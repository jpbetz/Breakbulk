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
import org.openanzo.rdf.Constants.GRAPHS;

/**
 *
 */
abstract public class ServerQueryTests extends QueryDatasetQueryTests {
    /***
     * Test a simple SPARQL query against all graphs.
     * 
     * @throws Exception
     */
    public void testSimpleQueryAllNamedGraphs() throws Exception {
        doTest(tests.get("all-named-graphs-1"));
    }

    /***
     * Test a more complex SPARQL query against all named graphs.
     * 
     * @throws Exception
     */
    public void testLinkedQueryPattern() throws Exception {
        doTest(tests.get("linked-query-pattern"));
    }

    /***
     * Test a more complex SPARQL query against all named graphs with repetitions in statements (the same statements exist in multiple graphs).
     * 
     * @throws Exception
     */
    public void testGraphsWithRepetitions() throws Exception {
        doTest(tests.get("graphs-with-repetitions"));
    }

    /**
     * Test that the same content appearing multiple times in a default graph does not increase result cardinalityies
     * 
     * @throws Exception
     */
    public void testMultipleOverlappingGraphsInDefaultGraph() throws Exception {
        doTest(tests.get("multiple-overlapping-graphs-in-default-graph"));
    }

    /**
     * Test a query with named dataset specified in protocol - 2 default graphs, query checks named graphs (no results)
     * 
     * @throws Exception
     */
    public void testDataset3() throws Exception {
        doTest(tests.get("dataset-3"));
    }

    /**
     * Test the list:member predicate
     * 
     * @throws Exception
     */
    public void testListQuery() throws Exception {
        // doTest(tests.get("list-query"));
    }

    /**
     * Test the preds:textlike functional predicate with two variable binding to the text string
     * 
     * @throws Exception
     */
    //public void testTextLike1() throws Exception {
    //   doTest(tests.get("textlike-1"));
    //}

    /**
     * Test the preds:textlike functional predicate
     * 
     * @throws Exception
     */
    // public void testTextLike2() throws Exception {
    //    doTest(tests.get("textlike-2"));
    // }

    /**
     * Test a leading OPTIONAL in conjunction with the textmatch functional predicate. See http://www.openanzo.org/projects/openanzo/ticket/316 .
     * 
     * @throws Exception
     */
    public void testTextMatchAndOptional1() throws Exception {
        doTest(tests.get("textmatch-and-optional-1"));
    }

    /**
     * Test a leading OPTIONAL (order dependence of optionals). See http://www.openanzo.org/projects/openanzo/ticket/316 .
     * 
     * @throws Exception
     */
    public void testOptionalBare() throws Exception {
        doTest(tests.get("optional-bare"));
    }

    /**
     * Test a former NPE condition in the Glitter rewriters.
     * 
     * @throws Exception
     */
    public void testTextmatchAndUnionNPE() throws Exception {
        doTest(tests.get("textmatch-and-union-npe"));
    }

    /**
     * Test that 3-branch UNIONs properly join with other graph patterns.
     * 
     * @throws Exception
     */
    public void testUnionThreeBranch() throws Exception {
        doTest(tests.get("union-three-branch"));
    }

    static protected final String[] allNamedGraphs = new String[] { GRAPHS.ALL_NAMEDGRAPHS.toString() };
    static {
        addQueryTest("all-named-graphs-1", RDFFormat.SPARQL, noGraphsSpecified, allNamedGraphs);
        addQueryTest("linked-query-pattern", RDFFormat.SPARQL, allNamedGraphs, allNamedGraphs);
        addQueryTest("graphs-with-repetitions", RDFFormat.SPARQL, noGraphsSpecified, allNamedGraphs);
        addQueryTest("multiple-overlapping-graphs-in-default-graph", RDFFormat.SPARQL, allNamedGraphs, noGraphsSpecified);
        addQueryTest("list-query", RDFFormat.SPARQL, new String[] { "http://example.org/list-query" }, noGraphsSpecified);
        addQueryTest("dataset-3", RDFFormat.SPARQL, noGraphsSpecified, noGraphsSpecified, new String[] { "http://example.org/dataset" });
        addQueryTest("textlike-1", RDFFormat.SPARQL, noGraphsSpecified, new String[] { "http://example.org/textlike-1" });
        addQueryTest("textlike-2", RDFFormat.SPARQL, noGraphsSpecified, new String[] { "http://example.org/textlike-2" });
        addQueryTest("textmatch-and-optional-1", RDFFormat.SPARQL);
        addQueryTest("optional-bare", RDFFormat.SPARQL);
        addQueryTest("textmatch-and-union-npe", RDFFormat.SPARQL);
        addQueryTest("union-three-branch", RDFFormat.SPARQL);
    }

}
