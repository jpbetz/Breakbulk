/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.tests.rdf.performance.js.ObjectStatementPerformance");

dojo.require("anzo.tests.rdf.performance.PerformanceUtils");

dojo.require("anzo.rdf.QuadStore");

dojo.require("anzo.rdf.vocabulary.XMLSchema");

tests.register("anzo.tests.rdf.performance.js.ObjectStatementPerformance", 
    [
//        function test_PerformanceRawObjects() {
//            timeFunction(buildRawObjects);
//        },
    
        function test_PerformanceBasicPrototypes() {
            timeFunction(buildBasicPrototypes);
        },
    
        function test_PerformanceBasicPrototypesWithInheritance() {
            timeFunction(buildBasicPrototypesWithInheritance);
        }
        
//        function test_PerformanceDojoInheritance() {
//            timeFunction(buildDojoInheritance);
//        }
        
    ]
);


function timeFunction(func, iterations, warmupIterations) {
    // summary: Invoke a function repeatedly to time it and print the average time of the iterations.
    
    iterations = iterations || 5; // default to 5 iterations
    warmupIterations = warmupIterations || 1; // default to 1 warm-up iteration
    
    console.debug("Starting warm-up invocations...");
    for (var i = 0; i < warmupIterations; i++) {
        func();
    }
    console.debug("Done with warm-up invocations.");

    console.debug("Starting measurement iterations...");
    var measurements = new Array(iterations);
    for (var i = 0; i < iterations; i++) {
        var startTime = new Date().getTime();
        func();
        var endTime=new Date().getTime();
        measurements[i] = endTime - startTime;
        console.debug("Time to create run iteration #" + (i + 1) + ": " + measurements[i] + "ms");
    }
    console.debug("Done with measurement iterations.");
    var total = 0;
    for (var i = 0; i < measurements.length; i++) {
        total += measurements[i];
    }
    var average = total / measurements.length;
    var sqrTotal = 0; 
    for (var i = 0; i < measurements.length; i++) {
        var diff = measurements[i] - average;
        sqrTotal += (diff * diff);
    }
    var stddev = Math.sqrt(sqrTotal / measurements.length);
    console.debug("Average time to run method: " + average + "ms. stddev:" + stddev + "ms.");
}

function buildRawObjects() {

    var NUM_STMTS = 10000;

    var args= [];
    for(var i = 1; i <= NUM_STMTS; i++) {
        var stmt = {
            subject       : { type: 'uri',     value: 'http://example/subj'+i },
            predicate     : { type: 'uri',     value: 'http://example/pred'+i },
            object        : { type: 'literal', value: 'This is a long paragraph containing information. '+i, datatype: 'http://www.w3.org/2001/XMLSchema#string' },
            namedGraphUri : { type: 'uri',     value: 'http://example/graph'+i }
        }
        args.push(stmt);
    }
    
}
        
function buildBasicPrototypes() {

    var NUM_STMTS = 10000;
    var args= [];
    for(var i = 1; i <= NUM_STMTS; i++) {
        var stmt = new Statement(
                      new URI('http://example/subj'+i), 
                      new URI('http://example/pred'+i), 
                      new Literal('This is a long paragraph containing information. '+i, null, 'http://www.w3.org/2001/XMLSchema#string'), 
                      new URI('http://example/graph'+i)
                   );
        args.push(stmt);
    }
}
        
function buildBasicPrototypesWithInheritance() {
    
    var NUM_STMTS = 10000;
    
    var args= [];
    for(var i = 1; i <= NUM_STMTS; i++) {
        var stmt = new Statement2(
                      new URI2('http://example/subj'+i), 
                      new URI2('http://example/pred'+i), 
                      new Literal2('This is a long paragraph containing information. '+i, null, 'http://www.w3.org/2001/XMLSchema#string'), 
                      new URI2('http://example/graph'+i)
                   );
        args.push(stmt);
    }
}
        

function buildDojoInheritance() {
    
    var NUM_STMTS = 10000;
    
    var args= [];
    for(var i = 1; i <= NUM_STMTS; i++) {
        var stmt = new anzo.createStatement(
                      new anzo.createURI('http://example/subj'+i), 
                      new anzo.createURI('http://example/pred'+i), 
                      new anzo.createTypedLiteral('This is a long paragraph containing information. '+i, 'http://www.w3.org/2001/XMLSchema#string'), 
                      new anzo.createURI('http://example/graph'+i)
                   );
        args.push(stmt);
    }
    
}


// ----------------------------------------------------
// Basic Prototype Objects

Literal = function(value, language, datatype) {
    this.value    = value;
    this.language = language;
    this.datatype = datatype;
}

Literal.prototype.dictionaryKey = function() { 
    // returns:
    //  a value used to lookup this object based on its values rather then reference
    return this.toString(); 
}

Literal.prototype.toString = function() { 
    var s = '"'+this.value+'"';
    if(this.datatype)
        s += "^^<"+this.datatype.toString()+">";
    if(this.language)
        s += "@"+this.language;
    return s;
}

Literal.prototype.equals = function(node) {
        
    // summary: Compares this object to the given node
    // returns: true if the given object is equal to this object, false otherwise
    
    // node : Object
    //  The object that is compared to this
    
    return (node != null && dojo.isFunction(node.dictionaryKey) && node.dictionaryKey() == this.dictionaryKey())
    
}


URI = function(value) {
    try {
        if(value == null) 
            throw Error("Invalid argument");
        this.value = value.toString();
        var index = getLocalNameIndex(value);
        if(index < 1) 
            throw Error('Invalid URI: '+value);
        
        this.namespace = value.slice(0, index);
        this.localname = value.slice(index, value.length);
    } catch (e) {
        log.error("ERROR: " + value);
    }
}

URI.prototype.dictionaryKey = function() {
    // returns:
    //      a value used to lookup this object based on its values rather then reference
    return this.value;
}

URI.prototype.toString = function() {
    // returns:
    //      a value used to lookup this object based on its values rather then reference
    return this.value;
}
    
URI.prototype.equals = function(node) {
        
    // summary: 
    //      Compares this object to the given node.
    // returns: 
    //      Returns True if the given object is equal to this object, false otherwise.
    
    // node : Object
    //  The object that is compared to this
    
    return (node != null && dojo.isFunction(node.dictionaryKey) && node.dictionaryKey() == this.dictionaryKey())
}

getLocalNameIndex = function(value) {
    // returns: The index of the delimiter between the namespace and the local name in the given uri.
        
    var index = value.indexOf("#");
    if(index < 1)
       index = value.lastIndexOf('/');
    if(index < 1) 
       index = value.lastIndexOf(':');
    return index+1;
}


BNode = function(value) {
    if(value == null) 
        throw Error("Invalid argument");
    this.value = value.toString();   
}

BNode.prototype.dictionaryKey = function() {
    // returns:
    //      Returns a value used to lookup this object based on its values rather then reference.
    return this.value;
}

BNode.prototype.toString = function() {
    // returns:
    //      Returns a value used to lookup this object based on its values rather then reference.
    return this.value;
}

BNode.prototype.equals = function(node) {
        
    // summary: 
    //      Compares this object to the given node.
    
    // returns: 
    //      Returns True if the given object is equal to this object, false otherwise
    
    // node : Object
    //  The object that is compared to this
    
    return (node != null && dojo.isFunction(node.dictionaryKey) && node.dictionaryKey() == this.dictionaryKey())
}

Statement = function(subject, predicate, object, namedGraphUri) {
        
    // subject: URI | BNode
    //  The subject of the predicate.
    
    // predicate: URI
    //  The predicate of the statement.
    
    // object: URI | BNode | Literal
    //  The object of the statement.

    // namedGraphUri: URI ?
    //  The optional URI of the named graph to which this statement belongs.
    
    if(!(subject instanceof URI || subject instanceof BNode)) { throw Error("Statement: Invalid Argument - subject is required and must be an Resource."); }
    if(!(predicate instanceof URI))    { throw Error("Statement: Invalid Argument - predicate is required and must be an URI."); }
    if(!(object instanceof Literal || object instanceof URI || object instanceof BNode))     { throw Error("Statement: Invalid Argument - object is required and must be an Value."); }
    if(namedGraphUri != null && !(namedGraphUri instanceof URI)) { throw Error("Statement: Invalid Argument - namedGraphUri must be an URI."); }
   
    this.subject          = subject;
    this.predicate        = predicate;
    this.object           = object;
    this.namedGraphUri    = namedGraphUri;
}

Statement.prototype.equals = function(/*Statement*/ statement) {
        
    // summary: 
    //     Compares this object to the given node.
    
    // returns: 
    //      Returns true if the given object is equal to this object, false otherwise.
    
    // statement : Object
    //  The object that is compared to this
    
    if((this.subject == null && statement.subject != null) || (this.predicate == null && statement.predicate != null) || (this.object == null && statement.object != null) || (this.namednamedGraphUri == null && statement.namnamedGraphUri != null))
        return false;
    if((this.subject && !this.subject.equals(statement.subject)) || (this.predicate && !this.predicate.equals(statement.predicate)) || (this.object && !this.object.equals(statement.object)) || (this.namedGraphUri && !this.namedGraphUri.equals(statement.namedGraphUri)))
        return false;
    return true;
}

Statement.prototype.dictionaryKey = function() {
    // returns:
    //      Returns a value used to lookup this object based on its values rather then reference.
   
    var code = '';
    code += this.subject        ? this.subject.dictionaryKey()       : null;
    code += this.predicate      ? this.predicate.dictionaryKey()     : null;
    code += this.object         ? this.object.dictionaryKey()        : null;
    code += this.namedGraphUri  ? this.namedGraphUri.dictionaryKey() : null;
    return code;
}

Statement.prototype.equals = function(/*Statement*/ statement) {
        
    // summary: 
    //     Compares this object to the given node.
    
    // returns: 
    //      Returns true if the given object is equal to this object, false otherwise.
    
    // statement : Object
    //  The object that is compared to this
    
    if((this.subject == null && statement.subject != null) || (this.predicate == null && statement.predicate != null) || (this.object == null && statement.object != null) || (this.namednamedGraphUri == null && statement.namnamedGraphUri != null))
        return false;
    if((this.subject && !this.subject.equals(statement.subject)) || (this.predicate && !this.predicate.equals(statement.predicate)) || (this.object && !this.object.equals(statement.object)) || (this.namedGraphUri && !this.namedGraphUri.equals(statement.namedGraphUri)))
        return false;
    return true;
}

Statement.prototype.toString = function() {
    // summary: Gets the string representation of the statement in the format:
    //     { 'subject', 'predicate', 'object', 'namedGraphUri' }
    // returns: 
    //     Returns the string representation version of the value stored in this object.
    
    var s = '{ '+this.subject+', '+this.predicate+', '+this.object;
    if(this.namedGraphUri)
       s += ', '+this.namedGraphUri+' }';
    else
       s += ' }';
    return s;
}

// --------------------------------------------------------------------
// Prototype Object With Classical Inheritance

Value2 = function() {
}

Resource2 = function() {
}
Resource2.prototype = new Value2;

Literal2 = function(value, language, datatype) {
    this.value    = value;
    this.language = language;
    this.datatype = datatype;
}

Literal2.prototype = new Value2;

Literal2.prototype.dictionaryKey = function() { 
    // returns:
    //  a value used to lookup this object based on its values rather then reference
    return this.toString(); 
}

Literal2.prototype.toString = function() { 
    var s = '"'+this.value+'"';
    if(this.datatype)
        s += "^^<"+this.datatype.toString()+">";
    if(this.language)
        s += "@"+this.language;
    return s;
}

Literal2.prototype.equals = function(node) {
        
    // summary: Compares this object to the given node
    // returns: true if the given object is equal to this object, false otherwise
    
    // node : Object
    //  The object that is compared to this
    
    return (node != null && dojo.isFunction(node.dictionaryKey) && node.dictionaryKey() == this.dictionaryKey())
}


URI2 = function(value) {
    try {
        if(value == null) 
            throw Error("Invalid argument");
        this.value = value.toString();
        var index = getLocalNameIndex(value);
        if(index < 1) 
            throw Error('Invalid URI: '+value);
        
        this.namespace = value.slice(0, index);
        this.localname = value.slice(index, value.length);
    } catch (e) {
        log.error("ERROR: " + value);
    }
}

URI2.prototype = new Resource2;
 
URI2.prototype.dictionaryKey = function() {
    // returns:
    //      a value used to lookup this object based on its values rather then reference
    return this.value;
}

URI2.prototype.toString = function() {
    // returns:
    //      a value used to lookup this object based on its values rather then reference
    return this.value;
}
    
URI2.prototype.equals = function(node) {
        
    // summary: 
    //      Compares this object to the given node.
    // returns: 
    //      Returns True if the given object is equal to this object, false otherwise.
    
    // node : Object
    //  The object that is compared to this
    
    return (node != null && dojo.isFunction(node.dictionaryKey) && node.dictionaryKey() == this.dictionaryKey())
}

BNode2 = function(value) {
    if(value == null) 
        throw Error("Invalid argument");
    this.value = value.toString();   
}

BNode2.prototype = new Resource2;

BNode2.prototype.dictionaryKey = function() {
    // returns:
    //      Returns a value used to lookup this object based on its values rather then reference.
    return this.value;
}

BNode2.prototype.toString = function() {
    // returns:
    //      Returns a value used to lookup this object based on its values rather then reference.
    return this.value;
}

BNode2.prototype.equals = function(node) {
        
    // summary: 
    //      Compares this object to the given node.
    
    // returns: 
    //      Returns True if the given object is equal to this object, false otherwise
    
    // node : Object
    //  The object that is compared to this
    
    return (node != null && dojo.isFunction(node.dictionaryKey) && node.dictionaryKey() == this.dictionaryKey())
}

Statement2 = function(subject, predicate, object, namedGraphUri) {
        
    // subject: URI | BNode
    //  The subject of the predicate.
    
    // predicate: URI
    //  The predicate of the statement.
    
    // object: URI | BNode | Literal
    //  The object of the statement.

    // namedGraphUri: URI ?
    //  The optional URI of the named graph to which this statement belongs.
    
    if(!(subject instanceof Resource2)) { throw Error("Statement: Invalid Argument - subject is required and must be an Resource."); }
    if(!(predicate instanceof URI2))    { throw Error("Statement: Invalid Argument - predicate is required and must be an URI."); }
    if(!(object instanceof Value2))     { throw Error("Statement: Invalid Argument - object is required and must be an Value."); }
    if(namedGraphUri != null && !(namedGraphUri instanceof URI2)) { throw Error("Statement: Invalid Argument - namedGraphUri must be an URI."); }
   
    this.subject          = subject;
    this.predicate        = predicate;
    this.object           = object;
    this.namedGraphUri    = namedGraphUri;
}

Statement2.prototype.equals = function(/*Statement*/ statement) {
        
    // summary: 
    //     Compares this object to the given node.
    
    // returns: 
    //      Returns true if the given object is equal to this object, false otherwise.
    
    // statement : Object
    //  The object that is compared to this
    
    if((this.subject == null && statement.subject != null) || (this.predicate == null && statement.predicate != null) || (this.object == null && statement.object != null) || (this.namednamedGraphUri == null && statement.namnamedGraphUri != null))
        return false;
    if((this.subject && !this.subject.equals(statement.subject)) || (this.predicate && !this.predicate.equals(statement.predicate)) || (this.object && !this.object.equals(statement.object)) || (this.namedGraphUri && !this.namedGraphUri.equals(statement.namedGraphUri)))
        return false;
    return true;
}

Statement2.prototype.dictionaryKey = function() {
    // returns:
    //      Returns a value used to lookup this object based on its values rather then reference.
   
    var code = '';
    code += this.subject        ? this.subject.dictionaryKey()       : null;
    code += this.predicate      ? this.predicate.dictionaryKey()     : null;
    code += this.object         ? this.object.dictionaryKey()        : null;
    code += this.namedGraphUri  ? this.namedGraphUri.dictionaryKey() : null;
    return code;
}

Statement2.prototype.equals = function(/*Statement*/ statement) {
        
    // summary: 
    //     Compares this object to the given node.
    
    // returns: 
    //      Returns true if the given object is equal to this object, false otherwise.
    
    // statement : Object
    //  The object that is compared to this
    
    if((this.subject == null && statement.subject != null) || (this.predicate == null && statement.predicate != null) || (this.object == null && statement.object != null) || (this.namednamedGraphUri == null && statement.namnamedGraphUri != null))
        return false;
    if((this.subject && !this.subject.equals(statement.subject)) || (this.predicate && !this.predicate.equals(statement.predicate)) || (this.object && !this.object.equals(statement.object)) || (this.namedGraphUri && !this.namedGraphUri.equals(statement.namedGraphUri)))
        return false;
    return true;
}

Statement2.prototype.toString = function() {
    // summary: Gets the string representation of the statement in the format:
    //     { 'subject', 'predicate', 'object', 'namedGraphUri' }
    // returns: 
    //     Returns the string representation version of the value stored in this object.
    
    var s = '{ '+this.subject+', '+this.predicate+', '+this.object;
    if(this.namedGraphUri)
       s += ', '+this.namedGraphUri+' }';
    else
       s += ' }';
    return s;
}
