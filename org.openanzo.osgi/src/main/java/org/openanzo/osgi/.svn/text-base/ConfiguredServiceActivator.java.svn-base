/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.services.ServicesDictionary;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.metatype.MetaTypeProvider;
import org.slf4j.LoggerFactory;

/**
 * Abstract activator that is managed via OSGI configuration admin
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public abstract class ConfiguredServiceActivator extends ServiceActivator implements ManagedService, MetaTypeProvider {
    private static final org.slf4j.Logger                    log = LoggerFactory.getLogger(ConfiguredServiceActivator.class);

    protected Dictionary<? extends Object, ? extends Object> configProperties;

    /**
     * @return the configProperties
     */
    public final Dictionary<? extends Object, ? extends Object> getConfigProperties() {
        return configProperties;
    }

    @Override
    protected Collection<String> getServiceClassNames() {
        HashSet<String> scn = new HashSet<String>(super.getServiceClassNames());
        scn.add(ConfiguredServiceActivator.class.getName());
        scn.add(ManagedService.class.getName());
        scn.add(MetaTypeProvider.class.getName());
        return scn;
    }

    @Override
    public String getExtraStatus(boolean html) {
        if (html) {
            if (getConfigProperties() != null) {
                StringBuilder sb = new StringBuilder("<br/>Configuration Properties: ");
                sb.append("<table border='1'>");
                for (Enumeration<? extends Object> keys = getConfigProperties().keys(); keys.hasMoreElements();) {
                    Object key = keys.nextElement();
                    Object value = getConfigProperties().get(key);
                    if (key.toString().toLowerCase().contains("password") && value.toString().startsWith("encrypted:")) {
                        value = "********";
                    }
                    sb.append("<tr><td>" + key.toString() + "</td><td>" + value.toString() + "</td></tr>");
                }
                sb.append("</table>");
                return sb.toString();
            } else {
                return ("<br/>Configuration Properties: <font color='#cc0000'>NOT Set</font> ");
            }
        } else {
            return ("Are Configuration properties set? " + (getConfigProperties() != null));
        }
    }

    @Override
    public boolean isInitialized() {
        lock.lock();
        try {
            return super.isInitialized() && configProperties != null;
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    public void updated(Dictionary properties) throws ConfigurationException {
        lock.lock();
        try {
            log.info(LogUtils.LIFECYCLE_MARKER, "Configuration Updated: " + this.getClass().getName());
            if (properties != null) {
                OsgiConfigurationUtils.validateConfiguration(getObjectClassDefinition(getServicePid(), null), properties);
                OsgiConfigurationUtils.updateConfigProperties(properties, context);
                boolean restartSystemRequired = false;
                Set<String> changedProps = null;
                if (this.configProperties != null && state == ServiceLifecycleState.STARTED) {
                    changedProps = OsgiConfigurationUtils.isRestartRequired(getObjectClassDefinition(getServicePid(), null), configProperties, properties);
                    restartSystemRequired = (changedProps == null);
                }
                this.configProperties = properties;
                if (!restartSystemRequired) {
                    configurationPropertiesSet(changedProps);
                    if (isInitialized()) {
                        if (changedProps == null) {
                            startLocked();
                        } else {
                            restartLocked(changedProps);
                        }
                    }
                }
            } else if (this.configProperties != null) {
                stopLocked(false);
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Config properties have been set
     * 
     * @param changedProps
     *            set of properties that changed
     * @throws ConfigurationException
     */
    public void configurationPropertiesSet(Set<String> changedProps) throws ConfigurationException {
    }

    /**
     * Start was called after the service was already started, which usually means the configuration changed
     * 
     * @param changedProps
     *            set of properties that changed
     */
    public void restartLocked(Set<String> changedProps) {
        lock.lock();
        ServiceLifecycleState prevState = state;
        try {
            if (state == ServiceLifecycleState.STARTED) {
                restarted(changedProps);
            } else if (state != ServiceLifecycleState.STARTED && state != ServiceLifecycleState.STARTING) {
                state = ServiceLifecycleState.STARTING;
                start();
                state = ServiceLifecycleState.STARTED;
            }
            fireEvent();
        } catch (Throwable t) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error restarting due to modified configuration:" + this.getClass().getName(), t);
            state = prevState;
        } finally {
            startThread = null;
            lock.unlock();
        }
    }

    /**
     * Start was called after the service was already started, which usually means the configuration changed
     * 
     * @param changedProps
     *            set of properties that changed
     */
    public void restarted(Set<String> changedProps) {
        Boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled != null && !enabled) {
            ServiceLifecycleState prevState = state;
            try {
                state = ServiceLifecycleState.STOPPING;
                stop(false);
            } catch (Throwable t) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error restarting due to modified configuration:" + this.getClass().getName(), t);
                state = prevState;
            } finally {
                state = ServiceLifecycleState.NOT_ENABLED;
            }
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    public String[] getLocales() {
        return null;
    }
}
