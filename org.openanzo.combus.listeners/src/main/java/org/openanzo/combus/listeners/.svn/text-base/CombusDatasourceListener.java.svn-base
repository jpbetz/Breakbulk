/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 4, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus.listeners;

import org.openanzo.combus.endpoint.BaseServiceListener;
import org.openanzo.combus.endpoint.ICombusEndpointListener;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IQueryService;
import org.openanzo.datasource.services.BaseQueryService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IAuthenticationService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CombusDatasourceListener {
    protected static final Logger              log                              = LoggerFactory.getLogger(CombusDatasourceListener.class);

    private final BundleContext                context;

    private final IDatasource                  datasource;

    private CombusAuthorizationServiceListener authorizationService;

    private ServiceRegistration                authorizationServiceRegistration = null;

    private CombusIndexServiceListener         indexService;

    private ServiceRegistration                indexServiceRegistration         = null;

    private CombusModelServiceListener         modelService;

    private ServiceRegistration                modelServiceRegistration         = null;

    private BaseServiceListener                queryService;

    private ServiceRegistration                queryServiceRegistration         = null;

    private CombusReplicationServiceListener   replicationService;

    private ServiceRegistration                replicationServiceRegistration   = null;

    private CombusResetServiceListener         resetService;

    private ServiceRegistration                resetServiceRegistration         = null;

    private CombusUpdateServiceListener        updateService;

    private ServiceRegistration                updateServiceRegistration        = null;

    CombusDatasourceListener(BundleContext context, IDatasource datasource) {
        this.datasource = datasource;
        this.context = context;
    }

    void initialize(IAuthenticationService authenticationService) {

        String queueNamePrefix = null;
        if (!datasource.isPrimary()) {
            try {
                queueNamePrefix = UriGenerator.generateEncapsulatedString("", datasource.getInstanceURI().toString()) + "/";
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error generating queue name for datasource:" + datasource.getInstanceURI().toString(), ae);
                throw new AnzoRuntimeException(ae);
            }
        }

        try {
            if (datasource.getAuthorizationService() != null) {
                authorizationService = new CombusAuthorizationServiceListener(authenticationService, datasource.getAuthorizationService(), queueNamePrefix);
                authorizationService.start();
                authorizationServiceRegistration = context.registerService(new String[] { ICombusEndpointListener.class.getName() }, authorizationService, null);
            }
            if (datasource.getIndexService() != null) {
                indexService = new CombusIndexServiceListener(authenticationService, datasource.getIndexService(), queueNamePrefix);
                indexService.start();
                indexServiceRegistration = context.registerService(new String[] { ICombusEndpointListener.class.getName() }, indexService, null);
            }
            if (datasource.getModelService() != null) {
                modelService = new CombusModelServiceListener(authenticationService, datasource.getModelService(), queueNamePrefix);
                modelService.start();
                modelServiceRegistration = context.registerService(new String[] { ICombusEndpointListener.class.getName() }, modelService, null);
            }
            if (datasource.getQueryService() != null) {
                IQueryService service = datasource.getQueryService();
                if (service instanceof BaseQueryService) {
                    queryService = new BatchedCombusQueryServiceListener(authenticationService, (BaseQueryService) service, queueNamePrefix);
                    queryService.start();
                    queryServiceRegistration = context.registerService(new String[] { ICombusEndpointListener.class.getName() }, queryService, null);
                } else {
                    queryService = new CombusQueryServiceListener(authenticationService, service, queueNamePrefix);
                    queryService.start();
                    queryServiceRegistration = context.registerService(new String[] { ICombusEndpointListener.class.getName() }, queryService, null);

                }
            }
            if (datasource.getReplicationService() != null) {
                replicationService = new CombusReplicationServiceListener(authenticationService, datasource.getReplicationService(), queueNamePrefix);
                replicationService.start();
                replicationServiceRegistration = context.registerService(new String[] { ICombusEndpointListener.class.getName() }, replicationService, null);
            }
            if (datasource.getResetService() != null) {
                resetService = new CombusResetServiceListener(authenticationService, datasource.getResetService(), queueNamePrefix);
                resetService.start();
                resetServiceRegistration = context.registerService(new String[] { ICombusEndpointListener.class.getName() }, resetService, null);
            }
            if (datasource.getUpdateService() != null) {
                updateService = new CombusUpdateServiceListener(authenticationService, datasource.getUpdateService(), queueNamePrefix);
                updateService.start();
                updateServiceRegistration = context.registerService(new String[] { ICombusEndpointListener.class.getName() }, updateService, null);
            }
        } catch (AnzoException ae) {
            log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error setting up datasources combus listeners:" + datasource.getInstanceURI().toString(), ae);
            throw new AnzoRuntimeException(ae);
        }
    }

    protected void close() {
        if (authorizationServiceRegistration != null) {
            authorizationServiceRegistration.unregister();
            try {
                authorizationService.stop();
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error stopping authorization service listener", ae);
            }
        }
        if (indexServiceRegistration != null) {
            indexServiceRegistration.unregister();
            try {
                indexService.stop();
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error stopping index service listener", ae);
            }
        }
        if (modelServiceRegistration != null) {
            modelServiceRegistration.unregister();
            try {
                modelService.stop();
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error stopping model service listener", ae);
            }
        }
        if (queryServiceRegistration != null) {
            queryServiceRegistration.unregister();
            try {
                queryService.stop();
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error stopping query service listener", ae);
            }
        }
        if (replicationServiceRegistration != null) {
            replicationServiceRegistration.unregister();
            try {
                replicationService.stop();
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error stopping replication service listener", ae);
            }
        }
        if (resetServiceRegistration != null) {
            resetServiceRegistration.unregister();
            try {
                resetService.stop();
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error stopping reset service listener", ae);
            }
        }
        if (updateServiceRegistration != null) {
            updateServiceRegistration.unregister();
            try {
                updateService.stop();
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error stopping update service listener", ae);
            }
        }
    }
}
