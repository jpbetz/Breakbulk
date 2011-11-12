/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 7, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi;

/**
 * Service that provides status info to other tools, like status servlet
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IStatusProvider {
    /**
     * Get the current status for this service
     * 
     * @param html
     *            true if format of status should be in html
     * @return current status for this service
     */
    public String getCurrentStatus(boolean html);

    /**
     * Get the state for this service
     * 
     * @return the state for this service
     */
    public ServiceLifecycleState getState();
}
