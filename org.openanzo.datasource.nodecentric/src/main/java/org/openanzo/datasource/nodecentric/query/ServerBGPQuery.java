/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/glitter/BocaServerBGPQuery.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: ServerBGPQuery.java 229 2007-08-07 15:22:00Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.query;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

import org.openanzo.datasource.nodecentric.internal.NodeCentricOperationContext;
import org.openanzo.datasource.nodecentric.sql.GlitterRdbWrapper;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.container.query.AnzoBGPQuery;
import org.openanzo.jdbc.container.query.GraphSetType;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.query.NoSolutionsException;
import org.openanzo.jdbc.query.SQLQueryConstants;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.rdf.utils.Collections;

/**
 * ServerBGPQuery creates SQL queries against the Anzo relational schema from conjoined triple patterns. The entire context of a single ServerBGPQuery instance
 * can be constrained with a GRAPH clause (with either an IRI reference or a variable.)
 * 
 * It does not handle UNION patterns or FILTERs.
 * 
 * The algorithms in this class are based on research in:
 * http://www.cs.wayne.edu/~artem/main/research/TR-DB-052006-CLJF.pdf#search=%22sparql%20sql%20optional%20wayne%22 adjusted to the particulars of the Anzo
 * relational schema. Other deviations from Chebotko et al.'s work are documented below.
 * 
 * @author lee
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class ServerBGPQuery extends AnzoBGPQuery {
    private final NodeCentricOperationContext context;

    private final long                        numberDefaultGraphs;

    private final int                         defaultGraphRevisioned;

    private final int                         namedGraphsRevisioned;

    private String                            defaultGraphStatementsTable = null;

    private String                            namedGraphsStatementsTable  = null;

    private boolean                           bypassAcls                  = false;

    private boolean                           datasetResolved             = false;

    private GraphSetType                      defaultGraphsType           = null;

    private GraphSetType                      namedGraphsType             = null;

    private static final boolean              USE_EXISTS                  = false;

    /**
     * Create a new ServerBGPQuery
     * 
     * @param context
     *            NodeCentric specific context, which contains connection to run queries against
     * @param qi
     *            query
     * @param lastTransactionTime
     *            If not null, all generated queries only find triples that were active as of the given time
     */
    protected ServerBGPQuery(NodeCentricOperationContext context, QueryInformation qi, int revisionedDefaultGraph, int revisionedNamedGraphs, long validDefaultGraphs) {
        super(qi);
        this.numberDefaultGraphs = validDefaultGraphs;
        this.context = context;
        this.defaultGraphRevisioned = revisionedDefaultGraph;
        this.namedGraphsRevisioned = revisionedNamedGraphs;
    }

    @Override
    protected CoreDBConfiguration getConfiguration() {
        return context.getConfiguration();
    }

    @Override
    protected PreparedStatementProvider getPreparedStatementProvider() {
        return context.getStatementProvider();
    }

    @Override
    protected long getNumberOfValidDefaultGraphs() {
        return numberDefaultGraphs;
    }

    @Override
    protected Collection<Long> getValidDefaultGraphs() throws AnzoException {
        ClosableIterator<Long> results = GlitterRdbWrapper.selectGraphs(this.context.getStatementProvider(), getConnection(), context.getConfiguration().getSessionPrefix(), SQLQueryConstants.defaultGraphsTempTable);
        return Collections.toList(results);
    }

    @Override
    protected Connection getConnection() {
        return this.context.getConnection();
    }

    @Override
    protected CompositeNodeLayout getNodeLayout() {
        return this.context.getNodeLayout();
    }

    @Override
    protected boolean bypassAcls() {
        return bypassAcls;
    }

    @Override
    protected GraphSetType getDefaultGraphsType() {
        return defaultGraphsType;
    }

    @Override
    protected GraphSetType getNamedGraphsType() {
        return namedGraphsType;
    }

    @Override
    protected String getNamedGraphInQuery(String columnName) {
        if (USE_EXISTS) {
            return "EXISTS (SELECT " + getDefaultGraphsTable() + ".ID FROM " + getDefaultGraphsTable() + " WHERE " + getDefaultGraphsTable() + ".ID=" + columnName + ")";
        } else {
            if (context.getConfiguration().getDriverClassName().equals("oracle.jdbc.OracleDriver")) {
                return columnName + " IN(SELECT " + getQueryHint(getDefaultGraphsTable()) + " ID FROM " + getDefaultGraphsTable() + ")";
            } else {
                return super.getNamedGraphInQuery(columnName);
            }
        }
    }

    @Override
    protected String getStatementTable() {
        if (useDefaultDataset() && this.defaultGraphStatementsTable != null)
            return this.defaultGraphStatementsTable;
        else if (!useDefaultDataset() && this.namedGraphsStatementsTable != null)
            return this.namedGraphsStatementsTable;
        else
            return ServerSQL.statementTable;
    }

    /**
     * @param statementsTable
     *            the statementsTable to set
     */
    public void setDefaultGraphStatementsTable(String statementsTable) {
        this.defaultGraphStatementsTable = statementsTable;
    }

    /**
     * @param statementsTable
     *            the statementsTable to set
     */
    public void setNamedGraphsStatementsTable(String statementsTable) {
        this.namedGraphsStatementsTable = statementsTable;
    }

    @Override
    protected String getDefaultGraphsTable() {
        return context.getConfiguration().getSessionPrefix() + ServerSQL.defaultGraphsTempTable;
    }

    @Override
    protected String getNamedGraphsTable() {
        return context.getConfiguration().getSessionPrefix() + ServerSQL.namedGraphsTempTable;
    }

    @Override
    protected String getLiteralTable() {
        return "ALL_LITERALS_VIEW";
    }

    protected void setDefaultGraphsType(GraphSetType type) {
        this.defaultGraphsType = type;
    }

    protected void setNamedGraphsType(GraphSetType type) {
        this.namedGraphsType = type;
    }

    /**
     * @param bypassAcls
     *            the bypassAcls to set
     */
    public void setBypassAcls(boolean bypassAcls) {
        this.bypassAcls = bypassAcls;
    }

    /**
     * @return the datasetResolved
     */
    public boolean isDatasetResolved() {
        return datasetResolved;
    }

    /**
     * @param datasetResolved
     *            the datasetResolved to set
     */
    public void setDatasetResolved(boolean datasetResolved) {
        this.datasetResolved = datasetResolved;
    }

    @Override
    protected List<String> populateConstraintsFromTriples(List<String> constraints, Iterable<TripleInstance> triples, String alternativeColumnForNamedGraphs) throws NoSolutionsException {
        List<String> columns = super.populateConstraintsFromTriples(constraints, triples, alternativeColumnForNamedGraphs);
        for (TripleInstance ti : triples) {
            constraints.add(ti.getTripleTableAlias() + ".COMMITTED = 0 ");
            if ((useDefaultDataset() && this.defaultGraphRevisioned == 1) || (!useDefaultDataset() && this.namedGraphsRevisioned == 1)) {
                constraints.add(ti.getTripleTableAlias() + ".REND IS NULL ");
            }
        }
        return columns;
    }

    @Override
    protected String getQueryHint(String tableName) {
        //if (tableName != null && context.getConfiguration().getDriverClassName().equals("oracle.jdbc.OracleDriver")) {
        //     return "/*+ cardinality (" + tableName + " 8) */";
        //  } else {
        return "";
        // }
    }
}
