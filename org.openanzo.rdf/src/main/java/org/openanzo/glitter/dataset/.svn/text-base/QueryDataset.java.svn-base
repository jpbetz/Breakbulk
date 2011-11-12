/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 17, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.glitter.dataset;

import java.util.Set;

import org.openanzo.rdf.URI;

abstract public class QueryDataset {
    public boolean datasetFullyResolved     = false;

    public boolean defaultAllGraphs         = false;

    public boolean defaultAllMetadataGraphs = false;

    public boolean defaultAllNamedGraphs    = false;

    public boolean allGraphs                = false;

    public boolean allMetadataGraphs        = false;

    public boolean allNamedGraphs           = false;

    public boolean allNamedGraphs() {
        return allGraphs || (allNamedGraphs && allMetadataGraphs);
    }

    public boolean allDefaultGraphs() {
        return defaultAllGraphs || (defaultAllNamedGraphs && defaultAllMetadataGraphs);
    }

    public boolean fullyExpandedDatasets = false;

    public boolean isEmpty() {
        return !(defaultAllGraphs || defaultAllMetadataGraphs || defaultAllNamedGraphs || allGraphs || allMetadataGraphs || allNamedGraphs);
    }

    public boolean isNamedGraphsEmpty() {
        return !(allGraphs || allMetadataGraphs || allNamedGraphs);
    }

    public boolean isDefaultGraphsEmpty() {
        return !(defaultAllGraphs || defaultAllMetadataGraphs || defaultAllNamedGraphs);
    }

    public abstract String getCacheString();

    public abstract Set<URI> getDefaultGraphURIs();

    public abstract Set<URI> getNamedGraphURIs();

    public abstract Set<URI> getNamedDatasetURIs();
}
