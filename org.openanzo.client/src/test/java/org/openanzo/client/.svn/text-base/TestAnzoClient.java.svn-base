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
package org.openanzo.client;

import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.utils.test.TestUtilities;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.impl.AskResult;
import org.openanzo.services.impl.Precondition;

/**
 * Tests the anzo client class.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class TestAnzoClient extends TestConfiguration {

    /**
     * Verifies inTransaction returns the correct response for the various possible states.
     * 
     * @throws Exception
     */
    public void testInTransaction() throws Exception {
        AnzoClient client = new AnzoClient(TestConfiguration.getBasicConfiguration());
        try {
            client.begin(Collections.<IPrecondition> emptySet());
            assertTrue(client.inTransaction());
            client.commit();
            assertFalse(client.inTransaction());
            client.begin(Collections.<IPrecondition> emptySet());
            assertTrue(client.inTransaction());
            client.abort();
            assertFalse(client.inTransaction());
        } finally {
            client.close();
        }
    }

    /**
     * verify a commit called with no begin is a no-op and does not throw an exception.
     * 
     * @throws Exception
     */
    public void testNoOpCommit() throws Exception {
        AnzoClient client = new AnzoClient(TestConfiguration.getBasicConfiguration());
        try {
            client.clear();
            client.commit();
        } finally {
            client.close();
        }
    }

    /**
     * verify an abort called with no begin is a no-op and does not throw an exception.
     * 
     * @throws Exception
     */
    public void testNoOpAbort() throws Exception {
        AnzoClient client = new AnzoClient(TestConfiguration.getBasicConfiguration());
        try {
            client.clear();

            boolean exceptionCought = false;
            try {
                client.abort();
            } catch (Exception e) {
                exceptionCought = true;
            }
            assertFalse(exceptionCought);
        } finally {
            client.close();
        }
    }

    /**
     * verifies that statements are added to and removed from the transaction proxy correctly for the following set of operations:
     * 
     * <pre>
     *   begin transaction
     *   add stmt2 (and verify)
     *   abort transaction
     *   (verify stmt2 is removed)
     *   
     *   
     *   begin transaction
     *   add stmt3 (and verify)
     *   commit transaction
     *   (verify stmt3 still exists)
     * </pre>
     * 
     * @throws Exception
     */
    public void testSimpleTransactionIsolation() throws Exception {
        AnzoClient client = new AnzoClient(TestConfiguration.getBasicConfiguration());

        //client.setNotificationEnabled(false);
        try {
            ClientGraph replicaGraph = client.getReplicaGraph(TestData.graph1);
            replicaGraph.add(TestData.stmt1);

            assertTrue(replicaGraph.contains(TestData.stmt1));
            assertFalse(replicaGraph.contains(TestData.stmt2));
            assertFalse(replicaGraph.contains(TestData.stmt3));

            client.begin();

            replicaGraph.add(TestData.stmt2);

            assertTrue(replicaGraph.contains(TestData.stmt1));
            assertTrue(replicaGraph.contains(TestData.stmt2));
            assertFalse(replicaGraph.contains(TestData.stmt3));

            client.abort();

            assertTrue(replicaGraph.contains(TestData.stmt1));
            assertFalse(replicaGraph.contains(TestData.stmt2));
            assertFalse(replicaGraph.contains(TestData.stmt3));

            client.begin();

            replicaGraph.add(TestData.stmt3);

            assertTrue(replicaGraph.contains(TestData.stmt1));
            assertFalse(replicaGraph.contains(TestData.stmt2));
            assertTrue(replicaGraph.contains(TestData.stmt3));

            client.commit();

            assertTrue(replicaGraph.contains(TestData.stmt1));
            assertFalse(replicaGraph.contains(TestData.stmt2));
            assertTrue(replicaGraph.contains(TestData.stmt3));
        } finally {
            client.close();
        }
    }

    /**
     * Verifies that a list of three non-nested transactions all persist correctly.
     * 
     * @throws Exception
     */
    public void testPersistTransactions() throws Exception {
        AnzoClient client1 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());
        //client.setNotificationEnabled(false);
        try {
            client1.clear();

            client1.begin();
            ClientGraph replicaGraph = client1.getReplicaGraph(TestData.graph2);
            replicaGraph.add(TestData.stmt2);
            client1.commit();

            client1.begin();
            replicaGraph.add(TestData.stmt3);
            client1.commit();

            client1.begin();
            replicaGraph.add(TestData.stmt4);
            client1.commit();
        } finally {
            client1.close();
        }

        AnzoClient client2 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());
        try {
            assertEquals(3, client2.transactionQueue.committedTransactions.size());

            ClientGraph graph = client2.getReplicaGraph(TestData.graph2);
            assertTrue(graph.contains(TestData.stmt2));
            assertTrue(graph.contains(TestData.stmt3));
            assertTrue(graph.contains(TestData.stmt4));
        } finally {
            client2.close();
        }

    }

    /**
     * Verifies that the following nested transactions persist correctly:
     * 
     * <pre>
     *  (T1)
     *   | add stmt2
     *   |- (T2)
     *   |   add stmt3
     *   |- (T3)
     *       | add stmt4
     *       |- (T4)
     *           add stmt5
     * 
     * </pre>
     * 
     * @throws Exception
     */
    public void testPersistTransactionTree() throws Exception {
        AnzoClient client1 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());
        //client.setNotificationEnabled(false);
        try {
            client1.clear();

            client1.begin();
            ClientGraph replicaGraph = client1.getReplicaGraph(TestData.graph2);
            replicaGraph.add(TestData.stmt2);
            client1.begin();
            replicaGraph.add(TestData.stmt3);
            client1.commit();
            client1.begin();
            replicaGraph.add(TestData.stmt4);
            client1.begin();
            replicaGraph.add(TestData.stmt5);
            client1.commit();
            client1.commit();
            client1.commit();
        } finally {
            client1.close();
        }

        AnzoClient client2 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());
        try {
            assertEquals(1, client2.transactionQueue.committedTransactions.size());

            client2.transactionQueue.committedTransactions.get(0);

            ClientGraph graph = client2.getReplicaGraph(TestData.graph2);
            assertTrue(graph.contains(TestData.stmt2));
            assertTrue(graph.contains(TestData.stmt3));
            assertTrue(graph.contains(TestData.stmt4));
            assertTrue(graph.contains(TestData.stmt5));
        } finally {
            client2.close();
        }
    }

    /**
     * Verifies that all the fields of a precondition are persisted correctly.
     * 
     * @throws Exception
     */
    public void testPersistPrecondition() throws Exception {
        String preconditionQuery = "ASK WHERE (?s ?p ?o)";

        AnzoClient client1 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());
        //client.setNotificationEnabled(false);
        try {
            client1.clear();
            Precondition precondition = new Precondition(Collections.singleton(TestData.graph1), Collections.singleton(TestData.graph2), preconditionQuery, true);

            client1.begin(Collections.<IPrecondition> singleton(precondition));
            ClientGraph replicaGraph = client1.getReplicaGraph(TestData.graph2);
            replicaGraph.add(TestData.stmt2);
            client1.commit();
        } finally {
            client1.close();
        }
        AnzoClient client2 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());
        try {
            Transaction transaction = client2.transactionQueue.committedTransactions.get(0);
            Set<IPrecondition> preconditions = transaction.preconditions;
            assertNotNull(preconditions);
            Iterator<IPrecondition> iterator = preconditions.iterator();
            assertTrue(iterator.hasNext());
            IPrecondition next = iterator.next();

            assertEquals(preconditionQuery, next.getQuery());
            assertTrue(next.getDefaultGraphUris().contains(TestData.graph1));
            assertTrue(next.getNamedGraphUris().contains(TestData.graph2));
            AskResult result = (AskResult) next.getResult();
            assertTrue(result.getResultValue());
        } finally {
            client2.close();
        }
    }

    /**
     * Verifies that replicated Quads are persisted correctly.
     * 
     * See also testPersistTransaction, which verifies Quads that have not been replicated (and are in the transaction queue) are persisted correctly.
     * 
     * @throws Exception
     */
    public void testPersistQuad() throws Exception {
        AnzoClient client1 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());
        //client.setNotificationEnabled(false);
        try {
            client1.clear();

            ClientGraph graph = client1.getReplicaGraph(TestData.graph1);
            graph.add(TestData.stmt1);
            client1.quadStore.add(TestData.stmt1);
        } finally {
            client1.close();
        }
        AnzoClient client2 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());
        //client2.setNotificationEnabled(false);
        try {
            ClientGraph graph = client2.getReplicaGraph(TestData.graph1);
            assertTrue(graph.contains(TestData.stmt1));
        } finally {
            client2.close();
        }
    }

    /**
     * Try to create an anzo client with null properties.
     * 
     * @throws Exception
     */
    public void testWithNullProperties() throws Exception {
        AnzoClient client = null;
        try {

            boolean exceptionThrown = false;
            try {
                client = new AnzoClient(null);
            } catch (Exception e) {
                assertTrue(e instanceof RuntimeException);
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
     * Test with invalid port numbers.
     * 
     * @throws Exception
     */
    /* Not sure why these test should pass if we aren't actually trying to connect.
    public void testWithInvalidPortNumber_65536() throws Exception {
        AnzoClient client = null;
        try {
            boolean threwException = false;
            try {
                client = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration("default", "123", "tcp://localhost", 65536));
            } catch (Exception e) {
                threwException = true;
            } finally {
                if (client != null)
                    client.close();
            }
            assertTrue(threwException);
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
    */

    /**
     * Verifies that if the model service port is set to "0", which is not a valid port number, that an exception is thrown.
     */
    /* Not sure why these test should pass if we aren't actually trying to connect.
    public void testWithInvalidPortNumber_0() throws Exception {
        AnzoClient client = null;
        try {
            boolean threwException = false;
            try {
                client = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration("default", "123", "tcp://localhost", 0));
            } catch (Exception e) {
                threwException = true;
            } finally {
                if (client != null)
                    client.close();
            }
            assertTrue(threwException);
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
    */

    /**
     * Verifies that if the model service port is set to 8080, which is a valid port number, that no exception is thrown.
     * 
     * @throws Exception
     */
    public void testWithValidPortNumber() throws Exception {
        AnzoClient client = null;
        try {
            boolean threwException = false;
            try {
                client = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration("default", "123", "tcp://localhost", 61616, false));
            } catch (Exception e) {
                threwException = true;
            } finally {
                if (client != null)
                    client.close();
            }
            assertFalse(threwException);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test with invalid hostname: "test.garbage".
     * 
     * @throws Exception
     */
    public void testWithInvalidHostname() throws Exception {
        AnzoClient client = null;
        boolean threwException = false;
        try {
            client = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration("default", "123", "tcp://test.garbage", 61616, false));
            client.updateRepository();
        } catch (Exception e) {
            threwException = true;
        } finally {
            assertTrue(threwException);
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Make sure an exception is thrown if an attempt is made to create more than one client that uses the same container name, meaning they would be using the
     * persistent database tables, which is not allowed.
     * 
     * @throws Exception
     */
    public void testIllegalSharedDatabase() throws Exception {
        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {
            AnzoException exception = null;
            try {
                Properties properties = TestUtilities.getProperties();
                AnzoClientProperties.setPersistenceEnabled(properties, true);
                client1 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());
                client2 = new AnzoClient(TestConfiguration.getPersistenceConfiguration());

            } catch (AnzoException e) {
                exception = e;
            }
            assertNotNull(exception);
        } finally {
            if (client1 != null)
                client1.close();
            if (client2 != null)
                client2.close();
        }
    }

    //    /**
    //     * Test with invalid hostname: "123".
    //     */
    //    public void testWithInvalidHostname_Number() throws Exception {
    //        AnzoClient client = null;
    //        try {
    //            Properties props = TestUtilities.getProperties();
    //
    //            ServicesProperties.setTransportType(props, "WS");
    //            ModelServiceProperties.setHost(props, "123");
    //            client = new AnzoClient(props);
    //
    //            boolean threwException = false;
    //            try {
    //                client.replicate();
    //            } catch (Exception e) {
    //                threwException = true;
    //            }
    //            assertTrue(threwException);
    //        } finally {
    //            if (client != null) {
    //                client.close();
    //            }
    //        }
    //    }

}
