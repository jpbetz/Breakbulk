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
 * Named Service Execution Service interface
 * Operations related to named service execution
 * @author Generated Code
 *
 */
public interface IExecutionService extends IStatisticsProvider {
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "ExecutionService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.services.stats.ExecutionServiceStats getStatistics();
    */
	/**Constant for parameter operationUri */
	public static final String PARAM_OPERATION_URI = "operationUri";
	/**Constant for parameter statements */
	public static final String PARAM_STATEMENTS = "statements";
	/**Constant for parameter statements format */
	public static final String PARAM_STATEMENTSFormat = "statementsFormat";
	/**executeService operation name constant */
    public static final String EXECUTE_SERVICE = "executeService";
    /**
     * executes a named service on this Anzo server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param statements
     *            Set of statements that are used to execute the service.
     * @param operationUri
     *            URI of service and operation to execute
     * @return The result of the service execution conveyed as a collection of statements.
     * @throws AnzoException
     */
    public java.util.Collection<org.openanzo.rdf.Statement> executeService(IOperationContext context,java.util.Collection<org.openanzo.rdf.Statement> statements,org.openanzo.rdf.URI operationUri) throws AnzoException;

    /**
     * executes a named service on this Anzo server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param reader
     *            Set of statements that are used to execute the service.,String
	 * @param readerFormat
     *            format for reader
     * @param operationUri
     *            URI of service and operation to execute
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void executeService(IOperationContext context,String reader,String readerFormat,org.openanzo.rdf.URI operationUri, java.io.Writer output, String resultFormat) throws AnzoException;
}
