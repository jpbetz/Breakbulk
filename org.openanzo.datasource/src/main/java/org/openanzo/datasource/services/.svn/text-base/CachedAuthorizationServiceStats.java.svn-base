/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 29, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import org.apache.activemq.management.CountStatisticImpl;
import org.openanzo.services.DynamicServiceStats;

/**
 * Authorization stats including stats for cache misses and hits
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class CachedAuthorizationServiceStats extends DynamicServiceStats {
    protected final CountStatisticImpl getRolesForGraphCacheHit;

    protected final CountStatisticImpl getRolesForGraphCacheMiss;

    protected final CountStatisticImpl getRolesPermissionCacheHit;

    protected final CountStatisticImpl getRolesPermissionCacheMiss;

    /**
     * Create a new CachedAuthorizationServiceStats
     * 
     * @param methodNames
     *            method names
     */
    public CachedAuthorizationServiceStats(String... methodNames) {
        super(methodNames);

        getRolesPermissionCacheHit = new CountStatisticImpl("getRolesPermissionCacheHit", "Number of calls to getRolesPermission method that uses cached results.");
        getRolesPermissionCacheMiss = new CountStatisticImpl("getRolesPermissionCacheMiss", "Number of calls to getRolesPermission method that failed to use cached results.");
        addStatistic(getRolesPermissionCacheHit.getName(), getRolesPermissionCacheHit);
        addStatistic(getRolesPermissionCacheMiss.getName(), getRolesPermissionCacheMiss);

        getRolesForGraphCacheHit = new CountStatisticImpl("GetUserPermissionCacheHit", "Number of calls to getRolesForGraph method that uses cached results.");
        getRolesForGraphCacheMiss = new CountStatisticImpl("GetUserPermissionCacheMiss", "Number of calls to getRolesForGraph method that failed to use cached results.");
        addStatistic(getRolesForGraphCacheHit.getName(), getRolesForGraphCacheHit);
        addStatistic(getRolesForGraphCacheMiss.getName(), getRolesForGraphCacheMiss);

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        getRolesPermissionCacheHit.setEnabled(enabled);
        getRolesPermissionCacheMiss.setEnabled(enabled);
    }

    /**
     * @return the getUsersForGraphCacheHit
     */
    public CountStatisticImpl getGetRolesForGraphCacheHit() {
        return getRolesForGraphCacheHit;
    }

    /**
     * @return the getUsersForGraphCacheMiss
     */
    public CountStatisticImpl getGetRolesForGraphCacheMiss() {
        return getRolesForGraphCacheMiss;
    }

    /**
     * @return the getRolesPermissionCacheHit
     */
    public CountStatisticImpl getgetRolesPermissionCacheHit() {
        return getRolesPermissionCacheHit;
    }

    /**
     * @return the getRolesPermissionCacheMiss
     */
    public CountStatisticImpl getgetRolesPermissionCacheMiss() {
        return getRolesPermissionCacheMiss;
    }

}
