/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/


dojo.provide("anzo.client.AnzoClient");

dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.client.MetadataGraph");
dojo.require("anzo.rdf.AnzoGraph");

dojo.require("anzo.client.JMSUpdateService");
dojo.require("anzo.client.JMSReplicationService");
dojo.require("anzo.client.JMSQueryService");
dojo.require("anzo.client.JMSResetService");
dojo.require("anzo.client.JMSModelService");
dojo.require("anzo.client.JMSExecutionService");
dojo.require("anzo.client.JMSAuthorizationService");
dojo.require("anzo.client.NamedGraphUpdateManager");
dojo.require("anzo.client.TransactionProxy");
dojo.require("anzo.client.TransactionQueue");
dojo.require("anzo.client.GraphTable");
dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.client.Replicator");
dojo.require("anzo.client.ReplicaUpdater");
dojo.require("anzo.client.RealtimeUpdateManager");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.client.StatementChannel");
dojo.require("anzo.utils.UriGenerator");
dojo.require("anzo.rdf.vocabulary.RDF");
dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.client.Precondition");
dojo.require("anzo.client.AnzoClientDataset");
dojo.require("anzo.log");

(function(){

var log = anzo.log.getLogger("anzo.client.AnzoClient");
 
dojo.declare('anzo.client.AnzoClient', null, {
    
    updateService                : null,
    replicationService           : null,
    resetService                 : null,
    queryService                 : null,
    modelService				 : null,
    executionService			 : null,
    transactionQueue             : null,
    graphTable                   : null,
    transactionProxy             : null,
    quadStore                    : null,
    replicator					 : null,
    replicaUpdater				 : null,
    properties                   : null,
    newGraphs		 			 : null,
    realtimeUpdates              : null,
    
    constructor : function(properties) {
        // summary: Creates an AnzoClient using the given properties for configuration.
        // properties: Object.
        //   Configuration properties which specify connection information, etc. The following properties are supported:
        //     location: String. Required. The URL (absolute or relative) to where the anzo server is listening for connections.
        //     username: String. Required. The username to use for authenticating to the server.
        //     password: String. Required. The password to use for authenticating to the server.
        //     timeout: Number. Optional. Default is 30 seconds. The amount of time before an AnzoClient operation waits for a 
        //       response from the server before raising a timeout exception. This setting does not apply to the 'serverQuery' method which
        //       has a parameter to specify its own timeout.
        //     loginURL: String. Optional. Default is the 'location' string appended with the string 'anzo_authenticate'. This is the URL to
        //       use for the authentication request to the server. This is the only URL to which the username and password will be sent.  
        //     queryCacheEnabled: Boolean. Optional. Defaults to 'true'. If true, then SPARQL query results are cached on the client.
        //     queryCacheCapacity: Number. Optional. Defaults to 100. Sets the maximum number of queries whose results can be cached at any given time. When full, 
        //       the cache evicts entries to make way for new ones based on a cache policy (typically 'least recently used' entries are evicted). -1 indicates no limit.
        //     equivalentQueryCullingEnabled: Boolean. Optional. Defaults to 'true'. If true, then if a client asks the same query (including same dataset) as a query
        //       that is currently awaiting a response from the server, then the second query is not repeated and simply gets the response from the already pending query
        //       once it arrives. This functionality is only present when query caching is enabled.
        
        this._closed = false;
        this.connected = false;
        
        this.properties = properties;
        
        this.updateService         = new anzo.client.JMSUpdateService();
        this.replicationService    = new anzo.client.JMSReplicationService();
        this.resetService          = new anzo.client.JMSResetService();
        this.modelService		   = new anzo.client.JMSModelService();
        this.executionService	   = new anzo.client.JMSExecutionService();
        this.authorizationService = new anzo.client.JMSAuthorizationService();
        
        this.transactionQueue    = new anzo.client.TransactionQueue(this);
       
        this.graphTable          = new anzo.client.GraphTable();
        
        this.quadStore           = new anzo.rdf.QuadStore();
        this.transactionProxy    = new anzo.client.TransactionProxy(this.quadStore, this.transactionQueue);
        this.replicator		     = new anzo.client.Replicator(this);
        
        this.replicaUpdater      = new anzo.client.ReplicaUpdater(this, this.quadStore, anzo.client.ReplicaUpdater.TYPE_REPLICATION);
        this.namedGraphUpdateManager = new anzo.client.NamedGraphUpdateManager(this);
        
        this.newGraphs 			 = {};
        
        this.defaultGraphInitializers = [];
        this.defaultGraphInitializers.push(this.baseInitializer);
        this.defaultGraphInitializers.push(this.getRevisionedGraphInitializer(true));
        
        // map from uri -> array of callback functions
        this.getReplicaGraphCalls = {};
        
        this.realtimeUpdates = new anzo.client.RealtimeUpdateManager(this);
        this.updateRepositoryOnCommit = false;

        var queryCacheEnabled = this.properties.queryCacheEnabled == null || this.properties.queryCacheEnabled; //default to true
        var equivalentQueryCullingEnabled = this.properties.equivalentQueryCullingEnabled == null || this.properties.equivalentQueryCullingEnabled; //default to true
        this.queryService = new anzo.client.JMSQueryService((queryCacheEnabled ? this.realtimeUpdates : null), this.properties.queryCacheCapacity, equivalentQueryCullingEnabled);
    },
    
    connect : function(callback) {

        if (this._closed) {
            callback(null, new Error("AnzoClient is closed."));
            return;
        }

        if (this.connected) {
            log.warn("AnzoClient is already connected.");
        }
        log.debug("connect - Starting AnzoClient.connect.");
        anzo.messaging.JMSClient.connect(this.properties, dojo.hitch(this, function(status, message) {
            log.debug("connect - JMSClient connect complete.");
            if (status != anzo.messaging.CONNECTION_STATUS_CONNECTED) {
                log.debug("connect - error connecting.");
                if (callback) {
                    callback(status, message);
                }
                return;
            }
            
            if (message) {
	            var rolesStr = message[anzo.messaging.CONTROL_MSG_USER_ROLES];
	            if (rolesStr) {
    	            var roles = rolesStr.split("\n");
    	            this.userRoles = new anzo.utils.Set();
    	            for (var i=0;i<roles.length;i++) {
    	            	this.userRoles.add(anzo.createURI(roles[i]));
    	            }
	            }
	            
	            var userUriStr = message[anzo.messaging.CONTROL_MSG_USER_URI];
	            if (userUriStr) {
	                try {
	                   var userUri = anzo.createURI(userUriStr);
	                   this.userUri = userUri;
	                } catch(e) {
	                    log.error("Error parsing user URI returned by server: " + userUriStr);
	                }
	            }
	            this.isSysadmin=message[anzo.messaging.CONTROL_MSG_USER_IS_SYSADMIN];
            }
            this.connected = true;
            
            // Setup a listener to the JMSClient onDisonnect event so that we can clean up when
            // disconnection happens and fire the event up to our callers.
            this._jmsClientDisonnectEventHandle = dojo.connect(anzo.messaging.JMSClient, "onDisconnect", this, "_onJMSClientDisconnectInAnzoClient");
            
            var graphsToConnect = [];
            var graphsConnected = [];
            var graphsFailed = [];
            var calledBack = false;
            
            // Wrap the user's callback, if any, with a call to initialize the realtimeUpdates.
            // This has the effect of initializing it after all of the other AnzoClient initialization and before the
            // user's callback is called.
            var userCallback = callback;
            callback = dojo.hitch(this, function connectCallbackWrapper(status, message) {
                log.debug("connect - connectCallbackWrapper. About to connect realtimeUpdateClient.");
                this.realtimeUpdates._connect(dojo.hitch(this, function realtimeUpdateManagerConnectCallback() {
                    log.debug("connect - connected realtimeUpdateClient.");
                    this.clientConnected();
                    if (userCallback) {
                        userCallback(status, message);
                    }
                }));
            });
            
            // connect any unconnected graphs
            for (var uri in this.graphTable.table) {
                var graph = this.graphTable.table[uri].graph;
                if (!graph._connected) {
                    graphsToConnect.push(uri);
                }
            }
            
            if (graphsToConnect.length == 0) {
                log.debug("No existing graphs to connect in the AnzoClient.");
                if (callback) {
                    calledBack = true;
                    callback(status, message);
                }
                return;
            }
            
            for (var i=0;i<graphsToConnect.length;i++) {
                if (log.isDebugEnabled()) {
                    log.debug("Connecting graph:" + graphsToConnect[i]);
                }
                this.getReplicaGraph(graphsToConnect[i], {create: true, namedGraphInitializers: this.graphTable.table[graphsToConnect[i]].graph._namedGraphInitializers}, (function(i) { return function(graph, errors) {
                    if (calledBack) {
                        return;
                    }
                    if (graph) {
                        graphsConnected.push(graph.namedGraphUri);
                        graph.close();
                    } else {
                        if (log.isDebugEnabled()) {
                            log.debug("connect - Failed to get replica graph for graph:" + graphsToConnect[i] + ". Errors:" + dojo.toJson(errors, true));
                        }
                        graphsFailed.push(graphsToConnect[i]);
                    }
                    if (graphsConnected.length + graphsFailed.length == graphsToConnect.length) {
                        calledBack = true;
                        callback(status, graphsFailed);
                    }
                }})(i));
            }
            
            setTimeout(function() {
                if (calledBack) {
                    return;
                }
                if (graphsConnected.length + graphsFailed.length < graphsToConnect.length) {
                    var failed = [];
                    for (var i=0;i<graphsToConnect.length;i++) {
                        if (!anzo.utils.arrayContains(graphsToConnect[i],graphsConnected)) {
                            failed.push(graphsToConnect[i]);
                        }
                    }
                    if (log.isInfoEnabled()) {
                        log.info("connect - Timeout for connecting graphs expired. Graphs failed to connect:" + dojo.toJson(graphsFailed));
                    }
                    calledBack = true;
                    callback(status,failed);
                }
                // pretty arbitrary timeout, we'll have to tweak this.
            },1000 + 1000 * graphsToConnect.length);
            
        }));
    },
    
    _onJMSClientDisconnectInAnzoClient : function _onJMSClientDisconnectInAnzoClient() {
        log.debug("_onJMSClientDisconnectInAnzoClient - AnzoClient connection lost.");

        this._disconnectInternal();

        this.clientDisconnected();
    },
    
    getReplicaGraph : function(uri, args, callback) {
        // summary: Gets the graph with the given URI. The graph is returned as an argument in the callback.
        // uri: String | anzo.rdf.URI
        //   URI that specifies the name of the graph.
    	// args: ?Object
    	//   Optional arguments:
    	//      -create: Create the graph if it doesn't exist, true by default
    	//      -namedGraphInitializers: Initializes newly created graphs.
        // callback: Function
        //   Callback called once the graph has been replicated. The first argument of the callback
        //   contains an the graph as an instance of anzo.client.ClientGraph. If there was a problem
        //   obtaining the graph, then the first argument is null and the second argument to the callback
        //   contains error information.
    	// create: Create the graph if it doesn't exist, true by default
    	if(!args)
    		args = {};
    	
    	if (args.create == null)
    		args.create = true;
    	
        this.getReplicaGraphs([uri], args, function _getReplicaGraphsCallback(graphMap, errors) {
            var graph = graphMap[uri] === undefined ? null : graphMap[uri];
            if (callback) {
                callback(graph, errors);
            }
        });
    },
    
    getReplicaGraphs : function(uris, args, callback) {
        // summary: Gets all of the graphs specified by the given URIs. The graphs are returned as an argument in the callback.
        // uris: anzo.rdf.URI[] | String[]
        //   Array of URIs, each specifying the name of the graph.
        // args: ?Object
    	//   Optional arguments:
    	//      -create: Create the graph if it doesn't exist, true by default
    	//      -namedGraphInitializers: Initializes newly created graphs.
    	// callback: Function
        //   Callback called once the graphs have been replicated. The first argument of the callback
        //   contains an object which maps the graph URI to the graph instance of anzo.client.ClientGraph.
        //   If there was a problem obtaining a graph, then the value for the URI property will be 'undefined'. The 
        //   second argument to the callback contains error information if there were any errors.
    	
    	if(!args)
    		args = {};
    	
    	var create                 = args.create == null ? true : args.create;
    	var namedGraphInitializers = args.namedGraphInitializers;
    	
    	if (this._closed) {
            callback(null, new Error("AnzoClient is closed."));
            return;
        }

        if(!dojo.isArray(uris)) {
            throw Error("Invalid argument: uris argument must be an Array");
        }
        
        var graphsToGet = [];
        var replicaGraphs = {};
        for (var i = 0; i < uris.length; i++) {
            var uri = anzo.rdf.getValue(uris[i], {type: 'uri'});
            replicaGraphs[uri] = null;
            var graph = this.graphTable.get(uri);

            if (graph && (graph._connected || !this.connected)) {
                if (log.isDebugEnabled()) {
                    log.debug("getReplicaGraphs - graph returned immediately because either anzoClient is not connected or the graph is already connected:" + uri);
                }
                replicaGraphs[uri.toString()] = graph; 
            } else {
                graphsToGet.push(uri);
                if (graph) {
                    this.graphTable.release(uri); // Release this here since we'll be adding another reference when we actually get/connect the graph below.
                }
                if (log.isDebugEnabled()) {
                    log.debug("getReplicaGraphs - graph going to be downloaded from server:" + uri);
                }
            }
        }

        if (!this.connected) {
            log.debug("Not connected to server so creating graphs locally.");
            if (create) { // if we aren't connected, only defer getting graphs if we want to create them. 
            	          // the behavior would be too murky otherwise.
	            for (var i = 0; i < graphsToGet.length; i++) {
	                var uri = graphsToGet[i];
	                var metadataGraphUri = anzo.utils.UriGenerator.getMetadataGraphUri(uri);
	                var metadataGraph = new anzo.client.MetadataGraph(metadataGraphUri, this.transactionProxy);
	                graph = new anzo.client.ClientGraph(uri, this.transactionProxy, metadataGraph, this);
	                // we have to initialize the graph because if we close it before we connect, the graph
	                // will never be created on the server.
	                this._initializeNamedGraphInTransaction(graph, true, namedGraphInitializers);
	                graph._namedGraphInitializers = namedGraphInitializers;
	                this.graphTable.put(uri, graph);
	                replicaGraphs[uri.toString()] = graph;
	            }
            }
            callback(replicaGraphs, null);
            return;
        }

        if (graphsToGet.length == 0) {
            if (log.isDebugEnabled()) {
                log.debug("No graphs to get. All graphs either already exist in replica or no graphs were requested: uris.length" + uris.length);
            }
            callback(replicaGraphs, null);
            return;
        }

        var callbacks = null;
        var callbackAggregateUri = null;
        // An optimization to avoid making duplicate calls to the server. If you are asking for just one graph,
        // then we'll check if that graph has recently been asked for (the request is already en-route to the server).
        // If so, we'll just add you to the list of callbacks to call when the server returns.
        // We only do this for the case of once graph because then the callbacks are actually interchangable and
        // it's simple and efficient to determine if we've already made a call for the same graph when there's only one.
        if (uris.length == 1) {
            callbackAggregateUri = uris[0].toString();
            callbacks = this.getReplicaGraphCalls[callbackAggregateUri];
            if (callbacks) {
                if (log.isDebugEnabled()) {
                    log.debug("Already a getReplicaGraph call in progress for graph " + uri + ". Adding to list of callbacks rather than repeating the network request.");
                }
            	callbacks.push(callback);
            	return;
            } else {
            	callbacks = [];
            	this.getReplicaGraphCalls[callbackAggregateUri] = callbacks;
            	callbacks.push(callback);
            }
        }

        // NOTE: any graphs that don't actually exist on the server will simply be ignored by the replicate call on the server.
        this.replicator._replicateToQuadStore(graphsToGet, dojo.hitch(this, function(success, errors) {
            if (!success) {
                if (log.isDebugEnabled()) {
                    log.debug("Error dring replication for getReplicaGraphs:" + dojo.toJson(errors, true));
                }
                if (callbackAggregateUri) {
                    var callbacks = this.getReplicaGraphCalls[callbackAggregateUri];
                    if (log.isDebugEnabled()) {
                        log.debug("Calling aggregated callbacks. Count:" + callbacks.length + ". uri:" + callbackAggregateUri);
                    }
                    delete this.getReplicaGraphCalls[callbackAggregateUri];
                	for (var i = 0; i < callbacks.length; i++) {
                    	callbacks[i]({}, errors);
                	}
                    return;
                } else {
                    callback(replicaGraphs, errors);
                    return;
                }
            }
            
            var graphsToSubscribe = [];
            var uuidsToSubscribe = [];
            for (var i = 0; i < graphsToGet.length; i++) {
                var uri = graphsToGet[i];
                var metadataGraphUri = anzo.utils.UriGenerator.getMetadataGraphUri(uri);

                var stmts = this.quadStore.find(null, null, null, metadataGraphUri);
                var createNew = !stmts || stmts.length == 0;
                if (log.isDebugEnabled()) {
                    log.debug("Is graph new on the server? createNew:" + createNew + " stmts.length:" + (stmts ? stmts.length : 0));
                }
                
                if (createNew && !create) {
                	continue;
                }
                
                var graph = this.graphTable.get(uri);
                if (!graph) {
                    if (log.isDebugEnabled()) {
                        log.debug("Creating graph and metadata graph objects and adding to graph table: " + uri);
                    }
                    var metadataGraph = new anzo.client.MetadataGraph(metadataGraphUri, this.transactionProxy);
                    graph = new anzo.client.ClientGraph(uri, this.transactionProxy, metadataGraph, this);
                    this.graphTable.put(uri, graph);
                }
                
                
                if (createNew) {
                    // If the graph is new (not yet on the server), we've got nothing much else to do other than finish up.
                    this.newGraphs[uri] = metadataGraphUri;
                    this._initializeNamedGraphInTransaction(graph, true, namedGraphInitializers);
                    graph._connected = true;
                } else {
                    graphsToSubscribe.push(graph);
                    var uuidStmts = graph.metadataGraph.find(graph.namedGraphUri, anzo.client.Vocabulary.uuidProperty, null);
                    var uuidStmt = uuidStmts[0];
                    var uuid = uuidStmt.object;
                    uuidsToSubscribe.push(uuid);
                }
                replicaGraphs[uri] = graph;
            }
            
            if (callbackAggregateUri) {
                var callbacks = this.getReplicaGraphCalls[callbackAggregateUri];
                if (log.isDebugEnabled()) {
                    log.debug("Calling aggregated callbacks. Count:" + callbacks.length + ". uri:" + callbackAggregateUri);
                }
                delete this.getReplicaGraphCalls[callbackAggregateUri];
                for (var i = 0; i < callbacks.length; i++) {
                	callbacks[i](replicaGraphs, null);
                }
            } else if(callback) {
                if (callback) {
                    callback(replicaGraphs, null);
                }
            }
            
            // Now subscribe to the graph update topics for any graphs that are already on the server.
            // NOTE: We've already called the callback at this point. It is possible that the caller will
            // change some of these graphs locally and call updateRepository before the subscription to the graph
            // is complete. In the worst, case, that means that such an updateRepository call will miss the
            // the graph update messages for those changes (since we may not subscribe in time). In that case,
            // the updateRepository will simply timeout and do a 'replicate' call internally. So a possible
            // side effect of doing an updateRepository concurrently with this topic registration is that the
            // updateRespository takes much longer than it otherwise would. 
            if (this._closed) {
                log.debug("AnzoClient is closed before getting a change to subscribe to graph update messages. So not attempting to subscribe.");
                return;
            }
            this.namedGraphUpdateManager.addNamedGraphUpdateTopics(uuidsToSubscribe, dojo.hitch(this, function(success, missingSubscriptions, errorInfo) {
                if (this._closed) {
                    log.debug("Done subscribing to graph update topics but AnzoClient is now closed. So doing nothing.");
                    return;
                }
                
                if (!success && log.isWarnEnabled()) {
                    log.warn("Error subscribing to graph update topics. This may cause delays in receiving updates from the server.\nmissingSubscriptions:\n" + dojo.toJson(missingSubscriptions, true) + "\nerrorInfo:\n" + dojo.toJson(errorInfo, true));
                } else {
                    if (log.isDebugEnabled()) {
                        log.debug("Added subscription to graph topics. uuidsToSubscribe.length:" + uuidsToSubscribe.length);
                    }
                }

                // Mark the graphs as connected
                for (var i = 0; i < graphsToSubscribe.length; i++) {
                    var graph = graphsToSubscribe[i];
                    this._initializeNamedGraphInTransaction(graph, false, namedGraphInitializers);
                    graph._connected = true;
                }
                
                
            }));
        }));
    },
    
    _initializeNamedGraphInTransaction : function(graph, createNew, namedGraphInitializers) {
        if (!this.inTransaction()) {
            this.begin();
            try {
                this._initializeNamedGraph(graph, createNew, namedGraphInitializers);
                this.commit();
            } catch (e) {
                this.abort();
                throw (e);
            } 
        } else {
            this._initializeNamedGraph(graph, createNew, namedGraphInitializers);
        }
    },
    
    _initializeNamedGraph : function(graph, createNew, namedGraphInitializers) {
        
        for (var i=0;i<this.defaultGraphInitializers.length;i++) {
            this.defaultGraphInitializers[i].initializeNamedGraph(graph, createNew);
            
            if (this.defaultGraphInitializers[i].getPreconditions) {
            	var preconditions = this.defaultGraphInitializers[i].getPreconditions();
            	if (!this.transactionQueue.currentTransaction.preconditions) {
            		this.transactionQueue.currentTransaction.preconditions = preconditions;
            	} else {
            		for (var j=0;j<preconditions.length;j++) {
            			this.transactionQueue.currentTransaction.preconditions.push(preconditions[j]);
            		}
            	}
            }
        }
        
        if (namedGraphInitializers) {
            for (var i=0;i<namedGraphInitializers.length;i++) {
                namedGraphInitializers[i].initializeNamedGraph(graph, createNew);
                
                if (namedGraphInitializers[i].getPreconditions) {
	            	var preconditions = namedGraphInitializers[i].getPreconditions();
	            	if (!this.transactionQueue.currentTransaction.preconditions) {
	            		this.transactionQueue.currentTransaction.preconditions = preconditions;
	            	} else {
	            		for (var j=0;j<preconditions.length;j++) {
	            			this.transactionQueue.currentTransaction.preconditions.push(preconditions[j]);
	            		}
	            	}
	            }
            }
        }    	
        
    },
    
    begin : function(preconditions) {
        // summary: Begins a new transaction.
        // preconditions: anzo.client.Precondition[]
        //  Optional array of preconditions that must pass for the transaction not to fail.
        
        if (this._closed) {
            throw new Error("AnzoClient is closed.");
        }
        this.transactionQueue.begin(preconditions);
    },
    
    commit : function() {
        // summary: End the current transaction.
        
        if (this._closed) {
            throw new Error("AnzoClient is closed.");
        }
        this.transactionQueue.commit();
        if (this.updateRepositoryOnCommit) {
            this.updateRepository();
        }
    },
    
    abort : function() {
        // summary: Abort the current transaction.
        
        if (this._closed) {
            throw new Error("AnzoClient is closed.");
        }
        this.transactionQueue.abort();
    },
    
    inTransaction : function() {
        // summary: Checks if the AnzoClient has a transaction open. That is, 'begin' was called and 'commit' or 'abort' hasn't yet been called.
        // returns: Boolean
        //   True if in a transaction, false otherwise.
        
        if (this._closed) {
            throw new Error("AnzoClient is closed.");
        }
        return this.transactionQueue.inTransaction();
    },
    
    getTransactionContext : function() {
        if (this._closed) {
            throw new Error("AnzoClient is closed.");
        }
        return this.transactionQueue.getTransactionContext();
    },
    
    reset : function(statements, callback) {
        // summary: Removes all existing RDF from the repository and replaces it with the given statements.
        // statements : anzo.rdf.Statement[]
        //   Array of statements that are added to the repository after it is cleared.
        // callback : Function
        //  Optional method that is called upon completion.

        if (this._closed) {
            callback(false, new Error("AnzoClient is closed."));
            return;
        }
        this.resetService.reset(statements, callback);
    },
    
    replicate : function(callback) {
        if (this._closed) {
            callback(false, new Error("AnzoClient is closed."));
            return;
        }
        this.replicator.replicate(callback);
    },
    
    updateRepository : function() {
        // summary: Synchronizes this AnzoClient with the server by uploading all changes and downloading the latest
        //   version of any graphs being watched via replica graphs. 
        // description: The updateRepositoryComplete method is called upon completion.  One can register listeners to the 
        //   updateRepositoryComplete method by using dojo's connect method:
        //   | var handle = dojo.connect(datasetService, 'updateRepositoryComplete', function(success, errors) { <DO SOMETHING> });
        //   To disconnect:
        //   | dojo.disconnect(handle);

        if (this._closed) {
            throw new Error("AnzoClient is closed.");
        }
        this.replicator.update();
    },
    
    serverQuery : function(defaultNamedGraphs, namedGraphs, namedDatasets, query, baseUri, callback, options) {
        // summary: Sends asynchronous SPARQL query requests to the server.
        // defaultNamedGraphs: Array 
        //      List of named graph URIs that identify the graphs that will be merged to form the default graph in the query's RDF Dataset
        // namedGraphs: Array 
        //      List of named graph URIs that identify the named graph components of the query's RDF Dataset
        // namedDatasets: Array 
        //      List of named datasets URIs that identify the named datasets components of the query
        // query: String 
        //      The SPARQL query that is to be executed.
        // baseUri : String
        //      The base URI against which relative URI references in the query are resolved
        // callback: Function(result, success, errors)
        //      Called with the result set object (SPARQL result set as a javascript object) upon completion of the operation.
        //      For SELECT and ASK queries, the results are returned in the JSON SPARQL Query Results serialization as
        //      documented at http://www.w3.org/TR/rdf-sparql-json-res/. For CONSTRUCT queries, the result is an
        //      anzo.rdf.NamedGraph object containing the constructed graph. The namedGraphUri of the result graph for 
        //      CONSTRUCT queries will be a random URI.
        //      WARNING: For SELECT and ASK queries, do not modify the result object or its contents. Otherwise 
        //      the value in the cache will be affected and incorrect results to future queries may be returned.
        // options: Object
        //      Optional. Contains various optional parameters for the query request.  Including
        //      timeout: Number
        //           Amount of time in milliseconds after which the client will stop waiting for the query response and
        //           call the callback with a timeout error. -1 denotes an infinite timeout. The default timeout is -1
        //           regardless of other global timeout default settings.
    	//      priority: Number
    	//           The relative priority of this request.  No guarantees are made about how the server will handle the priority
    	//           but may be used by the client to advise the server.  
    	//      datasource: URI
    	//           The datasource to issue query requests against.  
        if (this._closed) {
            callback(null, false, new Error("AnzoClient is closed."));
            return;
        }
        this.queryService.query(defaultNamedGraphs, namedGraphs, namedDatasets, query, baseUri, callback, options);
    },

    serverQueries : function(queries) {
        // summary: Sends multiple asynchronous SPARQL query requests to the server at once.
        // queries: Array 
        //      An Array of Objects where each object fully specifies all of the parameters for the query.
        //      The parameters are all of those taken by the 'serverQuery' method. 
        //      Specifically, the objects may have the following properties:
        //      defaultNamedGraphs, namedGraphs, namedDatasets, query, baseUri, callback, options.
        //      See the documentation of the 'serverQuery' method for information about each property.
        if (this._closed) {
            callback(null, false, new Error("AnzoClient is closed."));
            return;
        }
        this.queryService.queryBatch(queries);
    },
    
    serverFind : function(subject, predicate, object, namedGraphUri, callback) {
        // summary: Finds statements that match the given pattern by directly querying server
        //  state rather than the replica state.
        // description: This method can be used to query a graph directly on the server. Note that
        //   any statements added and removed on local replicas will not be reflected on the server
        //   until updateRepository is called.
        // subject : String | anzo.rdf.Resource | null
        //  Subject value to match, or wildcard if null
        // predicate : String | anzo.rdf.URI | null
        //   Predicate value to match, or wildcard if null
        // object : Object | anzo.rdf.Value | null
        //  Object value to match, or wildcard if null
        // namedGraphUris : String | anzo.rdf.URI | anzo.rdf.INamedGraph | String[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]
        //  Array of uris used to match the named graph parameter of statements, or wildcard if null

        if (this._closed) {
            callback(null, false, new Error("AnzoClient is closed."));
            return;
        }
        this.modelService.findStatements(subject, predicate, object, namedGraphUri, callback);
    },
    
    replicaFind : function(subject, predicate, object, namedGraphUris) {
        // summary: Find set of statements that match provided parameters.
        // description: This method executes against the locally cached statements only.
        // subject : String | anzo.rdf.Resource | null
        //  Subject value to match, or wildcard if null
        // predicate : String | anzo.rdf.URI | null
        //   Predicate value to match, or wildcard if null
        // object : Object | anzo.rdf.Value | null
        //  Object value to match, or wildcard if null
        // namedGraphUris : String | anzo.rdf.URI | anzo.rdf.INamedGraph | String[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]
        //  Array of uris used to match the named graph parameter of statements, or wildcard if null
        // returns: An array of matching statements.
        
        if (this._closed) {
            throw new Error("AnzoClient is closed.");
        }
        return this.transactionProxy.find(subject, predicate, object, namedGraphUris);
    },
    
    getNamedGraphRevision : function(namedGraphUri, revision, callback) {
        // summary: Retrieves an entire graph at a particular revision. This is useful for working with old versions of graphs.
        // namedGraphUri: String | anzo.rdf.URI. The graph to retrieve.
        // revision: Number. The revision of the graph to retrieve.

        if (this._closed) {
            callback(null, false, new Error("AnzoClient is closed."));
            return;
        }
        this.modelService.getNamedGraphRevision(namedGraphUri, revision, function(stmts, success, error) {
            if (!success) {
                callback(null, success, error);
            } else {
                var quadStore = new anzo.rdf.QuadStore();
                quadStore.add(stmts);
                var metastmts = quadStore.find(namedGraphUri, anzo.client.Vocabulary.hasMetadataGraphProperty, null, null);
                if (!metastmts || metastmts.length < 1) {
                    callback(null, false, "No metadata graph found in statements");
                    return;
                }
                var metadataGraphUri = metastmts[0].object;
                var metadataGraph = new anzo.client.MetadataGraph(metadataGraphUri, quadStore);
                var namedGraph = new anzo.rdf.AnzoGraph(namedGraphUri, quadStore, metadataGraph);
                callback(namedGraph, true);
            }
        });
    },
    
    containsNamedGraph : function(namedGraphUri, callback) {
        if (this._closed) {
            callback(null, false, new Error("AnzoClient is closed."));
            return;
        }
        
    	this.modelService.containsNamedGraph(namedGraphUri, callback);
    },

    getRealtimeUpdates : function() {
        if (this._closed) {
            throw new Error("AnzoClient is closed.");
        }
        dojo.deprecated("anzo.client.AnzoClient.getRealtimeUpdates()", "This method is deprecated. Use the 'realtimeUpdates' property instead.");
        return this.realtimeUpdates;
    },
    
    executeService : function(operationUri, statements, callback, timeout) {
    	// summary: execute a semantic service on the server
    	// operationUri: the URI of the operation to execute
    	// statements: the statements to pass to the semantic service
    	// callback: the function to call when the service execution is complete
    	//   of the form function(statements, success, error)
        // timeout: Number
        //      Optional. Amount of time in milliseconds after which the client will stop waiting for the service response and
        //      call the callback with a timeout error. -1 denotes an infinite timeout. The default timeout is -1.  
        if (this._closed) {
            callback(null, false, new Error("AnzoClient is closed."));
            return;
        }
    	this.executionService.executeService(operationUri, statements, callback, timeout);
    },
    
    getStatementChannel : function (uri, callback, statementchannelreadycallback, namedGraphInitializers) {
    	// summary: create a statement channel for the given uri
    	// callback: function(channel, error)
        if (this._closed) {
            callback(null, new Error("AnzoClient is closed."));
            return;
        }
        if (namedGraphInitializers == null) {
        	namedGraphInitializers = [];
        }
       	namedGraphInitializers.push(this.getStatementChannelGraphInitializer());
        var statementChannelGraph = null;
		var handle = dojo.connect(this, "transactionComplete", function(transactionURI, transactionTimestamp, transactionGraphs, transactionContext) {
			if (transactionContext) {
				if (transactionContext.contains(uri)) {
					if (statementChannelGraph){
						var channel = new anzo.client.StatementChannel(statementChannelGraph, uri, this);
	   					statementchannelreadycallback(channel);
					}						
		       		dojo.disconnect(handle);
				}
			}
		});

        this.begin();
        this.getTransactionContext().add(anzo.createStatement(uri, uri, uri, uri));
    	this.getReplicaGraph(uri, {create: true, namedGraphInitializers: namedGraphInitializers }, dojo.hitch(this,function(graph, error) {
    		if (error) {
    			callback(false, error);
    		} else {
   				this.commit();
   				statementChannelGraph = graph;
   				callback(true, null);
    		}
    	}));
    },

    _disconnectInternal : function() {
        // summary: Do most of the state manipulation of a disconnect but don't actually affect the
        //   JMSClient. The caller will take care of that.
        // description: Cleanup the AnzoClient state to about the point it is right after the constructor runs
        //   except we keep any existing graphs and data in the replica as if it had been added immediately
        //   after the constructor and before calling 'connect'.
          
        if (!this.connected) {
            log.warn("AnzoClient already disconnected.");
        }

        this.connected = false;
        dojo.disconnect(this._jmsClientDisonnectEventHandle);
        this._jmsClientDisonnectEventHandle = null;

        this.userRoles = null;
        this.isSysadmin=null;
        
        // Mark all of the graphs as disconnected.
        for (var uri in this.graphTable.table) {
            var graph = this.graphTable.table[uri].graph;
            graph._connected = false;
        }
    },
    
    disconnect : function(callback) {
        // summary: Disconnect from the server.
        // description: This removes the connection to the server which means that the AnzoClient
        //   will behave as if it had just been created before the connect method. The data and graphs
        //   in the local replica are maintained but won't be kept up to date. New replica graphs created
        //   won't have the latest data from the server either. You can reconnect to the server by calling
        //   'connect' again.
        
        if (this._closed) {
            callback(null, new Error("AnzoClient is closed."));
            return;
        }
        this._disconnectInternal();
        this.realtimeUpdates._disconnect(dojo.hitch(this, function onRealtimeUpdateManagerDisconnect(success, errors) {
            if (!success && log.isWarnEnabled()) {
                log.warn("Error disconnecting real-time update manager:" + dojo.toJson(errors, true));
            }
            anzo.messaging.JMSClient.disconnect(dojo.hitch(this, function(status) {
                this.clientDisconnected();
                if (callback) {
                    callback(status);
                }
            }));
        }));
    },
    
    isClosed : function() {
        // summary: Get whether this graph is closed.
        // returns: Returns true if close has been called on this AnzoClient instance. Returns false otherwise.
        return this._closed;
    },
    
    close : function(callback) {
        // summary: Closes this AnzoClient. This should be called to release resources once the AnzoClient is no longer needed.
        //  It will also close any replicaGraphs and other such resources obtained from this AnzoClient.
        // callback : Function
        //   Optional function that is called upon completion of the close operation.

        if (this._closed) {
            log.debug("already closed.");
            return;
        }
        
        this._closed = true;
        
        // Cleanup any circular references (such as event handlers, etc.) that we may have so that
        // things are properly garbage collected.
        this.connected = false;
        dojo.disconnect(this._jmsClientDisonnectEventHandle);
        var realtimeManager = this.realtimeUpdates; // Save this to call close on it later.

        // Close all of the graphs in the graph table
        for (var uri in this.graphTable.table) {
            var graph = this.graphTable.table[uri].graph;
            graph.close();
        }
        this.graphTable = null;
        this.newGraphs = null;
        this.updateService = null;
        this.replicationService = null;
        this.queryService = null;
        this.resetService = null;
        this.modelService = null;
        this.executionService = null;
        this.authorizationService = null;
        this.transactionQueue = null;
        this.quadStore = null;
        this.transactionProxy = null;
        this.replicator = null;
        this.replicaUpdater = null;
        this.namedGraphUpdateManager = null;
        this.defaultGraphInitializers = null;
        this.getReplicaGraphCalls = null;
        this.realtimeUpdates = null;
        this.userRoles = null;
        this.isSysadmin=null;
        
        realtimeManager._close(dojo.hitch(this, function onRealtimeUpdateManagerDisconnect(success, errors) {
            if (!success && log.isWarnEnabled()) {
                log.warn("Error closing real-time update manager:" + dojo.toJson(errors, true));
            }
            anzo.messaging.JMSClient.disconnect(dojo.hitch(this, function(status) {
                this.clientDisconnected();
                if (callback) {
                    callback(status);
                }
            }));
        }));
    },
    
    canReadNamedGraph : function(namedGraphUri, callback) {
        if (this._closed) {
            callback(null, false, new Error("AnzoClient is closed."));
            return;
        }
    	this._getGraphPermission(namedGraphUri,"READ",callback);
    },
    
    canAddToNamedGraph : function(namedGraphUri, callback) {
        if (this._closed) {
            callback(null, false, new Error("AnzoClient is closed."));
            return;
        }
    	this._getGraphPermission(namedGraphUri,"ADD",callback);
    },
    
    canRemoveFromNamedGraph : function(namedGraphUri, callback) {
        if (this._closed) {
            callback(null, false, new Error("AnzoClient is closed."));
            return;
        }
    	this._getGraphPermission(namedGraphUri,"REMOVE",callback);
    },
    
    _getGraphPermission : function(namedGraphUri, privilege, callback) {
    	if(this.isSysadmin) {
    		callback(true, true);
    		return;
    	}
    	this.authorizationService.getRolesForGraph(namedGraphUri, privilege, dojo.hitch(this, function(roleUris, success, error) {
            if (!success) {
                callback(false, false, error);
            } else {
                var found = false;
                for (var i=0;i<roleUris.length;i++) {
                	if (this.userRoles.contains(roleUris[i])) {
                		found = true;
                	}
                }
                callback(found, true);
            }
        }));
    },
    
    _getGraphUriFromUuid : function _getGraphUriFromUuid(uuid) {
        // summary: Resolves the UUID in the given string into its corresponding graph URI.
        // uuid: String. A graph UUID.
        // description: The resolution of the UUID will only work for graphs that exist in this
        //   AnzoClient's local replicas. Any UUID not found in the local replica will be ignored.
        // returns: anzo.rdf.URI. The corresponding graph URI or null if it is unknown.
        var ret = null;
        var stmts = this.quadStore.find(null, anzo.client.Vocabulary.uuidProperty, uuid, null);
        if (stmts && stmts.length > 0) {
            var stmt = stmts[0];
            ret = stmt.subject;
        }
        return ret;
    },

    // event hooks
    
    replicationComplete : function(success, errors) {
        // summary: Called upon completion of each replication.
        // success: Boolean
        //  True if replication was successful, false otherwise.
        // errors: The errors object contain raw information about errors that may have
        //   happened suring replication. This is opque debugging data mainly. Rendering
        //   as a JSON string is recommended.
    },
    
    updateRepositoryComplete : function(success, errors) {
        // summary: Called upon completion of each update.
        // success: Boolean
        //  True if update was successful, false otherwise.
        // errors: The errors object contain raw information about errors that may have
        //   happened during update. This is opque debugging data mainly. Rendering
        //   as a JSON string is recommended.

    	log.debug("updateRepositoryComplete event fired.");
    },
    
    transactionComplete : function(transactionURI, transactionTimestamp, transactionGraphs, transactionContext) {
        // summary: called upon completion of a transaction involving graphs in the local replica.
        // transactionURI: the uri of the completed transaction
        // transactionTimestamp: the time on the server when the transaction was committed. In milliseconds since the epoch. 
        // transactionGraphs: the graphs involved in the transaction, an array of URI
        // transactionContext: an IQuadStore containing context statements for the transaction and subtransactions
    },
    
    transactionFailed : function(transactionURI, transactionGraphs, transactionContext, errors) {
        // summary: called upon failure of a transaction submitted from this client.
        // transactionURI: the uri of the completed transaction
        // transactionGraphs: the graphs involved in the transaction, an array of URI
        // transactionContext: an IQuadStore containing context statements for the transaction and subtransactions
    },
    
    clientConnected : function() {
        // summary: Called when the client successfully connects to a server.
    },

    clientDisconnected : function() {
        // summary: Called when the client is disconnected from the server, including both when the client is
        //   gracefully disconnected vi the 'disconnect' or 'close methods as well as when the connection is lost
        //   due to a network or server failure.
    },
    
    // named graph initializers
    
    baseInitializer : {
    	
    	initializeNamedGraph : function(graph, createNew) {
	        if (createNew) {
	            var _uri = graph.namedGraphUri;
	            if (!graph.metadataGraph.contains(_uri, anzo.client.Vocabulary.hasMetadataGraphProperty, graph.metadataGraph.namedGraphUri)) {
	                graph.metadataGraph.add(_uri, anzo.client.Vocabulary.hasMetadataGraphProperty, graph.metadataGraph.namedGraphUri);
	            }
	            graph.metadataGraph.add(_uri, anzo.rdf.vocabulary.RDF.type, anzo.client.Vocabulary.namedGraphType);
	        }
    	}
    	
    },
    
    getRevisionedGraphInitializer : function(revisioned) {
        return {
	        initializeNamedGraph : function(graph, createNew) {
	            if (createNew) {
	                var _uri = graph.namedGraphUri;
	                var rev = anzo.createTypedLiteral(revisioned,anzo.rdf.vocabulary.XMLSchema.xsBoolean);
	                if (!graph.metadataGraph.contains(_uri, anzo.client.Vocabulary.revisionedProperty, rev)) {
	                    graph.metadataGraph.add(_uri, anzo.client.Vocabulary.revisionedProperty, rev);
	                }
	            }
        	}
        };
    },
    
    getStatementChannelGraphInitializer : function() {
    	return {
	        initializeNamedGraph : function(graph, createNew) {
	            if (createNew) {
	                var _uri = graph.namedGraphUri;
	                if (!graph.metadataGraph.contains(_uri, anzo.rdf.vocabulary.RDF.type, anzo.client.Vocabulary.statementStreamType)) {
	                    graph.metadataGraph.add(_uri, anzo.rdf.vocabulary.RDF.type, anzo.client.Vocabulary.statementStreamType);
	                }
	            }
        	}
    	}
    },
    
    getGraphMustExistInitializer : function(mustExist) {
    	return {
    		
    		initializeNamedGraph : function(graph, createNew) {
	            this.graph = graph;
        	},
    		
	        getPreconditions : function() {
                var askQueryString = "ASK  { <" + this.graph.namedGraphUri + "> <" + anzo.rdf.vocabulary.RDF.type + "> <" + anzo.client.Vocabulary.namedGraphType + ">}";
                var askResult = mustExist;
                var defaultGraphUris = [anzo.client.Vocabulary.allMetadataGraphsUri];
                var namedGraphUris = [];
                var precondition = new anzo.client.Precondition(askQueryString, askResult, namedGraphUris, defaultGraphUris);
                return [precondition];   
        	}
        };
    	
    },
    
    createReplicaDataset : function(persisted, datasetUri, defaultGraphUris, namedGraphUris, callback) {
        if (this._closed) {
            callback(null, new Error("AnzoClient is closed."));
            return;
        }
        log.debug("creating AnzoClientDataset");
        var d = new anzo.client.AnzoClientDataset(this, datasetUri, anzo.client.REPLICA, persisted, defaultGraphUris, namedGraphUris);
        log.debug("created AnzoClientDataset");

        if(d.isLoaded) {
            log.debug("dataset is loaded");
            callback(d);
        } else {
            log.debug("dataset is NOT loaded yet, connecting to onLoad event.");
            var h = dojo.connect(d, 'onLoad', null, function() {
                dojo.disconnect(h);
                log.debug("Got dataset onLoad event.");
                callback(d);
            });
        } 
    },
    
    getAllReplicaGraphsDataset : function() {
        if (this._closed) {
            throw new Error("AnzoClient is closed.");
        }
        return this.graphTable.getDataset();
    }
    
});

dojo.mixin(anzo.client, {
	
	OPTION_TIMEOUT                 : "timeout" ,
	OPTION_PRIORITY                : "priority" ,
	OPTION_DATASOURCE              : "datasource",
	OPTION_INCLUDE_METADATA_GRAPHS : "includeMetadataGraphs"
    
});

})();
