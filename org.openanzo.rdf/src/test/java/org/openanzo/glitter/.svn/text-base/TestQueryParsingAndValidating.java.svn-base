/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter;

import junit.framework.TestCase;

import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.exception.UnknownFunctionException;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.query.planning.LexicalOrderBasedExecutionPlan;
import org.openanzo.glitter.syntax.concrete.ParseException;

/**
 * Tests in this class test legal and illegal query strings, in addition to semantic conditions imposed by {@link QueryValidator}s.
 * 
 * 
 * @author Lee Feigenbaum <lee@cambridgesemantics.com>
 * 
 */
public class TestQueryParsingAndValidating extends TestCase {

    private QueryController tryPrepareQuery(String query) throws GlitterException, ParseException {
        Engine engine = new Engine(new MockEngineConfig(LexicalOrderBasedExecutionPlan.class));

        QueryController prepareQuery = engine.prepareQuery(null, query);

        return prepareQuery;
    }

    /**
     * Test group by 1 var
     * 
     * @throws Exception
     */
    public void testGroupBy1Var() throws Exception {
        tryPrepareQuery("SELECT ?s { ?s ?p ?o } GROUP BY ?s");
    }

    /**
     * Test group by multi var
     * 
     * @throws Exception
     */
    public void testGroupByMultiVar() throws Exception {
        tryPrepareQuery("SELECT * { ?s ?p ?o } GROUP BY ?s ?p ?o");
    }

    /**
     * Test group by non var
     * 
     * @throws Exception
     */
    public void testGroupByNonVar() throws Exception {
        Exception e = null;
        try {
            tryPrepareQuery("SELECT * { ?s ?p ?o } GROUP BY _:b1");
        } catch (Exception tmp) {
            e = tmp;
        }
        assertNotNull(e);
    }

    /**
     * Test count var
     * 
     * @throws Exception
     */
    public void testCountVar() throws Exception {
        tryPrepareQuery("SELECT ?s (COUNT(?p) AS ?x) { ?s ?p ?o } GROUP BY ?s");
    }

    /**
     * Test count vars
     * 
     * @throws Exception
     */
    public void testCountVars() throws Exception {
        tryPrepareQuery("SELECT ?s (COUNT(?p, ?o) AS ?x) { ?s ?p ?o } GROUP BY ?s");
    }

    /**
     * Test count star
     * 
     * @throws Exception
     */
    public void testCountStar() throws Exception {
        tryPrepareQuery("SELECT ?s (COUNT(*) AS ?x) { ?s ?p ?o } GROUP BY ?s");
    }

    /**
     * Test count disticnt vars
     * 
     * @throws Exception
     */
    public void testCountDistinctVar() throws Exception {
        tryPrepareQuery("SELECT ?s (COUNT(DISTINCT ?p) AS ?x) { ?s ?p ?o } GROUP BY ?s");
    }

    /**
     * Test count distinct start
     * 
     * @throws Exception
     */
    public void testCountDistinctStar() throws Exception {
        tryPrepareQuery("SELECT ?s (COUNT(DISTINCT *) AS ?x) { ?s ?p ?o } GROUP BY ?s");
    }

    /**
     * Test count non var
     * 
     * @throws Exception
     */
    public void testCountNonVar() throws Exception {
        Exception e = null;
        try {
            tryPrepareQuery("SELECT ?s (COUNT(5) AS ?x) { ?s ?p ?o } GROUP BY ?s");
        } catch (Exception tmp) {
            e = tmp;
        }
        assertNotNull(e);
    }

    /**
     * Test select expressions
     * 
     * @throws Exception
     */
    public void testSelectExpressions() throws Exception {
        UnknownFunctionException ufe = null;
        try {
            tryPrepareQuery("SELECT ?a (3 + 5 AS ?b) (<http://example.org/func>(1, 2, ?c) AS ?d) (((3 * ?d)) AS ?e) { ?a ?b ?c . ?d ?e ?f . } GROUP BY ?a");
        } catch (UnknownFunctionException e) {
            ufe = e;
        }
        assertNotNull(ufe);
    }

    /**
     * Test no as
     * 
     * @throws Exception
     */
    public void testNoAS() throws Exception {
        Exception e = null;
        try {
            tryPrepareQuery("SELECT ?s (COUNT(*)) { ?s ?p ?o } GROUP BY ?s");
        } catch (Exception tmp) {
            e = tmp;
        }
        assertNotNull(e);
    }

    /**
     * Test no parens
     * 
     * @throws Exception
     */
    public void testNoParens() throws Exception {
        Exception e = null;
        try {
            tryPrepareQuery("SELECT ?s COUNT(*) { ?s ?p ?o } GROUP BY ?s");
        } catch (Exception tmp) {
            e = tmp;
        }
        assertNotNull(e);
    }

    /**
     * Test no parens with as
     * 
     * @throws Exception
     */
    public void testNoParensWithAS() throws Exception {
        Exception e = null;
        try {
            tryPrepareQuery("SELECT ?s COUNT(*) AS ?count { ?s ?p ?o } GROUP BY ?s");
        } catch (Exception tmp) {
            e = tmp;
        }
        assertNotNull(e);
    }

    /**
     * Test projected unbound variables
     * 
     * @throws Exception
     */
    public void testProjectedUnboundVariable() throws Exception {
        Exception e = null;
        try {
            tryPrepareQuery("SELECT ?s ?no { ?s ?p ?o }");
        } catch (Exception tmp) {
            e = tmp;
        }
        assertNotNull(e);
    }

    /**
     * Test project var not in group by
     * 
     * @throws Exception
     */
    public void testProjectVarNotInGroupBy() throws Exception {
        Exception e = null;
        try {
            tryPrepareQuery("SELECT ?s ?p { ?s ?p ?o } GROUP BY ?s");
        } catch (Exception tmp) {
            e = tmp;
        }
        assertNotNull(e);
    }
}
