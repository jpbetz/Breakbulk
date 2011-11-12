/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/Optional.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Optional.java 198 2007-08-01 16:25:33Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * Represents an OPTIONAL pattern in a SPARQL query, which consists possibly of a pattern that must match the underlying data, and a pattern that optionally
 * might match the underlying data.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Optional extends GraphPattern {
    /*
     * binary operator modeling:
     */
    private GraphPattern        mustMatch;

    private GraphPattern        mayMatch;

    // these filters only affect whether mayMatch can extend mustMatch, but
    // they are evaluated against solutions that join solutions of mustMatch
    // with solutions of mayMatch
    private HashSet<Expression> filters;

    @Override
    public Optional clone() {
        return new Optional(this.mustMatch != null ? (GraphPattern) this.mustMatch.clone() : null, (GraphPattern) this.mayMatch.clone(), this.filters);
    }

    /**
     * Constructs an {@link Optional} from a pattern that must match, one that optionally matches, and a collection of filter expressions.
     * 
     * @param mustMatch
     * @param mayMatch
     * @param filters
     */
    protected Optional(GraphPattern mustMatch, GraphPattern mayMatch, Iterable<Expression> filters) {
        this.mustMatch = mustMatch;
        this.mayMatch = mayMatch;
        this.filters = new HashSet<Expression>();
        for (Expression e : filters)
            this.filters.add(e);

        if (this.mustMatch != null)
            this.mustMatch.setParent(this);
        this.mayMatch.setParent(this);
    }

    /**
     * Constructs an {@link Optional} only from an optional pattern.
     * 
     * @param mayMatch
     */
    public Optional(GraphPattern mayMatch) {
        this.mustMatch = null;
        this.mayMatch = mayMatch;
        this.filters = new HashSet<Expression>();

        this.mayMatch.setParent(this);
    }

    @Override
    public String toString() {
        return (this.mustMatch != null ? this.mustMatch : "") + " OPTIONAL { " + this.mayMatch + " }";
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        if (this.mustMatch != null) {
            this.mustMatch.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
            s.append(". ");
            QueryController.printSeparator(printFlags, indentLevel, s);
        }
        s.append("OPTIONAL {");
        indentLevel++;
        QueryController.printSeparator(printFlags, indentLevel, s);
        this.mayMatch.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
        indentLevel--;
        QueryController.printSeparator(printFlags, indentLevel, s);
        s.append("}");
    }

    @Override
    public List<GraphPattern> getChildren() {
        ArrayList<GraphPattern> ar = new ArrayList<GraphPattern>();
        ar.add(mustMatch);
        ar.add(mayMatch);
        return ar;
    }

    /**
     * 
     * @return The required part of the OPTIONAL.
     */
    public GraphPattern getMustMatchPattern() {
        return this.mustMatch;
    }

    /**
     * 
     * @return The optional part of the OPTIONAL
     */
    public GraphPattern getMayMatchPattern() {
        return this.mayMatch;
    }

    @Override
    public java.util.Set<Expression> getFilters() {
        return this.filters;
    }

    @Override
    public boolean replaceChild(TreeNode oldChild, TreeNode newChild) {
        if (newChild instanceof GraphPattern) {
            if (oldChild == this.mustMatch) {
                if (oldChild != null)
                    oldChild.setParent(null);
                this.mustMatch = (GraphPattern) newChild;
                return true;
            } else if (oldChild == this.mayMatch) {
                newChild.setParent(this);
                oldChild.setParent(null);
                this.mayMatch = (GraphPattern) newChild;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if (child == this.mustMatch) {
            this.mustMatch = null;
            return true;
        }
        return false;
    }

    @Override
    public void addChild(TreeNode child) {
        if (child instanceof BGP) {
            BGP bgp = (BGP) child;
            if (bgp.getFunctionalPredicate() != null) {
                if (this.mustMatch instanceof BGP) {
                    ((BGP) this.mustMatch).setFunctionalPredicate(bgp.getFunctionalPredicate());
                    child.setParent(this);
                }
                return;
            }
        }
        throw new GlitterRuntimeException(ExceptionConstants.GLITTER.NO_ADD_CHILD, this.getClass().getName());
    }

    @Override
    protected Map<Variable, Integer> getVariableCount(boolean onlyBindableVariables) {
        Map<Variable, Integer> vars = super.getVariableCount(onlyBindableVariables);
        // if we want all variables, regardless of whether they can be bound to,
        // we also include variables occuring inside filters
        if (!onlyBindableVariables)
            for (Expression e : this.filters)
                for (Variable v : e.getReferencedVariables())
                    incrementVariableCount(vars, v, 1);
        return vars;
    }

    @Override
    public Collection<URI> getReferencedURIs() {
        Collection<URI> uris = super.getReferencedURIs();
        for (Expression e : this.filters)
            uris.addAll(e.getReferencedURIs());
        return uris;
    }
}
