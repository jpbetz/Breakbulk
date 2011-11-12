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
 * Revision:	$Id: OdoTripleNode.java 164 2007-07-31 14:11:09Z mroy $
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
 * An OdoTripleNode wraps a {@link TriplePatternNode} and allows for stateful comparison of two such nodes based on the number of free variables in each triple
 * pattern.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
class OdoTripleNode implements Comparable<OdoTripleNode> {
    private int                        varsMatched = 0;

    private final Collection<Variable> variables   = new ArrayList<Variable>();

    private final TriplePatternNode    t;

    private final TriplePattern        pattern;

    //private final IQuadStore           quadStore;

    /**
     * Constructor.
     * 
     * @param t
     */
    protected OdoTripleNode(TriplePatternNode t) {//, IQuadStore quadStore) {
        this.t = t;
        // this.quadStore = quadStore;
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

    @Override
    public String toString() {
        return this.t.toString();
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
     * @return The number of variables that have been matched via calls to #checkMatch(Variable)}
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

    private boolean isSubjectMatched   = false;

    private boolean isPredicateMatched = false;

    private boolean isObjectMatched    = false;

    /**
     * 
     * @param variable
     * @return <tt>true</tt>, if the given variable occurs in this triple pattern; <tt>false</tt>, otherwise
     */
    protected boolean checkMatch(Variable variable) {
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

    public int compareTo(OdoTripleNode otherNode) {
        if (otherNode.getTriple().equals(getTriple())) {
            return 0;
        }
        if (otherNode.getVarCount() < getVarCount()) {
            return 1;
        } else if (otherNode.getVarCount() > getVarCount()) {
            return -1;
        }

        if (otherNode.getMatchedVariableCount() > getMatchedVariableCount()) {
            return 1;
        } else if (otherNode.getMatchedVariableCount() < getMatchedVariableCount()) {
            return -1;
        } else {
            return otherNode.getTriple().toString().compareTo(getTriple().toString());
        }
        /*else if (quadStore != null) {
            long count1 = countPattern(getTriple().getTriplePattern());
            long count2 = countPattern(otherNode.getTriple().getTriplePattern());
            int r = (count1 == count2) ? 0 : (count1 > count2) ? 1 : -1;
            if (r == 0) {
                return otherNode.getTriple().toString().compareTo(getTriple().toString());
            } else {
                return r;
            }
        } else {
            return otherNode.getTriple().toString().compareTo(getTriple().toString());
        }
        else if (getUnMatchedVariableCount() > 0) {
            Collection<Variable> vars = getVariables();
            Collection<Variable> vars2 = otherNode.getVariables();
            Iterator<Variable> iter = vars.iterator();
            Iterator<Variable> iter2 = vars2.iterator();
            while (iter.hasNext()) {
                Variable var1 = iter.next();
                Variable var2 = (iter2.hasNext()) ? iter2.next() : null;
                int r = var1.compareTo(var2);
                if (r != 0) {
                    return r;
                }
            }
        }*/
    }
    /*
        private long countPattern(TriplePattern tp) {
            TriplePatternComponent s = tp.getSubject();
            TriplePatternComponent p = tp.getPredicate();
            TriplePatternComponent o = tp.getObject();

            Resource subj = (s != null && s instanceof Resource) ? (Resource) s : null;
            URI pred = (p != null && p instanceof URI) ? (URI) p : null;
            Value obj = (o != null && o instanceof Value) ? (Value) o : null;
            return quadStore.count(subj, pred, obj, (URI[]) null);
        }*/
}
