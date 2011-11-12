/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/Expression.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Expression.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryPart;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.PrettyPrintable;

/**
 * {@link Expression} represents SPARQL expressions. These can appear in several places in a query:
 * <ul>
 * <li>Within a FILTER or ORDER BY clause.</li>
 * <li>Within a SELECT clause or CONSTRUCT template</li>
 * </ol>
 * Expressions
 * can be evaluated in an environment can be evaluated against a {@link PatternSolution} (to look up the
 * values of {@link Bindable}s and, optionally, a {@link SolutionSet} (to denote an active group for calculating
 * aggregate values.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public interface Expression extends PrettyPrintable, QueryPart {

    /**
     *
     * @param solution
     *            A set of bindings to use to evaluate {@link Bindable} objects in the expression.
     * @param group
     *            A set of solutions representing a group (as from GROUP BY) of solutions to use in
     *            evaluating an aggregate. May be null if the expression is known not to reference any
     *            aggregates.
     * @return The {@link Value} that is the value of evaluating this expression.
     * @throws ExpressionEvaluationException
     *             If there is an error (e.g. a type error) in evaluating this expression.
     */
    public abstract Value evaluate(PatternSolution solution, SolutionSet group) throws ExpressionEvaluationException;
}
