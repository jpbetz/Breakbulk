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

import javax.jms.Destination;

import org.openanzo.rdf.URI;

/**
 * DestinationDatasetTracker is a dataset tracker for the server that contains the destination object for which this tracker is registered
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class DestinationNamedgraphTracker {
    protected final Destination destination;

    protected final URI         userUri;

    protected URI               namedGraphUri;

    public DestinationNamedgraphTracker(Destination destination, URI userUri, URI namedGraphUri) {
        this.destination = destination;
        this.userUri = userUri;
        this.namedGraphUri = namedGraphUri;
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

    /**
     * @return the namedGraphUri
     */
    public URI getNamedGraphUri() {
        return namedGraphUri;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof DestinationNamedgraphTracker) {
            DestinationNamedgraphTracker tracker = (DestinationNamedgraphTracker) o;
            result = (tracker.getDestination() == null && getDestination() == null) || (tracker.getDestination() != null && tracker.getDestination().equals(getDestination())) || (getDestination() != null && getDestination().equals(tracker.getDestination()));
            result &= (tracker.getUserUri() == null && getUserUri() == null) || (tracker.getUserUri() != null && tracker.getUserUri().equals(getUserUri())) || (getUserUri() != null && getUserUri().equals(tracker.getUserUri()));
            result &= (tracker.getNamedGraphUri() == null && getNamedGraphUri() == null) || (tracker.getNamedGraphUri() != null && tracker.getNamedGraphUri() != null && getNamedGraphUri().equals(tracker.getNamedGraphUri()));
        }
        return result;
    }

}
