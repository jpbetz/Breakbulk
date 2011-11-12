/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 7, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.security.B64Code;
import org.eclipse.jetty.http.security.Constraint;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.StringUtil;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.services.AnzoPrincipal;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic HTTP auth authenticator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BasicAuthenticator extends BasicContext {
    private static final Logger                                  log               = LoggerFactory.getLogger(BasicAuthenticator.class);

    IAuthenticatorRealm                                          realm;

    org.eclipse.jetty.security.authentication.BasicAuthenticator basicAuth;

    private Collection<PathSpec>                                 protectedPathSpec = new ArrayList<PathSpec>();

    //private Collection<PathSpec>                  pathSpec          = new ArrayList<PathSpec>();

    //private BundleContext                         bundleContext     = null;

    /**
     * Create basic authenticator
     * 
     * @param bundleContext
     *            bundle context
     * @param securityConstraint
     *            security Constraint
     * @param realm
     *            server authentication realm
     * @param docRoot
     *            docroot for servlet
     * @param pathSpec
     *            unprotected paths
     * @param protectedPathSpec
     *            protected paths
     * @param retrieveDir
     *            return directory resources
     */
    public BasicAuthenticator(BundleContext bundleContext, SecurityConstraint securityConstraint, IAuthenticatorRealm realm, String docRoot, Collection<PathSpec> pathSpec, Collection<PathSpec> protectedPathSpec, boolean retrieveDir) {
        super(bundleContext, securityConstraint, docRoot, retrieveDir);
        this.realm = realm;
        basicAuth = new org.eclipse.jetty.security.authentication.BasicAuthenticator();
        //this.pathSpec = pathSpec;
        this.protectedPathSpec = protectedPathSpec;
    }

    /**
     * Create basic authenticator
     * 
     * @param bundleContext
     *            bundle context
     * @param securityConstraint
     *            security Constraint
     * @param realm
     *            server authentication realm
     * @param docRoot
     *            docroot for servlet
     * @param pathSpec
     *            unprotected paths
     * @param protectedPathSpec
     *            protected paths
     */
    public BasicAuthenticator(BundleContext bundleContext, SecurityConstraint securityConstraint, IAuthenticatorRealm realm, String docRoot, Collection<PathSpec> pathSpec, Collection<PathSpec> protectedPathSpec) {
        this(bundleContext, securityConstraint, realm, docRoot, pathSpec, protectedPathSpec, false);
    }

    @Override
    public boolean handleSecurity(HttpServletRequest servletRequest, HttpServletResponse response) throws IOException {
        Request request = Request.getRequest(servletRequest);
        String uri = request.getServletPath();
        boolean protectedPath = false;
        for (PathSpec spec : protectedPathSpec) {
            if (spec.matches(uri)) {
                protectedPath = true;
                break;
            }
        }
        if (protectedPath) {
            Principal principal = authenticate(realm, null, request, response);
            return principal != null;
        } else {
            return true;
        }
    }

    //Code derived from org.eclipse.jetty.security.BasicAuthenticator.java
    // ========================================================================
    // Copyright 2002-2005 Mort Bay Consulting Pty. Ltd.
    // ------------------------------------------------------------------------
    // Licensed under the Apache License, Version 2.0 (the "License");
    // you may not use this file except in compliance with the License.
    // You may obtain a copy of the License at 
    // http://www.apache.org/licenses/LICENSE-2.0
    // Unless required by applicable law or agreed to in writing, software
    // distributed under the License is distributed on an "AS IS" BASIS,
    // WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    // See the License for the specific language governing permissions and
    // limitations under the License.
    // ========================================================================
    /* ------------------------------------------------------------ */
    /**
     * Authenticate user
     * 
     * @param realm
     *            server authentication real
     * @param pathInContext
     *            path of request
     * @param request
     *            request object
     * @param response
     *            response object
     * @return UserPrinciple if authenticated or null if not. If Authentication fails, then the authenticator may have committed the response as an auth
     *         challenge or redirect.
     * @exception IOException
     */
    public Principal authenticate(IAuthenticatorRealm realm, String pathInContext, Request request, HttpServletResponse response) throws IOException {

        // Get the user if we can
        AnzoPrincipal user = null;
        String credentials = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (credentials != null) {
            try {
                if (log.isDebugEnabled())
                    log.debug(LogUtils.SECURITY_MARKER, "Credentials: " + credentials);
                credentials = credentials.substring(credentials.indexOf(' ') + 1);
                credentials = B64Code.decode(credentials, StringUtil.__ISO_8859_1);
                int i = credentials.indexOf(':');
                String username = credentials.substring(0, i);
                String password = credentials.substring(i + 1);
                user = realm.authenticate(username, password, request);

                if (user == null) {
                    log.info(LogUtils.SECURITY_MARKER, "AUTH FAILURE: user {}", StringUtil.printable(username));
                } else {

                    request.setAuthentication(new BasicUserAuthorization(user, Constraint.__BASIC_AUTH));
                }
            } catch (Exception e) {
                log.info(LogUtils.SECURITY_MARKER, "AUTH FAILURE: " + e.toString(), e);
            }
        }

        // Challenge if we have no user
        if (user == null && response != null)
            sendChallenge(realm, response);

        return user;
    }

    void sendChallenge(IAuthenticatorRealm realm, HttpServletResponse response) throws IOException {
        response.setHeader(HttpHeaders.WWW_AUTHENTICATE, "basic realm=\"anzoRealm\"");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
