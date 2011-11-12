/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 15, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi.registry;

import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.URI;

/**
 * A Registry provider provides the ability to open registries and add listeners to the over registry provider
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IRegistryProvider {
    /**
     * Open a registry with the given URI
     * 
     * @param registryURI
     *            URI of registry
     * @param userDescription
     *            description of service/user opening registry
     * @return RegistryDataset for given URI
     * @throws AnzoException
     */
    public RegistryDataset openRegistry(URI registryURI, String userDescription) throws AnzoException;

    /**
     * Registry a datasource listener
     * 
     * @param datasourceListener
     *            listener to register
     */
    public void registerDatasourceListener(IDatasourceListener datasourceListener);

    /**
     * Unregister a datasource listener
     * 
     * @param datasourceListener
     *            listener to unregister
     */
    public void unregisterDatasourceListener(IDatasourceListener datasourceListener);

}
