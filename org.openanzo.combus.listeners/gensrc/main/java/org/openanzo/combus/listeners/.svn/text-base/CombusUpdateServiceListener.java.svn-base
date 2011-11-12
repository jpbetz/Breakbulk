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
 * Update Service combus listener interface
 * @author Generated Code
 */

public class CombusUpdateServiceListener extends BaseServiceListener {
	/** Service's Name in {@link String} form */
    public static final String SERVICE_ENDPOINT_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "CombusUpdateServiceListener";


    /** Stats for object*/
    protected org.openanzo.services.DynamicServiceStats stats=null;

   /** Service interface*/
    protected org.openanzo.datasource.IUpdateService iUpdateService=null;
    
    /**Queue Name Prefix*/
    protected String queueNamePrefix=null;

    /**
     * Create a new JMSUpdateServiceListener
     * @param authenticationService Authentication service used by this listener
     * @param _service Service for which listener is handling requests
     * @param queueNamePrefix Prefix for the queue name on which this listener is listening
     */
    public CombusUpdateServiceListener(IAuthenticationService authenticationService,org.openanzo.datasource.IUpdateService _service,String queueNamePrefix) {
        super(SERVICE_ENDPOINT_NAME,authenticationService);
        this.iUpdateService =_service;
        this.queueNamePrefix=queueNamePrefix;
        stats=new org.openanzo.services.DynamicServiceStats(org.openanzo.datasource.IUpdateService.IMPORT_STATEMENTS,org.openanzo.datasource.IUpdateService.UPDATE);
    }

    /**
     *  Statistics object for this service
     * @return the stats object for this service
     */
    public org.openanzo.services.DynamicServiceStats getStatistics(){
    	return stats;
    }

    public String getQueueName() {
        return "services/"+((queueNamePrefix!=null)?queueNamePrefix:"")+"update";
    }

   
    public TextMessage handleMessage(IOperationContext context, Destination replyTo, String resultFormat, String operation, TextMessage request, MessageProducer messageProducer) throws JMSException, AnzoException {
        verifyCaller(context);
        TextMessage response = null;
if(org.openanzo.datasource.IUpdateService.IMPORT_STATEMENTS.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean statementsFormatExists=request.propertyExists(org.openanzo.datasource.IUpdateService.PARAM_STATEMENTSFormat);
				String statementsFormat=(statementsFormatExists)?request.getStringProperty(org.openanzo.datasource.IUpdateService.PARAM_STATEMENTSFormat):org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
				String statements=request.getText();
			
				boolean graphTemplateFormatExists=request.propertyExists(org.openanzo.datasource.IUpdateService.PARAM_GRAPH_TEMPLATEFormat);
				String graphTemplateFormat=(graphTemplateFormatExists)?request.getStringProperty(org.openanzo.datasource.IUpdateService.PARAM_GRAPH_TEMPLATEFormat):org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
				boolean graphTemplateExists=request.propertyExists(org.openanzo.datasource.IUpdateService.PARAM_GRAPH_TEMPLATE);
                java.util.Collection<org.openanzo.rdf.Statement> graphTemplate = (graphTemplateExists)?org.openanzo.services.serialization.transport.StatementsSerializer.deserialize(messageWrapper,org.openanzo.datasource.IUpdateService.PARAM_GRAPH_TEMPLATE, graphTemplateFormat):null;
					
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iUpdateService.importStatements(context,statements,statementsFormat,graphTemplate, output,resultFormat);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("importStatements",(System.currentTimeMillis() - start));
           	 	}
        	}}else if(org.openanzo.datasource.IUpdateService.UPDATE.equals(operation)){
		  	long start=0;
        	if (stats.isEnabled()) {
            	start = System.currentTimeMillis();
       		}
        	try{        	
                org.openanzo.combus.JMSMessageWrapper messageWrapper=new org.openanzo.combus.JMSMessageWrapper(request);
				boolean returnResultsExists=request.propertyExists(org.openanzo.datasource.IUpdateService.PARAM_RETURN_RESULTS);
				if(!returnResultsExists){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IUpdateService.PARAM_RETURN_RESULTS);
				}
                boolean returnResults = org.openanzo.services.serialization.transport.BooleanSerializer.deserialize(messageWrapper,org.openanzo.datasource.IUpdateService.PARAM_RETURN_RESULTS, null);
	
				boolean transactionsFormatExists=request.propertyExists(org.openanzo.datasource.IUpdateService.PARAM_TRANSACTIONSFormat);
				String transactionsFormat=(transactionsFormatExists)?request.getStringProperty(org.openanzo.datasource.IUpdateService.PARAM_TRANSACTIONSFormat):org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_ANZO_XML;
				String transactions=request.getText();
			
				if(transactions==null){
					 throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER,org.openanzo.datasource.IUpdateService.PARAM_TRANSACTIONS);
				}				
				java.io.StringWriter output = new java.io.StringWriter();
		        this.iUpdateService.update(context,returnResults,transactions,transactionsFormat, output,resultFormat);
		        response = session.createTextMessage();
		        response.setBooleanProperty(org.openanzo.rdf.utils.SerializationConstants.operationFailed, false);
		        String out = output.toString();
		        if (out.length() > 0) {
		            response.setText(output.toString());
		        }
			}finally{
       			if (stats.isEnabled()) {
            	    stats.use("update",(System.currentTimeMillis() - start));
           	 	}
        	}
		} else {
	    	throw new AnzoException(ExceptionConstants.SERVER.UNKNOWN_OPERATION_ERROR, operation);
	    }
	    return response;
    }
}
