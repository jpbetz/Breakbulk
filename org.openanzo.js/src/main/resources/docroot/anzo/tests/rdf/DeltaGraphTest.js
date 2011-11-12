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
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)  
 */

dojo.provide("anzo.tests.rdf.DeltaGraphTest");

dojo.require("anzo.tests.utilities");

dojo.require("anzo.rdf.DeltaGraph");
dojo.require("anzo.rdf.NamedGraph");
dojo.require('anzo.rdf.Statement');
dojo.require("anzo.rdf.vocabulary.XMLSchema");

tests.register("anzo.tests.rdf.DeltaGraphTest", 
	[
		function test_DeltaGraphApplyAndAbort() {
		    var graph = new anzo.rdf.NamedGraph('http://name');
		    
            var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/rdf/parser/ontology.nt");		    
		    anzo.rdf.parser.NTripleParser.parse(str, graph);
				
            var delta = new anzo.rdf.DeltaGraph(graph);
            var dirty = false;
            dojo.connect(delta, 'onDirtyChange', function(d) {
                dirty = d;
            });
            
            var resource = "urn:lsid:telar.cambridgesemantics.com:cvit#Entry";
            tests.assertTrue(delta.find(resource).length == 2);
            
            delta.remove(resource);
            tests.assertTrue(dirty);
            tests.assertTrue(delta.isDirty());
            tests.assertTrue(graph.find(resource).length == 2);
            tests.assertTrue(delta.find(resource).length == 0);
            delta.abort();
            tests.assertFalse(dirty);
            tests.assertFalse(delta.isDirty());
            tests.assertTrue(delta.find(resource).length == 2);
            
            delta.remove(resource);
            tests.assertTrue(dirty);
            tests.assertTrue(delta.isDirty());
            tests.assertTrue(graph.find(resource).length == 2);
            tests.assertTrue(delta.find(resource).length == 0);
            delta.apply();
            tests.assertFalse(dirty);
            tests.assertFalse(delta.isDirty());
            tests.assertTrue(graph.find(resource).length == 0);
            
            delta.add("http://subj1", 'http://pred1', 'http://obj1');
            tests.assertTrue(dirty);
            tests.assertTrue(delta.isDirty());
            tests.assertTrue(graph.find("http://subj1").length == 0);
            tests.assertTrue(delta.find("http://subj1").length == 1);
            delta.abort();
            tests.assertFalse(dirty);
            tests.assertFalse(delta.isDirty());
            tests.assertTrue(delta.find("http://subj1").length == 0);
            
            delta.add("http://subj1", 'http://pred1', 'http://obj1');
            tests.assertTrue(graph.find("http://subj1").length == 0);
            tests.assertTrue(delta.find("http://subj1").length == 1);
            delta.apply();
            tests.assertFalse(dirty);
            tests.assertFalse(delta.isDirty());
            tests.assertTrue(delta.find("http://subj1").length == 1);
            
            var deltaSize = delta.size();
            var graphSize = graph.size();
            delta.add("http://subj2", 'http://pred2', 'http://obj2');
            delta.remove("http://subj2", 'http://pred2', 'http://obj2');
            tests.assertTrue(delta.size() == deltaSize);
            delta.apply();
            tests.assertTrue(graph.size() == graphSize);
            
            delta.add("http://subj2", 'http://pred2', 'http://obj2');
            tests.assertTrue(delta.contains("http://subj2", 'http://pred2', 'http://obj2'));
            delta.remove("http://subj2", 'http://pred2', 'http://obj2');
            delta.add("http://subj2", 'http://pred2', 'http://obj2');
            delta.add("http://subj2", 'http://pred2', 'http://obj2');
            tests.assertTrue(delta.size() == deltaSize+1);
            delta.apply();
            tests.assertTrue(graph.size() == graphSize+1);
            
            delta.clear();
            tests.assertTrue(graph.size() == graphSize+1);
            tests.assertTrue(delta.size() == 0);
            delta.abort();
            tests.assertTrue(delta.size() == deltaSize+1);
            
            delta.clear();
            tests.assertTrue(graph.size() == graphSize+1);
            tests.assertTrue(delta.size() == 0);
            delta.apply();
            tests.assertTrue(delta.size() == 0);
            
		},
		
		function test_DeltaGraphWithNoGraph() {
		    
		    var delta = new anzo.rdf.DeltaGraph();
		    
		    anzo.tests.utilities.test_NamedGraph(delta);
		    delta.clear();
		    
		    anzo.tests.utilities.test_NamedGraphEvents(delta);
		    delta.clear();
		    
		    tests.assertTrue(delta.isEmpty());
		    
		    delta.add("http://subj2", "http://pred2", "http://obj2");
		    
		    var exceptionThrown = false;
		    try {
		        graph.apply();
		    } catch(e) {
		        exceptionThrown = true;
		    }
		    tests.assertTrue(exceptionThrown);
		    
		    var graph = new anzo.rdf.NamedGraph('http://foo');
		    delta.setGraph(graph);
		    delta.apply();
		    
		    tests.assertTrue(graph.size() == 1);
		    tests.assertTrue(delta.size() == 1);
		    
		    delta.clear();
		    tests.assertTrue(delta.isEmpty());
		    tests.assertFalse(graph.isEmpty());
		    delta.apply();
		    tests.assertTrue(graph.isEmpty());
		    
		    anzo.tests.utilities.test_NamedGraph(delta);
		    delta.clear();
		    
		    anzo.tests.utilities.test_NamedGraphEvents(delta);
		    delta.clear();
		    
		    delta.close();
		    graph.close();
		    
		    // same test with specifying the uri of the delta graph
		    
		    var delta = new anzo.rdf.DeltaGraph('http://foo');
		    
		    anzo.tests.utilities.test_NamedGraph(delta);
		    delta.clear();
		    
		    anzo.tests.utilities.test_NamedGraphEvents(delta);
		    delta.clear();
		    
		    tests.assertTrue(delta.isEmpty());
		    
		    delta.add("http://subj2", "http://pred2", "http://obj2");
		    
		    var exceptionThrown = false;
		    try {
		        graph.apply();
		    } catch(e) {
		        exceptionThrown = true;
		    }
		    tests.assertTrue(exceptionThrown);
		    
		    var graph = new anzo.rdf.NamedGraph('http://foo');
		    delta.setGraph(graph);
		    delta.apply();
		    
		    tests.assertTrue(graph.size() == 1);
		    tests.assertTrue(delta.size() == 1);
		    
		    delta.clear();
		    tests.assertTrue(delta.isEmpty());
		    tests.assertFalse(graph.isEmpty());
		    delta.apply();
		    tests.assertTrue(graph.isEmpty());
		    
		    anzo.tests.utilities.test_NamedGraph(delta);
		    delta.clear();
		    
		    anzo.tests.utilities.test_NamedGraphEvents(delta);
		    delta.clear();
		    
		    delta.close();
		    graph.close();
		},
		
		function test_DeltaGraphDirty() {
            
            var graph = new anzo.rdf.NamedGraph('http://name');
            var delta = new anzo.rdf.DeltaGraph(graph);
            
            delta.add('http://subj1', 'http://pred1', 1);
            tests.assertTrue(delta.isDirty());
            delta.remove('http://subj1', 'http://pred1', 1);
            tests.assertFalse(delta.isDirty());
            
		},
		
		
		function test_DeltaGraph() {
            
            var graph = new anzo.rdf.NamedGraph('http://name');
            var delta = new anzo.rdf.DeltaGraph(graph);
            
            anzo.tests.utilities.test_NamedGraph(delta);

		},
		
		function test_DeltaGraphEvents() {
		    
		    var graph =  new anzo.rdf.NamedGraph('http://name');
		    var delta = new anzo.rdf.DeltaGraph(graph);
            
		    anzo.tests.utilities.test_NamedGraphEvents(delta);
        	
		},
		
		function test_bNode() {
            var graph =  new anzo.rdf.NamedGraph('http://name');
		    var delta = new anzo.rdf.DeltaGraph(graph);
            
            delta.add("http://sub1", "http://pred1", anzo.createBNode("123"));
            tests.assertTrue(delta.contains("http://sub1", "http://pred1", anzo.createBNode("123")));
            tests.assertFalse(graph.contains("http://sub1", "http://pred1", anzo.createBNode("123")));
            delta.apply();
            tests.assertTrue(graph.contains("http://sub1", "http://pred1", anzo.createBNode("123")));
            
       }
       
	]
);
