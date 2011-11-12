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
 
dojo.provide("anzo.client.AnzoClientDataset");

dojo.require("anzo.rdf.DatasetBase");
dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.log");

anzo.client.REPLICA     = 1;
anzo.client.MEMORY_ONLY = 2;

(function() {
var log = anzo.log.getLogger("anzo.client.AnzoClientDataset");

dojo.declare('anzo.client.AnzoClientDataset', anzo.rdf.DatasetBase, {
    
    client          : null,
    type            : -1,
    persisted       : false,
    
    // ======================================================================
    // INITIALIZATION
    
    initialize : function(args) {
        this.client                   = args[0];
        this.type                     = args[2];
        this.persisted                = args[3];
        this._initialDefaultGraphUris = args[4];
        this._initialNamedGraphUris   = args[5];
        
        anzo.client.AnzoClientDataset.superclass.initialize.call(this, [args[1]]);
    },
    
    loadInitialGraphs : function(callback) {
        // summary: This method loads and caches all graphs for this dataset AND loads and caches the graphs specified in the constructor.
        var _this = this;
        
        var defaultGraphSet = new anzo.utils.Set();
        defaultGraphSet.addAll(this.getDefaultGraphUris())
        if(this._initialDefaultGraphUris)
            defaultGraphSet.addAll(this._initialDefaultGraphUris);
        
        var namedGraphSet = new anzo.utils.Set();
        namedGraphSet.addAll(this.getNamedGraphUris())
        if(this._initialNamedGraphUris)
            namedGraphSet.addAll(this._initialNamedGraphUris);
        
        if(defaultGraphSet.isEmpty() && namedGraphSet.isEmpty()) {
            log.debug("no initial graphs dataset: " + this.uri.toString() + ". Calling callback.");
            callback();
            return;
        }
        var count = 0;
        var loaded = function() {
            log.debug("loaded an initial graph. count:" + (count + 1));
            if(++count >= defaultGraphSet.size() + namedGraphSet.size()) {
                callback();
            }
        }
        
        defaultGraphSet.forEach(function(item) {
            log.debug("adding default graph to dataset: " + _this.uri.toString());
            _this.addDefaultGraph(item, loaded);
        });
        
        namedGraphSet.forEach(function(item) {
            log.debug("Adding named graph to dataset: " + _this.uri.toString());
            _this.addNamedGraph(item, loaded);
        });
        
        delete this._initialNamedGraphUris;
        delete this._initialDefaultGraphUris;
    },
    
    // ======================================================================
    // DATASETBASE METHODS
    
    createNamedGraph : function(namedGraphUri, callback) {
        if (this.type == anzo.client.MEMORY_ONLY)
            callback(new anzo.rdf.NamedGraph(namedGraphUri));
        else if (this.type == anzo.client.REPLICA) 
            this.client.getReplicaGraph(namedGraphUri, {create: true}, callback);
        else if(this.type == anzo.client.SERVER)
            throw Error('Server graphs are not implemented in anzo-js');
        else 
            callback(new anzo.rdf.NamedGraph(namedGraphUri)); // default is an in-memory named graph
    },
    
    createDatasetGraph : function(callback) {
        if (this.persisted)
            this.client.getReplicaGraph(this.uri, {create: true}, callback);
        else
            callback(new anzo.rdf.NamedGraph(this.uri));
    },
    
    // ======================================================================
    // PRIVATE METHODS - optimized to use a single quad store
    
    _find : function(s, p, o, ns) {
        return this.client.transactionProxy.find(s, p, o, ns);
    },
    
    _contains : function(s, p, o, ns) {
	    return this.client.transactionProxy.contains(s, p, o, ns)
    },
    
    _size : function(ns) {
        return this.client.transactionProxy.size(ns);
    },
    
    _isEmpty: function(ns) {
        return this.client.transactionProxy.isEmpty(ns);
    }
    
});

})();
