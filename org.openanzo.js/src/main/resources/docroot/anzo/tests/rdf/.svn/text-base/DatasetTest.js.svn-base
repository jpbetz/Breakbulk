/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.tests.rdf.DatasetTest");

dojo.require("anzo.rdf.Dataset");
dojo.require("anzo.rdf.NamedGraph");

dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.log");

(function(){
var log = anzo.log.getLogger("anzo.tests.rdf.DatasetTest");

tests.register("anzo.tests.rdf.DatasetTest", 
	[

		function test_addAndRemoveGraphs() {
		    
		    var TestData = new anzo.tests.client.TestData();
		    
		    var d = new anzo.rdf.Dataset(TestData.dataset1);
		    
		    var g1, g2, g3, g4, g5, g6, g7;
		    
		    // =======================================================================================
		    // TEST: ADD BY URI TO NAMED GRAPH

		    d.addNamedGraph(TestData.graph1, function(g) { g1 = g; });
		    tests.assertTrue(g1 != null);
		    tests.assertTrue(d.containsNamedGraph(TestData.graph1));
            tests.assertTrue(d.containsNamedGraph(g1));
            tests.assertTrue(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.namedGraphProperty, g1.namedGraphUri));
            tests.assertTrue(new anzo.utils.Set(d.getNamedGraphUris()).contains(g1.namedGraphUri));
            tests.assertTrue(d.getNamedGraph(TestData.graph1) == g1);
            tests.assertTrue(d.getNamedGraph(g1) == g1);
            
            // =======================================================================================
		    // TEST: ADD BY URI TO DEFAULT GRAPH
		    
            d.addDefaultGraph(TestData.graph1, function(g) { g1 = g; });
		    tests.assertTrue(g1 != null);
		    tests.assertTrue(d.containsDefaultGraph(TestData.graph1));
            tests.assertTrue(d.containsDefaultGraph(g1));
            tests.assertTrue(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.defaultProperty, g1.namedGraphUri));
            tests.assertTrue(new anzo.utils.Set(d.getDefaultGraphUris()).contains(g1.namedGraphUri));
            tests.assertTrue(d.getDefaultGraph(TestData.graph1) == g1);
            tests.assertTrue(d.getDefaultGraph(g1) == g1);
            
            // =======================================================================================
		    // TEST: ADD BY GRAPH TO NAMED GRAPH
		    
            var g2 = new anzo.rdf.NamedGraph(TestData.graph2);
		    d.addNamedGraph(g2, function(g) { g2 = g; });
		    tests.assertTrue(g2 != null);
		    tests.assertTrue(d.containsNamedGraph(TestData.graph2));
            tests.assertTrue(d.containsNamedGraph(g2));
            tests.assertTrue(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.namedGraphProperty, g2.namedGraphUri));
            tests.assertTrue(new anzo.utils.Set(d.getNamedGraphUris()).contains(g2.namedGraphUri));
            tests.assertTrue(d.getNamedGraph(TestData.graph2) == g2);
            
            // =======================================================================================
		    // TEST: ADD BY GRAPH TO DEFAULT GRAPH
		    
		    var g2 = new anzo.rdf.NamedGraph(TestData.graph2);
            d.addDefaultGraph(g2, function(g) { g2 = g; });
		    tests.assertTrue(g2 != null);
		    tests.assertTrue(d.containsDefaultGraph(TestData.graph2));
            tests.assertTrue(d.containsDefaultGraph(g2));
            tests.assertTrue(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.defaultGraphProperty, g2.namedGraphUri));
            tests.assertTrue(new anzo.utils.Set(d.getDefaultGraphUris()).contains(g2.namedGraphUri));
            tests.assertTrue(d.getDefaultGraph(TestData.graph2) == g2);
            
            // =======================================================================================
            // TEST: ADD DIRECTLY TO NAMED DATASET GRAPH
            
            d.datasetGraph.add(d.uri, anzo.client.Vocabulary.namedGraphProperty, TestData.graph3);
            g3 = d.getNamedGraph(TestData.graph3);
            tests.assertTrue(d.getNamedGraph(TestData.graph3) != null);
            tests.assertTrue(d.containsNamedGraph(TestData.graph3));
            tests.assertTrue(d.containsNamedGraph(g3));
            tests.assertTrue(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.namedGraphProperty, g3.namedGraphUri));
            tests.assertTrue(new anzo.utils.Set(d.getNamedGraphUris()).contains(g3.namedGraphUri));
            tests.assertTrue(d.getNamedGraph(TestData.graph3) == g3);
            
            // =======================================================================================
		    // TEST: REMOVE BY URI FROM NAMED GRAPH

		    d.removeNamedGraph(TestData.graph1);
		    tests.assertFalse(d.containsNamedGraph(TestData.graph1));
            tests.assertFalse(d.containsNamedGraph(g1));
            tests.assertFalse(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.namedGraphProperty, g1.namedGraphUri));
            tests.assertFalse(new anzo.utils.Set(d.getNamedGraphUris()).contains(g1.namedGraphUri));
            
            // =======================================================================================
		    // TEST: REMOVE BY URI FROM DEFAULT GRAPH

		    d.removeDefaultGraph(TestData.graph1);
		    tests.assertFalse(d.containsDefaultGraph(TestData.graph1));
            tests.assertFalse(d.containsDefaultGraph(g1));
            tests.assertFalse(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.defaultGraphProperty, g1.namedGraphUri));
            tests.assertFalse(new anzo.utils.Set(d.getDefaultGraphUris()).contains(g1.namedGraphUri));
            
            // =======================================================================================
		    // TEST: REMOVE BY GRAPH FROM NAMED GRAPH
		    
            var g2 = new anzo.rdf.NamedGraph(TestData.graph2);
		    d.removeNamedGraph(g2);
		    tests.assertFalse(d.containsNamedGraph(TestData.graph2));
            tests.assertFalse(d.containsNamedGraph(g2));
            tests.assertFalse(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.namedGraphProperty, g2.namedGraphUri));
            tests.assertFalse(new anzo.utils.Set(d.getNamedGraphUris()).contains(g2.namedGraphUri));

            
            // =======================================================================================
		    // TEST: REMOVE BY GRAPH FROM DEFAULT GRAPH
		    
            var g2 = new anzo.rdf.NamedGraph(TestData.graph2);
		    d.removeDefaultGraph(g2);
		    tests.assertFalse(d.containsDefaultGraph(TestData.graph2));
            tests.assertFalse(d.containsDefaultGraph(g2));
            tests.assertFalse(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.defaultGraphProperty, g2.namedGraphUri));
            tests.assertFalse(new anzo.utils.Set(d.getDefaultGraphUris()).contains(g2.namedGraphUri));
            
            // =======================================================================================
            // TEST: REMOVE DIRECTLY FROM NAMED DATASET GRAPH
            
            d.datasetGraph.remove(d.uri, anzo.client.Vocabulary.namedGraphProperty, TestData.graph3);
            tests.assertFalse(d.getNamedGraph(TestData.graph3) != null);
            tests.assertFalse(d.containsNamedGraph(TestData.graph3));
            tests.assertFalse(d.containsNamedGraph(g3));
            tests.assertFalse(d.datasetGraph.contains(d.uri, anzo.client.Vocabulary.namedGraphProperty, g3.namedGraphUri));
            tests.assertFalse(new anzo.utils.Set(d.getNamedGraphUris()).contains(g3.namedGraphUri));
            
            // make sure the in-memory graphs have been removed from the cache
            tests.assertFalse(d.getNamedGraph(TestData.graph1) == g1);
            tests.assertFalse(d.getNamedGraph(TestData.graph2) == g2);
            tests.assertFalse(d.getNamedGraph(TestData.graph3) == g3);
            
            
            
            d.close();
            
		},
		
		function test_QuadStoreMethods() {
		    
		    var TestData = new anzo.tests.client.TestData();
		    
		    var ds = new anzo.rdf.Dataset(TestData.dataset1);
		    
		    var g1, g2, g3, g4, g5, g6, g7;
		    
            ds.addNamedGraph(TestData.graph1,   function(g) { g1 = g; });
		    ds.addNamedGraph(TestData.graph2,   function(g) { g2 = g; });
		    ds.addNamedGraph(TestData.graph3,   function(g) { g3 = g; });
		    ds.addNamedGraph(TestData.graph4,   function(g) { g4 = g; });
		    
		    ds.addDefaultGraph(TestData.graph3, function(g) { g3 = g; });
		    ds.addDefaultGraph(TestData.graph4, function(g) { g4 = g; });
		    ds.addDefaultGraph(TestData.graph5, function(g) { g5 = g; });
		    ds.addDefaultGraph(TestData.graph6, function(g) { g6 = g; });
		    
		    g1.add(TestData.subj1, TestData.pred1, TestData.obj1)
		    g2.add(TestData.subj2, TestData.pred2, TestData.obj2)
		    g3.add(TestData.subj3, TestData.pred3, TestData.obj3)
		    g4.add(TestData.subj4, TestData.pred4, TestData.obj4)
		    g5.add(TestData.subj5, TestData.pred5, TestData.obj5)
		    g6.add(TestData.subj6, TestData.pred6, TestData.obj6)
		    
		    tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1)[0].namedGraphUri.equals(g1.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2)[0].namedGraphUri.equals(g2.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3)[0].namedGraphUri.equals(g3.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4)[0].namedGraphUri.equals(g4.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj5, TestData.pred5, TestData.obj5)[0].namedGraphUri.equals(g5.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj6, TestData.pred6, TestData.obj6)[0].namedGraphUri.equals(g6.namedGraphUri));
		    tests.assertFalse(ds.find('http://random', TestData.pred6, TestData.obj6).length == 1);
		    
		    tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1, g1.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
		    tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2, g2.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
		    tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3, g3.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3).length == 1);
		    tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4, g4.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4).length == 1);
		    tests.assertTrue(ds.find(TestData.subj5, TestData.pred5, TestData.obj5, g5.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj5, TestData.pred5, TestData.obj5).length == 1);
		    tests.assertTrue(ds.find(TestData.subj6, TestData.pred6, TestData.obj6, g6.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj6, TestData.pred6, TestData.obj6).length == 1);
		    
		    tests.assertTrue(ds.contains(TestData.subj1, TestData.pred1, TestData.obj1));
		    tests.assertTrue(ds.contains(TestData.subj2, TestData.pred2, TestData.obj2));
		    tests.assertTrue(ds.contains(TestData.subj3, TestData.pred3, TestData.obj3));
		    tests.assertTrue(ds.contains(TestData.subj4, TestData.pred4, TestData.obj4));
		    tests.assertTrue(ds.contains(TestData.subj5, TestData.pred5, TestData.obj5));
		    tests.assertTrue(ds.contains(TestData.subj6, TestData.pred6, TestData.obj6));
		    tests.assertFalse(ds.contains(TestData.subj6, 'http://random', TestData.obj6));
		    
		    tests.assertTrue(ds.size() == 6);
		    tests.assertTrue(ds.size([g3.namedGraphUri, g4.namedGraphUri, 'http://random']) == 2);
		    tests.assertTrue(!ds.isEmpty([TestData.graph1]));
		    
		    tests.assertTrue(!ds.isEmpty());
		    tests.assertTrue(ds.isEmpty(['http://random']));
		    
		    ds.close();
		},

		function test_SetNamedGraphs() {
		    
		    var TestData = new anzo.tests.client.TestData();
		    
		    var ds = new anzo.rdf.Dataset(TestData.dataset1);
		    
		    var g1, g2, g3, g4, g5, g6, g7;
		    
		    ds.setNamedGraphs([TestData.graph1, TestData.graph2, TestData.graph3, TestData.graph4]);
		    ds.setDefaultGraphs([TestData.graph3, TestData.graph4, TestData.graph5, TestData.graph6])
		    
		    g1 = ds.getNamedGraph(TestData.graph1)
		    g2 = ds.getNamedGraph(TestData.graph2)
		    g3 = ds.getNamedGraph(TestData.graph3)
		    g4 = ds.getDefaultGraph(TestData.graph4)
		    g5 = ds.getDefaultGraph(TestData.graph5)
		    g6 = ds.getDefaultGraph(TestData.graph6)
		    
		    tests.assertTrue(g1 != null);
		    tests.assertTrue(g2 != null);
		    tests.assertTrue(g3 != null);
		    tests.assertTrue(g4 != null);
		    tests.assertTrue(g5 != null);
		    tests.assertTrue(g6 != null);
		    
		    tests.assertTrue(ds.getDefaultGraph(TestData.graph1) == null)
            tests.assertTrue(ds.getNamedGraph(TestData.graph6) == null)
            
		    g1.add(TestData.subj1, TestData.pred1, TestData.obj1)
		    g2.add(TestData.subj2, TestData.pred2, TestData.obj2)
		    g3.add(TestData.subj3, TestData.pred3, TestData.obj3)
		    g4.add(TestData.subj4, TestData.pred4, TestData.obj4)
		    g5.add(TestData.subj5, TestData.pred5, TestData.obj5)
		    g6.add(TestData.subj6, TestData.pred6, TestData.obj6)
		    
		    tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1)[0].namedGraphUri.equals(g1.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2)[0].namedGraphUri.equals(g2.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3)[0].namedGraphUri.equals(g3.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4)[0].namedGraphUri.equals(g4.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj5, TestData.pred5, TestData.obj5)[0].namedGraphUri.equals(g5.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj6, TestData.pred6, TestData.obj6)[0].namedGraphUri.equals(g6.namedGraphUri));
		    tests.assertFalse(ds.find('http://random', TestData.pred6, TestData.obj6).length == 1);
		    
		    tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1, g1.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2, g2.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3, g3.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4, g4.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj5, TestData.pred5, TestData.obj5, g5.namedGraphUri).length == 1);
		    tests.assertTrue(ds.find(TestData.subj6, TestData.pred6, TestData.obj6, g6.namedGraphUri).length == 1);
		    
		    tests.assertTrue(ds.contains(TestData.subj1, TestData.pred1, TestData.obj1));
		    tests.assertTrue(ds.contains(TestData.subj2, TestData.pred2, TestData.obj2));
		    tests.assertTrue(ds.contains(TestData.subj3, TestData.pred3, TestData.obj3));
		    tests.assertTrue(ds.contains(TestData.subj4, TestData.pred4, TestData.obj4));
		    tests.assertTrue(ds.contains(TestData.subj5, TestData.pred5, TestData.obj5));
		    tests.assertTrue(ds.contains(TestData.subj6, TestData.pred6, TestData.obj6));
		    tests.assertFalse(ds.contains(TestData.subj6, 'http://random', TestData.obj6));
		    
		    tests.assertTrue(ds.size() == 6);
		    tests.assertTrue(ds.size([g3.namedGraphUri, g4.namedGraphUri, 'http://random']) == 2);
		    tests.assertTrue(!ds.isEmpty([TestData.graph1]));
		    
		    tests.assertTrue(!ds.isEmpty());
		    tests.assertTrue(ds.isEmpty(['http://random']));
		    
		    ds.clear();
		    
		    tests.assertTrue(ds.getNamedGraphUris().length == 0)
		    tests.assertTrue(ds.getDefaultGraphUris().length == 0)
		    tests.assertTrue(g1.isEmpty())
		    tests.assertTrue(g2.isEmpty())
		    tests.assertTrue(g3.isEmpty())
		    tests.assertTrue(g4.isEmpty())
		    tests.assertTrue(g5.isEmpty())
		    tests.assertTrue(g6.isEmpty())
		    
		    ds.close();
		},
		
		function test_AddRemoveStmts() {
		    
		    var TestData = new anzo.tests.client.TestData();
		    
		    var ds = new anzo.rdf.Dataset(TestData.dataset1);
		    
		    var g1, g2, g3, g4, g5, g6, g7;
		    
		    ds.setNamedGraphs([TestData.graph1, TestData.graph2, TestData.graph3, TestData.graph4]);
		    ds.setDefaultGraphs([TestData.graph3, TestData.graph4, TestData.graph5, TestData.graph6])
		    
		    g1 = ds.getNamedGraph(TestData.graph1)
		    g2 = ds.getNamedGraph(TestData.graph2)
		    g3 = ds.getNamedGraph(TestData.graph3)
		    g4 = ds.getDefaultGraph(TestData.graph4)
		    g5 = ds.getDefaultGraph(TestData.graph5)
		    g6 = ds.getDefaultGraph(TestData.graph6)
		    
		    ds.add(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1)
		    ds.add(TestData.subj2, TestData.pred2, TestData.obj2, TestData.graph2)
		    ds.add(TestData.subj3, TestData.pred3, TestData.obj3, TestData.graph3)
		    ds.add(TestData.subj4, TestData.pred4, TestData.obj4, TestData.graph4)
		    ds.add(TestData.subj5, TestData.pred5, TestData.obj5, TestData.graph5)
		    ds.add(TestData.subj6, TestData.pred6, TestData.obj6, TestData.graph6)

		    tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1)[0].namedGraphUri.equals(g1.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2)[0].namedGraphUri.equals(g2.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3)[0].namedGraphUri.equals(g3.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4)[0].namedGraphUri.equals(g4.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj5, TestData.pred5, TestData.obj5)[0].namedGraphUri.equals(g5.namedGraphUri));
		    tests.assertTrue(ds.find(TestData.subj6, TestData.pred6, TestData.obj6)[0].namedGraphUri.equals(g6.namedGraphUri));
		    tests.assertFalse(ds.find('http://random', TestData.pred6, TestData.obj6).length == 1);
		    
		    ds.remove(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1)
		    ds.remove(TestData.subj2, TestData.pred2, TestData.obj2)
		    ds.remove(TestData.subj3, TestData.pred3)
		    ds.remove(TestData.subj4)
		    
		    tests.assertFalse(ds.contains(TestData.subj1, TestData.pred1, TestData.obj1));
		    tests.assertFalse(ds.contains(TestData.subj2, TestData.pred2, TestData.obj2));
		    tests.assertFalse(ds.contains(TestData.subj3, TestData.pred3, TestData.obj3));
		    tests.assertFalse(ds.contains(TestData.subj4, TestData.pred4, TestData.obj4));
		    
		    tests.assertTrue(ds.contains(TestData.subj5, TestData.pred5, TestData.obj5));
		    tests.assertTrue(ds.contains(TestData.subj6, TestData.pred6, TestData.obj6));
		    
		    ds.clear();
		    
		    tests.assertFalse(ds.contains(TestData.subj5, TestData.pred5, TestData.obj5));
		    tests.assertFalse(ds.contains(TestData.subj6, TestData.pred6, TestData.obj6));
		    
		    ds.close();
		}
		
	]
);

})();
