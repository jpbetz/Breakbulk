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
import java.util.HashSet;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.test.QueryTest;
import org.openanzo.test.ServerQueryTests;

/***
 * Test executing queries against the server.
 * 
 * @author Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * 
 */
public class TestAnzoClientServerQueries extends ServerQueryTests {

    // TODO - test both querying via anzoClient queryapi
    // and via a dataset
    @Override
    protected QueryResults executeQuery(Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI base) throws AnzoException {
        return this.anzoClient.serverQuery(defaultGraphs, namedGraphs, namedDatasets, query, base);
    }

    private AnzoClient            anzoClient = null;

    static private final URI      datasetUri = Constants.valueFactory.createURI("http://example.org/dataset");

    static private final Set<URI> noGraphs   = new HashSet<URI>();

    @Override
    protected void doTest(QueryTest test) throws Exception {
        this.anzoClient = new AnzoClient(getDefaultClientConfiguration());
        this.anzoClient.connect();
        try {
            anzoClient.reset(loadStatements("initialize.trig"), null);
            Collection<Statement> statements = parseAnyRdf(test.getData(), RDFFormat.TRIG, "");
            HashSet<URI> graphs = new HashSet<URI>();
            for (Statement s : statements)
                graphs.add(s.getNamedGraphUri());
            IDataset dataset = this.anzoClient.createServerDataset(false, datasetUri, noGraphs, graphs);
            dataset.add(statements);
            this.anzoClient.updateRepository();
            performQueryTest(test);
        } finally {
            if (this.anzoClient != null)
                this.anzoClient.close();
        }
    }
}
