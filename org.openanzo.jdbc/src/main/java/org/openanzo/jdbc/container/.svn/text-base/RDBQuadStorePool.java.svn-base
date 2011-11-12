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

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.layout.indexer.LiteralIndexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages a pool of RDBQuadStore objects. Database connections and SQL prepared statements are allocated for each RDBQuadStore according to the provided
 * configuration.
 * 
 * @author Joe Betz
 */
class RDBQuadStorePool {

    private static final Logger       log                   = LoggerFactory.getLogger(RDBQuadStorePool.class);

    /** Usage Count */
    private int                       usageCount            = 0;

    /** Max number of JDBC connections to open in pool */
    private final int                 MAX_READ_CONNECTIONS  = 15;

    /** Max number of JDBC connections to open in pool */
    private int                       MAX_WRITE_CONNECTIONS = 1;

    /** Set of all RDBQuadStores */
    protected final Set<RDBQuadStore> allStores;

    /** GenericObjectPool read RDBQuadStorePool */
    private GenericObjectPool         readPool              = null;

    /** RDBQuadStoreFactory for READ QuadStores */
    private RDBQuadStoreFactory       factoryRead           = null;

    /** GenericObjectPool rw RDBQuadStorePool */
    private GenericObjectPool         rwPool                = null;

    /** RDBQuadStoreFactory for READ_WRITE QuadStores */
    private RDBQuadStoreFactory       factoryRw             = null;

    /** Pool is started */
    private boolean                   started               = false;

    private final ReentrantLock       startLock             = new ReentrantLock();

    private final CoreDBConfiguration configuration;

    private final LiteralIndexer      literalIndexer;

    /**
     * Create new RDBQuadStorePool
     * 
     * @param properties
     *            Configuration properties
     * @param literalIndexer
     *            optional literal indexer
     */
    protected RDBQuadStorePool(CoreDBConfiguration configuration, LiteralIndexer literalIndexer) {
        if (configuration == null) {
            throw new AnzoRuntimeException(ExceptionConstants.SERVER.NO_SERVER_CONFIG);
        }
        this.literalIndexer = literalIndexer;
        this.configuration = configuration;
        allStores = new HashSet<RDBQuadStore>();
        incrementUsageCount();
        if (!configuration.getSupportsTableLocks()) {
            MAX_WRITE_CONNECTIONS = 1;
        }
    }

    /**
     * Start the connection pools
     * 
     * @throws AnzoException
     */
    protected void start() throws AnzoException {
        startLock.lock();
        try {
            if (started)
                return;
            started = true;
            setupPools();
        } finally {
            startLock.unlock();
        }
    }

    /**
     * Determine if the pool is started
     * 
     * @return true if pool is started
     * @throws AnzoException
     */
    public boolean getIsStarted() throws AnzoException {
        return started;
    }

    /**
     * Stop the connection pools
     */
    private void stop() {
        startLock.lock();
        try {
            started = false;
            try {
                rwPool.close();
                factoryRw.close();
                rwPool = null;
                factoryRw = null;
            } catch (Exception e) {
                log.error(LogUtils.RDB_MARKER, "Error closing connection pool", e);
            }
            try {
                readPool.close();
                factoryRead.close();
                readPool = null;
                factoryRead = null;
            } catch (Exception e) {
                log.error(LogUtils.RDB_MARKER, "Error closing connection pool", e);
            }
        } finally {
            startLock.unlock();
        }
    }

    private void setupPools() {
        readPool = new GenericObjectPool();
        factoryRead = new RDBQuadStoreFactory(this, literalIndexer, false, MAX_READ_CONNECTIONS, configuration);
        setupPool(readPool, factoryRead, MAX_READ_CONNECTIONS, MAX_READ_CONNECTIONS / 2, 60000);
        rwPool = new GenericObjectPool();
        factoryRw = new RDBQuadStoreFactory(this, literalIndexer, true, MAX_WRITE_CONNECTIONS, configuration);
        setupPool(rwPool, factoryRw, MAX_WRITE_CONNECTIONS, (MAX_WRITE_CONNECTIONS > 1) ? MAX_WRITE_CONNECTIONS / 2 : 1, 60000);
    }

    private void setupPool(GenericObjectPool pool, RDBQuadStoreFactory factory, int maxActive, int maxIdle, long blockWait) {
        pool.setFactory(factory);
        pool.setMaxActive(maxActive);
        pool.setMaxIdle(maxIdle);
        pool.setWhenExhaustedAction(GenericObjectPool.WHEN_EXHAUSTED_BLOCK);
        pool.setMaxWait(blockWait);
    }

    /**
     * Get a RDBQuadStore from the pool
     * 
     * @param type
     *            Type of RDBQuadStore to acquire
     * @return RDBQuadStore from the pool
     * @throws AnzoException
     */
    protected synchronized RDBQuadStore acquireRDBQuadStore(boolean write) throws AnzoException {
        RDBQuadStore quadStore = null;
        try {
            if (write) {
                quadStore = (RDBQuadStore) rwPool.borrowObject();
            } else {
                quadStore = (RDBQuadStore) readPool.borrowObject();
            }
        } catch (Exception e) {
            log.error(LogUtils.RDB_MARKER, "Error error acquiring quad store", e);
            throw new RuntimeException(e);
        }
        allStores.add(quadStore);
        return quadStore;
    }

    private int incrementUsageCount() {
        return ++usageCount;
    }

    private int decrementUsageCount() {
        return --usageCount;
    }

    /**
     * Close a reference to the pool, and if last reference, close the pool
     */
    protected void close() {
        int usage = decrementUsageCount();
        if (usage == 0) {
            stop();
        }
    }

    /**
     * Get the number of active stores in the read pool
     * 
     * @return number of active stores in the read pool
     */
    public int getReadStoresInUseSize() {
        return readPool.getNumActive();
    }

    /**
     * Get the number of inactive stores in the read pool
     * 
     * @return number of inactive stores in the read pool
     */
    public int getReadStoresInactiveSize() {
        return readPool.getNumIdle();
    }

    /**
     * Get the the max number of stores in the read pool
     * 
     * @return the max number of stores in the read pool
     */
    public int getReadStoreMaxPoolSize() {
        return readPool.getMaxActive();
    }

    /**
     * Get the number of active stores in the write pool
     * 
     * @return number of active stores in the write pool
     */
    public int getWriteStoresInUseSize() {
        return rwPool.getNumActive();
    }

    /**
     * Get the number of inactive stores in the write pool
     * 
     * @return number of inactive stores in the write pool
     */
    public int getWriteStoresInactiveSize() {
        return rwPool.getNumIdle();
    }

    /**
     * Get the max number of stores in the write pool
     * 
     * @return the max number of stores in the write pool
     */
    public int getWriteStoresMaxPoolSize() {
        return rwPool.getMaxActive();
    }

    /**
     * set the max size of the read pool
     * 
     * @param size
     *            max size of the read pool
     */
    public void setReadStoresMaxPoolSize(int size) {
        readPool.setMaxActive(size);
    }

    /**
     * set the max size of the write pool
     * 
     * @param size
     *            max size of the write pool
     */
    public void setWriteStoresMaxPoolSize(int size) {
        rwPool.setMaxActive(size);
    }

    /**
     * Get the max time to wait for a store in the read pool
     * 
     * @return the max time to wait for a store in the read pool
     */
    public long getReadStoresPoolMaxWaitTime() {
        return readPool.getMaxWait();
    }

    /**
     * Get the max time to wait for a store in the write pool
     * 
     * @return the max time to wait for a store in the write pool
     */
    public long getWriteStoresPoolMaxWaitTime() {
        return rwPool.getMaxWait();
    }

    /**
     * Set the max time to wait for a store in the read pool
     * 
     * @param maxWait
     *            time
     */
    public void setReadStoresPoolMaxWaitTime(long maxWait) {
        readPool.setMaxWait(maxWait);
    }

    /**
     * Set the max time to wait for a stores in the write pool
     * 
     * @param maxWait
     *            time
     */
    public void setWriteStoresPoolMaxWaitTime(long maxWait) {
        rwPool.setMaxWait(maxWait);
    }

    /**
     * Get the max idle stores in read pool
     * 
     * @return the max idle stores in read pool
     */
    public int getReadStoresPoolMaxIdle() {
        return readPool.getMaxIdle();
    }

    /**
     * Get the min idle time for stores in read pool
     * 
     * @return the min idle time for stores in read pool
     */
    public long getReadStoresPoolMinIdleTime() {
        return readPool.getMinEvictableIdleTimeMillis();
    }

    /**
     * Get the max idle stores in write pool
     * 
     * @return the max idle stores in write pool
     */
    public int getWriteStoresPoolMaxIdle() {
        return rwPool.getMaxIdle();
    }

    /**
     * Get the min idle time for stores in write pool
     * 
     * @return the min idle time for stores in write pool
     */
    public long getWriteStoresPoolMinIdleTime() {
        return rwPool.getMinEvictableIdleTimeMillis();
    }

    /**
     * Set the max number of idle stores in the read pool
     * 
     * @param max
     *            number of idle stores
     */
    public void setReadStoresPoolMaxIdlexIdle(int max) {
        readPool.setMaxIdle(max);
    }

    /**
     * Set the minimum idle time for stores in the read pool
     * 
     * @param minWait
     *            idle time for stores in the read pool
     */
    public void setReadStoresPoolMinIdleTime(long minWait) {
        readPool.setMinEvictableIdleTimeMillis(minWait);
    }

    /**
     * Set the max number of idle stores in the write pool
     * 
     * @param max
     *            number of idle stores
     */
    public void setWriteStoresPoolMaxIdle(int max) {
        rwPool.setMaxIdle(max);
    }

    /**
     * Set the minimum idle time for stores in the write pool
     * 
     * @param minWait
     *            idle time for stores in the write pool
     */
    public void setWriteStoresPoolMinIdleTime(long minWait) {
        rwPool.setMinEvictableIdleTimeMillis(minWait);
    }

    /**
     * Get the database store URL
     * 
     * @return the database store URL
     */
    public String getDatabaseUrl() {
        return configuration.getJdbcUrl();
    }

    /**
     * Get the database username
     * 
     * @return the database username
     */
    public String getDatabaseUserName() {
        return configuration.getUser();
    }

    /**
     * Set the database store URL
     * 
     * @param jdbcUrl
     *            for stores in the pool
     */
    public void setDatabaseUrl(String jdbcUrl) {
        configuration.setJBDCUrl(jdbcUrl);
    }

    /**
     * Set the database username
     * 
     * @param userName
     *            for database stores
     */
    public void setDatabaseUserName(String userName) {
        configuration.setUser(userName);
    }

    /**
     * Get the database password
     * 
     * @return the database password
     */
    public String getDatabasePassword() {
        return configuration.getPassword();
    }

    /**
     * Set the database password
     * 
     * @param password
     *            for database stores
     */
    public void setDatabasePassword(String password) {
        configuration.setPassword(password);
    }

    /**
     * Get the database driver's class name
     * 
     * @return the database driver's class name
     */
    public String getDatabaseDriver() {
        return configuration.getDriverClassName();
    }

    /**
     * Set the name of the jdbc driver class
     * 
     * @param dbDriver
     *            classname of jdbc driver
     */
    public void setDatabaseDriver(String dbDriver) {
        configuration.setDriverClassName(dbDriver);
    }

    /**
     * Get the filename for initialization and read file for database
     * 
     * @return the filename for initialization and read file for database
     */
    public String getRepositoryInitFile() {
        return configuration.getSqlFilename();
    }

    /**
     * Set the filename of the initialization and read file for database
     * 
     * @param dbInitFile
     *            initialization and read file for database
     */
    public void setRepositoryInitFile(String dbInitFile) {
        configuration.setSqlFilename(dbInitFile);
    }

    /**
     * @return the configuration
     */
    public CoreDBConfiguration getConfiguration() {
        return configuration;
    }
}
