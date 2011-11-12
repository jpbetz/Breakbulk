/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

/*
 * Tests for the anzo.tests.utilities methods.
 * So...Tests for the test helpers.
 * 
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.tests.utils.utilitiesTest");

dojo.require("anzo.tests.utilities");

tests.register("anzo.tests.utils.utilitiesTest", 
	[
		function testDeepCompareMatchesIdenticalArrays() {
		    var o1 = [ 1, "str", { foo: "bar", two: [2, "two"] }, [1, 4.7, { one: { another: undefined, empty: null } } ] ];
		    var o2 = [ 1, "str", { foo: "bar", two: [2, "two"] }, [1, 4.7, { one: { another: undefined, empty: null } } ] ];
            tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(o1, o2));
		},

		function testDeepCompareMatchesIdenticalObjects() {
		    var o1 = { "top-prop" : [ 1, "str", { foo: "bar", two: [2, "two"] }, [1, 4, { one: { another: "inside" } } ] ] };
		    var o2 = { "top-prop" : [ 1, "str", { foo: "bar", two: [2, "two"] }, [1, 4, { one: { another: "inside" } } ] ] };
            tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(o1, o2));
		},

		function testDeepCompareNoticesArraysOfDifferentLength() {
		    var o1 = [ 1, "str", { foo: "bar", two: [2, "two"] }, [1, 4, { one: { another: "inside" } } ], "extra" ];
		    var o2 = [ 1, "str", { foo: "bar", two: [2, "two"] }, [1, 4, { one: { another: "inside" } } ] ];
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o1, o2));

		    o1 = [ 1, "str", { foo: "bar", two: [2, "two", "three"] }, [1, 4, { one: { another: "inside" } } ] ];
		    o2 = [ 1, "str", { foo: "bar", two: [2, "two"] }, [1, 4, { one: { another: "inside" } } ] ];
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o1, o2));
		},

		function testDeepCompareNoticesArrayIsDifferentThanObject() {
		    var o1 = [ 1, 2 ];
		    var o2 = { one : 1, two : 2 };
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o1, o2));
		},

		function testDeepCompareNoticesArraysWithDifferentContent() {
		    var o1 = [ 1, "str", { foo: "bar", two: [2, "two"] } ];
		    var o2 = [ 1, "different", { foo: "bar", two: [2, "two"] } ];
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o1, o2));
		},

		function testDeepCompareNoticesObjectsWithDifferentContent() {
		    var o1 = { "top-prop" : 1 };
		    var o2 = { "top-prop" : [ 1 ] };
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o1, o2));
		},

		function testDeepCompareNoticesMatchesInnerArrays() {
		    var o1 = [{"type": "Transaction", "id": "35", "timestamp": "1198007591343"}, {"type": "Command", "id": "0"}, {"type": "CommandEnd"}, {"type": "TransactionEnd"}, {"type": "Transaction", "id": "36", "timestamp": "1198007591359"}, {"type": "Command", "id": "0"}, {"type": "Statement", "method": "Addition", "namedGraphUri": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "subject": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "predicate": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "object": {"objectType": "uri", "value": "http://xmlns.com/foaf/0.1/Person"}}, {"type": "Statement", "method": "Addition", "namedGraphUri": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "subject": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "predicate": "http://xmlns.com/foaf/0.1/name", "object": {"objectType": "literal", "value": "Ben", "dataType": "http://www.w3.org/2001/XMLSchema#string"}}, {"type": "CommandEnd"}, {"type": "TransactionEnd"}, {"type": "Transaction", "id": "37", "timestamp": "1198007591359"}, {"type": "AnzoException", "errorTags": "34", "errorCode": "524307", "ErrorMessageArg": ["ASK { <http://openanzo.org/namedGraphs/defaultNamedGraph/500> <http://purl.org/dc/elements/1.1/title> \"My title\">}"]}, {"type": "TransactionEnd"}];
            var o2 = [{"type": "Transaction", "id": "27", "timestamp": "1198006936031"}, {"type": "Command", "id": "0"}, {"type": "CommandEnd"}, {"type": "TransactionEnd"}, {"type": "Transaction", "id": "28", "timestamp": "1198006936046"}, {"type": "Command", "id": "0"}, {"type": "Statement", "method": "Addition", "namedGraphUri": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "subject": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "predicate": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "object": {"objectType": "uri", "value": "http://xmlns.com/foaf/0.1/Person"}}, {"type": "Statement", "method": "Addition", "namedGraphUri": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "subject": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "predicate": "http://xmlns.com/foaf/0.1/name", "object": {"objectType": "literal", "value": "Ben", "dataType": "http://www.w3.org/2001/XMLSchema#string"}}, {"type": "CommandEnd"}, {"type": "TransactionEnd"}, {"type": "Transaction", "id": "29", "timestamp": "1198006936046"}, {"type": "AnzoException", "errorTags": "34", "errorCode": "524307", "ErrorMessageArg": ["ASK { <http://openanzo.org/namedGraphs/defaultNamedGraph/500> <http://purl.org/dc/elements/1.1/title> \"My title\">}"]}, {"type": "TransactionEnd"}];
            tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(o1, o2, [ "timestamp", "id" ]));
		},

		function testDeepCompareNoticesObjectsWithDifferentExtraProperties() {
		    var o1 = { "top-prop" : 1, extra : 2 };
		    var o2 = { "top-prop" : 1 };
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o1, o2));
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o2, o1)); // Flip it around just in case.
		},
          
		function testDeepCompareIgnoresProperties() {
		    var o1 = { "top-prop" : 1, extra : function() { return 1; } };
		    var o2 = { "top-prop" : 1, "ignore-me" : o2 };
		    var ignoredProperties = [ "ignore-me", "extra", "don't look at me" ];
            tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(o1, o2, ignoredProperties));
            tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(o2, o1, ignoredProperties)); // Flip it around just in case.
		},

		function testDeepCompareObservesArrayOrderForObjects() {
		    var o1 = [ { foo : "bar", deep : { deepProp : "uri" } }, { foo : "bar" } ]; 
		    var o2 = [ { foo : "bar" }, { foo : "bar", deep : { deepProp : "uri" } } ];
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o1, o2));
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o2, o1)); // Flip it around just in case.
		},

		function testDeepCompareIgnoresArrayOrderForAppropriateProperties() {
		    var o1 = { unordered : [ 1, 2, 3 ], ordered : [ 7, 8, { unordered: [ 4, 5, 6] } ] };
		    var o2 = { unordered : [ 3, 1, 2 ], ordered : [ 7, 8, { unordered: [ 6, 5, 4] } ] };
		    var unorderedProperties = [ "unordered" ];
            tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(o1, o2, [], unorderedProperties));
            tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(o2, o1, [], unorderedProperties)); // Flip it around just in case.

            // Test that ordered arrays within unordered ones are still compared with ordering.
		    o1 = { unordered : [ 1, 2, { ordered : [ 3, 4, 5] } ] };
		    o2 = { unordered : [ 2, 1, { ordered : [ 4, 3, 5] } ] };
		    unorderedProperties = [ "unordered" ];
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o1, o2, [], unorderedProperties));
            tests.assertFalse(anzo.tests.utilities.deepCompareJSONObjects(o2, o1, [], unorderedProperties)); // Flip it around just in case.
		},

		function testDeepCompareThrowsExceptionForFunctions() {
		    var exceptionRaised = false;
		    var o1 = [ 1, function() { return 2; } ];
		    var o2 = [ 1, function() { return 2; } ];
		    try {
		        anzo.tests.utilities.deepCompareJSONObjects(o1, o2);
		    } catch (e) {
		        exceptionRaised = true;
		    }
		    tests.assertTrue(exceptionRaised);

		    exceptionRaised = false;
		    o1 = { one: 1, two : function() { return 2; } };
		    o2 = { one: 1, two : function() { return 2; } };
		    try {
		        anzo.tests.utilities.deepCompareJSONObjects(o1, o2);
		    } catch (e) {
		        exceptionRaised = true;
		    }
		    tests.assertTrue(exceptionRaised);
        },
        
        function testEscapeXml() {
            var str = "Testing < > ' \" 123. <a href='http://example.com\">\"whatever && something</a>";
            var expected = "Testing &lt; &gt; &apos; &quot; 123. &lt;a href=&apos;http://example.com&quot;&gt;&quot;whatever &amp;&amp; something&lt;/a&gt;";
            tests.assertTrue(anzo.tests.utilities.escapeXML(str) == expected);            
        },
        
        function testLoadTextFile() {
            var expected = "Hello. This is a Test\r\nText File That *doesn't* end in a newline!";
            var loaded = anzo.tests.utilities.loadTextFile("../../anzo/tests/utils/loadTextFileTestData.txt");
            tests.assertEqual(loaded, expected);
        },
        
        function testLoadTextFileThrowsExceptionForMissingFiles() {
            var exception = null;
            try {
                anzo.tests.utilities.loadTextFile("../../anzo/tests/utils/FileThatDoesNotExist.txt");
            } catch (e) {
                exception = e;
            }
            tests.assertTrue(exception != null);
        }
        
    ]   
);
