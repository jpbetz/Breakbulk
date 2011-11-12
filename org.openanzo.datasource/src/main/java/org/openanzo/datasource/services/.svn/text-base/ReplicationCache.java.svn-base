/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 21, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.cache.ICache;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.serialization.IReplicationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Replication service cache
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ReplicationCache implements IUpdateResultListener {
    private static final Logger             log  = LoggerFactory.getLogger(ReplicationCache.class);

    private final Lock                      lock = new ReentrantLock();

    private ICache<URI, NamedGraphRevision> cache;

    ReplicationCache(ICache<URI, NamedGraphRevision> cache) {
        this.cache = cache;
    }

    void reset() {
        cache.clear();
    }

    boolean lookupCache(URI uuid, IReplicationHandler handler) throws AnzoException {
        lock.lock();
        NamedGraphRevision ngr;
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            ngr = cache.get(uuid);
        } finally {
            lock.unlock();
            Thread.currentThread().setContextClassLoader(cl);
        }
        if (ngr != null) {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Got replica cache:{}:{}:{}:{}", new Object[] { uuid, ngr.namedGraphUri, ngr.revision, ngr.cache.size() });
            }
            handler.handleNamedGraph(ngr.namedGraphUri, ngr.uuid, ngr.revision);
            for (Statement stmt : ngr.cache) {
                boolean meta = false;
                if (!stmt.getNamedGraphUri().equals(ngr.namedGraphUri)) {
                    meta = true;
                }
                handler.handleStatement(meta, true, stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), stmt.getNamedGraphUri());
            }

            return true;
        } else {
            return false;
        }
    }

    /**
     * Update the
     * 
     * @param revision
     */
    public void cache(NamedGraphRevision revision) {
        lock.lock();
        try {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Caching:{}:{}:{}:{}", new Object[] { revision.uuid, revision.namedGraphUri, revision.revision, revision.cache.size() });
            }
            cache.put(revision.uuid, revision);
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
                for (URI uuid : transaction.getUpdatedNamedGraphs().values()) {
                    if (null != cache.remove(uuid)) {
                        if (log.isDebugEnabled())
                            log.debug(LogUtils.DATASOURCE_MARKER, "Invalidating Cache Entry:{}", new Object[] { uuid });
                    }
                }
                for (URI uuid : transaction.getRemovedNamedGraphs().values()) {
                    if (null != cache.remove(uuid)) {
                        if (log.isDebugEnabled())
                            log.debug(LogUtils.DATASOURCE_MARKER, "Invalidating Cache Entry:{}", new Object[] { uuid });
                    }
                }
            }
        } finally {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.TIMING_MARKER, "Replication CACHE UPDATE,{}", (System.currentTimeMillis() - start));
            }
            lock.unlock();
            Thread.currentThread().setContextClassLoader(cl);
        }
    }
}
