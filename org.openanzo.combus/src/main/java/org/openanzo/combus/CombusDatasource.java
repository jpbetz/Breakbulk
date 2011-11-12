/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 16, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus;

import java.util.Properties;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.openanzo.combus.proxy.CombusAuthorizationServiceProxy;
import org.openanzo.combus.proxy.CombusIndexServiceProxy;
import org.openanzo.combus.proxy.CombusModelServiceProxy;
import org.openanzo.combus.proxy.CombusResetServiceProxy;
import org.openanzo.combus.proxy.CombusUpdateServiceProxy;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.datasource.IServerQuadStoreProvider;
import org.openanzo.datasource.services.BaseDatasource;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CombusDatasource extends BaseDatasource {
    /** Service's Name in {@link String} form */
    private static final String                        DATASOURCE_NAME = NAMESPACES.DATASOURCE_PREFIX + "CombusDatasource";

    /** Service's Name in {@link URI} form */
    private static final URI                           DATASOURCE_URI  = Constants.valueFactory.createURI(DATASOURCE_NAME);

    private final CombusAuthorizationServiceProxy      authorizationService;

    private final CombusModelServiceProxy              modelService;

    private final CombusUpdateServiceProxy             updateService;

    private final CombusIndexServiceProxy              indexService;

    private final CombusBatchedQueryServiceProxy       queryService;

    private final CombusBatchedReplicationServiceProxy replicationService;

    private final CombusResetServiceProxy              resetService;

    private final ReentrantReadWriteLock               resetLock       = new ReentrantReadWriteLock();

    private final Properties                           properties;

    /**
     * Datasource which talks over a combus connection for its operations
     * 
     * @param properties
     *            Configuration properties
     * @param combusConnection
     */
    public CombusDatasource(Properties properties, CombusConnection combusConnection) {
        super(DATASOURCE_URI, true, null, false, false);
        this.properties = properties;
        authorizationService = new CombusAuthorizationServiceProxy(this, combusConnection);
        modelService = new CombusModelServiceProxy(this, combusConnection);
        updateService = new CombusUpdateServiceProxy(this, combusConnection);
        indexService = new CombusIndexServiceProxy(this, combusConnection);
        queryService = new CombusBatchedQueryServiceProxy(this, combusConnection);
        replicationService = new CombusBatchedReplicationServiceProxy(this, combusConnection);
        resetService = new CombusResetServiceProxy(this, combusConnection);
    }

    /*   public void start() throws AnzoException {
           authorizationService.start();
           modelService.start();
           updateService.start();
           indexService.start();
           queryService.start();
           replicationService.start();
           resetService.start();
       }*/

    public CombusAuthorizationServiceProxy getAuthorizationService() {
        return authorizationService;
    }

    public CombusIndexServiceProxy getIndexService() {
        return indexService;
    }

    public CombusModelServiceProxy getModelService() {
        return modelService;
    }

    public CombusBatchedQueryServiceProxy getQueryService() {
        return queryService;
    }

    public CombusBatchedReplicationServiceProxy getReplicationService() {
        return replicationService;
    }

    public CombusResetServiceProxy getResetService() {
        return resetService;
    }

    public CombusUpdateServiceProxy getUpdateService() {
        return updateService;
    }

    public IServerQuadStoreProvider getServerQuadStoreProvider() {
        return null;
    }

    public String getName() {
        return "CombusDatasource";
    }

    @Override
    public void registerDatasourceListener(IDatasourceListener listener) {
    }

    @Override
    public void unregisterDatasourceListener(IDatasourceListener listener) {
    }

    @Override
    public ReentrantReadWriteLock getLockProvider() {
        return resetLock;
    }

    public boolean isSelfDescribing() {
        return false;
    }

    /**
     * @return the properties
     */
    public Properties getProperties() {
        return properties;
    }
}
