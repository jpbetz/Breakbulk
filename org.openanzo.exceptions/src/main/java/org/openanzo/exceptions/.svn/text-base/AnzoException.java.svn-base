/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/common/exceptions/Attic/BocaException.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/30/2006
 * Revision:	$Id: AnzoException.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.exceptions;

import java.text.MessageFormat;

/**
 * Base exception for Anzo. Contains a set of 1 or more error tags, an error code, and any arguments needed to populate the exception message. The text of the
 * message is stored in an external properties file in order to facilitate i8n.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class AnzoException extends Exception {
    private static final long   serialVersionUID = 28959716613058757L;

    /**
     * Text constants for error messages
     */
    private static final String ROOT_CAUSE       = " Root Cause: ";

    private static final String ERROR_CODE       = "ErrorCode[";

    /** Error code for exception */
    private final long          errorCode;

    /** Arguments to error message */
    private final String[]      args;

    /**
     * Create a new exception with a error tags, an error code, and 0 or more string arguments to the error message.
     * 
     * @param errorCode
     *            Error code
     * @param args
     *            Arguments to error message
     */
    public AnzoException(final long errorCode, final String... args) {
        super();
        this.errorCode = errorCode;
        this.args = args;
    }

    /**
     * Create a new exception with a error tags, an error code, and 0 or more string arguments to the error message.
     * 
     * @param errorCode
     *            Error code
     * @param cause
     *            Cause of exception
     * @param args
     *            Arguments to error messages
     */
    public AnzoException(final long errorCode, final Throwable cause, final String... args) {
        super(cause);
        this.errorCode = errorCode;
        this.args = args;
    }

    /**
     * Return the error message for this exception.
     * 
     * @param includeErrorCode
     *            include the error code in the message
     * @return error message for this exception
     */
    public String getMessage(final boolean includeErrorCode) {
        final StringBuilder causeMessage = new StringBuilder();
        if (this.getCause() != null) {
            causeMessage.append(ROOT_CAUSE);
            if (this.getCause() instanceof AnzoException) {
                causeMessage.append(' ');
                causeMessage.append(((AnzoException) this.getCause()).getMessage(includeErrorCode));
            } else {
                causeMessage.append(this.getCause().getClass().getName());
                causeMessage.append(' ');
                causeMessage.append(this.getCause().getMessage());
            }
        }
        return getUserMessage(includeErrorCode) + causeMessage.toString();
    }

    /**
     * Return the error message for this exception.
     * 
     * @return error message for this exception
     */
    @Override
    public String getMessage() {
        return getMessage(true);
    }

    /**
     * Use error tags, an error code to lookup exception text, and fill in arguments to message.
     * 
     * @return text of error message based on error codes
     */
    private String getUserMessage(final boolean includeErrorTags) {
        final StringBuilder builder = new StringBuilder();
        if (includeErrorTags) {
            builder.append(ERROR_CODE);
            builder.append(errorCode);
            builder.append(']');
            builder.append(' ');
        }
        builder.append(MessageFormat.format(Messages.getString(errorCode), (Object[]) args));
        return builder.toString();
    }

    /**
     * Get the code.
     * 
     * @return Error's code
     */
    public long getErrorCode() {
        return errorCode;
    }

    /**
     * Get the arguments to the error message
     * 
     * @return arguments to the error message
     */
    public String[] getArgs() {
        return args.clone();
    }
}
