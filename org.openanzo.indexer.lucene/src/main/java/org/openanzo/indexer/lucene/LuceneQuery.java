/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer.lucene/src/com/ibm/adtech/indexer/lucene/LuceneQuery.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: LuceneQuery.java 169 2007-07-31 14:11:15Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer.lucene;

import java.util.Collection;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.MultiTermQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.PrefixFilter;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.util.Version;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.indexer.IQuery;
import org.openanzo.indexer.IndexerException;

/**
 * Implementation of IQuery based on Lucene.
 * 
 * @author Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 */
public class LuceneQuery implements IQuery {

    //private static final Logger log          = LoggerFactory.getLogger(LuceneQuery.class);

    protected Analyzer        analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);

    private Query             query    = null;

    protected Filter          filter   = null;

    private Collection<Query> terms    = null;

    private String            defaultField;

    private QueryParser       parser   = null;

    /**
     * Initializes the query based on the queryStr
     * 
     * @param queryStr
     *            query string, can use Lucene Query constructs
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#PARSE_EXCEPTION} if there was an exception parsing the query
     */
    public void initialize(String queryStr) throws IndexerException {
        try {
            parser = new QueryParser(Version.LUCENE_CURRENT, defaultField, analyzer);
            parser.setAllowLeadingWildcard(true);
            query = parser.parse(queryStr);
        } catch (ParseException e) {
            throw new IndexerException(ExceptionConstants.INDEX.PARSE_EXCEPTION, e, queryStr);
        }
    }

    /**
     * Initializes the query based on the queryStr
     * 
     * @param queryStr
     *            query string, can use Lucene Query constructs
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#PARSE_EXCEPTION} if there was an exception parsing the query
     */
    private void initializeFiltered(String queryStr) throws IndexerException {
        try {
            BooleanQuery bq = new BooleanQuery();
            parser = new QueryParser(Version.LUCENE_CURRENT, defaultField, analyzer);
            parser.setAllowLeadingWildcard(true);
            query = parser.parse(queryStr);
            parseQuery(bq, query, BooleanClause.Occur.MUST);
            for (Query term : terms) {
                bq.add(term, BooleanClause.Occur.MUST);
            }
            if (bq.getClauses().length == 0 && filter != null) {
                bq.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
            }
            query = bq;
        } catch (ParseException ie) {
            throw new IndexerException(ExceptionConstants.INDEX.PARSE_EXCEPTION, ie);
        }
    }

    private void parseQuery(BooleanQuery destinationQuery, Query sourceQuery, BooleanClause.Occur occur) {
        if (sourceQuery instanceof BooleanQuery) {
            for (BooleanClause bc : ((BooleanQuery) query).getClauses()) {
                parseQuery(destinationQuery, bc.getQuery(), occur);
            }
        } else if (sourceQuery instanceof PrefixQuery) {
            PrefixQuery pq = (PrefixQuery) sourceQuery;
            filter = new PrefixFilter(pq.getPrefix());
        } else if (sourceQuery instanceof WildcardQuery) {
            destinationQuery.add(new BooleanClause(sourceQuery, occur));
        } else if (sourceQuery instanceof TermQuery) {
            destinationQuery.add(new BooleanClause(sourceQuery, occur));
        } else if (sourceQuery instanceof MultiTermQuery) {
            destinationQuery.add(new BooleanClause(sourceQuery, occur));
        } else if (sourceQuery instanceof PhraseQuery) {
            destinationQuery.add(new BooleanClause(sourceQuery, occur));
        }
    }

    /**
     * Initializes a simple query. Sets the default field to search, along with the text to search. Note that text may contain other modifiers so that other
     * fields are searched as well.
     * 
     * @param defaultField
     *            default field to search in this query
     * @param text
     *            text query to search for, can use Lucene Query constructs
     * 
     */
    public void initialize(String defaultField, String text) throws IndexerException {
        query = null;
        this.defaultField = defaultField;
        initialize(text);
    }

    /**
     * Initializes a simple query. Sets the default field to search, along with the text to search. Note that text may contain other modifiers so that other
     * fields are searched as well.
     * 
     * @param defaultField
     *            default field to search in this query
     * @param text
     *            text query to search for, can use Lucene Query constructs
     * @param terms
     *            extra search terms for query
     * @throws IndexerException
     */
    public void initialize(String defaultField, String text, Collection<Query> terms) throws IndexerException {
        query = null;
        this.defaultField = defaultField;
        this.terms = terms;
        initializeFiltered(text);
    }

    /**
     * Get the underlying Query object
     * 
     * @return the underlying Query object
     */
    public Query getQuery() {
        return query;
    }

    /**
     * Get the underlying Filter object.
     * 
     * @return the underlying Filter object.
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * Get extra search terms for query
     * 
     * @return extra search terms for query
     */
    public Collection<Query> getTerms() {
        return terms;
    }
}
