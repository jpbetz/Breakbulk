/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 1, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IModelService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.rdf.AnzoGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.IRDFHandler;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.StatementCollector;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.OPTIONS;
import org.openanzo.rdf.utils.Collections;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.Privilege;
import org.openanzo.services.serialization.IValueSetHandler;
import org.openanzo.services.serialization.WriterStringValueSetHandler;
import org.openanzo.services.serialization.handlers.URIStringValueSetHandler;
import org.openanzo.services.serialization.transport.QueryUriSetSerializer;

/**
 * Base implementation of IModelService service
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseModelService extends BaseDatasourceComponent implements IModelService {
    /** Log for this Service */
    //private static final Logger   log                  = LoggerFactory.getLogger(BaseModelService.class);
    private final ModelServiceWithCacheStats stats = new ModelServiceWithCacheStats("containsNamedGraph", "findStatements", "getNamedGraphRevision", "getSize", "getStoredNamedGraphs", "getUriForUUID", "getUUIDforUri", "resolveNamedDataset");

    protected ModelServiceCache              cache;

    /**
     * Initialize the model cache
     * 
     * @param cacheProvider
     *            cache provider to use
     */
    protected void initializeCache(ICacheProvider cacheProvider) {
        if (cacheProvider != null) {
            this.cache = new ModelServiceCache(getDatasource().getName() + "/ModelService", cacheProvider);
        }
    }

    /**
     * @return the cache
     */
    public ModelServiceCache getCache() {
        return cache;
    }

    /**
     * Get the cacheUpdateListener for this service
     * 
     * @return the cacheUpdateListener for this service
     */
    public IUpdateResultListener getCacheUpdateListener() {
        return cache;
    }

    public String getName() {
        return getDatasource().getName() + ",Service=ModelService";
    }

    public String getDescription() {
        return "Model Service for " + getDatasource().getName();
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    public void reset() throws AnzoException {
        stats.reset();
        if (cache != null) {
            cache.reset();
        }
    }

    public void start() throws AnzoException {
        stats.setEnabled(true);
    }

    protected boolean canRead(IOperationContext context, URI namedGraphUri) throws AnzoException {
        try {
            return namedGraphUri != null && (context.getOperationPrincipal().isSysadmin() || namedGraphUri.equals(Constants.GRAPHS.GRAPHS_DATASET) || namedGraphUri.equals(Constants.GRAPHS.METADATA_GRAPHS_DATASET) || Collections.memberOf(getDatasource().getAuthorizationService().getRolesForGraph(context, namedGraphUri, Privilege.READ), context.getOperationPrincipal().getRoles()));
        } catch (AnzoException ae) {
            if (ae.getErrorCode() == ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND) {
                return false;
            } else {
                throw ae;
            }
        }
    }

    /**
     * Return the number of triples in graph
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            {@link URI} of named graph
     * @return Number of statements in named graph
     * @throws AnzoException
     */
    public long getSize(IOperationContext context, URI namedGraphUri) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            Long size = (cache != null) ? cache.getSize(namedGraphUri) : null;
            if (size == null) {
                stats.getGetSizeMiss().increment();
                size = getSizeInternal(context, namedGraphUri);
                if (cache != null)
                    cache.cacheSize(namedGraphUri, size);
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                }
            } else {
                stats.getGetSizeHit().increment();

                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                }
            }
            if (!canRead(context, namedGraphUri)) {
                return 0;
            } else {
                return size;
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("getSize", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    /**
     * Write the number of triples in graph to a an output writer
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            {@link URI} of named graph
     * @param output
     *            {@link Writer} onto which output is written
     * @throws AnzoException
     */
    public void getSize(IOperationContext context, URI namedGraphUri, Writer output) throws AnzoException {
        long size = getSize(context, namedGraphUri);
        org.openanzo.rdf.utils.SerializationUtils.writeValue(size, output, null);
    }

    public URI getUriForUUID(IOperationContext context, URI namedGraphUUID) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            URI uri = (cache != null) ? cache.getUriForUUID(namedGraphUUID) : null;
            if (uri == null) {
                stats.getGetUriForUUIDMiss().increment();
                uri = getUriForUUIDInternal(context, namedGraphUUID);
                if (cache != null)
                    cache.cacheUriForUUID(namedGraphUUID, uri);
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                }
            } else {
                stats.getGetUriForUUIDHit().increment();
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                }
            }
            if (!canRead(context, uri)) {
                return null;
            } else {
                return uri;
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("getUriForUUID", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    public void getUriForUUID(IOperationContext context, URI namedGraphUUID, Writer output) throws AnzoException {
        URI uri = getUriForUUID(context, namedGraphUUID);
        org.openanzo.rdf.utils.SerializationUtils.writeValue(uri, output, null);
    }

    public URI getUUIDforUri(IOperationContext context, URI namedGraphURI) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            URI uri = (cache != null) ? cache.getUUIDforURI(namedGraphURI) : null;
            if (uri == null) {
                stats.getGetUriForUUIDMiss().increment();
                uri = getUUIDforUriInternal(context, namedGraphURI);
                if (cache != null)
                    cache.cacheUUIDforURI(namedGraphURI, uri);
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                }
            } else {
                stats.getGetUriForUUIDHit().increment();

                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                }
            }
            if (!canRead(context, namedGraphURI)) {
                return null;
            } else {
                return uri;
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    public void getUUIDforUri(IOperationContext context, URI namedGraphURI, Writer output) throws AnzoException {
        URI uri = getUUIDforUri(context, namedGraphURI);
        org.openanzo.rdf.utils.SerializationUtils.writeValue(uri, output, null);
    }

    /**
     * Get the set of NamedGraphs stored on the server that the user has permission to see
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param valueSetHandler
     *            {@link IValueSetHandler} call-back handler that handles the values found
     * 
     * @throws AnzoException
     */
    private void getStoredNamedGraphs(IOperationContext context, IValueSetHandler<String> valueSetHandler) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            getStoredNamedGraphsInternal(context, valueSetHandler);
        } finally {
            if (stats.isEnabled()) {
                stats.use("getStoredNamedGraphs", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    /**
     * Get the set of NamedGraphs stored on the server that the user has permission to see
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @return the set of {@link URI}s for named graphs stored on the server that the user has permission to see
     * @throws AnzoException
     */
    public Set<URI> getStoredNamedGraphs(IOperationContext context) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            URIStringValueSetHandler handler = new URIStringValueSetHandler();
            getStoredNamedGraphsInternal(context, handler);
            return handler.getURIs();
        } finally {
            if (stats.isEnabled()) {
                stats.use("getStoredNamedGraphs", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    /**
     * Get the set of NamedGraphs stored on the server that the user has permission to see
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param output
     *            {@link Writer} to use to set write output
     * @param format
     *            format of data to write
     * @throws AnzoException
     */
    public void getStoredNamedGraphs(IOperationContext context, Writer output, String format) throws AnzoException {
        getStoredNamedGraphs(context, new WriterStringValueSetHandler(output, format));
    }

    HashSet<URI>  resolvingUris = new HashSet<URI>();

    ReentrantLock resolvingLock = new ReentrantLock();

    Condition     resolved      = resolvingLock.newCondition();

    public QueryDataset resolveNamedDataset(IOperationContext context, URI namedDatasetUri) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        try {
            QueryDataset uriSet = null;
            if (!canRead(context, namedDatasetUri)) {
                return new DefaultQueryDataset();
            }
            resolvingLock.lock();
            try {
                if (resolvingUris.contains(namedDatasetUri)) {
                    try {
                        resolved.await();
                    } catch (InterruptedException ie) {
                        throw new AnzoException(ExceptionConstants.CORE.INTERRUPTED, ie);
                    }
                }
                resolvingUris.add(namedDatasetUri);
            } finally {
                resolvingLock.unlock();
            }
            try {
                Boolean skipCache = context.getAttribute(OPTIONS.SKIPCACHE, Boolean.class);
                uriSet = ((skipCache == null || !skipCache) && (cache != null)) ? cache.getNamedDataset(namedDatasetUri) : null;
                if (uriSet == null) {
                    stats.getResolveNamedDatasetMiss().increment();
                    uriSet = resolveNamedDatasetInternal(context, namedDatasetUri);
                    if ((skipCache == null || !skipCache) && cache != null)
                        cache.cacheNamedDataset(namedDatasetUri, uriSet);
                    if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                        RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_DATASET_CACHE_HIT, Boolean.FALSE);
                    }
                } else {
                    stats.getResolveNamedDatasetHit().increment();
                    if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                        RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_DATASET_CACHE_HIT, Boolean.TRUE);
                    }
                }
                if (stats.isEnabled()) {
                    stats.use("resolveNamedDataset", (System.currentTimeMillis() - start));
                }
            } finally {
                resolvingLock.lock();
                try {
                    if (resolvingUris.remove(namedDatasetUri)) {
                        resolved.signalAll();
                    }
                } finally {
                    resolvingLock.unlock();
                }
            }
            if (uriSet == null || !canRead(context, namedDatasetUri)) {
                return new DefaultQueryDataset();
            }
            return uriSet;
        } finally {
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
        }
    }

    public void resolveNamedDataset(IOperationContext context, URI namedDatasetUri, Writer output, String resultFormat) throws AnzoException {
        QueryDataset result = resolveNamedDataset(context, namedDatasetUri);
        String resultString = QueryUriSetSerializer.serialize(result, resultFormat);
        try {
            output.write(resultString);
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
        }
    }

    protected QueryDataset resolveNamedDatasetInternal(IOperationContext context, URI namedDatasetURI) throws AnzoException {
        long start = -1;
        if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
            start = System.currentTimeMillis();
        }
        DefaultQueryDataset uriSet = new DefaultQueryDataset(new TreeSet<URI>(), new TreeSet<URI>(), new TreeSet<URI>());
        IAnzoGraph graph = getNamedGraphRevision(context, namedDatasetURI, -1);
        if (graph == null) {
            return uriSet;
        }
        Dataset dataset = AnzoFactory.getDataset(namedDatasetURI, graph);
        boolean includeMetadataGraphs = false;

        if (dataset.getIncludeMetadataGraphs() != null) {
            includeMetadataGraphs = (!namedDatasetURI.equals(Constants.GRAPHS.GRAPHS_DATASET) && !namedDatasetURI.equals(Constants.GRAPHS.METADATA_GRAPHS_DATASET));
            if (includeMetadataGraphs && dataset.getIncludeMetadataGraphs() != null) {
                includeMetadataGraphs = dataset.getIncludeMetadataGraphs();
            }
        }
        for (Statement stmt : graph.find(namedDatasetURI, Dataset.defaultGraphProperty, null)) {
            if (stmt.getObject() instanceof URI) {
                URI uri = (URI) stmt.getObject();
                uriSet.defaultGraphs.add(uri);
                if (includeMetadataGraphs && !UriGenerator.isMetadataGraphUri(uri)) {
                    uriSet.defaultGraphs.add(UriGenerator.generateMetadataGraphUri(uri));
                }
            }
        }
        for (Statement stmt : graph.find(namedDatasetURI, Dataset.namedGraphProperty, null)) {
            if (stmt.getObject() instanceof URI) {
                URI uri = (URI) stmt.getObject();
                uriSet.namedGraphs.add(uri);
                if (includeMetadataGraphs && !UriGenerator.isMetadataGraphUri(uri)) {
                    uriSet.namedGraphs.add(UriGenerator.generateMetadataGraphUri(uri));
                }
            }
        }
        for (Statement stmt : graph.find(namedDatasetURI, Dataset.defaultNamedGraphProperty, null)) {
            if (stmt.getObject() instanceof URI) {
                URI uri = (URI) stmt.getObject();
                uriSet.namedGraphs.add(uri);
                uriSet.defaultGraphs.add(uri);
                if (includeMetadataGraphs && !UriGenerator.isMetadataGraphUri(uri)) {
                    URI muri = UriGenerator.generateMetadataGraphUri(uri);
                    uriSet.namedGraphs.add(muri);
                    uriSet.defaultGraphs.add(muri);
                }
            }
        }
        if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
            long end = System.currentTimeMillis();
            RequestAnalysis.addAnalysisProperty("expandDataset", String.valueOf(end - start));
        }
        return uriSet;
    }

    /**
     * Get the {@link URI} of the graph's metadata graph
     * 
     * @param context
     *            Operation {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            {@link URI} of named graph
     * @return the {@link URI} of the graph's metadata graph
     * @throws AnzoException
     */
    public boolean containsNamedGraph(IOperationContext context, URI namedGraphUri) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            Boolean contains = (cache != null) ? cache.getContains(namedGraphUri) : null;
            if (contains == null) {
                stats.getContainsNamedGraphMiss().increment();
                contains = containsNamedGraphInternal(context, namedGraphUri);
                if (cache != null)
                    cache.cacheContains(namedGraphUri, contains);
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                }
            } else {
                stats.getContainsNamedGraphHit().increment();
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                }
            }
            if (contains && canRead(context, namedGraphUri)) {
                return true;
            } else {
                return false;
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("containsNamedGraph", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    public void containsNamedGraph(IOperationContext context, URI namedGraphUri, Writer output) throws AnzoException {
        boolean contains = containsNamedGraph(context, namedGraphUri);
        org.openanzo.rdf.utils.SerializationUtils.writeValue(contains, output, null);
    }

    /**
     * Find the set of statements that match the statement pattern
     * 
     * @param subj
     *            Subject {@link Resource} to match, or wildcard if null
     * @param pred
     *            Predicate {@link URI} to match, or wildcard if null
     * @param obj
     *            Object {@link Value} to match, or wildcard if null
     * @param namedGraphURI
     *            {@link Resource} of named graph to match, or wildcard if null
     * @return the set of {@link Statement} that match the quad pattern
     * @throws AnzoException
     */
    public Collection<Statement> findStatements(IOperationContext context, Resource subj, URI pred, Value obj, URI[] namedGraphURI) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        String queryString = StatementUtils.buildQueryString(subj, pred, obj, namedGraphURI);

        try {
            boolean useCache = cache != null && namedGraphURI != null && namedGraphURI.length > 0;
            Collection<Statement> stmts = useCache ? cache.getFindStatements(queryString) : null;
            if (stmts == null) {
                stats.getFindStatementsMiss().increment();
                StatementCollector sc = new StatementCollector();
                findStatementsInternal(context, subj, pred, obj, namedGraphURI, sc);
                stmts = sc.getStatements();
                if (useCache)
                    cache.cacheFind(queryString, stmts);
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                }
            } else {
                stats.getFindStatementsHit().increment();
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                }
            }
            if (stats.isEnabled()) {
                stats.use("findStatements", (System.currentTimeMillis() - start));
            }
            Collection<Statement> results = new ArrayList<Statement>();
            HashMap<URI, Boolean> ok = new HashMap<URI, Boolean>();
            if (stmts != null) {
                for (Statement stmt : stmts) {
                    Boolean canRead = (context.getOperationPrincipal().isSysadmin()) ? Boolean.TRUE : ok.get(stmt.getNamedGraphUri());
                    if (canRead == null) {
                        canRead = canRead(context, stmt.getNamedGraphUri());
                    }
                    if (canRead) {
                        results.add(stmt);
                    }
                }
            }
            return results;
        } finally {
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
        }
    }

    /**
     * Find the set of statements that match the statement pattern
     * 
     * @param context
     *            Operation {@link IOperationContext} context for this operation
     * @param subj
     *            Subject {@link Resource} to match, or wildcard if null
     * @param pred
     *            Predicate {@link URI} to match, or wildcard if null
     * @param obj
     *            Object {@link Value} to match, or wildcard if null
     * @param namedGraphURI
     *            {@link Resource} of named graph to match, or wildcard if null
     * @param writer
     *            {@link Writer} to which results are written
     * @param format
     *            format of output data
     * @throws AnzoException
     */
    public void findStatements(IOperationContext context, Resource subj, URI pred, Value obj, URI[] namedGraphURI, Writer writer, String format) throws AnzoException {
        IRDFHandler rdfWriter = ReadWriteUtils.getWriter(writer, RDFFormat.forMIMEType(format));
        Collection<Statement> results = findStatements(context, subj, pred, obj, namedGraphURI);
        rdfWriter.startRDF();
        if (results != null) {
            for (Statement stmt : results) {
                rdfWriter.handleStatement(stmt);
            }
        }
        rdfWriter.endRDF();
    }

    /**
     * Get the contents of a named graph at a given revision
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            {@link URI} of named graph
     * @param revision
     *            Revision of named graph to retrieve
     * @return the {@link IAnzoGraph} containing results
     * @throws AnzoException
     */
    public IAnzoGraph getNamedGraphRevision(IOperationContext context, URI namedGraphUri, long revision) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            Collection<Statement> stmts = (cache != null) ? cache.getGraph(namedGraphUri, revision) : null;
            if (stmts == null) {
                stats.getGetNamedGraphRevisionMiss().increment();
                stmts = getNamedGraphRevisionInternal(context, namedGraphUri, revision);
                if (cache != null)
                    cache.cacheGraph(namedGraphUri, stmts, revision);
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                }
            } else {
                stats.getGetNamedGraphRevisionHit().increment();

                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                }
            }
            if (!canRead(context, namedGraphUri)) {
                return null;
            }
            MemQuadStore quadStore = new MemQuadStore();
            quadStore.add(stmts);
            return new AnzoGraph(namedGraphUri, new NamedGraph(UriGenerator.generateMetadataGraphUri(namedGraphUri), quadStore), quadStore);
        } finally {
            if (stats.isEnabled()) {
                stats.use("getNamedGraphRevision", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    /**
     * Get the contents of a named graph at a given revision
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            {@link URI} of named graph
     * @param revision
     *            Revision of named graph to retrieve
     * @param writer
     *            {@link Writer} to which results are written
     * @param formatString
     *            format of results for output data
     * @throws AnzoException
     */
    public void getNamedGraphRevision(IOperationContext context, URI namedGraphUri, long revision, Writer writer, String formatString) throws AnzoException {
        RDFFormat format = RDFFormat.forMIMEType(formatString);
        if (format.supportsNamedGraphs()) {
            IRDFHandler handler = ReadWriteUtils.getWriter(writer, format);
            if (handler != null) {
                long start = 0;
                if (stats.isEnabled()) {
                    start = System.currentTimeMillis();
                }
                if (getLockProvider() != null)
                    getLockProvider().readLock().lock();
                logEntry();
                try {
                    handler.startRDF();
                    Collection<Statement> stmts = (cache != null) ? cache.getGraph(namedGraphUri, revision) : null;
                    if (stmts == null) {
                        stats.getGetNamedGraphRevisionMiss().increment();
                        stmts = getNamedGraphRevisionInternal(context, namedGraphUri, revision);
                        if (cache != null)
                            cache.cacheGraph(namedGraphUri, stmts, revision);
                        if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                            RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                        }
                    } else {
                        stats.getGetNamedGraphRevisionHit().increment();
                        if (!canRead(context, namedGraphUri)) {
                            stmts = null;
                        }
                        if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                            RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                        }
                    }
                    if (stmts != null) {
                        for (Statement stmt : stmts) {
                            handler.handleStatement(stmt);
                        }
                    }
                } finally {
                    handler.endRDF();
                    if (stats.isEnabled()) {
                        stats.use("getNamedGraphRevision", (System.currentTimeMillis() - start));
                    }
                    if (getLockProvider() != null)
                        getLockProvider().readLock().unlock();
                    logExit();
                }
            }
        } else {
            throw new AnzoException(ExceptionConstants.IO.NO_GRAPH_SUPPORT_RDFFORMAT, formatString);
        }
    }

    /**
     * Find the statements that match the provided quad pattern
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param subj
     *            Subject {@link Resource} to match, or wildcard if null
     * @param pred
     *            Predicate {@link URI} to match, or wildcard if null
     * @param obj
     *            Object {@link Value} to match, or wildcard if null
     * @param namedGraphURI
     *            {@link Resource} of named graph to match, or wildcard if null
     * @param handler
     *            {@link IRDFHandler} which handles the result statements
     * @throws AnzoException
     */
    protected abstract void findStatementsInternal(IOperationContext context, Resource subj, URI pred, Value obj, URI[] namedGraphURI, IRDFHandler handler) throws AnzoException;

    /**
     * Get the size of a named graph
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * 
     * @param namedGraphUri
     *            {@link URI} of named graph
     * @return Number of triples in named graph
     * @throws AnzoException
     *             Throws an exception if graph not found or user does not have permission to read graph. Note: If user doesn't have permission to see graph,
     *             unknown graph error is still thrown in order to prevent probing queries to determine existing of graphs
     */
    protected abstract long getSizeInternal(IOperationContext context, URI namedGraphUri) throws AnzoException;

    /**
     * Get the URI of a NamedGraph given a UUID
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * 
     * @param namedGraphUri
     *            UUID {@link URI} of named graph
     * @return URI of named graph
     * @throws AnzoException
     *             Throws an exception if graph not found or user does not have permission to read graph. Note: If user doesn't have permission to see graph,
     *             unknown graph error is still thrown in order to prevent probing queries to determine existing of graphs
     */
    protected abstract URI getUriForUUIDInternal(IOperationContext context, URI namedGraphUUIDUri) throws AnzoException;

    /**
     * Get the UUID of a NamedGraph given a URI
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * 
     * @param namedGraphUri
     *            UUID {@link URI} of named graph
     * @return URI of named graph
     * @throws AnzoException
     *             Throws an exception if graph not found or user does not have permission to read graph. Note: If user doesn't have permission to see graph,
     *             unknown graph error is still thrown in order to prevent probing queries to determine existing of graphs
     */
    protected abstract URI getUUIDforUriInternal(IOperationContext context, URI namedGraphUri) throws AnzoException;

    /**
     * Return true if named graph is within this model
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * 
     * @param namedGraphUri
     *            {@link URI} of named graph
     * @return {@link boolean} if named graph is within this model
     * @throws AnzoException
     *             Throws an exception if graph not found or user does not have permission to read graph. Note: If user doesn't have permission to see graph,
     *             unknown graph error is still thrown in order to prevent probing queries to determine existing of graphs
     */
    protected abstract boolean containsNamedGraphInternal(IOperationContext context, URI namedGraphUri) throws AnzoException;

    /**
     * Get stored NamedGraphs that user can read
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * 
     * @param valueSetHandler
     *            {@link IValueSetHandler} call-back handler for handling the values
     * @throws AnzoException
     */
    protected abstract void getStoredNamedGraphsInternal(IOperationContext context, IValueSetHandler<String> valueSetHandler) throws AnzoException;

    /**
     * Get the contents of a named graph at a given revision, and pass the results to an IBocaHandler. If the revision number is -1, this method should return
     * the latest revision.
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            {@link URI} of named graph
     * @param revision
     *            Revision to retrieve, or -1 for the latest revision.
     * @param handler
     *            {@link IRepositoryHandler} call-back handler to which results are written
     * @return true unless there was an exception
     * @throws AnzoException
     *             If the graph is non-revisioned and the revision requested was not -1, throws an exception with identifier
     *             DATASOURCE.NAMEDGRAPH.NON_REVISIONED_GRAPH.
     */
    protected abstract Collection<Statement> getNamedGraphRevisionInternal(IOperationContext context, URI namedGraphUri, long revision) throws AnzoException;

}
