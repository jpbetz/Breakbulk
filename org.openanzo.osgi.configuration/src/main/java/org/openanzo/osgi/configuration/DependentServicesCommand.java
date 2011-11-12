/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 9, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi.configuration;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.openanzo.osgi.IStatusProvider;
import org.openanzo.osgi.ServiceLifecycleState;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

/**
 * OSGI console command that shows status of OpenAnzo service activators
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DependentServicesCommand implements CommandProvider {
    //private static final Logger log     = LoggerFactory.getLogger(DependentServicesCommand.class);

    private final BundleContext context;

    protected DependentServicesCommand(final BundleContext context) {
        this.context = context;
    }

    public String getHelp() {
        return "---Status of OpenAnzo Services---\n\tds - Get the status of ServiceActivators\n";
    }

    /**
     * Get the status of openanzo service activators
     * 
     * @param ci
     */
    public void _ds(CommandInterpreter ci) { // NO_UCD
        try {
            String argument = ci.nextArgument();
            ServiceReference refs[] = context.getAllServiceReferences(IStatusProvider.class.getName(), null);
            if (argument == null) {
                boolean allOk = true;
                if (refs != null) {
                    for (ServiceReference ref : refs) {
                        IStatusProvider service = (IStatusProvider) context.getService(ref);
                        if (service.getState() != ServiceLifecycleState.NOT_ENABLED && service.getState() != ServiceLifecycleState.STARTED) {
                            allOk = false;
                        }
                    }
                }
                if (allOk) {
                    ci.println("All OpenAnzo services started.");
                } else {
                    ci.println("Not all OpenAnzo services started. Use  \"ds waiting\"  to see what services aren't started.");
                }
            } else if (argument.equals("all")) {
                if (refs != null) {
                    for (ServiceReference ref : refs) {
                        IStatusProvider service = (IStatusProvider) context.getService(ref);
                        ci.print(service.getCurrentStatus(false));
                    }
                }
            } else if (argument.equals("waiting")) {
                if (refs != null) {
                    for (ServiceReference ref : refs) {
                        IStatusProvider service = (IStatusProvider) context.getService(ref);
                        if (service.getState() != ServiceLifecycleState.NOT_ENABLED && service.getState() != ServiceLifecycleState.STARTED) {
                            ci.print(service.getCurrentStatus(false));
                        }
                    }
                }
            } else if (argument.equals("ready")) {
                if (refs != null) {
                    for (ServiceReference ref : refs) {
                        IStatusProvider service = (IStatusProvider) context.getService(ref);
                        if (service.getState() == ServiceLifecycleState.NOT_ENABLED || service.getState() == ServiceLifecycleState.STARTED) {
                            ci.print(service.getCurrentStatus(false));
                        }
                    }
                }
            }
        } catch (InvalidSyntaxException ise) {
            ci.printStackTrace(ise);
        }
    }
}
