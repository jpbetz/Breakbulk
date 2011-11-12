/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.analysis;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;

/**
 * 
 * @author Lee Feigenbaum ( <a href="mailto:lee@cambridgesemantics.com">lee@cambridgesemantics.com </a>)
 * 
 *         Outputs requests and responses with these fields:
 * 
 *         Type : "request" or "response" JMS Correlation ID : the correlation ID of the request/response Request User : the user that made the request (empty
 *         for responses) Run As User : the user that the request ran as (empty for responses) Destination : the destination service of the request (empty for
 *         responses) Prop1 Prop2 ... PropN : value (if any) of the property, for all properties mentioned in the full set of requests & responses handled Body
 *         : the body of the request or response
 * 
 *         Note: the current approach here stores everything in memory in order to be able to determine a complete set of properties before outputting anything
 *         (CSV is a "square" format and we'd like to treat properties as columns). If this becomes a problem, there are two solutions: + adapt the
 *         {@link RequestHandlerOutputProvider} pattern to allow a double pass through the data + output to a temporary file while accumulating properties, and
 *         at the end() transform the temp file to the final form
 * 
 */
public class CsvOutputRequestHandler implements RequestHandlerOutputProvider {

    private PrintStream out        = null;

    private Set<String> properties = new ListOrderedSet<String>();

    private static class Entry {
        private String              type;

        private String              jmsCorrelationId;

        private String              requestUser;

        private String              runAsUser;

        private String              destination;

        private Map<String, String> props;

        private String              body;

        private Entry(String type, String jmsCorrelationId, String requestUser, String runAsUser, String destination, Map<String, String> props, String body) {
            this.type = type;
            this.jmsCorrelationId = jmsCorrelationId;
            this.requestUser = requestUser;
            this.runAsUser = runAsUser;
            this.destination = destination;
            this.props = props;
            this.body = body;
        }
    }

    private ArrayList<Entry> entries = new ArrayList<Entry>();

    public Object handleRequest(String body, Map<String, String> properties, String requestUser, String runAsUser, String destination, String jmsCorrelationId) throws Exception {
        //System.err.println("handling *request*/response: "+ ++cnt);
        for (String k : properties.keySet())
            this.properties.add(k);
        this.entries.add(new Entry("request", jmsCorrelationId, requestUser, runAsUser, destination, properties, body));
        return null;
    }

    public void handleResponse(String body, Map<String, String> properties, Map<String, String> analysisProperties, String jmsCorrelationId) {
        //System.err.println("handling request/*response*: "+ ++cnt);
        for (String k : properties.keySet())
            this.properties.add(k);
        for (String k : analysisProperties.keySet())
            this.properties.add(k);
        Map<String, String> props = new HashMap<String, String>(properties);
        props.putAll(analysisProperties);
        this.entries.add(new Entry("response", jmsCorrelationId, "", "", "", props, body));
    }

    public void setOutputStream(PrintStream out) {
        this.out = out;
    }

    public void start() {
    }

    public void end() {
        this.out.print(prepareStringForCSVEntry("Type"));
        this.out.print(",");
        this.out.print(prepareStringForCSVEntry("JMS Correlation ID"));
        this.out.print(",");
        this.out.print(prepareStringForCSVEntry("Request User"));
        this.out.print(",");
        this.out.print(prepareStringForCSVEntry("Run As User"));
        this.out.print(",");
        this.out.print(prepareStringForCSVEntry("Destination"));
        for (String p : this.properties) {
            this.out.print(",");
            this.out.print(prepareStringForCSVEntry(p));
        }
        this.out.print(",");
        this.out.print(prepareStringForCSVEntry("Body"));
        this.out.println();
        for (Entry e : this.entries) {
            this.out.print(prepareStringForCSVEntry(e.type));
            this.out.print(",");
            this.out.print(prepareStringForCSVEntry(e.jmsCorrelationId));
            this.out.print(",");
            this.out.print(prepareStringForCSVEntry(e.requestUser));
            this.out.print(",");
            this.out.print(prepareStringForCSVEntry(e.runAsUser));
            this.out.print(",");
            this.out.print(prepareStringForCSVEntry(e.destination));
            for (String p : this.properties) {
                this.out.print(",");
                this.out.print(prepareStringForCSVEntry(e.props.get(p)));
            }
            this.out.print(",");
            this.out.print(prepareStringForCSVEntry(e.body));
            this.out.println();
        }
    }

    static private String prepareStringForCSVEntry(String s) {
        if (s == null || s.length() == 0)
            return "";
        // 1) replace any double quotes with doubled double quotes
        s = s.replace("\"", "\"\"");
        // 2) replace any tab characters with 4 space characters, since Excel doesn't handle tab characters in a cell
        s = s.replace("\t", "    ");
        // 3) wrap in double quotes
        return "\"" + s + "\"";
    }
}
