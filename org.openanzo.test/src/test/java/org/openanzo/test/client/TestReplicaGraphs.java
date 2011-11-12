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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.query.QueryEncoder;
import org.openanzo.rdf.utils.test.Condition;
import org.openanzo.rdf.utils.test.TestUtilities;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.test.AbstractTest;

/**
 * This tests replica graphs, as provided by the AnzoClient.
 * 
 * @author Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * 
 */
public class TestReplicaGraphs extends AbstractTest {

    static final URI GRAPH_URI = Constants.valueFactory.createURI("http://graph1");

    /**
     * Test that additions to the replica graph are also visible in the server graph with the same uri and on the same client.
     * 
     * @throws Exception
     */
    public void testWriteReplicaGraphReadServerGraph() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);

            final ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            final ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);

            clientGraph.add(stmt1);
            assertTrue(clientGraph.contains(stmt1));
            client.updateRepository();
            assertTrue(serverGraph.contains(stmt1));

        } finally {
            client.close();
        }
    }

    /**
     * Test that additions to the server graph are also visible to the replica graph with the same uri on the same client.
     * 
     * @throws Exception
     */
    public void testWriteServerGraphReadReplicaGraph() throws Exception {

        final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);

            serverGraph.add(stmt1);
            assertTrue(serverGraph.contains(stmt1));
            client.updateRepository();
            assertTrue(clientGraph.contains(stmt1));

        } finally {

            client.close();
        }
    }

    /**
     * Test simple addition/deletion of statements to/from the replica graph.
     * 
     * @throws Exception
     */
    public void testWriteReplicaGraphAndReplicate() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);

            ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);

            URI r = Constants.valueFactory.createURI("urn:test");
            Statement stmt = Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT);

            clientGraph.add(stmt);
            client.updateRepository();

            assertTrue(clientGraph.contains(stmt));

            clientGraph.remove(stmt);

            client.updateRepository();

            assertFalse(clientGraph.contains(stmt));
        } finally {

            client.close();
        }
    }

    /**
     * Verify that blank nodes read by a getReplicaGraph call can be removed via clear.
     * 
     * Regarding openanzo ticket #358. This test only fails if the client that creates the blank nodes is different from the client that runs clear.
     * 
     * @throws Exception
     */
    public void testClearGraphContainingBlankNodes() throws Exception {
        {
            AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            try {
                client.reset(loadStatements("initialize.trig"), null);

                ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
                client.begin();
                {
                    graph.add(TestData.stmt9);
                    graph.add(TestData.stmt10);
                }
                client.commit();
                client.updateRepository();
            } finally {

                client.close();
            }
        }

        {
            AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            try {
                ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
                graph.clear();
                client.updateRepository();
                assertEquals(0, graph.size());

            } finally {

                client.close();
            }
        }
    }

    /**
     * Test addition of a statement containing a literal to the client graph.
     * 
     * @throws Exception
     */
    public void testReplicaGraphReplicateLiteral() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
            Statement stmt = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string"), GRAPH_URI);
            graph.add(stmt);
            client.updateRepository();

            assertEquals(1, graph.size());

            Iterator<Statement> iter = graph.find(stmt.getSubject(), stmt.getPredicate(), stmt.getObject()).iterator();
            assertTrue(iter.hasNext());
            assertEquals(stmt, iter.next());
            assertFalse(iter.hasNext());
        } finally {

            client.close();
        }
    }

    /**
     * Test addition of a statement containing a literal to the replica graph.
     * 
     * @throws Exception
     */
    public void testReplicaGraphReplicateXMLlLiteral() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
            Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createLiteral("<test>test</test>", RDF.XMLLiteral), GRAPH_URI);
            graph.add(stmt1);
            client.updateRepository();

            assertEquals(1, graph.size());

            Iterator<Statement> iter = graph.find(stmt1.getSubject(), stmt1.getPredicate(), stmt1.getObject()).iterator();
            assertTrue(iter.hasNext());
            assertEquals(stmt1, iter.next());
        } finally {

            client.close();
        }
    }

    /**
     * Test adding statements to replica graph that are from the same client, then replicating and making sure that both graphs are in sync.
     * 
     * @throws Exception
     */
    public void testNonconflictingReplicaGraphWrites() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
            final Statement stmt2 = Constants.valueFactory.createStatement((createTestUri("subject2")), createTestUri("predicate2"), (createTestUri("object2")));

            final URI GRAPH_URI1 = Constants.valueFactory.createURI("http://GRAPH_URI1");
            final URI GRAPH_URI2 = Constants.valueFactory.createURI("http://GRAPH_URI2");

            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            // ------------------------------------------------------------------
            // create a local named graph, add a statement and replicate

            ClientGraph graph1 = client.getReplicaGraph(GRAPH_URI1);
            graph1.add(stmt1);
            client.updateRepository();

            // ------------------------------------------------------------------
            // create a local named graph, add a statement and replicate

            ClientGraph graph2 = client.getReplicaGraph(GRAPH_URI2);
            graph2.add(stmt2);
            client.updateRepository();

            assertEquals(1, graph1.size());
            assertEquals(1, graph2.size());
        } finally {
            client.close();
        }
    }

    /**
     * Test adding statements to replica graphs that are from different clients, then replicating and making sure that both graphs are in sync.
     * 
     * @throws Exception
     */
    public void testNonconflictingReplicaGraphWritesMultipleCients() throws Exception {

        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
            final Statement stmt2 = Constants.valueFactory.createStatement((createTestUri("subject2")), createTestUri("predicate2"), (createTestUri("object2")));

            final URI GRAPH_URI1 = Constants.valueFactory.createURI("http://GRAPH_URI1");
            final URI GRAPH_URI2 = Constants.valueFactory.createURI("http://GRAPH_URI2");

            client1 = new AnzoClient(getDefaultClientConfiguration());
            client1.connect();
            client1.reset(loadStatements("initialize.trig"), null);

            client2 = new AnzoClient(getDefaultClientConfiguration());
            client2.connect();

            // ------------------------------------------------------------------
            // create a local named graph, add a statement and replicate
            ClientGraph graph1_1 = client1.getReplicaGraph(GRAPH_URI1);
            final ClientGraph graph1_2 = client1.getReplicaGraph(GRAPH_URI2);

            graph1_1.add(stmt1);
            client1.updateRepository();

            // create a local named graph, add a statement and replicate
            ClientGraph graph2_1 = client2.getReplicaGraph(GRAPH_URI1);
            ClientGraph graph2_2 = client2.getReplicaGraph(GRAPH_URI2);
            graph2_2.add(stmt2);

            client2.updateRepository();

            assertTrue(graph1_1.contains(stmt1));

            assertTrue(graph2_1.contains(stmt1));
            assertTrue(graph2_2.contains(stmt2));

            client1.replicate(); // get client2's changes

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return graph1_2.contains(stmt2);
                }
            });

            assertTrue(graph1_2.contains(stmt2));

        } finally {
            if (client1 != null) {
                client1.close();
            }
            if (client2 != null) {
                client2.close();
            }
        }
    }

    /**
     * Test that additions to the replica graph are also visible in the server graph with the same uri and on different clients.
     * 
     * @throws Exception
     */
    public void testReplicaGraphWriteServerGraphReadMultipleClients() throws Exception {

        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {
            Statement stmt = Constants.valueFactory.createStatement((createTestUri("subject3")), createTestUri("predicate3"), (createTestUri("object3")));

            client1 = new AnzoClient(getDefaultClientConfiguration());
            client1.connect();
            client1.reset(loadStatements("initialize.trig"), null);

            client2 = new AnzoClient(getDefaultClientConfiguration());
            client2.connect();

            ClientGraph clientGraph1 = client1.getReplicaGraph(GRAPH_URI);
            client1.updateRepository();

            ClientGraph serverGraph1 = client1.getServerGraph(GRAPH_URI);
            client2.updateRepository();

            ClientGraph serverGraph2 = client2.getServerGraph(GRAPH_URI);
            clientGraph1.add(stmt);

            assertTrue(clientGraph1.contains(stmt));
            assertTrue(serverGraph1.contains(stmt)); // <-- goes through the same filter as clientGraph1
            assertFalse(serverGraph2.contains(stmt));

            client1.updateRepository();

            assertTrue(serverGraph2.contains(stmt)); // should appear now that client1 is replicated

        } finally {
            if (client1 != null) {
                client1.close();
            }
            if (client2 != null) {
                client2.close();
            }
        }
    }

    /**
     * Test close replica graph.
     * 
     * @throws Exception
     */
    public void testClose() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);

            final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string"));
            clientGraph.add(stmt1);
            client.updateRepository();

            final Statement stmt2 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string1"));
            clientGraph.add(stmt2);
            client.updateRepository();

            final Statement stmt3 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string2"));
            clientGraph.add(stmt3);
            client.updateRepository();

            clientGraph.contains(stmt1);
            clientGraph.contains(stmt2);
            clientGraph.contains(stmt3);

            clientGraph.close();
            assertTrue(clientGraph.isClosed());

            boolean threwException = false;
            try {
                clientGraph.remove(stmt1);
            } catch (Exception e) {
                threwException = true;
            }
            assertTrue(threwException);

            clientGraph = client.getReplicaGraph(GRAPH_URI);
            clientGraph.contains(stmt1);
            clientGraph.contains(stmt2);
            clientGraph.contains(stmt3);

            clientGraph.close();

            assertTrue(clientGraph.isClosed());

            threwException = false;
            try {
                clientGraph.remove(stmt1);
            } catch (Exception e) {
                threwException = true;
            }
            assertTrue(threwException);

        } finally {

            client.close();
        }
    }

    /**
     * Test size() for a replica graph.
     * 
     * @throws Exception
     */
    public void testSize() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            final ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            client.updateRepository();

            for (int i = 0; i < 10; i++) {
                Statement stmt = Constants.valueFactory.createStatement((createTestUri("" + Math.random())), createTestUri("predicate1"), (createTestUri("" + Math.random())));
                clientGraph.add(stmt);
            }

            assertEquals(10, clientGraph.size());
            client.updateRepository();
            assertEquals(10, clientGraph.size());

            clientGraph.clear();
            assertEquals(0, clientGraph.size());

        } finally {
            client.close();
        }

    }

    /**
     * Test addition of a statement containing a literal to the replica graph.
     * 
     * @throws Exception
     */
    public void testReplicaGraphFindAnonObj() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);
            client.begin();
            ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            Statement stmt = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createBNode(), GRAPH_URI);
            clientGraph.add(stmt);
            client.commit();
            client.updateRepository();
            assertEquals(1, clientGraph.size());
            Iterator<Statement> stmtIter = clientGraph.find(stmt.getSubject(), stmt.getPredicate(), stmt.getObject()).iterator();
            assertTrue(stmtIter.hasNext());
            assertEquals(stmt, stmtIter.next());
            assertFalse(stmtIter.hasNext());
        } finally {

            client.close();
        }
    }

    /**
     * Test addition of a statement containing a literal to the replica graph.
     * 
     * @throws Exception
     */
    public void testQueryAnonSubj() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);
            client.begin();
            ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            BlankNode subj = Constants.valueFactory.createBNode();
            URI pred = createTestUri("predicate1");
            BlankNode obj = Constants.valueFactory.createBNode();
            Statement stmt = Constants.valueFactory.createStatement(subj, pred, obj, GRAPH_URI);
            clientGraph.add(stmt);
            client.commit();

            client.updateRepository();

            assertEquals(1, clientGraph.size());
            Iterator<Statement> iter = clientGraph.find(null, null, null).iterator();
            assertTrue(iter.hasNext());
            Statement next2 = iter.next();

            assertEquals(stmt, next2);
            assertFalse(iter.hasNext());

            String query = "SELECT ?p ?o  WHERE { " + QueryEncoder.encodeForQuery(subj) + " ?p ?o }";
            Set<URI> defaultGraphs = new HashSet<URI>();
            defaultGraphs.add(GRAPH_URI);

            QueryResults results = client.serverQuery(defaultGraphs, null, null, query, null);
            Iterator<PatternSolution> result = results.getSelectResults().iterator();

            assertTrue(result.hasNext());
            PatternSolution next = result.next();
            assertEquals(pred, next.getBinding("p"));
            assertFalse(result.hasNext());

        } finally {

            client.close();
        }
    }
}
