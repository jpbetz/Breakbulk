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

dojo.provide("anzo.client.TransactionQueue");

dojo.require("anzo.client.Transaction");

dojo.declare('anzo.client.TransactionQueue', null, {
	
	// summary: Keeps an ordered tree of transactions across all graphs in an AnzoClient. Each transaction contains
	//   the particular statements that were added and removed and other information such as the transaction context
	//   and the precondition. 
	
	// committedTransactions : Array
	//  Array of committed transactions.
	committedTransactions  : null,   
	
	// currentTransaction : anzo.client.Transaction
	//  The current transaction.
	currentTransaction     : null,
	
	// currentTransactionRoot : anzo.client.Transaction
	//  The root of the current transaction (root of the transaction tree).
	currentTransactionRoot : null,
    
    constructor : function(anzoClient) {
        
       // summary: Initialize local data structures.
       
	   this.anzoClient = anzoClient;
	   
       this.committedTransactions = [];
       
       this.committedAdditionsInTransit = new anzo.rdf.QuadStore();
       this.committedDeletionsInTransit = new anzo.rdf.QuadStore();
       
       this.committedAdditions = new anzo.rdf.QuadStore();
       this.committedDeletions = new anzo.rdf.QuadStore();
    },
    
    inTransaction : function() {
        
        // summary: Checks if in transaction.
        
        // returns: True if in a transaction, false otherwise.
        
    	return this.currentTransaction != null;
    },
    
    
    flush : function() {

		// summary:
        //  Called when the set of committed transactions has been processed.  flush() does not
        //  abort the current transaction.
    	this.committedTransactions = [];  
    	this.committedAdditionsInTransit.clear();  	
    	this.committedDeletionsInTransit.clear();
    	this.committedAdditions.clear();
    	this.committedDeletions.clear();
    },
    
    clear : function() {
        
        // summary: Clears the queue, removing all stored transactions.
    	this.committedTransactions  = [];
    	this.committedAdditionsInTransit.clear();  	
    	this.committedDeletionsInTransit.clear();
    	this.committedAdditions.clear();
    	this.committedDeletions.clear();
    	this.currentTransaction     = null;
    	this.currentTransactionRoot = null;
    },
    
    begin : function(preconditions) {
        
        // summary: create a new Transaction, if currentTransaction is not null, set it to the child of the curentTransaction, and set the currentTransaction to point to the new Transaction, and set parentTransaction pointer of new transaction
        
        // preconditions: anzo.client.Precondition | anzo.client.Precondition[]
        //  The precondition(s) associated with this transaction that must be valid for this transaction to succeed.
        
    	if (preconditions && !dojo.isArray(preconditions)) {
    		preconditions = [preconditions];
    	}
    	var newTransaction = new anzo.client.Transaction(preconditions);
    	if (!this.currentTransaction) {
    		this.currentTransaction = newTransaction;
    		this.currentTransactionRoot = this.currentTransaction;
    	} else {
    		this.currentTransaction.childTransaction = newTransaction;
    		newTransaction.parentTransaction = this.currentTransaction;
    		this.currentTransaction = newTransaction;
    	}
    },
    
    commit : function() {
        
        // summary: if currentTransaction.parentTransaction and currentTransaction.previousTransaction are 'both' null, move the currentTransaction to the committedTransactions list, and set currentTransaction to null. Otherwise, set currentTransaction to the parent of the previous-most sibling of currentTransaction. If a parent is found, create a sibling for the parent. Set the next pointer of the sibling to the parent, and the prev pointer of the parent to the sibling. Finally set the currentTransaction to point to the new sibling. If a parent is not found, that means we have committed a sibling of the top-level transaction, which means we are committing the top-level transaction itself, so queue the transaction.
        
    	
    	var fireCompleteEvent = false;
    	
    	if (!(this.currentTransaction.parentTransaction || this.currentTransaction.previousTransaction)) {
    	    
    		if(!this.currentTransaction.isEmpty()) {
        		this.committedTransactions.push(this.currentTransaction);
        		this._applyToGlobalAddditionDeletions(this.currentTransaction);
    	    } else {
    	    	fireCompleteEvent = true;
    	    }
    		var oldTrans = this.currentTransaction;
    		this.currentTransaction = null;
    		this.currentTransactionRoot = null;
    		
    		if(fireCompleteEvent)
    			this.anzoClient.transactionComplete(oldTrans.transactionUri, null, [], oldTrans.contextQuadStore);
	    	
    	} else {
    		
    		// find the parent.  We walk back the prev-trans chain until it ends.  
    		while (this.currentTransaction.previousTransaction) {
    			this.currentTransaction = this.currentTransaction.previousTransaction;
    		}
    		if (this.currentTransaction.parentTransaction) {
    			var newSibling = new anzo.client.Transaction();
    			newSibling.previousTransaction = this.currentTransaction.parentTransaction;
    			this.currentTransaction.parentTransaction.nextTransaction = newSibling;
    			this.currentTransaction = newSibling;
    		} else {
    		    if(!this.currentTransaction.isEmpty()) {
        			this.committedTransactions.push(this.currentTransaction);
        			this._applyToGlobalAddditionDeletions(this.currentTransaction);
    		    } else {
    		    	fireCompleteEvent = true;
    		    }
    		    var oldTrans = this.currentTransaction;
    			this.currentTransaction = null;
    			this.currentTransactionRoot = null;
    			
    			if(fireCompleteEvent)
        			this.anzoClient.transactionComplete(oldTrans.transactionUri, null, [], oldTrans.contextQuadStore);
    		}
    	}
    },
    
    abort : function() {
        
        // summary: simply set currentTransaction to the parent of the previous most sibling of currentTransaction, Note that the previous-most sibling may be us and so go directly to parentTransaction. If the previous most sibling has no parent, then we aborting a sibling of the top-level transaction, i.e. we are aborting the top-level transaction
        
    	if (!(this.currentTransaction.parentTransaction || this.currentTransaction.previousTransaction)) {
    		this.currentTransaction = null;
    		this.currentTransactionRoot = null;
    	} else {
    		// find the parent.  We walk back the prev-trans chain until it ends.  
    		while (this.currentTransaction.previousTransaction) {
    			this.currentTransaction = this.currentTransaction.previousTransaction;
    		}
    		if (this.currentTransaction.parentTransaction) {
    			this.currentTransaction = this.currentTransaction.parentTransaction;
    		} else {
    			this.currentTransaction = null;
    			this.currentTransactionRoot = null;
    		}
    	}
    },
    
    add : function(statement) {
        
        // summary: Add a single statement or multiple statements to the currentTransaction.
        
        // statement: anzo.rdf.Statement | anzo.rdf.Statements[]
        //  Statements added to the currentTransaction.
        
    	if (!this.currentTransaction) {
    		// it is the TransactionProxy's responsibility to make sure we have a transaction
    		throw new Error("Transaction queue not in transaction");
    	} else {
    		this.currentTransaction.add(statement);
    	}
    },
    
    remove : function(statement) {
        
        // summary: Remove a single statement or multiple statements from the currentTransaction
        
        // statement: anzo.rdf.Statement | anzo.rdf.Statements[]
        //  Statements removed from the currentTransaction.
        
    	if (!this.currentTransaction) {
    		// it is the TransactionProxy's responsibility to make sure we have a transaction
    		throw new Error("Transaction queue not in transaction");
    	} else {
    		this.currentTransaction.remove(statement);
    	}
    },
    
    
      

    filter : function(statements, subject, predicate, object, namedGraphUris) {
        
        // summary:
        //  Filter the given anzo.utils.Set of Statement on the additions and deletions in every Transaction. 
        //  The quad pattern arguments act as a hint to narrow the filtering.  In particular, every Statement
        //  in statements is guaranteed to conform to the given quad pattern.  
    	
    	// statements : anzo.utils.Set
    	//  Set of statements that are to be filtered.
    	
    	// subject: anzo.rdf.Resource
    	//  Subject of the quad pattern used to filter the given statements.
    	
    	// predicate: anzo.rdf.URI
    	//  Predicate of the quad pattern used to filter the given statements.
    	
    	// object: anzo.rdf.Value
    	//  Object of the quad pattern used to filter the given statements.
    	
    	// namedGraphUris: anzo.rdf.URI[]
    	//  Array of named graph uris of the quad pattern used to filter the given statements.
    	
    	var mapFunction = function(transaction) {
			transaction.filter(statements, subject, predicate, object, namedGraphUris);
    	}
    	
    	
    	// ---------------------------------------
        
        if(!this.committedAdditionsInTransit.isEmpty())
            statements.addAll(this.committedAdditionsInTransit.find(subject,predicate,object,namedGraphUris));
        
        if(!this.committedDeletionsInTransit.isEmpty())
            statements.removeAll(this.committedDeletionsInTransit.find(subject,predicate,object,namedGraphUris));
        
        if(!this.committedAdditions.isEmpty())
            statements.addAll(this.committedAdditions.find(subject,predicate,object,namedGraphUris));
        
        if(!this.committedDeletions.isEmpty())
            statements.removeAll(this.committedDeletions.find(subject,predicate,object,namedGraphUris));
        
        // ---------------------------------------
        
    	if (this.currentTransaction) {
    		this.currentTransactionRoot.walkTransactionTree(mapFunction);
    	}
	},
    
    
    getTransactionContext : function() {
        if (this.currentTransaction) {
            return this.currentTransaction.getContext();
        }
    },
    
    _applyToGlobalAddditionDeletions : function(transaction) {
        var _this = this;
        
        var mapFunction = function(t) {
            var _a = t.additions.find();
            _this.committedAdditions.add(_a);
            _this.committedDeletions.remove(_a);
            
            var _d = t.deletions.find();
            _this.committedDeletions.add(_d);
            _this.committedAdditions.remove(_d);
        }
        transaction.walkTransactionTree(mapFunction);
    }
    
	
});