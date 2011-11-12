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

import org.openanzo.exceptions.AnzoException;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.serialization.INamedGraphUpdateHandler;

/**
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class ReplicaUpdater implements INamedGraphUpdateHandler {

    enum Type {
        REPLICATION, NAMED_GRAPH_UPDATE
    }

    private final AnzoClient client;

    private final IQuadStore replicaQuadStore;

    private final Type       type;

    ReplicaUpdater(IQuadStore replicaQuadStore, AnzoClient client, Type type) {
        this.replicaQuadStore = replicaQuadStore;
        this.client = client;
        this.type = type;
    }

    public void start() throws AnzoException {
    }

    public void end() throws AnzoException {
    }

    /**
     * revision is defined only if this is called from the Named graph update mechanism
     */
    public boolean handleNamedGraphUpdate(INamedGraphUpdate update) throws AnzoException {
        ClientGraph replicaGraph = null;
        ClientGraph serverGraph = null;
        boolean replicaInSync = true;
        URI namedGraphUri = update.getNamedGraphURI();
        try {
            client.clientLock.lockInterruptibly();
            try {
                replicaGraph = client.replicaGraphTable.get(namedGraphUri);
                if (replicaGraph != null) {
                    long currentRevision = replicaGraph.getRevision();
                    if (currentRevision != -1) {
                        if (currentRevision >= update.getRevision()) {
                            client.replicaGraphTable.release(namedGraphUri);
                            replicaGraph = null; // signal that everything is ok, but no need for us to update
                            replicaInSync = true;
                        } else if (type == Type.NAMED_GRAPH_UPDATE && currentRevision < update.getRevision() - 1) {
                            client.replicaGraphTable.release(namedGraphUri);
                            replicaGraph = null; // signal that our replica is too out of date to process this update
                            replicaInSync = false;
                        }
                    }
                }
                serverGraph = client.serverGraphTable.get(namedGraphUri);
                if (serverGraph != null) {
                    long currentRevision = serverGraph.getRevision();
                    if (currentRevision >= update.getRevision()) {
                        client.serverGraphTable.release(namedGraphUri);
                        serverGraph = null; // signal that everything is ok, but no need for us to update
                    }
                }
                INamedGraph replicaMeta = (replicaGraph != null) ? replicaGraph.getMetadataGraph() : null;
                INamedGraph serverMeta = (serverGraph != null) ? serverGraph.getMetadataGraph() : null;
                if (replicaMeta != null) {
                    NamedGraph namedGraph = AnzoFactory.getNamedGraph(namedGraphUri, replicaMeta);
                    Boolean revisioned = namedGraph.getRevisioned();
                    if (type == Type.NAMED_GRAPH_UPDATE || (revisioned != null && revisioned == true)) {
                        this.removeStatements(update.getMetaRemovals(), replicaMeta);
                        this.removeStatements(update.getRemovals(), replicaGraph);
                    } else {
                        this.replicaQuadStore.remove(null, null, null, namedGraphUri);
                        this.replicaQuadStore.remove(null, null, null, replicaMeta.getNamedGraphUri());
                    }
                    this.addStatements(update.getMetaAdditions(), replicaMeta);
                    this.addStatements(update.getAdditions(), replicaGraph);
                }
                this.notifyRemoveStatements(update.getMetaRemovals(), replicaMeta, serverMeta);
                this.notifyRemoveStatements(update.getRemovals(), replicaGraph, serverGraph);
                this.notifyAddStatements(update.getMetaAdditions(), replicaMeta, serverMeta);
                this.notifyAddStatements(update.getAdditions(), replicaGraph, serverGraph);
                if (replicaGraph != null) {
                    replicaGraph.setRevision(update.getRevision());
                }
                if (serverGraph != null) {
                    serverGraph.setRevision(update.getRevision());
                }
                return replicaInSync;
            } finally {
                if (replicaGraph != null) {
                    client.replicaGraphTable.release(namedGraphUri);
                }
                if (serverGraph != null) {
                    client.serverGraphTable.release(namedGraphUri);
                }
                client.clientLock.unlock();
            }
        } catch (InterruptedException ie) {
            return false;
        }
    }

    private void addStatements(Collection<Statement> stmts, INamedGraph replicaGraph) {
        if (stmts.size() == 0) {
            return;
        }
        replicaQuadStore.add(stmts);
    }

    private void removeStatements(Collection<Statement> stmts, INamedGraph replicaGraph) {
        if (stmts.size() == 0) {
            return;
        }
        replicaQuadStore.remove(stmts);
    }

    private void notifyAddStatements(Collection<Statement> stmts, INamedGraph replicaGraph, INamedGraph serverGraph) {
        if (stmts.size() == 0) {
            return;
        }
        if (replicaGraph != null) {
            replicaGraph.notifyAddStatements(stmts.toArray(new Statement[0]));
        }
        if (serverGraph != null) {
            serverGraph.notifyAddStatements(stmts.toArray(new Statement[0]));
        }
    }

    private void notifyRemoveStatements(Collection<Statement> stmts, INamedGraph replicaGraph, INamedGraph serverGraph) {
        if (stmts.size() == 0) {
            return;
        }

        if (replicaGraph != null) {
            replicaGraph.notifyRemoveStatements(stmts.toArray(new Statement[0]));
        }
        if (serverGraph != null) {
            serverGraph.notifyRemoveStatements(stmts.toArray(new Statement[0]));
        }
    }

}
