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

import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.test.ProtocolDatasetQueryTests;
import org.openanzo.test.QueryTest;

/***************************************************************************************************************************************************************
 * Test executing queries against the server.
 * 
 * @author Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * 
 */
public class TestDatasetBasicGraphQueries extends ProtocolDatasetQueryTests {

    // TODO - test both querying via anzoClient queryapi 
    // and via a dataset
    @Override
    protected QueryResults executeQuery(Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI base) throws AnzoException {
        return this.dataset.executeQuery(defaultGraphs, namedGraphs, namedDatasets, query, base);
    }

    private Dataset dataset = null;

    @Override
    protected void doTest(QueryTest test) throws Exception {
        Collection<Statement> statements = parseAnyRdf(test.getData(), RDFFormat.TRIG, "");
        HashMap<URI, INamedGraph> graphs = new HashMap<URI, INamedGraph>();
        this.dataset = new Dataset();

        for (Statement s : statements) {
            INamedGraph g = graphs.get(s.getNamedGraphUri());
            if (g == null) {
                if (test.getDefaultGraphs().contains(s.getNamedGraphUri())) {
                    g = this.dataset.addDefaultGraph(s.getNamedGraphUri());
                }
                // we don't really know where to put graphs ... so we guess that if the test wants a 
                // default graph that it should go there, and otherwise it goes as a named graph
                if (!test.getDefaultGraphs().contains(s.getNamedGraphUri()) || test.getNamedGraphs().contains(s.getNamedGraphUri()))
                    g = this.dataset.addNamedGraph(s.getNamedGraphUri());
                graphs.put(s.getNamedGraphUri(), g);
            }
            g.add(s);
        }

        HashSet<URI> processed = new HashSet<URI>();
        for (Statement s : statements) {
            URI u = s.getNamedGraphUri();
            if (!processed.contains(u)) {
                processed.add(u);
                INamedGraph g = graphs.get(s.getNamedGraphUri());

                if (test.getNamedDatasets().contains(u)) {
                    for (Statement t : g.find(u, org.openanzo.ontologies.openanzo.Dataset.defaultGraphProperty, null)) {
                        if (t.getObject() instanceof URI) {
                            this.dataset.addDefaultGraph((URI) t.getObject());
                        }

                    }
                    for (Statement t : g.find(u, org.openanzo.ontologies.openanzo.Dataset.defaultNamedGraphProperty, null)) {
                        if (t.getObject() instanceof URI) {
                            this.dataset.addDefaultGraph((URI) t.getObject());
                            this.dataset.addNamedGraph((URI) t.getObject());
                        }

                    }
                    for (Statement t : g.find(u, org.openanzo.ontologies.openanzo.Dataset.namedGraphProperty, null)) {
                        if (t.getObject() instanceof URI)
                            this.dataset.addNamedGraph((URI) t.getObject());
                    }
                }

            }
        }

        performQueryTest(test);
    }
}
