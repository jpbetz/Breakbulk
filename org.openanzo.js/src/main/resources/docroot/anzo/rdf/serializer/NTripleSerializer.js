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
 
dojo.provide('anzo.rdf.serializer.NTripleSerializer');

(function() {

anzo.rdf.serializer.NTripleSerializer.serialize = function NTripleSerialize(graph) {
    
    // summary: Serializes the statements of the given graph into N-triple format.
    
    // graph: anzo.rdf.INamedGraph
    //   The graph containing the statements that are to be serialized.
    
    // returns: String
    //   String containing the N-triple serialization of the statements in the given graph.
    
    var bnodeIdToBNodeLabelMap = { };
    var bnodeLabelCounter = { count: 1 };
    
    var buf = [];
    var stmts = graph.find();
    for (var i = 0; i < stmts.length; i++) {
        var stmt = stmts[i];
        var tripleStr = ''; // use a temporary string per triple for efficiency. This way we avoid copying of the entire string less often.
        
        if (stmt.subject instanceof anzo.rdf.BNode) {
            var bnodeLabel = _generateBNodeLabel(stmt.subject, bnodeIdToBNodeLabelMap, bnodeLabelCounter);
            tripleStr += '_:' + bnodeLabel + ' ';
        } else if (stmt.subject instanceof anzo.rdf.URI) {
            tripleStr += '<' + _escapeNTriplesString(stmt.subject.toString()) + '> ';
        }
        
        tripleStr += '<' + _escapeNTriplesString(stmt.predicate.toString()) + '> ';
        
        if (stmt.object instanceof anzo.rdf.BNode) {
            var bnodeLabel = _generateBNodeLabel(stmt.object, bnodeIdToBNodeLabelMap, bnodeLabelCounter);
            tripleStr += '_:' + bnodeLabel;
        } else if (stmt.object instanceof anzo.rdf.URI) {
            tripleStr += '<' + _escapeNTriplesString(stmt.object.toString()) + '>';
        } else if (stmt.object instanceof anzo.rdf.Literal) {
            tripleStr += '"' + _escapeNTriplesString(stmt.object.toString()) + '"';
            if (stmt.object.datatype) 
                tripleStr += "^^<" + _escapeNTriplesString(stmt.object.datatype) + ">";
            if (stmt.object.language)
                tripleStr += "@" + stmt.object.language;
        }
        
        tripleStr += ' .\n';
        
        buf.push(tripleStr);
    }
    
    return buf.join("");
}

function _generateBNodeLabel(bnode, bnodeIdToBNodeLabelMap, bnodeLabelCounter) {
    // summary: Gets a label string for the suitable for use in an N-Triples document. It keeps track
    //   of the bnodes already seen in the bnodeIdToBNodeLabelMap and will return the same label if
    //   the bnode has already been assigned a label.
    // description:   
    //  The anzo API allows members to supply any string ID for creating BNodes. This means that the BNode
    //  IDs can't be trusted to have the appropriate format for N-Triples BNode labels which is
    //  [A-Za-z][A-Za-z0-9]* as per http://www.w3.org/TR/rdf-testcases/#ntriples. So we have to generate
    //  the labels ourselves. We'll do that by keeping a counter and keep track of the labels we've
    //  generated so that we can pull them up when we run into the same BNode again.
    // returns: String label for given bnode  
    var bnodeKey = bnode.dictionaryKey();
    var bnodeLabel = bnodeIdToBNodeLabelMap[bnodeKey];
    if (!bnodeLabel) {
        bnodeLabel = "bnode" + bnodeLabelCounter.count;
        bnodeIdToBNodeLabelMap[bnodeKey] = bnodeLabel;
        bnodeLabelCounter.count++;
    }
    return bnodeLabel;
}

function _escapeNTriplesString(str) {
    // summary: escapes the given string per the rules described in the N-Triples format
    //  at http://www.w3.org/TR/rdf-testcases/#ntrip_strings

    var UTF_SURROGATE_OFFSET = 0x10000 - (0xD800 << 10) - 0xDC00;

    var ret = null;
    var buf = [];
    var len = str.length;
    var currStart = 0;
    for (var i = 0; i < len; i++) {
        var currCharCode = str.charCodeAt(i);
        if (currCharCode == 0x9) { // tab
            buf.push(str.substring(currStart, i));
            buf.push("\\t");
            currStart = i + 1;
        } else if (currCharCode == 0xA) { // newline
            buf.push(str.substring(currStart, i));
            buf.push("\\n");
            currStart = i + 1;
        } else if (currCharCode == 0xD) { // carriage return
            buf.push(str.substring(currStart, i));
            buf.push("\\r");
            currStart = i + 1;
        } else if (currCharCode == 0x22) { // double quote: "
            buf.push(str.substring(currStart, i));
            buf.push('\\"');
            currStart = i + 1;
        } else if (currCharCode == 0x5C) { // backslash
            buf.push(str.substring(currStart, i));
            buf.push("\\\\");
            currStart = i + 1;
        } else if (currCharCode < 0x20 || (currCharCode > 0x7E && currCharCode < 0xD800) || (currCharCode > 0xDFFF && currCharCode <= 0xFFFF)) {
            // Unicode characters that should be escapes with a lower u unicode escape sequence such as \u33BE.
            // This includes any characters other than those between 0x20 and 0x7E and stopping at 0xFFFF.
            // JavaScript strings are UTF-16 strings so we also skip the range from 0xD800 to 0xDFFF which is the
            // range set aside in UTF-16 for surrogate pairs to encode characters with code point greater than U+FFFF.
            buf.push(str.substring(currStart, i));
            var hexStr = currCharCode.toString(16).toUpperCase();
            for(var j = hexStr.length; j < 4; j++) { // Ensure there are 4 hex digits by adding 0 prefixes
                hexStr = "0" + hexStr;
            }
            buf.push("\\u" + hexStr);  
            currStart = i + 1;
        } else if (currCharCode >= 0xD800 && currCharCode <= 0xDFFF) {
            // This charaacter is part of a UTF-16 surrogate pair, so escape the two characters as
            // a capital U unicode escape sequence such as \U000122FA.
            if (i + 1 >= len) {
                throw new Error("Surrogate pair character found at position " + i + " but string ended without the second character in the pair.");
            } 
            buf.push(str.substring(currStart, i));
            var nextCharCode = str.charCodeAt(i + 1);
            var codepoint = (currCharCode << 10) + nextCharCode + UTF_SURROGATE_OFFSET;
            var hexStr = codepoint.toString(16).toUpperCase();
            for (var j = hexStr.length; j < 8; j++) { // Ensure there are 4 hex digits by adding 0 prefixes
                hexStr = "0" + hexStr;
            }
            buf.push("\\U" + hexStr);  
            currStart = i + 2;
            i++;
        }
    }
    
    if (buf.length <= 0) {
        // There were no escape sequences so just return the full substring as-is. 
        ret = str;
    } else {
        if (currStart < len) {
            // Catch any leftover characters since the last escape sequence.
            buf.push(str.substring(currStart, len));
        }
        ret = buf.join("");
    }
    return ret;
}

})();
