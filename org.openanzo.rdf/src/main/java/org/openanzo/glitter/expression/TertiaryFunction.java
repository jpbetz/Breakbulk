/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/BinaryFunction.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: BinaryFunction.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     C Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.rdf.Value;

/**
 * {@link TertiaryFunction} is a base class for SPARQL functions that take three arguments. It checks the number of arguments supplied and defers to an abstract
 * method {@link #call(Value, Value, Value)} that unpackages the three arguments from the original argument list.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public abstract class TertiaryFunction extends ScalarFunctionBase implements ScalarFunctionOnValues {

    public Value call(List<Value> arguments) throws ExpressionEvaluationException {
        if (arguments.size() != 3)
            throw new InvalidArgumentCountException(arguments.size(), 3);
        return call(arguments.get(0), arguments.get(1), arguments.get(2));
    }

    /**
     * Invoke a tertiary function explicitly with three arguments. Subclasses need only implement this method and are assured that they will receive exactly
     * three arguments.
     * 
     * @param arg1
     *            First argument to the function
     * @param arg2
     *            Second argument to the function
     * @param arg3
     *            Third argument to the function
     * @return The return value of the function
     * @throws ExpressionEvaluationException
     */
    public abstract Value call(Value arg1, Value arg2, Value arg3) throws ExpressionEvaluationException;
}
