/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/cast/XSDInteger.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: XSDInteger.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin.function;

import java.math.BigDecimal;

import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.expression.UnaryFunction;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.PolymorphicNumber;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Rounds a numeric to the nearest integer.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class Round extends UnaryFunction {

    @Override
    public Value call(Value arg1) throws IncompatibleTypeException {
        if (TypeConversions.isNumeric(arg1)) {
            TypedLiteral lit = (TypedLiteral) arg1;
            PolymorphicNumber number = new PolymorphicNumber(lit);
            if (number.convertsSafelyToLong())
                return number.asTypedLiteral();
            if (number.convertsSafelyToDouble())
                return Constants.valueFactory.createLiteral(Long.toString(Math.round(number.doubleValue())), XMLSchema.INTEGER);
            return Constants.valueFactory.createLiteral(number.bigDecimalValue().add(new BigDecimal(0.5)).toBigInteger().toString(), XMLSchema.INTEGER);
        }
        throw new IncompatibleTypeException(arg1, "numeric");
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.GLITTER_FUNCTION_NAMESPACE + "round");
    }

}
