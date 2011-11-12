/**
 * @fileoverview
 * TABULATOR RDF PARSER
 *
 * Version 0.1
 *  Parser believed to be in full positive RDF/XML parsing compliance
 *  with the possible exception of handling deprecated RDF attributes
 *  appropriately. Parser is believed to comply fully with other W3C
 *  and industry standards where appropriate (DOM, ECMAScript, &c.)
 *
 *  Author: David Sheets <dsheets@mit.edu>
 *  SVN ID: $Id$
 *
 * W3C® SOFTWARE NOTICE AND LICENSE
 * http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 * This work (and included software, documentation such as READMEs, or
 * other related items) is being provided by the copyright holders under
 * the following license. By obtaining, using and/or copying this work,
 * you (the licensee) agree that you have read, understood, and will
 * comply with the following terms and conditions.
 * 
 * Permission to copy, modify, and distribute this software and its
 * documentation, with or without modification, for any purpose and
 * without fee or royalty is hereby granted, provided that you include
 * the following on ALL copies of the software and documentation or
 * portions thereof, including modifications:
 * 
 * 1. The full text of this NOTICE in a location viewable to users of
 * the redistributed or derivative work.
 * 2. Any pre-existing intellectual property disclaimers, notices, or terms and
 * conditions. If none exist, the W3C Software Short Notice should be
 * included (hypertext is preferred, text is permitted) within the body
 * of any redistributed or derivative code.
 * 3. Notice of any changes or modifications to the files, including the
 * date changes were made. (We recommend you provide URIs to the location
 * from which the code is derived.)
 * 
 * THIS SOFTWARE AND DOCUMENTATION IS PROVIDED "AS IS," AND COPYRIGHT
 * HOLDERS MAKE NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO, WARRANTIES OF MERCHANTABILITY OR FITNESS
 * FOR ANY PARTICULAR PURPOSE OR THAT THE USE OF THE SOFTWARE OR
 * DOCUMENTATION WILL NOT INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS,
 * TRADEMARKS OR OTHER RIGHTS.
 * 
 * COPYRIGHT HOLDERS WILL NOT BE LIABLE FOR ANY DIRECT, INDIRECT, SPECIAL
 * OR CONSEQUENTIAL DAMAGES ARISING OUT OF ANY USE OF THE SOFTWARE OR
 * DOCUMENTATION.
 * 
 * The name and trademarks of copyright holders may NOT be used in
 * advertising or publicity pertaining to the software without specific,
 * written prior permission. Title to copyright in this software and any
 * associated documentation will at all times remain with copyright
 * holders.
 */
 
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
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
 
dojo.provide("anzo.rdf.parser.TabulatorParser");


// depends on:
	//  dig.csail.mit.edu/2005/ajar/ajaw/rdf/term.js 
	//  dig.csail.mit.edu/2005/ajar/ajaw/uri.js
	//  dig.csail.mit.edu/2005/ajar/ajaw/rdf/rdfparser.js

anzo.rdf.parser.TabulatorParser.parse = function(rdfXMLString, graph) {
	
	// summary: 
	//     Parses the given RDF/XML string and stores the statements into the given graph.
	
	// rdfXMLString : String
	//  RDF/XML serialized RDF string.
	
	// graph : anzo.rdf.INamedGraph
	//  The graph into which the parsed statements are stored.
	
	
	
	var store = new _GraphStore(graph);
	var parser = new RDFParser(store);
	parser.reify = parser.forceRDF = true;  // forceRDF isn't used??
	
	var nodeTree = null;
	if (document.implementation.createDocument){ 
	    // Mozilla, create a new DOMParser 
	  	nodeTree = (new DOMParser()).parseFromString(rdfXMLString, 'text/xml');
	} else if (window.ActiveXObject){ 
	    // Internet Explorer, create a new XML document using ActiveX 
	    // and use loadXML as a DOM parser. 
	    nodeTree = new ActiveXObject("Msxml.DOMDocument");//new ActiveXObject("Microsoft.XMLDOM")
	    nodeTree.async="false"; 
        nodeTree.loadXML(rdfXMLString);  
        
        // Fails in IE because getAttributeNodeNS is not a supported operation :-(
        
	} 
 
	// must be an XML document node tree
	parser.parse(nodeTree,'');

	 
}

// For more info see: http://dig.csail.mit.edu/2005/ajar/ajaw/Developer.html


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// STORE - Modified version of TestStore (http://dig.csail.mit.edu/2005/ajar/ajaw/test/rdf/rdfparser.test.html)

function _GraphStore(graph) {
	this.graph = graph;
    this.bn = 97 // 'a'
   // this.triples = []
   // this.collections = {}
    this.sym = function (uri) {
        return {val: uri, type: "sym"}
    }
    this.collection = function () {
        var store = this
    	var c = new Object()
    	c.val = this.bn++
    	c.type = "collection"
    	c.elements = []
    	c.append = function (el) { this.elements[this.elements.length]=el }
    	c.close = function () {
    	    var rdfns = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    	    if (this.elements.length == 0) {
    	        store.add(this,store.sym(rdfns+"first"),store.sym(rdfns+"nil"))
    		return
    	    }
    	    var cn = this
    	    store.add(cn,store.sym(rdfns+"first"),this.elements[0])
    	    for (var x=1; x<this.elements.length; x++) {
    	        var nn = store.bnode()
    		store.add(cn,store.sym(rdfns+"rest"),nn)
    		cn = nn
    	        store.add(cn,store.sym(rdfns+"first"),this.elements[x])
    	    }
    	    store.add(cn,store.sym(rdfns+"rest"),store.sym(rdfns+"nil"))
    	}
    	return c
    }
    this.bnode = function () {
    	return {val: this.bn++, type: "bnode"}
    }
    this.literal = function (val, lang, type) {
    	return {val: val, datatype: type, type: "literal", lang: lang}
    }
    this.add = function (s,p,o,w) {
    	
    	var subj = null;
    	var pred = null;
    	var obj  = null;
    	
    	// SUBJECT
        if (s.type == "bnode" || s.type == "collection") {
    	    subj = anzo.createBNode(String.fromCharCode(s.val));
    	} else {
    	    subj = anzo.createURI(s.val);
    	}

        // OBJECT
        if (o.type == "literal" && o.datatype == "http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral") {
    	    var val = ""
    	    var xmls = new XMLSerializer()
    	    for (var x=0; x < o.val.childNodes.length; x++)
    	        val += xmls.serializeToString(o.val.childNodes[x])
    	    o.val = val
    	    obj = anzo.rdf.getValue(o.val, { type : 'anzo.rdf.Literal' })
    	} else if(o.type == "literal") {
    	    obj = anzo.rdf.getValue(o.val, { type : 'anzo.rdf.Literal', language : o.lang, datatype: o.datatype });
    	} else if (o.type == "bnode" || o.type == "collection") {
    	    obj = anzo.createBNode(String.fromCharCode(o.val));
    	} else {
    	    obj = anzo.createURI(o.val);
    	}
        
        var subj = subj ? subj : anzo.rdf.getValue(s.val, { type : 'anzo.rdf.Resource' });
    	var pred = pred ? pred : anzo.createURI(p.val);
    	var obj  = obj  ? obj  : anzo.rdf.getValue(o.val);
    	
    	graph.add(subj, pred, obj);
    	
    }
        
        
    
}




// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// TABULATOR PARSER - http://dig.csail.mit.edu/2005/ajar/ajaw/js/rdf/parser.js

/**
 * @fileoverview
 * TABULATOR RDF PARSER
 *
 * Version 0.1
 *  Parser believed to be in full positive RDF/XML parsing compliance
 *  with the possible exception of handling deprecated RDF attributes
 *  appropriately. Parser is believed to comply fully with other W3C
 *  and industry standards where appropriate (DOM, ECMAScript, &c.)
 *
 *  Author: David Sheets <dsheets@mit.edu>
 *  SVN ID: $Id$
 *
 * W3C® SOFTWARE NOTICE AND LICENSE
 * http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 * This work (and included software, documentation such as READMEs, or
 * other related items) is being provided by the copyright holders under
 * the following license. By obtaining, using and/or copying this work,
 * you (the licensee) agree that you have read, understood, and will
 * comply with the following terms and conditions.
 * 
 * Permission to copy, modify, and distribute this software and its
 * documentation, with or without modification, for any purpose and
 * without fee or royalty is hereby granted, provided that you include
 * the following on ALL copies of the software and documentation or
 * portions thereof, including modifications:
 * 
 * 1. The full text of this NOTICE in a location viewable to users of
 * the redistributed or derivative work.
 * 2. Any pre-existing intellectual property disclaimers, notices, or terms and
 * conditions. If none exist, the W3C Software Short Notice should be
 * included (hypertext is preferred, text is permitted) within the body
 * of any redistributed or derivative code.
 * 3. Notice of any changes or modifications to the files, including the
 * date changes were made. (We recommend you provide URIs to the location
 * from which the code is derived.)
 * 
 * THIS SOFTWARE AND DOCUMENTATION IS PROVIDED "AS IS," AND COPYRIGHT
 * HOLDERS MAKE NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO, WARRANTIES OF MERCHANTABILITY OR FITNESS
 * FOR ANY PARTICULAR PURPOSE OR THAT THE USE OF THE SOFTWARE OR
 * DOCUMENTATION WILL NOT INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS,
 * TRADEMARKS OR OTHER RIGHTS.
 * 
 * COPYRIGHT HOLDERS WILL NOT BE LIABLE FOR ANY DIRECT, INDIRECT, SPECIAL
 * OR CONSEQUENTIAL DAMAGES ARISING OUT OF ANY USE OF THE SOFTWARE OR
 * DOCUMENTATION.
 * 
 * The name and trademarks of copyright holders may NOT be used in
 * advertising or publicity pertaining to the software without specific,
 * written prior permission. Title to copyright in this software and any
 * associated documentation will at all times remain with copyright
 * holders.
 */
/**
 * @class Class defining an RDFParser resource object tied to an RDFStore
 *  
 * @author David Sheets <dsheets@mit.edu>
 * @version 0.1
 * 
 * @constructor
 * @param {RDFStore} store An RDFStore object
 */
function RDFParser(store) {
    /** Standard namespaces that we know how to handle @final
     *  @member RDFParser
     */
    RDFParser['ns'] = {'RDF':
		       "http://www.w3.org/1999/02/22-rdf-syntax-ns#",
		       'RDFS':
		       "http://www.w3.org/2000/01/rdf-schema#"}
    /** DOM Level 2 node type magic numbers @final
     *  @member RDFParser
     */
    RDFParser['nodeType'] = {'ELEMENT': 1, 'ATTRIBUTE': 2, 'TEXT': 3,
			     'CDATA_SECTION': 4, 'ENTITY_REFERENCE': 5,
			     'ENTITY': 6, 'PROCESSING_INSTRUCTION': 7,
			     'COMMENT': 8, 'DOCUMENT': 9, 'DOCUMENT_TYPE': 10,
			     'DOCUMENT_FRAGMENT': 11, 'NOTATION': 12}

    /**
     * Frame class for namespace and base URI lookups
     * Base lookups will always resolve because the parser knows
     * the default base.
     *
     * @private
     */
    this['frameFactory'] = function (parser, parent, element) {
	return {'NODE': 1,
		'ARC': 2,
		'parent': parent,
		'parser': parser,
		'store': parser['store'],
		'element': element,
		'lastChild': 0,
		'base': null,
		'lang': null,
		'node': null,
		'nodeType': null,
		'listIndex': 1,
		'rdfid': null,
		'datatype': null,
		'collection': false,

	/** Terminate the frame and notify the store that we're done */
		'terminateFrame': function () {
		    if (this['collection']) {
			this['node']['close']()
		    }
		},
	
	/** Add a symbol of a certain type to the this frame */
		'addSymbol': function (type, uri) {
		    uri = URIjoin(uri, this['base'])
		    this['node'] = this['store']['sym'](uri)
		    this['nodeType'] = type
		},
	
	/** Load any constructed triples into the store */
		'loadTriple': function () {
		    if (this['parent']['parent']['collection']) {
			this['parent']['parent']['node']['append'](this['node'])
		    }
		    else {
			this['store']['add'](this['parent']['parent']['node'],
				       this['parent']['node'],
				       this['node'],
				       this['parser']['why'])
		    }
		    if (this['parent']['rdfid'] != null) { // reify
			var triple = this['store']['sym'](
			    URIjoin("#"+this['parent']['rdfid'],this['base']))
			this['store']['add'](triple,
					     this['store']['sym'](
						 RDFParser['ns']['RDF']
						     +"type"),
					     this['store']['sym'](
						 RDFParser['ns']['RDF']
						     +"Statement"),
					     this['parser']['why'])
			this['store']['add'](triple,
					     this['store']['sym'](
						 RDFParser['ns']['RDF']
						     +"subject"),
					     this['parent']['parent']['node'],
					     this['parser']['why'])
			this['store']['add'](triple,
					     this['store']['sym'](
						 RDFParser['ns']['RDF']
						     +"predicate"),
					     this['parent']['node'],
					     this['parser']['why'])
			this['store']['add'](triple,
					     this['store']['sym'](
						 RDFParser['ns']['RDF']
						     +"object"),
					     this['node'],
					     this['parser']['why'])
		    }
		},

	/** Check if it's OK to load a triple */
		'isTripleToLoad': function () {
		    return (this['parent'] != null
			    && this['parent']['parent'] != null
			    && this['nodeType'] == this['NODE']
			    && this['parent']['nodeType'] == this['ARC']
			    && this['parent']['parent']['nodeType']
			    == this['NODE'])
		},

	/** Add a symbolic node to this frame */
		'addNode': function (uri) {
		    this['addSymbol'](this['NODE'],uri)
		    if (this['isTripleToLoad']()) {
			this['loadTriple']()
		    }
		},

	/** Add a collection node to this frame */
		'addCollection': function () {
		    this['nodeType'] = this['NODE']
		    this['node'] = this['store']['collection']()
		    this['collection'] = true
		    if (this['isTripleToLoad']()) {
			this['loadTriple']()
		    }
		},

	/** Add a collection arc to this frame */
		'addCollectionArc': function () {
		    this['nodeType'] = this['ARC']
		},

	/** Add a bnode to this frame */
		'addBNode': function (id) {
		    if (id != null) {
			if (this['parser']['bnodes'][id] != null) {
			    this['node'] = this['parser']['bnodes'][id]
			} else {
			    this['node'] = this['parser']['bnodes'][id] = this['store']['bnode']()
			}
		    } else { this['node'] = this['store']['bnode']() }
		    
		    this['nodeType'] = this['NODE']
		    if (this['isTripleToLoad']()) {
			this['loadTriple']()
		    }
		},

	/** Add an arc or property to this frame */
		'addArc': function (uri) {
		    if (uri == RDFParser['ns']['RDF']+"li") {
			uri = RDFParser['ns']['RDF']+"_"+this['parent']['listIndex']++
		    }
		    this['addSymbol'](this['ARC'], uri)
		},

	/** Add a literal to this frame */
		'addLiteral': function (value) {
		    if (this['parent']['datatype']) { var lang = "" }
		    else { var lang = this['lang'] }
		    this['node'] = this['store']['literal'](
			value, lang, this['parent']['datatype'])
		    this['nodeType'] = this['NODE']
		    if (this['isTripleToLoad']()) {
			this['loadTriple']()
		    }
		}
	       }
    }

    /** Our triple store reference @private */
    this['store'] = store
    /** Our identified blank nodes @private */
    this['bnodes'] = {}
    /** A context for context-aware stores @private */
    this['why'] = null
    /** Reification flag */
    this['reify'] = false
    /** Force RDF in parsing flag */
    this['forceRDF'] = false

    /**
     * Build our initial scope frame and parse the DOM into triples
     * @param {DOMTree} document The DOM to parse
     * @param {String} base The base URL to use 
     * @param {Object} why The context to which this resource belongs
     */
    this['parse'] = function (document, base, why) {
    	var children = document['childNodes']
    
    	// clean up for the next run
    	this['cleanParser']()
    	
    	// figure out the root element
    	if (document['nodeType'] == RDFParser['nodeType']['DOCUMENT']) {
    	    for (var c=0; c<children['length']; c++) {
    		if (children[c]['nodeType']
    		    == RDFParser['nodeType']['ELEMENT']) {
    		    var root = children[c]
    		    break
    		}
    	    }	    
    	}
    	else if (document['nodeType'] == RDFParser['nodeType']['ELEMENT']) {
    	    var root = document
    	}
    	else {
    	    throw new Error("RDFParser: can't find root in " + base
    			    + ". Halting. ")
    	    return false
    	}
    	
    	this['why'] = why
    
    	// we're unsure if it's RDF
    	if (!this['forceRDF']
    	    && root['namespaceURI'] != RDFParser['ns']['RDF']) {
    	    throw new Error("RDFParser: " + base
    			    + " might not be RDF. Halting. "
    			    + "Parser expected either assurance"
    			    + " of RDF or root node with namespace"
    			    + " of " + RDFParser['ns']['RDF']);
    	    return false
    	}
    
    	// our topmost frame
    
    	var f = this['frameFactory'](this)
    	f['base'] = base
    	f['lang'] = ''
    	
    	this['parseDOM'](this['buildFrame'](f,root))
    	return true
        }
        this['parseDOM'] = function (frame) {
    	// a DOM utility function used in parsing
    	var elementURI = function (el) {
    	    return el['namespaceURI'] + el['localName']
    	}
    	var dig = true // if we'll dig down in the tree on the next iter
    
    	while (frame['parent']) {
    	    var dom = frame['element']
    	    var attrs = dom['attributes']
    	    
    	    if (dom['nodeType'] == RDFParser['nodeType']['TEXT']) { // we have a literal
    	            frame['addLiteral'](dom['nodeValue'])
    	  } else if (elementURI(dom) != RDFParser['ns']['RDF']+"RDF") { // not root
                if (frame['parent'] && frame['parent']['collection']) {
        		    // we're a collection element
        		    frame['addCollectionArc']()
        		    frame = this['buildFrame'](frame,frame['element'])
        		    frame['parent']['element'] = null;
        		}
        		if (!frame['parent'] || !frame['parent']['nodeType'] || frame['parent']['nodeType'] == frame['ARC']) {
        		    // we need a node
        		    var about =dom['getAttributeNodeNS'](RDFParser['ns']['RDF'],"about");
        		    var rdfid =dom['getAttributeNodeNS'](RDFParser['ns']['RDF'],"ID");
        		    if (about && rdfid) {
            			throw new Error("RDFParser: " + dom['nodeName']
            					+ " has both rdf:id and rdf:about."
            					+ " Halting. Only one of these"
            					+ " properties may be specified on a"
            					+ " node.");
        		    }
        		    if (about == null && rdfid) {
        		        frame['addNode']("#"+rdfid['nodeValue'])
            			dom['removeAttributeNode'](rdfid)
            	    }
        		    else if (about == null && rdfid == null) {
            			var bnid = dom['getAttributeNodeNS'](
            			    RDFParser['ns']['RDF'],"nodeID")
            			if (bnid) {
                			    frame['addBNode'](bnid['nodeValue'])
                			    dom['removeAttributeNode'](bnid)
            			} else { 
            			    frame['addBNode']() 
            			}
        		    }
        		    else {
            			frame['addNode'](about['nodeValue'])
            			dom['removeAttributeNode'](about)
        		    }
        		    
        		    // Typed nodes
        		    var rdftype = dom['getAttributeNodeNS'](
        			RDFParser['ns']['RDF'],"type")
        		    if (RDFParser['ns']['RDF']+"Description" != elementURI(dom)) {
        			     rdftype = {'nodeValue': elementURI(dom)}
        		    }
        		    if (rdftype != null) {
            			this['store']['add'](frame['node'],
            					     this['store']['sym'](
            						 RDFParser['ns']['RDF']+"type"),
            					     this['store']['sym'](
            						 URIjoin(rdftype['nodeValue'],
            							 frame['base'])),
            					     this['why'])
            			if (rdftype['nodeName']){
            			    dom['removeAttributeNode'](rdftype)
            			}
        		    }
        		    // Property Attributes
        		    for (var x = attrs['length']-1; x >= 0; x--) {
        			this['store']['add'](frame['node'],
        					     this['store']['sym'](
        						 elementURI(attrs[x])),
        					     this['store']['literal'](
        						 attrs[x]['nodeValue'],
        						 frame['lang'],""),
        					     this['why'])
        		    }
        		} else { // we should add an arc (or implicit bnode+arc)
        		    frame['addArc'](elementURI(dom))
        
        		    // save the arc's rdf:ID if it has one
        		    if (this['reify']) {
            			var rdfid = dom['getAttributeNodeNS'](
            			    RDFParser['ns']['RDF'],"ID")
            			if (rdfid) {
            			    frame['rdfid'] = rdfid['nodeValue']
            			    dom['removeAttributeNode'](rdfid)
            			}
        		    }
        		    var parsetype = dom['getAttributeNodeNS'](
        			RDFParser['ns']['RDF'],"parseType")
        		    var datatype = dom['getAttributeNodeNS'](
        			RDFParser['ns']['RDF'],"datatype")
        		    if (datatype) {
            			frame['datatype'] = datatype['nodeValue']
            			dom['removeAttributeNode'](datatype)
        		    }
        
        		    if (parsetype) {
            			var nv = parsetype['nodeValue']
            			if (nv == "Literal") {
            			    frame['datatype'] = RDFParser['ns']['RDF']+"XMLLiteral"
            			    // (this.buildFrame(frame)).addLiteral(dom)
            			    // should work but doesn't
            			    frame = this['buildFrame'](frame)
            			    frame['addLiteral'](dom)
            			    dig = false
            			}
            			else if (nv == "Resource") {
            			    frame = this['buildFrame'](frame,frame['element'])
            			    frame['parent']['element'] = null
            			    frame['addBNode']()
            			}
            			else if (nv == "Collection") {
            			    frame = this['buildFrame'](frame,frame['element'])
            			    frame['parent']['element'] = null
            			    frame['addCollection']()
            			}
            			dom['removeAttributeNode'](parsetype)
        		    }
        		    if (attrs['length'] != 0) {
            			var resource = dom['getAttributeNodeNS'](
            			    RDFParser['ns']['RDF'],"resource")
            			var bnid = dom['getAttributeNodeNS'](
            			    RDFParser['ns']['RDF'],"nodeID")
            			frame = this['buildFrame'](frame)
            			if (resource) {
            			    frame['addNode'](resource['nodeValue'])
            			    dom['removeAttributeNode'](resource)
            			} else {
            			    if (bnid) {
                				frame['addBNode'](bnid['nodeValue'])
                				dom['removeAttributeNode'](bnid)
            			    } else { 
            			        frame['addBNode']() 
            			    }
            			}
            			for (var x = attrs['length']-1; x >= 0; x--) {
            			    var f = this['buildFrame'](frame)
            			    f['addArc'](elementURI(attrs[x]))
            			    if (elementURI(attrs[x]) ==RDFParser['ns']['RDF']+"type"){
            				    (this['buildFrame'](f))['addNode']( attrs[x]['nodeValue'])
            			    } else {
            				(this['buildFrame'](f))['addLiteral'](
            				    attrs[x]['nodeValue'])
            			    }
            			}
        		    }
        		    else if (dom['childNodes']['length'] == 0) {
        			     (this['buildFrame'](frame))['addLiteral']("")
        		    }
        		}
    	    } // rdf:RDF
    
    	    // dig dug
    	    dom = frame['element']
    	    while (frame['parent']) {
    		var pframe = frame
    		while (dom == null) {
    		    frame = frame['parent']
    		    dom = frame['element']
    		}
    		var candidate = dom['childNodes'][frame['lastChild']]
    		if (candidate == null || !dig) {
    		    frame['terminateFrame']()
    		    if (!(frame = frame['parent'])) { break } // done
    		    dom = frame['element']
    		    dig = true
    		}
    		else if ((candidate['nodeType']
    			  != RDFParser['nodeType']['ELEMENT']
    			  && candidate['nodeType']
    			  != RDFParser['nodeType']['TEXT'])
    			 || (candidate['nodeType']
    			     == RDFParser['nodeType']['TEXT']
    			     && dom['childNodes']['length'] != 1)) {
    		    frame['lastChild']++
    		}
    		else { // not a leaf
    		    frame['lastChild']++
    		    frame = this['buildFrame'](pframe,
    					       dom['childNodes'][frame['lastChild']-1])
    		    break
    		}
    	    }
    	} // while
    }

    /**
     * Cleans out state from a previous parse run
     * @private
     */
    this['cleanParser'] = function () {
	this['bnodes'] = {}
	this['why'] = null
    }

    /**
     * Builds scope frame 
     * @private
     */
    this['buildFrame'] = function (parent, element) {
	var frame = this['frameFactory'](this,parent,element)
	if (parent) {
	    frame['base'] = parent['base']
	    frame['lang'] = parent['lang']
	}
	if (element == null
	    || element['nodeType'] == RDFParser['nodeType']['TEXT']) {
	    return frame
	}

	var attrs = element['attributes']

	var base = element['getAttributeNode']("xml:base")
	if (base != null) {
	    frame['base'] = base['nodeValue']
	    element['removeAttribute']("xml:base")
	}
	var lang = element['getAttributeNode']("xml:lang")
	if (lang != null) {
	    frame['lang'] = lang['nodeValue']
	    element['removeAttribute']("xml:lang")
	}

	// remove all extraneous xml and xmlns attributes
	for (var x = attrs['length']-1; x >= 0; x--) {
	    if (attrs[x]['nodeName']['substr'](0,3) == "xml") {
		element['removeAttributeNode'](attrs[x])
	    }
	}
	return frame
    }
}



// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// TABULATOR URI - http://dig.csail.mit.edu/2005/ajar/ajaw/js/uri.js


//  Implementing URI-specific functions
//
//	See RFC 2386
//
// This is or was   http://www.w3.org/2005/10/ajaw/uri.js
// 2005 W3C open source licence
//
//
//  Take a URI given in relative or absolute form and a base
//  URI, and return an absolute URI
//
//  See also http://www.w3.org/2000/10/swap/uripath.py
//

if (typeof Util == "undefined") { Util = {}}
if (typeof Util.uri == "undefined") { Util.uri = {}}

Util.uri.join = function (given, base) {
    // if (typeof tabulator.log.debug != 'undefined') tabulator.log.debug("   URI given="+given+" base="+base)
    var baseHash = base.indexOf('#')
    if (baseHash > 0) base = base.slice(0, baseHash)
    if (given.length==0) return base // before chopping its filename off
    if (given.indexOf('#')==0) return base + given
    var colon = given.indexOf(':')
    if (colon >= 0) return given	// Absolute URI form overrides base URI
    var baseColon = base.indexOf(':')
    if (base == "") return given;
    if (baseColon < 0) {
        throw Error("Invalid base: "+ base + ' in join with ' +given);
        return given
    }
    var baseScheme = base.slice(0,baseColon+1)  // eg http:
    if (given.indexOf("//") == 0)     // Starts with //
	return baseScheme + given;
    if (base.indexOf('//', baseColon)==baseColon+1) {  // Any hostpart?
	    var baseSingle = base.indexOf("/", baseColon+3)
	if (baseSingle < 0) {
	    if (base.length-baseColon-3 > 0) {
		return base + "/" + given
	    } else {
		return baseScheme + given
	    }
	}
    } else {
	var baseSingle = base.indexOf("/", baseColon+1)
	if (baseSingle < 0) {
	    if (base.length-baseColon-1 > 0) {
		return base + "/" + given
	    } else {
		return baseScheme + given
	    }
	}
    }

    if (given.indexOf('/') == 0)	// starts with / but not //
	return base.slice(0, baseSingle) + given
    
    var path = base.slice(baseSingle)
    var lastSlash = path.lastIndexOf("/")
    if (lastSlash <0) return baseScheme + given
    if ((lastSlash >=0) && (lastSlash < (path.length-1)))
	path = path.slice(0, lastSlash+1) // Chop trailing filename from base
    
    path = path + given
    while (path.match(/[^\/]*\/\.\.\//)) // must apply to result of prev
	path = path.replace( /[^\/]*\/\.\.\//, '') // ECMAscript spec 7.8.5
    path = path.replace( /\.\//g, '') // spec vague on escaping
    return base.slice(0, baseSingle) + path
}

//  refTo:    Make a URI relative to a given base
//
// based on code in http://www.w3.org/2000/10/swap/uripath.py
//
Util.uri.commonHost = new RegExp("^[-_a-zA-Z0-9.]+:(//[^/]*)?/[^/]*$");
Util.uri.refTo = function(base, uri) {
    if (!base) return uri;
    if (base == uri) return "";
    var i =0; // How much are they identical?
    while (i<uri.length && i < base.length)
        if (uri[i] == base[i]) i++;
        else break;
    if (base.slice(0,i).match(Util.uri.commonHost)) {
        var k = uri.indexOf('//');
        if (k<0) k=-2; // no host
        var l = uri.indexOf('/', k+2);   // First *single* slash
        if (uri.slice(l+1, l+2) != '/' && base.slice(l+1, l+2) != '/'
                           && uri.slice(0,l) == base.slice(0,l)) // common path to single slash
            return uri.slice(l); // but no other common path segments
    }
     // fragment of base?
    if (uri.slice(i, i+1) == '#' && base.length == i) return uri.slice(i);
    while (i>0 && uri[i-1] != '/') i--;

    if (i<3) return uri; // No way
    if ((base.indexOf('//', i-2) > 0) || uri.indexOf('//', i-2) > 0)
        return uri; // an unshared '//'
    if (base.indexOf(':', i) >0) return uri; // unshared ':'
    var n = 0;
    for (var j=i; j<base.length; j++) if (base[j]=='/') n++;
    if (n==0 && i < uri.length && uri[i] =='#') return './' + uri.slice(i);
    if (n==0 && i == uri.length) return './';
    var str = '';
    for (var j=0; j<n; j++) str+= '../';
    return str + uri.slice(i);
}


/** returns URI without the frag **/
Util.uri.docpart = function (uri) {
    var i = uri.indexOf("#")
    if (i < 0) return uri
    return uri.slice(0,i)
} 

/** return the protocol of a uri **/
Util.uri.protocol = function (uri) {
    return uri.slice(0, uri.indexOf(':'))
} //protocol

URIjoin = Util.uri.join
uri_docpart = Util.uri.docpart
uri_protocol = Util.uri.protocol


//ends