/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 23, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.openanzo.datasource.IDatasourceComponent;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.utils.SerializationConstants;
import org.slf4j.MDC;

/**
 * Base Datasource component
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
abstract public class BaseDatasourceComponent implements IDatasourceComponent {
    public void close() throws AnzoException {
    }

    /**
     * Set the MDC datasource uri
     */
    public void logEntry() {
        MDC.put(SerializationConstants.datasourceURI, getDatasource().getInstanceURI().toString());
    }

    /**
     * Remove the MDC datasource URI
     */
    public void logExit() {
        MDC.remove(SerializationConstants.datasourceURI);
    }

    /**
     * Get the lock provider for the parent datasource
     * 
     * @return the lock provider for the parent datasource
     */
    public ReentrantReadWriteLock getLockProvider() {
        return getDatasource().getLockProvider();
    }

}
