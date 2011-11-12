/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 3, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet;

import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import javax.servlet.Servlet;

import org.openanzo.security.keystore.ISecretKeystore;
import org.openanzo.services.IAuthenticationService;
import org.ops4j.pax.web.service.WebContainer;

/**
 * IServletComponent allows servlet host to register servlet
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IServletComponent {
    /** META-INF header for pointing to servlet config data */
    public static final String SERVLET_CONFIG = "Servlet-Properties";

    /**
     * Register a servlet
     * 
     * @param webContainer
     *            host of servlets
     * @param authenticationService
     *            the authentication service if needed
     * @param keystore
     *            the keystore if needed
     */
    public void registerServlet(WebContainer webContainer, IAuthenticationService authenticationService, ISecretKeystore keystore);

    /**
     * Unregister servlet with container
     * 
     * @param webContainer
     *            host of servlets
     */
    public void unregisterServlet(WebContainer webContainer);

    /**
     * Get the servlet object for this endpoint
     * 
     * @return the servlet object for this endpoint
     */
    public Servlet getServlet();

    /**
     * Get the path specs for the servlet
     * 
     * @return the path specs for the servlet
     */
    public Collection<PathSpec> getPathSpec();

    /**
     * Get the path specs for the paths that require authentication to accesss.
     * 
     * @return the path specs for the paths that require authentication to accesss.
     */
    public Collection<PathSpec> getProtectedPathSpec();

    /**
     * Get a specialized contextPath for this servlet. If null, the default server context is used.
     * 
     * @return a specialized contextPath for this servlet
     */
    public String getContextPath();

    /**
     * If needed, the docRoot for the servlet's context
     * 
     * @return the docRoot for the servlet's context
     */
    public String getDocRoot();

    /**
     * Return the authentication mode which denotes the authentication mode used for protecting the servlet.
     * 
     * @return the authentication mode which denotes the authentication mode used for protecting the servlet.
     */
    public AuthenticationMode getAuthenticationMode();

    /**
     * 
     * @return The security constraint that denotes the security node for this servlet
     */
    public SecurityConstraint getSecurityConstraint();

    /**
     * Return servlet init param properties
     * 
     * @return servlet init param properties
     */
    public Properties getInitProperties();

    /**
     * Returns page to which the component redirects when accessing a protected resource without valid credentials. This is valid only for some authentication
     * modes such as EncryptedTokenAuthentication.
     * 
     * @return the error page or null if none is defined.
     */
    public String getErrorPage();

    /**
     * Returns page to which the component redirects when invalid credentials are given in a login request. This is valid only for some authentication modes
     * such as EncryptedTokenAuthentication.
     * 
     * @return the login page or null if none is defined.
     */
    public String getLoginPage();

    /**
     * Get the authentication token timeout period.
     * 
     * @return the token timeout in minutes or -1 if unspecified.
     */
    public int getTokenTimeout();

    /**
     * Get the authentication token refresh timeout period. That is, the window of time when we avoid creating a new token to save on bandwidth and encryption
     * operations.
     * 
     * @return the authentication token refresh timeout period in minutes or -1 if unspecified.
     */
    public int getTokenRefreshWindow();

    /**
     * If true, then the authentication token will not be refreshed by the system. So the servlet must add the cookie to refresh the token when needed. This is
     * useful when there are certain requests that should not reset the authentication token timeout. If false, the authenticator automatically adds refreshes
     * the cookie as needed. False is the most common mode of operation.
     * 
     * This is only relevant for the EncryptedTokenAuthentication mode.
     * 
     * @return whether custom token refresh mode is enabled or <code>null</code> if unspecified.
     */
    public Boolean isCustomTokenRefreshEnabled();

    /**
     * @return Array of instanceUris for the webcontainers to which this servlet is to be registered, if null, registered on all containers
     */
    public Set<String> getWebcontainerInstanceURIs();

}
