/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/OrderingCondition.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: OrderingCondition.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;

import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * A single ordering condition in an <tt>ORDER BY</tt> clause of a query. This can be any expression paired with either ascending or descending order. The
 * expression is evaluated against pairs of solutions A and B. If the expression evaluates to &lt; 0, then A comes first; if &gt; 0 then B comes first.
 * Otherwise, the results according to this {@link OrderingCondition} are undefined.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class OrderingCondition implements QueryPart {
    private final boolean    ascending;

    private final Expression condition;

    /**
     *
     * @param condition
     *            How to sort solutions.
     * @param ascending
     *            Whether the sort order should be ascending (<tt>true</tt>) or descending (<tt>false</tt>)
     */
    public OrderingCondition(Expression condition, boolean ascending) {
        this.condition = condition;
        this.ascending = ascending;
    }

    /**
     *
     * @return The expression giving the ordering condition.
     */
    public Expression getCondition() {
        return this.condition;
    }

    /**
     *
     * @return Whether this {@link OrderingCondition} sorts ascending or not (descending).
     */
    public boolean isAscending() {
        return this.ascending;
    }

    @Override
    public String toString() {
        return (isAscending() ? "ASC(" : "DESC(") + this.condition.toString() + ")";
    }

    public Collection<Variable> getBindableVariables() {
        return Collections.emptyList();
    }

    public Collection<URI> getReferencedURIs() {
        return this.condition.getReferencedURIs();
    }

    public Collection<Variable> getReferencedVariables() {
        return this.condition.getReferencedVariables();
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        if (!this.ascending)
            s.append("DESC(");
        this.condition.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
        if (!this.ascending)
            s.append(")");
    }
}
