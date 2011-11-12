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

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;
import java.util.Map.Entry;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.syntax.abstrakt.BGP;
import org.openanzo.glitter.syntax.abstrakt.Graph;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.abstrakt.Group;
import org.openanzo.glitter.syntax.abstrakt.Optional;
import org.openanzo.glitter.syntax.abstrakt.Subquery;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.glitter.syntax.abstrakt.Union;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;

/**
 * Solve the node in memory, calling back to the provided NodeSolver to handle sub nodes.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class SerialInMemoryNodeSolver implements NodeSolver {

    private final QueryController controller;

    private QueryExecutionPlan    plan;

    //private boolean               composedSolutions;

    private boolean               canBindGraphVariables;

    private NodeSolver            subNodeSolver;

    /**
     * In memory node solver constructor
     * 
     * @param subNodeSolver
     *            node solver for which to solve nodes
     * @param controller
     *            the query controller for which this is solving
     * @param plan
     *            the queyr execution plan to execute
     * @param canBindGraphVariables
     *            true if the graph variable can be bound
     */
    public SerialInMemoryNodeSolver(NodeSolver subNodeSolver, QueryController controller, QueryExecutionPlan plan, boolean canBindGraphVariables) {
        this.subNodeSolver = subNodeSolver;
        this.controller = controller;
        this.plan = plan;
        this.canBindGraphVariables = canBindGraphVariables;
        // this.composedSolutions = false;
    }

    // @SuppressWarnings("null")
    public SolutionSet solveNode(TreeNode n, SolutionSet answerConstraints, org.openanzo.rdf.URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {
        SolutionSet newAnswers = null;
        long start = 0;
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_beginSolvingNodeInMemory] {}", n.getClass().getSimpleName());
            start = System.currentTimeMillis();
        }
        if (n instanceof TriplePatternNode) {
            // we can't generate bindings ourselves, so we return an empty
            // solution set -- i.e., no bindings
            newAnswers = SolutionUtils.noSolutions();
            if (isEnabled) {
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_returningNoSolutionsForTriplePatternNode]");
            }
        } else if (n instanceof BGP) {
            BGP bgp = (BGP) n;
            newAnswers = solveBGP(bgp, answerConstraints, namedGraphContext, namedGraphVariable);
        } else if (n instanceof Group) {
            Group group = (Group) n;
            newAnswers = solveGroup(group, answerConstraints, namedGraphContext, namedGraphVariable);
        } else if (n instanceof Optional) {
            Optional optional = (Optional) n;
            newAnswers = solveOptional(optional, answerConstraints, namedGraphContext, namedGraphVariable);
        } else if (n instanceof Union) {
            Union union = (Union) n;
            newAnswers = solveUnion(union, answerConstraints, namedGraphContext, namedGraphVariable);
        } else if (n instanceof Graph) {
            Graph graphNode = (Graph) n;
            newAnswers = solveGraph(graphNode, answerConstraints, namedGraphContext, namedGraphVariable);
        } else if (n instanceof Subquery) {
            Subquery subquery = (Subquery) n;
            newAnswers = solveSubquery(subquery, answerConstraints, namedGraphContext, namedGraphVariable);
        } else {
            // not reachable
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.UNREACHABLE_CODE);
        }
        //this.composedSolutions = true;
        if (isEnabled) {
            StringBuilder sb = new StringBuilder();
            n.prettyPrint(sb, true);
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_solvedNodeInMemory] [{}] {}:{}", new Object[] { sb.toString(), newAnswers.size(), System.currentTimeMillis() - start });
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.TIMING_MARKER, "glitter_SerialInMemoryNodeSolver_solvedNodeInMemory,{},{}", new Object[] { System.currentTimeMillis() - start, newAnswers.size() });
        }
        return newAnswers;
    }

    private SolutionSet solveGraph(Graph graphNode, SolutionSet answerConstraints, org.openanzo.rdf.URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {
        SolutionSet newAnswers;
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();

        TriplePatternComponent tpc = graphNode.getGraphContext();
        if (tpc instanceof org.openanzo.rdf.URI) {
            newAnswers = subNodeSolver.solveNode(graphNode.getGraphPattern(), answerConstraints, (org.openanzo.rdf.URI) tpc, namedGraphVariable);
        } else if (tpc instanceof Variable) {
            Variable graphVar = (Variable) tpc;

            ////
            // if we have a solution in which the GRAPH variable is bound to
            // something other than a URI, then the GRAPH clause fails to match
            // on that solution, and so we should remove the solution from our
            // list of answers
            for (ListIterator<PatternSolution> it = answerConstraints.listIterator(); it.hasNext();) {
                Value binding = it.next().getBinding(graphVar);
                if (binding != null && !(binding instanceof org.openanzo.rdf.URI)) {
                    if (isEnabled)
                        RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_removingSolutionBindingGraphVariableToNonURI] {} / {}", graphVar, binding);
                    it.remove();
                }
            }

            ////
            // if the backend can bind graph variables then we just recurse with this
            // variable as our graph context.
            if (canBindGraphVariables) {
                newAnswers = subNodeSolver.solveNode(graphNode.getGraphPattern(), answerConstraints, null, graphVar);
            } else {
                // otherwise, we try to match the GraphPattern in the context of all of the named graphs
                // in our DataSet

                // we're going to ask for solutions to the pattern given
                // this particular namedGraph as the graph context. first though,
                // we need to do a bit of massaging on our existing answers --
                // all answers that we receive from this matching are going to
                // be augmented with a tpc->namedGraph binding . Unfortunately,
                // our solution generator won't know that, so we need to help them
                // out a bit. This implies two things:
                //  1) Any existing answer which has tpc bound to anything other
                //     than namedGraph will not be compatible with any solution
                //     returned in this effort, and so should be omitted from
                //     the list of required answers passed along
                //  2) Any new answer which binds tpc to something other than
                //     namedGraph will immediately be invalid. i.e., all existing
                //     answers should act as if they already have the tpc->namedGraph
                //     binding present.
                HashMap<URI, SolutionSet> answersPerGraph = new HashMap<URI, SolutionSet>();
                Set<URI> allNamedGraphs = this.controller.getQueryDataset().getNamedGraphURIs();
                for (URI namedGraph : allNamedGraphs) {
                    SolutionSet apg = new SolutionList();
                    answersPerGraph.put(namedGraph, apg);
                }
                for (PatternSolution existingAnswer : answerConstraints) {
                    Value existingBinding = existingAnswer.getBinding(graphVar);
                    if (existingBinding == null) { // add graphVar -> graph for each graph
                        for (URI namedGraph : allNamedGraphs) {
                            PatternSolutionImpl clone = new PatternSolutionImpl(existingAnswer);
                            clone.setBinding(graphVar, namedGraph);
                            answersPerGraph.get(namedGraph).add(clone);
                        }
                    } else {
                        // see if the current binding is one of our named graphs; if so, we'll include
                        // this binding for that named graph only
                        URI namedGraph = ((org.openanzo.rdf.URI) existingBinding);
                        if (existingBinding instanceof org.openanzo.rdf.URI && allNamedGraphs.contains(namedGraph)) {
                            answersPerGraph.get(namedGraph).add(existingAnswer);
                        }
                    }
                }
                // finally, gather new answers from each of the named graphs
                newAnswers = new SolutionList();
                for (Entry<URI, SolutionSet> graph : answersPerGraph.entrySet()) {
                    SolutionSet graphRequiredBindings = graph.getValue();
                    // if we have overall required bindings, but our bindings filtered
                    // for this particular graph are empty, then there is no way for this
                    // graph to add any bindings to our overall solution, so we skip it
                    if (graphRequiredBindings != null && graphRequiredBindings.size() == 0)
                        continue;
                    org.openanzo.rdf.URI graphIri = graph.getKey();
                    // otherwise, see what we come up with for the graph pattern associated
                    // with this graph
                    SolutionSet graphAnswers = subNodeSolver.solveNode(graphNode.getGraphPattern(), graphRequiredBindings, graphIri, graphVar);

                    SolutionSet graphVariableBindingSet = SolutionUtils.singletonSolution(graphVar, graphIri);

                    // Add all the answers we've received for this graph from our dataset,
                    // but first ensure that the ?g -> graph IRI binding is in each answer that
                    // we're including
                    if (isEnabled) {
                        StringBuilder sb = new StringBuilder();
                        graphNode.getGraphPattern().prettyPrint(sb, true);
                        RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_joiningGraphVariableToGraphSolutions] Join({} / {}, {})", new Object[] { graphVar, graphIri, sb.toString() });
                    }
                    newAnswers.addAll(SPARQLAlgebra.join(graphAnswers, graphVariableBindingSet));
                }
            }
        } else {
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.GRAPH_NOT_VAR);
        }
        return newAnswers;
    }

    private SolutionSet solveUnion(Union union, SolutionSet answerConstraints, org.openanzo.rdf.URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {
        SolutionSet newAnswers;
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        long start = 0;
        // build a new collection and add in all the answers we get
        // (each individual answer conjoins with answers, but not with
        // each other)
        newAnswers = new SolutionList();
        for (TreeNode it : this.plan.orderNodes(union.getChildren())) {
            if (controller.isCancelled()) {
                throw new GlitterException(ExceptionConstants.GLITTER.QUERY_CANCELLED);
            }
            GraphPattern gp = (GraphPattern) it;
            SolutionSet currentNodeAnswers = subNodeSolver.solveNode(gp, answerConstraints, namedGraphContext, namedGraphVariable);
            if (isEnabled) {
                start = System.currentTimeMillis();
            }
            newAnswers.addAll(currentNodeAnswers);
            if (isEnabled) {
                StringBuilder sb = new StringBuilder();
                gp.prettyPrint(sb, true);
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_unioningAnswers] Union(..., {}) [{} + {}] {}", new Object[] { sb.toString(), newAnswers.size(), currentNodeAnswers.size(), System.currentTimeMillis() - start });
            }
        }
        return newAnswers;
    }

    private SolutionSet solveOptional(Optional opt, SolutionSet answerConstraints, org.openanzo.rdf.URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        SolutionSet newAnswers;
        GraphPattern must = opt.getMustMatchPattern();
        GraphPattern may = opt.getMayMatchPattern();
        SolutionSet newConstraints;
        if (must != null) {
            newAnswers = subNodeSolver.solveNode(must, answerConstraints, namedGraphContext, namedGraphVariable);
            if (isEnabled)
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_joiningOptionalLHSWithExistingAnswers]");
            newConstraints = SPARQLAlgebra.join(answerConstraints, newAnswers);
        } else {
            if (isEnabled)
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_emptyLHSOfOptionalIsIdentitySolutionSet]");
            newAnswers = SolutionUtils.unconstrainedSolutions();
            newConstraints = newAnswers;
        }
        if (must == null || newConstraints.size() != 0) {
            // So, at this point newAnswers = an extended subset of answerConstraints
            // We want to match mayMatch now in this new context -- which will
            // extend some of these newAnswers -- but we don't want to eliminate
            // answers that are not extended - so we just need a left
            // join instead of the conjoin operator.
            SolutionSet rhs = subNodeSolver.solveNode(may, newConstraints, namedGraphContext, namedGraphVariable);
            if (isEnabled) {
                StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
                if (must != null)
                    must.prettyPrint(sb1, true);
                else
                    sb1.append("BGP()");
                may.prettyPrint(sb2, true);
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_performingOptionalLeftJoin] [{}] [{}]", sb1.toString(), sb2.toString());
            }
            newAnswers = SPARQLAlgebra.leftJoin(newAnswers, rhs, opt.getFilters());
        }
        return newAnswers;
    }

    private SolutionSet solveGroup(Group group, SolutionSet answerConstraints, org.openanzo.rdf.URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        SolutionSet newAnswers;
        // first we need to see if this is a BGP backed by code (a FunctionalPredicate)
        // because those get handled specially

        newAnswers = conjoinAnswers(group, answerConstraints, namedGraphContext, namedGraphVariable);

        if (group.getAssignments().size() > 0) {
            if (isEnabled) {
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_executingAssignments] {}", group.getAssignments());
            }
            newAnswers = SPARQLAlgebra.processAssignments(newAnswers, group.getAssignments());
        }

        // apply filters at the end (TODO @@ this can be optimized as we go and
        // maybe should be -- note that it can only be optimized when a solution
        // has all the variables that occur in a FILTER bound already -- even then
        // I'm not positive that it can be eliminated since it may yet conjoin with
        // a new solution to form a 3rd solution that is kept due to another FILTER)
        if (newAnswers.size() > 0 && group.getFilters() != null && group.getFilters().size() > 0) {
            long start = 0;
            if (isEnabled) {
                start = System.currentTimeMillis();
            }
            newAnswers = SPARQLAlgebra.filterSolutions(newAnswers, group.getFilters());
            if (isEnabled) {
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_applyingFilters] [{}] {}:{}", new Object[] { group.getFilters(), newAnswers.size(), System.currentTimeMillis() - start });
            }
        }

        return newAnswers;
    }

    private SolutionSet solveBGP(BGP bgp, SolutionSet answerConstraints, org.openanzo.rdf.URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {
        SolutionSet newAnswers;
        // first we need to see if this is a BGP backed by code (a FunctionalPredicate)
        // because those get handled specially

        FunctionalPredicate fp = null;
        if ((fp = bgp.getFunctionalPredicate()) != null) {
            return solveFP(answerConstraints, namedGraphContext, namedGraphVariable, fp);
        }

        newAnswers = conjoinAnswers(bgp, answerConstraints, namedGraphContext, namedGraphVariable);

        return newAnswers;
    }

    private SolutionSet solveFP(SolutionSet answerConstraints, org.openanzo.rdf.URI namedGraphContext, Variable namedGraphVariable, FunctionalPredicate fp) throws GlitterException {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        SolutionSet newAnswers;
        // ask the FP to supply us with bindings - we give them any
        // answer constraints we know about, as well as a named graph context
        // and/or named graph variable

        if (isEnabled)
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_solvingFunctionalPredicate] {}", fp);
        if (namedGraphVariable == null || fp.canBindGraphVariables()) {
            newAnswers = fp.generateSolutions(namedGraphContext, namedGraphVariable, answerConstraints);
        } else if (fp.usesDataFromGraphs()) {
            // there is a graph variable which our FP can't handle, and the FP does use data
            // from the active graph; so we need to loop through our named graphs and in
            // turn ask the FP for solutions; each solution needs to be joined with a
            // solution binding the variable to the current named graph; all these solutions
            // get unioned together
            newAnswers = new SolutionList();
            for (URI graph : this.controller.getQueryDataset().getNamedGraphURIs()) {
                if (controller.isCancelled()) {
                    throw new GlitterException(ExceptionConstants.GLITTER.QUERY_CANCELLED);
                }
                SolutionSet ss = fp.generateSolutions(graph, null, answerConstraints);
                SolutionSet graphBinding = SolutionUtils.singletonSolution(namedGraphVariable, graph);
                if (isEnabled) {
                    RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_joiningGraphVariableToFunctionalPredicateSolutions] Join({} / {}, {})", new Object[] { namedGraphVariable, graph, fp });
                }
                newAnswers.addAll(SPARQLAlgebra.join(ss, graphBinding));
            }
        } else {
            // in this case, we only get one set of answers from the FP since it doesn't
            // use graph data, but since we need to bind the graph variable, it gets bound
            // to every possible named graph
            SolutionList graphBindings = new SolutionList();
            for (URI g : this.controller.getQueryDataset().getNamedGraphURIs())
                graphBindings.add(new PatternSolutionImpl(namedGraphVariable, g));
            SolutionSet ss = fp.generateSolutions(null, null, answerConstraints);
            if (isEnabled)
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_joiningGraphVariableToFunctionalPredicateSolutions] Join({}, {})", new Object[] { namedGraphVariable, fp });
            newAnswers = SPARQLAlgebra.join(graphBindings, ss);
        }
        return newAnswers;
    }

    private SolutionSet solveSubquery(Subquery subqueryNode, SolutionSet answerConstraints, org.openanzo.rdf.URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {
        // @@
        //boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        SolutionSet solutions = this.subNodeSolver.solveNode(subqueryNode.getSubqueryController().getQueryPattern(), answerConstraints, namedGraphContext, namedGraphVariable);
        SolutionSet processedSolutions = subqueryNode.getSubqueryController().getEngine().postProcessSolutions(solutions, false, subqueryNode.getSubqueryController()).getSelectResults();
        if (RequestAnalysis.getAnalysisLogger().isDebugEnabled())
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_returningSubqueryResults] {}:{}", new Object[] { solutions.size(), processedSolutions.size() });
        return processedSolutions;
    }

    private SolutionSet conjoinAnswers(TreeNode n, SolutionSet answerConstraints, org.openanzo.rdf.URI namedGraphContext, Variable namedGraphVariable) throws GlitterException {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        SolutionSet newAnswers;
        // both a group and a BGP require that its answers
        // be conjoined together
        //
        // note: compositional semantics would derive all the answers for these
        // components individually and then conjoin them, rather than conjoining
        // as we go. UPDATE: We can't conjoin as we go because that might change
        // the results of any FILTERs at the end. We can only conjoin with each other.

        // note: for each child after the first, both existing constraints and
        // new constraints apply to the rest of the children. We can't just
        // conjoin them because FILTERs need to apply only to the new answers. So we
        // maintain answerConstraints, which is (prematurely) conjoined, while also keeping
        // newAnswers on its own for FILTERing.

        SolutionSet newConstraints = answerConstraints;
        newAnswers = SolutionUtils.unconstrainedSolutions();

        for (Iterator<TreeNode> it = this.plan.orderNodes(n.getChildren()).iterator(); it.hasNext();) {
            if (controller.isCancelled()) {
                throw new GlitterException(ExceptionConstants.GLITTER.QUERY_CANCELLED);
            }
            TreeNode child = it.next();
            SolutionSet solutions = subNodeSolver.solveNode(child, newConstraints, namedGraphContext, namedGraphVariable);
            if (isEnabled) {
                StringBuilder sb = new StringBuilder();
                child.prettyPrint(sb, true);
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_joiningSolutionsFromNode] [{}] {}", sb.toString(), solutions.size());
            }
            if (solutions.size() == 0) {
                return SolutionUtils.noSolutions();
            }
            newAnswers = SPARQLAlgebra.join(newAnswers, solutions);
            // we only need the new constraints if we'll be looping again
            if (it.hasNext()) {
                if (isEnabled) {
                    RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SerialInMemoryNodeSolver_joiningNewConstraints]");
                }
                newConstraints = SPARQLAlgebra.join(newAnswers, newConstraints);
            }
        }
        return newAnswers;
    }
}
