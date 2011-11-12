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


dojo.provide("anzo.client.StatementChannel");

dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.messaging.JMSClient");

dojo.require("anzo.log");

/*
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
 
(function(){ 

var log = anzo.log.getLogger("anzo.client.StatementChannel");

dojo.declare('anzo.client.StatementChannel', null, {
    
    // summary: 
    //      Provides access to a statement channel on the combus.
    //     
     
    jmsClient	: null,
    
    uri 		: null,
    
    topic		: null,
    
    anzoClient	: null,
    
    listeners   : null,
    
    constructor : function(namedGraph, uri, anzoClient) {
    	this.anzoClient = anzoClient;
        this.namedGraph  = namedGraph;
        this.jmsClient = anzo.messaging.JMSClient;
        this.uri = uri;
        this.topic = null;
        this.listeners = [];
    },
    
    getTopic : function() {
    	if (this.topic) {
    		return this.topic;
    	} else {
    		var metadataGraph = anzo.utils.UriGenerator.getMetadataGraphUri(this.uri);
    		var uuidStmts = this.anzoClient.quadStore.find(this.uri, anzo.client.Vocabulary.uuidProperty, null, metadataGraph);
    		if (!uuidStmts || uuidStmts.length == 0) {
    			throw Error("Named graph does not exist for statement channel, try updating the repository: " + this.uri);
    		}
            var uuidStmt = uuidStmts[0];
            var uuid = uuidStmt.object;
            this.topic = anzo.utils.UriGenerator.getTopicString(anzo.client.Vocabulary.STREAM_TOPIC_PREFIX, uuid.toString());
            return this.topic;
    	}
    },
    
    sendMessage : function(messageProperties, statements, callback) {
    	var topic = this.getTopic();
    	// summary: send a message over the statement channel
    	// messageProperties: properties to send with the message
    	// statements: the statements of the message
    	// callback: function(success,error)
    	var stmts = anzo.client.Serialization.writeStatementsToJson(statements);
    	var msg = new anzo.messaging.JMSMessage(stmts);
    	for (var key in messageProperties) {
    		msg.properties[key] = messageProperties[key];
    	}
    	
    	var responseCallback = function(response) {
            var message = null;
            var callbackCalled = false;
            try {
                if (response.error) {
                    if (callback) {
                        callbackCalled = true;
                        callback(false, response);
                    }
                } else {
                    if (callback) {
                        callbackCalled = true;
                        callback(true);
                    }
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
    	
    	this.jmsClient.publish(msg,topic, responseCallback);
    },
    
    registerListener : function(listener, callback) {
    	// summary: register a listener on this channel.
    	// listener: function(messageProperties, statements)
    	// callback : function(success, error)
    	// 	 since the channel does not subscribe via the underlying jms client
    	// 	 until the first listener is registered, this call reports
    	// 	 any errors subscribing to the channel.
    	if (this.listeners.length > 0) {
    		anzo.utils.addToArray(listener, this.listeners);
    		callback(true);
    	} else {
    		var topic = this.getTopic();
    		this.jmsClient.subscribeToTopics(topic, dojo.hitch(this, this._topicMessageReceived), dojo.hitch(this, function(success, failedTopics, error) {
    			if (success) {
    				this.listeners.push(listener);
    			}
    			callback(success, error);
    		}));
    	}
    	
    },
    
    unregisterListener : function(listener, callback) {
    	var topic = this.getTopic();
    	// summary: unregister a listener on this channel.
    	// listener: function(messageProperties, statements)
    	anzo.utils.removeFromArray(listener, this.listeners);
    	if (this.listeners.length == 0) {
    		this.jmsClient.unsubscribeFromTopics(topic, function(success, error) {
    			if (callback) {
    				callback(success, error);
    			}
    		});
    	} else {
    		callback(true);
    	}
    	
    },
    
    close : function() {
    	// summary: close the channel
    	namedGraph.close();
    },
    
    getNamedGraph : function() {
    	// summary: get the graph with metadata about this channel
    	return namedGraph;
    },
    
    getUri : function() {
    	// summary: get the URI of this channel
    	return uri;
    },
    
    _topicMessageReceived : function(message) {
    	var statements = anzo.client.Serialization.readStatementsFromJsonString(message.body);
    	for (var i=0;i<this.listeners.length;i++) {
    		this.listeners[i](message.properties,statements);
    	}
    }
    
    
});

})();
