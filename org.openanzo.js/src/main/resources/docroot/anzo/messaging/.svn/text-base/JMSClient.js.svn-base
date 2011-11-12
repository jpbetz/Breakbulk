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
dojo.provide("anzo.messaging.JMSClient");

dojo.require("dojox.cometd.longPollTransportJsonEncoded"); // Bring in cometd but only with the transport we are using rather than all transports that would come with doing dojo.require("dojox.cometd")
dojo.require("anzo.messaging.JMSMessage");
dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.log");
dojo.require("anzo.log.log4javascript.MDC");
dojo.require("anzo.profiling");

/*
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
(function(){

var cometdEventTracerInitialized = false;
function createCometdEventTracer() {
    // summary: Create a cometd meta event watcher. It will log any messages published to the
    // "/cometd/meta" dojo channel if the logger, "anzo.messaging.CometdEventTrace"
    // is set to DEBUG level or higher.

    var cometdEventTracer = anzo.log.getLogger("anzo.messaging.CometdEventTrace");
    if (cometdEventTracer.isDebugEnabled() && !cometdEventTracerInitialized) {
        cometdEventTracerInitialized = true;
        dojo.subscribe("/cometd/meta", this, function(eventInfo) {
            cometdEventTracer.debug("/cometd/meta event - action:" + eventInfo.action + " state:" + eventInfo.state + " successful:" + eventInfo.successful + " reestablish:" + eventInfo.reestablish + " ...");
        });
    }
}

var jmsLogger = anzo.log.getLogger("anzo.messaging.JMSMessageTrace");

var log = anzo.log.getLogger("anzo.messaging.JMSClient");

anzo.messaging.JMSClient = {
    // summary: Simple JMS client using the dojo cometd library and bayeux transport.

    // public methods
    reset : function reset() {
        // summary: Resets all of the JMSClient state. This is a rarely called method. The best method to close a connection
        //   and get the JMSClient for a new connection is to call the 'disconnect' method.
        //   This is here for extraneous circumstances or for special situations like unit testing this class.
        delete this.connected;
        delete this.location;
        delete this.username;
        delete this.timeout;
        delete this._loginURL;
        delete this.correlations;
        delete this.messages;
        delete this.sequences;
        delete this.correlationId;
        delete this.destinationListeners;
        delete this.topicSubscriptions;
        if (this._connectionLostHandle) {
            dojo.unsubscribe(this._connectionLostHandle);
            delete this._connectionLostHandle;
        }
    },

    connect : function(properties, connectCallback, timeout) {
        // summary: Connect to the Anzo cloud via the BayeuxJMSBridge.
        // properties: an object with configuration information for the connection. Such as
        //   location - the path, either absolute or relative where Cometd is running.
        //   username/password - anzo login information
        //   loginURL - Optional. the location to which the authentication credentials will be submitted. The default is to append "/anzo_authenticate" to the URL given in 'location'.
        //   timeout - Optional. default timeout (in milliseconds) for all JMSClient operations (defaults to 30 seconds).
        // connectCallback: Function(Object status, Object errorInfo)
        //   Callback called once the connection is complete. The status argument can be compared to
        //   anzo.messaging.CONNECTION_STATUS_CONNECTED to check if the connection succeeded. In case of error,
        //   the errorInfo argument will have more information about the cause of the error.
        // timeout: Number.
        //   Optional. Maximum time in milliseconds to wait for the request to complete. -1 indicates infinite timeout.
        //   If not, given the timeout specified in the properties will be used. Or, if no timeout is specified in
        //   the properties, the default timeout of 30 seconds will be used.
        
        createCometdEventTracer();
        
        if (this.connected) {
            log.debug("JMSClient already connected.");
            if (connectCallback) {
                connectCallback(anzo.messaging.CONNECTION_STATUS_CONNECTED, null);
            }
            return;
        }
        this.connected = false;
        this.location = properties.location;
        this.username = properties.username;
        if (properties.timeout) {
            this.timeout = properties.timeout;
        } else {
            // default timeout of 30 seconds. Likely this will be overridden by configuration
            // in properties, if not in the req-resp call itself.
            this.timeout = 30000;
        }
        if (properties.loginURL) {
            this._loginURL = properties.loginURL;
        } else {
            this._loginURL = this.location + "anzo_authenticate";
        }

        if (timeout == null) {
            timeout = this.timeout;
        }

        this.correlations = {};
        this.messages={};
        this.sequences={};
        this.correlationId = 0;
        this.destinationListeners = {};
        this.topicSubscriptions = {};

        dojo.xhrPost({
            url : this._loginURL,
            content : { anzo_username : this.username, anzo_password : properties.password },
            timeout : timeout == -1 ? undefined : timeout,
            sync : false,
            load : dojo.hitch(this, function _jmsClient_authenticateSuccess(response, ioArgs) {
                if (log.isDebugEnabled()) {
                    log.debug("Authentication success. Initializing cometd.");
                }

                // Now that we are authenticated, we can initialize cometd.

                // Listen to the event signaling cometd being finished connecting. We'll proceed with our connection
                // to the JMS bridge once the basic cometd connection is finished.
                var sawHandshake = false;
                var initHandle = dojo.subscribe("/cometd/meta", this, function(info) {
                    // Cometd will fire a 'handshake' event and then a 'connect' event. When the successful'connect'
                    // event arrives we can consider this connection fully established.
                    if (log.isDebugEnabled()) {
                        log.debug("Cometd connection complete:" + info.action + " info.state:" + info.state + " info.successful:" + info.successful + " sawHandshake:" + sawHandshake);
                    }
                    if (info.action == "handshake" && sawHandshake == false && info.successful) {
                        log.debug("JMSClient saw successful handshake.");
                        sawHandshake = true;
                    } else if (info.action == "connect" && sawHandshake == true && info.successful) {
                        dojo.unsubscribe(initHandle);
                        initHandle = null;
                        log.debug("Cometd connection complete. Finishing JMS connection.");
                        this._jmsConnect(connectCallback, timeout);
                    } else {
                        log.debug("Invalid comet event while initializing. Firing failed JMS client callback.");
                        dojo.unsubscribe(initHandle);
                        initHandle = null;
                        if (connectCallback) {
                            var response = {};
                            response.error = true;
                            response.status = anzo.messaging.RESPONSE_STATUS_UNKNOWN_ERROR;
                            response.statusMessage = anzo.messaging.RESPONSE_STATUS_MESSAGE_UNKNOWN_ERROR;
                            response.cometdMetaMessageSummary = { action: info.action, state: info.state, successful: info.successful }; // We only take these well-known properties from the /cometd/meta message because the message may have properties like the 'cometd' property and others which would not properly output in JSON (due to having functions and object cycles). We expect error information to be representable in JSON.
                            connectCallback(anzo.messaging.CONNECTION_STATUS_DISCONNECTED, response);
                        }
                    }
                });
                dojox.cometd._advice = { reconnect: "none" }; // Edit this internal cometd state so that, if the 'init' fails (such as with a 404), cometd won't automatically retry. We'll leave it up to the caller to retry if they want to.
                dojox.cometd.init(this.location, {advice : { reconnect: "none" }}, {});
            }),
            error : dojo.hitch(this, function _jmsClient_authenticateFailure(response, ioArgs) {
                if (log.isDebugEnabled()) {
                    log.debug("Authentication failure. Auth url:" + (ioArgs ? ioArgs.url : ioArgs));
                }
                if (connectCallback) {
                    var msg = {};
                    msg.error = true;
                    msg.response = response;
                    if (response.status) {
                        msg.status = response.status;
                        msg.statusMessage = response.message;
                    } else {
                        msg.status = anzo.messaging.RESPONSE_STATUS_UNKNOWN;
                        msg.statusMessage = anzo.messaging.RESPONSE_STATUS_MESSAGE_UNKNOWN_ERROR;
                    }
                    connectCallback(anzo.messaging.CONNECTION_STATUS_DISCONNECTED, msg);
                }
            })
        });
    },

    startBatch : function() {
        // summary: Used to batch multiple 'publish' messages into a single request to the server.
        //  No messages will be sent until a correspoding 'endBatch' call is made. startBatch can
        //  be called multiple times and then endBatch must be called the same number of times that
        //  startBatch was called.

        if (!this.connected) {
            throw new Error("Not connected");
        }

        dojox.cometd.startBatch();
    },

    endBatch : function() {
        // summary: Stop batching 'publish' messages and send the currently batched messages to the server.
        //  No messages will be sent until a correspoding 'endBatch' call is made for every 'startBatch' call.

        if (!this.connected) {
            throw new Error("Not connected");
        }

        dojox.cometd.endBatch();
    },

    publish : function(msg, destination, responseCallback, timeout) {
        // summary: Publish msg to the given jms destination. The optional responseCallback is a function to be called
        //    when a msg is received to any subscribed destination whose correlationId matches the one we are sending.
        // msg : Object
        //    The message to send. This object will be sent as JSON so it should not have any circular references.
        // destination : String
        //    The destination to which the message should be sent.
        // responseCallback: Function(Object response)
        //   Optional. Called when a response to the message is received, or a timeout occurs. The response argument
        //   contains the response message.
        // timeout: Number.
        //   Optional. Maximum time in milliseconds to wait for the request to complete. -1 indicates infinite timeout.
        //   If not, given the timeout specified in the properties will be used. Or, if no timeout is specified in
        //   the properties, the default timeout of 30 seconds will be used.

        if (!this.connected) {
            throw new Error("Not connected");
        }

        anzo.profiling.mark("JMSClient");

        msg[anzo.messaging.JMS_MSG_DESTINATION] = destination;
        if (!msg.properties[anzo.messaging.JMS_MSG_PROPERTY_CORRELATION_ID]) {
        	msg.properties[anzo.messaging.JMS_MSG_PROPERTY_CORRELATION_ID] = this._newCorrelationId();
        }
        if (responseCallback) {
            var _timeout;
            // Use the global timeout setting if a specific one wasn't specified for this call
            if (timeout != null) {
                _timeout = timeout;
            } else {
                _timeout = this.timeout;
            }
            this.correlations[msg.properties[anzo.messaging.JMS_MSG_PROPERTY_CORRELATION_ID]] = responseCallback;
            if (_timeout != -1) { // timeout of -1 means infinite timeout
                setTimeout(dojo.hitch(this, function () { this._requestTimeout(msg.properties[anzo.messaging.JMS_MSG_PROPERTY_CORRELATION_ID]); }), _timeout);
            }
        }
        if (jmsLogger.isDebugEnabled()) {
            jmsLogger.debug("Publishing Message:" + dojo.toJson(msg, true));
        }
        dojox.cometd.publish(anzo.messaging.CHANNEL_BRIDGE, msg);
        anzo.profiling.measure("JMSClient_publish", "JMSClient");
    },

    disconnect : function(disconnectCallback) {
        if (!this.connected) {
            log.debug("already disconnected.");
            disconnectCallback(anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
            return;
        }

        if (this._connectionLostHandle) { // Unsubscribe from this event since a disconnection event at this point is expeted rather than an unexpected lost connection
            dojo.unsubscribe(this._connectionLostHandle);
        }

        if (disconnectCallback) {
            var handle = dojo.subscribe("/cometd/meta", this, function(info) {
                if (log.isDebugEnabled()) {
                    log.debug("disconnect cometd callback- action:" + info.action + " info.state:" + info.state + " info.successful:" + info.successful);
                }
                if (info.action == "disconnect" && info.successful) {
                    var finishDisconnect = dojo.hitch(this, function _finishDisconnect(status) {
                        this.connected = false;
                        dojo.unsubscribe(handle);
                        handle = null;
                        this.reset();
                        log.debug("calling disconnectCallback");
                        disconnectCallback(status);
                    });
                    if (info.state == "disconnected" || dojox.cometd.state() == "disconnected") {
                        // cometd is completely disconnected, so we can fire the callback.
                        log.debug("Disconnect cometd meta event came while state is disconnected.");
                        finishDisconnect(anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                    } else {
                        // Wait for cometd to be completely disconnected before firing the callback to be
                        // sure all cometd state is stable. We know that cometd is completely disconnected when we've seen
                        // a "disconnect" event AND we see the dojox.cometd.state() set to "disconnected".
                        // Unfortunately, there isn't too much we can do here but poll via setTimeout.
                        // We give up polling after a while and send an erroneous state.
                        var attempts = 10;
                        var interval = 150;
                        log.debug("Disconnect cometd meta event came while state is not 'disconnected' so we start waiting for cometd state to become 'disconnected'.");
                        setTimeout(function _waitForDisconnect() {
                            var state = dojox.cometd.state();
                            attempts--;
                            log.debug("Polling for cometd state. dojox.cometd.state:" + state + " Attempts remaining:" + attempts);
                            if (state == "disconnected") {
                                log.debug("State is 'disconnected'");
                                finishDisconnect(anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                            } else if (attempts > 0) {
                                setTimeout(_waitForDisconnect, interval);
                            } else {
                                log.debug("Quitting polling for 'disconnected' state. Too many attempts. Firing callback with 'unknown' state.");
                                finishDisconnect(anzo.messaging.CONNECTION_STATUS_UNKNOWN);
                            }
                        }, interval);
                    }
                }
            });
        }
        dojox.cometd.disconnect();
    },

    subscribeToTopics : function(topics, listener, responseCallback, timeout) {
        // summary: Subscribe to messages on a topic.  Only topics pertaining to
        //   named graph updates, transactions, and statement channels will be accepted
        //   by the server.
        // description: Only one listener per topic is kept at a time. If there is already
        //   a listener subscribed for the given topic, then it will be replaced with the
        //   given listener.
        // topic: String | Array of String
        //   The topic string or an array of topic strings.
        // listener: Function(Object message)
        //   The function to call whenever a topic messages is received. The function takes a single argument
        //   which includes the JMS message received on the topic.
        // responseCallback: Function(success, failedTopics, errorInfo)
        //   Optional. Callback called once the call is complete or upon failure.
        //   The success argument denotes if the call completed correctly. If there was an error subscribing
        //   to any of the requested topics, then each failed topic is listed in the failedTopics array. If success
        //   if false, the errorInfo argument contains debugging information. One suggested use is to display
        //   the errorInfo as a JSON string in a detailed error message. If success is true, then errorInfo is null.
        // timeout: Number
        //   Optional. Maximum time in milliseconds to wait for the request to complete. -1 indicates infinite timeout.
        //   If not given, the global timeout (as specified in the properties given to 'connect' or a default timeout is used.

        if (!dojo.isFunction(listener)) {
            throw new Error("subscribeToTopics - Missing required argument: listener.");
        }

        this._doTopicOperation(true, topics, listener, responseCallback, timeout);

    },

    unsubscribeFromTopics : function(topics, responseCallback, timeout) {
        // summary: Unsubscribe from the given topic.
        // description: Only one listener per topic is kept at a time so unsubscribing
        //   once will stop notifications regardless of how many times the subscribeToTopics
        //   method was called for a particular topic. The method will simply call the callback, if any,
        //   with success set to true immediately if the topic is not subscribed.
        // topic: String | Array of String.
        //   The topic or topics to unsubscribe.
        // responseCallback: Function(success, failedTopics, errorInfo)
        //   Optional. Callback called once the call is complete or upon failure.
        //   The success argument denotes if the call completed correctly. If there was an error unsubscribing
        //   to any of the requested topics, then each failed topic is listed in the failedTopics array. If success
        //   if false, the errorInfo argument contains debugging information. One suggested use is to display
        //   the errorInfo as a JSON string in a detailed error message. If success is true, then errorInfo is null.
        // timeout: Number
        //   Optional. Maximum time in milliseconds to wait for the request to complete. -1 indicates infinite timeout.
        //   If not given, the global timeout (as specified in the properties given to 'connect' or a default timeout is used.

        this._doTopicOperation(false, topics, null, responseCallback, timeout);
    },

    _doTopicOperation : function(subscribeOrUnsubscribe, topics, listener, responseCallback, timeout) {
        // summary: Subscribes or unsubscribes from the given topics. Only topics pertaining to
        //   named graph updates, transactions, and statement channels will be accepted
        //   by the server.
        // description: Only one listener per topic is kept at a time. If there is already
        //   a listener subscribed for the given topic, then it will be replaced with the
        //   given listener.
        // subscribeOrUnsubscribe: Boolean
        //   If true, the method will subscribe to the given topics, otherwise it will unsubscribe from the given topics.
        // topics: String | Array of String
        //   The topic string or an array of topic strings.
        // listener: Function(Object message)
        //   The function to call whenever a topic messages is received. The function takes a single argument
        //   which includes the JMS message received on the topic. This is ignored in the unsubscribe case.
        // responseCallback: Function(success, failedTopics, errorInfo)
        //   Optional. Callback called once the call is complete or upon failure.
        //   The success argument denotes if the call completed correctly. If there was an error (un)subscribing
        //   to any of the requested topics, then each failed topic is listed in the failedTopics array. If success
        //   if false, the errorInfo argument contains debugging information. One suggested use is to display
        //   the errorInfo as a JSON string in a detailed error message. If success is true, then errorInfo is null.
        //   Optional. Maximum time in milliseconds to wait for the request to complete. -1 indicates infinite timeout.
        //   If not given, the global timeout (as specified in the properties given to 'connect' or a default timeout is used.

        if (!dojo.isString(topics) && !dojo.isArray(topics)) {
            throw new Error("_doTopicOperation - Missing required argument: topics");
        }
        if (subscribeOrUnsubscribe && !dojo.isFunction(listener)) {
            throw new Error("_doTopicOperation - Missing required argument: listener.");
        }
        if (dojo.isString(topics)) {
            topics = [ topics ];
        }
        if (topics.length == 0) {
            if (responseCallback) {
                responseCallback(true, null, null);
            }
        } else {
            anzo.profiling.mark("JMSClient");

            // Filter out the topics to which we are already (un)subscribed.
            var topicsForServer = [];
            for (var i = 0; i < topics.length; i++) {
                var topic = topics[i]
                if (subscribeOrUnsubscribe) {
                    if (topic in this.topicSubscriptions) {
                        this.topicSubscriptions[topic] = listener;
                    } else {
                        topicsForServer.push(topic);
                    }
                } else {
                    if (topic in this.topicSubscriptions) {
                        topicsForServer.push(topic);
                    }
                }
            }
            if (topicsForServer.length == 0) {
                if (responseCallback) {
                    responseCallback(true, null, null);
                }
            } else {
                // Call the server to (un)subscribe to the topics
                var msg = {};
                msg[anzo.messaging.CONTROL_MSG_TOPICS] = topics;
                var operation = subscribeOrUnsubscribe ? anzo.messaging.CONTROL_TYPE_TOPIC_SUBSCRIBE : anzo.messaging.CONTROL_TYPE_TOPIC_UNSUBSCRIBE;
                this._publishControlMessage(msg, operation,  dojo.hitch(this, function onInternalSubscribeComplete(response) {
                    anzo.profiling.mark("JMSClient");

                    var success = !response.error && response.message[anzo.messaging.CONTROL_MSG_STATUS] == anzo.messaging.TOPIC_SUBSCRIBE_STATUS_SUCCESS;
                    var failedTopics = response.message ? response.message[anzo.messaging.TOPIC_SUBSCRIBE_FAILED_TOPICS] : null;
                    if (!success && !response.message) {
                        // If there is a failure without a response message then it was either a timeout or something catastropic.
                        // We'll consider all topics to be failed in this case.
                        failedTopics = topics;
                    }
                    // Add/remove the topic listeners for successful topics
                    for (var i = 0; i < topicsForServer.length; i++) {
                        var topic = topicsForServer[i];
                        if (!failedTopics || dojo.indexOf(failedTopics, topic) == -1) {
                            if (subscribeOrUnsubscribe) {
                                this.topicSubscriptions[topic] = listener;
                            } else {
                                delete this.topicSubscriptions[topic];
                            }
                        }
                    }

                    anzo.profiling.measure("JMSClient_post_doTopicOperation", "JMSClient");

                    if (responseCallback) {
                        responseCallback(success, failedTopics, success ? null : response);
                    }
                }), timeout);
                anzo.profiling.measure("JMSClient__doTopicOperation", "JMSClient");
            }
        }
    },

    // private methods

    _publishControlMessage : function(msg, operation, responseCallback, timeout, skipConnectedCheck) {
        // summary: Publish a message on the BayeuxJMSBridge's control channel.
        //   The optional responseCallback is a function to be called when a msg is received to
        //   any subscribed destination whose correlationId matches the one we are sending.
        if (!skipConnectedCheck && !this.connected) {
            throw new Error("Not connected");
        }

        anzo.profiling.mark("JMSClient");

        var correlationId = this._newCorrelationId();
        msg[anzo.messaging.CONTROL_MSG_CORRELATION_ID] = correlationId;
        msg[anzo.messaging.CONTROL_MSG_CONTROL_TYPE] = operation;

        if (responseCallback) {
            var _timeout;
            // Use the global timeout setting if a specific one wasn't specified for this call
            if (timeout != null) {
                _timeout = timeout;
            } else {
                _timeout = this.timeout;
            }
            this.correlations[correlationId] = responseCallback;
            if (log.isDebugEnabled()) {
                log.debug("_publishControlMessage - operation:" + operation + " correlationId:" + correlationId);
            }
            if (_timeout != -1) { // timeout of -1 means infinite timeout
                setTimeout(dojo.hitch(this, function() { this._requestTimeout(correlationId); }), _timeout);
            }
        }
        if (jmsLogger.isDebugEnabled()) {
            jmsLogger.debug("Publishing Control Message:" + dojo.toJson(msg, true));
        }
        dojox.cometd.publish(anzo.messaging.CHANNEL_CONTROL, msg);
        anzo.profiling.measure("JMSClient__publishControlMessage", "JMSClient");
    },

    _newCorrelationId : function() {

        // The opIdPrefix in the MDC is useful for a grouping operations related to higher-level tasks.
        // For example, grouping operations realted to a particular test. This helps match server logs to client logs.
        var opIdPrefix = anzo.log.log4javascript.MDC.get("opIdPrefix");
        return (opIdPrefix ? (opIdPrefix + ":") : "") + dojox.cometd.clientId + "-" + this.correlationId++;
    },

    _jmsConnect : function(connectCallback, timeout) {
        var tempChannelId = anzo.messaging.CHANNEL_USER_PREFIX + this.username + "/" + dojox.cometd.clientId;
        dojox.cometd.startBatch();
        dojox.cometd.subscribe(tempChannelId, this, "_handleMessageReceived");
        var correlationId = this._newCorrelationId();
        var msg = {};
        msg[anzo.messaging.CONTROL_MSG_PROTOCOL_VERSION] = anzo.messaging.PROTOCOL_VERSION;
        this._publishControlMessage(msg, anzo.messaging.CONTROL_TYPE_CONNECT, dojo.hitch(this, function(response) {
            this._connectComplete(response, connectCallback);
        }), timeout, true);
        dojox.cometd.endBatch();
    },

    _connectComplete : function(response, connectCallback) {
        if (response.error) {
            if (connectCallback) {
                connectCallback(anzo.messaging.CONNECTION_STATUS_DISCONNECTED, response);
            }
        } else {
            var message = response.message;
            var status = message[anzo.messaging.CONTROL_MSG_STATUS];
            if (status == anzo.messaging.CONNECTION_STATUS_CONNECTED) {
                this.connected = true;

                // Listen to cometd events that would signal failures in the poll requests so that
                // we can fire events when the "connection" is lost.
                this._connectionLostHandle = dojo.subscribe("/cometd/meta", this, dojo.hitch(this, function onCometdPollFailure(info) {
                    if (info.action == "connect" && info.successful == false) {
                        // A cometd poll request had a failure. We'll consider that a broken connection.
                        if (log.isDebugEnabled()) {
                            log.debug("Failed connect operation in cometd...JMSClient connection presumed lost. Firing disconnect event. action:" + info.action + " successful:" + info.successful);
                        }
                        if (this._connectionLostHandle) {
                            dojo.unsubscribe(this._connectionLostHandle); // we need to unsubscribe before calling cometd.disconnect since that method will fire this event again.
                        }

                        // We need to stop cometd from attempting to reconnect immediately so that
                        // we let the caller of our API decide what to do. Disconnecting cometd
                        // may cause another request to go out and fail but it's the cleanest way to reset cometd.
                        dojox.cometd.disconnect();

                        this.connected = false;
                        this.reset();
                        this.onDisconnect();
                    }
                }));
            }
            if (connectCallback) {
                connectCallback(status, message);
            }
        }
    },

    _handleMessageReceived : function(message) {
        // summary: Handles a received message. This could be a response to a control message or a JMS message.
        if (jmsLogger.isDebugEnabled()) {
            jmsLogger.debug("Incoming Message: " + dojo.toJson(message, true));
        }
        var correlationId = null;

        anzo.profiling.mark("JMSClient");

        var messageDataProperties = message.data.properties;
        if (messageDataProperties && messageDataProperties[anzo.messaging.JMS_MSG_PROPERTY_TYPE] == anzo.messaging.MSG_TYPE_TOPIC_MESSAGE) {
            // Handle a topic message by sending it to the appropriate topic listener.
            var topic = messageDataProperties[anzo.messaging.JMS_MSG_PROPERTY_TOPIC];
            if (topic && topic.length > 0) {
                var topicListener = this.topicSubscriptions[topic];
                if (topicListener) {
                    if (log.isDebugEnabled()) {
                        log.debug("_handleMessageReceived - Recieved topic message for " + topic + ". Calling listener.");
                    }
                    topicListener(message.data);
                } else {
                    log.info("_handleMessageReceived - Recieved topic messag for " + topic + " but no topic exists. Ignoring message.");
                }
            } else {
                log.info("_handleMessageReceived - Malformed topic message. Empty data in " + anzo.messaging.JMS_MSG_PROPERTY_TOPIC + " property.");
            }
        } else {
            // Handle all other kinds of messages
            if (messageDataProperties) {
                correlationId = messageDataProperties[anzo.messaging.JMS_MSG_PROPERTY_CORRELATION_ID];
            }
            if (!correlationId) {
                correlationId = message.data[anzo.messaging.CONTROL_MSG_CORRELATION_ID];
                if (correlationId) {
                    log.debug("_handleMessageReceived - got message with control correlation ID:" + correlationId)
                }
            }

           if (correlationId) {
                anzo.profiling.mark("JMSClient");
           		if(messageDataProperties&&messageDataProperties[anzo.messaging.DONE]){
           			var messagesForCor=this.messages[correlationId];
           			if(messagesForCor==null){
           				messagesForCor=[message];
           				this.messages[correlationId]=messagesForCor;
           				this.sequences[correlationId]=parseInt(messageDataProperties[anzo.messaging.SEQ]);
           			}else{
           				messagesForCor=messagesForCor.concat([message]);
           				this.messages[correlationId]=messagesForCor;
           				if((this.sequences[correlationId]+1)==parseInt(messageDataProperties[anzo.messaging.SEQ])){
           					this.sequences[correlationId]=parseInt(messageDataProperties[anzo.messaging.SEQ]);
           				}else{
           					log.error("Sequence # missing or out of order:"+(this.sequences[correlationId]+1)+":"+parseInt(messageDataProperties[anzo.messaging.SEQ]));
           				}
           			}
           			if(messageDataProperties[anzo.messaging.DONE]=="true"){
           				delete this.messages[correlationId];
           				delete this.sequences[correlationId];
           				var corCallback = this.correlations[correlationId];
		                if (corCallback) {
		                    delete this.correlations[correlationId];
		                    var response = {};
		                    response.error = false;
		                    response.status = anzo.messaging.RESPONSE_STATUS_SUCCESS;
		                    response.statusMessage = anzo.messaging.RESPONSE_STATUS_MESSAGE_SUCCESS;
		                    response.jmsMessages = messagesForCor;
		                    try {
		                        anzo.log.log4javascript.MDC.put("operationId", correlationId);
                       			anzo.profiling.measure("JMSClient_handleMessageReceived", "JMSClient");
		                        corCallback(response);
		                    } finally {
		                        anzo.log.log4javascript.MDC.remove("operationId");
		                    }
		                } else {
		                    log.warn("_handleMessageReceived - Received message with correlationId " + correlationId + " but could not find its callback. Message:" + dojo.toJson(message, true));
		                }
           			} else {
           			    anzo.profiling.measure("JMSClient_handleMessageReceived", "JMSClient");
           			}
           		}else{
	                var corCallback = this.correlations[correlationId];
	                if (corCallback) {
	                    delete this.correlations[correlationId];
	                    var response = {};
	                    response.error = false;
	                    response.status = anzo.messaging.RESPONSE_STATUS_SUCCESS;
	                    response.statusMessage = anzo.messaging.RESPONSE_STATUS_MESSAGE_SUCCESS;
	                    response.message = message.data;
	                    response.jmsMessage = message;
	                    try {
	                        anzo.log.log4javascript.MDC.put("operationId", correlationId);
	                        corCallback(response);
	                    } finally {
	                        anzo.log.log4javascript.MDC.remove("operationId");
	                    }
	                } else {
	                    log.warn("_handleMessageReceived - Received message with correlationId " + correlationId + " but could not find its callback. Message:" + dojo.toJson(message, true));
	                }
                }
            } else {
                // No correlation id so just call the listeners.
                this.onMessageReceived(message);
            }
        }
    },

    _requestTimeout : function(correlationId) {
        if (this.correlations) { // Since this is called from a setTimeout, it's possible it could be called after the JMSClient was reset and so the correlations map wouldn't exist. Ignore the call in such a case.
            var corCallback = this.correlations[correlationId];
            if (corCallback) {
                delete this.correlations[correlationId];
                var response = {};
                response.error = true;
                response.status = anzo.messaging.RESPONSE_STATUS_TIMEOUT;
                response.statusMessage = anzo.messaging.RESPONSE_STATUS_MESSAGE_TIMEOUT;
                corCallback(response);
            }
        }
    },

    // event hooks

    onMessageReceived : function(message) {
        // summary: event fired when a message wthout a correlation id is received.
        //  Such messages are typically notification messages. Connect to this message with dojo.connect().

        // message: object representing the JMS message and related information.
        //  To get at the JMS message use `message.data.properties` and `message.data.body`.
    },

    onDisconnect : function() {
        // summary: event fired when the JMSClient is disconnected from the server. This includes
        //   either when explicitly disconnected by calling 'disconnect()' or when the server suddenly fails to respond.
    }


}

dojo.mixin(anzo.messaging, {

    PROTOCOL_VERSION                        : "1.1",

    CHANNEL_CONTROL                         : "/anzo/control",
    CHANNEL_BRIDGE                          : "/anzo/bridge",
    CHANNEL_USER_PREFIX                     : "/anzo/user/",

    CONTROL_MSG_PROTOCOL_VERSION            : "protocolVersion",
    CONTROL_MSG_CONTROL_TYPE                : "type",
    CONTROL_MSG_CORRELATION_ID              : "correlationId",
    CONTROL_MSG_STATUS                      : "status",
    CONTROL_MSG_ERROR_MESSSAGE              : "errorMessage",
    CONTROL_MSG_TOPICS                      : "topics",
    CONTROL_MSG_USER_ROLES					: "userRoles",
    CONTROL_MSG_USER_URI					: "userUri",
    CONTROL_MSG_USER_IS_SYSADMIN    		: "isSysadmin",

    JMS_MSG_DESTINATION                     : "destination",
    JMS_MSG_PROPERTY_CORRELATION_ID         : "JMSCorrelationID",
    JMS_MSG_PROPERTY_TYPE                   : "type",
    JMS_MSG_PROPERTY_TOPIC                  : "topic",
    JMS_MSG_BODY                            : "body",
    MSG_TYPE_TOPIC_MESSAGE	                : "topicMessage",

    CONTROL_TYPE_CONNECT                    : "connect",
    CONTROL_TYPE_DISCONNECT                 : "disconnect",
    CONTROL_TYPE_TOPIC_SUBSCRIBE     	    : "topicSubscribe",
    CONTROL_TYPE_TOPIC_UNSUBSCRIBE   	    : "topicUnsubscribe",

    CONNECTION_STATUS_CONNECTED             : "connected",
    CONNECTION_STATUS_DISCONNECTED          : "disconnected",
    CONNECTION_STATUS_UNKNOWN               : "unknown",
    TOPIC_SUBSCRIBE_STATUS_FAILED           : "failed",
    TOPIC_SUBSCRIBE_STATUS_SUCCESS          : "success",
    TOPIC_SUBSCRIBE_FAILED_TOPICS           : "failedTopics",
    PUBLISH_STATUS_FAILED           		: "failed",
    PUBLISH_STATUS_SUCCESS          		: "success",
    DONE									: "done",
   	SEQ										: "sequence",

    RESPONSE_STATUS_SUCCESS                 : 0,
    // note, this success only means that we received a response.
    // the message itself may represent a failure at a higher level.
    RESPONSE_STATUS_MESSAGE_SUCCESS         : "Request response succeeded",
    RESPONSE_STATUS_TIMEOUT                 : 1,
    RESPONSE_STATUS_MESSAGE_TIMEOUT         : "Request response timeout",
    RESPONSE_STATUS_UNKNOWN_ERROR           : 2,
    RESPONSE_STATUS_MESSAGE_UNKNOWN_ERROR   : "Unknown error during request"

});
})();
