/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 4, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi;

/**
 * Listener for events about given service being registered with OSGI
 * 
 * @param <S>
 *            service type
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IServiceTrackerListener<S> {
    /**
     * Get the type for this component
     * 
     * @return the type for this component
     */
    Class<S> getComponentType();

    /**
     * Service was registered
     * 
     * @param service
     *            registered service
     */
    void registerService(S service);

    /**
     * Service was unregistered
     * 
     * @param service
     *            unregistered service
     */
    void unregisterService(S service);
}
