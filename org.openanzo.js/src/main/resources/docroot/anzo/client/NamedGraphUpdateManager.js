/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/


dojo.provide("anzo.client.NamedGraphUpdateManager");

dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.rdf.QuadStore");
dojo.require("anzo.utils.Set")
dojo.require("anzo.utils.UriGenerator");
dojo.require("anzo.log");

/*
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
 
(function(){ 

var log = anzo.log.getLogger("anzo.client.NamedGraphUpdateManager");

dojo.declare('anzo.client.NamedGraphUpdateManager', null, {
    
    // summary: 
    //      Handles named graph update notifications for the other client components.
    //     
     
    // anzoClient : anzo.client.AnzoClient
    //   The anzoClient
    anzoClient  : null,
    
    jmsClient	: null,
    
    SUBSCRIPTION_REQUEST_TIMEOUT : 30000,
    TRANSACTION_TIMEOUT			 : 5000,
    
    transactions : null,
    processedTransactions : null,
        
    constructor : function(anzoClient) {
        this.anzoClient  = anzoClient;
        this.jmsClient = anzo.messaging.JMSClient;
        this.transactions = {};
        this.processedTransactions = new anzo.utils.Set();
    },
    
    addNamedGraphUpdateTopics : function(namedGraphUuids, callback) {
        // summary: Subscribe to the named graph update topic of each of the given graphs.
        // namedGraphUuids : Array of String. Each string is a UUID denoting the graph's topic for which to subscribe.
        // callback: function(success, missingSubscriptions, errors) - callback called with results of the operation.
        //   success is false if any of the subscriptions failed. It's true if all subscriptions succeeded.
        //   If success if false, then missingSubscriptions is an Array of the UUIDs that were NOT subscribed and errors
        //   contains error information.
        if (!dojo.isArray(namedGraphUuids)) {
            callback(false, namedGraphUuids, new Error("namedGraphUuids must be an Array"));
            return;
        }
        if (log.isDebugEnabled()) {
            log.debug("Adding named graph update topic subscriptions for " + namedGraphUuids.length + " graphs.");
        }
        var missingSubscriptions = [];
        if (log.isDebugEnabled()) {
            log.debug("About to subscribe to named graph update for uuids:" + dojo.toJson(namedGraphUuids, true));
        }
        var topics = dojo.map(namedGraphUuids, function(item) { return anzo.utils.UriGenerator.getTopicString(anzo.client.Vocabulary.NAMEDGRAPH_TOPIC_PREFIX, item.toString()); }); 
        if (log.isDebugEnabled()) {
            log.debug("Converted named graph uuids to named graph update topics:" + dojo.toJson(topics, true));
        }
        
        this.jmsClient.subscribeToTopics(topics, dojo.hitch(this, this.handleNamedGraphTopicMessage), function(success, failedTopics, errorInfo) {
            if (log.isDebugEnabled()) {
                log.debug("Done adding named graph update topic subscriptions for " + namedGraphUuids.length + " graphs. success: " + success);
            }
            if (!success) {
                if (log.isDebugEnabled()) {
                    log.debug("Failed adding named graph update subscriptions for topics:" + dojo.toJson(failedTopics, true) + ".\nerrorInfo:" + dojo.toJson(errorInfo, true));
                }
                for (var i = 0; i < failedTopics.length; i++) {
                    var namedGraphUuid = anzo.utils.UriGenerator.getUriFromTopicString(anzo.client.Vocabulary.NAMEDGRAPH_TOPIC_PREFIX, failedTopics[i]);
                    missingSubscriptions.push(namedGraphUuid);
                }
                if (log.isDebugEnabled()) {
                    log.debug("Failed adding named graph update subscriptions for graphs:" + dojo.toJson(missingSubscriptions, true) + ".\nerrorInfo:" + dojo.toJson(errorInfo, true));
                }
            }
            if (callback) {
                callback(success, missingSubscriptions, success ? errorInfo : null);
            }
        }, this.SUBSCRIPTION_REQUEST_TIMEOUT);
    },
    
    removeNamedGraphUpdateTopics : function(namedGraphUuids) {
        // TODO: figure out if this is necessary
    },
    
    handleNamedGraphTopicMessage : function(topicMessage) {

        if (log.isDebugEnabled()) {
            log.debug("TOPIC MESSAGE RECEIVED:\n" + dojo.toJson(topicMessage, true));
        }

        var transactionUri = topicMessage.properties.transactionURI;
        if (this.processedTransactions.contains(transactionUri)) {
            if (log.isDebugEnabled()) {
                log.debug("handleNamedGraphTopicMessage - We've already processed this transaction:" + transactionUri);
            }
            return;
        }
        
        var messageGraphUri = topicMessage.properties.namedGraphUri;
        var messageGraphRevision = null;
        
        var transaction = this.transactions[transactionUri];
        if (!transaction) {
            if (log.isDebugEnabled()) {
                log.debug("Transaction not in transactions list yet:" + transactionUri);
            }
            transaction = {};
            transaction.transactionUri = transactionUri;
            transaction.expectedGraphs = [];
            this.transactions[transactionUri] = transaction;
            // map from nguri to named graph update objects.
            transaction.namedGraphUpdates = {};
            
            if (topicMessage.properties.transactionContext) {
                transaction.transactionContext = anzo.client.Serialization.readStatementsFromJsonString(topicMessage.properties.transactionContext);
            }
            
            if (topicMessage.properties.namedGraphUpdates) {
                var revs = anzo.client.Serialization.readNamedGraphRevisions(topicMessage.properties.namedGraphUpdates);
                for (var uuid in revs) {
                    var nguri = this.anzoClient._getGraphUriFromUuid(uuid);
                    if (nguri) {
                        transaction.expectedGraphs.push(nguri);
                        if (messageGraphUri == nguri.toString()) {
                            messageGraphRevision = revs[uuid]; 
                        }
                    }
                }
            }
            
            if (topicMessage.properties.timestamp) {
                transaction.timestamp = topicMessage.properties.timestamp;
            }
            
            setTimeout(dojo.hitch(this, function() {
                if (!this.processedTransactions.contains(transactionUri)) {
                    log.debug("Timedout waiting for transactions...")
                    this.replicateAndProcessAllTransactions();
                }
            }), 5000 + transaction.expectedGraphs.length * 1000);
            
        }
        
        var namedGraphUpdate = {};
        namedGraphUpdate.namedGraphUri = messageGraphUri;
        namedGraphUpdate.namedGraphUuid = topicMessage.properties.namedGraphUUID;
        var additions = anzo.client.Serialization.readStatementsFromJsonString(topicMessage.properties.additions);
        namedGraphUpdate.additions = additions;
        var removals = anzo.client.Serialization.readStatementsFromJsonString(topicMessage.properties.removals);
        namedGraphUpdate.removals = removals;
        var metaAdditions = anzo.client.Serialization.readStatementsFromJsonString(topicMessage.properties.metaAdditions);
        namedGraphUpdate.metaAdditions = metaAdditions;
        var metaRemovals = anzo.client.Serialization.readStatementsFromJsonString(topicMessage.properties.metaRemovals);
        namedGraphUpdate.metaRemovals = metaRemovals;
        namedGraphUpdate.revision = parseInt(messageGraphRevision);
        
        transaction.namedGraphUpdates[namedGraphUpdate.namedGraphUri] = namedGraphUpdate;
        
        //if (log.isDebugEnabled()) {
        //    log.debug("NAMED GRAPH UPDATE:\n" + dojo.toJson(namedGraphUpdate, true));
        //}
        
        // check and see if we have received everything
        var complete = true;
        for (var i = 0; i < transaction.expectedGraphs.length; i++) {
            if (!transaction.namedGraphUpdates[transaction.expectedGraphs[i]]) {
                complete = false;
                break;
            }
        }
        
        if (complete) {
            var replicaInSync = true;
            for (var nguri in transaction.namedGraphUpdates) {
                var update = transaction.namedGraphUpdates[nguri];
                var updater = this.anzoClient.replicaUpdater;
                var inSync = updater.updateNamedGraph(updater.TYPE_NAMED_GRAPH_UPDATE, update.namedGraphUri, update.namedGraphUuid, update.revision, update.additions, update.removals, update.metaAdditions, update.metaRemovals);
                if (!inSync) {
                    replicaInSync = false;
                }
            }

            if (replicaInSync) {
                log.debug("Replica in sync...");
                var context = null;
                if (transaction.transactionContext) {
                    context = new anzo.rdf.QuadStore();
                    context.add(transaction.transactionContext);
                }
                
                var handledByReplicator = this.anzoClient.replicator.transactionComplete(transactionUri);
                if (!handledByReplicator) {
                	// Fire the transactionComplete event ourselves since the replicator isn't going to do it for us.
                	// The replicator only does it for transactions involved in an updateRepository call. We should
                	// let the replicator handle those because that way it waits to fire the anzoClient.transactionComplete event
                	// until any new graphs involved in the transaction have been replicated.
                	this.anzoClient.transactionComplete(transaction.transactionUri, transaction.timestamp, transaction.expectedGraphs, context);
                }                
                delete this.transactions[transactionUri];
                this.processedTransactions.add(transactionUri);
            } else {
                log.debug("Replica not in sync...replicating all...");
                this.replicateAndProcessAllTransactions();
            }

        }
        
    },
    
    replicateAndProcessAllTransactions : function() {
        var transactionsToProcess = this.transactions;
        this.transactions = {};
        
        var graphsToReplicate = new anzo.utils.Set();
        
        for (var transactionUri in transactionsToProcess) {
            var transaction = transactionsToProcess[transactionUri];
            for (var i=0;i<transaction.expectedGraphs.length;i++) {
                graphsToReplicate.add(transaction.expectedGraphs[i]);
            }
        }
        console.log("Replicating select graphs..." + dojo.toJson(graphsToReplicate, false));
        this.anzoClient.replicator._replicateSelectGraphs(graphsToReplicate.toArray(), dojo.hitch(this, function(success, errors) {
            if (success) {
                
                for (var transactionUri in transactionsToProcess) {
                    var transaction = transactionsToProcess[transactionUri];
                    var context = null;
                    if (transaction.transactionContext) {
                        context = new anzo.rdf.QuadStore();
                        context.add(transaction.transactionContext);
                    }
                    var handledByReplicator = this.anzoClient.replicator.transactionComplete(transactionUri);
                    if (!handledByReplicator) {
                    	// Fire the transactionComplete event ourselves since the replicator isn't going to do it for us.
                    	// The replicator only does it for transactions involved in an updateRepository call. We should
                    	// let the replicator handle those because that way it waits to fire the anzoClient.transactionComplete event
                    	// until any new graphs involved in the transaction have been replicated.
                    	this.anzoClient.transactionComplete(transaction.transactionUri, transaction.timestamp, transaction.expectedGraphs, context);
                    }                
                }
            } else {
                log.warn("Error replicating all transactions.");
            }
        }));
    }
    
});

})();
