/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 23, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.cache;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.OSGI;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * A cached authorization service caches the acls and results from requests, and updates caches based on updates.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CachedAuthenticationService implements org.openanzo.services.IAuthenticationService, EventHandler {

    /** EventAdmin topic for user credentials changing */
    public static final String                     USER_CREDENTIALS_CHANGED_TOPIC = "org/openanzo/cache/userCredentials";

    /** EventAdmin topic for user roles changing */
    public static final String                     USER_ROLES_CHANGED_TOPIC       = "org/openanzo/cache/userRoles";

    private final CachedAuthenticationServiceStats stats;

    private ICache<String, Map<String, Boolean>>   passwordCache;

    private ICache<String, AnzoPrincipal>          principalCache;

    private final IAuthenticationService           parentService;

    private final ReentrantLock                    lock                           = new ReentrantLock();

    /**
     * Create a new CacheAuthenticationService wrapping another authentication service
     * 
     * @param parentService
     *            service to wrap
     * @param provider
     *            cache provider
     */
    public CachedAuthenticationService(IAuthenticationService parentService, ICacheProvider provider) {
        this.parentService = parentService;
        this.stats = new CachedAuthenticationServiceStats();
        this.stats.setEnabled(true);
        if (provider != null) {
            passwordCache = provider.<String, Map<String, Boolean>> openCache("AuthenticationPasswordCache", 20000, true);
            principalCache = provider.<String, AnzoPrincipal> openCache("AuthenticationPrincipalCache", 20000, true);
        }
    }

    public org.openanzo.services.DynamicServiceStats getStatistics() {
        return stats;
    }

    public String getName() {
        return "cached_" + parentService.getName();
    }

    public String getDescription() {
        return "Cached Authentication Service";
    }

    public AnzoPrincipal authenticateUser(IOperationContext context, String userName, String password) throws AnzoException {
        AnzoPrincipal result = null;
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        lock.lock();
        try {

            Boolean ok = null;
            Map<String, Boolean> userMap = passwordCache.get(userName);
            if (userMap != null) {
                ok = userMap.get(password);
            }
            if (ok != null) {
                if (ok) {
                    if (stats.isEnabled())
                        stats.getAuthenticateUserPasswordCacheHit().increment();
                    result = principalCache.get(userName);
                } else {
                    throw new AnzoException(ExceptionConstants.SERVER.UNKNOWN_USER_ERROR, userName);
                }
            } else {
                if (stats.isEnabled())
                    stats.getAuthenticateUserPasswordCacheMiss().increment();
            }
            if (result == null) {
                if (stats.isEnabled())
                    stats.getAuthenticateUserPrincipalCacheMiss().increment();
                try {
                    userMap = passwordCache.get(userName);
                    if (userMap == null) {
                        userMap = new HashMap<String, Boolean>();
                        passwordCache.put(userName, userMap);
                    }

                    result = parentService.authenticateUser(context, userName, password);
                    if (result != null) {
                        userMap.put(password, Boolean.TRUE);
                        principalCache.put(userName, result);
                        principalCache.put(result.getUserURI().toString(), result);
                    } else {
                        userMap.put(password, Boolean.FALSE);
                    }
                } catch (AnzoException ae) {
                    userMap = passwordCache.get(userName);
                    if (userMap == null) {
                        userMap = new HashMap<String, Boolean>();
                        passwordCache.put(userName, userMap);
                    }
                    userMap.put(password, Boolean.FALSE);
                    throw ae;
                }
            } else {
                if (stats.isEnabled())
                    stats.getAuthenticateUserPrincipalCacheHit().increment();
            }
            return result;
        } finally {
            lock.unlock();
            if (stats.isEnabled()) {
                stats.use("authenticateUser", (System.currentTimeMillis() - start));
            }
        }
    }

    public void authenticateUser(IOperationContext context, String userName, String password, Writer output, String format) throws AnzoException {
        AnzoPrincipal result = authenticateUser(context, userName, password);
        CommonSerializationUtils.writeAnzoPrincipal(result, output, format);
    }

    public AnzoPrincipal getUserPrincipal(IOperationContext context, String userName) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            AnzoPrincipal result = principalCache.get(userName);
            if (result == null) {
                if (stats.isEnabled())
                    stats.getGetUserPrincipalCacheMiss().increment();
                result = parentService.getUserPrincipal(context, userName);
                if (result != null) {
                    principalCache.put(userName, result);
                    principalCache.put(result.getUserURI().toString(), result);
                }
            } else {
                if (stats.isEnabled())
                    stats.getGetUserPrincipalCacheHit().increment();
            }
            return result;
        } finally {
            if (stats.isEnabled()) {
                stats.use("getUserPrincipal", (System.currentTimeMillis() - start));
            }
        }
    }

    public void getUserPrincipal(IOperationContext context, String userName, Writer output, String format) throws AnzoException {
        AnzoPrincipal result = getUserPrincipal(context, userName);
        if (result != null) {
            CommonSerializationUtils.writeAnzoPrincipal(result, output, format);
        }
    }

    public void handleEvent(Event event) {
        if (event.getTopic().equals(USER_CREDENTIALS_CHANGED_TOPIC)) {
            String username = (String) event.getProperty(SerializationConstants.userId);
            passwordCache.remove(username);
        } else if (event.getTopic().equals(USER_ROLES_CHANGED_TOPIC)) {
            String[] username = (String[]) event.getProperty(SerializationConstants.userId);
            String role = (String) event.getProperty(SerializationConstants.role);
            boolean added = (Boolean) event.getProperty(SerializationConstants.operation);
            URI roleURI = Constants.valueFactory.createURI(role);
            for (String name : username) {
                URI userURI = Constants.valueFactory.createURI(name);
                AnzoPrincipal principal = principalCache.get(userURI.toString());
                if (principal != null) {
                    if (added) {
                        principal.getRoles().add(roleURI);
                    } else {
                        principal.getRoles().remove(roleURI);
                    }
                }
            }
        } else if (event.getTopic().equals(OSGI.RESET_TOPIC)) {
            principalCache.clear();
            passwordCache.clear();
        }
    }
}
