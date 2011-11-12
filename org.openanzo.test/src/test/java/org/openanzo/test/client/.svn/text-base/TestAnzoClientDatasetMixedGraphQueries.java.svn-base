package org.openanzo.test.client;

import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.URI;

/**
 * Tests issuing local queries via the anzo client when given a dataset object filled with both replica and server graphs.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class TestAnzoClientDatasetMixedGraphQueries extends TestAnzoClientDatasetQueries {

    private int counter = 0;

    @Override
    protected INamedGraph getGraph(URI u) throws Exception {
        if (counter++ % 2 == 1) {
            return this.anzoClient.getServerGraph(u);
        } else {
            return this.anzoClient.getReplicaGraph(u);
        }
    }
}
