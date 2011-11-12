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
 * Implementation of {@link org.openanzo.ontologies.system.RDBComponent}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#RDBComponent)</p>
 * <br>
 */
public class RDBComponentImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.RDBComponent {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI credentialsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#credentials");
	protected static final org.openanzo.rdf.URI classNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#className");
	protected static final org.openanzo.rdf.URI enabledProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#enabled");
	protected static final org.openanzo.rdf.URI initOrderProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#initOrder");
	protected static final org.openanzo.rdf.URI dependencyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dependency");
	protected static final org.openanzo.rdf.URI dbTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dbType");
	protected static final org.openanzo.rdf.URI canonicalTableProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#canonicalTable");
	protected static final org.openanzo.rdf.URI clearProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#clear");
	protected static final org.openanzo.rdf.URI clientProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#client");
	protected static final org.openanzo.rdf.URI connectionSetupFunctionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#connectionSetupFunction");
	protected static final org.openanzo.rdf.URI connectionTeardownFunctionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#connectionTeardownFunction");
	protected static final org.openanzo.rdf.URI containerNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#containerName");
	protected static final org.openanzo.rdf.URI dbPasswordProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dbPassword");
	protected static final org.openanzo.rdf.URI dbURLProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dbURL");
	protected static final org.openanzo.rdf.URI dbUserProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dbUser");
	protected static final org.openanzo.rdf.URI initResourceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#initResource");
	protected static final org.openanzo.rdf.URI nodeCacheSizeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#nodeCacheSize");
	protected static final org.openanzo.rdf.URI perUserConnectionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#perUserConnection");
	protected static final org.openanzo.rdf.URI configurationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#configuration");

	RDBComponentImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static RDBComponentImpl getRDBComponent(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, RDBComponent.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new RDBComponentImpl(resource, namedGraphUri, dataset);
	}
	    
	static RDBComponentImpl createRDBComponent(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		RDBComponentImpl impl = new RDBComponentImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, RDBComponent.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, RDBComponent.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, dbTypeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, canonicalTableProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, clearProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, clientProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, connectionSetupFunctionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, connectionTeardownFunctionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, containerNameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dbPasswordProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dbURLProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dbUserProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, initResourceProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, nodeCacheSizeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, perUserConnectionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, configurationProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.RDBComponent.TYPE, _graph.getNamedGraphUri()));
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": credentials getProperty() in org.openanzo.ontologies.system.RDBComponent model not Resource", statement.getObject());
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": className getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal className in RDBComponent is not of type java.lang.String", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": enabled getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal enabled in RDBComponent is not of type java.lang.Boolean", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": initOrder getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal initOrder in RDBComponent is not of type java.lang.Integer", literal);
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
	 * Clears all values for 'dbType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDbType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dbTypeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#dbType
	public java.lang.String getDbType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, dbTypeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dbType getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal dbType in RDBComponent is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDbType() throws org.openanzo.rdf.jastor.JastorException {
		return getDbType(false);
	}
	
	public void setDbType(java.lang.String dbType) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dbTypeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (dbType != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(dbType,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, dbTypeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'canonicalTable'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCanonicalTable(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, canonicalTableProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#canonicalTable
	public java.lang.String getCanonicalTable(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, canonicalTableProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": canonicalTable getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal canonicalTable in RDBComponent is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getCanonicalTable() throws org.openanzo.rdf.jastor.JastorException {
		return getCanonicalTable(false);
	}
	
	public void setCanonicalTable(java.lang.String canonicalTable) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, canonicalTableProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (canonicalTable != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(canonicalTable,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, canonicalTableProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'clear'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearClear(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, clearProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#clear
	public java.lang.Boolean getClear(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, clearProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": clear getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal clear in RDBComponent is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getClear() throws org.openanzo.rdf.jastor.JastorException {
		return getClear(false);
	}
	
	public void setClear(java.lang.Boolean clear) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, clearProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (clear != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(clear,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, clearProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'client'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearClient(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, clientProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#client
	public java.lang.Boolean getClient(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, clientProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": client getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal client in RDBComponent is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getClient() throws org.openanzo.rdf.jastor.JastorException {
		return getClient(false);
	}
	
	public void setClient(java.lang.Boolean client) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, clientProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (client != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(client,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, clientProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'connectionSetupFunction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearConnectionSetupFunction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, connectionSetupFunctionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#connectionSetupFunction


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionConnectionSetupFunction = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/System#connectionSetupFunction properties in RDBComponent model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getConnectionSetupFunction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionConnectionSetupFunction.getPropertyCollection(_dataset, _graph, _resource,connectionSetupFunctionProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getConnectionSetupFunction() throws org.openanzo.rdf.jastor.JastorException {
		return getConnectionSetupFunction(false);
	}

	public void addConnectionSetupFunction(java.lang.String connectionSetupFunction) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(connectionSetupFunction,"http://www.w3.org/2001/XMLSchema#string");
		//if (_dataset.contains(_resource, connectionSetupFunctionProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (connectionSetupFunction != null) {
			_dataset.add(_resource, connectionSetupFunctionProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeConnectionSetupFunction(java.lang.String connectionSetupFunction) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(connectionSetupFunction,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, connectionSetupFunctionProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, connectionSetupFunctionProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'connectionTeardownFunction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearConnectionTeardownFunction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, connectionTeardownFunctionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#connectionTeardownFunction


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionConnectionTeardownFunction = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/System#connectionTeardownFunction properties in RDBComponent model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getConnectionTeardownFunction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionConnectionTeardownFunction.getPropertyCollection(_dataset, _graph, _resource,connectionTeardownFunctionProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getConnectionTeardownFunction() throws org.openanzo.rdf.jastor.JastorException {
		return getConnectionTeardownFunction(false);
	}

	public void addConnectionTeardownFunction(java.lang.String connectionTeardownFunction) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(connectionTeardownFunction,"http://www.w3.org/2001/XMLSchema#string");
		//if (_dataset.contains(_resource, connectionTeardownFunctionProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (connectionTeardownFunction != null) {
			_dataset.add(_resource, connectionTeardownFunctionProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeConnectionTeardownFunction(java.lang.String connectionTeardownFunction) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(connectionTeardownFunction,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, connectionTeardownFunctionProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, connectionTeardownFunctionProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'containerName'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearContainerName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, containerNameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#containerName
	public java.lang.String getContainerName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, containerNameProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": containerName getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal containerName in RDBComponent is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getContainerName() throws org.openanzo.rdf.jastor.JastorException {
		return getContainerName(false);
	}
	
	public void setContainerName(java.lang.String containerName) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, containerNameProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (containerName != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(containerName,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, containerNameProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'dbPassword'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDbPassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dbPasswordProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#dbPassword
	public java.lang.String getDbPassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, dbPasswordProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dbPassword getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal dbPassword in RDBComponent is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDbPassword() throws org.openanzo.rdf.jastor.JastorException {
		return getDbPassword(false);
	}
	
	public void setDbPassword(java.lang.String dbPassword) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dbPasswordProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (dbPassword != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(dbPassword,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, dbPasswordProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'dbURL'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDbURL(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dbURLProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#dbURL
	public java.lang.String getDbURL(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, dbURLProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dbURL getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal dbURL in RDBComponent is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDbURL() throws org.openanzo.rdf.jastor.JastorException {
		return getDbURL(false);
	}
	
	public void setDbURL(java.lang.String dbURL) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dbURLProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (dbURL != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(dbURL,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, dbURLProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'dbUser'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDbUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dbUserProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#dbUser
	public java.lang.String getDbUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, dbUserProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dbUser getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal dbUser in RDBComponent is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDbUser() throws org.openanzo.rdf.jastor.JastorException {
		return getDbUser(false);
	}
	
	public void setDbUser(java.lang.String dbUser) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dbUserProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (dbUser != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(dbUser,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, dbUserProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'initResource'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearInitResource(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, initResourceProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#initResource


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionInitResource = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/System#initResource properties in RDBComponent model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getInitResource(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionInitResource.getPropertyCollection(_dataset, _graph, _resource,initResourceProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getInitResource() throws org.openanzo.rdf.jastor.JastorException {
		return getInitResource(false);
	}

	public void addInitResource(java.lang.String initResource) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(initResource,"http://www.w3.org/2001/XMLSchema#string");
		//if (_dataset.contains(_resource, initResourceProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (initResource != null) {
			_dataset.add(_resource, initResourceProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeInitResource(java.lang.String initResource) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(initResource,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, initResourceProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, initResourceProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'nodeCacheSize'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearNodeCacheSize(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, nodeCacheSizeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#nodeCacheSize
	public java.lang.Integer getNodeCacheSize(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, nodeCacheSizeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": nodeCacheSize getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal nodeCacheSize in RDBComponent is not of type java.lang.Integer", literal);
		return (java.lang.Integer)obj;
		
	}
	
	public java.lang.Integer getNodeCacheSize() throws org.openanzo.rdf.jastor.JastorException {
		return getNodeCacheSize(false);
	}
	
	public void setNodeCacheSize(java.lang.Integer nodeCacheSize) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nodeCacheSizeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (nodeCacheSize != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(nodeCacheSize,"http://www.w3.org/2001/XMLSchema#int");
			_dataset.add(_resource, nodeCacheSizeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'perUserConnection'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPerUserConnection(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, perUserConnectionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#perUserConnection
	public java.lang.Boolean getPerUserConnection(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, perUserConnectionProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": perUserConnection getProperty() in org.openanzo.ontologies.system.RDBComponent model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal perUserConnection in RDBComponent is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getPerUserConnection() throws org.openanzo.rdf.jastor.JastorException {
		return getPerUserConnection(false);
	}
	
	public void setPerUserConnection(java.lang.Boolean perUserConnection) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, perUserConnectionProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (perUserConnection != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(perUserConnection,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, perUserConnectionProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'configuration'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearConfiguration(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, configurationProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#configuration

	public org.openanzo.ontologies.system.RDBConfiguration getConfiguration(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, configurationProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": configuration getProperty() in org.openanzo.ontologies.system.RDBComponent model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getRDBConfiguration(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.RDBConfiguration getConfiguration() throws org.openanzo.rdf.jastor.JastorException {
		return getConfiguration(false);
	}

	public void setConfiguration(org.openanzo.ontologies.system.RDBConfiguration configuration) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, configurationProperty, null,_graph.getNamedGraphUri());
		if (configuration != null) {
			_dataset.add(_resource, configurationProperty, configuration.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.RDBConfiguration setConfiguration() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, configurationProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.RDBConfiguration configuration = org.openanzo.ontologies.system.SystemFactory.createRDBConfiguration(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, configurationProperty, configuration.resource(),_graph.getNamedGraphUri());
		return configuration;
	}
	
	public org.openanzo.ontologies.system.RDBConfiguration setConfiguration(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, configurationProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, configurationProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.RDBConfiguration configuration = org.openanzo.ontologies.system.SystemFactory.getRDBConfiguration(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, configurationProperty, configuration.resource(),_graph.getNamedGraphUri());
		return configuration;
	}
	 


	protected java.util.concurrent.CopyOnWriteArraySet<RDBComponentListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<RDBComponentListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof RDBComponentListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	RDBComponentListener list = (RDBComponentListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof RDBComponentListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		RDBComponentListener list = (RDBComponentListener)listener;
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
				for(RDBComponentListener listener : listeners){
					listener.credentialsChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(classNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.classNameChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(enabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.enabledChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(initOrderProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.initOrderChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(dependencyProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Component _dependency = org.openanzo.ontologies.system.SystemFactory.getComponent(resource,_graph.getNamedGraphUri(),dataset());
				if (_dependency != null) {
					for(RDBComponentListener listener : listeners){
						listener.dependencyAdded(org.openanzo.ontologies.system.RDBComponentImpl.this,_dependency);
					}
				}			
			}
			if (statement.getPredicate().equals(dbTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.dbTypeChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(canonicalTableProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.canonicalTableChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(clearProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.clearChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(clientProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.clientChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(connectionSetupFunctionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(RDBComponentListener listener : listeners){
						listener.connectionSetupFunctionAdded(org.openanzo.ontologies.system.RDBComponentImpl.this,(java.lang.String)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(connectionTeardownFunctionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(RDBComponentListener listener : listeners){
						listener.connectionTeardownFunctionAdded(org.openanzo.ontologies.system.RDBComponentImpl.this,(java.lang.String)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(containerNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.containerNameChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(dbPasswordProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.dbPasswordChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(dbURLProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.dbURLChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(dbUserProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.dbUserChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(initResourceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(RDBComponentListener listener : listeners){
						listener.initResourceAdded(org.openanzo.ontologies.system.RDBComponentImpl.this,(java.lang.String)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(nodeCacheSizeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.nodeCacheSizeChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(perUserConnectionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners){
					listener.perUserConnectionChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}			
			}
			if (statement.getPredicate().equals(configurationProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(RDBComponentListener listener : listeners){
					listener.configurationChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
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
				for(RDBComponentListener listener : listeners){
					listener.credentialsChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(classNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.classNameChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(enabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.enabledChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(initOrderProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.initOrderChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(dependencyProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Component _dependency = org.openanzo.ontologies.system.SystemFactory.getComponent(resource,_graph.getNamedGraphUri(),dataset());
				if (_dependency != null) {
					for(RDBComponentListener listener : listeners){
						listener.dependencyRemoved(org.openanzo.ontologies.system.RDBComponentImpl.this,_dependency);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(dbTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.dbTypeChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(canonicalTableProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.canonicalTableChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(clearProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.clearChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(clientProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.clientChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(connectionSetupFunctionProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(RDBComponentListener listener : listeners){
						listener.connectionSetupFunctionRemoved(org.openanzo.ontologies.system.RDBComponentImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(connectionTeardownFunctionProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(RDBComponentListener listener : listeners){
						listener.connectionTeardownFunctionRemoved(org.openanzo.ontologies.system.RDBComponentImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(containerNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.containerNameChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(dbPasswordProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.dbPasswordChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(dbURLProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.dbURLChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(dbUserProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.dbUserChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(initResourceProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(RDBComponentListener listener : listeners){
						listener.initResourceRemoved(org.openanzo.ontologies.system.RDBComponentImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(nodeCacheSizeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.nodeCacheSizeChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(perUserConnectionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(RDBComponentListener listener : listeners) {
					listener.perUserConnectionChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(configurationProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(RDBComponentListener listener : listeners){
					listener.configurationChanged(org.openanzo.ontologies.system.RDBComponentImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}