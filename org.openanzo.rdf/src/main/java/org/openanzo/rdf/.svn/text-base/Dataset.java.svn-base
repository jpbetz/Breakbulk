/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/Dataset.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 20, 2006
 * Revision:	$Id: Dataset.java 168 2007-07-31 14:11:14Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Basic Dataset implementation that stores INamedGraphs.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Dataset extends DatasetBase {

    //private final static Logger     log        = LoggerFactory.getLogger(Dataset.class);

    private IQuadStore    quadStore;

    private ReentrantLock lock = new ReentrantLock();

    /**
     * Create a new empty dataset
     */
    public Dataset() {
        super();
    }

    @Override
    protected ReentrantLock getLock() {
        return lock;
    }

    /**
     * Setup an empty Dataset
     * 
     * @param datasetUri
     *            URI of dataset
     */
    public Dataset(URI datasetUri) {
        super(datasetUri);
    }

    @Override
    protected INamedGraph createNamedGraph(URI namedGraphUri) {
        if (quadStore == null) {
            quadStore = new MemQuadStore();
        }
        return new NamedGraph(namedGraphUri, quadStore);
    }

    @Override
    protected INamedGraph createDatasetGraph() {
        return createNamedGraph(this.datasetUri);
    }

    @Override
    public Collection<Statement> getStatements() {
        return quadStore != null ? ((MemQuadStore) quadStore).getStatements() : Collections.<Statement> emptySet();
    }

    public int statementsSize() {
        return quadStore != null ? ((MemQuadStore) quadStore).size() : 0;
    }
}
