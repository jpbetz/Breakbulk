/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/TriplePatternNode.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: TriplePatternNode.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * A {@link TriplePatternNode} is any node in the abstract syntax that represents a triple pattern (contains three {@link TriplePatternComponent}s).
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class TriplePatternNode extends GraphPattern {
    private final TriplePattern triplePattern;

    /**
     * Constructor from three triple pattern components.
     * 
     * @param s
     *            Subject
     * @param p
     *            Predicate
     * @param o
     *            Object
     */
    public TriplePatternNode(TriplePatternComponent s, TriplePatternComponent p, TriplePatternComponent o) {
        this.triplePattern = new TriplePattern(s, p, o);
    }

    /**
     * Construct from an existing {@link TriplePattern}.
     * 
     * @param tp
     */
    public TriplePatternNode(TriplePattern tp) {
        this.triplePattern = tp;
    }

    @Override
    public String toString() {
        return this.triplePattern.toString();
    }

    /**
     * 
     * @return The {@link TriplePattern} for this node.
     */
    public TriplePattern getTriplePattern() {
        return this.triplePattern;
    }

    @Override
    protected Map<Variable, Integer> getVariableCount(boolean onlyBindableVariables) {
        TriplePatternComponent s = this.triplePattern.getSubject(), p = this.triplePattern.getPredicate(), o = this.triplePattern.getObject();
        HashMap<Variable, Integer> vars = new HashMap<Variable, Integer>();
        if (s instanceof Variable)
            incrementVariableCount(vars, (Variable) s, 1);
        if (p instanceof Variable)
            incrementVariableCount(vars, (Variable) p, 1);
        if (o instanceof Variable)
            incrementVariableCount(vars, (Variable) o, 1);
        return vars;
    }

    @Override
    public Collection<URI> getReferencedURIs() {
        TriplePatternComponent s = this.triplePattern.getSubject(), p = this.triplePattern.getPredicate(), o = this.triplePattern.getObject();
        HashSet<URI> uris = new HashSet<URI>();
        if (s instanceof URI)
            uris.add((URI) s);
        if (p instanceof URI)
            uris.add((URI) p);
        if (o instanceof URI)
            uris.add((URI) o);
        return uris;
    }

    @Override
    public List<TreeNode> getChildren() {
        return Collections.<TreeNode> emptyList();
    }

    @Override
    public boolean replaceChild(TreeNode oldChild, TreeNode newChild) {
        return false;
    }

    @Override
    public boolean removeChild(TreeNode child) {
        throw new GlitterRuntimeException(ExceptionConstants.GLITTER.NO_REMOVE_CHILD, this.getClass().getName());
    }

    @Override
    public void addChild(TreeNode child) {
        throw new GlitterRuntimeException(ExceptionConstants.GLITTER.NO_ADD_CHILD, this.getClass().getName());
    }

    @Override
    public TriplePatternNode clone() {
        return new TriplePatternNode(triplePattern.getSubject(), triplePattern.getPredicate(), triplePattern.getObject());
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        QueryController.printTriplePatternComponent(this.triplePattern.getSubject(), printFlags, uri2prefix, s);
        s.append(' ');
        QueryController.printTriplePatternComponent(this.triplePattern.getPredicate(), printFlags, uri2prefix, s);
        s.append(' ');
        QueryController.printTriplePatternComponent(this.triplePattern.getObject(), printFlags, uri2prefix, s);
    }

    @Override
    public void prettyPrint(StringBuilder output, boolean deep) {
        output.append(this.getClass().getSimpleName());
        output.append("(");
        output.append(triplePattern.toString());
        output.append(")");
    }
}
