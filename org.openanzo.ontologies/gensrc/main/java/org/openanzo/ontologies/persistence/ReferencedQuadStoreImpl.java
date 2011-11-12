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
 * Implementation of {@link org.openanzo.ontologies.persistence.ReferencedQuadStore}
 * Use the org.openanzo.ontologies.persistence.ClientPersistenceFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedQuadStore)</p>
 * <br>
 */
public class ReferencedQuadStoreImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.persistence.ReferencedQuadStore {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI namedGraphProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#namedGraph");

	ReferencedQuadStoreImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static ReferencedQuadStoreImpl getReferencedQuadStore(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ReferencedQuadStore.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new ReferencedQuadStoreImpl(resource, namedGraphUri, dataset);
	}
	    
	static ReferencedQuadStoreImpl createReferencedQuadStore(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		ReferencedQuadStoreImpl impl = new ReferencedQuadStoreImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ReferencedQuadStore.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ReferencedQuadStore.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, namedGraphProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.persistence.ReferencedQuadStore.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'namedGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearNamedGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, namedGraphProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/ClientPersistence#namedGraph

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.persistence.ReferencedNamedGraph> propertyCollectionNamedGraph = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.persistence.ReferencedNamedGraph>() {
		public org.openanzo.ontologies.persistence.ReferencedNamedGraph getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.persistence.ClientPersistenceFactory.getReferencedNamedGraph((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.persistence.ReferencedNamedGraph 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.persistence.ReferencedNamedGraph> getNamedGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionNamedGraph.getPropertyCollection(_dataset, _graph, _resource,namedGraphProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedNamedGraph"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.persistence.ReferencedNamedGraph  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.persistence.ReferencedNamedGraph> getNamedGraph() throws org.openanzo.rdf.jastor.JastorException {
		return getNamedGraph(false);
	}

/**
     * 
     * @param namedGraph value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addNamedGraph(org.openanzo.ontologies.persistence.ReferencedNamedGraph namedGraph) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, namedGraphProperty,namedGraph.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.persistence.ReferencedNamedGraph addNamedGraph() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.persistence.ReferencedNamedGraph namedGraph = org.openanzo.ontologies.persistence.ClientPersistenceFactory.createReferencedNamedGraph(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, namedGraphProperty,namedGraph.resource(),_graph.getNamedGraphUri());
		return namedGraph;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.persistence.ReferencedNamedGraph addNamedGraph(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.persistence.ReferencedNamedGraph namedGraph = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getReferencedNamedGraph(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, namedGraphProperty,namedGraph.resource(),_graph.getNamedGraphUri());
		return namedGraph;
	}
	
	/**
	 * Remove object
	 * @param namedGraph object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeNamedGraph(org.openanzo.ontologies.persistence.ReferencedNamedGraph namedGraph) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, namedGraphProperty, namedGraph.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, namedGraphProperty, namedGraph.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeNamedGraph(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, namedGraphProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, namedGraphProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<ReferencedQuadStoreListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<ReferencedQuadStoreListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ReferencedQuadStoreListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	ReferencedQuadStoreListener list = (ReferencedQuadStoreListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ReferencedQuadStoreListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		ReferencedQuadStoreListener list = (ReferencedQuadStoreListener)listener;
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
			if (statement.getPredicate().equals(namedGraphProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.persistence.ReferencedNamedGraph _namedGraph = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getReferencedNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_namedGraph != null) {
					for(ReferencedQuadStoreListener listener : listeners){
						listener.namedGraphAdded(org.openanzo.ontologies.persistence.ReferencedQuadStoreImpl.this,_namedGraph);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(namedGraphProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.persistence.ReferencedNamedGraph _namedGraph = org.openanzo.ontologies.persistence.ClientPersistenceFactory.getReferencedNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_namedGraph != null) {
					for(ReferencedQuadStoreListener listener : listeners){
						listener.namedGraphRemoved(org.openanzo.ontologies.persistence.ReferencedQuadStoreImpl.this,_namedGraph);
					}
				}
				return;
			}
		}
		}}
	}
	


}