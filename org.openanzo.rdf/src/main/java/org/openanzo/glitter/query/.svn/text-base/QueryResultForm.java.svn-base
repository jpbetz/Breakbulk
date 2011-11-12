/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/QueryResultForm.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: QueryResultForm.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.List;

import org.openanzo.rdf.utils.PrettyPrintable;

/**
 * A {@link QueryResultForm} represents the form of results returned for a particular {@link QueryType}.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public interface QueryResultForm extends PrettyPrintable, QueryPart {
    /**
     * Result forms are given a chance to apply solution modifiers to the solution set before transforming the results. (For example, {@link Projection} might
     * apply <tt>DISTINCT</tt> here.
     *
     * @param solutions
     *            The original solution set
     * @return The (possibly) modified solution set
     */
    public abstract SolutionSet refineSolutionsBeforeOrdering(SolutionSet solutions);

    /**
     * Result forms are given a chance to apply solution modifiers to the solution set before transforming the results. (For example, {@link Projection} might
     * apply <tt>DISTINCT</tt> here.
     *
     * @param solutions
     *            The original solution set
     * @param solutionsAreSorted
     *            True if the solution set passed in is sorted
     * @return The (possibly) modified solution set
     */
    public abstract SolutionSet refineSolutionsAfterOrdering(SolutionSet solutions, List<OrderingCondition> sortedByConditions);

    /**
     *
     * @param results
     *            The solution set after all solution modified have been applied.
     * @return A form of the solution set specific to this {@link QueryResultForm}.
     */
    public abstract Object serializeResults(SolutionSet results);
}
