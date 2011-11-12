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
 * Reset Service interface
 * Operations related to resetint the data on the server
 * @author Generated Code
 *
 */
public interface IResetService extends IStatisticsProvider ,org.openanzo.datasource.IDatasourceComponent{
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "ResetService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.datasource.ResetServiceStats getStatistics();
    */
	/**Constant for parameter checks */
	public static final String PARAM_CHECKS = "checks";
	/**Constant for parameter statements */
	public static final String PARAM_STATEMENTS = "statements";
	/**Constant for parameter checks format */
	public static final String PARAM_CHECKSFormat = "checksFormat";
	/**Constant for parameter statements format */
	public static final String PARAM_STATEMENTSFormat = "statementsFormat";
	/**reset operation name constant */
    public static final String RESET = "reset";
    /**
     * Utility method that resets all data on the Server and reinitializes server to set of provided statements. This should only be used for testing. Operation can be turned off on the server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param statements
     *            Set of statements that are used to reinitialize the server.
     * @param checks
     *            Set of statements that are used to check if the server has reset.
     * @throws AnzoException
     */
    public void reset(IOperationContext context,java.util.Collection<org.openanzo.rdf.Statement> statements,java.util.Collection<org.openanzo.rdf.Statement> checks) throws AnzoException;

    /**
     * Utility method that resets all data on the Server and reinitializes server to set of provided statements. This should only be used for testing. Operation can be turned off on the server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param reader
     *            Set of statements that are used to reinitialize the server.,String
	 * @param readerFormat
     *            format for reader
     * @param checks
     *            Set of statements that are used to check if the server has reset.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void reset(IOperationContext context,String reader,String readerFormat,java.util.Collection<org.openanzo.rdf.Statement> checks, java.io.Writer output) throws AnzoException;
}
