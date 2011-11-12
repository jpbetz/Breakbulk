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
package org.openanzo.combus.publisher;

import java.util.List;

import org.openanzo.combus.IJmsProvider;
import org.openanzo.combus.realtime.RealtimeUpdatePublisher;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.CombusAttributes;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Event publisher activator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class EventPublisherActivator extends ConfiguredServiceActivator {
    private static final Logger              log            = LoggerFactory.getLogger(EventPublisherActivator.class);

    private EventPublisher                   eventPublisher = null;

    private ServiceRegistration              reg            = null;

    private OsgiServiceTracker<IJmsProvider> jmsTracker     = null;

    protected IJmsProvider                   jmsProvider    = null;

    static final String                      SERVICE_PID    = "org.openanzo.combus.Publisher";

    GenericObjectClassDef                    classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled, CombusAttributes.Host, CombusAttributes.Port, }, null));
    }

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { RealtimeUpdatePublisher.class.getName() };
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);
        log.info(LogUtils.LIFECYCLE_MARKER, "Starting combus event publisher activator");

        jmsTracker = new OsgiServiceTracker<IJmsProvider>(new IServiceTrackerListener<IJmsProvider>() {
            public void unregisterService(IJmsProvider service) {
                jmsProvider = null;
                stopLocked(false);
            }

            public void registerService(IJmsProvider service) {
                jmsProvider = service;
                lock.lock();
                try {
                    if (state == ServiceLifecycleState.STARTED && eventPublisher != null) {
                        try {
                            eventPublisher.start(jmsProvider);
                        } catch (AnzoException ae) {
                            log.error(LogUtils.LIFECYCLE_MARKER, "Error starting the combus update publisher", ae);
                            throw new AnzoRuntimeException(ae);
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }

            public Class<IJmsProvider> getComponentType() {
                return IJmsProvider.class;
            }
        }, context);
        jmsTracker.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        super.stop(context);
        if (jmsTracker != null) {
            jmsTracker.close();
            jmsTracker = null;
        }
    }

    @Override
    public void start() {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            eventPublisher = new EventPublisher(configProperties, getDependency(RealtimeUpdatePublisher.class));
            reg = context.registerService(IUpdateResultListener.class.getName(), eventPublisher, null);
            if (jmsProvider != null) {
                try {
                    eventPublisher.start(jmsProvider);
                } catch (AnzoException ae) {
                    log.error(LogUtils.LIFECYCLE_MARKER, "Error starting the combus update publisher", ae);
                    throw new AnzoRuntimeException(ae);
                }
            }
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        try {
            if (eventPublisher != null)
                eventPublisher.stop(bundleStopping);
        } catch (AnzoException ae) {
            if (bundleStopping) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error stopping the combus update publisher", ae);
            }
        }
        if (!bundleStopping && reg != null) {
            reg.unregister();
            reg = null;
        }
    }

    @Override
    public List<String> getOptionalOkServices() {
        List<String> list = super.getOkServices();
        if (jmsProvider != null) {
            list.add(IJmsProvider.class.getName());
        }
        return list;
    }

    @Override
    public List<String> getOptionalWaitingServices() {
        List<String> list = super.getWaitingServices();
        if (jmsProvider == null) {
            list.add(IJmsProvider.class.getName());
        }
        return list;
    }
}
