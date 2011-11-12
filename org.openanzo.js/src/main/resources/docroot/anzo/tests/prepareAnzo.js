/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * Use the file as the testUrl to the D.O.H (Dojo unit testing JavaScript unit test harness).
 * It will prepare the Dojo module paths such that the dojo.require() calls will find Anzo
 * code and tests. It will also enhance the D.O.H. framework with some useful functionality.
 * 
 * For example, if running the tests on the command line, from the openanzo-js/src/util/doh directory, do:
 * $ java -jar ../shrinksafe/custom_rhino.jar runner.js testUrl=../../anzo/tests/prepareAnzo.js testModule=anzo.tests.module 
 * 
 * Or if you want to use the graphical browser-based D.O.H. runner, then create a runTests.html file that looks something
 * like this:
 * <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
 * <html>
 *     <head>
 *       <title>Anzo.JS Unit Test Runner</title>
 *       <meta http-equiv="REFRESH" content="0;url=../util/doh/runner.html?testModule=anzo.tests.module&testUrl=../../anzo/tests/prepareAnzo">
 *     </head>
 *     <body>
 *         Redirecting to D.O.H runner.
 *     </body>
 * </html>
 * 
 */

// dojo.registerModulePath("anzo", "../../../anzo");

// Load profiling code for use in unit tests
var JiffyOptions = {
    SEND_MEASURES : false,
    BROWSER_EVENTS : {}
}
dojo.require("anzo.profiling.jiffy"); // load the Jiffy code, this typically is done via a script tag but we'll do it like this for the unit test

dojo.require("anzo.log");

(function(){
if (window && window.location && window.location.href.match(/mode=regression/)) {
    //console.debug("Running tests in regression mode. Default logging levels set to ALL.");
    //anzo.log.defaultLogLevel = 0; // Set the default log level to ALL when running in regression mode.
}
})();

dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.dohExtensions");

(function(){
// Load logging configuration from the default file
var logConfig = anzo.tests.utilities.loadTextFile("../../anzo/tests/anzolog.properties");
anzo.log.applyConfig(logConfig);
})();
