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
 * Index Service interface
 * Operations related to quering the index data on the server
 * @author Generated Code
 *
 */
public class CombusIndexServiceProxy extends BaseCombusProxyDatasourceService implements org.openanzo.datasource.IIndexService{
    /** Stats for object*/
   protected org.openanzo.services.DynamicServiceStats stats=null;
   protected CombusDatasource datasource=null;
    /**
     * Create a new JMSIndexServiceProxy     
	 * @param datasource Datasource to which this service belongs
     * @param combusConnection Connection which this proxy class uses to communicate to the server
     *
     */
    public CombusIndexServiceProxy( CombusDatasource datasource ,org.openanzo.combus.CombusConnection combusConnection) {
        super(datasource,combusConnection);
        stats=new org.openanzo.services.DynamicServiceStats(QUERY_INDEX);
	
    }

	public String getName(){
		return "CombusIndexServiceProxy";
	}
	
	public String getDescription(){
		return "Combus  IndexService Proxy Service";
	}

    /** Statistics object for this service*/
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }
    
    public java.util.Collection<org.openanzo.rdf.Statement> queryIndex(IOperationContext context,String query,String queryBody,int offset,int numberOfResults) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        String _requestBody = null;
		if(queryBody!=null){
	    _requestBody= org.openanzo.services.serialization.transport.StringSerializer.serialize(queryBody, null);
		}
		String resultFormat=org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
        queryIndex(context,query,_requestBody,offset,numberOfResults,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.StatementsSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void queryIndex(IOperationContext context,String query,String queryBody,int offset,int numberOfResults, java.io.Writer output, String resultFormat) throws AnzoException{
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
            messageWrapper.setProperty(SerializationConstants.operation, QUERY_INDEX);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            if(query!=null)
            org.openanzo.services.serialization.transport.StringSerializer.serialize(query,PARAM_QUERY,null,messageWrapper);
		
            messageWrapper.setBody(queryBody);
            org.openanzo.services.serialization.transport.IntSerializer.serialize(offset,PARAM_OFFSET,null,messageWrapper);
		
            org.openanzo.services.serialization.transport.IntSerializer.serialize(numberOfResults,PARAM_NUMBER_OF_RESULTS,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IIndexService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("queryIndex",(System.currentTimeMillis() - start));
            }
        }
    }
}
