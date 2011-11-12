/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 15, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.cache;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface ICacheProvider {
    /**
     * Open a cache for the given name using default settings
     * 
     * @param <K>
     *            Key type
     * @param <V>
     *            Value type
     * 
     * @param cacheName
     *            name of the cache to open
     * @return the ICache for the given name
     */
    public <K, V> ICache<K, V> openCache(String cacheName);

    /**
     * Open a cache for the given name
     * 
     * @param <K>
     *            Key type
     * @param <V>
     *            Value type
     * @param cacheName
     *            name of the cache to open
     * @param maxElements
     *            max elements to keep in memory
     * @param overflowToDisk
     *            overflow memory elements to disk if over maxElements
     * @return the ICache for the given name
     */
    public <K, V> ICache<K, V> openCache(String cacheName, int maxElements, boolean overflowToDisk);

    /**
     * Close the cache providers
     */
    public void close();

    /**
     * Prune the cache provider
     * 
     */
    public void prune();
}
