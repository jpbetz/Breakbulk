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


dojo.provide("anzo.client.ClientGraph");

dojo.require("anzo.rdf.NamedGraph");

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
(function(){

var log = anzo.log.getLogger("anzo.client.ClientGraph"); 
 
dojo.declare('anzo.client.ClientGraph', anzo.rdf.NamedGraph, {
    
    // summary: 
    //    The ClientGraph is a simple extension of anzo.rdf.NamedGraph. In addition to providing the 
    //    usual graph projection of an IQuadStore, the ClientGraph contains a pointer to a MetadataGraph,
    //    the defining feature of a named graph in Anzo, from the perspective of the user. From an operational
    //    perspective, the ClientGraph must also take the AnzoClient to perform the close operation properly,
    //    decrementing the usage count. The user of course never calls the constructor of an ClientGraph so this
    //    complication does not overburden the user.
    
    // metadataGraph : anzo.client.MetadataGraph
    //   The metadata graph that holds system information about this graph.
    metadataGraph   : null,
    
    // _anzoClient : anzo.client.AnzoClient
    //   The anzoClient that manages this graph.
    _anzoClient  : null,
    
    // _closed : Boolean
    //   False if this graph is closed.
    _closed          : false,
    
    _connected		: false,
    
    constructor : function(namedGraphUri, store, metadataGraph, anzoClient) {
		// summary:
		// 	create a new AnzoGraph instance. This constructor should not be explicitly
		// 	called. Instances of ClientGraph are handed out by the AnzoClient class.
		
		// namedGraphUri: String | anzo.rdf.URI
		// 	The uri of the named graph
		
		// store: anzo.rdf.IQuadStore
		// 	Optional store used to store the statements of this graph.
		
		// metadataGraph : anzo.client.MetadataGraph
        //   The metadata graph that holds system information about this graph.
    
		// anzoClient : anzo.client.AnzoClient
        //   The anzoClient that manages this graph.	
    	
    	this.metadataGraph             = metadataGraph;
    	this.metadataGraph.clientGraph = this;
    	this._anzoClient               = anzoClient;
    	this.fireEvents                = false;
    },
    
    add : function()  { 
	    // summary: Adds the given triple(s) to this graph.
	    //      Form 1: add(statement)   - takes a single statement and adds it
	    //      Form 2: add(statements)  - takes an array of statements and adds them
	    //      Form 3: add(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.URI) - adds the given triple    
        //      Form 4: add(anzo.rdf.INamedGraph)  - adds all statements of the given graph to this graph
        //      Form 5: add(anzo.rdf.IQuadStore) - adds all statements of the given triple graph to this graph
        
		if (this._closed) {
		    throw new Error("Graph is closed.");
		}

        var inTransaction = this._anzoClient.inTransaction()
        
        if (!inTransaction) {
        	this._anzoClient.begin();
        }
        
    	try {
    		this.inherited(arguments);
        	if (!inTransaction){
        		this._anzoClient.commit();
        	}
    	} catch (e){
    		if (!inTransaction) {
    			this._anzoClient.abort();
    			throw(e);
    		}
    	}
    },

	remove : function()  { 
	    // summary: Deletes the given triple(s) from this graph.
		//      Form 1: remove(statement) - removes the given statement
		//      Form 2: remove(statements) - removes the given array of statements
		//      Form 3: remove(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object) - removes the given triple pattern
		//      Form 4: remove(anzo.rdf.INamedGraph) - removes all statements of the given graph from this graph
		//      Form 5: remove(anzo.rdf.IQuadStore) - removes all statements of the given triple graph from this graph
		
		if (this._closed) {
		    throw new Error("Graph is closed.");
		}
		
        var inTransaction = this._anzoClient.inTransaction()
        
        if (!inTransaction) {
        	this._anzoClient.begin();
        }

    	try {
    		this.inherited(arguments);
        	if (!inTransaction){
        		this._anzoClient.commit();
        	}
    	} catch (e){
    		if (!inTransaction) {
    			this._anzoClient.abort();
    		}
    	}
    	
    },
    
    close : function() {
    	log.debug("Closing Graph");
    	if (this._closed) {
            log.debug("Graph already closed.");
    	    return;
    	}
    	
        if (this._anzoClient.graphTable.release(this.namedGraphUri)) {
        	log.debug("Close: removing statements");
          	this._closed = true;
        	var stmts = this.metadataGraph.find(this.namedGraphUri, anzo.client.Vocabulary.uuidProperty, null);
            if (stmts & stmts.length > 0) {
                this._anzoClient.namedGraphUpdateManager.removeNamedGraphUpdateTopic(stmts[0].object.toString());
            }
            this._anzoClient.quadStore.remove(null, null, null, this.namedGraphUri);
            this._anzoClient.quadStore.remove(null, null, null, this.metadataGraph.namedGraphUri);

            // Break the circular references so that the objects can be garbage collected. 
        	this._anzoClient = null;
        	this.metadataGraph.close();
        	this.metadataGraph = null;
        	this._connected = false;
        }

    }

});

})();
