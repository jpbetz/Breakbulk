/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 29, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.nodecentric.rdb.sql.ReplicationRdbWrapper;
import org.openanzo.datasource.nodecentric.rdb.sql.ReplicationRdbWrapper.SelectAllStatementResult;
import org.openanzo.datasource.nodecentric.rdb.sql.ReplicationRdbWrapper.SelectNamedGraphsResult;
import org.openanzo.datasource.nodecentric.rdb.sql.ReplicationRdbWrapper.SelectNewStatementsNRResult;
import org.openanzo.datasource.nodecentric.rdb.sql.ReplicationRdbWrapper.SelectNewStatementsResult;
import org.openanzo.datasource.services.BaseReplicationService;
import org.openanzo.datasource.services.NamedGraphRevision;
import org.openanzo.datasource.services.ReplicationCache;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.serialization.IReplicationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NodeCentric implementation of the IReplicationService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class NodeCentricReplicationService extends BaseReplicationService {
    private static final Logger         log = LoggerFactory.getLogger(NodeCentricReplicationService.class);

    private final NodeCentricDatasource datasource;

    protected NodeCentricReplicationService(NodeCentricDatasource datasource, ICacheProvider cacheProvider) {
        this.datasource = datasource;
        initializeCache(cacheProvider);
    }

    public IDatasource getDatasource() {
        return datasource;
    }

    /**
     * Handler that takes changes from database and sends them to an IrepositoryHandler to get processed into update message for client
     * 
     */
    static class Deltas {
        private Map<Long, Value>                       ids            = null;

        private final NodeCentricOperationContext      connectionContext;

        private final IReplicationHandler              handler;

        private final HashMap<URI, NamedGraphRevision> ngs            = new HashMap<URI, NamedGraphRevision>();

        private final HashMap<URI, Boolean>            newGraph;

        private final ReplicationCache                 cache;

        private NamedGraphRevision                     lastNGRevision = null;

        Deltas(IReplicationHandler handler, NodeCentricOperationContext connectionContext, HashMap<URI, Boolean> newGraph, ReplicationCache cache) {
            this.handler = handler;
            this.connectionContext = connectionContext;
            this.newGraph = newGraph;
            this.cache = cache;
        }

        protected void start(int totaSize) throws AnzoException {
            handler.start(totaSize);
        }

        protected void end() throws AnzoException {
            for (NamedGraphRevision ngr : ngs.values()) {
                if (cache != null && ngr.cache != null) {
                    cache.cache(ngr);
                }
            }
        }

        private @SuppressWarnings("unchecked")
        <T> T getValue(Long id) throws AnzoException {
            T value = (ids != null) ? (T) ids.get(id) : null;
            if (value == null) {
                value = (T) connectionContext.getNodeLayout().fetchValue(id, connectionContext.getConnection());
            }
            return value;
        }

        void handleNamedGraph(long graphId, long uuid, long revision, NamedGraphRevision ngr) throws AnzoException {
            URI graphNode = getValue(graphId);
            URI uuidNode = getValue(uuid);
            ngr.revision = revision;
            ngr.uuid = uuidNode;
            ngs.put(graphNode, ngr);
        }

        void handleStatement(boolean addition, Long graphId, Long subj, Long prop, Long obj) throws AnzoException {
            URI graphNode = getValue(graphId);
            Resource subjNode = getValue(subj);
            URI propNode = getValue(prop);
            Value objNode = getValue(obj);
            URI ngURI = graphNode;
            boolean meta = false;
            if (UriGenerator.isMetadataGraphUri(ngURI)) {
                ngURI = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, ngURI);
                meta = true;
            }
            NamedGraphRevision ngr = ngs.get(ngURI);
            if (ngr == null) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.REVISION_NOT_FOUND, "?", ngURI.toString());
            }
            if (meta && (!ngr.readMeta && !(ngr.readGraph && subjNode.equals(ngURI) && isSpecialMeta(propNode)))) {
                return;
            } else if (!meta && !ngr.readGraph) {
                return;
            }
            if (lastNGRevision == null || !lastNGRevision.namedGraphUri.equals(ngURI)) {
                handler.handleNamedGraph(ngr.namedGraphUri, ngr.uuid, ngr.revision);
                lastNGRevision = ngr;
                if (newGraph.get(ngURI) && lastNGRevision.cache == null) {
                    lastNGRevision.cache = new ArrayList<Statement>();
                }
            }
            handler.handleStatement(meta, addition, subjNode, propNode, objNode, graphNode);
            if (addition && lastNGRevision.cache != null) {
                lastNGRevision.cache.add(Constants.valueFactory.createStatement(subjNode, propNode, objNode, graphNode));
            }

        }

        /**
         * @param ids
         *            the ids to set
         */
        public void setIds(Map<Long, Value> ids) {
            this.ids = ids;
        }

    }

    private static boolean isSpecialMeta(URI predicate) {
        return predicate.equals(NamedGraph.uuidProperty) || predicate.equals(NamedGraph.revisionProperty) || predicate.equals(NamedGraph.datasourceProperty) || predicate.equals(NamedGraph.hasMetadataGraphProperty) || predicate.equals(NamedGraph.persistedProperty) || predicate.equals(NamedGraph.revisionedProperty);
    }

    @Override
    protected void replicateInternal(IOperationContext context, Collection<NamedGraphRevision> newGraphs, Collection<NamedGraphRevision> diffGraphs, IReplicationHandler handler, ReplicationCache cache) throws AnzoException {
        NodeCentricOperationContext connectionContext = datasource.getQueryContext(context);
        long startAll = System.currentTimeMillis();
        int count = 0;
        try {
            Map<Long, NamedGraphRevision> idToGraphs = new HashMap<Long, NamedGraphRevision>();
            long revisionCount = diffGraphs.size();
            long norevisionCount = newGraphs.size();

            long start = System.currentTimeMillis();
            datasource.begin(connectionContext.getConnection(), false, false);
            try {
                StringBuilder sb = new StringBuilder("Replicating:");
                HashMap<URI, Boolean> newGraph = new HashMap<URI, Boolean>();
                for (NamedGraphRevision ngRevision : newGraphs) {
                    newGraph.put(ngRevision.namedGraphUri, true);
                    Long namedGraphId = connectionContext.getNodeLayout().fetchId(ngRevision.namedGraphUri, connectionContext.getConnection());
                    Long metadataId = connectionContext.getNodeLayout().fetchId(ngRevision.metadataUri, connectionContext.getConnection());
                    if (namedGraphId != null && metadataId != null) {
                        idToGraphs.put(metadataId, ngRevision);
                        idToGraphs.put(namedGraphId, ngRevision);

                        long startInsertNamedGraphEntries = System.currentTimeMillis();
                        long insertNamedGraphEntries = ReplicationRdbWrapper.insertNamedGraphNewRevisions(connectionContext.getStatementProvider(), connectionContext.getConnection(), namedGraphId.toString(), connectionContext.getConfiguration().getSessionPrefix(), Long.toString(ngRevision.revision));
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.RDB_MARKER, "[REPLICATE-INSERT_NAMEDGRAPH_ENTRIES] {}:{}", insertNamedGraphEntries, (System.currentTimeMillis() - startInsertNamedGraphEntries));
                        }
                        if (insertNamedGraphEntries == 0) {
                            insertNamedGraphEntries = ReplicationRdbWrapper.insertNamedGraphNRNewRevisions(connectionContext.getStatementProvider(), connectionContext.getConnection(), namedGraphId.toString(), connectionContext.getConfiguration().getSessionPrefix(), Long.toString(ngRevision.revision));
                            if (log.isDebugEnabled()) {
                                log.debug(LogUtils.RDB_MARKER, "[REPLICATE-INSERT_NAMEDGRAPH_NR_ENTRIES] {}:{}", insertNamedGraphEntries, (System.currentTimeMillis() - startInsertNamedGraphEntries));
                            }
                        }
                        sb.append(ngRevision.namedGraphUri + ",");
                    }
                }
                for (NamedGraphRevision ngRevision : diffGraphs) {
                    newGraph.put(ngRevision.namedGraphUri, false);
                    Long namedGraphId = connectionContext.getNodeLayout().fetchId(ngRevision.namedGraphUri, connectionContext.getConnection());
                    Long metadataId = connectionContext.getNodeLayout().fetchId(ngRevision.metadataUri, connectionContext.getConnection());
                    if (namedGraphId != null && metadataId != null) {
                        idToGraphs.put(metadataId, ngRevision);
                        idToGraphs.put(namedGraphId, ngRevision);

                        long startInsertNamedGraphEntries = System.currentTimeMillis();
                        long insertNamedGraphEntries = ReplicationRdbWrapper.insertNamedGraphNewRevisions(connectionContext.getStatementProvider(), connectionContext.getConnection(), namedGraphId.toString(), connectionContext.getConfiguration().getSessionPrefix(), Long.toString(ngRevision.revision));
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.RDB_MARKER, "[REPLICATE-INSERT_NAMEDGRAPH_ENTRIES] {}:{}", insertNamedGraphEntries, (System.currentTimeMillis() - startInsertNamedGraphEntries));
                        }
                        if (insertNamedGraphEntries == 0) {
                            insertNamedGraphEntries = ReplicationRdbWrapper.insertNamedGraphNRNewRevisions(connectionContext.getStatementProvider(), connectionContext.getConnection(), namedGraphId.toString(), connectionContext.getConfiguration().getSessionPrefix(), Long.toString(ngRevision.revision));
                            if (log.isDebugEnabled()) {
                                log.debug(LogUtils.RDB_MARKER, "[REPLICATE-INSERT_NAMEDGRAPH_NR_ENTRIES] {}:{}", insertNamedGraphEntries, (System.currentTimeMillis() - startInsertNamedGraphEntries));
                            }
                        }
                        sb.append(ngRevision.namedGraphUri + ",");
                    }
                }
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[REPLICATE-NAMEDGRAPHS] {}", sb.toString());
                }

                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[REPLICATE-INSERT_REVISIONS] {}:{}", revisionCount + norevisionCount, (System.currentTimeMillis() - start));
                }

                long insertDeltaStatements = 0;
                long insertDeltaNRStatements = 0;
                if (revisionCount > 0) {
                    long startInsertDeltaStatements = System.currentTimeMillis();
                    insertDeltaStatements = ReplicationRdbWrapper.insertDeltaStatements(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getSessionPrefix());
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "[REPLICATE-INSERT_DELTA_STATEMENTS] {}:{}", insertDeltaStatements, (System.currentTimeMillis() - startInsertDeltaStatements));
                    }
                    long startInsertDeltaNRStatements = System.currentTimeMillis();
                    insertDeltaNRStatements = ReplicationRdbWrapper.insertDeltaNRStatements(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getSessionPrefix());
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "[REPLICATE-INSERT_DELTA_NR_STATEMENTS] {}:{}", insertDeltaNRStatements, (System.currentTimeMillis() - startInsertDeltaNRStatements));
                    }

                    long startPurgeExtraStatements = System.currentTimeMillis();
                    long purgeExtraStatements = ReplicationRdbWrapper.purgeExtraStatements(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getSessionPrefix());
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "[REPLICATE-PURGE_EXTRA_STATEMENTS] {}:{}", purgeExtraStatements, (System.currentTimeMillis() - startPurgeExtraStatements));
                    }
                    insertDeltaStatements -= purgeExtraStatements;
                }
                if (insertDeltaStatements > 0 || insertDeltaNRStatements > 0 || norevisionCount > 0) {
                    Deltas deltas = new Deltas(handler, connectionContext, newGraph, cache);
                    count = processDeltaResults(connectionContext, deltas, (insertDeltaStatements > 0 || insertDeltaNRStatements > 0), (norevisionCount > 0), idToGraphs);
                    deltas.end();
                }
            } finally {
                //if (datasource.getConfiguration().getForceTempTablePurge()) {
                try {
                    BaseSQL.truncateTableWithSessionMayCommit(datasource.getStatementProvider(), connectionContext.getConnection(), datasource.getConfiguration().getSessionPrefix(), "NGR_TMP");
                    BaseSQL.truncateTableWithSessionMayCommit(datasource.getStatementProvider(), connectionContext.getConnection(), datasource.getConfiguration().getSessionPrefix(), "STMTS_REP_TMP");
                } catch (RdbException sqle) {
                    log.error(LogUtils.RDB_MARKER, "Error clearing temporary tables", sqle);
                }
                // }
                datasource.commit(connectionContext.getConnection(), false, false);
            }

        } catch (SQLException sqle) {
            SQLException cause = sqle;
            while (cause != null) {
                log.error(LogUtils.RDB_MARKER, "SQL Error in replicate", cause);
                cause = cause.getNextException();
            }
            throw new AnzoException(ExceptionConstants.SERVER.REPLICATION_FAILED, sqle, sqle.getMessage());
        } finally {
            handler.end();
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[REPLICATE-TOTAL-TIME] {}:{}", count, (System.currentTimeMillis() - startAll));
            }
            if (connectionContext != null) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    static private int processDeltaResults(NodeCentricOperationContext connectionContext, Deltas deltas, boolean revisioned, boolean noRevisioned, Map<Long, NamedGraphRevision> idToGraphs) throws SQLException, AnzoException {
        long start = System.currentTimeMillis();

        ClosableIterator<SelectNamedGraphsResult> ngResults = ReplicationRdbWrapper.selectNamedGraphs(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getSessionPrefix());
        for (SelectNamedGraphsResult ngResult : ngResults) {
            deltas.handleNamedGraph(ngResult.getNamedGraphid(), ngResult.getUuid(), ngResult.getRevision(), idToGraphs.get(ngResult.getNamedGraphid()));
        }
        int count = 0;

        if (noRevisioned) {
            ClosableIterator<SelectNewStatementsResult> resultSet = ReplicationRdbWrapper.selectNewStatements(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getSessionPrefix());
            try {
                for (SelectNewStatementsResult result : resultSet) {
                    deltas.handleStatement(true, result.getNamedGraphId(), result.getSubj(), result.getProp(), result.getObj());
                    count++;
                }
            } finally {
                resultSet.close();
            }
            ClosableIterator<SelectNewStatementsNRResult> resultSet2 = ReplicationRdbWrapper.selectNewStatementsNR(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getSessionPrefix());
            try {
                for (SelectNewStatementsNRResult result : resultSet2) {
                    deltas.handleStatement(true, result.getNamedGraphId(), result.getSubj(), result.getProp(), result.getObj());
                    count++;
                }
            } finally {
                resultSet2.close();
            }
        }
        if (revisioned) {
            ClosableIterator<SelectAllStatementResult> resultSet = ReplicationRdbWrapper.selectAllStatement(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getSessionPrefix());
            try {
                for (SelectAllStatementResult result : resultSet) {
                    deltas.handleStatement((result.getRend() == null || result.getRend() == 0), result.getNamedGraphId(), result.getSubj(), result.getProp(), result.getObj());
                    count++;
                }
            } finally {
                resultSet.close();
            }
        }
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.RDB_MARKER, "[REPLICATE-GET_ALL_STATEMENTS] {}:{}", count, (System.currentTimeMillis() - start));
        }

        return count;
    }

}
