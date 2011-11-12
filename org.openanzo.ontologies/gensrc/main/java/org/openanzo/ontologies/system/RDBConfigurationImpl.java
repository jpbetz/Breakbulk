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
 * Implementation of {@link org.openanzo.ontologies.system.RDBConfiguration}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#RDBConfiguration)</p>
 * <br>
 */
public class RDBConfigurationImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.RDBConfiguration {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI dbTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dbType");
	protected static final org.openanzo.rdf.URI bigIntProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#bigInt");
	protected static final org.openanzo.rdf.URI blobProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#blob");
	protected static final org.openanzo.rdf.URI clientSqlFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#clientSqlFile");
	protected static final org.openanzo.rdf.URI connectionTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#connectionType");
	protected static final org.openanzo.rdf.URI dbDriverProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dbDriver");
	protected static final org.openanzo.rdf.URI dropTableSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dropTableSuffix");
	protected static final org.openanzo.rdf.URI forceTableTablePurgeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#forceTableTablePurge");
	protected static final org.openanzo.rdf.URI forceTempTableCreationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#forceTempTableCreation");
	protected static final org.openanzo.rdf.URI generatedIdStringProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#generatedIdString");
	protected static final org.openanzo.rdf.URI indexSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#indexSuffix");
	protected static final org.openanzo.rdf.URI maxIndexLengthProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#maxIndexLength");
	protected static final org.openanzo.rdf.URI maxObjectLengthProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#maxObjectLength");
	protected static final org.openanzo.rdf.URI maxTableNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#maxTableName");
	protected static final org.openanzo.rdf.URI quoteCharProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#quoteChar");
	protected static final org.openanzo.rdf.URI requiresTempTablespaceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requiresTempTablespace");
	protected static final org.openanzo.rdf.URI serverSqlFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#serverSqlFile");
	protected static final org.openanzo.rdf.URI sessionPrefixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#sessionPrefix");
	protected static final org.openanzo.rdf.URI singleRowOptimizationStringProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#singleRowOptimizationString");
	protected static final org.openanzo.rdf.URI smallIntProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#smallInt");
	protected static final org.openanzo.rdf.URI supportsFullOuterJoinsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsFullOuterJoins");
	protected static final org.openanzo.rdf.URI supportsIndividualBatchUpdatesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsIndividualBatchUpdates");
	protected static final org.openanzo.rdf.URI supportsIsolationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsIsolation");
	protected static final org.openanzo.rdf.URI supportsOptionalJoinsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsOptionalJoins");
	protected static final org.openanzo.rdf.URI supportsSequencesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsSequences");
	protected static final org.openanzo.rdf.URI supportsTableLocksProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsTableLocks");
	protected static final org.openanzo.rdf.URI supportsTableUnLocksProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsTableUnLocks");
	protected static final org.openanzo.rdf.URI supportsWithClauseProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#supportsWithClause");
	protected static final org.openanzo.rdf.URI tableCreateSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#tableCreateSuffix");
	protected static final org.openanzo.rdf.URI tableLockSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#tableLockSuffix");
	protected static final org.openanzo.rdf.URI textFieldSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#textFieldSuffix");
	protected static final org.openanzo.rdf.URI useTempFindProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useTempFind");
	protected static final org.openanzo.rdf.URI useTempInsertProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useTempInsert");
	protected static final org.openanzo.rdf.URI useUniqueTempNamesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useUniqueTempNames");
	protected static final org.openanzo.rdf.URI useUpperCaseTableProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useUpperCaseTable");
	protected static final org.openanzo.rdf.URI useUpperCaseTempTablesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useUpperCaseTempTables");
	protected static final org.openanzo.rdf.URI varCharProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#varChar");

	RDBConfigurationImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static RDBConfigurationImpl getRDBConfiguration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, RDBConfiguration.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new RDBConfigurationImpl(resource, namedGraphUri, dataset);
	}
	    
	static RDBConfigurationImpl createRDBConfiguration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		RDBConfigurationImpl impl = new RDBConfigurationImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, RDBConfiguration.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, RDBConfiguration.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, dbTypeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, bigIntProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, blobProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, clientSqlFileProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, connectionTypeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dbDriverProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dropTableSuffixProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, forceTableTablePurgeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, forceTempTableCreationProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, generatedIdStringProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, indexSuffixProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, maxIndexLengthProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, maxObjectLengthProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, maxTableNameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, quoteCharProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requiresTempTablespaceProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, serverSqlFileProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, sessionPrefixProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, singleRowOptimizationStringProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, smallIntProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, supportsFullOuterJoinsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, supportsIndividualBatchUpdatesProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, supportsIsolationProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, supportsOptionalJoinsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, supportsSequencesProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, supportsTableLocksProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, supportsTableUnLocksProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, supportsWithClauseProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, tableCreateSuffixProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, tableLockSuffixProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, textFieldSuffixProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, useTempFindProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, useTempInsertProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, useUniqueTempNamesProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, useUpperCaseTableProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, useUpperCaseTempTablesProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, varCharProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.RDBConfiguration.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'dbType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDbType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dbTypeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#dbType


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionDbType = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/System#dbType properties in RDBConfiguration model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getDbType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDbType.getPropertyCollection(_dataset, _graph, _resource,dbTypeProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getDbType() throws org.openanzo.rdf.jastor.JastorException {
		return getDbType(false);
	}

	public void addDbType(java.lang.String dbType) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(dbType,"http://www.w3.org/2001/XMLSchema#string");
		//if (_dataset.contains(_resource, dbTypeProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (dbType != null) {
			_dataset.add(_resource, dbTypeProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeDbType(java.lang.String dbType) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(dbType,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, dbTypeProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, dbTypeProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'bigInt'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearBigInt(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, bigIntProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#bigInt
	public java.lang.String getBigInt(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, bigIntProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": bigInt getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal bigInt in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getBigInt() throws org.openanzo.rdf.jastor.JastorException {
		return getBigInt(false);
	}
	
	public void setBigInt(java.lang.String bigInt) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, bigIntProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (bigInt != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(bigInt,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, bigIntProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'blob'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearBlob(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, blobProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#blob
	public java.lang.String getBlob(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, blobProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": blob getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal blob in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getBlob() throws org.openanzo.rdf.jastor.JastorException {
		return getBlob(false);
	}
	
	public void setBlob(java.lang.String blob) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, blobProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (blob != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(blob,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, blobProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'clientSqlFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearClientSqlFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, clientSqlFileProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#clientSqlFile
	public java.lang.String getClientSqlFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, clientSqlFileProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": clientSqlFile getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal clientSqlFile in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getClientSqlFile() throws org.openanzo.rdf.jastor.JastorException {
		return getClientSqlFile(false);
	}
	
	public void setClientSqlFile(java.lang.String clientSqlFile) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, clientSqlFileProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (clientSqlFile != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(clientSqlFile,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, clientSqlFileProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'connectionType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearConnectionType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, connectionTypeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#connectionType
	public java.lang.String getConnectionType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, connectionTypeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": connectionType getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal connectionType in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getConnectionType() throws org.openanzo.rdf.jastor.JastorException {
		return getConnectionType(false);
	}
	
	public void setConnectionType(java.lang.String connectionType) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, connectionTypeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (connectionType != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(connectionType,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, connectionTypeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'dbDriver'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDbDriver(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dbDriverProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#dbDriver
	public java.lang.String getDbDriver(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, dbDriverProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dbDriver getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal dbDriver in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDbDriver() throws org.openanzo.rdf.jastor.JastorException {
		return getDbDriver(false);
	}
	
	public void setDbDriver(java.lang.String dbDriver) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dbDriverProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (dbDriver != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(dbDriver,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, dbDriverProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'dropTableSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDropTableSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dropTableSuffixProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#dropTableSuffix
	public java.lang.String getDropTableSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, dropTableSuffixProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dropTableSuffix getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal dropTableSuffix in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDropTableSuffix() throws org.openanzo.rdf.jastor.JastorException {
		return getDropTableSuffix(false);
	}
	
	public void setDropTableSuffix(java.lang.String dropTableSuffix) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dropTableSuffixProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (dropTableSuffix != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(dropTableSuffix,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, dropTableSuffixProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'forceTableTablePurge'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearForceTableTablePurge(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, forceTableTablePurgeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#forceTableTablePurge
	public java.lang.Boolean getForceTableTablePurge(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, forceTableTablePurgeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": forceTableTablePurge getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal forceTableTablePurge in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getForceTableTablePurge() throws org.openanzo.rdf.jastor.JastorException {
		return getForceTableTablePurge(false);
	}
	
	public void setForceTableTablePurge(java.lang.Boolean forceTableTablePurge) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, forceTableTablePurgeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (forceTableTablePurge != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(forceTableTablePurge,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, forceTableTablePurgeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'forceTempTableCreation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearForceTempTableCreation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, forceTempTableCreationProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#forceTempTableCreation
	public java.lang.Boolean getForceTempTableCreation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, forceTempTableCreationProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": forceTempTableCreation getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal forceTempTableCreation in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getForceTempTableCreation() throws org.openanzo.rdf.jastor.JastorException {
		return getForceTempTableCreation(false);
	}
	
	public void setForceTempTableCreation(java.lang.Boolean forceTempTableCreation) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, forceTempTableCreationProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (forceTempTableCreation != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(forceTempTableCreation,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, forceTempTableCreationProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'generatedIdString'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearGeneratedIdString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, generatedIdStringProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#generatedIdString
	public java.lang.String getGeneratedIdString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, generatedIdStringProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": generatedIdString getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal generatedIdString in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getGeneratedIdString() throws org.openanzo.rdf.jastor.JastorException {
		return getGeneratedIdString(false);
	}
	
	public void setGeneratedIdString(java.lang.String generatedIdString) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, generatedIdStringProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (generatedIdString != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(generatedIdString,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, generatedIdStringProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'indexSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearIndexSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, indexSuffixProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#indexSuffix
	public java.lang.String getIndexSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, indexSuffixProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": indexSuffix getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal indexSuffix in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getIndexSuffix() throws org.openanzo.rdf.jastor.JastorException {
		return getIndexSuffix(false);
	}
	
	public void setIndexSuffix(java.lang.String indexSuffix) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, indexSuffixProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (indexSuffix != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(indexSuffix,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, indexSuffixProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'maxIndexLength'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMaxIndexLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, maxIndexLengthProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#maxIndexLength
	public java.lang.Integer getMaxIndexLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, maxIndexLengthProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": maxIndexLength getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal maxIndexLength in RDBConfiguration is not of type java.lang.Integer", literal);
		return (java.lang.Integer)obj;
		
	}
	
	public java.lang.Integer getMaxIndexLength() throws org.openanzo.rdf.jastor.JastorException {
		return getMaxIndexLength(false);
	}
	
	public void setMaxIndexLength(java.lang.Integer maxIndexLength) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, maxIndexLengthProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (maxIndexLength != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(maxIndexLength,"http://www.w3.org/2001/XMLSchema#int");
			_dataset.add(_resource, maxIndexLengthProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'maxObjectLength'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMaxObjectLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, maxObjectLengthProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#maxObjectLength
	public java.lang.Integer getMaxObjectLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, maxObjectLengthProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": maxObjectLength getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal maxObjectLength in RDBConfiguration is not of type java.lang.Integer", literal);
		return (java.lang.Integer)obj;
		
	}
	
	public java.lang.Integer getMaxObjectLength() throws org.openanzo.rdf.jastor.JastorException {
		return getMaxObjectLength(false);
	}
	
	public void setMaxObjectLength(java.lang.Integer maxObjectLength) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, maxObjectLengthProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (maxObjectLength != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(maxObjectLength,"http://www.w3.org/2001/XMLSchema#int");
			_dataset.add(_resource, maxObjectLengthProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'maxTableName'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMaxTableName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, maxTableNameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#maxTableName
	public java.lang.Integer getMaxTableName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, maxTableNameProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": maxTableName getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal maxTableName in RDBConfiguration is not of type java.lang.Integer", literal);
		return (java.lang.Integer)obj;
		
	}
	
	public java.lang.Integer getMaxTableName() throws org.openanzo.rdf.jastor.JastorException {
		return getMaxTableName(false);
	}
	
	public void setMaxTableName(java.lang.Integer maxTableName) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, maxTableNameProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (maxTableName != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(maxTableName,"http://www.w3.org/2001/XMLSchema#int");
			_dataset.add(_resource, maxTableNameProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'quoteChar'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearQuoteChar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, quoteCharProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#quoteChar
	public java.lang.String getQuoteChar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, quoteCharProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": quoteChar getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal quoteChar in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getQuoteChar() throws org.openanzo.rdf.jastor.JastorException {
		return getQuoteChar(false);
	}
	
	public void setQuoteChar(java.lang.String quoteChar) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, quoteCharProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (quoteChar != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(quoteChar,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, quoteCharProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'requiresTempTablespace'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequiresTempTablespace(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requiresTempTablespaceProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requiresTempTablespace
	public java.lang.Boolean getRequiresTempTablespace(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, requiresTempTablespaceProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": requiresTempTablespace getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal requiresTempTablespace in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getRequiresTempTablespace() throws org.openanzo.rdf.jastor.JastorException {
		return getRequiresTempTablespace(false);
	}
	
	public void setRequiresTempTablespace(java.lang.Boolean requiresTempTablespace) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requiresTempTablespaceProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (requiresTempTablespace != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(requiresTempTablespace,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, requiresTempTablespaceProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'serverSqlFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearServerSqlFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, serverSqlFileProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#serverSqlFile
	public java.lang.String getServerSqlFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, serverSqlFileProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": serverSqlFile getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal serverSqlFile in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getServerSqlFile() throws org.openanzo.rdf.jastor.JastorException {
		return getServerSqlFile(false);
	}
	
	public void setServerSqlFile(java.lang.String serverSqlFile) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, serverSqlFileProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (serverSqlFile != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(serverSqlFile,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, serverSqlFileProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'sessionPrefix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSessionPrefix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, sessionPrefixProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#sessionPrefix
	public java.lang.String getSessionPrefix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, sessionPrefixProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": sessionPrefix getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal sessionPrefix in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getSessionPrefix() throws org.openanzo.rdf.jastor.JastorException {
		return getSessionPrefix(false);
	}
	
	public void setSessionPrefix(java.lang.String sessionPrefix) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, sessionPrefixProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (sessionPrefix != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(sessionPrefix,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, sessionPrefixProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'singleRowOptimizationString'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSingleRowOptimizationString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, singleRowOptimizationStringProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#singleRowOptimizationString
	public java.lang.String getSingleRowOptimizationString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, singleRowOptimizationStringProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": singleRowOptimizationString getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal singleRowOptimizationString in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getSingleRowOptimizationString() throws org.openanzo.rdf.jastor.JastorException {
		return getSingleRowOptimizationString(false);
	}
	
	public void setSingleRowOptimizationString(java.lang.String singleRowOptimizationString) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, singleRowOptimizationStringProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (singleRowOptimizationString != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(singleRowOptimizationString,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, singleRowOptimizationStringProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'smallInt'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSmallInt(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, smallIntProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#smallInt
	public java.lang.String getSmallInt(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, smallIntProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": smallInt getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal smallInt in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getSmallInt() throws org.openanzo.rdf.jastor.JastorException {
		return getSmallInt(false);
	}
	
	public void setSmallInt(java.lang.String smallInt) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, smallIntProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (smallInt != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(smallInt,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, smallIntProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'supportsFullOuterJoins'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSupportsFullOuterJoins(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, supportsFullOuterJoinsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#supportsFullOuterJoins
	public java.lang.Boolean getSupportsFullOuterJoins(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, supportsFullOuterJoinsProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": supportsFullOuterJoins getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal supportsFullOuterJoins in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getSupportsFullOuterJoins() throws org.openanzo.rdf.jastor.JastorException {
		return getSupportsFullOuterJoins(false);
	}
	
	public void setSupportsFullOuterJoins(java.lang.Boolean supportsFullOuterJoins) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, supportsFullOuterJoinsProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (supportsFullOuterJoins != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(supportsFullOuterJoins,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, supportsFullOuterJoinsProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'supportsIndividualBatchUpdates'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSupportsIndividualBatchUpdates(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, supportsIndividualBatchUpdatesProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#supportsIndividualBatchUpdates
	public java.lang.Boolean getSupportsIndividualBatchUpdates(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, supportsIndividualBatchUpdatesProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": supportsIndividualBatchUpdates getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal supportsIndividualBatchUpdates in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getSupportsIndividualBatchUpdates() throws org.openanzo.rdf.jastor.JastorException {
		return getSupportsIndividualBatchUpdates(false);
	}
	
	public void setSupportsIndividualBatchUpdates(java.lang.Boolean supportsIndividualBatchUpdates) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, supportsIndividualBatchUpdatesProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (supportsIndividualBatchUpdates != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(supportsIndividualBatchUpdates,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, supportsIndividualBatchUpdatesProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'supportsIsolation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSupportsIsolation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, supportsIsolationProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#supportsIsolation
	public java.lang.Boolean getSupportsIsolation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, supportsIsolationProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": supportsIsolation getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal supportsIsolation in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getSupportsIsolation() throws org.openanzo.rdf.jastor.JastorException {
		return getSupportsIsolation(false);
	}
	
	public void setSupportsIsolation(java.lang.Boolean supportsIsolation) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, supportsIsolationProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (supportsIsolation != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(supportsIsolation,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, supportsIsolationProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'supportsOptionalJoins'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSupportsOptionalJoins(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, supportsOptionalJoinsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#supportsOptionalJoins
	public java.lang.Boolean getSupportsOptionalJoins(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, supportsOptionalJoinsProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": supportsOptionalJoins getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal supportsOptionalJoins in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getSupportsOptionalJoins() throws org.openanzo.rdf.jastor.JastorException {
		return getSupportsOptionalJoins(false);
	}
	
	public void setSupportsOptionalJoins(java.lang.Boolean supportsOptionalJoins) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, supportsOptionalJoinsProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (supportsOptionalJoins != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(supportsOptionalJoins,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, supportsOptionalJoinsProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'supportsSequences'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSupportsSequences(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, supportsSequencesProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#supportsSequences
	public java.lang.Boolean getSupportsSequences(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, supportsSequencesProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": supportsSequences getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal supportsSequences in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getSupportsSequences() throws org.openanzo.rdf.jastor.JastorException {
		return getSupportsSequences(false);
	}
	
	public void setSupportsSequences(java.lang.Boolean supportsSequences) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, supportsSequencesProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (supportsSequences != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(supportsSequences,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, supportsSequencesProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'supportsTableLocks'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSupportsTableLocks(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, supportsTableLocksProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#supportsTableLocks
	public java.lang.Boolean getSupportsTableLocks(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, supportsTableLocksProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": supportsTableLocks getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal supportsTableLocks in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getSupportsTableLocks() throws org.openanzo.rdf.jastor.JastorException {
		return getSupportsTableLocks(false);
	}
	
	public void setSupportsTableLocks(java.lang.Boolean supportsTableLocks) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, supportsTableLocksProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (supportsTableLocks != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(supportsTableLocks,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, supportsTableLocksProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'supportsTableUnLocks'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSupportsTableUnLocks(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, supportsTableUnLocksProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#supportsTableUnLocks
	public java.lang.Boolean getSupportsTableUnLocks(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, supportsTableUnLocksProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": supportsTableUnLocks getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal supportsTableUnLocks in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getSupportsTableUnLocks() throws org.openanzo.rdf.jastor.JastorException {
		return getSupportsTableUnLocks(false);
	}
	
	public void setSupportsTableUnLocks(java.lang.Boolean supportsTableUnLocks) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, supportsTableUnLocksProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (supportsTableUnLocks != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(supportsTableUnLocks,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, supportsTableUnLocksProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'supportsWithClause'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSupportsWithClause(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, supportsWithClauseProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#supportsWithClause
	public java.lang.Boolean getSupportsWithClause(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, supportsWithClauseProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": supportsWithClause getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal supportsWithClause in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getSupportsWithClause() throws org.openanzo.rdf.jastor.JastorException {
		return getSupportsWithClause(false);
	}
	
	public void setSupportsWithClause(java.lang.Boolean supportsWithClause) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, supportsWithClauseProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (supportsWithClause != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(supportsWithClause,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, supportsWithClauseProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'tableCreateSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTableCreateSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, tableCreateSuffixProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#tableCreateSuffix
	public java.lang.String getTableCreateSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, tableCreateSuffixProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": tableCreateSuffix getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal tableCreateSuffix in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getTableCreateSuffix() throws org.openanzo.rdf.jastor.JastorException {
		return getTableCreateSuffix(false);
	}
	
	public void setTableCreateSuffix(java.lang.String tableCreateSuffix) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, tableCreateSuffixProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (tableCreateSuffix != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(tableCreateSuffix,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, tableCreateSuffixProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'tableLockSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTableLockSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, tableLockSuffixProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#tableLockSuffix
	public java.lang.String getTableLockSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, tableLockSuffixProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": tableLockSuffix getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal tableLockSuffix in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getTableLockSuffix() throws org.openanzo.rdf.jastor.JastorException {
		return getTableLockSuffix(false);
	}
	
	public void setTableLockSuffix(java.lang.String tableLockSuffix) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, tableLockSuffixProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (tableLockSuffix != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(tableLockSuffix,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, tableLockSuffixProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'textFieldSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTextFieldSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, textFieldSuffixProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#textFieldSuffix
	public java.lang.String getTextFieldSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, textFieldSuffixProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": textFieldSuffix getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal textFieldSuffix in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getTextFieldSuffix() throws org.openanzo.rdf.jastor.JastorException {
		return getTextFieldSuffix(false);
	}
	
	public void setTextFieldSuffix(java.lang.String textFieldSuffix) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, textFieldSuffixProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (textFieldSuffix != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(textFieldSuffix,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, textFieldSuffixProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'useTempFind'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUseTempFind(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, useTempFindProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#useTempFind
	public java.lang.Boolean getUseTempFind(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, useTempFindProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": useTempFind getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal useTempFind in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getUseTempFind() throws org.openanzo.rdf.jastor.JastorException {
		return getUseTempFind(false);
	}
	
	public void setUseTempFind(java.lang.Boolean useTempFind) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, useTempFindProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (useTempFind != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(useTempFind,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, useTempFindProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'useTempInsert'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUseTempInsert(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, useTempInsertProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#useTempInsert
	public java.lang.Boolean getUseTempInsert(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, useTempInsertProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": useTempInsert getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal useTempInsert in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getUseTempInsert() throws org.openanzo.rdf.jastor.JastorException {
		return getUseTempInsert(false);
	}
	
	public void setUseTempInsert(java.lang.Boolean useTempInsert) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, useTempInsertProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (useTempInsert != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(useTempInsert,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, useTempInsertProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'useUniqueTempNames'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUseUniqueTempNames(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, useUniqueTempNamesProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#useUniqueTempNames
	public java.lang.Boolean getUseUniqueTempNames(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, useUniqueTempNamesProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": useUniqueTempNames getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal useUniqueTempNames in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getUseUniqueTempNames() throws org.openanzo.rdf.jastor.JastorException {
		return getUseUniqueTempNames(false);
	}
	
	public void setUseUniqueTempNames(java.lang.Boolean useUniqueTempNames) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, useUniqueTempNamesProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (useUniqueTempNames != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(useUniqueTempNames,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, useUniqueTempNamesProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'useUpperCaseTable'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUseUpperCaseTable(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, useUpperCaseTableProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#useUpperCaseTable
	public java.lang.Boolean getUseUpperCaseTable(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, useUpperCaseTableProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": useUpperCaseTable getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal useUpperCaseTable in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getUseUpperCaseTable() throws org.openanzo.rdf.jastor.JastorException {
		return getUseUpperCaseTable(false);
	}
	
	public void setUseUpperCaseTable(java.lang.Boolean useUpperCaseTable) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, useUpperCaseTableProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (useUpperCaseTable != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(useUpperCaseTable,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, useUpperCaseTableProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'useUpperCaseTempTables'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUseUpperCaseTempTables(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, useUpperCaseTempTablesProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#useUpperCaseTempTables
	public java.lang.Boolean getUseUpperCaseTempTables(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, useUpperCaseTempTablesProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": useUpperCaseTempTables getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal useUpperCaseTempTables in RDBConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getUseUpperCaseTempTables() throws org.openanzo.rdf.jastor.JastorException {
		return getUseUpperCaseTempTables(false);
	}
	
	public void setUseUpperCaseTempTables(java.lang.Boolean useUpperCaseTempTables) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, useUpperCaseTempTablesProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (useUpperCaseTempTables != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(useUpperCaseTempTables,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, useUpperCaseTempTablesProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'varChar'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearVarChar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, varCharProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#varChar
	public java.lang.String getVarChar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, varCharProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": varChar getProperty() in org.openanzo.ontologies.system.RDBConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal varChar in RDBConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getVarChar() throws org.openanzo.rdf.jastor.JastorException {
		return getVarChar(false);
	}
	
	public void setVarChar(java.lang.String varChar) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, varCharProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (varChar != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(varChar,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, varCharProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}
 


	protected java.util.concurrent.CopyOnWriteArraySet<RDBConfigurationListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<RDBConfigurationListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof RDBConfigurationListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	RDBConfigurationListener list = (RDBConfigurationListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof RDBConfigurationListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		RDBConfigurationListener list = (RDBConfigurationListener)listener;
		if(listeners.contains(list)){
			listeners.remove(list);
		}
		if(listeners.size()==0){	
    		_dataset.unregisterListener(_listener);
    	}
	}
	



	protected class ThingStatementListener implements org.openanzo.rdf.IStatementListener<org.openanzo.rdf.IDataset> {
	
		public void statementsAdded(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(dbTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(RDBConfigurationListener listener : listeners){
						listener.dbTypeAdded(org.openanzo.ontologies.system.RDBConfigurationImpl.this,(java.lang.String)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(bigIntProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.bigIntChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(blobProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.blobChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(clientSqlFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.clientSqlFileChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(connectionTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.connectionTypeChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(dbDriverProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.dbDriverChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(dropTableSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.dropTableSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(forceTableTablePurgeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.forceTableTablePurgeChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(forceTempTableCreationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.forceTempTableCreationChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(generatedIdStringProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.generatedIdStringChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(indexSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.indexSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(maxIndexLengthProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.maxIndexLengthChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(maxObjectLengthProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.maxObjectLengthChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(maxTableNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.maxTableNameChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(quoteCharProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.quoteCharChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(requiresTempTablespaceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.requiresTempTablespaceChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(serverSqlFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.serverSqlFileChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(sessionPrefixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.sessionPrefixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(singleRowOptimizationStringProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.singleRowOptimizationStringChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(smallIntProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.smallIntChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(supportsFullOuterJoinsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.supportsFullOuterJoinsChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(supportsIndividualBatchUpdatesProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.supportsIndividualBatchUpdatesChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(supportsIsolationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.supportsIsolationChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(supportsOptionalJoinsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.supportsOptionalJoinsChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(supportsSequencesProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.supportsSequencesChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(supportsTableLocksProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.supportsTableLocksChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(supportsTableUnLocksProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.supportsTableUnLocksChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(supportsWithClauseProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.supportsWithClauseChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(tableCreateSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.tableCreateSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(tableLockSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.tableLockSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(textFieldSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.textFieldSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(useTempFindProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.useTempFindChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(useTempInsertProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.useTempInsertChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(useUniqueTempNamesProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.useUniqueTempNamesChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(useUpperCaseTableProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.useUpperCaseTableChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(useUpperCaseTempTablesProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.useUpperCaseTempTablesChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(varCharProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners){
					listener.varCharChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(dbTypeProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(RDBConfigurationListener listener : listeners){
						listener.dbTypeRemoved(org.openanzo.ontologies.system.RDBConfigurationImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(bigIntProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.bigIntChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(blobProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.blobChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(clientSqlFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.clientSqlFileChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(connectionTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.connectionTypeChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(dbDriverProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.dbDriverChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(dropTableSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.dropTableSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(forceTableTablePurgeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.forceTableTablePurgeChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(forceTempTableCreationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.forceTempTableCreationChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(generatedIdStringProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.generatedIdStringChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(indexSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.indexSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(maxIndexLengthProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.maxIndexLengthChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(maxObjectLengthProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.maxObjectLengthChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(maxTableNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.maxTableNameChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(quoteCharProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.quoteCharChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(requiresTempTablespaceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.requiresTempTablespaceChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(serverSqlFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.serverSqlFileChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(sessionPrefixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.sessionPrefixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(singleRowOptimizationStringProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.singleRowOptimizationStringChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(smallIntProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.smallIntChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(supportsFullOuterJoinsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.supportsFullOuterJoinsChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(supportsIndividualBatchUpdatesProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.supportsIndividualBatchUpdatesChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(supportsIsolationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.supportsIsolationChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(supportsOptionalJoinsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.supportsOptionalJoinsChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(supportsSequencesProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.supportsSequencesChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(supportsTableLocksProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.supportsTableLocksChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(supportsTableUnLocksProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.supportsTableUnLocksChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(supportsWithClauseProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.supportsWithClauseChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(tableCreateSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.tableCreateSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(tableLockSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.tableLockSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(textFieldSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.textFieldSuffixChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(useTempFindProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.useTempFindChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(useTempInsertProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.useTempInsertChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(useUniqueTempNamesProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.useUniqueTempNamesChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(useUpperCaseTableProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.useUpperCaseTableChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(useUpperCaseTempTablesProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.useUpperCaseTempTablesChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(varCharProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBConfigurationListener listener : listeners) {
					listener.varCharChanged(org.openanzo.ontologies.system.RDBConfigurationImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}