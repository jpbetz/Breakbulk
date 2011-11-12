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
package org.openanzo.combus;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.openanzo.combus.CombusConnection.IMessageHandler;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.QueryType;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.serialization.CommonSerializationUtils;

/**
 * Query Service interface Operations related to quering the server
 * 
 * @author Generated Code
 * 
 */
public class CombusBatchedQueryServiceProxy extends BaseCombusProxyDatasourceService implements org.openanzo.datasource.IQueryService {
    /** Stats for object */
    protected org.openanzo.services.DynamicServiceStats stats            = null;

    protected CombusDatasource                          datasource       = null;

    /** Constant for parameter batchSize */
    public static final String                          PARAM_BATCH_SIZE = "batchSize";

    /**
     * Create a new JMSQueryServiceProxy
     * 
     * @param datasource
     *            Datasource to which this service belongs
     * @param combusConnection
     *            Connection which this proxy class uses to communicate to the server
     * 
     */
    public CombusBatchedQueryServiceProxy(CombusDatasource datasource, org.openanzo.combus.CombusConnection combusConnection) {
        super(datasource, combusConnection);
        stats = new org.openanzo.services.DynamicServiceStats("askQuery", "query");
    }

    public String getName() {
        return "CombusQueryServiceProxy";
    }

    public String getDescription() {
        return "Combus Batched Query Service Proxy";
    }

    /** Statistics object for this service */
    public org.openanzo.services.DynamicServiceStats getStatistics() {
        return stats;
    }

    public boolean askQuery(IOperationContext context, java.util.Set<org.openanzo.rdf.URI> defaultNamedGraphs, java.util.Set<org.openanzo.rdf.URI> namedGraphs, java.util.Set<org.openanzo.rdf.URI> namedDatasets, String query, String queryBody, org.openanzo.rdf.URI baseURI, boolean currentData) throws AnzoException {
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        String _requestBody = null;
        if (query != null) {
            _requestBody = org.openanzo.services.serialization.transport.StringSerializer.serialize(query, null);
        }
        askQuery(context, defaultNamedGraphs, namedGraphs, namedDatasets, _requestBody, queryBody, baseURI, currentData, responseWriter);
        return org.openanzo.services.serialization.transport.BooleanSerializer.deserialize(responseWriter.toString(), null);

    }

    public void askQuery(IOperationContext context, java.util.Set<org.openanzo.rdf.URI> defaultNamedGraphs, java.util.Set<org.openanzo.rdf.URI> namedGraphs, java.util.Set<org.openanzo.rdf.URI> namedDatasets, String query, String queryBody, org.openanzo.rdf.URI baseURI, boolean currentData, java.io.Writer output) throws AnzoException {
        if (!combusConnection.isConnected()) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper = new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.operation, ASK_QUERY);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }

            messageWrapper.setProperty(PARAM_DEFAULT_NAMED_GRAPHSFormat, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT);
            if (defaultNamedGraphs != null)
                org.openanzo.services.serialization.transport.URISetSerializer.serialize(defaultNamedGraphs, PARAM_DEFAULT_NAMED_GRAPHS, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT, messageWrapper);

            messageWrapper.setProperty(PARAM_NAMED_GRAPHSFormat, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT);
            if (namedGraphs != null)
                org.openanzo.services.serialization.transport.URISetSerializer.serialize(namedGraphs, PARAM_NAMED_GRAPHS, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT, messageWrapper);

            messageWrapper.setProperty(PARAM_NAMED_DATASETSFormat, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT);
            if (namedDatasets != null)
                org.openanzo.services.serialization.transport.URISetSerializer.serialize(namedDatasets, PARAM_NAMED_DATASETS, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT, messageWrapper);

            messageWrapper.setBody(query);
            if (queryBody != null)
                org.openanzo.services.serialization.transport.StringSerializer.serialize(queryBody, PARAM_QUERY_BODY, null, messageWrapper);

            if (baseURI != null)
                org.openanzo.services.serialization.transport.URISerializer.serialize(baseURI, PARAM_BASE_URI, null, messageWrapper);

            org.openanzo.services.serialization.transport.BooleanSerializer.serialize(currentData, PARAM_CURRENT_DATA, null, messageWrapper);

            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IQueryService.SERVICE_NAME, request, getTimeout());
            try {
                if (response != null && response.getText() != null) {
                    output.write(response.getText());
                    output.flush();
                }
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
            } catch (JMSException jmsex) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("askQuery", (System.currentTimeMillis() - start));
            }
        }
    }

    public org.openanzo.glitter.query.QueryResults query(IOperationContext context, java.util.Set<org.openanzo.rdf.URI> defaultNamedGraphs, java.util.Set<org.openanzo.rdf.URI> namedGraphs, java.util.Set<org.openanzo.rdf.URI> namedDatasets, String query, String queryBody, org.openanzo.rdf.URI baseURI) throws AnzoException {
        final String resultFormat = org.openanzo.rdf.RDFFormat.SPARQL.getDefaultMIMEType();
        if (!combusConnection.isConnected()) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper = new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, QUERY);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }

            messageWrapper.setProperty(PARAM_DEFAULT_NAMED_GRAPHSFormat, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT);
            if (defaultNamedGraphs != null)
                org.openanzo.services.serialization.transport.URISetSerializer.serialize(defaultNamedGraphs, PARAM_DEFAULT_NAMED_GRAPHS, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT, messageWrapper);

            messageWrapper.setProperty(PARAM_NAMED_GRAPHSFormat, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT);
            if (namedGraphs != null)
                org.openanzo.services.serialization.transport.URISetSerializer.serialize(namedGraphs, PARAM_NAMED_GRAPHS, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT, messageWrapper);

            messageWrapper.setProperty(PARAM_NAMED_DATASETSFormat, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT);
            if (namedDatasets != null)
                org.openanzo.services.serialization.transport.URISetSerializer.serialize(namedDatasets, PARAM_NAMED_DATASETS, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT, messageWrapper);
            org.openanzo.services.serialization.transport.IntSerializer.serialize(10000, PARAM_BATCH_SIZE, null, messageWrapper);

            if (query != null)
                org.openanzo.services.serialization.transport.StringSerializer.serialize(query, PARAM_QUERY, null, messageWrapper);

            messageWrapper.setBody(queryBody);
            if (baseURI != null)
                org.openanzo.services.serialization.transport.URISerializer.serialize(baseURI, PARAM_BASE_URI, null, messageWrapper);
            final MultiQueryResults queryResults = new MultiQueryResults();
            combusConnection.requestMultipleResponse(context, org.openanzo.datasource.IQueryService.SERVICE_NAME, request, getTimeout(), new IMessageHandler() {
                public void handleMessage(TextMessage message, int seq, boolean done, int totalSize) throws AnzoException {
                    try {
                        String queryType = message.getStringProperty(SerializationConstants.query);
                        String text = message.getText();
                        synchronized (queryResults) {
                            queryResults.handleResults(CommonSerializationUtils.readQueryResult(QueryType.valueOf(queryType), text, resultFormat), totalSize);
                            if (done) {
                                queryResults.done = true;
                                queryResults.notify();
                            }
                        }
                    } catch (JMSException jmsex) {
                        throw new RuntimeException(jmsex);
                    }
                }
            });
            synchronized (queryResults) {
                try {
                    if (!queryResults.done)
                        queryResults.wait();
                } catch (InterruptedException ie) {
                    throw new RuntimeException(ie);
                }
            }
            return queryResults.results;
        } finally {
            if (stats.isEnabled()) {
                stats.use("query", (System.currentTimeMillis() - start));
            }
        }
    }

    public void query(IOperationContext context, Set<URI> defaultNamedGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, String reader, URI baseURI, Writer output, String resultFormat) throws AnzoException {
    }

    private static class MultiQueryResults {
        QueryResults results;

        boolean      done = false;

        void handleResults(QueryResults result, int totalSolutions) {
            if (results == null) {
                results = result;
                results.setTotalSolutions(totalSolutions);
            } else {
                if (results.isConstructResult() || results.isDescribeResult()) {
                    results.getConstructResults().addAll(result.getConstructResults());
                } else if (results.isSelectResult()) {
                    results.getSelectResults().addAll(result.getSelectResults());
                } else {
                }
            }
        }
    }

    public boolean cancel(IOperationContext context, String operationId) throws AnzoException {
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        cancel(context, operationId, responseWriter);
        return org.openanzo.services.serialization.transport.BooleanSerializer.deserialize(responseWriter.toString(), null);

    }

    public void cancel(IOperationContext context, String operationId, java.io.Writer output) throws AnzoException {
        if (!combusConnection.isConnected()) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            if (operationId == null) {
                throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, PARAM_OPERATION_ID);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper = new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.operation, CANCEL);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }

            org.openanzo.services.serialization.transport.StringSerializer.serialize(operationId, PARAM_OPERATION_ID, null, messageWrapper);

            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IQueryService.SERVICE_NAME, request, getTimeout());
            try {
                if (response != null && response.getText() != null) {
                    output.write(response.getText());
                    output.flush();
                }
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
            } catch (JMSException jmsex) {
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("cancel", (System.currentTimeMillis() - start));
            }
        }
    }
}
