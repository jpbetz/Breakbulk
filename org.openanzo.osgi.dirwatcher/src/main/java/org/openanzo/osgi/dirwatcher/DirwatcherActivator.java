/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 9, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi.dirwatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.StringTokenizer;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.service.startlevel.StartLevel;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DirwatcherActivator implements BundleActivator {

    private final ArrayList<DirectoryWatcher> watchers = new ArrayList<DirectoryWatcher>();

    @SuppressWarnings("unchecked")
    public void start(BundleContext bundleContext) throws Exception {
        Bundle bundles[] = bundleContext.getBundles();
        Bundle systemBundle = null;
        for (Bundle bundle : bundles) {
            if (bundle.getSymbolicName().equals("org.eclipse.osgi")) {
                systemBundle = bundle;
                break;
            }
        }
        ServiceReference configAdminRef = bundleContext.getServiceReference(ConfigurationAdmin.class.getName());
        ServiceReference packageAdminRef = bundleContext.getServiceReference(PackageAdmin.class.getName());
        ServiceReference startLevelRef = bundleContext.getServiceReference(StartLevel.class.getName());

        ConfigurationAdmin configAdmin = (ConfigurationAdmin) bundleContext.getService(configAdminRef);
        PackageAdmin packageAdmin = (PackageAdmin) bundleContext.getService(packageAdminRef);
        StartLevel startLevel = (StartLevel) bundleContext.getService(startLevelRef);

        Collection<Bundle> starters[] = new Collection[10];
        DirectoryWatcher dws[] = new DirectoryWatcher[10];
        for (int i = 1; i < 10; i++) {
            String as = bundleContext.getProperty(ANZO_WATCH_DIR + i);
            if (as != null) {
                HashSet<String> directories = new HashSet<String>();
                StringTokenizer st = new StringTokenizer(as, ",");
                while (st.hasMoreTokens()) {
                    directories.add(st.nextToken());
                }
                DirectoryWatcher dw = new DirectoryWatcher(configAdmin, packageAdmin, startLevel, directories, i, 5000, bundleContext, systemBundle);
                watchers.add(dw);
                starters[i] = dw.installBundles();
                dws[i] = dw;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (starters[i] != null) {
                dws[i].startBundles(starters[i]);
            }
        }
        /*for (DirectoryWatcher dw : watchers) {
            dw.start();
        }*/
    }

    public void stop(BundleContext context) throws Exception {
        for (DirectoryWatcher dw : watchers) {
            dw.close();
        }
    }

    static final String ANZO_WATCH_DIR = "org.openanzo.directory.";
}
