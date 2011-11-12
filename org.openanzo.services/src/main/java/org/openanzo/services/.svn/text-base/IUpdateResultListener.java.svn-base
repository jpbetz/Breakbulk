/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/UpdateResultListener.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Oct 18, 2006
 * Revision:	$Id: UpdateResultListener.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services;

import org.openanzo.exceptions.AnzoException;

/**
 * IUpdateResultListener interface for listeners which are triggered after an update call has completed successfully.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IUpdateResultListener {

    /**
     * Handles the updateComplete event.
     * 
     * @param results
     *            Final state and other useful details of statements added/updated/removed during a update call.
     * @throws AnzoException
     */
    public abstract void updateComplete(IOperationContext context, IUpdates results) throws AnzoException;
}
