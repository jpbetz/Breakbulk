/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
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
 
dojo.provide("anzo.rdf.BaseQuadStore");

dojo.require('anzo.rdf.Statement');

dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.rdf.IQuadStore");
dojo.require("anzo.rdf.INamedGraph");

dojo.declare('anzo.rdf.BaseQuadStore', anzo.rdf.IQuadStore, {

    // summary: Abstract implementation of the anzo.rdf.IQuadStore.

    // --------------------------
    // ADD
    
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
        } else if(arguments[0] != null && arguments[1] != null && arguments[2] != null && arguments[3] != null) {
            arguments[3] = (arguments[3] instanceof anzo.rdf.INamedGraph) ? arguments[3].namedGraphUri : arguments[3];
            this._addStatements([anzo.createStatement(arguments[0], arguments[1], arguments[2], arguments[3])]);
        } else {
            throw Error("Invalid arguments: "+arguments);
        }
	},
	
	_addStatements : function(/*Array*/ statements) {
	    // description: Abstract method that must be implemented by subclasses.
		throw new Error("Unimplemented method: anzo.rdf.BaseQuadStore._addStatements"); 
	},
	
	// -------------------------------
	// REMOVE
	
	remove : function() {
		
		// summary: Deletes the given quad(s) from this store.
		//      Form 1: remove(statement) - removes the given statement
		//      Form 2: remove(statements) - removes the given array of statements
		//      Form 3: remove(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.URI | anzo.rdf.INamedGraph | string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph) - removes the given quad pattern
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
            
            var s = anzo.rdf.getValue(arguments[0], {type: 'resource'});
            var p = anzo.rdf.getValue(arguments[1], {type: 'uri'});
            var o = anzo.rdf.getValue(arguments[2]);
            
            var namedGraphUris = this._getNamedGraphUris(arguments[3]);
            
            var stmts = this.find(s, p, o, namedGraphUris);
            this._removeStatements(stmts);
        }
        
	},
	
	_removeStatements : function(/*Array*/ statements) {
	    // description: Abstract method that must be implemented by subclasses.
		throw new Error("Unimplemented method: anzo.rdf.BaseQuadStore._removeStatements"); 
	},
	
	// -------------------------------
    // CONTAINS
    
	contains  : function() {
	    
	    // summary: Tests if a statements are contained in this store that match provided parameters.
		//      Form 1: contains(statement) - checks if the given statement exists in this store
		//      Form 2: contains(statements) - checks if the given array of statements exist in this store
		//      Form 3: contains(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.URI | anzo.rdf.INamedGraph | string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]) - checks if the given pattern exists in this store
	    
	    // returns: True if the given pattern is found in this store, false otherwise
	    
	    if(arguments[0] instanceof anzo.rdf.Statement) {
            return this.contains(arguments[0].subject, arguments[0].predicate, arguments[0].object, arguments[0].namedGraphUri ? [arguments[0].namedGraphUri] : null);
        } else if(dojo.isArray(arguments[0])) {
            for(var i = 0; i < arguments[0].length; i++) {
    	        if(!this.contains(arguments[0][i].subject, arguments[0][i].predicate, arguments[0][i].object, arguments[0][i].namedGraphUri ? [arguments[0][i].namedGraphUri] : null)) 
    	           return false;
    	    }
    	    return true;
        } else {
            
        	var s = anzo.rdf.getValue(arguments[0], {type: 'resource'});
            var p = anzo.rdf.getValue(arguments[1], {type: 'uri'});
            var o = anzo.rdf.getValue(arguments[2]);
            
            var namedGraphUris = this._getNamedGraphUris(arguments[3]);
            return this._contains(s, p, o, namedGraphUris);
        }

	},
	
	_contains  : function(subject, predicate, object, namedGraphUris) {
	    // description: Abstract method that must be implemented by subclasses.
	    return this._find(subject, predicate, object, namedGraphUris).length > 0;
	},
	
	// ------------------------
	// FIND
	
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
        var p = anzo.rdf.getValue(arguments[1], {type: 'uri'});
        var o = anzo.rdf.getValue(arguments[2]);
        var namedGraphUris = this._getNamedGraphUris(arguments[3]);
	    
	    return this._find(s, p, o, namedGraphUris);
	},
	
	getStatements : function() {
    	// summary: Return all the statements in the quad store
		
	    // returns: An array of statements.
    	
    	return this.find(null, null, null, null);
    },
	
	_find : function(subject, predicate, object, namedGraphUris) {
	    // description: Abstract method that must be implemented by subclasses.
	    throw new Error("Unimplemented method: anzo.rdf.BaseQuadStore._find"); 
	},
	
	// ------------------------
	// IS EMPTY
	
	isEmpty : function() {
	    
	    // summary:
		//      Form 1: isEmpty() - checks if this store is empty
		//      Form 2: isEmpty(string | anzo.rdf.URI | anzo.rdf.INamedGraph) - checks if statements by the given named graph URI exist in the quad store
		//      Form 3: isEmpty(string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]) - checks if statements by the given named graph URIs exist in the quad store
	    
	    var namedGraphUris = this._getNamedGraphUris(arguments[0]);
	    return this._isEmpty(namedGraphUris);
	},
	
	_isEmpty : function(namedGraphUris) {
	    
	    // returns:
	    //     Returns true if the number of statements in the store for the given namedGraphUris is zero, false otherwise.
	    //     If namedGraphUris is empty, returns true if the the total number of statements in this store is zero, false otherwise.
	    
	    return this.size(namedGraphUris) == 0;
	},
	
	// -------------------------
	// SIZE
	
	size : function() {
	    
	    // summary:
		//      Form 1: size() - gets number of quads in the store
		//      Form 2: size(string | anzo.rdf.URI | anzo.rdf.INamedGraph) - gets number of quads in the store with the given named graph URI
		//      Form 3: size(string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]) - gets number of quads in the store with the given named graph URIs
	    
	    
	    var namedGraphUris = this._getNamedGraphUris(arguments[0]);
	    return this._size(namedGraphUris);
	},
	
	_size : function(namedGraphUris) {
	    
	    // summary: 
	    //     Returns the number of statements in the store for given namedGraphUris.
	    //     If the given named graph uris are not specified, it returns the total 
	    //     number of statemetns in the store.
	    
	    // description: Abstract method that must be implemented by subclasses.
	    
	    // returns:
	    //     The number of statements in the store for the given namedGraphUris.
	    //     If namedGraphUris is null, returns the total number of statements in this store.
	    
	    // namedGraphUris : String[] | anzo.rdf.URI[] | null
	    //  Array of uris used to determine the total sizes of specified graphs.
	    
	    throw new Error("Unimplemented method: anzo.rdf.BaseQuadStore._size"); 
	},
	
	// ------------------------------------------
	// UTILITIES
	
	_getNamedGraphUris : function(values) {
	    if(!values)
	       return [];
        if(!dojo.isArray(values))
           values = [values];
        for(var i = 0; i < values.length; i++) {
	       if(values[i] instanceof anzo.rdf.INamedGraph)
	           values[i] = anzo.rdf.getValue(values[i].namedGraphUri, {type: 'uri'});
	       else 
	           values[i] = anzo.rdf.getValue(values[i], {type: 'uri'});
	    }
	    return values;
	}
	
});