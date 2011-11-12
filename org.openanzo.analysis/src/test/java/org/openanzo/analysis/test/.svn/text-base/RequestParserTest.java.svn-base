/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.analysis.test;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;

import junit.framework.TestCase;

import org.openanzo.analysis.RequestHandler;
import org.openanzo.analysis.RequestParser;

/**
 * Test the request parser
 * 
 */
public class RequestParserTest extends TestCase {
    /**
     * 
     * @throws Exception
     */
    public void testParser() throws Exception {

        RequestHandler handler = new RequestHandler() {

            public Object handleRequest(String body, Map<String, String> properties, String requestUser, String runAsUser, String destination, String jmsCorrelationId) throws Exception {
                System.err.println("REQUEST");
                System.err.println(body);
                System.err.println("requestUser: " + requestUser);
                System.err.println("runAsUser: " + runAsUser);
                System.err.println("destination: " + destination);
                System.err.println("jmsCorrelationId: " + jmsCorrelationId);
                for (String name : properties.keySet()) {
                    System.err.println(name + " : " + properties.get(name));
                }
                return null;
            }

            public void handleResponse(String body, Map<String, String> properties, Map<String, String> analysisProperties, String jmsCorrelationId) {
                System.err.println("RESPONSE");
                System.err.println(body);
                System.err.println("jmsCorrelationId: " + jmsCorrelationId);

                for (String name : properties.keySet()) {
                    System.err.println(name + " :prop: " + properties.get(name));
                }

                for (String name : analysisProperties.keySet()) {
                    System.err.println(name + " :ans: " + analysisProperties.get(name));
                }

            }

        };

        RequestParser parser = new RequestParser();
        parser.parseRequest(new InputStreamReader(new FileInputStream("etc/sample-requests.txt"), "UTF-8"), handler);

    }
}
