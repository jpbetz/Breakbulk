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
 * Implementation of {@link org.openanzo.ontologies.persistence.ClientPersistenceRoot}
 * Use the org.openanzo.ontologies.persistence.ClientPersistenceFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#ClientPersistenceRoot)</p>
 * <br>
 */
public class ClientPersistenceRootImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.persistence.ClientPersistenceRoot {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI committedTransactionsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#committedTransactions");

	ClientPersistenceRootImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static ClientPersistenceRootImpl getClientPersistenceRoot(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ClientPersistenceRoot.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new ClientPersistenceRootImpl(resource, namedGraphUri, dataset);
	}
	    
	static ClientPersistenceRootImpl createClientPersistenceRoot(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		ClientPersistenceRootImpl impl = new ClientPersistenceRootImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ClientPersistenceRoot.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ClientPersistenceRoot.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, committedTransactionsProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.persistence.ClientPersistenceRoot.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'committedTransactions'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCommittedTransactions(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, committedTransactionsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#committedTransactions

	public org.openanzo.ontologies.persistence.PersistedTransaction getCommittedTransactions(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, committedTransactionsProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": committedTransactions getProperty() in org.openanzo.ontologies.persistence.ClientPersistenceRoot model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction getCommittedTransactions() throws org.openanzo.rdf.jastor.JastorException {
		return getCommittedTransactions(false);
	}

	public void setCommittedTransactions(org.openanzo.ontologies.persistence.PersistedTransaction committedTransactions) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, committedTransactionsProperty, null,_graph.getNamedGraphUri());
		if (committedTransactions != null) {
			_dataset.add(_resource, committedTransactionsProperty, committedTransactions.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.persistence.PersistedTransaction setCommittedTransactions() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, committedTransactionsProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.persistence.PersistedTransaction committedTransactions = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createPersistedTransaction(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, committedTransactionsProperty, committedTransactions.resource(),_graph.getNamedGraphUri());
		return committedTransactions;
	}
	
	public org.openanzo.ontologies.persistence.PersistedTransaction setCommittedTransactions(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, committedTransactionsProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, committedTransactionsProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.persistence.PersistedTransaction committedTransactions = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getPersistedTransaction(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, committedTransactionsProperty, committedTransactions.resource(),_graph.getNamedGraphUri());
		return committedTransactions;
	}
	 


	protected java.util.concurrent.CopyOnWriteArraySet<ClientPersistenceRootListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<ClientPersistenceRootListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ClientPersistenceRootListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	ClientPersistenceRootListener list = (ClientPersistenceRootListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ClientPersistenceRootListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		ClientPersistenceRootListener list = (ClientPersistenceRootListener)listener;
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
			if (statement.getPredicate().equals(committedTransactionsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(ClientPersistenceRootListener listener : listeners){
					listener.committedTransactionsChanged(org.openanzo.ontologies.persistence.ClientPersistenceRootImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(committedTransactionsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(ClientPersistenceRootListener listener : listeners){
					listener.committedTransactionsChanged(org.openanzo.ontologies.persistence.ClientPersistenceRootImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}