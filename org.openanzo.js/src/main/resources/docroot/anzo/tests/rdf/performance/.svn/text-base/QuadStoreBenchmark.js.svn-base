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

dojo.provide("anzo.tests.rdf.performance.QuadStoreBenchmark");

dojo.require("anzo.tests.rdf.performance.PerformanceUtils");

dojo.require("anzo.rdf.QuadStore");

dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.tests.utilities");

tests.register("anzo.tests.rdf.performance.QuadStoreBenchmark", 
	[
		
		function test_Performance1() {
		    
		    var NUM_STMTS = 100000;
		    
		    console.debug("Testing performance of QuadStore using "+NUM_STMTS+" statements (quads).");
		    console.debug("   This tests the benchmark specified on the performance wiki.");
		    
		    
            var store = new anzo.rdf.QuadStore();
            
            var _temp1 = false;
            var _temp2 = false;
            var _temp3 = false;
            
            var createObj = function(sNum, pNum, oNum, cNum) {
                //console.debug('>  '+sNum);
                if(sNum == 2 && !_temp1) {
                    _temp1 = true;
                } else if(sNum == 2 && !_temp2) {
                    _temp2 = true;
                } else if(sNum == 2 && !_temp3) {
                    _temp3 = true;
                }
                
                if(_temp3)
                    return 'edkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdks'+Math.random(); 
                if(_temp2)
                     return 'edkdiekdiekdosodkdkdedkdiekdiekdosodkdkedkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdksedkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdksedkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdksedkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdksedkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdksedkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdksedkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdksedkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdksedkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdksdeurifkdks'+Math.random();
                if(_temp1)
                    return 'http://www.w3.org/1999/02/22-rdf-syntax-ns#Seq'+sNum+1;   
                return 'edkdiekdiekdosodkdkdedkdiekdiekdosodkdkdeurifkdks'+Math.random(); 
            }
            
            var patterns = anzo.tests.utilities.addStmts(store, NUM_STMTS, 1000, 1000, 90000, 100, 1, createObj);
            
            console.debug("----------------------------------------------");
            console.debug("added: "+NUM_STMTS+" statements to the store");
		    window.setTimeout(null,10);
		    
		    var patternLow    = patterns[0];
		    var patternMiddle = patterns[1];
		    var patternHigh   = patterns[2];
		  //  alert('about to do operations');
            getFindPerformanceNumbers(store, patternLow, patternMiddle, patternHigh);
            getAddPerformanceNumbers(store);
            getRemovePerformanceNumbers(store);
            
            // 321,000 total, so 280,000 ish, that's 2.8K/stmt
            // 1,000,000 +, so 10K/stmt +
            
		}
		
	]
);

		
			