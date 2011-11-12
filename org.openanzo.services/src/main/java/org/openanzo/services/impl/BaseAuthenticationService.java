/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 27, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.impl;

import java.io.Writer;
import java.util.concurrent.CopyOnWriteArraySet;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUserRolesExtender;

/**
 * Base implementation of service which is in charge of authentication and authorization within the server.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseAuthenticationService implements IAuthenticationService {

    private final DynamicServiceStats                 stats         = new DynamicServiceStats(AUTHENTICATE_USER, GET_USER_PRINCIPAL);

    protected CopyOnWriteArraySet<IUserRolesExtender> roleExtenders = new CopyOnWriteArraySet<IUserRolesExtender>();

    /**
     * Create a BaseAuthorizationService
     */
    public BaseAuthenticationService() {
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    public void registerRoleExtender(IUserRolesExtender extender) {
        roleExtenders.add(extender);
    }

    public void unregisterRoleExtender(IUserRolesExtender extender) {
        roleExtenders.remove(extender);
    }

    public AnzoPrincipal authenticateUser(IOperationContext context, String userName, String password) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            if (userName == null) {
                throw new AnzoException(ExceptionConstants.SERVER.MISSING_ARG, SerializationConstants.userId, "authenticateUser");
            }
            AnzoPrincipal principal = authenticateUserInternal(context, userName, password);
            return principal;
        } finally {
            if (stats.isEnabled()) {
                stats.use(AUTHENTICATE_USER, (System.currentTimeMillis() - start));
            }
        }
    }

    public void authenticateUser(IOperationContext context, String userName, String password, Writer output, String format) throws AnzoException {
        AnzoPrincipal authenticateUser = authenticateUser(context, userName, password);
        org.openanzo.services.serialization.CommonSerializationUtils.writeAnzoPrincipal(authenticateUser, output, format);
    }

    public AnzoPrincipal getUserPrincipal(IOperationContext context, String userName) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            if (userName == null) {
                throw new AnzoException(ExceptionConstants.SERVER.MISSING_ARG, SerializationConstants.userId, "getUserPrincipal");
            }
            return getUserPrincipalInternal(context, userName);
        } finally {
            if (stats.isEnabled()) {
                stats.use(GET_USER_PRINCIPAL, (System.currentTimeMillis() - start));
            }
        }
    }

    public void getUserPrincipal(IOperationContext context, String userName, Writer output, String format) throws AnzoException {
        AnzoPrincipal user = getUserPrincipal(context, userName);
        if (user != null) {
            org.openanzo.services.serialization.CommonSerializationUtils.writeAnzoPrincipal(user, output, format);
        }
    }

    /**
     * Determine the User's {@link AnzoPrincipal} object
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param userName
     *            userName of user for whom to determine principal
     * @return {@link AnzoPrincipal} for user with given userName
     * @throws AnzoException
     *             {@link ExceptionConstants.SERVER#UNKNOWN_USER_ERROR} if specified named graph could not be found
     * @throws AnzoException
     *             {@link ExceptionConstants.DATASOURCE.USER#NOT_FOUND} if specified user could not be found
     * @throws AnzoException
     *             {@link ExceptionConstants.DATASOURCE.USER#GET_USER_BY_ID} if there was an SQL error loading a user via their userName
     */
    protected abstract AnzoPrincipal getUserPrincipalInternal(IOperationContext context, String userName) throws AnzoException;

    /**
     * Authenticate the userName and password, and return {@link AnzoPrincipal} object for specified userName
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param userName
     *            User for this session
     * @param password
     *            Password for this session
     * @return {@link AnzoPrincipal} object for specified userName
     * @throws AnzoException
     *             if there was an exception thrown within the authenticateUserInternal method
     */
    protected abstract AnzoPrincipal authenticateUserInternal(IOperationContext context, String userName, String password) throws AnzoException;

}
