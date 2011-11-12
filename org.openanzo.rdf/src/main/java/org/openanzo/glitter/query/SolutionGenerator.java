/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/SolutionGenerator.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: SolutionGenerator.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.Set;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.rdf.Variable;

/**
 * A {@link SolutionGenerator} is a backend to the Glitter engine that knows how to generate a specific type of bindings.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public interface SolutionGenerator {
    /**
     * 
     * @return The unique ID of this instance of a query
     */
    public String getQueryId();

    /**
     * 
     * @param dataset
     *            The {@link RDFDataset} against which the query is being executed.
     */
    public abstract void setQueryDataset(QueryDataset dataset);

    /**
     * 
     * @param queryInformation
     *            Information on the parsed and prepared query.
     */
    public abstract void setQueryInformation(QueryInformation queryInformation);

    /**
     * 
     * @param plan
     *            The execution plan in use.
     */
    public abstract void setQueryExecutionPlan(QueryExecutionPlan plan);

    /**
     * 
     * @return Accessor to the dataset
     */
    public abstract QueryDataset getQueryDataset();

    /**
     * 
     * @return Accessor to the parsed query
     */
    public abstract QueryInformation getQueryInformation();

    /**
     * 
     * @return Accessor to the execution plan
     */
    public abstract QueryExecutionPlan getQueryExecutionPlan();

    /**
     * @deprecated
     * @return QueryExecutionServices for this SolutionGenerator
     */
    @Deprecated
    public abstract QueryExecutionServices getQueryExecutionServices();

    /**
     * 
     * @param node
     *            The node in the tree for which bindings are desired.
     * @param namedGraph
     *            If not null, the solutions should be generated by matching against this graph from the named graph part of the RDF dataSet. Otherwise, the
     *            solutions should be generated from the default graph. (i.e., if not null, treat this graph as the default graph)
     * @param namedGraphVariable
     *            If not null and this SolutionGenerator returns true for canBindGraphVariables(), then this is the variable that should be bound to the named
     *            graph IRI from which solutions are found.
     * @param requiredBindings
     *            Known bindings at this point in the AST. Every returned solution should be a superset of one solution from the required bindings. (That is,
     *            unbound variables can be bound, but all bound variables must remain bound to the same value.) Note that Glitter enforces this constraint when
     *            combining pattern solutions.
     * 
     *            In general, if generateSolutions returns a value (null or otherwise), then the SolutionGenerator will not be called again for any descendants
     *            of node. If an exception is thrown, then generateSolution may be called for descendant (simpler) nodes.
     * @param controller
     *            TODO
     * @return A list of bindings (for variables and blank nodes) that satisfy the given tree node, or null if this pattern doesn't match.
     * @throws GlitterException
     */
    public abstract SolutionSet generateSolutions(TreeNode node, org.openanzo.rdf.URI namedGraph, Variable namedGraphVariable, SolutionSet requiredBindings, QueryController controller) throws GlitterException;

    /**
     * Called before any calls to generateSolutions but after all calls to set*.
     * 
     * @throws GlitterException
     */
    public abstract void initialize() throws GlitterException;

    /**
     * Called after all calls to generateSolutions.
     * 
     * @throws GlitterException
     */
    public abstract void cleanup() throws GlitterException;

    /*
     * The following methods provide information for the engine and query executor to use
     * in determining how to traverse the query AST.
     */
    /**
     * Informative method.
     * 
     * @return Whether or not this backend makes use of known constraints passed in when generating solutions.
     */
    public abstract boolean usesRequiredBindings();

    /**
     * Informative method.
     * 
     * @return Whether or not this backend can handle multiple requests in parallel.
     */
    public abstract boolean canHandleSimultaneousRequests();

    /**
     * Informative method.
     * 
     * @return Whether or not this backend can range over a graph variable and bind the variable to the appropriate graphs from the named graph part of the
     *         {@link RDFDataset}
     */
    public abstract boolean canBindGraphVariables();

    /**
     * Many backends do not implement filters, in which case Glitter will filter results even if the solution generator handles a node which subsumes filters.
     * (Other than an OPTIONAL -- a solution generator should only handle an OPTIONAL that includes a filter if it can handle the filter.)
     * 
     * @param filters
     * @return true if the solution generator will take care of these filters on any nodes that it sees, false if Glitter should handle the filters.
     */
    public abstract boolean willHandleFilters(Set<Expression> filters);

    /**
     * Many backends do not special-case assignments, in which case Glitter will bind & join the variables in the assignments even if the solution generator
     * handles a node which subsumes the assignments.
     * 
     * @param assignments
     * @return true if the solution generator will take care of these assignments on any nodes that it sees, false if Glitter should handle the assignments.
     */
    public abstract boolean willHandleAssignments(MultiMap<Variable, Expression> assignments);

    /**
     * 
     * @return whether or not the generator sorts returned solutions as per any ORDER BY information
     */
    public abstract boolean sortedSolutions();
}
