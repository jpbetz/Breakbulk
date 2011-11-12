/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.analysis;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Request recorder
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class RequestRecorder {
    protected static final Logger log                 = LoggerFactory.getLogger(RequestRecorder.class);

    /** JMS correlation ID */
    public static final String    JMS_CORRELATION_ID  = "jmsCorrelationId";

    /** JMS reply to destination */
    public static final String    REPLY_TO            = "replyTo";

    /** JMS Destination */
    public static final String    DESTINATION         = "destination";

    /** JMS Request user */
    public static final String    REQUEST_USER        = "requestUser";

    /** JMS Request RunAs user */
    public static final String    REQUEST_RUN_AS_USER = "requestRunAsUser";

    private String                location            = null;

    private Set<String>           excludedQueues      = null;

    /**
     * Request Recorder
     * 
     * @param location
     *            location of output
     * @param excludedQueues
     *            set of queue names to exclude from recording
     */
    public RequestRecorder(String location, Set<String> excludedQueues) {
        log.debug(LogUtils.LIFECYCLE_MARKER, "Setting Combus Endpoint Recorder: {}", location);
        this.location = location;
        this.excludedQueues = excludedQueues;
    }

    private boolean handleMessage(TextMessage message) {
        try {
            return excludedQueues == null || !excludedQueues.contains(message.getJMSDestination().toString());
        } catch (JMSException jmsex) {
            return true;
        }
    }

    /**
     * Record a request
     * 
     * @param request
     *            request to record
     * @param user
     *            user making request
     * @param runAsUser
     *            runas user making request
     * @throws AnzoException
     */
    public void recordRequest(TextMessage request, String user, String runAsUser) throws AnzoException {
        try {
            if (handleMessage(request)) {
                Map<String, String> props = getCommonProperties(request);
                getRequestProperties(request, props, user, runAsUser);
                recordEntry("@request", props, request.getText());
            }
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.COMBUS.RECORDER_ERROR, e, "Error recording request");
        }
    }

    /**
     * Record response
     * 
     * @param response
     *            response to request
     * @throws AnzoException
     */
    public void recordResponse(TextMessage response) throws AnzoException {
        try {
            if (handleMessage(response)) {
                Map<String, String> props = getCommonProperties(response);
                getResponseProperties(props);
                recordEntry("@response", props, response.getText());
            }
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.COMBUS.RECORDER_ERROR, e, "Error recording response");
        }
    }

    /**
     * Record response
     * 
     * @param jmsCorrelationId
     *            correlation id of request
     * @param operation
     *            operation name
     * @throws AnzoException
     */
    public void recordResponse(String jmsCorrelationId, String operation) throws AnzoException {
        try {
            Map<String, String> props = getCommonProperties(jmsCorrelationId, operation);
            getResponseProperties(props);
            recordEntry("@response", props, "NO RESPONSE TEXT");
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.COMBUS.RECORDER_ERROR, e, "Error recording response");
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> getCommonProperties(TextMessage msg) throws Exception {
        HashMap<String, String> props = new HashMap<String, String>();
        Enumeration<String> names = msg.getPropertyNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = msg.getStringProperty(name);
            props.put(name, value);
        }
        if (msg.getJMSCorrelationID() != null) {
            props.put(JMS_CORRELATION_ID, msg.getJMSCorrelationID());
        }
        return props;
    }

    private Map<String, String> getCommonProperties(String jmsCorrelationId, String operation) throws Exception {
        HashMap<String, String> props = new HashMap<String, String>();
        props.put(JMS_CORRELATION_ID, jmsCorrelationId);
        props.put("operation", operation);
        return props;
    }

    private void getRequestProperties(TextMessage msg, Map<String, String> properties, String user, String runAsUser) throws Exception {
        if (msg.getJMSDestination() != null) {
            properties.put(DESTINATION, msg.getJMSDestination().toString());
        }
        if (msg.getJMSReplyTo() != null) {
            properties.put(REPLY_TO, msg.getJMSReplyTo().toString());
        }
        properties.put(REQUEST_USER, user);
        if (runAsUser != null) {
            properties.put(REQUEST_RUN_AS_USER, runAsUser);
        }
    }

    private void getResponseProperties(Map<String, String> properties) throws Exception {
        for (String name : RequestAnalysis.getAnalysisPropertyNames()) {
            properties.put(name, RequestAnalysis.getAnalysisProperty(name).toString());
        }
    }

    private synchronized void recordEntry(String header, Map<String, String> properties, String body) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append(header).append("\r\n");
        builder.append("@properties").append("\r\n");
        TreeMap<String, String> sortedProperties = new TreeMap<String, String>(properties);
        for (Map.Entry<String, String> entry : sortedProperties.entrySet()) {
            builder.append(entry.getKey()).append("=").append(entry.getValue()).append("\r\n");
        }
        if (body != null) {
            builder.append("@body").append("\r\n");
            builder.append(body).append("\r\n");
        }
        Writer writer = new OutputStreamWriter(new FileOutputStream(location, true), "UTF-8");

        writer.write(builder.toString());
        writer.flush();
        writer.close();
    }

    /**
     * Close the recorder
     */
    public void close() {

    }

}
