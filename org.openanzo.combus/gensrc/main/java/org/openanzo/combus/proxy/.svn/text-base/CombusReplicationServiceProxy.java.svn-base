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
 * Replication Service interface
 * Operations related to replicating data from the server
 * @author Generated Code
 *
 */
public class CombusReplicationServiceProxy extends BaseCombusProxyDatasourceService implements org.openanzo.datasource.IReplicationService{
    /** Stats for object*/
   protected org.openanzo.services.DynamicServiceStats stats=null;
   protected CombusDatasource datasource=null;
    /**
     * Create a new JMSReplicationServiceProxy     
	 * @param datasource Datasource to which this service belongs
     * @param combusConnection Connection which this proxy class uses to communicate to the server
     *
     */
    public CombusReplicationServiceProxy( CombusDatasource datasource ,org.openanzo.combus.CombusConnection combusConnection) {
        super(datasource,combusConnection);
        stats=new org.openanzo.services.DynamicServiceStats(REPLICATE);
	
    }

	public String getName(){
		return "CombusReplicationServiceProxy";
	}
	
	public String getDescription(){
		return "Combus  ReplicationService Proxy Service";
	}

    /** Statistics object for this service*/
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }
    
    public void replicate(IOperationContext context,java.util.Collection<org.openanzo.rdf.Statement> namedGraphs,org.openanzo.services.serialization.IReplicationHandler handler,int batchSize) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        if(namedGraphs==null){
             throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_NAMED_GRAPHS);
        }
        String _requestBody = null;
	    _requestBody= org.openanzo.services.serialization.transport.StatementsSerializer.serialize(namedGraphs, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
		String resultFormat=org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_ANZO_XML;
		String namedGraphsFormat=org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
        replicate(context,_requestBody,namedGraphsFormat,batchSize,responseWriter,resultFormat);
        org.openanzo.services.serialization.transport.ReplicationSerializer.deserialize(responseWriter.toString(),resultFormat,handler);
	}

    public void replicate(IOperationContext context,String namedGraphs,String namedGraphsFormat,int batchSize, java.io.Writer output, String resultFormat) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(namedGraphs==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_NAMED_GRAPHS);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, REPLICATE);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            messageWrapper.setProperty(PARAM_NAMED_GRAPHSFormat, namedGraphsFormat);
            messageWrapper.setBody(namedGraphs);
            org.openanzo.services.serialization.transport.IntSerializer.serialize(batchSize,PARAM_BATCH_SIZE,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IReplicationService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("replicate",(System.currentTimeMillis() - start));
            }
        }
    }
}
