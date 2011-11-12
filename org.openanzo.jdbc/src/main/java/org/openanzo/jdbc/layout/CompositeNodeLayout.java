/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/CompositeNodeLayout.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: CompositeNodeLayout.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openanzo.cache.ICache;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.container.sql.NodeSQL;
import org.openanzo.jdbc.container.sql.NodeSQL.GetAllLiteralsResult;
import org.openanzo.jdbc.layout.indexer.LiteralIndexer;
import org.openanzo.jdbc.query.NodeConverter;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.jdbc.utils.UnhandledRdbException;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides cached access to RDF Nodes persisted in a relational database according to the 'node centric layout' schema. RDF Nodes are allocated IDs when they
 * are stored allowing any database table to store a reference to a node using a BIGINT column and this class for converting Nodes to and from the IDs stored in
 * the database.
 * 
 * @author <a href="mailto:evanchik@us.ibm.com">Stephen Evanchik</a>
 * @author Joe Betz
 */
public class CompositeNodeLayout {
    //private static final Logger                      log                 = LoggerFactory.getLogger(CompositeNodeLayout.class);

    // The name of the temporary table that is used during bulk node insertion
    private final static String                      RESOURCE_TEMP_TABLE = "RES_TMP";

    private final static String                      LITERAL_TEMP_TABLE  = "LIT_TMP";

    private final static String                      LOCKED_IDS_TABLE    = "_USED_IDS";

    private final static String                      ID_TEMP_TABLE       = "ID_TMP";

    private static final Logger                      log                 = LoggerFactory.getLogger(CompositeNodeLayout.class);

    @SuppressWarnings("unchecked")
    private final ILayoutCache[]                     layoutTypesToCaches;

    private final String                             URI_TABLE_NAME;

    private final String                             LONG_URI_TABLE_NAME;

    private final String                             BLANK_TABLE_NAME;

    private final String                             LITERAL_TABLE_NAME;

    private final String                             LONG_LIT_TABLE_NAME;

    private final String                             TYPED_LITERAL_TABLE_NAME;

    private final String                             LONG_TYPED_LIT_TABLE_NAME;

    private final String                             LOCK_ID_TABLE_NAME;

    private final String                             LANGUAGE_TABLE;

    private final String                             DATATYPE_TABLE;

    private final String[]                           tables;

    private final PreparedStatementProvider          stmtProvider;

    private int                                      maxLength;

    private final boolean                            supportsTempTables;

    private final NodeLayoutCacheProxy<URI>          nodeURILayout;

    private final NodeLayoutCacheProxy<BlankNode>    nodeBlankLayout;

    private final NodeLayoutCacheProxy<PlainLiteral> nodePlainLiteralLayout;

    private final NodeLayoutCacheProxy<TypedLiteral> nodeTypedLiteralLayout;

    private final ValueLayoutCacheProxy              datatypeLayout;

    private final ValueLayoutCacheProxy              languageLayout;

    private final NodeConverter                      nodeConverter;

    private final String                             optimizationString;

    private final LiteralIndexer                     literalIndexer;

    private final ICache<Long, URI>                  uriCache;

    private final ICache<URI, Long>                  uriIdCache;

    private final ICache<Long, BlankNode>            blankCache;

    private final ICache<BlankNode, Long>            blankIdCache;

    private final ICache<Long, PlainLiteral>         literalCache;

    private final ICache<PlainLiteral, Long>         literalIdCache;

    private final ICache<Long, TypedLiteral>         typedLiteralCache;

    private final ICache<TypedLiteral, Long>         typedLiteralIdCache;

    private final ICache<Long, String>               languageCache;

    private final ICache<String, Long>               languageIdCache;

    private final ICache<Long, String>               datatypeCache;

    private final ICache<String, Long>               datatypeIdCache;

    /**
     * Construct a layout to store nodes in a database
     * 
     * @param stmtProvider
     *            The interface to the SQL prepared statement cache
     * @param supportsSequences
     *            Does the underlying database support sequences to get IDs
     * @param literalIndexer
     *            Literal indexer for the underlying connection
     * @param containerName
     *            The name of the logical container for the nodes. This container name is used to generate the table names for each node type (i.e. Node_URI or
     *            Node_Literal, etc.)
     * @param maxLength
     *            The maximum length of a node's string representation before it is considered long
     * @param optimizationString
     *            String prepended to queries to enable database specific optimizations
     * @param supportsTempTables
     *            true if the database supports temporary tables, false otherwise.
     * @param supportsIdentity
     * @param sessionPrefix
     *            prefix for references to temporary tables within queries
     * @param uriCache
     *            cache of uri values and ids
     * @param literalCache
     *            cache of literal values and ids
     * @param languageCache
     *            cache of language values and ids
     * @param datatypeCache
     *            cache of datatype values and ids
     * 
     * @param uriIdCache
     *            cache of uri values and ids
     * @param blankCache
     * @param blankIdCache
     * @param literalIdCache
     *            cache of literal values and ids
     * @param typedLiteralCache
     * @param typedLiteralIdCache
     * @param languageIdCache
     *            cache of language values and ids
     * @param datatypeIdCache
     *            cachoe of datatype values and ids
     * 
     */
    public CompositeNodeLayout(PreparedStatementProvider stmtProvider, boolean supportsSequences, LiteralIndexer literalIndexer, String containerName, int maxLength, String optimizationString, boolean supportsTempTables, boolean supportsIdentity, String sessionPrefix, ICache<Long, URI> uriCache, ICache<URI, Long> uriIdCache, ICache<Long, BlankNode> blankCache, ICache<BlankNode, Long> blankIdCache, ICache<Long, PlainLiteral> literalCache, ICache<PlainLiteral, Long> literalIdCache,
            ICache<Long, TypedLiteral> typedLiteralCache, ICache<TypedLiteral, Long> typedLiteralIdCache, ICache<Long, String> languageCache, ICache<String, Long> languageIdCache, ICache<Long, String> datatypeCache, ICache<String, Long> datatypeIdCache) {
        if (stmtProvider == null)
            throw new InvalidParameterException("stmtProvider must not be null");
        this.literalIndexer = literalIndexer;
        this.optimizationString = optimizationString;
        this.stmtProvider = stmtProvider;
        this.maxLength = maxLength;
        this.supportsTempTables = supportsTempTables;
        this.uriCache = uriCache;
        this.uriIdCache = uriIdCache;
        this.blankCache = blankCache;
        this.blankIdCache = blankIdCache;
        this.literalCache = literalCache;
        this.literalIdCache = literalIdCache;
        this.typedLiteralCache = typedLiteralCache;
        this.typedLiteralIdCache = typedLiteralIdCache;
        this.datatypeCache = datatypeCache;
        this.datatypeIdCache = datatypeIdCache;
        this.languageCache = languageCache;
        this.languageIdCache = languageIdCache;
        URI_TABLE_NAME = NodeType.URI.getName(containerName);
        LONG_URI_TABLE_NAME = NodeType.LONG_URI.getName(containerName);
        BLANK_TABLE_NAME = NodeType.BLANK.getName(containerName);
        LITERAL_TABLE_NAME = NodeType.LITERAL.getName(containerName);
        LONG_LIT_TABLE_NAME = NodeType.LONG_LITERAL.getName(containerName);
        TYPED_LITERAL_TABLE_NAME = NodeType.TYPED_LITERAL.getName(containerName);
        LONG_TYPED_LIT_TABLE_NAME = NodeType.TYPED_LONG_LITERAL.getName(containerName);
        LOCK_ID_TABLE_NAME = containerName + LOCKED_IDS_TABLE;
        LANGUAGE_TABLE = containerName + "_LANGUAGE";
        DATATYPE_TABLE = containerName + "_DATATYPE";
        tables = new String[] { URI_TABLE_NAME, LONG_URI_TABLE_NAME, BLANK_TABLE_NAME, LITERAL_TABLE_NAME, LONG_LIT_TABLE_NAME, TYPED_LITERAL_TABLE_NAME, LONG_TYPED_LIT_TABLE_NAME, DATATYPE_TABLE, LANGUAGE_TABLE };
        datatypeLayout = new ValueLayoutCacheProxy(new ValueLayout(stmtProvider, DATATYPE_TABLE, optimizationString, "DATATYPE_SEQ", supportsSequences), datatypeCache, datatypeIdCache);
        languageLayout = new ValueLayoutCacheProxy(new ValueLayout(stmtProvider, LANGUAGE_TABLE, optimizationString, "LANG_SEQ", supportsSequences), languageCache, languageIdCache);
        nodeURILayout = new NodeLayoutCacheProxy<URI>(new NodeURILayout<URI>(NodeType.URI, NodeType.LONG_URI, stmtProvider, supportsSequences, NodeType.uriSequence, NodeType.longUriSequence, URI_TABLE_NAME, LONG_URI_TABLE_NAME, sessionPrefix, RESOURCE_TEMP_TABLE, ID_TEMP_TABLE, maxLength, optimizationString, LOCK_ID_TABLE_NAME), uriCache, uriIdCache);
        nodeBlankLayout = new NodeLayoutCacheProxy<BlankNode>(new NodeURILayout<BlankNode>(NodeType.BLANK, null, stmtProvider, supportsSequences, NodeType.blankSequence, NodeType.blankSequence, BLANK_TABLE_NAME, sessionPrefix, RESOURCE_TEMP_TABLE, ID_TEMP_TABLE, optimizationString, LOCK_ID_TABLE_NAME), blankCache, blankIdCache);
        nodePlainLiteralLayout = new NodeLayoutCacheProxy<PlainLiteral>(new NodeLiteralLayout<PlainLiteral>(NodeType.LITERAL, NodeType.LONG_LITERAL, PlainLiteral.class, literalIndexer, stmtProvider, supportsSequences, NodeType.literalSequence, NodeType.longLiteralSequence, LITERAL_TABLE_NAME, LONG_LIT_TABLE_NAME, sessionPrefix, LITERAL_TEMP_TABLE, ID_TEMP_TABLE, maxLength, optimizationString, datatypeLayout, languageLayout, LOCK_ID_TABLE_NAME, false), literalCache, literalIdCache);
        nodeTypedLiteralLayout = new NodeLayoutCacheProxy<TypedLiteral>(new NodeLiteralLayout<TypedLiteral>(NodeType.TYPED_LITERAL, NodeType.TYPED_LONG_LITERAL, TypedLiteral.class, literalIndexer, stmtProvider, supportsSequences, NodeType.typedliteralSequence, NodeType.longTypedLiteralSequence, TYPED_LITERAL_TABLE_NAME, LONG_TYPED_LIT_TABLE_NAME, sessionPrefix, LITERAL_TEMP_TABLE, ID_TEMP_TABLE, maxLength, optimizationString, datatypeLayout, languageLayout, LOCK_ID_TABLE_NAME, true), typedLiteralCache,
                typedLiteralIdCache);
        layoutTypesToCaches = new ILayoutCache[NodeType.typeCount];
        layoutTypesToCaches[NodeType.URI.getRange()] = nodeURILayout;
        layoutTypesToCaches[NodeType.LONG_URI.getRange()] = nodeURILayout;
        layoutTypesToCaches[NodeType.BLANK.getRange()] = nodeBlankLayout;
        layoutTypesToCaches[NodeType.LITERAL.getRange()] = nodePlainLiteralLayout;
        layoutTypesToCaches[NodeType.LONG_LITERAL.getRange()] = nodePlainLiteralLayout;
        layoutTypesToCaches[NodeType.TYPED_LITERAL.getRange()] = nodeTypedLiteralLayout;
        layoutTypesToCaches[NodeType.TYPED_LONG_LITERAL.getRange()] = nodeTypedLiteralLayout;
        this.nodeConverter = new NodeConverter(this);
    }

    /**
     * Construct a layout to store nodes in a database
     * 
     * @param stmtProvider
     *            The interface to the SQL prepared statement cache
     * @param supportsSequences
     *            Does the underlying database support sequences to get IDs
     * @param literalIndexer
     *            Literal indexer for the underlying connection
     * @param containerName
     *            The name of the logical container for the nodes. This container name is used to generate the table names for each node type (i.e. Node_URI or
     *            Node_Literal, etc.)
     * @param uriCache
     *            cache of uri values and ids
     * @param literalCache
     *            cache of literal values and ids
     * @param languageCache
     *            cache of language values and ids
     * @param datatypeCache
     *            cachoe of datatype values and ids
     * @param uriIdCache
     *            cache of uri values and ids
     * @param blankCache
     * @param blankIdCache
     * @param literalIdCache
     *            cache of literal values and ids
     * @param typedLiteralCache
     * @param typedLiteralIdCache
     * @param languageIdCache
     *            cache of language values and ids
     * @param datatypeIdCache
     *            cachoe of datatype values and ids
     * @param maxLength
     *            The maximum length of a node's string representation before it is considered long
     * @param optimizationString
     *            String prepended to queries to enable database specific optimizations
     * @param supportsTempTables
     *            true if the database supports temporary tables, false otherwise.
     * @param supportsIdentity
     * @param sessionPrefix
     *            prefix for references to temporary tables within queries
     */
    public CompositeNodeLayout(PreparedStatementProvider stmtProvider, boolean supportsSequences, LiteralIndexer literalIndexer, String containerName, ICache<Long, URI> uriCache, ICache<URI, Long> uriIdCache, ICache<Long, BlankNode> blankCache, ICache<BlankNode, Long> blankIdCache, ICache<Long, PlainLiteral> literalCache, ICache<PlainLiteral, Long> literalIdCache, ICache<Long, TypedLiteral> typedLiteralCache, ICache<TypedLiteral, Long> typedLiteralIdCache, ICache<Long, String> languageCache,
            ICache<String, Long> languageIdCache, ICache<Long, String> datatypeCache, ICache<String, Long> datatypeIdCache, int maxLength, String optimizationString, boolean supportsTempTables, boolean supportsIdentity, String sessionPrefix) {
        this(stmtProvider, supportsSequences, literalIndexer, containerName, maxLength, optimizationString, supportsTempTables, supportsIdentity, sessionPrefix, uriCache, uriIdCache, blankCache, blankIdCache, literalCache, literalIdCache, typedLiteralCache, typedLiteralIdCache, languageCache, languageIdCache, datatypeCache, datatypeIdCache);
    }

    /**
     * Determine the NodeType for a given node
     * 
     * @param n
     *            The node to retrieve its specific type
     * @return The type of the node
     * @throws RdbException
     */
    public NodeType getNodeType(Value n) throws RdbException {
        if (n == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "n");
        }
        NodeType layoutType;
        if (isLong(n)) {
            layoutType = NodeType.getLongLayout(n);
        } else {
            layoutType = NodeType.getShortLayout(n);
        }
        if (layoutType == null) {
            log.error(LogUtils.RDB_MARKER, "Unable to map node type to ID for Class:{} ", n.getClass().getName());
            throw new UnhandledRdbException(ExceptionConstants.RDB.NO_NODETYPE_CLASS, n.getClass().getName());
        }
        return layoutType;
    }

    /**
     * Determine whether or not a node's string representation is longer than the maximum length.
     * 
     * @param n
     *            The node to test
     * @return true of the node is a 'long' node, false otherwise
     * @throws RdbException
     */
    private boolean isLong(Value n) throws RdbException {
        if (n == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "n");
        }
        return n.toString().length() > maxLength;
    }

    /**
     * Get the array of table names where the nodes are stored
     * 
     * @return An array of table names where each node type is stored
     */
    public String[] listTables() {
        return tables;
    }

    /**
     * Get the DataType layout
     * 
     * @return the DataType layout
     */
    public ValueLayoutCacheProxy getDatatypeLayout() {
        return datatypeLayout;
    }

    /**
     * Get the Language layout
     * 
     * @return the Language layout
     */
    public ValueLayoutCacheProxy getLanguageLayout() {
        return languageLayout;
    }

    /**
     * Clear all of the in memory node caches as well as the datatype and language caches
     * 
     */
    public void clearCache() {
        uriCache.clear();
        blankCache.clear();
        literalCache.clear();
        typedLiteralCache.clear();
        datatypeCache.clear();
        languageCache.clear();
        uriIdCache.clear();
        blankIdCache.clear();
        literalIdCache.clear();
        typedLiteralIdCache.clear();
        datatypeIdCache.clear();
        languageIdCache.clear();
        clear(nodeURILayout);
        clear(nodeBlankLayout);
        clear(nodePlainLiteralLayout);
        clear(nodeTypedLiteralLayout);
        clear(datatypeLayout);
        clear(languageLayout);
        nodeConverter.clearCache();
    }

    /**
     * Clear the in-memory uncommitted cache data
     */
    public void clearUncommittedCache() {
        clearUncommitted(nodeURILayout);
        clearUncommitted(nodeBlankLayout);
        clearUncommitted(nodePlainLiteralLayout);
        clearUncommitted(nodeTypedLiteralLayout);
        clearUncommitted(datatypeLayout);
        clearUncommitted(languageLayout);
    }

    /**
     * Commit the in-memory uncommitted cache data
     */
    public void commitUncommittedCache() {
        commitUncommitted(nodeURILayout);
        commitUncommitted(nodeBlankLayout);
        commitUncommitted(nodePlainLiteralLayout);
        commitUncommitted(nodeTypedLiteralLayout);
        commitUncommitted(datatypeLayout);
        commitUncommitted(languageLayout);
    }

    private void clear(ILayoutCache<?> valueLayout) {
        valueLayout.clearCache();
    }

    private void clearUncommitted(ILayoutCache<?> valueLayout) {
        valueLayout.clearUncommittedCache();
    }

    private void commitUncommitted(ILayoutCache<?> valueLayout) {
        valueLayout.commitUncommittedCache();
    }

    /**
     * Get the NodeLayoutCacheProxy for the node in question.
     * 
     * @param n
     *            The node to retrieve the NodeLayoutCacheProxy
     * @return The NodeLayoutCacheProxy for that type of node
     */
    private NodeLayoutCacheProxy<?> getNodeLayoutByNodeClass(Value n) throws RdbException {
        if (n == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "n");
        }
        if (n instanceof URI) {
            return nodeURILayout;
        } else if (n instanceof PlainLiteral) {
            return nodePlainLiteralLayout;
        } else if (n instanceof TypedLiteral) {
            return nodeTypedLiteralLayout;
        } else if (n instanceof BlankNode) {
            return nodeBlankLayout;
        }
        throw new UnhandledRdbException(ExceptionConstants.RDB.NO_NODETYPE_CLASS, n.getClass().getName());
    }

    /**
     * Get the NodeLayoutCacheProxy for the NodeType in question.
     * 
     * @param layoutType
     *            The layout for a particular type of node
     * @return The NodeLayoutCacheProxy for that type of node
     */
    @SuppressWarnings("unchecked")
    private NodeLayoutCacheProxy getNodeLayoutByType(NodeType layoutType) {
        return (NodeLayoutCacheProxy) layoutTypesToCaches[layoutType.getRange()];
    }

    /**
     * Store value in appropriate table and return ID
     * 
     * @param value
     *            value to store
     * @param connection
     *            connection to the database
     * @param transactionId
     *            id of the transaction for which this storage operation is a part
     * @return ID of value stored in table
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    public Long store(Value value, Connection connection, long transactionId) throws RdbException {
        if (value == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "value");
        }
        INodeLayout nodeLayout = getNodeLayoutByNodeClass(value);
        Long id = nodeLayout.store(value, connection, transactionId);
        return id;
    }

    /**
     * Fetch the ID of the Value from the appropriate table
     * 
     * @param value
     *            value to store
     * @param connection
     *            connection to the database
     * @return ID of value stored in table
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    public Long fetchId(Value value, Connection connection) throws RdbException {
        if (value == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "value");
        }
        INodeLayout nodeLayout = getNodeLayoutByNodeClass(value);
        Long id = nodeLayout.fetchId(value, connection);
        return id;
    }

    /**
     * Fetch the stored Value for the provided ID
     * 
     * @param id
     *            ID of value to retrieve
     * @param connection
     *            connection to the database
     * @return Value for provided ID
     * @throws RdbException
     */
    public Value fetchValue(Long id, Connection connection) throws RdbException {
        if (id == null || id.longValue() == 0)
            return null;
        NodeType layoutType = NodeType.getById(id.longValue());
        INodeLayout<?> nodeLayout = getNodeLayoutByType(layoutType);
        Value n = nodeLayout.fetchValue(id, connection);
        return n;
    }

    /**
     * Resolve the IDs of the set of provided Values,optionally storing Values if they are not already stored based.
     * 
     * @param nodesToResolve
     *            Set of Values to resolve
     * @param storeUnresolvedNodes
     *            Store Values that are not already stored
     * @param connection
     *            connection to the database
     * @param transactionId
     *            id of the transaction for which this storage operation is a part
     * @return Map of Values to their resolved IDs
     * @throws RdbException
     */
    public Map<Value, Long> resolveStoredNodes(Set<Value> nodesToResolve, boolean storeUnresolvedNodes, Connection connection, long transactionId) throws RdbException {
        Map<Value, Long> alreadyStored = new HashMap<Value, Long>();
        if (supportsTempTables) {
            alreadyStored = resolveStoredNodesFast(nodesToResolve, storeUnresolvedNodes, connection, transactionId);
        } else {
            alreadyStored = resolveStoredNodesSlow(nodesToResolve, storeUnresolvedNodes, connection, transactionId);
        }
        return alreadyStored;
    }

    /**
     * Resolve the Values of the set of provided IDs
     * 
     * @param ids
     *            Set of IDs to resolve
     * @param connection
     *            connection to the database
     * 
     * @return Map of IDs to their resolved Values
     * @throws RdbException
     */
    public Map<Long, Value> resolveStoredIds(Set<Long> ids, Connection connection) throws RdbException {
        Map<Long, Value> alreadyStored = null;
        if (supportsTempTables) {
            alreadyStored = findDeferredIdsFast(ids, connection);
        } else {
            alreadyStored = findDeferredIdsSlow(ids, connection);
        }
        return alreadyStored;
    }

    /**
     * Finds all the node using a bulk lookup. 'Slow' indicates this method is inferior in performance compared to 'findDeferredNodesFast', which optimizes
     * insert by using temporary tables. This methods should be used only for databases that do not not support temporary tables.
     * 
     * @param nodesToResolve
     *            nodes to resolved
     * @param storeUnresolvedNodes
     *            store Values that are not currently stored
     * @param connection
     *            connection to the database
     * @return Map of Value and their resolved IDs.
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    private Map<Value, Long> resolveStoredNodesSlow(Set<Value> deferredNodes, boolean storeUnresolvedNodes, Connection connection, long transactionId) throws RdbException {
        Map<Value, Long> alreadyStored = new HashMap<Value, Long>();
        for (Value n : deferredNodes) {
            INodeLayout nodeLayout = getNodeLayoutByNodeClass(n);
            Long id = (storeUnresolvedNodes) ? nodeLayout.store(n, connection, transactionId) : nodeLayout.fetchId(n, connection);
            if (id != null) {
                alreadyStored.put(n, id);
            }
        }
        return alreadyStored;
    }

    /**
     * Finds all the node values using a bulk lookup. 'Fast' indicates this method is superior in performance compared with 'findDeferredNodesSlow'. This
     * methods requires database support for temporary tables.
     * 
     * @param nodesToResolve
     *            nodes to resolved
     * @param storeUnresolvedNodes
     *            store Values that are not currently stored
     * @param connection
     *            connection to the database
     * 
     * @return Map of Value and their resolved IDs.
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    private Map<Value, Long> resolveStoredNodesFast(Set<Value> nodesToResolve, boolean storeUnresolvedNodes, Connection connection, long transactionId) throws RdbException {
        Map<Value, Long> alreadyStored = new HashMap<Value, Long>();
        Map<INodeLayout, Set<Value>> pendingNodes = new HashMap<INodeLayout, Set<Value>>();
        if (nodesToResolve == null)
            return alreadyStored;
        for (Value n : nodesToResolve) {
            INodeLayout nodeLayout = getNodeLayoutByNodeClass(n);
            Set<Value> nodeSet = pendingNodes.get(nodeLayout);
            if (nodeSet == null) {
                nodeSet = new HashSet<Value>();
                pendingNodes.put(nodeLayout, nodeSet);
            }
            nodeSet.add(n);
        }
        // Now, for each node type put the nodes in a temporary table so that we can resolve them
        for (INodeLayout nodeLayout : pendingNodes.keySet()) {
            Set<Value> nodeSet = pendingNodes.get(nodeLayout);
            if (nodeSet.size() == 0)
                continue;
            alreadyStored.putAll(nodeLayout.resolveStoredNodes(nodeSet, storeUnresolvedNodes, connection, transactionId));
        }
        return alreadyStored;
    }

    /**
     * Commit the entries for any nodes that were created during this transactions
     * 
     * @param connection
     *            Connection for operation
     * @param transactionId
     *            id of the transaction for which this storage operation is a part
     * @return number of committed referenced ids
     * @throws RdbException
     */
    public long commitReferencedIds(Connection connection, long transactionId) throws RdbException {
        long count = 0;
        count += nodeURILayout.commitReferencedIds(connection, transactionId);
        count += nodeBlankLayout.commitReferencedIds(connection, transactionId);
        count += nodePlainLiteralLayout.commitReferencedIds(connection, transactionId);
        count += nodeTypedLiteralLayout.commitReferencedIds(connection, transactionId);
        NodeSQL.purge(stmtProvider, connection, transactionId, LOCK_ID_TABLE_NAME);
        return count;
    }

    /**
     * Abort the addition of any nodes that were created during this transaction, and not any other transaction
     * 
     * @param connection
     *            Connection for operation
     * @param transactionId
     *            id of the transaction for which this storage operation is a part* @return
     * @return number of aborted referenced ids
     * @throws RdbException
     */
    public long abortReferencedIds(Connection connection, long transactionId) throws RdbException {
        long count = 0;
        count += nodeURILayout.abortReferencedIds(connection, transactionId);
        count += nodeBlankLayout.abortReferencedIds(connection, transactionId);
        count += nodePlainLiteralLayout.abortReferencedIds(connection, transactionId);
        count += nodeTypedLiteralLayout.abortReferencedIds(connection, transactionId);
        NodeSQL.purge(stmtProvider, connection, transactionId, LOCK_ID_TABLE_NAME);
        return count;
    }

    /**
     * Finds all the node values using a bulk lookup. 'Fast' indicates this method is superior in performance compared with 'findDeferredNodesSlow'. This
     * methods requires database support for temporary tables.
     * 
     * @param idsToResolve
     *            IDs that need to be resolved
     * @param connection
     *            connection to the database
     * 
     * @return A map of IDs to their resolved Values
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    private Map<Long, Value> findDeferredIdsFast(Set<Long> idsToResolve, Connection connection) throws RdbException {
        Map<INodeLayout, Set<Long>> pendingIds = new HashMap<INodeLayout, Set<Long>>();
        Map<Long, Value> resolved = new HashMap<Long, Value>();
        if (idsToResolve == null) {
            return resolved;
        }
        for (Long l : idsToResolve) {
            Value val = (Value) getIfCached(l);
            if (val == null) {
                INodeLayout nodeLayout = getNodeLayoutByType(NodeType.getById(l.longValue()));
                Set<Long> nodeSet = pendingIds.get(nodeLayout);
                if (nodeSet == null) {
                    nodeSet = new HashSet<Long>();
                    pendingIds.put(nodeLayout, nodeSet);
                }
                nodeSet.add(l);
            } else {
                resolved.put(l, val);
            }
        }
        // Now, for each node type put the nodes in a temporary table so that we can resolve them
        for (INodeLayout nodeLayout : pendingIds.keySet()) {
            Set<Long> nodeSet = pendingIds.get(nodeLayout);
            if (nodeSet.size() == 0)
                continue;
            resolved.putAll(nodeLayout.resolveStoredIds(nodeSet, connection));
        }
        return resolved;
    }

    /**
     * Finds all the node using a bulk lookup. 'Slow' indicates this method is inferior in performance compared to 'findDeferredNodesFast', which optimizes
     * insert by using temporary tables. This methods should be used only for databases that do not not support temporary tables.
     * 
     * @param idsToResolve
     *            IDs that need to be resolved
     * @param connection
     *            connection to the database
     * 
     * @return A map of IDs to their resolved Values
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    private Map<Long, Value> findDeferredIdsSlow(Set<Long> deferredIds, Connection connection) throws RdbException {
        Map<Long, Value> resolved = new HashMap<Long, Value>();
        if (deferredIds == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "deferredIds");
        }
        for (Long l : deferredIds) {
            Value val = (Value) getIfCached(l);
            if (val == null) {
                INodeLayout nodeLayout = getNodeLayoutByType(NodeType.getById(l.longValue()));
                val = nodeLayout.fetchValue(l, connection);
                resolved.put(l, val);
            } else {
                resolved.put(l, val);
            }
        }
        return resolved;
    }

    /**
     * Create Value object from provided ID and value and cache result
     * 
     * @param id
     *            ID of node
     * @param value
     *            String value of node
     * @param modifierId
     *            modifierId for literals
     * @param connection
     *            connection to the database
     * @return convert Value for provided data
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    public Value cache(Long id, String value, Long modifierId, Connection connection) throws RdbException {
        if (id == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "id");
        }
        NodeType layoutType = NodeType.getById(id.longValue());
        ILayoutCache cache = layoutTypesToCaches[layoutType.getRange()];
        return (Value) cache.cache(id, value, modifierId, connection);
    }

    /**
     * Get the Object for this ID, if already cached
     * 
     * @param id
     *            of Object to retrieve
     * @return the Object for this ID, if already cached
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    public Object getIfCached(Long id) throws RdbException {
        if (id == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "id");
        }
        NodeType layoutType = NodeType.getById(id.longValue());
        NodeLayoutCacheProxy nodeLayout = getNodeLayoutByType(layoutType);
        return nodeLayout.getIfCached(id);
    }

    /**
     * Get the ID for this Value, if already cached
     * 
     * @param value
     *            node value to find cached ID
     * @return the ID for this Value, if already cached
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    public Long getIfCached(Value value) throws RdbException {
        if (value == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "value");
        }
        NodeLayoutCacheProxy nodeLayout = getNodeLayoutByNodeClass(value);
        return nodeLayout.getIfCached(value);
    }

    /**
     * Return true if a Value with this ID is already cached
     * 
     * @param id
     *            to check
     * @return true if a Value with this ID is already cached
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    public boolean isCached(Long id) throws RdbException {
        if (id == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "id");
        }
        NodeType layoutType = NodeType.getById(id.longValue());
        NodeLayoutCacheProxy nodeLayout = getNodeLayoutByType(layoutType);
        return nodeLayout.isCached(id);
    }

    /**
     * Return true if a ID for this Value is already cached
     * 
     * @param value
     *            node value to check
     * @return true if a ID for this Value is already cached
     * @throws RdbException
     */
    @SuppressWarnings("unchecked")
    public boolean isCached(Value value) throws RdbException {
        if (value == null) {
            throw new RdbException(ExceptionConstants.CORE.NULL_PARAMETER, "value");
        }
        NodeLayoutCacheProxy nodeLayout = getNodeLayoutByNodeClass(value);
        return nodeLayout.isCached(value);
    }

    /**
     * Get the nodeURILayout
     * 
     * @return the nodeURILayout
     */
    public NodeLayoutCacheProxy<URI> getNodeURILayout() {
        return nodeURILayout;
    }

    /**
     * Get the nodeConverter
     * 
     * @return the nodeConverter
     */
    public NodeConverter getNodeConverter() {
        return nodeConverter;
    }

    /**
     * Get the nodeLiteralLayout
     * 
     * @return the nodeLiteralLayout
     */
    public NodeLayoutCacheProxy<PlainLiteral> getPlainNodeLiteralLayout() {
        return nodePlainLiteralLayout;
    }

    /**
     * Get the TypedLiteral layout
     * 
     * @return the TypedLiteral layout
     */
    public NodeLayoutCacheProxy<TypedLiteral> getTypedNodeLiteralLayout() {
        return nodeTypedLiteralLayout;
    }

    /**
     * Get an Iterator over all the Literal values stored in the database
     * 
     * @param connection
     *            connections to from which to retrieve literals
     * @return an Iterator over all the Literal values stored in the database
     * @throws RdbException
     */
    public ClosableIterator<GetAllLiteralsResult> getAllLiterals(Connection connection) throws RdbException {
        return NodeSQL.getAllLiterals(stmtProvider, connection, LITERAL_TABLE_NAME, optimizationString);
    }

    /**
     * Get the literalIndexer
     * 
     * @return the literalIndexer
     */
    public LiteralIndexer getLiteralIndexer() {
        return literalIndexer;
    }

    /**
     * Get the URI table name
     * 
     * @return URI table name
     */
    public String getURITableName() {
        return URI_TABLE_NAME;
    }

    /**
     * Get the Long URI table name
     * 
     * @return Long URI table name
     */
    public String getLongURITableName() {
        return LONG_URI_TABLE_NAME;
    }

    /**
     * Get the Literal table name
     * 
     * @return Literal table name
     */
    public String getLiteralTableName() {
        return LITERAL_TABLE_NAME;
    }

    /**
     * Get the Long Literal table name
     * 
     * @return Long Literal table name
     */
    public String getLongLiteralTableName() {
        return LONG_LIT_TABLE_NAME;
    }

    /**
     * Get the Blank Node table name
     * 
     * @return Blank Node table name
     */
    public String getBlankNodeTableName() {
        return BLANK_TABLE_NAME;
    }

    /**
     * @param maxLength
     *            the maxLength to set
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        nodeURILayout.setMaxLength(maxLength);
        nodeBlankLayout.setMaxLength(maxLength);
        nodePlainLiteralLayout.setMaxLength(maxLength);
        nodeTypedLiteralLayout.setMaxLength(maxLength);
    }
}
