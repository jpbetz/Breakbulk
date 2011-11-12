/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.openanzo.test.TestEncryptedTokenAuthorizationBlocksServletAccess;
import org.openanzo.test.client.TestAnzoClientDatasetMixedGraphQueries;
import org.openanzo.test.client.TestAnzoClientDatasetReplicaGraphQueries;
import org.openanzo.test.client.TestAnzoClientDatasetServerGraphQueries;
import org.openanzo.test.client.TestAnzoClientIntegration;
import org.openanzo.test.client.TestAnzoClientReplicaGraphReplicaQueries;
import org.openanzo.test.client.TestAnzoClientServerGraphReplicaQueries;
import org.openanzo.test.client.TestAnzoClientServerQueries;
import org.openanzo.test.client.TestAuthorization;
import org.openanzo.test.client.TestBinaryStore;
import org.openanzo.test.client.TestCommands;
import org.openanzo.test.client.TestComplicatedInputs;
import org.openanzo.test.client.TestDatasetBasicGraphQueries;
import org.openanzo.test.client.TestDatasets;
import org.openanzo.test.client.TestDateTime;
import org.openanzo.test.client.TestIntegratedTextQueries;
import org.openanzo.test.client.TestQueries;
import org.openanzo.test.client.TestReplicaGraphs;
import org.openanzo.test.client.TestReplication;
import org.openanzo.test.client.TestSemanticServiceExecution;
import org.openanzo.test.client.TestServerGraphs;
import org.openanzo.test.client.TestTransactions;
import org.openanzo.test.client.TestUpdates;
import org.openanzo.test.client.cli.TestCommandLineInterface;

/**
 * Convenience suite that groups together all of the regression/integration tests run by the Anzo Maven build. Note that this is kept up to date manually. See
 * the openanzo-test/pom.xml to make sure this list of tests is up to date.
 * 
 * @author Jordi A. Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 */
public class BuildIntegrationTestSuite {
    /**
     * Run all the test
     * 
     * @return Test suite
     */
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(TestAnzoClientDatasetReplicaGraphQueries.class);
        suite.addTestSuite(TestAnzoClientDatasetMixedGraphQueries.class);
        suite.addTestSuite(TestAnzoClientDatasetServerGraphQueries.class);
        suite.addTestSuite(TestAnzoClientIntegration.class);
        suite.addTestSuite(TestAnzoClientReplicaGraphReplicaQueries.class);
        suite.addTestSuite(TestAnzoClientServerGraphReplicaQueries.class);
        suite.addTestSuite(TestAnzoClientServerQueries.class);
        suite.addTestSuite(TestBinaryStore.class);
        //suite.addTestSuite(TestAnzoJsDohRegression.class);
        suite.addTestSuite(TestAuthorization.class);
        suite.addTestSuite(TestCommandLineInterface.class);
        suite.addTestSuite(TestCommands.class);
        suite.addTestSuite(TestComplicatedInputs.class);
        suite.addTestSuite(TestDatasetBasicGraphQueries.class);
        suite.addTestSuite(TestDatasets.class);
        suite.addTestSuite(TestDateTime.class);
        //suite.addTestSuite(TestEncryptedTokenAuthenticationRegression.class);
        suite.addTestSuite(TestEncryptedTokenAuthorizationBlocksServletAccess.class);
        suite.addTestSuite(TestIntegratedTextQueries.class);
        suite.addTestSuite(TestQueries.class);
        suite.addTestSuite(TestReplicaGraphs.class);
        suite.addTestSuite(TestReplication.class);
        suite.addTestSuite(TestSemanticServiceExecution.class);
        suite.addTestSuite(TestServerGraphs.class);
        suite.addTestSuite(TestTransactions.class);
        suite.addTestSuite(TestUpdates.class);
        return suite;
    }
}
