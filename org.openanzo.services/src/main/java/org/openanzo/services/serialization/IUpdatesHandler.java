/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 2, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.IUpdateTransaction;

/**
 * Handler for IUpdateTrasnsactions
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IUpdatesHandler {
    /**
     * Start handling transactions
     * 
     * @throws AnzoException
     */
    public void start() throws AnzoException;

    /**
     * Handle transaction
     * 
     * @param transaction
     *            transaction to handle
     * @throws AnzoException
     */
    public void handleTransaction(IUpdateTransaction transaction) throws AnzoException;

    /**
     * Finish handling transctions
     * 
     * @throws AnzoException
     */
    public void end() throws AnzoException;
}
