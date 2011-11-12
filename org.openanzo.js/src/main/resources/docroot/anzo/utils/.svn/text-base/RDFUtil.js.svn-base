
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
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
 
dojo.provide("anzo.utils.RDFUtil");

dojo.mixin(anzo.utils, {
    
    filterStatements : function(statements, subject, predicate, object) {
    	
    	// summary:
    	//     Filters the given array of statements by the given triple pattern.
    	
    	// statements : anzo.rdf.Statement[]
    	//  Array of statements that are to be filtered based on the given triple pattern.
    	
    	// subject : anzo.rdf.Resource | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
    	
    	statements = statements ? statements : []; // null statements argument is okay
    	return dojo.filter(statements, 
    						function matchStatement(statement) { 
    							return anzo.utils.statementMatcher(statement, subject, predicate, object);
    						});
    },
    
    statementMatcher : function(/* Statement */ statement, /*Node*/ subject, /*Node*/ predicate, /*Node*/ object) {
    	
    	// summary: Matches the given subject, predicate and object pattern with the given statement.
    	
    	// statmenet : anzo.rdf.Statement
    	//  The statement against which the pattern is matches.
    	
    	// subject : anzo.rdf.Resource | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
    	
    	if(subject != null && !statement.subject.equals(subject))
    		return false;
    	if(predicate != null && !statement.predicate.equals(predicate))
    		return false;
    	if(object != null && !statement.object.equals(object))
    		return false;
    	return true;
    },
    
    findAcrossGraphs : function(graphsArray, /*Node*/ subject, /*Node*/ predicate, /*Node*/ object) {
        
        // summary: Calls find with the given arguments on each graph in the given array and returns the union of the resulting statements.
    	
    	// graphsArray : INamedGraph[]
    	//  Array of graphs.
    	
    	// subject : anzo.rdf.Resource | String | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : anzo.rdf.URI | String | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : anzo.rdf.Value | Object | null
	    //  Object value to match, or wildcard if null
	    
	    // returns: An array of statements.

        var _stmts   = [];
        var _visited = {};
	    var _key     = null;
	    
        if(graphsArray && dojo.isArray(graphsArray)) {
            for(var i = 0; i < graphsArray.length; i++) {
                _key = graphsArray[i].namedGraphUri.dictionaryKey();
                if(!(_key in _visited)) {
                    _stmts = _stmts.concat(graphsArray[i].find(subject, predicate, object));
                    _visited[_key] = true;
                }
            }
        }
        return _stmts;
    }
    
});