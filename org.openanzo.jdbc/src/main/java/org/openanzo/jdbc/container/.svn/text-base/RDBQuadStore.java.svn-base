/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.container;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.cache.ICacheProvider;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.jdbc.container.query.FindInferred;
import org.openanzo.jdbc.container.query.RdbEngineConfig;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.container.sql.GraphSQL;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.layout.Quad;
import org.openanzo.jdbc.layout.ValueLayoutCacheProxy;
import org.openanzo.jdbc.layout.indexer.LiteralIndexer;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.IteratorUtils;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.BaseQuadStore;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.Anzo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Node Centric QuadStore backed by a relational database.
 * 
 * Writes are run within database transactions and are locked to prevent concurrent writes from sharing database transactions.
 * 
 * Read operations do not respect transaction isolation.
 * 
 * @author Stephen Evanchik (<a href="mailto:evanchik@us.ibm.com">Stephen Evanchik</a>)
 * @author Joe Betz (<a href="mailto:jpbetz@cambridgesemantics.com">jpbetz@cambridgesemantics.com</a>)
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class RDBQuadStore extends BaseQuadStore implements IRDBQuadStore {
    private static final Logger         log                    = LoggerFactory.getLogger(RDBQuadStore.class);

    /** ID of named graph's URI */
    protected static final String       ng                     = "namedGraphId";

    /** ID of statement's subject */
    protected static final String       subj                   = "subj";

    /** ID of statement's predicate */
    protected static final String       prop                   = "prop";

    /** ID of statement's object */
    protected static final String       obj                    = "obj";

    private final Random                random                 = new Random();

    protected Connection                connection;

    private final CompositeNodeLayout   nodeLayout;

    private String                      containerName          = null;

    // Instance of PreparedStatementProvider used by Driver for hard-coded db commands
    private PreparedStatementProvider   stmtProvider           = null;

    private final Engine                glitter;

    private final RDBTransactionManager internalTransactionManager;

    private final LiteralIndexer        literalIndexer;

    /** Is the JDBC connection set to readonly,rw or query */
    protected final boolean             write;

    protected boolean                   initializing           = false;

    private boolean                     returned               = false;

    private static final String         STATEMENT_TABLE_SUFFIX = "_S";

    private static final String         INITIAL_DATABASE_TABLE = "GLITTERUNIT";

    /*
     * The filename that contains all of the SQL commands to be loaded in to the PreparedStatementProvider
     */
    private String                      SQL_FILENAME;

    /*
     * The name of the database table that we use to indicate whether or not the database bas been properly setup for this
     * physical layout
     */
    private String                      STATEMENT_TABLE_NAME   = null;

    /**
     * @return the stmtProvider
     */
    public PreparedStatementProvider getStmtProvider() {
        return stmtProvider;
    }

    private final class RDBTransactionManager {
        private void performCommit() throws AnzoException {
            try {
                RDBQuadStore.this.connection.commit();
                if (!initializing && RDBQuadStore.this.write) {
                    unlockTable();
                }
                RDBQuadStore.this.connection.setAutoCommit(true);
            } catch (SQLException e) {
                log.error(LogUtils.RDB_MARKER, "Exception commiting connection transaction", e);
                throw new AnzoException(ExceptionConstants.RDB.OPERATION_ERROR, e, e.getMessage());
            }
            nodeLayout.commitUncommittedCache();
        }

        private void performBegin() throws AnzoException {
            try {
                RDBQuadStore.this.connection.setAutoCommit(false);
                if (!initializing && RDBQuadStore.this.write) {
                    lockTable();
                }
            } catch (SQLException e) {
                log.error(LogUtils.RDB_MARKER, "Exception beginning connection transaction", e);
                throw new AnzoException(ExceptionConstants.RDB.OPERATION_ERROR, e, e.getMessage());
            }
        }

        private void performAbort() throws AnzoException {
            try {
                RDBQuadStore.this.connection.rollback();
                if (!initializing && RDBQuadStore.this.write) {
                    unlockTable();
                }
                RDBQuadStore.this.connection.setAutoCommit(true);
            } catch (SQLException e) {
                log.error(LogUtils.RDB_MARKER, "Exception aborting connection transaction", e);
                throw new AnzoException(ExceptionConstants.RDB.OPERATION_ERROR, e, e.getMessage());
            } finally {
                nodeLayout.clearUncommittedCache();
            }
        }

        /** ReentrantLock that makes sure only the same thread that starts a transaction can abort or commit it */
        private final ReentrantLock lock = new ReentrantLock();

        protected void commit() throws AnzoException {
            if (lock.isLocked()) {
                if (lock.isHeldByCurrentThread()) {
                    int count = lock.getHoldCount();
                    try {
                        if (count == 1) {
                            performCommit();
                        }
                    } finally {
                        lock.unlock();
                    }
                } else {
                    throw new IllegalMonitorStateException(Messages.getString("Messages.CurrentThreadNotOwner"));
                }
            } else {
                throw new IllegalMonitorStateException(Messages.getString("Messages.NotInTransaction"));
            }
        }

        protected void abort() throws AnzoException {
            if (lock.isLocked()) {
                if (lock.isHeldByCurrentThread()) {
                    try {
                        performAbort();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    throw new IllegalMonitorStateException(Messages.getString("Messages.CurrentThreadNotOwner"));
                }
            } else {
                throw new IllegalMonitorStateException(Messages.getString("Messages.NotInTransaction"));
            }
        }

        protected void begin() throws AnzoException {
            lock.lock();
            if (lock.getHoldCount() == 1) {
                performBegin();
            }
        }
    }

    final CoreDBConfiguration configuration;

    /**
     * @return the configuration
     */
    public CoreDBConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Create a new RDBQuadStore from the provided properties.
     * 
     * @param configuration
     *            configuration information
     * @param write
     *            store is for writting
     * @return RDBQuadStore for configuration
     * @throws AnzoException
     */
    public static RDBQuadStore createQuadStore(CoreDBConfiguration configuration, boolean write) throws AnzoException {
        RDBQuadStorePool connectionPool = new RDBQuadStorePool(configuration, null);
        connectionPool.start();
        return connectionPool.acquireRDBQuadStore(write);
    }

    /**
     * Create a new RDBConnection
     * 
     * @param connectionPool
     *            the connection pool creating this connection
     * @param cacheProvider
     *            the cache provider for of caches of node values to their ids
     * @param literalIndexer
     *            the literal indexer for like text queries
     * @param write
     *            connection is for writting data
     * @param configuration
     *            the configuration data for the connection
     * @param connection
     *            the underlying jdbc connection
     */
    protected RDBQuadStore(ICacheProvider cacheProvider, LiteralIndexer literalIndexer, boolean write, CoreDBConfiguration configuration, Connection connection) {
        this.connection = connection;
        this.write = write;
        this.configuration = configuration;
        this.connection = connection;
        this.literalIndexer = literalIndexer;
        // SAE: The call to setContainerName initializes other dependant instance variables
        setContainerName(configuration.getContainerName());
        setupPreparedStatementProvider();
        int maxLength = configuration.getMaxIndexKeyLength();
        String optimizationString = configuration.getOptimizationString();
        nodeLayout = new CompositeNodeLayout(stmtProvider, configuration.getSupportsSequences(), this.literalIndexer, containerName, cacheProvider.<Long, URI> openCache("URICache", 20000, true), cacheProvider.<URI, Long> openCache("URIIDCache", 20000, true), cacheProvider.<Long, BlankNode> openCache("BlankCache", 20000, true), cacheProvider.<BlankNode, Long> openCache("BlankIDCache", 20000, true), cacheProvider.<Long, PlainLiteral> openCache("LiteralCache", 20000, true), cacheProvider
                .<PlainLiteral, Long> openCache("LiteralIdCache", 20000, true), cacheProvider.<Long, TypedLiteral> openCache("TypedCache", 20000, true), cacheProvider.<TypedLiteral, Long> openCache("TypedLiteralIdCache", 20000, true), cacheProvider.<Long, String> openCache("LanguageCache", 20000, true), cacheProvider.<String, Long> openCache("LanguageIdCache", 20000, true), cacheProvider.<Long, String> openCache("DatatypeCache", 20000, true), cacheProvider.<String, Long> openCache("DatatypeIdCache", 20000,
                true), maxLength, optimizationString, configuration.getSupportsTempForInsert(), configuration.getSupportsIdentity(), configuration.getSessionPrefix());
        RdbEngineConfig config = new RdbEngineConfig();
        config.getRdbSolutionGeneratorFactory().setNodeCentricNamedGraphContainer(this);
        glitter = new Engine(config);
        internalTransactionManager = new RDBTransactionManager();
        connect();
    }

    protected void lockTable() {
        if (!initializing && configuration.getSupportsTableLocks()) {
            try {
                BaseSQL.lockTable(stmtProvider, connection, containerName + "_U", configuration.getTableLocksExtras());
                BaseSQL.lockTable(stmtProvider, connection, containerName + "_S", configuration.getTableLocksExtras());
                BaseSQL.lockTable(stmtProvider, connection, containerName + "_L", configuration.getTableLocksExtras());
                BaseSQL.lockTable(stmtProvider, connection, containerName + "_TL", configuration.getTableLocksExtras());
                //BaseSQL.lockTable(getPreparedStatementProvider(), connection, containerName + "_X", configuration.getTableLocksExtras());
                BaseSQL.lockTable(stmtProvider, connection, containerName + "_B", configuration.getTableLocksExtras());
                BaseSQL.lockTable(stmtProvider, connection, containerName + "_LU", configuration.getTableLocksExtras());
                BaseSQL.lockTable(stmtProvider, connection, containerName + "_LL", configuration.getTableLocksExtras());
                BaseSQL.lockTable(stmtProvider, connection, containerName + "_LTL", configuration.getTableLocksExtras());
                //BaseSQL.lockTable(getPreparedStatementProvider(), connection, containerName + "_XL", configuration.getTableLocksExtras());
            } catch (RdbException e) {
                try {
                    abort();
                } catch (AnzoException be) {
                    log.error(LogUtils.RDB_MARKER, "Exception aborting lock tables", be);
                }
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_CONTAINER_SQLCACHE, e);
            }
        }
    }

    protected void unlockTable() {
        if (!initializing && configuration.getSupportsTableUnLocks()) {
            try {
                BaseSQL.unlockTable(stmtProvider, connection, containerName + "_U");
                BaseSQL.unlockTable(stmtProvider, connection, containerName + "_S");
                BaseSQL.unlockTable(stmtProvider, connection, containerName + "_L");
                BaseSQL.unlockTable(stmtProvider, connection, containerName + "_TL");
                //BaseSQL.unlockTable(getPreparedStatementProvider(), connection, containerName + "_X");
                BaseSQL.unlockTable(stmtProvider, connection, containerName + "_B");
                BaseSQL.unlockTable(stmtProvider, connection, containerName + "_LU");
                BaseSQL.unlockTable(stmtProvider, connection, containerName + "_LL");
                BaseSQL.unlockTable(stmtProvider, connection, containerName + "_LTL");
                //BaseSQL.unlockTable(getPreparedStatementProvider(), connection, containerName + "_XL");
            } catch (RdbException e) {
                try {
                    abort();
                } catch (AnzoException be) {
                    log.error(LogUtils.RDB_MARKER, "Exception aborting lock tables", be);
                }
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_CONTAINER_SQLCACHE, e);
            }
        }
    }

    private void setupPreparedStatementProvider() {
        SQL_FILENAME = configuration.getSqlFilename();
        try {
            stmtProvider = new PreparedStatementProvider();
            stmtProvider.loadSQLFile(findSQLResource(SQL_FILENAME));
        } catch (RdbException e) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_CONTAINER_SQLCACHE, e);
        }
    }

    /* (non-Javadoc)
     * @see org.openanzo.jdbc.container.container.IRDBQuadStore#connect()
     */
    public synchronized void connect() {
        if (connection == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_CONTAINER_CONNECTION);
        }
        try {
            initializing = true;
            try {
                begin();
                // This database layout requires extra entities in order to support
                // storing graphs and nodes
                if (!hasTable(INITIAL_DATABASE_TABLE)) {
                    stmtProvider.runSQLGroup("initDBtables", configuration.getInitParams(containerName), connection);
                }
                if (!hasTable(STATEMENT_TABLE_NAME)) {
                    stmtProvider.runSQLGroup("initGraphTables", configuration.getInitParams(containerName), connection);
                    stmtProvider.runSQLGroup("initIndexes", configuration.getInitParams(containerName), connection);
                    prepopulateLanguageTable();
                    prepopulateDatatable();
                }
                //if (configuration.getSupportsTempForInsert() || configuration.getSupportsTempOnFind()) {
                if (!hasTempTable("ID_TMP")) {
                    try {
                        stmtProvider.runSQLGroup("createTemporaryTables", configuration.getInitParams(containerName), connection);
                    } catch (SQLException e) {
                        log.debug(LogUtils.RDB_MARKER, "Unable to create temporary tables:", e);
                    }
                }
                //}
                commit();
            } catch (SQLException e) {
                log.error(LogUtils.RDB_MARKER, "Could not initialized database tables ", e);
                abort();
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_CONTAINER_TABLES, e);
            } catch (RdbException e) {
                log.error(LogUtils.RDB_MARKER, "Could not initialized database tables ", e);
                abort();
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_CONTAINER_TABLES, e);
            }
        } catch (AnzoException be) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_CONTAINER, be);
        } finally {
            initializing = false;
        }
    }

    private InputStream findSQLResource(String sqlFilename) throws RdbException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(sqlFilename);
        if (is == null) {
            throw new RdbException(ExceptionConstants.RDB.FAILED_LOAD_SQL_FILE, sqlFilename);
        }
        return is;
    }

    private void prepopulateLanguageTable() throws RdbException {
        ClosableIterator<String> languageIter = null;
        try {
            languageIter = stmtProvider.listPreloadData(findSQLResource("preloaddata/languages.data"));
            ValueLayoutCacheProxy langLayout = nodeLayout.getLanguageLayout();
            Collection<String> list = new ArrayList<String>();
            org.openanzo.rdf.utils.Collections.addAll(languageIter, list);
            langLayout.batchAddAndCache(list, connection);
        } finally {
            IteratorUtils.close(languageIter);
        }
    }

    private void prepopulateDatatable() throws RdbException {
        ClosableIterator<String> datatypeIter = null;
        try {
            datatypeIter = stmtProvider.listPreloadData(findSQLResource("preloaddata/datatypes.data"));
            ValueLayoutCacheProxy datatypeLayout = nodeLayout.getDatatypeLayout();
            Collection<String> list = new ArrayList<String>();
            org.openanzo.rdf.utils.Collections.addAll(datatypeIter, list);
            datatypeLayout.batchAddAndCache(list, connection);
        } finally {
            IteratorUtils.close(datatypeIter);
        }
    }

    /* (non-Javadoc)
     * @see org.openanzo.jdbc.container.container.IRDBQuadStore#isConnected()
     */
    public boolean isConnected() {
        if (connection == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_CONTAINER_CONNECTION);
        }
        try {
            return hasTable(STATEMENT_TABLE_NAME);
        } catch (RdbException e) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_CONTAINER_CONNECTION, e);
        }
    }

    //private static final Pattern db2TableNamePattern = Pattern.compile("[A-Za-z][A-Za-z0-9_]*");

    /**
     * Set the URI for this container
     * 
     * @param uri
     *            for this container
     */
    public void setURI(URI uri) {
        String containerName = uri.toString();
        setContainerName(containerName);
    }

    /**
     * Get the container's name
     * 
     * @return the container's name
     */
    public String getContainerName() {
        return containerName;
    }

    /**
     * Set the container's name
     * 
     * @param containerName
     */
    public void setContainerName(String containerName) {
        this.containerName = "G" + Math.abs(containerName.toString().hashCode()); /* makes the table name shorter */
        STATEMENT_TABLE_NAME = this.containerName + STATEMENT_TABLE_SUFFIX;
    }

    /* (non-Javadoc)
     * @see org.openanzo.jdbc.container.container.IRDBQuadStore#close()
     */
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqle) {
                log.error(LogUtils.RDB_MARKER, "Exception closing connection", sqle);
            } finally {
                connection = null;
            }
        }
    }

    /* (non-Javadoc)
     * @see org.openanzo.jdbc.container.container.IRDBQuadStore#isClosed()
     */
    public boolean isClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch (SQLException sqle) {
            return true;
        }
    }

    private void clearCaches() {
        if (nodeLayout != null)
            nodeLayout.clearCache();
    }

    /* (non-Javadoc)
     * @see org.openanzo.jdbc.container.container.IRDBQuadStore#clearDatabase()
     */
    public void clearDatabase() {
        try {
            deleteTable(STATEMENT_TABLE_NAME);
        } catch (RdbException re) {
            log.debug(LogUtils.RDB_MARKER, "Exception deleting table:" + STATEMENT_TABLE_NAME, re);
        }
        try {
            deleteTable(containerName + "_TRANSACTIONS");
        } catch (RdbException re) {
            log.debug(LogUtils.RDB_MARKER, "Exception deleting table:" + containerName + "_TRANSACTIONS", re);
        }
        try {
            deleteTable(containerName + "_COMMANDS");
        } catch (RdbException re) {
            log.debug(LogUtils.RDB_MARKER, "Exception deleting table:" + containerName + "_COMMANDS", re);
        }
        try {
            deleteTable(containerName + "_CHANGESETS");
        } catch (RdbException re) {
            log.debug(LogUtils.RDB_MARKER, "Exception deleting table:" + containerName + "_CHANGESETS", re);
        }
        try {
            deleteTable(containerName + "_ST");
        } catch (RdbException re) {
            log.debug(LogUtils.RDB_MARKER, "Exception deleting table:" + containerName + "_ST", re);
        }
        try {
            deleteTable(containerName + "_OBJ_INFER");
        } catch (RdbException re) {
            log.debug(LogUtils.RDB_MARKER, "Exception deleting table:" + containerName + "_OBJ_INFER", re);
        }
        try {
            deleteTable(containerName + "_PROP_INFER");
        } catch (RdbException re) {
            log.debug(LogUtils.RDB_MARKER, "Exception deleting table:" + containerName + "_PROP_INFER", re);
        }
        String[] nodeTables = nodeLayout.listTables();
        for (int i = 0; i < nodeTables.length; i++) {
            String tableName = nodeTables[i];
            try {
                deleteTable(tableName);
            } catch (RdbException re) {
                log.debug(LogUtils.RDB_MARKER, "Exception deleting table:" + tableName, re);
            }
        }
        clearCaches();
    }

    private void deleteTable(String tablename) throws RdbException {
        if (!hasTable(tablename))
            return;
        BaseSQL.dropTable(stmtProvider, connection, tablename);
    }

    private boolean hasTable(String tablename) throws RdbException {
        try {
            ResultSet rs = null;
            try {
                rs = connection.getMetaData().getTables(null, null, configuration.getUsesUppercase() ? tablename.toUpperCase() : tablename.toLowerCase(), new String[] { "TABLE" });
                if (!rs.next())
                    return false;
                String tbl = rs.getString(3);
                if (!tbl.equalsIgnoreCase(tablename))
                    return false;
                return true;
            } finally {
                if (rs != null)
                    rs.close();
            }
        } catch (SQLException e) {
            log.error(LogUtils.RDB_MARKER, "Could not get metadata information from the database table", e);
            throw new RdbException(ExceptionConstants.RDB.FAILED_GETTING_TABLE_STATUS, e, tablename);
        }
    }

    private boolean hasTempTable(String tablename) throws RdbException {
        try {
            ResultSet rs = null;
            try {
                rs = connection.getMetaData().getTables(null, null, configuration.getUsesUppercaseTempTables() ? tablename.toUpperCase() : tablename.toLowerCase(), null);
                if (!rs.next()) {
                    return false;
                }
                String tbl = rs.getString(3);
                if (!tbl.equalsIgnoreCase(tablename)) {
                    return false;
                }
                return true;
            } finally {
                if (rs != null) {
                    rs.close();
                }
            }
        } catch (SQLException e) {
            log.error(LogUtils.RDB_MARKER, "Could not get metadata information from the database table", e);
            throw new RdbException(ExceptionConstants.RDB.FAILED_GETTING_TABLE_STATUS, e, tablename);
        }
    }

    public void clear() {
        try {
            try {
                begin();
                remove(find(null, null, null));
                commit();
            } catch (RdbException e) {
                abort();
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_CLEAR, e);
            } finally {
            }
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

    protected void clear(URI... context) {
        try {
            try {
                begin();
                remove(find(null, null, null, context));
            } catch (RdbException e) {
                abort();
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_CLEAR, e);
            } finally {
                commit();
            }
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

    public void add(Statement... statements) {
        try {
            long tranId = random.nextLong();
            if (statements.length > 20 && configuration.getSupportsTempForInsert()) {
                long start1 = System.currentTimeMillis();
                long start = System.currentTimeMillis();
                long end = System.currentTimeMillis();

                begin();
                HashSet<Value> nodes = new HashSet<Value>();
                Collection<Statement> stmts = new HashSet<Statement>();
                Collections.addAll(stmts, statements);
                for (Statement statement : stmts) {
                    Long gid = nodeLayout.getIfCached(statement.getNamedGraphUri());
                    if (gid == null)
                        nodes.add(statement.getNamedGraphUri());
                    Long sid = nodeLayout.getIfCached(statement.getSubject());
                    if (sid == null)
                        nodes.add(statement.getSubject());
                    Long pid = nodeLayout.getIfCached(statement.getPredicate());
                    if (pid == null)
                        nodes.add(statement.getPredicate());
                    Long oid = nodeLayout.getIfCached(statement.getObject());
                    if (oid == null)
                        nodes.add(statement.getObject());
                }
                Map<Value, Long> alreadyStored = (nodes.size() > 0) ? nodeLayout.resolveStoredNodes(nodes, true, connection, tranId) : new HashMap<Value, Long>();
                nodeLayout.commitReferencedIds(connection, tranId);
                end = System.currentTimeMillis();
                log.debug("[RSN]{}:{}", Integer.toString(alreadyStored.size()), Long.toString(end - start));
                start = end;
                GraphSQL.BatchInsertStatement stmt = new GraphSQL.BatchInsertStatement(connection, stmtProvider, configuration.getSessionPrefix() + "STMT_TMP");
                try {
                    for (Statement statement : stmts) {
                        Value[] gspo = { statement.getNamedGraphUri(), statement.getSubject(), statement.getPredicate(), statement.getObject() };
                        Long[] ids = new Long[4];
                        for (int i = 0; i < gspo.length; i++) {
                            if (nodeLayout.isCached(gspo[i])) {
                                ids[i] = nodeLayout.getIfCached(gspo[i]);
                            } else {
                                if (alreadyStored.containsKey(gspo[i])) {
                                    ids[i] = alreadyStored.get(gspo[i]);
                                } else {
                                    log.error("Could not find node: " + gspo[i]);
                                    throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_CONTAINER_FIND_NODE, gspo[i].toString());
                                }
                            }
                        }
                        long ngId = ids[0].longValue();
                        long subjId = ids[1].longValue();
                        long predId = ids[2].longValue();
                        long objId = ids[3].longValue();
                        stmt.addEntry(UriGenerator.isMetadataGraphUri(statement.getNamedGraphUri()) ? 1 : 0, ngId, subjId, predId, objId);
                    }
                    stmt.executeStatement();
                    end = System.currentTimeMillis();
                    log.debug(LogUtils.RDB_MARKER, "[BIS]{}", Long.toString(end - start));
                    start = end;
                    int count = GraphSQL.purgeInsertStatements(stmtProvider, connection, configuration.getSessionPrefix() + configuration.getUniqueTempName("STMT_TMP", 0), configuration.getSessionPrefix() + configuration.getUniqueTempName("STMT_TMP", 1), STATEMENT_TABLE_NAME);
                    end = System.currentTimeMillis();
                    long totalTime = (end - start);
                    log.debug(LogUtils.RDB_MARKER, "[PIS]{}:{}", Integer.toString(count), Long.toString(end - start));
                    start = end;
                    count = GraphSQL.commitInsertStatements(stmtProvider, connection, configuration.getSessionPrefix() + configuration.getUniqueTempName("STMT_TMP", 0), STATEMENT_TABLE_NAME);
                    end = System.currentTimeMillis();
                    log.debug(LogUtils.RDB_MARKER, "[CIS]{}:{}", Integer.toString(count), Long.toString(end - start));
                    totalTime += (end - start);
                    log.debug(LogUtils.RDB_MARKER, "[PCIS]{}:{}", Integer.toString(count), Long.toString(totalTime));
                    commit();
                } catch (RdbException e) {
                    log.error(LogUtils.RDB_MARKER, "Failed executing batched insertStatement ", e);
                    abort();
                    throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_CONTAINER_INSERT_BATCH, e);
                } finally {
                    stmt.close();
                    try {
                        if (configuration.getForceTempTablePurge()) {
                            BaseSQL.truncateTableWithSessionMayCommit(stmtProvider, connection, configuration.getSessionPrefix(), configuration.getUniqueTempName("STMT_TMP", 0));
                        }
                        log.debug(LogUtils.RDB_MARKER, "[STORE]{}:{}:{} Q/mS:{} mS/Q", new Object[] { Integer.toString(statements.length), Long.toString(System.currentTimeMillis() - start1), Long.toString(statements.length / ((System.currentTimeMillis() - start1) + 1)), Long.toString((System.currentTimeMillis() - start1) / (statements.length + 1)) });
                    } catch (RdbException e) {
                        log.error(LogUtils.RDB_MARKER, "Failed executing batched insertStatement ", e);
                        throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_CONTAINER_INSERT_BATCH, e);
                    }

                }

            } else {
                begin();
                try {
                    Set<Statement> stmts = new LinkedHashSet<Statement>();
                    Collections.addAll(stmts, statements);
                    GraphSQL.BatchInsertStatement stmt = new GraphSQL.BatchInsertStatement(connection, stmtProvider, STATEMENT_TABLE_NAME);
                    try {
                        for (Statement statement : stmts) {
                            long ngId = nodeLayout.store(statement.getNamedGraphUri(), connection, tranId).longValue();
                            long subjId = nodeLayout.store(statement.getSubject(), connection, tranId).longValue();
                            long predId = nodeLayout.store(statement.getPredicate(), connection, tranId).longValue();
                            long objId = nodeLayout.store(statement.getObject(), connection, tranId).longValue();
                            int exists;
                            try {
                                exists = GraphSQL.statementExists(stmtProvider, connection, ngId, subjId, predId, objId, STATEMENT_TABLE_NAME);
                            } catch (RdbException e) {
                                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_CONTAINER_STMT_EXISTS, e);
                            }
                            if (exists > 0) {
                                continue;
                            }
                            stmt.addEntry(UriGenerator.isMetadataGraphUri(statement.getNamedGraphUri()) ? 1 : 0, ngId, subjId, predId, objId);
                        }
                        stmt.executeStatement();
                    } finally {
                        stmt.close();
                    }
                    commit();
                } catch (RdbException e) {
                    log.error(LogUtils.RDB_MARKER, "Error adding statements", e);
                    abort();
                    throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_ADD_TRIPLES, e);
                }
            }
        } catch (AnzoException be) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_ADD_TRIPLES, be);
        }
    }

    public void remove(Statement... statements) {
        try {
            try {
                begin();
                for (Statement statement : statements) {
                    Long ngId = nodeLayout.fetchId(statement.getNamedGraphUri(), connection);
                    Long subjId = nodeLayout.fetchId(statement.getSubject(), connection);
                    Long predId = nodeLayout.fetchId(statement.getPredicate(), connection);
                    Long objId = nodeLayout.fetchId(statement.getObject(), connection);
                    if (ngId != null && subjId != null && predId != null && objId != null)
                        GraphSQL.deleteStatement(stmtProvider, connection, ngId, subjId, predId, objId, STATEMENT_TABLE_NAME);
                }
                commit();
            } catch (RdbException e) {
                log.error(LogUtils.RDB_MARKER, "Unable to delete statements: ", e);
                abort();
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_CONTAINER_DELETE_STATEMENT, e);
            }
        } catch (AnzoException be) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_DELETE_TRIPLES, be);
        }
    }

    private int rowCount(String tableName) {
        try {
            return BaseSQL.getRowCount(stmtProvider, connection, tableName);
        } catch (RdbException e) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_CONTAINER_COUNT_ROWS, e, tableName);
        }
    }

    public Collection<Statement> getStatements() {
        return find(null, null, null, (URI[]) null);
    }

    public Collection<Statement> find(Resource subj, URI prop, Value obj, URI... namedGraphUri) {
        try {

            //long start=System.currentTimeMillis();
            Iterable<Quad> quads = FindInferred.findStatements(this, subj, prop, obj, namedGraphUri);
            ArrayList<Statement> stmts = new ArrayList<Statement>();
            for (Quad quad : quads) {
                URI context = (URI) quad.getNamedGraphTerm().getValue();
                Resource s = (Resource) quad.getSubjTerm().getValue();
                URI p = (URI) quad.getPredTerm().getValue();
                Value o = quad.getObjTerm().getValue();
                stmts.add(Constants.valueFactory.createStatement(s, p, o, context));
            }
            //System.err.println("FindTime("+stmts.size()+")->["+(System.currentTimeMillis()-start)+"]"	);

            return stmts;

        } catch (AnzoException be) {
            throw new AnzoRuntimeException(be);
        }
    }

    public int size() {
        return rowCount(STATEMENT_TABLE_NAME);
    }

    public int size(URI... namedGraphUri) {
        int size = 0;
        for (URI ng : namedGraphUri) {
            try {
                Long ngId = nodeLayout.fetchId(ng, connection);
                if (ngId == null) {
                    size += 0;
                } else {
                    size += GraphSQL.size(stmtProvider, connection, ngId, STATEMENT_TABLE_NAME);
                }
            } catch (RdbException e) {
                log.error(LogUtils.RDB_MARKER, "Exception getting size of graph", e);
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_CONTAINER_COUNT_STATEMENTS, e, Arrays.toString(namedGraphUri));
            }
        }
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Tests if a statement is contained in the container.
     * 
     * @param match
     *            is the statement to be tested
     * @return boolean result to indicate if the statement was contained
     */
    public boolean contains(Statement match) {
        return contains(match.getSubject(), match.getPredicate(), match.getObject(), match.getNamedGraphUri());
    }

    /**
     * Tests if a statement is contained in the container.
     * 
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param contexts
     *            Context values to match, or wildcard if null
     * @return boolean result to indicate if the statement was contained
     */
    public boolean contains(Resource subj, URI prop, Value obj, URI... contexts) {
        // FIXME: Optimize this so that the database doesn'q have to work so hard
        Collection<Statement> it = null;
        it = find(subj, prop, obj, contexts);
        return !it.isEmpty();
    }

    /**
     * Execute a SPARQL query against the data within this container
     * 
     * @param defaultNamedGraphsIn
     *            Set&lt;URI&gt; of URIs for NamedGraphs that will make up the default graph for this query
     * @param namedGraphsIn
     *            Set&lt;URI&gt; of URIs for NamedGraphs that will make up the NamedGraphs for this query
     * @param namedDatasets
     *            Set of URIs for named datasets that will contribute to the query's RDF dataset
     * @param query
     *            SPARQL query string
     * @param baseUri
     *            Base URI against which relative URI references in the SPARQL query are resolved
     * @return the Results of running query
     * @throws AnzoException
     */
    public QueryResults executeQuery(Set<URI> defaultNamedGraphsIn, Set<URI> namedGraphsIn, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        try {
            begin();
            log.debug(LogUtils.RDB_MARKER, query);
            long start = System.currentTimeMillis();
            HashSet<URI> defaultNamedGraphs = new HashSet<URI>(defaultNamedGraphsIn);
            HashSet<URI> namedGraphs = new HashSet<URI>(namedGraphsIn);

            if (namedDatasets != null) {
                for (URI uri : namedDatasets) {
                    for (Statement s : find(uri, Anzo.DEFAULTNAMEDGRAPH, null, uri)) {
                        defaultNamedGraphs.add((URI) s.getObject());
                        namedGraphs.add((URI) s.getObject());
                    }
                    for (Statement s : find(uri, Anzo.DEFAULTGRAPH, null, uri)) {
                        defaultNamedGraphs.add((URI) s.getObject());
                    }
                    for (Statement s : find(uri, Anzo.NAMEDGRAPH, null, uri)) {
                        namedGraphs.add((URI) s.getObject());
                    }
                }
            }

            QueryResults results = glitter.executeQuery(null, query, new DefaultQueryDataset(defaultNamedGraphs, namedGraphs), baseUri);
            log.debug(LogUtils.RDB_MARKER, "QueryTime({})->[{}]", Integer.toString(results.getSelectResults().size()), Long.toString(System.currentTimeMillis() - start));
            return results;
        } catch (ParseException pe) {
            abort();
            throw new AnzoException(ExceptionConstants.CLIENT.FAILED_CONTAINER_EXEC_QUERY, pe, query);
        } catch (GlitterException ge) {
            abort();
            throw new AnzoException(ExceptionConstants.CLIENT.FAILED_CONTAINER_EXEC_QUERY, ge, query);
        } finally {
            commit();
        }
    }

    //TODO:Fix this impl
    public Collection<URI> getNamedGraphUris() {
        return null;
    }

    /* (non-Javadoc)
     * @see org.openanzo.jdbc.container.container.IRDBQuadStore#begin()
     */
    public void begin() throws AnzoException {
        internalTransactionManager.begin();
    }

    /* (non-Javadoc)
     * @see org.openanzo.jdbc.container.container.IRDBQuadStore#abort()
     */
    public void abort() throws AnzoException {
        internalTransactionManager.abort();
    }

    /* (non-Javadoc)
     * @see org.openanzo.jdbc.container.container.IRDBQuadStore#commit()
     */
    public void commit() throws AnzoException {
        internalTransactionManager.commit();
    }

    protected void reset(String id) {
        nodeLayout.clearCache();
    }

    /**
     * Get the conection for the quad store
     * 
     * @return the conection for the quad store
     */
    public Connection getConnection() {
        return connection;
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
     * Get the preparedStatement provider
     * 
     * @return the preparedStatement provider
     */
    public PreparedStatementProvider getPreparedStatementProvider() {
        return stmtProvider;
    }

    /**
     * Set if quad store is returned
     * 
     * @param returned
     *            is returned to pool
     */
    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    /**
     * Get if quad store is returned to pool
     * 
     * @return if quad store is returned to pool
     */
    public boolean getReturned() {
        return returned;
    }

    /**
     * @return the nodeLayout
     */
    public CompositeNodeLayout getNodeLayout() {
        return nodeLayout;
    }

}
