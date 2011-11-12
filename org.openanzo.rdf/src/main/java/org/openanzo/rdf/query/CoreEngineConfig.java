/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 7, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.query;

import java.util.Hashtable;
import java.util.Map;

import org.openanzo.glitter.DefaultEngineConfig;
import org.openanzo.glitter.EngineConfig;
import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.planning.SimpleCostExecutionPlan;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.URI;

/**
 * SuperType for Engine configs that use the same functional predicates
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class CoreEngineConfig extends DefaultEngineConfig implements EngineConfig {

    private Map<URI, Class<? extends FunctionalPredicate>> functionalPredicates = new Hashtable<URI, Class<? extends FunctionalPredicate>>();

    /**
     * Create CoreEngineConfig
     */
    public CoreEngineConfig() {
        super();
    }

    public QueryExecutionPlan getQueryExecutionPlan(SolutionGenerator sg) {
        return new SimpleCostExecutionPlan();
    }

    /**
     * Register FunctionalPredicate with this engine config
     * 
     * @param predicate
     *            to register
     * @param clazz
     *            to instantiate
     */
    public void registerFunctionalPredicate(String predicate, Class<? extends FunctionalPredicate> clazz) {
        functionalPredicates.put(MemURI.create(predicate), clazz);
    }

    public Map<URI, Class<? extends FunctionalPredicate>> getFunctionalPredicates() {
        return functionalPredicates;
    }
}
