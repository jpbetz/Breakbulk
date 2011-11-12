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
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)  
 */

dojo.provide("anzo.tests.client.JMSResetServiceTest");

dojo.require("anzo.client.JMSResetService");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");

tests.register("anzo.tests.client.JMSResetServiceTest", 
    [
        {
            name: "test_JMSResetService",
            timeout: 5000,
            setUp: function() {
            },
            runTest: function () {

                var d = new doh.Deferred();
                anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                
                    // get statements used to reset the database
                    var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/initialize.json");
                    var json = dojo.fromJson(str);
                    var statements =  anzo.client.Serialization.readStatementsFromJson(json);
                    
                    var resetService = new anzo.client.JMSResetService();
                    resetService.reset(statements, d.getTestErrorWrapper(function(success, errors) {
                        tests.assertTrue(success);
                        tests.assertTrue(errors == null);
                        
                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function() { d.callback(true); }));
                    }));
                }));
                
                return d;
            }
        },
        {
            name: "testExceptionsInCallbackBug",
            timeout: 5000,
            setUp: function() {
            },
            runTest: function testExceptionsInCallbackBug() {
                // summary: An exception in the callback should not cause the callback to be called twice. There
                //   was previously a bug where that happened: http://www.openanzo.org/projects/openanzo/ticket/243

                var d = new doh.Deferred();
                anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                
                    // get statements used to reset the database
                    var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/initialize.json");
                    var json = dojo.fromJson(str);
                    var statements =  anzo.client.Serialization.readStatementsFromJson(json);
                    
                    var callbackCallCount = 0;
                    var updateService = new anzo.client.JMSUpdateService();
                    var resetService = new anzo.client.JMSResetService();
                    resetService.reset(statements, function(success, errors) {
                        callbackCallCount++;
                        tests.assertTrue(success);
                        tests.assertTrue(errors == null);
                        
                        // We set a timeout to check how many times the callback was called after throwing an exception inside it.
                        setTimeout(d.getTestErrorWrapper(function pollCallbackCallCount() { 
                            tests.assertEqual(1, callbackCallCount); // The callback must have only be called once!
                            anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function() { d.callback(true); }));
                        }), 1000);

                        throw new Error("Purposeful exception to test the behavior of exceptions in callbacks.");
                    });
                }));
                
                return d;
            }
        }

    ]
);

