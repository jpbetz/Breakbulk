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
 * Factory for instantiating objects for ontology classes in the System ontology.  The
 * get methods leave the dataset unchanged and return a Java view of the object in the dataset.  The create methods
 * may add certain baseline properties to the dataset such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	label : Container Components Ontology <br>
 * 	comment : Container Components Ontology. <br>
 * <br>
 * <br>
 *	@version 0.1
 */
public class SystemFactory extends org.openanzo.rdf.jastor.ThingFactory { 


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isAuthorizationRulePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(AuthorizationRuleImpl.uriPatternProperty) ||
			predicate.equals(AuthorizationRuleImpl.privilegeProperty) ||
			predicate.equals(AuthorizationRuleImpl.roleProperty) ;
	}
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AuthorizationRule
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule createAuthorizationRule(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		AuthorizationRule result= org.openanzo.ontologies.system.AuthorizationRuleImpl.createAuthorizationRule(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AuthorizationRule
	 * @param dataset the IDataset containing the data
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule createAuthorizationRule(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createAuthorizationRule(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AuthorizationRule
	 * @param dataset the IDataset containing the data
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule createAuthorizationRule(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAuthorizationRule(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AuthorizationRule
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule createAuthorizationRule(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAuthorizationRule(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AuthorizationRule
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule createAuthorizationRule(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createAuthorizationRule(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AuthorizationRule
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule createAuthorizationRule(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAuthorizationRule(resource, graph);
	}
	
	
	/**
	 * Create a new instance of AuthorizationRule.  Leaves the dataset unchanged.
	 * @param resource The resource of the AuthorizationRule
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule getAuthorizationRule(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.AuthorizationRuleImpl.getAuthorizationRule(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AuthorizationRule
	 * @param dataset the IDataset containing the data
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule getAuthorizationRule(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAuthorizationRule(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AuthorizationRule
	 * @param dataset the IDataset containing the data
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule getAuthorizationRule(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAuthorizationRule(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AuthorizationRule
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule getAuthorizationRule(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAuthorizationRule(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AuthorizationRule
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule getAuthorizationRule(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAuthorizationRule(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AuthorizationRule.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AuthorizationRule
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AuthorizationRule getAuthorizationRule(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAuthorizationRule(resource, graph);
	}
	
	/**
	 * Return an instance of AuthorizationRule for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#AuthorizationRule
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AuthorizationRule> getAllAuthorizationRule(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,AuthorizationRule.TYPE,_namedGraphUri);
		java.util.List<AuthorizationRule> list = new java.util.ArrayList<AuthorizationRule>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getAuthorizationRule(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of AuthorizationRule for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#AuthorizationRule
	 * @param dataset the IDataset containing the data
	 * @return a List of AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AuthorizationRule> getAllAuthorizationRule(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllAuthorizationRule(null, dataset);
	}
	
	/**
	 * Return an instance of AuthorizationRule for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#AuthorizationRule
	 * @param graph the NamedGraph containing the data
	 * @return a List of AuthorizationRule
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AuthorizationRule> getAllAuthorizationRule(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllAuthorizationRule(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isComponentPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ComponentImpl.credentialsProperty) ||
			predicate.equals(ComponentImpl.classNameProperty) ||
			predicate.equals(ComponentImpl.enabledProperty) ||
			predicate.equals(ComponentImpl.initOrderProperty) ||
			predicate.equals(ComponentImpl.dependencyProperty) ;
	}
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Component
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component createComponent(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Component result= org.openanzo.ontologies.system.ComponentImpl.createComponent(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Component
	 * @param dataset the IDataset containing the data
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component createComponent(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createComponent(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Component
	 * @param dataset the IDataset containing the data
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component createComponent(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createComponent(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Component
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component createComponent(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createComponent(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Component
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component createComponent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createComponent(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Component
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component createComponent(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createComponent(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Component.  Leaves the dataset unchanged.
	 * @param resource The resource of the Component
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component getComponent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.ComponentImpl.getComponent(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Component
	 * @param dataset the IDataset containing the data
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component getComponent(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getComponent(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Component
	 * @param dataset the IDataset containing the data
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component getComponent(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getComponent(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Component
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component getComponent(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getComponent(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Component
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component getComponent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getComponent(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Component.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Component
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Component getComponent(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getComponent(resource, graph);
	}
	
	/**
	 * Return an instance of Component for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Component
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Component> getAllComponent(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Component.TYPE,_namedGraphUri);
		java.util.List<Component> list = new java.util.ArrayList<Component>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getComponent(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Component for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Component
	 * @param dataset the IDataset containing the data
	 * @return a List of Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Component> getAllComponent(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllComponent(null, dataset);
	}
	
	/**
	 * Return an instance of Component for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Component
	 * @param graph the NamedGraph containing the data
	 * @return a List of Component
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Component> getAllComponent(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllComponent(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isCredentialsPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(CredentialsImpl.passwordProperty) ||
			predicate.equals(CredentialsImpl.userProperty) ;
	}
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Credentials
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials createCredentials(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Credentials result= org.openanzo.ontologies.system.CredentialsImpl.createCredentials(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Credentials
	 * @param dataset the IDataset containing the data
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials createCredentials(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createCredentials(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Credentials
	 * @param dataset the IDataset containing the data
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials createCredentials(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createCredentials(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Credentials
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials createCredentials(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createCredentials(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Credentials
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials createCredentials(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createCredentials(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Credentials
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials createCredentials(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createCredentials(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Credentials.  Leaves the dataset unchanged.
	 * @param resource The resource of the Credentials
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials getCredentials(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.CredentialsImpl.getCredentials(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Credentials
	 * @param dataset the IDataset containing the data
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials getCredentials(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getCredentials(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Credentials
	 * @param dataset the IDataset containing the data
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials getCredentials(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getCredentials(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Credentials
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials getCredentials(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getCredentials(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Credentials
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials getCredentials(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getCredentials(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Credentials.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Credentials
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Credentials getCredentials(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getCredentials(resource, graph);
	}
	
	/**
	 * Return an instance of Credentials for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Credentials
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Credentials> getAllCredentials(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Credentials.TYPE,_namedGraphUri);
		java.util.List<Credentials> list = new java.util.ArrayList<Credentials>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getCredentials(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Credentials for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Credentials
	 * @param dataset the IDataset containing the data
	 * @return a List of Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Credentials> getAllCredentials(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllCredentials(null, dataset);
	}
	
	/**
	 * Return an instance of Credentials for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Credentials
	 * @param graph the NamedGraph containing the data
	 * @return a List of Credentials
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Credentials> getAllCredentials(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllCredentials(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isDatasourcePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(DatasourceImpl.credentialsProperty) ||
			predicate.equals(DatasourceImpl.classNameProperty) ||
			predicate.equals(DatasourceImpl.enabledProperty) ||
			predicate.equals(DatasourceImpl.initOrderProperty) ||
			predicate.equals(DatasourceImpl.dependencyProperty) ||
			predicate.equals(DatasourceImpl.uriPatternProperty) ||
			predicate.equals(DatasourceImpl.enableCachingProperty) ||
			predicate.equals(DatasourceImpl.enableIndexingProperty) ||
			predicate.equals(DatasourceImpl.isPrimaryProperty) ||
			predicate.equals(DatasourceImpl.resetEnabledProperty) ||
			predicate.equals(DatasourceImpl.authorizationRuleProperty) ||
			predicate.equals(DatasourceImpl.datasourceCapabilityProperty) ;
	}
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datasource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource createDatasource(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Datasource result= org.openanzo.ontologies.system.DatasourceImpl.createDatasource(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datasource
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource createDatasource(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createDatasource(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datasource
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource createDatasource(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatasource(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datasource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource createDatasource(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatasource(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datasource
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource createDatasource(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createDatasource(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datasource
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource createDatasource(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatasource(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Datasource.  Leaves the dataset unchanged.
	 * @param resource The resource of the Datasource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource getDatasource(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.DatasourceImpl.getDatasource(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datasource
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource getDatasource(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getDatasource(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datasource
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource getDatasource(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatasource(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datasource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource getDatasource(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatasource(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datasource
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource getDatasource(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getDatasource(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Datasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datasource
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datasource getDatasource(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatasource(resource, graph);
	}
	
	/**
	 * Return an instance of Datasource for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Datasource
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Datasource> getAllDatasource(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Datasource.TYPE,_namedGraphUri);
		java.util.List<Datasource> list = new java.util.ArrayList<Datasource>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getDatasource(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Datasource for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Datasource
	 * @param dataset the IDataset containing the data
	 * @return a List of Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Datasource> getAllDatasource(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllDatasource(null, dataset);
	}
	
	/**
	 * Return an instance of Datasource for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Datasource
	 * @param graph the NamedGraph containing the data
	 * @return a List of Datasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Datasource> getAllDatasource(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllDatasource(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isDatasourceCapabilityPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(DatasourceCapabilityImpl.capabilityServiceProperty) ;
	}
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasourceCapability
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability createDatasourceCapability(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		DatasourceCapability result= org.openanzo.ontologies.system.DatasourceCapabilityImpl.createDatasourceCapability(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasourceCapability
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability createDatasourceCapability(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createDatasourceCapability(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasourceCapability
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability createDatasourceCapability(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatasourceCapability(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasourceCapability
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability createDatasourceCapability(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatasourceCapability(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasourceCapability
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability createDatasourceCapability(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createDatasourceCapability(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasourceCapability
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability createDatasourceCapability(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatasourceCapability(resource, graph);
	}
	
	
	/**
	 * Create a new instance of DatasourceCapability.  Leaves the dataset unchanged.
	 * @param resource The resource of the DatasourceCapability
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability getDatasourceCapability(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.DatasourceCapabilityImpl.getDatasourceCapability(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasourceCapability
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability getDatasourceCapability(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getDatasourceCapability(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasourceCapability
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability getDatasourceCapability(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatasourceCapability(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasourceCapability
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability getDatasourceCapability(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatasourceCapability(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasourceCapability
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability getDatasourceCapability(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getDatasourceCapability(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DatasourceCapability.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasourceCapability
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasourceCapability getDatasourceCapability(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatasourceCapability(resource, graph);
	}
	
	/**
	 * Return an instance of DatasourceCapability for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#DatasourceCapability
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DatasourceCapability> getAllDatasourceCapability(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,DatasourceCapability.TYPE,_namedGraphUri);
		java.util.List<DatasourceCapability> list = new java.util.ArrayList<DatasourceCapability>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getDatasourceCapability(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of DatasourceCapability for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#DatasourceCapability
	 * @param dataset the IDataset containing the data
	 * @return a List of DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DatasourceCapability> getAllDatasourceCapability(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllDatasourceCapability(null, dataset);
	}
	
	/**
	 * Return an instance of DatasourceCapability for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#DatasourceCapability
	 * @param graph the NamedGraph containing the data
	 * @return a List of DatasourceCapability
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DatasourceCapability> getAllDatasourceCapability(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllDatasourceCapability(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isStatisticsProviderPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(StatisticsProviderImpl.titleProperty) ||
			predicate.equals(StatisticsProviderImpl.descriptionProperty) ||
			predicate.equals(StatisticsProviderImpl.statisticsEnabledProperty) ||
			predicate.equals(StatisticsProviderImpl.statisticProperty) ;
	}
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatisticsProvider
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider createStatisticsProvider(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		StatisticsProvider result= org.openanzo.ontologies.system.StatisticsProviderImpl.createStatisticsProvider(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatisticsProvider
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider createStatisticsProvider(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createStatisticsProvider(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatisticsProvider
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider createStatisticsProvider(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createStatisticsProvider(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatisticsProvider
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider createStatisticsProvider(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createStatisticsProvider(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatisticsProvider
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider createStatisticsProvider(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createStatisticsProvider(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatisticsProvider
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider createStatisticsProvider(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createStatisticsProvider(resource, graph);
	}
	
	
	/**
	 * Create a new instance of StatisticsProvider.  Leaves the dataset unchanged.
	 * @param resource The resource of the StatisticsProvider
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider getStatisticsProvider(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.StatisticsProviderImpl.getStatisticsProvider(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatisticsProvider
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider getStatisticsProvider(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticsProvider(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatisticsProvider
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider getStatisticsProvider(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getStatisticsProvider(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatisticsProvider
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider getStatisticsProvider(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getStatisticsProvider(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatisticsProvider
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider getStatisticsProvider(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getStatisticsProvider(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of StatisticsProvider.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatisticsProvider
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatisticsProvider getStatisticsProvider(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getStatisticsProvider(resource, graph);
	}
	
	/**
	 * Return an instance of StatisticsProvider for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#StatisticsProvider
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<StatisticsProvider> getAllStatisticsProvider(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,StatisticsProvider.TYPE,_namedGraphUri);
		java.util.List<StatisticsProvider> list = new java.util.ArrayList<StatisticsProvider>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getStatisticsProvider(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of StatisticsProvider for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#StatisticsProvider
	 * @param dataset the IDataset containing the data
	 * @return a List of StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<StatisticsProvider> getAllStatisticsProvider(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllStatisticsProvider(null, dataset);
	}
	
	/**
	 * Return an instance of StatisticsProvider for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#StatisticsProvider
	 * @param graph the NamedGraph containing the data
	 * @return a List of StatisticsProvider
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<StatisticsProvider> getAllStatisticsProvider(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllStatisticsProvider(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isStatisticPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(StatisticImpl.titleProperty) ||
			predicate.equals(StatisticImpl.descriptionProperty) ||
			predicate.equals(StatisticImpl.statisticsEnabledProperty) ||
			predicate.equals(StatisticImpl.statisticCountProperty) ||
			predicate.equals(StatisticImpl.statisticLastSampleTimeProperty) ||
			predicate.equals(StatisticImpl.statisticStartTimeProperty) ||
			predicate.equals(StatisticImpl.statisticUnitProperty) ;
	}
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Statistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic createStatistic(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Statistic result= org.openanzo.ontologies.system.StatisticImpl.createStatistic(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Statistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic createStatistic(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createStatistic(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Statistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic createStatistic(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createStatistic(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Statistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic createStatistic(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createStatistic(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Statistic
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic createStatistic(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createStatistic(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Statistic
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic createStatistic(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createStatistic(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Statistic.  Leaves the dataset unchanged.
	 * @param resource The resource of the Statistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic getStatistic(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.StatisticImpl.getStatistic(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Statistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic getStatistic(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getStatistic(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Statistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic getStatistic(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getStatistic(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Statistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic getStatistic(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getStatistic(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Statistic
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic getStatistic(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getStatistic(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Statistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Statistic
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Statistic getStatistic(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getStatistic(resource, graph);
	}
	
	/**
	 * Return an instance of Statistic for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Statistic
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Statistic> getAllStatistic(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Statistic.TYPE,_namedGraphUri);
		java.util.List<Statistic> list = new java.util.ArrayList<Statistic>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getStatistic(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Statistic for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Statistic
	 * @param dataset the IDataset containing the data
	 * @return a List of Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Statistic> getAllStatistic(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllStatistic(null, dataset);
	}
	
	/**
	 * Return an instance of Statistic for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Statistic
	 * @param graph the NamedGraph containing the data
	 * @return a List of Statistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Statistic> getAllStatistic(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllStatistic(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isCountStatisticPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(CountStatisticImpl.titleProperty) ||
			predicate.equals(CountStatisticImpl.descriptionProperty) ||
			predicate.equals(CountStatisticImpl.statisticsEnabledProperty) ||
			predicate.equals(CountStatisticImpl.statisticCountProperty) ||
			predicate.equals(CountStatisticImpl.statisticLastSampleTimeProperty) ||
			predicate.equals(CountStatisticImpl.statisticStartTimeProperty) ||
			predicate.equals(CountStatisticImpl.statisticUnitProperty) ||
			predicate.equals(CountStatisticImpl.statisticFrequencyProperty) ||
			predicate.equals(CountStatisticImpl.statisticPeriodProperty) ;
	}
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the CountStatistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic createCountStatistic(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		CountStatistic result= org.openanzo.ontologies.system.CountStatisticImpl.createCountStatistic(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the CountStatistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic createCountStatistic(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createCountStatistic(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the CountStatistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic createCountStatistic(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createCountStatistic(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the CountStatistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic createCountStatistic(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createCountStatistic(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the CountStatistic
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic createCountStatistic(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createCountStatistic(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the CountStatistic
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic createCountStatistic(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createCountStatistic(resource, graph);
	}
	
	
	/**
	 * Create a new instance of CountStatistic.  Leaves the dataset unchanged.
	 * @param resource The resource of the CountStatistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic getCountStatistic(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.CountStatisticImpl.getCountStatistic(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the CountStatistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic getCountStatistic(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getCountStatistic(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the CountStatistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic getCountStatistic(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getCountStatistic(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the CountStatistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic getCountStatistic(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getCountStatistic(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the CountStatistic
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic getCountStatistic(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getCountStatistic(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of CountStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the CountStatistic
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static CountStatistic getCountStatistic(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getCountStatistic(resource, graph);
	}
	
	/**
	 * Return an instance of CountStatistic for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#CountStatistic
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<CountStatistic> getAllCountStatistic(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,CountStatistic.TYPE,_namedGraphUri);
		java.util.List<CountStatistic> list = new java.util.ArrayList<CountStatistic>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getCountStatistic(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of CountStatistic for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#CountStatistic
	 * @param dataset the IDataset containing the data
	 * @return a List of CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<CountStatistic> getAllCountStatistic(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllCountStatistic(null, dataset);
	}
	
	/**
	 * Return an instance of CountStatistic for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#CountStatistic
	 * @param graph the NamedGraph containing the data
	 * @return a List of CountStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<CountStatistic> getAllCountStatistic(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllCountStatistic(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isTimerStatisticPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(TimerStatisticImpl.titleProperty) ||
			predicate.equals(TimerStatisticImpl.descriptionProperty) ||
			predicate.equals(TimerStatisticImpl.statisticsEnabledProperty) ||
			predicate.equals(TimerStatisticImpl.statisticCountProperty) ||
			predicate.equals(TimerStatisticImpl.statisticLastSampleTimeProperty) ||
			predicate.equals(TimerStatisticImpl.statisticStartTimeProperty) ||
			predicate.equals(TimerStatisticImpl.statisticUnitProperty) ||
			predicate.equals(TimerStatisticImpl.statisticAverageExcludingMinMaxProperty) ||
			predicate.equals(TimerStatisticImpl.statisticAveragePerSecondProperty) ||
			predicate.equals(TimerStatisticImpl.statisticAveragePerSecondExcludingMinMaxProperty) ||
			predicate.equals(TimerStatisticImpl.statisticAverageTimeProperty) ||
			predicate.equals(TimerStatisticImpl.statisticMaxTimeProperty) ||
			predicate.equals(TimerStatisticImpl.statisticMinTimeProperty) ||
			predicate.equals(TimerStatisticImpl.statisticTotalTimeProperty) ;
	}
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TimerStatistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic createTimerStatistic(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		TimerStatistic result= org.openanzo.ontologies.system.TimerStatisticImpl.createTimerStatistic(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TimerStatistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic createTimerStatistic(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createTimerStatistic(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TimerStatistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic createTimerStatistic(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createTimerStatistic(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TimerStatistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic createTimerStatistic(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createTimerStatistic(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TimerStatistic
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic createTimerStatistic(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createTimerStatistic(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TimerStatistic
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic createTimerStatistic(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createTimerStatistic(resource, graph);
	}
	
	
	/**
	 * Create a new instance of TimerStatistic.  Leaves the dataset unchanged.
	 * @param resource The resource of the TimerStatistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic getTimerStatistic(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.TimerStatisticImpl.getTimerStatistic(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TimerStatistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic getTimerStatistic(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getTimerStatistic(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TimerStatistic
	 * @param dataset the IDataset containing the data
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic getTimerStatistic(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getTimerStatistic(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TimerStatistic
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic getTimerStatistic(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getTimerStatistic(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TimerStatistic
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic getTimerStatistic(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getTimerStatistic(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of TimerStatistic.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TimerStatistic
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TimerStatistic getTimerStatistic(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getTimerStatistic(resource, graph);
	}
	
	/**
	 * Return an instance of TimerStatistic for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#TimerStatistic
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<TimerStatistic> getAllTimerStatistic(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,TimerStatistic.TYPE,_namedGraphUri);
		java.util.List<TimerStatistic> list = new java.util.ArrayList<TimerStatistic>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getTimerStatistic(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of TimerStatistic for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#TimerStatistic
	 * @param dataset the IDataset containing the data
	 * @return a List of TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<TimerStatistic> getAllTimerStatistic(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllTimerStatistic(null, dataset);
	}
	
	/**
	 * Return an instance of TimerStatistic for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#TimerStatistic
	 * @param graph the NamedGraph containing the data
	 * @return a List of TimerStatistic
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<TimerStatistic> getAllTimerStatistic(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllTimerStatistic(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isRDBDatasourcePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(RDBDatasourceImpl.credentialsProperty) ||
			predicate.equals(RDBDatasourceImpl.classNameProperty) ||
			predicate.equals(RDBDatasourceImpl.enabledProperty) ||
			predicate.equals(RDBDatasourceImpl.initOrderProperty) ||
			predicate.equals(RDBDatasourceImpl.dependencyProperty) ||
			predicate.equals(RDBDatasourceImpl.uriPatternProperty) ||
			predicate.equals(RDBDatasourceImpl.enableCachingProperty) ||
			predicate.equals(RDBDatasourceImpl.enableIndexingProperty) ||
			predicate.equals(RDBDatasourceImpl.isPrimaryProperty) ||
			predicate.equals(RDBDatasourceImpl.resetEnabledProperty) ||
			predicate.equals(RDBDatasourceImpl.authorizationRuleProperty) ||
			predicate.equals(RDBDatasourceImpl.datasourceCapabilityProperty) ||
			predicate.equals(RDBDatasourceImpl.dbTypeProperty) ||
			predicate.equals(RDBDatasourceImpl.canonicalTableProperty) ||
			predicate.equals(RDBDatasourceImpl.clearProperty) ||
			predicate.equals(RDBDatasourceImpl.clientProperty) ||
			predicate.equals(RDBDatasourceImpl.connectionSetupFunctionProperty) ||
			predicate.equals(RDBDatasourceImpl.connectionTeardownFunctionProperty) ||
			predicate.equals(RDBDatasourceImpl.containerNameProperty) ||
			predicate.equals(RDBDatasourceImpl.dbPasswordProperty) ||
			predicate.equals(RDBDatasourceImpl.dbURLProperty) ||
			predicate.equals(RDBDatasourceImpl.dbUserProperty) ||
			predicate.equals(RDBDatasourceImpl.initResourceProperty) ||
			predicate.equals(RDBDatasourceImpl.nodeCacheSizeProperty) ||
			predicate.equals(RDBDatasourceImpl.perUserConnectionProperty) ||
			predicate.equals(RDBDatasourceImpl.configurationProperty) ;
	}
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBDatasource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource createRDBDatasource(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		RDBDatasource result= org.openanzo.ontologies.system.RDBDatasourceImpl.createRDBDatasource(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBDatasource
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource createRDBDatasource(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createRDBDatasource(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBDatasource
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource createRDBDatasource(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRDBDatasource(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBDatasource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource createRDBDatasource(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRDBDatasource(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBDatasource
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource createRDBDatasource(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createRDBDatasource(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBDatasource
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource createRDBDatasource(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRDBDatasource(resource, graph);
	}
	
	
	/**
	 * Create a new instance of RDBDatasource.  Leaves the dataset unchanged.
	 * @param resource The resource of the RDBDatasource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource getRDBDatasource(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.RDBDatasourceImpl.getRDBDatasource(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBDatasource
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource getRDBDatasource(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getRDBDatasource(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBDatasource
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource getRDBDatasource(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRDBDatasource(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBDatasource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource getRDBDatasource(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRDBDatasource(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBDatasource
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource getRDBDatasource(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getRDBDatasource(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of RDBDatasource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBDatasource
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBDatasource getRDBDatasource(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRDBDatasource(resource, graph);
	}
	
	/**
	 * Return an instance of RDBDatasource for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#RDBDatasource
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<RDBDatasource> getAllRDBDatasource(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,RDBDatasource.TYPE,_namedGraphUri);
		java.util.List<RDBDatasource> list = new java.util.ArrayList<RDBDatasource>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getRDBDatasource(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of RDBDatasource for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#RDBDatasource
	 * @param dataset the IDataset containing the data
	 * @return a List of RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<RDBDatasource> getAllRDBDatasource(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllRDBDatasource(null, dataset);
	}
	
	/**
	 * Return an instance of RDBDatasource for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#RDBDatasource
	 * @param graph the NamedGraph containing the data
	 * @return a List of RDBDatasource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<RDBDatasource> getAllRDBDatasource(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllRDBDatasource(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isFormatPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(FormatImpl.javaTypeProperty) ||
			predicate.equals(FormatImpl.locationProperty) ;
	}
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Format
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format createFormat(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Format result= org.openanzo.ontologies.system.FormatImpl.createFormat(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Format
	 * @param dataset the IDataset containing the data
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format createFormat(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createFormat(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Format
	 * @param dataset the IDataset containing the data
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format createFormat(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFormat(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Format
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format createFormat(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFormat(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Format
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format createFormat(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createFormat(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Format
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format createFormat(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFormat(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Format.  Leaves the dataset unchanged.
	 * @param resource The resource of the Format
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format getFormat(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.FormatImpl.getFormat(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Format
	 * @param dataset the IDataset containing the data
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format getFormat(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getFormat(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Format
	 * @param dataset the IDataset containing the data
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format getFormat(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFormat(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Format
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format getFormat(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFormat(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Format
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format getFormat(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getFormat(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Format.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Format
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Format getFormat(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFormat(resource, graph);
	}
	
	/**
	 * Return an instance of Format for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Format
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Format> getAllFormat(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Format.TYPE,_namedGraphUri);
		java.util.List<Format> list = new java.util.ArrayList<Format>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getFormat(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Format for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Format
	 * @param dataset the IDataset containing the data
	 * @return a List of Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Format> getAllFormat(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllFormat(null, dataset);
	}
	
	/**
	 * Return an instance of Format for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Format
	 * @param graph the NamedGraph containing the data
	 * @return a List of Format
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Format> getAllFormat(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllFormat(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isNetworkComponentPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(NetworkComponentImpl.credentialsProperty) ||
			predicate.equals(NetworkComponentImpl.classNameProperty) ||
			predicate.equals(NetworkComponentImpl.enabledProperty) ||
			predicate.equals(NetworkComponentImpl.initOrderProperty) ||
			predicate.equals(NetworkComponentImpl.dependencyProperty) ||
			predicate.equals(NetworkComponentImpl.networkTimeoutProperty) ||
			predicate.equals(NetworkComponentImpl.connectionProperty) ;
	}
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkComponent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent createNetworkComponent(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		NetworkComponent result= org.openanzo.ontologies.system.NetworkComponentImpl.createNetworkComponent(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkComponent
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent createNetworkComponent(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createNetworkComponent(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkComponent
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent createNetworkComponent(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNetworkComponent(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkComponent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent createNetworkComponent(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNetworkComponent(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkComponent
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent createNetworkComponent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createNetworkComponent(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkComponent
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent createNetworkComponent(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNetworkComponent(resource, graph);
	}
	
	
	/**
	 * Create a new instance of NetworkComponent.  Leaves the dataset unchanged.
	 * @param resource The resource of the NetworkComponent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent getNetworkComponent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.NetworkComponentImpl.getNetworkComponent(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkComponent
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent getNetworkComponent(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getNetworkComponent(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkComponent
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent getNetworkComponent(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNetworkComponent(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkComponent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent getNetworkComponent(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNetworkComponent(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkComponent
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent getNetworkComponent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getNetworkComponent(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of NetworkComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkComponent
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkComponent getNetworkComponent(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNetworkComponent(resource, graph);
	}
	
	/**
	 * Return an instance of NetworkComponent for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#NetworkComponent
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<NetworkComponent> getAllNetworkComponent(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,NetworkComponent.TYPE,_namedGraphUri);
		java.util.List<NetworkComponent> list = new java.util.ArrayList<NetworkComponent>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getNetworkComponent(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of NetworkComponent for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#NetworkComponent
	 * @param dataset the IDataset containing the data
	 * @return a List of NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<NetworkComponent> getAllNetworkComponent(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllNetworkComponent(null, dataset);
	}
	
	/**
	 * Return an instance of NetworkComponent for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#NetworkComponent
	 * @param graph the NamedGraph containing the data
	 * @return a List of NetworkComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<NetworkComponent> getAllNetworkComponent(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllNetworkComponent(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isNetworkConnectionPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(NetworkConnectionImpl.hostProperty) ||
			predicate.equals(NetworkConnectionImpl.keystoreFileProperty) ||
			predicate.equals(NetworkConnectionImpl.keystorePasswordProperty) ||
			predicate.equals(NetworkConnectionImpl.keystoreTypeProperty) ||
			predicate.equals(NetworkConnectionImpl.portProperty) ||
			predicate.equals(NetworkConnectionImpl.timeoutProperty) ||
			predicate.equals(NetworkConnectionImpl.truststoreFileProperty) ||
			predicate.equals(NetworkConnectionImpl.truststorePasswordProperty) ||
			predicate.equals(NetworkConnectionImpl.truststoreTypeProperty) ||
			predicate.equals(NetworkConnectionImpl.useSslProperty) ;
	}
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkConnection
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection createNetworkConnection(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		NetworkConnection result= org.openanzo.ontologies.system.NetworkConnectionImpl.createNetworkConnection(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkConnection
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection createNetworkConnection(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createNetworkConnection(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkConnection
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection createNetworkConnection(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNetworkConnection(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkConnection
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection createNetworkConnection(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNetworkConnection(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkConnection
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection createNetworkConnection(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createNetworkConnection(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkConnection
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection createNetworkConnection(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNetworkConnection(resource, graph);
	}
	
	
	/**
	 * Create a new instance of NetworkConnection.  Leaves the dataset unchanged.
	 * @param resource The resource of the NetworkConnection
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection getNetworkConnection(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.NetworkConnectionImpl.getNetworkConnection(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkConnection
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection getNetworkConnection(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getNetworkConnection(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkConnection
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection getNetworkConnection(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNetworkConnection(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkConnection
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection getNetworkConnection(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNetworkConnection(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NetworkConnection
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection getNetworkConnection(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getNetworkConnection(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of NetworkConnection.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NetworkConnection
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NetworkConnection getNetworkConnection(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNetworkConnection(resource, graph);
	}
	
	/**
	 * Return an instance of NetworkConnection for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#NetworkConnection
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<NetworkConnection> getAllNetworkConnection(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,NetworkConnection.TYPE,_namedGraphUri);
		java.util.List<NetworkConnection> list = new java.util.ArrayList<NetworkConnection>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getNetworkConnection(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of NetworkConnection for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#NetworkConnection
	 * @param dataset the IDataset containing the data
	 * @return a List of NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<NetworkConnection> getAllNetworkConnection(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllNetworkConnection(null, dataset);
	}
	
	/**
	 * Return an instance of NetworkConnection for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#NetworkConnection
	 * @param graph the NamedGraph containing the data
	 * @return a List of NetworkConnection
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<NetworkConnection> getAllNetworkConnection(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllNetworkConnection(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isOperationPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(OperationImpl.nameProperty) ||
			predicate.equals(OperationImpl.bypassPoolProperty) ||
			predicate.equals(OperationImpl.restEndpointProperty) ||
			predicate.equals(OperationImpl.restTypeProperty) ||
			predicate.equals(OperationImpl.sysadminRequiredProperty) ||
			predicate.equals(OperationImpl.wsOperationProperty) ||
			predicate.equals(OperationImpl.requestParameterProperty) ||
			predicate.equals(OperationImpl.requestParameter0Property) ||
			predicate.equals(OperationImpl.requestParameter1Property) ||
			predicate.equals(OperationImpl.requestParameter2Property) ||
			predicate.equals(OperationImpl.requestParameter3Property) ||
			predicate.equals(OperationImpl.requestParameter4Property) ||
			predicate.equals(OperationImpl.requestParameter5Property) ||
			predicate.equals(OperationImpl.requestParameter6Property) ||
			predicate.equals(OperationImpl.requestParameter7Property) ||
			predicate.equals(OperationImpl.resultProperty) ;
	}
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Operation
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation createOperation(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Operation result= org.openanzo.ontologies.system.OperationImpl.createOperation(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Operation
	 * @param dataset the IDataset containing the data
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation createOperation(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createOperation(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Operation
	 * @param dataset the IDataset containing the data
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation createOperation(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOperation(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Operation
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation createOperation(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOperation(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Operation
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation createOperation(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createOperation(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Operation
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation createOperation(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOperation(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Operation.  Leaves the dataset unchanged.
	 * @param resource The resource of the Operation
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation getOperation(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.OperationImpl.getOperation(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Operation
	 * @param dataset the IDataset containing the data
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation getOperation(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getOperation(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Operation
	 * @param dataset the IDataset containing the data
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation getOperation(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOperation(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Operation
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation getOperation(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOperation(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Operation
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation getOperation(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getOperation(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Operation.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Operation
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Operation getOperation(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOperation(resource, graph);
	}
	
	/**
	 * Return an instance of Operation for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Operation
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Operation> getAllOperation(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Operation.TYPE,_namedGraphUri);
		java.util.List<Operation> list = new java.util.ArrayList<Operation>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getOperation(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Operation for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Operation
	 * @param dataset the IDataset containing the data
	 * @return a List of Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Operation> getAllOperation(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllOperation(null, dataset);
	}
	
	/**
	 * Return an instance of Operation for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Operation
	 * @param graph the NamedGraph containing the data
	 * @return a List of Operation
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Operation> getAllOperation(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllOperation(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isParameterPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ParameterImpl.nameProperty) ||
			predicate.equals(ParameterImpl.nullAllowedProperty) ||
			predicate.equals(ParameterImpl.parameterLocationProperty) ||
			predicate.equals(ParameterImpl.typeProperty) ;
	}
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Parameter
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter createParameter(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Parameter result= org.openanzo.ontologies.system.ParameterImpl.createParameter(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Parameter
	 * @param dataset the IDataset containing the data
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter createParameter(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createParameter(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Parameter
	 * @param dataset the IDataset containing the data
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter createParameter(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createParameter(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Parameter
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter createParameter(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createParameter(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Parameter
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter createParameter(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createParameter(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Parameter
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter createParameter(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createParameter(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Parameter.  Leaves the dataset unchanged.
	 * @param resource The resource of the Parameter
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter getParameter(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.ParameterImpl.getParameter(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Parameter
	 * @param dataset the IDataset containing the data
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter getParameter(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getParameter(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Parameter
	 * @param dataset the IDataset containing the data
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter getParameter(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getParameter(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Parameter
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter getParameter(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getParameter(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Parameter
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter getParameter(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getParameter(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Parameter.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Parameter
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Parameter getParameter(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getParameter(resource, graph);
	}
	
	/**
	 * Return an instance of Parameter for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Parameter
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Parameter> getAllParameter(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Parameter.TYPE,_namedGraphUri);
		java.util.List<Parameter> list = new java.util.ArrayList<Parameter>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getParameter(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Parameter for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Parameter
	 * @param dataset the IDataset containing the data
	 * @return a List of Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Parameter> getAllParameter(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllParameter(null, dataset);
	}
	
	/**
	 * Return an instance of Parameter for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Parameter
	 * @param graph the NamedGraph containing the data
	 * @return a List of Parameter
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Parameter> getAllParameter(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllParameter(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isRDBComponentPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(RDBComponentImpl.credentialsProperty) ||
			predicate.equals(RDBComponentImpl.classNameProperty) ||
			predicate.equals(RDBComponentImpl.enabledProperty) ||
			predicate.equals(RDBComponentImpl.initOrderProperty) ||
			predicate.equals(RDBComponentImpl.dependencyProperty) ||
			predicate.equals(RDBComponentImpl.dbTypeProperty) ||
			predicate.equals(RDBComponentImpl.canonicalTableProperty) ||
			predicate.equals(RDBComponentImpl.clearProperty) ||
			predicate.equals(RDBComponentImpl.clientProperty) ||
			predicate.equals(RDBComponentImpl.connectionSetupFunctionProperty) ||
			predicate.equals(RDBComponentImpl.connectionTeardownFunctionProperty) ||
			predicate.equals(RDBComponentImpl.containerNameProperty) ||
			predicate.equals(RDBComponentImpl.dbPasswordProperty) ||
			predicate.equals(RDBComponentImpl.dbURLProperty) ||
			predicate.equals(RDBComponentImpl.dbUserProperty) ||
			predicate.equals(RDBComponentImpl.initResourceProperty) ||
			predicate.equals(RDBComponentImpl.nodeCacheSizeProperty) ||
			predicate.equals(RDBComponentImpl.perUserConnectionProperty) ||
			predicate.equals(RDBComponentImpl.configurationProperty) ;
	}
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBComponent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent createRDBComponent(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		RDBComponent result= org.openanzo.ontologies.system.RDBComponentImpl.createRDBComponent(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBComponent
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent createRDBComponent(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createRDBComponent(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBComponent
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent createRDBComponent(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRDBComponent(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBComponent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent createRDBComponent(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRDBComponent(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBComponent
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent createRDBComponent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createRDBComponent(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBComponent
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent createRDBComponent(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRDBComponent(resource, graph);
	}
	
	
	/**
	 * Create a new instance of RDBComponent.  Leaves the dataset unchanged.
	 * @param resource The resource of the RDBComponent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent getRDBComponent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.RDBComponentImpl.getRDBComponent(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBComponent
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent getRDBComponent(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getRDBComponent(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBComponent
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent getRDBComponent(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRDBComponent(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBComponent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent getRDBComponent(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRDBComponent(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBComponent
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent getRDBComponent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getRDBComponent(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of RDBComponent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBComponent
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBComponent getRDBComponent(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRDBComponent(resource, graph);
	}
	
	/**
	 * Return an instance of RDBComponent for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#RDBComponent
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<RDBComponent> getAllRDBComponent(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,RDBComponent.TYPE,_namedGraphUri);
		java.util.List<RDBComponent> list = new java.util.ArrayList<RDBComponent>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getRDBComponent(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of RDBComponent for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#RDBComponent
	 * @param dataset the IDataset containing the data
	 * @return a List of RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<RDBComponent> getAllRDBComponent(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllRDBComponent(null, dataset);
	}
	
	/**
	 * Return an instance of RDBComponent for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#RDBComponent
	 * @param graph the NamedGraph containing the data
	 * @return a List of RDBComponent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<RDBComponent> getAllRDBComponent(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllRDBComponent(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isRDBConfigurationPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(RDBConfigurationImpl.dbTypeProperty) ||
			predicate.equals(RDBConfigurationImpl.bigIntProperty) ||
			predicate.equals(RDBConfigurationImpl.blobProperty) ||
			predicate.equals(RDBConfigurationImpl.clientSqlFileProperty) ||
			predicate.equals(RDBConfigurationImpl.connectionTypeProperty) ||
			predicate.equals(RDBConfigurationImpl.dbDriverProperty) ||
			predicate.equals(RDBConfigurationImpl.dropTableSuffixProperty) ||
			predicate.equals(RDBConfigurationImpl.forceTableTablePurgeProperty) ||
			predicate.equals(RDBConfigurationImpl.forceTempTableCreationProperty) ||
			predicate.equals(RDBConfigurationImpl.generatedIdStringProperty) ||
			predicate.equals(RDBConfigurationImpl.indexSuffixProperty) ||
			predicate.equals(RDBConfigurationImpl.maxIndexLengthProperty) ||
			predicate.equals(RDBConfigurationImpl.maxObjectLengthProperty) ||
			predicate.equals(RDBConfigurationImpl.maxTableNameProperty) ||
			predicate.equals(RDBConfigurationImpl.quoteCharProperty) ||
			predicate.equals(RDBConfigurationImpl.requiresTempTablespaceProperty) ||
			predicate.equals(RDBConfigurationImpl.serverSqlFileProperty) ||
			predicate.equals(RDBConfigurationImpl.sessionPrefixProperty) ||
			predicate.equals(RDBConfigurationImpl.singleRowOptimizationStringProperty) ||
			predicate.equals(RDBConfigurationImpl.smallIntProperty) ||
			predicate.equals(RDBConfigurationImpl.supportsFullOuterJoinsProperty) ||
			predicate.equals(RDBConfigurationImpl.supportsIndividualBatchUpdatesProperty) ||
			predicate.equals(RDBConfigurationImpl.supportsIsolationProperty) ||
			predicate.equals(RDBConfigurationImpl.supportsOptionalJoinsProperty) ||
			predicate.equals(RDBConfigurationImpl.supportsSequencesProperty) ||
			predicate.equals(RDBConfigurationImpl.supportsTableLocksProperty) ||
			predicate.equals(RDBConfigurationImpl.supportsTableUnLocksProperty) ||
			predicate.equals(RDBConfigurationImpl.supportsWithClauseProperty) ||
			predicate.equals(RDBConfigurationImpl.tableCreateSuffixProperty) ||
			predicate.equals(RDBConfigurationImpl.tableLockSuffixProperty) ||
			predicate.equals(RDBConfigurationImpl.textFieldSuffixProperty) ||
			predicate.equals(RDBConfigurationImpl.useTempFindProperty) ||
			predicate.equals(RDBConfigurationImpl.useTempInsertProperty) ||
			predicate.equals(RDBConfigurationImpl.useUniqueTempNamesProperty) ||
			predicate.equals(RDBConfigurationImpl.useUpperCaseTableProperty) ||
			predicate.equals(RDBConfigurationImpl.useUpperCaseTempTablesProperty) ||
			predicate.equals(RDBConfigurationImpl.varCharProperty) ;
	}
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration createRDBConfiguration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		RDBConfiguration result= org.openanzo.ontologies.system.RDBConfigurationImpl.createRDBConfiguration(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration createRDBConfiguration(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createRDBConfiguration(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration createRDBConfiguration(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRDBConfiguration(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration createRDBConfiguration(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRDBConfiguration(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBConfiguration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration createRDBConfiguration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createRDBConfiguration(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBConfiguration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration createRDBConfiguration(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRDBConfiguration(resource, graph);
	}
	
	
	/**
	 * Create a new instance of RDBConfiguration.  Leaves the dataset unchanged.
	 * @param resource The resource of the RDBConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration getRDBConfiguration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.RDBConfigurationImpl.getRDBConfiguration(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration getRDBConfiguration(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getRDBConfiguration(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration getRDBConfiguration(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRDBConfiguration(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration getRDBConfiguration(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRDBConfiguration(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the RDBConfiguration
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration getRDBConfiguration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getRDBConfiguration(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of RDBConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the RDBConfiguration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static RDBConfiguration getRDBConfiguration(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRDBConfiguration(resource, graph);
	}
	
	/**
	 * Return an instance of RDBConfiguration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#RDBConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<RDBConfiguration> getAllRDBConfiguration(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,RDBConfiguration.TYPE,_namedGraphUri);
		java.util.List<RDBConfiguration> list = new java.util.ArrayList<RDBConfiguration>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getRDBConfiguration(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of RDBConfiguration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#RDBConfiguration
	 * @param dataset the IDataset containing the data
	 * @return a List of RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<RDBConfiguration> getAllRDBConfiguration(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllRDBConfiguration(null, dataset);
	}
	
	/**
	 * Return an instance of RDBConfiguration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#RDBConfiguration
	 * @param graph the NamedGraph containing the data
	 * @return a List of RDBConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<RDBConfiguration> getAllRDBConfiguration(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllRDBConfiguration(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isServicePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ServiceImpl.credentialsProperty) ||
			predicate.equals(ServiceImpl.classNameProperty) ||
			predicate.equals(ServiceImpl.enabledProperty) ||
			predicate.equals(ServiceImpl.initOrderProperty) ||
			predicate.equals(ServiceImpl.dependencyProperty) ||
			predicate.equals(ServiceImpl.nameProperty) ||
			predicate.equals(ServiceImpl.availableOverJmsProperty) ||
			predicate.equals(ServiceImpl.availableOverRestProperty) ||
			predicate.equals(ServiceImpl.availableOverWSProperty) ||
			predicate.equals(ServiceImpl._interfaceProperty) ||
			predicate.equals(ServiceImpl.isDatasourceServiceProperty) ||
			predicate.equals(ServiceImpl.jmsQueueNameProperty) ||
			predicate.equals(ServiceImpl.operationProperty) ;
	}
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Service
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service createService(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Service result= org.openanzo.ontologies.system.ServiceImpl.createService(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Service
	 * @param dataset the IDataset containing the data
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service createService(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createService(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Service
	 * @param dataset the IDataset containing the data
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service createService(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createService(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Service
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service createService(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createService(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Service
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service createService(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createService(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Service
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service createService(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createService(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Service.  Leaves the dataset unchanged.
	 * @param resource The resource of the Service
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service getService(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.ServiceImpl.getService(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Service
	 * @param dataset the IDataset containing the data
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service getService(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getService(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Service
	 * @param dataset the IDataset containing the data
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service getService(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getService(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Service
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service getService(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getService(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Service
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service getService(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getService(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Service.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Service
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Service getService(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getService(resource, graph);
	}
	
	/**
	 * Return an instance of Service for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Service
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Service> getAllService(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Service.TYPE,_namedGraphUri);
		java.util.List<Service> list = new java.util.ArrayList<Service>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getService(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Service for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Service
	 * @param dataset the IDataset containing the data
	 * @return a List of Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Service> getAllService(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllService(null, dataset);
	}
	
	/**
	 * Return an instance of Service for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Service
	 * @param graph the NamedGraph containing the data
	 * @return a List of Service
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Service> getAllService(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllService(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isTypePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(TypeImpl.javaTypeProperty) ||
			predicate.equals(TypeImpl.nameProperty) ||
			predicate.equals(TypeImpl.defaultValueProperty) ||
			predicate.equals(TypeImpl.javaTransportTypeProperty) ||
			predicate.equals(TypeImpl.serializerProperty) ||
			predicate.equals(TypeImpl.defaultJMSFormatProperty) ||
			predicate.equals(TypeImpl.defaultRestFormatProperty) ||
			predicate.equals(TypeImpl.defaultWSFormatProperty) ||
			predicate.equals(TypeImpl.validFormatProperty) ;
	}
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Type
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type createType(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Type result= org.openanzo.ontologies.system.TypeImpl.createType(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Type
	 * @param dataset the IDataset containing the data
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type createType(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createType(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Type
	 * @param dataset the IDataset containing the data
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type createType(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createType(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Type
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type createType(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createType(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Type
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type createType(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createType(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Type
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type createType(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createType(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Type.  Leaves the dataset unchanged.
	 * @param resource The resource of the Type
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type getType(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.TypeImpl.getType(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Type
	 * @param dataset the IDataset containing the data
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type getType(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getType(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Type
	 * @param dataset the IDataset containing the data
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type getType(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getType(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Type
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type getType(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getType(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Type
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type getType(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getType(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Type.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Type
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Type getType(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getType(resource, graph);
	}
	
	/**
	 * Return an instance of Type for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Type
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Type> getAllType(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Type.TYPE,_namedGraphUri);
		java.util.List<Type> list = new java.util.ArrayList<Type>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getType(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Type for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Type
	 * @param dataset the IDataset containing the data
	 * @return a List of Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Type> getAllType(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllType(null, dataset);
	}
	
	/**
	 * Return an instance of Type for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#Type
	 * @param graph the NamedGraph containing the data
	 * @return a List of Type
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Type> getAllType(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllType(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isHttpConfigurationPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(HttpConfigurationImpl.credentialsProperty) ||
			predicate.equals(HttpConfigurationImpl.classNameProperty) ||
			predicate.equals(HttpConfigurationImpl.enabledProperty) ||
			predicate.equals(HttpConfigurationImpl.initOrderProperty) ||
			predicate.equals(HttpConfigurationImpl.dependencyProperty) ||
			predicate.equals(HttpConfigurationImpl.networkTimeoutProperty) ||
			predicate.equals(HttpConfigurationImpl.connectionProperty) ;
	}
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the HttpConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration createHttpConfiguration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		HttpConfiguration result= org.openanzo.ontologies.system.HttpConfigurationImpl.createHttpConfiguration(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the HttpConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration createHttpConfiguration(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createHttpConfiguration(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the HttpConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration createHttpConfiguration(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createHttpConfiguration(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the HttpConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration createHttpConfiguration(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createHttpConfiguration(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the HttpConfiguration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration createHttpConfiguration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createHttpConfiguration(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the HttpConfiguration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration createHttpConfiguration(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createHttpConfiguration(resource, graph);
	}
	
	
	/**
	 * Create a new instance of HttpConfiguration.  Leaves the dataset unchanged.
	 * @param resource The resource of the HttpConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration getHttpConfiguration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.HttpConfigurationImpl.getHttpConfiguration(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the HttpConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration getHttpConfiguration(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getHttpConfiguration(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the HttpConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration getHttpConfiguration(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getHttpConfiguration(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the HttpConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration getHttpConfiguration(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getHttpConfiguration(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the HttpConfiguration
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration getHttpConfiguration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getHttpConfiguration(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of HttpConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the HttpConfiguration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static HttpConfiguration getHttpConfiguration(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getHttpConfiguration(resource, graph);
	}
	
	/**
	 * Return an instance of HttpConfiguration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#HttpConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<HttpConfiguration> getAllHttpConfiguration(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,HttpConfiguration.TYPE,_namedGraphUri);
		java.util.List<HttpConfiguration> list = new java.util.ArrayList<HttpConfiguration>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getHttpConfiguration(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of HttpConfiguration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#HttpConfiguration
	 * @param dataset the IDataset containing the data
	 * @return a List of HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<HttpConfiguration> getAllHttpConfiguration(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllHttpConfiguration(null, dataset);
	}
	
	/**
	 * Return an instance of HttpConfiguration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#HttpConfiguration
	 * @param graph the NamedGraph containing the data
	 * @return a List of HttpConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<HttpConfiguration> getAllHttpConfiguration(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllHttpConfiguration(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isLdapConfigurationPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(LdapConfigurationImpl.credentialsProperty) ||
			predicate.equals(LdapConfigurationImpl.classNameProperty) ||
			predicate.equals(LdapConfigurationImpl.enabledProperty) ||
			predicate.equals(LdapConfigurationImpl.initOrderProperty) ||
			predicate.equals(LdapConfigurationImpl.dependencyProperty) ||
			predicate.equals(LdapConfigurationImpl.networkTimeoutProperty) ||
			predicate.equals(LdapConfigurationImpl.connectionProperty) ||
			predicate.equals(LdapConfigurationImpl.dnToUriTemplateProperty) ||
			predicate.equals(LdapConfigurationImpl.ldapCNProperty) ||
			predicate.equals(LdapConfigurationImpl.ldapIdProperty) ||
			predicate.equals(LdapConfigurationImpl.ldapInitFileProperty) ||
			predicate.equals(LdapConfigurationImpl.ldapInternalCredentialsProperty) ||
			predicate.equals(LdapConfigurationImpl.ldapInternalPrincipalProperty) ||
			predicate.equals(LdapConfigurationImpl.ldapOProperty) ||
			predicate.equals(LdapConfigurationImpl.ldapSearchBaseDNProperty) ||
			predicate.equals(LdapConfigurationImpl.ldapSuffixProperty) ||
			predicate.equals(LdapConfigurationImpl.ldapUseInternalProperty) ||
			predicate.equals(LdapConfigurationImpl.roleBaseDNProperty) ||
			predicate.equals(LdapConfigurationImpl.rolesSearchProperty) ||
			predicate.equals(LdapConfigurationImpl.sysadminRoleProperty) ||
			predicate.equals(LdapConfigurationImpl.userBaseDNProperty) ||
			predicate.equals(LdapConfigurationImpl.userIdAttributeProperty) ||
			predicate.equals(LdapConfigurationImpl.userSearchProperty) ;
	}
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the LdapConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration createLdapConfiguration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		LdapConfiguration result= org.openanzo.ontologies.system.LdapConfigurationImpl.createLdapConfiguration(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the LdapConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration createLdapConfiguration(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createLdapConfiguration(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the LdapConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration createLdapConfiguration(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createLdapConfiguration(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the LdapConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration createLdapConfiguration(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createLdapConfiguration(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the LdapConfiguration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration createLdapConfiguration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createLdapConfiguration(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the LdapConfiguration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration createLdapConfiguration(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createLdapConfiguration(resource, graph);
	}
	
	
	/**
	 * Create a new instance of LdapConfiguration.  Leaves the dataset unchanged.
	 * @param resource The resource of the LdapConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration getLdapConfiguration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.LdapConfigurationImpl.getLdapConfiguration(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the LdapConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration getLdapConfiguration(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getLdapConfiguration(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the LdapConfiguration
	 * @param dataset the IDataset containing the data
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration getLdapConfiguration(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getLdapConfiguration(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the LdapConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration getLdapConfiguration(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getLdapConfiguration(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the LdapConfiguration
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration getLdapConfiguration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getLdapConfiguration(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of LdapConfiguration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the LdapConfiguration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static LdapConfiguration getLdapConfiguration(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getLdapConfiguration(resource, graph);
	}
	
	/**
	 * Return an instance of LdapConfiguration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#LdapConfiguration
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<LdapConfiguration> getAllLdapConfiguration(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,LdapConfiguration.TYPE,_namedGraphUri);
		java.util.List<LdapConfiguration> list = new java.util.ArrayList<LdapConfiguration>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getLdapConfiguration(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of LdapConfiguration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#LdapConfiguration
	 * @param dataset the IDataset containing the data
	 * @return a List of LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<LdapConfiguration> getAllLdapConfiguration(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllLdapConfiguration(null, dataset);
	}
	
	/**
	 * Return an instance of LdapConfiguration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#LdapConfiguration
	 * @param graph the NamedGraph containing the data
	 * @return a List of LdapConfiguration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<LdapConfiguration> getAllLdapConfiguration(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllLdapConfiguration(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isJastorOntologyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(JastorOntologyImpl.generateProperty) ||
			predicate.equals(JastorOntologyImpl.ontologyUriProperty) ||
			predicate.equals(JastorOntologyImpl._packageProperty) ;
	}
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorOntology
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology createJastorOntology(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		JastorOntology result= org.openanzo.ontologies.system.JastorOntologyImpl.createJastorOntology(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorOntology
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology createJastorOntology(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createJastorOntology(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorOntology
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology createJastorOntology(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createJastorOntology(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorOntology
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology createJastorOntology(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createJastorOntology(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorOntology
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology createJastorOntology(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createJastorOntology(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorOntology
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology createJastorOntology(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createJastorOntology(resource, graph);
	}
	
	
	/**
	 * Create a new instance of JastorOntology.  Leaves the dataset unchanged.
	 * @param resource The resource of the JastorOntology
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology getJastorOntology(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.JastorOntologyImpl.getJastorOntology(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorOntology
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology getJastorOntology(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getJastorOntology(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorOntology
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology getJastorOntology(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getJastorOntology(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorOntology
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology getJastorOntology(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getJastorOntology(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorOntology
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology getJastorOntology(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getJastorOntology(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of JastorOntology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorOntology
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorOntology getJastorOntology(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getJastorOntology(resource, graph);
	}
	
	/**
	 * Return an instance of JastorOntology for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#JastorOntology
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<JastorOntology> getAllJastorOntology(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,JastorOntology.TYPE,_namedGraphUri);
		java.util.List<JastorOntology> list = new java.util.ArrayList<JastorOntology>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getJastorOntology(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of JastorOntology for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#JastorOntology
	 * @param dataset the IDataset containing the data
	 * @return a List of JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<JastorOntology> getAllJastorOntology(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllJastorOntology(null, dataset);
	}
	
	/**
	 * Return an instance of JastorOntology for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#JastorOntology
	 * @param graph the NamedGraph containing the data
	 * @return a List of JastorOntology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<JastorOntology> getAllJastorOntology(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllJastorOntology(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isJastorGenerationPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(JastorGenerationImpl.destDirProperty) ||
			predicate.equals(JastorGenerationImpl.generateListenersProperty) ||
			predicate.equals(JastorGenerationImpl.jastorOntologyProperty) ;
	}
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorGeneration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration createJastorGeneration(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		JastorGeneration result= org.openanzo.ontologies.system.JastorGenerationImpl.createJastorGeneration(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorGeneration
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration createJastorGeneration(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createJastorGeneration(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorGeneration
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration createJastorGeneration(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createJastorGeneration(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorGeneration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration createJastorGeneration(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createJastorGeneration(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorGeneration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration createJastorGeneration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createJastorGeneration(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorGeneration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration createJastorGeneration(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createJastorGeneration(resource, graph);
	}
	
	
	/**
	 * Create a new instance of JastorGeneration.  Leaves the dataset unchanged.
	 * @param resource The resource of the JastorGeneration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration getJastorGeneration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.system.JastorGenerationImpl.getJastorGeneration(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorGeneration
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration getJastorGeneration(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getJastorGeneration(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorGeneration
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration getJastorGeneration(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getJastorGeneration(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorGeneration
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration getJastorGeneration(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getJastorGeneration(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the JastorGeneration
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration getJastorGeneration(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getJastorGeneration(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of JastorGeneration.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the JastorGeneration
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static JastorGeneration getJastorGeneration(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getJastorGeneration(resource, graph);
	}
	
	/**
	 * Return an instance of JastorGeneration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#JastorGeneration
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<JastorGeneration> getAllJastorGeneration(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,JastorGeneration.TYPE,_namedGraphUri);
		java.util.List<JastorGeneration> list = new java.util.ArrayList<JastorGeneration>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getJastorGeneration(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of JastorGeneration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#JastorGeneration
	 * @param dataset the IDataset containing the data
	 * @return a List of JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<JastorGeneration> getAllJastorGeneration(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllJastorGeneration(null, dataset);
	}
	
	/**
	 * Return an instance of JastorGeneration for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/System#JastorGeneration
	 * @param graph the NamedGraph containing the data
	 * @return a List of JastorGeneration
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<JastorGeneration> getAllJastorGeneration(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllJastorGeneration(graph.getNamedGraphUri(), dataset);
	}



	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 * @throws org.openanzo.rdf.jastor.JastorException 
	 */
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#JastorGeneration"), namedGraphUri)) {
			return getJastorGeneration(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#JastorOntology"), namedGraphUri)) {
			return getJastorOntology(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#LdapConfiguration"), namedGraphUri)) {
			return getLdapConfiguration(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#HttpConfiguration"), namedGraphUri)) {
			return getHttpConfiguration(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#NetworkComponent"), namedGraphUri)) {
			return getNetworkComponent(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Type"), namedGraphUri)) {
			return getType(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Service"), namedGraphUri)) {
			return getService(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#RDBConfiguration"), namedGraphUri)) {
			return getRDBConfiguration(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Parameter"), namedGraphUri)) {
			return getParameter(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Operation"), namedGraphUri)) {
			return getOperation(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#NetworkConnection"), namedGraphUri)) {
			return getNetworkConnection(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Format"), namedGraphUri)) {
			return getFormat(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#RDBDatasource"), namedGraphUri)) {
			return getRDBDatasource(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#RDBComponent"), namedGraphUri)) {
			return getRDBComponent(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Datasource"), namedGraphUri)) {
			return getDatasource(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Component"), namedGraphUri)) {
			return getComponent(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#TimerStatistic"), namedGraphUri)) {
			return getTimerStatistic(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#CountStatistic"), namedGraphUri)) {
			return getCountStatistic(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Statistic"), namedGraphUri)) {
			return getStatistic(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#StatisticsProvider"), namedGraphUri)) {
			return getStatisticsProvider(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#DatasourceCapability"), namedGraphUri)) {
			return getDatasourceCapability(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Credentials"), namedGraphUri)) {
			return getCredentials(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#AuthorizationRule"), namedGraphUri)) {
			return getAuthorizationRule(resource, namedGraphUri, dataset);
		}
		return new org.openanzo.rdf.jastor.ThingImpl(resource, namedGraphUri, dataset);
	}
	/*
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getThing(resource, resource, dataset);
	}
	
	public static org.openanzo.rdf.jastor.Thing getThing(String uri, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getThing(resource, namedGraphUri, dataset);
	}
	
	public static org.openanzo.rdf.jastor.Thing getThing(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getThing(resource, dataset);
	}
	
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getThing(resource, graph.getNamedGraphUri(), dataset);
	}
	
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.URI resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getThing(resource, graph.getNamedGraphUri(), dataset);
	}
	
	public static org.openanzo.rdf.jastor.Thing getThing(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getThing(resource, graph);
	}
	*/
	/**
	 * Return a list of compatible interfaces for the given type.  Searches through all ontology classes
	 * in the System ontology.
	 * @param type the type for which to find compatible interfaces
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> listCompatibleInterfaces (org.openanzo.rdf.Resource type) {
		java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> types = new java.util.ArrayList<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>>();
		if (type.equals(org.openanzo.ontologies.system.AuthorizationRule.TYPE)) {
			types.add(org.openanzo.ontologies.system.AuthorizationRule.class);
		}
		if (type.equals(org.openanzo.ontologies.system.Component.TYPE)) {
			types.add(org.openanzo.ontologies.system.Component.class);
		}
		if (type.equals(org.openanzo.ontologies.system.Credentials.TYPE)) {
			types.add(org.openanzo.ontologies.system.Credentials.class);
		}
		if (type.equals(org.openanzo.ontologies.system.Datasource.TYPE)) {
			types.add(org.openanzo.ontologies.system.Datasource.class);
		}
		if (type.equals(org.openanzo.ontologies.system.DatasourceCapability.TYPE)) {
			types.add(org.openanzo.ontologies.system.DatasourceCapability.class);
		}
		if (type.equals(org.openanzo.ontologies.system.StatisticsProvider.TYPE)) {
			types.add(org.openanzo.ontologies.system.StatisticsProvider.class);
		}
		if (type.equals(org.openanzo.ontologies.system.Statistic.TYPE)) {
			types.add(org.openanzo.ontologies.system.Statistic.class);
		}
		if (type.equals(org.openanzo.ontologies.system.CountStatistic.TYPE)) {
			types.add(org.openanzo.ontologies.system.CountStatistic.class);
		}
		if (type.equals(org.openanzo.ontologies.system.TimerStatistic.TYPE)) {
			types.add(org.openanzo.ontologies.system.TimerStatistic.class);
		}
		if (type.equals(org.openanzo.ontologies.system.RDBDatasource.TYPE)) {
			types.add(org.openanzo.ontologies.system.RDBDatasource.class);
		}
		if (type.equals(org.openanzo.ontologies.system.Format.TYPE)) {
			types.add(org.openanzo.ontologies.system.Format.class);
		}
		if (type.equals(org.openanzo.ontologies.system.NetworkComponent.TYPE)) {
			types.add(org.openanzo.ontologies.system.NetworkComponent.class);
		}
		if (type.equals(org.openanzo.ontologies.system.NetworkConnection.TYPE)) {
			types.add(org.openanzo.ontologies.system.NetworkConnection.class);
		}
		if (type.equals(org.openanzo.ontologies.system.Operation.TYPE)) {
			types.add(org.openanzo.ontologies.system.Operation.class);
		}
		if (type.equals(org.openanzo.ontologies.system.Parameter.TYPE)) {
			types.add(org.openanzo.ontologies.system.Parameter.class);
		}
		if (type.equals(org.openanzo.ontologies.system.RDBComponent.TYPE)) {
			types.add(org.openanzo.ontologies.system.RDBComponent.class);
		}
		if (type.equals(org.openanzo.ontologies.system.RDBConfiguration.TYPE)) {
			types.add(org.openanzo.ontologies.system.RDBConfiguration.class);
		}
		if (type.equals(org.openanzo.ontologies.system.Service.TYPE)) {
			types.add(org.openanzo.ontologies.system.Service.class);
		}
		if (type.equals(org.openanzo.ontologies.system.Type.TYPE)) {
			types.add(org.openanzo.ontologies.system.Type.class);
		}
		if (type.equals(org.openanzo.ontologies.system.HttpConfiguration.TYPE)) {
			types.add(org.openanzo.ontologies.system.HttpConfiguration.class);
		}
		if (type.equals(org.openanzo.ontologies.system.LdapConfiguration.TYPE)) {
			types.add(org.openanzo.ontologies.system.LdapConfiguration.class);
		}
		if (type.equals(org.openanzo.ontologies.system.JastorOntology.TYPE)) {
			types.add(org.openanzo.ontologies.system.JastorOntology.class);
		}
		if (type.equals(org.openanzo.ontologies.system.JastorGeneration.TYPE)) {
			types.add(org.openanzo.ontologies.system.JastorGeneration.class);
		}
		return types;
	}
}