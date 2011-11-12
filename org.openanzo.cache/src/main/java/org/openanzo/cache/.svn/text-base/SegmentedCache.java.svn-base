/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  May 7, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * @param <K>
 *            Type of key
 * @param <V>
 *            Tyoe of values
 * 
 */
public class SegmentedCache<K, V> implements ICache<K, V> {
    SoftReference<SpecialHashMap>             softCacheLink;

    CopyOnWriteArraySet<ICacheListener<K, V>> listeners        = new CopyOnWriteArraySet<ICacheListener<K, V>>();

    LinkedList<SpecialHashMap>                stack            = new LinkedList<SpecialHashMap>();

    int                                       maxSize          = 0;

    private final int                         numberOfSegments = 3;

    final Object                              lock             = new Object();

    long                                      lastModCount     = 0;

    @SuppressWarnings("unused")
    private final String                      cacheName;

    SegmentedCache(String cacheName, int maxSize) {
        this.cacheName = cacheName;
        this.maxSize = maxSize;
        softCacheLink = createSoftReference(null);
    }

    private SoftReference<SpecialHashMap> createSoftReference(SpecialHashMap map) {
        if (map == null) {
            map = new SpecialHashMap();
        }
        return new SoftReference<SpecialHashMap>(map);
    }

    public void clear() {
        synchronized (lock) {
            stack.clear();
            if (softCacheLink.get() == null) {
                softCacheLink = createSoftReference(null);
                return;
            } else {
                softCacheLink.get().clear();
            }
            lastModCount = 0;
        }
    }

    void prune() {
        lastModCount++;
        synchronized (lock) {
            SpecialHashMap map = softCacheLink.get();
            if (map != null) {
                if (map.size() > 0) {
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        for (ICacheListener<K, V> listener : listeners) {
                            listener.elementRemoved(entry.getKey(), entry.getValue());
                        }
                    }
                }
                map.clear();
            }
            softCacheLink = createSoftReference(stack.size() > 0 ? stack.removeLast() : null);
        }
    }

    void reorg() {
        if (lastModCount > maxSize / ((numberOfSegments + 1) * 2)) {
            synchronized (lock) {
                if (softCacheLink.get() != null) {
                    SpecialHashMap map = softCacheLink.get();
                    int needsMore = (maxSize / (numberOfSegments + 1)) - map.size();
                    if (needsMore > 0 && stack.size() > 0) {
                        SpecialHashMap lastMap = stack.getLast();
                        while (lastMap != null && needsMore > 0) {
                            for (Iterator<Map.Entry<K, V>> iterator = lastMap.entrySet().iterator(); needsMore-- > 0 && iterator.hasNext();) {
                                Map.Entry<K, V> entry = iterator.next();
                                map.put(entry.getKey(), entry.getValue());
                                iterator.remove();
                            }
                            if (lastMap.size() == 0) {
                                stack.removeLast();
                            }
                            lastMap = stack.getLast();
                        }
                    }
                }
                lastModCount = 0;
            }
        }
    }

    public V get(K key) {
        synchronized (lock) {
            if (stack.size() > 0) {
                for (HashMap<K, V> map : stack) {
                    V v = map.get(key);
                    if (v != null) {
                        if (map != stack.getFirst()) {
                            map.remove(key);
                            stack.getFirst().put(key, v);
                        }
                        return v;
                    }
                }
            }
            if (softCacheLink.get() == null) {
                softCacheLink = createSoftReference(stack.size() > 0 ? stack.removeLast() : null);
                return null;
            }
            return softCacheLink.get().get(key);
        }
    }

    public V remove(K key) {
        lastModCount++;
        synchronized (lock) {
            if (stack.size() > 0) {
                HashMap<K, V> mapToRemove = null;
                try {
                    for (HashMap<K, V> map : stack) {
                        V v = map.remove(key);
                        if (v != null) {
                            if (map.size() == 0) {
                                mapToRemove = map;
                            }
                            return v;
                        }
                    }
                } finally {
                    if (mapToRemove != null) {
                        stack.remove(mapToRemove);
                    }
                }
            }
            if (softCacheLink.get() == null) {
                softCacheLink = createSoftReference(stack.size() > 0 ? stack.removeLast() : null);
                return null;
            }
            V v = softCacheLink.get().remove(key);
            if (v != null) {
                if (softCacheLink.get().size() == 0 && stack.size() > 0) {
                    softCacheLink = createSoftReference(stack.removeLast());
                }
            }
            return v;
        }
    }

    public Set<K> keySet() {
        synchronized (lock) {
            HashSet<K> keys = new HashSet<K>();
            for (HashMap<K, V> map : stack) {
                keys.addAll(map.keySet());
            }

            if (softCacheLink.get() == null) {
                softCacheLink = createSoftReference(stack.size() > 0 ? stack.removeLast() : null);
            } else {
                keys.addAll(softCacheLink.get().keySet());
            }
            return keys;
        }
    }

    public V put(K key, V value) {
        lastModCount++;
        synchronized (lock) {
            remove(key);
            if (stack.size() > 0) {
                SpecialHashMap map = stack.getFirst();
                if (map.size() > (maxSize / (numberOfSegments + 1))) {
                    map = new SpecialHashMap();
                    stack.push(map);
                    if (stack.size() > numberOfSegments) {
                        softCacheLink = createSoftReference(stack.removeLast());
                    }
                }
                if (softCacheLink.get() == null) {
                    softCacheLink = createSoftReference(stack.size() > 0 ? stack.removeLast() : null);
                }
                return map.put(key, value);
            } else {
                if (softCacheLink.get() == null) {
                    softCacheLink = createSoftReference(null);
                }
                return softCacheLink.get().put(key, value);
            }
        }
    }

    public void registerListener(ICacheListener<K, V> listener) {
        listeners.add(listener);
    }

    public void unregisterListener(ICacheListener<K, V> listener) {
        listeners.remove(listener);
    }

    class SpecialHashMap extends HashMap<K, V> {
        private static final long serialVersionUID = 72943522689159363L;

        @Override
        protected void finalize() throws Throwable {
            if (size() > 0) {
                for (Map.Entry<K, V> entry : entrySet()) {
                    for (ICacheListener<K, V> listener : listeners) {
                        listener.elementRemoved(entry.getKey(), entry.getValue());
                    }
                }
            }
            super.finalize();
        }
    }
}
