/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/Engine.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: Engine.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter;

import java.io.Reader;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.glitter.exception.ConfigurationException;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.exception.QueryRefusedException;
import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.OrderingCondition;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryExecutionPlan;
import org.openanzo.glitter.query.QueryExecutor;
import org.openanzo.glitter.query.QueryResultForm;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.query.SolutionSorter;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.glitter.query.rewriter.FunctionalPredicateRewriter;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.glitter.syntax.concrete.SPARQLParser;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.URI;

/**
 * The core Glitter engine. Provides the basic framework for parsing and executing SPARQL queries in Glitter.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Engine {
    static final java.util.Hashtable<String, QueryController> controllers = new java.util.Hashtable<String, QueryController>();

    private EngineConfig                                      configuration;
    static {
        StandardBasis.registerStandardFunctions();
    }

    /**
     * 
     * @param configuration
     *            Contains configuration settings for this Glitter Engine instance
     */
    public Engine(EngineConfig configuration) {
        this.configuration = configuration;
    }

    /**
     * 
     * @return The {@link EngineConfig} for this Glitter engine.
     */
    public EngineConfig getConfiguration() {
        return this.configuration;
    }

    /**
     * 
     * @param configuration
     *            New {@link EngineConfig} for this Glitter engine.
     */
    public void setConfiguration(EngineConfig configuration) {
        this.configuration = configuration;
    }

    /**
     * Performs the following steps to prepare the query for execution:<br>
     * 1) parse the query <br>
     * 2) retrieve a query controller<br>
     * 2.5) rewrite the tree as specified in the configuration (this includes rewriting any BGPs that contain functional predicates)<br>
     * 2.6) validate that the query is acceptable as specified in the configuration <br>
     * 3) Load a SolutionGenerator and an RDFDataset <br>
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            The query to be executed.
     * @return A {@link QueryController} that summarizes the parsed and prepared query.
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryController prepareQuery(SolutionGenerator sg, String query) throws ParseException, GlitterException {
        return _prepareQuery(getParser(query), sg, null, null);
    }

    /**
     * See {@link #prepareQuery(SolutionGenerator,String)}
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            Provides the query to be executed
     * @return A {@link QueryController} that summarizes the parsed and prepared query.
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryController prepareQuery(SolutionGenerator sg, Reader query) throws ParseException, GlitterException {
        return _prepareQuery(getParser(query), sg, null, null);
    }

    /**
     * See {@link #prepareQuery(SolutionGenerator,String)}
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            Provides the query to be executed
     * @param defaultGraphs
     *            Identifies the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            Identifies the named graph components of the query's RDF Dataset
     * @param baseUri
     *            The base URI against which relative URI references in the query are resolved
     * @return A {@link QueryController} that summarizes the parsed and prepared query.
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryController prepareQuery(SolutionGenerator sg, String query, QueryDataset queryDataset, URI baseUri) throws ParseException, GlitterException {
        return _prepareQuery(getParser(query), sg, queryDataset, baseUri);
    }

    /**
     * Combines preparing and executing a query as per {@link #prepareQuery(SolutionGenerator,String)}
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            Provides the query to be executed
     * @return The results of executing the query
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryResults executeQuery(SolutionGenerator sg, String query) throws ParseException, GlitterException {
        return _query(getParser(query), sg, null, null);
    }

    /**
     * Combines preparing and executing a query as per {@link #prepareQuery(SolutionGenerator,String)}
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            Provides the query to be executed
     * @return The results of executing the query
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryResults executeQuery(SolutionGenerator sg, Reader query) throws ParseException, GlitterException {
        return _query(getParser(query), sg, null, null);
    }

    /**
     * Combines preparing and executing a query as per {@link #prepareQuery(SolutionGenerator,String)}
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            Provides the query to be executed
     * @param defaultGraphs
     *            Identifies the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            Identifies the named graph components of the query's RDF Dataset
     * @return The results of executing the query
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryResults executeQuery(SolutionGenerator sg, String query, QueryDataset queryDataset) throws ParseException, GlitterException {
        return _query(getParser(query), sg, queryDataset, null);
    }

    /**
     * Combines preparing and executing a query as per {@link #prepareQuery(SolutionGenerator,String)}
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            Provides the query to be executed
     * @param defaultGraphs
     *            Identifies the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            Identifies the named graph components of the query's RDF Dataset
     * @return The results of executing the query
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryResults executeQuery(SolutionGenerator sg, Reader query, QueryDataset queryDataset) throws ParseException, GlitterException {
        return _query(getParser(query), sg, queryDataset, null);
    }

    /**
     * Combines preparing and executing a query as per {@link #prepareQuery(SolutionGenerator,String)}
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            Provides the query to be executed
     * @param defaultGraphs
     *            Identifies the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            Identifies the named graph components of the query's RDF Dataset
     * @param baseUri
     *            The base URI against which relative URI references in the query are resolved
     * @return The results of executing the query
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryResults executeQuery(SolutionGenerator sg, String query, QueryDataset queryDataset, URI baseUri) throws ParseException, GlitterException {
        return _query(getParser(query), sg, queryDataset, baseUri);
    }

    /**
     * Combines preparing and executing a query as per {@link #prepareQuery(SolutionGenerator,String)}
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            Provides the query to be executed
     * @param defaultGraphs
     *            Identifies the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            Identifies the named graph components of the query's RDF Dataset
     * @param baseUri
     *            The base URI against which relative URI references in the query are resolved
     * @return The results of executing the query
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryResults executeQuery(SolutionGenerator sg, String query, Set<URI> dgs, Set<URI> ngs) throws ParseException, GlitterException {
        return _query(getParser(query), sg, new DefaultQueryDataset(dgs, ngs), null);
    }

    /**
     * Combines preparing and executing a query as per {@link #prepareQuery(SolutionGenerator,String)}
     * 
     * @param sg
     *            solution generator to use, if null, factory is used
     * @param query
     *            Provides the query to be executed
     * @param defaultGraphs
     *            Identifies the graphs that will be merged to form the default graph in the query's RDF Dataset
     * @param namedGraphs
     *            Identifies the named graph components of the query's RDF Dataset
     * @param baseUri
     *            The base URI against which relative URI references in the query are resolved
     * @return The results of executing the query
     * @throws ParseException
     * @throws GlitterException
     */
    public QueryResults executeQuery(SolutionGenerator sg, Reader query, QueryDataset queryDataset, URI baseUri) throws ParseException, GlitterException {
        return _query(getParser(query), sg, queryDataset, baseUri);
    }

    private QueryResults _query(SPARQLParser parser, SolutionGenerator sg, QueryDataset queryDataset, URI baseUri) throws ParseException, GlitterException {

        long start = -1;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        QueryController qc = _prepareQuery(parser, sg, queryDataset, baseUri);
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            RequestAnalysis.addAnalysisProperty("glitterPrepareQuery", (end - start));
        }
        return executeQuery(qc);
    }

    private QueryController _prepareQuery(SPARQLParser parser, SolutionGenerator sg, QueryDataset dataset, URI baseUri) throws ParseException, GlitterException {
        // 1)
        QueryController controller = parser.getQueryController();
        if (baseUri != null)
            controller.setBaseUri(baseUri);
        // 2)
        parser.Query();
        // 2.5)

        StringBuilder sb = null;
        StringBuilder sb2 = null;
        int i = 0;
        do {
            sb = new StringBuilder();
            sb2 = new StringBuilder();
            controller.getQueryPattern().prettyPrint(sb, true);
            for (TreeRewriter rewriter : this.configuration.getTreeRewriters()) {
                controller.setQueryPattern((GraphPattern) Glitter.rewriteTree(controller.getQueryPattern(), rewriter));
            }
            controller.getQueryPattern().prettyPrint(sb2, true);
        } while (i++ < 5 && !sb.toString().equals(sb2.toString()));
        Map<URI, Class<? extends FunctionalPredicate>> fpMap = this.configuration.getFunctionalPredicates();
        if (fpMap != null) {
            FunctionalPredicateRewriter fpr = new FunctionalPredicateRewriter(fpMap, controller);
            controller.setQueryPattern((GraphPattern) Glitter.rewriteTree(controller.getQueryPattern(), fpr));
        }
        // 2.6)
        for (QueryValidator validator : this.configuration.getQueryValidators()) {
            if (!validator.validateQuery(controller))
                throw new QueryRefusedException(validator.getValidationError());
        }
        // 3)
        if (sg == null) {
            sg = this.getConfiguration().getSolutionGeneratorFactory().getSolutionGenerator();
        }

        QueryExecutionPlan plan = null;
        try {
            plan = this.configuration.getQueryExecutionPlan(sg);
        } catch (ExceptionInInitializerError e) {
            throw new ConfigurationException(e.getCause());
        }
        // either populate our dataset externally (priority) or else from the
        // query controller
        if (dataset != null && !dataset.isEmpty()) {
            controller.setDatasetFromQuery(false);
            controller.setQueryDataset(dataset);
        } else {
            controller.setDatasetFromQuery(true);
        }
        sg.setQueryInformation(controller);
        sg.setQueryDataset(controller.getQueryDataset());
        sg.setQueryExecutionPlan(plan);
        controller.setSolutionGenerator(sg);
        controller.setEngine(this);
        return controller;
    }

    /**
     * Executes a query. An overload of {@link #prepareQuery(SolutionGenerator,String)} must be called first.<br>
     * 4) create a query executor <br>
     * 5) execute the query <br>
     * 6) Apply query modifiers (ORDER BY, LIMIT, OFFSET) <br>
     * 7) Produce and return a result form
     * 
     * @param controller
     *            The {@link QueryController} that contains information about a parsed and prepared query.
     * @return The results of executing the query.
     * @throws GlitterException
     */
    public QueryResults executeQuery(QueryController controller) throws GlitterException {
        if (controller.getSolutionGenerator() != null && controller.getSolutionGenerator().getQueryId() != null) {
            controllers.put(controller.getSolutionGenerator().getQueryId(), controller);
        }
        try {
            SolutionGenerator sg = controller.getSolutionGenerator();
            // 4)
            // fetch an appropriate query executor based on the query itself (as
            // embodied
            // by the QueryController) and based upon our backend solutions
            // provider.
            QueryExecutor qe = getQueryExecutor(controller, sg);
            // 5)
            SolutionSet solutions = null;
            try {
                long start = -1;
                boolean isEnabled = RequestAnalysis.isAnalysisEnabled();
                if (isEnabled) {
                    start = System.currentTimeMillis();
                }
                sg.initialize();
                if (isEnabled) {
                    long end = System.currentTimeMillis();
                    RequestAnalysis.addAnalysisProperty("sgInitialize", (end - start));
                }

                if (isEnabled) {
                    start = System.currentTimeMillis();
                }
                solutions = qe.executeQuery();
                if (isEnabled) {
                    long end = System.currentTimeMillis();
                    RequestAnalysis.addAnalysisProperty("engineExecuteQuery", (end - start));
                }
            } finally {
                sg.cleanup();
            }

            return postProcessSolutions(solutions, !qe.composedSolutions() && sg.sortedSolutions(), controller);
        } finally {
            if (controller.getSolutionGenerator() != null && controller.getSolutionGenerator().getQueryId() != null) {
                controllers.remove(controller.getSolutionGenerator().getQueryId());
            }
        }
    }

    /**
     * @param solutions
     * @param solutionsAreSorted
     * @param controller
     * @return query results
     * @throws GlitterException
     */
    public QueryResults postProcessSolutions(SolutionSet solutions, boolean solutionsAreSorted, QueryController controller) throws GlitterException {
        // SPARQL mandates that projection/distinct (which are only properties
        // of
        // SELECT queries) occur at this point, before LIMIT and OFFSET are
        // applied.
        // We handle this by allowing the result forms to refine the solution
        // list
        // as it sees fit.
        QueryResultForm resultForm = controller.getQueryResultForm();
        solutions = resultForm.refineSolutionsBeforeOrdering(solutions);

        // 6)
        // the first modifier to be applied is ORDER BY. there's a chance that
        // the SolutionGenerator may have already ordered the solutions.
        if (!solutionsAreSorted) {
            List<OrderingCondition> orderingConditions = controller.getOrderingConditions();
            if (orderingConditions.size() > 0) {
                Collections.sort(solutions, new SolutionSorter(orderingConditions));
                solutionsAreSorted = true;
            }
        }

        solutions = resultForm.refineSolutionsAfterOrdering(solutions, solutionsAreSorted ? controller.getOrderingConditions() : null);

        // finally we apply LIMIT and OFFSET, in that order.
        // TODO -- is there a way to determine if the backend has already done
        // this for the whole graph pattern tree?
        int limit = controller.getLimit(), offset = controller.getOffset();
        int solutionCount = solutions.size();

        // TODO -- what if offset > solution.size() - 1
        int startIndex = offset > 0 ? offset : 0;
        int endIndex = -1;
        if (startIndex + limit > solutionCount || limit == -1) {
            endIndex = solutionCount;
        } else {
            endIndex = startIndex + limit;
        }
        long start = System.currentTimeMillis();
        solutions = solutions.slice(startIndex, endIndex);
        if (RequestAnalysis.getAnalysisLogger().isDebugEnabled() && solutions.size() != solutionCount)
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_Engine_slicedSolutionSet] {}:{}:{}:{}", new Object[] { limit, offset, solutions.size(), System.currentTimeMillis() - start });
        // 7)
        // apply result form to get a returnable value
        return new QueryResults(controller.getQueryResultForm().serializeResults(solutions), controller, solutionCount);
    }

    private QueryExecutor getQueryExecutor(QueryController controller, SolutionGenerator sg) {
        QueryExecutor qe = this.configuration.getQueryExecutor(sg);
        qe.initialize(this.configuration, controller, sg, sg.getQueryExecutionPlan());
        return qe;
    }

    private SPARQLParser getParser(String query) {
        return getParser(new StringReader(query));
    }

    private SPARQLParser getParser(Reader query) {
        return new SPARQLParser(query);
    }

    public boolean cancelQuery(String operationId) {
        QueryController qc = controllers.get(operationId);
        if (qc != null) {
            qc.setCancelled(true);
            return true;
        } else {
            return false;
        }

    }
}
