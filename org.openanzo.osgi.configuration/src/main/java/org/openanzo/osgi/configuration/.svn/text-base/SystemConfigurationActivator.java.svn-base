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
package org.openanzo.osgi.configuration;

import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class SystemConfigurationActivator implements BundleActivator {

    private SystemConfigurationConfigPlugin systemConfigPlugin = null;

    public void start(BundleContext context) throws Exception {
        systemConfigPlugin = new SystemConfigurationConfigPlugin(context);
        context.registerService(new String[] { CommandProvider.class.getName() }, new DependentServicesCommand(context), null);
    }

    public void stop(BundleContext context) {
        if (systemConfigPlugin != null) {
            systemConfigPlugin.close();
        }
    }
}
