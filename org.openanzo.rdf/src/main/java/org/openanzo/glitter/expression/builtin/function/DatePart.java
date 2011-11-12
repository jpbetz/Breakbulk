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

import javax.xml.datatype.XMLGregorianCalendar;

import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.MalformedLiteralException;
import org.openanzo.glitter.expression.UnaryFunction;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.datatype.TypeMaps;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Given an xsd:date or an xsd:dateTime, returns the appropriate xsd:date
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class DatePart extends UnaryFunction {

    @Override
    public Value call(Value arg1) throws IncompatibleTypeException {
        if (arg1 instanceof TypedLiteral) {
            TypedLiteral lit = (TypedLiteral) arg1;
            URI dt = lit.getDatatypeURI();
            if (dt.equals(XMLSchema.DATE))
                return arg1;
            else if (dt.equals(XMLSchema.DATETIME)) {
                XMLGregorianCalendar dateTime;
                try {
                    dateTime = (XMLGregorianCalendar) lit.getNativeValue();
                } catch (IllegalArgumentException iae) {
                    throw new MalformedLiteralException(arg1, "xsd:dateTime or xsd:date");
                }
                XMLGregorianCalendar date = TypeMaps.datatypeFactory.newXMLGregorianCalendarDate(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), dateTime.getTimezone());
                return MemTypedLiteral.create(date);
            }

        }
        throw new IncompatibleTypeException(arg1, "typed literal of xsd:date or xsd:dateTime");
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.GLITTER_FUNCTION_NAMESPACE + "datePart");
    }

}
