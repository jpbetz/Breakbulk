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

dojo.provide("anzo.log._base");

dojo.require("anzo.log.log4javascript");

(function(){
var _consoleAppender = new anzo.log.log4javascript.BrowserConsoleAppender(new anzo.log.log4javascript.PatternLayout("%d{HH:mm:ss} %-5p %x{operationId} %c - %m%n"));
_consoleAppender.setThreshold(anzo.log.log4javascript.Level.TRACE);

var _operationIdCounter = 1; // Unique global counter for generating unique request Ids 

dojo.mixin(anzo.log, {
    
    _levels : [ anzo.log.log4javascript.Level.ALL, anzo.log.log4javascript.Level.TRACE, anzo.log.log4javascript.Level.DEBUG, anzo.log.log4javascript.Level.INFO, anzo.log.log4javascript.Level.WARN, anzo.log.log4javascript.Level.ERROR, anzo.log.log4javascript.Level.FATAL, anzo.log.log4javascript.Level.OFF ],

    // summary: The log active level for all loggers created via the anzo.log.getLogger method.
    //  Change this if you want to affect the initial state of loggers as they are created rather
    //  than changing their state after they have been created.
    defaultLogLevel : 4, // WARN. This is an index into the anzo.log._levels array. We use the index here rather than just referencing log4javascript.Level.WARN so that when we do entry/exit instrumentation on anzo.log, it doesn't flow through instrumenting the log4javascript WARN object itself.

    _INSTRUMENTATION_RECURSION_THRESHOLD : 20,
    
    getLogger : function getLogger(loggerName) {
        // summary: Returns a log4javascript logger setup to log according to Anzo.JS conventions. It logs
        //   to the browser console (Firebug or Firebug Lite). Calling this method more than once won't create
        //   a new logger. It will reuse the previously created logger.
        // description: Anzo.JS convention is to have JavaScript objects with methods include a logger
        //   for the methods to use. The loggers created via this method by default log to the built-in browser
        //   console (Firebug in Firefox, Firebug Lite in IE, etc.) using the log4javascript BrowserConsoleAppender.
        //   They output log messages using the default pattern: "%d{HH:mm:ss} %-5p %x{operationId} %c - %m%n". The
        //   operationId is taken from the MDC and is typically set by the Anzo.JS framework.
        // loggerName: Anzo.JS convention is such that the full namespaced name of the object containing the
        //   logger is used as the loggerName.
        // example:
        //   | dojo.provide("anzo.foo.Bar");
        //   | dojo.require("anzo.log");
        //   | (function(){
        //   | var log = anzo.log.getLogger("anzo.foo.Bar");
        //   | dojo.declare("anzo.foo.Bar", null, {
        //   |     myMethod : function myMethod() {
        //   |         // do stuff...
        //   |         log.debug("A log message.");
        //   |     }
        //   | }
        //   | })();
    	var logger = anzo.log.log4javascript.getLogger(loggerName);
    	// We use the _AnzoInitialized property on the logger to denote if the appenders for the log have been setup yet. 
    	if (!logger._AnzoInitialized) {
        	logger.addAppender(_consoleAppender);
        	logger.setLevel(this._levels[this.defaultLogLevel]);
        	logger._AnzoInitialized = true;
    	}
    	return logger;
    },
    
    setPattern : function setPattern(pattern) {
        // summary: Sets the pattern used by the log statements.
        // pattern: String
        //   The pattern format is similar to the log4j PatternLayout format. See the log4javascript
        //   documentation for more information: http://www.timdown.co.uk/log4javascript/log4javascript-current/docs/manual.html#patternlayout
        //   One extra conversion charater is supported for access to the Mapped Diagnostic Context (MDC): x. To show a property
        //   in the MDC use a pattern like: "%x{propertyName}" where 'propertyName' is the relevant property in the MDC.
        // description: Note that this pattern is only used for loggers which are obtained using the anzo.log.getLogger
        //   method. 
        _consoleAppender.setLayout(new anzo.log.log4javascript.PatternLayout(pattern));
    },

    addMethodTracing : function addMethodTracing(namespace, deep, skip, loggerFactoryMethod, _obj, _recurseCount) {
        // summary: Traverses a JavaScript namespace instrumenting each method in the namespace with
        //   entry and exit log messages.
        // description: The trace log messages are written to the TRACE log level using the log4javascript framework.
        //   The name of the logger logger used for a given method is the full namespace name of the object in which
        //   the method lives. For example, entry/exit log messages for the anzo.client.AnzoClient.connect() method
        //   are written to a logger with the name "anzo.client.AnzoClient".
        //   Note that, by default, the loggers are set to the DEBUG level which means that the TRACE level messages
        //   won't be output. The loggers' level can be set to TRACE to see the entry/exit log messages.
        // namespace: String
        //   The JavaScript namespace that should be instrumented.
        // deep: Boolean
        //   Optional. If true, the namespace will be instrumented recursively. If false, only the given namespace level will be
        //   instrumented with method tracing. Default is true.
        // skip: Array of String
        //   Optional. If given, then any property mentioned there will not be instrumented or recursed. You can either
        //   list a property name (ex. "global") or a full namespace name (ex. "dojo.global") for each element. By default,
        //   "constructor", "log4javascript", "dojo.global", "dojo.doc", and "dojo._loadedModules" properties are ignored to avoid cycles.
        //   If you supply your own, you should probably include at least "constructor" unless you are sure it won't cause a cycle.
        // loggerFactoryMethod: Function(String)
        //   Optional. If supplied, the loggers for tracing will be created using this method. By default the
        //   anzo.log.getLogger() method is used. This can be useful is for tracing using different log appenders or layouts.
        // _obj: Object
        //   Optional. If supplied, the method will start instrumenting this object rather then the object of the given 
        //   namespace. This isn't typically useful except for testing or internal use.
        // _recurseCount: Number
        //   Optional. This is only for internal use. It is a counter to know how many levels deep in recursion
        //   this method is being called under. This is used for simple cycle detection. The method will throw an
        //   exception if the _recurseCount is greater than this._INSTRUMENTATION_RECURSION_THRESHOLD.
        
        log.debug("addMethodTracing(" + namespace + ", " + deep + ", " + (skip ? skip.toString() : skip) + ", " + loggerFactoryMethod + ", " + (_obj ? _obj.toString() : _obj) + ", " + _recurseCount + ")");
        if (!dojo.isString(namespace)) {
            throw new Error("addMethodTracing - namespace argument must be a string.");
        }
        if (!_recurseCount) {
            _recurseCount = 0;
        }
        if (_recurseCount > this._INSTRUMENTATION_RECURSION_THRESHOLD) {
            throw new Error("addMethodTracing - recursion too deep. There may be a cycle in the namespace being instrumented. Parts of the namespace may have been instrumented. Error while instrumenting namespace:\n" + namespace);
        }
        if (!skip) {
            // We skip these by default to avoid cycles.
            skip = [ "constructor", "dojo.global", "dojo.doc", "dojo._loadedModules", "log4javascript" ];
            log.debug("addMethodTracing - skip parameter not given, using: " + skip);
        }
        if (skip.indexOf(namespace) != -1) {
            log.debug("addMethodTracing - skipping namespace: " + namespace);
            return;
        }
        if (deep === undefined || deep === null) {
            log.debug("addMethodTracing - deep parameter not given, setting to true.");
            deep = true;
        }
        if (!loggerFactoryMethod) {
            log.debug("addMethodTracing - using default logger factory: anzo.log.getLogger.");
            loggerFactoryMethod = anzo.log.getLogger;
        }
        var namespaceObj = _obj ? _obj : eval(namespace); 
        log.debug("addMethodTracing - namespaceObj: " + namespaceObj);
        if (!namespaceObj) {
            log.debug("addMethodTracing - namespaceObj is null or undefined. Nothing to instrument.");
            return;
        }
        for (var property in namespaceObj) {
            if (skip.indexOf(property) != -1) {
                log.debug("addMethodTracing - skipping property: " + property);
                continue;
            }
            var val = namespaceObj[property];
            var propertyNamespace = namespace + "." + property;
            if (anzo.log.log4javascript.Level.DEBUG.isGreaterOrEqual(log.getLevel())) {
                log.debug("addMethodTracing - property:" + property + " - typeof val:" + (typeof val) + (dojo.isArray(val) ? " dojo.isArray(val):true" : "") + (val instanceof RegExp ? " RegExp" : ""));
            }
            if (dojo.isFunction(val) && !(val instanceof RegExp) && !val._InstrumentedForTracing) {
                // RegExp objects are typeof "function" in many browsers so we have to check instanceof to avoid instrumenting RegExp objects.
                var logger = loggerFactoryMethod.call(this, namespace);
                log.debug("addMethodTracing - instrumenting property: " + property);

                // The wrapper function logs an entry message showing each argument, calls the method,
                // and then logs an exit message showing the return value.
                var wrapper = (function(f, prop) { return function methodTracingWrapper() {
                    var methodNameStr = namespace + "." + prop;
                    var enterTraceStr = "ENTER " + methodNameStr + "(";
                    var argsStr = "";
                    for (var i = 0; i < arguments.length; i++) {
                        var arg = arguments[i];
                        argsStr += (arg ? arg.toString() : arg) + (i == arguments.length - 1 ? "" : ", ");
                    }
                    logger.trace(enterTraceStr + argsStr + ")");
                    var ret = f.apply(this, arguments);
                    logger.trace("EXIT " + methodNameStr + " returned " + (ret ? ret.toString() : ret));
                    return ret;
                }})(val, property);
                wrapper._InstrumentedForTracing = true;

                // We need to copy all of the properties of the current function being instrumented.
                // This is important especially in the case of constructors to make sure the appropriate 
                // prototype is maintained.
                for (var functionProperty in val) {
                    var subval = val[functionProperty];
                    log.debug("addMethodTracing - copying function object property: " + functionProperty + " - " + (subval ? subval.toString() : subval));
                    wrapper[functionProperty] = subval;
                    if (deep && subval) {
                        var recurseNamespace = propertyNamespace + "." + functionProperty;
                        log.debug("addMethodTracing - Recursing on function sub-property:" + recurseNamespace);
                        arguments.callee.call(this, propertyNamespace + "." + functionProperty, deep, skip, loggerFactoryMethod, subval, _recurseCount + 1);  //recurse
                    }
                }
                
                namespaceObj[property] = wrapper; 
            } else if (deep && val && typeof val == "object" && !dojo.isArray(val)) {
                log.debug("addMethodTracing - Recursing on property:" + propertyNamespace);
                arguments.callee.call(this, propertyNamespace, deep, skip, loggerFactoryMethod, val, _recurseCount + 1); // recurse
            }
        }
    },
    
    applyConfig : function applyConfig(config) {
        // summary: Sets the log levels for various loggers as given in the input string.
        // config: String. Configuration string of a format similar to Log4j's log4j.properties file.
        //   For example:
        //   | # Set logger level for AnzoClient
        //   | anzo.client.AnzoClient=DEBUG
        //   | anzo.rdf.NamedGraph=ERROR # Set logger level for NamedGraph
        //   Note that there are some differences from the Log4j format. First, there is no heirarchical
        //   nature to the Anzo loggers. So setting anzo.rdf=DEBUG will not affect the anzo.rdf.NamedGraph logger.
        //   Second, there is no support for configuring layouts and appenders. It is just a list of lines setting
        //   logger levels. Each logger is obtained with the anzo.log.getLogger method.
        // returns: Boolean. true if the whole file was parsed and applied successfully. false if there were errors.
        //   Note that it will simply ignore lines that have parse errors and continue onto other lines.
        if (!dojo.isString(config)) {
            throw new Error("appleConfig - config must be a string.");
        }
        var success = true;
        var loggerRegExp = /^\s*(?:(?:([^# \f\n\r\t\v\u00A0\u2028\u2029=]+)\s*=\s*(\w+)\s*(?:#.*\s*)?)|(?:#.*\s*))?$/
        var lines = config.split("\n");
        for (var i = 0; i < lines.length; i++) {
            var line = lines[i];
            var match = loggerRegExp.exec(line);
            if (match) {
                var loggerName = match[1];
                var logLevelStr = match[2];
                if (loggerName && logLevelStr && loggerName.length > 0 && logLevelStr.length > 0) {
                    var logLevel = null;
                    if (logLevelStr == anzo.log.log4javascript.Level.ALL.name) {
                        logLevel = anzo.log.log4javascript.Level.ALL;
                    } else if (logLevelStr == anzo.log.log4javascript.Level.TRACE.name) {
                        logLevel = anzo.log.log4javascript.Level.TRACE;
                    } else if (logLevelStr == anzo.log.log4javascript.Level.DEBUG.name) {
                        logLevel = anzo.log.log4javascript.Level.DEBUG;
                    } else if (logLevelStr == anzo.log.log4javascript.Level.INFO.name) {
                        logLevel = anzo.log.log4javascript.Level.INFO;
                    } else if (logLevelStr == anzo.log.log4javascript.Level.WARN.name) {
                        logLevel = anzo.log.log4javascript.Level.WARN;
                    } else if (logLevelStr == anzo.log.log4javascript.Level.ERROR.name) {
                        logLevel = anzo.log.log4javascript.Level.ERROR;
                    } else if (logLevelStr == anzo.log.log4javascript.Level.FATAL.name) {
                        logLevel = anzo.log.log4javascript.Level.FATAL;
                    } else if (logLevelStr == anzo.log.log4javascript.Level.OFF.name) {
                        logLevel = anzo.log.log4javascript.Level.OFF;
                    }
                    if (!logLevel) {
                        success = false;
                        log.warn("Error parsing log config - logLevel must be one of ALL, TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF. Note that it's case-sensitive. Ignoring malformed line: " + line);
                    } else if (!loggerName) {
                        success = false;
                        log.warn("Error parsing log config - logger name is missing. Ignoring malformed line: " + line);
                    } else {
                        // All good with the parsing. Get the logger and set its level.
                        log.debug("applyConfig - Setting logger '" + loggerName + "' to level '" + logLevel.name + "'.");
                        var logger = anzo.log.getLogger(loggerName);
                        logger.setLevel(logLevel);
                    }
                } // else this is just a blank line or a comment so just ignore it.
            } else {
                success = false;
                log.warn("Error parsing log config. Ignoring malformed line: " + line);
            }
        }
        
        return success;
    },
    
    _generateOperationId : function _generateOperationId() {
        // summary: Generate a unique string that can be used for naming operations. This is useful
        //   to add into log messages, using the anzo.log.log4javascript.MDC, for grouping related
        //   log messages.
        return "" + _operationIdCounter++; 
    } 
});

var log = anzo.log.getLogger("anzo.log");

})();
