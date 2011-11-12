/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 13, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jdbc.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.ontologies.system.RDBComponent;
import org.openanzo.ontologies.system.RDBConfiguration;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class CoreDBConfiguration {

    private static final Properties DB2ServerProps                = new Properties();
    static {
        configureDB2(DB2ServerProps, false);
    }

    private static final Properties DB2Props                      = new Properties();
    static {
        configureDB2(DB2Props, true);
    }

    private static final Properties OracleServerProps             = new Properties();
    static {
        configureOracle(OracleServerProps, false);
    }

    private static final Properties OracleProps                   = new Properties();
    static {
        configureOracle(OracleProps, true);
    }

    private static final Properties PostgresServerProps           = new Properties();
    static {
        configurePostgres(PostgresServerProps, false);
    }

    private static final Properties PostgresProps                 = new Properties();
    static {
        configurePostgres(PostgresProps, true);
    }

    private static final Properties HSQLServerProps               = new Properties();
    static {
        configureHSQL(HSQLServerProps, false);
    }

    private static final Properties HSQLProps                     = new Properties();
    static {
        configureHSQL(HSQLProps, true);
    }

    private static final Properties H2Props                       = new Properties();
    static {
        configureH2(H2Props, true);
    }

    private static final Properties H2ServerProps                 = new Properties();
    static {
        configureH2(H2ServerProps, false);
    }

    private static final Properties MSSQLProps                    = new Properties();
    static {
        configureMSSQL(MSSQLProps, true);
    }

    private static final Properties MSSQLServerProps              = new Properties();
    static {
        configureMSSQL(MSSQLServerProps, false);
    }

    /**
     * Prefix string added to the start of the jdbc URL.
     */
    private String                  url                           = null;

    /**
     * Prefix string added to the start of the jdbc URL.
     */
    private String                  url_prefix                    = null;

    /**
     * Postfix string added to the end of the jdbc URL.
     */
    private String                  url_postfix                   = null;

    /**
     * JDBC driver name.
     */
    private String                  driver                        = null;

    /**
     * UserId for connection to database.
     */
    private String                  user                          = null;

    /**
     * Password for connection to database.
     */
    private String                  password                      = null;

    /**
     * Does the database require unique temporary table names within a query
     */
    private boolean                 requiresUniqueTempNames       = false;

    /**
     * Local directory path where database will be loaded from.
     */
    private String                  file_location                 = null;

    private String                  containerName                 = "ANZO";

    private boolean                 clear                         = false;

    private String                  sql_filename                  = null;

    private String                  quote_char                    = null;

    private int                     max_tablename_length          = 0;

    private boolean                 limit_transaction_size        = true;

    private boolean                 use_temp_inserts              = false;

    private boolean                 use_temp_find                 = false;

    private boolean                 supports_optional_joins       = false;

    private boolean                 supports_sequences            = false;

    private boolean                 supports_fullouter_joins      = false;

    private boolean                 supports_with_clause          = false;

    private int                     max_index_key_length          = 0;

    private int                     max_long_object_length        = 0;

    private boolean                 uses_uppercase                = false;

    private boolean                 uses_uppercase_temptables     = false;

    private String                  sessionPrefix                 = "";

    private boolean                 forceTempTablePurge           = false;

    private boolean                 forceTempTableCreation        = false;

    private String                  indexSuffix                   = "";

    private String                  optimizationString            = "";

    private String                  tableCreateExtras             = "";

    private String                  textFieldExtras               = "";

    private boolean                 supportsTableLocks            = false;

    private String                  tableLocksExtras              = "";

    private boolean                 supportsTableUnLocks          = false;

    private String                  smallInt                      = "SMALLINT";

    private String                  bigInt                        = "BIGINT";

    private String                  varChar                       = "VARCHAR";

    private String                  blob                          = "VARCHAR";

    private boolean                 supportsIsolation             = true;

    private boolean                 supportsIdentity              = true;

    private String                  literalTrue                   = "true";

    private String                  literalFalse                  = "false";

    private String                  dropExtras                    = "";

    private int                     nodeCacheSize                 = 25000;

    private boolean                 requiresTempTablespace        = false;

    private String                  generatedIdString             = "";

    private boolean                 supportsIndividualBatchUpdate = false;

    private String                  canonicalTable                = null;

    private boolean                 useHardReset                  = false;

    private boolean                 supportsLimitOffset           = false;

    private String[]                initializationFiles           = null;

    private String[]                initParams                    = null;

    private String[]                connectionSetupFunctions      = null;

    private String[]                connectionTeardownFunctions   = null;

    private String                  validationQuery               = null;

    /**
     * Get the init params passed to prepared statements as the template params
     * 
     * @return the init params passed to prepared statements as the template params
     */
    public String[] getInitParams() {
        if (initParams == null) {
            initParams = new String[] { getContainerName(), getIndexSuffix(), getTableCreateExtras(), getTextFieldExtras(), getMaxLongObjectLength() + "", getSmallInt(), getBigInt(), getVarChar(), getBlob(), getGeneratedIdString() };
        }
        return initParams;
    }

    /**
     * Get the init params passed to prepared statements as the template params
     * 
     * @param containerName
     *            name of non default container
     * @return the init params passed to prepared statements as the template params
     */
    public String[] getInitParams(String containerName) {
        return new String[] { containerName, getIndexSuffix(), getTableCreateExtras(), getTextFieldExtras(), getMaxLongObjectLength() + "", getSmallInt(), getBigInt(), getVarChar(), getBlob(), getGeneratedIdString() };
    }

    /**
     * @return the initializationFiles
     */
    public String[] getInitializationFiles() {
        return initializationFiles;
    }

    /**
     * @param initializationFiles
     *            the initializationFiles to set
     */
    public void setInitializationFiles(String[] initializationFiles) {
        this.initializationFiles = initializationFiles;
    }

    /**
     * Core configuration properties for jdbc connections
     */
    public CoreDBConfiguration() {
        super();
    }

    /**
     * Get the clear on startup flag
     * 
     * @return the clear on startup flag
     */
    public boolean getClearOnStartup() {
        return clear;
    }

    /**
     * Set the clear on startup flag
     * 
     * @param clear
     *            true if the database is should be cleared on start
     * 
     */
    public void setClearOnStartup(boolean clear) {
        this.clear = clear;
    }

    /**
     * Get the driver's class name
     * 
     * @return the driver's class name
     */
    public String getDriverClassName() {
        return driver;
    }

    /**
     * Set the jdbc driver's class name
     * 
     * @param driver
     *            the jdbc driver's class name
     */
    public void setDriverClassName(String driver) {
        this.driver = driver;
    }

    /**
     * Get the file_location for file based rdbs
     * 
     * @return the file_location for file based rdbs
     */
    public String getFileLocation() {
        return file_location;
    }

    /**
     * Set the file location for file based rdbs
     * 
     * @param file_location
     *            the file_location to set
     */
    public void setFileLocation(String file_location) {
        this.file_location = file_location;
    }

    /**
     * Get the max length an index key can be
     * 
     * @return the max length an index key can be
     */
    public int getMaxIndexKeyLength() {
        return max_index_key_length;
    }

    /**
     * Set the max length an index key can be
     * 
     * @param max_index_key_length
     *            the max_index_key_length to set
     */
    public void setMaxIndexKeyLength(int max_index_key_length) {
        this.max_index_key_length = max_index_key_length;
    }

    /**
     * Get the max length of a long object
     * 
     * @return the max length of a long object
     */
    public int getMaxLongObjectLength() {
        return max_long_object_length;
    }

    /**
     * Set the max length of a long object
     * 
     * @param max_long_object_length
     *            the max_long_object_length to set
     */
    public void setMaxLongObjectLength(int max_long_object_length) {
        this.max_long_object_length = max_long_object_length;
    }

    /**
     * Get the max table name length
     * 
     * @return the max table name length
     */
    public int getMaxTablenameLength() {
        return max_tablename_length;
    }

    /**
     * Set the max table name length
     * 
     * @param max_tablename_length
     *            the max tablename length to set
     */
    public void setMaxTablenameLength(int max_tablename_length) {
        this.max_tablename_length = max_tablename_length;
    }

    /**
     * Get the password
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password
     * 
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the quote char
     * 
     * @return the quote char
     */
    public String getQuoteChar() {
        return quote_char;
    }

    /**
     * Set the quote char
     * 
     * @param quote_char
     *            the quote char to set
     */
    public void setQuoteChar(String quote_char) {
        this.quote_char = quote_char;
    }

    /**
     * Get the sql filename
     * 
     * @return the sql filename
     */
    public String getSqlFilename() {
        return sql_filename;
    }

    /**
     * Set the sql filename
     * 
     * @param sql_filename
     *            the sql filename to set
     */
    public void setSqlFilename(String sql_filename) {
        this.sql_filename = sql_filename;
    }

    /**
     * Determine if the db supports full outer joins
     * 
     * @return true if the db supports full outer joins
     */
    public boolean getSupportsFullouterJoins() {
        return supports_fullouter_joins;
    }

    /**
     * Set if the db supports full outer joins
     * 
     * @param supports_fullouter_joins
     *            supports full outer joins
     */
    public void setSupportsFullouterJoins(boolean supports_fullouter_joins) {
        this.supports_fullouter_joins = supports_fullouter_joins;
    }

    /**
     * Determine if the db supports sequences
     * 
     * @return true if the db supports sequences
     */
    public boolean getSupportsSequences() {
        return supports_sequences;
    }

    /**
     * Set if the database supports sequences
     * 
     * @param supports_sequences
     *            flag if the database supports sequences
     */
    public void setSupportsSequences(boolean supports_sequences) {
        this.supports_sequences = supports_sequences;
    }

    /**
     * Determine if the db should use temporary tables during find operations
     * 
     * @return true if the db should use temporary tables during find operations
     */
    public boolean getSupportsTempOnFind() {
        return use_temp_find;
    }

    /**
     * Set if the database should use temporary tables during find operations
     * 
     * @param use_temp_find
     *            if the database should use temporary tables during find operations
     */
    public void setSupportsTempOnFind(boolean use_temp_find) {
        this.use_temp_find = use_temp_find;
    }

    /**
     * Determine if the db should use temporary tables during insert operations
     * 
     * @return true if the db should use temporary tables during insert operations
     */
    public boolean getSupportsTempForInsert() {
        return use_temp_inserts;
    }

    /**
     * Set if the database should use temporary tables during find operations
     * 
     * @param use_temp_inserts
     *            db should use temporary tables during find operations
     */
    public void setSupportsTempForInsert(boolean use_temp_inserts) {
        this.use_temp_inserts = use_temp_inserts;
    }

    /**
     * Determine if the database supports the WITH clause
     * 
     * @return true if the database supports the WITH clause
     */
    public boolean getSupportsWithClause() {
        return supports_with_clause;
    }

    /**
     * Set if the database supports the WITH clause
     * 
     * @param supports_with_clause
     *            db supports the WITH clause
     */
    public void setSupportsWithClause(boolean supports_with_clause) {
        this.supports_with_clause = supports_with_clause;
    }

    /**
     * Set the jdbc URL
     * 
     * @param url
     *            the jdbc url
     */
    public void setJBDCUrl(String url) {
        this.url = url;
    }

    /**
     * Get the string to add to the end of all jdbc urls
     * 
     * @return the string to add to the end of all jdbc urls
     */
    public String getUrlPostfix() {
        return url_postfix;
    }

    /**
     * Set the string to add to the end of all jdbc urls
     * 
     * @param url_postfix
     *            the string to add to the end of all jdbc urls
     */
    public void setUrlPostfix(String url_postfix) {
        this.url_postfix = url_postfix;
    }

    /**
     * Get the string to add to the start of all jdbc urls
     * 
     * @return the string to add to the start of all jdbc urls
     */
    public String getUrlPrefix() {
        return url_prefix;
    }

    /**
     * Set the string to add to the end of all jdbc urls
     * 
     * @param url_prefix
     *            the string to add to the end of all jdbc urls
     */
    public void setUrlPrefix(String url_prefix) {
        this.url_prefix = url_prefix;
    }

    /**
     * Get the database user
     * 
     * @return the database user
     */
    public String getUser() {
        return user;
    }

    /**
     * Set the database user
     * 
     * @param user
     *            the username
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Determine if the database uses all uppercase table and column names
     * 
     * @return true if the database uses all uppercase table and column names
     */
    public boolean getUsesUppercase() {
        return uses_uppercase;
    }

    /**
     * Set if the database uses all uppercase table and column names
     * 
     * @param uses_uppercase
     *            if the database uses all uppercase table and column names
     */
    public void setUsesUppercase(boolean uses_uppercase) {
        this.uses_uppercase = uses_uppercase;
    }

    /**
     * Determine if the database uses all uppercase temporary table and column names
     * 
     * @return true if the database uses all uppercase temporary table and column names
     */
    public boolean getUsesUppercaseTempTables() {
        return uses_uppercase_temptables;
    }

    /**
     * Set if the database uses all uppercase temporary table and column names
     * 
     * @param uses_uppercase_temptables
     *            if the database uses all uppercase temporary table and column names
     */
    public void setUsesUppercaseTempTables(boolean uses_uppercase_temptables) {
        this.uses_uppercase_temptables = uses_uppercase_temptables;
    }

    /**
     * Get the JDBC url for connections
     * 
     * @return the JDBC url for connections
     */
    public String getJdbcUrl() {
        String jdbcUrl = url;
        if (jdbcUrl == null) {
            jdbcUrl = ((url_prefix != null) ? url_prefix : "") + ((file_location != null) ? file_location : "") + ((containerName != null) ? "/" + containerName : "") + ((url_postfix != null) ? url_postfix : "");
        }
        return jdbcUrl;
    }

    /**
     * Get the sessionPrefix for temporary tables
     * 
     * @return the sessionPrefix for temporary tables
     */
    public String getSessionPrefix() {
        return sessionPrefix;
    }

    /**
     * Set the sessionPrefix for temporary tables
     * 
     * @param sessionPrefix
     *            the sessionPrefix for temporary tables
     */
    public void setSessionPrefix(String sessionPrefix) {
        this.sessionPrefix = sessionPrefix;
    }

    /**
     * Determine if connection needs to force a clear on temporary tables
     * 
     * @return true if connection needs to force a clear on temporary tables
     */
    public boolean getForceTempTablePurge() {
        return forceTempTablePurge;
    }

    /**
     * Set if connection needs to force a clear on temporary tables
     * 
     * @param forceTempTablePurge
     *            if connection needs to force a clear on temporary tables
     */
    public void setForceTempTablePurge(boolean forceTempTablePurge) {
        this.forceTempTablePurge = forceTempTablePurge;
    }

    /**
     * Get the string to add to the end of index creation
     * 
     * @return the string to add to the end of index creation
     */
    public String getIndexSuffix() {
        return indexSuffix;
    }

    /**
     * Get the String containing any extra sql text to be added to the end of a query
     * 
     * @return the String containing any extra sql text to be added to the end of a query
     */
    public String getOptimizationString() {
        return optimizationString;
    }

    /**
     * Set the String containing any extra sql text to be added to the end of a query
     * 
     * @param optimizationString
     *            the String containing any extra sql text to be added to the end of a query
     */
    public void setOptimizationString(String optimizationString) {
        this.optimizationString = optimizationString;
    }

    /**
     * Get the String containing any extra sql text to be added to the end of a create table call
     * 
     * @return the String containing any extra sql text to be added to the end of a create table call
     */
    public String getTableCreateExtras() {
        return tableCreateExtras;
    }

    /**
     * Set the String containing any extra sql text to be added to the end of a create table call
     * 
     * @param tableCreateExtras
     *            the String containing any extra sql text to be added to the end of a create table call
     */
    public void setTableCreateExtras(String tableCreateExtras) {
        this.tableCreateExtras = tableCreateExtras;
    }

    /**
     * Get the String containing any extra sql needed as part of a text column definition
     * 
     * @return the String containing any extra sql needed as part of a text column definition
     */
    public String getTextFieldExtras() {
        return textFieldExtras;
    }

    /**
     * Set the String containing any extra sql needed as part of a text column definition
     * 
     * @param textFieldExtras
     *            the String containing any extra sql needed as part of a text column definition
     */
    public void setTextFieldExtras(String textFieldExtras) {
        this.textFieldExtras = textFieldExtras;
    }

    /**
     * Determine if the database supports table locks
     * 
     * @return the true if the database supports table locks
     */
    public boolean getSupportsTableLocks() {
        return supportsTableLocks;
    }

    /**
     * Set if database supports table locks
     * 
     * @param supportsTableLocks
     *            if database supports table locks
     */
    public void setSupportsTableLocks(boolean supportsTableLocks) {
        this.supportsTableLocks = supportsTableLocks;
    }

    /**
     * Determine if the database supports table unlocks
     * 
     * @return true if database supports table unlocks
     */
    public boolean getSupportsTableUnLocks() {
        return supportsTableUnLocks;
    }

    /**
     * Set if database supports table unlocks
     * 
     * @param supportsTableUnLocks
     *            if database supports table unlocks
     */
    public void setSupportsTableUnLocks(boolean supportsTableUnLocks) {
        this.supportsTableUnLocks = supportsTableUnLocks;
    }

    /**
     * Get the string needed at the end of a table lock call
     * 
     * @return the string needed at the end of a table lock call
     */
    public String getTableLocksExtras() {
        return tableLocksExtras;
    }

    /**
     * Set the String needed at the end of a table lock call
     * 
     * @param tableLocksExtras
     *            the String needed at the end of a table lock call
     */
    public void setTableLocksExtras(String tableLocksExtras) {
        this.tableLocksExtras = tableLocksExtras;
    }

    /**
     * Get the SQL String for SmallInt declaration
     * 
     * @return the SQL String for SmallInt declaration
     */
    public String getSmallInt() {
        return smallInt;
    }

    /**
     * Get the SQL String for BigInt declaration
     * 
     * @return the SQL String for BigInt declaration
     */
    public String getBigInt() {
        return bigInt;
    }

    /**
     * Get the SQL String for VarChar declaration
     * 
     * @return the SQL String for VarChar declaration
     */
    public String getVarChar() {
        return varChar;
    }

    /**
     * Determine if the database supports transaction isolation modes
     * 
     * @return true if the database supports transaction isolation modes
     */
    public boolean getSupportsIsolation() {
        return supportsIsolation;
    }

    /**
     * Determine if the database requires unique temporary table names
     * 
     * @return true if the database requires unique temporary table names
     */
    public boolean getRequiresUniqueTempNames() {
        return requiresUniqueTempNames;
    }

    /**
     * Set if the database requires unique temporary table names
     * 
     * @param uniqueTempNames
     *            if the database requires unique temporary table names
     */
    public void setRequiresUniqueTempNames(boolean uniqueTempNames) {
        this.requiresUniqueTempNames = uniqueTempNames;
    }

    /**
     * Get the string that the database uses to represent TRUE
     * 
     * @return the string that the database uses to represent TRUE
     */
    public String getLiteralTrue() {
        return literalTrue;
    }

    /**
     * Set the string that the database uses to represent TRUE
     * 
     * @param literalTrue
     *            the string that the database uses to represent TRUE
     */
    public void setLiteralTrue(String literalTrue) {
        this.literalTrue = literalTrue;
    }

    /**
     * Get the string that the database uses to represent FALSE
     * 
     * @return the string that the database uses to represent FALSE
     */
    public String getLiteralFalse() {
        return literalFalse;
    }

    /**
     * Set the string that the database uses to represent FALSE
     * 
     * @param literalFalse
     *            the string that the database uses to represent FALSE
     */
    public void setLiteralFalse(String literalFalse) {
        this.literalFalse = literalFalse;
    }

    /**
     * Determine if the database requires a forced creation of temporary tables
     * 
     * @return if the database requires a forced creation of temporary tables
     */
    public boolean getForceTempCreation() {
        return forceTempTableCreation;
    }

    /**
     * Set if the database requires a forced creation of temporary tables
     * 
     * @param forceTempTableCreation
     *            if the database requires a forced creation of temporary tables
     */
    public void setForceTempCreation(boolean forceTempTableCreation) {
        this.forceTempTableCreation = forceTempTableCreation;
    }

    /**
     * Get the SQL string needed by this database at the end of the standard drop table call
     * 
     * @return the SQL string needed by this database at the end of the standard drop table call
     */
    public String getDropExtras() {
        return dropExtras;
    }

    /**
     * Set the SQL string needed by this database at the end of the standard drop table call
     * 
     * @param dropExtras
     *            the SQL string needed by this database at the end of the standard drop table call
     */
    public void setDropExtras(String dropExtras) {
        this.dropExtras = dropExtras;
    }

    /**
     * Return a temporary table name, with an appended number string if the table requires unique temporary table names
     * 
     * @param name
     *            name of table
     * @param index
     *            this occurrence of the temporary table name in the query
     * @return a temporary table name, with an appended number string if the table requires unique temporary table names
     */
    public String getUniqueTempName(String name, int index) {
        if (!getRequiresUniqueTempNames() || index == 0) {
            return name;
        }
        return name + index;
    }

    /**
     * Get the size of the caches for the ID->Node and Node->ID maps
     * 
     * @return the nodeCacheSize the size of the caches for the ID->Node and Node->ID maps
     */
    public int getNodeCacheSize() {
        return nodeCacheSize;
    }

    /**
     * Set the size of the caches for the ID->Node and Node->ID maps
     * 
     * @param nodeCacheSize
     *            the size of the caches for the ID->Node and Node->ID maps
     */
    public void setNodeCacheSize(int nodeCacheSize) {
        this.nodeCacheSize = nodeCacheSize;
    }

    /**
     * @return the requiresTempTablespace
     */
    public boolean getRequiresTempTablespace() {
        return requiresTempTablespace;
    }

    /**
     * @param requiresTempTablespace
     *            the requiresTempTablespace to set
     */
    public void setRequiresTempTablespace(boolean requiresTempTablespace) {
        this.requiresTempTablespace = requiresTempTablespace;
    }

    /**
     * @return the blob
     */
    public String getBlob() {
        return blob;
    }

    /**
     * @param blob
     *            the blob to set
     */
    public void setBlob(String blob) {
        this.blob = blob;
    }

    /**
     * @return the generatedIdString
     */
    public String getGeneratedIdString() {
        return generatedIdString;
    }

    /**
     * @param generatedIdString
     *            the generatedIdString to set
     */
    public void setGeneratedIdString(String generatedIdString) {
        this.generatedIdString = generatedIdString;
    }

    /**
     * 
     * @return true if db supports individual batch updates
     */
    public boolean getSupportsIndividualBatchUpdate() {
        return supportsIndividualBatchUpdate;
    }

    /**
     * 
     * @param supportsIndividualBatchUpdate
     *            true if db supports individual batch updates
     */
    public void setSupportsIndividualBatchUpdate(boolean supportsIndividualBatchUpdate) {
        this.supportsIndividualBatchUpdate = supportsIndividualBatchUpdate;
    }

    /**
     * @return a canonical table name used to test whether the table structure for this RDB component has been initialized. If null, the connection is checked
     *         for the presence of _any_ table at all.
     */
    public String getCanonicalTable() {
        return this.canonicalTable;
    }

    /**
     * @return the useHardReset
     */
    public boolean getUseHardReset() {
        return useHardReset;
    }

    /**
     * @param useHardReset
     *            the useHardReset to set
     */
    public void setUseHardReset(boolean useHardReset) {
        this.useHardReset = useHardReset;
    }

    /**
     * @return the containerName
     */
    public String getContainerName() {
        return containerName;
    }

    /**
     * @param containerName
     *            the containerName to set
     */
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * @return the connectionSetupFunctions
     */
    public String[] getConnectionSetupFunctions() {
        return connectionSetupFunctions;
    }

    /**
     * @param connectionSetupFunctions
     *            the connectionSetupFunctions to set
     */
    public void setConnectionSetupFunctions(String[] connectionSetupFunctions) {
        this.connectionSetupFunctions = connectionSetupFunctions;
    }

    /**
     * @return the connectionTeardownFunctions
     */
    public String[] getConnectionTeardownFunctions() {
        return connectionTeardownFunctions;
    }

    /**
     * @param connectionTeardownFunctions
     *            the connectionTeardownFunctions to set
     */
    public void setConnectionTeardownFunctions(String[] connectionTeardownFunctions) {
        this.connectionTeardownFunctions = connectionTeardownFunctions;
    }

    /**
     * @return the useLimitOffset
     */
    public boolean getSupportsLimitOffset() {
        return supportsLimitOffset;
    }

    /**
     * @param useLimitOffset
     *            the useLimitOffset to set
     */
    public void setSupportsLimitOffset(boolean useLimitOffset) {
        this.supportsLimitOffset = useLimitOffset;
    }

    /**
     * Create a configuration object based on config properties
     * 
     * @param configProperties
     *            the config properties
     * @return configuration object based on config properties
     * @throws AnzoException
     */
    public static CoreDBConfiguration createConfiguration(Dictionary<? extends Object, ? extends Object> configProperties) throws AnzoException {
        String typeString = RDBDictionary.getType(configProperties);
        Properties properties = null;
        DBTypes type = (typeString != null) ? DBTypes.valueOf(typeString) : null;
        switch (type) {
        case HSQL:
            properties = new Properties(HSQLProps);
            break;
        case ServerHSQL:
            properties = new Properties(HSQLServerProps);
            break;
        case H2:
            properties = new Properties(H2Props);
            break;
        case ServerH2:
            properties = new Properties(H2ServerProps);
            break;
        case DB2:
            properties = new Properties(DB2Props);
            break;
        case ServerDB2:
            properties = new Properties(DB2ServerProps);
            break;
        case Postgres:
            properties = new Properties(PostgresProps);
            break;
        case ServerPostgres:
            properties = new Properties(PostgresServerProps);
            break;
        case Oracle:
            properties = new Properties(OracleProps);
            break;
        case ServerOracle:
            properties = new Properties(OracleServerProps);
            break;
        case MSSQL:
            properties = new Properties(MSSQLProps);
            break;
        case ServerMSSQL:
            properties = new Properties(MSSQLServerProps);
            break;
        }
        if (properties == null) {
            throw new RuntimeException("Unknown configuration properties");
        }
        if (configProperties instanceof Properties) {
            properties.putAll((Properties) configProperties);
        } else {
            for (Enumeration<? extends Object> keys = configProperties.keys(); keys.hasMoreElements();) {
                Object key = keys.nextElement();
                properties.put(key, configProperties.get(key));
            }
        }
        try {
            return initializeProperties(properties, typeString);
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.IO.PROPERTIES_ERROR, e);
        }
    }

    /**
     * Initialize config object based on properties
     * 
     * @param properties
     *            config properties
     * @param typeString
     *            type of database
     * @return the configured CoreDBConfiguration
     * @throws Exception
     */
    public static CoreDBConfiguration initializeProperties(Properties properties, String typeString) throws Exception {
        CoreDBConfiguration dbConfig = new CoreDBConfiguration();

        dbConfig.clear = RDBProperties.getClearOnLoad(properties);
        dbConfig.url = RDBProperties.getUrl(properties);
        dbConfig.user = RDBProperties.getUser(properties);
        dbConfig.password = RDBProperties.getPassword(properties);
        dbConfig.containerName = RDBProperties.getContainerName(properties);
        dbConfig.nodeCacheSize = RDBProperties.getNodeCacheSize(properties, 20000);

        dbConfig.driver = RDBProperties.getDriver(properties);
        dbConfig.file_location = RDBProperties.getFileLocation(properties);
        dbConfig.max_index_key_length = RDBProperties.getMaxIndexKeyLength(properties);
        dbConfig.max_long_object_length = RDBProperties.getMaxLongObjectLength(properties);
        dbConfig.max_tablename_length = RDBProperties.getMaxTablenameLength(properties);
        dbConfig.quote_char = RDBProperties.getQuotechar(properties);
        dbConfig.sessionPrefix = RDBProperties.getSessionPrefix(properties);
        dbConfig.sql_filename = RDBProperties.getSqlfile(properties);
        dbConfig.supports_optional_joins = RDBProperties.getSupportsOptionalJoins(properties);
        dbConfig.supports_fullouter_joins = RDBProperties.getSupportsFullouterJoins(properties);
        dbConfig.supports_sequences = RDBProperties.getSupportsSequences(properties);
        dbConfig.supportsTableLocks = RDBProperties.getSupportsTableLocks(properties);
        dbConfig.supportsTableUnLocks = RDBProperties.getSupportsTableUnLocks(properties);
        dbConfig.supports_with_clause = RDBProperties.getSupportsWithClause(properties);
        dbConfig.supportsLimitOffset = RDBProperties.getSupportsLimitOffset(properties);
        dbConfig.requiresUniqueTempNames = RDBProperties.getUniqueTempNames(properties);
        dbConfig.url_postfix = RDBProperties.getUrlPostfix(properties);
        dbConfig.url_prefix = RDBProperties.getUrlPrefix(properties);
        dbConfig.uses_uppercase = RDBProperties.getUsesUppercase(properties);
        dbConfig.uses_uppercase_temptables = RDBProperties.getUsesUppercaseTempTables(properties);
        dbConfig.use_temp_find = RDBProperties.getUseTempTableFind(properties);
        dbConfig.use_temp_inserts = RDBProperties.getUseTempTableInsert(properties);
        dbConfig.useHardReset = RDBProperties.getUseHardReset(properties);
        dbConfig.tableLocksExtras = RDBProperties.getTableLockSuffix(properties);
        dbConfig.tableCreateExtras = RDBProperties.getTableCreateSuffix(properties);
        dbConfig.forceTempTablePurge = RDBProperties.getForceTempTablePurge(properties);
        dbConfig.forceTempTableCreation = RDBProperties.getForceTempTableCreation(properties);
        dbConfig.indexSuffix = RDBProperties.getIndexSuffix(properties);
        dbConfig.optimizationString = RDBProperties.getSingleRowOptimizationString(properties);
        dbConfig.textFieldExtras = RDBProperties.getTextFieldSuffix(properties);
        dbConfig.smallInt = RDBProperties.getSmallInt(properties);
        dbConfig.bigInt = RDBProperties.getBigInt(properties);
        dbConfig.varChar = RDBProperties.getVarChar(properties);
        dbConfig.blob = RDBProperties.getBlob(properties);
        dbConfig.supportsIsolation = RDBProperties.getSupportsIsolation(properties);
        dbConfig.dropExtras = RDBProperties.getDropTableSuffix(properties);
        dbConfig.requiresTempTablespace = RDBProperties.getRequiresTempTablespace(properties);
        dbConfig.generatedIdString = RDBProperties.getGeneratedIdString(properties);
        dbConfig.supportsIndividualBatchUpdate = RDBProperties.getSupportsIndividualBatchUpdates(properties);
        dbConfig.canonicalTable = RDBProperties.getCanonicalTableName(properties);
        dbConfig.limit_transaction_size = RDBProperties.getLimitTransactionSize(properties);
        dbConfig.validationQuery = RDBProperties.getValidationQuery(properties);
        String initFiles = RDBProperties.getInitializationFiles(properties);
        if (initFiles != null) {
            ArrayList<String> initFileSet = new ArrayList<String>();
            StringTokenizer st = new StringTokenizer(initFiles, ",");
            while (st.hasMoreTokens()) {
                initFileSet.add(st.nextToken());
            }
            dbConfig.initializationFiles = initFileSet.toArray(new String[0]);
        }
        dbConfig.supportsIdentity = RDBProperties.getSupportsIdentity(properties);
        return dbConfig;
    }

    /**
     * Augment config properties for db2
     * 
     * @param configProperties
     *            configuration properties to
     * @param client
     *            true if this is for local persistence, false if for server
     */
    @SuppressWarnings("unchecked")
    public static void configureDB2(Dictionary configProperties, boolean client) {
        RDBDictionary.setMaxLongObjectLength(configProperties, 512);
        //RDBDictionary.setMaxLongObjectLength(configProperties, 256);
        RDBDictionary.setMaxTablenameLength(configProperties, 64);
        RDBDictionary.setSessionPrefix(configProperties, "SESSION.");
        RDBDictionary.setSupportsOptionalJoins(configProperties, true);
        RDBDictionary.setSupportsFullouterJoins(configProperties, true);
        RDBDictionary.setSupportsSequences(configProperties, true);
        RDBDictionary.setSupportsTableLocks(configProperties, true);
        RDBDictionary.setSupportsTableUnLocks(configProperties, false);
        RDBDictionary.setSupportsWithClause(configProperties, true);
        RDBDictionary.setUseTempTableFind(configProperties, true);
        RDBDictionary.setUseTempTableInsert(configProperties, true);
        RDBDictionary.setUniqueTempNames(configProperties, false);
        RDBDictionary.setUsesUppercase(configProperties, true);
        RDBDictionary.setUsesUppercaseTempTables(configProperties, true);
        RDBDictionary.setSupportsLimitOffset(configProperties, false);
        RDBDictionary.setDriver(configProperties, "com.ibm.db2.jcc.DB2Driver");
        RDBDictionary.setQuotechar(configProperties, "'");
        RDBDictionary.setLimitTransactionSize(configProperties, true);
        if (client) {
            RDBDictionary.setSqlfile(configProperties, "etc/DB2_nc.sql");
        } else {
            RDBDictionary.setContainerName(configProperties, "ANZO");
            RDBDictionary.setSqlfile(configProperties, "etc/ServerDB2.sql");
        }
        if (client) {
            RDBDictionary.setType(configProperties, "DB2");
        } else {
            RDBDictionary.setType(configProperties, "ServerDB2");
        }
        RDBDictionary.setBigInt(configProperties, "BIGINT");
        RDBDictionary.setDropTableSuffix(configProperties, "");
        RDBDictionary.setForceTempTablePurge(configProperties, false);
        RDBDictionary.setForceTempTableCreation(configProperties, false);
        RDBDictionary.setIndexSuffix(configProperties, " ALLOW REVERSE SCANS");
        RDBDictionary.setSingleRowOptimizationString(configProperties, " FOR READ ONLY OPTIMIZE FOR 1 ROW");
        RDBDictionary.setSmallInt(configProperties, "SMALLINT");
        RDBDictionary.setVarChar(configProperties, "VARCHAR");
        RDBDictionary.setBlob(configProperties, "CLOB(1G)");
        RDBDictionary.setSupportsIsolation(configProperties, true);
        RDBDictionary.setSupportsIndividualBatchUpdates(configProperties, true);
        RDBDictionary.setTableCreateSuffix(configProperties, "");
        RDBDictionary.setTableLockSuffix(configProperties, " IN EXCLUSIVE MODE");
        RDBDictionary.setTextFieldSuffix(configProperties, "");
        RDBDictionary.setGeneratedIdString(configProperties, "BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 CACHE 10000)");
        RDBDictionary.setRequiresTempTablespace(configProperties, true);
        RDBDictionary.setSupportsIdentity(configProperties, true);
        RDBDictionary.setValidationQuery(configProperties, "VALUES(1)");
    }

    /**
     * Augment config properties for MSSQL
     * 
     * @param configProperties
     *            configuration properties to
     * @param client
     *            true if this is for local persistence, false if for server
     */
    @SuppressWarnings("unchecked")
    public static void configureMSSQL(Dictionary configProperties, boolean client) {
        RDBDictionary.setMaxLongObjectLength(configProperties, 256);
        RDBDictionary.setMaxTablenameLength(configProperties, 64);
        RDBDictionary.setSessionPrefix(configProperties, "#");
        RDBDictionary.setSupportsOptionalJoins(configProperties, true);
        RDBDictionary.setSupportsFullouterJoins(configProperties, true);
        RDBDictionary.setSupportsSequences(configProperties, false);
        RDBDictionary.setSupportsTableLocks(configProperties, false);
        RDBDictionary.setSupportsTableUnLocks(configProperties, false);
        RDBDictionary.setSupportsWithClause(configProperties, true);
        RDBDictionary.setUseTempTableFind(configProperties, true);
        RDBDictionary.setUseTempTableInsert(configProperties, true);
        RDBDictionary.setUniqueTempNames(configProperties, false);
        RDBDictionary.setUsesUppercase(configProperties, true);
        RDBDictionary.setUsesUppercaseTempTables(configProperties, true);
        RDBDictionary.setSupportsLimitOffset(configProperties, false);
        RDBDictionary.setDriver(configProperties, "net.sourceforge.jtds.jdbc.Driver");
        RDBDictionary.setQuotechar(configProperties, "'");
        RDBDictionary.setLimitTransactionSize(configProperties, true);
        if (client) {
            RDBDictionary.setSqlfile(configProperties, "etc/MSSQL_nc.sql");
        } else {
            RDBDictionary.setContainerName(configProperties, "ANZO");
            RDBDictionary.setSqlfile(configProperties, "etc/ServerMSSQL.sql");
        }
        if (client) {
            RDBDictionary.setType(configProperties, "MSSQL");
        } else {
            RDBDictionary.setType(configProperties, "ServerMSSQL");
        }
        RDBDictionary.setBigInt(configProperties, "BIGINT");
        RDBDictionary.setDropTableSuffix(configProperties, "");
        RDBDictionary.setForceTempTablePurge(configProperties, true);
        RDBDictionary.setForceTempTableCreation(configProperties, true);
        RDBDictionary.setIndexSuffix(configProperties, "");
        RDBDictionary.setSingleRowOptimizationString(configProperties, "");
        RDBDictionary.setSmallInt(configProperties, "SMALLINT");
        RDBDictionary.setVarChar(configProperties, "NVARCHAR");
        RDBDictionary.setBlob(configProperties, "NVARCHAR(MAX)");
        RDBDictionary.setSupportsIsolation(configProperties, true);
        RDBDictionary.setSupportsIndividualBatchUpdates(configProperties, true);
        RDBDictionary.setTableCreateSuffix(configProperties, "");
        RDBDictionary.setTableLockSuffix(configProperties, " ");
        RDBDictionary.setTextFieldSuffix(configProperties, " COLLATE SQL_Latin1_General_Cp437_BIN");
        RDBDictionary.setGeneratedIdString(configProperties, "BIGINT IDENTITY (1,1)");
        RDBDictionary.setRequiresTempTablespace(configProperties, false);
        RDBDictionary.setSupportsIdentity(configProperties, true);
        RDBDictionary.setValidationQuery(configProperties, "select 1");
    }

    /**
     * Augment config properties for HSQL
     * 
     * @param configProperties
     *            configuration properties to
     * @param client
     *            true if this is for local persistence, false if for server
     */
    @SuppressWarnings("unchecked")
    public static void configureHSQL(Dictionary configProperties, boolean client) {
        RDBDictionary.setMaxLongObjectLength(configProperties, 512);
        RDBDictionary.setMaxTablenameLength(configProperties, 64);
        RDBDictionary.setSessionPrefix(configProperties, "");
        RDBDictionary.setSupportsOptionalJoins(configProperties, true);
        RDBDictionary.setSupportsFullouterJoins(configProperties, false);
        RDBDictionary.setSupportsSequences(configProperties, true);
        RDBDictionary.setSupportsTableLocks(configProperties, false);
        RDBDictionary.setSupportsTableUnLocks(configProperties, false);
        RDBDictionary.setSupportsWithClause(configProperties, false);
        RDBDictionary.setUseTempTableFind(configProperties, true);
        RDBDictionary.setUseTempTableInsert(configProperties, true);
        RDBDictionary.setUniqueTempNames(configProperties, false);
        RDBDictionary.setUsesUppercase(configProperties, true);
        RDBDictionary.setUsesUppercaseTempTables(configProperties, true);
        RDBDictionary.setSupportsLimitOffset(configProperties, true);
        RDBDictionary.setDriver(configProperties, "org.hsqldb.jdbcDriver");
        RDBDictionary.setQuotechar(configProperties, "'");
        RDBDictionary.setLimitTransactionSize(configProperties, false);
        if (client) {
            RDBDictionary.setSqlfile(configProperties, "etc/HSQL_nc.sql");
        } else {
            RDBDictionary.setContainerName(configProperties, "ANZO");
            RDBDictionary.setSqlfile(configProperties, "etc/ServerHSQL.sql");
        }
        if (client) {
            RDBDictionary.setType(configProperties, "HSQL");
        } else {
            RDBDictionary.setType(configProperties, "ServerHSQL");
        }
        RDBDictionary.setBigInt(configProperties, "BIGINT");
        RDBDictionary.setDropTableSuffix(configProperties, "");
        RDBDictionary.setForceTempTablePurge(configProperties, false);
        RDBDictionary.setForceTempTableCreation(configProperties, false);
        RDBDictionary.setIndexSuffix(configProperties, "");
        RDBDictionary.setSingleRowOptimizationString(configProperties, "");
        RDBDictionary.setSmallInt(configProperties, "SMALLINT");
        RDBDictionary.setVarChar(configProperties, "VARCHAR");
        RDBDictionary.setBlob(configProperties, "LONGVARCHAR");
        RDBDictionary.setSupportsIsolation(configProperties, true);
        RDBDictionary.setSupportsIndividualBatchUpdates(configProperties, true);
        RDBDictionary.setTableCreateSuffix(configProperties, "");
        RDBDictionary.setTableLockSuffix(configProperties, "");
        RDBDictionary.setTextFieldSuffix(configProperties, "");
        RDBDictionary.setGeneratedIdString(configProperties, "BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1000, INCREMENT BY 1)");
        RDBDictionary.setRequiresTempTablespace(configProperties, false);
        RDBDictionary.setSupportsIdentity(configProperties, true);
    }

    /**
     * Augment config properties for H2
     * 
     * @param configProperties
     *            configuration properties to
     * @param client
     *            true if this is for local persistence, false if for server
     */
    @SuppressWarnings("unchecked")
    public static void configureH2(Dictionary configProperties, boolean client) {
        RDBDictionary.setMaxLongObjectLength(configProperties, 512);
        RDBDictionary.setMaxTablenameLength(configProperties, 64);
        RDBDictionary.setSessionPrefix(configProperties, "");
        RDBDictionary.setSupportsOptionalJoins(configProperties, false);
        RDBDictionary.setSupportsFullouterJoins(configProperties, false);
        RDBDictionary.setSupportsSequences(configProperties, true);
        RDBDictionary.setSupportsTableLocks(configProperties, false);
        RDBDictionary.setSupportsTableUnLocks(configProperties, false);
        RDBDictionary.setSupportsWithClause(configProperties, false);
        RDBDictionary.setUseTempTableFind(configProperties, true);
        RDBDictionary.setUseTempTableInsert(configProperties, true);
        RDBDictionary.setUniqueTempNames(configProperties, false);
        RDBDictionary.setUsesUppercase(configProperties, true);
        RDBDictionary.setUsesUppercaseTempTables(configProperties, true);
        RDBDictionary.setSupportsLimitOffset(configProperties, true);
        RDBDictionary.setDriver(configProperties, "org.h2.Driver");
        RDBDictionary.setQuotechar(configProperties, "'");
        RDBDictionary.setLimitTransactionSize(configProperties, false);
        if (client) {
            RDBDictionary.setSqlfile(configProperties, "etc/H2_nc.sql");
        } else {
            RDBDictionary.setContainerName(configProperties, "ANZO");
            RDBDictionary.setSqlfile(configProperties, "etc/ServerH2.sql");
        }
        if (client) {
            RDBDictionary.setType(configProperties, "H2");
        } else {
            RDBDictionary.setType(configProperties, "ServerH2");
        }
        RDBDictionary.setBigInt(configProperties, "BIGINT");
        RDBDictionary.setDropTableSuffix(configProperties, "");
        RDBDictionary.setForceTempTablePurge(configProperties, false);
        RDBDictionary.setForceTempTableCreation(configProperties, false);
        RDBDictionary.setIndexSuffix(configProperties, "");
        RDBDictionary.setSingleRowOptimizationString(configProperties, "");
        RDBDictionary.setSmallInt(configProperties, "SMALLINT");
        RDBDictionary.setVarChar(configProperties, "VARCHAR");
        RDBDictionary.setBlob(configProperties, "LONGVARCHAR");
        RDBDictionary.setSupportsIsolation(configProperties, true);
        RDBDictionary.setSupportsIndividualBatchUpdates(configProperties, true);
        RDBDictionary.setTableCreateSuffix(configProperties, "");
        RDBDictionary.setTableLockSuffix(configProperties, "");
        RDBDictionary.setTextFieldSuffix(configProperties, "");
        RDBDictionary.setGeneratedIdString(configProperties, "IDENTITY");
        RDBDictionary.setRequiresTempTablespace(configProperties, false);
        RDBDictionary.setSupportsIdentity(configProperties, true);
    }

    /**
     * Augment config properties for Oracle
     * 
     * @param configProperties
     *            configuration properties to
     * @param client
     *            true if this is for local persistence, false if for server
     */
    @SuppressWarnings("unchecked")
    public static void configureOracle(Dictionary configProperties, boolean client) {
        RDBDictionary.setMaxLongObjectLength(configProperties, 512);
        //RDBDictionary.setMaxLongObjectLength(configProperties, 128);
        RDBDictionary.setMaxTablenameLength(configProperties, 64);
        RDBDictionary.setSessionPrefix(configProperties, "");
        RDBDictionary.setSupportsOptionalJoins(configProperties, true);
        RDBDictionary.setSupportsFullouterJoins(configProperties, true);
        RDBDictionary.setSupportsSequences(configProperties, true);
        RDBDictionary.setSupportsTableLocks(configProperties, true);
        RDBDictionary.setSupportsTableUnLocks(configProperties, false);
        RDBDictionary.setSupportsWithClause(configProperties, false);
        RDBDictionary.setUseTempTableFind(configProperties, true);
        RDBDictionary.setUseTempTableInsert(configProperties, true);
        RDBDictionary.setUniqueTempNames(configProperties, false);
        RDBDictionary.setUsesUppercase(configProperties, true);
        RDBDictionary.setUsesUppercaseTempTables(configProperties, true);
        RDBDictionary.setSupportsLimitOffset(configProperties, false);
        RDBDictionary.setDriver(configProperties, "oracle.jdbc.OracleDriver");
        RDBDictionary.setQuotechar(configProperties, "'");
        RDBDictionary.setLimitTransactionSize(configProperties, true);
        if (client) {
            RDBDictionary.setSqlfile(configProperties, "etc/Oracle_nc.sql");
        } else {
            RDBDictionary.setContainerName(configProperties, "ANZO");
            RDBDictionary.setSqlfile(configProperties, "etc/ServerOracle.sql");
        }
        if (client) {
            RDBDictionary.setType(configProperties, "Oracle");
        } else {
            RDBDictionary.setType(configProperties, "ServerOracle");
        }
        RDBDictionary.setBigInt(configProperties, "NUMBER");
        RDBDictionary.setDropTableSuffix(configProperties, "");
        RDBDictionary.setForceTempTablePurge(configProperties, false);
        RDBDictionary.setForceTempTableCreation(configProperties, false);
        RDBDictionary.setIndexSuffix(configProperties, "");
        RDBDictionary.setSingleRowOptimizationString(configProperties, "");
        RDBDictionary.setSmallInt(configProperties, "NUMBER(1)");
        RDBDictionary.setVarChar(configProperties, "VARCHAR2");
        RDBDictionary.setBlob(configProperties, "NCLOB");
        RDBDictionary.setSupportsIsolation(configProperties, false);
        RDBDictionary.setSupportsIndividualBatchUpdates(configProperties, false);
        RDBDictionary.setTableCreateSuffix(configProperties, " INITRANS 5");
        RDBDictionary.setTableLockSuffix(configProperties, " IN EXCLUSIVE MODE");
        RDBDictionary.setTextFieldSuffix(configProperties, "");
        RDBDictionary.setGeneratedIdString(configProperties, " INTEGER ");
        RDBDictionary.setRequiresTempTablespace(configProperties, false);
        RDBDictionary.setSupportsIdentity(configProperties, false);
        RDBDictionary.setValidationQuery(configProperties, "select 1 from dual");
    }

    /**
     * Augment config properties for Postgres
     * 
     * @param configProperties
     *            configuration properties to
     * @param client
     *            true if this is for local persistence, false if for server
     */
    @SuppressWarnings("unchecked")
    public static void configurePostgres(Dictionary configProperties, boolean client) {
        RDBDictionary.setMaxLongObjectLength(configProperties, 512);
        //RDBDictionary.setMaxLongObjectLength(configProperties, 128);
        RDBDictionary.setMaxTablenameLength(configProperties, 64);
        RDBDictionary.setSessionPrefix(configProperties, "");
        RDBDictionary.setSupportsOptionalJoins(configProperties, true);
        RDBDictionary.setSupportsFullouterJoins(configProperties, false);
        RDBDictionary.setSupportsSequences(configProperties, true);
        RDBDictionary.setSupportsTableLocks(configProperties, true);
        RDBDictionary.setSupportsTableUnLocks(configProperties, false);
        RDBDictionary.setSupportsWithClause(configProperties, false);
        RDBDictionary.setUseTempTableFind(configProperties, true);
        RDBDictionary.setUseTempTableInsert(configProperties, true);
        RDBDictionary.setUniqueTempNames(configProperties, false);
        RDBDictionary.setUsesUppercase(configProperties, false);
        RDBDictionary.setUsesUppercaseTempTables(configProperties, false);
        RDBDictionary.setSupportsLimitOffset(configProperties, true);
        RDBDictionary.setDriver(configProperties, "org.postgresql.Driver");
        RDBDictionary.setQuotechar(configProperties, "'");
        RDBDictionary.setLimitTransactionSize(configProperties, true);
        if (client) {
            RDBDictionary.setSqlfile(configProperties, "etc/Postgres_nc.sql");
        } else {
            RDBDictionary.setContainerName(configProperties, "ANZO");
            RDBDictionary.setSqlfile(configProperties, "etc/ServerPostgres.sql");
        }
        if (client) {
            RDBDictionary.setType(configProperties, "Postgres");
        } else {
            RDBDictionary.setType(configProperties, "ServerPostgres");
        }
        RDBDictionary.setBigInt(configProperties, "BIGINT");
        RDBDictionary.setDropTableSuffix(configProperties, " IF EXISTS");
        RDBDictionary.setForceTempTablePurge(configProperties, false);
        RDBDictionary.setForceTempTableCreation(configProperties, true);
        RDBDictionary.setIndexSuffix(configProperties, "");
        RDBDictionary.setSingleRowOptimizationString(configProperties, "");
        RDBDictionary.setSmallInt(configProperties, "SMALLINT");
        RDBDictionary.setVarChar(configProperties, "VARCHAR");
        RDBDictionary.setBlob(configProperties, "TEXT");
        RDBDictionary.setSupportsIsolation(configProperties, true);
        RDBDictionary.setSupportsIndividualBatchUpdates(configProperties, false);
        RDBDictionary.setTableCreateSuffix(configProperties, "");
        RDBDictionary.setTableLockSuffix(configProperties, " IN EXCLUSIVE MODE");
        RDBDictionary.setTextFieldSuffix(configProperties, "");
        RDBDictionary.setGeneratedIdString(configProperties, "SERIAL");
        RDBDictionary.setRequiresTempTablespace(configProperties, false);
        RDBDictionary.setSupportsIdentity(configProperties, true);
        RDBDictionary.setValidationQuery(configProperties, "VALUES(1)");
    }

    /**
     * Create a configuration from a jastor configuration object
     * 
     * @param component
     *            jastor configuration object
     * @return the configuration
     */
    static public CoreDBConfiguration createConfiguration(RDBComponent component) {
        CoreDBConfiguration dbConfig = new CoreDBConfiguration();
        String typeString = component.getDbType();
        RDBConfiguration configuration = null;
        if (typeString == null) {
            configuration = component.getConfiguration();
            if (configuration != null) {
                typeString = configuration.getConnectionType();
            }
        }
        DBTypes type = (typeString != null) ? DBTypes.valueOf(typeString) : null;
        Properties properties = null;
        switch (type) {
        case HSQL:
            properties = new Properties(HSQLProps);
            break;
        case ServerHSQL:
            properties = new Properties(HSQLServerProps);
            break;
        case DB2:
            properties = new Properties(DB2Props);
            break;
        case ServerDB2:
            properties = new Properties(DB2ServerProps);
            break;
        case Postgres:
            properties = new Properties(PostgresProps);
            break;
        case ServerPostgres:
            properties = new Properties(PostgresServerProps);
            break;
        case Oracle:
            properties = new Properties(OracleProps);
            break;
        case ServerOracle:
            properties = new Properties(OracleServerProps);
            break;
        case MSSQL:
            properties = new Properties(MSSQLProps);
            break;
        case ServerMSSQL:
            properties = new Properties(MSSQLServerProps);
            break;
        default:
            properties = new Properties();
        }
        //Load default properties based on db type
        dbConfig.nodeCacheSize = RDBProperties.getNodeCacheSize(properties, 20000);
        dbConfig.driver = RDBProperties.getDriver(properties);
        dbConfig.file_location = RDBProperties.getFileLocation(properties);
        dbConfig.max_index_key_length = RDBProperties.getMaxIndexKeyLength(properties);
        dbConfig.max_long_object_length = RDBProperties.getMaxLongObjectLength(properties);
        dbConfig.max_tablename_length = RDBProperties.getMaxTablenameLength(properties);
        dbConfig.quote_char = RDBProperties.getQuotechar(properties);
        dbConfig.sessionPrefix = RDBProperties.getSessionPrefix(properties);
        dbConfig.sql_filename = RDBProperties.getSqlfile(properties);
        dbConfig.supports_optional_joins = RDBDictionary.getSupportsOptionalJoins(properties);
        dbConfig.supports_fullouter_joins = RDBProperties.getSupportsFullouterJoins(properties);
        dbConfig.supports_sequences = RDBProperties.getSupportsSequences(properties);
        dbConfig.supportsTableLocks = RDBProperties.getSupportsTableLocks(properties);
        dbConfig.supportsTableUnLocks = RDBProperties.getSupportsTableUnLocks(properties);
        dbConfig.supports_with_clause = RDBProperties.getSupportsWithClause(properties);
        dbConfig.requiresUniqueTempNames = RDBProperties.getUniqueTempNames(properties);
        dbConfig.url_postfix = RDBProperties.getUrlPostfix(properties);
        dbConfig.url_prefix = RDBProperties.getUrlPrefix(properties);
        dbConfig.uses_uppercase = RDBProperties.getUsesUppercase(properties);
        dbConfig.uses_uppercase_temptables = RDBProperties.getUsesUppercaseTempTables(properties);
        dbConfig.use_temp_find = RDBProperties.getUseTempTableFind(properties);
        dbConfig.use_temp_inserts = RDBProperties.getUseTempTableInsert(properties);
        dbConfig.useHardReset = RDBProperties.getUseHardReset(properties);
        dbConfig.tableLocksExtras = RDBProperties.getTableLockSuffix(properties);
        dbConfig.tableCreateExtras = RDBProperties.getTableCreateSuffix(properties);
        dbConfig.forceTempTablePurge = RDBProperties.getForceTempTablePurge(properties);
        dbConfig.forceTempTableCreation = RDBProperties.getForceTempTableCreation(properties);
        dbConfig.indexSuffix = RDBProperties.getIndexSuffix(properties);
        dbConfig.optimizationString = RDBProperties.getSingleRowOptimizationString(properties);
        dbConfig.textFieldExtras = RDBProperties.getTextFieldSuffix(properties);
        dbConfig.smallInt = RDBProperties.getSmallInt(properties);
        dbConfig.bigInt = RDBProperties.getBigInt(properties);
        dbConfig.varChar = RDBProperties.getVarChar(properties);
        dbConfig.blob = RDBProperties.getBlob(properties);
        dbConfig.supportsIsolation = RDBProperties.getSupportsIsolation(properties);
        dbConfig.dropExtras = RDBProperties.getDropTableSuffix(properties);
        dbConfig.requiresTempTablespace = RDBProperties.getRequiresTempTablespace(properties);
        dbConfig.generatedIdString = RDBProperties.getGeneratedIdString(properties);
        dbConfig.supportsIndividualBatchUpdate = RDBProperties.getSupportsIndividualBatchUpdates(properties);
        dbConfig.canonicalTable = RDBProperties.getCanonicalTableName(properties);
        dbConfig.limit_transaction_size = RDBProperties.getLimitTransactionSize(properties);
        //Load DB instance data from component
        dbConfig.url = component.getDbURL();

        dbConfig.user = component.getDbUser();
        dbConfig.password = component.getDbPassword();
        dbConfig.canonicalTable = component.getCanonicalTable();

        Boolean client = component.getClient();
        boolean isClient = true;
        if (client != null) {
            isClient = client;
        }

        Boolean clear = component.getClear();
        if (clear != null) {
            dbConfig.clear = clear;
        }

        Integer nodeCacheSize = component.getNodeCacheSize();
        if (nodeCacheSize != null) {
            dbConfig.nodeCacheSize = nodeCacheSize;
        }

        Collection<String> initFiles = component.getInitResource();
        if (initFiles != null) {
            dbConfig.initializationFiles = initFiles.toArray(new String[0]);
        }

        Collection<String> setupFunctions = component.getConnectionSetupFunction();
        if (setupFunctions != null) {
            dbConfig.connectionSetupFunctions = setupFunctions.toArray(new String[0]);
        }

        Collection<String> tearDownFunctions = component.getConnectionTeardownFunction();
        if (tearDownFunctions != null) {
            dbConfig.connectionTeardownFunctions = tearDownFunctions.toArray(new String[0]);
        }

        //Load any configuration data stored in rdf
        if (configuration != null) {
            String driver = configuration.getDbDriver();
            if (driver != null) {
                dbConfig.driver = driver;
            }
            String sql_filename = (isClient) ? configuration.getClientSqlFile() : configuration.getServerSqlFile();
            if (sql_filename != null) {
                dbConfig.sql_filename = sql_filename;
            }
            String quote_char = configuration.getQuoteChar();
            if (quote_char != null) {
                dbConfig.quote_char = quote_char;
            }
            String sessionPrefix = configuration.getSessionPrefix();
            if (sessionPrefix != null) {
                dbConfig.sessionPrefix = sessionPrefix;
            }
            String indexSuffix = configuration.getIndexSuffix();
            if (indexSuffix != null) {
                dbConfig.indexSuffix = indexSuffix;
            }
            String optimizationString = configuration.getSingleRowOptimizationString();
            if (optimizationString != null) {
                dbConfig.optimizationString = optimizationString;
            }
            String tableLocksExtras = configuration.getTableLockSuffix();
            if (tableLocksExtras != null) {
                dbConfig.tableLocksExtras = tableLocksExtras;
            }
            String dropExtras = configuration.getDropTableSuffix();
            if (dropExtras != null) {
                dbConfig.dropExtras = dropExtras;
            }
            String smallInt = configuration.getSmallInt();
            if (smallInt != null) {
                dbConfig.smallInt = smallInt;
            }
            String bigInt = configuration.getBigInt();
            if (bigInt != null) {
                dbConfig.bigInt = bigInt;
            }
            String varChar = configuration.getVarChar();
            if (varChar != null) {
                dbConfig.varChar = varChar;
            }
            String blob = configuration.getBlob();
            if (blob != null) {
                dbConfig.blob = blob;
            }
            String tableCreateExtras = configuration.getTableCreateSuffix();
            if (tableCreateExtras != null) {
                dbConfig.tableCreateExtras = tableCreateExtras;
            }
            String textFieldExtras = configuration.getTextFieldSuffix();
            if (textFieldExtras != null) {
                dbConfig.textFieldExtras = textFieldExtras;
            }

            String generatedIdString = configuration.getGeneratedIdString();
            if (generatedIdString != null) {
                dbConfig.generatedIdString = generatedIdString;
            }

            Integer max_tablename_length = configuration.getMaxTableName();
            if (max_tablename_length != null) {
                dbConfig.max_tablename_length = max_tablename_length;
            }
            Boolean supports_ibu = configuration.getSupportsIndividualBatchUpdates();
            if (supports_ibu != null) {
                dbConfig.supportsIndividualBatchUpdate = supports_ibu;
            }
            Boolean supports_sequences = configuration.getSupportsSequences();
            if (supports_sequences != null) {
                dbConfig.supports_sequences = supports_sequences;
            }
            Boolean supports_oj = configuration.getSupportsOptionalJoins();
            if (supports_oj != null) {
                dbConfig.supports_optional_joins = supports_oj;
            }
            Boolean supports_fullouter_joins = configuration.getSupportsFullOuterJoins();
            if (supports_fullouter_joins != null) {
                dbConfig.supports_fullouter_joins = supports_fullouter_joins;
            }
            Boolean supports_with_clause = configuration.getSupportsWithClause();
            if (supports_with_clause != null) {
                dbConfig.supports_with_clause = supports_with_clause;
            }
            Integer max_index_key_length = configuration.getMaxIndexLength();
            if (max_index_key_length != null) {
                dbConfig.max_index_key_length = max_index_key_length;
            }
            Integer max_long_object_length = configuration.getMaxObjectLength();
            if (max_long_object_length != null) {
                dbConfig.max_long_object_length = max_long_object_length;
            }
            Boolean uses_uppercase = configuration.getUseUpperCaseTable();
            if (uses_uppercase != null) {
                dbConfig.uses_uppercase = uses_uppercase;
            }
            Boolean requiresUniqueTempNames = configuration.getUseUniqueTempNames();
            if (requiresUniqueTempNames != null) {
                dbConfig.requiresUniqueTempNames = requiresUniqueTempNames;
            }
            Boolean use_temp_find = configuration.getUseTempFind();
            if (use_temp_find != null) {
                dbConfig.use_temp_find = use_temp_find;
            }
            Boolean use_temp_inserts = configuration.getUseTempInsert();
            if (use_temp_inserts != null) {
                dbConfig.use_temp_inserts = use_temp_inserts;
            }
            Boolean supportsTableLocks = configuration.getSupportsTableLocks();
            if (supportsTableLocks != null) {
                dbConfig.supportsTableLocks = supportsTableLocks;
            }
            Boolean supportsTableUnLocks = configuration.getSupportsTableUnLocks();
            if (supportsTableUnLocks != null) {
                dbConfig.supportsTableUnLocks = supportsTableUnLocks;
            }
            Boolean forceTempTableCreation = configuration.getForceTempTableCreation();
            if (forceTempTableCreation != null) {
                dbConfig.forceTempTableCreation = forceTempTableCreation;
            }
            Boolean supportsIsolation = configuration.getSupportsIsolation();
            if (supportsIsolation != null) {
                dbConfig.supportsIsolation = supportsIsolation;
            }
            Boolean forceTempTablePurge = configuration.getForceTableTablePurge();
            if (forceTempTablePurge != null) {
                dbConfig.forceTempTablePurge = forceTempTablePurge;
            }
            Boolean requiresTempTablespace = configuration.getRequiresTempTablespace();
            if (requiresTempTablespace != null) {
                dbConfig.requiresTempTablespace = requiresTempTablespace;
            }
        }
        return dbConfig;
    }

    /**
     * @return the supportsIdentity
     */
    public boolean getSupportsIdentity() {
        return supportsIdentity;
    }

    /**
     * @param supportsIdentity
     *            the supportsIdentity to set
     */
    public void setSupportsIdentity(boolean supportsIdentity) {
        this.supportsIdentity = supportsIdentity;
    }

    /**
     * @return the supports_optional_joins
     */
    public boolean getSupportsOptionalJoins() {
        return supports_optional_joins;
    }

    /**
     * @param supportsOptionalJoins
     *            the supports_optional_joins to set
     */
    public void setSupportsOptionalJoins(boolean supportsOptionalJoins) {
        this.supports_optional_joins = supportsOptionalJoins;
    }

    /**
     * @return the limit_transaction_size
     */
    public boolean getLimitTransactionSize() {
        return limit_transaction_size;
    }

    /**
     * @param limit_transaction_size
     *            the limit_transaction_size to set
     */
    public void setLimitTransactionSize(boolean limit_transaction_size) {
        this.limit_transaction_size = limit_transaction_size;
    }

    /**
     * @return the validationQuery
     */
    public String getValidationQuery() {
        return validationQuery;
    }

    /**
     * @param validationQuery
     *            the validationQuery to set
     */
    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

}
