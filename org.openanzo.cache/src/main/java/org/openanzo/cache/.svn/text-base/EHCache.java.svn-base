/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 23, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.cache;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * @param <K>
 *            key type
 * @param <V>
 *            value type
 */
public class EHCache<K, V> implements ICache<K, V> {
    Cache                                     cache;

    CacheEventListener                        cacheListener;

    CopyOnWriteArraySet<ICacheListener<K, V>> listeners = new CopyOnWriteArraySet<ICacheListener<K, V>>();

    EHCache(Cache cache) {
        this.cache = cache;
        this.cacheListener = new CacheEventListener() {
            @Override
            public Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            public void notifyRemoveAll(Ehcache cache) {
            }

            @SuppressWarnings("unchecked")
            public void notifyElementUpdated(Ehcache cache, Element element) throws CacheException {
                if (cache.equals(EHCache.this.cache)) {
                    for (ICacheListener listener : listeners) {
                        listener.elementRemoved(element.getObjectKey(), element.getObjectValue());
                    }
                }
            }

            @SuppressWarnings("unchecked")
            public void notifyElementRemoved(Ehcache cache, Element element) throws CacheException {
                if (cache.equals(EHCache.this.cache)) {
                    for (ICacheListener listener : listeners) {
                        listener.elementRemoved(element.getObjectKey(), element.getObjectValue());
                    }
                }
            }

            public void notifyElementPut(Ehcache cache, Element element) throws CacheException {

            }

            @SuppressWarnings("unchecked")
            public void notifyElementExpired(Ehcache cache, Element element) {
                if (cache.equals(EHCache.this.cache)) {
                    for (ICacheListener listener : listeners) {
                        listener.elementRemoved(element.getObjectKey(), element.getObjectValue());
                    }
                }
            }

            @SuppressWarnings("unchecked")
            public void notifyElementEvicted(Ehcache cache, Element element) {
                if (cache.equals(EHCache.this.cache)) {
                    for (ICacheListener listener : listeners) {
                        listener.elementRemoved(element.getObjectKey(), element.getObjectValue());
                    }
                }
            }

            public void dispose() {
            }
        };
    }

    public void registerListener(ICacheListener<K, V> listener) {
        listeners.add(listener);
        if (listeners.size() == 1) {
            cache.getCacheEventNotificationService().registerListener(cacheListener);
        }
    }

    public void unregisterListener(ICacheListener<K, V> listener) {
        listeners.remove(listener);
        if (listeners.size() == 0) {
            cache.getCacheEventNotificationService().unregisterListener(cacheListener);
        }
    }

    public void clear() {
        cache.removeAll();
        cache.clearStatistics();
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        Element element = cache.get(key);
        if (element != null) {
            return (V) element.getValue();
        }
        return null;
    }

    public V put(K key, V value) {
        Element element = new Element(key, value);
        cache.put(element);
        return value;
    }

    public V remove(K key) {
        cache.remove(key);
        return null;
    }

    @SuppressWarnings("unchecked")
    public Set<K> keySet() {
        return new HashSet<K>(cache.getKeys());
    }

}
