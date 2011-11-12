/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/client/TestComplicatedInputs.java,v $
 * Created by:  Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * Created on:  9/22/2006
 * Revision:	$Id: TestComplicatedInputs.java 171 2007-07-31 14:11:17Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test.client;

import java.util.Properties;
import java.util.Random;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.vocabulary.XMLSchema;
import org.openanzo.services.ServicesProperties;
import org.openanzo.test.AbstractTest;

/**
 * The goal of these tests is to check the behavior of the system with unexpected/unusual inputs.
 * 
 * @author Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * 
 */
public class TestComplicatedInputs extends AbstractTest {

    /**
     * Test creating a named graph with a very long uri (check for buffer overflows).
     * 
     * @throws Exception
     */
    public void testLongNameGraphURI() throws Exception {
        AnzoClient client = null;
        try {
            Random random = new Random();
            StringBuilder uri = new StringBuilder("http://");
            for (int i = 0; i < 32000; i++) {
                int next = random.nextInt() % 25;
                if (next < 0)
                    next *= -1;
                uri.append(((char) ('a' + next)));
            }
            final URI GRAPH_URI = Constants.valueFactory.createURI(uri.toString());
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
            assertNotNull(graph);
            client.updateRepository();

            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);
            assertNotNull(serverGraph);
            client.updateRepository();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test creating a named graph with a very long uri (check for buffer overflows).
     * 
     * @throws Exception
     */
    public void testLongLiterals() throws Exception {
        AnzoClient client = null;
        try {
            Random random = new Random();
            StringBuilder uri = new StringBuilder("http://");
            for (int i = 0; i < 32000; i++) {
                int next = random.nextInt() % 25;
                if (next < 0)
                    next *= -1;
                uri.append(((char) ('a' + next)));
            }
            final URI GRAPH_URI = Constants.valueFactory.createURI("http://test/uri");
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
            assertNotNull(graph);
            client.updateRepository();

            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);
            assertNotNull(serverGraph);
            client.updateRepository();
            Statement stmt = Constants.valueFactory.createStatement(MemURI.create("http://test/uri"), MemURI.create("http://test/uri"), Constants.valueFactory.createTypedLiteral(uri.toString()));
            serverGraph.add(stmt);
            client.updateRepository();
            assertTrue(serverGraph.contains(stmt));
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test creating a named graph with a very long uri (check for buffer overflows).
     * 
     * @throws Exception
     */
    public void testGermanLiterals() throws Exception {
        AnzoClient client = null;
        try {
            String input = "Universität";
            final URI GRAPH_URI = Constants.valueFactory.createURI("http://test/uri");
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);
            client.updateRepository();
            Statement stmt = Constants.valueFactory.createStatement(MemURI.create("http://test/uri"), MemURI.create("http://test/uri"), Constants.valueFactory.createTypedLiteral(input));
            serverGraph.add(stmt);
            client.updateRepository();
            assertTrue(serverGraph.contains(stmt));
            for (Statement stmt1 : serverGraph.find(null, null, Constants.valueFactory.createTypedLiteral(input))) {
                assertTrue(stmt1.getObject() instanceof TypedLiteral);
                assertTrue(((TypedLiteral) stmt1.getObject()).getLabel().equals(input));
            }
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * 
     * @throws Exception
     */
    public void testLexicalLiterals() throws Exception {
        AnzoClient client = null;
        try {
            String input = "10.";
            String input2 = "+5";
            String input3 = "01";
            final URI GRAPH_URI = Constants.valueFactory.createURI("http://test/uri");
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);
            client.updateRepository();
            TypedLiteral lit = Constants.valueFactory.createLiteral(input, XMLSchema.DECIMAL);
            TypedLiteral lit2 = Constants.valueFactory.createLiteral(input2, XMLSchema.INTEGER);
            TypedLiteral lit3 = Constants.valueFactory.createLiteral(input3, XMLSchema.DECIMAL);
            Statement stmt = Constants.valueFactory.createStatement(MemURI.create("http://test/uri"), MemURI.create("http://test/uri"), lit);
            Statement stmt2 = Constants.valueFactory.createStatement(MemURI.create("http://test/uri"), MemURI.create("http://test/uri2"), lit2);
            Statement stmt3 = Constants.valueFactory.createStatement(MemURI.create("http://test/uri"), MemURI.create("http://test/uri3"), lit3);
            serverGraph.add(stmt);
            serverGraph.add(stmt2);
            serverGraph.add(stmt3);
            client.updateRepository();
            assertTrue(serverGraph.contains(stmt));
            assertTrue(serverGraph.contains(stmt2));
            assertTrue(serverGraph.contains(stmt3));
            for (Statement stmt1 : serverGraph.find(null, null, lit)) {
                assertTrue(stmt1.getObject() instanceof TypedLiteral);
                assertTrue(((TypedLiteral) stmt1.getObject()).getLabel().equals(input));
            }
            for (Statement stmt1 : serverGraph.find(null, null, lit2)) {
                assertTrue(stmt1.getObject() instanceof TypedLiteral);
                assertTrue(((TypedLiteral) stmt1.getObject()).getLabel().equals(input2));
            }
            for (Statement stmt1 : serverGraph.find(null, null, lit3)) {
                assertTrue(stmt1.getObject() instanceof TypedLiteral);
                assertTrue(((TypedLiteral) stmt1.getObject()).getLabel().equals(input3));
            }
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test creating a named graph with a null uri.
     * 
     * @throws Exception
     */
    public void testNULLNameGraphURI() throws Exception {
        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            boolean exceptionThrown = false;
            try {
                client.getReplicaGraph(null);
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test creating a named graph with an empty graph uri.
     * 
     * @throws Exception
     */
    public void testEmptyNameGraphURI() throws Exception {
        AnzoClient client = null;
        try {
            Properties props = new Properties(System.getProperties());
            props.putAll(getProperties());
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            boolean exceptionThrown = false;
            try {
                client.getServerGraph(Constants.valueFactory.createURI(""));
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test creating a client without a password.
     * 
     * @throws Exception
     */
    public void testWithNoPassword() throws Exception {

        boolean exceptionThrown = false;
        AnzoClient client = null;
        try {
            Properties configGraph = getDefaultClientConfiguration();
            ServicesProperties.setPassword(configGraph, null);
            client = new AnzoClient(configGraph);
            client.reset(loadStatements("initialize.trig"), null);
            client.getServerGraph(GRAPHS.DEFAULT_SYSTEMGRAPH).size();
        } catch (AnzoException be) {
            exceptionThrown = true;
        } finally {
            if (client != null) {
                client.close();
            }
        }
        assertTrue(exceptionThrown);
    }

    /**
     * Test creating client with notifications using minimum specified properties.
     * 
     * This test tries to connect to a remote server.
     * 
     * @throws Exception
     */
    public void testWithMinimulProperties() throws Exception {

        final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
        final URI GRAPH_URI = Constants.valueFactory.createURI("http://graph1");

        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            assertNotNull(clientGraph);

            clientGraph.add(stmt1);

            client.updateRepository();

            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);
            assertNotNull(serverGraph);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
}
