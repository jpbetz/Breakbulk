package org.openanzo.jdbc.query;

import java.io.ByteArrayInputStream;
import java.util.Collections;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.SPARQLAlgebra;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.rdf.MemVariable;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.adapter.BasicNodeConverter;
import org.openanzo.rdf.adapter.ResultHandler;
import org.openanzo.rdf.adapter.RioResultHandler;
import org.openanzo.rdf.vocabulary.FOAF;
import org.openrdf.query.resultio.sparqlxml.SPARQLResultsXMLParser;

/**
 * Test sparql algegra
 * 
 */
public class TestSPARQLAlgebra extends TestCase {
    static final Variable a  = MemVariable.createVariable("a");

    static final Variable b  = MemVariable.createVariable("b");

    static final Variable c  = MemVariable.createVariable("c");

    static final URI      u1 = FOAF.name;

    static final URI      u2 = FOAF.title;

    static final URI      u3 = FOAF.img;

    static final URI      u4 = FOAF.age;

    static final URI      u5 = FOAF.birthday;

    static final URI      u6 = FOAF.homepage;

    /**
     * @throws Exception
     */
    public void testJoinFullMatch() throws Exception {
        verifyJoin("join-full-match");
    }

    /**
     * @throws Exception
     */
    public void testJoinNonIntersecting() throws Exception {
        verifyJoin("join-non-intersecting");
    }

    /**
     * @throws Exception
     */
    public void testJoinNoMatch() throws Exception {
        verifyJoin("join-no-match");
    }

    /**
     * @throws Exception
     */
    public void testJoinPartialMatch() throws Exception {
        verifyJoin("join-partial-match");
    }

    /**
     * @throws Exception
     */
    public void testJoinMulitBindingMatch() throws Exception {
        verifyJoin("join-multi-binding-match");
    }

    /**
     * @throws Exception
     */
    public void testLeftJoinMulitBindingMatch() throws Exception {
        verifyLeftJoin("left-join-multi-binding-match");
    }

    /**
     * @param testName
     * @throws Exception
     */
    public void verifyJoin(String testName) throws Exception {
        verifyJoin(testName + "-solution1.srx", testName + "-solution2.srx", testName + "-result.srx", false);
    }

    /**
     * @param testName
     * @throws Exception
     */
    public void verifyLeftJoin(String testName) throws Exception {
        verifyJoin(testName + "-solution1.srx", testName + "-solution2.srx", testName + "-result.srx", true);
    }

    /**
     * @param input1
     * @param input2
     * @param result
     * @param leftJoin
     * @throws Exception
     */
    public void verifyJoin(String input1, String input2, String result, boolean leftJoin) throws Exception {
        SolutionSet set1 = customize(getSolution(input1));
        SolutionSet set2 = customize(getSolution(input2));
        SolutionSet expected = getSolution(result);

        SolutionSet actual;
        if (leftJoin) {
            actual = SPARQLAlgebra.leftJoin(set1, set2, Collections.<Expression> emptySet());
        } else {
            actual = SPARQLAlgebra.join(set1, set2);
        }

        actual = normalize(actual);
        assertEquals(expected.size(), actual.size());
        for (PatternSolution sol : expected) {
            assertTrue(actual.contains(sol));
        }
    }

    /**
     * @param set
     * @return the
     */
    SolutionSet normalize(SolutionSet set) {
        return set;
    }

    // default impl does nothing, subclasses of this test suite should customize for the type of RDF Values they are checking.
    /**
     * @param set
     * @return
     */
    SolutionSet customize(SolutionSet set) {
        return set;
    }

    /**
     * @param filename
     * @return
     * @throws Exception
     */
    static SolutionSet getSolution(String filename) throws Exception {
        String input = IOUtils.toString(TestSPARQLAlgebra.class.getResourceAsStream(filename), "UTF-8");
        RioResultHandler handler = new RioResultHandler(new ResultHandler());
        SPARQLResultsXMLParser parser = new SPARQLResultsXMLParser(BasicNodeConverter.valueFactory);
        parser.setTupleQueryResultHandler(handler);
        parser.parse(new ByteArrayInputStream(input.getBytes("UTF-8")));
        return handler.getQueryResults().getSelectResults();
    }
}
