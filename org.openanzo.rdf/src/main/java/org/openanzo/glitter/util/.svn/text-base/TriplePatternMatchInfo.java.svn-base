/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter.util;

import org.openanzo.glitter.query.Projection;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.QueryType;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * Bits of data needed to effectively solve a TriplePattern Glitter node.
 * 
 * In addition to the triple pattern and named graph to solve for, this class provides {@link #isDistinct()} and {@link #isNeededOutsideOfQuery(Bindable)}.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TriplePatternMatchInfo {
    private final TriplePatternNode node;

    private final TriplePattern     pattern;

    private final URI               namedGraph;

    private final Variable          namedGraphVariable;

    private final QueryInformation  qc;

    private final boolean           distinctSolutions;

    /**
     * Create match info for a treenode
     * 
     * @param node
     *            node for which to create info
     * @param namedGraph
     *            namedgraph used for this node
     * @param namedGraphVariable
     *            namedgraph variable used for this node
     * @param qc
     */
    public TriplePatternMatchInfo(TriplePatternNode node, URI namedGraph, Variable namedGraphVariable, QueryInformation qc) {

        this.node = node;
        this.pattern = node.getTriplePattern();
        this.namedGraph = namedGraph;
        this.namedGraphVariable = namedGraphVariable;
        this.qc = qc;
        if (qc != null) {
            this.distinctSolutions = this.qc.getQueryType() == QueryType.SELECT && ((Projection) this.qc.getQueryResultForm()).isDistinct();
        } else {
            distinctSolutions = false;
        }
    }

    /**
     * Is the binding used outside of this treenode
     * 
     * @param b
     *            bindable to check
     * @return true if the binding used outside of this treenode
     */
    public boolean isNeededOutsideOfQuery(Bindable b) {
        if (qc == null) {
            return true;
        }

        return Glitter.isNeededOutsideOfNode(b, node, qc, true);
    }

    /**
     * Distinct solutions only
     * 
     * @return Distinct solutions only
     */
    public boolean isDistinct() {
        return distinctSolutions;
    }

    /**
     * Get the triple pattern
     * 
     * @return the triple pattern
     */
    public TriplePattern getPattern() {
        return pattern;
    }

    /**
     * 
     * @return the namedgraph
     */
    public URI getNamedGraph() {
        return namedGraph;
    }

    /**
     * 
     * @return the namedgraph variable
     */
    public Variable getNamedGraphVariable() {
        return namedGraphVariable;
    }
}
