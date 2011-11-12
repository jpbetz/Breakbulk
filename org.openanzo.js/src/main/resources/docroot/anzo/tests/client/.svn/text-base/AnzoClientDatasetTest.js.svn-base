/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
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
 * 
 */

dojo.provide("anzo.tests.client.AnzoClientDatasetTest");

dojo.require("anzo.tests.messaging.JMSClientRecorder");
dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.log");

(function() {
var log = anzo.log.getLogger("anzo.tests.client.AnzoClientDatasetTest");

tests.register("anzo.tests.client.AnzoClientDatasetTest", 
    [
        
        {
            name: "test_Basics",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_Basics() {
                
                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.createReplicaDataset(true, TestData.dataset1, null, null, d.getTestErrorWrapper(function(ds) {
                            ds.addNamedGraph(TestData.graph1, d.getTestErrorWrapper(function(g1) {
                                g1.add(TestData.subj1, TestData.pred1, TestData.obj1);
                                ds.addNamedGraph(TestData.graph2, d.getTestErrorWrapper(function(g2) {
                                    g2.add(TestData.subj2, TestData.pred2, TestData.obj2);
                                    ds.addNamedGraph(TestData.graph3, d.getTestErrorWrapper(function(g3) {
                                        g3.add(TestData.subj3, TestData.pred3, TestData.obj3);
                                        
                                        tests.assertTrue(ds.containsNamedGraph(TestData.graph2));
                                        tests.assertTrue(ds.containsNamedGraph(g2));
                                        tests.assertTrue(ds.datasetGraph.contains(ds.uri, anzo.client.Vocabulary.namedGraphProperty, g2.namedGraphUri));
                                        tests.assertTrue(new anzo.utils.Set(ds.getNamedGraphUris()).contains(g2.namedGraphUri));
                                        tests.assertTrue(ds.getNamedGraph(TestData.graph2) == g2);
                                        
                                        
                                        tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1)[0].namedGraphUri.equals(g1.namedGraphUri));
                                        tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2)[0].namedGraphUri.equals(g2.namedGraphUri));
                                        tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3)[0].namedGraphUri.equals(g3.namedGraphUri));
                                        
                                        tests.assertTrue(ds.size() == 3);
                                        tests.assertTrue(ds.size([g2.namedGraphUri, g3.namedGraphUri, 'http://random']) == 2);
                                        
                                        tests.assertTrue(!ds.isEmpty());
                                        tests.assertTrue(ds.isEmpty(['http://random']));
                                        
                                        ds.close();
                                        
                                        anzoClient.close(d.getTestErrorWrapper(function(status){ d.callback(true); }));
                                    }));
                                    
                                }));
                            }));
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
            name: "test_Basics2",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_Basics2() {
                
                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        anzoClient.createReplicaDataset(true, TestData.dataset1, [TestData.graph1, TestData.graph2, TestData.graph3], [TestData.graph2, TestData.graph3, TestData.graph4], d.getTestErrorWrapper(function(ds) {
                            ds.addNamedGraph(TestData.graph5, d.getTestErrorWrapper(function(g5) {
                                ds.addDefaultGraph(TestData.graph5, d.getTestErrorWrapper(function(g5_1) {

                                    tests.assertTrue(ds.getDefaultGraph(TestData.graph1) != null)
                                    tests.assertFalse(ds.getNamedGraph(TestData.graph1) != null)
                                    tests.assertTrue(ds.getNamedGraph(TestData.graph2) != null)
                                    tests.assertTrue(ds.getNamedGraph(TestData.graph3) != null)
                                    tests.assertTrue(ds.getNamedGraph(TestData.graph4) != null)
                                    tests.assertFalse(ds.getDefaultGraph(TestData.graph4) != null)
                                    tests.assertTrue(ds.getDefaultGraph(TestData.graph5) != null)
                                    
                                    var g1 = ds.getDefaultGraph(TestData.graph1);
                                    var g2 = ds.getNamedGraph(TestData.graph2);
                                    var g3 = ds.getNamedGraph(TestData.graph3);
                                    var g4 = ds.getNamedGraph(TestData.graph4);
                                    
                                    g1.add(TestData.subj1, TestData.pred1, TestData.obj1)
                                    g2.add(TestData.subj2, TestData.pred2, TestData.obj2)
                                    g3.add(TestData.subj3, TestData.pred3, TestData.obj3)
                                    g4.add(TestData.subj4, TestData.pred4, TestData.obj4)
                                    g5.add(TestData.subj5, TestData.pred5, TestData.obj5)

                                    tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1)[0].namedGraphUri.equals(g1.namedGraphUri));
                                    tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2)[0].namedGraphUri.equals(g2.namedGraphUri));
                                    tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3)[0].namedGraphUri.equals(g3.namedGraphUri));
                                    tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4)[0].namedGraphUri.equals(g4.namedGraphUri));
                                    tests.assertTrue(ds.find(TestData.subj5, TestData.pred5, TestData.obj5)[0].namedGraphUri.equals(g5.namedGraphUri));

                                    tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1, g1.namedGraphUri).length == 1);
                                    tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2, g2.namedGraphUri).length == 1);
                                    tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3, g3.namedGraphUri).length == 1);
                                    tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4, g4.namedGraphUri).length == 1);
                                    tests.assertTrue(ds.find(TestData.subj5, TestData.pred5, TestData.obj5, g5.namedGraphUri).length == 1);

                                    tests.assertTrue(ds.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                    tests.assertTrue(ds.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                    tests.assertTrue(ds.contains(TestData.subj3, TestData.pred3, TestData.obj3));
                                    tests.assertTrue(ds.contains(TestData.subj4, TestData.pred4, TestData.obj4));
                                    tests.assertTrue(ds.contains(TestData.subj5, TestData.pred5, TestData.obj5));
                                    
                                    tests.assertTrue(ds.size() == 5);
                                    tests.assertTrue(ds.size([g3.namedGraphUri, g4.namedGraphUri, 'http://random']) == 2);
                                    
                                    tests.assertTrue(!ds.isEmpty());
                                    tests.assertTrue(ds.isEmpty(['http://random']));
                                    tests.assertTrue(!ds.isEmpty([TestData.graph1]));

                                    ds.close();
                                    
                                    // test loading an existing dataset
                                    anzoClient.createReplicaDataset(true, TestData.dataset1, null, null, d.getTestErrorWrapper(function(ds) {

                                        tests.assertTrue(ds.getDefaultGraph(TestData.graph1) != null)
                                        tests.assertTrue(ds.getNamedGraph(TestData.graph2) != null)
                                        tests.assertTrue(ds.getNamedGraph(TestData.graph3) != null)
                                        tests.assertTrue(ds.getNamedGraph(TestData.graph4) != null)
                                        tests.assertTrue(ds.getDefaultGraph(TestData.graph5) != null)
                                        
                                        ds.clear();
                                        tests.assertTrue(ds.isEmpty());
                                        tests.assertTrue(ds.size() == 0);
                                        
                                        ds.close();
                                        
                                        anzoClient.close(d.getTestErrorWrapper(function(status){ d.callback(true); }));
                                        
                                    }));
                                }));
                            }));     
                        }));
                    }));
                }));
                
                return d;
            }
        },
        
        {
            name: "test_ReplicatingDatasets",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_ReplicatingDatasets() {
                
                var TestData = new anzo.tests.client.TestData();
                
                var d = new doh.Deferred();
            
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        
                        tests.assertTrue(suc);
                        
                        anzoClient.createReplicaDataset(true, TestData.dataset1, [TestData.graph1, TestData.graph2, TestData.graph3], [TestData.graph2, TestData.graph3, TestData.graph4], d.getTestErrorWrapper(function(ds) {
                            
                            // make sure the graphs were added to the dataset
                            tests.assertTrue(ds.getDefaultGraph(TestData.graph1) != null)
                            tests.assertFalse(ds.getNamedGraph(TestData.graph1) != null)
                            tests.assertTrue(ds.getNamedGraph(TestData.graph2) != null)
                            tests.assertTrue(ds.getNamedGraph(TestData.graph3) != null)
                            tests.assertTrue(ds.getNamedGraph(TestData.graph4) != null)
                            tests.assertFalse(ds.getDefaultGraph(TestData.graph4) != null)
                            
                            // get the named graphs
                            var g1 = ds.getDefaultGraph(TestData.graph1);
                            var g2 = ds.getNamedGraph(TestData.graph2);
                            var g3 = ds.getNamedGraph(TestData.graph3);
                            var g4 = ds.getNamedGraph(TestData.graph4);
                            
                            // add statements to the graphs
                            g1.add(TestData.subj1, TestData.pred1, TestData.obj1) // add to graph directly
                            g2.add(TestData.subj2, TestData.pred2, TestData.obj2) // add to graph directly
                            ds.add(TestData.subj3, TestData.pred3, TestData.obj3, g3.namedGraphUri) // add to graph via dataset
                            ds.add(TestData.subj4, TestData.pred4, TestData.obj4, g4.namedGraphUri) // add to graph via dataset
                            
                            // make sure the statements can be found through the dataset's find method
                            tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1)[0].namedGraphUri.equals(g1.namedGraphUri));
                            tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2)[0].namedGraphUri.equals(g2.namedGraphUri));
                            tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3)[0].namedGraphUri.equals(g3.namedGraphUri));
                            tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4)[0].namedGraphUri.equals(g4.namedGraphUri));
                            
                            tests.assertTrue(ds.find(TestData.subj1, TestData.pred1, TestData.obj1, g1.namedGraphUri).length == 1);
                            tests.assertTrue(ds.find(TestData.subj2, TestData.pred2, TestData.obj2, g2.namedGraphUri).length == 1);
                            tests.assertTrue(ds.find(TestData.subj3, TestData.pred3, TestData.obj3, g3.namedGraphUri).length == 1);
                            tests.assertTrue(ds.find(TestData.subj4, TestData.pred4, TestData.obj4, g4.namedGraphUri).length == 1);
                            
                            // VALIDATE THAT THE STATEMENTS EXIST IN THE REPLICA QUAD STORE
                            tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
                            tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                            tests.assertTrue(anzoClient.replicaFind(TestData.subj3, TestData.pred3, TestData.obj3).length == 1);
                            tests.assertTrue(anzoClient.replicaFind(TestData.subj4, TestData.pred4, TestData.obj4).length == 1);
                            
                            // make sure the statements can be found through the dataset's contains method
                            tests.assertTrue(ds.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                            tests.assertTrue(ds.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                            tests.assertTrue(ds.contains(TestData.subj3, TestData.pred3, TestData.obj3));
                            tests.assertTrue(ds.contains(TestData.subj4, TestData.pred4, TestData.obj4));
                            
                            tests.assertTrue(ds.size() == 4);
                            tests.assertTrue(ds.size([g3.namedGraphUri, g4.namedGraphUri, 'http://random']) == 2);

                            tests.assertTrue(!ds.isEmpty());
                            tests.assertTrue(ds.isEmpty(['http://random']));
                            tests.assertTrue(!ds.isEmpty([TestData.graph1]));
                            
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                
                                // VALIDATE THAT THE STATEMENTS EXIST IN THE REPLICA QUAD STORE

                                tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj3, TestData.pred3, TestData.obj3).length == 1);
                                tests.assertTrue(anzoClient.replicaFind(TestData.subj4, TestData.pred4, TestData.obj4).length == 1);
                                
                                tests.assertTrue(ds.getDefaultGraphUris().length == 3);
                                tests.assertTrue(ds.getNamedGraphUris().length == 3);
                                
                                
                                tests.assertTrue(ds.getDefaultGraph(TestData.graph1) != null)
                                tests.assertFalse(ds.getNamedGraph(TestData.graph1) != null)
                                tests.assertTrue(ds.getNamedGraph(TestData.graph2) != null)
                                tests.assertTrue(ds.getNamedGraph(TestData.graph3) != null)
                                tests.assertTrue(ds.getNamedGraph(TestData.graph4) != null)
                                tests.assertFalse(ds.getDefaultGraph(TestData.graph4) != null)

                                tests.assertTrue(ds.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                tests.assertTrue(ds.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                tests.assertTrue(ds.contains(TestData.subj3, TestData.pred3, TestData.obj3));
                                tests.assertTrue(ds.contains(TestData.subj4, TestData.pred4, TestData.obj4));
                                
                                tests.assertTrue(ds.size() == 4);
                                
                                ds.close();
                                
                                anzoClient.close(d.getTestErrorWrapper(function(status){
//                                            d.callback(true);
                                    anzoClient = null;
                                    // ===============================================================================================
                                    // TEST ACCESSING A NAMED DATASET ON THE SERVER
                                    
                                    var anzoClient2 = new anzo.client.AnzoClient(anzo.tests.properties);
                                    anzoClient2.connect(d.getTestErrorWrapper(function connected(status, message) {
                                        anzoClient2.createReplicaDataset(true, TestData.dataset1, null, null, d.getTestErrorWrapper(function(ds) {
                                            
                                            tests.assertTrue(ds.getDefaultGraph(TestData.graph1) != null)
                                            tests.assertFalse(ds.getNamedGraph(TestData.graph1) != null)
                                            tests.assertTrue(ds.getNamedGraph(TestData.graph2) != null)
                                            tests.assertTrue(ds.getNamedGraph(TestData.graph3) != null)
                                            tests.assertTrue(ds.getNamedGraph(TestData.graph4) != null)
                                            tests.assertFalse(ds.getDefaultGraph(TestData.graph4) != null)
                                            
                                            tests.assertTrue(ds.contains(TestData.subj1, TestData.pred1, TestData.obj1));
                                            tests.assertTrue(ds.contains(TestData.subj2, TestData.pred2, TestData.obj2));
                                            tests.assertTrue(ds.contains(TestData.subj3, TestData.pred3, TestData.obj3));
                                            tests.assertTrue(ds.contains(TestData.subj4, TestData.pred4, TestData.obj4));
                                            
                                            tests.assertTrue(ds.size() == 4);

                                            ds.close();
                                            anzoClient2.close(d.getTestErrorWrapper(function(status){ d.callback(true); }));
                                        }));
                                    }));
                                }));
                            }));
                            
                            // VALIDATE THAT THE STATEMENTS EXIST IN THE REPLICA QUAD STORE
                            tests.assertTrue(anzoClient.replicaFind(TestData.subj1, TestData.pred1, TestData.obj1).length == 1);
                            tests.assertTrue(anzoClient.replicaFind(TestData.subj2, TestData.pred2, TestData.obj2).length == 1);
                            tests.assertTrue(anzoClient.replicaFind(TestData.subj3, TestData.pred3, TestData.obj3).length == 1);
                            tests.assertTrue(anzoClient.replicaFind(TestData.subj4, TestData.pred4, TestData.obj4).length == 1);
                            
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
