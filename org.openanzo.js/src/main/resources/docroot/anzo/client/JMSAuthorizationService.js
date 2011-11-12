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

dojo.provide("anzo.client.JMSAuthorizationService");

dojo.require("anzo.client.Serialization");
dojo.require("anzo.log");

dojo.declare("anzo.client.JMSAuthorizationService", null, {

    _getAuthorizationServiceResponseCallback : function(callback) {
        // summary: Creates a callback function for parsing responses from AuthorizationService operations.
        var responseCallback = function(response) {
            var callbackCalled = false;
            try {
                if (response.error || response.message.properties.operationFailed == "true") {
                    callbackCalled = true;
                    callback(null, false, response);
                } else {
                    var body = response.message.body;
                    var uris = anzo.client.Serialization.readUriSet(body);
                    callbackCalled = true;
                    callback(uris, true, null);
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
    
    getRolesForGraph : function(uri, privilege, callback) {
        // summary: callback with an array of statements for the graph and metadata graph

        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_TEXT;
        
        var msg = new anzo.messaging.JMSMessage(null, responseFormat);
        msg.properties[ser.OPERATION] = ser.OP_GET_ROLES_FOR_GRAPH;
        msg.properties[ser.RESPONSE_FORMAT] = ser.MIMETYPE_TEXT;
        msg.properties[ser.NAMED_GRAPH_URI] = uri.toString();
        msg.properties[ser.PRIVILEGE] = privilege;
        var responseCallback = this._getAuthorizationServiceResponseCallback(callback);
        anzo.messaging.JMSClient.publish(msg, "services/authorization", responseCallback);
    }
    
});
