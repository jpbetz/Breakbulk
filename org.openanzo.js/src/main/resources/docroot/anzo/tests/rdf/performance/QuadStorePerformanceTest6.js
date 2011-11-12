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

dojo.provide("anzo.tests.rdf.performance.QuadStorePerformanceTest3");

dojo.require("anzo.tests.rdf.performance.PerformanceUtils");

dojo.require("anzo.rdf.QuadStore");

dojo.require("anzo.rdf.vocabulary.XMLSchema");

tests.register("anzo.tests.rdf.performance.QuadStorePerformanceTest6", 
	[
		
		function test_Performance1() {
		    
		    // summary: each statement has a unique set of nodes in the quad
		    
		    var NUM_STMTS = 10000;
		    var NUM_DIFFERENT_URIS = 10;
		    
		    console.debug("Testing performance of QuadStore using "+NUM_STMTS+" statements (quads).");
		    console.debug("   This test adds statements that have the same predicates, but don't share any of the subjects, objects or named graphs.");
		    
		    var store = new anzo.rdf.QuadStore();
		    
		    var args = [];
		    for(var i = 0; i < NUM_STMTS; i++) {
		    	var id = i % NUM_DIFFERENT_URIS;
		        store.add('http://subj'+id, 'http://pred' + id, 'http://obj'+id, 'http://graph'+i );
		    }

		    window.setTimeout(null,10);
		    
		    var middleNum = NUM_DIFFERENT_URIS/2;
		    var patternLow = anzo.createStatement('http://subj1', 'http://pred1', 'http://obj1', 'http://graph1');
		    var patternMiddle = anzo.createStatement('http://subj'+middleNum, 'http://pred1', 'http://obj'+middleNum, 'http://graph'+middleNum);
		    var patternHigh = anzo.createStatement('http://subj'+(NUM_DIFFERENT_URIS-1), 'http://pred1', 'http://obj'+(NUM_DIFFERENT_URIS-1), 'http://graph'+(NUM_DIFFERENT_URIS-1));
		    
            getFindPerformanceNumbers(store, patternLow, patternMiddle, patternHigh);
            getAddPerformanceNumbers(store);
            getRemovePerformanceNumbers(store);
		}
		
	]
);

		
			