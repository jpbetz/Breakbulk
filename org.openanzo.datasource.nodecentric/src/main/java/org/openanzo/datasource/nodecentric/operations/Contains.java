/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jan 18, 2008
 * Revision:    $Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.openanzo.datasource.nodecentric.internal.NodeCentricOperationContext;
import org.openanzo.datasource.nodecentric.sql.NamedGraphRdbWrapper;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Set of find operations for both regular finds, as well as find with results.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Contains {

    private static final Logger log             = LoggerFactory.getLogger(Contains.class);

    private static final String SUBJECT_TEMP    = "SUBJECT_IDS_TEMP";

    private static final String PREDICATE_TEMP  = "PREDICATE_IDS_TEMP";

    private static final String OBJECT_TEMP     = "OBJECT_IDS_TEMP";

    private static final String NAMEDGRAPH_TEMP = "NAMEDGRAPH_IDS_TEMP";

    /**
     * Find statements in context that match pattern. <li>If graphTable is not null, queries are joined against temporary table containing valid graphs for this
     * query</li> <li>Else if the namedGraphId is not null, then queries go against only statements that have the specific namedGraphId</li> <li>Finally, if
     * both the graphTable and namedGraphId are null, query either queries all graphs if metadataGraph==-1, namedGraphs if metadataGraph==0, or metadataGraphs
     * if metadataGraph==1
     * 
     * @param context
     *            source of data
     * @param tableName
     *            statements table
     * @param revisioned
     *            include temporal limits in query
     * @param timestamp
     *            include temporal limit in query, if null and revisioned is true, uses all data including current transaction data
     * @param subject
     *            Subject resource to match, or wildcard if null
     * @param predicate
     *            Predicate uri to match, or wildcard if null
     * @param object
     *            Object value to match, or wildcard if null
     * @param namedGraphUri
     *            id of namedGraph to query
     * @return Iterable set of quads containing results of find operation
     * @throws AnzoException
     *             if there was an error finding statements
     */
    public static boolean contains(NodeCentricOperationContext context, String tableName, boolean revisioned, Long timestamp, Resource[] subject, URI[] predicate, Value[] object, URI[] namedGraphUri) throws AnzoException {
        try {
            ArrayList<Long> subjectIds = null;
            ArrayList<Long> predicateIds = null;
            ArrayList<Long> objectIds = null;
            ArrayList<Long> namedGraphIds = null;
            try {
                if (subject != null && subject.length > 0) {
                    if (subject.length > 1 || subject[0] != null) {
                        subjectIds = new ArrayList<Long>();
                        for (Resource subj : subject) {
                            Long id = context.getNodeLayout().fetchId(subj, context.getConnection());
                            if (id == null && subject.length == 1) {
                                return false; // required node is not even in db
                            } else {
                                subjectIds.add(id);
                            }
                        }
                        if (subjectIds.size() == 0) {
                            return false; // required node is not even in db
                        }
                        if (subjectIds.size() >= 100) {
                            insertIdsToTempTable(context, SUBJECT_TEMP, subjectIds);
                        }
                    }
                }
                if (predicate != null && predicate.length > 0) {
                    if (predicate.length > 1 || predicate[0] != null) {
                        predicateIds = new ArrayList<Long>();
                        for (URI pred : predicate) {
                            Long id = context.getNodeLayout().fetchId(pred, context.getConnection());
                            if (id == null && predicate.length == 1) {
                                return false; // required node is not even in db
                            } else {
                                predicateIds.add(id);
                            }
                        }
                        if (predicateIds.size() == 0) {
                            return false; // required node is not even in db
                        }
                        if (predicateIds.size() >= 100) {
                            insertIdsToTempTable(context, PREDICATE_TEMP, predicateIds);
                        }
                    }
                }
                if (object != null && object.length > 0) {
                    if (object.length > 1 || object[0] != null) {
                        objectIds = new ArrayList<Long>();
                        for (Value obj : object) {
                            Long id = context.getNodeLayout().fetchId(obj, context.getConnection());
                            if (id == null && object.length == 1) {
                                return false; // required node is not even in db
                            } else {
                                objectIds.add(id);
                            }
                        }
                        if (objectIds.size() == 0) {
                            return false; // required node is not even in db
                        }
                        if (objectIds.size() >= 100) {
                            insertIdsToTempTable(context, OBJECT_TEMP, objectIds);
                        }
                    }
                }
                if (namedGraphUri != null && namedGraphUri.length > 0) {
                    if (namedGraphUri.length > 1 || namedGraphUri[0] != null) {
                        namedGraphIds = new ArrayList<Long>();
                        for (URI ngURI : namedGraphUri) {
                            Long id = context.getNodeLayout().fetchId(ngURI, context.getConnection());
                            if (id == null && namedGraphUri.length == 1) {
                                return false; // required node is not even in db
                            } else {
                                namedGraphIds.add(id);
                            }
                        }
                        if (namedGraphIds.size() == 0) {
                            return false; // required node is not even in db
                        }
                        if (namedGraphIds.size() >= 100) {
                            insertIdsToTempTable(context, NAMEDGRAPH_TEMP, namedGraphIds);
                        }
                    }
                }
                String sql = generateSQLStatement(context, tableName, revisioned, timestamp, subjectIds, predicateIds, objectIds, namedGraphIds);
                Statement stmt = context.getConnection().createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = stmt.executeQuery(sql);
                    if (resultSet.next()) {
                        return true;
                    } else {
                        return false;
                    }
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                }
            } finally {
                try {
                    if (subjectIds != null && subjectIds.size() >= 100) {
                        BaseSQL.clearTableWithSessionPrefix(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), SUBJECT_TEMP);
                    }
                    if (predicateIds != null && predicateIds.size() >= 100) {
                        BaseSQL.clearTableWithSessionPrefix(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), PREDICATE_TEMP);
                    }
                    if (objectIds != null && objectIds.size() >= 100) {
                        BaseSQL.clearTableWithSessionPrefix(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), OBJECT_TEMP);
                    }
                    if (namedGraphIds != null && namedGraphIds.size() >= 100) {
                        BaseSQL.clearTableWithSessionPrefix(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), NAMEDGRAPH_TEMP);
                    }
                } catch (RdbException e) {
                    log.error(LogUtils.RDB_MARKER, "Error clearing temporary tables", e);
                }
            }
        } catch (SQLException e) {
            throw new AnzoException(ExceptionConstants.RDB.FAILED_EXECUTING_SQL, e);
        }
    }

    /**
     * Insert the id into the temp table
     * 
     * @param context
     *            The context used for operation
     * @param tableName
     *            Table name in which to insert ids
     * @param ids
     *            Ids to insert
     * @throws AnzoException
     */
    public static void insertIdsToTempTable(NodeCentricOperationContext context, String tableName, Collection<Long> ids) throws AnzoException {
        PreparedStatement ps = null;
        try {
            ps = context.getStatementProvider().getPreparedSQLStatement(NamedGraphRdbWrapper.insertIdsIntoTempTable, new String[] { context.getConfiguration().getSessionPrefix(), tableName }, context.getConnection());
            ps.clearBatch();
            for (Long id : ids) {
                ps.setLong(1, id);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new AnzoException(ExceptionConstants.RDB.FAILED_EXECUTING_SQL, e);
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException sqle) {
                if (log.isTraceEnabled()) {
                    log.trace(LogUtils.RDB_MARKER, "Error closing prepared statement", sqle);
                }
            }
        }
    }

    private static final String SELECT                     = "SELECT FAKE FROM GLITTERUNIT WHERE EXISTS (SELECT NAMEDGRAPHID FROM ";

    private static final String AND                        = " AND ";

    private static final String WHERE                      = " WHERE ";

    private static final String REVISIONED                 = " REND IS NULL ";

    private static final String REVISIONED_HSTART          = " COMMITTED=0 ";

    private static final String REVISIONED_HEND            = " REND IS NULL OR REND > ";

    private static final String SUBJECT                    = " SUBJECT= ";

    private static final String SUBJECT_IN                 = " SUBJECT IN (";

    private static final String SUBJECT_IN_TEMP_START      = " EXISTS (SELECT ID FROM ";

    private static final String SUBJECT_IN_TEMP_END        = " WHERE ID=SUBJECT)";

    private static final String PREDICATE                  = " PREDICATE= ";

    private static final String PREDICATE_IN               = " PREDICATE IN (";

    private static final String PREDICATE_IN_TEMP_START    = " EXISTS (SELECT ID FROM ";

    private static final String PREDICATE_IN_TEMP_END      = " WHERE ID=PREDICATE)";

    private static final String OBJECT                     = " OBJECT= ";

    private static final String OBJECT_IN                  = " OBJECT IN (";

    private static final String OBJECT_IN_TEMP_START       = " EXISTS (SELECT ID FROM ";

    private static final String OBJECT_IN_TEMP_END         = " WHERE ID=OBJECT)";

    private static final String NAMEDGRAPHID               = " NAMEDGRAPHID= ";

    private static final String NAMEDGRAPHID_IN            = " NAMEDGRAPHID IN (";

    private static final String NAMEDGRAPHID_IN_TEMP_START = " EXISTS (SELECT ID FROM ";

    private static final String NAMEDGRAPHID_IN_TEMP_END   = " WHERE ID=NAMEDGRAPHID)";

    private static String generateSQLStatement(NodeCentricOperationContext context, String tableName, boolean revisioned, Long timestamp, ArrayList<Long> subjectIds, ArrayList<Long> predicateIds, ArrayList<Long> objectIds, ArrayList<Long> namedGraphIds) {
        StringBuilder sb = new StringBuilder();
        sb.append(SELECT);
        sb.append(tableName);
        sb.append(WHERE);
        boolean first = true;
        if (subjectIds != null && subjectIds.size() > 0) {
            if (subjectIds.size() == 1) {
                sb.append(SUBJECT);
                sb.append(subjectIds.get(0).toString());
            } else if (subjectIds.size() < 100) {
                sb.append(SUBJECT_IN);
                for (Iterator<Long> ids = subjectIds.iterator(); ids.hasNext();) {
                    sb.append(ids.next().toString());
                    if (ids.hasNext()) {
                        sb.append(',');
                    }
                }
                sb.append(')');
            } else {
                sb.append(SUBJECT_IN_TEMP_START);
                sb.append(context.getConfiguration().getSessionPrefix());
                sb.append(SUBJECT_TEMP);
                sb.append(SUBJECT_IN_TEMP_END);
            }
            first = false;
        }
        if (predicateIds != null && predicateIds.size() > 0) {
            if (!first) {
                sb.append(AND);
            } else {
                first = false;
            }
            if (predicateIds.size() == 1) {
                sb.append(PREDICATE);
                sb.append(predicateIds.get(0).toString());
            } else if (predicateIds.size() < 100) {
                sb.append(PREDICATE_IN);
                for (Iterator<Long> ids = predicateIds.iterator(); ids.hasNext();) {
                    sb.append(ids.next().toString());
                    if (ids.hasNext()) {
                        sb.append(',');
                    }
                }
                sb.append(')');
            } else {
                sb.append(PREDICATE_IN_TEMP_START);
                sb.append(context.getConfiguration().getSessionPrefix());
                sb.append(PREDICATE_TEMP);
                sb.append(PREDICATE_IN_TEMP_END);
            }
        }
        if (objectIds != null && objectIds.size() > 0) {
            if (!first) {
                sb.append(AND);
            } else {
                first = false;
            }
            if (objectIds.size() == 1) {
                sb.append(OBJECT);
                sb.append(objectIds.get(0).toString());
            } else if (objectIds.size() < 100) {
                sb.append(OBJECT_IN);
                for (Iterator<Long> ids = objectIds.iterator(); ids.hasNext();) {
                    sb.append(ids.next().toString());
                    if (ids.hasNext()) {
                        sb.append(',');
                    }
                }
                sb.append(')');
            } else {
                sb.append(OBJECT_IN_TEMP_START);
                sb.append(context.getConfiguration().getSessionPrefix());
                sb.append(OBJECT_TEMP);
                sb.append(OBJECT_IN_TEMP_END);
            }
        }
        if (namedGraphIds != null && namedGraphIds.size() > 0) {
            if (!first) {
                sb.append(AND);
            } else {
                first = false;
            }
            if (namedGraphIds.size() == 1) {
                sb.append(NAMEDGRAPHID);
                sb.append(namedGraphIds.get(0).toString());
            } else if (namedGraphIds.size() < 100) {
                sb.append(NAMEDGRAPHID_IN);
                for (Iterator<Long> ids = namedGraphIds.iterator(); ids.hasNext();) {
                    sb.append(ids.next().toString());
                    if (ids.hasNext()) {
                        sb.append(',');
                    }
                }
                sb.append(')');
            } else {
                sb.append(NAMEDGRAPHID_IN_TEMP_START);
                sb.append(context.getConfiguration().getSessionPrefix());
                sb.append(NAMEDGRAPH_TEMP);
                sb.append(NAMEDGRAPHID_IN_TEMP_END);
            }
        }
        if (revisioned) {
            if (!first) {
                sb.append(AND);
            } else {
                first = false;
            }
            if (timestamp == null) {
                sb.append(REVISIONED);
            } else {
                sb.append(REVISIONED_HSTART);
                sb.append(timestamp.toString());
                sb.append(AND);
                sb.append('(');
                sb.append(REVISIONED_HEND);
                sb.append(timestamp.toString());
                sb.append(')');

            }
        }
        sb.append(')');
        return sb.toString();
    }

}
