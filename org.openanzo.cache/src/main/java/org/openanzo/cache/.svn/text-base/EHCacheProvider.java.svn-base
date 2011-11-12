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

import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Status;
import net.sf.ehcache.management.ManagementService;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jmx.IJMXServiceEndpoint;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class EHCacheProvider implements ICacheProvider, IJMXServiceEndpoint {
    private static final Logger log  = LoggerFactory.getLogger(EHCacheProvider.class);

    Lock                        lock = new ReentrantLock();

    CacheManager                manager;

    /**
     * 
     */
    protected EHCacheProvider(BundleContext context, Dictionary<? extends Object, ? extends Object> configProperties) {
        String configFile = (String) configProperties.get("org.openanzo.cache.configFile");
        URL configUrl = context.getBundle().getEntry(configFile);
        if (configUrl != null) {
            try {
                manager = CacheManager.create(configUrl.openStream());
            } catch (IOException ioe) {
                log.error(LogUtils.INTERNAL_MARKER, "Error creating cache manager", ioe);
                throw new AnzoRuntimeException(ExceptionConstants.IO.READ_ERROR, ioe);
            }
        } else {
            manager = CacheManager.create();
        }

        Properties props = new Properties();
        for (Enumeration<? extends Object> enumeration = configProperties.keys(); enumeration.hasMoreElements();) {
            String key = (String) enumeration.nextElement();
            props.put(key, configProperties.get(key));
        }
        context.registerService(IJMXServiceEndpoint.class.getName(), this, null);
    }

    static final String parseName(String cacheName) {
        String result = cacheName.replace(':', '_').replace('/', '_').replace('#', '_').replace('.', '_').replace('=', '_');
        return result;
    }

    public <K, V> ICache<K, V> openCache(String cacheName) {
        lock.lock();
        try {
            cacheName = parseName(cacheName);
            Cache cache = manager.getCache(cacheName);
            if (cache == null) {
                manager.addCache(cacheName);
                cache = manager.getCache(cacheName);
            }
            return new EHCache<K, V>(cache);
        } finally {
            lock.unlock();
        }
    }

    public <K, V> ICache<K, V> openCache(String cacheName, int maxElements, boolean overflowToDisk) {
        lock.lock();
        try {
            cacheName = parseName(cacheName);
            Cache cache = manager.getCache(cacheName);
            if (cache == null) {
                //cache = new Cache(cacheName, maxElements, MemoryStoreEvictionPolicy.LRU, overflowToDisk, System.getProperty("ehcache.disk.store.dir"), true, 360, 180, true, 360, null, null, maxElements * 2);
                cache = new Cache(cacheName, maxElements, MemoryStoreEvictionPolicy.LRU, false, System.getProperty("ehcache.disk.store.dir"), false, 0, 0, false, 0, null);
                manager.addCache(cache);
                cache = manager.getCache(cacheName);
            }
            return new EHCache<K, V>(cache);
        } finally {
            lock.unlock();
        }

    }

    public void close() {
        lock.lock();
        try {
            if (manager.getStatus() == Status.STATUS_ALIVE) {
                for (String cache : manager.getCacheNames()) {
                    manager.getCache(cache).flush();
                }
                manager.shutdown();
            }
        } finally {
            lock.unlock();
        }
    }

    public void prune() {
    }

    public void registerWithJMX(MBeanServer mbeanServer, ObjectName parentObjectName) throws AnzoException {
        ManagementService.registerMBeans(manager, mbeanServer, true, true, true, true);
    }

}
