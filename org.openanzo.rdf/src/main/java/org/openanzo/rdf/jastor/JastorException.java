/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/jastor/Attic/JastorException.java,v $
 * Created by:  Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 * Created on:  5/15/2006
 * Revision:	$Id: JastorException.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor;

/**
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 */
public class JastorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Exception that caused this Exception to be created and thrown
     */
    private final Exception   originalException;

    /**
     * String describing the cause of this error or information related to it
     */
    private final String      errorDescription;

    /**
     * Constructs a new JastorException using the original exception that caused this new exception to be thrown, an error code associated with the exception
     * and the error's description
     * 
     * @param exception
     *            The exception that caused this exception to be created
     * @param errorCode
     *            The error code associated with this excecpion
     * @param errorDescription
     *            The description of the error
     */
    protected JastorException(Exception exception, int errorCode, String errorDescription) {
        super(errorDescription);
        this.originalException = exception;
        this.errorDescription = errorDescription;
    }

    /**
     * Constructs a new JastorException using an error code associated with the exception and the error's description
     * 
     * @param errorCode
     *            The error code associated with this exception
     * @param errorDescription
     *            The description of the error
     */
    protected JastorException(int errorCode, String errorDescription) {
        super(errorDescription);
        this.originalException = null;
        this.errorDescription = errorDescription;
    }

    /**
     * Constructs a new JastorException using the original exception that caused this new exception to be thrown and the error's description
     * 
     * @param exception
     *            The exception that caused this exception to be created
     * @param errorDescription
     *            The description of the error
     */
    public JastorException(Exception exception, String errorDescription) {
        super(errorDescription);
        this.originalException = exception;
        this.errorDescription = errorDescription;
    }

    /**
     * Constructs a new JastorException using the error's description
     * 
     * @param errorDescription
     *            The description of the error
     */
    public JastorException(String errorDescription) {
        super(errorDescription);
        this.originalException = null;
        this.errorDescription = errorDescription;
    }

    /**
     * Constructs a new JastorException using default values
     */
    public JastorException() {
        super("Error occurred within Jastor");
        this.originalException = null;
        this.errorDescription = "Error occurred within Jastor.";
    }

    /**
     * Return the exception that caused this exception to be created
     * 
     * @return The exception that caused this exception to occur
     */
    public Exception getOriginalException() {
        return this.originalException;
    }

    /**
     * Return the description for this exception
     * 
     * @return The description belonging to this exception
     */
    public String getErrorDescription() {
        return this.errorDescription;
    }

    /**
     * Returns string containing both the error code and the error description
     * 
     * @return Message describing the error
     */
    @Override
    public String getMessage() {
        return this.errorDescription + (this.originalException != null ? " Root Cause: " + originalException.getClass().getName() + " " + originalException.getMessage() : "");
    }

    /**
     * Print the stack trace of the original exception
     */
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("printStackTrace(): " + this.getClass().getName());
        if (this.originalException != null) {
            System.err.println("STACK TRACE FOR INNER EXCEPTION: " + this.originalException.getClass().getName());
            this.originalException.printStackTrace();
        } else {
            System.err.println("No stack trace to print, as there was no original exception thrown.");
        }
    }
}
