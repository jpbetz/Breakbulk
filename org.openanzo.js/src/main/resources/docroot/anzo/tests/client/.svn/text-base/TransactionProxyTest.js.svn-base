/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.TransactionProxyTest");
dojo.require("anzo.client.TransactionProxy");
dojo.require("anzo.rdf.QuadStore");
dojo.require("anzo.client.TransactionQueue");

tests.register("anzo.tests.client.TransactionProxyTest", 
	[
		
		function test_TransactionProxy() {
		    
			var quadStore = new anzo.rdf.QuadStore();
			var transactionQueue = new anzo.client.TransactionQueue();
			transactionQueue.begin();
			var store = new anzo.client.TransactionProxy(quadStore, transactionQueue);
		    
		    anzo.tests.utilities.testQuadStore(store);
			
		},
		
		function testFind() {
		    
		    var quadStore = new anzo.rdf.QuadStore();
			var transactionQueue = new anzo.client.TransactionQueue();
		    var store = new anzo.client.TransactionProxy(quadStore, transactionQueue);
		    
		    anzo.tests.utilities.testFind(store);
           
		},
		
		function testAddRemove() {
		    
		    var quadStore = new anzo.rdf.QuadStore();
			var transactionQueue = new anzo.client.TransactionQueue();
		    var store = new anzo.client.TransactionProxy(quadStore, transactionQueue);
		    
		    anzo.tests.utilities.testAddRemove(store);
		    
		}
		
	]
);

	
			
			
			