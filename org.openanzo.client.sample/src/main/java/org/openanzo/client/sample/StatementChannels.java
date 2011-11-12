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
import java.util.HashMap;
import java.util.Map;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.client.IStatementChannel;
import org.openanzo.client.IStatementChannelListener;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;

/**
 * 
 * This simple example instantiates a client AnzoClient that connects to the server. This example works against the ready-to-run standalone server.
 * <p>
 * In this example, we use a replica graph to access a named graph on the server, and store the graph locally.
 * <p>
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>
 * 
 */
public class StatementChannels {
    /**
     * Test statement channels
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        AnzoClient anzoClient = null;

        // use a try-finally to make sure the anzoClients are closed properly
        try {

            // prepare the configuration for the client
            String username = "default";
            String password = "123";
            String host = "localhost";
            int port = 61616;
            boolean useSsl = false;

            // instantiate a anzo client
            anzoClient = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration(username, password, host, port, useSsl));
            // connect the client
            anzoClient.connect();

            // always use try-finally to make sure the graph is closed.
            URI namedGraphURI = Constants.valueFactory.createURI("http://example.org/ng1");

            // create a statement channel.
            IStatementChannel channel = anzoClient.getStatementChannel(namedGraphURI);

            // for the channel to be active, we must perform an update repository since
            // the underly graph must be created.
            anzoClient.updateRepository();

            channel.registerListener(new IStatementChannelListener() {

                public void statementsReceived(Map<String, Object> messageProperties, Collection<Statement> statements) {
                    System.err.println("Properties: " + messageProperties);
                    System.err.println("Statements: " + statements);
                }

                public void channelClosed() {

                }

            });

            Map<String, Object> props = new HashMap<String, Object>();
            props.put("prop1", "val1");

            IQuadStore quadStore = new MemQuadStore();
            URI res1 = Constants.valueFactory.createURI("http://example.org/res1");
            URI prop1 = Constants.valueFactory.createURI("http://example.org/prop1");

            quadStore.add(res1, prop1, Constants.valueFactory.createLiteral("value1"), res1);
            quadStore.add(res1, prop1, Constants.valueFactory.createLiteral("value2"), res1);

            channel.sendMessage(props, quadStore.getStatements());

        } finally {
            if (anzoClient != null)
                anzoClient.close();
        }
    }

}
