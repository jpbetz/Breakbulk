/*******************************************************************************
 * Copyright (c) 2007-2010 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 1, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.datasource.IUpdateService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.AnzoMultiMap;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdates;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.openanzo.services.serialization.IUpdatesHandler;
import org.openanzo.services.serialization.IUpdatesReader;
import org.openanzo.services.serialization.UpdatesCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base implementation of the IUpdateService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseUpdateService extends BaseDatasourceComponent implements IUpdateService {
    private static final Logger                       log                             = LoggerFactory.getLogger(BaseUpdateService.class);

    /** {@link IUpdateResultListener}s for updates that are fired to datasource internal update listeners */
    protected final Collection<IUpdateResultListener> datasourceUpdateResultListeners = new HashSet<IUpdateResultListener>();

    /** {@link IUpdateResultListener}s for updates to external update listeners */
    protected final Collection<IUpdateResultListener> globalUpdateResultListeners     = new HashSet<IUpdateResultListener>();

    private final DynamicServiceStats                 stats                           = new DynamicServiceStats("update", "importStatements");

    private static final String                       FIRE_GLOBAL_UDPATE_EVENTS       = "fireGlobalUpdateEvents";

    public String getName() {
        return getDatasource().getName() + ",Service=UpdateService";
    }

    public String getDescription() {
        return "Update Service for " + getDatasource().getName();
    }

    /**
     * @return the stats
     */
    public DynamicServiceStats getStatistics() {
        return stats;
    }

    /**
     * Add a global update result listener
     * 
     * @param listener
     *            global update result listener
     */
    public void addGlobalUpdateResultListener(IUpdateResultListener listener) {
        if (listener != null)
            globalUpdateResultListeners.add(listener);
    }

    /**
     * Remove a global update result listener
     * 
     * @param listener
     *            global update result listener
     */
    public void removeGlobalUpdateResultListener(IUpdateResultListener listener) {
        if (listener != null)
            globalUpdateResultListeners.remove(listener);
    }

    /**
     * Add a datasource specific update result listener
     * 
     * @param listener
     *            global update result listener
     */
    public void addDatasourceUpdateResultListener(IUpdateResultListener listener) {
        if (listener != null)
            datasourceUpdateResultListeners.add(listener);
    }

    /**
     * Remove a datasource specific update result listener
     * 
     * @param listener
     *            global update result listener
     */
    public void removeDatasourceUpdateResultListener(IUpdateResultListener listener) {
        if (listener != null)
            datasourceUpdateResultListeners.remove(listener);
    }

    public void start() throws AnzoException {
        stats.setEnabled(true);
    }

    public void reset() throws AnzoException {
        stats.reset();
    }

    /**
     * Checks if the user calling the operation is an anonymous user. If it is an anonymous user, then an exception is thrown.
     * 
     * @param context
     * @throws AnzoException
     */
    private void throwExceptionIfAnonymousUser(IOperationContext context) throws AnzoException {
        AnzoPrincipal principal = context.getOperationPrincipal();
        if (principal != null && principal.isAnonymous()) {
            throw new AnzoException(ExceptionConstants.SERVER.ANONYMOUS_UPDATE_NOT_ALLOWED_ERROR);
        }
    }

    public IUpdates update(IOperationContext context, boolean returnResults, IUpdates transactions) throws AnzoException {
        long start = 0;
        if (stats.isEnabled() || log.isDebugEnabled()) {
            start = System.currentTimeMillis();
        }
        throwExceptionIfAnonymousUser(context);
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            IUpdates updateResults = updateInternal(context, returnResults, transactions);
            for (IUpdateResultListener listener : datasourceUpdateResultListeners) {
                try {
                    listener.updateComplete(context, updateResults);
                } catch (AnzoException ae) {
                    log.error(LogUtils.DATASOURCE_MARKER, "Error in listener:" + listener.getClass().getName());
                }
            }
            Boolean fireGlobal = (Boolean) context.getAttribute(FIRE_GLOBAL_UDPATE_EVENTS);
            if (fireGlobal == null || fireGlobal.booleanValue()) {
                for (IUpdateResultListener listener : globalUpdateResultListeners) {
                    try {
                        listener.updateComplete(context, updateResults);
                    } catch (AnzoException ae) {
                        log.error(LogUtils.DATASOURCE_MARKER, "Error in listener:" + listener.getClass().getName());
                    }
                }
            }
            return updateResults;
        } finally {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.TIMING_MARKER, "Base Update Total,{}", (System.currentTimeMillis() - start));
            }
            if (stats.isEnabled()) {
                stats.use("update", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    public void update(IOperationContext context, boolean returnResults, String input, String inputFormat, Writer output, String resultFormat) throws AnzoException {
        long start = 0;
        if (stats.isEnabled() || log.isDebugEnabled()) {
            start = System.currentTimeMillis();
        }
        throwExceptionIfAnonymousUser(context);
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            IUpdatesReader formatReader = CommonSerializationUtils.getUpdatesReader(input, inputFormat);
            UpdatesCollector collector = new UpdatesCollector(); // TODO: should we stream update results?

            IUpdates updateResults = updateInternal(context, returnResults, formatReader, collector);
            for (IUpdateResultListener listener : datasourceUpdateResultListeners) {
                try {
                    listener.updateComplete(context, updateResults);
                } catch (AnzoException ae) {
                    log.error(LogUtils.DATASOURCE_MARKER, "Error in listener:" + listener.getClass().getName());
                }
            }
            Boolean fireGlobal = (Boolean) context.getAttribute(FIRE_GLOBAL_UDPATE_EVENTS);
            if (fireGlobal == null || fireGlobal.booleanValue()) {
                for (IUpdateResultListener listener : globalUpdateResultListeners) {
                    try {
                        listener.updateComplete(context, updateResults);
                    } catch (AnzoException ae) {
                        log.error(LogUtils.DATASOURCE_MARKER, "Error in listener:" + listener.getClass().getName());
                    }
                }
            }
            CommonSerializationUtils.writeUpdates(returnResults, collector.getUpdates(), output, resultFormat);

        } finally {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.TIMING_MARKER, "Base Update Time,{}", (System.currentTimeMillis() - start));
            }
            if (stats.isEnabled()) {
                stats.use("update", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    public IUpdates importStatements(IOperationContext context, Collection<Statement> statements, Collection<Statement> graphTemplate) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        throwExceptionIfAnonymousUser(context);
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            MultiMap<URI, Statement> map = new AnzoMultiMap<URI, Statement>();
            for (Statement stmt : statements) {
                URI ngUri = stmt.getNamedGraphUri();
                if (ngUri == null) {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.STATEMENT_NO_GRAPH);
                }
                map.put(ngUri, stmt);
            }
            if (graphTemplate == null) {
                graphTemplate = Collections.<Statement> emptySet();
            }
            IUpdates updateResults = importStatementsInternal(context, map, graphTemplate);
            for (IUpdateResultListener listener : datasourceUpdateResultListeners) {
                try {
                    listener.updateComplete(context, updateResults);
                } catch (AnzoException ae) {
                    log.error(LogUtils.DATASOURCE_MARKER, "Error in listener:" + listener.getClass().getName());
                }
            }
            Boolean fireGlobal = (Boolean) context.getAttribute(FIRE_GLOBAL_UDPATE_EVENTS);
            if (fireGlobal == null || fireGlobal.booleanValue()) {
                for (IUpdateResultListener listener : globalUpdateResultListeners) {
                    try {
                        listener.updateComplete(context, updateResults);
                    } catch (AnzoException ae) {
                        log.error(LogUtils.DATASOURCE_MARKER, "Error in listener:" + listener.getClass().getName());
                    }
                }
            }
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.TIMING_MARKER, "Base Import,{},{}", (System.currentTimeMillis() - start), map.values().size());
            }
            return updateResults;
        } finally {
            if (stats.isEnabled()) {
                stats.use("importStatements", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    public void importStatements(IOperationContext context, String reader, String readerFormat, Collection<Statement> graphTemplate, Writer output, String resultFormat) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        throwExceptionIfAnonymousUser(context);
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            MultiMap<URI, Statement> statements = ReadWriteUtils.readStatementSets(reader, readerFormat);
            if (statements.containsKey(null)) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.STATEMENT_NO_GRAPH);
            }
            if (graphTemplate == null) {
                graphTemplate = Collections.<Statement> emptySet();
            }
            IUpdates updateResults = importStatementsInternal(context, statements, graphTemplate);
            for (IUpdateResultListener listener : datasourceUpdateResultListeners) {
                try {
                    listener.updateComplete(context, updateResults);
                } catch (AnzoException ae) {
                    log.error(LogUtils.DATASOURCE_MARKER, "Error in listener:" + listener.getClass().getName());
                }
            }
            Boolean fireGlobal = (Boolean) context.getAttribute(FIRE_GLOBAL_UDPATE_EVENTS);
            if (fireGlobal == null || fireGlobal.booleanValue()) {
                for (IUpdateResultListener listener : globalUpdateResultListeners) {
                    try {
                        listener.updateComplete(context, updateResults);
                    } catch (AnzoException ae) {
                        log.error(LogUtils.DATASOURCE_MARKER, "Error in listener:" + listener.getClass().getName());
                    }
                }
            }
            CommonSerializationUtils.writeUpdates(false, updateResults, output, resultFormat);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.TIMING_MARKER, "Base Import,{},{}", (System.currentTimeMillis() - start), statements.values().size());
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("importStatements", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    /**
     * Update the server
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param returnResults
     *            return update results and not just errors
     * @param transactions
     *            The set of transactions to commit to the server
     * @return the results of updating the server
     * @throws AnzoException
     */
    protected abstract IUpdates updateInternal(IOperationContext context, boolean returnResults, IUpdates updates) throws AnzoException;

    /**
     * Update the server
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param returnResults
     *            return update results and not just errors
     * @param reader
     *            reader providing the transactions that need to be processed
     * @param writer
     *            writer that transaction results should be written to if returnResults is true
     * @return the results of updating the server
     * @throws AnzoException
     */
    protected abstract IUpdates updateInternal(IOperationContext context, boolean returnResults, IUpdatesReader reader, IUpdatesHandler writer) throws AnzoException;

    /**
     * Update the server
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param returnResults
     *            return update results and not just errors
     * @param statements
     *            The set of statements to import to the server
     * @param graphTemplate
     *            The set of statements to use as new graph template
     * @return the results of updating the server
     * @throws AnzoException
     */
    protected abstract IUpdates importStatementsInternal(IOperationContext context, MultiMap<URI, Statement> statements, Collection<Statement> graphTemplate) throws AnzoException;
}
