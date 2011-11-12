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
 * Implementation of {@link org.openanzo.ontologies.system.JastorOntology}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#JastorOntology)</p>
 * <br>
 */
public class JastorOntologyImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.JastorOntology {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI generateProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#generate");
	protected static final org.openanzo.rdf.URI ontologyUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ontologyUri");
	protected static final org.openanzo.rdf.URI _packageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#package");

	JastorOntologyImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static JastorOntologyImpl getJastorOntology(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, JastorOntology.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new JastorOntologyImpl(resource, namedGraphUri, dataset);
	}
	    
	static JastorOntologyImpl createJastorOntology(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		JastorOntologyImpl impl = new JastorOntologyImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, JastorOntology.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, JastorOntology.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, generateProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ontologyUriProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, _packageProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.JastorOntology.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'generate'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearGenerate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, generateProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#generate
	public java.lang.Boolean getGenerate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, generateProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": generate getProperty() in org.openanzo.ontologies.system.JastorOntology model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal generate in JastorOntology is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getGenerate() throws org.openanzo.rdf.jastor.JastorException {
		return getGenerate(false);
	}
	
	public void setGenerate(java.lang.Boolean generate) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, generateProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (generate != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(generate,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, generateProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ontologyUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearOntologyUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ontologyUriProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ontologyUri
	public org.openanzo.rdf.URI getOntologyUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ontologyUriProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;
		if (!(statement.getObject() instanceof org.openanzo.rdf.URI))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ontologyUri getProperty() in org.openanzo.ontologies.system.JastorOntology model not URI", statement.getObject());
		return (org.openanzo.rdf.URI)statement.getObject();
		
	}
	
	public org.openanzo.rdf.URI getOntologyUri() throws org.openanzo.rdf.jastor.JastorException {
		return getOntologyUri(false);
	}
	
	public void setOntologyUri(org.openanzo.rdf.URI ontologyUri) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ontologyUriProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ontologyUri != null) {
	
			_dataset.add(_resource, ontologyUriProperty, ontologyUri,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for '_package'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clear_package(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, _packageProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#package
	public java.lang.String get_package(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, _packageProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": _package getProperty() in org.openanzo.ontologies.system.JastorOntology model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal _package in JastorOntology is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String get_package() throws org.openanzo.rdf.jastor.JastorException {
		return get_package(false);
	}
	
	public void set_package(java.lang.String _package) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, _packageProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (_package != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(_package,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, _packageProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}
 


	protected java.util.concurrent.CopyOnWriteArraySet<JastorOntologyListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<JastorOntologyListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof JastorOntologyListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	JastorOntologyListener list = (JastorOntologyListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof JastorOntologyListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		JastorOntologyListener list = (JastorOntologyListener)listener;
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
			if (statement.getPredicate().equals(generateProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JastorOntologyListener listener : listeners){
					listener.generateChanged(org.openanzo.ontologies.system.JastorOntologyImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ontologyUriProperty)) {
				for(JastorOntologyListener listener : listeners){
					listener.ontologyUriChanged(org.openanzo.ontologies.system.JastorOntologyImpl.this);
				}			
			}
			if (statement.getPredicate().equals(_packageProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JastorOntologyListener listener : listeners){
					listener._packageChanged(org.openanzo.ontologies.system.JastorOntologyImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(generateProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JastorOntologyListener listener : listeners) {
					listener.generateChanged(org.openanzo.ontologies.system.JastorOntologyImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ontologyUriProperty)) {
				for(JastorOntologyListener listener : listeners) {
					listener.ontologyUriChanged(org.openanzo.ontologies.system.JastorOntologyImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(_packageProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JastorOntologyListener listener : listeners) {
					listener._packageChanged(org.openanzo.ontologies.system.JastorOntologyImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}