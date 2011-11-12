/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.rdf.DatasetBase"); 

// client
dojo.require("anzo.client.Vocabulary");

// rdf
dojo.require("anzo.rdf.IDataset");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.rdf.vocabulary.RDF");

// utils
dojo.require("anzo.utils.UriGenerator");
dojo.require("anzo.utils.Set");

(function(){
    
var log = anzo.log.getLogger("anzo.rdf.DatasetBase");

dojo.declare('anzo.rdf.DatasetBase', anzo.rdf.IDataset, {
    
    datasetGraph : null,

    isLoaded     : false,
    
    _graphs      : null,
    
    _handles     : null,
    
    // ======================================================================
    // INITIALIZATION
    
    constructor : function() {
        this.initialize(arguments)
    },
    
    initialize : function(args) {
        this.uri      = args[0] ? anzo.rdf.getValue(args[0], {type: 'uri'}) : anzo.utils.UriGenerator.generateStandardUri(Math.random());
        this._graphs  = {};
        this._handles = [];
        
        var _this     = this;
        var clientVocab = anzo.client.Vocabulary;
        this.createDatasetGraph(function(datasetGraph) {
            if (_this.uri != null) {
                datasetGraph.add(_this.uri, anzo.rdf.vocabulary.RDF.type, clientVocab.namedDatasetType);
            }
            
            _this.datasetGraph = datasetGraph;
            // keep the dataset object in sync with the dataset graph
            
            _this._handles.push(dojo.connect(_this.datasetGraph, 'statementsAdded', function(stmts) {
                if(!_this._locked) {
                    for(var i = 0; i < stmts.length; i++) {
                        var stmt = stmts[i];
                        if (stmt.predicate.equals(clientVocab.namedGraphProperty) || stmt.predicate.equals(clientVocab.defaultGraphProperty)) {
                            _this._createGraph(stmt.object);
                        }
                    }
                }
            }));
            _this._handles.push(dojo.connect(_this.datasetGraph, 'statementsRemoved', function(stmts) {
                if(!_this._locked) {
                    for(var i = 0; i < stmts.length; i++) {
                        var predicate = stmts[i].predicate;
                        var object = stmts[i].object;
                        if ((predicate.equals(clientVocab.namedGraphProperty) || predicate.equals(clientVocab.defaultGraphProperty))
                                && !_this.datasetGraph.contains(_this.uri, clientVocab.namedGraphProperty, object) && !_this.datasetGraph.contains(_this.uri, clientVocab.defaultGraphProperty, object)) {
                            _this.removeFromCache(object);
                        }
                    }
                }
            }));

            log.debug("about to load initial graphs for dataset: " + _this.uri.toString());
            _this.loadInitialGraphs(function() {
                _this.onLoad();
            });
            
        });
    },
    
    loadInitialGraphs : function(callback) {
        // summary: This method loads and caches all graphs for this dataset.
        
        var _this = this;
        
        var defaultGraphSet = new anzo.utils.Set();
        defaultGraphSet.addAll(this.getDefaultGraphUris());
        
        var namedGraphSet = new anzo.utils.Set();
        namedGraphSet.addAll(this.getNamedGraphUris());
        
        if(defaultGraphSet.isEmpty() && namedGraphSet.isEmpty()) {
            log.debug("no initial graphs dataset: " + this.uri.toString() + ". Calling callback.");
            callback();
            return;
        }
        var count = 0;
        var loaded = function() { 
            if(++count >= defaultGraphSet.size() + defaultGraphSet.size()) {
                callback();
            }
        };
        
        defaultGraphSet.forEach(function(item) {
            log.debug("adding default graph to dataset: " + _this.uri.toString());
            _this.addDefaultGraph(item, loaded);
        });
            
        
        namedGraphSet.forEach(function(item) {
            log.debug("Adding named graph to dataset: " + _this.uri.toString());
            _this.addNamedGraph(item, loaded);
        });
            
    },
    
    onLoad : function() {
        log.debug("onLoad called");
        this.isLoaded = true;
    },
    
    // ====================================================================================
    // DATASET METHODS
    
    addDefaultGraph : function(graph, callback) {
        if (graph == null)
            throw new Error('anzo.rdf.DatasetBase.addDefaultGraph: The given graph uri is undefined.');
        this._addGraph(graph, callback, true);
    },
    
    addNamedGraph : function(graph, callback) {
        if (graph == null)
            throw new Error('anzo.rdf.DatasetBase.addNamedGraph: The given graph uri is undefined.');
        this._addGraph(graph, callback, false);
    },
    
    _addGraph : function(graph, callback, isDefault) {
        var _this = this;
        var namedGraphURI = this._getGraphURI(graph);
        this._createGraph(graph, function(g) {
            _this._locked = true;
            _this.datasetGraph.add(_this.uri, isDefault ? anzo.client.Vocabulary.defaultGraphProperty : anzo.client.Vocabulary.namedGraphProperty, namedGraphURI);
            _this._locked = false;
            if(dojo.isFunction(callback))
                callback(g);
        });
    },

    removeDefaultGraph : function(graph) {
        if (graph == null)
            throw new Error('anzo.rdf.DatasetBase.removeDefaultGraph: The given graph uri is undefined.');
        this._removeGraph(graph, true);
    },
    
    removeNamedGraph : function(graph) {
        if (graph == null)
            throw new Error('anzo.rdf.DatasetBase.removeNamedGraph: The given graph uri is undefined.');
        this._removeGraph(graph, false);
    },
    
    _removeGraph : function(graph, isDefault) {    
        var namedGraphURI = this._getGraphURI(graph);
        var graph         = isDefault ? this.getDefaultGraph(graph) : this.getNamedGraph(graph);
        
        this.datasetGraph.remove(this.uri, isDefault ? anzo.client.Vocabulary.defaultGraphProperty : anzo.client.Vocabulary.namedGraphProperty, namedGraphURI);
        //graph.close();
    },
    
    setDefaultGraphs : function(graphs, callback) {
        if(!graphs)
            throw new Error('anzo.rdf.DatasetBase.setDefaultGraphs: The given default graph uris are undefined.');
        this._setGraphs(graphs, callback, true)
    },
    
    setNamedGraphs : function(graphs, callback) {
        if(!graphs)
            throw new Error('anzo.rdf.DatasetBase.setNamedGraphs: The given default graph uris are undefined.'); 
        this._setGraphs(graphs, callback, false)
    },
    
    _setGraphs : function(graphs, callback, isDefault) {
        if(!dojo.isArray(graphs)) 
            graphs = [graphs];
        
        // clear old default graphs
        this.datasetGraph.remove(this.uri, isDefault ? anzo.client.Vocabulary.defaultGraphProperty : anzo.client.Vocabulary.namedGraphProperty);
        
        // add new default graphs
        var count = 0;
        var f = function() { 
            if(++count == graphs.length) 
                if(dojo.isFunction(callback)) 
                    callback(); 
        }
        for(var i = 0; i < graphs.length; i++)
            isDefault ? this.addDefaultGraph(graphs[i], f) : this.addNamedGraph(graphs[i], f)
    },

    containsDefaultGraph : function(graph) {
        if (graph == null)
            throw new Error('anzo.rdf.DatasetBase.containsDefaultGraph: The given graph uri is undefined.');
        return this._containsGraph(graph, true);
    },
    
    containsNamedGraph : function(graph) {
        if (graph == null)
            throw new Error('anzo.rdf.DatasetBase.containsNamedGraph: The given graph uri is undefined.');
        return this._containsGraph(graph, false);
    },
    
    _containsGraph : function(graph, isDefault) {
        var namedGraphURI = this._getGraphURI(graph);
        return this.datasetGraph.contains(this.uri, isDefault ? anzo.client.Vocabulary.defaultGraphProperty : anzo.client.Vocabulary.namedGraphProperty, namedGraphURI);
    },

    getDefaultGraphUris : function() {
        return this._getGraphUris(true);
    },
    
    getNamedGraphUris : function() {
        return this._getGraphUris(false);
    },
    
    _getGraphUris : function(isDefault) {
        var visited = {};
        var _array  = [];
        var stmts = this.datasetGraph.find(this.uri, isDefault ? anzo.client.Vocabulary.defaultGraphProperty : anzo.client.Vocabulary.namedGraphProperty);
        for(var i = 0; i < stmts.length; i++) {
            var key = stmts[i].object.dictionaryKey();
            if(!(key in visited)) {
                visited[key] = true;
                _array.push(stmts[i].object);
            }
        }
        return _array;
    },
    
    getNamedGraph : function(graph) {
        if (graph == null)
            throw new Error('anzo.rdf.DatasetBase.getNamedGraph: The given graph uri is undefined.');
        return this._getGraph(graph, false);
    },
    
    getDefaultGraph : function(graph) {
        if (graph == null)
            throw new Error('anzo.rdf.DatasetBase.getNamedGraph: The given graph uri is undefined.');
        return this._getGraph(graph, true);
    },
    
    _getGraph : function(graph, isDefault) {
        var namedGraphURI = this._getGraphURI(graph);
        if(this.datasetGraph.contains(this.uri, isDefault ? anzo.client.Vocabulary.defaultGraphProperty : anzo.client.Vocabulary.namedGraphProperty, namedGraphURI))
            return this._graphs[namedGraphURI.dictionaryKey()];
        return null;
    },
    
    // ====================================================================================
    // IQUADSTORE METHODS
    
    add : function() {
        
        // summary: Adds the given quad(s) to this store.
	    //      Form 1: add(statement)   - takes a single statement and adds it
	    //      Form 2: add(statements)  - takes an array of statements and adds them
	    //      Form 3: add(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.URI) - adds the given quad    
        //      Form 4: add(anzo.rdf.INamedGraph)  - adds all statements of the given graph to this store
        //      Form 5: add(anzo.rdf.IQuadStore) - adds all statements of the given quad store to this store
        
        if(arguments[0] instanceof anzo.rdf.Statement) {
            this._addStatements([arguments[0]]);
        } else if(dojo.isArray(arguments[0])) {
            this._addStatements(arguments[0]);
        } else if(arguments[0] instanceof anzo.rdf.IQuadStore || arguments[0] instanceof anzo.rdf.INamedGraph) {
            this._addStatements(arguments[0].find());
        } else if(arguments[0] && arguments[1] && arguments[2]&& arguments[3]) {
            arguments[3] = (arguments[3] instanceof anzo.rdf.INamedGraph) ? arguments[3].namedGraphUri : arguments[3];
            this._addStatements([anzo.createStatement(arguments[0], arguments[1], arguments[2], arguments[3])]);
        } else {
            throw new Error("Invalid arguments: "+arguments);
        }
	},
	
	_addStatements : function(/*Array*/ statements) {
	    for(var i = 0; i < statements.length; i++) {
	        if(!statements[i].namedGraphUri)
	           throw new Error('Named graph uri is missing.');
	        
	        var _graph = this._graphs[statements[i].namedGraphUri.dictionaryKey()];
	        if(_graph != null)
	           _graph.add(statements[i]);
	        else
	           throw new Error('Named graph in statement not in dataset')
	    }
	},
	
	remove : function() {
		
		// summary: Deletes the given quad(s) from this store.
		//      Form 1: remove(statement) - removes the given statement
		//      Form 2: remove(statements) - removes the given array of statements
		//      Form 3: remove(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.| anzo.rdf.INamedGraph | string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph) - removes the given quad pattern
		//      Form 4: remove(anzo.rdf.INamedGraph) - removes all statements of the given graph from this store
		//      Form 5: remove(anzo.rdf.IQuadStore) - removes all statements of the given quad store from this store
		
		if(arguments[0] instanceof anzo.rdf.Statement) {
            this._removeStatements([arguments[0]]);
        } else if(dojo.isArray(arguments[0])) {
            this._removeStatements(arguments[0]);
        } else if(arguments[0] instanceof anzo.rdf.IQuadStore || arguments[0] instanceof anzo.rdf.INamedGraph) {
            this._removeStatements(arguments[0].find());
        } else if(arguments.length == 0) {
            this.clear();
        } else {
            
            var s = anzo.rdf.getValue(arguments[0], { type: 'resource'});
            var p = anzo.rdf.getValue(arguments[1], {type: 'uri'});
            var o = anzo.rdf.getValue(arguments[2]);
            
            var namedGraphUris = this.getNamedGraphUris(arguments[3]);
            
            var stmts = this.find(s, p, o, namedGraphUris);
            this._removeStatements(stmts);
        }
        
	},
	
	_removeStatements : function(/*Array*/ statements) {
	    for(var i = 0; i < statements.length; i++) {
	        if(!statements[i].namedGraphUri)
	           throw new Error('Named graph uri is missing.');
	        var _graph = this._graphs[statements[i].namedGraphUri.dictionaryKey()];
	        if(_graph != null)
	           _graph.remove(statements[i]);
	        else
	           throw new Error('Named graph in statement not in dataset')
	    }
	},

    clear: function() {
        var namedGraphs = this.getNamedGraphUris();
        for(var i = 0; i < namedGraphs.length; i++) {
            var g = this.getNamedGraph(namedGraphs[i]);
            if(g) {
                g.clear();
                this._removeGraph(namedGraphs[i], false);
            }
        }
        
        var defaultGraphs = this.getDefaultGraphUris();
        for(var i = 0; i < defaultGraphs.length; i++) {
            var g = this.getDefaultGraph(defaultGraphs[i]);
            if(g) {
                g.clear();
                this._removeGraph(defaultGraphs[i], true);
            }
        }
    },

    contains: function(subject, predicate, object, namedGraphUris) {
        var s = anzo.rdf.getValue(arguments[0],   { type: 'resource'});
        var p = anzo.rdf.getValue(arguments[1], {type: 'uri'});
        var o = anzo.rdf.getValue(arguments[2]);
        var ns = this._normalizeNamedGraphs(arguments[3]);
	    if(ns && ns.length == 0)
           return false;
	    return this._contains(s, p, o, ns)
    },
    
    _contains : function(s, p, o, ns) {
        return this._find(s, p, o, ns).length > 0;
    },
    
    find : function() {
	    
	    // summary: Find set of statements that match provided parameters.
		
	    // returns: An array of matching statements.
	    
		// subject : String | anzo.rdf.Resource | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : String | anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : Object | anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
	    
	    // namedGraphUris : String | anzo.rdf.URI | anzo.rdf.INamedGraph | String[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]
	    //  Array of uris used to match the named graph parameter of statements, or wildcard if null
	    
	    
	    var s = anzo.rdf.getValue(arguments[0], {type: 'resource'});
        var p = anzo.rdf.getValue(arguments[1], {type: 'uri'})
        var o = anzo.rdf.getValue(arguments[2]);
        var ns = this._normalizeNamedGraphs(arguments[3]);
	    if(ns && ns.length == 0)
	       return [];
	    return this._find(s, p, o, ns)
	},
	
	_find : function(s, p, o, graphURIs) { 
	    var _array   = [];
	    var _visited = {};
	    var _key     = null;
	    for(var i = 0; i < graphURIs.length; i++) {
	        var g = this.getNamedGraph(graphURIs[i]);
	        if(!g)
	           g = this.getDefaultGraph(graphURIs[i]);
	        _key = g.namedGraphUri.dictionaryKey();
	        if(g && !(_key in _visited)) {
	            _array = _array.concat(g.find(s, p, o));
	            _visited[_key] = true;
	        }
	    }
	    return _array;
	},

    findPreferential : function(includeEntireDataset, subj, prop, obj, namedGraphUris)  {
        console.warn("Depricated method - this method is depricated and will be removed in future releases of anzo.")
        if (includeEntireDataset) {
            var uris    = [];
            var visited = {};
            var key     = null;
            if (namedGraphUris != null && namedGraphUris.length > 0) {
                dojo.forEach(namedGraphUris, dojo.hitch(this, function(uri) {
                    if (uri != null) {
                        uri = anzo.rdf.getValue(uri, {type: 'uri'});
                        key = uri.dictionaryKey();
                        if (!(key in visited) && this.containsNamedGraph(uri)) {
                            visited[key] = true;
                            uris.push(uri);
                        }
                    }
                }));
                var _graphURIs = this.getNamedGraphUris();
                dojo.forEach(_graphURIs, dojo.hitch(this, function(uri) {
                    if (uri != null) {
                        uri = anzo.rdf.getValue(uri, {type: 'uri'});
                        key = uri.dictionaryKey();
                        if (!(key in visited) && this.containsNamedGraph(uri)) {
                            visited[key] = true;
                            uris.push(uri);
                        }
                    }
                    if (this.containsNamedGraph(uri))
                        uris.add(uri);
                }));
                uris = uris.toArray();
            } else {
                uris = this.getNamedGraphUris();
            }
            return this.find(subj, prop, obj, uris);
        } else {
            return this.find(subj, prop, obj, namedGraphUris);
        }
    },

    getStatements : function() {
        return this.find();
    },

    isClosed : function() {
        return this.closed;
    },

    size: function(namedGraphURIs) {
       var ns = this._normalizeNamedGraphs(namedGraphURIs);
       if(ns && ns.length == 0)
           return 0;
       return this._size(ns);
    },
    
    _size : function(ns) {
        return this._find(null, null, null, ns).length;
    },

    close: function() {
        this.closed = true;
        for(var i = 0; i < this._handles.length; i++)
            dojo.disconnect(this._handles[i]);
    },

    isEmpty : function(namedGraphURIs) {
        var ns = this._normalizeNamedGraphs(namedGraphURIs);
        if(ns && ns.length == 0)
           return true;
        return this._isEmpty(ns);
    },
    
    _isEmpty: function(ns) {
        return this._size(ns) == 0;
    },
    
    // ====================================================================================
    // ABSTRACT METHODS - to be implemented by subclasses
    
    createNamedGraph : function(namedGraphUri, callback) {
        throw new Error("Unimplemented method: anzo.rdf.DatasetBase.createNamedGraph"); 
    },

    createDatasetGraph : function(callback) {
        throw new Error("Unimplemented method: anzo.rdf.DatasetBase.createDatasetGraph"); 
    },
    
    // ====================================================================================
    // PRIVATE UTILITY METHODS
    
    _getGraphURI : function(graph) {
        if(graph instanceof anzo.rdf.INamedGraph) 
            return anzo.rdf.getValue(graph.namedGraphUri, {type: 'uri'});
        return anzo.rdf.getValue(graph, {type: 'uri'});
    },
    
    _createGraph : function(graph, callback) {
        var _this = this;
        
        var namedGraphUri = this._getGraphURI(graph);
        
        if(namedGraphUri.dictionaryKey() in _this._graphs) {
            if(dojo.isFunction(callback))
                callback(_this._graphs[namedGraphUri.dictionaryKey()])
        } else {
            _this.loadGraph(namedGraphUri, callback);
        }   
    },
    
    loadGraph : function(graph, callback) {
        var _this = this;
        var namedGraphUri = this._getGraphURI(graph);
        _this.createNamedGraph(namedGraphUri, function(g) {
            _this.cacheGraph(g);
            if(dojo.isFunction(callback))
                callback(g);
        });
    },
    
    cacheGraph : function(graph) {
        var namedGraphUri = this._getGraphURI(graph);
        this._graphs[namedGraphUri.dictionaryKey()] = graph;
    },
    
    removeFromCache : function(namedGraphUri) {
        var g = this._graphs[namedGraphUri.dictionaryKey()];
        if(g) {
            //g.close();
            delete this._graphs[namedGraphUri.dictionaryKey()];
        }
    },
    
    _normalizeNamedGraphs : function(namedGraphUris) {
        var namedGraphURIs   = this.getNamedGraphUris();
        var defaultGraphURIs = this.getDefaultGraphUris();
	    var namedGraphUris   = this._getNamedGraphUris(namedGraphUris);
	    var graphURIs        = [];
	    
	    if(namedGraphUris == null || namedGraphUris.length == 0) {
	        var _visited = {};
	        var _key     = null;
	        for(var i = 0; i < namedGraphURIs.length; i++) {
	            key = namedGraphURIs[i].dictionaryKey();
	            if(!(_key in _visited)) {
	               graphURIs.push(namedGraphURIs[i]);
	               _visited[key] = true;
	            }
	        }
	        for(var i = 0; i < defaultGraphURIs.length; i++) {
	            key = defaultGraphURIs[i].dictionaryKey();
	            if(!(_key in _visited)) {
	               graphURIs.push(defaultGraphURIs[i]);
	               _visited[key] = true;
	            }
	        }
	    } else {
	        var ngSet = {};
            var dgSet = {};
            for(var i = 0; i < namedGraphURIs.length; i++) 
                ngSet[namedGraphURIs[i].dictionaryKey()] = namedGraphURIs[i];
            for(var i = 0; i < defaultGraphURIs.length; i++) 
                dgSet[defaultGraphURIs[i].dictionaryKey()] = defaultGraphURIs[i];
            
            var _visited = {};
	        var key     = null;
	        for(var i = 0; i < namedGraphUris.length; i++) {
	            key = namedGraphUris[i].dictionaryKey();
	            if(!(key in _visited) && (key in ngSet || key in dgSet)) {
	                graphURIs.push(namedGraphUris[i]);
	               _visited[key] = true;
	            }
	        }
	    }
	    return graphURIs;
    },
    
    _getNamedGraphUris : function(values) {
        var array = [];
	    if(values) {
	       if(!dojo.isArray(values))
	           values = [values];
	       for(var i = 0; i < values.length; i++) {
    	       if(values[i] instanceof anzo.rdf.INamedGraph)
    	           array[i] = anzo.rdf.getValue(values[i].namedGraphUri, {type: 'uri'});
    	       else
    	           array[i] = anzo.rdf.getValue(values[i], {type: 'uri'});
    	   }
	    }
	    return array;
	}

});

})();
