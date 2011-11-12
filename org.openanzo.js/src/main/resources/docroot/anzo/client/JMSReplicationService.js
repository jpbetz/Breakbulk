/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
dojo.provide("anzo.client.JMSReplicationService");

dojo.require("anzo.client.Serialization");

dojo.declare("anzo.client.JMSReplicationService", null, {
    
    
    constructor : function() {
    },
    
    replicate : function(namedGraphStatements, callback) {
        // summary: Retrieves changes from the repository that have been made to the given
        //  named graphs since their given revisions
        
        // namedGraphStatements: An array of Statements of the form <namedGraphUri> <revision> rev#
        //  indicating the current revisions and the graphs to replicate.

        // callback : Function(Object replicationResults, Boolean success, Object error)
        //  Method called upon completion of the requested operation.
        //  The replicationResults argument contains the changes made on the server since the marker.
        //  The marker argument contains the new marker which can be used as the reference for future replications. The result
        //  contains the server changes up to this marker.
        //  The success argument denotes if the operation completed successfully. 
        //  The error argument contains information about any error in the case of failure.
        //  The error argument is null in case of success.
        //  Turning the error object into a string with dojo.toJson to display error
        //  information is recommended.

        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_JSON;
        
        var body = ser.writeStatementsToJson(namedGraphStatements);
        
        var msg = new anzo.messaging.JMSMessage(body, responseFormat);
        msg.properties[ser.OPERATION] = ser.OP_REPLICATE;
        
        msg.properties[ser.RESPONSE_FORMAT] = ser.MIMETYPE_JSON;
        msg.properties[ser.NAMED_GRAPHS_FORMAT] = ser.MIMETYPE_JSON;
        msg.properties["batchSize"] = 20000;
        var responseCallback = function(response) {
            var callbackCalled = false;
            try {
                if (response.error || (response.message&&response.message.properties.operationFailed == "true") || (response.jmsMessages&&response.jmsMessages[0].data.properties.operationFailed=="true")) {
                    callbackCalled = true;
                    callback(null, false, response);
                } else {
                	if(response.message!=null){
                   		var body = dojo.fromJson(response.message.body);
                    	callbackCalled = true;
                    	callback(body, true, null);
                    }else if(response.jmsMessages!=null){
                    	var body =[];
                    	for(var l = 0; l < response.jmsMessages.length; l++){
                    		body=body.concat(dojo.fromJson(response.jmsMessages[l].data.body));
                    	}
                    	callbackCalled = true;
                    	callback(body, true, null);
                    }
                }
            } catch(e) {
                if (!callbackCalled && callback) {
                    // Ensure the callback is called even in the case of type errors and the like in the code above.
                    e.response = response;
                    callback(null, false, e);
                } else {
                    // If the callback itself threw the error rather than Anzo.JS code, just let it bubble up. 
                    throw e;
                }
            }
        };
    
        anzo.messaging.JMSClient.publish(msg, "services/replication", responseCallback);
    }
    
});
