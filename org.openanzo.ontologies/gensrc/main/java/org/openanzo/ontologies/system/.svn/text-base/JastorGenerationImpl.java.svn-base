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
 * Implementation of {@link org.openanzo.ontologies.system.JastorGeneration}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#JastorGeneration)</p>
 * <br>
 */
public class JastorGenerationImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.JastorGeneration {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI destDirProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#destDir");
	protected static final org.openanzo.rdf.URI generateListenersProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#generateListeners");
	protected static final org.openanzo.rdf.URI jastorOntologyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#jastorOntology");

	JastorGenerationImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static JastorGenerationImpl getJastorGeneration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, JastorGeneration.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new JastorGenerationImpl(resource, namedGraphUri, dataset);
	}
	    
	static JastorGenerationImpl createJastorGeneration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		JastorGenerationImpl impl = new JastorGenerationImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, JastorGeneration.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, JastorGeneration.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, destDirProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, generateListenersProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, jastorOntologyProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.JastorGeneration.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'destDir'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDestDir(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, destDirProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#destDir
	public java.lang.String getDestDir(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, destDirProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": destDir getProperty() in org.openanzo.ontologies.system.JastorGeneration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal destDir in JastorGeneration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDestDir() throws org.openanzo.rdf.jastor.JastorException {
		return getDestDir(false);
	}
	
	public void setDestDir(java.lang.String destDir) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, destDirProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (destDir != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(destDir,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, destDirProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'generateListeners'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearGenerateListeners(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, generateListenersProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#generateListeners
	public java.lang.Boolean getGenerateListeners(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, generateListenersProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": generateListeners getProperty() in org.openanzo.ontologies.system.JastorGeneration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal generateListeners in JastorGeneration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getGenerateListeners() throws org.openanzo.rdf.jastor.JastorException {
		return getGenerateListeners(false);
	}
	
	public void setGenerateListeners(java.lang.Boolean generateListeners) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, generateListenersProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (generateListeners != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(generateListeners,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, generateListenersProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'jastorOntology'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearJastorOntology(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, jastorOntologyProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#jastorOntology

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.JastorOntology> propertyCollectionJastorOntology = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.JastorOntology>() {
		public org.openanzo.ontologies.system.JastorOntology getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.system.SystemFactory.getJastorOntology((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.system.JastorOntology 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.JastorOntology> getJastorOntology(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionJastorOntology.getPropertyCollection(_dataset, _graph, _resource,jastorOntologyProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#JastorOntology"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.system.JastorOntology  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.JastorOntology> getJastorOntology() throws org.openanzo.rdf.jastor.JastorException {
		return getJastorOntology(false);
	}

/**
     * 
     * @param jastorOntology value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addJastorOntology(org.openanzo.ontologies.system.JastorOntology jastorOntology) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, jastorOntologyProperty,jastorOntology.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.system.JastorOntology addJastorOntology() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.JastorOntology jastorOntology = org.openanzo.ontologies.system.SystemFactory.createJastorOntology(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, jastorOntologyProperty,jastorOntology.resource(),_graph.getNamedGraphUri());
		return jastorOntology;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.system.JastorOntology addJastorOntology(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.JastorOntology jastorOntology = org.openanzo.ontologies.system.SystemFactory.getJastorOntology(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, jastorOntologyProperty,jastorOntology.resource(),_graph.getNamedGraphUri());
		return jastorOntology;
	}
	
	/**
	 * Remove object
	 * @param jastorOntology object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeJastorOntology(org.openanzo.ontologies.system.JastorOntology jastorOntology) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, jastorOntologyProperty, jastorOntology.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, jastorOntologyProperty, jastorOntology.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeJastorOntology(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, jastorOntologyProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, jastorOntologyProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<JastorGenerationListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<JastorGenerationListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof JastorGenerationListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	JastorGenerationListener list = (JastorGenerationListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof JastorGenerationListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		JastorGenerationListener list = (JastorGenerationListener)listener;
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
			if (statement.getPredicate().equals(destDirProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JastorGenerationListener listener : listeners){
					listener.destDirChanged(org.openanzo.ontologies.system.JastorGenerationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(generateListenersProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JastorGenerationListener listener : listeners){
					listener.generateListenersChanged(org.openanzo.ontologies.system.JastorGenerationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(jastorOntologyProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.JastorOntology _jastorOntology = org.openanzo.ontologies.system.SystemFactory.getJastorOntology(resource,_graph.getNamedGraphUri(),dataset());
				if (_jastorOntology != null) {
					for(JastorGenerationListener listener : listeners){
						listener.jastorOntologyAdded(org.openanzo.ontologies.system.JastorGenerationImpl.this,_jastorOntology);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(destDirProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JastorGenerationListener listener : listeners) {
					listener.destDirChanged(org.openanzo.ontologies.system.JastorGenerationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(generateListenersProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JastorGenerationListener listener : listeners) {
					listener.generateListenersChanged(org.openanzo.ontologies.system.JastorGenerationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(jastorOntologyProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.JastorOntology _jastorOntology = org.openanzo.ontologies.system.SystemFactory.getJastorOntology(resource,_graph.getNamedGraphUri(),dataset());
				if (_jastorOntology != null) {
					for(JastorGenerationListener listener : listeners){
						listener.jastorOntologyRemoved(org.openanzo.ontologies.system.JastorGenerationImpl.this,_jastorOntology);
					}
				}
				return;
			}
		}
		}}
	}
	


}