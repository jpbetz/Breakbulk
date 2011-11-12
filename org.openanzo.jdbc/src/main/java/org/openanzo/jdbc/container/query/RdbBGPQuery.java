/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
did  * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/graph/Attic/BocaBGPQuery.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: RdbBGPQuery.java 229 2007-08-07 15:22:00Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.container.query;

import java.sql.Connection;
import java.util.Collection;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.container.RDBQuadStore;
import org.openanzo.jdbc.container.sql.GlitterSQL;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.query.NoSolutionsException;
import org.openanzo.jdbc.query.SQLQueryConstants;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.Value;

/**
 * RdbBGPQuery creates SQL queries agains the Anzo relational schema from conjoined triple patterns. The entire context of a single RdbBGPQuery instance can be
 * constrainted with a GRAPH clause (with either an IRI reference of a variable.)
 * 
 * It does not handle OPTIONAL patterns, UNION patterns, or FILTERs.
 * 
 * The algorithms in this class are based on research in:
 * http://www.cs.wayne.edu/~artem/main/research/TR-DB-052006-CLJF.pdf#search=%22sparql%20sql%20optional%20wayne%22 adjusted to the particulars of the Anzo
 * relational schema. Other deviations from Chebotko et al.'s work are documented below.
 * 
 * @author lee
 * 
 */
public class RdbBGPQuery extends AnzoBGPQuery {
    protected RDBQuadStore container          = null;

    long                   validDefaultGraphs = 0;

    /**
     * Create a new RdbBGPQuery
     * 
     * @param container
     *            source of data
     * @param queryInformation
     *            Glitter queryInformation
     * @param validDefaultGraphs
     *            numer of valid default graphs
     * 
     */
    public RdbBGPQuery(RDBQuadStore container, QueryInformation queryInformation, long validDefaultGraphs) {
        super(queryInformation);
        this.validDefaultGraphs = validDefaultGraphs;
        this.container = container;
    }

    @Override
    protected CoreDBConfiguration getConfiguration() {
        return container.getConfiguration();
    }

    @Override
    protected PreparedStatementProvider getPreparedStatementProvider() {
        return container.getPreparedStatementProvider();
    }

    @Override
    protected long getNumberOfValidDefaultGraphs() {
        return validDefaultGraphs;
    }

    @Override
    protected Collection<Long> getValidDefaultGraphs() throws AnzoException {
        ClosableIterator<Long> results = GlitterSQL.selectGraphs(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), SQLQueryConstants.defaultGraphsTempTable, null);
        return org.openanzo.rdf.utils.Collections.toList(results);
    }

    @Override
    protected Long getId(TriplePatternComponent tpc) throws NoSolutionsException {
        try {
            Long l = container.getNodeLayout().fetchId((Value) tpc, container.getConnection());

            if (l == null)
                throw new NoSolutionsException();
            return l;
        } catch (AnzoException re) {
            throw new NoSolutionsException(re);
        }
    }

    @Override
    protected Connection getConnection() {
        return this.container.getConnection();
    }

    @Override
    protected CompositeNodeLayout getNodeLayout() {
        return this.container.getNodeLayout();
    }

    @Override
    protected String getStatementTable() {
        return container.getContainerName() + "_S";
    }

    @Override
    protected String getDefaultGraphsTable() {
        return container.getConfiguration().getSessionPrefix() + SQLQueryConstants.defaultGraphsTempTable;
    }

    @Override
    protected String getNamedGraphsTable() {
        return container.getConfiguration().getSessionPrefix() + SQLQueryConstants.namedGraphsTempTable;
    }

    @Override
    protected String getLiteralTable() {
        return this.container.getContainerName() + "_L";
    }

    @Override
    protected boolean bypassAcls() {
        return false;
    }

    @Override
    protected GraphSetType getDefaultGraphsType() {
        return GraphSetType.LISTED;
    }

    @Override
    protected GraphSetType getNamedGraphsType() {
        return GraphSetType.LISTED;
    }

    @Override
    protected String getQueryHint(String tableName) {
        return "";
    }
}
