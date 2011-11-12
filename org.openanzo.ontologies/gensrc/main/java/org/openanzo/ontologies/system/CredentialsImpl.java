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
 * Implementation of {@link org.openanzo.ontologies.system.Credentials}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#Credentials)</p>
 * <br>
 */
public class CredentialsImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.Credentials {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI passwordProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#password");
	protected static final org.openanzo.rdf.URI userProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#user");

	CredentialsImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static CredentialsImpl getCredentials(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Credentials.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new CredentialsImpl(resource, namedGraphUri, dataset);
	}
	    
	static CredentialsImpl createCredentials(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		CredentialsImpl impl = new CredentialsImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Credentials.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Credentials.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, passwordProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, userProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Credentials.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'password'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, passwordProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#password
	public java.lang.String getPassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, passwordProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": password getProperty() in org.openanzo.ontologies.system.Credentials model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal password in Credentials is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getPassword() throws org.openanzo.rdf.jastor.JastorException {
		return getPassword(false);
	}
	
	public void setPassword(java.lang.String password) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, passwordProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (password != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(password,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, passwordProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'user'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, userProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#user
	public java.lang.String getUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, userProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": user getProperty() in org.openanzo.ontologies.system.Credentials model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal user in Credentials is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getUser() throws org.openanzo.rdf.jastor.JastorException {
		return getUser(false);
	}
	
	public void setUser(java.lang.String user) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, userProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (user != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(user,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, userProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}
 


	protected java.util.concurrent.CopyOnWriteArraySet<CredentialsListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<CredentialsListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof CredentialsListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	CredentialsListener list = (CredentialsListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof CredentialsListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		CredentialsListener list = (CredentialsListener)listener;
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
			if (statement.getPredicate().equals(passwordProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CredentialsListener listener : listeners){
					listener.passwordChanged(org.openanzo.ontologies.system.CredentialsImpl.this);
				}			
			}
			if (statement.getPredicate().equals(userProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CredentialsListener listener : listeners){
					listener.userChanged(org.openanzo.ontologies.system.CredentialsImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(passwordProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CredentialsListener listener : listeners) {
					listener.passwordChanged(org.openanzo.ontologies.system.CredentialsImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(userProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CredentialsListener listener : listeners) {
					listener.userChanged(org.openanzo.ontologies.system.CredentialsImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}