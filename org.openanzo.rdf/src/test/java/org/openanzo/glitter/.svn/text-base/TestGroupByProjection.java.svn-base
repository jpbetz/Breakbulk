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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.openanzo.glitter.expression.aggregate.Count;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.PatternSolutionImpl;
import org.openanzo.glitter.query.Projection;
import org.openanzo.glitter.query.SolutionList;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.FunctionCall;
import org.openanzo.glitter.syntax.abstrakt.SimpleExpression;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.MemVariable;
import org.openanzo.rdf.Variable;

/**
 * Test group by projection
 *
 */
public class TestGroupByProjection extends TestCase {

    /*
     * setup a simple solution list with enough possible GROUP BY permutations for all the needs of the
     * below tests.
     *
     *  x  | y   | z
     * ----------------
     * x_1 | y_4 | z_1
     * x_1 | y_4 | z_1
     * x_3 | y_4 | z_1
     * x_1 | y_4 | z_2
     *
     */
    private static SolutionList solution = new SolutionList();

    private static Variable     x        = MemVariable.createVariable("x");

    private static Variable     y        = MemVariable.createVariable("y");

    private static Variable     z        = MemVariable.createVariable("z");

    private static Variable     count    = MemVariable.createVariable("count");

    private static Expression   countStar, countDistinctStar, xExpression, zExpression;
    static {
        try {
            countStar = new FunctionCall(new Count(), Collections.<Expression> emptyList(), true, false);
            countDistinctStar = new FunctionCall(new Count(), Collections.<Expression> emptyList(), true, true);
            xExpression = new SimpleExpression(x);
            zExpression = new SimpleExpression(z);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static {
        PatternSolutionImpl pattern1 = new PatternSolutionImpl();
        pattern1.setBinding(x, MemTypedLiteral.create("x_1"));
        pattern1.setBinding(y, MemTypedLiteral.create("y_4"));
        pattern1.setBinding(z, MemTypedLiteral.create("z_1"));
        solution.add(pattern1);

        PatternSolutionImpl pattern2 = new PatternSolutionImpl();
        pattern2.setBinding(x, MemTypedLiteral.create("x_1"));
        pattern2.setBinding(y, MemTypedLiteral.create("y_4"));
        pattern2.setBinding(z, MemTypedLiteral.create("z_1"));
        solution.add(pattern2);

        PatternSolutionImpl pattern3 = new PatternSolutionImpl();
        pattern3.setBinding(x, MemTypedLiteral.create("x_3"));
        pattern3.setBinding(y, MemTypedLiteral.create("y_4"));
        pattern3.setBinding(z, MemTypedLiteral.create("z_1"));
        solution.add(pattern3);

        PatternSolutionImpl pattern4 = new PatternSolutionImpl();
        pattern4.setBinding(x, MemTypedLiteral.create("x_1"));
        pattern4.setBinding(y, MemTypedLiteral.create("y_4"));
        pattern4.setBinding(z, MemTypedLiteral.create("z_2"));
        solution.add(pattern4);
    }

    /**
     * "SELECT count(*) ... GROUP BY ?x" should result in:
     *
     * <pre>
     *  count
     * -------
     *   3
     *   1
     * </pre>
     *
     * @throws Exception
     */
    public void testProjectGroupedCount() throws Exception {

        List<Variable> groupBy = new ArrayList<Variable>();
        groupBy.add(x);

        Projection p = new Projection(Collections.singletonList(countStar), Collections.singletonList(count), groupBy, false, false, false);
        SolutionSet countGroupBy = p.refineSolutionsBeforeOrdering(solution);
        countGroupBy = p.refineSolutionsAfterOrdering(countGroupBy, null);

        assertEquals(2, countGroupBy.size());
        assertEquals(MemTypedLiteral.create(BigInteger.valueOf(3)), countGroupBy.get(0).getBinding(count));
        assertNull(countGroupBy.get(0).getBinding(x));
        assertEquals(MemTypedLiteral.create(BigInteger.valueOf(1)), countGroupBy.get(1).getBinding(count));
        assertNull(countGroupBy.get(1).getBinding(x));
    }

    /**
     * SELECT ?x COUNT(*) ... GROUP BY ?x" should result in:
     *
     * <pre>
     *   x  | count
     * ------------
     *  x_1 |  3
     *  x_3 |  1
     * </pre>
     *
     * @throws Exception
     */
    public void testProjectSingleBindingGroupAndCount() throws Exception {

        List<Variable> groupBy = new ArrayList<Variable>();
        groupBy.add(x);

        List<Expression> projected = new ArrayList<Expression>();
        projected.add(xExpression);
        projected.add(countStar);

        List<Variable> projectedAs = new ArrayList<Variable>();
        projectedAs.add(x);
        projectedAs.add(count);

        Projection p = new Projection(projected, projectedAs, groupBy, false, false, false);
        SolutionSet countGroupBy = p.refineSolutionsBeforeOrdering(solution);
        countGroupBy = p.refineSolutionsAfterOrdering(countGroupBy, null);

        assertEquals(2, countGroupBy.size());
        assertEquals(MemTypedLiteral.create(BigInteger.valueOf(3)), countGroupBy.get(0).getBinding(count));
        assertEquals(MemTypedLiteral.create("x_1"), countGroupBy.get(0).getBinding(x));
        assertEquals(MemTypedLiteral.create(BigInteger.valueOf(1)), countGroupBy.get(1).getBinding(count));
        assertEquals(MemTypedLiteral.create("x_3"), countGroupBy.get(1).getBinding(x));
    }

    /**
     * SELECT ?x ?z COUNT(*) ... GROUP BY ?x ?z" should result in:
     *
     * <pre>
     *   x  |  z  | count
     * ------------------
     *  x_1 | z_1 |  2
     *  x_3 | z_1 |  1
     *  x_1 | z_2 |  1
     * </pre>
     *
     * @throws Exception
     */
    public void testProjectMultiBindingGroupAndCount() throws Exception {

        List<Variable> groupBy = new ArrayList<Variable>();
        groupBy = new ArrayList<Variable>();
        groupBy.add(x);
        groupBy.add(z);

        List<Expression> projected = new ArrayList<Expression>();
        projected.add(xExpression);
        projected.add(zExpression);
        projected.add(countStar);

        List<Variable> projectedAs = new ArrayList<Variable>(groupBy);
        projectedAs.add(count);

        Projection p = new Projection(projected, projectedAs, groupBy, false, false, false);
        SolutionSet countGroupBy = p.refineSolutionsBeforeOrdering(solution);
        countGroupBy = p.refineSolutionsAfterOrdering(countGroupBy, null);

        assertEquals(3, countGroupBy.size());

        HashMap<String, HashMap<String, Integer>> expected = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String, Integer> x1 = new HashMap<String, Integer>();
        x1.put("z_1", 2);
        x1.put("z_2", 1);
        HashMap<String, Integer> x3 = new HashMap<String, Integer>();
        x3.put("z_1", 1);

        expected.put("x_1", x1);
        expected.put("x_3", x3);

        for (PatternSolution sol : countGroupBy) {
            HashMap<String, Integer> zmap = expected.get(((Literal) sol.getBinding(x)).getLabel());
            assertNotNull(zmap);
            Integer i = zmap.get(((Literal) sol.getBinding(z)).getLabel());
            assertNotNull(i);
            assertEquals(MemTypedLiteral.create(BigInteger.valueOf(i)), sol.getBinding(count));
            expected.remove(sol.getBinding(z));
        }
    }

    /**
     * SELECT ?z COUNT(DISTINCT *) ... GROUP BY ?z" should result in:
     *
     * <pre>
     *   z  | count
     * -------------
     *  z_1 |  2
     *  z_2 |  1
     * </pre>
     *
     * @throws Exception
     */
    public void testGroupByDistinct() throws Exception {
        List<Variable> groupBy = new ArrayList<Variable>();
        groupBy = new ArrayList<Variable>();
        groupBy.add(z);

        List<Expression> projected = new ArrayList<Expression>();
        projected.add(zExpression);
        projected.add(countDistinctStar);

        List<Variable> projectedAs = new ArrayList<Variable>(groupBy);
        projectedAs.add(count);

        Projection p = new Projection(projected, projectedAs, groupBy, false, false, false);
        SolutionSet countGroupBy = p.refineSolutionsBeforeOrdering(solution);
        countGroupBy = p.refineSolutionsAfterOrdering(countGroupBy, null);

        assertEquals(2, countGroupBy.size());

        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("z_1", 2);
        expected.put("z_2", 1);

        for (PatternSolution sol : countGroupBy) {
            Integer i = expected.get(((Literal) sol.getBinding(z)).getLabel());
            assertNotNull(i);
            assertEquals(MemTypedLiteral.create(BigInteger.valueOf(i)), sol.getBinding(count));
            expected.remove(sol.getBinding(z));
        }
    }

    /**
     * Sanity test to got with above 'testGroupByDistinct' SELECT ?z COUNT(*) ... GROUP BY ?z" should result in:
     *
     * <pre>
     *   z  | count
     * -------------
     *  z_1 |  3   &lt;--- * 3 instead of 2
     *  z_2 |  1
     * </pre>
     *
     * @throws Exception
     */
    public void testGroupByNonDistinct() throws Exception {
        List<Variable> groupBy = new ArrayList<Variable>();
        groupBy = new ArrayList<Variable>();
        groupBy.add(z);

        List<Expression> projected = new ArrayList<Expression>();
        projected.add(zExpression);
        projected.add(countStar);

        List<Variable> projectedAs = new ArrayList<Variable>(groupBy);
        projectedAs.add(count);

        Projection p = new Projection(projected, projectedAs, groupBy, false, false, false);
        SolutionSet countGroupBy = p.refineSolutionsBeforeOrdering(solution);
        countGroupBy = p.refineSolutionsAfterOrdering(countGroupBy, null);

        assertEquals(2, countGroupBy.size());

        HashMap<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("z_1", 3);
        expected.put("z_2", 1);

        for (PatternSolution sol : countGroupBy) {
            Integer i = expected.get(((Literal) sol.getBinding(z)).getLabel());
            assertNotNull(i);
            assertEquals(MemTypedLiteral.create(BigInteger.valueOf(i)), sol.getBinding(count));
            expected.remove(sol.getBinding(z));
        }
    }
}
