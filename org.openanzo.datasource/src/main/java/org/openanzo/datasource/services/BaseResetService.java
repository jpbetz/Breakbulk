/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
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
import java.util.Dictionary;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.datasource.IResetService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.OSGI;
import org.openanzo.rdf.utils.AnzoMultiMap;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IOperationContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base implementation of the IResetService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseResetService extends BaseDatasourceComponent implements IResetService {
    private static final Logger       log        = LoggerFactory.getLogger(BaseResetService.class);

    private final DynamicServiceStats stats      = new DynamicServiceStats("reset");

    protected EventAdmin              eventAdmin = null;

    protected boolean                 enabled    = false;

    /**
     * Base reset service
     * 
     * @param enabled
     *            is reset enabled
     * @param eventAdmin
     *            eventAdmin object used to publish reset events
     */
    public BaseResetService(boolean enabled, EventAdmin eventAdmin) {
        this.enabled = enabled;
        this.eventAdmin = eventAdmin;
    }

    public String getName() {
        return getDatasource().getName() + ",Service=ResetService";
    }

    public String getDescription() {
        return "Reset Service for " + getDatasource().getName();
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    public void start() throws AnzoException {
        stats.setEnabled(true);
    }

    public void reset() throws AnzoException {
        stats.reset();
    }

    public void reset(IOperationContext context, String input, String inputFormat, java.util.Collection<org.openanzo.rdf.Statement> checks, Writer output) throws AnzoException {
        if (!enabled) {
            throw new AnzoException(ExceptionConstants.SERVER.RESET_NOT_ENABLED);
        }
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        logEntry();
        try {
            long start2 = 0;
            long end = 0;
            if (log.isDebugEnabled()) {
                System.currentTimeMillis();
            }
            if (getDatasource() instanceof BaseDatasource) {
                ((BaseDatasource) getDatasource()).resetStarting();
            }
            if (log.isDebugEnabled()) {
                end = System.currentTimeMillis();
                log.debug(LogUtils.DATASOURCE_MARKER, "PreReset:" + (end - start2));
                start2 = end;
            }
            if (getLockProvider() != null)
                getLockProvider().writeLock().lock();
            try {
                if (getDatasource() instanceof BaseDatasource) {
                    ((BaseDatasource) getDatasource()).reset();
                }
                if (log.isDebugEnabled()) {
                    end = System.currentTimeMillis();
                    log.debug(LogUtils.DATASOURCE_MARKER, "Reset:" + (end - start2));
                    start2 = end;
                }
                if (eventAdmin != null)
                    eventAdmin.sendEvent(new Event(OSGI.RESET_TOPIC, (Dictionary<Object, Object>) new Properties()));

                MultiMap<URI, Statement> statements = ReadWriteUtils.readStatementSets(input, inputFormat);
                resetInternal(context, statements, checks);
                if (log.isDebugEnabled()) {
                    end = System.currentTimeMillis();
                    log.debug(LogUtils.DATASOURCE_MARKER, "ResetInternal:" + (end - start2));
                    start2 = end;
                }
            } finally {
                if (getLockProvider() != null)
                    getLockProvider().writeLock().unlock();
            }
            if (getDatasource() instanceof BaseDatasource) {
                ((BaseDatasource) getDatasource()).postReset();
            }
            if (log.isDebugEnabled()) {
                end = System.currentTimeMillis();
                log.debug(LogUtils.DATASOURCE_MARKER, "PostReset:" + (end - start2));
                start2 = end;
            }

            if (getDatasource() instanceof BaseDatasource) {
                ((BaseDatasource) getDatasource()).resetFinished();
            }
            if (log.isDebugEnabled()) {
                end = System.currentTimeMillis();
                log.debug(LogUtils.DATASOURCE_MARKER, "ResetFinished:" + (end - start2));
                start2 = end;
            }
            resetChecks(context, checks);
        } finally {
            if (stats.isEnabled()) {
                stats.use("reset", (System.currentTimeMillis() - start));
            }
            logExit();

        }
    }

    public void reset(IOperationContext context, Collection<Statement> statements, Collection<Statement> checks) throws AnzoException {
        if (!enabled) {
            throw new AnzoException(ExceptionConstants.SERVER.RESET_NOT_ENABLED);
        }
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        logEntry();
        try {
            long start2 = 0;
            long end = 0;
            if (log.isDebugEnabled()) {
                System.currentTimeMillis();
            }
            if (getDatasource() instanceof BaseDatasource) {
                ((BaseDatasource) getDatasource()).resetStarting();
            }
            if (log.isDebugEnabled()) {
                end = System.currentTimeMillis();
                log.debug(LogUtils.DATASOURCE_MARKER, "PreReset:" + (end - start2));
                start2 = end;
            }
            if (getLockProvider() != null)
                getLockProvider().writeLock().lock();
            try {
                if (getDatasource() instanceof BaseDatasource) {
                    ((BaseDatasource) getDatasource()).reset();
                }
                if (log.isDebugEnabled()) {
                    end = System.currentTimeMillis();
                    log.debug(LogUtils.DATASOURCE_MARKER, "Reset:" + (end - start2));
                    start2 = end;
                }
                if (eventAdmin != null)
                    eventAdmin.sendEvent(new Event(OSGI.RESET_TOPIC, (Map<Object, Object>) new Properties()));

                MultiMap<URI, Statement> map = new AnzoMultiMap<URI, Statement>();
                for (Statement stmt : statements) {
                    map.put(stmt.getNamedGraphUri(), stmt);
                }
                resetInternal(context, map, checks);
                if (log.isDebugEnabled()) {
                    end = System.currentTimeMillis();
                    log.debug(LogUtils.DATASOURCE_MARKER, "ResetInternal:" + (end - start2));
                    start2 = end;
                }
            } finally {
                if (getLockProvider() != null)
                    getLockProvider().writeLock().unlock();
            }
            if (getDatasource() instanceof BaseDatasource) {
                ((BaseDatasource) getDatasource()).postReset();
            }
            if (log.isDebugEnabled()) {
                end = System.currentTimeMillis();
                log.debug(LogUtils.DATASOURCE_MARKER, "PostReset:" + (end - start2));
                start2 = end;
            }

            if (getDatasource() instanceof BaseDatasource) {
                ((BaseDatasource) getDatasource()).resetFinished();
            }
            if (log.isDebugEnabled()) {
                end = System.currentTimeMillis();
                log.debug(LogUtils.DATASOURCE_MARKER, "ResetFinished:" + (end - start2));
                start2 = end;
            }
            resetChecks(context, checks);
        } finally {
            if (stats.isEnabled()) {
                stats.use("reset", (System.currentTimeMillis() - start));
            }
            logExit();
        }
    }

    /**
     * Reset the database contents with the system graph data contained in the graph
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param statements
     *            {@link MultiMap} of {@link URI}s to {@link Statement}s containing new contents for system graph
     * @return {@link ValuePair} containing server's {@link URI} and ID for URI
     * @throws AnzoException
     */
    protected abstract URI resetInternal(IOperationContext context, MultiMap<URI, Statement> statements, Collection<Statement> checks) throws AnzoException;

    protected abstract void resetChecks(IOperationContext context, java.util.Collection<org.openanzo.rdf.Statement> checks) throws AnzoException;

}
