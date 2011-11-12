/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 6, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.util.Collection;
import java.util.HashSet;

/**
 * MultiHashMap that uses a CopyOnWriteArrayList as the collection
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 * @param <K>
 *            Key type
 * @param <V>
 *            Value type
 */
public class HashSetMultiHashMap<K, V> extends AnzoMultiMap<K, V> {

    /**
     * 
     */
    private static final long serialVersionUID = -7611472185268492630L;

    /**
     * 
     */
    public HashSetMultiHashMap() {
        super();
    }

    /**
     * @param initialCapacity
     * @param loadFactor
     *            public HashSetMultiHashMap(int initialCapacity, float loadFactor) { super(initialCapacity, loadFactor); }
     */
    /**
     * @param initialCapacity
     *            public HashSetMultiHashMap(int initialCapacity) { super(initialCapacity); }
     */
    /**
     * @param mapToCopy
     *            public HashSetMultiHashMap(Map<K, V> mapToCopy) { super(mapToCopy); }
     */
    /**
     * @param mapToCopy
     *            public HashSetMultiHashMap(MultiMap<K, V> mapToCopy) { super(mapToCopy);
     * 
     *            }
     */
    @Override
    protected Collection<V> createCollection(Collection<? extends V> coll) {
        if (coll == null) {
            return new HashSet<V>();
        } else {
            return new HashSet<V>(coll);
        }
    }
}
