/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import javax.jms.JMSException;

import org.openanzo.client.GraphTable.Type;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IModelService;
import org.openanzo.datasource.IUpdateService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.CompoundAnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.rdf.AnzoGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.OPTIONS;
import org.openanzo.rdf.utils.IStatementsHandler;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.INotificationConnectionListener;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.IUpdatesProvider;
import org.openanzo.services.Privilege;
import org.openanzo.services.UpdateServerException;
import org.openanzo.services.impl.BaseOperationContext;
import org.openanzo.services.impl.Precondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * The AnzoClient provides remote access to an Anzo server.
 * 
 * This is the central management point for a single connection to an Anzo server. The AnzoClient provides the methods to get replica and server graphs. The
 * graphs are bound to the AnzoClient that creates them, and all graph created with a single AnzoClient share a common TransactionQueue, NotificationService and
 * persistence provider.
 * 
 * For more details see: http://www.openanzo.org/projects/openanzo/wiki/AnzoJavaProgrammingModel
 * 
 * @author Joe Betz
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 */
public class AnzoClient {
    private static final Logger                          log                        = LoggerFactory.getLogger(AnzoClient.class);

    /** INamedGraphInitializer for creating Revisioned NamedGraphs */
    public static final INamedGraphInitializer           REVISIONED_NAMED_GRAPH     = new RevisionedNamedGraphInitializer(true);

    /** INamedGraphInitializer for creating NonRevisioned NamedGraphs */
    public static final INamedGraphInitializer           NON_REVISIONED_NAMED_GRAPH = new RevisionedNamedGraphInitializer(false);

    /** INamedGraphInitializer that adds precondition that the NamedGraph must already exist on the server */
    public static final INamedGraphInitializer           GRAPH_MUST_EXIST           = new GraphExistenceInitializer(true);

    /** INamedGraphInitializer that adds precondition that the NamedGraph must not already exist on the server */
    public static final INamedGraphInitializer           GRAPH_MUST_NOT_EXIST       = new GraphExistenceInitializer(false);

    private static final INamedGraphInitializer          STATEMENT_STREAM           = new StatementStreamInitializer();

    protected final AnzoClientDatasource                 clientDatasource;

    protected final INotificationConnectionListener      reconnectionListener;

    protected final GraphTable                           replicaGraphTable;

    protected final GraphTable                           serverGraphTable;

    protected final TransactionProxy                     replicaGraphTransactionProxy;

    protected final TransactionProxy                     serverGraphTransactionProxy;

    protected final TransactionQueue                     transactionQueue;

    protected final Replicator                           replicator;

    protected final ReplicaUpdater                       replicaUpdater;

    protected final ReplicaUpdater                       namedGraphUpdater;

    protected final IQuadStore                           quadStore;

    protected final IQuadStoreComponent                  quadStoreComponent;

    protected final IQuadStore                           serverQuadStore;

    protected final RealtimeUpdateManager                realtimeUpdates;

    final NamedGraphUpdateManager                        namedGraphUpdateManager;

    final ReentrantLock                                  clientLock                 = new ReentrantLock();

    private final HashSet<IAnzoClientConnectionListener> connectionListeners        = new HashSet<IAnzoClientConnectionListener>();

    private final HashSet<ITransactionListener>          transactionListeners       = new HashSet<ITransactionListener>();

    private boolean                                      closed                     = false;

    private boolean                                      connected                  = false;

    private boolean                                      updateRepositoryOnCommit   = false;

    protected boolean                                    jmsEnabled                 = true;

    private final ArrayList<INamedGraphInitializer>      defaultGraphInitializers   = new ArrayList<INamedGraphInitializer>();

    protected final HashMap<URI, StatementChannel>       statementChannels          = new HashMap<URI, StatementChannel>();

    // runas user state

    /** Service container principal */
    protected AnzoPrincipal                              servicePrincipal           = null;

    /** ThreadLocal property for the userid to run operations as for this thread */
    protected final ThreadLocal<AnzoPrincipal>           runAsPrincipal             = new ThreadLocal<AnzoPrincipal>();

    /** ThreadLocal property for the user to run operations as for this thread */
    protected final ThreadLocal<String>                  runAsUser                  = new ThreadLocal<String>();

    protected String                                     userDescription            = null;

    protected Collection<AnzoClientDataset>              datasets                   = new ArrayList<AnzoClientDataset>();

    /**
     * Creates a new AnzoClient.
     * 
     * Loads the given properties and initializes the various services required to communicate with the anzo server.
     * 
     * @param configuration
     *            Java properties file. These properties are usually created via calls to
     *            {@link AnzoClientConfigurationFactory#createJMSConfiguration(String, String, String, Integer,Boolean)}
     * @throws AnzoException
     */
    public AnzoClient(Properties configuration) throws AnzoException {
        this(new AnzoClientDatasource(configuration));
    }

    /**
     * Creates a new AnzoClient using the provided implementation of the core services. This method is usually only used on the server.
     * 
     * @param configuration
     *            These properties are usually passed in from the OSGI host
     * @param datasource
     *            Instance of the {@link IDatasource} on which this client operates
     * @param authenticationService
     *            Instance of the {@link IAuthenticationService} on which this client operates
     * @param executionService
     *            Instance of the {@link IExecutionService} on which this client operates
     * @param updatesProvider
     *            Instance of the {@link IUpdatesProvider} on which this client operates
     * @param jmsProvider
     *            Instance of the {@link IJmsProvider} that this client uses to get its jms connections
     * @param enableJMS
     *            true if this client needs to use jms. Note:the jmsProvider must be provided if this is true
     * @throws AnzoException
     */
    @SuppressWarnings("unchecked")
    public AnzoClient(Dictionary configuration, IDatasource datasource, IAuthenticationService authenticationService, IExecutionService executionService, IUpdatesProvider updatesProvider, IJmsProvider jmsProvider, boolean enableJMS) throws AnzoException {
        this(new AnzoClientDatasource(configuration, datasource, authenticationService, executionService, updatesProvider, jmsProvider, enableJMS));
    }

    private AnzoClient(AnzoClientDatasource datasource) throws AnzoException {
        this.clientDatasource = datasource;
        this.clientDatasource.start();
        quadStoreComponent = clientDatasource.getQuadStore();
        this.quadStore = this.quadStoreComponent.getQuadStore();
        this.transactionQueue = quadStoreComponent.getTransactionQueue();
        this.serverQuadStore = new ServerQuadStore(this);

        this.replicaGraphTransactionProxy = new TransactionProxy(quadStore, transactionQueue, this);
        this.serverGraphTransactionProxy = new TransactionProxy(serverQuadStore, transactionQueue, this);

        // the replica graph table may be persisted, whereas 
        // the server graph table need not. 
        replicaGraphTable = this.quadStoreComponent.getReplicaGraphTable(this);
        replicaGraphTable.type = Type.REPLICA;
        serverGraphTable = new GraphTable(this);
        serverGraphTable.type = Type.SERVER;

        this.realtimeUpdates = (clientDatasource.getCombusConnection() != null) ? new RealtimeUpdateManager(this) : null;
        this.namedGraphUpdateManager = new NamedGraphUpdateManager(this);

        this.replicaUpdater = new ReplicaUpdater(quadStore, this, ReplicaUpdater.Type.REPLICATION);
        this.namedGraphUpdater = new ReplicaUpdater(quadStore, this, ReplicaUpdater.Type.NAMED_GRAPH_UPDATE);

        this.reconnectionListener = new JMSConnectionListener();

        this.replicator = new Replicator(this);

        defaultGraphInitializers.add(new BaseNamedGraphInitializer());
        defaultGraphInitializers.add(new RevisionedNamedGraphInitializer(true));

    }

    /**
     * @return the AnzoClientDatasource for this AnzoClient
     */
    public AnzoClientDatasource getAnzoClientDatasource() {
        return clientDatasource;
    }

    /**
     * Set whether client will call {@link #updateRepository()} when {@link #commit()} is called
     * 
     * @param updateRepositoryOnCommit
     *            If true, {@link #updateRepository()} is automatically called. If false, the use must call {@link #updateRepository()} directly.
     */
    public void setUpdateRepositoryOnCommit(boolean updateRepositoryOnCommit) {
        this.updateRepositoryOnCommit = updateRepositoryOnCommit;
    }

    /**
     * Connects to the anzo server, establishing event subscriptions if notification is enabled.
     * 
     * @throws AnzoException
     */
    public void connect() throws AnzoException {

        if (closed) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_CLOSED);
        }

        try {
            clientLock.lockInterruptibly();
            if (connected) {
                return;
            }

            jmsEnabled = clientDatasource.getCombusConnection() != null;
            connected = true;
            if (jmsEnabled) {
                clientDatasource.getCombusConnection().connect();
            }
            namedGraphUpdateManager.connect();

            if (jmsEnabled) {
                connectToNotification();
            }

            // setup any statement channels
            for (URI uri : statementChannels.keySet()) {
                StatementChannel channel = statementChannels.get(uri);
                channel.connect();
            }

            // connect all unconnected graphs
            for (URI uri : replicaGraphTable.table.keySet()) {
                ClientGraph graph = replicaGraphTable.table.get(uri).graph;
                if (!graph.connected) {
                    getReplicaGraph(uri, graph.namedGraphInitializers);
                    replicaGraphTable.release(uri, false);
                }
            }

            // we must connect server graphs as well. 
            for (URI uri : serverGraphTable.table.keySet()) {
                ClientGraph graph = serverGraphTable.table.get(uri).graph;
                if (!graph.connected) {
                    getServerGraph(uri, graph.namedGraphInitializers);
                    serverGraphTable.release(uri, false);
                }
            }

            for (IAnzoClientConnectionListener listener : connectionListeners) {
                listener.clientConnected();
            }

        } catch (InterruptedException e) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_LOCK_ERROR, e);
        } finally {
            clientLock.unlock();
        }
    }

    /**
     * Disconnects that Anzo Client. The client may later be reconnected if further operations are required.
     * 
     * @throws AnzoException
     */
    public void disconnect() throws AnzoException {
        try {
            clientLock.lock();

            boolean wasConnected = connected;

            connected = false;

            if (clientDatasource != null) {
                clientDatasource.disconnect(namedGraphUpdateManager);
            }

            namedGraphUpdateManager.disconnect();

            if (wasConnected) {
                disconnectFromNotification(true, true);
            }

            for (URI uri : replicaGraphTable.table.keySet()) {
                ClientGraph graph = replicaGraphTable.table.get(uri).graph;
                graph.connected = false;
            }

            // we must connect server graphs as well. 
            for (URI uri : serverGraphTable.table.keySet()) {
                ClientGraph graph = serverGraphTable.table.get(uri).graph;
                graph.connected = false;
            }

            for (IAnzoClientConnectionListener listener : connectionListeners) {
                listener.clientDisconnected();
            }

        } finally {
            clientLock.unlock();
        }
    }

    /**
     * @return true if the client is currently connected
     */
    public boolean isConnected() {
        return connected;
    }

    /**
     * @return The RealtimeUpdateManager for this client
     * @throws AnzoException
     */
    public RealtimeUpdateManager getRealtimeUpdates() throws AnzoException {
        if (!jmsEnabled) {
            throw new AnzoException(ExceptionConstants.CLIENT.JMS_NOT_ENABLED);
        }
        if (!this.realtimeUpdates.connected) {
            this.realtimeUpdates.connect();
        }
        return this.realtimeUpdates;
    }

    private void connectToNotification() throws AnzoException {
        try {

            if (!jmsEnabled) {
                return;
            }
            if (!clientDatasource.getCombusConnection().isConnected()) {
                clientDatasource.getCombusConnection().connect();
            }

            clientDatasource.getCombusConnection().registerConnectionListener(reconnectionListener);
            clientDatasource.getCombusConnection().startMessageExecutor();
            // check if we need to reconnect the realtime updates
            if (!this.realtimeUpdates.patternToTracker.isEmpty()) {
                this.realtimeUpdates.connect();
            }
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.SERVER_CONNECT_EXCEPTION, jmsex);
        }
    }

    private void disconnectFromNotification(boolean enableReconnect, boolean cleanDisconnect) throws AnzoException {
        ArrayList<AnzoException> exceptions = new ArrayList<AnzoException>();
        if (!jmsEnabled) {
            return;
        }
        if (!enableReconnect) {
            clientDatasource.getCombusConnection().unregisterConnectionListener(reconnectionListener);
        }

        if (this.realtimeUpdates.connected) {
            try {
                realtimeUpdates.disconnect(enableReconnect, cleanDisconnect);
            } catch (AnzoException ae) {
                exceptions.add(ae);
            }
        }

        // this disconnection might be
        // redundant because it should all
        // get closed when the container is stopped
        clientDatasource.getCombusConnection().stopMessageExecutor();
        try {
            clientDatasource.getCombusConnection().disconnect(cleanDisconnect);
        } catch (AnzoException ae) {
            exceptions.add(ae);
        }
        if (exceptions.size() > 0) {
            throw new CompoundAnzoException(exceptions);
        }
    }

    /**
     * Register a {@link IAnzoClientConnectionListener} that is notified when the clients connection state changes.
     * 
     * @param listener
     */
    public void registerConnectionListener(IAnzoClientConnectionListener listener) {
        connectionListeners.add(listener);
    }

    /**
     * Unregister a {@link IAnzoClientConnectionListener} .
     * 
     * @param listener
     */
    public void unregisterConnectionListener(IAnzoClientConnectionListener listener) {
        connectionListeners.remove(listener);
    }

    /**
     * Register a {@link ITransactionListener} that is notified when client receives transaction events.
     * 
     * @param listener
     */
    public void registerTransactionListener(ITransactionListener listener) {
        transactionListeners.add(listener);
    }

    /**
     * Unregister a {@link ITransactionListener}
     * 
     * @param listener
     */
    public void unregisterTransactionListener(ITransactionListener listener) {
        transactionListeners.remove(listener);
    }

    /**
     * Gets a replica graph with the given URI and registers the graph for replication, and optionally for notification. To unregister the graph call
     * graph.close().
     * 
     * A replica graph keeps a local copy of the graph and performs all read and write operations directly against this local copy. The replicate method must be
     * called to synchronize replica graphs with the anzo server.
     * 
     * Since replica graphs keep a local copy of the graph, they may be used offline, meaning they do not require the anzo client be connected to the anzo
     * server.
     * 
     * For details on how replication works, see the replicate method.
     * 
     * To perform reads and writes directly against the server see the getServerGraph method.
     * 
     * @param uri
     *            URI of the NamedGraph to get/create
     * @param namedGraphInitializers
     *            Set of initializers used to create graph if it does not exist. Will use {@link #REVISIONED_NAMED_GRAPH} if none are set.
     * @return A replica graph for the given URI.
     * @throws AnzoException
     */
    public ClientGraph getReplicaGraph(URI uri, INamedGraphInitializer... namedGraphInitializers) throws AnzoException {
        return getReplicaGraphs(Collections.singleton(uri), namedGraphInitializers).get(uri);
    }

    /**
     * Gets a replica graph with the given URI and registers the graph for replication, and optionally for notification. To unregister the graph call
     * graph.close().
     * 
     * A replica graph keeps a local copy of the graph and performs all read and write operations directly against this local copy. The replicate method must be
     * called to synchronize replica graphs with the anzo server.
     * 
     * Since replica graphs keep a local copy of the graph, they may be used offline, meaning they do not require the anzo client be connected to the anzo
     * server.
     * 
     * For details on how replication works, see the replicate method.
     * 
     * To perform reads and writes directly against the server see the getServerGraph method.
     * 
     * @param uris
     *            URI that specifies the name of the graphs.
     * @param namedGraphInitializers
     *            Set of initializers used to create graph if it does not exist. Will use {@link #REVISIONED_NAMED_GRAPH} if none are set.
     * @return Map of URIs to their replica graphs.
     * @throws AnzoException
     */
    public Map<URI, ClientGraph> getReplicaGraphs(Set<URI> uris, INamedGraphInitializer... namedGraphInitializers) throws AnzoException {

        Map<URI, ClientGraph> replicaGraphs = new HashMap<URI, ClientGraph>();
        Set<URI> graphsToGet = new HashSet<URI>();

        for (URI uri : uris) {
            ClientGraph clientGraph = replicaGraphTable.get(uri);
            if (clientGraph != null && (clientGraph.connected || !this.connected)) {
                boolean canReadGraph = true;
                if (runAsUser.get() != null) {
                    canReadGraph = canReadNamedGraph(uri);
                }
                if (canReadGraph) {
                    replicaGraphs.put(uri, clientGraph);
                }
            } else {
                if (clientGraph != null) {
                    // we have to decrement the count because it will be
                    // increased again below.  We cannot just do a release
                    // because that will remove the graph from the table if
                    // the count is just 1 (and should be 0 as in the persistence case)
                    replicaGraphTable.release(uri, false);
                }
                graphsToGet.add(uri);
            }
        }

        if (!connected) {
            for (URI uri : graphsToGet) {
                URI metadataGraphUri = UriGenerator.generateMetadataGraphUri(uri);
                NamedGraph metadataGraph = new MetadataGraph(metadataGraphUri, replicaGraphTransactionProxy, replicaGraphTable);
                metadataGraph.setNotifyAddRemove(false);
                ClientGraph clientGraph = new ClientGraph(uri, replicaGraphTransactionProxy, metadataGraph, this, replicaGraphTable, namedGraphInitializers);
                replicaGraphTable.put(uri, clientGraph);
                if (!inTransaction()) {
                    begin();
                    try {
                        initializeNamedGraph(clientGraph, true, namedGraphInitializers);
                        commit();
                    } catch (AnzoException e) {
                        abort();
                        throw new AnzoException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_GRAPH, e, uri.toString());
                    }
                } else {
                    initializeNamedGraph(clientGraph, true, namedGraphInitializers);
                }

                replicaGraphs.put(uri, clientGraph);
            }
            return Collections.unmodifiableMap(replicaGraphs);
        }

        replicator.replicateToQuadStore(graphsToGet);

        for (URI uri : graphsToGet) {
            boolean createNew = false;
            if (this.quadStore.find(null, null, null, UriGenerator.generateMetadataGraphUri(uri)).isEmpty()) {
                createNew = true;
            }
            ClientGraph graph = getGraph(uri, createNew, replicaGraphTable, replicaGraphTransactionProxy, namedGraphInitializers);
            replicaGraphs.put(uri, graph);
        }

        return replicaGraphs;

    }

    /**
     * Gets a server graph with the given URI and optionally registers it for notification. To unregister the graph call graph.close().
     * 
     * A server graph performs all read and write operations directly against the anzo server and requires a connection to the anzo server to operate.
     * 
     * To perform reads and writes when not connected to the anzo server, see the getReplicaGraph method.
     * 
     * @param uri
     *            URI that specifies the name of the graph.
     * @param namedGraphInitializers
     *            Set of initializers used to create graph if it does not exist. Will use {@link #REVISIONED_NAMED_GRAPH} if none are set.
     * @return A server graph for the given URI.
     * @throws AnzoException
     */
    public ClientGraph getServerGraph(URI uri, INamedGraphInitializer... namedGraphInitializers) throws AnzoException {

        if (!connected) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }

        ClientGraph serverGraph = serverGraphTable.get(uri);
        if (serverGraph != null && serverGraph.connected) {
            if (runAsUser.get() != null) {
                if (canReadNamedGraph(uri)) {
                    return serverGraph;
                } else {
                    return null;
                }
            }
            return serverGraph;
        }

        if (serverGraph != null) {
            // decrement the ref count on the server graph
            // because it will be increased againg below in
            // getGraph()
            serverGraphTable.release(uri, false);
        }

        boolean createNew = !clientDatasource.getModelService().containsNamedGraph(createContext("containsNamedGraph"), uri);

        if (!createNew) {
            Collection<Statement> stmts = null;
            Collection<Statement> serverStmts = null;
            stmts = quadStore.find(uri, org.openanzo.ontologies.openanzo.NamedGraph.uuidProperty, (URI) null, (URI) null);
            if (stmts.isEmpty()) {
                URI metadataGraphUri = UriGenerator.generateMetadataGraphUri(uri);
                serverStmts = serverQuadStore.find(uri, org.openanzo.ontologies.openanzo.NamedGraph.uuidProperty, (URI) null, metadataGraphUri);
                if (!serverStmts.isEmpty()) {
                    Statement uuidStmt = serverStmts.iterator().next();
                    quadStore.add(uuidStmt);
                }
            }

        }

        ClientGraph graph = getGraph(uri, createNew, serverGraphTable, serverGraphTransactionProxy, namedGraphInitializers);
        return graph;

    }

    /**
     * Pushes all committed transactions to the server.
     * 
     * @throws AnzoException
     */
    public void updateRepository() throws AnzoException {
        if (!connected) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }
        replicator.update();
    }

    /**
     * Replicate changes from the server to the client. This is usually not needed, since replica graphs are kept up-to-date via real time messaging.
     * 
     * @throws AnzoException
     */
    public void replicate() throws AnzoException {
        if (!connected) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }
        replicator.replicate();
    }

    /**
     * Begins a new transaction. If begin is called from within a transaction, a nested transaction is begun. Transactions are isolated per thread.
     * 
     * @param preconditions
     *            Optional array of preconditions that must pass for the transaction not to fail.
     */
    public void begin(Set<IPrecondition> preconditions) {
        transactionQueue.begin(preconditions);
    }

    /**
     * Begins a new transaction. If begin is called from within a transaction, a nested transaction is begun.
     */
    public void begin() {
        transactionQueue.begin();
    }

    /**
     * Commit the current transaction. If {@link #setUpdateRepositoryOnCommit(boolean)} has not been called with true, then transaction is kept on client untill
     * {@link #updateRepository()} is called, otherwise transaction is sent to server during this call.
     */
    public void commit() {
        try {
            // transaction complete should also return false
            // if the transaction was empty, and thus not added
            // to the queue.
            boolean transactionComplete = transactionQueue.commit();
            if (transactionComplete) {
                this.replicaGraphTable.mergeIsolatedGraphs();
                this.serverGraphTable.mergeIsolatedGraphs();
                for (AnzoClientDataset dataset : datasets) {
                    dataset.commit();
                }
            }
            if (transactionComplete && updateRepositoryOnCommit) {
                updateRepository();
            }
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

    /**
     * Abort the current transaction.
     */
    public void abort() {
        transactionQueue.abort();
        for (AnzoClientDataset dataset : datasets) {
            dataset.abort();
        }
    }

    /**
     * Get the {@link INamedGraph} that holds the current threads transaction context
     * 
     * @return the {@link INamedGraph} that holds the current threads transaction context
     */
    public INamedGraph getTransactionContext() {
        return transactionQueue.getTransactionContext();
    }

    /**
     * Checks if current thread is in a transaction.
     * 
     * @return True if current thread is in a transaction, false otherwise.
     */
    public boolean inTransaction() {
        return transactionQueue.inTransaction();
    }

    /**
     * If reset is enabled on the anzo server, removes all existing RDF from the repository and replaces it with the given statements.
     * 
     * NOTE: This call resets the anzo server, completely removing all data stored on the server and replacing it with the provided statements. This is intended
     * to be used only for testing, and production anzo servers should be configured with reset disabled.
     * 
     * @param statements
     *            Array of statements that are added to the repository after it is cleared.
     * @param checks
     *            A set of checks that the server blocks on until they are all true before this method returns
     * @throws AnzoException
     */
    public void reset(Collection<Statement> statements, Collection<Statement> checks) throws AnzoException {
        if (!connected) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }
        try {
            clientLock.lockInterruptibly();
            clientDatasource.getResetService().reset(createContext("reset"), statements, checks);
            clear();
        } catch (InterruptedException e) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_LOCK_ERROR, e);
        } finally {
            clientLock.unlock();
        }
    }

    /**
     * Clears the local replicated data, all graphs, and transactions
     * 
     * @throws AnzoException
     */
    public void clear() throws AnzoException {
        try {
            namedGraphUpdateManager.clear();
            clientLock.lockInterruptibly();
            quadStore.clear();
            quadStoreComponent.reset();
            transactionQueue.clear();
            replicaGraphTable.clear();
            serverGraphTable.clear();
        } catch (InterruptedException e) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_LOCK_ERROR, e);
        } finally {
            clientLock.unlock();
        }
    }

    /**
     * Runs a SPARQL query directly against the server.
     * 
     * @param defaultNamedGraphs
     *            List of named graph URIs that identify the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            List of named graph URIs that identify the named graph components of the query's RDF Dataset
     * @param namedDatasets
     *            List of presisted dataset URIs that identify set of datasets whose contents will contribute to the defaultNamedGraphs and namedGraphs.
     * @param query
     *            The SPARQL query that is to be executed.
     * @param baseUri
     *            The base URI against which relative URI references in the query are resolved
     * @return The SPARQL query results.
     * @throws AnzoException
     */
    public QueryResults serverQuery(Set<URI> defaultNamedGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put(OPTIONS.PRIORITY, 4);
        return serverQuery(defaultNamedGraphs, namedGraphs, namedDatasets, query, baseUri, options);
    }

    /**
     * @param defaultNamedGraphs
     *            List of named graph URIs that identify the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            List of named graph URIs that identify the named graph components of the query's RDF Dataset
     * @param namedDatasets
     *            List of presisted dataset URIs that identify set of datasets whose contents will contribute to the defaultNamedGraphs and namedGraphs.
     * @param query
     *            The SPARQL query that is to be executed.
     * @param baseUri
     *            The base URI against which relative URI references in the query are resolved
     * @param options
     *            Pass a set of custom options to this call. see {@link OPTIONS#PRIORITY},{@link Constants.COMBUS#TIMEOUT}, {@link OPTIONS#DATASOURCE}
     * @return The SPARQL query results.
     * @throws AnzoException
     */
    public QueryResults serverQuery(Set<URI> defaultNamedGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri, Map<String, Object> options) throws AnzoException {
        if (!connected) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }
        IOperationContext context = createContext("executeQuery");
        if (options != null) {
            for (String prop : options.keySet()) {
                context.setAttribute(prop, options.get(prop));
            }
        }
        return clientDatasource.getQueryService().query(context, defaultNamedGraphs, namedGraphs, namedDatasets, null, query, baseUri);
    }

    /**
     * Runs a SPARQL query directly against the server.
     * 
     * @param defaultNamedGraphs
     *            List of named graph URIs that identify the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            List of named graph URIs that identify the named graph components of the query's RDF Dataset
     * @param namedDatasets
     *            List of presisted dataset URIs that identify set of datasets whose contents will contribute to the defaultNamedGraphs and namedGraphs.
     * @param query
     *            The SPARQL query that is to be executed.
     * @return The SPARQL query results.
     * @throws AnzoException
     */
    public QueryResults serverQuery(Set<URI> defaultNamedGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query) throws AnzoException {
        return serverQuery(defaultNamedGraphs, namedGraphs, namedDatasets, query, null);
    }

    /**
     * Runs a SPARQL query against this anzo client's replica graphs. This method does not connect to the anzo server and may be called offline.
     * 
     * @param defaultNamedGraphs
     *            List of named graph URIs that identify the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            List of named graph URIs that identify the named graph components of the query's RDF Dataset
     * @param namedDatasets
     *            List of presisted dataset URIs that identify set of datasets whose contents will contribute to the defaultNamedGraphs and namedGraphs.
     * @param query
     *            SPARQL query string
     * @param baseUri
     *            Base URI against which relative URI references in the SPARQL query are resolved
     * @return The SPARQL query results.
     * @throws AnzoException
     */
    public QueryResults replicaQuery(Set<URI> defaultNamedGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        if (namedDatasets != null && namedDatasets.size() > 0)
            throw new UnsupportedOperationException("Named dataset queries against replica graphs");
        return replicaGraphTransactionProxy.executeQuery(defaultNamedGraphs, namedGraphs, namedDatasets, query, baseUri);
    }

    /**
     * Return an collection of statements that match the pattern of subj,prop,obj, namedGraphUri in the local replica graphs
     * 
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphUri
     *            Named graph values to match, or wildcard if null
     * @return an collection of all statements that match the pattern of subj,prop,obj,namedGraphUri
     */
    public Collection<Statement> replicaFind(Resource subj, URI prop, Value obj, URI... namedGraphUri) throws AnzoException {
        if (runAsUser.get() != null) {
            Collection<URI> graphs = new ArrayList<URI>();
            if (namedGraphUri != null && namedGraphUri.length > 0) {
                for (URI ng : namedGraphUri) {
                    if (canReadNamedGraph(ng)) {
                        graphs.add(ng);
                    }
                }
                namedGraphUri = graphs.toArray(new URI[0]);
            }
        }
        Collection<Statement> stmts = replicaGraphTransactionProxy.find(subj, prop, obj, namedGraphUri);

        if (runAsUser.get() != null) {
            if (namedGraphUri == null || namedGraphUri.length == 0) {
                Collection<Statement> filtered = new HashSet<Statement>();
                HashSet<URI> allowed = new HashSet<URI>();
                HashSet<URI> notAllowed = new HashSet<URI>();

                for (Statement stmt : stmts) {
                    if (allowed.contains(stmt.getNamedGraphUri())) {
                        filtered.add(stmt);
                    } else if (notAllowed.contains(stmt.getNamedGraphUri())) {
                        continue;
                    } else {
                        if (canReadNamedGraph(stmt.getNamedGraphUri())) {
                            allowed.add(stmt.getNamedGraphUri());
                            filtered.add(stmt);
                        } else {
                            notAllowed.add(stmt.getNamedGraphUri());
                        }
                    }
                }
                return filtered;
            }
        }

        return stmts;
    }

    /**
     * Return collection of statements that match the pattern of subj,prop,obj, namedGraphUri on the server
     * 
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphUri
     *            Named graph values to match, or wildcard if null
     * @return collection of statements that match the pattern of subj,prop,obj,namedGraphUri
     * @throws AnzoException
     */
    public Collection<Statement> serverFind(Resource subj, URI prop, Value obj, URI... namedGraphUri) throws AnzoException {
        if (!connected) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }
        return serverGraphTransactionProxy.find(subj, prop, obj, namedGraphUri);
    }

    /**
     * Gets a read-only copy of a named graph as it existed when at the provided revision.
     * 
     * @param namedGraphUri
     *            The URI of the named graph to get.
     * @param revision
     *            The revision number, must be greater than zero and less than or equal to the current named graph revision.
     * @return A read-only copy of the named graph.
     * @throws AnzoException
     */
    public IAnzoGraph getNamedGraphRevision(URI namedGraphUri, long revision) throws AnzoException {
        if (!connected) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }
        return clientDatasource.getModelService().getNamedGraphRevision(createContext(IModelService.GET_NAMED_GRAPH_REVISION), namedGraphUri, revision);
    }

    /**
     * Gets a read-only copy of the named graph as it now exists.
     * 
     * @param namedGraphUri
     *            The URI of the named graph to get.
     * @return A read-only copy of the named graph.
     * @throws AnzoException
     */
    public IAnzoGraph getCurrentNamedGraphRevision(URI namedGraphUri) throws AnzoException {
        return getNamedGraphRevision(namedGraphUri, -1);
    }

    /**
     * Closes this anzo client. Once called, the client cannot be reconnected
     */
    public void close() {
        close(true);
    }

    /**
     * Closes this anzo client. Once called, the client cannot be reconnected
     * 
     * @param clean
     *            If true, try to cleanly close jms, otherwise assume jms is not valid
     * 
     */
    public void close(boolean clean) {
        try {
            namedGraphUpdateManager.disconnect();
            clientLock.lock();
            if (connected) {
                try {
                    disconnectFromNotification(false, clean);
                } catch (AnzoException e) {
                    log.error(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_DISCONNECTING_NOTIFICATIONS), e);
                }
            }
            replicaGraphTable.close();
            serverGraphTable.close();
            datasets.clear();
            connected = false;
            closed = true;
        } finally {
            try {
                clientDatasource.stop(clean);
            } catch (AnzoException be) {
                throw new AnzoRuntimeException(be);
            } finally {
                clientLock.unlock();
            }
        }
    }

    private ClientGraph getGraph(URI uri, boolean createNew, GraphTable graphTable, IQuadStore store, INamedGraphInitializer... namedGraphInitalizers) throws AnzoException {
        try {
            clientLock.lockInterruptibly();

            ClientGraph clientGraph = graphTable.get(uri);
            if (clientGraph == null || !clientGraph.connected) {
                URI metadataGraphUri = UriGenerator.generateMetadataGraphUri(uri);
                NamedGraph metadataGraph;

                if (clientGraph == null) {
                    metadataGraph = new MetadataGraph(metadataGraphUri, store, graphTable);
                    metadataGraph.setNotifyAddRemove(false);
                    clientGraph = new ClientGraph(uri, store, metadataGraph, this, graphTable, namedGraphInitalizers);
                    graphTable.put(uri, clientGraph);
                }

                if (!createNew) {
                    Collection<Statement> stmts = null;
                    stmts = quadStore.find(uri, org.openanzo.ontologies.openanzo.NamedGraph.uuidProperty, (URI) null, metadataGraphUri);
                    if (!stmts.isEmpty()) {
                        Statement uuidStmt = stmts.iterator().next();
                        URI uuid = (URI) uuidStmt.getObject();
                        namedGraphUpdateManager.addNamedGraphUpdateTopic(uuid);
                    }
                }
                if (!createNew) {
                    Collection<Statement> stmts = null;
                    stmts = store.find(uri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null, metadataGraphUri);
                    if (!stmts.isEmpty()) {
                        Statement revStmt = stmts.iterator().next();
                        Literal rev = (Literal) revStmt.getObject();
                        try {
                            clientGraph.setRevision(Long.parseLong(rev.getLabel()));
                        } catch (NumberFormatException nfe) {
                            if (log.isDebugEnabled()) {
                                log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CORE.NFE, rev.getLabel()), nfe);
                            }
                        }
                    }
                }
                if (!inTransaction()) {
                    begin();
                    try {
                        if (createNew) {
                            transactionQueue.getOrCreateIsolatedTransaction().currentTransaction.getNamedGraphsToSubscribe().put(uri, metadataGraphUri);
                            if (graphTable == serverGraphTable) {
                                transactionQueue.getOrCreateIsolatedTransaction().currentTransaction.getServerUUIDStoFetch().add(uri);
                            }
                        }
                        initializeNamedGraph(clientGraph, createNew, namedGraphInitalizers);
                        commit();
                    } catch (AnzoException e) {
                        abort();
                        throw new AnzoException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_GRAPH, e, uri.toString());
                    }
                } else {
                    if (createNew) {
                        transactionQueue.getOrCreateIsolatedTransaction().currentTransaction.getNamedGraphsToSubscribe().put(uri, metadataGraphUri);
                        if (graphTable == serverGraphTable) {
                            transactionQueue.getOrCreateIsolatedTransaction().currentTransaction.getServerUUIDStoFetch().add(uri);
                        }
                    }
                    initializeNamedGraph(clientGraph, createNew, namedGraphInitalizers);
                }
                clientGraph.connected = true;
            }
            return clientGraph;

        } catch (InterruptedException e) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_LOCK_ERROR, e);
        } finally {
            clientLock.unlock();
        }
    }

    private void initializeNamedGraph(IAnzoGraph namedGraph, boolean createNew, INamedGraphInitializer... namedGraphInitializers) throws AnzoException {
        for (INamedGraphInitializer initializer : defaultGraphInitializers) {
            initializer.initializeNamedGraph(namedGraph, createNew);
            // we will always be in a transactions so this should never be null;
            Collection<IPrecondition> preconditions = initializer.getPreconditions();
            if (preconditions != null && !preconditions.isEmpty()) {
                transactionQueue.isolatedTransactions.get().currentTransaction.preconditions.addAll(preconditions);
            }
        }

        for (INamedGraphInitializer initializer : namedGraphInitializers) {
            initializer.initializeNamedGraph(namedGraph, createNew);
            Collection<IPrecondition> preconditions = initializer.getPreconditions();
            if (preconditions != null && !preconditions.isEmpty()) {
                transactionQueue.isolatedTransactions.get().currentTransaction.preconditions.addAll(preconditions);
            }
        }
    }

    /**
     * Create, or retrieve if already exists, a dataset of replica graphs based on the given default and named graphs.
     * 
     * @param persisted
     *            If true, this dataset's structure is persisted in the server and thus can be used for running queries.
     * @param datasetUri
     *            URI of the dataset
     * @param defaultGraphUris
     *            List of named graph URIs that identify the graphs that will be merged to form the default graph for this dataset
     * @param namedGraphUris
     *            List of named graph URIs that identify the named graph components for this dataset
     * @param namedGraphInitializers
     *            Set of initializers used to create graph if it does not exist. Will use {@link #REVISIONED_NAMED_GRAPH} if none are set.
     * @return the dataset
     */
    public IDataset createReplicaDataset(boolean persisted, URI datasetUri, Set<URI> defaultGraphUris, Set<URI> namedGraphUris, INamedGraphInitializer... namedGraphInitializers) {
        return new AnzoClientDataset(this, datasetUri, AnzoClientDataset.DatasetType.REPLICA, persisted, defaultGraphUris, namedGraphUris, namedGraphInitializers);
    }

    /**
     * Create, or retrieve if already exists, a dataset of server graphs based on the given default and named graphs.
     * 
     * @param persisted
     *            If true, this dataset's structure is persisted in the server and thus can be used for running queries.
     * @param datasetUri
     *            URI of the dataset
     * @param defaultGraphUris
     *            List of named graph URIs that identify the graphs that will be merged to form the default graph for this dataset
     * @param namedGraphUris
     *            List of named graph URIs that identify the named graph components for this dataset
     * @param namedGraphInitializers
     *            Set of initializers used to create graph if it does not exist. Will use {@link #REVISIONED_NAMED_GRAPH} if none are set.
     * @return the dataset
     */
    public IDataset createServerDataset(boolean persisted, URI datasetUri, Set<URI> defaultGraphUris, Set<URI> namedGraphUris, INamedGraphInitializer... namedGraphInitializers) {
        return new AnzoClientDataset(this, datasetUri, AnzoClientDataset.DatasetType.SERVER, persisted, defaultGraphUris, namedGraphUris, namedGraphInitializers);
    }

    /**
     * Get dataset that represents the set of all open replica graphs. If a service user has been set this call is not permitted.
     * 
     * @return dataset that represents the set of all open replica graphs
     */
    public IDataset getAllReplicaGraphsDataset() {
        if (runAsUser.get() != null) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.OP_NOT_ALLOWED_WITH_SERVICE_USER, "getAllReplicaGraphsDataset");
        }
        return replicaGraphTable.getDataset();
    }

    /**
     * Get dataset that represents the set of all open replica graphs. If a service user has been set this call is not permitted.
     * 
     * @return dataset that represents the set of all open server graphs
     */
    public IDataset getAllServerGraphsDataset() {
        if (runAsUser.get() != null) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.OP_NOT_ALLOWED_WITH_SERVICE_USER, "getAllServerGraphsDataset");
        }
        return serverGraphTable.getDataset();
    }

    /**
     * Get the number of currently queued transactions which have not been sent to the server
     * 
     * @return the number of currently queued transactions which have not been sent to the server
     */
    public long getQueuedTransactionCount() {
        return transactionQueue.committedTransactions.size();
    }

    /**
     * Drop all currently queued transactions
     */
    public void dropQueuedTransactions() {
        transactionQueue.clear();
    }

    /**
     * Get a {@link IStatementChannel} for the given URI
     * 
     * @param uri
     *            URI of statement channel
     * @param initializers
     *            Set of initializers used to create the statement channel's configuration graph if it does not exist. Will use {@link #REVISIONED_NAMED_GRAPH}
     *            if none are set.
     * @return a {@link IStatementChannel} for the given URI
     * @throws AnzoException
     */
    public IStatementChannel getStatementChannel(URI uri, INamedGraphInitializer... initializers) throws AnzoException {
        INamedGraphInitializer[] inits = new INamedGraphInitializer[(initializers != null) ? initializers.length + 1 : 1];
        if (initializers != null)
            System.arraycopy(initializers, 0, inits, 0, initializers.length);
        inits[inits.length - 1] = STATEMENT_STREAM;
        AnzoGraph graph = getReplicaGraph(uri, inits);
        IStatementChannel stream = createStatementChannel(uri, graph);
        return stream;
    }

    /**
     * Import the set of statements into the server. No events/notification are sent for imported statements.
     * 
     * @param statements
     *            Set of statements to import into server
     * @param templateStatements
     *            Template for imported graphs metadata, ie acls
     * @throws AnzoException
     */
    public void importStatements(Collection<Statement> statements, Collection<Statement> templateStatements) throws AnzoException {
        IUpdates updates = clientDatasource.getUpdateService().importStatements(createContext(IUpdateService.IMPORT_STATEMENTS), statements, templateStatements);
        List<IUpdateTransaction> results = updates.getTransactions();
        boolean hadErrors = false;
        @SuppressWarnings("unchecked")
        ArrayList<AnzoException>[] errors = new ArrayList[results.size()];
        int i = 0;

        for (IUpdateTransaction transaction : results) {
            if (transaction.getErrors().size() > 0) {
                hadErrors = true;
                errors[i] = new ArrayList<AnzoException>();
                for (AnzoException err : transaction.getErrors()) {
                    errors[i].add(err);
                }
                i++;
            }
        }
        if (hadErrors) {
            throw new UpdateServerException(updates.getTransactions().toArray(new IUpdateTransaction[0]), errors);
        }
    }

    /**
     * Import the set of statements into the server. No events/notification are sent for imported statements.
     * 
     * @param statements
     *            Set of statements to import into server
     * @param initializers
     *            Set of initializers used to create the imported graphs if it does not exist. Will use {@link #REVISIONED_NAMED_GRAPH} if none are set.
     * @throws AnzoException
     */
    public void importStatements(Collection<Statement> statements, INamedGraphInitializer... initializers) throws AnzoException {
        MemQuadStore store = new MemQuadStore();
        AnzoGraph graphTemplate = new AnzoGraph(GRAPHS.DEFAULT_GRAPH_TEMPLATE, new NamedGraph(GRAPHS.DEFAULT_METADATA_GRAPH_TEMPLATE, store), store);
        for (INamedGraphInitializer initializer : initializers) {
            initializer.initializeNamedGraph(graphTemplate, true);
        }
        IUpdates updates = clientDatasource.getUpdateService().importStatements(createContext(IUpdateService.IMPORT_STATEMENTS), statements, store.getStatements());
        List<IUpdateTransaction> results = updates.getTransactions();
        boolean hadErrors = false;
        @SuppressWarnings("unchecked")
        ArrayList<AnzoException>[] errors = new ArrayList[results.size()];
        int i = 0;

        for (IUpdateTransaction transaction : results) {
            if (transaction.getErrors().size() > 0) {
                hadErrors = true;
                errors[i] = new ArrayList<AnzoException>();
                for (AnzoException err : transaction.getErrors()) {
                    errors[i].add(err);
                }
                i++;
            }
        }
        if (hadErrors) {
            throw new UpdateServerException(updates.getTransactions().toArray(new IUpdateTransaction[0]), errors);
        }
    }

    /**
     * Import the set of statements into the server. No events/notification are sent for imported statements.
     * 
     * @param fileName
     *            Name of file containing statements
     * @param baseUri
     *            Base URI of uris in the file
     * @param defaultNamedGraph
     *            Default graph for statements that do not have a namedGraph specified in file
     * @param initializers
     *            Set of initializers used to create the imported graphs if it does not exist. Will use {@link #REVISIONED_NAMED_GRAPH} if none are set.
     * @param callbackHandler
     *            Callback handler to show verbose status of import
     * @throws AnzoException
     */
    public void importStatements(String fileName, String baseUri, URI defaultNamedGraph, int batchSize, final IStatementsHandler callbackHandler, INamedGraphInitializer... initializers) throws AnzoException {
        try {
            Reader reader = ReadWriteUtils.createSmartFileReader(fileName);
            importStatements(reader, RDFFormat.forFileName(fileName), baseUri, defaultNamedGraph, batchSize, callbackHandler, initializers);
            reader.close();
        } catch (FileNotFoundException fnfe) {
            throw new AnzoException(ExceptionConstants.IO.RDF_PARSER_ERROR, fnfe);
        } catch (IOException fnfe) {
            throw new AnzoException(ExceptionConstants.IO.RDF_PARSER_ERROR, fnfe);
        }
    }

    /**
     * Import the set of statements into the server. No events/notification are sent for imported statements.
     * 
     * @param reader
     *            reader containing data
     * @param format
     *            format of data within reader. @see {@link RDFFormat}
     * @param baseUri
     *            Base URI of uris in the file
     * @param defaultNamedGraph
     *            Default graph for statements that do not have a namedGraph specified in file
     * @param callbackHandler
     *            Callback handler to show verbose status of import
     * @param initializers
     *            Set of initializers used to create the imported graphs if it does not exist. Will use {@link #REVISIONED_NAMED_GRAPH} if none are set.
     * @throws AnzoException
     */
    public void importStatements(Reader reader, RDFFormat format, String baseUri, URI defaultNamedGraph, int batchSize, final IStatementsHandler callbackHandler, INamedGraphInitializer... initializers) throws AnzoException {
        final MemQuadStore store = new MemQuadStore();
        AnzoGraph graphTemplate = new AnzoGraph(GRAPHS.DEFAULT_GRAPH_TEMPLATE, new NamedGraph(GRAPHS.DEFAULT_METADATA_GRAPH_TEMPLATE, store), store);
        for (INamedGraphInitializer initializer : initializers) {
            initializer.initializeNamedGraph(graphTemplate, true);
        }
        long start = System.currentTimeMillis();
        int totalSize = 0;
        if (defaultNamedGraph == null && !format.supportsNamedGraphs()) {
            totalSize = ReadWriteUtils.batchLoadStatementsWithSubjectToNamedGraph(reader, format, baseUri, batchSize, new IStatementsHandler() {
                public void handleStatements(Collection<Statement> statements) throws AnzoException {
                    IUpdates updates = clientDatasource.getUpdateService().importStatements(createContext(IUpdateService.IMPORT_STATEMENTS), statements, store.getStatements());
                    List<IUpdateTransaction> results = updates.getTransactions();
                    @SuppressWarnings("unchecked")
                    ArrayList<AnzoException>[] errors = new ArrayList[results.size()];
                    int i = 0;
                    boolean hadErrors = false;
                    for (IUpdateTransaction transaction : results) {
                        if (transaction.getErrors().size() > 0) {
                            hadErrors = true;
                            errors[i] = new ArrayList<AnzoException>();
                            for (AnzoException err : transaction.getErrors()) {
                                errors[i].add(err);
                            }
                            i++;
                        }
                    }
                    if (hadErrors) {
                        throw new UpdateServerException(updates.getTransactions().toArray(new IUpdateTransaction[0]), errors);
                    } else {
                        if (callbackHandler != null)
                            callbackHandler.handleStatements(statements);
                    }
                }
            });
        } else {
            totalSize = ReadWriteUtils.batchLoadStatements(reader, format, baseUri, defaultNamedGraph, batchSize, new IStatementsHandler() {
                public void handleStatements(Collection<Statement> statements) throws AnzoException {
                    IUpdates updates = clientDatasource.getUpdateService().importStatements(createContext(IUpdateService.IMPORT_STATEMENTS), statements, store.getStatements());
                    List<IUpdateTransaction> results = updates.getTransactions();
                    @SuppressWarnings("unchecked")
                    ArrayList<AnzoException>[] errors = new ArrayList[results.size()];
                    int i = 0;
                    boolean hadErrors = false;
                    for (IUpdateTransaction transaction : results) {
                        if (transaction.getErrors().size() > 0) {
                            hadErrors = true;
                            errors[i] = new ArrayList<AnzoException>();
                            for (AnzoException err : transaction.getErrors()) {
                                errors[i].add(err);
                            }
                            i++;
                        }
                    }
                    if (hadErrors) {
                        throw new UpdateServerException(updates.getTransactions().toArray(new IUpdateTransaction[0]), errors);
                    } else {
                        if (callbackHandler != null)
                            callbackHandler.handleStatements(statements);
                    }
                }
            });
        }
        long total = System.currentTimeMillis() - start;
        if (log.isInfoEnabled()) {
            log.info(LogUtils.INTERNAL_MARKER, "Imported " + totalSize + " in " + (total / 1000) + " seconds");
        }
    }

    /**
     * Import the set of statements into the server. No events/notification are sent for imported statements.
     * 
     * @param reader
     *            reader containing data
     * @param format
     *            format of data within reader. @see {@link RDFFormat}
     * @param baseUri
     *            Base URI of uris in the file
     * @param defaultNamedGraph
     *            Default graph for statements that do not have a namedGraph specified in file
     * @param templateStatements
     *            Template for imported graphs metadata, ie acls
     * @param callbackHandler
     *            Callback handler to show verbose status of import
     * @throws AnzoException
     */
    public void importStatements(Reader reader, RDFFormat format, String baseUri, URI defaultNamedGraph, int batchSize, final Collection<Statement> templateStatements, final IStatementsHandler callbackHandler) throws AnzoException {

        long start = System.currentTimeMillis();
        int totalSize = ReadWriteUtils.batchLoadStatements(reader, format, baseUri, defaultNamedGraph, batchSize, new IStatementsHandler() {
            public void handleStatements(Collection<Statement> statements) throws AnzoException {
                IUpdates updates = clientDatasource.getUpdateService().importStatements(createContext(IUpdateService.IMPORT_STATEMENTS), statements, templateStatements);
                List<IUpdateTransaction> results = updates.getTransactions();
                @SuppressWarnings("unchecked")
                ArrayList<AnzoException>[] errors = new ArrayList[results.size()];
                int i = 0;
                boolean hadErrors = false;
                for (IUpdateTransaction transaction : results) {
                    if (transaction.getErrors().size() > 0) {
                        hadErrors = true;
                        errors[i] = new ArrayList<AnzoException>();
                        for (AnzoException err : transaction.getErrors()) {
                            errors[i].add(err);
                        }
                        i++;
                    }
                }
                if (hadErrors) {
                    throw new UpdateServerException(updates.getTransactions().toArray(new IUpdateTransaction[0]), errors);
                } else {
                    if (callbackHandler != null)
                        callbackHandler.handleStatements(statements);
                }
            }
        });
        long total = System.currentTimeMillis() - start;
        if (log.isInfoEnabled()) {
            log.info(LogUtils.INTERNAL_MARKER, "Imported " + totalSize + " in " + (total / 1000) + " seconds");
        }
    }

    private IStatementChannel createStatementChannel(URI uri, AnzoGraph graph) throws AnzoException {
        if (!jmsEnabled) {
            throw new AnzoException(ExceptionConstants.CLIENT.JMS_NOT_ENABLED);
        }
        StatementChannel channel = statementChannels.get(uri);
        if (channel == null) {
            channel = new StatementChannel(clientDatasource.getCombusConnection(), uri, graph, this);
            statementChannels.put(uri, channel);
        }
        return channel;
    }

    void closeChannel(IStatementChannel channel) throws AnzoException {
        statementChannels.remove(channel.getURI());
    }

    /**
     * Returns true if the NamedGraph is stored on the server
     * 
     * @param namedGraphUri
     *            URI of NamedGraph to check for on server
     * @return True if the namedGraph stored on the server
     * @throws AnzoException
     */
    public boolean namedGraphExists(URI namedGraphUri) throws AnzoException {
        if (!connected) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }
        if (namedGraphUri == null) {
            return false;
        }
        try {
            return clientDatasource.getModelService().containsNamedGraph(createContext(IModelService.CONTAINS_NAMED_GRAPH), namedGraphUri);
        } catch (AnzoException be) {
            if (be.getErrorCode() == ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND) {
                return false;
            } else {
                throw be;
            }
        }
    }

    /**
     * Retrieve the set URIs for the graphs stored on the server, for which the current user has read permission.
     * 
     * @return set of URIs for the graphs stored on the server, for which the current user has read permission.
     * @throws AnzoException
     */
    public Set<URI> getNamedGraphs() throws AnzoException {
        return clientDatasource.getModelService().getStoredNamedGraphs(createContext(IModelService.GET_STORED_NAMED_GRAPHS));
    }

    /**
     * Exectute a semantic service on the server
     * 
     * @param serviceUri
     *            URI of the service to call
     * @param statements
     *            Input statements to the service
     * @return results from the service
     * @throws AnzoException
     */
    public Collection<Statement> executeService(URI serviceUri, Collection<Statement> statements) throws AnzoException {
        IOperationContext context = createContext(IExecutionService.EXECUTE_SERVICE);
        return clientDatasource.getExecutionService().executeService(context, statements, serviceUri);
    }

    protected void handleTransaction(IUpdateTransaction transaction) throws AnzoException {
        replicator.transactionComplete(transaction.getURI());
        notifyTransactionListeners(transaction);
    }

    protected void notifyTransactionListeners(IUpdateTransaction transaction) {
        if (userDescription != null) {
            MDC.put(SerializationConstants.userDescription, userDescription);
        }
        try {
            if (transactionListeners.size() > 0) {
                IDataset dataset = new Dataset();
                if (transaction.getTransactionContext() != null) {
                    Collection<Statement> stmts = transaction.getTransactionContext();
                    for (Statement stmt : stmts) {
                        URI namedGraphUri = stmt.getNamedGraphUri();
                        if (!dataset.containsNamedGraph(namedGraphUri)) {
                            dataset.addNamedGraph(namedGraphUri);
                        }
                        dataset.add(stmt);
                    }
                }
                Set<URI> ngUpates = convertUUIDSToNamedGraphURIs(transaction.getUpdatedNamedGraphRevisions().keySet());
                for (ITransactionListener listener : transactionListeners) {
                    listener.transactionComplete(transaction.getURI(), transaction.getTransactionTimestamp(), ngUpates, dataset);
                }
            }
        } finally {
            if (userDescription != null) {
                MDC.remove(SerializationConstants.userDescription);
            }
        }
    }

    protected void notifyTransactionListners(URI transactionUri, long timestamp, Set<URI> namedGraphs, Collection<Statement> context) {
        if (userDescription != null) {
            MDC.put(SerializationConstants.userDescription, userDescription);
        }
        try {
            if (transactionListeners.size() > 0) {
                IDataset dataset = new Dataset();
                if (context != null) {
                    for (Statement stmt : context) {
                        URI namedGraphUri = stmt.getNamedGraphUri();
                        if (!dataset.containsNamedGraph(namedGraphUri)) {
                            dataset.addNamedGraph(namedGraphUri);
                        }
                        dataset.add(stmt);
                    }
                }
                for (ITransactionListener listener : transactionListeners) {
                    listener.transactionComplete(transactionUri, timestamp, namedGraphs, dataset);
                }
            }
        } finally {
            if (userDescription != null) {
                MDC.remove(SerializationConstants.userDescription);
            }
        }
    }

    protected void notifyTransactionListners(URI transactionUri, Set<URI> namedGraphs, Collection<Statement> context, List<AnzoException> errors) {
        if (userDescription != null) {
            MDC.put(SerializationConstants.userDescription, userDescription);
        }
        try {
            if (transactionListeners.size() > 0) {
                IDataset dataset = new Dataset();
                if (context != null) {
                    for (Statement stmt : context) {
                        URI namedGraphUri = stmt.getNamedGraphUri();
                        if (!dataset.containsNamedGraph(namedGraphUri)) {
                            dataset.addNamedGraph(namedGraphUri);
                        }
                        dataset.add(stmt);
                    }
                }
                for (ITransactionListener listener : transactionListeners) {
                    listener.transactionFailed(transactionUri, namedGraphs, dataset, errors);
                }
            }
        } finally {
            if (userDescription != null) {
                MDC.remove(SerializationConstants.userDescription);
            }
        }
    }

    protected Set<URI> convertUUIDSToNamedGraphURIs(Set<URI> uuids) {
        Set<URI> uris = new HashSet<URI>();
        for (URI uuid : uuids) {
            Iterator<Statement> stmts = null;
            stmts = quadStore.find(null, org.openanzo.ontologies.openanzo.NamedGraph.uuidProperty, uuid, (URI) null).iterator();
            if (stmts.hasNext()) {
                Statement uuidStmt = stmts.next();
                URI namedGraphUri = (URI) uuidStmt.getSubject();
                uris.add(namedGraphUri);
            }

        }
        return uris;
    }

    /**
     * Set the userId for the current thread which this service will use to authenticate. The Anzo Client will protect replica data from being read by
     * non-authorized service users, but will not be able to prevent services users from listenting to realtime updates (for example) that have already been
     * registered by an authorized user. In general, events are not protected in this manner.
     * 
     * Multi-user uses of this client (in web-apps for example) should be sure that updates create in the transaction queue or current transaction have been
     * committed and sent to the server via update repository before either handing control to a new service user, or reverting control back to the primary
     * user. This is to keep service users from writing statements to graphs they don't have permission to, as well as prevent valid writes from service or
     * primary users to fail because they could be ultimately sent to the server by an un-authorized service user. A good first step to prevent such situations
     * is to setUpdateOnCommit(true).
     * 
     * @param user
     *            userId for the current thread which this service will use to authenticate
     */
    public void setServiceUser(String user) throws AnzoException {
        if (servicePrincipal == null) {
            servicePrincipal = getServicePrincipal();
        }
        if (!servicePrincipal.isSysadmin()) {
            throw new AnzoException(ExceptionConstants.COMBUS.RUNAS_NOT_AUTHORIZED);
        }
        if (user == null || user.equals(servicePrincipal.getName())) {
            runAsUser.remove();
        } else {
            runAsUser.set(user);
        }
        runAsPrincipal.remove();
    }

    /**
     * Get the userId for the current thread which this service will use to authenticate
     * 
     * @return the userId for the current thread which this service will use to authenticate
     */
    public String getServiceUser() {
        String ruser = runAsUser.get();
        if (ruser != null) {
            return ruser;
        } else {
            return clientDatasource.getServiceUser();
        }
    }

    /**
     * Allow end user to provide a description about the user
     * 
     * @param userDescription
     *            User provided description
     */
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    /**
     * Get user provided description of client if available
     * 
     * @return User provided description
     */
    public String getUserDescription() {
        return userDescription;
    }

    private boolean getGraphPermission(URI namedGraphUri, Privilege privilege, URI metadataPredicate) throws AnzoException {
        // not all data sources will provide access control info in the metadata graph but for those
        // that do, we can short circuit a call to the server if we have the graph in the replica.
        URI metadataGraphUri = UriGenerator.generateMetadataGraphUri(namedGraphUri);
        Collection<Statement> roleStmts = quadStore.find(namedGraphUri, metadataPredicate, null, metadataGraphUri);
        Set<URI> graphRoles = new HashSet<URI>();
        for (Statement stmt : roleStmts) {
            graphRoles.add((URI) stmt.getObject());
        }
        if (org.openanzo.rdf.utils.Collections.memberOf(graphRoles, getServicePrincipal().getRoles())) {
            return true;
        }
        // we could potentially avoid some of the following calls to the server
        if (!namedGraphExists(namedGraphUri)) {
            return false;
        }
        if (getServicePrincipal().isSysadmin()) {
            return true;
        }
        return org.openanzo.rdf.utils.Collections.memberOf(clientDatasource.getAuthorizationService().getRolesForGraph(createContext(IAuthorizationService.GET_ROLES_FOR_GRAPH), namedGraphUri, privilege), getServicePrincipal().getRoles());
    }

    /**
     * Return true if the user has permission to read data from the given grap
     * 
     * @param namedGraphUri
     *            URI of graph for which to determine read permission
     * @return true if the user has permission to read data from the given graph
     * @throws AnzoException
     */
    public boolean canReadNamedGraph(URI namedGraphUri) throws AnzoException {
        return getGraphPermission(namedGraphUri, Privilege.READ, org.openanzo.ontologies.openanzo.NamedGraph.canBeReadByProperty);
    }

    /**
     * Return true if the user has permission to add data from the given graph
     * 
     * @param namedGraphUri
     *            URI of graph for which to determine add permission
     * @return true if the user has permission to add data from the given graph
     * @throws AnzoException
     */
    public boolean canAddToNamedGraph(URI namedGraphUri) throws AnzoException {
        return getGraphPermission(namedGraphUri, Privilege.ADD, org.openanzo.ontologies.openanzo.NamedGraph.canBeAddedToByProperty);
    }

    /**
     * Return true if the user has permission to remove data from the given graph
     * 
     * @param namedGraphUri
     *            URI of graph for which to determine remove permission
     * @return true if the user has permission to remove data from the given graph
     * @throws AnzoException
     */
    public boolean canRemoveFromNamedGraph(URI namedGraphUri) throws AnzoException {
        return getGraphPermission(namedGraphUri, Privilege.REMOVE, org.openanzo.ontologies.openanzo.NamedGraph.canBeRemovedFromByProperty);
    }

    /**
     * Get the AnzoPrincipal object for the the currently connected user
     * 
     * @return AnzoPrincipal object for the the currently connected user
     * @throws AnzoException
     */
    public AnzoPrincipal getServicePrincipal() throws AnzoException {
        String user = runAsUser.get();
        if (user != null) {
            AnzoPrincipal runAsPrincipal = this.runAsPrincipal.get();
            if (runAsPrincipal != null) {
                return runAsPrincipal;
            }
            IOperationContext context = new BaseOperationContext("getUserPrincipal", BaseOperationContext.generateOperationId(), null);
            runAsPrincipal = clientDatasource.authenticationService.getUserPrincipal(context, user);
            this.runAsPrincipal.set(runAsPrincipal);
            return runAsPrincipal;
        } else {
            if (servicePrincipal == null) {
                IOperationContext context = new BaseOperationContext("getUserPrincipal", BaseOperationContext.generateOperationId(), null);
                servicePrincipal = clientDatasource.authenticationService.getUserPrincipal(context, getServiceUser());
                return servicePrincipal;
            }
            return servicePrincipal;
        }
    }

    protected IOperationContext createContext(String name) throws AnzoException {
        return new BaseOperationContext(name, BaseOperationContext.generateOperationId(), getServicePrincipal());
    }

    class JMSConnectionListener implements INotificationConnectionListener {
        public void connectionStateChanged(int state) {
            // react to auto-reconnection from the underlying 
            // JMS connection
            if (state == INotificationConnectionListener.CONNECTED) {
                if (!connected) {
                    try {
                        connect();
                    } catch (AnzoException e) {
                        log.error(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.JMS_CONNECT_FAILED), e);
                    }
                }
                // react to disconnection from the underlying JMS connection
            } else if (state == INotificationConnectionListener.DISCONNECTED || state == INotificationConnectionListener.CONNECTIONFAILED) {
                if (connected) {
                    try {
                        disconnect();
                    } catch (AnzoException e) {
                        log.error(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_DISCONNECTING_NOTIFICATIONS));
                    }
                }
            }
        }

        public void notificationException(AnzoException exception) {
        }
    }

    private static class BaseNamedGraphInitializer implements INamedGraphInitializer {

        public void initializeNamedGraph(IAnzoGraph namedGraph, boolean createNew) throws AnzoException {
            if (createNew) {
                INamedGraph metadataGraph = namedGraph.getMetadataGraph();
                URI uri = namedGraph.getNamedGraphUri();
                URI metadataGraphUri = metadataGraph.getNamedGraphUri();
                if (!metadataGraph.contains(uri, org.openanzo.ontologies.openanzo.NamedGraph.hasMetadataGraphProperty, metadataGraphUri)) {
                    metadataGraph.add(uri, org.openanzo.ontologies.openanzo.NamedGraph.hasMetadataGraphProperty, metadataGraphUri);
                    metadataGraph.add(uri, RDF.TYPE, org.openanzo.ontologies.openanzo.NamedGraph.TYPE);
                }
            }
        }

        public Collection<IPrecondition> getPreconditions() {
            return null;
        }

    }

    private static class RevisionedNamedGraphInitializer implements INamedGraphInitializer {

        boolean revisioned = true;

        public RevisionedNamedGraphInitializer(boolean revisioned) {
            this.revisioned = revisioned;
        }

        public void initializeNamedGraph(IAnzoGraph namedGraph, boolean createNew) throws AnzoException {
            if (createNew) {
                INamedGraph metadataGraph = namedGraph.getMetadataGraph();
                org.openanzo.ontologies.openanzo.NamedGraph graph = AnzoFactory.getNamedGraph(namedGraph.getNamedGraphUri(), metadataGraph);
                //if (graph.getRevisioned() == null) {
                graph.setRevisioned(revisioned);
                //}
            }

        }

        public Collection<IPrecondition> getPreconditions() {
            return null;
        }

    }

    private static class StatementStreamInitializer implements INamedGraphInitializer {

        public StatementStreamInitializer() {
        }

        public void initializeNamedGraph(IAnzoGraph namedGraph, boolean createNew) throws AnzoException {
            if (createNew) {
                INamedGraph metadataGraph = namedGraph.getMetadataGraph();
                Statement type = Constants.valueFactory.createStatement(namedGraph.getNamedGraphUri(), RDF.TYPE, org.openanzo.ontologies.openanzo.StatementStream.TYPE, metadataGraph.getNamedGraphUri());
                if (!metadataGraph.contains(type)) {
                    metadataGraph.add(type);
                }
            }
        }

        public Collection<IPrecondition> getPreconditions() {
            return null;
        }

    }

    private static class GraphExistenceInitializer implements INamedGraphInitializer {

        IAnzoGraph graph     = null;

        boolean    mustExist = true;

        GraphExistenceInitializer(boolean mustExist) {
            this.mustExist = mustExist;
        }

        public void initializeNamedGraph(IAnzoGraph namedGraph, boolean createNew) throws AnzoException {
            this.graph = namedGraph;
        }

        public Collection<IPrecondition> getPreconditions() {
            IPrecondition precondition = new Precondition();
            String queryString = "ASK  { <" + graph.getNamedGraphUri() + "> <" + RDF.TYPE + "> <" + org.openanzo.ontologies.openanzo.NamedGraph.TYPE + ">}";
            precondition.setQuery(queryString);
            precondition.setDefaultGraphUris(Collections.singleton(UriGenerator.generateMetadataGraphUri(graph.getNamedGraphUri())));
            precondition.setResult(mustExist);
            return Collections.singleton(precondition);
        }
    }

}
