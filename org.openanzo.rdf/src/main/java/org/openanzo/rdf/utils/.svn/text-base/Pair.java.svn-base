/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.java.util/src/com/ibm/adtech/java/util/Pair.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: Pair.java 167 2007-07-31 14:11:13Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.utils;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 2 Item list
 * 
 * @author Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * 
 * @param <F>
 *            Type of first object
 * @param <S>
 *            Type of second object
 */
public class Pair<F, S> {

    /** First element of pair */
    final public F first;

    /** Second element of pair */
    public S       second;

    /**
     * Create a new pair
     * 
     * @param f
     *            First element of pair
     * @param s
     *            Second element of pair
     */
    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(first);
        builder.append(second);
        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair<?, ?>))
            return false;
        Pair<?, ?> other = (Pair<?, ?>) obj;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(first, other.first);
        builder.append(second, other.second);
        return builder.isEquals();
    }

    @Override
    public String toString() {
        return (new ToStringBuilder(this)).append(first).append(second).toString();
    }
}
