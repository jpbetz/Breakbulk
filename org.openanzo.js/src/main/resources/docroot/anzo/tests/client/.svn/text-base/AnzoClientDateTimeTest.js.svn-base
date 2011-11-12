/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

/*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.AnzoClientDateTimeTest");

dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.log");

(function() {
var log = anzo.log.getLogger("anzo.tests.client.AnzoClientDateTimeTest");

tests.register("anzo.tests.client.AnzoClientDateTimeTest", 
    [
        {
            name: "test_lexicalDateValuesArePreserved",
            timeout: 120000,
            setUp: function() {
            },
            runTest: function test_lexicalDateValuesArePreserved() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                var lexicalTypedDateLiterals = [
                    // xsd:dateTime
                    // UTC
                    anzo.createTypedLiteral("2008-07-11T16:48:32Z", "http://www.w3.org/2001/XMLSchema#dateTime"),
                    // With time zone offset
                    anzo.createTypedLiteral("2008-07-12T16:48:32-04:00", "http://www.w3.org/2001/XMLSchema#dateTime"),
                    // Without time zone
                    anzo.createTypedLiteral("2008-07-13T16:48:32", "http://www.w3.org/2001/XMLSchema#dateTime"),
                    // With fractional seconds
                    anzo.createTypedLiteral("2008-07-15T16:48:32.25", "http://www.w3.org/2001/XMLSchema#dateTime"),
                    // With fractional seconds at the nanosecond precision
                    anzo.createTypedLiteral("2008-07-15T16:48:32.254221458", "http://www.w3.org/2001/XMLSchema#dateTime"),
                    // With fractional seconds and time zone
                    anzo.createTypedLiteral("2008-07-16T16:48:32.25-05:00", "http://www.w3.org/2001/XMLSchema#dateTime"),
        
                    // xsd:date
                    // UTC
                    anzo.createTypedLiteral("2008-07-11Z", "http://www.w3.org/2001/XMLSchema#date"),
                    // With time zone offset
                    anzo.createTypedLiteral("2008-07-12-04:00", "http://www.w3.org/2001/XMLSchema#date"),
                    // Without time zone
                    anzo.createTypedLiteral("2008-07-13", "http://www.w3.org/2001/XMLSchema#date"),
        
                    // xsd:time
                    // UTC
                    anzo.createTypedLiteral("16:48:32Z", "http://www.w3.org/2001/XMLSchema#time"),
                    // With time zone offset
                    anzo.createTypedLiteral("17:48:32-04:00", "http://www.w3.org/2001/XMLSchema#time"),
                    // Without time zone
                    anzo.createTypedLiteral("18:48:32", "http://www.w3.org/2001/XMLSchema#time"),
                    // With fractional seconds
                    anzo.createTypedLiteral("19:48:32.25", "http://www.w3.org/2001/XMLSchema#time"),
                    // With fractional seconds and time zone
                    anzo.createTypedLiteral("20:48:32.25-05:00", "http://www.w3.org/2001/XMLSchema#time"),
        
                    // xsd:gYearMonth
                    // UTC
                    anzo.createTypedLiteral("2008-06Z", "http://www.w3.org/2001/XMLSchema#gYearMonth"),
                    // With time zone offset
                    anzo.createTypedLiteral("2008-07-04:00", "http://www.w3.org/2001/XMLSchema#gYearMonth"),
                    // Without time zone
                    anzo.createTypedLiteral("2008-08", "http://www.w3.org/2001/XMLSchema#gYearMonth"),
        
                    // xsd:gYear
                    // UTC
                    anzo.createTypedLiteral("2008", "http://www.w3.org/2001/XMLSchema#gYear"),
                    // With time zone offset
                    anzo.createTypedLiteral("2009-06:00", "http://www.w3.org/2001/XMLSchema#gYear"),
                    // Without time zone
                    anzo.createTypedLiteral("2010", "http://www.w3.org/2001/XMLSchema#gYear"),
        
                    // xsd:gMonthDay
                    // UTC
                    anzo.createTypedLiteral("--07-14Z", "http://www.w3.org/2001/XMLSchema#gMonthDay"),
                    // With time zone offset
                    anzo.createTypedLiteral("--07-15-06:00", "http://www.w3.org/2001/XMLSchema#gMonthDay"),
                    // Without time zone
                    anzo.createTypedLiteral("--07-16", "http://www.w3.org/2001/XMLSchema#gMonthDay"),
        
                    // xsd:gMonth
                    // UTC
                    anzo.createTypedLiteral("--07Z", "http://www.w3.org/2001/XMLSchema#gMonth"),
                    // With time zone offset
                    anzo.createTypedLiteral("--08-06:00", "http://www.w3.org/2001/XMLSchema#gMonth"),
                    // Without time zone
                    anzo.createTypedLiteral("--09", "http://www.w3.org/2001/XMLSchema#gMonth"),
        
                    // xsd:gDay
                    // UTC
                    anzo.createTypedLiteral("---14Z", "http://www.w3.org/2001/XMLSchema#gDay"),
                    // With time zone offset
                    anzo.createTypedLiteral("---15-06:00", "http://www.w3.org/2001/XMLSchema#gDay"),
                    // Without time zone
                    anzo.createTypedLiteral("---16", "http://www.w3.org/2001/XMLSchema#gDay")
                ];
                
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            tests.assertTrue(graph);
                            
                            log.debug("Adding literals and verifying contains in local store.")
                            try { 
                                for (var i = 0; i < lexicalTypedDateLiterals.length; i++) {
                                    var subj = "http://example.org/subj" + i;
                                    var pred = "http://example.org/pred" + i;
                                    var literal = lexicalTypedDateLiterals[i];
                                    graph.add(subj, pred, literal);
                                    tests.assertTrue(graph.contains(subj, pred, literal));
                                }
                            } catch (e) {
                                log.debug("Failure adding or checking date literal:" + lexicalTypedDateLiterals[i]);
                                throw e;
                            }

                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("updateRepositoryComplete")
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                log.debug("Verify literals in local store after updateRepository.")
                                try { 
                                    for (var i = 0; i < lexicalTypedDateLiterals.length; i++) {
                                        var subj = "http://example.org/subj" + i;
                                        var pred = "http://example.org/pred" + i;
                                        var literal = lexicalTypedDateLiterals[i];
                                        tests.assertTrue(graph.contains(subj, pred, literal));
                                        var stmts = anzoClient.replicaFind(subj, pred, literal);
                                        tests.assertTrue(stmts.length == 1);
                                        tests.assertEqual(subj, stmts[0].subject.toString());
                                        tests.assertEqual(pred, stmts[0].predicate.toString());
                                        tests.assertEqual(literal.value, stmts[0].object.value);
                                        tests.assertEqual(literal.datatype.toString(), stmts[0].object.datatype.toString());
                                    }
                                } catch (e) {
                                    log.debug("Failure checking date literal:" + lexicalTypedDateLiterals[i]);
                                    throw e;
                                }
                                
                                log.debug("Verify literals via serverFind");
                                var verifyLiteralsViaServerFind = d.getTestErrorWrapper(function(i) {
                                    var subj = "http://example.org/subj" + i;
                                    var pred = "http://example.org/pred" + i;
                                    var literal = lexicalTypedDateLiterals[i];
                                    log.debug("Verifying literal via serverFind: " + literal);
                                    var stmts = anzoClient.serverFind(subj, pred, literal, null, d.getTestErrorWrapper(function serverFindCallback(stmts, success, errors) {
                                        log.debug("serverFind callback for " + literal + " success:" + success);
                                        tests.assertTrue(success);
                                        tests.assertTrue(stmts.length == 1);
                                        tests.assertEqual(subj, stmts[0].subject.toString());
                                        tests.assertEqual(pred, stmts[0].predicate.toString());
                                        tests.assertEqual(literal.value, stmts[0].object.value);
                                        tests.assertEqual(literal.datatype.toString(), stmts[0].object.datatype.toString());
                                        
                                        if (i  + 1 < lexicalTypedDateLiterals.length) {
                                            verifyLiteralsViaServerFind(i + 1);
                                        } else {
                                            anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                d.callback(true);
                                            }));
                                        }
                                    }));
                                });
                                verifyLiteralsViaServerFind(0);
                                
                            }));                            
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
            name: "test_nativeDateValues",
            timeout: 120000,
            setUp: function() {
            },
            runTest: function test_nativeDateValues() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                var date = new Date(1216330344703); // Thu Jul 17 17:32:24.703 EDT 2008 which is Thu Jul 17 21:32:24.703 UTC 2008
                var expectedTimeLexicalValue = anzo.tests.utilities.formatExpectedTimeString(date); // This is different depending on local time zone
                var expectedDateLexicalValue = anzo.tests.utilities.formatExpectedDateString(date); // This is different depending on local time zone
                var literals = [
                    // Date to xsd:dateTime - using default
                    { literal : anzo.createTypedLiteral(date), expectedLexicalValue : "2008-07-17T21:32:24.703Z" },
                    // Date to xsd:dateTime
                    { literal : anzo.createTypedLiteral(date, "http://www.w3.org/2001/XMLSchema#dateTime"), expectedLexicalValue : "2008-07-17T21:32:24.703Z" },
                    // Date to xsd:time
                    { literal : anzo.createTypedLiteral(date, "http://www.w3.org/2001/XMLSchema#time"), expectedLexicalValue : expectedTimeLexicalValue },
                    // Date to xsd:date
                    { literal : anzo.createTypedLiteral(date, "http://www.w3.org/2001/XMLSchema#date"), expectedLexicalValue : expectedDateLexicalValue },
                ];
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            tests.assertTrue(graph);
                            
                            log.debug("Adding native literals and verifying contains in local store.")
                            try { 
                                for (var i = 0; i < literals.length; i++) {
                                    var subj = "http://example.org/subj" + i;
                                    var pred = "http://example.org/pred" + i;
                                    var literal = literals[i].literal;
                                    graph.add(subj, pred, literal);
                                    var lexicalLiteral = anzo.createTypedLiteral(literals[i].expectedLexicalValue, literal.datatype);
                                    tests.assertTrue(graph.contains(subj, pred, lexicalLiteral));
                                }
                            } catch (e) {
                                log.debug("Failure adding or checking date literal:" + literals[i].literal);
                                throw e;
                            }

                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("updateRepositoryComplete")
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                log.debug("Verify native literals in local store after updateRepository.")
                                try { 
                                    for (var i = 0; i < literals.length; i++) {
                                        var subj = "http://example.org/subj" + i;
                                        var pred = "http://example.org/pred" + i;
                                        var literal = literals[i].literal;
                                        var lexicalLiteral = anzo.createTypedLiteral(literals[i].expectedLexicalValue, literal.datatype);
                                        tests.assertTrue(graph.contains(subj, pred, lexicalLiteral));
                                        var stmts = anzoClient.replicaFind(subj, pred, lexicalLiteral);
                                        tests.assertTrue(stmts.length == 1);
                                        tests.assertEqual(subj, stmts[0].subject.toString());
                                        tests.assertEqual(pred, stmts[0].predicate.toString());
                                        tests.assertEqual(literals[i].expectedLexicalValue, stmts[0].object.value);
                                        tests.assertEqual(literal.datatype.toString(), stmts[0].object.datatype.toString());
                                    }
                                } catch (e) {
                                    log.debug("Failure checking date literal:" + literals[i].literal);
                                    throw e;
                                }
                                
                                log.debug("Verify literals via serverFind");
                                var verifyLiteralsViaServerFind = d.getTestErrorWrapper(function(i) {
                                    var subj = "http://example.org/subj" + i;
                                    var pred = "http://example.org/pred" + i;
                                    var literal = literals[i].literal;
                                    log.debug("Verifying literal via serverFind: " + literal);
                                    var lexicalLiteral = anzo.createTypedLiteral(literals[i].expectedLexicalValue, literal.datatype);
                                    var stmts = anzoClient.serverFind(subj, pred, lexicalLiteral, null, d.getTestErrorWrapper(function serverFindCallback(stmts, success, errors) {
                                        log.debug("serverFind callback for " + literal + " success:" + success);
                                        tests.assertTrue(success);
                                        tests.assertTrue(stmts.length == 1);
                                        tests.assertEqual(subj, stmts[0].subject.toString());
                                        tests.assertEqual(pred, stmts[0].predicate.toString());
                                        tests.assertEqual(literals[i].expectedLexicalValue, stmts[0].object.value);
                                        tests.assertEqual(literal.datatype.toString(), stmts[0].object.datatype.toString());
                                        
                                        if (i  + 1 < literals.length) {
                                            verifyLiteralsViaServerFind(i + 1);
                                        } else {
                                            anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                d.callback(true);
                                            }));
                                        }
                                    }));
                                });
                                verifyLiteralsViaServerFind(0);
                                
                            }));                            
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        }
    ]
);

})();
