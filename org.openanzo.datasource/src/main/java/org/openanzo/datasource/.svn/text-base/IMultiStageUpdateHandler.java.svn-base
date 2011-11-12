/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 27, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource;

import java.util.Collection;

import org.openanzo.datasource.update.UpdateChanges;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.IOperationContext;

/**
 * Interface used during the update process to do the multiple steps of update
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IMultiStageUpdateHandler {
    /**
     * Get the current context for the update call
     * 
     * @return the current context for the update call
     */
    public IOperationContext getContext();

    /*
     * Commiting a transaction to the backend is a 6 step process
     */

    /**
     * Step 1: start the transaction in the backend
     * 
     * @param transactionId
     *            Id of the transaction
     * @param transactionURI
     *            URI of the transaction
     * @param namedGraphs
     *            collection of namedgraphs affected by transaction
     * @param transactionContext
     *            context for transaction
     * @throws AnzoException
     */
    public void beginTransaction(Long transactionId, URI transactionURI, Collection<URI> namedGraphs, Collection<Statement> transactionContext) throws AnzoException;

    /**
     * Step 2: initialize any structures in the backend pertinent to the transaction, ie creating node objects in node-centric
     * 
     * @throws AnzoException
     */
    public void prepareForUpdate() throws AnzoException;

    /**
     * Step 3: insert updates into the database, but these updates should still be in a pre-committed state
     * 
     * @param updateResults
     *            Update results object to which updates are written
     * @param transactionStart
     *            Timestamp of when the transaction was committed
     * @param userURI
     *            URI of the user committing the transaction
     * @throws AnzoException
     */
    public void insertUpdates(UpdateChanges updateResults, long transactionStart, URI userURI) throws AnzoException;

    /**
     * Step 4: commit the outstanding changes from step 3 and 4.
     * 
     * @param transaction
     *            The transaction object being committed
     * @param namedGraphs
     *            Collection of graphs affected by transaction
     * @throws AnzoException
     */
    public void commitTransaction(org.openanzo.datasource.update.ServerUpdateTransaction transaction, Collection<URI> namedGraphs) throws AnzoException;

    /**
     * Abort any of the above steps
     * 
     * @throws AnzoException
     */
    public void abort() throws AnzoException;

}
