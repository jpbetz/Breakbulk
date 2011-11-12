/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.execution;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.IStatisticsProvider;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for the SemanticService
 * 
 */
public class SemanticServiceActivator extends ConfiguredServiceActivator {
    private static final Logger                            log                    = LoggerFactory.getLogger(SemanticServiceActivator.class);

    ServiceRegistration                                    reg                    = null;

    SemanticServiceExecutionService                        executionService       = null;

    protected OsgiServiceTracker<ISemanticServiceExecutor> serviceExecutorTracker = null;

    private static final String                            SERVICE_PID            = "org.openanzo.execution.SemanticExecutionService";

    GenericObjectClassDef                                  classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled }, null));
    }

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[0];
    }

    @Override
    public void start() {
        executionService = new SemanticServiceExecutionService();
        log.debug(LogUtils.LIFECYCLE_MARKER, "Registering tracker for executors...");
        serviceExecutorTracker = new OsgiServiceTracker<ISemanticServiceExecutor>(new IServiceTrackerListener<ISemanticServiceExecutor>() {
            public Class<ISemanticServiceExecutor> getComponentType() {
                return ISemanticServiceExecutor.class;
            }

            public void unregisterService(ISemanticServiceExecutor serviceExecutor) {
                executionService.unregisterServiceExecutor(serviceExecutor.getServiceTypeUri());
            }

            public void registerService(ISemanticServiceExecutor serviceExecutor) {
                executionService.registerServiceExecutor(serviceExecutor.getServiceTypeUri(), serviceExecutor);
            }

        }, context);
        serviceExecutorTracker.open();
        log.debug(LogUtils.LIFECYCLE_MARKER, "Registring SemanticExecutionService");
        reg = context.registerService(new String[] { IExecutionService.class.getName(), IStatisticsProvider.class.getName() }, executionService, configProperties);
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (serviceExecutorTracker != null) {
            serviceExecutorTracker.close();
        }
        if (!bundleStopping && reg != null) {
            reg.unregister();
            reg = null;
        }
    }
}
