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

dojo.provide("anzo.tests.rdf.parser.NTripleParserTest");

dojo.require("anzo.rdf.Statement");
dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.rdf.parser.NTripleParser");
dojo.require("anzo.tests.utilities");
dojo.require('anzo.rdf.serializer.NTripleSerializer');

(function() {
    
function assertParseException(str, lineNumber, columnNumberLow, columnNumberHigh) {
    // summary: Utility function for testing the N-Triples parser. It calls the parser with the
    //  given string and checks that an exception is thrown and that the exception contains
    //  parseLineNumner and parseColumnNumber properties within the given ranges.
   
    var graph = new anzo.rdf.NamedGraph();
    var correctExceptionThrown = false;
    try {
        anzo.rdf.parser.NTripleParser.parse(str, graph);
    } catch (e) {
        tests.assertTrue(e instanceof anzo.rdf.parser.NTripleParser.NTriplesParserError);
        //doh.debug("e.parseColumnNumber:" + e.parseLineNumber + " e.parseColumnNumber:" + e.parseColumnNumber);
        if (lineNumber != null) {
            tests.assertTrue(e.parseLineNumber == lineNumber);
        }
        if (columnNumberLow != null && columnNumberHigh != null) {
            tests.assertTrue(e.parseColumnNumber >= columnNumberLow && e.parseColumnNumber <= columnNumberHigh);
        }
        correctExceptionThrown = true;
    }
    tests.assertTrue(correctExceptionThrown);
}

tests.register("anzo.tests.rdf.parser.NTripleParserTest", 
    [
        function test_ParsingWithComments() {
            // summary: Parse a single triple surrounded by comment lines
            var graph = new anzo.rdf.NamedGraph();
            var str = '# SOME COMMENT TEXT\n<http://openanzo.org/users/sysadmin> <http://openanzo.org/ontologies/2008/07/Anzo#inRole> <http://openanzo.org/Role/sysAdmin> .\n# SOME MORE COMMENT TEXT';
            anzo.rdf.parser.NTripleParser.parse(str, graph);
            
            tests.assertTrue(graph.size() == 1);
            tests.assertTrue(graph.contains("http://openanzo.org/users/sysadmin", "http://openanzo.org/ontologies/2008/07/Anzo#inRole", "http://openanzo.org/Role/sysAdmin"));
        },
        
        function test_ParsingLanguages() {
            // summary: The following regular expression defines what a language designator looks like: [a-z]+('-' [a-z0-9]+ )* 
            //  See the grammar at http://www.w3.org/TR/rdf-testcases/#ntriples
            var graph = new anzo.rdf.NamedGraph();
            var str = '<http://example.org/subject1> <http://example.org/predicate1> "a literal"@en .\n<http://example.org/subject2> <http://example.org/predicate2> "another literal"@en-us-ca52.';
            anzo.rdf.parser.NTripleParser.parse(str, graph);
            tests.assertTrue(graph.size() == 2);
            tests.assertTrue(graph.contains("http://example.org/subject1", "http://example.org/predicate1", anzo.createLiteral("a literal", "en")));
            tests.assertTrue(graph.contains("http://example.org/subject2", "http://example.org/predicate2", anzo.createLiteral("another literal", "en-us-ca52")));
        },

        function test_ParsingOnlyCommentsAndBlankLines() {
            // summary: Tests parsing a string with nothing but comments in various forms.
            var graph = new anzo.rdf.NamedGraph();
            var string = '\n# SOME COMMENT TEXT\n    \t# SOME COMMENT TEXT\n\n\r\n\t # <#> \r'; // Note that lines end in either \n, \r\n, or \r (rare Mac style)
            anzo.rdf.parser.NTripleParser.parse(string, graph);
            tests.assertTrue(graph.size() == 0);
        },

        function test_ParseLowercaseUnicodeEscapeSequences() {
            // summary: Tests parsing \u0000 unicode escape sequences in URIs and in literals.
            var graph = new anzo.rdf.NamedGraph();
            // The subject here, unescaped is "http://example.org/subject1"
            var str = '<\\u0068ttp://exam\\u0070le.org/subject\\u0031> <http://example.org/predicate1> "\\uAF34\\u0145" .';
            anzo.rdf.parser.NTripleParser.parse(str, graph);
            tests.assertTrue(graph.size() == 1);
            tests.assertTrue(graph.contains("http://example.org/subject1", "http://example.org/predicate1", anzo.createLiteral("\uAF34\u0145")));
        },

        function test_ParseUppercaseUnicodeEscapeSequences() {
            // summary: Tests parsing \U00000000 unicode escape sequences in URIs and in literals.
            var graph = new anzo.rdf.NamedGraph();
            // The subject here, unescaped is "http://example.org/subject1"
            // The literal contains a character outside of the unicode Basic Multilingual Plane (code point is greater than FFFF).
            // The character is the gothic letter 'faihu'at unicode code point U+10346. Since JavaScript strings are in
            // UTF-16, then the only way to represent this character in a JavaScript string is to use the UTF-16 encoding
            // for the character. That encoding spans four bytes or two JavaScript characters (the UTF-16 surrogate pair).
            // The UTF-16 surrogate pair for the 'faihu' character comes out to be \uD800 and \uDF46.
            // See http://www.tbray.org/ongoing/When/200x/2003/04/26/UTF for some information.
            var str = '<\\U00000068ttp://exam\\U00000070le.org/subject\\U00000031> <http://example.org/predicate1> "\\U00010346" .';
            anzo.rdf.parser.NTripleParser.parse(str, graph);
            tests.assertTrue(graph.size() == 1);
            tests.assertTrue(graph.contains("http://example.org/subject1", "http://example.org/predicate1", anzo.createLiteral("\uD800\uDF46")));
        },

        function test_ParserExceptionIsInstanceOfError() {
            // summary: We want the heirarchy set correctly. It must inherit from Error.
            var graph = new anzo.rdf.NamedGraph();
            var correctExceptionThrown = false;
            try {
                anzo.rdf.parser.NTripleParser.parse("erroneous string - not a valid N-Triples document.", graph);
            } catch (e) {
                tests.assertTrue(e instanceof anzo.rdf.parser.NTripleParser.NTriplesParserError);
                tests.assertTrue(e instanceof Error);
                correctExceptionThrown = true;
            }
            tests.assertTrue(correctExceptionThrown);
        },

        function test_EmptyURIsAreNotAllowed() {
            var str = '<> <http://example.org/predicate> "simple literal" .';        
            assertParseException(str, 1, 2, 2);
        },
        
        function test_ParserThrowsErrorForIncompleteUnicodeEscapeSequences() {
            // summary: Unicode escape sequences must have 4 or 8 characters depending on whether they us a lowercase or uppercase 'u'.
            //  We also ensure that the error thrown has correct parseLineNumber and parseColumnNumber information pointing at the location of the error. 
            var str = '<\\u123> <http://example.org/predicate1> "a literal" .';
            assertParseException(str, 1, 2, 7);

            str = '<http://example.com> <http://example.org/predicate1> "a literal\\UFFFF" .';
            assertParseException(str, 1, 64, 70);

            str = '<http://example.com> <http://example.org/predicate1> "\\u r a literal" .';
            assertParseException(str, 1, 55, 57);

            // Only uppercase hex digits are allowed.
            str = '\n\n\n<http://example.com> <http://\\UAAAABBBbexample.org/predicate1> "a literal" .';
            assertParseException(str, 4, 30, 39);
        },

        function test_TriplesMustBeSeperatedByNewlines() {
            var str = '<http://example.org/resource1> <http://example.org/predicate> "foo" . <http://example.org/resource2> <http://example.org/predicate> "foo" .';
            assertParseException(str, 1, 71, 71);
        },
        
        function test_DotRequiredEvenForLastTripleAndEndOfFile() {
            var str = '<http://example.org/resource1> <http://example.org/predicate> "foo"';
            assertParseException(str, 1, 68, 68);

            // Try it with the newline
            str = '<http://example.org/resource1> <http://example.org/predicate> "foo"\n';
            assertParseException(str, 1, 68, 68);
        },
         
        function test_OnlyLowercaseAlphanumericCharactersAllowedForLanguage() {
            // summary: The following regular expression defines what a language designator looks like: [a-z]+(-[a-z0-9]+)* 
            //  See the grammar at http://www.w3.org/TR/rdf-testcases/#ntriples
            //  We also ensure that the error thrown has correct parseLineNumber and parseColumnNumber information pointing at the location of the error. 
            var str = '<http://example.org/resource1> <http://example.org/predicate> "foo"@French .';
            assertParseException(str, 1, 69, 69);

            str = '<http://example.org/resource1> <http://example.org/predicate> "foo"@-us .';
            assertParseException(str, 1, 69, 69);

            str = '<http://example.org/resource1> <http://example.org/predicate> "foo"@en-us-.';
            assertParseException(str, 1, 75, 75);

            // Multiple dashes in a row aren't allowed.
            str = '<http://example.org/resource1> <http://example.org/predicate> "foo"@en-us--ca.';
            assertParseException(str, 1, 75, 75);
        },

        function test_ParsingW3CExampleNTriplesFile() {
            // summary: The W3C defines the N-Triples format here: http://www.w3.org/TR/rdf-testcases/#ntriples
            //  They provide a sample N-Triples file for testing. This test loads that file and verifies
            //  that the data was loaded into the graph correctly.
            var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/rdf/parser/w3cTest.nt");
            var graph = new anzo.rdf.NamedGraph();
            anzo.rdf.parser.NTripleParser.parse(str, graph);

            anzo.tests.utilities.assertW3CNTriplesExampleGraph(graph);
        },
        
        function test_ParsingOntologyExample() {
            // summary: Tests a real world ontology example.
            var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/rdf/parser/ontology.nt");
            var graph = new anzo.rdf.NamedGraph();
            anzo.rdf.parser.NTripleParser.parse(str, graph);

            anzo.tests.utilities.assertOntologyExampleGraph(graph);
        },
        
        function test_ParsingUserAndRolesRolesExample() {
            // summary: Test real word example containing user and role information
            var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/rdf/parser/usersAndRoles.nt");
            var graph = new anzo.rdf.NamedGraph();
            anzo.rdf.parser.NTripleParser.parse(str, graph);

            anzo.tests.utilities.assertUserAndRolesExampleGraph(graph);
        },
    ]
);

})();
