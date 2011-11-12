/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jdbc.container.query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections15.MultiMap;
import org.apache.commons.lang.StringUtils;
import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.exception.UnknownGraphException;
import org.openanzo.glitter.expression.BinaryFunction;
import org.openanzo.glitter.expression.UnaryFunction;
import org.openanzo.glitter.expression.builtin.IsBlank;
import org.openanzo.glitter.expression.builtin.IsIRI;
import org.openanzo.glitter.expression.builtin.IsLiteral;
import org.openanzo.glitter.expression.builtin.LogicalAnd;
import org.openanzo.glitter.expression.builtin.Not;
import org.openanzo.glitter.expression.builtin.PolymorphicEq;
import org.openanzo.glitter.expression.builtin.PolymorphicNe;
import org.openanzo.glitter.expression.builtin.SameTerm;
import org.openanzo.glitter.query.AbstractSolutionGenerator;
import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.PatternSolutionImpl;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.SolutionList;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.query.SolutionUtils;
import org.openanzo.glitter.query.planning.QueryOptimizer;
import org.openanzo.glitter.query.planning.TripleNode;
import org.openanzo.glitter.syntax.abstrakt.BGP;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.FunctionCall;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.abstrakt.Group;
import org.openanzo.glitter.syntax.abstrakt.Optional;
import org.openanzo.glitter.syntax.abstrakt.SimpleExpression;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.container.sql.GlitterSQL;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.query.NoSolutionsException;
import org.openanzo.jdbc.query.NodeConverter;
import org.openanzo.jdbc.query.SQLQueryConstants;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.GRAPHS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link AnzoSolutionGeneratorBase} is a base class for Anzo Glitter implementations that share similar approaches to solving Glitter queries.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public abstract class AnzoSolutionGeneratorBase extends AbstractSolutionGenerator {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AnzoSolutionGeneratorBase.class);

    protected boolean                     includeAllNamedGraphsInDefaultDataset = false, includeAllMetadataGraphsInDefaultDataset = false, includeAllNamedGraphsInNamedDataset = false, includeAllMetadataGraphsInNamedDataset = false;

    // These allow us to short circuit some SQL queries.
    protected boolean                     noDefaultGraphs;

    protected boolean                     noNamedGraphs;

    protected NodeConverter               nodeConverter                         = null;

    // These variables are the counts of valid (with respect to ACLs and time) graphs
    // in the default graph and named graph parts of the query's dataset
    protected long                        validGraphsInDefaultGraph             = -1;

    protected long                        validGraphsInNamedGraphs              = -1;

    abstract protected CoreDBConfiguration getConfiguration();

    abstract protected AnzoBGPQuery createAnzoBGPQuery(TreeNode node);

    abstract protected Connection getConnection();

    abstract protected PreparedStatementProvider getPreparedStatementProvider();

    abstract protected Logger getLogger();

    abstract protected String getSessionPrefix();

    abstract protected void clearTempTable() throws RdbException, SQLException;

    abstract protected CompositeNodeLayout getNodeLayout();

    abstract protected String getDefaultGraphsTempTable();

    abstract protected String getNamedGraphsTempTable();

    abstract protected String getTemporaryTempTable();

    abstract protected int insertGraphByIdIfValid(Long graphId, String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException;

    abstract protected boolean insertGraphsIfValid(Set<URI> graphs, String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException;

    abstract protected int insertAllGraphsIfValid(String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException;

    abstract protected int insertDatasetGraphsIfValid(Long datasetId, Long datasetGraphPropertyId, String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException;

    abstract protected int insertAllNamedGraphsIfValid(String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException;

    abstract protected int insertAllMetadataGraphsIfValid(String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException;

    abstract protected void setGraphsType(boolean defaults, GraphSetType type);

    protected AnzoBGPQuery getAnzoBGPQuery(TreeNode node, org.openanzo.rdf.URI namedGraph, Variable namedGraphVariable, SolutionSet requiredBindings) throws NoSolutionsException {
        AnzoBGPQuery query = createAnzoBGPQuery(node);
        query.setThisNode(node);
        query.setDefaultGraphCount(this.validGraphsInDefaultGraph);
        if (namedGraph != null) {
            query.setNamedGraph(namedGraph);
        } else if (namedGraphVariable != null) {
            query.setGraphVariable(namedGraphVariable);
        }
        query.setRequiredBindings(requiredBindings);
        return query;
    }

    public void initialize() throws GlitterException {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        long start = 0;
        if (isEnabled) {
            start = System.currentTimeMillis();
        }
        try {
            long[] validUris = populateDatasetTables(getNodeLayout(), getConnection(), getDefaultGraphsTempTable(), getNamedGraphsTempTable(), getLogger());
            validGraphsInDefaultGraph = validUris[0];
            validGraphsInNamedGraphs = validUris[1];
        } finally {
            if (isEnabled) {
                RequestAnalysis.getAnalysisLogger().debug("[glitter_AnzoSolutionGeneratorBase_initializeDatasetTables] {}", Long.toString(System.currentTimeMillis() - start));
            }
        }
    }

    protected long[] populateDatasetTables(CompositeNodeLayout layout, Connection connection, String defaultGraphsTempTable, String namedGraphsTempTable, Logger log) throws GlitterException {
        long validNamedGraphsInDefaultGraph = 0;
        long validNamedGraphsInNamedGraphs = 0;
        Set<URI> defaultGraphSet = null, namedGraphSet = null;
        try {
            Set<URI> defaultGraphs = this.dataset.getDefaultGraphURIs(), namedGraphs = this.dataset.getNamedGraphURIs();
            // translate the list of URIs to lists of node IDs. If any of the graphs
            // are unknown to the system we raise an error.
            if (defaultGraphs != null) {
                if (defaultGraphs.contains(GRAPHS.ALL_GRAPHS) || defaultGraphs.contains(GRAPHS.ALL_METADATAGRAPHS) || defaultGraphs.contains(GRAPHS.ALL_NAMEDGRAPHS)) {
                    defaultGraphSet = new HashSet<URI>();
                    for (URI u : defaultGraphs) {
                        if (u.equals(GRAPHS.ALL_GRAPHS)) {
                            includeAllNamedGraphsInDefaultDataset = includeAllMetadataGraphsInDefaultDataset = true;
                        } else if (u.equals(GRAPHS.ALL_METADATAGRAPHS)) {
                            includeAllMetadataGraphsInDefaultDataset = true;
                        } else if (u.equals(GRAPHS.ALL_NAMEDGRAPHS)) {
                            includeAllNamedGraphsInDefaultDataset = true;
                        } else {
                            defaultGraphSet.add(u);
                        }
                    }
                } else {
                    defaultGraphSet = defaultGraphs;
                }
            } else {
                defaultGraphSet = Collections.<URI> emptySet();
            }
            if (namedGraphs != null) {
                if (namedGraphs.contains(GRAPHS.ALL_GRAPHS) || namedGraphs.contains(GRAPHS.ALL_METADATAGRAPHS) || namedGraphs.contains(GRAPHS.ALL_NAMEDGRAPHS)) {
                    namedGraphSet = new HashSet<URI>();
                    for (URI u : namedGraphs) {
                        if (u.equals(GRAPHS.ALL_GRAPHS))
                            includeAllNamedGraphsInNamedDataset = includeAllMetadataGraphsInNamedDataset = true;
                        else if (u.equals(GRAPHS.ALL_METADATAGRAPHS))
                            includeAllMetadataGraphsInNamedDataset = true;
                        else if (u.equals(GRAPHS.ALL_NAMEDGRAPHS))
                            includeAllNamedGraphsInNamedDataset = true;
                        else
                            namedGraphSet.add(u);
                    }
                } else {
                    namedGraphSet = namedGraphs;
                }
            } else {
                namedGraphSet = Collections.<URI> emptySet();
            }
            // get the graph IDs to operate on into two tables (separate for default
            // graphs and named graphs) -- further queries can ignore ACLs,
            // transactionTime of named graphs, and the user-specified dataset.
            validNamedGraphsInDefaultGraph = populateValidGraphs(layout, connection, defaultGraphSet, true, includeAllNamedGraphsInDefaultDataset, includeAllMetadataGraphsInDefaultDataset, defaultGraphsTempTable);
            this.noDefaultGraphs = validNamedGraphsInDefaultGraph == 0;
            validNamedGraphsInNamedGraphs = populateValidGraphs(layout, connection, namedGraphSet, false, includeAllNamedGraphsInNamedDataset, includeAllMetadataGraphsInNamedDataset, namedGraphsTempTable);
            this.noNamedGraphs = validNamedGraphsInNamedGraphs == 0;
        } catch (SQLException e) {
            log.error(LogUtils.RDB_MARKER, "SQL error populating dataset tables", e);
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.SQL_EXCEPTION, e);
        } catch (AnzoException e) {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.DATASOURCE_MARKER, "Anzo Exception populating dataset tables", e);
            }
            throw new GlitterRuntimeException(e);
        }
        return new long[] { validNamedGraphsInDefaultGraph, validNamedGraphsInNamedGraphs };
    }

    protected Map<URI, Long> resolveSet(CompositeNodeLayout layout, Connection connection, Set<URI> uris, boolean bypassAcls) throws AnzoException, UnknownGraphException {
        Map<URI, Long> graphIds = layout.getNodeURILayout().resolveStoredNodes(uris, false, connection, -1);
        if (!bypassAcls && graphIds.size() < uris.size()) {
            uris.removeAll(graphIds.keySet());
            throw new UnknownGraphException(StringUtils.join(uris.iterator(), ", "));
        }
        return graphIds;
    }

    /**
     * <ol>
     * <li>Everything in graphIds needs to be checked for validity (existence, timeliness, authority), and an error thrown if anything fails
     * <li>If includeAllNamedGraphs && includeAllMetadataGraphs, then everything can just be dumped to destinationTable directly, after the validity check of
     * graphIds
     * <li>If only 1 of graphIds, datasetIds, includeAllNamedGraphs, or includeAllMetadataGraphs is given, then the temporary table can also be skipped
     * <li>Otherwise, everything must be populated into a temporary table, and then distinct values selected into destinationTable
     * </ol>
     */
    protected long populateValidGraphs(CompositeNodeLayout layout, Connection connection, Set<URI> graphsSet, boolean defaults, boolean includeAllNamedGraphs, boolean includeAllMetadataGraphs, String destinationTable) throws SQLException, GlitterException, AnzoException {
        long graphs = 0;
        boolean allGraphs = includeAllMetadataGraphs && includeAllNamedGraphs;

        int graphSources = (graphsSet.size() > 0 ? 1 : 0) + (includeAllNamedGraphs ? 1 : 0) + (includeAllMetadataGraphs ? 1 : 0);
        if (graphSources == 0)
            return 0;
        boolean needsTemporaryTable = graphSources > 1;

        String insertTable = needsTemporaryTable ? getTemporaryTempTable() : destinationTable;
        if (graphsSet.size() > 0) {
            insertGraphsIfValid(graphsSet, insertTable, defaults);
            graphs += graphsSet.size();
        }
        if (allGraphs) {
            graphs = insertAllGraphsIfValid(insertTable, defaults);
            setGraphsType(defaults, GraphSetType.ALL_GRAPHS);
        } else {
            if (graphs > 0) {
                setGraphsType(defaults, GraphSetType.LISTED);
            }
            if (includeAllNamedGraphs) {
                if (graphs == 0) {
                    setGraphsType(defaults, GraphSetType.ALL_NAMED_GRAPHS);
                }
                graphs += insertAllNamedGraphsIfValid(insertTable, defaults);
            }
            if (includeAllMetadataGraphs) {
                if (graphs == 0) {
                    setGraphsType(defaults, GraphSetType.ALL_METADATA_GRAPHS);
                }
                graphs += insertAllMetadataGraphsIfValid(insertTable, defaults);
            }
        }
        if (needsTemporaryTable && graphs > 0)
            return GlitterSQL.copyDistinctDatasetIds(getPreparedStatementProvider(), getConnection(), getSessionPrefix(), insertTable, destinationTable);
        return graphs;
    }

    protected boolean containsNodeType(TreeNode parent, Class<?>[] cs) {
        for (TreeNode child : parent.getChildren()) {
            if (child == null)
                continue;
            for (Class<?> element : cs)
                if (element.isInstance(child))
                    return true;
            if (containsNodeType(child, cs))
                return true;
        }
        return false;
    }

    protected QueryOptimizer cqo = new QueryOptimizer();

    boolean handleOptional(AnzoBGPQuery query, TreeNode node) throws NoSolutionsException {
        if (!getConfiguration().getSupportsOptionalJoins()) {
            return false;
        }
        Optional opt = (Optional) node;
        if (opt.getFilters() != null && opt.getFilters().size() > 0)
            return false;
        GraphPattern gp = opt.getMustMatchPattern();
        if (gp instanceof BGP) {
            BGP bgp = (BGP) gp;
            if (!handleBGP(query, bgp))
                return false;
        } else if (gp instanceof TriplePatternNode) {
            query.addTriplePattern(((TriplePatternNode) gp).getTriplePattern());
        } else if (gp instanceof Optional) {
            if (!handleOptional(query, gp))
                return false;
        } else if (gp instanceof Group) {
            if (((Group) gp).getPatterns().size() == 1) {
                GraphPattern graphPattern = (((Group) gp).getPatterns().iterator().next());
                if (!handleGraphPattern(query, graphPattern))
                    return false;
                handleFilters(query, gp);
            } else {
                return false;
            }
        } else {
            return false;
        }
        GraphPattern gpMay = opt.getMayMatchPattern();
        if (gpMay instanceof Group) {
            Group group = (Group) gpMay;
            for (GraphPattern gpMay2 : group.getChildren()) {
                if (gpMay2 instanceof BGP) {
                    BGP bgp = (BGP) gpMay2;
                    List<TriplePattern> patterns = new ArrayList<TriplePattern>();
                    for (TriplePatternNode tp : bgp.getTriplePatterns()) {
                        patterns.add(tp.getTriplePattern());
                    }
                    query.addOptionalPatterns(patterns);
                } else if (gpMay2 instanceof TriplePatternNode) {
                    query.addOptionalPattern(((TriplePatternNode) gpMay2).getTriplePattern());
                } else {
                    return false;
                }
            }
        } else if (gpMay instanceof BGP) {
            BGP bgp = (BGP) gpMay;
            List<TriplePattern> patterns = new ArrayList<TriplePattern>();
            for (TriplePatternNode tp : bgp.getTriplePatterns()) {
                patterns.add(tp.getTriplePattern());
            }
            query.addOptionalPatterns(patterns);
        } else if (gpMay instanceof TriplePatternNode) {
            query.addOptionalPattern(((TriplePatternNode) gpMay).getTriplePattern());
        } else {
            return false;
        }
        handleFilters(query, node);
        return true;
    }

    protected boolean handleBGP(AnzoBGPQuery query, TreeNode node) throws NoSolutionsException {
        BGP bgp = (BGP) node;
        TriplePattern ftp = null;
        if (bgp.getFunctionalPredicate() != null) {
            FunctionalPredicate fp = bgp.getFunctionalPredicate();
            if (fp instanceof TextLikePredicate) {
                query.addLikeMatch(((TextLikePredicate) fp).var, ((TextLikePredicate) fp).textMatch);
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
        for (TripleNode noder : cqo.getOrderedSet(nodes.iterator())) {
            if (noder.getUnMatchedVariableCount() > 0 && noder.getMatchedVariableCount() == 1) {
                TriplePattern tp = noder.getTriple().getTriplePattern();
                query.addExtraTriplePattern(tp.getSubject(), tp.getPredicate(), tp.getObject());
            } else {
                query.addTriplePattern(noder.getTriple().getTriplePattern());
            }
        }
        handleFilters(query, node);
        return true;
    }

    protected boolean handleGraphPattern(AnzoBGPQuery query, TreeNode node) throws NoSolutionsException {
        if (node instanceof TriplePatternNode) {
            query.addTriplePattern(((TriplePatternNode) node).getTriplePattern());
        } else if (node instanceof BGP) {
            if (!handleBGP(query, node))
                return false;
        } else if (node instanceof Optional) {
            if (!handleOptional(query, node))
                return false;
        } else if (node instanceof Group) {
            Group group = (Group) node;
            List<GraphPattern> children = group.getChildren();
            GraphPattern gp = null;
            if (!children.isEmpty())
                gp = children.get(0);
            if (gp == null || children.size() > 1)
                return false;
            if (gp instanceof BGP) {
                if (!handleBGP(query, gp))
                    return false;
            } else if (gp instanceof Optional) {
                if (!handleOptional(query, gp))
                    return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
        handleFilters(query, node);
        return true;

    }

    protected boolean buildQuery(AnzoBGPQuery query, TreeNode node, TreeNode mustMatchNode) throws NoSolutionsException {
        if (!handleGraphPattern(query, node))
            return false;
        query.catalogTriples();
        return true;
    }

    protected void handleFilters(AnzoBGPQuery query, TreeNode node) {
        Set<Expression> removed = new HashSet<Expression>();
        for (Expression filter : node.getFilters()) {
            handleFilter(filter, query, node, false, removed);
        }
        for (Expression filter : removed) {
            node.getFilters().remove(filter);
        }
        if (removed.size() > 0) {
            node.invalidateCache();
        }
    }

    protected void handleFilter(Expression filter, AnzoBGPQuery query, TreeNode node, boolean not, Set<Expression> removed) {
        if (filter instanceof FunctionCall) {
            FunctionCall fc = ((FunctionCall) filter);
            if (fc.getFunction() instanceof BinaryFunction) {
                if (fc.getArguments().size() == 2) {
                    Expression e1 = fc.getArguments().get(0);
                    Expression e2 = fc.getArguments().get(1);
                    if (e1 instanceof SimpleExpression && e2 instanceof SimpleExpression) {
                        TriplePatternComponent v1 = ((SimpleExpression) e1).getTerm();
                        TriplePatternComponent v2 = ((SimpleExpression) e2).getTerm();
                        if (v1 instanceof Bindable && v2 instanceof Bindable) {
                            if (fc.getFunction() instanceof PolymorphicEq) {
                                removed.add(filter);
                                if (not) {
                                    query.addNotEqualVariables((Bindable) v1, (Bindable) v2);
                                } else {
                                    query.addEqualVariables((Bindable) v1, (Bindable) v2);
                                }
                            } else if (fc.getFunction() instanceof SameTerm) {
                                removed.add(filter);
                                if (not) {
                                    query.addNotEqualVariables((Bindable) v1, (Bindable) v2);
                                } else {
                                    query.addEqualVariables((Bindable) v1, (Bindable) v2);
                                }
                            } else if (fc.getFunction() instanceof PolymorphicNe) {
                                removed.add(filter);
                                if (not) {
                                    query.addEqualVariables((Bindable) v1, (Bindable) v2);
                                } else {
                                    query.addNotEqualVariables((Bindable) v1, (Bindable) v2);
                                }
                            }
                        }
                    }
                }
            } else if (fc.getFunction() instanceof UnaryFunction) {
                if (fc.getArguments().size() == 1) {
                    Expression e1 = fc.getArguments().get(0);
                    if (fc.getFunction() instanceof Not) {
                        if (e1 instanceof FunctionCall) {
                            handleFilter(e1, query, node, true, removed);
                        }
                    } else {
                        if (e1 instanceof SimpleExpression) {
                            TriplePatternComponent v1 = ((SimpleExpression) e1).getTerm();
                            if (v1 instanceof Bindable) {
                                if (fc.getFunction() instanceof IsIRI) {
                                    removed.add(filter);
                                    query.addIsIRI((Bindable) v1, not);
                                } else if (fc.getFunction() instanceof IsLiteral) {
                                    removed.add(filter);
                                    query.addIsLiteral((Bindable) v1, not);
                                } else if (fc.getFunction() instanceof IsBlank) {
                                    removed.add(filter);
                                    query.addIsBlank((Bindable) v1, not);
                                }
                            }
                        }
                    }
                }
            } else if (fc.getFunction() instanceof LogicalAnd) {
                if (canHandleAllFunctions(fc.getArguments())) {
                    for (Expression exp : fc.getArguments()) {
                        handleFilter(exp, query, node, not, removed);
                    }
                }
            }
        }
    }

    private boolean canHandleAllFunctions(List<Expression> filters) {
        for (Expression exp : filters) {
            if (exp instanceof FunctionCall) {
                FunctionCall fc = (FunctionCall) exp;
                if (!((fc.getFunction() instanceof LogicalAnd && canHandleAllFunctions(fc.getArguments())) || fc.getFunction() instanceof PolymorphicEq || fc.getFunction() instanceof PolymorphicNe || fc.getFunction() instanceof SameTerm || fc.getFunction() instanceof IsIRI || fc.getFunction() instanceof IsLiteral || fc.getFunction() instanceof IsBlank)) {
                    return false;
                }
            }
        }
        return true;
    }

    protected SolutionSet getBindingsForQuery(AnzoBGPQuery query, TreeNode node, SolutionSet solutions, QueryController controller) throws SQLException, AnzoException {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        if (solutions == null)
            solutions = new SolutionList();
        // The query optimizer pulls out "extra triples" - triples that are simple property
        // extractions from resources that are identified in other ways
        if (!buildQuery(query, node, null))
            return null;

        if (isEnabled) {
            StringBuilder sb = new StringBuilder();
            node.prettyPrint(sb, true);
            RequestAnalysis.getAnalysisLogger().debug("[glitter_AnzoSolutionGeneratorBase_startSolvingNode] [{}] = [{}]", node.toString(), sb.toString());
        }

        String sql = query.getSQL(query.getExtraTriples().size() > 0 || query.getOptionalTriples().size() > 0 ? getSessionPrefix() + "TEMP_COLUMNS" : null);
        long start = System.currentTimeMillis();
        Statement stmt = getConnection().createStatement();
        try {
            logSql(sql, new String[] {});
            ResultSet rs = null;
            if (query.getExtraTriples().size() > 0 || query.getOptionalTriples().size() > 0) {
                long start2 = 0;
                if (isEnabled) {
                    start2 = System.currentTimeMillis();
                }
                int counter = 0;
                try {
                    counter = (sql != null) ? stmt.executeUpdate(sql) : 1;
                } catch (SQLException sqle) {
                    log.error(LogUtils.RDB_MARKER, "Error executing query:" + sql, sqle);
                    throw sqle;
                }
                if (controller.isCancelled()) {
                    throw new GlitterException(ExceptionConstants.GLITTER.QUERY_CANCELLED);
                }
                if (counter > 0) {
                    if (sql != null && isEnabled) {
                        RequestAnalysis.getAnalysisLogger().debug("[glitter_AnzoSolutionGeneratorBase_" + "sqlInterimQuery] {}:{}:{}", new Object[] { sql, Long.toString(counter), Long.toString(System.currentTimeMillis() - start2) });
                        start2 = System.currentTimeMillis();
                    }
                    String sqlExtra = query.getExtraSQL();
                    if (sql == null && sqlExtra == null) {
                        return SolutionUtils.noSolutions();
                    }
                    try {
                        rs = stmt.executeQuery(sqlExtra);
                    } catch (SQLException sqle) {
                        log.error(LogUtils.RDB_MARKER, "Error executing query:" + sqlExtra, sqle);
                        throw sqle;
                    }
                    if (controller.isCancelled()) {
                        throw new GlitterException(ExceptionConstants.GLITTER.QUERY_CANCELLED);
                    }
                    if (isEnabled) {
                        RequestAnalysis.getAnalysisLogger().debug("[glitter_AnzoSolutionGeneratorBase_" + "sqlExtrasQuery] {}::{}", new Object[] { sqlExtra, Long.toString(System.currentTimeMillis() - start2) });
                        start2 = System.currentTimeMillis();
                    }
                }
            } else {
                long start2 = 0;
                if (isEnabled) {
                    start2 = System.currentTimeMillis();
                }
                if (sql == null) {
                    return SolutionUtils.noSolutions();
                }
                try {
                    rs = stmt.executeQuery(sql);
                } catch (SQLException sqle) {
                    log.error(LogUtils.RDB_MARKER, "Error executing query:" + sql, sqle);
                    throw sqle;
                }
                if (controller.isCancelled()) {
                    throw new GlitterException(ExceptionConstants.GLITTER.QUERY_CANCELLED);
                }
                if (isEnabled) {
                    RequestAnalysis.getAnalysisLogger().debug("[glitter_AnzoSolutionGeneratorBase_" + "sqlQuery] {}::{}", sql, Long.toString(System.currentTimeMillis() - start2));
                    start2 = System.currentTimeMillis();
                }
            }
            int count = 0;
            if (rs != null) {
                count = addBindings(query, node, rs, solutions, SQLQueryConstants.glitterIgnoredVariable, getConnection(), controller);
            }
            if (isEnabled) {
                RequestAnalysis.getAnalysisLogger().debug("[glitter_AnzoSolutionGeneratorBase_" + "sqlTotalResults] {}:{}", Long.toString(count), Long.toString(System.currentTimeMillis() - start));
            }
            return solutions;
        } finally {
            try {
                clearTempTable();
            } catch (SQLException sqle) {
                getLogger().error("SQL exception clearing temporary tables", sqle);
            } catch (RdbException sqle) {
                getLogger().error("SQL exception clearing temporary tables", sqle);
            }
            if (stmt != null)
                stmt.close();
        }
    }

    /**
     * 
     * We need to translate this result set into our own bindings. This means: 1) converting column names to Bindable objects 2) ignoring the fake unit column
     * 3) mapping back from Anzo IDs to BNode Nodes to Glitter objects 4) associating the appropriate openrdf object with the bindable key
     * 
     */
    protected int addBindings(AnzoBGPQuery query, TreeNode node, ResultSet rs, SolutionSet bindings, String glitterIgnoredVariable, Connection connection, QueryController controller) throws SQLException, AnzoException {
        int resultsProcessed = 0;
        try {
            ResultSetMetaData meta = rs.getMetaData();
            // HashMap<Integer, Bindable> columns = new HashMap<Integer, Bindable>();
            int lastColumn = meta.getColumnCount();
            Bindable columns[] = new Bindable[lastColumn + 1];
            for (int i = 1; i <= lastColumn; i++) {
                String name = meta.getColumnLabel(i);
                if (!name.equals(glitterIgnoredVariable)) { // 2)
                    columns[i] = query.getBindableForAlias(name); // 1)
                }
            }
            // TODO we'd like to filter here if possible, but it breaks if we're inside a LeftJoin that has
            // filters...
            while (rs.next()) {
                if (controller.isCancelled()) {
                    throw new GlitterException(ExceptionConstants.GLITTER.QUERY_CANCELLED);
                }
                resultsProcessed++;
                PatternSolutionImpl solution = new PatternSolutionImpl();
                for (int j = 1; j < columns.length; j++) {
                    if (columns[j] != null) {
                        long id = rs.getLong(j);
                        if (id != 0) {
                            org.openanzo.rdf.Value value = this.nodeConverter.getGlitterNode(id, connection); // 3)
                            solution.setBinding(columns[j], value);
                        }
                    }
                }
                bindings.add(solution);
            }
            this.nodeConverter.resolveNodes(connection);
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return resultsProcessed;
    }

    protected boolean isNonVacuous(TreeNode node) {
        if (node == null)
            return false;
        // a node is non-vaccuous if it is a triple pattern, has filters, or has a non-vaccuous child
        if (node instanceof TriplePatternNode)
            return true;
        Set<Expression> filters = node.getFilters();
        if (filters != null && !filters.isEmpty())
            return true;
        for (TreeNode child : node.getChildren()) {
            if (isNonVacuous(child))
                return true;
        }
        return false;
    }

    protected void logSql(String sql, String[] params) {
        String s = "SQL: " + sql + "\n\t[";
        for (int i = 0; i < params.length; i++) {
            s += params[i];
            if (i + 1 < params.length)
                s += ", ";
        }
        s += "]";
    }

    protected SolutionSet unitSolution() {
        SolutionList unit = new SolutionList();
        PatternSolutionImpl emptySolution = new PatternSolutionImpl();
        unit.add(emptySolution);
        return unit;
    }

    public boolean willHandleAssignments(MultiMap<Variable, Expression> assignments) {
        return false;
    }
}
