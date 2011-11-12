/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 27, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.io.Writer;
import java.util.Collection;

import org.openanzo.datasource.IIndexService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.query.TextMatchPredicate.TextMatchQuery;
import org.openanzo.rdf.IRDFHandler;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.StatementCollector;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IOperationContext;

/**
 * BaseIndexService is a base implementation for the IIndexService which provides the server's interface to a text indexer
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseIndexService extends BaseDatasourceComponent implements IIndexService {
    /** Log for this Service */
    //private static final Logger   log                  = LoggerFactory.getLogger(BaseModelService.class);
    protected DynamicServiceStats stats = new DynamicServiceStats("queryIndex");

    public String getName() {
        return getDatasource().getName() + ",Service=IndexService";
    }

    public String getDescription() {
        return "Index Service for " + getDatasource().getName();
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

    /**
     * 
     * Run a query on the text indexer
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param queryString
     *            String containing query text
     * @param startIndex
     *            offset into query results to return
     * @param numResults
     *            the number of query results to return
     * @param output
     *            outputStream to which results are written
     * @param format
     *            format of output data
     * @throws AnzoException
     *             {@link ExceptionConstants.INDEX#FAILED_INDEX_QUERY_DISABLED} if indexing is disabled
     */
    public void queryIndex(IOperationContext context, String paramQuery, String queryString, int startIndex, int numResults, Writer output, String format) throws AnzoException {
        if (queryString == null || queryString.length() == 0)
            queryString = paramQuery; // TEMP fix until we drop support for paramQuery in messages
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            IRDFHandler writer = ReadWriteUtils.getWriter(output, RDFFormat.forMIMEType(format));

            executeIndexQueryInternal(context, queryString, startIndex, numResults, writer);
        } finally {
            if (stats.isEnabled()) {
                stats.use("queryIndex", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    /**
     * 
     * Run a query on the text indexer
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param queryString
     *            String containing query text
     * @param startIndex
     *            offset into query results to return
     * @param numResults
     *            the number of query results to return
     * @return statements that match the query results
     * @throws AnzoException
     *             {@link ExceptionConstants.INDEX#FAILED_INDEX_QUERY_DISABLED} if indexing is disabled
     */
    public Collection<Statement> queryIndex(IOperationContext context, String paramQuery, String queryString, int startIndex, int numResults) throws AnzoException {
        if (queryString == null || queryString.length() == 0)
            queryString = paramQuery; // TEMP fix until we drop support for paramQuery in messages
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            StatementCollector sc = new StatementCollector();
            executeIndexQueryInternal(context, queryString, startIndex, numResults, sc);
            return sc.getStatements();
        } finally {
            if (stats.isEnabled()) {
                stats.use("queryIndex", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    /**
     * Query the text indexer for a set of statements that match a text indexer query
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param query
     *            query string
     * @param offset
     *            index of first result to return
     * @param limit
     *            maximum number of results to return
     * @param handler
     *            {@link IRDFHandler} to handle the results from the index query
     * @throws AnzoException
     */
    protected abstract void executeIndexQueryInternal(IOperationContext context, String query, int offset, int limit, IRDFHandler handler) throws AnzoException;

    /**
     * Query the text indexer for a set of statements that match a text indexer query
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param query
     *            query string
     * @param offset
     *            index of first result to return
     * @param limit
     *            maximum number of results to return
     * @return the results from the index query
     * @throws AnzoException
     */
    protected abstract Collection<Statement> executeIndexQueryInternal(IOperationContext context, String query, int offset, int limit) throws AnzoException;

    /**
     * 
     * @param context
     * @param query
     * @param offset
     * @param limit
     * @return
     * @throws AnzoException
     */
    public abstract Collection<Statement> executeIndexQueryInternal(IOperationContext context, TextMatchQuery query, int offset, int limit) throws AnzoException;

}
