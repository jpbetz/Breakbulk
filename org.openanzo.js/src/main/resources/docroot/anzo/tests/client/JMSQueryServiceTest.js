/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.JMSQueryServiceTest");

dojo.require("anzo.client.JMSQueryService");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.log");
dojo.require("anzo.tests.client.TestData");

(function(){
var log = anzo.log.getLogger("anzo.tests.client.JMSQueryServiceTest");

tests.register("anzo.tests.client.JMSQueryServiceTest", [
    {
        name: "test_arrayLengthEquals",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function _arrayLengthEquals() {
            var q = new anzo.client.JMSQueryService();
            tests.assertTrue(q._arrayLengthEquals([],[]));
            tests.assertTrue(q._arrayLengthEquals([ "one" ], [ "uno" ]));
            tests.assertTrue(q._arrayLengthEquals([ "one", 2 ], [ "uno", 2 ]));
            tests.assertTrue(q._arrayLengthEquals(null, null));
            tests.assertTrue(q._arrayLengthEquals(undefined, undefined));
            tests.assertTrue(q._arrayLengthEquals(undefined, []));
            tests.assertTrue(q._arrayLengthEquals([], undefined));
            tests.assertTrue(q._arrayLengthEquals([], null));

            tests.assertFalse(q._arrayLengthEquals(undefined, [ "one" ]));
            tests.assertFalse(q._arrayLengthEquals(null, [ "one" ]));
            tests.assertFalse(q._arrayLengthEquals([ "one" ], undefined));
            tests.assertFalse(q._arrayLengthEquals([ "one" ], null));
            tests.assertFalse(q._arrayLengthEquals([ "one" ], [ "one", "two" ]));
            tests.assertFalse(q._arrayLengthEquals([ "one", "two" ], [ "one" ]));
        }
    },
    
    function testDefaultCacheSize() {
        // summary: simple test to ensure the appropriate cache size is set based on having it specified in the constructor.

        // Don't pass a cacheSize and check that the expected cacheSize is set
        var service = new anzo.client.JMSQueryService({}); // an empty object is enough to fake a RealTimeUpdateManager for the constructor.
        tests.assertEqual(100, service._resultsCache.capacity());
        
        // Pass a cacheSize and check is set
        service = new anzo.client.JMSQueryService({}, 200);
        tests.assertEqual(200, service._resultsCache.capacity()); 
    },
    
    function testExplicitCacheSize() {
        // summary: simple test to ensure the appropriate cache size is set when explicitly specifies in the constructor.

        var service = new anzo.client.JMSQueryService({}, 50); // an empty object is enough to fake a RealTimeUpdateManager for the constructor.
        tests.assertEqual(50, service._resultsCache.capacity());
        
        service = new anzo.client.JMSQueryService({}, -1); // an empty object is enough to fake a RealTimeUpdateManager for the constructor.
        tests.assertEqual(-1, service._resultsCache.capacity());
    },
    
    function testQueryDatasetParsing() {
        // summary: Test that the parser for detecting dataset clauses in queries works properly.
        
        var service = new anzo.client.JMSQueryService({}); // an empty object is enough to fake a RealTimeUpdateManager for the constructor.

        var queries = [
            { e: true, q: "BASE <http://example.org/foo#bar> PREFIX ex: <http://example.org/baz/> SELECT * FROM foo:bar {}" },
            { e: true, q: "SELECT * FROM # comment\n<http://example.org/foo> WHERE {}" },
            { e: true, q: "DESCRIBE <http://example.com>FROM <http://example.com/graph>" },
            { e: true, q: "SELECT * FROM DATASET <http://example.com/graph> {}" },
            { e: true, q: "SELECT * FROM NAMED <http://example.com/graph> {}" },
            { e: true, q: "SELECT * FroM NAMED <http://example.com/graph> {}" },
            { e: true, q: "SELECT * from NAMED <http://example.com/graph> {}" },
            { e: true, q: "SELECT*FROM<http://example.com/graph> {}" },
            { e: true, q: "SELECT *\nFROM\n<http://example.com/graph> {}" },
            { e: true, q: "SELECT *\nFROM# a comment right after the clause keyword\n<http://example.com/graph> {}" },
            { e: true, q: "SELECT # FROM COMMENT\nWHERE {}" }, // Overly conservative but it's trade-off. It would be nice if this weren't detected as having a dataset clause 
            { e: true, q: "SELECT * { <http://example.com/ab*FROM#> a <http://example.com/type> }" }, // Overly conservative but it's trade-off. It would be nice if this weren't detected as having a dataset clause
            { e: false, q: "SELECT * { <http://example.com/ab*FROM> a <http://example.com/type> }" },
            { e: false, q: "CONSTRUCT { foo:from a bar:from } WHERE {}" },
            { e: false, q: "SELECT * # FROMAGE\nWHERE {}" }, 
            { e: false, q: "SELECT ?defrombulator WHERE {}" }, 
            { e: false, q: "SELECT ?from WHERE {}" } 
        ];

        for (var i = 0; i < queries.length; i++) {
            var query = queries[i].q;
            //log.debug("About to check query:" + query);
            var result = service._containsQueryDatasetClause(query);
            var correct = queries[i].e == result;
            //log.debug("correct: " + correct + " (result:" + result + ")");
            tests.assertTrue(correct);
        }
    }
]);

})();
