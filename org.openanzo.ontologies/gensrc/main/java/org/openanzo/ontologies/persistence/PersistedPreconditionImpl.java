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
 * Implementation of {@link org.openanzo.ontologies.persistence.PersistedPrecondition}
 * Use the org.openanzo.ontologies.persistence.ClientPersistenceFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedPrecondition)</p>
 * <br>
 */
public class PersistedPreconditionImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.persistence.PersistedPrecondition {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI askResultProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#askResult");
	protected static final org.openanzo.rdf.URI queryStringProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#queryString");
	protected static final org.openanzo.rdf.URI preconditionDefaultUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#preconditionDefaultUri");
	protected static final org.openanzo.rdf.URI preconditionNamedGraphUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#preconditionNamedGraphUri");

	PersistedPreconditionImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static PersistedPreconditionImpl getPersistedPrecondition(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, PersistedPrecondition.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new PersistedPreconditionImpl(resource, namedGraphUri, dataset);
	}
	    
	static PersistedPreconditionImpl createPersistedPrecondition(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		PersistedPreconditionImpl impl = new PersistedPreconditionImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, PersistedPrecondition.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, PersistedPrecondition.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, askResultProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, queryStringProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, preconditionDefaultUriProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, preconditionNamedGraphUriProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.persistence.PersistedPrecondition.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'askResult'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAskResult(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, askResultProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#askResult
	public java.lang.Boolean getAskResult(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, askResultProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": askResult getProperty() in org.openanzo.ontologies.persistence.PersistedPrecondition model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal askResult in PersistedPrecondition is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getAskResult() throws org.openanzo.rdf.jastor.JastorException {
		return getAskResult(false);
	}
	
	public void setAskResult(java.lang.Boolean askResult) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, askResultProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (askResult != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(askResult,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, askResultProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'queryString'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearQueryString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, queryStringProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#queryString
	public java.lang.String getQueryString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, queryStringProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": queryString getProperty() in org.openanzo.ontologies.persistence.PersistedPrecondition model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal queryString in PersistedPrecondition is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getQueryString() throws org.openanzo.rdf.jastor.JastorException {
		return getQueryString(false);
	}
	
	public void setQueryString(java.lang.String queryString) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, queryStringProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (queryString != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(queryString,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, queryStringProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'preconditionDefaultUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPreconditionDefaultUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, preconditionDefaultUriProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#preconditionDefaultUri

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionPreconditionDefaultUri = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPreconditionDefaultUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPreconditionDefaultUri.getPropertyCollection(_dataset, _graph, _resource,preconditionDefaultUriProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPreconditionDefaultUri() throws org.openanzo.rdf.jastor.JastorException {
		return getPreconditionDefaultUri(false);
	}

/**
     * 
     * @param preconditionDefaultUri value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addPreconditionDefaultUri(org.openanzo.rdf.jastor.Thing preconditionDefaultUri) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, preconditionDefaultUriProperty,preconditionDefaultUri.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addPreconditionDefaultUri() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing preconditionDefaultUri = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, preconditionDefaultUriProperty,preconditionDefaultUri.resource(),_graph.getNamedGraphUri());
		return preconditionDefaultUri;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addPreconditionDefaultUri(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing preconditionDefaultUri = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, preconditionDefaultUriProperty,preconditionDefaultUri.resource(),_graph.getNamedGraphUri());
		return preconditionDefaultUri;
	}
	
	/**
	 * Remove object
	 * @param preconditionDefaultUri object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreconditionDefaultUri(org.openanzo.rdf.jastor.Thing preconditionDefaultUri) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, preconditionDefaultUriProperty, preconditionDefaultUri.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, preconditionDefaultUriProperty, preconditionDefaultUri.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreconditionDefaultUri(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, preconditionDefaultUriProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, preconditionDefaultUriProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'preconditionNamedGraphUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPreconditionNamedGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, preconditionNamedGraphUriProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#preconditionNamedGraphUri

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionPreconditionNamedGraphUri = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPreconditionNamedGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPreconditionNamedGraphUri.getPropertyCollection(_dataset, _graph, _resource,preconditionNamedGraphUriProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPreconditionNamedGraphUri() throws org.openanzo.rdf.jastor.JastorException {
		return getPreconditionNamedGraphUri(false);
	}

/**
     * 
     * @param preconditionNamedGraphUri value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addPreconditionNamedGraphUri(org.openanzo.rdf.jastor.Thing preconditionNamedGraphUri) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, preconditionNamedGraphUriProperty,preconditionNamedGraphUri.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addPreconditionNamedGraphUri() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing preconditionNamedGraphUri = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, preconditionNamedGraphUriProperty,preconditionNamedGraphUri.resource(),_graph.getNamedGraphUri());
		return preconditionNamedGraphUri;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addPreconditionNamedGraphUri(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing preconditionNamedGraphUri = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, preconditionNamedGraphUriProperty,preconditionNamedGraphUri.resource(),_graph.getNamedGraphUri());
		return preconditionNamedGraphUri;
	}
	
	/**
	 * Remove object
	 * @param preconditionNamedGraphUri object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreconditionNamedGraphUri(org.openanzo.rdf.jastor.Thing preconditionNamedGraphUri) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, preconditionNamedGraphUriProperty, preconditionNamedGraphUri.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, preconditionNamedGraphUriProperty, preconditionNamedGraphUri.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreconditionNamedGraphUri(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, preconditionNamedGraphUriProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, preconditionNamedGraphUriProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<PersistedPreconditionListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<PersistedPreconditionListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof PersistedPreconditionListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	PersistedPreconditionListener list = (PersistedPreconditionListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof PersistedPreconditionListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		PersistedPreconditionListener list = (PersistedPreconditionListener)listener;
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
			if (statement.getPredicate().equals(askResultProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersistedPreconditionListener listener : listeners){
					listener.askResultChanged(org.openanzo.ontologies.persistence.PersistedPreconditionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(queryStringProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersistedPreconditionListener listener : listeners){
					listener.queryStringChanged(org.openanzo.ontologies.persistence.PersistedPreconditionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(preconditionDefaultUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _preconditionDefaultUri = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_preconditionDefaultUri != null) {
					for(PersistedPreconditionListener listener : listeners){
						listener.preconditionDefaultUriAdded(org.openanzo.ontologies.persistence.PersistedPreconditionImpl.this,_preconditionDefaultUri);
					}
				}			
			}
			if (statement.getPredicate().equals(preconditionNamedGraphUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _preconditionNamedGraphUri = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_preconditionNamedGraphUri != null) {
					for(PersistedPreconditionListener listener : listeners){
						listener.preconditionNamedGraphUriAdded(org.openanzo.ontologies.persistence.PersistedPreconditionImpl.this,_preconditionNamedGraphUri);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(askResultProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersistedPreconditionListener listener : listeners) {
					listener.askResultChanged(org.openanzo.ontologies.persistence.PersistedPreconditionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(queryStringProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersistedPreconditionListener listener : listeners) {
					listener.queryStringChanged(org.openanzo.ontologies.persistence.PersistedPreconditionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(preconditionDefaultUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _preconditionDefaultUri = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_preconditionDefaultUri != null) {
					for(PersistedPreconditionListener listener : listeners){
						listener.preconditionDefaultUriRemoved(org.openanzo.ontologies.persistence.PersistedPreconditionImpl.this,_preconditionDefaultUri);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(preconditionNamedGraphUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _preconditionNamedGraphUri = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_preconditionNamedGraphUri != null) {
					for(PersistedPreconditionListener listener : listeners){
						listener.preconditionNamedGraphUriRemoved(org.openanzo.ontologies.persistence.PersistedPreconditionImpl.this,_preconditionNamedGraphUri);
					}
				}
				return;
			}
		}
		}}
	}
	


}