/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * 
 * This is a unit test that really isn't a unit test, but provides a convenient way to 
 * run the request playback analysis.  One limitation of the Javascript-based playback
 * is that all requests must be made as the same user.  This is because a given browser
 * may only be connected as a single user at a time, and the cost of connecting and reconnecting
 * as different users per connection would be prohibitively expensive
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.analysis.AnalysisTest");

dojo.require("anzo.tests.analysis.Analysis");

(function() {
var log = anzo.log.getLogger("anzo.tests.analysis.AnalysisTest");

tests.register("anzo.tests.analysis.AnalysisTest", 
    [
    	
        {
            name: "test_RequestAnalysis",
            timeout: 1000000,
            setUp: function() {
            },
            runTest: function test_RequestAnalysis() {
            
                var d = new doh.Deferred();
            
                anzo.tests.analysis.playback("../../anzo/tests/analysis/combusRecorder.txt", 10, d.getTestErrorWrapper(function playbackComplete(success, message) {
                	tests.assertTrue(success);
                	d.callback(true);
                }));
                
                return d;
            }
        }
    ]
);

})();
