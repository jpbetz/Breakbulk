/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import org.openanzo.exceptions.AnzoException;

/**
 * Reader that can read IUpdateResults and pass the contents to an IUpdatesHandler
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IUpdatesReader {
    /**
     * Read data and pass contents to handler
     * 
     * @param handler
     *            handler to handle parsed data
     * @throws AnzoException
     */
    void read(final IUpdatesHandler handler) throws AnzoException;
}
