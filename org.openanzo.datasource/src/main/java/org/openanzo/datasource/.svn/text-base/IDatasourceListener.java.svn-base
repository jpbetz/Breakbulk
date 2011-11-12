/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 3, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource;

import org.openanzo.exceptions.AnzoException;

/**
 * Listener that is notified when datasource reset is taking place
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IDatasourceListener {
    /**
     * First phase of reset, when all listeners are told reset is starting
     * 
     * @throws AnzoException
     */
    public void resetStarting() throws AnzoException;

    /**
     * Second phase of reset, when listeners should do any action pertaining to reset
     * 
     * @throws AnzoException
     */
    public void reset() throws AnzoException;

    /**
     * Load any reset data
     * 
     * @throws AnzoException
     */
    public void postReset() throws AnzoException;

    /**
     * Final phase of reset, when listeners know what all the components have reset themselves
     * 
     * @throws AnzoException
     */
    public void resetFinished() throws AnzoException;

}
