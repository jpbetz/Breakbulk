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
 * Query Service interface
 * Operations related to quering the server
 * @author Generated Code
 *
 */
public interface IQueryService extends IStatisticsProvider ,org.openanzo.datasource.IDatasourceComponent{
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "QueryService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.datasource.QueryServiceStats getStatistics();
    */
	/**Constant for parameter baseURI */
	public static final String PARAM_BASE_URI = "baseURI";
	/**Constant for parameter currentData */
	public static final String PARAM_CURRENT_DATA = "currentData";
	/**Constant for parameter defaultNamedGraphs */
	public static final String PARAM_DEFAULT_NAMED_GRAPHS = "defaultNamedGraphs";
	/**Constant for parameter namedDatasets */
	public static final String PARAM_NAMED_DATASETS = "namedDatasets";
	/**Constant for parameter namedGraphs */
	public static final String PARAM_NAMED_GRAPHS = "namedGraphs";
	/**Constant for parameter operationId */
	public static final String PARAM_OPERATION_ID = "operationId";
	/**Constant for parameter query */
	public static final String PARAM_QUERY = "query";
	/**Constant for parameter queryBody */
	public static final String PARAM_QUERY_BODY = "queryBody";
	/**Constant for parameter defaultNamedGraphs format */
	public static final String PARAM_DEFAULT_NAMED_GRAPHSFormat = "defaultNamedGraphsFormat";
	/**Constant for parameter namedDatasets format */
	public static final String PARAM_NAMED_DATASETSFormat = "namedDatasetsFormat";
	/**Constant for parameter namedGraphs format */
	public static final String PARAM_NAMED_GRAPHSFormat = "namedGraphsFormat";
	/**askQuery operation name constant */
    public static final String ASK_QUERY = "askQuery";
    /**
     * Run a Sparql Ask query on the server and return the results in a QueryResult object.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param defaultNamedGraphs
     *            URIS of NamedGraphs to union together as the defaultModel for the dataset the query is run against.
     * @param namedGraphs
     *            URIS of NamedGraphs for the dataset the query is run against.
     * @param namedDatasets
     *            URIs of datasets that contribute to the query's RDF dataset.
     * @param query
     *            Sparql query text.
     * @param queryBody
     *            Sparql query text.
     * @param baseURI
     *            Base URI for query.
     * @param currentData
     *            Run ask against current, uncommitted data.
     * @return The results of running the query.  Result format is dependent on both the type of query, and the requested format.
     * @throws AnzoException
     */
    public boolean askQuery(IOperationContext context,java.util.Set<org.openanzo.rdf.URI> defaultNamedGraphs,java.util.Set<org.openanzo.rdf.URI> namedGraphs,java.util.Set<org.openanzo.rdf.URI> namedDatasets,String query,String queryBody,org.openanzo.rdf.URI baseURI,boolean currentData) throws AnzoException;

    /**
     * Run a Sparql Ask query on the server and return the results in a QueryResult object.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param defaultNamedGraphs
     *            URIS of NamedGraphs to union together as the defaultModel for the dataset the query is run against.
     * @param namedGraphs
     *            URIS of NamedGraphs for the dataset the query is run against.
     * @param namedDatasets
     *            URIs of datasets that contribute to the query's RDF dataset.
     * @param reader
     *            Sparql query text.
     * @param queryBody
     *            Sparql query text.
     * @param baseURI
     *            Base URI for query.
     * @param currentData
     *            Run ask against current, uncommitted data.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void askQuery(IOperationContext context,java.util.Set<org.openanzo.rdf.URI> defaultNamedGraphs,java.util.Set<org.openanzo.rdf.URI> namedGraphs,java.util.Set<org.openanzo.rdf.URI> namedDatasets,String reader,String queryBody,org.openanzo.rdf.URI baseURI,boolean currentData, java.io.Writer output) throws AnzoException;
	/**cancel operation name constant */
    public static final String CANCEL = "cancel";
    /**
     * Run a Sparql query on the server and return the results in a QueryResult object.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param operationId
     *            OperationId.
     * @return The results of cancelling a querys.
     * @throws AnzoException
     */
    public boolean cancel(IOperationContext context,String operationId) throws AnzoException;

    /**
     * Run a Sparql query on the server and return the results in a QueryResult object.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param operationId
     *            OperationId.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void cancel(IOperationContext context,String operationId, java.io.Writer output) throws AnzoException;
	/**query operation name constant */
    public static final String QUERY = "query";
    /**
     * Run a Sparql query on the server and return the results in a QueryResult object.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param defaultNamedGraphs
     *            URIS of NamedGraphs to union together as the defaultModel for the dataset the query is run against.
     * @param namedGraphs
     *            URIS of NamedGraphs for the dataset the query is run against.
     * @param namedDatasets
     *            URIs of datasets that contribute to the query's RDF dataset.
     * @param query
     *            Sparql query text.
     * @param queryBody
     *            Sparql query text.
     * @param baseURI
     *            Base URI for query.
     * @return The results of running the query.  Result format is dependent on both the type of query, and the requested format.
     * @throws AnzoException
     */
    public org.openanzo.glitter.query.QueryResults query(IOperationContext context,java.util.Set<org.openanzo.rdf.URI> defaultNamedGraphs,java.util.Set<org.openanzo.rdf.URI> namedGraphs,java.util.Set<org.openanzo.rdf.URI> namedDatasets,String query,String queryBody,org.openanzo.rdf.URI baseURI) throws AnzoException;

    /**
     * Run a Sparql query on the server and return the results in a QueryResult object.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param defaultNamedGraphs
     *            URIS of NamedGraphs to union together as the defaultModel for the dataset the query is run against.
     * @param namedGraphs
     *            URIS of NamedGraphs for the dataset the query is run against.
     * @param namedDatasets
     *            URIs of datasets that contribute to the query's RDF dataset.
     * @param query
     *            Sparql query text.
     * @param reader
     *            Sparql query text.
     * @param baseURI
     *            Base URI for query.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void query(IOperationContext context,java.util.Set<org.openanzo.rdf.URI> defaultNamedGraphs,java.util.Set<org.openanzo.rdf.URI> namedGraphs,java.util.Set<org.openanzo.rdf.URI> namedDatasets,String query,String reader,org.openanzo.rdf.URI baseURI, java.io.Writer output, String resultFormat) throws AnzoException;
}
