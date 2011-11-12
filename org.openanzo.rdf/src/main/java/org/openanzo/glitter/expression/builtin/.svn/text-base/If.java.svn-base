/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:$Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/LogicalAnd.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: LogicalAnd.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.glitter.expression.ScalarFunctionOnValuesAndErrors;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Conditional. If(test, res1, res2[, res3])
 *
 * if test is true, returns res1.
 * if test is false, returns res2.
 * if test is error, returns res3 if present.
 * if test is error, returns test (error) if res3 not present.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class If implements ScalarFunctionOnValuesAndErrors {

	public Value call(List<Value> arguments,
			List<ExpressionEvaluationException> errors)
			throws ExpressionEvaluationException {
		if (arguments.size() < 3 || arguments.size() > 4)
			throw new InvalidArgumentCountException(arguments.size(), 3, 4);

		Value test = arguments.get(0);
		ExpressionEvaluationException testError = errors.get(0);
		int index;
		if (testError != null) {
		    if (arguments.size() < 4)
		        throw testError;
		    index = 3;
		} else {
	        boolean testResult = TypeConversions.effectiveBooleanValue(test);
	        index = testResult ? 1 : 2;
		}
        if (arguments.get(index) != null) {
            return arguments.get(index);
        } else {
            throw errors.get(index);
        }
	}

	public URI getIdentifier() {
		return Glitter.createURI(NAMESPACES.BUILTIN_NAMESPACE + "if");
	}

	public boolean operatesOnTypeErrors() {
		return true;
	}

	public boolean operatesOnValues() {
		return true;
	}
}
