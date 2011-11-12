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
package org.openanzo.client;

import java.util.Collection;
import java.util.Iterator;

import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;

/**
 * Unit tests the transaction proxy class.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TestTransactionProxy extends TestConfiguration {

    /**
     * verifies that the contains methods are correct.
     */
    public void testContains() {
        TransactionProxy proxy = createProxy();
        assertFalse(proxy.contains(TestData.stmt1));
        assertFalse(proxy.contains(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1));
        assertFalse(proxy.contains(TestData.subj1, null, null, (URI[]) null));
        assertFalse(proxy.contains(null, TestData.pred1, null, (URI[]) null));
        assertFalse(proxy.contains(null, null, TestData.obj1, (URI[]) null));
        assertFalse(proxy.contains(null, null, null, TestData.graph1));
        proxy.add(TestData.stmt1);

        assertTrue(proxy.contains(TestData.stmt1));
        assertTrue(proxy.contains(TestData.stmt1));
        assertTrue(proxy.contains(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1));
        assertTrue(proxy.contains(TestData.subj1, null, null, (URI[]) null));
        assertTrue(proxy.contains(null, TestData.pred1, null, (URI[]) null));
        assertTrue(proxy.contains(null, null, TestData.obj1, (URI[]) null));
        assertTrue(proxy.contains(null, null, null, TestData.graph1));

        proxy.remove(TestData.stmt1);
        assertFalse(proxy.contains(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1));

        assertFalse(proxy.contains(TestData.stmt1));
    }

    /**
     * verifies that the find method finds a statement when it is added and does not find it after it has been removed.
     */
    public void testFind() {
        TransactionProxy proxy = createProxy();

        proxy.add(TestData.stmt1);

        Iterator<Statement> find = proxy.find(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1).iterator();
        assertTrue(find.hasNext());
        Statement stmt = find.next();
        assertEquals(TestData.stmt1, stmt);
        assertFalse(find.hasNext());

        proxy.remove(TestData.stmt1);

        Iterator<Statement> find2 = proxy.find(TestData.subj1, TestData.pred1, TestData.obj1, TestData.graph1).iterator();
        assertFalse(find2.hasNext());
    }

    /**
     * Verifies that a sparql query find a statement that has been added and does not find it after it is removed.
     * 
     * @throws Exception
     */
    public void testQuery() throws Exception {
        TransactionProxy proxy = createProxy();
        proxy.add(TestData.stmt1);

        QueryResults result = proxy.executeQuery(null, null, null, "SELECT ?s ?p ?o WHERE { ?s ?p ?o . }", null);
        Iterator<PatternSolution> selectResult = result.getSelectResults().iterator();

        assertTrue(selectResult.hasNext());
        PatternSolution bindingSet = selectResult.next();
        assertEquals(TestData.subj1.toString(), bindingSet.getBinding("s").toString());
        assertEquals(TestData.pred1.toString(), bindingSet.getBinding("p").toString());
        assertEquals(TestData.obj1.toString(), bindingSet.getBinding("o").toString());
        assertFalse(selectResult.hasNext());

        proxy.remove(TestData.stmt1);

        QueryResults result2 = proxy.executeQuery(null, null, null, "SELECT ?s ?p ?o WHERE { ?s ?p ?o . }", null);
        Iterator<PatternSolution> selectResult2 = result2.getSelectResults().iterator();
        assertFalse(selectResult2.hasNext());
    }

    /**
     * verifies that the getStatements method returns all the statements in the proxy.
     * 
     * @throws Exception
     */
    public void testGetStatements() throws Exception {
        TransactionProxy proxy = createProxy();

        Iterator<Statement> iter = proxy.getStatements().iterator();
        assertFalse(iter.hasNext());

        proxy.add(TestData.stmt1);

        iter = proxy.getStatements().iterator();
        assertTrue(iter.hasNext());
        Statement stmt = iter.next();
        assertEquals(TestData.stmt1, stmt);
        assertFalse(iter.hasNext());

        proxy.remove(TestData.stmt1);

        iter = proxy.getStatements().iterator();
        assertFalse(iter.hasNext());
    }

    /**
     * verifies that the getNamedGraphUris methods returns a graph when it exists and does not after it is removed.
     * 
     * @throws Exception
     */
    public void testGetNamedGraphUris() throws Exception {
        TransactionProxy proxy = createProxy();
        Collection<URI> namedGraphUris = proxy.getNamedGraphUris();
        assertFalse(namedGraphUris.contains(TestData.graph1));

        proxy.add(TestData.stmt1);

        namedGraphUris = proxy.getNamedGraphUris();
        assertTrue(namedGraphUris.contains(TestData.graph1));

        proxy.remove(TestData.stmt1);

        namedGraphUris = proxy.getNamedGraphUris();
        assertFalse(namedGraphUris.contains(TestData.graph1));
    }

    /**
     * verifies that the size, clear and isEmpty methods return the correct results.
     * 
     * @throws Exception
     */
    public void testClearAndSizeAndIsEmpty() throws Exception {
        TransactionProxy proxy = createProxy();

        proxy.add(TestData.stmt1);

        assertEquals(1, proxy.size());
        assertEquals(1, proxy.size(TestData.graph1));
        assertEquals(0, proxy.size(TestData.graph2));
        assertFalse(proxy.isEmpty());
        assertFalse(proxy.isEmpty(TestData.graph1));
        assertTrue(proxy.isEmpty(TestData.graph2));

        proxy.add(TestData.stmt2);

        assertEquals(2, proxy.size());
        assertEquals(1, proxy.size(TestData.graph1));
        assertEquals(1, proxy.size(TestData.graph2));
        assertFalse(proxy.isEmpty());
        assertFalse(proxy.isEmpty(TestData.graph1));
        assertFalse(proxy.isEmpty(TestData.graph2));

        proxy.clear();

        assertEquals(0, proxy.size());
        assertEquals(0, proxy.size(TestData.graph1));
        assertEquals(0, proxy.size(TestData.graph2));
        assertTrue(proxy.isEmpty());
        assertTrue(proxy.isEmpty(TestData.graph1));
        assertTrue(proxy.isEmpty(TestData.graph2));
    }

    /**
     * verifies that add and remove behave correctly when in a transaction.
     * 
     * @throws Exception
     */
    public void testInTransaction() throws Exception {
        TransactionProxy proxy = createProxy();
        proxy.transactionQueue.begin();
        assertFalse(proxy.contains(TestData.stmt1));
        proxy.add(TestData.stmt1);

        assertTrue(proxy.contains(TestData.stmt1));

        proxy.remove(TestData.stmt1);

        assertFalse(proxy.contains(TestData.stmt1));
        proxy.transactionQueue.commit();
    }

    private TransactionProxy createProxy() {
        IQuadStore quadStore = new MemQuadStore();
        IQuadStore transactionStore = new MemQuadStore();
        TransactionPersistence transactionStorage = new TransactionPersistence(transactionStore);
        return new TransactionProxy(quadStore, new TransactionQueue(transactionStorage), null);
    }
}
