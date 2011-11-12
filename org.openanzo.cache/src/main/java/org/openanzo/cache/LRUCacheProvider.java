/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 29, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.cache;

import java.util.HashMap;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class LRUCacheProvider implements ICacheProvider {

    public void close() {
        lruCaches.clear();
    }

    @SuppressWarnings("unchecked")
    HashMap<String, LRUCache> lruCaches = new HashMap<String, LRUCache>();

    public <K, V> ICache<K, V> openCache(String cacheName) {
        return openCache(cacheName, 1000, false);

    }

    @SuppressWarnings("unchecked")
    public <K, V> ICache<K, V> openCache(String cacheName, int maxElements, boolean overflowToDisk) {
        LRUCache<K, V> cache = lruCaches.get(cacheName);
        if (cache == null) {
            cache = new LRUCache<K, V>(maxElements);
            lruCaches.put(cacheName, cache);
        }
        return cache;
    }

    public void prune() {
    }
}
