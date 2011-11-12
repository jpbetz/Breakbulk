/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 18, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi.registry;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.pool.AnzoClientPool;
import org.openanzo.client.pool.RestrictedAnzoClient;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.osgi.registry.internal.RegistryProvider;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Registry Dataset is a special dataset that is backed by a namedgraph in the registry datasource
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class RegistryDataset implements IDataset {

    //private static final Logger      log                 = LoggerFactory.getLogger(RegistryDataset.class);

    private IDataset                       parent              = null;

    private final RestrictedAnzoClient     anzoClient;

    private final AnzoClientPool           anzoClientPool;

    private final RegistryProvider         registryProvider;

    private final Set<IDatasourceListener> datasourceListeners = new HashSet<IDatasourceListener>();

    private final ReentrantLock            resetLock           = new ReentrantLock();

    private URI                            registryURI         = null;

    /**
     * Create a RegistryDataset for the given uri
     * 
     * @param registryProvider
     *            registry provider
     * @param registryUri
     *            URI for the registry
     * @param userDescription
     *            description of user/service opening registry
     * @param anzoClientPool
     *            anzo client pool used to open registry graph
     * @throws AnzoException
     */
    public RegistryDataset(RegistryProvider registryProvider, URI registryUri, String userDescription, AnzoClientPool anzoClientPool) throws AnzoException {
        this.registryURI = registryUri;
        this.registryProvider = registryProvider;
        this.anzoClient = anzoClientPool.getAnzoClient(false, userDescription);
        this.anzoClient.begin();
        parent = anzoClient.createReplicaDataset(true, registryUri, null, null, AnzoClient.REVISIONED_NAMED_GRAPH);
        this.anzoClient.commit();
        this.anzoClient.updateRepository();
        this.anzoClientPool = anzoClientPool;
    }

    /**
     * 
     * @return true if the AnzoClient under the registry is closed
     */
    public boolean isClosed() {
        return !anzoClient.isConnected();
    }

    /**
     * Start a transaction to update registry data
     */
    public void beginUpdatingRegistry() {
        if (anzoClient.inTransaction()) {
            System.err.println("Already in transaction");
        }
        anzoClient.begin();
    }

    /**
     * Commit the current transaction
     * 
     * @throws AnzoException
     */
    public void commitRegistry() throws AnzoException {
        anzoClient.commit();
        anzoClient.updateRepository();
    }

    /**
     * Abort the current transaction
     * 
     * @throws AnzoException
     */
    public void abortRegistry() {
        anzoClient.abort();
    }

    /**
     * 
     * @return true if in transaction
     */
    public boolean inTransaction() {
        return anzoClient.inTransaction();
    }

    /**
     * Close the registry
     */
    public void close() throws AnzoException {
        resetLock.lock();
        try {
            parent.close();
            anzoClientPool.returnAnzoClient(anzoClient);
            registryProvider.getRegistries().remove(this);
        } finally {
            resetLock.unlock();
        }
    }

    /**
     * Server reset is starting, let all listeners know
     * 
     * @throws AnzoException
     */
    public void resetStarting() throws AnzoException {
        for (IDatasourceListener listener : datasourceListeners) {
            if (listener != null)
                listener.resetStarting();
        }
        resetLock.lock();
    }

    /**
     * Server reset in process, clean up and notify listeners to reset
     * 
     * @throws AnzoException
     */
    public void reset() throws AnzoException {
        parent.close();
        anzoClient.clear();
        for (IDatasourceListener listener : datasourceListeners) {
            if (listener != null)
                listener.reset();
        }
    }

    /**
     * Server reset is completed, reopen registry with new data
     * 
     * @throws AnzoException
     */
    public void postReset() throws AnzoException {
        anzoClient.begin();
        parent = anzoClient.createReplicaDataset(true, this.registryURI, null, null, AnzoClient.REVISIONED_NAMED_GRAPH);
        anzoClient.commit();
        anzoClient.updateRepository();
        for (IDatasourceListener listener : datasourceListeners) {
            if (listener != null)
                listener.postReset();
        }
    }

    /**
     * Server reset is completed, reopen registry with new data
     * 
     * @throws AnzoException
     */
    public void resetFinished() throws AnzoException {
        try {
            for (IDatasourceListener listener : datasourceListeners) {
                if (listener != null)
                    listener.resetFinished();
            }
        } finally {
            resetLock.unlock();
        }
    }

    /**
     * Register a datasource listener
     * 
     * @param listener
     *            listener to register
     */
    public void registerDatasourceListener(IDatasourceListener listener) {
        datasourceListeners.add(listener);
    }

    /**
     * Unregister a datasource listener
     * 
     * @param listener
     *            listener to unregister
     */
    public void unregisterDatasourceListener(IDatasourceListener listener) {
        datasourceListeners.remove(listener);
    }

    // all the other methods are just straight passthroughs. 

    public INamedGraph addDefaultGraph(URI uri) {
        return parent.addDefaultGraph(uri);
    }

    public INamedGraph addNamedGraph(URI uri) {
        return parent.addNamedGraph(uri);
    }

    public void clear() {
        parent.clear();
    }

    public boolean containsDefaultGraph(URI uri) {
        return parent.containsDefaultGraph(uri);
    }

    public boolean containsNamedGraph(URI uri) {
        return parent.containsNamedGraph(uri);
    }

    public QueryResults executeQuery(String query) throws AnzoException {
        return parent.executeQuery(query);
    }

    public Collection<Statement> find(boolean includeEntireDataset, Resource subj, URI prop, Value obj, URI... namedGraphUris) {
        return parent.find(includeEntireDataset, subj, prop, obj, namedGraphUris);
    }

    public INamedGraph getDatasetGraph() {
        return parent.getDatasetGraph();
    }

    public INamedGraph getDefaultGraph(URI uri) {
        return parent.getDefaultGraph(uri);
    }

    public Set<URI> getDefaultGraphUris() {
        return parent.getDefaultGraphUris();
    }

    public INamedGraph getNamedGraph(URI uri) {
        return parent.getNamedGraph(uri);
    }

    public Set<URI> getNamedGraphUris() {
        return parent.getNamedGraphUris();
    }

    public URI getURI() {
        return parent.getURI();
    }

    public void removeDefaultGraph(URI uri) {
        parent.removeDefaultGraph(uri);

    }

    public void removeNamedGraph(URI uri) {
        parent.removeNamedGraph(uri);
    }

    public void setDefaultGraphs(Set<URI> defaultGraphUris) {
        parent.setDefaultGraphs(defaultGraphUris);
    }

    public void setNamedGraphs(Set<URI> namedGraphUris) {
        parent.setNamedGraphs(namedGraphUris);
    }

    public void add(Collection<Statement> statements) {
        parent.add(statements);
    }

    public void add(Resource subj, URI pred, Value obj, URI namedGraphUri) {
        parent.add(subj, pred, obj, namedGraphUri);
    }

    public void add(Statement... statements) {
        parent.add(statements);
    }

    public boolean contains(Resource subj, URI prop, Value obj, URI... namedGraphUri) {
        return parent.contains(subj, prop, obj, namedGraphUri);
    }

    public boolean contains(Statement statement) {
        return parent.contains(statement);
    }

    public QueryResults executeQuery(Set<URI> defaultGraph, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        return parent.executeQuery(defaultGraph, namedGraphs, namedDatasets, query, baseUri);
    }

    public Collection<Statement> find(Resource subj, URI prop, Value obj, URI... namedGraphUri) {
        return parent.find(subj, prop, obj, namedGraphUri);
    }

    public Collection<Statement> getStatements() {
        return parent.getStatements();
    }

    public boolean isEmpty() {
        return parent.isEmpty();
    }

    public void remove(Collection<Statement> statements) {
        parent.remove(statements);
    }

    public void remove(Resource subj, URI prop, Value obj, URI... namedGraphUri) {
        parent.remove(subj, prop, obj, namedGraphUri);
    }

    public void remove(Statement... statements) {
        parent.remove(statements);
    }

    public int size() {
        return parent.size();
    }

    public int size(URI... namedGraphUris) {
        return parent.size(namedGraphUris);
    }

    public void notifyAddStatements(Statement... statements) {
        parent.notifyAddStatements(statements);
    }

    public void notifyRemoveStatements(Statement... statements) {
        parent.notifyRemoveStatements(statements);
    }

    public void registerListener(IStatementListener<IDataset> listener) {
        parent.registerListener(listener);
    }

    public void unregisterListener(IStatementListener<IDataset> listener) {
        parent.unregisterListener(listener);
    }

    /**
     * @return the resetLock
     */
    public ReentrantLock getResetLock() {
        return resetLock;
    }
}
