/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Aug 19, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet.internal;

import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.servlet.IServletComponent;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bunle listener that looks for servlet config headers in bundles in order to serve servlets defined in config files
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ServletConfigurationListener implements BundleListener {
    private static final Logger         log         = LoggerFactory.getLogger(ServletConfigurationListener.class);

    BundleContext                       context     = null;

    HashSet<Long>                       bundles     = new HashSet<Long>();

    ConfigurationAdmin                  configAdmin = null;

    Map<String, BundleServletActivator> activators  = new ConcurrentHashMap<String, BundleServletActivator>();

    ServletConfigurationListener(ConfigurationAdmin configAdmin, BundleContext context) {
        this.context = context;
        this.configAdmin = configAdmin;
    }

    void open() {
        context.addBundleListener(this);
        Bundle[] bundles = context.getBundles();
        for (Bundle bundle : bundles) {
            if (Bundle.ACTIVE == bundle.getState()) {
                addingBundle(bundle);
            }
        }
    }

    void close(boolean bundleStopping) {
        context.removeBundleListener(this);
        for (BundleServletActivator activator : activators.values()) {
            activator.stop(bundleStopping);
        }
        activators.clear();
    }

    public void bundleChanged(BundleEvent event) {
        Bundle bundle = event.getBundle();
        if (Bundle.ACTIVE == bundle.getState()) {
            addingBundle(bundle);
        }
    }

    /**
     * Bundle added to system
     * 
     * @param bundle
     *            bundle that was added
     */
    @SuppressWarnings("unchecked")
    public void addingBundle(Bundle bundle) {
        if (!bundles.contains(bundle.getBundleId())) {
            bundles.add(bundle.getBundleId());
            Dictionary<String, String> headers = bundle.getHeaders();
            String servletConfig = headers.get(IServletComponent.SERVLET_CONFIG);
            if (servletConfig != null) {
                servletConfig = OsgiConfigurationUtils.preprocessString(servletConfig, bundle.getBundleContext());
                Properties properties = new Properties();
                URL entry = bundle.getEntry(servletConfig);
                if (entry != null) {
                    try {
                        properties.load(entry.openStream());
                        String pid = properties.getProperty(Constants.SERVICE_PID);
                        activators.put(pid, new BundleServletActivator(bundle, pid, configAdmin, properties));
                    } catch (IOException ioe) {
                        log.error(LogUtils.LIFECYCLE_MARKER, "Error loading servlet config properties for bundle:" + bundle.getSymbolicName(), ioe);
                    }
                }
            }
        }
    }
}
