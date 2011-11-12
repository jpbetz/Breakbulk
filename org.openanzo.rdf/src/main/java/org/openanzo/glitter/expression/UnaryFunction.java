/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:       $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/UnaryFunction.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: UnaryFunction.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
  *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.rdf.Value;

/**
 * Base class for SPARQL functions that take a single argument. This base class takes care of checking
 * that only a single argument is passed to a unary function.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public abstract class UnaryFunction extends ScalarFunctionBase implements ScalarFunctionOnValues {

	public Value call(List<Value> arguments) throws ExpressionEvaluationException {
		if (arguments.size() != 1)
			throw new InvalidArgumentCountException(arguments.size(), 1);
		return call(arguments.get(0));
	}
	
	/**
	 * An unpackaged version of {@link ScalarFunctionOnValues#call(List)} that receives the single
	 * argument to the function.
	 * @param arg1 The single unary argument to the function
	 * @return The return value of the function.
	 * @throws IncompatibleTypeException
	 */
	public abstract Value call(Value arg1) throws IncompatibleTypeException;

}
