/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation,Cambridge Semantics Incorporated and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/security/activemq/BocaAuthenticationBroker.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Oct 4, 2006
 * Revision:	$Id: AuthenticationBroker.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.activemq.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ConnectionContext;
import org.apache.activemq.broker.ProducerBrokerExchange;
import org.apache.activemq.broker.region.Destination;
import org.apache.activemq.broker.region.Subscription;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQTempDestination;
import org.apache.activemq.command.ConnectionInfo;
import org.apache.activemq.command.ConsumerInfo;
import org.apache.activemq.command.Message;
import org.apache.activemq.command.ProducerInfo;
import org.apache.activemq.security.SecurityContext;
import org.apache.commons.collections15.BidiMap;
import org.apache.commons.collections15.bidimap.DualHashBidiMap;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.COMBUS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.Privilege;
import org.openanzo.services.impl.BaseOperationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * SecurityBroker that provides Anzo authentication and authorization to a ActiveMQ broker.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class SecurityBroker extends BrokerFilter implements IDatasourceListener {

    private static final Logger                       log                    = LoggerFactory.getLogger(SecurityBroker.class);

    private final IAuthenticationService              authenticationService;

    private final List<ServerSecurityContext>         securityContexts       = Collections.synchronizedList(new ArrayList<ServerSecurityContext>());

    private final Map<String, ServerSecurityContext>  userSecurityContextMap = Collections.synchronizedMap(new HashMap<String, ServerSecurityContext>());

    private final Map<String, Set<ConnectionContext>> userConnection         = Collections.synchronizedMap(new HashMap<String, Set<ConnectionContext>>());

    private final BidiMap<String, URI>                idToUser               = new DualHashBidiMap<String, URI>();

    private final Vector<String>                      connections            = new Vector<String>();

    private static final String                       ADD_CONNECTION         = "addConnection";

    private static final String                       ADD_CONSUMER           = "addConsumer";

    private static final String                       ADD_PRODUCER           = "addProducer";

    private static final String                       SEND_MESSAGE           = "sendMessage";

    private static final String                       HANDLE_ACLS_UPDATE     = "handleAclUpdate";

    private final HashSet<String>                     serverQueueNames       = new HashSet<String>();

    private final AnzoPrincipal                       principal;

    private IDatasource                               primaryDatasource      = null;

    private Timer                                     timer                  = new Timer(true);

    private TimerTask                                 sweaperTask            = null;

    /**
     * Create a new AuthenticationBroker
     * 
     * @param next
     *            activemq broker
     * @throws AnzoException
     */
    protected SecurityBroker(Broker next, IAuthenticationService authenticationService, ICacheProvider cacheProvider, String userName, String password) throws AnzoException {
        super(next);
        this.authenticationService = authenticationService;
        principal = authenticationService.authenticateUser(new BaseOperationContext("StartSecurityBroker", BaseOperationContext.generateOperationId(), null), userName, password);
        serverQueueNames.add(COMBUS.NOTIFICATION_UPDATES_QUEUE);
        serverQueueNames.add(COMBUS.TRANSACTIONS_TOPIC);
        sweaperTask = new TimerTask() {
            @Override
            public void run() {
                purgeTopics();
            }
        };
        timer.schedule(sweaperTask, 1000 * 10 * 60, 1000 * 10 * 60);
    }

    private void purgeTopics() {
        try {
            for (Map.Entry<ActiveMQDestination, Destination> entry : SecurityBroker.this.next.getDestinationMap().entrySet()) {
                if (entry.getKey().getPhysicalName().startsWith(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {
                    if (entry.getValue().getConsumers().size() == 0) {
                        SecurityBroker.this.next.removeDestination(getAdminConnectionContext(), entry.getKey(), 1000);
                    }
                }
            }
        } catch (NullPointerException npe) {
            //Needed to handle activemq bug
        } catch (Exception e) {
            log.warn(LogUtils.COMBUS_MARKER, Messages.getString(ExceptionConstants.COMBUS.ERROR_PURGING_TOPICS), e);
        }
    }

    public void setDatasource(IDatasource datasource) {
        if (this.primaryDatasource != null && datasource != null && !primaryDatasource.equals(datasource)) {
            this.primaryDatasource.unregisterDatasourceListener(this);
        }
        this.primaryDatasource = datasource;
        if (this.primaryDatasource != null) {
            this.primaryDatasource.registerDatasourceListener(this);
        }
    }

    public void resetStarting() throws AnzoException {
    }

    public void reset() throws AnzoException {
        purgeTopics();
    }

    public void resetFinished() throws AnzoException {
        refresh();
        userSecurityContextMap.clear();
    }

    public void postReset() throws AnzoException {
    }

    void connect() throws AnzoException {
    }

    @Override
    public void addConnection(ConnectionContext connectionContext, ConnectionInfo info) throws Exception {
        if (connectionContext.getSecurityContext() == null) {
            IOperationContext context = null;
            try {
                context = new BaseOperationContext(ADD_CONNECTION, info.getConnectionId().toString(), principal);
                context.setMDC();
                AnzoPrincipal principal = authenticationService.authenticateUser(context, info.getUserName(), info.getPassword());
                if (principal != null) {
                    idToUser.put(info.getUserName(), principal.getUserURI());
                    ServerSecurityContext securityContext = userSecurityContextMap.get(principal.getName());
                    if (securityContext == null) {
                        securityContext = new ServerSecurityContext(principal);
                        userSecurityContextMap.put(principal.getName(), securityContext);
                        securityContexts.add(securityContext);
                    }
                    connectionContext.setSecurityContext(securityContext);
                    Set<ConnectionContext> conns = userConnection.get(info.getUserName());
                    if (conns == null) {
                        conns = new CopyOnWriteArraySet<ConnectionContext>();
                        userConnection.put(info.getUserName(), conns);
                    }
                    conns.add(connectionContext);
                    connectionContext.setProducerFlowControl(false);
                } else {
                    MDC.put(LogUtils.REMOTE_ADDRESS, connectionContext.getConnection().getRemoteAddress());
                    MDC.put(LogUtils.USER, info.getUserName());
                    String errorMsg = Messages.getString(ExceptionConstants.COMBUS.ERROR_LOGGING_IN);
                    log.error(LogUtils.SECURITY_MARKER, errorMsg);
                    MDC.clear();
                    throw new SecurityException(errorMsg);
                }
            } finally {
                if (context != null) {
                    context.clearMDC();
                }
            }
        }
        connections.add(info.getConnectionId().getValue());
        super.addConnection(connectionContext, info);
    }

    @Override
    public void removeConnection(ConnectionContext context, ConnectionInfo info, Throwable error) throws Exception {
        super.removeConnection(context, info, error);

        Set<ConnectionContext> conns = userConnection.get(info.getUserName());
        if (conns != null) {
            conns.remove(context);
        }
        connections.remove(info.getConnectionId().getValue());
        if (!userSecurityContextMap.values().contains(context.getSecurityContext())) {
            securityContexts.remove(context.getSecurityContext());
        }
    }

    /**
     * Previously logged in users may no longer have the same access anymore. Refresh all the logged into users.
     */
    private void refresh() {
        for (SecurityContext sc : securityContexts) {
            sc.getAuthorizedReadDests().clear();
            sc.getAuthorizedWriteDests().clear();
        }
    }

    @Override
    public void removeDestination(ConnectionContext context, ActiveMQDestination destination, long timeout) throws Exception {
        final ServerSecurityContext securityContext = (ServerSecurityContext) context.getSecurityContext();
        if (securityContext == null) {
            MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
            String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, context.getConnectionId().toString());
            log.error(LogUtils.SECURITY_MARKER, errorMsg);
            MDC.clear();
            throw new SecurityException(errorMsg);
        }
        // You don't need to be an admin to remove temp destinations.
        if (!destination.isTemporary()) {
            if (destination.getPhysicalName().startsWith("services/")) {
                if (!securityContext.getAnzoPrincipal().isSysadmin()) {
                    MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                    MDC.put(LogUtils.USER, securityContext.getAnzoPrincipal().getName());
                    String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, securityContext.getUserName(), "remove", destination.toString());
                    log.info(LogUtils.SECURITY_MARKER, errorMsg);
                    MDC.clear();
                    throw new SecurityException(errorMsg);
                }
            } else if (destination.getPhysicalName().startsWith(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {

            } else if (destination.getPhysicalName().startsWith(NAMESPACES.STREAM_TOPIC_PREFIX)) {

            }
        } else {
            if (!((ActiveMQTempDestination) destination).getConnectionId().equals(context.getConnectionId().getValue())) {
                MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                MDC.put(LogUtils.USER, securityContext.getAnzoPrincipal().getName());
                String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, securityContext.getUserName(), "remove", destination.toString());
                log.info(LogUtils.SECURITY_MARKER, errorMsg);
                MDC.clear();
                throw new SecurityException(errorMsg);
            }
        }
        super.removeDestination(context, destination, timeout);
    }

    @Override
    public Subscription addConsumer(ConnectionContext context, ConsumerInfo info) throws Exception {
        //   resetlock.readLock().lock();
        //   try {
        final ServerSecurityContext subject = (ServerSecurityContext) context.getSecurityContext();
        if (subject == null) {
            MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
            String errorMsg = "Connection is not authenticated:" + context.getClientId();
            log.error(LogUtils.SECURITY_MARKER, errorMsg);
            MDC.clear();
            throw new SecurityException(errorMsg);
        }
        if (!subject.getAuthorizedReadDests().containsKey(info.getDestination())) {
            if (info.getDestination().getPhysicalName().startsWith("services/")) {
                if (!subject.getAnzoPrincipal().isSysadmin()) {
                    MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                    MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                    String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, subject.getUserName(), "read", info.getDestination().toString());
                    log.info(LogUtils.SECURITY_MARKER, errorMsg);
                    MDC.clear();
                    throw new SecurityException(errorMsg);
                }
            } else if (info.getDestination().isTemporary() && !((ActiveMQTempDestination) info.getDestination()).getConnectionId().equals(context.getConnectionId().getValue())) {
                MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, subject.getUserName(), "read", info.getDestination().toString());
                log.info(LogUtils.SECURITY_MARKER, errorMsg);
                MDC.clear();
                throw new SecurityException(errorMsg);
            } else {
                IOperationContext opContext = null;
                try {
                    String destinationName = info.getDestination().getPhysicalName();
                    if (destinationName.startsWith(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX) || destinationName.startsWith(NAMESPACES.STREAM_TOPIC_PREFIX)) {
                        opContext = new BaseOperationContext(ADD_CONSUMER, context.getConnectionId().toString(), principal);
                        opContext.setMDC();
                        if (!subject.getAnzoPrincipal().isSysadmin()) {
                            if (primaryDatasource == null) {
                                MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                                MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                                String logMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_SERVER_NOT_READY);
                                log.warn(LogUtils.COMBUS_MARKER, logMsg);
                                MDC.clear();
                                throw new SecurityException(logMsg);
                            }
                            String namedGraphUUIDUri = null;
                            if (destinationName.startsWith(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {
                                namedGraphUUIDUri = UriGenerator.stripEncapsulatedString(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX, destinationName);
                            } else {
                                namedGraphUUIDUri = UriGenerator.stripEncapsulatedString(NAMESPACES.STREAM_TOPIC_PREFIX, destinationName);
                            }
                            URI namedGraphUri = null;
                            try {
                                namedGraphUri = primaryDatasource.getModelService().getUriForUUID(opContext, Constants.valueFactory.createURI(namedGraphUUIDUri));
                            } catch (AnzoException e) {
                                String logMsg = Messages.formatString(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GRAPH_NOT_VALID, namedGraphUUIDUri);
                                log.debug(LogUtils.DATASOURCE_MARKER, logMsg, e);
                                throw new SecurityException(logMsg, e);
                            }
                            if (namedGraphUri == null) {
                                String logMsg = Messages.formatString(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GRAPH_NOT_VALID, namedGraphUUIDUri);
                                log.debug(LogUtils.DATASOURCE_MARKER, logMsg);
                                throw new SecurityException(logMsg);
                            }
                            Set<URI> roles = primaryDatasource.getAuthorizationService().getRolesForGraph(opContext, namedGraphUri, Privilege.READ);
                            if (!org.openanzo.rdf.utils.Collections.memberOf(roles, subject.getAnzoPrincipal().getRoles())) {
                                MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                                MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                                String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.NOT_AUTHORIZED_FOR_TOPIC, subject.getUserName(), "read", info.getDestination().toString());
                                log.info(LogUtils.SECURITY_MARKER, errorMsg);
                                MDC.clear();
                                throw new SecurityException(errorMsg);
                            }
                        }
                    }
                } finally {
                    if (opContext != null) {
                        opContext.clearMDC();
                    }
                }
            }
            subject.getAuthorizedReadDests().put(info.getDestination(), info.getDestination());
        }
        return super.addConsumer(context, info);
    }

    @Override
    public void removeConsumer(ConnectionContext context, ConsumerInfo info) throws Exception {
        super.removeConsumer(context, info);
        if (info.getDestination().getPhysicalName().startsWith(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {
            Set<Destination> dests = next.getDestinations(info.getDestination());
            if (dests != null) {
                for (Destination dest : dests) {
                    if (dest.getConsumers().size() == 0) {
                        //                       dest.dispose(getAdminConnectionContext());
                    }
                }
            }
        }
    }

    @Override
    public void addProducer(ConnectionContext context, ProducerInfo info) throws Exception {
        final ServerSecurityContext subject = (ServerSecurityContext) context.getSecurityContext();
        if (subject == null) {
            MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
            String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, context.getConnectionId().toString());
            log.error(LogUtils.SECURITY_MARKER, errorMsg);
            MDC.clear();
            throw new SecurityException(errorMsg);
        }
        if (info.getDestination() != null) {
            if (serverQueueNames.contains(info.getDestination().getPhysicalName())) {
                if (!subject.getAnzoPrincipal().isSysadmin()) {
                    MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                    MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                    String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, subject.getUserName(), "write", info.getDestination().toString());

                    log.info(LogUtils.SECURITY_MARKER, errorMsg);
                    MDC.clear();
                    throw new SecurityException(errorMsg);
                }
            } else if (info.getDestination().isTemporary()) {
                if (!subject.getAnzoPrincipal().isSysadmin()) {
                    MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                    MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                    String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, subject.getUserName(), "write", info.getDestination().toString());
                    log.info(LogUtils.SECURITY_MARKER, errorMsg);
                    MDC.clear();
                    throw new SecurityException(errorMsg);
                }
            } else if (info.getDestination().getPhysicalName().startsWith(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {
                if (!subject.getAnzoPrincipal().isSysadmin()) {
                    MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                    MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                    String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, subject.getUserName(), "write", info.getDestination().toString());
                    log.info(LogUtils.SECURITY_MARKER, errorMsg);
                    MDC.clear();
                    throw new SecurityException(errorMsg);
                }
            } else if (info.getDestination().getPhysicalName().startsWith(NAMESPACES.STREAM_TOPIC_PREFIX)) {
                if (primaryDatasource == null) {
                    String logMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_SERVER_NOT_READY);
                    log.warn(LogUtils.COMBUS_MARKER, logMsg);
                    throw new SecurityException(logMsg);
                }
                IOperationContext opContext = null;
                try {
                    opContext = new BaseOperationContext(ADD_PRODUCER, context.getConnectionId().toString(), principal);
                    opContext.setMDC();
                    if (!subject.getAnzoPrincipal().isSysadmin()) {
                        String namedGraphUUIDUri = UriGenerator.stripEncapsulatedString(NAMESPACES.STREAM_TOPIC_PREFIX, info.getDestination().getPhysicalName());
                        URI namedGraphUri = null;
                        try {
                            namedGraphUri = primaryDatasource.getModelService().getUriForUUID(opContext, Constants.valueFactory.createURI(namedGraphUUIDUri));
                        } catch (AnzoException e) {
                            String logMsg = Messages.formatString(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GRAPH_NOT_VALID, namedGraphUUIDUri);
                            log.debug(LogUtils.DATASOURCE_MARKER, logMsg, e);
                            throw new SecurityException(logMsg, e);
                        }
                        if (namedGraphUri == null) {
                            String logMsg = Messages.formatString(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GRAPH_NOT_VALID, namedGraphUUIDUri);
                            log.debug(LogUtils.DATASOURCE_MARKER, logMsg);
                            throw new SecurityException(logMsg);
                        }
                        Set<URI> roles = primaryDatasource.getAuthorizationService().getRolesForGraph(opContext, namedGraphUri, Privilege.ADD);
                        if (!org.openanzo.rdf.utils.Collections.memberOf(roles, subject.getAnzoPrincipal().getRoles())) {
                            MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                            MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                            String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, subject.getUserName(), "write", info.getDestination().toString());
                            log.info(LogUtils.SECURITY_MARKER, errorMsg);
                            MDC.clear();
                            throw new SecurityException(errorMsg);
                        }
                    }
                } finally {
                    if (opContext != null) {
                        opContext.clearMDC();
                    }
                }
            } else if (info.getDestination().getPhysicalName().startsWith("services/")) {
                Set<Destination> dests = next.getDestinations(info.getDestination());
                if (dests == null || dests.size() == 0) {
                    MDC.put(LogUtils.REMOTE_ADDRESS, context.getConnection().getRemoteAddress());
                    MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                    String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_TOPIC_NOT_EXIST_YET, subject.getUserName(), info.getDestination().toString());
                    log.info(LogUtils.SECURITY_MARKER, errorMsg);
                    MDC.clear();
                    throw new SecurityException(errorMsg);
                }
            }
            subject.getAuthorizedWriteDests().put(info.getDestination(), info.getDestination());
        }
        super.addProducer(context, info);
    }

    @Override
    public void send(ProducerBrokerExchange exchange, Message messageSend) throws Exception {
        final ServerSecurityContext subject = (ServerSecurityContext) exchange.getConnectionContext().getSecurityContext();
        if (subject == null) {
            MDC.put(LogUtils.REMOTE_ADDRESS, exchange.getConnectionContext().getConnection().getRemoteAddress());
            String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, exchange.getConnectionContext().getConnectionId().toString());
            log.error(LogUtils.SECURITY_MARKER, errorMsg);
            MDC.clear();
            throw new SecurityException(errorMsg);
        }
        if (!subject.getAuthorizedWriteDests().contains(messageSend.getDestination())) {
            if (serverQueueNames.contains(messageSend.getDestination().getPhysicalName()) || messageSend.getDestination().getPhysicalName().startsWith(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX)) {
                if (!subject.getAnzoPrincipal().isSysadmin()) {
                    MDC.put(LogUtils.REMOTE_ADDRESS, exchange.getConnectionContext().getConnection().getRemoteAddress());
                    MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                    String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, subject.getUserName(), "write", messageSend.getDestination().toString());
                    log.info(LogUtils.SECURITY_MARKER, errorMsg);
                    MDC.clear();
                    throw new SecurityException(errorMsg);
                }
            } else if (messageSend.getDestination().getPhysicalName().startsWith(NAMESPACES.STREAM_TOPIC_PREFIX)) {
                if (primaryDatasource == null) {
                    MDC.put(LogUtils.REMOTE_ADDRESS, exchange.getConnectionContext().getConnection().getRemoteAddress());
                    MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                    String logMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_SERVER_NOT_READY);
                    log.warn(LogUtils.COMBUS_MARKER, logMsg);
                    MDC.clear();
                    throw new SecurityException(logMsg);
                }
                IOperationContext opContext = null;
                try {
                    opContext = new BaseOperationContext(SEND_MESSAGE, exchange.getConnectionContext().getConnectionId().toString(), principal);
                    opContext.setMDC();
                    if (!subject.getAnzoPrincipal().isSysadmin()) {
                        String namedGraphUUIDUri = UriGenerator.stripEncapsulatedString(NAMESPACES.STREAM_TOPIC_PREFIX, messageSend.getDestination().getPhysicalName());
                        URI namedGraphUri = null;
                        try {
                            namedGraphUri = primaryDatasource.getModelService().getUriForUUID(opContext, Constants.valueFactory.createURI(namedGraphUUIDUri));
                        } catch (AnzoException e) {
                            String logMsg = Messages.formatString(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GRAPH_NOT_VALID, namedGraphUUIDUri);
                            log.debug(LogUtils.COMBUS_MARKER, logMsg, e);
                            throw new SecurityException(logMsg, e);
                        }
                        if (namedGraphUri == null) {
                            String logMsg = Messages.formatString(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GRAPH_NOT_VALID, namedGraphUUIDUri);
                            log.debug(LogUtils.COMBUS_MARKER, logMsg);
                            throw new SecurityException(logMsg);
                        }
                        Set<URI> roles = primaryDatasource.getAuthorizationService().getRolesForGraph(opContext, namedGraphUri, Privilege.ADD);
                        if (!org.openanzo.rdf.utils.Collections.memberOf(roles, subject.getAnzoPrincipal().getRoles())) {
                            MDC.put(LogUtils.REMOTE_ADDRESS, exchange.getConnectionContext().getConnection().getRemoteAddress());
                            MDC.put(LogUtils.USER, subject.getAnzoPrincipal().getName());
                            String errorMsg = Messages.formatString(ExceptionConstants.COMBUS.ERROR_CONNECTION_NOT_AUTHENTICATED, subject.getUserName(), "write", messageSend.getDestination().toString());
                            log.info(LogUtils.SECURITY_MARKER, errorMsg);
                            MDC.clear();
                            throw new SecurityException(errorMsg);
                        }
                        subject.getAuthorizedWriteDests().put(messageSend.getDestination(), messageSend.getDestination());
                        messageSend.setProperty(SerializationConstants.userUri, subject.getAnzoPrincipal().getUserURI().toString());
                    }
                } finally {
                    if (opContext != null) {
                        opContext.clearMDC();
                    }
                }
            } /*else if (messageSend.getDestination().getPhysicalName().startsWith("services/")) {
                           Set<Destination> dests = next.getDestinations(messageSend.getDestination());
                           if (dests == null || dests.size() == 0) {
                               if (messageSend.getReplyTo() != null && messageSend.getCorrelationId() != null) {
                                   Message reply = messageSend.copy();
                                   reply.setDestination(messageSend.getReplyTo());
                                   try {
                                       reply.clearBody();
                                   } catch (javax.jms.JMSException e) {

                                   }
                                   reply.setProperty("error", "true");
                                   next.send(exchange, reply);
                               }
                               //throw new IllegalArgumentException("User " + subject.getUserName() + " is not authorized to publish to: " + messageSend.getDestination() + " since is does not yet exist");
                           }
                       }*/
            subject.getAuthorizedWriteDests().put(messageSend.getDestination(), messageSend.getDestination());
        }
        super.send(exchange, messageSend);
        //     } finally {
        //         resetlock.readLock().unlock();
        //     }
    }

    void refreshNamedGraphAcl(URI namedGraphUri) throws AnzoException {
        if (primaryDatasource != null) {
            String uuid = null;
            IOperationContext opContext = null;
            try {
                opContext = new BaseOperationContext(HANDLE_ACLS_UPDATE, HANDLE_ACLS_UPDATE + namedGraphUri, principal);
                opContext.setMDC();
                uuid = primaryDatasource.getModelService().getUUIDforUri(opContext, namedGraphUri).toString();
            } catch (AnzoException e) {
                String logMsg = Messages.formatString(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GRAPH_NOT_VALID, namedGraphUri.toString());
                log.warn(LogUtils.COMBUS_MARKER, logMsg);
            } finally {
                if (opContext != null) {
                    opContext.clearMDC();
                }
            }

            if (uuid != null) {
                String destName = UriGenerator.generateEncapsulatedString(NAMESPACES.NAMEDGRAPH_TOPIC_PREFIX, uuid);
                ActiveMQDestination destination = ActiveMQDestination.createDestination(destName, ActiveMQDestination.TOPIC_TYPE);
                for (SecurityContext sc : securityContexts) {
                    sc.getAuthorizedReadDests().remove(destination);
                    sc.getAuthorizedWriteDests().remove(destination);
                }
            }
        }
    }

    static class ServerSecurityContext extends SecurityContext {

        private final Set<String>   roles;

        private final AnzoPrincipal principal;

        ServerSecurityContext(AnzoPrincipal principal) {
            super(principal.getName());
            this.principal = principal;
            this.roles = new HashSet<String>();
            for (URI uri : principal.getRoles()) {
                roles.add(uri.toString());
            }
        }

        /**
         * @return the principal
         */
        public AnzoPrincipal getAnzoPrincipal() {
            return principal;
        }

        @Override
        public Set<String> getPrincipals() {
            return roles;
        }
    }

}
