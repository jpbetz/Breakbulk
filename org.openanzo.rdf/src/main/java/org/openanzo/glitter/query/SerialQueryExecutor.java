/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/SerialQueryExecutor.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: SerialQueryExecutor.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.EnumSet;
import java.util.Set;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.exceptions.Assert;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.EngineConfig;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.abstrakt.Group;
import org.openanzo.glitter.syntax.abstrakt.Optional;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link SerialQueryExecutor} is the standard {@link QueryExecutor}. It uses the supplied execution plan to generate bindings serially; it repeatedly asks
 * a solution generator to generate bindings for as large a part of the query as it can, and the executor composes these results into the final
 * {@link SolutionSet}.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class SerialQueryExecutor implements QueryExecutor, NodeSolver {
    private static final Logger      log = LoggerFactory.getLogger(SerialQueryExecutor.class);

    private SolutionGenerator        generator;

    private QueryController          controller;

    private EngineConfig             config;

    private final boolean            composedSolutions;

    private boolean                  done;

    private SerialInMemoryNodeSolver solver;

    /**
     * Constructor.
     */
    public SerialQueryExecutor() {
        this.composedSolutions = false;
        this.done = false;

    }

    public void initialize(EngineConfig config, QueryController controller, SolutionGenerator sg, QueryExecutionPlan plan) {
        this.config = config;
        this.generator = sg;
        this.controller = controller;
        this.solver = new SerialInMemoryNodeSolver(this, controller, plan, generator.canBindGraphVariables());
    }

    public SolutionSet executeQuery() throws org.openanzo.glitter.exception.GlitterException {
        Assert.isTrue(!this.done); // prevent reuse of these objects
        GraphPattern root = this.controller.getQueryPattern();

        if (log.isInfoEnabled()) {
            log.info(LogUtils.GLITTER_MARKER, "Executing query:" + this.controller.getQueryString(true));
        }
        if (RequestAnalysis.getAnalysisLogger().isDebugEnabled()) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialQueryExecutor_query]\n" + this.controller.prettyPrintQueryString(EnumSet.of(QueryStringPrintOptions.INDENT)));
        }
        SolutionSet solutions = solveNode(root, SolutionUtils.unconstrainedSolutions(), null, null);
        this.done = true;
        return solutions;
    }

    public boolean composedSolutions() {
        return this.composedSolutions;
    }

    /**
     * Returns a list of pattern solutions that satisfy the given tree node, in light of the named graph context supplied and the answers known already to be
     * true. The most interesting part of these parameters is 'answers' (see below).
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
     * @return Solutions generated from node n *only*. It is the responsibility of the caller (not the callee) to algebraically compose these solutions with the
     *         known constraints in whatever manner is appropriate.
     */
    public SolutionSet solveNode(TreeNode n, SolutionSet answerConstraints, URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {

        if (answerConstraints == null)
            answerConstraints = SolutionUtils.unconstrainedSolutions();

        SolutionUtils.substituteFilterBindings(n, answerConstraints);
        // TODO write tests for this
        if (this.config.substituteFixedBindings()) {
            n = SolutionUtils.substituteFixedBindings(n, answerConstraints);
        }
        // first, see if our SolutionGenerator wants a crack at this node
        // if this node is an optional with filters that the SolutionGenerator cannot handle,
        // don't give it a chance
        // TODO this is broken because the optional w/ filters could be embedded deep w/in a group
        // we probably need to rely on the solution generator telling us it can't handle it
        if (!(n instanceof Optional && n.getFilters() != null && n.getFilters().size() > 0 && !this.generator.willHandleFilters(n.getFilters()))) {
            SolutionSet results = delegateNodeToSolutionGenerator(n, answerConstraints, namedGraphContext, namedGraphVariable);
            if (results != null) {
                return results;
            }
        }
        // if we get to this point, then we need to handle this node ourselves
        return solver.solveNode(n, answerConstraints, namedGraphContext, namedGraphVariable);
    }

    /*
     * Send the solution to the generator and see if it can solve it.  If it can't it will throw a GlitterException.
     */
    private SolutionSet delegateNodeToSolutionGenerator(TreeNode n, SolutionSet answerConstraints, URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {
        long start = 0;
        long totalTime = 0;
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        SolutionSet answers = null;
        try {
            if (isEnabled) {
                start = System.currentTimeMillis();
                totalTime = System.currentTimeMillis();
            }
            answers = this.generator.generateSolutions(n, namedGraphContext, namedGraphVariable, answerConstraints, controller);
            if (answers == null)
                return null;
            if (isEnabled) {
                StringBuilder sb = new StringBuilder();
                n.prettyPrint(sb, true);
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialQueryExecutor_newAnswersFromSolutionGeneratorForNode] [{}] = [{}] {}:{}", new Object[] { n.toString(), sb.toString(), Integer.toString(answers.size()), Long.toString(System.currentTimeMillis() - start) });
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.TIMING_MARKER, "glitter_SerialQueryExecutor_newAnswersFromSolutionGeneratorForNode,{},{},{}", new Object[] { Long.toString(System.currentTimeMillis() - start), Integer.toString(answers.size()), sb.toString() });
                start = System.currentTimeMillis();
            }
            if (n instanceof Group) {
                Group g = (Group) n;
                if (g.getAssignments().size() > 0 && !generator.willHandleAssignments(g.getAssignments())) {
                    answers = SPARQLAlgebra.processAssignments(answers, g.getAssignments());
                    if (isEnabled) {
                        RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialQueryExecutor_processedAssignments] {}:{}", Long.toString(System.currentTimeMillis() - start), Integer.toString(answers.size()));
                        RequestAnalysis.getAnalysisLogger().debug(LogUtils.TIMING_MARKER, "glitter_SerialQueryExecutor_processedAssignments,{},{}", Long.toString(System.currentTimeMillis() - start), Integer.toString(answers.size()));
                        start = System.currentTimeMillis();
                    }
                }
            }
            Set<Expression> filters = n.getFilters();
            if (filters != null && filters.size() > 0 && !this.generator.willHandleFilters(filters)) {
                // we need to apply the filters ourselves
                answers = SPARQLAlgebra.filterSolutions(answers, n.getFilters());
                if (isEnabled) {
                    RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialQueryExecutor_filteredSolutions] {}:{}", Long.toString(System.currentTimeMillis() - start), Integer.toString(answers.size()));
                    RequestAnalysis.getAnalysisLogger().debug(LogUtils.TIMING_MARKER, "glitter_SerialQueryExecutor_filteredSolutions,{},{}", Long.toString(System.currentTimeMillis() - start), Integer.toString(answers.size()));
                    start = System.currentTimeMillis();
                }
                // if this node is OPTIONAL(A, B, F) then answers is the LeftJoin(eval(A), eval(B))
                // Therefore, answers contains some members of eval(A) (for which there were
                // no compatible bindings in eval(B)) and all the members of Join((eval(A), eval(B))).
                // If a filter eliminates a solution S, and S was the result of joining a member
                // of eval(A), SA, and of eval(B), SB, then we need to make sure that SA is in the answer
                // set. We have no way of doing that at this granularity. We could redo all the algebra,
                // but it's probably better in the first place to require the solution generator to handle
                // optionals... (see note above)
            }
            if (isEnabled) {
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialQueryExecutor_solvedNodeWithSolutionGenerator] {}:{}", new Object[] { Long.toString(System.currentTimeMillis() - totalTime), Integer.toString((answers != null) ? answers.size() : 0) });
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.TIMING_MARKER, "glitter_SerialQueryExecutor_solvedNodeWithSolutionGenerator,{},{}", new Object[] { Long.toString(System.currentTimeMillis() - totalTime), Integer.toString((answers != null) ? answers.size() : 0) });
            }
            return answers;
        } finally {
        }
    }
}
