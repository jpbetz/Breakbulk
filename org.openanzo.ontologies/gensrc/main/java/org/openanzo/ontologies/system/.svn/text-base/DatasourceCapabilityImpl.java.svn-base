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
 * Implementation of {@link org.openanzo.ontologies.system.DatasourceCapability}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#DatasourceCapability)</p>
 * <br>
 */
public class DatasourceCapabilityImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.DatasourceCapability {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI capabilityServiceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#capabilityService");

	DatasourceCapabilityImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static DatasourceCapabilityImpl getDatasourceCapability(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, DatasourceCapability.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new DatasourceCapabilityImpl(resource, namedGraphUri, dataset);
	}
	    
	static DatasourceCapabilityImpl createDatasourceCapability(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		DatasourceCapabilityImpl impl = new DatasourceCapabilityImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, DatasourceCapability.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, DatasourceCapability.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, capabilityServiceProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.DatasourceCapability.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'capabilityService'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCapabilityService(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, capabilityServiceProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#capabilityService

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Service> propertyCollectionCapabilityService = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Service>() {
		public org.openanzo.ontologies.system.Service getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.system.SystemFactory.getService((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.system.Service 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Service> getCapabilityService(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCapabilityService.getPropertyCollection(_dataset, _graph, _resource,capabilityServiceProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Service"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.system.Service  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Service> getCapabilityService() throws org.openanzo.rdf.jastor.JastorException {
		return getCapabilityService(false);
	}

/**
     * 
     * @param capabilityService value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addCapabilityService(org.openanzo.ontologies.system.Service capabilityService) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, capabilityServiceProperty,capabilityService.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.system.Service addCapabilityService() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Service capabilityService = org.openanzo.ontologies.system.SystemFactory.createService(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, capabilityServiceProperty,capabilityService.resource(),_graph.getNamedGraphUri());
		return capabilityService;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.system.Service addCapabilityService(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Service capabilityService = org.openanzo.ontologies.system.SystemFactory.getService(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, capabilityServiceProperty,capabilityService.resource(),_graph.getNamedGraphUri());
		return capabilityService;
	}
	
	/**
	 * Remove object
	 * @param capabilityService object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCapabilityService(org.openanzo.ontologies.system.Service capabilityService) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, capabilityServiceProperty, capabilityService.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, capabilityServiceProperty, capabilityService.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCapabilityService(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, capabilityServiceProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, capabilityServiceProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<DatasourceCapabilityListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<DatasourceCapabilityListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof DatasourceCapabilityListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	DatasourceCapabilityListener list = (DatasourceCapabilityListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof DatasourceCapabilityListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		DatasourceCapabilityListener list = (DatasourceCapabilityListener)listener;
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
			if (statement.getPredicate().equals(capabilityServiceProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Service _capabilityService = org.openanzo.ontologies.system.SystemFactory.getService(resource,_graph.getNamedGraphUri(),dataset());
				if (_capabilityService != null) {
					for(DatasourceCapabilityListener listener : listeners){
						listener.capabilityServiceAdded(org.openanzo.ontologies.system.DatasourceCapabilityImpl.this,_capabilityService);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(capabilityServiceProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Service _capabilityService = org.openanzo.ontologies.system.SystemFactory.getService(resource,_graph.getNamedGraphUri(),dataset());
				if (_capabilityService != null) {
					for(DatasourceCapabilityListener listener : listeners){
						listener.capabilityServiceRemoved(org.openanzo.ontologies.system.DatasourceCapabilityImpl.this,_capabilityService);
					}
				}
				return;
			}
		}
		}}
	}
	


}