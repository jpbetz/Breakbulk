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
package org.openanzo.servlet.sparql;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Servlet;

import org.openanzo.client.pool.ClientPoolDependentActivator;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.servlet.BaseServletComponent;
import org.openanzo.servlet.IServletComponent;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for SPARQL endpoint servlet
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class Activator extends ClientPoolDependentActivator {
    private static final Logger        log         = LoggerFactory.getLogger(Activator.class);

    QueryServlet                       servlet     = null;

    static final String                SERVICE_PID = "org.openanzo.servlet.Sparql";

    GenericObjectClassDef       classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled }, null));
    }

    private ServiceRegistration serviceRegistration;

    @Override
    public String[] getDependencies() {
        return new String[] {};
    }

    /**
     * @return the SERVICE_PID
     */
    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public void start() {
        servlet = new QueryServlet(clientPool);
        BaseServletComponent component = new BaseServletComponent() {
            public Servlet getServlet() {
                return servlet;
            }
        };
        try {
            Properties configProps = new Properties();
            for (Enumeration<?> keys = configProperties.keys(); keys.hasMoreElements();) {
                Object key = keys.nextElement();
                configProps.put(key, configProperties.get(key));
            }
            component.initialize(context, configProperties);
            serviceRegistration = context.registerService(IServletComponent.class.getName(), component, configProperties);
        } catch (AnzoException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error starting sparql servlet", ae);
            throw new AnzoRuntimeException(ae);
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (serviceRegistration != null && !bundleStopping) {
            serviceRegistration.unregister();
            serviceRegistration = null;
        }
    }
}
