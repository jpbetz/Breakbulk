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
package org.openanzo.combus.endpoint.internal;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.openanzo.analysis.RequestRecorder;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.combus.endpoint.CombusEndpointDictionary;
import org.openanzo.combus.endpoint.ICombusEndpointListener;
import org.openanzo.combus.endpoint.attributes.CombusEndpointAttributes;
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
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for combus endpoints
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CombusEndpointActivator extends ConfiguredServiceActivator {
    protected static final Logger                       log                     = LoggerFactory.getLogger(CombusEndpointActivator.class);

    private OsgiServiceTracker<ICombusEndpointListener> endpointListenerTracker = null;

    private CombusEndpoint                              combusEndoint           = null;

    private ServiceRegistration                         serviceRegistration     = null;

    static final String                                 SERVICE_PID             = "org.openanzo.combus.Endpoint";

    GenericObjectClassDef                               classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled, CombusAttributes.Host, CombusAttributes.Port }, new AttributeDefinition[] { CombusEndpointAttributes.RecorderEnabled }));
    }

    private RequestRecorder recorder = null;

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { IJmsProvider.class.getName() };
    }

    @Override
    public void start() {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            try {
                setupRecorder();

                combusEndoint = new CombusEndpoint(getDependency(IJmsProvider.class), configProperties, recorder);
                combusEndoint.start();
                serviceRegistration = context.registerService(CombusEndpoint.class.getName(), combusEndoint, null);

                endpointListenerTracker = new OsgiServiceTracker<ICombusEndpointListener>(new IServiceTrackerListener<ICombusEndpointListener>() {
                    public void unregisterService(ICombusEndpointListener service) {
                        combusEndoint.unregisterListener(service);
                    }

                    public void registerService(ICombusEndpointListener service) {
                        combusEndoint.registerListener(service);
                    }

                    public Class<ICombusEndpointListener> getComponentType() {
                        return ICombusEndpointListener.class;
                    }
                }, context);
                endpointListenerTracker.open();
            } catch (AnzoException ae) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error starting CombusEndpoint Activator", ae);
                throw new AnzoRuntimeException(ae);
            }
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    private void setupRecorder() {
        Boolean recorderEnabled = CombusEndpointDictionary.getRecorderEnabled(configProperties);
        String recorderLocation = CombusEndpointDictionary.getRecorderOutput(configProperties);
        if (recorderLocation == null) {
            log.error("Cannot initialize combus recorder since location has not been configured");
            if (recorder != null) {
                recorder.close();
                recorder = null;
            }
            return;
        }
        String excludedQueues = CombusEndpointDictionary.getRecorderExcludedQueues(configProperties);
        Set<String> excludedQueueNames = null;
        if (excludedQueues != null) {
            excludedQueueNames = new HashSet<String>();
            StringTokenizer st = new StringTokenizer(excludedQueues, " ");
            while (st.hasMoreTokens()) {
                excludedQueueNames.add(st.nextToken());
            }
        }
        if (recorderEnabled != null && recorderEnabled) {
            recorder = new RequestRecorder(recorderLocation, excludedQueueNames);
            if (combusEndoint != null)
                combusEndoint.setRecorder(recorder);
        } else if (recorder != null) {
            recorder.close();
            recorder = null;
        }
    }

    @Override
    public void restarted(Set<String> changedProps) {
        if (changedProps.contains(CombusEndpointDictionary.KEY_RECORDER_ENABLED) || changedProps.contains(CombusEndpointDictionary.KEY_RECORDER_OUTPUT)) {
            setupRecorder();
        }
        super.restarted(changedProps);
    }

    @Override
    public void stop(boolean bundleStopping) {
        try {
            if (combusEndoint != null)
                combusEndoint.stop();
        } catch (AnzoException ae) {
            log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error stopping Combus Endpoint activator", ae);
        }
        if (endpointListenerTracker != null) {
            endpointListenerTracker.close();
        }
        if (!bundleStopping && serviceRegistration != null) {
            serviceRegistration.unregister();
            serviceRegistration = null;
        }
        if (recorder != null) {
            recorder.close();
        }
    }
}
