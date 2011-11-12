/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  May 6, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class AnzoCacheFactory implements ICacheProvider {
    @SuppressWarnings("unchecked")
    ConcurrentHashMap<String, SegmentedCache> caches = new ConcurrentHashMap<String, SegmentedCache>();

    Thread                                    reorgThread;

    boolean                                   closed = false;

    /**
     * New anzo cache factory
     */
    public AnzoCacheFactory() {
        reorgThread = new Thread("CacheReorgThread") {
            @Override
            @SuppressWarnings("unchecked")
            public void run() {
                while (!closed) {
                    for (SegmentedCache map : caches.values()) {
                        map.reorg();
                    }
                    try {
                        sleep(5000);
                    } catch (InterruptedException ie) {
                    }
                }
            }
        };
        reorgThread.setDaemon(true);
        reorgThread.start();
    }

    @SuppressWarnings("unchecked")
    public void close() {
        for (SegmentedCache map : caches.values()) {
            map.clear();
        }
        caches.clear();
        closed = true;
        reorgThread.interrupt();
    }

    public <K, V> ICache<K, V> openCache(String cacheName) {
        return openCache(cacheName, 1000, false);
    }

    @SuppressWarnings("unchecked")
    public <K, V> ICache<K, V> openCache(String cacheName, int maxElements, boolean overflowToDisk) {
        SegmentedCache<K, V> map = caches.get(cacheName);
        if (map == null) {
            map = new SegmentedCache<K, V>(cacheName, maxElements);
            caches.put(cacheName, map);
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    public void prune() {
        for (SegmentedCache map : caches.values()) {
            map.prune();
        }
    }
}
