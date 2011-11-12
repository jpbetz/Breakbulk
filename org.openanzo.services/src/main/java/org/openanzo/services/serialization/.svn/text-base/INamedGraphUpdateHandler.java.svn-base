/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/

package org.openanzo.services.serialization;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.INamedGraphUpdate;

/**
 * 
 * Used by client components to process named graph updates. Implements of this interface must use contextual information to determine if the contents of the
 * update are meant to update or completely replace the existing statements.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface INamedGraphUpdateHandler {
    /**
     * Handling updates starting
     * 
     * @throws AnzoException
     */
    public void start() throws AnzoException;

    /**
     * Handling updates finished
     * 
     * @throws AnzoException
     */
    public void end() throws AnzoException;

    /**
     * Handle a namedGraphUpdate
     * 
     * @param namedGraphUpdate
     *            update about a namedgraph
     * @return true if handled
     * @throws AnzoException
     */
    public boolean handleNamedGraphUpdate(INamedGraphUpdate namedGraphUpdate) throws AnzoException;

}
