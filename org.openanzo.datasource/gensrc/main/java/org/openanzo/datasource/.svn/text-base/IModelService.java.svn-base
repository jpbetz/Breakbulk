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
 * Model Service interface
 * Operations related to updating and quering the data on the server
 * @author Generated Code
 *
 */
public interface IModelService extends IStatisticsProvider ,org.openanzo.datasource.IDatasourceComponent{
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "ModelService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.datasource.ModelServiceStats getStatistics();
    */
	/**Constant for parameter namedDatasetUri */
	public static final String PARAM_NAMED_DATASET_URI = "namedDatasetUri";
	/**Constant for parameter namedGraphUUID */
	public static final String PARAM_NAMED_GRAPH_UUID = "namedGraphUUID";
	/**Constant for parameter namedGraphUri */
	public static final String PARAM_NAMED_GRAPH_URI = "namedGraphUri";
	/**Constant for parameter object */
	public static final String PARAM_OBJECT = "object";
	/**Constant for parameter predicate */
	public static final String PARAM_PREDICATE = "predicate";
	/**Constant for parameter revision */
	public static final String PARAM_REVISION = "revision";
	/**Constant for parameter subject */
	public static final String PARAM_SUBJECT = "subject";
	/**Constant for parameter namedGraphUri format */
	public static final String PARAM_NAMED_GRAPH_URIFormat = "namedGraphUriFormat";
	/**findStatements operation name constant */
    public static final String FIND_STATEMENTS = "findStatements";
    /**
     * Find the set of statements that match a Statement pattern.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param subject
     *            Subject Resource to match, or wildcard if null or equal to Any
     * @param predicate
     *            Predicate URI to match, or wildcard if null or equal to Any
     * @param object
     *            Object Value to match, or wildcard if null or equal to Any
     * @param namedGraphUri
     *            NamedGraph URIs to match, or wildcard if null or equal to Any
     * @return Collection of statements that match the find statements.
     * @throws AnzoException
     */
    public java.util.Collection<org.openanzo.rdf.Statement> findStatements(IOperationContext context,org.openanzo.rdf.Resource subject,org.openanzo.rdf.URI predicate,org.openanzo.rdf.Value object,org.openanzo.rdf.URI[] namedGraphUri) throws AnzoException;

    /**
     * Find the set of statements that match a Statement pattern.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param subject
     *            Subject Resource to match, or wildcard if null or equal to Any
     * @param predicate
     *            Predicate URI to match, or wildcard if null or equal to Any
     * @param object
     *            Object Value to match, or wildcard if null or equal to Any
     * @param namedGraphUri
     *            NamedGraph URIs to match, or wildcard if null or equal to Any
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void findStatements(IOperationContext context,org.openanzo.rdf.Resource subject,org.openanzo.rdf.URI predicate,org.openanzo.rdf.Value object,org.openanzo.rdf.URI[] namedGraphUri, java.io.Writer output, String resultFormat) throws AnzoException;
	/**containsNamedGraph operation name constant */
    public static final String CONTAINS_NAMED_GRAPH = "containsNamedGraph";
    /**
     * Return true if model contains this NamedGraph.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            URI of NamedGraph to retrieve
     * @return True if model contains given namedgraph.
     * @throws AnzoException
     */
    public boolean containsNamedGraph(IOperationContext context,org.openanzo.rdf.URI namedGraphUri) throws AnzoException;

    /**
     * Return true if model contains this NamedGraph.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            URI of NamedGraph to retrieve
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void containsNamedGraph(IOperationContext context,org.openanzo.rdf.URI namedGraphUri, java.io.Writer output) throws AnzoException;
	/**getNamedGraphRevision operation name constant */
    public static final String GET_NAMED_GRAPH_REVISION = "getNamedGraphRevision";
    /**
     * Get an INamedGraphWithMetaData for a specific NamedGraph at the specific revision.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            URI of NamedGraph to retrieve
     * @param revision
     *            Revision of NamedGraph to retrieve, -1 for the current revision
     * @return INamedGraphWithMetadata conveyed as a collection of statements.
     * @throws AnzoException
     */
    public org.openanzo.rdf.IAnzoGraph getNamedGraphRevision(IOperationContext context,org.openanzo.rdf.URI namedGraphUri,long revision) throws AnzoException;

    /**
     * Get an INamedGraphWithMetaData for a specific NamedGraph at the specific revision.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            URI of NamedGraph to retrieve
     * @param revision
     *            Revision of NamedGraph to retrieve, -1 for the current revision
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void getNamedGraphRevision(IOperationContext context,org.openanzo.rdf.URI namedGraphUri,long revision, java.io.Writer output, String resultFormat) throws AnzoException;
	/**getSize operation name constant */
    public static final String GET_SIZE = "getSize";
    /**
     * Get the size of a NamedGraph.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            URI of NamedGraph to retrieve
     * @return Size of NamedGraph.
     * @throws AnzoException
     */
    public long getSize(IOperationContext context,org.openanzo.rdf.URI namedGraphUri) throws AnzoException;

    /**
     * Get the size of a NamedGraph.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            URI of NamedGraph to retrieve
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void getSize(IOperationContext context,org.openanzo.rdf.URI namedGraphUri, java.io.Writer output) throws AnzoException;
	/**getStoredNamedGraphs operation name constant */
    public static final String GET_STORED_NAMED_GRAPHS = "getStoredNamedGraphs";
    /**
     * Get the set of URIs for the NamedGraphs that user can read.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @return URIs for the NamedGraphs that user can read.
     * @throws AnzoException
     */
    public java.util.Set<org.openanzo.rdf.URI> getStoredNamedGraphs(IOperationContext context) throws AnzoException;

    /**
     * Get the set of URIs for the NamedGraphs that user can read.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void getStoredNamedGraphs(IOperationContext context, java.io.Writer output, String resultFormat) throws AnzoException;
	/**getUriForUUID operation name constant */
    public static final String GET_URI_FOR_UUID = "getUriForUUID";
    /**
     * Get the NamedGraph URI for the given UUID.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUUID
     *            UUID URI of NamedGraph URI to retrieve
     * @return URI of NamedGraph.
     * @throws AnzoException
     */
    public org.openanzo.rdf.URI getUriForUUID(IOperationContext context,org.openanzo.rdf.URI namedGraphUUID) throws AnzoException;

    /**
     * Get the NamedGraph URI for the given UUID.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUUID
     *            UUID URI of NamedGraph URI to retrieve
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void getUriForUUID(IOperationContext context,org.openanzo.rdf.URI namedGraphUUID, java.io.Writer output) throws AnzoException;
	/**getUUIDforUri operation name constant */
    public static final String GET_UUIDFOR_URI = "getUUIDforUri";
    /**
     * Get the NamedGraph UUID for the given URI.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            URI of NamedGraph UUID to retrieve
     * @return UUID of NamedGraph.
     * @throws AnzoException
     */
    public org.openanzo.rdf.URI getUUIDforUri(IOperationContext context,org.openanzo.rdf.URI namedGraphUri) throws AnzoException;

    /**
     * Get the NamedGraph UUID for the given URI.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            URI of NamedGraph UUID to retrieve
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void getUUIDforUri(IOperationContext context,org.openanzo.rdf.URI namedGraphUri, java.io.Writer output) throws AnzoException;
	/**resolveNamedDataset operation name constant */
    public static final String RESOLVE_NAMED_DATASET = "resolveNamedDataset";
    /**
     * Get the set of URIs for a NamedDataset.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedDatasetUri
     *            URI of NamedGraph to retrieve
     * @return URIs for the NamedDataset.
     * @throws AnzoException
     */
    public org.openanzo.glitter.dataset.QueryDataset resolveNamedDataset(IOperationContext context,org.openanzo.rdf.URI namedDatasetUri) throws AnzoException;

    /**
     * Get the set of URIs for a NamedDataset.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedDatasetUri
     *            URI of NamedGraph to retrieve
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void resolveNamedDataset(IOperationContext context,org.openanzo.rdf.URI namedDatasetUri, java.io.Writer output, String resultFormat) throws AnzoException;
}
