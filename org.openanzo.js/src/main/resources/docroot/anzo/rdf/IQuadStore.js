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
 
dojo.provide("anzo.rdf.IQuadStore"); 


dojo.declare('anzo.rdf.IQuadStore', null, {
    
    // summary: 
    //      The superclass of all Stores that store statements where each statement 
    //      has its subject, predicate, object and namedGraphUri specified (thereby 
    //      making it a quad). Arguments to the public methods such as find, add, etc 
    //      can be passed as values or as anzo.rdf.Values, or any combination of the two.
	
	add : function() { 
	    
	    // summary: Adds the given quad(s) to this store.
	    //      Form 1: add(statement)   - takes a single statement and adds it
	    //      Form 2: add(statements)  - takes an array of statements and adds them
	    //      Form 3: add(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.URI) - adds the given quad    
        //      Form 4: add(anzo.rdf.INamedGraph)  - adds all statements of the given graph to this store
        //      Form 5: add(anzo.rdf.IQuadStore) - adds all statements of the given quad store to this store
        
        
        throw new Error("Unimplemented method: anzo.rdf.IQuadStore.add"); 
	},
	
	remove : function() { 
	    // summary: Deletes the given quad(s) from this store.
		//      Form 1: remove(statement) - removes the given statement
		//      Form 2: remove(statements) - removes the given array of statements
		//      Form 3: remove(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.URI | anzo.rdf.INamedGraph | string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph) - removes the given quad pattern
		//      Form 4: remove(anzo.rdf.INamedGraph) - removes all statements of the given graph from this store
		//      Form 5: remove(anzo.rdf.IQuadStore) - removes all statements of the given quad store from this store
		
	    throw new Error("Unimplemented method: anzo.rdf.IQuadStore.remove"); 
	},
	
	find : function(subject, predicate, object, namedGraphUris) { 
	    
	    // summary: Find set of statements that match provided parameters.
		
		// subject : String | anzo.rdf.Resource | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : String | anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : Object | anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
	    
	    // namedGraphUris : String | anzo.rdf.URI | anzo.rdf.INamedGraph | String[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]
	    //  Array of uris used to match the named graph parameter of statements, or wildcard if null
	    
	    // returns: An array of matching statements.
	    
		throw new Error("Unimplemented method: anzo.rdf.IQuadStore.find"); 
    },
    
    getStatements : function() {
    	// summary: Return all the statements in the quad store
		
	    // returns: An array of statements.
    	
    	throw new Error("Unimplemented method: anzo.rdf.IQuadStore.getStatements"); 
    },

	contains  : function() { 
	    // summary: Tests if a statements are contained in this store that match provided parameters.
		//      Form 1: contains(statement) - checks if the given statement exists in this store
		//      Form 2: contains(statements) - checks if the given array of statements exist in this store
		//      Form 3: contains(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.URI | anzo.rdf.INamedGraph | string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]) - checks if the given pattern exists in this store
	    
	    // returns: True if the given pattern is found in this store, false otherwise
	    
	    throw new Error("Unimplemented method: anzo.rdf.IQuadStore.contains"); 
	},
	
	clear : function () { 
	    // summary: Remove all statements from this store.
	    throw new Error("Unimplemented method: anzo.rdf.IQuadStore.clear"); 
	},

	isEmpty : function(namedGraphUris) { 
	    
	    // summary:
		//      Form 1: isEmpty() - checks if this store is empty
		//      Form 2: isEmpty(string | anzo.rdf.URI | anzo.rdf.INamedGraph) - checks if statements by the given named graph URI exist in the quad store
		//      Form 3: isEmpty(string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]) - checks if statements by the given named graph URIs exist in the quad store
	    
	    throw new Error("Unimplemented method: anzo.rdf.IQuadStore.isEmpty"); 
	},

	size : function(namedGraphUris) { 
	    
	    // summary:
		//      Form 1: size() - gets number of quads in the store
		//      Form 2: size(string | anzo.rdf.URI | anzo.rdf.INamedGraph) - gets number of quads in the store with the given named graph URI
		//      Form 3: size(string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]) - gets number of quads in the store with the given named graph URIs
	    
	    throw new Error("Unimplemented method: anzo.rdf.IQuadStore.size"); 
	},

	getNamedGraphUris : function () { 
	    // summary: Return the set of namedGraphUris contained within this store.
	    // returns: An array of named graph uris contained in this store.
	    throw new Error("Unimplemented method: anzo.rdf.IQuadStore.getNamedGraphUris"); 
	},
	
	// ------------------------------------------
	// EVENTS
	
	statementsAdded : function(statements) {
	    // summary: Event called when statements are added to this store.
	    
	    // statements : anzo.rdf.Statement[]
	    //  Array of statemetns that are added to this store.
	},
	
	statementsRemoved : function(statements) {
	    // summary: Event called when statements are removed from this store.
	    
	    // statements : anzo.rdf.Statement[]
	    //  Array of statements removed from this store.
	}
	
});