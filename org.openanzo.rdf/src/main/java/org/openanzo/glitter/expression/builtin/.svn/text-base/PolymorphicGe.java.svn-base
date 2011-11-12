/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
  * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/PolymorphicGe.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: PolymorphicGe.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.expression.BinaryFunction;
import org.openanzo.glitter.expression.InfixOperator;
import org.openanzo.glitter.util.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * The &gt;= operator functions on numerics, booleans, datetimes, and RDF terms, in that priority order.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class PolymorphicGe extends BinaryFunction implements InfixOperator {
    public String getOperator() {
        return ">=";
    }

    @Override
    public Value call(Value arg1, Value arg2) throws ExpressionEvaluationException {
        ComparisonResult cr = compareLiteralValues(arg1, arg2);
        return (cr == ComparisonResult.EQUAL || cr == ComparisonResult.GREATER) ? Constants.TRUE : Constants.FALSE;
    }

    public URI getIdentifier() { return null; }

}
