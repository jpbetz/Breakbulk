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
import java.util.HashMap;
import java.util.Map;

import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.query.QueryExecutor;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionGeneratorFactory;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.glitter.query.planning.LexicalOrderBasedExecutionPlan;
import org.openanzo.rdf.URI;

/**
 * Parse only glitter config
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ParseOnlyEngineConfig implements EngineConfig {

    public boolean allowNaryUnion() {
        return true;
    }

    public Map<URI, Class<? extends FunctionalPredicate>> getFunctionalPredicates() {
        return new HashMap<URI, Class<? extends FunctionalPredicate>>();
    }

    public QueryExecutionPlan getQueryExecutionPlan(SolutionGenerator sg) {
        return new LexicalOrderBasedExecutionPlan();
    }

    public QueryExecutor getQueryExecutor(SolutionGenerator sg) {
        throw new UnsupportedOperationException("getQueryExecutor should not be called on an engine configured with ParseOnlyEngineConfig");
    }

    public Iterable<QueryValidator> getQueryValidators() {
        return Collections.emptyList();
    }

    public SolutionGeneratorFactory getSolutionGeneratorFactory() {
        return new MockSolutionGeneratorFactory();
    }

    public Iterable<TreeRewriter> getTreeRewriters() {
        return Collections.emptyList();
    }

    public boolean substituteFixedBindings() {
        return false;
    }

}
