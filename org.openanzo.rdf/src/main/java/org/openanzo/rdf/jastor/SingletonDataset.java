/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Dec 12, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.rdf.jastor;

import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
public class SingletonDataset implements IDataset {

    private static final Logger                                            log       = LoggerFactory.getLogger(SingletonDataset.class);

    private final INamedGraph                                              graph;

    private IStatementListener<INamedGraph>                                graphListener;

    private final CopyOnWriteArraySet<IStatementListener<IDataset>>        listeners = new CopyOnWriteArraySet<IStatementListener<IDataset>>();

    /** WeakHashMap cache of uris */
    static private final Map<INamedGraph, SoftReference<SingletonDataset>> cache     = new WeakHashMap<INamedGraph, SoftReference<SingletonDataset>>();

    /**
     * Get an instance of a singleton dataset for the graph provided, resuing one from cache if possible
     * 
     * @param graph
     *            graph for which to wrap with a dataset
     * @return dataset encapsulating a single graph
     */
    public static final SingletonDataset getInstance(INamedGraph graph) {
        synchronized (cache) {
            SingletonDataset result = null;
            SoftReference<SingletonDataset> ref = cache.get(graph);
            if (ref != null) {
                result = ref.get();
            }
            if (result == null) {
                result = new SingletonDataset(graph);
                cache.put(graph, new SoftReference<SingletonDataset>(result));
            }
            return result;
        }

    }

    private SingletonDataset(INamedGraph graph) {
        this.graph = graph;
    }

    public INamedGraph addDefaultGraph(URI uri) {
        throw new UnsupportedOperationException();
    }

    public INamedGraph addNamedGraph(URI uri) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        graph.clear();
    }

    public INamedGraph getDatasetGraph() {
        throw new UnsupportedOperationException();
    }

    public INamedGraph getDefaultGraph(URI uri) {
        if (uri.equals(graph.getNamedGraphUri())) {
            return graph;
        } else {
            return null;
        }
    }

    public void removeDefaultGraph(URI uri) {
        throw new UnsupportedOperationException();
    }

    public void removeNamedGraph(URI uri) {
        throw new UnsupportedOperationException();
    }

    public void setDefaultGraphs(Set<URI> defaultGraphUris) {
        throw new UnsupportedOperationException();
    }

    public void setNamedGraphs(Set<URI> namedGraphUris) {
        throw new UnsupportedOperationException();
    }

    public void close() {
        if (graphListener != null)
            graph.unregisterListener(graphListener);
    }

    public boolean containsDefaultGraph(URI uri) {
        return uri.equals(graph.getNamedGraphUri());
    }

    public boolean containsNamedGraph(URI uri) {
        return uri.equals(graph.getNamedGraphUri());
    }

    public QueryResults executeQuery(String query) throws AnzoException {
        throw new UnsupportedOperationException();
    }

    public Collection<Statement> find(boolean includeEntireDataset, Resource subj, URI prop, Value obj, URI... namedGraphUris) {
        boolean found = false;
        for (int i = 0; i < namedGraphUris.length; i++) {
            if (namedGraphUris[i].equals(graph.getNamedGraphUri())) {
                found = true;
                break;
            }
        }
        if (found) {
            return graph.find(subj, prop, obj);
        } else {
            return Collections.<Statement> emptySet();
        }
    }

    public Set<URI> getDefaultGraphUris() {
        return Collections.singleton(graph.getNamedGraphUri());
    }

    public Set<URI> getNamedGraphUris() {
        return Collections.singleton(graph.getNamedGraphUri());
    }

    public INamedGraph getNamedGraph(URI uri) {
        if (uri.equals(graph.getNamedGraphUri())) {
            return graph;
        } else {
            return null;
        }
    }

    public int size() {
        return graph.size();
    }

    public void registerListener(IStatementListener<IDataset> listener) {
        listeners.add(listener);
        if (graphListener == null) {
            graphListener = new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    notifyAddStatements(statements);
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                    notifyRemoveStatements(statements);
                }
            };
            graph.registerListener(graphListener);
        }
    }

    public void unregisterListener(IStatementListener<IDataset> listener) {
        listeners.remove(listener);
        if (listeners.size() == 0 && graphListener != null) {
            graph.unregisterListener(graphListener);
            graphListener = null;
        }
    }

    public void notifyAddStatements(Statement... statements) {
        if (getURI().toString().equals("http://openanzo.org/registries/Datasources")) {
            log.debug(LogUtils.GLITTER_MARKER, "Notifying singleton dataset..." + listeners);
        }
        for (IStatementListener<IDataset> listener : listeners) {
            listener.statementsAdded(this, statements);
        }
    }

    public void notifyRemoveStatements(Statement... statements) {
        for (IStatementListener<IDataset> listener : listeners) {
            listener.statementsRemoved(this, statements);
        }
    }

    public void add(Collection<Statement> statements) {
        for (Statement stmt : statements) {
            add(stmt);
        }
    }

    public void add(Resource subj, URI pred, Value obj, URI namedGraphUri) {
        if (namedGraphUri.equals(graph.getNamedGraphUri())) {
            graph.add(subj, pred, obj);
        }
    }

    public void add(Statement... statements) {
        for (Statement statement : statements) {
            add(statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getNamedGraphUri());
        }
    }

    public boolean contains(Resource subj, URI prop, Value obj, URI... namedGraphUris) {
        for (URI nguri : namedGraphUris) {
            if (nguri.equals(graph.getNamedGraphUri())) {
                return graph.contains(subj, prop, obj);
            }
        }
        return false;
    }

    public boolean contains(Statement statement) {
        if (statement.getNamedGraphUri().equals(graph.getNamedGraphUri())) {
            return graph.contains(statement);
        } else {
            return false;
        }
    }

    public QueryResults executeQuery(Set<URI> defaultGraph, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        throw new UnsupportedOperationException();
    }

    public Collection<Statement> find(Resource subj, URI prop, Value obj, URI... namedGraphUri) {
        return find(false, subj, prop, obj, namedGraphUri);
    }

    public Collection<Statement> getStatements() {
        return graph.getStatements();
    }

    public boolean isEmpty() {
        return graph.isEmpty();
    }

    public void remove(Collection<Statement> statements) {
        for (Statement stmt : statements) {
            remove(stmt);
        }
    }

    public void remove(Resource subj, URI pred, Value obj, URI... namedGraphUri) {
        if (namedGraphUri == null || namedGraphUri[0].equals(graph.getNamedGraphUri())) {
            graph.remove(subj, pred, obj);
        }
    }

    public void remove(Statement... statements) {
        for (Statement statement : statements) {
            remove(statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getNamedGraphUri());
        }
    }

    public int size(URI... namedGraphUris) {
        for (URI nguri : namedGraphUris) {
            if (nguri.equals(graph.getNamedGraphUri())) {
                return graph.size();
            }
        }
        return 0;
    }

    public URI getURI() {
        return graph.getNamedGraphUri();
    }

}
