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

import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.glitter.expression.ScalarFunctionBase;
import org.openanzo.glitter.expression.ScalarFunctionOnValues;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.datatype.TypeMaps;

/**
 * Returns the current date and time.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class Now extends ScalarFunctionBase implements ScalarFunctionOnValues  {

    public Value call(List<Value> arguments) throws ExpressionEvaluationException {
        if (arguments.size() > 1)
            throw new InvalidArgumentCountException(arguments.size(), 0, 1);
        GregorianCalendar now = null;
        if (arguments.size() == 1) {
            Value v = arguments.get(0);
            if (!(v instanceof Literal))
                throw new IncompatibleTypeException(v, "plain or typed literal");
            TimeZone tz = TimeZone.getTimeZone(((Literal)v).getLabel());
            now = new GregorianCalendar(tz);
        } else {
            now = new GregorianCalendar();
        }
        return MemTypedLiteral.create(TypeMaps.datatypeFactory.newXMLGregorianCalendar(now));
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.GLITTER_FUNCTION_NAMESPACE + "now");
    }

}
