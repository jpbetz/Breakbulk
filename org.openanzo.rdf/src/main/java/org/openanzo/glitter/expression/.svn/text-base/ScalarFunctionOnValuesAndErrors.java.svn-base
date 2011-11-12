/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/FunctionOnValuesAndErrors.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: FunctionOnValuesAndErrors.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.rdf.Value;

/**
 * Similar to {@link ScalarFunctionOnValues}, except that each argument may be a type error. This interface is for {@link Function}s that return <tt>true</tt>
 * for {@link ScalarFunction#operatesOnTypeErrors()}.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public interface ScalarFunctionOnValuesAndErrors extends ScalarFunction {
    /**
     * Takes arguments; a null argument will have a corresponding non-null Exception in the errors list.
     * 
     * @param arguments
     *            A list of arguments to the function. A null entry has a non-null Exception at the same index in the errors list.
     * @param errors
     *            A list of Exceptions generated while evaluating arguments to the function. A null entry has a non-null value at the same index in the
     *            arguments list.
     * @return The result of evaluating this function against the given arguments and errors
     * @throws ExpressionEvaluationException
     */
    public Value call(List<Value> arguments, List<ExpressionEvaluationException> errors) throws ExpressionEvaluationException;

}
