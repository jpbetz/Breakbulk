/*******************************************************************************
 * Copyright (c) 2004, 2007-2009 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.notification.web/JavaSource/com/ibm/adtech/boca/notification/UpdateManager.java,v $
 * Created by:  Joe Betz
 * Created on:  3/22/2006
 * Revision:	$Id: UpdateManager.java 163 2007-07-31 14:11:08Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.combus.realtime;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.collections15.MultiMap;
import org.apache.commons.collections15.multimap.MultiHashMap;
import org.openanzo.cache.ICache;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.combus.MessageUtils;
import org.openanzo.combus.endpoint.BaseServiceListener;
import org.openanzo.combus.endpoint.ICombusEndpointListener;
import org.openanzo.datasource.IDatasource;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.COMBUS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.Collections;
import org.openanzo.rdf.utils.CopyOnWriteMultiHashMap;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.Privilege;
import org.openanzo.services.ServicesDictionary;
import org.openanzo.services.impl.BaseOperationContext;
import org.openanzo.services.impl.DatasetTracker;
import org.openanzo.services.impl.SelectorTracker;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.openanzo.services.serialization.IUpdatesHandler;
import org.openanzo.services.serialization.JSONUpdatesReader;
import org.openanzo.services.serialization.NamedGraphUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RealtimeUpdatePublisher processes update messages from the update service, and sends messages to registered notification clients
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public class RealtimeUpdatePublisher extends BaseServiceListener implements ICombusEndpointListener {
    private static final Logger                                                log                     = LoggerFactory.getLogger(RealtimeUpdatePublisher.class);

    /** Service Endpoint's Name in {@link String} form */
    public static final String                                                 SERVICE_NAME            = NAMESPACES.SERVICE_PREFIX + "RealtimeUpdatePublisher";

    /** Map of Users to their destinations */
    private final MultiMap<URI, Destination>                                   userDestinations        = new CopyOnWriteMultiHashMap<URI, Destination>();

    /** Model service to make calls against */
    protected final IDatasource                                                datasource;

    /** The current server id for the server */
    protected String                                                           currentServerId         = null;

    protected final DestinationTrackerManager                                  trackers                = new DestinationTrackerManager();

    protected final CopyOnWriteMultiHashMap<URI, DestinationDatasetTracker>    datasetTrackers         = new CopyOnWriteMultiHashMap<URI, DestinationDatasetTracker>();

    protected final CopyOnWriteMultiHashMap<URI, DestinationDatasetTracker>    datasetUrisTrackers     = new CopyOnWriteMultiHashMap<URI, DestinationDatasetTracker>();

    protected final Map<DestinationDatasetTracker, DestinationDatasetTracker>  datasetExpandedTrackers = new HashMap<DestinationDatasetTracker, DestinationDatasetTracker>();

    protected final CopyOnWriteMultiHashMap<URI, DestinationNamedgraphTracker> namedGraphTrackers      = new CopyOnWriteMultiHashMap<URI, DestinationNamedgraphTracker>();

    protected MessageProducer                                                  producer                = null;

    protected final Dictionary<? extends Object, ? extends Object>             configProperties;

    protected final CopyOnWriteMultiHashMap<URI, URI>                          userRolesCache;

    protected final ICache<URI, Set<URI>>                                      graphRolesCache;

    protected final Set<URI>                                                   registeredSysadmins     = java.util.Collections.synchronizedSet(new HashSet<URI>());

    IOperationContext                                                          context;

    /**
     * Create UpdateManager for configuration properties
     */
    RealtimeUpdatePublisher(Dictionary<? extends Object, ? extends Object> configProperties, IAuthenticationService authenticationService, IDatasource datasource, ICacheProvider cacheProvider) {
        super(SERVICE_NAME, 1, 1, authenticationService);
        this.datasource = datasource;
        this.configProperties = configProperties;
        this.userRolesCache = new CopyOnWriteMultiHashMap<URI, URI>();
        this.graphRolesCache = cacheProvider.<URI, Set<URI>> openCache("RealtimeGraphCache", 20000, true);
        try {
            this.context = new BaseOperationContext("RealtimeUpdatePublisher", BaseOperationContext.generateOperationId(), authenticationService.getUserPrincipal(null, ServicesDictionary.getUser(configProperties, null)));
        } catch (AnzoException ae) {
            log.error(LogUtils.DATASOURCE_MARKER, "Error creating default context", ae);
        }
    }

    private MessageProducer getProducer() throws AnzoException {

        if (producer == null) {
            if (session == null) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED);
            }
            try {
                this.producer = session.createProducer(null);
            } catch (JMSException jmsex) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_CREATE_PRODUCER_FAILED, jmsex);
            }
        }
        return producer;
    }

    /**
     * Reset cache the cache of acls
     * 
     * @param session
     *            session
     * @throws AnzoException
     */
    public void reset(Session session) throws AnzoException {
        synchronized (datasetTrackers) {
            datasetTrackers.clear();
        }
        userRolesCache.clear();
        graphRolesCache.clear();
        registeredSysadmins.clear();
        trackers.clear();
        namedGraphTrackers.clear();
        try {
            // Now send a transaction complete to all users
            TextMessage endMessage = session.createTextMessage();
            endMessage.setStringProperty(SerializationConstants.operation, SerializationConstants.reset);
            endMessage.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
            for (Map.Entry<URI, Collection<Destination>> entry : userDestinations.entrySet()) {
                Collection<Destination> destinations = entry.getValue();
                for (Destination destination : destinations) {
                    try {
                        getProducer().send(destination, endMessage);
                    } catch (JMSException jmex) {
                        log.debug(LogUtils.COMBUS_MARKER, "Error sending reset message", jmex);
                        cleanupDestination(entry.getKey(), destination);
                    }
                }
            }
        } catch (JMSException jmse) {
            throw new AnzoException(ExceptionConstants.COMBUS.PROCESS_UPDATE_FAILED, jmse);
        }
        //currentServerId = serviceContainer.getInstanceURI().toString();
    }

    /**
     * Register a User with its destination and a session
     * 
     * @param userUri
     *            UserURI for client
     * @param destination
     *            Destination for client
     * @param session
     *            Session for the destination
     * @throws AnzoException
     */
    void registerClient(AnzoPrincipal principal, Destination destination) throws AnzoException {
        if (log.isDebugEnabled()) {
            log.debug("Registering client - user:{} dest:{}", (principal != null ? principal.getUserURI() : null), (destination != null ? destination.toString() : null));
        }
        if (principal == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, "principal");
        }
        userDestinations.put(principal.getUserURI(), destination);
        if (principal.isSysadmin()) {
            registeredSysadmins.add(principal.getUserURI());
        }
        for (URI role : principal.getRoles()) {
            userRolesCache.put(role, principal.getUserURI());
        }
    }

    /**
     * Deregister a destination from a UserId
     * 
     * @param userUri
     *            UserURI for client
     * @param destination
     *            Destination to deregister
     * @throws AnzoException
     */
    void deregisterClient(AnzoPrincipal principal, Destination destination) throws AnzoException {
        userDestinations.remove(principal.getUserURI(), destination);
        trackers.removeDestinationsTrackers(destination);
        removeDestination(destination);
        if (principal.isSysadmin()) {
            registeredSysadmins.remove(principal.getUserURI());
        }
    }

    /**
     * Handle an namedgraph update message from the model service
     * 
     * @param context
     *            context of operation
     * @param session
     *            JMS session message came in over
     * @param message
     *            JMS Message containing update message stream
     * @throws AnzoException
     */
    public void handleNamedgraphUpdateMessage(IOperationContext context, Session session, TextMessage message) throws AnzoException {
        try {
            if (trackers.isEmpty() && datasetTrackers.isEmpty() && namedGraphTrackers.isEmpty())
                return;
            NotificationUpdateHandler handler = new NotificationUpdateHandler(session, null);
            NamedGraphUpdate update = MessageUtils.processNamedGraphUpdateMessage(message);
            handler.handleNamedGraphUpdate(update);
            Collection<DestinationNamedgraphTracker> ngListeners = namedGraphTrackers.get(update.getUUID());
            if (ngListeners != null && !ngListeners.isEmpty()) {
                for (DestinationNamedgraphTracker ngt : ngListeners) {
                    try {
                        getProducer().send(ngt.getDestination(), message);
                    } catch (JMSException jmex) {
                        log.warn(LogUtils.COMBUS_MARKER, MessageFormat.format(Messages.getString(ExceptionConstants.COMBUS.SEND_MESSAGE_FAILED), ngt.getUserUri().toString()), jmex);
                        cleanupDestination(ngt.getUserUri(), ngt.getDestination());
                    }
                }
            }
        } catch (JMSException jmsex) {
            log.error(LogUtils.COMBUS_MARKER, "Error handling named graph update message", jmsex);
        }
    }

    /**
     * Handle an namedgraph update message from the model service
     * 
     * @param context
     *            context of operation
     * @param session
     *            JMS session message came in over
     * @param message
     *            JMS Message containing update message stream
     * @throws AnzoException
     */
    public void handleNamedgraphUpdateMessage(String operationid, INamedGraphUpdate update, Map<String, Object> updateMessage) throws AnzoException {
        try {
            if (trackers.isEmpty() && datasetTrackers.isEmpty() && namedGraphTrackers.isEmpty())
                return;
            NotificationUpdateHandler handler = new NotificationUpdateHandler(session, null);
            handler.handleNamedGraphUpdate(update);
            Collection<DestinationNamedgraphTracker> ngListeners = namedGraphTrackers.get(update.getUUID());
            if (ngListeners != null && !ngListeners.isEmpty()) {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
                setMessageProperties(textMessage, updateMessage);

                for (DestinationNamedgraphTracker ngt : ngListeners) {
                    try {
                        getProducer().send(ngt.getDestination(), textMessage);
                    } catch (JMSException jmex) {
                        log.warn(LogUtils.COMBUS_MARKER, MessageFormat.format(Messages.getString(ExceptionConstants.COMBUS.SEND_MESSAGE_FAILED), ngt.getUserUri().toString()), jmex);
                        cleanupDestination(ngt.getUserUri(), ngt.getDestination());
                    }
                }
            }
        } catch (JMSException jmsex) {
            log.error(LogUtils.COMBUS_MARKER, "Error handling named graph update message", jmsex);
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

    /**
     * Handler an update message from the model service
     * 
     * @param context
     *            context of operation
     * @param session
     *            JMS session message came in over
     * @param message
     *            JMS Message containing update message stream
     * @throws AnzoException
     */
    public void handleTransactionMessage(IOperationContext context, Session session, TextMessage message) throws AnzoException {
        try {
            // Get the XML data from the message and parse it with the updates parser
            String results = message.getText();
            String version = message.getStringProperty(SerializationConstants.version);
            if (version != null && currentServerId != null) {
                if (!version.equals(currentServerId)) {
                    return;
                }
            }
            if (trackers.size() == 0)
                return;
            NotificationUpdateHandler handler = new NotificationUpdateHandler(session, version);
            synchronized (userDestinations) {
                JSONUpdatesReader.parseUpdateTransactions(results, handler);
            }
        } catch (JMSException jmsex) {
            log.error(LogUtils.COMBUS_MARKER, "Error handling transaction message", jmsex);
        }
    }

    class NotificationUpdateHandler implements IUpdatesHandler {

        Session updateSession = null;

        String  version       = null;

        NotificationUpdateHandler(Session session, String version) {
            this.updateSession = session;
            this.version = version;
        }

        boolean checkVersion() {
            if (currentServerId != null && (!currentServerId.equals(version))) {
                return true;
            } else {
                return false;
            }
        }

        public void start() throws AnzoException {
        }

        public void end() throws AnzoException {
            handleDocumentEnd();
        }

        public void handleTransaction(IUpdateTransaction transaction) throws AnzoException {
            if ((transaction.getErrors() == null || transaction.getErrors().size() == 0) && !transaction.isEmpty()) {
                for (INamedGraphUpdate update : transaction.getNamedGraphUpdates()) {
                    handleNamedGraphUpdate(update);
                }

            }
        }

        public void handleNamedGraphUpdate(INamedGraphUpdate update) throws AnzoException {
            handleNamedGraph(update.getNamedGraphURI());
            for (Statement stmt : update.getMetaRemovals()) {
                if (!handleStatement(false, stmt))
                    return;
            }
            for (Statement stmt : update.getMetaAdditions()) {
                if (!handleStatement(true, stmt))
                    return;
            }
            for (Statement stmt : update.getRemovals()) {
                if (!handleStatement(false, stmt))
                    return;
            }
            for (Statement stmt : update.getAdditions()) {
                if (!handleStatement(true, stmt))
                    return;
            }
        }

        boolean handleNamedGraph(URI namedGraphUri) throws AnzoException {
            log.debug(LogUtils.COMBUS_MARKER, "handleNamedGraph {}", namedGraphUri);
            if (checkVersion())
                return false;
            if (userDestinations.size() == 0 || datasetTrackers.size() == 0)
                return false;

            Collection<DestinationDatasetTracker> trackers = datasetUrisTrackers.get(namedGraphUri);
            if (trackers != null && trackers.size() > 0) {
                for (DestinationDatasetTracker tracker : trackers) {
                    for (URI uri : tracker.namedGraphsUris) {
                        datasetTrackers.remove(uri, tracker);
                    }
                }
                for (URI uri : getDatasetURIs(namedGraphUri)) {
                    for (DestinationDatasetTracker tracker : trackers) {
                        datasetTrackers.put(uri, tracker);
                        tracker.namedGraphsUris.add(namedGraphUri);
                    }
                }
            }

            MultiHashMap<URI, DestinationDatasetTracker> matchingTrackers = matchingDatasetTrackers(namedGraphUri);
            log.debug(LogUtils.COMBUS_MARKER, "Found {} matchingTrackers for graph {}", matchingTrackers.size(), namedGraphUri);
            if (matchingTrackers.size() > 0) {
                Set<URI> roles = null;
                roles = graphRolesCache.get(namedGraphUri);

                if (roles == null) {
                    roles = datasource.getAuthorizationService().getRolesForGraph(context, namedGraphUri, Privilege.READ);
                    graphRolesCache.put(namedGraphUri, roles);
                }

                Set<URI> users = getUsersForRoles(roles);

                if (users.size() > 0) {
                    for (Map.Entry<URI, Collection<DestinationDatasetTracker>> entry : matchingTrackers.entrySet()) {
                        if (users.contains(entry.getKey())) {
                            MultiMap<Destination, URI> byDestination = byDestination(entry.getValue());
                            if (log.isDebugEnabled() && byDestination.size() == 0) {
                                log.debug(LogUtils.COMBUS_MARKER, "Ignoring graph update since there is no matching destination for graph {}", namedGraphUri);
                            }
                            for (Map.Entry<Destination, Collection<URI>> subentry : byDestination.entrySet()) {
                                try {
                                    TextMessage textMessage = updateSession.createTextMessage();
                                    textMessage.setStringProperty(SerializationConstants.operation, SerializationConstants.datasetUpdate);
                                    textMessage.setStringProperty(SerializationConstants.namedGraphUri, namedGraphUri.toString());
                                    if (version != null) {
                                        textMessage.setStringProperty(SerializationConstants.version, version);
                                    }
                                    textMessage.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
                                    //textMessage.setStringProperty(SerializationConstants.transactionURI, transactionURI.toString());

                                    if (log.isDebugEnabled())
                                        log.debug(MessageUtils.prettyPrint(textMessage, "Sending Notification to " + entry.getKey()));
                                    StringBuilder sb = new StringBuilder();
                                    for (URI dsURI : subentry.getValue()) {
                                        sb.append(dsURI.toString());
                                        sb.append(",");
                                    }
                                    textMessage.setStringProperty(SerializationConstants.datasetUri, sb.toString());
                                    getProducer().send(subentry.getKey(), textMessage);
                                } catch (JMSException jmex) {
                                    log.error(LogUtils.COMBUS_MARKER, MessageFormat.format(Messages.getString(ExceptionConstants.COMBUS.SEND_MESSAGE_FAILED), entry.getKey().toString()), jmex);
                                    cleanupDestination(entry.getKey(), subentry.getKey());
                                }
                            }
                        } else {
                            log.debug(LogUtils.COMBUS_MARKER, "Ignoring graph update since no users are listening that are allowed to see the graph {}", namedGraphUri);
                        }
                    }
                } else {
                    log.debug(LogUtils.COMBUS_MARKER, "Ignoring graph update since no users belong to the roles for graph {}", namedGraphUri);
                }
            } else {
                log.debug(LogUtils.COMBUS_MARKER, "Ignoring graph update since there are no matching trackers for graph {}", namedGraphUri);
            }
            return true;
        }

        boolean handleStatement(boolean additions, Statement statement) throws AnzoException {
            if (checkVersion())
                return false;
            if (userDestinations.size() == 0 || trackers.size() == 0)
                return false;
            Set<URI> roles = null;
            Map<Destination, URI> matches = trackers.matchingDestinations(statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getNamedGraphUri());
            if (matches.size() > 0) {
                roles = graphRolesCache.get(statement.getNamedGraphUri());
                if (roles == null) {
                    roles = datasource.getAuthorizationService().getRolesForGraph(context, statement.getNamedGraphUri(), Privilege.READ);
                    graphRolesCache.put(statement.getNamedGraphUri(), roles);
                }

                Set<URI> users = getUsersForRoles(roles);

                if (users.size() > 0) {
                    TextMessage textMessage = null;
                    try {
                        textMessage = updateSession.createTextMessage();
                        textMessage.setStringProperty(SerializationConstants.operation, SerializationConstants.updateResults);
                        textMessage.setBooleanProperty(SerializationConstants.method, additions);
                        textMessage.setStringProperty(SerializationConstants.type, SerializationConstants.statement);
                        CommonSerializationUtils.setSubjectInMessage(textMessage, statement.getSubject());
                        textMessage.setStringProperty(SerializationConstants.predicate, statement.getPredicate().toString());
                        textMessage.setStringProperty(SerializationConstants.namedGraphUri, statement.getNamedGraphUri().toString());
                        CommonSerializationUtils.setObjectInMessage(textMessage, statement.getObject());
                        if (version != null) {
                            textMessage.setStringProperty(SerializationConstants.version, version);
                        }
                        textMessage.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
                        //textMessage.setStringProperty(SerializationConstants.transactionURI, transactionURI.toString());
                    } catch (JMSException jmse) {
                        throw new AnzoException(ExceptionConstants.COMBUS.CREATE_MESSAGE_FAILED, jmse);
                    }
                    for (Map.Entry<Destination, URI> entry : matches.entrySet()) {
                        if (users.contains(entry.getValue())) {
                            try {
                                if (log.isDebugEnabled())
                                    log.debug(MessageUtils.prettyPrint(textMessage, "Sending Notification to " + entry.getKey()));
                                getProducer().send(entry.getKey(), textMessage);
                            } catch (JMSException jmex) {
                                log.error(LogUtils.COMBUS_MARKER, MessageFormat.format(Messages.getString(ExceptionConstants.COMBUS.SEND_MESSAGE_FAILED), entry.getKey().toString()), jmex);
                                cleanupDestination(entry.getValue(), entry.getKey());
                            }
                        }
                    }
                }
            }
            return true;
        }

        boolean handleDocumentEnd() throws AnzoException {
            if (checkVersion())
                return false;
            return true;
        }
    }

    private void cleanupDestination(URI userUri, Destination destination) {
        trackers.removeDestinationsTrackers(destination);
        userDestinations.remove(userUri, destination);

    }

    void registerTracker(IOperationContext context, Set<? extends SelectorTracker> selectorTrackers, Set<? extends DatasetTracker> datasetTrackersIn, Set<URI> namedGraphTrackers, Destination destination) throws AnzoException {
        URI userURI = context.getOperationPrincipal().getUserURI();
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.COMBUS_MARKER, "registerTracker for {} selectorTrackers, {} datasetTrackers and " + (namedGraphTrackers == null ? 0 : namedGraphTrackers.size()) + " to destination '" + destination + "' for user " + userURI, (selectorTrackers == null ? 0 : selectorTrackers.size()), (datasetTrackersIn == null ? 0 : datasetTrackersIn.size()));
        }
        if (selectorTrackers != null) {
            for (SelectorTracker trackerObject : selectorTrackers) {
                if (trackerObject instanceof DestinationSelectorTracker) {
                    trackers.addTracker((DestinationSelectorTracker) trackerObject);
                } else {
                    SelectorTracker tracker = trackerObject;
                    trackers.addTracker(new DestinationSelectorTracker(destination, userURI, tracker.getSubject(), tracker.getPredicate(), tracker.getObject(), tracker.getNamedGraphUri()));
                }
            }
        }
        if (datasetTrackersIn != null) {
            for (DatasetTracker trackerObject : datasetTrackersIn) {
                log.debug(LogUtils.COMBUS_MARKER, "registerTracker got request to add datasetTracker {}", trackerObject.getTrackerURI());
                if (trackerObject instanceof DestinationDatasetTracker) {
                    addDatasetTracker(context, (DestinationDatasetTracker) trackerObject);
                } else {
                    DestinationDatasetTracker ddt = new DestinationDatasetTracker(destination, userURI, trackerObject);
                    addDatasetTracker(context, ddt);
                }
            }
        }
        if (namedGraphTrackers != null) {
            for (URI graph : namedGraphTrackers) {
                boolean ok = true;
                if (!context.getOperationPrincipal().isSysadmin()) {
                    URI namedGraphUri = datasource.getModelService().getUriForUUID(context, graph);
                    Set<URI> roles = graphRolesCache.get(graph);
                    if (roles == null) {
                        roles = datasource.getAuthorizationService().getRolesForGraph(context, namedGraphUri, Privilege.READ);
                        graphRolesCache.put(graph, roles);
                        graphRolesCache.put(namedGraphUri, roles);
                    }
                    if (!Collections.memberOf(roles, context.getOperationPrincipal().getRoles())) {
                        ok = false;
                    }
                }
                if (ok) {
                    this.namedGraphTrackers.put(graph, new DestinationNamedgraphTracker(destination, context.getOperationPrincipal().getUserURI(), graph));
                }
            }
        }
    }

    private MultiHashMap<URI, DestinationDatasetTracker> matchingDatasetTrackers(URI namedGraphUri) {
        MultiHashMap<URI, DestinationDatasetTracker> results = new MultiHashMap<URI, DestinationDatasetTracker>();
        Collection<DestinationDatasetTracker> trackers = datasetTrackers.get(namedGraphUri);
        if (trackers != null) {
            for (DestinationDatasetTracker entry : trackers) {
                results.put(entry.userUri, entry);
            }
        }
        return results;
    }

    private MultiHashMap<Destination, URI> byDestination(Collection<DestinationDatasetTracker> trackers) {
        MultiHashMap<Destination, URI> results = new MultiHashMap<Destination, URI>();
        for (DestinationDatasetTracker entry : trackers) {
            results.put(entry.destination, entry.getTrackerURI());
        }
        return results;
    }

    protected Collection<URI> getDatasetURIs(URI namedDataset) throws AnzoException {
        Collection<URI> uris = new ArrayList<URI>();
        QueryDataset uriSet = datasource.getModelService().resolveNamedDataset(context, namedDataset);
        if (uriSet != null) {
            if (uriSet.getDefaultGraphURIs() != null) {
                for (URI uri : uriSet.getDefaultGraphURIs()) {
                    uris.add(uri);
                }
            }
            if (uriSet.getNamedGraphURIs() != null) {
                for (URI uri : uriSet.getNamedGraphURIs()) {
                    uris.add(uri);
                }
            }
        }
        return uris;
    }

    private void addDatasetTracker(IOperationContext context, DestinationDatasetTracker tracker) throws AnzoException {
        if (log.isDebugEnabled()) {
            if (tracker == null) {
                log.debug(LogUtils.COMBUS_MARKER, "Trying to add null datasetTracker.");
            } else {
                log.debug(LogUtils.COMBUS_MARKER, "Adding datasetTracker " + tracker.getTrackerURI() + " with " + (tracker.getDefaultGraphs() == null ? 0 : tracker.getDefaultGraphs().size()) + " default graphs, " + (tracker.getNamedGraphs() == null ? 0 : tracker.getNamedGraphs().size()) + " named graphs, and " + (tracker.getNamedDatasets() == null ? 0 : tracker.getNamedDatasets().size()) + " named datasets for destination '" + tracker.getDestination() + "' for user " + tracker.getUserUri());
            }
        }
        if (tracker == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, "tracker");
        }
        synchronized (datasetTrackers) {
            for (URI ngURI : tracker.getDefaultGraphs()) {
                datasetTrackers.put(ngURI, tracker);
            }
            for (URI ngURI : tracker.getNamedGraphs()) {
                datasetTrackers.put(ngURI, tracker);
            }
            if (tracker.getNamedDatasets() != null) {
                for (URI dsUri : tracker.getNamedDatasets()) {
                    datasetUrisTrackers.put(dsUri, tracker);
                    datasetTrackers.put(dsUri, tracker);
                    for (URI uri : getDatasetURIs(dsUri)) {
                        datasetTrackers.put(uri, tracker);
                        tracker.namedGraphsUris.add(uri);
                    }
                    // Save this tracker instance with the expanded namedGraphsUris so that we don't have to re-expand
                    // when removing the tracker.
                    datasetExpandedTrackers.put(tracker, tracker);
                }
            }
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.COMBUS_MARKER, "After adding datasetTracker, the size of datasetTrackers map is {}.", datasetTrackers.size());
            }
        }
    }

    private void removeDatasetTracker(IOperationContext context, DestinationDatasetTracker tracker) throws AnzoException {
        log.debug(LogUtils.COMBUS_MARKER, "Removing dataset tracker {}", (tracker != null ? tracker.getTrackerURI() : null));
        if (tracker == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, "tracker");
        }
        synchronized (datasetTrackers) {
            if (tracker.getDefaultGraphs() != null) {
                for (URI ngURI : tracker.getDefaultGraphs()) {
                    datasetTrackers.remove(ngURI, tracker);
                }
            }
            if (tracker.getNamedGraphs() != null) {
                for (URI ngURI : tracker.getNamedGraphs()) {
                    datasetTrackers.remove(ngURI, tracker);
                }
            }
            if (tracker.getNamedDatasets() != null) {
                for (URI dsUri : tracker.getNamedDatasets()) {
                    datasetTrackers.remove(dsUri, tracker);
                    datasetUrisTrackers.remove(dsUri, tracker);
                    // The tracker passed into the this method is likely to not have the namedGraphsUris all filled in, so we lookup
                    // the expanded version of the tracker to remove things.
                    DestinationDatasetTracker expandedTracker = datasetExpandedTrackers.get(tracker);
                    if (expandedTracker != null) {
                        for (URI uri : expandedTracker.namedGraphsUris) {
                            datasetTrackers.remove(uri, tracker);
                        }
                    }
                    datasetExpandedTrackers.remove(tracker);
                }
            }
        }
    }

    private void removeDestination(Destination destination) {
        synchronized (datasetTrackers) {
            MultiMap<URI, DestinationDatasetTracker> toRemove = new MultiHashMap<URI, DestinationDatasetTracker>();
            for (Map.Entry<URI, Collection<DestinationDatasetTracker>> entry : datasetTrackers.entrySet()) {
                for (DestinationDatasetTracker tracker : entry.getValue()) {
                    if (tracker.getDestination().equals(destination)) {
                        toRemove.put(entry.getKey(), tracker);
                    }
                }
            }
            for (Map.Entry<URI, Collection<DestinationDatasetTracker>> entry : toRemove.entrySet()) {
                for (DestinationDatasetTracker tracker : entry.getValue()) {
                    datasetTrackers.remove(entry.getKey(), tracker);
                }
            }
        }
        synchronized (namedGraphTrackers) {
            MultiMap<URI, DestinationNamedgraphTracker> toRemove = new MultiHashMap<URI, DestinationNamedgraphTracker>();
            for (Map.Entry<URI, Collection<DestinationNamedgraphTracker>> entry : namedGraphTrackers.entrySet()) {
                for (DestinationNamedgraphTracker dest : entry.getValue()) {
                    if (dest.getDestination().equals(destination)) {
                        toRemove.put(entry.getKey(), dest);
                    }
                }
            }
            for (Map.Entry<URI, Collection<DestinationNamedgraphTracker>> entry : toRemove.entrySet()) {
                for (DestinationNamedgraphTracker dest : entry.getValue()) {
                    namedGraphTrackers.remove(entry.getKey(), dest);
                }
            }
        }
    }

    void unregisterTracker(IOperationContext context, Set<? extends SelectorTracker> selectorTrackers, Set<? extends DatasetTracker> datasetTrackersIn, Set<URI> namedGraphTrackers, Destination destination) throws AnzoException {
        URI userURI = context.getOperationPrincipal().getUserURI();
        if (selectorTrackers != null) {
            for (SelectorTracker trackerObject : selectorTrackers) {
                if (trackerObject instanceof DestinationSelectorTracker) {
                    trackers.removeTracker((DestinationSelectorTracker) trackerObject);
                } else {
                    SelectorTracker tracker = trackerObject;
                    trackers.removeTracker(new DestinationSelectorTracker(destination, userURI, tracker.getSubject(), tracker.getPredicate(), tracker.getObject(), tracker.getNamedGraphUri()));
                }
            }
        }
        if (datasetTrackersIn != null) {
            for (DatasetTracker trackerObject : datasetTrackersIn) {
                if (trackerObject instanceof DestinationDatasetTracker) {
                    removeDatasetTracker(context, (DestinationDatasetTracker) trackerObject);
                } else {
                    DestinationDatasetTracker ddt = new DestinationDatasetTracker(destination, userURI, trackerObject);
                    removeDatasetTracker(context, ddt);
                }
            }
        }
        if (namedGraphTrackers != null) {
            for (URI graph : namedGraphTrackers) {
                this.namedGraphTrackers.remove(graph, new DestinationNamedgraphTracker(destination, context.getOperationPrincipal().getUserURI(), graph));
            }
        }
    }

    public TextMessage handleMessage(IOperationContext context, Destination replyTo, String format, String operation, TextMessage request, MessageProducer messageProducer) throws JMSException, AnzoException {
        verifyCaller(context);
        if (operation != null && SerializationConstants.updateResults.equals(operation)) {
            handleTransactionMessage(context, session, request);
            return null;
        } else if (operation != null && SerializationConstants.namedGraphUpdate.equals(operation)) {
            handleNamedgraphUpdateMessage(context, session, request);
            return null;
        } else if (SerializationConstants.reset.equals(operation)) {
            reset(session);
            return null;
        }
        throw new AnzoException(ExceptionConstants.SERVER.UNKNOWN_OPERATION_ERROR, operation);
    }

    public String getQueueName() {
        return COMBUS.NOTIFICATION_UPDATES_QUEUE;
    }

    private Set<URI> getUsersForRoles(Set<URI> roles) {
        HashSet<URI> users = new HashSet<URI>();
        for (URI role : roles) {
            Collection<URI> u = userRolesCache.get(role);
            if (u != null)
                users.addAll(u);
        }
        synchronized (registeredSysadmins) {
            users.addAll(registeredSysadmins);
        }
        return users;
    }

}
