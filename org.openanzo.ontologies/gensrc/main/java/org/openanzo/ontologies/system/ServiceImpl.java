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
 * Implementation of {@link org.openanzo.ontologies.system.Service}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#Service)</p>
 * <br>
 */
public class ServiceImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.Service {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI credentialsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#credentials");
	protected static final org.openanzo.rdf.URI classNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#className");
	protected static final org.openanzo.rdf.URI enabledProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#enabled");
	protected static final org.openanzo.rdf.URI initOrderProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#initOrder");
	protected static final org.openanzo.rdf.URI dependencyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dependency");
	protected static final org.openanzo.rdf.URI nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#name");
	protected static final org.openanzo.rdf.URI availableOverJmsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#availableOverJms");
	protected static final org.openanzo.rdf.URI availableOverRestProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#availableOverRest");
	protected static final org.openanzo.rdf.URI availableOverWSProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#availableOverWS");
	protected static final org.openanzo.rdf.URI _interfaceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#interface");
	protected static final org.openanzo.rdf.URI isDatasourceServiceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#isDatasourceService");
	protected static final org.openanzo.rdf.URI jmsQueueNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#jmsQueueName");
	protected static final org.openanzo.rdf.URI operationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#operation");

	ServiceImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static ServiceImpl getService(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Service.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new ServiceImpl(resource, namedGraphUri, dataset);
	}
	    
	static ServiceImpl createService(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		ServiceImpl impl = new ServiceImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Service.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Service.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Component.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Component.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, credentialsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, classNameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, enabledProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, initOrderProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dependencyProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, nameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, availableOverJmsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, availableOverRestProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, availableOverWSProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, _interfaceProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, isDatasourceServiceProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, jmsQueueNameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, operationProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Service.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Component.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'credentials'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCredentials(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, credentialsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#credentials

	public org.openanzo.ontologies.system.Credentials getCredentials(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, credentialsProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": credentials getProperty() in org.openanzo.ontologies.system.Service model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getCredentials(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Credentials getCredentials() throws org.openanzo.rdf.jastor.JastorException {
		return getCredentials(false);
	}

	public void setCredentials(org.openanzo.ontologies.system.Credentials credentials) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, credentialsProperty, null,_graph.getNamedGraphUri());
		if (credentials != null) {
			_dataset.add(_resource, credentialsProperty, credentials.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Credentials setCredentials() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, credentialsProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Credentials credentials = org.openanzo.ontologies.system.SystemFactory.createCredentials(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, credentialsProperty, credentials.resource(),_graph.getNamedGraphUri());
		return credentials;
	}
	
	public org.openanzo.ontologies.system.Credentials setCredentials(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, credentialsProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, credentialsProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Credentials credentials = org.openanzo.ontologies.system.SystemFactory.getCredentials(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, credentialsProperty, credentials.resource(),_graph.getNamedGraphUri());
		return credentials;
	}
	
	/**
	 * Clears all values for 'className'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearClassName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, classNameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#className
	public java.lang.String getClassName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, classNameProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": className getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal className in Service is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getClassName() throws org.openanzo.rdf.jastor.JastorException {
		return getClassName(false);
	}
	
	public void setClassName(java.lang.String className) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, classNameProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (className != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(className,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, classNameProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'enabled'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, enabledProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#enabled
	public java.lang.Boolean getEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, enabledProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": enabled getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal enabled in Service is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getEnabled() throws org.openanzo.rdf.jastor.JastorException {
		return getEnabled(false);
	}
	
	public void setEnabled(java.lang.Boolean enabled) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, enabledProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (enabled != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(enabled,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, enabledProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'initOrder'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearInitOrder(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, initOrderProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#initOrder
	public java.lang.Integer getInitOrder(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, initOrderProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": initOrder getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal initOrder in Service is not of type java.lang.Integer", literal);
		return (java.lang.Integer)obj;
		
	}
	
	public java.lang.Integer getInitOrder() throws org.openanzo.rdf.jastor.JastorException {
		return getInitOrder(false);
	}
	
	public void setInitOrder(java.lang.Integer initOrder) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, initOrderProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (initOrder != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(initOrder,"http://www.w3.org/2001/XMLSchema#int");
			_dataset.add(_resource, initOrderProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'dependency'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDependency(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dependencyProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#dependency

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Component> propertyCollectionDependency = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Component>() {
		public org.openanzo.ontologies.system.Component getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.system.SystemFactory.getComponent((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.system.Component 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Component> getDependency(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDependency.getPropertyCollection(_dataset, _graph, _resource,dependencyProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Component"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.system.Component  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Component> getDependency() throws org.openanzo.rdf.jastor.JastorException {
		return getDependency(false);
	}

/**
     * 
     * @param dependency value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addDependency(org.openanzo.ontologies.system.Component dependency) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, dependencyProperty,dependency.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.system.Component addDependency() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Component dependency = org.openanzo.ontologies.system.SystemFactory.createComponent(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, dependencyProperty,dependency.resource(),_graph.getNamedGraphUri());
		return dependency;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.system.Component addDependency(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Component dependency = org.openanzo.ontologies.system.SystemFactory.getComponent(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, dependencyProperty,dependency.resource(),_graph.getNamedGraphUri());
		return dependency;
	}
	
	/**
	 * Remove object
	 * @param dependency object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDependency(org.openanzo.ontologies.system.Component dependency) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, dependencyProperty, dependency.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, dependencyProperty, dependency.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDependency(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, dependencyProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, dependencyProperty, resource,_graph.getNamedGraphUri());
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": name getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal name in Service is not of type java.lang.String", literal);
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
	 * Clears all values for 'availableOverJms'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAvailableOverJms(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, availableOverJmsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#availableOverJms
	public java.lang.Boolean getAvailableOverJms(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, availableOverJmsProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": availableOverJms getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal availableOverJms in Service is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getAvailableOverJms() throws org.openanzo.rdf.jastor.JastorException {
		return getAvailableOverJms(false);
	}
	
	public void setAvailableOverJms(java.lang.Boolean availableOverJms) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, availableOverJmsProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (availableOverJms != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(availableOverJms,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, availableOverJmsProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'availableOverRest'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAvailableOverRest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, availableOverRestProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#availableOverRest
	public java.lang.Boolean getAvailableOverRest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, availableOverRestProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": availableOverRest getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal availableOverRest in Service is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getAvailableOverRest() throws org.openanzo.rdf.jastor.JastorException {
		return getAvailableOverRest(false);
	}
	
	public void setAvailableOverRest(java.lang.Boolean availableOverRest) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, availableOverRestProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (availableOverRest != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(availableOverRest,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, availableOverRestProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'availableOverWS'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAvailableOverWS(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, availableOverWSProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#availableOverWS
	public java.lang.Boolean getAvailableOverWS(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, availableOverWSProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": availableOverWS getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal availableOverWS in Service is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getAvailableOverWS() throws org.openanzo.rdf.jastor.JastorException {
		return getAvailableOverWS(false);
	}
	
	public void setAvailableOverWS(java.lang.Boolean availableOverWS) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, availableOverWSProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (availableOverWS != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(availableOverWS,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, availableOverWSProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for '_interface'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clear_interface(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, _interfaceProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#interface
	public java.lang.String get_interface(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, _interfaceProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": _interface getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal _interface in Service is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String get_interface() throws org.openanzo.rdf.jastor.JastorException {
		return get_interface(false);
	}
	
	public void set_interface(java.lang.String _interface) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, _interfaceProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (_interface != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(_interface,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, _interfaceProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'isDatasourceService'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearIsDatasourceService(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, isDatasourceServiceProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#isDatasourceService
	public java.lang.Boolean getIsDatasourceService(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, isDatasourceServiceProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": isDatasourceService getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal isDatasourceService in Service is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getIsDatasourceService() throws org.openanzo.rdf.jastor.JastorException {
		return getIsDatasourceService(false);
	}
	
	public void setIsDatasourceService(java.lang.Boolean isDatasourceService) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, isDatasourceServiceProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (isDatasourceService != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(isDatasourceService,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, isDatasourceServiceProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'jmsQueueName'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearJmsQueueName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, jmsQueueNameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#jmsQueueName
	public java.lang.String getJmsQueueName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, jmsQueueNameProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": jmsQueueName getProperty() in org.openanzo.ontologies.system.Service model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal jmsQueueName in Service is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getJmsQueueName() throws org.openanzo.rdf.jastor.JastorException {
		return getJmsQueueName(false);
	}
	
	public void setJmsQueueName(java.lang.String jmsQueueName) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, jmsQueueNameProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (jmsQueueName != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(jmsQueueName,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, jmsQueueNameProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'operation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, operationProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#operation

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Operation> propertyCollectionOperation = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Operation>() {
		public org.openanzo.ontologies.system.Operation getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.system.SystemFactory.getOperation((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.system.Operation 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Operation> getOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionOperation.getPropertyCollection(_dataset, _graph, _resource,operationProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Operation"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.system.Operation  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Operation> getOperation() throws org.openanzo.rdf.jastor.JastorException {
		return getOperation(false);
	}

/**
     * 
     * @param operation value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addOperation(org.openanzo.ontologies.system.Operation operation) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, operationProperty,operation.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.system.Operation addOperation() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Operation operation = org.openanzo.ontologies.system.SystemFactory.createOperation(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, operationProperty,operation.resource(),_graph.getNamedGraphUri());
		return operation;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.system.Operation addOperation(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Operation operation = org.openanzo.ontologies.system.SystemFactory.getOperation(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, operationProperty,operation.resource(),_graph.getNamedGraphUri());
		return operation;
	}
	
	/**
	 * Remove object
	 * @param operation object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeOperation(org.openanzo.ontologies.system.Operation operation) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, operationProperty, operation.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, operationProperty, operation.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeOperation(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, operationProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, operationProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<ServiceListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<ServiceListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ServiceListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	ServiceListener list = (ServiceListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof ServiceListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		ServiceListener list = (ServiceListener)listener;
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
			if (statement.getPredicate().equals(credentialsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(ServiceListener listener : listeners){
					listener.credentialsChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(classNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener.classNameChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(enabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener.enabledChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(initOrderProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener.initOrderChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(dependencyProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Component _dependency = org.openanzo.ontologies.system.SystemFactory.getComponent(resource,_graph.getNamedGraphUri(),dataset());
				if (_dependency != null) {
					for(ServiceListener listener : listeners){
						listener.dependencyAdded(org.openanzo.ontologies.system.ServiceImpl.this,_dependency);
					}
				}			
			}
			if (statement.getPredicate().equals(nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener.nameChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(availableOverJmsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener.availableOverJmsChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(availableOverRestProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener.availableOverRestChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(availableOverWSProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener.availableOverWSChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(_interfaceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener._interfaceChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(isDatasourceServiceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener.isDatasourceServiceChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(jmsQueueNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners){
					listener.jmsQueueNameChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(operationProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Operation _operation = org.openanzo.ontologies.system.SystemFactory.getOperation(resource,_graph.getNamedGraphUri(),dataset());
				if (_operation != null) {
					for(ServiceListener listener : listeners){
						listener.operationAdded(org.openanzo.ontologies.system.ServiceImpl.this,_operation);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(credentialsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(ServiceListener listener : listeners){
					listener.credentialsChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(classNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener.classNameChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(enabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener.enabledChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(initOrderProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener.initOrderChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(dependencyProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Component _dependency = org.openanzo.ontologies.system.SystemFactory.getComponent(resource,_graph.getNamedGraphUri(),dataset());
				if (_dependency != null) {
					for(ServiceListener listener : listeners){
						listener.dependencyRemoved(org.openanzo.ontologies.system.ServiceImpl.this,_dependency);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener.nameChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(availableOverJmsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener.availableOverJmsChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(availableOverRestProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener.availableOverRestChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(availableOverWSProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener.availableOverWSChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(_interfaceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener._interfaceChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(isDatasourceServiceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener.isDatasourceServiceChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(jmsQueueNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(ServiceListener listener : listeners) {
					listener.jmsQueueNameChanged(org.openanzo.ontologies.system.ServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(operationProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Operation _operation = org.openanzo.ontologies.system.SystemFactory.getOperation(resource,_graph.getNamedGraphUri(),dataset());
				if (_operation != null) {
					for(ServiceListener listener : listeners){
						listener.operationRemoved(org.openanzo.ontologies.system.ServiceImpl.this,_operation);
					}
				}
				return;
			}
		}
		}}
	}
	


}