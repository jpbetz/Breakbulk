/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter.query;

import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * Node solver
 */
public interface NodeSolver {

    /**
     * Recursively solve a TreeNode from a query plan and return the solution.
     * 
     * @param n
     *            The tree node for which we are seeking solutions
     * @param answerConstraints
     *            These represent bindings that must be in the solution set due to nodes of the AST that have already been visited. Exactly how new solutions
     *            are combined with these solutions depends on the semantics of the particular node being processed. N.B. A null answers is equivalent to an
     *            answers containing a single solution with no bindings. This is the default state of the world and is *very* different from a non-null but
     *            empty list of solutions (which indicates that no solutions will work.)
     * @param namedGraphContext
     *            The named graph in which answers should be sought, or null if the matching is taking place against the default graph.
     * @param namedGraphVariable
     *            Variable that contains namedGraph
     * @return Solutions generated from node n *only*. It is the responsibility of the caller (not the callee) to algebraically compose these solutions with the
     *         known constraints in whatever manner is appropriate.
     * @throws GlitterException
     */
    public SolutionSet solveNode(TreeNode n, SolutionSet answerConstraints, URI namedGraphContext, Variable namedGraphVariable) throws GlitterException;
}
