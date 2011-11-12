/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/SolutionSorter.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: SolutionSorter.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.expression.ScalarFunctionBase;
import org.openanzo.glitter.expression.ScalarFunctionBase.ComparisonResult;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.ValueMax;
import org.openanzo.rdf.ValueMin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sorts solutions according to a given list of {@link OrderingCondition}s.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class SolutionSorter implements Comparator<PatternSolution> {
    private static final Logger           log = LoggerFactory.getLogger(SolutionSorter.class);

    private final List<OrderingCondition> conditions;

    /**
     * Constructor.
     * 
     * @param conditions
     */
    public SolutionSorter(List<OrderingCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Compares two solutions by evaluating the ordering expressions in the context of the two solutions. The SPARQL specification defines rules for comparing
     * various pairs of RDF term values to derive a proper ordering.
     */
    public int compare(PatternSolution c1, PatternSolution c2) {
        int cmp = 0;
        for (OrderingCondition condition : this.conditions) {
            Value v1 = c1.getCondition(condition);
            if (v1 == null) {
                v1 = c1.setCondition(condition, condition.getCondition().evaluate(c1, null));
            }
            Value v2 = c2.getCondition(condition);
            if (v2 == null) {
                v2 = c2.setCondition(condition, condition.getCondition().evaluate(c2, null));
            }
            int sign = condition.isAscending() ? 1 : -1;
            int v1First = -1 * sign;
            int v2First = 1 * sign;

            if (v1 instanceof ValueMin || v2 instanceof ValueMin) {
                if (!(v1 instanceof ValueMin))
                    return v2First;
                if (!(v2 instanceof ValueMin))
                    return v1First;
                continue;
            }

            if (v1 instanceof ValueMax || v2 instanceof ValueMax) {
                if (!(v1 instanceof ValueMax))
                    return v1First;
                if (!(v2 instanceof ValueMax))
                    return v2First;
                continue;
            }

            // if one is unbound, then that comes first
            if (v1 == null || v2 == null) {
                if (v2 != null)
                    return v1First;
                else if (v1 != null)
                    return v2First;
                else
                    continue; // try next condition
            }
            if (v1.equals(v2)) {
                continue;
            }
            // blank nodes come next; if both are blank nodes, we have no way of distinguishing
            if (v1 instanceof BlankNode || v2 instanceof BlankNode) {
                if (!(v2 instanceof BlankNode))
                    return v1First;
                else if (!(v1 instanceof BlankNode))
                    return v2First;
                else
                    continue;
            }
            // next come IRIs, which get sorted by character strings
            if (v1 instanceof URI || v2 instanceof URI) {
                if (!(v2 instanceof URI))
                    return v1First;
                else if (!(v1 instanceof URI))
                    return v2First;
                cmp = v1.toString().compareTo(v2.toString());
                if (cmp != 0)
                    return cmp * sign;
                else
                    continue;
            }
            // next are RDF literals - we can compare whatever our function base class can compare
            if (v1 instanceof Literal || v2 instanceof Literal) {
                if (!(v2 instanceof Literal))
                    return v1First;
                if (!(v1 instanceof Literal))
                    return v2First;

                List<Value> values = new ArrayList<Value>();
                values.add(v1);
                values.add(v2);
                try {
                    ComparisonResult cr = ScalarFunctionBase.compareLiteralValues(v1, v2);
                    if (cr == ComparisonResult.LESSER)
                        return -sign;
                    else if (cr == ComparisonResult.GREATER)
                        return sign;
                } catch (ExpressionEvaluationException e) {
                    log.trace(LogUtils.GLITTER_MARKER, "No valid comparison in ORDER BY: " + e);
                }

                // otherwise, these two do not compare well or compare as equal, so pass to the
                // next test
                continue;
            }
        }
        // if we haven't differentiated the two solutions yet, they must
        // be equal in our eyes
        return 0;
    }

}
