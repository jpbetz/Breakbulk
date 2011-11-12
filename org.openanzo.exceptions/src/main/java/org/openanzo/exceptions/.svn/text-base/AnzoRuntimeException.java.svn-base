/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/common/exceptions/Attic/BocaRuntimeException.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/19/2005
 * Revision:	$Id: AnzoRuntimeException.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.exceptions;

/**
 * Runtime exception that encapsulates a AnzoException
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class AnzoRuntimeException extends RuntimeException {
    private static final long     serialVersionUID = -6290097600356563758L;

    /** Internal Exception object for this RuntimeException */
    protected final AnzoException exception;

    /**
     * Create a RuntimeException caused by an AnzoException
     * 
     * @param anzoException
     *            Cause of exception
     */
    public AnzoRuntimeException(final AnzoException anzoException) {
        super(anzoException.getMessage(), anzoException);
        this.exception = anzoException;
    }

    /**
     * Create a RuntimeException based on given error codes and arguments
     * 
     * @param errorCode
     *            Error code
     * @param arguments
     *            Arguments to exception
     */
    public AnzoRuntimeException(final long errorCode, final String... arguments) {
        super();
        this.exception = new AnzoException(errorCode, arguments);
    }

    /**
     * Create a RuntimeException based on given error codes, throwable, and arguments
     * 
     * @param errorCode
     *            Error code
     * @param cause
     *            Root cause of exception
     * @param arguments
     *            Arguments to exception
     */
    public AnzoRuntimeException(final long errorCode, final Throwable cause, final String... arguments) {
        super(cause);
        this.exception = new AnzoException(errorCode, arguments);
    }

    /**
     * Get the exception's error message
     * 
     * @return exceptions error message
     */
    @Override
    public String getMessage() {
        return getMessage(true);
    }

    /**
     * Get the exception's error message
     * 
     * @param includeErrorCodes
     *            include the error code in the exception
     * @return exceptions error message
     */
    public String getMessage(final boolean includeErrorCodes) {
        return exception.getMessage(includeErrorCodes);
    }

    /**
     * Get exception's error code
     * 
     * @return exception's error code
     */
    public long getErrorCode() {
        return exception.getErrorCode();
    }

    /**
     * Get error's message arguments
     * 
     * @return error's message arguments
     */
    public String[] getArgs() {
        return exception.getArgs();
    }

    /**
     * Get the exception that this runtime exception encapsulates
     * 
     * @return the exception that this runtime exception encapsulates
     */
    public AnzoException getAnzoException() {
        return exception;
    }
}
