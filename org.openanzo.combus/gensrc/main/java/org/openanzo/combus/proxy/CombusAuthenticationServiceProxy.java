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
 * Authentication Service interface
 * Operations related to authentication and roles.
 * @author Generated Code
 *
 */
public class CombusAuthenticationServiceProxy extends BaseCombusProxyService implements org.openanzo.services.IAuthenticationService{
    /** Stats for object*/
   protected org.openanzo.services.DynamicServiceStats stats=null;
    /**
     * Create a new JMSAuthenticationServiceProxy
     * @param combusConnection Connection which this proxy class uses to communicate to the server
     *
     */
    public CombusAuthenticationServiceProxy( org.openanzo.combus.CombusConnection combusConnection) {
        
        super(combusConnection);
        stats=new org.openanzo.services.DynamicServiceStats(AUTHENTICATE_USER,GET_USER_PRINCIPAL);
	
    }

	public String getName(){
		return "CombusAuthenticationServiceProxy";
	}
	
	public String getDescription(){
		return "Combus  AuthenticationService Proxy Service";
	}

    /** Statistics object for this service*/
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }
    
    public org.openanzo.services.AnzoPrincipal authenticateUser(IOperationContext context,String userId,String password) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
		String resultFormat=org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
        authenticateUser(context,userId,password,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.PrincipalSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void authenticateUser(IOperationContext context,String userId,String password, java.io.Writer output, String resultFormat) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(userId==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_USER_ID);
            }
       	    if(password==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_PASSWORD);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, AUTHENTICATE_USER);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.StringSerializer.serialize(userId,PARAM_USER_ID,null,messageWrapper);
		
            org.openanzo.services.serialization.transport.StringSerializer.serialize(password,PARAM_PASSWORD,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.services.IAuthenticationService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("authenticateUser",(System.currentTimeMillis() - start));
            }
        }
    }
    public org.openanzo.services.AnzoPrincipal getUserPrincipal(IOperationContext context,String userId) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
		String resultFormat=org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
        getUserPrincipal(context,userId,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.PrincipalSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void getUserPrincipal(IOperationContext context,String userId, java.io.Writer output, String resultFormat) throws AnzoException{
     	if (!combusConnection.isConnected()) {
     	    throw new AnzoException( ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
            //combusConnection.connect();
        }
        long start=0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try{
       	    if(userId==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_USER_ID);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, GET_USER_PRINCIPAL);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.StringSerializer.serialize(userId,PARAM_USER_ID,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.services.IAuthenticationService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("getUserPrincipal",(System.currentTimeMillis() - start));
            }
        }
    }
}
