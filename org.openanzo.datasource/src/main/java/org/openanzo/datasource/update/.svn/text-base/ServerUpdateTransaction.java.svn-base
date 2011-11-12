/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/repository/update/TransactionUpdateResults.java,v $
 * Created by:  Joe Betz
 * Created on:  3/22/2006
 * Revision:	$Id: TransactionUpdateResults.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.update;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.UpdateTransaction;

/**
 * Tracks adds, updates, removes and errors in an update transaction. Update operations on a statement are merged so that only the final state of the statment
 * is stored. Removed NamedGraphs are tracked seperate from statements.
 * 
 * @author Joe Betz
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public class ServerUpdateTransaction extends UpdateTransaction {

    /** Get the user that is making the updates */
    private final IOperationContext context;

    /** Has an error occurred during this transaction */
    private boolean                 hasError     = false;

    private final Set<Statement>    aclAdditions = new HashSet<Statement>();

    private final Set<Statement>    aclRemovals  = new HashSet<Statement>();

    private final Long              transactionId;

    /**
     * Create a new server update transaction
     * 
     * @param context
     * @param timestamp
     * @param transactionId
     * @param transactionURI
     * @param transactionContext
     */
    public ServerUpdateTransaction(IOperationContext context, Long timestamp, Long transactionId, URI transactionURI, java.util.Collection<Statement> transactionContext) {
        super(transactionURI, timestamp, transactionContext, new HashMap<URI, Long>());
        this.context = context;
        this.transactionId = transactionId;
    }

    /**
     * Get the User that created this transaction
     * 
     * @return User that created this transaction
     */
    public AnzoPrincipal getServerPrincipal() {
        return context.getOperationPrincipal();
    }

    /**
     * Get the context for the transaction
     * 
     * @return the context for the transaction
     */
    public IOperationContext getContext() {
        return context;
    }

    /**
     * Handle an error by creating a AnzoException and writing error to handler
     * @param errorCode
     *            Error code
     * @param errorMessageArgs
     *            Arguments for error messages
     * 
     * @throws AnzoException
     */
    public void handleError(long errorCode, String... errorMessageArgs) throws AnzoException {
        hasError = true;
        getErrors().add(new AnzoException(errorCode, errorMessageArgs));
    }

    /**
     * Return true if any errors have occurred during this transaction
     * 
     * @return Return true if any errors have occurred during this transaction
     */
    public boolean hasError() {
        return hasError;
    }

    /**
     * @return the aclAdditions
     */
    public Set<Statement> getAclAdditions() {
        return aclAdditions;
    }

    /**
     * @return the aclRemovals
     */
    public Set<Statement> getAclRemovals() {
        return aclRemovals;
    }

    /**
     * @return the transactionId
     */
    public Long getTransactionId() {
        return transactionId;
    }

}
