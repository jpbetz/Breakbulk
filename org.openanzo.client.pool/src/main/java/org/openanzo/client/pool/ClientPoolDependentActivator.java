/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 18, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client.pool;

import java.util.List;
import java.util.Set;

import org.openanzo.datasource.DatasourceDictionary;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.osgi.ConfiguredServiceActivator;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class that other activators can subclass, where the activator depends on having a client pool
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
abstract public class ClientPoolDependentActivator extends ConfiguredServiceActivator {

    private static final Logger log               = LoggerFactory.getLogger(ClientPoolDependentActivator.class);

    protected AnzoClientPool    clientPool        = null;

    private ServiceTracker      clientPoolTracker = null;

    @Override
    public void configurationPropertiesSet(Set<String> changedProps) throws ConfigurationException {
        String datasourceURI = DatasourceDictionary.getDatasourceURI(configProperties);
        try {
            clientPoolTracker = new NamedClientPoolTracker(context, datasourceURI, new INamedClientPoolRegistrationListener() {

                public void unregisterClientPool(AnzoClientPool clientPool) {
                    lock.lock();
                    try {
                        ClientPoolDependentActivator.this.clientPool = clientPool;
                        stopLocked(false);
                    } finally {
                        lock.unlock();
                    }

                }

                public void registerClientPool(AnzoClientPool clientPool) {
                    lock.lock();
                    try {

                        ClientPoolDependentActivator.this.clientPool = clientPool;
                        if (isInitialized()) {
                            startLocked();
                        }
                    } finally {
                        lock.unlock();
                    }

                }
            });
        } catch (InvalidSyntaxException ise) {
            log.error(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.OSGI.INVALID_SERVICE_SYNTAX, ise.getFilter()), ise);
        }

        clientPoolTracker.open();
    }

    @Override
    public List<String> getOkServices() {
        List<String> list = super.getOkServices();
        if (clientPool != null) {
            list.add(AnzoClientPool.class.getName());
        }
        return list;
    }

    @Override
    public List<String> getWaitingServices() {
        List<String> list = super.getWaitingServices();
        if (clientPool == null) {
            list.add(AnzoClientPool.class.getName());
        }
        return list;
    }

    @Override
    public boolean isInitialized() {
        return super.isInitialized() && clientPool != null;
    }

}
