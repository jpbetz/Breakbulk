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

import junit.framework.TestCase;

import org.openanzo.glitter.expression.builtin.function.PartitionIndex;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Tests SPARQL algebraic operations.
 *
 */
public class TestGlitterFunctions extends TestCase {


    /**
     * Test partition index on doubles that result in imprecise FP-representation
     *
     * @throws Exception
     */
    public void testPartitionIndexImprecision() throws Exception {
        PartitionIndex pi = new PartitionIndex();
        Value value = MemTypedLiteral.create("1.16", XMLSchema.DOUBLE);
        Value start = MemTypedLiteral.create("1.01", XMLSchema.DOUBLE);
        Value interval = MemTypedLiteral.create("0.03", XMLSchema.DOUBLE);
        Value index = pi.call(value, start, interval);

        Value expected = MemTypedLiteral.create("5", XMLSchema.INTEGER);

        assertEquals(expected, index);
    }
}
