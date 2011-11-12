/*******************************************************************************
 * Copyright (c) 2000, 2007-2008 IBM Corporation,Cambridge Semantics Incorporated and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.openanzo.test.client.TestAnzoClientDatasetMixedGraphQueries;
import org.openanzo.test.client.TestAnzoClientDatasetReplicaGraphQueries;
import org.openanzo.test.client.TestAnzoClientDatasetServerGraphQueries;
import org.openanzo.test.client.TestAnzoClientReplicaGraphReplicaQueries;
import org.openanzo.test.client.TestAnzoClientServerGraphReplicaQueries;
import org.openanzo.test.client.TestAnzoClientServerQueries;

/**
 * Convenience suite that groups together integrations tests to exercise database queries. It's just here for convenience during development.
 */
public class QueryIntegrationTestSuite extends TestSuite {
    /**
     * Run all the query tests
     * 
     * @return the query test suite
     */
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(TestAnzoClientDatasetReplicaGraphQueries.class);
        suite.addTestSuite(TestAnzoClientDatasetMixedGraphQueries.class);
        suite.addTestSuite(TestAnzoClientDatasetServerGraphQueries.class);
        suite.addTestSuite(TestAnzoClientReplicaGraphReplicaQueries.class);
        suite.addTestSuite(TestAnzoClientServerGraphReplicaQueries.class);
        suite.addTestSuite(TestAnzoClientServerQueries.class);
        return suite;
    }
}
