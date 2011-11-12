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
 * Update Service interface
 * Operations related to updating data on the server
 * @author Generated Code
 *
 */
public interface IUpdateService extends IStatisticsProvider ,org.openanzo.datasource.IDatasourceComponent{
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "UpdateService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.datasource.UpdateServiceStats getStatistics();
    */
	/**Constant for parameter graphTemplate */
	public static final String PARAM_GRAPH_TEMPLATE = "graphTemplate";
	/**Constant for parameter returnResults */
	public static final String PARAM_RETURN_RESULTS = "returnResults";
	/**Constant for parameter statements */
	public static final String PARAM_STATEMENTS = "statements";
	/**Constant for parameter transactions */
	public static final String PARAM_TRANSACTIONS = "transactions";
	/**Constant for parameter graphTemplate format */
	public static final String PARAM_GRAPH_TEMPLATEFormat = "graphTemplateFormat";
	/**Constant for parameter statements format */
	public static final String PARAM_STATEMENTSFormat = "statementsFormat";
	/**Constant for parameter transactions format */
	public static final String PARAM_TRANSACTIONSFormat = "transactionsFormat";
	/**importStatements operation name constant */
    public static final String IMPORT_STATEMENTS = "importStatements";
    /**
     * Utility method that imports a set of statements to the server, using the graph template to create new graphs if they do not exist.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param statements
     *            Set of statements that are used to import to the server.
     * @param graphTemplate
     *            Set of statements that are used to initialize new graphs.
     * @return If returnResults is true, IUpdates will include the changes that occured on the server due to this update or if the transaction failed, the set of errors. If returnResults is false, only errors will be returned.
     * @throws AnzoException
     */
    public org.openanzo.services.IUpdates importStatements(IOperationContext context,java.util.Collection<org.openanzo.rdf.Statement> statements,java.util.Collection<org.openanzo.rdf.Statement> graphTemplate) throws AnzoException;

    /**
     * Utility method that imports a set of statements to the server, using the graph template to create new graphs if they do not exist.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param reader
     *            Set of statements that are used to import to the server.,String
	 * @param readerFormat
     *            format for reader
     * @param graphTemplate
     *            Set of statements that are used to initialize new graphs.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void importStatements(IOperationContext context,String reader,String readerFormat,java.util.Collection<org.openanzo.rdf.Statement> graphTemplate, java.io.Writer output, String resultFormat) throws AnzoException;
	/**update operation name constant */
    public static final String UPDATE = "update";
    /**
     * Sends a set of transactions to the server to be processed.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param returnResults
     *            Should operation return the additions and deletions within the IUpdates object.
     * @param transactions
     *            Set of transactions to commit on the server.
     * @return If returnResults is true, IUpdates will include the changes that occured on the server due to this update or if the transaction failed, the set of errors. If returnResults is false, only errors will be returned.
     * @throws AnzoException
     */
    public org.openanzo.services.IUpdates update(IOperationContext context,boolean returnResults,org.openanzo.services.IUpdates transactions) throws AnzoException;

    /**
     * Sends a set of transactions to the server to be processed.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param returnResults
     *            Should operation return the additions and deletions within the IUpdates object.
     * @param reader
     *            Set of transactions to commit on the server.,String
	 * @param readerFormat
     *            format for reader
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void update(IOperationContext context,boolean returnResults,String reader,String readerFormat, java.io.Writer output, String resultFormat) throws AnzoException;
}
