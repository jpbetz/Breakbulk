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

dojo.provide("anzo.tests.rdf.performance.js.ArrayMemPerformance");

dojo.require("anzo.tests.rdf.performance.PerformanceUtils");

dojo.require("anzo.rdf.QuadStore");

dojo.require("anzo.rdf.vocabulary.XMLSchema");

tests.register("anzo.tests.rdf.performance.js.ArrayMemPerformance", 
	[
		
		function test_Performance1() {
		    
		    // summary: Tests performance of storing statements as arrays.
		    
		    var NUM_STMTS = 100000;
		    
		    console.debug("Testing memory usage of creating "+NUM_STMTS*4+" distinct anzo.rdf.URI objects.");
		    
		    
		    var args= [];
		    for(var i = 1; i <= NUM_STMTS; i++) {
		        var stmt = [
		            'http://subj'+i,
		            'http://pred'+i,
		            'This is a long paragraph containing information. '+i,
		            'literal',
		            null,
		            'http://www.w3.org/2001/XMLSchema#string',
		            'http://graph'+i
		        ]
		        args.push(stmt);
		    }

		     alert('added '+NUM_STMTS+' statements serialized as light weight arrays');
		   // 70 megs
		}
		
	]
);

		
			