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

/**
 * @param <K>
 *            key type
 * @param <V>
 *            value type
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface ICache<K, V> {
    /**
     * Retrieve the value from the cache based on key
     * 
     * @param key
     *            key of value to return
     * @return value for key
     */
    public V get(K key);

    /**
     * Cache the value based on the key
     * 
     * @param key
     *            key of value to cache
     * @param value
     *            value to store
     * @return V old value
     */
    public V put(K key, V value);

    /**
     * Remove an entry from the cache
     * 
     * @param key
     *            key of entry to remove
     * @return true if entry was removed
     */
    public V remove(K key);

    /**
     * Clear the cache
     */
    public void clear();

    /**
     * Get the keys of stored values in the cache
     * 
     * @return Collection of the keys stored
     */
    public Set<K> keySet();

    /**
     * Register a cache listener
     * 
     * @param listener
     *            cache listener
     */
    public void registerListener(ICacheListener<K, V> listener);

    /**
     * Unregister a cache listener
     * 
     * @param listener
     *            cache listener
     */
    public void unregisterListener(ICacheListener<K, V> listener);
}
