/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.client.Precondition");


dojo.declare('anzo.client.Precondition', null, {
    
    // summary: A Precondition is nothing more than a SPARQL query and an expected result. In the current implementation of Anzo server and for the forseeable future, only SPARQL ASK queries are supported. That is, queries about the state of the named graphs in the system, and have a simple true or false answer. The caller supplies the usual query (query string, default graphs, and named graphs), as well as the expected answer, true or false. The reader need only think briefly about the mechanism to understand that more complicated preconditions provide no extra benefit. Any general SPARQL query such as a SELECT, and expect result set, can be rewritten as an ASK query where the expected select results are built into the ASK query.
    
    constructor : function(askQueryString, askResult, namedGraphUris, defaultGraphUris) {
       
       // summary: 
       //  Construct a new Precondition
       
       // askQueryString: String
       //  The query string
       
       // askResult: Boolean 
       //  True if the result of the ask query is true, false otherwise.
       
       // namedGraphUris: anzo.rdf.URI[]
       //  Array of named graph URIs.
       
       // defaultGraphUris: anzo.rdf.URI[]
       //  Default named grpah URIs used to execute the given query.
       
       this.askQueryString   = askQueryString;
       this.askResult        = askResult;
       this.namedGraphUris   = namedGraphUris;
       this.defaultGraphUris = defaultGraphUris;
    }
	
});