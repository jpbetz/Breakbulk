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
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.ArrayUtils;
import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IQueryService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.ExceptionConstants.IO;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.ParseOnlyEngineConfig;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.glitter.exception.GlitterParseException;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.OPTIONS;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.SerializationUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.Privilege;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.openanzo.services.serialization.IQueryResultsHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base implementation of the IQueryService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseQueryService extends BaseDatasourceComponent implements IQueryService {
    private static final Logger              log   = LoggerFactory.getLogger(BaseQueryService.class);

    private final QueryServiceWithCacheStats stats = new QueryServiceWithCacheStats("query", "askQuery");

    protected IQueryCache                    cache;

    protected void initCache(ICacheProvider cacheProvider) {
        if (cacheProvider != null) {
            createQueryCache(cacheProvider);
        }
    }

    protected void createQueryCache(ICacheProvider cacheProvider) {
        this.cache = new QueryCache(getDatasource().getInstanceURI().toString(), cacheProvider);
    }

    public String getName() {
        return getDatasource().getName() + ",Service=QueryService";
    }

    public String getDescription() {
        return "Query Service for " + getDatasource().getName();
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    public void start() throws AnzoException {
        stats.setEnabled(true);
    }

    public void reset() throws AnzoException {
        stats.reset();
        if (cache != null)
            cache.reset();
    }

    /**
     * Get the cacheUpdateListener for this service
     * 
     * @return the cacheUpdateListener for this service
     */
    public IUpdateResultListener getCacheUpdateListener() {
        return cache;
    }

    /**
     * Query where results are passed to handler
     * 
     * @param context
     * @param defaultNamedGraphs
     * @param graphs
     * @param namedDatasets
     * @param paramQuery
     * @param queryString
     * @param baseUri
     * @param queryResultsHandler
     * @throws AnzoException
     */
    public void query(IOperationContext context, Set<URI> defaultNamedGraphs, Set<URI> graphs, Set<URI> namedDatasets, String paramQuery, String queryString, URI baseUri, IQueryResultsHandler queryResultsHandler) throws AnzoException {
        // try {
        org.openanzo.glitter.query.QueryResults queryResults = query(context, defaultNamedGraphs, graphs, namedDatasets, paramQuery, queryString, baseUri);

        queryResultsHandler.start(queryResults.getQueryType(), queryResults.getTotalSolutions());
        switch (queryResults.getQueryType()) {
        case ASK:
            queryResultsHandler.handleAskResult(queryResults.getAskResults());
            break;
        case CONSTRUCT_QUADS:
        case DESCRIBE_QUADS:
        case CONSTRUCT:
        case DESCRIBE:
            for (Statement stmt : queryResults.getConstructResults()) {
                queryResultsHandler.handleStatement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), stmt.getNamedGraphUri());
            }
            break;
        case SELECT:
            SolutionSet solutionSet = queryResults.getSelectResults();
            queryResultsHandler.handleBindings(solutionSet.getBindings());
            for (PatternSolution sol : solutionSet) {
                queryResultsHandler.handleSolution(sol);
            }
            break;
        }
        queryResultsHandler.end();
    }

    protected boolean canRead(IOperationContext context, URI namedGraphUri, boolean failIfNotFound) throws AnzoException {
        try {
            Set<URI> roles = getDatasource().getAuthorizationService().getRolesForGraph(context, namedGraphUri, Privilege.READ);
            if (!context.getOperationPrincipal().isSysadmin() && !org.openanzo.rdf.utils.Collections.memberOf(roles, context.getOperationPrincipal().getRoles())) {
                return false;
            }
            return true;
        } catch (AnzoException ae) {
            if (!failIfNotFound && ae.getErrorCode() == ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND) {
                return false;
            }
            throw new GlitterRuntimeException(ae);
        }
    }

    protected QueryDataset resolveQueryUriSet(IOperationContext context, Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets) throws AnzoException {
        long start = System.currentTimeMillis();
        DefaultQueryDataset uriSet = new DefaultQueryDataset();
        if (defaultGraphs != null) {
            for (URI uri : defaultGraphs) {
                if (!uri.equals(GRAPHS.ALL_GRAPHS) && !uri.equals(GRAPHS.ALL_METADATAGRAPHS) && !uri.equals(GRAPHS.ALL_NAMEDGRAPHS)) {
                    if (!canRead(context, uri, true)) {
                        new GlitterRuntimeException(ExceptionConstants.DATASOURCE.NO_READ_ERROR, uri.toString());
                    }
                } else if (uri.equals(GRAPHS.ALL_GRAPHS)) {
                    uriSet.defaultAllGraphs = true;
                } else if (uri.equals(GRAPHS.ALL_METADATAGRAPHS)) {
                    uriSet.defaultAllMetadataGraphs = true;
                } else if (uri.equals(GRAPHS.ALL_NAMEDGRAPHS)) {
                    uriSet.defaultAllNamedGraphs = true;
                }
            }
        }
        if (namedGraphs != null) {
            for (URI uri : namedGraphs) {
                if (!uri.equals(GRAPHS.ALL_GRAPHS) && !uri.equals(GRAPHS.ALL_METADATAGRAPHS) && !uri.equals(GRAPHS.ALL_NAMEDGRAPHS)) {
                    if (!canRead(context, uri, true)) {
                        new GlitterRuntimeException(ExceptionConstants.DATASOURCE.NO_READ_ERROR, uri.toString());
                    }
                } else if (uri.equals(GRAPHS.ALL_GRAPHS)) {
                    uriSet.allGraphs = true;
                } else if (uri.equals(GRAPHS.ALL_METADATAGRAPHS)) {
                    uriSet.allMetadataGraphs = true;
                } else if (uri.equals(GRAPHS.ALL_NAMEDGRAPHS)) {
                    uriSet.allNamedGraphs = true;
                }
            }
        }
        boolean both = (((namedGraphs != null && namedGraphs.size() > 0) || uriSet.allGraphs || uriSet.allMetadataGraphs || uriSet.allNamedGraphs) || ((defaultGraphs != null && defaultGraphs.size() > 0) || uriSet.defaultAllGraphs || uriSet.defaultAllMetadataGraphs || uriSet.defaultAllNamedGraphs)) && (namedDatasets != null && namedDatasets.size() > 0);
        uriSet.setDefaultGraphs((both) ? new TreeSet<URI>() : new LinkedHashSet<URI>());
        uriSet.setNamedGraphs((both) ? new TreeSet<URI>() : new LinkedHashSet<URI>());

        // expand out the graph names from the named datasets
        if (defaultGraphs != null && defaultGraphs.size() > 0) {
            uriSet.getDefaultGraphURIs().addAll((both) ? defaultGraphs : new TreeSet<URI>(defaultGraphs));
        }
        if (namedGraphs != null && namedGraphs.size() > 0) {
            uriSet.getNamedGraphURIs().addAll((both) ? namedGraphs : new TreeSet<URI>(namedGraphs));
        }

        if (namedDatasets != null) {

            Boolean includeMetadata = context.getAttribute(OPTIONS.INCLUDEMETADATAGRAPHS, Boolean.class);
            boolean icm = includeMetadata != null ? includeMetadata : false;
            for (URI namedDataset : namedDatasets) {
                QueryDataset uris = getDatasource().getModelService().resolveNamedDataset(context, namedDataset);
                if (uris.fullyExpandedDatasets) {
                    uriSet.getDefaultGraphURIs().addAll(uris.getDefaultGraphURIs());
                    uriSet.getNamedGraphURIs().addAll(uris.getNamedGraphURIs());
                } else {
                    if (uris.getDefaultGraphURIs() != null) {
                        for (URI uri : uris.getDefaultGraphURIs()) {
                            if (context.getOperationPrincipal().isSysadmin() || canRead(context, uri, false)) {
                                uriSet.getDefaultGraphURIs().add(uri);
                                if (icm && !UriGenerator.isMetadataGraphUri(uri) && (context.getOperationPrincipal().isSysadmin() || canRead(context, UriGenerator.generateMetadataGraphUri(uri), false))) {
                                    uriSet.getDefaultGraphURIs().add(UriGenerator.generateMetadataGraphUri(uri));
                                }
                            }
                        }
                    }
                    if (uris.getNamedGraphURIs() != null) {
                        for (URI uri : uris.getNamedGraphURIs()) {
                            if (context.getOperationPrincipal().isSysadmin() || canRead(context, uri, false)) {
                                uriSet.getNamedGraphURIs().add(uri);
                                if (icm && !UriGenerator.isMetadataGraphUri(uri) && (context.getOperationPrincipal().isSysadmin() || canRead(context, UriGenerator.generateMetadataGraphUri(uri), false))) {
                                    uriSet.getNamedGraphURIs().add(UriGenerator.generateMetadataGraphUri(uri));
                                }
                            }
                        }
                    }
                }
            }
        }
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.TIMING_MARKER, "RESOLVE QUERY URIS,{},{}", (System.currentTimeMillis() - start), uriSet.namedGraphs.size() + uriSet.defaultGraphs.size());
        }
        return uriSet;
    }

    protected QueryDataset resolveAndVerifyGraphs(IOperationContext context, Set<URI> dngs, Set<URI> ngs, Set<URI> namedDatasets, String queryString, URI baseUri, QueryController prepareQuery) throws AnzoException {
        QueryDataset uriSet = null;
        if ((dngs == null || dngs.size() == 0) && (ngs == null || ngs.size() == 0) && (namedDatasets == null || namedDatasets.size() == 0)) {
            uriSet = resolveQueryUriSet(context, prepareQuery.getQueryDataset().getDefaultGraphURIs(), prepareQuery.getQueryDataset().getNamedGraphURIs(), prepareQuery.getQueryDataset().getNamedDatasetURIs());
        } else {
            uriSet = resolveQueryUriSet(context, dngs, ngs, namedDatasets);
        }
        if (!(uriSet.allGraphs || uriSet.allMetadataGraphs || uriSet.allNamedGraphs || uriSet.defaultAllGraphs || uriSet.defaultAllMetadataGraphs || uriSet.defaultAllNamedGraphs)) {
            context.setAttribute("datasetResolved", Boolean.TRUE);
            uriSet.datasetFullyResolved = true;
        }
        return uriSet;
    }

    public org.openanzo.glitter.query.QueryResults query(IOperationContext context, Set<URI> defaultNamedGraphs, Set<URI> graphs, Set<URI> namedDatasets, String paramQuery, String queryString, URI baseUri) throws AnzoException {
        if (queryString == null || queryString.length() == 0)
            queryString = paramQuery; // TEMP fix until we drop support for
        // paramQuery in messages
        long start = 0;
        if (stats.isEnabled() || log.isDebugEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.DATASOURCE_MARKER, "Query:{} [{}] [{}] [{}]", new Object[] { queryString, defaultNamedGraphs != null ? ArrayUtils.toString(defaultNamedGraphs.toArray(new URI[0])) : "null", graphs != null ? ArrayUtils.toString(graphs.toArray(new URI[0])) : "null", namedDatasets != null ? ArrayUtils.toString(namedDatasets.toArray(new URI[0])) : "null" });
        }
        try {
            QueryController prepareQuery = new Engine(new ParseOnlyEngineConfig()).prepareQuery(null, queryString, null, baseUri);
            QueryDataset uriSet = resolveAndVerifyGraphs(context, defaultNamedGraphs, graphs, namedDatasets, queryString, baseUri, prepareQuery);
            Boolean skipCache = context.getAttribute(OPTIONS.SKIPCACHE, Boolean.class);
            boolean skip = (skipCache != null && skipCache) || cache == null;
            skip |= (uriSet.allGraphs || uriSet.allMetadataGraphs || uriSet.allNamedGraphs || uriSet.defaultAllGraphs || uriSet.defaultAllMetadataGraphs || uriSet.defaultAllNamedGraphs);
            String cacheString = !skip ? queryString + uriSet.getCacheString() : null;

            org.openanzo.glitter.query.QueryResults queryResults = !skip ? cache.findResults(cacheString, uriSet) : null;
            if (queryResults == null) {
                if (stats.isEnabled()) {
                    stats.getCacheMiss().increment();
                }
                queryResults = executeQueryInternal(context, uriSet, queryString, baseUri);
                if (!skip && cache != null) {
                    cache.cacheResults(cacheString, queryResults, uriSet);
                }
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                }
            } else {
                if (stats.isEnabled()) {
                    stats.getCacheHit().increment();
                }
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                }
            }
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.TIMING_MARKER, "Total Query Time:results,{},{},{}", new Object[] { (System.currentTimeMillis() - start), queryResults.getTotalSolutions(), queryString });
            }
            return queryResults;
        } catch (ParseException pe) {
            throw new GlitterParseException(pe, queryString, pe.getMessage());
        } finally {
            if (stats.isEnabled()) {
                stats.use("query", (System.currentTimeMillis() - start));
            }

            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    public void askQuery(IOperationContext context, Set<URI> defaultNamedGraphs, Set<URI> graphs, Set<URI> namedDatasets, String paramQuery, String queryString, URI baseUri, boolean current, Writer out) throws AnzoException {
        boolean queryResults = askQuery(context, defaultNamedGraphs, graphs, namedDatasets, paramQuery, queryString, baseUri, current);
        SerializationUtils.writeValue(queryResults, out, null);
    }

    public boolean askQuery(IOperationContext context, Set<URI> defaultNamedGraphs, Set<URI> graphs, Set<URI> namedDatasets, String paramQuery, String queryString, URI baseUri, boolean current) throws AnzoException {
        if (queryString == null || queryString.length() == 0)
            queryString = paramQuery; // TEMP fix until we drop support for
        // paramQuery in messages
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            QueryController prepareQuery = new Engine(new ParseOnlyEngineConfig()).prepareQuery(null, queryString, null, baseUri);
            QueryDataset uriSet = resolveAndVerifyGraphs(context, defaultNamedGraphs, graphs, namedDatasets, queryString, baseUri, prepareQuery);
            Boolean skipCache = context.getAttribute(OPTIONS.SKIPCACHE, Boolean.class);
            boolean skip = (skipCache != null && skipCache) || cache == null;
            skip |= (uriSet.allGraphs || uriSet.allMetadataGraphs || uriSet.allNamedGraphs || uriSet.defaultAllGraphs || uriSet.defaultAllMetadataGraphs || uriSet.defaultAllNamedGraphs);
            String cacheString = !skip ? queryString + uriSet.getCacheString() : null;

            org.openanzo.glitter.query.QueryResults queryResults = !skip ? cache.findResults(cacheString, uriSet) : null;

            if (queryResults == null) {
                if (stats.isEnabled()) {
                    stats.getCacheMiss().increment();
                }
                queryResults = executeQueryInternal(context, uriSet, queryString, baseUri);
                if (!skip && cache != null) {
                    cache.cacheResults(cacheString, queryResults, uriSet);
                }
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                }
            } else {
                if (stats.isEnabled()) {
                    stats.getCacheHit().increment();
                }
                if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                }
            }
            return queryResults.getAskResults();
        } catch (ParseException pe) {
            throw new GlitterParseException(pe, queryString, pe.getMessage());
        } finally {
            if (stats.isEnabled()) {
                stats.use("askQuery", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    /**
     * Run a query on the server's data
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * 
     * @param queryController
     *            prepopulated QueryController
     * @return the results of the query
     * @throws AnzoException
     */
    protected abstract org.openanzo.glitter.query.QueryResults executeQueryInternal(IOperationContext context, QueryDataset uriSet, String queryString, URI baseUri) throws AnzoException;

    public void query(IOperationContext context, Set<URI> defaultNamedGraphs, Set<URI> graphs, Set<URI> namedDatasets, String paramQuery, String queryString, URI baseUri, Writer out, String format) throws AnzoException {
        try {
            org.openanzo.glitter.query.QueryResults queryResults = query(context, defaultNamedGraphs, graphs, namedDatasets, paramQuery, queryString, baseUri);
            out.write(queryResults.getQueryType().name() + "\n");
            CommonSerializationUtils.writeQueryResults(queryResults, out, format);
            context.setAttribute(SerializationConstants.totalSolutions, queryResults.getTotalSolutions());
        } catch (IOException ioe) {
            throw new AnzoException(IO.WRITE_ERROR, ioe, ioe.getMessage());
        }
    }
}
