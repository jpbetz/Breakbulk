/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

dojo.provide("anzo.tests.utilities");

dojo.require("anzo.client.JMSResetService");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.client.TransactionQueue");
dojo.require("anzo.client.TransactionProxy");
dojo.require("anzo.client.JMSUpdateService");
dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.rdf.parser.NTripleParser");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.rdf.QuadStore");
dojo.require("anzo.rdf.vocabulary.XMLSchema");
dojo.require("anzo.utils.UriGenerator");
dojo.require("anzo.rdf.vocabulary.RDF");
dojo.require("anzo.log");
dojo.require("dojo.number");

(function() {
var log = anzo.log.getLogger("anzo.tests.utilities");
    
function _resetHelper() {
    // summary: returns the statements used by the reset methods.

    // NOTE: The rdf string that is used to reset the database MUST be updated when initialize.trig is changed.
    var graph = new anzo.rdf.NamedGraph();
    var str = anzo.tests.utilities.loadTextFile("../../anzo/tests/initialize.json");
    var json = dojo.fromJson(str);
    var stmts =  anzo.client.Serialization.readStatementsFromJson(json);

    return stmts;
}

anzo.tests.utilities = {
    
    waitFor : function(condition, timeout, pollInterval, callback) {
        // summary: Waits for the given condition function to return 'true' or the given timeout expires.
        // condition: Function
        //   A function that takes no arguments and returns a Boolean. This function will be called
        //   repeatedly to check if the condition has become true.
        // timeout: Number
        //   Integer number of milliseconds to wait for the condition to become true. If this amount of time
        //   passes and the condition is not true, then the callback is called with its 'success' argument 
        //   set to 'false'.
        // pollInterval: Number
        //   Integer number of milliseconds to wait between checking the condition.
        // callback: Function
        //   Function called once the condition becomes true or the timeout expires. The first argument
        //   to the method is 'true' if the condition is true or 'false' in case of error or timeout.
        //   In case of error, the second argument contains error information.
        
        if (!dojo.isFunction(condition)) {
            throw new Error("waitFor - condition must be a function.");
        }
        if (pollInterval > timeout) {
            throw new Error("waitFor - pollInterval must be less then the timeout.");
        }
        if (!dojo.isFunction(callback)) {
            throw new Error("waitFor - callback is required.");
        }
        var startTime = new Date().getTime();
        function _poll() {  
            try {
                var pollTime = new Date().getTime();
                if (condition()) {
                    setTimeout(function() { callback(true); }, 0);
                } else if (pollTime - startTime > timeout) {
                    setTimeout(function() { callback(false); }, 0);
                } else {
                    setTimeout(_poll, pollInterval);
                }
            } catch(e) {
                setTimeout(function() { callback(false, e); }, 0);
            }
        }
        setTimeout(_poll, pollInterval);
    },

    reset : function(anzoClient, callback) {
        // summary: Resets the state of the repository to a known testing state.
        anzoClient.reset(_resetHelper(), callback);
    },

    resetRaw : function(callback) {
        // summary: Resets the state of the repository during testing for low-level cases where there is no AnzoClient.
        var resetService = new anzo.client.JMSResetService();
        resetService.reset(_resetHelper(), callback);
    },

    loadTextFile : function loadTextFile(relativePath) {
        // summary: Reads a text file from disk and returns the value as a string. Note that
        //   a 'default encoding' may be used to convert the file's bytes into text. This will
        //   know to use dojo.xhrGet versus Rhino's readFile depending on the environment running
        //   the test. 
        // relativePath : String
        //   A path to the file to load. The same absolute path does not tend to work in both Rhino and the browser
        //   so relative paths are best.
        // returns: The contexts of the file as a string.

        var ret = null;
        var error = null;
        if (dojo.isRhino) {
            ret = readFile(relativePath);
            if (!ret) {
                throw new Error("Error reading file (may not exist): " + relativePath);
            }
        } else {
            dojo.xhrGet({
                url: relativePath, 
                handleAs: "text",
                sync: true,
                timeout: 5000,
                load: function(response, ioArgs) {
                    ret = response;
                    return response;
                },
                error: function(response, ioArgs) {
                    var msg = "Error loading " + relativePath + " - HTTP status code: " + ioArgs.xhr.status;
                    error = new Error(msg);
                    return response;
                }
            });
            
        }

        if (error) {
            throw error;
        }
        
        return ret;
    },
            
    skipTestInRhino : function skipTestInRhino(reasonMsg) {
        // summary: Checks if you are running inside the Rhino JavaScript engine.
        //    If so, it returns true and prints a message saying the test will be skipped
        //    and includes the given reasonMsg string in the message.
        // description: 
        //  Example usage:
        //  | if (anzo.tests.utilities.skipTestInRhino("DOMParser does not exist in Rhino")) {
        //  |     return;
        //  | }
        //  | // rest of test...     
        // 
        // reasonMsg: String. This should be filled with something informational about why
        //   the test isn't run inside Rhino.
        if (dojo.isRhino) {
            log.warn("Skipping test inside Rhino: " + reasonMsg);
        }
        return dojo.isRhino;
    },
    
    objectPropertiesToString : function objectPropertiesToString(obj, showValues) {
        // summary: Iterates through an objects properties, adding them to a string optionally 
        //   with their values. This is mainly useful as a debugging tool.
        // obj: Object. The object to render
        // showValues: Boolean. If true, the property values are included in the returned string. Defaults to false.
        // returns: String. A string with the object's properties.
        var str = "";
        for (var prop in obj) {
            str += prop;
            if (showValues) {
                str += ":" + obj[prop];
            }
            str += "\n"; 
        }
        return str;
    },

    formatExpectedTimeString : function formatExpectedTimeString(date) {
        // summary: Formats a string in the xsd:time format based on the local time values of the give Date object.
        //  For example, "20:05:12.014"
        return dojo.number.format(date.getHours(), { pattern: "00" }) + ":" + dojo.number.format(date.getMinutes(), { pattern: "00" }) + ":" + dojo.number.format(date.getSeconds(), { pattern: "00" }) + "." + dojo.number.format(date.getMilliseconds(), { pattern: "000" });
    },
    
    formatExpectedDateString : function formatExpectedDateString(date) {
        // summary: Formats a string in the xsd:date format based on the local time values of the give Date object.
        //  For example, "2009-06-01"
        return dojo.number.format(date.getFullYear(), { pattern: "0000" }) + "-" + dojo.number.format(date.getMonth() + 1, { pattern: "00" }) + "-" + dojo.number.format(date.getDate(), { pattern: "00" });
    },
    
    deepCompareJSONObjects : function deepCompareJSONObjects(o1, o2, propertiesToSkip, unorderedProperties) {
        // summary: Performs a deep compare of two JavaScript objects. Do not call this on objects with cycles or on objects
        //  with functions. It is intended to compare loaded JSON strings or objects that will be serialized to JSON.
        
        // description: This function is useful in tests because comparing actual JSON strings to expected
        //  JSON strings is not compatible across JavaScript runtimes. Since properties in JavaScript
        //  objects can be in any order, the strings aren't guaranteed to be equal even though 
        //  the represent the same JSON data. Rhino, for example uses a different order than 
        //  SpiderMonkey (Firefox). So having both JSON strings parsed into JavaScript objects will
        //  work better.
        //  Keep in mind that if either JavaScript object has cycles or functions, this function
        //  will not work. It will throw an exception if you're lucky or overflow the stack
        //  if you aren't.
        //  Example usage:
        //  | tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(jsonObject, expectedJsonObject)); 
   
            // o1: Object or Array. An object to compare.
        // o2: Object or Array. The other object to compare.
        // propertiesToSkip: (Optional) Array of Strings. Any properties denoted in this array will be ignored for purposes of comparison. 
        // unorderedProperties: (Optional) Array of Strings. Any properties denoted in this array will be compared without regard to order even if the property contains an array.
        
        function _deepCompareJSONObjects(o1, o2, propertiesToSkip, unorderedProperties, unorderedArrayComparison) {
            // summary: internal helper function which takes a boolean as the last argument to denote if
            //  array comparison should be ordered (false) or unordered (true)
            //log.debug("deepCompareJSONObjects:\n\to1:" + dojo.toJson(o1, true) + "\n\to2:" + dojo.toJson(o2, true));
            var recurse = arguments.callee;
            var typeOfo1 = typeof(o1); 
            var typeOfo2 = typeof(o2); 
            if (typeOfo1 !== typeOfo2) {
                log.info("deepCompareJSONObjects: Arguments do not have the same type.");
                return false;
            }
            
            if (dojo.isFunction(o1) || dojo.isFunction(o2)) {
                throw "deepCompareJSONObjects does not support functions.";
            } else if (dojo.isArray(o1) || dojo.isArray(o2)) {
                if (o1.length !== o2.length) {
                    log.info("deepCompareJSONObjects: Arguments are arrays with different lengths.");
                    return false;
                }
                if (unorderedArrayComparison) {
                    var seen = new Array(o2.length);
                    for (var i = 0; i < o1.length; i++) {
                        for (var j = 0; j < o2.length; j++) {
                            if (!seen[j]) {
                                var result = recurse(o1[i], o2[j], propertiesToSkip, unorderedProperties, false);
                                if (result) {
                                    seen[j] = true;
                                    break;
                                }
                            }
                        }
                        if (j >= o2.length) {
                            log.info("deepCompareJSONObjects: Unordered array comparison failed. Could not find o1[" + i + "] inside o2.");
                            return false;
                        }
                    }
                } else {
                    for (var i = 0; i < o1.length; i++) {
                        var result = recurse(o1[i], o2[i], propertiesToSkip, unorderedProperties, false);
                        if (!result) {
                            return false;
                        }
                    }
                    
                }
            } else if (typeOfo1 === "undefined" || typeOfo1 === null || typeOfo1 === "number" || typeOfo1 === "boolean" || dojo.isString(o1) ||
                        typeOfo2 === "undefined" || typeOfo2 === null || typeOfo2 === "number" || typeOfo2 === "boolean" || dojo.isString(o2)) {
                if (o1 !== o2) {
                    log.info("deepCompareJSONObjects: Leaf values are different.\n\to1:" + o1 + "\n\to2:" + o2);
                    return false;
                }
            } else { 
                for(var i in o1) {
                    if (!propertiesToSkip || !propertiesToSkip.some(function (x) { return x == i; })) {
                        var foundProperty = false;
                        for (var j in o2) {
                            if (i == j) {
                                foundProperty = true;
                                break;
                            }
                        }
                        if (!foundProperty) {
                            log.info("deepCompareJSONObjects: o2 or an object within it is missing property '" + i + "'");
                            return false;
                        }
                        
                        var needUnorderedArrayComparison = unorderedProperties ? unorderedProperties.some(function(x) { return x == i; }) : false;
                        var result = recurse(o1[i], o2[j], propertiesToSkip, unorderedProperties, needUnorderedArrayComparison);
                        if (!result) {
                            return false;
                        }
                    }
                }
                
                // We've checked that o2 has all of the properties that o1 has and that they are the same.
                // Now check that o2 doesn't have any 'extra' properties that o1 is missing. It doesn't matter if they
                // are the same or not since they are extra.
                for(var i in o2) {
                    if (!propertiesToSkip || !propertiesToSkip.some(function (x) { return x == i; })) {
                        var foundProperty = false;
                        for(var j in o1) {
                            if (i == j) {
                                foundProperty = true;
                                break;
                            }
                        }
                        if (!foundProperty) {
                            log.info("deepCompareJSONObjects: o1 or an object within it is missing property '" + i + "'");
                            return false;
                        }
                    }
                }
                
            }
    
            return true;
        }
        
        return _deepCompareJSONObjects(o1, o2, propertiesToSkip, unorderedProperties, false);
    },
    
    escapeXML : function escapeXML(str) {
        // summary: escapes the special XML characters into their appropriate entities (&gt, &lt, &quot, &amp, &apos).
        
        return str.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&apos;");
    },
    
    rawUpdateRepository : function rawUpdateRepository(statements, addOrRemove, callback) {
        // summary: Adds or removes statements from the server by directly communicating
        //   with the JMSUpdateService rather than via the AnzoClient API. Note that the statements
        //   must be full Quads (include the namespaceUri).
        // description: This is useful only to unit tests that are testing internal systems
        //   and so do not have the ability to make these changes via the traditional means.
        // statements: Array of anzo.rdf.Statement objects
        //   List of quads to add or remove.
        // addOrRemove: Boolean
        //   If true, the statements will be added. If false, they will be removed.
        var quadStore = new anzo.rdf.QuadStore();
        var transactionQueue = new anzo.client.TransactionQueue();
        var store = new anzo.client.TransactionProxy(quadStore, transactionQueue);
    
        transactionQueue.begin();
        for (var i = 0; i < statements.length; i++) {
            if (addOrRemove) {
                store.add(statements[i]);	    
            } else {
                store.remove(statements[i]);
            }
        }
        transactionQueue.commit();
        
        var transactions = transactionQueue.committedTransactions;
        
        var updateService = new anzo.client.JMSUpdateService();
        updateService.updateServer(transactions, false, false, callback);
    },

    rawCreateGraph : function rawCreateGraph(graphUri, callback) {
        // summary: Creates a graph on the server via direct calls to the JMSUpdateService 
        //   rather than via the graph API. Note that the statements.
        // description: This is useful only to unit tests that are testing internal systems
        //   and so do not have the ability to make these changes via the traditional means.
        // graphUri: String
        //   The new graph's URI.
        
        // Creating a graph is done by adding two special statements.
        var metadataGraphUri = anzo.utils.UriGenerator.getMetadataGraphUri(graphUri);
        var statements = [
            anzo.createStatement(graphUri, anzo.client.Vocabulary.hasMetadataGraphProperty, metadataGraphUri, metadataGraphUri),
            anzo.createStatement(graphUri, anzo.rdf.vocabulary.RDF.type, anzo.client.Vocabulary.namedGraphType, metadataGraphUri)
        ];
        rawUpdateRepository(statements, true, callback);
    },

    addStmts : function(store, numStmts, numS, numP, numO, numC, base, createObject) {
        
        // summary: adds numStmts statements to the given store
                
        var sCount = 1; 
        var pCount = 1;//Math.floor(numP/2);
        var oCount = 1;//Math.floor(numO/3);
        var cCount = 1;//Math.floor(numO/4);
         
        var patterns = [];
        
        if(!base)
            base = 1;
        
        if(!createObject)
            createObject = function(num) { return 'http://obj'+num; }
        
        for(var i = base; i < numStmts+base; i++) {
           //log.debug("adding: "+anzo.createStatement('http://subj'+sCount++, 'http://pred'+pCount++, 'http://obj'+oCount++, 'http://graph'+cCount++))

            var s = 'http://www.w3.org/1999/02/22-rdf-syntax-ns#Seq'+sCount;
            var p = 'http://www.w3.org/1999/02/22-rdf-syntax-ns#first'+pCount;
            var o = createObject(sCount, pCount, oCount, cCount);
            var c = 'http://www.w3.org/1999/02/22-rdf-syntax-ns#graph'+cCount;
            
            var stmt = anzo.createStatement(s, p, o, c);
            if(i == base+1)
              patterns[0] = stmt
            if(i == Math.floor((numStmts+base)/2))
              patterns[1] = stmt;
            if(i == numStmts+base-1)
              patterns[2] = stmt;
              
            store.add(stmt);
            
            sCount++;
            pCount++;
            oCount++;
            cCount++;
            
            if(sCount > numS)
              sCount = 1;
            if(pCount > numP)
              pCount = 1;
            if(oCount > numO)
              oCount = 1;
            if(cCount > numC)
              cCount = 1;
              
            
        }
        
        return patterns;
                
    },
    
    
    testAddRemove : function(store) {
            
            
        // ADD QUAD
        store.add('http://subj1', 'http://pred1', 'http://obj1', 'http://graph1');
        tests.assertTrue(store.find('http://subj1', 'http://pred1', 'http://obj1', 'http://graph1').length == 1);
        tests.assertTrue(store.contains('http://subj1', 'http://pred1', 'http://obj1', 'http://graph1'));
        tests.assertTrue(store.find('http://subj1', 'http://pred1', 'http://obj1', ['http://graph1']).length == 1);
        tests.assertTrue(store.contains('http://subj1', 'http://pred1', 'http://obj1', ['http://graph1']));
        
        // ADD QUAD WITH A GRAPH
        var graph1 = new anzo.rdf.NamedGraph('http://graph1');
        store.add('http://subj2', 'http://pred1', 'http://obj1', graph1);
        tests.assertTrue(store.find('http://subj2', 'http://pred1', 'http://obj1', graph1).length == 1);
        tests.assertTrue(store.contains('http://subj2', 'http://pred1', 'http://obj1', graph1));
        tests.assertTrue(store.find('http://subj2', 'http://pred1', 'http://obj1', [graph1]).length == 1);
        tests.assertTrue(store.contains('http://subj2', 'http://pred1', 'http://obj1', [graph1]));
        tests.assertTrue(store.find('http://subj2', 'http://pred1', 'http://obj1').length == 1);
        tests.assertTrue(store.contains('http://subj2', 'http://pred1', 'http://obj1'));
        
        // ADD GRAPH
        var graph2 = new anzo.rdf.NamedGraph('http://graph2');
        graph2.add('http://subj3', 'http://pred3', 'http://obj3');
        
        tests.assertTrue(store.size(graph1) == 2);
        store.add(graph2);
        tests.assertTrue(store.size(graph2) == 1);
        tests.assertTrue(store.size([graph2]) == 1);
        tests.assertTrue(store.size([graph2.namedGraphUri]) == 1);
        tests.assertTrue(store.size() == 3);
        
        // ADD STATEMENTS
        var stmts = [];
        for(var i = 0; i < 5; i++)
        stmts.push(anzo.createStatement('http://s'+i, 'http://p'+i, 'http://o'+i, 'http://c1'));
        store.add(stmts);
        tests.assertTrue(store.contains(null, null, null, 'http://c1'));
        tests.assertTrue(store.size('http://c1') == 5);
        tests.assertTrue(!store.isEmpty('http://c1'));
        tests.assertTrue(store.isEmpty('http://c555'));
        
        var store2 = new anzo.rdf.QuadStore();
        store2.add('http://ss11', 'http://pp11', 'http://oo11', 'http://cc11');
        store2.add('http://ss11', 'http://pp11', 1, 'http://cc11');
        store2.add('http://ss11', 'http://pp11', true, 'http://cc11');
        
        store.add(store2);
        tests.assertTrue(store.size('http://cc11') == 3);
        
        // REMOVE QUADS
        store.remove(null, null, null, 'http://c1');
        tests.assertTrue(store.isEmpty('http://c1'));
        
        store.remove('http://subj1', 'http://pred1', 'http://obj1', ['http://graph1']);
        tests.assertFalse(store.contains('http://subj1', 'http://pred1', 'http://obj1', ['http://graph1']));
    
        // ADD QUAD WITH A GRAPH
        store.remove('http://subj2', 'http://pred1', 'http://obj1', graph1);
        tests.assertFalse(store.contains('http://subj2', 'http://pred1', 'http://obj1', graph1));
        store.add('http://subj2', 'http://pred1', 'http://obj1', graph1);
        tests.assertTrue(store.contains('http://subj2', 'http://pred1', 'http://obj1', graph1));
        store.remove('http://subj2', 'http://pred1', 'http://obj1', [graph1]);
        tests.assertFalse(store.contains('http://subj2', 'http://pred1', 'http://obj1', [graph1]));
        
        // REMOVE STATEMENTS
        var stmts = [];
        for(var i = 0; i < 5; i++)
        stmts.push(anzo.createStatement('http://s'+i, 'http://p'+i, 'http://o'+i, 'http://c1'));
        store.add(stmts);
        tests.assertTrue(store.size('http://c1') == 5);
        store.remove(stmts);
        tests.assertTrue(store.size('http://c1') == 0);
        tests.assertTrue(store.isEmpty('http://c1'));
        
        // REMOVE GRAPH
        tests.assertTrue(store.size(graph2) == 1);
        store.remove(graph2);
        tests.assertTrue(store.size(graph2) == 0);
        tests.assertTrue(store.isEmpty(graph2));
        
        // REMOVE QUAD STORE
        store.remove(store2);
        tests.assertTrue(store.size('http://cc11') == 0);
        
        // USING SERIALIZED VALUES
        
        store.add("<http://cc11>", "<http://p1>", "<http://o1>", "<http://graph1>");
        tests.assertTrue(store.find("<http://cc11>").length == 1);
        tests.assertTrue(store.find(null, "<http://p1>").length == 1);
        tests.assertTrue(store.find(null, null, "<http://o1>").length == 1);
        tests.assertTrue(store.find(null, "<http://p1>")[0].subject.toString() == 'http://cc11');
        
        store.remove("<http://cc11>", "<http://p1>", "<http://o1>", "<http://graph1>");
        tests.assertTrue(store.isEmpty());
        
        store.add("_:23412351234", "<http://p1>", "'dog'@en", "<http://graph1>");
        tests.assertTrue(store.find(null, null, anzo.createLiteral("dog", 'en')).length == 1);
        tests.assertTrue(store.find(null, null, "'dog'@en").length == 1);
        tests.assertTrue(store.find(anzo.createBNode(23412351234), null, anzo.createLiteral("dog", 'en')).length == 1);
        
        store.remove("_:23412351234", "<http://p1>", "'dog'@en", "<http://graph1>");
        tests.assertTrue(store.isEmpty());
        
        store.add("_:23412351234", "<http://p1>", "'dog'^^<http://www.w3.org/2001/XMLSchema#string>", "<http://graph1>");
        tests.assertTrue(store.find(null, null, anzo.createTypedLiteral("dog", 'http://www.w3.org/2001/XMLSchema#string')).length == 1);
        tests.assertTrue(store.find(null, null, "'dog'^^<http://www.w3.org/2001/XMLSchema#string>").length == 1);
        
        anzo.rdf.registerNamespace("xsd", "http://www.w3.org/2001/XMLSchema#");

        tests.assertTrue(store.find(anzo.createBNode(23412351234), null, anzo.createTypedLiteral("dog", 'xsd:string')).length == 1);
        
        store.remove("_:23412351234", "<http://p1>", "'dog'^^<http://www.w3.org/2001/XMLSchema#string>", "<http://graph1>");
        tests.assertTrue(store.isEmpty());
        
        store.add('a', 'a', 'a', 'a');
        var stmt = store.find('a', 'a', 'a')[0];
        tests.assertTrue(stmt.subject instanceof anzo.rdf.BNode);
        tests.assertTrue(stmt.subject.value == 'a');
        tests.assertTrue(stmt.predicate instanceof anzo.rdf.URI);
        tests.assertTrue(stmt.predicate.equals(anzo.rdf.vocabulary.RDF.type));
        tests.assertTrue(stmt.object instanceof anzo.rdf.Literal);
        tests.assertTrue(stmt.object.serialize() == '"a"');
        
        
    },
    
    
    
    testFind : function(store) {
            
            
        var NUM_STMTS         = 10;
        
        var SUBJECT_PERCENT   = 10;
        var PREDICATE_PERCENT = 20;
        var OBJECT_PERCENT    = 40;
        var GRAPH_PERCENT     = 30;
        
        // ------------------------
        
        
        
        var numS = NUM_STMTS * SUBJECT_PERCENT/100;  
        var numP = NUM_STMTS * PREDICATE_PERCENT/100;  
        var numO = NUM_STMTS * OBJECT_PERCENT/100;
        var numC = NUM_STMTS * GRAPH_PERCENT/100;
        
        var patterns = anzo.tests.utilities.addStmts(store, NUM_STMTS, numS, numP, numO, numC);
        
        var patternLow    = patterns[0];
        var patternMiddle = patterns[1];
        var patternHigh   = patterns[2];
        
        var stmts = null;
        
        stmts = store.find(patternLow.subject, patternLow.predicate, patternLow.object, [ patternLow.namedGraphUri ]);
        
        stmts = store.find(patternMiddle.subject, patternMiddle.predicate, patternMiddle.object, [ patternMiddle.namedGraphUri ]);
        
        stmts = store.find(patternHigh.subject, patternHigh.predicate, patternHigh.object, [ patternHigh.namedGraphUri ]);
        
        //log.debug("----------------------------------------------")
        //log.debug("find(?, p, o, c)")
        
        //startTime=new Date().getTime();
        stmts = store.find(null, patternLow.predicate, patternLow.object, [ patternLow.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, p, o, c) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds.  Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(null, patternMiddle.predicate, patternMiddle.object, [ patternMiddle.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, p, o, c) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds.  Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(null, patternHigh.predicate, patternHigh.object, [ patternHigh.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, p, o, c) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds.  Found num stmts: '+stmts.length);
        
        
        //log.debug("----------------------------------------------")
        //log.debug("find(s, ?, o, c)")
        
        //startTime=new Date().getTime();
        stmts = store.find(patternLow.subject, null, patternLow.object, [ patternLow.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, ?, o, c) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds.  Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternMiddle.subject, null, patternMiddle.object, [ patternMiddle.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, ?, o, c) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds.  Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternHigh.subject, null, patternHigh.object, [ patternHigh.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, ?, o, c) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds.  Found num stmts: '+stmts.length);
        
        //log.debug("----------------------------------------------")
        //log.debug("find(s, p, ?, c)")
        
        //startTime=new Date().getTime();
        stmts = store.find(patternLow.subject, patternLow.predicate, null, [ patternLow.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, p, ?, c) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternMiddle.subject, patternMiddle.predicate, null, [ patternMiddle.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, p, ?, c) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternHigh.subject, patternHigh.predicate, null, [ patternHigh.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, p, ?, c) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        
        //log.debug("----------------------------------------------")
        //log.debug("find(s, p, o, ?)")
        
        //startTime=new Date().getTime();
        stmts = store.find(patternLow.subject, patternLow.predicate, patternLow.object, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, p, o, ?) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternMiddle.subject, patternMiddle.predicate, patternMiddle.object, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, p, o, ?) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternHigh.subject, patternHigh.predicate, patternHigh.object, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, p, o, ?) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        
        //log.debug("----------------------------------------------")
        //log.debug("find(?, ?, o, c)")
        
        //startTime=new Date().getTime();
        stmts = store.find(null, null, patternLow.object, [ patternLow.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, ?, o, c) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(null, null, patternMiddle.object, [ patternMiddle.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, ?, o, c) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(null, null, patternHigh.object, [ patternHigh.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, ?, o, c) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //log.debug("----------------------------------------------")
        //log.debug("find(s, ?, ?, c)")
        
        //startTime=new Date().getTime();
        stmts = store.find(patternLow.subject, null, null, [ patternLow.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, ?, ?, c) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternMiddle.subject, null, null, [ patternMiddle.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, ?, ?, c) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternHigh.subject, null, null, [ patternHigh.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, ?, ?, c) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        
        //log.debug("----------------------------------------------")
        //log.debug("find(s, p, ?, ?)")
        
        //startTime=new Date().getTime();
        stmts = store.find(patternLow.subject, patternLow.predicate, null, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, p, ?, ?) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternMiddle.subject, patternMiddle.predicate, null, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, p, ?, ?) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternHigh.subject, patternHigh.predicate, null, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, p, ?, ?) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        
        //log.debug("----------------------------------------------")
        //log.debug("find(?, p, ?, c)")
        
        //startTime=new Date().getTime();
        stmts = store.find(null, patternLow.predicate, null, [ patternLow.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, p, ?, c) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(null, patternMiddle.predicate, null, [ patternMiddle.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, p, ?, c) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(null, patternHigh.predicate, null, [ patternHigh.namedGraphUri ]);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, p, ?, c) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //log.debug("----------------------------------------------")
        //log.debug("find(s, ?, o, ?)")
        
        //startTime=new Date().getTime();
        stmts = store.find(patternLow.subject, null, patternLow.object, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, ?, o, ?) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternMiddle.subject, null, patternMiddle.object, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, ?, o, ?) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(patternHigh.subject, null, patternHigh.object, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (s, ?, o, ?) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //log.debug("----------------------------------------------")
        //log.debug("find(?, p, o, ?)")
        
        //startTime=new Date().getTime();
        stmts = store.find(null, patternLow.predicate, patternLow.object, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, p, o, ?) on first added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(null, patternMiddle.predicate, patternMiddle.object, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, p, o, ?) on middle added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        //startTime=new Date().getTime();
        stmts = store.find(null, patternHigh.predicate, patternHigh.object, null);
        //endTime=new Date().getTime();
        //log.debug('Elapsed time calling find (?, p, o, ?) on last added statement of '+NUM_STMTS+' statements: '+((//endTime-//startTime))+' milliseconds. Found num stmts: '+stmts.length);
        
        // BNODE test
        store.add('123', 'http://foo', 23, 'http://bar');
        tests.assertTrue(store.find('123').length == 1);
        tests.assertTrue(store.find(null, null, null, 'http://bar').length > 0);
        tests.assertTrue(store.find(null, null, null, new anzo.rdf.NamedGraph('http://bar')).length > 0);
        tests.assertTrue(store.contains(null, null, null, 'http://bar'));
        tests.assertTrue(store.contains(null, null, null, new anzo.rdf.NamedGraph('http://bar')));
        
        store.add("http://sub1", "http://pred1", anzo.createBNode("123"), 'http://foo');
        tests.assertTrue(store.contains("http://sub1", "http://pred1", anzo.createBNode("123")));
       
    },
    
    
    testQuadStore : function(store) {
        
        tests.assertTrue(store.size() == 0);
        
        var graph1 = 'http://graph1';
        var graph2 = 'http://graph2';
        var graph3 = 'http://graph3';
        
        var stmt1 = anzo.createStatement('http://subj1', 'http://pred1', 'http://obj1', graph1);
        var stmt2 = anzo.createStatement('http://subj2', 'http://pred2', 'http://obj2', graph2);
        var stmt3 = anzo.createStatement('http://subj3', 'http://pred3', 'http://obj3', graph3);
        
        store.add(stmt1.subject, stmt1.predicate, stmt1.object, stmt1.namedGraphUri);
        
        store.add(stmt1);
        store.add(stmt2);	
        store.add(stmt3);
        
        tests.assertTrue(store.size() == 3);
        
        tests.assertTrue(store.size([graph1, graph2, graph3]) == 3);
        
        tests.assertTrue(store.size([graph2, graph3]) == 2);
        tests.assertTrue(store.size([graph3]) == 1);
        
        
        store.add(stmt1);	
        store.add(stmt2);	
        store.add(stmt3);
        
        
        tests.assertTrue(store.size() == 3);
        
        store.clear();
        tests.assertTrue(store.size() == 0);
        
        store.add(stmt1);	
        store.add(stmt2);	
        store.add(stmt3);
        
        tests.assertTrue(store.size() == 3);
        
        for(var i = 6; i < 20; i++) 
            store.add(anzo.createStatement('http://subj'+i, 'http://pred1'+i, 'http://obj1'+i, graph1))
        for(var i = 6; i < 20; i++) 
            store.add(anzo.createStatement('http://subj'+i, 'http://pred1'+i, 'http://obj1'+i, graph2))
        for(var i = 6; i < 20; i++) 
            store.add(anzo.createStatement('http://subj'+i, 'http://pred1'+i, 'http://obj1'+i, graph3))
        
        tests.assertTrue(store.size() == 45);
        tests.assertTrue(store.find('http://subj1').length == 1);
        
        tests.assertTrue(store.find('http://subj1', null, null, [ 'http://foo' ]).length == 0);
        
        tests.assertTrue(store.find('http://subj1', null, null, [ graph1 ]).length == 1);
        
        
        tests.assertTrue(store.find(null, 'http://pred1').length == 1);
        tests.assertTrue(store.find(null, 'http://pred1', null, [ 'http://foo' ]).length == 0);
        tests.assertTrue(store.find(null, 'http://pred1', null, [ graph1 ]).length == 1);
        
        tests.assertTrue(store.find(null, null, 'http://obj1').length == 1);
        tests.assertTrue(store.find(null, null, 'http://obj1', [ 'http://foo' ]).length == 0);
        tests.assertTrue(store.find(null, null, 'http://obj1', [ graph1 ]).length == 1);
        
        
        tests.assertTrue(store.contains(anzo.createStatement('http://subj1', 'http://pred1', 'http://obj1')));
        tests.assertTrue(store.contains('http://subj1', 'http://pred1', 'http://obj1'));
        tests.assertTrue(!store.contains('http://subj1', 'http://pred1', 'http://obj1', [graph2]));
        tests.assertTrue(!store.contains('http://subj1', 'http://pred1', 'http://obj1', [graph2, graph3]));
        tests.assertTrue(store.contains('http://subj1', 'http://pred1', 'http://obj1', [graph1]));
        tests.assertTrue(store.contains('http://subj1', 'http://pred1', 'http://obj1', [graph2, graph1]));
        tests.assertTrue(!store.contains('http://foo', 'http://foo', 'http://foo'));
        
        tests.assertTrue(store.find('http://subj1', 'http://pred1', 'http://obj1').length == 1);
        tests.assertTrue(store.find('http://subj1', 'http://pred1', 'http://obj1', [graph2]).length == 0);
        tests.assertTrue(store.find('http://subj1', 'http://pred1', 'http://obj1', [graph2, graph3]).length == 0);
        tests.assertTrue(store.find('http://subj1', 'http://pred1', 'http://obj1', [graph1]).length == 1);
        tests.assertTrue(store.find('http://foo', 'http://foo', 'http://foo').length == 0);
        
        tests.assertTrue(store.contains('http://subj1'));
        tests.assertTrue(!store.contains('http://subj1', null, null, [graph2]));
        tests.assertTrue(!store.contains('http://subj1', null, null, [graph2, graph3]));
        tests.assertTrue(store.contains('http://subj1', null, null, [graph1]));
        tests.assertTrue(store.contains('http://subj1', null, null, [graph2, graph1]));
        tests.assertTrue(!store.contains('http://foo'));
        
        tests.assertTrue(store.find('http://subj1').length == 1);
        tests.assertTrue(store.find('http://subj1', null, null, [graph2]).length == 0);
        tests.assertTrue(store.find('http://subj1', null, null, [graph2, graph3]).length == 0);
        tests.assertTrue(store.find('http://subj1', null, null, [graph1]).length == 1);
        tests.assertTrue(store.find('http://foo').length == 0);
        
        tests.assertTrue(store.contains('http://subj1', 'http://pred1'));
        tests.assertTrue(!store.contains('http://subj1', 'http://pred1', null, [graph2]));
        tests.assertTrue(!store.contains('http://subj1', 'http://pred1', null, [graph2, graph3]));
        tests.assertTrue(store.contains('http://subj1', 'http://pred1', null, [graph1]));
        tests.assertTrue(store.contains('http://subj1', 'http://pred1', null, [graph2, graph1]));
        
        tests.assertTrue(!store.contains('http://subj1', 'http://foo'));
        
        
        // -------------------------
        
        
        tests.assertTrue(store.find('http://subj1', 'http://pred1').length == 1);
        tests.assertTrue(store.find('http://subj1', 'http://pred1', null, [graph2]).length == 0);
        tests.assertTrue(store.find('http://subj1', 'http://pred1', null, [graph2, graph3]).length == 0);
        tests.assertTrue(store.find('http://subj1', 'http://pred1', null, [graph1]).length == 1);
        tests.assertTrue(store.find('http://subj1', 'http://foo').length == 0);
        
        
        
        
        tests.assertTrue(store.contains(null, 'http://pred1'));
        tests.assertTrue(!store.contains(null, 'http://pred1', null, [graph2]));
        tests.assertTrue(!store.contains(null, 'http://pred1', null, [graph2, graph3]));
        tests.assertTrue(store.contains(null, 'http://pred1', null, [graph1]));
        tests.assertTrue(store.contains(null, 'http://pred1', null, [graph2, graph1]));
        tests.assertTrue(!store.contains(null, 'http://foo'));
        
        
        tests.assertTrue(store.find(null, 'http://pred1').length == 1);
        tests.assertTrue(store.find(null, 'http://pred1', null, [graph2]).length == 0);
        tests.assertTrue(store.find(null, 'http://pred1', null, [graph2, graph3]).length == 0);
        tests.assertTrue(store.find(null, 'http://pred1', null, [graph1]).length == 1);
        tests.assertTrue(store.find(null, 'http://pred1', null, [graph2, graph1]).length == 1);
        tests.assertTrue(store.find(null, 'http://foo').length == 0);
        
        
        tests.assertTrue(store.contains(null, null,'http://obj1'));
        tests.assertTrue(!store.contains(null, null,'http://obj1', [graph2]));
        tests.assertTrue(!store.contains(null, null,'http://obj1', [graph2, graph3]));
        tests.assertTrue(store.contains(null, null,'http://obj1', [graph1]));
        tests.assertTrue(store.contains(null, null,'http://obj1', [graph2, graph1]));
        tests.assertTrue(!store.contains(null, null,'http://foo'));
        
        
        tests.assertTrue(store.find(null, null,'http://obj1').length == 1);
        tests.assertTrue(store.find(null, null,'http://obj1', [graph2]).length == 0);
        tests.assertTrue(store.find(null, null,'http://obj1', [graph2, graph3]).length == 0);
        tests.assertTrue(store.find(null, null,'http://obj1', [graph1]).length == 1);
        tests.assertTrue(store.find(null, null,'http://foo').length == 0);
        
        
        tests.assertTrue(store.contains('http://subj1', null,'http://obj1'));
        tests.assertTrue(!store.contains('http://subj1', null,'http://obj1', [graph2]));
        tests.assertTrue(!store.contains('http://subj1', null,'http://obj1', [graph2, graph3]));
        tests.assertTrue(store.contains('http://subj1', null,'http://obj1', [graph1]));
        tests.assertTrue(store.contains('http://subj1', null,'http://obj1', [graph2, graph1]));
        tests.assertTrue(!store.contains('http://subj1', null,'http://foo'));
        
        tests.assertTrue(store.find('http://subj1', null,'http://obj1').length == 1);
        tests.assertTrue(store.find('http://subj1', null,'http://obj1', [graph2]).length == 0);
        tests.assertTrue(store.find('http://subj1', null,'http://obj1', [graph2, graph3]).length == 0);
        tests.assertTrue(store.find('http://subj1', null,'http://obj1', [graph1]).length == 1);
        tests.assertTrue(store.find('http://subj1', null,'http://foo').length == 0);
        

        
        store.remove(null, null, null, [graph1, graph2, graph3]);
        tests.assertTrue(store.isEmpty());
        
        for(var i = 1; i <= 20; i++) 
            store.add(anzo.createStatement('http://subj'+i, 'http://pred1'+i, 'http://obj1'+i, graph1))
        for(var i = 1; i <= 20; i++) 
            store.add(anzo.createStatement('http://subj'+i, 'http://pred1'+i, 'http://obj1'+i, graph2))
        for(var i = 1; i <= 20; i++) 
            store.add(anzo.createStatement('http://subj'+i, 'http://pred1'+i, 'http://obj1'+i, graph3))
        
        tests.assertTrue(store.size() == 60);
        
        tests.assertTrue(store.find().length == 60);
        tests.assertTrue(store.find(null, null, null, [graph1]).length == 20);
        tests.assertTrue(store.find(null, null, null, [graph2]).length == 20);
        tests.assertTrue(store.find(null, null, null, [graph3]).length == 20);
        tests.assertTrue(store.find(null, null, null, [graph1, graph2]).length == 40);

        store.remove(null, null, null, [graph1, graph2]);
        tests.assertTrue(store.size([graph1, graph2]) == 0);
        tests.assertTrue(store.isEmpty([graph1, graph2]));
        tests.assertTrue(store.size([graph3]) == 20);
        
        store.remove(null, null, null, [graph3]);
        tests.assertTrue(store.size() == 0);
        
        
        store.add('http://rouben', "http://xmlns.com/foaf/0.1/knows", 'http://sean', 'http://g1');
        store.add('http://rouben', "http://xmlns.com/foaf/0.1/knows", 'http://ben', 'http://g1');
        tests.assertTrue(store.find('http://rouben', "http://xmlns.com/foaf/0.1/knows").length == 2);
        tests.assertTrue(store.find('http://rouben', "http://xmlns.com/foaf/0.1/knows", null, ['http://g1']).length == 2);
        
        store.clear();
        
        store.add('http://sean', "http://xmlns.com/foaf/0.1/knows", 'http://rouben', 'http://g1');
        store.add('http://ben', "http://xmlns.com/foaf/0.1/knows", 'http://rouben', 'http://g1');
        tests.assertTrue(store.find(null, "http://xmlns.com/foaf/0.1/knows", 'http://rouben').length == 2);
        tests.assertTrue(store.find(null, "http://xmlns.com/foaf/0.1/knows", 'http://rouben', ['http://g1']).length == 2);
        
        
        // --------------------------------------
        
        store.add(stmt1);	
        
        store.clear();
        
        store.add(stmt1);
        
        for(var i = 6; i < 20; i++) 
            store.add(anzo.createStatement('http://subj'+i, 'http://pred1'+i, 'http://obj1'+i, graph1))
        for(var i = 6; i < 20; i++) 
            store.add(anzo.createStatement('http://subj'+i, 'http://pred1'+i, 'http://obj1'+i, graph2))
        for(var i = 6; i < 20; i++) 
            store.add(anzo.createStatement('http://subj'+i, 'http://pred1'+i, 'http://obj1'+i, graph3))
        
        store.remove(null, null, null, [graph1, graph2, graph3]);
        
    },
    
    
    test_NamedGraph : function(store) {
            
        var subj1 = anzo.createURI('http://res1');
        var pred1 = anzo.createURI('http://pred1');
        var obj1  = anzo.createURI('http://obj1');
        
        var subj2 = anzo.createURI('http://res2');
        var pred2 = anzo.createURI('http://pred2');
        var obj2  = anzo.createURI('http://obj2');
        
        store.clear();
        tests.assertTrue(store.size() == 0);
        
        store.add(subj1, pred1, obj1);
        tests.assertTrue(store.size() == 1);
        tests.assertTrue(store.find(subj1, pred1, obj1).length == 1);
        tests.assertTrue(store.find(subj1, null, null).length == 1);
        tests.assertTrue(store.find(null, pred1, null).length == 1);
        tests.assertTrue(store.find(null, null, obj1).length == 1);
        tests.assertTrue(store.find(null, null, null).length == 1);
        tests.assertTrue(store.find(subj1, null, obj1).length == 1);
        tests.assertTrue(store.find(null, pred1, obj1).length == 1);
      
        tests.assertTrue(store.find(subj1, pred1, null).length == 1);
        
        store.add(subj2, pred2, obj2);
        
        tests.assertTrue(store.size() == 2);
        
        store.add(subj2, pred2, obj2);
        tests.assertTrue(store.size() == 2);
        store.remove(subj2, pred2, obj2);
        tests.assertTrue(store.size() == 1);
        
        store.add(subj2, pred2, obj2);
        tests.assertTrue(store.size() == 2);
        tests.assertTrue(store.find(subj2, pred2, obj2).length == 1);
        tests.assertTrue(store.find(subj2, null, null).length == 1);
        tests.assertTrue(store.find(null, pred2, null).length == 1);
        tests.assertTrue(store.find(null, null, obj2).length == 1);
        tests.assertTrue(store.find(null, null, null).length == 2);
        tests.assertTrue(store.find(subj2, null, obj2).length == 1);
        tests.assertTrue(store.find(null, pred2, obj2).length == 1);
        
        store.clear();
        tests.assertTrue(store.size() == 0);
        
        // TEST USING VALUES RATHER THAN NODES
        
        store.add('http://subj', 'http://pred', 3);
        tests.assertTrue(store.find('http://subj').length == 1);
        tests.assertTrue(store.find(null, 'http://pred').length == 1);
        tests.assertTrue(store.find(null, null, 3).length == 1);
        
        tests.assertTrue(store.find(anzo.rdf.getValue('http://subj')).length == 1);
        tests.assertTrue(store.find(null, anzo.rdf.getValue('http://pred')).length == 1);
        tests.assertTrue(store.find(null, null, anzo.rdf.getValue(3)).length == 1);
        store.remove('http://subj', 'http://pred', 3);
        tests.assertTrue(store.size() == 0);
        
        var stmts = [];
        for(var i = 0; i < 10; i++) {
            var stmt = anzo.createStatement('http://subj'+i, 'http://pred'+i, 'http://obj'+i);
        stmts.push(stmt);
        store.add(stmt.subject, stmt.predicate, stmt.object);
        }
        tests.assertTrue(store.find().length == 10);
        tests.assertTrue(store.find(stmts[5].subject).length == 1);
        tests.assertTrue(store.find(null, stmts[5].predicate).length == 1);
        tests.assertTrue(store.find(null, null, stmts[5].object).length == 1);
        store.remove();
        tests.assertTrue(store.find().length == 0);
        
        
        var stmts = [];
        for(var i = 0; i < 10; i++) {
            var stmt = anzo.createStatement('http://subj1', 'http://pred'+i, 'http://obj'+i);
            stmts.push(stmt);
            store.add(stmt.subject, stmt.predicate, stmt.object);
        }
        tests.assertTrue(store.find().length == 10);
        tests.assertTrue(store.find(stmts[0].subject).length == 10);
            
        tests.assertTrue(store.find(null, stmts[5].predicate).length == 1);
        tests.assertTrue(store.find(null, null, stmts[5].object).length == 1);
        
        store.clear();
        tests.assertTrue(store.find().length == 0);
        tests.assertTrue(store.size() == 0);
        tests.assertTrue(store.isEmpty());
        
        store.add(stmts);
        
        tests.assertTrue(store.find().length == 10);			
        tests.assertTrue(store.find(stmts[0].subject).length == 10);
        tests.assertTrue(store.find(null, stmts[5].predicate).length == 1);
        tests.assertTrue(store.find(null, null, stmts[5].object).length == 1);
        
        store.clear();
        tests.assertTrue(store.find().length == 0);
        tests.assertTrue(store.size() == 0);
        tests.assertTrue(store.isEmpty());
        
        var stmts = [];
        for(var i = 0; i < 10; i++) {
            var stmt = anzo.createStatement('http://subj'+i, 'http://pred1', 'http://obj'+i);
            stmts.push(stmt);
            store.add(stmt.subject, stmt.predicate, stmt.object);
        }
        tests.assertTrue(store.find().length == 10);			
        tests.assertTrue(store.find(null, stmts[0].predicate).length == 10);
        tests.assertTrue(store.find(stmts[5].subject).length == 1);
        tests.assertTrue(store.find(null, null, stmts[5].object).length == 1);
        
        store.clear();
        tests.assertTrue(store.find().length == 0);
        tests.assertTrue(store.size() == 0);
        tests.assertTrue(store.isEmpty());
        
        store.add(stmts);
        
        
        tests.assertTrue(store.find().length == 10);			
        tests.assertTrue(store.find(null, stmts[0].predicate).length == 10);
        tests.assertTrue(store.find(stmts[5].subject).length == 1);
        tests.assertTrue(store.find(null, null, stmts[5].object).length == 1);
        
        store.clear();
        tests.assertTrue(store.find().length == 0);
        tests.assertTrue(store.size() == 0);
        tests.assertTrue(store.isEmpty());
        
        
        var stmts = [];
        for(var i = 0; i < 10; i++) {
            var stmt = anzo.createStatement('http://subj'+i, 'http://pred'+i, 'http://obj1');
            stmts.push(stmt);
            store.add(stmt.subject, stmt.predicate, stmt.object);
        }
        tests.assertTrue(store.find().length == 10);	
        tests.assertTrue(store.find(null, null, stmts[0].object).length == 10);
        tests.assertTrue(store.find(stmts[5].subject).length == 1);
        tests.assertTrue(store.find(null, stmts[5].predicate).length == 1);
        
        store.clear();
        tests.assertTrue(store.find().length == 0);
        tests.assertTrue(store.size() == 0);
        tests.assertTrue(store.isEmpty());
        
        store.add(stmts);
        
        tests.assertTrue(store.find().length == 10);			
        tests.assertTrue(store.find(null, null, stmts[0].object).length == 10);
        tests.assertTrue(store.find(stmts[5].subject).length == 1);
        tests.assertTrue(store.find(null, stmts[5].predicate).length == 1);
        
        store.clear();
        tests.assertTrue(store.find().length == 0);
        tests.assertTrue(store.size() == 0);
        tests.assertTrue(store.isEmpty());
        
        
        var stmts = [];
        for(var i = 0; i < 10; i++) {
            var stmt = anzo.createStatement('http://subj1', 'http://pred1', 'http://obj1');
            stmts.push(stmt);
            store.add(stmt.subject, stmt.predicate, stmt.object);
        }
        
        tests.assertTrue(store.find().length == 1);		
        tests.assertTrue(store.find(stmts[5].subject).length == 1);		
        tests.assertTrue(store.find(stmts[5].subject, stmts[4].predicate).length == 1);	
        tests.assertTrue(store.find(stmts[5].subject, stmts[4].predicate, stmts[1].object).length == 1);	
        store.clear();
        
        // test namespaces
        
        anzo.rdf.registerNamespace('foo', 'http://www.w3.org/1999/02/22-rdf-syntax-ns#');
        store.add('foo:bar', 'foo:zoo', 123);
        tests.assertTrue(store.contains('foo:bar', 'foo:zoo', 123));
        tests.assertTrue(store.find('foo:bar').length == 1);
        tests.assertTrue(store.find('http://www.w3.org/1999/02/22-rdf-syntax-ns#bar').length == 1);
        tests.assertTrue(store.find('http://www.w3.org/1999/02/22-rdf-syntax-ns#bar').length == 1);
        
        
        store.remove();
        tests.assertTrue(store.size() == 0);
        
        store.add("<http://s1>", "<http://p1>", "<http://o1>");
        tests.assertTrue(store.find("<http://s1>").length == 1);
        tests.assertTrue(store.find(null, "<http://p1>").length == 1);
        tests.assertTrue(store.find(null, null, "<http://o1>").length == 1);
        tests.assertTrue(store.find(null, "<http://p1>")[0].subject.toString() == 'http://s1');
        
        store.remove("<http://s1>", "<http://p1>", "<http://o1>");
        tests.assertTrue(store.isEmpty());
        
        store.add("_:23412351234", "<http://p1>", "'dog'@en");
        tests.assertTrue(store.find(null, null, anzo.createLiteral("dog", 'en')).length == 1);
        tests.assertTrue(store.find(null, null, "'dog'@en").length == 1);
        tests.assertTrue(store.find(anzo.createBNode(23412351234), null, anzo.createLiteral("dog", 'en')).length == 1);
        
        store.remove("_:23412351234", "<http://p1>", "'dog'@en");
        tests.assertTrue(store.isEmpty());
        
        store.add("_:23412351234", "<http://p1>", "'dog'^^<http://www.w3.org/2001/XMLSchema#string>");
        tests.assertTrue(store.find(null, null, anzo.createTypedLiteral("dog", 'http://www.w3.org/2001/XMLSchema#string')).length == 1);
        tests.assertTrue(store.find(null, null, "'dog'^^<http://www.w3.org/2001/XMLSchema#string>").length == 1);
        
        anzo.rdf.registerNamespace("xsd", "http://www.w3.org/2001/XMLSchema#");

        tests.assertTrue(store.find(anzo.createBNode(23412351234), null, anzo.createTypedLiteral("dog", 'xsd:string')).length == 1);
        
        store.remove("_:23412351234", "<http://p1>", "'dog'^^<http://www.w3.org/2001/XMLSchema#string>");
        tests.assertTrue(store.isEmpty());
        
    },
    
    test_NamedGraphEvents : function(graph) {
            
        var addStmts = [];
        dojo.connect(graph, 'statementsAdded', function(statements) {
            addStmts = statements;
        });    
        
        var deleteStmts = [];
        dojo.connect(graph, 'statementsRemoved', function(statements) {
            deleteStmts = statements;
        });
        
        var stmts = [];
        for(var i = 0; i < 10; i++) {
            var stmt = anzo.createStatement('http://subj1', 'http://pred'+i, 'http://obj'+i);
            stmts.push(stmt);
            graph.add(stmt.subject, stmt.predicate, stmt.object);
        }
        tests.assertTrue(addStmts.length == 1);
        
        tests.assertTrue(graph.find().length == 10);			
        tests.assertTrue(graph.find(stmts[0].subject).length == 10);
        tests.assertTrue(graph.find(null, stmts[5].predicate).length == 1);
        tests.assertTrue(graph.find(null, null, stmts[5].object).length == 1);
        
        graph.clear();
        
        tests.assertTrue(graph.find().length == 0);
        tests.assertTrue(graph.size() == 0);
        tests.assertTrue(graph.isEmpty());
        
        graph.add(stmts);
        tests.assertTrue(addStmts.length == 10);
        
        tests.assertTrue(graph.find().length == 10);			
        tests.assertTrue(graph.find(stmts[0].subject).length == 10);
        tests.assertTrue(graph.find(null, stmts[5].predicate).length == 1);
        tests.assertTrue(graph.find(null, null, stmts[5].object).length == 1);
        
        graph.clear();
        tests.assertTrue(graph.find().length == 0);
        tests.assertTrue(graph.size() == 0);
        tests.assertTrue(graph.isEmpty());
        
        tests.assertTrue(deleteStmts.length == 10);
    },

    assertOntologyExampleGraph : function assertOntologyExampleGraph(graph) {
        // summary: Test utility method which asserts that the graph contains exactly the graph represented by
        //  the ontology.nt N-Triples example file.
    
        tests.assertTrue(graph.size() == 20);
        var stmt = graph.find(null, "http://www.w3.org/2002/07/owl#versionInfo", anzo.createLiteral("0.1"));
        tests.assertTrue(stmt.length == 1);
        tests.assertTrue(stmt[0].subject instanceof anzo.rdf.BNode);
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#CViT", "http://www.w3.org/2002/07/owl#imports", "http://xmlns.com/foaf/0.1/"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#CViT", "http://www.w3.org/2002/07/owl#imports", "http://purl.org/dc/elements/1.1/"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#CViT", "http://www.w3.org/2000/01/rdf-schema#comment", anzo.createLiteral("CViT Ontology")));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#CViT", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://www.w3.org/2002/07/owl#Ontology"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#Entry", "http://purl.org/dc/elements/1.1/title", anzo.createTypedLiteral("Entry", "http://www.w3.org/2001/XMLSchema#string")));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#Entry", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://www.w3.org/2002/07/owl#Class"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#Organization", "http://purl.org/dc/elements/1.1/title", anzo.createTypedLiteral("Organization", "http://www.w3.org/2001/XMLSchema#string")));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#Organization", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://www.w3.org/2002/07/owl#Class"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#File", "http://purl.org/dc/elements/1.1/title", anzo.createTypedLiteral("File", "http://www.w3.org/2001/XMLSchema#string")));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#File", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://www.w3.org/2002/07/owl#Class"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#FundingSource", "http://www.w3.org/2000/01/rdf-schema#subClassOf", "urn:lsid:telar.cambridgesemantics.com:cvit#Organization"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#FundingSource", "http://purl.org/dc/elements/1.1/title", anzo.createTypedLiteral("Funding Source", "http://www.w3.org/2001/XMLSchema#string")));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#FundingSource", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://www.w3.org/2002/07/owl#Class"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#Person", "http://purl.org/dc/elements/1.1/title", anzo.createTypedLiteral("Person", "http://www.w3.org/2001/XMLSchema#string")));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#Person", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://www.w3.org/2002/07/owl#Class"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#ExternalLink", "http://purl.org/dc/elements/1.1/title", anzo.createTypedLiteral("External Link", "http://www.w3.org/2001/XMLSchema#string")));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#ExternalLink", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://www.w3.org/2002/07/owl#Class"));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#TaskList", "http://purl.org/dc/elements/1.1/title", anzo.createTypedLiteral("Task List", "http://www.w3.org/2001/XMLSchema#string")));
        tests.assertTrue(graph.contains("urn:lsid:telar.cambridgesemantics.com:cvit#TaskList", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://www.w3.org/2002/07/owl#Class"));
    },
    
    assertUserAndRolesExampleGraph : function assertUserAndRolesExampleGraph(graph) {
        // summary: Test utility method which asserts that the graph contains exactly the graph represented by
        //   the usersAndRoles.nt N-Triples example file.
    
        tests.assertTrue(graph.size() == 41);
        tests.assertTrue(graph.contains("http://openanzo.org/users/sysadmin", "http://openanzo.org/ontologies/2008/07/Anzo#inRole", "http://openanzo.org/Role/sysAdmin"));
        tests.assertTrue(graph.contains("http://openanzo.org/users/sysadmin", "http://openanzo.org/ontologies/2008/07/Anzo#defaultRole", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/users/sysadmin", "http://openanzo.org/ontologies/2008/07/Anzo#password", anzo.createLiteral("123")));
        tests.assertTrue(graph.contains("http://openanzo.org/users/sysadmin", "http://openanzo.org/ontologies/2008/07/Anzo#userId", anzo.createLiteral("sysadmin")));
        tests.assertTrue(graph.contains("http://openanzo.org/users/sysadmin", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#User"));
        tests.assertTrue(graph.contains("http://openanzo.org/Role/webuser", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#Role"));
        tests.assertTrue(graph.contains("http://openanzo.org/Role/sysAdmin", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#Role"));
        tests.assertTrue(graph.contains("http://openanzo.org/Role/default", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#Role"));
        tests.assertTrue(graph.contains("http://openanzo.org/Role/webauthors", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#Role"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/1", "http://openanzo.org/ontologies/2008/07/Anzo#changeNamedGraphACL", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/1", "http://openanzo.org/ontologies/2008/07/Anzo#removeNamedGraph", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/1", "http://openanzo.org/ontologies/2008/07/Anzo#insertNamedGraph", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/1", "http://openanzo.org/ontologies/2008/07/Anzo#remove", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/1", "http://openanzo.org/ontologies/2008/07/Anzo#add", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/1", "http://openanzo.org/ontologies/2008/07/Anzo#read", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/1", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#ACL"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/SystemAcl", "http://openanzo.org/ontologies/2008/07/Anzo#removeNamedGraph", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/SystemAcl", "http://openanzo.org/ontologies/2008/07/Anzo#insertNamedGraph", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/SystemAcl", "http://openanzo.org/ontologies/2008/07/Anzo#changeNamedGraphACL", "http://openanzo.org/Role/sysAdmin"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/SystemAcl", "http://openanzo.org/ontologies/2008/07/Anzo#removeNamedGraph", "http://openanzo.org/Role/sysAdmin"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/SystemAcl", "http://openanzo.org/ontologies/2008/07/Anzo#insertNamedGraph", "http://openanzo.org/Role/sysAdmin"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/SystemAcl", "http://openanzo.org/ontologies/2008/07/Anzo#remove", "http://openanzo.org/Role/sysAdmin"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/SystemAcl", "http://openanzo.org/ontologies/2008/07/Anzo#add", "http://openanzo.org/Role/sysAdmin"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/SystemAcl", "http://openanzo.org/ontologies/2008/07/Anzo#read", "http://openanzo.org/Role/sysAdmin"));
        tests.assertTrue(graph.contains("http://openanzo.org/ACL/SystemAcl", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#ACL"));
        tests.assertTrue(graph.contains("http://openanzo.org/users/webuser", "http://openanzo.org/ontologies/2008/07/Anzo#password", anzo.createLiteral("webuser")));
        tests.assertTrue(graph.contains("http://openanzo.org/users/webuser", "http://openanzo.org/ontologies/2008/07/Anzo#userId", anzo.createLiteral("webuser")));
        tests.assertTrue(graph.contains("http://openanzo.org/users/webuser", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#User"));
        tests.assertTrue(graph.contains("http://openanzo.org/users/default", "http://openanzo.org/ontologies/2008/07/Anzo#defaultRole", "http://openanzo.org/Role/default"));
        tests.assertTrue(graph.contains("http://openanzo.org/users/default", "http://openanzo.org/ontologies/2008/07/Anzo#password", anzo.createLiteral("123")));
        tests.assertTrue(graph.contains("http://openanzo.org/users/default", "http://openanzo.org/ontologies/2008/07/Anzo#userId", anzo.createLiteral("default")));
        tests.assertTrue(graph.contains("http://openanzo.org/users/default", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#User"));
        tests.assertTrue(graph.contains("http://openanzo.org/namedGraphs/defaultNamedGraph", "http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph", "http://openanzo.org/metadataGraphs/defaultMetadataGraph"));
        tests.assertTrue(graph.contains("http://openanzo.org/namedGraphs/defaultNamedGraph", "http://openanzo.org/ontologies/2008/07/Anzo#usesAcl", "http://openanzo.org/ACL/1"));
        tests.assertTrue(graph.contains("http://openanzo.org/namedGraphs/defaultNamedGraph", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"));
        tests.assertTrue(graph.contains("http://openanzo.org/namedGraphs/defaultSystemGraph", "http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph", "http://openanzo.org/metadataGraphs/defaultSystemMetadataGraph"));
        tests.assertTrue(graph.contains("http://openanzo.org/namedGraphs/defaultSystemGraph", "http://openanzo.org/ontologies/2008/07/Anzo#usesAcl", "http://openanzo.org/ACL/SystemAcl"));
        tests.assertTrue(graph.contains("http://openanzo.org/namedGraphs/defaultSystemGraph", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"));
        tests.assertTrue(graph.contains("http://openanzo.org/users/webauthor1", "http://openanzo.org/ontologies/2008/07/Anzo#password", anzo.createLiteral("webauthor1")));
        tests.assertTrue(graph.contains("http://openanzo.org/users/webauthor1", "http://openanzo.org/ontologies/2008/07/Anzo#userId", anzo.createLiteral("webauthor1")));
        tests.assertTrue(graph.contains("http://openanzo.org/users/webauthor1", "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "http://openanzo.org/ontologies/2008/07/Anzo#User"));
    },
    
    assertW3CNTriplesExampleGraph : function assertW3CNTriplesExampleGraph(graph) {
        // summary: Test utility method which asserts that the graph contains exactly the graph represented by
        //   the w3cTest.nt N-Triples example file. 

        // Find the _:anon BNode.
        var stmts = graph.find("http://example.org/resource15", "http://example.org/property", null);
        tests.assertTrue(stmts.length == 1);
        var anonNode = stmts[0].object;
        tests.assertTrue(anonNode instanceof anzo.rdf.BNode);

        tests.assertTrue(graph.size() == 30);
        tests.assertTrue(graph.contains("http://example.org/resource1", "http://example.org/property", "http://example.org/resource2"));
        tests.assertTrue(graph.contains(anonNode, "http://example.org/property", "http://example.org/resource2"));
        tests.assertTrue(graph.contains("http://example.org/resource2", "http://example.org/property", anonNode));
        tests.assertTrue(graph.contains("http://example.org/resource3", "http://example.org/property", "http://example.org/resource2"));
        tests.assertTrue(graph.contains("http://example.org/resource4", "http://example.org/property", "http://example.org/resource2"));
        tests.assertTrue(graph.contains("http://example.org/resource5", "http://example.org/property", "http://example.org/resource2"));
        tests.assertTrue(graph.contains("http://example.org/resource6", "http://example.org/property", "http://example.org/resource2"));
        tests.assertTrue(graph.contains("http://example.org/resource7", "http://example.org/property", anzo.createLiteral("simple literal")));
        tests.assertTrue(graph.contains("http://example.org/resource8", "http://example.org/property", anzo.createLiteral("backslash:\\")));
        tests.assertTrue(graph.contains("http://example.org/resource9", "http://example.org/property", anzo.createLiteral("dquote:\"")));
        tests.assertTrue(graph.contains("http://example.org/resource10", "http://example.org/property", anzo.createLiteral("newline:\n")));
        tests.assertTrue(graph.contains("http://example.org/resource11", "http://example.org/property", anzo.createLiteral("return\r")));
        tests.assertTrue(graph.contains("http://example.org/resource12", "http://example.org/property", anzo.createLiteral("tab:\t")));
        tests.assertTrue(graph.contains("http://example.org/resource13", "http://example.org/property", "http://example.org/resource2"));
        tests.assertTrue(graph.contains("http://example.org/resource14", "http://example.org/property", anzo.createLiteral("x")));
        tests.assertTrue(graph.contains("http://example.org/resource15", "http://example.org/property", anonNode));
        tests.assertTrue(graph.contains("http://example.org/resource16", "http://example.org/property", anzo.createLiteral("\u00E9")));
        tests.assertTrue(graph.contains("http://example.org/resource17", "http://example.org/property", anzo.createLiteral("\u20AC")));
        tests.assertTrue(graph.contains("http://example.org/resource21", "http://example.org/property", anzo.createTypedLiteral("", "http://www.w3.org/2000/01/rdf-schema#XMLLiteral")));
        tests.assertTrue(graph.contains("http://example.org/resource22", "http://example.org/property", anzo.createTypedLiteral(" ", "http://www.w3.org/2000/01/rdf-schema#XMLLiteral")));
        tests.assertTrue(graph.contains("http://example.org/resource23", "http://example.org/property", anzo.createTypedLiteral("x", "http://www.w3.org/2000/01/rdf-schema#XMLLiteral")));
        tests.assertTrue(graph.contains("http://example.org/resource23", "http://example.org/property", anzo.createTypedLiteral("\"", "http://www.w3.org/2000/01/rdf-schema#XMLLiteral")));
        tests.assertTrue(graph.contains("http://example.org/resource24", "http://example.org/property", anzo.createTypedLiteral("<a></a>", "http://www.w3.org/2000/01/rdf-schema#XMLLiteral")));
        tests.assertTrue(graph.contains("http://example.org/resource25", "http://example.org/property", anzo.createTypedLiteral("a <b></b>", "http://www.w3.org/2000/01/rdf-schema#XMLLiteral")));
        tests.assertTrue(graph.contains("http://example.org/resource26", "http://example.org/property", anzo.createTypedLiteral("a <b></b> c", "http://www.w3.org/2000/01/rdf-schema#XMLLiteral")));
        tests.assertTrue(graph.contains("http://example.org/resource26", "http://example.org/property", anzo.createTypedLiteral("a\n<b></b>\nc", "http://www.w3.org/2000/01/rdf-schema#XMLLiteral")));
        tests.assertTrue(graph.contains("http://example.org/resource27", "http://example.org/property", anzo.createTypedLiteral("chat", "http://www.w3.org/2000/01/rdf-schema#XMLLiteral")));
        tests.assertTrue(graph.contains("http://example.org/resource30", "http://example.org/property", anzo.createLiteral("chat", "fr")));
        tests.assertTrue(graph.contains("http://example.org/resource31", "http://example.org/property", anzo.createLiteral("chat", "en")));
        tests.assertTrue(graph.contains("http://example.org/resource32", "http://example.org/property", anzo.createTypedLiteral("abc", "http://example.org/datatype1")));
    },
    
    test_LiteralsInFindAddRemoveAndContains : function test_LiteralsInFindAddRemoveAndContains(graph) {
        // summary: Utility function for testing the interaction between add/remove/find/contains for statements with literal objects.
        // description: The method will add the statement and invoke find and contains in all of their forms. For example:
        //   | find(null, null, null);
        //   | find(subject, null, null);
        //   | find(subject predicate, null);
        //   | ...
        //   Then the method will remove the statement (using all possible ways to call 'remove' and check that
        //   find and contains, in all of their possible invocations, won't find it.
        //   In particular, this test method is trying to verify that, when creating a statement via 'add', passing the
        //   same exact arguments to remove/find/contains will yield expected results.
        //   For example:
        //   | add("http://example.org/subj1", "http://example.org/pred1", "my object");
        //   | contains("http://example.org/subj1", "http://example.org/pred1", "my object"); // should be true
        //   | find("http://example.org/subj1", "http://example.org/pred1", "my object"); // should find the statement
        //   | remove("http://example.org/subj1", "http://example.org/pred1", "my object"); // should remove the statement
        //   It sounds simple but if the literal is given a datatype or language by the framework during 'add'
        //   and the same isn't done for the other methods, then the results can end up being inconsistent.
        //   This test method tries to ensure that consistency. When you consider the automatic conversion that is done
        //   on primitive JavaScript types, there are possibilities for errors there. 

        function test_LiteralsInFindAddRemoveAndContainsHelper(graph, subject, predicate, object, language, datatype) {
            log.debug("Testing behavior of literal ('" + object + "', datatype: '" + datatype + "', language: '" + language + "') when passed to add/remove/find/contains methods.");
            log.debug("Testing literals on graph '" + graph.namedGraphUri + "' with subject '" + subject + "' and predicate '" + predicate + "'.");
    
            var rawObject = object;
            if (language && datatype) {
                throw new Error("Literal cannot be both typed and have a language tag.");    
            } else if (language) {
                object = anzo.createLiteral(object, language);
            } else if (datatype) {
                object = anzo.createTypedLiteral(object, datatype);
            }
            
            if (!(anzo.rdf.getValue(object) instanceof anzo.rdf.Literal)) {
                throw new Error("object argument ('" + object + "') must be interpreted as a literal by anzo.rdf.getValue. So no URIs for the object.");
            }
            
            graph.add(subject, predicate, object);
            for (var findMask = 0; findMask < 8; findMask++) {
                var s = findMask & 1 ? subject : null; 
                var p = findMask & 2 ? predicate : null; 
                var o = findMask & 4 ? object : null; 
                log.debug("Checking graph.contains(" + s + ", " + p + ", " + o + ") must be true.");
                tests.assertTrue(graph.contains(s, p, o));
                log.debug("Checking graph.find(" + s + ", " + p + ", " + o + ") finds exactly one statement.");
                var stmts = graph.find(s, p, o);
                tests.assertTrue(stmts.length == 1);
                //log.debug("Checking find result subject.");
                tests.assertTrue(stmts[0].subject.value === subject);
                //log.debug("Checking find result predicate.");
                tests.assertTrue(stmts[0].predicate.value === predicate);
                //log.debug("Checking find result object is a anzo.rdf.Literal.");
                tests.assertTrue(stmts[0].object instanceof anzo.rdf.Literal);
                //log.debug("Checking find result object is a anzo.rdf.Value.");
                tests.assertTrue(stmts[0].object instanceof anzo.rdf.Value);
                //log.debug("Checking find result object value. - stmts[0].object.value:" + stmts[0].object.value + " rawObject:" + rawObject);
                tests.assertTrue(dojo.isString(stmts[0].object.value)); // Value should always be a lexical string representation of the literal
                //log.debug("Checking find result object datatype. - stmts[0].object.datatype:" + stmts[0].object.datatype + " datatype:" + datatype);
                if (datatype) {
                    tests.assertTrue(stmts[0].object.datatype.equals(anzo.createURI(datatype)));
                } else {
                    // We don't mind the code adding a datatype as long as we found the statement with the same arguments as we created it.
                    // Except for one thing: strings should be left as plain literals rather than adding an xsd:string type.
                    // See http://www.openanzo.org/projects/openanzo/ticket/213
                    tests.assertTrue(!dojo.isString(object) || stmts[0].object.datatype == null);
                }
                //log.debug("Checking find result object language - stmts[0].object.language:" + stmts[0].object.language + " language:" + language);
                tests.assertTrue(stmts[0].object.language == language);
            }
            
            for (var removeMask = 0; removeMask < 8; removeMask++) {        
                var s_remove = removeMask & 1 ? subject : null; 
                var p_remove = removeMask & 2 ? predicate : null; 
                var o_remove = removeMask & 4 ? object : null; 
                log.debug("Removing graph.remove(" + s_remove + ", " + p_remove + ", " + o_remove + ").");
                graph.remove(s_remove, p_remove, o_remove);
                for (var findMask = 0; findMask < 8; findMask++) {
                    var s = findMask & 1 ? subject : null; 
                    var p = findMask & 2 ? predicate : null; 
                    var o = findMask & 4 ? object : null; 
                    log.debug("Checking graph.contains(" + s + ", " + p + ", " + o + ") must be false.");
                    tests.assertFalse(graph.contains(s, p, o));
                    log.debug("Checking graph.find(" + s + ", " + p + ", " + o + ") finds zero statements.");
                    var stmts = graph.find(s, p, o);
                    tests.assertTrue(stmts.length == 0);
                }
                graph.add(subject, predicate, object); // add it back so that the next remove iteration can remove it.
            }
        }

        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", "my test plain string literal");
        graph.clear();
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", "a typed string literal", undefined, "http://www.w3.org/2001/XMLSchema#string");
        graph.clear();
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", "plain string with language", "en-US");
        graph.clear();

        // Try passing in a JavaScript Number in various forms
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", 5);
        graph.clear();
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", 5, "en-US");
        graph.clear();
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", 5, undefined, "http://www.w3.org/2001/XMLSchema#string");
        graph.clear();
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", 5, undefined, "http://www.w3.org/2001/XMLSchema#double");
        graph.clear();

        // Now a boolean...false just to be tricky
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", false);
        graph.clear();
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", false, "en-US");
        graph.clear();
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", false, undefined, "http://www.w3.org/2001/XMLSchema#string");
        graph.clear();
        test_LiteralsInFindAddRemoveAndContainsHelper(graph, "http://example.org/subj1", "http://example.org/pred1", false, undefined, "http://www.w3.org/2001/XMLSchema#boolean");
    }
}

})();
