/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Wraps code and is inspired by the Jiffy-web API:
 * http://code.google.com/p/jiffy-web/
 * which is Copyright 2008 Whitepages.com, Inc.
 * used under the Apache License 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Documentation contains information from http://billwscott.com/jiffyext/
 * licensed by Bill W Scott under the Creative Commons Attribution 3.0 United States License: 
 * http://creativecommons.org/licenses/by/3.0/us/
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.profiling._base");

(function(){

if (typeof Jiffy == "undefined") {
    // Define a stub API if the Jiffy-web API doesn't exist. This allows code to call performance methods
    // without errors even when jiffy.js isn't being loaded at all.
    dojo.mixin(anzo.profiling, {    
    	mark : function(referenceID) {},
    	measure : function(eventName, referenceID) {},
    	getMeasures: function(){ return {}; },
    	clearMeasures: function() {}
    });
} else {
    // Jiffy is loaded so defer the operations to Jiffy
    
    dojo.mixin(anzo.profiling, {
        
        // summary: Assigns a name to the current moment in time. The current time is obtained using a JavaScript Date object.
        // referenceID: String. Identifier to assign to the current time. 
    	mark : function(referenceID) {
    	    if (Jiffy.options.USE_JIFFY == undefined || !Jiffy.options.USE_JIFFY) { return; };
    	    Jiffy.mark(referenceID);
    	},

        // summary: Captures the elapsed time between now and previous measurement on a mark.
        // description: Records the elapsed time between now and the mark denoted by the given 'referenceID'.
        //    Note that a particular mark may be used multiple times to record measurements. Each time,
        //    the elapsed time calculated will be computed starting from the previous call to 'measure'.
        //    For example:
        //    | anzo.profiling.mark("MyMark");
        //    | // 100 millseconds pass ...
        //    | anzo.profiling.measure("FirstMeasurement", "MyMark"); // records about 100ms
        //    | // 100 millseconds pass ...
        //    | anzo.profiling.measure("SecondMeasurement", "MyMark"); // records about 100ms
        //    Note that the second measurement recorded 100ms of elapsed time rather than 200ms.
        // eventName: The name to give this elapsed time measurement.
        // referenceID: The name of the mark (preciously created with the 'mark' method) to use as
        //   the start time for this elapsed time measurement.
    	measure : function(eventName, referenceID) {
            Jiffy.measure(eventName, referenceID);
    	},

        // summary: Returns the recorded measurements.
        // description: The format of the measurements is as follows.
        //   et: Elapsed time for this measurement (in milliseconds).
        //   evt: The name of the event measured.
        //   name: The name of the mark associated with this event.
        //   For example:
        //   | var measures = [
        //   |   {et:2676, evt:"load",            name:"PageStart", rt:1213159816044},
        //   |   {et:7,    evt:"carouselcreated", name:"onLoad",    rt:1213159818722},
        //   |   {et:67,   evt:"finishedonLoad",  name:"onLoad",    rt:1213159818729}
        //   | ];
    	getMeasures : function(){ 
    	    return Jiffy.getMeasures(); 
    	},

        // summary: Clears all of the recorded measurements. This leaves 'marks' intact.
    	clearMeasures: function() {
    	    Jiffy.clearMeasures();
    	}
    });
}

})();
