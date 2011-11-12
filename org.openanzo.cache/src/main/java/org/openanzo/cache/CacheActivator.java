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
package org.openanzo.cache;

import java.util.Properties;

import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CacheActivator extends ConfiguredServiceActivator {
    //private static final Logger   log         = LoggerFactory.getLogger(CacheActivator.class);

    static final String           SERVICE_PID = "org.openanzo.cache.CacheProvider";

    private ICacheProvider        provider    = null;

    private ServiceRegistration   serviceReg  = null;

    GenericObjectClassDef       classDef;

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
        System.setProperty("ehcache.disk.store.dir", context.getDataFile("cache").getAbsolutePath());
        provider = new AnzoCacheFactory();// new EHCacheProvider(context, configProperties);//new AnzoCacheFactory();
        serviceReg = context.registerService(ICacheProvider.class.getName(), provider, null);
        String[] topics = new String[] { "system/memory" };
        Properties props = new Properties();
        props.put(EventConstants.EVENT_TOPIC, topics);
        context.registerService(new String[] { EventHandler.class.getName() }, new EventHandler() {
            long lastCalled = 0;

            public void handleEvent(Event event) {
                if (System.currentTimeMillis() - lastCalled > 30000) {
                    lastCalled = System.currentTimeMillis();
                    provider.prune();
                    lastCalled = System.currentTimeMillis();
                }
            }
        }, props);

    }

    @Override
    public void stop(boolean bundleStopping) {
        if (provider != null) {
            provider.close();
            provider = null;
        }
        if (!bundleStopping && serviceReg != null) {
            serviceReg.unregister();
            serviceReg = null;
        }
    }

}
