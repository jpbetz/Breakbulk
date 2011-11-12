/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Aug 15, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.manager;

import java.util.Collection;

import org.openanzo.datasource.IDatasource;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * The datasource manager keeps track of the registered datasources in the system, so that other services don't need to manage them independently
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IDatasourceManager {
    /** The URI for a registry containing references to all the registered datasources */
    public static final URI DATASOURCE_REGISTRY_URI = Constants.valueFactory.createURI(NAMESPACES.PREFIX + "/registries/Datasources");

    /**
     * Get a datasource with the given instance URI
     * 
     * @param datasourceURI
     *            instance URI of datasource to retrieve
     * @return datasource for given instance URI
     */
    public IDatasource getDatasource(URI datasourceURI);

    /**
     * Get set of all datasource registered
     * 
     * @return set of all datasource registered
     */
    public Collection<IDatasource> getDatasources();
}
