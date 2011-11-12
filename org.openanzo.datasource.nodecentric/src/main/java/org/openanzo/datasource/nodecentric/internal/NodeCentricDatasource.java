/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 27, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.collections15.MultiMap;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.apache.commons.pool.impl.GenericKeyedObjectPoolFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.openanzo.cache.ICache;
import org.openanzo.cache.ICacheListener;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.DatasourceDictionary;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IModelService;
import org.openanzo.datasource.IQueryService;
import org.openanzo.datasource.IReplicationService;
import org.openanzo.datasource.IResetService;
import org.openanzo.datasource.IServerQuadStoreProvider;
import org.openanzo.datasource.IUpdateService;
import org.openanzo.datasource.nodecentric.query.GraphSet;
import org.openanzo.datasource.nodecentric.sql.Backup;
import org.openanzo.datasource.nodecentric.sql.GlitterRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.LastTransactionTime;
import org.openanzo.datasource.nodecentric.sql.NamedGraphRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.ServerRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.Backup.SelectFullStatementsNRResult;
import org.openanzo.datasource.nodecentric.sql.Backup.SelectFullStatementsResult;
import org.openanzo.datasource.nodecentric.sql.Backup.SelectNamedGraphsRevisionedResult;
import org.openanzo.datasource.nodecentric.sql.Backup.SelectStatementsRevisionedResult;
import org.openanzo.datasource.nodecentric.sql.GlitterRdbWrapper.SelectQueryDatasetsResult;
import org.openanzo.datasource.services.BaseDatasource;
import org.openanzo.datasource.services.CachedAuthorizationService;
import org.openanzo.datasource.update.NamedGraphType;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.CompoundAnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.ontologies.system.Datasource;
import org.openanzo.ontologies.system.DatasourceCapability;
import org.openanzo.ontologies.system.SystemFactory;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.datatype.TypeMaps;
import org.openanzo.rdf.utils.Collections;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.vocabulary.XMLSchema;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IAuthorizationEventListener;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IStatisticsProvider;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.impl.BaseOperationContext;
import org.openanzo.services.serialization.BackupRevision;
import org.openanzo.services.serialization.IBackupHandler;
import org.openanzo.services.serialization.XMLBackupReader;
import org.openanzo.services.serialization.XMLGraphBackupWriter;
import org.openanzo.services.serialization.XMLWritingUtils;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Back-end implementation that talks to a NodeCentric RDB store.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class NodeCentricDatasource extends BaseDatasource implements IDatasource, IStatisticsProvider {

    protected static final Logger                           log                    = LoggerFactory.getLogger(NodeCentricDatasource.class);

    /** Max number of operations per transactions */
    public static final int                                 MAX_OPERATION_SIZE     = 32000;

    private static final long                               SCHEMA_VERSION         = 12;

    private static final int                                PS_CACHE_SIZE          = 100;

    static final String                                     serverUpper            = "SERVER";

    static final String                                     serverLower            = "server";

    private static final String                             table                  = "TABLE";

    private static final String                             seq                    = "SEQUENCE";

    private static final String                             view                   = "VIEW";

    static final String                                     STATEMENTS             = "STATEMENTS";

    static final String                                     STATEMENTS_NR          = "STATEMENTS_NR";

    /** Max number of JDBC connections to open in pool */
    private int                                             MAX_QUERY_CONNECTIONS  = 8;

    /** Max number of JDBC connections to open in pool */
    private int                                             MAX_WRITE_CONNECTIONS  = 4;

    /** Existence of this table determines if database has been initialized */
    private static final String                             INITIAL_DATABASE_TABLE = "STATEMENTS";

    /** Connection Configuration */
    private final CoreDBConfiguration                       configuration;

    /** Query Pool */
    public final GenericObjectPool                          queryPool;

    /** Write Pool */
    public final GenericObjectPool                          writePool;

    private final IAuthorizationService                     authorizationService;

    private final NodeCentricResetService                   resetService;

    private final NodeCentricIndexService                   indexService;

    private final NodeCentricIndexUpdateHandler             indexHandler;

    private final NodeCentricModelService                   modelService;

    private final NodeCentricUpdateService                  updateService;

    private final NodeCentricReplicationService             replicationService;

    private final NodeCentricQueryService                   queryService;

    private final WeakHashMap<Connection, ReentrantLock>    connectionLocks        = new WeakHashMap<Connection, ReentrantLock>();

    protected final PreparedStatementProvider               statementProvider;

    private final CompositeNodeLayout                       nodeLayout;

    private static final String                             INITIALIZE_CONNECTION  = "initializeConnection";

    private final NodeCentricDatasourceStatistics           stats                  = new NodeCentricDatasourceStatistics();

    private final ReentrantLock                             serverLock             = new ReentrantLock();

    private final ReentrantLock                             graphSetLock           = new ReentrantLock();

    private final Condition                                 graphSetReady          = graphSetLock.newCondition();

    private final Collection<Long>                          purgedSets             = new ArrayList<Long>();

    private final Thread                                    purgeSetThread;

    /** Shared reset lock used during testing */
    private final ReentrantReadWriteLock                    resetLock              = new ReentrantReadWriteLock();

    private final Set<IAuthorizationEventListener>          aclEventListeners;

    private final OsgiServiceTracker<IUpdateResultListener> updateListenerTracker;

    private final String                                    instanceId;

    private final EventAdmin                                eventAdmin;

    private final ICacheProvider                            cacheProvider;

    private boolean                                         initialized            = false;

    private final ICache<GraphSet, GraphSet>                graphSets;

    private Dictionary<? extends Object, ? extends Object>  configProperties;

    /**
     * Create a new NodeCentricDatasource.
     * 
     * @param bundleContext
     * @param configProperties
     * @param cacheProvider
     * @param aclEventListeners
     * @param eventAdmin
     * @throws AnzoException
     */
    public NodeCentricDatasource(BundleContext bundleContext, Dictionary<? extends Object, ? extends Object> configProperties, ICacheProvider cacheProvider, Set<IAuthorizationEventListener> aclEventListeners, EventAdmin eventAdmin) throws AnzoException {
        super(configProperties);
        this.configProperties = configProperties;
        //Runtime runtime = Runtime.getRuntime();
        //int nrOfProcessors = runtime.availableProcessors();
        //this.MAX_QUERY_CONNECTIONS = Math.max(2, nrOfProcessors - 1);
        // this.MAX_WRITE_CONNECTIONS = Math.max(2, nrOfProcessors - 1);
        if (DatasourceDictionary.getMaxWriteConnections(configProperties) != null) {
            this.MAX_WRITE_CONNECTIONS = DatasourceDictionary.getMaxWriteConnections(configProperties);
        }
        if (DatasourceDictionary.getMaxQueryConnections(configProperties) != null) {
            this.MAX_QUERY_CONNECTIONS = DatasourceDictionary.getMaxQueryConnections(configProperties);
        }
        this.aclEventListeners = aclEventListeners;
        this.cacheProvider = cacheProvider;
        this.eventAdmin = eventAdmin;
        this.graphSets = cacheProvider.openCache("GraphSetCache", 20, false);
        this.graphSets.registerListener(new ICacheListener<GraphSet, GraphSet>() {
            public void elementRemoved(GraphSet key, GraphSet value) {
                graphSetLock.lock();
                try {
                    purgedSets.add(key.getSetId());
                    graphSetReady.signal();
                } finally {
                    graphSetLock.unlock();
                }
            }
        });

        instanceId = (String) configProperties.get(org.osgi.framework.Constants.SERVICE_PID);
        configuration = CoreDBConfiguration.createConfiguration(configProperties);
        statementProvider = new PreparedStatementProvider();
        URL psURL = bundleContext.getBundle().getResource(configuration.getSqlFilename());
        if (psURL != null) {
            try {
                InputStream stream = psURL.openStream();
                statementProvider.loadSQLFile(stream);
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.RDB.FAILED_INITIALIZING_POOL, ioe);
            }
        }
        nodeLayout = new CompositeNodeLayout(statementProvider, configuration.getSupportsSequences(), null, configuration.getContainerName(), configuration.getMaxLongObjectLength(), configuration.getOptimizationString(), true, configuration.getSupportsIdentity(), configuration.getSessionPrefix(), this.cacheProvider.<Long, URI> openCache(instanceId + "UriValue", 20000, true), this.cacheProvider.<URI, Long> openCache(instanceId + "UriIdValue", 20000, true), this.cacheProvider.<Long, BlankNode> openCache(instanceId + "BlankValue", 20000, true), this.cacheProvider.<BlankNode, Long> openCache(instanceId + "BlankIdValue", 20000, true), this.cacheProvider.<Long, PlainLiteral> openCache(instanceId + "PlainLiteralValue", 20000, true), this.cacheProvider.<PlainLiteral, Long> openCache(instanceId + "PlainLiteralIdValue", 20000, true), this.cacheProvider.<Long, TypedLiteral> openCache(instanceId + "TypedLiteralValue", 20000, true), this.cacheProvider.<TypedLiteral, Long> openCache(instanceId + "TypedLiteralIdValue", 20000, true), this.cacheProvider.<Long, String> openCache(instanceId + "LanguageValue", 20000, true), this.cacheProvider.<String, Long> openCache(instanceId + "LanguageIdValue", 20000, true), this.cacheProvider.<Long, String> openCache(instanceId + "DatatypeValue", 20000, true), this.cacheProvider.<String, Long> openCache(instanceId + "DatatypeIdValue", 20000, true));

        this.isPrimary = DatasourceDictionary.getIsPrimary(configProperties);

        resetService = new NodeCentricResetService(resetEnabled, this);
        updateService = new NodeCentricUpdateService(this);
        modelService = new NodeCentricModelService(this, (enableCaching) ? this.cacheProvider : null);
        indexService = new NodeCentricIndexService(this);
        indexHandler = new NodeCentricIndexUpdateHandler(this);
        queryService = new NodeCentricQueryService(this, (enableCaching) ? this.cacheProvider : null);
        replicationService = new NodeCentricReplicationService(this, (enableCaching) ? this.cacheProvider : null);
        authorizationService = new CachedAuthorizationService(new NodeCentricAuthorizationService(this), (enableCaching) ? this.cacheProvider : null);

        queryPool = initializeConnectionFactory(false, MAX_QUERY_CONNECTIONS);
        writePool = initializeConnectionFactory(true, MAX_WRITE_CONNECTIONS);

        updateService.addDatasourceUpdateResultListener(indexHandler);
        if (replicationService.getCacheUpdateListener() != null)
            updateService.addDatasourceUpdateResultListener(replicationService.getCacheUpdateListener());
        if (queryService.getCacheUpdateListener() != null)
            updateService.addDatasourceUpdateResultListener(queryService.getCacheUpdateListener());
        if (modelService.getCacheUpdateListener() != null)
            updateService.addDatasourceUpdateResultListener(modelService.getCacheUpdateListener());
        resetService.start();
        updateService.start();
        queryService.start();
        replicationService.start();
        authorizationService.start();
        indexHandler.start();
        indexService.start();
        modelService.start();
        try {
            Connection connection = (Connection) writePool.borrowObject();
            writePool.returnObject(connection);
        } catch (AnzoException ae) {
            throw ae;
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.RDB.FAILED_INITIALIZING_POOL, e);
        }
        updateListenerTracker = new OsgiServiceTracker<IUpdateResultListener>(new IServiceTrackerListener<IUpdateResultListener>() {

            public void unregisterService(IUpdateResultListener service) {
                updateService.removeGlobalUpdateResultListener(service);
            }

            public void registerService(IUpdateResultListener service) {
                updateService.addGlobalUpdateResultListener(service);
            }

            public Class<IUpdateResultListener> getComponentType() {
                return IUpdateResultListener.class;
            }

        }, bundleContext);
        updateListenerTracker.open();
        setupCapabilities();
        // state = ServiceLifecycleState.STARTED;
        setupStats(bundleContext);
        indexHandler.rebuildIndex(indexHandler.rebuildIndex);
        purgeSetThread = new Thread("PurgeQueryGraphSets") {
            @Override
            public void run() {
                while (!interrupted()) {
                    try {
                        graphSetLock.lockInterruptibly();
                        try {
                            if (purgedSets.size() > 0) {
                                try {
                                    Connection connection = getWriteConnection();
                                    begin(connection, true, true);
                                    GlitterRdbWrapper.BatchPurgeQueryDataset ps = new GlitterRdbWrapper.BatchPurgeQueryDataset(connection, statementProvider);
                                    try {
                                        for (Long id : purgedSets) {
                                            ps.addEntry(id);
                                        }
                                        purgedSets.clear();
                                        ps.executeStatement();
                                        commit(connection, true, true);
                                        ps.close();
                                    } finally {
                                        returnWriteConnection(connection);
                                    }
                                } catch (AnzoException ae) {
                                    log.error(LogUtils.RDB_MARKER, "Error purging graph datasets", ae);
                                }
                            }
                            graphSetReady.await();
                        } finally {
                            graphSetLock.unlock();
                        }
                    } catch (InterruptedException ie) {
                        return;
                    }
                }
            }
        };
        purgeSetThread.setDaemon(true);
        purgeSetThread.start();
    }

    public boolean isSelfDescribing() {
        return true;
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    public String getName() {
        String name = "";
        try {
            name = "Datasource=NodeCentricDatasource_" + URLEncoder.encode(getInstanceURI().toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("Should never happen since UTF-8 must be supported by all JVMs on all platforms.", e);
        }
        return name;
    }

    public String getDescription() {
        return "Node Centric Datasource:" + getInstanceURI().toString();
    }

    public IModelService getModelService() {
        return modelService;
    }

    public IQueryService getQueryService() {
        return queryService;
    }

    public IReplicationService getReplicationService() {
        return replicationService;
    }

    public IResetService getResetService() {
        return resetService;
    }

    public IUpdateService getUpdateService() {
        return updateService;
    }

    public IServerQuadStoreProvider getServerQuadStoreProvider() {
        return updateService;
    }

    public IAuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    @Override
    public void setupCapabilities() {
        super.setupCapabilities();
    }

    /**
     * @param bundleStopping
     *            true if the bundle stopping explicitly, and not due to overall osgi system shutdown
     * @throws AnzoException
     *             {@link ExceptionConstants.OSGI#ERROR_STOPPING_SERVICE} if there was a problem stopping this service
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_CLOSING_POOL} if there was a problem closing the database connection pool
     */
    public void close(boolean bundleStopping) throws AnzoException {
        if (!bundleStopping) {
            cleanupStats();
        }
        ArrayList<AnzoException> exceptions = new ArrayList<AnzoException>();
        if (queryPool != null) {
            try {
                queryPool.close();
            } catch (Exception e) {
                exceptions.add(new AnzoException(ExceptionConstants.RDB.FAILED_CLOSING_POOL, e));
            }
        }
        if (writePool != null) {
            try {
                writePool.close();
            } catch (Exception e) {
                exceptions.add(new AnzoException(ExceptionConstants.RDB.FAILED_CLOSING_POOL, e));
            }
        }
        if (exceptions.size() > 0) {
            throw new CompoundAnzoException(exceptions, ExceptionConstants.OSGI.ERROR_STOPPING_SERVICE);
        }
        if (purgeSetThread != null) {
            purgeSetThread.interrupt();
        }
    }

    @Override
    public void postReset() {
        super.postReset();
        setupCapabilities();
    }

    void resetDatasource() throws AnzoException {
        getNodeLayout().clearCache();
        modelService.reset();
        updateService.reset();
        indexService.reset();
        authorizationService.reset();
        replicationService.reset();
        queryService.reset();
        indexHandler.reset();
        graphSets.clear();
        purgedSets.clear();
        capabilities = null;
    }

    /**
     * Backup data to a file
     * 
     * @param fileName
     * @throws AnzoException
     */
    public void backupData(String fileName) throws AnzoException {
        Connection connection = getWriteConnection();
        try {
            lockTable(connection, true);
            ClosableIterator<Long> uuids = Backup.selectDistinctRevisionedUUIDs(statementProvider, connection);
            Collection<Long> uuidIds = new ArrayList<Long>();
            Collections.addAll(uuids, uuidIds);
            uuids = Backup.selectDistinctNonRevisionedUUIDs(statementProvider, connection);
            Collections.addAll(uuids, uuidIds);
            //Calendar cal = Calendar.getInstance();
            //directoryName + "/datasourceBackup_" + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) + cal.get(Calendar.DAY_OF_MONTH) + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + ".xml"
            exportGraphs(uuidIds, fileName, connection);
        } finally {
            unlockTable(connection, true);
            returnWriteConnection(connection);
        }
    }

    /**
     * Export a set of set of graphs
     * 
     * @param graphsToExport
     *            set of graphs to export
     * @param fileName
     *            filename to which exports are written
     * @throws AnzoException
     */
    public void exportGraphs(Collection<URI> graphsToExport, String fileName) throws AnzoException {
        final NodeCentricOperationContext connectionContext = getWriteContext(new BaseOperationContext("EXPORT", BaseOperationContext.generateOperationId(), new AnzoPrincipal("sysadmin", null, null, true, false)));
        try {
            lockTable(connectionContext.getConnection(), true);
            Collection<Long> uuidIds = new ArrayList<Long>();
            for (URI graph : graphsToExport) {
                Long graphId = connectionContext.getNodeLayout().fetchId(graph, connectionContext.getConnection());
                if (graphId != null) {
                    ClosableIterator<Long> uuids = Backup.selectRevisionedGraphUUIDs(connectionContext.getStatementProvider(), connectionContext.getConnection(), graphId);
                    Collections.addAll(uuids, uuidIds);
                    uuids = Backup.selectNonRevisionedGraphUUIDs(connectionContext.getStatementProvider(), connectionContext.getConnection(), graphId);
                    Collections.addAll(uuids, uuidIds);
                }
            }
            exportGraphs(uuidIds, fileName, connectionContext.getConnection());
        } finally {
            unlockTable(connectionContext.getConnection(), true);
            returnWriteContext(connectionContext);
        }
    }

    @SuppressWarnings("null")
    private void exportGraphs(Collection<Long> uuids, String fileName, Connection connection) throws AnzoException {
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(fileName), Constants.byteEncoding);
            XMLGraphBackupWriter.writeBackupsStart(writer);
            for (Long uuidId : uuids) {
                ClosableIterator<SelectNamedGraphsRevisionedResult> results = Backup.selectNamedGraphsRevisioned(statementProvider, connection, uuidId);
                URI ngURI = null;
                URI metaURI = null;
                URI uuid = (URI) nodeLayout.fetchValue(uuidId, connection);
                Long id = null;
                Long metaId = null;
                if (results.hasNext()) {
                    SelectNamedGraphsRevisionedResult result = results.next();
                    ngURI = (URI) nodeLayout.fetchValue(result.getId(), connection);
                    id = result.getId();
                    metaId = result.getMetaId();
                    metaURI = (URI) nodeLayout.fetchValue(result.getMetaId(), connection);
                    URI lastMode = (URI) nodeLayout.fetchValue(result.getLastModifiedBy(), connection);
                    long revision = result.getRevision();
                    long hstart = result.getHstart();
                    long hend = result.getHend();
                    XMLGraphBackupWriter.writeNamedGraphBackupStart(writer, ngURI, metaURI, uuid, true);
                    XMLGraphBackupWriter.writeRevisionsStart(writer);
                    XMLGraphBackupWriter.writeRevisionInfo(writer, revision, hstart, hend, lastMode);
                }
                while (results.hasNext()) {
                    SelectNamedGraphsRevisionedResult result = results.next();
                    URI lastMode = (URI) nodeLayout.fetchValue(result.getLastModifiedBy(), connection);
                    long revision = result.getRevision();
                    long hstart = result.getHstart();
                    long hend = result.getHend();
                    XMLGraphBackupWriter.writeRevisionInfo(writer, revision, hstart, hend, lastMode);
                }
                XMLGraphBackupWriter.writeRevisionsEnd(writer);
                XMLGraphBackupWriter.writeStatementsStart(writer, ngURI.toString());
                ClosableIterator<SelectStatementsRevisionedResult> statements = Backup.selectStatementsRevisioned(statementProvider, connection, uuidId, id);
                while (statements.hasNext()) {
                    SelectStatementsRevisionedResult result = statements.next();
                    Resource subj = (Resource) nodeLayout.fetchValue(result.getSubject(), connection);
                    URI pred = (URI) nodeLayout.fetchValue(result.getPredicate(), connection);
                    Value obj = nodeLayout.fetchValue(result.getObject(), connection);
                    long end = result.getEnd();
                    XMLWritingUtils.handleStatement(writer, subj, pred, obj, ngURI, result.getStart(), (end > 0) ? end : null);

                }
                XMLGraphBackupWriter.writeStatementsEnd(writer);
                XMLGraphBackupWriter.writeStatementsStart(writer, metaURI.toString());
                ClosableIterator<SelectStatementsRevisionedResult> metaStatements = Backup.selectStatementsRevisioned(statementProvider, connection, uuidId, metaId);
                while (metaStatements.hasNext()) {
                    SelectStatementsRevisionedResult result = metaStatements.next();
                    Resource subj = (Resource) nodeLayout.fetchValue(result.getSubject(), connection);
                    URI pred = (URI) nodeLayout.fetchValue(result.getPredicate(), connection);
                    Value obj = nodeLayout.fetchValue(result.getObject(), connection);
                    long end = result.getEnd();
                    XMLWritingUtils.handleStatement(writer, subj, pred, obj, metaURI, result.getStart(), (end > 0) ? end : null);
                }
                XMLGraphBackupWriter.writeStatementsEnd(writer);
                XMLGraphBackupWriter.writeNamedGraphBackupEnd(writer);
                writer.flush();
            }
            XMLGraphBackupWriter.writeBackupsEnd(writer);
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            log.error(LogUtils.RDB_MARKER, "Error exporting graphs", ioe);
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
        }
    }

    /**
     * Reset the server from a set of backup data
     * 
     * @param fileName
     *            filename for backup data
     * @throws AnzoException
     */
    public void restoreData(String fileName) throws AnzoException {
        resetService.restoreData(fileName);
    }

    /**
     * Initialize a jdbc connection pool
     * 
     * @param type
     *            either rw or query pool
     * @param maxActive
     *            maximum number of connections in pool
     * @param configuration
     *            configuration properties used for creating database connections
     * @return connection pool
     * @throws AnzoException
     *             {@link ExceptionConstants#RDB.DRIVER_NAME} if there was a problem loading class for database driver
     */
    private GenericObjectPool initializeConnectionFactory(boolean write, int maxActive) throws AnzoException {
        // Will use in jndi
        // DataSource ds = (DataSource) ctx.lookup(RepositoryProperties.getDatabaseJndiName(properties));
        try {
            Class.forName(configuration.getDriverClassName());
        } catch (ClassNotFoundException e1) {
            throw new AnzoException(ExceptionConstants.RDB.DRIVER_NAME, e1, configuration.getDriverClassName());
        }
        Properties props = new Properties();
        props.put("user", configuration.getUser());
        props.put("password", configuration.getPassword());
        props.put("SetBigStringTryClob", "true");
        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(configuration.getJdbcUrl(), props);
        GenericObjectPool connectionPool = new GenericObjectPool();
        connectionPool.setMaxActive(maxActive);
        connectionPool.setMaxIdle(Math.max(1, maxActive / 2));
        connectionPool.setMinIdle(0);
        connectionPool.setMinEvictableIdleTimeMillis(1000 * 60 * 10);
        connectionPool.setTimeBetweenEvictionRunsMillis(1000 * 60 * 10);
        connectionPool.setWhenExhaustedAction(GenericObjectPool.WHEN_EXHAUSTED_BLOCK);
        connectionPool.setMaxWait(GenericKeyedObjectPool.DEFAULT_MAX_WAIT);
        connectionPool.setTestOnBorrow(true);
        GenericKeyedObjectPoolFactory statementPool = new GenericKeyedObjectPoolFactory(null, PS_CACHE_SIZE, GenericKeyedObjectPool.WHEN_EXHAUSTED_BLOCK, GenericKeyedObjectPool.DEFAULT_MAX_WAIT, PS_CACHE_SIZE, PS_CACHE_SIZE, GenericKeyedObjectPool.DEFAULT_TEST_ON_BORROW, GenericKeyedObjectPool.DEFAULT_TEST_ON_RETURN, GenericKeyedObjectPool.DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS, GenericKeyedObjectPool.DEFAULT_NUM_TESTS_PER_EVICTION_RUN, GenericKeyedObjectPool.DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS, GenericKeyedObjectPool.DEFAULT_TEST_WHILE_IDLE);
        PoolableConnectionFactory pcf = new PoolableConnectionFactory(connectionFactory, connectionPool, statementPool, configuration.getValidationQuery(), false, true) {
            @Override
            public synchronized Object makeObject() throws Exception {
                Connection connection = (Connection) super.makeObject();
                initializeConnection(connection);
                return connection;
            }
        };

        if (configuration.getSupportsIsolation() && write)
            pcf.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        else if (configuration.getSupportsIsolation() && !write)
            pcf.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        return connectionPool;
    }

    private long getCurrentVersion(Connection connection) throws AnzoException {
        Long currentVersion = ServerRdbWrapper.getServerVersion(getStatementProvider(), connection);
        if (currentVersion == null) {
            return -1;
        } else {
            return currentVersion;
        }
    }

    private void verifyVersion(Connection connection, long currentVersion) throws AnzoException {
        if (currentVersion < SCHEMA_VERSION) {
            for (long i = currentVersion; i < SCHEMA_VERSION; i++) {
                try {
                    String name = (i + "To" + (i + 1));
                    begin(connection, true, true);
                    log.info(LogUtils.RDB_MARKER, "Updating from db schema {} to {}", i, (i + 1));
                    if (getStatementProvider().getSqlString(name) != null) {
                        getStatementProvider().runSQLGroup(name, configuration.getInitParams(), connection);
                    }
                    if (i == 9) {
                        nineToTen(connection);
                    }
                    commit(connection, true, true);

                    String nameMore = (i + "To" + (i + 1) + "more");
                    if (getStatementProvider().getSqlString(nameMore) != null) {
                        getStatementProvider().runSQLGroupCommitIndividual(nameMore, configuration.getInitParams(), connection);
                    }
                    begin(connection, true, true);
                    ServerRdbWrapper.setServerVersion(getStatementProvider(), connection, i + 1);
                    commit(connection, true, true);
                    log.info(LogUtils.RDB_MARKER, "Updated from db schema {} to {}", i, (i + 1));
                } catch (SQLException sqle) {
                    log.info(LogUtils.RDB_MARKER, "Failed updating from db schema " + i + " to " + (i + 1), sqle);
                    abort(connection, true, true);
                }
            }
        }
    }

    private void nineToTen(Connection connection) throws AnzoException {
        Long id = nodeLayout.fetchId(NamedGraph.modifiedProperty, connection);
        if (id != null) {

            Backup.BatchReplaceStatement bps = new Backup.BatchReplaceStatement(connection, statementProvider);
            int needsDoing = 0;

            for (SelectFullStatementsResult result : Backup.selectFullStatements(statementProvider, connection, id)) {
                Value object = nodeLayout.fetchValue(result.getObject(), connection);
                if (object instanceof TypedLiteral) {
                    URI datatype = ((TypedLiteral) object).getDatatypeURI();
                    if (datatype.equals(XMLSchema.LONG)) {
                        Long lmt = (Long) ((TypedLiteral) object).getNativeValue();
                        XMLGregorianCalendar cal = TypeMaps.getXMLCaledar(lmt);
                        Literal newDateTime = Constants.valueFactory.createTypedLiteral(cal);
                        Long newOid = nodeLayout.store(newDateTime, connection, 0);
                        String oldStmtId = result.getId();
                        String newStmtId = MessageFormat.format(ID_STRING, Long.toString(result.getNamedGraphId()), Long.toString(result.getSubject()), id.toString(), Long.toString(newOid));
                        bps.addEntry(newStmtId, newOid, oldStmtId);
                        needsDoing++;
                    }
                }
            }
            if (needsDoing > 0) {
                log.info(LogUtils.RDB_MARKER, "Updated old modified long timestamps to dateTime timestamps:" + needsDoing);
                bps.executeStatement();
                bps.close();
            }
            Backup.BatchReplaceStatementNR bpns = new Backup.BatchReplaceStatementNR(connection, statementProvider);
            needsDoing = 0;
            for (SelectFullStatementsNRResult result : Backup.selectFullStatementsNR(statementProvider, connection, id)) {
                Value object = nodeLayout.fetchValue(result.getObject(), connection);
                if (object instanceof TypedLiteral) {
                    URI datatype = ((TypedLiteral) object).getDatatypeURI();
                    if (datatype.equals(XMLSchema.LONG)) {
                        Long lmt = (Long) ((TypedLiteral) object).getNativeValue();
                        XMLGregorianCalendar cal = TypeMaps.getXMLCaledar(lmt);
                        Literal newDateTime = Constants.valueFactory.createTypedLiteral(cal);
                        Long newOid = nodeLayout.store(newDateTime, connection, 0);
                        String oldStmtId = result.getId();
                        String newStmtId = MessageFormat.format(ID_STRING, Long.toString(result.getNamedGraphId()), Long.toString(result.getSubject()), id.toString(), Long.toString(newOid));
                        bpns.addEntry(newStmtId, newOid, oldStmtId);
                        needsDoing++;
                    }
                }
            }
            if (needsDoing > 0) {
                log.info(LogUtils.RDB_MARKER, "Updated old modified long timestamps to dateTime timestamps:" + needsDoing);
                bpns.executeStatement();
                bpns.close();
            }
        }
    }

    /**
     * Start the JDBC connection, initializing tables if they don't already exist
     * 
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_INITIALZE_TEMPTABLES} if there was a problem running the createTemporaryTables sql group
     */
    void initializeConnection(Connection connection) throws AnzoException {
        if (!initialized) {
            boolean inited = isInitialized(connection, INITIAL_DATABASE_TABLE);
            if (!inited) {
                NodeCentricOperationContext context = new NodeCentricOperationContext(INITIALIZE_CONNECTION, BaseOperationContext.generateOperationId(), null, connection, this);
                resetService.resetDatabase(context, true, (MultiMap<URI, Statement>) null);
                if (indexHandler != null) {
                    indexHandler.reset();
                }
            } else {
                long currentVersion = getCurrentVersion(connection);
                verifyVersion(connection, currentVersion);
            }
        }
        if (configuration.getForceTempCreation() || !hasTempTable(connection, "STMTS_TMP")) {
            try {
                begin(connection, false, true);
                statementProvider.runSQLGroup("createTemporaryTables", configuration.getInitParams(), connection);
                commit(connection, false, true);
            } catch (SQLException sqle) {
                abort(connection, false, true);
                if (!configuration.getForceTempCreation()) {
                    log.error(LogUtils.RDB_MARKER, "Error creating temporary tables", sqle);
                    throw new AnzoException(ExceptionConstants.RDB.FAILED_INITIALZE_TEMPTABLES, sqle);
                }
            }
        }
        if (!initialized) {
            begin(connection, true, true);
            for (Long transactionId : LastTransactionTime.selectUncommitedTransactions(statementProvider, connection, getInstanceId())) {
                log.error(LogUtils.RDB_MARKER, "Transaction [{}] uncommited from previous instance of server, cleaning it up now.", transactionId);
                nodeLayout.abortReferencedIds(connection, transactionId);
                NodeCentricServerQuadStore.abortTransaction(connection, statementProvider, configuration, true, transactionId, false);
                NodeCentricServerQuadStore.abortTransaction(connection, statementProvider, configuration, false, transactionId, false);
                NamedGraphRdbWrapper.purgelockedNamedGraph(statementProvider, connection, transactionId);
            }
            LastTransactionTime.purgeTransactions(statementProvider, connection, getInstanceId());
            //GlitterRdbWrapper.purgeQueryDatasets(statementProvider, connection, getInstanceId());
            long lastId = -1;
            GraphSet lastSet = null;
            for (SelectQueryDatasetsResult result : GlitterRdbWrapper.selectQueryDatasets(statementProvider, connection)) {
                long id = result.getDatasetId();
                long gid = result.getGraphId();
                if (lastId != id) {
                    if (lastSet != null) {
                        graphSets.put(lastSet, lastSet);
                    }
                    lastSet = new GraphSet(id);
                }
                lastId = id;
                URI graphUri = (URI) nodeLayout.fetchValue(gid, connection);
                if (lastSet != null) {
                    lastSet.add(graphUri);
                }
            }
            for (GraphSet gs : graphSets.keySet()) {
                gs.setRevisionedCount(GlitterRdbWrapper.countValidRevisionedGraphsInSet(statementProvider, connection, gs.getSetId()));
                gs.setNonRevisionedCount((gs.getRevisionedCount() == gs.size()) ? 0 : GlitterRdbWrapper.countValidNonRevisionedGraphsInSet(statementProvider, connection, gs.getSetId()));
            }
            initialized = true;
            commit(connection, true, true);
        }
    }

    /**
     * Determine if the database is initialized, or is it already being initialized by another connection. First check if a specified table exists. If it does,
     * check the initialized status.
     * 
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_WAITING_DB_INIT} if there was a problem waiting for the initialization status
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_GET_INIT_STATUS} if there was a problem querying for the initialization status
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_SETTING_ISOLATION} if there was a problem changing the transaction isolation level
     */
    private boolean isInitialized(Connection connection, String tablename) throws AnzoException {
        int isolation = Connection.TRANSACTION_REPEATABLE_READ;
        if (configuration.getSupportsIsolation()) {
            try {
                isolation = connection.getTransactionIsolation();
                connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            } catch (SQLException e) {
                log.error(LogUtils.RDB_MARKER, "Error setting tranaction isolation", e);
                throw new AnzoException(ExceptionConstants.RDB.FAILED_SETTING_ISOLATION, e);
            }
        }
        try {
            ResultSet rs = null;
            //Need to check all the tables, and not just the server table.  If we only check the server table, we could overwrite tables containing data.
            try {
                try {
                    rs = connection.getMetaData().getTables(null, null, configuration.getUsesUppercase() ? serverUpper : serverLower, new String[] { table });
                    if (!rs.next()) {
                        return !checkIfTablesExists(connection, true);
                    }
                    String tbl = rs.getString(3);
                    if (!tbl.equalsIgnoreCase(serverUpper)) {
                        return !checkIfTablesExists(connection, true);
                    }
                } finally {
                    if (rs != null) {
                        rs.close();
                    }
                }
            } catch (SQLException e) {
                log.error(LogUtils.RDB_MARKER, "error checking tables", e);
                throw new AnzoException(ExceptionConstants.RDB.FAILED_GETTING_TABLE_STATUS, e, serverUpper);
            }
            try {
                long initialized = 2;
                int retries = 0;
                //While the server is initializing in another connection, wait. Wait a total of 20 seconds, and then fail.
                while (initialized > 1) {
                    if (retries++ < 30) {
                        Long init = ServerRdbWrapper.getInitialized(statementProvider, connection);
                        if (init == null) {
                            return true;
                        }
                        initialized = init.longValue();
                        if (initialized > 1) {
                            if ((System.currentTimeMillis() - initialized) > 60000) {
                                log.error(LogUtils.RDB_MARKER, "A previous connections was intializing the database, but its been over a minute, so assume a fauilure");
                                ServerRdbWrapper.setInitializingFailed(statementProvider, connection);
                                return false;
                            }
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ie) {
                            }
                        }
                    } else {
                        throw new AnzoException(ExceptionConstants.RDB.FAILED_WAITING_DB_INIT);
                    }
                }
                checkIfTablesExists(connection, false);
                return true;
            } catch (RdbException e) {
                log.error(LogUtils.RDB_MARKER, "Error checking initialization state", e);
                throw new AnzoException(ExceptionConstants.RDB.FAILED_GET_INIT_STATUS, e);
            }
        } finally {
            try {
                if (configuration.getSupportsIsolation()) {
                    connection.setTransactionIsolation(isolation);
                }
            } catch (SQLException e) {
                log.error(LogUtils.RDB_MARKER, "Error setting transaction isolation level", e);
                throw new AnzoException(ExceptionConstants.RDB.FAILED_SETTING_ISOLATION, e);
            }
        }
    }

    private boolean checkIfTablesExists(Connection connection, boolean none) throws AnzoException {
        ResultSet rs = null;
        try {
            long currentVersion = none ? SCHEMA_VERSION : getCurrentVersion(connection);

            boolean tables = true;
            boolean sequences = false;
            boolean views = false;
            try {
                rs = connection.getMetaData().getTableTypes();
                while (rs.next() && (!tables || !sequences || !views)) {
                    String type = rs.getString(1);
                    if (type.toUpperCase().equals(table)) {
                        tables = true;
                    } else if (type.toUpperCase().equals(seq)) {
                        sequences = true;
                    } else if (type.toUpperCase().equals(view)) {
                        views = true;
                    }
                }
            } finally {
                if (rs != null) {
                    rs.close();
                }
            }
            if (tables) {
                try {
                    rs = connection.getMetaData().getTables(null, null, null, new String[] { table });

                    HashSet<String> requiredTables = new HashSet<String>();
                    requiredTables.add(serverUpper);
                    java.util.Collections.addAll(requiredTables, resetService.getRequiredTables());
                    java.util.Collections.addAll(requiredTables, resetService.getNodeCentricTables());
                    while (rs.next()) {
                        String tbl = rs.getString(3);
                        if (requiredTables.remove(tbl.toUpperCase()) && none) {
                            throw new AnzoException(ExceptionConstants.RDB.INCOMPLETE_DATABASE);
                        }
                        if (tbl.toUpperCase().equals("ANZO_U")) {
                            ResultSet metadata = connection.getMetaData().getColumns(null, null, tbl, null);
                            while (metadata.next()) {
                                String name = metadata.getString(4);
                                if (name.toUpperCase().equals("VALUE")) {
                                    int size = metadata.getInt(7);
                                    configuration.setMaxLongObjectLength(size);
                                    nodeLayout.setMaxLength(size);
                                    break;
                                }
                            }
                        }
                    }
                    if (!none && requiredTables.size() > 0) {
                        throw new AnzoException(ExceptionConstants.RDB.FAILED_GETTING_TABLE_STATUS, Arrays.toString(requiredTables.toArray()));
                    }
                } finally {
                    if (rs != null) {
                        rs.close();
                    }
                }
            }
            if (sequences) {
                String seqs[][] = resetService.getRequiredSequences();
                for (int i = 0; i < currentVersion; i++) {
                    String vseq[] = seqs[i];
                    if (vseq != null && vseq.length > 0) {
                        try {
                            rs = connection.getMetaData().getTables(null, null, null, new String[] { seq });
                            HashSet<String> requiredSeq = new HashSet<String>();
                            java.util.Collections.addAll(requiredSeq, vseq);
                            while (rs.next()) {
                                String tbl = rs.getString(3);
                                if (requiredSeq.remove(tbl.toUpperCase()) && none) {
                                    throw new AnzoException(ExceptionConstants.RDB.INCOMPLETE_DATABASE);
                                }
                            }
                            if (!none && requiredSeq.size() > 0) {
                                throw new AnzoException(ExceptionConstants.RDB.FAILED_GETTING_TABLE_STATUS, Arrays.toString(requiredSeq.toArray()));
                            }
                        } finally {
                            if (rs != null) {
                                rs.close();
                            }
                        }
                    }
                }
            }
            if (views) {
                try {
                    rs = connection.getMetaData().getTables(null, null, null, new String[] { view });

                    HashSet<String> required = new HashSet<String>();
                    if (currentVersion < 12) {
                        required.add("ALL_STMTS_VIEW");
                    } else {
                        java.util.Collections.addAll(required, resetService.getRequiredViews());
                    }
                    while (rs.next()) {
                        String tbl = rs.getString(3);
                        if (required.remove(tbl.toUpperCase()) && none) {
                            throw new AnzoException(ExceptionConstants.RDB.INCOMPLETE_DATABASE);
                        }
                    }
                    if (!none && required.size() > 0) {
                        throw new AnzoException(ExceptionConstants.RDB.FAILED_GETTING_TABLE_STATUS, Arrays.toString(required.toArray()));
                    }
                } finally {
                    if (rs != null) {
                        rs.close();
                    }
                }
            }
        } catch (SQLException e) {
            log.error(LogUtils.RDB_MARKER, "Error checking if statements exist", e);
            throw new AnzoException(ExceptionConstants.RDB.FAILED_INITIALZE_DB, e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    log.debug(LogUtils.RDB_MARKER, "Error closing result set", e);

                }
            }
        }
        return true;
    }

    /**
     * Determine if the temptable with the given name is available
     * 
     * @param connection
     *            connection to the underlying database
     * @param tablename
     *            name of temporary table to lookup
     * @return true if temporary table exists
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_GETTING_TABLE_STATUS} if there was a problem querying for information about the temp table
     * 
     */
    private boolean hasTempTable(Connection connection, String tablename) throws AnzoException {
        try {
            ResultSet rs = null;
            try {
                rs = connection.getMetaData().getTables(null, null, configuration.getSessionPrefix() + (configuration.getUsesUppercase() ? tablename.toUpperCase() : tablename.toLowerCase()), null);
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
            log.error(LogUtils.RDB_MARKER, "Error checking for temporat table status", e);
            throw new AnzoException(ExceptionConstants.RDB.FAILED_GETTING_TABLE_STATUS, e, tablename);
        }
    }

    /**
     * Get a {@link Connection} from the write pool
     * 
     * @return {@link Connection} from the write pool
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_GETTING_CONNECTION} if there was a problem getting a connection from the write pool
     * 
     */
    private Connection getWriteConnection() throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
            stats.getGetWriteConnectionUse().increment();
        }
        try {
            return (Connection) writePool.borrowObject();
        } catch (AnzoException ae) {
            throw ae;
        } catch (Exception exception) {
            throw new AnzoException(ExceptionConstants.RDB.FAILED_GETTING_CONNECTION, exception);
        } finally {
            if (stats.isEnabled()) {
                stats.getGetWriteConnectionDuration().addTime((System.currentTimeMillis() - start));
            }
        }
    }

    // private Hashtable<Connection, Thread> connectionThreads = new Hashtable<Connection, Thread>();

    /**
     * Get a {@link Connection} from the query pool
     * 
     * @return {@link Connection} from the query pool
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_GETTING_CONNECTION} if there was a problem getting a connection from the query pool
     * 
     */
    private Connection getQueryConnection() throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
            stats.getGetQueryConnectionUse().increment();
        }
        try {

            Connection connection = (Connection) queryPool.borrowObject();

            return connection;
        } catch (AnzoException ae) {
            throw ae;
        } catch (Exception exception) {
            throw new AnzoException(ExceptionConstants.RDB.FAILED_GETTING_CONNECTION, exception);
        } finally {
            if (stats.isEnabled()) {
                stats.getGetQueryConnectionDuration().addTime((System.currentTimeMillis() - start));
            }
        }
    }

    /**
     * Return a {@link Connection} to the write pool
     * 
     * @param connection
     *            {@link Connection} to return
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_GETTING_CONNECTION} if there was a problem returning a connection to the write pool
     * 
     */
    private void returnWriteConnection(Connection connection) throws AnzoException {
        try {
            if (!connection.isClosed()) {
                if (!connection.getAutoCommit()) {
                    abort(connection, false, true);
                }
                writePool.returnObject(connection);
            } else {
                writePool.invalidateObject(connection);
            }

        } catch (AnzoException ae) {
            throw ae;
        } catch (Exception exception) {
            throw new AnzoException(ExceptionConstants.RDB.FAILED_RETURNING_CONNECTION, exception);
        }
    }

    /**
     * Return a {@link Connection} to the query pool
     * 
     * @param connection
     *            {@link Connection} to return
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_GETTING_CONNECTION} if there was a problem returning a connection to the query pool
     * 
     */
    private void returnQueryConnection(Connection connection) throws AnzoException {
        try {
            if (!connection.isClosed()) {
                queryPool.returnObject(connection);
            } else {
                queryPool.invalidateObject(connection);
            }
        } catch (AnzoException ae) {
            throw ae;
        } catch (Exception exception) {
            throw new AnzoException(ExceptionConstants.RDB.FAILED_RETURNING_CONNECTION, exception);
        }
    }

    /**
     * Wrap the underlying IOperationContext with a NodeCentricOperationContext, that contains a connection from the query pool
     * 
     * @param context
     *            underlying context for the operation
     * @return a NodeCentricOperationContext, that contains a connection from the query pool
     * @throws AnzoException
     */
    public NodeCentricOperationContext getQueryContext(IOperationContext context) throws AnzoException {
        return new NodeCentricOperationContext(context, getQueryConnection(), this);
    }

    /**
     * Wrap the underlying IOperationContext with a NodeCentricOperationContext, that contains a connection from the write pool
     * 
     * @param context
     *            underlying context for the operation
     * @return a NodeCentricOperationContext, that contains a connection from the write pool
     * @throws AnzoException
     */
    public NodeCentricOperationContext getWriteContext(IOperationContext context) throws AnzoException {
        return new NodeCentricOperationContext(context, getWriteConnection(), this);
    }

    /**
     * Return the connection within this context to the query pool, and return the wrapped context
     * 
     * @param context
     *            context containing a query connection
     * @return the wrapped context
     * @throws AnzoException
     */
    public IOperationContext returnQueryContext(NodeCentricOperationContext context) throws AnzoException {
        returnQueryConnection(context.getConnection());
        context.setConnection(null);
        return context.getRootContext();
    }

    /**
     * Return the connection within this context to the write pool, and return the wrapped context
     * 
     * @param context
     *            context containing a query connection
     * @return the wrapped context
     * @throws AnzoException
     */
    public IOperationContext returnWriteContext(NodeCentricOperationContext context) throws AnzoException {
        if (context.getConnection() != null) {
            returnWriteConnection(context.getConnection());
            context.setConnection(null);
        }
        return context.getRootContext();
    }

    public void rebindWriteContext(NodeCentricOperationContext context) throws AnzoException {
        if (context.getConnection() != null) {
            returnWriteConnection(context.getConnection());
        }
        context.setConnection(getWriteConnection());
    }

    public void rebindQueryContext(NodeCentricOperationContext context) throws AnzoException {
        if (context.getConnection() != null) {
            returnQueryConnection(context.getConnection());
        }
        context.setConnection(getQueryConnection());
    }

    /**
     * Get the RepositoryConnectionConfiguration object for the back-end
     * 
     * @return the RepositoryConnectionConfiguration object for the back-end
     */
    public CoreDBConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Lock the the database SERVER table
     * 
     * @param connection
     *            {@link Connection} to underlying database
     * @param needsWrite
     *            this connection is going write to the database
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_LOCK_TABLES} if there was a problem locking the database table
     * 
     */
    private void lockTable(Connection connection, boolean needsWrite) throws AnzoException {
        if (configuration.getSupportsTableLocks() && needsWrite) {
            try {
                ServerRdbWrapper.lockTable(statementProvider, connection, serverUpper, getConfiguration().getTableLocksExtras());
            } catch (RdbException e) {
                throw new AnzoException(ExceptionConstants.RDB.FAILED_LOCK_TABLES, e, serverUpper);
            }
        } else if (needsWrite) {
            serverLock.lock();
        }
    }

    /**
     * Unlock the the database SERVER table
     * 
     * @param connection
     *            {@link Connection} to underlying database
     * @param needsWrite
     *            this connection is going write from the database
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_UNLOCK_TABLES} if there was a problem unlocking the database table
     * 
     */
    private void unlockTable(Connection connection, boolean needsWrite) throws AnzoException {
        if (configuration.getSupportsTableUnLocks() && needsWrite) {
            try {
                ServerRdbWrapper.unlockTable(statementProvider, connection, serverUpper);
            } catch (RdbException e) {
                throw new AnzoException(ExceptionConstants.RDB.FAILED_UNLOCK_TABLES, e, serverUpper);
            }
        } else if (!configuration.getSupportsTableLocks() && needsWrite) {
            serverLock.unlock();
        }
    }

    /**
     * Determine if this connection is within a transaction
     * 
     * @param connection
     *            connection of which to determine transaction status
     * @return true if connection is within transaction
     */
    public boolean isInTransaction(Connection connection) {
        ReentrantLock lock = connectionLocks.get(connection);
        if (lock != null) {
            return lock.isLocked();
        }
        return false;
    }

    /**
     * Begin database transaction
     * 
     * Note:Database already in transaction
     * 
     * @param connection
     *            {@link Connection} to underlying database
     * @param needsWrite
     *            if true, tables will be locked if needed
     * @param needsTransaction
     *            TODO
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#ALREADY_IN_RDB_TRANSACTION} if this connection is already with a transaction
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_START_RDB_TRANSACTION} if there was a problem setting autoCommit to false
     */
    public void begin(Connection connection, boolean needsWrite, boolean needsTransaction) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
            stats.getBeginUse().increment();
        }
        try {
            ReentrantLock lock = connectionLocks.get(connection);
            if (lock == null) {
                lock = new ReentrantLock();
                connectionLocks.put(connection, lock);
            }
            if (lock.isLocked()) {
                throw new AnzoException(ExceptionConstants.RDB.ALREADY_IN_RDB_TRANSACTION);
            }
            lock.lock();
            if (lock.getHoldCount() == 1 && needsTransaction) {
                try {
                    connection.setAutoCommit(false);
                } catch (SQLException e) {
                    lock.unlock();
                    log.error(LogUtils.RDB_MARKER, "Error starting jdbc transaction", e);
                    throw new AnzoRuntimeException(ExceptionConstants.RDB.FAILED_START_RDB_TRANSACTION, e);
                }
                try {
                    lockTable(connection, needsWrite);
                } catch (AnzoException e) {
                    try {
                        connection.setAutoCommit(false);
                    } catch (SQLException sqle) {
                        log.error(LogUtils.RDB_MARKER, "Error aborting jdbc transaction", sqle);
                    }
                    lock.unlock();
                    throw e;
                }

            }
        } finally {
            if (stats.isEnabled()) {
                stats.getBeginDuration().addTime((System.currentTimeMillis() - start));
            }
        }
    }

    /**
     * Abort database transaction
     * 
     * Note:Database already in transaction
     * 
     * @param connection
     *            {@link Connection} to underlying database
     * @param needsWrite
     *            if true, tables will be locked if needed
     * @param needsTransaction
     *            TODO
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#DIDNT_START_RDB_TRANSACTION} if this thread didn't start the transaction
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_ROLLBACK_RDB_TRANSACTION} if there was a problem rolling back the connection
     */
    protected void abort(Connection connection, boolean needsWrite, boolean needsTransaction) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
            stats.getAbortUse().increment();
        }
        try {
            ReentrantLock lock = connectionLocks.get(connection);
            if (lock == null) {
                lock = new ReentrantLock();
                connectionLocks.put(connection, lock);
            }
            if (lock.isLocked()) {
                if (lock.isHeldByCurrentThread()) {
                    try {
                        if (needsTransaction) {
                            ArrayList<AnzoException> exceptions = null;
                            try {
                                if (!connection.isClosed()) {
                                    try {
                                        connection.rollback();
                                        connection.setAutoCommit(true);
                                    } catch (SQLException e) {
                                        log.error(LogUtils.RDB_MARKER, "Error rolling back transaction", e);
                                        exceptions = new ArrayList<AnzoException>();
                                        exceptions.add(new AnzoException(ExceptionConstants.RDB.FAILED_ROLLBACK_RDB_TRANSACTION, e));
                                    }
                                    try {
                                        unlockTable(connection, needsWrite);
                                    } catch (AnzoException ae) {
                                        log.error(LogUtils.RDB_MARKER, "Error unlocking table", ae);
                                        if (exceptions == null) {
                                            exceptions = new ArrayList<AnzoException>();
                                        }
                                        exceptions.add(ae);
                                    }
                                }
                            } catch (SQLException e) {
                                log.error(LogUtils.RDB_MARKER, "Error rollingback jdbc transaction", e);
                                exceptions = new ArrayList<AnzoException>();
                                exceptions.add(new AnzoException(ExceptionConstants.RDB.FAILED_ROLLBACK_RDB_TRANSACTION, e));
                            }

                            if (exceptions != null && exceptions.size() > 0) {
                                throw new CompoundAnzoException(exceptions, ExceptionConstants.RDB.FAILED_ROLLBACK_RDB_TRANSACTION);
                            }
                        }
                    } finally {
                        lock.unlock();
                        nodeLayout.clearUncommittedCache();
                    }
                } else {
                    throw new AnzoException(ExceptionConstants.RDB.DIDNT_START_RDB_TRANSACTION);
                }
            }
        } finally {
            if (stats.isEnabled()) {
                stats.getAbortDuration().addTime((System.currentTimeMillis() - start));
            }
        }
    }

    /**
     * Commit database transaction
     * 
     * Note:Database already in transaction
     * 
     * @param connection
     *            {@link Connection} to underlying database
     * @param needsWrite
     *            if true, tables will be locked if needed
     * @param needsTransaction
     *            TODO
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#NOT_IN_RDB_TRANSACTION} if connection isn't in a transaction
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#DIDNT_START_RDB_TRANSACTION} if this thread didn't start the transaction
     * @throws AnzoException
     *             {@link ExceptionConstants.RDB#FAILED_COMMIT_RDB_TRANSACTION} if there was a problem committing the connection
     */
    public void commit(Connection connection, boolean needsWrite, boolean needsTransaction) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
            stats.getCommitUse().increment();
        }
        try {
            ReentrantLock lock = connectionLocks.get(connection);
            if (lock == null) {
                lock = new ReentrantLock();
                connectionLocks.put(connection, lock);
            }
            if (lock.isLocked()) {
                if (lock.isHeldByCurrentThread()) {
                    try {
                        if (needsTransaction) {
                            ArrayList<AnzoException> exceptions = null;
                            try {
                                connection.commit();
                                connection.setAutoCommit(true);
                            } catch (SQLException e) {
                                log.error(LogUtils.RDB_MARKER, "Error commmiting jdbc transaction", e);
                                exceptions = new ArrayList<AnzoException>();
                                exceptions.add(new AnzoException(ExceptionConstants.RDB.FAILED_COMMIT_RDB_TRANSACTION, e));
                            }
                            try {
                                unlockTable(connection, needsWrite);
                            } catch (AnzoException ae) {
                                log.error(LogUtils.RDB_MARKER, "Error unlocking tables", ae);
                                if (exceptions == null) {
                                    exceptions = new ArrayList<AnzoException>();
                                }
                                exceptions.add(ae);
                            }
                            if (exceptions != null && exceptions.size() > 0) {
                                throw new CompoundAnzoException(exceptions, ExceptionConstants.RDB.FAILED_COMMIT_RDB_TRANSACTION);
                            }
                        }
                    } finally {
                        lock.unlock();
                        nodeLayout.clearUncommittedCache();
                    }
                } else {
                    throw new AnzoException(ExceptionConstants.RDB.DIDNT_START_RDB_TRANSACTION);
                }
            } else {
                throw new AnzoException(ExceptionConstants.RDB.NOT_IN_RDB_TRANSACTION);
            }
        } finally {
            if (stats.isEnabled()) {
                stats.getCommitDuration().addTime((System.currentTimeMillis() - start));
            }
        }
    }

    /**
     * Get the shared PreparedStatementProvider for the back-end
     * 
     * @return the shared PreparedStatementProvider for the back-end
     */
    public PreparedStatementProvider getStatementProvider() {
        return statementProvider;
    }

    /**
     * Get the shared CompositeNodeLayout for the back-end
     * 
     * @return the shared CompositeNodeLayout for the back-end
     */
    public CompositeNodeLayout getNodeLayout() {
        return nodeLayout;
    }

    /**
     * Get the IndexService for the back-end
     * 
     * @return the IndexService for the back-end
     */
    public NodeCentricIndexService getIndexService() {
        return indexService;
    }

    /**
     * Determine if the given named graph is stored, and if so, what type of storage
     * 
     * @param context
     *            Connection context for this operation
     * @param namedGraphUri
     *            URI of namedGraph to lookup
     * @return NamedGraphType for the given namedGraph if it is stored within this backend
     * @throws AnzoException
     */
    protected NamedGraphType containsNamedGraph(NodeCentricOperationContext context, URI namedGraphUri, boolean metadata) throws AnzoException {
        Long ngId = context.getNodeLayout().fetchId(namedGraphUri, context.getConnection());
        if (ngId == null) {
            return null;
        }
        Long result = metadata ? NamedGraphRdbWrapper.containsMetadataGraphRevisioned(context.getStatementProvider(), context.getConnection(), ngId) : NamedGraphRdbWrapper.containsNamedGraphRevisioned(context.getStatementProvider(), context.getConnection(), ngId);
        if (result != null) {
            return NamedGraphType.REVISIONED;
        }
        result = metadata ? NamedGraphRdbWrapper.containsMetadataGraphNonRevisioned(context.getStatementProvider(), context.getConnection(), ngId) : NamedGraphRdbWrapper.containsNamedGraphNonRevisioned(context.getStatementProvider(), context.getConnection(), ngId);
        if (result != null) {
            return NamedGraphType.NON_REVISIONED_PERSISTED;
        }
        return null;

    }

    /**
     * @return the initParams
     */
    public String[] getInitParams() {
        return configuration.getInitParams();
    }

    /**
     * Runstats on the underlying database
     * 
     * @throws AnzoException
     */
    public void runstats() throws AnzoException {
        Connection connection = getWriteConnection();
        try {
            String[][] tableSets = { NodeCentricResetService.liveTables, resetService.getNodeCentricTables() };
            for (String[] tables : tableSets) {
                for (String table : tables) {
                    try {
                        ServerRdbWrapper.stats(statementProvider, connection, table);
                    } catch (RdbException sqle) {
                        log.error(LogUtils.RDB_MARKER, "SQL Error deleting from table", sqle);
                    }
                }
            }
        } finally {
            returnWriteConnection(connection);
        }
    }

    @Override
    public ReentrantReadWriteLock getLockProvider() {
        return resetLock;
    }

    /**
     * @param datasourceInstanceURI
     *            the datasourceInstanceURI to set
     */
    public void setDatasourceInstanceURI(URI datasourceInstanceURI) {
    }

    /**
     * @return the dictionary
     */
    public Dictionary<? extends Object, ? extends Object> getConfigurationParameters() {
        return configProperties;
    }

    /**
     * @return the aclEventListeners
     */
    public Set<IAuthorizationEventListener> getAclEventListeners() {
        return aclEventListeners;
    }

    /**
     * @return the graphSets
     */
    public ICache<GraphSet, GraphSet> getGraphSets() {
        return graphSets;
    }

    /**
     * @return the eventAdmin
     */
    public EventAdmin getEventAdmin() {
        return eventAdmin;
    }

    private static final String ID_STRING = "{0}:{1}:{2}:{3}";

    /**
     * Import backup/migration data into datasource, without doing a reset
     * 
     * @param replace
     *            If true, replace a graph if it already exists, otherwise ignore data from backup
     * @param fileName
     *            Filename containing backup data
     * @throws AnzoException
     */
    public void importBackupData(final boolean replace, String fileName) throws AnzoException {
        final NodeCentricOperationContext connectionContext = getWriteContext(new BaseOperationContext("MIGRATE", BaseOperationContext.generateOperationId(), new AnzoPrincipal("sysadmin", null, null, true, false)));
        try {
            lockTable(connectionContext.getConnection(), true);

            try {
                Reader fileReader = ReadWriteUtils.createSmartFileReader(fileName);
                XMLBackupReader reader = new XMLBackupReader(fileReader);
                try {
                    reader.read(new IBackupHandler() {
                        URI  ngURI;

                        URI  mdURI;

                        Long graphId;

                        Long metaId;

                        Long uuidId;

                        Long graphsDatasetId;

                        Long metadataDatasetId;

                        Long namedGraphPropertyId;

                        Long graphsUUID;

                        Long metadataUUID;

                        long timestamp = 0;

                        public void start() throws AnzoException {
                            begin(connectionContext.getConnection(), true, true);
                            getIndexHandler().indexer.preIndex();
                            graphsDatasetId = nodeLayout.store(GRAPHS.GRAPHS_DATASET, connectionContext.getConnection(), 1);
                            metadataDatasetId = nodeLayout.store(GRAPHS.METADATA_GRAPHS_DATASET, connectionContext.getConnection(), 1);
                            namedGraphPropertyId = nodeLayout.store(Dataset.namedGraphProperty, connectionContext.getConnection(), 1);
                            graphsUUID = nodeLayout.fetchId(getModelService().getUUIDforUri(connectionContext, GRAPHS.GRAPHS_DATASET), connectionContext.getConnection());
                            metadataUUID = nodeLayout.fetchId(getModelService().getUUIDforUri(connectionContext, GRAPHS.METADATA_GRAPHS_DATASET), connectionContext.getConnection());
                        }

                        public void handleStatement(boolean metadata, boolean revisioned, Statement statement, Long start, Long end) throws AnzoException {
                            Long s = nodeLayout.store(statement.getSubject(), connectionContext.getConnection(), 1);
                            Long p = nodeLayout.store(statement.getPredicate(), connectionContext.getConnection(), 1);
                            Long o = nodeLayout.store(statement.getObject(), connectionContext.getConnection(), 1);
                            String stmtId = MessageFormat.format(ID_STRING, (metadata) ? metaId.toString() : graphId.toString(), s.toString(), p.toString(), o.toString());
                            if (revisioned) {
                                Backup.restoreStatement(statementProvider, connectionContext.getConnection(), stmtId, metadata ? 1 : 0, uuidId, metadata ? metaId : graphId, s, p, o, start, end);
                            } else {
                                Backup.restoreStatementNR(statementProvider, connectionContext.getConnection(), stmtId, metadata ? 1 : 0, metadata ? metaId : graphId, s, p, o);
                            }
                            if ((end == null || end.longValue() > 0) && statement.getObject() instanceof Literal) {
                                StatementWrapper sw = new StatementWrapper(metadata ? mdURI : ngURI, metadata ? metaId : graphId, statement.getSubject(), s, statement.getPredicate(), p, statement.getObject(), o, timestamp);
                                getIndexHandler().indexer.index(sw);
                            }
                        }

                        public boolean handleNamedGraph(boolean revisioned, URI namedGraphUri, URI metadataURI, URI uuid, Collection<BackupRevision> revisions) throws AnzoException {
                            NamedGraphType type = containsNamedGraph(connectionContext, namedGraphUri, false);
                            if (type == null || replace) {
                                ngURI = namedGraphUri;
                                mdURI = metadataURI;
                                graphId = nodeLayout.store(namedGraphUri, connectionContext.getConnection(), 1);
                                metaId = nodeLayout.store(metadataURI, connectionContext.getConnection(), 1);
                                uuidId = nodeLayout.store(uuid, connectionContext.getConnection(), 1);
                                if (type != null) {
                                    if (revisioned) {
                                        Backup.purgeNamedGraphRevisioned(statementProvider, connectionContext.getConnection(), graphId);
                                        Backup.purgeNamedGraphStatementsRevisioned(statementProvider, connectionContext.getConnection(), graphId, metaId);
                                    } else {
                                        Backup.purgeNamedGraphNonRevisioned(statementProvider, connectionContext.getConnection(), graphId);
                                        Backup.purgeNamedGraphStatementsNonRevisioned(statementProvider, connectionContext.getConnection(), graphId, metaId);
                                    }
                                    getIndexHandler().indexer.purgeNamedGraph(graphId);
                                    getIndexHandler().indexer.purgeNamedGraph(metaId);
                                }
                                for (BackupRevision backup : revisions) {
                                    Long lastMod = nodeLayout.store(backup.lastModifiedBy, connectionContext.getConnection(), 1);
                                    if (revisioned) {
                                        Backup.restoreNamedGraph(statementProvider, connectionContext.getConnection(), backup.start, backup.end, graphId, metaId, uuidId, backup.revision, lastMod);
                                    } else {
                                        Backup.restoreNamedGraphNR(statementProvider, connectionContext.getConnection(), backup.start, graphId, metaId, uuidId, backup.revision, lastMod);
                                    }
                                    if (backup.start != null && (backup.end == null || backup.end.longValue() == 0)) {
                                        timestamp = backup.start;
                                    }
                                }
                                if (type == null) {
                                    if (!namedGraphUri.equals(GRAPHS.GRAPHS_DATASET) && !namedGraphUri.equals(GRAPHS.METADATA_GRAPHS_DATASET)) {
                                        String stmtId = MessageFormat.format(ID_STRING, graphsDatasetId, graphsDatasetId, namedGraphPropertyId, graphId);
                                        Backup.restoreStatement(statementProvider, connectionContext.getConnection(), stmtId, 0, graphsUUID, graphsDatasetId, graphsDatasetId, namedGraphPropertyId, graphId, 0, null);
                                        stmtId = MessageFormat.format(ID_STRING, metadataDatasetId, metadataDatasetId, namedGraphPropertyId, metaId);
                                        Backup.restoreStatement(statementProvider, connectionContext.getConnection(), stmtId, 0, metadataUUID, metadataDatasetId, metadataDatasetId, namedGraphPropertyId, metaId, 0, null);
                                    }
                                }
                                return true;
                            } else {
                                return false;
                            }
                        }

                        public void end() throws AnzoException {
                            commit(connectionContext.getConnection(), true, true);
                            nodeLayout.commitReferencedIds(connectionContext.getConnection(), 1);
                            getIndexHandler().indexer.postIndex();
                        }
                    });
                } catch (AnzoException ae) {
                    abort(connectionContext.getConnection(), true, true);
                } finally {
                    if (fileReader != null) {
                        fileReader.close();
                    }
                }

            } catch (Exception e) {
                log.error(LogUtils.RDB_MARKER, "Error importing backup data", e);
            }

        } finally {
            unlockTable(connectionContext.getConnection(), true);
            returnWriteContext(connectionContext);
        }
    }

    /**
     * @return the indexHandler
     */
    protected NodeCentricIndexUpdateHandler getIndexHandler() {
        return indexHandler;
    }

    /**
     * @return the instanceId
     */
    public String getInstanceId() {
        return instanceId;
    }

    @Override
    public void executeCommand(String command, IDataset request, IDataset response) throws AnzoException {
        if (command.equals("runstats")) {
            runstats();
        } else {
            super.executeCommand(command, request, response);
        }
    }

    /**
     * Get the capabilities of the datasource
     */
    @Override
    public INamedGraph getCapabilities() {
        INamedGraph graph = super.getCapabilities();
        URI uri = getInstanceURI();
        Datasource datasource = SystemFactory.getDatasource(uri, graph);
        datasource.addDatasourceCapability(DatasourceCapability.DatasourceRead);
        datasource.addDatasourceCapability(DatasourceCapability.DatasourceQuery);
        datasource.addDatasourceCapability(DatasourceCapability.DatasourceUpdate);
        datasource.addDatasourceCapability(DatasourceCapability.DatasourceEvents);
        return graph;
    }
}
