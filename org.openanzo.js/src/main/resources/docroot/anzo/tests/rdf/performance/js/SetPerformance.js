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

dojo.provide("anzo.tests.rdf.performance.js.SetPerformance");

dojo.require("anzo.tests.rdf.performance.PerformanceUtils");

dojo.require("anzo.rdf.QuadStore");

dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.utils.Set");

tests.register("anzo.tests.rdf.performance.js.SetPerformance", 
	[
		
		function test_Performance1() {
		    
		    // summary: Tests memory usage of creating a bunch of sets.
		    
		    var NUM_STMTS = 600001;
		    
		    var args= [];
		    for(var i = 1; i <= NUM_STMTS; i++) {
		        var set = new anzo.utils.Set(); // < this takes for ever
		        // var set = new Object(); // < this is very quick
		        args.push(set);
		    }
            
            alert('added '+NUM_STMTS+' statements serialized as light weight objects');
		    
            
		}
		
	]
);

		
			