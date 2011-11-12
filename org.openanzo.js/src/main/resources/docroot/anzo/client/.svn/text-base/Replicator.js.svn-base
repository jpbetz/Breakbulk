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

dojo.provide("anzo.client.Replicator");

dojo.require("anzo.utils.Set");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.utils.UriGenerator");
dojo.require("anzo.log");

(function(){

var log = anzo.log.getLogger("anzo.client.Replicator");

dojo.declare('anzo.client.Replicator', null, {
    
    // summary: 
    //  
    
    constructor : function(anzoClient) {
        // summary: Initialization
        
        this.anzoClient	    = anzoClient;
        this.updating		= false;
        this.updatePending  = false;
        
        this.expectedTransactions = new anzo.utils.Set();
        this.receivedTransactions = new anzo.utils.Set();
        this.failedTransactions = new anzo.utils.Set();
        this.newGraphs 		      = {};
		
		this.receivedExpectedTransactions = false;
		this.updateRepositoryReturned = false;
        
		this._replicationTimeouts = 0; // Simply for investigating how many times this happens. Mainly a performance statistic.
    },
    
    update : function() {
        if (this.updating) {
            this.updatePending = true;
            return;
        } else {
            this.updating = true;
            this._update();
        }
    },
    
    _update : function() {
        var _this = this;
        var anzoClient = this.anzoClient;
        var queue = anzoClient.transactionQueue;
        // this traverses the transaction tree of each transactions, and flattens to a single transactions, 
        // at the same time organizing the additions and deletions by named graphs
        
        if (log.isDebugEnabled()) {
            log.debug("Queue length: " + queue.committedTransactions.length);
        }
        for (var j=0;j<queue.committedTransactions.length;j++) {
            log.debug("Checking if transaction is empty.");
            if (queue.committedTransactions[j].isEmpty()) {
                log.debug("Removing empty transaction from queue.");
                queue.committedTransactions.splice(j,1);
                j--;
            }
        }
        if (log.isDebugEnabled()) {
            log.debug("Queue length after filtering empty transactions: " + queue.committedTransactions.length);
        }        
        if (queue.committedTransactions.length == 0) {
            log.debug("empty transaction queue, finishing update");
            this.updating = false;
            this.anzoClient.updateRepositoryComplete(true, null);
            return;
        }
        
        var transactions = anzo.client.Serialization.writeTransactionsToJson(queue.committedTransactions);
        
        // for now, store the current set of transactions 
        // in a member variable
        this.transactions = transactions;
        // set of URI that will contain the set of failed transaction URIs
        this.failedTransactions.clear();
        // used in invoking transaction events
        this.transactionTimestamps = {};
        //this.transactionGraphRevisions = {};
        // used to invoke failed transaction events;
        this.errorMap = {};
        
        var updateId = anzo.utils.randomInt(10);
        this.updateId = updateId;
        
		this.receivedExpectedTransactions = false;
		this.updateRepositoryReturned = false;
		
        this.receivedTransactions.clear();
        this.expectedTransactions.clear();
        
        // map from namedGraphUri to metadataGraph uri
        this.newGraphs = anzoClient.newGraphs;
        this.anzoClient.newGraphs = {};
        
        // find the transactions that contain only new graphs so we know not to wait
        // for transaction events for them. Or conversely, find the list of "expected transactions"
        // which are any transaction that mentions a non-new graph for which we have a replica graph.

        // if we have no replica graphs then don't wait for the transaction
        var replicaGraphs = this.anzoClient.graphTable.table;
        
        var empty = true;
        for (var uri in replicaGraphs) {
            empty = false;
            break;
        }
        
        if (!empty) {
            
            var newGraphsArray = [];
            // add all named graph uris and metadata graph uris.
            for (var uri in this.newGraphs) {
                newGraphsArray.push(uri.toString());
                newGraphsArray.push(this.newGraphs[uri].toString());
            }
            
            for (var i=0; i<transactions.length;i++) {
                var transaction = transactions[i];
                
                if (!transaction.namedGraphs || transaction.namedGraphs.length == 0) {
                    continue;
                }
                var needed = false;
                for (var j=0;j<transaction.namedGraphs.length;j++) {
                    var update = transaction.namedGraphs[j];
                    var nguri = update.namedGraphUri;
                    if (replicaGraphs[update.namedGraphUri] && !anzo.utils.arrayContains(update.namedGraphUri.toString(),newGraphsArray)) {
                        needed = true;
                        break;
                    }
                }
                
                if (needed) {
                    this.expectedTransactions.add(transaction.transactionURI);
                }
               
            }
        }
        
        if (log.isDebugEnabled()) {
            log.debug("Expected transactions: " + dojo.toJson(this.expectedTransactions));
        }
        
        queue.committedAdditionsInTransit.add(queue.committedAdditions);
        queue.committedAdditions.clear();
        queue.committedDeletionsInTransit.add(queue.committedDeletions);
        queue.committedDeletions.clear();
        
        if (log.isDebugEnabled()) {
            log.debug("About to call updateService.updateServer. updateId:" + updateId);
        }
        anzoClient.updateService.updateServer(transactions, false, false, function(message, success, error) {
            if (log.isDebugEnabled()) {
                log.debug("In updateService.updateServer callback. updateId:" + updateId + " this.updateId:" + _this.updateId);
            }
            _this.updateRepositoryReturned = true;
            if (log.isDebugEnabled()) {
                log.debug("Expected transactions right after update: " + dojo.toJson(_this.expectedTransactions));
            }
            var errors = [];
            if (!success) {
                log.debug("UPDATE FAILED!");
                _this._completeUpdate(false, error);
            } else {
                
                queue.committedAdditionsInTransit.clear();
                queue.committedDeletionsInTransit.clear();
                
                for (var i=0;i<message.length;i++) {
                    
                    var transactionUri = transactions[i].transactionURI;
                    if (log.isDebugEnabled()) {
                        log.debug("NGU: " + message[i].namedGraphUpdates);
                    }
                    if (message[i].namedGraphUpdates) {
                        _this.transactionTimestamps[transactionUri] = message[i].timestamp;
                        if (_this.expectedTransactions.size() > 0) {
                            var namedGraphUpdates = message[i].namedGraphUpdates;
                            
                            if (namedGraphUpdates) {
                                var revs = anzo.client.Serialization.readNamedGraphRevisions(namedGraphUpdates);
                                if (log.isDebugEnabled()) {
                                    log.debug("REVS: " + dojo.toJson(revs,true));
                                }
                                if (!revs) {
                                    _this.expectedTransactions.remove(transactionUri);
                                }
                            } else {
                                _this.expectedTransactions.remove(transactionUri);
                            }
                        }
                    } else if (message[i].AnzoException) {
                        // Right now we just push the error onto to the array. 
                        // We could lineup the errors with the transactions, but
                        // that order will be fairly meaningless to the user catching the exception
                        errors.push(message[i]);
                        _this.failedTransactions.add(transactionUri);
                        _this.expectedTransactions.remove(transactionUri);  
                        // used to process the failed transaction event
                        _this.errorMap[transactionUri] = message[i].AnzoException;                      
                    } else {
                        if (log.isDebugEnabled()) {
                            log.debug("Skipping: transactionUri: "+transactionUri);
                        }
                        _this.expectedTransactions.remove(transactionUri);
                    }
                    
                    // remove the transaction from the queue since we know it has been processed
                    // (even if unsuccessfully) on the server
                    
                    for (var j=0;j<queue.committedTransactions.length;j++) {
                        if (transactionUri == queue.committedTransactions[j].transactionUri) {
                            queue.committedTransactions.splice(j,1);
                            j--;
                        }
                    }
                }
            }
            
            if (log.isDebugEnabled()) {
                log.debug("Expected transactions after update analysis: " + dojo.toJson(_this.expectedTransactions));
            }
            
            // we might have received named graph update messages
            // before the update callback is fired.
            if (_this.expectedTransactions.size() > _this.receivedTransactions.size() ) {
                if (log.isDebugEnabled()) {
                    log.debug("Waiting for expected transactions. updateId:" + updateId);
                }
                setTimeout(function() {
                    // Check that operation timing out is actually the current pending update operation. It's possible that the operation
                    // completed successfully and that a whole new one started by the time this timeout fires. This test here will neutralize
                    // this timeout such a situation.
                    if (log.isDebugEnabled()) {
                        log.debug("Inside waiting for transaction timeout handler (doesn't mean the operation timed out. checking that now). updateId:" + updateId + " this.updateId:" + _this.updateId);
                    }
                    if (updateId == _this.updateId) {
                        if (log.isInfoEnabled()) {
                            log.info("replicating select graphs due to timeout. updateId:" + updateId);
                        }
                        _this._replicationTimeouts++;
                        
                        // optimize by replicating only those graphs in transactions we can't wait for.
                        var absentTransactions = new anzo.utils.Set();
                        absentTransactions.addAll(_this.expectedTransactions);
                        absentTransactions.removeAll(_this.receivedTransactions);
                        var graphsToReplicate = new anzo.utils.Set();
                        for (var i=0; i<transactions.length;i++) {
                            var transaction = transactions[i];
                            if (absentTransactions.contains(transaction.transactionURI)) {
                                for (var j=0;j<transaction.namedGraphs.length;j++) {
                                    var update = transaction.namedGraphs[j];
                                    var nguri = update.namedGraphUri;
                                    graphsToReplicate.add(nguri);
                                }
                            }
                        }
                        
                        for (var uri in _this.newGraphs) {
							graphsToReplicate.add(uri);
						}
                        
                        // signal that this update is being finished off here so that while the replicate happens,
                        // more named graph update/transaction complete messages don't trigger another update
                        // completion
                        _this.updateId = -1;
                        
                        _this._replicateSelectGraphs(graphsToReplicate.toArray(), function (success, errors) {
                            _this._completeUpdate(success, errors);
                        });
                    } else {
                        if (log.isDebugEnabled()) {
                            log.debug("Update timeout timedout, but the updateId doesn't match so we are all good. updateId:" + updateId + " this.updateId:" + _this.updateId);
                        }
					}
                }, 2000);
            } else {
                if (log.isDebugEnabled()) {
                    log.debug("transactions: " + _this.expectedTransactions.size() + " " + _this.receivedTransactions.size());
                }
            	// check to make sure the update isn't already finished
            	if (_this.receivedExpectedTransactions || (_this.expectedTransactions.size() == _this.receivedTransactions.size())) {
	                if (updateId == _this.updateId) {
						log.debug("replicating only new graphs after update (no expected transactions, or all expected transactions have returned)");
						var found = false;
						for (var uri in _this.newGraphs) {
							found = true;
							break;
						}
						if (found) {
							log.debug("New graphs being replicated. Calling _replicateNewGraphs.");
							_this._replicateNewGraphs(_this.newGraphs, function(success, errors){
								_this._completeUpdate(success, errors);
							});
						}
						else {
							log.debug("No new graphs need to be replicated.");
							_this._completeUpdate(true, []);
						}
					} else {
						log.debug("UpdateID mismatch in update call stack...");
					}
            	} else {
					log.debug("Update returned but expected transactions have not been received yet");
				}
            }
        });
    },
    
    transactionComplete : function(transactionUri) {
    	var handled = false; // The function will return this value which indicates if firing anzoClient.transactionComplete event will be handled by this function for the given transaction. 
    	
        if (this.expectedTransactions.contains(transactionUri)) {
            var queue = this.anzoClient.transactionQueue;
            for (var j=0;j<queue.committedTransactions.length;j++) {
                if (transactionUri == queue.committedTransactions[j].transactionUri) {
                    queue.committedTransactions.splice(j,1);
                    j--;
                }
            }
            
            this.receivedTransactions.add(transactionUri);
            handled = true;
            
            if (this.expectedTransactions.size() == this.receivedTransactions.size()) {
				if (this.updateRepositoryReturned) {
					if (this.updateId != -1) {
						log.debug("replicating only new graphs (all updates received, and updateServer has already returned)");
		                // This next line signals that the update is being completed by this code.
						// This ensures that, if the update call hasn't yet completed, it's callback won't also try 
						// to complete the update once it gets called.
		                this.updateId = -1;
						var newGraphsIsEmpty = true;
						for (var uri in this.newGraphs) {
							newGraphsIsEmpty = false;
							break;
						}
						if (!newGraphsIsEmpty) {
							this._replicateNewGraphs(this.newGraphs, dojo.hitch(this, function(success, errors){
								this._completeUpdate(success, errors);
							}));
						}
						else {
							log.debug("no new graphs to replicate");
							this._completeUpdate(true, []);
						}
					} else {
						log.debug("Transactions received, but replicator already timed-out waiting...");
					}
				} else {
					log.debug("received all expected transaction, but update has not returned so cannot complete update yet");
					this.receivedExpectedTransactions = true;
				}
            }
        } else {
            if (log.isDebugEnabled()) {
                log.debug("Transaction received, but not expected: " + transactionUri);
            }
        }
        return handled;
    },
    
    _completeUpdate : function(success, errors) {
        
        // fire the transaction events for the transactions with with we were involved. 
        for (var i=0; i < this.transactions.length;i++) {
            var transaction = this.transactions[i];
            var transactionUri = transaction.transactionURI;
            
            var failed = this.failedTransactions.contains(transactionUri);
            
            var context = null;
            if (transaction.transactionContext) {
                context = new anzo.rdf.QuadStore();
                context.add(anzo.client.Serialization.readStatementsFromJson(transaction.transactionContext));
            }
            
            var namedGraphs = [];
            for (var j=0; j<transaction.namedGraphs.length; j++) {
                namedGraphs.push(transaction.namedGraphs[j].namedGraphUri);
            } 
        
            if (!failed) {
                var timestamp = this.transactionTimestamps[transactionUri];
                this.anzoClient.transactionComplete(transactionUri, timestamp, namedGraphs, context);
            } else {
                var errors = this.errorMap[transactionUri];
                this.anzoClient.transactionFailed(transactionUri, namedGraphs, context, errors);
            }
        }
        
        var uuidsToSubscribe = [];
        if (success) {
            
            var empty = true;
            for (var key in this.newGraphs) {
                empty = false;
                break;
            }
                        
            if (!empty) {
            	log.debug("Computing new graph subscriptions...");
                var candidates = new anzo.utils.Set();
                for (var i=0; i<this.transactions.length;i++) {
                    var tran = this.transactions[i];
                    candidates.add(tran.transactionURI);     			
                }
                
                // noted:  we used to also remove expected transactions from the
                // candidates, but by doing so we missed out on subscribing to 
                // new graphs that were part of an expected transaction that
                // also had existing graphs
                
                // if the transaction failed, then we won't be subscribing either
                candidates.removeAll(this.failedTransactions);

                // compute the set of all graphs received in transactions, that we aren't already
                // subscribed to.  We need to make sure we don't try to subscribe to a graph
                // that we tried to create only in a failed in a transaction 
                var candidateGraphs = new anzo.utils.Set();
                
                for (var i=0;i<this.transactions.length;i++) {
                    var tran = this.transactions[i];
                    if (candidates.contains(tran.transactionURI)) {
                        for (var j=0;j<tran.namedGraphs.length;j++) {
                            candidateGraphs.add(tran.namedGraphs[j].namedGraphUri);
                        }
                    }  			
                }
                
                for (var uri in this.newGraphs) {
                    if (!candidateGraphs.contains(uri.toString())) {
                        continue;
                    }
                    var stmts = this.anzoClient.quadStore.find(uri, anzo.client.Vocabulary.uuidProperty, null, null);
                    if (stmts && stmts.length > 0) {
                        var uuidStmt = stmts[0];
                        var uuid = uuidStmt.object;
                        if (log.isDebugEnabled()) {
                            log.debug("Subscribing to: " + uri);
                        }
                        uuidsToSubscribe.push(uuid);
                    } else {
                        if (log.isWarnEnabled()) {
                            log.warn("_completeUpdate - missing UUID in QuadStore for graph " + uri + " so cannot not subscribe to its graph update topic.");
                        }
                    }
                }
            }
        } else {
            log.debug("completeUpdate called with success as false");
        }
        this.anzoClient.namedGraphUpdateManager.addNamedGraphUpdateTopics(uuidsToSubscribe, dojo.hitch(this, function(suc, missingSubscriptions, err) {
            this.expectedTransactions.clear();
            this.receivedTransactions.clear();
            this.failedTransactions.clear();
            if (log.isDebugEnabled()) {    
                log.debug("Remaining transactions in queue: " + this.anzoClient.transactionQueue.committedTransactions.length);
            }    
            this.anzoClient.updateRepositoryComplete(success, errors);
            
            if (!this.updatePending) {
                this.updating = false;
            } else {
                this.updatePending = false;
                this._update();
            }
        }));
    },
    
    replicate : function(callback) {
        var namedGraphStatements = [];
        for (var uri in this.anzoClient.graphTable.table) {
            var graph = this.anzoClient.graphTable.table[uri].graph;
            var metadataGraph = graph.metadataGraph;
            var stmts = metadataGraph.find(uri, anzo.client.Vocabulary.revisionProperty, null);
            if (stmts.length > 0) {
                namedGraphStatements.push(stmts[0]);
            } else {
                var stmt = anzo.createStatement(uri, anzo.client.Vocabulary.revisionProperty, -1, metadataGraph.namedGraphUri);
                namedGraphStatements.push(stmt);
            }
        }
        this._replicate(namedGraphStatements, true, callback);
    },
    
    _replicateSelectGraphs : function(graphsToReplicate, callback) {
        if (log.isDebugEnabled()) {
            log.debug("Replicating select graphs #graphs: " + graphsToReplicate.length);
        }
        var namedGraphStatements = [];
        for (var i=0;i<graphsToReplicate.length;i++) {
            var uri = graphsToReplicate[i];
            if (log.isDebugEnabled()) {
                log.debug("Adding select graph: " + uri);
            }
            if (!this.anzoClient.graphTable.table[uri]) {
                // graph may have been closed in the meantime
                if (log.isDebugEnabled()) {
                    log.debug("Graph is not in graphTable so it will not be replicated: " + uri);
                }
                continue;
            }
            var graph = this.anzoClient.graphTable.table[uri].graph;
            
            var metadataGraph = graph.metadataGraph;
            var stmts = metadataGraph.find(uri, anzo.client.Vocabulary.revisionProperty, null);
            if (stmts.length > 0) {
                namedGraphStatements.push(stmts[0]);
            } else {
                var stmt = anzo.createStatement(uri, anzo.client.Vocabulary.revisionProperty, -1, metadataGraph.namedGraphUri);
                namedGraphStatements.push(stmt);
            }
        }
        this._replicate(namedGraphStatements, true, callback);
    },
    
    _replicateNewGraphs : function(newGraphs, callback) {
        var namedGraphStatements = [];
        for (var uri in newGraphs) {
            if (!this.anzoClient.graphTable.table[uri]) {
                if (log.isDebugEnabled()) {
                    log.debug("Graph is not yet in graphTable so it will not be replicated: " + uri);
                }
                continue;
            }
            // only allow selective replication of graphs that
            // have been fully added to the local replica, i.e.
            // don't include those that have been provisioned only
            // in the transaction queue. 
            var ngStmt = anzo.createStatement(uri, anzo.client.Vocabulary.revisionProperty, -1, newGraphs[uri]);
            namedGraphStatements.push(ngStmt);
        }
        if (log.isDebugEnabled()) {
           log.debug("Replicating named graph statements: " + namedGraphStatements);
        }
        this._replicate(namedGraphStatements, true, callback);    	
    },
    
    _replicateToQuadStore : function(graphsToReplicate, callback) {
        // summary: Replicate the given graphs directly to the quadstore without assumptions 
        //   about the graph being in the graph table yet.
        var namedGraphStatements = [];
        for (var i=0;i<graphsToReplicate.length;i++) {
            var uri = graphsToReplicate[i];
            var metadataGraphUri = anzo.utils.UriGenerator.getMetadataGraphUri(uri);
            var stmts = this.anzoClient.quadStore.find(uri, anzo.client.Vocabulary.revisionProperty, null, metadataGraphUri); 
            if (stmts.length > 0) {
                namedGraphStatements.push(stmts[0]);
            } else {
                var stmt = anzo.createStatement(uri, anzo.client.Vocabulary.revisionProperty, -1, metadataGraphUri);
                namedGraphStatements.push(stmt);
            }
        }
        this._replicate(namedGraphStatements, false, callback);
    },

    _replicate : function(namedGraphStatements, ignoreGraphsNotInTable, callback) {
        if (log.isDebugEnabled()) {
            log.debug("Replicating #graphs: " + namedGraphStatements.length);
        }
        if (namedGraphStatements.length == 0) {
            this._completeReplication(true, [], callback);
        } else {
            this.anzoClient.replicationService.replicate(namedGraphStatements, dojo.hitch(this, function replicatorOnExecReplicateComplete(message, success, error) {
            	if (success) {
                    this.anzoClient.replicaUpdater.update(message, ignoreGraphsNotInTable);
                    this._completeReplication(true, [], callback);
                } else {
                    this._completeReplication(false, [error], callback);
                }
            }));
        }
    },
    
    _completeReplication : function(success, errors, callback) {
        log.debug("Completing replication!");
        this.anzoClient.replicationComplete(success, errors);
        if (callback) {
            callback(success, errors);
        }
    }
    
});

})();
