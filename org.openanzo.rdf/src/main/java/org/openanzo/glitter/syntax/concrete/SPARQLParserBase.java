/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/concrete/SPARQLParserBase.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: SPARQLParserBase.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.concrete;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.exception.StringLiteralException;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.SubqueryController;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.BlankNodeManager;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.MemVariable;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.vocabulary.RDF;

/**
 * The base class for SPARQL parsers generated from a JavaCC grammar.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
abstract public class SPARQLParserBase {

    private BlankNodeManager      blankNodeManager;

    private Stack<QueryController> queryControllers;

    private Map<String, Variable> variables;

    /**
     * Default constructor.
     */
    public SPARQLParserBase() {
        this.blankNodeManager = new BlankNodeManager(true);
        this.queryControllers = new Stack<QueryController>();
        this.queryControllers.push(new QueryController());
        this.variables = new HashMap<String, Variable>();
    }

    /**
     * Define a new scope which will have a new set of blank nodes. Pushes the new scope onto a stack. Should be paired with {@link #exitGroupScope()}
     */
    public void enterGroupScope() {
        this.blankNodeManager.enterLabelScope();
    }

    /**
     * Ends a blank node label scope. Should be paired with {@link #exitGroupScope()}
     */
    public void exitGroupScope() {
        this.blankNodeManager.exitLabelScope();
    }

    /**
     *
     * @return A {@link BlankNodeManager} for the current group scope.
     */
    public BlankNodeManager getBlankNodeManager() {
        return this.blankNodeManager;
    }

    /**
     *
     * @return The {@link QueryController} for the query currently being parsed
     */
    public QueryController getQueryController() {
        return this.queryControllers.peek();
    }

    /**
     * Begins a new subquery, meaning that subsequent calls to getQueryController will return
     * a new controller for the subquery.
     *
     * @return The controller for the new subquery
     */
    public SubqueryController enterSubquery() {
        SubqueryController qc = new SubqueryController(getQueryController());
        this.queryControllers.push(qc);
        return qc;
    }

    /**
     * Ends the current subquery, meaning that subsequent calls to getQueryController will return
     * the parent controller of the completed subquery
     *
     */
    public void exitSubquery() {
        this.queryControllers.pop();
    }

    /**
     * This accessor ensures that all variables with the same name will share the same {@link Variable} reference.
     *
     * @param name
     *            name of variable to get
     * @return {@link Variable} for the given name
     */
    public Variable getVariable(String name) {
        Variable v = this.variables.get(name);
        if (v == null) {
            v = MemVariable.createVariable(name);
            this.variables.put(name, v);
        }
        return v;
    }

    /**
     * (1) Strip quotes from the beginning and end of the string. (2) perform the following substitutions (a) \\uHHHH -> unicode code point at hex value HHHH
     * (b) \UHHHHHHHH -> unicode code point at hex value HHHHHHHH (c) \t -> U+0009 (tab) (d) \n -> U+000A (line feed) (e) \r -> U+000D (carriage return) (f) \b
     * -> U+0008 (backspace) (g) \f -> U+000C (form feed) (h) \" -> U+0022 (quotation mark, double quote mark) (i) \' -> U+0027 (apostrophe-quote, single quote
     * mark) (j) \\ -> U+005C (backslash)
     *
     * @param s
     *            The lexical representation of the string from within a query.
     * @return The value of the lexical representation.
     * @throws StringLiteralException
     */
    public String evaluateStringLiteral(String s) throws StringLiteralException {
        // (1)
        int quoteLength = 1;
        if (s.length() >= 3 && (s.substring(0, 3).equals("'''") || s.substring(0, 3).equals("\"\"\"")))
            quoteLength = 3;
        s = s.substring(quoteLength, s.length() - quoteLength);
        // (2)
        StringBuilder buf = new StringBuilder(s.length());
        int startIndex = 0;
        int nextEscape, codePoint;
        int sourceLength = s.length(); // cache
        while (true) {
            // if we're at the end of the string, then we're done
            if (startIndex >= sourceLength)
                break;
            nextEscape = s.indexOf("\\", startIndex);
            // we're done when we have no more escape characters
            // to process
            if (nextEscape == -1) {
                // add on the rest of the source string
                buf.append(s.substring(startIndex));
                break;
            }
            // there better be at least one more character in the
            // string
            if (nextEscape + 1 >= sourceLength)
                throw new StringLiteralException("invalid escape character at end of string literal");
            // add everything between the start index and the escape
            buf.append(s.substring(startIndex, nextEscape));
            startIndex = nextEscape + 2; // character after \X
            switch (s.charAt(nextEscape + 1)) {
            case 'u':
                // in this case, we better have an additional
                // 4 hex characters coming our way
                if (startIndex + 3 >= sourceLength)
                    throw new StringLiteralException("invalid Unicode escape sequence: \\u must be followed by four hex characters");
                codePoint = string2hex(s.substring(startIndex, startIndex + 4));
                buf.append((char) codePoint);
                startIndex += 4;
                break;
            case 'U':
                // in this case, we better have an additional
                // 8 hex characters coming our way
                if (startIndex + 7 >= sourceLength)
                    throw new StringLiteralException("invalid Unicode escape sequence: \\u must be followed by seven hex characters");
                codePoint = string2hex(s.substring(startIndex, startIndex + 8));
                buf.append((char) codePoint);
                startIndex += 8;
                break;
            case 't':
                buf.append('\t');
                break;
            case 'n':
                buf.append('\n');
                break;
            case 'r':
                buf.append('\r');
                break;
            case 'b':
                buf.append('\b');
                break;
            case 'f':
                buf.append('\f');
                break;
            case '"':
                buf.append('\"');
                break;
            case '\'':
                buf.append('\'');
                break;
            case '\\':
                buf.append('\\');
                break;
            default:
                throw new StringLiteralException("Unrecognized escape sequence");
            }
        }
        return buf.toString();
    }

    // helpers
    static int string2hex(String s) {
        return Integer.parseInt(s, 16);
    }

    protected TriplePatternComponent nodes2collection(ArrayList<TriplePatternComponent> nodes) throws ParseException {
        ArrayList<TriplePatternNode> fake = new ArrayList<TriplePatternNode>();
        return nodes2collection(nodes, fake);
    }

    protected TriplePatternComponent nodes2collection(ArrayList<TriplePatternComponent> nodes, ArrayList<TriplePatternNode> triples) throws ParseException {
        if (nodes.size() == 0)
            return RDF.nil;
        BlankNodeManager bnm = getBlankNodeManager();
        BlankNode root = null, current = null, last = null;
        TriplePatternComponent currentValue;
        for (int i = 0; i < nodes.size(); i++) {
            current = bnm.getBlankNode();
            if (root == null)
                root = current;
            currentValue = nodes.get(i);
            // add an rdf:first link to the current value
            triples.add(new TriplePatternNode(current, RDF.first, currentValue));
            if (last != null)
                triples.add(new TriplePatternNode(last, RDF.rest, current));
            last = current;
        }
        // add the nil cap at the end of the list
        triples.add(new TriplePatternNode(last, RDF.rest, RDF.nil));
        return root;
    }

    protected static Number negate(Number n) {
        if (n instanceof BigDecimal) {
            return ((BigDecimal) n).negate();
        } else if (n instanceof BigInteger) {
            return ((BigInteger) n).negate();
        } else if (n instanceof Byte) {
            return Byte.valueOf((byte) (n.byteValue() * -1));
        } else if (n instanceof Double) {
            return Double.valueOf(n.doubleValue() * -1);
        } else if (n instanceof Float) {
            return Float.valueOf(n.floatValue() * -1);
        } else if (n instanceof Integer) {
            return Integer.valueOf(n.intValue() * -1);
        } else if (n instanceof Long) {
            return Long.valueOf(n.longValue() * -1);
        } else if (n instanceof Short) {
            return Short.valueOf((short) (n.shortValue() * -1));
        }
        throw new GlitterRuntimeException(ExceptionConstants.GLITTER.NO_NEGATE, n.toString());
    }

    protected static java.net.URI token2uri(Token t) throws ParseException {
        return java.net.URI.create(t.image.substring(1, t.image.length() - 1));
    }

    protected static org.openanzo.rdf.URI createUri(String s) throws ParseException {
        return MemURI.create(s);
    }
}
