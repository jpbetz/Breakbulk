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
 * 
 * Run this test in two browsers at once. The test should pass in both browsers
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.MultiBrowserTest");

dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.log");
dojo.require("anzo.rdf.Statement");

(function() {
var log = anzo.log.getLogger("anzo.tests.client.MultiBrowserTest");

tests.register("anzo.tests.client.MultiBrowserTest", 
    [
    	
        {
           name: "test_MultiBrowser",
           timeout: 60000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
                var d = new doh.Deferred();
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    var clientId = dojox.cometd.clientId;
	                var clientUri = anzo.createURI("http://openanzo.org/test/" + clientId);
	                var clientPredicate = anzo.createURI("http://openanzo.org/test/client");
	                var countLiteral = anzo.createLiteral(0);
	                var clientStmt = anzo.createStatement(clientUri,clientPredicate,countLiteral,TestData.graph1);
                    var done = false;
                    anzoClient.begin();
                    anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                        graph.add(clientStmt);	
                        anzoClient.commit();
                        tests.assertTrue(graph.contains(clientStmt));
                        
                        var count = 0;
                        var othercount = 0;
                        
                        dojo.connect(graph, 'statementsAdded', d.getTestErrorWrapper(function graphStatementAdded(stmts) {
                        	if (done) {
                        		return;
                        	}
                            log.debug("graph stmts:" + dojo.toJson(stmts, true));
                            if (stmts[0].predicate.equals(clientPredicate) && !stmts[0].subject.equals(clientUri)) {
                            	log.debug("Recevied stmt from other client")
                            	othercount++;
                            	var countLiteral2 = anzo.createLiteral(++count);
	                			var countStmt = anzo.createStatement(clientUri,clientPredicate,countLiteral2,TestData.graph1);
	                			anzoClient.begin();
	                			graph.add(countStmt);	
                        		anzoClient.commit();
                        		tests.assertTrue(graph.contains(countStmt));
                        		var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
		                            if (!success) {
		                            	log.debug(dojo.toJson(errors, true));
		                            }
		                            tests.assertTrue(success);
		                            dojo.disconnect(handle);
		                            tests.assertTrue(graph.contains(countStmt));
		                            tests.assertTrue(anzoClient.quadStore.contains(countStmt));
		                            if (othercount == 20){
		                            	var client = anzoClient;
		                            	done = true;
	                            		d.callback(true);
		                            } 
		                        }));
		                        anzoClient.updateRepository();
	                        }
                            log.debug("OtherCount: " + othercount);
                        }));
                        
                        var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                            if (!success) {
                            	log.debug(dojo.toJson(errors, true));
                            }
                            tests.assertTrue(success);
                            dojo.disconnect(handle);
                            tests.assertTrue(graph.contains(clientStmt));
                            tests.assertTrue(anzoClient.quadStore.contains(clientStmt));
                            
                            //anzoClient.close(d.getTestErrorWrapper(function(status){
                             //   d.callback(true);
                            //}));
                            
                        }));
                        anzoClient.updateRepository();

                    }));
                }));
                
                return d;
            }
        }
    ]
);

})();
