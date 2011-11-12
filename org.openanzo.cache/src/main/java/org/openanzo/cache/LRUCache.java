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

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.commons.collections15.map.LRUMap;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * @param <K>
 *            key type
 * @param <V>
 *            value type
 */
public class LRUCache<K, V> implements ICache<K, V> {

    LRUMap<K, V> map = null;

    LRUCache(int maxSize) {
        map = new LRUMap<K, V>(maxSize) {

            private static final long serialVersionUID = -4014149744440579768L;

            @Override
            protected boolean removeLRU(org.apache.commons.collections15.map.AbstractLinkedMap.LinkEntry<K, V> entry) {
                for (ICacheListener<K, V> listener : listeners) {
                    listener.elementRemoved(entry.getKey(), entry.getValue());
                }
                return super.removeLRU(entry);
            }

        };
    }

    CopyOnWriteArraySet<ICacheListener<K, V>> listeners = new CopyOnWriteArraySet<ICacheListener<K, V>>();

    public void clear() {
        map.clear();
    }

    public V get(K key) {
        return map.get(key);
    }

    public V put(K key, V value) {
        return map.put(key, value);
    }

    public V remove(K key) {
        return map.remove(key);
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    public void registerListener(ICacheListener<K, V> listener) {
        listeners.add(listener);
    }

    public void unregisterListener(ICacheListener<K, V> listener) {
        listeners.remove(listener);
    }
}
