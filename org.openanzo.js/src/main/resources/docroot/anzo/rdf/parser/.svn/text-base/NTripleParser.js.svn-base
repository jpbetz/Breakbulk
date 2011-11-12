/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * Created on:  Oct 10, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>) 
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 */
 
dojo.provide('anzo.rdf.parser.NTripleParser');

dojo.require("anzo.rdf.Statement");

(function () {

dojo.declare("anzo.rdf.parser.NTripleParser.NTriplesParserError", Error, {
    // summary: A custom Error object that inherits from the built-in Error class and adds
    //  parseLineNumber and parseColumnNumber properties. Those properties point to the location of the
    //  error in the string being parsed.
    constructor : function _NTriplesParserErrorConstructor(message, lineNumber, columnNumber) {
        this.message = message;
        this.parseLineNumber = lineNumber;
        this.parseColumnNumber = columnNumber;
    }
});

anzo.rdf.parser.NTripleParser.parse = function nTripleParse(nTripleString, graph) {
    
    // summary: 
    //     Parses the given N-Triple string and stores the statements into the given graph.
    // description:
    //     N-Triples is a simple RDF serialization format. It's syntax is defined
    //     at http://www.w3.org/TR/rdf-testcases/#ntriples. 
    
    // nTripleString : String
    //  N-Triple serialized RDF string.
    
    // graph : anzo.rdf.INamedGraph
    //  The graph into which the parsed statements are stored.

    // We parse using a simple state machine. These are the possible states.
    var states = {
        START : 0, // Start of line or input
        COMMENT : 1,
        SUBJECT_URI : 2,
        SUBJECT_BNODE : 3,
        PREDICATE_URI : 4,
        OBJECT_URI : 5,
        OBJECT_LITERAL : 6,
        OBJECT_LANG_START : 7,
        OBJECT_LANG_AFTER_FIRST_CHAR : 8,
        OBJECT_LANG_AFTER_DASH : 9, // after the optional '-' character 
        OBJECT_DATATYPE : 10,
        OBJECT_BNODE: 11,
        AFTER_SUBJECT : 12,
        AFTER_PREDICATE : 13,
        AFTER_OBJECT: 14,
        BEFORE_PREDICATE : 15, // after at least one space or tab
        BEFORE_OBJECT : 16, // after at least one space or tab
        SUBJECT_BNODE_BODY : 17, // after the first character of the bnode label
        OBJECT_BNODE_BODY : 18, // after the first character of the bnode label
        AFTER_OBJECT_LITERAL: 19,
        END : 20 // after the dot
    }
    var str = nTripleString;
    var state = states.START;
    var currChar = -1; 
    var len = str.length;
    var lineNumber = 1;
    var columnNumber = 1;
    // The context collects the start and end indexes of the tokens for a single triple
    var context = {
        subject : { start: -1, end: -1, lineStart: -1, columnStart: -1 },
        subject_bnode : { start: -1, end: -1, lineStart: -1, columnStart: -1 },
        predicate : { start: -1, end: -1, lineStart: -1, columnStart: -1 },
        object_uri : { start: -1, end: -1, lineStart: -1, columnStart: -1 },
        object_literal : { start: -1, end: -1, lineStart: -1, columnStart: -1 },
        object_lang : { start: -1, end: -1, lineStart: -1, columnStart: -1 },
        object_datatype : { start: -1, end: -1, lineStart: -1, columnStart: -1  },
        object_bnode : { start: -1, end: -1, lineStart: -1, columnStart: -1 }
    }
    // Map from bnode name (the N-Triples label) to anzo.rdf.BNode object. This caches the BNode objects created
    // so that we can find them again when other parts of the N-Triples document reference the same bnode label.
    var bnodeMap = { }; 
    // This collects all of the parsed statements.
    var statementsToAdd = [];
    
    // Pump the string through the state machine. 
    for (var i = 0; i < len; i++) {
        currChar = str.charAt(i);
        if (state == states.START) {
            if (currChar == '<') {
                state = states.SUBJECT_URI;
                context.subject.start = i + 1;
                context.subject.columnStart = columnNumber + 1;
                context.subject.lineStart = lineNumber;
            } else if (currChar == '#') {
                state = states.COMMENT;
            } else if (currChar == '_') {
                // Starting a bNode, the next character should be ':'
                if (i + 1 < len && str.charAt(i + 1) == ':') {
                    state = states.SUBJECT_BNODE;
                    context.subject_bnode.start = i + 2;
                    context.subject_bnode.columnStart = columnNumber + 2;
                    context.subject_bnode.lineStart = lineNumber;
                    i++;
                    columnNumber++;
                } else {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected character '" + currChar + "'. Expected ':'.", lineNumber, columnNumber);
                }
            } else if (!_isSpace(currChar)) {
                // Should be an end of line character if it isn't anything else at this point.
                var iseol = _isEol(str, i);
                if (iseol == 0) {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected character '" + currChar + "'. Expected an end of line character.", lineNumber, columnNumber);
                } else if (iseol == 1) {
                    lineNumber++;
                    columnNumber = 1;
                } else if (iseol == 2) {
                    i++;
                    lineNumber++;
                    columnNumber = 1;
                } else {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unknown error parsing N-Triples string - _isEol returned invalid state.", lineNumber, columnNumber);
                }
            }
        } else if (state == states.COMMENT) {
            var iseol = _isEol(str, i);
            if (iseol == 1) {
                state = states.START;
                lineNumber++;
                columnNumber = 1;
            } else if (iseol == 2) {
                state = states.START;
                i++;
                lineNumber++;
                columnNumber = 1;
            }
            // ignore all other characters in comment
        } else if (state == states.SUBJECT_URI || state == states.PREDICATE_URI || state == states.OBJECT_URI || state == states.OBJECT_DATATYPE) {
            var currCharCode = str.charCodeAt(i);
            if (currChar == '>') {
                var uri_start = -1;
                if (state == states.SUBJECT_URI) {
                    uri_start = context.subject.start; 
                    context.subject.end = i;
                    state = states.AFTER_SUBJECT;
                } else if (state == states.PREDICATE_URI) {
                    uri_start = context.predicate.start;
                    context.predicate.end = i;
                    state = states.AFTER_PREDICATE;
                } else if (state == states.OBJECT_URI) {
                    uri_start = context.object_uri.start;
                    context.object_uri.end = i;
                    state = states.AFTER_OBJECT;
                } else if (state == states.OBJECT_DATATYPE) {
                    uri_start = context.object_datatype.start;
                    context.object_datatype.end = i;
                    state = states.AFTER_OBJECT;
                } else {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unknown error parsing N-Triples string - invalid state handling URI.", lineNumber, columnNumber);
                }
                
                if (uri_start == i) { // The URI string "<>" is not allowed as per http://www.w3.org/TR/rdf-testcases/#absoluteURI
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("URI must not be empty.", lineNumber, columnNumber);
                }
            } else if(currCharCode < 0x20 || currCharCode > 0x7E) {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected character in URI (charCode: " + currCharCode + "). Literals must contain only ASCII characters from 0x20 to 0x7E. To include other characters escape them with their unicode code point such as \\u34EE.", lineNumber, columnNumber);
                
            }
            // let all other characters through. We'll handle escapes later.
        } else if (state == states.AFTER_SUBJECT || state == states.AFTER_PREDICATE) {
            // A least one space or tab is required after the subject and predicate 
            if (!_isSpace(currChar)) {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Expected at least one whitespace character.", lineNumber, columnNumber);
            } else {
                if (state == states.AFTER_SUBJECT) {
                    state = states.BEFORE_PREDICATE;
                } else if (state == states.AFTER_PREDICATE) {
                    state = states.BEFORE_OBJECT;
                } else {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unknown error parsing N-Triples string - invalid state handling text.", lineNumber, columnNumber);
                }
            }
        } else if (state == states.AFTER_OBJECT) {
            if (currChar == '.') {
                state = states.END;
                _finishStatement(str, context, bnodeMap, statementsToAdd, lineNumber, columnNumber);
            } else if (!_isSpace(currChar)) {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Expected '.', space, or tab.", lineNumber, columnNumber);
            }
        } else if (state == states.BEFORE_PREDICATE) {
            if (currChar == '<') {
                state = states.PREDICATE_URI;
                context.predicate.start = i + 1;
                context.predicate.columnStart = columnNumber + 1;
                context.predicate.lineStart = lineNumber;
            } else if (!_isSpace(currChar)) {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Expected '<', space, or tab.", lineNumber, columnNumber);
            }
        } else if (state == states.BEFORE_OBJECT) {
            if (currChar == '<') {
                state = states.OBJECT_URI;
                context.object_uri.start = i + 1;
                context.object_uri.columnStart = columnNumber + 1;
                context.object_uri.lineStart = lineNumber;
            } else if (currChar == '"') {
                state = states.OBJECT_LITERAL;
                context.object_literal.start = i + 1;
                context.object_literal.columnStart = columnNumber + 1;
                context.object_literal.lineStart = lineNumber;
            } else if (currChar == '_') {
                // Starting a bNode, the next character should be ':'
                if (i + 1 < len && str.charAt(i + 1) == ':') {
                    state = states.OBJECT_BNODE;
                    context.object_bnode.start = i + 2;
                    context.object_bnode.columnStart = columnNumber + 2;
                    context.object_bnode.lineStart = lineNumber;
                    i++;
                    columnNumber++;
                } else {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected character '" + currChar + "'. Expected ':'.", lineNumber, columnNumber);
                }
            } else if (!_isSpace(currChar)) {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Expected '<', space, or tab.", lineNumber, columnNumber);
            }
        } else if (state == states.SUBJECT_BNODE || state == states.OBJECT_BNODE) {
            // First character of a bnode label must be in [A-Za-z]
            var currCharCode = str.charCodeAt(i);
            if(currCharCode < 0x41 || (currCharCode > 0x5A && currCharCode < 0x61) || currCharCode > 0x7A) {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected character (charCode: " + currCharCode + "). BNode label must start with a letter from [A-Za-z].", lineNumber, columnNumber);
            }
            
            if (state == states.SUBJECT_BNODE) {
                state = states.SUBJECT_BNODE_BODY;
            } else if (state == states.OBJECT_BNODE) {
                state = states.OBJECT_BNODE_BODY;
            } else {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unknown error parsing N-Triples string - invalid state handling text.", lineNumber, columnNumber);
            }
        } else if (state == states.SUBJECT_BNODE_BODY || state == states.OBJECT_BNODE_BODY) {
            // The valid bnode label characters after the first character are [A-Za-z0-9]
            var currCharCode = str.charCodeAt(i);
            if (currChar == '.' && state == states.OBJECT_BNODE_BODY) {
                context.object_bnode.end = i;
                state = states.END;
                _finishStatement(str, context, bnodeMap, statementsToAdd, lineNumber, columnNumber);
            } else if (_isSpace(currChar)) {
                if (state == states.SUBJECT_BNODE_BODY) {
                    context.subject_bnode.end = i;
                    state = states.BEFORE_PREDICATE;
                } else if (state == states.OBJECT_BNODE_BODY) {
                    context.object_bnode.end = i;
                    state = states.AFTER_OBJECT;
                } else {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unknown error parsing N-Triples string - invalid state handling text.", lineNumber, columnNumber);
                }
            } else if(currCharCode < 0x30 || (currCharCode > 0x39 && currCharCode < 0x41) || (currCharCode > 0x5A && currCharCode < 0x61) || currCharCode > 0x7A) {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected character (charCode: " + currCharCode + "). BNode labels must only contain characters from [A-Za-z0-9].", lineNumber, columnNumber);
            }
        } else if (state == states.OBJECT_LITERAL) {
            var currCharCode = str.charCodeAt(i);
            if (currChar == '\\') {
                // Escape sequence. We don't fully resolve the escape sequence here. We'll handle that when we create the statement.
                if (i + 1 >= len) {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Invalid escape sequence. End of input found during escape sequence.", lineNumber, columnNumber);
                }
                i++;
                columnNumber++;
            } else if (currChar == '"') {
                context.object_literal.end = i;
                state = states.AFTER_OBJECT_LITERAL;
            } else if(currCharCode < 0x20 || currCharCode > 0x7E) {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected character (charCode: " + currCharCode + "). Literals may only contain character codes from 0x20 to 0x7E. To include other characters escape them with their unicode code point such as \\u34EE.", lineNumber, columnNumber);
            }
        } else if (state == states.AFTER_OBJECT_LITERAL) {
            var currCharCode = str.charCodeAt(i);
            if (currChar == '@') {
                state = states.OBJECT_LANG_START;
                context.object_lang.start = i + 1;
                context.object_lang.columnStart = columnNumber + 1;
                context.object_lang.lineStart = lineNumber;
            } else if (currChar == '^' && i + 2 < len && str.charAt(i + 1) == '^' && str.charAt(i + 2) == '<') {
                state = states.OBJECT_DATATYPE;
                context.object_datatype.start = i + 3;
                context.object_datatype.columnStart = columnNumber + 3;
                context.object_datatype.lineStart = lineNumber;
                i += 2;
                columnNumber += 2;
            } else if (currChar == '.') {
                state = states.END;
                _finishStatement(str, context, bnodeMap, statementsToAdd, lineNumber, columnNumber);
            } else if (_isSpace(currChar)) {
                state = states.AFTER_OBJECT;
            } else {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected character after literal (charCode: " + currCharCode + ").", lineNumber, columnNumber); 
            }
        } else if (state == states.OBJECT_LANG_START) {
            var currCharCode = str.charCodeAt(i);
            if (currCharCode >= 0x61 && currCharCode <= 0x7A) {
                // First character of language designator must be from [a-z]
                state = states.OBJECT_LANG_AFTER_FIRST_CHAR;
            } else {
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Invalid character ('" + currChar + "') in language designator.", lineNumber, columnNumber);
            }
        } else if (state == states.OBJECT_LANG_AFTER_FIRST_CHAR) {
            var currCharCode = str.charCodeAt(i);
            if (currChar == '-') {
                state = states.OBJECT_LANG_AFTER_DASH;
            } else if (currChar == '.') {
                context.object_lang.end = i;
                state = states.END;
                _finishStatement(str, context, bnodeMap, statementsToAdd, lineNumber, columnNumber);
            } else if (_isSpace(currChar)) {
                context.object_lang.end = i;
                state = states.AFTER_OBJECT;
            } else if (currCharCode < 0x61 || currCharCode > 0x7A) {
                // First part of language designator must only have characters from [a-z]
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Invalid character ('" + currChar + "') in language designator.", lineNumber, columnNumber);
            }
        } else if (state == states.OBJECT_LANG_AFTER_DASH) {
            var currCharCode = str.charCodeAt(i);
            if (currChar == '.') {
                if (str.charAt(i - 1) == '-') {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Invalid language designation for literal.", lineNumber, columnNumber);
                }
                context.object_lang.end = i;
                state = states.END;
                _finishStatement(str, context, bnodeMap, statementsToAdd, lineNumber, columnNumber);
            } else if (_isSpace(currChar)) {
                if (str.charAt(i - 1) == '-') {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Invalid language designation for literal.", lineNumber, columnNumber);
                }
                context.object_lang.end = i;
                state = states.AFTER_OBJECT;
            } else if (currChar == '-') {
                if (str.charAt(i - 1) == '-') {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Invalid language designation for literal.", lineNumber, columnNumber);
                }
            } else if (currCharCode < 0x30 || (currCharCode > 0x39 && currCharCode < 0x61) || currCharCode > 0x7A) {
                // Second part of language designator must only have characters from [a-z0-9] or another dash as long as there is at least on [a-z0-9] character
                throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Invalid character ('" + currChar + "') in language designator.", lineNumber, columnNumber);
            }
        } else if (state == states.END) {
            if (!_isSpace(currChar)) {
                var iseol = _isEol(str, i);
                if (iseol == 0) {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected character '" + currChar + "'. Expected space, or newline characters.", lineNumber, columnNumber);
                } else if (iseol == 1) {
                    state = states.START;
                    lineNumber++;
                    columnNumber = 1;
                } else if (iseol == 2) {
                    state = states.START;
                    i++;
                    lineNumber++;
                    columnNumber = 1;
                } else {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unknown error parsing N-Triples string - _isEol returned invalid state.", lineNumber, columnNumber);
                }
            }
        }

        columnNumber++;
    }
    
    // Allowable ending states
    if (state != states.START && state != states.END && state != states.COMMENT) {
        throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unexpected end of input.", lineNumber, columnNumber);
    }
    
    if (statementsToAdd.length > 0) {
        graph.add(statementsToAdd);
    }
}

function _finishStatement(str, context, bnodeMap, statementsToAdd, lineNumber, columnNumber) {
    // summary: Interal parser function which creates an anzo.rdf.Statement object based on the
    //   current values of the context argument. It adds the created statement to the statementsToAdd
    //   array and resets the context.
    var statement = _makeStatementFromContext(str, context, bnodeMap, lineNumber, columnNumber);
    statementsToAdd.push(statement);
    _resetContext(context);
}

function _makeStatementFromContext(str, context, bnodeMap, lineNumber, columnNumber) {
    // summary: Internal parser function which creates an anzo.rdf.Statement object from
    //   the context values. It will handle any escapes found in the URIs or literal strings.
    var subjectNode = null;
    var predicateNode = null;
    var objectNode = null;
    var statement = null;
    
    // Some shortcuts for efficiency. Avoids repeated property lookups.
    var contextSubject = context.subject;
    var contextSubjectBNode = context.subject_bnode;
    var contextPredicate = context.predicate;
    var contextObjectUri = context.object_uri;
    var contextObjectBNode = context.object_bnode;
    var contextObjectLiteral = context.object_literal;
    
    if (contextSubject.start >= 0) {
        var uri = _unescapeSubstring(str, contextSubject.start, contextSubject.end, contextSubject.lineStart, contextSubject.columnStart);
        subjectNode = anzo.createURI(uri);
    } else if (contextSubjectBNode.start >= 0) {
        var subjectNodeLabel = str.substring(contextSubjectBNode.start, contextSubjectBNode.end);
        subjectNode = _getBNode(subjectNodeLabel, bnodeMap);
    } else {
        throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Missing subject data for triple.", lineNumber, columnNumber);
    }
    
    if (contextPredicate.start >= 0) {
        var uri = _unescapeSubstring(str, contextPredicate.start, contextPredicate.end, contextPredicate.lineStart, contextPredicate.columnStart);
        predicateNode = anzo.createURI(uri);
    } else {
        throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Missing predicate data for triple.", lineNumber, columnNumber);
    }
    
    if (contextObjectUri.start >= 0) {
        var uri = _unescapeSubstring(str, contextObjectUri.start, contextObjectUri.end, contextObjectUri.lineStart, contextObjectUri.columnStart);
        objectNode = anzo.createURI(uri);
    } else if (contextObjectBNode.start >= 0) {
        var objectNodeLabel = str.substring(contextObjectBNode.start, contextObjectBNode.end);
        objectNode = _getBNode(objectNodeLabel, bnodeMap);
    } else if (contextObjectLiteral.start >= 0) {
        var literalValue = _unescapeSubstring(str, contextObjectLiteral.start, contextObjectLiteral.end, contextObjectLiteral.lineStart, contextObjectLiteral.columnStart);
        var contextDatatype = context.object_datatype;
        var contextLang = context.object_lang;
        if (contextDatatype.start >= 0) {
            var uri = _unescapeSubstring(str, contextDatatype.start, contextDatatype.end, contextDatatype.lineStart, contextDatatype.columnStart);
            objectNode = anzo.createTypedLiteral(literalValue, uri);
        } else if (contextLang.start >= 0) {
            var lang = str.substring(contextLang.start, contextLang.end);
            objectNode = anzo.createLiteral(literalValue, lang);
        } else {
            objectNode = anzo.createLiteral(literalValue);
        }
    } else {
        throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Missing object data for triple.", lineNumber, columnNumber);
    }
    
    statement = new anzo.rdf.Statement(subjectNode, predicateNode, objectNode);
    return statement;
}

function _getBNode(nodeLabel, bnodeMap) {
    // summary: Finds the anzo.rdf.BNode object for the given nodeLabel. It will create a new one if there
    //   isn't yet an object which corresponds to the label.
    var ret = null;
    var cachedBnode = bnodeMap[nodeLabel];
    if (cachedBnode) { 
        ret = cachedBnode;
    } else {
        ret = anzo.createBNode();
        bnodeMap[nodeLabel] = ret;
    }
    return ret;
}

function _unescapeSubstring(str, start, end, lineNumber, columnNumber) {
    // summary: Internal parser function which unescapes the substring between the start and end indexes (does not include
    //   the character at end). This handles the escaping mechanism described 
    //   at http://www.w3.org/TR/rdf-testcases/#ntrip_strings.  
    // returns: the unescaped string
    var buf = [];
    var len = str.length;
    var currentStart = start;
    var ret = null;
    var currChar = null;
    for (var i = start; i < end && i < len; i++) {
        currChar = str.charAt(i);
        if (currChar == '\\') {
            buf.push(str.substring(currentStart, i));
            if (i + 1 < len && i + 1 < end) {
                var nextChar = str.charAt(i + 1);
                if (nextChar == '\\' || nextChar == '"' || nextChar == 't' || nextChar == 'n' || nextChar == 'r') {
                    var ch = nextChar;
                    if (nextChar == 't') {
                        ch = '\t';
                    } else if (nextChar == 'n') {
                        ch = '\n';
                    } else if (nextChar == 'r') {
                        ch = '\r';
                    }
                    buf.push(ch);
                    currentStart = i + 2;
                    i++;
                    columnNumber++;
                } else if (nextChar == 'u' || nextChar == 'U') {
                    // Handle unicode escape sequences (\uFFFF style of \UFFFFFFFF)
                    var unicodeSequenceLength = (nextChar == 'u') ? 4 : 8; 
                    if (i + 1 + unicodeSequenceLength < len && i + 1 + unicodeSequenceLength < end) {
                        var hexStr = str.substring(i + 2, i + 2 + unicodeSequenceLength);
                        if (!hexStr.match(/^[0-9A-F]+$/)) {
                            throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Invalid Unicode escape sequence. Require " + unicodeSequenceLength + " hex digits (in capitals: 0-9A-F).", lineNumber, columnNumber);
                        }
                        var num = parseInt(hexStr, 16);
                        currentStart = i + 2 + unicodeSequenceLength;
                        if (num <= 0xFFFF) {
                            // Handle code points within the Unicode Basic Multilingual Plane (BMP)
                            buf.push(String.fromCharCode(num));
                        } else {
                            // Handle code points outside of the Unicode Basic Multilingual Plane (BMP).
                            // This creates a UTF-16 surrogate pair.
                            var v_prime = num - 0x10000;
                            var v_high = v_prime >> 10; // higher order 10 bits (or more) of v_prime
                            var v_low = v_prime & 0x3FF; // low order 10 bits of v_prime
                            buf.push(String.fromCharCode(0xD800 | v_high, 0xDC00 | v_low));
                        }
                        i += unicodeSequenceLength + 1;
                        columnNumber += unicodeSequenceLength + 1;
                    } else { 
                        throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Invalid Unicode escape sequence. Require four hex digits (in capitals: 0-9A-F).", lineNumber, columnNumber + 1);
                    }
                } else {
                    throw new anzo.rdf.parser.NTripleParser.NTriplesParserError("Unknown escape sequence ('\\" + currChar + "').", lineNumber, columnNumber + 1);
                }
            }
        }
        columnNumber++;
    }
    if (buf.length <= 0) {
        // There were no escape sequences so just return the full substring as-is. 
        ret = str.substring(start, end);
    } else {
        if (currentStart < end) {
            // Catch any leftover characters since the last escape sequence.
            buf.push(str.substring(currentStart, end));
        }
        ret = buf.join("");
    }
    return ret;
}

function _isSpace(ch) {
    // summary: Determine if the given character is a space or tab character. N-Triples considers
    //   only the space character and tab allowable whitespace.
    // returns: true if the given character is a space or tab. false otherwise. 
    return ch == ' ' || ch == '\t';
}
    
function _isEol(str, i) {
    // summary: returns 0 is this isn't an eol character. It returns 1 if it's a single carriage-return or newline.
    //   It returns 2 if it's a carriage-return and newline pair. 
    var ch = str.charAt(i);
    var ret = 0;
    if (ch == '\r' && i + 1 < str.length && str.charAt(i + 1) == '\n') {
        ret = 2;
    } else if (ch == '\r' || ch == '\n') {
        ret = 1;
    } else {
        ret = 0;
    }
    return ret;
}

function _resetContext(context) {
    // summary: Internal parse function which rests the indexes in the given context to prepare it for
    //   processing a new triple. 

    // Some shortcuts for efficiency. Avoids repeated property lookups.
    var contextSubject = context.subject;
    var contextSubjectBNode = context.subject_bnode;
    var contextPredicate = context.predicate;
    var contextObjectUri = context.object_uri;
    var contextObjectLiteral = context.object_literal;
    var contextObjectBNode = context.object_bnode;
    var contextDatatype = context.object_datatype;
    var contextLang = context.object_lang;
    
    contextSubject.start = -1;
    contextSubject.end = -1;
    contextSubject.lineStart = -1;
    contextSubject.columnStart = -1;

    contextSubjectBNode.start = -1;
    contextSubjectBNode.end = -1;
    contextSubjectBNode.lineStart = -1;
    contextSubjectBNode.columnStart = -1;

    contextPredicate.start = -1;
    contextPredicate.end = -1;
    contextPredicate.lineStart = -1;
    contextPredicate.columnStart = -1;

    contextObjectUri.start = -1;
    contextObjectUri.end = -1;
    contextObjectUri.lineStart = -1;
    contextObjectUri.columnStart = -1;

    contextObjectLiteral.start = -1;
    contextObjectLiteral.end = -1;
    contextObjectLiteral.lineStart = -1;
    contextObjectLiteral.columnStart = -1;

    contextObjectBNode.start = -1;
    contextObjectBNode.end = -1;
    contextObjectBNode.lineStart = -1;
    contextObjectBNode.columnStart = -1;

    contextLang.start = -1;
    contextLang.end = -1;
    contextLang.lineStart = -1;
    contextLang.columnStart = -1;

    contextDatatype.start = -1;
    contextDatatype.end = -1;
    contextDatatype.lineStart = -1;
    contextDatatype.columnStart = -1;
}

})();
