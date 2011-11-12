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
package org.openanzo.security.keystore.internal;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.security.keystore.ISecretKeystore;
import org.openanzo.security.keystore.SecretKeyStore;
import org.openanzo.security.keystore.attributes.KeyStoreAttributes;
import org.openanzo.services.ServicesDictionary;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator for the secret keystore
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class SecretKeystoreActivator extends ConfiguredServiceActivator {
    private static final Logger         log         = LoggerFactory.getLogger(SecretKeystoreActivator.class);

    private ISecretKeystore             encoder;

    private ServiceRegistration         reg;

    static final String                 SERVICE_PID = "org.openanzo.security.KeyStore";

    GenericObjectClassDef       classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled, KeyStoreAttributes.Algorithm, KeyStoreAttributes.KeyFileLocation, KeyStoreAttributes.KeyPassword }, new AttributeDefinition[] { KeyStoreAttributes.KeystoreType }));
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
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            encoder = new SecretKeyStore(configProperties, context.getDataFile(""));
            try {
                encoder.start();
            } catch (AnzoException ae) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error starting secret key store", ae);
                throw new AnzoRuntimeException(ae);
            }
            reg = context.registerService(ISecretKeystore.class.getName(), encoder, null);
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }

    }

    @Override
    public void stop(boolean bundleStopping) {
        try {
            if (encoder != null)
                encoder.stop();
            encoder = null;
        } catch (Exception e) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error stopping the Secret Key Encoder", e);
        }
        if (!bundleStopping && reg != null) {
            reg.unregister();
            reg = null;
        }
    }
}
