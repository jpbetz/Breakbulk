/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/client/TestQueries.java,v $
 * Created by:  Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * Created on:  9/25/2006
 * Revision:    $Id: TestQueries.java 229 2007-08-07 15:22:00Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/

package org.openanzo.test.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.query.QueryEncoder;
import org.openanzo.test.AbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests queries against the server that require text indexing.
 * 
 */
public class TestIntegratedTextQueries extends AbstractTest {
    private static final Logger log      = LoggerFactory.getLogger(TestIntegratedTextQueries.class);

    static final URI            NG_SUBJ1 = Constants.valueFactory.createURI("http://test/subj1");

    static final URI            NG_PRED1 = Constants.valueFactory.createURI("http://test/pred1");

    static final URI            NG_SUBJ  = Constants.valueFactory.createURI("http://test/subj");

    static final URI            NG_PRED  = Constants.valueFactory.createURI("http://test/pred");

    static final Literal        NG_TEXT1 = Constants.valueFactory.createLiteral("hello text ng1");

    static final Literal        NG_TEXT2 = Constants.valueFactory.createLiteral("hello text ng2");

    static final Literal        UNMATCH  = Constants.valueFactory.createLiteral("unmatched");

    static final Literal        UNMATCH2 = Constants.valueFactory.createLiteral("unmatched2");

    static final URI            ng1      = createTestUri("namedGraph1");

    static final URI            ng2      = createTestUri("namedGraph4");

    void setupIntegratedTextQueryNG(AnzoClient client) throws AnzoException {
        INamedGraph serverGraph1 = client.getServerGraph(ng1);
        client.begin();
        serverGraph1.add(NG_SUBJ1, NG_PRED1, NG_SUBJ);
        serverGraph1.add(NG_SUBJ, NG_PRED, NG_TEXT1);
        serverGraph1.add(NG_SUBJ, NG_PRED, UNMATCH);
        client.commit();
        client.updateRepository();
        INamedGraph serverGraph2 = client.getServerGraph(ng2);
        client.begin();
        serverGraph2.add(NG_SUBJ, NG_PRED, NG_TEXT1);
        serverGraph2.add(NG_SUBJ, NG_PRED, UNMATCH);
        client.commit();
        client.updateRepository();
    }

    /**
     * Test a simple text query.
     * 
     * @throws Throwable
     */
    @SuppressWarnings("null")
    public void testIntegratedLikeTextQuery() throws Throwable {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        assertNotNull(client);
        try {
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            INamedGraph serverGraph = client.getServerGraph(createTestUri("namedGraph1"));
            URI res = Constants.valueFactory.createURI("http://test/subj");
            URI prop = Constants.valueFactory.createURI("http://test/pred");
            Constants.valueFactory.createURI("http://test/pred2");
            client.begin();
            Literal testText = Constants.valueFactory.createLiteral("Greetings, Hello text");
            serverGraph.add(res, prop, testText);
            serverGraph.add(res, prop, Constants.valueFactory.createLiteral("non-matching"));
            client.commit();
            client.updateRepository();
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            String query;
            QueryResults results = null;
            try {
                query = "SELECT  ?s ?o WHERE { ?s " + QueryEncoder.encodeForQuery(prop) + " ?o . ?o <" + org.openanzo.glitter.util.Constants.TEXTLIKEPREDICATE + "> \"Greetings%\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
                assertTrue(results.isSelectResult());

                Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                assertTrue(iter.hasNext());
                PatternSolution sol = iter.next();
                Value val = sol.getBinding("o");
                assertEquals(testText, val);
                assertTrue(sol.getBinding("s") instanceof URI);
            } else {
                indexE.printStackTrace();
            }
        } finally {
            if (client != null)
                client.close();
        }
    }

    /**
     * Test a text query with a variable reused in an extra triple pattern: ?s :p ?o . ?o textlike "foo%" . ?s :p2 ?o
     * 
     * Invalid
     * 
     * @throws Throwable
     */
    public void testIntegratedLikeTextQueryWithReusedVariable() throws Throwable {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        assertNotNull(client);
        try {
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            INamedGraph serverGraph = client.getServerGraph(createTestUri("namedGraph1"));
            client.begin();

            Constants.valueFactory.createURI("http://test/pred2");

            Literal testText = Constants.valueFactory.createLiteral("text");
            Literal otherText = Constants.valueFactory.createLiteral("other");
            serverGraph.add(createTestUri("s"), createTestUri("p"), testText);
            serverGraph.add(createTestUri("s"), createTestUri("p2"), otherText);
            client.commit();
            client.updateRepository();
            String query;
            query = "PREFIX : <http://test.example.com/test#> SELECT ?s WHERE { ?s :p ?o . ?o <" + org.openanzo.glitter.util.Constants.TEXTLIKEPREDICATE + "> \"te%\" . ?s :p2 ?o }";
            QueryResults results = client.serverQuery(Collections.singleton(createTestUri("namedGraph1")), null, null, query, null);
            assertTrue(results.isSelectResult());
            assertEquals(0, results.getSelectResults().size());
        } finally {
            client.close();
        }
    }

    /**
     * Test a simple text query.
     * 
     * @throws Throwable
     */
    @SuppressWarnings("null")
    public void testIntegratedTextQuery() throws Throwable {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        assertNotNull(client);
        try {
            client.reset(loadStatements("initialize.trig"), null);
            INamedGraph serverGraph = client.getServerGraph(createTestUri("namedGraph1"));
            URI res = Constants.valueFactory.createURI("http://test/subj");
            URI prop = Constants.valueFactory.createURI("http://test/pred");
            client.begin();
            Literal testText = Constants.valueFactory.createLiteral("hello text");
            serverGraph.add(res, prop, testText);
            serverGraph.add(res, prop, Constants.valueFactory.createLiteral("non-matching"));
            client.commit();
            client.updateRepository();
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            String query;
            QueryResults results = null;
            try {
                query = "SELECT  ?o WHERE { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                PatternSolution sol = results.getSelectResults().iterator().next();
                Value val = sol.getBinding("o");
                assertEquals(testText, val);
            } else {
                assertTrue(indexE.getErrorCode() == ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED);
                log.warn("server indexing not enabled");
            }
            results = null;
            try {
                query = "SELECT  ?o WHERE { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello text\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                PatternSolution sol = results.getSelectResults().iterator().next();
                Value val = sol.getBinding("o");
                assertEquals(testText, val);
            } else {
                assertTrue(indexE.getErrorCode() == ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED);
                log.warn("server indexing not enabled");
            }
            results = null;
            try {
                query = "SELECT  ?o WHERE { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello* text\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                PatternSolution sol = results.getSelectResults().iterator().next();
                Value val = sol.getBinding("o");
                assertEquals(testText, val);
            } else {
                assertTrue(indexE.getErrorCode() == ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED);
                log.warn("server indexing not enabled");
            }
        } finally {
            client.close();
        }
    }

    /**
     * Test a simple text query.
     * 
     * @throws Throwable
     */
    @SuppressWarnings("null")
    public void testIntegratedWildcardTextQuery() throws Throwable {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        assertNotNull(client);
        try {
            client.reset(loadStatements("initialize.trig"), null);
            INamedGraph serverGraph = client.getServerGraph(createTestUri("namedGraph1"));
            URI res = Constants.valueFactory.createURI("http://test/subj");
            URI prop = Constants.valueFactory.createURI("http://test/pred");
            client.begin();
            Literal testText = Constants.valueFactory.createLiteral("hello text");
            serverGraph.add(res, prop, testText);
            serverGraph.add(res, prop, Constants.valueFactory.createLiteral("non-matching"));
            for (int i = 0; i < 2048; i++) {
                serverGraph.add(res, prop, Constants.valueFactory.createLiteral("hel" + i));
            }
            client.commit();
            client.updateRepository();
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            String query;
            QueryResults results = null;
            try {
                query = "SELECT  ?o WHERE { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hell*\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                PatternSolution sol = results.getSelectResults().iterator().next();
                Value val = sol.getBinding("o");
                assertEquals(testText, val);
            } else {
                assertTrue(indexE.getErrorCode() == ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED);
                log.warn("server indexing not enabled");
            }
        } finally {
            client.close();
        }
    }

    /**
     * Test a test query with subject and predicate restrictions.
     * 
     * @throws Throwable
     * 
     * */
    @SuppressWarnings("null")
    public void testIntegratedTextQuerySP() throws Throwable {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        assertNotNull(client);
        try {
            client.reset(loadStatements("initialize.trig"), null);
            INamedGraph serverGraph = client.getServerGraph(createTestUri("namedGraph1"));
            URI res = Constants.valueFactory.createURI("http://test/subj");
            URI prop = Constants.valueFactory.createURI("http://test/pred");
            client.begin();
            String testText = "hello text";
            serverGraph.add(res, prop, Constants.valueFactory.createLiteral(testText));
            serverGraph.add(res, prop, Constants.valueFactory.createLiteral("non-matching"));
            client.commit();
            client.updateRepository();
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            String query;
            QueryResults results;
            try {
                // Fake predicate.
                query = "SELECT ?s ?o WHERE { ?s <http://test/notfound> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(0, results.getSelectResults().size());
                // Fake subject.
                query = "SELECT ?p ?o WHERE { <http://test/notfound> ?p ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(0, results.getSelectResults().size());
                // Fake subject & predicate.
                query = "SELECT ?o WHERE { <http://test/notfound> <http://test/notfound> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(0, results.getSelectResults().size());
                // Real predicate.
                query = "SELECT ?s ?o WHERE { ?s <http://test/pred> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                PatternSolution soln = results.getSelectResults().iterator().next();
                assertEquals(res.toString(), soln.getBinding("s").toString());
                assertEquals(testText, ((Literal) soln.getBinding("o")).getLabel());
                // Real predicate with wildcard.
                query = "SELECT ?s ?o WHERE { ?s <http://test/pred> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"h?llo\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                soln = results.getSelectResults().iterator().next();
                assertEquals(res, soln.getBinding("s"));
                assertEquals(testText, ((Literal) soln.getBinding("o")).getLabel());
                // Real subject.
                query = "SELECT ?p ?o WHERE { <http://test/subj> ?p ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                soln = results.getSelectResults().iterator().next();
                assertEquals(prop, soln.getBinding("p"));
                assertEquals(testText, ((Literal) soln.getBinding("o")).getLabel());
                // Real subject & predicate.
                query = "SELECT ?o WHERE { <http://test/subj> <http://test/pred> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                // No subject or predicate.
                query = "SELECT ?s ?p ?o WHERE { ?s ?p ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                soln = results.getSelectResults().iterator().next();
                assertEquals(res, soln.getBinding("s"));
                assertEquals(prop, soln.getBinding("p"));
                assertEquals(testText, ((Literal) soln.getBinding("o")).getLabel());
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
            } else {
                assertEquals(ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED, indexE.getErrorCode());
                log.warn("server indexing not enabled");
            }
        } finally {
            client.close();
        }
    }

    /**
     * Test a test query with subject and predicate restrictions.
     * 
     * @throws Throwable
     */
    @SuppressWarnings("null")
    public void testIntegratedTextQuerySPWildCard() throws Throwable {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        assertNotNull(client);
        try {
            client.reset(loadStatements("initialize.trig"), null);
            INamedGraph serverGraph = client.getServerGraph(createTestUri("namedGraph1"));
            URI res = Constants.valueFactory.createURI("http://test/subj");
            URI prop = Constants.valueFactory.createURI("http://test/pred");
            client.begin();
            String testText = "hello text";
            serverGraph.add(res, prop, Constants.valueFactory.createLiteral(testText));
            for (int i = 0; i < 2048; i++) {
                serverGraph.add(res, prop, Constants.valueFactory.createLiteral("hel" + i));
            }
            serverGraph.add(res, prop, Constants.valueFactory.createLiteral("non-matching"));
            client.commit();
            client.updateRepository();
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            String query;
            QueryResults results;
            try {
                // Fake predicate.
                query = "SELECT ?s ?o WHERE { ?s <http://test/notfound> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hell*\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(0, results.getSelectResults().size());
                // Fake subject.
                query = "SELECT ?p ?o WHERE { <http://test/notfound> ?p ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hell*\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(0, results.getSelectResults().size());
                // Fake subject & predicate.
                query = "SELECT ?o WHERE { <http://test/notfound> <http://test/notfound> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hell*\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(0, results.getSelectResults().size());
                // Real predicate.
                query = "SELECT ?s ?o WHERE { ?s <http://test/pred> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hell*\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                PatternSolution soln = results.getSelectResults().iterator().next();
                assertEquals(res.toString(), soln.getBinding("s").toString());
                assertEquals(testText, ((Literal) soln.getBinding("o")).getLabel());
                // Real predicate with wildcard.
                query = "SELECT ?s ?o WHERE { ?s <http://test/pred> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"h?llo\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                soln = results.getSelectResults().iterator().next();
                assertEquals(res, soln.getBinding("s"));
                assertEquals(testText, ((Literal) soln.getBinding("o")).getLabel());
                // Real subject.
                query = "SELECT ?p ?o WHERE { <http://test/subj> ?p ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hell*\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                soln = results.getSelectResults().iterator().next();
                assertEquals(prop, soln.getBinding("p"));
                assertEquals(testText, ((Literal) soln.getBinding("o")).getLabel());
                // Real subject & predicate.
                query = "SELECT ?o WHERE { <http://test/subj> <http://test/pred> ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hell*\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                // No subject or predicate.
                query = "SELECT ?s ?p ?o WHERE { ?s ?p ?o  . ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hell*\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                soln = results.getSelectResults().iterator().next();
                assertEquals(res, soln.getBinding("s"));
                assertEquals(prop, soln.getBinding("p"));
                assertEquals(testText, ((Literal) soln.getBinding("o")).getLabel());
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
            } else {
                assertEquals(ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED, indexE.getErrorCode());
                log.warn("server indexing not enabled");
            }
        } finally {
            client.close();
        }
    }

    /**
     * Test a text query with a string typed literal object.
     * 
     * @throws Throwable
     */
    @SuppressWarnings("null")
    public void testIntegratedTextQueryTypedLiteral() throws Throwable {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        assertNotNull(client);
        try {
            client.reset(loadStatements("initialize.trig"), null);
            INamedGraph serverGraph = client.getServerGraph(createTestUri("namedGraph1"));
            URI res = Constants.valueFactory.createURI("http://test/subj");
            URI prop = Constants.valueFactory.createURI("http://test/pred");
            client.begin();
            String testText = "hello text";
            Literal lit = Constants.valueFactory.createLiteral(testText);
            serverGraph.add(res, prop, lit);
            client.commit();
            client.updateRepository();
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            QueryResults results = null;
            String query;
            try {
                query = "SELECT  ?o WHERE { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                assertEquals(lit, results.getSelectResults().iterator().next().getBinding("o"));
            } else {
                assertTrue(indexE.getErrorCode() == ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED);
                log.warn("server indexing not enabled");
            }
        } finally {
            client.close();
        }
    }

    /**
     * Test text match query against default graph with all named graphs
     * 
     * @throws Exception
     */
    @SuppressWarnings("null")
    public void testIntegratedTextQueryDefaultNG() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        assertNotNull(client);
        try {
            client.reset(loadStatements("initialize.trig"), null);
            setupIntegratedTextQueryNG(client);
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            String query;
            QueryResults results = null;
            try {
                query = "SELECT  ?o WHERE { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertTrue(results.getSelectResults().size() == 1 || results.getSelectResults().size() == 2);
                // 2
                // default graph
                query = "SELECT  ?o WHERE {?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(ng1), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                PatternSolution soln = results.getSelectResults().iterator().next();
                soln.getBinding("o").toString().contains("ng1");
                // default graph
                query = "SELECT  ?o WHERE {?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }";
                results = client.serverQuery(Collections.singleton(ng2), null, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                soln = results.getSelectResults().iterator().next();
                soln.getBinding("o").toString().contains("ng2");
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
                log.warn("server indexing enabled");
            } else {
                assertTrue(indexE.getErrorCode() == ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED);
                log.warn("server indexing not enabled");
            }
        } finally {
            client.close();
        }
    }

    /**
     * Test text match query against one graph
     * 
     * @throws Exception
     */
    @SuppressWarnings("null")
    public void testIntegratedTextQueryNG() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        assertNotNull(client);
        try {
            client.reset(loadStatements("initialize.trig"), null);
            setupIntegratedTextQueryNG(client);
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            String query;
            QueryResults results = null;
            try {
                query = "SELECT  ?o WHERE {graph <" + ng1 + "> { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }}";
                results = client.serverQuery(null, Collections.singleton(ng1), null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                Set<Value> vals = new HashSet<Value>();
                int i = 0;
                {
                    Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                    while (iter.hasNext()) {
                        PatternSolution solution = iter.next();
                        Value graph = solution.getBinding("o");
                        vals.add(graph);
                        i++;
                    }
                }
                assertEquals(1, i);
                assertTrue(vals.contains(NG_TEXT1));
                query = "SELECT  ?o WHERE {graph <" + ng2 + "> { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }}";
                results = client.serverQuery(null, Collections.singleton(ng2), null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                vals = new HashSet<Value>();
                {
                    Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                    while (iter.hasNext()) {
                        PatternSolution solution = iter.next();
                        Value graph = solution.getBinding("o");
                        vals.add(graph);
                    }
                }
                assertEquals(1, i);
                assertTrue(vals.contains(NG_TEXT1));
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
                log.warn("server indexing enabled");
            } else {
                log.warn(indexE.getLocalizedMessage());
                assertEquals(ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED, indexE.getErrorCode());
                log.warn("server indexing not enabled");
            }
        } finally {
            client.close();
        }
    }

    /**
     * Test text match query against all namedgraphs and graph is a result binding
     * 
     * @throws Exception
     */
    @SuppressWarnings("null")
    public void testIntegratedTextQueryBindNG() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        assertNotNull(client);
        try {
            client.reset(loadStatements("initialize.trig"), null);
            setupIntegratedTextQueryNG(client);
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            String query;
            QueryResults results = null;
            try {
                // pull out graph?
                query = "SELECT  ?g ?o WHERE {graph ?g { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }}";
                results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(2, results.getSelectResults().size());
                // 2
                Set<Value> graphs = new HashSet<Value>();
                {
                    Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                    while (iter.hasNext()) {
                        PatternSolution solution = iter.next();
                        Value graph = solution.getBinding("g");
                        graphs.add(graph);
                    }
                }
                assertTrue(graphs.contains(ng1));
                assertTrue(graphs.contains(ng2));
                query = "SELECT ?g ?o WHERE {graph ?g { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }}";
                results = client.serverQuery(null, Collections.singleton(ng1), null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
                PatternSolution soln = results.getSelectResults().iterator().next();
                assertEquals(ng1, soln.getBinding("g"));
                Set<URI> ngraphs = new HashSet<URI>();
                ngraphs.add(ng1);
                ngraphs.add(ng2);
                query = "SELECT ?g ?o WHERE {graph ?g { ?o <" + org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE + "> \"hello\" }}";
                results = client.serverQuery(null, ngraphs, null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(2, results.getSelectResults().size());
                // 2
                graphs.clear();
                {
                    Iterator<PatternSolution> iter = results.getSelectResults().iterator();
                    while (iter.hasNext()) {
                        PatternSolution solution = iter.next();
                        Value graph = solution.getBinding("g");
                        graphs.add(graph);
                    }
                }
                assertTrue(graphs.contains(ng1));
                assertTrue(graphs.contains(ng2));
            } catch (AnzoException e) {
                exceptionCaught = true;
                indexE = e;
            }
            if (!exceptionCaught) {
                log.warn("server indexing enabled");
            } else {
                assertEquals(ExceptionConstants.INDEX.FAILED_INDEX_QUERY_DISABLED, indexE.getErrorCode());
                log.warn("server indexing not enabled");
            }
        } finally {
            client.close();
        }
    }

    public void testIntegratedTextUnion() throws Exception {
        AnzoClient client = new AnzoClient(getDefaultClientConfiguration());
        client.connect();
        assertNotNull(client);
        try {
            client.reset(loadStatements("initialize.trig"), null);
            setupIntegratedTextQueryNG(client);
            boolean exceptionCaught = false;
            AnzoException indexE = null;
            String query;
            QueryResults results = null;
            try {
                // pull out graph?
                query = "SELECT  ?g ?o WHERE {graph ?g {?s " + QueryEncoder.encodeForQuery(NG_PRED1) + " ?o . {?o " + QueryEncoder.encodeForQuery(NG_PRED) + " " + QueryEncoder.encodeForQuery(NG_TEXT1) + " .}  UNION {?o " + QueryEncoder.encodeForQuery(NG_PRED) + " " + QueryEncoder.encodeForQuery(UNMATCH2) + ".}}}";
                results = client.serverQuery(null, Collections.singleton(GRAPHS.ALL_NAMEDGRAPHS), null, query, null);
                assertTrue(results.isSelectResult());
                assertEquals(1, results.getSelectResults().size());
            } catch (AnzoException e) {
                e.printStackTrace();
            }

        } finally {
            client.close();
        }
    }
}
