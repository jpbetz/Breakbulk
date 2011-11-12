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
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.rdf.DeltaGraph");

// rdf
dojo.require("anzo.rdf.INamedGraph");
dojo.require("anzo.rdf.Statement");

// util
dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.utils.UriGenerator");

dojo.declare('anzo.rdf.DeltaGraph', anzo.rdf.INamedGraph, {
    
    // _fireEvents : Boolean
    //   True enables add/remove events, false disables them.
    _fireEvents   : true,
	
	// _fireUnderlyingGraphEvents : Boolean
	//   True enables add/remove events from the underlying graph to bubble up and fire from this graph, false disables them.
	_fireUnderlyingGraphEvents : false,
    
    // _graph : anzo.rdf.INamedGraph
    //   The underlying graph onto which the deltas are applied.
    _graph        : null,
    
    // _additions : anzo.rdf.NamedGraph
    //   Graph used to keep track of addition deltas.
    _additions   : null,
    
    // _deletions : anzo.rdf.NamedGraph
    //   Graph used to keep track of deletion deltas.
    _deletions   : null,
    
    constructor : function(arg) {
        // summary: Creates and initializes the delta graph.
        
        // arg: anzo.rdf.NamedGraph | anzo.rdf.URI | null
        //   Optional graph that is set as the underlying graph of this delta graph or uri specifying the name of the delta graph.

		this._handles = [];
		
        if(arguments[0] instanceof anzo.rdf.INamedGraph)
            this.setGraph(arguments[0]);
        else if(arguments[0] != null)
            this.namedGraphUri = anzo.rdf.getValue(arguments[0], {type: 'uri'});
        else 
            this.namedGraphUri = anzo.utils.UriGenerator.generateUri('http://openanzo.org/namedGraphs/');
        
        if(this._additions == null || this._deletions == null)
            this._createDeltaStores(this.namedGraphUri);
    },
    
    setGraph : function(graph) {
        // summary: Sets the underlying graph for this delta graph.  Note that this method MUST be called before the 'apply' method is called.        
    	if(this.getGraph() == graph)
            return;
        
        this._graph = graph;
        if(!this.namedGraphUri || !this._graph.namedGraphUri.equals(this.namedGraphUri)) {
            this.namedGraphUri = this._graph.namedGraphUri;
            this._createDeltaStores(this.namedGraphUri);
        }
    },
    
    _createDeltaStores : function(uri) {
        var additions = new anzo.rdf.NamedGraph(uri);
        if(this._additions)
            additions.add(this._additions);
        this._additions = additions;
        
        var deletions = new anzo.rdf.NamedGraph(uri);
        if(this._deletions)
            deletions.add(this._deletions);
        this._deletions = deletions;
        
        this._updateEventConnections();
    },
	
	enableEvents : function(_fireEvents) {
		// summary: Enables or disables the events fired from the delta graph.
		if(this._fireEvents == _fireEvents)
			return;
		this._fireEvents = _fireEvents;
		this._updateEventConnections();
	},
	
	enableUnderlyingGraphEvents : function(_fireUnderlyingGraphEvents) {
		// summary: Enables or disables the events fired from the underlying graph.
		if(this._fireUnderlyingGraphEvents == _fireUnderlyingGraphEvents)
			return;
		this._fireUnderlyingGraphEvents = _fireUnderlyingGraphEvents;
		this._updateEventConnections();
	},
	
	_updateEventConnections : function() {
		// summary: Hooks/unhooks graph events and handlers as specified.
		this._disconnect();
		var underlyingGraph = this.getGraph();
		if(underlyingGraph) {
			this._connect(underlyingGraph, 'statementsAdded',   dojo.hitch(this, 'underlyingGraphStatementsAdded'));
            this._connect(underlyingGraph, 'statementsRemoved', dojo.hitch(this, 'underlyingGraphStatementsRemoved'));
			if(this._fireUnderlyingGraphEvents) {
				this._connect(underlyingGraph, 'statementsAdded',   dojo.hitch(this, '_fireAdded'));
	            this._connect(underlyingGraph, 'statementsRemoved', dojo.hitch(this, '_fireRemoved'));
			}
		}
	},
	
	setProperty : function(s, p, o) {
		this.remove(s, p);
		this.add(s, p, o);
	},
	
	underlyingGraphStatementsAdded   : function(stmts) {},
	underlyingGraphStatementsRemoved : function(stmts) {},
	
	_fireAdded : function(addedStatements) {
		if(this.__lockEvents == 0 && this._fireEvents)
			this.statementsAdded.apply(this, arguments);
	},
	
	_fireRemoved : function(removedStatements) {
		if(this.__lockEvents == 0 && this._fireEvents)
			this.statementsRemoved.apply(this, arguments);
	},
	
	_connect : function(/*Object|null*/ obj,
		/*String|Function*/ event,
		/*String|Function*/ method) {
		// summary: Used to create and keep track of dojo connections.
		this._handles.push(dojo.connect(obj, event, method));
	},
    
    _disconnect : function() {
		// summary: Used to disconnect all the connections created by calling _connect.
        for(var i = 0; i < this._handles.length; i++) 
			dojo.disconnect(this._handles[i]);
		this._handles = [];
    },
    
    getGraph : function() {
        // summary: Returns the underlying graph of this delta graph.
        return this._graph;
    },
    
    add : function(s, p, o) {
        
        // summary: Adds the given triple(s) to this graph.
	    //      Form 1: add(statement)   - takes a single statement and adds it
	    //      Form 2: add(statements)  - takes an array of statements and adds them
	    //      Form 3: add(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.URI) - adds the given triple    
        //      Form 4: add(anzo.rdf.INamedGraph)  - adds all statements of the given graph to this graph
    	
    	if (this._closed) {
            throw new Error("Graph is closed.");
        }
    	if(arguments[0] instanceof anzo.rdf.Statement) {
            this._addStatements([arguments[0]]);
        } else if(dojo.isArray(arguments[0])) {
            this._addStatements(arguments[0]);
        } else if(arguments[0] instanceof anzo.rdf.INamedGraph) {
            this._addStatements(arguments[0].find());
        } else if(arguments[0] != null && arguments[1] != null && arguments[2] != null) {
            var stmt = anzo.createStatement(arguments[0], arguments[1], arguments[2], this.namedGraphUri);
            this._addStatements([stmt]);
        } else {
            throw Error("Invalid arguments: "+arguments);
        }
    	
    	
    },
    
    _addStatements : function(stmts) {
    	
    	var _addStmts = stmts;
    	
    	// don't add statements to the additions delta if they already exist in the underlying graph
    	var underlyingGraph = this.getGraph();
    	if(underlyingGraph) {
    		_addStmts = [];
	    	for(var i = 0; i < stmts.length; i++) {
	    		if(!underlyingGraph.contains(stmts[i]))
	    			_addStmts.push(stmts[i]);
	    	}
    	}
    	
    	this._additions.add(_addStmts);
        this._deletions.remove(stmts);
        
        this._fireAdded(stmts);
        this._fireIfDirtyChanged();
    },
    
    remove : function(s, p, o) {
	    
	    // summary: Deletes the given triple(s) from this graph.
		//      Form 1: remove(statement) - removes the given statement
		//      Form 2: remove(statements) - removes the given array of statements
		//      Form 3: remove(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object) - removes the given triple pattern
		//      Form 4: remove(anzo.rdf.INamedGraph) - removes all statements of the given graph from this graph
    	
    	if (this._closed) {
            throw new Error("Graph is closed.");
        }
    	
    	var underlyingGraph = this.getGraph();
    	if(arguments[0] instanceof anzo.rdf.Statement) {
            this._removeStatements([arguments[0]]);
        } else if(dojo.isArray(arguments[0])) {
            this._removeStatements(arguments[0]);
        } else if(arguments[0] instanceof anzo.rdf.INamedGraph) {
            this._removeStatements(arguments[0].find());
        } else {
        	if (arguments[0] != null && arguments[1] != null && arguments[2] != null) {
        		var stmts = [anzo.createStatement(arguments[0], arguments[1], arguments[2], this.namedGraphUri)];
        	} else {
            	var stmts = underlyingGraph ? underlyingGraph.find(arguments[0], arguments[1], arguments[2]) : [];
            	stmts = stmts.concat(this._additions.find(arguments[0], arguments[1], arguments[2]));
        	}
            this._removeStatements(stmts);
        }
    	
    },
    
    _removeStatements : function(stmts) {
    	
    	
    	var _deleteStmts = stmts;
    	
    	// don't add statements to the deletions delta if they don't exist in the underlying graph
    	var underlyingGraph = this.getGraph();
    	if(underlyingGraph) {
    		_deleteStmts = [];
    		for(var i = 0; i < stmts.length; i++) {
    			if(underlyingGraph.contains(stmts[i]))
    				_deleteStmts.push(stmts[i]);
    		}
    	}
    	
		this._additions.remove(stmts);
		this._deletions.add(_deleteStmts);
		
		this._fireRemoved(stmts);
		this._fireIfDirtyChanged();
    },
    
	find : function(s, p, o)  { 
	    
	    // summary: Find set of statements that match provided parameters.
		
	    // returns: An array of matching statements.
	    
		// subject : String | anzo.rdf.Resource | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : String | anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : Object | anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
	    
    	if (this._closed) {
            throw new Error("Graph is closed.");
        }
    	
    	var underlyingGraph = this.getGraph();
    	
	    var stmts  = underlyingGraph ? underlyingGraph.find(s, p, o) : [];
	    var dStmts = this._deletions.find(s, p, o);
	    var aStmts = this._additions.find(s, p, o);
	    
	    var _set = {};
	    
	    for(var i = 0; i < stmts.length; i++)
	        _set[stmts[i].dictionaryKey()] = stmts[i];

	    for(var i = 0; i < dStmts.length; i++)
	       delete _set[dStmts[i].dictionaryKey()];
	    
	    for(var i = 0; i < aStmts.length; i++)
	       _set[aStmts[i].dictionaryKey()] = aStmts[i];
	    
	    return anzo.utils.values(_set);
	},
	
	contains : function(s, p, o)  { 
	    
	    // summary: Tests if a statement (pattern) is contained in the graph that match provided parameters.
	    
	    // returns: True if the given pattern is found in this graph, false otherwise.
	    
	    // subject : String | anzo.rdf.Resource | anzo.rdf.Statement | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : String | anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : Object | anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
	    
		if(arguments[0] instanceof anzo.rdf.Statement)
            return this.contains(arguments[0].subject, arguments[0].predicate, arguments[0].object);
		
	    return this.find(s, p, o).length > 0;
	},
	
	size : function()  { 
	    // summary: Return number of statements in graph.
	    // returns: Number of statements in graph.
	    
	    return this.find().length;
	},
	
	isEmpty : function() { 
	    // summary: Return if graph is empty.
	    // returns: Returns true if the number of statements in this graph is zero, false otherwise.
	    return this.size() == 0;
	},
	
	isClosed : false,
	
	isClosed : function() { 
	    // summary: Return if graph is closed.
	    // returns: True if the graph is closed, false otherwise.
	    return this.isClosed;
	},
	
	close : function() { 
	    // summary: Close the graph by releasing all resources.
	    this.isClosed = true;
	    this._disconnect();
	},
	
	clear : function()  { 
	    // summary: Removes all statements from this graph.
	    this.remove();
	},
	
	__lockEvents : 0,
	
	apply : function() {
		var underlyingGraph = this.getGraph();
		
	    if(underlyingGraph == null)
	       throw Error("Target graph is unspecified.  Deltas cannot be applied.");
	    
		this.__lockEvents++; // no need to fire events when applying (since the view of the graph does not change to the user)
		
		underlyingGraph.remove(this._deletions);
		underlyingGraph.add(this._additions);
	    
		this.reset();
		
		this.__lockEvents--;
		
		this._fireIfDirtyChanged();
	},
	
	abort : function() {
	    if(this._fireEvents) {
    	    var additions = this._deletions.find();
    	    var deletions = this._additions.find();
	    }
	    
	    this.reset();
	    
	    if(this._fireEvents) {
    	    this.statementsRemoved(deletions);
    	    this.statementsAdded(additions);
	    }
	    this._fireIfDirtyChanged();
	},
	
	reset : function() {
		this._deletions.clear();
	    this._additions.clear();
	},
	
	_fireIfDirtyChanged : function() {
	    var newDirty = this.isDirty();
	    if(this._dirty != newDirty) {
	        this._dirty = newDirty;
	        this.onDirtyChange(newDirty);
	    }
	},
	
	onDirtyChange : function(dirty) {
	    // summary: Event that fires when the dirty flag is changed.
	},
	
	isDirty : function() {
	    return (!this._additions.isEmpty() || !this._deletions.isEmpty())
	}

});