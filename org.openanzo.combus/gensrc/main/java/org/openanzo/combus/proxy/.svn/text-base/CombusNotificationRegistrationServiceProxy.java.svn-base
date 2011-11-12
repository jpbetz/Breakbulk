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
 * Notification Registration Service interface
 * Operations related to managing notification subscribers and their subscriptions.
 * @author Generated Code
 *
 */
public class CombusNotificationRegistrationServiceProxy extends BaseCombusProxyService implements org.openanzo.services.INotificationRegistrationService{
    /** Stats for object*/
   protected org.openanzo.services.DynamicServiceStats stats=null;
    /**
     * Create a new JMSNotificationRegistrationServiceProxy
     * @param combusConnection Connection which this proxy class uses to communicate to the server
     *
     */
    public CombusNotificationRegistrationServiceProxy( org.openanzo.combus.CombusConnection combusConnection) {
        
        super(combusConnection);
        stats=new org.openanzo.services.DynamicServiceStats(REGISTER_SUBSCRIBER,REGISTER_TRACKERS,UNREGISTER_SUBSCRIBER,UNREGISTER_TRACKERS);
	
    }

	public String getName(){
		return "CombusNotificationRegistrationServiceProxy";
	}
	
	public String getDescription(){
		return "Combus  NotificationRegistrationService Proxy Service";
	}

    /** Statistics object for this service*/
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }
    
    public boolean registerSubscriber(IOperationContext context,javax.jms.Destination replyTo) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        registerSubscriber(context,replyTo,responseWriter);
		return org.openanzo.services.serialization.transport.BooleanSerializer.deserialize(responseWriter.toString(),null);
	 	
	}

    public void registerSubscriber(IOperationContext context,javax.jms.Destination replyTo, java.io.Writer output) throws AnzoException{
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

            messageWrapper.setProperty(SerializationConstants.operation, REGISTER_SUBSCRIBER);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.services.INotificationRegistrationService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("registerSubscriber",(System.currentTimeMillis() - start));
            }
        }
    }
    public boolean registerTrackers(IOperationContext context,java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers,java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers,java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers,javax.jms.Destination replyTo) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        registerTrackers(context,trackers,datasettrackers,namedgraphTrackers,replyTo,responseWriter);
		return org.openanzo.services.serialization.transport.BooleanSerializer.deserialize(responseWriter.toString(),null);
	 	
	}

    public void registerTrackers(IOperationContext context,java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers,java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers,java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers,javax.jms.Destination replyTo, java.io.Writer output) throws AnzoException{
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

            messageWrapper.setProperty(SerializationConstants.operation, REGISTER_TRACKERS);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            messageWrapper.setProperty(PARAM_TRACKERSFormat, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
            if(trackers!=null)
            org.openanzo.services.serialization.transport.SelectorTrackerSerializer.serialize(trackers,PARAM_TRACKERS,org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType(),messageWrapper);
		
            messageWrapper.setProperty(PARAM_DATASETTRACKERSFormat, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
            if(datasettrackers!=null)
            org.openanzo.services.serialization.transport.DatasetTrackerSerializer.serialize(datasettrackers,PARAM_DATASETTRACKERS,org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType(),messageWrapper);
		
            messageWrapper.setProperty(PARAM_NAMEDGRAPH_TRACKERSFormat, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT);
            if(namedgraphTrackers!=null)
            org.openanzo.services.serialization.transport.URISetSerializer.serialize(namedgraphTrackers,PARAM_NAMEDGRAPH_TRACKERS,org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.services.INotificationRegistrationService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("registerTrackers",(System.currentTimeMillis() - start));
            }
        }
    }
    public boolean unregisterSubscriber(IOperationContext context,javax.jms.Destination replyTo) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        unregisterSubscriber(context,replyTo,responseWriter);
		return org.openanzo.services.serialization.transport.BooleanSerializer.deserialize(responseWriter.toString(),null);
	 	
	}

    public void unregisterSubscriber(IOperationContext context,javax.jms.Destination replyTo, java.io.Writer output) throws AnzoException{
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

            messageWrapper.setProperty(SerializationConstants.operation, UNREGISTER_SUBSCRIBER);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.services.INotificationRegistrationService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("unregisterSubscriber",(System.currentTimeMillis() - start));
            }
        }
    }
    public boolean unregisterTrackers(IOperationContext context,java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers,java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers,java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers,javax.jms.Destination replyTo) throws AnzoException{
        java.io.StringWriter responseWriter = new java.io.StringWriter();
        unregisterTrackers(context,trackers,datasettrackers,namedgraphTrackers,replyTo,responseWriter);
		return org.openanzo.services.serialization.transport.BooleanSerializer.deserialize(responseWriter.toString(),null);
	 	
	}

    public void unregisterTrackers(IOperationContext context,java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers,java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers,java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers,javax.jms.Destination replyTo, java.io.Writer output) throws AnzoException{
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

            messageWrapper.setProperty(SerializationConstants.operation, UNREGISTER_TRACKERS);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            
            messageWrapper.setProperty(PARAM_TRACKERSFormat, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
            if(trackers!=null)
            org.openanzo.services.serialization.transport.SelectorTrackerSerializer.serialize(trackers,PARAM_TRACKERS,org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType(),messageWrapper);
		
            messageWrapper.setProperty(PARAM_DATASETTRACKERSFormat, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
            if(datasettrackers!=null)
            org.openanzo.services.serialization.transport.DatasetTrackerSerializer.serialize(datasettrackers,PARAM_DATASETTRACKERS,org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType(),messageWrapper);
		
            messageWrapper.setProperty(PARAM_NAMEDGRAPH_TRACKERSFormat, org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT);
            if(namedgraphTrackers!=null)
            org.openanzo.services.serialization.transport.URISetSerializer.serialize(namedgraphTrackers,PARAM_NAMEDGRAPH_TRACKERS,org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT,messageWrapper);
		
            TextMessage response = combusConnection.requestResponse(context, org.openanzo.services.INotificationRegistrationService.SERVICE_NAME, request, getTimeout());
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
       		      stats.use("unregisterTrackers",(System.currentTimeMillis() - start));
            }
        }
    }
}
