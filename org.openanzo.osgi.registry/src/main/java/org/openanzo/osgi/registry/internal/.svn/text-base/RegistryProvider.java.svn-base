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
package org.openanzo.osgi.registry.internal;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.client.pool.AnzoClientPool;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.registry.IRegistryProvider;
import org.openanzo.osgi.registry.RegistryDataset;
import org.openanzo.rdf.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class RegistryProvider implements IRegistryProvider {

    private static final Logger                        log                 = LoggerFactory.getLogger(RegistryProvider.class);

    protected static final String                      SERVICE_PID         = "org.openanzo.osgi.RegistryProvider";

    private final AnzoClientPool                       pool;

    private final Set<IDatasourceListener>             datasourceListeners = new HashSet<IDatasourceListener>();

    private final CopyOnWriteArraySet<RegistryDataset> registries          = new CopyOnWriteArraySet<RegistryDataset>();

    private final Lock                                 lock                = new ReentrantLock();

    /**
     * 
     */
    protected RegistryProvider(Dictionary<? extends Object, ? extends Object> configProperties, AnzoClientPool clientPool) {
        this.pool = clientPool;
        pool.registerDatasourceListener(new IDatasourceListener() {
            public void resetStarting() throws AnzoException {
                lock.lock();
                try {
                    for (RegistryDataset registry : registries) {
                        try {
                            registry.resetStarting();
                        } catch (Throwable t) {
                            log.error(LogUtils.LIFECYCLE_MARKER, "Error resetting registry", t);
                        }
                    }
                    for (IDatasourceListener listener : datasourceListeners) {
                        if (listener != null)
                            try {
                                listener.resetStarting();
                            } catch (Throwable t) {
                                log.error(LogUtils.LIFECYCLE_MARKER, "Error resetting registry", t);
                            }
                    }
                } finally {
                    lock.unlock();
                }
            }

            public void reset() throws AnzoException {
                lock.lock();
                try {
                    for (RegistryDataset registry : registries) {
                        try {
                            registry.reset();
                        } catch (Throwable t) {
                            log.error(LogUtils.LIFECYCLE_MARKER, "Error resetting registry", t);
                        }
                    }
                    for (IDatasourceListener listener : datasourceListeners) {
                        if (listener != null)
                            try {
                                listener.reset();
                            } catch (Throwable t) {
                                log.error(LogUtils.LIFECYCLE_MARKER, "Error resetting registry", t);
                            }
                    }
                } finally {
                    lock.unlock();
                }
            }

            public void postReset() throws AnzoException {
                lock.lock();
                try {
                    for (RegistryDataset registry : registries) {
                        try {
                            registry.postReset();
                        } catch (Throwable t) {
                            log.error(LogUtils.LIFECYCLE_MARKER, "Error resetting registry", t);
                        }
                    }
                    for (IDatasourceListener listener : datasourceListeners) {
                        if (listener != null)
                            try {
                                listener.postReset();
                            } catch (Throwable t) {
                                log.error(LogUtils.LIFECYCLE_MARKER, "Error resetting registry", t);
                            }
                    }
                } finally {
                    lock.unlock();
                }
            }

            public void resetFinished() throws AnzoException {
                lock.lock();
                try {
                    for (RegistryDataset registry : registries) {
                        try {
                            registry.resetFinished();
                        } catch (Throwable t) {
                            log.error(LogUtils.LIFECYCLE_MARKER, "Error resetting registry", t);
                        }
                    }
                    for (IDatasourceListener listener : datasourceListeners) {
                        if (listener != null)
                            try {
                                listener.resetFinished();
                            } catch (Throwable t) {
                                log.error(LogUtils.LIFECYCLE_MARKER, "Error resetting registry", t);
                            }
                    }
                } finally {
                    lock.unlock();
                }
            }

        });
    }

    /**
     * Get the dataset for a given registry
     * 
     * @return the dataset for a given registry
     */
    public RegistryDataset openRegistry(URI registryURI, String userDescription) throws AnzoException {
        RegistryDataset registry = new RegistryDataset(this, registryURI, userDescription, pool);
        lock.lock();
        try {
            registries.add(registry);
        } finally {
            lock.unlock();
        }
        return registry;
    }

    protected void close() {
        try {
            lock.lock();
            try {
                RegistryDataset[] regs = registries.toArray(new RegistryDataset[0]);
                for (RegistryDataset registry : regs) {
                    registry.close();
                }
                registries.clear();
            } finally {
                lock.unlock();
            }
        } catch (AnzoException e) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error closing registry datasets", e);
        }
    }

    public void registerDatasourceListener(IDatasourceListener listener) {
        datasourceListeners.add(listener);
    }

    public void unregisterDatasourceListener(IDatasourceListener listener) {
        datasourceListeners.remove(listener);
    }

    /**
     * @return the registries
     */
    public CopyOnWriteArraySet<RegistryDataset> getRegistries() {
        return registries;
    }

}
