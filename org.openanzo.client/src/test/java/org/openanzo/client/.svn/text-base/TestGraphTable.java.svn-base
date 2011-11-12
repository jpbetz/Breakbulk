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

import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;

/**
 * Unit tests for the GraphTable class.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TestGraphTable extends TestConfiguration {

    /**
     * Creates two client graphs, and puts a different graph URI in the graph table for each client graph.
     * 
     * Verifies that the GraphTable.get method returns the correct client graph for each graph URI.
     * 
     * Verifies that the reference count has been incremented twice for graph1 (one for the put and one for the get) by releasing it twice and checking the
     * results of the release call. Also verifies that get method returns null after the reference count reaches zero.
     * 
     * Last, verifies that graph2 is still in the table after graph1 is removed.
     * 
     * @throws Exception
     */
    public void testPutAndRelease() throws Exception {
        AnzoClient client = new AnzoClient(TestConfiguration.getBasicConfiguration());
        GraphTable table = new GraphTable(client);
        MemQuadStore quadStore = new MemQuadStore();
        AnzoClient anzoClient = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration("default", "123", "tcp://localhost", 61616, false));

        NamedGraph namedGraph1 = new NamedGraph(TestData.graph1);
        NamedGraph namedGraph2 = new NamedGraph(TestData.graph2);

        ClientGraph client1 = new ClientGraph(TestData.graph1, quadStore, namedGraph1, anzoClient, table);
        ClientGraph client2 = new ClientGraph(TestData.graph2, quadStore, namedGraph2, anzoClient, table);

        assertNull(table.get(TestData.graph1));

        table.put(TestData.graph1, client1);
        table.put(TestData.graph2, client2);

        assertEquals(client1, table.get(TestData.graph1));
        assertEquals(client2, table.get(TestData.graph2));

        assertEquals(GraphTable.ReleaseResult.OPEN, table.release(TestData.graph1));
        assertEquals(GraphTable.ReleaseResult.CLOSE_ALL, table.release(TestData.graph1));

        assertNull(table.get(TestData.graph1));

        assertEquals(client2, table.get(TestData.graph2));
    }
}
