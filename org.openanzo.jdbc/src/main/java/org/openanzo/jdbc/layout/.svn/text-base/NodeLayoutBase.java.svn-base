/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/NodeLayoutBase.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: NodeLayoutBase.java 178 2007-07-31 14:22:33Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.jdbc.container.sql.NodeSQL;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Value;

/**
 * Abstract class. Provides read/write access to node's persisted in either a single table or two tables, where the first table stores nodes short enough to be
 * indexed and the second table stores the long nodes. In the long node table hashes are generated for the indices.
 * 
 * @param <T>
 *            Type of Value being stored
 * @author Joe Betz
 * @author Stephen Evanchik <evanchik@us.ibm.com>
 */
abstract class NodeLayoutBase<T extends Value> implements INodeLayout<T> {

    //private static final Logger         log = LoggerFactory.getLogger(NodeLayoutBase.class);

    /**
     * The maximum length a node's string representation can be before it is considered a long node
     */
    protected int                             maxLength;

    protected final PreparedStatementProvider stmtProvider;

    protected final String                    tableName;

    protected final String                    longTableName;

    protected final String                    sessionPrefix;

    protected final String                    resourceTempTableName;

    protected final String                    idTempTableName;

    protected final boolean                   supportsSequences;

    protected final String                    sequenceName;

    protected final String                    longSequenceName;

    protected final String                    optimizationString;

    protected final String                    lockedIdsName;

    /**
     * Construct a layout to store nodes in a database
     * 
     * @param stmtProvider
     *            The interface to the SQL prepared statement cache
     * @param supportsSequences
     *            Does the underlying database support sequences to get IDs
     * @param sequenceName
     *            The name of the sequence that is used to get IDs
     * @param longSequenceName
     *            The name of the sequence that is used to get IDs for long objects
     * @param tableName
     *            The name of the table where the nodes are stored
     * @param longTableName
     *            The name of the table where excessively long nodes are stored
     * @param resourceTempTableName
     *            The name of the temporary table used to bulk insert nodes
     * @param idTempTableName
     *            The name of the temporary table used to bulk id resolution
     * @param maxLength
     *            The maximum length of a node's string representation before it is considered long
     * @param optimizationString
     *            Extra parameters added to queries for database specific optimizations
     */
    protected NodeLayoutBase(PreparedStatementProvider stmtProvider, boolean supportsSequences, String sequenceName, String longSequenceName, String tableName, String longTableName, String sessionPrefix, String resourceTempTableName, String idTempTableName, int maxLength, String optimizationString, String lockedIdsName) {
        this.stmtProvider = stmtProvider;
        this.sequenceName = sequenceName;
        this.longSequenceName = longSequenceName;
        this.tableName = tableName;
        this.longTableName = longTableName;
        this.sessionPrefix = sessionPrefix;
        this.resourceTempTableName = resourceTempTableName;
        this.idTempTableName = idTempTableName;
        this.maxLength = maxLength;
        this.supportsSequences = supportsSequences;
        this.optimizationString = optimizationString;
        this.lockedIdsName = lockedIdsName;
    }

    /**
     * Determines whether or not a node is 'long'
     * 
     * @param n
     *            The node to test
     * @return true if the node is a long node, false otherwise
     */
    protected boolean isLong(T n) {
        try {
            return (longTableName != null && n.toString().getBytes(Constants.byteEncoding).length > maxLength);
        } catch (UnsupportedEncodingException uee) {
            throw new AnzoRuntimeException(ExceptionConstants.IO.ENCODING_ERROR, uee);
        }
    }

    public Long fetchId(T n, Connection connection) throws RdbException {
        String value = null;
        if (n instanceof BlankNode) {
            value = ((BlankNode) n).getLabel();
        } else {
            value = n.toString();
        }
        long hash = n.hashCode();
        Long nodeID = null;
        if (isLong(n)) {
            ClosableIterator<NodeSQL.FetchLongNodeIDResult> results = NodeSQL.fetchLongNodeID(stmtProvider, connection, hash, longTableName);
            try {
                for (NodeSQL.FetchLongNodeIDResult result : results) {
                    if (result.getValue().equals(value)) {
                        nodeID = Long.valueOf(result.getId());
                        break;
                    }
                }
            } finally {
                results.close();
            }
        } else {
            nodeID = NodeSQL.fetchNodeID(stmtProvider, connection, value, tableName, optimizationString);
        }
        return nodeID;

    }

    /**
     * Get the longSequenceName
     * 
     * @return the longSequenceName
     */
    public String getLongSequenceName() {
        return longSequenceName;
    }

    /**
     * Get the sequenceName
     * 
     * @return the sequenceName
     */
    public String getSequenceName() {
        return sequenceName;
    }

    /**
     * @param maxLength
     *            the maxLength to set
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
