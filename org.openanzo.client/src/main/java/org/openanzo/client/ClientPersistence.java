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

import java.util.Dictionary;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.container.RDBQuadStore;
import org.openanzo.ontologies.persistence.ClientPersistenceFactory;
import org.openanzo.ontologies.persistence.ClientPersistenceRoot;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.URI;

/**
 * Manages persistence of client state: replication marker, trackers and transaction queues.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class ClientPersistence {
    static final URI                       storageUri = Constants.valueFactory.createURI("http://openanzo.org/reserved/localStorage");

    protected final ClientPersistenceRoot  clientStore;

    protected final RDBQuadStore           quadStore;

    protected final TransactionPersistence transactionPersistence;

    @SuppressWarnings("unchecked")
    ClientPersistence(Dictionary properties) throws AnzoException {
        // this quad store is for the statements
        quadStore = createRdbQuadStore("_c", properties);

        // this persistent quad store if for the transaction queue and replica graph table
        RDBQuadStore transactionQueueStore = createRdbQuadStore("_t", properties);

        this.transactionPersistence = new TransactionPersistence(transactionQueueStore);
        this.clientStore = ClientPersistenceFactory.createClientPersistenceRoot(storageUri, new NamedGraph(storageUri, quadStore));
    }

    private RDBQuadStore createRdbQuadStore(String postfix, Dictionary<Object, Object> properties) throws AnzoException {
        CoreDBConfiguration configuration = CoreDBConfiguration.createConfiguration(properties);
        String containerName = configuration.getContainerName();
        String tmpContainerName = containerName + postfix;
        configuration.setContainerName(tmpContainerName);
        RDBQuadStore quadStore = RDBQuadStore.createQuadStore(configuration, true);
        quadStore.connect();
        return quadStore;
    }

    public void clear() {
        quadStore.clear();
        transactionPersistence.clear();
    }

    public void drop() {
        RDBQuadStore clientStore = quadStore;
        clientStore.clearDatabase();

        RDBQuadStore transactionStore = (RDBQuadStore) transactionPersistence.quadStore;
        transactionStore.clearDatabase();
    }

}
