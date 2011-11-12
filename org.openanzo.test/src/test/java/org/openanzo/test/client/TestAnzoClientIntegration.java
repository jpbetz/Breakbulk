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

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.jms.TextMessage;

import junit.framework.Assert;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.client.IStatementChannel;
import org.openanzo.client.IStatementChannelListener;
import org.openanzo.client.ITransactionListener;
import org.openanzo.client.cli.PlaybackHandler;
import org.openanzo.client.command.Command;
import org.openanzo.client.command.CommandManager;
import org.openanzo.client.command.ICommand;
import org.openanzo.combus.CombusProperties;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.ontologies.openanzo.DatasetListener;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.IDatasetListener;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.OPTIONS;
import org.openanzo.rdf.query.QueryEncoder;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.utils.test.AssertBlock;
import org.openanzo.rdf.utils.test.Condition;
import org.openanzo.rdf.utils.test.TestUtilities;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;
import org.openanzo.rdf.vocabulary.FOAF;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.rdf.vocabulary.XMLSchema;
import org.openanzo.services.ACLUtil;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.ITracker;
import org.openanzo.services.UpdateServerException;
import org.openanzo.services.impl.Precondition;
import org.openanzo.test.AbstractTest;

/**
 * Tests client-server operations called from the AnzoClient class.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * @author Joe Betz(<a href="mailto:jpbetz@cambridgesemantics.com">jpbetz@cambridgesemantics.com</a>)
 * 
 */
public class TestAnzoClientIntegration extends AbstractTest {

    static final URI GRAPH_URI   = Constants.valueFactory.createURI("http://graph1");

    static final URI GRAPH_URI_2 = Constants.valueFactory.createURI("http://graph2");

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Replicate two new statements up to the server and verify a find call using a server graph finds the one it was looking for.
     * 
     * @throws Exception
     */
    public void testFindStatements() throws Exception {

        Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"), GRAPH_URI);
        Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"), GRAPH_URI);
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph graph = client.getServerGraph(GRAPH_URI);

            Iterator<Statement> iter = graph.find(stmt1.getSubject(), null, null).iterator();
            assertFalse(iter.hasNext());

            client.updateRepository();
            graph.add(stmt1);
            graph.add(stmt2);
            client.updateRepository();

            iter = graph.find(stmt1.getSubject(), null, null).iterator();
            assertTrue(iter.hasNext());
            Statement t = iter.next();
            assertEquals(t, stmt1);
            assertFalse(iter.hasNext());

            assertEquals(2, graph.size());
        } finally {
            client.close();
        }
    }

    /**
     * Tests the serverFind operation in a case where it is sent with many graphs as the last argument. That reproduces the issue seen in
     * http://www.openanzo.org/projects/openanzo/ticket/842
     * 
     * @throws Exception
     */
    public void testServerFindWithManyGraphURIs() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            URL resource = getClass().getResource("./film-dataset.trig");
            Collection<Statement> statementsLoad = ReadWriteUtils.loadStatements(new InputStreamReader(resource.openStream(), Constants.byteEncoding), RDFFormat.forFileName(resource.toString()), "");
            client.importStatements(statementsLoad);
            client.updateRepository();

            // 1390 graphs mentioned
            // 1037 rdf type actors actors
            URI datasetURI = Constants.valueFactory.createURI("http://cambridgesemantics.com/datasets/C6AB60AD4F6C4CD3B22CF7985BDB93E7/dataset");
            Collection<Statement> statements = client.serverFind(datasetURI, Dataset.defaultNamedGraphProperty, null, datasetURI);
            assertEquals(1390, statements.size());
            Iterator<Statement> iterator = statements.iterator();
            URI[] graphUris = new URI[statements.size()];
            for (int i = 0; i < graphUris.length; i++) {
                graphUris[i] = (URI) iterator.next().getObject();
            }
            statements = client.serverFind(null, RDF.TYPE, Constants.valueFactory.createURI("http://cambridgesemantics.com/ontologies/MovieInfo#Actor"), graphUris);
            assertEquals(1037, statements.size());

        } finally {
            {
                client.close();
            }
        }
    }

    static final Statement stmt1 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://res1"), Constants.valueFactory.createURI("http://test.example.com/test#property"), Constants.valueFactory.createURI("http://res12"));

    static final Statement stmt2 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://res2"), Constants.valueFactory.createURI("http://test.example.com/test#property"), Constants.valueFactory.createURI("http://res22"));

    static final Statement stmt3 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://res3"), Constants.valueFactory.createURI("http://test.example.com/test#property"), Constants.valueFactory.createURI("http://res33"));

    /**
     * Calls clear and makes sure the client is empty. Add a statement, make sure it doesn't show up on the server until replication.
     * 
     * @throws Exception
     */
    public void testMultiGraphClear() throws Exception {
        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {
            client1 = new AnzoClient(getDefaultClientConfiguration());
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            //client1.reset(new ArrayList<Statement>());
            ClientGraph graph = client1.getReplicaGraph(GRAPH_URI);

            client2 = new AnzoClient(getDefaultClientConfiguration());
            client2.connect();

            graph.add(stmt1);

            client1.updateRepository();

            graph.clear();
            assertTrue(graph.size() == 0);
            client1.updateRepository();

            assertFalse(client1.getServerGraph(graph.getNamedGraphUri()).contains(stmt1.getSubject(), null, null));

            graph.add(stmt1);
            assertTrue(graph.contains(stmt1));

            // stmt1 should not exist on the server
            assertFalse(client2.getServerGraph(graph.getNamedGraphUri()).contains(stmt1.getSubject(), null, null));

            client1.updateRepository();

            // stmt1 should exist on the server
            assertTrue(client2.getServerGraph(graph.getNamedGraphUri()).contains(stmt1.getSubject(), null, null));
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
     * Tests a command that adds a statement to a replica graph.
     * 
     * @throws Exception
     */
    public void testCommand() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {

            final Statement stmt4 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://res4"), Constants.valueFactory.createURI("http://test.example.com/test#property"), Constants.valueFactory.createURI("http://res44"));

            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            final ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);

            ICommand command = new Command() {

                public Object execute() {
                    clientGraph.add(stmt4);
                    return null;
                }
            };
            CommandManager manager = new CommandManager(client);
            manager.execute(command);

            assertTrue(clientGraph.contains(stmt4));
        } finally {
            {
                client.close();
            }
        }
    }

    /**
     * Test import statements
     * 
     * @throws Exception
     */
    public void testImportStatement() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            boolean exception = false;
            try {
                URL resource = getClass().getResource("./test.n3");
                Collection<Statement> statements = ReadWriteUtils.loadStatements(new InputStreamReader(resource.openStream(), Constants.byteEncoding), RDFFormat.forFileName(resource.toString()), "");
                client.importStatements(statements);
            } catch (AnzoException ae) {
                exception = true;
            }
            assertTrue(exception);
        } finally {
            {
                client.close();
            }
        }
    }

    /**
     * Executes an implicit and explicit transaction and verifies they both, once committed, are isolated to the client until they are replicated.
     * 
     * @throws Exception
     */
    public void testTransactions() throws Exception {

        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {

            client1 = new AnzoClient(getDefaultClientConfiguration());
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            client2 = new AnzoClient(getDefaultClientConfiguration());
            client2.connect();

            ClientGraph clientGraph = client1.getReplicaGraph(GRAPH_URI);
            ClientGraph serverGraph = client2.getServerGraph(GRAPH_URI);

            // TRANSACTION 1 - changes to graphs not surrounded with begin/commit are
            // treated as individual transactions
            clientGraph.add(stmt1);

            assertTrue(clientGraph.contains(stmt1));
            assertFalse(serverGraph.contains(stmt1));

            // TRANSACTION 2 - all changes inside the begin/commit are executed as a single
            // transaction
            client1.begin();
            try {
                clientGraph.add(stmt2);
                clientGraph.add(stmt3);
                client1.commit();
            } catch (Exception e) {
                client1.abort();
                throw e;
            }

            assertTrue(clientGraph.contains(stmt1));
            assertTrue(clientGraph.contains(stmt2));
            assertTrue(clientGraph.contains(stmt3));

            assertFalse(serverGraph.contains(stmt2));
            assertFalse(serverGraph.contains(stmt3));

            client1.updateRepository();

            assertTrue(serverGraph.contains(stmt1));
            assertTrue(serverGraph.contains(stmt2));
            assertTrue(serverGraph.contains(stmt3));
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
     * Tests sizes and transaction queue sharing among the various graphs on a single client.
     * 
     * @throws Exception
     */
    public void testMultiGraphSize() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            final ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            final ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);

            for (int i = 0; i < 10; i++) {
                Statement stmt = Constants.valueFactory.createStatement((createTestUri("" + Math.random())), createTestUri("predicate1"), (createTestUri("" + Math.random())));
                clientGraph.add(stmt);
            }

            assertEquals(10, clientGraph.size());
            assertEquals(10, serverGraph.size());

            client.updateRepository();

            assertEquals(10, clientGraph.size());
            assertEquals(10, serverGraph.size());

            // we purposefully do not do a begin/commit because we want
            // to have many seperate transactions for the test.
            for (int i = 0; i < 10; i++) {
                Statement stmt = Constants.valueFactory.createStatement((createTestUri("" + Math.random())), createTestUri("predicate1"), (createTestUri("" + Math.random())));
                serverGraph.add(stmt);
            }
            assertEquals(20, clientGraph.size());
            assertEquals(20, serverGraph.size());

            client.updateRepository();

            TestUtilities.waitFor(10000, new AssertBlock() {
                @Override
                public void test() {
                    assertEquals(20, clientGraph.size());
                    assertEquals(20, serverGraph.size());
                }
            });

            assertEquals(20, clientGraph.size());
            assertEquals(20, serverGraph.size());
        } finally {
            {
                client.close();
            }
        }
    }

    /**
     * Tests AnzoClient.getNamedGraphRevision
     * 
     * @throws Exception
     */
    public void testGetNamedGraphRevision() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        client.reset(new ArrayList<Statement>(), null);
        try {
            ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string"));
            clientGraph.add(stmt1);
            client.updateRepository();
            Statement stmt2 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string1"));
            clientGraph.add(stmt2);
            client.updateRepository();
            Statement stmt3 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string2"));
            clientGraph.add(stmt3);
            client.updateRepository();
            assertEquals(3, clientGraph.size());
            Iterator<Statement> stmts = clientGraph.getMetadataGraph().find(clientGraph.getNamedGraphUri(), NamedGraph.revisionProperty, null).iterator();
            Value revision = null;
            long rev = -1;
            if (stmts != null && stmts.hasNext()) {
                revision = stmts.next().getObject();
            }
            if (revision != null) {
                Object obj = StatementUtils.getNativeValue((Literal) revision);
                if (obj instanceof Long) {
                    rev = ((Long) obj).longValue();
                } else {
                    try {
                        rev = Long.parseLong(((Literal) revision).getLabel());
                    } catch (Exception e) {

                    }
                }
            }
            assertEquals(3, rev);
            INamedGraph rev1 = client.getNamedGraphRevision(GRAPH_URI, 0);
            assertEquals(0, rev1.size());
            INamedGraph rev2 = client.getNamedGraphRevision(GRAPH_URI, 1);
            assertEquals(1, rev2.size());
            INamedGraph rev3 = client.getNamedGraphRevision(GRAPH_URI, 2);
            assertEquals(2, rev3.size());
            INamedGraph rev4 = client.getNamedGraphRevision(GRAPH_URI, 3);
            assertEquals(3, rev4.size());
        } finally {
            client.close();
        }
    }

    /**
     * Test that a created graph exists via call to {@link AnzoClient#namedGraphExists(URI)}
     * 
     * @throws Exception
     */
    public void testNamedGraphExists() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());

        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            assertFalse(client.namedGraphExists(TestData.graph1));
            client.getReplicaGraph(TestData.graph1);
            client.updateRepository();
            assertTrue(client.namedGraphExists(TestData.graph1));
        } finally {
            client.close();
        }
    }

    /**
     * Test calling reset with no statements, this will cause the server to use the default init data
     * 
     * @throws Exception
     */
    public void testEmptyReset() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(Collections.<Statement> emptySet(), null);
            client.reset(Collections.<Statement> emptySet(), null);
        } finally {

            client.close();
        }
    }

    /**
     * Test creating an empty graph and verifying it is created on server
     * 
     * @throws Exception
     */
    public void testEmptyGraph() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);
            client.updateRepository();
            assertTrue(replicaGraph.getMetadataGraph().contains(new Statement(replicaGraph.getNamedGraphUri(), RDF.TYPE, NamedGraph.TYPE)));
            assertTrue(replicaGraph.getMetadataGraph().contains(new Statement(replicaGraph.getNamedGraphUri(), NamedGraph.canBeReadByProperty, null)));
            assertTrue(replicaGraph.getMetadataGraph().contains(new Statement(replicaGraph.getNamedGraphUri(), NamedGraph.persistedProperty, MemTypedLiteral.TRUE)));
        } finally {

            client.close();
        }
    }

    /**
     * Test getting a list of named graphs after they are created
     * 
     * @throws Exception
     */
    public void testGetNamedGraphs() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            // a default named graph exists by default in the configuration
            client.getReplicaGraph(TestData.graph1);
            client.getReplicaGraph(TestData.graph2);
            client.getReplicaGraph(TestData.graph3);
            client.updateRepository();
            Set<URI> graphs = client.getNamedGraphs();
            assertTrue(graphs.contains(TestData.graph1));
            assertTrue(graphs.contains(TestData.graph2));
            assertTrue(graphs.contains(TestData.graph3));
        } finally {

            client.close();
        }
    }

    private void addTestQueryData(AnzoClient client) throws Exception {
        URI graph1 = createTestUri("namedGraph1");
        ClientGraph serverGraph = client.getServerGraph(graph1);
        ClientGraph serverGraph2 = client.getServerGraph(createTestUri("namedGraph4"));
        Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
        Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object2"));
        Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
        Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate3"), createTestUri("object3"));
        Statement stmt5 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate3"), Constants.valueFactory.createBNode());

        client.begin();
        serverGraph.add(stmt1);
        serverGraph.add(stmt2);
        serverGraph.add(stmt5);
        serverGraph.add(Constants.valueFactory.createStatement(serverGraph.getNamedGraphUri(), Constants.valueFactory.createURI("http://testtext"), Constants.valueFactory.createLiteral("É yo yo yo")));
        serverGraph.add(Constants.valueFactory.createStatement(serverGraph.getNamedGraphUri(), Constants.valueFactory.createURI("http://testtext"), Constants.valueFactory.createLiteral("another test string")));
        serverGraph2.add(stmt3);
        serverGraph2.add(stmt4);
        client.commit();
        client.updateRepository();
    }

    private void addTestQueryData2(AnzoClient client) throws Exception {
        URI graph1 = createTestUri("namedGraph1");
        ClientGraph serverGraph = client.getServerGraph(graph1);
        Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object10"));
        Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object12"));

        client.begin();
        serverGraph.add(stmt1);
        serverGraph.add(stmt2);
        client.commit();
        client.updateRepository();
    }

    /**
     * Test a simple query against server
     * 
     * @throws Throwable
     */
    public void testQuery() throws Throwable {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            addTestQueryData(client);

            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
            Set<URI> defaultGraphs = new HashSet<URI>();
            defaultGraphs.add(createTestUri("namedGraph1"));
            QueryResults results = client.serverQuery(defaultGraphs, null, null, query, null);
            int i = 0;
            assertTrue(results.isSelectResult());
            Iterator<PatternSolution> result = results.getSelectResults().iterator();

            while (result.hasNext()) {
                result.next();
                i++;
            }
            assertEquals(5, i);
        } finally {

            client.close();
        }
    }

    /**
     * Test simple construct query
     * 
     * @throws Exception
     */
    public void testQueryConstructGraph() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            addTestQueryData(client);

            String query = "CONSTRUCT {?s ?p ?o} WHERE { GRAPH ?g { ?s ?p ?o }}";
            QueryResults results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isConstructResult());
            Collection<Statement> stmtIter = results.getConstructResults();
            int i = 0;
            for (Statement statement : stmtIter) {
                assertNotNull(statement);
                i++;
            }
            assertEquals(8, i);

        } finally {

            client.close();
        }

    }

    /**
     * Test simple construct query
     * 
     * @throws Exception
     *             public void testQueryConstructQuadGraph() throws Exception {
     * 
     *             AnzoClient client = new AnzoClient(getDefaultClientConfiguration()); try { client.connect(); client.reset(new ArrayList<Statement>(), null);
     *             addTestQueryData(client);
     * 
     *             String query = "CONSTRUCT {GRAPH ?g{?s ?p ?o}} WHERE { GRAPH ?g { ?s ?p ?o }}"; QueryResults results = client.serverQuery(null,
     *             Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null); assertTrue(results.isConstructResult()); Collection<Statement> stmtIter =
     *             results.getConstructResults(); int i = 0; for (Statement statement : stmtIter) { assertNotNull(statement); i++; } assertEquals(7, i);
     * 
     *             } finally {
     * 
     *             client.close(); }
     * 
     *             }
     */
    /**
     * Test simple construct query
     * 
     * @throws Exception
     */
    public void testNegatedIsQuery() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            addTestQueryData(client);

            String query = "SELECT ?s ?o WHERE { GRAPH ?g { ?s ?p ?o . FILTER(isLiteral(?o))}}";
            QueryResults results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(2, results.getSelectResults().size());

            query = "SELECT ?s ?o WHERE { GRAPH ?g { ?s ?p ?o . FILTER(isIRI(?o))}}";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(5, results.getSelectResults().size());

            query = "SELECT ?s ?o WHERE { GRAPH ?g { ?s ?p ?o . FILTER(!isIRI(?o))}}";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(3, results.getSelectResults().size());

            query = "SELECT ?s ?o WHERE { GRAPH ?g { ?s ?p ?o . FILTER(!isLiteral(?o))}}";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(6, results.getSelectResults().size());

            query = "SELECT ?s ?o WHERE { GRAPH ?g { ?s ?p ?o . FILTER(isBlank(?o))}}";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(1, results.getSelectResults().size());

            query = "SELECT ?s ?o WHERE { GRAPH ?g { ?s ?p ?o . FILTER(!isBlank(?o))}}";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(7, results.getSelectResults().size());

        } finally {

            client.close();
        }

    }

    /**
     * Test simple construct query
     * 
     * @throws Exception
     */
    public void testLimitZero() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            addTestQueryData(client);

            String query = "SELECT ?s ?o WHERE { GRAPH ?g { ?s ?p ?o }} LIMIT 0";
            QueryResults results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(0, results.getSelectResults().size());

            query = "SELECT ?s ?o WHERE { GRAPH ?g { ?s ?p ?o }} LIMIT 1";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(1, results.getSelectResults().size());
            assertTrue(results.getTotalSolutions() > 1);
        } finally {

            client.close();
        }

    }

    /**
     * Test simple named graph query
     * 
     * @throws Throwable
     */
    public void testQueryGraph() throws Throwable {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());

        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            addTestQueryData(client);
            String query = "SELECT ?s ?p ?o ?g WHERE { GRAPH ?g { ?s ?p ?o }}";
            QueryResults results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(8, results.getSelectResults().size());
        } finally {

            client.close();
        }
    }

    /**
     * Test running query multiple times, and getting right results
     * 
     * @throws Throwable
     */
    public void testCachableQueryGraph() throws Throwable {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());

        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            addTestQueryData(client);
            String query = "SELECT ?s ?p ?o ?g WHERE { GRAPH ?g { ?s ?p ?o }}";
            URI graphUri = Constants.valueFactory.createURI("http://test.example.com/test#namedGraph1");
            QueryResults results = client.serverQuery(null, Collections.singleton(graphUri), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(5, results.getSelectResults().size());
            results = client.serverQuery(null, Collections.singleton(graphUri), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(5, results.getSelectResults().size());
            addTestQueryData2(client);
            results = client.serverQuery(null, Collections.singleton(graphUri), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(7, results.getSelectResults().size());
            results = client.serverQuery(null, Collections.singleton(graphUri), null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(7, results.getSelectResults().size());
        } finally {

            client.close();
        }
    }

    /**
     * Test running ask query
     * 
     * @throws Throwable
     */
    public void testAskQuery() throws Throwable {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        URI graphUri1 = createTestUri("namedGraph1");
        URI graphUri4 = createTestUri("namedGraph4");
        ClientGraph graph = null;
        ClientGraph serverGraph4 = null;
        ClientGraph serverGraph1 = null;
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            graph = client.getServerGraph(graphUri1);
            client.commit();
            client.updateRepository();
            URI pred = createTestUri("predicate1");
            String query = "ASK WHERE { ?s <" + pred + ">  ?o }";
            QueryResults results = client.serverQuery(Collections.singleton(graphUri1), Collections.<URI> emptySet(), null, query, null);
            assertTrue(results.isAskResult());
            assertFalse(results.getAskResults());
            serverGraph1 = client.getServerGraph(graphUri1);
            serverGraph4 = client.getServerGraph(graphUri4);
            Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), pred, createTestUri("object1"));
            client.begin();
            serverGraph1.add(stmt1);
            client.commit();
            client.updateRepository();

            results = client.serverQuery(Collections.singleton(graphUri1), Collections.<URI> emptySet(), null, query, null);
            assertTrue(results.isAskResult());
            assertTrue(results.getAskResults());
        } finally {
            try {
                if (graph != null) {
                    graph.close();
                }
                if (serverGraph4 != null) {
                    serverGraph4.close();
                }
                if (serverGraph1 != null) {
                    serverGraph1.close();
                }
            } finally {

                client.close();
            }
        }
    }

    /**
     * Test invalid query
     * 
     * @throws Exception
     */
    public void testInvalidQuery() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            client.getServerGraph(GRAPH_URI);
            String query = "JunkJunk";
            try {
                client.serverQuery(null, null, null, query, null);
            } catch (AnzoException be) {
                return;
            }
        } finally {

            client.close();
        }
        fail("executeQuery() needed to throw an exception.");
    }

    /**
     * Test system graph query
     * 
     * @throws Throwable
     */
    public void testSystemQuery() throws Throwable {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            assertNotNull(client);
            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
            QueryResults results = client.serverQuery(Collections.singleton(GRAPHS.DEFAULT_SYSTEMGRAPH), Collections.<URI> emptySet(), null, query, null);
            assertTrue(results.isSelectResult());
            int i = 0;

            Iterator<PatternSolution> iter = results.getSelectResults().iterator();
            while (iter.hasNext()) {
                PatternSolution qs = iter.next();
                i++;
                qs.getBinding("s");
                qs.getBinding("p");
                qs.getBinding("o");

            }
            assertEquals(1, i);
            query = "CONSTRUCT {?s ?p ?o} WHERE { GRAPH ?g { ?s ?p ?o }}";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.DEFAULT_SYSTEMGRAPH), null, query, null);
            assertTrue(results.isConstructResult());
            Iterator<Statement> stmtIter = results.getConstructResults().iterator();
            i = 0;
            while (stmtIter.hasNext()) {
                stmtIter.next();
                i++;
            }
            assertEquals(1, i);
            query = "SELECT ?s ?p ?o ?g WHERE { GRAPH ?g { ?s ?p ?o }}";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.DEFAULT_SYSTEMGRAPH), null, query, null);
            assertTrue(results.isSelectResult());
            i = 0;
            Iterator<PatternSolution> iterator = results.getSelectResults().iterator();
            while (iterator.hasNext()) {
                PatternSolution qs = iterator.next();
                i++;
                qs.getBinding("s");
                qs.getBinding("p");
                qs.getBinding("o");
                qs.getBinding("g");
            }
            assertEquals(1, i);
        } finally {

            client.close();
        }
    }

    /**
     * Test system metadata query
     * 
     * @throws Throwable
     */
    public void testSystemMetaQuery() throws Throwable {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
            QueryResults results = client.serverQuery(Collections.singleton(GRAPHS.DEFAULT_SYSTEM_METAGRAPH), Collections.<URI> emptySet(), null, query, null);
            assertTrue(results.isSelectResult());
            int i = 0;
            {
                Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                while (iter.hasNext()) {
                    PatternSolution qs = iter.next();
                    i++;
                    qs.getBinding("s");
                    qs.getBinding("p");
                    qs.getBinding("o");
                }
            }
            query = "CONSTRUCT {?s ?p ?o} WHERE { GRAPH ?g { ?s ?p ?o }}";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.DEFAULT_SYSTEM_METAGRAPH), null, query, null);
            assertTrue(results.isConstructResult());
            Iterator<Statement> stmtIter = results.getConstructResults().iterator();
            while (stmtIter.hasNext()) {
                stmtIter.next();
            }
            query = "SELECT ?s ?p ?o ?g WHERE { GRAPH ?g { ?s ?p ?o }}";
            results = client.serverQuery(null, Collections.singleton(GRAPHS.DEFAULT_SYSTEM_METAGRAPH), null, query, null);
            assertTrue(results.isSelectResult());
            i = 0;
            {
                Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                while (iter.hasNext()) {
                    i++;
                    PatternSolution qs = iter.next();
                    qs.getBinding("s");
                    qs.getBinding("p");
                    qs.getBinding("o");
                    qs.getBinding("g");
                }
            }
        } finally {

            client.close();
        }
    }

    /**
     * Test metadata query
     * 
     * @throws Throwable
     */
    public void testMetaQuery() throws Throwable {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        client.reset(new ArrayList<Statement>(), null);
        client.getServerGraph(createTestUri("namedGraph1"));
        client.updateRepository();
        try {
            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";

            Set<URI> defaultGraphs = Collections.singleton(client.getServerGraph(createTestUri("namedGraph1")).getMetadataGraph().getNamedGraphUri());
            QueryResults results = client.serverQuery(defaultGraphs, Collections.<URI> emptySet(), null, query, null);
            assertTrue(results.isSelectResult());
            int i = 0;
            {
                Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                while (iter.hasNext()) {
                    i++;
                    PatternSolution qs = iter.next();
                    qs.getBinding("s");
                    qs.getBinding("p");
                    qs.getBinding("o");
                }
            }
            query = "CONSTRUCT {?s ?p ?o} WHERE { GRAPH ?g { ?s ?p ?o }}";
            results = client.serverQuery(null, defaultGraphs, null, query, null);
            assertTrue(results.isConstructResult());
            Iterator<Statement> stmtIter = results.getConstructResults().iterator();
            while (stmtIter.hasNext()) {
                stmtIter.next();
            }
            query = "SELECT ?s ?p ?o ?g WHERE { GRAPH ?g { ?s ?p ?o }}";
            results = client.serverQuery(null, defaultGraphs, null, query, null);
            assertTrue(results.isSelectResult());
            i = 0;
            {
                Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                while (iter.hasNext()) {
                    i++;
                    PatternSolution qs = iter.next();
                    qs.getBinding("s");
                    qs.getBinding("p");
                    qs.getBinding("o");
                    qs.getBinding("g");

                }
            }
        } finally {

            client.close();
        }
    }

    /**
     * Test mixed data and metadata query
     * 
     * @throws Throwable
     */
    public void testDataAndMetaQuery() throws Throwable {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        client.reset(new ArrayList<Statement>(), null);
        client.getServerGraph(createTestUri("namedGraph1"));
        client.updateRepository();
        try {
            URI graph1 = createTestUri("namedGraph1");
            ClientGraph serverGraph = client.getServerGraph(graph1);
            Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object2"));
            Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate3"), createTestUri("object3"));
            client.begin();
            serverGraph.add(stmt1);
            serverGraph.add(stmt2);
            serverGraph.add(Constants.valueFactory.createStatement(serverGraph.getNamedGraphUri(), Constants.valueFactory.createURI("http://testtext"), Constants.valueFactory.createLiteral(" yo yo yo")));
            serverGraph.add(Constants.valueFactory.createStatement(serverGraph.getNamedGraphUri(), Constants.valueFactory.createURI("http://testtext"), Constants.valueFactory.createLiteral("another test string")));
            serverGraph.add(stmt3);
            serverGraph.add(stmt4);
            client.commit();
            String query = "SELECT ?g ?r ?s ?p ?o  WHERE {GRAPH ?g{ ?s ?p ?o } . GRAPH ?mg{?g " + QueryEncoder.encodeForQuery(NamedGraph.hasMetadataGraphProperty) + " ?mg . ?g " + QueryEncoder.encodeForQuery(NamedGraph.revisionProperty) + " ?r}}";
            Set<URI> defaultGraphs = new HashSet<URI>();
            defaultGraphs.add(graph1);
            defaultGraphs.add(GRAPHS.ALL_METADATAGRAPHS);
            QueryResults results = client.serverQuery(Collections.<URI> emptySet(), defaultGraphs, null, query, null);
            assertTrue(results.isSelectResult());
            int i = 0;
            {
                Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                while (iter.hasNext()) {
                    i++;
                    PatternSolution qs = iter.next();
                    qs.getBinding("g");
                    qs.getBinding("r");
                    qs.getBinding("s");
                    qs.getBinding("p");
                    qs.getBinding("o");
                }
            }
        } finally {

            client.close();
        }
    }

    /**
     * Test mixed data and metadata query over default graph
     * 
     * @throws Throwable
     */
    public void testDataAndMetaQueryInDefault() throws Throwable {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            URI graph1 = createTestUri("namedGraph1");
            ClientGraph serverGraph = client.getServerGraph(graph1);
            Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object2"));
            Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate3"), createTestUri("object3"));
            client.begin();
            serverGraph.add(stmt1);
            serverGraph.add(stmt2);
            serverGraph.add(Constants.valueFactory.createStatement(serverGraph.getNamedGraphUri(), Constants.valueFactory.createURI("http://testtext"), Constants.valueFactory.createLiteral(" yo yo yo")));
            serverGraph.add(Constants.valueFactory.createStatement(serverGraph.getNamedGraphUri(), Constants.valueFactory.createURI("http://testtext"), Constants.valueFactory.createLiteral("another test string")));
            serverGraph.add(stmt3);
            serverGraph.add(stmt4);
            client.commit();
            String query = "SELECT ?g ?r ?s ?p ?o  WHERE { ?s ?p ?o  . ?g " + QueryEncoder.encodeForQuery(NamedGraph.hasMetadataGraphProperty) + " ?mg . ?g " + QueryEncoder.encodeForQuery(NamedGraph.revisionProperty) + " ?r}";
            Set<URI> defaultGraphs = new HashSet<URI>();
            defaultGraphs.add(GRAPHS.ALL_NAMEDGRAPHS);
            defaultGraphs.add(GRAPHS.DEFAULT_SYSTEM_METAGRAPH);
            QueryResults results = client.serverQuery(defaultGraphs, Collections.<URI> emptySet(), null, query, null);
            assertTrue(results.isSelectResult());
            int i = 0;
            {
                Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                while (iter.hasNext()) {
                    i++;
                    PatternSolution qs = iter.next();
                    qs.getBinding("g");
                    qs.getBinding("r");
                    qs.getBinding("s");
                    qs.getBinding("p");
                    qs.getBinding("o");

                }
            }
        } finally {

            client.close();
        }
    }

    /**
     * Test basic runas user test
     * 
     * @throws Exception
     */
    public void testBasicRunAs() throws Exception {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            URI namedGraphUri = createTestUri("namedGraph2");
            ClientGraph serverGraph = client.getServerGraph(namedGraphUri);
            URI r = Constants.valueFactory.createURI("urn:test");
            serverGraph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));
            client.updateRepository();

            assertTrue(serverGraph.size() == 1);

            client.setServiceUser("default");
            assertEquals(0, serverGraph.size());
            client.setServiceUser("sysadmin");
            assertEquals(1, serverGraph.size());
        } finally {

            client.close();
        }
    }

    /**
     * Test basic runas user test
     * 
     * @throws Exception
     */
    public void testWriteRunAs() throws Exception {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            client.setServiceUser("default");
            client.begin();
            ClientGraph serverGraph = client.getReplicaGraph(TestData.graph1);
            serverGraph.add(TestData.stmt1);
            client.commit();

            client.updateRepository();

            NamedGraph ng = AnzoFactory.getNamedGraph(TestData.graph1, serverGraph.getMetadataGraph());
            assertEquals("ldap://uid=default,ou=users,dc=openanzo,dc=org", ng.getCanBeReadBy().iterator().next().resource().toString());

        } finally {

            client.close();
        }
    }

    /**
     * Test basic runas user test
     * 
     * @throws Exception
     */
    public void testContainsGraphRunAs() throws Exception {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);

            client.begin();
            ClientGraph serverGraph = client.getReplicaGraph(TestData.graph1);
            serverGraph.add(TestData.stmt1);
            client.commit();
            client.updateRepository();

            client.setServiceUser("default");
            assertFalse(client.namedGraphExists(TestData.graph1));
            client.setServiceUser(null);
            assertTrue(client.namedGraphExists(TestData.graph1));
            client.setServiceUser("default");
            assertFalse(client.namedGraphExists(TestData.graph1));
            client.setServiceUser(null);
            assertTrue(client.namedGraphExists(TestData.graph1));

        } finally {

            client.close();
        }
    }

    /**
     * Test basic runas user test
     * 
     * @throws Exception
     */
    public void testRunAsReplicaSecurity() throws Exception {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);

            client.begin();
            ClientGraph graph1 = client.getReplicaGraph(TestData.graph1);
            graph1.add(TestData.stmt1);
            client.commit();
            client.updateRepository();

            client.setServiceUser("default");
            assertNull(client.getReplicaGraph(TestData.graph1));

            client.setServiceUser(null);
            assertNotNull(client.getReplicaGraph(TestData.graph1));

            client.setServiceUser("default");
            client.begin();
            ClientGraph graph2 = client.getReplicaGraph(TestData.graph2);
            graph2.add(TestData.stmt2);
            graph2.add(TestData.stmt3);
            client.commit();
            client.updateRepository();

            assertEquals(19, client.replicaFind(null, null, null).size());
            client.setServiceUser(null);
            assertEquals(31, client.replicaFind(null, null, null).size());
            client.setServiceUser("default");
            assertEquals(2, client.replicaFind(null, null, null, new URI[] { TestData.graph1, TestData.graph2 }).size());

            String query = "select * WHERE {?s ?p ?o}";
            Set<URI> ngs = new HashSet<URI>();
            ngs.add(GRAPHS.ALL_NAMEDGRAPHS);
            QueryResults results = client.replicaQuery(ngs, null, null, query, null);
            SolutionSet sols = results.getSelectResults();
            assertEquals(2, sols.size());

            client.setServiceUser(null);
            results = client.replicaQuery(ngs, null, null, query, null);
            sols = results.getSelectResults();
            assertEquals(3, sols.size());

        } finally {
            client.close();
        }

    }

    /**
     * Test basic runas user test
     * 
     * @throws Exception
     */
    public void testRunAsSecurity() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            assertFalse(client.getServicePrincipal().isSysadmin());
            boolean caught = false;
            try {
                client.setServiceUser("default2");
            } catch (AnzoException e) {
                assertEquals(ExceptionConstants.COMBUS.RUNAS_NOT_AUTHORIZED, e.getErrorCode());
                caught = true;
            }
            assertTrue(caught);

        } finally {
            client.close();
        }

    }

    /**
     * Test basic server graph
     * 
     * @throws Exception
     */
    public void testBasicServerGraph() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);
            client.begin();
            client.commit();
            URI r = Constants.valueFactory.createURI("urn:test");
            serverGraph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));
            client.updateRepository();
            assertTrue(serverGraph.size() == 1);
            // verify that is there
            assertTrue(serverGraph.contains(r, RDF.TYPE, RDF.ALT));
        } finally {

            client.close();
        }
    }

    /**
     * Test basic replica graph
     * 
     * @throws Exception
     */
    public void testBasicReplicaGraph() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client.getReplicaGraph(GRAPH_URI);
            URI r = Constants.valueFactory.createURI("urn:test");
            replicaGraph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));
            client.updateRepository();
            assertTrue(replicaGraph.size() == 1);
            // verify that is there
            assertTrue(replicaGraph.contains(r, RDF.TYPE, RDF.ALT));

            assertTrue(replicaGraph.getMetadataGraph().contains(new Statement(replicaGraph.getNamedGraphUri(), RDF.TYPE, NamedGraph.TYPE)));
            assertTrue(replicaGraph.getMetadataGraph().contains(new Statement(replicaGraph.getNamedGraphUri(), NamedGraph.canBeReadByProperty, null)));
            //assertTrue(replicaGraph.getMetadataGraph().contains(new Statement(replicaGraph.getNamedGraphUri(), NamedGraph.revisionedProperty, MemTypedLiteral.FALSE)));
            assertTrue(replicaGraph.getMetadataGraph().contains(new Statement(replicaGraph.getNamedGraphUri(), NamedGraph.persistedProperty, MemTypedLiteral.TRUE)));
        } finally {

            client.close();
        }
    }

    /**
     * Test replica graph literal
     * 
     * @throws Exception
     */
    public void testReplicaGraphLiteral() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            URI r = Constants.valueFactory.createURI("urn:test");
            Statement newStmt = Constants.valueFactory.createStatement(r, Constants.valueFactory.createURI("http://testpred"), Constants.valueFactory.createLiteral("test literal"));
            clientGraph.add(newStmt);
            client.updateRepository();

            Iterator<Statement> iter = clientGraph.getStatements().iterator();
            while (iter.hasNext()) {
                iter.next();
            }

            assertTrue(clientGraph.size() == 1);
        } finally {

            client.close();
        }
    }

    /**
     * Test replica graph find for literal
     * 
     * @throws Exception
     */
    public void testReplicaLiteral() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
            Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), Constants.valueFactory.createLiteral("some string"));
            graph.add(stmt1);
            client.updateRepository();

            assertEquals(1, graph.size()); // used to be 1.. but now there are the metadata
            Iterator<Statement> statements = graph.find(stmt1.getSubject(), stmt1.getPredicate(), stmt1.getObject()).iterator();
            int i = 0;
            while (statements.hasNext()) {
                statements.next();
                i++;
            }
            assertEquals(1, i);
        } finally {

            client.close();
        }
    }

    /**
     * Test updating metadata graph
     * 
     * @throws Exception
     */
    public void testUpdateMetadataGraph() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph graph = client.getReplicaGraph(TestData.graph2);
            graph.add(TestData.stmt2);
            client.updateRepository();

            assertEquals(1, graph.size()); // used to be 1.. but now there are the metadata
            Iterator<Statement> statements = graph.find(TestData.stmt2.getSubject(), TestData.stmt2.getPredicate(), TestData.stmt2.getObject()).iterator();
            int i = 0;
            while (statements.hasNext()) {
                statements.next();
                i++;
            }
            assertEquals(1, i);

            client.begin();
            graph.getMetadataGraph().add(TestData.graph2, TestData.stmt2.getPredicate(), TestData.stmt2.getObject());
            client.commit();
            client.updateRepository();
            assertTrue(graph.getMetadataGraph().contains(TestData.graph2, TestData.stmt2.getPredicate(), TestData.stmt2.getObject()));

        } finally {

            client.close();
        }
    }

    /**
     * Not sure if this is the correct way to add stuff to a graph, but somehow all of the statements don't make it in all of the time.
     * 
     * @throws Exception
     */
    public void testInsertStatementsThreaded() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph serverGraph = client.getServerGraph(createTestUri("namedGraph1"));

            int numThreads = 2;
            int numTransactions = 10;
            int numStatements = 5;
            List<Thread> threads = new ArrayList<Thread>();
            for (int i = 0; i < numThreads; i++) {
                Thread t = new Thread(new StatementAdder(client, serverGraph, numTransactions, numStatements, 0, "adder" + i));
                threads.add(t);
            }
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            //client.replicate();
            Set<URI> defaultGraphs = new HashSet<URI>();
            defaultGraphs.add(createTestUri("namedGraph1"));
            QueryResults results = client.serverQuery(defaultGraphs, Collections.<URI> emptySet(), null, "construct { ?s ?p ?o } WHERE { ?s ?p ?o }", null);
            assertTrue(results.isConstructResult());
            int i = results.getConstructResults().size();
            assertEquals(numThreads * numTransactions * numStatements, i);
        } finally {

            client.close();
        }
    }

    /**
     * Not sure if this is the correct way to add stuff to a graph, but somehow all of the statements don't make it in all of the time.
     * 
     * @throws Exception
     */
    public void testInsertStatementsMultiClientThreaded() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);

            int numThreads = 3;
            int numTransactions = 5;
            int numStatements = 5;
            List<Thread> threads = new ArrayList<Thread>();
            /* client.begin();
             for(int i=0;i<numThreads;i++) {
                 ClientGraph serverGraph = client.getServerGraph(createTestUri("namedGraph"+i));
                 serverGraph.close();
             }
             client.commit();
             client.updateRepository();
             */
            for (int i = 0; i < numThreads; i++) {
                Thread t = new Thread(new StatementClientAdder(i, numTransactions, numStatements, 0, "adder" + i));
                threads.add(t);
            }
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            //client.replicate();

            QueryResults results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), Collections.<URI> emptySet(), null, "construct { ?s ?p ?o } WHERE { ?s ?p ?o }", null);
            assertTrue(results.isConstructResult());
            /*int i = */results.getConstructResults().size();
            //   assertEquals(numThreads * numTransactions * numStatements, i);
        } finally {

            client.close();
        }
    }

    private long getNamedGraphRevision(IAnzoGraph graph) {
        long revision = -1;
        if (graph.getMetadataGraph().contains(graph.getNamedGraphUri(), NamedGraph.revisionProperty, null)) {
            Iterator<Statement> ei = graph.getMetadataGraph().find(graph.getNamedGraphUri(), NamedGraph.revisionProperty, null).iterator();
            if (ei.hasNext()) {
                Value rev = ei.next().getObject();
                if (rev instanceof Literal) {
                    Object obj = StatementUtils.getNativeValue((Literal) rev);
                    if (obj instanceof Number) {
                        revision = ((Number) obj).longValue();
                    }
                }
            }
        }
        return revision;
    }

    /**
     * Test named graph revision
     * 
     * @throws Throwable
     */
    public void testNGRevision() throws Throwable {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            URI uri = createTestUri("namedGraph1");
            ClientGraph serverGraph = client.getServerGraph(uri);
            assertNotNull(serverGraph);
            serverGraph.add(Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://testpred"), Constants.valueFactory.createLiteral("foo")));
            client.updateRepository();

            assertEquals(17, serverGraph.getMetadataGraph().size());

            Long oldRevision = getNamedGraphRevision(serverGraph);

            serverGraph.add(Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://test"), Constants.valueFactory.createURI("http://testpred"), Constants.valueFactory.createLiteral("blah")));
            client.updateRepository();

            Long revision = getNamedGraphRevision(serverGraph);
            assertEquals(oldRevision + 1, (long) revision);

            IAnzoGraph graph = client.getNamedGraphRevision(uri, revision);
            Long testRevision = getNamedGraphRevision(graph);
            assertEquals(oldRevision + 1, (long) testRevision);

            graph = client.getNamedGraphRevision(uri, oldRevision);
            testRevision = getNamedGraphRevision(graph);
            assertEquals((long) oldRevision, (long) testRevision);
        } finally {
            client.close();
        }
    }

    List<AnzoException> errorResults   = null;

    Long                commandIdError = null;

    class StatementAdder implements Runnable {

        String      baseStr = null;

        int         numTransactions;

        int         numStatements;

        long        sleepTime;

        AnzoClient  client;

        ClientGraph m;

        public StatementAdder(AnzoClient client, ClientGraph m, int numTransactions, int numStatements, long sleepTime, String... args) {
            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                sb.append(arg);
                sb.append(" ");
            }
            baseStr = sb.toString();
            this.numTransactions = numTransactions;
            this.numStatements = numStatements;
            this.sleepTime = sleepTime;
            this.m = m;
            this.client = client;
        }

        public void run() {
            int count = 0;
            for (int i = 0; i < numTransactions; i++) {

                client.begin();
                for (int j = 0; j < numStatements; j++) {
                    m.add(Constants.valueFactory.createStatement(createTestUri("subject" + i), createTestUri("pred"), Constants.valueFactory.createLiteral(baseStr + "t " + i + ", s" + j)));
                    count++;
                }
                client.commit();

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                }

            }
            try {
                client.updateRepository();
            } catch (AnzoException e) {
                throw new AnzoRuntimeException(e);
            }
        }
    }

    class StatementClientAdder implements Runnable {

        String baseStr = null;

        int    numTransactions;

        int    numStatements;

        long   sleepTime;

        int[]  counts  = { 1, 1, 10, 10, 10, 100, 100, 8000 };

        int    id      = 0;

        public StatementClientAdder(int id, int numTransactions, int numStatements, long sleepTime, String... args) {
            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                sb.append(arg);
                sb.append(" ");
            }
            baseStr = sb.toString();
            this.numTransactions = numTransactions;
            this.numStatements = numStatements;
            this.sleepTime = sleepTime;
            this.id = id;
        }

        public void run() {
            try {
                AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
                client.connect();
                try {
                    ClientGraph serverGraph = client.getServerGraph(createTestUri("namedGraph" + id));
                    client.updateRepository();
                    int count = 0;
                    for (int i = 0; i < numTransactions; i++) {
                        client.begin();
                        for (int j = 0; j < counts[id]; j++) {
                            serverGraph.add(Constants.valueFactory.createStatement(createTestUri("subject" + i), createTestUri("pred"), Constants.valueFactory.createLiteral(baseStr + "t " + i + ", s" + j)));
                            count++;
                        }
                        client.commit();
                        client.updateRepository();
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {
                        }
                    }
                    // System.err.println("Client:"+id+" finished");

                } finally {
                    client.close();
                }
            } catch (AnzoException e) {
                throw new AnzoRuntimeException(e);
            }
        }
    }

    /**
     * Test getting old revision
     * 
     * @throws Exception
     */
    public void testOldRevisionSimple() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            URI uri = createTestUri("testUri");
            int currentVersion = 0;
            ClientGraph serverGraph = client.getServerGraph(uri);
            URI res = Constants.valueFactory.createURI("http://example.org/res");
            URI prop = Constants.valueFactory.createURI("http://example.org/ver");
            serverGraph.add(Constants.valueFactory.createStatement(res, prop, Constants.valueFactory.createLiteral("Version 0")));
            client.commit();
            client.updateRepository();
            Long rev = getNamedGraphRevisionNumber(client, uri);
            assertEquals(Long.valueOf(currentVersion++), rev);
            serverGraph.close();
            client.begin();
            serverGraph = client.getServerGraph(uri);
            serverGraph.clear();
            serverGraph.add(Constants.valueFactory.createStatement(res, prop, Constants.valueFactory.createLiteral("Version 1")));
            client.commit();
            client.updateRepository();
            rev = getNamedGraphRevisionNumber(client, uri);
            assertEquals(Long.valueOf(currentVersion++), rev);
            serverGraph.close();
            client.begin();
            serverGraph = client.getServerGraph(uri);
            serverGraph.clear();
            serverGraph.add(Constants.valueFactory.createStatement(res, prop, Constants.valueFactory.createLiteral("Version 2")));
            client.commit();
            client.updateRepository();
            rev = getNamedGraphRevisionNumber(client, uri);
            assertEquals(Long.valueOf(currentVersion++), rev);
            serverGraph.close();
            client.begin();
            serverGraph = client.getServerGraph(uri);
            serverGraph.clear();
            serverGraph.add(Constants.valueFactory.createStatement(res, prop, Constants.valueFactory.createLiteral("Version 3")));
            client.commit();
            client.updateRepository();
            rev = getNamedGraphRevisionNumber(client, uri);
            assertEquals(Long.valueOf(currentVersion++), rev);
            serverGraph.close();
            INamedGraph verGraph = client.getNamedGraphRevision(uri, 3);
            assertTrue(verGraph.contains(res, prop, Constants.valueFactory.createLiteral("Version 3")));
            verGraph = client.getNamedGraphRevision(uri, 2);
            assertTrue(verGraph.contains(res, prop, Constants.valueFactory.createLiteral("Version 2")));
        } finally {

            client.close();
        }
    }

    /**
     * Test adding duplicate literals
     * 
     * @throws Exception
     */
    public void testInsertDuplicateLiteral() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph serverGraph = client.getServerGraph(createTestUri("namedGraph1"));
            URI subj = Constants.valueFactory.createURI("http://test");
            URI pred = Constants.valueFactory.createURI("http://pred");
            URI pred2 = Constants.valueFactory.createURI("http://pred2");
            Literal obj = Constants.valueFactory.createLiteral("http://obj", XMLSchema.ANYURI);
            client.begin();
            serverGraph.add(Constants.valueFactory.createStatement(subj, pred, obj));
            serverGraph.add(Constants.valueFactory.createStatement(subj, pred2, obj));
            client.commit();
            client.updateRepository();
            Iterator<Statement> iter = serverGraph.find(null, null, obj).iterator();
            int count = 0;
            while (iter.hasNext()) {
                iter.next();
                count++;
            }

            assertEquals(2, count);
        } finally {

            client.close();
        }
    }

    String getNamedGraphRevision(AnzoClient client, URI id) throws Exception {
        Long revision = getNamedGraphRevisionNumber(client, id);
        if (revision == null)
            return null;
        return id + ":" + revision;
    }

    Long getNamedGraphRevisionNumber(AnzoClient client, URI id) throws Exception {
        ClientGraph serverGraph = client.getServerGraph(id);
        try {
            return getNamedGraphRevision(serverGraph);
        } finally {
            if (serverGraph != null)
                serverGraph.close();
        }
    }

    /**
     * For a ServerGraph, add stmt1, then verify a contains call finds the statement before and after a replicate call.
     * 
     * @throws Exception
     */
    public void testServerGraphFind() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph graph = client.getReplicaGraph(TestData.graph1);
            client.begin();
            graph.add(TestData.stmt1);
            client.commit();
            client.updateRepository();

            ClientGraph serverGraph = client.getServerGraph(TestData.graph1);
            assertTrue(serverGraph.contains(TestData.stmt1));
        } finally {

            client.close();
        }
    }

    /**
     * For a ServerGraph, add stmt1, replicate and then remove it and make sure it is removed before and after it is replicated.
     * 
     * Also make sure contains finds the statement during the isolated transaction.
     * 
     * @throws Exception
     */
    public void testServerGraphAddRemove() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph serverGraph = client.getServerGraph(TestData.graph1);

            serverGraph.remove(TestData.stmt1);

            assertFalse(serverGraph.contains(TestData.stmt1));

            client.begin();
            serverGraph.add(TestData.stmt1);
            assertTrue(serverGraph.contains(TestData.stmt1));
            client.commit();

            client.updateRepository();

            assertTrue(serverGraph.contains(TestData.stmt1));

            client.begin();
            serverGraph.remove(TestData.stmt1);
            assertFalse(serverGraph.contains(TestData.stmt1));
            client.commit();

            assertFalse(serverGraph.contains(TestData.stmt1));

            client.updateRepository();

            assertFalse(serverGraph.contains(TestData.stmt1));

        } finally {

            client.close();
        }
    }

    /**
     * For a ServerGraph, verify the size call returns the correct response before and after replication.
     * 
     * @throws Exception
     */
    public void testServerGraphSize() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph serverGraph = client.getServerGraph(TestData.graph1);

            int size = serverGraph.size();
            serverGraph.add(TestData.stmt1);
            int endSize = serverGraph.size();

            assertEquals(1, endSize - size);

            client.updateRepository();

            endSize = serverGraph.size();
            assertEquals(1, endSize - size);

        } finally {

            client.close();
        }
    }

    /**
     * For a ServerGraph, verify the size call returns the correct response before and after replication.
     * 
     * @throws Exception
     * 
     */
    public void testServerGraphPermission() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            /*ClientGraph serverGraph = */client.getServerGraph(TestData.graph1);
            client.updateRepository();
            assertTrue(client.canReadNamedGraph(TestData.graph1));
            assertTrue(client.canAddToNamedGraph(TestData.graph1));
            assertTrue(client.canRemoveFromNamedGraph(TestData.graph1));
        } finally {

            client.close();
        }
    }

    /**
     * Test removal of a namedGraph
     * 
     * @throws Exception
     */
    public void testServerGraphRemoval() throws Exception {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph serverGraph = client.getServerGraph(TestData.graph1, AnzoClient.REVISIONED_NAMED_GRAPH);

            int size = serverGraph.size();
            serverGraph.add(TestData.stmt1);
            int endSize = serverGraph.size();

            assertEquals(1, endSize - size);

            client.updateRepository();
            endSize = serverGraph.size();
            assertEquals(1, endSize - size);

            assertTrue(client.namedGraphExists(TestData.graph1));
            NamedGraph graph = AnzoFactory.getNamedGraph(serverGraph.getNamedGraphUri(), serverGraph.getMetadataGraph());
            URI uuid = graph.getUuid();
            serverGraph.getMetadataGraph().remove(TestData.graph1, RDF.TYPE, NamedGraph.TYPE);
            client.updateRepository();

            assertFalse(client.namedGraphExists(TestData.graph1));
            serverGraph.close();
            serverGraph = client.getServerGraph(TestData.graph1);
            client.updateRepository();
            graph = AnzoFactory.getNamedGraph(serverGraph.getNamedGraphUri(), serverGraph.getMetadataGraph());
            URI uuidNew = graph.getUuid();
            assertFalse(uuid.equals(uuidNew));

        } finally {

            client.close();
        }
    }

    /**
     * Make sure a metadata graph for a ServerGraph contains expected properties before it is replicated.
     * 
     * @throws Exception
     */
    public void testServerGraphMetadataGraph() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph serverGraph = client.getServerGraph(TestData.graph1);
            INamedGraph metadataGraph = serverGraph.getMetadataGraph();
            assertTrue(metadataGraph.contains(TestData.graph1, org.openanzo.ontologies.openanzo.NamedGraph.hasMetadataGraphProperty, metadataGraph.getNamedGraphUri()));
        } finally {

            client.close();
        }
    }

    /**
     * Verifies server graph events
     * 
     * @throws Exception
     */
    public void testServerGraphEvents() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.clear();
            client.reset(new ArrayList<Statement>(), null);
            client.clear();

            final ClientGraph serverGraph = client.getServerGraph(TestData.graph1);
            client.updateRepository();

            final HashMap<URI, Integer> map = new HashMap<URI, Integer>();
            map.put(serverGraph.getNamedGraphUri(), 0);
            map.put(serverGraph.getMetadataGraph().getNamedGraphUri(), 0);

            IStatementListener<INamedGraph> listener = new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    map.put(statements[0].getNamedGraphUri(), map.get(statements[0].getNamedGraphUri()) + statements.length);
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                }

            };

            serverGraph.registerListener(listener);
            serverGraph.getMetadataGraph().registerListener(listener);

            assertFalse(serverGraph.contains(TestData.stmt1));

            client.begin();
            serverGraph.add(TestData.stmt1);
            assertTrue(serverGraph.contains(TestData.stmt1));
            client.commit();

            client.updateRepository();

            assertTrue(serverGraph.contains(TestData.stmt1));

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return (Integer.valueOf(1).equals(map.get(serverGraph.getNamedGraphUri())));
                }
            });
            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return (Integer.valueOf(2).equals(map.get(serverGraph.getMetadataGraph().getNamedGraphUri())));
                }
            });
            assertEquals(Integer.valueOf(1), map.get(serverGraph.getNamedGraphUri()));
            assertEquals(Integer.valueOf(2), map.get(serverGraph.getMetadataGraph().getNamedGraphUri()));

        } finally {

            client.close();
        }
    }

    /**
     * Make sure a ServerGraph contains the correct metadata graph statements after replication. Double check with a second client that did not create the
     * graph.
     * 
     * @throws Exception
     */
    public void testCreateServerGraphTwice() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        client1.connect();
        try {
            client1.reset(new ArrayList<Statement>(), null);
            ClientGraph graph1 = client1.getServerGraph(TestData.graph1);
            assertEquals(3, graph1.getMetadataGraph().size());
            graph1.add(TestData.stmt1);
            assertEquals(3, graph1.getMetadataGraph().size());
            client1.updateRepository();
            assertEquals(17, graph1.getMetadataGraph().size());

            ClientGraph graph2 = client1.getServerGraph(TestData.graph1);
            assertEquals(17, graph2.getMetadataGraph().size());
        } finally {
            client1.close();
        }

        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        client2.connect();
        try {
            ClientGraph graph2 = client2.getServerGraph(TestData.graph1);
            graph2.add(TestData.stmt2);
            client2.updateRepository();
            assertEquals(17, graph2.getMetadataGraph().size());
        } finally {
            client2.close();
        }
    }

    /**
     * Test basic replication
     * 
     * @throws Exception
     */
    public void testReplicate() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        AnzoClient client2 = null;
        try {
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph graph = client.getReplicaGraph(TestData.graph1);
            graph.add(TestData.stmt1);
            graph.add(TestData.stmt2);

            client.begin();
            graph.add(TestData.stmt3);
            graph.add(TestData.stmt4);
            client.commit();

            client.commit();

            assertTrue(graph.contains(TestData.stmt1));
            assertTrue(graph.contains(TestData.stmt2));
            assertTrue(graph.contains(TestData.stmt3));
            assertTrue(graph.contains(TestData.stmt4));

            client.updateRepository();

            assertTrue(graph.contains(TestData.stmt1));
            assertTrue(graph.contains(TestData.stmt2));
            assertTrue(graph.contains(TestData.stmt3));
            assertTrue(graph.contains(TestData.stmt4));

            client2 = new AnzoClient(getDefaultClientConfiguration());
            client2.connect();
            ClientGraph graph2 = client2.getReplicaGraph(TestData.graph1);

            assertTrue(graph2.contains(TestData.stmt1));
            assertTrue(graph2.contains(TestData.stmt2));
            assertTrue(graph2.contains(TestData.stmt3));
            assertTrue(graph2.contains(TestData.stmt4));

        } finally {

            client.close();
            if (client2 != null)
                client2.close();
        }
    }

    /**
     * Test replication graph events
     * 
     * @throws Exception
     */
    public void testReplicationGraphEvents() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph graph = client.getReplicaGraph(TestData.graph1);
            graph.add(TestData.stmt1);
            graph.add(TestData.stmt2);

            client.begin();
            graph.add(TestData.stmt3);
            graph.add(TestData.stmt4);
            client.commit();
            client.commit();

            assertTrue(graph.contains(TestData.stmt1));
            assertTrue(graph.contains(TestData.stmt2));
            assertTrue(graph.contains(TestData.stmt3));
            assertTrue(graph.contains(TestData.stmt4));

            IStatementListener<INamedGraph> listener = new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    //can do an assert in the event handler because its called directly in the
                    //replicate call stack.
                    assertEquals(4, statements.length);
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {

                }

            };

            graph.registerListener(listener);

            client.updateRepository();

            assertTrue(graph.contains(TestData.stmt1));
            assertTrue(graph.contains(TestData.stmt2));
            assertTrue(graph.contains(TestData.stmt3));
            assertTrue(graph.contains(TestData.stmt4));

        } finally {

            client.close();
        }
    }

    /**
     * Test getting named graph updates
     * 
     * @throws Exception
     */
    public void testNamedGraphUpdates() throws Exception {

        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {
            client1 = new AnzoClient(getDefaultClientConfiguration());
            client2 = new AnzoClient(getDefaultClientConfiguration());

            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            client2.connect();

            ClientGraph replicaGraph1 = client1.getReplicaGraph(TestData.graph2);
            client1.updateRepository();

            final ClientGraph replicaGraph2 = client2.getReplicaGraph(TestData.graph2);
            client2.updateRepository();

            final int[] count = new int[2];

            replicaGraph2.registerListener(new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    //                    System.err.println("Statements added");
                    //                    for (int i=0;i<statements.length;i++) {
                    //                        System.err.println(statements[i]);
                    //                    }
                    count[0] += statements.length;
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                    count[1] += statements.length;
                }

            });

            client1.begin();
            replicaGraph1.add(TestData.stmt2);
            replicaGraph1.add(TestData.stmt3);
            client1.commit();
            client1.updateRepository();

            assertTrue(replicaGraph1.contains(TestData.stmt2));
            assertTrue(replicaGraph1.contains(TestData.stmt3));

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return count[0] == 2;
                }
            });
            assertEquals(2, count[0]);
            assertTrue(replicaGraph2.contains(TestData.stmt2));
            assertTrue(replicaGraph2.contains(TestData.stmt3));

            client1.begin();
            replicaGraph1.remove(TestData.stmt2);
            replicaGraph1.remove(TestData.stmt3);
            client1.commit();

            assertFalse(replicaGraph1.contains(TestData.stmt2));
            assertFalse(replicaGraph1.contains(TestData.stmt3));
            client1.updateRepository();
            assertFalse(replicaGraph1.contains(TestData.stmt2));
            assertFalse(replicaGraph1.contains(TestData.stmt3));

            TestUtilities.waitForStatement(replicaGraph2, TestData.stmt2, false);
            TestUtilities.waitForStatement(replicaGraph2, TestData.stmt3, false);

            assertFalse(replicaGraph2.contains(TestData.stmt2));
            assertFalse(replicaGraph2.contains(TestData.stmt3));
            assertEquals(0, replicaGraph2.size());

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return count[1] == 2;
                }
            });
            assertEquals(2, count[1]);

        } finally {
            if (client1 != null)
                client1.close();
            if (client2 != null)
                client2.close();
        }
    }

    /**
     * Test transaction events
     * 
     * @throws Exception
     */
    public void testTransactionEvents() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());

        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph graph2 = client.getReplicaGraph(TestData.graph2);
            ClientGraph graph1 = client.getReplicaGraph(TestData.graph1);
            client.commit();
            client.updateRepository();

            final boolean[] conditions = new boolean[3];
            for (int i = 0; i < conditions.length; i++) {
                conditions[i] = false;
            }

            ITransactionListener listener = new ITransactionListener() {

                public void transactionComplete(URI transactionURI, long transactionTimestamp, Set<URI> transactionGraphs, IDataset transactionContext) {
                    if (transactionGraphs.contains(TestData.graph2) && transactionGraphs.contains(TestData.graph1)) {
                        conditions[0] = true;
                    }
                    if (transactionContext.getNamedGraphUris().size() == 1) {
                        conditions[1] = true;
                    }
                    Iterator<Statement> stmts = transactionContext.getStatements().iterator();
                    int count = 0;
                    while (stmts.hasNext()) {
                        stmts.next();
                        count++;
                    }
                    conditions[2] = count == 2;
                }

                public void transactionFailed(URI transactionURI, Set<URI> transactionGraphs, IDataset transactionContext, List<AnzoException> errors) {

                }

            };

            client.registerTransactionListener(listener);

            client.begin();
            INamedGraph context = client.getTransactionContext();
            context.add(TestData.stmt4);
            context.add(TestData.stmt5);
            graph1.add(TestData.stmt1);
            graph2.add(TestData.stmt2);
            graph2.add(TestData.stmt3);
            client.commit();
            client.updateRepository();

            assertTrue(graph1.contains(TestData.stmt1));
            assertTrue(graph2.contains(TestData.stmt2));
            assertTrue(graph2.contains(TestData.stmt3));

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    for (int i = 0; i < conditions.length; i++) {
                        if (!conditions[i]) {
                            return false;
                        }
                    }
                    return true;
                }
            });

        } finally {

            client.close();
        }
    }

    /**
     * Test only one graph event
     * 
     * @throws Exception
     */
    public void testOnlyOneGraphEvent() throws Exception {

        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {
            client1 = new AnzoClient(getDefaultClientConfiguration());

            client2 = new AnzoClient(getDefaultClientConfiguration());

            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);

            client2.connect();

            ClientGraph replicaGraph1 = client1.getReplicaGraph(TestData.graph1);
            client1.updateRepository();

            ClientGraph replicaGraph2 = client2.getReplicaGraph(TestData.graph1);
            client2.updateRepository();

            final int[] count = new int[2];

            replicaGraph2.registerListener(new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    count[0] += statements.length;
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                    count[1] += statements.length;
                }

            });

            replicaGraph1.add(TestData.stmt1);
            client1.updateRepository();
            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return count[0] == 1;
                }
            });
            assertEquals(1, count[0]);
            client2.updateRepository();
            // make sure that we don't get duplicate events.
            assertEquals(1, count[0]);
            replicaGraph1.remove(TestData.stmt1);
            assertFalse(replicaGraph1.contains(TestData.stmt1));
            client1.updateRepository();
            assertFalse(replicaGraph1.contains(TestData.stmt1));
            TestUtilities.waitForStatement(replicaGraph2, TestData.stmt1, false);
            assertFalse(replicaGraph2.contains(TestData.stmt1));
            assertEquals(0, replicaGraph2.size());
            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return count[1] == 1;
                }
            });
            assertEquals(1, count[1]);
        } finally {
            if (client1 != null)
                client1.close();
            if (client2 != null)
                client2.close();
        }
    }

    /**
     * Verify that is a precondition is not met, that the server returns the correct error.
     * 
     * @throws Exception
     */
    public void testPreconditionAndUpdateError() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);

            IPrecondition precondition = new Precondition();

            String queryString = "ASK  { <" + TestData.subj1 + "> <" + TestData.pred1 + "> <" + TestData.objuri1 + ">}";

            precondition.setQuery(queryString);
            precondition.setDefaultGraphUris(Collections.singleton(GRAPHS.ALL_GRAPHS));

            client.begin(Collections.singleton(precondition));
            ClientGraph graph = client.getReplicaGraph(TestData.graph1);
            graph.add(TestData.stmt1);
            graph.add(TestData.stmt2);
            client.commit();

            boolean caught = false;
            try {
                client.updateRepository();
            } catch (UpdateServerException e) {
                caught = true;
                List<AnzoException>[] errors = e.getErrors();
                assertEquals(1, errors.length);
                List<AnzoException> list = errors[0];
                assertEquals(1, list.size());
                AnzoException ex = list.get(0);
                assertEquals(ExceptionConstants.DATASOURCE.COMMAND_PREREQ_FAILED, ex.getErrorCode());
            }
            assertTrue(caught);

            client.begin();
            graph = client.getReplicaGraph(TestData.graph1);
            graph.add(TestData.stmt1);
            graph.add(TestData.stmt2);
            client.commit();

            client.begin(Collections.singleton(precondition));
            graph.add(TestData.stmt1);
            graph.add(TestData.stmt3);
            client.commit();
        } finally {

            client.close();
        }

    }

    /**
     * Verifies that the metadata graph for a client graph is properly populated after a new graph is added via a ClientGraph and replicated.
     * 
     * @throws Exception
     */
    public void testCreateReplicaGraphTwice() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        client1.connect();
        try {
            client1.reset(new ArrayList<Statement>(), null);
            ClientGraph graph1 = client1.getReplicaGraph(TestData.graph1);
            graph1.add(TestData.stmt1);
            client1.updateRepository();
            assertEquals(17, graph1.getMetadataGraph().size());
        } finally {
            client1.close();
        }

        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        client2.connect();
        try {
            ClientGraph graph2 = client2.getReplicaGraph(TestData.graph1);
            graph2.add(TestData.stmt2);
            client2.updateRepository();
            assertEquals(17, graph2.getMetadataGraph().size());
        } finally {
            client2.close();
        }
    }

    /**
     * Adds two statements to graph1 via a ClientGraph and verifies they are found by a "SELECT * WHERE {GRAPH <graph1> { ?s ?p ?o}}" sparql query.
     * 
     * @throws Exception
     */
    public void testServerQuery() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);

            client.begin();
            replicaGraph.add(TestData.stmt1);
            replicaGraph.add(TestData.stmt2);
            client.commit();

            client.updateRepository();

            QueryResults results = client.serverQuery(Collections.singleton(TestData.graph1), Collections.singleton(TestData.graph1), null, "SELECT * WHERE {GRAPH <" + TestData.graph1 + "> {?s ?p ?o}}", Constants.valueFactory.createURI(TestData.prefix));
            Iterator<PatternSolution> result = results.getSelectResults().iterator();
            assertTrue(result.hasNext());

            boolean found1 = false;
            boolean found2 = false;

            while (result.hasNext()) {

                PatternSolution set = result.next();

                if (TestData.stmt1.getSubject().toString().equals(set.getBinding("s").toString()) && TestData.stmt1.getPredicate().toString().equals(set.getBinding("p").toString()) && TestData.stmt1.getObject().toString().equals(set.getBinding("o").toString())) {
                    found1 = true;
                }

                if (TestData.stmt2.getSubject().toString().equals(set.getBinding("s").toString()) && TestData.stmt2.getPredicate().toString().equals(set.getBinding("p").toString()) && TestData.stmt2.getObject().toString().equals(set.getBinding("o").toString())) {
                    found2 = true;
                }
            }

            assertTrue(found1);
            assertTrue(found2);
        } finally {

            client.close();
        }
    }

    /**
     * Adds two statements to graph1 via a ClientGraph and verifies they are found by a "SELECT * WHERE {GRAPH <graph1> { ?s ?p ?o}}" sparql query.
     * 
     * @throws Exception
     */
    public void testServerQueryWithSameGraphId() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);

            client.begin();
            Statement stmt1 = Constants.valueFactory.createStatement(TestData.graph1, TestData.pred1, TestData.subj1, TestData.graph1);
            Statement stmt2 = Constants.valueFactory.createStatement(TestData.subj1, TestData.pred2, TestData.obj2, TestData.graph1);
            Statement stmt3 = Constants.valueFactory.createStatement(TestData.graph1, TestData.pred3, TestData.obj3, TestData.graph1);

            replicaGraph.add(stmt1);
            replicaGraph.add(stmt2);
            replicaGraph.add(stmt3);
            client.commit();

            client.updateRepository();

            QueryResults results = client.serverQuery(Collections.singleton(TestData.graph1), Collections.singleton(TestData.graph1), null, "SELECT ?g WHERE {GRAPH ?g {?g " + QueryEncoder.encodeForQuery(TestData.pred1) + " ?o. ?o " + QueryEncoder.encodeForQuery(TestData.pred2) + "  ?o2. ?g " + QueryEncoder.encodeForQuery(TestData.pred3) + "  ?o3.}}", Constants.valueFactory.createURI(TestData.prefix));
            Iterator<PatternSolution> result = results.getSelectResults().iterator();
            assertTrue(result.hasNext());

        } finally {

            client.close();
        }
    }

    /**
     * Adds two statements to graph1 via a ClientGraph and verifies they are found by a "SELECT * WHERE {GRAPH <graph1> { ?s ?p ?o}}" sparql query.
     * 
     * @throws Exception
     */
    public void testHighLowPriorityServerQuery() throws Exception {

        final AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);

            client.begin();
            replicaGraph.add(TestData.stmt1);
            replicaGraph.add(TestData.stmt2);
            client.commit();

            client.updateRepository();
            ArrayList<Thread> threads = new ArrayList<Thread>();
            for (int i = 0; i < 500; i++) {
                final int j = i;
                Thread t1 = new Thread() {
                    @Override
                    public void run() {
                        try {
                            Map<String, Object> options = new HashMap<String, Object>();
                            options.put(OPTIONS.PRIORITY, (j % 100 == 0) ? 1 : 4);
                            client.serverQuery(Collections.singleton(TestData.graph1), Collections.singleton(TestData.graph1), null, "SELECT * WHERE {GRAPH <" + TestData.graph1 + "> {?s ?p ?o}}", Constants.valueFactory.createURI(TestData.prefix), options);
                        } catch (AnzoException ae) {
                        }
                    }
                };
                threads.add(t1);
            }
            for (Thread t1 : threads) {
                t1.start();
            }
            for (Thread t1 : threads) {
                t1.join();
            }
        } finally {

            client.close();
        }
    }

    /**
     * Adds two statements to graph1 via a ClientGraph and verifies they are found by a "SELECT * WHERE {GRAPH <graph1> { ?s ?p ?o}}" sparql query.
     * 
     * @throws Exception
     */
    public void testReplicaQuery() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);

            client.begin();
            replicaGraph.add(TestData.stmt1);
            client.commit();

            client.updateRepository();

            replicaGraph.add(TestData.stmt2);

            QueryResults results = client.replicaQuery(Collections.singleton(TestData.graph1), Collections.singleton(TestData.graph1), null, "SELECT * WHERE {GRAPH <" + TestData.graph1 + "> {?s ?p ?o}}", null);
            Iterator<PatternSolution> result = results.getSelectResults().iterator();
            assertTrue(result.hasNext());

            boolean found1 = false;
            boolean found2 = false;

            while (result.hasNext()) {

                PatternSolution set = result.next();

                if (TestData.stmt1.getSubject().toString().equals(set.getBinding("s").toString()) && TestData.stmt1.getPredicate().toString().equals(set.getBinding("p").toString()) && TestData.stmt1.getObject().toString().equals(set.getBinding("o").toString())) {
                    found1 = true;
                }

                if (TestData.stmt2.getSubject().toString().equals(set.getBinding("s").toString()) && TestData.stmt2.getPredicate().toString().equals(set.getBinding("p").toString()) && TestData.stmt2.getObject().toString().equals(set.getBinding("o").toString())) {
                    found2 = true;
                }
            }

            assertTrue(found1);
            assertTrue(found2);
        } finally {

            client.close();
        }
    }

    /**
     * Test realtime tracker events
     * 
     * @throws Exception
     */
    public void testBasicRealtimeTracker() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            client2.connect();

            final boolean[] test = new boolean[2];

            IStatementListener<ITracker> listener = new IStatementListener<ITracker>() {

                public void statementsAdded(ITracker source, Statement... statements) {
                    if (statements[0].equals(TestData.stmt1)) {
                        test[0] = true;
                    }
                }

                public void statementsRemoved(ITracker source, Statement... statements) {
                }

            };

            ITransactionListener transactionListener = new ITransactionListener() {

                public void transactionComplete(URI transactionURI, long transactionTimestamp, Set<URI> transactionGraphs, IDataset transactionContext) {
                    test[1] = !transactionContext.getStatements().isEmpty();
                }

                public void transactionFailed(URI transactionURI, Set<URI> transactionGraphs, IDataset transactionContext, List<AnzoException> errors) {
                }

            };

            client2.getRealtimeUpdates().addTracker(null, null, null, TestData.graph1, listener);
            client2.getRealtimeUpdates().addTransactionListener(transactionListener);

            client1.begin();

            client1.getTransactionContext().add(TestData.stmt1);

            ClientGraph replicaGraph1 = client1.getReplicaGraph(TestData.graph1);
            replicaGraph1.add(TestData.stmt1);
            client1.commit();
            client1.updateRepository();

            TestUtilities.waitFor(20000, new Condition() {
                @Override
                public boolean check() {
                    return test[0] && test[1] == true;
                }
            });

            assertTrue(test[0]);
            assertTrue(test[1]);

        } finally {
            client1.close();
            client2.close();
        }
    }

    /**
     * Test realtime dataset tracker events
     * 
     * @throws Exception
     */
    public void testBasicRealtimeDatasetTracker() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            client2.connect();

            final boolean[] test = new boolean[2];

            IDatasetListener listener = new IDatasetListener() {

                public void datasetChanged() {
                    test[0] = true;
                }
            };

            client2.getRealtimeUpdates().addTracker(Constants.valueFactory.createURI("http://test/testDS"), Collections.<URI> emptySet(), Collections.<URI> singleton(TestData.graph1), Collections.<URI> emptySet(), listener);

            client1.begin();

            ClientGraph replicaGraph1 = client1.getReplicaGraph(TestData.graph1);
            replicaGraph1.add(TestData.stmt1);
            client1.commit();
            client1.updateRepository();

            TestUtilities.waitFor(20000, new Condition() {
                @Override
                public boolean check() {
                    return test[0] == true;
                }
            });

            assertTrue(test[0]);

            test[0] = false;
            client1.begin();

            ClientGraph replicaGraph2 = client1.getReplicaGraph(TestData.graph2);
            replicaGraph2.add(TestData.stmt1);
            client1.commit();
            client1.updateRepository();

            Thread.sleep(2000);
            assertFalse(test[0]);

        } finally {
            client1.close();
            client2.close();
        }
    }

    /**
     * Test realtime dataset tracker events for modifying graphs mentioned by named datasets being tracked.
     * 
     * This test runs as sysadmin so that it tests the situation found in the latter part of http://www.openanzo.org/projects/openanzo/ticket/827 in which edits
     * to graphs with no ACL statements did not send out real-time events even for subscribed sysadmin users.
     * 
     * @throws Exception
     */
    public void testRealtimeDatasetTrackerNamedDatasetEventsForSysadmin() throws Exception {

        AnzoClient client1 = new AnzoClient(getSystemClientConfiguration());
        AnzoClient client2 = new AnzoClient(getSystemClientConfiguration());
        try {
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            client2.connect();

            // Create a graph and a named dataset that points to it.
            client1.begin();
            ClientGraph replicaGraph1 = client1.getReplicaGraph(TestData.graph1);
            replicaGraph1.add(TestData.graph1, RDF.TYPE, Dataset.TYPE);
            replicaGraph1.add(TestData.graph1, Dataset.defaultNamedGraphProperty, TestData.graph2);
            ClientGraph replicaGraph2 = client1.getReplicaGraph(TestData.graph2);
            replicaGraph2.add(TestData.graph2, RDF.TYPE, FOAF.Person);
            client1.commit();
            client1.updateRepository();

            final boolean[] test = new boolean[1];

            IDatasetListener listener = new IDatasetListener() {

                public void datasetChanged() {
                    test[0] = true;
                }
            };

            client2.getRealtimeUpdates().addTracker(Constants.valueFactory.createURI("http://test/testDS"), Collections.<URI> emptySet(), Collections.<URI> emptySet(), Collections.<URI> singleton(TestData.graph1), listener);

            client1.begin();
            replicaGraph1.add(TestData.stmt1);
            client1.commit();
            client1.updateRepository();

            TestUtilities.waitFor(20000, new Condition() {
                @Override
                public boolean check() {
                    return test[0] == true;
                }
            });

            assertTrue(test[0]);

        } finally {
            client1.close();
            client2.close();
        }
    }

    /**
     * Test basic datasets
     * 
     * @throws Exception
     */
    public void testDatasets() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            INamedGraph graph1 = client1.getReplicaGraph(TestData.graph1);
            graph1.add(TestData.stmt1);
            INamedGraph graph2 = client1.getServerGraph(TestData.graph2);
            graph2.add(TestData.stmt2);
            client1.updateRepository();

            IDataset dataset = client1.getAllReplicaGraphsDataset();
            assertTrue(dataset.contains(TestData.stmt1));
            assertFalse(dataset.contains(TestData.stmt2));

            dataset = client1.getAllServerGraphsDataset();
            assertFalse(dataset.contains(TestData.stmt1));
            assertTrue(dataset.contains(TestData.stmt2));

            dataset.addDefaultGraph(TestData.graph2);
            assertTrue(dataset.containsDefaultGraph(TestData.graph2));
            assertFalse(dataset.containsDefaultGraph(TestData.graph1));
            assertTrue(dataset.containsNamedGraph(TestData.graph2));
            assertFalse(dataset.containsNamedGraph(TestData.graph1));

            final List<Statement> adds = new ArrayList<Statement>();
            final List<Statement> removes = new ArrayList<Statement>();

            IStatementListener<IDataset> listener = new IStatementListener<IDataset>() {
                public void statementsAdded(IDataset source, Statement... statements) {
                    adds.addAll(Arrays.asList(statements));
                }

                public void statementsRemoved(IDataset source, Statement... statements) {
                    removes.addAll(Arrays.asList(statements));
                }
            };

            dataset.registerListener(listener);
            graph2.add(TestData.stmt3);
            graph2.remove(TestData.stmt2);

            client1.updateRepository();
            TestUtilities.waitFor(new AssertBlock() {
                @Override
                public void test() {
                    assertTrue(adds.contains(TestData.stmt3));
                    assertTrue(removes.contains(TestData.stmt2));
                }
            });

            dataset.close();

        } finally {
            client1.close();
        }
    }

    /**
     * Test anzo client datasets
     * 
     * @throws Exception
     */
    public void testAnzoClientDataset() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            Set<URI> uris = new HashSet<URI>();
            uris.add(TestData.graph1);
            uris.add(TestData.graph2);
            IDataset dataset = client1.createReplicaDataset(false, TestData.graph1, null, uris);
            dataset.add(TestData.stmt1);
            dataset.add(TestData.stmt2);

            ClientGraph graph1 = client1.getReplicaGraph(TestData.graph1);
            assertTrue(graph1.contains(TestData.stmt1));

            client1.updateRepository();

            assertTrue(graph1.contains(TestData.stmt1));
            assertTrue(dataset.contains(TestData.stmt2));

            dataset.close();

        } finally {
            client1.close();
        }

    }

    /**
     * Test stored anzo client datasets
     * 
     * @throws Exception
     */
    public void testStoredAnzoClientDataset() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            client2.connect();

            Set<URI> uris = new HashSet<URI>();
            Set<URI> defaults = new HashSet<URI>();
            IDataset dataset = client1.createReplicaDataset(true, TestData.graph1, defaults, uris);

            dataset.addNamedGraph(TestData.graph2);
            dataset.addNamedGraph(TestData.graph3);
            dataset.addDefaultGraph(TestData.graph2);

            INamedGraph datasetGraph = dataset.getDatasetGraph();
            assertEquals(4, datasetGraph.getStatements().size());

            client1.updateRepository();

            client2.getReplicaGraph(TestData.graph1);

            dataset = client2.createReplicaDataset(true, TestData.graph1, defaults, uris);
            assertTrue(dataset.containsNamedGraph(TestData.graph2));
            assertTrue(dataset.containsNamedGraph(TestData.graph3));
            assertTrue(dataset.containsDefaultGraph(TestData.graph2));

        } finally {
            client1.close();
            client2.close();
        }

    }

    /**
     * Test named graph revision
     * 
     * @throws Exception
     */
    public void testGetNamedGraphRevision2() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph graph = client.getReplicaGraph(TestData.graph2);
            client.updateRepository();
            graph.add(TestData.stmt2);
            client.updateRepository();
            Iterator<Statement> stmts = graph.getMetadataGraph().find(TestData.graph2, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null).iterator();
            assertTrue(stmts.hasNext());

            graph.add(TestData.stmt3);
            client.updateRepository();
            graph.add(TestData.stmt4);
            client.updateRepository();

            for (int i = 0; i <= 3; i++) {
                INamedGraph rev = client.getNamedGraphRevision(TestData.graph2, i);
                assertEquals(i, rev.size());
            }

        } finally {
            {
                client.close();
            }
        }
    }

    /**
     * Test client fails when getting invalid revision
     * 
     * @throws Exception
     */
    public void testGetNamedGraphRevisionFail() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph graph = client.getReplicaGraph(TestData.graph2);
            client.updateRepository();
            graph.add(TestData.stmt2);
            client.updateRepository();
            Iterator<Statement> stmts = graph.getMetadataGraph().find(TestData.graph2, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null).iterator();
            assertTrue(stmts.hasNext());

            graph.add(TestData.stmt3);
            client.updateRepository();
            graph.add(TestData.stmt4);
            client.updateRepository();
            boolean exceptionThrown = false;
            try {
                client.getNamedGraphRevision(TestData.graph2, 10);
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

        } finally {
            client.close();
        }
    }

    /**
     * Test metadata graph uri creation
     * 
     * @throws Exception
     */
    public void testGeneratedMetadataGraphUris() throws Exception {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph namedGraph = client.getServerGraph(TestData.graph1);
            ClientGraph systemGraph = client.getServerGraph(GRAPHS.DEFAULT_SYSTEMGRAPH);
            INamedGraph metadataGraph = systemGraph.getMetadataGraph();

            assertEquals(UriGenerator.generateMetadataGraphUri(systemGraph.getNamedGraphUri()), metadataGraph.getNamedGraphUri());

            client.begin();
            ACLUtil.setPermissions(namedGraph, TestData.role1, true, true, true, true, true, true);
            client.commit();

            client.updateRepository();

        } finally {

            client.close();
        }
    }

    /**
     * Test creating a non-revisioned graph
     * 
     * @throws Exception
     */
    public void testNonRevisionedGraphs() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client.getReplicaGraph(GRAPH_URI, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
            URI r = Constants.valueFactory.createURI("urn:test");
            replicaGraph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));
            client.updateRepository();
            assertEquals(1, replicaGraph.size());
            // verify that is there
            assertTrue(replicaGraph.contains(r, RDF.TYPE, RDF.ALT));

            INamedGraph meta = replicaGraph.getMetadataGraph();
            NamedGraph graph = AnzoFactory.getNamedGraph(replicaGraph.getNamedGraphUri(), meta);

            assertEquals(false, (boolean) graph.getRevisioned());

        } finally {

            client.close();
        }
    }

    /**
     * Test statement channels
     * 
     * @throws Exception
     */
    public void testStatementStreams() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        AnzoClient client3 = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        client2.connect();
        client3.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            IStatementChannel channel = client.getStatementChannel(GRAPH_URI, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
            client.updateRepository();

            IStatementChannel channel2 = client2.getStatementChannel(GRAPH_URI, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
            client2.updateRepository();

            final Collection<Statement> statementsReceived = new ArrayList<Statement>();

            channel2.registerListener(new IStatementChannelListener() {

                public void statementsReceived(Map<String, Object> messagePropertes, Collection<Statement> statements) {
                    statementsReceived.addAll(statements);
                }

                public void channelClosed() {
                }

            });

            final Collection<Statement> statementsReceived3 = new ArrayList<Statement>();
            IStatementChannel channel3 = client3.getStatementChannel(GRAPH_URI_2, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
            client3.updateRepository();

            channel3.registerListener(new IStatementChannelListener() {

                public void statementsReceived(Map<String, Object> messagePropertes, Collection<Statement> statements) {
                    statementsReceived3.addAll(statements);
                }

                public void channelClosed() {
                }

            });

            Collection<Statement> statements = loadStatements("initialize.trig");
            channel.sendMessage(null, statements);
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return statementsReceived.size() > 0;
                }
            });

            assertEquals(statements.size(), statementsReceived.size());
            assertEquals(0, statementsReceived3.size());

        } finally {

            client.close();
            client2.close();
            client3.close();
        }
    }

    /**
     * Test same client statement channel
     * 
     * @throws Exception
     */
    public void testStatementChannelSameClient() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            IStatementChannel channel = client.getStatementChannel(GRAPH_URI, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
            client.updateRepository();

            final Collection<Statement> statementsReceived = new ArrayList<Statement>();

            channel.registerListener(new IStatementChannelListener() {

                public void statementsReceived(Map<String, Object> messagePropertes, Collection<Statement> statements) {
                    statementsReceived.addAll(statements);
                }

                public void channelClosed() {
                }

            });

            Collection<Statement> statements = loadStatements("initialize.trig");
            channel.sendMessage(null, statements);
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return statementsReceived.size() > 0;
                }
            });

            assertEquals(statements.size(), statementsReceived.size());

        } finally {

            client.close();
        }
    }

    /**
     * Test getting existing replica graph
     * 
     * @throws Exception
     */
    public void testExistingReplicaGraph() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client1.connect();
            client2.connect();
            client1.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client1.getReplicaGraph(TestData.graph1);
            replicaGraph.add(TestData.stmt1);
            client1.updateRepository();
            assertTrue(replicaGraph.size() == 1);
            assertTrue(replicaGraph.contains(TestData.stmt1));

            ClientGraph graph2 = client2.getReplicaGraph(TestData.graph1);

            assertTrue(graph2.size() == 1);
            assertTrue(graph2.contains(TestData.stmt1));
            client2.begin();
            graph2.add(TestData.stmt2);
            client2.commit();
            client2.updateRepository();

            assertTrue(graph2.contains(TestData.stmt2));

        } finally {
            client1.close();
            client2.close();
        }
    }

    /**
     * Test deleting existing graph
     * 
     * @throws Exception
     */
    public void testDeletingExistingReplicaGraph() throws Exception {

        AnzoClient client1 = new AnzoClient(getSystemClientConfiguration());
        AnzoClient client2 = new AnzoClient(getSystemClientConfiguration());
        try {
            client1.connect();
            client2.connect();
            client1.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client1.getReplicaGraph(TestData.graph1);
            replicaGraph.add(TestData.stmt1);
            client1.updateRepository();
            assertTrue(replicaGraph.size() == 1);
            assertTrue(replicaGraph.contains(TestData.stmt1));

            ClientGraph graph2 = client2.getReplicaGraph(TestData.graph1);

            assertTrue(graph2.size() == 1);
            assertTrue(graph2.contains(TestData.stmt1));
            client2.begin();
            graph2.getMetadataGraph().remove(TestData.graph1, RDF.TYPE, NamedGraph.TYPE);
            client2.commit();
            client2.updateRepository();

            assertFalse(client2.namedGraphExists(TestData.graph1));
            assertFalse(client1.namedGraphExists(TestData.graph1));

        } finally {
            client1.close();
            client2.close();
        }
    }

    /**
     * Test deleting existing server graph
     * 
     * @throws Exception
     */
    public void testDeletingExistingServerGraph() throws Exception {

        AnzoClient client1 = new AnzoClient(getSystemClientConfiguration());
        AnzoClient client2 = new AnzoClient(getSystemClientConfiguration());
        try {
            client1.connect();
            client2.connect();
            client1.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client1.getReplicaGraph(TestData.graph1);
            replicaGraph.add(TestData.stmt1);
            client1.updateRepository();
            assertTrue(replicaGraph.size() == 1);
            assertTrue(replicaGraph.contains(TestData.stmt1));

            ClientGraph graph2 = client2.getServerGraph(TestData.graph1);

            assertTrue(graph2.size() == 1);
            assertTrue(graph2.contains(TestData.stmt1));
            client2.begin();
            graph2.getMetadataGraph().remove(TestData.graph1, RDF.TYPE, NamedGraph.TYPE);
            client2.commit();
            client2.updateRepository();

            assertFalse(client2.namedGraphExists(TestData.graph1));
            assertFalse(client1.namedGraphExists(TestData.graph1));

        } finally {
            client1.close();
            client2.close();
        }
    }

    /**
     * Test deleting and creating the same graph
     * 
     * @throws Exception
     */
    public void testDeletingAndCreatingExistingServerGraph() throws Exception {

        AnzoClient client1 = new AnzoClient(getSystemClientConfiguration());
        AnzoClient client2 = new AnzoClient(getSystemClientConfiguration());
        try {
            client1.connect();
            client2.connect();
            client1.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client1.getReplicaGraph(TestData.graph1);
            replicaGraph.add(TestData.stmt1);
            client1.updateRepository();
            assertTrue(replicaGraph.size() == 1);
            assertTrue(replicaGraph.contains(TestData.stmt1));

            ClientGraph graph2 = client2.getServerGraph(TestData.graph1);

            assertTrue(graph2.size() == 1);
            assertTrue(graph2.contains(TestData.stmt1));
            client2.begin();
            graph2.getMetadataGraph().remove(TestData.graph1, RDF.TYPE, NamedGraph.TYPE);
            client2.commit();
            client2.updateRepository();
            graph2.close();

            assertFalse(client2.namedGraphExists(TestData.graph1));
            assertFalse(client1.namedGraphExists(TestData.graph1));

            // important that this is a replica graph because it
            // checks the quad store for a uuid property
            graph2 = client2.getReplicaGraph(TestData.graph1);
            client2.updateRepository();
            assertTrue(client2.namedGraphExists(TestData.graph1));

        } finally {
            client1.close();
            client2.close();
        }
    }

    /**
     * Test getting and old graph after delete
     * 
     * @throws Exception
     */
    public void testGettingOldGraphAfterDelete() throws Exception {

        AnzoClient client1 = new AnzoClient(getSystemClientConfiguration());
        try {
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            ClientGraph graph = client1.getReplicaGraph(TestData.graph1);
            graph.add(TestData.stmt1);
            client1.updateRepository();
            assertTrue(graph.size() == 1);
            assertTrue(graph.contains(TestData.stmt1));
            Long rev = getNamedGraphRevisionNumber(client1, TestData.graph1);
            assertEquals(1, rev.longValue());
            client1.begin();
            graph.getMetadataGraph().remove(TestData.graph1, RDF.TYPE, NamedGraph.TYPE);
            client1.commit();
            client1.updateRepository();
            graph.close();

            assertFalse(client1.namedGraphExists(TestData.graph1));

            // important that this is a replica graph because it
            // checks the quad store for a uuid property
            graph = client1.getReplicaGraph(TestData.graph1);
            client1.updateRepository();
            assertTrue(client1.namedGraphExists(TestData.graph1));
            Long rev2 = getNamedGraphRevisionNumber(client1, TestData.graph1);
            assertEquals(0, rev2.longValue());
            boolean exceptionThrown = false;
            try {
                client1.getNamedGraphRevision(TestData.graph1, 1);
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
        } finally {
            client1.close();
        }
    }

    /**
     * Test closing replica graph
     * 
     * @throws Exception
     */
    public void testCloseReplicaGraph() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph2);
            replicaGraph.add(TestData.stmt2);
            replicaGraph.add(TestData.stmt3);
            client.updateRepository();
            assertTrue(replicaGraph.size() == 2);
            // verify that is there
            assertTrue(replicaGraph.contains(TestData.stmt2));
            assertTrue(!client.replicaFind(TestData.stmt2.getSubject(), TestData.stmt2.getPredicate(), TestData.stmt2.getObject(), TestData.graph2).isEmpty());
            replicaGraph.close();
            assertFalse(!client.replicaFind(TestData.stmt2.getSubject(), TestData.stmt2.getPredicate(), TestData.stmt2.getObject(), TestData.graph2).isEmpty());
        } finally {

            client.close();
        }
    }

    /**
     * Test update repository on commit
     * 
     * @throws Exception
     */
    public void testUpdateRepositoryOnCommit() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        client.setUpdateRepositoryOnCommit(true);
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        client2.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph2);
            replicaGraph.add(TestData.stmt2);
            replicaGraph.add(TestData.stmt3);
            client.commit();
            assertTrue(replicaGraph.size() == 2);
            // verify that is there
            assertTrue(replicaGraph.contains(TestData.stmt2));
            assertTrue(!client.replicaFind(TestData.stmt2.getSubject(), TestData.stmt2.getPredicate(), TestData.stmt2.getObject(), TestData.graph2).isEmpty());
            replicaGraph.close();
            assertFalse(!client.replicaFind(TestData.stmt2.getSubject(), TestData.stmt2.getPredicate(), TestData.stmt2.getObject(), TestData.graph2).isEmpty());

            ClientGraph graph2 = client2.getReplicaGraph(TestData.graph2);
            assertTrue(graph2.size() == 2);
            assertTrue(graph2.contains(TestData.stmt2));

        } finally {

            client.close();
            client2.close();
        }
    }

    /**
     * Test offline connection
     * 
     * @throws Exception
     */
    public void testOfflineAndConnect() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.setUpdateRepositoryOnCommit(true);
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph2);
            replicaGraph.add(TestData.stmt2);
            replicaGraph.add(TestData.stmt3);
            client.commit();
            assertTrue(replicaGraph.size() == 2);
            // verify that is there
            assertTrue(replicaGraph.contains(TestData.stmt2));
            assertTrue(!client.replicaFind(TestData.stmt2.getSubject(), TestData.stmt2.getPredicate(), TestData.stmt2.getObject(), TestData.graph2).isEmpty());
            replicaGraph.close();
            assertFalse(!client.replicaFind(TestData.stmt2.getSubject(), TestData.stmt2.getPredicate(), TestData.stmt2.getObject(), TestData.graph2).isEmpty());

            ClientGraph graph2 = client2.getReplicaGraph(TestData.graph2);
            assertFalse(graph2.size() == 2);
            assertFalse(graph2.contains(TestData.stmt2));

            // perform a connect and see that the graph connects as well, automatically.
            client2.connect();
            assertTrue(graph2.size() == 2);
            assertTrue(graph2.contains(TestData.stmt2));

        } finally {

            client.close();
            client2.close();
        }
    }

    /**
     * Test noop transaction
     * 
     * @throws Exception
     */
    public void testNoopTransaction() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client1.connect();
            client2.connect();
            client1.reset(new ArrayList<Statement>(), null);
            client1.begin();
            ClientGraph replicaGraph = client1.getReplicaGraph(TestData.graph1);
            replicaGraph.add(TestData.stmt1);
            replicaGraph.add(TestData.stmt2);
            replicaGraph.add(TestData.stmt3);
            client1.commit();
            client1.updateRepository();
            assertTrue(replicaGraph.size() == 3);
            assertTrue(replicaGraph.contains(TestData.stmt1));
            assertTrue(replicaGraph.contains(TestData.stmt2));
            assertTrue(replicaGraph.contains(TestData.stmt3));

            ClientGraph graph2 = client2.getReplicaGraph(TestData.graph1);

            graph2.add(TestData.stmt1);
            graph2.add(TestData.stmt2);
            graph2.add(TestData.stmt3);
            graph2.add(TestData.stmt4);
            client2.updateRepository();
            assertTrue(graph2.contains(TestData.stmt4));

        } finally {
            client1.close();
            client2.close();
        }
    }

    /**
     * Test get replica graphs
     * 
     * @throws Exception
     */
    public void testGetReplicaGraphs() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client1.connect();
            client2.connect();
            client1.reset(new ArrayList<Statement>(), null);
            ClientGraph graph1 = client1.getReplicaGraph(TestData.graph1);
            graph1.add(TestData.stmt1);
            ClientGraph graph2 = client1.getReplicaGraph(TestData.graph2);
            graph2.add(TestData.stmt2);
            client1.updateRepository();
            assertTrue(graph1.size() == 1);
            assertTrue(graph1.contains(TestData.stmt1));
            assertTrue(graph2.size() == 1);
            assertTrue(graph2.contains(TestData.stmt2));

            Set<URI> graphsToGet = new HashSet<URI>();
            graphsToGet.add(TestData.graph1);
            graphsToGet.add(TestData.graph2);
            graphsToGet.add(TestData.graph3);
            graphsToGet.add(TestData.graph4);

            Map<URI, ClientGraph> graphs = client2.getReplicaGraphs(graphsToGet);

            assertEquals(4, graphs.size());
            assertTrue(graphs.get(TestData.graph1).contains(TestData.stmt1));
            assertTrue(graphs.get(TestData.graph2).contains(TestData.stmt2));
            graphs.get(TestData.graph3).add(TestData.stmt3);
            graphs.get(TestData.graph4).add(TestData.stmt4);

            client2.updateRepository();

            assertTrue(graphs.get(TestData.graph3).contains(TestData.stmt3));
            assertTrue(graphs.get(TestData.graph4).contains(TestData.stmt4));

        } finally {
            client1.close();
            client2.close();
        }
    }

    /**
     * Test graph table isolation
     * 
     * @throws Exception
     */
    public void testGraphTableIsolation() throws Exception {
        final AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);

            final boolean[] status = new boolean[] { false, false };

            Thread t1 = new Thread() {

                @Override
                public void run() {
                    try {
                        client.begin();
                        client.getReplicaGraph(TestData.graph1);
                        status[0] = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            };

            Thread t2 = new Thread() {

                @Override
                public void run() {
                    try {
                        TestUtilities.waitFor(new Condition() {
                            @Override
                            public boolean check() {
                                return status[0];
                            }
                        });
                        client.begin();
                        ClientGraph graph = client.getReplicaGraph(TestData.graph1);
                        graph.add(TestData.stmt1);
                        client.commit();
                        status[1] = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            };

            t1.start();
            t2.start();

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return status[0] && status[1];
                }
            });

            client.updateRepository();

        } finally {

            client.close();
        }

    }

    /**
     * Test graph table isolation events
     * 
     * @throws Exception
     */
    public void testGraphTableIsolationEvents() throws Exception {
        final AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);

            final boolean[] status = new boolean[] { false, false };

            final boolean[] received = new boolean[] { false, false, false, false };

            final IStatementListener<INamedGraph> l1 = new IStatementListener<INamedGraph>() {
                public void statementsAdded(INamedGraph source, Statement... statements) {
                    received[0] = true;
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                }
            };

            final IStatementListener<INamedGraph> l2 = new IStatementListener<INamedGraph>() {
                public void statementsAdded(INamedGraph source, Statement... statements) {
                    received[1] = true;
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                }
            };

            final IStatementListener<INamedGraph> ml1 = new IStatementListener<INamedGraph>() {
                public void statementsAdded(INamedGraph source, Statement... statements) {
                    received[2] = true;
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                }
            };

            final IStatementListener<INamedGraph> ml2 = new IStatementListener<INamedGraph>() {
                public void statementsAdded(INamedGraph source, Statement... statements) {
                    received[3] = true;
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                }
            };

            Thread t1 = new Thread() {

                @Override
                public void run() {
                    try {
                        client.begin();
                        ClientGraph graph = client.getReplicaGraph(TestData.graph1);
                        graph.registerListener(l1);
                        graph.getMetadataGraph().registerListener(ml1);
                        status[0] = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            };

            Thread t2 = new Thread() {

                @Override
                public void run() {
                    try {
                        TestUtilities.waitFor(new Condition() {
                            @Override
                            public boolean check() {
                                return status[0];
                            }
                        });
                        client.begin();
                        ClientGraph graph = client.getReplicaGraph(TestData.graph1);
                        graph.registerListener(l2);
                        graph.getMetadataGraph().registerListener(ml2);
                        graph.add(TestData.stmt1);
                        client.commit();
                        status[1] = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            };

            t1.start();
            t2.start();

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return status[0] && status[1];
                }
            });

            client.updateRepository();

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return received[0] && received[1] && received[2] && received[3];
                }
            });

        } finally {

            client.close();
        }
    }

    /**
     * Test graph table isolation closing
     * 
     * @throws Exception
     */
    public void testGraphTableIsolationClosing() throws Exception {
        final AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);

            final boolean[] status = new boolean[] { false, false, false };

            client.begin();
            ClientGraph graph = client.getReplicaGraph(TestData.graph1);
            graph.add(TestData.stmt1);
            client.commit();
            client.updateRepository();
            graph.close();

            Thread t1 = new Thread() {

                @Override
                public void run() {
                    try {
                        client.begin();
                        ClientGraph g1 = client.getReplicaGraph(TestData.graph1);
                        assertTrue(g1.contains(TestData.stmt1));
                        status[0] = true;
                        TestUtilities.waitFor(new Condition() {
                            @Override
                            public boolean check() {
                                return status[1];
                            }
                        });
                        assertTrue(g1.contains(TestData.stmt1));
                        status[2] = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            };

            Thread t2 = new Thread() {

                @Override
                public void run() {
                    try {
                        TestUtilities.waitFor(new Condition() {
                            @Override
                            public boolean check() {
                                return status[0];
                            }
                        });
                        ClientGraph g2 = client.getReplicaGraph(TestData.graph1);
                        assertTrue(g2.contains(TestData.stmt1));
                        g2.close();
                        status[1] = true;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            };

            t1.start();
            t2.start();

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return status[0] && status[1] && status[2];
                }
            });

        } finally {

            client.close();
        }

    }

    /**
     * Verify that is a precondition is not met, that the server returns the correct error.
     * 
     * @throws Exception
     */
    public void testGraphExistenceInitializer() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);

            ClientGraph graph = client.getReplicaGraph(TestData.graph1, AnzoClient.GRAPH_MUST_EXIST);

            boolean caught = false;
            try {
                client.updateRepository();
            } catch (UpdateServerException e) {
                AnzoException ex = e.getErrors()[0].get(0);
                caught = true;
                assertEquals(ExceptionConstants.DATASOURCE.COMMAND_PREREQ_FAILED, ex.getErrorCode());
            }
            assertTrue(caught);

            graph.close();

            graph = client.getReplicaGraph(TestData.graph1, AnzoClient.GRAPH_MUST_NOT_EXIST);
            client.updateRepository();

            graph.close();

            graph = client.getReplicaGraph(TestData.graph1, AnzoClient.GRAPH_MUST_EXIST);
            client.updateRepository();

            graph.close();

            caught = false;
            client.begin();
            graph = client.getReplicaGraph(TestData.graph1, AnzoClient.GRAPH_MUST_NOT_EXIST);
            graph.add(TestData.stmt1);
            client.commit();
            try {
                client.updateRepository();
            } catch (UpdateServerException e) {
                AnzoException ex = e.getErrors()[0].get(0);
                caught = true;
                assertEquals(ExceptionConstants.DATASOURCE.COMMAND_PREREQ_FAILED, ex.getErrorCode());
            }
            assertTrue(caught);

        } finally {
            client.close();
        }
    }

    /**
     * Test removal of a namedGraph
     * 
     * @throws Exception
     */
    public void testGraphRemovalEvents() throws Exception {

        AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        client.connect();
        AnzoClient client2 = new AnzoClient(getSystemClientConfiguration());
        client2.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph graph = client.getReplicaGraph(TestData.graph1, AnzoClient.REVISIONED_NAMED_GRAPH);

            int size = graph.size();
            graph.add(TestData.stmt1);
            int endSize = graph.size();

            assertEquals(1, endSize - size);

            client.updateRepository();
            endSize = graph.size();
            assertEquals(1, endSize - size);

            ClientGraph graph2 = client2.getReplicaGraph(TestData.graph1, AnzoClient.REVISIONED_NAMED_GRAPH);
            assertTrue(graph2.contains(TestData.stmt1));
            graph2.registerListener(new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                    //System.err.println("Graph2 removed: " + statements.length);
                }

            });

            graph.registerListener(new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                    //System.err.println("Graph removed: " + statements.length);
                }

            });

            assertTrue(client.namedGraphExists(TestData.graph1));

            graph.add(TestData.stmt2);
            client.updateRepository();

            NamedGraph g = AnzoFactory.getNamedGraph(graph.getNamedGraphUri(), graph.getMetadataGraph());
            URI uuid = g.getUuid();
            graph.getMetadataGraph().remove(TestData.graph1, RDF.TYPE, NamedGraph.TYPE);
            client.updateRepository();

            assertFalse(client.namedGraphExists(TestData.graph1));
            graph.close();
            graph = client.getServerGraph(TestData.graph1);
            client.updateRepository();
            g = AnzoFactory.getNamedGraph(graph.getNamedGraphUri(), graph.getMetadataGraph());
            URI uuidNew = g.getUuid();
            assertFalse(uuid.equals(uuidNew));

        } finally {

            client.close();
            client2.close();
        }
    }

    /**
     * Test error reporting
     * 
     * @throws Exception
     */
    public void testErrorReporting() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);

            client.begin();
            ClientGraph graph = client.getReplicaGraph(TestData.graph1, AnzoClient.GRAPH_MUST_EXIST);
            graph.add(TestData.stmt1);
            URI transactionUri = client.getTransactionContext().getNamedGraphUri();

            client.commit();

            client.begin();
            ClientGraph graph2 = client.getReplicaGraph(TestData.graph2, AnzoClient.GRAPH_MUST_NOT_EXIST);
            graph2.add(TestData.stmt2);
            client.commit();

            boolean caught = false;
            try {
                client.updateRepository();
            } catch (UpdateServerException e) {

                assertEquals(transactionUri, e.getTransactions()[0].getURI());

                AnzoException ex = e.getErrors()[0].get(0);
                caught = true;
                assertEquals(ExceptionConstants.DATASOURCE.COMMAND_PREREQ_FAILED, ex.getErrorCode());
            }
            assertTrue(caught);

        } finally {
            client.close();
        }
    }

    /**
     * Test dependent transaction fail correctly
     * 
     * @throws Exception
     */
    public void testDependentTransactionFailure() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);

            client.begin();
            ClientGraph graph = client.getReplicaGraph(TestData.graph1);
            graph.add(TestData.stmt8);
            client.commit();

            client.updateRepository();

            client.begin();
            graph.add(TestData.stmt2);
            client.commit();

            IPrecondition precondition = new Precondition();
            String queryString = "ASK  { <" + TestData.subj1 + "> <" + TestData.pred1 + "> <" + TestData.objuri1 + ">}";
            precondition.setQuery(queryString);
            precondition.setDefaultGraphUris(Collections.singleton(GRAPHS.ALL_GRAPHS));
            precondition.setResult(false);

            client.begin(Collections.singleton(precondition));
            graph.add(TestData.stmt3);
            client.commit();

            client.begin(Collections.singleton(precondition));
            client.getReplicaGraph(TestData.graph2);
            graph.add(TestData.stmt1);
            client.commit();

            boolean caught = false;
            try {
                client.updateRepository();
            } catch (UpdateServerException e) {

                AnzoException ex = e.getErrors()[0].get(0);
                caught = true;
                assertEquals(ExceptionConstants.DATASOURCE.COMMAND_PREREQ_FAILED, ex.getErrorCode());
                ex = e.getErrors()[1].get(0);
                assertEquals(ExceptionConstants.DATASOURCE.PREVIOUS_TRANSACTION_FAILED, ex.getErrorCode());
            }
            assertTrue(caught);

            // graph2 should not exist because its transactions contains an
            // update to graph1, which was modified in the previous failed transaction,
            // in the same update call.
            assertFalse(client.namedGraphExists(TestData.graph2));

        } finally {
            client.close();
        }
    }

    /**
     * Test the local transaction events
     * 
     * @throws Exception
     */
    public void testLocalTransactionEvents() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph replicaGraph = client.getReplicaGraph(GRAPH_URI);
            URI r = Constants.valueFactory.createURI("urn:test");
            replicaGraph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));
            client.commit();

            final boolean[] status = new boolean[] { false };

            client.registerTransactionListener(new ITransactionListener() {

                public void transactionComplete(URI transactionURI, long transactionTimestamp, Set<URI> transactionGraphs, IDataset transactionContext) {
                    status[0] = true;
                }

                public void transactionFailed(URI transactionURI, Set<URI> transactionGraphs, IDataset transactionContext, List<AnzoException> errors) {
                }

            });

            client.updateRepository();
            assertTrue(replicaGraph.size() == 1);
            // verify that is there
            assertTrue(replicaGraph.contains(r, RDF.TYPE, RDF.ALT));

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return status[0];
                }
            });

        } finally {

            client.close();
        }
    }

    /**
     * Test transaction failed events
     * 
     * @throws Exception
     */
    public void testTransactionFailedEvents() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1, AnzoClient.GRAPH_MUST_EXIST);
            URI r = Constants.valueFactory.createURI("urn:test");
            replicaGraph.add(Constants.valueFactory.createStatement(r, RDF.TYPE, RDF.ALT));
            client.commit();

            client.begin();
            ClientGraph graph2 = client.getReplicaGraph(TestData.graph2);
            graph2.add(TestData.stmt1);
            client.commit();

            final boolean[] status = new boolean[] { false, false };

            client.registerTransactionListener(new ITransactionListener() {

                public void transactionComplete(URI transactionURI, long transactionTimestamp, Set<URI> transactionGraphs, IDataset transactionContext) {
                    status[1] = true;
                }

                public void transactionFailed(URI transactionURI, Set<URI> transactionGraphs, IDataset transactionContext, List<AnzoException> errors) {
                    status[0] = true;
                }

            });

            try {
                client.updateRepository();
            } catch (Exception e) {

            }

            assertTrue(replicaGraph.size() == 0);

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return status[0] && status[1];
                }
            });

            assertFalse(client.namedGraphExists(TestData.graph1));
            assertTrue(client.namedGraphExists(TestData.graph2));

        } finally {

            client.close();
        }
    }

    /**
     * Test replica persistence
     * 
     * @throws Exception
     */
    public void testPersistedReplica() throws Exception {
        AnzoClient client = new AnzoClient(getPersistedClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);

            replicaGraph.add(TestData.stmt1);
            client.updateRepository();
            assertTrue(replicaGraph.size() == 1);
            assertTrue(replicaGraph.contains(TestData.stmt1));
            client.close();

            Collection<Statement> stmts = client.replicaFind(null, null, null, TestData.graph1);

            client = new AnzoClient(getPersistedClientConfiguration());
            client.connect();

            stmts = client.replicaFind(null, null, null, TestData.graph1);
            assertFalse(stmts.isEmpty());

        } finally {

            client.close();
        }
    }

    /**
     * Test presisted transaction queue
     * 
     * @throws Exception
     */
    public void testPersistedTransactionQueueRemoval() throws Exception {
        AnzoClient client = new AnzoClient(getPersistedClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);
            replicaGraph.add(TestData.stmt1);
            client.commit();
            client.updateRepository();
            assertTrue(replicaGraph.size() == 1);
            assertTrue(replicaGraph.contains(TestData.stmt1));
            replicaGraph.close();
            client.close();

            client = new AnzoClient(getPersistedClientConfiguration());

            Collection<Statement> stmts = client.replicaFind(null, null, null, TestData.graph1);
            assertTrue(stmts.isEmpty());

        } finally {

            client.close();
        }
    }

    /**
     * Test persisted transaction queue
     * 
     * @throws Exception
     */
    public void testPersistedTransactionQueue() throws Exception {
        AnzoClient client = new AnzoClient(getPersistedClientConfiguration());
        client.connect();
        try {
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);
            replicaGraph.add(TestData.stmt1);
            assertTrue(replicaGraph.size() == 1);
            assertTrue(replicaGraph.contains(TestData.stmt1));
            client.commit();
            client.close();

            client = new AnzoClient(getPersistedClientConfiguration());

            Collection<Statement> stmts = client.replicaFind(null, null, null, TestData.graph1);
            assertFalse(stmts.isEmpty());

        } finally {

            client.close();
        }
    }

    /**
     * Test persisted graph table
     * 
     * @throws Exception
     */
    public void testPersistedGraphTable() throws Exception {
        AnzoClient client = new AnzoClient(getPersistedClientConfiguration());
        client.connect();
        try {
            Collection<Statement> stmts = null;
            client.reset(new ArrayList<Statement>(), null);
            client.begin();
            ClientGraph replicaGraph1 = client.getReplicaGraph(TestData.graph1);
            ClientGraph replicaGraph2 = client.getReplicaGraph(TestData.graph2);

            replicaGraph1.add(TestData.stmt1);
            replicaGraph2.add(TestData.stmt2);
            assertTrue(replicaGraph1.size() == 1);
            assertTrue(replicaGraph1.contains(TestData.stmt1));
            client.commit();

            client.close();

            //            stmts = client.replicaFind(null, null, null);
            //            for (Statement stmt : stmts) {
            //                System.err.println(stmt);
            //            }

            client = new AnzoClient(getPersistedClientConfiguration());
            client.connect();
            stmts = client.replicaFind(null, null, null, TestData.graph1);
            assertFalse(stmts.isEmpty());
            stmts = client.replicaFind(null, null, null, TestData.graph2);
            assertFalse(stmts.isEmpty());

            IDataset replicaGraphsDataset = client.getAllReplicaGraphsDataset();
            assertTrue(replicaGraphsDataset.getNamedGraphUris().contains(TestData.graph1));
            assertTrue(replicaGraphsDataset.getNamedGraphUris().contains(TestData.graph2));

            // get a replicaGraph so that it won't close on us when we close the client...
            replicaGraph1 = client.getReplicaGraph(TestData.graph1);

            client.close();

            client = new AnzoClient(getPersistedClientConfiguration());
            client.connect();
            stmts = client.replicaFind(null, null, null, TestData.graph1);
            assertFalse(stmts.isEmpty());
            stmts = client.replicaFind(null, null, null, TestData.graph2);
            // even though the graph has been removed, we may still have
            // its statements in the persisted queue.
            assertFalse(stmts.isEmpty());

            replicaGraphsDataset = client.getAllReplicaGraphsDataset();
            assertTrue(replicaGraphsDataset.getNamedGraphUris().contains(TestData.graph1));
            assertFalse(replicaGraphsDataset.getNamedGraphUris().contains(TestData.graph2));

        } finally {

            client.close();
        }
    }

    /**
     * Test server dataset events
     * 
     * @throws Exception
     */
    public void testServerDatasetEvents() throws Exception {

        AnzoClient client1 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client1.connect();
            client1.reset(new ArrayList<Statement>(), null);
            Set<URI> uris = new HashSet<URI>();
            uris.add(TestData.graph1);
            uris.add(TestData.graph2);
            IDataset dataset = client1.createServerDataset(true, TestData.graph3, null, uris);
            dataset.add(TestData.stmt1);
            dataset.add(TestData.stmt2);

            ClientGraph graph1 = client1.getReplicaGraph(TestData.graph1);
            assertTrue(graph1.contains(TestData.stmt1));
            client1.updateRepository();

            assertTrue(graph1.contains(TestData.stmt1));
            assertTrue(dataset.contains(TestData.stmt2));

            final boolean[] test = new boolean[1];
            test[0] = false;

            org.openanzo.ontologies.openanzo.Dataset ds = AnzoFactory.getDataset(TestData.graph3, dataset.getDatasetGraph());

            ds.registerListener(new DatasetListener() {

                public void namedGraphAdded(org.openanzo.ontologies.openanzo.Dataset source, NamedGraph newValue) {
                    test[0] = true;
                }

                public void namedGraphRemoved(org.openanzo.ontologies.openanzo.Dataset source, NamedGraph oldValue) {
                }

                public void defaultGraphAdded(org.openanzo.ontologies.openanzo.Dataset source, NamedGraph newValue) {
                }

                public void defaultGraphRemoved(org.openanzo.ontologies.openanzo.Dataset source, NamedGraph oldValue) {
                }

                public void defaultNamedGraphAdded(Dataset source, NamedGraph newValue) {
                }

                public void defaultNamedGraphRemoved(Dataset source, NamedGraph oldValue) {
                }

                public void includeMetadataGraphsChanged(Dataset source) {
                }
            });

            client1.begin();
            dataset.addNamedGraph(TestData.graph4);
            client1.commit();
            client1.updateRepository();

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return test[0];
                }
            });

            dataset.close();

        } finally {
            client1.close();
        }

    }

    /**
     * Test new and existing graphs in transaction
     * 
     * @throws Exception
     */
    public void testNewAndExistingGraphsInTransaction() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        AnzoClient client2 = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);
            client2.connect();

            client.begin();
            final ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);
            replicaGraph.add(TestData.stmt1);
            client.commit();
            client.updateRepository();

            // the key to this test is updating a new and existing graph in the same transaction
            client.begin();
            final ClientGraph replicaGraph2 = client.getReplicaGraph(TestData.graph2);
            replicaGraph2.add(TestData.stmt3);
            replicaGraph.add(TestData.stmt2);
            client.commit();
            client.updateRepository();

            assertTrue(replicaGraph2.contains(TestData.stmt3));

            final HashMap<URI, Integer> map = new HashMap<URI, Integer>();
            map.put(replicaGraph2.getNamedGraphUri(), 0);

            IStatementListener<INamedGraph> listener = new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    //System.err.println("Statements added: " + statements);
                    map.put(statements[0].getNamedGraphUri(), map.get(statements[0].getNamedGraphUri()) + statements.length);
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                }

            };

            replicaGraph2.registerListener(listener);

            client2.begin();
            ClientGraph serverGraph2 = client2.getServerGraph(TestData.graph2);
            serverGraph2.add(TestData.stmt5);
            assertTrue(serverGraph2.contains(TestData.stmt5));
            client2.commit();
            client2.updateRepository();
            assertTrue(serverGraph2.contains(TestData.stmt5));

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return (Integer.valueOf(1).equals(map.get(replicaGraph2.getNamedGraphUri())));
                }
            });
            assertTrue(replicaGraph2.contains(TestData.stmt5));
            assertEquals(Integer.valueOf(1), map.get(replicaGraph2.getNamedGraphUri()));

        } finally {

            client.close();
            client2.close();
        }
    }

    /**
     * Test new and exsiting server graphs in transaction
     * 
     * @throws Exception
     */
    public void testNewAndExistingServerGraphsInTransaction() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(new ArrayList<Statement>(), null);

            client.begin();
            final ClientGraph serverGraph = client.getServerGraph(TestData.graph1);
            serverGraph.add(TestData.stmt1);
            client.commit();
            client.updateRepository();

            // the key to this test is updating a new and existing graph in the same transaction
            client.begin();
            final ClientGraph serverGraph2 = client.getServerGraph(TestData.graph2);

            final HashMap<URI, Integer> map = new HashMap<URI, Integer>();
            map.put(serverGraph2.getNamedGraphUri(), 0);

            client.registerTransactionListener(new ITransactionListener() {
                public void transactionComplete(URI transactionURI, long transactionTimestamp, Set<URI> transactionGraphs, IDataset transactionContext) {
                    //System.err.println("Transaction completeD: " + transactionURI + " " + transactionGraphs);
                }

                public void transactionFailed(URI transactionURI, Set<URI> transactionGraphs, IDataset transactionContext, List<AnzoException> errors) {
                }
            });

            IStatementListener<INamedGraph> listener = new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    //System.err.println("Statements added: " + statements[0]);
                    map.put(statements[0].getNamedGraphUri(), map.get(statements[0].getNamedGraphUri()) + statements.length);
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                }

            };

            serverGraph2.registerListener(listener);

            serverGraph2.add(TestData.stmt3);
            serverGraph.add(TestData.stmt2);
            client.commit();
            client.updateRepository();

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return (Integer.valueOf(1).equals(map.get(serverGraph2.getNamedGraphUri())));
                }
            });

        } finally {

            client.close();
        }
    }

    /**
     * This test makes sure that if we have a replica and a server graph for a URI, then closing one doesn't prevent the other from receiving events, or
     * continuing to exist.
     * 
     * @throws Exception
     */
    public void testClosingServerOrReplicaGraph() throws Exception {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.clear();
            client.reset(new ArrayList<Statement>(), null);
            client.clear();

            final ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);
            client.updateRepository();

            final HashMap<URI, Integer> map = new HashMap<URI, Integer>();
            map.put(replicaGraph.getNamedGraphUri(), 0);
            map.put(replicaGraph.getMetadataGraph().getNamedGraphUri(), 0);

            IStatementListener<INamedGraph> listener = new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    map.put(statements[0].getNamedGraphUri(), map.get(statements[0].getNamedGraphUri()) + statements.length);
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                }

            };

            replicaGraph.registerListener(listener);
            replicaGraph.getMetadataGraph().registerListener(listener);

            assertFalse(replicaGraph.contains(TestData.stmt1));

            client.begin();
            replicaGraph.add(TestData.stmt1);
            assertTrue(replicaGraph.contains(TestData.stmt1));
            client.commit();

            client.updateRepository();

            ClientGraph serverGraph = client.getServerGraph(TestData.graph1);
            serverGraph.close();

            assertTrue(replicaGraph.contains(TestData.stmt1));

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return (Integer.valueOf(1).equals(map.get(replicaGraph.getNamedGraphUri())));
                }
            });
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return (Integer.valueOf(2).equals(map.get(replicaGraph.getMetadataGraph().getNamedGraphUri())));
                }
            });
            assertEquals(Integer.valueOf(1), map.get(replicaGraph.getNamedGraphUri()));
            assertEquals(Integer.valueOf(2), map.get(replicaGraph.getMetadataGraph().getNamedGraphUri()));

        } finally {
            client.close();
        }
    }

    static final URI testGraph = Constants.valueFactory.createURI("http://test/testGraph");

    static final URI ng1       = Constants.valueFactory.createURI("http://test/1");

    static final URI ng2       = Constants.valueFactory.createURI("http://test/2");

    static final URI ng3       = Constants.valueFactory.createURI("http://test/3");

    /**
     * Test reconnect replica graph test
     * 
     * @throws AnzoException
     */
    public void testConnectReconnectReplicaGraphTest() throws AnzoException {
        AnzoClient anzoClient = new AnzoClient(getDefaultClientConfiguration());
        try {
            Assert.assertNotNull(anzoClient);

            Assert.assertTrue(anzoClient.isConnected() == false);
            anzoClient.connect();
            Assert.assertTrue(anzoClient.isConnected() == true);

            anzoClient.updateRepository();

            ClientGraph graph = anzoClient.getReplicaGraph(testGraph);
            graph.clear();
            Assert.assertTrue(graph.getStatements().size() == 0);

            anzoClient.disconnect();
            Assert.assertTrue(anzoClient.isConnected() == false);
            Assert.assertTrue(graph.getStatements().size() == 0);

            Statement s = new org.openanzo.rdf.Statement(ng1, ng2, ng3);
            graph.add(s);
            Assert.assertTrue(graph.getStatements().size() == 1);

            try {
                anzoClient.updateRepository();
                Assert.assertTrue(false);
            } catch (Exception e) {
                Assert.assertTrue(true);
            }
            anzoClient.connect();

            Assert.assertTrue(anzoClient.isConnected() == true);
            Assert.assertTrue(graph.getStatements().size() == 1);

            anzoClient.updateRepository();

            anzoClient.disconnect();
            Assert.assertTrue(anzoClient.isConnected() == false);
            Assert.assertTrue(graph.getStatements().size() == 1);

            try {
                anzoClient.updateRepository();
                Assert.assertTrue(false);
            } catch (Exception e) {
                Assert.assertTrue(true);
            }

            graph.clear();
            Assert.assertTrue(graph.getStatements().size() == 0);

            anzoClient.connect();
            Assert.assertTrue(anzoClient.isConnected() == true);

            try {
                anzoClient.updateRepository();
            } catch (Exception e) {
                Assert.assertTrue(false);
            }

            Assert.assertTrue(graph.getStatements().size() == 0);
            anzoClient.disconnect();

            /** Is it neccessary to close the graph before closing the AnzoClient? */
            graph.close();
            anzoClient.close();
        } finally {
            anzoClient.close();
        }
    }

    /**
     * The interesting thing here is that there is a difference in the behavior of the replicaGraph and the serverGraph. The serverGraph here throws an
     * exception that "ErrorCode[16:16399] [COMBUS_ERROR] Already connected to notification service" . The replicaGraph above throws only a silent exception.
     * 
     * @throws AnzoException
     */
    public void testConnectReconnectServerGraphTest() throws AnzoException {
        AnzoClient anzoClient = new AnzoClient(getDefaultClientConfiguration());
        try {

            Assert.assertNotNull(anzoClient);

            Assert.assertTrue(anzoClient.isConnected() == false);
            anzoClient.connect();
            Assert.assertTrue(anzoClient.isConnected() == true);

            anzoClient.updateRepository();

            ClientGraph graph = anzoClient.getServerGraph(testGraph);
            graph.clear();
            Assert.assertTrue(graph.getStatements().size() == 0);

            anzoClient.disconnect();
            Assert.assertTrue(anzoClient.isConnected() == false);
            try {
                Assert.assertTrue(graph.getStatements().size() == 0);
            } catch (Exception e) {
                Assert.assertTrue(true);
            }

            Statement s = new org.openanzo.rdf.Statement(ng1, ng2, ng3);
            try {
                graph.add(s);
            } catch (Exception e) {
                Assert.assertTrue(true);
            }
            try {
                anzoClient.updateRepository();
                Assert.assertTrue(false);
            } catch (Exception e) {
                Assert.assertTrue(true);
            }
            anzoClient.connect();

            Assert.assertTrue(anzoClient.isConnected() == true);
            Assert.assertTrue(graph.getStatements().size() == 0);

            anzoClient.updateRepository();

            anzoClient.disconnect();
            Assert.assertTrue(anzoClient.isConnected() == false);
            try {
                Assert.assertTrue(graph.getStatements().size() == 1);
            } catch (Exception e) {
                Assert.assertTrue(true);
            }

            try {
                anzoClient.updateRepository();
                Assert.assertTrue(false);
            } catch (Exception e) {
                Assert.assertTrue(true);
            }

            try {
                graph.clear();
                Assert.assertTrue(false);
            } catch (Exception e) {
                Assert.assertTrue(true);
            }

            try {
                Assert.assertTrue(graph.getStatements().size() == 0);
            } catch (Exception e) {
                Assert.assertTrue(true);
            }

            anzoClient.connect();
            Assert.assertTrue(anzoClient.isConnected() == true);

            try {
                anzoClient.updateRepository();
            } catch (Exception e) {
                Assert.assertTrue(false);
            }

            Assert.assertTrue(graph.getStatements().size() == 0);
            anzoClient.disconnect();

            /** Is it neccessary to close the graph before closing the AnzoClient? */
            graph.close();
            anzoClient.close();
        } finally {
            anzoClient.close();
        }
    }

    /**
     * Test server query testing
     * 
     * @throws Exception
     */
    public void testServerQueryCaching() throws Exception {
        AnzoClient client = null;
        client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        client.reset(new ArrayList<Statement>(), null);
        client.close();

        Properties props = getSystemClientConfiguration();
        HashMap<String, String> creds = new HashMap<String, String>();
        creds.put("sysadmin", "123");
        String host = CombusProperties.getHost(props);
        int port = CombusProperties.getPort(props);
        boolean useSsl = CombusProperties.getUseSsl(props);
        PlaybackHandler handler = new PlaybackHandler(0, creds, host, port, useSsl, null, null, null, null);

        String body = "PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> SELECT ?o WHERE { <http://openanzo.org/semanticServices/echoService> rdf:type ?o . }";
        String user = "sysadmin";
        String runAsUser = "sysadmin";
        String dest = "services/query";
        HashMap<String, String> reqProps = new HashMap<String, String>();
        reqProps.put("requestAnalysisEnabled", "true");
        reqProps.put("defaultNamedGraphs", "http://openanzo.org/semanticServices/echoService");
        reqProps.put("defaultNamedGraphsFormat", "text/plain");
        reqProps.put("namedGraphsFormat", "text/plain");
        reqProps.put("resultFormat", "application/sparql-results+xml");
        reqProps.put("operation", "query");
        TextMessage response = (TextMessage) handler.handleRequest(body, reqProps, user, runAsUser, dest, "simpleQuery-1");
        assertFalse(response.getBooleanProperty("ans_cacheHit"));
        response = (TextMessage) handler.handleRequest(body, reqProps, user, runAsUser, dest, "simpleQuery-2");
        assertTrue(response.getBooleanProperty("ans_cacheHit"));

        reqProps.put(OPTIONS.SKIPCACHE, Boolean.TRUE.toString());
        response = (TextMessage) handler.handleRequest(body, reqProps, user, runAsUser, dest, "simpleQuery-3");
        assertFalse(response.getBooleanProperty("ans_cacheHit"));
        response = (TextMessage) handler.handleRequest(body, reqProps, user, runAsUser, dest, "simpleQuery-4");
        assertFalse(response.getBooleanProperty("ans_cacheHit"));
        reqProps.put(OPTIONS.SKIPCACHE, Boolean.FALSE.toString());
        response = (TextMessage) handler.handleRequest(body, reqProps, user, runAsUser, dest, "simpleQuery-5");
        assertTrue(response.getBooleanProperty("ans_cacheHit"));

    }

}
