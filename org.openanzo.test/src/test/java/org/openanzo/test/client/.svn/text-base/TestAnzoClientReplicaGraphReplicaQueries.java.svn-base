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

import java.util.HashSet;

import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.URI;
import org.openanzo.test.QueryTest;

/***
 * Test executing queries locally against data in replica graphs.
 * 
 * @author Lee Feigenbaum (<a href="mailto:lee@cambridgesemantics.com">lee@cambridgesemantics.com</a>)
 * 
 */
public class TestAnzoClientReplicaGraphReplicaQueries extends TestAnzoClientReplicaQueries {
    @Override
    protected void doTest(QueryTest test) throws Exception {
        super.doTest(test);
    }

    @Override
    protected IDataset getDataset(HashSet<URI> graphs) {
        return this.anzoClient.createReplicaDataset(false, datasetUri, noGraphs, graphs);
    }
}
