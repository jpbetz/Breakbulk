/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 15, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet.internal;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.security.keystore.ISecretKeystore;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.ServicesDictionary;
import org.openanzo.servlet.IServletComponent;
import org.ops4j.pax.web.service.WebContainer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main activator for hosting servlets
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ServletsActivator extends ConfiguredServiceActivator {
    private static final Logger                     log             = LoggerFactory.getLogger(ServletsActivator.class);

    static final String                             SERVICE_PID     = "org.openanzo.servlet.Servlets";

    protected OsgiServiceTracker<IServletComponent> servletsTracker = null;

    protected ArrayList<IServletComponent>          servlets        = new ArrayList<IServletComponent>();

    protected StaticResourceFactory                 factory         = null;

    protected ServletConfigurationListener          servletListener = null;

    GenericObjectClassDef                           classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled }, null));
    }

    @Override
    public String[] getDependencies() {
        return new String[] { ConfigurationAdmin.class.getName(), IAuthenticationService.class.getName(), WebContainer.class.getName(), ISecretKeystore.class.getName() };
    }

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        super.stop(context);

        if (servletsTracker != null) {
            servletsTracker.close();
        }
    }

    @Override
    public void serviceAvailable(String type, ServiceReference ref, Object service) {
        if (type.equals(ConfigurationAdmin.class.getName())) {
            ConfigurationAdmin configurationAdmin = (ConfigurationAdmin) service;
            factory = new StaticResourceFactory(context, configurationAdmin);
            servletListener = new ServletConfigurationListener(configurationAdmin, context);
            servletListener.open();
        } else if (type.equals(WebContainer.class.getName())) {
            if (state == ServiceLifecycleState.STARTED) {
                for (IServletComponent servlet : servlets) {
                    registerServlet(servlet, (WebContainer) service, ref);
                }
            }
        }
    }

    @Override
    public void serviceUnAvailable(String type, ServiceReference ref, Object service) {
        if (type.equals(WebContainer.class.getName())) {
            if (state == ServiceLifecycleState.STARTED) {
                for (IServletComponent servlet : servlets) {
                    unregisterServlet(servlet, (WebContainer) service, ref);
                }
            }
        }
    }

    @Override
    public void start() {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (log.isInfoEnabled()) {
            log.info(LogUtils.LIFECYCLE_MARKER, "Starting the servlet whiteboard listener:" + enabled);
        }
        if (enabled) {
            if (log.isInfoEnabled()) {
                log.info(LogUtils.LIFECYCLE_MARKER, "Starting the servlet whiteboard listener");
            }
            servletsTracker = new OsgiServiceTracker<IServletComponent>(new IServiceTrackerListener<IServletComponent>() {
                public void unregisterService(IServletComponent servlet) {
                    if (servlets.remove(servlet)) {
                        Map<ServiceReference, WebContainer> wcs = getDependencies(WebContainer.class);
                        if (wcs != null) {
                            for (Map.Entry<ServiceReference, WebContainer> entry : wcs.entrySet())
                                unregisterServlet(servlet, entry.getValue(), entry.getKey());
                        }
                    }
                }

                public void registerService(IServletComponent servlet) {
                    if (log.isInfoEnabled()) {
                        log.info(LogUtils.LIFECYCLE_MARKER, "Registering servlet:" + servlet.toString());
                    }
                    if (!servlets.contains(servlet)) {
                        servlets.add(servlet);
                        Map<ServiceReference, WebContainer> wcs = getDependencies(WebContainer.class);
                        if (wcs != null) {
                            for (Map.Entry<ServiceReference, WebContainer> entry : wcs.entrySet())
                                registerServlet(servlet, entry.getValue(), entry.getKey());
                        }
                    }
                }

                public Class<IServletComponent> getComponentType() {
                    return IServletComponent.class;
                }
            }, context);
            servletsTracker.open();
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    private void registerServlet(IServletComponent servlet, WebContainer wc, ServiceReference ref) {
        Set<String> instanceUris = servlet.getWebcontainerInstanceURIs();
        if (instanceUris == null || instanceUris.size() == 0) {
            servlet.registerServlet(wc, getDependency(IAuthenticationService.class), getDependency(ISecretKeystore.class));
        } else {
            String instance = (String) ref.getProperty("org.ops4j.pax.web.instanceId");
            if (instance != null && instanceUris.contains(instance)) {
                servlet.registerServlet(wc, getDependency(IAuthenticationService.class), getDependency(ISecretKeystore.class));
            }
        }
    }

    private void unregisterServlet(IServletComponent servlet, WebContainer wc, ServiceReference ref) {
        Set<String> instanceUris = servlet.getWebcontainerInstanceURIs();
        if (instanceUris == null || instanceUris.size() == 0) {
            servlet.unregisterServlet(wc);
        } else {
            String instance = (String) ref.getProperty("org.ops4j.pax.web.instanceId");
            if (instance != null && instanceUris.contains(instance)) {
                servlet.unregisterServlet(wc);
            }
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        Map<ServiceReference, WebContainer> wcs = getDependencies(WebContainer.class);
        for (IServletComponent servlet : servlets) {
            if (wcs != null) {
                for (Map.Entry<ServiceReference, WebContainer> entry : wcs.entrySet())
                    unregisterServlet(servlet, entry.getValue(), entry.getKey());
            }
        }
        servlets.clear();
        if (servletListener != null) {
            servletListener.close(bundleStopping);
        }
    }
}
