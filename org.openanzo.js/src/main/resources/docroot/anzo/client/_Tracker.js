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

dojo.provide("anzo.client._Tracker");

dojo.require("anzo.rdf.Statement");
dojo.require("anzo.utils.UriGenerator");
dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.rdf.vocabulary.RDF");

/*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.declare('anzo.client._Tracker', null, {
    
    // _listeners : Array
    //    List of objects which are interested in events for updates that match this tracker.
    _listeners : null,
    
    // _listenerCount : Number
    //   Count of the registered listeners on this tracker. The _listener's length property isn't reliable since it's a sparse array.
    _listenerCount : 0,
    
    constructor : function() {
        this._listeners = [];
        this._listenerCount = 0;
    },
    
    addListener : function(listener) {
        // summary: Add a listener to the tracker, making sure not to add duplicates.
        // listener: Object. The listener to add.
        // returns: true if the listener was added, false if the listener already existed.
        if (anzo.utils._sparseArrayFind(this._listeners, listener) == -1) {
            this._listeners.push(listener);
            this._listenerCount++;
            return true;
        }
        return false;
    },

    removeListener : function(listener) {
        // summary: Removes a listener from the tracker.
        // listener: Object. The listener to remove.
        // returns: true if the listener was removed, false if the listener wasn't found.
        var i = anzo.utils._sparseArrayFind(this._listeners, listener);
        if (i != -1) {
            delete this._listeners[i];
            this._listenerCount--;
            return true;
        }
        return false;
    },
    
    getListenerCount : function() {
        // summary: Gets the number of listeners registered on this tracker.
        return this._listenerCount;
    }
});

dojo.declare('anzo.client._StatementTracker', anzo.client._Tracker, {
    
    _SELECTOR_TRACKER_TYPE_URI : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#SelectorTracker"),
    _SELECTOR_TRACKER_SUBJECT : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#subject"),
    _SELECTOR_TRACKER_PREDICATE : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#predicate"),
    _SELECTOR_TRACKER_OBJECT : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#object"),
    _SELECTOR_TRACKER_GRAPH_URI : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#namedGraphUri"),
    
    // statement : anzo.rdf.Statement
    //   Specifies the pattern of this tracker.
    statement : null,
    
    constructor : function() {
        // summary: Initialize local data structures.
        // description: The constructor can be called in two forms:
        //   statement - anzo.rdf.Statement
        //      Statement that describes the tracked pattern.
        //   OR
        //   subject: anzo.rdf.Resource
        //     Subject of the quad pattern that will be tracked. Must not be null.
        //   predicate: anzo.rdf.URI
        //     Predicate of the quad pattern that will be tracked. Must not be null.
        //   object: anzo.rdf.Value
        //     Object of the quad pattern that will be tracked. Must not be null.
        //   namedGraphUris: anzo.rdf.URI
        //     Named graph uri of the quad pattern that will be tracked. Must not be null.
        
        if(arguments[0] instanceof anzo.rdf.Statement)
            this.statement = arguments[0];
        else
            this.statement = anzo.createStatement(arguments[0], arguments[1], arguments[2], arguments[3]);
    },
    
    notifyListeners : function(addition, statements) {
        // summary: Call all of this tracker's listeners with an event as given.
        // statements: Array of anzo.rdf.Statement objects which were added or removed.
        anzo.utils._sparseArrayForEach(this._listeners, function listenerNotifier(item) {
            var eventName = addition ? "statementsAdded" : "statementsRemoved";
            var method =  item[eventName];
            if (dojo.isFunction(method)) {
                setTimeout(function() { method(statements); }, 0);
            }
        });
    },
    
    serialize : function(statements) {
        // summary: Serialize the tracker to a set of RDF statements.
        // statements: Array
        //   Optional. If given, then the statements resulting from the serialization are appended to this array.
        //   Otherwise, the new statements are returned in a new array.
        // returns: The statements array given as an argument or a new array with the serialized tracker statements
        //   if the statements array argument wasn't given.
        
        if (!dojo.isArray(statements)) {
            statements = [];
        }
        
        var trackerUri = anzo.utils.UriGenerator.generateUri("http://openanzo.org/trackers/");
        statements.push(anzo.createStatement(trackerUri, anzo.rdf.vocabulary.RDF.type, this._SELECTOR_TRACKER_TYPE_URI, trackerUri));
        statements.push(anzo.createStatement(trackerUri, this._SELECTOR_TRACKER_SUBJECT, this.statement.subject, trackerUri));
        statements.push(anzo.createStatement(trackerUri, this._SELECTOR_TRACKER_PREDICATE, this.statement.predicate, trackerUri));
        statements.push(anzo.createStatement(trackerUri, this._SELECTOR_TRACKER_OBJECT, this.statement.object, trackerUri));
        statements.push(anzo.createStatement(trackerUri, this._SELECTOR_TRACKER_GRAPH_URI, this.statement.namedGraphUri, trackerUri));
        
        return statements;
    },
    
    dictionaryKey : function() {
        return this.statement.dictionaryKey();
    }
});

dojo.declare('anzo.client._DatasetTracker', anzo.client._Tracker, {
    
    _DATASET_TRACKER_TYPE_URI : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#DatasetTracker"),
    _DATASET_TRACKER_NAMED_DATASET : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#namedDataset"),
    _DATASET_TRACKER_DEFAULT_GRAPH : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#defaultGraph"),
    _DATASET_TRACKER_NAMED_GRAPH : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#namedGraph"),

    constructor : function(datasetTrackerURI, defaultNamedGraphs, namedGraphs, namedDatasets) {
        // summary: Creates an object to collect the listeners for a particular dataset tracker.
        // datasetTrackerURI: anzo.rdf.URI | String
        //   The unique identifier of this dataset tracker.
        // defaultNamedGraphs: anzo.rdf.URI | String | Array
        //   Named Graph URI(s) to track for any changes. Optional. 
        // namedGraphs: anzo.rdf.Resource | String | Array
        //   Named Graph URI(s) to track for any changes. Optional.
        // namedDatasets: anzo.rdf.URI | String | Array
        //   Named Dataset URI(s) to track for any changes.
        this.datasetTrackerURI = anzo.createURI(datasetTrackerURI);
        this.defaultNamedGraphs = defaultNamedGraphs;
        this.namedGraphs = namedGraphs;
        this.namedDatasets = namedDatasets;
    },
    
    notifyListeners : function() {
        // summary: Call all of this tracker's listeners' 'datasetChanged'.
        anzo.utils._sparseArrayForEach(this._listeners, function listenerNotifier(item) {
            var method =  item['datasetChanged'];
            if (dojo.isFunction(method)) {
                setTimeout(function() { method(); }, 0);
            }
        });
    },
    
    serialize : function(statements) {
        // summary: Serialize the tracker to a set of RDF statements.
        // statements: Array
        //   Optional. If given, then the statements resulting from the serialization are appended to this array.
        //   Otherwise, the new statements are returned in a new array.
        // returns: The statements array given as an argument or a new array with the serialized tracker statements
        //   if the statements array argument wasn't given.
        
        if (!dojo.isArray(statements)) {
            statements = [];
        }
        
        var trackerUri = this.datasetTrackerURI;
        statements.push(anzo.createStatement(trackerUri, anzo.rdf.vocabulary.RDF.type, this._DATASET_TRACKER_TYPE_URI, trackerUri));
        this._serializeObjectList(statements, trackerUri, this._DATASET_TRACKER_NAMED_DATASET, this.namedDatasets, trackerUri);
        this._serializeObjectList(statements, trackerUri, this._DATASET_TRACKER_DEFAULT_GRAPH, this.defaultNamedGraphs, trackerUri);
        this._serializeObjectList(statements, trackerUri, this._DATASET_TRACKER_NAMED_GRAPH, this.namedGraphs, trackerUri);

        return statements;
    },
    
    _serializeObjectList : function(statements, subject, predicate, objectList, namedGraphUri) {
        // summary: Append new statements to the given statements array such that each new statement 
        //   uses the given subject, predicate, one object from the given objectList, and the given namedGraphUri. 
        if (dojo.isArray(objectList)) {
            for (var i = 0; i < objectList.length; i++) {
                statements.push(anzo.createStatement(subject, predicate, objectList[i], namedGraphUri));
            }
        } else if (objectList != null) {
            statements.push(anzo.createStatement(subject, predicate, objectList, namedGraphUri));
        }
    },

    dictionaryKey : function() {
        return this.datasetTrackerURI.toString();
    }
});
