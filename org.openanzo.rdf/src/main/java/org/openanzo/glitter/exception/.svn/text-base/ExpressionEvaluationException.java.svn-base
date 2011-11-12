/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/ExpressionEvaluationException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: ExpressionEvaluationException.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;

/**
 * Indicates an error in evaluating a FILTER or ORDER BY expression. This exception should be caught and handled by appropriate tri-state logic or turn into
 * "false" at the top level of a FILTER expression.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public abstract class ExpressionEvaluationException extends AnzoRuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param msg
     *            Explanation of the exception.
     */
    public ExpressionEvaluationException(String msg) {
        super(ExceptionConstants.GLITTER.EXPRESSION_EVAL, msg);
    }

    /**
     * @param errorTags
     *            Error tags
     * @param errorCode
     *            Error code
     * @param arguments
     *            Arguments to exception
     */
    protected ExpressionEvaluationException(long errorCode, String... arguments) {
        super(errorCode, arguments);
    }

}
