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
package org.openanzo.client.sample;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;

/**
 * 
 * This simple example instantiates a client AnzoClient that connects to the server. This example works against the ready-to-run standalone server.
 * <p>
 * In this example, we show how to execute a service that has been deployed on the server. The deployment of such services is beyond the scope of this example.
 * <p>
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>
 * 
 */
public class ExecuteService {
    /**
     * Execute service
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        AnzoClient anzoClient = null;

        // use a try-finally to make sure the anzoClients are closed properly
        try {

            // prepare the configuration for the client
            String username = "sysadmin";
            String password = "123";
            String host = "localhost";
            int port = 61616;
            boolean useSsl = false;
            // instantiate a anzo client
            anzoClient = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration(username, password, host, port, useSsl));
            // connect the client
            anzoClient.connect();

            // the echo service is a built in service used for testing purposes.
            URI serviceUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/echoService#echo");
            Set<Statement> statements = new HashSet<Statement>();
            URI res1 = Constants.valueFactory.createURI("http://example.org/res1");
            URI prop1 = Constants.valueFactory.createURI("http://example.org/prop1");
            Statement stmt = Constants.valueFactory.createStatement(res1, prop1, res1, res1);
            statements.add(stmt);

            Collection<Statement> result = anzoClient.executeService(serviceUri, statements);
            System.err.println("Received back: " + result);
        } finally {
            if (anzoClient != null)
                anzoClient.close();
        }
    }

}
