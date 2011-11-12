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

dojo.provide("anzo.tests.rdf.NamedGraphTest");

dojo.require("anzo.tests.utilities");
dojo.require("anzo.rdf.NamedGraph");
dojo.require('anzo.rdf.Statement');
dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.log");

(function(){
var log = anzo.log.getLogger("anzo.tests.rdf.NamedGraphTest");
    
tests.register("anzo.tests.rdf.NamedGraphTest", 
    [
        
        function test_NamedGraphRemovalOfSubjectAndObject() {
            // summary: This unit test tests the bug reported in ticket #196
            var graph = new anzo.rdf.NamedGraph();
            
            graph.add('http://rouben', 'foaf:favoriteImages', 'http://icon1');
            graph.add('http://rouben', 'foaf:favoriteImages', 'http://icon2');
            
            graph.add('http://sean', 'foaf:favoriteImages', 'http://icon3');
            graph.add('http://sean', 'foaf:favoriteImages', 'http://icon4');
            
            tests.assertTrue(graph.find('http://rouben', 'foaf:favoriteImages').length == 2);
            graph.remove('http://sean', 'foaf:favoriteImages', 'http://icon3');
            graph.add('http://rouben', 'foaf:favoriteImages', 'http://icon3');
            
            tests.assertTrue(graph.find('http://rouben', 'foaf:favoriteImages').length == 3);
            
            graph.remove('http://sean', 'foaf:favoriteImages', 'http://icon4');
            tests.assertTrue(graph.find('http://rouben', 'foaf:favoriteImages').length == 3);
            
        },
        
        function test_NamedGraph() {
            
            var graph = new anzo.rdf.NamedGraph('http://name');
            
            anzo.tests.utilities.test_NamedGraph(graph);

        },
        
        function test_NamedGraphEvents() {
            
            var graph = new anzo.rdf.NamedGraph('http://name');
            
            anzo.tests.utilities.test_NamedGraphEvents(graph);
            
        },
        
        function test_bNode() {
         var graph1 =  new anzo.rdf.NamedGraph('http://ng1');
         
         graph1.add("http://sub1", "http://pred1", anzo.createBNode("123"));
         tests.assertTrue(graph1.contains("http://sub1", "http://pred1", anzo.createBNode("123")));
       },
       
       function testContains() {
            
            var graph = new anzo.rdf.NamedGraph('http://ng1');
            var stmt1 = anzo.createStatement("http://rouben", "http://knows1", "http://lee1");
            graph.add(stmt1);
            graph.add("http://rouben", "http://knows2", "http://lee2");
            tests.assertTrue(graph.contains("http://rouben", "http://knows2", "http://lee2"));
            tests.assertTrue(graph.contains("http://rouben", "http://knows1", "http://lee1"));
            tests.assertTrue(graph.contains(stmt1));
            
        },
        
        function testGetStatements() {
            
            var graph = new anzo.rdf.NamedGraph('http://example.org/ng1');
            var statements = [
            anzo.createStatement("http://example.org/subj1", "http://example.org/pred1", "http://example.org/obj1", "http://example.org/ng2"),
            anzo.createStatement("http://example.org/subj2", "http://example.org/pred2", "http://example.org/obj2", "http://example.org/ng3"),
            anzo.createStatement("http://example.org/subj3", "http://example.org/pred3", "http://example.org/obj3", "http://example.org/ng4")
            ]
            graph.add(statements);
            var foundStatements = null;
            var statement = null;
            foundStatements = graph.getStatements();
            tests.assertEqual(3, foundStatements.length);
            
        },
        
        function testAddMultipleStatementsAtOnce() {
            
            var graph = new anzo.rdf.NamedGraph('http://example.org/ng1');
            var statements = [
            anzo.createStatement("http://example.org/subj1", "http://example.org/pred1", "http://example.org/obj1"),
            anzo.createStatement("http://example.org/subj2", "http://example.org/pred2", "http://example.org/obj2"),
            anzo.createStatement("http://example.org/subj3", "http://example.org/pred3", "http://example.org/obj3")
            ]
            graph.add(statements);
            tests.assertTrue(graph.contains(statements[0]));
            tests.assertTrue(graph.contains(statements[1]));
            tests.assertTrue(graph.contains(statements[2]));
        },

        function testRemoveMultipleStatementsAtOnce() {
            
            var graph = new anzo.rdf.NamedGraph('http://example.org/ng1');
            var statements = [
            anzo.createStatement("http://example.org/subj1", "http://example.org/pred1", "http://example.org/obj1"),
            anzo.createStatement("http://example.org/subj2", "http://example.org/pred2", "http://example.org/obj2"),
            anzo.createStatement("http://example.org/subj3", "http://example.org/pred3", "http://example.org/obj3")
            ]
            graph.add(statements);
            graph.remove(statements);
            tests.assertFalse(graph.contains(statements[0]));
            tests.assertFalse(graph.contains(statements[1]));
            tests.assertFalse(graph.contains(statements[2]));
        },

        function testAddingMultipleStatementsWithDifferentNamedGraphUris() {
            // summary: When you add a statement to a graph and the statement's graph URI doesn't match that of
            //   the graph, it should still be added. The statement's graph URI is essentially ignored when adding. 
            var graph = new anzo.rdf.NamedGraph('http://example.org/ng1');
            var statements = [
            anzo.createStatement("http://example.org/subj1", "http://example.org/pred1", "http://example.org/obj1", "http://example.org/ng2"),
            anzo.createStatement("http://example.org/subj2", "http://example.org/pred2", "http://example.org/obj2", "http://example.org/ng3"),
            anzo.createStatement("http://example.org/subj3", "http://example.org/pred3", "http://example.org/obj3", "http://example.org/ng4")
            ]
            graph.add(statements);
            var foundStatements = null;
            var statement = null;
            foundStatements = graph.find("http://example.org/subj1", "http://example.org/pred1", "http://example.org/obj1");

            statement = foundStatements[0];
            tests.assertTrue(foundStatements.length == 1);
            tests.assertTrue(statement.namedGraphUri.toString() == "http://example.org/ng1");

            foundStatements = graph.find("http://example.org/subj2", "http://example.org/pred2", "http://example.org/obj2");
            statement = foundStatements[0];
            tests.assertTrue(foundStatements.length == 1);
            tests.assertTrue(statement.namedGraphUri.toString() == "http://example.org/ng1");

            foundStatements = graph.find("http://example.org/subj3", "http://example.org/pred3", "http://example.org/obj3");
            statement = foundStatements[0];
            tests.assertTrue(foundStatements.length == 1);
            tests.assertTrue(statement.namedGraphUri.toString() == "http://example.org/ng1");
        },
        
        function testLiteralsInAddRemoveContainsFind() {

            var graph = new anzo.rdf.NamedGraph('http://example.org/ng1');
            anzo.tests.utilities.test_LiteralsInFindAddRemoveAndContains(graph);
        },

        function testAddingAndRetrievingDates() {
            // summary: See http://www.openanzo.org/projects/openanzo/ticket/376
            var graph = new anzo.rdf.NamedGraph('http://example.org/ng1');
            var subj1 = "http://example.org/subj1";
            var pred1 = "http://example.org/pred1";
            // 1213136959718 millseconds since the epoch, is Tue Jun 10 2008 18:29:19 GMT-0400 (Eastern Daylight Time), on my machine.
            var date = new Date(1213136959718);
            var dateSame = new Date(1213136959718); // To try and make sure more than reference equality is at play
            var dateDifferent = new Date(1213136959719);

            // Sanity check to make sure the date objects behave as we expect
            tests.assertTrue(dateSame.getTime() != dateDifferent.getTime());
            tests.assertTrue(dateSame != dateDifferent);

            graph.add(subj1, pred1, date);
            log.debug("added date statement");
            tests.assertTrue(graph.contains(subj1, pred1, dateSame));
            log.debug("contains same passed " + graph.contains(subj1, pred1, dateDifferent));
            tests.assertFalse(graph.contains(subj1, pred1, dateDifferent));
            log.debug("contains different passed");
            var stmts = graph.find(subj1, pred1, dateSame);
            tests.assertEqual(1, stmts.length);
            log.debug("found 1 statement");
            tests.assertEqual(date.getTime(), stmts[0].object.getNativeValue().getTime());
            log.debug("matched times at statement");
            tests.assertEqual(0, graph.find(subj1, pred1, dateDifferent).length);
        }
    ]
);

})();
