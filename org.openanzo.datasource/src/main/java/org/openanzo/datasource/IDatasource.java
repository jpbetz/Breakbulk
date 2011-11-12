/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  May 30, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.URI;

/**
 * Datasource is the overall datasource container that exposes a set of services that interact with the datasource
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IDatasource {
    /**
     * Get name for this datasource
     * 
     * @return name
     */
    String getName();

    /**
     * Get a graph containing the description of the datasources capabilities
     * 
     * @return the capabilities graph
     */
    INamedGraph getCapabilities();

    /**
     * Return true if the capabilities graph provided by getCapabilities can be used to instantiate this datasource in the registry.
     * 
     * @return true if the capabilities graph provided by getCapabilities can be used to instantiate this datasource in the registry.
     */
    boolean isSelfDescribing();

    /**
     * Get datasource's Instance URI
     * 
     * @return URI of datasource
     */
    URI getInstanceURI();

    /**
     * Returns true if this datasource is the primary datasource as defined in the configuration.
     * 
     * @return true if this datasource is the primary datasource as defined in the configuration.
     */
    boolean isPrimary();

    /**
     * Get the datasource's model service
     * 
     * @return the datasource's model service
     * 
     */
    IModelService getModelService();

    /**
     * Get the datasource's update service
     * 
     * @return the datasource's update service
     * 
     */
    IUpdateService getUpdateService();

    /**
     * Get the datasource's replication service
     * 
     * @return the datasource's replication service
     * 
     */
    IReplicationService getReplicationService();

    /**
     * Get the datasource's query service
     * 
     * @return the datasource's query service
     * 
     */
    IQueryService getQueryService();

    /**
     * Get the datasource's index service
     * 
     * @return the datasource's index service
     * 
     */
    IIndexService getIndexService();

    /**
     * Get the datasource's reset service
     * 
     * @return the datasource's reset service
     * 
     */
    IResetService getResetService();

    /**
     * Get the IServerQuadStoreProvider for the datasource
     * 
     * @return IServerQuadStoreProvider for the datasource
     */
    IServerQuadStoreProvider getServerQuadStoreProvider();

    /**
     * Get the datasource's implementation of a service for the given interface
     * 
     * @param <ServiceType>
     *            Type of service to retreieve
     * @param clazz
     *            class type
     * @return Instance of the service requested
     */
    <ServiceType> ServiceType getService(Class<ServiceType> clazz);

    /**
     * Get the datasource's authorization service
     * 
     * @return the datasource's authorization service
     * 
     */
    IAuthorizationService getAuthorizationService();

    /**
     * Register a datasource listener
     * 
     * @param listener
     *            listener to register
     */
    void registerDatasourceListener(IDatasourceListener listener);

    /**
     * Unregister a datasource listener
     * 
     * @param listener
     *            listener to unregister
     */
    void unregisterDatasourceListener(IDatasourceListener listener);

    /**
     * Get the lock provider for the datasource
     * 
     * @return the lock provider for the datasource
     */
    abstract public ReentrantReadWriteLock getLockProvider();

    /**
     * Execute a special command against the datasource
     * 
     * @param command
     * @param request
     * @param response
     * @throws AnzoException
     */
    abstract public void executeCommand(String command, IDataset request, IDataset response) throws AnzoException;
}
