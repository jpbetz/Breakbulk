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
package org.openanzo.osgi.registry.internal;

import java.util.List;
import java.util.Set;

import org.openanzo.client.pool.AnzoClientPool;
import org.openanzo.datasource.DatasourceDictionary;
import org.openanzo.datasource.attributes.DatasourceAttributes;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.osgi.registry.IRegistryProvider;
import org.openanzo.rdf.URI;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class RegistryActivator extends ConfiguredServiceActivator {
    private static final Logger                log               = LoggerFactory.getLogger(RegistryActivator.class);

    private RegistryProvider                   provider          = null;

    private ServiceRegistration                serviceReg        = null;

    private OsgiServiceTracker<AnzoClientPool> clientPoolTracker = null;

    protected AnzoClientPool                   clientPool        = null;

    private URI                                datasourceURI     = null;

    private RegistryManifestLoader             manifestLoader    = null;

    GenericObjectClassDef                      classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(RegistryProvider.SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled, DatasourceAttributes.DatasourceURI }, null));
    }

    @Override
    public String getServicePid() {
        return RegistryProvider.SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[0];
    }

    @Override
    public boolean registerFrameworkStoppingListener() {
        return true;
    }

    @Override
    protected void frameworkStopping() {
        stop(false);
    }

    @Override
    public void configurationPropertiesSet(Set<String> changedProperties) throws ConfigurationException {
        datasourceURI = org.openanzo.rdf.Constants.valueFactory.createURI(DatasourceDictionary.getDatasourceURI(getConfigProperties()));
        if (clientPoolTracker == null) {
            IServiceTrackerListener<AnzoClientPool> listener = new IServiceTrackerListener<AnzoClientPool>() {

                public void unregisterService(AnzoClientPool service) {// NO_UCD
                    clientPool = null;
                    stopLocked(false);
                }

                public void registerService(AnzoClientPool service) { // NO_UCD
                    clientPool = service;
                    if (isInitialized()) {
                        startLocked();
                    }
                }

                public Class<AnzoClientPool> getComponentType() {
                    return AnzoClientPool.class;
                }

            };
            String dsFilter = "(&(" + DatasourceDictionary.KEY_DATASOURCE_URI + "=" + datasourceURI.toString() + ")(" + Constants.OBJECTCLASS + "=" + listener.getComponentType().getName() + "))";
            try {
                Filter filter = context.createFilter(dsFilter);
                clientPoolTracker = new OsgiServiceTracker<AnzoClientPool>(listener, filter, context);
                clientPoolTracker.open();
            } catch (InvalidSyntaxException sfe) {
                log.error(LogUtils.LIFECYCLE_MARKER, Messages.formatString(ExceptionConstants.OSGI.INVALID_SERVICE_SYNTAX, dsFilter), sfe);
                throw new ConfigurationException("Filter", Messages.formatString(ExceptionConstants.OSGI.INVALID_SERVICE_SYNTAX, dsFilter), sfe);
            }
        }
    }

    @Override
    public boolean isInitialized() {
        return super.isInitialized() && clientPool != null;
    }

    @Override
    public void start() {
        provider = new RegistryProvider(configProperties, clientPool);
        manifestLoader = new RegistryManifestLoader(context, clientPool, provider);
        manifestLoader.open();
        serviceReg = context.registerService(IRegistryProvider.class.getName(), provider, null);
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (provider != null) {
            provider.close();
            provider = null;
        }
        if (!bundleStopping && serviceReg != null) {
            serviceReg.unregister();
            serviceReg = null;
        }
        if (!bundleStopping) {
            manifestLoader.close(bundleStopping);
        }
    }

    @Override
    public List<String> getOkServices() {
        List<String> list = super.getOkServices();
        if (clientPool != null) {
            list.add(AnzoClientPool.class.getName());
        }
        return list;
    }

    @Override
    public List<String> getWaitingServices() {
        List<String> list = super.getWaitingServices();
        if (clientPool == null) {
            list.add(AnzoClientPool.class.getName());
        }
        return list;
    }
}
