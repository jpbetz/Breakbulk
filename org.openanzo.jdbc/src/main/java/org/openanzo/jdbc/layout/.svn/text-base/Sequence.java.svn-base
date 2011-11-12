/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/layout/Sequence.java,v $
 * Created by:  Stephen Evanchik <evanchik@us.ibm.com>
 * Created on:  9/30/2005
 * Revision:	$Id: Sequence.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.layout;

import java.sql.Connection;
import java.sql.SQLException;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.jdbc.container.sql.NoSequencesSQL;
import org.openanzo.jdbc.container.sql.SequencesSQL;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.jdbc.utils.RdbException;

/**
 * @author Stephen Evanchik <evanchik@us.ibm.com>
 */
class Sequence {

    /**
     * Get the next ID in the node sequence
     * 
     * @param sequenceName
     *            name of the sequence *
     * @param stmtProvider
     *            Cache of prepared statements
     * @param connection
     *            connection to the database
     * @param supportsSequences
     *            true if the database engine supports sequences, false otherwise
     * @return A Long containing containing the next node ID
     * @throws RdbException
     *             if there was an exception getting the next sequence value
     */
    static protected synchronized Long getNext(String sequenceName, PreparedStatementProvider stmtProvider, Connection connection, boolean supportsSequences) throws RdbException {
        Long nodeId = null;
        if (supportsSequences) {
            nodeId = SequencesSQL.getNodeID(stmtProvider, connection, sequenceName);
        } else {
            try {
                boolean inTransaction = !connection.getAutoCommit();
                if (!inTransaction) {
                    try {
                        connection.setAutoCommit(false);
                    } catch (SQLException t) {
                        throw new RdbException(ExceptionConstants.RDB.FAILED_START_RDB_TRANSACTION, t);
                    }
                }
                try {
                    nodeId = NoSequencesSQL.selectNodeID(stmtProvider, connection, sequenceName);
                    nodeId = Long.valueOf(nodeId.longValue() + 1);
                    NoSequencesSQL.updateNodeID(stmtProvider, connection, nodeId.longValue(), sequenceName);
                    if (!inTransaction)
                        connection.commit();
                } catch (RdbException t) {
                    if (!inTransaction)
                        connection.rollback();
                    throw t;
                } catch (SQLException t) {
                    if (!inTransaction)
                        connection.rollback();
                    throw t;
                } finally {
                    if (!inTransaction)
                        connection.setAutoCommit(true);
                }
            } catch (SQLException t) {
                throw new RdbException(ExceptionConstants.RDB.FAILED_START_RDB_TRANSACTION, t);
            }
        }
        return nodeId;

    }
}
