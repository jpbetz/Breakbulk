/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/indexer/Attic/LiteralIndexQuery.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: LiteralIndexQuery.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout.indexer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Scorer;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.indexer.IndexerException;
import org.openanzo.indexer.lucene.LuceneConstants;
import org.openanzo.indexer.lucene.LuceneQuery;

/**
 * Literal indexer query processor
 * 
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 */
class LiteralIndexQuery {

    //private final static Logger log          = LoggerFactory.getLogger(LiteralIndexQuery.class.getName());

    private Analyzer    analyzer     = null;

    private String      defaultField = null;

    private QueryParser parser       = null;

    IndexSearcher       searcher;

    private String      location     = null;

    /**
     * Create a new LiteralIndexQuery object
     */
    public LiteralIndexQuery() {
        super();
    }

    /**
     * Initialize with a set of configuration properties
     * 
     * @param properties
     *            containing configuration data
     * @throws IndexerException
     *             if there was no index location specified
     */
    protected void initialize(Dictionary<? extends Object, ? extends Object> properties) throws IndexerException {
        defaultField = LuceneConstants.INDEXER_FIELD_OBJECT;
        analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
        parser = new QueryParser(Version.LUCENE_CURRENT, defaultField, analyzer);
        parser.setAllowLeadingWildcard(true);
        location = LiteralIndexerDictionary.getIndexLocation(properties);
        if (location == null) {
            throw new IndexerException(ExceptionConstants.INDEX.INDEX_CONFIG_PARAM_MISSING, LiteralIndexerProperties.KEY_LITERAL_INDEX_LOCATION);
        }

        try {
            searcher = new IndexSearcher(FSDirectory.open(new File(location)));
        } catch (IOException e) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_INIT_SEARCH, e, location);
        }
    }

    /**
     * Query the index and return set if IDs for literals that match the query
     * 
     * @param queryStr
     *            query to run on indexer
     * @return set of IDs for literals that match the query
     * @throws IndexerException
     *             if there was an error parsing, or processing the query
     */
    public List<Long> query(String queryStr) throws IndexerException {
        final ArrayList<Long> ids = new ArrayList<Long>();

        try {
            Query query = parser.parse(queryStr);

            searcher.search(query, new Collector() {
                int docBase = 0;

                @Override
                public void setScorer(Scorer arg0) throws IOException {
                }

                @Override
                public void setNextReader(IndexReader arg0, int arg1) throws IOException {
                    this.docBase = arg1;
                }

                @Override
                public void collect(int doc) throws IOException {
                    try {
                        Document document = searcher.doc(docBase + doc);
                        Field idField = document.getField(LuceneConstants.INDEXER_FIELD_OBJ_NODE_ID);
                        if (idField != null) {
                            Long nodeId = Long.valueOf(idField.stringValue());
                            ids.add(nodeId);
                        }
                    } catch (IOException ioe) {
                        throw new AnzoRuntimeException(ExceptionConstants.INDEX.WRONG_QUERY_TYPE, LuceneQuery.class.toString());
                    }
                }

                @Override
                public boolean acceptsDocsOutOfOrder() {
                    return true;
                }
            });
        } catch (IOException e) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_INDEX_QUERY, e);
        } catch (AnzoRuntimeException e) {
            throw new IndexerException(e.getErrorCode(), e.getCause(), e.getArgs());
        } catch (ParseException e) {
            throw new IndexerException(ExceptionConstants.INDEX.PARSE_EXCEPTION, e, queryStr);
        }
        return ids;
    }
}
