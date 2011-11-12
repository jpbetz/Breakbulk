/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 2, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi.configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.IStatusProvider;
import org.openanzo.osgi.ISystemConfig;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.CombusAttributes;
import org.openanzo.osgi.attributes.LDAPAttributes;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ConfigurationPlugin;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.MetaTypeProvider;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class SystemConfigurationConfigPlugin implements ConfigurationPlugin, ManagedService, MetaTypeProvider, ISystemConfig {
    private static final Logger               log              = LoggerFactory.getLogger(SystemConfigurationConfigPlugin.class);

    /** Service PID for SystemConfigurationConfigPlugin */
    public static final String                SERVICE_PID      = "org.openanzo.osgi.SystemConfig";

    public final static GenericObjectClassDef ocd              = new GenericObjectClassDef(SERVICE_PID, "Anzo OSGI Default System Configuration", "Default configuration properties that other bundles use as defaults when they themselves do not have the property locally configured.", new AttributeDefinition[] { CombusAttributes.Host, CombusAttributes.Port, ServicesAttributes.User, ServicesAttributes.Password }, new AttributeDefinition[] { ServicesAttributes.RequireSSL, CombusAttributes.SslHost,
            CombusAttributes.SslPort, CombusAttributes.UseSsl, LDAPAttributes.Host, LDAPAttributes.Port, LDAPAttributes.LdapServerUser, LDAPAttributes.LdapServerPassword });

    private final Properties                  systemProperties = new Properties();

    private final BundleContext               context;

    private ServiceRegistration               credentialsReg   = null;

    private ServiceRegistration               systemConfig     = null;

    SystemConfigurationConfigPlugin(BundleContext context) {
        this.context = context;
        if (credentialsReg == null) {
            Properties props = new Properties();
            props.put(Constants.SERVICE_PID, SystemConfigurationConfigPlugin.SERVICE_PID);
            props.put(org.osgi.framework.Constants.SERVICE_DESCRIPTION, "SystemConfiguration Config Plugin");
            credentialsReg = context.registerService(new String[] { ManagedService.class.getName(), ConfigurationPlugin.class.getName(), MetaTypeProvider.class.getName() }, this, props);
        }
    }

    @SuppressWarnings("unchecked")
    // implement unchecked interface
    public void updated(Dictionary config) throws ConfigurationException {
        if (config != null) {
            OsgiConfigurationUtils.validateConfiguration(ocd, config);
            for (Enumeration keys = config.keys(); keys.hasMoreElements();) {
                Object key = keys.nextElement();
                Object value = config.get(key);
                systemProperties.put(key, value);
            }
            if (systemConfig == null) {
                systemConfig = context.registerService(new String[] { ISystemConfig.class.getName() }, this, null);
                Thread statusThread = new Thread("StartupStatus Thread") {

                    @Override
                    public void run() {
                        try {
                            while (true) {
                                Thread.sleep(1000);
                                try {
                                    ServiceReference refs[] = context.getAllServiceReferences(IStatusProvider.class.getName(), null);
                                    if (refs != null) {
                                        boolean allOk = true;
                                        for (ServiceReference ref : refs) {
                                            IStatusProvider service = (IStatusProvider) context.getService(ref);
                                            if (service.getState() != ServiceLifecycleState.NOT_ENABLED && service.getState() != ServiceLifecycleState.STARTED) {
                                                allOk = false;
                                            }
                                        }
                                        if (allOk) {
                                            if (context.getProperty("org.openanzo.regressiontest") != null) {
                                                try {
                                                    String ah = context.getProperty("org.openanzo.regressiontest");
                                                    File file = new File(ah != null ? ah : ".", "status.txt");
                                                    FileWriter fw = new FileWriter(file);
                                                    fw.write("ok");
                                                    fw.close();
                                                } catch (IOException ioe) {
                                                    log.error(LogUtils.LIFECYCLE_MARKER, "Error setting status file", ioe);
                                                }
                                            }
                                            System.out.println("All Currently Registered Services started.");
                                            return;
                                        }
                                    }
                                } catch (InvalidSyntaxException ise) {
                                    log.error(LogUtils.LIFECYCLE_MARKER, Messages.formatString(ExceptionConstants.OSGI.INVALID_SERVICE_SYNTAX, ise.getFilter()), ise);
                                }
                            }
                        } catch (InterruptedException ie) {
                            log.error(LogUtils.LIFECYCLE_MARKER, "Status thread interrupted", ie);
                            return;
                        }
                    }
                };
                statusThread.setDaemon(true);
                statusThread.start();

            }
        }
    }

    protected void close() {
        if (credentialsReg != null) {
            credentialsReg.unregister();
        }
        if (systemConfig != null) {
            systemConfig.unregister();
        }
    }

    @SuppressWarnings("unchecked")
    public void modifyConfiguration(ServiceReference serviceReference, Dictionary config) {
        String pid = (String) config.get(Constants.SERVICE_PID);
        if (pid != null && !pid.equals(SERVICE_PID) && (pid.startsWith("org.openanzo.") || pid.startsWith("com.cambridgesemantics."))) {
            for (Map.Entry<Object, Object> entry : systemProperties.entrySet()) {
                if (config.get(entry.getKey()) == null) {
                    config.put(entry.getKey(), entry.getValue());
                }
            }
            Properties props = (Properties) System.getProperties().clone();
            for (Map.Entry<Object, Object> entry : props.entrySet()) {
                String key = entry.getKey().toString();
                if (key.startsWith("org.openanzo.") || key.startsWith("com.cambridgesemantics.") && config.get(key) != null) {
                    config.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public String[] getLocales() {
        return null;
    }

    public ObjectClassDefinition getObjectClassDefinition(String pid, String locale) {
        return ocd;
    }

}
