/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/publisher/EventPublisher.java,v $
 * Created by:  Christopher R. Vincent
 * Created on:  3/22/2006
 * Revision:	$Id: EventPublisher.java 180 2007-07-31 14:24:13Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.combus.publisher;

import java.io.StringWriter;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.advisory.DestinationEvent;
import org.apache.activemq.advisory.DestinationListener;
import org.apache.activemq.advisory.DestinationSource;
import org.apache.activemq.broker.BrokerStoppedException;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.transport.TransportDisposedIOException;
import org.openanzo.combus.CombusDictionary;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.combus.MessageUtils;
import org.openanzo.combus.realtime.RealtimeUpdatePublisher;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.COMBUS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.ServicesDictionary;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Event Publisher publishes transaction update messages from the UpdateService onto the combus.
 * 
 * @author Christopher R. Vincent
 */
class EventPublisher implements IUpdateResultListener, ExceptionListener, EventPublisherMBean {
    /** Log factory for logging events */
    private static final Logger                                   log                = LoggerFactory.getLogger(EventPublisher.class);

    /** The default number of events to queue for publication before discarding old messages. */
    private static final int                                      QUEUE_SIZE_DEFAULT = 5000;

    /** JMS ConnectionFactory */
    private ActiveMQConnectionFactory                             factory            = null;

    /** JMS broker configuration. */
    private ActiveMQConnection                                    connection         = null;

    private DestinationSource                                     ds                 = null;

    /** JMS session */
    private Session                                               session            = null;

    /** Producer to send update messages */
    private MessageProducer                                       producer           = null;

    /** Producer to send update messages */
    private MessageProducer                                       topicProducer      = null;

    /** Max allowable size of queue */
    private int                                                   queueSize          = QUEUE_SIZE_DEFAULT;

    /** Queue of publisher messages */
    private final LinkedList<IUpdates>                            queue              = new LinkedList<IUpdates>();

    /** Thread that publisher runs */
    private PublisherThread                                       thread             = null;

    /** Map of ids and topics */
    private Hashtable<String, Destination>                        topics             = new Hashtable<String, Destination>();

    final Lock                                                    lock               = new ReentrantLock();

    final Condition                                               notEmpty           = lock.newCondition();

    private final WeakHashMap<String, SoftReference<Destination>> destinations       = new WeakHashMap<String, SoftReference<Destination>>();

    private final String                                          jmsUpdateQueueName;

    private final Dictionary<? extends Object, ? extends Object>  configProperties;

    private HashSet<String>                                       ngTopics           = new HashSet<String>();

    private RealtimeUpdatePublisher                               realtimePublisher;

    /**
     * Create a new EventPublisher
     */
    protected EventPublisher(Dictionary<? extends Object, ? extends Object> configProperties, RealtimeUpdatePublisher realtimePublisher) {
        this.jmsUpdateQueueName = CombusDictionary.getUpdatesQueue(configProperties, null);
        this.configProperties = configProperties;
        this.realtimePublisher = realtimePublisher;
    }

    protected void start(IJmsProvider jmsProvider) throws AnzoException {
        this.factory = (ActiveMQConnectionFactory) jmsProvider.createConnectionFactory(configProperties);
        this.factory.setUseAsyncSend(true);
        thread = new PublisherThread();
        thread.start();
    }

    protected void stop(boolean stopping) throws AnzoException {
        if (thread != null) {
            thread.interrupt();
        }
        lock.lock();
        try {
            queue.clear();
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
        topics.clear();
        disconnect(stopping);
    }

    public void reset() throws AnzoException {
        lock.lock();
        try {
            queue.clear();

            if (connection != null && session != null) {
                try {
                    TextMessage bytesMessage = session.createTextMessage();
                    bytesMessage.setStringProperty(SerializationConstants.operation, SerializationConstants.reset);
                    publishTransactionUpdateMessage(bytesMessage);
                } catch (JMSException jmsex) {
                    log.error(LogUtils.COMBUS_MARKER, "Error sending reset message", jmsex);
                    throw new AnzoException(ExceptionConstants.COMBUS.SEND_MESSAGE_FAILED, jmsex);
                }
            }

            for (SoftReference<Destination> ref : destinations.values()) {
                Destination dest = ref.get();
                if (dest != null) {
                    try {
                        connection.destroyDestination(((ActiveMQDestination) dest));
                    } catch (JMSException be) {
                        log.warn(LogUtils.COMBUS_MARKER, "Error destroying destinations", be);
                    }
                }
            }
            ngTopics.clear();
            Set<ActiveMQTopic> topics = ds.getTopics();
            for (ActiveMQTopic topic : topics) {
                if (topic.getPhysicalName().startsWith(Constants.NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {
                    ngTopics.add(topic.getPhysicalName());
                }
            }
        } finally {
            lock.unlock();
            destinations.clear();
        }
    }

    protected void connect() throws AnzoException {
        // Create broker connection.
        try {
            String user = ServicesDictionary.getUser(configProperties, null);
            String password = ServicesDictionary.getPassword(configProperties, null);
            connection = (ActiveMQConnection) factory.createConnection(user, password);
            ds = new DestinationSource(connection);
            ds.start();
            Set<ActiveMQTopic> topics = ds.getTopics();
            for (ActiveMQTopic topic : topics) {
                if (topic.getPhysicalName().startsWith(Constants.NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {
                    ngTopics.add(topic.getPhysicalName());
                }
            }
            ds.setDestinationListener(new DestinationListener() {

                public void onDestinationEvent(DestinationEvent event) {
                    if (event.getDestination().getPhysicalName().startsWith(Constants.NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {
                        if (event.isAddOperation()) {
                            ngTopics.add(event.getDestination().getPhysicalName());
                        } else if (event.isRemoveOperation()) {
                            ngTopics.remove(event.getDestination().getPhysicalName());
                        }
                    }
                }
            });
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue updateQueue = session.createQueue(jmsUpdateQueueName);
            if (updateQueue != null) {
                producer = session.createProducer(updateQueue);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            }
            topicProducer = session.createProducer(null);
            topicProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        } catch (JMSException e) {
            log.error(LogUtils.COMBUS_MARKER, "Error connecting combus update publisher", e);
            disconnect(true);
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_CONNECT_FAILED, e);
        }
    }

    /**
     * Disconnect the event publisher from the JMS server
     * 
     */
    private void disconnect(boolean stopping) {
        try {
            if (stopping) {
                try {
                    if (producer != null)
                        producer.close();
                } catch (JMSException e) {
                    if (stopping) {
                        log.error(LogUtils.COMBUS_MARKER, "Error closing combus update publisher producer", e);
                    }
                }
                try {
                    if (session != null)
                        session.close();
                } catch (JMSException e) {
                    if (stopping) {
                        log.error(LogUtils.COMBUS_MARKER, "Error closing combus update publisher session", e);
                    }
                }
                try {
                    if (ds != null) {
                        ds.stop();
                    }
                } catch (JMSException e) {
                    if (stopping) {
                        log.error(LogUtils.COMBUS_MARKER, "Error closing combus update publisher destination source", e);
                    }
                }
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (JMSException e) {
                if (stopping) {
                    log.error(LogUtils.COMBUS_MARKER, "Error closing combus update publisher connection", e);
                }
            }
        }
        ds = null;
        producer = null;
        session = null;
        connection = null;
        ngTopics.clear();
    }

    /**
     * Get the current size of the event publication queue.
     * 
     * @return Size of event publication queue
     */
    public int getMaxQueueSize() {
        return queueSize;
    }

    public void onException(JMSException exception) {
        if (exception.getCause() instanceof BrokerStoppedException || exception.getCause() instanceof TransportDisposedIOException) {
            disconnect(false);
        } else {
            log.error(LogUtils.COMBUS_MARKER, "Exception on the combus update publisher connection", exception);
            disconnect(true);
        }
    }

    /**
     * Publish the specified properties as a new event.
     * 
     * @param properties
     *            map of {@link java.lang.String}property name to one of the supported JMS property value types.
     * @param data
     *            data for message body
     */
    private void publish(String destination, Map<String, Object> properties, String data) {
        if (connection != null && session != null) {
            try {
                TextMessage bytesMessage = session.createTextMessage();
                bytesMessage.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
                setMessageProperties(bytesMessage, properties);
                if (data != null)
                    bytesMessage.setText(data);
                if (destination == null) {
                    publishTransactionUpdateMessage(bytesMessage);
                } else {
                    publishNamedGraphUpdateMessage(destination, bytesMessage);
                }
            } catch (JMSException e) {
                onException(e);
            }
        }
    }

    // Message should be discarded if EventPublisherException is thrown.
    private void publishTransactionUpdateMessage(TextMessage message) throws JMSException {
        lock.lock();
        try {
            if (log.isTraceEnabled()) {
                log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(message, "Publishing Message to " + producer.getDestination()));
            } else if (log.isDebugEnabled()) {
                log.debug(LogUtils.COMBUS_MARKER, "Publishing Message to " + producer.getDestination());
            }
            producer.send(message);
        } finally {
            lock.unlock();
        }
    }

    // Message should be discarded if EventPublisherException is thrown.
    private void publishNamedGraphUpdateMessage(String topic, TextMessage message) throws JMSException {
        lock.lock();
        try {
            if (log.isTraceEnabled()) {
                log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(message, "Publishing Message to " + topic));
            } else if (log.isDebugEnabled()) {
                log.debug(LogUtils.COMBUS_MARKER, "Publishing Message to " + topic);
            }
            SoftReference<Destination> ref = destinations.get(topic);
            Destination dest = (ref != null) ? ref.get() : null;
            if (dest == null) {
                dest = session.createTopic(topic);
                destinations.put(topic, new SoftReference<Destination>(dest));
            }
            topicProducer.send(dest, message);
        } finally {
            lock.unlock();
        }
    }

    private void setMessageProperties(Message message, Map<String, Object> properties) throws JMSException {
        // How can we do this more efficiently?
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String name = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                message.setStringProperty(name, (String) value);
            } else if (value instanceof Integer) {
                message.setIntProperty(name, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                message.setLongProperty(name, ((Long) value).longValue());
            } else if (value instanceof Float) {
                message.setFloatProperty(name, ((Float) value).floatValue());
            } else if (value instanceof Double) {
                message.setDoubleProperty(name, ((Double) value).doubleValue());
            } else if (value instanceof Short) {
                message.setShortProperty(name, ((Short) value).shortValue());
            } else if (value instanceof Byte) {
                message.setByteProperty(name, ((Byte) value).byteValue());
            } else if (value instanceof Boolean) {
                message.setBooleanProperty(name, ((Boolean) value).booleanValue());
            }
        }
    }

    /* Thread that reconnects to notification server and publishes any messages in the queue */
    protected class PublisherThread extends Thread {

        PublisherThread() {
            super("EventPublisherThread");
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    try {
                        while (queue.size() == 0)
                            notEmpty.await(5, TimeUnit.SECONDS);
                    } catch (InterruptedException ie) {
                        return;
                    } finally {
                        lock.unlock();
                    }
                    // Send message to broker, retry on failure.
                    boolean success = false;
                    IUpdates message = null;
                    int retries = 0;
                    while (!success) {
                        if (retries > 0) {
                            sleep(5000);
                        }
                        // Get latest message in case of overflow.
                        lock.lock();
                        try {
                            try {
                                message = queue.getFirst();
                            } catch (NoSuchElementException nsee) {
                                break;
                            }
                        } finally {
                            lock.unlock();
                        }
                        if (message != null) {
                            // Ensure connection.
                            try {
                                if (connection == null) {
                                    connect();
                                }
                            } catch (AnzoException e) {
                                log.error(LogUtils.COMBUS_MARKER, "Error connecting combus update publisher connection", e);
                                retries++;
                                continue;
                            }
                            // Attempt to publish.
                            processUpdateMessage(message);
                            success = true;
                        }
                    }
                    // Remove from front of queue, unless already gone due to overflow.
                    lock.lock();
                    try {
                        try {
                            if (message == queue.getFirst()) {
                                queue.removeFirst();
                            }
                        } catch (NoSuchElementException e) {
                            log.debug(LogUtils.COMBUS_MARKER, "Error removing message from queue", e);
                        }
                    } finally {
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public void updateComplete(IOperationContext context, IUpdates results) throws AnzoException {
        lock.lock();
        try {
            queue.addLast(results);
            if ((queueSize > 0) && (queue.size() > queueSize)) {
                queue.removeFirst();
            }
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    private void processUpdateMessage(IUpdates message) {
        try {
            //StringWriter output = new StringWriter();
            //CommonSerializationUtils.writeUpdates(true, message.updates, output, RDFFormat.JSON.getDefaultMIMEType());
            //publish(null, message.properties, output.toString());

            for (IUpdateTransaction transaction : message.getTransactions()) {
                if (transaction.getErrors().size() == 0) {
                    String operationId = message.getOperationId();
                    publishNamedGraphUpdates(transaction, operationId);
                    publishTransactionEvent(transaction, operationId);
                }
            }
        } catch (AnzoException ae) {
            log.error(LogUtils.COMBUS_MARKER, "Error processing update message", ae);
        }
    }

    private void publishNamedGraphUpdates(IUpdateTransaction transaction, String operationId) throws AnzoException {
        Map<String, Object> message = new HashMap<String, Object>();
        message.put(SerializationConstants.type, SerializationConstants.namedGraphUpdate);
        message.put(SerializationConstants.operation, SerializationConstants.namedGraphUpdate);
        message.put(SerializationConstants.transactionTimestamp, transaction.getTransactionTimestamp());
        if (transaction.getURI() != null)
            message.put(SerializationConstants.transactionURI, transaction.getURI().toString());
        if (transaction.getTransactionContext() != null) {
            StringWriter tc = new StringWriter();
            ReadWriteUtils.writeStatements(transaction.getTransactionContext(), tc, RDFFormat.JSON, null, false);
            message.put(SerializationConstants.transactionContext, tc.toString());
        }
        message.put(Constants.COMBUS.JMS_CORRELATION_ID, operationId);
        String ngRevs = CommonSerializationUtils.writeNamedGraphRevisions(transaction.getUpdatedNamedGraphRevisions());

        if (ngRevs != null) {
            message.put(SerializationConstants.namedGraphUpdates, ngRevs);
        }
        for (Map.Entry<URI, URI> key : transaction.getUpdatedNamedGraphs().entrySet()) {
            URI ngUri = key.getKey();
            URI UUID = key.getValue();
            INamedGraphUpdate update = transaction.getNamedGraphUpdate(ngUri);

            String topic = UriGenerator.generateEncapsulatedString(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX, UUID.toString());
            Map<String, Object> messageClone = new HashMap<String, Object>(message);
            messageClone.put(SerializationConstants.namedGraphUri, ngUri.toString());
            messageClone.put(SerializationConstants.namedGraphUUID, UUID.toString());
            if (update != null) {
                Collection<Statement> additions = update.getAdditions();
                if (additions != null) {
                    StringWriter adds = new StringWriter();
                    ReadWriteUtils.writeStatements(additions, adds, RDFFormat.JSON);
                    messageClone.put(SerializationConstants.additions, adds.toString());
                }
                Collection<Statement> removals = update.getRemovals();
                if (removals != null) {
                    StringWriter removes = new StringWriter();
                    ReadWriteUtils.writeStatements(removals, removes, RDFFormat.JSON);
                    messageClone.put(SerializationConstants.removals, removes.toString());
                }
                Collection<Statement> metaAdditions = update.getMetaAdditions();
                if (metaAdditions != null) {
                    StringWriter adds = new StringWriter();
                    ReadWriteUtils.writeStatements(metaAdditions, adds, RDFFormat.JSON);
                    messageClone.put(SerializationConstants.metaAdditions, adds.toString());
                }
                Collection<Statement> metaRemovals = update.getMetaRemovals();
                if (metaRemovals != null) {
                    StringWriter removes = new StringWriter();
                    ReadWriteUtils.writeStatements(metaRemovals, removes, RDFFormat.JSON);
                    messageClone.put(SerializationConstants.metaRemovals, removes.toString());
                }
                if (additions != null || removals != null || metaAdditions != null || metaRemovals != null) {
                    if (ngTopics.contains(topic)) {
                        publish(topic, messageClone, null);
                    }
                    Map<String, Object> messageClone2 = new HashMap<String, Object>(messageClone);
                    //messageClone2.remove(SerializationConstants.namedGraphUpdates);
                    //messageClone2.remove(SerializationConstants.transactionContext);
                    if (realtimePublisher == null) {
                        publish(null, messageClone2, null);
                    } else {
                        realtimePublisher.handleNamedgraphUpdateMessage(operationId, update, messageClone2);
                    }
                }
            }
        }

    }

    private void publishTransactionEvent(IUpdateTransaction transaction, String operationId) throws AnzoException {
        Map<String, Object> message = new HashMap<String, Object>();
        message.put(SerializationConstants.type, SerializationConstants.transactionComplete);
        message.put(SerializationConstants.operation, SerializationConstants.transactionComplete);
        message.put(SerializationConstants.transactionTimestamp, transaction.getTransactionTimestamp());
        String ngRevs = CommonSerializationUtils.writeNamedGraphRevisions(transaction.getUpdatedNamedGraphRevisions());
        if (ngRevs != null)
            message.put(SerializationConstants.namedGraphUpdates, ngRevs);
        if (transaction.getURI() != null)
            message.put(SerializationConstants.transactionURI, transaction.getURI().toString());
        if (transaction.getTransactionContext() != null) {
            StringWriter tc = new StringWriter();
            ReadWriteUtils.writeStatements(transaction.getTransactionContext(), tc, RDFFormat.JSON);
            message.put(SerializationConstants.transactionContext, tc.toString());
        }
        message.put(Constants.COMBUS.JMS_CORRELATION_ID, operationId);
        publish(COMBUS.TRANSACTIONS_TOPIC, message, null);
    }

    public void flushQueue() {
        lock.lock();
        try {
            queue.clear();
        } finally {
            lock.unlock();
        }
    }

    public int getQueueSize() {
        return queue.size();
    }

    public void setMaxQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

}
