/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.java.util/src/com/ibm/adtech/java/util/UpcastIterator.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: UpcastIterator.java 167 2007-07-31 14:11:13Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.util.Iterator;

/**
 * For an iterator of values that extend T, create a new iterator that provides T values
 * 
 * @author Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * 
 * @param <T>
 *            Type of objects itertor is to return
 */
public class UpcastIterator<T> implements Iterator<T> {

    private final Iterator<? extends T> source;

    /**
     * Create new Iterator
     * 
     * @param src
     *            Iterator of values that extend T
     */
    public UpcastIterator(Iterator<? extends T> src) {
        this.source = src;
    }

    public boolean hasNext() {
        return this.source.hasNext();
    }

    public T next() {
        return this.source.next();
    }

    public void remove() {
        this.source.remove();
    }
}
