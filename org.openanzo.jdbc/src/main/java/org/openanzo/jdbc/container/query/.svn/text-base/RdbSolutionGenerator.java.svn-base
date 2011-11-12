/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/graph/Attic/BocaSolutionGenerator.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: RdbSolutionGenerator.java 229 2007-08-07 15:22:00Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.container.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.exception.UnknownGraphException;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.SolutionList;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.Graph;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.glitter.syntax.abstrakt.Union;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.container.RDBQuadStore;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.container.sql.GlitterSQL;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.query.NoSolutionsException;
import org.openanzo.jdbc.query.NodeConverter;
import org.openanzo.jdbc.query.SQLQueryConstants;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.vocabulary.RDF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RdbSolutionGenerator implements the core of the Anzo backend; it translates SPARQL queries into SQL queries against the node centric container schema.
 */
public class RdbSolutionGenerator extends AnzoSolutionGeneratorBase implements SolutionGenerator {

    private static final Logger log          = LoggerFactory.getLogger(RdbSolutionGenerator.class);

    protected RDBQuadStore      rdbQuadStore = null;

    protected boolean           myLock       = false;

    /**
     * Create a new RdbSolutionGenerator for data contained in the provided container
     * 
     * @param container
     *            connection to database that contains data
     */
    public RdbSolutionGenerator(RDBQuadStore container) {
        this.rdbQuadStore = container;
        this.noDefaultGraphs = false;
        this.noNamedGraphs = false;
    }

    public String getQueryId() {
        return null;
    }

    @Override
    protected CompositeNodeLayout getNodeLayout() {
        return this.rdbQuadStore.getNodeLayout();
    }

    @Override
    protected String getDefaultGraphsTempTable() {
        return SQLQueryConstants.defaultGraphsTempTable;
    }

    @Override
    protected String getNamedGraphsTempTable() {
        return SQLQueryConstants.namedGraphsTempTable;
    }

    @Override
    protected String getTemporaryTempTable() {
        return SQLQueryConstants.tempGraphsTempTable;
    }

    @Override
    protected Logger getLogger() {
        return log;
    }

    @Override
    protected CoreDBConfiguration getConfiguration() {
        return this.rdbQuadStore.getConfiguration();
    }

    @Override
    protected String getSessionPrefix() {
        return this.rdbQuadStore.getConfiguration().getSessionPrefix();
    }

    @Override
    protected void clearTempTable() throws RdbException, SQLException {
        BaseSQL.truncateTableWithSessionMayCommit(this.rdbQuadStore.getPreparedStatementProvider(), rdbQuadStore.getConnection(), this.rdbQuadStore.getConfiguration().getSessionPrefix(), "TEMP_COLUMNS");
    }

    @Override
    protected void setGraphsType(boolean defaults, GraphSetType type) {
    }

    @Override
    public void initialize() throws GlitterException {
        this.nodeConverter = new NodeConverter(rdbQuadStore.getNodeLayout());
        // start a transaction (if necessary), create a temp table with OK named graph IDs
        Glitter.getLog().debug("Creating temporary graph tables and indexes");
        /* try {
             this.rdbQuadStore.begin();
         } catch (AnzoException be) {
             throw new GlitterException(be);
         }*/
        populateDatasetTables(this.rdbQuadStore.getNodeLayout(), this.rdbQuadStore.getConnection(), SQLQueryConstants.defaultGraphsTempTable, SQLQueryConstants.namedGraphsTempTable, log);
    }

    public void cleanup() throws GlitterException {
        if (!myLock) {
            try {
                BaseSQL.truncateTableWithSessionMayCommit(this.rdbQuadStore.getPreparedStatementProvider(), rdbQuadStore.getConnection(), rdbQuadStore.getConfiguration().getSessionPrefix(), SQLQueryConstants.defaultGraphsTempTable);
                BaseSQL.truncateTableWithSessionMayCommit(this.rdbQuadStore.getPreparedStatementProvider(), rdbQuadStore.getConnection(), rdbQuadStore.getConfiguration().getSessionPrefix(), SQLQueryConstants.namedGraphsTempTable);
            } catch (RdbException sqle) {
                log.error(LogUtils.RDB_MARKER, "Error clearing temporary tables", sqle);
            }
        }
        /* if (myLock) {
             try {
                 this.rdbQuadStore.commit();
             } catch (AnzoException be) {
                 throw new GlitterException(be);
             }
         }*/
    }

    @SuppressWarnings("unchecked")
    final private Class<GraphPattern>[] notHandled = new Class[] { Graph.class, Union.class };

    public SolutionSet generateSolutions(TreeNode node, org.openanzo.rdf.URI namedGraph, Variable namedGraphVariable, SolutionSet requiredBindings, QueryController controller) {
        // we don't do anything which is a UNION
        // or anything that is an ancestor of a node type that we don't handle (UNION, GRAPH)
        if (node instanceof Union || containsNodeType(node, notHandled))
            return null;
        // if this is a graph node, update our graph context and replace the node with the
        // GRAPH's graph pattern (we recurse this for the strange nested GRAPH cases)
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
        }
        // At this point, we know that node is not a GRAPH node and not a UNION node and contains
        // neither.
        try {

            // Short-circuit if:
            // (1) we're querying the default graph which is empty (zero or unit solution)
            // (2) we're querying the named graphs which are empty (zero or unit solution)
            // (3) we're querying a specific named graph which is not in our dataset  (zero or unit solution)
            boolean queryingDefaultGraph = namedGraphVariable == null && namedGraph == null;
            if ((queryingDefaultGraph && noDefaultGraphs) || (!queryingDefaultGraph && noNamedGraphs)) {
                if (isNonVacuous(node))
                    throw new NoSolutionsException();
                else
                    return unitSolution();
            }

            if (!rdbQuadStore.getConfiguration().getSupportsTempOnFind() && !(node instanceof TriplePatternNode)) {
                return null;
            }

            AnzoBGPQuery query = getAnzoBGPQuery(node, namedGraph, namedGraphVariable, requiredBindings);
            SolutionSet solutions = getBindingsForQuery(query, node, null, controller);
            return solutions;
        } catch (NoSolutionsException e) {
            return new SolutionList();
        } catch (SQLException e) {
            log.error(LogUtils.RDB_MARKER, "SQL Error generating solutions", e);
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.SQL_EXCEPTION, e);
        } catch (AnzoException e) {
            log.error(LogUtils.RDB_MARKER, "Anzo exception generating solutions", e);
            throw new GlitterRuntimeException(e);
        }
    }

    @Override
    protected AnzoBGPQuery createAnzoBGPQuery(TreeNode node) {
        return new RdbBGPQuery(this.rdbQuadStore, Glitter.getMostSpecificController(node, information), this.validGraphsInDefaultGraph);
    }

    @Override
    protected Connection getConnection() {
        return this.rdbQuadStore.getConnection();
    }

    /**
     * Get the RDBQuadStore for this solution generator
     * 
     * @return the RDBQuadStore for this solution generator
     */
    public RDBQuadStore getContainer() {
        return rdbQuadStore;
    }

    @Override
    protected PreparedStatementProvider getPreparedStatementProvider() {
        return this.rdbQuadStore.getPreparedStatementProvider();
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

    public boolean willHandleFilters(Set<Expression> filters) {
        return false;
    }

    @Override
    protected int insertGraphByIdIfValid(Long graphId, String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        return GlitterSQL.insertGraphIfValid(getPreparedStatementProvider(), getConnection(), graphId, getSessionPrefix(), insertTable, this.rdbQuadStore.getContainerName());
    }

    @Override
    protected boolean insertGraphsIfValid(Set<URI> graphsSet, String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        Map<URI, Long> graphIds = resolveSet(getNodeLayout(), getConnection(), graphsSet, false);
        for (Map.Entry<URI, Long> graphId : graphIds.entrySet()) {
            int count = insertGraphByIdIfValid(graphId.getValue(), insertTable, defaults);
            if (count == 0)
                throw new UnknownGraphException(graphId.getKey());
        }
        return true;
    }

    @Override
    protected int insertAllGraphsIfValid(String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        Long ngDatasetId = getNodeLayout().fetchId(GRAPHS.GRAPHS_DATASET, getConnection());
        Long ngDatasetMetadataId = getNodeLayout().fetchId(GRAPHS.GRAPHS_DATASET_META, getConnection());
        Long mgDatasetId = getNodeLayout().fetchId(GRAPHS.METADATA_GRAPHS_DATASET, getConnection());
        Long mgDatasetMetadataId = getNodeLayout().fetchId(GRAPHS.METADATA_GRAPHS_DATASET_META, getConnection());
        return GlitterSQL.insertAllValidGraphs(getPreparedStatementProvider(), getConnection(), ngDatasetId, ngDatasetMetadataId, mgDatasetId, mgDatasetMetadataId, getSessionPrefix(), insertTable, this.rdbQuadStore.getContainerName());
    }

    @Override
    protected int insertAllNamedGraphsIfValid(String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        Long rdfTypeId = getNodeLayout().fetchId(RDF.TYPE, getConnection());
        Long namedGraphTypeId = getNodeLayout().fetchId(NamedGraph.TYPE, getConnection());
        Long ngDatasetId = getNodeLayout().fetchId(GRAPHS.GRAPHS_DATASET, getConnection());
        Long mgDatasetId = getNodeLayout().fetchId(GRAPHS.METADATA_GRAPHS_DATASET, getConnection());
        return GlitterSQL.insertAllValidNamedGraphs(getPreparedStatementProvider(), getConnection(), rdfTypeId, namedGraphTypeId, ngDatasetId, mgDatasetId, getSessionPrefix(), insertTable, this.rdbQuadStore.getContainerName());
    }

    @Override
    protected int insertAllMetadataGraphsIfValid(String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        Long hasMetadataGraphId = getNodeLayout().fetchId(NamedGraph.hasMetadataGraphProperty, getConnection());
        Long ngDatasetMetadataId = getNodeLayout().fetchId(GRAPHS.GRAPHS_DATASET_META, getConnection());
        Long mgDatasetMetadataId = getNodeLayout().fetchId(GRAPHS.METADATA_GRAPHS_DATASET_META, getConnection());
        return GlitterSQL.insertAllValidMetadataGraphs(getPreparedStatementProvider(), getConnection(), hasMetadataGraphId, ngDatasetMetadataId, mgDatasetMetadataId, getSessionPrefix(), insertTable, this.rdbQuadStore.getContainerName());
    }

    @Override
    protected int insertDatasetGraphsIfValid(Long datasetId, Long datasetGraphPropertyId, String insertTable, boolean defaults) throws SQLException, GlitterException, AnzoException {
        return GlitterSQL.insertValidDatasetGraphs(getPreparedStatementProvider(), getConnection(), datasetId, datasetId, datasetGraphPropertyId, getSessionPrefix(), insertTable, this.rdbQuadStore.getContainerName());
    }
}
