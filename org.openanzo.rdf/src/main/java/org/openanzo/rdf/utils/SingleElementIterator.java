/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.java.util/src/com/ibm/adtech/java/util/SingleElementIterator.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: SingleElementIterator.java 167 2007-07-31 14:11:13Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for single values
 * 
 * @author Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * @param <T>
 *            Type of value within the iterator
 */
public class SingleElementIterator<T> implements Iterator<T> {

    private final T element;

    private boolean done;

    /**
     * Create an Iterator for a single value
     * 
     * @param element
     *            element to provide via iterate
     */
    public SingleElementIterator(T element) {
        this.element = element;
        done = false;
    }

    public boolean hasNext() {
        return !done;
    }

    public T next() {
        if (done)
            throw new NoSuchElementException();
        done = true;
        return element;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
