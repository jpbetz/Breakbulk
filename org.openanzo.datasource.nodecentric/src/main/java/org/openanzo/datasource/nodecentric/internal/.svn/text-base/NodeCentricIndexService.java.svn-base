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

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.nodecentric.indexer.ModelIndexQuery;
import org.openanzo.datasource.nodecentric.indexer.ModelIndexerFactory;
import org.openanzo.datasource.services.BaseIndexService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.query.TextMatchPredicate.TextMatchQuery;
import org.openanzo.indexer.IQuery;
import org.openanzo.indexer.IResult;
import org.openanzo.indexer.IndexerProperties;
import org.openanzo.indexer.lucene.LuceneConstants;
import org.openanzo.indexer.lucene.LuceneProperties;
import org.openanzo.indexer.lucene.LuceneSearch;
import org.openanzo.jdbc.layout.Quad;
import org.openanzo.jdbc.query.IRdbValue;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IRDFHandler;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.Collections;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.Privilege;

/**
 * NodeCentric implementation of the IIndexService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class NodeCentricIndexService extends BaseIndexService {
    //private static final Logger   logger                   = LoggerFactory.getLogger(NodeCentricIndexService.class);

    private ModelIndexerFactory         indexerFactory = null;

    private LuceneSearch                search         = null;

    private final NodeCentricDatasource datasource;

    private String                      indexLocation  = null;

    /**
     * Create a new NodeCentricIndexService
     * 
     * @param datasource
     *            parent datasource
     */
    public NodeCentricIndexService(NodeCentricDatasource datasource) {
        this.datasource = datasource;
    }

    public IDatasource getDatasource() {
        return datasource;
    }

    @Override
    public void start() throws AnzoException {
        indexLocation = (String) datasource.getConfigurationParameters().get(LuceneProperties.KEY_LUCENE_INDEX_LOCATION);
        int pageSize = 0;
        String indexPageSize = (String) datasource.getConfigurationParameters().get(IndexerProperties.KEY_INDEXER_PAGE_SIZE);
        if (indexPageSize != null) {
            pageSize = Integer.parseInt(indexPageSize);
        }
        indexerFactory = new ModelIndexerFactory();
        search = indexerFactory.createSearchFromLocation(indexLocation);
        search.setPageSize(pageSize);
    }

    /**
     * Query the text indexer for a set of statements that match a text indexer query
     * 
     * @param context
     *            context for this operation
     * @param query
     *            query string
     * @param offset
     *            index of first result to return
     * @param limit
     *            maximum number of results to return
     * @param handler
     *            Call-back handler that handles the results of this query
     * @throws AnzoException
     */
    @Override
    protected void executeIndexQueryInternal(IOperationContext context, String query, int offset, int limit, IRDFHandler handler) throws AnzoException {
        if (indexerFactory != null && search != null) {
            NodeCentricOperationContext connectionContext = null;
            try {
                handler.startRDF();
                connectionContext = datasource.getQueryContext(context);
                IQuery indexQuery = indexerFactory.createQueryFromDefaultFieldAndText(LuceneConstants.INDEXER_FIELD_OBJECT, query);
                List<IResult> results = search.executeQuery(indexQuery);
                HashMap<Long, Boolean> acls = new HashMap<Long, Boolean>();
                if (offset == 0 && limit == -1) {
                    for (IResult result : results) {
                        Statement sw = processResult(connectionContext, result, acls);
                        if (sw != null) {
                            handler.handleStatement(sw);
                        }
                    }
                } else {
                    int resultCount = 0;
                    int returnCount = 0;
                    if (offset <= results.size()) {
                        Iterator<IResult> resultsIterator = results.iterator();
                        while (resultsIterator.hasNext() && returnCount < limit) {
                            IResult result = resultsIterator.next();
                            Statement sw = processResult(connectionContext, result, acls);
                            if (sw != null) {
                                resultCount++;
                                if (resultCount > offset) {
                                    handler.handleStatement(sw);
                                    returnCount++;
                                    if (limit >= 0 && returnCount >= limit) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                handler.endRDF();

            } finally {
                if (connectionContext != null) {
                    datasource.returnQueryContext(connectionContext);
                }
            }
        } else {
            throw new AnzoException(ExceptionConstants.INDEX.NOT_INITIALIZED);
        }
        // return statements;
    }

    /**
     * Turns the results of an index query into a StatementWrapper. Returns null if it is not visible.
     * 
     * @param context
     *            context for this operation
     * @param result
     *            result to convert
     * @param acls
     *            map of NamedGraph IDs to a boolean specifying if graph is visible for the userid
     * @return statement wrapper for result
     * @throws AnzoException
     */
    private Statement processResult(NodeCentricOperationContext connectionContext, IResult result, HashMap<Long, Boolean> acls) throws AnzoException {
        Long ngId = Long.valueOf(result.getFieldValue(LuceneConstants.INDEXER_FIELD_GRAPH_ID));
        Boolean canRead = connectionContext.getOperationPrincipal().isSysadmin() ? Boolean.TRUE : acls.get(ngId);
        URI ngURI = (URI) connectionContext.getNodeLayout().fetchValue(ngId, connectionContext.getConnection());
        if (canRead == null) {
            Set<URI> roles = datasource.getAuthorizationService().getRolesForGraph(connectionContext, ngURI, Privilege.READ);
            canRead = Boolean.valueOf(Collections.memberOf(roles, connectionContext.getOperationPrincipal().getRoles()));
            acls.put(ngId, canRead);
        }
        if (canRead.booleanValue()) {
            Long subjectId = Long.valueOf(result.getFieldValue(LuceneConstants.INDEXER_FIELD_SUBJECT_ID));
            Long predicateId = Long.valueOf(result.getFieldValue(LuceneConstants.INDEXER_FIELD_PREDICATE_ID));
            Long objId = Long.valueOf(result.getFieldValue(LuceneConstants.INDEXER_FIELD_OBJ_NODE_ID));
            Resource subj = (Resource) connectionContext.getNodeLayout().fetchValue(subjectId, connectionContext.getConnection());
            URI pred = (URI) connectionContext.getNodeLayout().fetchValue(predicateId, connectionContext.getConnection());
            Value obj = connectionContext.getNodeLayout().fetchValue(objId, connectionContext.getConnection());
            return Constants.valueFactory.createStatement(subj, pred, obj, ngURI);
        }
        return null;
    }

    @Override
    public Collection<Statement> executeIndexQueryInternal(IOperationContext context, String query, int offset, int limit) throws AnzoException {
        return executeIndexQueryInternal(context, query, offset, limit, false);
    }

    /**
     * Query the text indexer for a set of statements that match a text indexer query
     * 
     * @param context
     *            context for this operation
     * @param query
     *            query string
     * @param offset
     *            index of first result to return
     * @param limit
     *            maximum number of results to return
     * @param prepopulateSolutionNodes
     *            should the index query populate the values of solution nodes before returning?
     * @return set of statements that match a text indexer query
     * @throws AnzoException
     */
    private Collection<Statement> executeIndexQueryInternal(IOperationContext context, String query, int offset, int limit, boolean prepopulateSolutionNodes) throws AnzoException {
        if (indexerFactory == null || search == null) {
            throw new AnzoException(ExceptionConstants.INDEX.NOT_INITIALIZED);
        }
        ArrayList<Statement> resultStatements = new ArrayList<Statement>();
        NodeCentricOperationContext connectionContext = null;
        try {
            connectionContext = datasource.getQueryContext(context);
            IQuery indexQuery = indexerFactory.createQueryFromDefaultFieldAndText(LuceneConstants.INDEXER_FIELD_OBJECT, query);
            List<IResult> results = search.executeQuery(indexQuery);
            HashMap<Long, Boolean> acls = new HashMap<Long, Boolean>();
            if (offset == 0 && limit == -1) {
                for (IResult result : results) {
                    StatementWrapper sw = processResultToWrapper(connectionContext, result, acls);
                    if (sw != null) {
                        Quad q = new Quad(connectionContext.getConnection(), connectionContext.getNodeLayout().getNodeConverter(), sw.getGraphId(), sw.getSubjectId(), sw.getPredicateId(), sw.getObjectId());
                        resultStatements.add(q.asStatement());
                    }
                }
            } else {
                int resultCount = 0;
                int returnCount = 0;
                if (offset <= results.size()) {
                    Iterator<IResult> resultsIterator = results.iterator();
                    while (resultsIterator.hasNext() && returnCount < limit) {
                        IResult result = resultsIterator.next();
                        StatementWrapper sw = processResultToWrapper(connectionContext, result, acls);
                        if (sw != null) {
                            resultCount++;
                            if (resultCount > offset) {
                                Quad q = new Quad(connectionContext.getConnection(), connectionContext.getNodeLayout().getNodeConverter(), sw.getGraphId(), sw.getSubjectId(), sw.getPredicateId(), sw.getObjectId());
                                resultStatements.add(q.asStatement());
                                returnCount++;
                                if (limit >= 0 && returnCount >= limit) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (prepopulateSolutionNodes) {
                for (Statement statement : resultStatements) {
                    populateRdbNode(statement.getSubject(), connectionContext.getConnection());
                    populateRdbNode(statement.getPredicate(), connectionContext.getConnection());
                    populateRdbNode(statement.getObject(), connectionContext.getConnection());
                    populateRdbNode(statement.getNamedGraphUri(), connectionContext.getConnection());
                }
            }
            return resultStatements;
        } finally {
            if (connectionContext != null) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    /**
     * Query the text indexer for a set of statements that match a text indexer query
     * 
     * @param context
     *            context for this operation
     * @param query
     *            query string
     * @param offset
     *            index of first result to return
     * @param limit
     *            maximum number of results to return
     * @param prepopulateSolutionNodes
     *            should the index query populate the values of solution nodes before returning?
     * @return set of statements that match a text indexer query
     * @throws AnzoException
     */
    @Override
    public Collection<Statement> executeIndexQueryInternal(IOperationContext context, TextMatchQuery query, int offset, int limit) throws AnzoException {
        if (indexerFactory == null || search == null) {
            throw new AnzoException(ExceptionConstants.INDEX.NOT_INITIALIZED);
        }
        ArrayList<Statement> resultStatements = new ArrayList<Statement>();
        NodeCentricOperationContext connectionContext = null;
        try {
            connectionContext = datasource.getQueryContext(context);
            ModelIndexQuery indexQuery = indexerFactory.createQueryFromDefaultFieldAndTextAndTerms(LuceneConstants.INDEXER_FIELD_OBJECT, query.literalQuery, query.terms);
            List<IResult> results = search.executeQuery(indexQuery);
            HashMap<Long, Boolean> acls = new HashMap<Long, Boolean>();
            if (offset == 0 && limit == -1) {
                for (IResult result : results) {
                    StatementWrapper sw = processResultToWrapper(connectionContext, result, acls);
                    if (sw != null) {
                        Quad q = new Quad(connectionContext.getConnection(), connectionContext.getNodeLayout().getNodeConverter(), sw.getGraphId(), sw.getSubjectId(), sw.getPredicateId(), sw.getObjectId());
                        resultStatements.add(q.asStatement());
                    }
                }
            } else {
                int resultCount = 0;
                int returnCount = 0;
                if (offset <= results.size()) {
                    Iterator<IResult> resultsIterator = results.iterator();
                    while (resultsIterator.hasNext() && returnCount < limit) {
                        IResult result = resultsIterator.next();
                        StatementWrapper sw = processResultToWrapper(connectionContext, result, acls);
                        if (sw != null) {
                            resultCount++;
                            if (resultCount > offset) {
                                Quad q = new Quad(connectionContext.getConnection(), connectionContext.getNodeLayout().getNodeConverter(), sw.getGraphId(), sw.getSubjectId(), sw.getPredicateId(), sw.getObjectId());
                                resultStatements.add(q.asStatement());
                                returnCount++;
                                if (limit >= 0 && returnCount >= limit) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            for (Statement statement : resultStatements) {
                populateRdbNode(statement.getSubject(), connectionContext.getConnection());
                populateRdbNode(statement.getPredicate(), connectionContext.getConnection());
                populateRdbNode(statement.getObject(), connectionContext.getConnection());
                populateRdbNode(statement.getNamedGraphUri(), connectionContext.getConnection());
            }
            return resultStatements;
        } finally {
            if (connectionContext != null) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    /**
     * Turns the results of an index query into a StatementWrapper. Returns null if it is not visible.
     * 
     * @param context
     *            context for this operation
     * @param result
     *            result to convert
     * @param acls
     *            map of NamedGraph IDs to a boolean specifying if graph is visible for the userid
     * @return statement wrapper for result
     * @throws AnzoException
     */
    protected StatementWrapper processResultToWrapper(NodeCentricOperationContext connectionContext, IResult result, HashMap<Long, Boolean> acls) throws AnzoException {
        Long ngId = Long.valueOf(result.getFieldValue(LuceneConstants.INDEXER_FIELD_GRAPH_ID));
        Boolean canRead = connectionContext.getOperationPrincipal().isSysadmin() ? Boolean.TRUE : acls.get(ngId);
        URI ngURI = (URI) connectionContext.getNodeLayout().fetchValue(ngId, connectionContext.getConnection());
        if (canRead == null) {
            Set<URI> roles = datasource.getAuthorizationService().getRolesForGraph(connectionContext, ngURI, Privilege.READ);
            canRead = Boolean.valueOf(Collections.memberOf(roles, connectionContext.getOperationPrincipal().getRoles()));
            acls.put(ngId, canRead);
        }
        if (canRead.booleanValue()) {
            Long subjectId = Long.valueOf(result.getFieldValue(LuceneConstants.INDEXER_FIELD_SUBJECT_ID));
            Long predicateId = Long.valueOf(result.getFieldValue(LuceneConstants.INDEXER_FIELD_PREDICATE_ID));
            Long objId = Long.valueOf(result.getFieldValue(LuceneConstants.INDEXER_FIELD_OBJ_NODE_ID));
            return new StatementWrapper(ngId, subjectId, predicateId, objId, null);
        }
        return null;
    }

    private void populateRdbNode(Object node, Connection connection) throws RdbException {
        if (node instanceof IRdbValue) {
            IRdbValue value = (IRdbValue) node;
            value.populate(connection);
        }
    }

}
