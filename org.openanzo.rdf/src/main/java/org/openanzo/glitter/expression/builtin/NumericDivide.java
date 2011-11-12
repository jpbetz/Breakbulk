/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
  * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/NumericDivide.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: NumericDivide.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.expression.BinaryFunction;
import org.openanzo.glitter.expression.InfixOperator;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.PolymorphicNumber;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Numeric division.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class NumericDivide extends BinaryFunction implements InfixOperator {
	@Override
	public Value call(Value arg1, Value arg2)
			throws ExpressionEvaluationException {
		if (!TypeConversions.isNumeric(arg1))
			throw new IncompatibleTypeException(arg1, "numeric");
		if (!TypeConversions.isNumeric(arg2))
			throw new IncompatibleTypeException(arg2, "numeric");
		return new PolymorphicNumber(arg1).divide(new PolymorphicNumber(arg2)).asTypedLiteral();
	}
	
	public URI getIdentifier() {
		return Glitter.createURI(NAMESPACES.OP_NAMESPACE + "numeric-divide");
	}

    public String getOperator() {
        return "/";
    }

}
