/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/ValueLayout.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: ValueLayout.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.util.Collection;

import org.openanzo.jdbc.container.sql.NoSequencesSQL;
import org.openanzo.jdbc.container.sql.NodeSQL;
import org.openanzo.jdbc.container.sql.NodeSQL.FetchAllCommonValuesResult;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;

/**
 * Provides read/write access to persisted string values of limited length in a single table. This class's original purpose was for storing RDF datatype and
 * language strings. The length limit is database dependant. For example, a DB2 instance may limit length to 250 chars.
 * 
 * @author Joe Betz
 * @author Stephen Evanchik <evanchik@us.ibm.com>
 */
class ValueLayout implements IValueLayout {

    private final PreparedStatementProvider stmtProvider;

    private final String                    tableName;

    private final String                    optimizationString;

    private final String                    sequenceName;

    private final boolean                   supportsSequences;

    /**
     * Construct a layout to store String values in a database
     * 
     * @param type
     *            Type of nodes this is storing
     * @param stmtProvider
     *            The interface to the SQL prepared statement cache
     * @param sequenceName
     *            The name of the sequence that is used to get IDs
     * @param tableName
     *            The name of the table where the nodes are stored
     * @param optimizationString
     *            Extra parameters added to queries for database specific optimizations
     */
    protected ValueLayout(PreparedStatementProvider stmtProvider, String tableName, String optimizationString, String sequenceName, boolean supportsSequences) {
        if (stmtProvider == null)
            throw new InvalidParameterException("stmtProvider must not be null");
        if (tableName == null)
            throw new InvalidParameterException("tableName must not be null");
        this.stmtProvider = stmtProvider;
        this.tableName = tableName;
        this.optimizationString = optimizationString;
        this.sequenceName = sequenceName;
        this.supportsSequences = supportsSequences;
    }

    public Long store(String value, Connection connection) throws RdbException {
        Long id = fetchId(value, connection);
        if (id == null) {
            if (supportsSequences) {
                id = Sequence.getNext(sequenceName, stmtProvider, connection, supportsSequences);
                NodeSQL.insertCommonValue(stmtProvider, connection, id, value, tableName);
            } else {
                id = NoSequencesSQL.insertCommonValue(stmtProvider, connection, value, tableName);
            }
        }
        return id;
    }

    public Long fetchId(String value, Connection connection) throws RdbException {
        return NodeSQL.fetchCommonValueID(stmtProvider, connection, value, tableName, optimizationString);
    }

    public String fetchValue(Long id, Connection connection) throws RdbException {
        return NodeSQL.fetchCommonValue(stmtProvider, connection, id.longValue(), tableName, optimizationString);
    }

    public void batchAdd(Collection<String> iter, Connection connection) throws RdbException {
        for (String string : iter) {
            store(string, connection);
        }
    }

    public ClosableIterator<FetchAllCommonValuesResult> fetchAll(Connection connection) throws RdbException {
        return NodeSQL.fetchAllCommonValues(stmtProvider, connection, tableName);
    }
}
