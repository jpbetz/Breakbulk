/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.client.JMSResetService");

dojo.require("anzo.client.Serialization");
dojo.require("anzo.log");

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */

dojo.declare('anzo.client.JMSResetService', null, {
    // summary: Service used to reset the database.
    
    reset : function(statements, callback) {
        // summary: Resets the server with the given statements.
        // statements: Array
        //      List of statements that are used to reset the server.  These statements specify the initial set of named graphs, users and access controls. This RDF document may not contain named graph data itself. The file is isomorphic to the initialize.trig file that is used to initialize a new Anzo database the first time it starts up.
        // callback : Function(Boolean success, Object error)
        //  Method called upon completion of the requested operation.
        //  The success argument denotes if the operation completed successfully. 
        //  The error argument contains information about any error in the case of failure.
        //  The error argument is null in case of success.
        //  Turning the error object into a string with dojo.toJson to display error
        //  information is recommended.
        
        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_JSON;
        
        var msg = new anzo.messaging.JMSMessage(null, responseFormat);
        
        msg.properties[ser.OPERATION] = ser.OP_RESET;
        msg.properties[ser.STATEMENTS_FORMAT] = ser.MIMETYPE_JSON;
        msg.body = ser.writeStatementsToJson(statements);
        
        var responseCallback = function(response) {
            var callbackCalled = false;
            try {
                if (response.error || response.message.properties.operationFailed == "true") {
                    callbackCalled = true;
                    callback(false, response);
                } else {
                    callbackCalled = true;
                    callback(true, null);
                }
            } catch(e) {
                 if (!callbackCalled && callback) {
                    // Ensure the callback is called even in the case of type errors and the like in the code above.
                    e.response = response;
                    callback(false, e);
                } else {
                    // If the callback itself threw the error rather than Anzo.JS code, just let it bubble up. 
                    throw e;
                }
            }
        };
    
        anzo.messaging.JMSClient.publish(msg, "services/reset", responseCallback);
    }
});
