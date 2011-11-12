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

dojo.provide("anzo.tests.client.ShapesServices");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.log");



(function() {
	
var log = anzo.log.getLogger("anzo.tests.client.ShapesServices");

anzo.tests.client.Shapes = {
	
	serviceUri : anzo.createURI("http://openanzo.org/semanticServices/shapes"),
	triangleOp : anzo.createURI("http://openanzo.org/semanticServices/shapes#computeTriangleArea"),
	squareOp : anzo.createURI("http://openanzo.org/semanticServices/shapes#computeSquareArea"),
	circleOp : anzo.createURI("http://openanzo.org/semanticServices/shapes#computeCircleArea"),
	shapePredicate : anzo.createURI("http://openanzo.org/semanticServices/shapes#shape"),
	basePredicate : anzo.createURI("http://openanzo.org/semanticServices/shapes#base"),
	heightPredicate : anzo.createURI("http://openanzo.org/semanticServices/shapes#height"),
	sidePredicate : anzo.createURI("http://openanzo.org/semanticServices/shapes#side"),
	radiusPredicate : anzo.createURI("http://openanzo.org/semanticServices/shapes#radius")
	
};

anzo.tests.client.GraphUpdate = {
	
	serviceUri : anzo.createURI("http://openanzo.org/semanticServices/longRunningService"),
	startUpdatingOp : anzo.createURI("http://openanzo.org/semanticServices/longRunningService#startUpdating"),
	stopUpdatingOp : anzo.createURI("http://openanzo.org/semanticServices/longRunningService#stopUpdating"),
	updateNamedGraphPredicate : anzo.createURI("http://openanzo.org/semanticServices/longRunningService#updateNamedGraph"),
    updatePeriodPredicate : anzo.createURI("http://openanzo.org/semanticServices/longRunningService#updatePeriod"),
    updatePredicatePredicate : anzo.createURI("http://openanzo.org/semanticServices/longRunningService#updatePredicate"),
    updateResourcePredicate : anzo.createURI("http://openanzo.org/semanticServices/longRunningService#updateResource"),
    updateRangePredicate : anzo.createURI("http://openanzo.org/semanticServices/longRunningService#updateRange"),
    updateKeyPredicate : anzo.createURI("http://openanzo.org/semanticServices/longRunningService#updateKey")
	
};

dojo.declare('anzo.tests.client.ShapesServices', null, {
	
	constructor : function(anzoClient) {
		
		this.anzoClient = anzoClient;
		
		
	},
	
	computeTriangleArea : function(shapeUri, callback) {
		this.callOperation(anzo.tests.client.Shapes.triangleOp, shapeUri, callback);
	},
	
	computeSquareArea : function(shapeUri, callback) {
		this.callOperation(anzo.tests.client.Shapes.squareOp, shapeUri, callback);
	},
	
	computeCircleArea : function(shapeUri, callback) {
		this.callOperation(anzo.tests.client.Shapes.circleOp, shapeUri, callback);
	},
	
	callOperation : function(opUri, shapeUri, callback) {
		
        var stmts = new Array();
        stmts.push(anzo.createStatement(opUri,anzo.tests.client.Shapes.shapePredicate,shapeUri,opUri));
        
        this.anzoClient.executeService(opUri, stmts, function executionComplete(stmts, success, error) {
            if (!success) {
            	log.debug("Error in services: " + dojo.toJson(error));
            	callback(null, false, error);
            } else {
            	callback(stmts[0].object.value, true, null);
            }
            
        });
	},
	
	startUpdating : function(updateNamedGraph, updateResource, updatePredicate, updateRange, updatePeriod, callback) {
		log.debug("ng before: " + dojo.toJson(updateNamedGraph, true));
		updateNamedGraph = anzo.rdf.getValue(updateNamedGraph);
		log.debug("ng after: " + dojo.toJson(updateNamedGraph, true));
		updateResource = anzo.rdf.getValue(updateResource);
		updatePredicate = anzo.rdf.getValue(updatePredicate);
		var stmts = new Array();
		var voc = anzo.tests.client.GraphUpdate;
		stmts.push(anzo.createStatement(voc.startUpdatingOp,voc.updateNamedGraphPredicate,updateNamedGraph,voc.startUpdatingOp));
		stmts.push(anzo.createStatement(voc.startUpdatingOp,voc.updateResourcePredicate,updateResource,voc.startUpdatingOp));
		stmts.push(anzo.createStatement(voc.startUpdatingOp,voc.updatePredicatePredicate,updatePredicate,voc.startUpdatingOp));
		stmts.push(anzo.createStatement(voc.startUpdatingOp,voc.updateRangePredicate,anzo.createLiteral(updateRange),voc.startUpdatingOp));
		stmts.push(anzo.createStatement(voc.startUpdatingOp,voc.updatePeriodPredicate,anzo.createLiteral(updatePeriod),voc.startUpdatingOp));
		this.anzoClient.executeService(voc.startUpdatingOp, stmts, function executionComplete(stmts, success, error) {
            if (!success) {
            	log.debug("Error in services: " + dojo.toJson(error));
            	callback(null, false, error);
            } else {
            	callback(stmts[0].object.value, true, null);
            }
        });
	},
	
	stopUpdating : function(updateKey, callback) {
		var stmts = new Array();
		var voc = anzo.tests.client.GraphUpdate;
		stmts.push(anzo.createStatement(voc.stopUpdatingOp,voc.updateKeyPredicate,anzo.createLiteral(updateKey),voc.stopUpdatingOp));
		this.anzoClient.executeService(voc.stopUpdatingOp, stmts, function executionComplete(stmts, success, error) {
            if (!success) {
            	log.debug("Error in services: " + dojo.toJson(error));
            	callback(false, error);
            } else {
            	callback(true, null);
            }
        });
	}
	
	
	

});

tests.register("anzo.tests.client.ShapesServicesTests", 
    [
    
    	/*
    	{
           name: "test_ComputeTriangleArea",
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
                    
                    	// create a graph with a shape it in, that the servie we call we use to compute
                    	// the area.
                    
	                    anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                        	
                        	
                        	graph.add(anzo.createStatement(TestData.graph1, anzo.tests.client.Shapes.basePredicate, anzo.createLiteral(4), TestData.graph1));
                        	graph.add(anzo.createStatement(TestData.graph1, anzo.tests.client.Shapes.heightPredicate, anzo.createLiteral(6), TestData.graph1));
                        	
                        	anzoClient.commit();
                        	
                        	
                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success && errors.length == 0);
                                dojo.disconnect(handle);
                                
                                var shapesServices = new anzo.tests.client.ShapesServices(anzoClient);
                                
                                
                                shapesServices.computeTriangleArea(TestData.graph1,d.getTestErrorWrapper(function(result, success, error) {
                                    tests.assertTrue(success);
                                    tests.assertEqual(12,result);
                                   
                                    anzoClient.close(d.getTestErrorWrapper(function(status){
                                        d.callback(true);
                                    }));
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
           name: "test_ComputeCircleArea",
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
                    
                    	// create a graph with a shape it in, that the servie we call we use to compute
                    	// the area.
                    
	                    anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                        	
                        	graph.add(anzo.createStatement(TestData.graph1, anzo.tests.client.Shapes.radiusPredicate, anzo.createLiteral(4), TestData.graph1));
                        	anzoClient.commit();
                        	
                        	
                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success && errors.length == 0);
                                dojo.disconnect(handle);
                                
                                var shapesServices = new anzo.tests.client.ShapesServices(anzoClient);
                                
                                shapesServices.computeCircleArea(TestData.graph1,d.getTestErrorWrapper(function(result, success, error) {
                                    tests.assertTrue(success);
                                    tests.assertEqual(4 * 4 * Math.PI,result);
                                   
                                    anzoClient.close(d.getTestErrorWrapper(function(status){
                                        d.callback(true);
                                    }));
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
           name: "test_ComputeSquareArea",
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
                    
                    	// create a graph with a shape it in, that the servie we call we use to compute
                    	// the area.
                    
	                    anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                        	
                        	
                        	graph.add(anzo.createStatement(TestData.graph1, anzo.tests.client.Shapes.sidePredicate, anzo.createLiteral(4), TestData.graph1));
                        	
                        	anzoClient.commit();
                        	
                        	
                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success && errors.length == 0);
                                dojo.disconnect(handle);
                                
                                var shapesServices = new anzo.tests.client.ShapesServices(anzoClient);
                                
                                
                                shapesServices.computeSquareArea(TestData.graph1,d.getTestErrorWrapper(function(result, success, error) {
                                    tests.assertTrue(success);
                                    tests.assertEqual(16,result);
                                   
                                    anzoClient.close(d.getTestErrorWrapper(function(status){
                                        d.callback(true);
                                    }));
                                }));
                                
	                    	}));
	                    	anzoClient.updateRepository();
                        }));
                        
    
                    }));
                }));
                
                return d;
            }
        },
        
        */ 
        {
           name: "test_GraphUpdater",
           timeout: 10000000000000000,
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
                    
                    	// create a graph with a shape it in, that the servie we call we use to compute
                    	// the area.
                    
	                    anzoClient.begin();
                        anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                        	
                        	graph.add(anzo.createStatement(TestData.graph1, anzo.tests.client.Shapes.sidePredicate, anzo.createLiteral(4), TestData.graph1));
                        	
                        	anzoClient.commit();
                        	
                        	
                            var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                                tests.assertTrue(success && errors.length == 0);
                                dojo.disconnect(handle);
                                
                                var stmts = new Array();
                                var key = null;
                                var eventHandle = dojo.connect(graph,"statementsAdded", d.getTestErrorWrapper(function(statements){
                                    for (var i=0;i<statements.length;i++) {
                                        stmts.push(statements[i]);
                                    }
                                    log.debug("Event received: " + stmts.length);
                                    if (stmts.length == 10) {
                                    	log.debug("Stopping UPDATING....");
                                    	shapesServices.stopUpdating(key, d.getTestErrorWrapper(function(success, error) {
		                                    if (!success) {
		                                    	log.debug("Error stopping updating.." + dojo.toJson(error, true))
		                                    }
			                                tests.assertTrue(success);
			                                anzoClient.close(d.getTestErrorWrapper(function(status){
		                                        d.callback(true);
		                                    }));
		                                }));
                                    }
                                }));
                                
                                var shapesServices = new anzo.tests.client.ShapesServices(anzoClient);
                                
                                shapesServices.startUpdating(TestData.graph1.toString(), TestData.stmt1.subject.toString(), TestData.stmt1.predicate.toString(), 1000, 1000, d.getTestErrorWrapper(function(result, success, error) {
                                    if (!success) {
                                    	log.debug("Error starting updating.." + dojo.toJson(error, true))
                                    }
                                    key = result;
                                    tests.assertTrue(success);
                                }));
                                
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