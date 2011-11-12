/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/client/TestTransactions.java,v $
 * Created by:  Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * Created on:  9/22/2006
 * Revision:	$Id: TestTransactions.java 171 2007-07-31 14:11:17Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test.client;

import java.util.LinkedList;
import java.util.List;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.client.command.Command;
import org.openanzo.client.command.CommandManager;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.test.AbstractTest;

/**
 * This test is designed to validate Anzo's <code>IUpdateTransactionQueue</code> and <code>TransactionQueueManager</code>.
 * 
 * @author Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * 
 */
public class TestTransactions extends AbstractTest {
    static final URI GRAPH_URI = Constants.valueFactory.createURI("http://graph1");

    /**
     * Test the use of different transactions (custom command, single transaction, transaction with multiple add/delete statements, etc).
     * 
     * @throws Exception
     */
    public void testMixedTransactionTypes() throws Exception {
        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {

            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            final Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), createTestUri("object4"));

            client1 = new AnzoClient(getDefaultClientConfiguration());
            client1.connect();
            client1.reset(loadStatements("initialize.trig"), null);
            CommandManager manager1 = new CommandManager(client1);

            client2 = new AnzoClient(getDefaultClientConfiguration());
            client2.connect();

            final ClientGraph replicaGraph1 = client1.getReplicaGraph(GRAPH_URI);
            final ClientGraph replicaGraph2 = client2.getServerGraph(GRAPH_URI);

            // ------------------------------------------------------------------------
            // create three different transactions
            // -make sure the transaction queue has the correct number of transactions
            // -make sure the transactions work and take affect when necessary

            client1.updateRepository();

            // T1: CUSTOM XCOMMAND TRANSACTION
            Command command = new Command() {

                public Object execute() {
                    replicaGraph1.add(stmt1);
                    return null;
                }
            };
            manager1.execute(command);

            // T2: SINGLE STATEMENT CHANGE TRANSACTION
            replicaGraph1.add(stmt2);

            // T3: MULTIPLE STATEMENT CHANGES IN A TRANSACTION
            client1.begin();
            replicaGraph1.add(stmt3);
            replicaGraph1.add(stmt4);
            client1.commit();

            assertEquals(3, client1.getQueuedTransactionCount());

            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt4));
            client1.updateRepository();

            assertTrue(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt2));
            assertTrue(replicaGraph2.contains(stmt3));
            assertTrue(replicaGraph2.contains(stmt4));
            assertEquals(0, client1.getQueuedTransactionCount());
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
     * Test clearing the transaction queue
     * 
     * @throws Exception
     */
    public void testDropQueuedTransactions() throws Exception {
        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {

            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));

            client1 = new AnzoClient(getDefaultClientConfiguration());
            client1.connect();
            client1.reset(loadStatements("initialize.trig"), null);
            client2 = new AnzoClient(getDefaultClientConfiguration());
            client2.connect();

            final ClientGraph replicaGraph1 = client1.getReplicaGraph(GRAPH_URI);
            final ClientGraph replicaGraph2 = client2.getServerGraph(GRAPH_URI);

            // -----------------------------------------------------------------------
            // create a single transaction, then delete it from the transaction queue
            // -make sure the transaction has no affect any of the graphs

            replicaGraph1.add(stmt2);
            client1.updateRepository();

            replicaGraph1.remove(stmt2);
            assertEquals(1, client1.getQueuedTransactionCount());
            client1.dropQueuedTransactions();

            assertEquals(0, client1.getQueuedTransactionCount());
            assertTrue(replicaGraph1.contains(stmt2));
            client1.updateRepository();
            assertTrue(replicaGraph1.contains(stmt2));
            assertTrue(replicaGraph2.contains(stmt2));
            replicaGraph1.add(stmt1);
            replicaGraph1.add(stmt3);
            assertEquals(2, client1.getQueuedTransactionCount());
            client1.dropQueuedTransactions();

            assertEquals(0, client1.getQueuedTransactionCount());
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph1.contains(stmt2));
            assertTrue(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));

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
     * Test the effects of replicating after a begin and before a commit (mid transaction).
     * 
     * @throws Exception
     */
    public void testMidTransactionReplication() throws Exception {

        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {

            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));

            client1 = new AnzoClient(getDefaultClientConfiguration());
            client1.connect();
            client1.reset(loadStatements("initialize.trig"), null);
            client2 = new AnzoClient(getDefaultClientConfiguration());
            client2.connect();

            final ClientGraph replicaGraph1 = client1.getReplicaGraph(GRAPH_URI);
            client1.updateRepository();

            final ClientGraph replicaGraph2 = client2.getServerGraph(GRAPH_URI);
            client2.updateRepository();

            client1.begin();
            replicaGraph1.add(stmt1);
            client1.commit();

            client1.begin();
            replicaGraph1.add(stmt2);
            client1.commit();

            client1.begin();
            replicaGraph1.add(stmt3);

            client1.updateRepository();

            assertTrue(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt3));

            client1.commit();

            assertTrue(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt3));

            client1.updateRepository();

            assertTrue(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt2));
            assertTrue(replicaGraph2.contains(stmt3));

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
     * Test the behavior of the transaction queue when faced with null commands.
     * 
     * @throws Exception
     */
    public void testTransactionQueueWithNullCommands() throws Exception {

        AnzoClient client = null;
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            final Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), createTestUri("object4"));

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            CommandManager manager = new CommandManager(client);

            final ClientGraph replicaGraph = client.getReplicaGraph(GRAPH_URI);
            client.updateRepository();

            // ------------------------------------------------------------------------
            // create three different transactions
            // -make sure the transaction queue has the correct number of transactions
            // -make sure the transactions work and take affect when necessary

            // T1: CUSTOM XCOMMAND TRANSACTION
            Command command = new Command() {

                public Object execute() {
                    replicaGraph.add(stmt1);
                    return null;
                }
            };

            manager.execute(command);

            boolean exceptionThrown = false;
            try {
                manager.execute(null);
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

            // T2: SINGLE STATEMENT CHANGE TRANSACTION
            replicaGraph.add(stmt2);

            // T3: MULTIPLE STATEMENT CHANGES IN A TRANSACTION
            client.begin();
            replicaGraph.add(stmt3);
            replicaGraph.add(stmt4);
            client.commit();

            assertEquals(3, client.getQueuedTransactionCount());

            client.updateRepository();

            assertEquals(0, client.getQueuedTransactionCount());

            // -----------------------------------------------------------------------
            // create a single transaction, then delete it from the transaction queue
            // -make sure the transaction has no affect any of the graphs

            replicaGraph.remove(stmt2);
            assertEquals(1, client.getQueuedTransactionCount());
            client.dropQueuedTransactions();
            assertEquals(0, client.getQueuedTransactionCount());
            assertTrue(replicaGraph.contains(stmt2));
            client.updateRepository();
            assertTrue(replicaGraph.contains(stmt2));
            replicaGraph.add(stmt1);
            replicaGraph.add(stmt3);
            client.updateRepository();

            client.begin();
            replicaGraph.clear();
            client.commit();
            assertEquals(1, client.getQueuedTransactionCount());
            client.dropQueuedTransactions();
            assertEquals(0, client.getQueuedTransactionCount());
            assertTrue(replicaGraph.contains(stmt1));
            assertTrue(replicaGraph.contains(stmt2));
            assertTrue(replicaGraph.contains(stmt3));

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test:
     * <UL>
     * <li>IUpdateTransactionQueueManager.beginNonBlocking()</li>
     * </UL>
     * 
     * @throws Exception
     */
    public void testBeginNonBlockingInSameThread() throws Exception {

        AnzoClient client = null;

        try {

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            assertFalse(client.inTransaction());

            // ----------------------------------------------------------------
            // test beginNonBlocking/commit with errors

            client.begin();
            assertTrue(client.inTransaction());
            boolean exceptionThrown = false;
            try {
                client.begin();
            } catch (Exception e) {
                exceptionThrown = true;
                client.abort();
            }
            assertFalse(exceptionThrown);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test <code>IUpdateTransactionQueue</code> provided by <code>AnzoClient</code>:
     * 
     * <UL>
     * <li>begin/abort</li>
     * <li>begin/commit</li>
     * <li>beginNonBlocking/abort</li>
     * <li>beginNonBlocking/commit</li>
     * </UL>
     * 
     * @throws Exception
     */
    public void testTransactionQueueHandler() throws Exception {

        AnzoClient client = null;
        try {

            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();

            final ClientGraph replicaGraph = client.getReplicaGraph(GRAPH_URI);
            assertFalse(client.inTransaction());

            // ----------------------------------------------------------------
            // test begin/abort

            client.begin();
            assertTrue(client.inTransaction());
            replicaGraph.add(stmt1);
            assertTrue(replicaGraph.contains(stmt1));
            client.abort();
            assertFalse(replicaGraph.contains(stmt1));

            // ----------------------------------------------------------------
            // test begin/commit

            client.begin();
            assertTrue(client.inTransaction());
            replicaGraph.add(stmt1);
            assertTrue(replicaGraph.contains(stmt1));
            client.commit();
            assertTrue(replicaGraph.contains(stmt1));

            // ----------------------------------------------------------------
            // test beginNonBlocking/abort

            client.begin();
            replicaGraph.add(stmt2);
            assertTrue(replicaGraph.contains(stmt2));
            client.abort();
            assertFalse(replicaGraph.contains(stmt2));

            // ----------------------------------------------------------------
            // test beginNonBlocking/commit

            client.begin();
            replicaGraph.add(stmt2);
            assertTrue(replicaGraph.contains(stmt2));
            client.commit();
            assertTrue(replicaGraph.contains(stmt2));

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test the transaction reference count.
     * 
     * @throws Exception
     */
    public void testTransactionReferenceCounts() throws Exception {

        AnzoClient client = null;
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            final Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), createTestUri("object4"));

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph replicaGraph = client.getReplicaGraph(GRAPH_URI);
            assertNotNull(replicaGraph);
            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);
            assertNotNull(serverGraph);
            client.updateRepository();

            client.begin();
            replicaGraph.add(stmt1);
            client.begin();
            client.begin();
            client.begin();
            replicaGraph.add(stmt2);
            client.begin();
            replicaGraph.remove(stmt1);
            client.commit();
            replicaGraph.add(stmt3);
            client.commit();
            client.commit();
            client.commit();
            replicaGraph.remove(stmt3);
            replicaGraph.add(stmt4);
            assertEquals(0, client.getQueuedTransactionCount());
            client.commit();
            assertEquals(1, client.getQueuedTransactionCount());
            assertFalse(replicaGraph.contains(stmt1));
            assertTrue(replicaGraph.contains(stmt2));
            assertFalse(replicaGraph.contains(stmt3));
            assertTrue(replicaGraph.contains(stmt4));
            assertFalse(serverGraph.contains(stmt1));
            assertTrue(serverGraph.contains(stmt2));
            assertFalse(serverGraph.contains(stmt3));
            assertTrue(serverGraph.contains(stmt4));
            client.begin();
            serverGraph.add(stmt1);
            client.begin();
            client.begin();
            client.begin();
            serverGraph.add(stmt2);
            client.begin();
            serverGraph.remove(stmt1);
            client.commit();
            serverGraph.add(stmt3);
            client.commit();
            client.commit();
            client.commit();
            serverGraph.remove(stmt3);
            serverGraph.add(stmt4);
            client.commit();
            assertEquals(2, client.getQueuedTransactionCount());
            assertFalse(serverGraph.contains(stmt1));
            assertTrue(serverGraph.contains(stmt2));
            assertFalse(serverGraph.contains(stmt3));
            assertTrue(serverGraph.contains(stmt4));
            assertFalse(replicaGraph.contains(stmt1));
            assertTrue(replicaGraph.contains(stmt2));
            assertFalse(replicaGraph.contains(stmt3));
            assertTrue(replicaGraph.contains(stmt4));
            client.dropQueuedTransactions();
            assertEquals(0, client.getQueuedTransactionCount());
            assertFalse(serverGraph.contains(stmt1));
            assertFalse(serverGraph.contains(stmt2));
            assertFalse(serverGraph.contains(stmt3));
            assertFalse(serverGraph.contains(stmt4));
            assertFalse(replicaGraph.contains(stmt1));
            assertFalse(replicaGraph.contains(stmt2));
            assertFalse(replicaGraph.contains(stmt3));
            assertFalse(replicaGraph.contains(stmt4));

            replicaGraph.close();
            boolean exceptionThrown = false;
            try {
                replicaGraph.add(stmt3);
            } catch (RuntimeException e) {
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
     * Test transactions and transaction reference count.
     * 
     * @throws Exception
     */
    public void testAddingRemovingStatementsInMessyTransactions() throws Exception {

        AnzoClient client = null;
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            final Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), createTestUri("object4"));

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph replicaGraph1 = client.getReplicaGraph(Constants.valueFactory.createURI("http://graph1"));
            ClientGraph replicaGraph2 = client.getReplicaGraph(Constants.valueFactory.createURI("http://graph2"));
            ClientGraph replicaGraph3 = client.getReplicaGraph(Constants.valueFactory.createURI("http://graph3"));
            ClientGraph replicaGraph4 = client.getReplicaGraph(Constants.valueFactory.createURI("http://graph4"));
            ClientGraph replicaGraph5 = client.getReplicaGraph(Constants.valueFactory.createURI("http://graph6"));
            ClientGraph replicaGraph6 = client.getReplicaGraph(Constants.valueFactory.createURI("http://graph7"));
            ClientGraph serverGraph1 = client.getServerGraph(Constants.valueFactory.createURI("http://graph1"));
            ClientGraph serverGraph2 = client.getServerGraph(Constants.valueFactory.createURI("http://graph2"));
            ClientGraph serverGraph3 = client.getServerGraph(Constants.valueFactory.createURI("http://graph3"));
            ClientGraph serverGraph4 = client.getServerGraph(Constants.valueFactory.createURI("http://graph4"));
            ClientGraph serverGraph5 = client.getServerGraph(Constants.valueFactory.createURI("http://graph9"));
            ClientGraph serverGraph6 = client.getServerGraph(Constants.valueFactory.createURI("http://graph11"));
            client.updateRepository();
            // T1
            client.begin();
            replicaGraph2.add(stmt1);
            assertTrue(serverGraph2.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt1));
            replicaGraph3.add(stmt3);
            client.commit();
            assertEquals(1, client.getQueuedTransactionCount());
            // T2
            serverGraph2.remove(stmt1);
            assertFalse(serverGraph2.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertEquals(2, client.getQueuedTransactionCount());
            // T3
            client.begin();
            replicaGraph1.add(stmt1);
            serverGraph2.add(stmt4);
            replicaGraph2.remove(stmt4);
            client.commit();
            assertFalse(replicaGraph2.contains(stmt4));
            assertTrue(replicaGraph1.contains(stmt1));
            assertEquals(3, client.getQueuedTransactionCount());
            client.dropQueuedTransactions();
            assertTrue(replicaGraph1.size() == 0);
            assertTrue(serverGraph1.size() == 0);
            assertTrue(replicaGraph2.size() == 0);
            assertTrue(serverGraph2.size() == 0);
            assertTrue(replicaGraph3.size() == 0);
            assertTrue(serverGraph3.size() == 0);
            assertTrue(replicaGraph4.size() == 0);
            assertTrue(serverGraph4.size() == 0);
            // T1
            client.begin();
            replicaGraph1.add(stmt1);
            replicaGraph2.remove(stmt1);
            replicaGraph3.add(stmt3);
            replicaGraph3.add(stmt3);
            replicaGraph3.add(stmt3);
            serverGraph3.add(stmt3);
            serverGraph3.add(stmt3);
            serverGraph3.add(stmt3);
            replicaGraph5.add(stmt3);
            replicaGraph6.add(stmt4);
            client.commit();
            assertTrue(replicaGraph1.contains(stmt1));
            assertTrue(replicaGraph3.contains(stmt3));
            assertTrue(replicaGraph5.contains(stmt3));
            assertTrue(replicaGraph6.contains(stmt4));
            assertEquals(1, client.getQueuedTransactionCount());

            assertTrue(replicaGraph1.contains(stmt1.getSubject(), stmt1.getPredicate(), stmt1.getObject()));
            // T2
            client.begin();
            client.begin();
            client.begin();
            serverGraph5.add(stmt1);
            client.commit();
            client.commit();
            client.commit();
            assertEquals(2, client.getQueuedTransactionCount());
            // T3
            client.begin();
            client.begin();
            client.begin();
            serverGraph6.add(stmt3);
            replicaGraph5.add(stmt3);
            serverGraph1.add(stmt4);
            client.commit();
            client.commit();
            client.commit();
            assertEquals(3, client.getQueuedTransactionCount());
            assertTrue(serverGraph6.contains(stmt3));
            assertTrue(replicaGraph5.contains(stmt3));
            assertTrue(serverGraph1.contains(stmt4));
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test adding and removing in the same transaction.
     * 
     * @throws Throwable
     */
    public void testAddAndRemoveInSameTransaction() throws Throwable {

        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        try {
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            ClientGraph replicaGraph = client.getReplicaGraph(GRAPH_URI);
            ClientGraph serverGraph = client.getServerGraph(GRAPH_URI);
            Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object2"));
            Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate3"), createTestUri("object3"));
            replicaGraph.add(stmt3); // +Stmt3
            assertTrue(replicaGraph.contains(stmt3));
            replicaGraph.add(stmt4); // +Stmt4
            assertTrue(replicaGraph.contains(stmt4));
            client.begin();
            replicaGraph.add(stmt1); // +Stmt1
            assertTrue(replicaGraph.contains(stmt1));
            replicaGraph.remove(stmt1); // -Stmt1
            assertFalse(replicaGraph.contains(stmt1));
            replicaGraph.add(stmt2); // +Stmt2
            assertTrue(replicaGraph.contains(stmt2));
            replicaGraph.remove(stmt2); // -Stmt2
            assertFalse(replicaGraph.contains(stmt2));
            replicaGraph.add(stmt2); // +Stmt2
            assertTrue(replicaGraph.contains(stmt2));
            replicaGraph.remove(stmt3); // -Stmt3
            assertFalse(replicaGraph.contains(stmt3));
            replicaGraph.remove(stmt4); // -Stmt4
            assertFalse(replicaGraph.contains(stmt4));
            replicaGraph.add(stmt4); // +Stmt4
            assertTrue(replicaGraph.contains(stmt4));
            replicaGraph.add(stmt2); // +Stmt2
            client.commit();
            assertFalse(replicaGraph.contains(stmt3));
            assertTrue(replicaGraph.contains(stmt4)); // make sure there is only 1
            client.updateRepository(); // replicate now so that the
            // changes go to the server.

            assertFalse(serverGraph.contains(stmt1));
            assertFalse(serverGraph.contains(stmt3));
            assertTrue(serverGraph.contains(stmt4)); // make sure there is only 1
            assertFalse(replicaGraph.contains(stmt3));
            assertTrue(replicaGraph.contains(stmt4));

            replicaGraph.close();
        } finally {
            client.close();
        }
    }

    /**
     * Validate that transactions throw appropriate exceptions.
     * 
     * @throws Throwable
     */
    public void testTransactionExceptions() throws Throwable {

        final List<Exception> exceptions = new LinkedList<Exception>();

        final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
        final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object2"));

        final AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        try {

            final ClientGraph replicaGraph = client.getReplicaGraph(GRAPH_URI);

            // commits and aborts with no matching begin are now no-ops
            //            boolean exceptionThrown = false;
            //            try {
            //                client.commit();
            //            } catch (Exception e) {
            //                exceptionThrown = true;
            //            }
            //            assertTrue(exceptionThrown);
            //
            //            exceptionThrown = false;
            //            try {
            //                // begin has not been called, so this is invalid
            //                client.abort();
            //            } catch (Exception e) {
            //                exceptionThrown = true;
            //            }
            //            assertTrue(exceptionThrown);

            new Thread(new Runnable() {

                public void run() {

                    try {
                        client.begin();
                        replicaGraph.add(stmt2);
                        replicaGraph.remove(stmt1);

                        new Thread(new Runnable() {

                            public void run() {

                                try {
                                    client.begin();
                                    replicaGraph.add(stmt2);
                                    replicaGraph.remove(stmt1);
                                    client.commit();
                                } catch (Exception e) {
                                    synchronized (exceptions) {
                                        exceptions.add(e);
                                    }
                                }

                            }

                        }).start();

                        client.commit();

                    } catch (Exception e) {
                        synchronized (exceptions) {
                            exceptions.add(e);
                        }
                    }
                }

            }).start();

            Thread.sleep(400);

            assertFalse(replicaGraph.contains(stmt1));
            assertTrue(replicaGraph.contains(stmt2));

        } finally {
            client.close();
        }

        if (!exceptions.isEmpty())
            throw new Exception(exceptions.get(0));
    }

    /**
     * If one performs a particular sequence of adds and removes on a graph, that sequence should always yield the same graph at the end, regardless of how the
     * individual adds and removes are grouped into transactions. In other words, in the absence of errors, the placement of begin and commit calls should not
     * affect the results of the data in the graph.
     * 
     * We'll test this via a border condition: deleting a statement first and then adding the same statement. If we do that as two separate transactions or as
     * one transaction, there should be no difference in the results. The graph should contain the added statement.
     * 
     * @throws Exception
     */
    public void testDifferentTransactionGroupingYieldsSameResults() throws Exception {

        AnzoClient client = null;
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement((createTestUri("subject1")), createTestUri("predicate1"), (createTestUri("object1")));
            final Statement stmt2 = Constants.valueFactory.createStatement((createTestUri("subject2")), createTestUri("predicate2"), (createTestUri("object2")));

            final URI GRAPH_URI1 = Constants.valueFactory.createURI("http://GRAPH_URI1");

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            // Start with an empty graph
            ClientGraph localGraph = client.getReplicaGraph(GRAPH_URI1);

            // Delete, then add the a statement without calling begin/commit.
            // The statement should exist in the graph after replication.
            localGraph.remove(stmt1); // Delete before an add
            localGraph.add(stmt1);
            client.updateRepository();
            assertTrue(localGraph.contains(stmt1.getSubject(), stmt1.getPredicate(), stmt1.getObject()));

            // Delete, then add within a single transaction.
            // The statement should also exist in the graph after replication.
            client.begin();
            localGraph.remove(stmt2); // Delete before an add
            localGraph.add(stmt2);
            client.commit();
            client.updateRepository();
            assertTrue(localGraph.contains(stmt2.getSubject(), stmt2.getPredicate(), stmt2.getObject()));

            localGraph.close();

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
}
