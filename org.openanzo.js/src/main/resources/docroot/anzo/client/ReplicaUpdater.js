/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
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

dojo.provide("anzo.client.ReplicaUpdater");

dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.utils.UriGenerator");
dojo.require("anzo.log");

(function(){

var log = anzo.log.getLogger("anzo.client.ReplicaUpdater");

dojo.declare('anzo.client.ReplicaUpdater', null, {
    
    TYPE_REPLICATION			: 0,
    TYPE_NAMED_GRAPH_UPDATE	    : 1,
    
    constructor : function(anzoClient, replicaQuadStore) {
        // summary: 
        //		create a new replicator
        // anzoClient:
        //      an initialized AnzoClient instance
        // replicaQuadStore:
        //		the quad store replica to update against
        if (!anzoClient) { throw new Error("anzo.client.ReplicaUpdater missing required anzoClient argument to constructor."); }
        if (!replicaQuadStore) { throw new Error("anzo.client.ReplicaUpdater missing required replicaQuadStore argument to constructor."); }

        this.replicaQuadStore = replicaQuadStore;
        this.anzoClient = anzoClient;
    },

    update : function(replicationMessage, ignoreGraphsNotInTable) {
        
        if (log.isDebugEnabled()) {
            log.debug("Replication Message:" + dojo.toJson(replicationMessage, true));
        }

        var ser = anzo.client.Serialization;
        for (var i = 0; i < replicationMessage.length; i++) {
            var namedGraphUpdate = replicationMessage[i];
            if(namedGraphUpdate.done==null){
           	 	namedGraphUpdate.done=true;
	            var namedGraphUri = namedGraphUpdate.namedGraphUri;
	            var namedGraphUuid = namedGraphUpdate.namedGraphUUID;
	            var revision = namedGraphUpdate.revision;
	            var additions = ser.readStatementsFromJson(namedGraphUpdate.additions);
	            var removals = ser.readStatementsFromJson(namedGraphUpdate.removals);	           
	            var metaAdditions = ser.readStatementsFromJson(namedGraphUpdate.metaAdditions);
	            var metaRemovals = ser.readStatementsFromJson(namedGraphUpdate.metaRemovals);
	            for(var j = i+1; j < replicationMessage.length; j++){
	            	var subNamedGraphUpdate=replicationMessage[j];
	            	if(subNamedGraphUpdate.namedGraphUri==namedGraphUri&&(subNamedGraphUpdate.done==null)){
		           	    if(subNamedGraphUpdate.additions!=null){
		           	    	additions = additions.concat(ser.readStatementsFromJson(subNamedGraphUpdate.additions));
		           	    }
		           		if(subNamedGraphUpdate.removals!=null){
		           			removals = removals.concat(ser.readStatementsFromJson(subNamedGraphUpdate.removals));
		           		}
		        		if(subNamedGraphUpdate.metaAdditions!=null){
		        			metaAdditions = metaAdditions.concat(ser.readStatementsFromJson(subNamedGraphUpdate.metaAdditions));
		        		}
		           		if(subNamedGraphUpdate.metaRemovals!=null){
		           			metaRemovals = metaRemovals.concat(ser.readStatementsFromJson(subNamedGraphUpdate.metaRemovals));
		           		}
		           		subNamedGraphUpdate.done=true;
	         		}
	           	}
	           if (log.isDebugEnabled()) {
	                log.debug("Calling updateNamedGraph for graph:" + namedGraphUri);
	            }            
	            this.updateNamedGraph(this.TYPE_REPLICATION, namedGraphUri, namedGraphUuid, revision, additions, removals, metaAdditions, metaRemovals, ignoreGraphsNotInTable);
            }
        }
    }, 
    
    updateNamedGraph : function(type, namedGraphUri, uuid, revision, additions, removals, metaAdditions, metaRemovals, ignoreGraphsNotInTable) {

        if (ignoreGraphsNotInTable === undefined || ignoreGraphsNotInTable === null) { // default to true
            ignoreGraphsNotInTable = true;
        }
        
        var updateReplica = true;
        var replicaInSync = true;
        try {
            var replicaGraph = this.anzoClient.graphTable.get(namedGraphUri);
            if (replicaGraph || ignoreGraphsNotInTable === false) {
                if (log.isDebugEnabled()) {
                    log.debug("Applying update to graph. replicaGraph:" + replicaGraph + " ignoreGraphsNotInTable:" + ignoreGraphsNotInTable + " namedGraphUri:" + namedGraphUri);
                }
                var metadataGraphUri = anzo.utils.UriGenerator.getMetadataGraphUri(anzo.createURI(namedGraphUri));
                var revisionedModeStmts = null;
                if (revision != -1 || type == this.TYPE_NAMED_GRAPH_UPDATE) {
                    // This message is such that we'll need to know if the graph is a non-revisioned graph...so look it up.
                    revisionedModeStmts = this.replicaQuadStore.find(namedGraphUri, anzo.client.Vocabulary.revisionedProperty, null, metadataGraphUri);
                }
                if (type != this.TYPE_NAMED_GRAPH_UPDATE && (revision == -1 || (revisionedModeStmts && revisionedModeStmts.length > 0 && revisionedModeStmts[0].object == "false"))) {
                    // If this is a non-revisioned graph, then we need to wipe the replica this graph's data before applying
                    // the update so that we don't leave around any stale statements.
                    if (log.isDebugEnabled()) {
                        log.debug("Graph is a non-revisioned graph so wiping replica data before applying new data for: " + namedGraphUri);
                    }
                    this.replicaQuadStore.remove(null, null, null, metadataGraphUri);
                    this.replicaQuadStore.remove(null, null, null, namedGraphUri);
                } else {
                    // This is a revisioned graph (or the 0th revision of a non-revisioned graph) so we need to compare
                    // the revision of the graph in our local replica with that of the revision in the update.
                    var currentRevision = -1;
                    var revStmts = this.replicaQuadStore.find(namedGraphUri, anzo.client.Vocabulary.revisionProperty, null, metadataGraphUri);
                    var revVal = null;
                    if (revStmts && revStmts.length > 0) {
                        revVal = revStmts[0].object.value;
                        currentRevision = parseInt(revStmts[0].object.value);
                    }
                    if (log.isDebugEnabled()) {
                        log.debug("Current replica revision (if any):" + currentRevision + " Update Revision (if any):" + revision);
                    }
                    if (isNaN(currentRevision)) {
                        if (log.isErrorEnabled()) {
                            log.error("Error parsing current replica revision: '" + revVal + "' in update for graph: " + namedGraphUri + ". Ignoring updates.");
                        }
                        updateReplica = false; 
                        replicaInSync = false;
                    } else if(currentRevision >= revision) {
                        // We're already up-to-date past the message's revision in the replica.
                        updateReplica = false; // signal that everything is ok, but no need for us to update
                        replicaInSync = true;
                    } else if (type == this.TYPE_NAMED_GRAPH_UPDATE && currentRevision < revision-1){
                        // If this update is coming from notification and we're more than one revision out of date,
                        // signal that our replica is too out of date to process this update.
                        // If it is coming from replication, then we know we can update safely.
                        updateReplica = false; 
                        replicaInSync = false;
                    } 
                }
                if (updateReplica) {
                    if (log.isDebugEnabled()) {
                        log.debug("Updating replica for named graph:" + namedGraphUri);
                    }
                    if (removals.length > 0) {
                        this.replicaQuadStore.remove(removals);
                    }
                    if (metaRemovals.length > 0) {
                        this.replicaQuadStore.remove(metaRemovals);
                    }
                    if (additions.length > 0) {
                        this.replicaQuadStore.add(additions);
                    }
                    
                    if (metaAdditions.length > 0) {
                        this.replicaQuadStore.add(metaAdditions);
                    }
                    
                    if (removals.length > 0) {
                        if (replicaGraph) {
                            replicaGraph.statementsRemoved(removals);
                        }
                    }
                    if (metaRemovals.length > 0) {
                        if (replicaGraph) {
                            replicaGraph.metadataGraph.statementsRemoved(metaRemovals);
                        }
                    }
                    if (additions.length > 0) {
                        if (replicaGraph) {
                            replicaGraph.statementsAdded(additions);
                        }
                    }
                    if (metaAdditions.length > 0) {
                        if (replicaGraph) {
                            replicaGraph.metadataGraph.statementsAdded(metaAdditions);
                        }
                    }
                } else {
                    if (log.isDebugEnabled()) {
                        log.debug("No need to update replica for named graph:" + namedGraphUri);
                    }
                }
            } else {
                if (log.isDebugEnabled()) {
                    log.debug("updateNamedGraph - ignoring graph update since no replicaGraph exists in graph table for uri:" + namedGraphUri);
                }
            }
            
        } finally {
            if (replicaGraph) {
                this.anzoClient.graphTable.release(namedGraphUri);
            }
        }
        return replicaInSync;
    }
    
});

})();
