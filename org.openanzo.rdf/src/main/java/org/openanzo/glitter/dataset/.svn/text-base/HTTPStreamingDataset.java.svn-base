/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/dataset/HTTPStreamingDataset.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: HTTPStreamingDataset.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.dataset;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.UnknownGraphException;
import org.openanzo.rdf.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the default implementation of an RDF dataset in Glitter. It retrieves all of the graphs via HTTP GET and returns them as byte-oriented InputStreams.
 * It's up to the consumer to parse the graphs, and as such, this will only be useful in limited cases.
 * 
 * @author Lee
 * 
 */
public class HTTPStreamingDataset extends QueryDataset {
    private static final Logger log         = LoggerFactory.getLogger(HTTPStreamingDataset.class);

    static private final int    MAX_THREADS = 6;

    private Map<URI, Future<InputStream>> defaultGraphs, namedGraphs;

    private ExecutorService               threads;

    /**
     * Default constructor.
     */
    public HTTPStreamingDataset() {
        this.defaultGraphs = new Hashtable<URI, Future<InputStream>>();
        this.namedGraphs = new Hashtable<URI, Future<InputStream>>();
        this.threads = Executors.newFixedThreadPool(MAX_THREADS);
    }

    static private class GraphRetriever implements Callable<InputStream> {
        private URI graph;

        protected GraphRetriever(URI graph) {
            this.graph = graph;
        }

        public InputStream call() throws IOException {
            return java.net.URI.create(this.graph.toString()).toURL().openStream();
        }
    }

    private boolean retrieveGraph(URI name, Map<URI, Future<InputStream>> destination) {
        if (destination.containsKey(name))
            return false; // not actually retrieving anything
        destination.put(name, this.threads.submit(new GraphRetriever(name)));
        return true;
    }

    public void addDefaultGraph(URI name) {
        retrieveGraph(name, this.defaultGraphs);
    }

    public void addNamedGraph(URI name) {
        retrieveGraph(name, this.namedGraphs);
    }

    public void setDefaultGraphs(Set<URI> graphs) {
        this.defaultGraphs = new Hashtable<URI, Future<InputStream>>();
        for (URI u : graphs)
            addDefaultGraph(u);
    }

    public void setNamedGraphs(Set<URI> graphs) {
        this.namedGraphs = new Hashtable<URI, Future<InputStream>>();
        for (URI u : graphs)
            addNamedGraph(u);
    }

    protected InputStream getGraph(URI name, Map<URI, Future<InputStream>> map) throws UnknownGraphException {
        Future<InputStream> content = map.get(name);
        if (content == null)
            throw new UnknownGraphException(name);
        try {
            return content.get(); // if necessary, waits for the thread to return
        } catch (InterruptedException e) {
            // TODO log in case we start going loop-the-loop here
            return getGraph(name, map);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public InputStream getDefaultGraph(URI name) throws UnknownGraphException {
        return getGraph(name, this.defaultGraphs);
    }

    public InputStream getNamedGraph(URI name) throws UnknownGraphException {
        return getGraph(name, this.namedGraphs);
    }

    @Override
    public Set<URI> getDefaultGraphURIs() {
        return getNameIterator(this.defaultGraphs);
    }

    @Override
    public Set<URI> getNamedGraphURIs() {
        return getNameIterator(this.namedGraphs);
    }

    private Set<URI> getNameIterator(Map<URI, Future<InputStream>> graphs) {
        Set<URI> uris = new HashSet<URI>();
        for (Iterator<URI> iter = graphs.keySet().iterator(); iter.hasNext();) {
            uris.add(iter.next());
        }
        return uris;
    }

    @Override
    public Set<URI> getNamedDatasetURIs() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (defaultGraphs == null || defaultGraphs.size() == 0) && (namedGraphs == null || namedGraphs.size() == 0);
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
            for (URI g : getDefaultGraphURIs()) {
                sb.append(g.getNamespace());
                sb.append(g.getLocalName());
                sb.append(',');
            }
            sb.append(']');
            sb.append(':');
            sb.append('[');
            for (URI g : getNamedGraphURIs()) {
                sb.append(g.getNamespace());
                sb.append(g.getLocalName());
                sb.append(',');
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
