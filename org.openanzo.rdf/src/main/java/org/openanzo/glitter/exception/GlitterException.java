/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/GlitterException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: GlitterException.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;

/**
 * Superclass for non-runtime Glitter exceptions.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class GlitterException extends AnzoException {
    private static final long serialVersionUID = 104559221171189306L;

    /**
     * 
     * @param msg
     *            Description of the exception.
     */
    public GlitterException(String msg) {
        super(ExceptionConstants.GLITTER.GLITTER_EXCEPTION, msg);
    }

    /**
     * 
     * @param cause
     *            Cause of the exception.
     */
    public GlitterException(Throwable cause) {
        super(ExceptionConstants.GLITTER.GLITTER_EXCEPTION, cause);
    }

    /**
     * Create a new exception with a set of error tags, an error code, and 0 or more string arguments to the error message.
     * 
     * @param errorCode
     *            Error code
     * @param args
     *            Arguments to error message
     */
    public GlitterException(long errorCode, String... args) {
        super(errorCode, args);
    }

    /**
     * Create a new exception with a set of error tags, an error code, and 0 or more string arguments to the error message.
     * 
     * @param errorCode
     *            Error code
     * @param cause
     *            Cause of exception
     * @param args
     *            Arguments to error messages
     */
    public GlitterException(long errorCode, Throwable cause, String... args) {
        super(errorCode, cause, args);
    }
}
