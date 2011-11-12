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
package org.openanzo.ontologies.openanzo;

/**
 * Implementation of {@link org.openanzo.ontologies.openanzo.Precondition}
 * Use the org.openanzo.ontologies.openanzo.AnzoFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#Precondition)</p>
 * <br>
 */
public class PreconditionImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.openanzo.Precondition {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI datasetProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#dataset");
	protected static final org.openanzo.rdf.URI queryProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#query");
	protected static final org.openanzo.rdf.URI resultProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#result");

	PreconditionImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static PreconditionImpl getPrecondition(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Precondition.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new PreconditionImpl(resource, namedGraphUri, dataset);
	}
	    
	static PreconditionImpl createPrecondition(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		PreconditionImpl impl = new PreconditionImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Precondition.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Precondition.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, datasetProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, queryProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, resultProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.Precondition.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'dataset'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDataset(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, datasetProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#dataset

	public org.openanzo.ontologies.openanzo.Dataset getDataset(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, datasetProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dataset getProperty() in org.openanzo.ontologies.openanzo.Precondition model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.openanzo.AnzoFactory.getDataset(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.openanzo.Dataset getDataset() throws org.openanzo.rdf.jastor.JastorException {
		return getDataset(false);
	}

	public void setDataset(org.openanzo.ontologies.openanzo.Dataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, datasetProperty, null,_graph.getNamedGraphUri());
		if (dataset != null) {
			_dataset.add(_resource, datasetProperty, dataset.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.openanzo.Dataset setDataset() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, datasetProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.openanzo.Dataset dataset = org.openanzo.ontologies.openanzo.AnzoFactory.createDataset(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, datasetProperty, dataset.resource(),_graph.getNamedGraphUri());
		return dataset;
	}
	
	public org.openanzo.ontologies.openanzo.Dataset setDataset(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, datasetProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, datasetProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.openanzo.Dataset dataset = org.openanzo.ontologies.openanzo.AnzoFactory.getDataset(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, datasetProperty, dataset.resource(),_graph.getNamedGraphUri());
		return dataset;
	}
	
	/**
	 * Clears all values for 'query'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearQuery(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, queryProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#query

	public org.openanzo.ontologies.openanzo.Query getQuery(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, queryProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": query getProperty() in org.openanzo.ontologies.openanzo.Precondition model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.openanzo.AnzoFactory.getQuery(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.openanzo.Query getQuery() throws org.openanzo.rdf.jastor.JastorException {
		return getQuery(false);
	}

	public void setQuery(org.openanzo.ontologies.openanzo.Query query) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, queryProperty, null,_graph.getNamedGraphUri());
		if (query != null) {
			_dataset.add(_resource, queryProperty, query.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.openanzo.Query setQuery() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, queryProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.openanzo.Query query = org.openanzo.ontologies.openanzo.AnzoFactory.createQuery(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, queryProperty, query.resource(),_graph.getNamedGraphUri());
		return query;
	}
	
	public org.openanzo.ontologies.openanzo.Query setQuery(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, queryProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, queryProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.openanzo.Query query = org.openanzo.ontologies.openanzo.AnzoFactory.getQuery(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, queryProperty, query.resource(),_graph.getNamedGraphUri());
		return query;
	}
	
	/**
	 * Clears all values for 'result'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearResult(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, resultProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#result

	public org.openanzo.ontologies.openanzo.Result getResult(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, resultProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": result getProperty() in org.openanzo.ontologies.openanzo.Precondition model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.openanzo.AnzoFactory.getResult(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.openanzo.Result getResult() throws org.openanzo.rdf.jastor.JastorException {
		return getResult(false);
	}

	public void setResult(org.openanzo.ontologies.openanzo.Result result) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, resultProperty, null,_graph.getNamedGraphUri());
		if (result != null) {
			_dataset.add(_resource, resultProperty, result.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.openanzo.Result setResult() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, resultProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.openanzo.Result result = org.openanzo.ontologies.openanzo.AnzoFactory.createResult(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, resultProperty, result.resource(),_graph.getNamedGraphUri());
		return result;
	}
	
	public org.openanzo.ontologies.openanzo.Result setResult(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, resultProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, resultProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.openanzo.Result result = org.openanzo.ontologies.openanzo.AnzoFactory.getResult(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, resultProperty, result.resource(),_graph.getNamedGraphUri());
		return result;
	}
	 


	protected java.util.concurrent.CopyOnWriteArraySet<PreconditionListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<PreconditionListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof PreconditionListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	PreconditionListener list = (PreconditionListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof PreconditionListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		PreconditionListener list = (PreconditionListener)listener;
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
			if (statement.getPredicate().equals(datasetProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PreconditionListener listener : listeners){
					listener.datasetChanged(org.openanzo.ontologies.openanzo.PreconditionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(queryProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PreconditionListener listener : listeners){
					listener.queryChanged(org.openanzo.ontologies.openanzo.PreconditionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(resultProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(PreconditionListener listener : listeners){
					listener.resultChanged(org.openanzo.ontologies.openanzo.PreconditionImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(datasetProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PreconditionListener listener : listeners){
					listener.datasetChanged(org.openanzo.ontologies.openanzo.PreconditionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(queryProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PreconditionListener listener : listeners){
					listener.queryChanged(org.openanzo.ontologies.openanzo.PreconditionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(resultProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(PreconditionListener listener : listeners){
					listener.resultChanged(org.openanzo.ontologies.openanzo.PreconditionImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}