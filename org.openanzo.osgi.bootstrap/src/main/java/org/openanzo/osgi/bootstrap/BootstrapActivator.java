/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi.bootstrap;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.ServiceActivator;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.packageadmin.PackageAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BootstrapActivator extends ServiceActivator {
    private static final Logger           log         = LoggerFactory.getLogger(BootstrapActivator.class);

    private ManifestConfigurationListener listener    = null;

    private static final String           SERVICE_PID = "org.openanzo.osgi.Bootstrap";

    enum Mode {
        //If configuration already exists, do nothing with the new properties
        IGNORE,
        //If configuration already exists, add any new properties contained within file, without overwriting existing properties
        AUGMENT,
        //If configuration already exists, add any new properties contained within file, and update existing properties with new value
        UPDATE,
        //Remove old configuration and replace with new properties
        REPLACE
    }

    private Mode mode = Mode.IGNORE;

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public boolean registerService() {
        return false;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { ConfigurationAdmin.class.getName(), PackageAdmin.class.getName(), org.osgi.service.startlevel.StartLevel.class.getName() };
    }

    @Override
    public boolean startThreaded() {
        return false;
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);
        String modeString = context.getProperty("org.openanzo.osgi.bootstrap.mode");
        if (modeString != null) {
            mode = Mode.valueOf(modeString);
        }
    }

    @Override
    public void serviceAvailable(String type, ServiceReference ref, Object service) {
        if (type.equals(ConfigurationAdmin.class.getName())) {
            String bootStrap = context.getProperty("org.openanzo.osgi.bootstrap.path");
            if (bootStrap != null) {
                StringTokenizer st = new StringTokenizer(bootStrap, ":");
                while (st.hasMoreElements()) {
                    String path = st.nextToken().trim();
                    File pathFile = new File(path);
                    if (pathFile.exists()) {
                        if (pathFile.isDirectory()) {
                            loadDirectory(pathFile);
                        } else {
                            try {
                                loadBootStrapFile(null, new FileInputStream(pathFile));
                            } catch (FileNotFoundException fnfe) {
                                log.error(LogUtils.LIFECYCLE_MARKER, "Error loading bootstrap properties file:" + pathFile, fnfe);
                            }
                        }
                    }
                }
            }
            listener = new ManifestConfigurationListener(context, this);
            listener.open();
        }
    }

    static final String FILE_EXTENSION = ".properties";

    private void loadDirectory(File dir) {

        File files[] = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(FILE_EXTENSION);
            }
        });
        Arrays.sort(files, new Comparator<File>() {
            public int compare(File o1, File o2) { //NO_UCD
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (File file : files) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    loadDirectory(file);
                } else {
                    try {
                        loadBootStrapFile(null, new FileInputStream(file));
                    } catch (FileNotFoundException fnfe) {
                        log.error(LogUtils.LIFECYCLE_MARKER, "Error loading bootstrap properties file:" + file, fnfe);
                    }
                }
            }
        }
    }

    @SuppressWarnings( { "unchecked", "null" })
    // marshal between Configuration type
    void loadBootStrapFile(Bundle bundle, InputStream file) {
        ConfigurationAdmin configurationAdmin = getDependency(ConfigurationAdmin.class);
        try {
            Properties properties = new Properties();
            properties.load(file);
            if (bundle != null) {
                properties.put("bundleId", Long.toString(bundle.getBundleId()));
            }
            String factoryPid = (String) properties.get("service.factoryPid");
            if (factoryPid != null) {
                String instanceUri = ServicesDictionary.getInstanceURI(properties);
                Configuration[] cfgs = null;
                if (instanceUri != null) {
                    cfgs = configurationAdmin.listConfigurations("(&(" + ServicesDictionary.KEY_INSTANCE_URI + "=" + instanceUri + ")(service.factoryPid=" + factoryPid + "))");
                }
                boolean newConfig = false;
                if (cfgs == null || cfgs.length == 0) {
                    newConfig = true;
                } else if (mode == Mode.REPLACE) {
                    for (Configuration cfg : cfgs) {
                        cfg.delete();
                    }
                    newConfig = true;
                }

                if (newConfig) {
                    Configuration config = configurationAdmin.createFactoryConfiguration(factoryPid, null);
                    config.update(properties);
                } else if (mode != Mode.IGNORE) {
                    for (Configuration cfg : cfgs) {
                        boolean changed = false;
                        for (Entry<Object, Object> entry : properties.entrySet()) {
                            Object oldValue = cfg.getProperties().get(entry.getKey());
                            if (mode == Mode.UPDATE || (mode == Mode.AUGMENT && oldValue == null)) {
                                cfg.getProperties().put(entry.getKey(), entry.getValue());
                                changed = true;
                            }
                        }

                        if (changed) {
                            cfg.update(cfg.getProperties());
                        }
                    }

                }
            } else {
                String pid = (String) properties.get(Constants.SERVICE_PID);
                if (pid != null) {

                    Configuration[] cfgs = configurationAdmin.listConfigurations("(" + org.osgi.framework.Constants.SERVICE_PID + "=" + pid + ")");
                    boolean newConfig = false;
                    if (cfgs == null || cfgs.length == 0) {
                        newConfig = true;
                    } else if (mode == Mode.REPLACE) {
                        for (Configuration cfg : cfgs) {
                            cfg.delete();
                        }
                        newConfig = true;
                    }

                    if (newConfig) {
                        Configuration config = configurationAdmin.getConfiguration(pid, null);
                        config.update(properties);
                    } else if (mode != Mode.IGNORE) {
                        for (Configuration cfg : cfgs) {
                            boolean changed = false;
                            for (Entry<Object, Object> entry : properties.entrySet()) {
                                Object oldValue = cfg.getProperties().get(entry.getKey());
                                if (mode == Mode.UPDATE || (mode == Mode.AUGMENT && oldValue == null)) {
                                    cfg.getProperties().put(entry.getKey(), entry.getValue());
                                    changed = true;
                                }
                            }
                            if (changed) {
                                cfg.update(cfg.getProperties());
                            }
                        }

                    }
                }
            }
        } catch (Exception e) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error loading bootstrap file", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start() {
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (bundleStopping) {
            listener.close();
        }
    }

}
