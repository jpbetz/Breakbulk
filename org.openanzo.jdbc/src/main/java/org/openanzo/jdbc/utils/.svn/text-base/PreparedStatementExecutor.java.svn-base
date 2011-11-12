/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 20, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Abstract class that allows for batch execution of a generated prepared statement wrapper
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class PreparedStatementExecutor {
    protected boolean                 closed = false;

    final protected PreparedStatement ps;

    /**
     * Create an executor
     * 
     * @param connection
     *            connection to the database
     * @param provider
     *            the prepared statement provider
     * @param preparedStatementName
     *            name of prepared statement
     * @param templateParams
     *            template params for the prepared statement
     * @throws RdbException
     */
    public PreparedStatementExecutor(Connection connection, PreparedStatementProvider provider, String preparedStatementName, String... templateParams) throws RdbException {
        try {
            ps = provider.prepareStatement(preparedStatementName, templateParams, connection);
        } catch (SQLException sqle) {
            throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
        }
    }

    /**
     * Execute the batch statement
     * 
     * @throws RdbException
     */
    final public void executeStatement() throws RdbException {
        try {
            try {
                ps.executeBatch();
            } finally {
                ps.clearBatch();
            }
        } catch (SQLException sqle) {
            throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL, sqle);
        }
    }

    /**
     * Close the prepared statement
     * 
     * @throws RdbException
     */
    final public void close() throws RdbException {
        if (!closed) {
            try {
                ps.close();
            } catch (SQLException sqle) {
                throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL, sqle);
            } finally {
                closed = true;
            }
        }
    }
}
