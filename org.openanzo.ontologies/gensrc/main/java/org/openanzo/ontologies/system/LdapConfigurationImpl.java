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
 * Implementation of {@link org.openanzo.ontologies.system.LdapConfiguration}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#LdapConfiguration)</p>
 * <br>
 */
public class LdapConfigurationImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.LdapConfiguration {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI credentialsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#credentials");
	protected static final org.openanzo.rdf.URI classNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#className");
	protected static final org.openanzo.rdf.URI enabledProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#enabled");
	protected static final org.openanzo.rdf.URI initOrderProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#initOrder");
	protected static final org.openanzo.rdf.URI dependencyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dependency");
	protected static final org.openanzo.rdf.URI networkTimeoutProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#networkTimeout");
	protected static final org.openanzo.rdf.URI connectionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#connection");
	protected static final org.openanzo.rdf.URI dnToUriTemplateProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dnToUriTemplate");
	protected static final org.openanzo.rdf.URI ldapCNProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapCN");
	protected static final org.openanzo.rdf.URI ldapIdProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapId");
	protected static final org.openanzo.rdf.URI ldapInitFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapInitFile");
	protected static final org.openanzo.rdf.URI ldapInternalCredentialsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapInternalCredentials");
	protected static final org.openanzo.rdf.URI ldapInternalPrincipalProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapInternalPrincipal");
	protected static final org.openanzo.rdf.URI ldapOProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapO");
	protected static final org.openanzo.rdf.URI ldapSearchBaseDNProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapSearchBaseDN");
	protected static final org.openanzo.rdf.URI ldapSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapSuffix");
	protected static final org.openanzo.rdf.URI ldapUseInternalProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapUseInternal");
	protected static final org.openanzo.rdf.URI roleBaseDNProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#roleBaseDN");
	protected static final org.openanzo.rdf.URI rolesSearchProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#rolesSearch");
	protected static final org.openanzo.rdf.URI sysadminRoleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#sysadminRole");
	protected static final org.openanzo.rdf.URI userBaseDNProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#userBaseDN");
	protected static final org.openanzo.rdf.URI userIdAttributeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#userIdAttribute");
	protected static final org.openanzo.rdf.URI userSearchProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#userSearch");

	LdapConfigurationImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static LdapConfigurationImpl getLdapConfiguration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, LdapConfiguration.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new LdapConfigurationImpl(resource, namedGraphUri, dataset);
	}
	    
	static LdapConfigurationImpl createLdapConfiguration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		LdapConfigurationImpl impl = new LdapConfigurationImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, LdapConfiguration.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, LdapConfiguration.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Component.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Component.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.NetworkComponent.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.NetworkComponent.TYPE,_graph.getNamedGraphUri());     
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
		
		list.addAll(_dataset.find(_resource, networkTimeoutProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, connectionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dnToUriTemplateProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ldapCNProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ldapIdProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ldapInitFileProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ldapInternalCredentialsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ldapInternalPrincipalProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ldapOProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ldapSearchBaseDNProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ldapSuffixProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ldapUseInternalProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, roleBaseDNProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, rolesSearchProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, sysadminRoleProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, userBaseDNProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, userIdAttributeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, userSearchProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.LdapConfiguration.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Component.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.NetworkComponent.TYPE, _graph.getNamedGraphUri()));
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": credentials getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Resource", statement.getObject());
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": className getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal className in LdapConfiguration is not of type java.lang.String", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": enabled getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal enabled in LdapConfiguration is not of type java.lang.Boolean", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": initOrder getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal initOrder in LdapConfiguration is not of type java.lang.Integer", literal);
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
	 * Clears all values for 'networkTimeout'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearNetworkTimeout(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, networkTimeoutProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#networkTimeout
	public java.lang.Long getNetworkTimeout(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, networkTimeoutProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": networkTimeout getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal networkTimeout in LdapConfiguration is not of type java.lang.Long", literal);
		return (java.lang.Long)obj;
		
	}
	
	public java.lang.Long getNetworkTimeout() throws org.openanzo.rdf.jastor.JastorException {
		return getNetworkTimeout(false);
	}
	
	public void setNetworkTimeout(java.lang.Long networkTimeout) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, networkTimeoutProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (networkTimeout != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(networkTimeout,"http://www.w3.org/2001/XMLSchema#long");
			_dataset.add(_resource, networkTimeoutProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'connection'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearConnection(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, connectionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#connection

	public org.openanzo.ontologies.system.NetworkConnection getConnection(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, connectionProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": connection getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getNetworkConnection(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.NetworkConnection getConnection() throws org.openanzo.rdf.jastor.JastorException {
		return getConnection(false);
	}

	public void setConnection(org.openanzo.ontologies.system.NetworkConnection connection) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, connectionProperty, null,_graph.getNamedGraphUri());
		if (connection != null) {
			_dataset.add(_resource, connectionProperty, connection.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.NetworkConnection setConnection() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, connectionProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.NetworkConnection connection = org.openanzo.ontologies.system.SystemFactory.createNetworkConnection(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, connectionProperty, connection.resource(),_graph.getNamedGraphUri());
		return connection;
	}
	
	public org.openanzo.ontologies.system.NetworkConnection setConnection(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, connectionProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, connectionProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.NetworkConnection connection = org.openanzo.ontologies.system.SystemFactory.getNetworkConnection(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, connectionProperty, connection.resource(),_graph.getNamedGraphUri());
		return connection;
	}
	
	/**
	 * Clears all values for 'dnToUriTemplate'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDnToUriTemplate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dnToUriTemplateProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#dnToUriTemplate
	public java.lang.String getDnToUriTemplate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, dnToUriTemplateProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dnToUriTemplate getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal dnToUriTemplate in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDnToUriTemplate() throws org.openanzo.rdf.jastor.JastorException {
		return getDnToUriTemplate(false);
	}
	
	public void setDnToUriTemplate(java.lang.String dnToUriTemplate) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dnToUriTemplateProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (dnToUriTemplate != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(dnToUriTemplate,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, dnToUriTemplateProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ldapCN'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLdapCN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ldapCNProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ldapCN
	public java.lang.String getLdapCN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ldapCNProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ldapCN getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ldapCN in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getLdapCN() throws org.openanzo.rdf.jastor.JastorException {
		return getLdapCN(false);
	}
	
	public void setLdapCN(java.lang.String ldapCN) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ldapCNProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ldapCN != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ldapCN,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, ldapCNProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ldapId'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLdapId(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ldapIdProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ldapId
	public java.lang.String getLdapId(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ldapIdProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ldapId getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ldapId in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getLdapId() throws org.openanzo.rdf.jastor.JastorException {
		return getLdapId(false);
	}
	
	public void setLdapId(java.lang.String ldapId) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ldapIdProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ldapId != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ldapId,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, ldapIdProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ldapInitFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLdapInitFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ldapInitFileProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ldapInitFile
	public java.lang.String getLdapInitFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ldapInitFileProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ldapInitFile getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ldapInitFile in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getLdapInitFile() throws org.openanzo.rdf.jastor.JastorException {
		return getLdapInitFile(false);
	}
	
	public void setLdapInitFile(java.lang.String ldapInitFile) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ldapInitFileProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ldapInitFile != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ldapInitFile,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, ldapInitFileProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ldapInternalCredentials'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLdapInternalCredentials(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ldapInternalCredentialsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ldapInternalCredentials
	public java.lang.String getLdapInternalCredentials(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ldapInternalCredentialsProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ldapInternalCredentials getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ldapInternalCredentials in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getLdapInternalCredentials() throws org.openanzo.rdf.jastor.JastorException {
		return getLdapInternalCredentials(false);
	}
	
	public void setLdapInternalCredentials(java.lang.String ldapInternalCredentials) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ldapInternalCredentialsProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ldapInternalCredentials != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ldapInternalCredentials,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, ldapInternalCredentialsProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ldapInternalPrincipal'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLdapInternalPrincipal(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ldapInternalPrincipalProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ldapInternalPrincipal
	public java.lang.String getLdapInternalPrincipal(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ldapInternalPrincipalProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ldapInternalPrincipal getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ldapInternalPrincipal in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getLdapInternalPrincipal() throws org.openanzo.rdf.jastor.JastorException {
		return getLdapInternalPrincipal(false);
	}
	
	public void setLdapInternalPrincipal(java.lang.String ldapInternalPrincipal) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ldapInternalPrincipalProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ldapInternalPrincipal != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ldapInternalPrincipal,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, ldapInternalPrincipalProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ldapO'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLdapO(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ldapOProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ldapO
	public java.lang.String getLdapO(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ldapOProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ldapO getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ldapO in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getLdapO() throws org.openanzo.rdf.jastor.JastorException {
		return getLdapO(false);
	}
	
	public void setLdapO(java.lang.String ldapO) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ldapOProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ldapO != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ldapO,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, ldapOProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ldapSearchBaseDN'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLdapSearchBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ldapSearchBaseDNProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ldapSearchBaseDN
	public java.lang.String getLdapSearchBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ldapSearchBaseDNProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ldapSearchBaseDN getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ldapSearchBaseDN in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getLdapSearchBaseDN() throws org.openanzo.rdf.jastor.JastorException {
		return getLdapSearchBaseDN(false);
	}
	
	public void setLdapSearchBaseDN(java.lang.String ldapSearchBaseDN) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ldapSearchBaseDNProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ldapSearchBaseDN != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ldapSearchBaseDN,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, ldapSearchBaseDNProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ldapSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLdapSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ldapSuffixProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ldapSuffix
	public java.lang.String getLdapSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ldapSuffixProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ldapSuffix getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ldapSuffix in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getLdapSuffix() throws org.openanzo.rdf.jastor.JastorException {
		return getLdapSuffix(false);
	}
	
	public void setLdapSuffix(java.lang.String ldapSuffix) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ldapSuffixProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ldapSuffix != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ldapSuffix,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, ldapSuffixProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ldapUseInternal'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLdapUseInternal(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ldapUseInternalProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#ldapUseInternal
	public java.lang.Boolean getLdapUseInternal(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ldapUseInternalProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ldapUseInternal getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ldapUseInternal in LdapConfiguration is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getLdapUseInternal() throws org.openanzo.rdf.jastor.JastorException {
		return getLdapUseInternal(false);
	}
	
	public void setLdapUseInternal(java.lang.Boolean ldapUseInternal) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ldapUseInternalProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ldapUseInternal != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ldapUseInternal,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, ldapUseInternalProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'roleBaseDN'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRoleBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, roleBaseDNProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#roleBaseDN
	public java.lang.String getRoleBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, roleBaseDNProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": roleBaseDN getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal roleBaseDN in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getRoleBaseDN() throws org.openanzo.rdf.jastor.JastorException {
		return getRoleBaseDN(false);
	}
	
	public void setRoleBaseDN(java.lang.String roleBaseDN) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, roleBaseDNProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (roleBaseDN != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(roleBaseDN,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, roleBaseDNProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'rolesSearch'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRolesSearch(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, rolesSearchProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#rolesSearch
	public java.lang.String getRolesSearch(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, rolesSearchProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": rolesSearch getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal rolesSearch in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getRolesSearch() throws org.openanzo.rdf.jastor.JastorException {
		return getRolesSearch(false);
	}
	
	public void setRolesSearch(java.lang.String rolesSearch) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, rolesSearchProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (rolesSearch != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(rolesSearch,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, rolesSearchProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'sysadminRole'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSysadminRole(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, sysadminRoleProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#sysadminRole
	public java.lang.String getSysadminRole(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, sysadminRoleProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": sysadminRole getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal sysadminRole in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getSysadminRole() throws org.openanzo.rdf.jastor.JastorException {
		return getSysadminRole(false);
	}
	
	public void setSysadminRole(java.lang.String sysadminRole) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, sysadminRoleProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (sysadminRole != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(sysadminRole,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, sysadminRoleProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'userBaseDN'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUserBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, userBaseDNProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#userBaseDN
	public java.lang.String getUserBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, userBaseDNProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": userBaseDN getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal userBaseDN in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getUserBaseDN() throws org.openanzo.rdf.jastor.JastorException {
		return getUserBaseDN(false);
	}
	
	public void setUserBaseDN(java.lang.String userBaseDN) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, userBaseDNProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (userBaseDN != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(userBaseDN,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, userBaseDNProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'userIdAttribute'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUserIdAttribute(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, userIdAttributeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#userIdAttribute
	public java.lang.String getUserIdAttribute(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, userIdAttributeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": userIdAttribute getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal userIdAttribute in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getUserIdAttribute() throws org.openanzo.rdf.jastor.JastorException {
		return getUserIdAttribute(false);
	}
	
	public void setUserIdAttribute(java.lang.String userIdAttribute) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, userIdAttributeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (userIdAttribute != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(userIdAttribute,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, userIdAttributeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'userSearch'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUserSearch(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, userSearchProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#userSearch
	public java.lang.String getUserSearch(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, userSearchProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": userSearch getProperty() in org.openanzo.ontologies.system.LdapConfiguration model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal userSearch in LdapConfiguration is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getUserSearch() throws org.openanzo.rdf.jastor.JastorException {
		return getUserSearch(false);
	}
	
	public void setUserSearch(java.lang.String userSearch) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, userSearchProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (userSearch != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(userSearch,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, userSearchProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}
 


	protected java.util.concurrent.CopyOnWriteArraySet<LdapConfigurationListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<LdapConfigurationListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof LdapConfigurationListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	LdapConfigurationListener list = (LdapConfigurationListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof LdapConfigurationListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		LdapConfigurationListener list = (LdapConfigurationListener)listener;
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
				for(LdapConfigurationListener listener : listeners){
					listener.credentialsChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(classNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.classNameChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(enabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.enabledChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(initOrderProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.initOrderChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(dependencyProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Component _dependency = org.openanzo.ontologies.system.SystemFactory.getComponent(resource,_graph.getNamedGraphUri(),dataset());
				if (_dependency != null) {
					for(LdapConfigurationListener listener : listeners){
						listener.dependencyAdded(org.openanzo.ontologies.system.LdapConfigurationImpl.this,_dependency);
					}
				}			
			}
			if (statement.getPredicate().equals(networkTimeoutProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.networkTimeoutChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(connectionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(LdapConfigurationListener listener : listeners){
					listener.connectionChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(dnToUriTemplateProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.dnToUriTemplateChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ldapCNProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.ldapCNChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ldapIdProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.ldapIdChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ldapInitFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.ldapInitFileChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ldapInternalCredentialsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.ldapInternalCredentialsChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ldapInternalPrincipalProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.ldapInternalPrincipalChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ldapOProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.ldapOChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ldapSearchBaseDNProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.ldapSearchBaseDNChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ldapSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.ldapSuffixChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ldapUseInternalProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.ldapUseInternalChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(roleBaseDNProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.roleBaseDNChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(rolesSearchProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.rolesSearchChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(sysadminRoleProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.sysadminRoleChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(userBaseDNProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.userBaseDNChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(userIdAttributeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.userIdAttributeChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(userSearchProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners){
					listener.userSearchChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
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
				for(LdapConfigurationListener listener : listeners){
					listener.credentialsChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(classNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.classNameChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(enabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.enabledChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(initOrderProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.initOrderChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(dependencyProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Component _dependency = org.openanzo.ontologies.system.SystemFactory.getComponent(resource,_graph.getNamedGraphUri(),dataset());
				if (_dependency != null) {
					for(LdapConfigurationListener listener : listeners){
						listener.dependencyRemoved(org.openanzo.ontologies.system.LdapConfigurationImpl.this,_dependency);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(networkTimeoutProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.networkTimeoutChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(connectionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(LdapConfigurationListener listener : listeners){
					listener.connectionChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(dnToUriTemplateProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.dnToUriTemplateChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ldapCNProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.ldapCNChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ldapIdProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.ldapIdChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ldapInitFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.ldapInitFileChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ldapInternalCredentialsProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.ldapInternalCredentialsChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ldapInternalPrincipalProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.ldapInternalPrincipalChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ldapOProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.ldapOChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ldapSearchBaseDNProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.ldapSearchBaseDNChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ldapSuffixProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.ldapSuffixChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ldapUseInternalProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.ldapUseInternalChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(roleBaseDNProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.roleBaseDNChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(rolesSearchProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.rolesSearchChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(sysadminRoleProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.sysadminRoleChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(userBaseDNProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.userBaseDNChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(userIdAttributeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.userIdAttributeChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(userSearchProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(LdapConfigurationListener listener : listeners) {
					listener.userSearchChanged(org.openanzo.ontologies.system.LdapConfigurationImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}