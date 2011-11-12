/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model.indexer.lucene/src/com/ibm/adtech/boca/model/indexer/lucene/ModelIndexer.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: ModelIndexer.java 161 2007-07-31 14:11:06Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.indexer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.DateTools.Resolution;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.openanzo.datasource.nodecentric.internal.NodeCentricDatasource;
import org.openanzo.datasource.nodecentric.internal.NodeCentricOperationContext;
import org.openanzo.datasource.nodecentric.internal.StatementWrapper;
import org.openanzo.datasource.nodecentric.sql.StatementRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.StatementRdbWrapper.FindLiteralStatementsNRRangeResult;
import org.openanzo.datasource.nodecentric.sql.StatementRdbWrapper.FindLiteralStatementsRangeResult;
import org.openanzo.datasource.nodecentric.sql.StatementRdbWrapper.FindMinMaxIdResult;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.indexer.IndexerException;
import org.openanzo.indexer.lucene.LuceneConstants;
import org.openanzo.indexer.lucene.LuceneIndexerBase;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.INDEXER;
import org.openanzo.rdf.vocabulary.XMLSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Indexer for Anzo models based on Lucene.
 * 
 * @author Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 */
public class ModelIndexer extends LuceneIndexerBase<StatementWrapper, NodeCentricDatasource> {

    private static final Logger log = LoggerFactory.getLogger(ModelIndexer.class.getName());

    /**
     * Purge a namedGraph from index
     * 
     * @param graphId
     *            id of graph to purge
     * @throws IndexerException
     */
    public void purgeNamedGraph(Long graphId) throws IndexerException {
        try {
            IndexReader reader = IndexReader.open(FSDirectory.open(new File(location)), true);
            reader.deleteDocuments(new Term(LuceneConstants.INDEXER_FIELD_GRAPH_ID, graphId.toString()));
            reader.close();
        } catch (IOException ioe) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_DELETE_DOC, ioe);
        }
    }

    public boolean index(StatementWrapper statement) throws IndexerException {
        if (indexWriter != null) {
            Document doc = ModelIndexer.createDocument(statement);
            if (doc != null) {
                addDocument(doc);
                return true;
            }
        }
        return false;
    }

    public void remove(StatementWrapper statement) throws IndexerException {
        if (indexWriter != null) {
            deleteDocuments(new Term(LuceneConstants.INDEXER_FIELD_STMT_ID, statement.getId()));
        }
    }

    /**
     * Create a new IndexDocument for the statement provided
     * 
     * @param statementWrapper
     *            index wrapper around an Anzo Statement
     * @return the indexer's document for this statement
     */
    private static Document createDocument(StatementWrapper statementWrapper) {
        Document doc = null;
        Value objNode = statementWrapper.getObject();
        boolean index = false;
        if (objNode instanceof Literal) {
            Literal literal = (Literal) objNode;

            String text = null;
            if (literal instanceof PlainLiteral) {
                index = true;
                text = literal.getLabel();
            } else if (literal instanceof TypedLiteral) {
                URI type = ((TypedLiteral) literal).getDatatypeURI();
                if (type.equals(XMLSchema.STRING)) {
                    index = true;
                    text = literal.getLabel();
                } else {
                    // It's not an indexable type.
                    // Try index numbers or booleans?
                }
            }
            if (index) {
                doc = new Document();
                doc.add(new Field(LuceneConstants.INDEXER_FIELD_OBJECT, text, Field.Store.YES, Field.Index.ANALYZED));
                doc.add(new Field(INDEXER.INDEXER_FIELD_PREDICATE, statementWrapper.getPredicate().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                doc.add(new Field(INDEXER.INDEXER_FIELD_SUBJECT, statementWrapper.getSubject().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                doc.add(new Field(LuceneConstants.INDEXER_FIELD_PREDICATE_ID, statementWrapper.getPredicateId().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                doc.add(new Field(LuceneConstants.INDEXER_FIELD_SUBJECT_ID, statementWrapper.getSubjectId().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                doc.add(new Field(INDEXER.INDEXER_FIELD_GRAPH_URI, statementWrapper.getGraphURI().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                doc.add(new Field(LuceneConstants.INDEXER_FIELD_GRAPH_ID, statementWrapper.getGraphId().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                doc.add(new Field(LuceneConstants.INDEXER_FIELD_OBJ_NODE_ID, statementWrapper.getObjectId().toString(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                String id = statementWrapper.getId();
                doc.add(new Field(LuceneConstants.INDEXER_FIELD_STMT_ID, id, Field.Store.YES, Field.Index.NOT_ANALYZED));
                if (statementWrapper.getModified() != null) {
                    doc.add(new Field(LuceneConstants.INDEXER_FIELD_MODIFIED, DateTools.timeToString(statementWrapper.getModified().longValue(), Resolution.HOUR), Field.Store.YES, Field.Index.NOT_ANALYZED));
                }
            }
        }
        return doc;
    }

    private class IdQuad {
        long g;

        long s;

        long o;

        long p;

        IdQuad(long g, long s, long p, long o) {
            this.g = g;
            this.s = s;
            this.o = o;
            this.p = p;
        }
    }

    public int rebuild(NodeCentricDatasource datasource) throws IndexerException {
        clear();
        int stmtCount = 0;
        NodeCentricOperationContext context = null;
        try {
            context = datasource.getQueryContext(null);
            preIndex();
            long start = 0;
            long size = 20000;

            datasource.begin(context.getConnection(), false, false);
            try {

                FindMinMaxIdResult minMaxLiteral = StatementRdbWrapper.findMinMaxId(context.getStatementProvider(), context.getConnection(), "ANZO_L");
                long min = minMaxLiteral.getMin();
                long max = minMaxLiteral.getMax();
                start = min;
                long end = Math.min(max, start + size);
                while (start < end) {
                    if (end < max) {
                        log.error(LogUtils.RDB_MARKER, "Reindexing statements for literals:{}-{} of {}", new Object[] { Long.toString(start - min), Long.toString(end - min), Long.toString(max - min) });
                    } else {
                        log.info(LogUtils.RDB_MARKER, "Reindexing statements for literals:{}-{} of {}", new Object[] { Long.toString(start - min), Long.toString(end - min), Long.toString(max - min) });
                    }
                    stmtCount += findStatements(context, start, end);
                    start = start + size;
                    end = Math.min(max, start + size);
                }
                FindMinMaxIdResult minMaxLongLiteral = StatementRdbWrapper.findMinMaxId(context.getStatementProvider(), context.getConnection(), "ANZO_LL");
                min = minMaxLongLiteral.getMin();
                max = minMaxLongLiteral.getMax();
                start = min;
                end = Math.min(max, start + size);
                while (start < end) {
                    if (end < max) {
                        log.error(LogUtils.RDB_MARKER, "Reindexing statements for long literals:{}-{} of {}", new Object[] { Long.toString(start - min), Long.toString(end - min), Long.toString(max - min) });
                    } else {
                        log.info(LogUtils.RDB_MARKER, "Reindexing statements for long literals:{}-{} of {}", new Object[] { Long.toString(start - min), Long.toString(end - min), Long.toString(max - min) });

                    }
                    stmtCount += findStatements(context, start, end);
                    start = start + size;
                    end = Math.min(max, start + size);
                }
                FindMinMaxIdResult minMaxTypedLiteral = StatementRdbWrapper.findMinMaxId(context.getStatementProvider(), context.getConnection(), "ANZO_TL");
                min = minMaxTypedLiteral.getMin();
                max = minMaxTypedLiteral.getMax();
                start = min;
                end = Math.min(max, start + size);
                while (start < end) {
                    if (end < max) {
                        log.error(LogUtils.RDB_MARKER, "Reindexing statements for typed literals:{}-{} of {}", new Object[] { Long.toString(start - min), Long.toString(end - min), Long.toString(max - min) });
                    } else {
                        log.info(LogUtils.RDB_MARKER, "Reindexing statements for typed literals:{}-{} of {}", new Object[] { Long.toString(start - min), Long.toString(end - min), Long.toString(max - min) });

                    }
                    stmtCount += findStatements(context, start, end);
                    start = start + size;
                    end = Math.min(max, start + size);
                }
                FindMinMaxIdResult minMaxLongTypedLiteral = StatementRdbWrapper.findMinMaxId(context.getStatementProvider(), context.getConnection(), "ANZO_LTL");
                min = minMaxLongTypedLiteral.getMin();
                max = minMaxLongTypedLiteral.getMax();
                start = min;
                end = Math.min(max, start + size);
                while (start < end) {
                    if (end < max) {
                        log.error(LogUtils.RDB_MARKER, "Reindexing statements for long typed literals:{}-{} of {}", new Object[] { Long.toString(start - min), Long.toString(end - min), Long.toString(max - min) });
                    } else {
                        log.info(LogUtils.RDB_MARKER, "Reindexing statements for long typed literals:{}-{} of {}", new Object[] { Long.toString(start - min), Long.toString(end - min), Long.toString(max - min) });

                    }
                    stmtCount += findStatements(context, start, end);
                    start = start + size;
                    end = Math.min(max, start + size);
                }

            } finally {
                datasource.commit(context.getConnection(), false, false);
            }

            log.info(LogUtils.RDB_MARKER, "Index {} total statements", Integer.toString(stmtCount));
        } catch (AnzoException e) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_REBUILD, e);
        } finally {
            try {
                datasource.returnQueryContext(context);
            } catch (Exception e) {
                throw new IndexerException(ExceptionConstants.INDEX.FAILED_REBUILD, e);
            }
        }
        needsIndexRebuild = false;
        return stmtCount;
    }

    private long findStatements(NodeCentricOperationContext context, long start, long end) throws AnzoException {
        HashSet<Long> ids = new HashSet<Long>();
        ArrayList<IdQuad> list = new ArrayList<IdQuad>();
        long stmtCount = 0;
        for (FindLiteralStatementsRangeResult result : StatementRdbWrapper.findLiteralStatementsRange(context.getStatementProvider(), context.getConnection(), start, end)) {
            long g = result.getNamedGraphId();
            long s = result.getSubj();
            long p = result.getProp();
            long o = result.getObj();
            IdQuad quint = new IdQuad(g, s, p, o);
            list.add(quint);
            ids.add(g);
            ids.add(s);
            ids.add(p);
            ids.add(o);
        }
        for (FindLiteralStatementsNRRangeResult result : StatementRdbWrapper.findLiteralStatementsNRRange(context.getStatementProvider(), context.getConnection(), start, end)) {
            long g = result.getNamedGraphId();
            long s = result.getSubj();
            long p = result.getProp();
            long o = result.getObj();
            IdQuad quint = new IdQuad(g, s, p, o);
            list.add(quint);
            ids.add(g);
            ids.add(s);
            ids.add(p);
            ids.add(o);
        }

        if (list.size() > 0) {
            Map<Long, Value> nodes = context.getNodeLayout().resolveStoredIds(ids, context.getConnection());
            for (IdQuad quad : list) {
                StatementWrapper sw = new StatementWrapper((URI) nodes.get(quad.g), quad.g, (Resource) nodes.get(quad.s), quad.s, (URI) nodes.get(quad.p), quad.p, nodes.get(quad.o), quad.o, Long.valueOf(0));
                index(sw);
                stmtCount++;
            }
            ids.clear();
            list.clear();
        }
        postIndex();
        return stmtCount;
    }
}
