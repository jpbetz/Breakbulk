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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.List;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.services.IStatisticsProvider;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract activator for bundles that expose a Java Semantic Service
 * 
 */
public abstract class JavaServiceActivator extends ConfiguredServiceActivator {
    private static final Logger       log = LoggerFactory.getLogger(JavaServiceActivator.class);

    private List<ServiceRegistration> reg = new ArrayList<ServiceRegistration>();

    /**
     * Get the human readable name of the semantic service
     * 
     * @return the human readable name of the semantic service
     */
    abstract public String getName();

    /**
     * Get the Services that this bundle exposes
     * 
     * @param configProperties
     *            configuration properties
     * @return collection of semantic services this bundle exposes
     */
    abstract public Collection<IBundledSemanticService> getBundledServices(Dictionary<? extends Object, ? extends Object> configProperties);

    /**
     * Get the service factories that this bundle exposes
     * 
     * @param configProperties
     *            configuration properties
     * @return the service factories that this bundle exposes
     */
    abstract public Collection<ISemanticServiceFactory> getServiceFactories(Dictionary<? extends Object, ? extends Object> configProperties);

    /**
     * Get the default configuration properties for this activator
     * 
     * @return the default configuration properties for this activator
     */
    abstract public Dictionary<? extends Object, ? extends Object> getDefaultConfigProperties();

    private final ObjectClassDefinition ocd;

    /**
     * New java Service Activator
     */
    public JavaServiceActivator() {
        super();
        ocd = createOCD();
    }

    protected ObjectClassDefinition createOCD() {
        return new GenericObjectClassDef(getServicePid(), getName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled }, null);
    }

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return ocd;
    }

    @Override
    public String[] getDependencies() {
        return new String[0];
    }

    @Override
    public void start() {
        Collection<IBundledSemanticService> bundledServices = getBundledServices(configProperties);
        for (IBundledSemanticService service : bundledServices) {
            log.debug(LogUtils.LIFECYCLE_MARKER, "Registering bundled service: " + service);
            reg.add(context.registerService(new String[] { IBundledSemanticService.class.getName(), IStatisticsProvider.class.getName() }, service, configProperties));
        }

        Collection<ISemanticServiceFactory> serviceFactories = getServiceFactories(configProperties);
        for (ISemanticServiceFactory serviceFactory : serviceFactories) {
            log.debug(LogUtils.LIFECYCLE_MARKER, "Registering serviceFactory: " + serviceFactory);
            reg.add(context.registerService(ISemanticServiceFactory.class.getName(), serviceFactory, configProperties));
        }

    }

    @Override
    public void stop(boolean bundleStopping) {
        if (!bundleStopping && reg != null) {
            for (ServiceRegistration r : reg) {
                r.unregister();
            }
            reg.clear();
        }
    }
}
