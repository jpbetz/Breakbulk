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

dojo.provide("anzo.tests.client.JMSReplicationServiceTest");

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
dojo.require("anzo.client.JMSReplicationService");
dojo.require("anzo.tests.messaging.JMSClientRecorder");
dojo.require("anzo.tests.properties");
dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.log");

(function(){
var log = anzo.log.getLogger("anzo.tests.client.JMSReplicationServiceTest");

tests.register("anzo.tests.client.JMSReplicationServiceTest", [
    {
        name: "testReplicate",
        timeout: 10000,
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
                    
                    var updateService = new anzo.client.JMSUpdateService();
                    updateService.updateServer(transactions, false, false, d.getTestErrorWrapper(function updateComplete(message, success, error) {
                        tests.assertTrue(success);
                        
                        // Make sure we got what we expected.
                        // Note, this includes an exception for a purposefully failing precondition.  		
                        var resultExpected = [{"transactionURI": "http://openanzo.org/namedGraphs//07a582b7-99fa-44a8-8b75-1cedb5f60c1a", "namedGraphUpdates": "http://openanzo.org/namedGraphUUID/revisioned/94c20127-6db5-4362-af23-f07f617eeb97=1,http://openanzo.org/namedGraphUUID/revisioned/34edb0c6-fbf6-4317-959d-7191c89e70bb=0,http://openanzo.org/namedGraphUUID/revisioned/a8df3e2a-9517-4fae-a7d1-f4f3516f4d01=1,"}, {"transactionURI": "http://openanzo.org/namedGraphs//9e8a5c66-a3c3-4a57-833b-942b1d93763f", "namedGraphUpdates": "http://openanzo.org/namedGraphUUID/revisioned/34edb0c6-fbf6-4317-959d-7191c89e70bb=1,"}, {"transactionURI": "http://openanzo.org/namedGraphs//8c295f28-9019-47f4-847d-d71510145e78", "AnzoException": [{"errorTags": "64", "errorCode": "265", "ErrorMessageArg": ["http://openanzo.org/namedGraphs//8c295f28-9019-47f4-847d-d71510145e78", "ASK { <http://openanzo.org/namedGraphs/defaultNamedGraph/500> <http://purl.org/dc/elements/1.1/title> \"My title\"}"]}]}];
                        var ignoreProperties = [ "transactionURI", "namedGraphUpdates", "ErrorMessageArg", "statusMessage" ]; // ignore these properties when comparing the objects since these change over time and aren't relevant if they differ.  		    
                        //log.debug("testUpdateServer - message:\n\n" + dojo.toJson(message, true) + "\n\n");
                        //log.debug("testUpdateServer - expected:\n\n" + dojo.toJson(resultExpected, true) + "\n\n");
                        
                        tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(resultExpected, message, ignoreProperties));
                        
                        var replicationService = new anzo.client.JMSReplicationService();
                        var ngStmt = anzo.createStatement(sub, anzo.client.Vocabulary.revisionProperty, -1, ng);
                        var stmts = [ngStmt];
                        replicationService.replicate(stmts, d.getTestErrorWrapper(function replicateComplete(message, success, error) {
                        	log.debug("rep passed: " + success);
                        	var resultExpected = [{"namedGraphUri": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "namedGraphUUID": "http://openanzo.org/namedGraphUUID/revisioned/73907e0a-9459-4532-98a9-abc7d3decc9c", "revision": "1", "removals": [], "metaRemovals": [{"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#revision", "object": {"objectType": "literal", "value": "0", "dataType": "http://www.w3.org/2001/XMLSchema#long"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#modified", "object": {"objectType": "literal", "value": "1204784719437", "dataType": "http://www.w3.org/2001/XMLSchema#long"}}], "additions": [{"namedGraphUri": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://xmlns.com/foaf/0.1/name", "object": {"objectType": "literal", "value": "Ben", "dataType": "http://www.w3.org/2001/XMLSchema#string"}}, {"namedGraphUri": "http://openanzo.org/namedGraphs/defaultNamedGraph/500", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "object": {"objectType": "uri", "value": "http://xmlns.com/foaf/0.1/Person"}}], "metaAdditions": [{"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#modified", "object": {"objectType": "literal", "value": "1204784719453", "dataType": "http://www.w3.org/2001/XMLSchema#long"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#revision", "object": {"objectType": "literal", "value": "1", "dataType": "http://www.w3.org/2001/XMLSchema#long"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#lastModifiedByUser", "object": {"objectType": "uri", "value": "ldap://uid=default,ou=users,dc=openanzo,dc=org"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#canBeRemovedFromBy", "object": {"objectType": "uri", "value": "ldap://uid=default,ou=users,dc=openanzo,dc=org"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#canBeAddedToBy", "object": {"objectType": "uri", "value": "ldap://uid=default,ou=users,dc=openanzo,dc=org"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#canBeReadBy", "object": {"objectType": "uri", "value": "ldap://uid=default,ou=users,dc=openanzo,dc=org"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#canBeRemovedFromBy", "object": {"objectType": "uri", "value": "ldap://uid=default,ou=users,dc=openanzo,dc=org"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#canBeAddedToBy", "object": {"objectType": "uri", "value": "ldap://uid=default,ou=users,dc=openanzo,dc=org"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#canBeReadBy", "object": {"objectType": "uri", "value": "ldap://uid=default,ou=users,dc=openanzo,dc=org"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#persisted", "object": {"objectType": "literal", "value": "true", "dataType": "http://www.w3.org/2001/XMLSchema#boolean"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#revisioned", "object": {"objectType": "literal", "value": "true", "dataType": "http://www.w3.org/2001/XMLSchema#boolean"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#createdBy", "object": {"objectType": "uri", "value": "ldap://uid=default,ou=users,dc=openanzo,dc=org"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#uuid", "object": {"objectType": "uri", "value": "http://openanzo.org/namedGraphUUID/revisioned/73907e0a-9459-4532-98a9-abc7d3decc9c"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph", "object": {"objectType": "uri", "value": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs(http%3A%2F%2Fopenanzo.org%2FnamedGraphs%2FdefaultNamedGraph%2F500)", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/500"}, "predicate": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "object": {"objectType": "uri", "value": "http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"}}]}];
 							var ignoreProperties  = ["namedGraphUri", "namedGraphUUID", "value", "metaRemovals", "metaAdditions"];
 							//log.debug("testReplicationService - message:\n\n" + dojo.toJson(message, true) + "\n\n");
                        	//log.debug("testReplicationService - expected:\n\n" + dojo.toJson(resultExpected, true) + "\n\n");
                        	//tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(resultExpected, message, ignoreProperties));
                        	anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function() { d.callback(true); }));
                        }));
                        
                }));
                }));
            }));
        
            return d;
        }
    },
    {
        name: "testExceptionsInCallbackBug",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function testExceptionsInCallbackBug() {
            // summary: An exception in the callback should not cause the callback to be called twice. There
            //   was previously a bug where that happened: http://www.openanzo.org/projects/openanzo/ticket/243
            var d = new doh.Deferred();
        
            anzo.messaging.JMSClient.connect(anzo.tests.properties, d.getTestErrorWrapper(function connected(status, message) {
                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                anzo.tests.utilities.resetRaw(d.getTestErrorWrapper(function onResetComplete(suc) {
                    var sub = anzo.createURI("http://openanzo.org/namedGraphs/defaultNamedGraph/500");
                    var ng = anzo.utils.UriGenerator.getMetadataGraphUri(sub);
                    
                    var replicationService = new anzo.client.JMSReplicationService();
                    var ngStmt = anzo.createStatement(sub, anzo.client.Vocabulary.revisionProperty, -1, ng);
                    var stmts = [ngStmt];
                    var callbackCallCount = 0;
                    replicationService.replicate(stmts, function replicateComplete(message, success, error) {
                        callbackCallCount++;

                        // We set a timeout to check how many times the callback was called after throwing an exception inside it.
                        setTimeout(d.getTestErrorWrapper(function pollCallbackCallCount() { 
                            tests.assertEqual(1, callbackCallCount); // The callback must have only be called once!
                            anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function() { d.callback(true); }));
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
