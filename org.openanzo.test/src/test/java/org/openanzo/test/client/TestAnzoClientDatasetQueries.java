/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/client/TestQueries.java,v $
 * Created by:  Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * Created on:  9/25/2006
 * Revision:	$Id: TestQueries.java 229 2007-08-07 15:22:00Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test.client;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.DatasetBase;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.test.ProtocolDatasetQueryTests;
import org.openanzo.test.QueryTest;

/***
 * Test executing queries against the server.
 * 
 * @author Lee Feigenbaum (<a href="mailto:lee@cambridgesemantics.com">lee@cambridgesemantics.com</a>)
 * 
 */
public abstract class TestAnzoClientDatasetQueries extends ProtocolDatasetQueryTests {

    @Override
    protected QueryResults executeQuery(Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI base) throws AnzoException {
        return this.dataset.executeQuery(query /*, base */);
        //return anzoClient.getAllGraphsDataset().executeQuery(dataset.getDefaultGraphUris(), dataset.getNamedGraphUris(), query);
    }

    protected AnzoClient            anzoClient = null;

    protected TestDataset           dataset    = null;

    static protected final Set<URI> noGraphs   = new HashSet<URI>();

    @Override
    protected void doTest(QueryTest test) throws Exception {
        this.anzoClient = new AnzoClient(getDefaultClientConfiguration());
        this.anzoClient.connect();
        this.anzoClient.reset(loadStatements("initialize.trig"), null);
        this.dataset = new TestDataset();
        try {
            Collection<Statement> statements = parseAnyRdf(test.getData(), RDFFormat.TRIG, "");
            HashMap<URI, INamedGraph> graphs = new HashMap<URI, INamedGraph>();
            for (Statement s : statements) {
                URI u = s.getNamedGraphUri();
                INamedGraph g = graphs.get(u);
                if (g == null) {
                    g = getGraph(u);
                    graphs.put(u, g);
                }
                g.add(s);
            }
            HashSet<URI> processed = new HashSet<URI>();
            for (Statement s : statements) {
                URI u = s.getNamedGraphUri();
                if (!processed.contains(u)) {
                    processed.add(u);
                    INamedGraph g = graphs.get(s.getNamedGraphUri());
                    if (test.getDefaultGraphs().contains(u)) {
                        this.dataset.addGraph(g);
                        this.dataset.addDefaultGraph(u);
                    }
                    if (test.getNamedDatasets().contains(u)) {
                        for (Statement t : g.find(u, org.openanzo.ontologies.openanzo.Dataset.defaultGraphProperty, null)) {
                            if (t.getObject() instanceof URI) {
                                this.dataset.addDefaultGraph((URI) t.getObject());
                            }

                        }
                        for (Statement t : g.find(u, org.openanzo.ontologies.openanzo.Dataset.defaultNamedGraphProperty, null)) {
                            if (t.getObject() instanceof URI) {
                                this.dataset.addGraph(getGraph((URI) t.getObject()));
                                this.dataset.addNamedGraph((URI) t.getObject());
                                this.dataset.addDefaultGraph((URI) t.getObject());
                            }

                        }
                        for (Statement t : g.find(u, org.openanzo.ontologies.openanzo.Dataset.namedGraphProperty, null)) {
                            if (t.getObject() instanceof URI) {
                                this.dataset.addGraph(getGraph((URI) t.getObject()));
                                this.dataset.addNamedGraph((URI) t.getObject());
                            }
                        }
                    }
                    if ((!test.getDefaultGraphs().contains(u) && !test.getNamedDatasets().contains(u)) || test.getNamedGraphs().contains(u)) {
                        this.dataset.addGraph(getGraph(u));
                        this.dataset.addNamedGraph(u);
                    }

                }
            }
            performQueryTest(test);
            anzoClient.updateRepository();
            performQueryTest(test);
        } finally {
            if (this.anzoClient != null)
                this.anzoClient.close();
        }
    }

    /*
     * 
     */
    abstract protected INamedGraph getGraph(URI u) throws Exception;

    class TestDataset extends DatasetBase {
        void addGraph(INamedGraph graph) {
            graphs.put(graph.getNamedGraphUri(), graph);
        }

        @Override
        protected INamedGraph createDatasetGraph() {
            return null;
        }

        @Override
        protected INamedGraph createNamedGraph(URI namedGraphUri) {
            return null;
        }

        @Override
        protected ReentrantLock getLock() {
            return null;
        }

    }
}
