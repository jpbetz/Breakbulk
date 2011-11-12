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
package org.openanzo.osgi.bootstrap;

import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class ManifestConfigurationListener implements SynchronousBundleListener {
    private static final Logger      log           = LoggerFactory.getLogger(ManifestConfigurationListener.class);

    private static final String      BUNDLE_CONFIG = "Configuration-Properties";

    private final BundleContext      context;

    private final BootstrapActivator activator;

    private final HashSet<Long>      bundles       = new HashSet<Long>();

    protected final ReentrantLock    lock          = new ReentrantLock();

    protected ManifestConfigurationListener(BundleContext context, BootstrapActivator activator) {
        this.context = context;
        this.activator = activator;
    }

    // marshal from xml decoder
    protected void open() {
        lock.lock();
        try {
            Bundle[] bundles = context.getBundles();
            for (Bundle bundle : bundles) {
                if (Bundle.ACTIVE == bundle.getState()) {
                    addingBundle(bundle);
                }
            }
            context.addBundleListener(this);
        } finally {
            lock.unlock();
        }
    }

    protected void close() {
        context.removeBundleListener(this);
    }

    public void bundleChanged(BundleEvent event) {
        lock.lock();
        try {
            Bundle bundle = event.getBundle();
            if (Bundle.ACTIVE == bundle.getState()) {
                addingBundle(bundle);
            }
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    private void addingBundle(Bundle bundle) {
        if (!bundles.contains(bundle.getBundleId())) {
            bundles.add(bundle.getBundleId());
            Dictionary<String, String> headers = bundle.getHeaders();
            String initPath = headers.get(BUNDLE_CONFIG);
            if (initPath != null) {
                StringTokenizer st = new StringTokenizer(initPath, ",");
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    token = OsgiConfigurationUtils.preprocessString(token, bundle.getBundleContext());
                    if (token.endsWith(BootstrapActivator.FILE_EXTENSION)) {
                        processFile(bundle, token);
                    } else if (token.endsWith("/")) {
                        processDirectory(bundle, token, false);
                    } else if (token.endsWith("/*")) {
                        processDirectory(bundle, token, true);
                    }

                }
            }

        }
    }

    private void processFile(Bundle bundle, String fileName) {
        try {
            URL initResource = bundle.getEntry(fileName);
            if (initResource != null) {
                activator.loadBootStrapFile(bundle, initResource.openStream());
            }
        } catch (IOException ioe) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error loding bundle's " + bundle.getSymbolicName() + " file:" + fileName, ioe);
        }
    }

    @SuppressWarnings("unchecked")
    private void processDirectory(Bundle bundle, String directoryName, boolean subDirs) {
        Enumeration entries = bundle.getEntryPaths(directoryName);
        if (entries != null) {
            while (entries.hasMoreElements()) {
                String entry = (String) entries.nextElement();
                if (entry.endsWith(BootstrapActivator.FILE_EXTENSION)) {
                    processFile(bundle, entry);
                } else if (subDirs && entry.endsWith("/")) {
                    processDirectory(bundle, entry, subDirs);
                }
            }
        }
    }
}
