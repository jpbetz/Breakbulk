/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/UnhandledRdbException.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: UnhandledRdbException.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.utils;

import org.openanzo.exceptions.AnzoRuntimeException;

/**
 * Exception dealing with unhandled RDB errors
 * 
 * @author Joe Betz
 * 
 */
public class UnhandledRdbException extends AnzoRuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Create a new exception with a error tags, an error code, and 0 or more string arguments to the error message.
     * @param errorCode
     *            Error code
     * @param args
     *            Arguments to error messages
     */
    public UnhandledRdbException(long errorCode, String... args) {
        super(errorCode, args);
    }

    /**
     * Create a RuntimeException based on given error codes, throwable, and arguments
     * @param errorCode
     *            Error code
     * @param cause
     *            Root cause of exception
     * @param args
     *            Arguments to exception
     */
    protected UnhandledRdbException(long errorCode, Throwable cause, String... args) {
        super(errorCode, cause, args);
    }

}
