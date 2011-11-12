/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Aug 16, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services;

/**
 * Implementing classes provide update events
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IUpdatesProvider {
    /**
     * Register update result listener
     * 
     * @param listener
     *            listener to register
     */
    public void registerUpdatesListener(IUpdateResultListener listener);

    /**
     * Unregister update result listener
     * 
     * @param listener
     *            listener to unregister
     */
    public void unregisterUpdatesListener(IUpdateResultListener listener);
}
