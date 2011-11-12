/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.combus.bayeux;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

import org.apache.commons.lang.StringUtils;
import org.cometd.Bayeux;
import org.cometd.Channel;
import org.cometd.Client;
import org.cometd.Listener;
import org.cometd.SecurityPolicy;
import org.eclipse.jetty.util.ajax.JSON;
import org.openanzo.analysis.Profiler;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.combus.MessageUtils;
import org.openanzo.datasource.IDatasource;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.BaseOperationContext;
import org.openanzo.services.impl.ConfiguredCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * The BayeuxJMSBridge is essentially a translator between HTTP and JMS built on top of the Bayeux Comet protocol. Bayeux is a protocol and techniques that add
 * bidirectional communication to HTTP. Anzo.JS clients connect to the BayeuxJMSBridgeServlet and the Bayeux implementation will send messages to this
 * BayeuxJMSBridge.
 * 
 * The BayeuxJMSBridge will keep one JMS connection that all clients will share. Authentication is handled by blocking access to the BayeuxJMSBridgeServlet via
 * any authentication mechanism such as HTTP Basic Authentication, Form Authentication, etc. Authorization of the JMS messages is done by communicating with the
 * Anzo authorization service and via the runAsUser functionality of services.
 * 
 * For more information, see http://www.openanzo.org/projects/openanzo/wiki/CommunicationBusComet
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 * 
 */
class BayeuxJMSBridge implements ServletContextAttributeListener, BayeuxJMSConstants {

    private static final Logger           log                             = LoggerFactory.getLogger("org.openanzo.combus.bayeux.BayeuxJmsBridge");

    private static final Profiler         profiler                        = new Profiler();

    private static final String           SEND_BAYEUX_MESSAGE_TO_JMS      = "sendBayeuxMessageToJMS";

    private static final String           CHECK_ACCESS_FOR_SUBSCRIPTION   = "checkAccessForSubscription";

    private static final String           ACL_UPDATE_IN_BAYEUX_JMS_BRIDGE = "ACLUpdateInBayeuxJMSBridge";

    private static final String           GET_ROLES_FOR_USER              = "GetRolesForUser";

    private static final String           AUTHENTICATE_SERVICE            = "AuthenticateServiceUser";

    private static final String           PROTOCOL_VERSION                = "1.1";

    private static final int              THREAD_POOL_SIZE_DEFAULT        = 10;

    private BridgeMessageListener         bridgeListener                  = null;

    private final DisconnectListener      bayeuxDisconnectListener        = new DisconnectListener();

    private final BridgeConnectionManager bridgeConnectionManager;

    private final AnzoPrincipal           servicePrincipal;

    private ThreadPoolExecutor            workerPool;

    protected BayeuxJMSBridge(IAuthenticationService authenticationService, IJmsProvider jmsProvider, ICacheProvider cacheProvider, Properties properties, ConfiguredCredentials credentials, IDatasource datasource) throws AnzoException {
        this.bridgeConnectionManager = new BridgeConnectionManager(datasource, cacheProvider, credentials);
        servicePrincipal = authenticationService.authenticateUser(new BaseOperationContext(AUTHENTICATE_SERVICE, BaseOperationContext.generateOperationId(), null), credentials.getUserName(), credentials.getPassword());
        ConnectionFactory factory = jmsProvider.createConnectionFactory(properties);
        bridgeConnectionManager.initialize(factory, properties);
        log.info(LogUtils.COMBUS_MARKER, "JMS-Bayeux Bridge initialized.");
    }

    private synchronized void initialize(Bayeux bayeux, Properties properties) {

        int threadPoolSize = THREAD_POOL_SIZE_DEFAULT;
        Integer size = BayeuxBridgeDictionary.getThreadPoolSize(properties);
        if (size != null) {
            threadPoolSize = size;
        }
        log.info(LogUtils.LIFECYCLE_MARKER, "BayeuxBridge using thread pool size '{}'.", threadPoolSize);
        workerPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadPoolSize);

        if (!bayeux.hasChannel(CHANNEL_CONTROL)) {
            Client bayeuxControlChannelClient = bayeux.newClient("control");
            bayeuxControlChannelClient.addListener(new ControlListener(bayeux));
            bayeux.getChannel(CHANNEL_CONTROL, true).subscribe(bayeuxControlChannelClient);

            Client bayeuxBridgeChannelClient = bayeux.newClient("bridge");
            bayeuxBridgeChannelClient.addListener(new BridgeListener(bayeux));
            bayeux.getChannel(CHANNEL_BRIDGE, true).subscribe(bayeuxBridgeChannelClient);

            if (log.isTraceEnabled()) {
                log.trace(LogUtils.LIFECYCLE_MARKER, "BayeuxJMSBridge initialized with TRACE logging enabled. Adding MonitorListener to log all Bayeux messages.");
                Client bayeuxAllChannelClient = bayeux.newClient("monitor");
                bayeuxAllChannelClient.addListener(new MonitorListener());
                bayeux.getChannel("/**", true).subscribe(bayeuxAllChannelClient);
            }
            bayeux.setSecurityPolicy(new BayeuxJMSSecurityPolicy());
            bridgeListener = new BridgeMessageListener(bayeux);
        }
    }

    protected void refreshThreadPoolSize(Dictionary<? extends Object, ? extends Object> configProperties) {
        int threadPoolSize = 0;
        Integer size = BayeuxBridgeDictionary.getThreadPoolSize(configProperties);
        if (size != null) {
            threadPoolSize = Integer.parseInt(size.toString());
        }

        workerPool.setCorePoolSize(threadPoolSize);
        workerPool.setMaximumPoolSize(threadPoolSize);
    }

    /**
     * Called when the service container component's (CometdServletEndpoint) stop method is called. This destroys all of the JMS connection state and Bayeux
     * connection state.
     * 
     * @param bundleStopping
     *            bundle stopping
     * @throws AnzoException
     */
    protected void stop(boolean bundleStopping) throws AnzoException {
        bridgeConnectionManager.destroy(bundleStopping);
    }

    /**
     * Called when the service container component's (CometdServletEndpoint) reset method is called.
     */
    protected void resetStarting() {
    }

    protected void resetFinished() {
    }

    protected void reset() {
        bridgeConnectionManager.reset();
    }

    public void attributeAdded(ServletContextAttributeEvent scab) {
        Properties properties = (Properties) scab.getServletContext().getAttribute("initParams");
        if (scab.getName().equals(Bayeux.ATTRIBUTE)) {
            Bayeux bayeux = (Bayeux) scab.getValue();
            initialize(bayeux, properties);
        }
    }

    /**
     * Returns the id of the Bayeux channel used to send responses to the current user's particular client. The authenticated username is pulled from the given
     * principal.
     */
    private String getReplyChannelId(AnzoPrincipal principal, Client fromClient) {
        String username = principal.getName();
        return getReplyChannelId(username, fromClient.getId());
    }

    /**
     * Returns the id of the Bayeux channel used to send responses to given username and client id. The Channel ID is essentially a path which concatenates the
     * username and client id along with a prefix.
     */
    private static String getReplyChannelId(String username, String clientId) {
        String replyChannelId = CHANNEL_USER_PREFIX + username + "/" + clientId;
        return replyChannelId;
    }

    private static void publishIfChannelExists(Bayeux bayeux, String channelId, Client fromClient, Object data, String msgId) {
        Channel replyChannel = bayeux.getChannel(channelId, false);
        if (replyChannel == null) {
            log.warn(LogUtils.COMBUS_MARKER, "sendError - Bayeux reply channel {} missing.", channelId);
        } else {
            replyChannel.publish(fromClient, data, "R" + msgId);
        }
    }

    private void sendError(Bayeux bayeux, Client fromClient, Object data, String msgId, AnzoPrincipal principal, String status, String errorMsg) {
        Map<?, ?> obj = (Map<?, ?>) data;
        String replyChannelId = getReplyChannelId(principal, fromClient);
        Map<String, Object> replyData = new HashMap<String, Object>();
        replyData.put(CONTROL_MSG_STATUS, status);
        if (errorMsg != null) {
            replyData.put(CONTROL_MSG_ERROR_MESSSAGE, errorMsg);
        }
        if (obj.get(CONTROL_MSG_CORRELATION_ID) != null) {
            replyData.put(CONTROL_MSG_CORRELATION_ID, obj.get(CONTROL_MSG_CORRELATION_ID).toString());
        } else {
            Map<?, ?> props = (Map<?, ?>) obj.get(JMS_MSG_PROPERTIES);
            if (props != null) {
                if (props.get(JMS_MSG_PROPERTY_CORRELATION_ID) != null) {
                    Map<String, String> p = new HashMap<String, String>();
                    replyData.put(JMS_MSG_PROPERTIES, p);
                    p.put(JMS_MSG_PROPERTY_CORRELATION_ID, (String) props.get(JMS_MSG_PROPERTY_CORRELATION_ID));
                }
            }
        }
        publishIfChannelExists(bayeux, replyChannelId, fromClient, replyData, "R" + msgId);
    }

    /**
     * Called whenever any graph's read privilege is removed for any role. We need to go through our graph update subscriptions when this happens to kick out
     * any user that no longer has access to get those messages.
     * 
     * @param namedGraphUri
     *            the URI of the graph whose read access changed.
     * @param role
     *            the role who's read access to the graph was removed.
     */
    protected void namedGraphReadPrivilegeRemoved(URI namedGraphUri, URI role) {
        IOperationContext opContext = null;
        try {
            opContext = new BaseOperationContext(ACL_UPDATE_IN_BAYEUX_JMS_BRIDGE, ACL_UPDATE_IN_BAYEUX_JMS_BRIDGE + namedGraphUri, servicePrincipal);
            opContext.setMDC();
            bridgeConnectionManager.removeUnauthorizedSubscriptions(namedGraphUri, role, opContext);
        } catch (AnzoException e) {
            log.error(LogUtils.COMBUS_MARKER, "Error removing unauthorized subscriptions for graph " + namedGraphUri, e);
        } finally {
            if (opContext != null) {
                opContext.clearMDC();
            }
        }
    }

    /**
     * The Bayeux listener received messages sent to the 'control' channel. Typically those are things like connect, topic subscription, etc.
     */
    private class ControlListener implements Listener {
        private static final String ERROR_MSG_GRAPH_SUBSCRIBE_PREFIX   = "Could not subscribe to graph update events for graph:";

        private static final String ERROR_MSG_GRAPH_UNSUBSCRIBE_PREFIX = "Could not unsubscribe from graph update events for graph:";

        final Bayeux                bayeux;

        protected ControlListener(Bayeux bayeux) {
            this.bayeux = bayeux;
        }

        public void removed(String id, boolean timeout) {
            log.debug(LogUtils.COMBUS_MARKER, "User removed (control).");
        }

        public void deliver(final Client fromClient, final Client toClient, org.cometd.Message msg) {
            if (log.isTraceEnabled()) {
                log.trace(LogUtils.COMBUS_MARKER, "Control message received:{}", msg.toString());
            }
            final AnzoPrincipal principal = PrincipalFilter.getPrincipal(); // This is dependent on the current request thread so we get this now rather than in the worker thread
            // Grab the parts of the message that we need now since the message object may be recycled by CometD for another request
            // by the time the worker task executes.
            final HashMap<?, ?> data = (HashMap<?, ?>) msg.getData();
            final String msgId = msg.getId();
            final String type = (String) data.get(CONTROL_MSG_CONTROL_TYPE);
            final String clientId = fromClient.getId();
            final String replyChannelId = getReplyChannelId(principal.getName(), clientId);
            final String correlationId = data.get(CONTROL_MSG_CORRELATION_ID).toString();
            workerPool.execute(new Runnable() {
                public void run() {
                    if (type.equals(CONTROL_TYPE_CONNECT)) {
                        handleBridgeConnect(fromClient, data, msgId, principal, clientId, replyChannelId, correlationId);
                    } else if (type.equals(CONTROL_TYPE_TOPIC_SUBSCRIBE)) {
                        handleTopicSubscriptionOperation(true, fromClient, data, msgId, principal, clientId, replyChannelId, correlationId);
                    } else if (type.equals(CONTROL_TYPE_TOPIC_UNSUBSCRIBE)) {
                        handleTopicSubscriptionOperation(false, fromClient, data, msgId, principal, clientId, replyChannelId, correlationId);
                    } else {
                        String errorMsg = "Unknown control message: " + type;
                        log.error(LogUtils.COMBUS_MARKER, errorMsg);
                        sendError(bayeux, fromClient, data, msgId, principal, STATUS_BAD_REQUEST, errorMsg);
                    }
                }
            });
        }

        /**
         * Handle a control channel message to connect create a JMS session for the client. The response to the request will contain the user's user and role
         * information.
         * 
         * @param fromClient
         * @param data
         * @param msgId
         * @param username
         * @param clientId
         * @param replyChannelId
         * @param correlationId
         */
        private void handleBridgeConnect(Client fromClient, HashMap<?, ?> data, String msgId, AnzoPrincipal principal, String clientId, String replyChannelId, String correlationId) {
            String protocolVersion = (String) data.get(CONTROL_MSG_PROTOCOL_VERSION);
            if (protocolVersion == null || !protocolVersion.equals(PROTOCOL_VERSION)) {
                if (principal != null)
                    MDC.put(LogUtils.USER, principal.getName());
                String errorString = "Protocol version mismatch, received " + protocolVersion + " expecting " + PROTOCOL_VERSION;
                log.error(LogUtils.COMBUS_MARKER, errorString);
                MDC.clear();
                sendError(bayeux, fromClient, data, msgId, principal, CONNECTION_STATUS_FAILED, errorString);
                return;
            }

            Map<String, Object> replyData = new HashMap<String, Object>();
            replyData.put(CONTROL_MSG_CORRELATION_ID, correlationId);
            try {
                bridgeConnectionManager.connectClient(clientId, bridgeListener, principal);
                IOperationContext opContext = new BaseOperationContext("GetUserPrincipal", GET_ROLES_FOR_USER, servicePrincipal);
                opContext.setMDC();
                Set<URI> roles = principal.getRoles();
                StringBuilder rolesBuffer = new StringBuilder();
                int count = 0;
                for (URI uri : roles) {
                    if (count > 0) {
                        rolesBuffer.append("\n");
                    }
                    count++;
                    rolesBuffer.append(uri.toString());
                }
                replyData.put(CONTROL_MSG_USER_ROLES, rolesBuffer.toString());
                replyData.put(CONTROL_MSG_USER_IS_SYSADMIN, principal.isSysadmin());
                URI userURI = principal.getUserURI();
                if (userURI != null) {
                    replyData.put(CONTROL_MSG_USER_URI, userURI.toString());
                }
                replyData.put(CONTROL_MSG_STATUS, CONNECTION_STATUS_CONNECTED);
            } catch (JMSException e) {
                if (principal != null)
                    MDC.put(LogUtils.USER, principal.getName());
                String errorMsg = "Error setting up temporary topic";
                log.error(LogUtils.COMBUS_MARKER, errorMsg, e);
                sendError(bayeux, fromClient, data, msgId, principal, CONNECTION_STATUS_FAILED, errorMsg);
                return;
            }
            fromClient.addListener(bayeuxDisconnectListener);
            publishIfChannelExists(bayeux, replyChannelId, fromClient, replyData, "R" + msgId);
        }

        /**
         * Handles a control channel message to subscribe or unsubscribe from a JMS topic.
         * 
         * @param subscribeOrUnsubscribe
         * @param fromClient
         * @param data
         * @param msgId
         * @param username
         * @param clientId
         * @param replyChannelId
         * @param correlationId
         */
        private void handleTopicSubscriptionOperation(boolean subscribeOrUnsubscribe, Client fromClient, HashMap<?, ?> data, String msgId, AnzoPrincipal principal, String clientId, String replyChannelId, String correlationId) {
            Object topicInput = data.get(CONTROL_MSG_TOPICS);
            if (!(topicInput instanceof Object[])) {
                if (principal != null)
                    MDC.put(LogUtils.USER, principal.getName());
                String errorMsg = "Missing or malformed " + CONTROL_MSG_TOPICS + " in " + (subscribeOrUnsubscribe ? CONTROL_TYPE_TOPIC_SUBSCRIBE : CONTROL_TYPE_TOPIC_UNSUBSCRIBE) + " message. Must be an Array of Strings.";
                log.error(LogUtils.COMBUS_MARKER, errorMsg);
                MDC.clear();
                sendError(bayeux, fromClient, data, msgId, principal, TOPIC_SUBSCRIBE_STATUS_FAILED, errorMsg);
                return;
            }
            long pid = profiler.start("Subscribing to topics {}", msgId);
            Object[] topics = (Object[]) topicInput;
            List<String> failedTopics = new ArrayList<String>();
            List<String> errors = new ArrayList<String>();
            for (Object topicObject : topics) {
                if (topicObject instanceof String) {
                    String topic = (String) topicObject;
                    if (StringUtils.isNotEmpty(topic)) {
                        if (subscribeOrUnsubscribe) {
                            IOperationContext opContext = null;
                            try {
                                opContext = new BaseOperationContext(CHECK_ACCESS_FOR_SUBSCRIPTION, correlationId, principal);
                                opContext.setMDC();
                                long ipid = profiler.start("Subscribing to topic {}", topic);
                                bridgeConnectionManager.topicSubscribe(topic, clientId, principal, bridgeListener, opContext);
                                profiler.stop(ipid);
                            } catch (Exception e) {
                                failedTopics.add(topic);
                                String errorMsg = ERROR_MSG_GRAPH_SUBSCRIBE_PREFIX + topic + "." + e.getMessage();
                                errors.add(errorMsg);
                                if (principal != null)
                                    MDC.put(LogUtils.USER, principal.getName());
                                log.error(LogUtils.COMBUS_MARKER, ERROR_MSG_GRAPH_SUBSCRIBE_PREFIX + topic, e);
                                MDC.clear();
                            } finally {
                                if (opContext != null) {
                                    opContext.clearMDC();
                                }
                            }
                        } else {
                            try {
                                bridgeConnectionManager.topicUnsubscribe(topic, clientId);
                            } catch (Exception e) {
                                failedTopics.add(topic);
                                String errorMsg = ERROR_MSG_GRAPH_UNSUBSCRIBE_PREFIX + topic + "." + e.getMessage();
                                errors.add(errorMsg);
                                if (principal != null)
                                    MDC.put(LogUtils.USER, principal.getName());
                                log.error(LogUtils.COMBUS_MARKER, ERROR_MSG_GRAPH_UNSUBSCRIBE_PREFIX + topic, e);
                                MDC.clear();
                            }
                        }
                    }
                } else {
                    String errorMsg = "Missing or malformed topic string inside array of " + CONTROL_MSG_TOPICS + " argument in " + (subscribeOrUnsubscribe ? CONTROL_TYPE_TOPIC_SUBSCRIBE : CONTROL_TYPE_TOPIC_UNSUBSCRIBE) + " message. Elements of the array must be strings.";
                    errors.add(errorMsg);
                    if (principal != null)
                        MDC.put(LogUtils.USER, principal.getName());
                    log.error(LogUtils.COMBUS_MARKER, errorMsg);
                    MDC.clear();
                }
            }

            // Send back the response
            Map<String, Object> replyData = new HashMap<String, Object>();
            replyData.put(CONTROL_MSG_CORRELATION_ID, correlationId);
            replyData.put(CONTROL_MSG_STATUS, (failedTopics.size() == 0 && errors.size() == 0) ? TOPIC_SUBSCRIBE_STATUS_SUCCESS : TOPIC_SUBSCRIBE_STATUS_FAILED);
            replyData.put(TOPIC_SUBSCRIBE_FAILED_TOPICS, failedTopics.toArray());
            replyData.put(TOPIC_SUBSCRIBE_TOPIC_ERRORS, errors.toArray());

            profiler.stop(pid);
            publishIfChannelExists(bayeux, replyChannelId, fromClient, replyData, "R" + msgId);
        }

    }

    private class BridgeListener implements Listener {
        final Bayeux bayeux;

        protected BridgeListener(Bayeux bayeux) {
            this.bayeux = bayeux;
        }

        public void removed(String id, boolean timeout) {
            log.debug(LogUtils.COMBUS_MARKER, "User removed (bridge).");
        }

        public void deliver(final Client fromClient, final Client toClient, org.cometd.Message msg) {

            // This is dependent on the current request thread so we get this now rather than in the worker thread
            final AnzoPrincipal principal = PrincipalFilter.getPrincipal();
            // Grab the parts of the message that we need now since the message object may be recycled by CometD for another request
            // by the time the worker task executes.
            final String msgId = msg.getId();
            final HashMap<?, ?> data = (HashMap<?, ?>) msg.getData();

            workerPool.execute(new Runnable() {
                public void run() {
                    long outerProfiler = profiler.start("Delivering Bayeux message over JMS. Message ID:{}", msgId);
                    long readProfiler = profiler.start("Reading Bayeux Message");
                    HashMap<?, ?> obj = data;
                    Map<?, ?> props = (Map<?, ?>) obj.get(JMS_MSG_PROPERTIES);
                    String destination = (String) obj.get(JMS_MSG_DESTINATION);
                    String body = null;
                    // The Bayeux system will have parsed the JSON into a Map but we need it as a string
                    // to re-transmit it to the anzo system.
                    Object msgBody = obj.get(JMS_MSG_BODY);
                    profiler.stop(readProfiler);
                    if (msgBody instanceof Map<?, ?> || msgBody instanceof Object[]) {
                        long doubleJsonProfiler = profiler.start("Converting Bayeux message from Map to String.");
                        body = JSON.toString(msgBody);
                        profiler.stop(doubleJsonProfiler);
                    } else {
                        body = (String) msgBody;
                    }

                    long corrIdProfiler = profiler.start("Finding correlation id.");
                    String correlationId = null;
                    if (obj.get(CONTROL_MSG_CORRELATION_ID) != null) {
                        correlationId = obj.get(CONTROL_MSG_CORRELATION_ID).toString();
                    } else {
                        if (props != null) {
                            if (props.get(JMS_MSG_PROPERTY_CORRELATION_ID) != null) {
                                correlationId = (String) props.get(JMS_MSG_PROPERTY_CORRELATION_ID);
                            }
                        }
                    }
                    profiler.stop(corrIdProfiler);

                    IOperationContext opContext = null;
                    try {
                        long opContextProfiler = profiler.start("Creating operation context for sending client message.");
                        opContext = new BaseOperationContext(SEND_BAYEUX_MESSAGE_TO_JMS, correlationId, principal);
                        opContext.setMDC();
                        profiler.stop(opContextProfiler);
                        long sendJmsProfiler = profiler.start("Bridge Sending JMS Message");
                        boolean publishedToTopic = bridgeConnectionManager.sendClientMessage(fromClient.getId(), principal, destination, props, body, opContext);
                        profiler.stop(sendJmsProfiler);
                        if (publishedToTopic) {
                            // if we published the message to a topic, (as opposed to a service destination), 
                            // then we send back the response immediately, saying that the message has been
                            // successfully published.  
                            long topicSuccessProfiler = profiler.start("Replying success on topic send.");
                            String replyChannelId = getReplyChannelId(principal, fromClient);
                            Map<String, Object> replyData = new HashMap<String, Object>();
                            replyData.put(CONTROL_MSG_STATUS, PUBLISH_STATUS_SUCCESS);
                            if (obj.get(CONTROL_MSG_CORRELATION_ID) != null) {
                                replyData.put(CONTROL_MSG_CORRELATION_ID, obj.get(CONTROL_MSG_CORRELATION_ID).toString());
                            } else {
                                if (props != null) {
                                    if (props.get(JMS_MSG_PROPERTY_CORRELATION_ID) != null) {
                                        Map<String, String> p = new HashMap<String, String>();
                                        replyData.put(JMS_MSG_PROPERTIES, p);
                                        p.put(JMS_MSG_PROPERTY_CORRELATION_ID, (String) props.get(JMS_MSG_PROPERTY_CORRELATION_ID));
                                    }
                                }
                            }
                            publishIfChannelExists(bayeux, replyChannelId, fromClient, replyData, "R" + msgId);
                            profiler.stop(topicSuccessProfiler);
                        }
                    } catch (JMSException e) {
                        String errorMsg = "Error publishing message over JMS";
                        sendError(bayeux, fromClient, data, msgId, principal, PUBLISH_STATUS_FAILED, errorMsg);
                        log.error(LogUtils.COMBUS_MARKER, errorMsg, e);
                    } catch (AnzoException e) {
                        String errorMsg = "Error publishing message over JMS";
                        sendError(bayeux, fromClient, data, msgId, principal, PUBLISH_STATUS_FAILED, errorMsg);
                        log.error(LogUtils.COMBUS_MARKER, errorMsg, e);
                    } finally {
                        if (opContext != null) {
                            long clearMdcProfiler = profiler.start("Clearing operation context.");
                            opContext.clearMDC();
                            profiler.stop(clearMdcProfiler);
                        }
                        profiler.stop(outerProfiler);
                    }
                }
            });
        }

    }

    /**
     * Listens to disconnections from the Bayeux side of the bridge. It will disconnect the corresponding JMS state. This includes disconnections due to
     * client-side timeouts. See http://cometd.org/documentation/cometd-java/server/listeners
     */
    private class DisconnectListener implements Listener {

        public DisconnectListener() {
        }

        public void removed(String id, boolean timeout) {
            bridgeConnectionManager.disconnectClient(id);
        }

        public void deliver(Client fromClient, Client toClient, org.cometd.Message msg) {

        }

    }

    /**
     * A Bayeux listener that listens on all channels. It simply logs messages received for debugging purposes.
     */
    static private class MonitorListener implements Listener {

        public MonitorListener() {
        }

        public void removed(String id, boolean timeout) {
            log.debug(LogUtils.COMBUS_MARKER, "User removed (monitor) client id:{}", id);
        }

        public void deliver(Client fromClient, Client toClient, org.cometd.Message msg) {
            String toChannel = msg.getChannel();
            Object data = msg.getData();
            if (log.isTraceEnabled()) {
                log.trace(LogUtils.COMBUS_MARKER, "MonitorListener: {} - {} -> {} {}", new Object[] { fromClient, toClient, toChannel, data });
            }
        }

    }

    /**
     * The JMS listener. All JMS messages sent to the bridge are handled by this class. It is responsible for forwarding the messages to the appropriate Bayeux
     * channel.
     */
    private class BridgeMessageListener implements MessageListener {

        private final Bayeux _bayeux;

        protected BridgeMessageListener(Bayeux bayeux) {
            _bayeux = bayeux;
        }

        public void onMessage(Message msg) {
            try {
                if (log.isTraceEnabled()) {
                    log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(msg, "BayeuxJMSBridge Received Message"));
                }

                if (!(msg instanceof TextMessage)) {
                    log.error(LogUtils.COMBUS_MARKER, "Received non-text message, cannot deliver to web client.");
                    return;
                }

                if (bridgeConnectionManager.handleInternalMessage(msg)) {
                    // The it was handled as a cleanup message, then we have nothing left to do.
                    return;
                }

                // Build the corresponding Bayeux message with the info from the JMS message
                Map<String, Object> replyData = new HashMap<String, Object>();
                Map<String, String> props = new HashMap<String, String>();
                replyData.put(JMS_MSG_PROPERTIES, props);
                Enumeration<?> propNames = msg.getPropertyNames();
                while (propNames.hasMoreElements()) {
                    String name = (String) propNames.nextElement();
                    props.put(name, msg.getStringProperty(name));
                }
                if (msg.getJMSCorrelationID() != null) {
                    props.put(JMS_MSG_PROPERTY_CORRELATION_ID, msg.getJMSCorrelationID());
                }
                replyData.put(JMS_MSG_BODY, ((TextMessage) msg).getText());
                Destination jmsDestination = msg.getJMSDestination();
                if (jmsDestination instanceof TemporaryTopic) {
                    // This is a message bound for a client's temporary topic, so send it
                    // via the particular client's Bayeux channel. 
                    Pair<String, String> userInfo = bridgeConnectionManager.findBayeuxReplyChannelForTopic((TemporaryTopic) jmsDestination);
                    if (userInfo != null) {
                        String replyChannelId = getReplyChannelId(userInfo.first, userInfo.second);
                        publishIfChannelExists(_bayeux, replyChannelId, _bayeux.getClient(userInfo.second), replyData, "jms-" + msg.getJMSMessageID());
                    }
                } else if (jmsDestination instanceof Topic) {
                    // If this isn't for a client's temporary topic then this is likely a topic message. 
                    // We need to find out which particular topic then send the
                    // message to each Bayeux client that is subscribed to that topic. 
                    Topic topicDest = (Topic) msg.getJMSDestination();
                    String topic = topicDest.getTopicName();
                    if (bridgeConnectionManager.isTopicSubscribed(topic)) {
                        props.put(JMS_MSG_PROPERTY_TYPE, MSG_TYPE_TOPIC_MESSAGE);
                        props.put(JMS_MSG_PROPERTY_TOPIC, topic);
                        log.debug(LogUtils.COMBUS_MARKER, "Topic message for {} received by BayeuxJMSBridge.", topic);
                        Collection<Pair<String, String>> userInfoCollection = bridgeConnectionManager.findChannelsSubscribedToTopic(topic);
                        for (Pair<String, String> subscriberUserInfo : userInfoCollection) {
                            String replyChannelId = getReplyChannelId(subscriberUserInfo.first, subscriberUserInfo.second);
                            publishIfChannelExists(_bayeux, replyChannelId, _bayeux.getClient(subscriberUserInfo.second), replyData, "jms-" + msg.getJMSMessageID());
                        }
                    } else {
                        log.debug(LogUtils.COMBUS_MARKER, "Message received by BayeuxJMSBridge that is neither intended directly for a user nor a topic message. Ignoring message.");
                    }
                } else {
                    log.debug(LogUtils.COMBUS_MARKER, "Message received by BayeuxJMSBridge that is neither intended directly for a user nor a topic message. Ignoring message.");
                }
            } catch (JMSException e) {
                log.error(LogUtils.COMBUS_MARKER, "Error relaying JMS message over bayeux", e);
            }
        }
    }

    /**
     * This implements the security policy for the Bayeux connections. It prevents any user from creating a Bayeux channel that would receive messages intended
     * for another user. The channels with the format /anzo/user/USER/CLIENTID are used to communicate with the user named by USER in the channel name. So the
     * policy checks the currently logged in user and the channel name's USER match before allowing the channel to be opened.
     */
    static private class BayeuxJMSSecurityPolicy implements SecurityPolicy {

        public boolean canCreate(Client client, String channel, org.cometd.Message message) {
            String username = getUsername();
            if (channel.startsWith("/anzo/user/")) {
                String[] parts = channel.split("/");
                if (parts.length < 4)
                    return false;
                return username.equals(parts[3]);
            } else {
                return false;
            }
        }

        public boolean canSubscribe(Client client, String channel, org.cometd.Message message) {
            return canCreate(client, channel, message);
        }

        public boolean canPublish(Client client, String channel, org.cometd.Message message) {
            return true;
        }

        public boolean canHandshake(org.cometd.Message message) {
            return true;
        }

        private String getUsername() {
            Principal principal = PrincipalFilter.getPrincipal();
            if (principal != null) {
                return principal.getName();
            } else {
                return null;
            }
        }
    }

    // Ignored events

    public void attributeRemoved(ServletContextAttributeEvent scab) {

    }

    public void attributeReplaced(ServletContextAttributeEvent scab) {

    }

}
