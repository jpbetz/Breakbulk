/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.Collections;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IPrecondition;

/**
 * The Transaction contains pointers to parent, child, and sibling nodes, a list of optional preconditions, and two QuadStore instances that make up the delta
 * aspect of the Transaction. The pointers work as described in the previous section, and we describe peconditions in the next section. Here we describe how we
 * keep track of additions and deletions in the Transaction as well as how we filter.
 * 
 * This class is not thread safe.
 * 
 * @author Joe Betz
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
class Transaction {

    //  Store that holds all the statements added in this transaction.
    final MemQuadStore          additions;

    //  Store that holds all the statements deleted in this transaction.
    final MemQuadStore          deletions;

    //  Array of preconditions associated with this transaction.
    final Set<IPrecondition>    preconditions;

    //  Reference to the parent transaction.
    Transaction                 parentTransaction;

    //  Reference to the child transaction.
    Transaction                 childTransaction;

    //  Reference to the previous transaction.
    Transaction                 previousTransaction;

    //  Reference to the next transaction.
    Transaction                 nextTransaction;

    // Quad store containing the context graphs the entire transaction hierarchy
    IQuadStore                  contextQuadStore;

    INamedGraph                 contextGraph;

    final URI                   transactionUri;

    // these two sets are used to keep track of post-update processing when new graphs are created
    // on the server.
    protected HashMap<URI, URI> namedGraphsToSubscribe = new HashMap<URI, URI>();

    final Set<URI>              serverUUIDStoFetch     = new HashSet<URI>();

    /**
     * Initialize global variables.
     * 
     * @param preconditions
     *            Preconditions associated with this transaction. This transaction will fail if any of the preconditions fail.
     */
    Transaction(Set<IPrecondition> preconditions, URI uri) {
        this.additions = new MemQuadStore();
        this.deletions = new MemQuadStore();
        this.preconditions = preconditions;
        this.transactionUri = uri;
    }

    Transaction(Set<IPrecondition> preconditions) {
        this(preconditions, UriGenerator.generateNamedGraphUri());
    }

    Transaction() {
        this(new HashSet<IPrecondition>());
    }

    /**
     * Add a single statement or multiple statements to this transaction.
     * 
     * @param statements
     *            Statements added to the currentTransaction.
     */
    void add(Statement... statements) {
        this.additions.add(statements);
        this.deletions.remove(statements);
    }

    /**
     * Remove a single statement or multiple statements from this transaction
     * 
     * @param statements
     *            Statements removed from the currentTransaction.
     */
    void remove(Statement... statements) {
        this.additions.remove(statements);
        this.deletions.add(statements);
    }

    /**
     * Filter the given anzo.util.Set of Statement on the additions and deletions in this Transaction. The quad pattern arguments act as a hint to narrow the
     * filtering. In particular, every Statement in statements is guaranteed to conform to the given quad pattern.
     * 
     * @param statements
     *            Statements that are to be filtered.
     * @param subject
     *            Subject of the quad pattern used to filter the given statements.
     * @param predicate
     *            Predicate of the quad pattern used to filter the given statements.
     * @param object
     *            Object of the quad pattern used to filter the given statements.
     * @param namedGraphUris
     *            Named graph uri of the quad pattern used to filter the given statements.
     */
    void filter(Collection<Statement> statements, Resource subject, URI predicate, Value object, URI... namedGraphUris) {
        Collections.addAllUnique(this.additions.find(subject, predicate, object, namedGraphUris), statements);
        statements.removeAll(this.deletions.find(subject, predicate, object, namedGraphUris));
    }

    /**
     * Walk over the transaction tree in pre-order (root-child-sibling), applying the given mapFunction to each transaction. This utility will also be used by
     * the code that serializes the tree for updateServer.
     * 
     * @param mapFunction
     *            Function applied to each transaction in the tree.
     */
    void walkTransactionTree(MapFunction mapFunction) {
        this.performWalkTransactionTree(mapFunction, this);
    }

    /**
     * Walk over the transaction tree in pre-order (root-child-sibling), applying the given mapFunction to each transaction. This utility will also be used by
     * the code that serializes the tree for updateServer.
     * 
     * @param mapFunction
     *            Function applied to each transaction in the tree.
     * @param root
     *            The target transaction.
     */
    void performWalkTransactionTree(MapFunction mapFunction, Transaction root) {
        mapFunction.call(root);
        if (root.childTransaction != null && root.childTransaction != root) {
            this.performWalkTransactionTree(mapFunction, root.childTransaction);
        }
        if (root.nextTransaction != null && root.nextTransaction != root) {
            this.performWalkTransactionTree(mapFunction, root.nextTransaction);
        }
    }

    interface MapFunction {
        void call(Transaction transaction);
    }

    Collection<Statement> getAdditions() {
        return additions.getStatements();
    }

    Collection<Statement> getDeletions() {
        return deletions.getStatements();
    }

    Set<IPrecondition> getPreconditions() {
        return preconditions;
    }

    boolean isEmpty() {
        boolean empty = additions.isEmpty() && deletions.isEmpty() && (contextGraph == null || contextGraph.isEmpty());
        if (!empty) {
            return false;
        }
        empty = childTransaction == null || childTransaction.isEmpty();
        if (!empty) {
            return false;
        }
        empty = nextTransaction == null || nextTransaction.isEmpty();
        return empty;
    }

    protected IQuadStore getContextQuadStore() {
        if (contextQuadStore == null) {
            if (parentTransaction != null) {
                contextQuadStore = parentTransaction.getContextQuadStore();
            } else if (previousTransaction != null) {
                contextQuadStore = previousTransaction.getContextQuadStore();
            } else {
                contextQuadStore = new MemQuadStore();
            }
        }
        return contextQuadStore;
    }

    INamedGraph getContext() {
        if (contextGraph != null) {
            return contextGraph;
        }
        contextGraph = new NamedGraph(transactionUri, getContextQuadStore());
        return contextGraph;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) obj;
        return this.transactionUri.equals(other.transactionUri);
    }

    @Override
    public int hashCode() {
        return transactionUri.toString().hashCode();
    }

    @Override
    public String toString() {
        return transactionUri.toString();
    }

    /**
     * @return the serverUUIDStoFetch
     */
    Set<URI> getServerUUIDStoFetch() {
        return serverUUIDStoFetch;
    }

    /**
     * @return the namedGraphsToSubscribe
     */
    HashMap<URI, URI> getNamedGraphsToSubscribe() {
        return namedGraphsToSubscribe;
    }

}
