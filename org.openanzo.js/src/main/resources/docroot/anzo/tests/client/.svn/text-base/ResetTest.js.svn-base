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

dojo.provide("anzo.tests.client.ResetTest");

dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.log");

(function() {
var log = anzo.log.getLogger("anzo.tests.client.ResetTest");

tests.register("anzo.tests.client.ResetTest", 
    [
    	
        {
            name: "test_Reset",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_Reset() {
            
                var d = new doh.Deferred();
            
                var TestData = new anzo.tests.client.TestData();
               
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties);
                
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    anzo.tests.utilities.reset(anzoClient, d.getTestErrorWrapper(function onResetComplete(suc) {
                        tests.assertTrue(suc);
                        d.callback(true);
                    }));
                }));
                
                return d;
            }
        }
    ]
);

})();
