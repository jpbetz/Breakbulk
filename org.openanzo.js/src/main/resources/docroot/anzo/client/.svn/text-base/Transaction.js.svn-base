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


dojo.provide("anzo.client.Transaction");
dojo.require("anzo.rdf.QuadStore");

dojo.declare('anzo.client.Transaction', null, {
    
    // summary: The Transaction contains pointers to parent, child, and sibling nodes, a list of optional preconditions, and two QuadStore instances that make up the delta aspect of the Transaction. The pointers work as described in the previous section, and we describe peconditions in the next section. Here we describe how we keep track of additions and deletions in the Transaction as well as how we filter.
    
    // additions : anzo.rdf.QuadStore
    //  Store that holds all the statements added in this transaction.
    additions            : null,
    
    // deletions : anzo.rdf.QuadStore
    //  Store that holds all the statements deleted in this transaction.
    deletions            : null,
    
    // preconditions : anzo.client.Precondition[]
    //  Array of preconditions associated with this transaction.
    preconditions        : null,
    
    // parentTransaction : anzo.client.Transaction
    //  Reference to the parent transaction.
    parentTransaction    : null,
    
    // childTransaction : anzo.client.Transaction
    //  Reference to the child transaction.
    childTransaction     : null,
    
    // previousTransaction : anzo.client.Transaction
    //  Reference to the previous transaction.
    previousTransaction  : null,
    
    // nextTransaction : anzo.client.Transaction
    //  Reference to the next transaction.
    nextTransaction      : null,
    
    contextQuadStore	 : null,
    
    contextGraph		 : null,
    
    transactionUri		 : null,
        
    constructor : function(preconditions) {
        
        // summary: Initialize global variables.
        
        // preconditions : anzo.client.Precondition[]
        //  Preconditions associated with this transaction.  This transaction will fail if any of the preconditions fail.
        
    	this.additions = new anzo.rdf.QuadStore();
    	this.deletions = new anzo.rdf.QuadStore();
    	this.preconditions = preconditions;
    	this.transactionUri = anzo.utils.UriGenerator.generateNamedGraphUri();
    },
    
    add : function(statement) {
        
        // summary: Add a single statement or multiple statements to this transaction.
        
        // statement: anzo.rdf.Statement | anzo.rdf.Statements[]
        //  Statements added to the currentTransaction.
        
    	if (dojo.isArray(statement)) {
    		this.additions.add(statement);
    		this.deletions.remove(statement);
    	} else {
    		this.additions.add(statement);
    		this.deletions.remove(statement);
    	}
    },
    
    remove : function(statement) {
    	
    	// summary: Remove a single statement or multiple statements from this transaction
        
        // statement: anzo.rdf.Statement | anzo.rdf.Statements[]
        //  Statements removed from the currentTransaction.
         
        if (dojo.isArray(statement)) {
    		this.additions.remove(statement);
    		this.deletions.add(statement);
    	} else {
    		this.additions.remove(statement);
    		this.deletions.add(statement);
    	}
    },
    
    filter : function(statements, subject, predicate, object, namedGraphUris) {
        
        // summary:
        //  Filter the given anzo.util.Set of Statement on the additions and deletions in this Transaction. 
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
        
    	statements.addAll(this.additions.find(subject,predicate,object,namedGraphUris));
    	statements.removeAll(this.deletions.find(subject,predicate,object,namedGraphUris));
    },

    walkTransactionTree : function(mapFunction) {
        
        // summary: 
        //  Walk over the transaction tree in pre-order (root-child-sibling), 
        //  applying the given mapFunction to each transaction.  This utility
        //  will also be used by the code that serializes the tree for updateServer.
        
        // mapFunction : Function
        //  Function applied to each transaction in the tree.
        
    	this._walkTransactionTree(mapFunction,this);
    },
    
    _walkTransactionTree : function(mapFunction, root) {
        
        // summary: 
        //  Walk over the transaction tree in pre-order (root-child-sibling), 
        //  applying the given mapFunction to each transaction.  This utility
        //  will also be used by the code that serializes the tree for updateServer.
        
        // mapFunction : Function
        //  Function applied to each transaction in the tree.
        
        // root : anzo.client.Transaction
        //  The target transaction.
        
    	mapFunction(root);
    	if (root.childTransaction) {
    		this._walkTransactionTree(mapFunction,root.childTransaction);
    	}
    	if (root.nextTransaction) {
    		this._walkTransactionTree(mapFunction,root.nextTransaction);
    	}
    },
    
    getContextQuadStore : function() {
        if (this.contextQuadStore == null) {
            if (this.parentTransaction != null) {
                this.contextQuadStore = this.parentTransaction.getContextQuadStore();
            } else if (this.previousTransaction != null) {
                this.contextQuadStore = this.previousTransaction.getContextQuadStore();
            } else {
                this.contextQuadStore = new anzo.rdf.QuadStore();
            }
        }
        return this.contextQuadStore;
    },

    getContext : function() {
        if (this.contextGraph != null) {
            return this.contextGraph;
        }
        this.contextGraph = new anzo.rdf.NamedGraph(this.transactionUri, this.getContextQuadStore());
        return this.contextGraph;
    },
    
    isEmpty : function() {
    	var empty = true;
    	this.walkTransactionTree(function(transaction) {
    		empty = empty && transaction.additions.isEmpty() && transaction.deletions.isEmpty() && (!transaction.contextGraph || transaction.contextGraph.isEmpty());
    	});
    	return empty;
    }
    
	
});