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

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Simple NamedGraph extension used for linking listeners between isolated metadata graphs.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 */
public class MetadataGraph extends org.openanzo.rdf.NamedGraph {

    private static final long   serialVersionUID = -6399862428861812901L;

    private final static Logger log              = LoggerFactory.getLogger(MetadataGraph.class);

    private final GraphTable    graphTable;

    MetadataGraph(URI namedGraphUri, IQuadStore quadStore, GraphTable graphTable) {
        super(namedGraphUri, quadStore);
        this.graphTable = graphTable;
    }

    @Override
    public void registerListener(IStatementListener<INamedGraph> listener) {
        Set<IStatementListener<INamedGraph>> listeners = graphTable.metaListeners.get(getNamedGraphUri());
        if (listeners == null) {
            listeners = new CopyOnWriteArraySet<IStatementListener<INamedGraph>>();
            graphTable.metaListeners.put(getNamedGraphUri(), listeners);
        }
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(IStatementListener<INamedGraph> listener) {
        Set<IStatementListener<INamedGraph>> listeners = graphTable.metaListeners.get(getNamedGraphUri());
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    @Override
    public void notifyAddStatements(Statement... statements) {
        Set<IStatementListener<INamedGraph>> listeners = graphTable.metaListeners.get(getNamedGraphUri());
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
    }

    @Override
    public void notifyRemoveStatements(Statement... statements) {
        Set<IStatementListener<INamedGraph>> listeners = graphTable.metaListeners.get(getNamedGraphUri());
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
    }

}
