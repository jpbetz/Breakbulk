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
dojo.provide("anzo.tests.messaging.JMSClientRecorder");

dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.log");

/*
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>) 
 * @author Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>) 
 */

(function() {
var log = anzo.log.getLogger("anzo.tests.messaging.JMSClientRecorder");

anzo.tests.messaging.JMSClientRecorder = {
    // summary: Can record and playback messages sent and received via a JMSClient. This is usful for creating unit tests since it
    //   can be used to exercise functionality without the network. This object expects to be used within the D.O.H. unit testing framework. 
    // description: The JMSClientRecorder works by overriding some methods in the JMSClient object so that it can intercept messages
    //   and store them or respond with a recorded message. The object has three modes of operation: MODE_NORMAL, MODE_RECORD, and MODE_PLAYBACK.
    //   In MODE_NORMAL, the JMSClientRecorder does nothing. The JMSClient works as normal. That is the default mode. In MODE_RECORD, the JMSClientRecorder will
    //   record requests, responses, and notifications until the current unit test suite completes. Once completed, it prints a JSON object
    //   representing the recorded information. The JSON string can be used as input to the loadRequests method for later playback.
    //   In MODE_PLAYBACK, the JMSClientRecorder intercepts requests and looks up the associated response. If it finds one, it immediately sends
    //   without any network activity. If it doesn't find the request in its request library, it throws an error.
    //   The JMSClientRecorder supports recording and playback of notification messages (incoming messages without a request) but it has a few
    //   limitations. It does not record the relative timing of messages, only the order. As such, it only records notification messages after
    //   having seen at least one request. During recording, it associates notification messages with the current pending request. During playback,
    //   when a request is sent, it responds with all associated messages in order. So the order of messages from recording is kept but the exact timing
    //   between received messages is not simulated during playback.   

    MODE_NORMAL : "normal",
    MODE_RECORD : "record",
    MODE_PLAYBACK : "playback",

    MESSAGE_DELAY : 5, // Time, in milliseconds, to simulate the network overhead and server's processing time for requests when in MODE_PLAYBACK. 
    
    mode : this.MODE_NORMAL,
    requestCount : 0,
    testId : "",
    testNames : new anzo.utils.Set(),
    requests : {},
    currentMsgKey : null,
    onMessageReceivedHandle : null,
    onEndTestHandle : null,
    onTestStartedHandle : null,
    
    _RecordedMessage : function(message, isResponse, request) {
        // summary: Internal struct used by the JMSClientRecorder. Requests are associated with a list of these
        //   with at most one of then having isResponse set to true.
        this.message = message;
        this.isResponse = isResponse;
        this.correspondingRequest = request;
    },
    
    setMode : function(mode) {
        // summary: enable normal, record, or playback mode as described in the JMSClientRecorder object description. This method can only
        //   be reliably called once. Changing the mode 'on-the-fly' is not currently supported.
        if (mode == this.mode) {
            return;
        }
        this.mode = mode;
        
        // Disconnect events to start clean
        if (this.onMessageReceivedHandle) {
            dojo.disconnect(this.onMessageReceivedHandle);
        }
        if (this.onEndTestHandle) {
            dojo.disconnect(this.onEndTestHandle);
        }
        if (this.onTestStartedHandle) {
            dojo.disconnect(this.onTestStartedHandle);
        }
        
        if (mode == this.MODE_RECORD) {
            anzo.messaging.JMSClient.original_publish = anzo.messaging.JMSClient.publish;
            anzo.messaging.JMSClient.original_publishControlMessage = anzo.messaging.JMSClient._publishControlMessage;
            anzo.messaging.JMSClient.publish = this.record_publish;
            anzo.messaging.JMSClient._publishControlMessage = this.record_publishControlMessage;

            this.onMessageReceivedHandle = dojo.connect(anzo.messaging.JMSClient, "onMessageReceived", dojo.hitch(this, this.record_onMessageReceived));
            this.onEndTestHandle = dojo.connect(tests,"_onEnd", dojo.hitch(this, function()  {
                if (window && window.open && document && document.open && document.write) {
                    // If we are in the browser, then display a link which pops up a page containing the recorded data JSON string.
                    var linkStr = 'JMSClientRecorder: <a href="javascript:anzo.tests.messaging.JMSClientRecorder._showRecordedMessageDataPopup(dojo.toJson(anzo.tests.messaging.JMSClientRecorder.requests, true));">Click here to see recorded message data</a>.';
                    doh.debug(linkStr);
                } else {
                    // We aren't in the browser so just output the recorded requests to the console.
                    doh.debug("DUMP (one-line)\n" + dojo.toJson(anzo.tests.messaging.JMSClientRecorder.requests));
                    doh.debug("DUMP (readable)\n\n" + dojo.toJson(anzo.tests.messaging.JMSClientRecorder.requests, true) + "\n\n");
                }
            }));
            
        } else if (mode == this.MODE_PLAYBACK) {
            //anzo.messaging.JMSClient.connected = true;
            anzo.messaging.JMSClient.publish = this.playback_publish;
            anzo.messaging.JMSClient._publishControlMessage = this.playback_publishControlMessage;
            
            anzo.messaging.JMSClient.connect = function playbackConnect(properties, connectCallback) {
                if (anzo.messaging.JMSClient.connected) {
                    if (connectCallback) {
                        connectCallback(anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    }
                    return;
                }
                anzo.messaging.JMSClient.connected = true;
                anzo.messaging.JMSClient.graphUpdateSubscriptions = {}
                var msg = {};
                msg[anzo.messaging.CONTROL_MSG_PROTOCOL_VERSION] = anzo.messaging.PROTOCOL_VERSION;
                this._publishControlMessage(msg, anzo.messaging.CONTROL_TYPE_CONNECT, function(response) {
                    anzo.messaging.JMSClient.connected = true;
                    if (connectCallback) {
                        connectCallback(anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    }
                }, undefined, true);
            };
            
            anzo.messaging.JMSClient.disconnect = function playbackDisconnect(disconnectCallback) {
                anzo.messaging.JMSClient.connected = false;
                anzo.messaging.JMSClient.graphUpdateSubscriptions = {}
                if (disconnectCallback) {
                    disconnectCallback(anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                }
            };
        }
        if (mode == this.MODE_PLAYBACK || mode == this.MODE_RECORD) {
            
            this.onTestStartedHandle = dojo.connect(tests,"_testStarted", function(group, fixture) {
                if (!fixture.name || anzo.tests.messaging.JMSClientRecorder.testNames.contains(fixture.name)) {
                    throw new Error("test must have unique name");
                }
                anzo.tests.messaging.JMSClientRecorder.testId = group + "::" + fixture.name;
                anzo.tests.messaging.JMSClientRecorder.requestCount = 0;
            });
        }
    },
    
    record_publish : function(msg, destination, responseCallback, timeout) {
        var callback = anzo.tests.messaging.JMSClientRecorder._prepareMessageRecording(msg, destination, responseCallback);
        anzo.messaging.JMSClient.original_publish(msg, destination, callback, timeout);
    },

    _prepareMessageRecording : function(msg, destination, responseCallback) {
        var key = anzo.tests.messaging.JMSClientRecorder.getMsgKey(msg, destination);
        if (key in anzo.tests.messaging.JMSClientRecorder.requests) {
            throw new Error("Request already exists with key: " + key);
        }
        anzo.tests.messaging.JMSClientRecorder.requests[key] = []; // Record the request without a response first.
        anzo.tests.messaging.JMSClientRecorder.currentMsgKey = key; // Store the new request's key to use for storing any incoming (notification) messages that happen between this request and the next. 
        var callback = function(response) {
            var recordedMessage = new anzo.tests.messaging.JMSClientRecorder._RecordedMessage(dojo.clone(response), true, msg);
            anzo.tests.messaging.JMSClientRecorder.requests[key].push(recordedMessage); // Now save the response
            if (responseCallback) {
                responseCallback(response);
            }
        }
        return callback;
    },

    record_publishControlMessage : function(msg, operation, responseCallback, timeout, skipConnectedCheck) {
        var callback = anzo.tests.messaging.JMSClientRecorder._prepareMessageRecording(msg, operation, responseCallback);
        anzo.messaging.JMSClient.original_publishControlMessage(msg, operation, callback, timeout, skipConnectedCheck);
    },

    playback_publishControlMessage : function(msg, operation, responseCallback, timeout, skipConnectedCheck) {
        anzo.tests.messaging.JMSClientRecorder.playback_publish(msg, operation, responseCallback, timeout);
    },
    
    playback_publish : function(msg, destination, responseCallback, timeout) {
        var key = anzo.tests.messaging.JMSClientRecorder.getMsgKey(msg, destination);
        if (!(key in anzo.tests.messaging.JMSClientRecorder.requests)) {
            throw new Error("Response not found for request: " + key);
        }
        
        // Fire off all of the messages in order, calling the responseCallback for the one that is a response.
        var playbackMessage = function _playbackMessage(messages, i, seenResponse) {
            var recordedMessage = null;
            if (i < messages.length) {
                recordedMessage = messages[i];
                
                if (recordedMessage.isResponse) {
                    if (seenResponse) {
                        throw new Error("Two response messages found for a request with key:" + key);
                    }
                    seenResponse = true;
                    if (responseCallback) {
                        //log.debug("Getting ready to send back recorded message for this request:\n" + dojo.toJson(msg, true));
                        //log.debug("Sending recorded response message (" + key + "):\n" + dojo.toJson(recordedMessage, true));
                        responseCallback(recordedMessage.message);
                    }
                } else {
                    var messageDataProperties = recordedMessage.message.data.properties; 
                    if (messageDataProperties && messageDataProperties[anzo.messaging.JMS_MSG_PROPERTY_TYPE] == anzo.messaging.MSG_TYPE_NAMED_GRAPH_UPDATE) {
                        // Handle a NamedGraphUpdate message by sending it to the appropriate graph subscription listener.
                        var graphUuid = messageDataProperties[anzo.messaging.JMS_MSG_NAMED_GRAPH_UUID];
                        if (graphUuid && graphUuid.length > 0) {
                            var graphUpdateListener = this.graphUpdateSubscriptions[graphUuid];
                            if (graphUpdateListener) {
                                graphUpdateListener(recordedMessage.message.data);
                            } else {
                                log.debug("playback_publish - Recieved NamedGraphUpdate for " + graphUuid + " but no listener exists. Ignoring message.");
                            }
                        } else {
                            log.debug("playback_publish - Malformed NamedGraphUpdate message. Empty data in " + anzo.messaging.JMS_MSG_NAMED_GRAPH_UUID + " property.");
                        }
                    } else {
                        // Fire the notification message event
                        // log.debug("Firing notification message (" + key + "):\n" + dojo.toJson(recordedMessage.message, true));
                        anzo.messaging.JMSClient.onMessageReceived(recordedMessage.message);
                    }
                }
                setTimeout(function() { _playbackMessage(messages, i + 1, seenResponse); }, anzo.tests.messaging.JMSClientRecorder.MESSAGE_DELAY);
            }
        };
        var messagesToSend = anzo.tests.messaging.JMSClientRecorder.requests[key];
        setTimeout(function() { 
            playbackMessage(messagesToSend, 0, false);
        }, anzo.tests.messaging.JMSClientRecorder.MESSAGE_DELAY);
    },
    
    record_onMessageReceived : function(message) {
        var key = this.currentMsgKey;
        //log.debug("record_onMessageReceived - this:" + anzo.tests.utilities.objectPropertiesToString(this));
        if (!key) {
            throw new Error("Received notification message before the first request. This message cannot be played back properly.");
        }
        if (!(key in anzo.tests.messaging.JMSClientRecorder.requests)) {
            throw new Error("Response not found for request: " + key);
        }
        var recordedMessage = new anzo.tests.messaging.JMSClientRecorder._RecordedMessage(dojo.clone(message), false, null);
        anzo.tests.messaging.JMSClientRecorder.requests[key].push(recordedMessage);
    },
    
    loadRequests : function(reqs) {
        // summary: Load previously recorded requests for playback. The object must be in MODE_PLAYBACK or this method does nothing. 
        if (anzo.tests.messaging.JMSClientRecorder.mode == anzo.tests.messaging.JMSClientRecorder.MODE_PLAYBACK) {
            for (var key in reqs) {
                var recordedMessages = reqs[key];
                this.requests[key] = recordedMessages;

                // Do some fail-fast invariant checking. At most one response message may be associated with each request. 
                if (!dojo.isArray(recordedMessages)) {
                    throw new Error("Invalid recorded request data. Request must be associated with an array of responses.");
                }
                var seenResponse = false;
                for (var i = 0; i < recordedMessages.length; i++) {
                    if (recordedMessages[i].isResponse) {
                        if (seenResponse) {
                            throw new Error("Invalid recorded request data. More than one response message is associated with request:" + key);
                        }
                        seenResponse = true;
                    }
                }
            }
        }
    },
    
    getMsgKey : function(msg, destination) {
        var key = anzo.tests.messaging.JMSClientRecorder.testId + "::" + anzo.tests.messaging.JMSClientRecorder.requestCount++;
        //log.debug("getMsgKey(destination:" + destination + "): " + key);
        return key;
    },
    
    getObjKey : function(obj,objkey) {
        // We sort the properties since JavaScript doesn't guarantee
        // property order and we want to ensure that our recorded data
        // is played back correctly on different JavaScript engines.
        // See http://www.openanzo.org/projects/openanzo/ticket/112
        if (objkey) {
            var str = objkey + ":"
        } else {
            var str = "";
        }
        if (dojo.isArrayLike(obj)) {
            var a = new Array();
            for (var i=0;i<obj.length;i++) {
                a.push(anzo.tests.messaging.JMSClientRecorder.getObjKey(obj[i],i + ""));
            }
            a.sort();
            for (var i=0;i<a.length;i++) {
                str += "," + a[i];
            }
            return str;
        } else if (dojo.isObject(obj)) {
            var propnames = new Array();
            for (var key in obj) {
                propnames.push(key);
            }
            propnames.sort();
            for (var i=0;i<propnames.length;i++) {
                str += "#" + anzo.tests.messaging.JMSClientRecorder.getObjKey(obj[propnames[i]],propnames[i]);
            }
            return str;
        } else {
            return str;
        }
    },
    
    _showRecordedMessageDataPopup : function _showRecordedMessageDataPopup(recordedData) {
        // summary: Opens a new popup window and fills it with the string given in the recordedData argument wrapped in an HTML 'pre' element.
        var escapedRecordedData = anzo.tests.utilities.escapeXML(recordedData);
        var popupHtml = "<html><head><title>JMSClientRecorder Recorded Message Data</title></head><body><pre>" +
            escapedRecordedData + "</pre></body></html>";
        var popupWindow = window.open("about:blank", "_blank");
        var popupDoc = popupWindow.document.open("text/html", "replace");
        popupDoc.write(popupHtml);
        popupDoc.close();
    }
};

})();
