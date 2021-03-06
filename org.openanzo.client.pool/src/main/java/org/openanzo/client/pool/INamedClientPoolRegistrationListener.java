/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 10, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client.pool;

/**
 * Listener that is notified when a client pool is registered and available from OSGI
 */
public interface INamedClientPoolRegistrationListener {

    /**
     * ClientPool is available
     * 
     * @param clientPool
     *            the available client pool
     */
    public void registerClientPool(AnzoClientPool clientPool);

    /**
     * ClientPool is no longer available
     * 
     * @param clientPool
     *            the no longer available client pool
     */
    public void unregisterClientPool(AnzoClientPool clientPool);
}
