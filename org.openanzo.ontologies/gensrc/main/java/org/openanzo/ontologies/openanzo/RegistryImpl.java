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
 * Implementation of {@link org.openanzo.ontologies.openanzo.Registry}
 * Use the org.openanzo.ontologies.openanzo.AnzoFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#Registry)</p>
 * <br>
 */
public class RegistryImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.openanzo.Registry {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI includeMetadataGraphsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#includeMetadataGraphs");
	protected static final org.openanzo.rdf.URI defaultGraphProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#defaultGraph");
	protected static final org.openanzo.rdf.URI defaultNamedGraphProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#defaultNamedGraph");
	protected static final org.openanzo.rdf.URI namedGraphProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#namedGraph");
	protected static final org.openanzo.rdf.URI registeredTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#registeredType");

	RegistryImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static RegistryImpl getRegistry(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Registry.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new RegistryImpl(resource, namedGraphUri, dataset);
	}
	    
	static RegistryImpl createRegistry(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		RegistryImpl impl = new RegistryImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Registry.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Registry.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.Dataset.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.Dataset.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, includeMetadataGraphsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, defaultGraphProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, defaultNamedGraphProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, namedGraphProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, registeredTypeProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.Registry.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.Dataset.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'includeMetadataGraphs'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearIncludeMetadataGraphs(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, includeMetadataGraphsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#includeMetadataGraphs
	public java.lang.Boolean getIncludeMetadataGraphs(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, includeMetadataGraphsProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": includeMetadataGraphs getProperty() in org.openanzo.ontologies.openanzo.Registry model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal includeMetadataGraphs in Registry is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getIncludeMetadataGraphs() throws org.openanzo.rdf.jastor.JastorException {
		return getIncludeMetadataGraphs(false);
	}
	
	public void setIncludeMetadataGraphs(java.lang.Boolean includeMetadataGraphs) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, includeMetadataGraphsProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (includeMetadataGraphs != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(includeMetadataGraphs,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, includeMetadataGraphsProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'defaultGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDefaultGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, defaultGraphProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#defaultGraph

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.NamedGraph> propertyCollectionDefaultGraph = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.NamedGraph>() {
		public org.openanzo.ontologies.openanzo.NamedGraph getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.openanzo.NamedGraph 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getDefaultGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDefaultGraph.getPropertyCollection(_dataset, _graph, _resource,defaultGraphProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.NamedGraph  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getDefaultGraph() throws org.openanzo.rdf.jastor.JastorException {
		return getDefaultGraph(false);
	}

/**
     * 
     * @param defaultGraph value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addDefaultGraph(org.openanzo.ontologies.openanzo.NamedGraph defaultGraph) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, defaultGraphProperty,defaultGraph.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.NamedGraph addDefaultGraph() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.NamedGraph defaultGraph = org.openanzo.ontologies.openanzo.AnzoFactory.createNamedGraph(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultGraphProperty,defaultGraph.resource(),_graph.getNamedGraphUri());
		return defaultGraph;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.NamedGraph addDefaultGraph(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.NamedGraph defaultGraph = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultGraphProperty,defaultGraph.resource(),_graph.getNamedGraphUri());
		return defaultGraph;
	}
	
	/**
	 * Remove object
	 * @param defaultGraph object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDefaultGraph(org.openanzo.ontologies.openanzo.NamedGraph defaultGraph) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, defaultGraphProperty, defaultGraph.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, defaultGraphProperty, defaultGraph.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDefaultGraph(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, defaultGraphProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, defaultGraphProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'defaultNamedGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDefaultNamedGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, defaultNamedGraphProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#defaultNamedGraph

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.NamedGraph> propertyCollectionDefaultNamedGraph = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.NamedGraph>() {
		public org.openanzo.ontologies.openanzo.NamedGraph getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.openanzo.NamedGraph 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getDefaultNamedGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDefaultNamedGraph.getPropertyCollection(_dataset, _graph, _resource,defaultNamedGraphProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.NamedGraph  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getDefaultNamedGraph() throws org.openanzo.rdf.jastor.JastorException {
		return getDefaultNamedGraph(false);
	}

/**
     * 
     * @param defaultNamedGraph value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addDefaultNamedGraph(org.openanzo.ontologies.openanzo.NamedGraph defaultNamedGraph) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, defaultNamedGraphProperty,defaultNamedGraph.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.NamedGraph addDefaultNamedGraph() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.NamedGraph defaultNamedGraph = org.openanzo.ontologies.openanzo.AnzoFactory.createNamedGraph(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultNamedGraphProperty,defaultNamedGraph.resource(),_graph.getNamedGraphUri());
		return defaultNamedGraph;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.NamedGraph addDefaultNamedGraph(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.NamedGraph defaultNamedGraph = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultNamedGraphProperty,defaultNamedGraph.resource(),_graph.getNamedGraphUri());
		return defaultNamedGraph;
	}
	
	/**
	 * Remove object
	 * @param defaultNamedGraph object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDefaultNamedGraph(org.openanzo.ontologies.openanzo.NamedGraph defaultNamedGraph) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, defaultNamedGraphProperty, defaultNamedGraph.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, defaultNamedGraphProperty, defaultNamedGraph.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDefaultNamedGraph(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, defaultNamedGraphProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, defaultNamedGraphProperty, resource,_graph.getNamedGraphUri());
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
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#namedGraph

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.NamedGraph> propertyCollectionNamedGraph = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.NamedGraph>() {
		public org.openanzo.ontologies.openanzo.NamedGraph getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.openanzo.NamedGraph 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getNamedGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionNamedGraph.getPropertyCollection(_dataset, _graph, _resource,namedGraphProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.NamedGraph  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getNamedGraph() throws org.openanzo.rdf.jastor.JastorException {
		return getNamedGraph(false);
	}

/**
     * 
     * @param namedGraph value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addNamedGraph(org.openanzo.ontologies.openanzo.NamedGraph namedGraph) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, namedGraphProperty,namedGraph.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.NamedGraph addNamedGraph() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.NamedGraph namedGraph = org.openanzo.ontologies.openanzo.AnzoFactory.createNamedGraph(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, namedGraphProperty,namedGraph.resource(),_graph.getNamedGraphUri());
		return namedGraph;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.NamedGraph addNamedGraph(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.NamedGraph namedGraph = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, namedGraphProperty,namedGraph.resource(),_graph.getNamedGraphUri());
		return namedGraph;
	}
	
	/**
	 * Remove object
	 * @param namedGraph object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeNamedGraph(org.openanzo.ontologies.openanzo.NamedGraph namedGraph) throws org.openanzo.rdf.jastor.JastorException {
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
 
	/**
	 * Clears all values for 'registeredType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRegisteredType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, registeredTypeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#registeredType

	public org.openanzo.rdf.jastor.Thing getRegisteredType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, registeredTypeProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": registeredType getProperty() in org.openanzo.ontologies.openanzo.Registry model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.ThingFactory.getThing(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.Thing getRegisteredType() throws org.openanzo.rdf.jastor.JastorException {
		return getRegisteredType(false);
	}

	public void setRegisteredType(org.openanzo.rdf.jastor.Thing registeredType) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, registeredTypeProperty, null,_graph.getNamedGraphUri());
		if (registeredType != null) {
			_dataset.add(_resource, registeredTypeProperty, registeredType.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.Thing setRegisteredType() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, registeredTypeProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.Thing registeredType = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, registeredTypeProperty, registeredType.resource(),_graph.getNamedGraphUri());
		return registeredType;
	}
	
	public org.openanzo.rdf.jastor.Thing setRegisteredType(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, registeredTypeProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, registeredTypeProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.Thing registeredType = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, registeredTypeProperty, registeredType.resource(),_graph.getNamedGraphUri());
		return registeredType;
	}
	 


	protected java.util.concurrent.CopyOnWriteArraySet<RegistryListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<RegistryListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof RegistryListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	RegistryListener list = (RegistryListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof RegistryListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		RegistryListener list = (RegistryListener)listener;
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
			if (statement.getPredicate().equals(includeMetadataGraphsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RegistryListener listener : listeners){
					listener.includeMetadataGraphsChanged(org.openanzo.ontologies.openanzo.RegistryImpl.this);
				}			
			}
			if (statement.getPredicate().equals(defaultGraphProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.NamedGraph _defaultGraph = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_defaultGraph != null) {
					for(RegistryListener listener : listeners){
						listener.defaultGraphAdded(org.openanzo.ontologies.openanzo.RegistryImpl.this,_defaultGraph);
					}
				}			
			}
			if (statement.getPredicate().equals(defaultNamedGraphProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.NamedGraph _defaultNamedGraph = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_defaultNamedGraph != null) {
					for(RegistryListener listener : listeners){
						listener.defaultNamedGraphAdded(org.openanzo.ontologies.openanzo.RegistryImpl.this,_defaultNamedGraph);
					}
				}			
			}
			if (statement.getPredicate().equals(namedGraphProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.NamedGraph _namedGraph = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_namedGraph != null) {
					for(RegistryListener listener : listeners){
						listener.namedGraphAdded(org.openanzo.ontologies.openanzo.RegistryImpl.this,_namedGraph);
					}
				}			
			}
			if (statement.getPredicate().equals(registeredTypeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(RegistryListener listener : listeners){
					listener.registeredTypeChanged(org.openanzo.ontologies.openanzo.RegistryImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(includeMetadataGraphsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RegistryListener listener : listeners) {
					listener.includeMetadataGraphsChanged(org.openanzo.ontologies.openanzo.RegistryImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(defaultGraphProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.NamedGraph _defaultGraph = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_defaultGraph != null) {
					for(RegistryListener listener : listeners){
						listener.defaultGraphRemoved(org.openanzo.ontologies.openanzo.RegistryImpl.this,_defaultGraph);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(defaultNamedGraphProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.NamedGraph _defaultNamedGraph = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_defaultNamedGraph != null) {
					for(RegistryListener listener : listeners){
						listener.defaultNamedGraphRemoved(org.openanzo.ontologies.openanzo.RegistryImpl.this,_defaultNamedGraph);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(namedGraphProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.NamedGraph _namedGraph = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_namedGraph != null) {
					for(RegistryListener listener : listeners){
						listener.namedGraphRemoved(org.openanzo.ontologies.openanzo.RegistryImpl.this,_namedGraph);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(registeredTypeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(RegistryListener listener : listeners){
					listener.registeredTypeChanged(org.openanzo.ontologies.openanzo.RegistryImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}