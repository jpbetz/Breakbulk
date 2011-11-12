/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/indexer/Attic/LiteralIndexer.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: LiteralIndexer.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout.indexer;

import java.io.IOException;
import java.util.Dictionary;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.Term;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.indexer.IndexerException;
import org.openanzo.indexer.lucene.LuceneConstants;
import org.openanzo.indexer.lucene.LuceneIndexerBase;
import org.openanzo.jdbc.container.RDBQuadStore;
import org.openanzo.jdbc.container.sql.NodeSQL;
import org.openanzo.jdbc.container.sql.NodeSQL.GetAllLiteralsResult;
import org.openanzo.jdbc.layout.NodeType;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Indexer for Anzo Literals based on Lucene.
 * 
 * @author Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 */
public class LiteralIndexer extends LuceneIndexerBase<Pair<Long, Literal>, RDBQuadStore> {

    private static final Logger     log = LoggerFactory.getLogger(LiteralIndexer.class.getName());

    private final LiteralIndexQuery searcher;

    /**
     * Create new LiteralIndexer
     */
    public LiteralIndexer() {
        searcher = new LiteralIndexQuery();
    }

    @Override
    public void initialize(Dictionary<? extends Object, ? extends Object> properties) throws IndexerException {
        location = LiteralIndexerDictionary.getIndexLocation(properties);
        if (location == null) {
            throw new IndexerException(ExceptionConstants.INDEX.INDEX_CONFIG_PARAM_MISSING, LiteralIndexerProperties.KEY_LITERAL_INDEX_LOCATION);
        }
        boolean clear = LiteralIndexerDictionary.getIndexClear(properties);
        boolean removeLock = LiteralIndexerDictionary.getRemoveLockFile(properties);
        boolean rebuildIndex = initialize(location, clear, removeLock);
        searcher.initialize(properties);
        needsIndexRebuild = rebuildIndex;
    }

    @Override
    public boolean needsIndexRebuild() {
        return super.needsIndexRebuild();
    }

    /**
     * Search the indexer for literals that match the query pattern
     * 
     * @param queryStr
     *            query string to run
     * @return list of literal IDs that match query
     * @throws IndexerException
     */
    public List<Long> query(String queryStr) throws IndexerException {
        return searcher.query(queryStr);
    }

    @Override
    public void clear() throws IndexerException {
        try {
            if (searcher.searcher != null) {
                searcher.searcher.close();
                searcher.searcher = null;
            }
        } catch (IOException e) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_INDEX_CLEAR, e);
        }
        super.clear();
    }

    @Override
    public void close() throws IndexerException {
        try {
            if (searcher.searcher != null) {
                searcher.searcher.close();
                searcher.searcher = null;
            }
        } catch (IOException e) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_INDEX_CLOSE, e);
        }
        super.close();
    }

    public boolean index(Pair<Long, Literal> literal) throws IndexerException {
        if (indexWriter != null) {
            Document doc = createDocument(literal);
            addDocument(doc);
            return true;
        }
        return false;
    }

    public void remove(Pair<Long, Literal> literal) throws IndexerException {
        if (indexWriter != null) {
            deleteDocuments(new Term(LuceneConstants.INDEXER_FIELD_OBJ_NODE_ID, Long.toString(literal.first)));
        }
    }

    /**
     * Create a new document which indexes a Literal and its ID
     * 
     * @param pair
     *            literal value
     * @return new Document
     */
    private static Document createDocument(Pair<Long, Literal> pair) {
        Document doc = null;
        boolean index = false;
        String text = null;

        Literal literal = pair.second;
        if (literal instanceof PlainLiteral) {
            index = true;
            text = pair.second.getLabel();
        } else {
            // indexing all literals for now since dates and numbers are meaningful.  
            // TODO: figure out what from lucene can be used to allow for typed fields, 
            // like dates to be search-able, users won't be searching for xsd:datetime format
            // strings, they will search using a variety of date string's often locale specific.
            //

            /*URI type = ((TypedLiteral) literal).getDatatype();
            if (type.equals(XMLSchema.STRING)) {*/
            index = true;
            text = literal.getLabel();
            /*} else {
                // It's not an indexable type.
                // Try index numbers or booleans?
            }*/
        }
        if (index) {
            doc = new Document();
            if (log.isTraceEnabled())
                log.trace(LogUtils.RDB_MARKER, "indexing text: " + text);
            doc.add(new Field(LuceneConstants.INDEXER_FIELD_OBJECT, text, Field.Store.YES, Field.Index.ANALYZED));
            doc.add(new Field(LuceneConstants.INDEXER_FIELD_OBJ_NODE_ID, Long.toString(pair.first), Field.Store.YES, Field.Index.NOT_ANALYZED));
        }
        return doc;
    }

    public int rebuild(RDBQuadStore connection) throws IndexerException {
        clear();
        int indexCount = 0;
        int stmtCount = 0;
        ClosableIterator<GetAllLiteralsResult> iter = null;
        preIndex();
        try {
            iter = NodeSQL.getAllLiterals(connection.getStmtProvider(), connection.getConnection(), connection.getContainerName() + "_L", connection.getConfiguration().getOptimizationString());
            while (iter.hasNext()) {
                GetAllLiteralsResult result = iter.next();
                try {
                    long nodeId = result.getId();
                    long indexWriterId = result.getModifierId();
                    String value = result.getValue();

                    NodeType type = NodeType.getById(nodeId);
                    Literal literal;
                    if (type == NodeType.LITERAL || type == NodeType.LONG_LITERAL) {
                        literal = connection.getNodeLayout().getPlainNodeLiteralLayout().convert(value, indexWriterId, connection.getConnection());
                    } else if (type == NodeType.TYPED_LITERAL || type == NodeType.TYPED_LONG_LITERAL) {
                        literal = connection.getNodeLayout().getTypedNodeLiteralLayout().convert(value, indexWriterId, connection.getConnection());
                    } else {
                        throw new IllegalStateException("Node must be a literal type.");
                    }

                    Document doc = LiteralIndexer.createDocument(new Pair<Long, Literal>(nodeId, literal));
                    if (doc != null) {
                        indexWriter.addDocument(doc);
                    }
                } catch (IOException rdbe) {
                    throw new IndexerException(ExceptionConstants.INDEX.FAILED_REBUILD, rdbe);
                }
                stmtCount++;
            }
        } catch (RdbException rdbe) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_REBUILD, rdbe);
        } finally {
            if (iter != null)
                iter.close();
        }
        if (log.isInfoEnabled())
            log.info(LogUtils.RDB_MARKER, "{} total statements, {} indexed", stmtCount, indexCount);
        postIndex();
        needsIndexRebuild = false;
        return stmtCount;
    }
}
