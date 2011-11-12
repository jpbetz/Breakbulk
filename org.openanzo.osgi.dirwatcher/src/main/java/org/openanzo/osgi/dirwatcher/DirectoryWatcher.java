package org.openanzo.osgi.dirwatcher;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * -DirectoryWatcher-
 * 
 * This class runs a background task that checks a directory for new files or
 * removed files. These files can be configuration files or jars.
 */
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.Version;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.service.startlevel.StartLevel;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

class DirectoryWatcher extends Thread {
    private static final org.slf4j.Logger log                     = LoggerFactory.getLogger(DirectoryWatcher.class);

    private final static String           ALIAS_KEY               = "_alias_factory_pid";

    private final HashSet<File>           watchedDirectories      = new HashSet<File>();

    private final HashSet<String>         watchedDirectoriesPaths = new HashSet<String>();

    private final Map<String, Long>       currentManagedConfigs   = new HashMap<String, Long>();

    private final Map<String, Long>       currentManagedBundles   = new HashMap<String, Long>();

    private final long                    poll;

    private final int                     sl;

    private final BundleContext           context;

    private final ConfigurationAdmin      configAdmin;

    private final PackageAdmin            packageAdmin;

    private final StartLevel              startLevel;

    private final Bundle                  systemBundle;

    static final Marker                   LIFECYCLE_MARKER        = MarkerFactory.getMarker("services");

    protected DirectoryWatcher(ConfigurationAdmin configAdmin, PackageAdmin packageAdmin, StartLevel startLevel, Collection<String> directories, int sl, long poll, BundleContext context, Bundle systemBundle) {
        super("DirectoyrWatcherForLevel:" + sl);
        this.systemBundle = systemBundle;
        this.configAdmin = configAdmin;
        this.packageAdmin = packageAdmin;
        this.context = context;
        this.poll = poll;
        this.sl = sl;
        this.startLevel = startLevel;
        for (String dir : directories) {
            File directory = new File(dir.trim());
            if (!directory.isDirectory() && !directory.isFile()) {
                directory.mkdirs();
            }
            this.watchedDirectories.add(directory);
            watchedDirectoriesPaths.add(directory.getAbsolutePath());
        }
    }

    protected Collection<Bundle> installBundles() {
        try {
            Map<String, File> installed = new HashMap<String, File>();
            Map<String, String> versions = new HashMap<String, String>();
            Set<String> configs = new HashSet<String>();
            traverse(installed, versions, configs, watchedDirectories);
            Iterator<Map.Entry<String, Long>> currentIter = currentManagedBundles.entrySet().iterator();
            while (currentIter.hasNext()) {
                Map.Entry<String, Long> entry = currentIter.next();
                File currentFile = installed.get(entry.getKey());
                if (currentFile != null) {
                    if (currentFile.lastModified() <= entry.getValue()) {
                        currentIter.remove();
                    }
                }
            }
            doConfigs(currentManagedConfigs, configs);
            return doInstalled(currentManagedBundles, installed, versions);
        } catch (Throwable e) {
            log.error(LIFECYCLE_MARKER, "In main loop, we have serious trouble", e);
            return Collections.<Bundle> emptySet();
        }
    }

    /**
     * Main run loop, will traverse the directory, and then handle the delta between installed and newly found/lost bundles and configurations.
     * 
     */
    @Override
    public void run() {
        try {
            while (!interrupted()) {
                if (systemBundle == null || systemBundle.getState() == Bundle.ACTIVE) {
                    startBundles(installBundles());
                }
                Thread.sleep(poll);
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    @SuppressWarnings("unchecked")
    protected void startBundles(Collection<Bundle> starters) {
        if (starters.size() != 0) {
            for (Bundle bundle : starters) {
                if (!isFragment(bundle)) {
                    try {
                        Dictionary headers = bundle.getHeaders();
                        Object level = headers.get("Bundle-StartLevel");
                        int bundleLevel = sl;
                        if (level != null) {
                            bundleLevel = Integer.parseInt(level.toString());
                        }
                        startLevel.setBundleStartLevel(bundle, bundleLevel);
                        // if (startLevel.getStartLevel() >= bundleLevel) {
                        bundle.start();
                        //  }
                    } catch (BundleException e) {
                        log.error(LIFECYCLE_MARKER, "Error while starting a newly installed bundle " + bundle.getSymbolicName(), e);
                    }
                }
            }
        }
    }

    /**
     * Traverse the directory and fill the map with the found jars and configurations keyed by the abs file path.
     * 
     * @param jars
     *            Returns the abspath -> file for found jars
     * @param configs
     *            Returns the abspath -> file for found configurations
     * @param jardir
     *            The directory to traverse
     */
    private void traverse(Map<String, File> jars, Map<String, String> versions, Set<String> configs, Collection<File> jarDirs) {
        for (File jardir : jarDirs) {
            File list[] = jardir.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.isFile() && (pathname.getPath().endsWith(".jar") || pathname.getPath().endsWith(".cfg"));
                }
            });
            if (list != null) {
                for (File file : list) {
                    if (file.getPath().endsWith(".jar")) {
                        try {
                            JarFile jarFile = new JarFile(file);
                            Manifest manifest = jarFile.getManifest();
                            Attributes attributes = manifest.getMainAttributes();
                            String bundleName = attributes.getValue(Constants.BUNDLE_SYMBOLICNAME);
                            String version = attributes.getValue(Constants.BUNDLE_VERSION);
                            if (bundleName != null && version != null) {
                                String oldVers = versions.get(bundleName);
                                boolean newer = true;
                                if (oldVers != null) {
                                    Version newVersion = new Version(version);
                                    Version oldVersion = new Version(oldVers);
                                    if (oldVersion.compareTo(newVersion) > -1) {
                                        newer = false;
                                        if (log.isDebugEnabled()) {
                                            log.debug(LIFECYCLE_MARKER, "Bundle file with greater version already found: {}:{}>={}", new Object[] { bundleName, oldVers, version });
                                        }
                                    }
                                }
                                if (newer) {
                                    jars.put(bundleName, file);
                                    versions.put(bundleName, version);
                                }
                            }
                        } catch (IOException ioe) {
                            log.error(LIFECYCLE_MARKER, "Cannot load jar file:" + file.toString(), ioe);
                        }
                    } else if (file.getPath().endsWith(".cfg")) {
                        configs.add(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    /**
     * Install bundles that were discovered and uninstall bundles that are gone from the current state.
     * 
     * @param current
     *            A map location -> path that holds the current state
     * @param discovered
     *            A set of paths that represent the just found bundles
     */
    private Collection<Bundle> doInstalled(Map<String, Long> current, Map<String, File> discovered, Map<String, String> versioned) {
        boolean refresh = false;
        Bundle bundles[] = context.getBundles();
        for (int i = 0; i < bundles.length; i++) {
            Bundle bundle = bundles[i];
            String symbolicName = bundle.getSymbolicName();
            File file = discovered.remove(symbolicName);
            if (file != null) {
                // We have a bundle that is already installed
                // so we know it
                Version vers = new Version(versioned.get(symbolicName));
                Version bundleVers = new Version((String) bundle.getHeaders().get(Constants.BUNDLE_VERSION));
                int result = bundleVers.compareTo(vers);
                if (log.isDebugEnabled()) {
                    log.debug(LIFECYCLE_MARKER, "Existing Bundle vs New Bundle:{} New:{} Old:{} Compare:{}", new Object[] { symbolicName, vers.toString(), bundleVers.toString(), Integer.toString(result) });
                }
                if (result < 0 || file.lastModified() > bundle.getLastModified() + 4000) {
                    try {
                        // We treat this as an update, it is modified,,
                        // different size, and it is present in the dir
                        // as well as in the list of bundles.
                        InputStream in = new FileInputStream(file);
                        bundle.update(in);
                        refresh = true;
                        in.close();
                        log.info(LIFECYCLE_MARKER, "Updating bundle {}:{} from {} to {}", new Object[] { bundle.getLocation(), symbolicName, bundleVers.toString(), vers.toString() });
                        // Fragments can not be started. All other
                        // bundles are always started because OSGi treats this
                        // as a noop when the bundle is already started
                        if (!isFragment(bundle)) {
                            try {
                                bundle.start();
                            } catch (Exception e) {
                                log.error(LIFECYCLE_MARKER, "Fail to start bundle {}", e, symbolicName);
                            }
                        }
                    } catch (Exception e) {
                        log.error(LIFECYCLE_MARKER, "Failed to update bundle ", e);
                    }
                }
            } else {
                // Hmm. We found a bundle that looks like it came from our
                // watched directory but we did not find it this round.
                // Just remove it.
                for (String watchedDirectory : watchedDirectoriesPaths) {
                    if (bundle.getLocation().startsWith(watchedDirectory)) {
                        try {
                            bundle.uninstall();
                            refresh = true;
                            log.error(LIFECYCLE_MARKER, "Uninstall bundle {}", symbolicName);
                        } catch (Exception e) {
                            log.debug(LIFECYCLE_MARKER, "Uninstalled failed {}:{}", bundle.getLocation(), symbolicName);
                        }
                        break;
                    }
                }
            }

        }
        Collection<Bundle> starters = new ArrayList<Bundle>();
        for (Map.Entry<String, File> entry : discovered.entrySet()) {
            try {
                InputStream in = new FileInputStream(entry.getValue());
                Bundle bundle = context.installBundle(entry.getKey(), in);
                in.close();
                // We do not start this bundle yet. We wait after
                // refresh because this will minimize the disruption
                // as well as temporary unresolved errors.
                starters.add(bundle);
                log.info(LIFECYCLE_MARKER, "Installed {}", entry.getKey());
            } catch (Exception e) {
                log.error(LIFECYCLE_MARKER, "failed to install/start bundle: {}", e, entry.getKey());
            }
        }
        if (refresh) {
            refresh();
        }
        return starters;
    }

    /**
     * Handle the changes between the configurations already installed and the newly found/lost configurations.
     * 
     * @param current
     *            Existing installed configurations abspath -> File
     * @param discovered
     *            Newly found configurations
     */
    private void doConfigs(Map<String, Long> current, Set<String> discovered) {
        try {
            // Set all old keys as inactive, we remove them
            // when we find them to be active, will be left
            // with the inactive ones.
            Set<String> inactive = new HashSet<String>(current.keySet());

            for (String path : discovered) {
                File f = new File(path);

                if (!current.containsKey(path)) {
                    // newly found entry, set the configuration immediately
                    Long l = Long.valueOf(f.lastModified());
                    if (setConfig(f)) {
                        // Remember it for the next round
                        current.put(path, l);
                    }
                } else {
                    // Found an existing one.
                    // Check if it has been updated
                    long lastModified = f.lastModified();
                    long oldTime = (current.get(path)).longValue();
                    if (oldTime < lastModified) {
                        if (setConfig(f)) {
                            // Remember it for the next round.
                            current.put(path, Long.valueOf(lastModified));
                        }
                    }
                }
                // Mark this one as active
                inactive.remove(path);
            }
            for (String path : inactive) {
                File f = new File(path);
                if (deleteConfig(f)) {
                    current.remove(path);
                }
            }
        } catch (Exception ee) {
            log.error(LIFECYCLE_MARKER, "Error Processing config: ", ee);
        }
    }

    /**
     * Set the configuration based on the config file.
     * 
     * @param f
     *            Configuration file
     * @return
     * @throws Exception
     */
    private boolean setConfig(File f) throws Exception {

        Properties p = new Properties();
        InputStream in = new FileInputStream(f);
        p.load(in);
        in.close();
        String pid[] = parsePid(f.getName());
        if (pid[1] != null) {
            p.put(ALIAS_KEY, pid[1]);
        }
        Configuration config = getConfiguration(pid[0], pid[1]);
        if (config.getBundleLocation() != null) {
            config.setBundleLocation(null);
        }
        config.update(p);
        return true;
    }

    /**
     * Remove the configuration.
     * 
     * @param f
     *            File where the configuration in whas defined.
     * @return
     * @throws Exception
     */
    private boolean deleteConfig(File f) throws Exception {
        String pid[] = parsePid(f.getName());
        Configuration config = getConfiguration(pid[0], pid[1]);
        config.delete();
        return true;
    }

    private String[] parsePid(String path) {
        String pid = path.substring(0, path.length() - 4);
        int n = pid.indexOf('-');
        if (n > 0) {
            String factoryPid = pid.substring(n + 1);
            pid = pid.substring(0, n);
            return new String[] { pid, factoryPid };
        } else {
            return new String[] { pid, null };
        }
    }

    private Configuration getConfiguration(String pid, String factoryPid) throws Exception {
        if (factoryPid != null) {
            String filter = "(|(" + ALIAS_KEY + "=" + factoryPid + ")(.alias_factory_pid=" + factoryPid + "))";
            Configuration configs[] = configAdmin.listConfigurations(filter);
            if (configs == null || configs.length == 0) {
                return configAdmin.createFactoryConfiguration(pid, null);
            } else {
                return configs[0];
            }
        } else {
            return configAdmin.getConfiguration(pid, null);
        }
    }

    /**
     * Check if a bundle is a fragment.
     * 
     * @param bundle
     * @return
     */
    private boolean isFragment(Bundle bundle) {
        if (packageAdmin != null) {
            return packageAdmin.getBundleType(bundle) == PackageAdmin.BUNDLE_TYPE_FRAGMENT;
        }
        return false;
    }

    /**
     * Convenience to refresh the packages
     */
    private void refresh() {
        packageAdmin.refreshPackages(null);
    }

    protected void close() {
        interrupt();
        try {
            join(10000);
        } catch (InterruptedException ie) {
            // Ignore
        }
    }
}
