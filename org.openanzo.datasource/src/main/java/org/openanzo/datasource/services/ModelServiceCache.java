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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.cache.ICache;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Cache for the model service
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ModelServiceCache implements IUpdateResultListener {
    private static final Logger           log  = LoggerFactory.getLogger(ModelServiceCache.class);

    ICache<String, Collection<Statement>> findCache;

    ICache<URI, Long>                     sizeCache;

    ICache<URI, Boolean>                  containsCache;

    ICache<URI, URI>                      uuidCache;

    ICache<String, Collection<Statement>> revisionCache;

    ICache<URI, QueryDataset>             datasetCache;

    private final Lock                    lock = new ReentrantLock();

    ModelServiceCache(String name, ICacheProvider cacheProvider) {
        this.findCache = cacheProvider.<String, Collection<Statement>> openCache(name + "ModelServiceFindCache", 5000, true);
        this.sizeCache = cacheProvider.<URI, Long> openCache(name + "ModelServiceSizeCache", 10000, true);
        this.containsCache = cacheProvider.<URI, Boolean> openCache(name + "ModelServiceContainsCache", 10000, true);
        this.uuidCache = cacheProvider.<URI, URI> openCache(name + "ModelServiceUUIDCache", 25000, true);
        this.revisionCache = cacheProvider.<String, Collection<Statement>> openCache(name + "ModelServiceRevisionCache", 5000, true);
        this.datasetCache = cacheProvider.<URI, QueryDataset> openCache(name + "ModelServiceDatasetCache", 5000, true);
    }

    void reset() {
        lock.lock();
        try {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "QueryCache reset");
            }
            findCache.clear();
            sizeCache.clear();
            containsCache.clear();
            uuidCache.clear();
            revisionCache.clear();
            datasetCache.clear();
        } finally {
            lock.unlock();
        }
    }

    private ThreadLocal<ClassLoader> oldLoader = new ThreadLocal<ClassLoader>();

    private void entry() {
        oldLoader.set(Thread.currentThread().getContextClassLoader());
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
    }

    private void exit() {
        Thread.currentThread().setContextClassLoader(oldLoader.get());
        oldLoader.remove();
    }

    Long getSize(URI namedGraphURI) {
        entry();
        try {
            Long result = sizeCache.get(namedGraphURI);
            if (result != null && log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "CacheHit Size:" + namedGraphURI + ":" + result.toString());
            }
            return result;
        } finally {
            exit();
        }
    }

    void cacheSize(URI namedGraphURI, Long size) {
        entry();
        try {
            sizeCache.put(namedGraphURI, size);
        } finally {
            exit();
        }
    }

    Collection<Statement> getGraph(URI namedGraphURI, long revision) {
        entry();
        try {
            Collection<Statement> result = revisionCache.get(namedGraphURI.toString() + ":" + revision);
            if (result != null && log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "CacheHit Graph:" + namedGraphURI + ":" + result.toString());
            }
            return result;
        } finally {
            exit();
        }
    }

    void cacheGraph(URI namedGraphURI, Collection<Statement> graph, long revision) {
        entry();
        try {
            revisionCache.put(namedGraphURI.toString() + ":" + revision, graph);
        } finally {
            exit();
        }
    }

    Collection<Statement> getFindStatements(String queryString) {
        entry();
        try {
            Collection<Statement> result = findCache.get(queryString);
            if (result != null && log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "CacheHit Find:" + queryString + ":" + result.toString());
            }
            return result;
        } finally {
            exit();
        }
    }

    void cacheFind(String queryString, Collection<Statement> stmts) {
        entry();
        try {
            findCache.put(queryString, stmts);
        } finally {
            exit();
        }
    }

    Boolean getContains(URI namedGraphURI) {
        entry();
        try {
            Boolean result = containsCache.get(namedGraphURI);
            if (result != null && log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "CacheHit Contains:" + namedGraphURI + ":" + result.toString());
            }
            return result;
        } finally {
            exit();
        }
    }

    void cacheContains(URI namedGraphURI, Boolean contains) {
        entry();
        try {
            containsCache.put(namedGraphURI, contains);
        } finally {
            exit();
        }
    }

    URI getUriForUUID(URI uuid) {
        entry();
        try {
            URI result = uuidCache.get(uuid);
            if (result != null && log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "CacheHit UUID:" + uuid + ":" + result.toString());
            }
            return result;
        } finally {
            exit();
        }
    }

    void cacheUriForUUID(URI uuid, URI uri) {
        entry();
        try {
            uuidCache.put(uuid, uri);
        } finally {
            exit();
        }
    }

    URI getUUIDforURI(URI uri) {
        entry();
        try {
            URI result = uuidCache.get(uri);
            if (result != null && log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "CacheHit URI:" + uri + ":" + result.toString());
            }
            return result;
        } finally {
            exit();
        }
    }

    void cacheUUIDforURI(URI uri, URI uuid) {
        entry();
        try {
            uuidCache.put(uri, uuid);
        } finally {
            exit();
        }
    }

    public QueryDataset getNamedDataset(URI namedDatasetURI) {
        entry();
        try {
            QueryDataset result = datasetCache.get(namedDatasetURI);
            if (result != null && log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "CacheHit Dataset:" + namedDatasetURI + ":" + result.toString());
            }
            return result;
        } finally {
            exit();
        }
    }

    public void cacheNamedDataset(URI namedDatasetURI, QueryDataset uris) {
        entry();
        try {
            datasetCache.put(namedDatasetURI, uris);
        } finally {
            exit();
        }
    }

    public void updateComplete(IOperationContext context, IUpdates results) throws AnzoException {
        lock.lock();
        long start = 0;
        if (log.isDebugEnabled()) {
            start = System.currentTimeMillis();
        }
        entry();
        try {
            for (IUpdateTransaction transaction : results.getTransactions()) {
                for (URI ngUri : transaction.getUpdatedNamedGraphs().keySet()) {
                    URI mdGraph = UriGenerator.generateMetadataGraphUri(ngUri);
                    updateCache(ngUri);
                    updateCache(mdGraph);
                    if (null != uuidCache.remove(transaction.getUpdatedNamedGraphs().get(ngUri))) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.DATASOURCE_MARKER, "Removing uuid:" + mdGraph.toString());
                        }
                    }
                }
                for (URI ngUri : transaction.getRemovedNamedGraphs().keySet()) {
                    URI mdGraph = UriGenerator.generateMetadataGraphUri(ngUri);
                    removeCache(ngUri);
                    removeCache(mdGraph);
                    if (null != uuidCache.remove(transaction.getUpdatedNamedGraphs().get(ngUri))) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.DATASOURCE_MARKER, "Removing uuid:" + mdGraph.toString());
                        }
                    }
                }
                if (transaction.getRemovedNamedGraphs().size() > 0) {
                    removeCache(Constants.GRAPHS.GRAPHS_DATASET);
                    removeCache(Constants.GRAPHS.METADATA_GRAPHS_DATASET);
                }
                for (Long rev : transaction.getUpdatedNamedGraphRevisions().values()) {
                    if (rev.longValue() == 0) {
                        removeCache(Constants.GRAPHS.GRAPHS_DATASET);
                        removeCache(Constants.GRAPHS.METADATA_GRAPHS_DATASET);
                        break;
                    }
                }
            }
        } finally {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.TIMING_MARKER, "MODEL CACHE UPDATE,{}", (System.currentTimeMillis() - start));
            }
            lock.unlock();
            exit();
        }
    }

    private void updateCache(URI ngUri) {
        if (null != sizeCache.remove(ngUri))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing size:" + ngUri.toString());
            }
        if (null != revisionCache.remove(ngUri.toString() + ":-1"))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing revision:" + ngUri.toString());
            }
        if (null != uuidCache.remove(ngUri))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing uuid:" + ngUri.toString());
            }
        if (null != datasetCache.remove(ngUri))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing dataset:" + ngUri.toString());
            }
        if (null != containsCache.remove(ngUri))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing contains:" + ngUri.toString());
            }

        for (String obj : findCache.keySet()) {
            if (obj.toString().contains(ngUri.toString())) {
                if (null != findCache.remove(obj))
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.DATASOURCE_MARKER, "Removing find:" + obj);
                    }
            }
        }
    }

    private void removeCache(URI ngUri) {
        if (null != sizeCache.remove(ngUri))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing size:" + ngUri.toString());
            }
        if (null != revisionCache.remove(ngUri.toString() + ":-1"))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing revision:" + ngUri.toString());
            }
        if (null != uuidCache.remove(ngUri))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing uuid:" + ngUri.toString());
            }
        if (null != datasetCache.remove(ngUri))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing dataset:" + ngUri.toString());
            }
        if (null != containsCache.remove(ngUri))
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Removing contains:" + ngUri.toString());
            }
        for (String obj : findCache.keySet()) {
            if (obj.toString().contains(ngUri.toString())) {
                if (null != findCache.remove(obj))
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.DATASOURCE_MARKER, "Removing find:" + obj);
                    }
            }
        }
    }
}
