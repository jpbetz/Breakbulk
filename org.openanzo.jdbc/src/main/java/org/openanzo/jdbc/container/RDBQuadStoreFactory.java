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

import java.sql.Connection;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.cache.LRUCacheProvider;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.layout.indexer.LiteralIndexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates RDBQuadStores from a pool.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class RDBQuadStoreFactory implements PoolableObjectFactory {

    private static final Logger             log = LoggerFactory.getLogger(RDBQuadStoreFactory.class);

    /** JDBC Connection Pool */
    private PoolableConnectionFactory       pcf;

    private GenericObjectPool               connectionPool;

    /** RespositoryConnectionPool */
    private final RDBQuadStorePool          quadStorePool;

    /** ConnectionPool */
    private final PoolableConnectionFactory connectionFactory;

    /** ReadOnly connections */
    private final boolean                   write;

    /** Configuration data for the connections in this pool */
    private final CoreDBConfiguration       configuration;

    /** Shared cache provider for the connections in this pool */
    private final ICacheProvider            cacheProvider;

    /** Literal indexer for the stores in this pool */
    private final LiteralIndexer            literalIndexer;

    /**
     * Create new RDBQuadStoreFactory
     * 
     * @param quadStorePool
     *            Pool of jdbc connections
     * @param parentPool
     *            Parent pool that is using this factory to create connections
     * @param literalIndexer
     *            Literal indexer for the connections in this pool
     * @param write
     *            is connection for writting data
     * @param maxActive
     *            connections allowed
     * @param configuration
     *            data for connections
     */
    protected RDBQuadStoreFactory(RDBQuadStorePool quadStorePool, LiteralIndexer literalIndexer, boolean write, int maxActive, CoreDBConfiguration configuration) {
        this.quadStorePool = quadStorePool;
        this.write = write;
        this.configuration = configuration;
        this.cacheProvider = new LRUCacheProvider();
        this.connectionFactory = initializeConnectionFactory(write, maxActive, configuration);
        this.literalIndexer = literalIndexer;
    }

    /**
     * Close the factory
     * 
     * @throws Exception
     */
    protected void close() throws Exception {
        connectionFactory.getPool().close();
    }

    /** Activate RDBConnection from pool */
    public void activateObject(Object obj) throws Exception {
        ((RDBQuadStore) obj).setReturned(false);
    }

    /** Destroy RDBConnection */
    public void destroyObject(Object obj) throws Exception {
        closeConnection(((RDBQuadStore) obj));
    }

    /** Make new RDBConnection */
    public Object makeObject() throws Exception {
        Connection connection = (Connection) connectionFactory.makeObject();
        connectionFactory.activateObject(connection);
        RDBQuadStore con = new RDBQuadStore(cacheProvider, literalIndexer, write, configuration, connection);
        //quadStorePool.registerResetListener(con);
        return con;
    }

    /** Put RDBConnection back in pool */
    public void passivateObject(Object obj) throws Exception {
        cleanConnection(((IRDBQuadStore) obj));
        ((RDBQuadStore) obj).setReturned(true);
    }

    /** Validate RDBConnection is still good */
    public boolean validateObject(Object obj) {
        RDBQuadStore con = ((RDBQuadStore) obj);
        return !con.isClosed();
    }

    private static void cleanConnection(IRDBQuadStore con) {
        try {
            con.abort();
        } catch (AnzoException bre) {
            log.error(LogUtils.RDB_MARKER, "Error aborting jdbc connection", bre);
        }
    }

    private void closeConnection(RDBQuadStore con) {
        cleanConnection(con);
        con.close();
        quadStorePool.allStores.remove(con);
        //quadStorePool.unregisterResetListener(con);
    }

    private PoolableConnectionFactory initializeConnectionFactory(boolean write, int maxActive, CoreDBConfiguration configuration) {
        // Will use in jndi
        // DataSource ds = (DataSource) ctx.lookup(RepositoryProperties.getDatabaseJndiName(properties));
        try {
            Class.forName(configuration.getDriverClassName());
        } catch (ClassNotFoundException e1) {
            throw new AnzoRuntimeException(ExceptionConstants.RDB.DRIVER_NAME, e1, configuration.getDriverClassName());
        }
        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(configuration.getJdbcUrl(), configuration.getUser(), configuration.getPassword());
        connectionPool = new GenericObjectPool();
        connectionPool.setMaxActive(maxActive);
        connectionPool.setMinIdle(1);
        connectionPool.setWhenExhaustedAction(GenericObjectPool.WHEN_EXHAUSTED_BLOCK);
        connectionPool.setMaxWait(30000);
        connectionPool.setMaxActive(maxActive);
        pcf = new PoolableConnectionFactory(connectionFactory, connectionPool, null, null, false, true);
        if ((!write && configuration.getSupportsIsolation()))
            pcf.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        return pcf;
    }
}
