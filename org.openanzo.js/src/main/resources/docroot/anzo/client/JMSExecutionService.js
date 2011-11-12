/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.client.JMSExecutionService");

dojo.require("anzo.client.Serialization");
dojo.require("anzo.log");

dojo.declare("anzo.client.JMSExecutionService", null, {

    _getExecutionServiceResponseCallback : function(callback) {
        // summary: Creates a callback function for parsing responses from ExecutionService operations.
        var responseCallback = function(response) {
            var callbackCalled = false;
            try {
                if (response.error || response.message.properties.operationFailed == "true") {
                    callbackCalled = true;
                    callback(null, false, response);
                } else {
                    var body = dojo.fromJson(response.message.body);
                    var stmts = anzo.client.Serialization.readStatementsFromJson(body);
                    callbackCalled = true;
                    callback(stmts, true, null);
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
        return responseCallback;
    },
    
    executeService : function(uri, statements, callback, timeout) {
        // summary: callback with an array of statements for the graph and metadata graph
        // timeout : Number
        //   The timeout in milliseconds for the call. If a response has not been received within this timeout,
        //   the call will be aborted and the callback will be called with an error.
        //   The default timeout is infinite for queries regardless of other global timeout settings.

        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_JSON;
        
        var msg = new anzo.messaging.JMSMessage(null, responseFormat);
        msg.properties[ser.OPERATION] = ser.OP_EXECUTE_SERVICE;
        msg.properties[ser.RESPONSE_FORMAT] = ser.MIMETYPE_JSON;
        msg.properties[ser.STATEMENTS_FORMAT] = ser.MIMETYPE_JSON;
        msg.properties[ser.OPERATION_URI] = uri.toString();
        msg.body = ser.writeStatementsToJson(statements);
        var responseCallback = this._getExecutionServiceResponseCallback(callback);

        // default to an infinite timeout
        if (timeout == null) {
            timeout = -1; 
        }    

        anzo.messaging.JMSClient.publish(msg, "services/execution", responseCallback, timeout);

    }
    
});
