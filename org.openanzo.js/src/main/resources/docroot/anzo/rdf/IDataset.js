/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * Created on:  Oct 10, 2007
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.rdf.IDataset"); 

dojo.require("anzo.rdf.IQuadStore");

dojo.declare('anzo.rdf.IDataset', anzo.rdf.IQuadStore, {
    
    // uri : anzo.rdf.URI
    //   Name of the dataset.
    uri : null,
    
    getDatasetGraph : function() {
        // summary: Returns a named graph containing the RDF serialization of the dataset. Implementations should maintain this graph, so that subsequent changes to the dataset are reflected in the graph instances after it is returned. 
        throw new Error("Unimplemented method: anzo.rdf.IDataset.getDatasetGraph"); 
    },
    
    addNamedGraph : function(graph, callback) {
        // summary: Adds the specified graph to the dataset.
        
        // graph : String | anzo.rdf.URI | anzo.rdf.INamedGraph
        //  URI or the named graph that is to be added to the dataset.
        
        // callback : function
        //  Called with the named graph that is added to the dataset upon completion of the operation. 
        
        throw new Error("Unimplemented method: anzo.rdf.IDataset.addNamedGraph");
    },

    setNamedGraphs : function(graphs, callback) {
        
        // summary: Sets the named graphs of the dataset.
        
        // graph : String[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]
        //  Array of URIs or the named graphs that are to be set as the named graphs of the dataset.
        
        // callback : function
        //  Called with the named graphs that are set. 
        
        throw new Error("Unimplemented method: anzo.rdf.IDataset.setNamedGraphs"); 
    },

    getNamedGraph : function(uri) {
        // summary; Retrieves the named graph stored in the dataset with the given uri.
        
        // uri : String | anzo.rdf.URI
        //   Name of the desired graph.
        
        throw new Error("Unimplemented method: anzo.rdf.IDataset.getNamedGraph"); 
    },
    
    getDefaultGraph : function(uri) {
        // summary; Retrieves the default graph stored in the dataset with the given uri.
        
        // uri : String | anzo.rdf.URI
        //   Name of the desired graph.
        
        throw new Error("Unimplemented method: anzo.rdf.IDataset.getNamedGraph"); 
    },

    getNamedGraphUris : function() {
        // summary; Retrieves the uris for all named grpahs in this dataset.
        // returns: An array of uris.
        
        throw new Error("Unimplemented method: anzo.rdf.IDataset.getNamedGraphUris"); 
    },

    containsNamedGraph : function(graph) {
        // returns: true if the dataset contains the specified graph.
        throw new Error("Unimplemented method: anzo.rdf.IDataset.containsNamedGraph"); 
    },

    removeNamedGraph: function(graph) {
        // summary: Removed the specified named graph from the dataset.
        
        // graph : String | anzo.rdf.URI | anzo.rdf.INamedGraph
        //  The graph that is to be removed from the dataset.
        
        throw new Error("Unimplemented method: anzo.rdf.IDataset.removeNamedGraph");
    },

    containsDefaultGraph: function(graph) {
        // returns: true if the dataset contains the specified default graph, false otherwise.
        throw new Error("Unimplemented method: anzo.rdf.IDataset.containsDefaultGraphUri");
    },

    getDefaultGraphUris : function() {
        // summary; Retrieves the uris for all default grpahs in this dataset.
        // returns: An array of uris.
        throw new Error("Unimplemented method: anzo.rdf.IDataset.getDefaultGraphUris");
    },

    addDefaultGraph: function(graph, callback) {
        // summary: Add a default graph to the dataset.
        
        // graph : String | anzo.rdf.URI | anzo.rdf.INamedGraph
        //  URI or the named graph that is to be added to the dataset.
        
        // callback : function
        //  Called with the named graph that is added to the dataset upon completion of the operation. 
        
        throw new Error("Unimplemented method: anzo.rdf.IDataset.addDefaultGraphUri");
    },

    removeDefaultGraph: function(graph) {
        // summary: Removes the specified default graph from the dataset.

        // graph : String | anzo.rdf.URI | anzo.rdf.INamedGraph
        //  The graph that is to be removed from the dataset.
        
        throw new Error("Unimplemented method: anzo.rdf.IDataset.removeDefaultGraphUri");
    },

    setDefaultGraphs: function(graphs, callback) {
        // summary: Sets the default graphs of the dataset.
        
        // graph : String[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]
        //  Array of URIs or the named graphs that are to be set as the default graphs of the dataset.
        
        // callback : function
        //  Called with the named graphs that are set. 
        
        throw new Error("Unimplemented method: anzo.rdf.IDataset.setDefaultGraphUris");
    },

    findPreferential : function(includeEntireDataset, subj, prop, obj, namedGraphUris) {
        throw new Error("Unimplemented method: anzo.rdf.IDataset.findPreferential");
    },

    executeQuery : function(query) {
        // summary: Execute a SPARQL query against the data within this dataset, using the dataset's DefaultGraph and NameGraph sets
        throw new Error("Unimplemented method: anzo.rdf.IDataset.executeQuery");
    },

    close : function() {
        // summary: Closes the dataset and all graphs that it created.
        throw new Error("Unimplemented method: anzo.rdf.IDataset.close");
    }
	
}) ;