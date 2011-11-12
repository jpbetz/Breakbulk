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

import java.util.Set;

import org.apache.commons.collections15.MultiMap;
import org.apache.commons.lang.NotImplementedException;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.query.AbstractSolutionGenerator;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * Mock solution generator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class MockSolutionGenerator extends AbstractSolutionGenerator {

    public SolutionSet generateSolutions(TreeNode node, URI namedGraph, Variable namedGraphVariable, SolutionSet requiredBindings, QueryController controller) throws GlitterException {
        throw new NotImplementedException();
    }

    public String getQueryId() {
        return null;
    }

    public void initialize() throws GlitterException {
    }

    public void cleanup() throws GlitterException {
    }

    public boolean canBindGraphVariables() {
        return false;
    }

    public boolean canHandleSimultaneousRequests() {
        return false;
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
}
