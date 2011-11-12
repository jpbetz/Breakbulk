/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test.client;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.test.AbstractTest;

/**
 * Test the server graphs provided by the <code>AnzoClient</code>.
 * 
 * @author Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * 
 */
public class TestEmbeddedServerGraphs extends AbstractTest {
    static final URI GRAPH_URI = Constants.valueFactory.createURI("http://graph1");

    /**
     * Test simple addition/deletion of statements to/from the server graph.
     * 
     * @throws Exception
     */
    /*public void testAddRemove() throws Exception {
        AnzoClient client = new AnzoClient(getEmbeddedClientConfiguration());
        try {
            client.connect();
            client.reset(loadStatements("initialize.trig"));
            ClientGraph graph = client.getServerGraph(GRAPH_URI);
            URI r = Constants.valueFactory.createURI("urn:test");
            graph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));
            client.updateRepository();
            // verify that is there
            // and in the first server graph
            assertTrue(graph.contains(r, RDF.TYPE, RDF.ALT));
            // try the deleteAll method
            graph.remove(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));

            client.updateRepository();

            assertFalse(graph.contains(r, RDF.TYPE, RDF.ALT));
        } finally {
            if (client != null)
                client.close();
        }
    }*/

    /**
     * Test simple addition/deletion of statements to/from the server graph.
     * 
     * @throws Exception
     */
    /* public void itestContinuousAdd() throws Exception {
        AnzoClient client = new AnzoClient(getEmbeddedClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"));
            ClientGraph graph = client.getServerGraph(GRAPH_URI);
            URI r = Constants.valueFactory.createURI("urn:test");
            for (int i = 0; i < 50000; i++) {
                System.err.println("Sent:" + i);
                graph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, Constants.valueFactory.createTypedLiteral(Integer.valueOf(i))));
                client.updateRepository();
                synchronized (r) {
                    r.wait(2000);
                }
            }
        } finally {
            if (client != null)
                client.close();
        }
    }
    */
    /**
     * Test transaction begin/commit on ServerGraph
     * 
     * @throws Exception
     */
    /* public void testSetServiceUser() throws Exception {

        AnzoClient client = new AnzoClient(getEmbeddedClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"));
            client.setServiceUser("default");
            ClientGraph graph = client.getServerGraph(GRAPH_URI);
            client.begin();
            URI r = Constants.valueFactory.createURI("urn:test");
            graph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));
            client.commit();
            client.updateRepository();
            assertTrue(graph.size() == 1);
            assertTrue(graph.contains(r, RDF.TYPE, RDF.ALT));
        } finally {
            if (client != null)
                client.close();
        }
    }
    */
    /**
     * Test adding and replicating to/with two server graphs.
     * 
     * @throws Exception
     */
    /*   public void testAddingAndReplicatingWithTwoServerGraphs() throws Exception {

        AnzoClient client = null;
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
            final Statement stmt2 = Constants.valueFactory.createStatement((createTestUri("subject2")), createTestUri("predicate2"), (createTestUri("object2")));
            final URI GRAPH_URI1 = Constants.valueFactory.createURI("http://GRAPH_URI1");
            final URI GRAPH_URI2 = Constants.valueFactory.createURI("http://GRAPH_URI2");

            client = new AnzoClient(getEmbeddedClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"));

            // ------------------------------------------------------------------
            // create a server graph, add a statement and replicate

            ClientGraph serverGraph1 = client.getServerGraph(GRAPH_URI1);
            serverGraph1.add(stmt1);
            client.updateRepository();

            // ------------------------------------------------------------------
            // create a server graph, add a statement and replicate

            ClientGraph serverGraph2 = client.getServerGraph(GRAPH_URI2);
            serverGraph2.add(stmt2);
            client.updateRepository();

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
    */
    /**
     * Test adding to and replicating with two server graphs located on two different clients
     * 
     * @throws Exception
     */
    /*  public void testAddingAndReplicatingWithTwoServerGraphsFromDifferentAnzoClients() throws Exception {

        if (MODE == EMBEDED)
            return;

        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
            final Statement stmt2 = Constants.valueFactory.createStatement((createTestUri("subject2")), createTestUri("predicate2"), (createTestUri("object2")));
            final URI GRAPH_URI1 = Constants.valueFactory.createURI("http://GRAPH_URI1");
            final URI GRAPH_URI2 = Constants.valueFactory.createURI("http://GRAPH_URI2");

            client1 = new AnzoClient(getEmbeddedClientConfiguration());
            client1.connect();
            client1.reset(loadStatements("initialize.trig"));
            client2 = new AnzoClient(getEmbeddedClientConfiguration());
            client2.connect();

            // ------------------------------------------------------------------
            // create a server graph, add a statement and replicate
            ClientGraph graph1 = client1.getServerGraph(GRAPH_URI1);
            graph1.add(stmt1);
            client1.updateRepository();

            // ------------------------------------------------------------------
            // create a server graph, add a statement and replicate
            ClientGraph graph2 = client2.getServerGraph(GRAPH_URI2);
            graph2.add(stmt2);
            client2.updateRepository();

            // TODO: assert something!
        } finally {
            if (client1 != null) {
                client1.close();
            }
            if (client2 != null) {
                client2.close();
            }
        }
    }
    */
    /**
     * Test adding to and replicating with multiple server graphs.
     * 
     * @throws Exception
     */
    /*  public void testAddingAndReplicatingWithManyServerGraphs() throws Exception {

        AnzoClient client = null;
        try {
            final int NUM_SERVER_GRAPHS = 20;
            final int NUM_TRANSACTIONS = 20;
            final int NUM_ADDS_PER_TRANSACTION = 10;

            client = new AnzoClient(getEmbeddedClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"));

            List<ClientGraph> graphs = new LinkedList<ClientGraph>();
            for (int i = 0; i < NUM_SERVER_GRAPHS; i++) {
                graphs.add(client.getServerGraph(Constants.valueFactory.createURI("http://graph" + i)));
            }
            client.updateRepository();
            for (Iterator<ClientGraph> iter = graphs.iterator(); iter.hasNext();) {
                ClientGraph graph1 = iter.next();
                for (int numTransactions = 0; numTransactions < NUM_TRANSACTIONS; numTransactions++) {
                    client.begin();
                    for (int i = 0; i < NUM_ADDS_PER_TRANSACTION; i++) {
                        Statement stmt = Constants.valueFactory.createStatement((createTestUri("subject" + i)), createTestUri("predicate" + i), (createTestUri("object" + 1)));
                        graph1.add(stmt);
                    }
                    client.commit();
                }
            }
            client.updateRepository();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
    */
    /**
     * Test addition of a statement containing a literal to the server graph.
     * 
     * @throws Exception
     */
    /* public void testLiteral() throws Exception {

        AnzoClient client = new AnzoClient(getEmbeddedClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"));

            ClientGraph graph = client.getServerGraph(GRAPH_URI);
            Statement stmt = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string"));
            graph.add(stmt);
            client.updateRepository();

            assertTrue(graph.size() == 1);
            assertTrue(graph.contains(stmt.getSubject(), stmt.getPredicate(), stmt.getObject()));
        } finally {
            if (client != null)
                client.close();
        }
    }
    */
    /**
     * Writes a statement to the server containing an anon node and verifies it can be read back afterward.
     * 
     * @throws Exception
     */
    /*  public void testAnon() throws Exception {

        AnzoClient client = new AnzoClient(getEmbeddedClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"));

            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);
            Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), Constants.valueFactory.createBNode());
            serverGraph.add(stmt1);
            client.updateRepository();

            assertTrue(serverGraph.size() == 1);
            assertTrue(serverGraph.contains(stmt1.getSubject(), stmt1.getPredicate(), stmt1.getObject()));
        } finally {
            if (client != null)
                client.close();
        }
    }
    */
    /**
     * Test closing server graph.
     * 
     * @throws Exception
     */
    /* public void testClose() throws Exception {

        AnzoClient client = new AnzoClient(getEmbeddedClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"));

            ClientGraph graph = client.getServerGraph(GRAPH_URI);

            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string"));
            graph.add(stmt1);
            client.updateRepository();

            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string1"));
            graph.add(stmt2);
            client.updateRepository();

            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string2"));
            graph.add(stmt3);
            client.updateRepository();

            graph.contains(stmt1);
            graph.contains(stmt2);
            graph.contains(stmt3);

            graph.close();
            assertTrue(graph.isClosed());

            boolean threwException = false;
            try {
                graph.remove(stmt1);
            } catch (Exception e) {
                threwException = true;
            }
            assertTrue(threwException);

            graph = client.getServerGraph(GRAPH_URI);
            graph.contains(stmt1);
            graph.contains(stmt2);
            graph.contains(stmt3);

            graph.close();
            assertTrue(graph.isClosed());

            threwException = false;
            try {
                graph.remove(stmt1);
            } catch (Exception e) {
                threwException = true;
            }
            assertTrue(threwException);

        } finally {
            if (client != null)
                client.close();
        }
    }
    */
    /**
     * Test ServerGraph.size()
     * 
     * @throws Exception
     */
    /*   public void testSize() throws Exception {

        AnzoClient client = null;
        try {

            client = new AnzoClient(getEmbeddedClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"));

            final ClientGraph graph = client.getServerGraph(GRAPH_URI);

            client.updateRepository();

            for (int i = 0; i < 10; i++) {
                Statement stmt = Constants.valueFactory.createStatement(createTestUri("" + Math.random()), createTestUri("predicate1"), createTestUri("" + Math.random()));
                graph.add(stmt);
            }

            assertEquals(10, graph.size());
            client.updateRepository();
            assertEquals(10, graph.size());

            graph.clear();
            assertEquals(0, graph.size());
            assertTrue(graph.size() == 0);

        } finally {
            if (client != null) {
                client.close();
            }
        }

    }
    */
    /*
    public void testBasicReplicaGraph() throws Exception {

        AnzoClient client = new AnzoClient(getEmbeddedClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"));
            ClientGraph replicaGraph = client.getReplicaGraph(GRAPH_URI);
            URI r = Constants.valueFactory.createURI("urn:test");
            replicaGraph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));
            client.updateRepository();
            assertTrue(replicaGraph.size() == 1);
            // verify that is there
            assertTrue(replicaGraph.contains(r, RDF.TYPE, RDF.ALT));
        } finally {
            if (client != null)
                client.close();
        }
    }
    */
}
