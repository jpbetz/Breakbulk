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

import java.io.IOException;
import java.util.Dictionary;
import java.util.Properties;

import javax.servlet.Servlet;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.servlet.BaseServletComponent;
import org.openanzo.servlet.IServletComponent;
import org.openanzo.servlet.ServletDictionary;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for servlets in bundles
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BundleServletActivator implements ManagedService {
    private static final Logger                              log        = LoggerFactory.getLogger(BundleServletActivator.class);

    protected Bundle                                         bundle     = null;

    protected String                                         servicePid = null;

    protected Dictionary<? extends Object, ? extends Object> configProperties;

    protected BundleServlet                                  servlet    = null;

    protected ServiceRegistration                            reg        = null;

    BundleServletActivator(Bundle bundle, String servicePid, ConfigurationAdmin configurationAdmin, Properties properties) {
        this.bundle = bundle;
        this.servicePid = servicePid;
        bundle.getBundleContext().registerService(new String[] { BundleServletActivator.class.getName(), ManagedService.class.getName() }, this, properties);
        try {
            Configuration[] configs = configurationAdmin.listConfigurations("(" + Constants.SERVICE_PID + "=" + servicePid + ")");
            if (configs == null || configs.length == 0) {
                Configuration configuration = configurationAdmin.getConfiguration(servicePid, null);
                configuration.update(properties);
            }
        } catch (InvalidSyntaxException ise) {
            log.error(LogUtils.LIFECYCLE_MARKER, Messages.formatString(ExceptionConstants.OSGI.INVALID_CONFIGURATION_SYTAX, ise.getFilter()), ise);
        } catch (IOException ise) {
            log.error(LogUtils.LIFECYCLE_MARKER, Messages.formatString(ExceptionConstants.OSGI.ERROR_UPDATING_CONFIG, ManagedService.class.getName()), ise);
        }
    }

    @SuppressWarnings("unchecked")
    public void updated(Dictionary configProperties) throws ConfigurationException {
        this.configProperties = configProperties;
        if (configProperties != null) {
            OsgiConfigurationUtils.updateConfigProperties(configProperties, bundle.getBundleContext());
            start();
        } else {
            stop(false);
        }
    }

    void start() {
        try {
            servlet = new BundleServlet(bundle.getBundleContext(), configProperties);
            reg = bundle.getBundleContext().registerService(IServletComponent.class.getName(), servlet, configProperties);
        } catch (AnzoException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, Messages.formatString(ExceptionConstants.OSGI.ERROR_STARTING, "Servlet Activator"), ae);
            throw new AnzoRuntimeException(ae);
        }
    }

    void stop(boolean bundleStopping) {
        if (reg != null && !bundleStopping) {
            reg.unregister();
            reg = null;
        }
    }

    class BundleServlet extends BaseServletComponent {
        Servlet servlet = null;

        @SuppressWarnings("unchecked")
        public BundleServlet(BundleContext context, Dictionary<? extends Object, ? extends Object> configProperties) throws AnzoException {
            String classname = ServletDictionary.getServletClass(configProperties);
            if (classname != null) {
                try {
                    Class<Servlet> servletClass = context.getBundle().loadClass(classname);
                    servlet = servletClass.newInstance();
                } catch (ClassNotFoundException cnfe) {
                    log.error(LogUtils.LIFECYCLE_MARKER, Messages.formatString(ExceptionConstants.OSGI.ERROR_CANT_INSTANTIATE_CLASS, classname), cnfe);
                } catch (IllegalAccessException cnfe) {
                    log.error(LogUtils.LIFECYCLE_MARKER, Messages.formatString(ExceptionConstants.OSGI.ERROR_CANT_INSTANTIATE_CLASS, classname), cnfe);
                } catch (InstantiationException cnfe) {
                    log.error(LogUtils.LIFECYCLE_MARKER, Messages.formatString(ExceptionConstants.OSGI.ERROR_CANT_INSTANTIATE_CLASS, classname), cnfe);
                }
            }
            initialize(context, configProperties);
        }

        public Servlet getServlet() {
            return servlet;
        }

    }
}
