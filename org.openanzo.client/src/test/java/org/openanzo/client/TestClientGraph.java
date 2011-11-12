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

import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;

/**
 * Unit tests of the ClientGraph class.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TestClientGraph extends TestConfiguration {

    /**
     * For a replica graph, verify a metadata graph URI matches what the UriGenerator creates.
     * 
     * @throws Exception
     */
    public void testMetadataGraph() throws Exception {
        AnzoClient client = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration("default", "123", "tcp://localhost", 61616, false));
        //client.setNotificationEnabled(false);
        try {
            ClientGraph clientGraph = client.getReplicaGraph(TestData.graph1);
            assertEquals(TestData.graph1, clientGraph.getNamedGraphUri());
            assertEquals(UriGenerator.generateMetadataGraphUri(TestData.graph1), clientGraph.getMetadataGraph().getNamedGraphUri());
        } finally {
            client.close();
        }
    }

    /**
     * Check that the when a ClientGraph is closed that the trackers for that ClientGraph are marked for deletion.
     * 
     * See testClearTrackers for details about what trackers are marked as deleted.
     * 
     * @throws Exception
     */
    public void testCloseGraph() throws Exception {
        AnzoClient client = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration("default", "123", "tcp://localhost", 61616, false));
        try {
            ClientGraph clientGraph = client.getReplicaGraph(TestData.graph1);
            clientGraph.close();
        } finally {
            client.close();
        }
    }
}
