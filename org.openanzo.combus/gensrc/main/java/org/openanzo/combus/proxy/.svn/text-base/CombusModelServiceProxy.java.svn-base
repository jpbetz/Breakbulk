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
package org.openanzo.combus.proxy;
import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
//import org.openanzo.rdf.Constants;
import org.openanzo.services.IOperationContext;
import org.openanzo.rdf.utils.SerializationConstants;
//import org.openanzo.rdf.URI;
import org.openanzo.combus.CombusDatasource;
import org.openanzo.combus.BaseCombusProxyDatasourceService;
 /**
 * Model Service interface
 * Operations related to updating and quering the data on the server
 * @author Generated Code
 *
 */
public class CombusModelServiceProxy extends BaseCombusProxyDatasourceService implements org.openanzo.datasource.IModelService{
    /** Stats for object*/
   protected org.openanzo.services.DynamicServiceStats stats=null;
   protected CombusDatasource datasource=null;
    /**
     * Create a new JMSModelServiceProxy     
	 * @param datasource Datasource to which this service belongs
     * @param combusConnection Connection which this proxy class uses to communicate to the server
     *
     */
    public CombusModelServiceProxy( CombusDatasource datasource ,org.openanzo.combus.CombusConnection combusConnection) {
        super(datasource,combusConnection);
        stats=new org.openanzo.services.DynamicServiceStats(FIND_STATEMENTS,CONTAINS_NAMED_GRAPH,GET_NAMED_GRAPH_REVISION,GET_SIZE,GET_STORED_NAMED_GRAPHS,GET_URI_FOR_UUID,GET_UUIDFOR_URI,RESOLVE_NAMED_DATASET);
	
    }

	public String getName(){
		return "CombusModelServiceProxy";
	}
	
	public String getDescription(){
		return "Combus  ModelService Proxy Service";
	}

    /** Statistics object for this service*/
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }
    
    public java.util.Collection<org.openanzo.rdf.Statement> findStatements(IOperationContext context,org.openanzo.rdf.Resource subject,org.openanzo.rdf.URI predicate,org.openanzo.rdf.Value object,org.openanzo.rdf.URI[] namedGraphUri) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
		String resultFormat=org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
        findStatements(context,subject,predicate,object,namedGraphUri,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.StatementsSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void findStatements(IOperationContext context,org.openanzo.rdf.Resource subject,org.openanzo.rdf.URI predicate,org.openanzo.rdf.Value object,org.openanzo.rdf.URI[] namedGraphUri, java.io.Writer output, String resultFormat) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, FIND_STATEMENTS);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            if(subject!=null)
            org.openanzo.services.serialization.transport.ResourceSerializer.serialize(subject,PARAM_SUBJECT,null,messageWrapper);
		
            if(predicate!=null)
            org.openanzo.services.serialization.transport.URISerializer.serialize(predicate,PARAM_PREDICATE,null,messageWrapper);
		
            if(object!=null)
            org.openanzo.services.serialization.transport.ValueSerializer.serialize(object,PARAM_OBJECT,null,messageWrapper);
		
            messageWrapper.setProperty(PARAM_NAMED_GRAPH_URIFormat, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT);
            if(namedGraphUri!=null)
            org.openanzo.services.serialization.transport.URIArraySetSerializer.serialize(namedGraphUri,PARAM_NAMED_GRAPH_URI,org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IModelService.SERVICE_NAME, request, getTimeout());
            try {
	            if (response != null && response.getText() != null) {
	                output.write(response.getText());
	                output.flush();
	            }
	        } catch (IOException ioe) {
	            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);
	        } catch (JMSException jmsex) {
	            throw new AnzoException( ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
	        }
        }finally{
       		if (stats.isEnabled()) {
       		      stats.use("findStatements",(System.currentTimeMillis() - start));
            }
        }
    }
    public boolean containsNamedGraph(IOperationContext context,org.openanzo.rdf.URI namedGraphUri) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        containsNamedGraph(context,namedGraphUri,responseWriter);
		return org.openanzo.services.serialization.transport.BooleanSerializer.deserialize(responseWriter.toString(),null);
	 	
	}

    public void containsNamedGraph(IOperationContext context,org.openanzo.rdf.URI namedGraphUri, java.io.Writer output) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(namedGraphUri==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_NAMED_GRAPH_URI);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.operation, CONTAINS_NAMED_GRAPH);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.URISerializer.serialize(namedGraphUri,PARAM_NAMED_GRAPH_URI,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IModelService.SERVICE_NAME, request, getTimeout());
            try {
	            if (response != null && response.getText() != null) {
	                output.write(response.getText());
	                output.flush();
	            }
	        } catch (IOException ioe) {
	            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);
	        } catch (JMSException jmsex) {
	            throw new AnzoException( ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
	        }
        }finally{
       		if (stats.isEnabled()) {
       		      stats.use("containsNamedGraph",(System.currentTimeMillis() - start));
            }
        }
    }
    public org.openanzo.rdf.IAnzoGraph getNamedGraphRevision(IOperationContext context,org.openanzo.rdf.URI namedGraphUri,long revision) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
		String resultFormat=org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
        getNamedGraphRevision(context,namedGraphUri,revision,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.NamedGraphSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void getNamedGraphRevision(IOperationContext context,org.openanzo.rdf.URI namedGraphUri,long revision, java.io.Writer output, String resultFormat) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(namedGraphUri==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_NAMED_GRAPH_URI);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, GET_NAMED_GRAPH_REVISION);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.URISerializer.serialize(namedGraphUri,PARAM_NAMED_GRAPH_URI,null,messageWrapper);
		
            org.openanzo.services.serialization.transport.LongSerializer.serialize(revision,PARAM_REVISION,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IModelService.SERVICE_NAME, request, getTimeout());
            try {
	            if (response != null && response.getText() != null) {
	                output.write(response.getText());
	                output.flush();
	            }
	        } catch (IOException ioe) {
	            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);
	        } catch (JMSException jmsex) {
	            throw new AnzoException( ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
	        }
        }finally{
       		if (stats.isEnabled()) {
       		      stats.use("getNamedGraphRevision",(System.currentTimeMillis() - start));
            }
        }
    }
    public long getSize(IOperationContext context,org.openanzo.rdf.URI namedGraphUri) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        getSize(context,namedGraphUri,responseWriter);
		return org.openanzo.services.serialization.transport.LongSerializer.deserialize(responseWriter.toString(),null);
	 	
	}

    public void getSize(IOperationContext context,org.openanzo.rdf.URI namedGraphUri, java.io.Writer output) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(namedGraphUri==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_NAMED_GRAPH_URI);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.operation, GET_SIZE);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.URISerializer.serialize(namedGraphUri,PARAM_NAMED_GRAPH_URI,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IModelService.SERVICE_NAME, request, getTimeout());
            try {
	            if (response != null && response.getText() != null) {
	                output.write(response.getText());
	                output.flush();
	            }
	        } catch (IOException ioe) {
	            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);
	        } catch (JMSException jmsex) {
	            throw new AnzoException( ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
	        }
        }finally{
       		if (stats.isEnabled()) {
       		      stats.use("getSize",(System.currentTimeMillis() - start));
            }
        }
    }
    public java.util.Set<org.openanzo.rdf.URI> getStoredNamedGraphs(IOperationContext context) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
		String resultFormat=org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
        getStoredNamedGraphs(context,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.URISetSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void getStoredNamedGraphs(IOperationContext context, java.io.Writer output, String resultFormat) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, GET_STORED_NAMED_GRAPHS);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IModelService.SERVICE_NAME, request, getTimeout());
            try {
	            if (response != null && response.getText() != null) {
	                output.write(response.getText());
	                output.flush();
	            }
	        } catch (IOException ioe) {
	            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);
	        } catch (JMSException jmsex) {
	            throw new AnzoException( ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
	        }
        }finally{
       		if (stats.isEnabled()) {
       		      stats.use("getStoredNamedGraphs",(System.currentTimeMillis() - start));
            }
        }
    }
    public org.openanzo.rdf.URI getUriForUUID(IOperationContext context,org.openanzo.rdf.URI namedGraphUUID) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        getUriForUUID(context,namedGraphUUID,responseWriter);
		return org.openanzo.services.serialization.transport.URISerializer.deserialize(responseWriter.toString(),null);
	 	
	}

    public void getUriForUUID(IOperationContext context,org.openanzo.rdf.URI namedGraphUUID, java.io.Writer output) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(namedGraphUUID==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_NAMED_GRAPH_UUID);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.operation, GET_URI_FOR_UUID);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.URISerializer.serialize(namedGraphUUID,PARAM_NAMED_GRAPH_UUID,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IModelService.SERVICE_NAME, request, getTimeout());
            try {
	            if (response != null && response.getText() != null) {
	                output.write(response.getText());
	                output.flush();
	            }
	        } catch (IOException ioe) {
	            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);
	        } catch (JMSException jmsex) {
	            throw new AnzoException( ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
	        }
        }finally{
       		if (stats.isEnabled()) {
       		      stats.use("getUriForUUID",(System.currentTimeMillis() - start));
            }
        }
    }
    public org.openanzo.rdf.URI getUUIDforUri(IOperationContext context,org.openanzo.rdf.URI namedGraphUri) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        getUUIDforUri(context,namedGraphUri,responseWriter);
		return org.openanzo.services.serialization.transport.URISerializer.deserialize(responseWriter.toString(),null);
	 	
	}

    public void getUUIDforUri(IOperationContext context,org.openanzo.rdf.URI namedGraphUri, java.io.Writer output) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(namedGraphUri==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_NAMED_GRAPH_URI);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.operation, GET_UUIDFOR_URI);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.URISerializer.serialize(namedGraphUri,PARAM_NAMED_GRAPH_URI,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IModelService.SERVICE_NAME, request, getTimeout());
            try {
	            if (response != null && response.getText() != null) {
	                output.write(response.getText());
	                output.flush();
	            }
	        } catch (IOException ioe) {
	            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);
	        } catch (JMSException jmsex) {
	            throw new AnzoException( ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
	        }
        }finally{
       		if (stats.isEnabled()) {
       		      stats.use("getUUIDforUri",(System.currentTimeMillis() - start));
            }
        }
    }
    public org.openanzo.glitter.dataset.QueryDataset resolveNamedDataset(IOperationContext context,org.openanzo.rdf.URI namedDatasetUri) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
		String resultFormat=org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
        resolveNamedDataset(context,namedDatasetUri,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.QueryUriSetSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void resolveNamedDataset(IOperationContext context,org.openanzo.rdf.URI namedDatasetUri, java.io.Writer output, String resultFormat) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(namedDatasetUri==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_NAMED_DATASET_URI);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, RESOLVE_NAMED_DATASET);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.URISerializer.serialize(namedDatasetUri,PARAM_NAMED_DATASET_URI,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IModelService.SERVICE_NAME, request, getTimeout());
            try {
	            if (response != null && response.getText() != null) {
	                output.write(response.getText());
	                output.flush();
	            }
	        } catch (IOException ioe) {
	            throw new AnzoException( ExceptionConstants.IO.WRITE_ERROR, ioe);
	        } catch (JMSException jmsex) {
	            throw new AnzoException( ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
	        }
        }finally{
       		if (stats.isEnabled()) {
       		      stats.use("resolveNamedDataset",(System.currentTimeMillis() - start));
            }
        }
    }
}
