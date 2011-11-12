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

import java.util.HashSet;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.URI;

/**
 * 
 * This simple example instantiates a client AnzoClient that connects to the server. This example works against the ready-to-run standalone server.
 * <p>
 * In this example we show the various dataset facilities provided by AnzoClient.
 * <p>
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>
 * 
 */
public class Datasets {
    /**
     * Test datasets
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

            URI datasetURI = Constants.valueFactory.createURI("http://example.org/ds1");
            URI namedGraphURI1 = Constants.valueFactory.createURI("http://example.org/ng1");
            URI namedGraphURI2 = Constants.valueFactory.createURI("http://example.org/ng2");
            URI namedGraphURI3 = Constants.valueFactory.createURI("http://example.org/ng3");
            Set<URI> graphUris = new HashSet<URI>();
            graphUris.add(namedGraphURI1);
            graphUris.add(namedGraphURI2);
            graphUris.add(namedGraphURI3);
            IDataset replicaDataset = null;
            IDataset serverDataset = null;
            try {
                URI res1 = Constants.valueFactory.createURI("http://example.org/res1");
                URI prop1 = Constants.valueFactory.createURI("http://example.org/prop1");
                // start a transaction in which we will create a graph and add some statements to it.
                anzoClient.begin();
                try {
                    // we first demonstrate replica and server datasets.

                    // create a replica dataset
                    // the true argument indicates that we want to store 
                    // dataset definition (graphs) on the server. 
                    // named datasets are first class facility in Anzo, and may be used to simplify querying
                    replicaDataset = anzoClient.createReplicaDataset(true, datasetURI, graphUris, graphUris);
                    replicaDataset.add(res1, prop1, Constants.valueFactory.createLiteral("value1"), namedGraphURI1);
                    replicaDataset.add(res1, prop1, Constants.valueFactory.createLiteral("value1"), namedGraphURI2);
                    replicaDataset.add(res1, prop1, Constants.valueFactory.createLiteral("value1"), namedGraphURI3);
                    anzoClient.commit();
                } catch (Exception e) {
                    anzoClient.abort();
                    throw e;
                }
                anzoClient.updateRepository();

                // because the dataset has been stored on the server, we can use stored
                // dataset to instantiate a server dataset. 

                serverDataset = anzoClient.createServerDataset(true, datasetURI, null, null);

                System.err.println("Server Dataset URIs:");
                System.err.println(serverDataset.getNamedGraphUris());
                System.err.println("Server Dataset statements:");
                System.err.println(serverDataset.getStatements());

                // the next two datasets are maintained automatically by AnzoClient,
                // containing all replica and server graphs.  
                IDataset allReplicaGraphs = anzoClient.getAllReplicaGraphsDataset();
                // note that the size() method on the dataset itself is the number of statements in the dataset.
                // This statement will print "4", accounting for the graphs used to maintain the datasets
                System.err.println("number of replica graphs: " + allReplicaGraphs.getNamedGraphUris().size());
                IDataset allServerGraphs = anzoClient.getAllServerGraphsDataset();
                System.err.println("number of server graphs: " + allServerGraphs.getNamedGraphUris().size());

            } finally {
                if (replicaDataset != null) {
                    replicaDataset.close();
                }
                if (serverDataset != null) {
                    serverDataset.close();
                }
            }
        } finally {
            if (anzoClient != null)
                anzoClient.close();
        }
    }

}
