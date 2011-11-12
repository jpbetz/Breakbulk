/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jan 17, 2008
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.openanzo.datasource.IStoredNamedGraph;
import org.openanzo.datasource.StoredNamedGraph;
import org.openanzo.datasource.nodecentric.operations.Find;
import org.openanzo.datasource.nodecentric.operations.Update;
import org.openanzo.datasource.nodecentric.sql.InsertStatementsRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.NamedGraphRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.NamedGraphRdbWrapper.SelectNamedGraphNonRevisionedResult;
import org.openanzo.datasource.nodecentric.sql.NamedGraphRdbWrapper.SelectNamedGraphRevisionedResult;
import org.openanzo.datasource.update.NamedGraphType;
import org.openanzo.datasource.update.ServerUpdateTransaction;
import org.openanzo.datasource.update.UpdateChanges;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.UriGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An implementation of IQuadStore that talks to the NodeCentric data source
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class NodeCentricServerQuadStore {
    private static final Logger                  log               = LoggerFactory.getLogger(NodeCentricServerQuadStore.class);

    private final boolean                        revisioned;

    private final NodeCentricOperationContext    context;

    private final Collection<Statement>          additions         = new ArrayList<Statement>();

    private final Collection<Statement>          removals          = new ArrayList<Statement>();

    private PreparedStatement                    updateNamedGraph  = null;

    private PreparedStatement                    insertNamedGraph  = null;

    private Long                                 transactionId     = null;

    private Long                                 transactionStart  = null;

    private int                                  removedGraphs     = 0;

    NamedGraphRdbWrapper.BatchInsertRemovedGraph removeGraphBatch  = null;

    static final String                          REMOVE_GRAPHS_TMP = "REMOVE_GRAPHS_TMP";

    private boolean                              direct;

    /**
     * Create a new ServiceContainer
     * 
     * @param context
     * @param revisioned
     */
    protected NodeCentricServerQuadStore(NodeCentricOperationContext context, boolean revisioned, boolean direct) {
        this.context = context;
        this.revisioned = revisioned;
        this.direct = direct;
    }

    protected void close() throws AnzoException {
        if (updateNamedGraph != null) {
            try {
                updateNamedGraph.close();
            } catch (SQLException sqle) {
                if (log.isTraceEnabled())
                    log.trace(LogUtils.RDB_MARKER, "Error closing prepared statement", sqle);
            }
        }
        if (insertNamedGraph != null) {
            try {
                insertNamedGraph.close();
            } catch (SQLException sqle) {
                if (log.isTraceEnabled())
                    log.trace(LogUtils.RDB_MARKER, "Errror closing prepared statement", sqle);
            }
        }
    }

    protected void precommit() throws AnzoException {
        try {
            if (revisioned) {
                if (updateNamedGraph == null) {
                    updateNamedGraph = context.getStatementProvider().getPreparedSQLStatement(NamedGraphRdbWrapper.deleteNamedGraph, context.getConnection());
                }
                if (insertNamedGraph == null) {
                    insertNamedGraph = context.getStatementProvider().getPreparedSQLStatement(NamedGraphRdbWrapper.insertNamedGraph, context.getConnection());
                }
            } else {
                if (updateNamedGraph == null) {
                    updateNamedGraph = context.getStatementProvider().getPreparedSQLStatement(NamedGraphRdbWrapper.updateNamedGraphNR, context.getConnection());
                }
                if (insertNamedGraph == null) {
                    insertNamedGraph = context.getStatementProvider().getPreparedSQLStatement(NamedGraphRdbWrapper.insertNamedGraphNR, context.getConnection());
                }
            }

        } catch (SQLException sqle) {
            throw new AnzoException(ExceptionConstants.DATASOURCE.FAILED_EXECUTE_BATCH, sqle);
        }
    }

    protected void removeNamedGraph(URI namedGraphUri, long rend, long transactionStart) throws AnzoException {
        this.transactionStart = transactionStart;
        Long ngId = context.getNodeLayout().fetchId(namedGraphUri, context.getConnection());
        URI metadataUri = UriGenerator.generateMetadataGraphUri(namedGraphUri);
        Long metaId = context.getNodeLayout().fetchId(metadataUri, context.getConnection());

        if (revisioned) {
            try {
                if (ngId != null) {
                    removeGraphBatch.addEntry(ngId, 0, rend);
                    removeGraphBatch.addEntry(metaId, 0, rend);
                    removedGraphs++;
                    //NamedGraphRdbWrapper.deleteStatementsForNamedGraph(context.getStatementProvider(), context.getConnection(), transactionStart, ngId, metaId);
                    //NamedGraphRdbWrapper.deleteNamedGraph(context.getStatementProvider(), context.getConnection(), transactionStart, (-1 * transactionId), ngId);
                } else {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUri.toString());
                }
            } catch (RdbException sqle) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.FAILED_EXECUTE_BATCH, sqle);
            }
        } else {
            if (ngId != null) {
                removeGraphBatch.addEntry(ngId, 1, rend);
                removeGraphBatch.addEntry(metaId, 1, rend);
                removedGraphs++;
                // NamedGraphRdbWrapper.deleteStatementsForNamedGraphNR(context.getStatementProvider(), context.getConnection(), ngId, metaId);
                // NamedGraphRdbWrapper.deleteNamedGraphNR(context.getStatementProvider(), context.getConnection(), (-1 * transactionId), ngId);
            } else {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUri.toString());
            }

        }
    }

    protected void executeNamedGraphsUpdates() throws AnzoException {
        try {
            long start = System.currentTimeMillis();
            if (removedGraphs > 0) {
                removeGraphBatch.executeStatement();
                if (revisioned) {
                    long startR = log.isDebugEnabled() ? System.currentTimeMillis() : 0;
                    int count = NamedGraphRdbWrapper.deleteStatementsForNamedGraphBatch(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), REMOVE_GRAPHS_TMP);
                    int count2 = NamedGraphRdbWrapper.deleteNamedGraphBatch(context.getStatementProvider(), context.getConnection(), transactionStart, (-1 * transactionId), context.getConfiguration().getSessionPrefix(), REMOVE_GRAPHS_TMP);
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "[REMOVE NAMED GRAPHS] {}:{}:{}", new Object[] { Long.toString(System.currentTimeMillis() - startR), Integer.toString(count), Integer.toString(count2) });
                    }
                } else {
                    long startR = log.isDebugEnabled() ? System.currentTimeMillis() : 0;
                    int count = NamedGraphRdbWrapper.deleteStatementsForNamedGraphNRBatch(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), REMOVE_GRAPHS_TMP);
                    int count2 = NamedGraphRdbWrapper.deleteNamedGraphNRBatch(context.getStatementProvider(), context.getConnection(), (-1 * transactionId), context.getConfiguration().getSessionPrefix(), REMOVE_GRAPHS_TMP);
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "[REMOVE NAMED GRAPHS NR] {}:{}:{}", new Object[] { Long.toString(System.currentTimeMillis() - startR), Integer.toString(count), Integer.toString(count2) });
                    }
                }
            }

            updateNamedGraph.executeBatch();
            insertNamedGraph.executeBatch();
            updateNamedGraph.clearBatch();
            insertNamedGraph.clearBatch();
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[UPDATE NAMEDGRAPHS] {}", (System.currentTimeMillis() - start));
            }
        } catch (SQLException sqle) {
            if (log.isErrorEnabled()) {
                SQLException cause = sqle;
                while (cause != null) {
                    log.error(LogUtils.RDB_MARKER, "SQL Error in executeNamedGraphUpdates", cause);
                    cause = cause.getNextException();
                }
            }
            throw new AnzoException(ExceptionConstants.DATASOURCE.FAILED_EXECUTE_BATCH, sqle);
        } finally {
            removeGraphBatch.close();
        }
    }

    protected void updateNamedGraphRevision(IStoredNamedGraph storedGraph) throws AnzoException {
        Long ngId = context.getNodeLayout().fetchId(storedGraph.getURI(), context.getConnection());
        Long metaId = context.getNodeLayout().fetchId(storedGraph.getMetaURI(), context.getConnection());
        Long uuidID = context.getNodeLayout().fetchId(storedGraph.getUUID(), context.getConnection());
        Long userId = context.getNodeLayout().fetchId(storedGraph.getLastModifiedBy(), context.getConnection());
        if (revisioned) {
            try {
                if (ngId != null) {
                    if (!storedGraph.isNewGraph()) {
                        updateNamedGraph.setLong(1, storedGraph.getLastModifiedTime());
                        updateNamedGraph.setLong(2, (-1 * transactionId));
                        updateNamedGraph.setLong(3, ngId);
                        updateNamedGraph.addBatch();
                    }
                    insertNamedGraph.setLong(1, storedGraph.getLastModifiedTime());
                    insertNamedGraph.setLong(2, ngId);
                    insertNamedGraph.setLong(3, metaId);
                    insertNamedGraph.setLong(4, uuidID);
                    insertNamedGraph.setLong(5, storedGraph.getNewRevision());
                    insertNamedGraph.setLong(6, userId);
                    insertNamedGraph.setLong(7, transactionId);
                    insertNamedGraph.addBatch();
                } else {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, storedGraph.getURI().toString());
                }
            } catch (SQLException sqle) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.FAILED_EXECUTE_BATCH, sqle);
            }
        } else {
            try {
                if (ngId != null) {
                    if (!storedGraph.isNewGraph()) {
                        updateNamedGraph.setLong(1, (-1 * transactionId));
                        updateNamedGraph.setLong(2, ngId);
                        updateNamedGraph.addBatch();
                    }
                    insertNamedGraph.setLong(1, storedGraph.getLastModifiedTime());
                    insertNamedGraph.setLong(2, ngId);
                    insertNamedGraph.setLong(3, metaId);
                    insertNamedGraph.setLong(4, uuidID);
                    insertNamedGraph.setLong(5, storedGraph.getNewRevision());
                    insertNamedGraph.setLong(6, userId);
                    insertNamedGraph.setLong(7, transactionId);
                    insertNamedGraph.addBatch();
                } else {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, storedGraph.getURI().toString());
                }
            } catch (SQLException sqle) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.FAILED_EXECUTE_BATCH, sqle);
            }
        }
    }

    public void beginTransaction(Long transactionId) throws AnzoException {
        removedGraphs = 0;
        this.transactionId = transactionId;
        removeGraphBatch = new NamedGraphRdbWrapper.BatchInsertRemovedGraph(context.getConnection(), context.getStatementProvider(), context.getConfiguration().getSessionPrefix(), REMOVE_GRAPHS_TMP);
    }

    protected UpdateChanges update(Map<URI, IStoredNamedGraph> graphs, Map<Value, Long> storedNodes) throws AnzoException {
        UpdateChanges ur = (revisioned) ? Update.update(context, transactionId, graphs, additions, removals, storedNodes, direct) : Update.updateNR(context, transactionId, graphs, additions, removals, storedNodes, direct);
        additions.clear();
        removals.clear();
        return ur;
    }

    public Collection<URI> getNamedGraphUris() throws AnzoException {
        ArrayList<URI> uris = new ArrayList<URI>();
        if (revisioned) {
            ClosableIterator<Long> results = NamedGraphRdbWrapper.getAllRevisionedNamedGraphs(context.getStatementProvider(), context.getConnection());
            while (results.hasNext()) {
                uris.add((URI) context.getNodeLayout().fetchValue(results.next(), context.getConnection()));
            }

        } else {
            ClosableIterator<Long> results = NamedGraphRdbWrapper.getAllNonRevisionedNamedGraphs(context.getStatementProvider(), context.getConnection());
            while (results.hasNext()) {
                uris.add((URI) context.getNodeLayout().fetchValue(results.next(), context.getConnection()));
            }
        }
        return uris;
    }

    public Collection<Statement> getStatements() throws AnzoException {
        return Find.findQuads(context, revisioned ? NodeCentricDatasource.STATEMENTS : NodeCentricDatasource.STATEMENTS_NR, revisioned, true, null, null, null, null);
    }

    protected void add(Statement... statements) throws AnzoException {
        Collections.addAll(additions, statements);
    }

    protected void remove(Statement... statements) throws AnzoException {
        Collections.addAll(removals, statements);
    }

    protected boolean containsNamedGraph(URI namedGraphUri) throws AnzoException {
        Long ngId = context.getNodeLayout().fetchId(namedGraphUri, context.getConnection());
        if (ngId == null) {
            return false;
        }
        boolean isMeta = UriGenerator.isMetadataGraphUri(namedGraphUri);
        if (revisioned) {
            Long result = isMeta ? NamedGraphRdbWrapper.containsMetadataGraphRevisioned(context.getStatementProvider(), context.getConnection(), ngId) : NamedGraphRdbWrapper.containsNamedGraphRevisioned(context.getStatementProvider(), context.getConnection(), ngId);
            return result != null;
        } else {
            Long result = isMeta ? NamedGraphRdbWrapper.containsMetadataGraphNonRevisioned(context.getStatementProvider(), context.getConnection(), ngId) : NamedGraphRdbWrapper.containsNamedGraphNonRevisioned(context.getStatementProvider(), context.getConnection(), ngId);
            return result != null;
        }

    }

    protected URI getNamedGraphUUID(URI namedGraphUri) throws AnzoException {
        Long ngId = context.getNodeLayout().fetchId(namedGraphUri, context.getConnection());
        if (ngId == null) {
            return null;
        }
        Long result = null;
        if (revisioned) {
            result = NamedGraphRdbWrapper.getUUIDForNamedGraph(context.getStatementProvider(), context.getConnection(), ngId);
        } else {
            result = NamedGraphRdbWrapper.getUUIDForNamedGraphNR(context.getStatementProvider(), context.getConnection(), ngId);
        }
        if (result == null) {
            return null;
        } else {
            return (URI) context.getNodeLayout().fetchValue(result, context.getConnection());
        }
    }

    protected void abort() throws AnzoException {
        if (transactionId != null) {
            abortTransaction(context.getConnection(), context.getStatementProvider(), context.getConfiguration(), revisioned, transactionId, direct);
        }
        removeGraphBatch.close();
    }

    static void abortTransaction(Connection connection, PreparedStatementProvider stmtProvider, CoreDBConfiguration configuration, boolean revisioned, long transactionId, boolean direct) throws AnzoException {

        // SelectStatementIdsResult result = InsertStatementsRdbWrapper.selectStatementIds(stmtProvider, connection, configuration.getSessionPrefix());
        // int maxValue = result.getMax() + 1;
        if (revisioned) {
            /* if (configuration.getLimitTransactionSize() && maxValue > NodeCentricDatasource.MAX_OPERATION_SIZE) {
                 long start = System.currentTimeMillis();
                 for (int i = 0; (i * NodeCentricDatasource.MAX_OPERATION_SIZE) <= maxValue; i++) {
                     int offset = (i * NodeCentricDatasource.MAX_OPERATION_SIZE);
                     int max = Math.min(offset + NodeCentricDatasource.MAX_OPERATION_SIZE, maxValue);
                     long count = InsertStatementsRdbWrapper.abortTransactionAddStatementsRange(stmtProvider, connection, transactionId, offset, max, configuration.getSessionPrefix());
                     if (log.isDebugEnabled()) {
                         log.debug("[ABORT TRANSACTION ADD STATEMENTS RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), count, (System.currentTimeMillis() - start) });
                     }
                     start = System.currentTimeMillis();
                     count = InsertStatementsRdbWrapper.abortTransactionRemoveStatementsRange(stmtProvider, connection, (-1 * transactionId), offset, max, configuration.getBigInt(), configuration.getSessionPrefix());
                     if (log.isDebugEnabled()) {
                         log.debug("[ABORT TRANSACTION REMOVE STATEMENTS RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), count, (System.currentTimeMillis() - start) });
                     }
                 }

             } else {*/
            long start = System.currentTimeMillis();
            long count = 0;
            if (!direct) {
                count = InsertStatementsRdbWrapper.abortTransactionAddStatements(stmtProvider, connection, transactionId);
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION ADD STATEMENTS] {}:{}", count, (System.currentTimeMillis() - start));
                }
            } else {
                count = InsertStatementsRdbWrapper.abortTransactionAlreadyAddedStatements(stmtProvider, connection, configuration.getSessionPrefix());
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION ALREADY ADDED STATEMENTS] {}:{}", count, (System.currentTimeMillis() - start));
                }
            }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.abortTransactionRemoveStatements(stmtProvider, connection, (-1 * transactionId), configuration.getBigInt());
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION REMOVE STATEMENTS] {}:{}", count, (System.currentTimeMillis() - start));
            }
            // }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.abortTransactionAddNamedGraphs(stmtProvider, connection, transactionId);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION ADD NAMEDGRAPHS] {}:{}", count, (System.currentTimeMillis() - start));
            }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.abortTransactionRemoveNamedGraphs(stmtProvider, connection, (-1 * transactionId), configuration.getBigInt());
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION REMOVE NAMEDGRAPHS] {}:{}", count, (System.currentTimeMillis() - start));
            }
        } else {
            /* if (maxValue > NodeCentricDatasource.MAX_OPERATION_SIZE) {
                 long start = System.currentTimeMillis();
                 for (int i = 0; (i * NodeCentricDatasource.MAX_OPERATION_SIZE) <= maxValue; i++) {
                     int offset = (i * NodeCentricDatasource.MAX_OPERATION_SIZE);
                     int max = Math.min(offset + NodeCentricDatasource.MAX_OPERATION_SIZE, maxValue);
                     start = System.currentTimeMillis();
                     long count = InsertStatementsRdbWrapper.abortTransactionAddStatementsNRRange(stmtProvider, connection, transactionId, offset, max, configuration.getSessionPrefix());
                     if (log.isDebugEnabled()) {
                         log.debug("[ABORT TRANSACTION ADD STATEMENTS_NR RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), count, (System.currentTimeMillis() - start) });
                     }
                     start = System.currentTimeMillis();
                     count = InsertStatementsRdbWrapper.abortTransactionRemoveStatementsNRRange(stmtProvider, connection, transactionId * -1, offset, max, configuration.getSessionPrefix());
                     if (log.isDebugEnabled()) {
                         log.debug("[ABORT TRANSACTION REMOVE STATEMENTS_NR RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), count, (System.currentTimeMillis() - start) });
                     }
                 }
             } else {*/
            long start = System.currentTimeMillis();
            long count = 0;
            if (!direct) {
                count = InsertStatementsRdbWrapper.abortTransactionAddStatementsNR(stmtProvider, connection, transactionId);
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION ADD STATEMENTS_NR] {}:{}", count, (System.currentTimeMillis() - start));
                }
            } else {
                count = InsertStatementsRdbWrapper.abortTransactionAlreadyAddedStatementsNR(stmtProvider, connection, configuration.getSessionPrefix());
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION ALREADY ADDED STATEMENTS_NR] {}:{}", count, (System.currentTimeMillis() - start));
                }
            }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.abortTransactionRemoveStatementsNR(stmtProvider, connection, transactionId * -1);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION REMOVE STATEMENTS_NR] {}:{}", count, (System.currentTimeMillis() - start));
            }
            // }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.abortTransactionRemoveNamedGraphsNR(stmtProvider, connection, transactionId * -1);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION REMOVE NAMEDGRAPHS_NR] {}:{}", count, (System.currentTimeMillis() - start));
            }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.abortTransactionAddNamedGraphsNR(stmtProvider, connection, transactionId);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[ABORT TRANSACTION ADD NAMEDGRAPHS_NR] {}:{}", count, (System.currentTimeMillis() - start));
            }
        }
    }

    protected void commit(ServerUpdateTransaction transaction) throws AnzoException {
        if (revisioned) {
            long start = System.currentTimeMillis();
            int count = 0;
            /* SelectStatementIdsResult result = InsertStatementsRdbWrapper.selectStatementIds(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
            int maxValue = result.getMax() + 1;
            if (context.getConfiguration().getLimitTransactionSize() && maxValue > NodeCentricDatasource.MAX_OPERATION_SIZE) {
                for (int i = 0; (i * NodeCentricDatasource.MAX_OPERATION_SIZE) <= maxValue; i++) {
                    int offset = (i * NodeCentricDatasource.MAX_OPERATION_SIZE);
                    int max = Math.min(offset + NodeCentricDatasource.MAX_OPERATION_SIZE, maxValue);
                    context.getDatasource().begin(context.getConnection(), false, true);
                    start = System.currentTimeMillis();
                    count = InsertStatementsRdbWrapper.commitTransactionStatementsRange(context.getStatementProvider(), context.getConnection(), transactionId, offset, max, context.getConfiguration().getSessionPrefix());
                    if (log.isDebugEnabled()) {
                        log.debug("[COMMIT TRANSACTION ADD STATEMENTS RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), count, (System.currentTimeMillis() - start) });
                    }
                    start = System.currentTimeMillis();
                    count = InsertStatementsRdbWrapper.commitTransactionStatementsRange(context.getStatementProvider(), context.getConnection(), transactionId * -1, offset, max, context.getConfiguration().getSessionPrefix());
                    if (log.isDebugEnabled()) {
                        log.debug("[COMMIT TRANSACTION REMOVE STATEMENTS RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), count, (System.currentTimeMillis() - start) });
                    }
                    context.getDatasource().commit(context.getConnection(), false, true);
                }
            } else {*/
            context.getDatasource().begin(context.getConnection(), false, true);
            if (!direct) {
                count = InsertStatementsRdbWrapper.commitTransactionStatements(context.getStatementProvider(), context.getConnection(), transactionId);
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[COMMIT TRANSACTION ADD STATEMENTS] {}:{}", count, (System.currentTimeMillis() - start));
                }
            }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.commitTransactionStatements(context.getStatementProvider(), context.getConnection(), transactionId * -1);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[COMMIT TRANSACTION REMOVE STATEMENTS] {}:{}", count, (System.currentTimeMillis() - start));
            }
            context.getDatasource().commit(context.getConnection(), false, true);
            //  }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.commitTransactionNamedGraphs(context.getStatementProvider(), context.getConnection(), transactionId);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[COMMIT TRANSACTION ADD NAMEDGRAPHS] {}:{}", count, (System.currentTimeMillis() - start));
            }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.commitTransactionNamedGraphs(context.getStatementProvider(), context.getConnection(), transactionId * -1);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[COMMIT TRANSACTION REMOVE NAMEDGRAPHS] {}:{}", count, (System.currentTimeMillis() - start));
            }
        } else {
            long start = System.currentTimeMillis();
            long count = 0;
            /*  SelectStatementIdsResult result = InsertStatementsRdbWrapper.selectStatementIds(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
              int maxValue = result.getMax() + 1;
              if (maxValue > NodeCentricDatasource.MAX_OPERATION_SIZE) {
                  for (int i = 0; (i * NodeCentricDatasource.MAX_OPERATION_SIZE) <= maxValue; i++) {
                      int offset = (i * NodeCentricDatasource.MAX_OPERATION_SIZE);
                      int max = Math.min(offset + NodeCentricDatasource.MAX_OPERATION_SIZE, maxValue);
                      count = InsertStatementsRdbWrapper.commitTransactionAddStatementsNRRange(context.getStatementProvider(), context.getConnection(), transactionId, offset, max, context.getConfiguration().getSessionPrefix());
                      if (log.isDebugEnabled()) {
                          log.debug("[COMMIT TRANSACTION ADD STATEMENTS_NR RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), count, (System.currentTimeMillis() - start) });
                      }
                      start = System.currentTimeMillis();
                      count = InsertStatementsRdbWrapper.commitTransactionRemoveStatementsNRRange(context.getStatementProvider(), context.getConnection(), transactionId * -1, offset, max, context.getConfiguration().getSessionPrefix());
                      if (log.isDebugEnabled()) {
                          log.debug("[COMMIT TRANSACTION REMOVE STATEMENTS_NR RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), count, (System.currentTimeMillis() - start) });
                      }
                  }
              } else {*/
            if (!direct) {
                count = InsertStatementsRdbWrapper.commitTransactionAddStatementsNR(context.getStatementProvider(), context.getConnection(), transactionId);
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[COMMIT TRANSACTION ADD STATEMENTS_NR] {}:{}", new Object[] { count, (System.currentTimeMillis() - start) });
                }
            }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.commitTransactionRemoveStatementsNR(context.getStatementProvider(), context.getConnection(), transactionId * -1);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[COMMIT TRANSACTION REMOVE STATEMENTS_NR] {}:{}", new Object[] { count, (System.currentTimeMillis() - start) });
            }
            //  }

            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.commitTransactionRemoveNamedGraphsNR(context.getStatementProvider(), context.getConnection(), transactionId * -1);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[COMMIT TRANSACTION REMOVE NAMEDGRAPHS_NR] {}:{}", count, (System.currentTimeMillis() - start));
            }
            start = System.currentTimeMillis();
            count = InsertStatementsRdbWrapper.commitTransactionAddNamedGraphsNR(context.getStatementProvider(), context.getConnection(), transactionId);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[COMMIT TRANSACTION ADD NAMEDGRAPHS_NR] {}:{}", count, (System.currentTimeMillis() - start));
            }
        }
    }

    public StoredNamedGraph getStoredNamedGraph(URI namedGraphUri) throws AnzoException {
        Long id = context.getNodeLayout().fetchId(namedGraphUri, context.getConnection());
        if (id == null) {
            return null;
        }
        if (revisioned) {
            SelectNamedGraphRevisionedResult result = NamedGraphRdbWrapper.selectNamedGraphRevisioned(context.getStatementProvider(), context.getConnection(), id);
            if (result != null) {
                URI metaUri = (URI) context.getNodeLayout().fetchValue(result.getMetaId(), context.getConnection());
                URI uuidURI = (URI) context.getNodeLayout().fetchValue(result.getUuid(), context.getConnection());
                Long revision = result.getRevision();
                Long hStart = result.getHstart();
                URI userURI = (URI) context.getNodeLayout().fetchValue(result.getLastModifiedBy(), context.getConnection());
                return new StoredNamedGraph(false, NamedGraphType.REVISIONED, namedGraphUri, metaUri, uuidURI, revision, userURI, hStart);
            }
        } else {
            SelectNamedGraphNonRevisionedResult result = NamedGraphRdbWrapper.selectNamedGraphNonRevisioned(context.getStatementProvider(), context.getConnection(), id);
            if (result != null) {
                URI metaUri = (URI) context.getNodeLayout().fetchValue(result.getMetaId(), context.getConnection());
                URI uuidURI = (URI) context.getNodeLayout().fetchValue(result.getUuid(), context.getConnection());
                Long revision = result.getRevision();
                Long hStart = result.getHstart();
                URI userURI = (URI) context.getNodeLayout().fetchValue(result.getLastModifiedBy(), context.getConnection());
                return new StoredNamedGraph(false, NamedGraphType.NON_REVISIONED_PERSISTED, namedGraphUri, metaUri, uuidURI, revision, userURI, hStart);
            }
        }
        return null;

    }

    /**
     * @return the additions
     */
    public Collection<Statement> getAdditions() {
        return additions;
    }

    /**
     * @return the removals
     */
    public Collection<Statement> getRemovals() {
        return removals;
    }
}
