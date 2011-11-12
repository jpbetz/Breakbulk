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
package org.openanzo.combus.realtime;
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
 * Notification Registration Service combus listener interface
 * @author Generated Code
 */

public class CombusNotificationRegistrationServiceListener extends BaseServiceListener {
	/** Service's Name in {@link String} form */
    public static final String SERVICE_ENDPOINT_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "CombusNotificationRegistrationServiceListener";


    /** Stats for object*/
    protected org.openanzo.services.DynamicServiceStats stats=null;

   /** Service interface*/
    protected org.openanzo.services.INotificationRegistrationService iNotificationRegistrationService=null;
    
    /**Queue Name Prefix*/
    protected String queueNamePrefix=null;

    /**
     * Create a new JMSNotificationRegistrationServiceListener
     * @param authenticationService Authentication service used by this listener
     * @param _service Service for which listener is handling requests
     * @param queueNamePrefix Prefix for the queue name on which this listener is listening
     */
    public CombusNotificationRegistrationServiceListener(IAuthenticationService authenticationService,org.openanzo.services.INotificationRegistrationService _service,String queueNamePrefix) {
        super(SERVICE_ENDPOINT_NAME,authenticationService);
        this.iNotificationRegistrationService =_service;
        this.queueNamePrefix=queueNamePrefix;
        stats=new org.openanzo.services.DynamicServiceStats(org.openanzo.services.INotificationRegistrationService.REGISTER_SUBSCRIBER,org.openanzo.services.INotificationRegistrationService.REGISTER_TRACKERS,org.openanzo.services.INotificationRegistrationService.UNREGISTER_SUBSCRIBER,org.openanzo.services.INotificationRegistrationService.UNREGISTER_TRACKERS);
    }

    /**
     *  Statistics object for this service
     * @return the stats object for this service
     */
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }

    public String getQueueName() {
        return "services/"+((queueNamePrefix!=null)?queueNamePrefix:"")+"notification";
    }

   
    public TextMessage handleMessage(IOperationContext context, Destination replyTo, String resultFormat, String operation, TextMessage request, MessageProducer messageProducer) throws JMSException, AnzoException {
        verifyCaller(context);
        TextMessage response = null;
if(org.openanzo.services.INotificationRegistrationService.REGISTER_SUBSCRIBER.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{				
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iNotificationRegistrationService.registerSubscriber(context,replyTo, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("registerSubscriber",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.services.INotificationRegistrationService.REGISTER_TRACKERS.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean trackersFormatExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_TRACKERSFormat);
				String trackersFormat=(trackersFormatExists)?request.getStringProperty(org.openanzo.services.INotificationRegistrationService.PARAM_TRACKERSFormat):org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
				boolean trackersExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_TRACKERS);
                java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers = (trackersExists)?org.openanzo.services.serialization.transport.SelectorTrackerSerializer.deserialize(messageWrapper,org.openanzo.services.INotificationRegistrationService.PARAM_TRACKERS, trackersFormat):null;
	
				boolean datasettrackersFormatExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_DATASETTRACKERSFormat);
				String datasettrackersFormat=(datasettrackersFormatExists)?request.getStringProperty(org.openanzo.services.INotificationRegistrationService.PARAM_DATASETTRACKERSFormat):org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
				boolean datasettrackersExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_DATASETTRACKERS);
                java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers = (datasettrackersExists)?org.openanzo.services.serialization.transport.DatasetTrackerSerializer.deserialize(messageWrapper,org.openanzo.services.INotificationRegistrationService.PARAM_DATASETTRACKERS, datasettrackersFormat):null;
	
				boolean namedgraphTrackersFormatExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_NAMEDGRAPH_TRACKERSFormat);
				String namedgraphTrackersFormat=(namedgraphTrackersFormatExists)?request.getStringProperty(org.openanzo.services.INotificationRegistrationService.PARAM_NAMEDGRAPH_TRACKERSFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
				boolean namedgraphTrackersExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_NAMEDGRAPH_TRACKERS);
                java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers = (namedgraphTrackersExists)?org.openanzo.services.serialization.transport.URISetSerializer.deserialize(messageWrapper,org.openanzo.services.INotificationRegistrationService.PARAM_NAMEDGRAPH_TRACKERS, namedgraphTrackersFormat):null;
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iNotificationRegistrationService.registerTrackers(context,trackers,datasettrackers,namedgraphTrackers,replyTo, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("registerTrackers",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.services.INotificationRegistrationService.UNREGISTER_SUBSCRIBER.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{				
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iNotificationRegistrationService.unregisterSubscriber(context,replyTo, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("unregisterSubscriber",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.services.INotificationRegistrationService.UNREGISTER_TRACKERS.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean trackersFormatExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_TRACKERSFormat);
				String trackersFormat=(trackersFormatExists)?request.getStringProperty(org.openanzo.services.INotificationRegistrationService.PARAM_TRACKERSFormat):org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
				boolean trackersExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_TRACKERS);
                java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers = (trackersExists)?org.openanzo.services.serialization.transport.SelectorTrackerSerializer.deserialize(messageWrapper,org.openanzo.services.INotificationRegistrationService.PARAM_TRACKERS, trackersFormat):null;
	
				boolean datasettrackersFormatExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_DATASETTRACKERSFormat);
				String datasettrackersFormat=(datasettrackersFormatExists)?request.getStringProperty(org.openanzo.services.INotificationRegistrationService.PARAM_DATASETTRACKERSFormat):org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
				boolean datasettrackersExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_DATASETTRACKERS);
                java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers = (datasettrackersExists)?org.openanzo.services.serialization.transport.DatasetTrackerSerializer.deserialize(messageWrapper,org.openanzo.services.INotificationRegistrationService.PARAM_DATASETTRACKERS, datasettrackersFormat):null;
	
				boolean namedgraphTrackersFormatExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_NAMEDGRAPH_TRACKERSFormat);
				String namedgraphTrackersFormat=(namedgraphTrackersFormatExists)?request.getStringProperty(org.openanzo.services.INotificationRegistrationService.PARAM_NAMEDGRAPH_TRACKERSFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_TEXT;
				boolean namedgraphTrackersExists=request.propertyExists(org.openanzo.services.INotificationRegistrationService.PARAM_NAMEDGRAPH_TRACKERS);
                java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers = (namedgraphTrackersExists)?org.openanzo.services.serialization.transport.URISetSerializer.deserialize(messageWrapper,org.openanzo.services.INotificationRegistrationService.PARAM_NAMEDGRAPH_TRACKERS, namedgraphTrackersFormat):null;
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iNotificationRegistrationService.unregisterTrackers(context,trackers,datasettrackers,namedgraphTrackers,replyTo, output);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("unregisterTrackers",(System.currentTimeMillis() - start));
           	 	}
        	}
		} else {
	    	throw new AnzoException(ExceptionConstants.SERVER.UNKNOWN_OPERATION_ERROR, operation);
	    }
	    return response;
    }
}
