/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
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

dojo.provide("anzo.tests.client.RealtimeUpdateTest");

dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.client.RealtimeUpdateManager");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.log");

(function(){
var log = anzo.log.getLogger("anzo.tests.client.RealtimeUpdateTest");

tests.registerGroup("anzo.tests.client.RealtimeUpdateTest",
    [
        // TODO: test bnodes
        {
           name : "test_receivesAddRemoveStatementRealtimeUpdates",
           timeout : 20000,
           setUp : function() {
           },
           runTest : function test_receivesAddRemoveStatementRealtimeUpdates() {
                // summary: Registers a statement tracker waits for the notifications about creating a graph, adding a statement,
                //   and removing a statement.

                var d = new doh.Deferred(); // Return a Deferred object to let the test system know to wait around for the response.

                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function(suc) {
                        // First create a graph in the repository to which we'll be adding statements.
                        tests.assertTrue(suc);
                        var graphUri = "http://example.org/testGraph1";
                        anzoClient.getReplicaGraph(graphUri, null, d.getTestErrorWrapper(function onGetReplicaGraphComplete(graph, errors) {
                            log.debug("onGetReplicaGraphComplete");
                            tests.assertTrue(graph != null);

                            // Now there is a graph in the system. We register for a tracker
                            // to listen for particular changes on that graph. 
                            var realtimeUpdates = anzoClient.realtimeUpdates;
                            
                            var firstStatement = anzo.createStatement("http://example.com/subject21", "http://example.com/predicate22", anzo.createLiteral("Look at me!"), graphUri);
                            var secondStatement = anzo.createStatement("http://example.com/subject21", "http://example.com/predicate22", anzo.createTypedLiteral("Look at me too!", anzo.rdf.vocabulary.XMLSchema.xsString), graphUri);
                            var thirdStatement = anzo.createStatement("http://example.com/subject21", "http://example.com/notTracked", "This statement isn't tracked!", graphUri);
                            var fourthStatement = anzo.createStatement("http://example.com/subject21", "http://example.com/predicate22", anzo.createLiteral("Over here! With a language", "en"), graphUri);
                            var sawFirstStatementAdded = false;
                            var sawSecondStatementAdded = false;
                            var sawSecondStatementRemoved = false;
                            var sawFourthStatementAdded = false;
                            var listener = { 
                                statementsAdded : d.getTestErrorWrapper(function onStatementsAdded(statements) {
                                    log.debug("statementsAdded event.");
                                    tests.assertEqual(1, statements.length);
                                    var statement = statements[0];
                                    if (statement.equals(firstStatement)) {
                                        tests.assertFalse(sawFirstStatementAdded); // The event should be fired only once per statement added.
                                        sawFirstStatementAdded = true;
                                    } else if (statement.equals(secondStatement)) {
                                        tests.assertFalse(sawSecondStatementAdded); // The event should be fired only once per statement added.
                                        sawSecondStatementAdded = true;
                                    } else if (statement.equals(fourthStatement)) {
                                        tests.assertFalse(sawFourthStatementAdded); // The event should be fired only once per statement added.
                                        sawFourthStatementAdded = true;
                                    } else {
                                        throw new Error("statementAdded event received for unexpected statement: " + statement.toString());
                                    }
                               }),
                                statementsRemoved : d.getTestErrorWrapper(function onStatementsRemoved(statements) {
                                    log.debug("statementsRemoved event.");
                                    tests.assertEqual(1, statements.length);
                                    var statement = statements[0];
                                    if (statement.equals(secondStatement)) {
                                        tests.assertFalse(sawSecondStatementRemoved); // The event should be fired only once per statement removed.
                                        sawSecondStatementRemoved = true;
                                    } else {
                                        throw new Error("statementRemoved event received for unexpected statement: " + statement.toString());
                                    }
                                })
                            }
                            realtimeUpdates.addTracker("http://example.com/subject21", "http://example.com/predicate22", null, graphUri, listener, d.getTestErrorWrapper(function trackerRegistered(success, errors) {
                                log.debug("trackerRegistered");
                                tests.assertTrue(success);

                                // Now the tracker is registered. Let's add and remove some statements to see if we get the real-time-updates.
                                graph.add(firstStatement);
                                graph.add(secondStatement);
                                graph.add(thirdStatement); // Should not fire an event since it doesn't match the tracker.
                                graph.add(fourthStatement);

                                log.debug("about to update repository for adds.");
                                // Commit those statement additions
                                var addCompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onAddsComplete(success, errors) {
                                    log.debug("repositoryUpdate for adds");
                                    tests.assertTrue(success);
                                    dojo.disconnect(addCompleteHandle);

                                    log.debug("about to do some removes.");
                                    
                                    // Now we'll remove some statements to test the statementsRemoved event.
                                    graph.remove(secondStatement);
                                    graph.remove(thirdStatement); // Should not fire an event.

                                    log.debug("about to do update repository for removes.");

                                    var removeCompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onRemovesComplete(success, errors) {
                                        log.debug("repositoryUpdate for removes.");
                                        tests.assertTrue(success);
                                        dojo.disconnect(removeCompleteHandle);
                                        
                                        // All we need to do now is wait around for the events. We'll poll a few times.
                                        var pollCount = 0;
                                        var pollCallback = d.getTestErrorWrapper(function pollCallback() {
                                            log.debug("test_receivesAddRemoveStatementRealtimeUpdates - pollCallback");
                                            var success = sawFirstStatementAdded && sawSecondStatementAdded && sawSecondStatementRemoved && sawFourthStatementAdded;
                                            if (success) {
                                                anzoClient.close(d.getTestErrorWrapper(function(status){
                                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                    d.callback(true);
                                                }));
                                            } else {
                                                if (!sawFirstStatementAdded) {
                                                    log.debug("test_receivesAddRemoveStatementRealtimeUpdates - statementAdded event not yet received for: " + firstStatement.toString());
                                                }
                                                if (!sawSecondStatementAdded) {
                                                    log.debug("test_receivesAddRemoveStatementRealtimeUpdates - statementAdded event not yet received for: " + secondStatement.toString());
                                                }
                                                if (!sawSecondStatementRemoved) {
                                                    log.debug("test_receivesAddRemoveStatementRealtimeUpdates - statementRemoved not yet received for:" + secondStatement.toString());
                                                }
                                                if (!sawFourthStatementAdded) {
                                                    log.debug("test_receivesAddRemoveStatementRealtimeUpdates - statementAdded event not yet received for: " + fourthStatement.toString());
                                                }
                                                
                                                log.debug("test_receivesAddRemoveStatementRealtimeUpdates - Not all statement real-time updates received yet. Iteration #" + pollCount + ". Polling again.");
                                                if (pollCount > 5) {
                                                    throw new Error("All expected real-time updates were not received within the timeout.");
                                                }
                                                pollCount++;
                                                setTimeout(pollCallback, 1000);
                                            }
                                        });
                                        setTimeout(pollCallback, 1000);
                                    }));
                                    anzoClient.updateRepository();
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
           name : "test_receivesAddRemoveDatasetChangedRealtimeUpdates",
           timeout : 20000,
           setUp : function() {
           },
           runTest : function test_receivesAddRemoveDatasetChangedRealtimeUpdates() {
                // summary: Registers a dataset tracker waits for the notifications about modifying graphs, adding graphs to a named dataset,
                // and changing graphs referenced by named datasets.

                var d = new doh.Deferred(); // Return a Deferred object to let the test system know to wait around for the response.

                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function(suc) {
                        // First create a few graphs. One to be referenced as a dataset default graph, a named graph, and graphs to be referenced
                        // by a named dataset. Also create a named dataset. These are the graphs we'll be tracking.
                        tests.assertTrue(suc);
                        var defaultGraphUri = "http://example.org/defaultGraph1";
                        var namedGraphUri = "http://example.org/namedGraph1";
                        var namedDatasetUri = "http://example.org/namedDataset1";
                        var defaultGraph2Uri = "http://example.org/defaultGraph2";
                        var namedGraph2Uri = "http://example.org/namedGraph2";
                        
                        anzoClient.getReplicaGraphs([ defaultGraphUri, namedGraphUri, defaultGraph2Uri, namedGraph2Uri ], null, d.getTestErrorWrapper(function onGetReplicaGraphsComplete(graphMap, errors) {
                            log.debug("onGetReplicaGraphsComplete");
                            tests.assertTrue(graphMap != null);
                            var defaultGraph1 = graphMap[defaultGraphUri];
                            var namedGraph1 = graphMap[namedGraphUri];
                            var defaultGraph2 = graphMap[defaultGraph2Uri];
                            var namedGraph2 = graphMap[namedGraph2Uri];
                            tests.assertTrue(defaultGraph1 != null);
                            tests.assertTrue(namedGraph1 != null);
                            tests.assertTrue(defaultGraph2 != null);
                            tests.assertTrue(namedGraph2 != null);

                            // Now create the named dataset
                            anzoClient.createReplicaDataset(true, namedDatasetUri, [ defaultGraph2Uri ], [ namedGraph2 ], d.getTestErrorWrapper(function onCreateReplicaDataset(namedDataset) {
                                log.debug("onCreateReplicaDataset");
                                tests.assertTrue(namedDataset != null);
                                
                                log.debug("about to call updateRepository for createGraphs.");
                                var createGraphsCompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onCreateGraphsComplete(success, errors) {
                                    log.debug("repositoryUpdate for createGraphs");
                                    tests.assertTrue(success);
                                    dojo.disconnect(createGraphsCompleteHandle);
                                    createGraphsCompleteHandle = null;
                                
                                    // Now that the test data is primed, we can register for tracker and listen for the proper notifications.
                                    var realtimeUpdates = anzoClient.realtimeUpdates;
                                    
                                    var sawDatasetChanged = false;
                                    var listener = { 
                                        datasetChanged : d.getTestErrorWrapper(function onDatasetChanged() {
                                            log.debug("datasetChanged event.");
                                            sawDatasetChanged = true;
                                        })
                                    };
                                    var trackerUri = "http://example.com/myTracker1";
                                    realtimeUpdates.addDatasetTracker(trackerUri, defaultGraphUri, namedGraphUri, namedDatasetUri, listener, d.getTestErrorWrapper(function datasetTrackerRegistered(success, errors) {
                                        log.debug("datasetTrackerRegistered");
                                        tests.assertTrue(success);
        
                                        var TestData = new anzo.tests.client.TestData();
        
                                        // Now the tracker is registered. Let's modify each graph and see if we get a notification as expected.
                                        defaultGraph1.add(TestData.subj1, TestData.pred1, TestData.obj1);
                                        log.debug("about to update repository for defaultGraph1.");
                                        
                                        var defaultGraph1CompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onDefaultGraph1Complete(success, errors) {
                                            log.debug("repositoryUpdate for defaultGraph1");
                                            tests.assertTrue(success);
                                            dojo.disconnect(defaultGraph1CompleteHandle);
                                            defaultGraph1CompleteHandle = null;
        
                                            var condition = function() { 
                                                log.debug("Polling - sawDatasetChanged: " + sawDatasetChanged);
                                                return sawDatasetChanged; 
                                            }
                                            anzo.tests.utilities.waitFor(condition, 2000, 300, d.getTestErrorWrapper(function onSawDatasetChanged(success) {
                                                log.debug("Done waiting for defaultGraph1 event - success: " + success);
                                                tests.assertTrue(success);
                                                sawDatasetChanged = false; // reset for next modification
    
                                                // Now we'll add a statement to the namedGraph we are tracking and see if we get the event
                                                namedGraph1.add(TestData.subj2, TestData.pred2, TestData.obj2);
            
                                                log.debug("about to do update repository for namedGraph1.");
            
                                                var namedGraph1CompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onNamedGraph1Complete(success, errors) {
                                                    log.debug("repositoryUpdate for namedGraph1.");
                                                    tests.assertTrue(success);
                                                    dojo.disconnect(namedGraph1CompleteHandle);
                                                    namedGraph1CompleteHandle = null;
    
                                                    anzo.tests.utilities.waitFor(condition, 2000, 300, d.getTestErrorWrapper(function onSawDatasetChanged(success) {
                                                        log.debug("Done waiting for namedGraph1 event - success: " + success);
                                                        tests.assertTrue(success);
                                                        sawDatasetChanged = false; // reset for next modification
            
                                                        // Now we'll add a statement to the defaultGraph2 which we are tracking indirectly because we
                                                        // are tracking the namedDataset that references it.
                                                        defaultGraph2.add(TestData.subj3, TestData.pred3, TestData.obj3);
                    
                                                        log.debug("about to do update repository for defaultGraph2.");
                    
                                                        var defaultGraph2CompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onDefaultGraph2Complete(success, errors) {
                                                            log.debug("repositoryUpdate for defaultGraph2.");
                                                            tests.assertTrue(success);
                                                            dojo.disconnect(defaultGraph2CompleteHandle);
                                                            defaultGraph2CompleteHandle = null;
    
                                                            anzo.tests.utilities.waitFor(condition, 2000, 300, d.getTestErrorWrapper(function onSawDatasetChanged(success) {
                                                                log.debug("Done waiting for defaultGraph2 event - success: " + success);
                                                                tests.assertTrue(success);
                                                                sawDatasetChanged = false; // reset for next modification
                    
                                                                // Now we'll add a statement to the namedGraph2 which we are tracking indirectly because we
                                                                // are tracking the namedDataset that references it.
                                                                namedGraph2.add(TestData.subj3, TestData.pred3, TestData.obj3);
                            
                                                                log.debug("about to do update repository for namedGraph2.");
                            
                                                                var namedGraph2CompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onNamedGraph2Complete(success, errors) {
                                                                    log.debug("repositoryUpdate for namedGraph2.");
                                                                    tests.assertTrue(success);
                                                                    dojo.disconnect(namedGraph2CompleteHandle);
                                                                    namedGraph2CompleteHandle = null;
    
                                                                    anzo.tests.utilities.waitFor(condition, 2000, 300, d.getTestErrorWrapper(function onSawDatasetChanged(success) {
                                                                        log.debug("Done waiting for namedGraph2 event - success: " + success);
                                                                        tests.assertTrue(success);
                                                                        sawDatasetChanged = false; // reset for next modification
                            
                                                                        // Now we'll add a whole graph to the namedDataset to ensure we get an event for changing the actual named dataset.
                                                                        namedDataset.addNamedGraph("http://example.com/namedGraph3", d.getTestErrorWrapper(function onNewNamedDatasetNamedGraph(namedGraph3, errors) {
                                                                            tests.assertTrue(namedGraph3);
                                                                            log.debug("about to do update repository for namedGraph3.");
                                        
                                                                            var namedGraph3CompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onNamedGraph3Complete(success, errors) {
                                                                                log.debug("repositoryUpdate for namedGraph3.");
                                                                                tests.assertTrue(success);
                                                                                dojo.disconnect(namedGraph3CompleteHandle);
                                                                                namedGraph3CompleteHandle = null;
    
                                                                                anzo.tests.utilities.waitFor(condition, 2000, 300, d.getTestErrorWrapper(function onSawDatasetChanged(success) {
                                                                                    log.debug("Done waiting for namedGraph3 event - success: " + success);
                                                                                    tests.assertTrue(success);
                                                                                    sawDatasetChanged = false; // reset for next modification
                                                                                    
                                                                                    // Now we'll change the graph which we recently added to the dataset. We'll see if we get the notification about the changed dataset.
                                                                                    namedGraph3.add("http://example.com/subInGraph3", "http://example.com/predInGraph3", "http://example.com/objInGraph3");
                                                                                                                                                                        
                                                                                    var namedGraph3ChangeCompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onNamedGraph3ChangeComplete(success, errors) {
                                                                                        log.debug("repositoryUpdate for namedGraph3 change.");
                                                                                        tests.assertTrue(success);
                                                                                        dojo.disconnect(namedGraph3ChangeCompleteHandle);
                                                                                        namedGraph3ChangeCompleteHandle = null;
            
                                                                                        anzo.tests.utilities.waitFor(condition, 2000, 300, d.getTestErrorWrapper(function onSawNamedGraph3Changed(success) {
                                                                                            log.debug("Done waiting for namedGraph3 changed event - success: " + success);
                                                                                            tests.assertTrue(success);
                                                                                            sawDatasetChanged = false; // reset for next modification
                                                                                            
                                                                                            // All done!
                                                                                            anzoClient.close(d.getTestErrorWrapper(function(status){
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
                                                                anzoClient.updateRepository();
                                                            }));
                                                        }));
                                                        anzoClient.updateRepository();
                                                    }));
                                                }));
                                                anzoClient.updateRepository();
                                            }));
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
           name : "test_receivesTransactionEvents",
           timeout : 20000,
           setUp : function() {
           },
           runTest : function test_receivesTransactionEvents() {

                var d = new doh.Deferred(); // Return a Deferred object to let the test system know to wait around for the response.

                var TestData = new anzo.tests.client.TestData();

                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function(suc) {
                        // First create a graph in the repository to which we'll be adding statements.
                        tests.assertTrue(suc);
                        
                        var realtimeUpdates = anzoClient.realtimeUpdates;
                        
                        var sawTransactionEvent = false;
                        var listener = d.getTestErrorWrapper(function(uri, timestamp, graphUris, transactionContext) {
                            log.debug("test_receivesTransactionEvents - Inside listener.");
                            tests.assertEqual(TestData.graph1, graphUris[0]);
                            tests.assertEqual(1, transactionContext.size());
                            sawTransactionEvent = true;
                        });
                        
                        dojo.connect(realtimeUpdates, "transactionComplete", listener);
                        
                        log.debug("test_receivesTransactionEvents - getting replica graph.");
                        anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            log.debug("test_receivesTransactionEvents - got replica graph.");
                            tests.assertTrue(graph != null);
                            anzoClient.commit();
                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                log.debug("test_receivesTransactionEvents - updateRepositoryComplete.");
                                tests.assertTrue(success);
                                dojo.disconnect(handle);
                                
                                //log.debug("STORE\n" + dojo.toJson(anzoClient.quadStore.find(),true));
                                
                                realtimeUpdates.registerForTransactionUpdates(d.getTestErrorWrapper(function registerComplete(success, error) {
                                    log.debug("test_receivesTransactionEvents - Registered for transaction updates");
                                    tests.assertTrue(success);
                                    anzoClient.begin();
                                    anzoClient.getTransactionContext().add(TestData.stmt5);
                                    graph.add(TestData.stmt1);	
                                    graph.add(TestData.stmt2);		
                                    anzoClient.commit();
                                    tests.assertTrue(graph.contains(TestData.stmt1));
                                    tests.assertTrue(graph.contains(TestData.stmt2));
                                    
                                    var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                        log.debug("test_receivesTransactionEvents - second updateRepositoryComplete");
                                        tests.assertTrue(success);
                                        dojo.disconnect(handle);
                                        
                                        tests.assertTrue(graph.contains(TestData.stmt1));
                                        tests.assertTrue(graph.contains(TestData.stmt2));
                                        
                                        tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt1));
                                        tests.assertTrue(anzoClient.quadStore.contains(TestData.stmt2));

                                        anzo.tests.utilities.waitFor(function() { return sawTransactionEvent; }, 1000, 300, d.getTestErrorWrapper(function onSawDatasetChanged(success) {
                                            anzoClient.close(d.getTestErrorWrapper(function(status){
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
            }
        },

        {
            name : "test_TrackersFireWhenMatchingStatementIsNotified",
            timeout : 10000,
            setUp : function() {
            },
            runTest : function test_TrackersFireWhenMatchingStatementIsNotified() {
                // summary: Test various formulations of trackers and make sure that events are fired for 
                //   each only when appropriate. This reaches into some private methods of the RealtimeUpdateManager
                //   to notify the trackers without needing a server.
                
                var d = new doh.Deferred(); // Return a Deferred object to let the test system know to wait around for the response.
                
                var rtclient = new anzo.client.RealtimeUpdateManager(new anzo.client.AnzoClient({}));
                
                var addEventCounts = [];
                var removeEventCounts = [];
    
                var stmt = anzo.createStatement('http://subj1', 'http://pred1', 'http://obj1', 'http://graph1');
                var stmt2 = anzo.createStatement('http://subj11', 'http://pred11', 'http://obj11', 'http://graph11');
                
                // We add a tracker for every combination of listening to 'stmt'. For example,
                // rtclient.addTracker('http://subj1', null, null, null,...
                // rtclient.addTracker('http://subj1', 'http://pred1', null, null,...
                // rtclient.addTracker(null, 'http://pred1', null, null,...
                // and so on...including rtclient.addTracker(null, null, null, null...
                // We don't use the callback since we aren't going to the server then we know the 
                // tracker registration is instant because the client isn't yet connected.
                var countIndex = 0;
                for (var i = 0; i < 2; i++) {
                    for (var j = 0; j < 2; j++) {
                        for (var k = 0; k < 2; k++) {
                            for (var l = 0; l < 2; l++) {
                                addEventCounts.push(0);
                                removeEventCounts.push(0);
    
                                rtclient.addTracker(i == 0 ? stmt.subject : null,
                                    j == 0 ? stmt.predicate : null,
                                    k == 0 ? stmt.object : null, 
                                    l == 0 ? stmt.namedGraphUri : null,
                                    {
                                        statementsAdded : (function(index) { return function() { addEventCounts[index]++; }; })(countIndex),
                                        statementsRemoved : (function(index) { return function() { removeEventCounts[index]++; }; })(countIndex)
                                    }
                                );
                                countIndex++;
                            }
                        }
                    }
                }
    
                // Notify of a statement addition that matches all of the trackers
                rtclient._notifyTrackers(true, stmt);
                setTimeout(function() {
                    for (var i = 0; i < addEventCounts.length; i++) {
                        tests.assertEqual(1, addEventCounts[i]);
                    }
        
                    // Notify of a statement removal that matches all of the trackers
                    rtclient._notifyTrackers(false, stmt);
                    setTimeout(function() {
                        for (var i = 0; i < removeEventCounts.length; i++) {
                            tests.assertEqual(1, removeEventCounts[i]);
                        }
                        
                        // Notify of a statement addition that DOESN'T match most of the trackers.
                        // It only matches the last one (null,null,null,null).
                        rtclient._notifyTrackers(true, stmt2);
                        setTimeout(function() {
                            for (var i = 0; i < addEventCounts.length - 1; i++) {
                                tests.assertEqual(1, addEventCounts[i]);
                            }
                            tests.assertEqual(2, addEventCounts[addEventCounts.length - 1]);
                
                            // Notify of a statement removal that DOESN'T match most of the trackers.
                            // It only matches the last one (null,null,null,null).
                            rtclient._notifyTrackers(false, stmt2);
                            setTimeout(function() {
                                for (var i = 0; i < removeEventCounts.length - 1; i++) {
                                    tests.assertEqual(1, removeEventCounts[i]);
                                }
                                tests.assertEqual(2, removeEventCounts[removeEventCounts.length - 1]);
                    
                                // Now remove all of the trackers and reset the event counts.
                                countIndex = 0;
                                for (var i = 0; i < 2; i++) {
                                    for (var j = 0; j < 2; j++) {
                                        for (var k = 0; k < 2; k++) {
                                            for (var l = 0; l < 2; l++) {
                                                addEventCounts[countIndex] = 0;
                                                removeEventCounts[countIndex] = 0;
                                                rtclient.removeTracker(i == 0 ? stmt.subject : null,
                                                    j == 0 ? stmt.predicate : null,
                                                    k == 0 ? stmt.object : null, 
                                                    l == 0 ? stmt.namedGraphUri : null
                                                );
                                                countIndex++;
                                            }
                                        }
                                    }
                                }
                    
                                // Notify of a statement addition that should match trackers but they are all unregistered. 
                                rtclient._notifyTrackers(true, stmt);
                                setTimeout(function() {
                                    for (var i = 0; i < addEventCounts.length; i++) {
                                        tests.assertEqual(0, addEventCounts[i]);
                                    }
                        
                                    // Notify of a statement removal that should match trackers but they are all unregistered. 
                                    rtclient._notifyTrackers(false, stmt);
                                    setTimeout(function() {
                                        for (var i = 0; i < removeEventCounts.length; i++) {
                                            tests.assertEqual(0, removeEventCounts[i]);
                                        }
                                        
                                        d.callback(true);
                                    }, 0);
                                }, 0);
                            }, 0);
                        }, 0);
                    }, 0);
                }, 0);
    
                return d;
            }
        },

        {
           name : "test_subscriptionsAreAddedUponConnect",
           timeout : 20000,
           setUp : function() {
           },
           runTest : function test_subscriptionsAreAddedUponConnect() {
                // summary: Registers a tracker before connecting. It then connects and checks that we receive
                //   notifications for those trackers and transactions.

                var d = new doh.Deferred(); // Return a Deferred object to let the test system know to wait around for the response.

                var TestData = new anzo.tests.client.TestData();

                // Reset first since we will ruin the real-time update subscription state on the server if we reset after the connecting.
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function(suc) {
                        tests.assertTrue(suc);
                        anzoClient.close(d.getTestErrorWrapper(function(status){
                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                            
                            // Create a brand new anzoClient to start from a clean slate
                            anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                            
                            // Setup a tracker and a transaction listener before connecting the AnzoClient
                            var sawStatement = false;
                            var sawTransaction = false;
                            var listener = { 
                                statementsAdded : d.getTestErrorWrapper(function onStatementsAdded(statements) {
                                    log.debug("statementsAdded event.");
                                    tests.assertEqual(1, statements.length);
                                    tests.assertTrue(statements[0].equals(TestData.stmt1));
                                    sawStatement = true;
                               }),
                               statementsRemoved : d.getTestErrorWrapper(function onStatementsRemoved(statements) {
                                   throw new Error("Unexpected statementsRemoved real-time update event. Only expected additions.");
                               })
                            }
                            anzoClient.realtimeUpdates.addTracker(TestData.subj1, TestData.pred1, null, TestData.graph1, listener, d.getTestErrorWrapper(function trackerRegistered(success, errors) {
                                log.debug("addTracker done");
                                tests.assertTrue(success);
            
                                var transactionListenerHandle = dojo.connect(anzoClient.realtimeUpdates, "transactionComplete", d.getTestErrorWrapper(function(uri, timestamp, graphUris, transactionContext) {
                                    log.debug("transactionComplete event.");
                                    dojo.disconnect(transactionListenerHandle);
                                    //tests.assertEqual(1, graphUris.length);
                                    //tests.assertEqual(TestData.graph1, graphUris[0]);
                                    sawTransaction = true;
                                }));
                                
                                anzoClient.realtimeUpdates.registerForTransactionUpdates(d.getTestErrorWrapper(function registerComplete(success, error) {
                                    log.debug("registerForTransactionUpdates done");
                                    tests.assertTrue(success);
            
                                    // Now that we've setup the tracker and transaction listener, we'll connect and make some changes
                                    anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                                        anzoClient.begin();
                                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function onGetReplicaGraphComplete(graph, errors) {
                                            log.debug("onGetReplicaGraphComplete");
                                            tests.assertTrue(graph != null);
                                            
                                            graph.add(TestData.subj1, TestData.pred1, TestData.obj1);
                                            
                                            anzoClient.commit();
        
                                            var addCompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onUpdateComplete(success, errors) {
                                                log.debug("repositoryUpdateComplete");
                                                tests.assertTrue(success);
                                                dojo.disconnect(addCompleteHandle);
                                                
                                                var pollCount = 0;
                                                var pollCallback = d.getTestErrorWrapper(function pollCallback() {
                                                    log.debug("pollCallback");
                                                    var success = sawStatement && sawTransaction;
                                                    if (success) {
                                                        anzoClient.close(d.getTestErrorWrapper(function(status){
                                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                            d.callback(true);
                                                        }));
                                                    } else {
                                                        if (!sawStatement) {
                                                            log.debug("statementAdded event not yet received for: " + TestData.stmt1.toString());                                                
                                                        }
                                                        if (!sawTransaction) {
                                                            log.debug("transactionComplete event not yet received.");                                                
                                                        }
                                                        log.debug("Not all real-time updates received yet. Iteration #" + pollCount + ". Polling again.");
                                                        if (pollCount > 5) {
                                                            throw new Error("All expected real-time updates were not received within the timeout.");
                                                        }
                                                        pollCount++;
                                                        setTimeout(pollCallback, 1000);
                                                    }
                                                });
                                                setTimeout(pollCallback, 1000);
                                            }));
                                            anzoClient.updateRepository();
                                        }));
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
           name : "test_subscriptionsAreRestoredAfterDisconnect",
           timeout : 50000, // @@
           setUp : function() {
           },
           runTest : function test_subscriptionsAreRestoredAfterDisconnect() {
                // summary: Connects and registers some trackers. Then it disconnects and reconnects. Then
                //   some modifications are sent to the server to see if we get the real-time updates. This tests
                //   if the tracker and transaction handlers are maintained across disconnect and reconnect.

                var d = new doh.Deferred(); // Return a Deferred object to let the test system know to wait around for the response.

                var TestData = new anzo.tests.client.TestData();

                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function(suc) {
                        tests.assertTrue(suc);
                            
                        // Setup a tracker and a transaction listener before connecting the AnzoClient
                        var sawStatement = false;
                        var sawTransaction = false;
                        var listener = { 
                            statementsAdded : d.getTestErrorWrapper(function onStatementsAdded(statements) {
                                log.debug("statementsAdded event.");
                                tests.assertEqual(1, statements.length);
                                tests.assertTrue(statements[0].equals(TestData.stmt1));
                                sawStatement = true;
                           }),
                           statementsRemoved : d.getTestErrorWrapper(function onStatementsRemoved(statements) {
                               throw new Error("Unexpected statementsRemoved real-time update event. Only expected additions.");
                           })
                        }
                        anzoClient.realtimeUpdates.addTracker(TestData.subj1, TestData.pred1, null, TestData.graph1, listener, d.getTestErrorWrapper(function trackerRegistered(success, errors) {
                            log.debug("addTracker done");
                            tests.assertTrue(success);
        
                            var transactionListenerHandle = dojo.connect(anzoClient.realtimeUpdates, "transactionComplete", d.getTestErrorWrapper(function(uri, timestamp, graphUris, transactionContext) {
                                log.debug("transactionComplete event.");
                                dojo.disconnect(transactionListenerHandle);
                                //tests.assertEqual(1, graphUris.length);
                                //tests.assertEqual(TestData.graph1, graphUris[0]);
                                sawTransaction = true;
                            }));
                            
                            anzoClient.realtimeUpdates.registerForTransactionUpdates(d.getTestErrorWrapper(function registerComplete(success, error) {
                                log.debug("registerForTransactionUpdates done");
                                tests.assertTrue(success);
        
                                // Now that we've setup the tracker and transaction listener while connected, we'll disconnect and reconnect to see if the subscription is maintained.
                                anzoClient.disconnect(d.getTestErrorWrapper(function disconnected(status) {
                                    log.debug("disconnected...going to reconnect");
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                                        tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                                        anzoClient.begin();
                                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function onGetReplicaGraphComplete(graph, errors) {
                                            log.debug("onGetReplicaGraphComplete");
                                            tests.assertTrue(graph != null);
                                            
                                            graph.add(TestData.subj1, TestData.pred1, TestData.obj1);
                                            
                                            anzoClient.commit();
        
                                            var addCompleteHandle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function onUpdateComplete(success, errors) {
                                                log.debug("repositoryUpdateComplete");
                                                tests.assertTrue(success);
                                                dojo.disconnect(addCompleteHandle);
                                                
                                                var pollCount = 0;
                                                var pollCallback = d.getTestErrorWrapper(function pollCallback() {
                                                    log.debug("pollCallback");
                                                    var success = sawStatement && sawTransaction;
                                                    if (success) {
                                                        anzoClient.close(d.getTestErrorWrapper(function(status){
                                                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                                            d.callback(true);
                                                        }));
                                                    } else {
                                                        if (!sawStatement) {
                                                            log.debug("statementAdded event not yet received for: " + TestData.stmt1.toString());                                                
                                                        }
                                                        if (!sawTransaction) {
                                                            log.debug("transactionComplete event not yet received.");                                                
                                                        }
                                                        log.debug("Not all real-time updates received yet. Iteration #" + pollCount + ". Polling again.");
                                                        if (pollCount > 5) {
                                                            throw new Error("All expected real-time updates were not received within the timeout.");
                                                        }
                                                        pollCount++;
                                                        setTimeout(pollCallback, 1000);
                                                    }
                                                });
                                                setTimeout(pollCallback, 1000);
                                            }));
                                            anzoClient.updateRepository();
                                        }));
                                    }));
                                }));
                            }));
                            
                        }));
                    }));
                }));
    
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
