/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jan 22, 2010
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.glitter.dataset;

import java.util.Set;
import java.util.TreeSet;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultQueryDataset extends QueryDataset {
    private static final Logger log           = LoggerFactory.getLogger(DefaultQueryDataset.class);

    public Set<URI>             defaultGraphs = null;

    public Set<URI>             namedGraphs   = null;

    public Set<URI>             namedDatasets = null;

    /**
 * 
 */
    public DefaultQueryDataset() {
        this(new TreeSet<URI>(), new TreeSet<URI>(), new TreeSet<URI>());
    }

    public DefaultQueryDataset(Set<URI> dgs, Set<URI> ngs) {
        this(dgs, ngs, new TreeSet<URI>());
    }

    public DefaultQueryDataset(Set<URI> dgs, Set<URI> ngs, Set<URI> namedDatasets) {
        this.defaultGraphs = dgs;
        this.namedGraphs = ngs;
        this.namedDatasets = namedDatasets;
    }

    @Override
    public boolean isEmpty() {
        return (defaultGraphs == null || defaultGraphs.size() == 0) && (namedGraphs == null || namedGraphs.size() == 0) && super.isEmpty();
    }

    @Override
    public boolean isDefaultGraphsEmpty() {
        return (defaultGraphs == null || defaultGraphs.size() == 0) && super.isDefaultGraphsEmpty();
    }

    @Override
    public boolean isNamedGraphsEmpty() {
        return (namedGraphs == null || namedGraphs.size() == 0) && super.isNamedGraphsEmpty();
    }

    @Override
    public Set<URI> getDefaultGraphURIs() {
        return defaultGraphs;
    }

    @Override
    public Set<URI> getNamedGraphURIs() {
        return namedGraphs;
    }

    @Override
    public Set<URI> getNamedDatasetURIs() {
        return namedDatasets;
    }

    /**
     * @param defaultNamedGraphs
     *            the defaultNamedGraphs to set
     */
    public void setDefaultGraphs(Set<URI> defaultNamedGraphs) {
        this.defaultGraphs = defaultNamedGraphs;
    }

    /**
     * @param namedGraphs
     *            the namedGraphs to set
     */
    public void setNamedGraphs(Set<URI> namedGraphs) {
        this.namedGraphs = namedGraphs;
    }

    /**
     * @param namedDatasets
     *            the namedDatasets to set
     */
    public void setNamedDatasets(Set<URI> namedDatasets) {
        this.namedDatasets = namedDatasets;
    }

    @Override
    public String getCacheString() {
        long start = 0;
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        if (log.isDebugEnabled() || isEnabled) {
            start = System.currentTimeMillis();
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if (defaultGraphs != null) {
                for (URI g : defaultGraphs) {
                    sb.append(g.getNamespace());
                    sb.append(g.getLocalName());
                    sb.append(',');
                }
            }
            sb.append(']');
            sb.append(':');
            sb.append('[');
            if (namedGraphs != null) {
                for (URI g : namedGraphs) {
                    sb.append(g.getNamespace());
                    sb.append(g.getLocalName());
                    sb.append(',');
                }
            }
            sb.append(']');
            return sb.toString();
        } finally {
            if (log.isDebugEnabled() || isEnabled) {
                if (log.isDebugEnabled()) {
                    long end = System.currentTimeMillis();
                    log.debug(LogUtils.DATASOURCE_MARKER, "CreateQueryString time: " + (end - start));
                }
                if (isEnabled) {
                    RequestAnalysis.getAnalysisLogger().debug(LogUtils.TIMING_MARKER, "glitter_queryCacheCreateString,{}", Long.toString(System.currentTimeMillis() - start));
                }
                start = System.currentTimeMillis();
            }
        }
    }
}
