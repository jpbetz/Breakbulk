/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/common/exceptions/UpdateServerException.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/24/2006
 * Revision:	$Id: UpdateServerException.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Anzo exception that is made up of a set of other exceptions
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class CompoundAnzoException extends AnzoException {

    private static final long         serialVersionUID = 1807308892432474799L;

    /** Set of errors that make up this compound exception */
    private final List<AnzoException> errors;

    /**
     * Create new CompoundAnzoException with given errors
     * 
     * @param errors
     *            Array of errors that occurred for the corresponding transactions
     */
    public CompoundAnzoException(final List<AnzoException> errors) {
        super(ExceptionConstants.CORE.COMPOUND_EXCEPTION);
        this.errors = errors;
    }

    /**
     * Create new CompoundAnzoException with given errors
     * 
     * @param errors
     *            Array of errors that occurred for the corresponding transactions
     */
    public CompoundAnzoException(final AnzoException... errors) {
        super(ExceptionConstants.CORE.COMPOUND_EXCEPTION);
        this.errors = new ArrayList<AnzoException>();
        Collections.addAll(this.errors, errors);
    }

    /**
     * Create a new exception with a set of error tags, an error code, and 0 or more string arguments to the error message.
     * 
     * @param errors
     *            Array of errors that occurred for the corresponding transactions
     * @param errorCode
     *            Error code
     * @param args
     *            Arguments to error message
     */
    public CompoundAnzoException(final List<AnzoException> errors, final long errorCode, final String... args) {
        super(errorCode, args);
        this.errors = errors;
    }

    /**
     * Create a new exception with a set of error tags, an error code, and 0 or more string argurments to the error message.
     * 
     * @param errors
     *            Array of errors that occurred for the corresponding transactions
     * @param errorCode
     *            Error code
     * @param cause
     *            Cause of exception
     * @param args
     *            Arguments to error messages
     */
    public CompoundAnzoException(final List<AnzoException> errors, final long errorCode, final Throwable cause, final String... args) {
        super(errorCode, cause, args);
        this.errors = errors;
    }

    /**
     * Get the set of errors for this compound exception
     * 
     * @return the set of errors for this compound exception
     */
    public List<AnzoException> getErrors() {
        return errors;
    }

    @Override
    public String getMessage(final boolean includeErrorCodes) {
        final StringBuilder causeMessage = new StringBuilder();
        causeMessage.append(super.getMessage(includeErrorCodes));
        for (AnzoException exception : errors) {
            causeMessage.append("\n");

            causeMessage.append(exception.getMessage(includeErrorCodes));
        }

        return causeMessage.toString();
    }

    @Override
    public String getMessage() {
        return getMessage(true);
    }
}
