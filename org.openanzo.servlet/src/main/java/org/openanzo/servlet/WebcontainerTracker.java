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
package org.openanzo.servlet;

import java.util.HashMap;
import java.util.StringTokenizer;

import org.openanzo.services.ServicesDictionary;
import org.ops4j.pax.web.service.WebContainer;
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
public class WebcontainerTracker extends ServiceTracker {

    HashMap<String, WebContainer> webContainers = new HashMap<String, WebContainer>();

    WebcontainerTrackerListener   listener;

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
    public WebcontainerTracker(BundleContext context, String instanceIds, WebcontainerTrackerListener listener) throws InvalidSyntaxException {
        super(context, context.createFilter(convertToFilter(instanceIds)), null);
        this.listener = listener;
    }

    @Override
    public Object addingService(ServiceReference reference) {
        WebContainer webContainer = (WebContainer) context.getService(reference);
        String instanceId = (String) reference.getProperty(ServicesDictionary.KEY_INSTANCE_URI);
        if (!this.webContainers.containsKey(instanceId)) {
            this.webContainers.put(instanceId, webContainer);
            if (listener != null)
                listener.webcontainerAvailable(instanceId, webContainer);
        }
        return webContainer;
    }

    @Override
    public void removedService(ServiceReference reference, Object serviceObject) {
        String instanceId = (String) reference.getProperty(ServicesDictionary.KEY_INSTANCE_URI);
        WebContainer webContainer = this.webContainers.remove(instanceId);
        if (webContainer != null) {
            context.ungetService(reference);
            if (listener != null)
                listener.webcontainerUnAvailable(instanceId, webContainer);
        }
    }

    static final String classType = "(" + org.osgi.framework.Constants.OBJECTCLASS + "=" + WebContainer.class.getName() + ")";

    static String convertToFilter(String instanceIds) {
        StringTokenizer st = instanceIds != null ? new StringTokenizer(instanceIds, ",") : null;
        int size = instanceIds == null ? 0 : instanceIds.equals("*") ? 0 : st.countTokens();
        if (size == 0) {
            return classType;
        } else if (size == 1) {
            return "(& " + classType + "(org.openanzo.services.instanceURI=" + st.nextToken() + "))";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(& ");
            sb.append(classType);
            sb.append("(|");
            while (st.hasMoreTokens()) {
                sb.append("(org.openanzo.services.instanceURI=" + st.nextToken() + ")");
            }
            sb.append("))");
            return sb.toString();
        }
    }

    public interface WebcontainerTrackerListener {
        public void webcontainerAvailable(String instanceId, WebContainer wc);

        public void webcontainerUnAvailable(String instanceId, WebContainer wc);
    }
}
