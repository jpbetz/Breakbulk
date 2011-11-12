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
package org.openanzo.datasource.manager.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.osgi.framework.console.CommandProvider;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.datasource.manager.IDatasourceManager;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.execution.java.IBundledSemanticService;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.ontologies.system.Datasource;
import org.openanzo.ontologies.system.SystemFactory;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.osgi.registry.IRegistryProvider;
import org.openanzo.osgi.registry.RegistryDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.Collections;
import org.openanzo.services.IStatisticsProvider;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for the DatasourceManager
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DatasourceManagerActivator extends ConfiguredServiceActivator implements IDatasourceManager {
    private static final Logger                       log                  = LoggerFactory.getLogger(DatasourceManagerActivator.class);

    private OsgiServiceTracker<IDatasource>           datasourceTracker    = null;

    private final ConcurrentHashMap<URI, IDatasource> datasources          = new ConcurrentHashMap<URI, IDatasource>();

    /** Service PID for the DatasourceManager */
    public static final String                        SERVICE_PID          = "org.openanzo.datasource.DatasourceManager";

    private RegistryDataset                           registry             = null;

    private org.openanzo.ontologies.openanzo.Dataset  registryDataset      = null;

    private IDatasourceListener                       resetListener        = null;

    private InitResourceListener                      initResourceListener = null;

    GenericObjectClassDef                             classDef;

    DatasourceService                                 service;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled }, null));
    }

    private ReentrantLock resetLock = new ReentrantLock();

    private boolean       resetting = false;

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { IRegistryProvider.class.getName() };
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);
        context.registerService(new String[] { CommandProvider.class.getName() }, new DatasourceManagerCommand(this), null);
    }

    @Override
    public void start() {
        try {
            resetListener = new RegistryResetListener();
            registry = getDependency(IRegistryProvider.class).openRegistry(DATASOURCE_REGISTRY_URI, "DatasourceManagerActivator");
            registry.registerDatasourceListener(resetListener);
        } catch (AnzoException ae) {
            log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error starting datasource manager", ae);
        }
        setupRegistry();
        Properties props = new Properties();
        props.put(org.osgi.framework.Constants.SERVICE_PID, SERVICE_PID);
        props.put(org.osgi.framework.Constants.SERVICE_DESCRIPTION, "Datasource Manager/Registry");
        context.registerService(IDatasourceManager.class.getName(), this, props);
        datasourceTracker = new OsgiServiceTracker<IDatasource>(new IServiceTrackerListener<IDatasource>() {

            public void unregisterService(IDatasource datasource) {
                unregisterDatasource(datasource);
            }

            public void registerService(IDatasource datasource) {
                if (!resetting) {
                    registerDatasource(datasource);
                } else {
                    datasources.put(datasource.getInstanceURI(), datasource);
                }
            }

            public Class<IDatasource> getComponentType() {
                return IDatasource.class;
            }
        }, context);
        datasourceTracker.open();
        initResourceListener = new InitResourceListener(context, getDependency(IRegistryProvider.class));
        log.debug(LogUtils.DATASOURCE_MARKER, "Registering datasource service");
        service = new DatasourceService(this, ServicesDictionary.getUser(configProperties, null));
        context.registerService(new String[] { IBundledSemanticService.class.getName(), IStatisticsProvider.class.getName() }, service, null);
    }

    private void setupRegistry() {
        resetLock.lock();
        try {
            registry.beginUpdatingRegistry();
            registryDataset = AnzoFactory.createDataset(DATASOURCE_REGISTRY_URI, registry);
            for (IDatasource datasource : datasources.values()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "setting up registry for : " + datasource.getInstanceURI() + " " + datasource.isSelfDescribing());
                if (datasource.isSelfDescribing()) {
                    if (!registry.contains(DATASOURCE_REGISTRY_URI, Dataset.namedGraphProperty, datasource.getInstanceURI(), DATASOURCE_REGISTRY_URI)) {
                        log.debug(LogUtils.DATASOURCE_MARKER, "Adding datasource to registry:  " + datasource.getInstanceURI());
                        INamedGraph capabilities = datasource.getCapabilities();
                        Datasource datasourceComp = SystemFactory.createDatasource(datasource.getInstanceURI(), datasource.getInstanceURI(), registry);
                        datasourceComp.setIsPrimary(datasource.isPrimary());
                        if (capabilities != null) {
                            datasourceComp.graph().add(capabilities.getStatements());
                        }
                        registryDataset.addNamedGraph(datasource.getInstanceURI());
                    }
                }
            }
            registry.commitRegistry();
        } catch (AnzoException ae) {
            if (registry.inTransaction()) {
                registry.abortRegistry();
            }
            log.error(LogUtils.DATASOURCE_MARKER, "Error setting up datasource manager registry", ae);
        } finally {
            resetLock.unlock();
        }

    }

    @Override
    public void stop(boolean bundleStopping) {
        if (datasourceTracker != null) {
            datasourceTracker.close();
            datasourceTracker = null;
        }
        if (initResourceListener != null) {
            initResourceListener.stop(bundleStopping);
            initResourceListener = null;
        }
    }

    public IDatasource getDatasource(URI datasourceURI) {
        IDatasource ds = datasources.get(datasourceURI);
        if (ds == null) {
            log.debug(LogUtils.DATASOURCE_MARKER, "Datasource is null for:" + datasourceURI + ":" + Arrays.toString(datasources.keySet().toArray()));
        }
        return ds;
    }

    public Collection<IDatasource> getDatasources() {
        return Collections.copyCollection(datasources.values());
    }

    private void registerDatasource(IDatasource datasource) {
        resetLock.lock();
        try {
            log.debug(LogUtils.DATASOURCE_MARKER, "Registering datasource: " + datasource.getInstanceURI());
            datasources.put(datasource.getInstanceURI(), datasource);
            if (datasource.isSelfDescribing()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Datasource: " + datasource.getInstanceURI() + ": is self describing");
                if (!registry.contains(DATASOURCE_REGISTRY_URI, Dataset.namedGraphProperty, datasource.getInstanceURI(), DATASOURCE_REGISTRY_URI)) {
                    try {
                        log.debug(LogUtils.DATASOURCE_MARKER, "Adding datasource to registry (osgi event) : " + datasource.getInstanceURI());
                        registry.beginUpdatingRegistry();
                        INamedGraph capabilities = datasource.getCapabilities();
                        Datasource datasourceComp = SystemFactory.createDatasource(datasource.getInstanceURI(), datasource.getInstanceURI(), registry);
                        datasourceComp.setIsPrimary(datasource.isPrimary());
                        if (capabilities != null) {
                            datasourceComp.graph().add(capabilities.getStatements());
                        }
                        registryDataset.addNamedGraph(datasource.getInstanceURI());
                        registry.commitRegistry();
                    } catch (AnzoException ae) {
                        log.error(LogUtils.DATASOURCE_MARKER, "Error registring datasource with manager:" + datasource.getInstanceURI(), ae);
                        if (registry.inTransaction()) {
                            registry.abortRegistry();
                        }
                    }
                } else {
                    log.debug(LogUtils.DATASOURCE_MARKER, "Datasource already in registry:" + datasource.getInstanceURI());
                }
            }
        } finally {
            resetLock.unlock();
        }
    }

    @Override
    public String getExtraStatus(boolean html) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        if (html) {
            pw.println("<h4><font color='#00cc00'>Registered Datasources:</font></h4>");
            for (URI ds : datasources.keySet()) {
                pw.println("<li>" + ds.toString() + "</li>");
            }
        } else {
            pw.println("Registered Datasources:");
            for (URI ds : datasources.keySet()) {
                pw.println(ds.toString());
            }
        }
        pw.flush();
        sw.flush();
        return sw.toString();
    }

    private void unregisterDatasource(IDatasource datasource) {
        resetLock.lock();
        try {
            log.debug(LogUtils.DATASOURCE_MARKER, "Unregisterring datasource: " + datasource.getInstanceURI());
            datasources.remove(datasource.getInstanceURI());
        } finally {
            resetLock.unlock();
        }
    }

    class RegistryResetListener implements IDatasourceListener {
        public void resetStarting() throws AnzoException {
            resetting = true;
        }

        public void reset() throws AnzoException {
        }

        public void postReset() throws AnzoException {
        }

        public void resetFinished() throws AnzoException {
            setupRegistry();
            resetting = false;
        }
    }

    @Override
    public boolean registerFrameworkStoppingListener() {
        return true;
    }

    @Override
    protected void frameworkStopping() {
        stop(false);
    }
}
