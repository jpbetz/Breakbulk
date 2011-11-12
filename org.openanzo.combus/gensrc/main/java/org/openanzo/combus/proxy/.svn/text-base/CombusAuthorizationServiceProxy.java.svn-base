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
 * authorization Service interface
 * Operations related to authorization.
 * @author Generated Code
 *
 */
public class CombusAuthorizationServiceProxy extends BaseCombusProxyDatasourceService implements org.openanzo.datasource.IAuthorizationService{
    /** Stats for object*/
   protected org.openanzo.services.DynamicServiceStats stats=null;
   protected CombusDatasource datasource=null;
    /**
     * Create a new JMSAuthorizationServiceProxy     
	 * @param datasource Datasource to which this service belongs
     * @param combusConnection Connection which this proxy class uses to communicate to the server
     *
     */
    public CombusAuthorizationServiceProxy( CombusDatasource datasource ,org.openanzo.combus.CombusConnection combusConnection) {
        super(datasource,combusConnection);
        stats=new org.openanzo.services.DynamicServiceStats(GET_ROLES_FOR_GRAPH);
	
    }

	public String getName(){
		return "CombusAuthorizationServiceProxy";
	}
	
	public String getDescription(){
		return "Combus  AuthorizationService Proxy Service";
	}

    /** Statistics object for this service*/
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }
    
    public java.util.Set<org.openanzo.rdf.URI> getRolesForGraph(IOperationContext context,org.openanzo.rdf.URI namedGraphUri,org.openanzo.services.Privilege privilege) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
		String resultFormat=org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
        getRolesForGraph(context,namedGraphUri,privilege,responseWriter,resultFormat);
		return org.openanzo.services.serialization.transport.URISetSerializer.deserialize(responseWriter.toString(),resultFormat);
	 	
	}

    public void getRolesForGraph(IOperationContext context,org.openanzo.rdf.URI namedGraphUri,org.openanzo.services.Privilege privilege, java.io.Writer output, String resultFormat) throws AnzoException{
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
       	    if(privilege==null){
                 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,PARAM_PRIVILEGE);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, GET_ROLES_FOR_GRAPH);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            org.openanzo.services.serialization.transport.URISerializer.serialize(namedGraphUri,PARAM_NAMED_GRAPH_URI,null,messageWrapper);
		
            org.openanzo.services.serialization.transport.PrivilegeSerializer.serialize(privilege,PARAM_PRIVILEGE,null,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.datasource.IAuthorizationService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("getRolesForGraph",(System.currentTimeMillis() - start));
            }
        }
    }
}
