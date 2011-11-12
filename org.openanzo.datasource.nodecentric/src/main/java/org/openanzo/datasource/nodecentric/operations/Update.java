/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jan 18, 2008
 * Revision:    $Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.operations;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.openanzo.datasource.IStoredNamedGraph;
import org.openanzo.datasource.nodecentric.internal.NodeCentricDatasource;
import org.openanzo.datasource.nodecentric.internal.NodeCentricOperationContext;
import org.openanzo.datasource.nodecentric.sql.InsertStatementsRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.InsertStatementsRdbWrapper.SelectInsertStatementsResult;
import org.openanzo.datasource.update.UpdateChanges;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.UriGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Update {
    private static final Logger log       = LoggerFactory.getLogger(Update.class);

    private static final String STMTS_TMP = "STMTS_TMP";

    /**
     * Update statements in database
     * 
     * @param context
     *            context for operation
     * @param transactionId
     *            id of transaction
     * @param namedGraphs
     *            namedgraphs to store
     * @param additions
     *            statements to add
     * @param deletions
     *            statements to remove
     * @param storedNodes
     *            resolved values to ids
     * @param insertDirect
     *            stand alone insert that does not need 2 stage committed insert
     * @return the updates
     * @throws AnzoException
     */
    static public UpdateChanges update(NodeCentricOperationContext context, Long transactionId, Map<URI, IStoredNamedGraph> namedGraphs, Collection<Statement> additions, Collection<Statement> deletions, Map<Value, Long> storedNodes, boolean insertDirect) throws AnzoException {
        UpdateChanges updateResults = new UpdateChanges();
        if ((additions == null || additions.size() == 0) && (deletions == null || deletions.size() == 0))
            return updateResults;
        int countA = 0;
        int countR = 0;
        long startOverall = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        Statement[] additionsArray = (additions != null) ? new HashSet<Statement>(additions).toArray(new Statement[0]) : null;
        long middle = System.currentTimeMillis();
        try {
            int adds = 0;
            if (additions != null && additions.size() > 0)
                adds = insert(context, (insertDirect ? 0 : transactionId), namedGraphs, additionsArray, storedNodes);
            Statement[] removalsArray = (deletions != null) ? new HashSet<Statement>(deletions).toArray(new Statement[0]) : null;
            int removes = 0;
            if (deletions != null && deletions.size() > 0)
                removes = remove(context, -1 * transactionId, namedGraphs, removalsArray);

            middle = System.currentTimeMillis();
            start = middle;
            if (adds > 0 && removes > 0) {
                int pis = InsertStatementsRdbWrapper.purgeInsertRemoveStatements(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
                middle = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[PURGE ADD/REMOVE STATEMENTS] {}:{}", Integer.toString(pis), Long.toString((middle - start)));
            }

            if (adds > 0) {

                int pis = InsertStatementsRdbWrapper.purgeInsertStatements(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
                adds = adds - pis;
                middle = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[PURGE EXISTING STATEMENTS] {}:{}", Integer.toString(pis), Long.toString((middle - start)));
            }
            start = middle;
            if (removes > 0) {
                int prs = InsertStatementsRdbWrapper.purgeRemoveStatements(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
                middle = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[PURGE NONEXISTING REMOVES] {}:{}", Integer.toString(prs), Long.toString((middle - start)));
                removes = removes - prs;
                start = System.currentTimeMillis();

                if (removes > 0) {
                    if (context.getConfiguration().getLimitTransactionSize() && removalsArray.length > NodeCentricDatasource.MAX_OPERATION_SIZE) {
                        for (int i = 0; (i * NodeCentricDatasource.MAX_OPERATION_SIZE) <= removalsArray.length; i++) {
                            int offset = (i * NodeCentricDatasource.MAX_OPERATION_SIZE);
                            int max = Math.min(offset + NodeCentricDatasource.MAX_OPERATION_SIZE, removalsArray.length);
                            start = System.currentTimeMillis();
                            int count = InsertStatementsRdbWrapper.commitRemoveStatementsRange(context.getStatementProvider(), context.getConnection(), -1 * transactionId, offset, max, context.getConfiguration().getSessionPrefix());
                            countR += count;
                            middle = System.currentTimeMillis();
                            if (log.isDebugEnabled())
                                log.debug(LogUtils.RDB_MARKER, "[COMMIT REMOVED STATEMENTS RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), Long.toString(count), Long.toString((middle - start)) });
                        }
                    } else {
                        countR = InsertStatementsRdbWrapper.commitRemoveStatements(context.getStatementProvider(), context.getConnection(), -1 * transactionId, context.getConfiguration().getSessionPrefix());
                        middle = System.currentTimeMillis();
                        if (log.isDebugEnabled())
                            log.debug(LogUtils.RDB_MARKER, "[COMMIT REMOVED STATEMENTS] {}:{}", Long.toString(countR), Long.toString((middle - start)));
                    }
                }
            }
            start = System.currentTimeMillis();
            if (adds > 0) {
                if (context.getConfiguration().getLimitTransactionSize() && additionsArray.length > NodeCentricDatasource.MAX_OPERATION_SIZE) {
                    for (int i = 0; (i * NodeCentricDatasource.MAX_OPERATION_SIZE) <= additionsArray.length; i++) {
                        int offset = (i * NodeCentricDatasource.MAX_OPERATION_SIZE);
                        int max = Math.min(offset + NodeCentricDatasource.MAX_OPERATION_SIZE, additionsArray.length);
                        start = System.currentTimeMillis();
                        long count = InsertStatementsRdbWrapper.commitInsertStatementsRange(context.getStatementProvider(), context.getConnection(), offset, max, context.getConfiguration().getSessionPrefix());
                        countA += count;
                        middle = System.currentTimeMillis();
                        if (log.isDebugEnabled())
                            log.debug(LogUtils.RDB_MARKER, "[COMMIT INSERTED STATEMENTS RANGE {}-{}] {}:{}", new Object[] { Integer.toString(offset), Integer.toString(max), Long.toString(count), Long.toString((middle - start)) });
                    }
                } else {
                    countA = InsertStatementsRdbWrapper.commitInsertStatements(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
                    middle = System.currentTimeMillis();
                    if (log.isDebugEnabled())
                        log.debug(LogUtils.RDB_MARKER, "[COMMIT INSERTED STATEMENTS] {}:{}", Long.toString(countA), Long.toString((middle - start)));
                }
            }
            start = middle;
            ClosableIterator<SelectInsertStatementsResult> results = null;
            try {
                results = InsertStatementsRdbWrapper.selectInsertStatements(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
                middle = System.currentTimeMillis();
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[SELECT UPDATED STATEMENTS] {}", Long.toString((middle - start)));
                }
                start = middle;
                while (results.hasNext()) {
                    SelectInsertStatementsResult result = results.next();
                    int id = result.getStmtId();
                    if (result.getOperation() == 1) {
                        URI ngURI = additionsArray[id].getNamedGraphUri();
                        if (!ngURI.equals(GRAPHS.GRAPHS_DATASET) && !ngURI.equals(GRAPHS.METADATA_GRAPHS_DATASET)) {
                            updateResults.namedGraphs.add(namedGraphs.get(ngURI));
                        }
                        updateResults.addedStatements.add(additionsArray[id]);
                    } else {
                        URI ngURI = removalsArray[id].getNamedGraphUri();
                        if (!ngURI.equals(GRAPHS.GRAPHS_DATASET) && !ngURI.equals(GRAPHS.METADATA_GRAPHS_DATASET)) {
                            updateResults.namedGraphs.add(namedGraphs.get(ngURI));
                        }
                        updateResults.removedStatements.add(removalsArray[id]);
                    }
                }
            } finally {
                if (results != null)
                    results.close();
            }
            middle = System.currentTimeMillis();
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[RESOLVE UPDATED STATEMENTS] {}", Long.toString((middle - start)));
            }
            start = middle;
            InsertStatementsRdbWrapper.commitStatementIds(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
        } finally {
            BaseSQL.truncateTableWithSessionMayCommit(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), STMTS_TMP);
        }
        middle = System.currentTimeMillis();
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.RDB_MARKER, "[DELETE TEMP STATEMENTS] {}", Long.toString((middle - start)));
        }
        long totalTime = (System.currentTimeMillis() - startOverall);
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.RDB_MARKER, "[STORED] {}:{}:{} Q/ms:{} ms/Q", new Object[] { Long.toString(countA), Long.toString(totalTime), Long.toString((countA / (totalTime + 1))), Long.toString((totalTime / (countA + 1))) });
        }

        return updateResults;

    }

    /**
     * Update statements in database
     * 
     * @param context
     *            context for operation
     * @param transactionId
     *            id of transaction
     * @param namedGraphs
     *            namedgraphs to store
     * @param additions
     *            statements to add
     * @param deletions
     *            statements to remove
     * @param storedNodes
     *            resolved values to ids
     * @param insertDirect
     *            stand alone insert that does not need 2 stage committed insert
     * @return the updates
     * @throws AnzoException
     */
    static public UpdateChanges updateNR(NodeCentricOperationContext context, Long transactionId, Map<URI, IStoredNamedGraph> namedGraphs, Collection<Statement> additions, Collection<Statement> deletions, Map<Value, Long> storedNodes, boolean insertDirect) throws AnzoException {
        UpdateChanges updateResults = new UpdateChanges();
        if ((additions == null || additions.size() == 0) && (deletions == null || deletions.size() == 0))
            return updateResults;
        int countA = 0;
        int countR = 0;
        long startOverall = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        Statement[] additionsArray = (additions != null) ? new HashSet<Statement>(additions).toArray(new Statement[0]) : null;
        int adds = 0;
        if (additions != null && additions.size() > 0)
            adds = insert(context, insertDirect ? 0 : transactionId, namedGraphs, additionsArray, storedNodes);
        Statement[] removalsArray = (deletions != null) ? new HashSet<Statement>(deletions).toArray(new Statement[0]) : null;
        int removes = 0;
        if (deletions != null && deletions.size() > 0)
            removes = remove(context, (-1 * transactionId), namedGraphs, removalsArray);
        long middle = System.currentTimeMillis();
        long pis = 0;
        if (adds > 0) {
            pis = InsertStatementsRdbWrapper.purgeInsertStatementsNR(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[PURGE EXISTING STATEMENTS_NR] {}:{}", Long.toString(pis), Long.toString((middle - start)));
            start = middle;
        }
        long prs = 0;
        if (removes > 0) {
            prs = InsertStatementsRdbWrapper.purgeRemoveStatementsNR(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
            middle = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[PURGE NONEXISTING REMOVES_NR] {}:{}", Long.toString(prs), Long.toString((middle - start)));
            start = System.currentTimeMillis();
            if (removes - prs > 0) {
                countR = InsertStatementsRdbWrapper.commitRemoveStatementsNR(context.getStatementProvider(), context.getConnection(), (-1 * transactionId), context.getConfiguration().getSessionPrefix());
                middle = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[COMMIT REMOVED STATEMENTS_NR] {}:{}", Long.toString(countR), Long.toString((middle - start)));
            }
        }
        if (adds - pis > 0) {
            start = System.currentTimeMillis();
            countA = InsertStatementsRdbWrapper.commitInsertStatementsNR(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
            middle = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[COMMIT INSERTED STATEMENTS_NR] {}:{}", Long.toString(countA), Long.toString((middle - start)));
            start = middle;
        }
        if (countA + countR > 0) {
            ClosableIterator<SelectInsertStatementsResult> results = null;
            try {
                results = InsertStatementsRdbWrapper.selectInsertStatements(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix());
                middle = System.currentTimeMillis();
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[SELECT UPDATED STATEMENTS_NR] {}", Long.toString((middle - start)));
                }
                start = middle;
                while (results.hasNext()) {
                    SelectInsertStatementsResult result = results.next();
                    int id = result.getStmtId();
                    if (result.getOperation() == 1) {
                        URI ngURI = additionsArray[id].getNamedGraphUri();
                        if (!ngURI.equals(GRAPHS.GRAPHS_DATASET) && !ngURI.equals(GRAPHS.METADATA_GRAPHS_DATASET)) {
                            updateResults.namedGraphs.add(namedGraphs.get(ngURI));
                        }
                        updateResults.addedStatements.add(additionsArray[id]);
                    } else {
                        URI ngURI = removalsArray[id].getNamedGraphUri();
                        if (!ngURI.equals(GRAPHS.GRAPHS_DATASET) && !ngURI.equals(GRAPHS.METADATA_GRAPHS_DATASET)) {
                            updateResults.namedGraphs.add(namedGraphs.get(ngURI));
                        }
                        updateResults.removedStatements.add(removalsArray[id]);
                    }
                }
            } finally {
                if (results != null)
                    results.close();
            }

            middle = System.currentTimeMillis();
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[RESOLVE UPDATED STATEMENTS_NR] {}", Long.toString((middle - start)));
            }
        }
        start = middle;
        BaseSQL.clearTableWithSessionPrefix(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), STMTS_TMP);
        middle = System.currentTimeMillis();
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.RDB_MARKER, "[DELETE TEMP STATEMENTS_NR] {}", Long.toString((middle - start)));
        }
        long totalTime = (System.currentTimeMillis() - startOverall);
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.RDB_MARKER, "[STORED_NR] {}:{}:{} Q/ms:{} ms/Q", new Object[] { Long.toString(countA), Long.toString(totalTime), Long.toString((countA / (totalTime + 1))), Long.toString((totalTime / (countA + 1))) });
        }

        return updateResults;

    }

    private static final String ID_STRING = "{0}:{1}:{2}:{3}";

    static private int insert(NodeCentricOperationContext context, long transactionId, Map<URI, IStoredNamedGraph> revisions, Statement[] statements, Map<Value, Long> storedNodes) throws AnzoException {
        try {
            if (context.getConfiguration().getSupportsTempForInsert() && statements.length > 0) {
                InsertStatementsRdbWrapper.BatchInsertTempStatement insertPrepared = new InsertStatementsRdbWrapper.BatchInsertTempStatement(context.getConnection(), context.getStatementProvider(), context.getConfiguration().getSessionPrefix());
                try {
                    long start = System.currentTimeMillis();
                    long end = 0;
                    URI lastNG = null;
                    Long lastUUID = null;
                    Map<URI, Long> uriToUUIDid = new HashMap<URI, Long>();
                    for (int i = 0; (i * NodeCentricDatasource.MAX_OPERATION_SIZE) <= statements.length; i++) {
                        int offset = (i * NodeCentricDatasource.MAX_OPERATION_SIZE);
                        for (int k = offset; k < Math.min(offset + NodeCentricDatasource.MAX_OPERATION_SIZE, statements.length); k++) {
                            Statement statement = statements[k];
                            Long ngId = storedNodes.get(statement.getNamedGraphUri());
                            Long subjId = storedNodes.get(statement.getSubject());
                            Long predId = storedNodes.get(statement.getPredicate());
                            Long objId = storedNodes.get(statement.getObject());
                            if (ngId == null || subjId == null || predId == null || objId == null) {
                                throw new RdbException(ExceptionConstants.DATASOURCE.LOAD_OBJECT);
                            }
                            String stmtId = MessageFormat.format(ID_STRING, ngId.toString(), subjId.toString(), predId.toString(), objId.toString());
                            IStoredNamedGraph revision = revisions.get(statement.getNamedGraphUri());
                            if (lastNG == null || !lastNG.equals(statement.getNamedGraphUri())) {
                                lastUUID = uriToUUIDid.get(statement.getNamedGraphUri());
                                if (lastUUID == null) {
                                    lastUUID = context.getNodeLayout().fetchId(revision.getUUID(), context.getConnection());
                                    if (lastUUID == null) {
                                        throw new RdbException(ExceptionConstants.DATASOURCE.LOAD_OBJECT);
                                    }
                                    uriToUUIDid.put(statement.getNamedGraphUri(), lastUUID);
                                }
                                lastNG = statement.getNamedGraphUri();
                            }
                            insertPrepared.addEntry(1, k, stmtId, UriGenerator.isMetadataGraphUri(statement.getNamedGraphUri()) ? 1 : 0, lastUUID, ngId, subjId, predId, objId, revision.getNewRevision(), transactionId);
                        }
                        insertPrepared.executeStatement();
                    }

                    end = System.currentTimeMillis();
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "[BATCH INSERT TEMP STATEMENTS] {}:{}", Integer.toString(statements.length), Long.toString((end - start)));
                    }
                    return statements.length;
                } finally {
                    insertPrepared.close();
                }
            } else if (statements.length > 0) {
                long start = System.currentTimeMillis();
                URI lastNG = null;
                Long lastUUID = null;
                Map<URI, Long> uriToUUIDid = new HashMap<URI, Long>();
                for (int k = 0; k < statements.length; k++) {
                    Statement statement = statements[k];
                    Long ngId = storedNodes.get(statement.getNamedGraphUri());
                    Long subjId = storedNodes.get(statement.getSubject());
                    Long predId = storedNodes.get(statement.getPredicate());
                    Long objId = storedNodes.get(statement.getObject());
                    if (ngId == null || subjId == null || predId == null || objId == null) {
                        throw new RdbException(ExceptionConstants.DATASOURCE.LOAD_OBJECT);
                    }
                    String stmtId = MessageFormat.format(ID_STRING, ngId.toString(), subjId.toString(), predId.toString(), objId.toString());
                    IStoredNamedGraph revision = revisions.get(statement.getNamedGraphUri());
                    if (lastNG == null || !lastNG.equals(statement.getNamedGraphUri())) {
                        lastUUID = uriToUUIDid.get(statement.getNamedGraphUri());
                        if (lastUUID == null) {
                            lastUUID = context.getNodeLayout().fetchId(revision.getUUID(), context.getConnection());

                            if (lastUUID == null) {
                                throw new RdbException(ExceptionConstants.DATASOURCE.LOAD_OBJECT);
                            }
                            uriToUUIDid.put(statement.getNamedGraphUri(), lastUUID);
                        }
                        lastNG = statement.getNamedGraphUri();
                    }
                    InsertStatementsRdbWrapper.insertTempStatement(context.getStatementProvider(), context.getConnection(), 1, k, stmtId, statement.getNamedGraphUri().toString().startsWith(NAMESPACES.METADATAGRAPH_PREFIX) ? 1 : 0, lastUUID, ngId, subjId, predId, objId, revision.getNewRevision(), transactionId, context.getConfiguration().getSessionPrefix());
                }
                long end = System.currentTimeMillis();
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[INDV INSERT TEMP STATEMENTS] {}:{}", Integer.toString(statements.length), Long.toString((end - start)));
                }
                return statements.length;
            } else {
                return 0;
            }
        } catch (RdbException rdb) {
            throw new AnzoException(ExceptionConstants.RDB.FAILED_EXECUTING_SQL, rdb);
        }
    }

    static private int remove(NodeCentricOperationContext context, long transactionId, Map<URI, IStoredNamedGraph> revisions, Statement[] statements) throws AnzoException {
        try {
            long start = System.currentTimeMillis();
            long end = 0;
            int total = 0;
            if (context.getConfiguration().getSupportsTempForInsert() && statements.length > 0) {
                InsertStatementsRdbWrapper.BatchInsertTempStatement insertPrepared = new InsertStatementsRdbWrapper.BatchInsertTempStatement(context.getConnection(), context.getStatementProvider(), context.getConfiguration().getSessionPrefix());

                try {
                    HashSet<Value> values = new HashSet<Value>();
                    for (org.openanzo.rdf.Statement statement : statements) {
                        values.add(statement.getNamedGraphUri());
                        values.add(statement.getSubject());
                        values.add(statement.getPredicate());
                        values.add(statement.getObject());
                    }
                    Map<Value, Long> alreadyStored = context.getNodeLayout().resolveStoredNodes(values, false, context.getConnection(), -1);

                    end = System.currentTimeMillis();
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "[RESOLVE_STORED_NODES] {}:{}", Integer.toString(alreadyStored.size()), Long.toString((end - start)));
                    }
                    start = end;
                    URI lastNG = null;
                    Long lastUUID = null;
                    Map<URI, Long> uriToUUIDid = new HashMap<URI, Long>();
                    for (int i = 0; (i * NodeCentricDatasource.MAX_OPERATION_SIZE) <= statements.length; i++) {
                        int offset = (i * NodeCentricDatasource.MAX_OPERATION_SIZE);
                        for (int k = offset; k < Math.min(offset + NodeCentricDatasource.MAX_OPERATION_SIZE, statements.length); k++) {
                            Statement statement = statements[k];
                            Long ngId = alreadyStored.get(statement.getNamedGraphUri());
                            if (ngId == null) {
                                continue;
                            }
                            Long subjId = alreadyStored.get(statement.getSubject());
                            if (subjId == null) {
                                continue;
                            }
                            Long predId = alreadyStored.get(statement.getPredicate());
                            if (predId == null) {
                                continue;
                            }
                            Long objId = alreadyStored.get(statement.getObject());
                            if (objId == null) {
                                continue;
                            }

                            String stmtId = MessageFormat.format(ID_STRING, ngId.toString(), subjId.toString(), predId.toString(), objId.toString());
                            IStoredNamedGraph revision = revisions.get(statement.getNamedGraphUri());
                            if (lastNG == null || !lastNG.equals(statement.getNamedGraphUri())) {
                                lastUUID = uriToUUIDid.get(statement.getNamedGraphUri());
                                if (lastUUID == null) {
                                    lastUUID = context.getNodeLayout().fetchId(revision.getUUID(), context.getConnection());

                                    if (lastUUID == null) {
                                        throw new RdbException(ExceptionConstants.DATASOURCE.LOAD_OBJECT);
                                    }
                                    uriToUUIDid.put(statement.getNamedGraphUri(), lastUUID);
                                }
                                lastNG = statement.getNamedGraphUri();
                            }
                            insertPrepared.addEntry(0, k, stmtId, UriGenerator.isMetadataGraphUri(statement.getNamedGraphUri()) ? 1 : 0, lastUUID, ngId, subjId, predId, objId, revision.getNewRevision(), transactionId);
                            total++;
                        }
                        insertPrepared.executeStatement();
                    }
                    end = System.currentTimeMillis();
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "[BATCH INSERT TEMP STATEMENTS] {}:{}", Integer.toString(total), Long.toString((end - start)));
                    }
                } finally {
                    insertPrepared.close();
                }
            } else if (statements.length > 0) {
                URI lastNG = null;
                Long lastUUID = null;
                Map<URI, Long> uriToUUIDid = new HashMap<URI, Long>();
                for (int id = 0; id < statements.length; id++) {
                    Statement statement = statements[id];
                    Long ngId = context.getNodeLayout().fetchId(statement.getNamedGraphUri(), context.getConnection());
                    Long subjId = context.getNodeLayout().fetchId(statement.getSubject(), context.getConnection());
                    Long predId = context.getNodeLayout().fetchId(statement.getPredicate(), context.getConnection());
                    Long objId = context.getNodeLayout().fetchId(statement.getObject(), context.getConnection());
                    if (ngId != null && subjId != null && predId != null && objId != null) {
                        String stmtId = MessageFormat.format(ID_STRING, ngId.toString(), subjId.toString(), predId.toString(), objId.toString());
                        IStoredNamedGraph revision = revisions.get(statement.getNamedGraphUri());
                        if (lastNG == null || !lastNG.equals(statement.getNamedGraphUri())) {
                            lastUUID = uriToUUIDid.get(statement.getNamedGraphUri());
                            if (lastUUID == null) {
                                lastUUID = context.getNodeLayout().fetchId(revision.getUUID(), context.getConnection());

                                if (lastUUID == null) {
                                    throw new RdbException(ExceptionConstants.DATASOURCE.LOAD_OBJECT);
                                }
                                uriToUUIDid.put(statement.getNamedGraphUri(), lastUUID);
                            }
                            lastNG = statement.getNamedGraphUri();
                        }
                        InsertStatementsRdbWrapper.insertTempStatement(context.getStatementProvider(), context.getConnection(), 0, total, stmtId, statement.getNamedGraphUri().toString().startsWith(NAMESPACES.METADATAGRAPH_PREFIX) ? 1 : 0, lastUUID, ngId, subjId, predId, objId, revision.getNewRevision(), transactionId, context.getConfiguration().getSessionPrefix());
                    }
                    total++;
                }
                end = System.currentTimeMillis();
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[INDV INSERT TEMP STATEMENTS] {}:{}", Integer.toString(total), Long.toString((end - start)));
                }
            }

            return total;

        } catch (RdbException rdb) {
            throw new AnzoException(ExceptionConstants.RDB.FAILED_EXECUTING_SQL, rdb);
        }
    }

}
