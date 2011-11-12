/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 9, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.jetty.http.security.Constraint;
import org.eclipse.jetty.server.Request;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.BaseOperationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jetty server authentication module
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ServerRealm implements IAuthenticatorRealm {
    private static final Logger                      log                   = LoggerFactory.getLogger(ServerRealm.class);

    IAuthenticationService                           authenticationService = null;

    private static final String                      AUTHENTICATE          = "ServerRealm.Authenticate";

    private ConcurrentHashMap<String, AnzoPrincipal> principals            = new ConcurrentHashMap<String, AnzoPrincipal>();

    private static final String                      GET_PRINCIPAL         = "ServerRealm.GetPrincipal";

    /**
     * Create a new ServerRealm
     * 
     * @param authenticationService
     *            authentication service which this realm will use
     */
    public ServerRealm(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private static final String FAILED_AUTH = "Failed to authenticate user: ";

    /**
     * Authenticate a user with the authentication service
     * 
     * @param userId
     *            userid to authentication
     * @param credentials
     *            password to authenticate
     * @param request
     *            request to authenticate
     * @return principal if authentication passed
     */
    public AnzoPrincipal authenticate(String userId, Object credentials, Request request) {
        IOperationContext context = new BaseOperationContext(AUTHENTICATE, BaseOperationContext.generateOperationId(), null);
        context.setMDC();
        try {
            if (userId != null) {
                userId = URLDecoder.decode(userId, Constants.byteEncoding);
            }
            if (credentials != null && credentials instanceof String) {
                credentials = URLDecoder.decode((String) credentials, Constants.byteEncoding);
            }
            AnzoPrincipal principal = authenticationService.authenticateUser(context, userId, (String) credentials);

            if (principal != null) {
                principals.put(userId, principal);
                request.setAttribute(SerializationConstants.authenticationURI, principal.getUserURI());
                request.setAttribute(SerializationConstants.userPrincipal, principal);
                request.setAuthentication(new BasicUserAuthorization(principal, Constraint.__BASIC_AUTH));
            }
            return principal;
        } catch (IOException ae) {
            if (log.isErrorEnabled()) {
                log.error(LogUtils.SECURITY_MARKER, FAILED_AUTH.concat(userId), ae);
            }
            throw new AnzoRuntimeException(ExceptionConstants.IO.READ_ERROR, ae);
        } catch (AnzoException ae) {
            if (log.isErrorEnabled()) {
                log.error(LogUtils.SECURITY_MARKER, FAILED_AUTH.concat(userId == null ? "null" : userId), ae);
            }
            throw new AnzoRuntimeException(ae);
        } finally {
            context.clearMDC();
        }
    }

    /**
     * get principal for given userid
     * 
     * @param username
     *            id of user to get
     * @return principal for given userid
     */
    public AnzoPrincipal getPrincipal(String username) {
        IOperationContext context = new BaseOperationContext(GET_PRINCIPAL, BaseOperationContext.generateOperationId(), null);
        context.setMDC();
        try {
            if (username != null) {
                username = URLDecoder.decode(username, Constants.byteEncoding);
            }

            AnzoPrincipal principal = authenticationService.getUserPrincipal(context, username);

            return principal;
        } catch (IOException ae) {
            if (log.isErrorEnabled()) {
                log.error(LogUtils.SECURITY_MARKER, FAILED_AUTH.concat(username), ae);
            }
            throw new AnzoRuntimeException(ExceptionConstants.IO.READ_ERROR, ae);
        } catch (AnzoException ae) {
            if (log.isErrorEnabled()) {
                log.error(LogUtils.SECURITY_MARKER, FAILED_AUTH.concat(username), ae);
            }
            throw new AnzoRuntimeException(ae);
        } finally {
            context.clearMDC();
        }
    }

}
