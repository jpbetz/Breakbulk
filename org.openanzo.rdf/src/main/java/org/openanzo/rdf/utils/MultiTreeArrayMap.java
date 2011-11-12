/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 17, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A multiTreeMap that uses array lists for the collection storage
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 * @param <K>
 *            Key type
 * @param <V>
 *            Value Type
 */
public class MultiTreeArrayMap<K extends Comparable<?>, V extends Comparable<?>> extends MultiTreeMap<K, V> {
    private static final long serialVersionUID = -2816767764556768354L;

    @Override
    protected Collection<V> createCollection(Collection<? extends V> coll) {
        if (coll == null) {
            return new ArrayList<V>();
        } else {
            return new ArrayList<V>(coll);
        }
    }
}
