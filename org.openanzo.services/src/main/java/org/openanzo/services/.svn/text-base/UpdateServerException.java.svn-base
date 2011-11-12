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
package org.openanzo.services;

import java.util.List;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;

/**
 * A compound Anzo exception for Update server errors
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class UpdateServerException extends AnzoException {

    private static final long           serialVersionUID = 1L;

    /** Set of errors that occurred on the server, one slot for each transaction */
    private final List<AnzoException>[] errors;

    /** Set of transaction that were being committed when exception was thrown */
    private final IUpdateTransaction[]  transactions;

    /**
     * Create new UpdateServerException with given transactions and errors
     * 
     * @param transations
     *            Array of transactions that were being executed on the server
     * @param errors
     *            Array of errors that occurred for the corresponding transactions
     */
    public UpdateServerException(IUpdateTransaction[] transations, List<AnzoException>[] errors) {
        super(ExceptionConstants.SERVER.UPDATE_SERVER_ERROR);
        this.errors = errors.clone();
        this.transactions = transations.clone();
    }

    /**
     * Get the set of errors that occurred executing the set of transactions on the server
     * 
     * @return array of errors
     */
    public List<AnzoException>[] getErrors() {
        return errors;
    }

    /**
     * Get the set of transactions that were being executed on the server
     * 
     * @return array of executed transactions
     */
    public IUpdateTransaction[] getTransactions() {
        return transactions;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        for (List<AnzoException> exceptions : errors) {
            if (exceptions != null) {
                for (AnzoException exception : exceptions) {
                    sb.append(exception.getMessage());
                }
            }
        }
        return sb.toString();
    }

    /**
     * 
     * @return
     */
    public String getUserMessage() {
        return super.getMessage();
    }
}
