/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Revision:	$Id$
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *	   Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.ontologies.system;

/**
 * Interface for RDBConfiguration ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#RDBConfiguration)</p>
 * <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface RDBConfiguration extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#RDBConfiguration");
	

	/**
	 * The Anzo Property for dbType 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#dbType)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Database type. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI dbTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dbType");


	/**
	 * The Anzo Property for bigInt 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#bigInt)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Big int type. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI bigIntProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#bigInt");


	/**
	 * The Anzo Property for blob 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#blob)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Blob type. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI blobProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#blob");


	/**
	 * The Anzo Property for clientSqlFile 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#clientSqlFile)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Path to file containing table, index definitions as well as text of prepared statements. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI clientSqlFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#clientSqlFile");


	/**
	 * The Anzo Property for connectionType 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#connectionType)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Type of RDB connection. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI connectionTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#connectionType");


	/**
	 * The Anzo Property for dbDriver 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#dbDriver)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : JDBC driver class name. Only needed if replacing the default driver for the given database type. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI dbDriverProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dbDriver");


	/**
	 * The Anzo Property for dropTableSuffix 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#dropTableSuffix)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI dropTableSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dropTableSuffix");


	/**
	 * The Anzo Property for forceTableTablePurge 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#forceTableTablePurge)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI forceTableTablePurgeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#forceTableTablePurge");


	/**
	 * The Anzo Property for forceTempTableCreation 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#forceTempTableCreation)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI forceTempTableCreationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#forceTempTableCreation");


	/**
	 * The Anzo Property for generatedIdString 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#generatedIdString)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI generatedIdStringProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#generatedIdString");


	/**
	 * The Anzo Property for indexSuffix 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#indexSuffix)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI indexSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#indexSuffix");


	/**
	 * The Anzo Property for maxIndexLength 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#maxIndexLength)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : The max length of an index. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI maxIndexLengthProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#maxIndexLength");


	/**
	 * The Anzo Property for maxObjectLength 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#maxObjectLength)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : The max length of a node's value before using the long table. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI maxObjectLengthProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#maxObjectLength");


	/**
	 * The Anzo Property for maxTableName 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#maxTableName)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Max length of table names. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI maxTableNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#maxTableName");


	/**
	 * The Anzo Property for quoteChar 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#quoteChar)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Quote char used in queries. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI quoteCharProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#quoteChar");


	/**
	 * The Anzo Property for requiresTempTablespace 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requiresTempTablespace)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requiresTempTablespaceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requiresTempTablespace");


	/**
	 * The Anzo Property for serverSqlFile 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#serverSqlFile)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Path to file containing table, index definitions as well as text of prepared statements. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI serverSqlFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#serverSqlFile");


	/**
	 * The Anzo Property for sessionPrefix 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#sessionPrefix)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Prefix prepended to start of temporary tables. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI sessionPrefixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#sessionPrefix");


	/**
	 * The Anzo Property for singleRowOptimizationString 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#singleRowOptimizationString)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI singleRowOptimizationStringProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#singleRowOptimizationString");


	/**
	 * The Anzo Property for smallInt 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#smallInt)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI smallIntProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#smallInt");


	/**
	 * The Anzo Property for supportsFullOuterJoins 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#supportsFullOuterJoins)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database support full outer joins. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI supportsFullOuterJoinsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsFullOuterJoins");


	/**
	 * The Anzo Property for supportsIndividualBatchUpdates 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#supportsIndividualBatchUpdates)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database support individual batch updates. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI supportsIndividualBatchUpdatesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsIndividualBatchUpdates");


	/**
	 * The Anzo Property for supportsIsolation 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#supportsIsolation)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI supportsIsolationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsIsolation");


	/**
	 * The Anzo Property for supportsOptionalJoins 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#supportsOptionalJoins)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database support optional joins. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI supportsOptionalJoinsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsOptionalJoins");


	/**
	 * The Anzo Property for supportsSequences 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#supportsSequences)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database support sequences. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI supportsSequencesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsSequences");


	/**
	 * The Anzo Property for supportsTableLocks 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#supportsTableLocks)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database support table locks. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI supportsTableLocksProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsTableLocks");


	/**
	 * The Anzo Property for supportsTableUnLocks 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#supportsTableUnLocks)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database support explicit table unlocks. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI supportsTableUnLocksProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsTableUnLocks");


	/**
	 * The Anzo Property for supportsWithClause 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#supportsWithClause)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database support the WITH clause. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI supportsWithClauseProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsWithClause");


	/**
	 * The Anzo Property for tableCreateSuffix 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#tableCreateSuffix)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI tableCreateSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#tableCreateSuffix");


	/**
	 * The Anzo Property for tableLockSuffix 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#tableLockSuffix)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI tableLockSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#tableLockSuffix");


	/**
	 * The Anzo Property for textFieldSuffix 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#textFieldSuffix)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Size of node cache. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI textFieldSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#textFieldSuffix");


	/**
	 * The Anzo Property for useTempFind 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#useTempFind)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Can database use temporary tables for find operations. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI useTempFindProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useTempFind");


	/**
	 * The Anzo Property for useTempInsert 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#useTempInsert)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Can database use temporary tables for insert operation. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI useTempInsertProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useTempInsert");


	/**
	 * The Anzo Property for useUniqueTempNames 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#useUniqueTempNames)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database disallow multiple references to the same temporary table within a query. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI useUniqueTempNamesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useUniqueTempNames");


	/**
	 * The Anzo Property for useUpperCaseTable 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#useUpperCaseTable)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database use all uppercase strings for table and column names. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI useUpperCaseTableProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useUpperCaseTable");


	/**
	 * The Anzo Property for useUpperCaseTempTables 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#useUpperCaseTempTables)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does the database use all uppercase strings for temporary tables and column names. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI useUpperCaseTempTablesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useUpperCaseTempTables");


	/**
	 * The Anzo Property for varChar 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#varChar)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Var char type. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI varCharProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#varChar");




	/**
	 * Iterates through the 'dbType' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.String}
	 * @see			#dbTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.String> getDbType() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'dbType' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.String}
	 * @see			#dbTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.String> getDbType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'dbType' property value
	 * @param	dbType	{@link java.lang.String}, the value to add
	 * @see			#dbTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addDbType(java.lang.String dbType) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'dbType' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	dbType	{@link java.lang.String}, the value to remove
	 * @see			#dbTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDbType(java.lang.String dbType) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'dbType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#dbTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDbType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'bigInt' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#bigIntProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getBigInt() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'bigInt' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#bigIntProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getBigInt(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'bigInt' property value
	 * @param	bigInt	{@link java.lang.String}, the value to set
	 * @see			#bigIntProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setBigInt(java.lang.String bigInt) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'bigInt'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#bigIntProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearBigInt(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'blob' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#blobProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getBlob() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'blob' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#blobProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getBlob(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'blob' property value
	 * @param	blob	{@link java.lang.String}, the value to set
	 * @see			#blobProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setBlob(java.lang.String blob) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'blob'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#blobProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearBlob(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'clientSqlFile' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#clientSqlFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getClientSqlFile() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'clientSqlFile' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#clientSqlFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getClientSqlFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'clientSqlFile' property value
	 * @param	clientSqlFile	{@link java.lang.String}, the value to set
	 * @see			#clientSqlFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setClientSqlFile(java.lang.String clientSqlFile) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'clientSqlFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#clientSqlFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearClientSqlFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'connectionType' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#connectionTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getConnectionType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'connectionType' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#connectionTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getConnectionType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'connectionType' property value
	 * @param	connectionType	{@link java.lang.String}, the value to set
	 * @see			#connectionTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setConnectionType(java.lang.String connectionType) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'connectionType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#connectionTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearConnectionType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'dbDriver' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#dbDriverProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDbDriver() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'dbDriver' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#dbDriverProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDbDriver(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'dbDriver' property value
	 * @param	dbDriver	{@link java.lang.String}, the value to set
	 * @see			#dbDriverProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setDbDriver(java.lang.String dbDriver) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'dbDriver'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#dbDriverProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDbDriver(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'dropTableSuffix' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#dropTableSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDropTableSuffix() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'dropTableSuffix' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#dropTableSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDropTableSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'dropTableSuffix' property value
	 * @param	dropTableSuffix	{@link java.lang.String}, the value to set
	 * @see			#dropTableSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setDropTableSuffix(java.lang.String dropTableSuffix) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'dropTableSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#dropTableSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDropTableSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'forceTableTablePurge' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#forceTableTablePurgeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getForceTableTablePurge() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'forceTableTablePurge' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#forceTableTablePurgeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getForceTableTablePurge(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'forceTableTablePurge' property value
	 * @param	forceTableTablePurge	{@link java.lang.Boolean}, the value to set
	 * @see			#forceTableTablePurgeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setForceTableTablePurge(java.lang.Boolean forceTableTablePurge) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'forceTableTablePurge'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#forceTableTablePurgeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearForceTableTablePurge(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'forceTempTableCreation' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#forceTempTableCreationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getForceTempTableCreation() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'forceTempTableCreation' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#forceTempTableCreationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getForceTempTableCreation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'forceTempTableCreation' property value
	 * @param	forceTempTableCreation	{@link java.lang.Boolean}, the value to set
	 * @see			#forceTempTableCreationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setForceTempTableCreation(java.lang.Boolean forceTempTableCreation) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'forceTempTableCreation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#forceTempTableCreationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearForceTempTableCreation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'generatedIdString' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#generatedIdStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getGeneratedIdString() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'generatedIdString' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#generatedIdStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getGeneratedIdString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'generatedIdString' property value
	 * @param	generatedIdString	{@link java.lang.String}, the value to set
	 * @see			#generatedIdStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setGeneratedIdString(java.lang.String generatedIdString) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'generatedIdString'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#generatedIdStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearGeneratedIdString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'indexSuffix' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#indexSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getIndexSuffix() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'indexSuffix' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#indexSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getIndexSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'indexSuffix' property value
	 * @param	indexSuffix	{@link java.lang.String}, the value to set
	 * @see			#indexSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setIndexSuffix(java.lang.String indexSuffix) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'indexSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#indexSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIndexSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'maxIndexLength' property value from the given graph
	 * @return		{@link java.lang.Integer}
	 * @see			#maxIndexLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getMaxIndexLength() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'maxIndexLength' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Integer}
	 * @see			#maxIndexLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getMaxIndexLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'maxIndexLength' property value
	 * @param	maxIndexLength	{@link java.lang.Integer}, the value to set
	 * @see			#maxIndexLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setMaxIndexLength(java.lang.Integer maxIndexLength) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'maxIndexLength'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#maxIndexLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMaxIndexLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'maxObjectLength' property value from the given graph
	 * @return		{@link java.lang.Integer}
	 * @see			#maxObjectLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getMaxObjectLength() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'maxObjectLength' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Integer}
	 * @see			#maxObjectLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getMaxObjectLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'maxObjectLength' property value
	 * @param	maxObjectLength	{@link java.lang.Integer}, the value to set
	 * @see			#maxObjectLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setMaxObjectLength(java.lang.Integer maxObjectLength) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'maxObjectLength'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#maxObjectLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMaxObjectLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'maxTableName' property value from the given graph
	 * @return		{@link java.lang.Integer}
	 * @see			#maxTableNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getMaxTableName() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'maxTableName' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Integer}
	 * @see			#maxTableNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getMaxTableName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'maxTableName' property value
	 * @param	maxTableName	{@link java.lang.Integer}, the value to set
	 * @see			#maxTableNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setMaxTableName(java.lang.Integer maxTableName) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'maxTableName'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#maxTableNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMaxTableName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'quoteChar' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#quoteCharProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getQuoteChar() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'quoteChar' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#quoteCharProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getQuoteChar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'quoteChar' property value
	 * @param	quoteChar	{@link java.lang.String}, the value to set
	 * @see			#quoteCharProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setQuoteChar(java.lang.String quoteChar) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'quoteChar'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#quoteCharProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearQuoteChar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'requiresTempTablespace' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#requiresTempTablespaceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getRequiresTempTablespace() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'requiresTempTablespace' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#requiresTempTablespaceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getRequiresTempTablespace(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'requiresTempTablespace' property value
	 * @param	requiresTempTablespace	{@link java.lang.Boolean}, the value to set
	 * @see			#requiresTempTablespaceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRequiresTempTablespace(java.lang.Boolean requiresTempTablespace) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'requiresTempTablespace'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requiresTempTablespaceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequiresTempTablespace(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'serverSqlFile' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#serverSqlFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getServerSqlFile() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'serverSqlFile' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#serverSqlFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getServerSqlFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'serverSqlFile' property value
	 * @param	serverSqlFile	{@link java.lang.String}, the value to set
	 * @see			#serverSqlFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setServerSqlFile(java.lang.String serverSqlFile) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'serverSqlFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#serverSqlFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearServerSqlFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'sessionPrefix' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#sessionPrefixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSessionPrefix() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'sessionPrefix' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#sessionPrefixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSessionPrefix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'sessionPrefix' property value
	 * @param	sessionPrefix	{@link java.lang.String}, the value to set
	 * @see			#sessionPrefixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSessionPrefix(java.lang.String sessionPrefix) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'sessionPrefix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#sessionPrefixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSessionPrefix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'singleRowOptimizationString' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#singleRowOptimizationStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSingleRowOptimizationString() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'singleRowOptimizationString' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#singleRowOptimizationStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSingleRowOptimizationString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'singleRowOptimizationString' property value
	 * @param	singleRowOptimizationString	{@link java.lang.String}, the value to set
	 * @see			#singleRowOptimizationStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSingleRowOptimizationString(java.lang.String singleRowOptimizationString) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'singleRowOptimizationString'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#singleRowOptimizationStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSingleRowOptimizationString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'smallInt' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#smallIntProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSmallInt() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'smallInt' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#smallIntProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSmallInt(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'smallInt' property value
	 * @param	smallInt	{@link java.lang.String}, the value to set
	 * @see			#smallIntProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSmallInt(java.lang.String smallInt) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'smallInt'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#smallIntProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSmallInt(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'supportsFullOuterJoins' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsFullOuterJoinsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsFullOuterJoins() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'supportsFullOuterJoins' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsFullOuterJoinsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsFullOuterJoins(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'supportsFullOuterJoins' property value
	 * @param	supportsFullOuterJoins	{@link java.lang.Boolean}, the value to set
	 * @see			#supportsFullOuterJoinsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSupportsFullOuterJoins(java.lang.Boolean supportsFullOuterJoins) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'supportsFullOuterJoins'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#supportsFullOuterJoinsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSupportsFullOuterJoins(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'supportsIndividualBatchUpdates' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsIndividualBatchUpdatesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsIndividualBatchUpdates() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'supportsIndividualBatchUpdates' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsIndividualBatchUpdatesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsIndividualBatchUpdates(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'supportsIndividualBatchUpdates' property value
	 * @param	supportsIndividualBatchUpdates	{@link java.lang.Boolean}, the value to set
	 * @see			#supportsIndividualBatchUpdatesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSupportsIndividualBatchUpdates(java.lang.Boolean supportsIndividualBatchUpdates) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'supportsIndividualBatchUpdates'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#supportsIndividualBatchUpdatesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSupportsIndividualBatchUpdates(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'supportsIsolation' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsIsolationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsIsolation() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'supportsIsolation' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsIsolationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsIsolation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'supportsIsolation' property value
	 * @param	supportsIsolation	{@link java.lang.Boolean}, the value to set
	 * @see			#supportsIsolationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSupportsIsolation(java.lang.Boolean supportsIsolation) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'supportsIsolation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#supportsIsolationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSupportsIsolation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'supportsOptionalJoins' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsOptionalJoinsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsOptionalJoins() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'supportsOptionalJoins' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsOptionalJoinsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsOptionalJoins(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'supportsOptionalJoins' property value
	 * @param	supportsOptionalJoins	{@link java.lang.Boolean}, the value to set
	 * @see			#supportsOptionalJoinsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSupportsOptionalJoins(java.lang.Boolean supportsOptionalJoins) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'supportsOptionalJoins'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#supportsOptionalJoinsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSupportsOptionalJoins(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'supportsSequences' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsSequencesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsSequences() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'supportsSequences' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsSequencesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsSequences(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'supportsSequences' property value
	 * @param	supportsSequences	{@link java.lang.Boolean}, the value to set
	 * @see			#supportsSequencesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSupportsSequences(java.lang.Boolean supportsSequences) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'supportsSequences'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#supportsSequencesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSupportsSequences(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'supportsTableLocks' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsTableLocksProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsTableLocks() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'supportsTableLocks' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsTableLocksProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsTableLocks(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'supportsTableLocks' property value
	 * @param	supportsTableLocks	{@link java.lang.Boolean}, the value to set
	 * @see			#supportsTableLocksProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSupportsTableLocks(java.lang.Boolean supportsTableLocks) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'supportsTableLocks'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#supportsTableLocksProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSupportsTableLocks(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'supportsTableUnLocks' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsTableUnLocksProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsTableUnLocks() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'supportsTableUnLocks' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsTableUnLocksProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsTableUnLocks(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'supportsTableUnLocks' property value
	 * @param	supportsTableUnLocks	{@link java.lang.Boolean}, the value to set
	 * @see			#supportsTableUnLocksProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSupportsTableUnLocks(java.lang.Boolean supportsTableUnLocks) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'supportsTableUnLocks'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#supportsTableUnLocksProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSupportsTableUnLocks(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'supportsWithClause' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsWithClauseProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsWithClause() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'supportsWithClause' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#supportsWithClauseProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSupportsWithClause(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'supportsWithClause' property value
	 * @param	supportsWithClause	{@link java.lang.Boolean}, the value to set
	 * @see			#supportsWithClauseProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSupportsWithClause(java.lang.Boolean supportsWithClause) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'supportsWithClause'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#supportsWithClauseProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSupportsWithClause(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'tableCreateSuffix' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#tableCreateSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTableCreateSuffix() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'tableCreateSuffix' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#tableCreateSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTableCreateSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'tableCreateSuffix' property value
	 * @param	tableCreateSuffix	{@link java.lang.String}, the value to set
	 * @see			#tableCreateSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setTableCreateSuffix(java.lang.String tableCreateSuffix) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'tableCreateSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#tableCreateSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTableCreateSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'tableLockSuffix' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#tableLockSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTableLockSuffix() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'tableLockSuffix' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#tableLockSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTableLockSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'tableLockSuffix' property value
	 * @param	tableLockSuffix	{@link java.lang.String}, the value to set
	 * @see			#tableLockSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setTableLockSuffix(java.lang.String tableLockSuffix) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'tableLockSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#tableLockSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTableLockSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'textFieldSuffix' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#textFieldSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTextFieldSuffix() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'textFieldSuffix' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#textFieldSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTextFieldSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'textFieldSuffix' property value
	 * @param	textFieldSuffix	{@link java.lang.String}, the value to set
	 * @see			#textFieldSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setTextFieldSuffix(java.lang.String textFieldSuffix) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'textFieldSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#textFieldSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTextFieldSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'useTempFind' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useTempFindProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseTempFind() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'useTempFind' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useTempFindProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseTempFind(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'useTempFind' property value
	 * @param	useTempFind	{@link java.lang.Boolean}, the value to set
	 * @see			#useTempFindProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUseTempFind(java.lang.Boolean useTempFind) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'useTempFind'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#useTempFindProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUseTempFind(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'useTempInsert' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useTempInsertProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseTempInsert() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'useTempInsert' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useTempInsertProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseTempInsert(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'useTempInsert' property value
	 * @param	useTempInsert	{@link java.lang.Boolean}, the value to set
	 * @see			#useTempInsertProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUseTempInsert(java.lang.Boolean useTempInsert) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'useTempInsert'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#useTempInsertProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUseTempInsert(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'useUniqueTempNames' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useUniqueTempNamesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseUniqueTempNames() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'useUniqueTempNames' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useUniqueTempNamesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseUniqueTempNames(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'useUniqueTempNames' property value
	 * @param	useUniqueTempNames	{@link java.lang.Boolean}, the value to set
	 * @see			#useUniqueTempNamesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUseUniqueTempNames(java.lang.Boolean useUniqueTempNames) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'useUniqueTempNames'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#useUniqueTempNamesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUseUniqueTempNames(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'useUpperCaseTable' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useUpperCaseTableProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseUpperCaseTable() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'useUpperCaseTable' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useUpperCaseTableProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseUpperCaseTable(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'useUpperCaseTable' property value
	 * @param	useUpperCaseTable	{@link java.lang.Boolean}, the value to set
	 * @see			#useUpperCaseTableProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUseUpperCaseTable(java.lang.Boolean useUpperCaseTable) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'useUpperCaseTable'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#useUpperCaseTableProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUseUpperCaseTable(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'useUpperCaseTempTables' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useUpperCaseTempTablesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseUpperCaseTempTables() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'useUpperCaseTempTables' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useUpperCaseTempTablesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseUpperCaseTempTables(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'useUpperCaseTempTables' property value
	 * @param	useUpperCaseTempTables	{@link java.lang.Boolean}, the value to set
	 * @see			#useUpperCaseTempTablesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUseUpperCaseTempTables(java.lang.Boolean useUpperCaseTempTables) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'useUpperCaseTempTables'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#useUpperCaseTempTablesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUseUpperCaseTempTables(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'varChar' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#varCharProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getVarChar() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'varChar' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#varCharProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getVarChar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'varChar' property value
	 * @param	varChar	{@link java.lang.String}, the value to set
	 * @see			#varCharProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setVarChar(java.lang.String varChar) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'varChar'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#varCharProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearVarChar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}