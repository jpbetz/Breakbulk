/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Properties;

import org.openanzo.combus.ActiveMqProvider;
import org.openanzo.combus.CombusConnection;
import org.openanzo.combus.CombusDatasource;
import org.openanzo.combus.CombusDictionary;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.combus.proxy.CombusAuthenticationServiceProxy;
import org.openanzo.combus.proxy.CombusExecutionServiceProxy;
import org.openanzo.combus.proxy.CombusNotificationRegistrationServiceProxy;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IModelService;
import org.openanzo.datasource.IQueryService;
import org.openanzo.datasource.IReplicationService;
import org.openanzo.datasource.IResetService;
import org.openanzo.datasource.IUpdateService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.CompoundAnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.INotificationRegistrationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdatesProvider;
import org.openanzo.services.ServicesDictionary;
import org.openanzo.services.impl.BaseOperationContext;
import org.openanzo.services.impl.DatasetTracker;
import org.openanzo.services.impl.SelectorTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Core access to the datasource services which the AnzoClient uses.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Joe Betz
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class AnzoClientDatasource {

    private static final Logger                      log                  = LoggerFactory.getLogger(AnzoClientDatasource.class);

    protected final IDatasource                      datasource;

    protected final IAuthenticationService           authenticationService;

    protected final INotificationRegistrationService notificationRegistrationService;

    protected final IExecutionService                executionService;

    protected final CombusConnection                 combusConnection;

    private final HashSet<URI>                       topics               = new HashSet<URI>();

    protected IUpdatesProvider                       updatesProvider;

    protected final IQuadStoreComponent              quadStore;

    /** User to run embedded server under */
    protected final String                           serviceUser;

    /** Password that embedded server uses */
    protected final String                           servicePassword;

    protected final boolean                          USE_PER_GRAPH_TOPICS = true;

    protected AnzoClientDatasource(Properties properties) throws AnzoException {
        this(properties, null);
    }

    protected AnzoClientDatasource(Properties properties, IQuadStoreComponent quadStore) throws AnzoException {
        String user = ServicesDictionary.getUser(properties, null);
        if (user == null) {
            throw new AnzoException(ExceptionConstants.OSGI.MISSING_COMPONENT_PARAMETER, "AnzoClient", ServicesDictionary.KEY_SERVICE_USER);
        } else {
            serviceUser = user;
        }
        String password = ServicesDictionary.getPassword(properties, null);
        if (password == null) {
            throw new AnzoException(ExceptionConstants.OSGI.MISSING_COMPONENT_PARAMETER, "AnzoClient", ServicesDictionary.KEY_SERVICE_PASSWORD);
        } else {
            servicePassword = password;
        }
        String host = CombusDictionary.getHost(properties);
        if (host == null) {
            throw new AnzoException(ExceptionConstants.OSGI.MISSING_COMPONENT_PARAMETER, "AnzoClient", CombusDictionary.KEY_COMBUS_HOST);
        }
        Integer port = CombusDictionary.getPort(properties);
        if (port == null) {
            throw new AnzoException(ExceptionConstants.OSGI.MISSING_COMPONENT_PARAMETER, "AnzoClient", CombusDictionary.KEY_COMBUS_PORT);
        }

        Boolean useSsl = CombusDictionary.getUseSsl(properties);
        combusConnection = new CombusConnection(new ActiveMqProvider(false), user, password, host, port, useSsl != null ? useSsl.booleanValue() : false);
        notificationRegistrationService = new CombusNotificationRegistrationServiceProxy(combusConnection);
        authenticationService = new CombusAuthenticationServiceProxy(combusConnection);
        CombusExecutionServiceProxy executionProxy = new CombusExecutionServiceProxy(combusConnection);
        executionProxy.setTimeout(ServicesDictionary.getTimeout(properties, 60000));
        this.executionService = executionProxy;

        datasource = new CombusDatasource(properties, combusConnection);
        if (quadStore == null) {
            boolean persisted = AnzoClientDictionary.getPersistenceEnabled(properties);
            if (persisted) {
                this.quadStore = new PersistedQuadStoreComponent(properties);
            } else {
                this.quadStore = new MemQuadStoreComponent(properties);
            }
        } else {
            this.quadStore = quadStore;
        }
    }

    protected AnzoClientDatasource(Dictionary<Object, Object> properties, IDatasource datasource, IAuthenticationService authenticationService, IExecutionService executionService, IUpdatesProvider updatesProvider, IJmsProvider jmsProvider, boolean enableJms) throws AnzoException {
        this(properties, null, datasource, authenticationService, executionService, updatesProvider, jmsProvider, enableJms);
    }

    protected AnzoClientDatasource(Dictionary<Object, Object> properties, IQuadStoreComponent quadStore, IDatasource datasource, IAuthenticationService authenticationService, IExecutionService executionService, IUpdatesProvider updatesProvider, IJmsProvider jmsProvider, boolean enableJms) throws AnzoException {
        String user = ServicesDictionary.getUser(properties, null);
        if (user == null) {
            throw new AnzoException(ExceptionConstants.OSGI.MISSING_COMPONENT_PARAMETER, "AnzoClient", ServicesDictionary.KEY_SERVICE_USER);
        } else {
            serviceUser = user;
        }
        String password = ServicesDictionary.getPassword(properties, null);
        if (password == null) {
            throw new AnzoException(ExceptionConstants.OSGI.MISSING_COMPONENT_PARAMETER, "AnzoClient", ServicesDictionary.KEY_SERVICE_PASSWORD);
        } else {
            servicePassword = password;
        }
        this.datasource = datasource;
        this.authenticationService = authenticationService;
        this.executionService = executionService;
        if (jmsProvider != null && enableJms) {

            Boolean useSsl = CombusDictionary.getUseSsl(properties);
            String host = (useSsl != null && useSsl) ? CombusDictionary.getSslHost(properties) : CombusDictionary.getHost(properties);
            if (host == null) {
                throw new AnzoException(ExceptionConstants.OSGI.MISSING_COMPONENT_PARAMETER, "AnzoClient", CombusDictionary.KEY_COMBUS_SSL_HOST);
            }
            Integer port = (useSsl) ? CombusDictionary.getSslPort(properties) : CombusDictionary.getPort(properties);
            if (port == null) {
                throw new AnzoException(ExceptionConstants.OSGI.MISSING_COMPONENT_PARAMETER, "AnzoClient", CombusDictionary.KEY_COMBUS_SSL_PORT);
            }
            combusConnection = new CombusConnection(jmsProvider, serviceUser, servicePassword, host, port, useSsl != null ? useSsl.booleanValue() : false);
            notificationRegistrationService = new CombusNotificationRegistrationServiceProxy(combusConnection);
        } else {
            this.notificationRegistrationService = null;
            this.combusConnection = null;
        }
        this.updatesProvider = updatesProvider;
        if (quadStore == null) {
            boolean persisted = AnzoClientDictionary.getPersistenceEnabled(properties);
            if (persisted) {
                this.quadStore = new PersistedQuadStoreComponent(properties);
            } else {
                this.quadStore = new MemQuadStoreComponent(properties);
            }
        } else {
            this.quadStore = quadStore;
        }
    }

    /**
     * Get the {@link IResetService} service for this client's datasource
     * 
     * @return the reset service for this client's datasource
     */
    public IResetService getResetService() {
        return datasource.getResetService();
    }

    /**
     * Get the {@link IQueryService} service for this client's datasource
     * 
     * @return the {@link IQueryService} service for this client's datasource
     */
    public IQueryService getQueryService() {
        return datasource.getQueryService();
    }

    /**
     * Get the {@link IModelService} service for this client's datasource
     * 
     * @return the {@link IModelService} service for this client's datasource
     */
    public IModelService getModelService() {
        return datasource.getModelService();
    }

    /**
     * Get the {@link IUpdateService} service for this client's datasource
     * 
     * @return the {@link IUpdateService} service for this client's datasource
     */
    public IUpdateService getUpdateService() {
        return datasource.getUpdateService();
    }

    /**
     * Get the {@link IReplicationService} service for this client's datasource
     * 
     * @return the {@link IReplicationService} service for this client's datasource
     */
    public IReplicationService getReplicationService() {
        return datasource.getReplicationService();
    }

    /**
     * Get the {@link IExecutionService} service for this client's datasource
     * 
     * @return the {@link IExecutionService} service for this client's datasource
     */
    public IExecutionService getExecutionService() {
        return executionService;
    }

    /**
     * Get the {@link IAuthorizationService} service for this client's datasource
     * 
     * @return the {@link IAuthorizationService} service for this client's datasource
     */
    public IAuthorizationService getAuthorizationService() {
        return datasource.getAuthorizationService();
    }

    /**
     * Get the {@link CombusConnection} for this clients
     * 
     * @return the {@link CombusConnection} for this client
     */
    public CombusConnection getCombusConnection() {
        return combusConnection;
    }

    protected IQuadStoreComponent getQuadStore() {
        return quadStore;
    }

    protected INotificationRegistrationService getNotificationRegistrationService() {
        return notificationRegistrationService;
    }

    protected void disconnect(NamedGraphUpdateManager updateManager) throws AnzoException {
        if (updatesProvider != null) {
            updatesProvider.unregisterUpdatesListener(updateManager);
        }
    }

    protected void start() throws AnzoException {
        ArrayList<AnzoException> anzoExceptions = new ArrayList<AnzoException>();
        try {
            quadStore.start();
        } catch (AnzoException ae) {
            log.error(LogUtils.INTERNAL_MARKER, "Exception starting quadStore", ae);
            anzoExceptions.add(ae);
        }
        if (anzoExceptions.size() > 0) {
            throw new CompoundAnzoException(anzoExceptions);
        }
    }

    protected void stop(boolean clean) throws AnzoException {
        ArrayList<AnzoException> anzoExceptions = new ArrayList<AnzoException>();
        try {
            quadStore.close();
        } catch (AnzoException ae) {
            log.error(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.OSGI.ERROR_STOPPING_SERVICE, "quad store component"), ae);
            anzoExceptions.add(ae);
        }
        if (combusConnection != null) {
            try {
                combusConnection.stop(clean);
            } catch (AnzoException ae) {
                log.error(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.COMBUS.JMS_DISCONNECT_FAILED), ae);
                anzoExceptions.add(ae);
            }
        }
        if (anzoExceptions.size() > 0) {
            throw new CompoundAnzoException(anzoExceptions);
        }
    }

    protected void registerTopicListener(NamedGraphUpdateManager updateManager, URI... topic) throws AnzoException {
        if (updatesProvider != null) {
            boolean toAdd = topics.isEmpty();
            org.openanzo.rdf.utils.Collections.addAllArrayIfNotNull(topic, topics);
            if (toAdd) {
                updatesProvider.registerUpdatesListener(updateManager);
            }
        } else if (combusConnection != null) {
            if (USE_PER_GRAPH_TOPICS) {
                for (URI t : topic) {
                    String topicString = UriGenerator.generateEncapsulatedString(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX, t.toString());
                    combusConnection.registerTopicListener(topicString, updateManager);
                }
            } else {
                IOperationContext context = new BaseOperationContext(INotificationRegistrationService.REGISTER_TRACKERS, BaseOperationContext.generateOperationId(), null);
                try {
                    HashSet<URI> namedGraphUris = new HashSet<URI>();
                    org.openanzo.rdf.utils.Collections.addAllArrayIfNotNull(topic, namedGraphUris);
                    boolean regOk = getNotificationRegistrationService().registerTrackers(context, Collections.<SelectorTracker> emptySet(), Collections.<DatasetTracker> emptySet(), namedGraphUris, null);
                    if (!regOk) {
                        throw new AnzoException(ExceptionConstants.COMBUS.JMS_REGISTER_SELECTOR_ERROR);
                    }
                    combusConnection.registerMessageListener(updateManager);
                } finally {
                    context.clearMDC();
                }
            }
        }
    }

    protected void unregisterTopicListener(NamedGraphUpdateManager updateManager, URI... topic) throws AnzoException {
        if (updatesProvider != null) {
            if (topic != null) {
                for (URI t : topic) {
                    topics.remove(t);
                }
            }
            if (topics.isEmpty()) {
                updatesProvider.unregisterUpdatesListener(updateManager);
            }
        } else if (combusConnection != null) {
            if (USE_PER_GRAPH_TOPICS) {
                for (URI t : topic) {
                    String topicString = UriGenerator.generateEncapsulatedString(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX, t.toString());
                    combusConnection.unregisterTopicListener(topicString);
                }
            } else {
                IOperationContext context = new BaseOperationContext(INotificationRegistrationService.REGISTER_TRACKERS, BaseOperationContext.generateOperationId(), null);
                try {
                    HashSet<URI> namedGraphUris = new HashSet<URI>();
                    org.openanzo.rdf.utils.Collections.addAllArrayIfNotNull(topic, namedGraphUris);
                    boolean regOk = getNotificationRegistrationService().unregisterTrackers(context, Collections.<SelectorTracker> emptySet(), Collections.<DatasetTracker> emptySet(), namedGraphUris, null);
                    if (!regOk) {
                        throw new AnzoException(ExceptionConstants.COMBUS.JMS_REGISTER_SELECTOR_ERROR);
                    }
                } finally {
                    context.clearMDC();
                }
            }
        }
    }

    /**
     * @return the serviceUser
     */
    public String getServiceUser() {
        return serviceUser;
    }

    /**
     * @return the servicePassword
     */
    public String getServicePassword() {
        return servicePassword;
    }

    /**
     * @return the authenticationService
     */
    public IAuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}
