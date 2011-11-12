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
package org.openanzo.servlet.control;

import java.util.Collection;

import javax.servlet.Servlet;

import org.openanzo.servlet.BaseServletActivator;
import org.osgi.service.metatype.AttributeDefinition;

/**
 * Activator for regression control servlet
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class Activator extends BaseServletActivator {
    ControlServlet      servlet     = null;

    static final String SERVICE_PID = "org.openanzo.servlet.Control";

    /**
     * @return the sERVICE_PID
     */
    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String getName() {
        return getBundleName();
    }

    @Override
    public Collection<AttributeDefinition> getAdditionalOptional() {
        return null;
    }

    @Override
    public Collection<AttributeDefinition> getAdditionalRequired() {
        return null;
    }

    @Override
    public Servlet getServlet() {
        if (servlet == null) {
            servlet = new ControlServlet();
        }
        return servlet;
    }

}
