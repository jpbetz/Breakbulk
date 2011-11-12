/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/repository/update/UpdateResults.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  3/22/2006
 * Revision:	$Id: UpdateResults.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;

/**
 * List of IModelTransactionUpdates that occurred within one update call
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Updates implements IUpdates {

    /** List of IModelTransactionUpdates that occurred during this update call */
    private final List<IUpdateTransaction> transactions;

    private String                         operationId;

    /**
     * Create a new UpdateResults
     * 
     */
    public Updates(String operationId) {
        super();
        this.operationId = operationId;
        transactions = new ArrayList<IUpdateTransaction>();
    }

    public String getOperationId() {
        return operationId;
    }

    /**
     * @param operationId
     *            the operationId to set
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    /**
     * Create updates form list of transactions
     * 
     * @param transactions
     *            list of transactions
     */
    public Updates(List<IUpdateTransaction> transactions) {
        super();
        this.transactions = transactions;
    }

    public List<IUpdateTransaction> getTransactions() {
        return transactions;
    }

}
