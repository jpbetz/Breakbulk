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
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.AnzoGraph;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.SerializationConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Implementation for graphs replicated to the client. AnzoClient.getReplicaGraph or AnzoClientGraph.getServerGraph should be called to construct a new
 * ClientGraph.
 * 
 * If the entire graph is tracked, replication will update the AnzoClient with all the statements in the server's graph, otherwise only the tracked statements
 * will be in the local cache and non-tracked statements will not appear in find requests against the ClientGraph.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 */
public class ClientGraph extends AnzoGraph {
    /**
     * 
     */
    private static final long                serialVersionUID = 3892574383524913306L;

    private static final Logger              log              = LoggerFactory.getLogger(ClientGraph.class);

    // The anzo client that manages this graph.
    final AnzoClient                         anzoClient;

    // The graph table to use to close this graph
    final GraphTable                         graphTable;

    protected boolean                        connected        = false;

    protected final INamedGraphInitializer[] namedGraphInitializers;

    protected long                           revision         = -1;

    /**
     * create a new AnzoGraph instance. This constructor should not be explicitly called. Instances of AnzoGraph are handed out by the anzoClient
     * 
     * @param namedGraphUri
     *            The uri of the named graph
     * @param store
     *            Optional store used to store the statements of this graph.
     * @param metadataGraph
     *            The metadata graph that holds system information about this graph.
     * @param anzoClient
     *            The anzo client that manages this graph.
     */
    ClientGraph(URI namedGraphUri, IQuadStore store, INamedGraph metadataGraph, AnzoClient anzoClient, GraphTable graphTable, INamedGraphInitializer... graphInitializers) {
        super(namedGraphUri, metadataGraph, store);
        this.anzoClient = anzoClient;
        this.graphTable = graphTable;
        notifyAddRemove = false;
        this.namedGraphInitializers = (graphInitializers != null) ? graphInitializers : new INamedGraphInitializer[0];
    }

    @Override
    protected void checkClosed() {
        super.checkClosed();
        if (graphTable.type == GraphTable.Type.SERVER && !anzoClient.isConnected()) {
            throw new AnzoRuntimeException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }
    }

    @Override
    public void add(Collection<Statement> statements) {
        boolean inTransaction = anzoClient.inTransaction();
        if (!inTransaction)
            anzoClient.begin();

        try {
            super.add(statements);

        } catch (RuntimeException e) {
            if (!inTransaction)
                anzoClient.abort();
            throw new RuntimeException(e);
        }
        if (!inTransaction)
            anzoClient.commit();
    }

    @Override
    public void add(Statement... stmts) {
        boolean inTransaction = anzoClient.inTransaction();
        if (!inTransaction)
            anzoClient.begin();

        try {
            super.add(stmts);

        } catch (RuntimeException e) {
            if (!inTransaction)
                anzoClient.abort();
            throw new RuntimeException(e);
        }
        if (!inTransaction)
            anzoClient.commit();
    }

    @Override
    public void remove(Collection<Statement> statements) {
        boolean inTransaction = anzoClient.inTransaction();
        if (!inTransaction)
            anzoClient.begin();

        try {
            super.remove(statements);

        } catch (RuntimeException e) {
            if (!inTransaction)
                anzoClient.abort();
            throw new RuntimeException(e);
        }
        if (!inTransaction)
            anzoClient.commit();
    }

    @Override
    public void remove(Statement... stmts) {
        boolean inTransaction = anzoClient.inTransaction();
        if (!inTransaction)
            anzoClient.begin();

        try {
            super.remove(stmts);

        } catch (RuntimeException e) {
            if (!inTransaction)
                anzoClient.abort();
            throw new RuntimeException(e);
        }
        if (!inTransaction)
            anzoClient.commit();
    }

    /**
     * Close the graph.
     */
    @Override
    public void close() {
        anzoClient.clientLock.lock();
        try {
            GraphTable.ReleaseResult result = graphTable.release(getNamedGraphUri());
            if (result.equals(GraphTable.ReleaseResult.CLOSE_ALL)) {
                doClose();
            } else if (result.equals(GraphTable.ReleaseResult.CLOSE_INSTANCE)) {
                super.close();
            }
        } finally {
            anzoClient.clientLock.unlock();
        }
    }

    void doClose() {
        try {
            metadataGraph.close();
            // if (anzoClient.isConnected()) {
            if (!anzoClient.replicaGraphTable.contains(getNamedGraphUri()) && !anzoClient.serverGraphTable.contains(getNamedGraphUri())) {
                Collection<Statement> stmts = anzoClient.quadStore.find(getNamedGraphUri(), NamedGraph.uuidProperty, null, getMetadataGraph().getNamedGraphUri());
                if (!stmts.isEmpty()) {
                    Statement stmt = stmts.iterator().next();
                    anzoClient.namedGraphUpdateManager.removeNamedGraphUpdateTopic((URI) stmt.getObject());
                }
                // we have to clear the quad store for both replica and server
                // graphs because server graphs store the uuid in the quad store.
                //if (graphTable.type.equals(Type.REPLICA)) {
                anzoClient.quadStore.remove(null, null, null, getNamedGraphUri());
                anzoClient.quadStore.remove(null, null, null, metadataGraph.getNamedGraphUri());
                //}
            }
            //  }

        } catch (AnzoException ae) {
            throw new AnzoRuntimeException(ae);
        } finally {
            super.close();
        }

    }

    /**
     * @return the revision
     */
    public long getRevision() {
        return revision;
    }

    /**
     * @param revision
     *            the revision to set
     */
    public void setRevision(long revision) {
        this.revision = revision;
    }

    @Override
    public void registerListener(IStatementListener<INamedGraph> listener) {
        Set<IStatementListener<INamedGraph>> listeners = graphTable.listeners.get(getNamedGraphUri());
        if (listeners == null) {
            listeners = new CopyOnWriteArraySet<IStatementListener<INamedGraph>>();
            graphTable.listeners.put(getNamedGraphUri(), listeners);
        }
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(IStatementListener<INamedGraph> listener) {
        Set<IStatementListener<INamedGraph>> listeners = graphTable.listeners.get(getNamedGraphUri());
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    @Override
    public void notifyAddStatements(Statement... statements) {
        if (anzoClient.getUserDescription() != null) {
            MDC.put(SerializationConstants.userDescription, anzoClient.getUserDescription());
        }
        try {
            Set<IStatementListener<INamedGraph>> listeners = graphTable.listeners.get(getNamedGraphUri());
            if (listeners != null) {
                for (IStatementListener<INamedGraph> listener : listeners) {
                    try {
                        listener.statementsAdded(this, statements);
                    } catch (Throwable t) {
                        if (log.isWarnEnabled()) {
                            log.warn(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CLIENT.FAILED_NOTIFYING_ADD_STATEMENTS, listener.getClass().getName()), t);
                        }
                    }
                }
            }
        } finally {
            if (anzoClient.getUserDescription() != null) {
                MDC.remove(SerializationConstants.userDescription);
            }
        }
    }

    @Override
    public void notifyRemoveStatements(Statement... statements) {
        if (anzoClient.getUserDescription() != null) {
            MDC.put(SerializationConstants.userDescription, anzoClient.getUserDescription());
        }
        try {
            Set<IStatementListener<INamedGraph>> listeners = graphTable.listeners.get(getNamedGraphUri());
            if (listeners != null) {
                for (IStatementListener<INamedGraph> listener : listeners) {
                    try {
                        listener.statementsRemoved(this, statements);
                    } catch (Throwable t) {
                        if (log.isWarnEnabled()) {
                            log.warn(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CLIENT.FAILED_NOTIFYING_REMOVE_STATEMENTS, listener.getClass().getName()), t);
                        }
                    }
                }
            }
        } finally {
            if (anzoClient.getUserDescription() != null) {
                MDC.remove(SerializationConstants.userDescription);
            }
        }
    }

}
