/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.client._JMSNotificationRegistrationService");

dojo.require("anzo.messaging.JMSClient");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.client._Tracker");
dojo.require("anzo.log");

/*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
(function(){
    
var log = anzo.log.getLogger("anzo.client._JMSNotificationRegistrationService");

dojo.declare('anzo.client._JMSNotificationRegistrationService', null, {

    // summary: The JMSNotificationRegistrationService is used internally by the RealTimeUpdateManager to subscribe 
    //  to notifications from a server.

    // description: The JMSNotificationRegistrationService provides three major pieces of functionality.  First, 
    //  it provides a `connect` operation to let the notification server know that the client is interested 
    //  in notifications. Second, it implements a mechanism for registering anzo.client._Tracker objects to let the
    //  server know the client's interest in particular changes. Lastly, it receives notification messages
    //  using the JMSClent and relays them onto the listeners. 
    
    _NOTIFICATION_PUBLISH_QUEUE : "services/notification",

    _isConnected : false,
    _jmsMessageListenerHandle : null,
    _listener : null,
     
    constructor : function _JMSNotificationRegistrationService_constructor(listener) {
        // summary: create a _JMSNotificationRegistrationService.
        // listener: Optional. a listener for the notification messages.
        this._listener = listener;
        this._testExceptionCount = 0; // A variable used in tests for testing with null callbacks. Counts the number of failed responses from the server and failures while handling the server responses.
    },

    setListener : function setListener(listener) {
        // summary: Sets the listener for notification messages. May be null to remove the listener.
        this._listener = listener;
    },
    
    registerTrackers : function registerTrackers(statementTrackers, datasetTrackers, callback) {
        // summary: Registers the specified trackers with the server.
        // statementTrackers: anzo.client._StatementTracker | Array of anzo.client._StatementTracker
        //  The statement tracker(s) that will be registered with the server.
        // datasetTrackers: anzo.client._DatasetTracker | Array of anzo.client._DatasetTracker
        //  The dataset tracker(s) that will be registered with the server.
        // callback : Function(Boolean success, Object error)
        //  Optional. Method called upon completion of the requested operation.
        //  The success argument denotes if the trackers were successfully registered. 
        //  The error argument contains information about any error in the case of failure.
        //  The error argument is null in case of success.
        //  Turning the error object into a string with dojo.toJson to display error
        //  information is recommended.

        if (callback && !dojo.isFunction(callback)) {
            throw new Error("registerTrackers - callback must be a function or may be null or undefined.");
        }

        var callbackWrapper = null;
        if (callback) {
            // Wrap the callback so that we send null for the error object if successful.
            callbackWrapper = function _callbackWrapper(success, response) {
                callback(success, success ? null : response);
            }
        }        

        if (!this._isConnected) {
            // Connect before registering the tracker
            this.connect(dojo.hitch(this, function onConnectFromRegisterTracker(success, response) {
                try {
                    if (success) {
                        // We are now connected, so register the tracker.
                        this._doTrackerOperation(anzo.client.Serialization.OP_REGISTER_TRACKER, statementTrackers, datasetTrackers, callbackWrapper);
                    } else {
                        // Failed to connect so don't register the tracker. Just call the callback with the connect call's error.
                        if (callback) {
                            setTimeout(function() { callback(false, response); }, 0);
                        }
                    }
                } catch(e) {
                    this._testExceptionCount++;
                    // Ensure the callback is called even in the case of type errors and the like in the code above.
                    if (callback) {
                        e.response = response;
                        setTimeout(function() { callback(false, e); }, 0);
                    }
                }
            }));
        } else {
            // We are already connected, so just register the tracker.
            this._doTrackerOperation(anzo.client.Serialization.OP_REGISTER_TRACKER, statementTrackers, datasetTrackers, callbackWrapper);
        }
    },

    unregisterTrackers : function unregisterTrackers(statementTrackers, datasetTrackers, callback) {
        // summary: Unregisters the specified tracker(s) from the server.
        // statementTrackers: anzo.client._StatementTracker | Array of anzo.client._StatementTracker
        //  The statement tracker(s) that will be unregistered from the server.
        // datasetTrackers: anzo.client._DatasetTracker | Array of anzo.client._DatasetTracker
        //  The dataset tracker(s) that will be unregistered from the server.
        // callback : Function(Boolean success, Object error)
        //  Method called upon completion of the requested operation. 
        //  The success argument denotes if the trackers were successfully unregistered. 
        //  The error argument contains information about any error in the case of failure.
        //  The error argument is null in case of success.
        //  Turning the error object into a string with dojo.toJson to display error
        //  information is recommended.

        if (callback && !dojo.isFunction(callback)) {
            throw new Error("unregisterTrackers - callback must be a function or may be null or undefined.");
        }

        if (this._isConnected) {
            var callbackWrapper = null;
            if (callback) {
                // Wrap the callback so that we send null for the error object if successful.
                callbackWrapper = function _callbackWrapper(success, response) {
                    callback(success, success ? null : response);
                }
            } 
            this._doTrackerOperation(anzo.client.Serialization.OP_UNREGISTER_TRACKER, statementTrackers, datasetTrackers, callbackWrapper);
        } else {
            log.debug("unregisterTrackers - Already disconnected so skipping tracker removal.");
            if (callback) {
                setTimeout(function() { callback(true, null); }, 0);
            }
        }
    },

    connect : function connect(callback) {
        // summary: Subscribes this `_JMSNotificationRegistrationService` to notification messages. This starts the flow
        //  of messages notifying the client of changes made to the repository as they happen.
        // description: For subscribing to notification messages, a `registerSubscriber` message is sent to the 
        //  notification queue and a handler for the messages is registered with the JMSClient. 
        //  The method does nothing if this object is already connected.
        // callback : Function(Boolean success, Object error)
        //  Method called upon completion of the requested operation.
        //  The success argument denotes if the notificaiton connection was established. 
        //  The error argument contains information about any error in the case of failure.
        //  The error argument is null in case of success.
        //  Turning the error object into a string with dojo.toJson to display error
        //  information is recommended.

        if (callback && !dojo.isFunction(callback)) {
            throw new Error("connect - callback must be a function or may be null or undefined.");
        }

        if (!this._isConnected) {
            this._doConnectOperation(anzo.client.Serialization.OP_REGISTER_SUBSCRIBER, dojo.hitch(this, function onRegisterSubscriberComplete(success, response) {
                log.debug("Notification connect request complete  - success:" + success);
                var callbackCalled = false;
                try {
                    if (success) {
                        this._isConnected = true;
                        if (!this._jmsMessageListenerHandle) {
                            log.debug("Connecting to JMSClient onMessageReceived event.");
                            this._jmsMessageListenerHandle = dojo.connect(anzo.messaging.JMSClient, "onMessageReceived", dojo.hitch(this, this._onMessageReceived));
                        }
                    }
                    if (callback) {
                        callbackCalled = true;
                        callback(success, success ? null : response);
                    }
                } catch(e) {
                    this._testExceptionCount++;
                    if (!callbackCalled && callback) {
                        // Ensure the callback is called even in the case of type errors and the like in the code above.
                        e.response = response;
                        callback(false, e);
                    } else {
                        // If the callback itself threw the error rather than Anzo.JS code, just let it bubble up.
                        throw e;
                    }
                }
            }));
        } else {
            log.debug("notification connect - Already connected.");
            if (callback) {
                callback(true, null);
            }
        }
    },
    
    disconnect : function disconnect(callback) {
        // summary: Unsubscribes this `JMSNotificationRegistrationService` from notification messages. This stops the flow
        //  of messages notifying the client of changes made to the repository as they happen.
        // description: For unsubscribing from notification messages, an `unregisterSubscriber` message is sent to the 
        //  notification queue and the handler for the messages is unregistered with the JMSClient. 
        //  The method does nothing if this object is already disconnected.
        // callback : Function(Boolean success, Object error)
        //  Method called upon completion of the requested operation.
        //  The success argument denotes if the notificaiton connection was successfully removed. 
        //  The error argument contains information about any error in the case of failure.
        //  The error argument is null in case of success.
        //  Turning the error object into a string with dojo.toJson to display error
        //  information is recommended.

        if (callback && !dojo.isFunction(callback)) {
            throw new Error("disconnect - callback must be a function or may be null or undefined.");
        }
        
        if (this._isConnected) {
            this._doConnectOperation(anzo.client.Serialization.OP_UNREGISTER_SUBSCRIBER, dojo.hitch(this, function onUnregisterSubscriberComplete(success, response) {
                log.debug("Notification disconnect request complete  - success:" + success);
                var callbackCalled = false;
                try {
                    if (success) {
                        this._isConnected = false;
                        if (this._jmsMessageListenerHandle) {
                            log.debug("Diconnecting from JMSClient onMessageReceived event.");
                            dojo.disconnect(this._jmsMessageListenerHandle);
                            this._jmsMessageListenerHandle = null;
                        }
                    }
                    if (callback) {
                        callbackCalled = true;
                        callback(success, success ? null : response);
                    }
                } catch(e) {
                    this._testExceptionCount++;
                    if (!callbackCalled && callback) {
                        // Ensure the callback is called even in the case of type errors and the like in the code above.
                        e.response = response;
                        callback(false, e);
                    } else {
                        // If the callback itself threw the error rather than Anzo.JS code, just let it bubble up.
                        throw e;
                    }
                }
            }));
        } else {
            log.debug("Notification already disconnected.");
            if (callback) {
                callback(true, null);
            }
        }
    },
    
    _doConnectOperation : function _doConnectOperation(operation, callback) {
        // summary: Sends either a JMS `registerSubscriber` or `unregisterSubscriber` notification queue. 
        // operation: String
        //  Either `registerSubscriber` or `unregisterSubscriber`.
        // callback : Function(Boolean success, Object response)
        //  Method called upon completion of the requested operation.
        //  The success argument indicates if the requested operation suceeded.
        //  The response is the full response object as returned from the JMSClient.

        if (callback && !dojo.isFunction(callback)) {
            throw new Error("_doConnectOperation - callback must be a function or may be null or undefined.");
        }

        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_JSON;
        var msg = new anzo.messaging.JMSMessage(null, responseFormat);
        msg.properties[ser.OPERATION] = operation;
        msg.body = "1";
        
        var responseCallback = null;
        if (callback) {
            responseCallback = dojo.hitch(this, function _responseCallback(response) {
                var callbackCalled = false;
                try {
                    if (response.error || response.message.properties.operationFailed == "true") {
                        this._testExceptionCount++;
                        callbackCalled = true;
                        callback(false, response);
                    } else {
                        var responseMessage = response.message;
                        log.debug("_doConnectOperation(" + operation + ") - succeded.");
                        callbackCalled = true;
                        callback(true, response);
                    }
                } catch(e) {
                    this._testExceptionCount++;
                    if (!callbackCalled && callback) {
                        // Ensure the callback is called even in the case of type errors and the like in the code above.
                        e.response = response;
                        callback(false, e);
                    } else {
                        // If the callback itself threw the error rather than Anzo.JS code, just let it bubble up.
                        throw e;
                    }
                }
            });
        }
    
        anzo.messaging.JMSClient.publish(msg, this._NOTIFICATION_PUBLISH_QUEUE, responseCallback);
    },

    _doTrackerOperation : function _doTrackerOperation(operation, statementTrackers, datasetTrackers, callback) {
        // summary: Sends a request to the server to perform the requested operation on the specified tracker.
        // operation : String
        //  The operation that is to be performed. For example, 'registerTracker' or 'unregisterTracker'.
        // statementTrackers: anzo.client._StatementTracker | Array of anzo.client._StatementTracker
        //  The statement tracker(s) that will be (un)registered.
        // datasetTrackers: anzo.client._DatasetTracker | Array of anzo.client._DatasetTracker
        //  The dataset tracker(s) that will be (un)registered.
        // callback : Function(Boolean success, Object response)
        //  Method called upon completion of the requested operation.
        //  The success argument indicates if the requested operation suceeded.
        //  The response is the full response object as returned from the JMSClient.
        
        if (!statementTrackers && !datasetTrackers) {
            throw new Error("_doTrackerOperation - either statementTrackers or datasetTrackers must be given.");
        }
        if (callback && !dojo.isFunction(callback)) {
            throw new Error("_doTrackerOperation - callback must be a function or may be null or undefined.");
        }
        
        var serializedStatementTrackers = [];
        var statementTrackerCount = this._serializeTrackers(statementTrackers, serializedStatementTrackers);
        var serializedDatasetTrackers = [];
        var datasetTrackerCount = this._serializeTrackers(datasetTrackers, serializedDatasetTrackers);
        
        if (statementTrackerCount == 0 && datasetTrackerCount == 0) {
            // nothing to do
            if (callback) {
                setTimeout(function() { callback(true, null); }, 0);
            } 
        }

        var ser = anzo.client.Serialization;
        var responseFormat = ser.MIMETYPE_JSON;
        var msg = new anzo.messaging.JMSMessage(null, responseFormat);
        msg.properties[ser.OPERATION] = operation;
        if (statementTrackerCount > 0) {
            var trackerJsonData = ser.writeStatementsToJson(serializedStatementTrackers);
            msg.properties[ser.TRACKERS] = dojo.toJson(trackerJsonData);
            msg.properties[ser.TRACKERS_FORMAT] = ser.MIMETYPE_JSON;
        }
        if (datasetTrackerCount > 0) {
            var trackerJsonData = ser.writeStatementsToJson(serializedDatasetTrackers);
            msg.properties[ser.DATASET_TRACKERS] = dojo.toJson(trackerJsonData);
            msg.properties[ser.DATASET_TRACKERS_FORMAT] = ser.MIMETYPE_JSON;
        }
        
        var responseCallback = null;
        if (callback) {
            responseCallback = dojo.hitch(this, function _responseCallback(response) {
                try {
                    if (response.error || response.message.properties.operationFailed == "true") {
                        this._testExceptionCount++;
                        if (callback) {
                            setTimeout(function() { callback(false, response); }, 0);
                        }
                    } else {
                        if (log.isDebugEnabled()) {
                            log.debug("_doTrackerOperation(" + operation + ") - succeded.");
                        }
                        if (callback) {
                            setTimeout(function() { callback(true, response); }, 0);
                        }
                        
                    }
                } catch(e) {
                    this._testExceptionCount++;
                    if (callback) {
                        // Ensure the callback is called even in the case of type errors and the like in the code above.
                        e.response = response;
                        setTimeout(function() { callback(false, e); }, 0);
                    }
                }
            });
        }
    
        anzo.messaging.JMSClient.publish(msg, this._NOTIFICATION_PUBLISH_QUEUE, responseCallback);
    },

    _serializeTrackers : function(trackers, statements) {
        // summary: Serializes a list of trackers into the given array of RDF statements. 
        // trackers: anzo.rdf._Tracker | Array of anzo.rdf._Tracker objects
        //   The tracker(s) to serialize.
        // statements: Array
        //   Array of statements to which the newly serialized tracker RDF statements will be appended.
        // returns: Number
        //   The number of trackers serialized.
        var retval = 0;
        if (trackers != null) {
            if (dojo.isArray(trackers)) {
                for (var i = 0; i < trackers.length; i++) {
                    trackers[i].serialize(statements);
                    retval++;
                }
            } else if (trackers instanceof anzo.client._Tracker) {
                trackers.serialize(statements);
                retval++;
            } else {
                throw new Error("Given trackers arguments must be either an anzo.client._Tracker object or an Array of anzo.client._Tracker objects.");
            }
        }
        return retval;
    },
    
    _onMessageReceived : function _onMessageReceived(message) {
        // summary : handles the onMessageReceived event from the JMSClient. This receives any JMS messages
        //   that are real-time-update notification messages.
        
        // message: Object
        //   Message object representing the JMS message received from the JMSClient.
        
        // description: This method collects the The method collects messages, sorting them into buckets by transaction. When
        //   we get a "tranasction end" message, the first k complete transactions are processed such that
        //   their contents are exposed to the graphs via the datasetService's notification transaction proxy.
        
        if (!message || !message.data) {
            log.debug("_onMessageReceived - warning: null message received. Ignoring.");
            return;
        }
        
        if (this._listener) {
            this._listener(message.data);
        }
    }

});

})();
