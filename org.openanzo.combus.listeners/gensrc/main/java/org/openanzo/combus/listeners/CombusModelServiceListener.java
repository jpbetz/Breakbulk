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
 * Model Service combus listener interface
 * @author Generated Code
 */

public class CombusModelServiceListener extends BaseServiceListener {
	/** Service's Name in {@link String} form */
    public static final String SERVICE_ENDPOINT_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "CombusModelServiceListener";


    /** Stats for object*/
    protected org.openanzo.services.DynamicServiceStats stats=null;

   /** Service interface*/
    protected org.openanzo.datasource.IModelService iModelService=null;
    
    /**Queue Name Prefix*/
    protected String queueNamePrefix=null;

    /**
     * Create a new JMSModelServiceListener
     * @param authenticationService Authentication service used by this listener
     * @param _service Service for which listener is handling requests
     * @param queueNamePrefix Prefix for the queue name on which this listener is listening
     */
    public CombusModelServiceListener(IAuthenticationService authenticationService,org.openanzo.datasource.IModelService _service,String queueNamePrefix) {
        super(SERVICE_ENDPOINT_NAME,authenticationService);
        this.iModelService =_service;
        this.queueNamePrefix=queueNamePrefix;
        stats=new org.openanzo.services.DynamicServiceStats(org.openanzo.datasource.IModelService.FIND_STATEMENTS,org.openanzo.datasource.IModelService.CONTAINS_NAMED_GRAPH,org.openanzo.datasource.IModelService.GET_NAMED_GRAPH_REVISION,org.openanzo.datasource.IModelService.GET_SIZE,org.openanzo.datasource.IModelService.GET_STORED_NAMED_GRAPHS,org.openanzo.datasource.IModelService.GET_URI_FOR_UUID,org.openanzo.datasource.IModelService.GET_UUIDFOR_URI,org.openanzo.datasource.IModelService.RESOLVE_NAMED_DATASET);
    }

    /**
     *  Statistics object for this service
     * @return the stats object for this service
     */
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }

    public String getQueueName() {
        return "services/"+((queueNamePrefix!=null)?queueNamePrefix:"")+"model";
    }

   
    public TextMessage handleMessage(IOperationContext context, Destination replyTo, String resultFormat, String operation, TextMessage request, MessageProducer messageProducer) throws JMSException, AnzoException {
        verifyCaller(context);
        TextMessage response = null;
if(org.openanzo.datasource.IModelService.FIND_STATEMENTS.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean subjectExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_SUBJECT);
                org.openanzo.rdf.Resource subject = (subjectExists)?org.openanzo.services.serialization.transport.ResourceSerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_SUBJECT, null):null;
	
				boolean predicateExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_PREDICATE);
                org.openanzo.rdf.URI predicate = (predicateExists)?org.openanzo.services.serialization.transport.URISerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_PREDICATE, null):null;
	
				boolean objectExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_OBJECT);
                org.openanzo.rdf.Value object = (objectExists)?org.openanzo.services.serialization.transport.ValueSerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_OBJECT, null):null;
	
				boolean namedGraphUriFormatExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URIFormat);
				String namedGraphUriFormat=(namedGraphUriFormatExists)?request.getStringProperty(org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URIFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
				boolean namedGraphUriExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI);
                org.openanzo.rdf.URI[] namedGraphUri = (namedGraphUriExists)?org.openanzo.services.serialization.transport.URIArraySetSerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI, namedGraphUriFormat):null;
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iModelService.findStatements(context,subject,predicate,object,namedGraphUri, output,resultFormat);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("findStatements",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IModelService.CONTAINS_NAMED_GRAPH.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean namedGraphUriExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI);
				if(!namedGraphUriExists){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI);
				}
                org.openanzo.rdf.URI namedGraphUri = org.openanzo.services.serialization.transport.URISerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI, null);
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iModelService.containsNamedGraph(context,namedGraphUri, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("containsNamedGraph",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IModelService.GET_NAMED_GRAPH_REVISION.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean namedGraphUriExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI);
				if(!namedGraphUriExists){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI);
				}
                org.openanzo.rdf.URI namedGraphUri = org.openanzo.services.serialization.transport.URISerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI, null);
	
				boolean revisionExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_REVISION);
				if(!revisionExists){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IModelService.PARAM_REVISION);
				}
                long revision = org.openanzo.services.serialization.transport.LongSerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_REVISION, null);
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iModelService.getNamedGraphRevision(context,namedGraphUri,revision, output,resultFormat);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("getNamedGraphRevision",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IModelService.GET_SIZE.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean namedGraphUriExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI);
				if(!namedGraphUriExists){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI);
				}
                org.openanzo.rdf.URI namedGraphUri = org.openanzo.services.serialization.transport.URISerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI, null);
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iModelService.getSize(context,namedGraphUri, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("getSize",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IModelService.GET_STORED_NAMED_GRAPHS.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{				
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iModelService.getStoredNamedGraphs(context, output,resultFormat);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("getStoredNamedGraphs",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IModelService.GET_URI_FOR_UUID.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean namedGraphUUIDExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_UUID);
				if(!namedGraphUUIDExists){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_UUID);
				}
                org.openanzo.rdf.URI namedGraphUUID = org.openanzo.services.serialization.transport.URISerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_UUID, null);
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iModelService.getUriForUUID(context,namedGraphUUID, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("getUriForUUID",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IModelService.GET_UUIDFOR_URI.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean namedGraphUriExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI);
				if(!namedGraphUriExists){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI);
				}
                org.openanzo.rdf.URI namedGraphUri = org.openanzo.services.serialization.transport.URISerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_NAMED_GRAPH_URI, null);
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iModelService.getUUIDforUri(context,namedGraphUri, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("getUUIDforUri",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IModelService.RESOLVE_NAMED_DATASET.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean namedDatasetUriExists=request.propertyExists(org.openanzo.datasource.IModelService.PARAM_NAMED_DATASET_URI);
				if(!namedDatasetUriExists){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IModelService.PARAM_NAMED_DATASET_URI);
				}
                org.openanzo.rdf.URI namedDatasetUri = org.openanzo.services.serialization.transport.URISerializer.deserialize(messageWrapper,org.openanzo.datasource.IModelService.PARAM_NAMED_DATASET_URI, null);
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iModelService.resolveNamedDataset(context,namedDatasetUri, output,resultFormat);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("resolveNamedDataset",(System.currentTimeMillis() - start));
           	 	}
        	}
		} else {
	    	throw new AnzoException(ExceptionConstants.SERVER.UNKNOWN_OPERATION_ERROR, operation);
	    }
	    return response;
    }
}
