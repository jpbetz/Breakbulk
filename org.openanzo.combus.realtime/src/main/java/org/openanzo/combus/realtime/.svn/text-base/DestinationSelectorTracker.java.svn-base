/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 18, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus.realtime;

import java.util.Set;

import javax.jms.Destination;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.services.impl.SelectorTracker;

/**
 * Tracker that is linked to a destination
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DestinationSelectorTracker extends SelectorTracker {
    protected final Destination destination;

    protected final URI         userUri;

    /**
     * @param destination
     * @param userUri
     * @param subject
     * @param predicate
     * @param object
     * @param namedGraphUri
     */
    public DestinationSelectorTracker(Destination destination, URI userUri, Set<Resource> subject, Set<URI> predicate, Set<Value> object, Set<URI> namedGraphUri) {
        super(subject, predicate, object, namedGraphUri);
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
        if (o instanceof DestinationSelectorTracker) {
            DestinationSelectorTracker tracker = (DestinationSelectorTracker) o;
            return (tracker.getDestination() == null && getDestination() == null) || (tracker.getDestination() != null && tracker.getDestination().equals(getDestination())) || (getDestination() != null && getDestination().equals(tracker.getDestination())) && (tracker.getUserUri() == null && getUserUri() == null) || (tracker.getUserUri() != null && tracker.getUserUri().equals(getUserUri())) || (getUserUri() != null && getUserUri().equals(tracker.getUserUri())) && super.equals(o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        // hard-coded, randomly chosen, non-zero, odd numbers to seed the hash (ideally prime numbers)
        int code = new HashCodeBuilder(23, 59).append(destination).append(userUri).append(namedGraphUri).append(subject).append(predicate).append(object).toHashCode();
        return code;
    }
}
