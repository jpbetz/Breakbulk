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

import java.util.HashSet;

import junit.framework.TestCase;

import org.openanzo.glitter.query.PatternSolutionImpl;
import org.openanzo.glitter.query.SPARQLAlgebra;
import org.openanzo.glitter.query.SolutionList;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.MemVariable;
import org.openanzo.rdf.Variable;

/**
 * Tests SPARQL algebraic operations.
 *
 */
public class TestSPARQLAlgebra extends TestCase {

    private static SolutionList solutionsLHS              = new SolutionList();

    private static SolutionList solutionsRHS              = new SolutionList();

    private static SolutionList solutionExpectedLeftJoin = new SolutionList();

    private static SolutionList solutionExpectedJoin     = new SolutionList();

    private static Variable     x                        = MemVariable.createVariable("x");

    private static Variable     y                        = MemVariable.createVariable("y");

    static {
        PatternSolutionImpl patternA1 = new PatternSolutionImpl();
        patternA1.setBinding(x, MemTypedLiteral.create("x1"));
        patternA1.setBinding(y, MemTypedLiteral.create("y1"));
        solutionsLHS.add(patternA1);

        PatternSolutionImpl patternA2 = new PatternSolutionImpl();
        patternA2.setBinding(y, MemTypedLiteral.create("y2"));
        solutionsLHS.add(patternA2);

        PatternSolutionImpl patternB1 = new PatternSolutionImpl();
        patternB1.setBinding(x, MemTypedLiteral.create("x1"));
        patternB1.setBinding(y, MemTypedLiteral.create("y3"));
        solutionsRHS.add(patternB1);

        PatternSolutionImpl patternB2 = new PatternSolutionImpl();
        patternB2.setBinding(x, MemTypedLiteral.create("x2"));
        patternB2.setBinding(y, MemTypedLiteral.create("y2"));
        solutionsRHS.add(patternB2);

        solutionExpectedLeftJoin.add(patternA1);
        solutionExpectedLeftJoin.add(patternB2);

        solutionExpectedJoin.add(patternB2);
    }

    /**
     * Test left join logic
     *
     * @throws Exception
     */
    public void testLeftJoin1() throws Exception {
        SolutionSet ssActual = SPARQLAlgebra.leftJoin(solutionsLHS, solutionsRHS, new HashSet<Expression>());
        assertEquals(solutionExpectedLeftJoin, ssActual);
    }

    /**
     * Test join logic
     *
     * @throws Exception
     */
    public void testJoin() throws Exception {
        SolutionSet ssActual = SPARQLAlgebra.join(solutionsLHS, solutionsRHS);
        assertEquals(solutionExpectedJoin, ssActual);
    }

}
