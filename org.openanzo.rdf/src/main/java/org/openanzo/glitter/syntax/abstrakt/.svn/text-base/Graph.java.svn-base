/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/Graph.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Graph.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * {@link Graph} represents a GRAPH statement in a query.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Graph extends GraphPattern {
    // TODO - should this just be a parent of the other AST nodes
    // (as opposed to right now wherein we have it be a direct parent
    // of the leaf nodes
    private final TriplePatternComponent graph;

    private GraphPattern                 pattern;

    /**
     * Constructs a {@link Graph} from either a {@link Variable} or an {@link URI} representing the named graph, and a {@link GraphPattern} representing the
     * contents of the GRAPH clause.
     * 
     * @param graph
     * @param pattern
     */
    public Graph(TriplePatternComponent graph, GraphPattern pattern) {
        this.graph = graph;
        this.pattern = pattern;

        checkForEmptyPattern();
        this.pattern.setParent(this);
    }

    private void checkForEmptyPattern() {
        if (this.pattern == null) {
            this.pattern = new BGP();
            this.pattern.setParent(this);
        }
    }

    /**
     * 
     * @return The graph context for this GRAPH clause. Either a {@link Variable} or an {@link URI}/.
     */
    public TriplePatternComponent getGraphContext() {
        return this.graph;
    }

    /**
     * 
     * @return the graph pattern scoped to the graph context.
     */
    public GraphPattern getGraphPattern() {
        return this.pattern;
    }

    @Override
    public Graph clone() {
        return new Graph(this.graph, (GraphPattern) pattern.clone());
    }

    @Override
    public String toString() {
        return "GRAPH " + this.graph + " { " + this.pattern + " }";
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        s.append("GRAPH ");
        QueryController.printTriplePatternComponent(this.graph, printFlags, uri2prefix, s);
        s.append(" {");
        indentLevel++;
        QueryController.printSeparator(printFlags, indentLevel, s);
        this.pattern.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
        indentLevel--;
        QueryController.printSeparator(printFlags, indentLevel, s);
        s.append("}");
    }

    @Override
    public List<GraphPattern> getChildren() {
        return Collections.<GraphPattern> singletonList(this.pattern);
    }

    @Override
    protected Map<Variable, Integer> getVariableCount(boolean onlyBindableVariables) {
        Map<Variable, Integer> vars = super.getVariableCount(onlyBindableVariables);
        if (this.graph instanceof Variable)
            incrementVariableCount(vars, (Variable) this.graph, 1);
        return vars;
    }

    @Override
    public Collection<URI> getReferencedURIs() {
        Collection<URI> uris = super.getReferencedURIs();
        if (this.graph instanceof URI)
            uris.add((URI) this.graph);
        return uris;
    }

    @Override
    public boolean replaceChild(TreeNode oldChild, TreeNode newChild) {
        if (oldChild == this.pattern && newChild instanceof GraphPattern) {
            newChild.setParent(this);
            oldChild.setParent(null);
            this.pattern = (GraphPattern) newChild;
            checkForEmptyPattern();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if (this.pattern.equals(child)) {
            this.pattern = null;
            checkForEmptyPattern();
            child.setParent(null);
            return true;
        }
        return false;
    }

    @Override
    public void addChild(TreeNode child) {
        if (this.pattern != null)
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.NO_ADD_MULTI_CHILD);
        else if (!(child instanceof GraphPattern))
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.ONLY_ADD, "GraphPattern", "Graph");
        this.pattern = (GraphPattern) child;
        checkForEmptyPattern();
        child.setParent(this);
    }

    @Override
    protected boolean prettyPrintParams(StringBuilder output) {
        output.append(graph);
        return true;
    }
}
