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
package org.openanzo.glitter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections15.IteratorUtils;
import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionGeneratorFactory;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.rdf.URI;

/**
 * Engine config not backed by a real SolutionGenerator.
 * 
 * Convenience class for unit testing Glitter components up to, but not including the solution generators.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class MockEngineConfig extends DefaultEngineConfig {

    Class<? extends QueryExecutionPlan> plan;

    List<TreeRewriter>                  rewriters;

    SolutionGenerator                   solutionGenerator;

    /**
     * Mock engine config with execution plan
     * 
     * @param plan
     *            execution plan
     */
    public MockEngineConfig(Class<? extends QueryExecutionPlan> plan) {
        this(plan, null, new MockSolutionGenerator());
    }

    MockEngineConfig(Class<? extends QueryExecutionPlan> plan, List<TreeRewriter> rewriters, SolutionGenerator solutionGenerator) {
        this.plan = plan;
        this.rewriters = rewriters;
        this.solutionGenerator = solutionGenerator;
    }

    @Override
    public Iterable<TreeRewriter> getTreeRewriters() {
        if (rewriters == null)
            return super.getTreeRewriters();

        List<TreeRewriter> rewriterList = IteratorUtils.toList(super.getTreeRewriters().iterator());
        rewriterList.addAll(rewriters);
        return rewriterList;
    }

    public Map<URI, Class<? extends FunctionalPredicate>> getFunctionalPredicates() {
        return Collections.emptyMap();
    }

    public QueryExecutionPlan getQueryExecutionPlan(SolutionGenerator sg) {
        try {
            if (plan != null)
                return plan.newInstance();
            return null;
        } catch (IllegalAccessException iae) {
            throw new RuntimeException(iae);
        } catch (InstantiationException iae) {
            throw new RuntimeException(iae);
        }
    }

    public SolutionGeneratorFactory getSolutionGeneratorFactory() {
        return new MockSolutionGeneratorFactory(solutionGenerator);
    }
}
