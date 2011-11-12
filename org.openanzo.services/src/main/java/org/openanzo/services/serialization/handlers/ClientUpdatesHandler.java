/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/serialization/handlers/ClientUpdatesHandler.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/30/2006
 * Revision:	$Id: ClientUpdatesHandler.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.serialization.handlers;

import java.util.ArrayList;
import java.util.List;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.serialization.IUpdatesHandler;

/**
 * IRepositoryHandler that handles changes as a result of an update call to server
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ClientUpdatesHandler implements IUpdates, IUpdatesHandler {

    private final List<IUpdateTransaction> updates = new ArrayList<IUpdateTransaction>();

    private String                         operationId;

    public List<IUpdateTransaction> getTransactions() {
        return updates;
    }

    public void start() throws AnzoException {
    }

    public void end() throws AnzoException {
    }

    public void handleTransaction(IUpdateTransaction transaction) throws AnzoException {
        updates.add(transaction);
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
}
