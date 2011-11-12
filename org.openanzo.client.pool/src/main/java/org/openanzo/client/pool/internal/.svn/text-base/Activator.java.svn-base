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
package org.openanzo.client.pool.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.client.pool.AnzoClientPool;
import org.openanzo.client.pool.ClientPoolDictionary;
import org.openanzo.client.pool.attributes.ClientPoolAttributes;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.datasource.attributes.DatasourceAttributes;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.ServiceActivator;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.CombusAttributes;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdates;
import org.openanzo.services.IUpdatesProvider;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.MetaTypeProvider;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for the AnzoClient pool provider
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class Activator extends ServiceActivator implements ManagedServiceFactory, MetaTypeProvider {

    private static final Logger                         log             = LoggerFactory.getLogger(Activator.class);

    /** The factory pid for the client pool */
    public static final String                          FACTORY_PID     = "org.openanzo.client.ClientPool";

    private final ConcurrentMap<String, AnzoClientPool> clientPools     = new ConcurrentHashMap<String, AnzoClientPool>();

    protected OsgiServiceTracker<IJmsProvider>          jmsTracker      = null;

    protected IJmsProvider                              jmsProvider     = null;

    private UpdatesProvider                             updatesProvider = null;

    GenericObjectClassDef                               classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(FACTORY_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled, ServicesAttributes.User, ServicesAttributes.Password, }, new AttributeDefinition[] { CombusAttributes.Host, CombusAttributes.Port, DatasourceAttributes.DatasourceURI, ClientPoolAttributes.UsesJms }));
    }

    private Map<String, Dictionary<? extends Object, ? extends Object>> configs = new HashMap<String, Dictionary<? extends Object, ? extends Object>>();

    //private ServiceRegistration                                         updateReg        = null;
    @Override
    public String getServicePid() {
        return FACTORY_PID;
    }

    @Override
    public boolean startThreaded() {
        return true;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { IAuthenticationService.class.getName(), IExecutionService.class.getName() };
    }

    @Override
    public String getExtraStatus(boolean html) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        if (html) {
            if (clientPools.size() > 0) {
                pw.println("<h4><font color='#00cc00'>Running Client Pools:</font></h4>");
                for (AnzoClientPool pool : clientPools.values()) {
                    pw.println("<li>" + pool.getCurrentStatus(html) + "</li>");
                }
            }
            if (configs.size() > 0) {
                pw.println("<h4><font color='#cc0000'>Not Running Client Pools:</font></h4>");
                for (Dictionary<? extends Object, ? extends Object> config : configs.values()) {
                    String instance = ServicesDictionary.getInstanceURI(config);
                    pw.println("<li>" + instance + "</li>");
                }
            }
        } else {
            if (clientPools.size() > 0) {
                pw.println("Running Client Pools:");
                for (AnzoClientPool pool : clientPools.values()) {
                    pw.println(pool.getCurrentStatus(html));
                }
            }
            if (configs.size() > 0) {
                pw.println("Not Running Client Pools:");
                for (Dictionary<? extends Object, ? extends Object> config : configs.values()) {
                    String instance = ServicesDictionary.getInstanceURI(config);
                    pw.println(instance);
                }
            }
        }
        pw.flush();
        sw.flush();
        return sw.toString();
    }

    @Override
    protected Collection<String> getServiceClassNames() {
        HashSet<String> scn = new HashSet<String>(super.getServiceClassNames());
        scn.add(ManagedServiceFactory.class.getName());
        scn.add(MetaTypeProvider.class.getName());
        return scn;
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);
        jmsTracker = new OsgiServiceTracker<IJmsProvider>(new IServiceTrackerListener<IJmsProvider>() {
            public void unregisterService(IJmsProvider service) {
                jmsProvider = null;
                //TODO: This should only stop jms based clients
                stopLocked(false);
            }

            public void registerService(IJmsProvider service) {
                lock.lock();
                try {
                    jmsProvider = service;
                    if (isInitialized()) {
                        Iterator<Map.Entry<String, Dictionary<? extends Object, ? extends Object>>> iter = configs.entrySet().iterator();
                        while (iter.hasNext()) {
                            Map.Entry<String, Dictionary<? extends Object, ? extends Object>> entry = iter.next();
                            startPool(entry.getKey(), entry.getValue());
                        }
                        configs.clear();

                    }
                } finally {
                    lock.unlock();
                }
            }

            public Class<IJmsProvider> getComponentType() {
                return IJmsProvider.class;
            }
        }, context);
        jmsTracker.open();
        updatesProvider = new UpdatesProvider();

        Properties updatesProviderProps = new Properties();
        updatesProviderProps.put(Constants.SERVICE_DESCRIPTION, "Updates Provider Proxy");
        context.registerService(IUpdateResultListener.class.getName(), updatesProvider, updatesProviderProps);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        super.stop(context);

        if (jmsTracker != null) {
            jmsTracker.close();
            jmsTracker = null;
        }
    }

    @Override
    public void start() {
        HashSet<String> removed = new HashSet<String>();
        for (Map.Entry<String, Dictionary<? extends Object, ? extends Object>> entry : configs.entrySet()) {
            boolean usesJMS = ClientPoolDictionary.getUsesJms(entry.getValue());
            if (!usesJMS || jmsProvider != null) {
                startPool(entry.getKey(), entry.getValue());
                removed.add(entry.getKey());
            }
        }
        for (String remove : removed) {
            configs.remove(remove);
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        for (AnzoClientPool pool : clientPools.values()) {
            try {
                pool.close(bundleStopping);
            } catch (AnzoException ae) {
                if (bundleStopping) {
                    log.error(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.OSGI.ERROR_STOPPING_SERVICE, "client pool"), ae);
                } else {
                    log.debug(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.OSGI.ERROR_STOPPING_SERVICE, "client pool"), ae);
                }
            }
        }
        clientPools.clear();
        updatesProvider.stop();
    }

    @SuppressWarnings("unchecked")
    public void updated(String pid, Dictionary configProperties) throws ConfigurationException {
        lock.lock();
        try {
            OsgiConfigurationUtils.validateConfiguration(getObjectClassDefinition(null, null), configProperties);
            boolean usesJms = ClientPoolDictionary.getUsesJms(configProperties);
            if (isInitialized() && (!usesJms || jmsProvider != null)) {
                startPool(pid, configProperties);
            } else {
                configs.put(pid, configProperties);
            }
        } finally {
            lock.unlock();
        }
    }

    private void startPool(final String pid, final Dictionary<? extends Object, ? extends Object> configProperties) {
        if (!clientPools.containsKey(pid)) {
            boolean enabled = ServicesDictionary.getEnabled(configProperties);
            if (enabled) {
                Thread t1 = new Thread("AnzoClientPoolInitializer:" + pid) {
                    @Override
                    public void run() {
                        boolean usesJms = ClientPoolDictionary.getUsesJms(configProperties);
                        AnzoClientPool pool = new AnzoClientPool(configProperties, context, getDependency(IAuthenticationService.class), getDependency(IExecutionService.class), updatesProvider, (usesJms) ? jmsProvider : null);
                        clientPools.put(pid, pool);
                    }
                };
                t1.start();
            } else {
                state = ServiceLifecycleState.NOT_ENABLED;
            }
        }
    }

    public void deleted(String pid) {
        AnzoClientPool pool = clientPools.remove(pid);
        if (pool != null) {
            try {
                pool.close(false);
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.OSGI.ERROR_STOPPING_SERVICE, "client pool"), ae);
            }
        }
    }

    public String[] getLocales() {
        return null;
    }

    public String getName() {
        return FACTORY_PID;
    }

    static class UpdateObject {
        IOperationContext context;

        IUpdates          results;

        UpdateObject(IOperationContext context, IUpdates results) {
            this.context = context;
            this.results = results;
        }
    }

    static class UpdatesProvider implements IUpdatesProvider, IUpdateResultListener {
        CopyOnWriteArraySet<IUpdateResultListener> listeners    = new CopyOnWriteArraySet<IUpdateResultListener>();

        Thread                                     updateThread = null;

        LinkedList<UpdateObject>                   updates      = new LinkedList<UpdateObject>();

        ReentrantLock                              updateLock   = new ReentrantLock();

        Condition                                  newUpdates   = updateLock.newCondition();

        UpdatesProvider() {
            updateThread = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        UpdateObject object = null;
                        try {
                            updateLock.lock();
                            try {
                                while (updates.isEmpty()) {
                                    newUpdates.await();
                                }
                                object = updates.removeFirst();
                            } catch (InterruptedException ie) {
                                log.debug(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CORE.INTERRUPTED), ie);
                                return;
                            }
                        } finally {
                            updateLock.unlock();
                        }

                        for (IUpdateResultListener listener : listeners) {
                            try {
                                listener.updateComplete(object.context, object.results);
                            } catch (AnzoException ae) {
                                log.error(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.DATASOURCE.ERROR_UPDATE_LISTENER, listener.getClass().getName()), ae);
                            }
                        }
                    }
                }
            };
            updateThread.start();
        }

        public void stop() {
            updateThread.interrupt();
        }

        public void registerUpdatesListener(IUpdateResultListener listener) {
            listeners.add(listener);
        }

        public void unregisterUpdatesListener(IUpdateResultListener listener) {
            listeners.remove(listener);
        }

        public void updateComplete(IOperationContext context, IUpdates results) throws AnzoException {
            try {
                updateLock.lock();
                updates.add(new UpdateObject(context, results));
                newUpdates.signal();
            } finally {
                updateLock.unlock();
            }
        }
    }
}
