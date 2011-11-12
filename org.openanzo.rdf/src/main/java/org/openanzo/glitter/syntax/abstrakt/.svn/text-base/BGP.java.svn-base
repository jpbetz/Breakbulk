/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/BGP.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: BGP.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;

/**
 * A SPARQL basic graph pattern. Logically, a {@link BGP} is an ordered list of triple patterns and possibly a {@link FunctionalPredicate}.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class BGP extends GraphPattern {
    protected List<TriplePatternNode> triples;

    private FunctionalPredicate       functionalPredicate = null;

    /**
     * Default constructor.
     */
    public BGP() {
        this.triples = new ArrayList<TriplePatternNode>();
        for (TriplePatternNode tpn : this.triples)
            tpn.setParent(this);
    }

    /**
     * Construct a BGP from an array of triple patterns.
     * 
     * @param triples
     */
    public BGP(TriplePatternNode[] triples) {
        this.triples = Arrays.asList(triples);
        for (TriplePatternNode tpn : this.triples)
            tpn.setParent(this);
    }

    /**
     * Construct a BGP from a list of triple patterns.
     * 
     * @param triples
     */
    public BGP(ArrayList<TriplePatternNode> triples) {
        this.triples = triples;
        for (TriplePatternNode tpn : this.triples)
            tpn.setParent(this);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.triples.size(); i++) {
            if (i > 0)
                s += ". ";
            s += this.triples.get(i);
        }
        return s;
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        for (int i = 0; i < this.triples.size(); i++) {
            TriplePatternNode tpn = this.triples.get(i);
            if (i > 0) {
                s.append(". ");
                QueryController.printSeparator(printFlags, indentLevel, s);
            }
            tpn.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
        }
    }

    /**
     * Add a new triple pattern to this BGP.
     * 
     * @param tp
     */
    public void addTriplePattern(TriplePatternNode tp) {
        this.triples.add(tp);
        tp.setParent(this);
    }

    /**
     * @return An iterable collection of the triple patterns that comprise this BGP.
     */
    public List<TriplePatternNode> getTriplePatterns() {
        return this.triples;
    }

    /**
     * 
     * @return A {@link FunctionalPredicate} captured by this basic graph pattern.
     */
    public FunctionalPredicate getFunctionalPredicate() {
        return this.functionalPredicate;
    }

    /**
     * @param fp
     *            Sets a functional predicate for this BGP.
     */
    public void setFunctionalPredicate(FunctionalPredicate fp) {
        this.functionalPredicate = fp;
    }

    @Override
    public List<TriplePatternNode> getChildren() {
        return this.triples;
    }

    @Override
    public boolean replaceChild(TreeNode oldChild, TreeNode newChild) {
        for (ListIterator<TriplePatternNode> it = this.triples.listIterator(); it.hasNext();) {
            TriplePatternNode cur = it.next();
            if (cur == oldChild) {
                oldChild.setParent(null);
                newChild.setParent(this);
                it.set((TriplePatternNode) newChild);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeChild(TreeNode child) {
        return this.triples.remove(child);
    }

    @Override
    public void addChild(TreeNode child) {
        if (child instanceof TriplePatternNode) {
            this.triples.add((TriplePatternNode) child);
            child.setParent(this);
        } else
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.ONLY_TP_BGP);
    }

    @Override
    public BGP clone() {
        BGP bgp = new BGP();

        for (TriplePatternNode triple : this.triples) {
            bgp.addTriplePattern(triple.clone());
        }
        bgp.functionalPredicate = this.functionalPredicate;

        return bgp;
    }
}
