/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
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

dojo.provide("anzo.client.JMSUpdateService");

dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.messaging.JMSMessage");
dojo.require("anzo.log");

(function(){

var log = anzo.log.getLogger("anzo.client.JMSUpdateService");

dojo.declare('anzo.client.JMSUpdateService', null, {
    
    updateServer : function(transactions, returnResults, isIndexSynchronous, callback, timeout) {
        // summary: Sends transactions to the repository server to be committed.
        // transactions: Object
        //  The transactions to commit.
        // returnResults: Boolean
        //  If true, then the response contains all of the data added/removed during the update. If false,
        //  only the transaction begin/end commands and errors are returned. So, when false, the actual 
        //  additions and deletions are omitted from the response.
        // isIndexSynchronous: Boolean
        //  If true, the server repository will update its indexes before returning a response to this request.
        //  If false, the server will return immediately after comitting the changes and won't wait for the indexes
        //  to be updated. They will be updated in the background in the server. 
        // callback : Function(Object updateResults, Boolean success, Object error)
        //  Method called upon completion of the requested operation.
        //  The updateResults argument contains the results of applying the updates, including exceptions, if any. See
        //  the 'returnResults' argument for information about how to affect the contents of the updateResults. 
        //  The success argument denotes if the operation completed successfully. 
        //  The error argument contains information about any error in the case of failure.
        //  The error argument is null in case of success.
        //  Turning the error object into a string with dojo.toJson to display error
        //  information is recommended.
        // timeout: Integer
        //  Optional. Number of milliseconds to wait for a response. The call will fail if a response hasn't been received before
        //  the timeout time elapses.
        
        if (log.isDebugEnabled()) {
	        log.debug("START updateServer.");
            var startTime = (new Date()).getTime();
        }
        
        if (transactions.length == 0) {
            if (log.isDebugEnabled()) {
                var endTime = (new Date()).getTime();
    	        log.debug("DONE updateServer (no transactions) - time:" + (endTime - startTime));
            }
            callback(new Array(), true);
            return;
        }
        
        // primarily for testing, sometimes we may want to call updateServer
        // with a raw transaction tree instead of the json serialized format
        if (transactions[0].declaredClass == "anzo.client.Transaction") {
            transactions = anzo.client.Serialization.writeTransactionsToJson(transactions);
        }

        if (log.isDebugEnabled()) {
            log.debug("Transactions to send to the server - count:" + (transactions ? transactions.length : 0) + "\n" + dojo.toJson(transactions, true));
        }
        
        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_JSON;
        var msg = new anzo.messaging.JMSMessage(null, responseFormat);
        msg.properties[ser.OPERATION] = ser.OP_UPDATE_SERVER;
        msg.properties[ser.RETURN_RESULTS] = returnResults;
        msg.properties[ser.TRANSACTIONS_FORMAT] = ser.MIMETYPE_JSON;
        msg.body = transactions;
        
        var responseCallback = function(response) {
            var message = null;
            var callbackCalled = false;
            try {
                if (response.error || response.message.properties.operationFailed == "true") {
                    if (callback) {
                        callbackCalled = true;
                        if (log.isDebugEnabled()) {
                            var endTime = (new Date()).getTime();
                	        log.debug("DONE updateServer - time:" + (endTime - startTime));
                        }
                        callback(null, false, response);
                    }
                } else {
                    message = response.message;
                    var bodyRaw = message.body;
                    if (bodyRaw) { 
                        message.body = dojo.fromJson(bodyRaw);
                    }
                    if (callback) {
                        callbackCalled = true;
                        if (log.isDebugEnabled()) {
                            var endTime = (new Date()).getTime();
                	        log.debug("DONE updateServer - time:" + (endTime - startTime));
                        }
                        callback(message.body, true);
                    }
                }
            } catch(e) {
                if (!callbackCalled && callback) {
                    // Ensure the callback is called even in the case of type errors and the like in the code above.
                    e.response = response;
                    if (log.isDebugEnabled()) {
                        var endTime = (new Date()).getTime();
            	        log.debug("DONE updateServer - time:" + (endTime - startTime));
                    }
                    callback(null, false, e);
                } else {
                    // If the callback itself threw the error rather than Anzo.JS code, just let it bubble up. 
                    throw e;
                }
            }
        };
        anzo.messaging.JMSClient.publish(msg, "services/update", responseCallback, timeout);
    }

});

})();
