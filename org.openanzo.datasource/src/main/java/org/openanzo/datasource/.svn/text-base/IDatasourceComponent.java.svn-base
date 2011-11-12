/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Aug 26, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.IStatisticsProvider;

/**
 * Interface for the different components that make up a datasource
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IDatasourceComponent extends IStatisticsProvider {
    /**
     * Parent datasource for component
     * 
     * @return the parent datasource for the component
     */
    abstract IDatasource getDatasource();

    /**
     * Reset the component
     * 
     * @throws AnzoException
     */
    abstract public void reset() throws AnzoException;

    /**
     * Start the component
     * 
     * @throws AnzoException
     */
    abstract public void start() throws AnzoException;

    /**
     * Close the component
     * 
     * @throws AnzoException
     */
    abstract public void close() throws AnzoException;

    /**
     * Called at start of service call
     */
    abstract void logEntry();

    /**
     * Called at end of service call
     */
    abstract void logExit();

}
