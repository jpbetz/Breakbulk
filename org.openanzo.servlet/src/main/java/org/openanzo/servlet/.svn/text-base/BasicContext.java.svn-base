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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.URIUtil;
import org.openanzo.exceptions.LogUtils;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic http context for serving data with no authentication
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BasicContext implements HttpContext {
    private static final Logger        log           = LoggerFactory.getLogger(BasicContext.class);

    String                             docRoot       = null;

    /** Bundle prefix */
    public static final String         BUNDLE_PREFIX = "bundle://";

    /**
     * Bundle context
     */
    BundleContext                      bundleContext = null;

    /** Security Constraint */
    protected final SecurityConstraint securityConstraint;

    protected final boolean            retrieveDirResource;

    /**
     * Create new basic context
     * 
     * @param bundleContext
     *            bundle context
     * @param securityConstraint
     *            Security Constraint
     * @param docRoot
     *            docroot for servlet
     */

    public BasicContext(BundleContext bundleContext, SecurityConstraint securityConstraint, String docRoot) {
        this(bundleContext, securityConstraint, docRoot, false);
    }

    /**
     * Create new basic context
     * 
     * @param bundleContext
     *            bundle context
     * @param securityConstraint
     *            Security Constraint
     * @param docRoot
     *            docroot for servlet
     * @param retrieveDirResource
     *            return resources that are directories instead of returning null
     */

    public BasicContext(BundleContext bundleContext, SecurityConstraint securityConstraint, String docRoot, boolean retrieveDirResource) {
        this.docRoot = docRoot;
        this.bundleContext = bundleContext;
        this.securityConstraint = securityConstraint;
        this.retrieveDirResource = retrieveDirResource;
    }

    public URL getResource(String url) {
        if (docRoot != null) {
            try {
                if (url.startsWith(BUNDLE_PREFIX)) {
                    return bundleContext.getBundle().getEntry(url.substring(BUNDLE_PREFIX.length()));
                } else if (url.startsWith(docRoot)) {
                    File file = new File(url);
                    return (file.exists() && file.isFile()) ? file.toURI().toURL() : null;
                } else if (docRoot.startsWith(BUNDLE_PREFIX)) {
                    String prefix = docRoot.substring(BUNDLE_PREFIX.length());
                    return bundleContext.getBundle().getEntry(URIUtil.addPaths(prefix, url));
                } else {
                    File file = new File(docRoot, url);
                    return (file.exists() && (file.isFile() || retrieveDirResource)) ? file.toURI().toURL() : null;
                }
            } catch (MalformedURLException mue) {
                log.error(LogUtils.SERVER_INTERNAL_MARKER, "Malformed URL exception:" + url, mue);
                throw new RuntimeException(mue);
            }
        } else {
            return null;
        }
    }

    public String getMimeType(String url) {
        if (docRoot != null) {
            if (url.startsWith(docRoot)) {
                File file = new File(url);
                return (file.exists() && file.isFile()) ? MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(file) : null;
            } else {
                File file = new File(docRoot, url);
                return (file.exists() && file.isFile()) ? MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(file) : null;
            }
        } else {
            return null;
        }

    }

    protected SecurityConstraint getSecurityConstraint() {
        return securityConstraint;
    }

    public boolean handleSecurity(HttpServletRequest servletRequest, HttpServletResponse response) throws IOException {
        if (getSecurityConstraint() == null || getSecurityConstraint().equals(SecurityConstraint.NONE)) {
            return true;
        }
        HttpConnection connection = HttpConnection.getCurrentConnection();
        Connector connector = connection.getConnector();
        Request request = Request.getRequest(servletRequest);
        switch (getSecurityConstraint()) {
        case INTEGRAL:
            if (connector.isIntegral(request))
                break;
            if (connector.getIntegralPort() > 0) {
                String url = connector.getIntegralScheme() + "://" + request.getServerName() + ":" + connector.getIntegralPort() + request.getRequestURI();
                if (request.getQueryString() != null)
                    url += "?" + request.getQueryString();
                response.setContentLength(0);
                response.sendRedirect(url);
            } else
                response.sendError(Response.SC_FORBIDDEN, null);
            return false;
        case CONFIDENTIAL:
            if (connector.isConfidential(request))
                break;

            if (connector.getConfidentialPort() > 0) {
                String url = connector.getConfidentialScheme() + "://" + request.getServerName() + ":" + connector.getConfidentialPort() + request.getRequestURI();
                if (request.getQueryString() != null)
                    url += "?" + request.getQueryString();

                response.setContentLength(0);
                response.sendRedirect(url);
            } else
                response.sendError(Response.SC_FORBIDDEN, null);
            return false;

        default:
            // response.sendError(Response.SC_FORBIDDEN, null);
            return true;
        }
        return true;
    }
}
