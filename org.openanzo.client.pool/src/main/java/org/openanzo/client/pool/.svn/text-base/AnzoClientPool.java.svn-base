/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 18, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client.pool;

import java.util.Dictionary;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.pool.PoolableObjectFactory;
import org.openanzo.client.AnzoClient;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.datasource.DatasourceDictionary;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.datasource.IDatasourceRegistrationListener;
import org.openanzo.datasource.NamedDatasourceTracker;
import org.openanzo.datasource.PrimaryDatasourceTracker;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.osgi.IStatusProvider;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.IUpdatesProvider;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pool of anzo clients
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class AnzoClientPool implements IStatusProvider {
    private static final Logger                            log                   = LoggerFactory.getLogger(AnzoClientPool.class);

    private long                                           jmsCount              = 0;

    private long                                           nonjmsCount           = 0;

    private final List<AnzoClient>                         anzoClients           = new CopyOnWriteArrayList<AnzoClient>();

    private IDatasource                                    datasource            = null;

    private Set<IDatasourceListener>                       datasourceListeners   = new CopyOnWriteArraySet<IDatasourceListener>();

    private ServiceTracker                                 datasourceTracker     = null;

    private IAuthenticationService                         authenticationService = null;

    private IExecutionService                              executionService      = null;

    private IJmsProvider                                   jmsProvider           = null;

    private IUpdatesProvider                               updatesProvider       = null;

    private Dictionary<? extends Object, ? extends Object> configProperties      = null;

    private BundleContext                                  context               = null;

    private ServiceRegistration                            reg                   = null;

    protected ReentrantLock                                lock                  = new ReentrantLock();

    protected ServiceLifecycleState                        state                 = ServiceLifecycleState.CREATED;

    String                                                 instance              = null;

    /**
     * Create a new anzo client pool
     * 
     * @param configProperties
     *            configuration properties
     * @param context
     *            bundle context
     * @param authenticationService
     *            the authentication service
     * @param executionService
     *            the execution service
     * @param updatesProvider
     *            updates provider
     * @param jmsProvider
     *            jmsprovider
     */
    public AnzoClientPool(Dictionary<? extends Object, ? extends Object> configProperties, BundleContext context, IAuthenticationService authenticationService, IExecutionService executionService, IUpdatesProvider updatesProvider, IJmsProvider jmsProvider) {
        this.context = context;
        this.configProperties = configProperties;
        this.authenticationService = authenticationService;
        this.executionService = executionService;
        this.jmsProvider = jmsProvider;
        this.updatesProvider = updatesProvider;

        String datasourceURI = DatasourceDictionary.getDatasourceURI(configProperties);
        if (datasourceURI == null) {
            try {
                datasourceTracker = new PrimaryDatasourceTracker(context, new IDatasourceRegistrationListener() {

                    public void unregisterDatasource(IDatasource datasource) {
                        AnzoClientPool.this.datasource = null;

                    }

                    public void registerDatasource(IDatasource datasource) {
                        AnzoClientPool.this.datasource = datasource;
                        start();
                    }
                });
            } catch (InvalidSyntaxException ise) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.OSGI.INVALID_SERVICE_SYNTAX, ise.getFilter()), ise);
            }
        } else {
            try {
                datasourceTracker = new NamedDatasourceTracker(context, datasourceURI, new IDatasourceRegistrationListener() {

                    public void unregisterDatasource(IDatasource datasource) {
                        AnzoClientPool.this.datasource = null;
                    }

                    public void registerDatasource(IDatasource datasource) {
                        AnzoClientPool.this.datasource = datasource;
                        start();
                    }
                });
            } catch (InvalidSyntaxException ise) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.OSGI.INVALID_SERVICE_SYNTAX, ise.getFilter()), ise);
            }
        }
        datasourceTracker.open();
        instance = ServicesDictionary.getInstanceURI(configProperties);
    }

    void start() {
        lock.lock();
        try {
            if (state != ServiceLifecycleState.STARTED) {
                datasource.registerDatasourceListener(new IDatasourceListener() {
                    public void resetStarting() throws AnzoException {
                        for (IDatasourceListener listener : datasourceListeners) {
                            listener.resetStarting();
                        }
                        for (AnzoClient client : anzoClients) {
                            client.clear();
                        }
                    }

                    public void reset() throws AnzoException {
                        for (IDatasourceListener listener : datasourceListeners) {
                            listener.reset();
                        }
                    }

                    public void postReset() throws AnzoException {
                        for (IDatasourceListener listener : datasourceListeners) {
                            listener.postReset();
                        }
                    }

                    public void resetFinished() throws AnzoException {
                        for (IDatasourceListener listener : datasourceListeners) {
                            listener.resetFinished();
                        }
                    }
                });
            }
        } finally {
            lock.unlock();
        }

        //fixes #873   
        reg = context.registerService(AnzoClientPool.class.getName(), this, configProperties);
        state = ServiceLifecycleState.STARTED;
    }

    /**
     * Register an {@link IDatasourceListener}
     * 
     * @param listener
     *            listener to register
     */
    public void registerDatasourceListener(IDatasourceListener listener) {
        datasourceListeners.add(listener);
    }

    /**
     * Unregister an {@link IDatasourceListener}
     * 
     * @param listener
     *            listener to unregister
     */
    public void unregisterDatasourceListener(IDatasourceListener listener) {
        datasourceListeners.remove(listener);
    }

    /**
     * Get anzo client from the pool
     * 
     * @param useJms
     *            should the client use jms
     * @param userDescription
     *            description of user
     * @return anzo client from the pool
     * @throws AnzoException
     */
    public RestrictedAnzoClient getAnzoClient(boolean useJms, String userDescription) throws AnzoException {
        if (context.getBundle().getState() != Bundle.ACTIVE) {
            throw new AnzoException(ExceptionConstants.OSGI.BUNDLE_NOT_ACTIVE, context.getBundle().getSymbolicName(), Integer.toString(context.getBundle().getState()));
        }
        lock.lock();
        try {
            RestrictedAnzoClient anzoClient = new RestrictedAnzoClient(configProperties, datasource, authenticationService, executionService, updatesProvider, jmsProvider, useJms);
            anzoClients.add(anzoClient);
            anzoClient.setUserDescription(userDescription);
            anzoClient.connect();
            if (useJms)
                jmsCount++;
            else
                nonjmsCount--;
            return anzoClient;
        } catch (AnzoException exception) {
            log.error(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.SERVER.ERROR_GETTING_FROM_POOL), exception);
            throw exception;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Return anzo client to the pool
     * 
     * @param client
     *            client to return to pool
     */
    public void returnAnzoClient(RestrictedAnzoClient client) {
        returnAnzoClient(client, true);
    }

    /**
     * Return anzo client to the pool
     * 
     * @param client
     *            client to return to pool
     * @param closeJms
     *            if true, execute full jms close protocols, false if jms is already closed
     */
    public void returnAnzoClient(RestrictedAnzoClient client, boolean closeJms) {
        lock.lock();
        try {
            client.restrictedClose(closeJms);
            anzoClients.remove(client);
            if (client.useJms) {
                jmsCount--;
            } else {
                nonjmsCount--;
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Close the client pool
     * 
     * @param bundleStopping
     *            was the entire OSGI system stopped, or just this bundle
     * @throws AnzoException
     */
    public void close(boolean bundleStopping) throws AnzoException {
        lock.lock();
        try {
            if (state != ServiceLifecycleState.STOPPED) {

                if (!bundleStopping && reg != null) {
                    reg.unregister();
                }
                if (datasourceTracker != null) {
                    datasourceTracker.close();
                }
                state = ServiceLifecycleState.STOPPED;
            }
        } finally {
            lock.unlock();
        }
    }

    class AnzoClientFactory implements PoolableObjectFactory {
        final boolean useJms;

        public AnzoClientFactory(boolean useJms) {
            this.useJms = useJms;
        }

        public Object makeObject() throws Exception {
            RestrictedAnzoClient anzoClient = new RestrictedAnzoClient(configProperties, datasource, authenticationService, executionService, updatesProvider, jmsProvider, useJms);
            anzoClients.add(anzoClient);
            return anzoClient;
        }

        public void destroyObject(Object object) throws Exception {
            RestrictedAnzoClient client = (RestrictedAnzoClient) object;
            client.restrictedClose();
            anzoClients.remove(client);
        }

        public void passivateObject(Object object) throws Exception {
            RestrictedAnzoClient client = (RestrictedAnzoClient) object;
            client.disconnect();
            client.clear();
            client.setServiceUser(null);
        }

        public void activateObject(Object arg0) throws Exception {
        }

        public boolean validateObject(Object arg0) {
            return true;
        }
    }

    public String getCurrentStatus(boolean html) {
        return instance;
    }

    public ServiceLifecycleState getState() {
        return state;
    }
}
