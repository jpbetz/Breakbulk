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

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.client.INamedGraphInitializer;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.URI;
import org.openanzo.services.IPrecondition;

/**
 * 
 * This simple example instantiates a client AnzoClient that connects to the server. This example works against the ready-to-run standalone server.
 * <p>
 * In this example, we show how Named Graph Initializers can be used to help create named graphs with built-in and custom properties.
 * <p>
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>
 * 
 */
public class NamedGraphInitializers {
    /**
     * Test graph initializers
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

            IAnzoGraph replicaGraph = null;
            try {
                final URI namedGraphURI = Constants.valueFactory.createURI("http://example.org/ng1");
                final URI res1 = Constants.valueFactory.createURI("http://example.org/res1");
                final URI prop1 = Constants.valueFactory.createURI("http://example.org/prop1");

                // a named graph initializer implements a simple interface for adding statements
                // to the graph on creation.

                INamedGraphInitializer initializer = new INamedGraphInitializer() {

                    public void initializeNamedGraph(IAnzoGraph namedGraph, boolean createNew) throws AnzoException {
                        // the createNew flag indicates whether or not
                        // the graph already exists on the server.
                        namedGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value1"));
                        namedGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value2"));
                        // we could of course also modify the metadata graph as well.
                    }

                    public Collection<IPrecondition> getPreconditions() {
                        // return any preconditions that must hold 
                        // before the graph is created on the server
                        return null;
                    }

                };

                anzoClient.begin();
                try {
                    // create the replica graph object with our chosen initializers.
                    // The Anzo Client API provides a few pre-defined initializers.  For
                    // example, we can supply initializers setup the graph non-revisioned,
                    // and make sure the graph does not already exist.
                    replicaGraph = anzoClient.getReplicaGraph(namedGraphURI, initializer, AnzoClient.GRAPH_MUST_NOT_EXIST, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
                    anzoClient.commit();
                } catch (Exception e) {
                    anzoClient.abort();
                    throw e;
                }
                anzoClient.updateRepository();

                System.err.println("The graph has statements: ");
                System.err.println(replicaGraph.getStatements());

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
