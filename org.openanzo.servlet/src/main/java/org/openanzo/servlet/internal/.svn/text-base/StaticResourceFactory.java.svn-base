/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 18, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet.internal;

import java.util.Dictionary;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Servlet;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.servlet.BaseServletComponent;
import org.openanzo.servlet.IServletComponent;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class StaticResourceFactory implements ManagedServiceFactory {
    private static final Logger                    log          = LoggerFactory.getLogger(StaticResourceFactory.class);

    ConcurrentHashMap<String, ServiceRegistration> resourcePids = new ConcurrentHashMap<String, ServiceRegistration>();

    static final String                            FACTORY_PID  = "org.openanzo.servlet.StaticResourceFactory";

    protected BundleContext                        context      = null;

    StaticResourceFactory(BundleContext context, ConfigurationAdmin configurationAdmin) {
        this.context = context;
        Properties props = new Properties();
        props.put(org.osgi.framework.Constants.SERVICE_PID, StaticResourceFactory.FACTORY_PID);
        context.registerService(new String[] { StaticResourceFactory.class.getName(), ManagedServiceFactory.class.getName() }, this, props);
    }

    public String getName() {
        return FACTORY_PID;
    }

    public void deleted(String pid) {
        ServiceRegistration component = resourcePids.remove(pid);
        if (component != null) {
            component.unregister();
        }
    }

    @SuppressWarnings("unchecked")
    public void updated(String pid, Dictionary properties) throws ConfigurationException {
        if (!resourcePids.contains(pid) && properties != null) {
            OsgiConfigurationUtils.updateConfigProperties(properties, context);
            BaseServletComponent servlet = new BaseServletComponent() {
                public Servlet getServlet() {
                    return null;
                }
            };
            try {
                servlet.initialize(context, properties);
                context.registerService(IServletComponent.class.getName(), servlet, properties);
            } catch (AnzoException ae) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error initializing static resource factory", ae);
                throw new AnzoRuntimeException(ae);
            }
        }
    }
}
