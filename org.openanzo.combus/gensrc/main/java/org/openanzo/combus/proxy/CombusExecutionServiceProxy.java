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
import org.openanzo.combus.BaseCombusProxyService;
 /**
 * Named Service Execution Service interface
 * Operations related to named service execution
 * @author Generated Code
 *
 */
public class CombusExecutionServiceProxy extends BaseCombusProxyService implements org.openanzo.services.IExecutionService{
    /** Stats for object*/
   protected org.openanzo.services.DynamicServiceStats stats=null;
    /**
     * Create a new JMSExecutionServiceProxy
     * @param combusConnection Connection which this proxy class uses to communicate to the server
     *
     */
    public CombusExecutionServiceProxy( org.openanzo.combus.CombusConnection combusConnection) {
        
        super(combusConnection);
        stats=new org.openanzo.services.DynamicServiceStats(EXECUTE_SERVICE);
	
    }

	public String getName(){
		return "CombusExecutionServiceProxy";
	}
	
	public String getDescription(){
		return "Combus  ExecutionService Proxy Service";
	}

    /** Statistics object for this service*/
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }
    
    public java.util.Collection<org.openanzo.rdf.Statement> executeService(IOperationContext context,java.util.Collection<org.openanzo.rdf.Statement> statements,org.openanzo.rdf.URI operationUri) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        String _requestBody = null;
		if(statements!=null){
	    _requestBody= org.openanzo.services.serialization.transport.StatementsSerializer.serialize(statements, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
		}
		String resultFormat=org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
		String statementsFormat=org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
        executeService(context,_requestBody,statementsFormat,operationUri,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.StatementsSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void executeService(IOperationContext context,String statements,String statementsFormat,org.openanzo.rdf.URI operationUri, java.io.Writer output, String resultFormat) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(operationUri==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_OPERATION_URI);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, EXECUTE_SERVICE);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            messageWrapper.setProperty(PARAM_STATEMENTSFormat, statementsFormat);
            messageWrapper.setBody(statements);
            org.openanzo.services.serialization.transport.URISerializer.serialize(operationUri,PARAM_OPERATION_URI,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.services.IExecutionService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("executeService",(System.currentTimeMillis() - start));
            }
        }
    }
}
