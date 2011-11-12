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

dojo.provide("anzo.tests.client.TransactionQueueTest");
dojo.require("anzo.client.TransactionQueue");
dojo.require("anzo.rdf.Statement");

tests.register("anzo.tests.client.TransactionQueueTest", 
	[
		
		function test_EmptyTransactions() {
		    var queue = new anzo.client.TransactionQueue({
		    	transactionComplete : function() {}
		    });
		    queue.begin();
		      queue.begin();
		      queue.commit();
		    queue.commit();
		    tests.assertTrue(queue.currentTransaction == null);
			tests.assertTrue(queue.committedTransactions.length == 0);
		},
		
		function test_TreeWalk() {
		    var TestData = new anzo.tests.client.TestData();
               
			var queue = new anzo.client.TransactionQueue();
			
			// normally the preconditions would be an array but for testing we can 
			// pass in a string 
			queue.begin("1");
				tests.assertFalse(queue.currentTransaction == null);
				queue.begin("2");
				
			        queue.begin("3");
					queue.commit();
					
					queue.begin("4");
					   queue.currentTransaction.add(TestData.stmt1);
					queue.commit();
					
				queue.commit();
				queue.begin("5");
				queue.commit();
			queue.commit();
			tests.assertTrue(queue.currentTransaction == null);
			tests.assertTrue(queue.committedTransactions.length == 1);
			var labels = new Array();
			var walk = function(transaction) {
				if (transaction.preconditions) {
					labels.push(transaction.preconditions);
				}
			}
			queue.committedTransactions[0].walkTransactionTree(walk);
			tests.assertEqual(5,labels.length);
			for (var i=0;i<labels.length;i++) {
				tests.assertEqual("" + (1+i),labels[i]);
			}

		},
		
		function test_Filter() {
			
			var queue = new anzo.client.TransactionQueue();
		    
		    var graph1 = 'http://graph1';
			var graph2 = 'http://graph2';
			var graph3 = 'http://graph3';
		    
			var stmt1 = anzo.createStatement('http://subj1', 'http://pred1', 'http://obj1', graph1);
			var stmt2 = anzo.createStatement('http://subj1', 'http://pred2', 'http://obj2', graph2);
			var stmt3 = anzo.createStatement('http://subj1', 'http://pred3', 'http://obj3', graph3);
			var stmt4 = anzo.createStatement('http://subj1', 'http://pred3', 'http://obj4', graph3);
			var stmt5 = anzo.createStatement('http://subj1', 'http://pred3', 'http://obj5', graph3);
			var stmt6 = anzo.createStatement('http://subj1', 'http://pred3', 'http://obj6', graph3);
			
			var statements = new anzo.utils.Set();
			statements.add(stmt1);
			statements.add(stmt2);
			// don't add stmt3 because we want to test that Transaction filtering is working.
			
			queue.begin();
			
			tests.assertTrue(queue.inTransaction());
			
			queue.add(stmt1);
			queue.remove(stmt2);
			queue.add(stmt3);
			
				queue.begin();
					tests.assertTrue(queue.inTransaction());
					queue.add(stmt4);
					queue.begin();
						queue.add(stmt5);
					queue.commit();
					queue.add(stmt6);
				
					queue.filter(statements,'http://subj1',null,null,null);
				
				queue.commit();
				tests.assertTrue(queue.inTransaction());
			queue.commit();
			tests.assertFalse(queue.inTransaction());
			
			// check idempotency of filter
			queue.filter(statements,'http://subj1',null,null,null);
			
			tests.assertTrue(statements.contains(stmt1));
			tests.assertFalse(statements.contains(stmt2));
			tests.assertTrue(statements.contains(stmt3));
			
			tests.assertTrue(statements.contains(stmt4));
			tests.assertTrue(statements.contains(stmt5));
			tests.assertTrue(statements.contains(stmt6));
			
		}
	]
);

	
			
			
			