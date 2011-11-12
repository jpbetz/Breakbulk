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

dojo.provide("anzo.tests.rdf.performance.js.ObjectMemPerformance");

dojo.require("anzo.tests.rdf.performance.PerformanceUtils");

dojo.require("anzo.rdf.QuadStore");

dojo.require("anzo.rdf.vocabulary.XMLSchema");

tests.register("anzo.tests.rdf.performance.js.ObjectMemPerformance", 
	[
		
		function test_Performance1() {
		    
		    // summary: Tests performance of storing statements as objects.
		    
		    var NUM_STMTS = 100000;
		    
		    var args= [];
		    for(var i = 1; i <= NUM_STMTS; i++) {
		        var stmt = {
		            s : 'http://subj'+i,
		            p : 'http://pred'+i,
		            o : 'This is a long paragraph containing information. '+i,
		            ot : 'literal',
//		            oL : 'english',
                    oD : 'ttp://www.w3.org/2001/XMLSchema#string',
		            c : 'http://graph'+i
		        }
		        
		        args.push(stmt);
		    }
            
            alert('added '+NUM_STMTS+' statements serialized as light weight objects');
		    // 70 megs
            
		}
		
	]
);

		
			