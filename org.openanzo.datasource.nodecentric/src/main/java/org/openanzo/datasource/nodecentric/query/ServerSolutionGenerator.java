/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/glitter/BocaServerSolutionGenerator.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/27/06
 * Revision: $Id: ServerSolutionGenerator.java 229 2007-08-07 15:22:00Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.cache.ICache;
import org.openanzo.datasource.nodecentric.internal.NodeCentricOperationContext;
import org.openanzo.datasource.nodecentric.operations.Contains;
import org.openanzo.datasource.nodecentric.query.predicates.TextLikePredicate;
import org.openanzo.datasource.nodecentric.sql.GlitterRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.NamedGraphRdbWrapper;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.exception.UnknownGraphException;
import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionList;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.query.SolutionUtils;
import org.openanzo.glitter.query.TextMatchPredicate;
import org.openanzo.glitter.query.TextMatchPredicate.TextMatchQuery;
import org.openanzo.glitter.query.planning.TripleNode;
import org.openanzo.glitter.query.rewriter.FunctionalPredicateRewriter;
import org.openanzo.glitter.syntax.abstrakt.BGP;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.Graph;
import org.openanzo.glitter.syntax.abstrakt.Subquery;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.glitter.syntax.abstrakt.Union;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.container.query.AnzoBGPQuery;
import org.openanzo.jdbc.container.query.AnzoSolutionGeneratorBase;
import org.openanzo.jdbc.container.query.GraphSetType;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.query.IRdbValue;
import org.openanzo.jdbc.query.NoSolutionsException;
import org.openanzo.jdbc.query.NodeConverter;
import org.openanzo.jdbc.query.SQLQueryConstants;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.utils.UriGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ServerSolutionGenerator implements the core of the Anzo backend for glitter queries; it translates SPARQL queries into SQL queries against the Anzo temporal
 * RDF store schema.
 */
public class ServerSolutionGenerator extends AnzoSolutionGeneratorBase implements SolutionGenerator {
    private static final Logger               log                         = LoggerFactory.getLogger(ServerSolutionGenerator.class);

    // myLock is true if we're the ones that started a transaction (and therefore must cleanup and commit
    // at the end)
    private boolean                           myLock                      = false;

    private final boolean                     prepopulateSolutionNodes;

    // an array of TreeNode's that the solution generator does not handle (if they're inside the current
    // node)

    @SuppressWarnings("unchecked")
    // suppress conversion from covariant arrays to non-covariant generic types since it is a well known know Java generics limitation
    final private Class<? extends TreeNode>[] notHandled                  = new Class[] { Graph.class, Union.class };

    //NodeCentric Operation Context
    private NodeCentricOperationContext       context;

    private String                            defaultGraphStatementsTable = null;

    private String                            namedGraphsStatementsTable  = null;

    private int                               revisionedDefaultGraph      = 0;

    private int                               revisionedNamedGraphs       = 0;

    private String                            roleSql                     = null;

    private GraphSetType                      defaultGraphsType           = null;

    private GraphSetType                      namedGraphsType             = null;

    private ICache<GraphSet, GraphSet>        graphSets;

    private static final String               TEMP_COLUMNS                = "TEMP_COLUMNS";

    /**
     * Create a new ServerSolutionGenerator
     * 
     * @param context
     *            NodeCentric specific context, which contains connection to run queries against
     * @param transactionTi
     *            this.graphSets = context.getDatasource().getGraphSets();me timestamp of last transaction to include in queries
     */
    protected ServerSolutionGenerator(boolean prepopulateSolutionNodes) {
        this.noDefaultGraphs = false;
        this.noNamedGraphs = false;
        this.prepopulateSolutionNodes = prepopulateSolutionNodes;
    }

    /**
     * @param context
     *            the context to set
     */
    public void setContext(NodeCentricOperationContext context) {
        this.context = context;
        this.graphSets = context.getDatasource().getGraphSets();
    }

    public String getQueryId() {
        return (context != null) ? context.getOperationId() : null;
    }

    @Override
    protected CoreDBConfiguration getConfiguration() {
        return this.context.getConfiguration();
    }

    @Override
    protected Logger getLogger() {
        if (RequestAnalysis.isAnalysisEnabled()) {
            return RequestAnalysis.getAnalysisLogger();
        } else {
            return log;
        }
    }

    @Override
    protected String getSessionPrefix() {
        return this.context.getConfiguration().getSessionPrefix();
    }

    @Override
    protected CompositeNodeLayout getNodeLayout() {
        return this.context.getNodeLayout();
    }

    @Override
    protected String getDefaultGraphsTempTable() {
        return ServerSQL.defaultGraphsTempTable;
    }

    @Override
    protected String getNamedGraphsTempTable() {
        return ServerSQL.namedGraphsTempTable;
    }

    @Override
    protected String getTemporaryTempTable() {
        return ServerSQL.tempGraphsTempTable;
    }

    /**
     * @return the context
     */
    public NodeCentricOperationContext getContext() {
        return this.context;
    }

    /**
     * The ServerSolutionGenerator is initialized by ensuring that we're in a transaction and populating the temp tables with the valid URIs for the query
     * dataset's default graph and named graphs
     */
    @Override
    public void initialize() throws GlitterException {
        this.nodeConverter = new NodeConverter(this.context.getNodeLayout());
        // start a transaction (if necessary), create a temp table with OK named graph IDs
        Glitter.getLog().debug("Creating temporary graph tables and indexes");
        this.myLock = !this.context.getDatasource().isInTransaction(this.context.getConnection());
        if (this.myLock) {
            try {
                this.context.getDatasource().begin(this.context.getConnection(), false, false);
            } catch (AnzoException ae) {
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "Error initializing serversolutiongenerator", ae);
                }
                throw new GlitterException(ae.getErrorCode(), ae);
            }
        }
        // long start = System.currentTimeMillis();
        // System.err.println("Start:" + start);
        super.initialize();
        // System.err.println("Init:" + (System.currentTimeMillis() - start));
    }

    protected boolean datasetResolved() {
        Boolean resolved = (Boolean) this.context.getAttribute("datasetResolved");
        return resolved != null && resolved;
    }

    private boolean bypassAcls() {
        Boolean bypass = (Boolean) this.context.getAttribute("bypassAcls");
        return (bypass != null && bypass) || this.context.getOperationPrincipal().isSysadmin();
    }

    /**
     * Empty the temp tables if we own them or configuration insists that we do; if we own the lock, commit the transaction.
     */
    public void cleanup() throws GlitterException {
        if (!this.myLock) {
            try {
                BaseSQL.truncateTableWithSessionMayCommit(this.context.getStatementProvider(), this.context.getConnection(), this.context.getConfiguration().getSessionPrefix(), SQLQueryConstants.defaultGraphsTempTable);
                BaseSQL.truncateTableWithSessionMayCommit(this.context.getStatementProvider(), this.context.getConnection(), this.context.getConfiguration().getSessionPrefix(), SQLQueryConstants.namedGraphsTempTable);
                BaseSQL.truncateTableWithSessionMayCommit(this.context.getStatementProvider(), this.context.getConnection(), this.context.getConfiguration().getSessionPrefix(), SQLQueryConstants.tempGraphsTempTable);

            } catch (RdbException sqle) {
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "Error clearing temporary tables", sqle);
                }
            }
        }
        if (this.myLock) {
            try {
                this.context.getDatasource().commit(this.context.getConnection(), false, false);
            } catch (AnzoException ae) {
                throw new GlitterException(ae.getErrorCode(), ae);
            }
        }
    }

    /**
     * 
     * @param tempTable
     * @param uri
     * @return <tt>null</t> if the given <tt>uri</tt> is <tt>null</tt> or if the graph is not found or not in the dataset; <tt>0</tt> if the graph is a regular
     *         named graph in the dataset; <tt>1</tt> if the graph is a metadata graph in the dataset
     * @throws SQLException
     * @throws AnzoException
     */
    private int getGraphTypeFromDatasetPart(String tempTable, URI uri) throws SQLException, AnzoException {
        if (uri == null)
            return -1;
        Long id = this.context.getNodeLayout().fetchId(uri, this.context.getConnection());
        if (id == null) {
            return -1;
        }

        Integer result = GlitterRdbWrapper.containsRevisionedGraph(this.context.getStatementProvider(), this.context.getConnection(), id, this.context.getConfiguration().getSessionPrefix(), tempTable);
        if (result == null || result.intValue() == 0) {
            result = GlitterRdbWrapper.containsNonRevisionedGraph(this.context.getStatementProvider(), this.context.getConnection(), id, this.context.getConfiguration().getSessionPrefix(), tempTable);
            if (result != null && result.intValue() > 0)
                return 1;
        } else {
            return 0;
        }
        return -1;
    }

    public SolutionSet generateSolutions(TreeNode node, URI namedGraph, Variable namedGraphVariable, SolutionSet requiredBindings, QueryController controller) {
        if (node instanceof BGP) {
            BGP bgp = (BGP) node;
            if (bgp.getFunctionalPredicate() instanceof TextMatchPredicate) {
                String matchText = ((TextMatchPredicate) bgp.getFunctionalPredicate()).getTextMatch();
                if (matchText.trim().length() > 0 && !matchText.equals("*")) {
                    return solveTextMatchBGP(namedGraph, namedGraphVariable, requiredBindings, bgp);
                }
            }
        }

        // we don't do anything which is a UNION
        // or anything that is an ancestor of a node type that we don't handle (UNION, GRAPH)
        if (node instanceof Subquery || node instanceof Graph || node instanceof Union || containsNodeType(node, this.notHandled)) {
            return null;
        }
        // if this is a graph node, update our graph context and replace the node with the
        /* GRAPH's graph pattern (we recurse this for the strange nested GRAPH cases)
        while (node instanceof Graph) {
            // If this is a graph, we process the graph variable or URI and
            // continue with the child GraphPattern as our operative node.
            TriplePatternComponent context = ((Graph) node).getGraphContext();
            if (context instanceof Variable) {
                namedGraphVariable = (Variable) context;
            } else if (context instanceof URI) {
                namedGraph = (URI) context;
            } else {
                throw new GlitterRuntimeException(ExceptionConstants.GLITTER.GRAPH_NOT_VAR, context.toString());
            }
            node = ((Graph) node).getGraphPattern();
        }*/
        // At this point, we know that node is not a GRAPH node and not a UNION node and contains
        // neither.
        // pull out some properties for the particular part of the dataset we're querying
        boolean queryingDefaultGraph = namedGraphVariable == null && namedGraph == null;
        String datasetTable = queryingDefaultGraph ? ServerSQL.defaultGraphsTempTable : ServerSQL.namedGraphsTempTable;

        // If this is not a single triple pattern instance, we can only handle it if we can use temp tables
        // and we are not dealing with any metadata graphs
        if (!(node instanceof TriplePatternNode) && !this.context.getConfiguration().getSupportsTempOnFind()) {
            return null;
        }
        try {
            // If namedGraph != null, we need to know if it's in the appropriate part of the dataset and
            // whether it is a regular named graph or a metadata graph
            int namedGraphType = getGraphTypeFromDatasetPart(datasetTable, namedGraph);
            boolean allMatch = namedGraph != null ? UriGenerator.isMetadataGraphUri(namedGraph) ? (queryingDefaultGraph ? includeAllMetadataGraphsInDefaultDataset : includeAllMetadataGraphsInNamedDataset) : (queryingDefaultGraph ? includeAllNamedGraphsInDefaultDataset : includeAllNamedGraphsInNamedDataset) : false;
            // Short-circuit if:
            // (1) we're querying the default graph which is empty (zero or unit solution)
            // (2) we're querying the named graphs which are empty (zero or unit solution)
            // (3) we're querying a specific named graph which is not in our dataset  (zero or unit solution)
            if ((queryingDefaultGraph && this.noDefaultGraphs) || (!queryingDefaultGraph && this.noNamedGraphs) || (namedGraph != null && !allMatch && namedGraphType == -1)) {
                if (isNonVacuous(node))
                    throw new NoSolutionsException();
                else
                    return unitSolution();
            }

            log.trace("generateSolutions - no metadata graphs or one specific named graph that is not a metadata graph");
            AnzoBGPQuery query = getAnzoBGPQuery(node, namedGraph, namedGraphVariable, requiredBindings);
            if (query instanceof ServerBGPQuery) {
                ServerBGPQuery serverQuery = (ServerBGPQuery) query;
                serverQuery.setDefaultGraphStatementsTable(this.defaultGraphStatementsTable);
                serverQuery.setNamedGraphsStatementsTable(this.namedGraphsStatementsTable);
                serverQuery.setBypassAcls(bypassAcls());
                serverQuery.setDatasetResolved(datasetResolved());
                serverQuery.setDefaultGraphsType(this.defaultGraphsType);
                serverQuery.setNamedGraphsType(this.namedGraphsType);
            }
            SolutionSet solutions = getBindingsForQuery(query, node, null, controller);
            if (solutions == null)
                return null;
            if (this.prepopulateSolutionNodes) {
                for (PatternSolution solution : solutions) {
                    for (int i = 0; i < solution.size(); i++) {
                        populateRdbNode(solution.getBinding(i), this.context.getConnection());
                        populateRdbNode(solution.getValue(i), this.context.getConnection());
                    }
                }
            }
            return solutions;

        } catch (NoSolutionsException e) {
            return new SolutionList();
        } catch (SQLException e) {
            log.error(LogUtils.RDB_MARKER, "Error generating solutions", e);
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.SQL_EXCEPTION, e);
        } catch (GlitterException e) {
            if (e.getCause() != null)
                throw new GlitterRuntimeException(ExceptionConstants.GLITTER.CANNOT_GENERATE_SOLUTIONS, e.getCause());
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.CANNOT_GENERATE_SOLUTIONS, e);
        } catch (AnzoException e) {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "Error generating solutions", e);
            }
            throw new GlitterRuntimeException(e);
        }
    }

    private void populateRdbNode(Object node, Connection connection) throws RdbException {
        if (node instanceof IRdbValue) {
            IRdbValue value = (IRdbValue) node;
            value.populate(connection);
        }
    }

    /**
     * Solves a BGP containing only a functional predicate and it's required triple pattern(s). This is the case for functional predicate BGP's created by the
     * {@link FunctionalPredicateRewriter}.
     */
    private SolutionSet solveTextMatchBGP(URI namedGraph, Variable namedGraphVariable, SolutionSet requiredBindings, BGP bgp) {
        TextMatchPredicate match = (TextMatchPredicate) bgp.getFunctionalPredicate();
        try {
            // run the lucene query and build up the results, or return no solutions if the query has no matches.

            //long start = System.currentTimeMillis();

            TextMatchQuery luceneQuery = match.getLuceneQuery(namedGraph, namedGraphVariable);
            if (luceneQuery == null) {
                log.debug(LogUtils.RDB_MARKER, "solveTextMatchBGP returning no solutions because luceneQuery is null.");
                return SolutionUtils.noSolutions();
            }

            log.debug(LogUtils.RDB_MARKER, "solveTextMatchBGP about to call executeIndexQueryInternal");
            Collection<Statement> results = getContext().getDatasource().getIndexService().executeIndexQueryInternal(getContext(), luceneQuery, 0, -1);

            if (!luceneQuery.graphs.isEmpty()) {
                Collection<Statement> filteredResults = new HashSet<Statement>();
                log.debug(LogUtils.RDB_MARKER, "solveTextMatchBGP filtering results based on luceneQuery.graphs.");
                for (Statement stmt : results) {
                    if (luceneQuery.graphs.contains(stmt.getNamedGraphUri())) {
                        filteredResults.add(stmt);
                    }
                }
                log.debug(LogUtils.RDB_MARKER, "solveTextMatchBGP results size before filtering '{}'; after filtering '{}'", results.size(), filteredResults.size());
                results = filteredResults;
            } else {
                log.debug(LogUtils.RDB_MARKER, "solveTextMatchBGP lucene query graphs is empty - results not being filtered.");
            }

            if (results.size() == 0) {
                log.debug(LogUtils.RDB_MARKER, "solveTextMatchBGP returning no solutions because result size is zero.");
                return SolutionUtils.noSolutions();
            }

            log.debug(LogUtils.RDB_MARKER, "solveTextMatchBGP returning results - size: {}", results.size());
            return match.createSolutionSet(results, namedGraphVariable);
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

    @Override
    protected boolean handleBGP(AnzoBGPQuery query, TreeNode node) throws NoSolutionsException {
        BGP bgp = (BGP) node;
        TriplePattern ftp = null;
        if (bgp.getFunctionalPredicate() != null) {
            FunctionalPredicate fp = bgp.getFunctionalPredicate();
            if (fp instanceof TextLikePredicate) {
                query.addLikeMatch(((TextLikePredicate) fp).getVariable(), ((TextLikePredicate) fp).getTextQuery());
                ftp = fp.getFunctionalTriplePattern();
            } else if (fp instanceof TextMatchPredicate) {
                String matchText = ((TextMatchPredicate) fp).getTextMatch();
                if ((matchText.trim().length() == 0 || matchText.equals("*"))) {
                    query.addIsLiteral(((TextMatchPredicate) fp).getVar(), false);
                } else {
                    return false;
                }
                ftp = fp.getFunctionalTriplePattern();
            } else {
                return false;
            }
        }
        List<TriplePatternNode> nodes = new ArrayList<TriplePatternNode>();
        for (TriplePatternNode tpn : bgp.getTriplePatterns()) {
            if (ftp == null || !ftp.equals(tpn.getTriplePattern()))
                nodes.add(tpn);
        }
        for (TripleNode noder : this.cqo.getOrderedSet(nodes.iterator())) {
            if (noder.getUnMatchedVariableCount() > 0 && noder.getMatchedVariableCount() == 1) {
                TriplePattern tp = noder.getTriple().getTriplePattern();
                query.addExtraTriplePattern(tp.getSubject(), tp.getPredicate(), tp.getObject());
            } else {
                query.addTriplePattern(noder.getTriple().getTriplePattern());
            }
        }
        return true;
    }

    @Override
    protected AnzoBGPQuery createAnzoBGPQuery(TreeNode node) {
        return new ServerBGPQuery(this.context, Glitter.getMostSpecificController(node, information), this.revisionedDefaultGraph, this.revisionedNamedGraphs, this.validGraphsInDefaultGraph);
    }

    @Override
    protected Connection getConnection() {
        return this.context.getConnection();
    }

    @Override
    protected void clearTempTable() throws RdbException, SQLException {
        BaseSQL.truncateTableWithSessionMayCommit(this.context.getStatementProvider(), this.context.getConnection(), this.context.getConfiguration().getSessionPrefix(), TEMP_COLUMNS);
        for (int i = 0; i < 4; i++) {
            BaseSQL.truncateTableWithSessionMayCommit(this.context.getStatementProvider(), this.context.getConnection(), this.context.getConfiguration().getSessionPrefix(), "TEMP_CONSTRAINT" + i);
        }
    }

    @Override
    protected PreparedStatementProvider getPreparedStatementProvider() {
        return this.context.getStatementProvider();
    }

    public boolean sortedSolutions() {
        return false;
    }

    public boolean canHandleSimultaneousRequests() {
        return false;
    }

    public boolean canBindGraphVariables() {
        return true;
    }

    public boolean usesRequiredBindings() {
        return false;
    }

    // even though we do apply filters, we don't do it correctly for
    // optional nodes TODO so we answer false here
    public boolean willHandleFilters(Set<Expression> filters) {
        return false;
    }

    @Override
    protected void setGraphsType(boolean defaults, GraphSetType type) {
        if (defaults) {
            this.defaultGraphsType = type;
        } else {
            this.namedGraphsType = type;
        }
    }

    @Override
    protected int insertGraphByIdIfValid(Long graphId, String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        if (bypassAcls()) {
            return GlitterRdbWrapper.insertGraphSysAdmin(this.context.getStatementProvider(), this.context.getConnection(), graphId, getSessionPrefix(), insertTable);
        } else {
            Long canBeReadPropId = this.context.getNodeLayout().fetchId(NamedGraph.canBeReadByProperty, this.context.getConnection());
            return GlitterRdbWrapper.insertGraphIfValid(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable, "ALL_STMTS_VIEW", this.roleSql, Long.toString(graphId), Long.toString(canBeReadPropId));
        }
    }

    private GraphSet            defaultGraphSet;

    private GraphSet            namedGraphSet;

    private final static Random random = new Random();

    @Override
    protected boolean insertGraphsIfValid(Set<URI> graphs, String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        long start = 0;
        if (isEnabled) {
            start = System.currentTimeMillis();
        }
        try {
            if (bypassAcls() || datasetResolved()) {
                if (graphs.size() < 100 || graphs.size() > 25000) {
                    Map<URI, Long> graphIds = resolveSet(getNodeLayout(), getConnection(), graphs, true);
                    Contains.insertIdsToTempTable(this.context, insertTable, graphIds.values());
                } else {
                    long startGs = 0;
                    if (isEnabled) {
                        startGs = System.currentTimeMillis();
                    }
                    GraphSet graphSet = new GraphSet(graphs);
                    GraphSet oldSet = graphSets.get(graphSet);
                    if (oldSet != null) {
                        GlitterRdbWrapper.insertGraphsFromQueryDataset(this.context.getStatementProvider(), this.context.getConnection(), oldSet.getSetId(), getSessionPrefix(), insertTable);
                        if (defaults) {
                            defaultGraphSet = oldSet;
                        } else {
                            namedGraphSet = oldSet;
                        }
                        if (isEnabled) {
                            RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_foundCachedGraphSet] {}", Long.toString(System.currentTimeMillis() - startGs));
                        }
                        return true;
                    }
                    if (isEnabled) {
                        RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_noCachedGraphSet] {}", Long.toString(System.currentTimeMillis() - startGs));
                        startGs = System.currentTimeMillis();
                    }
                    PreparedStatement ps = null;
                    try {
                        Map<URI, Long> graphIds = resolveSet(getNodeLayout(), getConnection(), graphs, true);
                        if (isEnabled) {
                            RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_resolveNodes] {}", Long.toString(System.currentTimeMillis() - startGs));
                            startGs = System.currentTimeMillis();
                        }
                        ps = context.getStatementProvider().getPreparedSQLStatement(GlitterRdbWrapper.insertQueryDataset, null, context.getConnection());
                        ps.clearBatch();
                        long dsId = random.nextLong();
                        graphSet.setSetId(dsId);
                        for (Long id : graphIds.values()) {
                            ps.setLong(1, id);
                            ps.setLong(2, dsId);
                            //  ps.setString(3, context.getDatasource().getInstanceId());
                            ps.addBatch();
                        }
                        ps.executeBatch();
                        if (defaults) {
                            defaultGraphSet = graphSet;
                        } else {
                            namedGraphSet = graphSet;
                        }
                        graphSets.put(graphSet, graphSet);
                        GlitterRdbWrapper.insertGraphsFromQueryDataset(this.context.getStatementProvider(), this.context.getConnection(), graphSet.getSetId(), getSessionPrefix(), insertTable);
                    } catch (SQLException e) {
                        throw new AnzoException(ExceptionConstants.RDB.FAILED_EXECUTING_SQL, e);
                    } finally {
                        try {
                            if (ps != null)
                                ps.close();
                        } catch (SQLException sqle) {
                            if (log.isDebugEnabled()) {
                                log.error(LogUtils.RDB_MARKER, "Error closing prepared statement", sqle);
                            }
                        }
                        if (isEnabled) {
                            RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_cachedGraphSet] {}", Long.toString(System.currentTimeMillis() - startGs));
                        }
                    }
                }
                return true;
            } else {
                Map<URI, Long> graphIds = resolveSet(getNodeLayout(), getConnection(), graphs, false);
                Long canBeReadPropId = this.context.getNodeLayout().fetchId(NamedGraph.canBeReadByProperty, this.context.getConnection());
                for (Map.Entry<URI, Long> graphId : graphIds.entrySet()) {
                    int count = GlitterRdbWrapper.insertGraphIfValid(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable, "ALL_STMTS_VIEW", this.roleSql, Long.toString(graphId.getValue()), Long.toString(canBeReadPropId));
                    if (count == 0)
                        throw new UnknownGraphException(graphId.getKey());
                }
                return true;
            }
        } finally {
            if (isEnabled) {
                RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_insertGraphsIsValid] {}:{}", Integer.toString(graphs.size()), Long.toString(System.currentTimeMillis() - start));
            }
        }
    }

    @Override
    protected int insertAllGraphsIfValid(String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        if (bypassAcls()) {
            if ((defaults && this.defaultGraphsType == GraphSetType.ALL_GRAPHS) || (!defaults && this.namedGraphsType == GraphSetType.ALL_GRAPHS)) {
                return 1;
            } else {
                int total = GlitterRdbWrapper.insertAllNamedGraphs(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable);
                total += GlitterRdbWrapper.insertAllMetadataGraphs(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable);
                return total;
            }
        } else {
            Long canBeReadPropId = this.context.getNodeLayout().fetchId(NamedGraph.canBeReadByProperty, this.context.getConnection());
            Long ngDatasetId = this.context.getNodeLayout().fetchId(GRAPHS.GRAPHS_DATASET, this.context.getConnection());
            Long ngDatasetMetadataId = this.context.getNodeLayout().fetchId(GRAPHS.GRAPHS_DATASET_META, this.context.getConnection());
            Long mgDatasetId = this.context.getNodeLayout().fetchId(GRAPHS.METADATA_GRAPHS_DATASET, this.context.getConnection());
            Long mgDatasetMetadataId = this.context.getNodeLayout().fetchId(GRAPHS.METADATA_GRAPHS_DATASET_META, this.context.getConnection());
            return GlitterRdbWrapper.insertAllValidGraphs(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable, "ALL_STMTS_VIEW", this.roleSql, Long.toString(canBeReadPropId), Long.toString(ngDatasetId), Long.toString(ngDatasetMetadataId), Long.toString(mgDatasetId), Long.toString(mgDatasetMetadataId));
        }
    }

    @Override
    protected int insertAllNamedGraphsIfValid(String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        if (bypassAcls()) {
            if ((defaults && this.defaultGraphsType == GraphSetType.ALL_NAMED_GRAPHS) || (!defaults && this.namedGraphsType == GraphSetType.ALL_NAMED_GRAPHS)) {
                return 10000;
            } else {
                int total = GlitterRdbWrapper.insertAllNamedGraphs(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable);
                return total;
            }
        } else {
            Long canBeReadPropId = this.context.getNodeLayout().fetchId(NamedGraph.canBeReadByProperty, this.context.getConnection());
            Long ngDatasetId = this.context.getNodeLayout().fetchId(GRAPHS.GRAPHS_DATASET, this.context.getConnection());
            Long mgDatasetId = this.context.getNodeLayout().fetchId(GRAPHS.METADATA_GRAPHS_DATASET, this.context.getConnection());
            return GlitterRdbWrapper.insertAllValidNamedGraphs(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable, "ALL_STMTS_VIEW", this.roleSql, Long.toString(canBeReadPropId), Long.toString(ngDatasetId), Long.toString(mgDatasetId));
        }
    }

    @Override
    protected int insertAllMetadataGraphsIfValid(String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        if (bypassAcls()) {
            if ((defaults && this.defaultGraphsType == GraphSetType.ALL_METADATA_GRAPHS) || (!defaults && this.namedGraphsType == GraphSetType.ALL_METADATA_GRAPHS)) {
                return 1;
            } else {
                int total = GlitterRdbWrapper.insertAllMetadataGraphs(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable);
                return total;
            }
        } else {
            Long canBeReadPropId = this.context.getNodeLayout().fetchId(NamedGraph.canBeReadByProperty, this.context.getConnection());
            Long ngDatasetMetadataId = this.context.getNodeLayout().fetchId(GRAPHS.GRAPHS_DATASET_META, this.context.getConnection());
            Long mgDatasetMetadataId = this.context.getNodeLayout().fetchId(GRAPHS.METADATA_GRAPHS_DATASET_META, this.context.getConnection());
            return GlitterRdbWrapper.insertAllValidMetadataGraphs(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable, "ALL_STMTS_VIEW", this.roleSql, Long.toString(canBeReadPropId), Long.toString(ngDatasetMetadataId), Long.toString(mgDatasetMetadataId));
        }
    }

    @Override
    protected int insertDatasetGraphsIfValid(Long datasetId, Long datasetGraphPropertyId, String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        if (bypassAcls()) {
            return GlitterRdbWrapper.insertValidDatasetGraphsSysadmin(this.context.getStatementProvider(), this.context.getConnection(), datasetId, datasetId, datasetGraphPropertyId, getSessionPrefix(), insertTable, "ALL_STMTS_VIEW");
        } else {
            Long canBeReadPropId = this.context.getNodeLayout().fetchId(NamedGraph.canBeReadByProperty, this.context.getConnection());
            return GlitterRdbWrapper.insertValidDatasetGraphs(this.context.getStatementProvider(), this.context.getConnection(), getSessionPrefix(), insertTable, "ALL_STMTS_VIEW", this.roleSql, Long.toString(datasetId), Long.toString(datasetId), Long.toString(datasetGraphPropertyId), Long.toString(canBeReadPropId));
        }
    }

    @Override
    protected long[] populateDatasetTables(CompositeNodeLayout layout, Connection connection, String defaultGraphsTempTable, String namedGraphsTempTable, Logger log) throws GlitterException {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        long start = 0;
        if (log.isDebugEnabled() || isEnabled) {
            start = System.currentTimeMillis();
        }
        long[] ret = null;
        try {
            // cache role sql and transaction time sql
            if (!bypassAcls()) {
                Set<org.openanzo.rdf.URI> roles = (this.context.getOperationPrincipal() != null) ? this.context.getOperationPrincipal().getRoles() : Collections.singleton(Constants.DEFAULT_INTERNAL_USER);
                if (roles.size() >= 100) { // probably not set anywhere
                    this.roleSql = "SELECT ID IN OBJECT_IDS_TEMP";
                } else {
                    StringBuilder sb = new StringBuilder();
                    ArrayList<Long> validIds = new ArrayList<Long>();
                    for (Iterator<org.openanzo.rdf.URI> rolesIter = roles.iterator(); rolesIter.hasNext();) {
                        org.openanzo.rdf.URI roleURI = rolesIter.next();
                        Long id = this.context.getNodeLayout().fetchId(roleURI, this.context.getConnection());
                        if (id != null) {
                            validIds.add(id);
                        }
                    }
                    for (Iterator<Long> idsIterator = validIds.iterator(); idsIterator.hasNext();) {
                        sb.append(idsIterator.next());
                        if (idsIterator.hasNext()) {
                            sb.append(',');
                        }
                    }
                    this.roleSql = sb.toString();
                }
            }
            ret = super.populateDatasetTables(layout, connection, defaultGraphsTempTable, namedGraphsTempTable, log);
            if (isEnabled) {
                RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_superPopulateDatabaseTables] {}", Long.toString(System.currentTimeMillis() - start));
            }
            this.defaultGraphStatementsTable = getStatementTable(getDefaultGraphsTempTable(), true, ret[0]);
            this.revisionedDefaultGraph = (this.defaultGraphStatementsTable.equals(ServerSQL.nonRevisionedStatementTable)) ? -1 : this.defaultGraphStatementsTable.equals(ServerSQL.revisionedStatementTable) ? 1 : 0;
            this.namedGraphsStatementsTable = getStatementTable(getNamedGraphsTempTable(), false, ret[1]);
            this.revisionedNamedGraphs = (this.namedGraphsStatementsTable.equals(ServerSQL.nonRevisionedStatementTable)) ? -1 : this.namedGraphsStatementsTable.equals(ServerSQL.revisionedStatementTable) ? 1 : 0;

            // System.err.println("[POPULATE DATASET TABLES] " + ret[0] + ":" + ret[1] + ":" + (System.currentTimeMillis() - start));
            if (log.isDebugEnabled()) {
                log.debug("[POPULATE DATASET TABLES] " + ret[0] + ":" + ret[1] + ":" + (System.currentTimeMillis() - start));
            }
            return ret;
        } catch (SQLException e) {
            log.error(LogUtils.RDB_MARKER, "Error populating dataset tables", e);
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.ERROR_POPULATING_TABLES, e);
        } catch (AnzoException e) {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "Error populating dataset tables", e);
            }
            throw new GlitterRuntimeException(e);
        } finally {
            if (isEnabled) {
                RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_populateDatabaseTables] {}:{}:{}", new Object[] { Long.toString(System.currentTimeMillis() - start), (ret != null) ? ret[0] : 0, (ret != null) ? ret[1] : 0 });
            }
        }
    }

    private String getStatementTable(String datasetTable, boolean defaults, long totalGraphs) throws RdbException, SQLException {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        long start = 0;
        if (log.isDebugEnabled() || isEnabled) {
            start = System.currentTimeMillis();
        }
        if (bypassAcls() && this.namedGraphsType != GraphSetType.LISTED) {
            Long countRev = NamedGraphRdbWrapper.countAllRevisionedNamedGraphs(this.context.getStatementProvider(), this.context.getConnection());
            if (countRev == 0)
                return ServerSQL.nonRevisionedStatementTable;
            else if (countRev == totalGraphs || NamedGraphRdbWrapper.countAllNonRevisionedNamedGraphs(this.context.getStatementProvider(), this.context.getConnection()) == 0)
                return ServerSQL.revisionedStatementTable;
            else
                return ServerSQL.statementTable;
        } else {
            if (defaults && defaultGraphSet != null) {
                if (defaultGraphSet.getNonRevisionedCount() == -1 && defaultGraphSet.getRevisionedCount() == -1) {
                    defaultGraphSet.setRevisionedCount(GlitterRdbWrapper.countValidRevisionedGraphsInSet(this.context.getStatementProvider(), this.context.getConnection(), defaultGraphSet.getSetId()));
                    if (isEnabled) {
                        RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_getStatementTableCountRevisioned] {}:{}", defaultGraphSet.getRevisionedCount(), Long.toString(System.currentTimeMillis() - start));
                        start = System.currentTimeMillis();
                    }
                    defaultGraphSet.setNonRevisionedCount((defaultGraphSet.getRevisionedCount() == totalGraphs) ? 0 : GlitterRdbWrapper.countValidNonRevisionedGraphsInSet(this.context.getStatementProvider(), this.context.getConnection(), defaultGraphSet.getSetId()));
                    if (isEnabled) {
                        RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_getStatementTableCountNonRevisioned] {}:{}", defaultGraphSet.getNonRevisionedCount(), Long.toString(System.currentTimeMillis() - start));
                    }
                }
                if (defaultGraphSet.getRevisionedCount() == 0) {
                    return ServerSQL.nonRevisionedStatementTable;
                } else if (defaultGraphSet.getNonRevisionedCount() == 0) {
                    return ServerSQL.revisionedStatementTable;
                } else {
                    return ServerSQL.statementTable;
                }
            } else if (!defaults && namedGraphSet != null) {
                if (namedGraphSet.getNonRevisionedCount() == -1 && namedGraphSet.getRevisionedCount() == -1) {
                    namedGraphSet.setRevisionedCount(GlitterRdbWrapper.countValidRevisionedGraphsInSet(this.context.getStatementProvider(), this.context.getConnection(), namedGraphSet.getSetId()));
                    if (isEnabled) {
                        RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_getStatementTableCountRevisioned] {}:{}", namedGraphSet.getRevisionedCount(), Long.toString(System.currentTimeMillis() - start));
                        start = System.currentTimeMillis();
                    }
                    namedGraphSet.setNonRevisionedCount((namedGraphSet.getRevisionedCount() == totalGraphs) ? 0 : GlitterRdbWrapper.countValidNonRevisionedGraphsInSet(this.context.getStatementProvider(), this.context.getConnection(), namedGraphSet.getSetId()));
                    if (isEnabled) {
                        RequestAnalysis.getAnalysisLogger().debug("[glitter_ServerSolutionGenerator_getStatementTableCountNonRevisioned] {}:{}", namedGraphSet.getNonRevisionedCount(), Long.toString(System.currentTimeMillis() - start));
                    }
                }
                if (namedGraphSet.getRevisionedCount() == 0) {
                    return ServerSQL.nonRevisionedStatementTable;
                } else if (namedGraphSet.getNonRevisionedCount() == 0) {
                    return ServerSQL.revisionedStatementTable;
                } else {
                    return ServerSQL.statementTable;
                }
            } else {
                long countNonRev = GlitterRdbWrapper.countValidNonRevisionedGraphs(this.context.getStatementProvider(), this.context.getConnection(), datasetTable, this.context.getConfiguration().getSessionPrefix());
                if (countNonRev == 0) {
                    return ServerSQL.revisionedStatementTable;
                } else {
                    Long countRev = GlitterRdbWrapper.countValidRevisionedGraphs(this.context.getStatementProvider(), this.context.getConnection(), datasetTable, this.context.getConfiguration().getSessionPrefix());
                    if (countRev == 0) {
                        return ServerSQL.nonRevisionedStatementTable;
                    } else {
                        return ServerSQL.statementTable;
                    }
                }
            }
        }
    }
}
