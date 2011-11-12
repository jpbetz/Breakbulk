/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
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

dojo.provide("anzo.tests.client.TopicSubscriptionTest");

dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.properties");
dojo.require("anzo.log");

(function(){
var log = anzo.log.getLogger("anzo.tests.client.TopicSubscriptionTest");

tests.registerGroup("anzo.tests.client.TopicSubscriptionTest",
    [
    	// TODO: make this test work
        // TODO: Test what happens if you subscribe to a non-existant graph.
        // TODO: Test if you get multiple messages when subscribing multiple times.
        // TODO: Test what happens if you _unsubscribe_ from a non-existant graph.
        // TODO: Test that you cannot subscribe to a graph to which you don't have ACLs.
        {
            name: "test_subscribingAndReceivingToGraphUpdates",
            timeout: 20000,
            setUp: function() {
            },
            runTest: function test_subscribingAndReceivingTopics() {
                // summary: Test that you graph updates come back once the JMSClient subscribes to them
                var d = new doh.Deferred();
                anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function connectCallback(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

                    // <http://graph1> <http://openanzo.org/ontologies/2008/07/Anzo#uuid> <http://openanzo.org/namedGraphUUID/revisioned/042e16cb-83fd-4a2e-8873-c68938ae0f48> .
                    //var graphUri = "http://test.example.com/test#namedGraph2";
                    var topic = "http://openanzo.org/namedGraphUUID/revisioned/c0b9d9e1-875c-439c-8cfb-9182e28e80b0";
                    anzo.messaging.JMSClient.subscribeToTopics(graphUuid, d.getTestErrorWrapper(function graphUpdateListener(msg) {
                        log.debug("Got an update message: " + dojo.toJson(msg, true));
                    }), d.getTestErrorWrapper(function subscribeCallback(success, failedTopics, errors) {
                        tests.assertTrue(success);
                        
                        //anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function disconnectCallback(status, message) { d.callback(true); }));
                    }));
                }));
                
                
/*               
                var datasetService = new anzo.client.DatasetService(anzo.tests.properties);
                datasetService.connect(d.getTestErrorWrapper(function onConnect(status, error) {
                    log.debug("foo:" + status + " error:" + dojo.toJson(error,true));
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("foo1");
                    anzo.tests.utilities.reset(datasetService, d.getTestErrorWrapper(function(suc) {
                        tests.assertTrue(suc);
                        var graphUri = "http://example.com/graph1";
                        
                        // Don't let getReplicaGraph track the graph. We want to make sure that real-time-update notification
                        // messages don't mix up our test here.
                        var graph = datasetService.getReplicaGraph(graphUri, false);
                        var replicationEventHandle = dojo.connect(datasetService, "replicationComplete", d.getTestErrorWrapper(function onReplicationComplete(success, errors) {
                            log.debug("Replication complete: " + success + " errors:" + dojo.toJson(errors));
                            dojo.disconnect(replicationEventHandle);
    
                            var statements = graph.find(null,null,null);
                            log.debug("statements:" + dojo.toJson(statements, true));

                            datasetService.close(d.getTestErrorWrapper(function onClose() { d.callback(true); }));
                        }));
                        datasetService.replicate();
                    }));
                }));
*/
/*
                anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function connectCallback(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

                    anzo.tests.utilities.reset(datasetService, d.getTestErrorWrapper(function(suc) {
                        tests.assertTrue(suc);
                        var graphUri = "http://example.com/graph1";
                        anzo.tests.utilities.rawCreateGraph(graphUri, d.getTestErrorWrapper(function rawCreateGraphCallback(message) {
                            // Now need to get the graph's UUID
                            

                            //var gotGraphUpdate
                            // Now that the graph is created, subscribe to its updates.
                            //anzo.messaging.JMSClient.subscribeToGraphUpdates(graphUri, );
                        }));
                    }));
                }));
*/               
                return d;
            }
        }
    ],

    function setUp() {
    },

    function tearDown() {
    }
);

})();
