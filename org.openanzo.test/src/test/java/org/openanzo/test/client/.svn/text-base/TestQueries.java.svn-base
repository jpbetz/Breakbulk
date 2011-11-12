/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/client/TestQueries.java,v $
 * Created by:  Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * Created on:  9/25/2006
 * Revision:	$Id: TestQueries.java 229 2007-08-07 15:22:00Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.query.QueryEncoder;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.test.AbstractTest;

/**
 * Test executing queries against the server.
 * 
 * @author Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * 
 */
public class TestQueries extends AbstractTest {
    final static URI GRAPH3_URI = Constants.valueFactory.createURI("http://graph3");

    final static URI GRAPH2_URI = Constants.valueFactory.createURI("http://graph2");

    final static URI GRAPH_URI  = Constants.valueFactory.createURI("http://graph1");

    final static URI NAME1      = Constants.valueFactory.createURI("http://graph1");

    final static URI NAME2      = Constants.valueFactory.createURI("http://graph2");

    final static URI NAME3      = Constants.valueFactory.createURI("http://graph3");

    /**
     * Test querying a graph which has had a statement added and then removed.
     * 
     * @throws Exception
     */
    public void testQueryingARemovedStatement() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
        AnzoClient anzoClient = new AnzoClient(getDefaultClientConfiguration());
        anzoClient.connect();
        try {
            anzoClient.reset(loadStatements("initialize.trig"), null);
            IAnzoGraph serverGraph = anzoClient.getServerGraph(GRAPH_URI);
            serverGraph.add(stmt1);
            assertTrue(serverGraph.contains(stmt1));
            anzoClient.updateRepository();
            serverGraph.remove(stmt1);
            anzoClient.updateRepository();
            assertFalse(serverGraph.contains(stmt1));
            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
            HashSet<URI> defaultGraphs = new HashSet<URI>();
            defaultGraphs.add(GRAPH_URI);
            QueryResults results = anzoClient.serverQuery(defaultGraphs, Collections.<URI> emptySet(), null, query, null);
            int i = 0;
            assertTrue(results.isSelectResult());
            Iterator<PatternSolution> result = results.getSelectResults().iterator();
            while (result.hasNext()) {
                result.next();
                i++;
            }
            assertTrue(i == 0);
        } finally {
            anzoClient.close();
        }
    }

    /**
     * Test query string with escape chars
     * 
     * @throws Throwable
     */
    public void testEscapeCharQuery() throws Throwable {
        AnzoClient anzoClient = new AnzoClient(getDefaultClientConfiguration());
        anzoClient.connect();
        try {
            anzoClient.reset(loadStatements("initialize.trig"), null);
            IAnzoGraph replicaGraph = anzoClient.getReplicaGraph(NAME1);
            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), (createTestUri("object1")));
            String[] literalStrings = new String[] {
            // characters that must be escaped
                    // "backspace:\b",
                    "tab:\t", "linefeed:\n", "carriage return:\r", "double quote:\"", "single quote:\'", "backslash:\\",
                    // "unicode:\u1234",
                    // characters that dont require escaping
                    "form feed:\f",
                    // strings that might require special attention
                    "<xml>look alike</xml>", "<!-- -->", "!@#$%^&*()-_=+`~/?.>,<;:[{]}|",
                    // long literal test
                    "this is a really long string that might potentially be problematic simple due to its large number of " + "characters.  Because this one time at band camp, there is was really long literal string and it broke" + "a bunch of stuff just because it was so really long and we want to be extra careful to handle long strings +" + "correctly and stuff" };
            // this concatinates all the test strings together into one long string
            // comment this out for debugging
            String concatinated = "";
            for (int i = 0; i < literalStrings.length; i++) {
                concatinated += literalStrings[i];
            }
            literalStrings = new String[] { concatinated };
            // create literals for each test string
            Literal[] literals = new Literal[literalStrings.length];
            for (int i = 0; i < literalStrings.length; i++) {
                literals[i] = Constants.valueFactory.createLiteral(literalStrings[i]);
            }
            // for each literal try to add it to both a memory and local graph and query for it
            // using both a string query and a programatically created query
            for (int i = 0; i < literals.length; i++) {
                Statement stmt = Constants.valueFactory.createStatement(stmt1.getSubject(), stmt1.getPredicate(), literals[i]);
                replicaGraph.add(stmt);
                assertTrue(replicaGraph.contains(stmt));
                anzoClient.updateRepository();
                String queryString = "SELECT ?s where {?s <" + stmt1.getPredicate() + "> \"" + QueryEncoder.encodeForQuery(literals[i].getLabel()) + "\"}";
                QueryResults results = anzoClient.serverQuery(Collections.singleton(NAME1), null, null, queryString, null);
                int k = 0;
                assertTrue(results.isSelectResult());

                {
                    Iterator<PatternSolution> result = results.getSelectResults().iterator();

                    while (result.hasNext()) {
                        PatternSolution solution = result.next();
                        assertTrue(solution.getBinding("s") instanceof Resource);
                        k++;
                    }
                }
                assertEquals(1, k);
                results = anzoClient.serverQuery(Collections.singleton(NAME1), Collections.<URI> emptySet(), null, queryString, null);
                int l = 0;
                assertTrue(results.isSelectResult());

                {
                    Iterator<PatternSolution> result = results.getSelectResults().iterator();
                    while (result.hasNext()) {
                        PatternSolution solution = result.next();
                        assertTrue(solution.getBinding("s") instanceof Resource);
                        l++;
                    }
                }
                assertEquals(1, l);
            }
        } finally {
            anzoClient.close();
        }
    }

    /**
     * Test querying metadata
     * 
     * @throws Exception
     */
    public void testQueryingMetadata() throws Exception {
        AnzoClient anzoClient = null;
        try {
            anzoClient = new AnzoClient(getSystemClientConfiguration());
            anzoClient.connect();
            anzoClient.reset(loadStatements("initialize.trig"), null);
            int numGraphs = 1;
            IAnzoGraph serverSystemGraph = anzoClient.getServerGraph(GRAPHS.DEFAULT_SYSTEMGRAPH);
            assertNotNull(serverSystemGraph);
            anzoClient.begin();
            for (int i = 0; i < numGraphs; i++) {
                anzoClient.getServerGraph(Constants.valueFactory.createURI("http://model" + i));
            }
            anzoClient.commit();
            anzoClient.updateRepository();
            try {
                StringBuilder query = new StringBuilder();
                query.append("SELECT ?g ?revision ?createdBy WHERE {");
                query.append(" ?g " + QueryEncoder.encodeForQuery(NamedGraph.revisionProperty) + "  ?revision . ");
                query.append(" ?g " + QueryEncoder.encodeForQuery(NamedGraph.createdByProperty) + " ?createdBy . ");
                query.append(" ?g " + QueryEncoder.encodeForQuery(RDF.TYPE) + " " + QueryEncoder.encodeForQuery(NamedGraph.TYPE) + "} ");
                Set<URI> graphSet = Collections.singleton(GRAPHS.ALL_METADATAGRAPHS);
                QueryResults results = anzoClient.serverQuery(graphSet, graphSet, null, query.toString(), null);
                assertTrue(results.isSelectResult());
                int count = 0;
                Iterator<PatternSolution> result = results.getSelectResults().iterator();
                while (result.hasNext()) {
                    PatternSolution solution = result.next();
                    solution.getBinding("revision");
                    solution.getBinding("g");
                    solution.getBinding("createdBy");
                    count++;

                }
                // incremented to account for echo service graphs
                //assertEquals(numGraphs + 2/*+ 4*/, 3);
            } finally {
            }
            try {
                StringBuilder query = new StringBuilder();
                query.append("SELECT ?g ?revision ?createdBy WHERE {Graph ?g2 {");
                query.append(" ?g " + QueryEncoder.encodeForQuery(NamedGraph.revisionProperty) + " ?revision . ");
                query.append(" ?g " + QueryEncoder.encodeForQuery(NamedGraph.createdByProperty) + " ?createdBy . ");
                query.append(" ?g " + QueryEncoder.encodeForQuery(RDF.TYPE) + " " + QueryEncoder.encodeForQuery(NamedGraph.TYPE) + "}} ");
                Set<URI> graphSet = Collections.singleton(GRAPHS.ALL_METADATAGRAPHS);
                QueryResults results = anzoClient.serverQuery(graphSet, graphSet, null, query.toString(), null);
                assertTrue(results.isSelectResult());
                int count = 0;
                Iterator<PatternSolution> result = results.getSelectResults().iterator();
                while (result.hasNext()) {
                    PatternSolution solution = result.next();
                    solution.getBinding("revision");
                    solution.getBinding("g");
                    count++;
                }
                // incremented to account for echo service graphs
                //assertEquals(numGraphs + 7, count);
            } finally {
            }
        } finally {
            if (anzoClient != null)
                anzoClient.close();
        }
    }

    /**
     * Test server graph find with escape chars
     * 
     * @throws Throwable
     */
    public void testEscapeCharFind() throws Throwable {
        AnzoClient anzoClient = new AnzoClient(getDefaultClientConfiguration());
        anzoClient.connect();
        try {
            anzoClient.reset(loadStatements("initialize.trig"), null);
            IAnzoGraph serverGraph = anzoClient.getServerGraph(NAME1);
            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), (createTestUri("object1")));
            String[] literalStrings = new String[] {
            // characters that must be escaped
                    // "backspace:\b",
                    "tab:\t", "linefeed:\n", "carriage return:\r", "double quote:\"", "single quote:\'", "backslash:\\",
                    // "unicode:\u1234",
                    // characters that dont require escaping
                    "form feed:\f",
                    // strings that might require special attention
                    "<xml>look alike</xml>", "<!-- -->", "!@#$%^&*()-_=+`~/?.>,<;:[{]}|",
                    // long literal test
                    "this is a really long string that might potentially be problematic simple due to its large number of " + "characters.  Because this one time at band camp, there is was really long literal string and it broke" + "a bunch of stuff just because it was so really long and we want to be extra careful to handle long strings +" + "correctly and stuff" };
            // this concatinates all the test strings together into one long string
            // comment this out for debugging
            String concatinated = "";
            for (int i = 0; i < literalStrings.length; i++) {
                concatinated += literalStrings[i];
            }
            literalStrings = new String[] { concatinated };
            // create literals for each test string
            Literal[] literals = new Literal[literalStrings.length];
            for (int i = 0; i < literalStrings.length; i++) {
                literals[i] = Constants.valueFactory.createLiteral(literalStrings[i]);
            }
            // for each literal try to add it to both a memory and jena model and query for it
            // using both a string query and a programatically created query
            for (int i = 0; i < literals.length; i++) {
                Statement stmt = Constants.valueFactory.createStatement(stmt1.getSubject(), stmt1.getPredicate(), literals[i]);
                serverGraph.add(stmt);
                anzoClient.updateRepository();
                assertTrue(serverGraph.contains(stmt));
                Iterator<Statement> ei = serverGraph.find(stmt1.getSubject(), stmt.getPredicate(), stmt.getObject()).iterator();
                int k = 0;
                while (ei.hasNext()) {
                    ei.next();
                    k++;
                }
                assertEquals(1, k);
            }
        } finally {
            anzoClient.close();
        }
    }

    /**
     * Test adding the same statements to multiple server graphs and running a SPARQL query.
     * 
     * @throws Exception
     */
    public void testAddingSameStatementsToMultipleServerGraphsAndQuery() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
        final Statement stmt2 = Constants.valueFactory.createStatement((createTestUri("subject2")), createTestUri("predicate2"), (createTestUri("object2")));
        final Statement stmt3 = Constants.valueFactory.createStatement((createTestUri("subject3")), createTestUri("predicate3"), (createTestUri("object3")));
        final Statement stmt4 = Constants.valueFactory.createStatement((createTestUri("subject4")), createTestUri("predicate4"), (createTestUri("object4")));

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph serverGraph1 = client.getServerGraph(NAME1);
            ClientGraph serverGraph12 = client.getServerGraph(NAME1);
            ClientGraph serverGraph2 = client.getServerGraph(NAME2);
            ClientGraph serverGraph22 = client.getServerGraph(NAME2);
            ClientGraph serverGraph3 = client.getServerGraph(NAME3);
            ClientGraph serverGraph32 = client.getServerGraph(NAME3);
            serverGraph1.add(stmt1);
            serverGraph1.add(stmt2);
            serverGraph1.add(stmt3);
            serverGraph1.add(stmt4);
            assertTrue(serverGraph1.contains(stmt1));
            assertTrue(serverGraph12.contains(stmt1));
            assertFalse(serverGraph2.contains(stmt1));
            assertFalse(serverGraph22.contains(stmt1));
            assertFalse(serverGraph3.contains(stmt1));
            assertFalse(serverGraph32.contains(stmt1));
            client.updateRepository();
            serverGraph2.add(stmt1);
            serverGraph2.add(stmt2);
            serverGraph2.add(stmt3);
            serverGraph2.add(stmt4);
            assertTrue(serverGraph1.contains(stmt1));
            assertTrue(serverGraph12.contains(stmt1));
            assertTrue(serverGraph2.contains(stmt1));
            assertTrue(serverGraph22.contains(stmt1));
            assertFalse(serverGraph3.contains(stmt1));
            assertFalse(serverGraph32.contains(stmt1));
            serverGraph3.add(stmt1);
            serverGraph3.add(stmt2);
            serverGraph3.add(stmt3);
            serverGraph3.add(stmt4);
            assertTrue(serverGraph1.contains(stmt1));
            assertTrue(serverGraph12.contains(stmt1));
            assertTrue(serverGraph2.contains(stmt1));
            assertTrue(serverGraph22.contains(stmt1));
            assertTrue(serverGraph3.contains(stmt1));
            assertTrue(serverGraph32.contains(stmt1));
            client.updateRepository();
            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
            QueryResults results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
            int i = 0;
            assertTrue(results.isSelectResult());
            Iterator<PatternSolution> result = results.getSelectResults().iterator();
            while (result.hasNext()) {
                result.next();
                i++;
            }
            assertEquals(4, i);
            client.updateRepository();
        } finally {
            client.close();
        }
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
            QueryResults results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
            int i = 0;
            assertTrue(results.isSelectResult());
            Iterator<PatternSolution> result = results.getSelectResults().iterator();
            while (result.hasNext()) {
                result.next();
                i++;
            }
            assertEquals(4, i);
        } finally {
            client.close();
        }
    }

    /**
     * Test adding the same statements to multiple replica graphs and running a SPARQL query.
     * 
     * @throws Exception
     */
    public void testAddingSameStatementsToMultipleReplicaGraphsAndQuery() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
        final Statement stmt2 = Constants.valueFactory.createStatement((createTestUri("subject2")), createTestUri("predicate2"), (createTestUri("object2")));
        final Statement stmt3 = Constants.valueFactory.createStatement((createTestUri("subject3")), createTestUri("predicate3"), (createTestUri("object3")));
        final Statement stmt4 = Constants.valueFactory.createStatement((createTestUri("subject4")), createTestUri("predicate4"), (createTestUri("object4")));
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph replicaGraph1 = client.getReplicaGraph(NAME1);
            ClientGraph replicaGraph12 = client.getReplicaGraph(NAME1);
            ClientGraph replicaGraph2 = client.getReplicaGraph(NAME2);
            ClientGraph replicaGraph22 = client.getReplicaGraph(NAME2);
            ClientGraph replicaGraph3 = client.getReplicaGraph(NAME3);
            ClientGraph replicaGraph32 = client.getReplicaGraph(NAME3);
            replicaGraph1.add(stmt1);
            replicaGraph1.add(stmt2);
            replicaGraph1.add(stmt3);
            replicaGraph1.add(stmt4);
            assertTrue(replicaGraph1.contains(stmt1));
            assertTrue(replicaGraph12.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph22.contains(stmt1));
            assertFalse(replicaGraph3.contains(stmt1));
            assertFalse(replicaGraph32.contains(stmt1));
            client.updateRepository();
            replicaGraph2.add(stmt1);
            replicaGraph2.add(stmt2);
            replicaGraph2.add(stmt3);
            replicaGraph2.add(stmt4);
            assertTrue(replicaGraph1.contains(stmt1));
            assertTrue(replicaGraph12.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph22.contains(stmt1));
            assertFalse(replicaGraph3.contains(stmt1));
            assertFalse(replicaGraph32.contains(stmt1));
            replicaGraph3.add(stmt1);
            replicaGraph3.add(stmt2);
            replicaGraph3.add(stmt3);
            replicaGraph3.add(stmt4);
            assertTrue(replicaGraph1.contains(stmt1));
            assertTrue(replicaGraph12.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph22.contains(stmt1));
            assertTrue(replicaGraph3.contains(stmt1));
            assertTrue(replicaGraph32.contains(stmt1));
            client.updateRepository();
            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
            QueryResults results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
            int i = 0;
            assertTrue(results.isSelectResult());
            Iterator<PatternSolution> result = results.getSelectResults().iterator();
            while (result.hasNext()) {
                result.next();
                i++;
            }
            assertEquals(4, i);
        } finally {
            client.close();
        }
    }

    /**
     * Tests that the QueryResults object returns the proper number of binding names.
     * 
     * @throws Exception
     */
    public void testQueryResultsObject() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
        AnzoClient anzoClient = new AnzoClient(getDefaultClientConfiguration());
        anzoClient.connect();
        try {
            anzoClient.reset(loadStatements("initialize.trig"), null);
            IAnzoGraph serverGraph = anzoClient.getServerGraph(GRAPH_URI);
            serverGraph.add(stmt1);
            anzoClient.updateRepository();
            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
            HashSet<URI> defaultGraphs = new HashSet<URI>();
            defaultGraphs.add(GRAPH_URI);
            QueryResults results = anzoClient.serverQuery(defaultGraphs, Collections.<URI> emptySet(), null, query, null);
            assertEquals(3, results.getSelectResults().getBindingNames().size());
        } finally {
            anzoClient.close();
        }
    }

    /**
     * Tests that the QueryResults object returns the proper number of binding names.
     * 
     * @throws Exception
     */
    public void testNamedDatasetCache() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
        AnzoClient anzoClient = new AnzoClient(getDefaultClientConfiguration());
        anzoClient.connect();
        try {
            anzoClient.reset(loadStatements("initialize.trig"), null);
            IAnzoGraph serverGraph2 = anzoClient.getServerGraph(GRAPH2_URI);
            Dataset ds = AnzoFactory.createDataset(GRAPH2_URI, serverGraph2);
            ds.addDefaultGraph(GRAPH3_URI);
            anzoClient.updateRepository();

            String query = "SELECT ?s ?p ?o  WHERE { ?s ?p ?o }";
            HashSet<URI> namedDatasets = new HashSet<URI>();
            namedDatasets.add(GRAPH2_URI);
            QueryResults results = anzoClient.serverQuery(Collections.<URI> emptySet(), Collections.<URI> emptySet(), namedDatasets, query, null);
            assertEquals(0, results.getSelectResults().size());

            IAnzoGraph serverGraph = anzoClient.getServerGraph(GRAPH_URI);
            serverGraph.add(stmt1);
            ds.addDefaultGraph(GRAPH_URI);
            anzoClient.updateRepository();
            results = anzoClient.serverQuery(Collections.<URI> emptySet(), Collections.<URI> emptySet(), namedDatasets, query, null);
            assertEquals(1, results.getSelectResults().size());
        } finally {
            anzoClient.close();
        }
    }

    /**
     * Test server queries on changing graph
     * 
     * @throws Exception
     */
    public void testServerGraphGraphInQuery() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://sean"), Constants.valueFactory.createURI("http://xmlns.com/foaf/0.1/givenname"), Constants.valueFactory.createLiteral("Sean"));
        final Statement stmt2 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://sean"), Constants.valueFactory.createURI("http://xmlns.com/foaf/0.1/givenname"), Constants.valueFactory.createLiteral("NotSean"));

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph serverGraph1 = client.getServerGraph(Constants.valueFactory.createURI("http://foafgraph1"));
            serverGraph1.add(stmt1);
            client.updateRepository();
            assertTrue(serverGraph1.contains(stmt1));
            assertFalse(serverGraph1.contains(stmt2));

            String query = "SELECT ?fname ?g\n";
            query += "WHERE {\n";
            query += "       GRAPH ?g {\n";
            query += "         ?resource <http://xmlns.com/foaf/0.1/givenname> ?fname  . \n";
            query += "   }\n";
            query += "}\n";

            QueryResults results = client.serverQuery(Collections.<URI> emptySet(), Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);

            assertEquals(1, results.getSelectResults().size());

            serverGraph1.remove(stmt1);

            client.updateRepository();
            assertFalse(serverGraph1.contains(stmt1));
            assertFalse(serverGraph1.contains(stmt2));

            results = client.serverQuery(Collections.<URI> emptySet(), Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
            assertEquals(0, results.getSelectResults().size());

            serverGraph1.add(stmt2);
            client.updateRepository();
            assertFalse(serverGraph1.contains(stmt1));
            assertTrue(serverGraph1.contains(stmt2));

            results = client.serverQuery(Collections.<URI> emptySet(), Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);

            assertEquals(1, results.getSelectResults().size());

        } finally {
            client.close();
        }
    }
}
