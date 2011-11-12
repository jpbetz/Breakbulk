/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Dec 6, 2007
 * Revision: $Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.DatasetBase;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.UriGenerator;

/**
 * 
 * Stores reference counts for AnzoGraph instances.
 * 
 * This class is thread safe.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
public class GraphTable {
    ReentrantReadWriteLock  lock                            = new ReentrantReadWriteLock();

    public static final URI REPLICA_GRAPH_TABLE_DATASET_URI = Constants.valueFactory.createURI("http://openanzo.org/datasets/replicaGraphTable");

    public enum ReleaseResult {
        OPEN, CLOSE_INSTANCE, CLOSE_ALL
    }

    public enum Type {
        REPLICA, SERVER
    }

    Type type;

    /**
     * Holds a graph and it's reference count.
     * 
     * @param
     */
    protected static class TableEntry {
        ClientGraph graph;

        long        count;

        public TableEntry(ClientGraph graph) {
            this.graph = graph;
            count = 1;
        }
    }

    protected final HashMap<URI, TableEntry>                           table          = new HashMap<URI, TableEntry>();

    private final ThreadLocal<HashMap<URI, TableEntry>>                isolatedTable  = new ThreadLocal<HashMap<URI, TableEntry>>();

    private final ThreadLocal<GraphTableDataset>                       dataset        = new ThreadLocal<GraphTableDataset>();

    private final List<HashMap<URI, TableEntry>>                       isolatedTables = new ArrayList<HashMap<URI, TableEntry>>();

    protected final HashMap<URI, Set<IStatementListener<INamedGraph>>> listeners      = new HashMap<URI, Set<IStatementListener<INamedGraph>>>();

    protected final HashMap<URI, Set<IStatementListener<INamedGraph>>> metaListeners  = new HashMap<URI, Set<IStatementListener<INamedGraph>>>();

    private final AnzoClient                                           anzoClient;

    private final INamedGraph                                          persistedDatasetGraph;

    public GraphTable(AnzoClient anzoClient) {
        this(anzoClient, null);
    }

    /**
     * This version of the constructor is used for persistence
     * 
     * @param f
     * @param datasetGraph
     */
    public GraphTable(AnzoClient anzoClient, INamedGraph persistedDatasetGraph) {
        this.anzoClient = anzoClient;
        this.persistedDatasetGraph = persistedDatasetGraph;
        // the resulting set of calls that go and create all the replica graphs
        // in the case of persistence is a bit complicated, but it works.
        // The GraphTableDataset constructor uses the persistedDatasetGraph
        // to load all the replica graphs
        dataset.set(new GraphTableDataset());
    }

    void close() {

        // if we are in persistence,
        // we could have loaded up replica
        // graphs on startup that never got 
        // touched.  If so, we close them
        // note that such graphs never can 
        // exist in the isolated table because
        // the loading of such graphs does not
        // occur inside a transaction
        Set<ClientGraph> graphsToClose = new HashSet<ClientGraph>();
        if (persistedDatasetGraph != null) {
            for (URI uri : table.keySet()) {
                TableEntry entry = table.get(uri);
                if (entry.count == 0) {
                    // this close call, in a roundabout way,
                    // will come back and remove the graph
                    // from the table and modify the dataset
                    graphsToClose.add(entry.graph);
                    //entry.graph.close();
                }
            }
        }
        for (ClientGraph graph : graphsToClose) {
            graph.close();
        }

        table.clear();
        if (dataset.get() != null) {
            dataset.get().close();
        }
    }

    public void clear() {
        table.clear();
        // do we need to do this for all the thread-locals ?
        dataset.remove();
        for (HashMap<URI, TableEntry> t : isolatedTables) {
            t.clear();
        }
        listeners.clear();
        metaListeners.clear();
    }

    /**
     * Sets or replaces the entry in the graph table for the provided URI and graph. The reference count will be 1 after this call returns.
     * 
     * @param namedGraphUri
     *            The URI of the graph.
     * @param graph
     *            The graph.
     */
    public void put(URI namedGraphUri, ClientGraph graph) {
        lock.writeLock().lock();
        try {
            if (anzoClient.inTransaction() && isolatedTable.get() == null) {
                isolatedTable.set(new HashMap<URI, TableEntry>());
                isolatedTables.add(isolatedTable.get());
            }
            TableEntry tableEntry = new TableEntry(graph);
            tableEntry.count = 1;

            if (anzoClient.inTransaction()) {
                isolatedTable.get().put(namedGraphUri, tableEntry);
            } else {
                table.put(namedGraphUri, tableEntry);
            }
            if (dataset.get() == null) {
                getDataset();
            }
            dataset.get().addGraph(graph);

        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * Increments the reference count for the graph matching the URI if it is already in the table and returns the graph, otherwise returns null.
     * 
     * @param namedGraphUri
     *            A named graph URI.
     * @return A graph matching the URI
     */
    public ClientGraph get(URI namedGraphUri) {
        ClientGraph result = null;
        lock.writeLock().lock();
        try {
            TableEntry tableEntry = null;
            if (isolatedTable.get() != null) {
                tableEntry = isolatedTable.get().get(namedGraphUri);
            }
            if (tableEntry == null) {
                tableEntry = table.get(namedGraphUri);
            }
            if (tableEntry != null) {
                tableEntry.count++;
                result = tableEntry.graph;
            }
        } finally {
            lock.writeLock().unlock();
        }
        return result;
    }

    /**
     * Returns whether or not this URI is contained in the graph table..includes isolated tables as well.
     * 
     * @param namedGraphUri
     * @return true if contains the graph based on uri
     */
    boolean contains(URI namedGraphUri) {
        lock.readLock().lock();
        try {
            TableEntry tableEntry = null;
            if (isolatedTable.get() != null) {
                tableEntry = isolatedTable.get().get(namedGraphUri);
            }
            if (tableEntry == null) {
                tableEntry = table.get(namedGraphUri);
            }
            if (tableEntry != null) {
                return true;
            } else {
                return false;
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Decrements the reference count for the graph with the provided URI and removes it from the table if the reference count reaches zero.
     * 
     * @param namedGraphUri
     *            The graph URI to release.
     * @return True if the reference count reached zero or was already zero.
     */
    ReleaseResult release(URI namedGraphUri) {
        return release(namedGraphUri, true);
    }

    /**
     * Decrements the reference count for the graph with the provided URI and removes it from the table if the reference count reaches zero.
     * 
     * @param namedGraphUri
     *            The graph URI to release.
     * @param removeIfZeroReference
     *            Remove te graph if this is the last reference
     * @return True if the reference count reached zero or was already zero.
     */
    ReleaseResult release(URI namedGraphUri, boolean removeIfZeroReference) {
        ReleaseResult result = ReleaseResult.OPEN;
        lock.writeLock().lock();
        try {
            TableEntry tableEntry = null;

            if (isolatedTable.get() != null) {
                tableEntry = isolatedTable.get().get(namedGraphUri);
            }

            boolean isolated = false;
            if (tableEntry == null) {
                tableEntry = table.get(namedGraphUri);
            } else {
                isolated = true;
            }
            if (tableEntry == null) {
                if (graphExistsInSomeIsolatedTable(namedGraphUri)) {
                    result = ReleaseResult.CLOSE_INSTANCE;
                } else {
                    result = ReleaseResult.CLOSE_ALL;
                }
            } else {
                tableEntry.count--;
                if (tableEntry.count <= 0 && removeIfZeroReference) {
                    if (isolated) {
                        isolatedTable.get().remove(namedGraphUri);
                    } else {
                        table.remove(namedGraphUri);
                    }
                    if (dataset.get() == null) {
                        getDataset();
                    }
                    dataset.get().removeGraph(namedGraphUri);
                    if (graphExistsInSomeIsolatedTable(namedGraphUri)) {
                        result = ReleaseResult.CLOSE_INSTANCE;
                    } else {
                        listeners.remove(namedGraphUri);
                        metaListeners.remove(namedGraphUri);
                        result = ReleaseResult.CLOSE_ALL;
                    }
                }
            }
        } finally {
            lock.writeLock().unlock();
        }
        return result;
    }

    private boolean graphExistsInSomeIsolatedTable(URI uri) {
        for (HashMap<URI, TableEntry> table : isolatedTables) {
            if (table.containsKey(uri)) {
                return true;
            }
        }
        return table.containsKey(uri);
    }

    GraphTableDataset getDataset() {
        if (dataset.get() == null) {
            GraphTableDataset ds = new GraphTableDataset();
            for (ClientGraph graph : listAll()) {
                ds.addGraph(graph);
            }
            dataset.set(ds);
        }
        return dataset.get();
    }

    /**
     * Returns a set of all the graphs in the table.
     * 
     * @return Set containing all the graphs in the table.
     */
    Set<ClientGraph> listAll() {
        Set<ClientGraph> results = new HashSet<ClientGraph>();
        lock.readLock().lock();
        try {
            if (isolatedTable.get() != null) {
                for (TableEntry entry : isolatedTable.get().values()) {
                    results.add(entry.graph);
                }
            }
            for (TableEntry entry : table.values()) {
                results.add(entry.graph);
            }
        } finally {
            lock.readLock().unlock();
        }
        return results;

    }

    void mergeIsolatedGraphs() {
        lock.writeLock().lock();
        try {
            if (isolatedTable.get() != null) {
                Set<URI> toRemove = new HashSet<URI>();
                for (URI uri : isolatedTable.get().keySet()) {
                    TableEntry isolatedEntry = isolatedTable.get().get(uri);
                    TableEntry entry = table.get(uri);
                    if (entry == null) {
                        table.put(uri, isolatedEntry);
                        toRemove.add(uri);
                    }
                }
                for (URI uri : toRemove) {
                    isolatedTable.get().remove(uri);
                }
                if (isolatedTable.get().isEmpty()) {
                    isolatedTables.remove(isolatedTable.get());
                    isolatedTable.remove();
                }
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    class GraphTableDataset extends DatasetBase {
        private ReentrantLock lock = new ReentrantLock();

        GraphTableDataset() {
            super(REPLICA_GRAPH_TABLE_DATASET_URI);
        }

        @Override
        protected ReentrantLock getLock() {
            return lock;
        }

        @Override
        protected INamedGraph createNamedGraph(URI namedGraphUri) {
            if (persistedDatasetGraph != null) {
                if (isolatedTable.get() != null && isolatedTable.get().get(namedGraphUri) != null) {
                    return isolatedTable.get().get(namedGraphUri).graph;
                } else if (table.get(namedGraphUri) != null) {
                    return table.get(namedGraphUri).graph;
                }
                URI metadataGraphUri = UriGenerator.generateMetadataGraphUri(namedGraphUri);
                NamedGraph metadataGraph = new MetadataGraph(metadataGraphUri, anzoClient.replicaGraphTransactionProxy, GraphTable.this);
                metadataGraph.setNotifyAddRemove(false);
                ClientGraph clientGraph = new ClientGraph(namedGraphUri, anzoClient.replicaGraphTransactionProxy, metadataGraph, anzoClient, GraphTable.this);
                // any initializers from persisted graphs will have already been run.
                TableEntry entry = new TableEntry(clientGraph);
                entry.count = 0;
                entry.graph = clientGraph;
                table.put(namedGraphUri, entry);
                return clientGraph;
            }
            throw new UnsupportedOperationException("Cannot create graphs inside GraphTableDataset");
        }

        @Override
        protected INamedGraph createDatasetGraph() {
            if (persistedDatasetGraph != null) {
                return persistedDatasetGraph;
            } else {
                return new NamedGraph(datasetUri);
            }
        }

        private void addGraph(ClientGraph graph) {
            synchronized (graphs) {
                graphs.put(graph.getNamedGraphUri(), graph);
            }
            addDefaultGraph(graph.getNamedGraphUri());
            addNamedGraph(graph.getNamedGraphUri());
        }

        private void removeGraph(URI namedGraphUri) {
            synchronized (graphs) {
                graphs.remove(namedGraphUri);
            }
            defaultGraphUris.remove(namedGraphUri);
            if (datasetGraph != null) {
                datasetGraph.remove(datasetUri, Dataset.defaultGraphProperty, namedGraphUri);
            }
            namedGraphUris.remove(namedGraphUri);
            if (datasetGraph != null) {
                datasetGraph.remove(datasetUri, Dataset.namedGraphProperty, namedGraphUri);
                datasetGraph.remove(datasetUri, Dataset.defaultNamedGraphProperty, namedGraphUri);
            }

        }

        @Override
        public INamedGraph addNamedGraph(URI namedGraphUri) {
            if (!graphs.containsKey(namedGraphUri)) {
                throw new UnsupportedOperationException("Cannot create graphs inside GraphTableDataset");
            }
            return super.addNamedGraph(namedGraphUri);
        }

        @Override
        public INamedGraph addDefaultGraph(URI namedGraphUri) {
            if (!graphs.containsKey(namedGraphUri)) {
                throw new UnsupportedOperationException("Cannot create graphs inside GraphTableDataset");
            }
            return super.addDefaultGraph(namedGraphUri);
        }

        @Override
        public void setDefaultGraphs(Set<URI> namedGraphUris) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setNamedGraphs(Set<URI> namedGraphUris) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void removeDefaultGraph(URI namedGraphUri) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void removeNamedGraph(URI namedGraphUri) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void close() {
            synchronized (graphs) {
                graphs.clear();
            }
            defaultGraphUris.clear();
            namedGraphUris.clear();
            dataset.remove();
        }

    }
}
