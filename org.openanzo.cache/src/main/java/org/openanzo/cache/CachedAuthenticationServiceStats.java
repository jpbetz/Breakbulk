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
package org.openanzo.cache;

import org.apache.activemq.management.CountStatisticImpl;
import org.openanzo.services.DynamicServiceStats;

/**
 * Authorization stats including stats for cache misses and hits
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class CachedAuthenticationServiceStats extends DynamicServiceStats {
    protected final CountStatisticImpl authenticateUserPasswordCacheHit;

    protected final CountStatisticImpl authenticateUserPasswordCacheMiss;

    protected final CountStatisticImpl authenticateUserPrincipalCacheHit;

    protected final CountStatisticImpl authenticateUserPrincipalCacheMiss;

    protected final CountStatisticImpl getRolesForUserCacheHit;

    protected final CountStatisticImpl getRolesForUserCacheMiss;

    protected final CountStatisticImpl getUserPrincipalCacheHit;

    protected final CountStatisticImpl getUserPrincipalCacheMiss;

    /**
     * Create a new CachedAuthorizationServiceStats
     * 
     * @param methodNames
     */
    public CachedAuthenticationServiceStats(String... methodNames) {
        super(methodNames);
        authenticateUserPasswordCacheHit = new CountStatisticImpl("AuthenticateUserPasswordCacheHit", "Number of calls to authenticateUser method that uses cached results for password lookup.");
        authenticateUserPasswordCacheMiss = new CountStatisticImpl("AuthenticateUserPasswordCacheMiss", "Number of calls to authenticateUser method that failed to use cached results for password lookup.");
        addStatistic(authenticateUserPasswordCacheHit.getName(), authenticateUserPasswordCacheHit);
        addStatistic(authenticateUserPasswordCacheMiss.getName(), authenticateUserPasswordCacheMiss);

        authenticateUserPrincipalCacheHit = new CountStatisticImpl("AuthenticateUserPrincipalCacheHit", "Number of calls to authenticateUser method that uses cached results for Principal lookup.");
        authenticateUserPrincipalCacheMiss = new CountStatisticImpl("AuthenticateUserPrincipalCacheMiss", "Number of calls to authenticateUser method that failed to use cached results for Principal lookup.");
        addStatistic(authenticateUserPrincipalCacheHit.getName(), authenticateUserPrincipalCacheHit);
        addStatistic(authenticateUserPrincipalCacheMiss.getName(), authenticateUserPrincipalCacheMiss);

        getRolesForUserCacheHit = new CountStatisticImpl("GetRolesForUserCacheHit", "Number of calls to getRolesForUser method that uses cached results.");
        getRolesForUserCacheMiss = new CountStatisticImpl("GetRolesForUserCacheMiss", "Number of calls to getRolesForUser method that failed to use cached results.");
        addStatistic(getRolesForUserCacheHit.getName(), getRolesForUserCacheHit);
        addStatistic(getRolesForUserCacheMiss.getName(), getRolesForUserCacheMiss);

        getUserPrincipalCacheHit = new CountStatisticImpl("getUserPrincipalCacheHit", "Number of calls to getUserPrincipal method that uses cached results.");
        getUserPrincipalCacheMiss = new CountStatisticImpl("getUserPrincipalCacheMiss", "Number of calls to getUserPrincipal method that failed to use cached results.");
        addStatistic(getUserPrincipalCacheHit.getName(), getUserPrincipalCacheHit);
        addStatistic(getUserPrincipalCacheMiss.getName(), getUserPrincipalCacheMiss);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        authenticateUserPasswordCacheHit.setEnabled(enabled);
        authenticateUserPasswordCacheMiss.setEnabled(enabled);
        authenticateUserPrincipalCacheHit.setEnabled(enabled);
        authenticateUserPrincipalCacheMiss.setEnabled(enabled);
        getRolesForUserCacheHit.setEnabled(enabled);
        getRolesForUserCacheMiss.setEnabled(enabled);
        getUserPrincipalCacheHit.setEnabled(enabled);
        getUserPrincipalCacheMiss.setEnabled(enabled);
    }

    /**
     * @return the authenticateUserCacheHit
     */
    public CountStatisticImpl getAuthenticateUserPasswordCacheHit() {
        return authenticateUserPasswordCacheHit;
    }

    /**
     * @return the authenticateUserCacheMiss
     */
    public CountStatisticImpl getAuthenticateUserPasswordCacheMiss() {
        return authenticateUserPasswordCacheMiss;
    }

    /**
     * @return the authenticateUserCacheHit
     */
    public CountStatisticImpl getAuthenticateUserPrincipalCacheHit() {
        return authenticateUserPrincipalCacheHit;
    }

    /**
     * @return the authenticateUserCacheMiss
     */
    public CountStatisticImpl getAuthenticateUserPrincipalCacheMiss() {
        return authenticateUserPrincipalCacheMiss;
    }

    /**
     * @return the getRolesForUserCacheHit
     */
    public CountStatisticImpl getGetRolesForUserCacheHit() {
        return getRolesForUserCacheHit;
    }

    /**
     * @return the getRolesForUserCacheMiss
     */
    public CountStatisticImpl getGetRolesForUserCacheMiss() {
        return getRolesForUserCacheMiss;
    }

    /**
     * @return the getUserPrincipalCacheHit
     */
    public CountStatisticImpl getGetUserPrincipalCacheHit() {
        return getUserPrincipalCacheHit;
    }

    /**
     * @return the getUserPrincipalCacheMiss
     */
    public CountStatisticImpl getGetUserPrincipalCacheMiss() {
        return getUserPrincipalCacheMiss;
    }
}
