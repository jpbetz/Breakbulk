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

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;

/**
 * Test dataset queries
 */
public abstract class ProtocolDatasetQueryTests extends QueryTestSuiteBase {

    @Override
    abstract protected QueryResults executeQuery(Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI base) throws AnzoException;

    abstract protected void doTest(QueryTest test) throws Exception;

    /***
     * Test a simple SPARQL query against the default graph.
     *
     * @throws Exception
     */
    public void testSimpleQueryDefaultGraph() throws Exception {
        doTest(tests.get("default1"));
    }

    /***
     * Test a SPARQL query with a single named graph and a complex FILTER criteria.
     *
     * @throws Exception
     */
    public void testComplexFilter1NamedGraph() throws Exception {
        doTest(tests.get("complex-filter1"));
    }

    /**
     * Test a SPARQL query with multiple optionals.
     *
     * @throws Exception
     */
    public void testMultiOptionalQuery() throws Exception {
        doTest(tests.get("multi-optional"));
    }

    /**
     * Test a regex against a string cast of a URI.
     *
     * @throws Exception
     */
    public void testFilterURIQuery() throws Exception {
        doTest(tests.get("filter-uri"));
    }

    /**
     * Test the isURI SPARQL builtin.
     *
     * @throws Exception
     */
    public void testFilterIsURIQuery() throws Exception {
        doTest(tests.get("filter-isuri"));
    }

    /**
     * Test the isURI SPARQL builtin.
     *
     * @throws Exception
     */
    public void testFilterIsURI2Query() throws Exception {
        doTest(tests.get("filter-isuri2"));
    }

    /***
     * Test a simple SPARQL query against a named graph.
     *
     * @throws Exception
     */
    public void testSimpleQueryWithNamedGraph() throws Exception {
        doTest(tests.get("named-graph-1"));
    }

    /**
     * Test two named graphs with answers coming from each.
     *
     * @throws Exception
     */
    public void testTwoNamedGraphs() throws Exception {
        doTest(tests.get("two-named-graphs"));
    }

    /**
     * Test a query with several OPTIONALs.
     *
     * @throws Exception
     */
    public void testOptionalQuery() throws Exception {
        doTest(tests.get("optional-query"));
    }

    /**
     * Test a query that involves attribute retrieval branching off a resource (star-shaped)
     *
     * @throws Exception
     */
    public void testExtraTriplesAspect() throws Exception {
        doTest(tests.get("extra-triples-aspect"));
    }

    /**
     * Tests that a node (resource) not in the database does not make a whole query fail if it occurs in an OPTIONAL.
     *
     * @throws Exception
     */
    public void testNonexistentNode() throws Exception {
        doTest(tests.get("nonexistent-node"));
    }

    /**
     * Tests that a graph URI that occurs in the contents of the graph and in an optional part of the query is properly selected to be used in joining patterns
     * even if not projected out of the query
     *
     * @throws Exception
     */
    public void testGraphUriInGraphContentsOptional() throws Exception {
        doTest(tests.get("graph-uri-in-graph-contents-optional"));
    }

    /**
     * Tests that a graph URI that occurs in the contents of the graph and in a required triple pattern in the query is properly selected to be used in joining
     * bindings even if not projected out of the query
     *
     * @throws Exception
     */
    public void testGraphUriInGraphContents() throws Exception {
        doTest(tests.get("graph-uri-in-graph-contents"));
    }

    /**
     * Tests that a graph URI that occurs in the contents of the graph and in a required triple pattern that will be seen as an "extra" triple pattern
     * (attribute retrieving triple pattern) is properly selected to be used in joining bindings even if not projected out of the query
     *
     * @throws Exception
     */
    public void testGraphUriInGraphContentsExtra() throws Exception {
        doTest(tests.get("graph-uri-in-graph-contents-extra"));
    }

    /**
     * Tests that a GRAPH clause's patterns must all match from the same graph.
     *
     * @throws Exception
     */
    public void testRegularAndExtraTriplePatterns() throws Exception {
        doTest(tests.get("regular-and-extra-triple-patterns"));
    }

    /**
     * Tests the query and error given here: http://groups.google.com/group/openanzo/browse_thread/thread/c1279c3f71729f5e
     *
     * @throws Exception
     */
    public void testNullPointerException() throws Exception {
        doTest(tests.get("npe-test-1"));
    }

    /**
     * Test a query with named dataset specified in protocol
     *
     * @throws Exception
     */
    public void testDataset1Protocol() throws Exception {
        doTest(tests.get("dataset-1-protocol"));
    }

    /**
     * Test a query with named dataset specified in protocol with 2 named graphs
     *
     * @throws Exception
     */
    public void testDataset2() throws Exception {
        doTest(tests.get("dataset-2"));
    }

    /**
     * Tests a query with named dataset - 2 default graphs and 2 named graphs
     *
     * @throws Exception
     */
    public void testDataset4() throws Exception {
        doTest(tests.get("dataset-4"));
    }

    /**
     * Tests a query with a named dataset and explicit default and named graphs
     *
     * @throws Exception
     */
    public void testDataset5() throws Exception {
        doTest(tests.get("dataset-5"));
    }

    /**
     * Tests a projection of COUNT(DISTINCT *) and nothing else.
     *
     * @throws Exception
     */
    public void testCountDistinctStar() throws Exception {
        doTest(tests.get("count-distinct-star"));
    }

    /**
     * Tests a projection of ?s COUNT(DISTINCT *) with a GROUP BY ?s
     *
     * @throws Exception
     */
    public void testCountDistinctStarAndVarWithGroupBy() throws Exception {
        doTest(tests.get("count-distinct-star-and-var-with-group-by"));
    }

    /**
     * Test a selected expression which is a constant math expression.
     *
     * @throws Exception
     */
    public void testExpressionMathConstant() throws Exception {
        doTest(tests.get("expression-math-constant"));
    }

    /**
     * Test a selected expression which is a math expression with variables as arguments.
     *
     * @throws Exception
     */
    public void testExpressionMathVariables() throws Exception {
        doTest(tests.get("expression-math-variables"));
    }

    /**
     * Test a selected expression which uses builtin functions with variables as arguments
     *
     * @throws Exception
     */
    public void testExpressionBuiltinFunction1() throws Exception {
        doTest(tests.get("expression-builtin-function-1"));
    }

    /**
     * Test a selected expression which combined scalar and aggregate functions.
     *
     * @throws Exception
     */
    public void testExpressionAggregateAndScalar() throws Exception {
        doTest(tests.get("expression-aggregate-and-scalar"));
    }

    /**
     * Test an order by clause that orders over valid xsd:dateTime typed literals. See http://www.openanzo.org/projects/openanzo/ticket/438
     *
     * @throws Exception
     */
    public void testOrderByDateTime() throws Exception {
        doTest(tests.get("order-by-datetime"));
    }

    /**
     * Tests filtering based on a dateTime comparison.
     *
     * @throws Exception
     */
    public void testFilterByComparisonOfDateTime() throws Exception {
        doTest(tests.get("filter-by-datetime"));
    }

    /**
     * Tests that using an invalid dateTime literal does not cause an exception but the invalid solution isn't included.
     *
     * @throws Exception
     */
    public void testInvalidDateTimeInFilterIsAllowed() throws Exception {
        doTest(tests.get("invalid-datetime"));
    }

    /**
     * Tests that using an invalid dateTime literal does not cause an exception but the invalid solution isn't included.
     *
     * @throws Exception
     */
    public void testInvalidDateTimeInOrderIsAllowed() throws Exception {
        doTest(tests.get("invalid-datetime-orderby"));
    }

    /**
     * Tests proper sorting via ORDER BY. See ticket http://www.openanzo.org/projects/openanzo/ticket/469
     *
     * @throws Exception
     */
    public void testOrderByWithCount() throws Exception {
        doTest(tests.get("order-by-with-count"));
    }

    /**
     * Tests a basic SPARQL CONSTRUCT query.
     *
     * @throws Exception
     */
    public void testConstruct1() throws Exception {
        doTest(tests.get("construct-1"));
    }

    /**
     * Tests a basic SPARQL CONSTRUCT query with some unbound triples.
     *
     * @throws Exception
     */
    public void testConstruct2() throws Exception {
        doTest(tests.get("construct-2"));
    }

    /**
     * Tests whether ordering works correctly with a non-projected variable. See open anzo bug #517
     *
     * @throws Exception
     */
    public void testOrderByNonProjectedVariable() throws Exception {
        doTest(tests.get("order-by-non-projected-variable"));
    }

    /**
     * Tests whether ordering with unbound values works correctly.
     *
     * @throws Exception
     */
    public void testOrderByWithUnboundValues() throws Exception {
        doTest(tests.get("order-by-with-unbound-values"));
    }

    /**
     * Tests whether ordering with unbound values works correctly.
     *
     * @throws Exception
     */
    public void testOrderByWithUnboundValuesAsMax() throws Exception {
        doTest(tests.get("order-by-with-unbound-values-as-max"));
    }

    /**
     * Tests the datepart function.
     *
     * @throws Exception
     */
    public void testDatePart() throws Exception {
        doTest(tests.get("datepart"));
    }

    /**
     * Tests the datepart function.
     *
     * @throws Exception
     */
    public void testTimePart() throws Exception {
        doTest(tests.get("timepart"));
    }

    /**
     * Tests whether a comparison with an xsd:integer succeeds for various other numeric types as per expected numeric promotion rules.
     *
     * @throws Exception
     */
    public void testNumericCompare1() throws Exception {
        doTest(tests.get("numeric-compare-1"));
    }

    /**
     * Tests overloaded addition (+) for datetimes and dates + duration.
     *
     * @throws Exception
     */
    public void testDateTimeAdd1() throws Exception {
        doTest(tests.get("datetime-add-1"));
    }

    /**
     * Tests that a nice error happens when adding a literal with invalid duration value.
     *
     * @throws Exception
     */
    public void testDateTimeAddInvalidLiteral() throws Exception {
        doTest(tests.get("datetime-add-invalid-literal"));
    }

    /**
     * Tests the partitionIndex function with xsd:integer data.
     *
     * @throws Exception
     */
    public void testPartitionIndexInts() throws Exception {
        doTest(tests.get("partitionindex-ints"));
    }

    /**
     * Tests the partitionIndex function with xsd:double data.
     *
     * @throws Exception
     */
    public void testPartitionIndexDoubles() throws Exception {
        doTest(tests.get("partitionindex-doubles"));
    }

    /**
     * Tests the partitionIndex function with mixed numeric data.
     *
     * @throws Exception
     */
    public void testPartitionIndexMixed() throws Exception {
        doTest(tests.get("partitionindex-mixed"));
    }

    /**
     * Tests the partitionIndex function with xsd:dateTime's
     *
     * @throws Exception
     */
    public void testPartitionIndexDatetimes() throws Exception {
        doTest(tests.get("partitionindex-datetimes"));
    }

    /**
     * Tests that an appropriate exception is thrown when an argument to the partitionIndex function has an invalid lexical form.
     *
     * @throws Exception
     */
    public void testPartitionIndexDatetimesInvalidLiteralArgument() throws Exception {
        doTest(tests.get("partitionindex-datetimes-invalid-literal-argument"));
    }

    /**
     * Tests the that group by clauses can refer to calculated values from the SELECT list
     *
     * @throws Exception
     */
    public void testGroupByAliasedVariable() throws Exception {
        doTest(tests.get("group-by-aliased-variable"));
    }

    /**
     * tests assignments with functions applied to variables from BGPs
     *
     * @throws Exception
     */
    public void testLetFunctionOnBindings() throws Exception {
        doTest(tests.get("let-function-on-bindings"));
    }

    /**
     * tests multiple assignments in one LET expression
     *
     * @throws Exception
     */
    public void testLetMultiple() throws Exception {
        doTest(tests.get("let-multiple"));
    }

    /**
     * tests assignments to the same variable that was bound via BGP matching
     *
     * @throws Exception
     */
    public void testLetSameVariable() throws Exception {
        doTest(tests.get("let-same-variable"));
    }

    /**
     * tests an assignment attached to multiple rows
     *
     * @throws Exception
     */
    public void testLetSimpleMultiple() throws Exception {
        doTest(tests.get("let-simple-multiple"));
    }

    /**
     * tests a basic assignment
     *
     * @throws Exception
     */
    public void testLetSimple() throws Exception {
        doTest(tests.get("let-simple"));
    }

    /**
     * tests assignments correlated with union branches
     *
     * @throws Exception
     */
    public void testLetTaggedUnion() throws Exception {
        doTest(tests.get("let-tagged-union"));
    }

    /**
     * tests assignments that use aggregate functions within unions (not that useful)
     *
     * @throws Exception
     */
    public void testLetUnionAggregate() throws Exception {
        doTest(tests.get("let-union-aggregate"));
    }

    /**
     * tests assignments to the same variable twice (positive)
     *
     * @throws Exception
     */
    public void testLetVariableAssignedTwice() throws Exception {
        doTest(tests.get("let-variable-assigned-twice"));
    }

    /**
     * tests subquery being used for limit per resource
     *
     * @throws Exception
     */
    public void testSubqueryLPR() throws Exception {
        doTest(tests.get("subquery-lpr"));
    }

    /**
     * tests group_concat with the default separator
     *
     * @throws Exception
     */
    public void testGroupConcatDefault() throws Exception {
        doTest(tests.get("group-concat-default"));
    }

    /**
     * tests group_concat with a specified separator
     *
     * @throws Exception
     */
    public void testGroupConcatSeparator() throws Exception {
        doTest(tests.get("group-concat-separator"));
    }

    /**
     * tests construct with GRAPH in the template
     *
     * @throws Exception
     */
    public void testConstructGraph() throws Exception {
        doTest(tests.get("construct-graph"));
    }

    /**
     * test SELECT DISTINCT on URIs
     *
     * @throws Exception
     */
    public void testSelectDistinctUri() throws Exception {
        doTest(tests.get("select-distinct-uri"));
    }

    /**
     * test partitionIndex with xsd:time's
     *
     * @throws Exception
     */
    public void testPartitionIndexTimes() throws Exception {
        doTest(tests.get("partitionindex-times"));
    }

    /**
     * test partitionIndex with a negative duration and datetime's
     *
     * @throws Exception
     */
    public void testPartitionIndexDatetimesNegativeDuration() throws Exception {
        doTest(tests.get("partitionindex-datetimes-negative-duration"));
    }

    /**
     * Test glitter local name function
     *
     * @throws Exception
     */
    public void testLocalNameFunction() throws Exception {
        doTest(tests.get("local-name"));
    }

    static final protected String[]         noGraphsSpecified = new String[] {};

    static protected Map<String, QueryTest> tests             = new HashMap<String, QueryTest>();

    static protected QueryTest addQueryTest(String name, Exception expectedException) {
        if (expectedException == null) {
            throw new IllegalArgumentException("expectedException must not be null");
        }
        return addQueryTest(name, name, RDFFormat.SPARQL, new String[] { "http://example.org/" + name }, new String[] {}, new String[] {}, false, false, expectedException);
    }

    static protected QueryTest addQueryTest(String name, RDFFormat resultFormat) {
        return addQueryTest(name, resultFormat, new String[] { "http://example.org/" + name }, new String[] {}, new String[] {});
    }

    static protected QueryTest addQueryTestWithSingleNamedGraph(String name, RDFFormat resultFormat) {
        return addQueryTest(name, resultFormat, new String[] {}, new String[] { "http://example.org/" + name }, new String[] {});
    }

    static protected QueryTest addQueryTest(String name, RDFFormat resultFormat, String defaultGraph, String... namedGraphs) {
        return addQueryTest(name, resultFormat, new String[] { defaultGraph }, namedGraphs, new String[] {});
    }

    static protected QueryTest addQueryTest(String name, RDFFormat resultFormat, String[] defaultGraphs, String[] namedGraphs) {
        return addQueryTest(name, resultFormat, defaultGraphs, namedGraphs, new String[] {});
    }

    static protected QueryTest addQueryTest(String name, RDFFormat resultFormat, String[] defaultGraphs, String[] namedGraphs, String[] namedDatasets) {
        return addQueryTest(name, name, resultFormat, defaultGraphs, namedGraphs, namedDatasets, false, false, null);
    }

    static protected QueryTest addQueryTest(String testName, String testDataName, RDFFormat resultFormat, String[] defaultGraphs, String[] namedGraphs, String[] namedDatasets, boolean forceIgnoreOrder, boolean allowAnagrams, Exception expectedException) {
        return addQueryTest(testName, resultFormat, "queries/" + testDataName + ".rq", "queries/" + testDataName + ".trig", "queries/" + testDataName + "." + resultFormat.getFileExtensions()[0], defaultGraphs, namedGraphs, namedDatasets, forceIgnoreOrder, allowAnagrams, expectedException);
    }

    static protected QueryTest addQueryTest(String testName, RDFFormat resultFormat, String queryResource, String dataResource, String resultsResource, String[] defaultGraphs, String[] namedGraphs, String[] namedDatasets, boolean forceIgnoreOrder, boolean allowAnagrams, Exception expectedException) {
        InputStream query = ProtocolDatasetQueryTests.class.getResourceAsStream(queryResource);
        InputStream data = ProtocolDatasetQueryTests.class.getResourceAsStream(dataResource);
        InputStream results = ProtocolDatasetQueryTests.class.getResourceAsStream(resultsResource);
        if (query == null || data == null || (results == null && expectedException == null))
            throw new RuntimeException("Test '" + testName + "' has null query/data/results stream(s): " + query + "/" + data + "/" + results);
        QueryTest test = new QueryTest(query, data, results);
        test.setResultRDFFormat(resultFormat);
        test.setForceIgnoreOrder(forceIgnoreOrder);
        test.setExpectedException(expectedException);
        test.setAllowAnagrams(allowAnagrams);
        for (String s : defaultGraphs)
            test.addDefaultGraph(s);
        for (String s : namedGraphs)
            test.addNamedGraph(s);
        for (String s : namedDatasets)
            test.addNamedDataset(s);
        tests.put(testName, test);
        return test;
    }

    static {
        addQueryTest("default1", RDFFormat.SPARQL);
        addQueryTestWithSingleNamedGraph("complex-filter1", RDFFormat.SPARQL);
        addQueryTest("multi-optional", RDFFormat.SPARQL);
        addQueryTestWithSingleNamedGraph("filter-uri", RDFFormat.SPARQL);
        addQueryTestWithSingleNamedGraph("filter-isuri", RDFFormat.SPARQL);
        addQueryTestWithSingleNamedGraph("filter-isuri2", RDFFormat.SPARQL);
        addQueryTestWithSingleNamedGraph("named-graph-1", RDFFormat.SPARQL);
        addQueryTest("two-named-graphs", RDFFormat.SPARQL, noGraphsSpecified, new String[] { "http://example.org/two-named-graphs-1", "http://example.org/two-named-graphs-2" });
        addQueryTestWithSingleNamedGraph("optional-query", RDFFormat.SPARQL);
        addQueryTestWithSingleNamedGraph("extra-triples-aspect", RDFFormat.SPARQL);
        addQueryTest("nonexistent-node", RDFFormat.SPARQL, new String[] { "http://example.org/nonexistent-node" }, noGraphsSpecified);
        addQueryTestWithSingleNamedGraph("graph-uri-in-graph-contents-optional", RDFFormat.SPARQL);
        addQueryTestWithSingleNamedGraph("graph-uri-in-graph-contents", RDFFormat.SPARQL);
        addQueryTestWithSingleNamedGraph("graph-uri-in-graph-contents-extra", RDFFormat.SPARQL);
        addQueryTest("regular-and-extra-triple-patterns", RDFFormat.SPARQL, noGraphsSpecified, new String[] { "http://example.org/regular-and-extra-triple-patterns-1", "http://example.org/regular-and-extra-triple-patterns-2" });
        addQueryTest("npe-test-1", RDFFormat.SPARQL);
        addQueryTest("select-distinct-uri", RDFFormat.SPARQL);
        // dataset tests
        addQueryTest("dataset-1-protocol", "dataset-1", RDFFormat.SPARQL, new String[] {}, new String[] {}, new String[] { "http://example.org/dataset" }, false, false, null);
        addQueryTest("dataset-2", RDFFormat.SPARQL, noGraphsSpecified, noGraphsSpecified, new String[] { "http://example.org/dataset" });
        addQueryTest("dataset-4", RDFFormat.SPARQL, noGraphsSpecified, noGraphsSpecified, new String[] { "http://example.org/dataset" });
        addQueryTest("dataset-5", RDFFormat.SPARQL, new String[] { "http://example.org/dg2" }, new String[] { "http://example.org/ng2" }, new String[] { "http://example.org/dataset" });
        // count tests
        addQueryTest("count-distinct-star", RDFFormat.SPARQL);
        addQueryTest("count-distinct-star-and-var-with-group-by", RDFFormat.SPARQL);
        // select expression tests
        addQueryTest("expression-math-constant", RDFFormat.SPARQL);
        addQueryTest("expression-math-variables", RDFFormat.SPARQL);
        addQueryTest("expression-builtin-function-1", RDFFormat.SPARQL);
        addQueryTest("expression-aggregate-and-scalar", RDFFormat.SPARQL);
        addQueryTest("order-by-datetime", RDFFormat.SPARQL);
        addQueryTest("filter-by-datetime", RDFFormat.SPARQL);
        addQueryTest("invalid-datetime", RDFFormat.SPARQL);
        addQueryTest("invalid-datetime-orderby", RDFFormat.SPARQL);
        addQueryTest("invalid-datetime-orderby", "invalid-datetime-orderby", RDFFormat.SPARQL, new String[] { "http://example.org/invalid-datetime-orderby" }, new String[] {}, new String[] {}, true, false, null);
        addQueryTest("order-by-with-count", RDFFormat.SPARQL);
        // construct tests
        addQueryTest("construct-1", RDFFormat.TURTLE);
        addQueryTest("construct-2", RDFFormat.TURTLE);
        //
        addQueryTest("order-by-non-projected-variable", RDFFormat.SPARQL);
        addQueryTest("order-by-with-unbound-values", RDFFormat.SPARQL);
        addQueryTest("order-by-with-unbound-values-as-max", RDFFormat.SPARQL);
        // test date/time functions
        addQueryTest("local-name", RDFFormat.SPARQL);
        addQueryTest("datepart", RDFFormat.SPARQL);
        addQueryTest("timepart", RDFFormat.SPARQL);
        addQueryTest("datetime-add-1", RDFFormat.SPARQL);
        addQueryTest("datetime-add-invalid-literal", RDFFormat.SPARQL);
        // numeric comparison tests
        addQueryTest("numeric-compare-1", RDFFormat.SPARQL);
        // partitionIndex tests
        addQueryTest("partitionindex-ints", RDFFormat.SPARQL);
        addQueryTest("partitionindex-doubles", RDFFormat.SPARQL);
        addQueryTest("partitionindex-mixed", RDFFormat.SPARQL);
        addQueryTest("partitionindex-datetimes", RDFFormat.SPARQL);
        addQueryTest("partitionindex-times", RDFFormat.SPARQL);
        addQueryTest("partitionindex-datetimes-negative-duration", RDFFormat.SPARQL);
        addQueryTest("partitionindex-datetimes-invalid-literal-argument", RDFFormat.SPARQL);
        addQueryTest("group-by-aliased-variable", RDFFormat.SPARQL);
        // assignment tests
        addQueryTest("let-function-on-bindings", RDFFormat.SPARQL);
        addQueryTest("let-multiple", RDFFormat.SPARQL);
        addQueryTest("let-same-variable", RDFFormat.SPARQL);
        addQueryTest("let-simple-multiple", RDFFormat.SPARQL);
        addQueryTest("let-simple", RDFFormat.SPARQL);
        addQueryTest("let-tagged-union", RDFFormat.SPARQL);
        addQueryTest("let-union-aggregate", RDFFormat.SPARQL);
        addQueryTest("let-variable-assigned-twice", RDFFormat.SPARQL);
        // subquery tests
        addQueryTest("subquery-lpr", "subquery-lpr", RDFFormat.SPARQL, new String[] { "http://example.org/subquery-lpr" }, new String[] {}, new String[] {}, true, false, null);
        // group_concat tests
        addQueryTest("group-concat-default", "group-concat-default", RDFFormat.SPARQL, new String[] { "http://example.org/group-concat-default" }, new String[] {}, new String[] {}, false, true, null);
        addQueryTest("group-concat-separator", "group-concat-separator", RDFFormat.SPARQL, new String[] { "http://example.org/group-concat-separator" }, new String[] {}, new String[] {}, false, true, null);
        // construct'ing quads
        addQueryTest("construct-graph", RDFFormat.TRIG, "queries/construct-graph.rq", "queries/construct-graph-in.trig", "queries/construct-graph-out.trig", new String[] { "http://example.org/construct-graph" }, new String[] {}, new String[] {}, false, false, null);
    }
}
