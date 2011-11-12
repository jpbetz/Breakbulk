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
package org.openanzo.combus.realtime;

import java.util.HashSet;
import java.util.Set;

import javax.jms.Destination;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.openanzo.rdf.URI;
import org.openanzo.services.impl.DatasetTracker;

/**
 * DestinationDatasetTracker is a dataset tracker for the server that contains the destination object for which this tracker is registered
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class DestinationDatasetTracker extends DatasetTracker {
    protected final Destination destination;

    protected final URI         userUri;

    protected Set<URI>          namedGraphsUris = new HashSet<URI>();

    public DestinationDatasetTracker(Destination destination, URI userUri, URI datasetURI, Set<URI> defaultGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets) {
        super(datasetURI, defaultGraphs, namedGraphs, namedDatasets);
        this.destination = destination;
        this.userUri = userUri;
    }

    public DestinationDatasetTracker(Destination destination, URI userUri, DatasetTracker tracker) {
        super(tracker.getTrackerURI(), tracker.getDefaultGraphs(), tracker.getNamedGraphs(), tracker.getNamedDatasets());
        this.destination = destination;
        this.userUri = userUri;
    }

    /**
     * @return the destination
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * @return the userUri
     */
    public URI getUserUri() {
        return userUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        boolean result = false;
        if (o instanceof DestinationDatasetTracker) {
            DestinationDatasetTracker tracker = (DestinationDatasetTracker) o;
            result = (tracker.getDestination() == null && getDestination() == null) || (tracker.getDestination() != null && tracker.getDestination().equals(getDestination())) || (getDestination() != null && getDestination().equals(tracker.getDestination()));
            result &= (tracker.getUserUri() == null && getUserUri() == null) || (tracker.getUserUri() != null && tracker.getUserUri().equals(getUserUri())) || (getUserUri() != null && getUserUri().equals(tracker.getUserUri()));
            result &= tracker.getDefaultGraphs().equals(this.getDefaultGraphs());
            result &= tracker.getNamedGraphs().equals(this.getNamedGraphs());
            result &= tracker.getNamedDatasets().equals(this.getNamedDatasets());
        }
        return result;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder(1035, 263167);
        builder.append(getDestination());
        builder.append(getUserUri());
        builder.append(getDefaultGraphs());
        builder.append(getNamedGraphs());
        builder.append(getNamedDatasets());
        return builder.toHashCode();
    }
}
