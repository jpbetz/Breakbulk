/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.java.util/src/com/ibm/adtech/java/util/CompositeIterator.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: CompositeIterator.java 167 2007-07-31 14:11:13Z mroy $
 *  
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.util.Iterator;

/**
 * Combine 2 iterators into a composite iterator
 * 
 * @author Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * 
 * @param <T>
 *            Type of objects within the iterators
 */
public class CompositeIterator<T> implements Iterator<T> {

    private final Iterator<? extends T> it1;

    private final Iterator<? extends T> it2;

    /**
     * Create a composite of 2 iterators
     * 
     * @param it1
     *            First iterator
     * @param it2
     *            Second iterator
     */
    public CompositeIterator(Iterator<? extends T> it1, Iterator<? extends T> it2) {
        this.it1 = it1;
        this.it2 = it2;
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }

    public T next() {
        if (it1.hasNext())
            return it1.next();
        return it2.next();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

}
