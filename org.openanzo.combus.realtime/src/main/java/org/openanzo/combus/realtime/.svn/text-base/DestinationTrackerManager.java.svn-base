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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jms.Destination;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Manager that keeps track of the registered trackers
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class DestinationTrackerManager extends TrackerManager<DestinationSelectorTracker> {

    /**
     * Create a new Tracker Manager for DestinationSelectorTrackers
     */
    public DestinationTrackerManager() {
        super();
    }

    /**
     * Remove all trackers for a destination
     * 
     * @param destination
     *            destination to remove
     */
    public void removeDestinationsTrackers(Destination destination) {
        for (DestinationSelectorTracker tracker : trackers) {
            if (tracker.getDestination().equals(destination)) {
                super.removeTracker(tracker);
            }
        }
    }

    /**
     * Find the set of trackers that match the statement
     * 
     * @param subj
     *            subject of statement
     * @param pred
     *            predicate of statement
     * @param obj
     *            object of statement
     * @param ngUri
     *            ngURI of statement
     * @return set of trackers that match statement
     */
    private <T extends Value> boolean matchingValues(T value, Set<T> set) {
        if (value != null) {
            if (set == null || set.size() == 0) {
                return true;
            } else {
                return set.contains(Constants.ANY_URI) || set.contains(value);
            }
        }
        return false;
    }

    public Map<Destination, URI> matchingDestinations(Resource subj, URI pred, Value obj, URI ngUri) {
        if (subj == null && pred == null && obj == null && ngUri == null) {
            return Collections.<Destination, URI> emptyMap();
        }
        Collection<DestinationSelectorTracker> nSet = (ngUri == null) ? null : namedGraphMap.get(ngUri);
        Collection<DestinationSelectorTracker> sSet = (subj == null) ? null : subjectMap.get(subj);
        Collection<DestinationSelectorTracker> pSet = (pred == null) ? null : propMap.get(pred);
        Collection<DestinationSelectorTracker> oSet = (obj == null) ? null : objMap.get(obj);

        if (sSet != null || pSet != null || oSet != null || nSet != null || allWildTrackers.size() > 0) {
            HashMap<Destination, URI> results = new HashMap<Destination, URI>();
            if (nSet != null) {
                for (DestinationSelectorTracker tracker : nSet) {
                    if (matchingValues(subj, tracker.getSubject()) && matchingValues(pred, tracker.getPredicate()) && matchingValues(obj, tracker.getObject())) {
                        results.put(tracker.getDestination(), tracker.getUserUri());
                    }
                }
            }
            if (sSet != null) {
                for (DestinationSelectorTracker tracker : sSet) {
                    if (matchingValues(ngUri, tracker.getNamedGraphUri()) && matchingValues(pred, tracker.getPredicate()) && matchingValues(obj, tracker.getObject())) {
                        results.put(tracker.getDestination(), tracker.getUserUri());
                    }
                }
            }
            if (pSet != null) {
                for (DestinationSelectorTracker tracker : pSet) {
                    if (matchingValues(ngUri, tracker.getNamedGraphUri()) && matchingValues(subj, tracker.getSubject()) && matchingValues(obj, tracker.getObject())) {
                        results.put(tracker.getDestination(), tracker.getUserUri());
                    }
                }
            }
            if (oSet != null) {
                for (DestinationSelectorTracker tracker : oSet) {
                    if (matchingValues(ngUri, tracker.getNamedGraphUri()) && matchingValues(pred, tracker.getPredicate()) && matchingValues(subj, tracker.getSubject())) {
                        results.put(tracker.getDestination(), tracker.getUserUri());
                    }
                }
            }
            if (allWildTrackers.size() > 0) {
                for (DestinationSelectorTracker tracker : allWildTrackers) {
                    results.put(tracker.getDestination(), tracker.getUserUri());
                }
            }
            return results;
        }
        return Collections.<Destination, URI> emptyMap();
    }
}
