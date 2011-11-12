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
 * Implementation of {@link org.openanzo.ontologies.persistence.ReferencedNamedGraph}
 * Use the org.openanzo.ontologies.persistence.ClientPersistenceFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedNamedGraph)</p>
 * <br>
 */
public class ReferencedNamedGraphImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.persistence.ReferencedNamedGraph {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI graphUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#graphUri");
	protected static final org.openanzo.rdf.URI referenceUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#referenceUri");

	ReferencedNamedGraphImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static ReferencedNamedGraphImpl getReferencedNamedGraph(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ReferencedNamedGraph.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new ReferencedNamedGraphImpl(resource, namedGraphUri, dataset);
	}
	    
	static ReferencedNamedGraphImpl createReferencedNamedGraph(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		ReferencedNamedGraphImpl impl = new ReferencedNamedGraphImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ReferencedNamedGraph.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ReferencedNamedGraph.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, graphUriProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, referenceUriProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.persistence.ReferencedNamedGraph.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'graphUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, graphUriProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#graphUri

	public org.openanzo.rdf.jastor.Thing getGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, graphUriProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": graphUri getProperty() in org.openanzo.ontologies.persistence.ReferencedNamedGraph model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.ThingFactory.getThing(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.Thing getGraphUri() throws org.openanzo.rdf.jastor.JastorException {
		return getGraphUri(false);
	}

	public void setGraphUri(org.openanzo.rdf.jastor.Thing graphUri) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, graphUriProperty, null,_graph.getNamedGraphUri());
		if (graphUri != null) {
			_dataset.add(_resource, graphUriProperty, graphUri.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.Thing setGraphUri() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, graphUriProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.Thing graphUri = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, graphUriProperty, graphUri.resource(),_graph.getNamedGraphUri());
		return graphUri;
	}
	
	public org.openanzo.rdf.jastor.Thing setGraphUri(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, graphUriProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, graphUriProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.Thing graphUri = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, graphUriProperty, graphUri.resource(),_graph.getNamedGraphUri());
		return graphUri;
	}
	
	/**
	 * Clears all values for 'referenceUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearReferenceUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, referenceUriProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#referenceUri

	public org.openanzo.rdf.jastor.Thing getReferenceUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, referenceUriProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": referenceUri getProperty() in org.openanzo.ontologies.persistence.ReferencedNamedGraph model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.ThingFactory.getThing(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.Thing getReferenceUri() throws org.openanzo.rdf.jastor.JastorException {
		return getReferenceUri(false);
	}

	public void setReferenceUri(org.openanzo.rdf.jastor.Thing referenceUri) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, referenceUriProperty, null,_graph.getNamedGraphUri());
		if (referenceUri != null) {
			_dataset.add(_resource, referenceUriProperty, referenceUri.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.Thing setReferenceUri() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, referenceUriProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.Thing referenceUri = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, referenceUriProperty, referenceUri.resource(),_graph.getNamedGraphUri());
		return referenceUri;
	}
	
	public org.openanzo.rdf.jastor.Thing setReferenceUri(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, referenceUriProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, referenceUriProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.Thing referenceUri = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, referenceUriProperty, referenceUri.resource(),_graph.getNamedGraphUri());
		return referenceUri;
	}
	 


	protected java.util.concurrent.CopyOnWriteArraySet<ReferencedNamedGraphListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<ReferencedNamedGraphListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ReferencedNamedGraphListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	ReferencedNamedGraphListener list = (ReferencedNamedGraphListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ReferencedNamedGraphListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		ReferencedNamedGraphListener list = (ReferencedNamedGraphListener)listener;
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
			if (statement.getPredicate().equals(graphUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(ReferencedNamedGraphListener listener : listeners){
					listener.graphUriChanged(org.openanzo.ontologies.persistence.ReferencedNamedGraphImpl.this);
				}			
			}
			if (statement.getPredicate().equals(referenceUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(ReferencedNamedGraphListener listener : listeners){
					listener.referenceUriChanged(org.openanzo.ontologies.persistence.ReferencedNamedGraphImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(graphUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(ReferencedNamedGraphListener listener : listeners){
					listener.graphUriChanged(org.openanzo.ontologies.persistence.ReferencedNamedGraphImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(referenceUriProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(ReferencedNamedGraphListener listener : listeners){
					listener.referenceUriChanged(org.openanzo.ontologies.persistence.ReferencedNamedGraphImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}