/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*
 * @author Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 */

dojo.provide("anzo.tests.dohExtensions");

dojo.require("anzo.log.log4javascript.MDC");
dojo.require("anzo.messaging.JMSClient");

// Extend doh.Deferred with some useful methods
// for typical usage in Anzo ansynchronous tests.
doh.extend(doh.Deferred, {
    getTestErrorWrapper : function(cb, scope) {
        // summary: Wraps a callback in a try-catch block so that any exceptions, including
        // assertion failures, cause an error to be thrown on this Deferred object. This
        // is similar to the doh.Deferred.getTestCallback method except that callback(true)
        // isn't called by the wrapper. That allows this wrapper to be used for callbacks
        // within callbacks.
        var _this = this;
        return function(){
            try {
                cb.apply(scope||dojo.global||_this, arguments);
            } catch(e) {
                _this.errback(e);
            }
        }
    }
});

// Override some functionality in D.O.H. for with the OpenAnzo framework.
// In particular, add various output to the browser and rhino, especially for selenium
// tests to extract data about the test runs.
(function(){
    
    var OPID_PREFIX = "opIdPrefix";
    function setTestNameInMDC(testName) {
        anzo.log.log4javascript.MDC.put(OPID_PREFIX, testName);
    }

    function clearTestNameInMDC() {
        anzo.log.log4javascript.MDC.remove(OPID_PREFIX);
    }

    // Override the _testStarted DOH method to add the name to the MDC so that it
    // gets added to the operation ids sent to the server. Also, reset the JMSClient
    // in case the previous test had a problem and left the JMSClient without disconnecting. 
    var oldTestStarted = doh._testStarted;
    doh._testStarted = function(group, fixture){
        setTestNameInMDC(fixture.name.toString());
        anzo.messaging.JMSClient.reset();
        oldTestStarted.apply(doh, arguments);
    }
    
    // Override the init method to time the tests. The _report method will output the total time elapsed.
    var testStartTime = null;
    var oldDohInit = doh._init;
    doh._init = function() {
        oldDohInit.apply(doh, arguments);
        testStartTime = new Date();
    }

    function printElapsedTestTime() {
        var end = new Date();
        var elapsed = end.getTime() - testStartTime.getTime();
        var minutes = Math.floor(elapsed/(1000*60));
        var seconds = Math.floor((elapsed - minutes*1000*60)/1000);
        var milli = elapsed - minutes*1000*60 - seconds*1000;
        doh.debug("Time to run tests: " + minutes + "m" + seconds + "s" + milli + "ms\n");
    }
        
    if (dojo.isRhino) {
        // Override the Rhino version of the D.O.H. testFinished method so that it outputs test names as they pass or fail.
        // The browser D.O.H. does this but the Rhino one doesn't.
        var oldRhinoTestFinishedMethod = doh._testFinished;
        doh._testFinished = function(group, fixture, success){
            oldRhinoTestFinishedMethod.apply(doh, arguments);
            clearTestNameInMDC();
            doh.debug(((success) ? "PASSED" : "FAILED"), "test:", fixture.name);
        }

        // Override the doh._report method to make it quit explicitly in case of success or failure since
        // we may be inside a setTimeout message pump from the asyncTestRunner. 
        var oldReport = doh._report;
        doh._report = function(){
            oldReport.apply(doh, arguments);
            printElapsedTestTime();
            if(this._failureCount > 0 || this._errorCount > 0){
                quit(1);
            } else {
                quit(0); // Quit explicitly here since we may be inside the setTimeout event pump.
            }
        }
    }

    // Override some of the reporting D.O.H. methods when in the browser to provide a realiable
    // place to output information Selenium to extract. This avoids parsing text to extract success or failure and
    // so This helps reliably automate the D.O.H. tests with Selenium. 
    if (dojo.isBrowser) {
        var oldReportMethod = doh._report;
        doh._report = function(){
            // summary: add hidden divs containing test success and failure counts for use by
            //   the Selenium Java unit test runner to extract information.
            oldReportMethod.apply(doh, arguments);
            printElapsedTestTime();
            
            var reportDiv = document.createElement("div");
            reportDiv.id = "test-completion-report";
            reportDiv.style.display = "none";
            var errorsDiv = document.createElement("div");
            var failuresDiv = document.createElement("div");
            errorsDiv.id="test-completion-report-errors";
            failuresDiv.id="test-completion-report-failures";
            errorsDiv.appendChild(document.createTextNode(this._errorCount.toString()))
            failuresDiv.appendChild(document.createTextNode(this._failureCount.toString()))
            reportDiv.appendChild(errorsDiv);
            reportDiv.appendChild(failuresDiv);
            document.body.appendChild(reportDiv);
        }
        
        var oldBrowserTestFinishedMethod = doh._testFinished;
        doh._testFinished = function(group, fixture, success){
            // summary: add a hidden element containing all of the failed tests for use by
            //   the Selenium Java unit test runner to extract information.
            oldBrowserTestFinishedMethod.apply(doh, arguments);
            clearTestNameInMDC();

            var id = "test-failed-tests-report";
            if (!success) {
                var wrapperDiv = document.getElementById(id);
                if (!wrapperDiv) {
                    wrapperDiv = document.createElement("pre");
                    wrapperDiv.id = id;
                    wrapperDiv.style.display = "none";
                    document.body.appendChild(wrapperDiv);
                }
                wrapperDiv.innerHTML += group.toString() + " : " + fixture.name.toString() + "\n";
            }
        }
        
    }
})();
