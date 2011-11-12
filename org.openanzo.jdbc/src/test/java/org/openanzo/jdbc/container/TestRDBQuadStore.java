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
package org.openanzo.jdbc.container;

import java.util.Iterator;

import junit.framework.TestCase;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Unit tests of the RDBQuadStore class using Apache Derby as the relational database.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TestRDBQuadStore extends TestCase {
    private static final String    prefix = "http://test.example.com/test#";

    private static final URI       subj1  = Constants.valueFactory.createURI(prefix + "s1");

    private static final URI       pred1  = Constants.valueFactory.createURI(prefix + "p1");

    private static final URI       graph1 = Constants.valueFactory.createURI(prefix + "namedGraph1");

    private static final URI       pred2  = Constants.valueFactory.createURI(prefix + "p2");

    private static final URI       pred3  = Constants.valueFactory.createURI(prefix + "p3");

    private static final Value     obj1   = Constants.valueFactory.createLiteral("o1");

    private static final Value     obj2   = Constants.valueFactory.createLiteral("o2");

    private static final Value     obj7   = Constants.valueFactory.createTypedLiteral(4);

    private static final URI       graph2 = Constants.valueFactory.createURI(prefix + "namedGraph2");

    private static final URI       graph3 = Constants.valueFactory.createURI(prefix + "namedGraph3");

    private static final Statement stmt7  = Constants.valueFactory.createStatement(subj1, pred3, obj7, graph3);

    private static final Statement stmt1  = Constants.valueFactory.createStatement(subj1, pred1, obj1, graph1);

    private static final Statement stmt2  = Constants.valueFactory.createStatement(subj1, pred2, obj2, graph2);

    /**
     * Verify rdf statements can be added and removed from the quad store.
     * 
     * @throws Exception
     */
    public void testAddRemove() throws Exception {
        CoreDBConfiguration config = RDBTestUtilities.getConfiguration("ANZO_TEST");
        RDBQuadStore quadStore = RDBTestUtilities.getRDBQuadStore(config);
        quadStore.add(stmt7);
        assertTrue(quadStore.contains(stmt7));

        quadStore.close();

        quadStore = RDBQuadStore.createQuadStore(config, true);
        quadStore.connect();

        assertTrue(quadStore.contains(stmt7));

        quadStore.remove(stmt7);
        assertFalse(quadStore.contains(stmt7));
    }

    /**
     * Verify a find with a wild card object returns only the matching statement.
     * 
     * @throws Exception
     */
    public void testFind() throws Exception {
        RDBQuadStore quadStore = RDBTestUtilities.getRDBQuadStore();

        quadStore.add(stmt1);
        quadStore.add(stmt2);

        Iterator<Statement> find = quadStore.find(stmt1.getSubject(), stmt1.getPredicate(), null, stmt1.getNamedGraphUri()).iterator();
        assertTrue(find.hasNext());
        assertEquals(stmt1, find.next());
        assertFalse(find.hasNext());
    }

    /**
     * Verify a transaction can be aborted properly.
     * 
     * @throws Exception
     */
    public void testAbort() throws Exception {
        RDBQuadStore quadStore = RDBTestUtilities.getRDBQuadStore();

        quadStore.begin();

        quadStore.add(stmt1);
        quadStore.add(stmt2);

        assertTrue(quadStore.contains(stmt1)); // hsql doesn't support read transaction isolation
        assertTrue(quadStore.contains(stmt2));

        quadStore.abort();

        assertFalse(quadStore.contains(stmt1));
        assertFalse(quadStore.contains(stmt2));
    }

    /**
     * Verifies two quad stores are properly isolated from each other and may co-exist.
     * 
     * @throws Exception
     */
    public void testDualStores() throws Exception {
        RDBQuadStore quadStore = RDBTestUtilities.getRDBQuadStore();

        RDBQuadStore clientState = RDBTestUtilities.getRDBQuadStore("clientStateWithAFairlyLongName");

        quadStore.add(stmt1);
        clientState.add(stmt2);

        assertTrue(quadStore.contains(stmt1));
        assertTrue(clientState.contains(stmt2));

        assertFalse(quadStore.contains(stmt2));
        assertFalse(clientState.contains(stmt1));
    }
}
