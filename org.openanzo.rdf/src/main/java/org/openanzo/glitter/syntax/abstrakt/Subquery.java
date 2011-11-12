/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/Group.java,v $
 * Created by:  Lee Feigenbaum
 * Created on: 10/23/06
 * Revision: $Id: Group.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.Projection;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryType;
import org.openanzo.glitter.query.SubqueryController;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Subquery extends GraphPattern {

    private SubqueryController subquery;

    private Projection         projection;

    @Override
    public Subquery clone() {
        return new Subquery(this.subquery);
    }

    /**
     * 
     * @param subquery
     */
    public Subquery(SubqueryController subquery) {
        // to be part of our query tree, a subquery must return a result set
        if (subquery.getQueryType() != QueryType.SELECT)
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.UNEXPECTED, "Subqueries in the query tree must be SELECT queries");
        this.subquery = subquery;
        this.subquery.getQueryPattern().setParent(this);
        this.projection = (Projection) this.subquery.getQueryResultForm();
    }

    /**
     * @return the subquery controller for this subquery node
     */
    public SubqueryController getSubqueryController() {
        return this.subquery;
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        s.append("{");
        indentLevel++;
        QueryController.printSeparator(printFlags, indentLevel, s);
        this.subquery.prettyPrintQueryStringPart(printFlags, indentLevel, s);
        indentLevel--;
        QueryController.printSeparator(printFlags, indentLevel, s);
        s.append("}");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        builder.append(this.subquery.getQueryString(true));
        builder.append(" }");
        return builder.toString();
    }

    @Override
    public List<GraphPattern> getChildren() {
        return Collections.<GraphPattern> singletonList(this.subquery.getQueryPattern());
    }

    @Override
    public boolean replaceChild(TreeNode oldChild, TreeNode newChild) {
        if (oldChild == this.subquery.getQueryPattern() && newChild instanceof GraphPattern) {
            newChild.setParent(this);
            oldChild.setParent(null);
            this.subquery.setQueryPattern((GraphPattern) newChild);
            return true;
        }
        return false;
    }

    @Override
    protected Map<Variable, Integer> getVariableCount(boolean onlyBindableVariables) {
        // from the point of view of a subquery, we just look at the projected variables
        Map<Variable, Integer> vars = new HashMap<Variable, Integer>();
        for (Variable v : this.projection.getResultVariables())
            vars.put(v, 1);
        return vars;
    }

    @Override
    public Collection<URI> getReferencedURIs() {
        Collection<URI> uris = super.getReferencedURIs();
        for (Expression e : this.projection.getProjectedExpressions())
            uris.addAll(e.getReferencedURIs());
        return uris;
    }

    @Override
    public boolean removeChild(TreeNode child) {
        // a subquery must always have a single child
        return false;
    }

    @Override
    public void addChild(TreeNode child) {
        throw new GlitterRuntimeException(ExceptionConstants.GLITTER.NO_ADD_CHILD, this.getClass().getName());
    }

    @Override
    public void prettyPrint(StringBuilder output, boolean deep) {
        if (!deep) {
            output.append("Subquery(...)");
        } else {
            output.append("Subquery(");
            this.subquery.prettyPrint(output);
            output.append(")");
        }
    }
}
