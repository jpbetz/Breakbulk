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
package org.openanzo.binarystore.server;

import java.util.Properties;

import javax.servlet.Servlet;

import org.openanzo.binarystore.server.attributes.BinaryStoreAttributes;
import org.openanzo.client.pool.ClientPoolDependentActivator;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.services.ServicesDictionary;
import org.openanzo.servlet.BaseServletComponent;
import org.openanzo.servlet.IServletComponent;
import org.openanzo.servlet.SecurityConstraint;
import org.openanzo.servlet.attributes.ServletAttributes;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;

/**
 *Activator for the BinaryStore servlet
 */
public class Activator extends ClientPoolDependentActivator {
    BinaryStoreServlet          servlet             = null;

    static final String         SERVICE_PID         = "org.openanzo.binarystore.Servlet";

    private ServiceRegistration serviceRegistration = null;

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[0];
    }

    @Override
    public void start() throws AnzoException {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            servlet = new BinaryStoreServlet(clientPool);
            Boolean requireSSL = ServicesDictionary.getRequireSSL(configProperties);

            final boolean reqSSL = (requireSSL != null) ? requireSSL.booleanValue() : false;
            BaseServletComponent component = new BaseServletComponent() {
                public Servlet getServlet() {
                    return servlet;
                }

                @Override
                public SecurityConstraint getSecurityConstraint() {
                    return reqSSL ? SecurityConstraint.INTEGRAL : super.getSecurityConstraint();
                }
            };
            servlet.initialize(configProperties);
            component.initialize(context, configProperties);
            Properties props = new Properties();
            props.put(org.osgi.framework.Constants.SERVICE_DESCRIPTION, servlet.getServletInfo());
            serviceRegistration = context.registerService(IServletComponent.class.getName(), component, props);
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    @Override
    public void stop(boolean bundleStopping) throws AnzoException {
        if (!bundleStopping && serviceRegistration != null) {
            serviceRegistration.unregister();
            serviceRegistration = null;
        }
        if (servlet != null) {
            servlet.stop(bundleStopping);
            servlet = null;
        }
    }

    GenericObjectClassDef classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled, BinaryStoreAttributes.ServerNode, BinaryStoreAttributes.FileSystemRoot, BinaryStoreAttributes.ProgressUpdateFrequency, ServicesAttributes.User, ServicesAttributes.Password, ServletAttributes.DocRoot, ServletAttributes.ContextPath, ServletAttributes.ProtectedPathSpec, ServletAttributes.AuthorizationType,
                ServletAttributes.GzipOutput }, new AttributeDefinition[] { ServletAttributes.LoginPage, ServletAttributes.ErrorPage }));
    }

}
