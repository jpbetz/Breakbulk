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

import java.util.List;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.client.ITransactionListener;
import org.openanzo.client.RealtimeUpdateManager;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.ITracker;

/**
 * 
 * This simple example instantiates a client AnzoClient that connects to the server. This example works against the ready-to-run standalone server.
 * <p>
 * In this example we show how to use the realtime update system to receive notification about global statements updates and transactions
 * <p>
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>
 * 
 */
public class RealtimeUpdates {
    /**
     * Test realtime updates
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

            // get the realtime update manager.  
            RealtimeUpdateManager realtimeUpdates = anzoClient.getRealtimeUpdates();
            URI prop1 = Constants.valueFactory.createURI("http://example.org/prop1");
            // add tracker that will fire whenever a statement is added or removed in the system
            // whose predicate is prop1.  
            realtimeUpdates.addTracker(null, prop1, null, null, new IStatementListener<ITracker>() {

                public void statementsAdded(ITracker source, Statement... statements) {
                    System.err.println("Statement Added: " + statements[0]);
                }

                public void statementsRemoved(ITracker source, Statement... statements) {
                    System.err.println("Statement Removed: " + statements[0]);
                }

            });

            realtimeUpdates.addTransactionListener(new ITransactionListener() {
                public void transactionComplete(URI transactionURI, long transactionTimestamp, Set<URI> transactionGraphs, IDataset transactionContext) {
                    System.err.println("Transaction Complete: " + transactionURI);
                    System.err.println("Graphs affected: " + transactionGraphs);
                    System.err.println("Context statements: " + transactionContext.getStatements());
                    System.err.println("-------------------------------");
                }

                public void transactionFailed(URI transactionURI, Set<URI> transactionGraphs, IDataset transactionContext, List<AnzoException> errors) {
                    // this event will never be fired due to realtime updates
                }
            });

            // always use try-finally to make sure the graph is closed.
            URI namedGraphURI = Constants.valueFactory.createURI("http://example.org/ng1");
            IAnzoGraph replicaGraph = null;
            try {

                URI res1 = Constants.valueFactory.createURI("http://example.org/res1");

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
