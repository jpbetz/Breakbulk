/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Simon Martin ( <a href="mailto:simon@cambridgesemantics.com">simon@cambridgesemantics.com </a>)
 * Created on:  Jun 06, 2008
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/


dojo.provide("anzo.client.BinaryStore");

dojo.require("anzo.utils.UriGenerator");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.client.StatementChannel");
dojo.require("dojo.io.iframe");

(function() {
var log = anzo.log.getLogger("anzo.client.BinaryStore");

dojo.declare('anzo.client.BinaryStore', null, {
	
	constructor : function(url, anzoClient) {
		this._url = url;
		this._anzoClient = anzoClient;
		this._filelist = [];
		this._feedbackURIs = [];
	},
	
	connect : function(callback) {
		var username = this._anzoClient.properties.username;
		var feedbackURI = anzo.client.BinaryStore.createFeedbackURI(username);
		var _this = this;
		this._anzoClient.getStatementChannel(feedbackURI, function(success,error) {
				if (success) {
					_this._anzoClient.updateRepository();
				} else {
					callback(false,error);
				}
			}, 
			function (channel, error) {
				_this._channel = channel;
				_this._channellistener = function(properties, statements) {
				var jobCompleted = -1;
				var jobComplete = -1;
				var job = null;
				// a job should have at least 3 statements.
				var additionalStatements = [];
				if (statements.length < 3)
					return;
				for (var i = 0 ; i < statements.length ; i++) {
					if (statements[i].predicate.equals(anzo.client.BinaryStore.PROGRESS_JOB_URI)){
						job = statements[i].object;
					} else
					if (statements[i].predicate.equals(anzo.client.BinaryStore.PROGRESS_JOB_COMPLETED_URI)){
						jobCompleted = statements[i].object.toString();
					} else 
					if (statements[i].predicate.equals(anzo.client.BinaryStore.PROGRESS_JOB_COMPLETE_URI)){
						jobComplete = statements[i].object.toString();
					} else {
						additionalStatements.push(statements[i]);
					}
				}
				_this._onProgress(statements[0].subject, job, jobCompleted, jobComplete, additionalStatements);
			};
			channel.registerListener(_this._channellistener,
				function (success,error){
					if (!success) {
						_this._updating = false;
						callback(false, new Error("Could not prescribe to progress updates." + error.toString()));
						return;
					}
					callback(true);
				});
		},[anzoClient.getRevisionedGraphInitializer(false)]);
	},
	disconnect : function() {
		this.channel.close();
	},
	
	_addFeedbackListener : function(uri, callback) {
		this._feedbackURIs[uri] = callback;
	},
	 
	_removeFeedbackListener : function(uri, callback) {
		if (this._feedbackURIs[uri])
			delete this._feedbackURIs[uri];
	},
	
	_onProgress : function(subject, job, jobCompleted, jobComplete, additionalStatements) {
		if (this._feedbackURIs[subject.toString()])
			this._feedbackURIs[subject.toString()]( job, jobCompleted, jobComplete, additionalStatements );
	},
	
	addItem : function addItem(revisioned) {
		var bsi = new anzo.client.BinaryStoreItem(this, revisioned);
		return bsi;
	},
	
	getItem : function getItem(uri, callback) {
		if (this._filelist[uri]) {
			//call back asynchronously
			setTimeout(dojo.hitch(this,callback,this._filelist[uri]), 0);
		}
		else {
			var _this = this;
			// look for file in binary store.
			_this._anzoClient.containsNamedGraph(anzo.createURI(uri),function(response,exists,error) {
				if (exists) {
					_this._anzoClient.getReplicaGraph(anzo.createURI(uri), null, function(graph,error) {
						if (!graph || error) {
							callback (null, error ? new Error("Could not locate binary store item " + error.toString()) : new Error("Invalid binary store item uri"));
							return;
						}
						//check its a binary store item
						if (!graph.contains(anzo.createURI(uri), anzo.rdf.vocabulary.RDF.type, anzo.client.BinaryStore.BINARYSTORE_ITEM_URI)) {
							callback (null, new Error("Invalid binary store item uri"));
							return;
						}
						var bsi = new anzo.client.BinaryStoreItem(_this, graph, uri);
						_this._filelist[uri] = bsi;
						callback(bsi, null);
					});
				} else {
					callback (null, error ? new Error("Could not locate binary store item " + error.toString()) : new Error("Invalid binary store item uri"));					
				}
			});
		}
	},
	
	removeItem : function removeFile(uri, callback) {
		if (uri instanceof anzo.client.BinaryStoreItem) 
			uri = uri.src;
		var _this = this;
		this._anzoClient.containsNamedGraph(anzo.createURI(uri),function(response,exists,error) {
			if (!exists) {
				callback (error ? new Error("Could not locate binary store item " + error.toString()) : new Error("Invalid binary store item uri"));
			} else {
				_this._anzoClient.getReplicaGraph(anzo.createURI(uri),null, function(graph,error) {
					if (!graph || error) {
						callback (error ? new Error("Could not locate binary store item " + error.toString()) : new Error("Invalid binary store item uri"));
						return;
					}
					//check its a binary store item
					if (!graph.contains(anzo.createURI(uri), anzo.rdf.vocabulary.RDF.type, anzo.client.BinaryStore.BINARYSTORE_ITEM_URI)) {
						callback (new Error("Invalid binary store item uri"));
						return;
					}
					_this._anzoClient.begin();
					graph.remove(anzo.createURI(uri), anzo.rdf.vocabulary.RDF.type, anzo.client.BinaryStore.BINARYSTORE_ITEM_URI);
					_this._anzoClient.commit();
					_this._anzoClient.begin();
					graph.metadataGraph.remove(anzo.createURI(uri), anzo.rdf.vocabulary.RDF.type, anzo.client.Vocabulary.namedGraphType);
					_this._anzoClient.commit();
					graph.close();
					_this._anzoClient.updateRepository();
					delete _this._filelist[uri];
					callback(null);
				});
			}
		});
	}
});

dojo.mixin(anzo.client.BinaryStore, {
   	PROGRESSURI_PREFIX  : anzo.createURI("http://openanzo.org/ontologies/2008/07/AnzoBinaryStore/FeedbackChannel/Progress/"),
   	PROGRESS_JOB_URI: anzo.createURI("http://openanzo.org/ontologies/2008/07/AnzoBinaryStore#job"),
   	PROGRESS_JOB_COMPLETE_URI: anzo.createURI("http://openanzo.org/ontologies/2008/07/AnzoBinaryStore#jobcomplete"),
   	PROGRESS_JOB_COMPLETED_URI : anzo.createURI("http://openanzo.org/ontologies/2008/07/AnzoBinaryStore#jobcompleted"),
   	BINARYSTORE_ITEM_URI : anzo.createURI("http://openanzo.org/ontologies/2008/07/AnzoBinaryStore#binarystoreitem"),
    CREATE : "create",
    UPDATE : "update",
    DELETE : "delete",
    READ   : "read",
    createFeedbackURI : function (username) { return anzo.createURI("http://openanzo.org/ontologies/2008/07/AnzoBinaryStore/FeedbackChannel#" + username); }
    
});


dojo.declare('anzo.client.BinaryStoreItem', null, {
	//TODO: watch for file being deleted and set invalid if not
	isRevisioned : false,
	
	src : null,
	
	isValid : false,
	
	revision: -1,
	
	fireEvents : true,
	
	graph : null,
	
	_graphConnection : null,
	
	onProgress : function onProgress( job, jobCompleted, jobComplete, additionalStatements ){
		
	},
	
	constructor : function(bs, arg2, src) {
		this._updating = false;
		this._binaryStore = bs;
		this._isRevisioned = false;
		if (arg2 instanceof anzo.client.ClientGraph) {
			// this is an getFile
			var graph = arg2; 
			this.src = src; 
			var stmts = graph.metadataGraph.find(anzo.createURI(src), anzo.client.Vocabulary.revisionedProperty, null);
			if (stmts.length > 0) {
				this._isRevisioned  = stmts[0].object.toString();
			}
			if (this._isRevisioned) {
				var stmts = graph.metadataGraph.find(anzo.createURI(src), anzo.client.Vocabulary.revisionProperty, null);
				if (stmts.length > 0) {
					this.revision = stmts[0].object.toString();
				}
			} else this.revision = -1;
			this.graph = arg2;
			this.isValid = true;
			this._hookGraph();
		} else {
			// this is an addFile
			this._isRevisioned = arg2;
		}
	},
	
	update : function update(form, callback) {
		if (this._updating) {
			callback(new Error("Already updating."));
			return;
		}
		var _this = this;
		this._updating = true;
		var progressUri = null;
		if (this.fireEvents) {
			var progressUri = anzo.utils.UriGenerator.generateUri(anzo.client.BinaryStore.PROGRESSURI_PREFIX);
			this._binaryStore._addFeedbackListener(progressUri, dojo.hitch(this, this.onProgress));
		}
		var url ;
		if (!this.src) {
			//creating
			url = this._binaryStore._url + "/" + anzo.client.BinaryStore.CREATE + "?revisioned=" + this._isRevisioned.toString() + ((this.fireEvents  && progressUri)? "&upload_uri=" + progressUri.toString() : "" );
		} else {
			//updating
			url = this._binaryStore._url + "/" + anzo.client.BinaryStore.UPDATE + "?graph=" + this.src + ((this.fireEvents && progressUri) ? "&upload_uri=" + progressUri.toString() : "" );
		}
		dojo.byId(form).setAttribute("encType","multipart/form-data");
		dojo.byId(form).setAttribute("encoding","multipart/form-data");
		dojo.byId(form).setAttribute("method","POST");
		dojo.io.iframe.send({
			url: url,
			method : "post",
			form: dojo.byId(form),
			handleAs: "json",
			handle: dojo.hitch(this, function(response, ioArgs){
				this._updating = false;
				if (progressUri) {
					this._binaryStore._removeFeedbackListener(progressUri);
				}
				if(response instanceof Error || response.error){
					callback(response instanceof Error ? new Error("Binary File update FAILED: " + response.toString) : new Error(response.statusMessage));
				} else {
					this.src = response.uri;
					this.revision = response.revision;
					this.isValid = true;
					this._binaryStore._filelist[this.src] = this;
					var _this = this;
					if (!this.graph) {
						this._binaryStore._anzoClient.getReplicaGraph(response.uri, null, function(graph, error) {
							if (!graph || error) {
								callback (error ? new Error("Could not locate binary store item " + error.toString()) : new Error("Invalid binary store item uri"));
								return;
							}
							if (graph) {
								_this.graph = graph;
								_this._hookGraph();
								callback(null);
							}
						});
					} else	callback(null);
				}
			})
		});
	},
	
	_hookGraph : function() {
		if (this._graphConnection) {
			dojo.disconnect(this._graphConnection);
		}
		this._graphConnection = dojo.connect(this.graph, 'statementsRemoved', this, '_onStatementsRemoved');
		isValid = true;
	},
	
	_onStatementsRemoved :function(statements) {
		for (var i = 0; i < statements.length; i++ ) {
			if (statements[i].object.equals(anzo.client.BinaryStore.BINARYSTORE_ITEM_URI)){
				if (!this._graphConnection)
					dojo.disconnect(this._graphConnection);
				this.isValid = false;
				this.graph.close();
				this.graph = null;
				if (this._binaryStore._filelist[this.src])
					delete this._binaryStore._filelist[this.src];
			}
		}
	}
	
	
});
})();