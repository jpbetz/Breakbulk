/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 2, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Tracker that keeps track of a service type being registered and unregistered
 * 
 * @param <S>
 *            type of service to track
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class OsgiServiceTracker<S> extends ServiceTracker {

    private final IServiceTrackerListener<S> listener;

    /**
     * Create a tracker with the given listener
     * 
     * @param listener
     *            listener for events
     * @param context
     *            context for the tracker
     */
    public OsgiServiceTracker(IServiceTrackerListener<S> listener, BundleContext context) {
        super(context, listener.getComponentType().getName(), null);
        this.listener = listener;
    }

    /**
     * Create a tracker for the given listener with a filter
     * 
     * @param listener
     *            listener for events
     * @param filter
     *            filter for tracker
     * @param context
     *            context for the tracker
     */
    public OsgiServiceTracker(IServiceTrackerListener<S> listener, Filter filter, BundleContext context) {
        super(context, filter, null);
        this.listener = listener;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object addingService(ServiceReference reference) {
        S service = (S) context.getService(reference);
        listener.registerService(service);
        return service;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void removedService(ServiceReference reference, Object serviceObject) {
        S service = (S) serviceObject;
        listener.unregisterService(service);
        context.ungetService(reference);
    }

}
