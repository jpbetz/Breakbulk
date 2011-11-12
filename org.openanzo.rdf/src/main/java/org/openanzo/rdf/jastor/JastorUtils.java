/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 16, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.jastor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.vocabulary.DC;

/**
 * Utility methods that relate to Jastor Objects
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
public class JastorUtils {
    /**
     * For a Resource, use toString(). For a Literal, return the getLabel() value.
     * 
     * @param value
     *            value to format
     * @return String representation of value
     */
    public static String getStingValue(Value value) {
        if (value == null)
            return null;
        if (value instanceof Literal) {
            return ((Literal) value).getLabel();
        }
        return value.toString();
    }

    /** Comparator to sort objects by their DC.TITLE */
    static class TitleComparator implements Comparator<Thing> {
        public int compare(Thing o1, Thing o2) {
            Value title1 = o1.getPropertyValue(DC.TITLE);
            Value title2 = o2.getPropertyValue(DC.TITLE);
            if (title1 != null && title2 != null) {
                return title1.toString().compareTo(title2.toString());
            } else if (title1 != null) {
                return -1;
            } else if (title2 != null) {
                return 1;
            } else {
                return o1.resource().toString().compareTo(o2.resource().toString());
            }
        }
    }

    private static final TitleComparator titleComparator = new TitleComparator();

    /**
     * Sort a set of Things based on their titles
     * 
     * @param <T>
     *            Type of Things to sort
     * @param values
     *            Set of things to sort
     * @return Iterator over sorted set
     */
    public static <T extends Thing> Collection<T> sortByTitle(Iterable<T> values) {
        ArrayList<T> set = new ArrayList<T>();
        org.openanzo.rdf.utils.Collections.addAll(values, set);
        Collections.sort(set, titleComparator);
        return set;
    }
}
