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

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.test.AbstractTest;

/**
 * This test is designed to validate the public dataset API of <code>AnzoClient</code>.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class TestDatasets extends AbstractTest {
    final URI        GRAPH_URI        = Constants.valueFactory.createURI("http://graph1");

    final static URI NAME1            = Constants.valueFactory.createURI("http://graph1");

    final static URI NAME2            = Constants.valueFactory.createURI("http://graph2");

    final URI        replicaGraph1URI = createTestUri("graph-local-1");

    final URI        replicaGraph2URI = createTestUri("graph-local-2");

    final URI        serverGraph1URI  = createTestUri("graph-remote-1");

    final URI        serverGraph2URI  = createTestUri("graph-remote-2");

    /**
     * Test:
     * <UL>
     * <LI>AnzoClient.creatReplicaDataset(...)
     * <LI>AnzoClient.createServerDataset(...)
     * </UL>
     * 
     * @throws Exception
     * 
     */
    public void testCreateReplicaAndServerDatasets() throws Exception {
        AnzoClient anzoClient1 = null, anzoClient2 = null;
        URI datasetUri = Constants.valueFactory.createURI("http://graphnames");
        int numberOfGraphs = 20;
        try {
            int i = 0;
            Set<URI> names = new HashSet<URI>();

            anzoClient1 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);
            anzoClient2 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient2.connect();

            // -------------------------------------------------------------------------
            // test creating named graphs, then getting them using createReplicaDataset method
            // on two clients

            names.clear();
            for (i = 0; i < numberOfGraphs; i++) {
                names.add(Constants.valueFactory.createURI("http://graphname" + i));
            }

            for (Iterator<URI> iter = names.iterator(); iter.hasNext();) {
                i++;
                ClientGraph m = anzoClient1.getReplicaGraph(iter.next());
                Statement stmt = Constants.valueFactory.createStatement((createTestUri("subject" + i)), createTestUri("predicate" + i), (createTestUri("object" + 1)));
                m.add(stmt);
            }
            anzoClient1.updateRepository();
            //Thread.sleep(300);

            IDataset replicaDataset1 = anzoClient1.createReplicaDataset(false, datasetUri, Collections.<URI> emptySet(), names);
            IDataset replicaDataset2 = anzoClient2.createReplicaDataset(false, datasetUri, Collections.<URI> emptySet(), names);

            for (Iterator<URI> iter = names.iterator(); iter.hasNext();) {
                URI name = iter.next();
                assertTrue(replicaDataset1.containsNamedGraph(name));
                assertTrue(replicaDataset2.containsNamedGraph(name));
            }

            for (URI uri : replicaDataset1.getNamedGraphUris()) {
                assertTrue(replicaDataset2.containsNamedGraph(uri));
            }
            ClientGraph replicaGraph1 = anzoClient1.getReplicaGraph(replicaGraph1URI);
            ClientGraph replicaGraph2 = anzoClient2.getReplicaGraph(replicaGraph2URI);

            replicaDataset1.addNamedGraph(replicaGraph1URI);
            replicaDataset1.containsNamedGraph(replicaGraph1URI);
            assertEquals(replicaDataset1.getNamedGraph(replicaGraph1URI), replicaGraph1);

            replicaDataset2.addNamedGraph(replicaGraph2URI);
            replicaDataset2.containsNamedGraph(replicaGraph2URI);
            assertEquals(replicaDataset2.getNamedGraph(replicaGraph2URI), replicaGraph2);

            replicaDataset1.addNamedGraph(Constants.valueFactory.createURI("http://foo"));

            // -------------------------------------------------------------------------
            // test creating named graphs using the createReplicaDataset method

            names.clear();
            for (i = 0; i < numberOfGraphs; i++) {
                names.add(Constants.valueFactory.createURI("http://graphname2" + i));
            }

            IDataset replicaDataset3 = anzoClient1.createReplicaDataset(false, datasetUri, Collections.<URI> emptySet(), names);
            anzoClient1.updateRepository();
            //	Thread.sleep(300);

            assertNotNull(anzoClient2.getReplicaGraph(names.iterator().next()));

            IDataset replicaDataset4 = anzoClient2.createReplicaDataset(false, datasetUri, Collections.<URI> emptySet(), names);
            for (URI uri : replicaDataset3.getNamedGraphUris()) {
                assertTrue(replicaDataset4.containsNamedGraph(uri));
            }

            // --------------------------------------------------------------------------
            // test creating named graphs, then getting them using createServerDataset method
            // on two clients

            names.clear();
            for (i = 0; i < numberOfGraphs; i++) {
                names.add(Constants.valueFactory.createURI("http://graphname" + i));
            }

            //anzoClient1.begin();

            for (Iterator<URI> iter = names.iterator(); iter.hasNext();) {
                i++;
                ClientGraph m = anzoClient1.getServerGraph(iter.next());
                Statement stmt = Constants.valueFactory.createStatement((createTestUri("subject" + i)), createTestUri("predicate" + i), (createTestUri("object" + 1)));
                m.add(stmt);
            }
            //anzoClient1.commit();
            anzoClient1.updateRepository();
            //Thread.sleep(300);

            IDataset serverDataset1 = anzoClient1.createServerDataset(false, datasetUri, Collections.<URI> emptySet(), names);
            IDataset serverDataset2 = anzoClient2.createServerDataset(false, datasetUri, Collections.<URI> emptySet(), names);

            for (Iterator<URI> iter = names.iterator(); iter.hasNext();) {
                URI name = iter.next();
                assertTrue(serverDataset1.containsNamedGraph(name));
                assertTrue(serverDataset2.containsNamedGraph(name));
            }

            for (URI uri : serverDataset1.getNamedGraphUris()) {
                assertTrue(serverDataset2.containsNamedGraph(uri));
            }

            ClientGraph serverGraph1 = anzoClient1.getServerGraph(serverGraph1URI);
            ClientGraph serverGraph2 = anzoClient2.getServerGraph(serverGraph2URI);

            serverDataset1.addNamedGraph(serverGraph1URI);
            serverDataset1.containsNamedGraph(serverGraph1URI);
            assertEquals(serverDataset1.getNamedGraph(serverGraph1URI).getNamedGraphUri(), serverGraph1.getNamedGraphUri());

            serverDataset2.addNamedGraph(serverGraph2URI);
            serverDataset2.containsNamedGraph(serverGraph2URI);
            assertEquals(serverDataset2.getNamedGraph(serverGraph2URI).getNamedGraphUri(), serverGraph2.getNamedGraphUri());

            // --------------------------------------------------------------------------
            // test creating named graphs using the createServerDataset method

            names.clear();
            for (i = 0; i < numberOfGraphs; i++) {
                names.add(Constants.valueFactory.createURI("http://graphname2" + i));
            }

            IDataset serverDataset3 = anzoClient1.createServerDataset(false, datasetUri, Collections.<URI> emptySet(), names);
            anzoClient1.updateRepository();
            //Thread.sleep(300);

            assertNotNull(anzoClient2.getServerGraph(names.iterator().next()));

            IDataset serverDataset4 = anzoClient1.createServerDataset(false, datasetUri, Collections.<URI> emptySet(), names);
            for (URI uri : serverDataset3.getNamedGraphUris()) {
                assertTrue(serverDataset4.containsNamedGraph(uri));
            }

        } finally {
            if (anzoClient1 != null)
                anzoClient1.close();
            if (anzoClient2 != null)
                anzoClient2.close();
        }

    }

    /**
     * This test validates our current assumptions of System Graphs: Currently no data is stored in system graphs, so they should always be empty.
     * 
     * @throws Exception
     */
    public void testCurrentStateOfSystemGraph() throws Exception {
        AnzoClient anzoClient1 = null;
        try {

            //
            // create DATASET SERVICE 1 (CLIENT 1)
            //
            anzoClient1 = new AnzoClient(getSystemClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);

            ClientGraph replicaGraph1 = anzoClient1.getReplicaGraph(GRAPH_URI);
            assertNotNull(replicaGraph1);

            ClientGraph serverGraph1 = anzoClient1.getServerGraph(GRAPH_URI);
            assertNotNull(serverGraph1);

            ClientGraph m = anzoClient1.getReplicaGraph(GRAPHS.DEFAULT_SYSTEMGRAPH);

            // NOTE: If this breaks, that just means there is data in the system graph...it is not
            // an error, just a change in the status of server (as right now the system graph never
            // has anything in it).
            assertEquals(1, m.size());

        } finally {
            if (anzoClient1 != null)
                anzoClient1.close();
        }
    }

    /**
     * This test ensures invalid queries throw correct exception
     * 
     * @throws Exception
     */
    public void testInvalidDatasetQuery() throws Exception {
        AnzoClient anzoClient1 = null;
        try {

            //
            // create DATASET SERVICE 1 (CLIENT 1)
            //
            anzoClient1 = new AnzoClient(getSystemClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);

            boolean exceptionThrown = false;
            try {
                anzoClient1.serverQuery(Collections.<URI> emptySet(), Collections.singleton(GRAPH_URI), null, "SELECT ?g ?s ?p ?o WHERE{GRAPH ?g{?s ?p ?o}}");
            } catch (AnzoException e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
        } finally {
            if (anzoClient1 != null)
                anzoClient1.close();
        }
    }

    /**
     * Test:
     * <UL>
     * <LI>AnzoClient.getAllGraphsDataset()
     * <LI>AnzoClient.getAllReplicaGraphsDataset()
     * <LI>Definitions.getAllServerGraphsDataset()
     * </UL>
     * 
     * @throws Exception
     * 
     */
    public void testAnzoClientDatasets() throws Exception {
        AnzoClient anzoClient1 = null;

        final URI ReplicaAndServerGraphURI = Constants.valueFactory.createURI("http://localandremotegraph");

        try {

            //
            // create DATASET SERVICE 1 (CLIENT 1)
            //
            anzoClient1 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);

            ClientGraph replicaGraph1 = anzoClient1.getReplicaGraph(replicaGraph1URI);
            assertNotNull(replicaGraph1);

            ClientGraph replicaGraph2 = anzoClient1.getReplicaGraph(replicaGraph2URI);
            assertNotNull(replicaGraph2);

            ClientGraph serverGraph1 = anzoClient1.getServerGraph(serverGraph1URI);
            assertNotNull(serverGraph1);

            ClientGraph serverGraph2 = anzoClient1.getServerGraph(serverGraph2URI);
            assertNotNull(serverGraph2);

            ClientGraph replicaGraph4 = anzoClient1.getReplicaGraph(ReplicaAndServerGraphURI);
            assertNotNull(replicaGraph1);

            ClientGraph serverGraph4 = anzoClient1.getServerGraph(ReplicaAndServerGraphURI);
            assertNotNull(serverGraph1);

            assertTrue(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(replicaGraph1URI));
            assertTrue(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(replicaGraph2URI));
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(serverGraph1URI));
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(serverGraph2URI));
            assertTrue(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(ReplicaAndServerGraphURI));

            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(replicaGraph1URI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(replicaGraph2URI));
            assertTrue(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(serverGraph1URI));
            assertTrue(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(serverGraph2URI));
            assertTrue(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(ReplicaAndServerGraphURI));

            assertFalse(serverGraph1.isClosed());
            assertFalse(serverGraph2.isClosed());
            assertFalse(serverGraph4.isClosed());
            assertTrue(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(serverGraph1URI));
            assertTrue(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(serverGraph2URI));
            assertTrue(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(ReplicaAndServerGraphURI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(replicaGraph1URI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(replicaGraph2URI));

            replicaGraph1.close();
            assertTrue(replicaGraph1.isClosed());
            assertFalse(replicaGraph2.isClosed());
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(replicaGraph1URI));
            assertTrue(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(replicaGraph2URI));
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(serverGraph1URI));
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(serverGraph2URI));

            serverGraph2.close();
            assertTrue(serverGraph2.isClosed());
            assertFalse(serverGraph1.isClosed());
            assertTrue(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(serverGraph1URI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(serverGraph2URI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(replicaGraph1URI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(replicaGraph2URI));

            replicaGraph4.close();
            assertFalse(serverGraph4.isClosed());
            assertTrue(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(ReplicaAndServerGraphURI));
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(ReplicaAndServerGraphURI));

            anzoClient1.close();

            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(replicaGraph1URI));
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(replicaGraph2URI));
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(serverGraph1URI));
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(serverGraph2URI));
            assertFalse(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(ReplicaAndServerGraphURI));

            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(replicaGraph1URI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(replicaGraph2URI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(serverGraph1URI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(serverGraph2URI));
            assertFalse(anzoClient1.getAllServerGraphsDataset().containsNamedGraph(ReplicaAndServerGraphURI));

        } finally {
            if (anzoClient1 != null)
                anzoClient1.close();
        }
    }

    /**
     * Test closing named graphs.
     * 
     * @throws Exception
     */
    public void testClosingNamedGraphs() throws Exception {
        AnzoClient anzoClient1 = null;
        try {

            final Statement stmt3 = Constants.valueFactory.createStatement((createTestUri("subject3")), createTestUri("predicate3"), (createTestUri("object3")));

            anzoClient1 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);

            // -------------------------------------------------------------------
            // close the replica graph -> using graph.close()
            // -make sure it is registered as closed
            // -make sure you can't write to it anymore

            // create graph with name GRAPH_URI
            ClientGraph replicaGraph1 = anzoClient1.getReplicaGraph(GRAPH_URI);
            anzoClient1.updateRepository();
            replicaGraph1.close();
            assertTrue(replicaGraph1.isClosed());
            boolean exceptionThrown = false;
            try {
                replicaGraph1.add(stmt3);
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

            // -------------------------------------------------------------------
            // get two graphs with the same name, change one of them, then close one of them ->
            // using graph.close()
            // -make sure the graph is not closed as long as there exist a graph using it
            // -make sure when the second graph is closed, that the graph is closed
            // -make sure we can't write to the graphs once the graph has been closed

            // create graph with name GRAPH_URI
            ClientGraph replicaGraph2 = anzoClient1.getReplicaGraph(GRAPH_URI);
            anzoClient1.updateRepository();
            // create graph with name GRAPH_URI
            ClientGraph replicaGraph3 = anzoClient1.getReplicaGraph(GRAPH_URI);
            anzoClient1.updateRepository();
            anzoClient1.begin();
            replicaGraph2.add(stmt3);
            anzoClient1.commit();
            //	Thread.currentThread().sleep(200); // give server some time to send the event
            replicaGraph2.close();
            // the graph is still in use by replicaGraph3
            assertFalse(replicaGraph2.isClosed());
            assertFalse(replicaGraph3.isClosed());
            replicaGraph3.close();
            // the graph is no longer in use by replicaGraph2
            assertTrue(replicaGraph2.isClosed());
            // the graph is no longer in use by replicaGraph3
            assertTrue(replicaGraph3.isClosed());
            exceptionThrown = false;
            try {
                replicaGraph2.add(stmt3);
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
            exceptionThrown = false;
            try {
                replicaGraph3.add(stmt3);
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

            // create graph with name GRAPH_URI
            anzoClient1.getReplicaGraph(GRAPH_URI);
            anzoClient1.updateRepository();

            // make sure that just because the graph was connected again, that old graphs can't be
            // used
            exceptionThrown = false;
            try {
                replicaGraph3.add(stmt3);
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
        } finally {
            if (anzoClient1 != null) {
                anzoClient1.close();
            }
        }
    }

    /**
     * Test AnzoClient.namedGraphExists()
     * 
     * @throws Exception
     */
    public void testIsNamedGraphStored() throws Exception {
        AnzoClient anzoClient1 = null;
        try {

            //
            // create DATASET SERVICE 1 (CLIENT 1)
            //
            anzoClient1 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);

            assertFalse(anzoClient1.namedGraphExists(GRAPH_URI));

            anzoClient1.getReplicaGraph(GRAPH_URI);
            assertFalse(anzoClient1.namedGraphExists(GRAPH_URI));

            anzoClient1.updateRepository();
            assertTrue(anzoClient1.namedGraphExists(GRAPH_URI));

            anzoClient1.updateRepository();
            assertTrue(anzoClient1.namedGraphExists(GRAPH_URI));

        } finally {
            if (anzoClient1 != null) {
                anzoClient1.close();
            }
        }
    }

    /***********************************************************************************************************************************************************
     * Test executing a SPARQL query against the server dataset.
     * 
     * @throws Exception
     */
    public void testServerDatasetQuery() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), (createTestUri("object1")));
        final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), (createTestUri("object2")));
        final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), (createTestUri("object3")));
        final Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), (createTestUri("object4")));
        AnzoClient anzoClient = new AnzoClient(getDefaultClientConfiguration());
        anzoClient.connect();
        try {
            anzoClient.reset(loadStatements("initialize.trig"), null);
            ClientGraph serverGraph1 = anzoClient.getServerGraph(NAME1);
            ClientGraph serverGraph2 = anzoClient.getServerGraph(NAME2);
            serverGraph1.add(stmt1);
            serverGraph1.add(stmt2);
            serverGraph2.add(stmt3);
            serverGraph2.add(stmt4);
            anzoClient.updateRepository();
            assertTrue(serverGraph1.contains(stmt1));
            assertTrue(serverGraph1.contains(stmt2));
            assertTrue(serverGraph2.contains(stmt3));
            assertTrue(serverGraph2.contains(stmt4));
            IDataset serverDataset = anzoClient.getAllServerGraphsDataset();
            final String listStatementsQuery = "SELECT ?g ?s ?p ?o WHERE { GRAPH ?g { ?s ?p ?o . } }";
            QueryResults results = anzoClient.serverQuery(serverDataset.getDefaultGraphUris(), serverDataset.getNamedGraphUris(), null, listStatementsQuery, null);
            assertTrue(results.isSelectResult());
            Set<Statement> statements = new HashSet<Statement>();
            for (PatternSolution solution : results.getSelectResults()) {
                Resource s = (Resource) solution.getBinding("s");
                URI p = (URI) solution.getBinding("p");
                Value o = solution.getBinding("o");
                statements.add(Constants.valueFactory.createStatement(s, p, o));
            }
            assertTrue(statements.contains(stmt1));
            assertTrue(statements.contains(stmt2));
            assertTrue(statements.contains(stmt3));
            assertTrue(statements.contains(stmt4));
            anzoClient.updateRepository();
            results = anzoClient.serverQuery(serverDataset.getDefaultGraphUris(), serverDataset.getNamedGraphUris(), null, listStatementsQuery, null);
            int i = 0;
            assertTrue(results.isSelectResult());
            Iterator<PatternSolution> result = results.getSelectResults().iterator();
            statements = new HashSet<Statement>();
            while (result.hasNext()) {
                PatternSolution solution = result.next();
                Resource s = (Resource) solution.getBinding("s");
                URI p = (URI) solution.getBinding("p");
                Value o = solution.getBinding("o");
                statements.add(Constants.valueFactory.createStatement(s, p, o));
                i++;
            }
            assertTrue(statements.contains(stmt1));
            assertTrue(statements.contains(stmt2));
            assertTrue(statements.contains(stmt3));
            assertTrue(statements.contains(stmt4));
        } finally {
            anzoClient.close();
        }
    }

    /***********************************************************************************************************************************************************
     * Test executing a SPARQL query against the replica dataset.
     * 
     * @throws Exception
     */
    public void testReplicaDatasetQuery() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), (createTestUri("object1")));
        final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), (createTestUri("object2")));
        final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), (createTestUri("object3")));
        final Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), (createTestUri("object4")));
        AnzoClient anzoClient = new AnzoClient(getDefaultClientConfiguration());
        anzoClient.connect();
        try {
            anzoClient.reset(loadStatements("initialize.trig"), null);

            //anzoClient.getDatasetReplicator().setReplicationMode(ReplicationMode.MANUAL);
            ClientGraph replicaGraph1 = anzoClient.getReplicaGraph(NAME1);
            ClientGraph replicaGraph2 = anzoClient.getReplicaGraph(NAME2);
            replicaGraph1.add(stmt1);
            replicaGraph1.add(stmt2);
            replicaGraph2.add(stmt3);
            replicaGraph2.add(stmt4);
            anzoClient.updateRepository();
            assertTrue(replicaGraph1.contains(stmt1));
            assertTrue(replicaGraph1.contains(stmt2));
            assertTrue(replicaGraph2.contains(stmt3));
            assertTrue(replicaGraph2.contains(stmt4));

            final String listStatementsQuery = "SELECT ?g ?s ?p ?o WHERE { GRAPH ?g { ?s ?p ?o } }";
            //IDataset dataset = new Dataset();

            /*Set<INamedGraph> namedGraphs = new HashSet<INamedGraph>();
            namedGraphs.add(replicaGraph1);
            namedGraphs.add(replicaGraph2);
            dataset.setNamedGraphs(namedGraphs);
            
            QueryResults results = dataset.executeQuery(listStatementsQuery);*/

            IDataset replicaDataset = anzoClient.getAllReplicaGraphsDataset();
            QueryResults results = anzoClient.serverQuery(replicaDataset.getDefaultGraphUris(), replicaDataset.getNamedGraphUris(), null, listStatementsQuery, null);

            int i = 0;
            assertTrue(results.isSelectResult());
            {
                Iterator<PatternSolution> result = results.getSelectResults().iterator();
                Set<Statement> statements = new HashSet<Statement>();
                while (result.hasNext()) {
                    PatternSolution solution = result.next();
                    Resource s = (Resource) solution.getBinding("s");
                    URI p = (URI) solution.getBinding("p");
                    Value o = solution.getBinding("o");
                    statements.add(Constants.valueFactory.createStatement(s, p, o));
                    i++;
                }

                assertTrue(statements.contains(stmt1));
                assertTrue(statements.contains(stmt2));
                assertTrue(statements.contains(stmt3));
                assertTrue(statements.contains(stmt4));
            }
            anzoClient.updateRepository();
            results = anzoClient.serverQuery(Collections.<URI> emptySet(), Collections.singleton(NAME1), null, listStatementsQuery, null);
            i = 0;
            assertTrue(results.isSelectResult());
            {
                Iterator<PatternSolution> result = results.getSelectResults().iterator();
                Set<Statement> statements = new HashSet<Statement>();

                while (result.hasNext()) {
                    PatternSolution solution = result.next();
                    Resource s = (Resource) solution.getBinding("s");
                    URI p = (URI) solution.getBinding("p");
                    Value o = solution.getBinding("o");
                    Statement stmt = Constants.valueFactory.createStatement(s, p, o);
                    statements.add(stmt);
                    i++;
                }

                assertTrue(statements.contains(stmt1));
                assertTrue(statements.contains(stmt2));
                assertFalse(statements.contains(stmt3));
                assertFalse(statements.contains(stmt4));
            }
        } finally {
            anzoClient.close();
        }
    }
}
