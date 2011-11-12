/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 29, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.util.Collection;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IServerQuadStore;
import org.openanzo.datasource.IServerQuadStoreProvider;
import org.openanzo.datasource.services.BaseUpdateService;
import org.openanzo.datasource.update.MultiStageUpdatesProcessor;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.IAuthorizationEventListener;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.serialization.IUpdatesHandler;
import org.openanzo.services.serialization.IUpdatesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NodeCentric implementation of the IUpdateService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class NodeCentricUpdateService extends BaseUpdateService implements IServerQuadStoreProvider {
    private static final Logger                     log               = LoggerFactory.getLogger(NodeCentricUpdateService.class);

    private final NodeCentricDatasource             datasource;

    private Collection<IAuthorizationEventListener> aclEventListeners = null;

    protected NodeCentricUpdateService(NodeCentricDatasource datasource) {
        this.datasource = datasource;
    }

    public IDatasource getDatasource() {
        return datasource;
    }

    @Override
    public void start() throws AnzoException {
        this.aclEventListeners = datasource.getAclEventListeners();
    }

    @Override
    protected IUpdates updateInternal(IOperationContext context, boolean returnResults, IUpdates updates) throws AnzoException {
        NodeCentricOperationContext connectionContext = null;
        try {
            connectionContext = datasource.getWriteContext(context);
            IUpdates updateResults = MultiStageUpdatesProcessor.update(connectionContext, new DispatchingDeltaQuadStore(connectionContext, datasource.getInstanceURI(), datasourceUpdateResultListeners), datasource.getQueryService(), datasource.getAuthorizationService(), aclEventListeners, updates, false);
            return updateResults;
        } finally {
            if (connectionContext != null) {
                datasource.returnWriteContext(connectionContext);
            }
        }
    }

    @Override
    protected IUpdates updateInternal(IOperationContext context, boolean returnResults, IUpdatesReader reader, IUpdatesHandler writer) throws AnzoException {
        long start = System.currentTimeMillis();
        NodeCentricOperationContext connectionContext = null;
        try {
            connectionContext = datasource.getWriteContext(context);

            IUpdates updateResults = null;
            updateResults = MultiStageUpdatesProcessor.update(connectionContext, new DispatchingDeltaQuadStore(connectionContext, datasource.getInstanceURI(), datasourceUpdateResultListeners), datasource.getQueryService(), datasource.getAuthorizationService(), aclEventListeners, reader, false);

            writer.start();
            for (IUpdateTransaction update : updateResults.getTransactions()) {
                writer.handleTransaction(update);
            }
            writer.end();

            long end = System.currentTimeMillis();
            if (log.isDebugEnabled()) {
                if (end - start > 0) {
                    Integer countA = context.getAttribute("countAdd", Integer.class);
                    Integer countR = context.getAttribute("countRemove", Integer.class);
                    if (countA == null)
                        countA = Integer.valueOf(0);
                    if (countR == null)
                        countR = Integer.valueOf(0);
                    log.debug(LogUtils.RDB_MARKER, "[UPDATE REPOSITORY] {}: Adds {} [{} q/ms]: Removes {} [{} q/ms]", new Object[] { (end - start), countA, ((countA > 0) ? (countA / (end - start)) : 0), countR, ((countR > 0) ? (countR / (end - start)) : 0) });
                }
            }
            return updateResults;
        } finally {
            if (connectionContext != null) {
                datasource.returnWriteContext(connectionContext);
            }
        }
    }

    @Override
    protected IUpdates importStatementsInternal(IOperationContext context, MultiMap<URI, Statement> statements, Collection<Statement> graphTemplate) throws AnzoException {
        long start = System.currentTimeMillis();
        NodeCentricOperationContext connectionContext = null;
        try {
            connectionContext = (context instanceof NodeCentricOperationContext) ? (NodeCentricOperationContext) context : datasource.getWriteContext(context);
            Boolean resetting = context.getAttribute("resetting", Boolean.class);
            IUpdates updateResults = MultiStageUpdatesProcessor.update(connectionContext, new DispatchingDeltaQuadStore(connectionContext, datasource.getInstanceURI(), datasourceUpdateResultListeners), datasource.getQueryService(), datasource.getAuthorizationService(), aclEventListeners, statements, graphTemplate, resetting != null ? resetting.booleanValue() : false, true);
            long end = System.currentTimeMillis();
            if (log.isDebugEnabled()) {
                if (end - start > 0) {
                    Integer countA = context.getAttribute("countAdd", Integer.class);
                    Integer countR = context.getAttribute("countRemove", Integer.class);
                    if (countA == null)
                        countA = Integer.valueOf(0);
                    if (countR == null)
                        countR = Integer.valueOf(0);
                    log.debug(LogUtils.RDB_MARKER, "[IMPORT REPOSITORY] {}: Adds {} [{} q/ms]: Removes {} [{} q/ms]", new Object[] { (end - start), countA, ((countA > 0) ? (countA / (end - start)) : 0), countR, ((countR > 0) ? (countR / (end - start)) : 0) });
                }
            }
            return updateResults;
        } finally {
            if (connectionContext != null && !(context instanceof NodeCentricOperationContext)) {
                datasource.returnWriteContext(connectionContext);
            }
        }
    }

    public IServerQuadStore getServerQuadStore(IOperationContext context) throws AnzoException {
        NodeCentricOperationContext connectionContext = null;
        connectionContext = (context instanceof NodeCentricOperationContext) ? (NodeCentricOperationContext) context : datasource.getWriteContext(context);
        return new DispatchingDeltaQuadStore(connectionContext, datasource.getInstanceURI(), datasourceUpdateResultListeners);
    }

    public void closeServerQuadStore(IServerQuadStore store) throws AnzoException {
        datasource.returnWriteContext((NodeCentricOperationContext) store.getContext());

    }
}
