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

/*
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.GraphTableTest");
dojo.require("anzo.client.GraphTable");
dojo.require("anzo.client.ClientGraph");
tests.register("anzo.tests.client.GraphTableTest", 
	[
		
		function test_GraphTable() {
		    
			var graphTable = new anzo.client.GraphTable();
			
			var dummyGraph = new anzo.rdf.NamedGraph('http://test/1');
			
			var ds = graphTable.getDataset();
			
			graphTable.put("http://test/1",dummyGraph); // ++1
			graphTable.get("http://test/1",dummyGraph); // ++1

			tests.assertTrue(ds.getNamedGraphUris()[0].toString() == 'http://test/1');
			
			tests.assertFalse(graphTable.release("http://test/1")); // --1
			tests.assertTrue(graphTable.release("http://test/1")); // --1

			tests.assertTrue(graphTable.get('http://foo') == null);
			tests.assertFalse(graphTable.release("http://foo"));


			tests.assertTrue(ds.getNamedGraphUris().length == 0);
			tests.assertTrue(graphTable.get('http://test/1') == null);
			
			var error = false;
			try {
			ds.addNamedGraph('http://foo');
			} catch(e) {
			    error = true;
			}
			tests.assertTrue(error);

		}
		
	]
);

	
			
			
			