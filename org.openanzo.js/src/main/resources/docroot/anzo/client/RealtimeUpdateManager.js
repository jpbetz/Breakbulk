/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.client.RealtimeUpdateManager");

dojo.require("anzo.client._JMSNotificationRegistrationService");
dojo.require("anzo.client._Tracker");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.utils.RDFUtil");
dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.rdf.QuadStore");
dojo.require("anzo.log");

/*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */

(function(){
    
var log = anzo.log.getLogger("anzo.client.RealtimeUpdateManager");

dojo.declare('anzo.client.RealtimeUpdateManager', null, {
    // summary: The RealtimeUpdateManager provides the ability to monitor changes to graphs in an OpenAnzo
    //   repository. Users get near-real-time events for changes to graphs in the repository. Caller's shouldn't
    //   explicitly create one of these but should use the instance from the realtimeUpdates property of 
    //   the anzo.client.AnzoClient class.
    // description: The RealtimeUpdateManager lets callers subscribe to events which fire when statements are
    //   added or removed from the OpenAnzo repository. When subscribing, the caller supplies a statement
    //   pattern to denote the statements for which they want to be notified. For example, if I wanted to
    //   get an even everytime someone adds or removes a resource of type foaf:Person, I could register
    //   for the pattern: (*, rdf:type, foaf:Person, *). Notice the wildcard for the subject and the graph URI.
    //   Statements patterns used to receive real-time updates are known as "trackers".
    //   Clients may also subscribe to events that indicate when any graph in a set of graphs is modified.
    
    _CLOSED_ERROR_MESSAGE : "RealtimeUpdateManager is closed. Note that RealtimeUpdateManager instances are closed once the AnzoClient instance that created them is closed.",

    _anzoClient : null,

    constructor : function(anzoClient) {
        // summary: Construct a new RealtimeUpdateManager. Setup the internal state including 
        //   an anzo.client._JMSNotificationRegistrationService. Caller's shouldn't explicitly create 
        //   one of these but should obtain an instance using the anzo.client.AnzoClient.getRealtimeUpdateManager method.
        // anzoClient: Pointer to the anzoClient that controls this instance of the RealtimeUpdateManager.
        this._registrationService = new anzo.client._JMSNotificationRegistrationService(dojo.hitch(this, this._messageListener));
        this._resetUpdateClientState();
        this._anzoClient = anzoClient;

        this._receiveTransactions = false;
        this._connectedToTransactionTopic = false;
       
        this._connected = false;
        this._closed = false;
    },
    
    addTracker : function(subject, predicate, object, namedGraphUri, statementListener, callback) {
        // summary: Adds a tracker which listens to changes in the repository that match the given statement pattern.
        // subject: anzo.rdf.Resource | String
        //   The subject of the pattern that is to be tracked. null indicates a wildcard.
        // predicate: anzo.rdf.URI | String
        //   The predicate of the pattern that is to be tracked. null indicates a wildcard.
        // object: anzo.rdf.Value | Object
        //   The object of the pattern that is to be tracked. null indicates a wildcard.
        // namedGraphUri: anzo.rdf.URI | String
        //   URI of the named graph that is to be tracked. null indicates a wildcard.
        // statementListener: Object
        //    An object whose 'statementsAdded` and 'statementsRemoved' methods will be called when matching
        //    real-time updates are received. Each method takes an array of anzo.rdf.Statement objects denoting
        //    the statements that were added or removed. If the given object doesn't have either a 'statementsAdded'
        //    or 'statementsRemoved' method, then the function will throw an error.
        // callback : Function(Boolean success, Object error)
        //  Optional. Method called upon completion of the requested operation.
        //  The success argument denotes if the tracker was successfully registered. 
        //  The error argument contains information about any error in the case of failure.
        //  The error argument is null in case of success.
        //  Turning the error object into a string with dojo.toJson to display error
        //  information is recommended.

        if (this._closed) {
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }
        if (!statementListener || !(dojo.isFunction(statementListener.statementsAdded) || dojo.isFunction(statementListener.statementsRemoved))) {        
            callback(false, new Error("addTracker - invalid statementListener. Must be an object with at least one of the methods 'statementsAdded' or 'statementsRemoved'"));
            return;
        }
        if (callback && !dojo.isFunction(callback)) {
            callback(false, new Error("addTracker - callback argument must be a function."));
            return; 
        }        
        
        var stmt = this._getPatternStatement(subject, predicate, object, namedGraphUri);
        var statementKey = stmt.dictionaryKey();
        var tracker = this._patternToTracker[statementKey];
        var callbackDelegated = false;
        if(tracker == null) {
            // We make sure we immediately add the tracker to the maps rather than waiting until it's registered in case two calls to register
            // the same tracker URI come it. Otherwise, there is a race condition where one would override the other and one of the listeners wouldn't end up being subscribed.
            var tracker = new anzo.client._StatementTracker(stmt);
            this._patternToTracker[statementKey] = tracker;
            this._addMaps(tracker);
            tracker.addListener(statementListener);
            if (this._connected) {
                callbackDelegated = true;
                this._registrationService.registerTrackers(tracker, null, dojo.hitch(this, function onRegisterTrackerForAddTracker(success, errors) { 
                    if (dojo.isFunction(callback)) {
                        setTimeout(function() { callback(success, success ? null : errors); }, 0);
                    } else if(!success && log.isErrorEnabled()) {
                        log.error("addTracker - error while subscribing to tracker (no callback supplied for use in reporting error): " + statementKey + "\n errors:" + dojo.toJson(errors));
                    }
                }));
            }
            // If we aren't connected yet, just register the tracker in our object an leave the registration on the server for when we connect.
        } else {
            tracker.addListener(statementListener);
        }
        
        if (!callbackDelegated) {
            // If we didn't delegate the user's callback to the registerTrackers method, then
            // we must ensure to finish things up ourselves.
            if (dojo.isFunction(callback)) {
                setTimeout(function() { callback(true, null); }, 0);
            }
        }
    },

    addDatasetTracker : function(datasetTrackerURI, defaultNamedGraphs, namedGraphs, namedDatasets, datasetListener, callback) {
        // summary: Adds a tracker which listens to changes in any of the given graphs. Named Datasets are
        //   expanded and a notification is sent when any of the graphs referenced by a named dataset changes
        //   or when a graph is added of removed from the named dataset.
        // datasetTrackerURI: anzo.rdf.URI | String
        //   A unique identifier URI for naming this particular tracker.
        // defaultNamedGraphs: anzo.rdf.URI | String | Array
        //   Named Graph URI(s) to track for any changes. Optional. 
        // namedGraphs: anzo.rdf.Resource | String | Array
        //   Named Graph URI(s) to track for any changes. Optional.
        // namedDatasets: anzo.rdf.URI | String | Array
        //   Named Dataset URI(s) to track for any changes. Notification will be sent when when any of
        //   the graphs referenced by a named dataset changes or when a graph is added of removed from
        //   the named dataset. Optional.
        // datasetListener: Object
        //    An object whose 'datasetChanged' method will be called when any of the graphs matching the
        //    tracker are changed. If the given object doesn't have either a 'datasetChanged'
        //    method, then the function will throw an error.
        // callback : Function(Boolean success, Object error)
        //  Optional. Method called upon completion of the requested operation.
        //  The success argument denotes if the tracker was successfully registered. 
        //  The error argument contains information about any error in the case of failure.
        //  The error argument is null in case of success.
        //  Turning the error object into a string with dojo.toJson to display error
        //  information is recommended.

        if (this._closed) {
            log.debug(this._CLOSED_ERROR_MESSAGE);
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }
        if (!datasetListener || !(dojo.isFunction(datasetListener.datasetChanged))) {
            var errorMsg = "addDatasetTracker - invalid datasetListener. Must be an object with at least a method 'datasetChanged'";
            log.debug(errorMsg);
            callback(false, new Error(errorMsg));
            return;
        }
        if (callback && !dojo.isFunction(callback)) {
            var errorMsg = "addDatasetTracker - callback argument must be a function.";
            log.debug(errorMsg);
            callback(false, new Error(errorMsg));
            return; 
        }
        if ((defaultNamedGraphs == null || defaultNamedGraphs.length == 0) && (namedGraphs == null || namedGraphs.length == 0) && (namedDatasets == null || namedDatasets.length == 0)) {
            var errorMsg = "addDatasetTracker - at least one graph or named dataset to track must be specified.";
            log.debug(errorMsg);
            callback(false, new Error(errorMsg));
            return; 
        }

        var datasetTrackerURIStr = datasetTrackerURI instanceof anzo.rdf.URI ? datasetTrackerURI.toString() : datasetTrackerURI;
        var tracker = this._uriToDatasetTracker[datasetTrackerURIStr];
        var callbackDelegated = false;
        if(tracker == null) {
            if (log.isDebugEnabled()) {
                log.debug("DatasetTracker not yet registered so creating a new entry: " + datasetTrackerURIStr);
            }
            // We make sure we immediately add the tracker to the map rather than waiting until it's registered in case two calls to register
            // the same tracker URI come it. Otherwise, there is a race condition where one would override the other and one of the listeners wouldn't end up being subscribed.
            this._uriToDatasetTracker[datasetTrackerURIStr] = tracker = new anzo.client._DatasetTracker(datasetTrackerURI, defaultNamedGraphs, namedGraphs, namedDatasets);
            tracker.addListener(datasetListener);
            if (this._connected) {
                callbackDelegated = true;
                this._registrationService.registerTrackers(null, tracker, dojo.hitch(this, function onRegisterTrackerForAddTracker(success, errors) {
                    if (dojo.isFunction(callback)) {
                        setTimeout(function() { callback(success, success ? null : errors); }, 0);
                    } else if(!success && log.isErrorEnabled()) {
                        log.error("addDatasetTracker - error while subscribing to tracker (no callback supplied for use in reporting error): " + datasetTrackerURIStr + "\n errors:" + dojo.toJson(errors));
                    }
                }));
            }
            // If we aren't connected yet, just register the tracker in our object an leave the server registration for when we connect.
        } else {
            if (log.isDebugEnabled()) {
                log.debug("DatasetTracker already registered - adding a listener:" + datasetTrackerURIStr);
            }
            tracker.addListener(datasetListener);
        }
        
        if (!callbackDelegated) {
            // If we didn't delegate the user's callback to the registerTracker method, then
            // we must finish things up ourselves.
            if (dojo.isFunction(callback)) {
                setTimeout(function() { callback(true, null); }, 0);
            }
        }
    },
    
    removeTracker : function(subject, predicate, object, namedGraphUri, callback) {
        // summary: Removes all listeners for the given statement pattern.
        // description: This removes all listeners for the specific pattern given. Note that
        //   this only affects the exact pattern given. It won't remove any listeners of other patterns
        //   even if the patterns may be more specific versions of the given pattern. For example,
        //   if you add call addTracker(null, "http://example.org/pred", "Object Val", null, listener), then
        //   call removeTracker(null, null, null, null) will not remove that listener even though the 
        //   pattern (null, null, null, null) encompasses all statements that match the 
        //   pattern (null, "http://example.org/pred", "Object Val", null).
        // subject: anzo.rdf.Resource | String
        //   The subject of the pattern that is to be removed. null indicates a wildcard.
        // predicate: anzo.rdf.URI | String
        //   The predicate of the pattern that is to be removed. null indicates a wildcard.
        // object: anzo.rdf.Value | Object
        //   The object of the pattern that is to be removed. null indicates a wildcard.
        // namedGraphUri: anzo.rdf.URI | String
        //   named graph URI of the pattern that is to be removed. null indicates a wildcard.
        // callback : Function(Boolean success, Object error)
        //   Optional. Method called upon completion of the requested operation.
        //   The success argument denotes if the tracker was successfully unregistered. 
        //   The error argument contains information about any error in the case of failure.
        //   The error argument is null in case of success.
        //   Turning the error object into a string with dojo.toJson to display error
        //   information is recommended.

        if (this._closed) {
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }
        if (callback && !dojo.isFunction(callback)) {
            callback(false, new Error("removeTracker - callback argument must be a function."));
            return;
        }        

        var stmt = this._getPatternStatement(subject, predicate, object, namedGraphUri);
        var trackerKey = stmt.dictionaryKey();
        var tracker = this._patternToTracker[trackerKey];
        if(tracker) {
            this._removeMaps(tracker);
            delete this._patternToTracker[trackerKey];
            if (this._connected) {
                this._registrationService.unregisterTrackers(tracker, null, callback);
            }
        } else if (callback) {
            // The tracker doesn't exist. Nothing to do. Just call the callback.
            callback(true, null);
        }
    },

    removeDatasetTracker : function(datasetTrackerURI, callback) {
        // summary: Removes all listeners for the given dataset tracker.
        // datasetTrackerURI: anzo.rdf.Resource | String
        //   The unique identifier of the tracker to remove.
        // callback : Function(Boolean success, Object error)
        //   Optional. Method called upon completion of the requested operation.
        //   The success argument denotes if the tracker was successfully unregistered. 
        //   The error argument contains information about any error in the case of failure.
        //   The error argument is null in case of success.
        //   Turning the error object into a string with dojo.toJson to display error
        //   information is recommended.

        if (this._closed) {
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }
        if (callback && !dojo.isFunction(callback)) {
            callback(false, new Error("removeDatasetTracker - callback argument must be a function."));
            return;
        }        

        var datasetTrackerURIStr = datasetTrackerURI instanceof anzo.rdf.URI ? datasetTrackerURI.toString() : datasetTrackerURI;
        var tracker = this._uriToDatasetTracker[datasetTrackerURIStr];
        if(tracker) {
            delete this._uriToDatasetTracker[datasetTrackerURIStr];
            if (this._connected) {
                this._registrationService.unregisterTrackers(null, tracker, callback);
            }
        } else if (callback) {
            // The tracker doesn't exist. Nothing to do. Just call the callback.
            callback(true, null);
        }
    },

    removeTrackerListener : function(subject, predicate, object, namedGraphUri, statementListener, callback) {
        // summary: Removes a specific listener for the given statement pattern.
        // subject: anzo.rdf.Resource | String
        //   The subject of the pattern whose listener is to be removed. null indicates a wildcard.
        // predicate: anzo.rdf.URI | String
        //   The predicate  of the pattern whose listener is to be removed. null indicates a wildcard.
        // object: anzo.rdf.Value | Object
        //   The object of the pattern whose listener is to be removed. null indicates a wildcard.
        // namedGraphUri: anzo.rdf.URI | String
        //   named graph URI of the pattern whose listener is to be removed. null indicates a wildcard.
        // statementListener: Object
        //    The statementListener to remove. This must be the same object as was passed to addTracker.
        // callback : Function(Boolean success, Object error)
        //   Optional. Method called upon completion of the requested operation.
        //   The success argument denotes if the tracker listener was successfully removed. 
        //   The error argument contains information about any error in the case of failure.
        //   The error argument is null in case of success.
        //   Turning the error object into a string with dojo.toJson to display error
        //   information is recommended.

        if (this._closed) {
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }
        if (callback && !dojo.isFunction(callback)) {
            callback(false, new Error("removeTrackerListener - callback argument must be a function."));
            return;
        }        

        var stmt = this._getPatternStatement(subject, predicate, object, namedGraphUri);
        var trackerKey = stmt.dictionaryKey();
        var tracker = this._patternToTracker[trackerKey];
        var trackerPurged = false;
        if(tracker) {
            tracker.removeListener(statementListener);
            if(tracker.getListenerCount() <= 0) {
                trackerPurged = true;
                this._removeMaps(tracker);
                delete this._patternToTracker[trackerKey];
                if (this._connected) {
                    this._registrationService.unregisterTrackers(tracker, null, callback);
                }
            }
        }

        if (!trackerPurged && callback) {
            // This ensures the callback is called in situations where we haven't passed the callback to the
            // JMSNotificationRegistrationService to be called.
            callback(true, null);
        }
    },

    removeDatasetTrackerListener : function(datasetTrackerURI, datasetListener, callback) {
        // summary: Removes a specific listener for the dataset tracker identified by the given URI.
        // datasetTrackerURI: anzo.rdf.Resource | String
        //   The unique identifier of the tracker whose listener will be removed.
        // datasetListener: Object
        //    The datasetListener to remove. This must be the same object as was passed to addDatasetTracker.
        // callback : Function(Boolean success, Object error)
        //   Optional. Method called upon completion of the requested operation.
        //   The success argument denotes if the listener was successfully removed. 
        //   The error argument contains information about any error in the case of failure.
        //   The error argument is null in case of success.
        //   Turning the error object into a string with dojo.toJson to display error
        //   information is recommended.

        if (this._closed) {
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }
        if (callback && !dojo.isFunction(callback)) {
            callback(false, new Error("removeDatasetTrackerListener - callback argument must be a function."));
            return;
        }        

        var datasetTrackerURIStr = datasetTrackerURI instanceof anzo.rdf.URI ? datasetTrackerURI.toString() : datasetTrackerURI;
        var tracker = this._uriToDatasetTracker[datasetTrackerURIStr];
        var trackerPurged = false;
        if(tracker) {
            tracker.removeListener(datasetListener);
            if(tracker.getListenerCount() <= 0) {
                trackerPurged = true;
                delete this._uriToDatasetTracker[datasetTrackerURIStr];
                if (this._connected) {
                    this._registrationService.unregisterTrackers(null, tracker, callback);
                }
            }
        }

        if (!trackerPurged && callback) {
            // This ensures the callback is called in situations where we haven't passed the callback to the
            // JMSNotificationRegistrationService to be called.
            callback(true, null);
        }
    },
    
    containsTracker : function(subject, predicate, object, namedGraphUri) {
        // summary: Checks if a particular pattern is being tracked.
        // description: This method checks if the specific pattern has any listeners. Note that
        //   this only checks the exact pattern given. It won't check any listeners of other patterns
        //   even if the patterns may be more specific versions of the given pattern. For example,
        //   if you add call addTracker(null, "http://example.org/pred", "Object Val", null, listener), then
        //   containsTracker(null, "http://example.org/pred", "Object Val", null) will return true and
        //   containsTracker(null, null, null, null) will return false even though the pattern (null, null,
        //   null, null) encompasses all statements that match the pattern (null, "http://example.org/pred",
        //   "Object Val", null).
        // subject: anzo.rdf.Resource | String
        //   The subject of the pattern to check. null indicates a wildcard.
        // predicate: anzo.rdf.URI | String
        //   The predicate of the pattern to check. null indicates a wildcard.
        // object: anzo.rdf.Value | Object
        //   The object of the pattern to check. null indicates a wildcard.
        // namedGraphUri: anzo.rdf.URI | String
        //   The named graph URI of the pattern to check. null indicates a wildcard.
        // returns: Boolean.
        //   true if the pattern is being tracked. false otherwise.
        
        if (this._closed) {
            throw new Error(this._CLOSED_ERROR_MESSAGE);
        }

        var stmt = this._getPatternStatement(subject, predicate, object, namedGraphUri);
        var trackerKey = stmt.dictionaryKey();
        var tracker = this._patternToTracker[trackerKey];
        return !!tracker;
    },

    containsDatasetTracker : function(datasetTrackerURI) {
        // summary: Checks if a particular dataset as identified by the given URI is being tracked.
        //   Note that the same set of graphs may be tracked by as two different dataset trackers
        //   with unique URIs. This method will only check based on the unique tracker URI. It will not
        //   compare the sets of graphs.
        // description: Checks if a particular dataset as identified by the given URI is being tracked.
        //   Note that the same set of graphs may be tracked by as two different dataset trackers
        //   with unique URIs. This method will only check based on the unique tracker URI. It will not
        //   compare the sets of graphs.
        // datasetTrackerURI: anzo.rdf.Resource | String
        //   The unique identifier of the tracker whose listener will be removed.
        // returns: Boolean.
        //   true if the dataset is being tracked. false otherwise.
        
        if (this._closed) {
            throw new Error(this._CLOSED_ERROR_MESSAGE);
        }

        var datasetTrackerURIStr = datasetTrackerURI instanceof anzo.rdf.URI ? datasetTrackerURI.toString() : datasetTrackerURI;
        var tracker = this._uriToDatasetTracker[datasetTrackerURIStr];
        return !!tracker;
    },
    
    registerForTransactionUpdates : function(callback) {
        // summary: register that this client wants to receive transaction updates
        // callback: function(success, error)
        if (this._closed) {
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }

        if (this._receiveTransactions) {
            callback(true);
        } else {
            if (this._connected && !this._connectedToTransactionTopic) {
                this._receiveTransactions = true;
                this._subscribeToTransactionTopic(true, callback);
            } else if (!this._connected) {
                // Just mark that we want to get the transaction events. When the client calls _connect, we'll subscribe to the topic.
                this._receiveTransactions = true;    
                callback(true, null);
            } else { // this._connected && this._connectedToTransactionTopic
                callback(false, new Error("Invalid state. If we are subscribed to the topic then we should have this._receiveTransactions be true."));
            }
        }
    },
    
    unregisterForTransactionUpdates : function(callback) {
        // summary: indicate that we should stop receiving transaction updates
        // callback: function(success, error)
        if (this._closed) {
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }

        if (this._receiveTransactions) {
            if (this._connected && this._connectedToTransactionTopic) {
                this._receiveTransactions = false;
                this._subscribeToTransactionTopic(false, callback);
            } else if (!this._connected) {
                this._receiveTransactions = false;
                callback(true, null);
            } else { // this._connected && !this._connectedToTransactionTopic
                callback(false, new Error("Invalid state. If we are not subscribed to the topic and we are connected, then we should have this._receiveTransactions be false."));
            }
        } else {
            callback(true);
        }
    },

    transactionComplete : function transactionComplete(uri, timestamp, graphUris, transactionContext) {
        // summary: Event called whenever a "transaction complete" real-time update message arrives.
        //   Use dojo.connect to listen to the message. Transaction complete messages will not be received until 
        //   registerForTransactionUpdates has been called.
        // uri: anzo.rdf.URI. A unique URI that identifies the transaction.
        // timestamp: Number. A timestamp of when the transaction was completed. It's given in milliseconds from the epoch (January 1, 1970).
        // graphUris: Array or anzo.rdf.URI. A set of named graph URIs which denotes all of the graphs affected by this transaction.
        // transactionContext: An IQuadStore containing the context statements passed in when the transaction was created via the 'begin' call. This
        //   can contain arbitrary user-supplied data.

    },
    
    _transactionListener : function _transactionListener(message) {
        // summary: transaction messages come in via this method. This method parses them and fires the transactionComplete event.
        // message: the transaction message.
        if (log.isDebugEnabled()) {
            log.debug("Transaction Message Received by RealtimeUpdateManager:" + dojo.toJson(message, true));
        }
       
        var ser = anzo.client.Serialization;
        var msgProperties = message.properties;
        var operation = msgProperties[ser.OPERATION];
        if (operation == ser.TRANSACTION_COMPLETE) {
            var uri = msgProperties[ser.TRANSACTION_URI];
            // Parse some info about the transaction into an object which we save until we get the transaction complete message.
            var transactionContextString = msgProperties[ser.TRANSACTION_CONTEXT];
            var parsedTransactionContext = transactionContextString ? ser.readStatementsFromJsonString(transactionContextString) : null;
            
            if (parsedTransactionContext) {
                var transactionContext = new anzo.rdf.QuadStore();
                transactionContext.add(parsedTransactionContext);
            } else {
                var transactionContext = null;
            }
            var timestampString = msgProperties[ser.TRANSACTION_TIMESTAMP];
            var timestamp = parseInt(timestampString);
            var namedGraphUris = [];
            var namedGraphUpdatesString = msgProperties[ser.TRANSACTION_NAMEDGRAPHUPDATES];
            var revs = anzo.client.Serialization.readNamedGraphRevisions(namedGraphUpdatesString);
            if (revs) {
                for (var uuid in revs) {
                    log.debug("uuid: " + uuid);
                    var nguri = this._anzoClient._getGraphUriFromUuid(uuid);
                    log.debug("nguri: " + nguri);
                    if (nguri) {
                        namedGraphUris.push(nguri);
                    }
                }
            }
            this.transactionComplete(uri, timestamp, namedGraphUris, transactionContext);
        }
    },

    _messageListener : function _messageListener(message) {
        // summary: real-time updates come in via this method. This method parses them and fires
        //   the appropriate events on the appropriate listeners.
        // message: the real-time update notification message.

        if (log.isDebugEnabled()) {
            log.debug("Message Received by RealtimeUpdateManager:" + dojo.toJson(message, true));
        }
       
        var ser = anzo.client.Serialization;
        var msgProperties = message.properties;
        var operation = msgProperties[ser.OPERATION];
        if (operation == ser.UPDATE_RESULTS) {
            // Sample "Statement Update" Message (a statement removal):
            // ---------------
            // Destination = temp-topic://ID:snorks-2067-1205420589328-2:0:179
            // object = Look at me too!
            // namedGraphUri = http://example.org/testGraph1
            // type = Statement
            // dataType = http://www.w3.org/2001/XMLSchema#string
            // transactionURI = http://openanzo.org/namedGraphs//1c6ca986-abb7-44bb-8a0b-9f12114cc690
            // subject = http://example.com/subject21
            // subjectType = URI
            // objectType = LITERAL
            // predicate = http://example.com/predicate22
            // operation = UpdateResults
            // method = false
            // version = http://openanzo.org/Server/76af2774-3c23-4b05-83d9-85a266a21a4e
            // ---------------
            
            var subjectString = msgProperties[ser.SUBJECT];
            var subjectTypeString = msgProperties[ser.SUBJECT_TYPE];
            var predicateString = msgProperties[ser.PREDICATE];
            var objectString = msgProperties[ser.OBJECT];
            var objectTypeString = msgProperties[ser.OBJECT_TYPE];
            var methodString = msgProperties[ser.METHOD];
            var datatypeString = msgProperties[ser.DATATYPE];
            var languageString = msgProperties[ser.LANGUAGE];
            var graphUriString = msgProperties[ser.NAMED_GRAPH_URI];
            
            if (subjectString && subjectTypeString && predicateString && objectString && objectTypeString && methodString) {
                var subject = null;
                if (subjectTypeString == ser.UPDATE_VALUE_TYPE_URI) {
                    subject = anzo.createURI(subjectString);
                } else if (subjectTypeString == ser.UPDATE_VALUE_TYPE_BNODE) {
                    subject = anzo.createBNode(subjectString);
                }
                if (subject) {
                    var object = null;
                    if (objectTypeString == ser.UPDATE_VALUE_TYPE_LITERAL) {
                        if (datatypeString && datatypeString.length > 0) {
                            object = anzo.createTypedLiteral(objectString, datatypeString);
                        } else if (languageString && languageString.length > 0) {
                            object = anzo.createLiteral(objectString, languageString);
                        } else {
                            object = anzo.createLiteral(objectString);
                        }
                    } else if (objectTypeString == ser.UPDATE_VALUE_TYPE_BNODE) {
                        object = anzo.createBNode(objectString);
                    } else if (objectTypeString == ser.UPDATE_VALUE_TYPE_URI) {
                        object = anzo.createURI(objectString);
                    }
                    
                    if (object) {
                        var statement = anzo.createStatement(subject, anzo.createURI(predicateString), object, anzo.createURI(graphUriString));
                        
                        var additionOrRemoval = null;
                        var validMethod = true;
                        if (methodString == ser.UPDATE_METHOD_ADDITION) {
                            additionOrRemoval = true;
                        } else if (methodString == ser.UPDATE_METHOD_REMOVAL) {
                            additionOrRemoval = false;
                        } else {
                            validMethod = false;
                        }
                        if (validMethod) {
                            this._notifyTrackers(additionOrRemoval, statement);
                        } else {
                            log.info("Invalid 'statement' real-time update message. Unknown update method:" + methodString + ". Ignoring message.");
                        }
                    } else {
                        log.info("Invalid 'statement' real-time update message. Unknown object type:" + objectTypeString + ". Ignoring message."); 
                    }
                } else {
                    log.info("Invalid 'statement' real-time update message. Unknown subject type:" + subjectTypeString + ". Ignoring message.");
                }
            } else {
                log.info("Invalid 'statement' real-time update message. Missing required properties. Ignoring message.");
            }
        } else if (operation == ser.DATASET_UPDATE) {
            // Sample JMS DatasetUpdate message
            // Destination = temp-topic://ID:snorks-2071-1233248492656-2:2:8
            // operation = DatasetUpdate
            // namedGraphUri = http://example.org/defaultGraph1
            // datasetUri = http://example.com/myTracker1,http://example.com/myTracker2

            var datasetTrackerUriStr = msgProperties[ser.DATASET_URI];
            var datasetTrackerUris = datasetTrackerUriStr.split(",");
            for (var i = 0; i < datasetTrackerUris.length; i++) {
                var datasetTrackerUri = datasetTrackerUris[i];
                var tracker = this._uriToDatasetTracker[datasetTrackerUri];
                if (tracker) {
                    tracker.notifyListeners();
                }
            }
        }
    },

    _connect : function _connect(callback) {
        // summary: Connect to the notification service and register all trackers that may have already been registered.
        // callback : Function(Boolean success, Object error)
        //   Optional. Method called upon completion of the requested operation.
        //   The success argument denotes if the tracker was successfully registered. 
        //   The error argument contains information about any error in the case of failure.
        //   The error argument is null in case of success.
        //   Turning the error object into a string with dojo.toJson to display error
        //   information is recommended.
        if (this._closed) {
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }

        if (!this._connected) {
            var finishConnect = dojo.hitch(this, function(callback) {
                this._connected = true
                this._registrationService.setListener(dojo.hitch(this, this._messageListener));
                this._registerAllTrackersNotification(callback);
            });
            
            if (this._receiveTransactions) {
                this._subscribeToTransactionTopic(true, dojo.hitch(this, function(success, errors) {
                    if (success) {
                        finishConnect(callback);
                    } else {
                        callback(false, errors);
                    }
                }));
            } else {
                finishConnect(callback);
            }
        } else {
            log.debug("_connect - already connected.");
            if (callback) {
                callback(true, null);
            }
        }
    },

    _disconnect : function _disconnect(callback) {
        // summary: Disconnect from the notification service. Trackers and listeners are left intact. They
        //   will become active again if '_connect' is called.
        // callback : Function(Boolean success, Object error)
        //   Optional. Method called upon completion of the requested operation.
        //   The success argument denotes if the tracker was successfully registered. 
        //   The error argument contains information about any error in the case of failure.
        //   The error argument is null in case of success.
        //   Turning the error object into a string with dojo.toJson to display error
        //   information is recommended.
        
        if (this._closed) {
            callback(false, new Error(this._CLOSED_ERROR_MESSAGE));
            return;
        }

        if (this._connected) {
            this._connected = false;
            this._registrationService.disconnect(dojo.hitch(this, function registrationServiceDisconnect(success, errors) {
                if (!success && log.isWarnEnabled()) {
                    log.warn("Error disconnecting from realtimeUpdate registration service:" + dojo.toJson(errors));
                }
                if (this._connectedToTransactionTopic) {
                    this._subscribeToTransactionTopic(false, dojo.hitch(this, function transactionUpdatesUnregister(success2, errors2) {
                        if (!success && log.isWarnEnabled()) {
                            log.warn("Error unsubscribing from transaction event topic:" + dojo.toJson(errors));
                        }
                        if (callback) {
                            callback(success && success2, (errors || errors2) ? [errors, errors2] : null);
                        }
                    }));
                } else {
                    if (callback) {
                        callback(success, errors);
                    }
                }
            }));
        } else {
            log.debug("_close - already disconnected");
            if (callback) {
                callback(true, null);
            }
        }
    },

    _close : function _close(callback) {
        // summary: Disconnect from the notification service, clear all trackers and listeners
        //   of any kind and generally clean up. This is typically called from the AnzoClient's disconnect or close method.
        // callback : Function(Boolean success, Object error)
        //   Optional. Method called upon completion of the requested operation.
        //   The success argument denotes if the tracker was successfully registered. 
        //   The error argument contains information about any error in the case of failure.
        //   The error argument is null in case of success.
        //   Turning the error object into a string with dojo.toJson to display error
        //   information is recommended.
        
        // Get rid of all state. Especially important are the references to listeners and the
        // registration service since those are circular references.

        if (this._closed) {
            log.debug("Already closed.");
        } else {
            if (this._connected) {
                this._disconnect(dojo.hitch(this, function closeDisconnect(success, errors) {
                    this._resetUpdateClientState(); 
                    this._closed = true;
                    if (callback) {
                        callback(success, errors);
                    }
                }));
            } else {
                this._resetUpdateClientState();
                this._closed = true;
                if (callback) {
                    callback(true, null);
                }
            }
        }
    },
    
    _resetUpdateClientState : function _resetUpdateClientState() {
        // summary: Resets the internal state for keeping track of the trackers and listeners.

        this._uriToDatasetTracker = {};
        this._patternToTracker = {};
        // Indexes used to efficiently find trackers that match a given statement.
        this._sIndex = {};
        this._pIndex = {};
        this._oIndex = {};
        this._cIndex = {};

        this._receiveTransactions = false;
        this._registrationService.setListener(null); // break the circular reference

        this._anzoClient = null;

        this._receiveTransactions = false;
        this._connectedToTransactionTopic = false;
       
        this._connected = false;
    },
    
    _subscribeToTransactionTopic : function _subscribeToTransactionTopic(subscribeOrUnsubscribe, callback) {
        // summary: subscribes or unsubscribes from the JMS topic on which transaction events are broadcast.
        var topic = anzo.client.Vocabulary.TRANSACTIONS_TOPIC;
        if (subscribeOrUnsubscribe) {
            anzo.messaging.JMSClient.subscribeToTopics(topic, dojo.hitch(this, this._transactionListener), dojo.hitch(this, function(success, failedTopics, error) {
                if (log.isDebugEnabled()) {
                    log.debug("subscribed to transaction topic success:" + success);
                }
                this._connectedToTransactionTopic = true;
                if (callback) {
                    callback(success, error);
                }
            }));
        } else {
            anzo.messaging.JMSClient.unsubscribeFromTopics(topic, dojo.hitch(this, function(success, error) {
                if (log.isDebugEnabled()) {
                    log.debug("unsubscribed to transaction topic success:" + success);
                }
                this._connectedToTransactionTopic = false;
                if (callback) {
                    callback(success, error);
                }
            }));
        }    	
    },

    _registerAllTrackersNotification : function _registerAllTrackersNotification(callback) {
        // summary: Subscribes all active trackers for notification with the server. If the RealtimeUpdateManager
        //   isn't connected yet then this does nothing. It's the job of the AnzoClient to connect and close the
        //   RealtimeUpdateManager.
        // callback: Function(Boolean success, Object errors). Optional callback method called
        //   once all trackers have been registered. If any tracker failed to register, then
        //   the success argument is false. Otherwise it is true. In case of failure, the errors argument
        //   contains error information.

        if (this._connected) {
            // Collect the trackers into arrays.
            var statementTrackers = [];
            for(var key in this._patternToTracker) {
                var tracker = this._patternToTracker[key];
                statementTrackers.push(tracker);
            }
            var datasetTrackers = [];
            for(var key in this._uriToDatasetTracker) {
                var tracker = this._uriToDatasetTracker[key];
                datasetTrackers.push(tracker);
            }
            if (statementTrackers.length > 0 || datasetTrackers.length > 0) {
                // This will also take care of calling 'connect' internally.
                this._registrationService.registerTrackers(statementTrackers, datasetTrackers, callback);
            } else {
                // If there aren't any trackers we'll just make the connect call since we may still be interested
                // in transaction messages.
                this._registrationService.connect(callback);
            }
        } else {
            if (callback) {
                callback(true, null);
            }
        }
    },

    _getPatternStatement : function _getPatternStatement(subject, predicate, object, namedGraphUri) {
        // summary: Creates an anzo.rdf.Statement for the given pattern, including using the anzo.client.Vocabulary.ANY URI for wildcards.
        // subject: anzo.rdf.Resource | String
        //   The subject of the pattern. null indicates a wildcard.
        // predicate: anzo.rdf.URI | String
        //   The predicate of the pattern. null indicates a wildcard.
        // object: anzo.rdf.Value | Object
        //   The object of the pattern. null indicates a wildcard.
        // namedGraphUri: anzo.rdf.URI | String
        //   URI of the named graph. null indicates a wildcard.
        var s = this._getValueOrWildcard(subject,   { type: 'anzo.rdf.Resource' });
        var p = this._getValueOrWildcard(predicate, { type: 'anzo.rdf.URI' });
        var o = this._getValueOrWildcard(object);
        var c = this._getValueOrWildcard(namedGraphUri, { type: 'anzo.rdf.URI' });
        var stmt = anzo.createStatement(s, p, o, c);
        return stmt;
    },
    
    _getValueOrWildcard : function _getValueOrWildcard(value, constraints) {
        // summary: If the value is null is returns the reserverd wildcard URI value (anzo.client.Vocabulary.ANY),
        //   otherwise it calls anzo.rdf.getValue.
        // description: This is a utility function to ensure that we create valid anzo.rdf.Statement
        //   objects out of patterns. Null subjects, objects, or predicates aren't allowed in anzo.rdf.Statement
        //   objects so we use a reserved URI to denote wildcards in the patterns.
        // value: Object
        //  Value for which an anzo.rdf.Value is created.
        // constraints: Object
        //  Optional parameter that gives hints as to what the value is. These are passed to anzo.rdf.getValue.
        // returns: Returns an anzo.rdf.Value for the given value.  Returns anzo.client.Vocabulary.ANY if the value is null.
       
        if(value == null || anzo.client.Vocabulary.ANY.equals(value))
            return anzo.client.Vocabulary.ANY;
        return anzo.rdf.getValue(value, constraints);
    },

    _addMaps : function(tracker) {
        // summary: Index the pattern for the given tracker.
        // tracker : anzo.client._StatementTracker
        //   The tracker who's pattern is indexed.
        
        var subjectKey = tracker.statement.subject.dictionaryKey();
        var predicateKey = tracker.statement.predicate.dictionaryKey();
        var objectKey = tracker.statement.object.dictionaryKey();
        var graphUriKey = tracker.statement.namedGraphUri.dictionaryKey();

        if(!this._sIndex[subjectKey])
            this._sIndex[subjectKey] = [];
        this._sIndex[subjectKey].push(tracker);
        
        if(!this._pIndex[predicateKey])
            this._pIndex[predicateKey] = [];
        this._pIndex[predicateKey].push(tracker);
        
        if(!this._oIndex[objectKey])
            this._oIndex[objectKey] = [];
        this._oIndex[objectKey].push(tracker);
        
        if(!this._cIndex[graphUriKey])
            this._cIndex[graphUriKey] = [];
        this._cIndex[graphUriKey].push(tracker);
        
    },
    
    _removeMaps : function(tracker) {
        // summary: Removes the index for the pattern of the given tracker.
        // tracker : anzo.client._StatementTracker
        //  The tracker who's pattern is removed from the indexes.
        
        var subjectKey = tracker.statement.subject.dictionaryKey();
        var predicateKey = tracker.statement.predicate.dictionaryKey();
        var objectKey = tracker.statement.object.dictionaryKey();
        var graphUriKey = tracker.statement.namedGraphUri.dictionaryKey();
        
        if(this._sIndex[subjectKey]) {
            var subjectIndexEntry = this._sIndex[subjectKey];
            var i = dojo.indexOf(subjectIndexEntry, tracker);
            if(i >= 0) 
                anzo.utils.removeIndex(subjectIndexEntry, i);
            if(subjectIndexEntry.length == 0)
                delete this._sIndex[subjectKey];
        }
        
        if(this._pIndex[predicateKey]) {
            var i = dojo.indexOf(this._pIndex[predicateKey], tracker);
            if(i >= 0) 
                anzo.utils.removeIndex(this._pIndex[predicateKey], i);
            if(this._pIndex[predicateKey].length == 0)
                delete this._pIndex[predicateKey];
        }
        
        if(this._oIndex[objectKey]) {
            var i = dojo.indexOf(this._oIndex[objectKey], tracker);
            if(i >= 0) 
                anzo.utils.removeIndex(this._oIndex[objectKey], i);
            if(this._oIndex[objectKey].length == 0)
                delete this._oIndex[objectKey];
        }
        
        if(this._cIndex[graphUriKey]) {
            var i = dojo.indexOf(this._cIndex[graphUriKey], tracker);
            if(i >= 0) 
                anzo.utils.removeIndex(this._cIndex[graphUriKey], i);
            if(this._cIndex[graphUriKey].length == 0)
                delete this._cIndex[graphUriKey];
        }
    },

    _addToSet : function _addToSet(set, items) {
        // summary: adds all of the items to the given set with identity based on each item's dictionaryKey method.
        for(var i = 0; i < items.length; i++) {
            set[items[i].dictionaryKey()] = items[i];
        }
    },
    
    _notifyTrackers : function _notifyTrackers(addition, statement) {
        // summary: Notifies the trackers of statement changes.
        // addition: Boolean
        //  If true then the event is for addition of a new statement, if false then deletion of a statement.
        // statement: anzo.rdf.Statemenet
        //  The statement that was added or removed.

        var sKey   = statement.subject.dictionaryKey();
        var pKey   = statement.predicate.dictionaryKey();
        var oKey   = statement.object.dictionaryKey();
        var cKey   = statement.namedGraphUri.dictionaryKey();
        var anyKey = anzo.client.Vocabulary.ANY.dictionaryKey();

        var sSet = {};
        var pSet = {};
        var oSet = {};
        var cSet = {};
        
        var l = [];
        l = this._sIndex[sKey];
        if (l) {
            this._addToSet(sSet, l);
        }
        l = this._sIndex[anyKey];
        if (l) {
            this._addToSet(sSet, l);
        }

        l = this._pIndex[pKey];
        if (l) {
            this._addToSet(pSet, l);
        }
        l = this._pIndex[anyKey];
        if (l) {
            this._addToSet(pSet, l);
        }

        l = this._oIndex[oKey];
        if (l) {
            this._addToSet(oSet, l);
        }
        l = this._oIndex[anyKey];
        if (l) {
            this._addToSet(oSet, l);
        }

        l = this._cIndex[cKey];
        if (l) {
            this._addToSet(cSet, l);
        }
        l = this._cIndex[anyKey];
        if (l) {
            this._addToSet(cSet, l);
        }

        var set = new Array(4);
        set[0] = sSet;
        set[1] = pSet; 
        set[2] = oSet;
        set[3] = cSet;
        
        for(var key in set[0]) {
           var tracker = set[0][key]; 
           if(tracker && (key in set[1]) && (key in set[2]) && (key in set[3]))
               tracker.notifyListeners(addition, [ statement ]);
        }  
    }

});

})();
