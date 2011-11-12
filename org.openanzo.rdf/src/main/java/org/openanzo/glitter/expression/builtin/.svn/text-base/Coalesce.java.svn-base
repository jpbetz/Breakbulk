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
import org.openanzo.glitter.expression.ScalarFunctionOnValuesAndErrors;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Returns the first non-error, bound value. Takes an arbitrary number of arguments.
 * 
 * If all values are unbound or error, returns unbound.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Coalesce implements ScalarFunctionOnValuesAndErrors {

    public Value call(List<Value> arguments, List<ExpressionEvaluationException> errors) throws ExpressionEvaluationException {
        for (int i = 0; i < arguments.size(); i++) {
            if (errors.get(i) == null && arguments.get(i) != null)
                return arguments.get(i);
        }
        return null;
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.BUILTIN_NAMESPACE + "coalesce");
    }

    public boolean operatesOnTypeErrors() {
        return true;
    }

    public boolean operatesOnValues() {
        return true;
    }
}
