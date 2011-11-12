/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Dec 24, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import org.openanzo.client.Transaction.MapFunction;
import org.openanzo.datasource.IReplicationService;
import org.openanzo.datasource.IUpdateService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.SerializationUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.UpdateServerException;
import org.openanzo.services.impl.UpdateTransaction;
import org.openanzo.services.impl.Updates;
import org.openanzo.services.serialization.IReplicationHandler;
import org.openanzo.services.serialization.ReplicationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Marshalls the client-server replication request and response.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
public class Replicator {

    private static final Logger log                  = LoggerFactory.getLogger(Replicator.class);

    private static final int    UPDATE_TIMEOUT       = 5000;

    private static final int    BATCH_SIZE           = 20000;

    private final AnzoClient    client;

    private final HashSet<URI>  receivedTransactions = new HashSet<URI>();

    private final HashSet<URI>  expectedTransactions = new HashSet<URI>();

    private final HashSet<URI>  failedTransactions   = new HashSet<URI>();

    private final Condition     newTransactionEvent;

    Replicator(AnzoClient client) {
        this.client = client;
        newTransactionEvent = client.clientLock.newCondition();
    }

    /**
     * Synchronizes this anzo client with the server by uploading all changes and downloading statements that have changed and are being tracked by the client.
     * 
     * @throws AnzoException
     */
    void update() throws AnzoException {
        try {
            client.clientLock.lockInterruptibly();
            List<Transaction> committedTransactions = client.transactionQueue.getCommittedTransactions();
            Map<URI, Transaction> transactionMap = new HashMap<URI, Transaction>();
            for (Transaction tran : committedTransactions) {
                transactionMap.put(tran.transactionUri, tran);
            }
            ReplicatorUpdates updates = toIUpdateTransaction(committedTransactions);
            if (!updates.getTransactions().isEmpty()) {
                receivedTransactions.clear();
                expectedTransactions.clear();
                failedTransactions.clear();

                HashMap<URI, URI> newGraphs = new HashMap<URI, URI>();
                Set<URI> closedGraphs = new HashSet<URI>();
                for (Map.Entry<URI, URI> entry : updates.namedGraphsToSubscribe.entrySet()) {
                    newGraphs.put(entry.getKey(), entry.getValue());
                    if (!client.replicaGraphTable.table.containsKey(entry.getKey()) && !client.serverGraphTable.table.containsKey(entry.getKey())) {
                        closedGraphs.add(entry.getKey());
                    }
                }

                ArrayList<URI> newGraphsArray = new ArrayList<URI>();
                // add all named graph uris .
                for (Map.Entry<URI, URI> entry : newGraphs.entrySet()) {
                    newGraphsArray.add(entry.getKey());
                }

                // find the transactions that contain only new graphs so we know not to wait
                // for transaction events for them.

                // if we have no replica graphs then don't wait for the transaction
                Set<URI> replicaGraphs = client.replicaGraphTable.table.keySet();
                Set<URI> serverGraphs = client.serverGraphTable.table.keySet();
                //if (!replicaGraphs.isEmpty()) {
                for (IUpdateTransaction transaction : updates.getTransactions()) {
                    if (transaction.isEmpty()) {
                        continue;
                    }
                    boolean needed = false;
                    for (INamedGraphUpdate entry : transaction.getNamedGraphUpdates()) {
                        if ((serverGraphs.contains(entry.getNamedGraphURI()) || replicaGraphs.contains(entry.getNamedGraphURI())) && !newGraphsArray.contains(entry.getNamedGraphURI())) {
                            needed = true;
                            break;
                        }
                    }
                    if (needed)
                        expectedTransactions.add(transaction.getURI());
                }
                //}
                // System.err.println("Rec/Expected:"+receivedTransactions.size()+":"+expectedTransactions.size());

                IUpdates update = client.clientDatasource.getUpdateService().update(client.createContext(IUpdateService.UPDATE), false, updates);

                boolean hadErrors = false;

                List<IUpdateTransaction> results = update.getTransactions();

                @SuppressWarnings("unchecked")
                ArrayList<AnzoException>[] errors = new ArrayList[results.size()];
                HashMap<URI, ArrayList<AnzoException>> errorMap = new HashMap<URI, ArrayList<AnzoException>>();
                int i = 0;

                Map<URI, Long> transactionTimestamps = new HashMap<URI, Long>();

                for (IUpdateTransaction transaction : results) {
                    if (transaction.getErrors().size() > 0) {
                        failedTransactions.add(transaction.getURI());
                        expectedTransactions.remove(transaction.getURI());
                        hadErrors = true;
                        errors[i] = new ArrayList<AnzoException>();
                        for (AnzoException err : transaction.getErrors()) {
                            errors[i].add(err);
                        }
                        errorMap.put(transaction.getURI(), errors[i]);
                        i++;
                    }
                    Map<URI, Long> revs = transaction.getUpdatedNamedGraphRevisions();
                    if (revs == null || revs.isEmpty()) {
                        expectedTransactions.remove(transaction.getURI());
                    }
                    //committedTransactions.remove(transactionMap.get(transaction.getURI()));
                    transactionTimestamps.put(transaction.getURI(), transaction.getTransactionTimestamp());
                    /*if (transaction.getNamedGraphUpdates().size() > 0) {
                        client.namedGraphUpdateManager.updated(transaction);
                    }*/
                }

                long start = System.currentTimeMillis();
                boolean needsReplication = false;
                /*if (!client.jmsEnabled) {
                    needsReplication = true;
                } else {*/
                while (receivedTransactions.size() < expectedTransactions.size()) {
                    if (!newTransactionEvent.await(1000, TimeUnit.MILLISECONDS)) {
                        long end = System.currentTimeMillis();
                        if (end - start > UPDATE_TIMEOUT) {
                            needsReplication = true;
                            break;
                        }
                    }
                }
                //}

                if (needsReplication) {
                    // TODO: create a test for this case.  
                    HashSet<URI> absentTransactions = new HashSet<URI>();
                    absentTransactions.addAll(expectedTransactions);
                    absentTransactions.removeAll(receivedTransactions);
                    HashSet<URI> graphsToReplicate = new HashSet<URI>();
                    for (IUpdateTransaction updateTransaction : updates.getTransactions()) {
                        if (absentTransactions.contains(updateTransaction.getURI())) {
                            graphsToReplicate.addAll(updateTransaction.getNamedGraphs());
                        }
                    }
                    graphsToReplicate.addAll(newGraphsArray);
                    graphsToReplicate.removeAll(closedGraphs);
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CLIENT.EXTRA_REPLICATION_NEEDED, SerializationUtils.convertToList(graphsToReplicate, SerializationConstants.MIMETYPE_CSV)));
                    }

                    replicate(graphsToReplicate);
                } else {
                    HashSet<URI> graphsToReplicate = new HashSet<URI>();
                    graphsToReplicate.addAll(newGraphsArray);
                    graphsToReplicate.removeAll(closedGraphs);
                    if (graphsToReplicate.size() > 0) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CLIENT.REPLICATE_NEW_GRAPHS, SerializationUtils.convertToList(graphsToReplicate, SerializationConstants.MIMETYPE_CSV)));
                        }
                        replicateNewGraphs(graphsToReplicate);
                    }

                }

                HashSet<URI> toFetch = new HashSet<URI>();
                for (URI sgUUID : updates.getServerUUIDStoFetch) {
                    if (!closedGraphs.contains(sgUUID)) {
                        toFetch.add(sgUUID);
                    }
                }

                for (URI uri : toFetch) {
                    Collection<Statement> stmts = null;
                    Collection<Statement> serverStmts = null;
                    URI metadataGraphURI = UriGenerator.generateMetadataGraphUri(uri);
                    stmts = client.quadStore.find(uri, org.openanzo.ontologies.openanzo.NamedGraph.uuidProperty, null, metadataGraphURI);
                    if (stmts.isEmpty()) {
                        serverStmts = client.serverQuadStore.find(uri, org.openanzo.ontologies.openanzo.NamedGraph.uuidProperty, null, metadataGraphURI);
                        if (!serverStmts.isEmpty()) {
                            Statement uuidStmt = serverStmts.iterator().next();
                            client.quadStore.add(uuidStmt);
                        }
                    }

                }
                // if (client.jmsEnabled) {

                // we have to check that the transaction in which this graph was created succeeded.  

                if (!newGraphsArray.isEmpty()) {

                    Set<URI> candidates = new HashSet<URI>();
                    candidates.addAll(transactionMap.keySet());
                    // if the graph were expected as an update, we wouldn't be subscribing here
                    //candidates.removeAll(expectedTransactions);
                    // if the transaction failed, then we won't be subscribing either
                    candidates.removeAll(failedTransactions);

                    // compute the set of all graphs received in transactions, that we aren't already
                    // subscribed to.  
                    Set<URI> candidateGraphs = new HashSet<URI>();
                    for (IUpdateTransaction iut : updates.getTransactions()) {
                        if (candidates.contains(iut.getURI())) {
                            candidateGraphs.addAll(iut.getNamedGraphs());
                        }
                    }

                    newGraphsArray.removeAll(closedGraphs);
                    for (URI uri : newGraphsArray) {
                        if (!candidateGraphs.contains(uri)) {
                            continue;
                        }
                        Collection<Statement> stmts = null;
                        URI metadataGraphURI = UriGenerator.generateMetadataGraphUri(uri);
                        stmts = client.quadStore.find(uri, org.openanzo.ontologies.openanzo.NamedGraph.uuidProperty, null, metadataGraphURI);
                        if (!stmts.isEmpty()) {
                            Statement uuidStmt = stmts.iterator().next();
                            URI uuid = (URI) uuidStmt.getObject();
                            client.namedGraphUpdateManager.addNamedGraphUpdateTopic(uuid);
                        } else {
                            /*   HashSet<URI> graphsToReplicate = new HashSet<URI>();
                               graphsToReplicate.add(uri);
                               Map<URI, INamedGraphUpdate> ups = replicateNewGraphs(graphsToReplicate);
                               if (ups.containsKey(uri)) {
                                   INamedGraphUpdate up = ups.get(uri);
                                   System.err.println("Replicated :" + up.getNamedGraphURI() + ":" + up.getUUID() + ":" + up.getRevision());
                                   for (Statement stmt : up.getAdditions()) {
                                       System.err.println(stmt);
                                   }
                                   for (Statement stmt : up.getRemovals()) {
                                       System.err.println(stmt);
                                   }
                                   for (Statement stmt : up.getMetaAdditions()) {
                                       System.err.println(stmt);
                                   }
                                   for (Statement stmt : up.getMetaRemovals()) {
                                       System.err.println(stmt);
                                   }
                               } else {
                                   System.err.println("Didn't replicate correctly.");
                               }*/
                            throw new AnzoException(ExceptionConstants.COMBUS.NO_UUID_ERROR, uri.toString());
                        }
                    }
                    //}
                }
                for (IUpdateTransaction tran : updates.getTransactions()) {
                    committedTransactions.remove(transactionMap.get(tran.getURI()));
                    client.transactionQueue.removeCommittedTransaction(transactionMap.get(tran.getURI()));
                    if (!receivedTransactions.contains(tran.getURI())) {
                        if (!failedTransactions.contains(tran.getURI())) {
                            Collection<Statement> context = tran.getTransactionContext();
                            long timestamp = transactionTimestamps.get(tran.getURI());
                            client.notifyTransactionListners(tran.getURI(), timestamp, tran.getNamedGraphs(), context);
                        } else {
                            Collection<Statement> context = tran.getTransactionContext();
                            List<AnzoException> err = errorMap.get(tran.getURI());
                            client.notifyTransactionListners(tran.getURI(), tran.getNamedGraphs(), context, err);
                        }
                    }
                }

                if (hadErrors) {
                    throw new UpdateServerException(updates.getTransactions().toArray(new IUpdateTransaction[0]), errors);
                }
            }
        } catch (AnzoException e) {
            // any transaction left in the queue did not succeed due to the 
            // caught exception.
            for (Transaction transaction : client.transactionQueue.committedTransactions) {
                List<AnzoException> ex = new ArrayList<AnzoException>();
                ex.add(e);
                client.notifyTransactionListners(transaction.transactionUri, null, null, ex);
            }
            throw (e);
        } catch (InterruptedException ie) {
            log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.COMBUS.INTERRUPTED), ie);
        } finally {
            client.clientLock.unlock();
        }

    }

    void transactionComplete(URI transactionUri) {
        client.clientLock.lock();
        try {
            if (expectedTransactions.contains(transactionUri)) {
                receivedTransactions.add(transactionUri);
                newTransactionEvent.signalAll();
            }
        } finally {
            client.clientLock.unlock();
        }
    }

    /**
     * Replicate the given graphs directly to the quad store. Used by the getReplicaGraphsCall to bring down the graphs in bulk. This call is used populate the
     * replica in bulk.
     * 
     * @param newGraphs
     * @throws AnzoException
     */
    void replicateToQuadStore(Set<URI> graphs) throws AnzoException {
        ArrayList<Statement> replicationRevisions = new ArrayList<Statement>();
        //        for (URI uri : newGraphs) {
        //            replicationRevisions.add(Constants.valueFactory.createStatement(uri, NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(-1)));
        //        }

        for (URI uri : graphs) {
            Collection<Statement> stmts = client.quadStore.find(uri, NamedGraph.revisionProperty, null, UriGenerator.generateMetadataGraphUri(uri));
            if (stmts.isEmpty()) {
                replicationRevisions.add(Constants.valueFactory.createStatement(uri, NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(-1)));
            } else {
                replicationRevisions.add(stmts.iterator().next());
            }
        }

        IReplicationHandler bulkUpdateHandler = new IReplicationHandler() {

            public boolean handleNamedGraph(URI namedGraphUri, URI uuid, long revision) throws AnzoException {
                Collection<Statement> stmts = client.quadStore.find(namedGraphUri, NamedGraph.revisionedProperty, null, (URI[]) null);
                if (!stmts.isEmpty()) {
                    Value obj = stmts.iterator().next().getObject();
                    Literal lit = (Literal) obj;
                    Boolean revisioned = Boolean.parseBoolean(lit.getLabel());
                    if (!revisioned) {
                        URI metaUri = null;
                        if (UriGenerator.isMetadataGraphUri(namedGraphUri)) {
                            metaUri = namedGraphUri;
                            namedGraphUri = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, namedGraphUri);
                        } else {
                            metaUri = UriGenerator.generateMetadataGraphUri(namedGraphUri);
                        }
                        client.quadStore.remove(null, null, null, metaUri);
                        client.quadStore.remove(null, null, null, namedGraphUri);
                    }
                }
                return true;
            }

            public boolean handleStatement(boolean metadata, boolean addition, Resource subject, URI predicate, Value object, URI namedGraphURI) throws AnzoException {
                if (addition) {
                    client.quadStore.add(subject, predicate, object, namedGraphURI);
                } else {
                    client.quadStore.remove(subject, predicate, object, namedGraphURI);
                }
                return true;
            }

            public void start(int totalSize) throws AnzoException {
            }

            public void end() throws AnzoException {
            }
        };

        client.clientDatasource.getReplicationService().replicate(client.createContext(IReplicationService.REPLICATE), replicationRevisions, bulkUpdateHandler, BATCH_SIZE);
    }

    /**
     * Replicates the given set of graphs, passing -1 as the revision to the server for each.
     * 
     * @param newGraphs
     * @throws AnzoException
     */
    Map<URI, INamedGraphUpdate> replicateNewGraphs(Set<URI> newGraphs) throws AnzoException {
        ArrayList<Statement> replicationRevisions = new ArrayList<Statement>();

        for (URI uri : newGraphs) {
            replicationRevisions.add(Constants.valueFactory.createStatement(uri, NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(-1)));
        }
        ReplicationHandler bng = new ReplicationHandler(client.replicaUpdater);
        client.clientDatasource.getReplicationService().replicate(client.createContext(IReplicationService.REPLICATE), replicationRevisions, bng, BATCH_SIZE);
        return bng.getUpdates();
    }

    /**
     * Replicate the given graphs, passing the current revision, if any, we have for each in the quad store.
     * 
     * @param newGraphs
     * @throws AnzoException
     */
    void replicate(Set<URI> graphs) throws AnzoException {
        ArrayList<Statement> replicationRevisions = new ArrayList<Statement>();
        for (URI uri : graphs) {
            Collection<Statement> stmts = client.quadStore.find(uri, NamedGraph.revisionProperty, null, (URI[]) null);
            if (stmts.isEmpty()) {
                replicationRevisions.add(Constants.valueFactory.createStatement(uri, NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(-1)));
            } else {
                replicationRevisions.add(stmts.iterator().next());
            }
        }
        ReplicationHandler bng = new ReplicationHandler(client.replicaUpdater);
        client.clientDatasource.getReplicationService().replicate(client.createContext(IReplicationService.REPLICATE), replicationRevisions, bng, BATCH_SIZE);
    }

    /**
     * Replicate all graphs in the local replica based on the current revisions.
     * 
     * @throws AnzoException
     */
    void replicate() throws AnzoException {
        try {
            client.clientLock.lockInterruptibly();

            ArrayList<Statement> replicationRevisions = new ArrayList<Statement>();

            for (ClientGraph graph : client.replicaGraphTable.listAll()) {
                Collection<Statement> stmts = graph.getMetadataGraph().find(graph.getNamedGraphUri(), NamedGraph.revisionProperty, null);
                if (!stmts.isEmpty()) {
                    replicationRevisions.add(stmts.iterator().next());
                } else {
                    replicationRevisions.add(Constants.valueFactory.createStatement(graph.getNamedGraphUri(), NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(-1)));
                }
            }
            if (replicationRevisions.size() >= 0) {
                ReplicationHandler bng = new ReplicationHandler(client.replicaUpdater);
                client.clientDatasource.getReplicationService().replicate(client.createContext(IReplicationService.REPLICATE), replicationRevisions, bng, BATCH_SIZE);
            }
        } catch (InterruptedException ie) {
            throw new AnzoException(ExceptionConstants.CORE.INTERRUPTED);
        } finally {
            client.clientLock.unlock();
        }
    }

    /**
     * 
     * Uses the walkTransactionTree method of each of the committed transactions to add the transaction and all of it's children as commands to a new
     * IUpdateTransaction, which is then returned.
     * 
     */
    private static ReplicatorUpdates toIUpdateTransaction(List<Transaction> transactions) throws AnzoException {
        ReplicatorUpdates updates = new ReplicatorUpdates(null);

        List<Transaction> emptyTransactionsToRemove = new ArrayList<Transaction>();

        for (Transaction trans : transactions) {
            // pass in null for preconditions as they will be added in the transaction tree walk. 
            IUpdateTransaction transaction = new UpdateTransaction(trans.transactionUri, 0, (trans.getContextQuadStore() != null) ? trans.getContextQuadStore().getStatements() : null, null, null);
            AddCommandFunctor addCommandFunctor = new AddCommandFunctor(transaction, updates);
            trans.walkTransactionTree(addCommandFunctor);
            if (!transaction.isEmpty()) {
                updates.getTransactions().add(transaction);
            } else {
                emptyTransactionsToRemove.add(trans);
            }
        }
        transactions.removeAll(emptyTransactionsToRemove);
        return updates;
    }

    static class ReplicatorUpdates extends Updates {
        public ReplicatorUpdates(String operationId) {
            super(operationId);
        }

        Set<URI>      getServerUUIDStoFetch  = new HashSet<URI>();

        Map<URI, URI> namedGraphsToSubscribe = new HashMap<URI, URI>();
    }

    /**
     * When called, adds the passed in Transaction as a Command to the IUpdateTransaction provided to the constructor.
     * 
     * @author Joe Betz <jpbetz@cambridgesemantics.com>
     * 
     */
    private static class AddCommandFunctor implements MapFunction {
        IUpdateTransaction updateTransaction;

        ReplicatorUpdates  updates;

        AddCommandFunctor(IUpdateTransaction updateTransaction, ReplicatorUpdates updates) {
            this.updateTransaction = updateTransaction;
            this.updates = updates;
        }

        public void call(Transaction transaction) {
            try {
                if (transaction.getPreconditions() != null)
                    updateTransaction.getPreconditions().addAll(transaction.getPreconditions());
                updateTransaction.removeStatement(transaction.getDeletions());
                updateTransaction.addStatement(transaction.getAdditions());
                updates.getServerUUIDStoFetch.addAll(transaction.getServerUUIDStoFetch());
                updates.namedGraphsToSubscribe.putAll(transaction.getNamedGraphsToSubscribe());
            } catch (AnzoException ae) {
                throw new AnzoRuntimeException(ae);
            }
        }
    }

}
