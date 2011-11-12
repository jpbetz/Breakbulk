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
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.rdf.GraphResource");

dojo.require('anzo.rdf.Statement');

dojo.declare('anzo.rdf.GraphResource', null, {
    
    // summary:
    //      A "bean" that takes a resource and a graph and provides convenience methods to 
    //      access and set the properties of the given resource in the given graph.
    
    
    // resource : String | anzo.rdf.Resource
    //  The resource of which properties are read and modified.
    resource : null,
    
    // graph : anzo.rdf.INamedGraph
    //  The graph from which data is read from and to which data is written to.
    graph : null,
    
    // stubs : Array
    //  The array that stores the event connection stubs.
    stubs : null,
    
    constructor : function(resource, graph, properties) {
        
        // resource : String | anzo.rdf.Resource
        //  The resource of which properties are read and modified.
        
        // graph : anzo.rdf.INamedGraph
        //  The graph from which data is read from and to which data is written to.
        
        // properties : anzo.rdf.URI[] | String[] | String | anzo.rdf.URI
        //  Optional array of predicates or string URI or an anzo URI object for which methods are created.
        
        this.resource = anzo.rdf.getValue(resource, { type : 'resource' } );
        this.graph    = graph;
        
        if(this.resource == null || this.graph == null)
            throw Error ("Invalid arguments");
        
        if(properties)
            this.createPropertyMethods(properties);
        
        this.stubs = [];
    },
    
    getProperty : function(predicate) {
        
        // summary: 
        //      Returns the objects of the statements found by the given predicate.
        
        // returns: 
        //      Returns an array of values (objects found in statements by querying the graph with the pattern { this.subject, predicate, ? }
        
        // predicate : String | anzo.rdf.URI
	    //  The predicate for which the value is returned.
        
        var stmts = this.graph.find(this.resource, predicate, null);
        var vals = [];
        for(var i = 0; i < stmts.length; i++)
            vals[i] = stmts[i].object;
        return vals;
    },
    
    createPropertyMethods : function(arg) {
        
        // summary:
        //  Creates methods for the specified predicate(s).
        
        // args : anzo.rdf.URI[] | String[] | String | anzo.rdf.URI
        //  Array of predicates or string URI or an anzo URI object for which methods are created.
        
        if(dojo.isArray(arg)) {
            for(var i = 0; i < arg.length; i++) {
                this._createPropertyMethods(arg[i]);
            }
        } else {
            this._createPropertyMethods(arg);
        }
    },
    
    _createPropertyMethods : function(predicate) {
		
		// summary: 
		//    Creates methods for the given predicate.
		
		// description: 
		//    The created methods are:
		//        1. get: 'get'+predicate.getLocalName() (http://xmlns.com/foaf/0.1/firstName -> getFirstName)
        //        2. set: 'set'+predicate.getLocalName() (http://xmlns.com/foaf/0.1/firstName -> setFirstName)
        //        3. add: 'add'predicate.getLocalName() (http://xmlns.com/foaf/0.1/firstName -> addFirstName)
        //        4. remove: 'remove'+predicate.getLocalName() (http://xmlns.com/foaf/0.1/firstName -> removeFirstName)
        //        5. removeAll: 'removeAll'+predicate.getLocalName() (http://xmlns.com/foaf/0.1/firstName -> removeAllFirstName) 
		
		// predicate : String | anzo.rdf.URI
	    //  The predicate for which methods are generated.
		
		// get/update predicate constraints
		
		var p = anzo.rdf.getValue(predicate, {type: 'uri'})
		
		if(p == null)
            return;
        
		// create methods
		
		this._createGetMethod(p); 		// get
		
		this._createAddMethod(p); 		// add
		this._createRemoveMethod(p); 	// remove
		this._createRemoveAllMethod(p); // remove all
	
		this._createSetMethod(p); 		// set
		
	},
	
	
	// ------------------------------------------------------------
	// EVENT LISTENER METHODS
	
	connect : function(predicate, callback) {
	    
	    // summary: Connects the given callback method to events that fire when statements with the given predicate change.
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate used to filter events.
	    
	    var _this = this;
	    var _predicate = anzo.rdf.getValue(predicate, {type: 'uri'})
	    if(_predicate != null) {
	        var obj = {};
	        var handler = function(stmts) {
	           var _stmts = [];
	           for(var i = 0; i < stmts.length; i++) {
	               if(stmts[i].predicate.equals(_predicate))
	                   _stmts.push(stmts[i]);
	           }
	           if(_stmts.length > 0)
	               callback(_this.graph, _stmts);
	        }
	        obj.statementsAddedStub   = dojo.connect(this.graph, 'statementsAdded', handler);
	        obj.statementsRemovedStub = dojo.connect(this.graph, 'statementsRemoved', handler);
	        this.stubs.push(obj);
	        return obj;
	    }
	    return null;
	},
	
	disconnect : function(stub) {
	    // summary: Disconnects the connection identified by the given stub.
	    
	    // stub : Object
	    //  Object used to identify the target connection.
	    
	    if(stub) {
	        if(stub.statementsAddedStub)
	           dojo.disconnect(stub.statementsAddedStub);
	        if(stub.statementsRemovedStub) 
	           dojo.disconnect(stub.statementsRemovedStub);
	    }
	},
	
	disconnectAll : function() {
	    // summary: Disconnects all connected listeners.
	    for(var i = 0; i < this.stubs.length; i++)
	        this.disconnect(this.stubs[i]);
	},
	
	// ------------------------------------------------------------
	// CREATE PROPERTY METHODS (get, add, remove, removeAll, set, onChange)
	
	_createGetMethod : function(predicate) {
		
		// summary: Creates a get method for the given predicate.
	    // description:
	    //       The get method performs the following opperations:
	    //         1. return the value of ? after calling graph.find(this.resource, predicate, ?)
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the get method is created.
	    
		var _this = this;
		var _getMName = this.getGetMethodName(predicate);
		if(!this[_getMName]) {
			this[_getMName] = function() {
				// TODO: MAYBE I SHOULD RETURN RESOURCE OBJECTS INSTEAD OF RDF NODES...
				var triples = _this.graph.find(_this.resource, predicate);
				var vals = new Array();
				for(var i = 0; i < triples.length; i++) 
					vals.push(triples[i].object);
				return vals;
			}
		}
		return this[_getMName];
	},
	
	_createAddMethod : function(predicate) {
	    
	    // summary: Creates a add method for the given predicate.
	    // description:
	    //       The add method performs the following opperations:
	    //         1. add (this.resource, predicate, value)
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the add method is created.
	    
	    
		var _this = this;
		var _addMName = this.getAddMethodName(predicate);
		if(!this[_addMName]) {
			this[_addMName] = function(val) {
				// TODO: ADD CONSTRAINT VALIDATION
				_this.graph.add(_this.resource, predicate, val);
			}
		}
		return this[_addMName];
	},
	
	_createRemoveMethod : function(predicate) {
	    
	    // summary: Creates a remove method for the given predicate.
	    // description:
	    //       The remove method performs the following opperations:
	    //         1. removes (this.resource, predicate, value)
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the remove method is created.
	    
		var _this = this;
		var _removeMName = this.getRemoveMethodName(predicate);
		if(!this[_removeMName]) {
			this[_removeMName] = function(val) {
				_this.graph.remove(_this.resource, predicate, val);
			}
		}
		return this[_removeMName];
	},
	
	_createRemoveAllMethod : function(predicate) {
	    
	    // summary: Creates a removeAll method for the given predicate.
	    // description:
	    //       The removeAll method performs the following opperations:
	    //         1. removes (this.resource, predicate, ?)
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the removeAll method is created.
	    
		var _this = this;
		var _removeAllMName = this.getRemoveAllMethodName(predicate);
		if(!this[_removeAllMName]) {
			this[_removeAllMName] = function(val) {
				_this.graph.remove(_this.resource, predicate);
			}
		}
		return this[_removeAllMName];
	},
	
	_createSetMethod : function(predicate) {
	    
	    // summary: Creates a set method for the given predicate.
	    // description:
	    //       The set method performs the following opperations:
	    //         1. removes (this.resource, predicate, ?)
	    //         2. if the given value is not null, add a triple (this.resource, predicate, value)
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the set method is created.
	    
		var _this = this;
		var _setMName = this.getSetMethodName(predicate);
		if(!this[_setMName]) {
			this[_setMName] = function(val) {
				_this.graph.remove(_this.resource, predicate);
				if(val != null)
				    _this.graph.add(_this.resource, predicate, val);
			}
		}
		return this[_setMName];
	},
	
	// ------------------------------------------------------------
	// RETURN PROPERTY METHOD NAMES (get, add, remove, remove all, set, on change)
	
	_getMethodName : function(predicate, type) {
	    
	    // summary: 
	    //     Helper method to get the given type of method name for the given predicate.
	    
	    // returns: 
	    //     Name of the given type of method for the given predicate.
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the method name is returned.
	    
	    // type : String
	    //  String that specifies the method type.  Is one of the following: get, add, remove, removeAll, set
	    
	    var p = anzo.rdf.getValue(predicate, {type : 'uri'});
	    if(type == 'get' || type == 'add' || type == 'remove' || type == 'removeAll' || type == 'set') {
	        var s = type+p.getLocalName().substr(0, 1).toUpperCase();
			if(p.getLocalName().length > 1)
				s += p.getLocalName().substr(1, p.getLocalName().length-1);
			return s;
	    }
	    return null;
	},
	
	getGetMethodName : function(predicate) {
	    // summary: 
	    //     Returns the get method name for the given predicate.
	    //         http://xmlns.com/foaf/0.1/firstName -> getFirstName
	    
	    // returns: Name of the get method for the given predicate.
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the get method name is returned.
		return this._getMethodName(predicate, 'get');
	},
	
	getAddMethodName : function(predicate) {
	    // summary: 
	    //     Returns the add method name for the given predicate.
	    //         http://xmlns.com/foaf/0.1/knows -> addKnows
	    
	    // returns: Name of the add method for the given predicate.
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the add method name is returned.
		return this._getMethodName(predicate, 'add');
	},
	
	getRemoveMethodName : function(predicate) {
	    // summary: 
	    //     Returns the remove method name for the given predicate.
	    //         http://xmlns.com/foaf/0.1/knows -> removeKnows
	    
	    // returns: Name of the remove method for the given predicate.
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the remove method name is returned.
		return this._getMethodName(predicate, 'remove');
	},
	
	getRemoveAllMethodName : function(predicate) {
	    // summary: 
	    //     Returns the removeAll method name for the given predicate.
	    //         http://xmlns.com/foaf/0.1/knows -> removeAllKnows
	    
	    // returns: Name of the removeAll method for the given predicate.
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the removeAll method name is returned.
		return this._getMethodName(predicate, 'removeAll');
	},
	
	getSetMethodName : function(predicate) {
	    // summary: 
	    //     Returns the set method name for the given predicate.
	    //         http://xmlns.com/foaf/0.1/firstName -> setFirstName
	    
	    // returns: Name of the set method for the given predicate.
	    
	    // predicate : String | anzo.rdf.URI
	    //  The predicate for which the set method name is returned.
	    
		return this._getMethodName(predicate, 'set');
	}
	
});