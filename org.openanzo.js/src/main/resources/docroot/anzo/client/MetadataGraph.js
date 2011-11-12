/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.client.MetadataGraph");

dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.utils.UriGenerator");
dojo.require("anzo.utils.JSUtil");


/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)  
 */
 
dojo.declare('anzo.client.MetadataGraph', anzo.rdf.NamedGraph, {
    
    // summary: The Anzo metadata graph is a special purpose named graph that provides system-level information 
    //   about a named graph to the user as RDF itself, ACLs, version info, etc.
    // description: The MetadataGraph is another extension of anzo.rdf.NamedGraph. The Anzo metadata graph is
    //   a special purpose named graph that provides system-level information about a named graph to the 
    //   user as RDF itself, ACLs, version info, etc. Pervasvie through the Anzo system, the metadata graph 
    //   is also a mechanism for editing such information, but only that information. The metadata is actually
    //   stored in special purpose database tables so it is not possible to store arbitrary RDF in the metadata graph. 
    //   So the MetadataGraph object itself in anzo.client just makes sure the user doesn't add any bad triples, 
    //   saving him from a beratement by the server in the form of nasty error messages. Again, the user will 
    //   never create one of these, the graph factory methods within AnzoClient will take care of it.
    
    // clientGraph : anzo.client.ClientGraph
    //   Reference to the client graph of which this is the metadata graph.
    clientGraph : null,
    
    constructor : function(namedGraphUri, store) {
        // summary:
        // 	create a new MetadataGraph instance.  This constructor should not be explicitly
        // 	called.  Instances of MetadataGraph are handed out by the AnzoClient
        // namedGraphUri: String | anzo.rdf.URI
        // 	The uri of the named graph
        // store: anzo.rdf.IQuadStore
        // 	Optional store used to store the statements of this graph.
        
        // Nothing to do here. The Dojo inheritance system will take care of calling the superclass's constructor.
    },
    
    _addStatements : function(statements) {
        // summary: Adds the statements from the given array that are about the graph or meta graph.  All other statements are disregarded .
        // statements : anzo.rdf.Statement[]
        //  Array of triples (statements with subject, predicate and object) that are added to this graph.
        
    	var metaURI  = this.namedGraphUri.toString();
    	var graphURI = anzo.utils.UriGenerator.getNamedGraphUri(this.namedGraphUri).toString();
        
        var filteredStmts = dojo.filter(statements, function metadataGraphReservedStatementFilter(item) { 
            var s = item.subject.toString();
        	return (s == graphURI || s == metaURI);
        }, this);
        this.inherited(arguments, [ filteredStmts ]); // Call superclass's method
    },
    
    isClosed : function() {
        return this.clientGraph.isClosed();
    }
    
});
