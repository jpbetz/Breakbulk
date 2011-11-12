/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.AnzoClientTest");

dojo.require("anzo.tests.messaging.JMSClientRecorder");
dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.log");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.rdf.vocabulary.RDF");

(function() {
var log = anzo.log.getLogger("anzo.tests.client.AnzoClientTest");

tests.register("anzo.tests.client.AnzoClientTest", 
    [
    	{
            name: "test_GetReplicaGraphTwice",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_GetReplicaGraphTwice() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        
                        var count = 0;
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            count++;
                            if (count == 2) {
                                log.debug("test_GetReplicaGraphTwice - got replica graph. count:" + count);
                                anzoClient.close(d.getTestErrorWrapper(function(status){
                                    log.debug("disconnected status:" + status);
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                            }
                        }));
                        
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            count++;
                            if (count == 2) {
                                log.debug("test_GetReplicaGraphTwice - got replica graph. count:" + count);
                                anzoClient.close(d.getTestErrorWrapper(function(status){
                                    log.debug("disconnected status:" + status);
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                            }
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
            name: "test_NewReplicaGraph",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_NewReplicaGraph() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("Client connected successfully");
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        log.debug("Reset successfull");
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);		
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                
                                graph.close();
                                
                                tests.assertFalse(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertFalse(anzoClient.quadStore.contains(TestData.stmt2));
                                tests.assertError(Error, graph, "contains", [ TestData.stmt1 ]); // After closing the graph, all methods throw an exception
                                tests.assertError(Error, graph, "contains", [ TestData.stmt2 ]); // After closing the graph, all methods throw an exception
                                
                                anzoClient.close(d.getTestErrorWrapper(function(status){
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },
    
        {
            name: "test_EmptyGraph",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_NewReplicaGraph() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("Client connected successfully");
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        log.debug("Reset successfull");
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            anzoClient.commit();
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(17 == graph.metadataGraph.size() || 16 == graph.metadataGraph.size() || 15 == graph.metadataGraph.size());
                                
                                anzoClient.close(d.getTestErrorWrapper(function(status){
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ExistingReplicaGraph",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function test_ExistingReplicaGraph() {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            anzoClient.begin();
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);		
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                log.debug("first anzoClient updateRepositoryComplete.");
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                
                                anzoClient.close(d.getTestErrorWrapper(function anzoClientClosed(status) {
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    anzoClient = null;
                                    log.debug("first anzoClient closed.");
                                    var anzoClient2 = new anzo.client.AnzoClient(anzo.tests.properties);
                    
                                    anzoClient2.connect(d.getTestErrorWrapper(function connected(status, message) {
                                        log.debug("Client2 connected successfully");
                                        anzoClient2.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete2(graph, error) {
                                            log.debug("got existing replica graph...");
                                            
                                            tests.assertTrue(graph.contains(TestData.stmt1));
                                            tests.assertTrue(graph.contains(TestData.stmt2));
                                            tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt1));
                                            tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt2));
                                            tests.assertEqual(2, graph.size());
                                            tests.assertTrue(17 == graph.metadataGraph.size() || 16 == graph.metadataGraph.size() || 15 == graph.metadataGraph.size());
                                            anzoClient2.begin();
                                            graph.add(TestData.stmt3);
                                            graph.add(TestData.stmt4);
                                            anzoClient2.commit();	
                                            // the statements won't be in the quad store itself yet.
                                            tests.assertFalse(anzoClient2.quadStore.contains(TestData.stmt3));
                                            tests.assertFalse(anzoClient2.quadStore.contains(TestData.stmt4));
                                            tests.assertTrue(graph.contains(TestData.stmt3));
                                            tests.assertTrue(graph.contains(TestData.stmt4));
                                            tests.assertEqual(4, graph.size());
                                        
                                            log.debug("about to updateRepositoryComplete on anzoClient2");
                                            var handle2 = dojo.connect(anzoClient2,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                                tests.assertTrue(success);
                                                dojo.disconnect(handle2);
                                                
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt1));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt2));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt3));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt4));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt3));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt4));
                                                tests.assertEqual(4, graph.size());
                                                tests.assertTrue(17 == graph.metadataGraph.size() || 16 == graph.metadataGraph.size() || 15 == graph.metadataGraph.size());
                                                
                                                anzoClient2.close(d.getTestErrorWrapper(function(status){
                                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                    d.callback(true);
                                                }));
                                            }));
                                            anzoClient2.updateRepository();
                                            
                                        }));
                                    }));
                                }));
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
            name: "test_DontCreateGraph",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_DontCreateGraph() {
             
                 var TestData = new anzo.tests.client.TestData();
                
                 var d = new doh.Deferred();
             
                 var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                 
                 anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                     anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                         tests.assertTrue(suc);
                         anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                             anzoClient.begin();
                             graph.add(TestData.stmt1);	
                             graph.add(TestData.stmt2);		
                             anzoClient.commit();
                             
                             tests.assertTrue(graph.contains(TestData.stmt1));
                             tests.assertTrue(graph.contains(TestData.stmt2));
                             
                             var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                 tests.assertTrue(success);
                                 dojo.disconnect(handle);
                                 log.debug("first anzoClient updateRepositoryComplete.");
                                 tests.assertTrue(graph.contains(TestData.stmt1));
                                 tests.assertTrue(graph.contains(TestData.stmt2));
                                 
                                 tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                 tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                 
                                 anzoClient.close(d.getTestErrorWrapper(function anzoClientClosed(status) {
                                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                     anzoClient = null;
                                     log.debug("first anzoClient closed.");
                                     var anzoClient2 = new anzo.client.AnzoClient(anzo.tests.properties);
                     
                                     anzoClient2.connect(d.getTestErrorWrapper(function connected(status, message) {
                                         log.debug("Client2 connected successfully");
                                         anzoClient2.getReplicaGraphs([TestData.graph1 , TestData.graph2] , {create: false}, d.getTestErrorWrapper(function namedGraphComplete2(graphs, error) {
                                             log.debug("got existing replica graph...");
                                             
                                             tests.assertTrue(graphs[TestData.graph1] != null);
                                             tests.assertTrue(graphs[TestData.graph2] == null);
                                             
                                             anzoClient2.close(d.getTestErrorWrapper(function(status){
                                                 tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                 d.callback(true);
                                             }));
                                         }),false);
                                     }));
                                 }));
                             }));
                             anzoClient.updateRepository();
     
                         }));
                     }));
                 }));
                 
                 return d;
             }
         },

        {
           name: "test_OfflineReplicaGraph_closeBeforeConnecting",
           timeout: 20000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.resetRaw(d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                        
                        
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            tests.assertFalse(graph._connected);
                            anzoClient.begin();
                            graph.add(TestData.stmt1);
                            graph.add(TestData.stmt2);
                            anzoClient.commit();
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            graph.close();	
                            
                            anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                                var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                    tests.assertTrue(success);
                                    dojo.disconnect(handle);
                                    // since we closed the graph, there shouldn't be any statements in the quad store
                                    tests.assertFalse(anzoClient.quadStore.contains(TestData.stmt1));
                                    tests.assertFalse(anzoClient.quadStore.contains(TestData.stmt2));
                                    // however, if we get the graph back, it should come back fully populated due
                                    // to the update call
                                    anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph2, error) {
                                        tests.assertTrue(graph2.contains(TestData.stmt1));
                                        tests.assertTrue(graph2.contains(TestData.stmt2));
                                        tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                        tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                        anzoClient.close(d.getTestErrorWrapper(function(status){
                                            d.callback(true);
                                        }));
                                    }));
                                }));
                                anzoClient.updateRepository();
                            }));
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_OfflineReplicaGraph_connectWhileOpen",
           timeout: 20000,
           setUp: function() {
           },
           
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            anzoClient.begin();
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);		
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                
                                anzoClient.close(d.getTestErrorWrapper(function onAnzoclientClose(status) {
                                    anzoClient = null;
                                    var anzoClient2 = new anzo.client.AnzoClient(anzo.tests.properties);
                
                                    anzoClient2.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete2(graph2, error) {
                                        log.debug("got existing offline replica graph...");
                                        
                                        tests.assertFalse(graph2.contains(TestData.stmt1));
                                        tests.assertFalse(graph2.contains(TestData.stmt2));
                                        tests.assertFalse(anzoClient2.quadStore.contains(TestData.stmt1));
                                        tests.assertFalse(anzoClient2.quadStore.contains(TestData.stmt2));
                                        
                                        anzoClient2.connect(d.getTestErrorWrapper(function connected(status, message) {
                                            log.debug("Client2 connected successfully: " + status);
                                            
                                            tests.assertTrue(graph2.contains(TestData.stmt1));
                                            tests.assertTrue(graph2.contains(TestData.stmt2));
                                            tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt1));
                                            tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt2));
                                            tests.assertEqual(2,graph2.size());
                                            tests.assertTrue(15 == graph2.metadataGraph.size() || 16 == graph2.metadataGraph.size() || 17 == graph2.metadataGraph.size() );
                                            anzoClient2.begin();
                                            graph2.add(TestData.stmt3);
                                            graph2.add(TestData.stmt4);
                                            anzoClient2.commit();	
                                            // the statements won't be in the quad store itself yet.
                                            tests.assertFalse(anzoClient2.quadStore.contains(TestData.stmt3));
                                            tests.assertFalse(anzoClient2.quadStore.contains(TestData.stmt4));
                                            tests.assertTrue(graph2.contains(TestData.stmt3));
                                            tests.assertTrue(graph2.contains(TestData.stmt4));
                                            tests.assertEqual(4,graph2.size());
                                        
                                            
                                            var handle2 = dojo.connect(anzoClient2,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                                tests.assertTrue(success);
                                                dojo.disconnect(handle2);
                                                
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt1));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt2));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt3));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt4));
                                                tests.assertEqual(4,graph2.size());
                                                tests.assertTrue(15 == graph2.metadataGraph.size() || 16 == graph2.metadataGraph.size() || 17 == graph2.metadataGraph.size());
                                                
                                                anzoClient2.close(d.getTestErrorWrapper(function(status) { 
                                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                    d.callback(true);
                                                }));
                                            }));
                                            anzoClient2.updateRepository();
                                            
                                        }));
                                    }));
                                }));
                                
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
          
        },
        
        {
           name: "test_CreateAndAddInSameTransaction", 
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);		
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                
                                var modelService = anzoClient.modelService;
                                modelService.getNamedGraphRevision(TestData.graph1, -1, d.getTestErrorWrapper(function getNamedGraphRevisionComplete(stmts, success, error) {
                                    tests.assertTrue(success);
                                    tests.assertEqual(19, stmts.length);
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));				
                                
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_NamedGraphReplicationEvents",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            anzoClient.begin();
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);		
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            
                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                tests.assertEqual(2, graph.size());
                         
                                // Listen for new statement events
                                var stmts = [];
                                var eventHandle = dojo.connect(graph, "statementsAdded", d.getTestErrorWrapper(function(statements){
                                    for (var i=0;i<statements.length;i++) {
                                        stmts.push(statements[i]);
                                    }
                                }));

                                // Now add some more statements to the server but NOT via the
                                // AnzoClient API so that it simulates another system having added the statements.
                                anzo.tests.utilities.rawUpdateRepository([TestData.stmt3, TestData.stmt4], true, d.getTestErrorWrapper(function onRawUpdateRepository(updateResults, success, errors) {
                                    tests.assertTrue(success);
                                    
                                    // Now replicate to pick up the newly added statements and check that the appropriate events were fired
                                    var handle2 = dojo.connect(anzoClient, "replicationComplete", d.getTestErrorWrapper(function(success, errors) {
                                        dojo.disconnect(handle2);
                                        handle2 = null; 
                                        tests.assertTrue(success);
                                        tests.assertEqual(2, stmts.length);
                                        anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                            d.callback(true);
                                        }));
                                    }));
                                    anzoClient.replicate();
                                }));
                            }));
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_NamedGraphUpdates",
           timeout: 30000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            anzoClient.begin();
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);		
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("First update repository complete");
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));

                                anzoClient.close(d.getTestErrorWrapper(function onAnzoClientClose(status) {
                                    anzoClient = null;
                                
                                    var anzoClient2 = new anzo.client.AnzoClient(anzo.tests.properties);
                    
                                    anzoClient2.connect(d.getTestErrorWrapper(function connected(status, message) {
                                        log.debug("Client2 connected successfully");
                                        anzoClient2.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete2(graph, error) {
                                            log.debug("got existing replica graph...");
                                            
                                            tests.assertTrue(graph.contains(TestData.stmt1));
                                            tests.assertTrue(graph.contains(TestData.stmt2));
                                            tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt1));
                                            tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt2));
                                            tests.assertEqual(2, graph.size());
                                            
                                            tests.assertTrue(17 == graph.metadataGraph.size() || 16 == graph.metadataGraph.size() || 15 == graph.metadataGraph.size());
                                            anzoClient2.begin();
                                            graph.add(TestData.stmt3);
                                            anzoClient2.commit();
                                            anzoClient2.begin();
                                            graph.add(TestData.stmt4);
                                            anzoClient2.commit();	
                                            // the statements won't be in the quad store itself yet.
                                            tests.assertFalse(anzoClient2.quadStore.contains(TestData.stmt3));
                                            tests.assertFalse(anzoClient2.quadStore.contains(TestData.stmt4));
                                            tests.assertTrue(graph.contains(TestData.stmt3));
                                            tests.assertTrue(graph.contains(TestData.stmt4));
                                            tests.assertEqual(4,graph.size());
                                            
                                            var stmts = [];
                                            var eventHandle = dojo.connect(graph,"statementsAdded", d.getTestErrorWrapper(function(statements){
                                                for (var i=0;i<statements.length;i++) {
                                                    stmts.push(statements[i]);
                                                }
                                            }));
                                            
                                            var transactions = [];
                                            var eventHandle2 = dojo.connect(anzoClient2,"transactionComplete", d.getTestErrorWrapper(function(transactionURI, transactionTimestamp, transactionGraphs, transactionContext){
                                                transactions.push(transactionURI);
                                            }));
                                        
                                            var handle2 = dojo.connect(anzoClient2,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                                tests.assertTrue(success);
                                                dojo.disconnect(handle2);
                                                handle2 = null;
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt1));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt2));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt3));
                                                tests.assertTrue(anzoClient2.quadStore.contains(TestData.stmt4));
                                                tests.assertEqual(4,graph.size());
                                                tests.assertTrue(17 == graph.metadataGraph.size() || 16 == graph.metadataGraph.size() || 15 == graph.metadataGraph.size());
                                                log.debug("Checking the events..");
                                                tests.assertEqual(2,stmts.length);
                                                tests.assertTrue(transactions.length >= 2);
                                                anzoClient2.close(d.getTestErrorWrapper(function(status) { 
                                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                    d.callback(true);
                                                }));
                                            }));
                                            anzoClient2.updateRepository();
                                        }));
                                    }));
                                }));
                            }));
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_TransactionContext",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);
                            anzoClient.commit();
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                dojo.disconnect(handle);
                                anzoClient.begin();
                                anzoClient.getTransactionContext().add(TestData.stmt5);
                                graph.add(TestData.stmt1);	
                                graph.add(TestData.stmt2);	
                                anzoClient.begin();
                                anzoClient.getTransactionContext().add(TestData.stmt6);
                                graph.add(TestData.stmt3);
                                graph.add(TestData.stmt4);			
                                anzoClient.commit();
                                anzoClient.commit();

                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                tests.assertTrue(graph.contains(TestData.stmt3));
                                tests.assertTrue(graph.contains(TestData.stmt4));
                                
                                var transactions = new Array();
                                var context = null;
                                var graphs = null;
                                var eventHandle = dojo.connect(anzoClient,"transactionComplete", d.getTestErrorWrapper(function(transactionURI, transactionTimestamp, transactionGraphs, transactionContext){
                                    log.debug("transactionComplete context:" + transactionContext);
                                    transactions.push(transactionURI);
                                    context = transactionContext;
                                    graphs = transactionGraphs;
                                }));
                                
                                var handle2 = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                    dojo.disconnect(handle2);
                                    
                                    tests.assertTrue(graph.contains(TestData.stmt1));
                                    tests.assertTrue(graph.contains(TestData.stmt2));
                                    tests.assertTrue(graph.contains(TestData.stmt3));
                                    tests.assertTrue(graph.contains(TestData.stmt4));
                                    
                                    tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                    tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                    tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt3));
                                    tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt4));
                                    
                                    tests.assertTrue(context != null);
                                    tests.assertEqual(2,context.find().length);
                                    tests.assertTrue(transactions.length >= 1);
                                    tests.assertEqual(1, graphs.length);
                                    tests.assertEqual("http://test.example.com/test#namedGraph1", graphs[0]);
                                    
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                    
                                }));
                                anzoClient.updateRepository();
                            }));
                            anzoClient.updateRepository();
                        
    
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ServerQuery_SELECT",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQuery_SELECT() {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            
                            graph.add(TestData.stmt1);	
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                
                                var queryStr = 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
                                anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                    if (!success) {
                                        log.debug("Query execution failed: " + dojo.toJson(error));
                                    }
                                    tests.assertTrue(success);
                                    tests.assertTrue(msg != null);
                                    
                                    // head
                                    tests.assertTrue(msg.head != null);
                                    tests.assertTrue(msg.head.vars != null);
                                    tests.assertTrue(msg.head.vars[0] == 'x');
                                    tests.assertTrue(msg.head.vars[1] == 'y');
                                    
                                    // results
                                    tests.assertTrue(msg.results != null);
                                    tests.assertTrue(msg.results.bindings != null);
                                    tests.assertTrue(msg.results.bindings[0] != null);
                                    
                                    tests.assertTrue(msg.results.bindings[0].x != null);
                                    tests.assertTrue(msg.results.bindings[0].x.value == TestData.stmt1.predicate.toString());
                                    tests.assertTrue(msg.results.bindings[0].x.type == 'uri');
                                    
                                    tests.assertTrue(msg.results.bindings[0].y != null);
                                    log.debug("testing y value");
                                    tests.assertTrue(msg.results.bindings[0].y.value == TestData.stmt1.object.toString());
                                    log.debug("testing y type: " + msg.results.bindings[0].y.type);
                                    tests.assertTrue(msg.results.bindings[0].y.type == 'literal');
                                    
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                                
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
            name: "test_ServerQuery_SELECT_TotalSolutions",
            timeout: 40000,
            setUp: function() {
            },
            runTest: function test_ServerQuery_SELECT_TotalSolutions() {
             
                 var TestData = new anzo.tests.client.TestData();
                
                 var d = new doh.Deferred();
             
                 var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                 
                 anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                     anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                         log.debug("Reset done - success:" + suc);
                         tests.assertTrue(suc);
                         anzoClient.begin();
                         anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                             log.debug("Got replica graph:" + graph);
                             
                             graph.add(TestData.subj1, TestData.pred1, TestData.obj1);  
                             graph.add(TestData.subj1, TestData.pred2, TestData.obj2);  
                             graph.add(TestData.subj1, TestData.pred3, TestData.obj3);  
                             graph.add(TestData.subj1, TestData.pred4, TestData.obj4);  
                             anzoClient.commit();
                             
                             var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                 log.debug("updateRepositoryComplete - success:" + success);
                                 tests.assertTrue(success);
                                 dojo.disconnect(handle);
                                 
                                 var queryStr = 'select ?x ?y where { <' + TestData.subj1.toString() +  '> ?x ?y . } ORDER BY ?x LIMIT 2 OFFSET 1 ';
                                 anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                     if (!success) {
                                         log.debug("Query execution failed: " + dojo.toJson(error));
                                     }
                                     tests.assertTrue(success);
                                     tests.assertTrue(msg != null);
                                     
                                     // head
                                     tests.assertTrue(msg.head != null);
                                     tests.assertTrue(msg.head.vars != null);
                                     tests.assertTrue(msg.head.vars[0] == 'x');
                                     tests.assertTrue(msg.head.vars[1] == 'y');
                                     log.debug("About to check total solutions: " + msg.head.totalSolutions)
                                     tests.assertEqual(4, msg.head.totalSolutions);
                                     
                                     // results
                                     tests.assertTrue(msg.results != null);
                                     tests.assertTrue(msg.results.bindings != null);
                                     tests.assertEqual(2, msg.results.bindings.length);
                                     tests.assertTrue(msg.results.bindings[0] != null);
                                     
                                     log.debug("checking binding 0's x value");
                                     tests.assertTrue(msg.results.bindings[0].x != null);
                                     tests.assertEqual(TestData.pred2.toString(), msg.results.bindings[0].x.value);
                                     tests.assertEqual('uri', msg.results.bindings[0].x.type);
                                     
                                     log.debug("checking binding 0's y value");
                                     tests.assertTrue(msg.results.bindings[0].y != null);
                                     tests.assertEqual(TestData.obj2.toString(), msg.results.bindings[0].y.value);
                                     tests.assertEqual('literal', msg.results.bindings[0].y.type);

                                     log.debug("checking binding 1's x value");
                                     tests.assertTrue(msg.results.bindings[1].x != null);
                                     tests.assertEqual(TestData.pred3.toString(), msg.results.bindings[1].x.value);
                                     tests.assertEqual('uri', msg.results.bindings[1].x.type);
                                     
                                     log.debug("checking binding 1's y value");
                                     tests.assertTrue(msg.results.bindings[1].y != null);
                                     tests.assertEqual(TestData.obj3.toString(), msg.results.bindings[1].y.value);
                                     tests.assertEqual('literal', msg.results.bindings[1].y.type);

                                     anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                         tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                         d.callback(true);
                                     }));
                                 }));
                                 
                             }));
                             anzoClient.updateRepository();
     
                         }));
                     }));
                 }));
                 
                 return d;
             }
         },

        {
            name: "test_ServerQuery_SELECT_DuplicateQueryCulling",
            timeout: 40000,
            setUp: function() {
            },
            runTest: function test_ServerQuery_SELECT_DuplicateQueryCulling() {
                // summary: This tests issues two identical queries immediately in a row to see if the second query will be
                //   not be sent to the server and its callback simply piggy-backed on the first queries response.
                 var TestData = new anzo.tests.client.TestData();
                
                 var d = new doh.Deferred();
             
                 var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                 
                 anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                     anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                         tests.assertTrue(suc);
                         anzoClient.begin();
                         anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                             
                             graph.add(TestData.stmt1);  
                             anzoClient.commit();
                             
                             tests.assertTrue(graph.contains(TestData.stmt1));
                             
                             var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                 tests.assertTrue(success);
                                 dojo.disconnect(handle);
                                 
                                 tests.assertTrue(graph.contains(TestData.stmt1));
                                 
                                 tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                 
                                 var queryCallback1Called = false;
                                 var queryCallback2Called = false;
                                 
                                 log.debug("Calling first query");
                                 
                                 var queryStr = 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
                                 anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                     queryCallback1Called = true;
                                     log.debug("Callback one called");
                                     if (!success) {
                                         log.debug("Query execution failed: " + dojo.toJson(error));
                                     }
                                     tests.assertTrue(success);
                                     tests.assertTrue(msg != null);
                                 }));
                                 log.debug("Calling duplicate query");
                                 anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                     queryCallback2Called = true;
                                     log.debug("Callback two called");
                                     if (!success) {
                                         log.debug("Query execution failed: " + dojo.toJson(error));
                                     }
                                     tests.assertTrue(success);
                                     tests.assertTrue(msg != null);
                                 }));
                                 
                                 log.debug("Waiting for both query callbacks");

                                 anzo.tests.utilities.waitFor(function(){ 
                                     log.debug("Polling for callbacks: queryCallback1Called:" + queryCallback1Called + " queryCallback2Called:" + queryCallback2Called);
                                     return queryCallback1Called && queryCallback2Called; 
                                 }, 5000, 500, d.getTestErrorWrapper(function(success) {
                                     log.debug("Done waiting for callbacks - success:" + success);
                                     tests.assertTrue(success);

                                     log.debug("Checking if second query was culled - anzoClient.queryService._queriesCulled:" + anzoClient.queryService._queriesCulled);
                                     tests.assertTrue(anzoClient.queryService._queriesCulled == 1); // reaching into internal state just to verify the test
                                     
                                     tests.assertTrue(anzoClient.queryService._pendingQueries.size() == 0); // Make sure that the pending queries collection has been cleaned up
                                     
                                     anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                         tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                         d.callback(true);
                                     }));
                                 }));
                             }));
                             anzoClient.updateRepository();
     
                         }));
                     }));
                 }));
                 
                 return d;
             }
         },

         {
           name: "test_ServerQuery_ASK",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQuery_ASK() {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            log.debug("getReplicaGraph");
                            graph.add(TestData.subj1, TestData.pred1, TestData.obj1);	
                            tests.assertTrue(graph.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                            anzoClient.commit();
                            
                            log.debug("checking in replica graph");
                            tests.assertTrue(graph.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                            log.debug("done checking in replica graph");
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("updateRepositoryComplete");
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(graph.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                
                                var queryStr = 'ask { <' + TestData.subj1.toString() + '> <' + TestData.pred1.toString() + '> ?x . }';
                                anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                    log.debug("serverQuery");
                                    if (!success) {
                                        log.debug("Query execution failed: " + dojo.toJson(error, true));
                                    }
                                    tests.assertTrue(success);
                                    tests.assertTrue(msg != null);
                                    
                                    // head
                                    log.debug("assert head");
                                    tests.assertTrue(msg.head != null);
                                    
                                    // results
                                    log.debug("assert boolean");
                                    tests.assertTrue(msg["boolean"] === true);

                                    // Now test a false result
                                    var falseQueryStr = 'ask { <' + TestData.subj1.toString() + '> <' + TestData.pred2.toString() + '> ?x . }';
                                    anzoClient.serverQuery([TestData.graph1], null, null, falseQueryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                        log.debug("serverQuery for false query");
                                        if (!success) {
                                            log.debug("Query execution failed: " + dojo.toJson(error, true));
                                        }
                                        tests.assertTrue(success);
                                    
                                        tests.assertTrue(msg != null);
                                        
                                        // head
                                        log.debug("assert head");
                                        tests.assertTrue(msg.head != null);
                                        
                                        // results
                                        log.debug("assert boolean");
                                        tests.assertTrue(msg["boolean"] === false);

                                        anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                            d.callback(true);
                                        }));
                                    }));
                                }));
                                
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ServerQuery_CONSTRUCT",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQuery_CONSTRUCT() {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            log.debug("getReplicaGraph");
                            graph.add(TestData.subj1, TestData.pred1, TestData.obj1);	
                            tests.assertTrue(graph.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                            anzoClient.commit();
                            
                            log.debug("checking in replica graph");
                            tests.assertTrue(graph.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                            log.debug("done checking in replica graph");
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("updateRepositoryComplete");
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(graph.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                
                                var queryStr = 'construct { <' + TestData.subj2.toString() + '> <' + TestData.pred2.toString() + '> ?x . }'
                                             + 'where { <' + TestData.subj1.toString() + '> <' + TestData.pred1.toString() + '> ?x . }';
                                anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(graph, success, error) {
                                    log.debug("serverQuery");
                                    if (!success) {
                                        log.debug("Query execution failed: " + dojo.toJson(error, true));
                                    }
                                    tests.assertTrue(success);
                                    tests.assertTrue(graph.contains(TestData.subj2, TestData.pred2, TestData.obj1));
                                    tests.assertTrue(graph.find(TestData.subj2, TestData.pred2, TestData.obj1).length == 1);
                                    
                                    // The replica shouldn't be modified by a CONSTRUCT query. The results just come back in a memory graph.
                                    tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj1).length == 0); 
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                                
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
            name: "test_ServerQuery_CONSTRUCT_QUADS",
            timeout: 40000,
            setUp: function() {
            },
            runTest: function test_ServerQuery_CONSTRUCT_QUADS() {
             
                 var TestData = new anzo.tests.client.TestData();
                
                 var d = new doh.Deferred();
             
                 var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                 
                 anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                     anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                         tests.assertTrue(suc);
                         anzoClient.begin();
                         anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                             log.debug("getReplicaGraph");
                             graph.add(TestData.subj1, TestData.pred1, TestData.obj1);   
                             tests.assertTrue(graph.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                             anzoClient.commit();
                             
                             log.debug("checking in replica graph");
                             tests.assertTrue(graph.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                             log.debug("done checking in replica graph");
                             
                             var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                 log.debug("updateRepositoryComplete");
                                 tests.assertTrue(success);
                                 dojo.disconnect(handle);
                                 
                                 tests.assertTrue(graph.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                 
                                 tests.assertTrue(anzoClient.quadStore.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                 var queryStr = 'construct { graph <' + TestData.graph2.toString() + '> { <' + TestData.subj2.toString() + '> <' + TestData.pred2.toString() + '> ?x . } } '
                                              + 'where { <' + TestData.subj1.toString() + '> <' + TestData.pred1.toString() + '> ?x . }';
                                 anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(statements, success, error) {
                                     log.debug("serverQuery");
                                     if (!success) {
                                         log.debug("Query execution failed: " + dojo.toJson(error, true));
                                     }
                                     tests.assertTrue(success);
                                     var quadStore = new anzo.rdf.QuadStore();
                                     quadStore.add(statements);
                                     tests.assertTrue(quadStore.contains(TestData.subj2, TestData.pred2, TestData.obj1, TestData.graph2));
                                     tests.assertTrue(quadStore.find(TestData.subj2, TestData.pred2, TestData.obj1, TestData.graph2).length == 1);
                                     
                                     // The replica shouldn't be modified by a CONSTRUCT query. The results just come back in a memory statements array.
                                     tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj1).length == 0); 
                                     anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                         tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                         d.callback(true);
                                     }));
                                 }));
                                 
                             }));
                             anzoClient.updateRepository();
     
                         }));
                     }));
                 }));
                 
                 return d;
             }
         },

        {
           name: "test_ServerQueries_SELECT",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQueries_SELECT() {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            
                            graph.add(TestData.stmt1);	
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));

                                var queryResults = [ null, null, null ]; // Collects the results for the individuals queries as they come back asynchronously
                                var queryCallbackGenerator = function(i) { return function(msg, success, error) { queryResults[i] = { msg: msg, success: success, error: error }; }; };  
                                var queries = [
                                    {   defaultNamedGraphs: [TestData.graph1], namedGraphs: null, namedDatasets: null,
                                        query : 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }',
                                        baseUri: null, callback: d.getTestErrorWrapper(queryCallbackGenerator(0))
                                    },
                                    {   defaultNamedGraphs: [TestData.graph1], namedGraphs: null, namedDatasets: null,
                                        query : 'select ?x ?y where { ?x <' + TestData.stmt1.predicate.toString() +  '> ?y . }',
                                        baseUri: null, callback: d.getTestErrorWrapper(queryCallbackGenerator(1))
                                    },
                                    {   defaultNamedGraphs: [TestData.graph1], namedGraphs: null, namedDatasets: null,
                                        query : 'select ?x ?y where { ?x ?y ' + TestData.stmt1.object.serialize() +  ' . }',
                                        baseUri: null, callback: d.getTestErrorWrapper(queryCallbackGenerator(2))
                                    }
                                ];                                
                                anzoClient.serverQueries(queries);

                                // Wait around and poll until all three queries have returned.
                                var pollCount = 0;
                                var checkQueriesDone = d.getTestErrorWrapper(function _checkQueriesDone() {
                                    pollCount++;
                                    var msg = "";
                                    for (var i = 0; i < queryResults.length; i++) {
                                        if (queryResults[i] != null) {
                                            msg += "Got results for query #" + i + " (success:" + queryResults[i].success + "). ";
                                        } else {
                                            msg += "Waiting for query #" + i + ". ";
                                        }
                                    }
                                    log.debug(msg);

                                    if (dojo.every(queryResults, function(item) { return item != null; })) {
                                        log.debug("Got results for all queries expected.");
                                        
                                        // Check if the query results were all successful.
                                        var failedResults = false;
                                        for (var i = 0; i < queryResults.length; i++) {
                                            if (queryResults[i].success != true) {
                                                failedResults = true;
                                                log.error("Query result #" + i + " failed. Error:" + dojo.toJson(queryResults[i].error, true));
                                            }
                                        }
                                        tests.assertFalse(failedResults);
                                        anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                            d.callback(true);
                                        }));
                                    } else {
                                        if (pollCount < 5) {
                                            log.debug("All query results haven't arrived. Polling again...");
                                            setTimeout(checkQueriesDone, 1000);
                                        } else {
                                            throw new Error("Expected query results didn't arrive.");
                                        }
                                    }
                                });
                                setTimeout(checkQueriesDone, 1000);
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ServerQueries_ERROR_in_one_query_does_not_stop_all_queries",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQueries_ERROR_in_one_query_does_not_stop_all_queries() {
               // summary: Ensures that having an error in one of the queries in the array doesn't stop other in the array from being sent.
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            
                            graph.add(TestData.stmt1);	
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));

                                var queryResults = [ null, null ]; // Collects the results for the individuals queries as they come back asynchronously
                                var queryCallbackGenerator = function(i) { return function(msg, success, error) { queryResults[i] = { msg: msg, success: success, error: error }; }; };  
                                var queries = [
                                    // Query #0
                                    {   defaultNamedGraphs: [TestData.graph1], namedGraphs: null, namedDatasets: null,
                                        query : 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }',
                                        baseUri: null, callback: d.getTestErrorWrapper(queryCallbackGenerator(0))
                                    },
                                    // erroneous query - can't be sent...we expect subsequent queries to still be sent
                                    {   defaultNamedGraphs: null, namedGraphs: null, namedDatasets: null,
                                        query : null, // a null query string should throw an exception
                                        baseUri: null, callback: null
                                    },
                                    // erroneous query - can't be sent...we expect subsequent queries to still be sent
                                    null, // an empty entry should just be skipped over
                                    // Query #1
                                    {   defaultNamedGraphs: [TestData.graph1], namedGraphs: null, namedDatasets: null,
                                        query : 'select ?x ?y where { ?x ?y ' + TestData.stmt1.object.serialize() +  ' . }',
                                        baseUri: null, callback: d.getTestErrorWrapper(queryCallbackGenerator(1))
                                    }
                                ];
                                
                                var gotExpectedException = false;
                                try {
                                    anzoClient.serverQueries(queries);
                                } catch (e) {
                                    gotExpectedException = true;
                                    log.debug("Got expected exception:" + e.message);
                                }
                                tests.assertTrue(gotExpectedException);

                                // Wait around and poll until all expected queries have returned.
                                var pollCount = 0;
                                var checkQueriesDone = d.getTestErrorWrapper(function _checkQueriesDone() {
                                    pollCount++;
                                    var msg = "";
                                    for (var i = 0; i < queryResults.length; i++) {
                                        if (queryResults[i] != null) {
                                            msg += "Got results for query #" + i + " (success:" + queryResults[i].success + "). ";
                                        } else {
                                            msg += "Waiting for query #" + i + ". ";
                                        }
                                    }
                                    log.debug(msg);

                                    if (dojo.every(queryResults, function(item) { return item != null; })) {
                                        log.debug("Got results for all queries expected.");
                                        
                                        // Check if the query results were all successful.
                                        var failedResults = false;
                                        for (var i = 0; i < queryResults.length; i++) {
                                            if (queryResults[i].success != true) {
                                                failedResults = true;
                                                log.error("Query result #" + i + " failed. Error:" + dojo.toJson(queryResults[i].error, true));
                                            }
                                        }
                                        tests.assertFalse(failedResults);
                                        anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                            d.callback(true);
                                        }));
                                    } else {
                                        if (pollCount < 5) {
                                            log.debug("All query results haven't arrived. Polling again...");
                                            setTimeout(checkQueriesDone, 1000);
                                        } else {
                                            throw new Error("Expected query results didn't arrive.");
                                        }
                                    }
                                });
                                setTimeout(checkQueriesDone, 1000);
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ServerQuery_ClientCache",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQuery_ClientCache() {
               // summary: Test that asking the same query (on the same dataset) causes a cache hit. And test that the 
               //   cache entry is invalidated when a graph in the dataset changes. 
               //   Note: We reach into private state to check if the cache was used.
               
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            
                            graph.add(TestData.stmt1);
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                
                                var queryStr = 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
                                anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                    log.debug("First query finished. success:" + success);
                                    if (!success) {
                                        log.debug("Query execution failed: " + dojo.toJson(error));
                                    }
                                    tests.assertTrue(success);
                                    tests.assertTrue(msg != null);

                                    // We expect this first query to have been a cache miss
                                    tests.assertEqual(0, anzoClient.queryService._cacheHits);
                                    tests.assertEqual(1, anzoClient.queryService._cacheMisses);

                                    log.debug("About to send second query.");

                                    // Now repeat the query to check if it's cached
                                    anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                        log.debug("Second query finished. success:" + success);
                                        if (!success) {
                                            log.debug("Query execution failed: " + dojo.toJson(error));
                                        }
                                        tests.assertTrue(success);
    
                                        // We expect this second query to have been a cache hit
                                        tests.assertEqual(1, anzoClient.queryService._cacheHits);
                                        tests.assertEqual(1, anzoClient.queryService._cacheMisses);

                                        // Verify that the result set is what we expect it to be
                                        tests.assertTrue(msg != null);

                                        // head
                                        tests.assertTrue(msg.head != null);
                                        tests.assertTrue(msg.head.vars != null);
                                        tests.assertTrue(msg.head.vars[0] == 'x');
                                        tests.assertTrue(msg.head.vars[1] == 'y');
                                        
                                        // results
                                        tests.assertTrue(msg.results != null);
                                        tests.assertTrue(msg.results.bindings != null);
                                        tests.assertTrue(msg.results.bindings[0] != null);
                                        
                                        tests.assertTrue(msg.results.bindings[0].x != null);
                                        tests.assertTrue(msg.results.bindings[0].x.value == TestData.stmt1.predicate.toString());
                                        tests.assertTrue(msg.results.bindings[0].x.type == 'uri');
                                        
                                        tests.assertTrue(msg.results.bindings[0].y != null);
                                        log.debug("testing y value");
                                        tests.assertTrue(msg.results.bindings[0].y.value == TestData.stmt1.object.toString());
                                        log.debug("testing y type: " + msg.results.bindings[0].y.type);
                                        tests.assertTrue(msg.results.bindings[0].y.type == 'literal');
                                        
                                        // Now change a graph in the dataset to cause the invalidation of the cached query results.
                                        graph.remove(TestData.stmt1);

                                        log.debug("About to send update repository to change graph in dataset.");

                                        var handle2 = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                            log.debug("Done updating repository to change graph in dataset. success:" + success);
                                            tests.assertTrue(success);
                                            dojo.disconnect(handle2);
                                            handle2 = null;
                                            
                                            tests.assertFalse(graph.contains(TestData.stmt1));
                                            tests.assertFalse(anzoClient.quadStore.contains(TestData.stmt1));

                                            // Wait a little while to ensure that the notification message invalidating the query cache reaches this client.
                                            setTimeout(d.getTestErrorWrapper(function(success, errors) {
                                                // Now repeat the query and verify that it isn't cached anymore now that that the event has been received.
                                                log.debug("About to send third query.");
                                                anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                                    log.debug("Third query finished. success:" + success);
                                                    if (!success) {
                                                        log.debug("Query execution failed: " + dojo.toJson(error));
                                                    }
                                                    tests.assertTrue(success);

                                                    // We expect this third query to have been a cache miss
                                                    tests.assertEqual(1, anzoClient.queryService._cacheHits);
                                                    tests.assertEqual(2, anzoClient.queryService._cacheMisses);
                                            
                                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                        d.callback(true);
                                                    }));
                                                }));
                                            }), 1000);
                                        }));
                                        anzoClient.updateRepository();
                                    }));
                                }));
                                
                            }));
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
            name: "test_ServerQuery_ClientCacheInvalidation_Ticket827",
            timeout: 40000,
            setUp: function() {
            },
            runTest: function test_ServerQuery_ClientCacheInvalidation_Ticket827() {
                // summary: Test query cache invalidation works properly when modifying graphs referenced by linked data sets. 
                //   See http://www.openanzo.org/projects/openanzo/ticket/827
                //   Note: We reach into private state to check if the cache was used.
                
                 var TestData = new anzo.tests.client.TestData();
                
                 var d = new doh.Deferred();
             
                 var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                 
                 anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                     anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                         tests.assertTrue(suc);
                         // Setup existing graphs and the dataset that references the graphs.
                         anzoClient.begin();
                         anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                             
                             graph.add(TestData.stmt1);
                             
                             anzoClient.getReplicaGraph(TestData.graph2, null, d.getTestErrorWrapper(function namedGraphComplete2(datasetGraph, error) {
                                 
                            	 datasetGraph.add(TestData.graph2, anzo.rdf.vocabulary.RDF.type, anzo.client.Vocabulary.namedDatasetType);
                            	 datasetGraph.add(TestData.graph2, anzo.client.Vocabulary.namedGraphProperty, TestData.graph1);
                            	 datasetGraph.add(TestData.graph2, anzo.client.Vocabulary.defaultGraphProperty, TestData.graph1);
                            	 anzoClient.commit();
                             
	                             var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
	                                 log.debug("Finished setting up initial data state - success:" + success);
	                                 tests.assertTrue(success);
	                                 dojo.disconnect(handle);
	                                 handle = null;
	                                 
	                                 var queryStr = 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
	                                 anzoClient.serverQuery(null, null, [TestData.graph2], queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
	                                     log.debug("First query finished. success:" + success);
	                                     if (!success) {
	                                         log.debug("Query execution failed: " + dojo.toJson(error));
	                                     }
	                                     tests.assertTrue(success);
	                                     tests.assertTrue(msg != null);
	
	                                     // We expect this first query to have been a cache miss
	                                     tests.assertEqual(0, anzoClient.queryService._cacheHits);
	                                     tests.assertEqual(1, anzoClient.queryService._cacheMisses);
	
	                                     log.debug("About to send second query.");
	
	                                     // Now change the graph and then do a query to see if the cache was correctly invalidated
	                                     anzoClient.begin();
	                                     graph.remove(TestData.stmt1);
	                                     var modifiedStmt1Literal = TestData.stmt1.object.label + " 123";
	                                     graph.add(TestData.stmt1.subject, TestData.stmt1.predicate, anzo.createLiteral(modifiedStmt1Literal));
	                                     anzoClient.commit();

	                                     log.debug("About to send update repository to change graph in dataset.");

	    	                             var handle2 = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
	    	                                 log.debug("Finished modifying graph contents - success:" + success);
	    	                                 tests.assertTrue(success);
	    	                                 dojo.disconnect(handle2);
	    	                                 handle2 = null;

                                             // Wait a little while to ensure that the notification message invalidating the query cache reaches this client.
                                             setTimeout(d.getTestErrorWrapper(function(success, errors) {
                                            	 log.debug("About to send second query.");
			                                     // Now repeat the query to see if the cache was correctly invalidated.
			                                     anzoClient.serverQuery(null, null, [TestData.graph2], queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
			                                         log.debug("Second query finished. success:" + success);
			                                         if (!success) {
			                                             log.debug("Query execution failed: " + dojo.toJson(error));
			                                         }
			                                         tests.assertTrue(success);
			     
			                                         // We expect this second query to have been a cache hit
			                                         tests.assertEqual(0, anzoClient.queryService._cacheHits);
			                                         tests.assertEqual(2, anzoClient.queryService._cacheMisses);
			
			                                         // Verify that the result set is what we expect it to be
			                                         tests.assertTrue(msg != null);
			
			                                         // head
			                                         tests.assertTrue(msg.head != null);
			                                         tests.assertTrue(msg.head.vars != null);
			                                         tests.assertTrue(msg.head.vars[0] == 'x');
			                                         tests.assertTrue(msg.head.vars[1] == 'y');
			                                         
			                                         // results
			                                         tests.assertTrue(msg.results != null);
			                                         tests.assertTrue(msg.results.bindings != null);
			                                         tests.assertTrue(msg.results.bindings[0] != null);
			                                         
			                                         tests.assertTrue(msg.results.bindings[0].x != null);
			                                         tests.assertTrue(msg.results.bindings[0].x.value == TestData.stmt1.predicate.toString());
			                                         tests.assertTrue(msg.results.bindings[0].x.type == 'uri');
			                                         
			                                         tests.assertTrue(msg.results.bindings[0].y != null);
			                                         log.debug("testing y value");
			                                         tests.assertTrue(msg.results.bindings[0].y.value == modifiedStmt1Literal);
			                                         log.debug("testing y type: " + msg.results.bindings[0].y.type);
			                                         tests.assertTrue(msg.results.bindings[0].y.type == 'literal');
			                                         
				                                     log.debug("Changing the graph once again.");
				                                 	
				                                     // Now change the graph and then do a query to see if the cache was correctly invalidated
				                                     anzoClient.begin();
				                                     graph.remove(TestData.stmt1.subject, TestData.stmt1.predicate, null);
				                                     var modifiedStmt1Literal2 = TestData.stmt1.object.label + " 123 456";
				                                     graph.add(TestData.stmt1.subject, TestData.stmt1.predicate, anzo.createLiteral(modifiedStmt1Literal2));
				                                     anzoClient.commit();

				    	                             var handle3 = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
				    	                                 log.debug("Finished modifying graph contents a second time - success:" + success);
				    	                                 tests.assertTrue(success);
				    	                                 dojo.disconnect(handle3);
				    	                                 handle3 = null;

			                                             // Wait a little while to ensure that the notification message invalidating the query cache reaches this client.
			                                             setTimeout(d.getTestErrorWrapper(function(success, errors) {
			                                            	 log.debug("About to send third query.");
						                                     // Now repeat the query to see if the cache was correctly invalidated.
						                                     anzoClient.serverQuery(null, null, [TestData.graph2], queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
						                                         log.debug("Third query finished. success:" + success);
						                                         if (!success) {
						                                             log.debug("Query execution failed: " + dojo.toJson(error));
						                                         }
						                                         tests.assertTrue(success);
						     
						                                         // We expect this second query to have been a cache hit
						                                         tests.assertEqual(0, anzoClient.queryService._cacheHits);
						                                         tests.assertEqual(3, anzoClient.queryService._cacheMisses);
	
						                                         // Verify that the result set is what we expect it to be
						                                         tests.assertTrue(msg != null);
						
						                                         // head
						                                         tests.assertTrue(msg.head != null);
						                                         tests.assertTrue(msg.head.vars != null);
						                                         tests.assertTrue(msg.head.vars[0] == 'x');
						                                         tests.assertTrue(msg.head.vars[1] == 'y');
						                                         
						                                         // results
						                                         tests.assertTrue(msg.results != null);
						                                         tests.assertTrue(msg.results.bindings != null);
						                                         tests.assertTrue(msg.results.bindings[0] != null);
						                                         
						                                         tests.assertTrue(msg.results.bindings[0].x != null);
						                                         tests.assertTrue(msg.results.bindings[0].x.value == TestData.stmt1.predicate.toString());
						                                         tests.assertTrue(msg.results.bindings[0].x.type == 'uri');
						                                         
						                                         tests.assertTrue(msg.results.bindings[0].y != null);
						                                         log.debug("testing y value");
						                                         tests.assertTrue(msg.results.bindings[0].y.value == modifiedStmt1Literal2);
						                                         log.debug("testing y type: " + msg.results.bindings[0].y.type);
						                                         tests.assertTrue(msg.results.bindings[0].y.type == 'literal');
						                                         
			                                                     anzoClient.close(d.getTestErrorWrapper(function(status) {
			                                                         tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
			                                                         d.callback(true);
			                                                     }));
						                                     }));
			                                             }), 2000);
				    	                             }));
				    	                             anzoClient.updateRepository();
			                                     }));
                                             }), 2000);
	                                     }));
	    	                             anzoClient.updateRepository();
	                                 }));
	                             }));
	                             anzoClient.updateRepository();
	                         }));
                         }));
                     }));
                 }));
                 
                 return d;
             }
        },

        {
            name: "test_ServerQuery_QueryAgainstSystemDatasourceIsCached",
            timeout: 40000,
            setUp: function() {
            },
            runTest: function test_ServerQuery_QueryAgainstSystemDatasourceIsCached() {
                // summary: Queries against non-default datasources aren't cached. But the system datasource is considered the default
                //   datasource. So this test ensures that queries that explicitly mentioned the system datasource are cached. 
                //   Note: We reach into private state to check if the cache was used.
                
                 var TestData = new anzo.tests.client.TestData();
                
                 var d = new doh.Deferred();
             
                 var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                 
                 anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                     anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                         tests.assertTrue(suc);
                         anzoClient.begin();
                         anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                             graph.add(TestData.stmt1);
                             anzoClient.commit();
                             
                             tests.assertTrue(graph.contains(TestData.stmt1));
                             
                             var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                 tests.assertTrue(success);
                                 dojo.disconnect(handle);
                                 handle = null;
                                 
                                 tests.assertTrue(graph.contains(TestData.stmt1));
                                 tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                 
                                 var options = {};
                                 options[anzo.client.OPTION_DATASOURCE] = anzo.createURI("http://openanzo.org/datasource/systemDatasource");
                                 
                                 var queryStr = 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
                                 anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                     log.debug("First query finished. success:" + success);
                                     if (!success) {
                                         log.debug("Query execution failed: " + dojo.toJson(error));
                                     }
                                     tests.assertTrue(success);
                                     tests.assertTrue(msg != null);

                                     // We expect this first query to have been a cache miss
                                     tests.assertEqual(0, anzoClient.queryService._cacheHits);
                                     tests.assertEqual(1, anzoClient.queryService._cacheMisses);
                                     tests.assertEqual(1, anzoClient.queryService._resultsCache.size()); // The query should have been cached.

                                     log.debug("About to send second query.");

                                     // Now repeat the query to check if it's cached
                                     anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                         log.debug("Second query finished. success:" + success);
                                         if (!success) {
                                             log.debug("Query execution failed: " + dojo.toJson(error));
                                         }
                                         tests.assertTrue(success);
     
                                         // We expect this second query to have been a cache hit
                                         tests.assertEqual(1, anzoClient.queryService._cacheHits);
                                         tests.assertEqual(1, anzoClient.queryService._cacheMisses);
                                         tests.assertEqual(1, anzoClient.queryService._resultsCache.size());

                                         // Verify that the result set is what we expect it to be
                                         tests.assertTrue(msg != null);

                                         // head
                                         tests.assertTrue(msg.head != null);
                                         tests.assertTrue(msg.head.vars != null);
                                         tests.assertTrue(msg.head.vars[0] == 'x');
                                         tests.assertTrue(msg.head.vars[1] == 'y');
                                         
                                         // results
                                         tests.assertTrue(msg.results != null);
                                         tests.assertTrue(msg.results.bindings != null);
                                         tests.assertTrue(msg.results.bindings[0] != null);
                                         
                                         tests.assertTrue(msg.results.bindings[0].x != null);
                                         tests.assertTrue(msg.results.bindings[0].x.value == TestData.stmt1.predicate.toString());
                                         tests.assertTrue(msg.results.bindings[0].x.type == 'uri');
                                         
                                         tests.assertTrue(msg.results.bindings[0].y != null);
                                         log.debug("testing y value");
                                         tests.assertTrue(msg.results.bindings[0].y.value == TestData.stmt1.object.toString());
                                         log.debug("testing y type: " + msg.results.bindings[0].y.type);
                                         tests.assertTrue(msg.results.bindings[0].y.type == 'literal');
                                         
                                         anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                             tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                             d.callback(true);
                                         }));
                                     }), options);
                                 }), options);
                             }));
                             anzoClient.updateRepository();
                         }));
                     }));
                 }));
                 
                 return d;
             }
         },

        {
           name: "test_ServerQuery_ClientCacheOverflow",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQuery_ClientCacheOverflow() {
               // summary: Test that overflowing the cache removes the older cached item.
               //   Also ensure that the datasetTracker subscription is removed. 
               //   Note: We reach into private state to check if the cache was used.
               
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                // Copy the default properties and set the query cache capacity.
                var properties = {};
                for(var i in anzo.tests.properties) {
                    properties[i] = anzo.tests.properties[i];
                }
                properties.queryCacheCapacity = 1; // Only give space for caching one query

                var anzoClient = new anzo.client.AnzoClient(properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    
                    tests.assertEqual(1, anzoClient.queryService._resultsCache.capacity()); // Reach into private state to make sure that the cache capacity was properly configured.
                    
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);
                            anzoClient.commit();
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;
                        
                                var queryStr = 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
                                anzoClient.serverQuery(TestData.graph1, null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                    log.debug("First query finished. success:" + success);
                                    if (!success) {
                                        log.debug("Query execution failed: " + dojo.toJson(error));
                                    }
                                    tests.assertTrue(success);
                                    tests.assertTrue(msg != null);
        
                                    // We expect this first query to have been a cache miss. NOTE: This is private state that we're checking.
                                    tests.assertEqual(0, anzoClient.queryService._cacheHits);
                                    tests.assertEqual(1, anzoClient.queryService._cacheMisses);
                                    var count = 0;
                                    var datasetKey = null;
                                    for (var i in anzoClient.queryService._activeTrackers) {
                                        count++;
                                        datasetKey = i;
                                    }
                                    tests.assertEqual(1, count); // One subscription to the datasetTracker for the now cached query should exist 
        
                                    log.debug("About to send second query.");
        
                                    // Now send a new query (after waiting a bit to make sure to make the first query clearly older than this upcoming query).
                                    setTimeout(d.getTestErrorWrapper(function() {
                                        var queryStr2 = 'select ?a ?b where { <' + TestData.stmt2.subject.toString() +  '> ?a ?b . }';
                                        anzoClient.serverQuery(null, TestData.graph1, null, queryStr2, null, d.getTestErrorWrapper(function(msg, success, error) {
                                            log.debug("Second query finished. success:" + success);
                                            if (!success) {
                                                log.debug("Query execution failed: " + dojo.toJson(error));
                                            }
                                            tests.assertTrue(success);
        
                                            setTimeout(d.getTestErrorWrapper(function() { // Allow for the LRU cache removal callback to run
                                                // We expect this second query to have been a cache miss and to have kicked out the old query from the cache.
                                                // NOTE: This is private state that we're checking.
                                                tests.assertEqual(0, anzoClient.queryService._cacheHits);
                                                tests.assertEqual(2, anzoClient.queryService._cacheMisses);
                                                var count = 0;
                                                var newDatasetKey = null;
                                                for (var i in anzoClient.queryService._activeTrackers) {
                                                    count++;
                                                    newDatasetKey = i;
                                                }
                                                tests.assertEqual(1, count); // One subscription to the datasetTracker for the now cached query should exist 
                                                tests.assertTrue(datasetKey != newDatasetKey); // The one subscription to the datasetTracker should be different than it used to be since the newly cached query has a new dataset. 
                                                
                                                // Now repeat the second query to ensure it is cached.
                                                anzoClient.serverQuery(null, TestData.graph1, null, queryStr2, null, d.getTestErrorWrapper(function(msg, success, error) {
                                                    log.debug("Third query finished. success:" + success);
                                                    if (!success) {
                                                        log.debug("Query execution failed: " + dojo.toJson(error));
                                                    }
                                                    tests.assertTrue(success);
        
                                                    // We expect this third query to have been a cache hit.
                                                    // NOTE: This is private state that we're checking.
                                                    tests.assertEqual(1, anzoClient.queryService._cacheHits);
                                                    tests.assertEqual(2, anzoClient.queryService._cacheMisses);
                                                    
                                                    // Now repeat the first query to ensure it is NOT cached.
                                                    anzoClient.serverQuery(TestData.graph1, null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                                        log.debug("Fourth query finished. success:" + success);
                                                        if (!success) {
                                                            log.debug("Query execution failed: " + dojo.toJson(error));
                                                        }
                                                        tests.assertTrue(success);
                    
                                                        // We expect this fourth query to have been a cache hit.
                                                        // NOTE: This is private state that we're checking.
                                                        tests.assertEqual(1, anzoClient.queryService._cacheHits);
                                                        tests.assertEqual(3, anzoClient.queryService._cacheMisses);
                                                        
                                                        anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                            d.callback(true);
                                                        }));
                                                    }));
                                                }));
                                            }), 300);
                                        }));
                                    }), 300);
                                }));
                            }));
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ServerQuery_ClientCacheDisabled",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQuery_ClientCacheDisabled() {
               // summary: Test the client properties can disable to client query cache.
               
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                // Copy the default properties and set the query cache to be disabled in the copy
                var properties = {};
                for(var i in anzo.tests.properties) {
                    properties[i] = anzo.tests.properties[i];
                }
                properties.queryCacheEnabled = false;
                
                var anzoClient = new anzo.client.AnzoClient(properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);
                            anzoClient.commit();
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;
                                var queryStr = 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
                                anzoClient.serverQuery(TestData.graph1, null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                    log.debug("First query finished. success:" + success);
                                    if (!success) {
                                        log.debug("Query execution failed: " + dojo.toJson(error));
                                    }
                                    tests.assertTrue(success);
                                    tests.assertTrue(msg != null);
        
                                    // Reach into the private state to ensure that there is no query cache being used
                                    tests.assertTrue(anzoClient.queryService._cacheHits === undefined);
                                    tests.assertTrue(anzoClient.queryService._cacheMisses === undefined);
                                    tests.assertTrue(anzoClient.queryService._resultsCache === undefined);
                                    
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                            }));
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ServerQuery_QueryWithDatasetClauseIsNotCached",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQuery_QueryWithDatasetClauseIsNotCached() {
               // summary: Test that queries with dataset clauses in the query text aren't cached.
               //   Note: We reach into private state to check if the cache was used.
               
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);
                            anzoClient.commit();
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;
                                var queryStr = 'select ?x ?y FROM <' + TestData.graph1.toString() + '> where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
                                anzoClient.serverQuery(null, null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                    log.debug("First query finished. success:" + success);
                                    if (!success) {
                                        log.debug("Query execution failed: " + dojo.toJson(error));
                                    }
                                    tests.assertTrue(success);
                                    tests.assertTrue(msg != null);
        
                                    // We expect this first query to have been a cache miss
                                    tests.assertEqual(0, anzoClient.queryService._cacheHits);
                                    tests.assertEqual(1, anzoClient.queryService._cacheMisses);
        
                                    log.debug("About to send second query.");
        
                                    // Repeat the first query exactly.
                                    anzoClient.serverQuery(null, null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                        log.debug("Second query finished. success:" + success);
                                        if (!success) {
                                            log.debug("Query execution failed: " + dojo.toJson(error));
                                        }
                                        tests.assertTrue(success);
                                        tests.assertTrue(msg != null);
            
                                        // We expect this second query to have also been a cache miss since the query shouldn't have been cached due to its dataset clause
                                        tests.assertEqual(0, anzoClient.queryService._cacheHits);
                                        tests.assertEqual(2, anzoClient.queryService._cacheMisses);
                                        
                                        anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                            d.callback(true);
                                        }));
                                    }));
                                }));
                            }));
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ServerQuery_QueryWithSpecialUriInDatasetIsNotCached",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_ServerQuery_QueryWithSpecialUriInDatasetIsNotCached() {
               // summary: Test that queries with URIs like the allNamedGraphs URI in the dataset lists of URIs aren't cached.
               //   Note: We reach into private state to check if the cache was used.
               
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);
                            anzoClient.commit();
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;
                                var queryStr = 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
                                anzoClient.serverQuery(anzo.client.Vocabulary.allNamedGraphsUri, null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                    log.debug("First query finished. success:" + success);
                                    if (!success) {
                                        log.debug("Query execution failed: " + dojo.toJson(error));
                                    }
                                    tests.assertTrue(success);
                                    tests.assertTrue(msg != null);
        
                                    // We expect this first query to have been a cache miss
                                    tests.assertEqual(0, anzoClient.queryService._cacheHits);
                                    tests.assertEqual(1, anzoClient.queryService._cacheMisses);
        
                                    log.debug("About to send second query.");
        
                                    // Repeat the first query exactly.
                                    anzoClient.serverQuery(TestData.graph1, null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                        log.debug("Second query finished. success:" + success);
                                        if (!success) {
                                            log.debug("Query execution failed: " + dojo.toJson(error));
                                        }
                                        tests.assertTrue(success);
                                        tests.assertTrue(msg != null);
            
                                        // We expect this second query to have also been a cache miss since the query shouldn't have been cached due to the special URI used in the dataset
                                        tests.assertEqual(0, anzoClient.queryService._cacheHits);
                                        tests.assertEqual(2, anzoClient.queryService._cacheMisses);
                                        
                                        anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                            d.callback(true);
                                        }));
                                    }));
                                }));
                            }));
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ExecServerQueryExceptionsInCallbackBug",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
                // summary: An exception in the callback should not cause the callback to be called twice. There
                //   was previously a bug where that happened: http://www.openanzo.org/projects/openanzo/ticket/243

                var d = new doh.Deferred();
                var TestData = new anzo.tests.client.TestData();
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        var callbackCallCount = 0;
                        var queryStr = 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }';
                        anzoClient.serverQuery([TestData.graph1], null, null, queryStr, null, function(msg, success, error) {
                            callbackCallCount++;
                            
                            // We set a timeout to check how many times the callback was called after throwing an exception inside it.
                            if (callbackCallCount <= 1) {
                                setTimeout(d.getTestErrorWrapper(function pollCallbackCallCount() { 
                                    tests.assertEqual(1, callbackCallCount); // The callback must have only be called once!
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }), 1000);
                            }
    
                            throw new Error("test_ExecServerQueryExceptionsInCallbackBug - Purposeful exception to test the behavior of exceptions in callbacks.");
                        });
                    }));
                }));
                
                return d;
            }
        },

        {
           name: "test_ExecServerQueriesExceptionsInCallbackBug",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function test_ExecServerQueriesExceptionsInCallbackBug() {
                // summary: An exception in the callback should not cause the callback to be called twice. There
                //   was previously a bug where that happened: http://www.openanzo.org/projects/openanzo/ticket/243

                var d = new doh.Deferred();
                var TestData = new anzo.tests.client.TestData();
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        var callbackCallCount = 0;
                        var callback = function(msg, success, error) {
                            callbackCallCount++;
                            
                            // We set a timeout to check how many times the callback was called after throwing an exception inside it.
                            if (callbackCallCount <= 1) {
                                setTimeout(d.getTestErrorWrapper(function pollCallbackCallCount() { 
                                    tests.assertEqual(1, callbackCallCount); // The callback must have only be called once!
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }), 1000);
                            }

                            throw new Error("test_ExecServerQueriesExceptionsInCallbackBug - Purposeful exception to test the behavior of exceptions in callbacks.");
                        };
                        var queries = [
                            {   defaultNamedGraphs: [TestData.graph1], namedGraphs: null, namedDatasets: null,
                                query : 'select ?x ?y where { <' + TestData.stmt1.subject.toString() +  '> ?x ?y . }',
                                baseUri: null, callback: callback, timeout: null
                            }
                        ];
                        anzoClient.serverQueries(queries);
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_serverFind",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            log.debug("got replica graph...");
                            
                            graph.add(TestData.stmt1);	
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                log.debug("UpdateRepository complete!!!");
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                
                                log.debug("Calling serverFind");
                                anzoClient.serverFind(TestData.stmt1.subject, null, TestData.stmt1.object, null, d.getTestErrorWrapper(function(stmts, success, error) {
                                    log.debug("serverFind complete - BEGIN");
                                    if (!success) {
                                        log.debug("Server find failed: " + dojo.toJson(error));
                                    }
                                    
                                    tests.assertTrue(success);
                                    tests.assertTrue(stmts != null);
                                    tests.assertTrue(TestData.stmt1.equals(stmts[0]));
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                                
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_replicaFind",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);	
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                
                                tests.assertTrue(TestData.stmt1.equals(anzoClient.replicaFind(TestData.stmt1.subject,null,null,null)[0]));
                                
                                anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                                
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_updateRepositoryOnCommit",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.updateRepositoryOnCommit = true;
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);	
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                
                                graph.close();
                                
                                tests.assertFalse(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertFalse(anzoClient.quadStore.contains(TestData.stmt2));
                                tests.assertError(Error, graph, "contains", [ TestData.stmt1 ]); // After closing the graph, all methods throw an exception
                                tests.assertError(Error, graph, "contains", [ TestData.stmt2 ]); // After closing the graph, all methods throw an exception
                                
                                anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                            }));
                            anzoClient.commit();
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        
        {
           name: "test_getNamedGraphRevision",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);		
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                log.debug("UpdateRepository complete!!!");
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                
                                graph.close();
                                
                                tests.assertFalse(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertFalse(anzoClient.quadStore.contains(TestData.stmt2));
                                tests.assertError(Error, graph, "contains", [ TestData.stmt1 ]); // After closing the graph, all methods throw an exception
                                tests.assertError(Error, graph, "contains", [ TestData.stmt2 ]); // After closing the graph, all methods throw an exception
                                
                                anzoClient.getNamedGraphRevision(TestData.graph1,0,d.getTestErrorWrapper(function(namedGraph, success, error) {
                                    tests.assertTrue(namedGraph.contains(TestData.stmt1));
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                                
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
            name: "test_replicaGraphUpdatesAreReflectedInTransactionQueue",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_replicaGraphUpdatesAreReflectedInTransactionQueue() {
                // summary: The replica graphs should build up changes in a transaction queue and should
                //   reflect those changes immediately via the find/constatins methods. This
                //   test reaches into some private AnzoClient state to look at the transaction queue.
                //   This also tests the reference counting of graphs with the same URI.
    
                var d = new doh.Deferred();
                
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                var queue = anzoClient.transactionQueue;
                
                anzoClient.getReplicaGraph('http://foo', null, d.getTestErrorWrapper(function getReplicaGraphCallback1(graph1, errors) {
                    log.debug("got graph1");
                    tests.assertTrue(graph1.namedGraphUri == 'http://foo');
                    tests.assertEqual(0, graph1.size());
                    
                    tests.assertTrue(graph1.metadataGraph instanceof anzo.client.MetadataGraph);
                    tests.assertTrue(graph1.metadataGraph.namedGraphUri != null);
                    tests.assertTrue(graph1.metadataGraph.size() > 0);
                    
                    tests.assertFalse(anzoClient.inTransaction());
                    anzoClient.begin();
                    tests.assertEqual(1, queue.committedTransactions.length);
                    tests.assertTrue(anzoClient.inTransaction());
                    
                    graph1.add('http://subj1', 'http://pred1', 'http://obj1');
                    graph1.add('http://subj2', 'http://pred2', 'http://obj2');
                    
                    tests.assertTrue(graph1.contains('http://subj1', 'http://pred1', 'http://obj1'));
                    tests.assertTrue(graph1.contains('http://subj2', 'http://pred2', 'http://obj2'));
                    
                    tests.assertTrue(anzoClient.inTransaction());
                    anzoClient.commit();
                    tests.assertEqual(2, queue.committedTransactions.length);
                    tests.assertFalse(anzoClient.inTransaction());
                    
                    tests.assertTrue(graph1.contains('http://subj1', 'http://pred1', 'http://obj1'));
                    tests.assertTrue(graph1.contains('http://subj2', 'http://pred2', 'http://obj2'));
                    tests.assertEqual(2, graph1.size());
                    
                    log.debug("finished adding data to graph1");
                    
                    anzoClient.getReplicaGraph('http://foo', null, d.getTestErrorWrapper(function getReplicaGraphCallback2(graph2, errors) {
                        log.debug("got graph2");
                        tests.assertEqual(2, queue.committedTransactions.length);
                        tests.assertTrue(graph2.namedGraphUri == 'http://foo');
                        tests.assertEqual(2, graph2.size());
                        
                        tests.assertTrue(graph2.metadataGraph instanceof anzo.client.MetadataGraph);
                        tests.assertTrue(graph2.metadataGraph.namedGraphUri != null);
                        
                        graph1.remove('http://subj1', null, null);
                        tests.assertEqual(3, queue.committedTransactions.length);
                        
                        tests.assertFalse(graph1.contains('http://subj1', 'http://pred1', 'http://obj1'));
                        tests.assertFalse(graph2.contains('http://subj1', 'http://pred1', 'http://obj1'));
                        
                        tests.assertFalse(graph1.isClosed());
                        log.debug("closing graph1");
                        graph1.close();
                        tests.assertFalse(graph1.isClosed()); // not yet closed since the reference count is not zero
                        
                        tests.assertFalse(graph2.isClosed()); // not yet closed since the reference count is not zero
                        log.debug("closing graph2");
                        graph2.close();
                        tests.assertTrue(graph2.isClosed());  // closed since reference count is zero
                        
                        anzoClient.getReplicaGraph('http://foo', null, d.getTestErrorWrapper(function getReplicaGraphCallback3(graph3, errors) {
                            log.debug("got graph3");
                            //log.debug("transactions:" + dojo.toJson(anzo.client.Serialization.writeTransactionsToJson(queue.committedTransactions), true));
                            tests.assertEqual(4, queue.committedTransactions.length);
                            tests.assertTrue(graph3.contains('http://subj2', 'http://pred2', 'http://obj2'));
                            tests.assertEqual(1, graph3.size());
                            
                            tests.assertFalse(graph3.isClosed());
                            log.debug("closing graph3");
                            graph3.close();
                            tests.assertTrue(graph3.isClosed()); // closed since reference count is zero
                            
                            d.callback(true);
                        }));
                    }));
                }));
                return d;
            }
        },
                
        {
            name: "test_AnzoClientOpenAndClose",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_AnzoClientOpenAndClose() {
                // summary: Tests a simple connect and close sequence on an AnzoClient
                var d = new doh.Deferred();
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);

                anzoClient.connect(d.getTestErrorWrapper(function(status, errors) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzoClient.close(d.getTestErrorWrapper(function(status) {
                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                        d.callback(true);
                    }));
                }));

                return d;
            }
        },
        {
            name: "test_AddsViaMultipleAnzoClients",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_AddsViaMultipleAnzoClients() {
                // summary: Tests adding  statements to a single named graph but doing so over various
                //   sequential connections to the server using different AnzoClient objects.
                //   The statements should be written out to the server and be replicated once we connect again.
                var d = new doh.Deferred();
                var anzoClient1, anzoClient2, anzoClient3;
                var handle = null;
                var graphURI = 'http://example.org/graph1';
                anzoClient1 = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient1.connect(d.getTestErrorWrapper(function(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient1, d.getTestErrorWrapper(function(suc) {
                        tests.assertTrue(suc);
                        anzoClient1.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback1(graph1) {
                            anzoClient1.begin();
                            graph1.add('http://subj1', 'http://pred1', 'http://obj1');
                            graph1.add('http://subj2', 'http://pred2', 'http://obj2');
                            graph1.add('http://subj2', 'http://pred3', 10);
                            graph1.add('http://subj2', 'http://pred4', anzo.createBNode());
                            anzoClient1.commit();                                                       
                            var updateHandler1 = dojo.connect(anzoClient1, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                dojo.disconnect(updateHandler1);
                                tests.assertTrue(success && errors.length == 0);
                                anzoClient1.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback2(graph1) {
                                    tests.assertEqual(4, graph1.size());
                                    // close dataset service
                                    anzoClient1.close(d.getTestErrorWrapper(function(status) {
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        anzoClient1 = null;
                                        anzoClient2 = new anzo.client.AnzoClient(anzo.tests.properties);
                                        anzoClient2.connect(d.getTestErrorWrapper(function(status, message) {
                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                                            anzoClient2.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback3(graph1) {
                                                graph1.add('http://subj66', 'http://pred1', 'http://obj1');
                                                graph1.add('http://subj66', 'http://pred77', 'http://obj1');
                                                graph1.add('http://subj66', 'http://pred77', true);
                                                graph1.add('http://subj66', 'http://pred77', 4);
                                                graph1.add('http://subj66', 'http://pred77', 'Rouben');
                                                graph1.add('http://subj66', 'http://pred77', 67);
                                                var updateHandler2 = dojo.connect(anzoClient2, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                                    dojo.disconnect(updateHandler2);
                                                    tests.assertTrue(success && errors.length == 0);
                                                    anzoClient2.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback4(graph1) {
                                                        tests.assertEqual(10, graph1.size());
                                                        // close dataset service
                                                        anzoClient2.close(d.getTestErrorWrapper(function(status) {
                                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                            anzoClient2 = null;
                                                            anzoClient3 = new anzo.client.AnzoClient(anzo.tests.properties);
                                                            anzoClient3.connect(d.getTestErrorWrapper(function(status, message) {
                                                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                                                                anzoClient3.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback5(graph1) {
                                                                    graph1.add('http://subj66', 'http://pred1', 'http://obj1');  // <- this statement already exists
                                                                    var updateHandler3 = dojo.connect(anzoClient3, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                                                        dojo.disconnect(updateHandler3);
                                                                        tests.assertTrue(success && errors.length == 0);
                                                                        anzoClient3.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback6(graph1) {
                                                                            tests.assertEqual(10, graph1.size());
                                                                            anzoClient3.close(d.getTestErrorWrapper(function(status) {
                                                                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                                                d.callback(true);
                                                                            }));
                                                                        }));
                                                                    }));
                                                                    anzoClient3.updateRepository();
                                                                }));
                                                            }));
                                                        }));
                                                    }));
                                                }));
                                                anzoClient2.updateRepository();
                                            }));
                                        }));
                                    }));
                                }));
                            }));
                            anzoClient1.updateRepository();
                        }));
                    }));
                }));
                return d;
            }
        },

        {
            name: "test_AddsAndRemovesViaMultipleAnzoClients",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_AddsAndRemovesViaMultipleAnzoClients() {
                // summary: Tests adding and removing statements to a single named graph but doing so over various
                //   sequential connections to the server using different AnzoClient objects.
                //   The changes should be written out to the server and be replicated once we connect again.
                var d = new doh.Deferred();
                var anzoClient1, anzoClient2, anzoClient3;
                var graphURI = 'http://example.org/graph2';
                anzoClient1 = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient1.connect(d.getTestErrorWrapper(function(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient1, d.getTestErrorWrapper(function(suc) {
                        log.debug("test_AddsAndRemovesViaMultipleAnzoClients - finished reset. success:" + suc);
                        tests.assertTrue(suc);
                        anzoClient1.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback1(graph1) {
                            log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in getReplicaGraphCallback1. graph1 is null?:" + (graph1 == null));
                            anzoClient1.begin();
                            graph1.add('http://subj1', 'http://pred1', 'http://obj1');
                            graph1.add('http://subj2', 'http://pred2', 'http://obj2');
                            graph1.add('http://subj2', 'http://pred3', 10);
                            graph1.add('http://subj2', 'http://pred4', anzo.createBNode());
                            anzoClient1.commit();                                                       
                            var updateHandler1 = dojo.connect(anzoClient1, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in updateHandler1. success:" + success);
                                dojo.disconnect(updateHandler1);
                                tests.assertTrue(success && errors.length == 0);
                                anzoClient1.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback2(graph1) {
                                    log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in getReplicaGraphCallback2. graph1 is null?:" + (graph1 == null));
                                    tests.assertEqual(4, graph1.size());
                                    // close dataset service
                                    anzoClient1.close(d.getTestErrorWrapper(function(status) {
                                        log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in close callback 1 - status:" + status);
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        anzoClient1 = null;
                                        anzoClient2 = new anzo.client.AnzoClient(anzo.tests.properties);
                                        anzoClient2.connect(d.getTestErrorWrapper(function(status, message) {
                                            log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in connect for anzoClient2 - status:" + status);
                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                                            anzoClient2.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback3(graph1) {
                                                log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in getReplicaGraphCallback3. graph1 is null?:" + (graph1 == null));
                                                tests.assertEqual(4, graph1.size()); // Make sure the statements are there even when we connected with a new client
                                                graph1.remove('http://subj1', 'http://pred1', 'http://obj1');
                                                graph1.remove('http://subj2', 'http://pred2', 'http://obj2');
                                                graph1.remove('http://subj2', 'http://pred3', 10);
                                                graph1.remove('http://subj2', 'http://pred4', null);
                                                tests.assertEqual(0, graph1.size());
                                                var updateHandler2 = dojo.connect(anzoClient2, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                                    log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in updateHandler2. success:" + success);
                                                    dojo.disconnect(updateHandler2);
                                                    tests.assertTrue(success && errors.length == 0);
                                                    anzoClient2.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback4(graph1) {
                                                        log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in getReplicaGraphCallback4. graph1 is null?:" + (graph1 == null));
                                                        tests.assertEqual(0, graph1.size());
                                                        // close dataset service
                                                        anzoClient2.close(d.getTestErrorWrapper(function(status) {
                                                            log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in close callback 2 - status:" + status);
                                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                            anzoClient2 = null;
                                                            anzoClient3 = new anzo.client.AnzoClient(anzo.tests.properties);
                                                            anzoClient3.connect(d.getTestErrorWrapper(function(status, message) {
                                                                log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in connect for anzoClient3 - status:" + status);
                                                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                                                                anzoClient3.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback5(graph1) {
                                                                    log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in getReplicaGraphCallback5. graph1 is null?:" + (graph1 == null));
                                                                    tests.assertEqual(0, graph1.size()); // There should still be no statements here since we removed them earlier
                                                                    graph1.add('http://subj66', 'http://pred1', 'http://obj1'); 
                                                                    tests.assertEqual(1, graph1.size());
                                                                    var updateHandler3 = dojo.connect(anzoClient3, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                                                        log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in updateHandler3. success:" + success);
                                                                        dojo.disconnect(updateHandler3);
                                                                        tests.assertTrue(success && errors.length == 0);
                                                                        tests.assertEqual(1, graph1.size());
                                                                        anzoClient3.getReplicaGraph(graphURI, null, d.getTestErrorWrapper(function getReplicaGraphCallback6(graph1) {
                                                                            log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in getReplicaGraphCallback6. graph1 is null?:" + (graph1 == null));
                                                                            tests.assertEqual(1, graph1.size());
                                                                            anzoClient3.close(d.getTestErrorWrapper(function(status) {
                                                                                log.debug("test_AddsAndRemovesViaMultipleAnzoClients - in close callback 3 - status:" + status);
                                                                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                                                d.callback(true);
                                                                            }));
                                                                        }));
                                                                    }));
                                                                    anzoClient3.updateRepository();
                                                                }));
                                                            }));
                                                        }));
                                                    }));
                                                }));
                                                anzoClient2.updateRepository();
                                            }));
                                        }));
                                    }));
                                }));
                            }));
                            anzoClient1.updateRepository();
                        }));
                    }));
                }));
                return d;
            }
        },

        {
           name: "test_StatementAddedEventsAreFiredOnUpdateRespository",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function test_StatementAddedEventsAreFiredOnUpdateRespository() {
               // summary: Replica graphs expose events which fire when statements are added or removed.
               //   This test verifies that those events fire for adding statement. They should NOT fire when
               //   added to the transaction queue. They should fire only when actually written out to the server.
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                    
                        anzoClient.begin();
                        anzoClient.getReplicaGraph('http://foo', null, d.getTestErrorWrapper(function(graph1, errors) {
                        
                            var metadataUpdateCount = 0;
                            var updateCount = 0;
    
                            dojo.connect(graph1.metadataGraph, 'statementsAdded', d.getTestErrorWrapper(function metadataGraphStatementAdded(stmts) {
                                //log.debug("metadata stmts:" + dojo.toJson(stmts, true));
                                metadataUpdateCount += stmts.length;
                            }));
                            
                            dojo.connect(graph1, 'statementsAdded', d.getTestErrorWrapper(function graphStatementAdded(stmts) {
                                //log.debug("stmts:" + dojo.toJson(stmts, true));
                                updateCount += stmts.length;
                            }));
                            
                            graph1.add('http://subj1', 'http://pred1', 'http://obj1');
                            graph1.add('http://subj2', 'http://pred2', 'http://obj2');
                            graph1.add('http://subj2', 'http://pred3', 10);
                            graph1.add('http://subj2', 'http://pred4', anzo.createBNode());
                            anzoClient.commit();
                            
                            tests.assertEqual(0, metadataUpdateCount);
                            tests.assertEqual(0, updateCount);

                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success && errors.length == 0);
                                dojo.disconnect(handle);
    
                                tests.assertEqual(0, anzoClient.transactionQueue.committedTransactions.length);
                                
                                var metadataGraph = graph1.metadataGraph;
                                
                                tests.assertEqual(17, metadataUpdateCount);
                                tests.assertEqual(17, metadataGraph.size());
                                tests.assertEqual(4, graph1.size());
                                tests.assertEqual(4, updateCount);
                                tests.assertTrue(graph1.contains('http://subj1', 'http://pred1', 'http://obj1'));
                                tests.assertTrue(graph1.contains('http://subj2', 'http://pred3', 10));
                                
                                var stmts = graph1.find('http://subj2', 'http://pred4', null);
                                tests.assertTrue(stmts.length == 1 && stmts[0].object instanceof anzo.rdf.BNode);
    
                                anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                            }));								
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_StatementRemovedEventsAreFiredOnReplication",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function test_StatementRemovedEventsAreFiredOnReplication() {
               // summary: Replica graphs expose events which fire when statements are added or removed.
               //   This test verifies that those events fire for removing statements. They should NOT fire when
               //   added to the transaction queue. They should fire only when actually written out to the server.
               
                var d = new doh.Deferred();
                
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);

                        var addCount = 0;
                        var removeCount = 0;

                        anzoClient.getReplicaGraph('http://foo2', null, d.getTestErrorWrapper(function(graph1, errors) {
                        
                            dojo.connect(graph1,'statementsAdded', function(stmts) {
                                addCount += stmts.length;
                            });
                            
                            dojo.connect(graph1,'statementsRemoved', function(stmts) {
                                removeCount += stmts.length;
                            });
                            
                            anzoClient.begin();
                            graph1.add('http://subj1', 'http://pred1', 'http://obj1');
                            graph1.add('http://subj2', 'http://pred2', 'http://obj2');
                            graph1.add('http://subj2', 'http://pred3', 10);
                            graph1.add('http://subj2', 'http://pred4', anzo.createBNode());
                            anzoClient.commit();			

                            tests.assertEqual(0, addCount);
                            
                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success && errors.length == 0);
                                dojo.disconnect(handle);
                                
                                tests.assertEqual(4, addCount);

                                anzoClient.begin();

                                graph1.remove('http://subj2', 'http://pred2', 'http://obj2');
                                graph1.remove('http://subj2', 'http://pred3', 10);
                                var bnodeStatements = graph1.find('http://subj2', 'http://pred4', null);
                                tests.assertEqual(1, bnodeStatements.length);
                                graph1.remove('http://subj2', 'http://pred4', bnodeStatements[0].object);

                                tests.assertEqual(0, removeCount);

                                anzoClient.commit();
                                var handle2 = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                    tests.assertTrue(success && errors.length == 0);
                                    dojo.disconnect(handle2);
                                    
                                    tests.assertEqual(3, removeCount);
                                    
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                                anzoClient.updateRepository();
                            }));
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_closingReplicaGraphsRemovesStatementsFromReplica",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function test_closingReplicaGraphsRemovesStatementsFromReplica() {
               // summary: When all replica graph references to a particular named graph are closed,
               //   then that graph's statements should be removed from the client state. This test reaches
               //   into anzoClient private state (the quad store) to make sure it's cleaning up statements
               //   that are no longer relevant.
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);

                        anzoClient.getReplicaGraph('http://foo3', null, d.getTestErrorWrapper(function onGetReplicaGraphComplete(graph1, errors) {

                            var addCount = 0;
                        
                            dojo.connect(graph1, 'statementsAdded', function(stmts) {
                                addCount+= stmts.length;
                            });
                            
                            anzoClient.begin();
                            graph1.add('http://subj1', 'http://pred1', 'http://obj1');
                            graph1.add('http://subj2', 'http://pred2', 'http://obj2');
                            graph1.add('http://subj2', 'http://pred3', 10);
                            graph1.add('http://subj2', 'http://pred4', anzo.createBNode());
                            anzoClient.commit();			

                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success && errors.length == 0);
                                dojo.disconnect(handle);
                                
                                // Make sure the statements were added to the replica                                
                                tests.assertEqual(4, addCount);
                                var stmts = anzoClient.quadStore.find(null, null, null, ["http://foo3"]);
                                tests.assertEqual(4, stmts.length);

                                graph1.close();

                                // After closing the last reference to the replica graph, the quad store
                                // shouldn't contain the statements anymore.                                
                                var stmts = anzoClient.quadStore.find(null, null, null, ["http://foo3"]);
                                tests.assertEqual(0, stmts.length);

                                // It shouldn't even contain any statements at all since this was the only graph we obtained.
                                var stmts = anzoClient.quadStore.find(null, null, null, null);	
                                tests.assertEqual(0, stmts.length);

                                anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                            }));
                            anzoClient.updateRepository();
                        }));                    
                    }));                        
                }));                        
                
                return d;
            }
        },
        
        {
           name: "test_ExecuteService",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties.sysadmin);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                    
                        var serviceUri = anzo.createURI("http://openanzo.org/semanticServices/echoService#echo");
                        
                        var stmts = new Array();
                        stmts.push(TestData.stmt1);
                        stmts.push(TestData.stmt2);
                        stmts.push(TestData.stmt3);
                        stmts.push(TestData.stmt4);
                        
                        anzoClient.executeService(serviceUri, stmts, d.getTestErrorWrapper(function executionComplete(stmts, success, error) {
                            tests.assertTrue(success);
                            var quadStore = new anzo.rdf.QuadStore();
                            quadStore.add(stmts);
                            tests.assertTrue(quadStore.contains(TestData.stmt1));
                            tests.assertTrue(quadStore.contains(TestData.stmt2));
                            tests.assertTrue(quadStore.contains(TestData.stmt3));
                            tests.assertTrue(quadStore.contains(TestData.stmt4));
                            anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                d.callback(true);
                            }));
                        }));
                        
    
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_metadataGraphEdit",
           timeout: 20000,
           setUp: function() {
           },
           runTest: function test_metadataGraphEdit() {
               // summary: Attempt to remove a statement from the metadata graph and validate that it did.
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("connect complete.");
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        log.debug("reset complete:" + suc);
                        tests.assertTrue(suc);

                        anzoClient.getReplicaGraph('http://foo3', null, d.getTestErrorWrapper(function onGetReplicaGraphComplete(graph1, errors) {
                            log.debug("got replica graph.");
                            anzoClient.begin();
                            graph1.add('http://subj1', 'http://pred1', 'http://obj1');
                            anzoClient.commit();			

                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("update repository complete:" + success);
                                tests.assertTrue(success && errors.length == 0);
                                dojo.disconnect(handle);
                                handle = null;
                                
                                // Make sure the statements were added to the replica                                
                                var stmts = anzoClient.quadStore.find(null, null, null, ["http://foo3"]);
                                tests.assertEqual(1, stmts.length);
                                
                                tests.assertEqual(1, graph1.metadataGraph.find(graph1.namedGraphUri, anzo.client.Vocabulary.canBeRemovedFromByProperty, null).length);

                                anzoClient.begin();
                                graph1.metadataGraph.remove(graph1.namedGraphUri, anzo.client.Vocabulary.canBeRemovedFromByProperty, null);
                                anzoClient.commit();

                                log.debug("Removed a metadata graph statement...checking if it's gone.");
                                tests.assertEqual(0, graph1.metadataGraph.find(graph1.namedGraphUri, anzo.client.Vocabulary.canBeRemovedFromByProperty, null).length);
                                
                                var handle2 = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                    log.debug("updateRepositoryComplete.");
                                    tests.assertTrue(success && errors.length == 0);
                                    dojo.disconnect(handle2);
                                    handle2 = null;

                                    log.debug("Checking if metadata graph statement is still gone.");
                                    tests.assertEqual(0, graph1.metadataGraph.find(graph1.namedGraphUri, anzo.client.Vocabulary.canBeRemovedFromByProperty, null).length);
                                    
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                
                                }));
                                log.debug("Updating repository...sending removal of metadata graph statement to server.");
                                anzoClient.updateRepository();
                            }));
                            anzoClient.updateRepository();
                        }));                    
                    }));                        
                }));                        
                
                return d;
            }
        },
        
        {
           name: "test_StatementChannel",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties.sysadmin);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                    
                        var channelUri = TestData.graph1;
                        
                        var stmts = [];
                        stmts.push(TestData.stmt1);
                        stmts.push(TestData.stmt2);
                        stmts.push(TestData.stmt3);
                        stmts.push(TestData.stmt4);
                        
                        var props = {};
                        props["foo"] = "bar";
                        
                        anzoClient.getStatementChannel(channelUri,  d.getTestErrorWrapper(function(success,error) {
                        		tests.assertTrue(success && error == null);
								anzoClient.updateRepository();
							}), d.getTestErrorWrapper(function channelComplete(channel, error) {
                        	
                        	log.debug("Statment channel created...");
                        	
                            tests.assertTrue(channel != null);
                            
                            	
                        	var rev = anzo.createTypedLiteral(false,anzo.rdf.vocabulary.XMLSchema.xsBoolean);
                        	tests.assertTrue(channel.namedGraph.metadataGraph.contains(TestData.graph1,anzo.client.Vocabulary.revisionedProperty,rev));
                        
                            var listener = function(properties, statements) {
                                log.debug("received message on channel");
                                tests.assertEqual("bar",properties["foo"]);
                                var quadStore = new anzo.rdf.QuadStore();
                                quadStore.add(statements);
                                tests.assertTrue(quadStore.contains(TestData.stmt1));
                                tests.assertTrue(quadStore.contains(TestData.stmt2));
                                tests.assertTrue(quadStore.contains(TestData.stmt3));
                                tests.assertTrue(quadStore.contains(TestData.stmt4));
                                
                                channel.unregisterListener(listener, d.getTestErrorWrapper(function unregisterComplete(success, error) {
                                    log.debug("unregisterComplete");
                                    tests.assertTrue(success);
                                    
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                                
                            }
                            
                            channel.registerListener(listener, d.getTestErrorWrapper(function registerComplete(success, error) {
                                log.debug("registerComplete");
                                tests.assertTrue(success);
                                channel.sendMessage(props,stmts, d.getTestErrorWrapper(function sendComplete(success, error) {
                                    log.debug("sendComplete");
                                    tests.assertTrue(success);
                                }));
                                    
                            }));
                            
                        }), [anzoClient.getRevisionedGraphInitializer(false)]);
    
                    }));
                }));
                
                return d;
            }
        },
      
        {
            name: "test_ContainsNamedGraph",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_NewReplicaGraph() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            
                            
                            graph.add(TestData.stmt1);
                            anzoClient.commit();
                            
                            
                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success && errors.length == 0);
                                dojo.disconnect(handle);
                                
                                anzoClient.containsNamedGraph(TestData.graph1,d.getTestErrorWrapper(function(result, success, error) {
                                    
                                    tests.assertTrue(result);
                                   
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                                
                            }));
                            anzoClient.updateRepository();
                        }));
                        
                    }));
                }));
                
                return d;
            }
        },
        
        {
            name: "test_RemoveGraph",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_RemoveGraph() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties.sysadmin);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            graph.add(TestData.stmt1);
                            anzoClient.commit();
                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                dojo.disconnect(handle);
                                tests.assertTrue(success && errors.length == 0);
                                
                                anzoClient.containsNamedGraph(TestData.graph1,d.getTestErrorWrapper(function(result, success, error) {
                                    tests.assertTrue(result);
                                    
                                    anzoClient.begin();
                                    graph.metadataGraph.remove(TestData.graph1,anzo.rdf.vocabulary.RDF.type,anzo.client.Vocabulary.namedGraphType);
                                    anzoClient.commit();
                                    var handle2 = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                        dojo.disconnect(handle2);
                                        if (errors && errors.length > 0) {
                                            log.debug("ERROR REMOVING GRAPH: " + dojo.toJson(errors, true))
                                        }
                                        
                                        tests.assertTrue(success && errors.length == 0);
                                        
                                        anzoClient.containsNamedGraph(TestData.graph1,d.getTestErrorWrapper(function(result, success, error) {
                                            tests.assertFalse(result);
                                    
                                            anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                d.callback(true);
                                            }));
                                        }));
                                    }));
                                    anzoClient.updateRepository();
                                }));
                                
                            }));
                            anzoClient.updateRepository();
                        }));
                        
                    }));
                }));
                
                return d;
                
                return d;
            }
        },
        
        {
           name: "test_LocalTransactionEvents",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    log.debug("Client connected: " + status);
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        log.debug("reset complete: " + status);
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            log.debug("replica graph retrieved");
                            anzoClient.getTransactionContext().add(TestData.stmt5);
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);	
                            anzoClient.begin();
                            anzoClient.getTransactionContext().add(TestData.stmt6);
                            graph.add(TestData.stmt3);
                            graph.add(TestData.stmt4);			
                            anzoClient.commit();
                            anzoClient.commit();

                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            tests.assertTrue(graph.contains(TestData.stmt3));
                            tests.assertTrue(graph.contains(TestData.stmt4));
                            
                            var transactions = new Array();
                            var context = null;
                            var graphs = null;
                            var eventHandle = dojo.connect(anzoClient,"transactionComplete", d.getTestErrorWrapper(function(transactionURI, transactionTimestamp, transactionGraphs, transactionContext){
                                log.debug("transactionComplete context:" + transactionContext);
                                transactions.push(transactionURI);
                                context = transactionContext;
                                graphs = transactionGraphs;
                            }));
                            
                            var handle2 = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                dojo.disconnect(handle2);
                                
                                tests.assertTrue(graph.contains(TestData.stmt1));
                                tests.assertTrue(graph.contains(TestData.stmt2));
                                tests.assertTrue(graph.contains(TestData.stmt3));
                                tests.assertTrue(graph.contains(TestData.stmt4));
                                
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt3));
                                tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt4));
                                
                                log.debug("Testing transaction events...");
                                
                                tests.assertTrue(context != null);
                                tests.assertEqual(2,context.find().length);
                                tests.assertEqual(1,transactions.length);
                                tests.assertEqual(1, graphs.length);
                                tests.assertEqual("http://test.example.com/test#namedGraph1", graphs[0]);
                                
                                anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                                
                            }));
                            anzoClient.updateRepository();
    
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_FailedTransactionEvents",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
               
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    log.debug("Client connected: " + status);
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        log.debug("reset complete: " + status);
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, {create: true, namedGraphInitializers: [anzoClient.getGraphMustExistInitializer(true)]}, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            anzoClient.getTransactionContext().add(TestData.stmt5);
                            graph.add(TestData.stmt1);	
                            graph.add(TestData.stmt2);	
                            anzoClient.begin();
                            anzoClient.getTransactionContext().add(TestData.stmt6);
                            graph.add(TestData.stmt3);
                            graph.add(TestData.stmt4);			
                            anzoClient.commit();
                            anzoClient.commit();
                            
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            tests.assertTrue(graph.contains(TestData.stmt2));
                            tests.assertTrue(graph.contains(TestData.stmt3));
                            tests.assertTrue(graph.contains(TestData.stmt4));
                            
                            anzoClient.begin();
                            anzoClient.getReplicaGraph(TestData.graph2, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                                anzoClient.getTransactionContext().add(TestData.stmt5);
                                graph.add(TestData.stmt1);	
                                graph.add(TestData.stmt2);	
                                anzoClient.begin();
                                anzoClient.getTransactionContext().add(TestData.stmt6);
                                graph.add(TestData.stmt3);
                                graph.add(TestData.stmt4);			
                                anzoClient.commit();
                                anzoClient.commit();
                                
                                var transactions = new Array();
                                var context = null;
                                var graphs = null;
                                
                                var f_transactions = new Array();
                                var f_context = null;
                                var f_graphs = null;
                                
                                var eventHandle = dojo.connect(anzoClient,"transactionComplete", d.getTestErrorWrapper(function(transactionURI, transactionTimestamp, transactionGraphs, transactionContext){
                                    log.debug("transactionComplete context:" + transactionContext);
                                    transactions.push(transactionURI);
                                    context = transactionContext;
                                    graphs = transactionGraphs;
                                }));
                                
                                var eventHandle1 = dojo.connect(anzoClient,"transactionFailed", d.getTestErrorWrapper(function(transactionURI, transactionGraphs, transactionContext, errors){
                                    log.debug("transactionFailed errors:" + dojo.toJson(errors,true));
                                    f_transactions.push(transactionURI);
                                    f_context = transactionContext;
                                    f_graphs = transactionGraphs;
                                }));
                                
                                var handle2 = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                    dojo.disconnect(handle2);
                                    
                                    log.debug("Testing transaction events...");
                                    
                                    tests.assertTrue(f_context != null);
                                    tests.assertEqual(2,f_context.find().length);
                                    tests.assertEqual(1,f_transactions.length);
                                    tests.assertEqual(1, f_graphs.length);
                                    tests.assertEqual("http://test.example.com/test#namedGraph1", f_graphs[0]);
                                    
                                    tests.assertTrue(context != null);
                                    tests.assertEqual(2,context.find().length);
                                    tests.assertEqual(1,transactions.length);
                                    tests.assertEqual(1, graphs.length);
                                    tests.assertEqual("http://test.example.com/test#namedGraph2", graphs[0]);
                                    
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                    
                                }));
                                anzoClient.updateRepository();
                            }), true, [anzoClient.getGraphMustExistInitializer(false)]);
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
            name: "test_EmptyTransaction",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_NewReplicaGraph() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("Client connected successfully");
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        log.debug("Reset successfull");
                        anzoClient.begin();
                        anzoClient.commit();
                        anzoClient.begin();
                        anzoClient.commit();
                        anzoClient.begin();
                        anzoClient.commit();
                            
                        var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                            tests.assertTrue(success);
                            dojo.disconnect(handle);
                            anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                d.callback(true);
                            }));
                        }));
                        anzoClient.updateRepository();
    
                    }));
                }));
                
                return d;
            }
        },
        
        {
            name: "test_ClientRoles",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_ClientRoles() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("Client connected successfully");
                    var everyone = anzo.createURI("http://openanzo.org/Role/everyone");
                    tests.assertTrue(anzoClient.userRoles.contains(everyone));
                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                        d.callback(true);
                    }));
                }));
                
                return d;
            }
        },

        {
            name: "test_IsSysadminIsFalseForNonSysadmin",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_IsSysadminIsFalseForNonSysadmin() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("Client connected successfully");
                    tests.assertTrue(anzoClient.isSysadmin === false);
                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                        d.callback(true);
                    }));
                }));
                
                return d;
            }
        },

        {
            name: "test_IsSysadminIsTrueForSysadmin",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_IsSysadminIsTrueForSysadmin() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties.sysadmin);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("Client connected successfully");
                    tests.assertTrue(anzoClient.isSysadmin === true);
                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                        d.callback(true);
                    }));
                }));
                
                return d;
            }
        },

        {
            name: "test_GraphPermissionsAsDefault",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_GraphPermissions() {
            	return test_graphPermissions(anzo.tests.properties)
            }
        },
        
        {
            name: "test_GraphPermissionsAsSysadmin",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_GraphPermissions() {
            	return test_graphPermissions(anzo.tests.properties.sysadmin)
            }
        },
        
        {
            name: "test_AddingMultipleNewGraphsAtOnce",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_AddingMultipleNewGraphsAtOnce() {
                // summary: Make sure that sending two graphs up to the server at once works.
                //   This is here because of a previous bug that caused the ReplicaUpdater to
                //   only look at the first message in the replication response.
                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function(g1) {
                            anzoClient.getReplicaGraph(TestData.graph2, null, d.getTestErrorWrapper(function(g2) {
                                
                                g1.add(TestData.subj1, TestData.pred1, TestData.obj1);
                                g2.add(TestData.subj2, TestData.pred2, TestData.obj2);
                                
                                // Sanity check that the statement we just added exists is found in the replica.
                                // It will show up here really because it's in the transaction queue.
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);

                                var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                    tests.assertTrue(success);
                                    dojo.disconnect(handle);
                                    
                                    log.debug("checking");
                                    tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                                    tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
                                    log.debug("passed, nice");
                                    
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                                
                                anzoClient.updateRepository(); 
                            }));
                        }));
                    }));
                }));
                
                return d;
            }
        },        
        
        {
            name: "test_disconnectedAnzoClientRetainsGraphData",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_disconnectedAnzoClientRetainsGraphData() {
                // summary: We'll create some graph data and then disconnect the AnzoClient.
                //   The graph data should remain accessible on the disconnected anzoClient.
                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function(g1) {
                            
                            g1.add(TestData.subj1, TestData.pred1, TestData.obj1);
                            g1.add(TestData.subj2, TestData.pred2, TestData.obj2);
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                                tests.assertTrue(g1.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                tests.assertTrue(g1.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                
                                // Now that we've sent the graph updates up to the repository, let's add a statement
                                // to the transaction queue so that we can check if the transaction queue is maintained
                                // after the disconnect.
                                g1.add(TestData.subj3, TestData.pred3, TestData.obj3);
                                
                                anzoClient.disconnect(d.getTestErrorWrapper(function(status) {
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    
                                    // Test that the graph is still valid and contains data even after the disconnect
                                    tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
                                    tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                                    tests.assertTrue(anzoClient.replicaFind(TestData.subj3, TestData.pred3, TestData.obj3).length == 1);
                                    tests.assertTrue(g1.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                    tests.assertTrue(g1.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                    tests.assertTrue(g1.contains(TestData.subj3, TestData.pred3, TestData.obj3));
                                    
                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }));
                            }));
                            
                            anzoClient.updateRepository(); 
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
            name: "test_reconnectedAnzoClientGetsGraphUpdates",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_reconnectedAnzoClientGetsGraphUpdates() {
                // summary: We'll create some graph data and then disconnect the AnzoClient.
                //   We'll then immediately reconnect it and change the graph on the server directly via
                //   the JMSUpdateService (to simulate another client having changed the data).
                //   We expect the reconnected anzoClient to have received the updates because it
                //   reconnected to the named graph update topics.
                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function(g1) {
                            
                            g1.add(TestData.subj1, TestData.pred1, TestData.obj1);
                            g1.add(TestData.subj2, TestData.pred2, TestData.obj2);
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("updateRepositoryComplete");
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                                tests.assertTrue(g1.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                tests.assertTrue(g1.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                
                                log.debug("about to anzoClient.disconnect");
                                anzoClient.disconnect(d.getTestErrorWrapper(function(status) {
                                    log.debug("disconnected");
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    
                                    anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                                        log.debug("reconnected");
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

                                        // Now modify the graph directly via the JMSUpdateService to simulate another client having made a change.
                                        anzo.tests.utilities.rawUpdateRepository([TestData.stmt3, TestData.stmt4], true, d.getTestErrorWrapper(function onRawUpdateRepository(updateResults, success, errors) {
                                            tests.assertTrue(success);

                                            var pollCount = 0;
                                            var checkGraphUpdateArrived = d.getTestErrorWrapper(function _checkGraphUpdateArrived() {
                                                pollCount++;
                                                var gotStatement3 = g1.contains(TestData.stmt3);
                                                var gotStatement4 = g1.contains(TestData.stmt4);
                                                log.debug((gotStatement3 ? "Got statement 3. " : "Waiting for statement 3. ") + (gotStatement4 ? "Got statement 4. " : "Waiting for statement 4. "));
                                                if (gotStatement3 && gotStatement4) {
                                                    log.debug("Got all statements we wanted.");
                                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                        d.callback(true);
                                                    }));
                                                } else {
                                                    if (pollCount < 5) {
                                                        log.debug("All statements haven't arrived. Polling again...");
                                                        setTimeout(checkGraphUpdateArrived, 1000);
                                                    } else {
                                                        throw new Error("Expected statements didn't arrive.");
                                                    }
                                                }
                                            });
                                            setTimeout(checkGraphUpdateArrived, 1000);
                                        }));
                                    }));
                                }));
                            }));
                            
                            anzoClient.updateRepository(); 
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
            name: "test_connectAndDisconnectEventsAreFired",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_connectAndDisconnectEventsAreFired() {
                // summary: Connects and disconnects the AnzoClient and connects and closes the anzoClient to
                //  make sure the appropriate connection and disconnection events are fired.
                
                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);

                var clientConnectedEventFired = false;
                var clientConnectedHandle = dojo.connect(anzoClient, "clientConnected", d.getTestErrorWrapper(function() {
                    tests.assertFalse(clientConnectedEventFired); // ensure it's not fired in duplicate
                    clientConnectedEventFired = true; 
                }));
                
                var clientDisconnectedEventFired = false;
                var clientDisonnectedHandle = dojo.connect(anzoClient, "clientDisconnected", d.getTestErrorWrapper(function() {
                    tests.assertFalse(clientDisconnectedEventFired); // ensure it's not fired in duplicate
                    clientDisconnectedEventFired = true; 
                }));
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("connected the first time");
                    
                    tests.assertTrue(clientConnectedEventFired);

                    anzoClient.disconnect(d.getTestErrorWrapper(function(status) {
                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                        log.debug("disconnected the first time");

                        tests.assertTrue(clientDisconnectedEventFired);

                        // Now connect again and this time disconnect by calling 'close'.
                        clientConnectedEventFired = false;
                        clientDisconnectedEventFired = false;
                       
                        anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                            log.debug("reconnected");

                            tests.assertTrue(clientConnectedEventFired);
                            
                            anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                log.debug("closed");

                                tests.assertTrue(clientDisconnectedEventFired);
                                
                                d.callback(true);
                            }));
                        }));
                    }));
                }));
                
                return d;
            }
        },
        {
            name: "test_reconnectProperlyRemovesStatementsFromReplica",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function() {
                // summary: This test will create a graph and fill it with some statements on the server.
                //   Then we'll disconnect the anzoClient. Using raw commands via the JMSUpdateService to simulate
                //   a second user, we'll then remove some statements on the graph on the server. After that, we'll reconnect
                //   the anzoClient and assert that those statements are properly removed from the replica upon reconnection.

                return test_reconnectProperlyRemovesStatementsFromReplica(false);
            }
        },

        {
            name: "test_nonRevisionedGraphsAreReplicatedProperly",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_nonRevisionedGraphsAreReplicatedProperly() {
                // summary: non-revisioned graphs can't support the full replicate functionality where
                //  only the differences between particular revisions are returned. Since the old data isn't
                //  maintained, the replicate response will simply contain all of the current data. So the code
                //  must recognize this and replace the replica data with the data from the replicate response.
                //  This test ensures this happens by creating a non-revisioned graph, then disconnecting the graph
                //  and making some edits to the graph directly via the JMSUpdateService (to simulate another client
                //  having made the updates). When reconnecting, the anzoClient should have the up-to-date
                //  correct data from the server.
                //  See http://www.openanzo.org/projects/openanzo/ticket/396
                
                return test_reconnectProperlyRemovesStatementsFromReplica(true);
            }
        },

        {
            name: "test_graphUpdatesForNonRevisionedGraphs",
            timeout: 30000,
            setUp: function() {
            },
            runTest: function test_graphUpdatesForNonRevisionedGraphs() {
                // summary: We'll create a non-revisioned graph and then make some changes to it
                //   directly via the JMSUpdateService (to simulate another client having changed the data).
                //   We expect the replica graph to be updated by the graph update messages. In particular
                //   we must ensure that the updates include removes to make sure stale statements aren't
                //   left around. 

                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        
                        anzoClient.getReplicaGraph(TestData.graph1, {create: true, namedGraphInitializers: [ anzoClient.getRevisionedGraphInitializer(false) ]}, d.getTestErrorWrapper(function(g1) {
                            
                            g1.add(TestData.subj1, TestData.pred1, TestData.obj1);
                            g1.add(TestData.subj2, TestData.pred2, TestData.obj2);
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("updateRepositoryComplete");
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                                tests.assertTrue(g1.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                tests.assertTrue(g1.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                
                                // Now modify the graph directly via the JMSUpdateService to simulate another client having made a change.
                                anzo.tests.utilities.rawUpdateRepository([TestData.stmt3, TestData.stmt4], true, d.getTestErrorWrapper(function onRawUpdateRepository(updateResults, success, errors) {
                                    tests.assertTrue(success);

                                    log.debug("Did first raw update (additions)");
                                    anzo.tests.utilities.rawUpdateRepository([ anzo.createStatement(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1) ], false, d.getTestErrorWrapper(function onRawUpdateRepository2(updateResults, success, errors) {
                                        tests.assertTrue(success);

                                        log.debug("Did second raw update (deletion)");

                                        var pollCount = 0;
                                        var checkGraphUpdateArrived = d.getTestErrorWrapper(function _checkGraphUpdateArrived() {
                                            pollCount++;
                                            var gotStatement3 = g1.contains(TestData.stmt3);
                                            var gotStatement4 = g1.contains(TestData.stmt4);
                                            var removedStatement1 = !g1.contains(TestData.subj1, TestData.pred1, TestData.obj1) && anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 0;
                                            log.debug((gotStatement3 ? "Got statement 3. " : "Waiting for statement 3. ") + (gotStatement4 ? "Got statement 4. " : "Waiting for statement 4. ") + (removedStatement1 ? "Got statement 1 removal. " : "Waiting for statement 1 removal."));
                                            if (gotStatement3 && gotStatement4 && removedStatement1) {
                                                log.debug("Got all updates we wanted. Checking if untouched messages remain in replica.");
                                                tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                                                tests.assertTrue(g1.contains(TestData.subj2, TestData.pred2, TestData.obj2));

                                                anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                    d.callback(true);
                                                }));
                                            } else {
                                                if (pollCount < 5) {
                                                    log.debug("All statements haven't arrived. Polling again...");
                                                    setTimeout(checkGraphUpdateArrived, 1000);
                                                } else {
                                                    throw new Error("Expected statements didn't arrive.");
                                                }
                                            }
                                        });
                                        setTimeout(checkGraphUpdateArrived, 1000);
                                    }));
                                }));
                            }));
                            
                            anzoClient.updateRepository(); 
                        }));
                    }));
                }));
                
                return d;
            }
        },

        {
            name: "test_getReplicaGraphsSubscribesAllGraphsToUpdateTopics",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_getReplicaGraphsSubscribesAllGraphsToUpdateTopics() {
                // summary: We'll get some graphs first. Then we'll reconnect with a brand new AnzoClient and
                //   get the graphs all at once using getReplicaGraphs. We'll then modify them
                //   directly via the JMSUpdateService (to simulate another client having changed the data).
                //   We expect the replica graphs to be updated by the graph update messages. In particular
                //   we must ensure that the updates include removes to make sure stale statements aren't
                //   left around. 

                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);

                        anzoClient.getReplicaGraphs([ TestData.graph1, TestData.graph2 ], null, d.getTestErrorWrapper(function(graphs) {
                            var g1 = graphs[TestData.graph1];
                            var g2 = graphs[TestData.graph2];
                            tests.assertTrue(g1 != null);
                            tests.assertTrue(g2 != null);
                            g1.add(TestData.subj1, TestData.pred1, TestData.obj1);
                            g1.add(TestData.subj2, TestData.pred2, TestData.obj2);
                            g2.add(TestData.subj3, TestData.pred3, TestData.obj3);
                            g2.add(TestData.subj4, TestData.pred4, TestData.obj4);

                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("updateRepositoryComplete");
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                anzoClient.close(d.getTestErrorWrapper(function(status) {
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    anzoClient = null;
                                    g1 = null;
                                    g2 = null;
                                    graphs = null;

                                    var anzoClient2 = new anzo.client.AnzoClient(anzo.tests.properties);
                                    anzoClient2.connect(d.getTestErrorWrapper(function connected(status, message) {
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                                        log.debug("reconneted");
                                        anzoClient2.getReplicaGraphs([ TestData.graph1, TestData.graph2 ], null, d.getTestErrorWrapper(function(graphs) {
                                            var graph1 = graphs[TestData.graph1];
                                            var graph2 = graphs[TestData.graph2];
                                            log.debug("Got existing graphs:" + graph1 + " " + graph2);
                                            tests.assertTrue(graph1 != null);
                                            tests.assertTrue(graph2 != null);
                                            tests.assertTrue(anzoClient2.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1).length == 1);
                                            tests.assertTrue(anzoClient2.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2, TestData.graph1).length == 1);
                                            tests.assertTrue(anzoClient2.replicaFind(TestData.subj3, TestData.pred3, TestData.obj3, TestData.graph2).length == 1);
                                            tests.assertTrue(anzoClient2.replicaFind(TestData.subj4, TestData.pred4, TestData.obj4, TestData.graph2).length == 1);
                                            tests.assertTrue(graph1.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                            tests.assertTrue(graph1.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                            tests.assertTrue(graph2.contains(TestData.subj3, TestData.pred3, TestData.obj3));
                                            tests.assertTrue(graph2.contains(TestData.subj4, TestData.pred4, TestData.obj4));
                                            // Now modify the graph directly via the JMSUpdateService to simulate another client having made a change.
                                            anzo.tests.utilities.rawUpdateRepository([ anzo.createStatement(TestData.subj5, TestData.pred5, TestData.obj5, TestData.graph1), anzo.createStatement(TestData.subj6, TestData.pred6, TestData.obj6, TestData.graph2) ], true, d.getTestErrorWrapper(function onRawUpdateRepository(updateResults, success, errors) {
                                                tests.assertTrue(success);
                                                log.debug("Did first raw update (additions)");
                                                anzo.tests.utilities.rawUpdateRepository([ anzo.createStatement(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1), anzo.createStatement(TestData.subj3, TestData.pred3, TestData.obj3, TestData.graph2) ], false, d.getTestErrorWrapper(function onRawUpdateRepository2(updateResults, success, errors) {
                                                    tests.assertTrue(success);
          
                                                    log.debug("Did second raw update (deletions)");
                                                    var pollCount = 0;
                                                    
                                                    var checkGraphUpdateArrived = d.getTestErrorWrapper(function _checkGraphUpdateArrived() {
                                                        pollCount++;
                                                        var gotStatement5 = graph1.contains(TestData.subj5, TestData.pred5, TestData.obj5);
                                                        var gotStatement6 = graph2.contains(TestData.subj6, TestData.pred6, TestData.obj6);
                                                        var removedStatement1 = !graph1.contains(TestData.subj1, TestData.pred1, TestData.obj1) && anzoClient2.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 0;
                                                        var removedStatement3 = !graph2.contains(TestData.subj3, TestData.pred3, TestData.obj3) && anzoClient2.replicaFind(TestData.subj3, TestData.pred3, TestData.obj3).length == 0;
                                                        log.debug((gotStatement5 ? "Got statement 5. " : "Waiting for statement 5. ") + (gotStatement6 ? "Got statement 6. " : "Waiting for statement 6. ") + (removedStatement1 ? "Got statement 1 removal. " : "Waiting for statement 1 removal.") + (removedStatement3 ? "Got statement 3 removal. " : "Waiting for statement 3 removal."));
                                                        if (gotStatement5 && gotStatement6 && removedStatement1 && removedStatement3) {
                                                            log.debug("Got all updates we wanted. Checking if untouched statements remain in replica.");
                                                            tests.assertTrue(anzoClient2.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2, TestData.graph1).length == 1);
                                                            tests.assertTrue(anzoClient2.replicaFind(TestData.subj4, TestData.pred4, TestData.obj4, TestData.graph2).length == 1);
                                                            tests.assertTrue(graph1.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                                            tests.assertTrue(graph2.contains(TestData.subj4, TestData.pred4, TestData.obj4));
            
                                                            anzoClient2.close(d.getTestErrorWrapper(function(status) { 
                                                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                                d.callback(true);
                                                            }));
                                                        } else {
                                                            if (pollCount < 5) {
                                                                log.debug("All statements haven't arrived. Polling again...");
                                                                setTimeout(checkGraphUpdateArrived, 1000);
                                                            } else {
                                                                throw new Error("Expected statements didn't arrive.");
                                                            }
                                                        }
                                                    });
                                                    setTimeout(checkGraphUpdateArrived, 1000);
                                                }));
                                            }));
                                        }));
                                    }));
                                }));
                            }));
                            anzoClient.updateRepository(); 
                        }));
                    }));
                }));
  
                return d;
            }
        }, 
        
        {
            name: "test_UpdateNewAndExistingReplicaGraph",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_UpdateNewAndExistingReplicaGraph() {
             
                 var TestData = new anzo.tests.client.TestData();
                
                 var d = new doh.Deferred();
             
                 var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                 
                 anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                     anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                         tests.assertTrue(suc);
                         anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                             anzoClient.begin();
                             graph.add(TestData.stmt1);	
                             graph.add(TestData.stmt2);		
                             anzoClient.commit();
                             
                             tests.assertTrue(graph.contains(TestData.stmt1));
                             tests.assertTrue(graph.contains(TestData.stmt2));
                             
                             var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                 tests.assertTrue(success);
                                 dojo.disconnect(handle);
                                 tests.assertTrue(graph.contains(TestData.stmt1));
                                 tests.assertTrue(graph.contains(TestData.stmt2));
                                 
                                 anzoClient.begin();
                                 graph.add(TestData.stmt3);
                                 anzoClient.commit();
                                 anzoClient.begin();
                                 anzoClient.getReplicaGraph(TestData.graph2, null, d.getTestErrorWrapper(function namedGraphComplete(graph2, error) {
                                	 graph2.add(TestData.stmt5);	
                                     graph2.add(TestData.stmt6);		
                                	 anzoClient.commit();
                                	 var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                         tests.assertTrue(success);
                                         dojo.disconnect(handle);
                                         log.debug("Trying assertions...");
                                         tests.assertTrue(graph2.contains(TestData.stmt5));
                                         log.debug("Passed the first one..");
                                         tests.assertTrue(graph2.contains(TestData.stmt6));
                                         tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt5));
                                         tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt6));
                                         
                                         anzoClient.close(d.getTestErrorWrapper(function(status){
                                             log.debug("disconnected status:" + status);
                                             tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                             d.callback(true);
                                         }));
                                         
                                	 }));
                                	 anzoClient.updateRepository();
                                 }));
                             }));
                             anzoClient.updateRepository();
     
                         }));
                     }));
                 }));
                 
                 return d;
             }
         },
         
         {
             name: "test_UpdateNewAndExistingReplicaGraphSameTransaction",
             timeout: 10000,
             setUp: function() {
             },
             runTest: function test_UpdateNewAndExistingReplicaGraphSameTransaction() {
              
                  var TestData = new anzo.tests.client.TestData();
                 
                  var d = new doh.Deferred();
              
                  var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                  
                  anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                      tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                      anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                          tests.assertTrue(suc);
                          anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                              anzoClient.begin();
                              graph.add(TestData.stmt1);	
                              graph.add(TestData.stmt2);		
                              anzoClient.commit();
                              
                              tests.assertTrue(graph.contains(TestData.stmt1));
                              tests.assertTrue(graph.contains(TestData.stmt2));
                              
                              var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                  tests.assertTrue(success);
                                  dojo.disconnect(handle);
                                  tests.assertTrue(graph.contains(TestData.stmt1));
                                  tests.assertTrue(graph.contains(TestData.stmt2));
                                  
                                  anzoClient.begin();
                                  graph.add(TestData.stmt3);
                                  anzoClient.getReplicaGraph(TestData.graph2, null, d.getTestErrorWrapper(function namedGraphComplete(graph2, error) {
                                 	  graph2.add(TestData.stmt5);	
                                      graph2.add(TestData.stmt6);		
                                 	  anzoClient.commit();
                                 	  var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                          tests.assertTrue(success);
                                          dojo.disconnect(handle);
                                          log.debug("Trying assertions...");
                                          tests.assertTrue(graph2.contains(TestData.stmt5));
                                          log.debug("Passed the first one..");
                                          tests.assertTrue(graph2.contains(TestData.stmt6));
                                          tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt5));
                                          tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt6));
                                          
                                          anzoClient.close(d.getTestErrorWrapper(function(status){
                                              log.debug("disconnected status:" + status);
                                              tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                              d.callback(true);
                                          }));
                                          
                                 	 }));
                                 	 anzoClient.updateRepository();
                                  }));
                              }));
                              anzoClient.updateRepository();
      
                          }));
                      }));
                  }));
                  
                  return d;
              }
          },

          {
              name: "test_StatementsForNewGraphAreInReplicaWhenTransactionCompleteFires",
              timeout: 10000,
              setUp: function() {
              },
              runTest: function test_StatementsForNewGraphAreInReplicaWhenTransactionCompleteFires() {
            	   // summary: We create a transaction that both edits an existing graph and creates a new graph with some new statements.
            	   // We expect that when the transactionComplete event fires for that transaction, all of the new graphs' statements
            	   // and all of the existing graph's edited statements are in the replica. We previously ran into a bug where the transactionComplete
            	   // event would fire before that was true. Other tests above test that it is true after the updateRepositoryComplete event
            	   // but this one is concerned with the transactionComplete event.
                   var TestData = new anzo.tests.client.TestData();
                  
                   var d = new doh.Deferred();
               
                   var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                   
                   anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                       tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                       anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                           tests.assertTrue(suc);
                           anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                               anzoClient.begin();
                               graph.add(TestData.stmt1);	
                               graph.add(TestData.stmt2);		
                               anzoClient.commit();
                               
                               tests.assertTrue(graph.contains(TestData.stmt1));
                               tests.assertTrue(graph.contains(TestData.stmt2));
                               
                               var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                   tests.assertTrue(success);
                                   dojo.disconnect(handle);
                                   tests.assertTrue(graph.contains(TestData.stmt1));
                                   tests.assertTrue(graph.contains(TestData.stmt2));

                                   log.debug("All set with the existing graph. About to add the new graph (plus some statements in it) and change the existing graph in one transaction.");
                                   anzoClient.begin();
                                   graph.add(TestData.stmt3);
                                   anzoClient.getReplicaGraph(TestData.graph2, null, d.getTestErrorWrapper(function namedGraphComplete(graph2, error) {
                                  	  graph2.add(TestData.stmt5);	
                                      graph2.add(TestData.stmt6);
                                      var originalTransactionUri = anzoClient.transactionQueue.currentTransaction.transactionUri;
                                  	  anzoClient.commit();
                                  	  
                                  	  var transactionCompleteEventCallbackCount = 0;
                                  	  var transactionCompleteEventPassed = false;
                                      var completeEventHandle = dojo.connect(anzoClient, "transactionComplete", d.getTestErrorWrapper(function(transactionURI, transactionTimestamp, transactionGraphs, transactionContext) {
                                    	  transactionCompleteEventCallbackCount++;
                                    	  log.debug("transactionComplete event received for transactionURI: " + transactionURI + " transactionCompleteEventCallbackCount:" + transactionCompleteEventCallbackCount);
                                    	  dojo.disconnect(completeEventHandle);
                                    	  completeEventHandle = null;

                                    	  tests.assertEqual(1, transactionCompleteEventCallbackCount);
                                    	  tests.assertEqual(originalTransactionUri, transactionURI);
                                    	  
                                    	  log.debug("Verifying that statements are in replica in transactionComplete handler.");
                                    	  log.debug("New graph's size:" + graph2.size());
                                    	  tests.assertTrue(graph.contains(TestData.stmt3));
                                    	  tests.assertTrue(graph2.contains(TestData.stmt5));
                                    	  tests.assertTrue(graph2.contains(TestData.stmt6));
                                    	  log.debug("Verifying quadstore directly.");
                                          tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt3));
                                          tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt5));
                                          tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt6));
                                          
                                          transactionCompleteEventPassed = true;
                                      }));
                                  	  var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                  		   log.debug("final updateRepositoryComplete - success:" + success);
                                           tests.assertTrue(success);
                                           dojo.disconnect(handle);
                                           log.debug("Trying assertions...");
                                           tests.assertTrue(graph2.contains(TestData.stmt5));
                                           log.debug("Passed the first one..");
                                           tests.assertTrue(graph2.contains(TestData.stmt6));
                                           tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt5));
                                           tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt6));
                                           
                                           log.debug("Ensuring that transactionComplete event was fired and passed its assertions.");
                                           tests.assertTrue(transactionCompleteEventPassed);
                                           
                                           anzoClient.close(d.getTestErrorWrapper(function(status){
                                               log.debug("disconnected status:" + status);
                                               tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                               d.callback(true);
                                           }));
                                           
                                  	 }));
                                  	 log.debug("About to updateRepository which will send up the transaction: " + originalTransactionUri);
                                  	 anzoClient.updateRepository();
                                   }));
                               }));
                               anzoClient.updateRepository();
       
                           }));
                       }));
                   }));
                   
                   return d;
               }
           },

        {
            name: "test_DuplicateQueryCallback_Ticket_646",
            timeout: 40000,
            setUp: function() {
            },
            runTest: function test_DuplicateQueryCallback_Ticket_646() {
                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    log.debug("Connected - status:" + status);
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        log.debug("Reset - success:" + suc);
                        tests.assertTrue(suc);
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            log.debug("Got replica graph.");
                            tests.assertTrue(graph != null);
                            graph.add(TestData.stmt1);  
                            anzoClient.commit();
                            tests.assertTrue(graph.contains(TestData.stmt1));
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("updateRepositoryComplete - success:" + success);
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                handle = null;

                                var query = "SELECT * WHERE { GRAPH ?graph { <" + TestData.stmt1.subject.toString() + "> <" + TestData.stmt1.predicate.toString() + "> ?obj } }";
                                var callbackCalledCount = 0;
                                log.debug("asking first query");
                                anzoClient.serverQuery(null, [ TestData.stmt1.namedGraphUri ], null, query, null, d.getTestErrorWrapper(function() {
                                    callbackCalledCount++;
                                    log.debug("Query callback: callbackCalledCount:" + callbackCalledCount);
                                }));
                                
                                log.debug("asking second query");
                                anzoClient.serverQuery(null, [ TestData.stmt1.namedGraphUri ], null, query, null, d.getTestErrorWrapper(function() {
                                    callbackCalledCount++;
                                    log.debug("Second callback: callbackCalledCount:" + callbackCalledCount);
                                }));

                                // Wait around to give time for any extra erroneous calls to the query callbacks.
                                setTimeout(d.getTestErrorWrapper(function() {
                                    log.debug("Done waiting for callbacks.");
                                    tests.assertTrue(callbackCalledCount <= 2);
                                    
                                    tests.assertTrue(anzoClient.queryService._pendingQueries.size() == 0); // Make sure that the pending queries collection has been cleaned up

                                    anzoClient.close(d.getTestErrorWrapper(function(status){
                                        log.debug("disconnected status:" + status);
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        d.callback(true);
                                    }));
                                }), 1000);

                            }));
                            log.debug("about to updateRepository");
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        }
        
/*
        {
            name: "test_simulatedLossOfConnectionFiresEvents",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_simulatedLossOfConnectionFiresEvents() {
                // summary: We'll simulate cometd having seen an error in its poll request.
                //   The anzoClient should get a disconnected event. Our local replica should remain intact
                //   and we should be able to reconnect and restore graph subscriptions, etc.
                
                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);

                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("first connect done.");
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        log.debug("reset done");
                        
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function(g1) {
                            log.debug("getReplicaGraph done");
                            
                            g1.add(TestData.subj1, TestData.pred1, TestData.obj1);
                            g1.add(TestData.subj2, TestData.pred2, TestData.obj2);
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("updateRepositoryComplete");
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                var clientDisconnectedEventFired = false;
                                var clientDisonnectedHandle = dojo.connect(anzoClient, "clientDisconnected", d.getTestErrorWrapper(function() {
                                    tests.assertFalse(clientDisconnectedEventFired); // ensure it's not fired in duplicate
                                    clientDisconnectedEventFired = true;
                                    log.debug("clientDisconnected event fired");
                                    
                                    // Simulated broken connection happened. Now let's verify that the graph data in the replica is still usable.
                                    tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
                                    tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                                    tests.assertTrue(g1.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                    tests.assertTrue(g1.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                    tests.assertFalse(g1.contains(TestData.stmt3));
                                    tests.assertFalse(g1.contains(TestData.stmt4));
                                    
                                    log.debug("about to reconnect.");
                                    // Now let's reconnect and see if the graph topic subscriptions are restored.
                                    anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                                        log.debug("reconnected.");
                                        
                                        // Now modify the graph directly via the JMSUpdateService to simulate another client having made a change.
                                        anzo.tests.utilities.rawUpdateRepository([TestData.stmt3, TestData.stmt4], true, d.getTestErrorWrapper(function onRawUpdateRepository(updateResults, success, errors) {
                                            log.debug("done doing rawUpdateRepository.");
                                            tests.assertTrue(success);

                                            var pollCount = 0;
                                            var checkGraphUpdateArrived = d.getTestErrorWrapper(function _checkGraphUpdateArrived() {
                                                pollCount++;
                                                var gotStatement3 = g1.contains(TestData.stmt3);
                                                var gotStatement4 = g1.contains(TestData.stmt4);
                                                log.debug((gotStatement3 ? "Got statement 3. " : "Waiting for statement 3. ") + (gotStatement4 ? "Got statement 4. " : "Waiting for statement 4. "));
                                                if (gotStatement3 && gotStatement4) {
                                                    log.debug("Got all statements we wanted.");
                                                    dojo.disconnect(clientDisonnectedHandle);
                                                    clientDisonnectedHandle = null;
                                                    anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                                        log.debug("final close");
                                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                        d.callback(true);
                                                    }));
                                                } else {
                                                    if (pollCount < 5) {
                                                        log.debug("All statements haven't arrived. Polling again...");
                                                        setTimeout(checkGraphUpdateArrived, 1000);
                                                    } else {
                                                        throw new Error("Expected statements didn't arrive.");
                                                    }
                                                }
                                            });
                                            setTimeout(checkGraphUpdateArrived, 1000);
                                        }));
                                    }));
                                }));
                                
                                // Send the same event that cometd would send when it gets a failed poll request.
                                // The JMSClient will consider that a broken connection. This should trigger the clientDisconnected event.
                                dojo.publish("/cometd/meta", [{cometd:dojox.cometd,action:"connect",successful:false,state:dojox.cometd.state()}]);
                            }));
                            anzoClient.updateRepository();
                        }));
                    }));
                }));
                
                return d;
            }
        }
*/
    ]
);


function test_reconnectProperlyRemovesStatementsFromReplica(useNonRevisionedGraph) {
    // summary: Reusable test method that will create a graph and fill it with some statements on the server.
    //   Then it'll disconnect the anzoClient. Using raw commands via the JMSUpdateService to simulate
    //   a second user, it'll then remove some statements on the graph on the server. After that, it'll reconnect
    //   the anzoClient and assert that those statements are properly removed from the replica upon reconnection.
    // useNonRevisionedGraph : if true, then a non-revisioned graph will be used for the test. Otherwise a
    //   regular revisioned graph will be used.
    var TestData = new anzo.tests.client.TestData();
    
    var d = new doh.Deferred();

    var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);

    anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
        log.debug("first connect done.");
        anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
            tests.assertTrue(suc);
            log.debug("reset done");
            
            anzoClient.getReplicaGraph(TestData.graph1, {create: true, namedGraphInitializers: useNonRevisionedGraph ? [ anzoClient.getRevisionedGraphInitializer(false) ] : undefined}, d.getTestErrorWrapper(function(g1) {
                log.debug("getReplicaGraph done");
                
                g1.add(TestData.stmt1);
                g1.add(TestData.stmt2);
                g1.add(TestData.stmt3);
                
                var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                    log.debug("updateRepositoryComplete");
                    tests.assertTrue(success);
                    dojo.disconnect(handle);

                    tests.assertTrue(anzoClient.replicaFind(TestData.stmt1.subject, TestData.stmt1.predicate, TestData.stmt1.object, TestData.stmt1.namedGraphUri).length == 1);
                    tests.assertTrue(anzoClient.replicaFind(TestData.stmt2.subject, TestData.stmt2.predicate, TestData.stmt2.object, TestData.stmt2.namedGraphUri).length == 1);
                    tests.assertTrue(anzoClient.replicaFind(TestData.stmt3.subject, TestData.stmt3.predicate, TestData.stmt3.object, TestData.stmt3.namedGraphUri).length == 1);
                    tests.assertTrue(g1.contains(TestData.stmt1));
                    tests.assertTrue(g1.contains(TestData.stmt2));
                    tests.assertTrue(g1.contains(TestData.stmt3));

                    log.debug("about to disconnect anzoClient");
                    
                    anzoClient.disconnect(d.getTestErrorWrapper(function(status) {
                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                        log.debug("disconnected the first time");

                        // Now modify the graph directly via the JMSUpdateService to simulate another client having made a change.
                        // First we've got to connect the raw JMSClient so that the JMSUpdateService can communicate with the server.
                        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function(status) {
                            log.debug("raw connect");
                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                            anzo.tests.utilities.rawUpdateRepository([TestData.stmt1], false, d.getTestErrorWrapper(function onRawUpdateRepository(updateResults, success, errors) {
                                log.debug("done doing first rawUpdateRepository.");
                                tests.assertTrue(success);
                                // We do the rawUpdateRepository twice so that the graph gets multiple revisions.
                                // That ensures that a graph topic update won't be enough to keep the graph up-to-date.
                                anzo.tests.utilities.rawUpdateRepository([TestData.stmt2], false, d.getTestErrorWrapper(function onRawUpdateRepository(updateResults, success, errors) {
                                    log.debug("done doing second rawUpdateRepository.");
                                    tests.assertTrue(success);

                                    anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function(status) {
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                        log.debug("raw disconnect done.");

                                        anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                                            log.debug("reconnect");
                                    
                                            // The graph shouldn't have the statements that we removed while the anzoClient was disconnected.
                                            tests.assertFalse(anzoClient.replicaFind(TestData.stmt1.subject, TestData.stmt1.predicate, TestData.stmt1.object, TestData.stmt1.namedGraphUri).length == 1);
                                            tests.assertFalse(anzoClient.replicaFind(TestData.stmt2.subject, TestData.stmt2.predicate, TestData.stmt2.object, TestData.stmt2.namedGraphUri).length == 1);
                                            tests.assertTrue(anzoClient.replicaFind(TestData.stmt3.subject, TestData.stmt3.predicate, TestData.stmt3.object, TestData.stmt3.namedGraphUri).length == 1); // We didn't remove this one so it should still be around
                                            tests.assertFalse(g1.contains(TestData.stmt1));
                                            tests.assertFalse(g1.contains(TestData.stmt2));
                                            tests.assertTrue(g1.contains(TestData.stmt3)); // We didn't remove this one so it should still be around

                                            anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                d.callback(true);
                                            }));
                                        }));
                                    }));
                                }));
                            }));
                        }));
                    }));
                }));
                anzoClient.updateRepository();
            }));
        }));
    }));
    
    return d;
}

function test_graphPermissions(anzoClientProperties) {
	// summary: use the given properties to create an AnzoClient and test the permissions functions.
	//   this is used to test permissions as different users.
	
    var d = new doh.Deferred();
    
    var TestData = new anzo.tests.client.TestData();
    
    var anzoClient = new anzo.client.AnzoClient(anzoClientProperties);
    
    anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
        log.debug("Client connected successfully");
        anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
            tests.assertTrue(suc);
            log.debug("Reset successfull");
            anzoClient.begin();
            anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                graph.add(TestData.stmt1);	
                graph.add(TestData.stmt2);		
                anzoClient.commit();
                
                tests.assertTrue(graph.contains(TestData.stmt1));
                tests.assertTrue(graph.contains(TestData.stmt2));
                
                var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                    tests.assertTrue(success);
                    dojo.disconnect(handle);
                    
                    tests.assertTrue(graph.contains(TestData.stmt1));
                    tests.assertTrue(graph.contains(TestData.stmt2));
                    
                    anzoClient.canReadNamedGraph(TestData.graph1, d.getTestErrorWrapper(function(canRead, success, errors) {
                        if (!success) {
                            log.debug("Error getting graph permission: " + dojo.toJson(errors, true));
                        }
                        tests.assertTrue(success);
                        tests.assertTrue(canRead);
                        anzoClient.canAddToNamedGraph(TestData.graph1, d.getTestErrorWrapper(function(canAdd, success, errors) {
                            if (!success) {
                                log.debug("Error getting graph permission: " + dojo.toJson(errors, true));
                            }
                            tests.assertTrue(success);
                            tests.assertTrue(canAdd);
                            anzoClient.canRemoveFromNamedGraph(TestData.graph1, d.getTestErrorWrapper(function(canRemove, success, errors) {
                                if (!success) {
                                    log.debug("Error getting graph permission: " + dojo.toJson(errors, true));
                                }
                                tests.assertTrue(success);
                                tests.assertTrue(canRemove);
                                anzoClient.close(d.getTestErrorWrapper(function(status) { 
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                            }));
                        }));
                    }));
                }));
                anzoClient.updateRepository();

            }));
        }));
    }));
    
    return d;
}

})();
