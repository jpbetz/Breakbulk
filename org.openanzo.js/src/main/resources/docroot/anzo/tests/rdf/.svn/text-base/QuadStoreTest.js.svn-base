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

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)  
 */

dojo.provide("anzo.tests.rdf.QuadStoreTest");

dojo.require("anzo.rdf.QuadStore");

dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.rdf.NamedGraph");

tests.register("anzo.tests.rdf.QuadStoreTest", 
	[
		function test_MultipleBNodesAsSubjectsCanBeFound() {
		    // summary: Ensure that there bnodes are handled properly when there are multiple in the same positions.
            var store = new anzo.rdf.QuadStore();

            store.add(anzo.createBNode(), "http://example.org/predicate1", anzo.createLiteral("test"), "http://example.org/graph1");
            store.add(anzo.createBNode(), "http://example.org/predicate1", anzo.createLiteral("yet more test"), "http://example.org/graph1");

            // Find the BNodes
            var stmt = store.find(null, "http://example.org/predicate1", anzo.createLiteral("test"));
            tests.assertTrue(stmt.length == 1);
            var parsedBnode1 = stmt[0].subject;

            stmt = store.find(null, "http://example.org/predicate1", anzo.createLiteral("yet more test"));
            tests.assertTrue(stmt.length == 1);
            var parsedBnode2 = stmt[0].subject;
            
            tests.assertTrue(!parsedBnode1.equals(parsedBnode2));
        },
        		
		function test_test_QuadStoreRemovalOfSubjectAndObject() {
		    // This unit test tests the bug reported in ticket #196
		    
		    var store = new anzo.rdf.QuadStore();
       		
       		store.add('http://rouben', 'foaf:favoriteImages', 'http://icon1', 'http://graph1');
    		store.add('http://rouben', 'foaf:favoriteImages', 'http://icon2', 'http://graph1');
    		
    		store.add('http://sean', 'foaf:favoriteImages', 'http://icon3', 'http://graph1');
    		store.add('http://sean', 'foaf:favoriteImages', 'http://icon4', 'http://graph1');
		    
		    tests.assertTrue(store.find('http://rouben', 'foaf:favoriteImages').length == 2);
		    store.remove('http://sean', 'foaf:favoriteImages', 'http://icon3');
		    store.add('http://rouben', 'foaf:favoriteImages', 'http://icon3', 'http://graph1');
		    
		    tests.assertTrue(store.find('http://rouben', 'foaf:favoriteImages', null, 'http://graph1').length == 3);
		    
		    store.remove('http://sean', 'foaf:favoriteImages', 'http://icon4');
		    tests.assertTrue(store.find('http://rouben', 'foaf:favoriteImages').length == 3);
		    
		},
		
		function test_QuadStore() {
		   
		    var store = new anzo.rdf.QuadStore();
            anzo.tests.utilities.testQuadStore(store);
            
		},
		
		
		function testFind() {
		    
		    var store = new anzo.rdf.QuadStore();
			anzo.tests.utilities.testFind(store);
           
		},
		
		function testAddRemove() {
		    
		    var store = new anzo.rdf.QuadStore();
			anzo.tests.utilities.testAddRemove(store);
		    
		},
		
		function test() {
		    
		    var store = new anzo.rdf.QuadStore();
		    
		    store.add("http://rouben", "http://knows1", "http://lee1", 'http://graph1');
            store.add("http://rouben", "http://knows2", "http://lee2", 'http://graph1');
            store.remove("http://rouben", "http://knows2", "http://lee2", 'http://graph1');
            tests.assertTrue(store.find('http://rouben', 'http://knows1').length == 1);
            
            store.clear();
            
		    store.add("http://rouben", "http://knows", "http://lee", 'http://graph1');
            store.add("http://lee",    "http://knows", "http://jordi", 'http://graph1');
            store.remove("http://lee", "http://knows", "http://jordi", 'http://graph1');
            tests.assertTrue(store.find('http://rouben', 'http://knows').length == 1);
            
            store.clear();
            
            store.add("http://rouben", "http://knows1", "http://lee", 'http://graph1');
            store.add("http://lee",    "http://knows", "http://lee", 'http://graph1');
            store.remove("http://lee", "http://knows", "http://lee", 'http://graph1');
            tests.assertTrue(store.find('http://rouben', 'http://knows1').length == 1);
           
            store.clear();
            store.add("http://rouben", "http://rouben", "http://rouben", "http://rouben");
            tests.assertTrue(store.find('http://rouben').length == 1)
            tests.assertTrue(store.find(null, 'http://rouben').length == 1)
            tests.assertTrue(store.find(null, null, 'http://rouben').length == 1)
            tests.assertTrue(store.find(null, null, null, 'http://rouben').length == 1)
		},
		
		function testContains() {
			
			var store = new anzo.rdf.QuadStore();
			
		    var stmt1 = anzo.createStatement("http://rouben", "http://knows1", "http://lee1", 'http://graph1');
		    
		    store.add(stmt1);
            store.add("http://rouben", "http://knows2", "http://lee2", 'http://graph1');
            tests.assertTrue(store.contains("http://rouben", "http://knows2", "http://lee2", 'http://graph1'));
            tests.assertTrue(store.contains(stmt1));
			
		},
		
		function testGetStatements() {
			
			var store = new anzo.rdf.QuadStore();
			
		    var stmt1 = anzo.createStatement("http://rouben", "http://knows1", "http://lee1", 'http://graph1');
		    var stmt2 = anzo.createStatement("http://rouben", "http://knows2", "http://lee2", 'http://graph2');
		    
		    store.add(stmt1);
		    store.add(stmt2);
            tests.assertEqual(2,store.getStatements().length);
			
		}
		
		
	]
);
			