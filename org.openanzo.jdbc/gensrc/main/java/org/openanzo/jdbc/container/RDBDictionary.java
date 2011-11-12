/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.rdf.utils.properties.jet
 * Created on:  Generated Source from org.openanzo.rdf.utils.properties.jet
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jdbc.container;
import java.util.Dictionary;
/**
 *   Configuration properties for the RDB database connection.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class RDBDictionary{
 	
	/**
	 * Key for property "org.openanzo.database.url"
	 * The jdbc URL for the connection to the database.
	 * <li><b>Server:</b>Not Used</li>
	 * <li><b>Client:</b>Used if local persistence is enabled.</li>
	 * <li><b>Embedded:</b>See client. Note: Persistence shouldn't be used when in embedded mode since stack already has direct access to the database.</li>
	 *
	 * Examples:
	 * On DB2: jdbc:db2://localhost:50000/anzo
	 * On Oracle: jdbc:oracle:thin:@localhost:1521
	 * On PostgreSQL: jdbc:postgresql:anzo
	 * On HSQL: jdbc:hsqldb:mem:anzodb
	 * On MySQL: jdbc:mysql://localhost/anzo
	 */
	public static final String	KEY_DATABASE_URL	= "org.openanzo.database.url";
 	
	/**
	 * Key for property "org.openanzo.database.url.prefix"
	 * String prepended to the jdbc URLs.
	 *
	 * Examples:
	 * jdbc:derby:
	 */
	public static final String	KEY_DATABASE_URL_PREFIX	= "org.openanzo.database.url.prefix";
 	
	/**
	 * Key for property "org.openanzo.database.url.postfix"
	 * String appended to the jdbc URLs
	 *
	 * Examples:
	 * ;create=true;upgrade=true
	 */
	public static final String	KEY_DATABASE_URL_POSTFIX	= "org.openanzo.database.url.postfix";
 	
	/**
	 * Key for property "org.openanzo.database.type"
	 * Anzo database type name.
	 * <li><b>Server:</b>Not Used</li>
	 * <li><b>Client:</b>Used if local persistence is enabled.</li>
	 * <li><b>Embedded:</b>See client. Note: Persistence shouldn't be used when in embedded mode since stack already has direct access to the database.</li>
	 *
	 * Examples:
	 * For DB2: DB2
	 * For Oracle: Oracle
	 * For Derby: Derby
	 * For PostgreSQL: Postgres
	 * For HSQL: HSQL
	 * For MySQL: MySQL
	 */
	public static final String	KEY_DATABASE_TYPE	= "org.openanzo.database.type";
 	
	/**
	 * Key for property "org.openanzo.database.driver"
	 * JDBC driver class name. Only needed if replacing the default driver for the given database type.
	 *
	 * Examples:
	 * For using the derby network client driver: org.apache.derby.jdbc.ClientDriver
	 */
	public static final String	KEY_DATABASE_DRIVER	= "org.openanzo.database.driver";
 	
	/**
	 * Key for property "org.openanzo.database.user"
	 * Login id for the connection to the database.
	 * <li><b>Server:</b>Not Used</li>
	 * <li><b>Client:</b>Used if local persistence is enabled.</li>
	 * <li><b>Embedded:</b>See client. Note: Persistence shouldn't be used when in embedded mode since stack already has direct access to the database.</li>
	 *
	 * Examples:
	 * For DB2: db2inst1
	 * For Oracle: anzo
	 * For Derby: anzo
	 * For PostgreSQL: anzo
	 * For HSQL: sa
	 * For MySQL: anzo
	 */
	public static final String	KEY_DATABASE_USER	= "org.openanzo.database.user";
 	
	/**
	 * Key for property "org.openanzo.database.password"
	 * Password for the connection to the database.
	 * <li><b>Server:</b>Not Used</li>
	 * <li><b>Client:</b>Used if local persistence is enabled.</li>
	 * <li><b>Embedded:</b>See client. Note: Persistence shouldn't be used when in embedded mode since stack already has direct access to the database.</li>
	 *
	 * Examples:
	 * For DB2: password
	 * For Oracle: anzo
	 * For Derby: (don't specify a password)
	 * For PostgreSQL: anzo
	 * For HSQL: (don't specify a password)
	 * For MySQL: anzo
	 */
	public static final String	KEY_DATABASE_PASSWORD	= "org.openanzo.database.password";
 	
	/**
	 * Key for property "org.openanzo.database.fileLocation"
	 * Local directory path from where file based database will be loaded.
	 * <li><b>Server:</b>Not Used</li>
	 * <li><b>Client:</b>Used if local persistence is enabled.</li>
	 * <li><b>Embedded:</b>See client. Note: Persistence shouldn't be used when in embedded mode since stack already has direct access to the database.</li>
	 *
	 * Examples:
	 * For Derby: /tmp/anzoDerby
	 */
	public static final String	KEY_DATABASE_FILE_LOCATION	= "org.openanzo.database.fileLocation";
 	
	/**
	 * Key for property "org.openanzo.database.containerName"
	 * Unique URI to name container of statements and named graphs.
	 * <li><b>Server:</b>Not Used</li>
	 * <li><b>Client:</b>Used if local persistence is enabled.</li>
	 * <li><b>Embedded:</b>See client. Note: Persistence shouldn't be used when in embedded mode since stack already has direct access to the database.</li>
	 *
	 * Examples:
	 * http://openanzo.org/container1
	 */
	public static final String	KEY_DATABASE_CONTAINER_NAME	= "org.openanzo.database.containerName";
 	
	/**
	 * Key for property "org.openanzo.database.clearOnLoad"
	 * Flag for whether or not the database should be cleared when the database is first loaded.
	 * <li><b>Server:</b>Not Used</li>
	 * <li><b>Client:</b>Used if local persistence is enabled.</li>
	 * <li><b>Embedded:</b>See client. Note: Persistence shouldn't be used when in embedded mode since stack already has direct access to the database.</li>
	 *
	 */
	public static final String	KEY_DATABASE_CLEAR	= "org.openanzo.database.clearOnLoad";
 	
	/**
	 * Key for property "org.openanzo.database.sqlfile"
	 * Path to file containing table, index definitions as well as text of prepared statements.
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the standard file for you database.
	 *
	 */
	public static final String	KEY_DATABASE_SQL_FILENAME	= "org.openanzo.database.sqlfile";
 	
	/**
	 * Key for property "org.openanzo.database.quotechar"
	 * Quote char used in queries
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_QUOTE_CHAR	= "org.openanzo.database.quotechar";
 	
	/**
	 * Key for property "org.openanzo.database.maxTablenameLength"
	 * Max length of table names
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_MAX_TABLENAME_LENGTH	= "org.openanzo.database.maxTablenameLength";
 	
	/**
	 * Key for property "org.openanzo.database.useTempTableInsert"
	 * Can database use temporary tables for insert operations
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_USE_TEMP_INSERT	= "org.openanzo.database.useTempTableInsert";
 	
	/**
	 * Key for property "org.openanzo.database.useTempTableFind"
	 * Can database use temporary tables for find operations
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_USE_TEMP_FIND	= "org.openanzo.database.useTempTableFind";
 	
	/**
	 * Key for property "org.openanzo.database.uniqueTempNames"
	 * Does the database disallow multiple references to the same temporary table within a query.
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_UNIQUE_TEMP_NAMES	= "org.openanzo.database.uniqueTempNames";
 	
	/**
	 * Key for property "org.openanzo.database.supportsOptionalJoins"
	 * Does the database support optional joins
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SUPPORTS_OPTIONAL_JOINS	= "org.openanzo.database.supportsOptionalJoins";
 	
	/**
	 * Key for property "org.openanzo.database.supportsSequences"
	 * Does the database support sequences
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SUPPORTS_SEQUENCES	= "org.openanzo.database.supportsSequences";
 	
	/**
	 * Key for property "org.openanzo.database.supportsFullouterJoins"
	 * Does the database support full outer joins
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SUPPORTS_FULLOUTER_JOINS	= "org.openanzo.database.supportsFullouterJoins";
 	
	/**
	 * Key for property "org.openanzo.database.supportsWithClause"
	 * Does the database support the WITH clause
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SUPPORTS_WITH_CLAUSE	= "org.openanzo.database.supportsWithClause";
 	
	/**
	 * Key for property "org.openanzo.database.maxIndexKeyLength"
	 * The max length of an index
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_MAX_INDEX_KEY_LENGTH	= "org.openanzo.database.maxIndexKeyLength";
 	
	/**
	 * Key for property "org.openanzo.database.maxLongObjectLength"
	 * The max length of a node's value before using the long table.
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_MAX_LONG_OBJECT_LENGTH	= "org.openanzo.database.maxLongObjectLength";
 	
	/**
	 * Key for property "org.openanzo.database.usesUppercase"
	 * Does the database use all uppercase strings for table and column names
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_USES_UPPERCASE	= "org.openanzo.database.usesUppercase";
 	
	/**
	 * Key for property "org.openanzo.database.usesUppercaseTempTables"
	 * Does the database use all uppercase strings for temporary tables and column names
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_USES_UPPERCASE_TEMPTABLES	= "org.openanzo.database.usesUppercaseTempTables";
 	
	/**
	 * Key for property "org.openanzo.database.sessionPrefix"
	 * Prefix prepended to start of temporary tables
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SESSION_PREFIX	= "org.openanzo.database.sessionPrefix";
 	
	/**
	 * Key for property "org.openanzo.database.supportsTableLocks"
	 * Does the database support table locks
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SUPPORTS_TABLELOCKS	= "org.openanzo.database.supportsTableLocks";
 	
	/**
	 * Key for property "org.openanzo.database.supportsTableUnLocks"
	 * Does the database support explicit table unlocks
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SUPPORTS_TABLEUNLOCKS	= "org.openanzo.database.supportsTableUnLocks";
 	
	/**
	 * Key for property "org.openanzo.database.nodeCacheSize"
	 * Size of node cache
	 *
	 * Examples:
	 * Default is 25000
	 */
	public static final String	KEY_DATABASE_NODE_CACHE_SIZE	= "org.openanzo.database.nodeCacheSize";
 	
	/**
	 * Key for property "org.openanzo.database.useHardReset"
	 * Does the database need to drop all tables for a reset, instead of just deleting the rows from the existing tables
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_USE_HARD_RESET	= "org.openanzo.database.useHardReset";
 	
	/**
	 * Key for property "org.openanzo.database.bigInt"
	 * The text required within a create table operation for specifying a BIGINT
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_BIG_INT	= "org.openanzo.database.bigInt";
 	
	/**
	 * Key for property "org.openanzo.database.dropTableSuffix"
	 * The text added to the end of a table drop command.
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_DROP_TABLE_SUFFIX	= "org.openanzo.database.dropTableSuffix";
 	
	/**
	 * Key for property "org.openanzo.database.forceTempTablePurge"
	 * True if temporary tables need to be explicitly purged after using.
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_FORCE_TT_PURGE	= "org.openanzo.database.forceTempTablePurge";
 	
	/**
	 * Key for property "org.openanzo.database.forceTempTableCreation"
	 * Force the creation of temporary tables, even if they are already showing up in the catalog.
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_FORCE_TT_CREATE	= "org.openanzo.database.forceTempTableCreation";
 	
	/**
	 * Key for property "org.openanzo.database.indexSuffix"
	 * Text to add to the end of a create index call
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SESSION_INDEX_SUFFIX	= "org.openanzo.database.indexSuffix";
 	
	/**
	 * Key for property "org.openanzo.database.singleRowOptimizationString"
	 * Text added to the end of a query that is expected to return 1 row
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SINGLE_ROW	= "org.openanzo.database.singleRowOptimizationString";
 	
	/**
	 * Key for property "org.openanzo.database.smallInt"
	 * The text required within a create table operation for specifying a SMALLINT
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SMALL_INT	= "org.openanzo.database.smallInt";
 	
	/**
	 * Key for property "org.openanzo.database.varChar"
	 * The text required within a create table operation for specifying a VARCHAR
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_VAR_CHAR	= "org.openanzo.database.varChar";
 	
	/**
	 * Key for property "org.openanzo.database.blob"
	 * The text required within a create table operation for specifying a BLOB
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_BLOB	= "org.openanzo.database.blob";
 	
	/**
	 * Key for property "org.openanzo.database.supportsIsolation"
	 * True if this database supports setting isolation levels on the jdbc driver
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_ISOLATION	= "org.openanzo.database.supportsIsolation";
 	
	/**
	 * Key for property "org.openanzo.database.supportsIndividualBatchUpdates"
	 * True if the database supports batch operations where individual batch calls fail
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_SUPPORT_SINGLE_BATCH	= "org.openanzo.database.supportsIndividualBatchUpdates";
 	
	/**
	 * Key for property "org.openanzo.database.tableCreateSuffix"
	 * Text added to the end of a table creation call
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_CREATE_SUFFIX	= "org.openanzo.database.tableCreateSuffix";
 	
	/**
	 * Key for property "org.openanzo.database.tableLockSuffix"
	 * Text added to the end of a lock table call
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_LOCK_SUFFIX	= "org.openanzo.database.tableLockSuffix";
 	
	/**
	 * Key for property "org.openanzo.database.textFieldSuffix"
	 * Text added to the end of a text field definition within a create table call.
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_TEXT_FIELD_SUFFIX	= "org.openanzo.database.textFieldSuffix";
 	
	/**
	 * Key for property "org.openanzo.database.generatedIdString"
	 * The text required within a create table operation for specifying a generated id column
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_GENERATED_ID	= "org.openanzo.database.generatedIdString";
 	
	/**
	 * Key for property "org.openanzo.database.requiresTempTablespace"
	 * True if this database requires the creation of a temporary tablespace
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_REQUIRES_TT	= "org.openanzo.database.requiresTempTablespace";
 	
	/**
	 * Key for property "org.openanzo.database.canonicalTableName"
	 * Name of table used to determine if database is initialized
	 *
	 * Examples:
	 * This property is automatically set based on the database type. You only need to change this property if you do not want to use the default for you database.
	 */
	public static final String	KEY_DATABASE_CANONICAL_TABLE_NAME	= "org.openanzo.database.canonicalTableName";
 	
	/**
	 * Key for property "org.openanzo.database.initializationFiles"
	 * Comma separated list of files that are used to initialize database at creation time.
	 *
	 * Examples:
	 * 
	 */
	public static final String	KEY_DATABASE_INITIALIZATION_FILES	= "org.openanzo.database.initializationFiles";
 	
	/**
	 * Key for property "org.openanzo.database.supportsIdentity"
	 * Supports identity.
	 *
	 * Examples:
	 * 
	 */
	public static final String	KEY_DATABASE_SUPPORTS_IDENTITY	= "org.openanzo.database.supportsIdentity";
 	
	/**
	 * Key for property "org.openanzo.database.supportsLimitOffset"
	 * Supports Limit Offset queries.
	 *
	 * Examples:
	 * 
	 */
	public static final String	KEY_DATABASE_SUPPORTS_LIMIT_OFFSET	= "org.openanzo.database.supportsLimitOffset";
 	
	/**
	 * Key for property "org.openanzo.database.limitTransactionSize"
	 * Limit the transactions size.
	 *
	 * Examples:
	 * 
	 */
	public static final String	KEY_DATABASE_LIMIT_TRANSACTION_SIZE	= "org.openanzo.database.limitTransactionSize";
 	
	/**
	 * Key for property "org.openanzo.database.validationQuery"
	 * Query that validates the connection is still valid.
	 *
	 * Examples:
	 * 
	 */
	public static final String	KEY_DATABASE_VALIDATION_QUERY	= "org.openanzo.database.validationQuery";
 	
 	/**
	 * Get {@link #KEY_DATABASE_URL} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_URL} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUrl(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_URL);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_URL} property to url in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param url
	 *            value for url
	 */
	 @SuppressWarnings("unchecked")
	static public void setUrl(Dictionary properties, String url) {
		if(url==null){
			properties.remove(KEY_DATABASE_URL);
		}else{
			properties.put(KEY_DATABASE_URL, url);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_URL_PREFIX} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_URL_PREFIX} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUrlPrefix(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_URL_PREFIX);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_URL_PREFIX} property to url.prefix in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param urlPrefix
	 *            value for url.prefix
	 */
	 @SuppressWarnings("unchecked")
	static public void setUrlPrefix(Dictionary properties, String urlPrefix) {
		if(urlPrefix==null){
			properties.remove(KEY_DATABASE_URL_PREFIX);
		}else{
			properties.put(KEY_DATABASE_URL_PREFIX, urlPrefix);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_URL_POSTFIX} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_URL_POSTFIX} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUrlPostfix(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_URL_POSTFIX);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_URL_POSTFIX} property to url.postfix in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param urlPostfix
	 *            value for url.postfix
	 */
	 @SuppressWarnings("unchecked")
	static public void setUrlPostfix(Dictionary properties, String urlPostfix) {
		if(urlPostfix==null){
			properties.remove(KEY_DATABASE_URL_POSTFIX);
		}else{
			properties.put(KEY_DATABASE_URL_POSTFIX, urlPostfix);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_TYPE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_TYPE} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getType(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_TYPE);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_TYPE} property to type in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param type
	 *            value for type
	 */
	 @SuppressWarnings("unchecked")
	static public void setType(Dictionary properties, String type) {
		if(type==null){
			properties.remove(KEY_DATABASE_TYPE);
		}else{
			properties.put(KEY_DATABASE_TYPE, type);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_DRIVER} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_DRIVER} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getDriver(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_DRIVER);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_DRIVER} property to driver in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param driver
	 *            value for driver
	 */
	 @SuppressWarnings("unchecked")
	static public void setDriver(Dictionary properties, String driver) {
		if(driver==null){
			properties.remove(KEY_DATABASE_DRIVER);
		}else{
			properties.put(KEY_DATABASE_DRIVER, driver);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_USER} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_USER} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUser(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_USER);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_USER} property to user in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param user
	 *            value for user
	 */
	 @SuppressWarnings("unchecked")
	static public void setUser(Dictionary properties, String user) {
		if(user==null){
			properties.remove(KEY_DATABASE_USER);
		}else{
			properties.put(KEY_DATABASE_USER, user);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_PASSWORD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_PASSWORD} if not present
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception decrypting value
	 */
	  @SuppressWarnings("unchecked")
	static public String getPassword(Dictionary properties) throws org.openanzo.exceptions.AnzoException{
		try{
		Object _prop = properties.get(KEY_DATABASE_PASSWORD);
		
			
		if(_prop==null){
			return null;
		}else if(_prop.toString().startsWith("encrypted:")){
			_prop=_prop.toString().substring("encrypted:".length());
			if(_prop.toString().length()>0){
				return org.openanzo.exceptions.EncryptionUtil.decryptBase64(_prop.toString());
			}else{
				return _prop.toString();
			}
		}else{
			return _prop.toString();
		}
		
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
	
	/**
	 * Set {@link #KEY_DATABASE_PASSWORD} property to password in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param password
	 *            value for password
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception encrypting value
	 */
	  @SuppressWarnings("unchecked")
	static public void setPassword(Dictionary properties, String password) throws org.openanzo.exceptions.AnzoException {
		try{
			if(password==null){
				properties.remove(KEY_DATABASE_PASSWORD);
			}else{
				password="encrypted:"+org.openanzo.exceptions.EncryptionUtil.encryptBase64(password);
				properties.put(KEY_DATABASE_PASSWORD,password);
			}
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_FILE_LOCATION} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_FILE_LOCATION} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getFileLocation(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_FILE_LOCATION);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_FILE_LOCATION} property to fileLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param fileLocation
	 *            value for fileLocation
	 */
	 @SuppressWarnings("unchecked")
	static public void setFileLocation(Dictionary properties, String fileLocation) {
		if(fileLocation==null){
			properties.remove(KEY_DATABASE_FILE_LOCATION);
		}else{
			properties.put(KEY_DATABASE_FILE_LOCATION, fileLocation);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_CONTAINER_NAME} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_CONTAINER_NAME} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getContainerName(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_CONTAINER_NAME);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_CONTAINER_NAME} property to containerName in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param containerName
	 *            value for containerName
	 */
	 @SuppressWarnings("unchecked")
	static public void setContainerName(Dictionary properties, String containerName) {
		if(containerName==null){
			properties.remove(KEY_DATABASE_CONTAINER_NAME);
		}else{
			properties.put(KEY_DATABASE_CONTAINER_NAME, containerName);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_CLEAR} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_CLEAR},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getClearOnLoad(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_CLEAR);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_CLEAR} property to clearOnLoad in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clearOnLoad
	 *           value for clearOnLoad
	 */
	 @SuppressWarnings("unchecked")
	static public void setClearOnLoad(Dictionary properties, Boolean clearOnLoad) {
		if(clearOnLoad==null){
			properties.remove(KEY_DATABASE_CLEAR);
		}else{
			properties.put(KEY_DATABASE_CLEAR, clearOnLoad.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SQL_FILENAME} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SQL_FILENAME} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getSqlfile(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_SQL_FILENAME);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_SQL_FILENAME} property to sqlfile in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param sqlfile
	 *            value for sqlfile
	 */
	 @SuppressWarnings("unchecked")
	static public void setSqlfile(Dictionary properties, String sqlfile) {
		if(sqlfile==null){
			properties.remove(KEY_DATABASE_SQL_FILENAME);
		}else{
			properties.put(KEY_DATABASE_SQL_FILENAME, sqlfile);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_QUOTE_CHAR} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_QUOTE_CHAR} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getQuotechar(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_QUOTE_CHAR);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_QUOTE_CHAR} property to quotechar in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param quotechar
	 *            value for quotechar
	 */
	 @SuppressWarnings("unchecked")
	static public void setQuotechar(Dictionary properties, String quotechar) {
		if(quotechar==null){
			properties.remove(KEY_DATABASE_QUOTE_CHAR);
		}else{
			properties.put(KEY_DATABASE_QUOTE_CHAR, quotechar);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_MAX_TABLENAME_LENGTH} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_MAX_TABLENAME_LENGTH},or "64"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Integer getMaxTablenameLength(Dictionary properties) {
		Object _prop= properties.get(KEY_DATABASE_MAX_TABLENAME_LENGTH);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):64;
		if(value!=null&&value <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxTablenameLength","0");
		return value;
	}

	/**
	 * Set {@link #KEY_DATABASE_MAX_TABLENAME_LENGTH} property to maxTablenameLength in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param maxTablenameLength
	 *           value for maxTablenameLength
	 */
	 @SuppressWarnings("unchecked")
	static public void setMaxTablenameLength(Dictionary properties, Integer maxTablenameLength) {
		if(maxTablenameLength==null){
			properties.remove(KEY_DATABASE_MAX_TABLENAME_LENGTH);
		}else{
		if(maxTablenameLength <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxTablenameLength","0");
		properties.put(KEY_DATABASE_MAX_TABLENAME_LENGTH, Integer.toString(maxTablenameLength));
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_USE_TEMP_INSERT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_USE_TEMP_INSERT},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getUseTempTableInsert(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_USE_TEMP_INSERT);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_USE_TEMP_INSERT} property to useTempTableInsert in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param useTempTableInsert
	 *           value for useTempTableInsert
	 */
	 @SuppressWarnings("unchecked")
	static public void setUseTempTableInsert(Dictionary properties, Boolean useTempTableInsert) {
		if(useTempTableInsert==null){
			properties.remove(KEY_DATABASE_USE_TEMP_INSERT);
		}else{
			properties.put(KEY_DATABASE_USE_TEMP_INSERT, useTempTableInsert.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_USE_TEMP_FIND} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_USE_TEMP_FIND},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getUseTempTableFind(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_USE_TEMP_FIND);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_USE_TEMP_FIND} property to useTempTableFind in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param useTempTableFind
	 *           value for useTempTableFind
	 */
	 @SuppressWarnings("unchecked")
	static public void setUseTempTableFind(Dictionary properties, Boolean useTempTableFind) {
		if(useTempTableFind==null){
			properties.remove(KEY_DATABASE_USE_TEMP_FIND);
		}else{
			properties.put(KEY_DATABASE_USE_TEMP_FIND, useTempTableFind.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_UNIQUE_TEMP_NAMES} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_UNIQUE_TEMP_NAMES},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getUniqueTempNames(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_UNIQUE_TEMP_NAMES);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_UNIQUE_TEMP_NAMES} property to uniqueTempNames in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param uniqueTempNames
	 *           value for uniqueTempNames
	 */
	 @SuppressWarnings("unchecked")
	static public void setUniqueTempNames(Dictionary properties, Boolean uniqueTempNames) {
		if(uniqueTempNames==null){
			properties.remove(KEY_DATABASE_UNIQUE_TEMP_NAMES);
		}else{
			properties.put(KEY_DATABASE_UNIQUE_TEMP_NAMES, uniqueTempNames.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SUPPORTS_OPTIONAL_JOINS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SUPPORTS_OPTIONAL_JOINS},or "true"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsOptionalJoins(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_SUPPORTS_OPTIONAL_JOINS);
		if(_prop==null){
			_prop=Boolean.valueOf("true");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_SUPPORTS_OPTIONAL_JOINS} property to supportsOptionalJoins in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsOptionalJoins
	 *           value for supportsOptionalJoins
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsOptionalJoins(Dictionary properties, Boolean supportsOptionalJoins) {
		if(supportsOptionalJoins==null){
			properties.remove(KEY_DATABASE_SUPPORTS_OPTIONAL_JOINS);
		}else{
			properties.put(KEY_DATABASE_SUPPORTS_OPTIONAL_JOINS, supportsOptionalJoins.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SUPPORTS_SEQUENCES} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SUPPORTS_SEQUENCES},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsSequences(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_SUPPORTS_SEQUENCES);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_SUPPORTS_SEQUENCES} property to supportsSequences in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsSequences
	 *           value for supportsSequences
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsSequences(Dictionary properties, Boolean supportsSequences) {
		if(supportsSequences==null){
			properties.remove(KEY_DATABASE_SUPPORTS_SEQUENCES);
		}else{
			properties.put(KEY_DATABASE_SUPPORTS_SEQUENCES, supportsSequences.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SUPPORTS_FULLOUTER_JOINS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SUPPORTS_FULLOUTER_JOINS},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsFullouterJoins(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_SUPPORTS_FULLOUTER_JOINS);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_SUPPORTS_FULLOUTER_JOINS} property to supportsFullouterJoins in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsFullouterJoins
	 *           value for supportsFullouterJoins
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsFullouterJoins(Dictionary properties, Boolean supportsFullouterJoins) {
		if(supportsFullouterJoins==null){
			properties.remove(KEY_DATABASE_SUPPORTS_FULLOUTER_JOINS);
		}else{
			properties.put(KEY_DATABASE_SUPPORTS_FULLOUTER_JOINS, supportsFullouterJoins.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SUPPORTS_WITH_CLAUSE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SUPPORTS_WITH_CLAUSE},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsWithClause(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_SUPPORTS_WITH_CLAUSE);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_SUPPORTS_WITH_CLAUSE} property to supportsWithClause in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsWithClause
	 *           value for supportsWithClause
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsWithClause(Dictionary properties, Boolean supportsWithClause) {
		if(supportsWithClause==null){
			properties.remove(KEY_DATABASE_SUPPORTS_WITH_CLAUSE);
		}else{
			properties.put(KEY_DATABASE_SUPPORTS_WITH_CLAUSE, supportsWithClause.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_MAX_INDEX_KEY_LENGTH} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_MAX_INDEX_KEY_LENGTH},or "64"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Integer getMaxIndexKeyLength(Dictionary properties) {
		Object _prop= properties.get(KEY_DATABASE_MAX_INDEX_KEY_LENGTH);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):64;
		if(value!=null&&value <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxIndexKeyLength","0");
		return value;
	}

	/**
	 * Set {@link #KEY_DATABASE_MAX_INDEX_KEY_LENGTH} property to maxIndexKeyLength in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param maxIndexKeyLength
	 *           value for maxIndexKeyLength
	 */
	 @SuppressWarnings("unchecked")
	static public void setMaxIndexKeyLength(Dictionary properties, Integer maxIndexKeyLength) {
		if(maxIndexKeyLength==null){
			properties.remove(KEY_DATABASE_MAX_INDEX_KEY_LENGTH);
		}else{
		if(maxIndexKeyLength <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxIndexKeyLength","0");
		properties.put(KEY_DATABASE_MAX_INDEX_KEY_LENGTH, Integer.toString(maxIndexKeyLength));
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_MAX_LONG_OBJECT_LENGTH} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_MAX_LONG_OBJECT_LENGTH},or "64"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Integer getMaxLongObjectLength(Dictionary properties) {
		Object _prop= properties.get(KEY_DATABASE_MAX_LONG_OBJECT_LENGTH);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):64;
		if(value!=null&&value <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxLongObjectLength","0");
		return value;
	}

	/**
	 * Set {@link #KEY_DATABASE_MAX_LONG_OBJECT_LENGTH} property to maxLongObjectLength in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param maxLongObjectLength
	 *           value for maxLongObjectLength
	 */
	 @SuppressWarnings("unchecked")
	static public void setMaxLongObjectLength(Dictionary properties, Integer maxLongObjectLength) {
		if(maxLongObjectLength==null){
			properties.remove(KEY_DATABASE_MAX_LONG_OBJECT_LENGTH);
		}else{
		if(maxLongObjectLength <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxLongObjectLength","0");
		properties.put(KEY_DATABASE_MAX_LONG_OBJECT_LENGTH, Integer.toString(maxLongObjectLength));
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_USES_UPPERCASE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_USES_UPPERCASE},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getUsesUppercase(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_USES_UPPERCASE);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_USES_UPPERCASE} property to usesUppercase in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param usesUppercase
	 *           value for usesUppercase
	 */
	 @SuppressWarnings("unchecked")
	static public void setUsesUppercase(Dictionary properties, Boolean usesUppercase) {
		if(usesUppercase==null){
			properties.remove(KEY_DATABASE_USES_UPPERCASE);
		}else{
			properties.put(KEY_DATABASE_USES_UPPERCASE, usesUppercase.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_USES_UPPERCASE_TEMPTABLES} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_USES_UPPERCASE_TEMPTABLES},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getUsesUppercaseTempTables(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_USES_UPPERCASE_TEMPTABLES);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_USES_UPPERCASE_TEMPTABLES} property to usesUppercaseTempTables in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param usesUppercaseTempTables
	 *           value for usesUppercaseTempTables
	 */
	 @SuppressWarnings("unchecked")
	static public void setUsesUppercaseTempTables(Dictionary properties, Boolean usesUppercaseTempTables) {
		if(usesUppercaseTempTables==null){
			properties.remove(KEY_DATABASE_USES_UPPERCASE_TEMPTABLES);
		}else{
			properties.put(KEY_DATABASE_USES_UPPERCASE_TEMPTABLES, usesUppercaseTempTables.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SESSION_PREFIX} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SESSION_PREFIX} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getSessionPrefix(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_SESSION_PREFIX);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_SESSION_PREFIX} property to sessionPrefix in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param sessionPrefix
	 *            value for sessionPrefix
	 */
	 @SuppressWarnings("unchecked")
	static public void setSessionPrefix(Dictionary properties, String sessionPrefix) {
		if(sessionPrefix==null){
			properties.remove(KEY_DATABASE_SESSION_PREFIX);
		}else{
			properties.put(KEY_DATABASE_SESSION_PREFIX, sessionPrefix);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SUPPORTS_TABLELOCKS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SUPPORTS_TABLELOCKS},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsTableLocks(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_SUPPORTS_TABLELOCKS);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_SUPPORTS_TABLELOCKS} property to supportsTableLocks in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsTableLocks
	 *           value for supportsTableLocks
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsTableLocks(Dictionary properties, Boolean supportsTableLocks) {
		if(supportsTableLocks==null){
			properties.remove(KEY_DATABASE_SUPPORTS_TABLELOCKS);
		}else{
			properties.put(KEY_DATABASE_SUPPORTS_TABLELOCKS, supportsTableLocks.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SUPPORTS_TABLEUNLOCKS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SUPPORTS_TABLEUNLOCKS},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsTableUnLocks(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_SUPPORTS_TABLEUNLOCKS);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_SUPPORTS_TABLEUNLOCKS} property to supportsTableUnLocks in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsTableUnLocks
	 *           value for supportsTableUnLocks
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsTableUnLocks(Dictionary properties, Boolean supportsTableUnLocks) {
		if(supportsTableUnLocks==null){
			properties.remove(KEY_DATABASE_SUPPORTS_TABLEUNLOCKS);
		}else{
			properties.put(KEY_DATABASE_SUPPORTS_TABLEUNLOCKS, supportsTableUnLocks.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_NODE_CACHE_SIZE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for nodeCacheSize
	 * @return value of {@link #KEY_DATABASE_NODE_CACHE_SIZE}or defaultValue if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Integer getNodeCacheSize(Dictionary properties,Integer defaultValue) {
		Object _prop= properties.get(KEY_DATABASE_NODE_CACHE_SIZE);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):defaultValue;
		if(value!=null&&value <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"nodeCacheSize","0");
		return value;
	}

	/**
	 * Set {@link #KEY_DATABASE_NODE_CACHE_SIZE} property to nodeCacheSize in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param nodeCacheSize
	 *           value for nodeCacheSize
	 */
	 @SuppressWarnings("unchecked")
	static public void setNodeCacheSize(Dictionary properties, Integer nodeCacheSize) {
		if(nodeCacheSize==null){
			properties.remove(KEY_DATABASE_NODE_CACHE_SIZE);
		}else{
		if(nodeCacheSize <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"nodeCacheSize","0");
		properties.put(KEY_DATABASE_NODE_CACHE_SIZE, Integer.toString(nodeCacheSize));
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_USE_HARD_RESET} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_USE_HARD_RESET},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getUseHardReset(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_USE_HARD_RESET);
		if(_prop==null){
			_prop=Boolean.valueOf("false");
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_USE_HARD_RESET} property to useHardReset in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param useHardReset
	 *           value for useHardReset
	 */
	 @SuppressWarnings("unchecked")
	static public void setUseHardReset(Dictionary properties, Boolean useHardReset) {
		if(useHardReset==null){
			properties.remove(KEY_DATABASE_USE_HARD_RESET);
		}else{
			properties.put(KEY_DATABASE_USE_HARD_RESET, useHardReset.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_BIG_INT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_BIG_INT} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getBigInt(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_BIG_INT);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_BIG_INT} property to bigInt in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param bigInt
	 *            value for bigInt
	 */
	 @SuppressWarnings("unchecked")
	static public void setBigInt(Dictionary properties, String bigInt) {
		if(bigInt==null){
			properties.remove(KEY_DATABASE_BIG_INT);
		}else{
			properties.put(KEY_DATABASE_BIG_INT, bigInt);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_DROP_TABLE_SUFFIX} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_DROP_TABLE_SUFFIX} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getDropTableSuffix(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_DROP_TABLE_SUFFIX);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_DROP_TABLE_SUFFIX} property to dropTableSuffix in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param dropTableSuffix
	 *            value for dropTableSuffix
	 */
	 @SuppressWarnings("unchecked")
	static public void setDropTableSuffix(Dictionary properties, String dropTableSuffix) {
		if(dropTableSuffix==null){
			properties.remove(KEY_DATABASE_DROP_TABLE_SUFFIX);
		}else{
			properties.put(KEY_DATABASE_DROP_TABLE_SUFFIX, dropTableSuffix);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_FORCE_TT_PURGE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_FORCE_TT_PURGE}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getForceTempTablePurge(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_FORCE_TT_PURGE);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_FORCE_TT_PURGE} property to forceTempTablePurge in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param forceTempTablePurge
	 *           value for forceTempTablePurge
	 */
	 @SuppressWarnings("unchecked")
	static public void setForceTempTablePurge(Dictionary properties, Boolean forceTempTablePurge) {
		if(forceTempTablePurge==null){
			properties.remove(KEY_DATABASE_FORCE_TT_PURGE);
		}else{
			properties.put(KEY_DATABASE_FORCE_TT_PURGE, forceTempTablePurge.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_FORCE_TT_CREATE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_FORCE_TT_CREATE}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getForceTempTableCreation(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_FORCE_TT_CREATE);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_FORCE_TT_CREATE} property to forceTempTableCreation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param forceTempTableCreation
	 *           value for forceTempTableCreation
	 */
	 @SuppressWarnings("unchecked")
	static public void setForceTempTableCreation(Dictionary properties, Boolean forceTempTableCreation) {
		if(forceTempTableCreation==null){
			properties.remove(KEY_DATABASE_FORCE_TT_CREATE);
		}else{
			properties.put(KEY_DATABASE_FORCE_TT_CREATE, forceTempTableCreation.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SESSION_INDEX_SUFFIX} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SESSION_INDEX_SUFFIX} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getIndexSuffix(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_SESSION_INDEX_SUFFIX);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_SESSION_INDEX_SUFFIX} property to indexSuffix in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param indexSuffix
	 *            value for indexSuffix
	 */
	 @SuppressWarnings("unchecked")
	static public void setIndexSuffix(Dictionary properties, String indexSuffix) {
		if(indexSuffix==null){
			properties.remove(KEY_DATABASE_SESSION_INDEX_SUFFIX);
		}else{
			properties.put(KEY_DATABASE_SESSION_INDEX_SUFFIX, indexSuffix);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SINGLE_ROW} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SINGLE_ROW} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getSingleRowOptimizationString(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_SINGLE_ROW);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_SINGLE_ROW} property to singleRowOptimizationString in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param singleRowOptimizationString
	 *            value for singleRowOptimizationString
	 */
	 @SuppressWarnings("unchecked")
	static public void setSingleRowOptimizationString(Dictionary properties, String singleRowOptimizationString) {
		if(singleRowOptimizationString==null){
			properties.remove(KEY_DATABASE_SINGLE_ROW);
		}else{
			properties.put(KEY_DATABASE_SINGLE_ROW, singleRowOptimizationString);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SMALL_INT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SMALL_INT} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getSmallInt(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_SMALL_INT);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_SMALL_INT} property to smallInt in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param smallInt
	 *            value for smallInt
	 */
	 @SuppressWarnings("unchecked")
	static public void setSmallInt(Dictionary properties, String smallInt) {
		if(smallInt==null){
			properties.remove(KEY_DATABASE_SMALL_INT);
		}else{
			properties.put(KEY_DATABASE_SMALL_INT, smallInt);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_VAR_CHAR} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_VAR_CHAR} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getVarChar(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_VAR_CHAR);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_VAR_CHAR} property to varChar in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param varChar
	 *            value for varChar
	 */
	 @SuppressWarnings("unchecked")
	static public void setVarChar(Dictionary properties, String varChar) {
		if(varChar==null){
			properties.remove(KEY_DATABASE_VAR_CHAR);
		}else{
			properties.put(KEY_DATABASE_VAR_CHAR, varChar);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_BLOB} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_BLOB} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getBlob(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_BLOB);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_BLOB} property to blob in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param blob
	 *            value for blob
	 */
	 @SuppressWarnings("unchecked")
	static public void setBlob(Dictionary properties, String blob) {
		if(blob==null){
			properties.remove(KEY_DATABASE_BLOB);
		}else{
			properties.put(KEY_DATABASE_BLOB, blob);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_ISOLATION} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_ISOLATION}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsIsolation(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_ISOLATION);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_ISOLATION} property to supportsIsolation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsIsolation
	 *           value for supportsIsolation
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsIsolation(Dictionary properties, Boolean supportsIsolation) {
		if(supportsIsolation==null){
			properties.remove(KEY_DATABASE_ISOLATION);
		}else{
			properties.put(KEY_DATABASE_ISOLATION, supportsIsolation.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SUPPORT_SINGLE_BATCH} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SUPPORT_SINGLE_BATCH}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsIndividualBatchUpdates(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_SUPPORT_SINGLE_BATCH);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_SUPPORT_SINGLE_BATCH} property to supportsIndividualBatchUpdates in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsIndividualBatchUpdates
	 *           value for supportsIndividualBatchUpdates
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsIndividualBatchUpdates(Dictionary properties, Boolean supportsIndividualBatchUpdates) {
		if(supportsIndividualBatchUpdates==null){
			properties.remove(KEY_DATABASE_SUPPORT_SINGLE_BATCH);
		}else{
			properties.put(KEY_DATABASE_SUPPORT_SINGLE_BATCH, supportsIndividualBatchUpdates.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_CREATE_SUFFIX} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_CREATE_SUFFIX} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getTableCreateSuffix(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_CREATE_SUFFIX);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_CREATE_SUFFIX} property to tableCreateSuffix in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param tableCreateSuffix
	 *            value for tableCreateSuffix
	 */
	 @SuppressWarnings("unchecked")
	static public void setTableCreateSuffix(Dictionary properties, String tableCreateSuffix) {
		if(tableCreateSuffix==null){
			properties.remove(KEY_DATABASE_CREATE_SUFFIX);
		}else{
			properties.put(KEY_DATABASE_CREATE_SUFFIX, tableCreateSuffix);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_LOCK_SUFFIX} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_LOCK_SUFFIX} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getTableLockSuffix(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_LOCK_SUFFIX);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_LOCK_SUFFIX} property to tableLockSuffix in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param tableLockSuffix
	 *            value for tableLockSuffix
	 */
	 @SuppressWarnings("unchecked")
	static public void setTableLockSuffix(Dictionary properties, String tableLockSuffix) {
		if(tableLockSuffix==null){
			properties.remove(KEY_DATABASE_LOCK_SUFFIX);
		}else{
			properties.put(KEY_DATABASE_LOCK_SUFFIX, tableLockSuffix);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_TEXT_FIELD_SUFFIX} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_TEXT_FIELD_SUFFIX} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getTextFieldSuffix(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_TEXT_FIELD_SUFFIX);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_TEXT_FIELD_SUFFIX} property to textFieldSuffix in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param textFieldSuffix
	 *            value for textFieldSuffix
	 */
	 @SuppressWarnings("unchecked")
	static public void setTextFieldSuffix(Dictionary properties, String textFieldSuffix) {
		if(textFieldSuffix==null){
			properties.remove(KEY_DATABASE_TEXT_FIELD_SUFFIX);
		}else{
			properties.put(KEY_DATABASE_TEXT_FIELD_SUFFIX, textFieldSuffix);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_GENERATED_ID} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_GENERATED_ID} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getGeneratedIdString(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_GENERATED_ID);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_GENERATED_ID} property to generatedIdString in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param generatedIdString
	 *            value for generatedIdString
	 */
	 @SuppressWarnings("unchecked")
	static public void setGeneratedIdString(Dictionary properties, String generatedIdString) {
		if(generatedIdString==null){
			properties.remove(KEY_DATABASE_GENERATED_ID);
		}else{
			properties.put(KEY_DATABASE_GENERATED_ID, generatedIdString);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_REQUIRES_TT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_REQUIRES_TT}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getRequiresTempTablespace(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_REQUIRES_TT);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_REQUIRES_TT} property to requiresTempTablespace in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param requiresTempTablespace
	 *           value for requiresTempTablespace
	 */
	 @SuppressWarnings("unchecked")
	static public void setRequiresTempTablespace(Dictionary properties, Boolean requiresTempTablespace) {
		if(requiresTempTablespace==null){
			properties.remove(KEY_DATABASE_REQUIRES_TT);
		}else{
			properties.put(KEY_DATABASE_REQUIRES_TT, requiresTempTablespace.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_CANONICAL_TABLE_NAME} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_CANONICAL_TABLE_NAME} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getCanonicalTableName(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_CANONICAL_TABLE_NAME);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_CANONICAL_TABLE_NAME} property to canonicalTableName in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param canonicalTableName
	 *            value for canonicalTableName
	 */
	 @SuppressWarnings("unchecked")
	static public void setCanonicalTableName(Dictionary properties, String canonicalTableName) {
		if(canonicalTableName==null){
			properties.remove(KEY_DATABASE_CANONICAL_TABLE_NAME);
		}else{
			properties.put(KEY_DATABASE_CANONICAL_TABLE_NAME, canonicalTableName);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_INITIALIZATION_FILES} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_INITIALIZATION_FILES} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getInitializationFiles(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_INITIALIZATION_FILES);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_INITIALIZATION_FILES} property to initializationFiles in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param initializationFiles
	 *            value for initializationFiles
	 */
	 @SuppressWarnings("unchecked")
	static public void setInitializationFiles(Dictionary properties, String initializationFiles) {
		if(initializationFiles==null){
			properties.remove(KEY_DATABASE_INITIALIZATION_FILES);
		}else{
			properties.put(KEY_DATABASE_INITIALIZATION_FILES, initializationFiles);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SUPPORTS_IDENTITY} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SUPPORTS_IDENTITY}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsIdentity(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_SUPPORTS_IDENTITY);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_SUPPORTS_IDENTITY} property to supportsIdentity in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsIdentity
	 *           value for supportsIdentity
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsIdentity(Dictionary properties, Boolean supportsIdentity) {
		if(supportsIdentity==null){
			properties.remove(KEY_DATABASE_SUPPORTS_IDENTITY);
		}else{
			properties.put(KEY_DATABASE_SUPPORTS_IDENTITY, supportsIdentity.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_SUPPORTS_LIMIT_OFFSET} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_SUPPORTS_LIMIT_OFFSET}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getSupportsLimitOffset(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_SUPPORTS_LIMIT_OFFSET);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_SUPPORTS_LIMIT_OFFSET} property to supportsLimitOffset in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param supportsLimitOffset
	 *           value for supportsLimitOffset
	 */
	 @SuppressWarnings("unchecked")
	static public void setSupportsLimitOffset(Dictionary properties, Boolean supportsLimitOffset) {
		if(supportsLimitOffset==null){
			properties.remove(KEY_DATABASE_SUPPORTS_LIMIT_OFFSET);
		}else{
			properties.put(KEY_DATABASE_SUPPORTS_LIMIT_OFFSET, supportsLimitOffset.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_LIMIT_TRANSACTION_SIZE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_LIMIT_TRANSACTION_SIZE}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getLimitTransactionSize(Dictionary properties) {
		Object _prop=properties.get(KEY_DATABASE_LIMIT_TRANSACTION_SIZE);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_DATABASE_LIMIT_TRANSACTION_SIZE} property to limitTransactionSize in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param limitTransactionSize
	 *           value for limitTransactionSize
	 */
	 @SuppressWarnings("unchecked")
	static public void setLimitTransactionSize(Dictionary properties, Boolean limitTransactionSize) {
		if(limitTransactionSize==null){
			properties.remove(KEY_DATABASE_LIMIT_TRANSACTION_SIZE);
		}else{
			properties.put(KEY_DATABASE_LIMIT_TRANSACTION_SIZE, limitTransactionSize.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATABASE_VALIDATION_QUERY} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATABASE_VALIDATION_QUERY} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getValidationQuery(Dictionary properties) {
		Object _prop = properties.get(KEY_DATABASE_VALIDATION_QUERY);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DATABASE_VALIDATION_QUERY} property to validationQuery in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param validationQuery
	 *            value for validationQuery
	 */
	 @SuppressWarnings("unchecked")
	static public void setValidationQuery(Dictionary properties, String validationQuery) {
		if(validationQuery==null){
			properties.remove(KEY_DATABASE_VALIDATION_QUERY);
		}else{
			properties.put(KEY_DATABASE_VALIDATION_QUERY, validationQuery);
		}
	}
 	
 	
 }
 	