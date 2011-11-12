/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/IncompatibleTypeException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: IncompatibleTypeException.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.glitter.expression.AggregateFunction;

/**
 * Indicates that an aggregate function was referenced without an accompanying solution set.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class InvalidAggregateFunctionException extends ExpressionEvaluationException {
    private static final long serialVersionUID = -8555530425758350672L;

    /**
     *
     * @param f
     *   The aggregate function that cannot be evaluated without a group
     */
    public InvalidAggregateFunctionException(AggregateFunction f) {
        super("Aggregate function found where scalar function expected: " + f);
    }

}
