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
import java.util.Collections;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;

/**
 * 
 * This simple example instantiates a client AnzoClient that connects to the server. This example works against the ready-to-run standalone server.
 * <p>
 * In this example, show how to perform Sparql query and pattern-based find operations against both the local replica and the server.
 * <p>
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>
 * 
 */
public class QueryAndFind {
    /**
     * Test query find
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
            URI namedGraphURI2 = Constants.valueFactory.createURI("http://example.org/ng2");
            IAnzoGraph replicaGraph = null;
            try {

                URI res1 = Constants.valueFactory.createURI("http://example.org/res1");
                URI prop1 = Constants.valueFactory.createURI("http://example.org/prop1");
                // start a transaction in which we will create a graph and add some statements to it.
                anzoClient.begin();
                try {
                    // create the replica graph object. 
                    replicaGraph = anzoClient.getReplicaGraph(namedGraphURI);
                    replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value1"));
                    replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value2"));
                    replicaGraph = anzoClient.getReplicaGraph(namedGraphURI2);
                    replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value3"));
                    replicaGraph.add(res1, prop1, Constants.valueFactory.createLiteral("value4"));
                    anzoClient.commit();
                } catch (Exception e) {
                    anzoClient.abort();
                    throw e;
                }
                anzoClient.updateRepository();

                // perform a Sparql query against the server.
                // The query will find all statements in the default
                // graphs specified for the query. In this case
                // we supply the set of all named graph on the server
                // as the default graphs.

                String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
                QueryResults results = anzoClient.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query);
                SolutionSet solutions = results.getSelectResults();
                System.err.println("Server query found " + solutions.size() + " solutions");

                // perform a Sparql query against the local replica.
                // The query will find all statements in the default
                // graphs specified for the query. In this case
                // we supply the set of all graphs on the server
                // as the default graphs.  This includes metadata graphs
                // so we will receive considerably more results

                query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
                results = anzoClient.replicaQuery(Collections.singleton(GRAPHS.ALL_GRAPHS), null, null, query, null);
                solutions = results.getSelectResults();
                System.err.println("Replica query found " + solutions.size() + " solutions");

                // perform a pattern-based find against the server
                Collection<Statement> stmts = anzoClient.serverFind(null, null, null, namedGraphURI);
                System.err.println("Found " + stmts.size() + " statements on server");

                // perform a pattern-based find against the replica
                stmts = anzoClient.replicaFind(null, prop1, null, (URI[]) null);
                System.err.println("Found " + stmts.size() + " statements in local replica");

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
