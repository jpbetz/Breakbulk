/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 17, 2008
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.cache.ICache;
import org.openanzo.cache.ICacheListener;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.CopyOnWriteMultiHashMap;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The query cache
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class QueryCache implements IUpdateResultListener, IQueryCache {
    static final Logger                  log        = LoggerFactory.getLogger(QueryCache.class);

    ICache<String, QueryResults>         cache;

    CopyOnWriteMultiHashMap<URI, String> graphCache = new CopyOnWriteMultiHashMap<URI, String>();

    final Lock                           lock       = new ReentrantLock();

    /**
     * Query cache for the query service
     * 
     * @param name
     *            name of datasource
     * @param provider
     *            cache provider
     */
    public QueryCache(String name, ICacheProvider provider) {
        this.cache = provider.openCache(name + "_" + "QueryService", 1000, false);
        this.cache.registerListener(new ICacheListener<String, QueryResults>() {
            public void elementRemoved(String queryString, QueryResults result) {
                Set<URI> allGraphs = new HashSet<URI>();
                org.openanzo.rdf.utils.Collections.addAllIfNotNull(result.getQueryDataset().getDefaultGraphURIs(), allGraphs);
                org.openanzo.rdf.utils.Collections.addAllIfNotNull(result.getQueryDataset().getNamedGraphURIs(), allGraphs);
                for (URI uri : allGraphs) {
                    graphCache.remove(uri, queryString);
                }
            }
        });
        for (String key : this.cache.keySet()) {
            QueryResults result = this.cache.get(key);
            Set<URI> allGraphs = new HashSet<URI>();
            org.openanzo.rdf.utils.Collections.addAllIfNotNull(result.getQueryDataset().getDefaultGraphURIs(), allGraphs);
            org.openanzo.rdf.utils.Collections.addAllIfNotNull(result.getQueryDataset().getNamedGraphURIs(), allGraphs);
            for (URI uri : allGraphs) {
                graphCache.put(uri, key);
            }
        }
    }

    public void reset() {
        lock.lock();
        try {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "QueryCache reset");
            }
            cache.clear();
            graphCache.clear();
        } finally {
            lock.unlock();
        }
    }

    public QueryResults findResults(String queryString, QueryDataset dataset) {
        lock.lock();
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            if (dataset.allGraphs || dataset.defaultAllGraphs || dataset.allMetadataGraphs || dataset.defaultAllMetadataGraphs || dataset.allNamedGraphs || dataset.defaultAllNamedGraphs) {
                if (log.isDebugEnabled())
                    log.debug(LogUtils.DATASOURCE_MARKER, "Query Cache MISS (allDefault): " + queryString);
                return null;
            }

            boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
            long start = 0;
            if (log.isDebugEnabled() || isEnabled) {
                start = System.currentTimeMillis();
            }
            QueryResults result = cache.get(queryString);
            if (log.isDebugEnabled() || isEnabled) {
                if (log.isDebugEnabled()) {
                    long end = System.currentTimeMillis();
                    log.debug(LogUtils.DATASOURCE_MARKER, "Lookup cache time: " + (end - start));
                }
                if (isEnabled) {
                    RequestAnalysis.getAnalysisLogger().debug(LogUtils.TIMING_MARKER, "glitter_queryCacheLookupCache,{}", Long.toString(System.currentTimeMillis() - start));
                }
                start = System.currentTimeMillis();
            }
            if (result != null) {

                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.DATASOURCE_MARKER, "QueryCache HIT:" + queryString);
                }
                return result;
            }
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Query Cache MISS (string): " + queryString);
            }
            return null;
        } finally {
            lock.unlock();
            Thread.currentThread().setContextClassLoader(cl);
        }
    }

    public void cacheResults(String queryString, QueryResults result, QueryDataset dataset) {
        lock.lock();
        try {
            if (result.isConstructResult() || result.isDescribeResult()) {
                if ((result.isConstructResult() && result.getConstructResults().size() > 10000) || (result.isDescribeResult() && result.getDescribeResults().size() > 10000)) {
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.DATASOURCE_MARKER, "Not caching large results:" + queryString);
                    }
                    return;
                }
            } else if (result.isSelectResult()) {
                if (result.getSelectResults().size() > 10000) {
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.DATASOURCE_MARKER, "Not caching large results:" + queryString + " results(" + result.getSelectResults().size() + ")");
                    }
                    return;
                }
            }
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "QueryCache CACHING:" + queryString);
            }
            cache.put(queryString, result);
            Set<URI> allGraphs = new HashSet<URI>();
            org.openanzo.rdf.utils.Collections.addAllIfNotNull(dataset.getDefaultGraphURIs(), allGraphs);
            org.openanzo.rdf.utils.Collections.addAllIfNotNull(dataset.getNamedGraphURIs(), allGraphs);
            for (URI uri : allGraphs) {
                graphCache.put(uri, queryString);
            }
        } finally {
            lock.unlock();
        }
    }

    public void updateComplete(IOperationContext context, IUpdates results) throws AnzoException {
        long start = 0;
        if (log.isDebugEnabled()) {
            start = System.currentTimeMillis();
        }
        lock.lock();
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            for (IUpdateTransaction transaction : results.getTransactions()) {
                for (URI ngUri : transaction.getUpdatedNamedGraphs().keySet()) {
                    URI mdGraph = UriGenerator.generateMetadataGraphUri(ngUri);
                    Collection<String> queries = graphCache.get(ngUri);
                    if (queries != null) {
                        for (String query : queries) {
                            QueryResults result = cache.get(query);
                            if (result != null) {
                                if (null != cache.remove(query)) {
                                    if (log.isDebugEnabled()) {
                                        log.debug(LogUtils.DATASOURCE_MARKER, "QueryCache Removed:" + query);
                                    }
                                }
                                for (URI g : result.getQueryDataset().getDefaultGraphURIs()) {
                                    graphCache.remove(g, query);
                                }
                                for (URI g : result.getQueryDataset().getNamedGraphURIs()) {
                                    graphCache.remove(g, query);
                                }
                            }
                        }
                    }
                    graphCache.remove(ngUri);
                    queries = graphCache.get(mdGraph);
                    if (queries != null) {
                        for (String query : queries) {
                            QueryResults result = cache.get(query);
                            if (result != null) {
                                if (null != cache.remove(query)) {
                                    if (log.isDebugEnabled()) {
                                        log.debug(LogUtils.DATASOURCE_MARKER, "QueryCache Removed:" + query);
                                    }
                                }
                                for (URI g : result.getQueryDataset().getDefaultGraphURIs()) {
                                    graphCache.remove(g, query);
                                }
                                for (URI g : result.getQueryDataset().getNamedGraphURIs()) {
                                    graphCache.remove(g, query);
                                }
                            }
                        }
                    }
                    graphCache.remove(mdGraph);
                }
            }
        } finally {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.TIMING_MARKER, "QUERY CACHE UPDATE,{}", (System.currentTimeMillis() - start));
            }
            lock.unlock();
            Thread.currentThread().setContextClassLoader(cl);
        }
    }
}
