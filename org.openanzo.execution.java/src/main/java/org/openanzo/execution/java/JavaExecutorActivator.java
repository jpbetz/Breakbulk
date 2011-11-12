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
package org.openanzo.execution.java;

import java.util.Dictionary;
import java.util.Hashtable;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.execution.BaseExecutorActivator;
import org.openanzo.execution.BaseServiceExecutor;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for the JavaExector
 * 
 * 
 */
public class JavaExecutorActivator extends BaseExecutorActivator {

    private static final Logger                         log                   = LoggerFactory.getLogger(JavaExecutorActivator.class);

    /** Service PID for the JavaExecutor */
    public static final String                          SERVICE_PID           = "org.openanzo.execution.java.JavaServiceExecutor";

    private OsgiServiceTracker<ISemanticServiceFactory> serviceFactoryTracker = null;

    private OsgiServiceTracker<IBundledSemanticService> serviceTracker        = null;

    GenericObjectClassDef                               classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled }, null));
    }

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public void start() {
        super.start();

        serviceFactoryTracker = new OsgiServiceTracker<ISemanticServiceFactory>(new IServiceTrackerListener<ISemanticServiceFactory>() {

            public Class<ISemanticServiceFactory> getComponentType() {
                return ISemanticServiceFactory.class;
            }

            public void unregisterService(ISemanticServiceFactory serviceFactory) {
                JavaServiceExecutor exec = (JavaServiceExecutor) executor;
                exec.unregisterServiceFactory(serviceFactory.getClass().getName());
            }

            public void registerService(ISemanticServiceFactory serviceFactory) {
                try {
                    JavaServiceExecutor exec = (JavaServiceExecutor) executor;
                    exec.registerServiceFactory(serviceFactory.getClass().getName(), serviceFactory);
                    //                    if (services != null) {
                    //                        for (JavaSemanticService service : services) {
                    //                            context.registerService(IStatisticsProvider.class.getName(), service, null);
                    //                        }
                    //                    }
                } catch (AnzoException e) {
                    log.error(LogUtils.LIFECYCLE_MARKER, "Error registering java execution service factory:" + serviceFactory.getClass().getName(), e);
                }
            }

        }, context);
        serviceFactoryTracker.open();

        serviceTracker = new OsgiServiceTracker<IBundledSemanticService>(new IServiceTrackerListener<IBundledSemanticService>() {

            public Class<IBundledSemanticService> getComponentType() {
                return IBundledSemanticService.class;
            }

            public void unregisterService(IBundledSemanticService service) {
                JavaServiceExecutor exec = (JavaServiceExecutor) executor;
                exec.unregisterService(service);
            }

            public void registerService(final IBundledSemanticService service) {
                Thread t1 = new Thread() {
                    @Override
                    public void run() {
                        try {
                            JavaServiceExecutor exec = (JavaServiceExecutor) executor;
                            registry.beginUpdatingRegistry();
                            exec.registerService(service, registry);
                            registry.commitRegistry();
                        } catch (AnzoException e) {
                            log.error(LogUtils.LIFECYCLE_MARKER, "Error registering java bundled execution service:" + service.getName(), e);
                        }
                    }
                };
                t1.start();
            }

        }, context);
        serviceTracker.open();
    }

    @Override
    public void stop(boolean bundleStopping) {
        super.stop(bundleStopping);
        if (serviceFactoryTracker != null) {
            serviceFactoryTracker.close();
            serviceFactoryTracker = null;
        }
        if (serviceTracker != null) {
            serviceTracker.close();
            serviceTracker = null;
        }
    }

    @Override
    public Dictionary<? extends Object, ? extends Object> getDefaultConfigProperties() {
        return new Hashtable<Object, Object>();
    }

    @Override
    public BaseServiceExecutor getExecutor(Dictionary<? extends Object, ? extends Object> configProperties) {
        return new JavaServiceExecutor();
    }
}
