/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/client/TestUpdates.java,v $
 * Created by:  Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * Created on:  9/22/2006
 * Revision:	$Id: TestUpdates.java 171 2007-07-31 14:11:17Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.utils.test.Condition;
import org.openanzo.rdf.utils.test.TestUtilities;
import org.openanzo.test.AbstractTest;

/**
 * This class is designed to test notifications/updates.
 * 
 * @author Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * 
 */
public class TestUpdates extends AbstractTest {

    static final URI       GRAPH_URI = Constants.valueFactory.createURI("http://graph1");

    static final Statement stmt1     = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));

    static final Statement stmt2     = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object2"));

    static final Statement stmt3     = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));

    private int            numRemoved1 = 0, numAdded1 = 0, numRemoved2 = 0, numAdded2 = 0, numRemoved3 = 0, numAdded3 = 0;

    /**
     * Test:
     * <ol>
     * <li>Updates among three clients.</li>
     * <li>Adding and removing statements to/from replica graphs.</li>
     * <li>Revision history access.</li>
     * <li>Statement listener updates.</li>
     * <li>Immediate replication mode.</li>
     * <li>Events received by IReplicationListener.</li>
     * <li>Closing of datasets and replica graphs.</li>
     * </ol>
     * 
     * @throws Exception
     */
    public void testNotificationsWithThreeClientsAndImmediateReplication() throws Exception {

        AnzoClient anzoClient1 = null;
        AnzoClient anzoClient2 = null;
        AnzoClient anzoClient3 = null;
        try {
            numAdded1 = numAdded2 = numAdded3 = numRemoved1 = numRemoved2 = numRemoved3 = 0;
            //
            // create DATASET SERVICE 1 (CLIENT 1)
            //
            anzoClient1 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);
            //
            // create DATASET SERVICE 2 (CLIENT 2)
            //
            anzoClient2 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient2.connect();

            //
            // create DATASET SERVICE 3 (CLIENT 3)
            //
            anzoClient3 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient3.connect();

            assertFalse(anzoClient1.namedGraphExists(GRAPH_URI));
            assertFalse(anzoClient2.namedGraphExists(GRAPH_URI));
            assertFalse(anzoClient3.namedGraphExists(GRAPH_URI));
            // create graph with name GRAPH_URI
            ClientGraph replicaGraph1 = anzoClient1.getReplicaGraph(GRAPH_URI);
            assertNotNull(replicaGraph1);
            anzoClient1.updateRepository();

            assertTrue(anzoClient1.namedGraphExists(GRAPH_URI));
            assertTrue(anzoClient2.namedGraphExists(GRAPH_URI));
            assertTrue(anzoClient3.namedGraphExists(GRAPH_URI));
            // get existing graph with name GRAPH_URI
            ClientGraph replicaGraph2 = anzoClient2.getReplicaGraph(GRAPH_URI);
            assertNotNull(replicaGraph2);
            anzoClient2.updateRepository();

            assertTrue(anzoClient1.namedGraphExists(GRAPH_URI));
            assertTrue(anzoClient2.namedGraphExists(GRAPH_URI));
            assertTrue(anzoClient3.namedGraphExists(GRAPH_URI));
            // get existing graph with name GRAPH_URI
            ClientGraph replicaGraph3 = anzoClient3.getReplicaGraph(GRAPH_URI);
            assertNotNull(replicaGraph3);
            assertTrue(anzoClient1.namedGraphExists(GRAPH_URI));
            assertTrue(anzoClient2.namedGraphExists(GRAPH_URI));
            assertTrue(anzoClient3.namedGraphExists(GRAPH_URI));
            anzoClient3.updateRepository();

            // ADD LISTENERS TO REPLICA GRAPHS
            replicaGraph1.registerListener(new IStatementListener<INamedGraph>() {

                public void statementsRemoved(INamedGraph source, Statement... s) {
                    numRemoved1 += s.length;
                }

                public void statementsAdded(INamedGraph source, Statement... s) {
                    numAdded1 += s.length;
                }
            });
            replicaGraph2.registerListener(new IStatementListener<INamedGraph>() {

                public void statementsRemoved(INamedGraph source, Statement... s) {
                    numRemoved2 += s.length;
                }

                public void statementsAdded(INamedGraph source, Statement... s) {
                    numAdded2 += s.length;
                }
            });
            replicaGraph3.registerListener(new IStatementListener<INamedGraph>() {

                public void statementsRemoved(INamedGraph source, Statement... s) {
                    numRemoved3 += s.length;
                }

                public void statementsAdded(INamedGraph source, Statement... s) {
                    numAdded3 += s.length;
                }
            });
            // -----------------------------------------------------------------
            // add a statement to first graph
            // -make sure all graphs contain the same data
            // -make sure all statement listeners received events
            // -check revision history
            long currentRevision = getNamedGraphRevision(anzoClient1.getCurrentNamedGraphRevision(GRAPH_URI));
            assertEquals(0, currentRevision);
            replicaGraph1.add(stmt1);
            anzoClient1.updateRepository();
            assertTrue(replicaGraph1.contains(stmt1));
            // check the revision has incremented
            currentRevision = getNamedGraphRevision(anzoClient1.getCurrentNamedGraphRevision(GRAPH_URI));
            assertEquals(1, currentRevision);
            replicaGraph1.add(stmt2);
            anzoClient1.updateRepository();
            assertTrue(replicaGraph1.contains(stmt2));
            // check the revision has incremented
            currentRevision = getNamedGraphRevision(anzoClient1.getCurrentNamedGraphRevision(GRAPH_URI));
            assertEquals(2, currentRevision);
            replicaGraph1.remove(stmt2);
            anzoClient1.updateRepository();
            assertFalse(replicaGraph1.contains(stmt2));
            // check the revision has incremented
            currentRevision = getNamedGraphRevision(anzoClient1.getCurrentNamedGraphRevision(GRAPH_URI));
            assertEquals(3, currentRevision);
            IAnzoGraph localGraph1V2 = anzoClient1.getNamedGraphRevision(GRAPH_URI, 1);
            assertNotNull(localGraph1V2);
            assertTrue(localGraph1V2.contains(stmt1));
            assertFalse(localGraph1V2.contains(stmt2));

            TestUtilities.waitForStatement(replicaGraph2, stmt1, true);
            assertTrue(replicaGraph2.contains(stmt1));
            TestUtilities.waitForStatement(replicaGraph2, stmt2, false);
            assertFalse(replicaGraph2.contains(stmt2));
            TestUtilities.waitForStatement(replicaGraph3, stmt1, true);
            assertTrue(replicaGraph3.contains(stmt1));
            TestUtilities.waitForStatement(replicaGraph3, stmt3, false);
            assertFalse(replicaGraph3.contains(stmt3));
            // make sure both graph listeners received an update

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return numAdded1 >= 2;
                }
            });
            assertTrue(numAdded1 >= 2);

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return numAdded2 >= 2;
                }
            });
            assertTrue(numAdded2 >= 2);

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return numAdded3 >= 2;
                }
            });
            assertTrue(numAdded3 >= 2);

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return numRemoved1 >= 1;
                }
            });
            assertTrue(numRemoved1 >= 1);

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return numRemoved2 >= 1;
                }
            });
            assertTrue(numRemoved2 >= 1);

            TestUtilities.waitFor(new Condition() {
                @Override
                public boolean check() {
                    return numRemoved3 >= 1;
                }
            });
            assertTrue(numRemoved3 >= 1);

            numAdded1 = numAdded2 = numAdded3 = numRemoved1 = numRemoved2 = numRemoved3 = 0;
            // -----------------------------------------------------------------
            // delete all statements in a single transaction
            // -make sure all graphs contain the same data
            replicaGraph3.clear();
            anzoClient3.updateRepository();

            TestUtilities.waitForSize(replicaGraph1, 0);
            assertEquals(0, replicaGraph1.size());
            TestUtilities.waitForSize(replicaGraph2, 0);
            assertEquals(0, replicaGraph2.size());
            TestUtilities.waitForSize(replicaGraph3, 0);
            assertEquals(0, replicaGraph3.size());
            // ------------------------------------------------------------------
            // add statements to all graphs
            // -make sure all graphs contain the same data
            // -make sure all graph listeners are notified
            replicaGraph1.add(stmt1);
            replicaGraph2.add(stmt2);
            replicaGraph3.add(stmt3);
            anzoClient1.updateRepository();
            anzoClient2.updateRepository();
            anzoClient3.updateRepository();

            TestUtilities.waitForStatement(replicaGraph1, stmt1, true);
            assertTrue(replicaGraph1.contains(stmt1));
            TestUtilities.waitForStatement(replicaGraph2, stmt1, true);
            assertTrue(replicaGraph2.contains(stmt1));
            TestUtilities.waitForStatement(replicaGraph3, stmt1, true);
            assertTrue(replicaGraph3.contains(stmt1));
            TestUtilities.waitForStatement(replicaGraph1, stmt2, true);
            assertTrue(replicaGraph1.contains(stmt2));
            TestUtilities.waitForStatement(replicaGraph2, stmt2, true);
            assertTrue(replicaGraph2.contains(stmt2));
            TestUtilities.waitForStatement(replicaGraph3, stmt2, true);
            assertTrue(replicaGraph3.contains(stmt2));
            TestUtilities.waitForStatement(replicaGraph1, stmt3, true);
            assertTrue(replicaGraph1.contains(stmt3));
            TestUtilities.waitForStatement(replicaGraph2, stmt3, true);
            assertTrue(replicaGraph2.contains(stmt3));
            TestUtilities.waitForStatement(replicaGraph3, stmt3, true);
            assertTrue(replicaGraph3.contains(stmt3));
            // make sure all graph listeners received an update
            assertTrue(numAdded1 >= 1);
            assertTrue(numAdded2 >= 1);
            assertTrue(numAdded3 >= 1);
            numAdded1 = numAdded2 = numAdded3 = numRemoved1 = numRemoved2 = numRemoved3 = 0;
            // ------------------------------------------------------------------
            // delete statements from all graphs
            // -make sure all graphs contain the same data
            // -make sure all statement listeners are notified
            replicaGraph1.remove(stmt3);
            replicaGraph2.remove(stmt2);
            replicaGraph3.remove(stmt1);
            anzoClient1.updateRepository();
            anzoClient2.updateRepository();
            anzoClient3.updateRepository();

            TestUtilities.waitForSize(replicaGraph1, 0);
            assertEquals(0, replicaGraph1.size());
            TestUtilities.waitForSize(replicaGraph2, 0);
            assertEquals(0, replicaGraph2.size());
            TestUtilities.waitForSize(replicaGraph3, 0);
            assertEquals(0, replicaGraph3.size());
            // make sure all statement listeners received an update
            assertTrue(numRemoved1 >= 1);
            assertTrue(numRemoved2 >= 1);
            assertTrue(numRemoved3 >= 1);
            numAdded1 = numAdded2 = numAdded3 = numRemoved1 = numRemoved2 = numRemoved3 = 0;
            // -----------------------------------------------------------------
            // add and delete statements in a single transaction
            // -make sure other graphs do not change until the transaction is committed
            // -make sure all graphs contain the same data
            // -make sure all statement listeners received events
            anzoClient1.begin();
            replicaGraph1.add(stmt2);
            assertTrue(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph3.contains(stmt2));
            replicaGraph1.add(stmt3);
            assertTrue(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            assertFalse(replicaGraph3.contains(stmt3));
            anzoClient1.commit();
            anzoClient1.updateRepository();
            TestUtilities.waitForStatement(replicaGraph2, stmt2, true);
            assertTrue(replicaGraph2.contains(stmt2));
            assertTrue(replicaGraph2.contains(stmt2));
            TestUtilities.waitForStatement(replicaGraph3, stmt2, true);
            assertTrue(replicaGraph3.contains(stmt2));
            assertTrue(replicaGraph3.contains(stmt2));
            // make sure all graph listeners received an update
            assertTrue(numAdded1 >= 2);
            assertTrue(numAdded2 >= 2);
            assertTrue(numAdded3 >= 2);
            numAdded1 = numAdded2 = numAdded3 = numRemoved1 = numRemoved2 = numRemoved3 = 0;
            // -----------------------------------------------------------------
            // add and delete statements in multiple transactions
            // -make sure other graphs do not change until the transaction is committed
            // -make sure all graphs contain the same data
            // -make sure all statement listeners received events
            anzoClient1.begin();
            replicaGraph1.clear();
            anzoClient1.commit();
            anzoClient1.updateRepository();
            numAdded1 = numAdded2 = numAdded3 = numRemoved1 = numRemoved2 = numRemoved3 = 0;
            TestUtilities.waitForStatement(replicaGraph2, stmt2, false);
            assertFalse(replicaGraph2.contains(stmt2));
            TestUtilities.waitForStatement(replicaGraph3, stmt2, false);
            assertFalse(replicaGraph3.contains(stmt2));

            anzoClient1.begin();
            replicaGraph1.add(stmt1);
            assertTrue(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph3.contains(stmt1));
            replicaGraph1.add(stmt2);
            assertTrue(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph3.contains(stmt2));
            anzoClient1.commit();
            anzoClient1.updateRepository();
            anzoClient2.begin();
            replicaGraph2.add(stmt3);
            assertTrue(replicaGraph2.contains(stmt3));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph3.contains(stmt3));
            anzoClient2.commit();
            anzoClient2.updateRepository();
            TestUtilities.waitForStatement(replicaGraph1, stmt1, true);
            assertTrue(replicaGraph1.contains(stmt1));
            TestUtilities.waitForStatement(replicaGraph2, stmt1, true);
            assertTrue(replicaGraph2.contains(stmt1));
            TestUtilities.waitForStatement(replicaGraph3, stmt1, true);
            assertTrue(replicaGraph3.contains(stmt1));
            TestUtilities.waitForStatement(replicaGraph1, stmt2, true);
            assertTrue(replicaGraph1.contains(stmt2));
            TestUtilities.waitForStatement(replicaGraph2, stmt2, true);
            assertTrue(replicaGraph2.contains(stmt2));
            TestUtilities.waitForStatement(replicaGraph3, stmt2, true);
            assertTrue(replicaGraph3.contains(stmt2));
            TestUtilities.waitForStatement(replicaGraph1, stmt3, true);
            assertTrue(replicaGraph1.contains(stmt3));
            TestUtilities.waitForStatement(replicaGraph2, stmt3, true);
            assertTrue(replicaGraph2.contains(stmt3));
            TestUtilities.waitForStatement(replicaGraph3, stmt3, true);
            assertTrue(replicaGraph3.contains(stmt3));
            // make sure all statement listeners received an update
            assertTrue(numAdded1 >= 3);
            assertTrue(numAdded2 >= 3);
            assertTrue(numAdded3 >= 3);
            numAdded1 = numAdded2 = numAdded3 = numRemoved1 = numRemoved2 = numRemoved3 = 0;
            assertTrue(!anzoClient1.getNamedGraphs().isEmpty());
            assertTrue(anzoClient1.getNamedGraphs().contains(GRAPH_URI));
            assertTrue(!anzoClient2.getNamedGraphs().isEmpty());
            assertTrue(anzoClient2.getNamedGraphs().contains(GRAPH_URI));
            assertTrue(!anzoClient3.getNamedGraphs().isEmpty());
            assertTrue(anzoClient3.getNamedGraphs().contains(GRAPH_URI));
            assertTrue(anzoClient1.getAllReplicaGraphsDataset().containsNamedGraph(GRAPH_URI));
            assertTrue(anzoClient2.getAllReplicaGraphsDataset().containsNamedGraph(GRAPH_URI));
            assertTrue(anzoClient3.getAllReplicaGraphsDataset().containsNamedGraph(GRAPH_URI));
            // ----------------------------------------------------------------------
            // close datasets
            anzoClient1.close();
            anzoClient2.close();
            anzoClient3.close();
            // -----------------------------------------------------------------------
            // make sure all replica graphs have been closed
            // closing the client should not close the graphs.
            //            assertTrue(replicaGraph1.isClosed());
            //            assertTrue(replicaGraph1.isClosed());
            //            assertTrue(replicaGraph1.isClosed());
            // -----------------------------------------------------------------------
            // make sure local dataset is empty
            assertTrue(anzoClient3.getAllReplicaGraphsDataset().getNamedGraphUris().isEmpty());
        } finally {
            if (anzoClient1 != null) {
                anzoClient1.close();
            }
            if (anzoClient2 != null) {
                anzoClient2.close();
            }
            if (anzoClient3 != null) {
                anzoClient3.close();
            }
        }
    }

    private static class NotificationHelperThread implements Runnable {

        int                   notificationCount;

        final List<Throwable> exceptions;

        String                containerName;

        Statement             stmt;

        AnzoClient            anzoClient = null;

        ClientGraph           replicaGraph;

        public NotificationHelperThread(String containerName, Statement stmtToAdd) {
            this.containerName = containerName;
            this.stmt = stmtToAdd;
            exceptions = new ArrayList<Throwable>();
            notificationCount = 0;

            initialize();
        }

        private void initialize() {

            try {
                anzoClient = new AnzoClient(TestUpdates.getDefaultClientConfiguration());
                anzoClient.connect();
                replicaGraph = anzoClient.getReplicaGraph(GRAPH_URI);
                anzoClient.updateRepository();
                assertNotNull(replicaGraph);

                replicaGraph.registerListener(new IStatementListener<INamedGraph>() {

                    public void statementsRemoved(INamedGraph source, Statement... s) {
                    }

                    public void statementsAdded(INamedGraph source, Statement... s) {
                        for (Statement stmt : s) {
                            assertNotNull(stmt);
                            notificationCount++;
                        }
                    }
                });
            } catch (Throwable e) {
                synchronized (exceptions) {
                    exceptions.add(e);
                }
            }
        }

        public void run() {
            try {
                replicaGraph.add(stmt);
                anzoClient.updateRepository();

                Condition condition = new Condition() {
                    @Override
                    public boolean check() {
                        return notificationCount >= 3;
                    }
                };
                TestUtilities.waitFor(condition);

                //                long start = System.currentTimeMillis();
                //                while (true) {
                //                    long duration = System.currentTimeMillis() - start;
                //                    if (duration > (1000 * 10)) {
                //                        throw new Exception(Thread.currentThread().getName() + " Timed out waiting for notification additions.");
                //                    }
                //                    if (notificationCount >= 3)
                //                        break;
                //                    Thread.sleep(100);
                //                }

            } catch (Throwable e) {
                System.err.println("had an exception!");
                e.printStackTrace();
                synchronized (exceptions) {
                    exceptions.add(e);
                }
            }
        }
    }

    /**
     * Test adding statements to three graphs with the same URIs backed by three different dataset services run in three different threads.
     * 
     * @throws Exception
     */
    public void a_testNotificationsWithThreeClientsAndImmediateReplicationMultiThreaded() throws Exception {
        numAdded1 = numAdded2 = numAdded3 = numRemoved1 = numRemoved2 = numRemoved3 = 0;
        AnzoClient anzoClient = null;
        try {
            anzoClient = new AnzoClient(getDefaultClientConfiguration());
            anzoClient.connect();
            anzoClient.reset(loadStatements("initialize.trig"), null);
        } finally {
            if (anzoClient != null)
                anzoClient.close();
        }
        final List<Throwable> exceptions = new LinkedList<Throwable>();

        NotificationHelperThread helper1 = new NotificationHelperThread("dataService1", stmt1);
        NotificationHelperThread helper2 = new NotificationHelperThread("dataService2", stmt2);
        NotificationHelperThread helper3 = new NotificationHelperThread("dataService3", stmt3);
        try {
            Thread thread1 = new Thread(helper1, helper1.containerName);
            Thread thread2 = new Thread(helper2, helper2.containerName);
            Thread thread3 = new Thread(helper3, helper3.containerName);

            thread1.setPriority(Thread.MAX_PRIORITY);
            thread2.setPriority(Thread.MAX_PRIORITY);
            thread3.setPriority(Thread.MAX_PRIORITY);
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();

            if (!(exceptions.size() == 0))
                throw new Exception(exceptions.get(0));

            assertTrue(helper1.replicaGraph.contains(stmt1));
            assertTrue(helper1.replicaGraph.contains(stmt2));
            assertTrue(helper1.replicaGraph.contains(stmt3));

            assertTrue(helper2.replicaGraph.contains(stmt1));
            assertTrue(helper2.replicaGraph.contains(stmt2));
            assertTrue(helper2.replicaGraph.contains(stmt3));

            assertTrue(helper3.replicaGraph.contains(stmt1));
            assertTrue(helper3.replicaGraph.contains(stmt2));
            assertTrue(helper3.replicaGraph.contains(stmt3));

        } finally {
            try {
                helper1.anzoClient.close();
            } catch (Throwable t) {
                exceptions.add(t);
            }
            try {
                helper2.anzoClient.close();
            } catch (Throwable t) {
                exceptions.add(t);
            }
            try {
                helper3.anzoClient.close();
            } catch (Throwable t) {
                exceptions.add(t);
            }
        }

        if (!(exceptions.size() == 0))
            throw new Exception(exceptions.get(0));
    }

    int numNotificationConnStateChanged = 0, numNotificationExceptions = 0;

    /**
     * Test notifications
     * 
     * @throws Exception
     */
    public void testNotifications() throws Exception {
        final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
        AnzoClient anzoClient1 = null;
        try {
            //
            // create DATASET SERVICE 1 (CLIENT 1)
            //
            anzoClient1 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);
            ClientGraph replicaGraph1 = anzoClient1.getReplicaGraph(GRAPH_URI);
            assertNotNull(replicaGraph1);
            numAdded1 = numRemoved1 = 0;
            replicaGraph1.registerListener(new IStatementListener<INamedGraph>() {

                public void statementsRemoved(INamedGraph source, Statement... stmts) {
                    for (Statement s : stmts) {
                        if (s.getNamedGraphUri().equals(GRAPH_URI))
                            numRemoved1++;
                    }
                }

                public void statementsAdded(INamedGraph source, Statement... stmts) {
                    for (Statement s : stmts) {
                        if (s.getNamedGraphUri().equals(GRAPH_URI))
                            numAdded1++;
                    }
                }
            });
            replicaGraph1.add(stmt1);
            assertEquals(0, numAdded1);
            anzoClient1.updateRepository();
            assertEquals(1, numAdded1);
        } finally {
            if (anzoClient1 != null)
                anzoClient1.close();
        }
    }

    /**
     * A utility method that extracts the revision number from the given metadata graph and returns it.
     * 
     * @param graph1
     * @return
     */
    private long getNamedGraphRevision(IAnzoGraph graph) {
        Long revision = null;
        if (graph.getMetadataGraph().contains(graph.getNamedGraphUri(), NamedGraph.revisionProperty, null)) {
            Iterator<Statement> ei = graph.getMetadataGraph().find(graph.getNamedGraphUri(), NamedGraph.revisionProperty, null).iterator();
            if (ei.hasNext()) {
                revision = (Long) StatementUtils.getNativeValue(((Literal) ei.next().getObject()));
            }
        }
        return revision;
    }

}
