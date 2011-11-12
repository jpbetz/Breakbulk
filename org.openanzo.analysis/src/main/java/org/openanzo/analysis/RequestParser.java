/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.analysis;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * Parse requests
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 */
public class RequestParser {

    /**
     * Parse request information from reader
     * 
     * @param in
     *            input reader
     * @param handler
     *            handler to handle requests
     * @throws Exception
     */
    @SuppressWarnings("null")
    public void parseRequest(Reader in, RequestHandler handler) throws Exception {

        BufferedReader reader = new BufferedReader(in);
        boolean request = true;
        Map<String, String> msgProps = null;
        StringBuilder body = null;
        boolean firstBodyLine = false;

        String line = reader.readLine();
        while (line != null) {
            if (line.startsWith("@request") || line.startsWith("@response") || (line.startsWith("@properties") && body != null)) {
                if (msgProps != null) {
                    if (request) {
                        handleRequest(handler, body != null ? body.toString() : "", msgProps);
                    } else {
                        handleResponse(handler, body != null ? body.toString() : "", msgProps);
                    }
                }
                msgProps = null;
                body = null;
                request = line.startsWith("@request");
            } else if (line.startsWith("@properties")) {
                msgProps = new HashMap<String, String>();
            } else if (line.startsWith("@body")) {
                body = new StringBuilder();
                firstBodyLine = true;
            } else {
                if (msgProps != null && body == null) {
                    String[] parts = StringUtils.split(line, '=');
                    if (parts.length == 2) {
                        msgProps.put(parts[0], parts[1]);
                    }
                } else {
                    if (!firstBodyLine) {
                        body.append("\n");
                    } else {
                        firstBodyLine = false;
                    }
                    body.append(line);
                }
            }

            line = reader.readLine();
        }

        if (msgProps != null) {
            if (request) {
                handleRequest(handler, body.toString(), msgProps);
            } else {
                handleResponse(handler, body.toString(), msgProps);
            }
        }

    }

    private void handleRequest(RequestHandler handler, String body, Map<String, String> props) throws Exception {
        String requestUser = null;
        String runAsUser = null;
        String destination = null;
        String jmsCorrelationId = null;
        Map<String, String> reqProps = new HashMap<String, String>();

        for (Map.Entry<String, String> entry : props.entrySet()) {

            if (entry.getKey().equals(RequestRecorder.REQUEST_USER)) {
                requestUser = entry.getValue();
            } else if (entry.getKey().equals(RequestRecorder.REQUEST_RUN_AS_USER)) {
                runAsUser = entry.getValue();
            } else if (entry.getKey().equals(RequestRecorder.DESTINATION)) {
                destination = entry.getValue();
                destination = destination.substring(8);
            } else if (entry.getKey().equals(RequestRecorder.JMS_CORRELATION_ID)) {
                jmsCorrelationId = entry.getValue();
            } else {
                reqProps.put(entry.getKey(), entry.getValue());
            }
        }

        handler.handleRequest(body, reqProps, requestUser, runAsUser, destination, jmsCorrelationId);
    }

    private void handleResponse(RequestHandler handler, String body, Map<String, String> props) throws Exception {

        Map<String, String> reqProps = new HashMap<String, String>();
        Map<String, String> ansProps = new HashMap<String, String>();
        String jmsCorrelationId = null;

        for (Map.Entry<String, String> entry : props.entrySet()) {
            if (entry.getKey().equals(RequestRecorder.JMS_CORRELATION_ID)) {
                jmsCorrelationId = props.get(entry.getValue());
            } else if (entry.getKey().startsWith(RequestAnalysis.ANS_PROP_PREFIX)) {
                ansProps.put(entry.getKey(), entry.getValue());
            } else {
                reqProps.put(entry.getKey(), entry.getValue());
            }
        }

        handler.handleResponse(body, reqProps, ansProps, jmsCorrelationId);

    }

}
