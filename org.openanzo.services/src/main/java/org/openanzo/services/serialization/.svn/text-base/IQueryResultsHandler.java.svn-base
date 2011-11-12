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

package org.openanzo.services.serialization;

import java.util.Collection;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryType;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Used by client components to process partial query results.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface IQueryResultsHandler {
    /**
     * Start handling queryResults
     * 
     * @param queryType
     *            results type
     * @param totalSolutions
     * @throws AnzoException
     */
    public void start(QueryType queryType, int totalSolutions) throws AnzoException;

    /**
     * Stop handling queryResults
     * 
     * @throws AnzoException
     */
    public void end() throws AnzoException;

    /**
     * Handle the ask result
     * 
     * @param askResult
     *            boolean ask result
     * @return true if handled ok
     * @throws AnzoException
     */
    public boolean handleAskResult(boolean askResult) throws AnzoException;

    /**
     * Handle statement
     * 
     * @param subject
     *            subject of statement
     * @param predicate
     *            predicate of statement
     * @param object
     *            object of statement
     * @param namedGraphURI
     *            namedgraphURI of statement
     * @return true if handled ok
     * @throws AnzoException
     */
    public boolean handleStatement(Resource subject, URI predicate, Value object, URI namedGraphURI) throws AnzoException;

    /**
     * Handle the bindables for this solution set
     * 
     * @param bindables
     *            bindables
     * @return true if handles ok
     * @throws AnzoException
     */
    public boolean handleBindings(Collection<Bindable> bindables) throws AnzoException;

    /**
     * Handle a pattern solution
     * 
     * @param solution
     *            pattern solution
     * @return true if handle ok
     * @throws AnzoException
     */
    public boolean handleSolution(PatternSolution solution) throws AnzoException;

}
