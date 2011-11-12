/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.ServletException;

import org.eclipse.jetty.servlets.GzipFilter;
import org.eclipse.jetty.util.URIUtil;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.security.keystore.ISecretKeystore;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.ServicesDictionary;
import org.ops4j.pax.web.service.WebContainer;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.NamespaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for ServletComponent implementations. This class helps implementors of the {@link IServletComponent} interface by providing stock implementation
 * of many of the methods. Its initialize method will read the various properties from the configuration graph.
 * 
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 * @author Matthew Roy (<a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public abstract class BaseServletComponent implements IServletComponent {

    private static final Logger    log                = LoggerFactory.getLogger(BaseServletComponent.class);

    protected AuthenticationMode   authenticationMode = AuthenticationMode.NONE;

    protected SecurityConstraint   securityConstraint = SecurityConstraint.NONE;

    protected Collection<PathSpec> pathSpec           = new ArrayList<PathSpec>();

    protected Collection<PathSpec> protectedPathSpec  = new ArrayList<PathSpec>();

    protected String               contextPath;

    protected String               docRoot;

    protected Properties           servletProperties  = new Properties();

    protected String               loginPage;

    protected String               errorPage;

    protected int                  tokenTimeout       = -1;

    protected int                  tokenRefreshWindow = -1;

    protected Boolean              customTokenRefreshEnabled;

    protected Boolean              gzipOutputEnabled;

    protected HttpContext          context;

    protected BundleContext        bundleContext;

    protected GzipFilter           filter;

    protected WelcomeFilesFilter   welcomeFilter;

    protected Set<String>          instances          = new HashSet<String>();

    public void registerServlet(WebContainer webContainer, IAuthenticationService authenticationService, ISecretKeystore keystore) {
        setUpContext(authenticationService, keystore);

        try {
            // Properties contextProperties = new Properties();
            // contextProperties.put(WebContainerConstants.CONTEXT_NAME, (this.contextPath.startsWith("/") ? this.contextPath.substring(1) : this.contextPath));
            // webContainer.setContextParam(contextProperties, context);
            if (getServlet() != null) {
                ArrayList<String> paths = new ArrayList<String>();
                if (getPathSpec() != null) {
                    for (PathSpec spec : getPathSpec()) {
                        paths.add(spec.spec + ((spec.wildCard) ? "/*" : ""));
                    }
                }
                if (getProtectedPathSpec() != null) {
                    for (PathSpec spec : getProtectedPathSpec()) {
                        paths.add(spec.spec + ((spec.wildCard) ? "/*" : ""));
                    }
                }
                if (log.isInfoEnabled()) {
                    log.info(LogUtils.LIFECYCLE_MARKER, "Registering Servlet:" + getServlet() + " paths:" + Arrays.toString(paths.toArray(new String[0])));
                }
                ClassLoader currentClassLoader = null;
                currentClassLoader = Thread.currentThread().getContextClassLoader();
                Thread.currentThread().setContextClassLoader(getServlet().getClass().getClassLoader());
                try {
                    webContainer.registerServlet(getServlet(), paths.toArray(new String[0]), servletProperties, context);
                } finally {
                    Thread.currentThread().setContextClassLoader(currentClassLoader);
                }
            } else if (getDocRoot() != null) {
                ArrayList<String> allPaths = new ArrayList<String>();
                ArrayList<String> allRoots = new ArrayList<String>();
                if (getPathSpec() != null) {
                    for (PathSpec spec : getPathSpec()) {
                        try {
                            if (log.isInfoEnabled()) {
                                log.info(LogUtils.LIFECYCLE_MARKER, "Registering Resources:" + spec.spec + " docRoot:" + docRoot);
                            }
                            webContainer.registerResources(spec.spec, docRoot, context);
                            allPaths.add(spec.spec + ((spec.wildCard) ? "/*" : ""));
                            allRoots.add(spec.spec);
                        } catch (NamespaceException nse) {
                            log.error(LogUtils.LIFECYCLE_MARKER, "Error registering static resource: |" + spec.spec + "|", nse);
                        }
                    }
                }
                if (getProtectedPathSpec() != null) {
                    for (PathSpec spec : getProtectedPathSpec()) {
                        try {
                            if (log.isInfoEnabled()) {
                                log.info(LogUtils.LIFECYCLE_MARKER, "Registering Resources:" + spec.spec + " docRoot:" + docRoot);
                            }
                            webContainer.registerResources(spec.spec, docRoot, context);
                            allPaths.add(spec.spec + ((spec.wildCard) ? "/*" : ""));
                            allRoots.add(spec.spec);
                        } catch (NamespaceException nse) {
                            log.error(LogUtils.LIFECYCLE_MARKER, "Error registering static resource", nse);
                        }
                    }

                    welcomeFilter = new WelcomeFilesFilter(allRoots, new String[] { "index.html", "index.htm" }, true);
                    webContainer.registerFilter(welcomeFilter, allPaths.toArray(new String[0]), null, null, context);

                }
                if ((gzipOutputEnabled == null || gzipOutputEnabled) && allPaths.size() > 0) {
                    filter = new GzipFilter();
                    webContainer.registerFilter(filter, allPaths.toArray(new String[0]), null, servletProperties, context);
                }

            }
        } catch (ServletException se) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error registering servlet at:" + getContextPath(), se);
            throw new RuntimeException(se);
        }
    }

    /**
     * Initializes the HttpContext depending on the authentication mode
     */
    protected void setUpContext(IAuthenticationService authenticationService, ISecretKeystore keystore) {
        switch (getAuthenticationMode()) {
        case NONE:
            context = new BasicContext(bundleContext, getSecurityConstraint(), getDocRoot());
            break;
        case BASIC: {
            IAuthenticatorRealm relm = new ServerRealm(authenticationService);
            context = new BasicAuthenticator(bundleContext, getSecurityConstraint(), relm, getDocRoot(), getPathSpec(), getProtectedPathSpec());
        }
            break;
        case ENCRYPTED_TOKEN: {
            ServerRealm relm = new ServerRealm(authenticationService);
            EncryptedTokenAuthenticator authenticator = new EncryptedTokenAuthenticator(bundleContext, getSecurityConstraint(), relm, keystore, docRoot, getPathSpec(), getProtectedPathSpec());
            authenticator.setLoginPage(getLoginPage());
            authenticator.setErrorPage(getErrorPage());
            if (tokenTimeout != -1)
                authenticator.setTokenTimeout(getTokenTimeout());
            if (customTokenRefreshEnabled != null)
                authenticator.setCustomTokenRefresh(isCustomTokenRefreshEnabled());
            if (tokenRefreshWindow != -1)
                authenticator.setTokenRefreshWindow(getTokenRefreshWindow());
            if (docRoot != null) {
                authenticator.setDocRoot(docRoot);
            }
            context = authenticator;
        }
            break;
        }
    }

    public void unregisterServlet(WebContainer webContainer) {
        if (getServlet() != null) {
            webContainer.unregisterServlet(getServlet());
        } else if (getDocRoot() != null) {
            try {
                if (welcomeFilter != null && webContainer != null) {
                    webContainer.unregisterFilter(welcomeFilter);
                }
            } catch (IllegalArgumentException iae) {
                log.debug(LogUtils.LIFECYCLE_MARKER, "Error unregistering welcome filter", iae);
            }
            if (webContainer != null && filter != null) {
                try {
                    webContainer.unregisterFilter(filter);
                } catch (IllegalArgumentException iae) {
                    log.debug(LogUtils.LIFECYCLE_MARKER, "Error unregistering filter", iae);
                }

            }
            if (webContainer != null && getPathSpec() != null) {
                for (PathSpec spec : getPathSpec()) {
                    try {
                        webContainer.unregister(spec.spec);
                    } catch (IllegalArgumentException iae) {
                        log.debug(LogUtils.LIFECYCLE_MARKER, "Error unregistering pathspec", iae);
                    }
                }
            }
            if (webContainer != null && getProtectedPathSpec() != null) {
                for (PathSpec spec : getProtectedPathSpec()) {
                    try {
                        webContainer.unregister(spec.spec);
                    } catch (IllegalArgumentException iae) {
                        log.debug(LogUtils.LIFECYCLE_MARKER, "Error unregistering protected pathsec", iae);
                    }
                }
            }

        }
    }

    /**
     * Initialize the hosting of a servlet
     * 
     * @param bundleContext
     *            bundle context for servlet
     * @param configProperties
     *            configuration properties
     * @throws AnzoException
     */
    public void initialize(BundleContext bundleContext, Dictionary<?, ?> configProperties) throws AnzoException {

        if (configProperties == null) {
            log.warn(LogUtils.LIFECYCLE_MARKER, "configProperties is null while initializing base servlet component.");
        } else {
            String instancesString = ServicesDictionary.getInstanceURI(configProperties);
            if (instancesString != null) {
                if (instancesString.equals("*")) {
                    //Do nothing since null equals all
                } else {
                    StringTokenizer st = new StringTokenizer(instancesString, ",");
                    while (st.hasMoreTokens()) {
                        instances.add(st.nextToken());
                    }
                }
            }
            this.bundleContext = bundleContext;
            String authmode = ServletDictionary.getAuthorizationType(configProperties);
            this.authenticationMode = (authmode != null) ? AuthenticationMode.valueOf(authmode) : AuthenticationMode.NONE;
            String sc = ServletDictionary.getSecurityConstraint(configProperties);
            this.securityConstraint = (sc != null) ? SecurityConstraint.valueOf(sc) : SecurityConstraint.NONE;
            Boolean requireSSL = ServicesDictionary.getRequireSSL(configProperties);
            boolean reqSSL = (requireSSL != null) ? requireSSL.booleanValue() : false;
            if (reqSSL) {
                this.securityConstraint = SecurityConstraint.INTEGRAL;
            }
            this.contextPath = ServletDictionary.getContextPath(configProperties);
            this.docRoot = ServletDictionary.getDocRoot(configProperties);
            if (this.docRoot != null) {
                this.docRoot = this.docRoot.replace('\\', '/'); // The web container doesn't like backslashes in the docroot. So convert them to forward slashes.
            }

            if (docRoot != null && docRoot.startsWith("./")) {
                String rootPath = getRootPath();
                rootPath = rootPath.replace('\\', '/');
                docRoot = URIUtil.addPaths(rootPath, docRoot.substring(Math.min(docRoot.length() - 1, 2)));
            } else if (docRoot != null && docRoot.startsWith("../")) {
                String rootPath = getRootPath();
                rootPath = rootPath.replace('\\', '/');
                docRoot = URIUtil.addPaths(rootPath, docRoot);
            }

            String pathSpec = ServletDictionary.getPathSpec(configProperties);
            if (pathSpec != null) {
                StringTokenizer st = new StringTokenizer(pathSpec, ",");
                while (st.hasMoreTokens()) {
                    String path = st.nextToken();
                    if (path != null) {
                        this.pathSpec.add(new PathSpec(URIUtil.addPaths(((getContextPath() != null) ? getContextPath() : ""), path)));
                    }
                }
            }

            String protectedPathSpec = ServletDictionary.getProtectedPathSpec(configProperties);
            if (protectedPathSpec != null) {
                StringTokenizer st = new StringTokenizer(protectedPathSpec, ",");
                while (st.hasMoreTokens()) {
                    String path = st.nextToken();
                    if (path != null) {
                        this.protectedPathSpec.add(new PathSpec(URIUtil.addPaths(((getContextPath() != null) ? getContextPath() : ""), path)));
                    }
                }
            }
            this.loginPage = ServletDictionary.getLoginPage(configProperties);
            if (this.loginPage != null) {
                this.loginPage = URIUtil.addPaths(this.contextPath, loginPage);
            }
            this.errorPage = ServletDictionary.getErrorPage(configProperties);
            if (this.errorPage != null) {
                this.errorPage = URIUtil.addPaths(this.contextPath, errorPage);
            }
            this.customTokenRefreshEnabled = ServletDictionary.getCustomTokenRefreshEnabled(configProperties);
            this.gzipOutputEnabled = ServletDictionary.getGzipOutput(configProperties);
            if (configProperties.get(ServletDictionary.KEY_AUTH_TOKEN_TIMEOUT) != null) {
                this.tokenTimeout = ServletDictionary.getAuthTokenTimeout(configProperties);
            }
            if (configProperties.get(ServletDictionary.KEY_AUTH_TOKEN_REFRESH_WINDOW) != null) {
                this.tokenRefreshWindow = ServletDictionary.getAuthTokenRefreshWindow(configProperties);
            }
            initializeServletProperties(configProperties);

            // Log some info for help debugging configuration issues
            if (log.isInfoEnabled()) {
                StringBuilder msg = new StringBuilder("Initialize BaseServletComponent with values: contextPath:");
                msg.append(this.contextPath);
                msg.append(" docRoot:");
                msg.append(this.docRoot);
                msg.append(" pathSpec:");
                if (this.pathSpec != null) {
                    boolean first = true;
                    for (PathSpec spec : this.pathSpec) {
                        if (!first) {
                            msg.append(",");
                        }
                        msg.append(spec.toString());
                        first = false;
                    }
                }
                msg.append(" authenticationMode:");
                msg.append(this.authenticationMode.toString());
                msg.append(" protectedPathSpec:");
                if (this.protectedPathSpec != null) {
                    boolean first = true;
                    for (PathSpec spec : this.protectedPathSpec) {
                        if (!first) {
                            msg.append(",");
                        }
                        msg.append(spec.toString());
                        first = false;
                    }
                }
                msg.append(" loginPage:");
                msg.append(this.loginPage);
                msg.append(" errorPage:");
                msg.append(this.errorPage);
                msg.append(" customTokenRefreshEnabled:");
                msg.append(this.customTokenRefreshEnabled);
                msg.append(" gzipOutputEnabled:");
                msg.append(this.gzipOutputEnabled);
                msg.append(" tokenTimeout:");
                msg.append(this.tokenTimeout);
                msg.append(" tokenRefreshWindow:");
                msg.append(this.tokenRefreshWindow);

                log.info(LogUtils.LIFECYCLE_MARKER, msg.toString());
            }
        }
    }

    private String getRootPath() {
        String path = System.getProperty("ANZO_SERVER_HOME");
        if (path == null) {
            path = System.getenv("ANZO_SERVER_HOME");
        }
        if (path == null) {
            path = System.getProperty("ANZO_HOME");
        }
        if (path == null) {
            path = System.getenv("ANZO_HOME");
        }
        return path;
    }

    public Set<String> getWebcontainerInstanceURIs() {
        return instances;
    }

    protected void initializeServletProperties(Dictionary<?, ?> configProperties) {
        for (Enumeration<?> keys = configProperties.keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            servletProperties.put(key, configProperties.get(key));
        }
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getContextPath()
     */
    public String getContextPath() {
        return this.contextPath;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getDocRoot()
     */
    public String getDocRoot() {
        return this.docRoot;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getInitProperties()
     */
    public Properties getInitProperties() {
        return this.servletProperties;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getIsAuthenticationMode()
     */
    public AuthenticationMode getAuthenticationMode() {
        return this.authenticationMode;
    }

    /**
     * @return the securityConstraint
     */
    public SecurityConstraint getSecurityConstraint() {
        return securityConstraint;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getPathSpec()
     */
    public Collection<PathSpec> getPathSpec() {
        return this.pathSpec;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getProtectedPathSpec()
     */
    public Collection<PathSpec> getProtectedPathSpec() {
        return this.protectedPathSpec;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getErrorPage()
     */
    public String getErrorPage() {
        return this.errorPage;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getLoginPage()
     */
    public String getLoginPage() {
        return this.loginPage;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getTokenTimeout()
     */
    public int getTokenTimeout() {
        return this.tokenTimeout;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#getTokenRefreshWindow()
     */
    public int getTokenRefreshWindow() {
        return this.tokenRefreshWindow;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.endpoint.IServletComponent#isCustomTokenRefreshEnabled()
     */
    public Boolean isCustomTokenRefreshEnabled() {
        return this.customTokenRefreshEnabled;
    }
}
