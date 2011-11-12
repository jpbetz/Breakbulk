/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 29, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.util.Collection;

import org.apache.commons.collections15.multimap.MultiHashMap;

/**
 * Extension of MultiHashMap to fix remove method
 * 
 * @param <K>
 *            Key type
 * @param <V>
 *            Value type
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class AnzoMultiMap<K, V> extends MultiHashMap<K, V> {

    private static final long serialVersionUID = -2198582438781952960L;

    /**
     * Create a new MultiHashMap
     */
    public AnzoMultiMap() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key, Object item) {
        Collection<V> valuesForKey = getCollection(key);
        if (valuesForKey == null) {
            return null;
        }
        boolean valueRemoved = valuesForKey.remove(item);

        // remove the list if it is now empty
        // (saves space, and allows equals to work)
        if (valuesForKey.isEmpty()) {
            remove(key);
        }
        return (valueRemoved) ? (V) item : null;
    }

}
