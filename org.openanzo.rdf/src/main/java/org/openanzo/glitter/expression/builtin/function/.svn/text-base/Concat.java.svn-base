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

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.expression.ScalarFunctionBase;
import org.openanzo.glitter.expression.ScalarFunctionOnValues;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Given a URI returns the local name
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class Concat extends ScalarFunctionBase implements ScalarFunctionOnValues {

    public Value call(List<Value> arguments) throws ExpressionEvaluationException {
        StringBuilder sb = new StringBuilder();
        for (Value v : arguments) {
            if (!(v instanceof Literal))
                throw new IncompatibleTypeException(v, "plain or typed literal");
            Literal l = (Literal) v;
            sb.append(l.getLabel());
        }
        return Constants.valueFactory.createLiteral(sb.toString());
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.GLITTER_FUNCTION_NAMESPACE + "concat");
    }

}
