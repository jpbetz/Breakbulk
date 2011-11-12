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
import org.openanzo.glitter.query.QueryResults;
import org.openrdf.query.BindingSet;
import org.openrdf.query.TupleQueryResultHandler;
import org.openrdf.query.TupleQueryResultHandlerException;

/**
 * Rio resulthandler
 * 
 */
public class RioResultHandler implements TupleQueryResultHandler {

    private final ResultHandler      handler;

    private final BasicNodeConverter converter;

    /**
     * Create RIO Result Handler
     * 
     * @param handler
     */
    public RioResultHandler(ResultHandler handler) {
        this.handler = handler;
        converter = new BasicNodeConverter();
    }

    public void startQueryResult(List<String> bindingNames) throws TupleQueryResultHandlerException {
        handler.startQueryResult(bindingNames);
    }

    public void handleSolution(BindingSet solution) throws TupleQueryResultHandlerException {
        PatternSolution patternSolution = converter.convert(solution);
        handler.handleSolution(patternSolution);
    }

    public void endQueryResult() throws TupleQueryResultHandlerException {
        handler.endQueryResult();
    }

    /**
     * Get the converted query results
     * 
     * @return converted query results
     */
    public QueryResults getQueryResults() {
        return handler.queryResults;
    }
}
