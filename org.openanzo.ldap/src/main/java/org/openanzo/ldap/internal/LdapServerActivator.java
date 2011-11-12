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
package org.openanzo.ldap.internal;

import java.util.Set;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.ldap.ObjectClassDef;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.services.LDAPDictionary;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ldap Server Activator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class LdapServerActivator extends ConfiguredServiceActivator {
    private static final Logger log         = LoggerFactory.getLogger(LdapServerActivator.class);

    final static ObjectClassDef ocd         = new ObjectClassDef();

    /** Service PID for ldap server */
    public static final String  SERVICE_PID = "org.openanzo.ldap.EmbeddedLDAPServer";

    private LdapServer          server;

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[0];
    }

    @Override
    public void configurationPropertiesSet(Set<String> changedProperties) throws ConfigurationException {
        String port = context.getProperty(LDAPDictionary.KEY_LDAP_PORT);
        if (port != null) {
            LDAPDictionary.setPort(configProperties, Integer.valueOf(port));
        }
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);
        state = ServiceLifecycleState.NOT_ENABLED;
    }

    @Override
    public void start() {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            try {
                server = new LdapServer(context, configProperties, eventAdmin);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(LogUtils.LIFECYCLE_MARKER, "Error starting the Embedded ApacheDS LDAP Server", e);
                throw new AnzoRuntimeException(ExceptionConstants.COMBUS.CREATE_BROKER_FAILED, e);
            }
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    @Override
    public void restarted(Set<String> changedProperties) {
        stop(false);
        start();
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (server != null) {
            server.stop(bundleStopping);
            server = null;
        }
    }

    public ObjectClassDefinition getObjectClassDefinition(String pid, String locale) {
        return ocd;
    }

}
