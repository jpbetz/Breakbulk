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
package org.openanzo.datasource;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.services.IStatisticsProvider;
import org.openanzo.services.IOperationContext;
import org.openanzo.rdf.URI;

 /**
 * authorization Service interface
 * Operations related to authorization.
 * @author Generated Code
 *
 */
public interface IAuthorizationService extends IStatisticsProvider ,org.openanzo.datasource.IDatasourceComponent{
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "AuthorizationService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.datasource.AuthorizationServiceStats getStatistics();
    */
	/**Constant for parameter namedGraphUri */
	public static final String PARAM_NAMED_GRAPH_URI = "namedGraphUri";
	/**Constant for parameter privilege */
	public static final String PARAM_PRIVILEGE = "privilege";
	/**getRolesForGraph operation name constant */
    public static final String GET_ROLES_FOR_GRAPH = "getRolesForGraph";
    /**
     * Get the URIs for the roles that have a given privilege on the graph.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            The URI of the graph for which to retrieve roles.
     * @param privilege
     *            Privilege.
     * @return Set of URIs for the Roles for which a user is a member.
     * @throws AnzoException
     */
    public java.util.Set<org.openanzo.rdf.URI> getRolesForGraph(IOperationContext context,org.openanzo.rdf.URI namedGraphUri,org.openanzo.services.Privilege privilege) throws AnzoException;

    /**
     * Get the URIs for the roles that have a given privilege on the graph.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            The URI of the graph for which to retrieve roles.
     * @param privilege
     *            Privilege.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void getRolesForGraph(IOperationContext context,org.openanzo.rdf.URI namedGraphUri,org.openanzo.services.Privilege privilege, java.io.Writer output, String resultFormat) throws AnzoException;
}
