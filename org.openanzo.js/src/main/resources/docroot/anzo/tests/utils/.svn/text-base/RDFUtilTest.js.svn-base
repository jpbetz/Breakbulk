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
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * Tests for the anzo.utils.Set class.
 * 
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.tests.utils.RDFUtilTest");

dojo.require("anzo.utils.RDFUtil");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.rdf.NamedGraph");

tests.register("anzo.tests.utils.RDFUtilTest", 
	[
		
		
		function testMatchStatement() {
			var statement = new anzo.rdf.Statement(anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred1"), anzo.createLiteral("some data"), anzo.createURI("http://example.com/graph1"));

			// Test all combinations of a simple truthful match
			tests.assertTrue(anzo.utils.statementMatcher(statement, null, null, null));
			tests.assertTrue(anzo.utils.statementMatcher(statement, 
				anzo.createURI("http://example.com/subject1"), null, null
			));
			tests.assertTrue(anzo.utils.statementMatcher(statement, 
				null, anzo.createURI("http://example.com/pred1"), null
			));
			tests.assertTrue(anzo.utils.statementMatcher(statement, 
				null, null, anzo.createLiteral("some data")
			));
			tests.assertTrue(anzo.utils.statementMatcher(statement, 
				anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred1"), null
			));
			tests.assertTrue(anzo.utils.statementMatcher(statement, 
				null, anzo.createURI("http://example.com/pred1"), anzo.createLiteral("some data")
			));
			tests.assertTrue(anzo.utils.statementMatcher(statement, 
				anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred1"), anzo.createLiteral("some data")
			));

			// Test some false matches
			tests.assertFalse(anzo.utils.statementMatcher(statement, 
				anzo.createURI("http://example.com/subject2"), null, null
			));
			tests.assertFalse(anzo.utils.statementMatcher(statement, 
				null, anzo.createURI("http://example.com/pred2"), null
			));
			tests.assertFalse(anzo.utils.statementMatcher(statement, 
				null, null, anzo.createLiteral("non-matching data")
			));
			tests.assertFalse(anzo.utils.statementMatcher(statement, 
				anzo.createURI("http://example.com/subject2"), anzo.createURI("http://example.com/pred1"), anzo.createLiteral("some data")
			));
			tests.assertFalse(anzo.utils.statementMatcher(statement, 
				anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred2"), anzo.createLiteral("some data")
			));
			tests.assertFalse(anzo.utils.statementMatcher(statement, 
				anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred1"), anzo.createLiteral("non-matching data")
			));
			
		},
		
		function testFilterStatements() {
			var statements = [ 
				new anzo.rdf.Statement(anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred1"), anzo.createLiteral("some data"), anzo.createURI("http://example.com/graph1")),
				new anzo.rdf.Statement(anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred2"), anzo.createLiteral("more data"), anzo.createURI("http://example.com/graph1")),
				new anzo.rdf.Statement(anzo.createURI("http://example.com/subject2"),  anzo.createURI("http://example.com/pred3"), anzo.createLiteral("yet more data"), anzo.createURI("http://example.com/graph1"))
			];

			var subject1Array = anzo.utils.filterStatements(statements, anzo.createURI("http://example.com/subject1"), null, null);
			tests.assertEqual(subject1Array.length, 2);
			tests.assertTrue(anzo.utils.statementMatcher(subject1Array[0], 
				anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred1"), anzo.createLiteral("some data")
			));
			tests.assertTrue(anzo.utils.statementMatcher(subject1Array[1], 
				anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred2"), anzo.createLiteral("more data")
			));

			var pred2Array = anzo.utils.filterStatements(statements, null, anzo.createURI("http://example.com/pred2"), null);
			tests.assertEqual(pred2Array.length, 1);
			tests.assertTrue(anzo.utils.statementMatcher(pred2Array[0], 
				anzo.createURI("http://example.com/subject1"), anzo.createURI("http://example.com/pred2"), anzo.createLiteral("more data")
			));
			
			// null statements argument should be allowed and it should return an empty array
			var res = anzo.utils.filterStatements(null, null, null, null);
			tests.assertTrue(res);
			tests.assertTrue(res.length == 0);
		},
		
		function testFindAcrossGraphs() {
		    var g1 = new anzo.rdf.NamedGraph("http://example.org/g1");
		    var g2 = new anzo.rdf.NamedGraph("http://example.org/g2");
		    var g3 = new anzo.rdf.NamedGraph("http://example.org/g3");
		    
		    g1.add("http://example.org/subject1", "http://example.org/predicate1", anzo.createLiteral("object 1"));
		    g2.add("http://example.org/subject2", "http://example.org/predicate2", anzo.createLiteral("object 2"));
		    g3.add("http://example.org/subject3", "http://example.org/predicate3", anzo.createLiteral("object 3"));
            g2.add("http://example.org/subject1", "http://example.org/predicate1", anzo.createLiteral("object 1")); // add the same statement as added to g1 so that we test for duplicates.

            var graphs = [ g1, g2, g3, g3 ]; // graph 3 purposefully duplicated to test if duplicates are returned (they shouldn't be).
            var stmts = null;
            stmts = anzo.utils.findAcrossGraphs(graphs, "http://example.org/subject1", "http://example.org/predicate1", anzo.createLiteral("object 1"));
            tests.assertEqual(2, stmts.length);
            tests.assertTrue(anzo.utils.statementMatcher(stmts[0], anzo.createURI("http://example.org/subject1"), anzo.createURI("http://example.org/predicate1"), anzo.createLiteral("object 1")));
            tests.assertTrue(anzo.utils.statementMatcher(stmts[1], anzo.createURI("http://example.org/subject1"), anzo.createURI("http://example.org/predicate1"), anzo.createLiteral("object 1")));
            // Must return the statement from both g1 and g2 but it can be in any order.
            tests.assertTrue((stmts[0].namedGraphUri == "http://example.org/g1" && stmts[1].namedGraphUri == "http://example.org/g2")
                             || (stmts[0].namedGraphUri == "http://example.org/g2" && stmts[1].namedGraphUri == "http://example.org/g1"));

            stmts = anzo.utils.findAcrossGraphs(graphs, "http://example.org/subject2", "http://example.org/predicate2", anzo.createLiteral("object 2"));
            tests.assertEqual(1, stmts.length);
            tests.assertTrue(anzo.utils.statementMatcher(stmts[0], anzo.createURI("http://example.org/subject2"), anzo.createURI("http://example.org/predicate2"), anzo.createLiteral("object 2")));

            stmts = anzo.utils.findAcrossGraphs(graphs, "http://example.org/subject3", "http://example.org/predicate3", anzo.createLiteral("object 3"));
            tests.assertEqual(1, stmts.length);
            tests.assertTrue(anzo.utils.statementMatcher(stmts[0], anzo.createURI("http://example.org/subject3"), anzo.createURI("http://example.org/predicate3"), anzo.createLiteral("object 3")));
		}

]);

