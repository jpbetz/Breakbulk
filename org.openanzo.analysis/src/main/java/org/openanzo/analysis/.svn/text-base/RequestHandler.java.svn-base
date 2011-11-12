/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.analysis;

import java.util.Map;

/**
 * Request handler
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface RequestHandler {
    /**
     * Handle a request
     * 
     * @param body
     *            body of the request
     * @param properties
     *            properties of the request
     * @param requestUser
     *            request user
     * @param runAsUser
     *            runas user
     * @param destination
     *            destination of request
     * @param jmsCorrelationId
     *            correlation id
     * @return object
     * @throws Exception
     */
    public Object handleRequest(String body, Map<String, String> properties, String requestUser, String runAsUser, String destination, String jmsCorrelationId) throws Exception;

    /**
     * Handle a response
     * 
     * @param body
     *            body of the response
     * @param properties
     *            properties of the response
     * @param analysisProperties
     *            properties of analysis
     * @param jmsCorrelationId
     *            correlation id
     */
    public void handleResponse(String body, Map<String, String> properties, Map<String, String> analysisProperties, String jmsCorrelationId);

}
