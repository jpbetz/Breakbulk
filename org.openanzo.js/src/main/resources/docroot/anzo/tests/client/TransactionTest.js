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

dojo.provide("anzo.tests.client.TransactionTest");
dojo.require("anzo.client.Transaction");
dojo.require("anzo.rdf.Statement");

tests.register("anzo.tests.client.TransactionTest", 
	[
		
		function test_Transaction() {
		    
		    var t = new anzo.client.Transaction();
		    
		    var graph1 = 'http://graph1';
			var graph2 = 'http://graph2';
			var graph3 = 'http://graph3';
		    
			var stmt1 = anzo.createStatement('http://subj1', 'http://pred1', 'http://obj1', graph1);
			var stmt2 = anzo.createStatement('http://subj1', 'http://pred2', 'http://obj2', graph2);
			var stmt3 = anzo.createStatement('http://subj1', 'http://pred3', 'http://obj3', graph3);
			
			var statements = new anzo.utils.Set();
			statements.add(stmt1);
			statements.add(stmt2);
			// don't add stmt3 because we want to test that Transaction filtering is working.
			
			t.add(stmt1);
			t.remove(stmt2);
			t.add(stmt3);
			
			t.filter(statements,'http://subj1',null,null,null);
			
			tests.assertTrue(statements.contains(stmt1));
			tests.assertFalse(statements.contains(stmt2));
			tests.assertTrue(statements.contains(stmt3));

		}
	]
);

	
			
			
			