/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.client.TransactionProxy");
dojo.require("anzo.rdf.BaseQuadStore");


dojo.declare('anzo.client.TransactionProxy', anzo.rdf.BaseQuadStore, {
    
    // summary: TransactionProxy itself is fairly simple. The add method takes in either a Statement, list of Statement or s,p,o,c quad definition. First it checks if a transaction has already begun. If not, it wraps the entire add operation in a new transaction. It then asks the TransactionQueue to which it is bound for the current Transaction (possibly just created) and in turn invokes Transaction.addStatmentAddition. The find method first asks the wrapped IQuadStore to perform the same find, and then filters the results using the TransactionQueue.
    
    constructor : function(quadStore, transactionQueue) {
       
       // summary: Initialization
       
       // quadStore: anzo.rdf.IQuadStore
       //  The store to which this store will proxy requests.
       
       // transactionQueue: anzo.client.TransactionQueue
       //  The queue that holds transactions for this graph.
       
       this.quadStore = quadStore;
       this.transactionQueue = transactionQueue;
       
    },
    
	_addStatements : function (statements) {
	    
	    // summary: Traps the additions in a transaction.
	    
		var inTransaction = this.transactionQueue.inTransaction();
		if (!inTransaction) {
			this.transactionQueue.begin();
		}
	    this.transactionQueue.add(statements);
	    if (!inTransaction) {
			this.transactionQueue.commit();
		}
	},

	_removeStatements : function(statements) { 
	    
	    // summary: Traps the removes in a transaction.
	    
		var inTransaction = this.transactionQueue.inTransaction();
		if (!inTransaction) {
			this.transactionQueue.begin();
		}
	    this.transactionQueue.remove(statements);
	    if (!inTransaction) {
			this.transactionQueue.commit();
		}
	},

	_find : function(subject, predicate, object, namedGraphUris) { 
	    
	    // summary: Performs a find on the given pattern.  Find is first called on the proxied store, then the statements are filtered out by the changes in the transaction queue.
	    
	    // subject : String | anzo.rdf.Resource | null
	    //  Subject value to match, or wildcard if null
	    
	    // predicate : String | anzo.rdf.URI | null
	    //   Predicate value to match, or wildcard if null
	    
	    // object : Object | anzo.rdf.Value | null
	    //  Object value to match, or wildcard if null
	    
	    // namedGraphUris : String | anzo.rdf.URI | anzo.rdf.INamedGraph | String[] | anzo.rdf.URI[] | anzo.rdf.INamedGraph[]
	    //  Array of uris used to match the named graph parameter of statements, or wildcard if null
	    
	    // returns: An array of matching statements.
	    
		var statements = new anzo.utils.Set();
		statements.addAll(this.quadStore.find(subject, predicate, object, namedGraphUris));
		
		this.transactionQueue.filter(statements, subject, predicate, object, namedGraphUris);
		return statements.toArray(); 
    },

	
	// -------------------------------
	
	clear : function () { 
	    
	    // summary: Removes all statements in this store.
	    
	    this.remove(this.find());
	},

	_isEmpty : function(namedGraphUris) { 
	    
	   // returns:
	   //     Returns true if the number of statements in the store for the given namedGraphUris is zero, false otherwise.
	   //     If namedGraphUris is empty, returns true if the the total number of statements in this store is zero, false otherwise.
	    
	   return this.size(namedGraphUris) == 0;
	},

	_size : function(namedGraphUris) { 
	    
	    // summary: 
	    //     Returns the number of statements in the store for given namedGraphUris.
	    //     If the given named graph uris are not specified, it returns the total 
	    //     number of statemetns in the store.
	    
	    // description: Abstract method that must be implemented by subclasses.
	    
	    // namedGraphUris : String[] | anzo.rdf.URI[] | null
	    //  Array of uris used to determine the total sizes of specified graphs.
	    
	    // returns:
	    //     The number of statements in the store for the given namedGraphUris.
	    //     If namedGraphUris is null, returns the total number of statements in this store.
	    
	    
		if (!namedGraphUris) {
	    	return this.find().length;
		} else {
			return this.find(null, null, null, namedGraphUris).length;
		}
	},

	getNamedGraphUris : function () { 
	    
	    // summary: 
	    //     Return the set of namedGraphUris contained within this store.
	    //     The only way to correctly get all namedGraphUris, is to enumerate all the statement (filtered of course),
	    //     and build up a set of namedGraphUris.  This is because the baseContainer could contain a single statement
	    //     from a named graph and the transaction queue could contain a deletion for that statement.  
	    //     perhaps we should disallow this method. 
	    
	    // returns: An array of named graph uris contained in this store.
	    
	     
	    var stmts = this.getAllStatements();
	    var namedGraphUris = new anzo.utils.Set();
	    for (var i=0;i<stmts.length;i++) {
	    	namedGraphUris.add(stmts[i].namedGraphUri);
	    }
	}
	
});