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

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.rdf.TriplePatternComponent;

/**
 * Indicates that a function or operator was supplied with an argument of a type that it does not handle.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class IncompatibleTypeException extends ExpressionEvaluationException {
    private static final long serialVersionUID = -7440463257577738032L;

    /**
     * 
     * @param value
     *            The supplied value
     * @param required
     *            The expected type
     */
    public IncompatibleTypeException(TriplePatternComponent value, String required) {
        super(ExceptionConstants.GLITTER.INCOMPATIBLE_TYPE, value != null ? value.toString() : "null", required);
    }

    /**
     * 
     * @param value
     *            The supplied value
     * @param required
     *            The expected type
     */
    public IncompatibleTypeException(Expression value, String required) {
        super(ExceptionConstants.GLITTER.INCOMPATIBLE_TYPE, value != null ? value.toString() : "null", required);
    }

}
