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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.services.IPrecondition;

/**
 * Manages both current transactions as they are built up on a per-thread basis and committed transactions that have not yet been replicated up to the
 * repository.
 * 
 * This class is thread safe. The active transactions as isolated per-thread, see ThreadLocal for details.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TransactionQueue {

    //  Array of committed transactions.
    protected final List<Transaction>                committedTransactions;

    // map of threads to IsolatedTransactions
    protected final ThreadLocal<IsolatedTransaction> isolatedTransactions;

    protected final TransactionPersistence           transactionPersistence;

    /**
     * Provides per-thread transaction isolation.
     * 
     * @author Joe Betz <jpbetz@cambridgesemantics.com>
     * 
     */
    protected static class IsolatedTransaction {
        // The current transaction.
        public Transaction currentTransaction;

        // The root of the current transaction (root of the transaction tree).
        public Transaction currentTransactionRoot;
    }

    /**
     * Initialize local data structures.
     */
    TransactionQueue() {
        this.committedTransactions = new CopyOnWriteArrayList<Transaction>();
        this.isolatedTransactions = new ThreadLocal<IsolatedTransaction>();
        this.transactionPersistence = null;
    }

    public TransactionQueue(TransactionPersistence transactionPersistence) {
        this.committedTransactions = transactionPersistence.loadTransactions();
        this.isolatedTransactions = new ThreadLocal<IsolatedTransaction>();
        this.transactionPersistence = transactionPersistence;
    }

    List<Transaction> getCommittedTransactions() {
        synchronized (committedTransactions) {
            List<Transaction> committedTransactions = new ArrayList<Transaction>(this.committedTransactions);
            //this.committedTransactions.clear();
            return committedTransactions;
        }
    }

    protected IsolatedTransaction getIsolatedTransaction() {
        return isolatedTransactions.get();
    }

    protected IsolatedTransaction getOrCreateIsolatedTransaction() {
        IsolatedTransaction isolatedTransaction = isolatedTransactions.get();
        if (isolatedTransaction != null)
            return isolatedTransaction;

        isolatedTransaction = new IsolatedTransaction();
        isolatedTransactions.set(isolatedTransaction);
        return isolatedTransaction;
    }

    protected void removeIsolatedTransaction() {
        isolatedTransactions.remove();
    }

    void removeCommittedTransaction(Transaction transaction) {
        this.committedTransactions.remove(transaction);
        if (transactionPersistence != null) {
            transactionPersistence.removeTransaction(transaction);
        }
    }

    /**
     * Checks if in transaction.
     * 
     * @return True if in a transaction, false otherwise.
     */
    boolean inTransaction() {
        IsolatedTransaction isolatedTransaction = getIsolatedTransaction();
        return isolatedTransaction != null && isolatedTransaction.currentTransaction != null;
    }

    /**
     * Clears the queue, removing all stored transactions.
     */
    void clear() {
        this.committedTransactions.clear();
        if (this.transactionPersistence != null) {
            this.transactionPersistence.clear();
        }
        removeIsolatedTransaction();
    }

    /**
     * create a new Transaction, if currentTransaction is not null, set it to the child of the curentTransaction, and set the currentTransaction to point to the
     * new Transaction, and set parentTransaction pointer of new transaction
     * 
     * @param preconditions
     *            The precondition(s) associated with this transaction that must be valid for this transaction to succeed.
     */
    void begin(Set<IPrecondition> preconditions) {
        IsolatedTransaction isolatedTransaction = getOrCreateIsolatedTransaction();

        Transaction newTransaction = new Transaction(preconditions);
        if (isolatedTransaction.currentTransaction == null) {
            isolatedTransaction.currentTransaction = newTransaction;
            isolatedTransaction.currentTransactionRoot = isolatedTransaction.currentTransaction;
        } else {
            isolatedTransaction.currentTransaction.childTransaction = newTransaction;
            newTransaction.parentTransaction = isolatedTransaction.currentTransaction;
            isolatedTransaction.currentTransaction = newTransaction;
        }
    }

    void begin(IPrecondition precondition) {
        Set<IPrecondition> preconditions = new HashSet<IPrecondition>();
        preconditions.add(precondition);
        begin(preconditions);
    }

    /**
     * create a new transaction with no preconditions.
     */
    void begin() {
        begin(new HashSet<IPrecondition>());
    }

    /**
     * if currentTransaction.parentTransaction and currentTransaction.previousTransaction are 'both' null, move the currentTransaction to the
     * committedTransactions list, and set currentTransaction to null. Otherwise, set currentTransaction to the parent of the previous-most sibling of
     * currentTransaction. If a parent is found, create a sibling for the parent. Set the next pointer of the sibling to the parent, and the prev pointer of the
     * parent to the sibling. Finally set the currentTransaction to point to the new sibling. If a parent is not found, that means we have committed a sibling
     * of the top-level transaction, which means we are committing the top-level transaction itself, so queue the transaction.
     * 
     * @return return whether or not a full transaction tree has been committed.
     * 
     * @throws AnzoException
     *             Throws error if no matching begin call has already been made within the same thread context.
     */
    boolean commit() {
        IsolatedTransaction isolatedTransaction = getOrCreateIsolatedTransaction();

        if (isolatedTransaction.currentTransaction == null) {
            return false;
        }

        boolean transactionComplete = false;

        if (isolatedTransaction.currentTransaction.parentTransaction == null && isolatedTransaction.currentTransaction.previousTransaction == null) {
            if (!isolatedTransaction.currentTransaction.isEmpty()) {
                synchronized (committedTransactions) {
                    this.committedTransactions.add(isolatedTransaction.currentTransaction);
                }
                if (this.transactionPersistence != null) {
                    this.transactionPersistence.saveTransaction(isolatedTransaction.currentTransaction);
                }
            }
            transactionComplete = true;
            removeIsolatedTransaction();
        } else {
            // find the parent.  We walk back the prev-trans chain until it ends.  
            while (isolatedTransaction.currentTransaction.previousTransaction != null) {
                isolatedTransaction.currentTransaction = isolatedTransaction.currentTransaction.previousTransaction;
            }
            if (isolatedTransaction.currentTransaction.parentTransaction != null) {
                Transaction newSibling = new Transaction(Collections.<IPrecondition> emptySet());
                newSibling.previousTransaction = isolatedTransaction.currentTransaction.parentTransaction;
                isolatedTransaction.currentTransaction.parentTransaction.nextTransaction = newSibling;
                isolatedTransaction.currentTransaction = newSibling;
            } else {
                if (!isolatedTransaction.currentTransaction.isEmpty()) {
                    synchronized (committedTransactions) {
                        this.committedTransactions.add(isolatedTransaction.currentTransaction);
                    }
                    if (this.transactionPersistence != null) {
                        this.transactionPersistence.saveTransaction(isolatedTransaction.currentTransaction);
                    }
                }
                transactionComplete = true;
                removeIsolatedTransaction();
            }
        }
        return transactionComplete;
    }

    /**
     * simply set currentTransaction to the parent of the previous most sibling of currentTransaction, Note that the previous-most sibling may be us and so go
     * directly to parentTransaction. If the previous most sibling has no parent, then we aborting a sibling of the top-level transaction, i.e. we are aborting
     * the top-level transaction
     * 
     * @throws AnzoException
     *             Throws error if no matching begin call has already been made within the same thread context.
     */
    void abort() {
        IsolatedTransaction isolatedTransaction = getOrCreateIsolatedTransaction();

        if (isolatedTransaction.currentTransaction == null) {
            return;
        }

        if (isolatedTransaction.currentTransaction.parentTransaction == null && isolatedTransaction.currentTransaction.previousTransaction == null) {
            removeIsolatedTransaction();
        } else {
            // find the parent.  We walk back the prev-trans chain until it ends.  
            while (isolatedTransaction.currentTransaction.previousTransaction != null) {
                isolatedTransaction.currentTransaction = isolatedTransaction.currentTransaction.previousTransaction;
            }
            if (isolatedTransaction.currentTransaction.parentTransaction != null) {
                isolatedTransaction.currentTransaction = isolatedTransaction.currentTransaction.parentTransaction;
            } else {
                removeIsolatedTransaction();
            }
        }
    }

    INamedGraph getTransactionContext() {
        IsolatedTransaction isolatedTransaction = getOrCreateIsolatedTransaction();
        if (isolatedTransaction.currentTransaction == null) {
            return null;
        }
        return isolatedTransaction.currentTransaction.getContext();
    }

    /**
     * Add a single statement or multiple statements to the currentTransaction.
     * 
     * @param statements
     *            Statements added to the currentTransaction.
     */
    void add(Statement... statements) {
        IsolatedTransaction isolatedTransaction = getOrCreateIsolatedTransaction();

        if (isolatedTransaction.currentTransaction == null) {
            // it is the TransactionProxy's responsibility to make sure we have a transaction
            throw new Error("Transaction queue not in transaction");
        } else {
            isolatedTransaction.currentTransaction.add(statements);
        }
    }

    /**
     * Remove a single statement or multiple statements from the currentTransaction
     * 
     * @param statements
     *            Statements removed from the currentTransaction.
     */
    void remove(Statement... statements) {
        IsolatedTransaction isolatedTransaction = getOrCreateIsolatedTransaction();

        if (isolatedTransaction.currentTransaction == null) {
            // it is the TransactionProxy's responsibility to make sure we have a transaction
            throw new Error("Transaction queue not in transaction");
        } else {
            isolatedTransaction.currentTransaction.remove(statements);
        }
    }

    /**
     * Filter the given Set of Statement on the additions and deletions in every Transaction. The quad pattern arguments act as a hint to narrow the filtering.
     * In particular, every Statement in statements is guaranteed to conform to the given quad pattern.
     * 
     * @param statements
     *            Set of statements that are to be filtered.
     * @param subject
     *            Subject of the quad pattern used to filter the given statements.
     * @param predicate
     *            Predicate of the quad pattern used to filter the given statements.
     * @param object
     *            Object of the quad pattern used to filter the given statements.
     * @param namedGraphUris
     *            Named graph uri of the quad pattern used to filter the given statements.
     */
    void filter(final Collection<Statement> statements, final Resource subject, final URI predicate, final Value object, final URI... namedGraphUris) {
        IsolatedTransaction isolatedTransaction = getOrCreateIsolatedTransaction();

        Transaction.MapFunction mapFunction = new Transaction.MapFunction() {
            public void call(Transaction transaction) {
                transaction.filter(statements, subject, predicate, object, namedGraphUris);
            }
        };

        for (Transaction transaction : committedTransactions) {
            transaction.walkTransactionTree(mapFunction);
        }
        if (isolatedTransaction.currentTransaction != null) {
            isolatedTransaction.currentTransactionRoot.walkTransactionTree(mapFunction);
        }

    }
}
