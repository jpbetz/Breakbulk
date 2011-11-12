/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/NumericAdd.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: NumericAdd.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import javax.xml.datatype.XMLGregorianCalendar;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.MalformedLiteralException;
import org.openanzo.glitter.expression.BinaryFunction;
import org.openanzo.glitter.expression.InfixOperator;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Subtracts two dates and returns the number of days.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class DateTimeSubtract extends BinaryFunction implements InfixOperator {
    @Override
    public Value call(Value arg1, Value arg2) throws ExpressionEvaluationException {
        if (!TypeConversions.isDateTimeType(arg1))
            throw new IncompatibleTypeException(arg1, "date or datetime");
        if (!TypeConversions.isDateTimeType(arg2))
            throw new IncompatibleTypeException(arg2, "date or datetime");
        TypedLiteral dateLiteral1 = (TypedLiteral) arg1;
        TypedLiteral dateLiteral2 = (TypedLiteral) arg2;
        XMLGregorianCalendar date1, date2;
        try {
            date1 = (XMLGregorianCalendar) dateLiteral1.getNativeValue();
        } catch (IllegalArgumentException iae) {
            throw new MalformedLiteralException(arg1, "xsd:date or xsd:dateTime");
        }
        try {
            date2 = (XMLGregorianCalendar) dateLiteral2.getNativeValue();
        } catch (IllegalArgumentException iae) {
            throw new MalformedLiteralException(arg2, "xsd:date or xsd:dateTime");
        }
        if (date1 == null)
            throw new MalformedLiteralException(arg1, "xsd:date or xsd:dateTime");
        if (date2 == null)
            throw new MalformedLiteralException(arg2, "xsd:date or xsd:dateTime");

        long milliseconds = date1.toGregorianCalendar().getTimeInMillis() - date2.toGregorianCalendar().getTimeInMillis();
        double days = ((double) milliseconds) / ((double) (1000 * 60 * 60 * 24));

        return Constants.valueFactory.createTypedLiteral(days);
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.OP_NAMESPACE + "datetime-subtract");
    }

    public String getOperator() {
        return "-";
    }

}
