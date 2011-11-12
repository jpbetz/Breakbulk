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

dojo.provide("anzo.client.JMSModelService");

dojo.require("anzo.client.Serialization");
dojo.require("anzo.log");

dojo.declare("anzo.client.JMSModelService", null, {

    _getModelServiceResponseCallback : function(callback) {
        // summary: Creates a callback function for parsing responses from ModelService operations.
        var responseCallback = function(response) {
            var callbackCalled = false;
            try {
                if (response.error || response.message.properties.operationFailed == "true") {
                    callbackCalled = true;
                    callback(null, false, response);
                } else {
                    var body = dojo.fromJson(response.message.body);
                    if (body != null) {
                    	var stmts = anzo.client.Serialization.readStatementsFromJson(body);
                    } else {
                    	var stmts = new Array();
                    }
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
    
    getNamedGraphRevision : function(uri, revision, callback) {
        // summary: callback with an array of statements for the graph and metadata graph

        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_JSON;
        
        var msg = new anzo.messaging.JMSMessage(null, responseFormat);
        msg.properties[ser.OPERATION] = ser.OP_GET_NAMED_GRAPH_REVISON;
        msg.properties[ser.RESPONSE_FORMAT] = ser.MIMETYPE_JSON;
        msg.properties[ser.REVISION] = "" + revision;
        msg.properties[ser.NAMED_GRAPH_URI] = uri.toString();
        
        var responseCallback = this._getModelServiceResponseCallback(callback);
        
        anzo.messaging.JMSClient.publish(msg, "services/model", responseCallback);

    },
    
    containsNamedGraph : function(uri, callback) {

        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_JSON;
        
        var msg = new anzo.messaging.JMSMessage(null, responseFormat);
        msg.properties[ser.OPERATION] = ser.OP_CONTAINS_NAMED_GRAPH;
        msg.properties[ser.RESPONSE_FORMAT] = ser.MIMETYPE_JSON;
        msg.properties[ser.NAMED_GRAPH_URI] = uri.toString();
        
        var responseCallback = function(response) {
        	
            var callbackCalled = false;
            try {
                if (response.error || response.message.properties.operationFailed == "true") {
                    callbackCalled = true;
                    callback(null, false, response);
                } else {
                    var body = dojo.fromJson(response.message.body);
                    
                    callbackCalled = true;
                    callback(body, true, null);
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
        
        anzo.messaging.JMSClient.publish(msg, "services/model", responseCallback);

    },
    
    
    findStatements : function(subject, predicate, object, namedGraphUri, callback) {
        // summary: callback with an array of statements for the graph and metadata graph

        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_JSON;
        
        var msg = new anzo.messaging.JMSMessage(null, responseFormat);
        msg.properties[ser.OPERATION] = ser.OP_FIND_STATEMENTS;
        msg.properties[ser.RESPONSE_FORMAT] = ser.MIMETYPE_JSON;
        
        
        if (subject) {
            msg.properties[ser.SUBJECT] = subject.toString();
        }
        if (predicate) {
            msg.properties[ser.PREDICATE] = predicate.toString();
        }
        if (object) {
        	object = anzo.rdf.getValue(object);
        	msg.properties[ser.OBJECT] = object.toString();
            if (object instanceof anzo.rdf.URI) {
                msg.properties[ser.OBJECT_TYPE] = ser.URI;
            } else if (object instanceof anzo.rdf.Literal) {
                msg.properties[ser.OBJECT_TYPE] = ser.LITERAL;
                if (object.language) {
                    msg.properties[ser.LANGUAGE] = object.language.toString();
                }
                if (object.datatype) {
                    msg.properties[ser.DATATYPE] = object.datatype.toString();
                }
            } else if (object instanceof anzo.rdf.BNode) { //bnode
                msg.properties[ser.OBJECT_TYPE] = ser.BNODE;
            } 	
        }
        
        if (namedGraphUri) {
            msg.properties[ser.NAMED_GRAPH_URI_FORMAT] = ser.MIMETYPE_TEXT;
            msg.properties[ser.NAMED_GRAPH_URI] = namedGraphUri.toString();
        }
        
        var responseCallback = this._getModelServiceResponseCallback(callback);
        
        anzo.messaging.JMSClient.publish(msg, "services/model", responseCallback);
        
    }
});
