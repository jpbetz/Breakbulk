/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer.lucene/src/com/ibm/adtech/indexer/lucene/LuceneSearch.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: LuceneSearch.java 169 2007-07-31 14:11:15Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer.lucene;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Scorer;
import org.apache.lucene.store.FSDirectory;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.indexer.IQuery;
import org.openanzo.indexer.IResult;
import org.openanzo.indexer.ISearch;
import org.openanzo.indexer.IndexerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Search implementation based on Lucene.
 * 
 * @author Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 */
public class LuceneSearch implements ISearch {

    private static final Logger log           = LoggerFactory.getLogger(LuceneSearch.class);

    protected String            location;

    protected IndexSearcher     searcher;

    int                         pageSize      = 5;

    ReentrantReadWriteLock      readWriteLock = new ReentrantReadWriteLock();

    /**
     * Close search
     * 
     * @throws AnzoException
     */
    public void close() throws AnzoException {
        try {
            searcher.close();
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.INDEX.FAILED_INDEX_CLOSE, ioe);
        }
    }

    /**
     * Initializes the Lucene index. Reads the index directory location out of the properties object.
     * 
     * The properties object is expected to contain the location of the directory containing the index (org.openanzo.indexer.lucene.indexLocation).
     * 
     * @param properties
     *            configuration properties for search
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#INDEX_CONFIG_PARAM_MISSING} if the {@link LuceneProperties#KEY_LUCENE_INDEX_LOCATION} property is missing
     */
    public void initialize(Properties properties) throws IndexerException {
        location = LuceneProperties.getIndexLocation(properties);
        if (location == null) {
            throw new IndexerException(ExceptionConstants.INDEX.INDEX_CONFIG_PARAM_MISSING, LuceneProperties.KEY_LUCENE_INDEX_LOCATION);
        }

        location = LuceneIndexerBase.getAbsoluteIndexLocation(location, LuceneProperties.getIndexerHome(properties));

        if (searcher == null) {
            try {
                searcher = new IndexSearcher(FSDirectory.open(new File(location)), true);
            } catch (IOException e) {
                throw new IndexerException(ExceptionConstants.INDEX.FAILED_INIT_SEARCH, e, location);
            }
        }
    }

    /**
     * Initializes the Lucene index.
     * 
     * @param location
     *            the location of the directory containing the index
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#INDEX_CONFIG_PARAM_MISSING} if the {@link LuceneProperties#KEY_LUCENE_INDEX_LOCATION} property is missing
     */
    public void initialize(String location) throws IndexerException {
        if (location == null) {
            throw new IndexerException(ExceptionConstants.INDEX.INDEX_CONFIG_PARAM_MISSING, LuceneProperties.KEY_LUCENE_INDEX_LOCATION);
        }
        this.location = location;

        if (searcher == null) {
            try {
                searcher = new IndexSearcher(FSDirectory.open(new File(location)), true);
            } catch (IOException e) {
                throw new IndexerException(ExceptionConstants.INDEX.FAILED_INIT_SEARCH, e, location);
            }
        }
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<IResult> executeQuery(IQuery query) throws IndexerException {
        preQuery();
        if (log.isDebugEnabled()) {
            if (query instanceof LuceneQuery) {
                LuceneQuery luceneQuery = (LuceneQuery) query;
                log.debug(LogUtils.DATASOURCE_MARKER, "executeQuery - filter:'{}' query:'{}' # of query terms: " + (luceneQuery.getTerms() == null ? 0 : luceneQuery.getTerms().size()), (luceneQuery.getFilter() == null ? "null" : luceneQuery.getFilter().toString()), (luceneQuery.getQuery() == null ? "null" : luceneQuery.getQuery().toString()));
            }
        }
        readWriteLock.readLock().lock();
        try {
            if (searcher != null) {
                try {
                    if (query instanceof LuceneQuery) {
                        LuceneQuery lQueryWrapper = (LuceneQuery) query;
                        Query lQuery = lQueryWrapper.getQuery();
                        Filter filter = lQueryWrapper.getFilter();
                        final List<IResult> results = new ArrayList<IResult>();

                        log.debug(LogUtils.DATASOURCE_MARKER, "executeQuery - About to invoke index searcher.");
                        if (filter != null) {
                            searcher.search(lQuery, filter, new Collector() {
                                private int docBase;

                                @Override
                                public void setScorer(Scorer arg0) throws IOException {
                                }

                                @Override
                                public void setNextReader(IndexReader arg0, int arg1) throws IOException {
                                    this.docBase = arg1;
                                }

                                @Override
                                public void collect(int doc) throws IOException {
                                    results.add(new LuceneResult(searcher.doc(doc + docBase)));
                                }

                                @Override
                                public boolean acceptsDocsOutOfOrder() {
                                    return true;
                                }
                            });
                        } else {
                            searcher.search(lQuery, new Collector() {
                                private int docBase;

                                @Override
                                public void setScorer(Scorer arg0) throws IOException {
                                }

                                @Override
                                public void setNextReader(IndexReader arg0, int arg1) throws IOException {
                                    this.docBase = arg1;
                                }

                                @Override
                                public void collect(int doc) throws IOException {
                                    results.add(new LuceneResult(searcher.doc(doc + docBase)));
                                }

                                @Override
                                public boolean acceptsDocsOutOfOrder() {
                                    return true;
                                }
                            });
                        }
                        log.debug(LogUtils.DATASOURCE_MARKER, "executeQuery - Index search complete. # of results: {}", results.size());
                        return results;
                    } else {
                        throw new IndexerException(ExceptionConstants.INDEX.WRONG_QUERY_TYPE, LuceneQuery.class.toString());
                    }
                } catch (IOException e) {
                    throw new IndexerException(ExceptionConstants.INDEX.FAILED_INDEX_QUERY, e);
                } catch (AnzoRuntimeException e) {
                    throw new IndexerException(e.getErrorCode(), e.getCause(), e.getArgs());
                }
            } else {
                throw new IndexerException(ExceptionConstants.INDEX.NO_SEARCH_OBJECT);
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    /**
     * run before the query
     * 
     * @throws IndexerException
     */
    public void preQuery() throws IndexerException {
        try {
            readWriteLock.readLock().lock();
            boolean indexOk = false;
            try {
                indexOk = searcher.getIndexReader().isCurrent();
            } finally {
                readWriteLock.readLock().unlock();
            }
            if (!indexOk) {
                readWriteLock.writeLock().lock();
                try {
                    log.info(LogUtils.DATASOURCE_MARKER, "Index is not current, closing and re-opening searcher to refresh.");
                    searcher.close();
                    searcher = new IndexSearcher(FSDirectory.open(new File(location)), true);
                } finally {
                    readWriteLock.writeLock().unlock();
                }
            }
        } catch (IOException e) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_INIT_SEARCH, e, location);
        }
    }
}
