/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/services/impl/JMSNotificationService.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/20/2006
 * Revision:	$Id: JMSNotificationService.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.combus;

import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;

import org.apache.activemq.broker.BrokerStoppedException;
import org.apache.activemq.transport.TransportDisposedIOException;
import org.apache.commons.collections15.BidiMap;
import org.apache.commons.collections15.MultiMap;
import org.apache.commons.collections15.bidimap.DualHashBidiMap;
import org.apache.commons.collections15.multimap.MultiHashMap;
import org.apache.commons.lang.StringUtils;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IIndexService;
import org.openanzo.datasource.IModelService;
import org.openanzo.datasource.IQueryService;
import org.openanzo.datasource.IReplicationService;
import org.openanzo.datasource.IResetService;
import org.openanzo.datasource.IUpdateService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.COMBUS;
import org.openanzo.rdf.Constants.OPTIONS;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.INotificationConnectionListener;
import org.openanzo.services.INotificationRegistrationService;
import org.openanzo.services.IOperationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of INotificationService that uses JMS to talk to a notification server. General design is client creates a temporary topic and connects to a
 * JMS ControlQueue and sends a login message that includes a TemporaryTopic for that user. The server authenticates the user, and registers the Temporary Topic
 * as a destination. When messages go through the JMS server, if the user is authorized to see the message, it is sent to the user's TemporaryTopic. Any message
 * selectors are applied to the TemporaryTopic, which filters the messages the user actually sees.
 * 
 * Class also handles the jms message received over the TemporaryTopic, and processes them.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public class CombusConnection {

    private final static Logger                                        log                    = LoggerFactory.getLogger(CombusConnection.class);

    /** JMS connection to notification/jms server */
    private Connection                                                 connection             = null;

    /** JMS session for control messages */
    private Session                                                    session                = null;

    /** JMS Message consumer for messages from server */
    private MessageConsumer                                            messageConsumer        = null;

    /** JMS Message producer to send messages to server */
    private MessageProducer                                            messageProducer        = null;

    /** JMS TempQueue used to receive message from server */
    private TemporaryQueue                                             tempQueue              = null;

    /** The JMS MessageListener for this connection */
    private JMSMessageListener                                         listener               = null;

    private final BidiMap<String, Destination>                         destinations           = new DualHashBidiMap<String, Destination>();

    /** Is connected to JMS server */
    protected boolean                                                  connected              = false;

    /** Is the service closed */
    protected boolean                                                  closed                 = false;

    /** Is the service in the process of closing */
    private boolean                                                    closing                = false;

    /** messageExecutorClosed close] */
    private boolean                                                    messageExecutorClosed  = true;

    /** Notification/jms username */
    private final String                                               userName;

    private final String                                               password;

    private final String                                               host;

    private final int                                                  port;

    private final boolean                                              useSsl;

    /** IJmsProvider that service uses to talk to notification/jms server */
    private final IJmsProvider                                         jmsProvider;

    /**
     * Thread that handles queue of messages to process on local client
     */
    protected Thread                                                   messageExecutor        = null;

    private final Lock                                                 lock                   = new ReentrantLock();

    private final Condition                                            newMessage             = lock.newCondition();

    private final Lock                                                 eventLock              = new ReentrantLock();

    private final Condition                                            newEventMessage        = eventLock.newCondition();

    /** Registered listeners for JMS connection events */
    private final CopyOnWriteArraySet<INotificationConnectionListener> connectionListeners    = new CopyOnWriteArraySet<INotificationConnectionListener>();

    /** Registered listeners for MessageListener events */
    private final CopyOnWriteArraySet<MessageListener>                 messageListeners       = new CopyOnWriteArraySet<MessageListener>();

    /** Map between a request correlationId and the message response */
    private final MultiMap<String, TextMessage>                        correlationIdToMessage = new MultiHashMap<String, TextMessage>();

    private final LinkedList<Message>                                  messageBuffer          = new LinkedList<Message>();

    private final Map<String, MessageConsumer>                         topicConsumer          = new Hashtable<String, MessageConsumer>();

    /**
     * Create a combus connection to the server
     * 
     * @param jmsProvider
     *            JMS provider for connections to jms server
     * @param userName
     *            user to connect
     * @param password
     *            password to connect
     * @param host
     *            hostname of server
     * @param port
     *            port of server
     * @param useSsl
     *            use ssl connection
     */
    public CombusConnection(IJmsProvider jmsProvider, String userName, String password, String host, int port, boolean useSsl) {
        this.jmsProvider = jmsProvider;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
        this.useSsl = useSsl;
    }

    /**
     * Stop connection
     * 
     * @param clean
     *            clean jsm disconnect
     * @throws AnzoException
     */
    public void stop(boolean clean) throws AnzoException {
        if (connected && !closed) {
            disconnect(clean);
        }
        if (messageExecutor != null)
            messageExecutor.interrupt();
    }

    /**
     * Connect to a JMS broker
     * 
     * @throws AnzoException
     */
    public void connect() throws AnzoException {

        if (connected) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_ALREADY_CONNECTED);
        }
        closed = false;
        // connect to notification
        try {
            performConnect();
        } catch (JMSException ne) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException ne2) {
                    if (log.isTraceEnabled())
                        log.trace(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_CLOSING_COMPONENT, "connection"), ne2);
                }
                connection = null;
            }
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_CONNECT_FAILED, ne, this.host + ":" + this.port);
        }
        if (!connected) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_CONNECT_TIMEOUT);
        }
    }

    private void performConnect() throws JMSException, AnzoException {
        if (connected || closing) {
            return;
        }
        if (jmsProvider == null) {
            throw new AnzoException(ExceptionConstants.COMBUS.NOTIFICATION_SERVICE_ERROR);
        }
        Properties propertiesNew = new Properties();
        CombusProperties.setHost(propertiesNew, host);
        CombusProperties.setPort(propertiesNew, port);
        CombusProperties.setUseSsl(propertiesNew, useSsl);
        ConnectionFactory connectionFactory = jmsProvider.createConnectionFactory(propertiesNew);
        if (connectionFactory != null) {
            if (userName != null && password != null) {
                connection = connectionFactory.createConnection(userName, password);
            } else {
                connection = connectionFactory.createConnection();
            }
            connection.setExceptionListener(new ExceptionListener() {

                public void onException(JMSException exception) {
                    if (!closed) { // if user has not requested disconnect
                        if (exception.getCause() instanceof BrokerStoppedException || exception.getCause() instanceof TransportDisposedIOException) {
                            closed = true;
                        } else {
                            try {
                                fireConnectionStateChange(INotificationConnectionListener.CONNECTIONFAILED);
                                performDisconnect(false);
                            } catch (AnzoException e) {
                                log.error(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.JMS_DISCONNECT_FAILED), e);
                            } finally {
                                connected = false;
                            }
                        }
                    }
                }
            });
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destinations.clear();
            destinations.put(INotificationRegistrationService.SERVICE_NAME, session.createQueue(COMBUS.NOTIFICATION_SERVICE_QUEUE));
            destinations.put(IModelService.SERVICE_NAME, session.createQueue(COMBUS.MODEL_SERVICE_QUEUE));
            destinations.put(IAuthorizationService.SERVICE_NAME, session.createQueue(COMBUS.AUTHORIZATION_SERVICE_QUEUE));
            destinations.put(IAuthenticationService.SERVICE_NAME, session.createQueue(COMBUS.AUTHENTICATION_SERVICE_QUEUE));
            destinations.put(IReplicationService.SERVICE_NAME, session.createQueue(COMBUS.REPLICATION_SERVICE_QUEUE));
            destinations.put(IResetService.SERVICE_NAME, session.createQueue(COMBUS.RESET_SERVICE_QUEUE));
            destinations.put(IUpdateService.SERVICE_NAME, session.createQueue(COMBUS.UPDATE_SERVICE_QUEUE));
            destinations.put(IQueryService.SERVICE_NAME, session.createQueue(COMBUS.QUERY_SERVICE_QUEUE));
            destinations.put(IIndexService.SERVICE_NAME, session.createQueue(COMBUS.INDEX_SERVICE_QUEUE));
            destinations.put(IExecutionService.SERVICE_NAME, session.createQueue(COMBUS.EXECUTION_SERVICE_QUEUE));
            tempQueue = session.createTemporaryQueue();
            messageProducer = session.createProducer(null);
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            messageConsumer = session.createConsumer(tempQueue);
            listener = new JMSMessageListener();
            messageConsumer.setMessageListener(listener);
            connected = true;
            fireConnectionStateChange(INotificationConnectionListener.CONNECTED);
        }
        return;

    }

    /**
     * Disconnect the JMS connection manager
     * 
     * @param clean
     *            true if jms disconnect should fully close
     * @throws AnzoException
     *             if the connection was already closed, or there was an exception performing disconnect.
     * 
     */
    public void disconnect(boolean clean) throws AnzoException {
        if (closed && clean) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED);
        }
        if (!closed) {
            closed = true;
            performDisconnect(clean);
        } else

        if (connection != null) {
            try {
                connection.close();
            } catch (AccessControlException ace) {
                //Catch invalid exception thrown in jdk1.5
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_CLOSING_COMPONENT, "connection"), ace);
                }
            } catch (JMSException jmsex) {
                log.debug(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_CLOSING_COMPONENT, "connection"), jmsex);
            } finally {
                connection = null;
            }
        }

    }

    protected void performDisconnect(boolean clean) throws AnzoException {
        AnzoException exception = null;
        if (closing || !isConnected()) {
            return;
        }
        closing = true;
        if (connected && clean) {
            try {
                messageListeners.clear();
                topicConsumer.clear();
                stopMessageExecutor();
                if (messageConsumer != null) {
                    try {
                        messageConsumer.close();
                    } catch (NullPointerException npe) {
                        //Catch exception due to defect within activemq's ActiveMQMessageConsumer.dispose() method
                        if (log.isTraceEnabled()) {
                            log.trace(LogUtils.COMBUS_MARKER, "NPE due to ActiveMQ dispose issue", npe);
                        }
                    }
                }
                if (tempQueue != null) {
                    tempQueue.delete();
                }

                if (messageProducer != null) {
                    messageProducer.close();
                }

                if (session != null) {
                    session.close();
                }

                connection.stop();
            } catch (JMSException jmsex) {
                log.debug(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_CLOSING_COMPONENT, "connection"), exception);
                // exception = new NotificationException(ExceptionConstants.NOTIFICATION.CODES.JMS_ERROR, ExceptionConstants.NOTIFICATION.JMS_DISCONNECT_FAILED, jmsex);
            } finally {
                messageProducer = null;
                tempQueue = null;
                messageConsumer = null;
            }

        }
        try {
            if (connection != null) {
                try {
                    connection.close();
                } catch (AccessControlException ace) {
                    //Catch invalid exception thrown in jdk1.5
                    if (log.isTraceEnabled()) {
                        log.trace(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_CLOSING_COMPONENT, "connection"), ace);
                    }
                }
            }
        } catch (JMSException jmsex) {
            exception = new AnzoException(ExceptionConstants.COMBUS.JMS_DISCONNECT_FAILED, jmsex);
        } finally {
            connection = null;
        }
        session = null;
        connected = false;
        if (clean) {
            fireConnectionStateChange(INotificationConnectionListener.DISCONNECTED);
        }
        closing = false;
        if (exception != null) {
            //throw exception;
            // we log this exception instead of throwing it. We don't want to raise
            // new exceptions trying to disconnect when we are already in a JMS error
            // situation
            log.warn(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.JMS_DISCONNECT_FAILED), exception);
        }
    }

    /**
     * Start the message executor
     * 
     * @throws JMSException
     */
    public void startMessageExecutor() throws JMSException {
        if (!messageExecutorClosed) {
            return;
        }
        messageExecutorClosed = false;
        messageExecutor = new Thread("MessageExecutor") {
            @Override
            public void run() {
                Message message = null;
                while (!interrupted() && !messageExecutorClosed && !closed) {
                    eventLock.lock();
                    try {
                        message = (!messageBuffer.isEmpty()) ? messageBuffer.removeFirst() : null;
                        if (message == null) {
                            try {
                                newEventMessage.await();
                            } catch (InterruptedException ie) {
                            }
                        }
                    } finally {
                        eventLock.unlock();
                    }
                    if (message != null) {
                        if (log.isTraceEnabled()) {
                            if (messageListeners.size() == 0) {
                                try {
                                    log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(message, "No message listeners.  Message getting dropped: "));
                                } catch (JMSException e) {
                                    log.trace(LogUtils.COMBUS_MARKER, "error printing jms message", e);
                                }
                            }
                        }
                        for (MessageListener listener : messageListeners) {
                            listener.onMessage(message);
                        }
                    }
                    message = null;
                }
            }
        };
        messageExecutor.setDaemon(true);
        messageExecutor.start();
    }

    /**
     * Stop the event message listener
     */
    public void stopMessageExecutor() {
        if (messageExecutor != null) {
            messageExecutor.interrupt();
        }
        messageExecutorClosed = true;
        eventLock.lock();
        try {
            messageBuffer.clear();
            newEventMessage.signalAll();
        } finally {
            eventLock.unlock();
        }
        messageExecutor = null;
    }

    /**
     * Determine if the service is connected
     * 
     * @return true if the service is connected.
     */
    public boolean isConnected() {
        return connected;
    }

    protected class JMSMessageListener implements MessageListener {
        public void onMessage(final Message message) {
            try {
                if (message.getJMSCorrelationID() == null) {
                    onEventMessage(message);
                    return;
                }
            } catch (JMSException jmsex) {
                notifyNotificationException(new AnzoException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, jmsex));
            }

            if (message != null && message instanceof TextMessage) {
                try {
                    if (log.isTraceEnabled()) {
                        log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(message, "Message Recieved: "));
                    }
                } catch (JMSException e) {
                }
                try {
                    String correlationId = message.getJMSCorrelationID();
                    lock.lock();
                    try {
                        correlationIdToMessage.put(correlationId, (TextMessage) message);
                        newMessage.signalAll();
                    } finally {
                        lock.unlock();
                    }
                } catch (JMSException jmsex) {
                    notifyNotificationException(new AnzoException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, jmsex));
                }
            }
        }

        private void onEventMessage(Message message) {
            if (log.isTraceEnabled()) {
                try {
                    log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(message, "Recieved Message"));
                } catch (JMSException e) {
                }
            }
            eventLock.lock();
            try {
                messageBuffer.add(message);
                newEventMessage.signalAll();
            } finally {
                eventLock.unlock();
            }
        }
    }

    /**
     * Publish message to a topic
     * 
     * @param topic
     *            topic on which to publish
     * @param message
     *            message to publish
     * @throws AnzoException
     */
    public void publishMessage(String topic, Message message) throws AnzoException {
        try {
            Destination destination = destinations.get(topic);
            if (destination == null) {
                destination = session.createTopic(topic);
                destinations.put(topic, destination);
            }
            if (log.isTraceEnabled()) {
                log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(message, "Sending Message: (destination=" + destination + ")"));
            }
            messageProducer.send(destination, message);
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.COULD_NOT_PUBLISH, jmsex);
        }
    }

    /**
     * Send a request to a destination and wait for a response
     * 
     * @param context
     *            context for this operational call
     * @param destinationName
     *            destination queue for this request
     * @param request
     *            request message
     * @param timeout
     *            timeout for waiting for a response
     * @return response message
     * @throws AnzoException
     *             if there was an exception sending request, or a timeout waiting for a response
     */
    public TextMessage requestResponse(IOperationContext context, String destinationName, Message request, long timeout) throws AnzoException {
        Destination destination = null;

        if (context.getAttribute(OPTIONS.DATASOURCE) != null) {
            URI datasourceUri = (URI) context.getAttribute(OPTIONS.DATASOURCE);
            Queue defaultDestination = (Queue) destinations.get(destinationName);
            if (datasourceUri.toString().equals("http://openanzo.org/datasource/systemDatasource")) {
                destination = defaultDestination;
            } else {
                String queueNamePrefix = UriGenerator.generateEncapsulatedString("", datasourceUri.toString()) + "/";
                try {
                    String[] parts = StringUtils.split(defaultDestination.getQueueName(), '/');
                    String queue = "services/" + queueNamePrefix + parts[1];
                    destination = destinations.get(queue);
                    if (destination == null) {
                        destination = session.createQueue(queue);
                        destinations.put(queue, destination);
                    }
                } catch (JMSException e) {
                    throw new AnzoException(ExceptionConstants.COMBUS.NO_SUCH_DESTINATION, destinationName);
                }
            }
        } else {
            destination = destinations.get(destinationName);
            if (destination == null) {
                throw new AnzoException(ExceptionConstants.COMBUS.NO_SUCH_DESTINATION, destinationName);
            }
        }

        if (context.getAttribute(COMBUS.TIMEOUT) != null) {
            timeout = (Long) context.getAttribute(COMBUS.TIMEOUT);
        }

        String correlationId = context.getOperationId();
        if (correlationId == null) {
            correlationId = UUID.randomUUID().toString();
        }

        try {
            request.setJMSCorrelationID(correlationId);
            request.setJMSReplyTo(tempQueue);
            request.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
            if (context.getOperationPrincipal() != null && !context.getOperationPrincipal().getName().equals(this.userName)) {
                request.setStringProperty(SerializationConstants.runAsUser, context.getOperationPrincipal().getName());
            }
            if (context.getAttribute(OPTIONS.PRIORITY) != null) {
                Integer priority = (Integer) context.getAttribute(OPTIONS.PRIORITY);
                request.setJMSPriority(priority);
                messageProducer.setPriority(priority);
            } else {
                messageProducer.setPriority(4);
            }
            if (context.getAttribute(OPTIONS.SKIPCACHE) != null) {
                request.setBooleanProperty(OPTIONS.SKIPCACHE, context.getAttribute(OPTIONS.SKIPCACHE, Boolean.class));
            }
            if (log.isTraceEnabled()) {
                log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(request, "Sending Request: (destination=" + destination + ")"));
            }
            messageProducer.send(destination, request);
        } catch (JMSException jmsex) {
            performDisconnect(true);
            throw new AnzoException(ExceptionConstants.COMBUS.COULD_NOT_PUBLISH, jmsex);
        }
        lock.lock();
        try {
            Collection<TextMessage> messageSet = correlationIdToMessage.remove(correlationId);
            long start = System.currentTimeMillis();
            while (messageSet == null) {
                if (timeout <= 0) {
                    try {
                        newMessage.await(2, TimeUnit.SECONDS);
                    } catch (InterruptedException ie) {
                        throw new AnzoException(ExceptionConstants.COMBUS.INTERRUPTED, correlationId);
                    }
                    if (closed || closing) {
                        throw new AnzoException(ExceptionConstants.COMBUS.INTERRUPTED, correlationId);
                    }
                    messageSet = correlationIdToMessage.remove(correlationId);
                } else {
                    try {
                        newMessage.await(timeout, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException ie) {
                        throw new AnzoException(ExceptionConstants.COMBUS.INTERRUPTED, correlationId);
                    }
                    if (closed || closing) {
                        throw new AnzoException(ExceptionConstants.COMBUS.INTERRUPTED, correlationId);
                    }
                    messageSet = correlationIdToMessage.remove(correlationId);
                    if (!connected) {
                        log.error(LogUtils.COMBUS_MARKER, "Request Response failed because connection was closed");
                        throw new AnzoException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED, correlationId);
                    }
                    if (messageSet == null && ((timeout > 0) && ((System.currentTimeMillis() - start) > timeout))) {
                        throw new AnzoException(ExceptionConstants.COMBUS.NO_SERVER_RESPONSE, correlationId);
                    }
                }
            }
            try {
                TextMessage message = messageSet.iterator().next();
                if (log.isTraceEnabled()) {
                    log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(message, "Received Response:"));
                }

                if (message.getBooleanProperty(SerializationConstants.operationFailed)) {
                    long errorCodes = message.propertyExists(SerializationConstants.errorTags) ? message.getLongProperty(SerializationConstants.errorCode) : ExceptionConstants.COMBUS.JMS_SERVICE_EXCEPTION;

                    // if available, use enumerated args, since these can be reconstruct an AnzoException correctly.
                    List<String> args = new ArrayList<String>();
                    for (int i = 0; true; i++) {
                        String errorArg = message.getStringProperty(SerializationConstants.errorMessageArg + i);
                        if (errorArg == null) {
                            break;
                        }
                        args.add(errorArg);
                    }

                    // NOTE: This doesn't really make any sense, but it was here before and it's better to be too verbose than not verbose enough
                    // when it comes to error messages, so it stays.  For now at least. -jpbetz
                    if (args.isEmpty()) {
                        args.add(message.getText());
                    }
                    throw new AnzoException(errorCodes, args.toArray(new String[0]));
                }
                /*Object prp = context.getAttribute("populateResponseProperties");
                if (prp != null && ((Boolean) prp)) {
                    HashMap<String, Object> props = new HashMap<String, Object>();
                    Enumeration<String> keys = message.getPropertyNames();
                    while (keys.hasMoreElements()) {
                        String key = keys.nextElement();
                        props.put(key, message.getObjectProperty(key));
                    }
                    context.setAttribute("responseProperties", props);
                }*/
                return message;
            } catch (JMSException jmsex) {
                log.debug(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "request response"), jmsex);
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Send a request to a destination and wait for a response
     * 
     * @param context
     *            context for this operational call
     * @param destinationName
     *            destination queue for this request
     * @param request
     *            request message
     * @param timeout
     *            timeout for waiting for a response
     * @param messageHandler
     *            the handler of multiple messages
     * @throws AnzoException
     *             if there was an exception sending request, or a timeout waiting for a response
     */
    public void requestMultipleResponse(IOperationContext context, String destinationName, Message request, long timeout, IMessageHandler messageHandler) throws AnzoException {
        Destination destination = null;
        if (context.getAttribute(OPTIONS.DATASOURCE) != null) {
            URI datasourceUri = (URI) context.getAttribute(OPTIONS.DATASOURCE);
            Queue defaultDestination = (Queue) destinations.get(destinationName);
            if (datasourceUri.toString().equals("http://openanzo.org/datasource/systemDatasource")) {
                destination = defaultDestination;
            } else {
                String queueNamePrefix = UriGenerator.generateEncapsulatedString("", datasourceUri.toString()) + "/";
                try {
                    String[] parts = StringUtils.split(defaultDestination.getQueueName(), '/');
                    String queue = "services/" + queueNamePrefix + parts[1];
                    destination = destinations.get(queue);
                    if (destination == null) {
                        destination = session.createQueue(queue);
                        destinations.put(queue, destination);
                    }
                } catch (JMSException e) {
                    throw new AnzoException(ExceptionConstants.COMBUS.NO_SUCH_DESTINATION, destinationName);
                }
            }
        } else {
            destination = destinations.get(destinationName);
            if (destination == null) {
                throw new AnzoException(ExceptionConstants.COMBUS.NO_SUCH_DESTINATION, destinationName);
            }
        }
        String correlationId = context.getOperationId();
        if (correlationId == null) {
            correlationId = UUID.randomUUID().toString();
        }

        try {
            request.setJMSCorrelationID(correlationId);
            request.setJMSReplyTo(tempQueue);
            request.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
            if (context.getOperationPrincipal() != null && !context.getOperationPrincipal().getName().equals(this.userName)) {
                request.setStringProperty(SerializationConstants.runAsUser, context.getOperationPrincipal().getName());
            }
            if (context.getAttribute(OPTIONS.PRIORITY) != null) {
                Integer priority = (Integer) context.getAttribute(OPTIONS.PRIORITY);
                request.setJMSPriority(priority);
                messageProducer.setPriority(priority);
            } else {
                messageProducer.setPriority(4);
            }
            if (context.getAttribute(OPTIONS.SKIPCACHE) != null) {
                request.setBooleanProperty(OPTIONS.SKIPCACHE, context.getAttribute(OPTIONS.SKIPCACHE, Boolean.class));
            }
            if (context.getAttribute(OPTIONS.INCLUDEMETADATAGRAPHS) != null) {
                request.setBooleanProperty(OPTIONS.INCLUDEMETADATAGRAPHS, context.getAttribute(OPTIONS.INCLUDEMETADATAGRAPHS, Boolean.class));
            }
            if (log.isTraceEnabled()) {
                log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(request, "Sending Request: (destination=" + destination + ")"));
            }
            messageProducer.send(destination, request);
        } catch (JMSException jmsex) {
            performDisconnect(true);
            throw new AnzoException(ExceptionConstants.COMBUS.COULD_NOT_PUBLISH, jmsex);
        }
        lock.lock();
        try {
            long start = System.currentTimeMillis();
            boolean done = false;
            int seq = 0;
            while (!done) {
                Collection<TextMessage> messageSet = correlationIdToMessage.remove(correlationId);
                while (messageSet == null) {
                    if (timeout <= 0) {
                        try {
                            newMessage.await(2, TimeUnit.SECONDS);
                        } catch (InterruptedException ie) {
                            throw new AnzoException(ExceptionConstants.COMBUS.INTERRUPTED, correlationId);
                        }
                        if (closed || closing) {
                            throw new AnzoException(ExceptionConstants.COMBUS.INTERRUPTED, correlationId);
                        }
                        messageSet = correlationIdToMessage.remove(correlationId);
                    } else {
                        try {
                            newMessage.await(timeout, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException ie) {
                            throw new AnzoException(ExceptionConstants.COMBUS.INTERRUPTED, correlationId);
                        }
                        if (closed || closing) {
                            throw new AnzoException(ExceptionConstants.COMBUS.INTERRUPTED, correlationId);
                        }
                        messageSet = correlationIdToMessage.remove(correlationId);
                        if (!connected) {
                            log.error(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "connection closed"));
                            throw new AnzoException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED, correlationId);
                        }
                        if (messageSet == null && ((timeout > -1) && ((System.currentTimeMillis() - start) > timeout))) {
                            throw new AnzoException(ExceptionConstants.COMBUS.NO_SERVER_RESPONSE, correlationId);
                        }
                    }

                }
                try {
                    for (TextMessage message : messageSet) {
                        if (log.isTraceEnabled()) {
                            log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(message, "Recieved Response:"));
                        }
                        if (message.propertyExists("done")) {
                            done = message.getBooleanProperty("done");
                        } else {
                            done = true;
                        }
                        if (message.propertyExists("sequence")) {
                            int sequence = message.getIntProperty("sequence");
                            if (sequence != seq) {
                                throw new AnzoException(ExceptionConstants.COMBUS.NO_SERVER_RESPONSE, correlationId);
                            } else {
                                seq++;
                            }
                        }

                        int totalSize = 0;
                        if (message.propertyExists(SerializationConstants.totalSolutions)) {
                            totalSize = message.getIntProperty(SerializationConstants.totalSolutions);
                        }
                        if (message.getBooleanProperty(SerializationConstants.operationFailed)) {
                            long errorCodes = message.propertyExists(SerializationConstants.errorTags) ? message.getLongProperty(SerializationConstants.errorCode) : ExceptionConstants.COMBUS.JMS_SERVICE_EXCEPTION;

                            // if available, use enumerated args, since these can be reconstruct an AnzoException correctly.
                            List<String> args = new ArrayList<String>();
                            for (int i = 0; true; i++) {
                                String errorArg = message.getStringProperty(SerializationConstants.errorMessageArg + i);
                                if (errorArg == null) {
                                    break;
                                }
                                args.add(errorArg);
                            }

                            // NOTE: This doesn't really make any sense, but it was here before and it's better to be too verbose than not verbose enough
                            // when it comes to error messages, so it stays.  For now at least. -jpbetz
                            if (args.isEmpty()) {
                                args.add(message.getText());
                            }
                            throw new AnzoException(errorCodes, args.toArray(new String[0]));
                        } else {
                            messageHandler.handleMessage(message, seq, done, totalSize);
                        }
                    }
                } catch (JMSException jmsex) {
                    log.debug(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "request multiple response"), jmsex);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Create a new JMS text message used to sending requests
     * 
     * @return a new JMS text message used to sending requests
     * @throws AnzoException
     *             if no connection to the JMS exists or there was an exception creating the message
     */
    public TextMessage createMessage() throws AnzoException {
        if (session == null) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED);
        }
        try {
            return session.createTextMessage();
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_DISCONNECT_FAILED, jmsex);
        }
    }

    protected void notifyNotificationException(AnzoException exception) {
        for (INotificationConnectionListener listener : connectionListeners) {
            listener.notificationException(exception);
        }
    }

    /**
     * Register an IJmsConnectionListener with this manager
     * 
     * @param listener
     *            listener to register with manager
     */
    public void registerConnectionListener(INotificationConnectionListener listener) {
        connectionListeners.add(listener);
    }

    /**
     * Unregister an IJmsConnectionListener with this manager
     * 
     * @param listener
     *            listener to unregister from manager
     */
    public void unregisterConnectionListener(INotificationConnectionListener listener) {
        connectionListeners.remove(listener);
    }

    /**
     * Register a MessageListener with this manager for messages that don't have correlation ids
     * 
     * @param listener
     *            listener to register with manager
     */
    public void registerMessageListener(MessageListener listener) {
        messageListeners.add(listener);
    }

    /**
     * Unregister a MessageListener with this manager for messages that don't have correlation ids
     * 
     * @param listener
     *            listener to unregister from manager
     */
    public void unregisterMessageListener(MessageListener listener) {
        messageListeners.remove(listener);
    }

    /**
     * Register a topic listener
     * 
     * @param topic
     *            topic to listen
     * @param topicListener
     *            listener for topic
     * @throws AnzoException
     */
    public void registerTopicListener(String topic, MessageListener topicListener) throws AnzoException {
        if (!connected) {
            connect();
        }
        if (connected) {
            synchronized (topicConsumer) {
                if (!topicConsumer.containsKey(topic)) {
                    try {
                        Destination destination = session.createTopic(topic);
                        MessageConsumer consumer = session.createConsumer(destination);
                        consumer.setMessageListener(topicListener);
                        topicConsumer.put(topic, consumer);
                    } catch (JMSException jmsex) {
                        log.debug(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "register topic listener"), jmsex);
                        throw new AnzoException(ExceptionConstants.COMBUS.NOT_AUTHORIZED_FOR_TOPIC, jmsex, userName, topic);
                    }
                }
            }
        }
    }

    /**
     * Unregister topic
     * 
     * @param topic
     *            topic to unregister
     * @throws AnzoException
     */
    public void unregisterTopicListener(String topic) throws AnzoException {
        if (connected) {
            synchronized (topicConsumer) {
                MessageConsumer consumer = topicConsumer.remove(topic);
                if (consumer != null) {
                    try {
                        try {
                            consumer.close();
                        } catch (NullPointerException npe) {
                            //Catch exception due to defect within activemq's ActiveMQMessageConsumer.dispose() method
                            if (log.isTraceEnabled()) {
                                log.trace(LogUtils.COMBUS_MARKER, "NPE due to activemq dispose issue", npe);
                            }
                        }
                    } catch (JMSException jmsex) {
                        log.debug(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "unregister topic"), jmsex);
                        throw new AnzoException(ExceptionConstants.COMBUS.NOT_AUTHORIZED_FOR_TOPIC, jmsex, userName, topic);
                    }
                }
            }
        }
    }

    private void fireConnectionStateChange(int state) {
        for (INotificationConnectionListener listener : connectionListeners) {
            listener.connectionStateChanged(state);
        }
    }

    /**
     * Message handler for topics
     * 
     */
    public interface IMessageHandler {
        /**
         * Handle a message from a topic
         * 
         * @param message
         *            Received message
         * @param seq
         *            sequence number
         * @param done
         *            all all messages for this sequence received
         * @param totalSize
         *            total number of messages
         * @throws AnzoException
         */
        public void handleMessage(TextMessage message, int seq, boolean done, int totalSize) throws AnzoException;

    }
}
