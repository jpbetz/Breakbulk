/*******************************************************************************
 * Copyright (c) 2008-2010 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 * 
 * Contributors:
 *     Mort Bay Consulting Pty. Ltd. - the Jetty FormAuthenticator is the basis of the Cambridge Semantics EncryptedTokenAuthenticator.
 *     Cambridge Semantics Incorporated - modified to use encrypted token method to avoid using session state.
 *     
 *  This code is based on Jetty's org.eclipse.jetty.security.FormAuthenticator class
 *  as modified by Cambridge Semantics Incorporated to implement the encrypted
 *  token authentication as described at:
 *  http://www.openanzo.org/projects/openanzo/wiki/AnzoJsSessionKeyAuthenticationDesign
 *  The original copyright statement from the FormAuthenticator is reproduced below.
 *  The FormAuthenticator's authors were listed in the source as:
 *  Greg Wilkins (gregw) and dan@greening.name

 *  ========================================================================
 *  Copyright 199-2004 Mort Bay Consulting Pty. Ltd.
 *  ------------------------------------------------------------------------
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  ========================================================================
 * 
 *******************************************************************************/

package org.openanzo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.time.DateUtils;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.UrlEncoded;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.security.keystore.ISecretKeystore;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.EncryptedTokenAuthenticatorConstants;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Encrypted Token Authentication Authenticator. This authenticator implements and authentication scheme similar to the typical J2EE Form-based authentication
 * except that rather than depending on the session to record authentication credentials, it encrypts the credentials inside a cookie.
 * 
 * The authentication scheme is described at: http://www.openanzo.org/projects/openanzo/wiki/AnzoJsSessionKeyAuthenticationDesign
 * 
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
public class EncryptedTokenAuthenticator extends BasicContext implements EncryptedTokenAuthenticatorConstants {

    private static final Logger  log                           = LoggerFactory.getLogger(EncryptedTokenAuthenticator.class);

    private static final long    serialVersionUID              = 1L;

    private final static String  AUTH_METHOD                   = "ANZO_ENCRYPTED_TOKEN";

    final static String          TOKEN_DELIMITER               = ";";

    /**
     * Name of a request attribute that will be set if the authentication cookie should be refreshed. That is, authentication was valid and the refresh window
     * has elapsed. The authenticator will set the cookie in this request attribute instead of directly adding the refreshed cookie to the response whenever the
     * 'customTokenRefresh' config property is true. The value of the request attribute will be the actual {@link Cookie} object containing the refreshed
     * cookie.
     * 
     * This is mainly useful for situations where the authenticator is being asked to skip refreshing the cookie. For example, if the servlets want certain
     * requests to not count as valid activity toward resetting the timeout. One useful scenario for that is cometd, which polls the server every 30 seconds or
     * so. We'd like to timeout the user even in light of a bunch of empty poll responses.
     */
    public final static String   ANZO_REFRESH_COOKIE_ATTRIBUTE = "org.openanzo.standaloneEncryptedTokenAuthenticator.refreshCookie";

    private String               _formErrorPage;

    private String               _formErrorPath;

    private String               _formLoginPage;

    private String               _formLoginPath;

    private ISecretKeystore      secretKeyEncoder;

    private long                 tokenTimeout                  = -1;

    private long                 tokenRefreshWindow            = -1;

    /**
     * @see #ANZO_REFRESH_COOKIE_ATTRIBUTE
     */
    private Boolean              customTokenRefresh;

    private ServerRealm          realm;

    private Collection<PathSpec> protectedPathSpec             = new ArrayList<PathSpec>();

    /**
     * 
     * create a new EncryptedTokenAuthenticator
     * 
     * @param bundleContext
     *            bundle context
     * @param securityConstraint
     *            securityConstraint
     * @param realm
     *            security realm for authentication
     * @param encoder
     *            keystore
     * @param docRoot
     *            docroot for servlet
     * @param pathSpec
     *            unprotected paths for servlet
     * @param protectedPathSpec
     *            the protected paths for servlet
     */
    public EncryptedTokenAuthenticator(BundleContext bundleContext, SecurityConstraint securityConstraint, ServerRealm realm, ISecretKeystore encoder, String docRoot, Collection<PathSpec> pathSpec, Collection<PathSpec> protectedPathSpec) {
        this(bundleContext, securityConstraint, realm, encoder, docRoot, pathSpec, protectedPathSpec, false);
    }

    /**
     * 
     * create a new EncryptedTokenAuthenticator
     * 
     * @param bundleContext
     *            bundle context
     * @param securityConstraint
     *            securityConstraint
     * @param realm
     *            security realm for authentication
     * @param encoder
     *            keystore
     * @param docRoot
     *            docroot for servlet
     * @param pathSpec
     *            unprotected paths for servlet
     * @param protectedPathSpec
     *            the protected paths for servlet
     * @param retrieveDir
     *            return directory resources
     */
    public EncryptedTokenAuthenticator(BundleContext bundleContext, SecurityConstraint securityConstraint, ServerRealm realm, ISecretKeystore encoder, String docRoot, Collection<PathSpec> pathSpec, Collection<PathSpec> protectedPathSpec, boolean retrieveDir) {
        super(bundleContext, securityConstraint, docRoot, retrieveDir);
        if (encoder == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER, "encoder");
        }
        this.secretKeyEncoder = encoder;
        this.realm = realm;
        //this.pathSpec = pathSpec;
        this.protectedPathSpec = protectedPathSpec;
    }

    @Override
    public boolean handleSecurity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (super.handleSecurity(request, response)) {
            return authenticate(request, response);
        } else {
            return false;
        }
    }

    /**
     * Set the login page
     * 
     * @param path
     *            path to login page
     */
    public void setLoginPage(String path) {
        if (path == null || path.trim().length() == 0) {
            _formLoginPage = "/authentication/login.html";
            _formLoginPath = "/authentication/login.html";
        } else {
            if (!path.startsWith("/")) {
                log.warn(LogUtils.LIFECYCLE_MARKER, "EncryptedTokenAuthenticator login page must start with /");
                path = "/" + path;
            }
            _formLoginPage = path;
            _formLoginPath = path;
            if (_formLoginPath.indexOf('?') > 0)
                _formLoginPath = _formLoginPath.substring(0, _formLoginPath.indexOf('?'));
        }
    }

    /**
     * Get the login page
     * 
     * @return the login page
     */
    public String getLoginPage() {
        return _formLoginPage;
    }

    /**
     * Set the login error page
     * 
     * @param path
     *            the login error page
     */
    public void setErrorPage(String path) {
        if (path == null || path.trim().length() == 0) {
            _formErrorPath = "/authentication/error.html";
            _formErrorPage = "/authentication/error.html";
        } else {
            if (!path.startsWith("/")) {
                log.warn(LogUtils.LIFECYCLE_MARKER, "EncryptedTokenAuthenticator error page must start with /");
                path = "/" + path;
            }
            _formErrorPage = path;
            _formErrorPath = path;

            if (_formErrorPath != null && _formErrorPath.indexOf('?') > 0)
                _formErrorPath = _formErrorPath.substring(0, _formErrorPath.indexOf('?'));
        }
    }

    /**
     * Get the login error page
     * 
     * @return the login error page
     */
    public String getErrorPage() {
        return _formErrorPage;
    }

    /**
     * Perform form authentication. Called from SecurityHandler.
     * 
     * @param servletRequest
     *            request to authenticate
     * @param response
     *            response to send response data
     * 
     * @return UserPrincipal if authenticated else null.
     * @throws IOException
     */
    @SuppressWarnings("null")
    public boolean authenticate(HttpServletRequest servletRequest, HttpServletResponse response) throws IOException {
        // NOTE: Jetty will sometimes call this method with a null response parameter. In particular, from
        // the org.eclipse.jetty.Request#getUserPrincipal() method.
        boolean ret = false;
        Request request = Request.getRequest(servletRequest);
        String uri = request.getServletPath();
        boolean protectedPath = false;
        for (PathSpec spec : protectedPathSpec) {
            if (spec.matches(uri)) {
                protectedPath = true;
                break;
            }
        }
        // Setup some defaults. Unfortunately, this is the only place we really get to set these up since the
        // Authenticator interface doesn't have an 'init'-like method.
        if (tokenTimeout <= 0) {
            tokenTimeout = 30 * DateUtils.MILLIS_PER_MINUTE;
        }
        if (tokenRefreshWindow <= 0) {
            tokenRefreshWindow = 5 * DateUtils.MILLIS_PER_MINUTE;
        }
        if (customTokenRefresh == null) {
            customTokenRefresh = Boolean.FALSE;
        }

        // Now handle the request
        uri = request.getPathInfo();
        if (uri.endsWith(LOGIN_URI_SUFFIX)) {
            // Handle a request for authentication.

            ret = false; // We will entirely handle the request here so return false to stop processing the request.

            String username = request.getParameter(USERNAME_PARAMETER_NAME);
            String password = request.getParameter(PASSWORD_PARAMETER_NAME);

            if (username == null || password == null) {
                log.error(LogUtils.SECURITY_MARKER, "Invalid anzo_authenticate request url:{} username:{} password:{}", new Object[] { uri, username, password == null ? null : "XXXObscuredNonNullPasswordXXX" });
            }

            AnzoPrincipal userPrincipal = null;
            try {
                userPrincipal = realm.authenticate(username, password, request);
            } catch (Exception e) {
                // No matter what sort of failure occurs in the realm we want to make sure to send the  appropriate
                // error response or redirect. So we can't all exceptions here.
                log.debug(LogUtils.SECURITY_MARKER, "Failed authentication call to the realm.", e);
            }
            if (userPrincipal == null) {
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.SECURITY_MARKER, "Authentication request FAILED for {}", StringUtil.printable(username));
                }
                request.setAuthentication(null);

                if (response != null) {
                    if (_formErrorPage == null || isRequestSentByXmlHttpRequest(request)) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.SECURITY_MARKER, "Sending 403 Forbidden error due to invalid credentials for user {}", username);
                        }
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    } else {
                        String redirectPath = response.encodeRedirectURL(URIUtil.addPaths(request.getContextPath(), _formErrorPage));
                        log.debug(LogUtils.SECURITY_MARKER, "Sending redirect to form error page {}", redirectPath);
                        response.setContentLength(0);
                        response.sendRedirect(redirectPath);
                    }
                }
            } else {
                // Authenticated OK
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.SECURITY_MARKER, "Authentication request OK for {}", StringUtil.printable(username));
                }
                request.setAuthentication(new BasicUserAuthorization(userPrincipal, AUTH_METHOD));

                // Set the encrypted token
                if (response != null) {
                    try {
                        String token = createEncryptedToken(username, request.getRemoteAddr());
                        Cookie tokenCookie = new Cookie(ANZO_TOKEN_COOKIE_NAME, token);
                        tokenCookie.setPath("/");
                        response.addCookie(tokenCookie);
                        if (isRequestSentByXmlHttpRequest(request)) {
                            // XMLHttpRequests just want a response with the cookie, no fancy redirects or anything like that.
                            // just send back 200 in text.(Need to send back something else firefox reports an error)
                            response.setStatus(HttpServletResponse.SC_OK);
                            response.setContentType("text/plain");
                            PrintWriter out = response.getWriter();
                            out.print(HttpServletResponse.SC_OK);
                            out.flush();
                            out.close();
                        } else {
                            // Redirect to the URL to user wanted to get to initially, or "/" if there isn't any such URL.
                            // We get the URL from a query parameter in the HTTP Referer (sic) header.
                            String referer = request.getHeader(HttpHeaders.REFERER);
                            String redirectPath = null;
                            if (referer != null) {
                                HttpURI refererUri = new HttpURI(referer);
                                MultiMap<String> queryParams = new MultiMap<String>();
                                refererUri.decodeQueryTo(queryParams, null);
                                String desiredUrl = (String) queryParams.getValue(ANZO_URL_QUERY_PARAM, 0);
                                if (desiredUrl != null) {
                                    redirectPath = desiredUrl;
                                }
                            }
                            if (redirectPath == null) {
                                redirectPath = URIUtil.addPaths(request.getContextPath(), "/");
                            }
                            redirectPath = response.encodeRedirectURL(redirectPath);
                            log.debug(LogUtils.SECURITY_MARKER, "Sending redirect to root {} after successful login request.", redirectPath);
                            response.sendRedirect(redirectPath);
                        }

                    } catch (AnzoException cause) {
                        IOException ex = new IOException("Error creating encrypted authentication token.");
                        ex.initCause(cause);
                        throw ex;
                    }
                }
            }

        } else if (isLoginOrErrorPage(uri)) {
            // Don't authenticate authform or errorpage. Just let the system them out.
            ret = true;
        } else if (protectedPath) {
            // This is a regular request for a protected resource, so check whether there is a valid
            // encrypted token in the request.
            AnzoPrincipal userPrincipal = null;

            // Parse and validate the authentication token from the cookie
            Token token = null;
            long currentTime = System.currentTimeMillis();
            Cookie[] cookies = request.getCookies();
            Cookie tokenCookie = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String cookieName = cookie.getName();
                    if (ANZO_TOKEN_COOKIE_NAME.equals(cookieName)) {
                        tokenCookie = cookie;
                        try {
                            token = parseAnzoToken(cookie.getValue());
                            userPrincipal = validateAuthToken(token, realm, request.getRemoteAddr(), currentTime);
                        } catch (AnzoException e) {
                            log.debug(LogUtils.SECURITY_MARKER, "Error decrypting and parsing authentication token.", e);
                        }
                        break;
                    }
                }
            }

            if (userPrincipal == null) {
                // Invalid, expired, or non-existent token
                ret = false; // Don't serve the resource

                if (log.isDebugEnabled()) {
                    String msg = "Auth token ";
                    if (tokenCookie == null) {
                        msg += "MISSING";
                    } else {
                        msg += "INVALID";
                    }
                    log.debug(LogUtils.SECURITY_MARKER, msg + " for URL: {}", StringUtil.printable(request.getRequestURI()));
                }
                if (response != null) {
                    Cookie cookie = new Cookie(ANZO_TOKEN_COOKIE_NAME, "");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie); // adding a cookie with MaxAge=0 tells the client to delete the cookie.
                    if (_formLoginPage == null || isRequestSentByXmlHttpRequest(request)) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.SECURITY_MARKER, "Sending 403 Forbidden error due to invalid auth token. Token: {}", token);
                        }
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    } else {
                        // We save the URL the user tried to access into a query parameter in the redirect to the login page.
                        // That way the login page can send the user to the page they wanted after they finish logging in.
                        // First we must reconstruct the URL the user accessed.
                        String requestUrl = uri;
                        if (request.getQueryString() != null) {
                            requestUrl += "?" + request.getQueryString();
                        }
                        requestUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + URIUtil.addPaths(request.getContextPath(), requestUrl);
                        // Now we add the requested URL as a query parameter to the login URL
                        MultiMap<String> loginPageUrlQueryParams = new MultiMap<String>();
                        loginPageUrlQueryParams.put(ANZO_URL_QUERY_PARAM, requestUrl);
                        String loginPageUrl = URIUtil.addPaths(request.getContextPath(), _formLoginPage);
                        try {
                            loginPageUrl = addQueryParametersToURI(loginPageUrl, loginPageUrlQueryParams);
                        } catch (URISyntaxException e) {
                            log.warn(LogUtils.SECURITY_MARKER, "Error creating login redirect URL. The user's attempted URL won't be saved for use after login.", e);
                        }
                        String redirectPath = response.encodeRedirectURL(loginPageUrl);
                        log.debug(LogUtils.SECURITY_MARKER, "Sending redirect to form login page {} after request without adequate credentials.", redirectPath);
                        response.setContentLength(0);
                        response.sendRedirect(redirectPath);
                    }
                }
            } else {
                // Properly authenticated
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.SECURITY_MARKER, "Auth token OK for '{}' for URL:{}", StringUtil.printable(userPrincipal.getName()), StringUtil.printable(request.getRequestURI()));
                }
                if (userPrincipal instanceof AnzoPrincipal) {
                    request.setAttribute(SerializationConstants.authenticationURI, (userPrincipal).getUserURI());
                }
                request.setAttribute(SerializationConstants.userPrincipal, userPrincipal);
                request.setAuthentication(new BasicUserAuthorization(userPrincipal, AUTH_METHOD));
                ret = true;

                // Check if the token is older than the refresh window. If so, create a new cookie with an updated timestamp.
                try {
                    if (currentTime < token.getTimestamp() || (currentTime - token.getTimestamp() >= tokenRefreshWindow)) { // if current time is less than the token's time, we'll issue a new cookie. That should only ever happen upon overflow of the number of milliseconds from the epoch.
                        String cookieval = createEncryptedToken(token.getUsername(), token.getRemoteAddress());
                        Cookie newTokenCookie = new Cookie(ANZO_TOKEN_COOKIE_NAME, cookieval);
                        newTokenCookie.setPath("/");
                        if (customTokenRefresh) {
                            request.setAttribute(ANZO_REFRESH_COOKIE_ATTRIBUTE, newTokenCookie);
                        } else {
                            response.addCookie(newTokenCookie);
                        }
                    }
                } catch (AnzoException e) {
                    log.error(LogUtils.SECURITY_MARKER, "Could NOT update timestamp on authentication token. Authentication session may end prematurely.", e);
                }
            }
        } else {
            // This is NOT a protected resource so just let it be served.
            ret = true;
        }

        log.debug(LogUtils.SECURITY_MARKER, "Returning from 'authenticate' with {} for path {}", ret, uri);
        return ret;
    }

    /**
     * Checks if the given token is a valid authentication token. If so, it returns the Principal for the user which the token authenticates.
     * 
     * @param token
     *            the parsed token to validate
     * @param realm
     *            used to obtain the principal using the token username
     * @param requestRemoteAddress
     *            the IP address of the client which made supplied the token. It will be compared to the address embedded in the token
     * @param currentTime
     *            the current time in milliseconds to compare to the token's timestamp for checking if the token is expired.
     * @return the authenticated principal or null if the token is invalid.
     */
    AnzoPrincipal validateAuthToken(Token token, ServerRealm realm, String requestRemoteAddress, long currentTime) {
        AnzoPrincipal userPrincipal = null;
        // Validate that the IP address for which the token was created is the same as the one in the current request.
        if (token != null && token.getRemoteAddress().equals(requestRemoteAddress)) {
            // Validate that the token isn't older than the timeout period
            if (currentTime >= token.getTimestamp() && (currentTime - token.getTimestamp() < tokenTimeout)) {
                // The token is valid. Let's lookup the user information as a final check.
                userPrincipal = realm.getPrincipal(token.getUsername());
            } else {
                log.debug(LogUtils.SECURITY_MARKER, "Auth token timestamp is expired: - tokenTimestamp:{} currentTime:{} difference:{} timeout:", new Object[] { token.getTimestamp(), currentTime, currentTime - token.getTimestamp(), tokenTimeout });
            }
        } else {
            log.debug(LogUtils.SECURITY_MARKER, "Auth token remote address does not match - tokenAddress:{} requestAddress:{}", (token != null) ? token.getRemoteAddress() : null, requestRemoteAddress);
        }
        return userPrincipal;
    }

    /**
     * Creates an encrypted token by combining the username, remote IP address, and the current timestamp (in milliseconds from the epoch) and then encrypting
     * the combined string. The string is of the format: "timestamp;remoteAddress;username". For example: <code>1208983023421;127.0.0.1;cooluser</code>
     * 
     * @param username
     *            the username of the authenticated user
     * @param remoteAddr
     *            the remote IP address from which the authentication request came.
     * @return the base64 representation of the encrypted token string.
     */
    String createEncryptedToken(String username, String remoteAddr) throws AnzoException {
        String timestamp = Long.toString(System.currentTimeMillis());
        StringBuilder str = new StringBuilder(username.length() + remoteAddr.length() + timestamp.length() + 2); // 2 for the colons
        str.append(timestamp);
        str.append(TOKEN_DELIMITER);
        str.append(remoteAddr);
        str.append(TOKEN_DELIMITER);
        str.append(username);

        String plaintoken = str.toString();
        String cyphertoken = this.secretKeyEncoder.encryptAndBase64EncodeString(plaintoken);
        return cyphertoken;
    }

    /**
     * Decrypts and parses the given authentication token.
     * 
     * @param token
     * @return null if the string couldn't be parsed properly.
     * @throws AnzoException
     */
    Token parseAnzoToken(String token) throws AnzoException {
        Token ret = null;
        String plaintoken = this.secretKeyEncoder.decryptAndBase64DecodeString(token);
        int firstDelimiter = plaintoken.indexOf(TOKEN_DELIMITER);
        if (firstDelimiter > 0) {
            String timestr = plaintoken.substring(0, firstDelimiter);
            try {
                long timestamp = Long.parseLong(timestr);
                int secondDelimiter = plaintoken.indexOf(TOKEN_DELIMITER, firstDelimiter + 1);
                if (secondDelimiter > firstDelimiter + 1) {
                    String remoteAddr = plaintoken.substring(firstDelimiter + 1, secondDelimiter);
                    if (secondDelimiter < plaintoken.length() - 1) {
                        String username = plaintoken.substring(secondDelimiter + 1);
                        ret = new Token(username, timestamp, remoteAddr);
                    }
                }
            } catch (NumberFormatException e) {
                log.trace(LogUtils.SECURITY_MARKER, "Invalid timestamp in authentication token.");
            }
        }
        return ret;
    }

    private boolean isLoginOrErrorPage(String pathInContext) {
        return pathInContext != null && ((_formErrorPath != null && pathInContext.endsWith(_formErrorPath)) || (_formLoginPath != null && pathInContext.endsWith(_formLoginPath)));
    }

    private boolean isRequestSentByXmlHttpRequest(HttpServletRequest request) {
        String val = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(val);
    }

    static class Token {
        private String username;

        private long   timestamp;

        private String remoteAddress;

        public Token(String username, long timestamp, String remoteAddress) {
            this.username = username;
            this.timestamp = timestamp;
            this.remoteAddress = remoteAddress;
        }

        public String getUsername() {
            return username;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public String getRemoteAddress() {
            return remoteAddress;
        }

        @Override
        public String toString() {
            ToStringBuilder builder = new ToStringBuilder(this).append(username).append(timestamp).append(remoteAddress);
            return builder.toString();
        }
    }

    /**
     * Get the authentication token timeout period.
     * 
     * @return the token timeout in milliseconds.
     */
    public long getTokenTimeout() {
        return tokenTimeout;
    }

    /**
     * Set the authentication token timeout period.
     * 
     * @param tokenTimeout
     *            the token timeout in milliseconds to set.
     */
    public void setTokenTimeout(long tokenTimeout) {
        this.tokenTimeout = tokenTimeout;
    }

    /**
     * Get the authentication token refresh timeout period. That is, the window of time when we avoid creating a new token to save on bandwidth and encryption
     * operations.
     * 
     * @return the authentication token refresh timeout period in milliseconds
     */
    public long getTokenRefreshWindow() {
        return tokenRefreshWindow;
    }

    /**
     * Set the authentication token refresh timeout period. That is, the window of time when we avoid creating a new token to save on bandwidth and encryption
     * operations.
     * 
     * @param tokenRefreshWindow
     *            the authentication token refresh timeout period in milliseconds to set.
     */
    public void setTokenRefreshWindow(long tokenRefreshWindow) {
        this.tokenRefreshWindow = tokenRefreshWindow;
    }

    /**
     * If true, the authenticator will not refresh the cookie when the refresh window elapses. Instead, it will place the cookie that would have been used to
     * refresh the token in a request attribute called {@link #ANZO_REFRESH_COOKIE_ATTRIBUTE}.
     * 
     * If false, the authenticator will refresh the authentication token by adding a cookie directly to the response and will not fill the
     * {@link #ANZO_REFRESH_COOKIE_ATTRIBUTE} request attribute.
     * 
     * Default is false. But will return null if it hasn't been set so that an explicit 'false' can be distinguished from a default 'false'.
     * 
     * @see #ANZO_REFRESH_COOKIE_ATTRIBUTE
     * @return true if a custom token refresh value should be used
     * 
     */
    public Boolean getCustomTokenRefresh() {
        return customTokenRefresh;
    }

    /**
     * Sets the customTokenRefresh mode.
     * 
     * @see #getCustomTokenRefresh()
     * @param customTokenRefresh
     *            the customTokenRefresh mode to set
     */
    public void setCustomTokenRefresh(Boolean customTokenRefresh) {
        this.customTokenRefresh = customTokenRefresh;
    }

    /**
     * @return the docRoot
     */
    public String getDocRoot() {
        return docRoot;
    }

    /**
     * @param docRoot
     *            the docRoot to set
     */
    public void setDocRoot(String docRoot) {
        this.docRoot = docRoot;
    }

    /**
     * Adds the give parameters to a URI string in the URI's query portion. It will add the '?' if needed, and will simply add the arguments if the URI already
     * has a query portion. It will also allow URIs with fragment portions (ex. '#foo') and place the query fragment and parameters in the appropriate place. It
     * will also escape any special URI characters in the parameter names or values.
     * 
     * This method assumes that the query string is in x-www-form-urlencoded format.
     * 
     * @param uri
     *            the URI string to modify
     * @param parameters
     *            the map with the key/value parameters to add to the query portion of the URI
     * @return a String URI with the parameters added to the given URI.
     * @throws URISyntaxException
     */
    public static String addQueryParametersToURI(String uri, MultiMap<String> parameters) throws URISyntaxException {
        URI inUri = new URI(uri);

        String paramStr = UrlEncoded.encode(parameters, null, false);
        String newQuery = inUri.getQuery() == null ? paramStr : inUri.getQuery() + "&" + paramStr;
        StringBuilder outUri = new StringBuilder();
        if (inUri.getScheme() != null) {
            outUri.append(inUri.getScheme());
            outUri.append(':');
        }
        if (inUri.getRawAuthority() != null) {
            outUri.append("//");
            outUri.append(inUri.getRawAuthority());
        }
        if (inUri.getRawPath() != null) {
            outUri.append(inUri.getRawPath());
        }
        if (StringUtils.isNotEmpty(newQuery)) {
            outUri.append('?');
            outUri.append(newQuery);
        }
        if (inUri.getRawFragment() != null) {
            outUri.append("#");
            outUri.append(inUri.getRawFragment());
        }
        return outUri.toString();
    }

    /**
     * Log the request to DEBUG level. WARNING: This should be used sparingly, if at all. Logging the entire request may expose sensitive information such as
     * passwords in the log files.
     * 
     * @param request
     */
    void logRequest(Request request) {
        if (log.isDebugEnabled()) {
            StringBuilder msg = new StringBuilder();
            msg.append("Request for ");
            msg.append(request.getRequestURL());
            msg.append("\nHeaders:");
            Enumeration<?> names = request.getHeaderNames();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                msg.append("\n");
                msg.append(name);
                msg.append(" : ");
                Enumeration<?> headers = request.getHeaders(name);
                while (headers.hasMoreElements()) {
                    msg.append((String) headers.nextElement());
                    if (headers.hasMoreElements()) {
                        msg.append(",");
                    }
                }
            }
            msg.append("\nBody\n");
            Reader reader = null;
            try {
                reader = request.getReader();
                String body = IOUtils.toString(reader);
                msg.append(body);
            } catch (IOException e) {
                msg.append(e.getMessage());
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        log.debug(LogUtils.SECURITY_MARKER, "Error closing request reader while logging", e);
                    }
                }
            }
            msg.append("\nDone logging request.");
            log.debug(LogUtils.SECURITY_MARKER, msg.toString());
        }
    }
}
