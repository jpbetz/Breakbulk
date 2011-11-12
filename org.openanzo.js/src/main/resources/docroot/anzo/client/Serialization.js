dojo.provide("anzo.client.Serialization");

dojo.require("anzo.rdf.Statement");

anzo.client.Serialization = {
    // summary: Methods and constants used to serialize objects to send as requests to the anzo server.
    
    MIMETYPE_JSON                 : "application/json",
    MIMETYPE_TEXT                 : "text/plain",
    MIMETYPE_CSV             	  : "text/csv",
    OPERATION					  : "operation",
    PRECONDITIONS                 : "preconditions",
    QUERY                         : "query",
    BASE_URI                      : "baseURI",
    QUERY_STRING       	 		  : "queryString",
    ASK_QUERY_RESULT    		  : "askQueryResult",
    DEFAULT_GRAPHS                : "defaultNamedGraphs",
    DEFAULT_GRAPHS_FORMAT         : "defaultNamedGraphsFormat",
    NAMED_GRAPHS                  : "namedGraphs",
    NAMED_GRAPHS_FORMAT           : "namedGraphsFormat",
    NAMED_GRAPH_URI               : "namedGraphUri",
    NAMED_GRAPH_URI_FORMAT        : "namedGraphUriFormat",
    NAMED_DATASETS                : "namedDatasets",
    NAMED_DATASETS_FORMAT         : "namedDatasetsFormat",
    SUBJECT                       : "subject",
    SUBJECT_TYPE                  : "subjectType",
    PREDICATE           		  : "predicate",
    OBJECT              		  : "object",
    OBJECT_TYPE					  : "objectType",
    URI                           : "uri",
    VALUE                         : "value",
    LITERAL                       : "literal",
    DATATYPE                      : "dataType",
    LANGUAGE                      : "language",
    BNODE                         : "bnode",
    ADDITION            		  : "Addition",
    DELETION            		  : "Deletion",
    COMMAND                       : "Command",
    RETURN_RESULTS                : "returnResults",
    MARKER                        : "marker",
    TRACKERS                      : "trackers",
    TRACKERS_FORMAT               : "trackersFormat",
    NEW_TRACKERS                  : "newTrackers",
    NEW_TRACKERS_FORMAT           : "newTrackersFormat",
    DATASET_TRACKERS              : "datasettrackers",
    DATASET_TRACKERS_FORMAT       : "datasettrackersFormat",
    TRANSACTION_COMPLETE          : "transactionComplete",
    OPERATION_URI				  : "operationUri",
    UPDATE_RESULTS                : "UpdateResults",
    DATASET_UPDATE                : "DatasetUpdate",
    DATASET_URI                   : "datasetUri",
    METHOD                        : "method",
    RESPONSE_FORMAT               : "resultFormat",
    TRANSACTIONS_FORMAT           : "transactionsFormat",
    STATEMENTS_FORMAT             : "statementsFormat",
    TRANSACTION_URI			      : "transactionURI",
    TRANSACTION_CONTEXT           : "transactionContext",
    TRANSACTION_TIMESTAMP         : "timestamp",
    TRANSACTION_NAMEDGRAPHUPDATES : "namedGraphUpdates",
    REVISION                      : "revision",
    ADDITIONS					  : "additions",
    REMOVALS                      : "removals",
    META_ADDITIONS                : "metaAdditions",
    META_REMOVALS                 : "metaRemovals",
    UPDATE_TYPE_STATEMENT         : "Statement",
    UPDATE_VALUE_TYPE_LITERAL     : "LITERAL",
    UPDATE_VALUE_TYPE_BNODE       : "BNODE",
    UPDATE_VALUE_TYPE_URI         : "URI",
    UPDATE_METHOD_ADDITION        : "true",
    UPDATE_METHOD_REMOVAL         : "false",
    PRIVILEGE					  : "privilege",
    
    OP_UPDATE_SERVER              : "update",
    OP_REPLICATE                  : "replicate",
    OP_EXEC_QUERY                 : "query",
    OP_RESET                      : "reset",
    OP_REGISTER_TRACKER           : "registerTrackers",
    OP_UNREGISTER_TRACKER         : "unregisterTrackers",
    OP_REGISTER_SUBSCRIBER        : "registerSubscriber",
    OP_UNREGISTER_SUBSCRIBER      : "unregisterSubscriber",
    OP_GET_NAMED_GRAPH_REVISON    : "getNamedGraphRevision",
    OP_FIND_STATEMENTS            : "findStatements",
    OP_EXECUTE_SERVICE			  : "executeService",
    OP_CONTAINS_NAMED_GRAPH		  : "containsNamedGraph",
    OP_GET_ROLES_FOR_GRAPH		  : "getRolesForGraph",


    writeTransactionsToJson : function(transactions) {
        
        // summary: Serializes the given transactions into json.
        
        // transactions: anzo.client.Transaction[]
        //   Array of transactions that is serialized into json.
        
        // returns: Array
        //  Json array that containes the serialized data for the given transactions.
        
        
        var tranArray = new Array(transactions.length);
        
        for (var i=0;i<transactions.length;i++) {
            var tran = {};
            tranArray[i] = tran;
            
            tran[this.TRANSACTION_URI] = transactions[i].transactionUri.toString();
            
            if (transactions[i].contextQuadStore) {
                var contextStatements = transactions[i].contextQuadStore.find();
                tran[this.TRANSACTION_CONTEXT] = this.writeStatementsToJson(contextStatements);
            }
            
            var precons = [];
            tran[this.PRECONDITIONS] = precons;
            
            var adds = [];
            var dels = [];
            
            var ser = anzo.client.Serialization;
            var transactionWalk = function(transaction) {
                var preconditions = transaction.preconditions;
                if (preconditions) {
                    for (var j=0;j<preconditions.length;j++) {
                        var precon = {};
                        var nguris = [];
                        for (var k=0;k<preconditions[j].namedGraphUris.length;k++) {
                            nguris.push(preconditions[j].namedGraphUris[k].toString());
                        }
                        precon[ser.NAMED_GRAPHS] = nguris;
                        var dguris = [];
                        for (var k=0;k<preconditions[j].defaultGraphUris.length;k++) {
                            dguris.push(preconditions[j].defaultGraphUris[k].toString());
                        }
                        precon[ser.DEFAULT_GRAPHS] = dguris;
                        var query = {};
                        query[ser.QUERY_STRING] = preconditions[j].askQueryString;
                        query[ser.ASK_QUERY_RESULT] = preconditions[j].askResult;
                        precon[ser.QUERY] = query;
                        precons.push(precon);
                    }
                }
                
                
                var additions = transaction.additions.find();
                for (var j=0;j<additions.length;j++) {
                    anzo.utils.addToArray(additions[j],adds);
                }
                var deletions = transaction.deletions.find();
                for (var j=0;j<deletions.length;j++) {
                    anzo.utils.addToArray(deletions[j],dels);
                }
            }
            transactions[i].walkTransactionTree(transactionWalk);
            
            // sort the statements by graph
            
            var namedGraphUpdates = {};
    
            this._groupByGraphUri(adds, namedGraphUpdates, true);		
            this._groupByGraphUri(dels, namedGraphUpdates, false);		
            
            for (var uri in namedGraphUpdates) {
                var update = namedGraphUpdates[uri];
                update[this.ADDITIONS] = this.writeStatementsToJson(update[this.ADDITIONS]);
                update[this.REMOVALS] = this.writeStatementsToJson(update[this.REMOVALS]);
                update[this.META_ADDITIONS] = this.writeStatementsToJson(update[this.META_ADDITIONS]);
                update[this.META_REMOVALS] = this.writeStatementsToJson(update[this.META_REMOVALS]);
            }
            
            var updateArray = [];
            for (var uri in namedGraphUpdates) {
                updateArray.push(namedGraphUpdates[uri]);
            }
            
            tran[this.NAMED_GRAPHS] = updateArray;
            
        }
        return tranArray;
    },
    
    _groupByGraphUri : function _groupByGraphUri(statements, namedGraphUpdates, additionsOrRemovals) {
        // summary: Traverse the given statements array, grouping the statements by namedGraphUri
        //   into the given namedGraphUpdates map. The values in the map are the start of a serialized form
        //   for sending the updates to the server.
        // additionsOrRemovals: Boolean. true denotes that these statements are additions, false denotes that they are removals.
        var metaUpdateType = null;
        var updateType = null;
        for (var i=0; i < statements.length; i++) {
            var meta = false;
            var uri = statements[i].namedGraphUri.toString();
            if (uri.indexOf(anzo.client.Vocabulary.METADATAGRAPH_PREFIX) == 0) {
                meta = true;
                uri = anzo.utils.UriGenerator.getNamedGraphUri(uri);
            }
            
            var update = namedGraphUpdates[uri];
            if (!update) {
                update = {};
                namedGraphUpdates[uri] = update;
                update[this.NAMED_GRAPH_URI] = uri;
                update[this.REVISION] = 0;
                update[this.ADDITIONS] = [];
                update[this.REMOVALS] = [];
                update[this.META_ADDITIONS] = [];
                update[this.META_REMOVALS] = [];
            }
            if (meta) {
                update[additionsOrRemovals ? this.META_ADDITIONS : this.META_REMOVALS].push(statements[i]);
            } else {
                update[additionsOrRemovals ? this.ADDITIONS : this.REMOVALS].push(statements[i]);
            }
        }
    },
    
    writeStatementsToJson : function(statements) {
        
        // summary: Serializes the given statements into json.
        
        // statements: anzo.rdf.Statement[]
        //  Array of statements that is serialized.
        
        // returns: Array of serialized statements.
        
        var stmts = new Array(statements.length);
        for (var i=0;i<statements.length;i++) {
            var stmt = {};
            if (statements[i].namedGraphUri) {
                stmt[this.NAMED_GRAPH_URI] = statements[i].namedGraphUri.toString();
            }
            
            var subject = {};
            stmt[this.SUBJECT] = subject;
            var subjectValue = statements[i].subject;
            
            if (subjectValue instanceof anzo.rdf.URI) {
                subject[this.OBJECT_TYPE] = this.URI;
                subject[this.VALUE] = subjectValue.toString();
            } else {
                subject[this.OBJECT_TYPE] = this.BNODE;
                subject[this.VALUE] = subjectValue.toString();
            }
            
            stmt[this.PREDICATE] = statements[i].predicate.toString();
            var value = statements[i].object;
            var object = {};
            if (value instanceof anzo.rdf.URI) {
                object[this.OBJECT_TYPE] = this.URI;
                object[this.VALUE] = value.toString();
            } else if (value instanceof anzo.rdf.Literal) {
                object[this.OBJECT_TYPE] = this.LITERAL;
                if (value.language) {
                    object[this.LANGUAGE] = value.language.toString();
                }
                if (value.datatype) {
                    object[this.DATATYPE] = value.datatype.toString();
                }
                object[this.VALUE] = value.toString();
            } else { //bnode
                object[this.OBJECT_TYPE] = this.BNODE;
                object[this.VALUE] = value.toString();
            }
            stmt[this.OBJECT] = object;
            stmts[i] = stmt;
        }
        return stmts;
    },
    
    readStatementsFromJsonString : function readStatementsFromJsonString(stmtsString) {
        var stmts = dojo.fromJson(stmtsString);
        return anzo.client.Serialization.readStatementsFromJson(stmts);
    },
    
    readStatementsFromJson : function readStatementsFromJson(stmts) {
        
        var statements = [];
        if(stmts!=null){
	        for (var i=0;i<stmts.length;i++) {
	            
	            var sub = stmts[i][this.SUBJECT];
	            if (sub[this.OBJECT_TYPE] == this.URI) {
	                var subject = anzo.createURI(sub[this.VALUE]);
	            } else {
	                var subject = anzo.createBNode(sub[this.VALUE]);
	            }
	            var predicate = anzo.createURI(stmts[i][this.PREDICATE]);
	            
	            var obj = stmts[i][this.OBJECT];
	            if (obj[this.OBJECT_TYPE] == this.URI) {
	                var object = anzo.createURI(obj[this.VALUE]);
	            } else if (obj[this.OBJECT_TYPE] == this.BNODE) {
	                var object = anzo.createBNode(obj[this.VALUE]);
	            } else { // literal
	                if (obj[this.DATATYPE]) {
	                    var object = anzo.createTypedLiteral(obj[this.VALUE], obj[this.DATATYPE]);
	                } else {
	                    var object = anzo.createLiteral(obj[this.VALUE], obj[this.LANGUAGE]);
	                }
	            }
	            
	            var namedGraphUri = undefined;
	            if (stmts[i][this.NAMED_GRAPH_URI]) {
	                namedGraphUri = anzo.createURI(stmts[i][this.NAMED_GRAPH_URI]);
	            }
	            
	            statements.push(anzo.createStatement(subject, predicate, object, namedGraphUri));
	        }
        }
        return statements;
    },
    
    TEXT_DELIM : "\n",
    
    convertToList : function(collection) {
        
        // summary: Serializes the given list into newline ('\n') delimited text.
        
        // collection: Array
        //  The array that is serialized into a list.
        
        // returns: String
        //  A string representing the serialized list for the given array.
        
        var result = '';
        var delimiter = this.TEXT_DELIM;
        
        if (collection != null) {
            for(var i = 0; i < collection.length; i++) {
                result += collection[i];
                if(i + 1 < collection.length) {
                    result += delimiter;
                }
            }
        }
        return result;
    },
    
    readNamedGraphRevisions : function readNamedGraphRevisions(revisions) {
        // summary: Parses a string containing URI and revision pairs.
        // description: The format of the string espected delimitis the URI from the revision with a '=' character and
        //   delimits the pairs with commas. For example:
        //   | http://example.org/firstGraph=3,http://example.org/anotherGraph=2
        // revisions: a string to parse.
        // returns: Object. a map from the URI to the revision number.
        var revs = {};
        var pairs = revisions.split(",");
        if (pairs.length <= 0) {
            return null;
        }
        for (var i=0;i<pairs.length;i++) {
            var pair = pairs[i].split("=");
            if (pair[0] != "") {
                revs[pair[0]] = pair[1];
            }
        }
        return revs;
    },
    
    readUriSet : function(csv) {
    	var str = csv.split("\n");
    	var uris = [];
    	for (var i=0;i<str.length;i++) {
    		uris.push(anzo.createURI(str[i]));
    	}
    	return uris;
    }
    
}
