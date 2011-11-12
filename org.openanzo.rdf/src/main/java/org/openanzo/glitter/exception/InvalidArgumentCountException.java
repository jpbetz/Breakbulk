/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/InvalidArgumentCountException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: InvalidArgumentCountException.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.exceptions.ExceptionConstants;

/**
 * Indicates that a function or operator was passed more or less arguments than it expected.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class InvalidArgumentCountException extends ExpressionEvaluationException {
    private static final long serialVersionUID = 293187960529233093L;

    /**
     * 
     * @param actual
     *            The number of arguments supplied
     * @param required
     *            The required number of arguments
     */
    public InvalidArgumentCountException(int actual, int required) {
        super(ExceptionConstants.GLITTER.INVALID_ARGUMENT_COUNT, Integer.toString(actual), Integer.toString(required));
    }

    /**
     * 
     * @param actual
     *            The number of arguments supplied
     * @param requiredMin
     *            The minimum required number of arguments
     * @param requiredMax
     *            The maximum required number of arguments
     */
    public InvalidArgumentCountException(int actual, int requiredMin, int requiredMax) {
        super(ExceptionConstants.GLITTER.INVALID_ARGUMENT_COUNT_MAX, Integer.toString(actual), Integer.toString(requiredMin), Integer.toString(requiredMax));
    }
}
