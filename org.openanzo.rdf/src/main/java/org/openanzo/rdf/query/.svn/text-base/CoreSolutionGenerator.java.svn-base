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

import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.query.AbstractSolutionGenerator;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.Variable;

/**
 * CoreSolutionGenerator solves only TriplePatternNode patterns using subclasses implementation of generateSolutions
 *
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 *
 */
public abstract class CoreSolutionGenerator extends AbstractSolutionGenerator {

    /**
     *
     */
    public CoreSolutionGenerator() {
        super();
    }

    public boolean canHandleSimultaneousRequests() {
        return false;
    }

    public boolean canBindGraphVariables() {
        return true;
    }

    public boolean sortedSolutions() {
        return false;
    }

    public boolean usesRequiredBindings() {
        return false;
    }

    public boolean willHandleFilters(Set<Expression> filters) {
        return false;
    }

    public boolean willHandleAssignments(MultiMap<Variable, Expression> assignments) {
        return false;
    }

    public void cleanup() throws GlitterException {
    }

    public void initialize() throws GlitterException {
    }

    protected void addSolutions(SolutionSet solutions, TriplePattern pattern, Collection<org.openanzo.rdf.Statement> matches, Variable namedGraphVariable) {
        for (org.openanzo.rdf.Statement statement : matches) {
            org.openanzo.rdf.URI matchGraph = statement.getNamedGraphUri();
            Statement triple = statement;
            PatternSolution sol = triple.entails(pattern);
            if (sol != null) {
                // if there's a named graph variable, we need to make sure it doesn't contradict
                // this solution and then set its binding
                if (namedGraphVariable != null) {
                    org.openanzo.rdf.Value existingGraphVariableBinding = sol.getBinding(namedGraphVariable);
                    if (existingGraphVariableBinding != null && !existingGraphVariableBinding.equals(matchGraph))
                        continue; // skip this solution due to an inconsistency
                    sol.setBinding(namedGraphVariable, matchGraph);
                }
                solutions.add(sol);
            }
        }

    }
}
