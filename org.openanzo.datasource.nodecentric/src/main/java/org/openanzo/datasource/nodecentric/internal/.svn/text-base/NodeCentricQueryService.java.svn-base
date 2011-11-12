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

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Map;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.nodecentric.query.ServerEngineConfig;
import org.openanzo.datasource.nodecentric.query.ServerSolutionGenerator;
import org.openanzo.datasource.nodecentric.query.predicates.TextLikePredicate;
import org.openanzo.datasource.services.BaseQueryService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.glitter.exception.GlitterParseException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.TextMatchPredicate;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.jdbc.query.IRdbValue;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.ISolutionGeneratorProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class NodeCentricQueryService extends BaseQueryService implements ISolutionGeneratorProvider {
    private static final Logger         log                = LoggerFactory.getLogger(NodeCentricQueryService.class);

    private final NodeCentricDatasource datasource;

    ServerEngineConfig                  prepopulatedConfig = new ServerEngineConfig(true);

    ServerEngineConfig                  config             = new ServerEngineConfig(false);

    Engine                              engine;

    /**
     * Create QueryService
     * 
     * @param datasource
     *            parent datasource
     * @param cacheProvider
     *            cache provider
     */
    public NodeCentricQueryService(NodeCentricDatasource datasource, ICacheProvider cacheProvider) {
        this.datasource = datasource;
        initCache(cacheProvider);
        config.registerFunctionalPredicate(org.openanzo.glitter.util.Constants.TEXTMATCHPREDICATE, TextMatchPredicate.class);
        config.registerFunctionalPredicate(org.openanzo.glitter.util.Constants.TEXTLIKEPREDICATE, TextLikePredicate.class);
        engine = new Engine(config);
    }

    public IDatasource getDatasource() {
        return datasource;
    }

    public SolutionGenerator acquireSolutionGenerator(IOperationContext context) {
        try {
            NodeCentricOperationContext connectionContext = datasource.getQueryContext(context);
            return acquireSolutionGenerator(connectionContext);

        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

    private final ThreadLocal<Integer> transactionDepth = new ThreadLocal<Integer>();

    private SolutionGenerator acquireSolutionGenerator(NodeCentricOperationContext context) {
        try {
            Integer depth = transactionDepth.get();
            int d = 0;
            if (depth != null)
                d = depth.intValue();
            log.info(LogUtils.RDB_MARKER, "begin transaction depth: {}", d);
            if (d == 0) {
                log.info(LogUtils.RDB_MARKER, "beginning transaction: {}", context);
                datasource.begin(context.getConnection(), false, false);
            }
            transactionDepth.set(d++);

            ServerSolutionGenerator solutionGenerator = prepopulatedConfig.getSolutionGeneratorFactory().getSolutionGenerator();
            solutionGenerator.setContext(context);
            return solutionGenerator;
        } catch (RdbException e) {
            throw new AnzoRuntimeException(ExceptionConstants.SERVER.QUERY_FAILED_ERROR, e);
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

    public void releaseSolutionGenerator(SolutionGenerator solutionGenerator) throws AnzoException {
        ServerSolutionGenerator generator = (ServerSolutionGenerator) solutionGenerator;
        NodeCentricOperationContext context = generator.getContext();
        Integer depth = transactionDepth.get();
        if (depth == null)
            depth = 0;
        else
            transactionDepth.set(depth--);
        log.info(LogUtils.RDB_MARKER, "complete transaction depth: {}", depth);
        if (depth <= 0) {
            log.info(LogUtils.RDB_MARKER, "commiting transaction: {}", context);
            datasource.commit(context.getConnection(), false, false);
            transactionDepth.set(0);
        }
        if (context != null) {
            datasource.returnQueryContext(context);
        }
    }

    @Override
    protected QueryResults executeQueryInternal(IOperationContext context, QueryDataset uriSet, String query, URI baseUri) throws AnzoException {
        log.info(LogUtils.RDB_MARKER, "Query received: {}", query);
        NodeCentricOperationContext connectionContext = null;
        try {
            long start = -1;
            if (RequestAnalysis.isAnalysisEnabled()) {
                start = System.currentTimeMillis();
            }
            connectionContext = datasource.getQueryContext(context);
            ServerSolutionGenerator solutionGenerator = config.getSolutionGeneratorFactory().getSolutionGenerator();
            solutionGenerator.setContext(connectionContext);
            try {

                boolean isMine = !datasource.isInTransaction(connectionContext.getConnection());
                if (isMine)
                    datasource.begin(connectionContext.getConnection(), false, false);
                if (RequestAnalysis.isAnalysisEnabled()) {
                    long end = System.currentTimeMillis();
                    RequestAnalysis.addAnalysisProperty("queryGetConnection", (end - start));
                }
                try {
                    if (RequestAnalysis.isAnalysisEnabled()) {
                        start = System.currentTimeMillis();
                    }
                    QueryResults executeQuery = engine.executeQuery(solutionGenerator, query, uriSet, baseUri);
                    if (RequestAnalysis.isAnalysisEnabled()) {
                        long end = System.currentTimeMillis();
                        RequestAnalysis.addAnalysisProperty("glitterExecuteQuery", (end - start));
                    }
                    // populate all nodes before returning connections
                    // TODO: this should be done as a bulk operation for all the nodes that need to be populated
                    if (RequestAnalysis.isAnalysisEnabled()) {
                        start = System.currentTimeMillis();
                    }
                    if (executeQuery.isSelectResult()) {
                        HashSet<Long> ids = new HashSet<Long>();
                        for (PatternSolution sol : executeQuery.getSelectResults()) {
                            for (int i = 0; i < sol.size(); i++) {
                                if (sol.getBinding(i) instanceof IRdbValue && !((IRdbValue) sol.getBinding(i)).populated()) {
                                    ids.add(((IRdbValue) sol.getBinding(i)).getId());
                                }
                                if (sol.getValue(i) instanceof IRdbValue && !((IRdbValue) sol.getValue(i)).populated()) {
                                    ids.add(((IRdbValue) sol.getValue(i)).getId());
                                }
                            }
                        }
                        Map<Long, Value> values = connectionContext.getNodeLayout().resolveStoredIds(ids, connectionContext.getConnection());
                        for (PatternSolution sol : executeQuery.getSelectResults()) {
                            for (int i = 0; i < sol.size(); i++) {
                                if (sol.getBinding(i) instanceof IRdbValue && !((IRdbValue) sol.getBinding(i)).populated()) {
                                    ((IRdbValue) sol.getBinding(i)).setValue(values.get((((IRdbValue) sol.getBinding(i)).getId())));
                                }
                                if (sol.getValue(i) instanceof IRdbValue && !((IRdbValue) sol.getValue(i)).populated()) {
                                    ((IRdbValue) sol.getValue(i)).setValue(values.get((((IRdbValue) sol.getValue(i)).getId())));
                                }
                            }
                        }
                    } else if (executeQuery.isConstructResult() || executeQuery.isDescribeResult()) {
                        HashSet<Long> ids = new HashSet<Long>();
                        for (org.openanzo.rdf.Statement stmt : executeQuery.getConstructResults()) {
                            if (stmt.getSubject() instanceof IRdbValue && !((IRdbValue) stmt.getSubject()).populated()) {
                                ids.add(((IRdbValue) stmt.getSubject()).getId());
                            }
                            if (stmt.getPredicate() instanceof IRdbValue && !((IRdbValue) stmt.getPredicate()).populated()) {
                                ids.add(((IRdbValue) stmt.getPredicate()).getId());
                            }
                            if (stmt.getObject() instanceof IRdbValue && !((IRdbValue) stmt.getObject()).populated()) {
                                ids.add(((IRdbValue) stmt.getObject()).getId());
                            }
                            if (stmt.getNamedGraphUri() instanceof IRdbValue && !((IRdbValue) stmt.getNamedGraphUri()).populated()) {
                                ids.add(((IRdbValue) stmt.getNamedGraphUri()).getId());
                            }
                        }
                        Map<Long, Value> values = connectionContext.getNodeLayout().resolveStoredIds(ids, connectionContext.getConnection());
                        for (org.openanzo.rdf.Statement stmt : executeQuery.getConstructResults()) {
                            if (stmt.getSubject() instanceof IRdbValue && !((IRdbValue) stmt.getSubject()).populated()) {
                                ((IRdbValue) stmt.getSubject()).setValue(values.get((((IRdbValue) stmt.getSubject()).getId())));
                            }
                            if (stmt.getPredicate() instanceof IRdbValue && !((IRdbValue) stmt.getPredicate()).populated()) {
                                ((IRdbValue) stmt.getPredicate()).setValue(values.get((((IRdbValue) stmt.getPredicate()).getId())));
                            }
                            if (stmt.getObject() instanceof IRdbValue && !((IRdbValue) stmt.getObject()).populated()) {
                                ((IRdbValue) stmt.getObject()).setValue(values.get((((IRdbValue) stmt.getObject()).getId())));
                            }
                            if (stmt.getNamedGraphUri() instanceof IRdbValue && !((IRdbValue) stmt.getNamedGraphUri()).populated()) {
                                ((IRdbValue) stmt.getNamedGraphUri()).setValue(values.get((((IRdbValue) stmt.getNamedGraphUri()).getId())));
                            }
                        }
                    }
                    if (RequestAnalysis.isAnalysisEnabled()) {
                        long end = System.currentTimeMillis();
                        RequestAnalysis.addAnalysisProperty("queryPopulateResultNodes", (end - start));
                    }
                    return executeQuery;
                } finally {
                    if (isMine)
                        datasource.commit(connectionContext.getConnection(), false, false);
                }
            } catch (ParseException e) {
                throw new GlitterParseException(e, query, e.getMessage());
            }
        } catch (RdbException e) {
            log.error(LogUtils.RDB_MARKER, "Error executing sql query for sparql", e);
            throw new AnzoException(ExceptionConstants.SERVER.QUERY_FAILED_ERROR, e, query);
        } finally {
            if (connectionContext != null) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    private void populateRdbNode(Object node, Connection connection) throws RdbException {
        if (node instanceof IRdbValue) {
            IRdbValue value = (IRdbValue) node;
            value.populate(connection);
        }
    }

    public boolean cancel(IOperationContext context, String operationId) throws AnzoException {
        return engine.cancelQuery(operationId);
    }

    public void cancel(IOperationContext context, String operationId, Writer output) throws AnzoException {
        boolean ok = cancel(context, operationId);
        try {
            output.write(Boolean.toString(ok));
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
        }
    }
}
