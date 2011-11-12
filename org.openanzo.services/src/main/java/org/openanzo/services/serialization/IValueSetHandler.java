/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 8, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.IOException;

/**
 * Callback handler used for methods that return sets of T
 * 
 * @param <T>
 *            Type of object to handle
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
public interface IValueSetHandler<T> {
    //TODO: Should this throw AnzoException
    /**
     * Handle an object
     * 
     * @param value
     *            object to handle
     * @throws IOException
     *             if there was a problem handling the value
     */
    public void handleValue(T value) throws IOException;

    /**
     * Start handling a new set
     * 
     * @throws IOException
     */
    public void start() throws IOException;

    /**
     * Finished handling the set
     * 
     * @throws IOException
     */
    public void end() throws IOException;
}
