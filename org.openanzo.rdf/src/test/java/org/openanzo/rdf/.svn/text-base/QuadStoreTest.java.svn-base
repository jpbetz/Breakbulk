/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 1, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf;

import static org.openanzo.rdf.query.QueryEncoder.encodeForQuery;
import info.aduna.collections.iterators.Iterators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import junit.framework.TestCase;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.vocabulary.RDF;

/**
 * Coverage test for quadstore
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class QuadStoreTest extends TestCase {

    /**
     * Speed test for quadstore operations
     * 
     * @throws Exception
     */
    public void i_testQuadStoreSpeed() throws Exception {
        MemQuadStore quadStore = new MemQuadStore();
        URI typeA = Constants.valueFactory.createURI("http://test/type/a");
        URI typeB = Constants.valueFactory.createURI("http://test/type/b");
        URI typeC = Constants.valueFactory.createURI("http://test/type/c");
        URI typeD = Constants.valueFactory.createURI("http://test/type/d");
        URI typeE = Constants.valueFactory.createURI("http://test/type/e");

        URI link1 = Constants.valueFactory.createURI("http://test/type/link1");
        URI link2 = Constants.valueFactory.createURI("http://test/type/link2");
        URI link3 = Constants.valueFactory.createURI("http://test/type/link3");
        URI link4 = Constants.valueFactory.createURI("http://test/type/link4");

        for (int i = 0; i < 20; i++) {
            URI ng = Constants.valueFactory.createURI("http://test/namedgraph/" + i);
            for (int j = 0; j < 400; j++) {
                URI a = Constants.valueFactory.createURI("http://test/subject/1" + j);
                URI b = Constants.valueFactory.createURI("http://test/subject/b" + j);
                URI c = Constants.valueFactory.createURI("http://test/subject/c" + j);
                URI d = Constants.valueFactory.createURI("http://test/subject/d" + j);
                URI e = Constants.valueFactory.createURI("http://test/subject/e" + j);
                URI f = Constants.valueFactory.createURI("http://test/subject/f" + j);

                quadStore.add(Constants.valueFactory.createStatement(a, RDF.TYPE, typeA, ng));
                quadStore.add(Constants.valueFactory.createStatement(b, RDF.TYPE, typeB, ng));
                quadStore.add(Constants.valueFactory.createStatement(c, RDF.TYPE, typeC, ng));
                quadStore.add(Constants.valueFactory.createStatement(d, RDF.TYPE, typeD, ng));
                quadStore.add(Constants.valueFactory.createStatement(e, RDF.TYPE, typeE, ng));
                quadStore.add(Constants.valueFactory.createStatement(f, RDF.TYPE, typeE, ng));

                quadStore.add(Constants.valueFactory.createStatement(a, link1, b, ng));
                quadStore.add(Constants.valueFactory.createStatement(c, link1, d, ng));
                quadStore.add(Constants.valueFactory.createStatement(a, link2, e, ng));
                quadStore.add(Constants.valueFactory.createStatement(c, link3, f, ng));
                quadStore.add(Constants.valueFactory.createStatement(e, link4, f, ng));
            }
        }
        String query = "select ?a  where {" + " ?a " + encodeForQuery(RDF.TYPE) + "  " + encodeForQuery(typeA) + ". " //1
                + " ?a " + encodeForQuery(link1) + " ?b."//2
                + " ?b " + encodeForQuery(RDF.TYPE) + " " + encodeForQuery(typeB) + "."//3
                + " ?c " + encodeForQuery(RDF.TYPE) + "  " + encodeForQuery(typeC) + "."//4
                + " ?c " + encodeForQuery(link1) + " ?d."//5
                + " ?d " + encodeForQuery(RDF.TYPE) + " " + encodeForQuery(typeD) + "."//6
                + " ?e " + encodeForQuery(RDF.TYPE) + "  " + encodeForQuery(typeE) + "."//7
                + " ?a " + encodeForQuery(link2) + " ?e."//8
                + " ?f " + encodeForQuery(RDF.TYPE) + "  " + encodeForQuery(typeE) + "."//8
                + " ?c " + encodeForQuery(link3) + " ?f."//9
                + " ?e " + encodeForQuery(link4) + " ?f.}";//10

        for (int i = 0; i < 20; i++) {
            long start = System.currentTimeMillis();
            URI ng1 = Constants.valueFactory.createURI("http://test/namedgraph/" + i);
            QueryResults results = quadStore.executeQuery(Collections.<URI> singleton(ng1), Collections.<URI> singleton(ng1), null, query, null);
            System.err.println("Size=" + results.getSelectResults().size() + ":" + (System.currentTimeMillis() - start));
        }
        System.err.println("Done queries");
        /*
          assertNotNull(last);
        long end = System.nanoTime();
        System.err.println("AddAll:" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size = find(quadStore, null, RDF.TYPE, Constants.valueFactory.createURI("http://type/0"), (URI[]) null).size();
        end = System.nanoTime();
        System.err.println("FindTypes(" + size + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size1 = find(quadStore, last.getSubject(), null, null, (URI[]) null).size();
        end = System.nanoTime();
        System.err.println("FindStmt1(" + size1 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size2 = find(quadStore, null, last.getPredicate(), null, (URI[]) null).size();
        end = System.nanoTime();
        System.err.println("FindStmt2(" + size2 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size3 = find(quadStore, last.getSubject(), last.getPredicate(), null, (URI[]) null).size();
        end = System.nanoTime();
        System.err.println("FindStmt3(" + size3 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size4 = find(quadStore, null, null, last.getObject(), (URI[]) null).size();
        end = System.nanoTime();
        System.err.println("FindStmt4(" + size4 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size5 = find(quadStore, last.getSubject(), null, last.getObject(), (URI[]) null).size();
        end = System.nanoTime();
        System.err.println("FindStmt5(" + size5 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size6 = find(quadStore, null, last.getPredicate(), last.getObject(), (URI[]) null).size();
        end = System.nanoTime();
        System.err.println("FindStmt6(" + size6 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size7 = find(quadStore, last.getSubject(), last.getPredicate(), last.getObject(), (URI[]) null).size();
        end = System.nanoTime();
        System.err.println("FindStmt7(" + size7 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size8 = find(quadStore, null, null, null, last.getNamedGraphUri()).size();
        end = System.nanoTime();
        System.err.println("FindStmt8(" + size8 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size9 = find(quadStore, last.getSubject(), null, null, last.getNamedGraphUri()).size();
        end = System.nanoTime();
        System.err.println("FindStmt9(" + size9 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size10 = find(quadStore, null, last.getPredicate(), null, last.getNamedGraphUri()).size();
        end = System.nanoTime();
        System.err.println("FindStmt10(" + size10 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size11 = find(quadStore, last.getSubject(), last.getPredicate(), null, last.getNamedGraphUri()).size();
        end = System.nanoTime();
        System.err.println("FindStmt11(" + size11 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size12 = find(quadStore, null, null, last.getObject(), last.getNamedGraphUri()).size();
        end = System.nanoTime();
        System.err.println("FindStmt12(" + size12 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size13 = find(quadStore, last.getSubject(), null, last.getObject(), last.getNamedGraphUri()).size();
        end = System.nanoTime();
        System.err.println("FindStmt13(" + size13 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size14 = find(quadStore, null, last.getPredicate(), last.getObject(), last.getNamedGraphUri()).size();
        end = System.nanoTime();
        System.err.println("FindStmt14(" + size14 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        start = System.nanoTime();
        int size15 = find(quadStore, last.getSubject(), last.getPredicate(), last.getObject(), last.getNamedGraphUri()).size();
        end = System.nanoTime();
        System.err.println("FindStmt15(" + size15 + "):" + ((end - start) / 1000000) + ":" + (end - start));
        */
    }

    static Statement stmt2 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri2"), Constants.valueFactory.createURI("http://testPred2"), Constants.valueFactory.createURI("http://testObj2"), Constants.valueFactory.createURI("http://testNg"));

    static Statement stmt3 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri3"), Constants.valueFactory.createURI("http://testPred3"), Constants.valueFactory.createURI("http://testObj3"), Constants.valueFactory.createURI("http://testNg3"));

    /**
     * Test adding and deleting statements from a quadstore
     * 
     * @throws Exception
     */
    @SuppressWarnings("null")
    public void testAddDelete() throws Exception {
        MemQuadStore quadStore = new MemQuadStore();
        AnzoRuntimeException e = null;
        Statement stmt = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri"), Constants.valueFactory.createURI("http://testPred"), Constants.valueFactory.createURI("http://testObj"));
        try {
            quadStore.add(stmt);
        } catch (AnzoRuntimeException are) {
            e = are;
        }
        assertNotNull(e);
        assertEquals(ExceptionConstants.CLIENT.URI_NOT_NULL, e.getErrorCode());
        try {
            quadStore.remove(stmt);
        } catch (AnzoRuntimeException are) {
            e = are;
        }
        assertNotNull(e);
        assertEquals(ExceptionConstants.CLIENT.URI_NOT_NULL, e.getErrorCode());
        quadStore.clear();
        assertEquals(0, quadStore.size());
        assertTrue(quadStore.isEmpty());
        quadStore.add();
        assertEquals(0, quadStore.size());
        assertTrue(quadStore.isEmpty());
        quadStore.add(stmt2, stmt3);
        assertEquals(2, quadStore.size());
        assertFalse(quadStore.isEmpty());
        assertEquals(2, quadStore.getNamedGraphUris().size());
        quadStore.remove(stmt2);
        assertEquals(1, quadStore.size());
        assertFalse(quadStore.isEmpty());
        quadStore.remove(stmt3);
        assertEquals(0, quadStore.size());
        assertTrue(quadStore.isEmpty());
        quadStore.remove();
    }

    /**
     * Coverage test for quadstore contains operations
     * 
     * @throws Exception
     */
    public void testContains() throws Exception {
        Statement stmt4 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri4"), Constants.valueFactory.createURI("http://testPred4"), Constants.valueFactory.createURI("http://testObj4"), Constants.valueFactory.createURI("http://testNg4"));
        MemQuadStore quadStore = new MemQuadStore();
        assertFalse(quadStore.contains(stmt4));
        quadStore.add(stmt2);
        assertTrue(quadStore.contains(null, stmt2.getPredicate(), null, stmt2.getNamedGraphUri()));
        quadStore.add(stmt3);
        assertTrue(quadStore.contains(stmt2));
        assertTrue(quadStore.contains(stmt3));
        assertFalse(quadStore.contains(stmt4));
        assertTrue(quadStore.contains(null, null, null, (URI[]) null));
        assertTrue(quadStore.contains(stmt2.getSubject(), null, null, (URI[]) null));
        assertTrue(quadStore.contains(null, stmt2.getPredicate(), null, (URI[]) null));
        assertTrue(quadStore.contains(stmt2.getSubject(), stmt2.getPredicate(), null, (URI[]) null));
        assertTrue(quadStore.contains(null, null, stmt2.getObject(), (URI[]) null));
        assertTrue(quadStore.contains(stmt2.getSubject(), null, stmt2.getObject(), (URI[]) null));
        assertTrue(quadStore.contains(null, stmt2.getPredicate(), stmt2.getObject(), (URI[]) null));
        assertTrue(quadStore.contains(stmt2.getSubject(), stmt2.getPredicate(), stmt2.getObject(), (URI[]) null));
        assertTrue(quadStore.contains(null, null, null, stmt2.getNamedGraphUri()));
        assertTrue(quadStore.contains(stmt2.getSubject(), null, null, stmt2.getNamedGraphUri()));
        assertTrue(quadStore.contains(null, stmt2.getPredicate(), null, stmt2.getNamedGraphUri()));
        assertTrue(quadStore.contains(stmt2.getSubject(), stmt2.getPredicate(), null, stmt2.getNamedGraphUri()));
        assertTrue(quadStore.contains(null, null, stmt2.getObject(), stmt2.getNamedGraphUri()));
        assertTrue(quadStore.contains(stmt2.getSubject(), null, stmt2.getObject(), stmt2.getNamedGraphUri()));
        assertTrue(quadStore.contains(null, stmt2.getPredicate(), stmt2.getObject(), stmt2.getNamedGraphUri()));
        assertTrue(quadStore.contains(stmt2.getSubject(), stmt2.getPredicate(), stmt2.getObject(), stmt2.getNamedGraphUri()));
        assertTrue(quadStore.contains(null, null, null, stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()));
        assertTrue(quadStore.contains(stmt2.getSubject(), null, null, stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()));
        assertTrue(quadStore.contains(null, stmt2.getPredicate(), null, stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()));
        assertTrue(quadStore.contains(stmt2.getSubject(), stmt2.getPredicate(), null, stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()));
        assertTrue(quadStore.contains(null, null, stmt2.getObject(), stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()));
        assertTrue(quadStore.contains(stmt2.getSubject(), null, stmt2.getObject(), stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()));
        assertTrue(quadStore.contains(null, stmt2.getPredicate(), stmt2.getObject(), stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()));
        assertTrue(quadStore.contains(stmt2.getSubject(), stmt2.getPredicate(), stmt2.getObject(), stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()));
        assertFalse(quadStore.contains(stmt4.getSubject(), null, null, (URI[]) null));
        assertFalse(quadStore.contains(null, stmt4.getPredicate(), null, (URI[]) null));
        assertFalse(quadStore.contains(stmt4.getSubject(), stmt4.getPredicate(), null, (URI[]) null));
        assertFalse(quadStore.contains(stmt4.getSubject(), stmt3.getPredicate(), null, (URI[]) null));
        assertFalse(quadStore.contains(null, null, stmt4.getObject(), (URI[]) null));
        assertFalse(quadStore.contains(stmt4.getSubject(), null, stmt4.getObject(), (URI[]) null));
        assertFalse(quadStore.contains(null, stmt4.getPredicate(), stmt4.getObject(), (URI[]) null));
        assertFalse(quadStore.contains(null, stmt3.getPredicate(), stmt4.getObject(), (URI[]) null));
        assertFalse(quadStore.contains(stmt4.getSubject(), stmt4.getPredicate(), stmt4.getObject(), (URI[]) null));
        assertFalse(quadStore.contains(null, null, null, stmt4.getNamedGraphUri()));
        assertFalse(quadStore.contains(stmt4.getSubject(), null, null, stmt4.getNamedGraphUri()));
        assertFalse(quadStore.contains(null, stmt4.getPredicate(), null, stmt4.getNamedGraphUri()));
        assertFalse(quadStore.contains(stmt4.getSubject(), stmt4.getPredicate(), null, stmt4.getNamedGraphUri()));
        assertFalse(quadStore.contains(null, null, stmt4.getObject(), stmt4.getNamedGraphUri()));
        assertFalse(quadStore.contains(stmt4.getSubject(), null, stmt4.getObject(), stmt4.getNamedGraphUri()));
        assertFalse(quadStore.contains(null, stmt4.getPredicate(), stmt4.getObject(), stmt4.getNamedGraphUri()));
        assertFalse(quadStore.contains(stmt4.getSubject(), stmt4.getPredicate(), stmt4.getObject(), stmt4.getNamedGraphUri()));
        assertFalse(quadStore.contains(stmt4.getSubject(), stmt4.getPredicate(), stmt4.getObject(), stmt4.getNamedGraphUri(), stmt3.getNamedGraphUri()));
    }

    /**
     * Coverage test for quadstore find operations
     * 
     * @throws Exception
     */
    public void testfind() throws Exception {
        Statement stmt4 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri4"), Constants.valueFactory.createURI("http://testPred4"), Constants.valueFactory.createURI("http://testObj4"), Constants.valueFactory.createURI("http://testNg4"));
        Statement stmt5 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri5"), Constants.valueFactory.createURI("http://testPred5"), Constants.valueFactory.createURI("http://testObj5"), Constants.valueFactory.createURI("http://testNg5"));
        Statement stmt6 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri5"), Constants.valueFactory.createURI("http://testPred5"), Constants.valueFactory.createURI("http://testObj5"), Constants.valueFactory.createURI("http://testNg6"));
        Statement stmt7 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri7"), Constants.valueFactory.createURI("http://testPred7"), Constants.valueFactory.createURI("http://testObj7"), Constants.valueFactory.createURI("http://testNg7"));
        Statement stmt8 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri7"), Constants.valueFactory.createURI("http://testPred8"), Constants.valueFactory.createURI("http://testObj7"), Constants.valueFactory.createURI("http://testNg7"));
        Statement stmt9 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri7"), Constants.valueFactory.createURI("http://testPred9"), Constants.valueFactory.createURI("http://testObj7"), Constants.valueFactory.createURI("http://testNg7"));
        Statement stmt10 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri8"), Constants.valueFactory.createURI("http://testPred10"), Constants.valueFactory.createURI("http://testObj7"), Constants.valueFactory.createURI("http://testNg7"));
        Statement stmt11 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri9"), Constants.valueFactory.createURI("http://testPred10"), Constants.valueFactory.createURI("http://testObj7"), Constants.valueFactory.createURI("http://testNg7"));
        Statement stmt12 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri10"), Constants.valueFactory.createURI("http://testPred10"), Constants.valueFactory.createURI("http://testObj7"), Constants.valueFactory.createURI("http://testNg7"));
        Statement stmt13 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri11"), Constants.valueFactory.createURI("http://testPred11"), Constants.valueFactory.createURI("http://testObj8"), Constants.valueFactory.createURI("http://testNg7"));
        Statement stmt14 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri11"), Constants.valueFactory.createURI("http://testPred11"), Constants.valueFactory.createURI("http://testObj9"), Constants.valueFactory.createURI("http://testNg7"));
        Statement stmt15 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri11"), Constants.valueFactory.createURI("http://testPred11"), Constants.valueFactory.createURI("http://testObj10"), Constants.valueFactory.createURI("http://testNg7"));
        MemQuadStore quadStore = new MemQuadStore();
        assertFalse(quadStore.contains(stmt4));
        quadStore.add(stmt2, stmt3, stmt5, stmt6);
        assertEquals(4, find(quadStore, null, null, null, (URI[]) null).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), null, null, (URI[]) null).size());
        assertEquals(1, find(quadStore, null, stmt2.getPredicate(), null, (URI[]) null).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), stmt2.getPredicate(), null, (URI[]) null).size());
        assertEquals(1, find(quadStore, null, null, stmt2.getObject(), (URI[]) null).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), null, stmt2.getObject(), (URI[]) null).size());
        assertEquals(1, find(quadStore, null, stmt2.getPredicate(), stmt2.getObject(), (URI[]) null).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), stmt2.getPredicate(), stmt2.getObject(), (URI[]) null).size());
        assertEquals(1, find(quadStore, null, null, null, stmt2.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), null, null, stmt2.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, null, stmt2.getPredicate(), null, stmt2.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), stmt2.getPredicate(), null, stmt2.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, null, null, stmt2.getObject(), stmt2.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), null, stmt2.getObject(), stmt2.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, null, stmt2.getPredicate(), stmt2.getObject(), stmt2.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), stmt2.getPredicate(), stmt2.getObject(), stmt2.getNamedGraphUri()).size());
        assertEquals(2, find(quadStore, null, null, null, stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), null, null, stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, null, stmt2.getPredicate(), null, stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), stmt2.getPredicate(), null, stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, null, null, stmt2.getObject(), stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), null, stmt2.getObject(), stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, null, stmt2.getPredicate(), stmt2.getObject(), stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt2.getSubject(), stmt2.getPredicate(), stmt2.getObject(), stmt2.getNamedGraphUri(), stmt3.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, null, null, null, stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, stmt2.getSubject(), null, null, stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, null, stmt2.getPredicate(), null, stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, stmt2.getSubject(), stmt2.getPredicate(), null, stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, null, null, stmt2.getObject(), stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, stmt2.getSubject(), null, stmt2.getObject(), stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, null, stmt2.getPredicate(), stmt2.getObject(), stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, stmt2.getSubject(), stmt2.getPredicate(), stmt2.getObject(), stmt4.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt5.getSubject(), null, null, stmt5.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, null, stmt5.getPredicate(), null, stmt5.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt5.getSubject(), stmt5.getPredicate(), null, stmt5.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, null, null, stmt5.getObject(), stmt5.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt5.getSubject(), null, stmt5.getObject(), stmt5.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, null, stmt5.getPredicate(), stmt5.getObject(), stmt5.getNamedGraphUri()).size());
        assertEquals(1, find(quadStore, stmt5.getSubject(), stmt5.getPredicate(), stmt5.getObject(), stmt5.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, stmt4.getSubject(), null, null, (URI[]) null).size());
        assertEquals(0, find(quadStore, null, stmt4.getPredicate(), null, (URI[]) null).size());
        assertEquals(0, find(quadStore, stmt4.getSubject(), stmt4.getPredicate(), null, (URI[]) null).size());
        assertEquals(0, find(quadStore, stmt4.getSubject(), stmt3.getPredicate(), null, (URI[]) null).size());
        assertEquals(0, find(quadStore, null, null, stmt4.getObject(), (URI[]) null).size());
        assertEquals(0, find(quadStore, stmt4.getSubject(), null, stmt4.getObject(), (URI[]) null).size());
        assertEquals(0, find(quadStore, stmt3.getSubject(), null, stmt4.getObject(), (URI[]) null).size());
        assertEquals(0, find(quadStore, null, stmt4.getPredicate(), stmt4.getObject(), (URI[]) null).size());
        assertEquals(0, find(quadStore, null, stmt3.getPredicate(), stmt4.getObject(), (URI[]) null).size());
        assertEquals(0, find(quadStore, stmt4.getSubject(), stmt4.getPredicate(), stmt4.getObject(), (URI[]) null).size());
        assertEquals(0, find(quadStore, stmt2.getSubject(), stmt4.getPredicate(), stmt4.getObject(), (URI[]) null).size());
        assertEquals(0, find(quadStore, stmt2.getSubject(), stmt2.getPredicate(), stmt4.getObject(), (URI[]) null).size());
        assertEquals(0, find(quadStore, null, null, null, stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, stmt4.getSubject(), null, null, stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, null, stmt4.getPredicate(), null, stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, stmt4.getSubject(), stmt4.getPredicate(), null, stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, null, null, stmt4.getObject(), stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, stmt4.getSubject(), null, stmt4.getObject(), stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, null, stmt4.getPredicate(), stmt4.getObject(), stmt4.getNamedGraphUri()).size());
        assertEquals(0, find(quadStore, stmt4.getSubject(), stmt4.getPredicate(), stmt4.getObject(), stmt4.getNamedGraphUri()).size());
        quadStore.add(stmt7, stmt8, stmt9, stmt10, stmt11, stmt12, stmt13, stmt14, stmt15);
        assertEquals(1, find(quadStore, stmt7.getSubject(), stmt7.getPredicate(), stmt7.getObject()).size());
        assertEquals(1, find(quadStore, stmt10.getSubject(), stmt10.getPredicate(), stmt10.getObject()).size());
        assertEquals(1, find(quadStore, stmt13.getSubject(), stmt13.getPredicate(), stmt13.getObject()).size());
        assertEquals(1, find(quadStore, stmt10.getSubject(), null, stmt10.getObject()).size());//o
        assertEquals(1, find(quadStore, stmt10.getSubject(), null, stmt10.getObject(), stmt10.getNamedGraphUri()).size());//o
        assertEquals(1, find(quadStore, stmt10.getSubject(), null, stmt10.getObject(), stmt10.getNamedGraphUri(), stmt2.getNamedGraphUri()).size());//o
        assertEquals(1, find(quadStore, stmt13.getSubject(), null, stmt13.getObject(), stmt13.getNamedGraphUri()).size());//o
        assertEquals(1, find(quadStore, stmt13.getSubject(), null, stmt13.getObject(), stmt13.getNamedGraphUri(), stmt2.getNamedGraphUri()).size());//s
    }

    private Collection<Statement> find(MemQuadStore quadStore, Resource subj, URI prop, Value obj, URI... namedGraphUris) {
        Iterable<Statement> stmts = quadStore.find(subj, prop, obj, namedGraphUris);
        ArrayList<Statement> list = new ArrayList<Statement>();
        Iterators.addAll(stmts.iterator(), list);
        return list;
    }

    /**
     * Test remove with wildcards
     * 
     * @throws Exception
     */
    public void testWildCardRemove() throws Exception {
        Statement stmt4 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri4"), Constants.valueFactory.createURI("http://testPred4"), Constants.valueFactory.createURI("http://testObj4"), Constants.valueFactory.createURI("http://testNg4"));
        Statement stmt5 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri5"), Constants.valueFactory.createURI("http://testPred5"), Constants.valueFactory.createURI("http://testObj5"), Constants.valueFactory.createURI("http://testNg5"));
        Statement stmt6 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri5"), Constants.valueFactory.createURI("http://testPred5"), Constants.valueFactory.createURI("http://testObj5"), Constants.valueFactory.createURI("http://testNg6"));
        Statement stmt7 = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://testUri7"), Constants.valueFactory.createURI("http://testPred7"), Constants.valueFactory.createURI("http://testObj7"), Constants.valueFactory.createURI("http://testNg7"));
        MemQuadStore store = new MemQuadStore();
        store.add(stmt4);
        store.add(stmt5);
        store.add(stmt6);
        store.add(stmt7);

        assertEquals(4, store.size());
        store.remove(null, null, Constants.valueFactory.createURI("http://testObj5"), (URI[]) null);
        assertEquals(2, store.size());
    }
}
