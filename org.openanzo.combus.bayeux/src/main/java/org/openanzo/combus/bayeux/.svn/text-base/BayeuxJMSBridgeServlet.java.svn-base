/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.combus.bayeux;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;

import org.cometd.server.AbstractBayeux;
import org.cometd.server.continuation.ContinuationBayeux;
import org.cometd.server.continuation.ContinuationCometdServlet;

/**
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
class BayeuxJMSBridgeServlet extends ContinuationCometdServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected AbstractBayeux newBayeux() {
        return new EncryptedTokenAuthenticationContinuationBayeux();
    }

    @Override
    public void init() throws ServletException {
        Properties properties = this.getInitProperties();
        getServletContext().setAttribute("initParams", properties);
        super.init();
    }

    private Properties getInitProperties() {
        Properties properties = new Properties();
        Enumeration<?> e = getInitParameterNames();
        String paramName;
        String paramValue;
        while (e.hasMoreElements()) {
            paramName = (String) e.nextElement();
            paramValue = getInitParameter(paramName);
            properties.put(paramName, paramValue);
        }
        return properties;
    }

    @Override
    public void destroy() {
        if (super.getBayeux() instanceof ContinuationBayeux) {
            ((ContinuationBayeux) super.getBayeux()).destroy();
        }
        super.destroy();
    }
}
