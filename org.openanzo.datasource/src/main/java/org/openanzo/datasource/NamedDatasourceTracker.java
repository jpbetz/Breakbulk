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
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * OSGI service tracker for a specific datasource
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class NamedDatasourceTracker extends ServiceTracker {
    private final IDatasourceRegistrationListener listener;

    IDatasource                                   datasource = null;

    /**
     * Create a new datasource tracker for a specific datasource
     * 
     * @param context
     *            bundlecontext for tracker
     * @param datasourceURI
     *            URI of datasource track
     * @param listener
     *            listener notified when datasource is available
     * @throws InvalidSyntaxException
     */
    public NamedDatasourceTracker(BundleContext context, String datasourceURI, IDatasourceRegistrationListener listener) throws InvalidSyntaxException {
        super(context, context.createFilter("(&(" + org.osgi.framework.Constants.OBJECTCLASS + "=" + IDatasource.class.getName() + ")(" + DatasourceDictionary.KEY_DATASOURCE_URI + "=" + datasourceURI + "))"), null);
        this.listener = listener;
    }

    @Override
    public Object addingService(ServiceReference reference) {
        IDatasource datasource = (IDatasource) context.getService(reference);
        if (this.datasource == null || this.datasource.equals(datasource)) {
            listener.registerDatasource(datasource);
            this.datasource = datasource;
        }
        return datasource;
    }

    @Override
    public void removedService(ServiceReference reference, Object serviceObject) {
        IDatasource datasource = (IDatasource) serviceObject;
        if (datasource != null && this.datasource.equals(datasource)) {
            listener.unregisterDatasource(datasource);
            context.ungetService(reference);
        }
    }
}
