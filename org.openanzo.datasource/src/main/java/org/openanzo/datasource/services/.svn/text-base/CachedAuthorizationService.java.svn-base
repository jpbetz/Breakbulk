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
package org.openanzo.datasource.services;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.cache.ICache;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IDatasource;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IAuthorizationEventListener;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.Privilege;
import org.openanzo.services.serialization.WriterStringValueSetHandler;
import org.slf4j.MDC;

/**
 * A cached authorization service caches the acls and results from requests, and updates caches based on updates.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CachedAuthorizationService implements IAuthorizationService, IAuthorizationEventListener {
    protected CachedAuthorizationServiceStats     stats               = null;

    /** Service's Name in {@link String} form */
    public static final String                    CACHED_SERVICE_NAME = NAMESPACES.SERVICE_PREFIX + "CachedAuthorizationService";

    /** Service's Name in {@link String} form */
    public static final URI                       CACHED_SERVICE_URI  = Constants.valueFactory.createURI(CACHED_SERVICE_NAME);

    protected final IAuthorizationService         parentService;

    private static String                         CACHED              = "CachedOperation";

    private ICache<URI, Map<Privilege, Set<URI>>> cache;

    /**
     * Create a new CacheAuthorizationService
     * 
     * @param parentService
     *            the parent authorization service
     * @param cacheProvider
     *            cache provider the the authorization service
     */
    public CachedAuthorizationService(IAuthorizationService parentService, ICacheProvider cacheProvider) {
        stats = new CachedAuthorizationServiceStats("getRolesForGraph");
        this.parentService = parentService;
        this.cache = (cacheProvider != null) ? cacheProvider.<URI, Map<Privilege, Set<URI>>> openCache(parentService.getDatasource().getInstanceURI() + "_" + "AuthorizationService", 10000, true) : null;
    }

    public String getName() {
        return parentService.getName() + "Cached";
    }

    public String getDescription() {
        return "Cached Authorization Service for " + parentService.getName();
    }

    public IDatasource getDatasource() {
        return parentService.getDatasource();
    }

    public void start() throws AnzoException {
        parentService.start();
        stats.setEnabled(true);
    }

    public void close() throws AnzoException {
        parentService.close();
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    private ThreadLocal<ClassLoader> oldLoader = new ThreadLocal<ClassLoader>();

    private void entry() {
        oldLoader.set(Thread.currentThread().getContextClassLoader());
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
    }

    private void exit() {
        Thread.currentThread().setContextClassLoader(oldLoader.get());
        oldLoader.remove();
    }

    public Set<URI> getRolesForGraph(IOperationContext context, URI namedGraphUri, Privilege privilage) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        entry();
        try {
            Map<Privilege, Set<URI>> ufg = (cache != null) ? (Map<Privilege, Set<URI>>) cache.get(namedGraphUri) : null;
            Set<URI> roles = null;
            if (ufg == null || !ufg.containsKey(privilage)) {
                if (stats.isEnabled())
                    stats.getGetRolesForGraphCacheMiss().increment();
                roles = parentService.getRolesForGraph(context, namedGraphUri, privilage);
                if (ufg == null) {
                    ufg = new HashMap<Privilege, Set<URI>>();
                }
                ufg.put(privilage, roles);
                if (cache != null)
                    cache.put(namedGraphUri, ufg);
                if (RequestAnalysis.isAnalysisEnabled()) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                }
            } else {
                roles = ufg.get(privilage);
                if (stats.isEnabled())
                    stats.getGetRolesForGraphCacheHit().increment();
                if (RequestAnalysis.isAnalysisEnabled()) {
                    RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                }
            }
            return roles;
        } finally {
            exit();
            if (stats.isEnabled()) {
                stats.use("getRolesForGraph", (System.currentTimeMillis() - start));
            }
        }
    }

    public void getRolesForGraph(IOperationContext context, URI namedGraphUri, Privilege privilage, Writer output, String format) throws AnzoException {
        Set<URI> rfg = getRolesForGraph(context, namedGraphUri, privilage);
        WriterStringValueSetHandler vsh = new WriterStringValueSetHandler(output, format);
        try {
            vsh.start();
            for (URI role : rfg) {
                vsh.handleValue(role.toString());
            }
            vsh.end();
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
        }

    }

    public void handleAuthorizationUpdates(Set<Statement> aclAdditions, Set<Statement> aclRemovals) throws AnzoException {
        entry();
        try {
            for (Statement acl : aclRemovals) {
                URI namedGraphUri = (URI) acl.getSubject();
                URI privilege = acl.getPredicate();
                URI role = (URI) acl.getObject();
                Privilege priv = null;
                if (privilege.equals(NamedGraph.canBeAddedToByProperty)) {
                    priv = Privilege.ADD;
                } else if (privilege.equals(NamedGraph.canBeRemovedFromByProperty)) {
                    priv = Privilege.REMOVE;
                } else if (privilege.equals(NamedGraph.canBeReadByProperty)) {
                    priv = Privilege.READ;
                }
                Map<Privilege, Set<URI>> roleMap = (cache != null) ? (Map<Privilege, Set<URI>>) cache.get(namedGraphUri) : null;
                if (roleMap != null) {
                    if (roleMap.containsKey(priv)) {
                        Set<URI> roles = roleMap.get(priv);
                        //log.debug("Removing role from cache");
                        roles.remove(role);
                        if (cache != null)
                            cache.put(namedGraphUri, roleMap);
                    }
                }
            }
            for (Statement acl : aclAdditions) {
                URI namedGraphUri = (URI) acl.getSubject();
                URI privilege = acl.getPredicate();
                URI role = (URI) acl.getObject();
                Privilege priv = null;
                if (privilege.equals(NamedGraph.canBeAddedToByProperty)) {
                    priv = Privilege.ADD;
                } else if (privilege.equals(NamedGraph.canBeRemovedFromByProperty)) {
                    priv = Privilege.REMOVE;
                } else if (privilege.equals(NamedGraph.canBeReadByProperty)) {
                    priv = Privilege.READ;
                }
                Map<Privilege, Set<URI>> roleMap = (cache != null) ? (Map<Privilege, Set<URI>>) cache.get(namedGraphUri) : null;
                if (roleMap != null) {
                    if (roleMap.containsKey(priv)) {
                        Set<URI> roles = roleMap.get(priv);
                        //  log.debug("Adding role to cache");
                        roles.add(role);
                        if (cache != null)
                            cache.put(namedGraphUri, roleMap);
                    }
                }
            }
        } finally {
            exit();
        }
    }

    public void reset() throws AnzoException {
        parentService.reset();
        if (cache != null)
            cache.clear();
    }

    public void logEntry() {
        parentService.logEntry();
        MDC.put(CACHED, "true");
    }

    public void logExit() {
        parentService.logExit();
        MDC.remove(CACHED);
    }
}
