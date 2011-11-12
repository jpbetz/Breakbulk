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

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openanzo.client.Transaction.MapFunction;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.ontologies.persistence.ClientPersistenceFactory;
import org.openanzo.ontologies.persistence.ClientPersistenceRoot;
import org.openanzo.ontologies.persistence.PersistedPrecondition;
import org.openanzo.ontologies.persistence.PersistedTransaction;
import org.openanzo.ontologies.persistence.ReferencedNamedGraph;
import org.openanzo.ontologies.persistence.ReferencedQuadStore;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.jastor.Thing;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.impl.AskResult;
import org.openanzo.services.impl.Precondition;

/**
 * Manages persistence of the AnzoClient's trackers, transactions and replication markers.
 * 
 * @author Joe Betz
 * 
 */
public class TransactionPersistence {

    // root node of persisted client state
    static final URI                persistenceUri = MemURI.create("http://openanzo.org/reserved/localPersistence");

    protected ClientPersistenceRoot clientStore;

    protected IQuadStore            quadStore;

    public TransactionPersistence(IQuadStore quadStore) {
        this.quadStore = quadStore;
        this.clientStore = ClientPersistenceFactory.createClientPersistenceRoot(persistenceUri, new NamedGraph(persistenceUri, quadStore));
    }

    void clear() {
        quadStore.clear();
    }

    /**
     * Loads all the transactions in the store.
     */
    List<Transaction> loadTransactions() {
        PersistedTransaction current = clientStore.getCommittedTransactions();

        List<Transaction> transactions = new ArrayList<Transaction>();

        Map<URI, Transaction> map = new HashMap<URI, Transaction>();
        LoadTransactionFunction function = new LoadTransactionFunction(this, map);

        while (current != null) {
            walkSavedTransactionTree(function, current);
            Transaction transaction = map.get(current.resource());
            transactions.add(transaction);
            current = current.getNext();
        }

        return transactions;
    }

    /**
     * Removes all transactions from the store.
     */
    void deleteTransactions() {
        quadStore.clear();
    }

    /**
     * Saves the provided transaction to the end of the list of transactions in the store.
     */
    void saveTransaction(Transaction transaction) {
        Map<Transaction, URI> map = new HashMap<Transaction, URI>();
        SaveTransactionFunction mapFunction = new SaveTransactionFunction(this, map);
        transaction.walkTransactionTree(mapFunction);

        URI uri = map.get(transaction);
        if (uri == null) {
            //uri = UriGenerator.generateTransactionURI();
            uri = transaction.transactionUri;
        }

        PersistedTransaction current = clientStore.getCommittedTransactions();

        if (current == null) {
            clientStore.setCommittedTransactions(uri);
        } else {
            PersistedTransaction previous = null;
            while (current != null) {
                previous = current;
                current = current.getNext();
            }
            if (previous != null)
                previous.setNext(uri);

        }
    }

    void removeTransaction(Transaction transaction) {
        removeTransaction(transaction.transactionUri);
    }

    private void removeTransaction(URI transactionUri) {

        PersistedTransaction tran = ClientPersistenceFactory.getPersistedTransaction(transactionUri, new NamedGraph(persistenceUri, quadStore));

        PersistedTransaction nextTran = tran.getNext();

        Collection<Statement> stmts = quadStore.find(null, PersistedTransaction.nextProperty, transactionUri, persistenceUri);
        if (!stmts.isEmpty()) {
            URI prevUri = (URI) stmts.iterator().next().getObject();
            PersistedTransaction prevTran = ClientPersistenceFactory.getPersistedTransaction(prevUri, new NamedGraph(persistenceUri, quadStore));
            if (nextTran != null) {
                prevTran.setNext(nextTran);
            } else {
                prevTran.setNext((PersistedTransaction) null);
            }
        } else {
            if (clientStore.getCommittedTransactions().resource().equals(transactionUri)) {
                if (nextTran != null) {
                    clientStore.setCommittedTransactions(nextTran);
                } else {
                    clientStore.setCommittedTransactions((PersistedTransaction) null);
                }
            }
        }

        Iterable<PersistedPrecondition> preconditions = tran.getPreconditions();
        for (PersistedPrecondition precondition : preconditions) {
            precondition.removeStatements();
        }

        if (tran.getAdditionsStore() != null) {
            removeQuadStore(tran.getAdditionsStore(), quadStore);
        }
        if (tran.getDeletionsStore() != null) {
            removeQuadStore(tran.getDeletionsStore(), quadStore);
        }

        if (tran.getChildTransaction() != null) {
            removeTransaction((URI) tran.getChildTransaction().resource());
        }
        if (tran.getNextTransaction() != null) {
            removeTransaction((URI) tran.getNextTransaction().resource());
        }

        tran.removeStatements();

    }

    private static class SaveTransactionFunction implements MapFunction {
        Map<Transaction, URI>  map;

        TransactionPersistence store;

        public SaveTransactionFunction(TransactionPersistence store, Map<Transaction, URI> map) {
            this.map = map;
            this.store = store;
        }

        public void call(Transaction transaction) {
            store.saveTransactionNode(transaction, map);
        }
    }

    private static class LoadTransactionFunction implements LoadPersistedMapFunction {
        Map<URI, Transaction>  map;

        TransactionPersistence store;

        public LoadTransactionFunction(TransactionPersistence store, Map<URI, Transaction> map) {
            this.map = map;
            this.store = store;
        }

        public void call(PersistedTransaction transaction) {
            store.loadTransaction(transaction, map);
        }
    }

    /**
     * persists the properties of the transaction object, using the provided map to dereference other transaction objects.
     * 
     */
    private URI saveTransactionNode(Transaction transaction, Map<Transaction, URI> map) {
        URI uri = map.get(transaction);
        if (uri == null) {
            //uri = UriGenerator.generateTransactionURI();
            uri = transaction.transactionUri;
            map.put(transaction, uri);
        }
        PersistedTransaction current = ClientPersistenceFactory.createPersistedTransaction(uri, new NamedGraph(persistenceUri, quadStore));

        for (IPrecondition precondition : transaction.getPreconditions()) {
            PersistedPrecondition storedPrecondition = current.addPreconditions();
            if (precondition.getDefaultGraphUris() != null) {
                for (URI graphUri : precondition.getDefaultGraphUris()) {
                    storedPrecondition.addPreconditionDefaultUri(graphUri);
                }
            }
            if (precondition.getNamedGraphUris() != null) {
                for (URI graphUri : precondition.getNamedGraphUris()) {
                    storedPrecondition.addPreconditionNamedGraphUri(graphUri);
                }
            }
            storedPrecondition.setQueryString(precondition.getQuery());

            AskResult result = (AskResult) precondition.getResult();
            if (result != null) {
                storedPrecondition.setAskResult(result.getResultValue());
            }

        }

        if (transaction.previousTransaction != null) {
            URI previousTransactionUri = map.get(transaction.previousTransaction);
            if (previousTransactionUri == null) {
                previousTransactionUri = UriGenerator.generateTransactionURI();
                map.put(transaction.previousTransaction, previousTransactionUri);
            }
            current.setPreviousTransaction(previousTransactionUri);
        }

        if (transaction.nextTransaction != null) {
            URI nextTransactionUri = map.get(transaction.nextTransaction);
            if (nextTransactionUri == null) {
                nextTransactionUri = UriGenerator.generateTransactionURI();
                map.put(transaction.nextTransaction, nextTransactionUri);
            }
            current.setNextTransaction(nextTransactionUri);
        }

        if (transaction.parentTransaction != null) {
            URI parentTransactionUri = map.get(transaction.parentTransaction);
            if (parentTransactionUri == null) {
                parentTransactionUri = UriGenerator.generateTransactionURI();
                map.put(transaction.parentTransaction, parentTransactionUri);
            }
            current.setParentTransaction(parentTransactionUri);
        }

        if (transaction.childTransaction != null) {
            URI childTransactionUri = map.get(transaction.childTransaction);
            if (childTransactionUri == null) {
                childTransactionUri = UriGenerator.generateTransactionURI();
                map.put(transaction.childTransaction, childTransactionUri);
            }
            current.setChildTransaction(childTransactionUri);
        }

        StringWriter writer = new StringWriter();
        try {
            ReadWriteUtils.writeStatements(transaction.getContext().getStatements(), writer, RDFFormat.TRIG, null, false);
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }

        current.setTransactionContext(writer.toString());
        current.setTransactionUri(transaction.transactionUri);

        saveQuadStore(transaction.getAdditions(), current.setAdditionsStore(Constants.valueFactory.createBNode()), quadStore);
        saveQuadStore(transaction.getDeletions(), current.setDeletionsStore(Constants.valueFactory.createBNode()), quadStore);

        return uri;
    }

    private Transaction loadTransaction(PersistedTransaction current, Map<URI, Transaction> map) {
        if (map.containsKey(current.resource())) {
            return map.get(current.resource());
        }
        // load the preconditions
        Set<IPrecondition> preconditions = new HashSet<IPrecondition>();
        Iterable<PersistedPrecondition> currentPreconditions = current.getPreconditions();
        for (PersistedPrecondition currentPrecondition : currentPreconditions) {
            Precondition precondition = new Precondition();

            precondition.setResult(currentPrecondition.getAskResult());
            precondition.setQuery(currentPrecondition.getQueryString());

            Set<URI> defaultUris = new HashSet<URI>();
            Iterable<Thing> defaultUri = currentPrecondition.getPreconditionDefaultUri();
            for (Thing uri : defaultUri) {
                defaultUris.add((URI) uri.resource());
            }
            precondition.setDefaultGraphUris(defaultUris);

            Set<URI> namedGraphUris = new HashSet<URI>();
            Iterable<Thing> namedGraphUri = currentPrecondition.getPreconditionNamedGraphUri();
            for (Thing uri : namedGraphUri) {
                namedGraphUris.add((URI) uri.resource());
            }
            precondition.setNamedGraphUris(namedGraphUris);
            preconditions.add(precondition);
        }

        Collection<Statement> adds = loadQuadStore(current.getAdditionsStore(), quadStore);
        Collection<Statement> deletes = loadQuadStore(current.getDeletionsStore(), quadStore);
        Transaction transaction = new Transaction(preconditions, (URI) current.getTransactionUri().resource());
        transaction.additions.add(adds);
        transaction.deletions.add(deletes);
        map.put((URI) current.resource(), transaction);

        PersistedTransaction previous = current.getPreviousTransaction();
        if (previous != null) {
            Transaction previousTransaction = map.get(previous.resource());
            if (previousTransaction == null) {
                previousTransaction = loadTransaction(previous, map);
                map.put((URI) previous.resource(), previousTransaction);
            }
            transaction.previousTransaction = previousTransaction;
        }

        PersistedTransaction next = current.getNextTransaction();
        if (next != null) {
            Transaction nextTransaction = map.get(next.resource());
            if (nextTransaction == null) {
                nextTransaction = loadTransaction(next, map);
                map.put((URI) next.resource(), nextTransaction);
            }
            transaction.nextTransaction = nextTransaction;
        }

        PersistedTransaction parent = current.getParentTransaction();
        if (parent != null) {
            Transaction parentTransaction = map.get(parent.resource());
            if (parentTransaction == null) {
                parentTransaction = loadTransaction(parent, map);
                map.put((URI) parent.resource(), parentTransaction);
            }
            transaction.parentTransaction = parentTransaction;
        }

        PersistedTransaction child = current.getChildTransaction();
        if (child != null) {
            Transaction childTransaction = map.get(child.resource());
            if (childTransaction == null) {
                childTransaction = loadTransaction(child, map);
                map.put((URI) child.resource(), childTransaction);
            }
            transaction.childTransaction = childTransaction;
        }

        String contextString = current.getTransactionContext();
        try {
            Collection<Statement> contextStmts = ReadWriteUtils.readStatements(contextString, RDFFormat.TRIG);
            for (Statement stmt : contextStmts) {
                transaction.getContext().add(stmt);
            }
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }

        return transaction;
    }

    /**
     * HACK: Stores a QuadStore within another QuadStore as a bunch of named graphs. Multiple quad stores may be saved to a single quad store this way even if
     * they share common named graph uris.
     */
    private static void saveQuadStore(Collection<Statement> statements, ReferencedQuadStore referencedStore, IQuadStore destination) {
        Map<URI, NamedGraph> graphs = new HashMap<URI, NamedGraph>();

        for (Statement stmt : statements) {
            URI context = stmt.getNamedGraphUri();
            NamedGraph graph = graphs.get(context);

            if (graph == null) {
                URI graphUri = UriGenerator.generateTransactionURI();
                ReferencedNamedGraph referencedGraph = referencedStore.addNamedGraph(graphUri);
                referencedGraph.setReferenceUri(graphUri);
                referencedGraph.setGraphUri(context);
                graph = new NamedGraph(graphUri, destination);
                graphs.put(context, graph);
            }

            graph.add(stmt);
        }
    }

    /**
     * HACK: Loads a quad store stored within another quad store. See saveQuadStore for details.
     */
    private static Collection<Statement> loadQuadStore(ReferencedQuadStore referencedStore, IQuadStore source) {
        Iterable<ReferencedNamedGraph> addGraphs = referencedStore.getNamedGraph();
        List<Statement> stmts = new ArrayList<Statement>();
        for (ReferencedNamedGraph referencedGraph : addGraphs) {
            URI namedGraphUri = (URI) referencedGraph.getGraphUri().resource();
            Collection<Statement> iterator = source.find(null, null, null, (URI) referencedGraph.getReferenceUri().resource());
            for (Statement stmt : iterator) {
                stmts.add(Constants.valueFactory.createStatement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), namedGraphUri));
            }
        }
        return stmts;
    }

    private static void removeQuadStore(ReferencedQuadStore referencedStore, IQuadStore source) {
        Iterable<ReferencedNamedGraph> addGraphs = referencedStore.getNamedGraph();
        for (ReferencedNamedGraph referencedGraph : addGraphs) {
            URI namedGraphUri = (URI) referencedGraph.getGraphUri().resource();
            source.remove(null, null, null, namedGraphUri);
        }
        referencedStore.removeStatements();
    }

    private interface LoadPersistedMapFunction {
        void call(PersistedTransaction transaction);
    }

    private static void walkSavedTransactionTree(LoadPersistedMapFunction mapFunction, PersistedTransaction root) {
        mapFunction.call(root);
        if (root.getChildTransaction() != null) {
            walkSavedTransactionTree(mapFunction, root.getChildTransaction());
        }
        if (root.getNextTransaction() != null) {
            walkSavedTransactionTree(mapFunction, root.getNextTransaction());
        }
    }
}
