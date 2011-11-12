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

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.client.ITransactionListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.impl.Precondition;

/**
 * 
 * This simple example instantiates a client AnzoClient that connects to the server. This example works against the ready-to-run standalone server.
 * <p>
 * In this example show how to use transactions, including nested transactions, transaction contexts, preconditions and transaction events.
 * <p>
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>
 * 
 */
public class Transactions {
    /**
     * Test transactions
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

            // The AnzoClient provides events when transactions involving replica (or server) graphs complete.
            // The transactions may have been committed from this client, or another client connected
            // to the same server.
            anzoClient.registerTransactionListener(new ITransactionListener() {

                public void transactionComplete(URI transactionURI, long transactionTimestamp, Set<URI> transactionGraphs, IDataset transactionContext) {
                    System.err.println("Transaction Complete: " + transactionURI);
                    System.err.println("Graphs affected: " + transactionGraphs);
                    System.err.println("Context statements: " + transactionContext.getStatements());
                    System.err.println("-------------------------------");
                }

                public void transactionFailed(URI transactionURI, Set<URI> transactionGraphs, IDataset transactionContext, List<AnzoException> errors) {
                    System.err.println("Transaction Failed: " + transactionURI);
                    System.err.println("Graphs affected: " + transactionGraphs);
                    System.err.println("Context statements: " + transactionContext.getStatements());
                    System.err.println("Errors: " + errors);
                    System.err.println("-------------------------------");
                }

            });

            // always use try-finally to make sure the graph is closed.
            URI namedGraphURI = Constants.valueFactory.createURI("http://example.org/ng1");
            IAnzoGraph replicaGraph = null;
            try {

                URI res1 = Constants.valueFactory.createURI("http://example.org/res1");
                URI prop1 = Constants.valueFactory.createURI("http://example.org/prop1");
                // start a transaction in which we will create a graph and add some statements to it.
                anzoClient.begin();
                try {

                    // at any point in a transaction, we can add context statements via
                    // the transaction context graphs.  These statements are not stored
                    // but are provided in transaction events to signal semantics about
                    // a transaction.  Each nested transaction receives its own context graph,
                    // forming a Dataset 

                    // The URI of the context graph is the URI of the transaction to use in
                    // linking up with transaction events as registered above.
                    INamedGraph context = anzoClient.getTransactionContext();
                    URI contextProp = Constants.valueFactory.createURI("http://example.org/action");
                    context.add(context.getNamedGraphUri(), contextProp, Constants.valueFactory.createLiteral("createGraph"));

                    // create the replica graph object, as well as
                    // create the graph in the current transaction
                    replicaGraph = anzoClient.getReplicaGraph(namedGraphURI);

                    // we can add a precondition that must hold before we execute the transaction.
                    // in this case we test that one of the statements we are adding does not alreayd exist
                    IPrecondition precondition = new Precondition();
                    String queryString = "ASK  { <" + res1 + "> <" + prop1 + "> \"value1\"}";
                    precondition.setQuery(queryString);
                    precondition.setDefaultGraphUris(Collections.singleton(GRAPHS.ALL_GRAPHS));
                    precondition.setResult(false);

                    // we can perform the add inside a nested transaction with the precondition.
                    anzoClient.begin(Collections.singleton(precondition));
                    try {
                        replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value1"));
                        replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value2"));
                        anzoClient.commit();
                    } catch (Exception e) {
                        anzoClient.abort();
                        throw e;
                    }

                    // commit the outer transaction
                    anzoClient.commit();

                    // now we'll show an example of a transaction failing. 
                    // We'll try to perform an add using the same precondition
                    // which now won't hold because we've added the graph.  
                    // The successful transaction will still be applied to the server
                    // because it was a seperate transaction. 

                    anzoClient.begin(Collections.singleton(precondition));
                    try {
                        replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value1"));
                        replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value2"));
                        anzoClient.commit();
                    } catch (Exception e) {
                        anzoClient.abort();
                        throw e;
                    }

                } catch (Exception e) {
                    anzoClient.abort();
                    throw e;
                }

                // send the committed transactions to the repository

                try {
                    anzoClient.updateRepository();
                } catch (Exception e) {
                    System.err.println("As expected, at least one transaction in update failed");
                }

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
