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

package org.openanzo.client;

import java.util.List;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.URI;

/**
 * Listener that receives events about the status of transactions
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface ITransactionListener {
    /**
     * Transaction was completed successfully
     * 
     * @param transactionURI
     *            URI of the transaction
     * @param transactionTimestamp
     *            timestamp of when the transaction was processed on the server
     * @param transactionGraphs
     *            Set of graphs that were affected by this transaction
     * @param transactionContext
     *            Set of statements that provide context/metadata about the transaction
     */
    public void transactionComplete(URI transactionURI, long transactionTimestamp, Set<URI> transactionGraphs, IDataset transactionContext);

    /**
     * The transaction failed to commit successfully on the server
     * 
     * @param transactionURI
     *            URI of the transaction
     * @param transactionGraphs
     *            Graphs that were a part of this transaction
     * @param transactionContext
     *            Set of statements that provide context/metadata about the transaction
     * @param errors
     *            Errors that caused the transaction to fail
     */
    public void transactionFailed(URI transactionURI, Set<URI> transactionGraphs, IDataset transactionContext, List<AnzoException> errors);

}
