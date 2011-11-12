/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/indexer/IndexUpdateHandler.java,v $
 * Created by:  Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 * Created on:  5/19/2006
 * Revision:	$Id: IndexUpdateHandler.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.IDatasourceComponent;
import org.openanzo.datasource.nodecentric.indexer.ModelIndexer;
import org.openanzo.datasource.nodecentric.indexer.ModelIndexerFactory;
import org.openanzo.datasource.services.BaseDatasourceComponent;
import org.openanzo.datasource.update.ServerQuadStoreUpdateHandler;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.indexer.IndexerException;
import org.openanzo.indexer.IndexerProperties;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Statement;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.serialization.IUpdatesHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler for index updates. Hook it into UpdateResultsHandler.
 * 
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 */
public class NodeCentricIndexUpdateHandler extends BaseDatasourceComponent implements IUpdateResultListener, IDatasourceComponent {

    private static final Logger         log            = LoggerFactory.getLogger(NodeCentricIndexUpdateHandler.class);

    /**
     * True if indexing is turned on.
     */
    protected boolean                   rebuildIndex   = false;

    /**
     * True if indexing is asynchronous.
     */
    private boolean                     isAsynchronous = false;

    ModelIndexer                        indexer        = null;

    private DynamicServiceStats         stats          = new DynamicServiceStats("update", "rebuildIndex");

    /**
     * Executor for asynchronous indexing.
     */
    private ExecutorService             indexExecutor  = null;

    private final NodeCentricDatasource datasource;

    /**
     * Create a new NodeCentricIndexUpdateHandler
     */

    protected NodeCentricIndexUpdateHandler(NodeCentricDatasource datasource) {
        this.datasource = datasource;
    }

    public String getName() {
        return "IndexUpdateHandler";
    }

    public String getDescription() {
        return "Node Centric Index Update Handler for " + datasource.getInstanceId();
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    public IDatasource getDatasource() {
        return this.datasource;
    }

    public void start() throws AnzoException {

        String rebuildIndex = (String) datasource.getConfigurationParameters().get(IndexerProperties.KEY_INDEXER_REBUILD);
        if (rebuildIndex != null) {
            this.rebuildIndex = Boolean.parseBoolean(rebuildIndex);
        }

        String isAsynchronous = (String) datasource.getConfigurationParameters().get(IndexerProperties.KEY_INDEXER_ASYNCHRONOUS);
        if (isAsynchronous != null) {
            this.isAsynchronous = Boolean.parseBoolean(isAsynchronous);
        }

        ModelIndexerFactory indexerFactory = new ModelIndexerFactory();
        indexer = indexerFactory.createIndexer(datasource.getConfigurationParameters());
        if (this.isAsynchronous) {
            indexExecutor = Executors.newFixedThreadPool(1);
        }

    }

    public void updateComplete(IOperationContext context, IUpdates results) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            handle(context, results);
        } finally {
            if (stats.isEnabled()) {
                stats.use("update", System.currentTimeMillis() - start);
            }
        }
    }

    /**
     * Reset the index (clear all contents).
     * 
     * @throws AnzoException
     */
    public void reset() throws AnzoException {
        if (isAsynchronous) {
            indexExecutor.shutdown();
            indexExecutor = null;
            indexExecutor = Executors.newFixedThreadPool(1);
        }
        indexer.clear();
    }

    protected void rebuildIndex(boolean force) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            if (force || indexer.needsIndexRebuild()) {
                indexer.rebuild(datasource);
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("rebuildIndex", System.currentTimeMillis() - start);
            }
        }
    }

    /**
     * Returns true if the indexing is asynchronous, false otherwise.
     * 
     * @return true if the indexing is asynchronous, false otherwise.
     */
    public boolean isAsynchronous() {
        return isAsynchronous;
    }

    /**
     * Handles bytes from UpdateResultsHandler, to be parsed as a transaction.
     * 
     * @param context
     *            NodeCentric specific context, which contains connection to run queries against *
     * @param updateResults
     *            Contents of the update results.
     * @throws AnzoException
     */
    private void handle(IOperationContext context, IUpdates updateResults) throws AnzoException {
        if (indexer != null) {
            if (isAsynchronous()) {
                indexExecutor.execute(new IndexerRunnable(context, updateResults));
            } else {
                handleUpdates(context, updateResults);
            }
        }
    }

    protected synchronized void handleUpdates(IOperationContext context, IUpdates updateResults) throws AnzoException {
        IndexerUpdateHandler handler = new IndexerUpdateHandler(context);
        try {
            for (IUpdateTransaction transaction : updateResults.getTransactions()) {
                handler.handleTransaction(transaction);
            }
        } catch (AnzoException ae) {
            handler.cleanUp();
            throw ae;
        }
    }

    /**
     * Wrapper for parsing index data, used to give taskes to the QueuedExecutor.
     * 
     * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
     */
    protected class IndexerRunnable implements Runnable {

        private final IUpdates          updateResults;

        private final IOperationContext context;

        IndexerRunnable(IOperationContext context, IUpdates updateResults) {
            this.updateResults = updateResults;
            this.context = context;
        }

        public void run() {
            try {
                handleUpdates(context, updateResults);
            } catch (AnzoException e) {
                log.error(LogUtils.RDB_MARKER, "Error processing update in indexer", e);
            }
        }
    }

    /**
     * Handler for parsing transaction events that come from {@link ServerQuadStoreUpdateHandler}.
     * 
     * For every transaction start, preIndex and preRemove are called. Statements with string literal objects are indexed. When the transaction ends, postIndex
     * and postRemove are called.
     * 
     * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
     */
    class IndexerUpdateHandler implements IUpdatesHandler {

        private Long                        timestamp   = null;

        private boolean                     connOwned   = false;

        private IOperationContext           rootContext = null;

        private NodeCentricOperationContext context     = null;

        IndexerUpdateHandler(IOperationContext rootContext) {
            if (rootContext != null && rootContext instanceof NodeCentricOperationContext) {
                context = (NodeCentricOperationContext) rootContext;
            } else {
                this.rootContext = rootContext;
            }
        }

        public void start() throws AnzoException {
        }

        public void end() throws AnzoException {
        }

        public void handleTransaction(IUpdateTransaction transaction) throws AnzoException {
            if (transaction.getErrors().size() > 0)
                return;
            if (context == null) {
                context = datasource.getQueryContext(rootContext);
                connOwned = true;
            }
            this.timestamp = transaction.getTransactionTimestamp();
            try {
                indexer.preIndex();
                indexer.preRemove();
            } catch (IndexerException e) {
                log.error(LogUtils.RDB_MARKER, "Error doing pre index operations", e);
                throw e;
            }
            for (INamedGraphUpdate update : transaction.getNamedGraphUpdates()) {
                for (Statement stmt : update.getRemovals()) {
                    handleStatement(false, stmt);
                }
                for (Statement stmt : update.getAdditions()) {
                    handleStatement(true, stmt);
                }
                for (Statement stmt : update.getMetaRemovals()) {
                    handleStatement(false, stmt);
                }
                for (Statement stmt : update.getMetaAdditions()) {
                    handleStatement(true, stmt);
                }
            }
            try {
                indexer.postIndex();
                indexer.postRemove();
            } catch (IndexerException e) {
                log.error(LogUtils.RDB_MARKER, "Error doing post index operations", e);
                throw e;
            }
            if (connOwned) {
                datasource.returnQueryContext(context);
                context = null;
                connOwned = false;
            }
        }

        protected void handleStatement(boolean additions, Statement stmt) throws AnzoException {
            if (indexer != null && (stmt.getObject() instanceof Literal)) {
                Long ngId = context.getNodeLayout().fetchId(stmt.getNamedGraphUri(), context.getConnection());
                Long subjectId = context.getNodeLayout().fetchId(stmt.getSubject(), context.getConnection());
                Long predicateId = context.getNodeLayout().fetchId(stmt.getPredicate(), context.getConnection());
                Long objectId = context.getNodeLayout().fetchId(stmt.getObject(), context.getConnection());
                if (ngId == null || subjectId == null || predicateId == null || objectId == null) {
                    log.error(LogUtils.RDB_MARKER, "Failed to index statements since and id for one of the statement elements could not be found: {} {} {} {}", new Object[] { ngId, subjectId, predicateId, objectId });
                }
                StatementWrapper wrapper = new StatementWrapper(stmt.getNamedGraphUri(), ngId, stmt.getSubject(), subjectId, stmt.getPredicate(), predicateId, stmt.getObject(), objectId, timestamp);
                try {
                    if (additions) {
                        indexer.index(wrapper);
                    } else {
                        indexer.remove(wrapper);
                    }
                } catch (IndexerException e) {
                    log.error(LogUtils.RDB_MARKER, "Error adding or removing index entry", e);
                    throw e;
                }
            }
        }

        void cleanUp() throws AnzoException {
            if (connOwned && context != null) {
                datasource.returnQueryContext(context);
                context = null;
                connOwned = false;
            }
        }
    }
}
