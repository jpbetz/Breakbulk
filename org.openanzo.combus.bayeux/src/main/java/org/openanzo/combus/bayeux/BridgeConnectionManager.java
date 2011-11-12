/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.combus.bayeux;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
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
import javax.jms.Session;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.broker.BrokerStoppedException;
import org.apache.activemq.transport.TransportDisposedIOException;
import org.apache.commons.lang.time.DateUtils;
import org.openanzo.analysis.Profiler;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IDatasource;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.COMBUS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.INotificationRegistrationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.Privilege;
import org.openanzo.services.impl.ConfiguredCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * This class contains the state kept by the BayeuxJMSBridge for the various connections made by clients. Its main purpose is to group the state essentially in
 * a monitor for concurrency synchronization. It exposes basic operations to manage connections such as adding connections, sending messages intended for
 * particular clients, etc.
 * 
 * The implementation is careful about how it locks while working with JMS to avoid deadlocks such as the one described at
 * http://www.openanzo.org/projects/openanzo/ticket/286
 * 
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
class BridgeConnectionManager implements BayeuxJMSConstants {

    private static final Logger                   log                           = LoggerFactory.getLogger("org.openanzo.combus.bayeux.BayeuxJmsBridge");

    private static final Profiler                 profiler                      = new Profiler();

    private Connection                            conn                          = null;

    private Session                               session                       = null;

    private MessageProducer                       mp                            = null;

    private final Map<String, Destination>        destinations                  = new HashMap<String, Destination>();

    /**
     * This lock protects read and write access to the client and graph subscription state. Specifically, do not access tempDestinationToClientState,
     * clientIdToClientState, graphSubscriptions, or topicsToDelete without having this lock. WARNING: Do not perform any JMS calls while holding this lock due
     * to possible deadlocks. This class's methods could be called from within JMS code. See http://www.openanzo.org/projects/openanzo/ticket/286 for a
     * description one such deadlock situation.
     */
    private final ReentrantLock                   mapLock                       = new ReentrantLock();

    /**
     * Map from JMS temporary topic for the ClientState for the client listening on that temporary topic.
     */
    private final Map<String, ClientState>        tempDestinationToClientState  = new HashMap<String, ClientState>();

    /**
     * Map from Bayeux clientId to the ClientState. Do not access without first acquiring mapLock.
     */
    private final Map<String, ClientState>        clientIdToClientState         = new HashMap<String, ClientState>();

    /**
     * Map from a topic to the information about the bayeux clients expecting messages on that topic. Do not access without first acquiring mapLock.
     */
    private final Map<String, TopicSubscription>  topicSubscriptions            = new HashMap<String, TopicSubscription>();

    /**
     * Map from correlationId to a temporary topic ready for deletion, its consumer, and the time (in milliseconds from the epoch) at which the topic was set
     * for deletion. This is used to keep track of the topics waiting for a response to an unregisterUser (NotificationRegistrationService) request. Once we
     * receive the response, we can finally delete the temporary topic. We also delete the topic after a given timeout if we haven't received the response after
     * a while.
     */
    private final Map<String, ClientStateToClose> topicsToDelete                = new HashMap<String, ClientStateToClose>();

    private Timer                                 topicDeletionTimeoutTimer     = new Timer("BridgeConnectionManager Topic Deletion Timeout Thread", true);

    private static final long                     TOPIC_DELETE_RESPONSE_TIMEOUT = 4 * DateUtils.MILLIS_PER_MINUTE;

    //private final GraphUUIDCachedResolver        graphUuidResolver;

    private final IDatasource                     datasource;

    private final ConfiguredCredentials           credentials;

    private boolean                               closed                        = false;

    private class TopicDeletionTimerTask extends TimerTask {
        @Override
        public void run() {
            List<ClientStateToClose> timedoutTopics = null;
            mapLock.lock();
            try {
                if (topicsToDelete != null) {
                    long currentTime = System.currentTimeMillis();
                    List<String> timedoutKeys = null;
                    for (Map.Entry<String, ClientStateToClose> topicToDeleteEntry : topicsToDelete.entrySet()) {
                        ClientStateToClose topicToDeleteInfo = topicToDeleteEntry.getValue();
                        if (topicToDeleteInfo != null) {
                            if (topicToDeleteInfo.getDeletionRequestTime() + TOPIC_DELETE_RESPONSE_TIMEOUT <= currentTime) {
                                if (timedoutTopics == null) {
                                    timedoutTopics = new ArrayList<ClientStateToClose>();
                                }
                                timedoutTopics.add(topicToDeleteInfo); // add it to the list of topics to delete. We'll delete them all after we've released the mapLock to avoid deadlocks.

                                if (timedoutKeys == null) {
                                    timedoutKeys = new ArrayList<String>();
                                }
                                timedoutKeys.add(topicToDeleteEntry.getKey()); // We'll remove these from the map after iteration is done to avoid ConcurrentModificationExceptions
                            }
                        } else {
                            // If there is a null entry, it's useless, mark it for removal
                            if (timedoutKeys == null) {
                                timedoutKeys = new ArrayList<String>();
                            }
                            timedoutKeys.add(topicToDeleteEntry.getKey()); // We'll remove these from the map after iteration is done to avoid ConcurrentModificationExceptions
                        }
                    }
                    if (timedoutKeys != null) {
                        for (String keyToRemove : timedoutKeys) {
                            topicsToDelete.remove(keyToRemove);
                        }
                    }
                }
            } finally {
                mapLock.unlock();
            }
            if (timedoutTopics != null) {
                for (ClientStateToClose topicToRemove : timedoutTopics) {
                    log.debug(LogUtils.COMBUS_MARKER, "Timed out waiting for unregister subscriber response. Removing topic for {}/{}", topicToRemove.username, topicToRemove.clientId);
                    topicToRemove.close();
                }
            }
        }
    }

    protected BridgeConnectionManager(IDatasource datasource, ICacheProvider cacheProvider, ConfiguredCredentials credentials) {
        this.datasource = datasource;
        this.credentials = credentials;
        //  this.graphUuidResolver = new GraphUUIDCachedResolver(cacheProvider);

        topicDeletionTimeoutTimer.scheduleAtFixedRate(new TopicDeletionTimerTask(), 500, TOPIC_DELETE_RESPONSE_TIMEOUT / 2);
    }

    /**
     * Creates a single JMS connection and session for use by the BayeuxJMSBridge. It connects to the combus using a configured sysadmin account.
     * 
     * @param factory
     *            this will be used to create the JMS connection and session.
     * @param properties
     *            must contain the username and password
     * @throws JMSException
     */
    protected void initialize(ConnectionFactory factory, Properties properties) throws AnzoException {
        try {
            conn = factory.createConnection(credentials.getUserName(), credentials.getPassword());
            conn.setExceptionListener(new ExceptionListener() {
                public void onException(JMSException exception) {
                    if (!closed) { // if user has not requested disconnect
                        if (exception.getCause() instanceof BrokerStoppedException || exception.getCause() instanceof TransportDisposedIOException) {
                            closed = true;
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (JMSException e) {
                                    log.debug(LogUtils.COMBUS_MARKER, "Error closing JMS connection", e);
                                }
                            }
                        } else {
                            log.error(LogUtils.COMBUS_MARKER, "Exception over Bayeux JMS connection", exception);
                        }
                    }
                }
            });
            conn.start();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            mp = session.createProducer(null);
            mp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // setup all the destination queues
            destinations.put(COMBUS.NOTIFICATION_SERVICE_QUEUE, session.createQueue(COMBUS.NOTIFICATION_SERVICE_QUEUE));
            destinations.put(COMBUS.MODEL_SERVICE_QUEUE, session.createQueue(COMBUS.MODEL_SERVICE_QUEUE));
            destinations.put(COMBUS.UPDATE_SERVICE_QUEUE, session.createQueue(COMBUS.UPDATE_SERVICE_QUEUE));
            destinations.put(COMBUS.AUTHENTICATION_SERVICE_QUEUE, session.createQueue(COMBUS.AUTHENTICATION_SERVICE_QUEUE));
            destinations.put(COMBUS.REPLICATION_SERVICE_QUEUE, session.createQueue(COMBUS.REPLICATION_SERVICE_QUEUE));
            destinations.put(COMBUS.QUERY_SERVICE_QUEUE, session.createQueue(COMBUS.QUERY_SERVICE_QUEUE));
            destinations.put(COMBUS.RESET_SERVICE_QUEUE, session.createQueue(COMBUS.RESET_SERVICE_QUEUE));
            destinations.put(COMBUS.EXECUTION_SERVICE_QUEUE, session.createQueue(COMBUS.EXECUTION_SERVICE_QUEUE));
            destinations.put(COMBUS.AUTHORIZATION_SERVICE_QUEUE, session.createQueue(COMBUS.AUTHORIZATION_SERVICE_QUEUE));
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_CONNECT_FAILED, jmsex);
        }
    }

    /**
     * Sets up state for connecting a single Bayeux client to the BayeuxJMSBridge.
     * 
     * @param clientId
     *            the Bayeux client id.
     * @return true if client was connected. false if there was already a connection for the client.
     */
    protected boolean connectClient(String clientId, MessageListener listener, AnzoPrincipal principal) throws JMSException {
        // checks if connection already exists, create topic and client state, add to maps.

        boolean ret = false;

        boolean clientAlreadyConnected = false;
        mapLock.lock();
        try {
            clientAlreadyConnected = clientIdToClientState.containsKey(clientId);
        } finally {
            mapLock.unlock();
        }

        if (!clientAlreadyConnected) {
            // We don't have a temporary topic for this client yet so we'll create one.
            // We make sure to do this while NOT holding the mapLock to avoid deadlocks
            // (like http://www.openanzo.org/projects/openanzo/ticket/286). This
            // means that it's possible, in rare cases, that we could create a temp topic which we'll
            // have to just throw out immediately but there's not much harm in that.
            TemporaryTopic topic = session.createTemporaryTopic();
            String tempDestinationId = topic.getTopicName();
            MessageConsumer consumer = session.createConsumer(topic);
            consumer.setMessageListener(listener);

            boolean destroyNewJMSState = false;
            mapLock.lock();
            try {
                if (clientIdToClientState.containsKey(clientId)) {
                    // Some other thread seems to have connected this client while we were busy creating
                    // JMS topics, etc. That's okay, we'll just close the topics we created since they aren't needed anymore.
                    // But we don't want to destroy them while holding the mapLock, so we'll just mark a boolean so that they
                    // are deleted after releasing the lock.
                    destroyNewJMSState = true;
                } else {
                    ClientState state = new ClientState(principal, topic, clientId, consumer);
                    tempDestinationToClientState.put(tempDestinationId, state);
                    clientIdToClientState.put(clientId, state);
                    ret = true;
                }
            } finally {
                mapLock.unlock();
                if (destroyNewJMSState) {
                    consumer.close();
                    topic.delete();
                }
            }
        }

        return ret;
    }

    protected boolean isTopicSubscribed(String topic) {
        return this.topicSubscriptions.containsKey(topic);
    }

    /**
     * Sets up a subscription of the given Bayeux client to the JMS topic.
     * 
     * @param topic
     * @param clientId
     * @return true if a subscription was added. false if there was already a subscription.
     * @throws AnzoException
     *             if the user does not have access to the topic
     * @throws JMSException
     */
    protected boolean topicSubscribe(String topic, String clientId, AnzoPrincipal principal, MessageListener listener, IOperationContext opContext) throws JMSException, AnzoException {
        // check if subscription already exists, update maps and client state
        boolean ret = false;

        boolean subscriptionAlreadyExists = false;
        boolean consumerAlreadyExists = false;
        mapLock.lock();
        try {
            TopicSubscription topicSubscription = topicSubscriptions.get(topic);
            consumerAlreadyExists = topicSubscription != null;
            subscriptionAlreadyExists = topicSubscription != null && topicSubscription.subscribedClients.containsKey(clientId);

            if (!subscriptionAlreadyExists) {

                // If we're going to be adding a subscription, check the access control first.
                if (!userHasTopicAccess(topic, principal, opContext)) {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NO_READ_ERROR, topic, opContext.getOperationPrincipal().getUserURI().toString());
                }

                if (consumerAlreadyExists) {
                    // If there is already a JMS consumer for the topic, then we can finish things here with some
                    // simple manipulation of the relevant maps.
                    addTopicSubscription(topic, clientId, topicSubscription);
                    ret = true;
                    subscriptionAlreadyExists = true;
                }
            }
        } finally {
            mapLock.unlock();
        }

        if (!subscriptionAlreadyExists) {
            // Handle adding the subscription when the JMS topic consumer doesn't exist.
            // We make sure to create the consumer while NOT holding mapLock to avoid deadlocks
            // (like http://www.openanzo.org/projects/openanzo/ticket/286). This
            // means that it's possible, in rare cases, that we could create a duplicate consumer
            // which we'll have to just throw out immediately but there's not much harm in that.
            assert !consumerAlreadyExists;
            Destination destination = session.createTopic(topic);
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(listener);

            boolean destroyNewJMSState = false;
            mapLock.lock();
            try {
                TopicSubscription topicSubscription = topicSubscriptions.get(topic);
                if (topicSubscription == null) {
                    topicSubscription = new TopicSubscription(consumer);
                    topicSubscriptions.put(topic, topicSubscription);
                } else {
                    // Some other thread seems to have created a consumer for this graph topic while we were busy creating
                    // JMS topics, etc. That's okay, we'll just close the consumer we created since they aren't needed now.
                    // But we don't want to destroy them while holding the mapLock, so we'll just mark a boolean so that they
                    // are deleted after releasing the lock.
                    destroyNewJMSState = true;
                }

                if (!topicSubscription.subscribedClients.containsKey(clientId)) {
                    // NOTE: Access control was already verified earlier in the method.
                    addTopicSubscription(topic, clientId, topicSubscription);
                    ret = true;
                }
            } finally {
                mapLock.unlock();
                if (destroyNewJMSState) {
                    consumer.close();
                }
            }
        }

        return ret;
    }

    /**
     * Unsubscribe the given client from the given topic.
     * 
     * @param topic
     * @param clientId
     */
    protected void topicUnsubscribe(String topic, String clientId) {
        MessageConsumer consumer = null;
        mapLock.lock();
        try {
            consumer = unsubscribeTopic(topic, clientId);
            ClientState state = clientIdToClientState.get(clientId);
            if (state != null) {
                state.topicSubscriptions.remove(topic);
            } else {
                log.warn(LogUtils.COMBUS_MARKER, "topicUnsubscribe - ClientState is null");
            }
        } finally {
            mapLock.unlock();
        }
        if (consumer != null) {
            closeMessageConsumer(consumer); // Close the consumer while not holding mapLock
        }
        log.debug(LogUtils.COMBUS_MARKER, "Unsubscribed client {} from topic {}", clientId, topic);
    }

    /**
     * Send a JMS message on behalf of the given client to a specific destination. The destination is a string that names an abstract queue such as that in
     * Constants.NOTIFICATION_SERVICE_QUEUE, etc.
     * 
     * @param clientId
     * @param destination
     * @param messageProperties
     * @param msgBody
     * @return returns whether or not this message was published to a topic
     * @throws JMSException
     * @throws AnzoException
     */
    protected boolean sendClientMessage(String clientId, AnzoPrincipal principal, String destination, Map<?, ?> messageProperties, String msgBody, IOperationContext opContext) throws JMSException, AnzoException {
        //long destinationProfiler = profiler.start("Resolving destination.");
        Destination dest = destinations.get(destination);
        //profiler.stop(destinationProfiler);
        if (dest == null && destination.startsWith("services/")) {
            dest = session.createQueue(destination);
            destinations.put(destination, dest);
        }
        if (dest == null) { // we probably have a statement channel
            //long nullDestProfiler = profiler.start("Sending client message with null destination.");
            if (destination == null || !destination.startsWith(NAMESPACES.STREAM_TOPIC_PREFIX)) {
                //profiler.stop(nullDestProfiler);
                throw new AnzoException(ExceptionConstants.COMBUS.INVALID_TOPIC, destination);
            }
            // first we have to get the named graph uri out of the statement channel topic.
            String uri = UriGenerator.stripEncapsulatedString(NAMESPACES.STREAM_TOPIC_PREFIX, destination);
            URI graphUri = Constants.valueFactory.createURI(uri);
            if (!userHasGraphAddAccess(graphUri, principal, opContext)) {
                //profiler.stop(nullDestProfiler);
                throw new AnzoException(ExceptionConstants.COMBUS.NOT_AUTHORIZED_FOR_TOPIC, opContext.getOperationPrincipal().getUserURI().toString(), destination);
            }
            Topic topic = session.createTopic(destination);

            TextMessage tmsg = session.createTextMessage();
            for (Map.Entry<?, ?> prop : messageProperties.entrySet()) {
                tmsg.setStringProperty(prop.getKey().toString(), prop.getValue().toString());
            }
            tmsg.setText(msgBody);
            mp.send(topic, tmsg);
            //profiler.stop(nullDestProfiler);
            return true;
        } else {
            TemporaryTopic tempTopicForReply;
            //long = clientStateProfiler = profiler.start("Obtaining Bayeux client state.");
            mapLock.lock();
            try {
                ClientState state = clientIdToClientState.get(clientId);
                if (state == null) {
                    throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
                }
                tempTopicForReply = state.topic;
            } finally {
                mapLock.unlock();
                //profiler.stop(clientStateProfiler);
            }

            //long prepareJmsProfiler = profiler.start("Preparing JMS Message.");
            TextMessage tmsg = session.createTextMessage();
            int priority = 4;
            for (Map.Entry<?, ?> prop : messageProperties.entrySet()) {
                if (JMS_MSG_PROPERTY_CORRELATION_ID.equals(prop.getKey())) {
                    tmsg.setJMSCorrelationID(prop.getValue().toString());
                }
                if (JMS_MSG_PROPERTY_PRIORITY.equals(prop.getKey())) {
                    priority = Integer.parseInt(prop.getValue().toString());
                } else {
                    tmsg.setStringProperty(prop.getKey().toString(), prop.getValue().toString());
                }
            }
            tmsg.setJMSPriority(priority);
            tmsg.setJMSReplyTo(tempTopicForReply);
            tmsg.setText(msgBody);
            String username = principal.getName();
            tmsg.setStringProperty("runAsUser", username);
            //profiler.stop(prepareJmsProfiler);
            long sendJmsProfiler = profiler.start("Sending JMS Message");
            mp.setPriority(priority);
            mp.send(dest, tmsg);
            profiler.stop(sendJmsProfiler);
            return false;
        }

    }

    /**
     * Handle a single Bayeux client disconnecting from the server. This closes the client's state like its JSM temporary topic and consumer and removes the
     * client's subscriptions to any graph update topics.
     * 
     * @param clientId
     */
    protected void disconnectClient(String clientId) {
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.COMBUS_MARKER, "Disconnecting:{} ", clientId);
        }

        // Avoid a deadlock by not doing JMS operations while holding mapLock.
        // We instead gather up the references we need and close them after releasing mapLock.
        List<MessageConsumer> consumersToClose = Collections.emptyList();
        TemporaryTopic topicToClose = null;
        MessageConsumer tempTopicConsumerToClose = null;
        String username = null;
        String errorMsg = "Error while disconnecting:" + clientId;

        mapLock.lock();
        try {
            ClientState state = clientIdToClientState.get(clientId);
            if (state != null) {
                username = state.principal.getName();
                errorMsg += username + "/" + clientId;

                topicToClose = state.topic;
                tempTopicConsumerToClose = state.consumer;

                try {
                    tempDestinationToClientState.remove(state.topic.getTopicName());
                } catch (JMSException e) {
                    log.warn(LogUtils.COMBUS_MARKER, errorMsg, e);
                }

                if (state.topicSubscriptions.size() > 0) {
                    consumersToClose = new ArrayList<MessageConsumer>(state.topicSubscriptions.size());
                    for (String topic : state.topicSubscriptions) {
                        MessageConsumer consumer = unsubscribeTopic(topic, state.clientId);
                        consumersToClose.add(consumer);
                    }
                }
                state.topicSubscriptions.clear();

                clientIdToClientState.remove(clientId);
            }
        } finally {
            mapLock.unlock();
        }

        // Now actually destroy the JMS state since we're no longer holding mapLock.
        for (MessageConsumer consumer : consumersToClose) {
            if (consumer != null) {
                try {
                    consumer.close();
                } catch (NullPointerException npe) {
                    //Catch exception due to defect within activemq's ActiveMQMessageConsumer.dispose() method
                } catch (JMSException e) {
                    log.warn(LogUtils.COMBUS_MARKER, errorMsg, e);
                }
            }
        }
        cleanupTemporaryTopic(topicToClose, tempTopicConsumerToClose, username, clientId);
    }

    private static class ClientStateToClose {
        private TemporaryTopic  temporaryTopic;

        private MessageConsumer consumer;

        private long            deletionRequestTime;

        private String          username;

        private String          clientId;

        ClientStateToClose(MessageConsumer consumer, TemporaryTopic temporaryTopic, long deletionRequestTime, String username, String clientId) {
            this.consumer = consumer;
            this.temporaryTopic = temporaryTopic;
            this.deletionRequestTime = deletionRequestTime;
            this.username = username;
            this.clientId = clientId;
        }

        long getDeletionRequestTime() {
            return deletionRequestTime;
        }

        void close() {
            if (consumer != null) {
                try {
                    consumer.close();
                    consumer = null;
                } catch (JMSException e) {
                    log.debug(LogUtils.COMBUS_MARKER, "Error while removing timed-out consumer.", e);
                }
            }
            if (temporaryTopic != null) {
                try {
                    temporaryTopic.delete();
                    temporaryTopic = null;
                } catch (JMSException e) {
                    log.debug(LogUtils.COMBUS_MARKER, "Error while removing timed-out temporary topic.", e);
                }
            }
        }
    }

    /**
     * Marks a temporary topic for deletion. Before deleting the topic, it will be unregistered via the notification registration service. The topic will be
     * deleted once that operation completes.
     * 
     * @param topicToClose
     *            the temporary topic to close.
     * @param username
     *            the username of the user to which the temporary topic belongs
     * @param clientId
     *            the clientId of the specific Bayeux connection to which the temporary topic applies.
     */
    private void cleanupTemporaryTopic(TemporaryTopic topicToClose, MessageConsumer tempTopicConsumerToClose, String username, String clientId) {

        String correlationId = UUID.randomUUID().toString();
        mapLock.lock();
        try {
            topicsToDelete.put(correlationId, new ClientStateToClose(tempTopicConsumerToClose, topicToClose, System.currentTimeMillis(), username, clientId));
        } finally {
            mapLock.unlock();
        }

        log.debug(LogUtils.COMBUS_MARKER, "Sending unregister subscriber message for {}/{}", username, clientId);
        try {
            TextMessage tmsg = session.createTextMessage();
            tmsg.setJMSCorrelationID(correlationId);
            tmsg.setJMSReplyTo(topicToClose);
            tmsg.setStringProperty(SerializationConstants.operation, INotificationRegistrationService.UNREGISTER_SUBSCRIBER);
            tmsg.setStringProperty("runAsUser", username);
            mp.send(destinations.get(COMBUS.NOTIFICATION_SERVICE_QUEUE), tmsg);
        } catch (JMSException e) {
            MDC.put(LogUtils.USER, username);
            log.warn(LogUtils.COMBUS_MARKER, "Error while sending real-time update subscription remove request for " + username + "/" + clientId, e);
            MDC.clear();
        }

    }

    /**
     * Checks if this is a message that the BridgeConnectionManager expects to handle and, if so, handles the message. These are messages that typically are
     * responses to requests sent by the BridgeConnectionManager code for its own purposes rather than messages explicitly sent or intended for a client.
     * 
     * @param msg
     *            the message the handle
     * @return true if the message was handled, false otherwise.
     * @throws JMSException
     */
    public boolean handleInternalMessage(Message msg) throws JMSException {
        boolean handled = false;
        if (msg != null) {
            String correlationId = msg.getJMSCorrelationID();
            if (correlationId != null) {
                ClientStateToClose topicToDelete = null;
                mapLock.lock();
                try {
                    topicToDelete = topicsToDelete.get(correlationId);
                    if (topicToDelete != null) {
                        topicsToDelete.remove(correlationId);
                        handled = true;
                    }
                } finally {
                    mapLock.unlock();
                }

                if (topicToDelete != null) {
                    log.debug(LogUtils.COMBUS_MARKER, "Finished deleting client JMS state for {}/{}", topicToDelete.username, topicToDelete.clientId);
                    topicToDelete.close();
                    topicToDelete = null;
                }
            }
        }
        return handled;
    }

    /**
     * Called whenever any graph's read privilege is removed for any role. We need to go through our graph update subscriptions when this happens to kick out
     * any user that no longer has access to get those messages.
     * 
     * @param namedGraphUri
     *            the URI of the graph whose read access changed.
     * @param role
     *            the role who's read access to the graph was removed.
     * @throws AnzoException
     */
    protected void removeUnauthorizedSubscriptions(URI namedGraphUri, URI role, IOperationContext opContext) throws AnzoException {

        List<String> possiblyAffectedTopics = new ArrayList<String>();

        //        String uuidStr = graphUuidResolver.getUuid(namedGraphUri, opContext, datasource.getModelService());
        URI uuid = datasource.getModelService().getUUIDforUri(opContext, namedGraphUri);
        if (uuid != null) {
            possiblyAffectedTopics.add(UriGenerator.generateEncapsulatedString(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX, uuid.toString()));
        }
        possiblyAffectedTopics.add(UriGenerator.generateEncapsulatedString(NAMESPACES.STREAM_TOPIC_PREFIX, namedGraphUri.toString()));

        for (String topic : possiblyAffectedTopics) {

            Map<String, MessageConsumer> consumersToClose = null;

            mapLock.lock();
            try {
                TopicSubscription subscriptions = topicSubscriptions.get(topic);
                if (subscriptions != null && !subscriptions.subscribedClients.isEmpty()) {
                    // There are users subscribed to this graph's updates. We need to go through each
                    // such user, retrieve their latest roles, and compare it to the roles which are allowed to
                    // read the graph.

                    // First we retrieve the read access information for the graph.
                    Set<URI> graphRoles = datasource.getAuthorizationService().getRolesForGraph(opContext, namedGraphUri, Privilege.READ);

                    // Now we check each user for access to this graph.
                    Iterator<Map.Entry<String, ClientState>> subscribedClientsIterator = subscriptions.subscribedClients.entrySet().iterator();
                    while (subscribedClientsIterator.hasNext()) {
                        ClientState state = subscribedClientsIterator.next().getValue();
                        if (state != null) {
                            if (state.principal != null) {
                                Set<URI> userRoles = state.principal.getRoles();
                                if (!state.principal.isSysadmin() && !org.openanzo.rdf.utils.Collections.memberOf(graphRoles, userRoles)) {
                                    // This user no longer has access to this graph so unsubscribe them.
                                    state.topicSubscriptions.remove(topic);
                                    subscribedClientsIterator.remove();
                                    if (subscriptions.subscribedClients.size() <= 0) {
                                        // This was the last subscriber so we can close this graph's consumer.
                                        topicSubscriptions.remove(topic);
                                        if (consumersToClose == null) {
                                            consumersToClose = new HashMap<String, MessageConsumer>();
                                        }
                                        consumersToClose.put(topic, subscriptions.consumer);
                                    }
                                }
                            }
                        }
                    }

                }
            } finally {
                mapLock.unlock();
            }

            // Now that we've released mapLock, we can close any consumers that were marked for closure.
            if (consumersToClose != null) {
                for (Map.Entry<String, MessageConsumer> entry : consumersToClose.entrySet()) {
                    closeMessageConsumer(entry.getValue());
                }
            }
        }
    }

    /**
     * Find the Bayeux username and clientId to which messages sent to the given topic should be relayed. Returns null if no such mapping could be found.
     * 
     * @param topic
     * @return a username and clientId pair.
     * @throws JMSException
     */
    protected Pair<String, String> findBayeuxReplyChannelForTopic(TemporaryTopic topic) throws JMSException {
        String destination = topic.getTopicName();
        Pair<String, String> ret = null;
        mapLock.lock();
        try {
            ClientState state = tempDestinationToClientState.get(destination);
            if (state != null) {
                ret = new Pair<String, String>(state.principal.getName(), state.clientId);
            }
        } finally {
            mapLock.unlock();
        }
        return ret;
    }

    /**
     * Find the collection of username and clientId pairs that are subscribed to the given topic.
     * 
     * @param graphUuid
     * @return a username and clientId pair.
     */
    protected Collection<Pair<String, String>> findChannelsSubscribedToTopic(String graphUuid) {
        Collection<Pair<String, String>> ret = Collections.emptyList();
        mapLock.lock();
        try {
            TopicSubscription subscriptions = topicSubscriptions.get(graphUuid);
            if (subscriptions != null && !subscriptions.subscribedClients.isEmpty()) {
                ret = new ArrayList<Pair<String, String>>(subscriptions.subscribedClients.size());
                for (Map.Entry<String, ClientState> subscribedClient : subscriptions.subscribedClients.entrySet()) {
                    ClientState state = subscribedClient.getValue();
                    if (state != null) {
                        Pair<String, String> pair = new Pair<String, String>(state.principal.getName(), state.clientId);
                        ret.add(pair);
                    }
                }
            }
        } finally {
            mapLock.unlock();
        }
        return ret;
    }

    /**
     * Called when the service container is reset. This mainly clears any state that depends on the match between a graph's UUID and its URI. That is because
     * upon a server reset, the UUID may change. So all graph update subscriptions will be cleared, for example. But the temporary topics for the particular
     * Bayeux clients remain.
     */
    protected void reset() {
        //graphUuidResolver.clear();

        // Clear all of the graph subscriptions since they are essentially meaningless after a reset
        // since graph UUIDs will have changed.
        Collection<MessageConsumer> consumersToClose = removeAllTopicSubscriptions();
        for (MessageConsumer consumer : consumersToClose) {
            if (consumer != null) {
                closeMessageConsumer(consumer);
            }
        }
    }

    /**
     * Destroy all state including the JMS connection and Bayeux client state.
     * 
     * @param bundleStopping
     *            bundle stopping
     * @throws AnzoException
     */
    protected void destroy(boolean bundleStopping) throws AnzoException {
        closed = true;

        topicDeletionTimeoutTimer.cancel();
        topicDeletionTimeoutTimer = null;

        if (conn != null) {
            try {
                Collection<MessageConsumer> consumersToClose = null;
                Collection<TemporaryTopic> topicsToDelete = null;
                mapLock.lock();
                try {
                    if (bundleStopping) {
                        Collection<MessageConsumer> graphTopicConsumersToClose = removeAllTopicSubscriptions();
                        consumersToClose = new ArrayList<MessageConsumer>(graphTopicConsumersToClose.size() + clientIdToClientState.size());
                        consumersToClose.addAll(graphTopicConsumersToClose);
                        topicsToDelete = new ArrayList<TemporaryTopic>(clientIdToClientState.size());
                        for (Map.Entry<String, ClientState> entry : clientIdToClientState.entrySet()) {
                            ClientState state = entry.getValue();
                            if (state != null) {
                                consumersToClose.add(state.consumer);
                                topicsToDelete.add(state.topic);
                            }
                        }
                    }
                    clientIdToClientState.clear();
                } finally {
                    mapLock.unlock();
                }
                if (bundleStopping) {
                    if (consumersToClose != null) {
                        for (MessageConsumer consumer : consumersToClose) {
                            if (consumer != null) {
                                closeMessageConsumer(consumer);
                            }
                        }
                    }
                    if (topicsToDelete != null) {
                        for (TemporaryTopic topic : topicsToDelete) {
                            if (topic != null) {
                                try {
                                    topic.delete();
                                } catch (JMSException jmsex) {
                                    log.warn(LogUtils.COMBUS_MARKER, "Error deleting bayuex connection manager temporary topic:" + topic.toString(), jmsex);
                                }
                            }
                        }
                    }
                    if (session != null) {
                        try {
                            session.close();
                        } catch (JMSException jmsex) {
                            log.warn(LogUtils.COMBUS_MARKER, "Error closing bayuex connection manager session", jmsex);
                        } finally {
                            session = null;
                        }
                    }
                }
            } finally {
                try {
                    conn.close();
                } catch (JMSException jmsex) {
                    log.warn(LogUtils.COMBUS_MARKER, "Error closing bayuex connection manager  connection", jmsex);
                } finally {
                    conn = null;
                }
            }
        }
    }

    /**
     * Unsubscribe all clients from all topics. This is useful for resetting or stopping the bridge. This method will not close any of the JMS consumers for the
     * topics. Instead it will return them in a collection so that the caller can close them.
     */
    private Collection<MessageConsumer> removeAllTopicSubscriptions() {
        Collection<MessageConsumer> consumersToClose = null;
        mapLock.lock();
        try {
            int topicSubscriptionsSize = topicSubscriptions.size();
            if (topicSubscriptionsSize > 0) {
                consumersToClose = new ArrayList<MessageConsumer>(topicSubscriptionsSize);
                for (Map.Entry<String, TopicSubscription> subscriptionEntry : topicSubscriptions.entrySet()) {
                    TopicSubscription topicSubscription = subscriptionEntry.getValue();
                    consumersToClose.add(topicSubscription.consumer);
                    for (Map.Entry<String, ClientState> clientEntry : topicSubscription.subscribedClients.entrySet()) {
                        ClientState state = clientEntry.getValue();
                        if (state != null) {
                            state.topicSubscriptions.clear();
                        }
                    }
                }
            }
            topicSubscriptions.clear();
        } finally {
            mapLock.unlock();
        }
        if (consumersToClose == null) {
            consumersToClose = Collections.emptyList();
        }
        return consumersToClose;
    }

    /**
     * Edits the state in the connection manager to reflect the addition of a subscription to given topic for the given client id. This method mainly does the
     * bookkeeping. It doesn't handle creating any JMS consumers or checking ACLs. That is expected to be done by the calling method.
     * 
     * @param topic
     * @param clientId
     * @param topicSubscription
     */
    private void addTopicSubscription(String topic, String clientId, TopicSubscription topicSubscription) {
        mapLock.lock();
        try {
            ClientState state = clientIdToClientState.get(clientId);
            if (state != null) {
                topicSubscription.subscribedClients.put(clientId, state);
                state.topicSubscriptions.add(topic);
            }
        } finally {
            mapLock.unlock();
        }
        log.debug(LogUtils.COMBUS_MARKER, "Subscribed client {} to topic {}", clientId, topic);
    }

    /**
     * Removes the client's subscription to the topic. If this is the last subscriber, then the topic's JMS consumer is returned so that it can be closed by the
     * caller.
     * 
     * @param topic
     *            the topic from which to unsubscribe.
     * @param clientId
     *            the id of the client to unsubscribe.
     */
    private MessageConsumer unsubscribeTopic(String topic, String clientId) {
        MessageConsumer consumerToClose = null;
        mapLock.lock();
        try {
            TopicSubscription topicSubscription = topicSubscriptions.get(topic);
            if (topicSubscription != null) {
                topicSubscription.subscribedClients.remove(clientId);
                if (topicSubscription.subscribedClients.size() <= 0) {
                    // This was the last subscriber so we can close this topic's consumer.
                    // But we can't do it while holding mapLock to avoid a deadlock, so we'll let the caller
                    // take care of destroying it.
                    consumerToClose = topicSubscription.consumer;
                    topicSubscriptions.remove(topic);
                }
            }
        } finally {
            mapLock.unlock();
        }
        return consumerToClose;
    }

    /**
     * Closes the given consumer with some exception handling to handle an ActiveMQ bug. WARNING: This method make JMS calls so don't call this method while
     * holding mapLock due to possible deadlock.
     * 
     * @param consumer
     */
    private void closeMessageConsumer(MessageConsumer consumer) {
        if (consumer != null) {
            try {
                consumer.close();
            } catch (NullPointerException npe) {

            } catch (JMSException jmsex) {
                log.warn(LogUtils.COMBUS_MARKER, "Error unsubscribing from graph updates.", jmsex);
            }
        }
    }

    /**
     * determine whether or not the current user can subscribe to the given topic.
     * 
     * @param topic
     * @param authorizationService
     * @param opContext
     * @return
     * @throws AnzoException
     */
    private boolean userHasTopicAccess(String topic, AnzoPrincipal principal, IOperationContext opContext) throws AnzoException {
        if (topic.startsWith(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {
            String graphUuid = UriGenerator.stripEncapsulatedString(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX, topic);
            URI graphUri = datasource.getModelService().getUriForUUID(opContext, Constants.valueFactory.createURI(graphUuid));
            // URI graphUri = graphUuidResolver.getGraphUri(graphUuid, opContext, datasource.getModelService());
            return userHasGraphReadAccess(graphUri, principal, opContext);
        } else if (topic.equals(COMBUS.TRANSACTIONS_TOPIC)) {
            return true;
        } else if (topic.startsWith(NAMESPACES.STREAM_TOPIC_PREFIX)) {
            String graphUuid = UriGenerator.stripEncapsulatedString(NAMESPACES.STREAM_TOPIC_PREFIX, topic);
            URI graphUri = datasource.getModelService().getUriForUUID(opContext, Constants.valueFactory.createURI(graphUuid));
            //URI graphUri = graphUuidResolver.getGraphUri(graphUuid, opContext, datasource.getModelService());
            return userHasGraphReadAccess(graphUri, principal, opContext);
        } else {
            throw new AnzoException(ExceptionConstants.COMBUS.INVALID_TOPIC, topic);
        }
    }

    /**
     * Checks if the current user has read access to the given graph.
     * 
     * @param graphUri
     *            The graph URI to check access.
     * @param opContext
     *            The operation context to use when communicating with the Anzo authorization service.
     * @return true if read access is granted, false otherwise.
     * @throws AnzoException
     */
    private boolean userHasGraphReadAccess(URI graphUri, AnzoPrincipal principal, IOperationContext opContext) throws AnzoException {
        boolean ret = false;
        if (principal == null) {
            throw new SecurityException("No currrently logged in principal.");
        }
        Set<URI> principalRoles = principal.getRoles();

        if (principal.isSysadmin()) {
            ret = true;
        } else {
            Set<URI> roles = datasource.getAuthorizationService().getRolesForGraph(opContext, graphUri, Privilege.READ);
            ret = org.openanzo.rdf.utils.Collections.memberOf(roles, principalRoles);
        }
        return ret;
    }

    /**
     * Checks if the current user has read access to the given graph.
     * 
     * @param graphUri
     *            The graph URI to check access.
     * @param opContext
     *            The operation context to use when communicating with the Anzo authorization service.
     * @return true if read access is granted, false otherwise.
     * @throws AnzoException
     */
    private boolean userHasGraphAddAccess(URI graphUri, AnzoPrincipal principal, IOperationContext opContext) throws AnzoException {
        boolean ret = false;
        if (principal == null) {
            throw new SecurityException("No currrently logged in principal.");
        }
        Set<URI> principalRoles = principal.getRoles();
        if (principal.isSysadmin()) {
            ret = true;
        } else {
            Set<URI> roles = datasource.getAuthorizationService().getRolesForGraph(opContext, graphUri, Privilege.ADD);
            ret = org.openanzo.rdf.utils.Collections.memberOf(roles, principalRoles);
        }
        return ret;
    }

    /**
     * Represents state held for one connection to the BayeuxJMSBridge. A particular user can connect many times under a different client id. This represents
     * one of those connections. The two main pieces of state held here are the temporary topic and the consumer. The temporary topic is the topic which
     * receives messages intended for the client. The consumer is listening on that topic.
     * 
     * The rest of the state kept for basic bookkeeping.
     */
    static class ClientState {

        protected ClientState(AnzoPrincipal principal, TemporaryTopic topic, String clientId, MessageConsumer consumer) {
            this.topic = topic;
            this.principal = principal;
            this.clientId = clientId;
            this.consumer = consumer;
            this.topicSubscriptions = Collections.synchronizedSet(new HashSet<String>());
        }

        final AnzoPrincipal   principal;

        final String          clientId;

        final TemporaryTopic  topic;

        final MessageConsumer consumer;

        /**
         * The set of topics to which this client is subscribed. We keep this mainly so that we can unsubscribe for them all during disconnection. Do not access
         * without first acquiring mapLock.
         */
        final Set<String>     topicSubscriptions;
    }

    /**
     * A TopicSubscription represents the state related to a subscription to topic. It keeps the JMS Consumer listening to the updates and it keeps a set of
     * Bayeux clientIds who are subscribed to messages for that topic.
     */
    static class TopicSubscription {
        final MessageConsumer          consumer;

        /**
         * Map from clientId to ClientState. This is essentially just a set of all of the Bayeux clients subscribed to a particular topic. The only reason this
         * is a Map rather than a Set is because it's more efficient to already have the ClientState (which we'll need to send the topic messages via Bayeux)
         * rather than having to lookup each ClientState as we iterate through the subscribedClients.
         */
        final Map<String, ClientState> subscribedClients;

        protected TopicSubscription(MessageConsumer consumer) {
            this.consumer = consumer;
            this.subscribedClients = Collections.synchronizedMap(new HashMap<String, ClientState>());
        }
    }

}
