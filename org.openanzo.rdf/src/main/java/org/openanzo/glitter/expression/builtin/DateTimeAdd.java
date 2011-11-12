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

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.MalformedLiteralException;
import org.openanzo.glitter.expression.BinaryFunction;
import org.openanzo.glitter.expression.InfixOperator;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Numeric addition.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class DateTimeAdd extends BinaryFunction implements InfixOperator {
    @Override
    public Value call(Value arg1, Value arg2) throws ExpressionEvaluationException {
        if (!TypeConversions.isDateTimeType(arg1))
            throw new IncompatibleTypeException(arg1, "datetime or date");
        if (!TypeConversions.isDuration(arg2))
            throw new IncompatibleTypeException(arg2, "duration");
        TypedLiteral dateLiteral = (TypedLiteral) arg1;
        TypedLiteral durationLiteral = (TypedLiteral) arg2;
        XMLGregorianCalendar date;
        try {
            date = (XMLGregorianCalendar) dateLiteral.getNativeValue();
        } catch (IllegalArgumentException iae) {
            throw new MalformedLiteralException(arg1, "xsd:dateTime or xsd:date or xsd:time");
        }
        Duration duration;
        try {
            duration = (Duration) durationLiteral.getNativeValue();
        } catch (IllegalArgumentException iae) {
            throw new MalformedLiteralException(arg2, "xsd:duration, xsd:dayTimeDuration, or xsd:dayTimeDuration");
        }
        if (date == null)
            throw new MalformedLiteralException(arg1, "xsd:dateTime or xsd:date or xsd:time");
        if (duration == null)
            throw new MalformedLiteralException(arg2, "xsd:duration, xsd:dayTimeDuration, or xsd:dayTimeDuration");

        date.add(duration);
        return MemTypedLiteral.create(date);
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.OP_NAMESPACE + "datetime-add");
    }

    public String getOperator() {
        return "+";
    }

}
