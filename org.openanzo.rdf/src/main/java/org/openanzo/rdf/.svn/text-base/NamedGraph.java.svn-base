/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/ContainerNamedGraph.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  4/27/2005
 * Revision:	$Id: ContainerNamedGraph.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;

import org.openanzo.exceptions.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NamedGraph class is a graph that provides an INamedGraph interface around statements within an IQuadStore
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class NamedGraph implements INamedGraph {
    private static final long                                          serialVersionUID = -8380133875482128495L;

    private final static Logger                                        log              = LoggerFactory.getLogger(NamedGraph.class);

    /** Parent IContainer containing statements */
    final IQuadStore                                                   quadStore;

    /** URI of NamedGraph */
    private final URI                                                  namedGraphUri;

    private boolean                                                    closed           = false;

    protected boolean                                                  notifyAddRemove  = true;

    /** Graph listeners */
    private final CopyOnWriteArraySet<IStatementListener<INamedGraph>> listeners        = new CopyOnWriteArraySet<IStatementListener<INamedGraph>>();

    /**
     * Create new ContainerNamedGraph backed by given container
     * 
     * @param quadStore
     *            Parent quadStore holding statements
     * @param namedGraphUri
     *            URI of NamedGraph
     */
    public NamedGraph(URI namedGraphUri, IQuadStore quadStore) {
        this.quadStore = quadStore;
        if (this.quadStore == null) {
            throw new RuntimeException("Null QuadStore");
        }
        this.namedGraphUri = namedGraphUri;
    }

    /**
     * New namededgraph with URI backed by a memquadstore
     * 
     * @param namedGraphUri
     *            uri for namedgraph
     */
    public NamedGraph(URI namedGraphUri) {
        this.namedGraphUri = namedGraphUri;
        this.quadStore = new MemQuadStore();
    }

    /**
     * Clear will remove the statements for this NamedGraph from the parent container
     */
    public void clear() {
        remove(find(null, null, null));
    }

    public URI getNamedGraphUri() {
        return namedGraphUri;
    }

    public void add(Resource subj, URI pred, Value obj) {
        checkClosed();
        add(new Statement(subj, pred, obj, getNamedGraphUri()));
    }

    public void remove(Resource subj, URI pred, Value obj) {
        checkClosed();
        if (subj == null || pred == null || obj == null) {
            remove(find(subj, pred, obj));
        } else {
            remove(new Statement(subj, pred, obj, getNamedGraphUri()));
        }
    }

    public void add(Statement... stmts) {
        checkClosed();

        boolean foundMismatchGraph = false;
        for (Statement stmt : stmts) {
            if (stmt.getNamedGraphUri() == null || !stmt.getNamedGraphUri().equals(getNamedGraphUri())) {
                foundMismatchGraph = true;
                break;
            }
        }

        Statement[] stmtsArray = stmts;
        if (foundMismatchGraph) {
            ArrayList<Statement> statements = new ArrayList<Statement>(stmts.length);
            for (Statement stmt : stmts) {
                if (stmt.getNamedGraphUri() == null || !stmt.getNamedGraphUri().equals(getNamedGraphUri())) {
                    foundMismatchGraph = true;
                    stmt = new Statement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), getNamedGraphUri());
                }
                statements.add(stmt);
            }
            stmtsArray = new Statement[statements.size()];
            statements.toArray(stmtsArray);
        }

        quadStore.add(stmtsArray);
        if (notifyAddRemove) {
            notifyAddStatements(stmtsArray);
        }
    }

    public boolean contains(Resource subj, URI prop, Value obj) {
        checkClosed();
        return quadStore.contains(subj, prop, obj, namedGraphUri);
    }

    public boolean contains(Statement statement) {
        checkClosed();
        return quadStore.contains(statement.getSubject(), statement.getPredicate(), statement.getObject(), namedGraphUri);
    }

    public void remove(Statement... stmts) {
        checkClosed();
        ArrayList<Statement> statements = new ArrayList<Statement>();
        for (Statement stmt : stmts) {
            if (stmt.getNamedGraphUri() == null || !stmt.getNamedGraphUri().equals(getNamedGraphUri())) {
                stmt = new Statement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), getNamedGraphUri());
            }
            statements.add(stmt);
        }
        quadStore.remove(statements.toArray(new Statement[0]));
        if (notifyAddRemove) {
            notifyRemoveStatements(statements.toArray(new Statement[0]));
        }
    }

    public void add(Collection<Statement> statements) {
        checkClosed();
        for (Statement statement : statements) {
            add(statement);
        }
    }

    public void remove(Collection<Statement> statements) {
        checkClosed();
        for (Statement statement : statements) {
            remove(statement);
        }
    }

    public Collection<Statement> find(Resource subj, URI prop, Value obj) {
        checkClosed();
        return quadStore.find(subj, prop, obj, namedGraphUri);
    }

    public Collection<Statement> getStatements() {
        checkClosed();
        return quadStore.find(null, null, null, getNamedGraphUri());
    }

    public int size() {
        checkClosed();
        return quadStore.size(getNamedGraphUri());
    }

    public boolean isEmpty() {
        checkClosed();
        return size() == 0;
    }

    public boolean isClosed() {
        return closed;
    }

    public void close() {
        closed = true;
    }

    /**
     * Determine whether IStatementListeners registere with this graph are automatically notified on statement add and remove calls, or whether notify must be
     * explicitly called. By default, this automatic notification is enabled.
     * 
     * @param notifyAddRemove
     */
    public void setNotifyAddRemove(boolean notifyAddRemove) {
        this.notifyAddRemove = notifyAddRemove;
    }

    public void registerListener(IStatementListener<INamedGraph> listener) {
        checkClosed();
        listeners.add(listener);
    }

    public void unregisterListener(IStatementListener<INamedGraph> listener) {
        checkClosed();
        listeners.remove(listener);
    }

    public void notifyAddStatements(Statement... statements) {
        checkClosed();
        for (IStatementListener<INamedGraph> listener : listeners) {
            try {
                listener.statementsAdded(this, statements);
            } catch (Throwable t) {
                if (log.isWarnEnabled()) {
                    log.warn(LogUtils.GLITTER_MARKER, "Error notifying listeners", t);
                }
            }
        }
    }

    public void notifyRemoveStatements(Statement... statements) {
        checkClosed();
        for (IStatementListener<INamedGraph> listener : listeners) {
            try {
                listener.statementsRemoved(this, statements);
            } catch (Throwable t) {
                if (log.isWarnEnabled()) {
                    log.warn(LogUtils.GLITTER_MARKER, "Error notifying listeners", t);
                }
            }
        }
    }

    protected void checkClosed() {
        if (closed) {
            throw new RuntimeException("Graph is closed");
        }
    }

}
