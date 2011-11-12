/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
 
dojo.provide("anzo.rdf.Statement");

dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.log");
dojo.require("dojo.date.stamp");

anzo.rdf._xsdIntegerTypes = {
	"http://www.w3.org/2001/XMLSchema#integer"            : true,
	"http://www.w3.org/2001/XMLSchema#int"                : true,
	"http://www.w3.org/2001/XMLSchema#negativeInteger"    : true,
	"http://www.w3.org/2001/XMLSchema#long"               : true,
	"http://www.w3.org/2001/XMLSchema#short"              : true,
	"http://www.w3.org/2001/XMLSchema#byte"               : true,
	"http://www.w3.org/2001/XMLSchema#nonNegativeInteger" : true,
	"http://www.w3.org/2001/XMLSchema#unsignedLong"       : true,
	"http://www.w3.org/2001/XMLSchema#unsignedInt"        : true,
	"http://www.w3.org/2001/XMLSchema#unsignedShort"      : true,
	"http://www.w3.org/2001/XMLSchema#unsignedByte"       : true,
	"http://www.w3.org/2001/XMLSchema#positiveInteger"    : true
}

anzo.rdf._xsdFloatTypes = {
	"http://www.w3.org/2001/XMLSchema#double"  : true,
    "http://www.w3.org/2001/XMLSchema#float"   : true,
    "http://www.w3.org/2001/XMLSchema#decimal" : true
}

anzo.rdf.Value = function() {
}

anzo.rdf.Resource = function() {
}
anzo.rdf.Resource.prototype = new anzo.rdf.Value;

(function() {
var log = anzo.log.getLogger("anzo.rdf.Literal");

anzo.rdf.Literal = function(value, language, datatype) {
    this.value    = value;
    this.language = language;
    this.datatype = datatype;
}

anzo.rdf.Literal.prototype = new anzo.rdf.Value;

anzo.rdf.Literal.prototype.serialize = function() {
    if(!this._string) {
        this._string = dojo.isString(this.value) ? anzo.utils.escapeString(this.value) : '"'+this.value+'"';
        if(this.datatype)
            this._string += "^^<"+this.datatype.toString()+">";
        if(this.language)
            this._string += "@"+this.language;
    }
    return this._string;
},

anzo.rdf.Literal.prototype.dictionaryKey = function() { 
    // returns:
    //  a value used to lookup this object based on its values rather then reference
    return this.serialize();
}

anzo.rdf.Literal.prototype.toString = function() { 
    return this.value;
}

anzo.rdf.Literal.prototype.equals = function(node) {
        
    // summary: Compares this object to the given node
    // returns: true if the given object is equal to this object, false otherwise
    
    // node : Object
    //  The object that is compared to this
    
    return (node != null && dojo.isFunction(node.dictionaryKey) && node.dictionaryKey() == this.dictionaryKey())
}

anzo.rdf.Literal.prototype.getNativeValue = function() { 
    // returns:
    //   the value of this literal as a native JavaScript object or null if the literal cannot be converted
    //   into a native JavaScript object.
    
    if ("_nv" in this) { // Value already computed...use cached value
        return this._nv;
    }
    
    var ret = null;
    if (!this.datatype || this.datatype == "http://www.w3.org/2001/XMLSchema#string"
            || this.datatype == "http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral"
            || this.datatype == "http://www.w3.org/2001/XMLSchema#anyURI") {
        ret = this.value;
    } else if (this.datatype == "http://www.w3.org/2001/XMLSchema#boolean") {
        if (this.value == "true" || this.value == "1")
            ret = true;
        else if (this.value == "false" || this.value == "0")
            ret = false;
    } else if (this.datatype in anzo.rdf._xsdIntegerTypes) {
        ret = parseInt(this.value);
        if (isNaN(ret))
            ret = null; 
    } else if (this.datatype in anzo.rdf._xsdFloatTypes) {
        if (/^\+?INF$/.test(this.value)) {
            ret = Number.POSITIVE_INFINITY;
        } else if (this.value == "-INF") {
            ret = Number.NEGATIVE_INFINITY;
        } else if (this.value == "NaN") {
            ret = Number.NaN;
        } else { 
            ret = parseFloat(this.value);
            if (isNaN(ret))
                ret = null; 
        }
    } else if (this.datatype == "http://www.w3.org/2001/XMLSchema#time") {
        ret = anzo.utils.fromISOString("T" + this.value); // the fromISOString requires a T prefix to parse a time. 
    } else if (this.datatype == "http://www.w3.org/2001/XMLSchema#dateTime"
            || this.datatype == "http://www.w3.org/2001/XMLSchema#date"
            || this.datatype == "http://www.w3.org/2001/XMLSchema#gYearMonth"
            || this.datatype == "http://www.w3.org/2001/XMLSchema#gYear"
            || this.datatype == "http://www.w3.org/2001/XMLSchema#gMonth"
            || this.datatype == "http://www.w3.org/2001/XMLSchema#gDay"
            || this.datatype == "http://www.w3.org/2001/XMLSchema#gMonthDay") {
        ret = anzo.utils.fromISOString(this.value);
    }
    
    // cache value
    this._nv = ret;

    return ret;
}

})();


(function() {
var log = anzo.log.getLogger("anzo.rdf.URI");

anzo.rdf.URI = function(value) {
    // summary: Class representing a URI. This constructor shouldn't normally be called. Use anzo.createURI to construct
    //   instances of this class. 
    try {
        if(!dojo.isString(value)) {
            throw Error("Invalid argument");
        }
        this.value = value;
        
        var index = value.lastIndexOf("#");
        if(index < 1)
           index = value.lastIndexOf('/');
        if(index < 1) 
           index = value.lastIndexOf(':');
        index++;
        
        if(index < 1)
            throw Error('Invalid URI: '+value);
        
        this.namespace = value.slice(0, index);
        this.localname = value.slice(index, value.length);
    } catch (e) {
        log.error("ERROR: " + value);
        throw e;
    }
}

anzo.rdf.URI.prototype = new anzo.rdf.Resource;

anzo.rdf.URI.prototype.serialize = function() {
    if(!this._serialized)
      this._serialized = "<"+this.value+">";
    return this._serialized;
},

anzo.rdf.URI.prototype.dictionaryKey = function() {
    // returns:
    //      a value used to lookup this object based on its values rather then reference
    return this.value;
}

anzo.rdf.URI.prototype.toString = function() {
    // returns:
    //      a value used to lookup this object based on its values rather then reference
    return this.value;
}
    
anzo.rdf.URI.prototype.equals = function(node) {
        
    // summary: 
    //      Compares this object to the given node.
    // returns: 
    //      Returns True if the given object is equal to this object, false otherwise.
    
    // node : Object
    //  The object that is compared to this
    
    return (node != null && dojo.isFunction(node.dictionaryKey) && node.dictionaryKey() == this.dictionaryKey())
}

anzo.rdf.URI.prototype.getLocalName = function() {
    return this.localname;
}

anzo.rdf.URI.prototype.getNamespace = function() {
    return this.namespace;
}

})();

(function() {
var log = anzo.log.getLogger("anzo.rdf.BNode");

anzo.rdf.BNode = function(value) {
    if(value == null) 
        throw Error("Invalid argument");
    this.value = value.toString();   
}

anzo.rdf.BNode.prototype = new anzo.rdf.Resource;

anzo.rdf.BNode.prototype.serialize = function() {
    if(!this._serialized)
      this._serialized = "_:"+this.value;
    return this._serialized;
},

anzo.rdf.BNode.prototype.dictionaryKey = function() {
    // returns:
    //      Returns a value used to lookup this object based on its values rather then reference.
    return this.value;
}

anzo.rdf.BNode.prototype.toString = function() {
    // returns:
    //      Returns a value used to lookup this object based on its values rather then reference.
    return this.value;
}

anzo.rdf.BNode.prototype.equals = function(node) {
        
    // summary: 
    //      Compares this object to the given node.
    
    // returns: 
    //      Returns True if the given object is equal to this object, false otherwise
    
    // node : Object
    //  The object that is compared to this
    
    return (node != null && dojo.isFunction(node.dictionaryKey) && node.dictionaryKey() == this.dictionaryKey())
}

})();

(function() {
var log = anzo.log.getLogger("anzo.rdf.Statement");

anzo.rdf.Statement = function(subject, predicate, object, namedGraphUri) {
        
    // subject: URI | BNode
    //  The subject of the predicate.
    
    // predicate: URI
    //  The predicate of the statement.
    
    // object: URI | BNode | Literal
    //  The object of the statement.

    // namedGraphUri: URI ?
    //  The optional URI of the named graph to which this statement belongs.
    
    if(!(subject instanceof anzo.rdf.Resource)) { throw Error("Statement: Invalid Argument - subject is required and must be an Resource."); }
    if(!(predicate instanceof anzo.rdf.URI))    { throw Error("Statement: Invalid Argument - predicate is required and must be an URI."); }
    if(!(object instanceof anzo.rdf.Value))     { throw Error("Statement: Invalid Argument - object is required and must be an Value."); }
    if(namedGraphUri != null && !(namedGraphUri instanceof anzo.rdf.URI)) { throw Error("Statement: Invalid Argument - namedGraphUri must be an URI."); }
   
    this.subject          = subject;
    this.predicate        = predicate;
    this.object           = object;
    this.namedGraphUri    = namedGraphUri;
}

anzo.rdf.Statement.prototype.dictionaryKey = function() {
    // returns:
    //      Returns a value used to lookup this object based on its values rather then reference.
    
    if(!this._dictionaryKey)
        this._dictionaryKey = '{ ' + this.subject.dictionaryKey()+', ' + this.predicate.dictionaryKey()+', ' + this.object.dictionaryKey() + ((this.namedGraphUri) ? ", "+this.namedGraphUri.dictionaryKey()+" }" : " }");
    return this._dictionaryKey;
}

anzo.rdf.Statement.prototype.toString = function() {
    // summary: Gets the string representation of the statement in the format:
    //     { 'subject', 'predicate', 'object', 'namedGraphUri' }
    // returns: 
    //     Returns the string representation version of the value stored in this object.
    
    if(!this._string)
        this._string = this.subject.serialize() + ' ' + this.predicate.serialize() + ' ' + this.object.serialize() + (this.namedGraphUri ? " " + this.namedGraphUri.serialize() : "");
    return this._string;
}

anzo.rdf.Statement.prototype.equals = function(/*Statement*/ statement) {
        
    // summary: 
    //     Compares this object to the given node.
    
    // returns: 
    //      Returns true if the given object is equal to this object, false otherwise.
    
    // statement : Object
    //  The object that is compared to this
    
    return (statement != null && dojo.isFunction(statement.dictionaryKey) && statement.dictionaryKey() == this.dictionaryKey())
}

})();

anzo.rdf.caching = true;

(function() {
var log = anzo.log.getLogger("anzo");

dojo.mixin(anzo, {
    
    createBNode : function(id) {
        
        // summary: 
        //      Creates an anzo.rdf.BNode with the given id.
        //      sample use:
        //         var bnode1 = anzo.createBNode(1235464543214);
        //         var bnode2 = anzo.createBNode();
        
        // id: Object ?
        //  The id of the created blank node.  If an id is not provided, one will be generated.
        
        if(id instanceof anzo.rdf.BNode)
            return id; 
        if(id == null)
            id = 'node'+anzo.utils.randomInt(16);
        var _node = null;
        if(anzo.rdf.caching) {
            if(this.valToBNode == null)
                this.valToBNode = {};
            _node = this.valToBNode[id.toString()];
            if(_node == null) {
                _node = new anzo.rdf.BNode(id.toString());
                this.valToBNode[id.toString()] = _node;
            }
        } else {
            _node = new anzo.rdf.BNode(id);
        }
        return _node;
    },
    
    createURI : function(value) {
        // summary: 
        //      Creates an anzo.rdf.URI with the given value. It will resolve namespace prefixes
        //      that are registered. For example 'dc:title'.
        //      sample use:
        //         var uri1 = anzo.createURI('http://value');
        //         var uri2 = anzo.createURI('dc:title');
        // value: String
        //   The URI that is stored in the anzo.rdf.Value object. If null, then null is immediately returned.
        
        if (value instanceof anzo.rdf.URI || value == null)
            return value; 
        if (!dojo.isString(value)) 
            throw new Error("The given URI input value must be a non-null string: "+value);
        if(!anzo.utils.isURI(value))
            throw new Error("The given value must be a legal URI: "+value);
            
        value = anzo.rdf._getResolvedNamespaceURI(value);
        var _node = null;
        if (anzo.rdf.caching ) {
            if (this.valToURI == null)
                this.valToURI = {};
            var _node = this.valToURI[value];
            if (_node == null) {
                _node = new anzo.rdf.URI(value);
                this.valToURI[value] = _node;
            }
        } else {
            _node = new anzo.rdf.URI(value);
        }
        return _node; 
    },
    
    createLiteral : function(value, lang) {
        
        // summary: 
        //      Creates an anzo.rdf.Literal with the given value. To create a plain literal, omit the 'lang' argument.
        //      sample use:
        //         var lit1 = anzo.createLiteral('Hello World', 'en');
        //         var lit2 = anzo.createLiteral('Hello World');
        // value: Object
        //   If value is a String, then it's used verbatim in the lixteral. If value is any other JavaScript type,
        //   then it is converted into a lexical representation using the rules
        //   at http://www.openanzo.org/projects/openanzo/wiki/AnzoTypeConversions for when a datatype isn't specified.
        // lang : String ?
        //   The language of the literal.
        
        if(value instanceof anzo.rdf.Literal)
            return value;

        if(!dojo.isString(value)) {
            var lexicalForm = anzo.rdf._convertToLexicalValue(value);
            value = lexicalForm.value;
        }
        
        var _node = null;
        if(lang == null) {
            if(anzo.rdf.caching) {
                if(!this.valToNode)
                    this.valToNode = {};
                var _node = this.valToNode[value];
                if(_node == null) {
                     _node = new anzo.rdf.Literal(value);
                    this.valToNode[value] = _node;
                }
            } else {
                _node = new anzo.rdf.Literal(value);
            }
        } else {
            if(anzo.rdf.caching) {
                if(!this.valToLangHash)
                    this.valToLangHash = {};
                var langHash = this.valToLangHash[value];
                if(langHash == null) {
                    langHash = {};
                    this.valToLangHash[value] = langHash;
                }
                _node = langHash[lang];
                if(_node == null) {
                    _node = new anzo.rdf.Literal(value, lang);
                    langHash[lang] = _node;
                }
            } else {
                _node = new anzo.rdf.Literal(value, lang);
            }
        }
        return _node;
    },
    
    createTypedLiteral : function(value, datatype) {
        
        // summary: 
        //      Creates an anzo.rdf.Literal with the given value and datatype.
        //      This method can create literals from native ECMAScript types as well.
        // description: This method has three main forms of use:
        //   createTypedLiteral(String, String | anzo.rdf.URI):
        //        This form creates a typed literal with the lexical value given by
        //        the string and the datatype as given by the second argument.
        //   createTypedLiteral(Object)
        //        This form converts the native ECMAScript value into a lexical string in the
        //        form of the most appropriate RDF datatype. For example, it converts an
        //        ECMAScript 'Date' into a typed literal of type `xsd:dateTime`.  
        //   createTypedLiteral(Object (not string), String | anzo.rdf.URI)
        //        This form converts the native ECMAScript value into a lexical string is the form
        //        of the supplied RDF datatype. This form is useful to specify a specific datatype
        //        when the native object has multiple possible datatypes it could be. For example,
        //        an ECMAScript 'Number' could potentially be converted into `xsd:double` or `xsd:decimal`.
        //        This method allows the caller to make that choice.  
        //      sample use:
        //         var lit1 = anzo.createTypedLiteral("1.35", "http://www.w3.org/2001/XMLSchema#decimal");
        //         var lit2 = anzo.createTypedLiteral(1.35, "http://www.w3.org/2001/XMLSchema#decimal");
        //         var lit3 = anzo.createTypedLiteral(1.35);
        //   See http://www.openanzo.org/projects/openanzo/wiki/AnzoTypeConversions for the type conversions
        //   supported by this method.
        // value: Object
        //    The value stored in the literal.
        // datatype : String | anzo.rdf.URI | ?
        //    The datatype of the literal.
        
        if (value instanceof anzo.rdf.Literal)
            return value;
        if (value == null) {
            throw new Error("value argument is required.");
        }

        var lexicalForm = anzo.rdf._convertToLexicalValue(value, datatype);
        var lexicalValue = lexicalForm.value;
        var _datatype = lexicalForm.datatype;
        
        var _node = null;
        var _datatype = anzo.rdf.getValue(_datatype, {type: 'uri'});
        if (anzo.rdf.caching) {
            if (!this.valToDatatypeHash)
                this.valToDatatypeHash = {};
            var datatypeHash = this.valToDatatypeHash[lexicalValue];
            if (datatypeHash == null) {
                datatypeHash = {};
                this.valToDatatypeHash[lexicalValue] = datatypeHash;
            }
            _node = datatypeHash[_datatype.dictionaryKey()];
            if (_node == null) {
                _node = new anzo.rdf.Literal(lexicalValue, null, _datatype);
                datatypeHash[_datatype.dictionaryKey()] = _node;
            }
        } else {
            _node = new anzo.rdf.Literal(lexicalValue, null, _datatype);
        }
        return _node;
    },
    
    createStatement : function(subject, predicate, object, namedGraphUri) {
        
        // summary: 
        //      Creates an anzo.rdf.Statement with the given values.
        //      sample use:
        //          var stmt1 = anzo.createStatement('http://rouben', 'http://firstName', 'Rouben', 'http://graph1');
        //          var stmt2 = anzo.createStatement(anzo.createURI('http://rouben'), anzo.createURI('http://firstName'), anzo.createTypedLiteral('Rouben', XMLSchema.xsString), anzo.createURI('http://graph1'));
        
        // subject : String | anzo.rdf.Resource
        //  The subject of the statement.
        
        // predicate : String | anzo.rdf.URI
        //  The predicate of the statement.
        
        // object : Object | anzo.rdf.Value
        //  The object of the statement.
        
        // namedGraphUri : anzo.rdf.URI ?
        //  The optional name of the graph to which this statement belongs to.
        
        var s = anzo.rdf.getValue(subject,       {type: 'resource'});
        var p = anzo.rdf.getValue(predicate,     {type: 'uri'});
        var o = anzo.rdf.getValue(object);
        var c = anzo.rdf.getValue(namedGraphUri, {type: 'uri'});
        
        
        if(anzo.rdf.caching) {
            if(!this.stmtCache) { 
                this.stmtCache = {};
            }
            var key = '{ ' + s.dictionaryKey() + ', ' + p.dictionaryKey() + ', ' + o.dictionaryKey() + ((c) ? ", " + c.dictionaryKey() + " }" : " }");
            var stmt = this.stmtCache[key];
            if(!stmt) {
                this.stmtCache[key] = stmt = new anzo.rdf.Statement(s, p, o, c);
            }
            return stmt;
        }
        return new anzo.rdf.Statement(s, p, o, c);
    }
    
});
})();


(function() {
var log = anzo.log.getLogger("anzo.rdf");

anzo.rdf.getValue = function(value, constraints) {
    
    // summary: 
    //  Returns an anzo.rdf.Value for the given value.  If the given value already is an anzo.rdf.Value, then it is simply returned.
    // description: 
    //  This method is used as a simple way to convert the given value to an anzo.rdf.Value.
    //     anzo.rdf.getValue('http://example.org/foo'); // this returns an anzo.rdf.URI
    //     anzo.rdf.getValue('Rouben'); // this returns a plain anzo.rdf.Literal (value is 'Rouben')
    // value : Object
    //  The value that is converted into an anzo.rdf.Value.
    //  If value is instanceof anzo.rdf.Value, then it is returned
    //  If value is null, then null is returned
    //  If value is a string that is a registered prefixed name (CURIE), then the prefix is resolved and an anzo.rdf.URI is returned.
    //  If value is a string that is an absolute URI, then anzo.rdf.URI is returned.
    //  If value is a number, then anzo.rdf.Literal is returned with datatype http://www.w3.org/2001/XMLSchema#double
    //  If value is a boolean, then anzo.rdf.Literal is returned with datatype http://www.w3.org/2001/XMLSchema#boolean
    //  If value is a Date, then anzo.rdf.Literal is returned with datatype http://www.w3.org/2001/XMLSchema#dateTime
    //  else, then a plain anzo.rdf.Literal is returned.
    // constraints : Object ?
    //  An object that contains hints that make guessing the type of value more acurate.
    //     constraints:
    //         type: String
    //          One of the following strings:
    //            anzo.rdf.Resource | anzo.rdf.URI | anzo.rdf.BNode | anzo.rdf.Literal |
    //            uri | literal | typed-literal | bnode
    //         datatype: anzo.rdf.URI
    //          Specifies the datatype of the literal value.
    //         language: String
    //          Specifies the language of the literal value.
    //         xml:lang: String
    //          Specifies the language of the literal value. The same as the 'language' property. If both are supplied,
    //          the value of the 'language' property is used.
    //  Results are undefined if conflicting constraints are given. For example,
    //  if a type of "anzo.rdf.Resource" is requested and a datatype is specified. That conflicts because
    //  only RDF literals can have datatype information.
    try {
        if (value == null || value instanceof anzo.rdf.Value)
            return value;
        
        var type     = null;
        var datatype = null;
        var language = null;
        
        if(constraints) {
        	
        	// set normalized type
        	if(constraints.type)
        		type = constraints.type == 'anzo.rdf.Resource' ? 'resource' : (constraints.type == 'anzo.rdf.URI' ? 'uri' : (constraints.type == 'anzo.rdf.BNode' ? 'bnode' : constraints.type));
        	
        	if(constraints.language)
        		language = constraints.language;
        	else if(constraints.lang)
        		language = constraints.lang;
        	else if(constraints["xml:lang"])
        		language = constraints["xml:lang"];
        	
        	if(constraints.datatype)
        		datatype = constraints.datatype;
        	
        	if(type == null) {
        		if(datatype)
        			type = 'typed-literal';
        		else if(language)
        			type = 'literal';
        	}
        }
        
        // handle shorthand 'a' for rdf:type
        if(type == 'uri' && value == 'a')
        	value = 'rdf:type';
        
        // --------------------------------------------------------------------
        // GUESS THE TYPE - see if the value is a serialized string
        
        if(dojo.isString(value)) {
        	
        	// DESERIALIZE STRING
        	if((!type || type == 'uri' || type == 'resource') && value.charAt(0) == '<' && value.charAt(value.length-1) == '>' && anzo.utils.isURI(value.substring(1, value.length-1))) { // deserialize uri of the form <http://foo>
    			type  = 'uri';
    			value = value.substring(1, value.length-1); // deserialize the value
    		} else if((!type || type == 'bnode' || type == 'resource') && value.charAt(0) == '_' && value.charAt(1) == ':') {
    			type = 'bnode';
        		value = value.substring(2); // deserialize the value
    		} else if(!type) {
    			var firstChar = value.charAt(0);
                if(firstChar == '"' || firstChar == "'") {
                    if(value.charAt(value.length-1) == firstChar) { // deserialize Literal of the form "foo"
                        type  = 'literal';
                        value = value.substring(1, value.length-1);
                    } else { // deserialize Literal of the form "foo"^^<http://bar>
                        var _index = value.indexOf(firstChar+'^^<');
                        if(_index > 0 && value.charAt(value.length-1) == '>') {
                        	datatype = value.substring(_index+4, value.length-1);
                            value    = value.substring(1, _index);
                            type     = 'typed-literal';
                        } else { // deserialize Literal of the form "foo"@en
                        	var _index = value.indexOf(firstChar+'@');
	                        if(_index > 0) {
	                        	language = value.substring(_index+2, value.length);
	                            value    = value.substring(1, _index);
	                            type     = 'literal';
	                        }
                        }
                    }
                }
    		}
    		
    		if(!type || type == 'resource')
    			type = anzo.utils.isURI(value) ? 'uri' : (type == 'resource' ? 'bnode' : 'literal');
    		
        } else if(!type) {
        	type = 'typed-literal';
        }
        
        // --------------------------------------------------------------------
        // GUESS THE DATATYPE BASED ON THE JAVASCRIPT NATIVE TYPE
        
        if((type == 'typed-literal' || type == 'anzo.rdf.Literal') && language == null && datatype == null) {			
            if ("number" == typeof value || value instanceof Number) {
                datatype = anzo.rdf._xsdDouble;
            } else if ("boolean" == typeof value || value instanceof Boolean) {
                datatype = anzo.rdf._xsdBoolean;
            } else if (value instanceof Date) {
                datatype = anzo.rdf._xsdDateTime;
            }
			
			if(datatype == null && type == 'typed-literal')
				datatype = anzo.rdf._xsdString;
        }
        
        // --------------------------------------------------------------------
        // CREATE THE RDF NODE
        
        var _node = null;
        if (type == 'uri') {
            _node = anzo.createURI(value.toString());
        } else if (type == 'typed-literal' || type == 'literal' || type == 'anzo.rdf.Literal')  {
            if(datatype)
                _node = anzo.createTypedLiteral(value, datatype);
            else
                _node = anzo.createLiteral(value, language);
        } else if (type == 'bnode') {
            _node = anzo.createBNode(value.toString());
        } else {
        	throw Error("Invalid type specified");
        }
        
        return _node;
    
    } catch(e) {
        log.error("getValue: Error - " + e.message);
        throw e;
    }
}

anzo.rdf._getResolvedNamespaceURI = function(/*String*/value) {
    // summary: Resolves prefixed URIs into their full URI. It uses the prefixes
    //    registered via anzo.rdf.registerNamespace. 
    // value : String
    //   The prefixed URI for which the namespace is to be resolved.
    // returns: String
    //   Returns the fully resolved uri (with the full namespace).
    //   If the prefix cannot be resolved, the input string is returned unchanged. 
    
    if (!dojo.isString(value)) {
        throw new Error("_getResolvedNamespaceURI - argument must be a string.");
    }
    var index = value.indexOf(':');
    if(index > 0 && index+1 < value.length) {
        var _prefix = value.substring(0, index);
        if(_prefix in anzo.rdf.namespaces) {
            var _localname = value.substring(index+1, value.length);
            value = anzo.rdf.namespaces[_prefix] + _localname;
        }
    }

    return value;
}

anzo.rdf._convertToLexicalValue = function(value, desiredDatatype) {
    var _datatype;
    if (desiredDatatype != null) {
        if (!(desiredDatatype instanceof anzo.rdf.URI) && !dojo.isString(desiredDatatype)) {
            throw new Error("Datatype argument, if supplied, must be a string or anzo.rdf.URI object.");
        }
        _datatype = desiredDatatype instanceof anzo.rdf.URI ? desiredDatatype.toString() : desiredDatatype;
    } else {
        if (value instanceof String || typeof value == "string")
            _datatype = "http://www.w3.org/2001/XMLSchema#string";
        else if (value instanceof Number || typeof value == "number") 
            _datatype = "http://www.w3.org/2001/XMLSchema#double";
        else if (value instanceof Boolean || typeof value == "boolean") 
            _datatype = "http://www.w3.org/2001/XMLSchema#boolean";
        else if (value instanceof Date) 
            _datatype = "http://www.w3.org/2001/XMLSchema#dateTime";
        else if (value instanceof anzo.rdf.URI) 
            _datatype = "http://www.w3.org/2001/XMLSchema#anyURI";
        else 
            _datatype = "http://www.w3.org/2001/XMLSchema#string";
    }
    
    var lexicalValue;
    if (value instanceof String || typeof value == "string") {
        lexicalValue = value;
    } else if ((value instanceof Number || typeof value == "number")
                && (_datatype == "http://www.w3.org/2001/XMLSchema#double"
                || _datatype == "http://www.w3.org/2001/XMLSchema#float"
                || _datatype == "http://www.w3.org/2001/XMLSchema#string")) {
        if (value == Number.POSITIVE_INFINITY)
            lexicalValue = "INF";
        else if (value == Number.NEGATIVE_INFINITY)
            lexicalValue = "-INF";
        else if (isNaN(value))
            lexicalValue = "NaN";
        else
            lexicalValue = value.toString();
    } else if ((value instanceof Number || typeof value == "number") && _datatype == "http://www.w3.org/2001/XMLSchema#decimal") {
        if (!isFinite(value) || isNaN(value))
            throw new Error("Cannot convert infinite numbers or NaN to xsd:decimal.");
        else
            lexicalValue = value.toString();
    } else if ((value instanceof Number || typeof value == "number") && _datatype in anzo.rdf._xsdIntegerTypes) {
        if (!isFinite(value) || isNaN(value))
            throw new Error("Cannot convert infinite numbers or NaN to " + _datatype);
        else
            lexicalValue = value.toFixed(0);
    } else if (((value instanceof Boolean || typeof value == "boolean") && (_datatype == "http://www.w3.org/2001/XMLSchema#boolean" || _datatype == "http://www.w3.org/2001/XMLSchema#string"))
                || ((value instanceof Array || typeof value == "array") && _datatype == "http://www.w3.org/2001/XMLSchema#string")) {
        lexicalValue = value.toString();
    } else if (value instanceof Date && (_datatype == "http://www.w3.org/2001/XMLSchema#dateTime" || _datatype == "http://www.w3.org/2001/XMLSchema#string")) {
        lexicalValue = anzo.utils.toISOString(value);
    } else if (value instanceof Date && _datatype == "http://www.w3.org/2001/XMLSchema#date") {
        lexicalValue = anzo.utils.toISOString(value, { format : "date", local : true, hideTimezone: true });
    } else if (value instanceof Date && _datatype == "http://www.w3.org/2001/XMLSchema#time") {
        lexicalValue = anzo.utils.toISOString(value, { format : "time", local : true, hideTimezone: true });
    } else if (value instanceof Date && _datatype == "http://www.w3.org/2001/XMLSchema#gYearMonth") {
        lexicalValue = anzo.utils.toISOString(value, { format : "gYearMonth", local : true, hideTimezone: true });
    } else if (value instanceof Date && _datatype == "http://www.w3.org/2001/XMLSchema#gYear") {
        lexicalValue = anzo.utils.toISOString(value, { format : "gYear", local : true, hideTimezone: true });
    } else if (value instanceof Date && _datatype == "http://www.w3.org/2001/XMLSchema#gMonth") {
        lexicalValue = anzo.utils.toISOString(value, { format : "gMonth", local : true, hideTimezone: true });
    } else if (value instanceof Date && _datatype == "http://www.w3.org/2001/XMLSchema#gDay") {
        lexicalValue = anzo.utils.toISOString(value, { format : "gDay", local : true, hideTimezone: true });
    } else if (value instanceof Date && _datatype == "http://www.w3.org/2001/XMLSchema#gMonthDay") {
        lexicalValue = anzo.utils.toISOString(value, { format : "gMonthDay", local : true, hideTimezone: true });
    } else if (value instanceof anzo.rdf.URI && (_datatype == "http://www.w3.org/2001/XMLSchema#anyURI" || _datatype == "http://www.w3.org/2001/XMLSchema#string")) {
        lexicalValue = value.toString();
    } else if (value instanceof Object && _datatype == "http://www.w3.org/2001/XMLSchema#string") {
        lexicalValue = value.toString();
    } else {
        throw new Error("Cannot convert native object into datatype <" + _datatype + ">. Object is:" + value); 
    } 

    var datatypeUri = desiredDatatype instanceof anzo.rdf.URI ? desiredDatatype : anzo.createURI(_datatype);
    return { value : lexicalValue, datatype : datatypeUri };
}

anzo.rdf.namespaces = {};

anzo.rdf.registerNamespace = function(namespacePrefix, uri) {
    // summary: Registeres the given namespace prefix with the given uri.
    
    // namespacePrefix : String
    //   The key used to find the specified uri (i.e. dc in dc:title)
    
    // uri : String
    //   The registered uri (i.e. http://purl.org/dc/elements/1.1/)
    
    anzo.rdf.namespaces[namespacePrefix] = uri;
}

anzo.rdf._xsdDouble   = anzo.createURI('http://www.w3.org/2001/XMLSchema#double');
anzo.rdf._xsdBoolean  = anzo.createURI('http://www.w3.org/2001/XMLSchema#boolean');
anzo.rdf._xsdDateTime = anzo.createURI('http://www.w3.org/2001/XMLSchema#dateTime');
anzo.rdf._xsdString   = anzo.createURI('http://www.w3.org/2001/XMLSchema#string');

})();