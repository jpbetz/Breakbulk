/*******************************************************************************
 * Copyright (g) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.client/src/com/ibm/adtech/boca/client/Attic/TrackerManager.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Apr 16, 2007
 * Revision:	$Id: TrackerManager.java 179 2007-07-31 14:22:34Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.combus.realtime;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.CopyOnWriteMultiHashMap;
import org.openanzo.services.impl.SelectorTracker;

/**
 * The trackerManager keeps track of trackers, and provides indexer matching to find trackers that match statements.
 * 
 * @param <T>
 *            Type of tracker
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class TrackerManager<T extends SelectorTracker> {

    protected final List<T>               trackers;

    protected final MultiMap<URI, T>      namedGraphMap;

    protected final MultiMap<Resource, T> subjectMap;

    protected final MultiMap<URI, T>      propMap;

    protected final MultiMap<Value, T>    objMap;

    protected final List<T>               allWildTrackers;

    /**
     * Create a new TrackerManager
     */
    public TrackerManager() {
        trackers = new CopyOnWriteArrayList<T>();
        subjectMap = new CopyOnWriteMultiHashMap<Resource, T>();
        propMap = new CopyOnWriteMultiHashMap<URI, T>();
        objMap = new CopyOnWriteMultiHashMap<Value, T>();
        namedGraphMap = new CopyOnWriteMultiHashMap<URI, T>();
        allWildTrackers = new CopyOnWriteArrayList<T>();
    }

    /**
     * Clear the contents of trackers and all indexes.
     */
    public void clear() {
        trackers.clear();
        namedGraphMap.clear();
        subjectMap.clear();
        propMap.clear();
        objMap.clear();
        allWildTrackers.clear();
    }

    /**
     * Get the size of the trackers
     * 
     * @return the size of the trackers
     */
    public int size() {
        return trackers.size();
    }

    /**
     * @return true if empty
     */
    public boolean isEmpty() {
        return trackers.isEmpty();
    }

    /**
     * Add a new tracker and index it
     * 
     * @param tracker
     *            to add
     */
    public void addTracker(T tracker) {
        trackers.add(tracker);
        addMaps(tracker);
    }

    /**
     * Remove a tracker and remove it from the indexes
     * 
     * @param tracker
     *            tracker to remove
     */
    public void removeTracker(T tracker) {
        trackers.remove(tracker);
        removeMaps(tracker);
    }

    protected void addMaps(T tracker) {
        Set<URI> g = tracker.getNamedGraphUri();
        Set<Resource> s = tracker.getSubject();
        Set<URI> p = tracker.getPredicate();
        Set<Value> o = tracker.getObject();
        if (s != null && !s.isEmpty()) {
            for (Resource _s : s) {
                subjectMap.put(_s, tracker);
            }
        }
        if (p != null && !p.isEmpty()) {
            for (URI _p : p) {
                propMap.put(_p, tracker);
            }
        }
        if (o != null && !o.isEmpty()) {
            for (Value _o : o) {
                objMap.put(_o, tracker);
            }
        }
        if (g != null && !g.isEmpty()) {
            for (URI ng : g) {
                namedGraphMap.put(ng, tracker);
            }
        }

        if ((s == null || s.isEmpty()) && (p == null || p.isEmpty()) && (o == null || o.isEmpty()) && (g == null || g.isEmpty())) {
            allWildTrackers.add(tracker);
        }
    }

    protected void removeMaps(T tracker) {
        Set<URI> g = tracker.getNamedGraphUri();
        Set<Resource> s = tracker.getSubject();
        Set<URI> p = tracker.getPredicate();
        Set<Value> o = tracker.getObject();
        if (s != null && !s.isEmpty()) {
            for (Resource _s : s) {
                subjectMap.remove(_s, tracker);
            }
        }
        if (p != null && !p.isEmpty()) {
            for (URI _p : p) {
                propMap.remove(_p, tracker);
            }
        }
        if (o != null && !o.isEmpty()) {
            for (Value _o : o) {
                objMap.remove(_o, tracker);
            }
        }
        if (g != null && !g.isEmpty()) {
            for (URI ng : g) {
                namedGraphMap.remove(ng, tracker);
            }
        }
        if ((s == null || s.isEmpty()) && (p == null || p.isEmpty()) && (o == null || o.isEmpty()) && (g == null || g.isEmpty())) {
            allWildTrackers.remove(tracker);
        }
    }

    static class StmtSetComp implements Comparator<Collection<?>> {

        public int compare(Collection<?> o1, Collection<?> o2) {
            int result = 0;
            if (o1.size() == o2.size())
                return result;
            return (o1.size() < o2.size()) ? -1 : 1;
        }
    }
}
