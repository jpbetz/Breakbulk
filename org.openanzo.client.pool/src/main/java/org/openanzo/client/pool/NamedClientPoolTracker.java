/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 10, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client.pool;

import org.openanzo.datasource.DatasourceDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * OSGI service tracker for a specific client pool
 * 
 */
public class NamedClientPoolTracker extends ServiceTracker {
    private final INamedClientPoolRegistrationListener listener;

    AnzoClientPool                                     clientPool = null;

    /**
     * Create a new named client pool tracker for a specific client pool
     * 
     * @param context
     *            bundlecontext for tracker
     * @param datasourceURI
     *            URI of datasource track
     * @param listener
     *            listener notified when client pool is available
     * @throws InvalidSyntaxException
     */
    public NamedClientPoolTracker(BundleContext context, String datasourceURI, INamedClientPoolRegistrationListener listener) throws InvalidSyntaxException {
        super(context, context.createFilter(getFilterExpression(datasourceURI)), null);
        this.listener = listener;
    }

    private static String getFilterExpression(String datasourceURI) {
        if (datasourceURI != null) {
            return "(&(" + org.osgi.framework.Constants.OBJECTCLASS + "=" + AnzoClientPool.class.getName() + ")(" + DatasourceDictionary.KEY_DATASOURCE_URI + "=" + datasourceURI + "))";
        } else {
            return "(&(" + org.osgi.framework.Constants.OBJECTCLASS + "=" + AnzoClientPool.class.getName() + ")(!(" + DatasourceDictionary.KEY_DATASOURCE_URI + " =*)))";
        }
    }

    @Override
    public Object addingService(ServiceReference reference) {
        AnzoClientPool clientPool = (AnzoClientPool) context.getService(reference);
        if (this.clientPool == null || this.clientPool.equals(clientPool)) {
            listener.registerClientPool(clientPool);
            this.clientPool = clientPool;
        }
        return clientPool;
    }

    @Override
    public void removedService(ServiceReference reference, Object serviceObject) {
        AnzoClientPool clientPool = (AnzoClientPool) serviceObject;
        if (clientPool != null && this.clientPool.equals(clientPool)) {
            listener.unregisterClientPool(clientPool);
            context.ungetService(reference);
        }
    }
}
