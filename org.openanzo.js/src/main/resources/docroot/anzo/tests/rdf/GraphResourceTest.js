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
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.tests.rdf.GraphResourceTest");

dojo.require("anzo.rdf.GraphResource");

dojo.require("anzo.rdf.NamedGraph");

tests.register("anzo.tests.rdf.GraphResourceTest", 
	[
		
		function test_SingleValued_GraphResource() {
		    
		    var graph = new anzo.rdf.NamedGraph('http://graph_1');
		    graph.add('http://rouben', "http://xmlns.com/foaf/0.1/firstName", "Rouben")
		    graph.add('http://rouben', "http://xmlns.com/foaf/0.1/knows", "http://sean")
		   
		    var bean = new anzo.rdf.GraphResource('http://rouben', graph);
		    tests.assertTrue(bean.getProperty("http://xmlns.com/foaf/0.1/firstName")[0].value == 'Rouben');
            
            // generate methods to access the first name property
            bean.createPropertyMethods("http://xmlns.com/foaf/0.1/firstName");
            
            // test method names
            tests.assertTrue(bean.getGetMethodName('http://xmlns.com/foaf/0.1/firstName') == 'getFirstName');
            tests.assertTrue(bean.getSetMethodName('http://xmlns.com/foaf/0.1/firstName') == 'setFirstName');

            // test methods are generated
            tests.assertTrue(dojo.isFunction(bean.getFirstName));
            tests.assertTrue(dojo.isFunction(bean.setFirstName));     
            
            tests.assertTrue(bean.getFirstName()[0].value == 'Rouben');
            bean.setFirstName('Ben');
            tests.assertTrue(bean.getFirstName()[0].value == 'Ben');
            bean.setFirstName(null);
            tests.assertTrue(bean.getFirstName()[0] == null);
            
            var eventCount = 0;
            var stub = bean.connect('http://xmlns.com/foaf/0.1/firstName', function() {
                eventCount++;
            });
            tests.assertTrue(eventCount == 0);
            
		    bean.setFirstName('Jon');
		    tests.assertTrue(eventCount == 1);
		    bean.setFirstName(null);
		    tests.assertTrue(eventCount == 2);
            
            eventCount = 0;
            bean.disconnect(stub); // this unhooks the registered listener
            bean.disconnectAll(); // this unhooks ALL registered listeners
           
            graph.clear();
            tests.assertTrue(eventCount == 0); 

		},
		
		function test_MultiValued_GraphResource() {
		    
		    var graph = new anzo.rdf.NamedGraph('http://graph_1');
		    graph.add('http://rouben', "http://xmlns.com/foaf/0.1/firstName", "Rouben")
		    graph.add('http://rouben', "http://xmlns.com/foaf/0.1/knows", "http://sean")
		   
		    var bean = new anzo.rdf.GraphResource('http://rouben', graph);
		    tests.assertTrue(bean.getProperty("http://xmlns.com/foaf/0.1/knows")[0].value == 'http://sean');
            
            
            // generate methods to access the knows property
            bean.createPropertyMethods("http://xmlns.com/foaf/0.1/knows");
            
            // test method names
            tests.assertTrue(bean.getGetMethodName('http://xmlns.com/foaf/0.1/knows') == 'getKnows');
            tests.assertTrue(bean.getAddMethodName('http://xmlns.com/foaf/0.1/knows') == 'addKnows');
            tests.assertTrue(bean.getRemoveMethodName('http://xmlns.com/foaf/0.1/knows') == 'removeKnows');
            
            // test methods are generated
            tests.assertTrue(dojo.isFunction(bean.getKnows));
            tests.assertTrue(dojo.isFunction(bean.addKnows));
            tests.assertTrue(dojo.isFunction(bean.removeKnows));
            tests.assertTrue(dojo.isFunction(bean.removeAllKnows));
            
            tests.assertTrue(bean.getKnows()[0].value == 'http://sean');
            bean.addKnows('http://ben');
            tests.assertTrue(bean.getKnows().length == 2);
            bean.removeKnows('http://sean');
            tests.assertTrue(bean.getKnows()[0].value == 'http://ben');
            bean.removeAllKnows();
            tests.assertTrue(bean.getKnows().length == 0);
            
		
		}
		
		
		
	]
);

	
			
			
			