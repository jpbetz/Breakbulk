/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Revision:	$Id$
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *	   Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.services.IStatisticsProvider;
import org.openanzo.services.IOperationContext;
import org.openanzo.rdf.URI;

 /**
 * Authentication Service interface
 * Operations related to authentication and roles.
 * @author Generated Code
 *
 */
public interface IAuthenticationService extends IStatisticsProvider {
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "AuthenticationService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.services.stats.AuthenticationServiceStats getStatistics();
    */
	/**Constant for parameter password */
	public static final String PARAM_PASSWORD = "password";
	/**Constant for parameter userId */
	public static final String PARAM_USER_ID = "userId";
	/**authenticateUser operation name constant */
    public static final String AUTHENTICATE_USER = "authenticateUser";
    /**
     * Authenticate a User.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param userId
     *            The id the user is authenticating against.
     * @param password
     *            The password for the id the user is authenticating against.
     * @return User's URI.
     * @throws AnzoException
     */
    public org.openanzo.services.AnzoPrincipal authenticateUser(IOperationContext context,String userId,String password) throws AnzoException;

    /**
     * Authenticate a User.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param userId
     *            The id the user is authenticating against.
     * @param password
     *            The password for the id the user is authenticating against.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void authenticateUser(IOperationContext context,String userId,String password, java.io.Writer output, String resultFormat) throws AnzoException;
	/**getUserPrincipal operation name constant */
    public static final String GET_USER_PRINCIPAL = "getUserPrincipal";
    /**
     * Get a User's URI.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param userId
     *            The id of the user for which to retrieve a URI.
     * @return URI.
     * @throws AnzoException
     */
    public org.openanzo.services.AnzoPrincipal getUserPrincipal(IOperationContext context,String userId) throws AnzoException;

    /**
     * Get a User's URI.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param userId
     *            The id of the user for which to retrieve a URI.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void getUserPrincipal(IOperationContext context,String userId, java.io.Writer output, String resultFormat) throws AnzoException;
}
