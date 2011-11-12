/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/PolymorphicNe.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: PolymorphicNe.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.expression.BinaryFunction;
import org.openanzo.glitter.expression.InfixOperator;
import org.openanzo.glitter.util.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * The != operator functions on numerics, booleans, datetimes, and RDF terms, in that priority order.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class PolymorphicNe extends BinaryFunction implements InfixOperator {
    public String getOperator() {
        return "!=";
    }

    @Override
    public Value call(Value arg1, Value arg2) throws ExpressionEvaluationException {
        if (arg1 instanceof Literal && arg2 instanceof Literal) {
            ComparisonResult cr = compareLiteralValues(arg1, arg2);
            if (cr == ComparisonResult.INDETERMINATE) {
                return new RDFTermNe().call(arg1, arg2);
            }
            return (cr == ComparisonResult.LESSER || cr == ComparisonResult.GREATER) ? Constants.TRUE : Constants.FALSE;
        } else {
            return new RDFTermNe().call(arg1, arg2);
        }
    }

    public URI getIdentifier() {
        return null;
    }

}
