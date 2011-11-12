/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.planning.LexicalOrderBasedExecutionPlan;
import org.openanzo.rdf.utils.PrettyPrinter;

/**
 * For a set of SPARQL queries intended to cover all of the language features, test that after the query is parsed that:
 *
 * <ol>
 * <li>The QueryController.getQueryString method will correctly return the "canonical format" of the query originally parsed</li>
 * <li>The QueryController.prettyPrint will correctly return the "canonical format" of the AST (Abstract Syntax Tree) for the query</li>
 * </ol>
 *
 * These test are performed by comparing the expected string representation of the query and AST with the one created by the QueryController.
 *
 * Note that the "canonical format" used here is completely informal and not intended for general use beyond these tests, heres some of the rules:
 *
 * <ul>
 * <li>The spacing must be exact</li>
 * <li>Prefixes are in-lined into the query (no PREFIX)</li>
 * <li>operator precedence must be explicit. E.g. FILTER(!?o1 && ?o2 || ?o3) must be written FILTER(((!?o1) && (?o2 || ?o3)))</li>
 * </ul>
 *
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 *
 */
public class TestQueryAndAstStrings extends TestCase {

    static final List<CanonicalQueryStrings> queries = new ArrayList<CanonicalQueryStrings>();

    static {
        String query;
        String ast;

        // a basic projection
        query = "SELECT ?o ?o2 WHERE { <http://fake.url/s> <http://fake.url/p> ?o. <http://fake.url/s> <http://fake.url/p2> ?o2 }";
        ast = "Query(Projection(?o, ?o2), GraphPattern(Group(BGP(TriplePatternNode(<http://fake.url/s> <http://fake.url/p> ?o), TriplePatternNode(<http://fake.url/s> <http://fake.url/p2> ?o2)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // projection w/ optional
        query = "SELECT ?o WHERE { ?s <http://fake.url/p> ?o OPTIONAL { ?s <http://fake.url/p2> ?o2 } }";
        ast = "Query(Projection(?o), GraphPattern(Group(Optional(Group(BGP(TriplePatternNode(?s <http://fake.url/p> ?o))), Group(BGP(TriplePatternNode(?s <http://fake.url/p2> ?o2)))))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        /* union order is not deterministic, so can't verify AST this way...
        query = "SELECT ?o WHERE { {<http://fake.url/s> ?p ?o } UNION {<http://fake.url/s2> ?p ?o } }";
        ast = "Query(Projection(?o), GraphPattern(Union(Group(Group(BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))), Group(Group(BGP(TriplePatternNode(<http://fake.url/s2> ?p ?o)))))))";
        queries.add(new CanonicalQueryStrings(query, ast));
        */

        // graph
        query = "SELECT ?o WHERE { GRAPH ?g { <http://fake.url/s> ?p ?o } }";
        ast = "Query(Projection(?o), GraphPattern(Group(Graph(?g, Group(BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // filter infix operator:  ?o > 0
        query = "SELECT ?o WHERE { <http://fake.url/s> ?p ?o FILTER ((?o > \"\"\"0\"\"\"^^<http://www.w3.org/2001/XMLSchema#integer>)) }";
        ast = "Query(Projection(?o), GraphPattern(Group(Filters(PolymorphicGt(?o, \"\"\"0\"\"\"^^<http://www.w3.org/2001/XMLSchema#integer>)), BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // filter prefix operator: !o
        query = "SELECT ?o WHERE { <http://fake.url/s> ?p ?o FILTER ((!?o)) }";
        ast = "Query(Projection(?o), GraphPattern(Group(Filters(Not(?o)), BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // filter function: isIRI(?o)
        query = "SELECT ?o WHERE { <http://fake.url/s> ?p ?o FILTER (isIRI(?o)) }";
        ast = "Query(Projection(?o), GraphPattern(Group(Filters(IsIRI(?o)), BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // nested filters: regex(str(?o), "@peter", "i")
        query = "SELECT ?o WHERE { <http://fake.url/s> ?p ?o FILTER (regex(str(?o), \"@peter\", \"i\")) }";
        ast = "Query(Projection(?o), GraphPattern(Group(Filters(RegEx(Str(?o), \"@peter\", \"i\")), BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // filter operator precedence: !?o && ?p || ?o
        query = "SELECT ?o WHERE { <http://fake.url/s> ?p ?o FILTER (((!?o) && (?p || ?o))) }";
        ast = "Query(Projection(?o), GraphPattern(Group(Filters(LogicalAnd(Not(?o), LogicalOr(?p, ?o))), BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // filter operator precidence, variation: (!?o && ?p) || ?o
        query = "SELECT ?o WHERE { <http://fake.url/s> ?p ?o FILTER ((((!?o) && ?p) || ?o)) }";
        ast = "Query(Projection(?o), GraphPattern(Group(Filters(LogicalOr(LogicalAnd(Not(?o), ?p), ?o)), BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // select distinct
        query = "SELECT DISTINCT ?o WHERE { <http://fake.url/s> ?p ?o } ORDER BY ASC(?o)";
        ast = "Query(OrderBy(?o), Projection(DISTINCT, ?o), GraphPattern(Group(BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // select reduced
        query = "SELECT REDUCED ?o WHERE { <http://fake.url/s> ?p ?o }";
        ast = "Query(Projection(REDUCED, ?o), GraphPattern(Group(BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // select count
        query = "SELECT (COUNT(*) AS ?count) ?o WHERE { <http://fake.url/s> ?p ?o } GROUP BY ?o";
        ast = "Query(Projection(ProjectAs(Count(*), ?count), ?o, GroupBy(?o)), GraphPattern(Group(BGP(TriplePatternNode(<http://fake.url/s> ?p ?o)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // ask
        query = "ASK WHERE { <http://fake.url/s> <http://fake.url/p> \"\"\"0\"\"\"^^<http://www.w3.org/2001/XMLSchema#integer> }";
        ast = "Query(Ask(), GraphPattern(Group(BGP(TriplePatternNode(<http://fake.url/s> <http://fake.url/p> \"\"\"0\"\"\"^^<http://www.w3.org/2001/XMLSchema#integer>)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // construct
        query = "CONSTRUCT { ?o <http://fake.url/p2> ?o2. ?o2 <http://fake.url/p3> <http://fake.url/s> } WHERE { <http://fake.url/s> ?p ?o. ?o <http://fake.url/p> ?o2 }";
        ast = "Query(Construct(TriplePatternNode(?o <http://fake.url/p2> ?o2), TriplePatternNode(?o2 <http://fake.url/p3> <http://fake.url/s>)), GraphPattern(Group(BGP(TriplePatternNode(<http://fake.url/s> ?p ?o), TriplePatternNode(?o <http://fake.url/p> ?o2)))))";
        queries.add(new CanonicalQueryStrings(query, ast));

        // complicated w/ optionals
        //query = "SELECT ?o1 ?o3 ?o4 ?o5 WHERE { ?s <http://fake.url/p1> ?o1 ; <http://fake.url/p2> [ <http://fake.url/p3> ?o3 ] OPTIONAL { ?s <http://fake.url/p2> [ <http://fake.url/p4> ?o4 ] } OPTIONAL { ?s <http://fake.url/p5> ?o5 } }";
        query = "SELECT ?o1 ?o3 ?o4 ?o5 WHERE { ?s <http://fake.url/p1> ?o1. _:b1 <http://fake.url/p3> ?o3. ?s <http://fake.url/p2> _:b1 OPTIONAL { _:b2 <http://fake.url/p4> ?o4. ?s <http://fake.url/p2> _:b2 } OPTIONAL { ?s <http://fake.url/p5> ?o5 } }";
        ast = "Query(Projection(?o1, ?o3, ?o4, ?o5), GraphPattern(Group(Optional(Group(Optional(Group(BGP(TriplePatternNode(?s <http://fake.url/p1> ?o1), TriplePatternNode(_:b1 <http://fake.url/p3> ?o3), TriplePatternNode(?s <http://fake.url/p2> _:b1))), Group(BGP(TriplePatternNode(_:b2 <http://fake.url/p4> ?o4), TriplePatternNode(?s <http://fake.url/p2> _:b2))))), Group(BGP(TriplePatternNode(?s <http://fake.url/p5> ?o5)))))))";
        queries.add(new CanonicalQueryStrings(query, ast));
    }

    String generateAbstractSyntax(String query) throws Exception {
        Engine engine = new Engine(new MockEngineConfig(LexicalOrderBasedExecutionPlan.class));

        QueryController prepareQuery = engine.prepareQuery(null, query);

        return PrettyPrinter.print(prepareQuery);
    }

    String parseAndSerialize(String query) throws Exception {
        Engine engine = new Engine(new MockEngineConfig(LexicalOrderBasedExecutionPlan.class));

        QueryController prepareQuery = engine.prepareQuery(null, query);

        return prepareQuery.getQueryString(true);
    }

    /**
     * Test abstract sparql syntax
     *
     * @throws Exception
     */
    public void testSparqlToAbstractSyntax() throws Exception {
        for (CanonicalQueryStrings query : queries) {
            assertEquals(query.ast, generateAbstractSyntax(query.sparql));
        }
    }

    /**
     * Test parse and serialize query
     *
     * @throws Exception
     */
    public void testParseAndSerializeQuery() throws Exception {
        for (CanonicalQueryStrings query : queries) {
            assertEquals(query.sparql, parseAndSerialize(query.sparql));
        }
    }

    static class CanonicalQueryStrings {
        public final String sparql;

        public final String ast;

        public CanonicalQueryStrings(String sparql, String ast) {
            this.sparql = sparql;
            this.ast = ast;
        }
    }
}
