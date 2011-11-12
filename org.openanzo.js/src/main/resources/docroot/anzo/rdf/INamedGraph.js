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
 
dojo.provide("anzo.rdf.INamedGraph"); 


dojo.declare('anzo.rdf.INamedGraph', null, {
	
	// summary:
	//     An RDF graph that holds a collection of anzo.rdf.Statements. 
	//     A named graph also has a name in the form of a URI (a.k.a. 
	//     namedGraphUri) associated with it. This name is used to 
	//     identify the graph. Arguments to the public methods such 
	//     as find, add, etc can be passed as values or as anzo.rdf.Values, 
	//     or any combination of the two.
	
	
	// namedGraphUri : anzo.rdf.URI
	//  The URI used to identify this graph.
	namedGraphUri : null,
	
    add : function()  { 
	    
	    // summary: Adds the given triple(s) to this graph.
	    //      Form 1: add(statement)   - takes a single statement and adds it
	    //      Form 2: add(statements)  - takes an array of statements and adds them
	    //      Form 3: add(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object, string | anzo.rdf.URI) - adds the given triple    
        //      Form 4: add(anzo.rdf.INamedGraph)  - adds all statements of the given graph to this graph
        //      Form 5: add(anzo.rdf.IQuadStore) - adds all statements of the given triple graph to this graph
        
        throw new Error("Unimplemented method: anzo.rdf.INamedGraph.add"); 
    },

	remove : function()  { 
	    
	    // summary: Deletes the given triple(s) from this graph.
		//      Form 1: remove(statement) - removes the given statement
		//      Form 2: remove(statements) - removes the given array of statements
		//      Form 3: remove(string | anzo.rdf.Resource, string | anzo.rdf.URI, Object) - removes the given triple pattern
		//      Form 4: remove(anzo.rdf.INamedGraph) - removes all statements of the given graph from this graph
		//      Form 5: remove(anzo.rdf.IQuadStore) - removes all statements of the given triple graph from this graph
		
        throw new Error("Unimplemented method: anzo.rdf.INamedGraph.remove"); 
    },
    
	find : function()  { 
	    
	    // summary: Find set of statements that match provided parameters.
		
	    // returns: An array of matching statements.
	    
		// subject : String | anzo.rdf.Resource | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : String | anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : Object | anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
	    
	    
	    throw new Error("Unimplemented method: anzo.rdf.INamedGraph.find"); 
	},
	
	getStatements : function() {
    	// summary: Return all the statements in the graph
		
	    // returns: An array of statements.
    	
    	throw new Error("Unimplemented method: anzo.rdf.INamedGraph.find"); 
    },
	
	contains : function()  { 
	    
	    // summary: Tests if a statement (pattern) is contained in the graph that match provided parameters.
	    
	    // returns: True if the given pattern is found in this graph, false otherwise.
	    
	    // subject : String | anzo.rdf.Resource | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : String | anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : Object | anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
	    
	    throw new Error("Unimplemented method: anzo.rdf.INamedGraph.contains"); 
	},
	
	size : function()  { 
	    // summary: Return number of statements in graph.
	    // returns: Number of statements in graph.
	    throw new Error("Unimplemented method: anzo.rdf.INamedGraph.size"); 
	},
	
	isEmpty : function() { 
	    // summary: Return if graph is empty.
	    // returns: Returns true if the number of statements in this graph is zero, false otherwise.
	    throw new Error("Unimplemented method: anzo.rdf.INamedGraph.isEmpty"); 
	},
	
	isClosed : function() { 
	    // summary: Return if graph is closed.
	    // returns: True if the graph is closed, false otherwise.
	    throw new Error("Unimplemented method: anzo.rdf.INamedGraph.isClosed"); 
	},
	
	
	close : function() { 
	    // summary: Close the graph by releasing all resources.
	    throw new Error("Unimplemented method: anzo.rdf.INamedGraph.close"); 
	},
	
	clear : function()  { 
	    // summary: Removes all statements from this graph.
	    throw new Error("Unimplemented method: anzo.rdf.INamedGraph.clear"); 
	},

	
    // ------------------------------------------
	// EVENTS
	
	statementsAdded : function(statements) {
	    // summary: Event called when statements are added to this graph.
	    
	    // statements : anzo.rdf.Statement[]
	    //  Array of statemetns that are added to this graph.
	},
	
	statementsRemoved : function(statements) {
	    // summary: Event called when statements are removed from this graph.
	    
	    // statements : anzo.rdf.Statement[]
	    //  Array of statements removed from this graph.
	}
	
});