/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.standalone/src/com/ibm/adtech/boca/standalone/ValidationServlet.java,v $
 * Created by:  Ben Szekely ( <a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com </a>
 * Created on:  3/22/2006
 * Revision:	$Id: ValidationServlet.java 160 2007-07-31 14:11:05Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.servlet.validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.combus.CombusProperties;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.URI;
import org.openanzo.services.ServicesProperties;

/**
 * get Test servlet that allows one to validate that the server is running correctly
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class ValidationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Create servlet
     */
    public ValidationServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    Properties getInitProperties() {
        Properties properties = new Properties();
        @SuppressWarnings("unchecked")
        // javax.servlet.GenericServlet returns unchecked value
        Enumeration e = getInitParameterNames();
        String paramName;
        String paramValue;
        while (e.hasMoreElements()) {
            paramName = (String) e.nextElement();
            paramValue = getInitParameter(paramName);
            properties.put(paramName, paramValue);
        }
        return properties;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties initProperties = getInitProperties();
        int port = CombusProperties.getPort(initProperties);
        String host = CombusProperties.getHost(initProperties);
        String user = ServicesProperties.getUser(initProperties, "default");
        String password = null;
        try {
            password = ServicesProperties.getPassword(initProperties, "123");
        } catch (AnzoException ae) {
            throw new AnzoRuntimeException(ae);
        }
        boolean useSsl = false;
        AnzoClient anzoClient = null;
        try {
            Properties configurationGraph = AnzoClientConfigurationFactory.createJMSConfiguration(user, password, host, port, useSsl);
            URI uri = Constants.valueFactory.createURI("http://openanzo.org/validation/ng1");
            anzoClient = new AnzoClient(configurationGraph);
            anzoClient.connect();
            resp.getWriter().println("Fetching remote model....");
            INamedGraph serverGraph = anzoClient.getServerGraph(uri);
            resp.getWriter().println("...done");
            URI res1 = Constants.valueFactory.createURI("http://example.org/res1");
            URI prop1 = Constants.valueFactory.createURI("http://example.org/prop1");
            anzoClient.begin();
            try {
                // do whatever you want to the model, read write,etc..
                resp.getWriter().println("Adding properties to model...");
                serverGraph.add(Constants.valueFactory.createStatement(res1, prop1, Constants.valueFactory.createLiteral("value1")));
                serverGraph.add(Constants.valueFactory.createStatement(res1, prop1, Constants.valueFactory.createLiteral("value2")));
                resp.getWriter().println("...done");
                resp.getWriter().println("Committing transaction....");
                anzoClient.commit();
            } catch (Exception e) {
                anzoClient.abort();
                throw e;
            }
            resp.getWriter().println("...done ");
            resp.getWriter().println("Updating repository");
            anzoClient.updateRepository();
            resp.getWriter().println("...done" + serverGraph.size());
            anzoClient.close();
            resp.getWriter().println("All is well.");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, sw.toString());
        } finally {
            if (anzoClient != null)
                anzoClient.close();
            resp.getWriter().flush();
            resp.getWriter().close();
        }
    }
}
