/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/FunctionOnTerms.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: FunctionOnTerms.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.rdf.Value;

/**
 * Interface for {@link Function}s that return <tt>false</tt> for {@link ScalarFunction#operatesOnValues()}. These functions are supplied with a list of
 * {@link Expression}s and the current environment in which those expressions should be considered.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public interface ScalarFunctionOnTerms extends ScalarFunction {
    /**
     * Invokes the function and determines a return value.
     * 
     * @param arguments
     *            The (unevaluated) expressions that are passed to the function in the query.
     * @param environment
     *            The current solution being evaluated against
     * @return The result of evaluating this function against the arguments in the given environment
     * @throws ExpressionEvaluationException
     *             For invalid types, or other expression evalutaion problems
     */
    public Value call(List<Expression> arguments, PatternSolution environment) throws ExpressionEvaluationException;

}
