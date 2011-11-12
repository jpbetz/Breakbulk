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
package org.openanzo.combus.listeners;
import javax.jms.MessageProducer;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.openanzo.combus.endpoint.BaseServiceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IAuthenticationService;

 /**
 * Query Service combus listener interface
 * @author Generated Code
 */

public class CombusQueryServiceListener extends BaseServiceListener {
	/** Service's Name in {@link String} form */
    public static final String SERVICE_ENDPOINT_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "CombusQueryServiceListener";


    /** Stats for object*/
    protected org.openanzo.services.DynamicServiceStats stats=null;

   /** Service interface*/
    protected org.openanzo.datasource.IQueryService iQueryService=null;
    
    /**Queue Name Prefix*/
    protected String queueNamePrefix=null;

    /**
     * Create a new JMSQueryServiceListener
     * @param authenticationService Authentication service used by this listener
     * @param _service Service for which listener is handling requests
     * @param queueNamePrefix Prefix for the queue name on which this listener is listening
     */
    public CombusQueryServiceListener(IAuthenticationService authenticationService,org.openanzo.datasource.IQueryService _service,String queueNamePrefix) {
        super(SERVICE_ENDPOINT_NAME,authenticationService);
        this.iQueryService =_service;
        this.queueNamePrefix=queueNamePrefix;
        stats=new org.openanzo.services.DynamicServiceStats(org.openanzo.datasource.IQueryService.ASK_QUERY,org.openanzo.datasource.IQueryService.CANCEL,org.openanzo.datasource.IQueryService.QUERY);
    }

    /**
     *  Statistics object for this service
     * @return the stats object for this service
     */
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }

    public String getQueueName() {
        return "services/"+((queueNamePrefix!=null)?queueNamePrefix:"")+"query";
    }

   
    public TextMessage handleMessage(IOperationContext context, Destination replyTo, String resultFormat, String operation, TextMessage request, MessageProducer messageProducer) throws JMSException, AnzoException {
        verifyCaller(context);
        TextMessage response = null;
if(org.openanzo.datasource.IQueryService.ASK_QUERY.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean defaultNamedGraphsFormatExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_DEFAULT_NAMED_GRAPHSFormat);
				String defaultNamedGraphsFormat=(defaultNamedGraphsFormatExists)?request.getStringProperty(org.openanzo.datasource.IQueryService.PARAM_DEFAULT_NAMED_GRAPHSFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
				boolean defaultNamedGraphsExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_DEFAULT_NAMED_GRAPHS);
                java.util.Set<org.openanzo.rdf.URI> defaultNamedGraphs = (defaultNamedGraphsExists)?org.openanzo.services.serialization.transport.URISetSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_DEFAULT_NAMED_GRAPHS, defaultNamedGraphsFormat):null;
	
				boolean namedGraphsFormatExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_NAMED_GRAPHSFormat);
				String namedGraphsFormat=(namedGraphsFormatExists)?request.getStringProperty(org.openanzo.datasource.IQueryService.PARAM_NAMED_GRAPHSFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
				boolean namedGraphsExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_NAMED_GRAPHS);
                java.util.Set<org.openanzo.rdf.URI> namedGraphs = (namedGraphsExists)?org.openanzo.services.serialization.transport.URISetSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_NAMED_GRAPHS, namedGraphsFormat):null;
	
				boolean namedDatasetsFormatExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_NAMED_DATASETSFormat);
				String namedDatasetsFormat=(namedDatasetsFormatExists)?request.getStringProperty(org.openanzo.datasource.IQueryService.PARAM_NAMED_DATASETSFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
				boolean namedDatasetsExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_NAMED_DATASETS);
                java.util.Set<org.openanzo.rdf.URI> namedDatasets = (namedDatasetsExists)?org.openanzo.services.serialization.transport.URISetSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_NAMED_DATASETS, namedDatasetsFormat):null;
	
				String query=request.getText();
			
				boolean queryBodyExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_QUERY_BODY);
                String queryBody = (queryBodyExists)?org.openanzo.services.serialization.transport.StringSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_QUERY_BODY, null):null;
	
				boolean baseURIExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_BASE_URI);
                org.openanzo.rdf.URI baseURI = (baseURIExists)?org.openanzo.services.serialization.transport.URISerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_BASE_URI, null):null;
	
				boolean currentDataExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_CURRENT_DATA);
                boolean currentData = (currentDataExists)?org.openanzo.services.serialization.transport.BooleanSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_CURRENT_DATA, null):false;
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iQueryService.askQuery(context,defaultNamedGraphs,namedGraphs,namedDatasets,query,queryBody,baseURI,currentData, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("askQuery",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IQueryService.CANCEL.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean operationIdExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_OPERATION_ID);
				if(!operationIdExists){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IQueryService.PARAM_OPERATION_ID);
				}
                String operationId = org.openanzo.services.serialization.transport.StringSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_OPERATION_ID, null);
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iQueryService.cancel(context,operationId, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("cancel",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IQueryService.QUERY.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean defaultNamedGraphsFormatExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_DEFAULT_NAMED_GRAPHSFormat);
				String defaultNamedGraphsFormat=(defaultNamedGraphsFormatExists)?request.getStringProperty(org.openanzo.datasource.IQueryService.PARAM_DEFAULT_NAMED_GRAPHSFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
				boolean defaultNamedGraphsExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_DEFAULT_NAMED_GRAPHS);
                java.util.Set<org.openanzo.rdf.URI> defaultNamedGraphs = (defaultNamedGraphsExists)?org.openanzo.services.serialization.transport.URISetSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_DEFAULT_NAMED_GRAPHS, defaultNamedGraphsFormat):null;
	
				boolean namedGraphsFormatExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_NAMED_GRAPHSFormat);
				String namedGraphsFormat=(namedGraphsFormatExists)?request.getStringProperty(org.openanzo.datasource.IQueryService.PARAM_NAMED_GRAPHSFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
				boolean namedGraphsExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_NAMED_GRAPHS);
                java.util.Set<org.openanzo.rdf.URI> namedGraphs = (namedGraphsExists)?org.openanzo.services.serialization.transport.URISetSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_NAMED_GRAPHS, namedGraphsFormat):null;
	
				boolean namedDatasetsFormatExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_NAMED_DATASETSFormat);
				String namedDatasetsFormat=(namedDatasetsFormatExists)?request.getStringProperty(org.openanzo.datasource.IQueryService.PARAM_NAMED_DATASETSFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
				boolean namedDatasetsExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_NAMED_DATASETS);
                java.util.Set<org.openanzo.rdf.URI> namedDatasets = (namedDatasetsExists)?org.openanzo.services.serialization.transport.URISetSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_NAMED_DATASETS, namedDatasetsFormat):null;
	
				boolean queryExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_QUERY);
                String query = (queryExists)?org.openanzo.services.serialization.transport.StringSerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_QUERY, null):null;
	
				String queryBody=request.getText();
			
				boolean baseURIExists=request.propertyExists(org.openanzo.datasource.IQueryService.PARAM_BASE_URI);
                org.openanzo.rdf.URI baseURI = (baseURIExists)?org.openanzo.services.serialization.transport.URISerializer.deserialize(messageWrapper,org.openanzo.datasource.IQueryService.PARAM_BASE_URI, null):null;
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iQueryService.query(context,defaultNamedGraphs,namedGraphs,namedDatasets,query,queryBody,baseURI, output,resultFormat);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("query",(System.currentTimeMillis() - start));
           	 	}
        	}
		} else {
	    	throw new AnzoException(ExceptionConstants.SERVER.UNKNOWN_OPERATION_ERROR, operation);
	    }
	    return response;
    }
}
