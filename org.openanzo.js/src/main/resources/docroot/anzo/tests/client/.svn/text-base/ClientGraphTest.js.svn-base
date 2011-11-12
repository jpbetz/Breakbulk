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

dojo.provide("anzo.tests.client.ClientGraphTest");

dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.tests.utilities");

(function() {

function buildRawClientGraph(uri) {
    // summary: private utility to create a ClientGraph for use in tests.
    var client = new anzo.client.AnzoClient({});
    var quadStore = client.transactionProxy;
    var metadataGraph = new anzo.rdf.NamedGraph(anzo.createURI("http://metadataGraph"),quadStore);
    var graph = new anzo.client.ClientGraph(anzo.createURI(uri),quadStore,metadataGraph,client);
    return graph;
}

tests.register("anzo.tests.client.ClientGraphTest", 
    [
        function test_ClientGraph() {
            // summary: Test that adding a statement to a ClientGraph works by showing up in 'contains'
            var TestData = new anzo.tests.client.TestData();
            
            var graph = buildRawClientGraph("http://namedGraph");
            
            graph.add(TestData.stmt1);
            graph.add(TestData.stmt2);		
                    
            tests.assertTrue(graph.contains(TestData.stmt1));
            tests.assertTrue(graph.contains(TestData.stmt2));
            
        },

        function test_ClientNamedGraph() {
            // summary: The ClientGraph should behave like a regular anzo.rdf.NamedGraph. So test it with typical
            //   graph operations.
            var graph = buildRawClientGraph("http://example.org/graphName");
            anzo.tests.utilities.test_NamedGraph(graph);
        },
        
        function test_LiteralsinClientGraph() {
            // summary: The ClientGraph should behave like a regular anzo.rdf.NamedGraph. So its behavior related to literals.
            var graph = buildRawClientGraph("http://example.org/graphName");
            anzo.tests.utilities.test_LiteralsInFindAddRemoveAndContains(graph);
        }
    ]
);

})();
