/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.JMSExecutionServiceTest");

dojo.require("anzo.client.Serialization");
dojo.require("anzo.client.TransactionQueue");
dojo.require("anzo.client.TransactionProxy");
dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.rdf.vocabulary.RDF");
dojo.require("anzo.rdf.vocabulary.DC");
dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.client.JMSExecutionService");
dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.tests.messaging.JMSClientRecorder");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.log");
dojo.require("anzo.tests.client.TestData");

(function(){
var log = anzo.log.getLogger("anzo.tests.client.JMSExecutionServiceTest");

tests.register("anzo.tests.client.JMSExecutionServiceTest", [
    {
        name: "testExecuteService",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function () {
            var d = new doh.Deferred();
        
            anzo.messaging.JMSClient.connect(anzo.tests.properties.sysadmin, d.getTestErrorWrapper(function connected(status, message) {
                tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                anzo.tests.utilities.resetRaw(d.getTestErrorWrapper(function onResetComplete(suc) {
                    var executionService = new anzo.client.JMSExecutionService();
                    var TestData = new anzo.tests.client.TestData();
                    
                    var serviceUri = anzo.createURI("http://openanzo.org/semanticServices/echoService#echo");
                    
                    var stmts = new Array();
                    stmts.push(TestData.stmt1);
                    stmts.push(TestData.stmt2);
                    stmts.push(TestData.stmt3);
                    stmts.push(TestData.stmt4);
                    
                    executionService.executeService(serviceUri, stmts, d.getTestErrorWrapper(function executionComplete(stmts, success, error) {
                        tests.assertTrue(success);
                        
                        var quadStore = new anzo.rdf.QuadStore();
                        quadStore.add(stmts);
                        
                        tests.assertTrue(quadStore.contains(TestData.stmt1));
                        tests.assertTrue(quadStore.contains(TestData.stmt2));
                        tests.assertTrue(quadStore.contains(TestData.stmt3));
                        tests.assertTrue(quadStore.contains(TestData.stmt4));
                        
                        anzo.messaging.JMSClient.disconnect(d.getTestErrorWrapper(function(status) {
                            tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                            d.callback(true);
                        })); 
                    }));
                }));
            }));
        
            return d;
        }
    }
    
    
]);

})();
