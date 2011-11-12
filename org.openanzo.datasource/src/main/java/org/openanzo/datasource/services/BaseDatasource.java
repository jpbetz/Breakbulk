/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 14, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.openanzo.datasource.DatasourceDictionary;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.datasource.IIndexService;
import org.openanzo.datasource.IModelService;
import org.openanzo.datasource.IQueryService;
import org.openanzo.datasource.IReplicationService;
import org.openanzo.datasource.IResetService;
import org.openanzo.datasource.IServerQuadStoreProvider;
import org.openanzo.datasource.IUpdateService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.ontologies.system.Datasource;
import org.openanzo.ontologies.system.SystemFactory;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.URI;
import org.openanzo.services.IStatisticsProvider;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base datasource
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
abstract public class BaseDatasource implements IDatasource {
    protected static final Logger                             log                  = LoggerFactory.getLogger(BaseDatasource.class);

    protected org.openanzo.rdf.INamedGraph                    capabilities;

    protected final CopyOnWriteArrayList<IDatasourceListener> listeners            = new CopyOnWriteArrayList<IDatasourceListener>();

    protected URI                                             instanceURI;

    protected Collection<String>                              uriPatterns;

    protected boolean                                         isPrimary            = false;

    ReentrantReadWriteLock                                    lock                 = new ReentrantReadWriteLock();

    protected final ArrayList<ServiceRegistration>            serviceRegistrations = new ArrayList<ServiceRegistration>();

    protected boolean                                         enableCaching        = true;

    protected boolean                                         resetEnabled         = false;

    /**
     * Create base datasource with given instance uri
     * 
     * @param instanceURI
     *            instanceuri for datasource
     * @param isPrimary
     *            is this the primary datasource
     */
    public BaseDatasource(URI instanceURI, boolean isPrimary, Collection<String> uriPatterns, boolean enableCaching, boolean resetEnabled) {
        constructor(instanceURI, isPrimary, uriPatterns, enableCaching, resetEnabled);
    }

    /**
     * Create base datasource based on configuration properties
     * 
     * @param configProperties
     *            the configuration properties for the datasource
     */
    public BaseDatasource(Dictionary<? extends Object, ? extends Object> configProperties) {
        String iu = ServicesDictionary.getInstanceURI(configProperties);
        Boolean isPrimary = DatasourceDictionary.getIsPrimary(configProperties);
        Boolean ec = DatasourceDictionary.getEnableCaching(configProperties, true);
        Boolean resetEnabledObj = DatasourceDictionary.getResetEnabled(configProperties);
        Collection<String> patterns = new ArrayList<String>();
        String patternString = DatasourceDictionary.getUriPatterns(configProperties);
        if (patternString != null) {
            StringTokenizer st = new StringTokenizer(patternString, ",");
            while (st.hasMoreElements()) {
                String pattern = st.nextToken();
                patterns.add(pattern);
            }
        }
        constructor(iu != null ? Constants.valueFactory.createURI(iu) : null, isPrimary != null ? isPrimary : false, patterns, ec != null ? ec.booleanValue() : true, resetEnabledObj != null ? resetEnabledObj.booleanValue() : false);
    }

    /**
     * 
     */
    public BaseDatasource() {
    }

    protected void constructor(URI instanceURI, boolean isPrimary, Collection<String> uriPatterns, boolean enableCaching, boolean resetEnabled) {
        this.instanceURI = instanceURI;
        this.isPrimary = isPrimary;
        this.enableCaching = enableCaching;
        this.resetEnabled = resetEnabled;
        this.uriPatterns = uriPatterns;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    /**
     * Setup the capabilities graph based on the configuration properties
     */
    public void setupCapabilities() {
        if (capabilities == null) {
            capabilities = new NamedGraph(getInstanceURI());
            Datasource datasource = SystemFactory.createDatasource(getInstanceURI(), capabilities);
            datasource.setIsPrimary(isPrimary());
            for (String pattern : uriPatterns) {
                datasource.addUriPattern(pattern);
            }
        }
    }

    public URI getInstanceURI() {
        return instanceURI;
    }

    public void registerDatasourceListener(IDatasourceListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unregisterDatasourceListener(IDatasourceListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notify the listeners that reset is starting
     */
    public void resetStarting() {
        for (IDatasourceListener listener : listeners) {
            try {
                listener.resetStarting();
            } catch (Throwable t) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error in listener's reset starting", t);
            }
        }
    }

    /**
     * Notify the listeners to do their reset code
     */
    public void reset() {
        for (IDatasourceListener listener : listeners) {
            try {
                listener.reset();
            } catch (Throwable t) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error in listener's reset", t);
            }
        }
    }

    /**
     * Notify the listeners that reset is finished
     */
    public void postReset() {
        for (IDatasourceListener listener : listeners) {
            try {
                listener.postReset();
            } catch (Throwable t) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error in listener's post reset", t);
            }
        }
    }

    /**
     * Notify the listeners that reset is finished
     */
    public void resetFinished() {
        for (IDatasourceListener listener : listeners) {
            try {
                listener.resetFinished();
            } catch (Throwable t) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error in listener's reset finished", t);
            }
        }
    }

    public INamedGraph getCapabilities() {
        return capabilities;
    }

    @SuppressWarnings("unchecked")
    public <ServiceType> ServiceType getService(Class<ServiceType> clazz) {
        if (clazz.equals(IAuthorizationService.class)) {
            return (ServiceType) getAuthorizationService();
        } else if (clazz.equals(IModelService.class)) {
            return (ServiceType) getModelService();
        } else if (clazz.equals(IUpdateService.class)) {
            return (ServiceType) getUpdateService();
        } else if (clazz.equals(IReplicationService.class)) {
            return (ServiceType) getReplicationService();
        } else if (clazz.equals(IResetService.class)) {
            return (ServiceType) getResetService();
        } else if (clazz.equals(IQueryService.class)) {
            return (ServiceType) getQueryService();
        } else if (clazz.equals(IIndexService.class)) {
            return (ServiceType) getIndexService();
        } else if (clazz.equals(IServerQuadStoreProvider.class)) {
            return (ServiceType) getServerQuadStoreProvider();
        } else {

            throw new RuntimeException("Unknown service type requested");
        }
    }

    public ReentrantReadWriteLock getLockProvider() {
        return lock;
    }

    /**
     * Setup the statistics objects and register with OSGI
     * 
     * @param context
     *            bundlecontex for datasource
     */
    public void setupStats(BundleContext context) {
        if (getModelService() != null) {
            serviceRegistrations.add(context.registerService(IStatisticsProvider.class.getName(), getModelService(), null));
        }
        if (getUpdateService() != null) {
            serviceRegistrations.add(context.registerService(IStatisticsProvider.class.getName(), getUpdateService(), null));
        }
        if (getResetService() != null) {
            serviceRegistrations.add(context.registerService(IStatisticsProvider.class.getName(), getResetService(), null));
        }
        if (getReplicationService() != null) {
            serviceRegistrations.add(context.registerService(IStatisticsProvider.class.getName(), getReplicationService(), null));
        }
        if (getIndexService() != null) {
            serviceRegistrations.add(context.registerService(IStatisticsProvider.class.getName(), getIndexService(), null));
        }
        if (getAuthorizationService() != null) {
            serviceRegistrations.add(context.registerService(IStatisticsProvider.class.getName(), getAuthorizationService(), null));
        }
        if (getQueryService() != null) {
            serviceRegistrations.add(context.registerService(IStatisticsProvider.class.getName(), getQueryService(), null));
        }
    }

    /**
     * Unregister the stats objects
     */
    public void cleanupStats() {
        for (ServiceRegistration serviceReg : serviceRegistrations) {
            serviceReg.unregister();
        }
        serviceRegistrations.clear();
    }

    protected static String generateDatasourceName(String name, URI instanceUri) {
        try {
            return "Datasource=" + name + "_" + URLEncoder.encode(instanceUri.toString(), Constants.byteEncoding);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("This should never happen since UTF-8 is always supported");
        }
    }

    public void executeCommand(String command, IDataset request, IDataset response) throws AnzoException {
    }
}
