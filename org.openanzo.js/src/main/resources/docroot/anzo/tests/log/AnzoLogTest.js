/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.log.AnzoLogTest");

dojo.require("anzo.log");
dojo.require("anzo.log.log4javascript");
dojo.require("anzo.log.log4javascript.MDC");

(function() {

function ArrayAppender(array, layout) {
    // summary: This log4javascript appender will output logs into the given array. Each element will contain
    //   a formatted message. This is useful for testing that logging is working properly by programatically
    //   inspecting log output in the array.
    if (layout) {
        this.setLayout(layout);
    }
    this.array = array;
};
ArrayAppender.prototype = new anzo.log.log4javascript.Appender();
ArrayAppender.prototype.layout = new anzo.log.log4javascript.SimpleLayout();
ArrayAppender.prototype.append = function(loggingEvent) {
    var formattedMessage = this.getLayout().format(loggingEvent);
    if (this.getLayout().ignoresThrowable()) {
        formattedMessage += loggingEvent.getThrowableStrRep();
    }
    this.array.push(formattedMessage);
};
ArrayAppender.prototype.toString = function() {
    return "[ArrayAppender]";
};

function getArrayLoggerFactoryMethod(array) {
    // summary: Perpare a log factory method which will create loggers that write to the given array
    //   via an ArrayAppender.
    var _testArrayAppender = new ArrayAppender(array, new anzo.log.log4javascript.PatternLayout("%-5p %c - %m%n"));
    return function(loggerName) {
        var logger = anzo.log.log4javascript.getLogger(loggerName);
        logger.removeAllAppenders(); // Reset the appenders so that we start with a clean slate here in case other tests have messed with the appenders.
        logger.addAppender(_testArrayAppender);
        logger.setLevel(anzo.log.log4javascript.Level.TRACE);
        return logger;
    }
}

// Setup a mini object heirarchy for testing the instrumentation of constructors with interesting prototype inheritance
function MyBaseObject() { this.baseObjectProperty = 123; };
function MySubObject(a, b) { this.subObjectProperty = 456; };
MySubObject.prototype = new MyBaseObject();

function getTestNamespaceObj() {
    // summary: Create an object which represents a typical JavaScript namespace object for use in tests below.
    //   The object includes some members to test some border conditions.
    return {
        bar : {
            f1 : function(x, y) { return x + y; },
            f2 : function(x) { return x + this.constant; },
            constant : 10
        },
        f3 : function() { return 3; },
        f4 : function() { }, // a method that doesn't return anything
        aString : "foo",
        aNumber : 1.3,
        aBoolean : true,
        aRegExp : /.*/, // RegExps in particular are important to test since they have typeof == "function"
        aNullProperty : null,
        anUndefinedProperty : undefined,
        aArray : [
            function() { return "This Should Not Be Instrumented!"; },
            { aprop : function() { return "This Should Also Not Be Instrumented!"; } },
            3
        ],
        aConstructor : MySubObject
    }
};

function assertLogMessageArray(anzoTestObject, logMessages) {
    // summary: Asserts that the given array contains the text expected when the given instrumented
    //   object's methods are invoked. The given object is expected to be created by the 'getTestNamespaceObj' function.

    anzoTestObject.bar.f1(5, 1);
    anzoTestObject.bar.f2(2);
    anzoTestObject.f3();
    anzoTestObject.f4();
    anzoTestObject.aArray[0]();
    anzoTestObject.aArray[1].aprop();

    //console.debug("logMessages:" + dojo.toJson(logMessages, true));

    tests.assertTrue(logMessages.length == 8);
    tests.assertTrue(logMessages[0] == "TRACE anzoLogTestNamespace.bar - ENTER anzoLogTestNamespace.bar.f1(5, 1)\r\n");
    tests.assertTrue(logMessages[1] == "TRACE anzoLogTestNamespace.bar - EXIT anzoLogTestNamespace.bar.f1 returned 6\r\n");
    tests.assertTrue(logMessages[2] == "TRACE anzoLogTestNamespace.bar - ENTER anzoLogTestNamespace.bar.f2(2)\r\n");
    tests.assertTrue(logMessages[3] == "TRACE anzoLogTestNamespace.bar - EXIT anzoLogTestNamespace.bar.f2 returned 12\r\n");
    tests.assertTrue(logMessages[4] == "TRACE anzoLogTestNamespace - ENTER anzoLogTestNamespace.f3()\r\n");
    tests.assertTrue(logMessages[5] == "TRACE anzoLogTestNamespace - EXIT anzoLogTestNamespace.f3 returned 3\r\n");
    tests.assertTrue(logMessages[6] == "TRACE anzoLogTestNamespace - ENTER anzoLogTestNamespace.f4()\r\n");
    tests.assertTrue(logMessages[7] == "TRACE anzoLogTestNamespace - EXIT anzoLogTestNamespace.f4 returned undefined\r\n");
}

tests.register("anzo.tests.log.AnzoLogTest",
    [
        function test_getLoggerShouldReuseAlreadyDefinedLoggers() {
            // summary: check that the logging system will reuse already defined loggers rather
            //  than creating a new logger each time for the same logger name.
            var loggerName = "My Logger";
            var logger = anzo.log.getLogger(loggerName);
            logger.anArbitraryProperty = 10;
            var logger2 = anzo.log.getLogger(loggerName);
            tests.assertTrue(logger === logger2);
            tests.assertTrue(logger.anArbitraryProperty == 10);
        },

        function test_getLoggerShouldCreateNewLoggersForNewLoggerNames() {
            // summary: check that the logging system will create different loggers if you
            //   supply a different logger name.
            var logger = anzo.log.getLogger("A Logger");
            var logger2 = anzo.log.getLogger("A Different Logger");
            tests.assertTrue(logger !== logger2);
        },

        function test_getLoggerListensToDefaultLogLevel() {
            // summary: check that the logging system respects the default log level.

            var loggers = anzo.log.log4javascript.evalInScope("loggers"); // grab the private loggers map from log4javascript. We'll be nice. We won't mess with it, we'll just take a quick look at it.

            var originalDefaultLogLevel = anzo.log.defaultLogLevel;
            try {
                anzo.log.defaultLogLevel = 5; // ERROR
                anzo.log.getLogger("An ERROR Logger by default");
                tests.assertTrue(loggers["An ERROR Logger by default"].getLevel().equals(anzo.log.log4javascript.Level.ERROR));

                anzo.log.defaultLogLevel = 1; // TRACE
                anzo.log.getLogger("A TRACE Logger by default");
                tests.assertTrue(loggers["A TRACE Logger by default"].getLevel().equals(anzo.log.log4javascript.Level.TRACE));

            } finally {
                anzo.log.defaultLogLevel = originalDefaultLogLevel; // Make sure we restore the log level in case it's being used by the test framework
            }
        },

        function test_addMethodTracingRecursesWhenAsked() {
            // summary: Test that the tracing instrumentation recurses by default and when true is passed for 'deep'.
            //   We use the _InstrumentedForTracing property for checking if the method was instrumented.
            anzoLogTestNamespace = getTestNamespaceObj(); // global on purpose to simulate a namespace
            anzo.log.addMethodTracing("anzoLogTestNamespace");
            // make sure the instrumentation worked
            tests.assertTrue(anzoLogTestNamespace.bar.f1._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.bar.f2._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.f3._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.f4._InstrumentedForTracing);

            anzoLogTestNamespace = getTestNamespaceObj(); // global on purpose to simulate a namespace
            anzo.log.addMethodTracing("anzoLogTestNamespace", true);
            // make sure the instrumentation worked
            tests.assertTrue(anzoLogTestNamespace.bar.f1._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.bar.f2._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.f3._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.f4._InstrumentedForTracing);
        },

        function test_addMethodTracingDoesNotRecurseWhenDeepIsFalse() {
            // summary: Test that the tracing ignores properties that aren't methods.
            anzoLogTestNamespace = getTestNamespaceObj(); // global on purpose to simulate a namespace
            anzo.log.addMethodTracing("anzoLogTestNamespace", false);
            // make sure the instrumentation worked
            tests.assertTrue(anzoLogTestNamespace.bar.f1._InstrumentedForTracing === undefined);
            tests.assertTrue(anzoLogTestNamespace.bar.f2._InstrumentedForTracing === undefined);
            tests.assertTrue(anzoLogTestNamespace.f3._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.f4._InstrumentedForTracing);
        },

        function test_addMethodTracingDoesNotChangeAnythingOtherThanFunctions() {
            // summary: The addMethodTracing method should only instrument functions and not any other kind of object.
            //  It should also NOT recurse into Arrays.
            anzoLogTestNamespace = getTestNamespaceObj(); // global on purpose to simulate a namespace
            anzo.log.addMethodTracing("anzoLogTestNamespace");
            tests.assertTrue(anzoLogTestNamespace.bar.f1._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.bar.f2._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.bar.constant === 10);
            tests.assertTrue(anzoLogTestNamespace.f3._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.f4._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.aString === "foo");
            tests.assertTrue(anzoLogTestNamespace.aNumber === 1.3);
            tests.assertTrue(anzoLogTestNamespace.aBoolean === true);
            tests.assertTrue(anzoLogTestNamespace.aRegExp instanceof RegExp);
            tests.assertTrue(anzoLogTestNamespace.aRegExp._InstrumentedForTracing === undefined);
            tests.assertTrue(anzoLogTestNamespace.aNullProperty === null);
            tests.assertTrue(anzoLogTestNamespace.anUndefinedProperty === undefined);
            tests.assertTrue(anzoLogTestNamespace.aArray[0]._InstrumentedForTracing === undefined);
            tests.assertTrue(anzoLogTestNamespace.aArray[1].aprop._InstrumentedForTracing === undefined);
            tests.assertTrue(anzoLogTestNamespace.aArray[2] === 3);
        },

        function test_addMethodTracingAddsEntryExitTracing() {
            // summary: Check that the proper logging occurs when instrumented. We use the custom-made
            //   ArrayAppender to write the logs to an array and then assert the contents of that array.
            anzoLogTestNamespace = getTestNamespaceObj(); // global on purpose to simulate a namespace
            var logMessages = [];
            anzo.log.addMethodTracing("anzoLogTestNamespace", true, undefined, getArrayLoggerFactoryMethod(logMessages));

            // Now check that entry/exit logging worked correctly
            assertLogMessageArray(anzoLogTestNamespace, logMessages);
        },

        function test_addMethodTracingIsIdempotent() {
            // summary: Test that the instrumentation is smart enough not to double-instrument things.
            anzoLogTestNamespace = getTestNamespaceObj(); // global on purpose to simulate a namespace
            var logMessages = [];
            var arrayLoggerFactory = getArrayLoggerFactoryMethod(logMessages);
            // Instrument things multiple times
            anzo.log.addMethodTracing("anzoLogTestNamespace", true, undefined, arrayLoggerFactory);
            anzo.log.addMethodTracing("anzoLogTestNamespace.bar", true, undefined, arrayLoggerFactory);
            anzo.log.addMethodTracing("anzoLogTestNamespace", true, undefined, arrayLoggerFactory);

            // Now check that entry/exit logging worked correctly
            // It must have not logged any extra messages which would happen if some methods
            // were double instrumented.
            assertLogMessageArray(anzoLogTestNamespace, logMessages);
        },

        function test_addMethodTracingPreservesArgumentsAndThis() {
            // summary: Check that the instrumenting a method will not change the definition of 'this' within the original
            //   method and will pass all of the arguments through.
            anzoLogTestNamespace = getTestNamespaceObj(); // global on purpose to simulate a namespace
            anzo.log.addMethodTracing("anzoLogTestNamespace");
            // make sure the instrumentation worked
            tests.assertTrue(anzoLogTestNamespace.bar.f1._InstrumentedForTracing);
            tests.assertTrue(anzoLogTestNamespace.bar.f2._InstrumentedForTracing);
            tests.assertEqual(3, anzoLogTestNamespace.bar.f1(1, 2));
            tests.assertEqual(15, anzoLogTestNamespace.bar.f2(5));
        },

        function test_addMethodTracingPreservesFunctionObjectProperties() {
            // summary: When instrumenting functions, the properties of the function object must be maintained.
            //   This is especially important for constructors which have important values in their 'prototype' property.
            anzoLogTestNamespace = getTestNamespaceObj(); // global on purpose to simulate a namespace
            anzo.log.addMethodTracing("anzoLogTestNamespace");

            // Invoke the instrumented constructor
            var obj = new anzoLogTestNamespace.aConstructor();
            tests.assertTrue(obj instanceof MyBaseObject)
            tests.assertTrue(obj instanceof MySubObject)
            tests.assertTrue(anzoLogTestNamespace.aConstructor._InstrumentedForTracing == true);
            tests.assertTrue(anzoLogTestNamespace.aConstructor.prototype._InstrumentedForTracing === undefined);
        },

        function test_addMethodTracingStopsRecursingForObjectsAtThreshold() {
            // summary: To avoid infinite recursion, the function stops after a predefined threshold of recursion.
            //   There are two places where the function recurses, on functions and on objects. This tests the object recursion.

            // global on purpose to simulate a namespace
            anzoLogTestNamespace = {
                prop0 : {
                    prop1: {
                        prop2: {
                            prop3: "much too deep"
                        }
                    }
                }
            };

            // Set the recursion threshold very low temporarily
            var oldThreshold = anzo.log._INSTRUMENTATION_RECURSION_THRESHOLD;
            anzo.log._INSTRUMENTATION_RECURSION_THRESHOLD = 2;
            var exceptionRaised = false;
            try {
                anzo.log.addMethodTracing("anzoLogTestNamespace");
            } catch(e) {
                if (e.message == "addMethodTracing - recursion too deep. There may be a cycle in the namespace being instrumented. Parts of the namespace may have been instrumented. Error while instrumenting namespace:\nanzoLogTestNamespace.prop0.prop1.prop2") {
                    exceptionRaised = true;
                }
            } finally {
                // Try not to affect other tests in case of failure
                anzo.log._INSTRUMENTATION_RECURSION_THRESHOLD = oldThreshold;
            }

            tests.assertTrue(exceptionRaised);
        },

        function test_addMethodTracingStopsRecursingForMethodsAtThreshold() {
            // summary: To avoid infinite recursion, the function stops after a predefined threshold of recursion.
            //   There are two places where the function recurses, on functions and on objects. This tests the function recursion.

            // global on purpose to simulate a namespace
            anzoLogTestNamespace = {
                noInstrumentMethod : function() { return "DON'T instrument me"; },
                anotherNoInstrumentMethod : function() { return "DON'T instrument me"; },
                instrumentMethod : function() { return "DO instrument me"; },
                skipRecursing : {
                    skipped : function() { return "DON'T instrument me"; }
                },
                anotherSkipRecursing : {
                    skipped : function() { return "DON'T instrument me"; }
                },
                doRecurse : {
                    instrumented : function() { return "DO instrument me"; }
                }
            };

            anzo.log.addMethodTracing("anzoLogTestNamespace", true, [
                "noInstrumentMethod",
                "anzoLogTestNamespace.skipRecursing",
                "anotherSkipRecursing",
                "anotherNoInstrumentMethod"
            ]);

            tests.assertTrue(anzoLogTestNamespace.noInstrumentMethod._InstrumentedForTracing === undefined);
            tests.assertTrue(anzoLogTestNamespace.anotherNoInstrumentMethod._InstrumentedForTracing === undefined);
            tests.assertTrue(anzoLogTestNamespace.instrumentMethod._InstrumentedForTracing === true);
            tests.assertTrue(anzoLogTestNamespace.skipRecursing.skipped._InstrumentedForTracing === undefined);
            tests.assertTrue(anzoLogTestNamespace.anotherSkipRecursing.skipped._InstrumentedForTracing === undefined);
            tests.assertTrue(anzoLogTestNamespace.doRecurse.instrumented._InstrumentedForTracing === true);
        },

        function test_addMethodTracingIgnoresSkippedProperties() {
            // summary: The 'skip' argument of the method prevents instrumentation of the properties or
            //   namespaces that are mentioned in the array.

            var func0 = function() { };
            func0.func1 = function() { };
            func0.func1.func2 = function() { };
            func0.func1.func2.func3 = function() { return "way too deep" };
            anzoLogTestNamespace = { func0: func0 }; // global on purpose to simulate a namespace

            // Set the recursion threshold very low temporarily
            var oldThreshold = anzo.log._INSTRUMENTATION_RECURSION_THRESHOLD;
            anzo.log._INSTRUMENTATION_RECURSION_THRESHOLD = 2;
            var exceptionRaised = false;
            try {
                anzo.log.addMethodTracing("anzoLogTestNamespace");
            } catch(e) {
                if (e.message == "addMethodTracing - recursion too deep. There may be a cycle in the namespace being instrumented. Parts of the namespace may have been instrumented. Error while instrumenting namespace:\nanzoLogTestNamespace.func0.func1.func2.func3.prototype") {
                    exceptionRaised = true;
                }
            } finally {
                // Try not to affect other tests in case of failure
                anzo.log._INSTRUMENTATION_RECURSION_THRESHOLD = oldThreshold;
            }

            tests.assertTrue(exceptionRaised);
        },

        function test_addMethodTracingAllowsExceptionsToFlowThroughInstrumentedMethods() {
            // summary: Exceptions that happen in instrumented methods should not be affected by instrumentation.

            anzoLogTestNamespace = { instrumented : function() { throw new Error("My Exception"); } } // global on purpose to simulate a namespace

            anzo.log.addMethodTracing("anzoLogTestNamespace");

            var exceptionRaised = false;
            try {
                anzoLogTestNamespace.instrumented();
            } catch(e) {
                if (e.message == "My Exception") {
                    exceptionRaised = true;
                }
            }

            tests.assertTrue(exceptionRaised);
        },

        function test_MDCPropertiesAreOutput() {
            // summary: MDC properties referenced in the patterns should be output in the log messages.
            //  If the property doesn't exist in the MDC, it should just be output as blank.
            var logMessages = [];
            var testArrayAppender = new ArrayAppender(logMessages, new anzo.log.log4javascript.PatternLayout("%-5p %c %x{propA} %x{propB} - %m"));
            var logger = anzo.log.log4javascript.getLogger("test_MDCPropertiesAreOutput_logger");
            logger.removeAllAppenders(); // Reset the appenders so that we start with a clean slate here in case other tests have messed with the appenders.
            logger.addAppender(testArrayAppender);
            logger.setLevel(anzo.log.log4javascript.Level.TRACE);

            anzo.log.log4javascript.MDC.clear();
            logger.trace("Nothing yet inside MDC.");
            anzo.log.log4javascript.MDC.put("propA", "prop_A_data");
            anzo.log.log4javascript.MDC.put("propB", "prop_B_data");
            logger.error("Now there is data in the MDC.");
            anzo.log.log4javascript.MDC.put("propA", "prop_A_data2");
            anzo.log.log4javascript.MDC.remove("propB");
            logger.warn("Now there is data only in propA in the MDC.");
            anzo.log.log4javascript.MDC.clear();
            logger.info("MDC cleared.");

            tests.assertEqual(4, logMessages.length);
            tests.assertEqual("TRACE test_MDCPropertiesAreOutput_logger   - Nothing yet inside MDC.", logMessages[0]);
            tests.assertEqual("ERROR test_MDCPropertiesAreOutput_logger prop_A_data prop_B_data - Now there is data in the MDC.", logMessages[1]);
            tests.assertEqual("WARN  test_MDCPropertiesAreOutput_logger prop_A_data2  - Now there is data only in propA in the MDC.", logMessages[2]);
            tests.assertEqual("INFO  test_MDCPropertiesAreOutput_logger   - MDC cleared.", logMessages[3]);
        },

        function test_MDCAppend() {
            // summary: The MDC append method should return the old value and append the string to the current value.
            anzo.log.log4javascript.MDC.clear();

            var appendResult1 = anzo.log.log4javascript.MDC.append("propA", "prop_A_data");
            var appendResult2 = anzo.log.log4javascript.MDC.append("propA", ":secondAppend");
            var appendResult3 = anzo.log.log4javascript.MDC.append("propA", ":thirdAppend");
            anzo.log.log4javascript.MDC.put("propB", 4); // Try appending to a value that isn't a string
            anzo.log.log4javascript.MDC.append("propB", ":numberAppend");

            tests.assertEqual("prop_A_data:secondAppend:thirdAppend", anzo.log.log4javascript.MDC.get("propA"));
            tests.assertEqual("4:numberAppend", anzo.log.log4javascript.MDC.get("propB"));
            tests.assertEqual("prop_A_data", appendResult1);
            tests.assertEqual("prop_A_data:secondAppend", appendResult2);
            tests.assertEqual("prop_A_data:secondAppend:thirdAppend", appendResult3);

            anzo.log.log4javascript.MDC.clear();
        },

        function test_applyConfigSetsLoggersFromSimpleConfig() {
            // summary: Test that a basic config file is loaded and the appropriate log levels are set for the loggers.
            var configStr = "anzo.tests.log.TestLogger.test_applyConfigSetsLoggersFromSimpleConfig=DEBUG\nanzo.tests.log.AnotherTestLogger.test_applyConfigSetsLoggersFromSimpleConfig=FATAL";
            var success = anzo.log.applyConfig(configStr);
            tests.assertTrue(success);
            var loggers = anzo.log.log4javascript.evalInScope("loggers"); // grab the private loggers map from log4javascript. We'll be nice. We won't mess with it, we'll just take a quick look at it.
            tests.assertTrue(loggers["anzo.tests.log.TestLogger.test_applyConfigSetsLoggersFromSimpleConfig"].getLevel().equals(anzo.log.log4javascript.Level.DEBUG));
            tests.assertTrue(loggers["anzo.tests.log.AnotherTestLogger.test_applyConfigSetsLoggersFromSimpleConfig"].getLevel().equals(anzo.log.log4javascript.Level.FATAL));
        },

        function test_applyConfigAllowsWhitespace() {
            // summary: Test that whitespace is allowed at the start of the line, between the equal sign and at the end of the line.
            //   Also, empty lines and lines that are only whitespace are also allowed.
            var configStr = "  \n\t\n\n  anzo.tests.log.TestLogger.test_applyConfigAllowsWhitespace=DEBUG  \n\tanzo.tests.log.AnotherTestLogger.test_applyConfigAllowsWhitespace = FATAL \n";
            var success = anzo.log.applyConfig(configStr);
            tests.assertTrue(success);
            var loggers = anzo.log.log4javascript.evalInScope("loggers"); // grab the private loggers map from log4javascript. We'll be nice. We won't mess with it, we'll just take a quick look at it.
            tests.assertTrue(loggers["anzo.tests.log.TestLogger.test_applyConfigAllowsWhitespace"].getLevel().equals(anzo.log.log4javascript.Level.DEBUG));
            tests.assertTrue(loggers["anzo.tests.log.AnotherTestLogger.test_applyConfigAllowsWhitespace"].getLevel().equals(anzo.log.log4javascript.Level.FATAL));
        },

        function test_applyConfigAllowsComments() {
            // summary: Test that lines with hash marks (#) are ignores. Whitespace before the hash mark is allowed. Make sure
            //  to include comments that end in windows end-of-line marks since bugs in parsing those have previously been found.
            var configStr = "# comment with a windows end-of-line.\r\n# a comment\nanzo.tests.log.TestLogger.test_applyConfigAllowsComments=DEBUG# a comment after the log description\n \t # a comment after some whitespace\nanzo.tests.log.AnotherTestLogger.test_applyConfigAllowsComments = FATAL\n#anzo.tests.log.ShouldNotBeReadAsLogger.test_applyConfigAllowsComments=INFO\r\n";
            var success = anzo.log.applyConfig(configStr);
            tests.assertTrue(success);
            var loggers = anzo.log.log4javascript.evalInScope("loggers"); // grab the private loggers map from log4javascript. We'll be nice. We won't mess with it, we'll just take a quick look at it.
            tests.assertTrue(loggers["anzo.tests.log.TestLogger.test_applyConfigAllowsComments"].getLevel().equals(anzo.log.log4javascript.Level.DEBUG));
            tests.assertTrue(loggers["anzo.tests.log.AnotherTestLogger.test_applyConfigAllowsComments"].getLevel().equals(anzo.log.log4javascript.Level.FATAL));
            tests.assertFalse(loggers["anzo.tests.log.ShouldNotBeReadAsLogger.test_applyConfigAllowsComments"]);
        },

        function test_applyConfigAllowsCarriageReturnAndNewline() {
            // summary: Make sure it can handle parsing \r\n style end of lines.
            var configStr = "anzo.tests.log.TestLogger.test_applyConfigAllowsCarriageReturnAndNewline=DEBUG\r\nanzo.tests.log.AnotherTestLogger.test_applyConfigAllowsCarriageReturnAndNewline=FATAL\r\n";
            var success = anzo.log.applyConfig(configStr);
            tests.assertTrue(success);
            var loggers = anzo.log.log4javascript.evalInScope("loggers"); // grab the private loggers map from log4javascript. We'll be nice. We won't mess with it, we'll just take a quick look at it.
            tests.assertTrue(loggers["anzo.tests.log.TestLogger.test_applyConfigAllowsCarriageReturnAndNewline"].getLevel().equals(anzo.log.log4javascript.Level.DEBUG));
            tests.assertTrue(loggers["anzo.tests.log.AnotherTestLogger.test_applyConfigAllowsCarriageReturnAndNewline"].getLevel().equals(anzo.log.log4javascript.Level.FATAL));
        },

        function test_applyConfigIgnoresMalformedLines() {
            // summary: Make sure it can handle parsing \r\n style end of lines.
            var configStr = "anzo.tests.log.MalformedLogger.test_applyConfigIgnoresMalformedLines\nanzo.tests.log.MalformedLogger.test_applyConfigIgnoresMalformedLines==DEBUG\nanzo.tests.log.MalformedLogger.test_applyConfigIgnoresMalformedLines=UNKNOWN\n=DEBUG\nanzo.tests.log.TestLogger.test_applyConfigIgnoresMalformedLines=DEBUG\r\nanzo.tests.log.AnotherTestLogger.test_applyConfigIgnoresMalformedLines=FATAL\r\n";
            var success = anzo.log.applyConfig(configStr);
            tests.assertTrue(success == false);
            var loggers = anzo.log.log4javascript.evalInScope("loggers"); // grab the private loggers map from log4javascript. We'll be nice. We won't mess with it, we'll just take a quick look at it.
            tests.assertTrue(loggers["anzo.tests.log.TestLogger.test_applyConfigIgnoresMalformedLines"].getLevel().equals(anzo.log.log4javascript.Level.DEBUG));
            tests.assertTrue(loggers["anzo.tests.log.AnotherTestLogger.test_applyConfigIgnoresMalformedLines"].getLevel().equals(anzo.log.log4javascript.Level.FATAL));
            tests.assertFalse(loggers["anzo.tests.log.MalformedLogger.test_applyConfigIgnoresMalformedLines"]);
            // Make sure the parser didn't take the extra equal sign as part of the logger name
            tests.assertFalse(loggers["anzo.tests.log.MalformedLogger.test_applyConfigIgnoresMalformedLines="]);
        },

        function test_applyConfigIgnoresCommentsWithoutSpaceAfterHash() {
            // summary: A comment starts with a hash mark and shouldn't be mistakenly interpreted as a logger.
            var configStr = "#anzo.tests.log.TestLogger.test_applyConfigIgnoresCommentsWithoutSpaceAfterHash=DEBUG";
            var success = anzo.log.applyConfig(configStr);
            tests.assertTrue(success);
            var loggers = anzo.log.log4javascript.evalInScope("loggers"); // grab the private loggers map from log4javascript. We'll be nice. We won't mess with it, we'll just take a quick look at it.
            tests.assertFalse(loggers["#anzo.tests.log.TestLogger.test_applyConfigIgnoresCommentsWithoutSpaceAfterHash"]);
        },

        function test_applyConfigAcceptsEmptyString() {
            // summary: The empty string is a succesful no-op.
            var success = anzo.log.applyConfig("");
            tests.assertTrue(success);
        },

        function test_applyConfigRequiresArgument() {
            // summary: A string must be given as an argument. Otherwise it throws an exception.
            var exceptionThrown = false;
            try {
                anzo.log.applyConfig();
            } catch (e) {
                exceptionThrown = true;
            }
            tests.assertTrue(exceptionThrown);
        },

        function test_IsEnabledForLogLevelOFF() {
            var logger = anzo.log.getLogger("anzo.tests.log.TestLogger.test_IsEnabledForLogLevelOFF");
            logger.setLevel(anzo.log.log4javascript.Level.OFF);
            tests.assertFalse(logger.isTraceEnabled());
            tests.assertFalse(logger.isDebugEnabled());
            tests.assertFalse(logger.isInfoEnabled());
            tests.assertFalse(logger.isWarnEnabled());
            tests.assertFalse(logger.isErrorEnabled());
            tests.assertFalse(logger.isFatalEnabled());
        },

        function test_IsEnabledForLogLevelFATAL() {
            var logger = anzo.log.getLogger("anzo.tests.log.TestLogger.test_IsEnabledForLogLevelFATAL");
            logger.setLevel(anzo.log.log4javascript.Level.FATAL);
            tests.assertFalse(logger.isTraceEnabled());
            tests.assertFalse(logger.isDebugEnabled());
            tests.assertFalse(logger.isInfoEnabled());
            tests.assertFalse(logger.isWarnEnabled());
            tests.assertFalse(logger.isErrorEnabled());
            tests.assertTrue(logger.isFatalEnabled());
        },

        function test_IsEnabledForLogLevelERROR() {
            var logger = anzo.log.getLogger("anzo.tests.log.TestLogger.test_IsEnabledForLogLevelERROR");
            logger.setLevel(anzo.log.log4javascript.Level.ERROR);
            tests.assertFalse(logger.isTraceEnabled());
            tests.assertFalse(logger.isDebugEnabled());
            tests.assertFalse(logger.isInfoEnabled());
            tests.assertFalse(logger.isWarnEnabled());
            tests.assertTrue(logger.isErrorEnabled());
            tests.assertTrue(logger.isFatalEnabled());
        },

        function test_IsEnabledForLogLevelWARN() {
            var logger = anzo.log.getLogger("anzo.tests.log.TestLogger.test_IsEnabledForLogLevelWARN");
            logger.setLevel(anzo.log.log4javascript.Level.WARN);
            tests.assertFalse(logger.isTraceEnabled());
            tests.assertFalse(logger.isDebugEnabled());
            tests.assertFalse(logger.isInfoEnabled());
            tests.assertTrue(logger.isWarnEnabled());
            tests.assertTrue(logger.isErrorEnabled());
            tests.assertTrue(logger.isFatalEnabled());
        },

        function test_IsEnabledForLogLevelINFO() {
            var logger = anzo.log.getLogger("anzo.tests.log.TestLogger.test_IsEnabledForLogLevelINFO");
            logger.setLevel(anzo.log.log4javascript.Level.INFO);
            tests.assertFalse(logger.isTraceEnabled());
            tests.assertFalse(logger.isDebugEnabled());
            tests.assertTrue(logger.isInfoEnabled());
            tests.assertTrue(logger.isWarnEnabled());
            tests.assertTrue(logger.isErrorEnabled());
            tests.assertTrue(logger.isFatalEnabled());
        },

        function test_IsEnabledForLogLevelDEBUG() {
            var logger = anzo.log.getLogger("anzo.tests.log.TestLogger.test_IsEnabledForLogLevelDEBUG");
            logger.setLevel(anzo.log.log4javascript.Level.DEBUG);
            tests.assertFalse(logger.isTraceEnabled());
            tests.assertTrue(logger.isDebugEnabled());
            tests.assertTrue(logger.isInfoEnabled());
            tests.assertTrue(logger.isWarnEnabled());
            tests.assertTrue(logger.isErrorEnabled());
            tests.assertTrue(logger.isFatalEnabled());
        },

        function test_IsEnabledForLogLevelTRACE() {
            var logger = anzo.log.getLogger("anzo.tests.log.TestLogger.test_IsEnabledForLogLevelTRACE");
            logger.setLevel(anzo.log.log4javascript.Level.TRACE);
            tests.assertTrue(logger.isTraceEnabled());
            tests.assertTrue(logger.isDebugEnabled());
            tests.assertTrue(logger.isInfoEnabled());
            tests.assertTrue(logger.isWarnEnabled());
            tests.assertTrue(logger.isErrorEnabled());
            tests.assertTrue(logger.isFatalEnabled());
        },

        function test_IsEnabledForLogLevelALL() {
            var logger = anzo.log.getLogger("anzo.tests.log.TestLogger.test_IsEnabledForLogLevelALL");
            logger.setLevel(anzo.log.log4javascript.Level.ALL);
            tests.assertTrue(logger.isTraceEnabled());
            tests.assertTrue(logger.isDebugEnabled());
            tests.assertTrue(logger.isInfoEnabled());
            tests.assertTrue(logger.isWarnEnabled());
            tests.assertTrue(logger.isErrorEnabled());
            tests.assertTrue(logger.isFatalEnabled());
        }
    ]
);

})();
