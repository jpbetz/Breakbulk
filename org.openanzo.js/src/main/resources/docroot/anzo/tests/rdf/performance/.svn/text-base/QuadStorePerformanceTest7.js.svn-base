/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
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

dojo.provide("anzo.tests.rdf.performance.QuadStorePerformanceTest7");

dojo.require("anzo.tests.rdf.performance.PerformanceUtils");

dojo.require("anzo.rdf.QuadStore");

dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.tests.utilities");

tests.register("anzo.tests.rdf.performance.QuadStorePerformanceTest7", 
	[
		
		function test_Performance1() {
		    
		    var NUM_STMTS         = 10000;
		    
		    var SUBJECT_PERCENT   = 10;
		    var PREDICATE_PERCENT = 20;
		    var OBJECT_PERCENT    = 40;
		    var GRAPH_PERCENT     = 30;
		    
		    // ------------------------------------------------
		    
		    var numS = NUM_STMTS * SUBJECT_PERCENT/100;  
		    var numP = NUM_STMTS * PREDICATE_PERCENT/100;  
		    var numO = NUM_STMTS * OBJECT_PERCENT/100;
		    var numC = NUM_STMTS * GRAPH_PERCENT/100;
		    
		    console.debug("Testing performance of QuadStore using "+NUM_STMTS+" statements (quads).");
		    console.debug("  This test creates and adds: "+numS+" statements, "+numP+" predicates, "+numO+" objects and "+numC+" graphs");
		    var store = new anzo.rdf.QuadStore();
		    
		    var patterns = anzo.tests.utilities.addStmts(store, NUM_STMTS, numS, numP, numO, numC);
		    console.debug("----------------------------------------------");
            console.debug("added: "+NUM_STMTS+" statements to the store");
		    window.setTimeout(null,10);
		    
		    var patternLow    = patterns[0];
		    var patternMiddle = patterns[1];
		    var patternHigh   = patterns[2];
		    
            getFindPerformanceNumbers(store, patternLow, patternMiddle, patternHigh);
            getAddPerformanceNumbers(store);
            getRemovePerformanceNumbers(store);
		}
		
	]
);

		
			