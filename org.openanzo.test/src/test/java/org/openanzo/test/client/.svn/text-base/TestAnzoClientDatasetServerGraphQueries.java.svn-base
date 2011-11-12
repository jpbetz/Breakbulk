package org.openanzo.test.client;

import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.URI;

/**
 * Tests issuing local queries via the anzo client when given a dataset object filled with replica graphs.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class TestAnzoClientDatasetServerGraphQueries extends TestAnzoClientDatasetQueries {
    @Override
    protected INamedGraph getGraph(URI u) throws Exception {
        return this.anzoClient.getServerGraph(u);
    }
}
