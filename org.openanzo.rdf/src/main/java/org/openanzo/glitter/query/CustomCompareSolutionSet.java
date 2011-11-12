/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.Comparator;

import org.openanzo.rdf.Value;

/**
 * Custom comparison solution set
 */
public interface CustomCompareSolutionSet extends SolutionSet {
    /**
     * Get the custom comparator
     * 
     * @return custom comparator
     */
    public Comparator<Value> getComparator();

    /**
     * Lexical comparator
     */
    public static final Comparator<Value> LEXICAL_COMPARATOR = new Comparator<Value>() {
                                                                 public int compare(Value o1, Value o2) {
                                                                     return o1.compareTo(o2);
                                                                 }
                                                             };

    /**
     * A comparison solution list
     */
    public static class ComparableSolutionList extends SolutionList implements CustomCompareSolutionSet {
        static final long               serialVersionUID = -2572513139616640123L;

        private final Comparator<Value> comparator;

        protected ComparableSolutionList(Comparator<Value> comparator) {
            this.comparator = comparator;
        }

        public Comparator<Value> getComparator() {
            return comparator;
        }

    }
}
