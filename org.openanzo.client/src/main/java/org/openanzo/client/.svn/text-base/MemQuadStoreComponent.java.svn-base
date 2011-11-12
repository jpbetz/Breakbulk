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

import org.openanzo.exceptions.AnzoException;
import org.openanzo.jdbc.container.RDBDictionary;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.MemQuadStore;

/**
 * Memory backed IQuadStoreComponent
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class MemQuadStoreComponent implements IQuadStoreComponent {
    IQuadStore         quadStore;

    TransactionQueue   transactionQueue;

    String             containerName;

    private boolean    shareQuadStore = false;

    @SuppressWarnings("unchecked")
    private Dictionary properties     = null;

    /**
     * Create a new memory backed quad store component
     */
    @SuppressWarnings("unchecked")
    MemQuadStoreComponent(Dictionary properties) {
        this.properties = properties;
    }

    public void start() throws AnzoException {
        this.containerName = RDBDictionary.getContainerName(properties);

        this.shareQuadStore = AnzoClientDictionary.getQuadstoreShared(properties);

        if (shareQuadStore) {
            this.quadStore = new MemQuadStore();
        }
        this.transactionQueue = new TransactionQueue();
    }

    public void close() throws AnzoException {
    }

    public void reset() throws AnzoException {
        if (shareQuadStore) {
            quadStore.clear();
        }
    }

    public IQuadStore getQuadStore() throws AnzoException {
        if (shareQuadStore) {
            return quadStore;
        } else {
            return new MemQuadStore();
        }
    }

    public TransactionQueue getTransactionQueue() throws AnzoException {
        return transactionQueue;
    }

    public GraphTable getReplicaGraphTable(AnzoClient anzoClient) throws AnzoException {
        return new GraphTable(anzoClient);
    }

    public String getContainerName() {
        return containerName;
    }

    public void drop() throws AnzoException {
    }
}
