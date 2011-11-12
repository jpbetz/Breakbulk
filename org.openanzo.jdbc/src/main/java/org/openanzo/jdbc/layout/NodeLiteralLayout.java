/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/NodeLiteralLayout.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: NodeLiteralLayout.java 178 2007-07-31 14:22:33Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.indexer.IndexerException;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.container.sql.NoSequencesSQL;
import org.openanzo.jdbc.container.sql.NodeSQL;
import org.openanzo.jdbc.container.sql.NodeSQL.FetchLiteralNodeValueResult;
import org.openanzo.jdbc.container.sql.NodeSQL.ResolveIdsLiteralResult;
import org.openanzo.jdbc.container.sql.NodeSQL.SelectAllResolvedIdsResult;
import org.openanzo.jdbc.layout.indexer.LiteralIndexer;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.IteratorUtils;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Layout for Node_Literal type. Based on NodeLayoutBase which enables long node support and aggregates two ValueLayouts for literal datatype and language
 * support.
 * 
 * @param <T>
 *            Type of literal
 * @author Joe Betz
 * @author Stephen Evanchik <evanchik@us.ibm.com>
 */
public class NodeLiteralLayout<T extends Literal> extends NodeLayoutBase<T> {

    private final Class<T>       clazz;

    private static final Logger  log  = LoggerFactory.getLogger(NodeURILayout.class);

    private final IValueLayout   datatypeLayout;

    private final IValueLayout   languageLayout;

    private final LiteralIndexer literalIndexer;

    private static final Long    ZERO = Long.valueOf(0);

    /** The string appended to the end of any string to preserve whitespace */
    public static final char     PAD  = '|';

    private final boolean        typed;

    private final NodeType       type;

    private final NodeType       longType;

    /**
     * Create a new NodeLiteralLayout
     * 
     * @param literalIndexer
     *            Optional literal indexer
     * @param stmtProvider
     *            PreparedStatementProvider from underlying connection
     * @param supportsSequences
     *            Does the underlying database support sequences to get IDs
     * @param sequenceName
     *            Name of sequence for getting IDs for literals
     * @param longSequenceName
     *            Name of sequence for getting IDs for long literals
     * @param tableName
     *            Name of table where literals are stored
     * @param longTableName
     *            Name of table where long literals are stored
     * @param resourceTempTableName
     *            Name of temporary table used during insertion and resolving of ids
     * @param idTempTableName
     *            Name of temporary table used to resolve values
     * @param maxLength
     *            The maximum length of a node's string representation before it is considered long
     * @param optimizationString
     *            Extra parameters added to queries for database specific optimizations
     * @param datatypeLayout
     *            The layout that contains Datatype data
     * @param languageLayout
     *            The layout that contains Language data
     * @param literalSchema
     *            Schema for literals
     * @param longLiteralSchema
     *            Schema for long literals
     */
    protected NodeLiteralLayout(NodeType type, NodeType longType, Class<T> clazz, LiteralIndexer literalIndexer, PreparedStatementProvider stmtProvider, boolean supportsSequences, String sequenceName, String longSequenceName, String tableName, String longTableName, String sessionPrefix, String resourceTempTableName, String idTempTableName, int maxLength, String optimizationString, IValueLayout datatypeLayout, IValueLayout languageLayout, String lockTempTableName, boolean typed) {
        super(stmtProvider, supportsSequences, sequenceName, longSequenceName, tableName, longTableName, sessionPrefix, resourceTempTableName, idTempTableName, maxLength, optimizationString, lockTempTableName);
        this.clazz = clazz;
        this.literalIndexer = literalIndexer;
        this.datatypeLayout = datatypeLayout;
        this.languageLayout = languageLayout;
        this.typed = typed;
        this.type = type;
        this.longType = longType;
    }

    public Long store(T literal, Connection connection, long transactionId) throws RdbException {
        Long nodeID = fetchId(literal, connection);
        if (nodeID != null) {
            return nodeID;
        }
        String value = literal.getLabel() + PAD;
        Long modifierId = null;

        if (literal instanceof TypedLiteral) {
            URI datatype = ((TypedLiteral) literal).getDatatypeURI();
            if (datatype.toString().trim().length() > 0) {
                modifierId = datatypeLayout.store(datatype.toString(), connection);
            }
        } else if (literal instanceof PlainLiteral) {
            String language = ((PlainLiteral) literal).getLanguage();
            if (language != null && language.trim().length() > 0) {
                modifierId = languageLayout.store(language, connection);
            }
        }
        if (modifierId == null) {
            modifierId = ZERO;
        }
        if (isLong(value)) {
            if (supportsSequences) {
                nodeID = Sequence.getNext(longSequenceName, stmtProvider, connection, supportsSequences);
                long hash = value.hashCode();
                NoSequencesSQL.insertLongLiteral(stmtProvider, connection, nodeID.longValue(), hash, value, modifierId, longTableName);
            } else {
                long hash = value.hashCode();
                nodeID = NoSequencesSQL.insertLongLiteralWithIdentity(stmtProvider, connection, hash, value, modifierId, longTableName);
                NodeSQL.insertLockedId(stmtProvider, connection, nodeID, transactionId, lockedIdsName);
            }
        } else {
            if (supportsSequences) {
                nodeID = Sequence.getNext(sequenceName, stmtProvider, connection, supportsSequences);
                NoSequencesSQL.insertLiteral(stmtProvider, connection, nodeID.longValue(), value, modifierId, tableName);
            } else {
                nodeID = NoSequencesSQL.insertLiteralWithIdentity(stmtProvider, connection, value, modifierId, tableName);
                NodeSQL.insertLockedId(stmtProvider, connection, nodeID, transactionId, lockedIdsName);
            }
        }
        if (literalIndexer != null) {
            try {
                literalIndexer.preIndex();
                literalIndexer.index(new Pair<Long, Literal>(nodeID.longValue(), literal));
            } catch (IndexerException ie) {
                log.error(LogUtils.RDB_MARKER, "Exception indexing literal:" + literal, ie);
            }
        }
        return nodeID;
    }

    @Override
    public boolean isLong(Literal n) {
        return (longTableName != null && isLong(n.getLabel()));
    }

    private boolean isLong(String value) {
        try {
            return value != null && value.getBytes(Constants.byteEncoding).length > maxLength;
        } catch (UnsupportedEncodingException uee) {
            throw new AnzoRuntimeException(ExceptionConstants.IO.ENCODING_ERROR, uee);
        }
    }

    public T fetchValue(Long id, Connection connection) throws RdbException {
        FetchLiteralNodeValueResult result;
        NodeType layoutType = NodeType.getById(id.longValue());
        if (layoutType == NodeType.LONG_LITERAL || layoutType == NodeType.TYPED_LONG_LITERAL) {
            result = NodeSQL.fetchLiteralNodeValue(stmtProvider, connection, id.longValue(), longTableName, optimizationString);
        } else {
            result = NodeSQL.fetchLiteralNodeValue(stmtProvider, connection, id.longValue(), tableName, optimizationString);
        }
        if (result == null)
            return null;
        String lexicalForm = result.getValue();
        return convert(lexicalForm, result.getModifier_id(), connection);
    }

    public T convert(String valueIn, Long modifierId, Connection connection) throws RdbException {
        String datatype = null;
        String language = null;
        if (modifierId != null && !modifierId.equals(ZERO)) {
            if (typed) {
                datatype = datatypeLayout.fetchValue(modifierId, connection);
            } else {
                language = languageLayout.fetchValue(modifierId, connection);
            }
        }
        String value = null;
        if (valueIn.charAt(valueIn.length() - 1) == PAD) {
            value = valueIn.substring(0, valueIn.length() - 1);
        }

        if (clazz.equals(TypedLiteral.class)) {
            TypedLiteral typed = Constants.valueFactory.createLiteral(value, Constants.valueFactory.createURI(datatype));
            return clazz.cast(typed);
        } else if (clazz.equals(PlainLiteral.class)) {
            PlainLiteral plain;
            if (language != null) {
                plain = Constants.valueFactory.createLiteral(value, language);
            } else {
                plain = Constants.valueFactory.createLiteral(value);
            }
            return clazz.cast(plain);
        } else {
            throw new IllegalStateException("Templated type is unsupported subclass of Literal.");
        }
    }

    @Override
    public Long fetchId(Literal literal, Connection connection) throws RdbException {
        Long modifierId = null;
        String value = literal.getLabel() + PAD;
        long hash = value.hashCode();
        Long nodeID = null;
        if (literal instanceof TypedLiteral) {
            URI datatype = ((TypedLiteral) literal).getDatatypeURI();
            if (datatype != null && datatype.toString().length() > 0) {
                modifierId = datatypeLayout.fetchId(datatype.toString(), connection);
                if (modifierId == null) {
                    // can't possibly be a match
                    return null;
                }
            }
        } else if (literal instanceof PlainLiteral) {
            String language = ((PlainLiteral) literal).getLanguage();
            if (language != null && language.trim().length() > 0) {
                modifierId = languageLayout.fetchId(language, connection);
                if (modifierId == null) {
                    // can't possibly be a match
                    return null;
                }
            }
        }
        if (modifierId == null) {
            modifierId = ZERO;
        }
        if (isLong(value)) {
            ClosableIterator<NodeSQL.FetchLongLiteralNodeIDResult> results = NodeSQL.fetchLongLiteralNodeID(stmtProvider, connection, hash, modifierId, longTableName);
            try {
                for (NodeSQL.FetchLongLiteralNodeIDResult result : results) {
                    if (result.getValue().equals(value)) {
                        nodeID = result.getId();
                        break;
                    }
                }
            } finally {
                results.close();
            }
        } else {
            nodeID = NodeSQL.fetchLiteralNodeID(stmtProvider, connection, value, modifierId, tableName, optimizationString);
        }
        return nodeID;

    }

    public NodeType getType() {
        return NodeType.LITERAL;
    }

    public long commitReferencedIds(Connection connection, long transactionId) throws RdbException {
        long start = System.currentTimeMillis();
        long uCount = NodeSQL.commitUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, tableName);
        uCount += NodeSQL.commitUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, longTableName);
        long end = System.currentTimeMillis();
        if (log.isDebugEnabled())
            log.debug(LogUtils.RDB_MARKER, "[UPDATE COMMITTED REFERENCE COUNTS LITERALS] {}:{}", uCount, (end - start));
        return uCount;
    }

    public long abortReferencedIds(Connection connection, long transactionId) throws RdbException {
        long start = System.currentTimeMillis();
        long uCount = NodeSQL.deleteUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, tableName);
        uCount += NodeSQL.deleteUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, longTableName);
        long end = System.currentTimeMillis();
        if (log.isDebugEnabled())
            log.debug(LogUtils.RDB_MARKER, "[ABORT REFERENCE COUNTS LITERALS] {}:{} ", uCount, (end - start));
        start = end;
        uCount += NodeSQL.decrementUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, tableName);
        uCount += NodeSQL.decrementUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, longTableName);
        end = System.currentTimeMillis();
        if (log.isDebugEnabled())
            log.debug(LogUtils.RDB_MARKER, "[DECREMENT REFERENCE COUNTS LITERALS] {}:{}", uCount, (end - start));
        return uCount;
    }

    public Map<Long, T> resolveStoredIds(Set<Long> ids, Connection connection) throws RdbException {
        Map<Long, T> resolved = new HashMap<Long, T>();
        ClosableIterator<ResolveIdsLiteralResult> cIter = null;
        try {
            // Insert the nodes in to a temporary table to be joined on the stored nodes' type table
            NodeSQL.BatchStoreResolveId statement = new NodeSQL.BatchStoreResolveId(connection, stmtProvider, sessionPrefix, idTempTableName);
            try {
                for (Long l : ids) {
                    statement.addEntry(l);
                }
                statement.executeStatement();
            } finally {
                statement.close();
            }
            /*
             * At this point all of the node values are in the temporary table so we can JOIN it against the node's type table
             * and get the values that are already stored.
             */
            cIter = NodeSQL.resolveIdsLiteral(stmtProvider, connection, type.getTypeMask(), type.getMaxValue(), sessionPrefix, idTempTableName, tableName);
            for (ResolveIdsLiteralResult row : cIter) {
                Long id = row.getId();
                String nodeValue = row.getValue();
                T node = convert(nodeValue, row.getModifierId(), connection);
                resolved.put(id, node);
            }
            if (longTableName != null) {
                cIter = NodeSQL.resolveIdsLiteral(stmtProvider, connection, longType.getTypeMask(), longType.getMaxValue(), sessionPrefix, idTempTableName, longTableName);
                for (ResolveIdsLiteralResult row : cIter) {
                    Long id = row.getId();
                    String nodeValue = row.getValue();
                    T node = convert(nodeValue, row.getModifierId(), connection);
                    resolved.put(id, node);
                }
            }
            BaseSQL.truncateTableWithSessionMayCommit(stmtProvider, connection, sessionPrefix, idTempTableName);
            /*
             * The nodes already stored have been split out in to this map, leaving only the nodes that need to be stored in the
             * iterator
             */
            return resolved;
        } finally {
            IteratorUtils.close(cIter);
        }
    }

    public Map<T, Long> resolveStoredNodes(Collection<T> nodes, boolean storeUnresolvedNodes, Connection connection, long transactionId) throws RdbException {
        Map<T, Long> alreadyStored = new HashMap<T, Long>();
        ClosableIterator<SelectAllResolvedIdsResult> cIter = null;
        try {
            long start = System.currentTimeMillis(), startAll = System.currentTimeMillis();
            // The helper map is used when we need to put everything back together
            // Insert the nodes in to a temporary table to be joined on the stored nodes' type table
            int shortCount = 0;
            int longCount = 0;
            ArrayList<T> newNodes = new ArrayList<T>();
            for (T literal : nodes) {
                String value = literal.getLabel() + PAD;
                if (!isLong(value)) {
                    shortCount++;
                    newNodes.add(literal);
                } else {
                    Long id = (storeUnresolvedNodes) ? store(literal, connection, transactionId) : fetchId(literal, connection);
                    if (id != null) {
                        alreadyStored.put(literal, id);
                    }
                    longCount++;
                }
            }
            insert(connection, storeUnresolvedNodes, newNodes);
            long end = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[BSRL] {}:{}:{}", new Object[] { shortCount, longCount, (end - start) });
            start = end;
            long resolvedCount = 0;
            if (shortCount > 0) {
                start = end;
                int counter = NodeSQL.resolveExistingLiterals(stmtProvider, connection, sessionPrefix, resourceTempTableName, idTempTableName, tableName);
                end = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[RESOLVE EXISTING LITERALS] {}:{}", counter, (end - start));
                resolvedCount += counter;
            }
            start = end;
            if (storeUnresolvedNodes) {
                start = end;
                long uCount = 0;
                long refCount = 0;
                if (shortCount > 0)
                    uCount += NodeSQL.updateExistingLiteralsReferenceCount(stmtProvider, connection, sessionPrefix, resourceTempTableName, tableName);
                end = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[UPDATE REFERENCE COUNTS LITERALS] {}:{}", uCount, (end - start));
                refCount = uCount;
                start = end;

                uCount = 0;
                if (shortCount > 0)
                    uCount += NodeSQL.resolveExistingUncommittedLiterals(stmtProvider, connection, sessionPrefix, resourceTempTableName, idTempTableName, tableName);
                end = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[RESOLVE UNCOMMITTED LITERALS] {}:{}", uCount, (end - start));
                resolvedCount += uCount;

                start = end;
                int pCount = 0;
                if (shortCount > 0)
                    pCount = NodeSQL.purgeResolvedLiterals(stmtProvider, connection, sessionPrefix, resourceTempTableName, idTempTableName);
                end = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[PURGE EXISTING LITERALS] {}:{}", pCount, (end - start));
                resolvedCount += uCount;

                start = end;
                uCount = 0;
                if (shortCount > 0)
                    uCount = NodeSQL.insertUnresolvedLiterals(stmtProvider, connection, sessionPrefix, resourceTempTableName, tableName, sequenceName);
                end = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[INSERT UNRESOLVED LITERALS IDS] {}:{}", uCount, (end - start));
                resolvedCount += uCount;

                start = end;
                uCount = NodeSQL.resolveExistingUncommittedLiterals(stmtProvider, connection, sessionPrefix, resourceTempTableName, idTempTableName, tableName);
                end = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[RESOLVE NEW LITERALS] {}:{}", uCount, (end - start));
                refCount += uCount;
                start = end;

                long storedCount = NodeSQL.insertUncommittedReferences(stmtProvider, connection, sessionPrefix, idTempTableName, lockedIdsName, Long.toString(transactionId));
                end = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[INSERT LOCKED IDS] {}:{}", storedCount, (end - start));
                refCount += storedCount;
            }
            long count = 0;
            if (shortCount > 0) {
                start = end;
                try {
                    start = end;
                    /*
                     * At this point all of the node values are in the temporary table so we can JOIN it against the node's type
                     * table and get the values that are already stored.
                     */
                    cIter = NodeSQL.selectAllResolvedIds(stmtProvider, connection, sessionPrefix, idTempTableName);
                    end = System.currentTimeMillis();
                    if (log.isDebugEnabled())
                        log.debug(LogUtils.RDB_MARKER, "[SELECT RESOLVED LITERALS] {}", (end - start));
                    start = end;
                    for (SelectAllResolvedIdsResult row : cIter) {
                        long id = row.getId();
                        int rowId = row.getRowid();
                        // Remove the node from the pending list and add it to the already stored list
                        T obj = newNodes.get(rowId);
                        alreadyStored.put(obj, Long.valueOf(id));
                        count++;
                    }
                    end = System.currentTimeMillis();
                } finally {
                    if (cIter != null)
                        cIter.close();
                }
            }
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[SSL] {}:{}", count, (end - start));
            start = end;
            if (storeUnresolvedNodes) {
                BaseSQL.clearTableWithSessionPrefix(stmtProvider, connection, sessionPrefix, idTempTableName);
                BaseSQL.clearTableWithSessionPrefix(stmtProvider, connection, sessionPrefix, resourceTempTableName);
            } else {
                BaseSQL.truncateTableWithSessionMayCommit(stmtProvider, connection, sessionPrefix, resourceTempTableName);
                BaseSQL.truncateTableWithSessionMayCommit(stmtProvider, connection, sessionPrefix, idTempTableName);
            }
            end = System.currentTimeMillis();

            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[PRN] {}", (end - start));
            /*
             * The nodes already stored have been split out in to this map, leaving only the nodes that need to be stored in the
             * iterator
             */
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[RESOLVE LITERALS] {}", (end - startAll));
            return alreadyStored;
        } finally {
            IteratorUtils.close(cIter);
        }
    }

    private <L extends Literal> int insert(Connection connection, boolean storeUnresolvedNodes, ArrayList<L> nodes) throws RdbException {
        if (nodes.size() > 100) {
            long start = System.currentTimeMillis();
            NodeSQL.BatchStoreResolveLiteral insertPrepared = null;
            try {
                insertPrepared = new NodeSQL.BatchStoreResolveLiteral(connection, stmtProvider, sessionPrefix, resourceTempTableName);
                for (int k = 0; k < nodes.size(); k++) {
                    L literal = nodes.get(k);
                    Long modifierId = null;
                    if (literal instanceof TypedLiteral) {
                        URI datatype = ((TypedLiteral) literal).getDatatypeURI();
                        if (datatype.toString().trim().length() > 0) {
                            modifierId = (storeUnresolvedNodes) ? datatypeLayout.store(datatype.toString(), connection) : datatypeLayout.fetchId(datatype.toString(), connection);
                            if (modifierId == null) {
                                // can't possibly be a match
                                continue;
                            }
                        }
                    } else if (literal instanceof PlainLiteral) {
                        String language = ((PlainLiteral) literal).getLanguage();
                        if (language != null && language.trim().length() > 0) {
                            modifierId = (storeUnresolvedNodes) ? languageLayout.store(language, connection) : languageLayout.fetchId(language, connection);
                            if (modifierId == null) {
                                // can't possibly be a match
                                continue;
                            }
                        }
                    }
                    if (modifierId == null)
                        modifierId = ZERO;
                    String value = literal.getLabel() + PAD;
                    insertPrepared.addEntry(k, value, modifierId);
                }
                insertPrepared.executeStatement();
                long end = System.currentTimeMillis();
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[BATCH INSERT TEMP LITERAL] {}:{}", Integer.toString(nodes.size()), Long.toString((end - start)));
                }
            } finally {
                try {
                    if (insertPrepared != null) {
                        insertPrepared.close();
                    }
                } catch (RdbException sqle) {
                    if (log.isTraceEnabled()) {
                        log.trace(LogUtils.RDB_MARKER, "Exception closing prepared statement", sqle);
                    }
                }
            }
            return nodes.size();
        } else if (nodes.size() > 0) {
            long start = System.currentTimeMillis();
            for (int k = 0; k < nodes.size(); k++) {
                L literal = nodes.get(k);
                Long modifierId = null;
                if (literal instanceof TypedLiteral) {
                    URI datatype = ((TypedLiteral) literal).getDatatypeURI();
                    if (datatype.toString().trim().length() > 0) {
                        modifierId = (storeUnresolvedNodes) ? datatypeLayout.store(datatype.toString(), connection) : datatypeLayout.fetchId(datatype.toString(), connection);
                        if (modifierId == null) {
                            // can't possibly be a match
                            continue;
                        }
                    }
                } else if (literal instanceof PlainLiteral) {
                    String language = ((PlainLiteral) literal).getLanguage();
                    if (language != null && language.trim().length() > 0) {
                        modifierId = (storeUnresolvedNodes) ? languageLayout.store(language, connection) : languageLayout.fetchId(language, connection);
                        if (modifierId == null) {
                            // can't possibly be a match
                            continue;
                        }
                    }
                }
                if (modifierId == null)
                    modifierId = ZERO;
                String value = literal.getLabel() + PAD;

                NodeSQL.storeResolveLiteral(stmtProvider, connection, k, value, modifierId, sessionPrefix, resourceTempTableName);
            }
            long end = System.currentTimeMillis();
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[INDV INSERT TEMP LITERAL] {}:{}", Integer.toString(nodes.size()), Long.toString((end - start)));
            }
            return nodes.size();
        } else {
            return 0;
        }
    }
}
