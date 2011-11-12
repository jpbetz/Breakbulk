/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.commons.collections15.CollectionUtils;
import org.openanzo.combus.CombusConnection;
import org.openanzo.combus.MessageUtils;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.IDatasetListener;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.COMBUS;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.INotificationRegistrationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.ITracker;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.impl.BaseOperationContext;
import org.openanzo.services.impl.DatasetTracker;
import org.openanzo.services.impl.SelectorTracker;
import org.openanzo.services.impl.UpdateTransaction;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manager that manages the realtime event trackers
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class RealtimeUpdateManager implements MessageListener {

    private static final Logger                     log                  = LoggerFactory.getLogger(RealtimeUpdateManager.class);

    protected boolean                               connected            = false;

    private final Set<ITransactionListener>         transactionListeners = Collections.synchronizedSet(new HashSet<ITransactionListener>());

    protected final AnzoClient                      anzoClient;

    protected final CombusConnection                combusConnection;

    protected final Map<Statement, SelectorTracker> patternToTracker;

    protected final Map<URI, DatasetTracker>        datasetToTrackers;

    protected final MemQuadStore                    quadStore;

    private final ReentrantReadWriteLock            trackerLock          = new ReentrantReadWriteLock();

    private final ReentrantReadWriteLock            transactionLock      = new ReentrantReadWriteLock();

    protected RealtimeUpdateManager(AnzoClient client) {
        this.anzoClient = client;
        this.combusConnection = client.clientDatasource.getCombusConnection();
        quadStore = new MemQuadStore();
        patternToTracker = new HashMap<Statement, SelectorTracker>();
        datasetToTrackers = new HashMap<URI, DatasetTracker>();

    }

    /**
     * Checks if a tracker is registered for the provided pattern.
     * 
     * @param subject
     *            The subject or null for wildcard.
     * @param predicate
     *            The predicate or null for wildcard.
     * @param object
     *            The object or null for wildcard.
     * @param namedGraphUri
     *            The namedGraphUri or null for wildcard.
     * @return true if there is a tracker that matches the pattern
     */
    boolean containsTracker(Resource subject, URI predicate, Value object, URI namedGraphUri) {
        return patternToTracker.containsKey(Constants.valueFactory.createMatchStatement(subject, predicate, object, namedGraphUri));
    }

    /**
     * Add an {@link ITransactionListener} that is notified when ever a transaction event occurs on the server
     * 
     * @param listener
     *            lister to be notified
     * @throws AnzoException
     */
    public void addTransactionListener(ITransactionListener listener) throws AnzoException {
        transactionListeners.add(listener);
        if (transactionListeners.size() == 1 && connected) {
            try {
                combusConnection.registerTopicListener(COMBUS.TRANSACTIONS_TOPIC, this);
            } catch (AnzoException ae) {
                transactionListeners.remove(listener);
            }
        }
    }

    /**
     * Unregister an {@link ITransactionListener}
     * 
     * @param listener
     *            listener to unregister
     * @throws AnzoException
     */
    public void removeTransactionListener(ITransactionListener listener) throws AnzoException {
        transactionListeners.remove(listener);
        if (transactionListeners.size() == 0 && connected) {
            try {
                combusConnection.unregisterTopicListener(COMBUS.TRANSACTIONS_TOPIC);
            } catch (AnzoException ae) {
                transactionListeners.remove(listener);
            }
        }
    }

    void notifyTransactionListeners(IUpdateTransaction update) throws AnzoException {
        IDataset dataset = new Dataset();
        if (update.getTransactionContext() != null) {
            for (Statement stmt : update.getTransactionContext()) {
                URI namedGraphUri = stmt.getNamedGraphUri();
                if (!dataset.containsNamedGraph(namedGraphUri)) {
                    dataset.addNamedGraph(namedGraphUri);
                }
                dataset.add(stmt);
            }
        }
        synchronized (transactionListeners) {
            for (ITransactionListener listener : transactionListeners) {
                listener.transactionComplete(update.getURI(), update.getTransactionTimestamp(), anzoClient.convertUUIDSToNamedGraphURIs(update.getUpdatedNamedGraphRevisions().keySet()), dataset);
            }
        }
    }

    /**
     * Adds a tracker for the provided pattern (subject, predicate, object and namedGraphUri). Registers the provided listener to receive events about quads
     * matching the pattern.
     * 
     * @param subject
     *            The subject of the quad, or null to match all subjects.
     * @param predicate
     *            The predicate of the quad, or null to match all preciates.
     * @param object
     *            The object of the quad, or null to match all objects.
     * @param namedGraphUri
     *            The namedGraphUri of the quad, or null to match all namedGraphUris.
     * @param listener
     *            if not null, this listener is registered to receive events about quads matching the pattern of tracker.
     * @throws AnzoException
     */
    public void addTracker(Resource subject, URI predicate, Value object, URI namedGraphUri, IStatementListener<ITracker> listener) throws AnzoException {
        try {
            trackerLock.writeLock().lockInterruptibly();

            Statement statement = Constants.valueFactory.createMatchStatement(subject, predicate, object, namedGraphUri);
            SelectorTracker tracker = patternToTracker.get(statement);
            if (tracker == null) {
                tracker = new SelectorTracker(subject, predicate, object, namedGraphUri);
                patternToTracker.put(statement, tracker);
                setupTrackerNotification(tracker);
                quadStore.add(statement);
            }
            tracker.addListener(listener);
        } catch (InterruptedException e) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_LOCK_ERROR, e);
        } finally {
            trackerLock.writeLock().unlock();
        }
    }

    /**
     * Removes all trackers matching the provided pattern.
     * 
     * @param subject
     *            The subject of the quad, or null to match all subjects.
     * @param predicate
     *            The predicate of the quad, or null to match all preciates.
     * @param object
     *            The object of the quad, or null to match all objects.
     * @param namedGraphUri
     *            The namedGraphUri of the quad, or null to match all namedGraphUris.
     * @throws AnzoException
     */
    public void removeTracker(Resource subject, URI predicate, Value object, URI namedGraphUri) throws AnzoException {
        Statement pattern = Constants.valueFactory.createMatchStatement(subject, predicate, object, namedGraphUri);
        SelectorTracker tracker = patternToTracker.get(pattern);
        if (tracker != null) {
            IOperationContext context = new BaseOperationContext(INotificationRegistrationService.REGISTER_TRACKERS, BaseOperationContext.generateOperationId(), null);
            try {
                boolean regOk = anzoClient.clientDatasource.getNotificationRegistrationService().unregisterTrackers(context, Collections.<SelectorTracker> singleton(tracker), Collections.<DatasetTracker> emptySet(),Collections.<URI>emptySet(), null);
                if (!regOk) {
                    throw new AnzoException(ExceptionConstants.COMBUS.JMS_REGISTER_SELECTOR_ERROR);
                }
            } finally {
                context.clearMDC();
            }
            patternToTracker.remove(pattern);
            quadStore.remove(pattern);
        }
    }

    /**
     * Add a dataset tracker
     * 
     * @param trackerUri
     *            URI for this tracker
     * @param defaultGraphs
     *            set of default graphs to monitor in this tracker
     * @param namedGraphs
     *            set of named graphs to monitor in this tracker
     * @param namedDatasets
     *            named datasets whose graphs are to be monitored
     * @param listener
     *            Listener that is notified when one of the graphs changes
     * @throws AnzoException
     */
    public void addTracker(URI trackerUri, Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, IDatasetListener listener) throws AnzoException {
        try {
            trackerLock.writeLock().lockInterruptibly();

            DatasetTracker tracker = datasetToTrackers.get(trackerUri);
            if (tracker == null) {
                tracker = new DatasetTracker(trackerUri, defaultGraphs, namedGraphs, namedDatasets);
                datasetToTrackers.put(trackerUri, tracker);
                setupTrackerNotification(tracker);
            }
            tracker.addListener(listener);
        } catch (InterruptedException e) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_LOCK_ERROR, e);
        } finally {
            trackerLock.writeLock().unlock();
        }
    }

    /**
     * Remove the tracker based on its URI
     * 
     * @param trackerUri
     *            URI of dataset tracker to remove
     * @throws AnzoException
     */
    public void removeTracker(URI trackerUri) throws AnzoException {
        DatasetTracker tracker = datasetToTrackers.remove(trackerUri);
        if (tracker != null) {
            IOperationContext context = new BaseOperationContext(INotificationRegistrationService.REGISTER_TRACKERS, BaseOperationContext.generateOperationId(), null);
            try {
                boolean regOk = anzoClient.clientDatasource.getNotificationRegistrationService().unregisterTrackers(context, Collections.<SelectorTracker> emptySet(), Collections.<DatasetTracker> singleton(tracker),Collections.<URI>emptySet(), null);
                if (!regOk) {
                    throw new AnzoException(ExceptionConstants.COMBUS.JMS_REGISTER_SELECTOR_ERROR);
                }
            } finally {
                context.clearMDC();
            }
        }
    }

    /**
     * Removes the given listener from the tracker matching the given pattern
     * 
     * @param subject
     *            The subject of the quad, or null to match all subjects.
     * @param predicate
     *            The predicate of the quad, or null to match all preciates.
     * @param object
     *            The object of the quad, or null to match all objects.
     * @param namedGraphUri
     *            The namedGraphUri of the quad, or null to match all namedGraphUris.
     * @param listener
     *            Listener to unregister from the given tracker pattern
     * @throws AnzoException
     */
    public void removeTrackerListener(Resource subject, URI predicate, Value object, URI namedGraphUri, IStatementListener<ITracker> listener) throws AnzoException {
        SelectorTracker tracker = patternToTracker.get(Constants.valueFactory.createMatchStatement(subject, predicate, object, namedGraphUri));
        if (tracker != null) {
            tracker.removeListener(listener);
            if (tracker.getListeners().isEmpty()) {
                removeTracker(subject, predicate, object, namedGraphUri);
            }
        }
    }

    /**
     * Remove a listener for the given dataset tracker
     * 
     * @param trackerUri
     *            URI of the dataset tracker from which to unregister
     * @param listener
     *            listener to unregister
     * @throws AnzoException
     */
    public void removeTrackerListener(URI trackerUri, IDatasetListener listener) throws AnzoException {
        DatasetTracker tracker = datasetToTrackers.get(trackerUri);
        if (tracker != null) {
            tracker.removeListener(listener);
            if (tracker.getListeners().isEmpty()) {
                removeTracker(trackerUri);
            }
        }
    }

    /**
     * Registers with the server to receive notifications of quads matching this tracker's pattern if notification is enabled.
     * 
     * @param tracker
     *            The tracker to register.
     * @throws AnzoException
     */
    private void setupTrackerNotification(SelectorTracker tracker) throws AnzoException {
        if (anzoClient.isConnected()) {
            IOperationContext context = new BaseOperationContext(INotificationRegistrationService.REGISTER_TRACKERS, BaseOperationContext.generateOperationId(), anzoClient.getServicePrincipal());
            try {
                boolean regOk = anzoClient.clientDatasource.getNotificationRegistrationService().registerTrackers(context, Collections.<SelectorTracker> singleton(tracker), Collections.<DatasetTracker> emptySet(), Collections.<URI> emptySet(), null);
                if (!regOk) {
                    throw new AnzoException(ExceptionConstants.COMBUS.JMS_REGISTER_SELECTOR_ERROR);
                }
            } finally {
                context.clearMDC();
            }
        }
    }

    private void setupTrackerNotification(DatasetTracker tracker) throws AnzoException {
        if (anzoClient.isConnected()) {
            IOperationContext context = new BaseOperationContext(INotificationRegistrationService.REGISTER_TRACKERS, BaseOperationContext.generateOperationId(), null);
            try {
                boolean regOk = anzoClient.clientDatasource.getNotificationRegistrationService().registerTrackers(context, Collections.<SelectorTracker> emptySet(), Collections.<DatasetTracker> singleton(tracker), Collections.<URI> emptySet(), null);
                if (!regOk) {
                    throw new AnzoException(ExceptionConstants.COMBUS.JMS_REGISTER_SELECTOR_ERROR);
                }
            } finally {
                context.clearMDC();
            }
        }
    }

    /**
     * Notifies the trackers of statement changes.
     * 
     * @param addition
     *            If true then the event is for addition of a new statement, if false then deletion of a statement.
     * @param statement
     *            The statement that was added or removed.
     */
    private void notifyTrackers(boolean addition, Statement statement) {
        Collection<Statement> result = this.findMatchingPatterns(statement);

        for (Statement stmt : result) {
            SelectorTracker tracker = patternToTracker.get(stmt);
            if (tracker != null) {
                tracker.notifyListeners(addition, statement);
            }
        }
    }

    private void notifyTrackers(URI namedGraphUri, Collection<URI> datasetUris) {
        for (URI datasetURI : datasetUris) {
            DatasetTracker tracker = datasetToTrackers.get(datasetURI);
            if (tracker != null) {
                tracker.notifyListeners(namedGraphUri);
            }
        }
    }

    /**
     * Finds all the tracker patterns that match the provided statements.
     * 
     * Implementation:
     * 
     * Trackers are stored as quads in a quad store, allowing the find operation to be use to find the matching trackers.
     * 
     * Nodes in a tracker pattern may be the special "ANY_URI", indicating the node in the quad is a wildcard.
     * 
     * The matching trackers are found as follows:
     * 
     * <pre>
     * (INTERSECTION
     *  (UNION trackers-with-matching-subject trackers-with-wildcard-subject)
     *  (UNION trackers-with-matching-predicate trackers-with-wildcard-predicate)
     *  (UNION trackers-with-matching-object trackers-with-wildcard-object)
     *  (UNION trackers-with-matching-namedGraphUri trackers-with-wildcard-namedGraphUri))
     * </pre>
     * 
     * @param statement
     *            The statement find matching tracker patterns for.
     * @return The tracker patterns matching the provided statement.
     */
    protected Collection<Statement> findMatchingPatterns(Statement statement) {

        Collection<Statement> subjectExactMatches = quadStore.find(statement.getSubject(), null, null, (URI[]) null);
        Collection<Statement> subjectWildcardMatches = quadStore.find(Constants.ANY_URI, null, null, (URI[]) null);

        // UNION exact and wildcard matches of the statements subject
        Collection<Statement> subjectMatches = CollectionUtils.union(subjectExactMatches, subjectWildcardMatches);

        Collection<Statement> predicateExactMatches = quadStore.find(null, statement.getPredicate(), null, (URI[]) null);
        Collection<Statement> predicateWildcardMatches = quadStore.find(null, Constants.ANY_URI, null, (URI[]) null);

        // UNION exact and wildcard matches of the statements predicate
        Collection<Statement> predicateMatches = CollectionUtils.union(predicateExactMatches, predicateWildcardMatches);

        Collection<Statement> objectExactMatches = quadStore.find(null, null, statement.getObject(), (URI[]) null);
        Collection<Statement> objectWildcardMatches = quadStore.find(null, null, Constants.ANY_URI, (URI[]) null);

        // UNION exact and wildcard matches of the statements object
        Collection<Statement> objectMatches = CollectionUtils.union(objectExactMatches, objectWildcardMatches);

        Collection<Statement> namedGraphExactMatches = quadStore.find(null, null, null, statement.getNamedGraphUri());
        Collection<Statement> namedGraphWildcardMatches = quadStore.find(null, null, null, Constants.ANY_URI);

        // UNION exact and wildcard matches of the statements namedGraphUri
        Collection<Statement> namedGraphMatches = CollectionUtils.union(namedGraphExactMatches, namedGraphWildcardMatches);

        // INTERSECTION of the unions
        Collection<Statement> intersection = CollectionUtils.intersection(CollectionUtils.intersection(CollectionUtils.intersection(subjectMatches, predicateMatches), objectMatches), namedGraphMatches);

        return intersection;
    }

    protected void connect() throws AnzoException {
        IOperationContext context = null;
        try {
            context = new BaseOperationContext(INotificationRegistrationService.REGISTER_SUBSCRIBER, BaseOperationContext.generateOperationId(), anzoClient.getServicePrincipal());
            boolean regOk = anzoClient.clientDatasource.getNotificationRegistrationService().registerSubscriber(context, null);
            if (!regOk) {
                throw new AnzoException(ExceptionConstants.COMBUS.SERVER_CONNECT_EXCEPTION);
            }
            this.combusConnection.registerMessageListener(this);
            for (Statement pattern : patternToTracker.keySet()) {
                SelectorTracker tracker = patternToTracker.get(pattern);
                setupTrackerNotification(tracker);
            }
            if (transactionListeners.size() > 0) {
                combusConnection.registerTopicListener(COMBUS.TRANSACTIONS_TOPIC, this);
            }
            connected = true;
        } finally {
            if (context != null) {
                context.clearMDC();
            }
        }
    }

    protected void disconnect(boolean enableReconnect, boolean clean) throws AnzoException {
        IOperationContext context = null;
        try {
            connected = false;
            if (clean && combusConnection.isConnected()) {
                context = new BaseOperationContext(INotificationRegistrationService.UNREGISTER_SUBSCRIBER, BaseOperationContext.generateOperationId(), null);
                anzoClient.clientDatasource.getNotificationRegistrationService().unregisterSubscriber(context, null);
                if (transactionListeners.size() > 0) {
                    combusConnection.unregisterTopicListener(COMBUS.TRANSACTIONS_TOPIC);
                }
                this.combusConnection.unregisterMessageListener(this);
            }

            if (!enableReconnect) {
                quadStore.clear();
                patternToTracker.clear();
            }
        } finally {
            if (context != null) {
                context.clearMDC();
            }
        }
    }

    public void onMessage(final Message message) {
        if (message == null) {
            log.error(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "null message"), new AnzoException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING));
            return;
        }
        try {
            if (log.isTraceEnabled()) {
                log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(message, "Notification Recieved: "));
            }
            String operation = message.getStringProperty(SerializationConstants.operation);
            if (operation != null) {
                if (operation.equals(SerializationConstants.transactionComplete)) {
                    handleTransactionMessage(message);
                } else if (SerializationConstants.updateResults.equals(operation)) {
                    handleUpdateMessage(message);
                } else if (SerializationConstants.datasetUpdate.equals(operation)) {
                    handleDatasetUpdateMessage(message);
                }
            }

        } catch (JMSException jmsex) {
            log.error(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "realtime update message"), jmsex);
        } catch (AnzoException e) {
            log.error(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "realtime update message"), e);
        }

    }

    // Normal update message. Iterate through those who have permission.
    protected void handleUpdateMessage(Message message) throws AnzoException {
        try {
            if (!message.propertyExists(SerializationConstants.method)) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER);
            }
            if (!message.propertyExists(SerializationConstants.subject)) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER);
            }
            if (!message.propertyExists(SerializationConstants.predicate)) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER);
            }
            if (!message.propertyExists(SerializationConstants.namedGraphUri)) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER);
            }
            if (!message.propertyExists(SerializationConstants.object)) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER);
            }
            boolean method = message.getBooleanProperty(SerializationConstants.method);
            // Extract statement info from message.
            String predicateUri = message.getStringProperty(SerializationConstants.predicate);
            String namedGraph = message.getStringProperty(SerializationConstants.namedGraphUri);

            // Construct  statement.
            Value object = CommonSerializationUtils.getObjectFromMessage(message);
            if (object == null) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER);
            }
            Resource subject = CommonSerializationUtils.getSubjectFromMessage(message);
            if (subject == null) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER);
            }
            URI predicate = Constants.valueFactory.createURI(predicateUri);
            URI namedGraphUri = Constants.valueFactory.createURI(namedGraph);
            URI graphURI = namedGraphUri;
            Statement stmt = Constants.valueFactory.createStatement(subject, predicate, object, graphURI);
            notifyTrackers(method, stmt);
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, jmsex);
        }
    }

    // Normal update message. Iterate through those who have permission.
    protected void handleDatasetUpdateMessage(Message message) throws AnzoException {
        try {
            if (!message.propertyExists(SerializationConstants.datasetUri)) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER);
            }
            if (!message.propertyExists(SerializationConstants.namedGraphUri)) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER);
            }
            String namedGraph = message.getStringProperty(SerializationConstants.namedGraphUri);
            String datasetUris = message.getStringProperty(SerializationConstants.datasetUri);
            Collection<URI> uris = new ArrayList<URI>();
            StringTokenizer st = new StringTokenizer(datasetUris, ",");
            while (st.hasMoreTokens()) {
                uris.add(Constants.valueFactory.createURI(st.nextToken()));
            }
            notifyTrackers(Constants.valueFactory.createURI(namedGraph), uris);
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, jmsex);
        }
    }

    // End of transaction.
    protected void handleTransactionMessage(Message message) throws AnzoException {
        // Extract method and transactionId.
        String transactionContextString = null;
        try {
            transactionContextString = message.propertyExists(SerializationConstants.transactionContext) ? message.getStringProperty(SerializationConstants.transactionContext) : null;
        } catch (JMSException e) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, e);
        }
        String updatedNamedGraphs = null;
        try {
            updatedNamedGraphs = message.propertyExists(SerializationConstants.namedGraphUpdates) ? message.getStringProperty(SerializationConstants.namedGraphUpdates) : null;
        } catch (JMSException e) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, e);
        }
        long timestamp = -1;
        try {
            timestamp = Long.valueOf(message.getLongProperty(SerializationConstants.transactionTimestamp));
        } catch (JMSException e) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, e);
        }
        String transactionUri = null;
        try {
            transactionUri = message.propertyExists(SerializationConstants.transactionURI) ? message.getStringProperty(SerializationConstants.transactionURI) : null;
        } catch (JMSException e) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, e);
        }
        URI transactionURI = (transactionUri != null) ? MemURI.create(transactionUri) : null;
        transactionLock.writeLock().lock();
        try {
            Collection<Statement> context = null;
            if (transactionContextString != null) {
                context = ReadWriteUtils.readStatements(transactionContextString, RDFFormat.JSON);
            }
            Map<URI, Long> updatedGraphs = null;
            if (updatedNamedGraphs != null) {
                updatedGraphs = CommonSerializationUtils.readNamedGraphRevisions(updatedNamedGraphs);
            }
            UpdateTransaction transaction = new UpdateTransaction(transactionURI, timestamp, context, updatedGraphs);
            notifyTransactionListeners(transaction);
        } finally {
            transactionLock.writeLock().unlock();
        }
    }
}
