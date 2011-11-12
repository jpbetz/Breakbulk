/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 17, 2008
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
public class QueryServiceWithCacheStats extends DynamicServiceStats {
    protected CountStatisticImpl cacheHit;

    protected CountStatisticImpl cacheMiss;

    /**
     * Create a new Statistics object for an QueryService
     * 
     * @param methodNames
     *            method names
     */
    public QueryServiceWithCacheStats(String... methodNames) {
        super(methodNames);
        cacheHit = new CountStatisticImpl("cacheHit", "Number of cache hits.");
        addStatistic(cacheHit.getName(), cacheHit);
        cacheMiss = new CountStatisticImpl("cacheMiss", "Number of cache misses.");
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
        return buffer.toString();
    }

    /**
     * @return the cacheHit
     */
    public CountStatisticImpl getCacheHit() {
        return cacheHit;
    }

    /**
     * @return the cacheMiss
     */
    public CountStatisticImpl getCacheMiss() {
        return cacheMiss;
    }
}
