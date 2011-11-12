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

// This file is a unit test for the asyncTestRunner.js file.
// To run the test, pass this file as the scipt for asyncTestrunner.js to run.
// Example:
// | java -jar ../src/util/shrinksafe/custom_rhino.jar asyncTestRunner.js asyncTestRunnerTest.js
// 
// One of the most important things that this test verifies is that the callbacks for timeouts
// intervals are invoked in the same thread as the main program runs. This is the single-threaded
// nature of JavaScript in browsers and it is important to simulate that correctly.

print("Testing asyncTestRunner...");

function assertTrue(condition) {
    // summary: Simple assert function inspired by Dojo's D.O.H..
    if (arguments.length != 1) { 
        throw new Error("assertTrue failed because it was not passed exactly 1 argument");
        quit(1); 
    } 
    if (!eval(condition)) {
        throw new Error("assertTrue('" + condition + "') failed");
        quit(1);
    }
}

var mainThreadId = java.lang.Thread.currentThread().getId();

var mainCodeComplete = false;
var timeoutCalledCount = 0;
var intervalCalledCount = 0;
var evalTimeoutCalledCount = 0;
var argsTimeoutCalledCount = 0;
var clearTimeoutCalledCount = 0;

setTimeout(function() { 
    timeoutCalledCount++;
    assertTrue("timeoutCalledCount === 1"); // Timeouts should only happen once.
    assertTrue("mainThreadId === java.lang.Thread.currentThread().getId()");
    assertTrue("mainCodeComplete");
}, 50);

// Test setTimeout with an eval string
setTimeout("evalTimeoutCalledCount++;" +
    "assertTrue('evalTimeoutCalledCount === 1'); assertTrue('mainThreadId === java.lang.Thread.currentThread().getId()');" +
    "assertTrue('mainCodeComplete');",
60);

// Test setTimeout with extra arguments to the function
setTimeout(function(a, b, c) { 
    argsTimeoutCalledCount++;
    assertTrue("argsTimeoutCalledCount === 1");
    assertTrue("mainThreadId === java.lang.Thread.currentThread().getId()");
    assertTrue("mainCodeComplete");
    assertTrue(a === "a" && b === "b" && c === "c");
}, 70, "a", "b", "c");


// Test clearTimeout
var timeoutHandler = setTimeout(function() { 
    clearTimeoutCalledCount++;
    assertTrue("clearTimeoutCalledCount === 0"); // Timeouts should only happen once.
    assertTrue("mainThreadId === java.lang.Thread.currentThread().getId()");
    assertTrue("mainCodeComplete");
}, 200);

clearTimeout(timeoutHandler);

var timeoutCounts = [];
var timeoutHandles = [];

// Test a recurring interval
var timerHandle = setInterval(function() {
    
    intervalCalledCount++;
    assertTrue("intervalCalledCount <= 10"); // Ensure it gets cleared when appropriate.
    assertTrue("mainThreadId === java.lang.Thread.currentThread().getId()");
    assertTrue("mainCodeComplete");

    if (intervalCalledCount >= 10) {
        clearInterval(timerHandle);
        
        // End the test after a little while. We want to just make sure that the interval was really cleared.
        setTimeout(function() {

            // Check that all the timeoutCounts were hit.
            for (var i = 0; i < timeoutCounts.length; i++) {
                assertTrue("timeoutCounts[" + i + "] >= 1");
            }
            
            print("asyncTestRunnerTest successful.");
            quit();
        }, 500);
    }
}, 20);

assertTrue(arguments.length == 0); // Running inside asyncTestRunner.js, arguments should look the same as when running this script alone.  

function testBorderConditions(isRecurring) {
    // Test a bunch of border conditions for arguments in either setTimeout and setInterval.
    var func = isRecurring ? setInterval : setTimeout;
    var exceptionThrown = null;

    exceptionThrown = null;
    try {
        func();
    } catch (e) {
        exceptionThrown = e;
    }
    assertTrue(exceptionThrown.message == ("Function " + (isRecurring ? "setInterval" : "setTimeout") + " requires at least one parameter."));

    exceptionThrown = null;
    try {
        func(undefined);
    } catch (e) {
        exceptionThrown = e;
    }
    assertTrue(exceptionThrown.message == ("useless " + (isRecurring ? "setInterval" : "setTimeout") + " call (missing quotes around argument?)"));

    function _generateEvalString(i, clear) {
        return "timeoutCounts[" + i + "] += 1; assertTrue(timeoutCounts[" + i + "] >= 1);" + (clear ? "clearInterval(timeoutHandles[" + i + "]);" : "");
    }
    // Test evaling a string
    var i = timeoutCounts.length;
    timeoutCounts[i] = 0;
    timeoutHandles[i] = func(_generateEvalString(i, isRecurring), 10);

    // Test evaling a string with a funky time argument that still converts to a number properly
    i = timeoutCounts.length;
    timeoutCounts[i] = 0;
    timeoutHandles[i] = func(_generateEvalString(i, isRecurring), [10]);

    // Test evaling a string inside an array
    i = timeoutCounts.length;
    timeoutCounts[i] = 0;
    timeoutHandles[i] = func(["timeoutCounts[" + i + "] += 1; assertTrue(timeoutCounts[" + i + "] >= 1);"], 10);

    // Test evaling a string without a time argument
    i = timeoutCounts.length;
    timeoutCounts[i] = 0;
    timeoutHandles[i] = func(_generateEvalString(i, isRecurring));

    // Test evaling a string with a funky time argument that doesn't convert to a number (so zero is used)
    i = timeoutCounts.length;
    timeoutCounts[i] = 0;
    timeoutHandles[i] = func(_generateEvalString(i, isRecurring), [10, 20]);
}

testBorderConditions(false);
testBorderConditions(true);

// Sleep this thread for a while to simulate doing a whole lot of time consuming work.
// We sleep long enough to have some of the timers we set above to fire. Still, the
// callbacks must not fire until this code yields control. That is the nature of
// single-threaded JavaScript.
java.lang.Thread.currentThread().sleep(100);

mainCodeComplete = true;
