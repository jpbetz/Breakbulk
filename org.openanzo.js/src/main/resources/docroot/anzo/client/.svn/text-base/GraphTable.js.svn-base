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

/**
 * 
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
 
dojo.provide("anzo.client.GraphTable");

dojo.require("anzo.rdf.Dataset");

dojo.declare('anzo.client.GraphTable', null, {
    
    // summary: Used to store and retreive named graphs.  A reference count is kept for each named graph.  When the reference count for a given graph reaches zero, the graph is removed from this table.
    
    // table : Object
    //  Use to map named graph URIs to named graph instances.
    table : null,
    
    dataset : null,
    
    constructor : function() {
        
        // summary: Initialize the table object.
        
    	this.table = {};
    },
    
    put : function(namedGraphUri, anzoGraph) {
    
        // summary: Registeres the given named graph with the given named grpah URI.  It also sets the entry count to one.
        
        // namedGraphUri : String | anzo.rdf.URI
        //  The URI of the given named graph.
        
        // anzoGraph : anzo.rdf.INamedGraph
        //  The named graph that is added to the table.
        
        var _uri = anzo.rdf.getValue(namedGraphUri, {type: 'uri'});
        if(_uri == null)
            throw Error("Given named graph uri is not a valid URI.")
    	var entry = new Object();
    	entry.count = 1;
    	entry.graph = anzoGraph;
    	this.table[_uri.dictionaryKey()] = entry;
    	this.getDataset().addGraph(entry.graph);
    },
    
    get : function(namedGraphUri) {
        
        // summary: Retreives the named graph mapped to by the given named graph URI.
        
        // namedGraphUri : String | anzo.rdf.URI
        //  The URI of the requested named graph.
        
        // returns: anzo.rdf.INamedGraph
        //  Returns the named graph that the given named graph URI mapps to.
        
        var _uri = anzo.rdf.getValue(namedGraphUri, {type: 'uri'});
        if(_uri == null)
            throw Error("Given named graph uri is not a valid URI.")
    	if (this.table[_uri.dictionaryKey()]) {
    		var entry = this.table[_uri.dictionaryKey()];
    		entry.count++;
    		return entry.graph;
    	} else {
    		return null;
    	}
    },
    
    contains : function(namedGraphUri) {
    	var _uri = anzo.rdf.getValue(namedGraphUri, {type: 'uri'});
        if(_uri == null)
            throw Error("Given named graph uri is not a valid URI.")
        
    	return _uri.dictionaryKey() in this.table;
    },

    release : function(namedGraphUri) {
        
        // summary: 
        //  Release the graph for the given uri.
        
        // namedGraphUri : String : anzo.rdf.URI
        //  The URI of the named graph that is to be reset.
        
        // returns: True iff the reference count of the graph with the given URI is 0, false otherwise.
        
        var _uri = anzo.rdf.getValue(namedGraphUri, {type: 'uri'});
        if(_uri == null)
            throw Error("Given named graph uri is not a valid URI.")
        
    	if (this.table[_uri.dictionaryKey()]) {
    		var entry = this.table[_uri.dictionaryKey()];
    		entry.count--;
    		if (entry.count == 0) {
    		    this.getDataset().removeGraph(entry.graph);
    			delete this.table[_uri.dictionaryKey()];
    			return true;
    		} else {
    			return false;
    		}
    	}
    	return false;
    },
    
    getDataset : function() {
        if (this.dataset == null) {
            this.dataset = new anzo.client.GraphTableDataset();
            for(var key in this.table)
                this.dataset.addGraph(this.table[key].graph);
        }
        return this.dataset;
    }

});

dojo.declare('anzo.client.GraphTableDataset', anzo.rdf.Dataset, {  
    
    addGraph: function(graph) {
        anzo.client.GraphTableDataset.superclass.addNamedGraph.call(this, graph);
        anzo.client.GraphTableDataset.superclass.addDefaultGraph.call(this, graph);
    },
    removeGraph: function(graph) {
        anzo.client.GraphTableDataset.superclass.removeDefaultGraph.call(this, graph);
        anzo.client.GraphTableDataset.superclass.removeNamedGraph.call(this, graph);
    },
    createDatasetGraph: function(callback) {
        callback(new anzo.rdf.NamedGraph(this.uri));
    },
    setDefaultGraphs : function(namedGraphUris) {
        throw new Error("Unsupported Operation Exception: anzo.client.GraphTableDataset.setDefaultGraphs");
    },
    setNamedGraphs : function(namedGraphUris) {
        throw new Error("Unsupported Operation Exception: anzo.client.GraphTableDataset.setNamedGraphs");
    },
    addNamedGraph : function(graph) {
        throw new Error("Unsupported Operation Exception: anzo.client.GraphTableDataset.addNamedGraph");
    },
    addDefaultGraph : function(graph) {
        throw new Error("Unsupported Operation Exception: anzo.client.GraphTableDataset.addDefaultGraph");
    },
    removeDefaultGraph : function(namedGraphUri) {
        throw new Error("Unsupported Operation Exception: anzo.client.GraphTableDataset.removeDefaultGraph");
    },
    removeNamedGraph : function(namedGraphUri) {
        throw new Error("Unsupported Operation Exception: anzo.client.GraphTableDataset.removeNamedGraph");
    },
    clear : function() {
        throw new Error("Unsupported Operation Exception: anzo.client.GraphTableDataset.clear");
    },
    close : function() {
        delete this.graphs;
    }
    
});