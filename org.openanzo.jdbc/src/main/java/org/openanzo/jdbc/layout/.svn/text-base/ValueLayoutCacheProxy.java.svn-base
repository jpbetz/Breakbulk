/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/ValueLayoutCacheProxy.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: ValueLayoutCacheProxy.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     C Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openanzo.cache.ICache;
import org.openanzo.jdbc.container.sql.NodeSQL.FetchAllCommonValuesResult;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.IteratorUtils;
import org.openanzo.jdbc.utils.RdbException;

/**
 * Wraps and caches data accessed by an IValueLayout object.
 * 
 * @author Joe Betz
 * @author Stephen Evanchik <evanchik@us.ibm.com>
 */
public class ValueLayoutCacheProxy implements IValueLayout, ILayoutCache<String> {
    private final IValueLayout         base;

    private final ICache<Long, String> cache;

    private final ICache<String, Long> idCache;

    private final Map<Long, String>    uncommitedByIdCache;

    private final Map<String, Long>    uncommitedByValueCache;

    /**
     * Create Cache Proxy for the given base layout.
     * 
     * @param base
     *            Base layout to add caching layer onto
     * @param byIdCache
     *            ID cache for this layout
     * @param byValueCache
     *            Value cache for this layout
     */
    protected ValueLayoutCacheProxy(IValueLayout base, ICache<Long, String> cache, ICache<String, Long> idCache) {
        this.base = base;
        this.cache = cache;
        this.idCache = idCache;
        uncommitedByIdCache = Collections.synchronizedMap(new HashMap<Long, String>());
        uncommitedByValueCache = Collections.synchronizedMap(new HashMap<String, Long>());
    }

    public void clearCache() {
        cache.clear();
        idCache.clear();
        uncommitedByIdCache.clear();
        uncommitedByValueCache.clear();
    }

    public void commitUncommittedCache() {
        for (Map.Entry<String, Long> entry : uncommitedByValueCache.entrySet()) {
            idCache.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Long, String> entry : uncommitedByIdCache.entrySet()) {
            cache.put(entry.getKey(), entry.getValue());
        }
        uncommitedByValueCache.clear();
        uncommitedByIdCache.clear();
    }

    public void clearUncommittedCache() {
        uncommitedByValueCache.clear();
        uncommitedByIdCache.clear();
    }

    void addToCache(Long id, String value) {
        uncommitedByIdCache.put(id, value);
        uncommitedByValueCache.put(value, id);
    }

    public String cache(Long id, String value, Long modifierId, Connection connection) {
        return null;
    }

    public boolean isCached(String value) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            return uncommitedByValueCache.containsKey(value) || idCache.get(value) != null;
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

    public Long getIfCached(String value) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            Long id = uncommitedByValueCache.get(value);
            if (id == null) {
                id = idCache.get(value);
            }
            return id;
        } finally {
            Thread.currentThread().setContextClassLoader(cl);
        }
    }

    public String getIfCached(Long id) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        try {
            String obj = uncommitedByIdCache.get(id);
            if (obj == null) {
                obj = cache.get(id);
            }
            return obj;
        } finally {
            Thread.currentThread().setContextClassLoader(cl);
        }
    }

    public Long fetchId(String value, Connection connection) throws RdbException {
        Long id = getIfCached(value);
        if (id != null) {
            return id;
        }
        id = base.fetchId(value, connection);
        if (id == null) {
            return null;
        }
        addToCache(id, value);
        return id;
    }

    public String fetchValue(Long id, Connection connection) throws RdbException {
        String value = getIfCached(id);
        if (value != null) {
            return value;
        }
        value = base.fetchValue(id, connection);
        if (value == null) {
            return null;
        }
        addToCache(id, value);
        return value;
    }

    public Long store(String value, Connection connection) throws RdbException {
        Long id = getIfCached(value);
        if (id != null) {
            return id;
        }
        id = base.store(value, connection);
        addToCache(id, value);
        return id;
    }

    /**
     * Doesn't cached added nodes
     */
    public void batchAdd(Collection<String> iter, Connection connection) throws RdbException {
        base.batchAdd(iter, connection);
    }

    /**
     * Doesn't cache fetched Nodes
     */
    public ClosableIterator<FetchAllCommonValuesResult> fetchAll(Connection connection) throws RdbException {
        return base.fetchAll(connection);
    }

    /**
     * Add set of strings into this layout and cache their values
     * 
     * @param connection
     *            connection to jdbc database to which data is added
     * @param iter
     *            set of strings to store and cache
     * @throws RdbException
     */
    public void batchAddAndCache(Collection<String> iter, Connection connection) throws RdbException {
        base.batchAdd(iter, connection);
        ClosableIterator<FetchAllCommonValuesResult> cIter = base.fetchAll(connection);
        try {
            while (cIter.hasNext()) {
                FetchAllCommonValuesResult result = cIter.next();
                String value = result.getValue();
                Long id = Long.valueOf(result.getId());
                addToCache(id, value);
            }
        } finally {
            IteratorUtils.close(cIter);
        }
    }
}
