/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/planning/Attic/OdoTripleNode.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Feb 8, 2007
 * Revision:	$Id: TripleNode.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.planning;

import java.util.ArrayList;
import java.util.Collection;

import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.Variable;

/**
 * An {@link TripleNode} wraps a {@link TriplePatternNode} and allows for stateful comparison of two such nodes based on the number of free variables in each
 * triple pattern.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class TripleNode implements Comparable<TripleNode> {
    private int                        varsMatched        = 0;

    private final Collection<Variable> variables          = new ArrayList<Variable>();

    private final TriplePatternNode    t;

    private final TriplePattern        pattern;

    private boolean                    isSubjectMatched   = false;

    private boolean                    isPredicateMatched = false;

    private boolean                    isObjectMatched    = false;

    /**
     * Constructor.
     * 
     * @param t
     */
    protected TripleNode(TriplePatternNode t) {
        this.t = t;
        this.pattern = t.getTriplePattern();
        if (this.pattern.getSubject() instanceof Variable) {
            this.variables.add((Variable) this.pattern.getSubject());
        }
        if (this.pattern.getPredicate() instanceof Variable) {
            this.variables.add((Variable) this.pattern.getPredicate());
        }
        if (this.pattern.getObject() instanceof Variable) {
            this.variables.add((Variable) this.pattern.getObject());
        }
    }

    /**
     * 
     * @return The {@link TriplePatternNode} corresponding to this object.
     */
    public TriplePatternNode getTriple() {
        return this.t;
    }

    /**
     * 
     * @return The number of variables in this triple pattern
     */
    public int getVarCount() {
        return this.variables.size();
    }

    /**
     * 
     * @return The variables in this triple pattern
     */
    public Collection<Variable> getVariables() {
        return this.variables;
    }

    @SuppressWarnings("all")
    /**
     * 
     * @return The number of variables that have been matched via calls to {@link #checkMatch(Variable)}
     */
    public int getMatchedVariableCount() {
        return this.varsMatched;
    }

    @SuppressWarnings("all")
    /**
     * 
     * @return The number of variables in this triple pattern not yet matched via calls to {@link #checkMatch(Variable)}
     */
    public int getUnMatchedVariableCount() {
        return this.variables.size() - this.varsMatched;
    }

    /**
     * Checks this {@link TripleNode} against the supplied triple node to see if they contain variables in common.
     * 
     * @param node
     */
    protected void buildMatch(TripleNode node) {
        if (this.pattern.getSubject() instanceof Variable) {
            if (node.checkMatch((Variable) this.pattern.getSubject())) {
                if (this.isSubjectMatched == false) {
                    this.isSubjectMatched = true;
                    this.varsMatched++;
                }
            }
        }

        if (this.pattern.getPredicate() instanceof Variable) {
            if (node.checkMatch((Variable) this.pattern.getPredicate())) {
                if (this.isPredicateMatched == false) {
                    this.isPredicateMatched = true;
                    this.varsMatched++;
                }
            }

        }

        if (this.pattern.getObject() instanceof Variable) {
            if (node.checkMatch((Variable) this.pattern.getObject())) {
                if (this.isObjectMatched == false) {
                    this.isObjectMatched = true;
                    this.varsMatched++;
                }
            }

        }
    }

    /**
     * 
     * @param variable
     * @return <tt>true</tt>, if the given variable occurs in this triple pattern and the match hasn't been noted before; <tt>false</tt>, otherwise
     */
    private boolean checkMatch(Variable variable) {
        boolean changed = false;
        if (this.pattern.getSubject().equals(variable)) {
            if (this.isSubjectMatched == false) {
                this.isSubjectMatched = true;
                this.varsMatched++;
                changed = true;
            }
        }
        if (this.pattern.getPredicate().equals(variable)) {
            if (this.isPredicateMatched == false) {
                this.isPredicateMatched = true;
                this.varsMatched++;
                changed = true;
            }
        }
        if (this.pattern.getObject().equals(variable)) {
            if (this.isObjectMatched == false) {
                this.isObjectMatched = true;
                this.varsMatched++;
                changed = true;
            }
        }
        return changed;
    }

    public int compareTo(TripleNode otherNode) {
        if (otherNode.getTriple().equals(getTriple())) {
            return 0;
        }

        /*if (otherNode.getVarCount() > getVarCount()) {
        	return 1;
        } else if (otherNode.getVarCount() < getVarCount()) {
        	return -1;
        }
        */
        if (otherNode.getMatchedVariableCount() > getMatchedVariableCount()) {
            return 1;
        } else if (otherNode.getMatchedVariableCount() < getMatchedVariableCount()) {
            return -1;
        }
        if (otherNode.getUnMatchedVariableCount() > getUnMatchedVariableCount()) {
            return -1;
        } else if (otherNode.getUnMatchedVariableCount() < getUnMatchedVariableCount()) {
            return 1;
        }

        if (otherNode.hashCode() < this.hashCode()) {
            return 1;
        } else if (otherNode.hashCode() > this.hashCode()) {
            return -1;
        } else {
            return 0;
        }
    }
}
