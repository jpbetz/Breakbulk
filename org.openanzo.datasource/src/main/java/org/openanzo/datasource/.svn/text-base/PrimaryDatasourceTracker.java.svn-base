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
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class PrimaryDatasourceTracker extends ServiceTracker {
    private final IDatasourceRegistrationListener listener;

    IDatasource                                   primaryDatasource = null;

    /**
     * 
     * @param context
     * @param listener
     * @throws InvalidSyntaxException
     */
    public PrimaryDatasourceTracker(BundleContext context, IDatasourceRegistrationListener listener) throws InvalidSyntaxException {
        super(context, context.createFilter("(&(objectClass=" + IDatasource.class.getName() + ")(isPrimary=true))"), null);
        this.listener = listener;
    }

    @Override
    public Object addingService(ServiceReference reference) {
        IDatasource datasource = (IDatasource) context.getService(reference);
        if (primaryDatasource == null || !primaryDatasource.equals(datasource)) {
            listener.registerDatasource(datasource);
            this.primaryDatasource = datasource;
        }
        return datasource;
    }

    @Override
    public void removedService(ServiceReference reference, Object serviceObject) {
        IDatasource datasource = (IDatasource) serviceObject;
        if (primaryDatasource != null && primaryDatasource.equals(datasource)) {
            listener.unregisterDatasource(datasource);
            context.ungetService(reference);
        }
    }
}
