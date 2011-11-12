/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.tests.profiling.ProfilingTest");

dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.log");

dojo.require("anzo.profiling");

(function() {
var log = anzo.log.getLogger("anzo.tests.profiling.ProfilingTest");

tests.register("anzo.tests.profiling.ProfilingTest", 
    [
        {
            name: "test_Measurements",
            timeout: 10000,
            setUp: function() {
            },
            runTest: function test_RequestAnalysis() {
            
                var d = new doh.Deferred();

                // Start with clear measurements in case other tests added some measurements for their own work.
                anzo.profiling.clearMeasures();

                // Set a mark and take two measurements related to that mark. Ensure that the measurements are recorded.                
                anzo.profiling.mark("FirstMark");
                setTimeout(d.getTestErrorWrapper(function() {
                    anzo.profiling.measure("FirstEvent", "FirstMark");
                    setTimeout(d.getTestErrorWrapper(function() {
                        anzo.profiling.measure("SecondEvent", "FirstMark");
                        
                        var measures = anzo.profiling.getMeasures();
                        tests.assertTrue(measures.length == 2);
                        var matches = dojo.filter(measures, function(item) { return item.evt == "FirstEvent"; });
                        log.debug("first match:" + dojo.toJson(matches));
                        tests.assertTrue(matches.length == 1);
                        tests.assertTrue(matches[0].evt == "FirstEvent");
                        tests.assertTrue(matches[0].et > 0);
                        tests.assertTrue(matches[0].name == "FirstMark");

                        matches = dojo.filter(measures, function(item) { return item.evt == "SecondEvent"; });
                        log.debug("second match:" + dojo.toJson(matches));
                        tests.assertTrue(matches.length == 1);
                        tests.assertTrue(matches[0].evt == "SecondEvent");
                        tests.assertTrue(matches[0].et >= 0);
                        tests.assertTrue(matches[0].name == "FirstMark");

                        // Now test clearing the measurements
                        anzo.profiling.clearMeasures();

                        var measures = anzo.profiling.getMeasures();
                        tests.assertTrue(measures.length == 0);

                      	d.callback(true);
                    }), 200);
                }), 200);

                return d;
            }
        }
    ]
);

})();
