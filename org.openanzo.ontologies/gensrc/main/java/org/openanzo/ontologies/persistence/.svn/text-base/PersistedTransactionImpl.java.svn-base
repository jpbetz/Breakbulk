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
package org.openanzo.ontologies.persistence;

/**
 * Implementation of {@link org.openanzo.ontologies.persistence.PersistedTransaction}
 * Use the org.openanzo.ontologies.persistence.ClientPersistenceFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedTransaction)</p>
 * <br>
 */
public class PersistedTransactionImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.persistence.PersistedTransaction {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI transactionContextProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#transactionContext");
	protected static final org.openanzo.rdf.URI additionsStoreProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#additionsStore");
	protected static final org.openanzo.rdf.URI childTransactionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#childTransaction");
	protected static final org.openanzo.rdf.URI deletionsStoreProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#deletionsStore");
	protected static final org.openanzo.rdf.URI nextProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#next");
	protected static final org.openanzo.rdf.URI nextTransactionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#nextTransaction");
	protected static final org.openanzo.rdf.URI parentTransactionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#parentTransaction");
	protected static final org.openanzo.rdf.URI preconditionsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#preconditions");
	protected static final org.openanzo.rdf.URI previousTransactionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#previousTransaction");
	protected static final org.openanzo.rdf.URI transactionUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#transactionUri");

	PersistedTransactionImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static PersistedTransactionImpl getPersistedTransaction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, PersistedTransaction.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new PersistedTransactionImpl(resource, namedGraphUri, dataset);
	}
	    
	static PersistedTransactionImpl createPersistedTransaction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		PersistedTransactionImpl impl = new PersistedTransactionImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, PersistedTransaction.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, PersistedTransaction.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, transactionContextProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, additionsStoreProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, childTransactionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, deletionsStoreProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, nextProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, nextTransactionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, parentTransactionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, preconditionsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, previousTransactionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, transactionUriProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.persistence.PersistedTransaction.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'transactionContext'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTransactionContext(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, transactionContextProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#transactionContext
	public java.lang.String getTransactionContext(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, transactionContextProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": transactionContext getProperty() in org.openanzo.ontologies.persistence.PersistedTransaction model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal transactionContext in PersistedTransaction is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getTransactionContext() throws org.openanzo.rdf.jastor.JastorException {
		return getTransactionContext(false);
	}
	
	public void setTransactionContext(java.lang.String transactionContext) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, transactionContextProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (transactionContext != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(transactionContext,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, transactionContextProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'additionsStore'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAdditionsStore(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, additionsStoreProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#additionsStore

	public org.openanzo.ontologies.persistence.ReferencedQuadStore getAdditionsStore(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, additionsStoreProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": additionsStore getProperty() in org.openanzo.ontologies.persistence.PersistedTransaction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getReferencedQuadStore(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.persistence.ReferencedQuadStore getAdditionsStore() throws org.openanzo.rdf.jastor.JastorException {
		return getAdditionsStore(false);
	}

	public void setAdditionsStore(org.openanzo.ontologies.persistence.ReferencedQuadStore additionsStore) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, additionsStoreProperty, null,_graph.getNamedGraphUri());
		if (additionsStore != null) {
			_dataset.add(_resource, additionsStoreProperty, additionsStore.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.persistence.ReferencedQuadStore setAdditionsStore() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, additionsStoreProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.persistence.ReferencedQuadStore additionsStore = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createReferencedQuadStore(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, additionsStoreProperty, additionsStore.resource(),_graph.getNamedGraphUri());
		return additionsStore;
	}
	
	public org.openanzo.ontologies.persistence.ReferencedQuadStore setAdditionsStore(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, additionsStoreProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, additionsStoreProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.persistence.ReferencedQuadStore additionsStore = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getReferencedQuadStore(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, additionsStoreProperty, additionsStore.resource(),_graph.getNamedGraphUri());
		return additionsStore;
	}
	
	/**
	 * Clears all values for 'childTransaction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearChildTransaction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, childTransactionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#childTransaction

	public org.openanzo.ontologies.persistence.PersistedTransaction getChildTransaction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, childTransactionProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": childTransaction getProperty() in org.openanzo.ontologies.persistence.PersistedTransaction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction getChildTransaction() throws org.openanzo.rdf.jastor.JastorException {
		return getChildTransaction(false);
	}

	public void setChildTransaction(org.openanzo.ontologies.persistence.PersistedTransaction childTransaction) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, childTransactionProperty, null,_graph.getNamedGraphUri());
		if (childTransaction != null) {
			_dataset.add(_resource, childTransactionProperty, childTransaction.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.persistence.PersistedTransaction setChildTransaction() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, childTransactionProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.persistence.PersistedTransaction childTransaction = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createPersistedTransaction(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, childTransactionProperty, childTransaction.resource(),_graph.getNamedGraphUri());
		return childTransaction;
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction setChildTransaction(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, childTransactionProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, childTransactionProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.persistence.PersistedTransaction childTransaction = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, childTransactionProperty, childTransaction.resource(),_graph.getNamedGraphUri());
		return childTransaction;
	}
	
	/**
	 * Clears all values for 'deletionsStore'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDeletionsStore(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, deletionsStoreProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#deletionsStore

	public org.openanzo.ontologies.persistence.ReferencedQuadStore getDeletionsStore(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, deletionsStoreProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": deletionsStore getProperty() in org.openanzo.ontologies.persistence.PersistedTransaction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getReferencedQuadStore(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.persistence.ReferencedQuadStore getDeletionsStore() throws org.openanzo.rdf.jastor.JastorException {
		return getDeletionsStore(false);
	}

	public void setDeletionsStore(org.openanzo.ontologies.persistence.ReferencedQuadStore deletionsStore) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, deletionsStoreProperty, null,_graph.getNamedGraphUri());
		if (deletionsStore != null) {
			_dataset.add(_resource, deletionsStoreProperty, deletionsStore.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.persistence.ReferencedQuadStore setDeletionsStore() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, deletionsStoreProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.persistence.ReferencedQuadStore deletionsStore = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createReferencedQuadStore(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, deletionsStoreProperty, deletionsStore.resource(),_graph.getNamedGraphUri());
		return deletionsStore;
	}
	
	public org.openanzo.ontologies.persistence.ReferencedQuadStore setDeletionsStore(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, deletionsStoreProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, deletionsStoreProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.persistence.ReferencedQuadStore deletionsStore = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getReferencedQuadStore(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, deletionsStoreProperty, deletionsStore.resource(),_graph.getNamedGraphUri());
		return deletionsStore;
	}
	
	/**
	 * Clears all values for 'next'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearNext(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, nextProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#next

	public org.openanzo.ontologies.persistence.PersistedTransaction getNext(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, nextProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": next getProperty() in org.openanzo.ontologies.persistence.PersistedTransaction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction getNext() throws org.openanzo.rdf.jastor.JastorException {
		return getNext(false);
	}

	public void setNext(org.openanzo.ontologies.persistence.PersistedTransaction next) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nextProperty, null,_graph.getNamedGraphUri());
		if (next != null) {
			_dataset.add(_resource, nextProperty, next.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.persistence.PersistedTransaction setNext() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nextProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.persistence.PersistedTransaction next = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createPersistedTransaction(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, nextProperty, next.resource(),_graph.getNamedGraphUri());
		return next;
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction setNext(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, nextProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, nextProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.persistence.PersistedTransaction next = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, nextProperty, next.resource(),_graph.getNamedGraphUri());
		return next;
	}
	
	/**
	 * Clears all values for 'nextTransaction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearNextTransaction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, nextTransactionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#nextTransaction

	public org.openanzo.ontologies.persistence.PersistedTransaction getNextTransaction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, nextTransactionProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": nextTransaction getProperty() in org.openanzo.ontologies.persistence.PersistedTransaction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction getNextTransaction() throws org.openanzo.rdf.jastor.JastorException {
		return getNextTransaction(false);
	}

	public void setNextTransaction(org.openanzo.ontologies.persistence.PersistedTransaction nextTransaction) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nextTransactionProperty, null,_graph.getNamedGraphUri());
		if (nextTransaction != null) {
			_dataset.add(_resource, nextTransactionProperty, nextTransaction.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.persistence.PersistedTransaction setNextTransaction() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nextTransactionProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.persistence.PersistedTransaction nextTransaction = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createPersistedTransaction(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, nextTransactionProperty, nextTransaction.resource(),_graph.getNamedGraphUri());
		return nextTransaction;
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction setNextTransaction(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, nextTransactionProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, nextTransactionProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.persistence.PersistedTransaction nextTransaction = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, nextTransactionProperty, nextTransaction.resource(),_graph.getNamedGraphUri());
		return nextTransaction;
	}
	
	/**
	 * Clears all values for 'parentTransaction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearParentTransaction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, parentTransactionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#parentTransaction

	public org.openanzo.ontologies.persistence.PersistedTransaction getParentTransaction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, parentTransactionProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": parentTransaction getProperty() in org.openanzo.ontologies.persistence.PersistedTransaction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction getParentTransaction() throws org.openanzo.rdf.jastor.JastorException {
		return getParentTransaction(false);
	}

	public void setParentTransaction(org.openanzo.ontologies.persistence.PersistedTransaction parentTransaction) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, parentTransactionProperty, null,_graph.getNamedGraphUri());
		if (parentTransaction != null) {
			_dataset.add(_resource, parentTransactionProperty, parentTransaction.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.persistence.PersistedTransaction setParentTransaction() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, parentTransactionProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.persistence.PersistedTransaction parentTransaction = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createPersistedTransaction(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, parentTransactionProperty, parentTransaction.resource(),_graph.getNamedGraphUri());
		return parentTransaction;
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction setParentTransaction(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, parentTransactionProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, parentTransactionProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.persistence.PersistedTransaction parentTransaction = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, parentTransactionProperty, parentTransaction.resource(),_graph.getNamedGraphUri());
		return parentTransaction;
	}
	
	/**
	 * Clears all values for 'preconditions'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPreconditions(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, preconditionsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#preconditions

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.persistence.PersistedPrecondition> propertyCollectionPreconditions = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.persistence.PersistedPrecondition>() {
		public org.openanzo.ontologies.persistence.PersistedPrecondition getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedPrecondition((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.persistence.PersistedPrecondition 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.persistence.PersistedPrecondition> getPreconditions(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPreconditions.getPropertyCollection(_dataset, _graph, _resource,preconditionsProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedPrecondition"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.persistence.PersistedPrecondition  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.persistence.PersistedPrecondition> getPreconditions() throws org.openanzo.rdf.jastor.JastorException {
		return getPreconditions(false);
	}

/**
     * 
     * @param preconditions value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addPreconditions(org.openanzo.ontologies.persistence.PersistedPrecondition preconditions) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, preconditionsProperty,preconditions.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.persistence.PersistedPrecondition addPreconditions() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.persistence.PersistedPrecondition preconditions = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createPersistedPrecondition(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, preconditionsProperty,preconditions.resource(),_graph.getNamedGraphUri());
		return preconditions;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.persistence.PersistedPrecondition addPreconditions(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.persistence.PersistedPrecondition preconditions = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedPrecondition(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, preconditionsProperty,preconditions.resource(),_graph.getNamedGraphUri());
		return preconditions;
	}
	
	/**
	 * Remove object
	 * @param preconditions object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreconditions(org.openanzo.ontologies.persistence.PersistedPrecondition preconditions) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, preconditionsProperty, preconditions.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, preconditionsProperty, preconditions.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreconditions(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, preconditionsProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, preconditionsProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'previousTransaction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPreviousTransaction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, previousTransactionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#previousTransaction

	public org.openanzo.ontologies.persistence.PersistedTransaction getPreviousTransaction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, previousTransactionProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": previousTransaction getProperty() in org.openanzo.ontologies.persistence.PersistedTransaction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction getPreviousTransaction() throws org.openanzo.rdf.jastor.JastorException {
		return getPreviousTransaction(false);
	}

	public void setPreviousTransaction(org.openanzo.ontologies.persistence.PersistedTransaction previousTransaction) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, previousTransactionProperty, null,_graph.getNamedGraphUri());
		if (previousTransaction != null) {
			_dataset.add(_resource, previousTransactionProperty, previousTransaction.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.persistence.PersistedTransaction setPreviousTransaction() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, previousTransactionProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.persistence.PersistedTransaction previousTransaction = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createPersistedTransaction(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, previousTransactionProperty, previousTransaction.resource(),_graph.getNamedGraphUri());
		return previousTransaction;
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction setPreviousTransaction(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, previousTransactionProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, previousTransactionProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.persistence.PersistedTransaction previousTransaction = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, previousTransactionProperty, previousTransaction.resource(),_graph.getNamedGraphUri());
		return previousTransaction;
	}
	
	/**
	 * Clears all values for 'transactionUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTransactionUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, transactionUriProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#transactionUri

	public org.openanzo.rdf.jastor.Thing getTransactionUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, transactionUriProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": transactionUri getProperty() in org.openanzo.ontologies.persistence.PersistedTransaction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.ThingFactory.getThing(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.Thing getTransactionUri() throws org.openanzo.rdf.jastor.JastorException {
		return getTransactionUri(false);
	}

	public void setTransactionUri(org.openanzo.rdf.jastor.Thing transactionUri) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, transactionUriProperty, null,_graph.getNamedGraphUri());
		if (transactionUri != null) {
			_dataset.add(_resource, transactionUriProperty, transactionUri.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.Thing setTransactionUri() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, transactionUriProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.Thing transactionUri = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, transactionUriProperty, transactionUri.resource(),_graph.getNamedGraphUri());
		return transactionUri;
	}
	
	public org.openanzo.rdf.jastor.Thing setTransactionUri(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, transactionUriProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, transactionUriProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.Thing transactionUri = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, transactionUriProperty, transactionUri.resource(),_graph.getNamedGraphUri());
		return transactionUri;
	}
	 


	protected java.util.concurrent.CopyOnWriteArraySet<PersistedTransactionListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<PersistedTransactionListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof PersistedTransactionListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	PersistedTransactionListener list = (PersistedTransactionListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof PersistedTransactionListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		PersistedTransactionListener list = (PersistedTransactionListener)listener;
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
			if (statement.getPredicate().equals(transactionContextProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersistedTransactionListener listener : listeners){
					listener.transactionContextChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(additionsStoreProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PersistedTransactionListener listener : listeners){
					listener.additionsStoreChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(childTransactionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PersistedTransactionListener listener : listeners){
					listener.childTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(deletionsStoreProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PersistedTransactionListener listener : listeners){
					listener.deletionsStoreChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(nextProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PersistedTransactionListener listener : listeners){
					listener.nextChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(nextTransactionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PersistedTransactionListener listener : listeners){
					listener.nextTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(parentTransactionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PersistedTransactionListener listener : listeners){
					listener.parentTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(preconditionsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.persistence.PersistedPrecondition _preconditions = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedPrecondition(resource,_graph.getNamedGraphUri(),dataset());
				if (_preconditions != null) {
					for(PersistedTransactionListener listener : listeners){
						listener.preconditionsAdded(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this,_preconditions);
					}
				}			
			}
			if (statement.getPredicate().equals(previousTransactionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PersistedTransactionListener listener : listeners){
					listener.previousTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(transactionUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PersistedTransactionListener listener : listeners){
					listener.transactionUriChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(transactionContextProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersistedTransactionListener listener : listeners) {
					listener.transactionContextChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(additionsStoreProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PersistedTransactionListener listener : listeners){
					listener.additionsStoreChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(childTransactionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PersistedTransactionListener listener : listeners){
					listener.childTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(deletionsStoreProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PersistedTransactionListener listener : listeners){
					listener.deletionsStoreChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(nextProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PersistedTransactionListener listener : listeners){
					listener.nextChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(nextTransactionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PersistedTransactionListener listener : listeners){
					listener.nextTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(parentTransactionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PersistedTransactionListener listener : listeners){
					listener.parentTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(preconditionsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.persistence.PersistedPrecondition _preconditions = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedPrecondition(resource,_graph.getNamedGraphUri(),dataset());
				if (_preconditions != null) {
					for(PersistedTransactionListener listener : listeners){
						listener.preconditionsRemoved(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this,_preconditions);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(previousTransactionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PersistedTransactionListener listener : listeners){
					listener.previousTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(transactionUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PersistedTransactionListener listener : listeners){
					listener.transactionUriChanged(org.openanzo.ontologies.persistence.PersistedTransactionImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}