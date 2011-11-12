/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/EngineConfig.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: EngineConfig.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter;

import java.util.Map;

import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.query.QueryExecutor;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionGeneratorFactory;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.rdf.URI;

/**
 * Defines configuration options available to direct the behavior of a Glitter {@link Engine}
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public interface EngineConfig {
    /**
     * 
     * @return A {@link SolutionGeneratorFactory} that can produce {@link SolutionGenerator}s for the Glitter engine.
     */
    public abstract SolutionGeneratorFactory getSolutionGeneratorFactory();

    /**
     * 
     * @return The {@link QueryExecutionPlan} class to use for putting together a plan of access for executing the query.
     */
    public abstract QueryExecutionPlan getQueryExecutionPlan(SolutionGenerator solutionGenerator);

    /**
     * 
     * @return An enumeration of {@link TreeRewriter}s that will be applied sequentially to transform the SPARQL query tree before query execution.
     */
    public abstract Iterable<TreeRewriter> getTreeRewriters();

    /**
     * 
     * @return An enumeration of {@link QueryValidator}s that will be invoked sequentially to determine if the engine will execute the given query.
     */
    public abstract Iterable<QueryValidator> getQueryValidators();

    /**
     * 
     * @return Whether the normal form rewriter should combine nested binary UNIONs into a single N-ary UNION operator.
     */
    public abstract boolean allowNaryUnion();

    /**
     * In many cases, an intermediate result set contains solutions that all bind a given variable to the same value. In most cases, this value can be safely
     * substituted in for the variable anywhere else in the query that the variable appears.
     * 
     * @return Whether the engine should aggressively substitute for variables with fixed values.
     */
    public abstract boolean substituteFixedBindings();

    /**
     * 
     * @return A map associating predicate URIs with {@link FunctionalPredicate}s that implement special semantics for that URI.
     */
    public abstract Map<URI, Class<? extends FunctionalPredicate>> getFunctionalPredicates();

    /**
     * Gets the query executor for the solution generator provided.
     * 
     * @param sg
     *            A solution generator.
     * @return A query executor.
     */
    public QueryExecutor getQueryExecutor(SolutionGenerator sg);

    // TODO ... optimizers, statistics suppliers
}
