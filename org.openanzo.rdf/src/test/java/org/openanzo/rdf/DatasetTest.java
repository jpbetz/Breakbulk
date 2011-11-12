/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 6, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.TestCase;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.vocabulary.Anzo;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class DatasetTest extends TestCase {

    static final URI ng1 = Constants.valueFactory.createURI("http://test/1");

    static final URI ng2 = Constants.valueFactory.createURI("http://test/2");

    static final URI ng3 = Constants.valueFactory.createURI("http://test/3");

    /**
     * Coverage test for Dataset
     * 
     * @throws Exception
     */
    public void testDataset() throws Exception {
        Dataset dataset = new Dataset();
        datasetTest(dataset);
        dataset.addNamedGraph(ng1);
        assertEquals(0, dataset.size());
        dataset.addNamedGraph(ng2);
        dataset.addDefaultGraph(ng2);
        assertEquals(1, dataset.getDefaultGraphUris().size());
        assertNotNull(dataset.getNamedGraph(ng1));
        assertNotNull(dataset.getNamedGraph(ng2));
        assertTrue(!dataset.getDefaultGraphUris().isEmpty());
        assertTrue(!dataset.getNamedGraphUris().isEmpty());
        assertTrue(dataset.containsNamedGraph(ng1));
        assertTrue(dataset.containsDefaultGraph(ng2));
        assertTrue(dataset.containsNamedGraph(ng2));
        assertFalse(dataset.containsDefaultGraph(ng1));
        dataset.addDefaultGraph(ng1);
        INamedGraph graph = dataset.getDefaultGraph(ng1);
        graph.add(Constants.valueFactory.createStatement(ng1, ng2, ng3));
        assertTrue(graph.contains(Constants.valueFactory.createStatement(ng1, ng2, ng3)));
        graph.remove(Constants.valueFactory.createStatement(ng1, ng2, ng3));
        dataset.removeNamedGraph(ng1);
        dataset.removeNamedGraph(ng2);
        assertEquals(0, dataset.size());
        assertEquals(2, dataset.getDefaultGraphUris().size());
        dataset.clear();
        Set<URI> dg = Collections.singleton(ng3);
        dataset.addNamedGraph(ng1);
        dataset.addNamedGraph(ng3);
        dataset.setDefaultGraphs(dg);

        assertEquals(0, dataset.size());
        dataset.addDefaultGraph(ng1);
        graph = dataset.getDefaultGraph(ng1);
        graph.add(Constants.valueFactory.createStatement(ng1, ng2, ng3));
        assertEquals(2, dataset.getDefaultGraphUris().size());
        QueryResults qr = dataset.executeQuery("SELECT ?s ?p ?o WHERE {?s ?p ?o.}");
        Iterator<PatternSolution> result = qr.getSelectResults().iterator();
        while (result.hasNext()) {
            PatternSolution ps = result.next();
            assertEquals(ng1.toString(), ps.getBinding("s").toString());
            assertEquals(ng2.toString(), ps.getBinding("p").toString());
            assertEquals(ng3.toString(), ps.getBinding("o").toString());
        }

        final int[] counts = new int[2];

        dataset.registerListener(new IStatementListener<IDataset>() {

            public void statementsAdded(IDataset source, Statement... statements) {
                counts[0]++;

            }

            public void statementsRemoved(IDataset source, Statement... statements) {
                counts[1]++;
            }

        });

        graph.remove(Constants.valueFactory.createStatement(ng1, ng2, ng3));
        graph.add(Constants.valueFactory.createStatement(ng1, ng2, ng3));

        assertEquals(1, counts[0]);
        assertEquals(1, counts[1]);

        dataset.close();
    }

    void datasetTest(IDataset dataset) throws Exception {
        assertEquals(0, dataset.size());
        assertEquals(0, dataset.size());
        assertEquals(0, dataset.getDefaultGraphUris().size());
    }

    /**
     * Test null params to dataset
     * 
     * @throws Exception
     */
    public void testNullParamsToDataset() throws Exception {
        IDataset dataset = new Dataset();
        boolean exp = false;
        try {
            dataset.addNamedGraph(null);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

        exp = false;
        try {
            dataset.addNamedGraph((URI) null);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

        exp = false;
        try {
            dataset.removeNamedGraph((URI) null);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

        exp = false;
        try {
            dataset.addDefaultGraph((URI) null);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

    }

    /**
     * Test dataset graph methods
     * 
     * @throws Exception
     */
    public void testDatasetGraphMethods() throws Exception {
        Dataset dataset = new Dataset(null);
        assertNull(dataset.getURI());
        dataset = new Dataset(ng1);

        dataset.addNamedGraph(ng1);

        Set<URI> ngs = dataset.getNamedGraphUris();
        assertTrue(ngs.contains(ng1));

        INamedGraph graph = dataset.getNamedGraph(ng1);
        assertNotNull(graph);

        dataset.removeNamedGraph(ng1);

        Set<URI> graphsSet = new HashSet<URI>();
        graphsSet.add(ng1);
        dataset = new Dataset();
        dataset.setNamedGraphs(graphsSet);
        boolean exp = false;

        try {
            dataset.add(null, null, null, null);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);
        exp = false;
        try {
            dataset.add(null, null, null, ng1);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);
        exp = false;
        try {
            dataset.add(ng1, null, null, ng1);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);
        exp = false;
        try {
            dataset.add(ng1, ng1, null, ng1);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

        dataset.add(ng1, ng1, ng1, ng1);
        exp = false;
        try {
            dataset.add(ng1, ng1, ng1, ng2);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

        exp = false;

        try {
            dataset.add(Constants.valueFactory.createStatement(null, null, null, null));
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);
        exp = false;
        try {
            dataset.add(Constants.valueFactory.createStatement(null, null, null, ng1));
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);
        exp = false;
        try {
            dataset.add(Constants.valueFactory.createStatement(ng1, null, null, ng1));
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);
        exp = false;
        try {
            dataset.add(Constants.valueFactory.createStatement(ng1, ng1, null, ng1));
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

        dataset.add(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1));
        dataset.add(Collections.<Statement> singleton(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1)));
        dataset.remove(Collections.<Statement> singleton(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1)));
        exp = false;
        try {
            dataset.add(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng2));
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

        dataset.add(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1));
        dataset.remove(null, null, null, (URI[]) null);
        dataset.add(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1));
        dataset.remove(null, null, null, ng1);
        dataset.add(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1));
        dataset.remove(ng1, null, null, ng1);
        dataset.add(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1));
        dataset.remove(ng1, ng1, null, ng1);
        dataset.add(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1));
        dataset.remove(ng1, ng1, ng1, ng1);

        exp = false;
        try {
            dataset.remove(ng1, ng1, ng1, ng2);
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

        exp = false;
        try {
            dataset.remove(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng2));
        } catch (AnzoRuntimeException are) {
            exp = true;
        }
        assertEquals(true, exp);

        dataset.clear();
        assertTrue(dataset.isEmpty());
        assertEquals(0, dataset.size());
        Collection<Statement> statements = dataset.find(null, null, null);
        assertTrue(statements.size() == 0);

        dataset.addNamedGraph(ng1);
        assertFalse(dataset.contains(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1)));
        dataset.add(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1));
        assertFalse(dataset.isEmpty());
        assertEquals(1, dataset.size(ng1));
        assertTrue(dataset.contains(Constants.valueFactory.createStatement(ng1, ng1, ng1, ng1)));
        statements = dataset.find(false, null, null, null);
        assertTrue(statements.size() > 0);
        statements = dataset.find(false, null, null, null, ng1);
        assertTrue(statements.size() > 0);
        statements = dataset.find(false, null, null, null, ng2);
        assertFalse(statements.size() > 0);
        statements = dataset.find(false, null, null, null, ng1, ng2);
        assertTrue(statements.size() > 0);
        statements = dataset.find(false, null, null, null, ng2, ng3);
        assertFalse(statements.size() > 0);
        statements = dataset.find(true, null, null, null, ng2, ng3);
        assertTrue(statements.size() > 0);
        statements = dataset.find(true, null, null, null, ng1);
        assertTrue(statements.size() > 0);
        statements = dataset.find(true, null, null, null);
        assertTrue(statements.size() > 0);

        Collection<Statement> stmts = dataset.getStatements();
        assertTrue(stmts.size() > 0);

        assertFalse(dataset.isClosed());
        dataset.close();
        assertTrue(dataset.isClosed());

        assertNull(dataset.getURI());
    }

    /**
     * Test dataset graph
     */
    public void testDatasetGraph() {
        URI datasetURI = Constants.valueFactory.createURI("http://testDataset");
        IDataset dataset = new Dataset(datasetURI);
        dataset.addNamedGraph(ng1);
        dataset.addNamedGraph(ng2);
        dataset.addNamedGraph(ng3);
        dataset.addDefaultGraph(ng1);
        dataset.addDefaultGraph(ng2);
        INamedGraph datasetGraph = dataset.getDatasetGraph();
        assertEquals(6, datasetGraph.size());
        assertEquals(3, datasetGraph.find(datasetURI, Anzo.NAMEDGRAPH, null).size());
        assertEquals(2, datasetGraph.find(datasetURI, Anzo.DEFAULTGRAPH, null).size());

        assertFalse(dataset.containsDefaultGraph(ng3));
        datasetGraph.add(datasetURI, Anzo.DEFAULTGRAPH, ng3);
        // the add will fire an event that
        assertTrue(dataset.containsDefaultGraph(ng3));
    }

}
