/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/repository/update/ServerUpdatesProcessor.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/5/2006
 * Revision:    $Id: ServerUpdatesProcessor.java 180 2007-07-31 14:24:13Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.update;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections15.MultiMap;
import org.apache.commons.collections15.multimap.MultiHashMap;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IQueryService;
import org.openanzo.datasource.IServerQuadStore;
import org.openanzo.datasource.IStoredNamedGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.CompoundAnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.IAuthorizationEventListener;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.impl.AskResult;
import org.openanzo.services.impl.UpdateTransaction;
import org.openanzo.services.impl.Updates;
import org.openanzo.services.serialization.IUpdatesHandler;
import org.openanzo.services.serialization.IUpdatesReader;
import org.openanzo.services.serialization.NamedGraphUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ServerUpdatesProcessor handles updates sent from the client, and applies them to the server
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class MultiStageUpdatesProcessor {
    /**
     * The interface that ServerQuadStores implement in order to handle the contents of update transactions
     */
    public interface NamedGraphUpdateHandler {
        /**
         * Handle a statement
         * 
         * @param addition
         *            is this an addition or a deletion
         * @param metadata
         *            is this a metadata statement
         * @param statement
         *            statement to process
         * @return true if the statement is handled
         * @throws AnzoException
         */
        public boolean handleStatement(boolean addition, boolean metadata, Statement statement) throws AnzoException;

        /**
         * Handle named graph info
         * 
         * @param namedGraphUri
         *            URI of namedGraph
         * @param metadataGraphUri
         *            URI of metadataGraph
         * @param aclAdditionSet
         *            Set of acl additions
         * @param aclRemovalSet
         *            Set of acl removals
         * @param revisioned
         *            Is this graph revisioned
         * @param persisted
         *            Is this graph persisted
         * @param metaStatements
         *            Metadata statements about namedGraph
         * @return true if the namedgraph is handled
         * @throws AnzoException
         */
        public boolean handleAddNamedGraph(URI namedGraphUri, URI metadataGraphUri, AclSet aclAdditionSet, AclSet aclRemovalSet, boolean revisioned, boolean persisted, Collection<Statement> metaStatements) throws AnzoException;

        /**
         * Handle removing a namedGraph
         * 
         * @param namedGraphUri
         *            URI of namedGraph
         * @return true if namedgraph removal is handled
         * @throws AnzoException
         */
        public boolean handleRemoveNamedGraph(URI namedGraphUri) throws AnzoException;

        /**
         * Handle adding an acl privilege
         * 
         * @param statement
         *            acl statement
         * @return true if privilege is added
         * @throws AnzoException
         */
        public boolean handleAddPrivilege(Statement statement) throws AnzoException;

        /**
         * Handle removing an acl privilege
         * 
         * @param statement
         *            acl statement
         * @return true if privilege is removed
         * @throws AnzoException
         */
        public boolean handleRemovePrivilege(Statement statement) throws AnzoException;
    }

    static class AclSet {
        final MultiMap<URI, Statement> aclMap = new MultiHashMap<URI, Statement>();

        void add(Statement statement) {
            aclMap.put(statement.getPredicate(), statement);
        }

        int size() {
            return aclMap.size();
        }
    }

    private static final Logger                           log                             = LoggerFactory.getLogger(MultiStageUpdatesProcessor.class);

    private static final String                           ERROR_PROCESSING_UPDATE         = "Error Processing Update:";

    private final IQueryService                           queryService;

    private final IAuthorizationService                   authorizationService;

    private final Collection<IAuthorizationEventListener> eventListeners;

    private final IOperationContext                       context;

    /** UpdateResults to which updates are written */
    private final Updates                                 updateResults;

    /** TransactionUpdateResults for the current Transaction */
    private ServerUpdateTransaction                       currentTransactionUpdateResults = null;

    /** Flag to keep track if anything has changed during the current transaction */
    private boolean                                       transactionChangeHappend        = false;

    private final IServerQuadStore                        backend;

    private Set<URI>                                      affectedNamedGraphs             = null;

    private final Set<URI>                                failedTransactionGraphs         = new HashSet<URI>();

    private static final Random                           random                          = new Random();

    private final boolean                                 reseting;

    private boolean                                       aborted                         = false;

    /**
     * Process a set of IUpdateTransactions and return results
     * 
     * @param context
     *            NodeCentric specific context, which contains connection to run queries against
     * @param backend
     *            The backend store to which this update processor will apply changes
     * @param queryService
     *            reference to the IQueryService, used for precondition checks
     * @param authorizationService
     *            reference to the authorization service used to check permission on graphs
     * @param eventListeners
     *            Listeners that are notified about updates
     * @param transactions
     *            Array of IUpdateTransactions to commit
     * @param resetting
     *            Is the server resetting
     * @return UpdateResults from update
     * @throws AnzoException
     */
    public static Updates update(IOperationContext context, IServerQuadStore backend, IQueryService queryService, IAuthorizationService authorizationService, Collection<IAuthorizationEventListener> eventListeners, IUpdates transactions, boolean resetting) throws AnzoException {
        try {
            Updates updateResults = new Updates(context.getOperationId());
            MultiStageUpdatesProcessor sup = new MultiStageUpdatesProcessor(context, backend, queryService, authorizationService, eventListeners, updateResults, resetting);
            for (IUpdateTransaction transaction : transactions.getTransactions()) {
                sup.handleTransaction(transaction);
            }
            return updateResults;
        } finally {
            backend.close();
        }
    }

    /**
     * Process a set of IUpdateTransactions contained in InputStream and return results
     * 
     * @param context
     *            NodeCentric specific context, which contains connection to run queries against
     * @param backend
     *            backend for data
     * @param queryService
     *            reference to the IQueryService, used for precondition checks
     * @param authorizationService
     *            reference to the authorization service used to check permission on graphs
     * @param eventListeners
     *            set of listeners that listen for ACL events
     * 
     * @param reader
     *            InputStream containing transactions
     * @param resetting
     *            Is the server resetting
     * @return UpdateResults from transactions
     * @throws AnzoException
     */
    public static Updates update(IOperationContext context, IServerQuadStore backend, IQueryService queryService, IAuthorizationService authorizationService, Collection<IAuthorizationEventListener> eventListeners, IUpdatesReader reader, boolean resetting) throws AnzoException {
        try {
            Updates updateResults = new Updates(context.getOperationId());
            MultiStageUpdatesProcessor serverUpdateProcessor = new MultiStageUpdatesProcessor(context, backend, queryService, authorizationService, eventListeners, updateResults, resetting);
            serverUpdateProcessor.read(reader);
            return updateResults;
        } finally {
            backend.close();
        }

    }

    /**
     * Process a set of IUpdateTransactions and return results
     * 
     * @param context
     *            NodeCentric specific context, which contains connection to run queries against
     * @param backend
     *            backend for data
     * @param queryService
     *            reference to the IQueryService, used for precondition checks
     * @param authorizationService
     *            reference to the authorization service used to check permission on graphs
     * @param eventListeners
     *            set of listeners that listen for ACL events
     * @param statements
     *            Data to add to server
     * @param graphTemplate
     *            Template of statements for creating a new graph
     * @param reseting
     *            Is the server resetting
     * @param bulkUpdate
     *            Is this a bulk update
     * @return UpdateResults from update
     * @throws AnzoException
     */
    public static Updates update(IOperationContext context, IServerQuadStore backend, IQueryService queryService, IAuthorizationService authorizationService, Collection<IAuthorizationEventListener> eventListeners, MultiMap<URI, Statement> statements, Collection<Statement> graphTemplate, boolean reseting, boolean bulkUpdate) throws AnzoException {
        long start = System.currentTimeMillis();
        IUpdates updates = convertStatementsToUpdates(context, bulkUpdate, statements, graphTemplate, backend);
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.TIMING_MARKER, "MULTISTAGE_UPDATEPROC CONVERT,{},{}", Long.toString(System.currentTimeMillis() - start), statements.size());
        }
        Updates results = update(context, backend, queryService, authorizationService, eventListeners, updates, reseting);
        return results;
    }

    /**
     * Create a new ServerUpdatesProcessor
     * 
     * @param context
     *            NodeCentric specific context, which contains connection to run queries against
     * @param queryService
     *            reference to the query service used for precondition checks
     * @param authorizationService
     *            reference to the authorization service used to check permission on graphs
     * @param eventListeners
     *            set of listeners that listen for ACL events
     * @param updateResults
     *            UpdateResults to which updates are written
     * @param isReseting
     *            true if server is in the process of resetting
     * @throws AnzoException
     */
    private MultiStageUpdatesProcessor(IOperationContext context, IServerQuadStore backend, IQueryService queryService, IAuthorizationService authorizationService, Collection<IAuthorizationEventListener> eventListeners, Updates updateResults, boolean isReseting) throws AnzoException {
        this.context = context;
        this.updateResults = updateResults;
        this.queryService = queryService;
        this.authorizationService = authorizationService;
        this.eventListeners = eventListeners;
        this.backend = backend;
        this.reseting = isReseting;
    }

    /**
     * Read updates from an InputStream
     * 
     * @param reader
     *            InputStream containing updates
     * @throws AnzoException
     */
    private void read(IUpdatesReader reader) throws AnzoException {
        try {
            reader.read(new IUpdatesHandler() {
                public void start() throws AnzoException {
                }

                public void handleTransaction(IUpdateTransaction transaction) throws AnzoException {
                    MultiStageUpdatesProcessor.this.handleTransaction(transaction);
                }

                public void end() throws AnzoException {
                }
            });
        } catch (AnzoException ae) {
            log.error(LogUtils.DATASOURCE_MARKER, ERROR_PROCESSING_UPDATE, ae);
            AnzoException throwing = null;
            if (currentTransactionUpdateResults != null) {
                currentTransactionUpdateResults.handleError(ae.getErrorCode(), ae.getArgs());
                try {
                    backend.abort();
                } catch (AnzoException ae2) {
                    throwing = new CompoundAnzoException(ae, ae2);
                }
            }
            throw (throwing != null) ? throwing : ae;
        } catch (AnzoRuntimeException ae) {
            log.error(LogUtils.DATASOURCE_MARKER, ERROR_PROCESSING_UPDATE, ae);
            AnzoException throwing = null;
            if (currentTransactionUpdateResults != null) {
                currentTransactionUpdateResults.handleError(ae.getErrorCode(), ae.getArgs());
                try {
                    backend.abort();
                } catch (AnzoException ae2) {
                    throwing = new CompoundAnzoException(ae.getAnzoException(), ae2);
                }
            }
            throw (throwing != null) ? throwing : ae.getAnzoException();
        }
    }

    /**
     * Abort the current transaction
     * 
     * @throws AnzoException
     *             if there was a problem aborting this update
     */
    private void abort() throws AnzoException {
        if (!aborted) {
            aborted = true;
            backend.abort();
        }
    }

    /**
     * Create a new transaction with given ID and add it list of transactions
     * 
     * @param transactionId
     *            ID of transaction
     * @param timestamp
     *            timestamp of transaction
     * @return a TransactionUpdateResults with given ID
     */

    private ServerUpdateTransaction nextTransaction(URI transactionURI, Collection<Statement> transactionContext) throws AnzoException {
        long nextId = random.nextLong();
        ServerUpdateTransaction tur = new ServerUpdateTransaction(context, System.currentTimeMillis(), nextId, transactionURI, transactionContext);
        updateResults.getTransactions().add(tur);
        return tur;
    }

    private void handleTransaction(IUpdateTransaction transaction) throws AnzoException {
        if (transaction.getNamedGraphUpdates() != null && transaction.getNamedGraphUpdates().size() > 0) {
            long start = System.currentTimeMillis();
            try {
                handleTransactionStart(transaction.getURI(), transaction.getNamedGraphs(), transaction.getTransactionContext(), transaction.getPreconditions());
                long start1 = System.currentTimeMillis();

                for (INamedGraphUpdate update : transaction.getNamedGraphUpdates()) {
                    ServerQuadStoreUpdateHandler sqsuh = new ServerQuadStoreUpdateHandler(backend, currentTransactionUpdateResults, authorizationService, reseting);
                    MultiStageUpdatesProcessor.handleNamedGraphUpdate(reseting, update, sqsuh);
                }
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.TIMING_MARKER, "[UPDATE-PRE_TRANSACTION_COMMIT],{}", (System.currentTimeMillis() - start1));
                }
                handleTransactionEnd();
            } catch (AnzoException t) {
                log.warn(LogUtils.DATASOURCE_MARKER, ERROR_PROCESSING_UPDATE, t);
                for (INamedGraphUpdate ngUpdate : transaction.getNamedGraphUpdates()) {
                    failedTransactionGraphs.add(ngUpdate.getNamedGraphURI());
                }
                abort();
                getCurrentTransactionUpdateResults().handleError(t.getErrorCode(), t.getArgs());
            } catch (AnzoRuntimeException ae) {
                log.warn(LogUtils.DATASOURCE_MARKER, ERROR_PROCESSING_UPDATE, ae.getAnzoException());
                for (INamedGraphUpdate ngUpdate : transaction.getNamedGraphUpdates()) {
                    failedTransactionGraphs.add(ngUpdate.getNamedGraphURI());
                }
                abort();
                getCurrentTransactionUpdateResults().handleError(ae.getAnzoException().getErrorCode(), ae.getAnzoException().getArgs());
            } finally {
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.TIMING_MARKER, "[TRANSACTION_TOTAL],{}", (System.currentTimeMillis() - start));
                }
            }
        }
    }

    static long started = 0;

    private boolean handleTransactionStart(URI transactionURI, Set<URI> affectedNamedGraphs, Collection<Statement> transactionContext, Collection<IPrecondition> preconditions) throws AnzoException {
        transactionChangeHappend = false;
        this.affectedNamedGraphs = affectedNamedGraphs;
        this.aborted = false;

        currentTransactionUpdateResults = nextTransaction(transactionURI, transactionContext);
        backend.beginTransaction(currentTransactionUpdateResults.getTransactionId(), currentTransactionUpdateResults.getURI(), affectedNamedGraphs, currentTransactionUpdateResults.getTransactionContext());

        for (URI uri : affectedNamedGraphs) {
            if (failedTransactionGraphs.contains(uri)) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.PREVIOUS_TRANSACTION_FAILED, uri.toString());
            }
        }

        if (preconditions != null) {
            for (IPrecondition precondition : preconditions) {
                try {
                    if (!(queryService.askQuery(context, precondition.getDefaultGraphUris(), precondition.getNamedGraphUris(), null, precondition.getQuery(), null, null, true) == ((AskResult) precondition.getResult()).getResultValue())) {
                        throw new AnzoException(ExceptionConstants.DATASOURCE.COMMAND_PREREQ_FAILED, transactionURI.toString(), precondition.getQuery());
                    }
                } catch (GlitterRuntimeException uge) {
                    if (((AskResult) precondition.getResult()).getResultValue()) {
                        throw new AnzoException(ExceptionConstants.DATASOURCE.COMMAND_PREREQ_FAILED, uge, transactionURI.toString(), precondition.getQuery());
                    }
                }
            }
        }
        return true;
    }

    private boolean handleTransactionEnd() throws AnzoException {
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.TIMING_MARKER, "Total PROCESS TRANSACTION,{}", Long.valueOf((System.currentTimeMillis() - currentTransactionUpdateResults.getTransactionTimestamp())));
        }
        long tStart = System.currentTimeMillis();
        if (!currentTransactionUpdateResults.hasError()) {
            try {
                URI userURI = (currentTransactionUpdateResults.getServerPrincipal() != null) ? currentTransactionUpdateResults.getServerPrincipal().getUserURI() : Constants.DEFAULT_INTERNAL_USER;
                org.openanzo.datasource.update.UpdateChanges quadResults = new org.openanzo.datasource.update.UpdateChanges();
                backend.insertUpdates(quadResults, currentTransactionUpdateResults.getTransactionTimestamp(), userURI);

                if (quadResults.removedStatements.size() > 0) {
                    Integer countA = context.getAttribute("countRemove", Integer.class);
                    if (countA == null) {
                        countA = Integer.valueOf(quadResults.removedStatements.size());
                    } else {
                        countA = Integer.valueOf(countA.intValue() + quadResults.removedStatements.size());
                    }
                    context.setAttribute("countRemove", countA);
                    currentTransactionUpdateResults.removeStatement(quadResults.removedStatements);
                    transactionChangeHappend = true;
                }
                if (quadResults.addedStatements.size() > 0) {
                    Integer countA = context.getAttribute("countAdd", Integer.class);
                    if (countA == null) {
                        countA = Integer.valueOf(quadResults.addedStatements.size());
                    } else {
                        countA = Integer.valueOf(countA.intValue() + quadResults.addedStatements.size());
                    }
                    context.setAttribute("countAdd", countA);
                    currentTransactionUpdateResults.addStatement(quadResults.addedStatements);
                    transactionChangeHappend = true;
                }
                for (IStoredNamedGraph storedGraph : quadResults.namedGraphs) {
                    currentTransactionUpdateResults.getUpdatedNamedGraphRevisions().put(storedGraph.getUUID(), storedGraph.getRevision());
                    currentTransactionUpdateResults.getUpdatedNamedGraphs().put(storedGraph.getURI(), storedGraph.getUUID());
                    INamedGraphUpdate update = currentTransactionUpdateResults.getNamedGraphUpdate(storedGraph.getURI());
                    update.setRevision(storedGraph.getRevision());
                    update.setUUID(storedGraph.getUUID());
                    transactionChangeHappend = true;
                }
                if (quadResults.removedNamedGraphs.size() > 0) {
                    currentTransactionUpdateResults.getRemovedNamedGraphs().putAll(quadResults.removedNamedGraphs);
                    transactionChangeHappend = true;
                }
                if (transactionChangeHappend) {
                    long start = System.currentTimeMillis();
                    backend.commitTransaction(currentTransactionUpdateResults, affectedNamedGraphs);
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.TIMING_MARKER, "COMMIT TRANSACTION,{}", Long.valueOf((System.currentTimeMillis() - start)));
                    }
                    if (eventListeners != null) {
                        for (IAuthorizationEventListener listener : eventListeners) {
                            listener.handleAuthorizationUpdates(currentTransactionUpdateResults.getAclAdditions(), currentTransactionUpdateResults.getAclRemovals());
                        }
                    }
                } else {
                    abort();
                }
                this.affectedNamedGraphs = null;
            } catch (AnzoException ae) {
                AnzoException throwing = null;
                try {
                    abort();
                } catch (AnzoException ae2) {
                    throwing = new CompoundAnzoException(ae, ae2);
                }
                throw (throwing != null) ? throwing : ae;
            }
        } else {
            abort();
        }
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.TIMING_MARKER, "PROCESS TRANSACTION END,{}", Long.valueOf((System.currentTimeMillis() - tStart)));
        }
        return true;

    }

    /**
     * @return the currentTransactionUpdateResults
     */
    private ServerUpdateTransaction getCurrentTransactionUpdateResults() {
        return currentTransactionUpdateResults;
    }

    static private void handleNamedGraphUpdate(boolean resetting, INamedGraphUpdate update, MultiStageUpdatesProcessor.NamedGraphUpdateHandler handler) throws AnzoException {
        if (!resetting && update.getNamedGraphURI().equals(Constants.GRAPHS.GRAPHS_DATASET) && (update.getAdditions().size() > 0 || update.getRemovals().size() > 0)) {
            throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.CANNOT_WRITE_TO_A_SYSTEM_GRAPH, Constants.GRAPHS.GRAPHS_DATASET.toString());
        } else if (!resetting && update.getNamedGraphURI().equals(Constants.GRAPHS.METADATA_GRAPHS_DATASET) && (update.getAdditions().size() > 0 || update.getRemovals().size() > 0)) {
            throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.CANNOT_WRITE_TO_A_SYSTEM_GRAPH, Constants.GRAPHS.METADATA_GRAPHS_DATASET.toString());
        }
        if (update.getMetaRemovals().size() > 0) {
            handleNamedGraphGraph(update.getNamedGraphURI(), update.getMetaRemovals(), false, handler);
        }
        if (update.getMetaAdditions().size() > 0) {
            handleNamedGraphGraph(update.getNamedGraphURI(), update.getMetaAdditions(), true, handler);
        }
        for (Statement stmt : update.getRemovals()) {
            handler.handleStatement(false, false, stmt);
        }
        for (Statement stmt : update.getAdditions()) {
            handler.handleStatement(true, false, stmt);
        }
    }

    private static boolean isAclResource(Statement statement) {
        boolean retval = false;
        retval = statement.getPredicate().equals(NamedGraph.canBeReadByProperty) || statement.getPredicate().equals(NamedGraph.canBeAddedToByProperty) || statement.getPredicate().equals(NamedGraph.canBeRemovedFromByProperty);
        return retval;
    }

    private static final boolean statementMatch(Statement stmt, URI predicate, Value obj) {
        return stmt.getPredicate().equals(predicate) && stmt.getObject().equals(obj);
    }

    //The statements that can be added to the metadata graph must meet the following rules:
    //The subject of the statement must be either the namedGraph's URI or the metadata graph's URI.
    //If it is the metadata graph's URI, the only additions or removals can be acl predicates.
    //Any other statement will throw an exception
    static void handleNamedGraphGraph(URI namedGraphURI, Collection<Statement> metaStatements, boolean additions, MultiStageUpdatesProcessor.NamedGraphUpdateHandler handler) throws AnzoException {
        boolean hasType = false;
        URI metadataGraphUri = UriGenerator.generateEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, namedGraphURI);
        MultiStageUpdatesProcessor.AclSet aclSet = new MultiStageUpdatesProcessor.AclSet();
        MultiStageUpdatesProcessor.AclSet metaAclSet = new MultiStageUpdatesProcessor.AclSet();
        boolean revisioned = true;
        boolean persisted = true;
        for (Iterator<Statement> iterator = metaStatements.iterator(); iterator.hasNext();) {
            Statement statement = iterator.next();
            if (MultiStageUpdatesProcessor.statementMatch(statement, RDF.TYPE, NamedGraph.TYPE)) {
                iterator.remove();
                if (statement.getSubject().equals(namedGraphURI)) {
                    hasType = true;
                } else {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.INVALID_METADATA_TRIPLE, statement.toString(), metadataGraphUri.toString());
                }
            } else {
                if (statement.getSubject().equals(metadataGraphUri)) {
                    if (isAclResource(statement)) {
                        metaAclSet.add(statement);
                    } else {
                        throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.INVALID_METADATA_TRIPLE, statement.toString(), metadataGraphUri.toString());
                    }
                } else if (AnzoFactory.isNamedGraphPredicate(statement.getPredicate())) {
                    if (!statement.getSubject().equals(namedGraphURI)) {
                        throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.INVALID_METADATA_TRIPLE, statement.toString(), metadataGraphUri.toString());
                    }
                    if (isAclResource(statement)) {
                        aclSet.add(statement);
                    } else if (statement.getPredicate().equals(NamedGraph.persistedProperty)) {
                        persisted = ((Boolean) ((TypedLiteral) statement.getObject()).getNativeValue()).booleanValue();
                        iterator.remove();
                    } else if (statement.getPredicate().equals(NamedGraph.revisionedProperty)) {
                        revisioned = ((Boolean) ((TypedLiteral) statement.getObject()).getNativeValue()).booleanValue();
                        iterator.remove();
                    } else if (statement.getPredicate().equals(NamedGraph.lastModifiedByUserProperty) || statement.getPredicate().equals(NamedGraph.modifiedProperty) || statement.getPredicate().equals(NamedGraph.createdByProperty) || statement.getPredicate().equals(NamedGraph.createdProperty) || statement.getPredicate().equals(NamedGraph.uuidProperty) || statement.getPredicate().equals(NamedGraph.revisionProperty) || statement.getPredicate().equals(NamedGraph.datasourceProperty)) {
                        throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.INVALID_METADATA_TRIPLE, statement.toString(), metadataGraphUri.toString());
                    } else if (statement.getPredicate().equals(NamedGraph.hasMetadataGraphProperty)) {
                        if (!statement.getObject().equals(metadataGraphUri)) {
                            throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.INVALID_METADATA_TRIPLE, statement.toString(), metadataGraphUri.toString());
                        } else {
                            iterator.remove();
                        }
                    }
                }
            }
        }
        if (metadataGraphUri != null && hasType) {
            if (additions) {
                handler.handleAddNamedGraph(namedGraphURI, metadataGraphUri, aclSet, metaAclSet, revisioned, persisted, metaStatements);
            } else {
                handler.handleRemoveNamedGraph(namedGraphURI);
            }
        } else {
            for (Statement stmt : aclSet.aclMap.values()) {
                if (additions) {
                    handler.handleAddPrivilege(stmt);
                } else {
                    handler.handleRemovePrivilege(stmt);
                }
            }
            for (Statement stmt : metaAclSet.aclMap.values()) {
                if (additions) {
                    handler.handleAddPrivilege(stmt);
                } else {
                    handler.handleRemovePrivilege(stmt);
                }
            }
            for (Statement stmt : metaStatements) {
                handler.handleStatement(additions, false, stmt);
            }
        }

    }

    private static IUpdates convertStatementsToUpdates(IOperationContext context, boolean bulkUpdate, MultiMap<URI, Statement> statements, Collection<Statement> graphTemplate, IServerQuadStore serverQuadStore) throws AnzoException {
        IUpdates updates = new Updates(context.getOperationId());
        IUpdateTransaction transaction = new UpdateTransaction(UriGenerator.generateTransactionURI(), 0, null, null);
        updates.getTransactions().add(transaction);
        // the orderedResourceMaps, once filled will have everything in order
        Map<URI, Collection<Statement>> statementMap = new HashMap<URI, Collection<Statement>>();
        Map<URI, Collection<Statement>> metaStatementMap = new HashMap<URI, Collection<Statement>>();
        Collection<Statement> datasetNG = null;
        Collection<Statement> metaDatasetNG = null;

        for (Map.Entry<URI, Collection<Statement>> entry : statements.entrySet()) {
            if (entry.getKey().equals(GRAPHS.METADATA_GRAPHS_DATASET_META)) {
                metaDatasetNG = entry.getValue();
            } else if (entry.getKey().equals(GRAPHS.GRAPHS_DATASET_META)) {
                datasetNG = entry.getValue();
            } else if (UriGenerator.isMetadataGraphUri(entry.getKey())) {
                metaStatementMap.put(entry.getKey(), entry.getValue());
            } else {
                statementMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<URI, Collection<Statement>> entry : metaStatementMap.entrySet()) {
            URI ngURI = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, entry.getKey());
            Collection<Statement> ngStatements = statementMap.remove(ngURI);
            Collection<Statement> ngmdStatements = entry.getValue();
            if (ngStatements == null) {
                ngStatements = new ArrayList<Statement>();
            }

            INamedGraphUpdate ngu = new NamedGraphUpdate(ngURI, null, ngStatements, null, ngmdStatements, null);
            transaction.addNamedGraphUpdate(ngu);
        }
        if (datasetNG != null) {
            Collection<Statement> ngStatements = statementMap.remove(GRAPHS.GRAPHS_DATASET);
            Collection<Statement> ngmdStatements = datasetNG;
            if (ngStatements == null) {
                ngStatements = new ArrayList<Statement>();
            }
            INamedGraphUpdate ngu = new NamedGraphUpdate(GRAPHS.GRAPHS_DATASET, null, ngStatements, null, ngmdStatements, null);
            transaction.addNamedGraphUpdate(ngu);
        }
        if (metaDatasetNG != null) {

            Collection<Statement> ngStatements = statementMap.remove(GRAPHS.METADATA_GRAPHS_DATASET);
            Collection<Statement> ngmdStatements = metaDatasetNG;
            if (ngStatements == null) {
                ngStatements = new ArrayList<Statement>();
            }
            INamedGraphUpdate ngu = new NamedGraphUpdate(GRAPHS.METADATA_GRAPHS_DATASET, null, ngStatements, null, ngmdStatements, null);
            transaction.addNamedGraphUpdate(ngu);
        }
        for (Map.Entry<URI, Collection<Statement>> entry : statementMap.entrySet()) {
            INamedGraphUpdate ngu = new NamedGraphUpdate(entry.getKey(), null, entry.getValue(), new ArrayList<Statement>(), new ArrayList<Statement>(), new ArrayList<Statement>());
            if (!serverQuadStore.containsNamedGraph(entry.getKey()) && graphTemplate != null) {
                URI metaURI = UriGenerator.generateMetadataGraphUri(entry.getKey());
                for (Statement initStatement : graphTemplate) {
                    if (initStatement.getSubject().equals(GRAPHS.DEFAULT_GRAPH_TEMPLATE)) {
                        ngu.getMetaAdditions().add(Constants.valueFactory.createStatement(entry.getKey(), initStatement.getPredicate(), initStatement.getObject(), metaURI));
                    } else if (initStatement.getSubject().equals(GRAPHS.DEFAULT_METADATA_GRAPH_TEMPLATE)) {
                        ngu.getMetaAdditions().add(Constants.valueFactory.createStatement(metaURI, initStatement.getPredicate(), initStatement.getObject(), metaURI));
                    } else if (initStatement.getSubject().equals(GRAPHS.DEFAULT_METADATA_GRAPH_TEMPLATE)) {
                        ngu.getMetaAdditions().add(Constants.valueFactory.createStatement(metaURI, initStatement.getPredicate(), initStatement.getObject(), metaURI));
                    }
                }
                ngu.getMetaAdditions().add(Constants.valueFactory.createStatement(entry.getKey(), RDF.TYPE, NamedGraph.TYPE, metaURI));
                ngu.getMetaAdditions().add(Constants.valueFactory.createStatement(entry.getKey(), NamedGraph.hasMetadataGraphProperty, metaURI, metaURI));
            }
            transaction.addNamedGraphUpdate(ngu);
        }

        return updates;
    }

}
