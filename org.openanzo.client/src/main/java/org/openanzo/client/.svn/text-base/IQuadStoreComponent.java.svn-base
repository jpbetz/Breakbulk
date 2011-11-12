/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 6, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.IQuadStore;

/**
 * Interface for a quadstore
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IQuadStoreComponent {
    /**
     * Get the IQuadStore storage
     * 
     * @return IQuadStore object
     * @throws AnzoException
     */
    IQuadStore getQuadStore() throws AnzoException;

    /**
     * Get the transaction queue for the component
     * 
     * @return the TransactionQueue for this component
     * @throws AnzoException
     */
    TransactionQueue getTransactionQueue() throws AnzoException;

    /**
     * Return the replica graph table.
     * 
     * @param client
     *            get the replicagraphtable for the given client
     * @return GraphTable
     * @throws AnzoException
     */
    GraphTable getReplicaGraphTable(AnzoClient client) throws AnzoException;

    /**
     * Get the container name
     * 
     * @return container name
     * @throws AnzoException
     */
    String getContainerName() throws AnzoException;

    void drop() throws AnzoException;

    void reset() throws AnzoException;

    void start() throws AnzoException;

    void close() throws AnzoException;
}
