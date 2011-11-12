/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/NodeLayoutCacheProxy.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: NodeLayoutCacheProxy.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openanzo.cache.ICache;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Value;

/**
 * Wraps and caches the data accessed by a INodeLayout object. *
 * 
 * @param <T>
 *            Type of Value being stored
 * @author Joe Betz
 * @author Stephen Evanchik <evanchik@us.ibm.com>
 */
public class NodeLayoutCacheProxy<T extends Value> implements INodeLayout<T>, ILayoutCache<T> {

    private final INodeLayout<T>  base;

    private final ICache<Long, T> cache;

    private final ICache<T, Long> idCache;

    private final Map<Long, T>    uncommitedByIdCache;

    private final Map<T, Long>    uncommitedByNodeCache;

    /**
     * Create NodeLayoutCacheProxy for the given base layout.
     * 
     * @param base
     *            Base layout to add caching layer onto
     * @param byIdCache
     *            ID cache for this layout
     * @param byNodeCache
     *            Node cache for this layout
     */
    protected NodeLayoutCacheProxy(INodeLayout<T> base, ICache<Long, T> cache, ICache<T, Long> idCache) {
        this.base = base;
        this.cache = cache;
        this.idCache = idCache;
        uncommitedByIdCache = Collections.synchronizedMap(new HashMap<Long, T>());
        uncommitedByNodeCache = Collections.synchronizedMap(new HashMap<T, Long>());
    }

    private void clearUncommited() {
        uncommitedByIdCache.clear();
        uncommitedByNodeCache.clear();
    }

    public void clearCache() {
        clearUncommited();
    }

    private void addToCache(Long id, T n) {
        cache.put(id, n);
        idCache.put(n, id);
    }

    private void addToUncommitedCache(Long id, T n) {
        uncommitedByIdCache.put(id, n);
        uncommitedByNodeCache.put(n, id);
    }

    public T cache(Long id, String value, Long modifierId, Connection connection) throws RdbException {
        T node = base.convert(value, modifierId, connection);
        cache.put(id, node);
        idCache.put(node, id);
        return node;
    }

    public Long store(T n, Connection connection, long transactionId) throws RdbException {
        Long id = getIfCached(n);
        if (id != null) {
            return id;
        }
        id = base.store(n, connection, transactionId);
        addToUncommitedCache(id, n);
        return id;
    }

    public void commitUncommittedCache() {
        for (Map.Entry<T, Long> entry : uncommitedByNodeCache.entrySet()) {
            idCache.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Long, T> entry : uncommitedByIdCache.entrySet()) {
            cache.put(entry.getKey(), entry.getValue());
        }
        clearUncommited();
    }

    public void clearUncommittedCache() {
        uncommitedByNodeCache.clear();
        uncommitedByIdCache.clear();
    }

    public boolean isCached(T n) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            return uncommitedByNodeCache.containsKey(n) || idCache.get(n) != null;
        } finally {
            Thread.currentThread().setContextClassLoader(cl);
        }

    }

    public boolean isCached(Long id) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            return uncommitedByIdCache.containsKey(id) || cache.get(id) != null;
        } finally {
            Thread.currentThread().setContextClassLoader(cl);
        }
    }

    public Long getIfCached(T value) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            Long id = uncommitedByNodeCache.get(value);
            if (id == null) {
                id = idCache.get(value);
            }
            return id;
        } finally {
            Thread.currentThread().setContextClassLoader(cl);
        }
    }

    public T getIfCached(Long id) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            T obj = uncommitedByIdCache.get(id);
            if (obj == null) {
                obj = cache.get(id);
            }
            return obj;
        } finally {
            Thread.currentThread().setContextClassLoader(cl);
        }
    }

    public Long fetchId(T n, Connection connection) throws RdbException {
        Long id = getIfCached(n);
        if (id != null) {
            return id;
        }
        id = base.fetchId(n, connection);
        if (id != null)
            addToCache(id, n);
        return id;
    }

    public T fetchValue(Long id, Connection connection) throws RdbException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            T n = cache.get(id);
            if (n != null) {
                return n;
            }
            n = base.fetchValue(id, connection);
            if (n == null) {
                return null;
            }
            addToCache(id, n);
            return n;
        } finally {
            Thread.currentThread().setContextClassLoader(cl);
        }
    }

    public Map<T, Long> resolveStoredNodes(Collection<T> nodes, boolean storeUnresolvedNodes, Connection connection, long transactionId) throws RdbException {
        HashMap<T, Long> alreadyStored = new HashMap<T, Long>();
        Set<T> notSeen = new HashSet<T>();
        for (T node : nodes) {
            Long id = getIfCached(node);
            if (id != null) {
                alreadyStored.put(node, id);
            } else {
                notSeen.add(node);
            }
        }
        if (notSeen.size() > 0) {
            Map<T, Long> resolved = base.resolveStoredNodes(notSeen, storeUnresolvedNodes, connection, transactionId);
            for (Map.Entry<T, Long> entry : resolved.entrySet()) {
                addToUncommitedCache(entry.getValue(), entry.getKey());
            }
            alreadyStored.putAll(resolved);
        }
        return alreadyStored;
    }

    public Map<Long, T> resolveStoredIds(Set<Long> ids, Connection connection) throws RdbException {
        HashMap<Long, T> alreadyStored = new HashMap<Long, T>();
        Set<Long> notSeen = new HashSet<Long>();
        for (Long id : ids) {
            T value = getIfCached(id);
            if (value != null) {
                alreadyStored.put(id, value);
                addToCache(id, value);
            } else {
                notSeen.add(id);
            }
        }
        if (notSeen.size() > 0) {
            Map<Long, T> resolved = base.resolveStoredIds(notSeen, connection);
            for (Map.Entry<Long, T> entry : resolved.entrySet()) {
                addToUncommitedCache(entry.getKey(), entry.getValue());
            }
            alreadyStored.putAll(resolved);
        }
        return alreadyStored;
    }

    public NodeType getType() {
        return base.getType();
    }

    public T convert(String value, Long modifierId, Connection connection) throws RdbException {
        return base.convert(value, modifierId, connection);
    }

    public long abortReferencedIds(Connection connection, long transactionId) throws RdbException {
        return base.abortReferencedIds(connection, transactionId);
    }

    public long commitReferencedIds(Connection connection, long transactionId) throws RdbException {
        return base.commitReferencedIds(connection, transactionId);
    }

    public void setMaxLength(int length) {
        this.base.setMaxLength(length);
    }
}
