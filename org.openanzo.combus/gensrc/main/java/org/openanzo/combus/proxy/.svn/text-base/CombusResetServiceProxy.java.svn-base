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
 * Reset Service interface
 * Operations related to resetint the data on the server
 * @author Generated Code
 *
 */
public class CombusResetServiceProxy extends BaseCombusProxyDatasourceService implements org.openanzo.datasource.IResetService{
    /** Stats for object*/
   protected org.openanzo.services.DynamicServiceStats stats=null;
   protected CombusDatasource datasource=null;
    /**
     * Create a new JMSResetServiceProxy     
	 * @param datasource Datasource to which this service belongs
     * @param combusConnection Connection which this proxy class uses to communicate to the server
     *
     */
    public CombusResetServiceProxy( CombusDatasource datasource ,org.openanzo.combus.CombusConnection combusConnection) {
        super(datasource,combusConnection);
        stats=new org.openanzo.services.DynamicServiceStats(RESET);
	
    }

	public String getName(){
		return "CombusResetServiceProxy";
	}
	
	public String getDescription(){
		return "Combus  ResetService Proxy Service";
	}

    /** Statistics object for this service*/
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }
    
    public void reset(IOperationContext context,java.util.Collection<org.openanzo.rdf.Statement> statements,java.util.Collection<org.openanzo.rdf.Statement> checks) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        String _requestBody = null;
		if(statements!=null){
	    _requestBody= org.openanzo.services.serialization.transport.StatementsSerializer.serialize(statements, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
		}
		String statementsFormat=org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
        reset(context,_requestBody,statementsFormat,checks,responseWriter);
	}

    public void reset(IOperationContext context,String statements,String statementsFormat,java.util.Collection<org.openanzo.rdf.Statement> checks, java.io.Writer output) throws AnzoException{
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

            messageWrapper.setProperty(SerializationConstants.operation, RESET);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            messageWrapper.setProperty(PARAM_STATEMENTSFormat, statementsFormat);
            messageWrapper.setBody(statements);
            messageWrapper.setProperty(PARAM_CHECKSFormat, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
            if(checks!=null)
            org.openanzo.services.serialization.transport.StatementsSerializer.serialize(checks,PARAM_CHECKS,org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType(),messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IResetService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("reset",(System.currentTimeMillis() - start));
            }
        }
    }
}
