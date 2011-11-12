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
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide('anzo.tests.rdf.serializer.NTripleSerializerTest');

dojo.require('anzo.rdf.serializer.NTripleSerializer');

dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.rdf.parser.NTripleParser");
dojo.require("anzo.tests.utilities");

tests.register("anzo.tests.rdf.serializer.NTripleSerializerTest", 
    [
        function test_CustomBNodesIdAreSerializedWithCorrectCharacters() {
            // summary: N-Triples demands that bnode labels be of format [A-Za-z][A-Za-z0-9]* but the
            //  anzo API allows callers to supply their on id for bnodes. The N-Triples serailizer
            //  must therefore perform an appropriate transformation.
            
            // We'll test this by submitting a bnode with an that doesn't match the N-Triples format
            // and we'll make sure the output string for the bnode does match the format.
            var graph = new anzo.rdf.NamedGraph('http://example.org/graph');
            graph.add("http://example.org/subject1", "http://example.org/predicate1", anzo.createBNode("123_a_funky-ID-for-a-BNode\u3433"));
            var serializedStr = anzo.rdf.serializer.NTripleSerializer.serialize(graph);
            
            var bnodeStartIndex = serializedStr.indexOf("_:");
            tests.assertTrue(bnodeStartIndex >= 0);
            var bnodeLabel = serializedStr.substring(bnodeStartIndex, serializedStr.length);
            tests.assertTrue(bnodeLabel.match(/_:[A-Za-z][A-Za-z0-9]*[ \t]*\.[ \t]*\n$/));
        },
        
        function test_DifferentBNodesAreSerializedWithDifferentLabels() {
            // summary: The BNode serialization has to keep the same bnodes the same and different bnodes different.
            var graph = new anzo.rdf.NamedGraph('http://example.org/graph');
            var bnode1 = anzo.createBNode();
            var bnode2 = anzo.createBNode();
            
            graph.add(bnode1, "http://example.org/predicate1", anzo.createLiteral("test"));
            graph.add(bnode1, "http://example.org/predicate2", anzo.createLiteral("more test"));
            graph.add(bnode2, "http://example.org/predicate1", bnode1);
            graph.add(bnode2, "http://example.org/predicate1", anzo.createLiteral("yet more test"));
            graph.add("http://example.org/subject1", "http://example.org/predicate1", bnode1);
            graph.add("http://example.org/subject1", "http://example.org/predicate1", bnode2);
            
            var serializedStr = anzo.rdf.serializer.NTripleSerializer.serialize(graph);

            // We can't compare serialization strings since there is more than one triple and the order of the triples is arbitrary in the serialization string.
            // So we parse the string and verify the resulting graph.
            var graph2 = new anzo.rdf.NamedGraph('http://example.org/graph2');
            anzo.rdf.parser.NTripleParser.parse(serializedStr, graph2);

            // Find the BNodes
            var stmt = graph2.find(null, "http://example.org/predicate1", anzo.createLiteral("test"));
            tests.assertTrue(stmt.length == 1);
            var parsedBnode1 = stmt[0].subject;
            stmt = graph2.find(null, "http://example.org/predicate1", anzo.createLiteral("yet more test"));
            tests.assertTrue(stmt.length == 1);
            var parsedBnode2 = stmt[0].subject;
            
            tests.assertTrue(!parsedBnode1.equals(parsedBnode2));
            tests.assertTrue(graph2.contains(parsedBnode1, "http://example.org/predicate1", anzo.createLiteral("test")));
            tests.assertTrue(graph2.contains(parsedBnode1, "http://example.org/predicate2", anzo.createLiteral("more test")));
            tests.assertTrue(graph2.contains(parsedBnode2, "http://example.org/predicate1", parsedBnode1));
            tests.assertTrue(graph2.contains(parsedBnode2, "http://example.org/predicate1", anzo.createLiteral("yet more test")));
            tests.assertTrue(graph2.contains("http://example.org/subject1", "http://example.org/predicate1", parsedBnode1));
            tests.assertTrue(graph2.contains("http://example.org/subject1", "http://example.org/predicate1", parsedBnode2));
        },

        function test_SerializingUnicodeCharactersAboveBMP() {
            // summary: Test that UTF-16 surrogate pairs are changed into the appropriate capital U escape sequence. 
            var graph = new anzo.rdf.NamedGraph('http://example.org/graph');
            graph.add("http://example.org/subject1", "http://example.org/predicate1", anzo.createLiteral("\uD800\uDF46"));

            var serializedStr = anzo.rdf.serializer.NTripleSerializer.serialize(graph);
            var expectedStr = '<http://example.org/subject1> <http://example.org/predicate1> "\\U00010346" .\n';
            
            tests.assertEqual(serializedStr, expectedStr);
        },
        
        function test_SerializingW3CExampleNTriplesFile() {
            // summary: Tests the serialization of the graph represented by the W3C example
            //  from http://www.w3.org/2000/10/rdf-tests/rdfcore/ntriples/test.nt

            var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/rdf/parser/w3cTest.nt");
            var graph1 = new anzo.rdf.NamedGraph('http://graph1');
            anzo.rdf.parser.NTripleParser.parse(str, graph1);
            
            // serialize the graph1 into N-Triples
            var serializedStr = anzo.rdf.serializer.NTripleSerializer.serialize(graph1);
            //doh.debug("serializedStr:\n" + serializedStr);
            
            // parse the serialized N-Triples into graph2
            var graph2 = new anzo.rdf.NamedGraph('http://graph2');
            anzo.rdf.parser.NTripleParser.parse(serializedStr, graph2);

            anzo.tests.utilities.assertW3CNTriplesExampleGraph(graph2);
        },

        function test_SerializingRealWorldOntologyExample() {
            // summary: Tests the serialization of a real world ontology example.

            // parse a properly serialized N-Triples into graph1
            var graph1 = new anzo.rdf.NamedGraph('http://graph1');
            var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/rdf/parser/ontology.nt");
            anzo.rdf.parser.NTripleParser.parse(str, graph1);
            
            // serialize the graph1 into N-Triples
            var serializedStr = anzo.rdf.serializer.NTripleSerializer.serialize(graph1);

            // parse the serialized N-Triples into graph2
            var graph2 = new anzo.rdf.NamedGraph('http://graph2');
            anzo.rdf.parser.NTripleParser.parse(serializedStr, graph2);

            anzo.tests.utilities.assertOntologyExampleGraph(graph2);            
        },
        
        function test_SerializingUserAndRolesRolesExample() {
            // summary: Tests the serialization of a real world example with user and role data.
            
            // parse a properly serialized n-triple into graph1
            var graph1 = new anzo.rdf.NamedGraph('http://graph1');
            var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/rdf/parser/usersAndRoles.nt");
            anzo.rdf.parser.NTripleParser.parse(str, graph1);
            
            // serialize the graph1 into n-triple
            var serializedStr = anzo.rdf.serializer.NTripleSerializer.serialize(graph1);
            
            // parse the serialized n-triple into graph2
            var graph2 = new anzo.rdf.NamedGraph('http://graph2');
            anzo.rdf.parser.NTripleParser.parse(serializedStr, graph2);
            
            anzo.tests.utilities.assertUserAndRolesExampleGraph(graph2);            
        }
    ]
);
