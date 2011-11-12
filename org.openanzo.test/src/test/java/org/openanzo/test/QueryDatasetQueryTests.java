/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.test;

import org.openanzo.rdf.RDFFormat;

/**
 * Test dataset query
 */
public abstract class QueryDatasetQueryTests extends ProtocolDatasetQueryTests {

    /***
     * Test a simple SPARQL query against a named graph using FROM NAMED.
     * 
     * @throws Exception
     */
    public void testSimpleQueryWithNamedGraphInQuery() throws Exception {
        doTest(tests.get("from-named-1"));
    }

    /**
     * Test a query with a FROM DATASET clause that references 2 default graphs.
     * 
     * @throws Exception
     */
    public void testDataset1() throws Exception {
        doTest(tests.get("dataset-1"));
    }

    static {
        addQueryTest("from-named-1", RDFFormat.SPARQL, noGraphsSpecified, noGraphsSpecified);
        // dataset tets
        addQueryTest("dataset-1", RDFFormat.SPARQL, new String[] {}, new String[] {}, new String[] {});
    }
}
