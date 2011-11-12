/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 19, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.openanzo.rdf.IDatasetListener;
import org.openanzo.rdf.URI;
import org.openanzo.services.ITracker;

/**
 * Tracker that monitors the graphs that makeup a dataset, and notifies listeners when one of the graphs change
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DatasetTracker implements ITracker {
    private final URI                             trackerURI;

    private final Set<URI>                        namedGraphs;

    private final Set<URI>                        defaultGraphs;

    private final Set<URI>                        namedDatasets;

    private CopyOnWriteArraySet<IDatasetListener> listeners = new CopyOnWriteArraySet<IDatasetListener>();

    public TrackerType getType() {
        return TrackerType.DATASET;
    }

    /**
     * Create a tracker that monitors the graphs that make up a dataset
     * 
     * @param trackerURI
     *            URI for this tracker
     * @param defaultGraphs
     *            default graphs to monitor
     * @param namedGraphs
     *            namedgraphs to monitor
     * @param namedDatasets
     *            namedDatasets to monitor
     */
    public DatasetTracker(URI trackerURI, Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets) {
        super();
        this.trackerURI = trackerURI;
        this.defaultGraphs = defaultGraphs;
        this.namedGraphs = namedGraphs;
        this.namedDatasets = namedDatasets;
    }

    /**
     * Create empty datset tracker with given URI
     * 
     * @param trackerURI
     *            uri of tracker
     */
    public DatasetTracker(URI trackerURI) {
        this.trackerURI = trackerURI;
        this.defaultGraphs = new HashSet<URI>();
        this.namedGraphs = new HashSet<URI>();
        this.namedDatasets = new HashSet<URI>();
    }

    /**
     * @return the trackerURI
     */
    public URI getTrackerURI() {
        return trackerURI;
    }

    /**
     * Get the monitored namedgraphs
     * 
     * @return the monitored namedgraphs
     */
    public Set<URI> getNamedGraphs() {
        return namedGraphs;
    }

    /**
     * Get the monitored default graphs
     * 
     * @return the monitored default graphs
     */
    public Set<URI> getDefaultGraphs() {
        return defaultGraphs;
    }

    /**
     * Get the monitored named datasets
     * 
     * @return the monitored named datasets
     */
    public Set<URI> getNamedDatasets() {
        return namedDatasets;
    }

    /**
     * Add a dataset listener to the tracker
     * 
     * @param listener
     *            dataset listener to register
     */
    public void addListener(IDatasetListener listener) {
        listeners.add(listener);
    }

    /**
     * Remove a dataset listener from the tracker
     * 
     * @param listener
     *            dataset listener to unregister
     */
    public void removeListener(IDatasetListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notify listeners of a change in one of the monitored graphs
     * 
     * @param namedGraphUri
     *            graph that changed
     */
    public void notifyListeners(URI namedGraphUri) {
        for (IDatasetListener listener : listeners) {
            listener.datasetChanged();
        }
    }

    /**
     * Get the set of listeners
     * 
     * @return the set of listeners
     */
    public Set<IDatasetListener> getListeners() {
        return Collections.unmodifiableSet(listeners);
    }

}
