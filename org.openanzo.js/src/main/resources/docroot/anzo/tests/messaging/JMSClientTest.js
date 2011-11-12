/*******************************************************************************
* Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
* Created on:  Oct 10, 2007
*
* Contributors:
*     Cambridge Semantics Incorporated - initial API and implementation
*******************************************************************************/
dojo.provide("anzo.tests.messaging.JMSClientTest");

dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.tests.properties");
dojo.require("anzo.log");

/*
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

(function() {
var log = anzo.log.getLogger("anzo.tests.messaging.JMSClientTest");

function simpleConnectAndDisconnect(d, continuation) {
    // summary: Connects and then immediately disconnects the JMSClient. 
    //  Used so that we can run through many connect/disconnect cycles to sort of stress test the code.

    anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function connectCallback(status, message) {
        if (status == anzo.messaging.CONNECTION_STATUS_CONNECTED) {
            log.debug("Connected successfuly.");
        } else {
            var errorMsg = "Error connecting - msg: " + dojo.toJson(message, true);
            log.debug(errorMsg);
            throw new Error(errorMsg);
        }
        
        // Now disconnect
        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function disconnectCallback(status, message) {
            if (status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED) {
                log.debug("Disconnected succesfully.");
            } else {
                var errorMsg = "Error disconnecting - msg: " + dojo.toJson(message, true);
                log.debug(errorMsg);
                throw new Error(errorMsg);
            }
            
            if (continuation) {
                continuation();
            }
        }));
    }));
}
    
doh.register("anzo.tests.messaging.JMSClientTest", [
    {
        name: "testSimpleConnectAndDisconnect",
        timeout: 20000,
        setUp: function() {
        },
        runTest: function testConnectAndDisconnect() {
            var d = new doh.Deferred();
            simpleConnectAndDisconnect(d, d.getTestErrorWrapper(function testConnectAndDisconnectContinuation() { d.callback(true); }));
            return d;
        }
    },
    {
        name: "testJMSClientRecoversFromHttpError",
        timeout: 20000,
        setUp: function(){
        },
        runTest: function testJMSClientRecoversFromHttpError(){
            var d = new doh.Deferred();

            var configProperties = {
                location : "/path-that-does-not-exist", // purposefully invalid path so that we get a 404
                username : "default",
                password : "123"
            }
            
            anzo.messaging.JMSClient.connect(configProperties, d.getTestErrorWrapper(function connectCallback(status, response) {
                if (response.status == 404
                        && status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED
                        && response.error == true) {
                    log.debug("Connection failed as expected.");
                } else {
                    var errorMsg = "JMS Connection did not fail as expected - status: " + status + " msg:" + dojo.toJson(response, true);
                    log.debug(errorMsg);
                    throw new Error(errorMsg);
                }

                // Now try a regular connect/disconnect cycle which should succeed properly.
                simpleConnectAndDisconnect(d, d.getTestErrorWrapper(function testConnectAndDisconnectContinuation() { d.callback(true); }));
            }));
            
            return d;
        }
    },
    {
        name: "testJMSClientFailsGracefullyOnCometdInitFailure",
        timeout: 20000,
        setUp: function(){
        },
        runTest: function testJMSClientFailsGracefullyOnCometdInitFailure() {
            // summary: This test allows authentication to proceed but the cometd init method fails.
            // We achieve this by using the correct URL for the login URL but an incorrect url for the location.
            // The system should properly handle the error, stopping the cometd connection. And it should
            // be able to connect successfully when the correct URL is attempted.
            var d = new doh.Deferred();

            var configProperties = {}
            dojo.mixin(configProperties, anzo.tests.properties);
            configProperties.loginURL = configProperties.location + "anzo_authenticate"; // This should be a correct URL so that authentication passes
            configProperties.location = "/path-that-does-not-exist"; // purposefully invalid path so that we get a 404
            
            anzo.messaging.JMSClient.connect(configProperties, d.getTestErrorWrapper(function connectCallback(status, response) {
                
                // Setup an event handler that will check to see if cometd is still trying to connect.
                // It shouldn't be. Cometd should quit trying and let us reconnect manually ourselves.
                var handshakeTriedAgain = false;
                var metaEventHandle = dojo.subscribe("/cometd/meta", this, d.getTestErrorWrapper(function(eventInfo) {
                    dojo.unsubscribe(metaEventHandle);
                    metaEventHandle = null;
                    if (eventInfo.action = "handshake") {
                        handshakeTriedAgain = true;
                    }
                }));
                // We wait a while before checking if the handshake was tried again to make sure cometd has a chance to try
                // if it's going to at all.
                setTimeout(d.getTestErrorWrapper(function() {
                    if (handshakeTriedAgain) {
                        log.error("Cometd tried to re-connect even after the failure!");
                    }
                    tests.assertFalse(handshakeTriedAgain);
                    
                    // Now try a regular connect/disconnect cycle which should succeed properly.
                    simpleConnectAndDisconnect(d, d.getTestErrorWrapper(function testConnectAndDisconnectContinuation() { d.callback(true); }));
                }), 3000);
            }));
            
            return d;
        }
    },
    {
        name: "testJMSClientFailsGracefullyOnAuthenticationFailure",
        timeout: 20000,
        setUp: function(){
        },
        runTest: function testJMSClientFailsGracefullyOnAuthenticationFailure(){
            var d = new doh.Deferred();

            var configProperties = {}
            dojo.mixin(configProperties, anzo.tests.properties);
            configProperties.password = "wr0ng-passw0rd!";
            
            anzo.messaging.JMSClient.connect(configProperties, d.getTestErrorWrapper(function connectCallback(status, response) {
                if (response.status == 403 // Forbidden
                        && status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED
                        && response.error == true) {
                    log.debug("Connection failed as expected with an authentication failure.");
                } else {
                    var errorMsg = "JMS Connection did not fail as expected - status: " + status + " msg:" + dojo.toJson(response, true);
                    log.debug(errorMsg);
                    throw new Error(errorMsg);
                }

                // Now try a regular connect/disconnect cycle which should succeed properly.
                simpleConnectAndDisconnect(d, d.getTestErrorWrapper(function testConnectAndDisconnectContinuation() { d.callback(true); }));
            }));
            
            return d;
        }
    },
    {
        name: "testMultipleConnectAndDisconnectSequences",
        timeout: 60000,
        setUp: function() {
        },
        runTest: function testMultipleConnectAndDisconnectSequences() {
            // summary: Runs the simpleConnect and Disconnect sequence multiple times one after the other.
            //  This is a small sort of stress test.
            var d = new doh.Deferred();
            var continuation = d.getTestErrorWrapper(function finalContinuation() {
                log.debug("Final Connect/Disconnect Cycle Complete.");
                d.callback(true);
            });
            for (var i = 4; i > 0; i--) {
                var currentContinuation = continuation;
                continuation = d.getTestErrorWrapper((function(x, y) { return function testConnectAndDisconnectContinuation() {
                    log.debug("Connect/Disconnect Cycle #" + x + " Complete.");
                    simpleConnectAndDisconnect(d, y);
                };})(i, currentContinuation));
            }
            simpleConnectAndDisconnect(d, continuation);
            return d;
        }
    }

    // Tests of the subscribeToGraphUpdates and unsubscribeFromGraphUpdates
    // methods are done in anzo.tests.client.GraphUpdateNotificationTest.
]);

})();
