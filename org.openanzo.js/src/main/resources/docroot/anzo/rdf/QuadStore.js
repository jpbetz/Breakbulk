/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * Created on:  Oct 10, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.rdf.QuadStore");

dojo.require('anzo.rdf.Statement');

dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.rdf.BaseQuadStore");

dojo.declare('anzo.rdf.QuadStore', anzo.rdf.BaseQuadStore, {
	
	// summary:
	//    An in-memory storage of statements. Each statement must specify their subject, predicate, object and namedGraphUri (thereby making them quads). 
	//    This store maintains indexes to allow fast lookup when calling the find method.
	//
    //    The following hashes are maintained by the quad store:
    //    
    //        * contextMap: Hash of namedGraphUris to statements
    //        * subjMap: Hash of subjects to statements
    //        * propMap: Hash of predicates to statements
    //        * objMap: Hash of objects to statements
    //        * poMap: Hash of predicates to hashes of objects to sets of statements (var hash1=poMap[p()]; var stmts=hash1[o()];)
    //        * psMap: Hash of predicates to hashes of subjects to sets of statements (var hash1=psMap[p()]; var stmts=hash1[s()];) 
    //    
    //    A set of all statements is also kept.
    //    
    //    Note that hashes must be performed on the values of the nodes rather then the objects since there is no guarantee that the objects stored in the statements are the same objects the user will use to call the find method. A way to do this is to have a hashCode method that returns a hash value based on the value of the node. Therefore, if any two nodes have the same values they will also have the same hash codes.
    //    
    //    Each time a statement is added to the store, it is added to the set of statements as well as to all the hashes (indexes). When a statement is removed, it is removed from everything.
    //    
    //    When the user calls
    //    find(...)
    //    here is what happens:
    //    
    //    if all parameters are null
    //    	return the set of all statements
    //    if only one of the values is specified, return the statements its hash returns
    //    	(i.e. if s was specified, return subjMap[s()])
    //            (i.e. if cArray was specified, iterate through the array and add contextMap[c[n]] to a running set and return that set)
    //    if s and p are specified, cArray is optional
    //            1. get the subject to statements hash by calling (var hash1 = psMap[p()])
    //            2. get the statements the given subject hashes to in that hash (var stmts = hash1[s()]);
    //            3. if cArray is not null and not empty, filter the list of stmts by the cArray
    //            4. return the filtered stmts array
    //    if p and o are specified, cArray is optional
    //            1. get the object to statements hash by calling (var hash1 = poMap[p()])
    //            2. get the statements the given object hashes to in that hash (var stmts = hash1[o()])
    //            3. if cArray is not null and not empty, filter the list of stmts by the cArray
    //            4. return teh filtered stmts array
    //    if s, p, o  are specified
    //            1. get the three sets of statements each hashes to
    //            2. pick the smallest set of the three and iterate through it filtering out all statements that don't match the pattern
    //            3. return the matching set
    //    if s and cArray are specified
    //            1. get statements hashed to by the subject (subjMap[s()])
    //            2. get statements hashed to by the names in the cArray (contextMap[cArray[i]])
    //            3. loop through the smallest set and filter on the given pattern
    //            4. return the filtered statements
    //    if p and cArray are specified
    //            1. get statements hashed to by the predicate (propMap[p()])
    //            2. get statements hashed to by the names in the cArray (contextMap[cArray[i]])
    //            3. loop through the smallest set and filter on the given pattern
    //            4. return the filtered statements
    //    if o and cArray are specified
    //            1. get statements hashed to by the object(objectMap[o()])
    //            2. get statements hashed to by the names in the cArray (contextMap[cArray[i]])
    //            3. loop through the smallest set and filter on the given pattern
    //            4. return the filtered statements
    //    if s, o and cArray are specified
    //            1. get statements hashed to by the subject (sMap[s()])
    //            2. get statements hashed to by the object (objectMap[o()])
    //            3. get statements hashed to by the names in the cArray (contextMap[cArray[i]])
    //            4. pick the smallest set and filter it on the given pattern
    //            5. return the filtered statements
    //    if s, p, o, cArray are defined
    //            1. create statements matching those patterns
    //            2. call contains on the statements set for each of those statements
    //            3. add each statement that returns true when calling the contains method to a set
    //            4. return the set
    //    
    //    in all cases where the given pattern contains more then one specified variable 
    //            if a single hash returns either null or an empty set, return an empty set
    //    
	
	
	// statements : anzo.utilities.Set
	//  Set of all statements in store
	statements : null,

    // contextMap : Object
	//  Index map of namedGraphUris to statements
	contextMap : null,

    // subjMap : Object
	//  Index map of subjects to statements
	subjMap : null,

    // propMap : Object
	//  Index map of properties to statements
	propMap : null,

    // objMap : Object
	//  Index map of object to statements
	objMap : null,

    // poMap : Object
	//  Hash of predicates to hashes of objects to sets of statements   (var hash1 = poMap[p()]; var stmtList = hash1[o()];)
	poMap : null,

    // psMap : Object
	//  Hash of predicates to hashes of subjects to sets of statements  (var hash1 = psMap[p()]; var stmtList = hash1[s()];)
	psMap : null,
	
	// storeNativeStatements : Boolean
	//  Specifies if the quad store should store native statements or instead convert them to lighter statements and then back when requested.  Storing native statements makes the quad store a lot faster since no conversions are needed, but takes up more memory.
	storeNativeStatements : true,
	
	keyCount : 0,

	/**
	 * Initialize quadstore's statement set and indexes
	 */
	constructor : function () {
	    
	    // summary: Initializes the indexes used to do fast lookup when the find method is called.
		
		this.statements        = {};
		this.statements.length = 0;
		this.statements.isSet  = true;
		this.subjMap           = {};
		this.propMap           = {};
		this.objMap            = {};
		this.contextMap        = {};
		this.poMap             = {};
		this.psMap             = {};
		
        this.valToNodeID       = {};
		this.nodeIDToVal       = {};
		this.nodeIDToRefCount  = {};
	},
	
	_incrementStmtRefCount : function(lightStmt) {
	    this._incrementRefCount(lightStmt.s);
	    this._incrementRefCount(lightStmt.p);
	    this._incrementRefCount(lightStmt.o);
	    this._incrementRefCount(lightStmt.c);
	},
	
	_decrementStmtRefCount : function(lightStmt) {
	    this._decrementRefCount(lightStmt.s);
	    this._decrementRefCount(lightStmt.p);
	    this._decrementRefCount(lightStmt.o);
	    this._decrementRefCount(lightStmt.c);
	},
	
	_incrementRefCount : function(key) {
	    if(this.nodeIDToRefCount[key] == null)
	       this.nodeIDToRefCount[key] = 0;
	    this.nodeIDToRefCount[key]++; 
	},
	
	_decrementRefCount : function(key) {
	    if(this.nodeIDToRefCount[key] == null)
	       this.nodeIDToRefCount[key] = 0;
	    this.nodeIDToRefCount[key]--; 
	    if(this.nodeIDToRefCount[key] <= 0) {
	        var val = this.nodeIDToVal[key];
	        delete this.nodeIDToVal[key];
	        delete this.nodeIDToRefCount[key];
	        delete this.valToNodeID[val.dictionaryKey()];  // hash key to val key
	    }
	},

	_getLightStmt : function(/* anzo.rdf.Statement */stmt, create) {
	    var sKey = stmt.subject.dictionaryKey();
	    var pKey = stmt.predicate.dictionaryKey();
	    var oKey = stmt.object.dictionaryKey();
	    var cKey = stmt.namedGraphUri.dictionaryKey();
	    
	    var sID = this.valToNodeID[sKey];
	    if(sID == null && create) {
	        sID = this.keyCount++; 
	        this.valToNodeID[sKey] = sID;
	        this.nodeIDToVal[sID] = stmt.subject; 
	    }
	    
	    var pID = this.valToNodeID[pKey];
	    if(pID == null && create) {
	        pID = this.keyCount++; 
	        this.valToNodeID[pKey] = pID;
	        this.nodeIDToVal[pID] = stmt.predicate; 
	    }
	    
	    var oID = this.valToNodeID[oKey];
	    if(oID == null && create) {
	        oID = this.keyCount++; 
	        this.valToNodeID[oKey] = oID;
	        this.nodeIDToVal[oID] = stmt.object; 
	    }
	    
	    var cID = this.valToNodeID[cKey];
	    if(cID == null && create) {
	        cID = this.keyCount++;  
	        this.valToNodeID[cKey] = cID;
	        this.nodeIDToVal[cID] = stmt.namedGraphUri;
	    }

        var obj = {
	        s : sID,
	        p : pID,
	        o : oID,
	        c : cID
	    }
        if(this.storeNativeStatements)
        	obj.stmt = stmt;
        return obj;
	},
	
	_normalizeFindResults : function(lightStmts, convert) {
	    var _this = this;
	    
	    var stmts = [];
	    if(lightStmts instanceof anzo.utils.Set && !lightStmts.isEmpty()) {
	        if(!convert)
	           return lightStmts.toArray();
	        lightStmts.forEach(function(lStmt) {
	            lStmt.stmt ? stmts.push(lStmt.stmt) : stmts.push(anzo.createStatement(_this.nodeIDToVal[lStmt.s], _this.nodeIDToVal[lStmt.p], _this.nodeIDToVal[lStmt.o], _this.nodeIDToVal[lStmt.c]));
	        });
	    } else if(lightStmts.isSet) {
    	    for(var key in lightStmts) {
    	        if(key == 'length' || key == 'isSet')
    	           continue;
    	        var lStmt = lightStmts[key];
    	        if(!convert) {
    	            stmts.push(lStmt);
    	        } else {
                    lStmt.stmt ? stmts.push(lStmt.stmt) : stmts.push(anzo.createStatement(_this.nodeIDToVal[lStmt.s], _this.nodeIDToVal[lStmt.p], _this.nodeIDToVal[lStmt.o], _this.nodeIDToVal[lStmt.c]));
    	        }
    	    }
	    } else if(dojo.isArray(lightStmts)) {
	        if(!convert)
	           return lightStmts;
	        for(var i = 0; i < lightStmts.length; i++) {
	            var lStmt = lightStmts[i];
	            lStmt.stmt ? stmts.push(lStmt.stmt) : stmts.push(anzo.createStatement(_this.nodeIDToVal[lStmt.s], _this.nodeIDToVal[lStmt.p], _this.nodeIDToVal[lStmt.o], _this.nodeIDToVal[lStmt.c]));
	        }
	    }
    
	    return stmts;
	},

   	_addStatements : function (/*Array*/ statements) {
   	   
	    // summary: Adds the given array of statements to this store and index them.
        // statement : anzo.rdf.Statement[]
        //  Array of quads (statements with subject, predicate, object and namedGraphUri) that are added to this quad store.
		for (var i = 0; i < statements.length; i++) {
		    var stmt = statements[i];
			if (stmt.namedGraphUri == null)
			    throw Error('Given statement is not a quad, is missing the named graph URI.');
			var ls = this._getLightStmt(stmt, true);
            this._addLightStatement(ls);
		}
	},
	
	_getLightStmtKey : function(lightStmt) {
	    if(!lightStmt.key)
	       lightStmt.key = lightStmt.s+':'+lightStmt.p+':'+lightStmt.o+':'+lightStmt.c;
	    return lightStmt.key;
	},
	
	_addLightStatement : function(lightStmt) {
	    var stmtKey = this._getLightStmtKey(lightStmt);
	    if(this.statements[stmtKey] == null) {
	        this.statements[stmtKey] = lightStmt;  // <-----  *
	        this.statements.length++;
	        this._addMaps(lightStmt, stmtKey);
	        this._incrementStmtRefCount(lightStmt);
	    }
	},
	
	_removeStatements : function(/*Array*/ statements) {
	    // summary: Removes the given array of statements from this store and removes indexes.
        // statement : anzo.rdf.Statement[]
        //  Array of quads (statements with subject, predicate, object and namedGraphUri) that are removed from this quad store.
		for (var i = 0; i < statements.length; i++) {
		    var stmt = statements[i];
			if (stmt.namedGraphUri == null) {
				throw new Error(ExceptionConstants.CLIENT.CODES.CORE_ERROR, ExceptionConstants.CLIENT.SUBCODES.URI_NOT_NULL);
			}
			
			var ls = this._getLightStmt(stmt, false);
			if(ls == null || ls.s == null || ls.p == null || ls.o == null || ls.c == null)
			    continue;
			this._removeLightStatement(ls);
		}
	},
	
	_removeLightStatement : function(lightStmt) {
	   var stmtKey = this._getLightStmtKey(lightStmt);
	   if(this.statements[stmtKey]) {
	        delete this.statements[stmtKey];
	        this.statements.length--;
	        this._removeMaps(lightStmt, stmtKey);
	        this._decrementStmtRefCount(lightStmt);
	    } 
	},

    _addToSingleNodeIndex : function _addToSingleNodeIndex(indexMap, lightStmt, stmtKey, node) {
        // summary: Indexes the given statement into the given index based on the given node as the key
        //  into the index.
        // description: This utility method will will handle setting up the index for the particular part of the
        //  statement. For example, I can use it to add the statement's subject node to the subject-based index (subjMap).
	    //  The various indexes (subjMap, propMap, etc.) have different types values for a given key
	    //  depending on how many statements are mapped to that key. If there are no statements that
	    //  map to the key, then the value is null or undefined. If there is only one value that
	    //  maps to the key, then the actual statement is stored as the value. If there is more than one value,
	    //  that maps to the key, then a map from statement key to statement is stored as the value.
	    //  To distinguish the storage of a map in the value versus a single statement, the map has the property
	    //  'isSet' set to true. The map also has a 'length' property.  
		var set = indexMap[node];
		if(!set) {
		    indexMap[node] = lightStmt; 
		} else if(set.isSet) {
		    set[stmtKey] = lightStmt; 
		    set.length++;
		} else {
		    var tempLStmt = set;
		    indexMap[node] = set = {}; 
		    set.isSet = true;
		    set.length = 2;
		    set[this._getLightStmtKey(tempLStmt)] = tempLStmt; 
		    set[stmtKey] = lightStmt; 
		}
 
    },
    
    _addToMultiNodeIndex : function _addToMultiNodeIndex(indexMap, lightStmt, stmtKey, firstNode, secondNode) {
        // summary: Similar to the _addToSingleNodeIndex method but works on the multi-node indexes
        //  like the psMap, and poMap.
		var secondIndexMap = indexMap[firstNode];
		if (!secondIndexMap) {
			indexMap[firstNode] = secondIndexMap = {};  
			secondIndexMap[secondNode] = lightStmt;  
		} else {
			var set = secondIndexMap[secondNode];
			if(!set) {
			    secondIndexMap[secondNode] = lightStmt;  
			} else if(set.isSet) {
			    set[stmtKey] = lightStmt; 
			    set.length ++;
			} else {
			    var tempLStmt = set;
    		    secondIndexMap[secondNode] = set = {};  
    		    set.isSet = true;
    		    set.length = 2;
    		    set[this._getLightStmtKey(tempLStmt)] = tempLStmt;  
    		    set[stmtKey] = lightStmt; 
    		    
			}
		}
    },
    
	_addMaps : function(lightStmt, stmtKey) {
	    // summary: Index this statement

	    this._addToSingleNodeIndex(this.subjMap, lightStmt, stmtKey, lightStmt.s);  
	    this._addToSingleNodeIndex(this.propMap, lightStmt, stmtKey, lightStmt.p);  
	    this._addToSingleNodeIndex(this.objMap, lightStmt, stmtKey, lightStmt.o);  
	    this._addToSingleNodeIndex(this.contextMap, lightStmt, stmtKey, lightStmt.c);  

	    this._addToMultiNodeIndex(this.poMap, lightStmt, stmtKey, lightStmt.p, lightStmt.o);  
	    this._addToMultiNodeIndex(this.psMap, lightStmt, stmtKey, lightStmt.p, lightStmt.s);  
	},

    _removeStatementFromSingleNodeIndex : function _removeStatementFromSingleNodeIndex(indexMap, lightStmt, stmtKey, node) {
        // summary: Removes the statement from the given index based on the given node as the key.
		var set = indexMap[node];
		if (set != null) {
            if(set.isSet) {
                delete set[stmtKey];
                set.length--;
                if(set.length == 0)
                    delete indexMap[node];
		    } else {
                delete indexMap[node];
		    }
		}
    },

    _removeStatementFromMultiNodeIndex : function _removeStatementFromMultiNodeIndex(indexMap, lightStmt, stmtKey, firstNode, secondNode) {
        // summary: Removes the statement from the given index based on the given node as the key.
		var secondIndexMap = indexMap[firstNode];
		if (secondIndexMap) {
			var set = secondIndexMap[secondNode];
			if(set && set.isSet) {
			    delete set[stmtKey]; 
			    set.length--;
			    if(set.length == 0) 
			        delete secondIndexMap[secondNode];
			} else if(set) {
    		    delete secondIndexMap[secondNode];
			}
			if(anzo.utils.isEmptyObject(secondIndexMap))
			   delete indexMap[firstNode];
		}
    },
    
	_removeMaps : function(lightStmt, stmtKey) {
	   
	    // summary: Remove indexes for this statement.
	    
	    this._removeStatementFromSingleNodeIndex(this.subjMap, lightStmt, stmtKey, lightStmt.s);  
	    this._removeStatementFromSingleNodeIndex(this.propMap, lightStmt, stmtKey, lightStmt.p);  
	    this._removeStatementFromSingleNodeIndex(this.objMap, lightStmt, stmtKey, lightStmt.o);  
	    this._removeStatementFromSingleNodeIndex(this.contextMap, lightStmt, stmtKey, lightStmt.c);  
		
	    this._removeStatementFromMultiNodeIndex(this.poMap, lightStmt, stmtKey, lightStmt.p, lightStmt.o);  
	    this._removeStatementFromMultiNodeIndex(this.psMap, lightStmt, stmtKey, lightStmt.p, lightStmt.s);  

	},
	
	_getSet : function(obj, key) {
	    var val = obj[key];
	    if(val && val.isSet) {
	       return val;
	    } else if(val) {
	        var o = { key : val };
	        o.length = 1;
	        o.isSet = true;
	        return o;
	    }
	    return null;
	},
	
	find : function() {
	    if(this.statements.length == 0)
	       return [];
	    return this.inherited(arguments);
	},
	
	_find : function(subject, predicate, object, namedGraphUris, args) {
		
		// summary: Find set of statements that match provided parameters.
		
	    // returns: An array of matching statements.
	    
		// subject : String | anzo.rdf.Resource | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : String | anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : Object | anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
	    
	    // namedGraphUris : String[] | anzo.rdf.URI[]
	    //  Array of uris used to match the named graph parameter of statements, or wildcard if null
	    
	    
	    
	    // 1. get val keys
	    // 2. get node ids
	    
		var sKey = subject   != null ? subject.dictionaryKey()   : null;
		var pKey = predicate != null ? predicate.dictionaryKey() : null;
		var oKey = object    != null ? object.dictionaryKey()    : null;
		
		var s = sKey ? this.valToNodeID[sKey] : null;
		if(s == null)
		  s = sKey;
		  
		var p = pKey ? this.valToNodeID[pKey] : null;
		if(p == null)
		  p = pKey;
		  
		var o = oKey ? this.valToNodeID[oKey] : null;
		if(o == null)
		  o = oKey;
		  
		var cArray = null;
		if(dojo.isArray(namedGraphUris)) {
		    var cArray = [];
    		for(var i = 0; i < namedGraphUris.length; i++) {
    		    var cKey = namedGraphUris[i].dictionaryKey();
    		    cArray[i] = cKey ? this.valToNodeID[cKey] : null;
    		    if(cArray[i] == null)
    		       cArray[i] = cKey;
    		}
		}
		
		//Determine what kind of query this is based on what values are provided
		var type = 0;
		if (s != null) {
			type |= 1;
		}
		if (p != null) {
			type |= 2;
		}
		if (o != null) {
			type |= 4;
		}
		if (cArray != null && cArray.length > 0) {
			type |= 8;
		}
		
		var results = null;
		switch (type) {
			case 0 :
			    results = this.statements;
			    break;
			case 1 :
			    results = this._getSet(this.subjMap, s);
				break;
			case 2 :
			    results = this._getSet(this.propMap, p);
				break;
			case 3 :
			     results = this._findPS(s, p);
			     break;
			case 4 :
				results = this._getSet(this.objMap, o);
				break;
			case 5 :
			     results = this.findSOC(s, o);
			     break;
			case 6 :
			     results = this._findPO(p, o);
			     break;
			case 7 :
			     results = this.findSPO(s, p, o);
			     break;
			case 8 :
				var matches = new anzo.utils.Set();
				for(var i = 0; i < cArray.length; i++) {
				    var namedGraphUri = cArray[i];
				    var cSet = this._getSet(this.contextMap, namedGraphUri);
					if (cSet != null) {
						matches.addAll(this._normalizeFindResults(cSet, args ? args.convert : true));
					}
				}
				return matches.toArray();
			case 9 :
			     results = this.findSC(s, cArray);
			     break;
			case 10 :
			     results = this.findPC(p, cArray);
			     break;
			case 11 :
				results = this._findPS(s, p, cArray);
			    break;
			case 12 :
			    results = this.findOC(o, cArray);
			    break;
			case 13 :
			     results = this.findSOC(s, o, cArray);
			     break;
			case 14 :
			     results = this._findPO(p, o, cArray);
			     break;
			case 15 :
				results = [];
				var visited = {};
				for (var i=0;i<cArray.length;i++) {
				    var stmt = { s: s, p: p, o: o, c: cArray[i]};
				    var stmtKey = this._getLightStmtKey(stmt);
					if (this.statements[stmtKey] && !(stmtKey in visited)) {
					    visited[stmtKey] = true;
					    results.push(stmt);
					}
				}
				break;
		}
		
		if(!results)
		    return [];
		return this._normalizeFindResults(results, args ? args.convert : true);
		
	},
	
	_contains  : function(subject, predicate, object, namedGraphUris) {
	    // description: Abstract method that must be implemented by subclasses.
	    return this._find(subject, predicate, object, namedGraphUris, { convert: true }).length > 0;		
	},
	
	_addAllSetObjToSet : function(set, setObj) {
	    for(var key in setObj) {
	        if(key == 'length' || key == 'isSet')
	           continue;
	        set.add(setObj[key], key);
	    }
	},

	_findPS : function(s, p, namedGraphUris) {
	    
	    // summary: Use the Predicate/Subject index to find statements
	    
	    // returns: An array of matching statements.
	    
	    // s : anzo.rdf.Resource
	    //  Subject value to match
	    
	    // p : anzo.rdf.URI
	    //  Predicate value to match
	    
	    // namedGraphUris : anzo.rdf.URI[]
	    //  Array of named graph uris to match, or wildcard if null
	    
		var matches = [];
		var visited = {};
		
		//Lookup property/s index for property value provided
		var psIndexMap = this.psMap[p];
		if (psIndexMap != null) {
			//Find s index for s provided
			var set = this._getSet(psIndexMap, s);
			if (set != null && set.length > 0) {
			    
			    //If only 1 namedGraphUri is provided, then get index for that namedGraphUri
				if (namedGraphUris == null || namedGraphUris.length == 0) {
				    return set;
				} else if (namedGraphUris.length == 1) {
					var cSet = this._getSet(this.contextMap, namedGraphUris[0]);
					if (cSet == null)
						return matches;
					
					//Use the smallest set of statements, the ones from the index or set from namedGraphUri index
					if (cSet.length < set.length) {
					    for(var key in cSet) {
					       if(key == 'length' || key == 'isSet')
	                           continue;
						    var stmt = cSet[key];
						    if(stmt.p == p && stmt.s == s) {
						        if(!(key in visited)) {
						            visited[key] = true;
						            matches.push(stmt);
						        }
							}
						}
					} else {
					    for(var key in set) {
					       if(key == 'length' || key == 'isSet')
	                           continue;
						    var stmt = set[key];
						    if(stmt.c == namedGraphUris[0]) {
								if(!(key in visited)) {
						            visited[key] = true;
						            matches.push(stmt);
						        }
							}
						}
					}
				} else { //If more than one namedGraphUri compare the namedGraphUri of statement from p/s index to set of namedGraphUris
					var contextSet = namedGraphUris;
					  for(var key in set) {
					    if(key == 'length' || key == 'isSet')
	                       continue;
						var stmt = set[key];
					    if(anzo.utils.indexOf(namedGraphUris, stmt.c) >= 0) {
					        if(!(key in visited)) {
					            visited[key] = true;
					            matches.push(stmt);
					        }
					    }
					}
				}
			}
		}
		return matches;
	},

	_findPO : function(p, o, namedGraphUris) {
	    
	    // summary: Use the Predicate/Object index to find statements
	    
	    // predicate : anzo.rdf.URI
	    //  Predicate value to match
	    
	    // object : anzo.rdf.Value
	    //  Object value to match
	    
	    // namedGraphUris : anzo.rdf.URI[]
	    //  Array of named graph uris to match, or wildcard if null
	    
		var matches = [];
		var visited = {};
		
		var poIndexMap = this.poMap[p];
		if (poIndexMap != null) {
			var set = this._getSet(poIndexMap, o);//[object()];
			if (set != null && set.length > 0) {
				if (namedGraphUris == null || namedGraphUris.length == 0) {
					return set;
				} else if (namedGraphUris.length == 1) {
					var cSet = this._getSet(this.contextMap, namedGraphUris[0]);
					if (cSet == null) {
						return matches;
					}
					if (cSet.length < set.length) {
					    for(var key in cSet) {
					       if(key == 'length' || key == 'isSet')
	                           continue;
						    var stmt = cSet[key];
						    if(stmt.p == p && stmt.o == o) {
								if(!(key in visited)) {
    					            visited[key] = true;
    					            matches.push(stmt);
    					        }
							}
						}
					} else {
					    for(var key in set) {
					       if(key == 'length' || key == 'isSet')
	                           continue;
						    var stmt = set[key];
							if(stmt.c == namedGraphUris[0]) {
								if(!(key in visited)) {
    					            visited[key] = true;
    					            matches.push(stmt);
    					        }
							}
						}
					}
				} else {
				    var contextSet = anzo.utils.Set(namedGraphUris);
					for(var key in set) {
				       if(key == 'length' || key == 'isSet')
                           continue;
					    var stmt = set[key];
						if (contextSet.contains(stmt.c)) {
							if(!(key in visited)) {
					            visited[key] = true;
					            matches.push(stmt);
					        }
						}
					}
				}
			}
		}
		return matches;
	},

	/**
	 * Find statements that match Subject,Predicate, and Object values provided
	 * 
	 * @param subj
	 *            Subject value to match
	 * @param prop
	 *            Property value to match
	 * @param obj
	 *            Object value to match
	 * @return Collection<Statement> of matching statements
	 */
	findSPO : function(s, p, o) {
	    
	    // summary: Find statements that match Subject,Predicate, and Object values provided
	    
	    // subject : anzo.rdf.Resource
	    //  Subject value to match
	    
	    // predicate : anzo.rdf.URI
	    //  Predicate value to match
	    
	    // object : anzo.rdf.Value
	    
	    
		var matches = [];
		var visited = {};
		
		var sSet = this._getSet(this.subjMap, s);
		if (sSet == null) {
			return matches;
		}
		
		var pSet = this._getSet(this.propMap, p);
		if (pSet == null) {
			return matches;
		}
		var oSet = this._getSet(this.objMap, o);
		if (oSet == null) {
			return matches;
		}
		if (sSet != null && pSet != null && oSet != null) {
			var set = new Array(3);
			set[0] = sSet;
			set[1] = pSet;
			set[2] = oSet;
			set.sort(anzo.utils.arrayAndSetComparator);
			
			if (set[0] == sSet) {
			    for(var key in sSet) {
			       if(key == 'length' || key == 'isSet')
                       continue;
				    var stmt = sSet[key];
				    if(stmt.o == o && stmt.p == p) {
                        if(!(key in visited)) {
				            visited[key] = true;
				            matches.push(stmt);
				        }
					}
				}
			} else if (set[0] == oSet) {
				for(var key in oSet) {
			       if(key == 'length' || key == 'isSet')
                       continue;
				    var stmt = oSet[key];
				    if(stmt.s == s && stmt.p == p) {
						if(!(key in visited)) {
				            visited[key] = true;
				            matches.push(stmt);
				        }
					}
				}
			} else {
			    for(var key in pSet) {
			       if(key == 'length' || key == 'isSet')
                       continue;
				    var stmt = pSet[key];
				    if(stmt.s == s && stmt.o == o) {
						if(!(key in visited)) {
				            visited[key] = true;
				            matches.push(stmt);
				        }
					}
				}
			}
		}
		return matches;
	},
	
	
	// -------------------------------------------------------------------------------------
	
	findSOC : function (s, o, namedGraphUris) {
	    
	    // summary: Find statements that match Subject and Object values provided
	    
	    // returns: An array of matching statements.
	    
	    // subject : anzo.rdf.Resource
	    //  Subject value to match
	    
	    // object : anzo.rdf.Value
	    //  Object value to match
	    
	    // namedGraphUris : anzo.rdf.URI[]
	    //  Array of named graph uris to match, or wildcard if null
	    
		var matches = [];
		var visited = {};
		
		var sSet = this._getSet(this.subjMap, s);
		if (sSet == null || sSet.length == 0) {
			return matches;
		}
		var oSet = this._getSet(this.objMap, o);
		if (oSet == null || oSet.length == 0) {
			return matches;
		}
		
		if (namedGraphUris != null && namedGraphUris.length > 0) {
			if (namedGraphUris.length == 1) {
				var cSet = this._getSet(this.contextMap, namedGraphUris[0]);
				if (cSet == null || cSet.length == 0) {
					return matches;
				}
				var set = new Array(3);
				set[0] = sSet;
				set[1] = cSet;
				set[2] = oSet;
				set.sort(anzo.utils.arrayAndSetComparator);
				if (set[0] == sSet) {
					 for(var key in sSet) {
    			       if(key == 'length' || key == 'isSet')
                           continue;
    				    var stmt = sSet[key];
    				    if(stmt.o == o && stmt.c == namedGraphUris[0]) {
							if(!(key in visited)) {
    				            visited[key] = true;
    				            matches.push(stmt);
    				        }
						}
					}
				} else if (set[0] == oSet) {
					 for(var key in oSet) {
    			       if(key == 'length' || key == 'isSet')
                           continue;
    				    var stmt = oSet[key];
    				    if(stmt.s == s && stmt.c == namedGraphUris[0]) {
							if(!(key in visited)) {
    				            visited[key] = true;
    				            matches.push(stmt);
    				        }
						}
					}
				} else {
					for(var key in cSet) {
    			       if(key == 'length' || key == 'isSet')
                           continue;
    				    var stmt = cSet[key];
    				    if(stmt.s == s && stmt.o == o) {
							if(!(key in visited)) {
    				            visited[key] = true;
    				            matches.push(stmt);
    				        }
						}
					}
				}
			} else {
				var contextSet = new anzo.utils.Set();
				contextSet.addAll(namedGraphUris);
				if (sSet.length < oSet.length) {
					
					for(var key in sSet) {
    			       if(key == 'length' || key == 'isSet')
                           continue;
    				    var stmt = sSet[key];
					    if(stmt.o == o && contextSet.contains(stmt.c)) {
							if(!(key in visited)) {
    				            visited[key] = true;
    				            matches.push(stmt);
    				        }
						}
					}
				} else {
					for(var key in oSet) {
    			       if(key == 'length' || key == 'isSet')
                           continue;
    				    var stmt = oSet[key];
    				    if(stmt.s == s && contextSet.contains(stmt.c)) {
							if(!(key in visited)) {
    				            visited[key] = true;
    				            matches.push(stmt);
    				        }
						}
					}
				}
			}
		} else {
			if (sSet.length < oSet.length) {
				for(var key in sSet) {
			        if(key == 'length' || key == 'isSet')
                       continue;
				    var stmt = sSet[key];
				    if(stmt.o == o) {
						if(!(key in visited)) {
				            visited[key] = true;
				            matches.push(stmt);
				        }
					}
				}
			} else {
				for(var key in oSet) {
			        if(key == 'length' || key == 'isSet')
                       continue;
				    var stmt = oSet[key];
				    if(stmt.s == s) {
						if(!(key in visited)) {
				            visited[key] = true;
				            matches.push(stmt);
				        }
					}
				}
			}
		}
		return matches;
	},

	findPC : function(p, namedGraphUris) {
	    
	    // summary: Use the Predicate index to find statements
	    
	    // returns: An array of matching statements.
	    
	    // predicate : anzo.rdf.URI
	    //  Predicate value to match
	    
	    // namedGraphUris : anzo.rdf.URI[]
	    //  Array of named graph uris to match, or wildcard if null
	    
		var matches = [];
		var visited = {};
		
		var pSet = this._getSet(this.propMap, p);
		if (pSet == null || pSet.length == 0) {
			return matches;
		}
		if (namedGraphUris.length == 1) {
			var cSet = this._getSet(this.contextMap, namedGraphUris[0]);
			if (cSet == null) {
				return matches;
			}
			if (cSet.length < pSet.length) {
				for(var key in cSet) {
			        if(key == 'length' || key == 'isSet')
                       continue;
				    var stmt = cSet[key];
				    if(stmt.p == p) {
						if(!(key in visited)) {
				            visited[key] = true;
				            matches.push(stmt);
				        }
					}
				}
			} else {
			    for(var key in pSet) {
			        if(key == 'length' || key == 'isSet')
                       continue;
				    var stmt = pSet[key];
				    if(stmt.c == namedGraphUris[0]) {
						if(!(key in visited)) {
				            visited[key] = true;
				            matches.push(stmt);
				        }
					}
				}
			}
		} else {
			var contextSet = new anzo.utils.Set();
			contextSet.addAll(namedGraphUris);
			 for(var key in pSet) {
		        if(key == 'length' || key == 'isSet')
                   continue;
			    var stmt = pSet[key];
				if (contextSet.contains(stmt.c)) {
					if(!(key in visited)) {
			            visited[key] = true;
			            matches.push(stmt);
			        }
				}
			}
		}
		return matches;
	},

	findSC : function(s, namedGraphUris) {
	    
	    // summary: Use the Subject index to find statements
	    
	    // returns: An array of matching statements.
	    
	    // subject : anzo.rdf.Resource
	    //  Subject value to match
	    
	    // namedGraphUris : anzo.rdf.URI[]
	    //  Array of named graph uris to match, or wildcard if null
	    
		var matches = [];
		var visited = {};
		
		var sSet = this._getSet(this.subjMap, s);
		if (sSet == null) {
			return matches;
		}
		if (namedGraphUris.length == 1) {
			var cSet = this._getSet(this.contextMap, namedGraphUris[0]);
			if (cSet == null) {
				return matches;
			}
			if (cSet.length < sSet.length) {
				 for(var key in cSet) {
    		        if(key == 'length' || key == 'isSet')
                       continue;
    			    var stmt = cSet[key];
    			    if(stmt.s == s) {
						if(!(key in visited)) {
    			            visited[key] = true;
    			            matches.push(stmt);
    			        }
					}
				}
			} else {
				for(var key in sSet) {
    		        if(key == 'length' || key == 'isSet')
                       continue;
    			    var stmt = sSet[key];
    			    if(stmt.c == namedGraphUris[0]) {
						if(!(key in visited)) {
    			            visited[key] = true;
    			            matches.push(stmt);
    			        }
					} 
				}
			}
		} else {
			var contextSet = new anzo.utils.Set();
			contextSet.addAll(namedGraphUris);
			for(var key in sSet) {
		        if(key == 'length' || key == 'isSet')
                   continue;
			    var stmt = sSet[key];
			    if(contextSet.contains(stmt.c)) {
					if(!(key in visited)) {
			            visited[key] = true;
			            matches.push(stmt);
			        }
				}
			}
		}
		return matches;
	},

	findOC : function(o, namedGraphUris) {
	    
	    // summary: Use the Object index to find statements
	    
	    // returns: An array of matching statements.
	    
	    // object : anzo.rdf.Value
	    //  Object value to match
	    
	    // namedGraphUris : anzo.rdf.URI[]
	    //  Array of named graph uris to match, or wildcard if null
	    
		var matches = [];
		var visited = {};
		
		var oSet = this._getSet(this.objMap, o);
		if (oSet == null) {
			return matches;
		}
		if (namedGraphUris.length == 1) {
			var cSet = this._getSet(this.contextMap, namedGraphUris[0]);
			if (cSet == null) {
				return matches;
			}
			if (cSet.length < oSet.length) {
				for(var key in cSet) {
    		        if(key == 'length' || key == 'isSet')
                       continue;
    			    var stmt = cSet[key];
    			    if(stmt.o == o) {
						if(!(key in visited)) {
    			            visited[key] = true;
    			            matches.push(stmt);
    			        }
					}
				}
			} else {
				for(var key in oSet) {
    		        if(key == 'length' || key == 'isSet')
                       continue;
    			    var stmt = oSet[key];
    			    if(stmt.c == namedGraphUris[0]) {
						if(!(key in visited)) {
    			            visited[key] = true;
    			            matches.push(stmt);
    			        }
					}
				}
			}
		} else {
			var contextSet = new anzo.utils.Set();
			contextSet.addAll(namedGraphUris);
			for(var key in oSet) {
		        if(key == 'length' || key == 'isSet')
                   continue;
			    var stmt = oSet[key];
				if (contextSet.contains(stmt.c)) {
					if(!(key in visited)) {
			            visited[key] = true;
			            matches.push(stmt);
			        }
				}
			}
		}
		return matches;
	},
	
	// -------------------------------
	
	clear : function () {
	    // summary: Clear statements and indexes from memory
	    
		this.statements        = {};
		this.statements.length = 0;
		this.statements.isSet  = true;
		this.subjMap           = {};
		this.propMap           = {};
		this.objMap            = {};
		this.contextMap        = {};
		this.poMap             = {};
		this.psMap             = {};
		
        this.valToNodeID       = {};
		this.nodeIDToVal       = {};
		this.nodeIDToRefCount  = {};
	},

    size : function() {
	    if(!arguments[0])
	       return this.statements.length;
	    return this.inherited(arguments);
	},
	
	_size : function(namedGraphUris) {
	    
	    // summary: 
	    //     Returns the number of statements in the store for given namedGraphUris.
	    //     If the given named graph uris are not specified, it returns the total 
	    //     number of statemetns in the store.
	    
	    // returns:
	    //     The number of statements in the store for the given namedGraphUris.
	    //     If namedGraphUris is null, returns the total number of statements in this store.
	    
	    // namedGraphUris : String[] | anzo.rdf.URI[] | null
	    //  Array of uris used to determine the total sizes of specified graphs.
	    
	    if(!namedGraphUris || namedGraphUris.length == 0) 
	       return this.statements.length;
	    
		var size = 0;
		for (var i = 0; i < namedGraphUris.length; i++) {
		    var namedGraphUri = namedGraphUris[i];
		    var cKey = namedGraphUri.dictionaryKey();
    		var c = cKey ? this.valToNodeID[cKey] : null;
		    var stmts = this._getSet(this.contextMap, c);
			if (stmts != null) {
				size += stmts.length;
			}
		}
		return size;
	},
	
	isEmpty : function() {
	    
	    // summary:
		//      Form 1: isEmpty() - checks if this store is empty
		//      Form 2: isEmpty(string | anzo.rdf.URI | anzo.rdf.INamedGraph) - checks if statements by the given named graph URI exist in the quad store
		//      Form 3: isEmpty(string[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]) - checks if statements by the given named graph URIs exist in the quad store
	    
	    if(!arguments[0])
	       return (this.statements.length == 0);
	    return this.inherited(arguments);
	}
	
	
});

