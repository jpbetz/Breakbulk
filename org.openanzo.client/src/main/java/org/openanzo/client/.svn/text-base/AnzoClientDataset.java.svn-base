/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Jan 4, 2008
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.DatasetBase;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.vocabulary.Anzo;
import org.openanzo.rdf.vocabulary.RDF;

/**
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
class AnzoClientDataset extends DatasetBase {

    //private static final Logger      log          = LoggerFactory.getLogger(AnzoClientDataset.class);
    enum DatasetType {
        SERVER, REPLICA, MEMORY_ONLY
    }

    private ThreadLocal<HashSet<URI>>              isolatedDefaultGraphs = new ThreadLocal<HashSet<URI>>();

    private ThreadLocal<HashSet<URI>>              isolatedNamedGraphs   = new ThreadLocal<HashSet<URI>>();

    private ThreadLocal<HashMap<URI, INamedGraph>> isolatedGraphs        = new ThreadLocal<HashMap<URI, INamedGraph>>();

    private boolean                                persisted             = false;

    private final DatasetType                      type;

    private final AnzoClient                       client;

    private final INamedGraphInitializer[]         initializers;

    AnzoClientDataset(AnzoClient client, URI datasetUri, DatasetType type, boolean persisted, Set<URI> defaultGraphUris, Set<URI> namedGraphUris, INamedGraphInitializer... namedGraphInitializers) {
        this.datasetUri = datasetUri;
        this.type = type;
        this.persisted = persisted;
        this.client = client;
        this.initializers = namedGraphInitializers;
        super.initialize();

        if (namedGraphUris != null) {
            for (URI uri : namedGraphUris) {
                addNamedGraph(uri);
            }
        }

        if (defaultGraphUris != null) {
            for (URI uri : defaultGraphUris) {
                addDefaultGraph(uri);
            }
        }
        client.datasets.add(this);
    }

    @Override
    public void close() {
        super.close();
        client.datasets.remove(this);
    }

    protected void commit() {
        if (isolatedDefaultGraphs.get() != null) {
            if (getLock() != null) {
                getLock().lock();
            }
            try {
                for (URI uri : isolatedDefaultGraphs.get()) {
                    defaultGraphUris.add(uri);
                }
                isolatedDefaultGraphs.get().clear();
            } finally {
                if (getLock() != null) {
                    getLock().unlock();
                }
            }

        }
        if (isolatedNamedGraphs.get() != null) {
            if (getLock() != null) {
                getLock().lock();
            }
            try {
                for (URI uri : isolatedNamedGraphs.get()) {
                    namedGraphUris.add(uri);
                }
                isolatedNamedGraphs.get().clear();
            } finally {
                if (getLock() != null) {
                    getLock().unlock();
                }
            }
        }
        if (isolatedGraphs.get() != null) {
            if (getLock() != null) {
                getLock().lock();
            }
            try {
                synchronized (graphs) {
                    for (Map.Entry<URI, INamedGraph> entry : isolatedGraphs.get().entrySet()) {
                        graphs.put(entry.getKey(), entry.getValue());
                    }
                }
                isolatedGraphs.get().clear();
            } finally {
                if (getLock() != null) {
                    getLock().unlock();
                }
            }
        }
    }

    @Override
    public void clear() {
        super.clear();
        abort();
    }

    protected void abort() {
        if (isolatedDefaultGraphs.get() != null) {
            isolatedDefaultGraphs.get().clear();
        }
        if (isolatedNamedGraphs.get() != null) {
            isolatedNamedGraphs.get().clear();
        }
        if (isolatedGraphs.get() != null) {
            isolatedGraphs.get().clear();
        }
    }

    @Override
    protected ReentrantLock getLock() {
        return client.clientLock;
    }

    @Override
    protected boolean addType() {
        if (datasetUri == null) {
            return false;
        }
        if (type != DatasetType.SERVER) {
            return !datasetGraph.contains(datasetUri, RDF.TYPE, Anzo.DATASET_TYPE);
        } else {
            return true;
        }
    }

    @Override
    protected NamedGraph createNamedGraph(URI namedGraphUri) {
        try {
            switch (type) {
            case MEMORY_ONLY:
                return new NamedGraph(namedGraphUri);
            case REPLICA:
                boolean exists = client.namedGraphExists(namedGraphUri);
                if (!exists) {
                    client.begin();
                }
                ClientGraph graph = client.getReplicaGraph(namedGraphUri, initializers);
                if (!exists) {
                    client.commit();
                    if (!client.inTransaction()) {
                        client.updateRepository();
                    }
                }
                return graph;
            default:
                return client.getServerGraph(namedGraphUri, initializers);
            }
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

    @Override
    protected INamedGraph createDatasetGraph() {
        try {
            if (type == DatasetType.MEMORY_ONLY || type == DatasetType.REPLICA) {
                if (persisted) {
                    return client.getReplicaGraph(this.datasetUri, initializers);
                } else {
                    return new NamedGraph(this.datasetUri);
                }
            } else { // server
                if (persisted) {
                    return client.getServerGraph(this.datasetUri, initializers);
                } else {
                    return new NamedGraph(this.datasetUri);
                }
            }
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

    @Override
    public INamedGraph addDefaultGraphInternal(URI namedGraphUri) {
        if (namedGraphUri == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER);
        }
        if (defaultGraphUris.contains(namedGraphUri)) {
            return graphs.get(namedGraphUri);
        }
        INamedGraph graph = null;
        if (client.inTransaction()) {
            graph = graphs.get(namedGraphUri);
            if (isolatedDefaultGraphs.get() == null) {
                isolatedDefaultGraphs.set(new HashSet<URI>());
            }
            if (isolatedGraphs.get() != null && isolatedGraphs.get().containsKey(namedGraphUri) && graph == null) {
                graph = isolatedGraphs.get().get(namedGraphUri);
            }
            if (graph == null) {
                graph = createNamedGraph(namedGraphUri);
                if (graphListener != null) {
                    graph.registerListener(graphListener);
                }
                if (isolatedGraphs.get() == null) {
                    isolatedGraphs.set(new HashMap<URI, INamedGraph>());
                }
                isolatedGraphs.get().put(namedGraphUri, graph);
            }
            if (!isolatedDefaultGraphs.get().contains(namedGraphUri)) {
                isolatedDefaultGraphs.get().add(namedGraphUri);
            }
        } else {
            graph = super.addDefaultGraphInternal(namedGraphUri);
        }
        return graph;
    }

    @Override
    public INamedGraph addNamedGraphInternal(URI namedGraphUri) {
        if (namedGraphUri == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER);
        }
        if (namedGraphUris.contains(namedGraphUri)) {
            return graphs.get(namedGraphUri);
        }
        INamedGraph graph = null;
        if (client.inTransaction()) {
            graph = graphs.get(namedGraphUri);
            if (isolatedNamedGraphs.get() == null) {
                isolatedNamedGraphs.set(new HashSet<URI>());
            }
            if (isolatedGraphs.get() != null && isolatedGraphs.get().containsKey(namedGraphUri) && graph == null) {
                graph = isolatedGraphs.get().get(namedGraphUri);
            }
            if (graph == null) {
                graph = createNamedGraph(namedGraphUri);
                if (graphListener != null) {
                    graph.registerListener(graphListener);
                }
                if (isolatedGraphs.get() == null) {
                    isolatedGraphs.set(new HashMap<URI, INamedGraph>());
                }
                isolatedGraphs.get().put(namedGraphUri, graph);
            }
            if (!isolatedNamedGraphs.get().contains(namedGraphUri)) {
                isolatedNamedGraphs.get().add(namedGraphUri);
            }
        } else {
            graph = super.addNamedGraphInternal(namedGraphUri);
        }
        return graph;
    }

    @Override
    public INamedGraph getDefaultGraph(URI namedGraphUri) {
        if (!defaultGraphUris.contains(namedGraphUri)) {
            if (client.inTransaction()) {
                if (isolatedDefaultGraphs.get() != null) {
                    if (isolatedDefaultGraphs.get().contains(namedGraphUri)) {
                        if (graphs.containsKey(namedGraphUri)) {
                            return graphs.get(namedGraphUri);
                        } else if (isolatedGraphs.get() != null) {
                            return isolatedGraphs.get().get(namedGraphUri);
                        }
                    }
                }
                return null;
            } else {
                return null;
            }
        }
        return graphs.get(namedGraphUri);
    }

    @Override
    public INamedGraph getNamedGraph(URI namedGraphUri) {
        if (!namedGraphUris.contains(namedGraphUri)) {
            if (client.inTransaction()) {
                if (isolatedNamedGraphs.get() != null) {
                    if (isolatedNamedGraphs.get().contains(namedGraphUri)) {
                        if (graphs.containsKey(namedGraphUri)) {
                            return graphs.get(namedGraphUri);
                        } else if (isolatedGraphs.get() != null) {
                            return isolatedGraphs.get().get(namedGraphUri);
                        }
                    }
                }
                return null;
            } else {
                return null;
            }
        }
        return graphs.get(namedGraphUri);
    }

    @Override
    public boolean containsNamedGraph(URI uri) {
        boolean result = namedGraphUris.contains(uri);
        if (result) {
            return result;
        } else {
            if (client.inTransaction()) {
                return (isolatedNamedGraphs.get() != null) ? isolatedNamedGraphs.get().contains(uri) : false;
            }
        }
        return false;
    }

    @Override
    public boolean containsDefaultGraph(URI uri) {
        boolean result = defaultGraphUris.contains(uri);
        if (result) {
            return result;
        } else {
            if (client.inTransaction()) {
                return (isolatedDefaultGraphs.get() != null) ? isolatedDefaultGraphs.get().contains(uri) : false;
            }
        }
        return false;
    }

    @Override
    public Set<URI> getDefaultGraphUris() {
        Set<URI> results = super.getDefaultGraphUris();
        if (client.inTransaction() && isolatedDefaultGraphs.get() != null) {
            HashSet<URI> newResults = new HashSet<URI>();
            newResults.addAll(results);
            newResults.addAll(isolatedDefaultGraphs.get());
            return newResults;

        }
        return results;
    }

    @Override
    public Set<URI> getNamedGraphUris() {
        Set<URI> results = super.getNamedGraphUris();
        if (client.inTransaction() && isolatedNamedGraphs.get() != null) {
            HashSet<URI> newResults = new HashSet<URI>();
            newResults.addAll(results);
            newResults.addAll(isolatedNamedGraphs.get());
            return newResults;

        }
        return results;
    }

    @Override
    protected INamedGraph getGraph(URI namedGraphUri) {
        INamedGraph graph = super.getGraph(namedGraphUri);
        if (graph == null && client.inTransaction() && isolatedGraphs.get() != null) {
            return isolatedGraphs.get().get(namedGraphUri);

        }
        return graph;
    }

    @Override
    protected Map<URI, INamedGraph> getGraphs() {
        Map<URI, INamedGraph> results = super.getGraphs();
        if (client.inTransaction() && isolatedGraphs.get() != null) {
            HashMap<URI, INamedGraph> newResults = new HashMap<URI, INamedGraph>(results);
            newResults.putAll(isolatedGraphs.get());
            return newResults;
        }
        return results;
    }
}
