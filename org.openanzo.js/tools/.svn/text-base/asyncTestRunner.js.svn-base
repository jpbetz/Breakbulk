/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 * Created on:  Dec 10, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

// asyncTestRunner.js
// Use this to add setTimeout/setInterval support to the Rhino JavaScript engine.
// Pass the script you would like to run as an argument to asyncTestRunner.js.
// For example:
//  | java -jar ../src/util/shrinksafe/custom_rhino.jar asyncTestRunner.js myExampleScript.js

var window = this;

(function() {

    var timers = {
        _timers : [],
        executeTimers : function() {
            var len = this._timers.length;
            for (var i = 0 ; i < len; i++) {
                var timer = this._timers[i];
                if (timer) {
                    var now = Date.now();
                    var timeElapsed = now - timer.startTime;
                    if (timeElapsed >= timer.interval) {
                        var func = timer.fn;
                        // Fire the event
                        if (typeof func == "string" || func instanceof String) {
                            eval(func.toString());
                        } else if (func) {
                            func();
                        }
                        
                        if (timer.isRecurring) {
                            timer.startTime = now;
                        } else {
                            delete this._timers[i];
                        }
                    }
                }
            }  
        },
        add : function(func, time, isRecurring) {
            var timerHandle = this._timers.length;
            this._timers[timerHandle] = { startTime : Date.now(), interval : time, fn : func, isRecurring : isRecurring };
            return timerHandle;
        },
        remove : function(timerHandle) {
            delete this._timers[timerHandle];
        }        
    };
    
    function _setTimer(isRecurring, args) {
        // These exceptions, conversions, and error conditions simulate the behavior of Firefox. 
        if (!args || args.length < 1) {
            throw new Error("Function " + (isRecurring ? "setInterval" : "setTimeout") + " requires at least one parameter.");
        }
        var fn = args[0];
        var time = 0;
        // Convert function argument to a string to eval if it isn't already a function
        if (fn === undefined) {
            throw new Error("useless " + (isRecurring ? "setInterval" : "setTimeout") + " call (missing quotes around argument?)");
        }
        if (typeof fn != "function" && !(fn instanceof Function)) {
            fn = new String(fn);
        }
        // Convert time argument, if any, to an integer. Default to 0 if that fails.
        if (args.length > 1) {
            var num = (+args[1]);
            if (!isNaN(num) && isFinite(num)) {
                time = Math.floor(num);
            }
        }

        // Handle any extra arguments after the first two by passing them to the callback.
        var func = fn;
        if (args.length > 3 && typeof fn == "function" || fn instanceof Function) {
            func = function() { fn.apply(this, args.slice(2)); };
        }

        return timers.add(func, time, isRecurring);
    }

    window.setTimeout = function(fn, time) {
        return _setTimer(false, Array.prototype.slice.call(arguments));
    };

    window.setInterval = function(fn, time) {
        return _setTimer(true, Array.prototype.slice.call(arguments));
    };
    
    window.clearTimeout = function _clearTimeout(t) {
        timers.remove(t);
    };

    window.clearInterval = function(timerHandle) {
        timers.remove(timerHandle);
    };

    if (arguments.length > 0) {
        load(arguments[0]);

        // Pump events
        while(1) {
            timers.executeTimers();        

            // Loosen up this loop so that we don't monopolize the CPU.
            java.lang.Thread.currentThread().sleep(1);
        }
    } else {
        print("Missing filename to run.");
        quit(1);
    }

// We want the script being run by this simulator to have the same arguments as if it
// was run alone. So we shift the Rhino global argument array to remove the name of this
// simulator script from the arguments. The Rhino 'load' function will run the script
// with the modified global 'arguments' array.
}).apply(this, arguments.length > 0 ? [ arguments.shift() ] : arguments);
