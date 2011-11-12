/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 21, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import org.apache.activemq.management.CountStatisticImpl;
import org.openanzo.services.DynamicServiceStats;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ReplicationWithCacheStats extends DynamicServiceStats {
    protected final CountStatisticImpl cacheHit;

    protected final CountStatisticImpl cacheMiss;

    /**
     * Create a new Statistics object for an ReplicationService
     * 
     * @param methodNames
     *            method names
     */
    public ReplicationWithCacheStats(String... methodNames) {
        super(methodNames);
        cacheHit = new CountStatisticImpl("replicateCacheHit", "Number of cache hits in replicate.");
        cacheMiss = new CountStatisticImpl("replicateCacheMiss", "Number of cache misses in replicate.");
        addStatistic(cacheHit.getName(), cacheHit);
        addStatistic(cacheMiss.getName(), cacheMiss);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        cacheHit.setEnabled(enabled);
        cacheMiss.setEnabled(enabled);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(" ");
        buffer.append(super.toString());
        buffer.append(" ");
        buffer.append(cacheHit);
        buffer.append(" ");
        buffer.append(cacheMiss);
        buffer.append(" ");
        return buffer.toString();
    }

    /**
     * @return the replicateUse stats
     */
    public CountStatisticImpl getReplicateCacheHit() {
        return cacheHit;
    }

    /**
     * @return the replicateUse stats
     */
    public CountStatisticImpl getReplicateCacheMiss() {
        return cacheMiss;
    }
}
