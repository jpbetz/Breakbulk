/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/ADataset.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 20, 2006
 * Revision:	$Id: ADataset.java 168 2007-07-31 14:11:14Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import info.aduna.collections.iterators.Iterators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.exception.UnknownGraphException;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.rdf.query.QuadStoreEngineConfig;
import org.openanzo.rdf.vocabulary.Anzo;
import org.openanzo.rdf.vocabulary.RDF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract base implementation of IDataset.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public abstract class DatasetBase implements IDataset {

    private final static Logger                                     log              = LoggerFactory.getLogger(DatasetBase.class);

    private boolean                                                 closed           = false;

    protected URI                                                   datasetUri;

    private Engine                                                  glitter;

    /** Graph listeners */
    private final CopyOnWriteArraySet<IStatementListener<IDataset>> listeners        = new CopyOnWriteArraySet<IStatementListener<IDataset>>();

    protected IStatementListener<INamedGraph>                       graphListener;

    /** Set of defaultGraphs */
    protected final HashSet<URI>                                    defaultGraphUris = new HashSet<URI>();

    /** Set of namedGraphs */
    protected final HashSet<URI>                                    namedGraphUris   = new HashSet<URI>();

    /** The graph instances */
    //protected final CopyOnWriteMap<URI, INamedGraph>                graphs           = new org.openanzo.rdf.utils.Collections.CopyOnWriteMap<URI, INamedGraph>(new HashMap<URI, INamedGraph>(), org.openanzo.rdf.utils.Collections.Functions.<URI, INamedGraph> hash());
    protected final HashMap<URI, INamedGraph>                       graphs           = new HashMap<URI, INamedGraph>();

    protected INamedGraph                                           datasetGraph;

    /**
     * Create default dataset
     */
    public DatasetBase() {
        this(null);
    }

    /**
     * Create dataset with given URI
     * 
     * @param datasetUri
     *            uri of dataset
     */
    public DatasetBase(URI datasetUri) {
        this.datasetUri = datasetUri;
        initialize();
    }

    protected boolean addType() {
        return true;
    }

    protected final void initialize() {
        QuadStoreEngineConfig config = new QuadStoreEngineConfig(this);
        glitter = new Engine(config);

        if (datasetUri != null) {
            datasetGraph = createDatasetGraph();
            if (addType()) {
                datasetGraph.add(datasetUri, RDF.TYPE, Anzo.DATASET_TYPE);
                // unfortunately we cannot use the jastor generated dataset classes because
                // of the dependency cycles it would induce.  Luckily, its only  predicates.
            }
        }

        if (datasetGraph != null) {
            datasetGraph.registerListener(new Listener());

            Collection<Statement> stmts = datasetGraph.find(datasetUri, Anzo.NAMEDGRAPH, null);
            for (Statement stmt : stmts) {
                addNamedGraphInternal((URI) stmt.getObject());
            }

            stmts = datasetGraph.find(datasetUri, Anzo.DEFAULTGRAPH, null);
            for (Statement stmt : stmts) {
                addDefaultGraphInternal((URI) stmt.getObject());
            }

            stmts = datasetGraph.find(datasetUri, Anzo.DEFAULTNAMEDGRAPH, null);
            for (Statement stmt : stmts) {
                addDefaultGraphInternal((URI) stmt.getObject());
                addNamedGraphInternal((URI) stmt.getObject());
            }
        }

    }

    protected abstract ReentrantLock getLock();

    protected abstract INamedGraph createNamedGraph(URI namedGraphUri);

    protected abstract INamedGraph createDatasetGraph();

    private INamedGraph createGraph(URI namedGraphUri) {
        if (getLock() != null) {
            getLock().lock();
        }
        try {
            if (!graphs.containsKey(namedGraphUri)) {
                INamedGraph graph = createNamedGraph(namedGraphUri);
                synchronized (graphs) {
                    graphs.put(namedGraphUri, graph);
                }
                if (graphListener != null) {
                    graph.registerListener(graphListener);
                }
            }
            return graphs.get(namedGraphUri);
        } finally {
            if (getLock() != null) {
                getLock().unlock();
            }
        }
    }

    private void removeGraph(URI namedGraphUri) {
        if (getLock() != null) {
            getLock().lock();
        }
        try {
            INamedGraph graph = graphs.get(namedGraphUri);
            if (graph != null) {
                graph.close();
                synchronized (graphs) {
                    graphs.remove(namedGraphUri);
                }
            }
        } finally {
            if (getLock() != null) {
                getLock().unlock();
            }
        }
    }

    public INamedGraph getDatasetGraph() {
        return datasetGraph;
    }

    public INamedGraph getDefaultGraph(URI namedGraphUri) {
        if (!defaultGraphUris.contains(namedGraphUri)) {
            return null;
        }
        return graphs.get(namedGraphUri);
    }

    @SuppressWarnings("unchecked")
    public Set<URI> getDefaultGraphUris() {
        return Collections.unmodifiableSet((Set<URI>) defaultGraphUris.clone());
    }

    public INamedGraph addDefaultNamedGraph(URI namedGraphUri) {
        INamedGraph graph = addDefaultGraphInternal(namedGraphUri);
        addNamedGraphInternal(namedGraphUri);
        if (datasetGraph != null && !datasetGraph.contains(datasetUri, Anzo.DEFAULTNAMEDGRAPH, namedGraphUri)) {
            datasetGraph.add(datasetUri, Anzo.DEFAULTNAMEDGRAPH, namedGraphUri);
        }
        return graph;
    }

    public INamedGraph addDefaultGraph(URI namedGraphUri) {
        INamedGraph graph = addDefaultGraphInternal(namedGraphUri);
        if (datasetGraph != null && !datasetGraph.contains(datasetUri, Anzo.DEFAULTGRAPH, namedGraphUri)) {
            datasetGraph.add(datasetUri, Anzo.DEFAULTGRAPH, namedGraphUri);
        }
        return graph;
    }

    protected INamedGraph addDefaultGraphInternal(URI namedGraphUri) {
        if (defaultGraphUris.contains(namedGraphUri)) {
            return graphs.get(namedGraphUri);
        }
        if (namedGraphUri == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER);
        }
        INamedGraph graph = createGraph(namedGraphUri);
        defaultGraphUris.add(namedGraphUri);
        return graph;
    }

    /**
     * Set defaultGraphUris to provided set of graphs
     * 
     * @param namedGraphUris
     *            Set of default graphs to use
     */
    public void setDefaultGraphs(Set<URI> namedGraphUris) {
        for (URI uri : defaultGraphUris) {
            if (!this.namedGraphUris.contains(uri)) {
                removeGraph(uri);
            }
        }
        if (datasetGraph != null) {
            datasetGraph.remove(datasetUri, Anzo.DEFAULTGRAPH, null);
        }
        defaultGraphUris.clear();
        for (URI uri : namedGraphUris) {
            addDefaultGraph(uri);
        }
    }

    public void removeDefaultGraph(URI namedGraphUri) {
        removeDefaultGraphInternal(namedGraphUri);
        if (datasetGraph != null) {
            datasetGraph.remove(datasetUri, Anzo.DEFAULTGRAPH, namedGraphUri);
        }
    }

    private void removeDefaultGraphInternal(URI namedGraphUri) {
        if (namedGraphUri == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER);
        }
        defaultGraphUris.remove(namedGraphUri);
        if (!namedGraphUris.contains(namedGraphUri)) {
            removeGraph(namedGraphUri);
        }
    }

    public boolean containsDefaultGraph(URI uri) {
        return defaultGraphUris.contains(uri);
    }

    public INamedGraph getNamedGraph(URI namedGraphUri) {
        if (!namedGraphUris.contains(namedGraphUri)) {
            return null;
        }
        return graphs.get(namedGraphUri);
    }

    @SuppressWarnings("unchecked")
    public Set<URI> getNamedGraphUris() {
        return Collections.unmodifiableSet((Set<URI>) namedGraphUris.clone());
    }

    public INamedGraph addNamedGraph(URI namedGraphUri) {
        INamedGraph graph = addNamedGraphInternal(namedGraphUri);
        if (datasetGraph != null && !datasetGraph.contains(datasetUri, Anzo.NAMEDGRAPH, namedGraphUri)) {
            datasetGraph.add(datasetUri, Anzo.NAMEDGRAPH, namedGraphUri);
        }
        return graph;
    }

    protected INamedGraph addNamedGraphInternal(URI namedGraphUri) {
        if (namedGraphUris.contains(namedGraphUri)) {
            return graphs.get(namedGraphUri);
        }
        if (namedGraphUri == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER);
        }
        INamedGraph graph = createGraph(namedGraphUri);
        namedGraphUris.add(namedGraphUri);
        return graph;
    }

    public void setNamedGraphs(Set<URI> namedGraphUris) {
        for (URI uri : namedGraphUris) {
            if (!defaultGraphUris.contains(uri)) {
                removeGraph(uri);
            }
        }
        if (datasetGraph != null) {
            datasetGraph.remove(datasetUri, Anzo.NAMEDGRAPH, null);
        }
        this.namedGraphUris.clear();
        for (URI uri : namedGraphUris) {
            addNamedGraph(uri);
        }
    }

    public void removeNamedGraph(URI namedGraphUri) {
        removeNamedGraphInternal(namedGraphUri);
        if (datasetGraph != null) {
            datasetGraph.remove(datasetUri, Anzo.NAMEDGRAPH, namedGraphUri);
        }
    }

    private void removeNamedGraphInternal(URI namedGraphUri) {
        if (namedGraphUri == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER);
        }
        namedGraphUris.remove(namedGraphUri);
        if (!defaultGraphUris.contains(namedGraphUri)) {
            removeGraph(namedGraphUri);
        }
    }

    public boolean containsNamedGraph(URI uri) {
        return namedGraphUris.contains(uri);
    }

    /**
     * Add a statement to the given NamedGraph if said NamedGraph is contained within this dataset. No exception is thrown if NamedGraph is not contained within
     * dataset, statement is simple ignored.
     * 
     * @param subj
     *            Subject of statement
     * @param pred
     *            Property of statement
     * @param obj
     *            Object of statement
     * @param namedGraphUri
     *            URI of NamedGraph to which statement is to be added
     * @throws AnzoRuntimeException
     *             if any of the 4 arguments is null
     */
    public void add(Resource subj, URI pred, Value obj, URI namedGraphUri) {
        if (namedGraphUri == null || subj == null || pred == null || obj == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, (namedGraphUri != null) ? namedGraphUri.toString() : null, (subj != null) ? subj.toString() : null, (pred != null) ? pred.toString() : null, (obj != null) ? obj.toString() : null);
        }
        INamedGraph graph = getNamedGraph(namedGraphUri);
        if (graph != null) {
            graph.add(subj, pred, obj);
        } else {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER, "Named graph in statement not in dataset");
        }
    }

    /**
     * Add statements to the given NamedGraph if said NamedGraph is contained within this dataset. No exception is thrown if NamedGraph is not contained within
     * dataset, statement is simple ignored.
     * 
     * @param statements
     *            to add
     * @throws AnzoRuntimeException
     *             if any of the 4 arguments is null
     */
    public void add(Statement... statements) {
        for (Statement statement : statements) {
            if (statement.getNamedGraphUri() == null || statement.getSubject() == null || statement.getPredicate() == null || statement.getObject() == null) {
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, (statement.getNamedGraphUri() != null) ? statement.getNamedGraphUri().toString() : null, (statement.getSubject() != null) ? statement.getSubject().toString() : null, (statement.getPredicate() != null) ? statement.getPredicate().toString() : null, (statement.getObject() != null) ? statement.getObject().toString() : null);
            }
            INamedGraph graph = getNamedGraph(statement.getNamedGraphUri());
            if (graph != null) {
                graph.add(statement.getSubject(), statement.getPredicate(), statement.getObject());
            } else {
                throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER, "Named graph in statement not in dataset");
            }
        }
    }

    /**
     * Add statements to their given NamedGraph. Context of each statement is used to determine which NamedGraph statement is to be added.
     * 
     * @param statements
     *            Iterator of statement to add
     */
    public void add(Collection<Statement> statements) {
        add(statements.toArray(new Statement[0]));
    }

    /**
     * Add statements to dataset, adding graphs to namedgraphs as needed
     * 
     * @param statements
     *            statements to add
     */
    public final void addWithGraphs(Collection<Statement> statements) {
        Set<URI> graphUris = new HashSet<URI>();
        for (Statement stmt : statements) {
            graphUris.add(stmt.getNamedGraphUri());
        }
        for (URI ngUri : graphUris) {
            addNamedGraph(ngUri);
        }
        add(statements.toArray(new Statement[0]));
    }

    /**
     * Delete statements from their given NamedGraph. Context of each statement is used to determine which NamedGraph statement is to be removed.
     * 
     * @param statements
     *            Iterator of statement to delete
     */
    public void remove(Collection<Statement> statements) {
        remove(statements.toArray(new Statement[0]));
    }

    /**
     * Delete statements from the given NamedGraph if said NamedGraph is contained within this dataset. No exception is thrown if NamedGraph is not contained
     * within dataset, statement is simple ignored.
     * 
     * @param subj
     *            Subject of statement
     * @param pred
     *            Property of statement
     * @param obj
     *            Object of statement
     * @param namedGraphUri
     *            URI of NamedGraph to which statement is to be deleted
     * @throws AnzoRuntimeException
     *             if any of the 4 arguments is null
     */
    public void remove(Resource subj, URI pred, Value obj, URI... namedGraphUri) {
        if ((namedGraphUri == null || namedGraphUri.length > 1) || subj == null || pred == null || obj == null) {
            remove(find(subj, pred, obj, namedGraphUri));
        } else {
            INamedGraph graph = getNamedGraph(namedGraphUri[0]);
            if (graph != null) {
                graph.remove(subj, pred, obj);
            } else {
                throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER, "Named graph in statement not in dataset");
            }
        }
    }

    /**
     * Delete statements from the given NamedGraph if said NamedGraph is contained within this dataset. No exception is thrown if NamedGraph is not contained
     * within dataset, statement is simple ignored.
     * 
     * @param statements
     *            statements to remove
     * @throws AnzoRuntimeException
     *             if any of the 4 arguments is null
     */
    public void remove(Statement... statements) {
        for (Statement statement : statements) {
            if (statement.getNamedGraphUri() == null || statement.getSubject() == null || statement.getPredicate() == null || statement.getObject() == null) {
                throw new AnzoRuntimeException(ExceptionConstants.CLIENT.NO_NULL_VALUES, (statement.getNamedGraphUri() != null) ? statement.getNamedGraphUri().toString() : null, (statement.getSubject() != null) ? statement.getSubject().toString() : null, (statement.getPredicate() != null) ? statement.getPredicate().toString() : null, (statement.getObject() != null) ? statement.getObject().toString() : null);
            }
            INamedGraph graph = getNamedGraph(statement.getNamedGraphUri());
            if (graph != null) {
                graph.remove(statement.getSubject(), statement.getPredicate(), statement.getObject());
            } else {
                throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER, "Named graph in statement not in dataset");
            }
        }
    }

    public void clear() {
        synchronized (graphs) {
            for (URI uri : graphs.keySet()) {
                INamedGraph graph = graphs.get(uri);
                graph.clear();
                graph.close();
            }
            graphs.clear();
        }
        this.defaultGraphUris.clear();
        this.namedGraphUris.clear();
        if (datasetGraph != null) {
            datasetGraph.remove(datasetUri, Anzo.DEFAULTGRAPH, null);
            datasetGraph.remove(datasetUri, Anzo.NAMEDGRAPH, null);
            datasetGraph.remove(datasetUri, Anzo.DEFAULTNAMEDGRAPH, null);
        }
    }

    public boolean contains(Resource subj, URI prop, Value obj, URI... namedGraphUris) {
        Collection<Statement> stmts = find(subj, prop, obj, namedGraphUris);
        return !stmts.isEmpty();
    }

    public boolean contains(Statement statement) {
        return contains(statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getNamedGraphUri());
    }

    protected INamedGraph getGraph(URI namedGraphUri) {
        return graphs.get(namedGraphUri);
    }

    @SuppressWarnings("unchecked")
    protected Map<URI, INamedGraph> getGraphs() {
        synchronized (graphs) {
            return Collections.unmodifiableMap((HashMap<URI, INamedGraph>) graphs.clone());
        }
    }

    public Collection<Statement> find(Resource subj, URI prop, Value obj, URI... namedGraphUris) {
        if (namedGraphUris != null && namedGraphUris.length > 0 && (!(namedGraphUris.length == 1 && namedGraphUris[0] == null))) {
            if (namedGraphUris.length == 1) {
                INamedGraph graph = getGraph(namedGraphUris[0]);
                if (graph != null) {
                    return graph.find(subj, prop, obj);
                }
                return Collections.<Statement> emptySet();
            } else {
                ArrayList<Statement> stmts = new ArrayList<Statement>();
                for (URI uri : namedGraphUris) {
                    INamedGraph graph = getGraph(uri);
                    if (graph != null) {
                        Iterators.addAll(graph.find(subj, prop, obj).iterator(), stmts);
                    }
                }
                return stmts;
            }
        } else {
            Map<URI, INamedGraph> graphs = getGraphs();
            if (graphs.size() > 0) {
                Set<URI> uris = null;
                URI[] u = null;
                uris = graphs.keySet();
                u = new URI[uris.size()];
                u = uris.toArray(u);
                return find(subj, prop, obj, u);
            } else {
                return Collections.<Statement> emptySet();
            }
        }
    }

    public Collection<Statement> find(boolean includeEntireDataset, Resource subj, URI prop, Value obj, URI... namedGraphUris) {
        if (includeEntireDataset) {
            Map<URI, INamedGraph> graphs = getGraphs();
            Set<URI> uris = null;
            if (namedGraphUris != null && namedGraphUris.length > 0) {
                uris = new LinkedHashSet<URI>();
                for (Resource uri : namedGraphUris) {
                    if (uri != null) {
                        if (graphs.containsKey(uri)) {
                            uris.add((URI) uri);
                        }
                    }
                }
                synchronized (graphs) {
                    for (URI uri : graphs.keySet()) {
                        uris.add(uri);
                    }
                }
            } else {
                uris = this.getNamedGraphUris();
            }
            return find(subj, prop, obj, uris.toArray(new URI[0]));
        } else {
            return find(subj, prop, obj, namedGraphUris);
        }
    }

    public Collection<Statement> getStatements() {
        return find(null, null, null, (URI[]) null);
    }

    /**
     * Is the dataset closed
     * 
     * @return if the dataset is closed
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * Get the URI for the dataset
     * 
     * @return the dataset's URI
     */
    public URI getURI() {
        return datasetUri;
    }

    public void close() {
        this.closed = true;
        synchronized (graphs) {
            for (URI uri : graphs.keySet()) {
                INamedGraph graph = graphs.get(uri);
                graph.close();
            }
        }
        if (datasetGraph != null) {
            datasetGraph.close();
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(getGraphs().keySet().toArray(new URI[0]));
    }

    public int size(URI... context) {
        int size = 0;
        for (Resource uri : context) {
            if (uri != null) {
                INamedGraph graph = getGraph((URI) uri);
                if (graph != null) {
                    size += graph.size();
                }
            }
        }
        return size;
    }

    public QueryResults executeQuery(String query) throws AnzoException {
        return query(getDefaultGraphUris(), getNamedGraphUris(), new HashSet<URI>(), query, null);
    }

    public QueryResults executeQuery(Set<URI> defaultGraph, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        return query(defaultGraph, namedGraphs, namedDatasets, query, baseUri);
    }

    private QueryResults query(Set<URI> defaultGraph, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        try {
            if (namedDatasets != null) {
                for (URI uri : namedDatasets) {
                    INamedGraph graph = getGraph(uri);
                    if (graph != null) {
                        for (Statement s : graph.find(uri, Anzo.DEFAULTGRAPH, null)) {
                            INamedGraph dg = s.getObject() instanceof URI ? getDefaultGraph((URI) s.getObject()) : null;
                            if (dg != null)
                                defaultGraph.add((URI) s.getObject());
                        }
                        for (Statement s : graph.find(uri, Anzo.NAMEDGRAPH, null)) {
                            INamedGraph ng = s.getObject() instanceof URI ? getNamedGraph((URI) s.getObject()) : null;
                            if (ng != null)
                                namedGraphs.add((URI) s.getObject());
                        }
                    }
                }
            }
            if (defaultGraph != null) {
                if (!getDefaultGraphUris().containsAll(defaultGraph))
                    throw new UnknownGraphException();
            }

            if (namedGraphs != null) {
                if (!getNamedGraphUris().containsAll(namedGraphs))
                    throw new UnknownGraphException();
            }

            return glitter.executeQuery(null, query, new DefaultQueryDataset(defaultGraph, namedGraphs), baseUri);
        } catch (ParseException e) {
            log.error(LogUtils.GLITTER_MARKER, "Error parsing query:" + query, e);
            throw new AnzoException(ExceptionConstants.CLIENT.ERROR_PARSING_QUERY, e, query);
        }
    }

    public void registerListener(IStatementListener<IDataset> listener) {
        listeners.add(listener);
        if (graphListener == null) {
            this.graphListener = new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    notifyAddStatements(statements);
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                    notifyRemoveStatements(statements);
                }
            };
            for (Map.Entry<URI, INamedGraph> entry : getGraphs().entrySet()) {
                entry.getValue().registerListener(graphListener);
            }
        }
    }

    public void unregisterListener(IStatementListener<IDataset> listener) {
        listeners.remove(listener);
        if (listeners.size() == 0) {
            for (Map.Entry<URI, INamedGraph> entry : getGraphs().entrySet()) {
                entry.getValue().unregisterListener(graphListener);
            }
            graphListener = null;
        }
    }

    public void notifyAddStatements(Statement... statements) {
        for (IStatementListener<IDataset> listener : listeners) {
            listener.statementsAdded(this, statements);
        }
    }

    public void notifyRemoveStatements(Statement... statements) {
        for (IStatementListener<IDataset> listener : listeners) {
            listener.statementsRemoved(this, statements);
        }
    }

    class Listener implements IStatementListener<INamedGraph> {
        public void statementsAdded(INamedGraph source, Statement... statements) {
            for (int i = 0; i < statements.length; i++) {
                if (!statements[i].getSubject().equals(DatasetBase.this.datasetUri)) {
                    continue;
                }
                if (statements[i].getPredicate().equals(Anzo.NAMEDGRAPH)) {
                    addNamedGraphInternal((URI) statements[i].getObject());
                } else if (statements[i].getPredicate().equals(Anzo.DEFAULTGRAPH)) {
                    addDefaultGraphInternal((URI) statements[i].getObject());
                } else if (statements[i].getPredicate().equals(Anzo.DEFAULTNAMEDGRAPH)) {
                    addDefaultGraphInternal((URI) statements[i].getObject());
                    addNamedGraphInternal((URI) statements[i].getObject());
                }
            }
        }

        public void statementsRemoved(INamedGraph source, Statement... statements) {
            for (int i = 0; i < statements.length; i++) {
                if (!statements[i].getSubject().equals(DatasetBase.this.datasetUri)) {
                    continue;
                }
                if (statements[i].getPredicate().equals(Anzo.NAMEDGRAPH)) {
                    removeNamedGraphInternal((URI) statements[i].getObject());
                } else if (statements[i].getPredicate().equals(Anzo.DEFAULTGRAPH)) {
                    removeDefaultGraphInternal((URI) statements[i].getObject());
                } else if (statements[i].getPredicate().equals(Anzo.DEFAULTNAMEDGRAPH)) {
                    removeNamedGraphInternal((URI) statements[i].getObject());
                    removeDefaultGraphInternal((URI) statements[i].getObject());
                }
            }
        }
    }
}
