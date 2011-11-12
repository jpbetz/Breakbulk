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
package org.openanzo.client.cli;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.jms.TextMessage;

import org.openanzo.analysis.RequestHandler;
import org.openanzo.analysis.RequestRecorder;
import org.openanzo.combus.ActiveMqProvider;
import org.openanzo.combus.CombusConnection;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IModelService;
import org.openanzo.datasource.IQueryService;
import org.openanzo.datasource.IReplicationService;
import org.openanzo.datasource.IResetService;
import org.openanzo.datasource.IUpdateService;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.COMBUS;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.INotificationRegistrationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.BaseOperationContext;

/**
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class PlaybackHandler implements RequestHandler {

    private final Map<String, String>           credentials;

    private Map<String, CombusConnection>       connections                = new HashMap<String, CombusConnection>();

    private final String                        host;

    private final int                           port;

    private final boolean                       useSsl;

    private long                                timeout                    = 60000;

    private final Set<String>                   allowedDestinations;

    private final String                        bodyPattern;

    private final HashMap<String, List<String>> propFilter;

    long                                        overallStartTime           = 0;

    long                                        totalRequestsSent          = 0;

    long                                        requestDurationTotal       = 0;

    private boolean                             firstRequest               = true;

    SortedMap<String, Long>                     perOperationDurationTotals = new TreeMap<String, Long>();

    SortedMap<String, Long>                     perOperationCounts         = new TreeMap<String, Long>();

    private final int                           id;

    private static final Map<String, String>    SERVICES                   = new HashMap<String, String>();

    static {
        SERVICES.put(COMBUS.REPLICATION_SERVICE_QUEUE, IReplicationService.SERVICE_NAME);
        SERVICES.put(COMBUS.QUERY_SERVICE_QUEUE, IQueryService.SERVICE_NAME);
        SERVICES.put(COMBUS.MODEL_SERVICE_QUEUE, IModelService.SERVICE_NAME);
        SERVICES.put(COMBUS.AUTHORIZATION_SERVICE_QUEUE, IAuthorizationService.SERVICE_NAME);
        SERVICES.put(COMBUS.NOTIFICATION_SERVICE_QUEUE, INotificationRegistrationService.SERVICE_NAME);
        SERVICES.put(COMBUS.UPDATE_SERVICE_QUEUE, IUpdateService.SERVICE_NAME);
        SERVICES.put(COMBUS.RESET_SERVICE_QUEUE, IResetService.SERVICE_NAME);
        SERVICES.put(COMBUS.EXECUTION_SERVICE_QUEUE, IExecutionService.SERVICE_NAME);
    }

    /**
     * Create a playback handler
     * 
     * @param id
     *            id of the playback
     * @param credentials
     *            credentials to use for connection
     * @param host
     *            hostname for server
     * @param port
     *            port for server
     * @param useSsl
     *            use ssl
     * @param timeout
     *            timeout for operations
     * @param bodyPattern
     * 
     * @param allowedDestinations
     * 
     * @param propFilter
     */
    public PlaybackHandler(int id, HashMap<String, String> credentials, String host, int port, boolean useSsl, String timeout, String bodyPattern, Set<String> allowedDestinations, HashMap<String, List<String>> propFilter) {
        this.id = id;
        this.credentials = credentials;
        this.host = host;
        this.port = port;
        this.useSsl = useSsl;
        if (timeout != null) {
            this.timeout = Long.parseLong(timeout);
        }
        this.allowedDestinations = allowedDestinations;
        this.bodyPattern = bodyPattern;
        this.propFilter = propFilter;
    }

    public Object handleRequest(String body, Map<String, String> properties, String requestUser, String runAsUser, String destination, String jmsCorrelationId) throws Exception {

        if (id > 0) {
            jmsCorrelationId = jmsCorrelationId + "-" + id;
        }

        if (firstRequest) {
            overallStartTime = System.currentTimeMillis();
            firstRequest = false;
        }

        String service = SERVICES.get(destination);
        if (service == null && allowedDestinations == null) {
            throw new CommandException("Unknown destination: " + destination);
        }

        if (allowedDestinations != null && !allowedDestinations.contains(service)) {
            return null;
        }
        if (bodyPattern != null && body.indexOf(bodyPattern) == -1) {
            return null;
        }

        if (propFilter != null) {
            boolean found = false;
            for (String prop : propFilter.keySet()) {
                List<String> vals = propFilter.get(prop);
                for (String val : vals) {
                    if (prop.equals(RequestRecorder.REQUEST_USER)) {
                        if (requestUser.indexOf(val) != -1) {
                            found = true;
                            break;
                        }
                    }

                    if (prop.equals(RequestRecorder.REQUEST_RUN_AS_USER)) {
                        if (runAsUser.indexOf(val) != -1) {
                            found = true;
                            break;
                        }
                    }

                    if (prop.equals(RequestRecorder.DESTINATION)) {
                        if (destination.indexOf(val) != -1) {
                            found = true;
                            break;
                        }
                    }

                    if (prop.equals(RequestRecorder.JMS_CORRELATION_ID)) {
                        if (jmsCorrelationId.indexOf(val) != -1) {
                            found = true;
                            break;
                        }
                    }

                    String propVal = properties.get(prop);
                    if (propVal != null && propVal.indexOf(val) != -1) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                return null;
            }

        }

        CombusConnection connection = connections.get(requestUser);
        if (connection == null) {
            connection = new CombusConnection(new ActiveMqProvider(false), requestUser, credentials.get(requestUser), host, port, useSsl);
            connection.connect();
            connections.put(requestUser, connection);
        }

        String user = requestUser;
        if (runAsUser != null) {
            user = runAsUser;
        }
        AnzoPrincipal principal = new AnzoPrincipal(user, null, Collections.<URI> emptySet(), false, Constants.DEFAULT_ANONYMOUS_USER.equals(user));

        IOperationContext ctx = new BaseOperationContext("playback: " + properties.get("operation"), jmsCorrelationId, principal);

        TextMessage request = connection.createMessage();
        request.setText(body);
        for (String name : properties.keySet()) {
            request.setStringProperty(name, properties.get(name));
        }

        String operation = properties.get("operation");
        System.out.println("Client (" + id + ") Request sent " + operation + "(" + jmsCorrelationId + ") ");
        long start = System.currentTimeMillis();
        TextMessage response = connection.requestResponse(ctx, service, request, timeout);
        long end = System.currentTimeMillis();
        long requestDuration = end - start;
        System.out.println("Client (" + id + ") Request complete " + operation + "(" + jmsCorrelationId + ") " + requestDuration);

        requestDurationTotal += requestDuration;
        totalRequestsSent++;
        Long current = perOperationDurationTotals.get(operation);
        perOperationDurationTotals.put(operation, (current == null ? 0 : current.longValue()) + requestDuration);
        current = perOperationCounts.get(operation);
        perOperationCounts.put(operation, (current == null ? 0 : current.longValue()) + 1);
        return response;
    }

    public void handleResponse(String body, Map<String, String> properties, Map<String, String> analysisProperties, String jmsCorrelationId) {
        // nothing to do here.
    }

}
