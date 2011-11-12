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
 * Update Service interface
 * Operations related to updating data on the server
 * @author Generated Code
 *
 */
public class CombusUpdateServiceProxy extends BaseCombusProxyDatasourceService implements org.openanzo.datasource.IUpdateService{
    /** Stats for object*/
   protected org.openanzo.services.DynamicServiceStats stats=null;
   protected CombusDatasource datasource=null;
    /**
     * Create a new JMSUpdateServiceProxy     
	 * @param datasource Datasource to which this service belongs
     * @param combusConnection Connection which this proxy class uses to communicate to the server
     *
     */
    public CombusUpdateServiceProxy( CombusDatasource datasource ,org.openanzo.combus.CombusConnection combusConnection) {
        super(datasource,combusConnection);
        stats=new org.openanzo.services.DynamicServiceStats(IMPORT_STATEMENTS,UPDATE);
	
    }

	public String getName(){
		return "CombusUpdateServiceProxy";
	}
	
	public String getDescription(){
		return "Combus  UpdateService Proxy Service";
	}

    /** Statistics object for this service*/
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }
    
    public org.openanzo.services.IUpdates importStatements(IOperationContext context,java.util.Collection<org.openanzo.rdf.Statement> statements,java.util.Collection<org.openanzo.rdf.Statement> graphTemplate) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        String _requestBody = null;
		if(statements!=null){
	    _requestBody= org.openanzo.services.serialization.transport.StatementsSerializer.serialize(statements, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
		}
		String resultFormat=org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_ANZO_XML;
		String statementsFormat=org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
        importStatements(context,_requestBody,statementsFormat,graphTemplate,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.TransactionsSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void importStatements(IOperationContext context,String statements,String statementsFormat,java.util.Collection<org.openanzo.rdf.Statement> graphTemplate, java.io.Writer output, String resultFormat) throws AnzoException{
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
            messageWrapper.setProperty(SerializationConstants.operation, IMPORT_STATEMENTS);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            messageWrapper.setProperty(PARAM_STATEMENTSFormat, statementsFormat);
            messageWrapper.setBody(statements);
            messageWrapper.setProperty(PARAM_GRAPH_TEMPLATEFormat, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
            if(graphTemplate!=null)
            org.openanzo.services.serialization.transport.StatementsSerializer.serialize(graphTemplate,PARAM_GRAPH_TEMPLATE,org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType(),messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IUpdateService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("importStatements",(System.currentTimeMillis() - start));
            }
        }
    }
    public org.openanzo.services.IUpdates update(IOperationContext context,boolean returnResults,org.openanzo.services.IUpdates transactions) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        if(transactions==null){
             throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_TRANSACTIONS);
        }
        String _requestBody = null;
	    _requestBody= org.openanzo.services.serialization.transport.TransactionsSerializer.serialize(transactions, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_ANZO_XML);
		String resultFormat=org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_ANZO_XML;
		String transactionsFormat=org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_ANZO_XML;
        update(context,returnResults,_requestBody,transactionsFormat,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.TransactionsSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void update(IOperationContext context,boolean returnResults,String transactions,String transactionsFormat, java.io.Writer output, String resultFormat) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(transactions==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_TRANSACTIONS);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, UPDATE);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.BooleanSerializer.serialize(returnResults,PARAM_RETURN_RESULTS,null,messageWrapper);
		
            messageWrapper.setProperty(PARAM_TRANSACTIONSFormat, transactionsFormat);
            messageWrapper.setBody(transactions);
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IUpdateService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("update",(System.currentTimeMillis() - start));
            }
        }
    }
}
