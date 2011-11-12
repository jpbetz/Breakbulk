/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/AbstractBocaTest.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  9/17/2004
 * Revision:    $Id: AbstractTest.java 171 2007-07-31 14:11:17Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.QueryType;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.adapter.BasicNodeConverter;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SmartEncodingInputStream;
import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.TupleQueryResultHandlerException;
import org.openrdf.query.dawg.DAWGTestResultSetParseException;
import org.openrdf.query.dawg.DAWGTestResultSetUtil;
import org.openrdf.query.impl.MutableTupleQueryResult;
import org.openrdf.query.impl.TupleQueryResultBuilder;
import org.openrdf.query.resultio.BooleanQueryResultParser;
import org.openrdf.query.resultio.QueryResultParseException;
import org.openrdf.query.resultio.TupleQueryResultParser;
import org.openrdf.query.resultio.sparqlxml.SPARQLBooleanXMLParser;
import org.openrdf.query.resultio.sparqlxml.SPARQLResultsXMLParser;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Suite of query tests
 * 
 * @author Lee Feigenbaum ( <a href="mailto:lee@cambridgesemantics.com">lee@cambridgesemantics.com </a>)
 */
public abstract class QueryTestSuiteBase extends AbstractTest {

    private static final Logger         log       = LoggerFactory.getLogger(QueryTestSuiteBase.class);

    protected static BasicNodeConverter converter = new BasicNodeConverter();

    abstract protected QueryResults executeQuery(Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI base) throws AnzoException;

    static protected HashMap<InputStream, Object> cachedStreamResults = new HashMap<InputStream, Object>();

    protected void performQueryTest(QueryTest test) throws RDFHandlerException, QueryResultParseException, TupleQueryResultHandlerException, DAWGTestResultSetParseException, IOException, Exception {
        String query = readAndCacheStream(test.getQuery());
        QueryType type = getQueryType(query);
        try {
            switch (type) {
            case SELECT:
                performSelectQueryTest(test.getBase(), test.getDefaultGraphs(), test.getNamedGraphs(), test.getNamedDatasets(), query, test.hasExpectedException() ? null : loadTupleQueryResult(test.getResults(), test.getResultRDFFormat(), test.getBase()), test.isForceIgnoreOrder(), test.isAllowAnagrams());
                break;
            case CONSTRUCT:
                performConstructQueryTest(test.getBase(), test.getDefaultGraphs(), test.getNamedGraphs(), test.getNamedDatasets(), query, test.hasExpectedException() ? null : parseAnyRdf(test.getResults(), test.getResultRDFFormat(), test.getBase()));
                break;
            case ASK:
                performAskQueryTest(test.getBase(), test.getDefaultGraphs(), test.getNamedGraphs(), test.getNamedDatasets(), query, test.hasExpectedException() ? null : loadBooleanResult(test.getResults(), test.getResultRDFFormat(), test.getBase()));
                break;
            case DESCRIBE:
                performDescribeQueryTest(test.getBase(), test.getDefaultGraphs(), test.getNamedGraphs(), test.getNamedDatasets(), query, test.hasExpectedException() ? null : parseAnyRdf(test.getResults(), test.getResultRDFFormat(), test.getBase()));
                break;
            default:
                fail("Unknown query type.");
            }
        } catch (Exception e) {
            verifyExpectedException(test, e);
        }
    }

    protected void verifyExpectedException(QueryTest test, Exception caughtException) throws Exception {
        Exception expectedException = test.getExpectedException();
        if (expectedException == null) {
            // This test isn't expecting an Exception so simply re-throw it so that the test fails
            throw caughtException;
        }

        // Do some verification of the expected errorCode and errorTags if the
        // expected exception is either an AnzoException or an AnzoRuntimeException.
        // We treat AnzoException and AnzoRuntimeException as interchangeable since the system
        // fires different ones depending on whether we are communicating over the network or to
        // a local query engine.
        long expectedErrorCode = -1;
        long expectedErrorTags = -1;
        long caughtErrorCode = -1;
        long caughtErrorTags = -1;
        if (expectedException instanceof AnzoException) {
            expectedErrorCode = ((AnzoException) expectedException).getErrorCode();
        }
        if (caughtException instanceof AnzoException) {
            caughtErrorCode = ((AnzoException) caughtException).getErrorCode();
        }
        if (expectedException instanceof AnzoRuntimeException) {
            expectedErrorCode = ((AnzoRuntimeException) expectedException).getErrorCode();
        }
        if (caughtException instanceof AnzoRuntimeException) {
            caughtErrorCode = ((AnzoRuntimeException) caughtException).getErrorCode();
        }
        if (expectedException instanceof AnzoException || expectedException instanceof AnzoRuntimeException) {
            if (caughtException instanceof AnzoException || caughtException instanceof AnzoRuntimeException) {
                if (expectedErrorCode != caughtErrorCode) {
                    throw new Exception("Query tests's expected AnzoException or AnzoRuntimeException with errorCode '" + expectedErrorCode + "' but got errorCode '" + caughtErrorCode + "'.", caughtException);
                }
                if (expectedErrorTags != caughtErrorTags) {
                    throw new Exception("Query tests's expected AnzoException or AnzoRuntimeException with errorTags '" + expectedErrorTags + "' but got errorTags '" + caughtErrorTags + "'.", caughtException);
                }
            } else {
                throw new Exception("Query test expected an AnzoException or AnzoRuntimeException but thrown exception was not an AnzoException or AnzoRuntimeException.", caughtException);
            }
        } else {
            // For the case where the exception isn't an AnzoException or an AnzoRuntimeException, the
            // best we can do is verify that as least the caught exception is an "instance of" the excepted exception.
            if (expectedException.getClass().isInstance(caughtException)) {
                throw new Exception("Query test's expected exception was of type " + expectedException.getClass().getName() + " while the thrown exception was of the incompatible type " + caughtException.getClass().getName(), caughtException);
            }
        }
    }

    protected String readAndCacheStream(InputStream stream) throws IOException {
        //System.err.println("** readAndCacheStream - start");
        if (!cachedStreamResults.containsKey(stream)) {
            //System.err.println("** readAndCacheStream - reading from stream");
            List<?> lines = IOUtils.readLines(stream);
            String s = "";
            for (Object tmp : lines)
                s += tmp + "\n";
            cachedStreamResults.put(stream, s);
            //if (s.equals(""))
            //    System.err.println("** readAndCacheStream - read empty string from " + lines.size() + " lines");
        }
        //System.err.println("** readAndCacheStream - end (" + ((String)cachedStreamResults.get(stream)).length() + ")");
        return (String) cachedStreamResults.get(stream);
    }

    @SuppressWarnings("all")
    protected QueryType getQueryType(String query) {
        String lc = query.toLowerCase();
        TreeMap<Integer, QueryType> m = new TreeMap<Integer, QueryType>();
        m.put(Integer.valueOf(lc.indexOf("select")), QueryType.SELECT);
        m.put(Integer.valueOf(lc.indexOf("construct")), QueryType.CONSTRUCT);
        m.put(Integer.valueOf(lc.indexOf("ask")), QueryType.ASK);
        m.put(Integer.valueOf(lc.indexOf("describe")), QueryType.DESCRIBE);
        for (Entry<Integer, QueryType> e : m.entrySet()) {
            int index = e.getKey();
            if (index > -1) {
                // determine if this index is inside a BASE or PREFIX clause. We do this by determining if
                // a colon immediately follows it or it is inside angle brackets
                int x;
                for (x = index + 3; Character.isJavaIdentifierPart(lc.charAt(x)); x++)
                    ; //earliest the colon could be, if we're in ask
                if (lc.charAt(x) != ':') {
                    int lt = lc.lastIndexOf('<', index);
                    int gt = lc.lastIndexOf('>', index);
                    if (lt == -1 || gt > lt) {
                        // no < before us, or else there's a > after the last <
                        return e.getValue();
                    }
                }
            }
        }
        fail("Unknown query type for query: " + query);
        return null;
    }

    @SuppressWarnings("unchecked")
    // ignore cast to Collection<Statement> since only used for testing
    protected Collection<Statement> parseAnyRdf(InputStream stream, org.openanzo.rdf.RDFFormat format, String base) throws AnzoException {
        if (!cachedStreamResults.containsKey(stream)) {
            cachedStreamResults.put(stream, ReadWriteUtils.loadStatements(SmartEncodingInputStream.createSmartReader(stream), format, base));
        }

        return (Collection<Statement>) cachedStreamResults.get(stream);

    }

    @SuppressWarnings("unchecked")
    // ignore cast to Collection<Statement> since only used for testing
    protected Collection<org.openrdf.model.Statement> parseAnyRdfOpenRdf(InputStream stream, RDFFormat format, String base) throws AnzoException {
        if (!cachedStreamResults.containsKey(stream)) {
            cachedStreamResults.put(stream, ReadWriteUtils.loadStatements(SmartEncodingInputStream.createSmartReader(stream), format, base));
        }

        return (Collection<org.openrdf.model.Statement>) cachedStreamResults.get(stream);

    }

    protected MutableTupleQueryResult loadTupleQueryResult(InputStream results, org.openanzo.rdf.RDFFormat format, String base) throws AnzoException, RDFHandlerException, IOException, QueryResultParseException, TupleQueryResultHandlerException, DAWGTestResultSetParseException, RDFParseException, QueryEvaluationException {
        if (!cachedStreamResults.containsKey(results)) {
            MutableTupleQueryResult tqr = null;
            if (format.equals(RDFFormat.SPARQL)) {
                // if it's not RDF, it's probably srx or srj
                TupleQueryResultParser parser = new SPARQLResultsXMLParser();//.createParser(TupleQueryResultFormat.SPARQL);
                TupleQueryResultBuilder tqrBuilder = new TupleQueryResultBuilder();
                parser.setTupleQueryResultHandler(tqrBuilder);
                parser.parse(results);
                tqr = new MutableTupleQueryResult(tqrBuilder.getQueryResult());
            } else {
                Collection<org.openrdf.model.Statement> rdf = parseAnyRdfOpenRdf(results, format, base);
                log.debug("expected: {}", rdf);
                tqr = new MutableTupleQueryResult(DAWGTestResultSetUtil.toTupleQueryResult(rdf));
            }
            cachedStreamResults.put(results, tqr);
        }
        return (MutableTupleQueryResult) cachedStreamResults.get(results);
    }

    protected Boolean loadBooleanResult(InputStream results, RDFFormat format, String base) throws AnzoException, RDFHandlerException, IOException, QueryResultParseException, TupleQueryResultHandlerException, DAWGTestResultSetParseException, RDFParseException {
        if (!cachedStreamResults.containsKey(results)) {
            Boolean b = null;
            if (format.equals(RDFFormat.BOOLEANRESULT)) {
                // if it's not RDF, it's probably srx or srj
                BooleanQueryResultParser parser = new SPARQLBooleanXMLParser();
                b = parser.parse(results);
            } else {
                Collection<org.openrdf.model.Statement> rdf = parseAnyRdfOpenRdf(results, format, base);
                b = DAWGTestResultSetUtil.toBooleanQueryResult(rdf);
            }
            cachedStreamResults.put(results, b);
        }
        return (Boolean) cachedStreamResults.get(results);
    }

    protected void performSelectQueryTest(String base, Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, MutableTupleQueryResult expectedResults, boolean forceIgnoreOrder, boolean allowAnagrams) throws Exception {
        QueryResults actualResults = executeQuery(defaultGraphs, namedGraphs, namedDatasets, query, base != null ? Constants.valueFactory.createURI(base) : null);

        //        Iterator<PatternSolution> iterator = actualResults.getSelectResults().iterator();
        //        while (iterator.hasNext()) {
        //            PatternSolution patternSolution = (PatternSolution) iterator.next();
        //            System.err.println(patternSolution);
        //        }

        assertEquals(QueryType.SELECT, actualResults.getQueryType());
        SolutionSet solutionSet = actualResults.getSelectResults();
        // ooo this is a bit of a cheat
        if (!query.matches("(?is:.*SELECT\\s+\\*.*)"))
            assertEquals(expectedResults.getBindingNames(), solutionSet.getBindingNames());
        assertTupleQueryResultEquals(expectedResults, solutionSet, forceIgnoreOrder ? false : query.toUpperCase().contains("ORDER BY"), allowAnagrams);
    }

    protected void performConstructQueryTest(String base, Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, Collection<Statement> expectedResults) throws Exception {
        QueryResults actualResults = executeQuery(defaultGraphs, namedGraphs, namedDatasets, query, base != null ? Constants.valueFactory.createURI(base) : null);

        assertTrue(actualResults.getQueryType() == QueryType.CONSTRUCT || actualResults.getQueryType() == QueryType.CONSTRUCT_QUADS);
        Collection<Statement> actualTriples = actualResults.getConstructResults();
        // we want set semantics for comparison
        HashSet<Statement> expectedTripleSet = new HashSet<Statement>(expectedResults);
        HashSet<Statement> actualTripleSet = new HashSet<Statement>(actualTriples);
        assertEquals(expectedTripleSet, actualTripleSet);
    }

    protected void performAskQueryTest(String base, Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, Boolean expectedResults) throws Exception {
        QueryResults actualResults = executeQuery(defaultGraphs, namedGraphs, namedDatasets, query, base != null ? Constants.valueFactory.createURI(base) : null);

        assertEquals(QueryType.ASK, actualResults.getQueryType());
        assertEquals(expectedResults.booleanValue(), actualResults.getAskResults());
    }

    protected void performDescribeQueryTest(String base, Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, Collection<Statement> expectedResults) throws Exception {
        QueryResults actualResults = executeQuery(defaultGraphs, namedGraphs, namedDatasets, query, base != null ? Constants.valueFactory.createURI(base) : null);

        assertTrue(actualResults.getQueryType() == QueryType.DESCRIBE || actualResults.getQueryType() == QueryType.DESCRIBE_QUADS);
        Collection<Statement> actualTriples = actualResults.getDescribeResults();
        // we want set semantics for comparison
        HashSet<Statement> expectedTripleSet = new HashSet<Statement>(expectedResults);
        HashSet<Statement> actualTripleSet = new HashSet<Statement>(actualTriples);
        assertEquals(expectedTripleSet, actualTripleSet);
    }

    private void assertTupleQueryResultEquals(MutableTupleQueryResult expected, SolutionSet actual, boolean ordered, boolean allowAnagrams) throws Exception {
        // this is laxer than it need be: SELECT * allows names in any order, but SELECT ?x ?y ?z mandates
        // the order
        Iterator<PatternSolution> actualIter = actual.iterator();
        assertEquals(new HashSet<String>(expected.getBindingNames()), new HashSet<String>(actual.getBindingNames()));
        if (ordered) {
            // if it's ordered, we can just walk the lists in parallel
            expected.beforeFirst();
            while (expected.hasNext()) {
                assertTrue(actualIter.hasNext());

                BindingSet expectedPatternSolution = expected.next();
                PatternSolution actualPatternSolution = actualIter.next();
                assertTrue("Expected solution does not equal actual solution:\n\t" + converter.convert(expectedPatternSolution) + "\n\t\tvs.\n\t" + actualPatternSolution, areSolutionsEqual(converter.convert(expectedPatternSolution), actualPatternSolution, allowAnagrams));
            }
            assertFalse(actualIter.hasNext());
        } else {
            // otherwise, we can just build bags from each solution set and compare them
            //assertEquals(tqr2bag(expected), tqr2bag(actual));
            // this doesn't work because different implementations have different .hashCodes, so
            // we do this the naive way
            LinkedList<PatternSolution> actualBindings = new LinkedList<PatternSolution>();
            while (actualIter.hasNext())
                actualBindings.add(actualIter.next());
            int expectedCount = 0;
            expected.beforeFirst();
            while (expected.hasNext()) {
                expectedCount++;
                BindingSet e = expected.next();
                PatternSolution expect = converter.convert(e);
                boolean found = false;
                for (PatternSolution a : actualBindings) {
                    if (areSolutionsEqual(expect, a, allowAnagrams)) {
                        actualBindings.remove(a);
                        found = true;
                        break;
                    }
                }
                assertTrue("Did not find expected bindings: \n\t" + expect + "\nActual bindings are:\n\t" + actualBindings, found);
            }

            assertEquals("Actual bindings found that were not expected. Expected were: \n\t[" + StringUtils.join(convertResults(expected), ", ") + "]\nActual bindings are:\n\t" + actualBindings, 0, actualBindings.size());
        }
    }

    private boolean areSolutionsEqual(PatternSolution expected, PatternSolution actual, boolean allowAnagrams) {
        if (!allowAnagrams)
            return expected.equals(actual);
        Bindable[] domain = expected.getBoundDomain(true);
        boolean sameDomain = Arrays.equals(domain, actual.getBoundDomain(true));
        if (!sameDomain)
            return false;
        for (Bindable b : domain) {
            Value expectedVal = expected.getBinding(b);
            Value actualVal = actual.getBinding(b);
            if (expectedVal == null && actualVal == null)
                continue;
            if (expectedVal == null || actualVal == null)
                return false;
            if (expectedVal.equals(actualVal))
                continue;
            // allow anagrams here, but only for literals
            if (expectedVal instanceof Literal && actualVal instanceof Literal) {
                String expectedLabel = ((Literal) expectedVal).getLabel();
                String actualLabel = ((Literal) actualVal).getLabel();
                char[] expectedChars = expectedLabel.toCharArray();
                char[] actualChars = actualLabel.toCharArray();
                Arrays.sort(expectedChars);
                Arrays.sort(actualChars);
                return Arrays.equals(expectedChars, actualChars);
            }
            return false;
        }
        return true;
    }

    static Collection<BindingSet> convertResults(MutableTupleQueryResult results) {
        Collection<BindingSet> resultCollection = new ArrayList<BindingSet>();
        while (results.hasNext()) {
            resultCollection.add(results.next());
        }
        return resultCollection;
    }
}
