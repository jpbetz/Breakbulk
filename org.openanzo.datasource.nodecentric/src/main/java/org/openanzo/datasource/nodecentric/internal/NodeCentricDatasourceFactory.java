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
package org.openanzo.datasource.nodecentric.internal;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.commons.collections15.multimap.MultiHashMap;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.DatasourceDictionary;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IDatasourceFactory;
import org.openanzo.datasource.nodecentric.ObjectClassDef;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.indexer.lucene.LuceneDictionary;
import org.openanzo.jmx.IJMXServiceEndpoint;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.ServiceActivator;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.IAuthorizationEventListener;
import org.openanzo.services.IStatisticsProvider;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;
import org.osgi.service.metatype.MetaTypeProvider;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator factory for NodeCentric Datasources
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class NodeCentricDatasourceFactory extends ServiceActivator implements IDatasourceFactory, ManagedServiceFactory, MetaTypeProvider {
    private static final Logger                                                   log                    = LoggerFactory.getLogger(NodeCentricDatasourceFactory.class);

    private final static ObjectClassDef                                           instanceDef            = new ObjectClassDef();

    private final MultiHashMap<IDatasource, ServiceRegistration>                  serviceRegistrations   = new MultiHashMap<IDatasource, ServiceRegistration>();

    private final ConcurrentMap<String, NodeCentricDatasource>                    datasources            = new ConcurrentHashMap<String, NodeCentricDatasource>();

    private OsgiServiceTracker<IAuthorizationEventListener>                       aclTracker             = null;

    private final Set<IAuthorizationEventListener>                                aclEventListeners      = new CopyOnWriteArraySet<IAuthorizationEventListener>();

    private final HashMap<String, Dictionary<? extends Object, ? extends Object>> initializingDatasource = new HashMap<String, Dictionary<? extends Object, ? extends Object>>();

    private NodeCentricDatasourcesJMX                                             jmxExposer             = null;

    /** Factory PID for NodecentricDatasource */
    public static final String                                                    FACTORY_PID            = "org.openanzo.datasource.nodecentric.Factory";

    private ServiceRegistration                                                   jmxRegistration        = null;

    @Override
    public String getServicePid() {
        return FACTORY_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { ICacheProvider.class.getName() };
    }

    @Override
    protected Collection<String> getServiceClassNames() {
        HashSet<String> scn = new HashSet<String>(super.getServiceClassNames());
        scn.add(ManagedServiceFactory.class.getName());
        scn.add(MetaTypeProvider.class.getName());
        return scn;
    }

    @Override
    public boolean registerService() {
        return false;
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);

        aclTracker = new OsgiServiceTracker<IAuthorizationEventListener>(new IServiceTrackerListener<IAuthorizationEventListener>() {

            public void unregisterService(IAuthorizationEventListener service) {
                aclEventListeners.remove(service);
            }

            public void registerService(IAuthorizationEventListener service) {
                aclEventListeners.add(service);
            }

            public Class<IAuthorizationEventListener> getComponentType() {
                return IAuthorizationEventListener.class;
            }

        }, bundleContext);
        aclTracker.open();
        jmxExposer = new NodeCentricDatasourcesJMX(bundleContext);
        jmxRegistration = context.registerService(new String[] { IJMXServiceEndpoint.class.getName() }, jmxExposer, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        super.stop(context);
        if (aclTracker != null) {
            aclTracker.close();
            aclTracker = null;
        }
    }

    public String getName() {
        return FACTORY_PID;
    }

    @Override
    public String getExtraStatus(boolean html) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        if (html) {
            if (datasources.size() > 0) {
                pw.println("<h4><font color='#00cc00'>NodeCentric Datasources:</font></h4>");
                for (NodeCentricDatasource ds : datasources.values()) {
                    try {
                        pw.println("<li>" + URLDecoder.decode(ds.getName(), "UTF-8") + "</li>");
                    } catch (UnsupportedEncodingException e) {
                        log.error(LogUtils.INTERNAL_MARKER, "Should never happen since UTF-8 must be supported by all JVMs on all platforms.", e);
                    }
                    pw.println("<br/>Configuration Properties: ");
                    pw.println("<table border='1'>");
                    for (Enumeration<? extends Object> keys = ds.getConfigurationParameters().keys(); keys.hasMoreElements();) {
                        Object key = keys.nextElement();
                        Object value = ds.getConfigurationParameters().get(key);
                        if (key.toString().toLowerCase().contains("password") && value.toString().startsWith("encrypted:")) {
                            value = "********";
                        }
                        pw.println("<tr><td>" + key.toString() + "</td><td>" + value.toString() + "</td></tr>");
                    }
                    pw.println("</table>");
                }
            }
            if (initializingDatasource.size() > 0) {
                pw.println("<h4><font color='#FFFF00'>NodeCentric Datasources Starting:</font></h4>");
                for (Map.Entry<String, Dictionary<? extends Object, ? extends Object>> entry : initializingDatasource.entrySet()) {
                    pw.println("<li>" + entry.getKey() + "</li>");
                    pw.println("<br/>Configuration Properties: ");
                    pw.println("<table border='1'>");
                    for (Enumeration<? extends Object> keys = entry.getValue().keys(); keys.hasMoreElements();) {
                        Object key = keys.nextElement();
                        Object value = entry.getValue().get(key);
                        pw.println("<tr><td>" + key.toString() + "</td><td>" + value.toString() + "</td></tr>");
                    }
                    pw.println("</table>");
                }

            }
        } else {
            if (datasources.size() > 0) {
                pw.println("NodeCentric Datasources:");
                for (NodeCentricDatasource ds : datasources.values()) {
                    try {
                        pw.println(URLDecoder.decode(ds.getName(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        log.error(LogUtils.INTERNAL_MARKER, "Should never happen since UTF-8 must be supported by all JVMs on all platforms.", e);
                    }
                }
            }
            if (initializingDatasource.size() > 0) {
                pw.println("NodeCentric Datasources Starting:");
                for (Map.Entry<String, Dictionary<? extends Object, ? extends Object>> entry : initializingDatasource.entrySet()) {
                    pw.println(entry.getKey());
                }
            }
        }
        pw.flush();
        sw.flush();
        return sw.toString();
    }

    @SuppressWarnings("unchecked")
    public void updated(String pid, Dictionary configProperties) throws ConfigurationException {
        try {
            lock.lockInterruptibly();
            if (!datasources.containsKey(pid)) {
                boolean enabled = ServicesDictionary.getEnabled(configProperties);
                if (enabled) {
                    try {
                        OsgiConfigurationUtils.validateConfiguration(instanceDef, configProperties);
                        OsgiConfigurationUtils.updateConfigProperties(configProperties, context);
                        String indexLocation = LuceneDictionary.getIndexLocation(configProperties);
                        if (indexLocation == null) {
                            File root = context.getDataFile(pid);
                            if (!root.exists()) {
                                root.mkdirs();
                            }
                            File indexLocationFile = new File(root, "index");
                            if (!indexLocationFile.exists()) {
                                indexLocationFile.mkdirs();
                            }
                            LuceneDictionary.setIndexLocation(configProperties, indexLocationFile.getAbsolutePath());
                        }
                        initializingDatasource.put(pid, configProperties);
                        try {
                            NodeCentricDatasource datasource = new NodeCentricDatasource(context, configProperties, getDependency(ICacheProvider.class), aclEventListeners, eventAdmin);
                            Dictionary<String, String> properties = new Hashtable<String, String>();
                            properties.put(SerializationConstants.isPrimary, Boolean.toString(datasource.isPrimary()));
                            properties.put(DatasourceDictionary.KEY_DATASOURCE_URI, datasource.getInstanceURI().toString());
                            serviceRegistrations.put(datasource, context.registerService(new String[] { NodeCentricDatasource.class.getName(), IDatasource.class.getName(), IStatisticsProvider.class.getName() }, datasource, properties));
                            IAuthorizationService auth = datasource.getAuthorizationService();
                            if (auth instanceof IAuthorizationEventListener) {
                                serviceRegistrations.put(datasource, context.registerService(IAuthorizationEventListener.class.getName(), auth, null));
                            }
                            datasources.put(pid, datasource);
                        } finally {
                            initializingDatasource.remove(pid);
                        }
                    } catch (AnzoException ae) {
                        log.error(LogUtils.LIFECYCLE_MARKER, "Error creating new nodecentric datasource", ae);
                        throw new AnzoRuntimeException(ae);
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new AnzoRuntimeException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } finally {
            lock.unlock();
        }
    }

    public void deleted(String pid) {
        try {
            lock.lockInterruptibly();
            NodeCentricDatasource datasource = datasources.remove(pid);
            if (datasource != null) {
                try {
                    datasource.close(false);
                } catch (AnzoException ae) {
                    log.error(LogUtils.LIFECYCLE_MARKER, "Error closing nodecentric datasource", ae);
                }
                Collection<ServiceRegistration> regs = serviceRegistrations.remove(datasource);
                if (regs != null) {
                    for (ServiceRegistration reg : regs) {
                        reg.unregister();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new AnzoRuntimeException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void start() {
        Properties props = new Properties();
        props.put(org.osgi.framework.Constants.SERVICE_PID, getServicePid());
        props.put(org.osgi.framework.Constants.SERVICE_DESCRIPTION, getBundleDescription());
        context.registerService(getServiceClassNames().toArray(new String[0]), this, props);
    }

    @Override
    public void stop(boolean bundleStopping) {
        aclTracker.close();
        for (NodeCentricDatasource ds : datasources.values()) {
            try {
                ds.close(bundleStopping);
                Collection<ServiceRegistration> regs = serviceRegistrations.remove(ds);
                if (regs != null) {
                    for (ServiceRegistration reg : regs) {
                        if (!bundleStopping) {
                            reg.unregister();
                        }
                    }
                    regs.clear();
                }
            } catch (AnzoException ae) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error closing nodecentric datasource", ae);
            }
        }
        datasources.clear();
        if (bundleStopping && jmxRegistration != null) {
            jmxRegistration.unregister();
            jmxRegistration = null;
        }
    }

    public String[] getLocales() {
        return null;
    }

    public ObjectClassDefinition getObjectClassDefinition(String pid, String locale) {
        return instanceDef;
    }
}
