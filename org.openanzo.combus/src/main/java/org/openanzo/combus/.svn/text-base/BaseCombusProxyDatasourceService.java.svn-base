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
package org.openanzo.combus;

import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IDatasourceComponent;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.ServicesProperties;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
abstract public class BaseCombusProxyDatasourceService extends BaseCombusProxyService implements IDatasourceComponent {
    private final CombusDatasource datasource;

    /**
     * @param datasource
     *            Datasource to which this service belongs
     * 
     * @param combusConnection
     *            Connection which this proxy class uses to communicate to the server
     */
    public BaseCombusProxyDatasourceService(CombusDatasource datasource, CombusConnection combusConnection) {
        super(combusConnection);
        this.datasource = datasource;
        String timeout = datasource.getProperties().getProperty(ServicesProperties.KEY_SERVICE_TIMEOUT + "." + getName());
        if (timeout != null) {
            setTimeout(Long.parseLong(timeout));
        } else {
            setTimeout(ServicesProperties.getTimeout(datasource.getProperties(), 60000));
        }
    }

    public void close() throws AnzoException {
    }

    public IDatasource getDatasource() {
        return datasource;
    }

    public void reset() throws AnzoException {
    }

    public void start() throws AnzoException {
    }

    public void logEntry() {
    }

    public void logExit() {
    }
}
