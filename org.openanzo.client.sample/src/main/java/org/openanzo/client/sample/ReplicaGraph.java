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

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
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
public class ReplicaGraph {
    /**
     * Test replica graph
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
            IAnzoGraph replicaGraph = null;
            try {

                URI res1 = Constants.valueFactory.createURI("http://example.org/res1");
                URI prop1 = Constants.valueFactory.createURI("http://example.org/prop1");
                // start a transaction in which we will create a graph and add some statements to it.
                anzoClient.begin();
                try {
                    // create the replica graph object. 
                    replicaGraph = anzoClient.getReplicaGraph(namedGraphURI);
                    // do whatever you want to the graph, read write,etc..
                    replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value1"));
                    replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value2"));
                    anzoClient.commit();
                } catch (Exception e) {
                    anzoClient.abort();
                    throw e;
                }
                anzoClient.updateRepository();

                System.err.println("The graph has statements: ");
                System.err.println(replicaGraph.getStatements());

                // we can register for events on replica graphs. These will fire whenever new statements
                // have been added to the local replica, either through automatic updates over JMS, or 
                // the updateRepository following a local modification.

                replicaGraph.registerListener(new IStatementListener<INamedGraph>() {

                    public void statementsAdded(INamedGraph source, Statement... statements) {
                        System.err.println("Statements added to: " + source.getNamedGraphUri());
                        for (int i = 0; i < statements.length; i++) {
                            System.err.println(statements[i]);
                        }
                    }

                    public void statementsRemoved(INamedGraph source, Statement... statements) {
                        System.err.println("Statements removed from: " + source.getNamedGraphUri());
                        for (int i = 0; i < statements.length; i++) {
                            System.err.println(statements[i]);
                        }
                    }

                });

                anzoClient.begin();
                replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value3"));
                replicaGraph.remove(res1, prop1, Constants.valueFactory.createLiteral("value2"));
                anzoClient.commit();
                anzoClient.updateRepository();

            } finally {
                if (replicaGraph != null) {
                    replicaGraph.close();
                }
            }
        } finally {
            if (anzoClient != null)
                anzoClient.close();
        }
    }

}
