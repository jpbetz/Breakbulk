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

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.rdf.StatementTest");

dojo.require("anzo.rdf.Statement");
dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.rdf.vocabulary.RDF");
dojo.require("anzo.log");
dojo.require("anzo.tests.utilities");

(function() {
var log = anzo.log.getLogger("anzo.tests.rdf.StatementTest");

tests.register("anzo.tests.rdf.StatementTest",
    [
        function test_Literal() {
            var l1 = new anzo.rdf.Literal('rouben');
            var l2 = new anzo.rdf.Literal('rouben');
            tests.assertTrue(l1.equals(l2));
            tests.assertTrue(l1.dictionaryKey() == l2.dictionaryKey());
            tests.assertTrue(l1.value == l2.value);

            var l3 = new anzo.rdf.Literal('rouben');
            l3.language = 'English';
            tests.assertFalse(l1.equals(l3));
            tests.assertTrue(l1.dictionaryKey() != l3.dictionaryKey());

            tests.assertTrue(l1 instanceof anzo.rdf.Literal);
            tests.assertTrue(l1 instanceof anzo.rdf.Value);

            var l4 = new anzo.rdf.Literal('foo"bar', 'en');
            var l4_1 = new anzo.rdf.Literal('foo"bar', 'en');
            tests.assertTrue(l4.equals(l4_1));
            tests.assertTrue(l4.serialize() == '"foo\\"bar"@en');

            var l5 = new anzo.rdf.Literal(true);
            var l5_1 = new anzo.rdf.Literal(true);
            tests.assertTrue(l5.equals(l5_1));
            tests.assertTrue(l5.serialize() == '"true"');

            var l6 = new anzo.rdf.Literal(true, 'en');
            var l6_1 = new anzo.rdf.Literal('true', 'en');
            tests.assertTrue(l6.equals(l6_1));
            tests.assertTrue(l6.serialize() == '"true"@en');

            var l7 = new anzo.rdf.Literal('foo"bar', 'en');
            var l7_1 = new anzo.rdf.Literal('foo"bar', 'gr');
            tests.assertFalse(l7.equals(l7_1));
        },

        function test_TypedLiteral() {

            var l1 = new anzo.rdf.Literal('rouben', null, anzo.rdf.vocabulary.XMLSchema.xsString);
            var l2 = new anzo.rdf.Literal('rouben', null, anzo.rdf.vocabulary.XMLSchema.xsString);

            tests.assertTrue(l1.equals(l2));
            tests.assertTrue(l1.dictionaryKey() == l2.dictionaryKey());
            tests.assertTrue(l1.value == l2.value);

            var l3 = new anzo.rdf.Literal('rouben');
            tests.assertFalse(l1.equals(l3));
            tests.assertTrue(l1.dictionaryKey() != l3.dictionaryKey());

            tests.assertTrue(l1 instanceof anzo.rdf.Literal);
            tests.assertTrue(l1 instanceof anzo.rdf.Value);

            var l4 = new anzo.rdf.Literal('foo"bar', null, anzo.rdf.vocabulary.XMLSchema.xsString);
            var l4_1 = new anzo.rdf.Literal('foo"bar', null, anzo.rdf.vocabulary.XMLSchema.xsString);
            tests.assertTrue(l4.equals(l4_1));
            tests.assertTrue(l4.serialize() == '"foo\\"bar"^^<http://www.w3.org/2001/XMLSchema#string>');

            var l5 = new anzo.rdf.Literal(true, null, anzo.rdf.vocabulary.XMLSchema.xsString);
            var l5_1 = new anzo.rdf.Literal(true, null, anzo.rdf.vocabulary.XMLSchema.xsString);
            tests.assertTrue(l5.equals(l5_1));
            tests.assertTrue(l5.serialize() == '"true"^^<http://www.w3.org/2001/XMLSchema#string>');

        },

        function test_URI() {

            var l1 = new anzo.rdf.URI('http://test1');
            var l2 = new anzo.rdf.URI('http://test1');

            tests.assertTrue(l1.equals(l2));
            tests.assertTrue(l1.dictionaryKey() == l2.dictionaryKey());
            tests.assertTrue(l1.value == l2.value);

            tests.assertTrue(l1 instanceof anzo.rdf.URI);
            tests.assertTrue(l1 instanceof anzo.rdf.Resource);
            tests.assertTrue(l1 instanceof anzo.rdf.Value);

            var uri_1 = anzo.createURI('http://foo#name');
            tests.assertTrue(uri_1.getLocalName() == 'name');
            tests.assertTrue(uri_1.getNamespace() == 'http://foo#');
            tests.assertTrue(uri_1.serialize() == '<http://foo#name>');

            var uri_2 = anzo.createURI('http://foo/name');
            tests.assertTrue(uri_2.getLocalName() == 'name');
            tests.assertTrue(uri_2.getNamespace() == 'http://foo/');
            tests.assertTrue(uri_2.serialize() == '<http://foo/name>');


        },

        function test_BNode() {
            var l1 = new anzo.rdf.BNode('123');
            var l2 = new anzo.rdf.BNode('123');

            tests.assertTrue(l1.equals(l2));
            tests.assertTrue(l1.dictionaryKey() == l2.dictionaryKey());
            tests.assertTrue(l1.value == l2.value);

            tests.assertTrue(l1 instanceof anzo.rdf.BNode);
            tests.assertTrue(l1 instanceof anzo.rdf.Resource);
            tests.assertTrue(l1 instanceof anzo.rdf.Value);

            var l3 = new anzo.createBNode();
            log.debug(l3.value);
        },

        function test_GetValue() {
     
            var uri = anzo.rdf.getValue('http://foo', {type: 'anzo.rdf.Resource' });
            tests.assertTrue(uri != null);
            tests.assertTrue(uri instanceof anzo.rdf.URI);

            var uri2 = anzo.rdf.getValue('http://foo');
            tests.assertTrue(uri2 != null);
            tests.assertTrue(uri2 instanceof anzo.rdf.URI);

            var bnode = anzo.rdf.getValue('123', {type: 'anzo.rdf.Resource' });
            tests.assertTrue(bnode != null);
            tests.assertTrue(bnode instanceof anzo.rdf.BNode);

            var literal = anzo.rdf.getValue("Rouben");
            tests.assertTrue(literal.datatype === undefined);
            tests.assertTrue(literal.language === undefined);

            var literal = anzo.rdf.getValue('http://foo', {language: 'en' });
            tests.assertTrue(literal != null);
            tests.assertTrue(literal instanceof anzo.rdf.Literal);
            tests.assertTrue(literal.language == 'en');
            
            var literal = anzo.rdf.getValue(true, {type: 'literal'});
            tests.assertTrue(literal != null);
            tests.assertTrue(literal instanceof anzo.rdf.Literal);
            tests.assertTrue(literal.language == null);
            tests.assertTrue(literal.datatype == null);

            var literal = anzo.rdf.getValue('http://foo', { datatype: anzo.rdf.vocabulary.XMLSchema.xsString });
            tests.assertTrue(literal != null);
            tests.assertTrue(literal instanceof anzo.rdf.Literal);
            tests.assertTrue(literal.datatype.equals(anzo.rdf.vocabulary.XMLSchema.xsString));
            tests.assertTrue(literal.language == null);

            var dateLiteral = anzo.rdf.getValue(new Date(1216330344703)); // Thu Jul 17 17:32:24.703 EDT 2008 which is Thu Jul 17 21:32:24.703 UTC 2008
            tests.assertTrue(dateLiteral.datatype.equals(anzo.rdf.vocabulary.XMLSchema.xsDateTime));
            tests.assertTrue(dojo.isString(dateLiteral.value));
            tests.assertEqual("2008-07-17T21:32:24.703Z", dateLiteral.value);

            var dateLiteral = anzo.rdf.getValue(new Date(1216330344703)); // Thu Jul 17 17:32:24.703 EDT 2008 which is Thu Jul 17 21:32:24.703 UTC 2008
            tests.assertTrue(dateLiteral.datatype.equals(anzo.rdf.vocabulary.XMLSchema.xsDateTime));
            tests.assertTrue(dojo.isString(dateLiteral.value));
            tests.assertEqual("2008-07-17T21:32:24.703Z", dateLiteral.value);

            // TEST PASSING SERIALIZED VALUES
            var uri1 = anzo.rdf.getValue('<http://www.example.org/vocabulary#foo>');
            tests.assertTrue(uri1 != null);
            tests.assertTrue(uri1 instanceof anzo.rdf.URI);
            tests.assertTrue(uri1.value.toString() == 'http://www.example.org/vocabulary#foo');
            tests.assertTrue(uri1.serialize() == '<http://www.example.org/vocabulary#foo>');

            var bnode = anzo.rdf.getValue('_:324453142134353214');
            tests.assertTrue(bnode != null);
            tests.assertTrue(bnode instanceof anzo.rdf.BNode);
            tests.assertTrue(bnode.value.toString() == '324453142134353214');
            tests.assertTrue(bnode.serialize() == '_:324453142134353214');

            var literal1 = anzo.rdf.getValue('"foo"');
            tests.assertTrue(literal1 != null);
            tests.assertTrue(literal1 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal1.value.toString() == 'foo');
            tests.assertTrue(literal1.serialize() == '"foo"');

            var literal2 = anzo.rdf.getValue("'foo'");
            tests.assertTrue(literal2 != null);
            tests.assertTrue(literal2 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal2.value.toString() == 'foo');
            console.debug(literal2.serialize());
            tests.assertTrue(literal2.serialize() == '"foo"');

            var literal3 = anzo.rdf.getValue("'foo'^^<http://foo>");
            tests.assertTrue(literal3 != null);
            tests.assertTrue(literal3 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal3.value.toString() == 'foo');
            tests.assertTrue(literal3.datatype.toString() == 'http://foo');
            tests.assertTrue(literal3.serialize() == '"foo"^^<http://foo>');

            var literal4 = anzo.rdf.getValue('"foo"^^<http://foo>');
            tests.assertTrue(literal4 != null);
            tests.assertTrue(literal4 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal4.value.toString() == 'foo');
            tests.assertTrue(literal4.datatype.toString() == 'http://foo');
            tests.assertTrue(literal4.serialize() == '"foo"^^<http://foo>');

            var literal5 = anzo.rdf.getValue("'foo'@en");
            tests.assertTrue(literal5 != null);
            tests.assertTrue(literal5 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal5.value.toString() == 'foo');
            tests.assertTrue(literal5.language.toString() == 'en');
            tests.assertTrue(literal5.serialize() == '"foo"@en');

            var literal6 = anzo.rdf.getValue('"foo"@en');
            tests.assertTrue(literal6 != null);
            tests.assertTrue(literal6 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal6.value.toString() == 'foo');
            tests.assertTrue(literal6.language.toString() == 'en');
            tests.assertTrue(literal6.serialize() == '"foo"@en');

            var literal7 = anzo.rdf.getValue("'f\"o'o'b'a'r\"'^^<http://foo>");
            tests.assertTrue(literal7 != null);
            tests.assertTrue(literal7 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal7.value.toString() == "f\"o'o'b'a'r\"");
            tests.assertTrue(literal7.datatype.toString() == 'http://foo');

            var _v = 'foo"bar';
            var literal8 = anzo.rdf.getValue('"'+_v+'"^^<http://foo>');
            tests.assertTrue(literal8 != null);
            tests.assertTrue(literal8 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal8.value.toString() == "foo\"bar");
            tests.assertTrue(literal8.datatype.toString() == 'http://foo');
            tests.assertTrue(literal8.serialize() == '"foo\\"bar"^^<http://foo>');

            // Some border conditions
            var literal9 = anzo.rdf.getValue("'");
            tests.assertTrue(literal9 != null);
            tests.assertTrue(literal9 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal9.value.toString() == "'");

            var literal10 = anzo.rdf.getValue("<>");
            tests.assertTrue(literal10 != null);
            tests.assertTrue(literal10 instanceof anzo.rdf.Literal);
            tests.assertTrue(literal10.value.toString() == "<>");
            
            // Test use of shorthand 'a' to specify rdf:type
        	var uri = anzo.rdf.getValue('a', {type: 'uri' });
        	tests.assertTrue(uri != null);
            tests.assertTrue(uri instanceof anzo.rdf.URI);
            tests.assertTrue(uri.equals(anzo.rdf.vocabulary.RDF.type));
            
        	var literal = anzo.rdf.getValue('a');
        	tests.assertTrue(literal != null);
        	tests.assertTrue(literal instanceof anzo.rdf.Literal);
            tests.assertTrue(literal.value.toString() == 'a');
            tests.assertTrue(literal.serialize() == '"a"');
            
            var stmt = anzo.createStatement('a', 'a', 'a', 'a');
            tests.assertTrue(stmt.subject instanceof anzo.rdf.BNode);
            tests.assertTrue(stmt.subject.value == 'a');
            tests.assertTrue(stmt.predicate instanceof anzo.rdf.URI);
            tests.assertTrue(stmt.predicate.equals(anzo.rdf.vocabulary.RDF.type));
            tests.assertTrue(stmt.object instanceof anzo.rdf.Literal);
            tests.assertTrue(stmt.object.serialize() == '"a"');
            tests.assertTrue(stmt.namedGraphUri instanceof anzo.rdf.URI);
            tests.assertTrue(stmt.namedGraphUri.equals(anzo.rdf.vocabulary.RDF.type));
            
        },

        function test_GetValueSupportsSPARQLResultsJSONSerilization() {
            // summary: The anzo.rdf.getValue method supports creating nodes based on information
            //   from a SPARQL Result in JSON format. You can pass the variable binding as the 'contraint'
            //   to create an RDF value of the appropriate form. For example:
            //   |  anzo.rdf.getValue(varBinding.value, varBinding);
            //   This test uses a sample JSON SPARQL Result to make sure that functionality works
            //   for all forms of values.

            var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/rdf/sampleSPARQLResult.json");
            var solution = dojo.fromJson(str);

            var binding, varBinding, v;

            // First binding
            binding = solution.results.bindings[0];
            varBinding = binding["x"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.BNode);

            varBinding = binding["hpage"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.URI);
            tests.assertEqual("http://work.example.org/alice/", v.value);

            varBinding = binding["name"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.Literal);
            tests.assertEqual("Alice", v.value);
            tests.assertTrue(v.language == null);
            tests.assertTrue(v.datatype == null);

            varBinding = binding["mbox"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.Literal);
            tests.assertEqual("", v.value);
            tests.assertTrue(v.language == null);
            tests.assertTrue(v.datatype == null);

            varBinding = binding["blurb"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.Literal);
            tests.assertEqual("<p xmlns=\"http://www.w3.org/1999/xhtml\">My name is <b>alice</b></p>", v.value);
            tests.assertTrue(v.language == null);
            tests.assertEqual("http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral", v.datatype.value);

            varBinding = binding["friend"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.BNode);

            // Second binding
            binding = solution.results.bindings[1];
            varBinding = binding["x"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.BNode);

            varBinding = binding["hpage"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.URI);
            tests.assertEqual("http://work.example.org/bob/", v.value);

            varBinding = binding["name"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.Literal);
            tests.assertEqual("Bob", v.value);
            tests.assertTrue(v.language === "en");
            tests.assertTrue(v.datatype == null);

            varBinding = binding["mbox"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.URI);
            tests.assertEqual("mailto:bob@work.example.org", v.value);

            varBinding = binding["friend"];
            v = anzo.rdf.getValue(varBinding.value, varBinding);
            tests.assertTrue(v instanceof anzo.rdf.BNode);
        },

        function test_ValueFactory() {
            // LITERAL
            var l1 = anzo.createLiteral('rouben', 'english');
            var l1_1 = new anzo.rdf.Literal('rouben');
            var l1_11 = new anzo.rdf.Literal('rouben', 'english');

            tests.assertFalse(l1.equals(l1_1));
            tests.assertFalse(l1.dictionaryKey() == l1_1.dictionaryKey());

            tests.assertTrue(l1.equals(l1_11));
            tests.assertTrue(l1.dictionaryKey() == l1_11.dictionaryKey());

            // TYPED LITERAL
            var l1 = anzo.createTypedLiteral('rouben', anzo.rdf.vocabulary.XMLSchema.xsString);
            var l1_1 = new anzo.rdf.Literal('rouben');
            var l1_11 = new anzo.rdf.Literal('rouben', null, anzo.rdf.vocabulary.XMLSchema.xsString);


            tests.assertFalse(l1.equals(l1_1));
            tests.assertFalse(l1.dictionaryKey() == l1_1.dictionaryKey());
            tests.assertTrue(l1.equals(l1_11));
            tests.assertTrue(l1.dictionaryKey() == l1_11.dictionaryKey());

            // URI
            var l1 = anzo.createURI('http://uri1');
            var l1_1 = new anzo.rdf.URI('http://uri1');
            tests.assertTrue(l1.equals(l1_1));
            tests.assertTrue(l1.dictionaryKey() == l1_1.dictionaryKey());

            // BNODE
            var l1 = anzo.createBNode('bnode_1');
            var l1_1 = new anzo.rdf.BNode('bnode_1');
            tests.assertTrue(l1.equals(l1_1));
            tests.assertTrue(l1.dictionaryKey() == l1_1.dictionaryKey());

            // STATEMENT

            var l1 = anzo.createStatement('http://subj1', 'http://pred1', 'http://obj1');
            tests.assertTrue(l1.subject.equals(new anzo.rdf.URI('http://subj1')));
            tests.assertTrue(l1.predicate.equals(new anzo.rdf.URI('http://pred1')));
            tests.assertTrue(l1.object.equals(new anzo.rdf.URI('http://obj1')));

            var l2 = anzo.createStatement('bnode_1', 'http://pred1', 'http://obj1');
            tests.assertTrue(l2.subject.equals(new anzo.rdf.BNode('bnode_1')));
            tests.assertTrue(l2.predicate.equals(new anzo.rdf.URI('http://pred1')));
            tests.assertTrue(l2.object.equals(new anzo.rdf.URI('http://obj1')));

            var l3 = anzo.createStatement('bnode_1', 'http://pred1', 'rouben');
            tests.assertTrue(l3.subject.equals(new anzo.rdf.BNode('bnode_1')));
            tests.assertTrue(l3.predicate.equals(new anzo.rdf.URI('http://pred1')));
            tests.assertTrue(l3.object.equals(anzo.createLiteral('rouben')));

            var l4 = anzo.createStatement('_:523462345345', 'http://pred1', '"123"^^<http://www.w3.org/2001/XMLSchema#integer>');
            tests.assertTrue(l4.subject.equals(new anzo.rdf.BNode('523462345345')));
            tests.assertTrue(l4.predicate.equals(new anzo.rdf.URI('http://pred1')));
            tests.assertTrue(l4.object.equals(anzo.createTypedLiteral('123', 'http://www.w3.org/2001/XMLSchema#integer')));

        },

        function test_Statement() {

            var uri1 = new anzo.rdf.URI('http://uri1');
            var uri2 = new anzo.rdf.URI('http://uri2');
            var uri3 = new anzo.rdf.URI('http://uri3');
            var uri4 = new anzo.rdf.URI('http://uri4');

            var bnode1 = new anzo.rdf.BNode("bnode_1");
            var bnode2 = new anzo.rdf.BNode("bnode_2");
            var bnode3 = new anzo.rdf.BNode("bnode_3");

            var l1 = new anzo.rdf.Literal("l1");
            var l2 = new anzo.rdf.Literal("l2");
            var l3 = new anzo.rdf.Literal("l3");


            // TRIPLE
            var triple1 = new anzo.rdf.Statement(uri1, uri2, uri3);
            var triple2 = new anzo.rdf.Statement(uri1, uri2, uri3);

            tests.assertTrue(triple1.equals(triple2));
            tests.assertTrue(triple1.dictionaryKey() == triple2.dictionaryKey());

            tests.assertTrue(triple1.subject == uri1);
            tests.assertTrue(triple1.predicate == uri2);
            tests.assertTrue(triple1.object == uri3);

            // QUAD

            var quad1 = new anzo.rdf.Statement(uri1, uri2, uri3, uri4);
            var quad2 = new anzo.rdf.Statement(uri1, uri2, uri3, uri4);

            tests.assertTrue(quad1.equals(quad2));
            tests.assertTrue(quad1.dictionaryKey() == quad2.dictionaryKey());

            tests.assertTrue(quad1.subject == uri1);
            tests.assertTrue(quad1.predicate == uri2);
            tests.assertTrue(quad1.object == uri3);
            tests.assertTrue(quad1.namedGraphUri == uri4);

        },

        function test_Namespaces() {

            anzo.rdf.registerNamespace('foo', 'http://purl.org/dc/elements/1.1/');

            var uri = anzo.createURI("foo:title");
            tests.assertTrue(uri.value == 'http://purl.org/dc/elements/1.1/title');

            var uri2 = anzo.rdf.getValue('foo:description', { type: 'anzo.rdf.URI'})
            tests.assertTrue(uri2.value == 'http://purl.org/dc/elements/1.1/description');

        },

        function test_plainLiteralsAreDefault() {
            // summary: When passing in strings, the default should be to create
            //    a plain literal (rather than a typed literal).
            //    See http://www.openanzo.org/projects/openanzo/ticket/213

            var s1 = anzo.createStatement('http://subj1', 'http://pred1', 'my string');
            tests.assertTrue(s1.object.equals(new anzo.createLiteral('my string')));
            tests.assertTrue(s1.object.datatype === undefined);
            tests.assertTrue(s1.object.language === undefined);

            var v1 = anzo.rdf.getValue('another string');
            tests.assertTrue(v1.equals(new anzo.createLiteral('another string')));
            tests.assertTrue(v1.datatype === undefined);
            tests.assertTrue(v1.language === undefined);

            var v2 = anzo.rdf.getValue('yet another string', { type : "anzo.rdf.Literal" });
            tests.assertTrue(v2.equals(new anzo.createLiteral('yet another string')));
            tests.assertTrue(v2.datatype === undefined);
            tests.assertTrue(v2.language === undefined);
        },

        function test_convertNumbersToXsdFloatingPointLiterals() {

            var lit;

            // xsd:double is the default for numbers
            var datatypes = [
                undefined, // the default
                "http://www.w3.org/2001/XMLSchema#double",
                "http://www.w3.org/2001/XMLSchema#float",
                "http://www.w3.org/2001/XMLSchema#string"
            ];

            for (var i = 0; i < datatypes.length; i++) {
                var expectedDatatype = datatypes[i] === undefined ? "http://www.w3.org/2001/XMLSchema#double" : datatypes[i];
                log.debug("convertNumbersToXsdFloatingPointLiterals - checking " + expectedDatatype);
                lit = anzo.createTypedLiteral(2, expectedDatatype);
                tests.assertEqual("2", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(2.6, expectedDatatype);
                tests.assertEqual("2.6", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(2.648839948, expectedDatatype);
                tests.assertEqual("2.648839948", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(1.0 / 10.0, expectedDatatype); // can't be represented as a double typically but current browsers seem to handle it fine
                tests.assertEqual("0.1", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(-3, expectedDatatype);
                tests.assertEqual("-3", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(Number.POSITIVE_INFINITY, expectedDatatype);
                tests.assertEqual("INF", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(Number.NEGATIVE_INFINITY, expectedDatatype);
                tests.assertEqual("-INF", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(Number.NaN, expectedDatatype);
                tests.assertEqual("NaN", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(Number.MAX_VALUE, expectedDatatype);
                tests.assertEqual("1.7976931348623157e+308", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(Number.MIN_VALUE, expectedDatatype);
                tests.assertEqual("5e-324", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());
            }

            // Now test the createLiteral method
            lit = anzo.createLiteral(2);
            tests.assertEqual("2", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(2.6);
            tests.assertEqual("2.6", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(2.648839948);
            tests.assertEqual("2.648839948", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(1.0 / 10.0); // can't be represented as a double typically but current browsers seem to handle it fine
            tests.assertEqual("0.1", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(-3);
            tests.assertEqual("-3", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(Number.POSITIVE_INFINITY);
            tests.assertEqual("INF", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(Number.NEGATIVE_INFINITY);
            tests.assertEqual("-INF", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(Number.NaN);
            tests.assertEqual("NaN", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(Number.MAX_VALUE);
            tests.assertEqual("1.7976931348623157e+308", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(Number.MIN_VALUE);
            tests.assertEqual("5e-324", lit.value);
            tests.assertTrue(lit.datatype === undefined);
        },

        function test_convertNumbersToXsdDecimalLiterals() {

            var lit;
            var expectedDatatype = "http://www.w3.org/2001/XMLSchema#decimal";
            lit = anzo.createTypedLiteral(2, expectedDatatype);
            tests.assertEqual("2", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            lit = anzo.createTypedLiteral(2.6, expectedDatatype);
            tests.assertEqual("2.6", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            lit = anzo.createTypedLiteral(2.648839948, expectedDatatype);
            tests.assertEqual("2.648839948", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            lit = anzo.createTypedLiteral(1.0 / 10.0, expectedDatatype); // can't be represented as a double typically but current browsers seem to handle it fine
            tests.assertEqual("0.1", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            lit = anzo.createTypedLiteral(-3, expectedDatatype);
            tests.assertEqual("-3", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            tests.assertError(Error, anzo, "createTypedLiteral", [Number.POSITIVE_INFINITY, expectedDatatype]);
            tests.assertError(Error, anzo, "createTypedLiteral", [Number.NEGATIVE_INFINITY, expectedDatatype]);
            tests.assertError(Error, anzo, "createTypedLiteral", [Number.NaN, expectedDatatype]);
        },

        function test_convertNumbersToXsdIntegralLiterals() {

            var lit;

            var datatypes = [
                "http://www.w3.org/2001/XMLSchema#integer",
                "http://www.w3.org/2001/XMLSchema#int",
                "http://www.w3.org/2001/XMLSchema#negativeInteger",
                "http://www.w3.org/2001/XMLSchema#long",
                "http://www.w3.org/2001/XMLSchema#short",
                "http://www.w3.org/2001/XMLSchema#byte",
                "http://www.w3.org/2001/XMLSchema#nonNegativeInteger",
                "http://www.w3.org/2001/XMLSchema#unsignedLong",
                "http://www.w3.org/2001/XMLSchema#unsignedInt",
                "http://www.w3.org/2001/XMLSchema#unsignedShort",
                "http://www.w3.org/2001/XMLSchema#unsignedByte",
                "http://www.w3.org/2001/XMLSchema#positiveInteger"
            ];

            for (var i = 0; i < datatypes.length; i++) {
                var expectedDatatype = datatypes[i];
                log.debug("test_convertNumbersToXsdIntegralLiterals - checking " + expectedDatatype);
                lit = anzo.createTypedLiteral(2, expectedDatatype);
                tests.assertEqual("2", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(2.6, expectedDatatype);
                tests.assertEqual("3", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(2.648839948, expectedDatatype);
                tests.assertEqual("3", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(1.0 / 10.0, expectedDatatype); // can't be represented as a double typically but current browsers seem to handle it fine
                tests.assertEqual("0", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(-3000, expectedDatatype);
                tests.assertEqual("-3000", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                tests.assertError(Error, anzo, "createTypedLiteral", [Number.POSITIVE_INFINITY, expectedDatatype]);
                tests.assertError(Error, anzo, "createTypedLiteral", [Number.NEGATIVE_INFINITY, expectedDatatype]);
                tests.assertError(Error, anzo, "createTypedLiteral", [Number.NaN, expectedDatatype]);
            }
        },

        function test_convertBooleanToXsdBooleanLiterals() {

            var lit;

            // xsd:boolean is the default for booleans
            var datatypes = [
                undefined, // the default
                "http://www.w3.org/2001/XMLSchema#boolean",
                "http://www.w3.org/2001/XMLSchema#string"
            ];

            for (var i = 0; i < datatypes.length; i++) {
                var expectedDatatype = datatypes[i] === undefined ? "http://www.w3.org/2001/XMLSchema#boolean" : datatypes[i];
                log.debug("convertNumbersToXsdBooleanLiterals - checking " + expectedDatatype);

                lit = anzo.createTypedLiteral(true, expectedDatatype);
                tests.assertEqual("true", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(false, expectedDatatype);
                tests.assertEqual("false", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(new Boolean(true), expectedDatatype);
                tests.assertEqual("true", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(new Boolean(false), expectedDatatype);
                tests.assertEqual("false", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());
            }

            // Now test the createLiteral method
            lit = anzo.createLiteral(true);
            tests.assertEqual("true", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(false);
            tests.assertEqual("false", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(new Boolean(true));
            tests.assertEqual("true", lit.value);
            tests.assertTrue(lit.datatype === undefined);

            lit = anzo.createLiteral(new Boolean(false));
            tests.assertEqual("false", lit.value);
            tests.assertTrue(lit.datatype === undefined);
        },

        function test_convertDateToXsdDateTimeLiterals() {

            var lit;

            // xsd:dateTime is the default for Date
            var datatypes = [
                undefined, // the default
                "http://www.w3.org/2001/XMLSchema#dateTime",
                "http://www.w3.org/2001/XMLSchema#string"
            ];

            var date = new Date(1216330344703); // Thu Jul 17 17:32:24.703 EDT 2008 which is Thu Jul 17 21:32:24.703 UTC 2008

            for (var i = 0; i < datatypes.length; i++) {
                var expectedDatatype = datatypes[i] === undefined ? "http://www.w3.org/2001/XMLSchema#dateTime" : datatypes[i];
                log.debug("test_convertDateToXsdDateTimeLiterals - checking " + expectedDatatype);

                lit = anzo.createTypedLiteral(date, expectedDatatype);
                tests.assertEqual("2008-07-17T21:32:24.703Z", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());
            }

            // Now test the createLiteral method
            lit = anzo.createLiteral(date);
            tests.assertEqual("2008-07-17T21:32:24.703Z", lit.value);
            tests.assertTrue(lit.datatype === undefined);
        },

        function test_convertDateToXsdDateLiterals() {
            var lit;
            var expectedDatatype = "http://www.w3.org/2001/XMLSchema#date";
            var date = new Date(1216330344703); // Thu Jul 17 17:32:24.703 EDT 2008 which is Thu Jul 17 21:32:24.703 UTC 2008
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            var expectedDateLexicalValue = anzo.tests.utilities.formatExpectedDateString(date); // This is different depending on local time zone
            tests.assertEqual(expectedDateLexicalValue, lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());
        },

        function test_convertDateToXsdTimeLiterals() {
            var lit;
            var expectedDatatype = "http://www.w3.org/2001/XMLSchema#time";
            var date = new Date(1216330344703); // Thu Jul 17 17:32:24.703 EDT 2008 which is Thu Jul 17 21:32:24.703 UTC 2008
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            var expectedTimeLexicalValue = anzo.tests.utilities.formatExpectedTimeString(date); // This is different depending on local time zone
            tests.assertEqual(expectedTimeLexicalValue, lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());
        },

        function test_convertDateToXsdGYearMonthLiterals() {
            var lit;
            var expectedDatatype = "http://www.w3.org/2001/XMLSchema#gYearMonth";
            var date = new Date(2008, 6, 17, 17, 32, 24, 703);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("2008-07", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            date = new Date(2008, 6, 1, 0, 0, 0);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("2008-07", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            date = new Date(2008, 6, 31, 23, 59, 59);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("2008-07", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());
        },

        function test_convertDateToXsdGYearLiterals() {
            var lit;
            var expectedDatatype = "http://www.w3.org/2001/XMLSchema#gYear";
            var date = new Date(2008, 0, 1, 0, 0, 0);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("2008", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            date = new Date(2008, 11, 31, 23, 59, 59);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("2008", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());
        },

        function test_convertDateToXsdGMonthLiterals() {
            var lit;
            var expectedDatatype = "http://www.w3.org/2001/XMLSchema#gMonth";
            var date = new Date(2008, 06, 1, 0, 0, 0);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("--07", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            date = new Date(2008, 06, 31, 23, 59, 59);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("--07", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());
        },

        function test_convertDateToXsdGDayLiterals() {
            var lit;
            var expectedDatatype = "http://www.w3.org/2001/XMLSchema#gDay";
            var date = new Date(2008, 06, 15, 0, 0, 0);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("---15", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            date = new Date(2008, 06, 15, 23, 59, 59);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("---15", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());
        },

        function test_convertDateToXsdGMonthDayLiterals() {
            var lit;
            var expectedDatatype = "http://www.w3.org/2001/XMLSchema#gMonthDay";
            var date = new Date(2008, 06, 15, 0, 0, 0);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("--07-15", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());

            date = new Date(2008, 06, 15, 23, 59, 59);
            lit = anzo.createTypedLiteral(date, expectedDatatype);
            tests.assertEqual("--07-15", lit.value);
            tests.assertEqual(expectedDatatype, lit.datatype.toString());
        },

        function test_convertUriToXsdAnyUriLiterals() {

            var lit;

            // xsd:anyURI is the default for anzo.rdf.URI
            var datatypes = [
                undefined, // the default,
                "http://www.w3.org/2001/XMLSchema#anyURI",
                "http://www.w3.org/2001/XMLSchema#string"
            ];

            var uri = anzo.createURI("http://example.org/foo");

            for (var i = 0; i < datatypes.length; i++) {
                var expectedDatatype = datatypes[i] === undefined ? "http://www.w3.org/2001/XMLSchema#anyURI" : datatypes[i];
                log.debug("convertUriToXsdAnyUriLiterals - checking " + expectedDatatype);

                lit = anzo.createTypedLiteral(uri, expectedDatatype);
                tests.assertEqual("http://example.org/foo", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());
            }

            lit = anzo.createLiteral(uri);
            tests.assertEqual("http://example.org/foo", lit.value);
            tests.assertTrue(lit.datatype === undefined);
        },

        function test_convertObjectToXsdStringLiterals() {

            var lit;

            // xsd:string is the default for Object
            var datatypes = [
                undefined, // the default
                "http://www.w3.org/2001/XMLSchema#string"
            ];

            function MyObject(x) {
                this.x = x;
            }
            MyObject.prototype.toString = function() {
                return "My insides:" + this.x;
            }

            for (var i = 0; i < datatypes.length; i++) {
                var expectedDatatype = datatypes[i] === undefined ? "http://www.w3.org/2001/XMLSchema#string" : datatypes[i];
                log.debug("convertObjectToXsdStringLiterals - checking " + expectedDatatype);

                lit = anzo.createTypedLiteral(new MyObject("testing"), expectedDatatype);
                tests.assertEqual("My insides:testing", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());

                lit = anzo.createTypedLiteral(new MyObject("testing again"), expectedDatatype);
                tests.assertEqual("My insides:testing again", lit.value);
                tests.assertEqual(expectedDatatype, lit.datatype.toString());
            }

            lit = anzo.createLiteral(new MyObject("testing plain literal"));
            tests.assertEqual("My insides:testing plain literal", lit.value);
            tests.assertTrue(lit.datatype === undefined);
        },

        function test_convertXsdStringToNativeString() {

            var lit;
            var nativeVal;

            lit = anzo.createTypedLiteral("a string", "http://www.w3.org/2001/XMLSchema#string");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof String || "string" == typeof nativeVal);
            tests.assertEqual("a string", nativeVal);

            lit = anzo.createTypedLiteral("165", "http://www.w3.org/2001/XMLSchema#string");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof String || "string" == typeof nativeVal);
            tests.assertEqual("165", nativeVal);
        },

        function test_convertRdfXmlLiteralToNativeString() {

            var lit;
            var nativeVal;

            lit = anzo.createTypedLiteral('<p>Welcome <span class="name">Bob</span></p>', "http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof String || "string" == typeof nativeVal);
            tests.assertEqual('<p>Welcome <span class="name">Bob</span></p>', nativeVal);
        },

        function test_convertXsdAnyUriToNativeString() {
            // Note that xsd:anyURI just uses a JavaScript string as its native value.
            // You might think that its native value should be an anzo.rdf.URI object but no.
            // anzo.rdf.URI is a subclass of anzo.rdf.Resource and an xsd:anyURI literal is not a resource,
            // it's a literal. So we don't want to represent it as an anzo.rdf.URI.

            var lit;
            var nativeVal;

            lit = anzo.createTypedLiteral("http://example.org/test", "http://www.w3.org/2001/XMLSchema#anyURI");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof String || "string" == typeof nativeVal);
            tests.assertEqual("http://example.org/test", nativeVal);
        },

        function test_convertXsdBooleanToNativeBoolean() {

            var lit;
            var nativeVal;

            lit = anzo.createTypedLiteral("true", "http://www.w3.org/2001/XMLSchema#boolean");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Boolean || "boolean" == typeof nativeVal);
            tests.assertTrue(nativeVal == true);

            lit = anzo.createTypedLiteral("1", "http://www.w3.org/2001/XMLSchema#boolean");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Boolean || "boolean" == typeof nativeVal);
            tests.assertTrue(nativeVal == true);

            lit = anzo.createTypedLiteral("false", "http://www.w3.org/2001/XMLSchema#boolean");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Boolean || "boolean" == typeof nativeVal);
            tests.assertTrue(nativeVal == false);

            lit = anzo.createTypedLiteral("0", "http://www.w3.org/2001/XMLSchema#boolean");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Boolean || "boolean" == typeof nativeVal);
            tests.assertTrue(nativeVal == false);

            lit = anzo.createTypedLiteral("verdad", "http://www.w3.org/2001/XMLSchema#boolean");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);
        },

        function test_convertXsdNumericalToNativeNumber() {

            var lit;
            var nativeVal;

            lit = anzo.createTypedLiteral("-1.23", "http://www.w3.org/2001/XMLSchema#decimal");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(-1.23, nativeVal);

            lit = anzo.createTypedLiteral("1", "http://www.w3.org/2001/XMLSchema#decimal");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(1.0, nativeVal);

            lit = anzo.createTypedLiteral("67.0", "http://www.w3.org/2001/XMLSchema#double");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(67.0, nativeVal);

            lit = anzo.createTypedLiteral("INF", "http://www.w3.org/2001/XMLSchema#double");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(Number.POSITIVE_INFINITY, nativeVal);

            lit = anzo.createTypedLiteral("+INF", "http://www.w3.org/2001/XMLSchema#double");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(Number.POSITIVE_INFINITY, nativeVal);

            lit = anzo.createTypedLiteral("-INF", "http://www.w3.org/2001/XMLSchema#double");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(Number.NEGATIVE_INFINITY, nativeVal);

            lit = anzo.createTypedLiteral("NaN", "http://www.w3.org/2001/XMLSchema#double");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertTrue(isNaN(nativeVal));

            lit = anzo.createTypedLiteral("INF", "http://www.w3.org/2001/XMLSchema#float");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(Number.POSITIVE_INFINITY, nativeVal);

            lit = anzo.createTypedLiteral("+INF", "http://www.w3.org/2001/XMLSchema#float");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(Number.POSITIVE_INFINITY, nativeVal);

            lit = anzo.createTypedLiteral("-INF", "http://www.w3.org/2001/XMLSchema#float");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(Number.NEGATIVE_INFINITY, nativeVal);

            lit = anzo.createTypedLiteral("NaN", "http://www.w3.org/2001/XMLSchema#float");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertTrue(isNaN(nativeVal));

            lit = anzo.createTypedLiteral("12.78e-2", "http://www.w3.org/2001/XMLSchema#float");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(0.1278, nativeVal);

            lit = anzo.createTypedLiteral("-1E4", "http://www.w3.org/2001/XMLSchema#float");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
            tests.assertEqual(-10000, nativeVal);

            lit = anzo.createTypedLiteral("three point two", "http://www.w3.org/2001/XMLSchema#float");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);

            var datatypes = [
                "http://www.w3.org/2001/XMLSchema#integer",
                "http://www.w3.org/2001/XMLSchema#int",
                "http://www.w3.org/2001/XMLSchema#negativeInteger",
                "http://www.w3.org/2001/XMLSchema#long",
                "http://www.w3.org/2001/XMLSchema#short",
                "http://www.w3.org/2001/XMLSchema#byte",
                "http://www.w3.org/2001/XMLSchema#nonNegativeInteger",
                "http://www.w3.org/2001/XMLSchema#unsignedLong",
                "http://www.w3.org/2001/XMLSchema#unsignedInt",
                "http://www.w3.org/2001/XMLSchema#unsignedShort",
                "http://www.w3.org/2001/XMLSchema#unsignedByte",
                "http://www.w3.org/2001/XMLSchema#positiveInteger"
            ];

            for (var i = 0; i < datatypes.length; i++) {
                var currentDatatype = datatypes[i];

                lit = anzo.createTypedLiteral("0", currentDatatype);
                nativeVal = lit.getNativeValue();
                tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
                tests.assertEqual(0, nativeVal);

                lit = anzo.createTypedLiteral("66478955", currentDatatype);
                nativeVal = lit.getNativeValue();
                tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
                tests.assertEqual(66478955, nativeVal);

                lit = anzo.createTypedLiteral("-45485", currentDatatype);
                nativeVal = lit.getNativeValue();
                tests.assertTrue(nativeVal instanceof Number || "number" == typeof nativeVal);
                tests.assertEqual(-45485, nativeVal);

                lit = anzo.createTypedLiteral("one hundred and 17", currentDatatype);
                nativeVal = lit.getNativeValue();
                tests.assertTrue(nativeVal == null);
            }

        },

        function test_convertXsdDateTimeToNativeDate() {

            var lit;
            var nativeVal;
            var July2008TimeZoneOffset = (new Date(2008, 06, 17, 21, 32, 24, 703)).getTimezoneOffset() * 60 * 1000; // in milliseconds
            log.debug("July2008TimeZoneOffset in ms:" + July2008TimeZoneOffset);

            // 1216330344703ms from the epoch UTC is Thu Jul 17 17:32:24.703 EDT 2008
            lit = anzo.createTypedLiteral("2008-07-17T17:32:24.703-04:00", "http://www.w3.org/2001/XMLSchema#dateTime");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            tests.assertEqual(1216330344703, nativeVal.getTime());

            // If there is no time zone in the lexical literal, then it is interpreted in the current local time zone as it existed on the particular day.
            // 1216330344703ms from the epoch UTC is Thu Jul 17 21:32:24.703 UTC 2008
            lit = anzo.createTypedLiteral("2008-07-17T21:32:24.703", "http://www.w3.org/2001/XMLSchema#dateTime");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            tests.assertEqual(1216330344703 + July2008TimeZoneOffset, nativeVal.getTime());

            // Bad dateTime literal
            lit = anzo.createTypedLiteral("2008---17T17:32:24.703-04:00", "http://www.w3.org/2001/XMLSchema#dateTime");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);

            // xsd:date
            var July29_2008TimeZoneOffset = (new Date(2008, 06, 29, 0, 0, 0, 0)).getTimezoneOffset() * 60 * 1000; // in milliseconds

            // If there is no time zone in the lexical literal, then it is interpreted in the current local time zone as it existed on the particular day.
            // 1217289600000ms from the epoch UTC is 2008-07-29T00:00:00Z
            lit = anzo.createTypedLiteral("2008-07-29", "http://www.w3.org/2001/XMLSchema#date");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            tests.assertEqual(1217289600000 + July29_2008TimeZoneOffset, nativeVal.getTime());

            // 1217289600000ms from the epoch UTC is 2008-07-29T00:00:00Z
            lit = anzo.createTypedLiteral("2008-07-29Z", "http://www.w3.org/2001/XMLSchema#date");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            tests.assertEqual(1217289600000, nativeVal.getTime());

            // 2008-07-29-04:00 amounts to 2008-07-29T00:00:00-04:00 which is the same as 2008-07-29T04:00:00Z
            // and 1217304000000ms from the epoch UTC is 2008-07-29T04:00:00Z
            lit = anzo.createTypedLiteral("2008-07-29-04:00", "http://www.w3.org/2001/XMLSchema#date");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            tests.assertEqual(1217304000000, nativeVal.getTime());

            // 2008-07-29+04:00 amounts to 2008-07-29T00:00:00+04:00 which is the same as 2008-07-28T20:00:00Z
            // and 1217275200000ms from the epoch UTC is 2008-07-28T20:00:00Z
            lit = anzo.createTypedLiteral("2008-07-29+04:00", "http://www.w3.org/2001/XMLSchema#date");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            tests.assertEqual(1217275200000, nativeVal.getTime());

            // Bad date literal
            lit = anzo.createTypedLiteral("2008--29", "http://www.w3.org/2001/XMLSchema#date");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);

            // xsd:time
            var Jan1970TimeZoneOffset = (new Date(1970, 0, 1, 13, 44, 23)).getTimezoneOffset() * 60 * 1000; // in milliseconds

            // 49463000ms is 1970-01-01T13:44:23Z
            lit = anzo.createTypedLiteral("13:44:23Z", "http://www.w3.org/2001/XMLSchema#time");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            tests.assertEqual(49463000, nativeVal.getTime());

            // If there is no time zone in the lexical literal, then it will be interpreted in the local time zone in 1970-01-01
            // 49463000ms is 1970-01-01T13:44:23Z
            lit = anzo.createTypedLiteral("13:44:23", "http://www.w3.org/2001/XMLSchema#time");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            tests.assertEqual(49463000 + Jan1970TimeZoneOffset, nativeVal.getTime());

            // Bad date literal
            lit = anzo.createTypedLiteral("13::23", "http://www.w3.org/2001/XMLSchema#time");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);

        },
        
        function test_convertNativeValueReturnsNullForInvalidLiterals() {
            // summary: If a literal can't be converted into a native value, getNativeValue should return null.

            var datatypes = [
                             "http://www.w3.org/2001/XMLSchema#integer",
                             "http://www.w3.org/2001/XMLSchema#int",
                             "http://www.w3.org/2001/XMLSchema#negativeInteger",
                             "http://www.w3.org/2001/XMLSchema#long",
                             "http://www.w3.org/2001/XMLSchema#short",
                             "http://www.w3.org/2001/XMLSchema#byte",
                             "http://www.w3.org/2001/XMLSchema#nonNegativeInteger",
                             "http://www.w3.org/2001/XMLSchema#unsignedLong",
                             "http://www.w3.org/2001/XMLSchema#unsignedInt",
                             "http://www.w3.org/2001/XMLSchema#unsignedShort",
                             "http://www.w3.org/2001/XMLSchema#unsignedByte",
                             "http://www.w3.org/2001/XMLSchema#positiveInteger",
                             "http://www.w3.org/2001/XMLSchema#dateTime",
                             "http://www.w3.org/2001/XMLSchema#date",
                             "http://www.w3.org/2001/XMLSchema#float",
                             "http://www.w3.org/2001/XMLSchema#double",
                             "http://www.w3.org/2001/XMLSchema#decimal",
                             "http://www.w3.org/2001/XMLSchema#boolean"
             ];

             var invalidLiteralValue = "x873z"; // A value which is not a valid lexical form for any of the datatypes in the datatypes array above.
             for (var i = 0; i < datatypes.length; i++) {
                 var currentDatatype = datatypes[i];

                 lit = anzo.createTypedLiteral(invalidLiteralValue, currentDatatype);
                 nativeVal = lit.getNativeValue();
                 log.debug("Testing invalid literal returns null for getNativeValue - '" + invalidLiteralValue + "'^^<" + currentDatatype + ">");
                 tests.assertTrue(nativeVal == null);
             }
             
             // These types are basically always valid...they just return the literal string as the native value and don't
             // do very much parsing at all so will likely never return null. But we want to make sure that they
             // don't throw an exception in case of invalid input so we test that here.
             var stringTypes = [ "http://www.w3.org/2001/XMLSchema#string",
                                 "http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral",
                                 "http://www.w3.org/2001/XMLSchema#anyURI"
             ];
             
             var invalidLiteralValue = "not a valid XMLLiteral or anyURI";
             for (var i = 0; i < stringTypes.length; i++) {
                 var currentDatatype = stringTypes[i];

                 lit = anzo.createTypedLiteral(invalidLiteralValue, currentDatatype);
                 nativeVal = lit.getNativeValue();
                 log.debug("Testing invalid literal does not throw exception getNativeValue - '" + invalidLiteralValue + "'^^<" + currentDatatype + ">");
                 tests.assertTrue(nativeVal == invalidLiteralValue);
             }

        },
        
        function test_convertXsdGYearMonthToNativeDate() {
            // xsd:date
            var July1_2008TimeZoneOffset = (new Date(2008, 06, 1, 0, 0, 0, 0)).getTimezoneOffset() * 60 * 1000; // in milliseconds

            // If there is no time zone in the lexical literal, then it is interpreted in the current local time zone
            // as it existed on the particular day.
            // 1214870400000ms from the epoch UTC is 2008-07-01T00:00:00Z
            var timeStr = "2008-07";
            var lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gYearMonth");
            var nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(1214870400000 + July1_2008TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking year of native value for " + timeStr);
            tests.assertEqual(2008, nativeVal.getFullYear());
            log.debug("Checking month of native value for " + timeStr);
            tests.assertEqual(06, nativeVal.getMonth());

            // The time zone should be ignored. 
            // 1214870400000ms from the epoch UTC is 2008-07-01T00:00:00Z
            timeStr = "2008-07+10:00";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gYearMonth");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(1214870400000 + July1_2008TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking year of native value for " + timeStr);
            tests.assertEqual(2008, nativeVal.getFullYear());
            log.debug("Checking month of native value for " + timeStr);
            tests.assertEqual(06, nativeVal.getMonth());
        },

        function test_convertXsdGMonthDayToNativeDate() {
            // xsd:date
            var July29_1970TimeZoneOffset = (new Date(1970, 06, 29, 0, 0, 0, 0)).getTimezoneOffset() * 60 * 1000; // in milliseconds

            // If there is no time zone in the lexical literal, then it is interpreted in the current local time zone
            // as it existed on the particular day.
            // 18057600000ms from the epoch UTC is 1970-07-29T00:00:00Z
            var timeStr = "--07-29";
            var lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gMonthDay");
            var nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(18057600000 + July29_1970TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking month of native value for " + timeStr);
            tests.assertEqual(06, nativeVal.getMonth());
            log.debug("Checking day of native value for " + timeStr);
            tests.assertEqual(29, nativeVal.getDate());

            // The time zone should be ignored. 
            // 18057600000ms from the epoch UTC is 1970-07-29T00:00:00Z
            timeStr = "--07-29+10:00";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gMonthDay");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(18057600000 + July29_1970TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking month of native value for " + timeStr);
            tests.assertEqual(06, nativeVal.getMonth());
            log.debug("Checking date of native value for " + timeStr);
            tests.assertEqual(29, nativeVal.getDate());

            // Invalid month day format. Missing leading "--".
            timeStr = "07-29";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gMonthDay");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);
        },
        
        function test_convertXsdGMonthToNativeDate() {
            // xsd:date
            var July1_1970TimeZoneOffset = (new Date(1970, 06, 1, 0, 0, 0, 0)).getTimezoneOffset() * 60 * 1000; // in milliseconds

            // If there is no time zone in the lexical literal, then it is interpreted in the current local time zone
            // as it existed on the particular day.
            // 15638400000ms from the epoch UTC is 1970-07-01T00:00:00Z
            var timeStr = "--07";
            var lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gMonth");
            var nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(15638400000 + July1_1970TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking month of native value for " + timeStr);
            tests.assertEqual(06, nativeVal.getMonth());

            // The time zone should be ignored. 
            // 15638400000ms from the epoch UTC is 1970-07-01T00:00:00Z
            timeStr = "--07+10:00";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gMonth");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(15638400000 + July1_1970TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking month of native value for " + timeStr);
            tests.assertEqual(06, nativeVal.getMonth());

            // Invalid gMonth format. Missing leading "--".
            timeStr = "07";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gMonth");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);

            // Invalid gMonth format. Missing leading "--".
            timeStr = "-07";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gMonth");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);
        },

        function test_convertXsdGDayToNativeDate() {
            // xsd:date
            var Jan29_1970TimeZoneOffset = (new Date(1970, 0, 29, 0, 0, 0, 0)).getTimezoneOffset() * 60 * 1000; // in milliseconds

            // If there is no time zone in the lexical literal, then it is interpreted in the current local time zone
            // as it existed on the particular day.
            // 2419200000ms from the epoch UTC is 1970-01-29T00:00:00Z
            var timeStr = "---29";
            var lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gDay");
            var nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(2419200000 + Jan29_1970TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking day of native value for " + timeStr);
            tests.assertEqual(29, nativeVal.getDate());

            // The time zone should be ignored. 
            // 2419200000ms from the epoch UTC is 1970-01-29T00:00:00Z
            timeStr = "---29+10:00";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gDay");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(2419200000 + Jan29_1970TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking day of native value for " + timeStr);
            tests.assertEqual(29, nativeVal.getDate());

            // Invalid gDay format. Missing leading "---".
            timeStr = "29";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gDay");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);

            // Invalid gDay format. Missing leading "---".
            timeStr = "-29";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gDay");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);
        },
        
        function test_convertXsdGYearToNativeDate() {
            // xsd:date
            var Jan29_2010TimeZoneOffset = (new Date(2010, 0, 1, 0, 0, 0, 0)).getTimezoneOffset() * 60 * 1000; // in milliseconds

            // If there is no time zone in the lexical literal, then it is interpreted in the current local time zone
            // as it existed on the particular day.
            // 1262304000000ms from the epoch UTC is 2010-01-01T00:00:00Z
            var timeStr = "2010";
            var lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gYear");
            var nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(1262304000000 + Jan29_2010TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking year of native value for " + timeStr);
            tests.assertEqual(2010, nativeVal.getFullYear());

            // The time zone should be ignored. 
            // 1262304000000ms from the epoch UTC is 2010-01-01T00:00:00Z
            timeStr = "2010+10:00";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gYear");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal instanceof Date);
            log.debug("Checking time from epoch of native value for " + timeStr);
            tests.assertEqual(1262304000000 + Jan29_2010TimeZoneOffset, nativeVal.getTime());
            log.debug("Checking year of native value for " + timeStr);
            tests.assertEqual(2010, nativeVal.getFullYear());

            // Invalid gYear format.
            timeStr = "2010--";
            lit = anzo.createTypedLiteral(timeStr, "http://www.w3.org/2001/XMLSchema#gYear");
            nativeVal = lit.getNativeValue();
            tests.assertTrue(nativeVal == null);
        }
    ]
);

})();
