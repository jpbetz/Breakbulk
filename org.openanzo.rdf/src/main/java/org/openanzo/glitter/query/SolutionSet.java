/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/SolutionSet.java,v $
 * Created by: Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on: Nov 25, 2006
 * Revision: $Id: SolutionSet.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.io.Serializable;
import java.util.List;

import org.openanzo.rdf.Bindable;

/**
 * A {@link SolutionSet} is a query result set; it is an ordered sequence of solutions.
 * 
 * @author lee
 * 
 */
public interface SolutionSet extends List<PatternSolution>, Serializable {
    /**
     * Returns a selected range of solutions from the {@link SolutionSet}
     * 
     * @param startInclusive
     *            The returned range starts at the given index (zero-indexed).
     * @param endExclusive
     *            The returned range contains all of the solutions <i>before</i> <tt>endExclusive</tt>
     * @return A sliced solution set
     */
    public SolutionSet slice(int startInclusive, int endExclusive);

    /**
     * Get the bindings within this solution set
     * 
     * @return the bindings within this solution set
     */
    public List<Bindable> getBindings();

    /**
     * Get the names of all the bindings within this solution set
     * 
     * @return the names of all the bindings within this solution set
     */
    public List<String> getBindingNames();
}
