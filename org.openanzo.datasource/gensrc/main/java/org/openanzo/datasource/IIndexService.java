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
 * Index Service interface
 * Operations related to quering the index data on the server
 * @author Generated Code
 *
 */
public interface IIndexService extends IStatisticsProvider ,org.openanzo.datasource.IDatasourceComponent{
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "IndexService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.datasource.IndexServiceStats getStatistics();
    */
	/**Constant for parameter numberOfResults */
	public static final String PARAM_NUMBER_OF_RESULTS = "numberOfResults";
	/**Constant for parameter offset */
	public static final String PARAM_OFFSET = "offset";
	/**Constant for parameter query */
	public static final String PARAM_QUERY = "query";
	/**Constant for parameter queryBody */
	public static final String PARAM_QUERY_BODY = "queryBody";
	/**queryIndex operation name constant */
    public static final String QUERY_INDEX = "queryIndex";
    /**
     * Run a query against the index on the server and returns the results in a collection of statements.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param query
     *            Sparql query text.
     * @param queryBody
     *            Sparql query text.
     * @param offset
     *            Offset into the number of results to return
     * @param numberOfResults
     *            Max number of results to return
     * @return Collection of statements that match the index query.
     * @throws AnzoException
     */
    public java.util.Collection<org.openanzo.rdf.Statement> queryIndex(IOperationContext context,String query,String queryBody,int offset,int numberOfResults) throws AnzoException;

    /**
     * Run a query against the index on the server and returns the results in a collection of statements.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param query
     *            Sparql query text.
     * @param reader
     *            Sparql query text.
     * @param offset
     *            Offset into the number of results to return
     * @param numberOfResults
     *            Max number of results to return
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void queryIndex(IOperationContext context,String query,String reader,int offset,int numberOfResults, java.io.Writer output, String resultFormat) throws AnzoException;
}
