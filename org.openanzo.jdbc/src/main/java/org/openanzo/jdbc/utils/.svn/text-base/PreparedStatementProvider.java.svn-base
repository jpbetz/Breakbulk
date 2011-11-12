/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/sqlcache/PreparedStatementProvider.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: PreparedStatementProvider.java 229 2007-08-07 15:22:00Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Properties;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides a cache of JDBC statement definitions. JDBC statements may be loaded from a java Properties file, a java Properties object or may be added using
 * 'addPreparedStatement'. The key of each property is a string name for that prepared statement and the value is the SQL statement or, for non-querying
 * statements with no JDBC paramters, a list of statements seperated ';;'. If a properties entry contains a list of statements as the value, only 'runSQLGroup'
 * may be used to access these statements.
 * 
 * Template variables may optionally be put in the JDBC statements using a '${varname}' syntax. These template variables should only be used to parameterize the
 * tablenames or other values where it will be the same for a substantial number of calls. If the template variable is rarely the same value the cache will
 * perform poorly, in which case it is better to use JDBC '?' parameters or dynamically generate the SQL and run it as a callable statement.
 * 
 * @author <a href="mailto:evanchik@us.ibm.com">Stephen Evanchik</a>
 * @version $Revision: 154 $ on $Date: 2007-07-31 10:00:53 -0400 (Tue, 31 Jul 2007) $
 */
public class PreparedStatementProvider {
    private static final Logger log           = LoggerFactory.getLogger(PreparedStatementProvider.class);

    private Properties          sqlOperations = new Properties();

    /**
     * Create a new PreparedStatementProvider for the given connection
     * 
     */
    public PreparedStatementProvider() {
    }

    /**
     * Load the contents of this file containing ddl and prepared statement text
     * 
     * @param sqlFileInputStream
     *            input stream containing ddl and prepared statement text
     * @throws RdbException
     *             {@link ExceptionConstants.RDB#FAILED_LOAD_SQL_FILE_INPUTSTREAM} if there was a problem loading the sql statements from the input stream
     */
    public void loadSQLFile(InputStream sqlFileInputStream) throws RdbException {
        try {
            sqlOperations.load(sqlFileInputStream);
        } catch (IOException ioe) {
            throw new RdbException(ExceptionConstants.RDB.FAILED_LOAD_SQL_FILE_INPUTSTREAM, ioe);
        }
    }

    /**
     * Execute a group of sql statements, usually used to initialize tables and indexes
     * 
     * @param name
     *            name of group
     * @param templateParameters
     *            arguments to the statement templates
     * @param connection
     *            connection on which to run the SQL statements
     * @throws SQLException
     * @throws RdbException
     */
    public void runSQLGroup(String name, String[] templateParameters, Connection connection) throws SQLException, RdbException {
        String[] sql = getSQL(name, templateParameters).split(";;");
        int i = 0;
        Statement cs = connection.createStatement();
        try {
            for (i = 0; i < sql.length; i++) {
                sql[i] = new String(sql[i].trim());
                if (sql[i].trim().length() == 0)
                    continue;
                if (log.isTraceEnabled()) {
                    log.trace(LogUtils.RDB_MARKER, "Executing SQL:{} ", sql[i]);
                }
                cs.execute(sql[i]);

            }
        } catch (SQLException e) {
            log.debug(LogUtils.RDB_MARKER, "Exception calling: " + sql[i], e);
            throw e;
        } finally {
            if (cs != null)
                cs.close();
        }
    }

    /**
     * Execute a group of sql statements, usually used to initialize tables and indexes
     * 
     * @param name
     *            name of group
     * @param templateParameters
     *            arguments to the statement templates
     * @param connection
     *            connection on which to run the SQL statements
     * @throws SQLException
     * @throws RdbException
     */
    public void runSQLGroupCommitIndividual(String name, String[] templateParameters, Connection connection) throws SQLException, RdbException {
        String[] sql = getSQL(name, templateParameters).split(";;");
        int i = 0;
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);

        Statement cs = connection.createStatement();
        try {
            for (i = 0; i < sql.length; i++) {
                sql[i] = new String(sql[i].trim());
                if (sql[i].trim().length() == 0)
                    continue;
                if (log.isTraceEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "Executing SQL:{} ", sql[i]);
                }
                cs.execute(sql[i]);
                connection.commit();
            }
        } catch (SQLException e) {
            log.debug(LogUtils.RDB_MARKER, "Exception calling: " + sql[i], e);
            throw e;
        } finally {
            if (cs != null)
                cs.close();
            connection.setAutoCommit(autoCommit);
        }
    }

    /**
     * Create a preparedStatement for the given SQL text
     * 
     * @param sql
     *            text of statement
     * @param connection
     *            connection on which to run the SQL statements
     * @return a preparedStatement for the given sql
     * @throws SQLException
     *             if there was an exception creating the prepared statement
     */
    public PreparedStatement prepareStatement(String sql, Connection connection) throws SQLException {
        log.trace(LogUtils.RDB_MARKER, "Prepared callable SQL:{} ", sql);
        return connection.prepareStatement(sql);
    }

    /**
     * Create a preparedStatement with the given name
     * 
     * @param name
     *            name of prepared statement
     * @param templateParameters
     *            parameters to the statement template
     * @param connection
     *            connection on which to run the SQL statements
     * @return Prepared statement for the given name and parameters
     * @throws SQLException
     * @throws RdbException
     *             {@link ExceptionConstants.RDB#NO_STMT_WITH_NAME} if there was a problem locating the sql for named operation
     */
    public PreparedStatement prepareStatement(String name, String[] templateParameters, Connection connection) throws SQLException, RdbException {
        String sql = getSQL(name, templateParameters);
        log.trace(LogUtils.RDB_MARKER, sql);
        return connection.prepareStatement(sql);
    }

    /**
     * Get a preparedStatement with the given name. Use cached version if available, or create a new version.
     * 
     * @param name
     *            name of prepared statement
     * @param templateParameters
     *            parameters to the statement template
     * @param connection
     *            connection on which to run the SQL statements
     * 
     * @return Prepared statement for the given name and parameters
     * @throws SQLException
     * @throws RdbException
     *             {@link ExceptionConstants.RDB#NO_STMT_WITH_NAME} if there was a problem locating the sql for named operation
     */
    public PreparedStatement getPreparedSQLStatement(String name, String[] templateParameters, Connection connection) throws SQLException, RdbException {
        PreparedStatement ps = null;
        String sql = getSQL(name, templateParameters);
        ps = (sql.startsWith("call")) ? connection.prepareCall("{" + sql + "}") : connection.prepareStatement(sql);
        if (log.isTraceEnabled())
            log.trace(LogUtils.RDB_MARKER, "Prepared: {}", sql);

        ps.clearParameters();
        return ps;
    }

    /**
     * Get a preparedStatement with the given name. Use cached version if available, or create a new version.
     * 
     * @param name
     *            name of prepared statement
     * @param templateParameters
     *            parameters to the statement template
     * @param connection
     *            connection on which to run the SQL statements
     * 
     * @return Prepared statement for the given name and parameters
     * @throws SQLException
     * @throws RdbException
     *             {@link ExceptionConstants.RDB#NO_STMT_WITH_NAME} if there was a problem locating the sql for named operation
     */
    public PreparedStatement getPreparedSQLStatementWithGeneratedIDS(String name, String[] templateParameters, Connection connection) throws SQLException, RdbException {
        PreparedStatement ps = null;
        String sql = getSQL(name, templateParameters);
        ps = (sql.endsWith("RETURNING ID")) ? connection.prepareStatement(sql) : connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        if (log.isTraceEnabled())
            log.trace(LogUtils.RDB_MARKER, "Prepared: {}", sql);

        ps.clearParameters();
        return ps;
    }

    /**
     * Get a {@link PreparedStatement} for the operation defined by the given name
     * 
     * @param name
     *            name of the prepared statement to create
     * @param connection
     *            connection to the database
     * @return a {@link PreparedStatement} for the operation defined by the given name
     * @throws SQLException
     * 
     * @throws RdbException
     *             {@link ExceptionConstants.RDB#NO_STMT_WITH_NAME} if there was a problem locating the sql for named operation
     */
    public PreparedStatement getPreparedSQLStatement(String name, Connection connection) throws SQLException, RdbException {
        return getPreparedSQLStatement(name, new String[0], connection);
    }

    private static final String[] replaceParameterRegexStrings = new String[26];
    static {
        for (int i = 0; i < replaceParameterRegexStrings.length; i++) {
            replaceParameterRegexStrings[i] = "\\$\\{\\s*" + ((char) ('a' + i)) + "\\s*\\}";
        }
    }

    /**
     * Get the sql text for the given prepared statement
     * 
     * @param name
     *            name of prepared statement
     * @return sql text for the given prepared statement
     */
    public String getSqlString(String name) {
        return (String) sqlOperations.get(name);
    }

    /**
     * Get the sql text with template parameters replaced for the given prepared statement
     * 
     * @param name
     *            name of prepared statement
     * @param templateParameters
     *            template values to replace
     * @return sql text for the given prepared statement
     * @throws RdbException
     */
    public String getSQL(String name, String[] templateParameters) throws RdbException {
        String sql = (String) sqlOperations.get(name);
        if (sql == null) {
            throw new RdbException(ExceptionConstants.RDB.NO_STMT_WITH_NAME, name);
        }
        if (!sql.startsWith("call")) {
            sql = MessageFormat.format(sql, (Object[]) templateParameters);
        }
        if (log.isTraceEnabled()) {
            log.trace(LogUtils.RDB_MARKER, "Generated SQL: {}", sql);
        }
        return sql;
    }

    /**
     * Retrieve data from file which will be used to preload some table
     * 
     * @param inputStream
     *            inputStream containing data
     * @return Iterator over the lines of text in the file
     */
    public ClosableIterator<String> listPreloadData(InputStream inputStream) {
        try {
            return new FileLineIterator(new InputStreamReader(inputStream, Constants.byteEncoding));
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("This exception should never occur since UTF-8 is always supported");
        }
    }

}
