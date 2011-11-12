/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/NodeURILayout.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: NodeURILayout.java 178 2007-07-31 14:22:33Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.container.sql.NoSequencesSQL;
import org.openanzo.jdbc.container.sql.NodeSQL;
import org.openanzo.jdbc.container.sql.NodeSQL.ResolveIdsUriResult;
import org.openanzo.jdbc.container.sql.NodeSQL.SelectAllResolvedIdsResult;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.IteratorUtils;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Layout for Node_URI and Node_Blank. Based on NodeLayoutBase which enables long node support for uri types that provide a long table name.
 * 
 * @param <T>
 *            type of Resource being stored in this layout
 * @author Joe Betz
 * @author Stephen Evanchik <evanchik@us.ibm.com>
 */
class NodeURILayout<T extends Resource> extends NodeLayoutBase<T> {
    private static final Logger log = LoggerFactory.getLogger(NodeURILayout.class);

    private final NodeType      type;

    private final NodeType      longType;

    /**
     * Construct a layout to store Resources (URIs or BNodes) in a database
     * 
     * @param type
     *            Type of nodes this is storing
     * @param stmtProvider
     *            The interface to the SQL prepared statement cache
     * @param supportsSequences
     *            Does the underlying database support sequences to get IDs
     * @param sequenceName
     *            The name of the sequence that is used to get IDs
     * @param longSequenceName
     *            The name of the sequence that is used to get IDs for long objects
     * @param tableName
     *            The name of the table where the nodes are stored
     * @param resourceTempTableName
     *            The name of the temporary table used to bulk insert nodes
     * @param idTempTableName
     *            The name of the temporary table used to bulk id resolution
     * @param optimizationString
     *            Extra parameters added to queries for database specific optimizations
     */
    protected NodeURILayout(NodeType type, NodeType longType, PreparedStatementProvider stmtProvider, boolean supportsSequences, String sequenceName, String longSequenceName, String tableName, String sessionPrefix, String resourceTempTableName, String idTempTableName, String optimizationString, String lockTempTableName) {
        super(stmtProvider, supportsSequences, sequenceName, longSequenceName, tableName, null, sessionPrefix, resourceTempTableName, idTempTableName, 0, optimizationString, lockTempTableName);
        if (!(type == NodeType.URI || type == NodeType.BLANK))
            throw new UnsupportedOperationException("Unsupported type passed to NodeURILayout constructor: " + type);
        this.type = type;
        this.longType = longType;
    }

    /**
     * Construct a layout to store Resources (URIs or BNodes) in a database
     * 
     * @param type
     *            Type of nodes this is storing
     * @param stmtProvider
     *            The interface to the SQL prepared statement cache
     * @param supportsSequences
     *            Does the underlying database support sequences to get IDs
     * @param sequenceName
     *            The name of the sequence that is used to get IDs
     * @param longSequenceName
     *            The name of the sequence that is used to get IDs for long objects
     * @param tableName
     *            The name of the table where the nodes are stored
     * @param longTableName
     *            The name of the table where excessively long nodes are stored
     * @param resourceTempTableName
     *            The name of the temporary table used to bulk insert nodes
     * @param idTempTableName
     *            The name of the temporary table used to bulk id resolution
     * @param maxLength
     *            The maximum length of a node's string representation before it is considered long
     * @param optimizationString
     *            Extra parameters added to queries for database specific optimizations
     */
    protected NodeURILayout(NodeType type, NodeType longType, PreparedStatementProvider stmtProvider, boolean supportsSequences, String sequenceName, String longSequenceName, String tableName, String longTableName, String sessionPrefix, String resourceTempTableName, String idTempTableName, int maxLength, String optimizationString, String lockTempTableName) {
        super(stmtProvider, supportsSequences, sequenceName, longSequenceName, tableName, longTableName, sessionPrefix, resourceTempTableName, idTempTableName, maxLength, optimizationString, lockTempTableName);
        if (!(type == NodeType.URI || type == NodeType.BLANK))
            throw new UnsupportedOperationException("Unsupported type passed to NodeURILayout constructor: " + type);
        this.type = type;
        this.longType = longType;
    }

    public Long store(T n, Connection connection, long transactionId) throws RdbException {
        Long nodeID = fetchId(n, connection);
        if (nodeID != null)
            return nodeID;

        String value;
        if (n instanceof BlankNode) {
            value = ((BlankNode) n).getLabel();
        } else {
            value = n.toString();
        }

        long hash = n.hashCode();
        if (isLong(n)) {
            if (supportsSequences) {
                nodeID = Sequence.getNext(longSequenceName, stmtProvider, connection, supportsSequences);
                NoSequencesSQL.insertLongNode(stmtProvider, connection, nodeID, hash, value, longTableName);
                NodeSQL.insertLockedId(stmtProvider, connection, nodeID, transactionId, lockedIdsName);
            } else {
                nodeID = NoSequencesSQL.insertLongNodeWithIdentity(stmtProvider, connection, hash, value, longTableName);
                NodeSQL.insertLockedId(stmtProvider, connection, nodeID, transactionId, lockedIdsName);
            }
        } else {
            if (supportsSequences) {
                nodeID = Sequence.getNext(sequenceName, stmtProvider, connection, supportsSequences);
                NoSequencesSQL.insertNode(stmtProvider, connection, nodeID, value, tableName);
                NodeSQL.insertLockedId(stmtProvider, connection, nodeID, transactionId, lockedIdsName);
            } else {
                nodeID = NoSequencesSQL.insertNodeWithIdentity(stmtProvider, connection, value, tableName);
                NodeSQL.insertLockedId(stmtProvider, connection, nodeID, transactionId, lockedIdsName);
            }
        }
        return nodeID;
    }

    public T fetchValue(Long id, Connection connection) throws RdbException {
        return convert(fetchLabel(id, connection), null, connection);
    }

    @SuppressWarnings("unchecked")
    public T convert(String value, Long modifiedId, Connection connection) throws RdbException {
        if (type == NodeType.URI) {
            return (T) Constants.valueFactory.createURI(value);
            // return new IdNode_URI(this, id);
        } else if (type == NodeType.BLANK) {
            return (T) Constants.valueFactory.createBNode(value);
            // return new IdNode_Blank(this, id);
        }
        throw new UnsupportedOperationException("Unsupported type passed to NodeURILayout constructor: " + type);
    }

    /*
     * public Object fetchLabel(IdNode idNode) { return fetchLabel(idNode.getId()); }
     */
    private String fetchLabel(Long id, Connection connection) throws RdbException {
        String nodeString;
        NodeType layoutType = NodeType.getById(id.longValue());
        if (layoutType == NodeType.LONG_URI) {
            nodeString = NodeSQL.fetchNodeValue(stmtProvider, connection, id.longValue(), longTableName, optimizationString);
        } else {
            nodeString = NodeSQL.fetchNodeValue(stmtProvider, connection, id.longValue(), tableName, optimizationString);
        }
        if (nodeString == null)
            throw new RdbException(ExceptionConstants.RDB.NO_VALUE_FOUND, id.toString());
        return nodeString;
    }

    public long commitReferencedIds(Connection connection, long transactionId) throws RdbException {
        long start = System.currentTimeMillis();
        long uCount = NodeSQL.commitUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, tableName);
        if (longTableName != null)
            uCount += NodeSQL.commitUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, longTableName);
        long end = System.currentTimeMillis();
        if (log.isDebugEnabled())
            log.debug(LogUtils.RDB_MARKER, "[UPDATE COMMITTED REFERENCE COUNTS URIS] {}:{}", uCount, (end - start));
        return uCount;
    }

    public long abortReferencedIds(Connection connection, long transactionId) throws RdbException {
        long start = System.currentTimeMillis();
        long uCount = NodeSQL.deleteUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, tableName);
        if (longTableName != null)
            uCount += NodeSQL.deleteUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, longTableName);
        long end = System.currentTimeMillis();
        if (log.isDebugEnabled())
            log.debug(LogUtils.RDB_MARKER, "[ABORT REFERENCE COUNTS URIS] {}:{}", uCount, (end - start));
        start = end;
        uCount += NodeSQL.decrementUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, tableName);
        if (longTableName != null)
            uCount += NodeSQL.decrementUncommittedReferences(stmtProvider, connection, transactionId, lockedIdsName, longTableName);
        end = System.currentTimeMillis();
        if (log.isDebugEnabled())
            log.debug(LogUtils.RDB_MARKER, "[DECREMENT REFERENCE COUNTS URIS]{}:{}", uCount, (end - start));
        return uCount;
    }

    public Map<T, Long> resolveStoredNodes(Collection<T> nodes, boolean storeUnResolvedNodes, Connection connection, long transactionId) throws RdbException {
        Map<T, Long> alreadyStored = new HashMap<T, Long>();
        ClosableIterator<SelectAllResolvedIdsResult> cIter = null;
        long start = System.currentTimeMillis(), startAll = System.currentTimeMillis();
        // The helper map is used when we need to put everything back together
        // Insert the nodes in to a temporary table to be joined on the stored nodes' type table
        int shortCount = 0;
        int longCount = 0;
        ArrayList<T> newNodes = new ArrayList<T>();
        for (T n : nodes) {
            if (!isLong(n)) {
                shortCount++;
                // Keep a mapping of the String to Resource for the String's type
                newNodes.add(n);
            } else {
                Long id = (storeUnResolvedNodes) ? store(n, connection, transactionId) : fetchId(n, connection);
                if (id != null) {
                    alreadyStored.put(n, id);
                }
                longCount++;
            }
        }
        insert(connection, newNodes);
        long end = System.currentTimeMillis();
        if (log.isDebugEnabled())
            log.debug(LogUtils.RDB_MARKER, "[BSRN]" + shortCount + ":" + longCount + ":" + (end - start));
        start = end;
        long resolvedCount = 0;
        if (shortCount > 0) {
            start = end;
            int counter = NodeSQL.resolveExistingUris(stmtProvider, connection, sessionPrefix, resourceTempTableName, idTempTableName, tableName);
            end = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[RESOLVE EXISTING URIS]{}:{}", counter, (end - start));
            resolvedCount += counter;
        }
        if (storeUnResolvedNodes) {
            start = end;
            long uCount = 0;
            long refCount = 0;
            if (shortCount > 0)
                uCount += NodeSQL.updateExistingUrisReferenceCount(stmtProvider, connection, sessionPrefix, resourceTempTableName, tableName);
            end = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[UPDATE REFERENCE COUNTS URIS]{}:{}", uCount, (end - start));
            refCount = uCount;
            start = end;

            uCount = 0;
            if (shortCount > 0)
                uCount += NodeSQL.resolveExistingUncommittedUris(stmtProvider, connection, sessionPrefix, resourceTempTableName, idTempTableName, tableName);
            end = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[RESOLVE UNCOMMITTED URIS]{}:{}", uCount, (end - start));
            resolvedCount += uCount;

            start = end;
            int pCount = 0;
            if (shortCount > 0)
                pCount = NodeSQL.purgeResolvedUris(stmtProvider, connection, sessionPrefix, resourceTempTableName, idTempTableName);
            end = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[PURGE EXISTING IDS]{}:{}", pCount, (end - start));
            resolvedCount += uCount;

            start = end;
            uCount = 0;
            if (shortCount > 0)
                uCount = NodeSQL.insertUnresolvedUris(stmtProvider, connection, sessionPrefix, resourceTempTableName, tableName, sequenceName);
            end = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[INSERT UNRESOLVED URIS IDS]{}:{}", uCount, (end - start));
            resolvedCount += uCount;

            start = end;
            uCount = NodeSQL.resolveExistingUncommittedUris(stmtProvider, connection, sessionPrefix, resourceTempTableName, idTempTableName, tableName);
            end = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[RESOLVE NEW URIS]{}:{}", uCount, (end - start));
            refCount += uCount;
            start = end;
            long storedCount = NodeSQL.insertUncommittedReferences(stmtProvider, connection, sessionPrefix, idTempTableName, lockedIdsName, Long.toString(transactionId));
            end = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug(LogUtils.RDB_MARKER, "[INSERT LOCKED IDS]{}:{}", storedCount, (end - start));
            refCount += storedCount;
        }
        int count = 0;
        if (shortCount > 0) {
            start = end;
            try {
                /*
                 * At this point all of the node values are in the temporary table so we can JOIN it against the node's type
                 * table and get the values that are already stored.
                 */
                cIter = NodeSQL.selectAllResolvedIds(stmtProvider, connection, sessionPrefix, idTempTableName);
                end = System.currentTimeMillis();
                if (log.isDebugEnabled())
                    log.debug(LogUtils.RDB_MARKER, "[SELECT RESOLVED URIS]{}", (end - start));
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
            log.debug(LogUtils.RDB_MARKER, "[SSN]{}:{}", count, (end - start));
        start = end;
        if (storeUnResolvedNodes) {
            BaseSQL.clearTableWithSessionPrefix(stmtProvider, connection, sessionPrefix, idTempTableName);
            BaseSQL.clearTableWithSessionPrefix(stmtProvider, connection, sessionPrefix, resourceTempTableName);
        } else {
            BaseSQL.truncateTableWithSessionMayCommit(stmtProvider, connection, sessionPrefix, resourceTempTableName);
            BaseSQL.truncateTableWithSessionMayCommit(stmtProvider, connection, sessionPrefix, idTempTableName);
        }
        end = System.currentTimeMillis();
        if (log.isDebugEnabled())
            log.debug(LogUtils.RDB_MARKER, "[PRN]{}", (end - start));
        /*
         * The nodes already stored have been split out in to this map, leaving only the nodes that need to be stored in the
         * iterator
         */
        if (log.isDebugEnabled())
            log.debug(LogUtils.RDB_MARKER, "[RESOLVE URIS]{}", (end - startAll));
        return alreadyStored;

    }

    public NodeType getType() {
        return type;
    }

    public Map<Long, T> resolveStoredIds(Set<Long> ids, Connection connection) throws RdbException {
        Map<Long, T> resolved = new HashMap<Long, T>();
        ClosableIterator<ResolveIdsUriResult> cIter = null;
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
            cIter = NodeSQL.resolveIdsUri(stmtProvider, connection, type.getTypeMask(), type.getMaxValue(), sessionPrefix, idTempTableName, tableName);
            int i = 0;
            for (ResolveIdsUriResult row : cIter) {
                i++;
                long id = row.getId();
                String nodeValue = row.getValue();
                // Remove the node from the pending list and add it to the already stored list
                T uri = convert(nodeValue, null, connection);
                resolved.put(id, uri);
                ids.remove(id);
            }
            if (ids.size() > 0 && longTableName != null) {
                cIter = NodeSQL.resolveIdsUri(stmtProvider, connection, longType.getTypeMask(), longType.getMaxValue(), sessionPrefix, idTempTableName, longTableName);
                for (ResolveIdsUriResult row : cIter) {
                    long id = row.getId();
                    String nodeValue = row.getValue();
                    // Remove the node from the pending list and add it to the already stored list
                    T uri = convert(nodeValue, null, connection);
                    resolved.put(id, uri);
                    ids.remove(id);
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

    private <N> int insert(Connection connection, ArrayList<N> nodes) throws RdbException {
        if (nodes.size() > 100) {
            NodeSQL.BatchStoreResolveNode insertPrepared = null;
            try {
                long start = System.currentTimeMillis();
                insertPrepared = new NodeSQL.BatchStoreResolveNode(connection, stmtProvider, sessionPrefix, resourceTempTableName);
                for (int k = 0; k < nodes.size(); k++) {
                    String value = null;
                    N n = nodes.get(k);
                    if (n instanceof BlankNode) {
                        value = ((BlankNode) n).getLabel();
                    } else {
                        value = n.toString();
                    }
                    insertPrepared.addEntry(k, value);
                }
                insertPrepared.executeStatement();
                long end = System.currentTimeMillis();
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "[BATCH INSERT TEMP NODE] {}:{}", Integer.toString(nodes.size()), Long.toString((end - start)));
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
                String value = null;
                N n = nodes.get(k);
                if (n instanceof BlankNode) {
                    value = ((BlankNode) n).getLabel();
                } else {
                    value = n.toString();
                }

                NodeSQL.storeResolveNode(stmtProvider, connection, k, value, sessionPrefix, resourceTempTableName);
            }
            long end = System.currentTimeMillis();
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "[INDV INSERT TEMP NODE] {}:{}", Integer.toString(nodes.size()), Long.toString((end - start)));
            }
            return nodes.size();
        } else {
            return 0;
        }
    }
}
