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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.rdf.BaseQuadStore;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.query.CoreEngineConfig;
import org.openanzo.rdf.query.QuadStoreEngineConfig;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.Anzo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TransactionProxy itself is fairly simple. The add method takes in either a Statement, list of Statement or s,p,o,c quad definition. First it checks if a
 * transaction has already begun. If not, it wraps the entire add operation in a new transaction. It then asks the TransactionQueue to which it is bound for the
 * current Transaction (possibly just created) and in turn invokes Transaction.addStatmentAddition. The find method first asks the wrapped IQuadStore to perform
 * the same find, and then filters the results using the TransactionQueue.
 * 
 * @author Joe Betz
 * 
 */
class TransactionProxy extends BaseQuadStore {
    private static final Logger log = LoggerFactory.getLogger(TransactionProxy.class);

    private final IQuadStore    quadStore;

    final TransactionQueue      transactionQueue;

    private final Engine        glitter;

    private AnzoClient          anzoClient;

    /**
     * Initialization
     * 
     * @param quadStore
     *            The store to which this store will proxy requests.
     * @param transactionQueue
     *            The queue that holds transactions for this graph.
     */
    TransactionProxy(IQuadStore quadStore, TransactionQueue transactionQueue, AnzoClient anzoClient) {
        this.quadStore = quadStore;
        this.transactionQueue = transactionQueue;

        CoreEngineConfig config = new QuadStoreEngineConfig(this);
        glitter = new Engine(config);
        this.anzoClient = anzoClient;
    }

    /**
     * Traps the additions in a transaction.
     * 
     * @param statements
     */
    public void add(Statement... statements) {

        boolean inTransaction = this.transactionQueue.inTransaction();
        if (!inTransaction) {
            this.transactionQueue.begin();
        }
        this.transactionQueue.add(statements);
        if (!inTransaction) {
            this.transactionQueue.commit();
        }
    }

    /**
     * Traps the removes in a transaction.
     * 
     * @param statements
     */
    public void remove(Statement... statements) {
        boolean inTransaction = this.transactionQueue.inTransaction();
        if (!inTransaction) {
            this.transactionQueue.begin();
        }
        this.transactionQueue.remove(statements);
        if (!inTransaction) {
            this.transactionQueue.commit();
        }
    }

    /**
     * Performs a find on the given pattern. Find is first called on the proxied store, then the statements are filtered out by the changes in the transaction
     * queue.
     * 
     * @param subject
     *            Subject value to match, or wildcard if null
     * @param predicate
     *            Predicate value to match, or wildcard if null
     * @param object
     *            Object value to match, or wildcard if null
     * @param namedGraphUris
     *            uri used to match the named graph parameter of statements, or wildcard if null
     * @return An array of matching statements.
     */
    public Collection<Statement> find(Resource subject, URI predicate, Value object, URI... namedGraphUris) {
        Collection<Statement> statements = new ArrayList<Statement>(this.quadStore.find(subject, predicate, object, namedGraphUris));
        this.transactionQueue.filter(statements, subject, predicate, object, namedGraphUris);
        return statements;
    }

    /**
     * Removes all statements in this store.
     */
    public void clear() {
        remove(find(null, null, null, (URI[]) null));
    }

    /**
     * Return if container is empty
     * 
     * @return true if container is empty
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Checks if a named graph is empty.
     * 
     * @param namedGraphUri
     *            The uri of the named graph to test.
     * @return Returns true if the number of statements in the store for the given namedGraphUris is zero, false otherwise. If namedGraphUris is empty, returns
     *         true if the the total number of statements in this store is zero, false otherwise.
     */
    public boolean isEmpty(URI namedGraphUri) {
        return this.size(namedGraphUri) == 0;
    }

    /**
     * Return number of statements in container
     * 
     * @return number of statements in container
     */
    public int size() {
        return find(null, null, null, (URI[]) null).size();
    }

    /**
     * Abstract method that must be implemented by subclasses.
     * 
     * Returns the number of statements in the store for given namedGraphUris. If the given named graph uris are not specified, it returns the total number of
     * statements in the store.
     * 
     * @param namedGraphUris
     *            uri used to determine the total sizes of specified graphs.
     * @return The number of statements in the store for the given namedGraphUris. If namedGraphUris is null, returns the total number of statements in this
     *         store.
     */
    public int size(URI... namedGraphUris) {
        return find(null, null, null, namedGraphUris).size();
    }

    /**
     * Return the set of namedGraphUris contained within this store. The only way to correctly get all namedGraphUris, is to enumerate all the statement
     * (filtered of course), and build up a set of namedGraphUris. This is because the baseContainer could contain a single statement from a named graph and the
     * transaction queue could contain a deletion for that statement. perhaps we should disallow this method.
     * 
     * @return An array of named graph uris contained in this store.
     */
    public Collection<URI> getNamedGraphUris() {
        Collection<Statement> stmts = getStatements();
        Set<URI> namedGraphUris = new HashSet<URI>();
        for (Statement stmt : stmts) {
            namedGraphUris.add(stmt.getNamedGraphUri());
        }
        return namedGraphUris;
    }

    /**
     * Return true if the container contains atleast 1 statement that matches the pattern of subj,prop,obj,namedGraphUri
     * 
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphUris
     *            named graph values to match, or wildcard if null
     * @return true if the container contains atleast 1 statement that matches the pattern of subj,prop,obj
     */
    public boolean contains(Resource subj, URI prop, Value obj, URI... namedGraphUris) {
        return this.find(subj, prop, obj, namedGraphUris).size() > 0;
    }

    /**
     * Return true if the container contains atleast 1 statement that matches the statement provided
     * 
     * @param statement
     *            Statement to check for existence in container
     * @return true if the container contains atleast 1 statement that matches the statement provided
     */
    public boolean contains(Statement statement) {
        URI[] resources;
        if (statement.getNamedGraphUri() != null) {
            resources = new URI[] { statement.getNamedGraphUri() };
        } else {
            resources = new URI[] {};
        }

        return contains(statement.getSubject(), statement.getPredicate(), statement.getObject(), resources);
    }

    /**
     * Execute a SPARQL query against the data within this container
     * 
     * @param defaultNamedGraphs
     *            Set&lt;URI&gt; of URIs for NamedGraphs that will make up the default graph for this query
     * @param namedGraphs
     *            Set&lt;URI&gt; of URIs for NamedGraphs that will make up the NamedGraphs for this query
     * @param namedDatasets
     *            Set of URIs for named datasets that will contribute to the query's RDF dataset
     * @param query
     *            SPARQL query string
     * @param baseUri
     *            Base URI against which relative URI references in the SPARQL query are resolved
     * @return Results of running query
     * @throws AnzoException
     */
    public QueryResults executeQuery(Set<URI> defaultNamedGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        try {
            HashSet<URI> defaultNgs = new HashSet<URI>();
            HashSet<URI> ngs = new HashSet<URI>();
            if (namedDatasets != null) {
                for (URI uri : namedDatasets) {
                    for (Statement s : find(uri, Anzo.DEFAULTNAMEDGRAPH, null, uri)) {
                        defaultNgs.add((URI) s.getObject());
                        ngs.add((URI) s.getObject());
                    }
                    for (Statement s : find(uri, Anzo.DEFAULTGRAPH, null, uri)) {
                        defaultNgs.add((URI) s.getObject());
                    }
                    for (Statement s : find(uri, Anzo.NAMEDGRAPH, null, uri)) {
                        ngs.add((URI) s.getObject());
                    }
                }
            }

            if (defaultNamedGraphs != null) {
                for (URI ng : defaultNamedGraphs) {
                    defaultNgs.add(ng);
                }
            }

            if (namedGraphs != null) {
                for (URI ng : namedGraphs) {
                    ngs.add(ng);
                }
            }

            UriGenerator.handleSpecialGraphUris(defaultNgs, this);
            UriGenerator.handleSpecialGraphUris(ngs, this);

            Set<URI> toRemove = new HashSet<URI>();
            for (URI ng : defaultNgs) {
                if (anzoClient.runAsUser.get() != null && !anzoClient.canReadNamedGraph(ng)) {
                    toRemove.add(ng);
                }
            }
            defaultNgs.removeAll(toRemove);
            toRemove.clear();
            for (URI ng : ngs) {
                if (anzoClient.runAsUser.get() != null && !anzoClient.canReadNamedGraph(ng)) {
                    toRemove.add(ng);
                }
            }
            ngs.removeAll(toRemove);
            DefaultQueryDataset queryDataset = new DefaultQueryDataset(defaultNgs, ngs);
            return glitter.executeQuery(null, query, queryDataset, baseUri);
        } catch (ParseException e) {
            log.error(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.GLITTER.PARSE_EXCEPTION, query, ""), e);
            throw new AnzoException(ExceptionConstants.CLIENT.ERROR_PARSING_QUERY, e, query);
        }
    }

    /**
     * Get an iterator over all statements within this container
     * 
     * @return CloseableIterator of all statements within this container
     */
    public Collection<Statement> getStatements() {
        return find(null, null, null, (URI[]) null);
    }
}
