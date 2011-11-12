/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 7, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.IOperationContext;

/**
 * Classes that can process updates implement so that classes can get a server quad store on which to send updates
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IServerQuadStoreProvider {
    /**
     * Get a new IServerQuadStore for the given context
     * 
     * @param context
     *            context for update operation
     * @return new IServerQuadStore
     * @throws AnzoException
     */
    IServerQuadStore getServerQuadStore(IOperationContext context) throws AnzoException;

    /**
     * Close the given quad store
     * @param store
     *            quad store to close
     * 
     * @throws AnzoException
     */
    void closeServerQuadStore(IServerQuadStore store) throws AnzoException;
}
