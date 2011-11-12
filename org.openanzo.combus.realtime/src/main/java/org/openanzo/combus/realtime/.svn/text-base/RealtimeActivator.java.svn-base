/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 3, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus.realtime;

import org.openanzo.cache.ICacheProvider;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.combus.endpoint.ICombusEndpointListener;
import org.openanzo.datasource.ConfiguredWithPrimaryDatasourceActivator;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.CombusAttributes;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class RealtimeActivator extends ConfiguredWithPrimaryDatasourceActivator {
    protected static final Logger                 log                         = LoggerFactory.getLogger(RealtimeActivator.class);

    RealtimeUpdatePublisher                       publisher                   = null;

    NotificationRegistrationService               notificationService         = null;

    CombusNotificationRegistrationServiceListener notificationServiceListener = null;

    ServiceRegistration                           listenerReg                 = null;

    ServiceRegistration                           publisherReg                = null;

    static final String                           SERVICE_PID                 = "org.openanzo.combus.RealtimePublisher";

    GenericObjectClassDef                         classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled, CombusAttributes.Host, CombusAttributes.Port }, null));
    }

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { IAuthenticationService.class.getName(), IJmsProvider.class.getName(), ICacheProvider.class.getName() };
    }

    @Override
    public void start() {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            publisher = new RealtimeUpdatePublisher(configProperties, getDependency(IAuthenticationService.class), primaryDatasource, getDependency(ICacheProvider.class));
            notificationService = new NotificationRegistrationService(publisher);
            CombusNotificationRegistrationServiceListener listener = new CombusNotificationRegistrationServiceListener(getDependency(IAuthenticationService.class), notificationService, null);
            try {
                listener.start();
                listenerReg = context.registerService(ICombusEndpointListener.class.getName(), listener, null);
                publisher.start();
                publisherReg = context.registerService(new String[] { RealtimeUpdatePublisher.class.getName(), ICombusEndpointListener.class.getName() }, publisher, null);
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error starting realtime even publisher", ae);
                throw new AnzoRuntimeException(ae);
            }
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (!bundleStopping && listenerReg != null) {
            listenerReg.unregister();
            listenerReg = null;
        }
        if (!bundleStopping && publisherReg != null) {
            publisherReg.unregister();
            publisherReg = null;
        }
        if (publisher != null) {
            try {
                publisher.stop();
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error stopping realtime even publisher", ae);
            }
        }
    }

}
