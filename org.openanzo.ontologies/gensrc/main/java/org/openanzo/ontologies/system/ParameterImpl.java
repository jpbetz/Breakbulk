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
 * Implementation of {@link org.openanzo.ontologies.system.Parameter}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#Parameter)</p>
 * <br>
 */
public class ParameterImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.Parameter {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#name");
	protected static final org.openanzo.rdf.URI nullAllowedProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#nullAllowed");
	protected static final org.openanzo.rdf.URI parameterLocationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#parameterLocation");
	protected static final org.openanzo.rdf.URI typeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#type");

	ParameterImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static ParameterImpl getParameter(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Parameter.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new ParameterImpl(resource, namedGraphUri, dataset);
	}
	    
	static ParameterImpl createParameter(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		ParameterImpl impl = new ParameterImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Parameter.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Parameter.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, nameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, nullAllowedProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, parameterLocationProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, typeProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Parameter.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'name'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, nameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#name
	public java.lang.String getName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, nameProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": name getProperty() in org.openanzo.ontologies.system.Parameter model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal name in Parameter is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getName() throws org.openanzo.rdf.jastor.JastorException {
		return getName(false);
	}
	
	public void setName(java.lang.String name) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nameProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (name != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(name,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, nameProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'nullAllowed'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearNullAllowed(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, nullAllowedProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#nullAllowed
	public java.lang.Boolean getNullAllowed(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, nullAllowedProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": nullAllowed getProperty() in org.openanzo.ontologies.system.Parameter model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal nullAllowed in Parameter is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getNullAllowed() throws org.openanzo.rdf.jastor.JastorException {
		return getNullAllowed(false);
	}
	
	public void setNullAllowed(java.lang.Boolean nullAllowed) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nullAllowedProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (nullAllowed != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(nullAllowed,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, nullAllowedProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'parameterLocation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearParameterLocation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, parameterLocationProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#parameterLocation
	public java.lang.String getParameterLocation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, parameterLocationProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": parameterLocation getProperty() in org.openanzo.ontologies.system.Parameter model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal parameterLocation in Parameter is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getParameterLocation() throws org.openanzo.rdf.jastor.JastorException {
		return getParameterLocation(false);
	}
	
	public void setParameterLocation(java.lang.String parameterLocation) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, parameterLocationProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (parameterLocation != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(parameterLocation,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, parameterLocationProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'type'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, typeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#type

	public org.openanzo.ontologies.system.Type getType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, typeProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": type getProperty() in org.openanzo.ontologies.system.Parameter model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getType(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Type getType() throws org.openanzo.rdf.jastor.JastorException {
		return getType(false);
	}

	public void setType(org.openanzo.ontologies.system.Type type) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, typeProperty, null,_graph.getNamedGraphUri());
		if (type != null) {
			_dataset.add(_resource, typeProperty, type.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Type setType() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, typeProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Type type = org.openanzo.ontologies.system.SystemFactory.createType(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, typeProperty, type.resource(),_graph.getNamedGraphUri());
		return type;
	}
	
	public org.openanzo.ontologies.system.Type setType(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, typeProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, typeProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Type type = org.openanzo.ontologies.system.SystemFactory.getType(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, typeProperty, type.resource(),_graph.getNamedGraphUri());
		return type;
	}
	 


	protected java.util.concurrent.CopyOnWriteArraySet<ParameterListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<ParameterListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ParameterListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	ParameterListener list = (ParameterListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ParameterListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		ParameterListener list = (ParameterListener)listener;
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
			if (statement.getPredicate().equals(nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ParameterListener listener : listeners){
					listener.nameChanged(org.openanzo.ontologies.system.ParameterImpl.this);
				}			
			}
			if (statement.getPredicate().equals(nullAllowedProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ParameterListener listener : listeners){
					listener.nullAllowedChanged(org.openanzo.ontologies.system.ParameterImpl.this);
				}			
			}
			if (statement.getPredicate().equals(parameterLocationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ParameterListener listener : listeners){
					listener.parameterLocationChanged(org.openanzo.ontologies.system.ParameterImpl.this);
				}			
			}
			if (statement.getPredicate().equals(typeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(ParameterListener listener : listeners){
					listener.typeChanged(org.openanzo.ontologies.system.ParameterImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ParameterListener listener : listeners) {
					listener.nameChanged(org.openanzo.ontologies.system.ParameterImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(nullAllowedProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ParameterListener listener : listeners) {
					listener.nullAllowedChanged(org.openanzo.ontologies.system.ParameterImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(parameterLocationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ParameterListener listener : listeners) {
					listener.parameterLocationChanged(org.openanzo.ontologies.system.ParameterImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(typeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(ParameterListener listener : listeners){
					listener.typeChanged(org.openanzo.ontologies.system.ParameterImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}