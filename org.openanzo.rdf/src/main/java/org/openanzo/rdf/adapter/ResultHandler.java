/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.rdf.adapter;

import java.util.List;

import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.SolutionList;
import org.openanzo.glitter.query.SolutionSet;
import org.openrdf.query.TupleQueryResultHandlerException;

/**
 * Result handler
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ResultHandler {

    QueryResults              queryResults = null;

    private List<String>      bindingNames = null;

    private final SolutionSet solutionSet  = new SolutionList();

    int                       total        = 0;

    protected void startQueryResult(List<String> bindingNames) throws TupleQueryResultHandlerException {
        this.bindingNames = bindingNames;
    }

    protected void handleSolution(PatternSolution solution) throws TupleQueryResultHandlerException {
        solutionSet.add(solution);
        total++;
    }

    protected void endQueryResult() throws TupleQueryResultHandlerException {
        queryResults = new QueryResults(solutionSet, new QueryController(), bindingNames, total);
    }
}
