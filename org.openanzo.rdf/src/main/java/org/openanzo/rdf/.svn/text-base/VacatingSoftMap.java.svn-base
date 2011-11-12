/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 24, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class VacatingSoftMap<K, V> {

    private WeakHashMap<K, WeakReference<V>> map = new WeakHashMap<K, WeakReference<V>>();

    public V get(K key) {
        WeakReference<V> ref = map.get(key);
        if (ref != null) {
            V value = ref.get();
            if (value == null) {
                remove(key);
            }
            return value;
        }
        return null;
    }

    public V put(K key, V value) {
        map.put(key, new WeakReference<V>(value));
        return value;
    }

    public boolean remove(K key) {
        return map.remove(key) != null;
    }

    public void clear() {
        map.clear();
    }
}
