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

dojo.provide("anzo.tests.client.EmailService");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.log");



(function() {
	
var log = anzo.log.getLogger("anzo.tests.client.EmailService");

anzo.tests.client.Email = {
	
	serviceUri : anzo.createURI("http://openanzo.org/semanticServices/email"),
	
	sendOp : anzo.createURI("http://openanzo.org/semanticServices/email#send"),
	registerOp : anzo.createURI("http://openanzo.org/semanticServices/email#registerForUpdates"),
	recipientProperty : anzo.createURI("http://openanzo.org/semanticServices/email#recipient"),
    senderProperty : anzo.createURI("http://openanzo.org/semanticServices/email#sender"),
    subjectProperty : anzo.createURI("http://openanzo.org/semanticServices/email#subject"),
    bodyProperty : anzo.createURI("http://openanzo.org/semanticServices/email#body"),
    graphProperty : anzo.createURI("http://openanzo.org/semanticServices/email#graph"),
	
};

dojo.declare('anzo.tests.client.EmailService', null, {
	
	constructor : function(anzoClient) {
		
		this.anzoClient = anzoClient;
		
		
	},
	
	send : function(sender, recipient, subject, body, callback) {
		
		var voc = anzo.tests.client.Email;
		
		var stmts = new Array();
		stmts.push(anzo.createStatement(voc.sendOp,voc.senderProperty,anzo.createLiteral(sender),voc.sendOp));
		stmts.push(anzo.createStatement(voc.sendOp,voc.recipientProperty,anzo.createLiteral(recipient),voc.sendOp));
		stmts.push(anzo.createStatement(voc.sendOp,voc.subjectProperty,anzo.createLiteral(subject),voc.sendOp));
		stmts.push(anzo.createStatement(voc.sendOp,voc.bodyProperty,anzo.createLiteral(body),voc.sendOp));
		
		this.anzoClient.executeService(voc.sendOp, stmts, function executionComplete(stmts, success, error) {
            if (!success) {
            	log.debug("Error in services: " + dojo.toJson(error));
            	callback(false, error);
            } else {
            	callback(true, null);
            }
        });
	},
	
	registerForUpdates : function(recipient, graph, callback) {
		
		var voc = anzo.tests.client.Email;
		
		var stmts = new Array();
		stmts.push(anzo.createStatement(voc.registerOp,voc.recipientProperty,anzo.createLiteral(recipient),voc.registerOp));
		stmts.push(anzo.createStatement(voc.registerOp,voc.graphProperty,graph,voc.registerOp));
		
		this.anzoClient.executeService(voc.registerOp, stmts, function executionComplete(stmts, success, error) {
            if (!success) {
            	log.debug("Error in services: " + dojo.toJson(error));
            	callback(false, error);
            } else {
            	callback(true, null);
            }
        });
	}
	

});

tests.register("anzo.tests.client.EmailServiceTests", 
    [
    
      
        {
           name: "test_SendEmail",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
                var d = new doh.Deferred();
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties.sysadmin);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                    
                        var emailService = new anzo.tests.client.EmailService(anzoClient);
                        
                        var sender = "semtechdemo@cambridgesemantics.com";
                        var recipient = "ben@cambridgesemantics.com";
                        var subject = "Testing Semantic Email Service";
                        var body = "This is a test of Semantic Email Service, you should probably comment out the test so you don't keep getting these emails";
                        
                        emailService.send(sender, recipient, subject, body, d.getTestErrorWrapper(function(success, error) {
                            if (!success) {
                            	log.debug("Error sending email.." + dojo.toJson(error, true))
                            }
                            tests.assertTrue(success);
                            anzoClient.close(d.getTestErrorWrapper(function(status){
                                d.callback(true);
                            }));
                        }));
                                
    
                    }));
                }));
                
                return d;
            }
        },
        
        {
           name: "test_RegisterForUpdates",
           timeout: 10000,
           setUp: function() {
           },
           runTest: function () {
            
                var TestData = new anzo.tests.client.TestData();
                var d = new doh.Deferred();
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties.sysadmin);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                    
                        var emailService = new anzo.tests.client.EmailService(anzoClient);
                        
                        var recipient = "ben@cambridgesemantics.com";
                        var nguri = anzo.createURI("http://www.example.org/vocabulary#session10");
                        
                        emailService.registerForUpdates(recipient, nguri, d.getTestErrorWrapper(function(success, error) {
                            if (!success) {
                            	log.debug("Error registering for updates.." + dojo.toJson(error, true))
                            }
                            tests.assertTrue(success);
                            
                            anzoClient.begin();
                            anzoClient.getReplicaGraph(nguri, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                            	graph.add(TestData.stmt1);	
                            	anzoClient.commit();
                            	tests.assertTrue(graph.contains(TestData.stmt1));
                            
	                            var handle = dojo.connect(anzoClient,"updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
	                                tests.assertTrue(success);
	                                dojo.disconnect(handle);
	                                tests.assertTrue(graph.contains(TestData.stmt1));
	                                graph.close();
	                                
	                                anzoClient.close(d.getTestErrorWrapper(function(status){
	                                    d.callback(true);
	                                }));
	                            }));
	                            anzoClient.updateRepository();
                        	}));
                        }));
                    }));
                }));
                
                return d;
            }
        }
    
    ]
);



})();