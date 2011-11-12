/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
  * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/UnaryMinus.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: UnaryMinus.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.expression.PrefixOperator;
import org.openanzo.glitter.expression.UnaryFunction;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.PolymorphicNumber;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Implements the unary numeric negation (minus) operator.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class UnaryMinus extends UnaryFunction implements PrefixOperator {

	@Override
	public Value call(Value arg1)
			throws IncompatibleTypeException {
		if (!TypeConversions.isNumeric(arg1))
			throw new IncompatibleTypeException(arg1, "numeric");
		return new PolymorphicNumber(arg1).negate().asTypedLiteral();
	}

	public URI getIdentifier() {
		return Glitter.createURI(NAMESPACES.OP_NAMESPACE + "numeric-unary-minus");
	}

    public String getOperator() {
        return "-";
    }

}
