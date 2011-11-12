/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
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

dojo.provide("anzo.tests.client.BayeuxEfficiencyTest");

dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.log");

(function() {
var log = anzo.log.getLogger("anzo.tests.client.BayeuxEfficiencyTest");

tests.register("anzo.tests.client.BayeuxEfficiencyTest", 
    [
       
     	{
            name: "test_BayeuxSendsMultimeMessagesPerPollRequest",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_BayeuxSendsMultimeMessagesPerPollRequest() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            
                            // First add a statement and replicate so that the graph is written on the server.
                            graph.add(TestData.subj1, TestData.pred1, 0);

                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success);
                                dojo.disconnect(handle);

                                // Now add a bunch of statements to the graph in individual transactions so as
                                // to cause many many revision messages to be sent out rapidly. Some of
                                // Those messages should be coming back in a single cometd poll response.
                                for (var i = 0; i < 100; i++) {
                                    anzoClient.begin();
                                    graph.add(TestData.subj1, TestData.pred1, i);
                                    anzoClient.commit();
                                }

                                // NOTE: This test is more of a driver than an automated test. You should inspect
                                // the HTTP traffic to see if comet managed to batch the messages as it should.
                                
                                var handle2 = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                    tests.assertTrue(success);
                                    dojo.disconnect(handle2);

                                    graph.close();
                                    anzoClient.close(d.getTestErrorWrapper(function(status){
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
        }
    ]
);

})();
