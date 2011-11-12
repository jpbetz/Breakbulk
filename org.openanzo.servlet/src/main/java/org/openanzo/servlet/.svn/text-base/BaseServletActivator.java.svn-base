/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Aug 4, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet;

import java.util.Collection;

import javax.servlet.Servlet;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.services.ServicesDictionary;
import org.openanzo.servlet.internal.BaseServletClassDef;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract activator for servlet bundles
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
abstract public class BaseServletActivator extends ConfiguredServiceActivator {
    private static final Logger log      = LoggerFactory.getLogger(BaseServletActivator.class);

    //private ServiceLifecycleState state    = ServiceLifecycleState.CREATED;

    private BaseServletClassDef classDef = null;

    private ServiceRegistration reg      = null;

    @Override
    public abstract String getServicePid();

    /**
     * Get name of the servlet
     * 
     * @return name of the servlet
     */
    public abstract String getName();

    /**
     * Get the servlet
     * 
     * @return the servlet
     */
    public abstract Servlet getServlet();

    /**
     * Set of additional required configuraion attribtues
     * 
     * @return Set of additional required configuraion attribtues
     */
    public abstract Collection<AttributeDefinition> getAdditionalRequired();

    /**
     * Set of additional optional configuraion attribtues
     * 
     * @return Set of additional optional configuraion attribtues
     */
    public abstract Collection<AttributeDefinition> getAdditionalOptional();

    /**
     * Base constructor
     */
    public BaseServletActivator() {
        classDef = new BaseServletClassDef(getServicePid(), getName(), getBundleDescription(), getAdditionalRequired(), getAdditionalOptional());
    }

    @Override
    public String[] getDependencies() {
        return new String[0];
    }

    @Override
    public void start() {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            BaseServletComponent component = new BaseServletComponent() {
                public Servlet getServlet() {
                    return BaseServletActivator.this.getServlet();
                }
            };
            try {
                component.initialize(context, configProperties);
                reg = context.registerService(IServletComponent.class.getName(), component, configProperties);
                state = ServiceLifecycleState.STARTED;
            } catch (AnzoException ae) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error starting base servlet activator", ae);
                throw new AnzoRuntimeException(ae);
            }
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (!bundleStopping && reg != null) {
            reg.unregister();
            reg = null;
        }
    }

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef;
    }
}
