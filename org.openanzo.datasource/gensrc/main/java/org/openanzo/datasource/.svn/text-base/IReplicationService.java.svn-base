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
 * Replication Service interface
 * Operations related to replicating data from the server
 * @author Generated Code
 *
 */
public interface IReplicationService extends IStatisticsProvider ,org.openanzo.datasource.IDatasourceComponent{
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "ReplicationService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.datasource.ReplicationServiceStats getStatistics();
    */
	/**Constant for parameter batchSize */
	public static final String PARAM_BATCH_SIZE = "batchSize";
	/**Constant for parameter handler */
	public static final String PARAM_HANDLER = "handler";
	/**Constant for parameter namedGraphs */
	public static final String PARAM_NAMED_GRAPHS = "namedGraphs";
	/**Constant for parameter namedGraphs format */
	public static final String PARAM_NAMED_GRAPHSFormat = "namedGraphsFormat";
	/**replicate operation name constant */
    public static final String REPLICATE = "replicate";
    /**
     * Replicates changes between the client and the server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphs
     *            null
     * @param handler
     *            Callback handler for results
     * @param batchSize
     *            null
     * @throws AnzoException
     */
    public void replicate(IOperationContext context,java.util.Collection<org.openanzo.rdf.Statement> namedGraphs,org.openanzo.services.serialization.IReplicationHandler handler,int batchSize) throws AnzoException;

    /**
     * Replicates changes between the client and the server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param reader
     *            null,String
	 * @param readerFormat
     *            format for reader
     * @param batchSize
     *            null
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @param resultFormat
     *            format of result data
     * @throws AnzoException
     */
    public void replicate(IOperationContext context,String reader,String readerFormat,int batchSize, java.io.Writer output, String resultFormat) throws AnzoException;
}
