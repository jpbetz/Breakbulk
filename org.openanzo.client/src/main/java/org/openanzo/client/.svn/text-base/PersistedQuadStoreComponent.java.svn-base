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

import java.util.Dictionary;
import java.util.HashSet;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.jdbc.container.RDBDictionary;
import org.openanzo.jdbc.container.RDBQuadStore;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.NamedGraph;

/**
 * IQuadStoreComponent that stores its data in a persisted rdb
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class PersistedQuadStoreComponent implements IQuadStoreComponent {

    RDBQuadStore                   quadStore          = null;

    TransactionQueue               transactionQueue   = null;

    ClientPersistence              persistence        = null;

    String                         containerName      = null;

    private static HashSet<String> reservedContainers = new HashSet<String>();

    @SuppressWarnings("unchecked")
    private Dictionary             properties         = null;

    /**
     * Create a new memory backed quad store component
     */
    @SuppressWarnings("unchecked")
    PersistedQuadStoreComponent(Dictionary properties) {
        this.properties = properties;
    }

    public void start() throws AnzoException {
        this.containerName = RDBDictionary.getContainerName(properties);

        if (reservedContainers.contains(containerName))
            throw new AnzoException(ExceptionConstants.CLIENT.DB_ALREADY_OPEN, containerName);
        reservedContainers.add(containerName);

        this.persistence = new ClientPersistence(properties);
        this.quadStore = persistence.quadStore;
        this.transactionQueue = new TransactionQueue(this.persistence.transactionPersistence);
    }

    public void close() throws AnzoException {
        reservedContainers.remove(containerName);
    }

    public void reset() throws AnzoException {
        this.quadStore.clear();
    }

    public IQuadStore getQuadStore() throws AnzoException {
        return quadStore;
    }

    public TransactionQueue getTransactionQueue() throws AnzoException {
        return transactionQueue;
    }

    public GraphTable getReplicaGraphTable(AnzoClient client) throws AnzoException {
        INamedGraph datasetGraph = new NamedGraph(GraphTable.REPLICA_GRAPH_TABLE_DATASET_URI, quadStore);
        return new GraphTable(client, datasetGraph);
    }

    public String getContainerName() {
        return this.containerName;
    }

    public void drop() throws AnzoException {
        persistence.drop();
    }
}
