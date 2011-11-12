/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/LogicalOr.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: LogicalOr.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.glitter.expression.InfixOperator;
import org.openanzo.glitter.expression.ScalarFunctionOnValuesAndErrors;
import org.openanzo.glitter.util.Constants;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Tri-state (including errors) logical-or operator (||).
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class LogicalOr implements ScalarFunctionOnValuesAndErrors, InfixOperator {

	public Value call(List<Value> arguments,
			List<ExpressionEvaluationException> errors)
			throws ExpressionEvaluationException {
		if (arguments.size() != 2)
			throw new InvalidArgumentCountException(arguments.size(), 2);
		
		Value[] args = {arguments.get(0), arguments.get(1)};
		Boolean[] bools = {null, null};
		ExpressionEvaluationException[] es = {errors.get(0), errors.get(1)};
		for (int i = 0; i < args.length; i++) {
			try { 
				if (args[i] != null)
					bools[i] = TypeConversions.effectiveBooleanValue(args[i]);
			} catch (ExpressionEvaluationException e) {
				es[i] = e;
			}
		}
		Boolean result = null;
		if (bools[0] != null && bools[1] != null) {
			result = bools[0] || bools[1];
		} else if (bools[0] == null) {
			if (bools[1] == null || !bools[1])
				throw es[0];
			else
				result = true;
		} else {
			if (bools[0])
				result = true;
			else
				throw es[1];
		}
		return (result)?Constants.TRUE:Constants.FALSE;
	}

	public URI getIdentifier() {
		return Glitter.createURI(NAMESPACES.BUILTIN_NAMESPACE + "logical-or");
	}

	public boolean operatesOnTypeErrors() {
		return true;
	}

	public boolean operatesOnValues() {
		return true;
	}

    public String getOperator() {
        return "||";
    }
}
