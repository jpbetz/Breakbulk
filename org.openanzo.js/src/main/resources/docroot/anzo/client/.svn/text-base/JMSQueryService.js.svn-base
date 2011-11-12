/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
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

dojo.provide("anzo.client.JMSQueryService");

dojo.require("anzo.client.Serialization");
dojo.require("anzo.rdf.NamedGraph");
dojo.require("anzo.utils.LRUHash");
dojo.require("anzo.utils.UriGenerator"); 
dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.log");

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
(function(){

var log = anzo.log.getLogger("anzo.client.JMSQueryService");

dojo.declare('anzo.client.JMSQueryService', null, {
    // summary: Service used to query the database.

    constructor : function(realtimeUpdateManager, cacheSize, cullEquivalentQueries) {
        // summary: Create a JMSQueryService.
        // realtimeUpdateManager: anzo.client.RealtimeUpdateManager. Optional. Used to listen for updates that invalidate entries
        //   in the client query cache. If null then client query caching is disabled.
        // cacheSize: Number. Optional. Default is 100. The capacity of the query results cache. -1 denotes an unlimited capacity.
        this._realtimeUpdateManager = realtimeUpdateManager;

        // Setup the client query results cache. We only do caching with a valid RealtimeUpdateManager
        // so that we can listen for graph changes that invalidate entries in the cache.
        if (this._realtimeUpdateManager) {
            if (cacheSize == null) {
                cacheSize = 100; // default cache size is 100
            } else if (cacheSize == 0) {
                throw new Error("cacheSize of zero not allowed. To disable caching, pass null for the realtimeUpdateManager argument.");
            } else if (cacheSize < 0 && cacheSize != -1) {
                throw new Error("cacheSize must be a positive integer or -1 (to denote unlimited cache capacity).");
            }
            var _queryCacheKeyEqualHitched = dojo.hitch(this, this._queryCacheKeyEqual);
            
            // The this._resultsCache object maintains a bounded cache of query results.
            // A query cache key collects the information to uniquely identify a query in an
            // object with the following properties:
            //   query: the query string
            //   defaultNamedGraphs: sorted list of default graph URIs
            //   namedGraphs: sorted list of named graphs
            //   namedDatasets: sorted list of named datasets
            //   baseUri: the query's base URI (as a string, not an anzo.rdf.URI object)
            this._resultsCache = new anzo.utils.LRUHash(this._queryCacheKeyHash, _queryCacheKeyEqualHitched, cacheSize);

            // This stores a set of queries for which we are waiting for a response from the server. It maps the
            // queryCacheKey that uniquely identifies a query to an array of callbacks which are waiting for the
            // query results. This lets us avoid sending out duplicate queries to the server if someone tries to send a query
            // that is the same as one already en route.
            if (cullEquivalentQueries) {
                this._pendingQueries = new anzo.utils.LRUHash(this._queryCacheKeyHash, _queryCacheKeyEqualHitched, -1);
                this._queriesCulled = 0;
            }

            // Maps a 'datasetKey' which is created from a query's sorted dataset uris (namedGraphs, defaultGraphs, and namedDatasets)
            // to a tracker information object. Tracker information objects have the following properties:
            //   uri: String. the unique name of a datasetTracker listening to changes for graphs in the a query dataset
            //   references: Number. count of cache entries that are depending on the tracker for change events.
            // This map's main purpose is to reuse datasetTracker registrations for query datasets that are the same. So we can
            // listen to one tracker for many different queries. This saves server resources.
            this._activeTrackers = {};
            this._onInvalidatedCacheEntryHitched = dojo.hitch(this, this._onInvalidatedCacheEntry);
            
            this._setupDatasetClauseRexExp();
            
            this._cacheHits = 0;
            this._cacheMisses = 0;
        }

    },

    query : function(defaultNamedGraphs, namedGraphs, namedDatasets, queryString, baseUri, callback, options) {
        // summary: Sends asynchronous SPARQL query requests to the server.
        // defaultNamedGraphs: Array | anzo.rdf.URI | String
        //      Named graph URI(s) that identify the graphs that will be merged to form the default graph in the query's RDF Dataset
        // namedGraphs: Array | anzo.rdf.URI | String
        //      Named graph URI(s) that identify the named graph components of the query's RDF Dataset
        // namedDatasets: Array | anzo.rdf.URI | String
        //      Named dataset URI(s) that identify the datasets that the query must run across.
        // queryString: String
        //      The SPARQL query that is to be executed.
        // namedDatasets: Array
        //      List of named dataset URIs that identify the datasets that will be queried across.
        // baseUri : String
        //      The base URI against which relative URI references in the query are resolved
        // callback : Function(Object results, Boolean success, Object error)
        //   Optional. Method called upon completion of the requested operation.
        //   The results argument of the callback contains the result set object (SPARQL result set as a javascript object).
        //   The success argument denotes if the operation completed successfully.
        //   The error argument contains information about any error in the case of failure.
        //   The error argument is null in case of success.
        //   Turning the error object into a string with dojo.toJson to display error
        //   information is recommended.
        //   WARNING: Do not modify the results object or its contents for ASK and SELECT queries. Otherwise 
        //   the value in the cache will be affected.
    	// options: Object
        //   Optional. Contains various optional parameters for the query request.  Including
    	//      timeout: Number
    	//           Amount of time in milliseconds after which the client will stop waiting for the query response and
        //           call the callback with a timeout error. -1 denotes an infinite timeout. The default timeout is -1
        //           regardless of other global timeout default settings.
    	//      priority: Number
    	//           The relative priority of this request.  No guarantees are made about how the server will handle the priority
    	//           but may be used by the client to advise the server.  
    	//      datasource: URI
    	//           The datasource to issue query requests against.  

        // Places to store sorted copies of these arrays for use in the query results cache keys.
        // We copy them because modifying the caller's arrays to sort them wouldn't be very nice of us.
        var sortedDefaultNamedGraphs = null;
        var sortedNamedGraphs = null;
        var sortedNamedDatasets = null;

        var cacheEnabled = this._resultsCache ? true : false;

        if (defaultNamedGraphs) {
            if (cacheEnabled && dojo.isArray(defaultNamedGraphs)) {
                sortedDefaultNamedGraphs = defaultNamedGraphs.slice(0).sort(this._uriComparator);
            } else {
                defaultNamedGraphs = [ defaultNamedGraphs ];
                sortedDefaultNamedGraphs = defaultNamedGraphs;
            }
        }
        if (namedGraphs) {
            if (cacheEnabled && dojo.isArray(namedGraphs)) {
                sortedNamedGraphs = namedGraphs.slice(0).sort(this._uriComparator);
            } else {
                namedGraphs = [ namedGraphs ];
                sortedNamedGraphs = namedGraphs;
            }
        }
        if (namedDatasets) {
            if (cacheEnabled && dojo.isArray(namedDatasets)) {
                sortedNamedDatasets = namedDatasets.slice(0).sort(this._uriComparator);
            } else {
                namedDatasets = [ namedDatasets ];
                sortedNamedDatasets = namedDatasets;
            }
        }

        // Check the query results cache first
        var cacheKey = null;
        var queryServer = true;
        if (cacheEnabled) {
            cacheKey = { query : queryString.toString(),
                         defaultNamedGraphs : sortedDefaultNamedGraphs,
                         namedGraphs : sortedNamedGraphs,
                         namedDatasets : sortedNamedDatasets,
                         baseUri : baseUri ? baseUri.toString() : null };
            var cachedResults = this._resultsCache.get(cacheKey);
            if (cachedResults) {
                this._cacheHits++;
                if (log.isDebugEnabled()) {
                    log.debug("Query Client Cache Hit: " + dojo.toJson(cacheKey, true) );
                }
                queryServer = false;
                setTimeout(function(){ callback(cachedResults, true, null); }, 0);
            } else {
                this._cacheMisses++;
                if (this._pendingQueries) {
                    // Piggyback on the callback of another query request if the query is the same as a query currently in progress 
                    var pendingQueryCallbacks = this._pendingQueries.get(cacheKey);
                    if (pendingQueryCallbacks) {
                        if (log.isDebugEnabled()) {
                            log.debug("Piggybacking on a pending query: " + dojo.toJson(cacheKey, true) );
                        }
                        this._queriesCulled++;
                        pendingQueryCallbacks.push(callback);
                        queryServer = false;
                    } else {
                        pendingQueryCallbacks = [ callback ];
                        callback = dojo.hitch(this, function(results, success, errors) {
                            if (log.isDebugEnabled()) {
                                log.debug("Registered query callback for piggybacking - pendingQueryCallbacks.length:" + pendingQueryCallbacks.length + " cacheKey:" + dojo.toJson(cacheKey, true));
                            }
                            this._pendingQueries.remove(cacheKey);
                            for (var i = 0; i < pendingQueryCallbacks.length; i++) {
                                setTimeout((function(idx){ 
                                    return function() { pendingQueryCallbacks[idx](results, success, errors); };
                                })(i), 0);
                            }
                        });
                        this._pendingQueries.set(cacheKey, pendingQueryCallbacks);
                    }
                }
            }
        }

        if (queryServer) {
            var ser = anzo.client.Serialization;
            var format = ser.MIMETYPE_JSON;
    
            var msg = new anzo.messaging.JMSMessage(null, format);
            var queue = "services/query";
            
            var datasourceUri = null;
            if (options) {
                datasourceUri = options[anzo.client.OPTION_DATASOURCE];
            	if (datasourceUri) {
            		if (datasourceUri.toString() != anzo.client.Vocabulary.systemDatasourceUri.toString()) {
            			queue = anzo.utils.UriGenerator.getDatasourceQueue(datasourceUri, "query");
            		}
            	}
            	if (options[anzo.client.OPTION_PRIORITY] != null)
            		msg.properties[anzo.client.OPTION_PRIORITY] = options[anzo.client.OPTION_PRIORITY];
            	if (options[anzo.client.OPTION_INCLUDE_METADATA_GRAPHS] != null)
            		msg.properties[anzo.client.OPTION_INCLUDE_METADATA_GRAPHS] = options[anzo.client.OPTION_INCLUDE_METADATA_GRAPHS];
            }
            
            msg.properties[ser.OPERATION] = ser.OP_EXEC_QUERY;
    
            var dgs = anzo.client.Serialization.convertToList(defaultNamedGraphs);
            msg.properties[ser.DEFAULT_GRAPHS] = dgs;
            msg.properties[ser.DEFAULT_GRAPHS_FORMAT] = ser.MIMETYPE_TEXT;
    
            var ngs = anzo.client.Serialization.convertToList(namedGraphs);
            msg.properties[ser.NAMED_GRAPHS] = ngs;
            msg.properties[ser.NAMED_GRAPHS_FORMAT] = ser.MIMETYPE_TEXT;
    
            var nds = anzo.client.Serialization.convertToList(namedDatasets);
            msg.properties[ser.NAMED_DATASETS] = nds;
            msg.properties[ser.NAMED_DATASETS_FORMAT] = ser.MIMETYPE_TEXT;
    
            if (baseUri != null) {
                msg.properties[ser.BASE_URI] =  baseUri.toString();
            }
    
            msg.body = queryString.toString();
    
            var responseCallback = dojo.hitch(this, function(response) {
                try {
                    if (response.error || response.message.properties.operationFailed == "true") {
                        setTimeout(function() { callback(null, false, response); }, 0);
                    } else {
                        var bodyRaw = response.message.body;
                        // The response contains a string denoting the result type (SELECT, ASK, etc.)
                        // followed by a newline, then the results in the appropriate format as requested.
                        if (bodyRaw) {
                            var newlineIndex = bodyRaw.indexOf("\n");
                            if (newlineIndex < 0) {
                                var e = new Error("Invalid query response. Missing query type and newline.");
                                e.response = response;
                                setTimeout(function() { callback(null, false, e); }, 0);
                            } else {
                                var queryType = bodyRaw.slice(0, newlineIndex);
                                var queryResponseData = bodyRaw.length > newlineIndex + 1 ? bodyRaw.slice(newlineIndex + 1) : null;
                                if (log.isDebugEnabled()) {
                                    log.debug("SPARQL Query Response: " + queryResponseData + "\nOriginal Query String:" + queryString);
                                }
                                var resultToCache = undefined;
                                if (queryType == "SELECT" || queryType == "ASK") {
                                    var resultset = dojo.fromJson(queryResponseData);
                                    if (response.message.properties.totalSolutions != null) {
                                        // If the totalSolutions information was returned from the server, then put it in the result set header.
                                        // The totalSolutions property is an optimization where the server will return the total number of matching
                                        // solutions even when the query had a LIMIT/OFFSET since the server knew the total count anyway. This
                                        // is helpful for paging implementations to avoid a second query just to count the total results.
                                        var totalSolutions = parseInt(response.message.properties.totalSolutions);
                                        if (!isNaN(totalSolutions)) {
                                            resultset.head.totalSolutions = totalSolutions;
                                        }
                                    }
                                    if (cacheEnabled) {
                                        resultToCache = resultset;
                                    }
                                    setTimeout(function() { callback(resultset, true, null); }, 0);
                                } else if (queryType == "CONSTRUCT") {
                                    var statements = anzo.client.Serialization.readStatementsFromJsonString(queryResponseData);
                                    var graph = new anzo.rdf.NamedGraph();
                                    graph.add(statements);
                                    if (cacheEnabled) {
                                        var cachedContructGraph = new anzo.rdf.NamedGraph(); // Store a separate graph so that modifications to the one given in the response don't affect the cache.  
                                        cachedContructGraph.add(statements);
                                        resultToCache = cachedContructGraph;
                                    }
                                    setTimeout(function() { callback(graph, true, null); }, 0);
                                } else if (queryType == "CONSTRUCT_QUADS") { 
                                    var statements = anzo.client.Serialization.readStatementsFromJsonString(queryResponseData);
                                    if (cacheEnabled) {
                                        resultToCache = statements;
                                    }
                                    setTimeout(function() { callback(statements, true, null); }, 0);
                                } else if (queryType == "DESCRIBE" || queryType == "DESCRIBE_QUADS") {
                                    setTimeout(function() { callback(null, false, new Error("DESCRIBE queries not supported.")); }, 0);
                                } else {
                                    var e = new Error("Invalid query response. Unknown query type:" + queryType);
                                    e.response = response;
                                    setTimeout(function() { callback(null, false, e); }, 0);
                                }
                                
                                // Cache the result and subscribe to the updates on the query's dataset to make sure that the cache is invalidated when appropriate.
                                if (cacheEnabled && resultToCache) {
                                    if (this._canCacheQuery(cacheKey.query, cacheKey.defaultNamedGraphs, cacheKey.namedGraphs, cacheKey.namedDatasets, datasourceUri)) {
                                        this._cacheQueryResults(cacheKey, resultToCache);
                                    } else {
                                        if (log.isWarnEnabled()) {
                                            log.warn("Cannot cache query results because either a dataset clause was detected in the query ('FROM', 'FROM NAMED', etc.) or one of the URIs in the dataset is a special URI like the allNamedGraphs URI. Caching such queries is not supported. Query:\n" + cacheKey.query);
                                        }
                                    }
                                } else {
                                    log.debug("Not caching entry because either caching is disabled or there are no results to cache. cacheEnabled:" + cacheEnabled + " resultToCache:" + resultToCache);
                                }
                                
                            }
                        }
                    }
                } catch(e) {
                    // Ensure the callback is called even in the case of type errors and the like in the code above.
                    e.response = response;
                    setTimeout(function() { callback(null, false, e); }, 0);
                }
            });
    
            // default to an infinite timeout
            var timeout = null;
            if (options != null) {
            	timeout = options[anzo.client.OPTION_TIMEOUT];
            }
            if (timeout == null) {
                timeout = -1; 
            }    
            anzo.messaging.JMSClient.publish(msg, queue, responseCallback, timeout);
        }
    },
    
    queryBatch : function(queries) {
        // summary: Sends multiple asynchronous SPARQL query requests to the server all at once.
        // queries: Array
        //      An Array of Objects where each object fully specifies all of the parameters for the query.
        //      The parameters are all of those taken by the 'AnzoClient.serverQuery' method (defaultNamedGraphs, namedGraphs, etc.)

        if (!dojo.isArray(queries)) {
            throw new Error("queries parameter must be an array object.");
        }
        var len = queries.length;
        if (len > 0) {
            var exceptions = [];
            anzo.messaging.JMSClient.startBatch();
            try {
                for (var i = 0; i < queries.length; i++) {
                    try {
                        var q = queries[i];
                        if (q) {
                            this.query(q.defaultNamedGraphs, q.namedGraphs, q.namedDatasets, q.query, q.baseUri, q.callback, q.options);
                        }
                    } catch (e) {
                        exceptions.push({index: i, exception: e});
                        log.debug("queryBatch: Error sending query '" + i + "':" + e.message);
                    }
                }
            } finally {
                anzo.messaging.JMSClient.endBatch();
            }

            if (exceptions.length > 0) {
                var msg = "Query errors while sending queries.\n";
                for (var i = 0; i < exceptions.length; i++) {
                    msg += "\tquery #" + exceptions[i].index + " error:" + exceptions[i].exception.message + "\n";
                }
                throw new Error(msg);
            }
        }
    },

    _cacheQueryResults : function(cacheKey, resultToCache) {
        // summary: Save the given query results under the given key. This takes care of subscribing
        //   to dataset trackers to listen for graph changes that will invalidate the cache entry.
        if ((cacheKey.defaultNamedGraphs == null || cacheKey.defaultNamedGraphs.length == 0)
                && (cacheKey.namedGraphs == null || cacheKey.namedGraphs.length == 0)
                && (cacheKey.namedDatasets == null || cacheKey.namedDatasets.length == 0)) {
            if (log.isWarnEnabled()) {
                // We don't cache such queries since there is no way to listen for changes that invalidate the query. 
                log.warn("Cannot cache query results because a no dataset information was given in the defaultNamedGraphs, namedGraphs, and namedDatasets arguments. Caching such queries is not supported. Query:\n" + cacheKey.query);
            }
        } else {
            if (log.isDebugEnabled()) {
                log.debug("Caching query:\n" + dojo.toJson(cacheKey, true));
            }
            this._resultsCache.set(cacheKey, resultToCache, this._onInvalidatedCacheEntryHitched);
            this._subscribeToDataset(cacheKey, { datasetChanged : dojo.hitch(this, function() {
                if(log.isDebugEnabled()) {
                    log.debug("datasetChanged event for cacheKey: " + dojo.toJson(cacheKey, true));
                }
                if (this._resultsCache) {
                    this._resultsCache.remove(cacheKey);
                }
            })});
        }
    },
    
    _queryCacheKeyHash : function _queryCacheKeyHash(key) {
        // summary: Hash function used to hash the queries. We trade-off efficiency here for
        //   uniqueness. We'll base the hash key solely on the query string. That is fairly unique
        //   for applications where the same query isn't applied to different datasets. It allows
        //   us to avoid having to inspect all of the URIs in the dataset for calculating the hash.
        return key.query;
    },

    _queryCacheKeyEqual : function _queryCacheKeyEqual(a, b) {
        // summary: compare strick equality of the two query cache keys. We have to inspect
        //   every URI in the dataset as well as the query strings. Equality on URIs is done via
        //   strict string comparison. That is, no interpretation of URI espace sequences or encodings is done.

        var retval = false;
        // We compare the sizes of the dataset components as a first check since it's
        // very efficient and may yield an answer without having to do more expensive comparisons.
        if (this._arrayLengthEquals(a.defaultNamedGraphs, b.defaultNamedGraphs)
                && this._arrayLengthEquals(a.namedGraphs, b.namedGraphs)
                && this._arrayLengthEquals(a.namedDatasets, b.namedDatasets)
                && a.baseUri == b.baseUri
                && a.query == b.query) {

            // Since the dataset component arrays are of equal size and the baseUri and query strings
            // are equal, then we must compare the contents of the dataset component arrays.
            // We assume that the arrays are sorted already.
            if (this._sortedArrayEquals(a.defaultNamedGraphs, b.defaultNamedGraphs)
                    && this._sortedArrayEquals(a.namedGraphs, b.namedGraphs)
                    && this._sortedArrayEquals(a.namedDatasets, b.namedDatasets)) {
                retval = true;
            }
        }
        return retval;
    },

    _sortedArrayEquals : function _sortedArrayEquals(a, b) {
        // summary: Compare the elements of two arrays for equality in order. Assumes that
        //   the given arrays have the same size. Arrays may be null or undefined in which case
        //   they are considered to have length 0.
        var retval = true;
        if (a) {
            var len = a.length;
            for (var i = 0; i < len; i++) {
                if (a[i] != b[i]) {
                    retval = false;
                    break;
                }
            }
        }
        return retval;
    },

    _arrayLengthEquals : function _arrayLengthEquals(a, b) {
        // summary: Compare the lengths of two arrays accounting for either or both of
        //   the arrays being null or undefined. Such arrays are considered to be zero length.
        return (a && b && a.length == b.length) || (!a && (!b || b.length == 0)) || (!b && a.length == 0);
    },

    _uriComparator : function _uriComparator(a, b) {
        // summary: used to sort URIs where there could be anzo.rdf.URI objects or basic strings intermingled.
        if (a.toString() < b.toString()) {
            return -1;
        } else if (a.toString() > b.toString()) {
            return 1;
        }
        return 0;
    },
    
    _setupDatasetClauseRexExp : function() {
        // summary: Prepare the regular expression used to check if queries contain dataset clauses.
        
        // This was the start of a more correct regular expression to catch dataset clauses
        // taking into account SPARQL comments (ignoring 'FROM' keyword in comments, etc.).
        // but it hasn't worked. It's here simply for posterity in case someone wants to revive it.
        //var ws = "[ \\t\\r\\n]"; // SPARQL's whitespace characters
        //var wsc = "(?:" + ws + "*(?:#.*?\\r|\\n)*)*"; // match optional whitespace characters and optional comments
        //var IRI_REF = "<[^<>\"\\\\{}|^`\\u0000-\\u0020]*>";
        //var PN_CHARS_BASE = "[A-Za-z\\u00C0-\\u00D6\\u00D8-\\u00F6\\u00F8-\\u02FF\\u0370-\\u037D\\u037F-\\u1FFF\\u200C-\\u200D\\u2070-\\u218F\\u2C00-\\u2FEF\\u3001-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFFD]"; // NOTE: missing characters #x10000-#xEFFFF due to JavaScript not supporting 4-byte unicode escape sequences
        //var PN_CHARS = PN_CHARS_BASE + "|[_\\-0-9\\u00B7\\u0300-\\u036F\\u203F-\\u2040]";
        //var PN_SECONDARY = "(?:(?:" + PN_CHARS + "|\\.)*" + PN_CHARS + ")?";
        //var PN_PREFIX = PN_CHARS_BASE + PN_SECONDARY;
        //var PNAME_NS = "(?:" + PN_PREFIX + ")?:";
        //var PN_LOCAL = "(?:" + PN_CHARS_BASE + "|[_0-9])" + PN_SECONDARY;
        //var PNAME_LN = PNAME_NS + PN_LOCAL;
        //var PrefixedName = "(" + PNAME_LN + ")|(" + PNAME_NS + ")";
        //var IRIref =  "(?:" + IRI_REF + ")|(?:" + ws + "+" + PrefixedName + ")";
        //var precedingDatasetClause = "[ \\t\\r\\n*}>]"; // This patten must precede a dataset clause according to the SPARQL spec

        // A simple regular expression based on testing the allowed characters immediately preceding
        // and immediately following the SPARQL 'FROM' keyword as per the SPARQL spec.
        this._datasetClauseRegExp = /[* \t\r\n}>]FROM[ \t\r\n<:#]/i
    },

    _canCacheQuery : function(query, defaultNamedGraphs, namedGraphs, namedDatasets, datasourceUri) {
        var canCacheQuery = datasourceUri == null || datasourceUri.toString() == anzo.client.Vocabulary.systemDatasourceUri.toString();
        if (canCacheQuery) {
            canCacheQuery = !this._containsNonCacheableGraphUri(defaultNamedGraphs) && !this._containsNonCacheableGraphUri(namedGraphs) && !this._containsNonCacheableGraphUri(namedDatasets);
        }
        if (canCacheQuery) {
            canCacheQuery = !this._containsQueryDatasetClause(query);
        }
        return canCacheQuery;
    },
    
    _containsNonCacheableGraphUri : function(graphUris) {
        var ret = false;
        if (graphUris) {
            if (dojo.isArray(graphUris)) {
                for (var i = 0; i < graphUris.length; i++) {
                    if (this._isNonCachableGraphUri(graphUris[i])) {
                        ret = true;
                        break;
                    }                    
                }
            } else {
                ret = this._isNonCachableGraphUri(graphUris);
            }
        }
        return ret;
    },
    
    _isNonCachableGraphUri : function(uri) {
        var voc = anzo.client.Vocabulary;
        var str = uri.toString();
        return (str == voc.allNamedGraphsUri.toString() || str == voc.allMetadataGraphsUri.toString() || str == voc.allGraphsUri.toString() || str == voc.graphsDataset.toString() || str == voc.metadataGraphsDataset.toString());
    },
    
   _containsQueryDatasetClause : function(query) {
        // summary: Parse the query string to find dataset clauses in the query.
        // description:  Note that this isn't a full-proof parser and may erroneously mark some query strings
        //   as having dataset clauses that do not have them. Parsing is done via regular expressions and may be thrown off
        //   things like prefixes, URIs, comments that have the phrases 'FROM' or 'FROM NAMED' in them.
        // query: String. The query string to parse
        // returns: Boolean. 'true' if the query string contains a dataset clause. 'false' otherwise.
        var match = this._datasetClauseRegExp.exec(query);
        return match != null;
    },
    
    _subscribeToDataset : function(cacheKey, listener) {
        // summary: Registers a tracker to listen for changes to any of the defaultGraphs, namedGraphs, namedDatasets, etc.
        //   involved in this query. It will make sure we aren't already listening to the same combination of graphs with an existing
        //   tracker. If we are, it just reuses that same tracker.
        // cacheKey: A query cache key collects the information to uniquely identify a query in an
        //   object with the following properties:
        //     query: the query string
        //     defaultNamedGraphs: sorted list of default graph URIs
        //     namedGraphs: sorted list of named graphs
        //     namedDatasets: sorted list of named datasets
        //     baseUri: the query's base URI (as a string, not an anzo.rdf.URI object)
        // listener: Object
        //   The listener passed to the RealtimeUpdateManager.addDatasetTracker method. It will be called when the dataset changes.

        if (!cacheKey) {
            throw new Error("_subscribeToDataset - cacheKey argument is required")
        }        
        if (!listener) {
            throw new Error("_subscribeToDataset - listener argument is required")
        }
        
        var key = this._buildDatasetKey(cacheKey.defaultNamedGraphs, cacheKey.namedGraphs, cacheKey.namedDatasets);
        var tracker = this._activeTrackers[key];
        if (tracker) {
            tracker.references++;
            if (log.isDebugEnabled()) {
                log.debug("Using existing datasetTracker (refcount: " + tracker.references + "):" + tracker.uri);
            }
        } else {
            var trackerUri = anzo.utils.UriGenerator.generateUri("http://openanzo.org/queryCache/tracker/");
            tracker = { uri: trackerUri, references: 1 };
            this._activeTrackers[key] = tracker;
            if (log.isDebugEnabled()) {
                log.debug("Creating new datasetTracker:" + tracker.uri);
            }
        }
        this._realtimeUpdateManager.addDatasetTracker(tracker.uri, cacheKey.defaultNamedGraphs, cacheKey.namedGraphs, cacheKey.namedDatasets, listener);
    },
    
    _onInvalidatedCacheEntry : function(cacheKey) {
        // summary: Called when a query cache entry is removed from the cache, including explicit removal or it
        //   falling out of the cache due to lack of space. It handles unregistering any dataset trackers associated with that query.
        // cacheKey: A query cache key collects the information to uniquely identify a query in an
        //   object with the following properties:
        //     query: the query string
        //     defaultNamedGraphs: sorted list of default graph URIs
        //     namedGraphs: sorted list of named graphs
        //     namedDatasets: sorted list of named datasets
        //     baseUri: the query's base URI (as a string, not an anzo.rdf.URI object)
        if(log.isDebugEnabled()) {
            log.debug("_onInvalidatedCacheEntry - removing dataset tracker for cacheKey:" + dojo.toJson(cacheKey, true));
        }
        var datasetKey = this._buildDatasetKey(cacheKey.defaultNamedGraphs, cacheKey.namedGraphs, cacheKey.namedDatasets);
        var tracker = this._activeTrackers[datasetKey];
        if (tracker) {
            tracker.references--;
            if (tracker.references == 0) {
                if (log.isDebugEnabled()) {
                    log.debug("_onInvalidatedCacheEntry - tracker reference count is zero: " + tracker.uri);
                }
                delete this._activeTrackers[datasetKey];
                this._realtimeUpdateManager.removeDatasetTracker(tracker.uri, function _removeDatasetTrackerCallback(success, error) {
                	if(log.isDebugEnabled()) {
                		log.debug("_removeDatasetTrackerCallback - Done removing dataset tracker: " + tracker.uri);
                	}
                });
            }
        }
    },
    
    _buildDatasetKey : function(defaultNamedGraphs, namedGraphs, namedDatasets) {
        // summary: Builds a key out of the given dataset components. It assumes the arguments
        //   are sorted arrays.
        var keyBuilder = [ "dg:", null, ">ng:", null, ">nd:", null, ">" ];
        keyBuilder[1] = this._concatenateUris(defaultNamedGraphs);
        keyBuilder[3] = this._concatenateUris(namedGraphs);
        keyBuilder[5] = this._concatenateUris(namedDatasets);
        return keyBuilder.join("");
    },
    
    _concatenateUris : function(uris) {
        // summary: concatenates an array of URIs. They are wrapped in '<' and '>' symbols.
        var str = "<";
        if (uris && uris.length > 0) {
            str += uris.join("><");
        }
        return str;
    }
});

})();
