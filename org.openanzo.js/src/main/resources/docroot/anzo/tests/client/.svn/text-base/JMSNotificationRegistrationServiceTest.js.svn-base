/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Cambridge Semantics Incorporated - initial API and
 * implementation
 ******************************************************************************/

/*
 * @author Jordi Albornoz Mulligan (<a
 * href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.JMSNotificationRegistrationServiceTest");

dojo.require("anzo.client._JMSNotificationRegistrationService");
dojo.require("anzo.client._Tracker");
dojo.require("anzo.tests.properties");
dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.log");

( function() {
    var log = anzo.log.getLogger("anzo.tests.client.JMSNotificationRegistrationServiceTest");

    tests.registerGroup("anzo.tests.client.JMSNotificationRegistrationServiceTest", [ {
        name :"test_registerTrackerOpsAllowNullCallback",
        timeout :10000,
        setUp : function() {
        },
        runTest : function test_registerTrackerAllowsNullCallbacks() {
            // summary: Call the registerTracker and unregisterTracker methods
            // with null callbacks.

        var d = new doh.Deferred(); // Return a Deferred object to let the test
                                    // system know to wait around for the
                                    // response.

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            var tracker = new anzo.client._StatementTracker(anzo.createURI("http://example.com/21"), anzo.createURI("http://example.com/22"), anzo.client.Vocabulary.ANY, anzo.createURI("http://example.com/23"));
            notificationService.registerTrackers(tracker);
            notificationService.unregisterTrackers(tracker);

            // Wait a few seconds to ensure there is enough time to have the
            // tracker operations
                // fail if they are going to. Unfortunately, there's nothing we
                // can do here but use a timeout
                // since we're testing what happens when there are no callbacks
                // supplied.
                setTimeout(d.getTestErrorWrapper( function() {
                    notificationService.disconnect(d.getTestErrorWrapper( function onDisconnect(success, error) {
                        tests.assertTrue(success);

                        // Without a callback this is only way to tell success
                        // is to get some cooperation from the
                        // notificationService.
                            // It keeps this count for us to check for any
                            // problems.
                            tests.assertTrue(notificationService._testExceptionCount == 0);

                            anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                                d.callback(true);
                            }));
                        }));
                }), 2000);

            }));

        return d;
    }
    },

    {
        name :"test_registerTrackerAllowsDuplicateTrackerRegistration",
        timeout :10000,
        setUp : function() {
        },
        runTest : function test_registerTrackerAllowsDuplicateTrackerRegistration() {
            // summary: Register a tracker with the server twice in a row. Both
            // should succeed.

        var d = new doh.Deferred(); // Return a Deferred object to let the test
                                    // system know to wait around for the
                                    // response.

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            var tracker = new anzo.client._StatementTracker(anzo.createURI("http://example.com/1"), anzo.createURI("http://example.com/2"), anzo.client.Vocabulary.ANY, anzo.createURI("http://example.com/3"));
            notificationService.registerTrackers(tracker, null, d.getTestErrorWrapper( function _registerTrackerCallback(success, error) {
                tests.assertTrue(success); // First one succeeded.

                    // Since we haven't yet connected in the notification
                    // service, it should have automatically
                    // connected. Verify that the automatic connection worked
                    // correctly.
                    tests.assertTrue(notificationService._isConnected);
                    tests.assertTrue(notificationService._jmsMessageListenerHandle != null);

                    // Now register the same tracker again.
                    notificationService.registerTrackers(tracker, null, d.getTestErrorWrapper( function _secondTrackerCallback(success, error) {
                        tests.assertTrue(success); // Second one succeeded.

                            notificationService.disconnect(d.getTestErrorWrapper( function onDisconnect(success, error) {
                                tests.assertTrue(success);
                                // Test finished successfully.
                                    anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                                        d.callback(true);
                                    }));
                                }));
                        }));
                }));
        }));

        return d;
    }
    },

    {
        name :"test_unregisterTrackerRemovesExistingTracker",
        timeout :10000,
        setUp : function() {
        },
        runTest : function test_unregisterTrackerRemovesExistingTracker() {
            // summary: Register a tracker and then remove it.

        var d = new doh.Deferred(); // Return a Deferred object to let the test
                                    // system know to wait around for the
                                    // response.

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
            // log.debug("test_unregisterTrackerRemovesExistingTracker -
            // connected.")

                var notificationService = new anzo.client._JMSNotificationRegistrationService();
                var tracker = new anzo.client._StatementTracker(anzo.createURI("http://example.com/10"), anzo.createURI("http://example.com/11"), anzo.client.Vocabulary.ANY, anzo.createURI("http://example.com/13"));
                notificationService.registerTrackers(tracker, null, d.getTestErrorWrapper( function _registerTrackerCallback(success, error) {
                    // log.debug("test_unregisterTrackerRemovesExistingTracker -
                    // tracker registered.")
                        tests.assertTrue(success); // Registration succeeded.

                        // Since we haven't yet connected in the notification
                        // service, it should have automatically connected.
                        // Verify that the automatic connection worked correctly
                        tests.assertTrue(notificationService._isConnected);
                        tests.assertTrue(notificationService._jmsMessageListenerHandle != null);

                        // Now unregister that same tracker.
                        notificationService.unregisterTrackers(tracker, null, d.getTestErrorWrapper( function _unregisterTrackerCallback(success, error) {
                            // log.debug("test_unregisterTrackerRemovesExistingTracker
                            // - tracker unregistered.")
                                tests.assertTrue(success); // Unregistration
                                                            // succeeded.

                                notificationService.disconnect(d.getTestErrorWrapper( function onDisconnect(success, error) {
                                    tests.assertTrue(success);
                                    // Test finished successfully.
                                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                                            d.callback(true);
                                        }));
                                    }));
                            }));
                    }));
            }));

        return d;
    }
    },

    {
        name :"test_unregisterTrackerSucceedsWhenTrackerDoesNotExist",
        timeout :10000,
        setUp : function() {
        },
        runTest : function test_unregisterTracker() {
            // summary: call unregisterTracker on a tracker that hasn't been
            // registered.
        var d = new doh.Deferred(); // Return a Deferred object to let the test
                                    // system know to wait around for the
                                    // response.

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            var tracker = new anzo.client._StatementTracker(anzo.createURI("http://example.com/unknown"), anzo.createURI("http://example.com/unknown/2"), anzo.client.Vocabulary.ANY, anzo.createURI("http://example.com/unknown/3"));
            notificationService.unregisterTrackers(tracker, null, d.getTestErrorWrapper( function _unregisterTrackerCallback(success, error) {
                tests.assertTrue(success);
                notificationService.disconnect(d.getTestErrorWrapper( function onDisconnect(success, error) {
                    tests.assertTrue(success);
                    // Test finished successfully.
                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                            d.callback(true);
                        }));
                    }));
            }));
        }));

        return d;
    }
    },

    {
        name :"test_unregisterTrackerRemovesExistingDatasetTracker",
        timeout :10000,
        setUp : function() {
        },
        runTest : function test_unregisterTrackerRemovesExistingDatasetTracker() {
            // summary: Register a dataset tracker and then remove it.
        var d = new doh.Deferred(); // Return a Deferred object to let the test
                                    // system know to wait around for the
                                    // response.

        var origLogLevel = anzo.log.getLogger("anzo.messaging.JMSMessageTrace").getLevel();
        anzo.log.getLogger("anzo.messaging.JMSMessageTrace").setLevel(anzo.log.log4javascript.Level.DEBUG);
        
        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
            log.debug("test_unregisterTrackerRemovesExistingDatasetTracker - connected.")

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            var tracker = new anzo.client._DatasetTracker(anzo.createURI("http://example.com/datasetTrackerTest1"), anzo.createURI("http://example.com/defaultGraph1"), anzo.createURI("http://example.com/namedGraph1"), anzo.createURI("http://example.com/namedDataset1"));

            notificationService.registerTrackers(null, tracker, d.getTestErrorWrapper( function _registerTrackerCallback(success, error) {
                log.debug("test_unregisterTrackerRemovesExistingDatasetTracker - tracker registered - success:" + success);
                tests.assertTrue(success); // Registration succeeded.

                // Since we haven't yet connected in the notification
                // service, it should have automatically connected. Verify
                // that the automatic connection worked correctly
                tests.assertTrue(notificationService._isConnected);
                log.debug("test_unregisterTrackerRemovesExistingDatasetTracker - tested _isConnected.");
                tests.assertTrue(notificationService._jmsMessageListenerHandle != null);
                log.debug("test_unregisterTrackerRemovesExistingDatasetTracker - about to unregister the tracker.");

                // Now unregister that same tracker.
                notificationService.unregisterTrackers(null, tracker, d.getTestErrorWrapper( function _unregisterTrackerCallback(success, error) {
                    log.debug("test_unregisterTrackerRemovesExistingDatasetTracker - tracker unregistered - success:" + success);
                    tests.assertTrue(success); // Unregistration succeeded.

                    notificationService.disconnect(d.getTestErrorWrapper( function onDisconnect(success, error) {
                        log.debug("test_unregisterTrackerRemovesExistingDatasetTracker - disconnecting from notification service - success:" + success);
                        tests.assertTrue(success);
                        // Test finished successfully.
                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                            anzo.log.getLogger("anzo.messaging.JMSMessageTrace").setLevel(origLogLevel);
                            d.callback(true);
                        }));
                    }));
                }));
            }));
        }));

        return d;
    }
    },

    {
        name :"test_connectThenDisconnect",
        timeout :10000,
        setUp : function() {
        },
        runTest : function test_connectThenDisconnect() {
            // summary: connect and then immediately disconnect.

        var d = new doh.Deferred(); // Return a Deferred object to let the test
                                    // system know to wait around for the
                                    // response.

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            // Haven't connected yet.
                tests.assertTrue(!notificationService._isConnected);
                tests.assertTrue(notificationService._jmsMessageListenerHandle == null);

                notificationService.connect(d.getTestErrorWrapper( function _connectCallback(success, error) {
                    tests.assertTrue(success);
                    tests.assertTrue(notificationService._isConnected);
                    tests.assertTrue(notificationService._jmsMessageListenerHandle != null);

                    // Now disconnect.
                        notificationService.disconnect(d.getTestErrorWrapper( function _disconnectCallback(success, error) {
                            tests.assertTrue(success);
                            tests.assertTrue(!notificationService._isConnected);
                            tests.assertTrue(notificationService._jmsMessageListenerHandle == null);

                            // Test finished successfully.
                                anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                                    d.callback(true);
                                }));
                            }));
                    }));
            }));

        return d;
    }
    },

    {
        name :"test_disconnectSucceedsOnAlreadyDisconnectedService",
        timeout :10000,
        setUp : function() {
        },
        runTest : function test_disconnectSucceedsOnAlreadyDisconnectedService() {
            // summary: calling disonnect on a disconnected service should work

        var d = new doh.Deferred(); // Return a Deferred object to let the test
                                    // system know to wait around for the
                                    // response.

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            // Haven't connected yet.
                tests.assertTrue(!notificationService._isConnected);
                tests.assertTrue(notificationService._jmsMessageListenerHandle == null);

                notificationService.disconnect(d.getTestErrorWrapper( function _disconnectCallback(success, error) {
                    tests.assertTrue(success);
                    tests.assertTrue(!notificationService._isConnected);
                    tests.assertTrue(notificationService._jmsMessageListenerHandle == null);

                    // Test finished successfully.
                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                            d.callback(true);
                        }));
                    }));
            }));

        return d;
    }
    }, {
        name :"testExceptionsInCallbackBugAddTracker",
        timeout :10000,
        setUp : function() {
        },
        runTest : function testExceptionsInCallbackBugAddTracker() {
            // summary: An exception in the callback should not cause the
            // callback to be called twice. There
        // was previously a bug where that happened:
        // http://www.openanzo.org/projects/openanzo/ticket/243
        var d = new doh.Deferred();

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            var tracker = new anzo.client._StatementTracker(anzo.createURI("http://example.com/unknown"), anzo.createURI("http://example.com/unknown/2"), anzo.client.Vocabulary.ANY, anzo.createURI("http://example.com/unknown/3"));
            var callbackCallCount = 0;
            notificationService.registerTrackers(tracker, null, function _registerTrackerCallback(success, error) {
                callbackCallCount++;

                // We set a timeout to check how many times the callback was
                // called after throwing an exception inside it.
                    setTimeout(d.getTestErrorWrapper( function pollCallbackCallCount() {
                        tests.assertEqual(1, callbackCallCount); // The
                                                                    // callback
                                                                    // must have
                                                                    // only be
                                                                    // called
                                                                    // once!
                            notificationService.disconnect(d.getTestErrorWrapper( function onDisconnect(success, error) {
                                tests.assertTrue(success);
                                // Test finished successfully.
                                    anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                                        d.callback(true);
                                    }));
                                }));
                        }), 1000);

                    throw new Error("Purposeful exception to test the behavior of exceptions in callbacks.");
                });
        }));

        return d;
    }
    }, {
        name :"testExceptionsInCallbackBugRemoveTracker",
        timeout :10000,
        setUp : function() {
        },
        runTest : function testExceptionsInCallbackBugRemoveTracker() {
            // summary: An exception in the callback should not cause the
            // callback to be called twice. There
        // was previously a bug where that happened:
        // http://www.openanzo.org/projects/openanzo/ticket/243
        var d = new doh.Deferred();

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            var tracker = new anzo.client._StatementTracker(anzo.createURI("http://example.com/unknown"), anzo.createURI("http://example.com/unknown/2"), anzo.client.Vocabulary.ANY, anzo.createURI("http://example.com/unknown/3"));
            var callbackCallCount = 0;
            try {
                notificationService.unregisterTrackers(tracker, null, function _unregisterTrackerCallback(success, error) {
                    callbackCallCount++;

                    // We set a timeout to check how many times the callback was
                    // called after throwing an exception inside it.
                        setTimeout(d.getTestErrorWrapper( function pollCallbackCallCount() {
                            tests.assertEqual(1, callbackCallCount); // The
                                                                        // callback
                                                                        // must
                                                                        // have
                                                                        // only
                                                                        // be
                                                                        // called
                                                                        // once!
                                notificationService.disconnect(d.getTestErrorWrapper( function onDisconnect(success, error) {
                                    tests.assertTrue(success);
                                    // Test finished successfully.
                                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                                            d.callback(true);
                                        }));
                                    }));
                            }), 1000);

                        throw new Error("Purposeful exception to test the behavior of exceptions in callbacks.");
                    });
            } catch (e) {
                if (e.message != "Purposeful exception to test the behavior of exceptions in callbacks.") {
                    throw e;
                }
            }
        }));

        return d;
    }
    }, {
        name :"testExceptionsInCallbackBugConnect",
        timeout :10000,
        setUp : function() {
        },
        runTest : function testExceptionsInCallbackBugConnect() {
            // summary: An exception in the callback should not cause the
            // callback to be called twice. There
        // was previously a bug where that happened:
        // http://www.openanzo.org/projects/openanzo/ticket/243
        var d = new doh.Deferred();

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            var callbackCallCount = 0;
            notificationService.connect( function _connectCallback(success, error) {
                callbackCallCount++;

                // We set a timeout to check how many times the callback was
                // called after throwing an exception inside it.
                    setTimeout(d.getTestErrorWrapper( function pollCallbackCallCount() {
                        tests.assertEqual(1, callbackCallCount); // The
                                                                    // callback
                                                                    // must have
                                                                    // only be
                                                                    // called
                                                                    // once!
                            notificationService.disconnect(d.getTestErrorWrapper( function onDisconnect(success, error) {
                                tests.assertTrue(success);
                                // Test finished successfully.
                                    anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                                        d.callback(true);
                                    }));
                                }));
                        }), 1000);

                    throw new Error("Purposeful exception to test the behavior of exceptions in callbacks.");
                });
        }));

        return d;
    }
    }, {
        name :"testExceptionsInCallbackBugDisconnect",
        timeout :10000,
        setUp : function() {
        },
        runTest : function testExceptionsInCallbackBugDisconnect() {
            // summary: An exception in the callback should not cause the
            // callback to be called twice. There
        // was previously a bug where that happened:
        // http://www.openanzo.org/projects/openanzo/ticket/243
        var d = new doh.Deferred();

        anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper( function connected(status, message) {
            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);

            var notificationService = new anzo.client._JMSNotificationRegistrationService();
            var callbackCallCount = 0;
            try {
                notificationService.disconnect( function _disconnectCallback(success, error) {
                    callbackCallCount++;

                    // We set a timeout to check how many times the callback was
                    // called after throwing an exception inside it.
                        setTimeout(d.getTestErrorWrapper( function pollCallbackCallCount() {
                            tests.assertEqual(1, callbackCallCount); // The
                                                                        // callback
                                                                        // must
                                                                        // have
                                                                        // only
                                                                        // be
                                                                        // called
                                                                        // once!
                                // Test finished successfully.
                                anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper( function() {
                                    d.callback(true);
                                }));
                            }), 1000);

                        throw new Error("Purposeful exception to test the behavior of exceptions in callbacks.");
                    });
            } catch (e) {
                if (e.message != "Purposeful exception to test the behavior of exceptions in callbacks.") {
                    throw e;
                }
            }
        }));

        return d;
    }
    } ],

    function setUp() {
    },

    function tearDown() {
    });

})();
