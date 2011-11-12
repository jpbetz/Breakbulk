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
 
dojo.provide("anzo.rdf.Dataset"); 

dojo.require("anzo.rdf.DatasetBase");
dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.rdf.QuadStore");

dojo.declare('anzo.rdf.Dataset', anzo.rdf.DatasetBase, {
    
    // summary: Basic Dataset implementation that stores anzo.rdf.INamedGraphs.
    
    createNamedGraph : function(namedGraphUri, callback) {
        if (this.quadStore == null)
            this.quadStore = new anzo.rdf.QuadStore();
        callback(new anzo.rdf.NamedGraph(namedGraphUri, this.quadStore));
    },
    
    createDatasetGraph : function(callback) {
        return this.createNamedGraph(this.uri, callback);
    },
    
    _createGraph : function(graph, callback) {
        var _this = this;
        
        // this allows us to add graphs directly to the dataset
        if(graph instanceof anzo.rdf.INamedGraph) {
            this.cacheGraph(graph);
            callback(graph);
        } else
            this.inherited(arguments);
    }
    
});