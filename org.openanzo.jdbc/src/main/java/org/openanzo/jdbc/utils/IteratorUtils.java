/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/IteratorUtils.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: IteratorUtils.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.utils;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.iterators.CollatingIterator;
import org.apache.commons.collections.iterators.FilterIterator;
import org.apache.commons.collections.iterators.IteratorChain;
import org.apache.commons.collections.iterators.TransformIterator;

/**
 * Convenience methods for working with iterators.
 * 
 * @author Joe Betz
 * 
 */
public class IteratorUtils {
    /**
     * Makes a best effort to close any closable iterator. Can close iterators nested in IteratorChain, TransformIterator, FilterIterator and CollatingIterator
     * instances.
     * 
     * @param iterator
     *            The iterator to close.
     */
    public static void close(Iterator<?> iterator) {
        if (iterator == null)
            return;
        // obvious case
        if (iterator instanceof ClosableIterator<?>) {
            ((ClosableIterator<?>) iterator).close();
        }
        // now check for all cases we know of where iterators can be nested..
        else if (iterator instanceof IteratorChain) {
            IteratorChain chain = (IteratorChain) iterator;

            @SuppressWarnings("unchecked")
            // marshal from apache commons collections
            List<Iterator<?>> iterators = chain.getIterators();

            for (Iterator<?> iteratorElement : iterators) {
                close(iteratorElement);
            }
        } else if (iterator instanceof TransformIterator) {
            TransformIterator trans = (TransformIterator) iterator;
            close(trans.getIterator());
        } else if (iterator instanceof FilterIterator) {
            FilterIterator filter = (FilterIterator) iterator;
            close(filter.getIterator());
        } else if (iterator instanceof CollatingIterator) {
            CollatingIterator iter = (CollatingIterator) iterator;

            @SuppressWarnings("unchecked")
            // marshal from apache commons collections
            List<Iterator<?>> iterators = iter.getIterators();

            for (Iterator<?> iteratorElement : iterators) {
                close(iteratorElement);
            }
        }
    }
}
