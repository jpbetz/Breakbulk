/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/QueryInformation.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: QueryInformation.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.List;

import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.rdf.URI;

/**
 * Provides read-only access to basic query information.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public interface QueryInformation {
    /**
     * 
     * @return The base URI as given by the <tt>BASE</tt> keyword.
     */
    public abstract URI getBaseUri();

    /**
     * 
     * @return The solution limit as given by the <tt>LIMIT</tt> keyword.
     */
    public abstract int getLimit();

    /**
     * 
     * @return The solution sequence offset as given by the <tt>OFFSET</tt> keyword.
     */
    public abstract int getOffset();

    /**
     * 
     * @return The sort conditions as given by the <tt>ORDER BY</tt> clause.
     */
    public abstract List<OrderingCondition> getOrderingConditions();

    /**
     * 
     * @return The result form of the query (SELECT, ASK, or CONSTRUCT)
     */
    public abstract QueryResultForm getQueryResultForm();

    /**
     * @param includeFromClauses
     *            don't include the from clauses
     * @return The original query string.
     */
    public abstract String getQueryString(boolean includeFromClauses);

    /**
     * @return An enumeration denoting the type of query (SELECT, ASK, or CONSTRUCT)
     */
    public abstract QueryType getQueryType();

    /**
     * 
     * @return The root node in the query's abstract syntax tree.
     */
    public abstract GraphPattern getQueryPattern();

    /**
     * 
     * @return The query's backend solution generator.
     */
    public abstract SolutionGenerator getSolutionGenerator();
}
