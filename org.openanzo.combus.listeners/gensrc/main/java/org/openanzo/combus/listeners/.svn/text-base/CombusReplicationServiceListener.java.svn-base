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
package org.openanzo.combus.listeners;
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
 * Replication Service combus listener interface
 * @author Generated Code
 */

public class CombusReplicationServiceListener extends BaseServiceListener {
	/** Service's Name in {@link String} form */
    public static final String SERVICE_ENDPOINT_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "CombusReplicationServiceListener";


    /** Stats for object*/
    protected org.openanzo.services.DynamicServiceStats stats=null;

   /** Service interface*/
    protected org.openanzo.datasource.IReplicationService iReplicationService=null;
    
    /**Queue Name Prefix*/
    protected String queueNamePrefix=null;

    /**
     * Create a new JMSReplicationServiceListener
     * @param authenticationService Authentication service used by this listener
     * @param _service Service for which listener is handling requests
     * @param queueNamePrefix Prefix for the queue name on which this listener is listening
     */
    public CombusReplicationServiceListener(IAuthenticationService authenticationService,org.openanzo.datasource.IReplicationService _service,String queueNamePrefix) {
        super(SERVICE_ENDPOINT_NAME,authenticationService);
        this.iReplicationService =_service;
        this.queueNamePrefix=queueNamePrefix;
        stats=new org.openanzo.services.DynamicServiceStats(org.openanzo.datasource.IReplicationService.REPLICATE);
    }

    /**
     *  Statistics object for this service
     * @return the stats object for this service
     */
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }

    public String getQueueName() {
        return "services/"+((queueNamePrefix!=null)?queueNamePrefix:"")+"replication";
    }

   
    public TextMessage handleMessage(IOperationContext context, Destination replyTo, String resultFormat, String operation, TextMessage request, MessageProducer messageProducer) throws JMSException, AnzoException {
        verifyCaller(context);
        TextMessage response = null;
if(org.openanzo.datasource.IReplicationService.REPLICATE.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean namedGraphsFormatExists=request.propertyExists(org.openanzo.datasource.IReplicationService.PARAM_NAMED_GRAPHSFormat);
				String namedGraphsFormat=(namedGraphsFormatExists)?request.getStringProperty(org.openanzo.datasource.IReplicationService.PARAM_NAMED_GRAPHSFormat):org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
				String namedGraphs=request.getText();
			
				if(namedGraphs==null){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IReplicationService.PARAM_NAMED_GRAPHS);
				}
				boolean batchSizeExists=request.propertyExists(org.openanzo.datasource.IReplicationService.PARAM_BATCH_SIZE);
                int batchSize = (batchSizeExists)?org.openanzo.services.serialization.transport.IntSerializer.deserialize(messageWrapper,org.openanzo.datasource.IReplicationService.PARAM_BATCH_SIZE, null):-1;
	
				java.util.Collection<org.openanzo.rdf.Statement> trackers = org.openanzo.rdf.utils.ReadWriteUtils.readStatements(namedGraphs, org.openanzo.rdf.RDFFormat.forMIMEType(namedGraphsFormat));
                org.openanzo.combus.listeners.BatchedReplicationHandler handler = new org.openanzo.combus.listeners.BatchedReplicationHandler(batchSize, replyTo, resultFormat, operation, request, session, mp,recorder);
                this.iReplicationService.replicate(context, trackers, handler,batchSize);
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("replicate",(System.currentTimeMillis() - start));
           	 	}
        	}
		} else {
	    	throw new AnzoException(ExceptionConstants.SERVER.UNKNOWN_OPERATION_ERROR, operation);
	    }
	    return response;
    }
}
