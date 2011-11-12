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

/*
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.JMSUpdateServiceTest");

dojo.require("anzo.client.Serialization");
dojo.require("anzo.client.TransactionQueue");
dojo.require("anzo.client.TransactionProxy");
dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.rdf.vocabulary.RDF");
dojo.require("anzo.rdf.vocabulary.DC");
dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.client.Precondition");
dojo.require("anzo.client.JMSUpdateService");
dojo.require("anzo.tests.messaging.JMSClientRecorder");
dojo.require("anzo.tests.properties");
dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.log");

(function(){
var log = anzo.log.getLogger("anzo.tests.client.JMSUpdateServiceTest");

tests.register("anzo.tests.client.JMSUpdateServiceTest", [
    {
        name: "testUpdateServer",
        timeout: 20000,
        setUp: function() {
        },
        runTest: function () {
            var d = new doh.Deferred();
        
            anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function connected(status, message) {
                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                anzo.tests.utilities.resetRaw(d.getTestErrorWrapper(function onResetComplete(suc) {
                    var rand = 500;
                    var sub = anzo.createURI("http://openanzo.org/namedGraphs/defaultNamedGraph/" + rand);
                    
                    var ng = anzo.utils.UriGenerator.getMetadataGraphUri(sub);
                    var pred1 = anzo.client.Vocabulary.hasMetadataGraphProperty;
                    var obj1 = ng;
                    var pred2 = anzo.rdf.vocabulary.RDF.type;
                    var obj2 = anzo.client.Vocabulary.namedGraphType;
                    
                    var person = anzo.createURI("http://xmlns.com/foaf/0.1/Person");
                    var foafname = anzo.createURI("http://xmlns.com/foaf/0.1/name");
        
                    var stmt1 = anzo.createStatement(sub,pred1,obj1,ng);
                    var stmt2 = anzo.createStatement(sub,pred2,obj2,ng);
                    var stmt3 = anzo.createStatement(sub,anzo.rdf.vocabulary.RDF.type,person, sub);
                    var stmt4 = anzo.createStatement(sub,foafname,'Ben', sub);
                    
                    var quadStore = new anzo.rdf.QuadStore();
                    var transactionQueue = new anzo.client.TransactionQueue();
                    var store = new anzo.client.TransactionProxy(quadStore, transactionQueue);
                    
                    transactionQueue.begin();
                    store.add(stmt1);
                    store.add(stmt2);
                    transactionQueue.commit();
                    transactionQueue.begin();
                    store.add(stmt3);
                    store.add(stmt4);
                    transactionQueue.commit();
                      
                    var transactions = transactionQueue.committedTransactions;
                    var updateService = new anzo.client.JMSUpdateService();
                    log.debug("calling update server!");
                    updateService.updateServer(transactions, false, false, d.getTestErrorWrapper(function updateComplete(message, success, error) {
                        tests.assertTrue(success);
                        // Make sure we got what we expected.
                        // Note, this includes an exception for a purposefully failing precondition.  		
                        var resultExpected = [{"transactionURI": "http://openanzo.org/namedGraphs//92a0af70-8f34-4ac0-8464-0d4354abe918", "namedGraphUpdates": "http://openanzo.org/namedGraphUUID/revisioned/9be67bb0-ab6c-4c92-b632-2e5583cc34d6=0,http://openanzo.org/namedGraphUUID/revisioned/c5979ece-c07c-4cdb-b8a7-3c4189835b17=1,http://openanzo.org/namedGraphUUID/revisioned/e3982786-c50a-48f7-9214-d620a4255685=1,"}, {"transactionURI": "http://openanzo.org/namedGraphs//6b300b20-8398-41d9-8e13-3c9b1e07ca5d", "namedGraphUpdates": "http://openanzo.org/namedGraphUUID/revisioned/9be67bb0-ab6c-4c92-b632-2e5583cc34d6=1,"}];
                        var ignoreProperties = [ "transactionURI", "namedGraphUpdates", "ErrorMessageArg", "statusMessage" ]; // ignore these properties when comparing the objects since these change over time and aren't relevant if they differ.  		    
                        //log.debug("testUpdateServer - message:\n\n" + dojo.toJson(message, false) + "\n\n");
                        //log.debug("testUpdateServer - expected:\n\n" + dojo.toJson(resultExpected, false) + "\n\n");
                        
                        tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(resultExpected, message, ignoreProperties));
                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function() { d.callback(true); }));
                    }));
                }));
            }));
        
            return d;
        }
    },

    {
        name: "testUpdateServerFailedPrecondition",
        timeout: 20000,
        setUp: function() {
        },
        runTest: function () {
            var d = new doh.Deferred();
        
            anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function connected(status, message) {
                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                anzo.tests.utilities.resetRaw(d.getTestErrorWrapper(function onResetComplete(suc) {
                    log.debug("Done with reset.");
                    var rand = 500;
                    var sub = anzo.createURI("http://openanzo.org/namedGraphs/defaultNamedGraph/" + rand);
                    
                    var ng = anzo.utils.UriGenerator.getMetadataGraphUri(sub);
                    var pred1 = anzo.client.Vocabulary.hasMetadataGraphProperty;
                    var obj1 = ng;
                    var pred2 = anzo.rdf.vocabulary.RDF.type;
                    var obj2 = anzo.client.Vocabulary.namedGraphType;
                    
                    var person = anzo.createURI("http://xmlns.com/foaf/0.1/Person");
                    var foafname = anzo.createURI("http://xmlns.com/foaf/0.1/name");
        
                    var stmt1 = anzo.createStatement(sub,pred1,obj1,ng);
                    var stmt2 = anzo.createStatement(sub,pred2,obj2,ng);
                    var stmt3 = anzo.createStatement(sub,anzo.rdf.vocabulary.RDF.type,person, sub);
                    var stmt4 = anzo.createStatement(sub,foafname,'Ben', sub);
                    
                    var quadStore = new anzo.rdf.QuadStore();
                    var transactionQueue = new anzo.client.TransactionQueue();
                    
                    // Because we now reset in every test run, this statement should not exist.
                    var askQueryString = 'ASK  { <' + sub + '> <' + anzo.rdf.vocabulary.RDF.type + '> <' + person + '>}';
                    var askResult = false;
                    var defaultGraphUris = [anzo.client.Vocabulary.allGraphsUri];
                    var namedGraphUris = [ng];
                    
                    var precondition = new anzo.client.Precondition(askQueryString, askResult, namedGraphUris, defaultGraphUris);
                    var failingPrecondition = new anzo.client.Precondition('ASK  { <' + sub + '> <' + anzo.rdf.vocabulary.DC.title + '> "My title"}', true, namedGraphUris, defaultGraphUris);
                    
                    var store = new anzo.client.TransactionProxy(quadStore, transactionQueue);
                    
                    transactionQueue.begin();
                    store.add(stmt1);
                    store.add(stmt2);
                    transactionQueue.commit();
                    transactionQueue.begin(precondition);
                    store.add(stmt3);
                    store.add(stmt4);
                    transactionQueue.commit();
                    transactionQueue.begin(failingPrecondition);
                    store.add(anzo.createStatement("http://example.com/someResource", "http://example.com/someResource/somePredicate",'A String Literal', sub));
                    transactionQueue.commit();
                    
                    var transactions = transactionQueue.committedTransactions;
                    
                    log.debug("About to update");
                    var updateService = new anzo.client.JMSUpdateService();
                    updateService.updateServer(transactions, false, false, d.getTestErrorWrapper(function updateComplete(message, success, error) {
                        log.debug("Done with update.");
                        tests.assertTrue(success);
                        // Make sure we got what we expected.
                        // Note, this includes an exception for a purposefully failing precondition.  		
                        var resultExpected = [{"transactionURI": "http://openanzo.org/namedGraphs//07a582b7-99fa-44a8-8b75-1cedb5f60c1a", "namedGraphUpdates": "http://openanzo.org/namedGraphUUID/revisioned/94c20127-6db5-4362-af23-f07f617eeb97=1,http://openanzo.org/namedGraphUUID/revisioned/34edb0c6-fbf6-4317-959d-7191c89e70bb=0,http://openanzo.org/namedGraphUUID/revisioned/a8df3e2a-9517-4fae-a7d1-f4f3516f4d01=1,"}, {"transactionURI": "http://openanzo.org/namedGraphs//9e8a5c66-a3c3-4a57-833b-942b1d93763f", "namedGraphUpdates": "http://openanzo.org/namedGraphUUID/revisioned/34edb0c6-fbf6-4317-959d-7191c89e70bb=1,"}, {"transactionURI": "http://openanzo.org/namedGraphs//8c295f28-9019-47f4-847d-d71510145e78", "AnzoException": [{"errorTags": "64", "errorCode": "265", "ErrorMessageArg": ["http://openanzo.org/namedGraphs//8c295f28-9019-47f4-847d-d71510145e78", "ASK { <http://openanzo.org/namedGraphs/defaultNamedGraph/500> <http://purl.org/dc/elements/1.1/title> \"My title\"}"]}]}];
                        var ignoreProperties = [ "transactionURI", "namedGraphUpdates", "ErrorMessageArg", "statusMessage" ]; // ignore these properties when comparing the objects since these change over time and aren't relevant if they differ.  		    
                        //log.debug("testUpdateServer - message:\n\n" + dojo.toJson(message, true) + "\n\n");
                        //log.debug("testUpdateServer - expected:\n\n" + dojo.toJson(resultExpected, true) + "\n\n");
                        
                        var compared = anzo.tests.utilities.deepCompareJSONObjects(resultExpected, message, ignoreProperties);
                        if (!compared) {
                            log.debug("Result different than expected. result:\n" + dojo.toJson(message, true) + "\nexpected:\n" + dojo.toJson(resultExpected, true));
                        }
                        tests.assertTrue(compared);
                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function() { d.callback(true); }));
                    }));
                }));
            }));
        
            return d;
        }
    },
    {
        name: "testUpdateServerTimeout",
        timeout: 20000,
        setUp: function() {
        },
        runTest: function () {
            // Sends a message with an extremely short timeout. The request should timeout immediately.
            var d = new doh.Deferred();

            anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function(status, message) {
                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                anzo.tests.utilities.resetRaw(d.getTestErrorWrapper(function onResetComplete(suc) {
                    tests.assertTrue(suc);
                    
                    var rand = 500;
                    var sub = anzo.createURI("http://openanzo.org/namedGraphs/defaultNamedGraph/" + rand);
                    var metadataGraph = anzo.utils.UriGenerator.getMetadataGraphUri(sub);
                    var hasMetadataGraph = anzo.client.Vocabulary.hasMetadataGraphProperty;
                    var rdfType = anzo.rdf.vocabulary.RDF.type;
                    var namedGraphType = anzo.client.Vocabulary.namedGraphType;
                    
                    var person = anzo.createURI("http://xmlns.com/foaf/0.1/Person");
                    var foafname = anzo.createURI("http://xmlns.com/foaf/0.1/name");
        
                    var stmt1 = anzo.createStatement(sub, hasMetadataGraph, metadataGraph, metadataGraph);
                    var stmt2 = anzo.createStatement(sub, rdfType, namedGraphType, metadataGraph);
                    var stmt3 = anzo.createStatement(sub, rdfType, person, sub);
                    var stmt4 = anzo.createStatement(sub, foafname, 'Ben', sub);
                    
                    var quadStore = new anzo.rdf.QuadStore();
                    var transactionQueue = new anzo.client.TransactionQueue();
                    
                    var store = new anzo.client.TransactionProxy(quadStore, transactionQueue);
                    
                    transactionQueue.begin();
                    store.add(stmt1);
                    store.add(stmt2);
                    transactionQueue.commit();
                    transactionQueue.begin();
                    store.add(stmt3);
                    store.add(stmt4);
                    transactionQueue.commit();
                    
                    var transactions = transactionQueue.committedTransactions;
                    
                    var updateService = new anzo.client.JMSUpdateService();
                    updateService.updateServer(transactions, false, false, d.getTestErrorWrapper(function(message, success, error) {
                        tests.assertFalse(success);
                        tests.assertTrue(error.status == anzo.messaging.RESPONSE_STATUS_TIMEOUT);
                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function() { d.callback(true); }));
                    }), 1); // set timeout of 1ms
               }));
            }));

            return d;
        }
    },
    {
        name: "testExceptionsInCallbackBug",
        timeout: 20000,
        setUp: function() {
        },
        runTest: function testExceptionsInCallbackBug() {
            // summary: An exception in the callback should not cause the callback to be called twice. There
            //   was previously a bug where that happened: http://www.openanzo.org/projects/openanzo/ticket/243

            // Sends a message with an extremely short timeout. The request should timeout immediately.
            var d = new doh.Deferred();

            anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function(status, message) {
                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                anzo.tests.utilities.resetRaw(d.getTestErrorWrapper(function onResetComplete(suc) {
                    tests.assertTrue(suc);

                    // Create some valid update data. We don't really care what it is. We just want a successful call.
                    var rand = 500;
                    var sub = anzo.createURI("http://openanzo.org/namedGraphs/defaultNamedGraph/" + rand);
                    var metadataGraph = anzo.utils.UriGenerator.getMetadataGraphUri(sub);
                    var hasMetadataGraph = anzo.client.Vocabulary.hasMetadataGraphProperty;
                    var rdfType = anzo.rdf.vocabulary.RDF.type;
                    var namedGraphType = anzo.client.Vocabulary.namedGraphType;
                    
                    var person = anzo.createURI("http://xmlns.com/foaf/0.1/Person");
                    var foafname = anzo.createURI("http://xmlns.com/foaf/0.1/name");
        
                    var stmt1 = anzo.createStatement(sub, hasMetadataGraph, metadataGraph, metadataGraph);
                    var stmt2 = anzo.createStatement(sub, rdfType, namedGraphType, metadataGraph);
                    var stmt3 = anzo.createStatement(sub, rdfType, person, sub);
                    var stmt4 = anzo.createStatement(sub, foafname, 'Ben', sub);
                    
                    var quadStore = new anzo.rdf.QuadStore();
                    var transactionQueue = new anzo.client.TransactionQueue();
                    
                    var store = new anzo.client.TransactionProxy(quadStore, transactionQueue);
                    
                    transactionQueue.begin();
                    store.add(stmt1);
                    store.add(stmt2);
                    transactionQueue.commit();
                    transactionQueue.begin();
                    store.add(stmt3);
                    store.add(stmt4);
                    transactionQueue.commit();
                    
                    var transactions = transactionQueue.committedTransactions;

                    var callbackCallCount = 0;
                    var updateService = new anzo.client.JMSUpdateService();
                    updateService.updateServer(transactions, false, false, function(message, success, error) {
                        callbackCallCount++;
                        tests.assertTrue(success);
                        
                        // We set a timeout to check how many times the callback was called after throwing an exception inside it.
                        setTimeout(d.getTestErrorWrapper(function pollCallbackCallCount() { 
                            tests.assertEqual(1, callbackCallCount); // The callback must have only be called once!
                            anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function(status) {
                                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                d.callback(true);
                            })); 
                        }), 1000);

                        throw new Error("Purposeful exception to test the behavior of exceptions in callbacks.");

                    });
                }));
            }));

            return d;
        }
    }
]);

})();
