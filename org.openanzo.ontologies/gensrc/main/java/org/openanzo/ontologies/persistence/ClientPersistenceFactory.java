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
 * Factory for instantiating objects for ontology classes in the ClientPersistence ontology.  The
 * get methods leave the dataset unchanged and return a Java view of the object in the dataset.  The create methods
 * may add certain baseline properties to the dataset such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://openanzo.org/ontologies/ClientPersistence)</p>
 * <br>
 * <br>
 * <br>
 */
public class ClientPersistenceFactory extends org.openanzo.rdf.jastor.ThingFactory { 


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isClientPersistenceRootPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ClientPersistenceRootImpl.committedTransactionsProperty) ;
	}
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ClientPersistenceRoot
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot createClientPersistenceRoot(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		ClientPersistenceRoot result= org.openanzo.ontologies.persistence.ClientPersistenceRootImpl.createClientPersistenceRoot(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ClientPersistenceRoot
	 * @param dataset the IDataset containing the data
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot createClientPersistenceRoot(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createClientPersistenceRoot(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ClientPersistenceRoot
	 * @param dataset the IDataset containing the data
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot createClientPersistenceRoot(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createClientPersistenceRoot(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ClientPersistenceRoot
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot createClientPersistenceRoot(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createClientPersistenceRoot(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ClientPersistenceRoot
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot createClientPersistenceRoot(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createClientPersistenceRoot(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ClientPersistenceRoot
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot createClientPersistenceRoot(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createClientPersistenceRoot(resource, graph);
	}
	
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Leaves the dataset unchanged.
	 * @param resource The resource of the ClientPersistenceRoot
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot getClientPersistenceRoot(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.persistence.ClientPersistenceRootImpl.getClientPersistenceRoot(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ClientPersistenceRoot
	 * @param dataset the IDataset containing the data
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot getClientPersistenceRoot(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getClientPersistenceRoot(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ClientPersistenceRoot
	 * @param dataset the IDataset containing the data
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot getClientPersistenceRoot(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getClientPersistenceRoot(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ClientPersistenceRoot
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot getClientPersistenceRoot(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getClientPersistenceRoot(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ClientPersistenceRoot
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot getClientPersistenceRoot(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getClientPersistenceRoot(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ClientPersistenceRoot.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ClientPersistenceRoot
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ClientPersistenceRoot getClientPersistenceRoot(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getClientPersistenceRoot(resource, graph);
	}
	
	/**
	 * Return an instance of ClientPersistenceRoot for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#ClientPersistenceRoot
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ClientPersistenceRoot> getAllClientPersistenceRoot(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,ClientPersistenceRoot.TYPE,_namedGraphUri);
		java.util.List<ClientPersistenceRoot> list = new java.util.ArrayList<ClientPersistenceRoot>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getClientPersistenceRoot(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of ClientPersistenceRoot for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#ClientPersistenceRoot
	 * @param dataset the IDataset containing the data
	 * @return a List of ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ClientPersistenceRoot> getAllClientPersistenceRoot(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllClientPersistenceRoot(null, dataset);
	}
	
	/**
	 * Return an instance of ClientPersistenceRoot for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#ClientPersistenceRoot
	 * @param graph the NamedGraph containing the data
	 * @return a List of ClientPersistenceRoot
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ClientPersistenceRoot> getAllClientPersistenceRoot(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllClientPersistenceRoot(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isPersistedPreconditionPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(PersistedPreconditionImpl.askResultProperty) ||
			predicate.equals(PersistedPreconditionImpl.queryStringProperty) ||
			predicate.equals(PersistedPreconditionImpl.preconditionDefaultUriProperty) ||
			predicate.equals(PersistedPreconditionImpl.preconditionNamedGraphUriProperty) ;
	}
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedPrecondition
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition createPersistedPrecondition(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		PersistedPrecondition result= org.openanzo.ontologies.persistence.PersistedPreconditionImpl.createPersistedPrecondition(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedPrecondition
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition createPersistedPrecondition(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createPersistedPrecondition(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedPrecondition
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition createPersistedPrecondition(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPersistedPrecondition(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedPrecondition
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition createPersistedPrecondition(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPersistedPrecondition(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedPrecondition
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition createPersistedPrecondition(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createPersistedPrecondition(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedPrecondition
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition createPersistedPrecondition(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPersistedPrecondition(resource, graph);
	}
	
	
	/**
	 * Create a new instance of PersistedPrecondition.  Leaves the dataset unchanged.
	 * @param resource The resource of the PersistedPrecondition
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition getPersistedPrecondition(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.persistence.PersistedPreconditionImpl.getPersistedPrecondition(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedPrecondition
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition getPersistedPrecondition(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getPersistedPrecondition(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedPrecondition
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition getPersistedPrecondition(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPersistedPrecondition(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedPrecondition
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition getPersistedPrecondition(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPersistedPrecondition(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedPrecondition
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition getPersistedPrecondition(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getPersistedPrecondition(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of PersistedPrecondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedPrecondition
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedPrecondition getPersistedPrecondition(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPersistedPrecondition(resource, graph);
	}
	
	/**
	 * Return an instance of PersistedPrecondition for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedPrecondition
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<PersistedPrecondition> getAllPersistedPrecondition(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,PersistedPrecondition.TYPE,_namedGraphUri);
		java.util.List<PersistedPrecondition> list = new java.util.ArrayList<PersistedPrecondition>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getPersistedPrecondition(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of PersistedPrecondition for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedPrecondition
	 * @param dataset the IDataset containing the data
	 * @return a List of PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<PersistedPrecondition> getAllPersistedPrecondition(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllPersistedPrecondition(null, dataset);
	}
	
	/**
	 * Return an instance of PersistedPrecondition for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedPrecondition
	 * @param graph the NamedGraph containing the data
	 * @return a List of PersistedPrecondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<PersistedPrecondition> getAllPersistedPrecondition(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllPersistedPrecondition(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isPersistedTransactionPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(PersistedTransactionImpl.transactionContextProperty) ||
			predicate.equals(PersistedTransactionImpl.additionsStoreProperty) ||
			predicate.equals(PersistedTransactionImpl.childTransactionProperty) ||
			predicate.equals(PersistedTransactionImpl.deletionsStoreProperty) ||
			predicate.equals(PersistedTransactionImpl.nextProperty) ||
			predicate.equals(PersistedTransactionImpl.nextTransactionProperty) ||
			predicate.equals(PersistedTransactionImpl.parentTransactionProperty) ||
			predicate.equals(PersistedTransactionImpl.preconditionsProperty) ||
			predicate.equals(PersistedTransactionImpl.previousTransactionProperty) ||
			predicate.equals(PersistedTransactionImpl.transactionUriProperty) ;
	}
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedTransaction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction createPersistedTransaction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		PersistedTransaction result= org.openanzo.ontologies.persistence.PersistedTransactionImpl.createPersistedTransaction(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedTransaction
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction createPersistedTransaction(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createPersistedTransaction(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedTransaction
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction createPersistedTransaction(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPersistedTransaction(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedTransaction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction createPersistedTransaction(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPersistedTransaction(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedTransaction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction createPersistedTransaction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createPersistedTransaction(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedTransaction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction createPersistedTransaction(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPersistedTransaction(resource, graph);
	}
	
	
	/**
	 * Create a new instance of PersistedTransaction.  Leaves the dataset unchanged.
	 * @param resource The resource of the PersistedTransaction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction getPersistedTransaction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.persistence.PersistedTransactionImpl.getPersistedTransaction(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedTransaction
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction getPersistedTransaction(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getPersistedTransaction(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedTransaction
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction getPersistedTransaction(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPersistedTransaction(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedTransaction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction getPersistedTransaction(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPersistedTransaction(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersistedTransaction
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction getPersistedTransaction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getPersistedTransaction(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of PersistedTransaction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersistedTransaction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersistedTransaction getPersistedTransaction(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPersistedTransaction(resource, graph);
	}
	
	/**
	 * Return an instance of PersistedTransaction for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedTransaction
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<PersistedTransaction> getAllPersistedTransaction(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,PersistedTransaction.TYPE,_namedGraphUri);
		java.util.List<PersistedTransaction> list = new java.util.ArrayList<PersistedTransaction>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getPersistedTransaction(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of PersistedTransaction for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedTransaction
	 * @param dataset the IDataset containing the data
	 * @return a List of PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<PersistedTransaction> getAllPersistedTransaction(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllPersistedTransaction(null, dataset);
	}
	
	/**
	 * Return an instance of PersistedTransaction for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedTransaction
	 * @param graph the NamedGraph containing the data
	 * @return a List of PersistedTransaction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<PersistedTransaction> getAllPersistedTransaction(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllPersistedTransaction(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isReferencedNamedGraphPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ReferencedNamedGraphImpl.graphUriProperty) ||
			predicate.equals(ReferencedNamedGraphImpl.referenceUriProperty) ;
	}
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedNamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph createReferencedNamedGraph(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		ReferencedNamedGraph result= org.openanzo.ontologies.persistence.ReferencedNamedGraphImpl.createReferencedNamedGraph(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedNamedGraph
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph createReferencedNamedGraph(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createReferencedNamedGraph(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedNamedGraph
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph createReferencedNamedGraph(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createReferencedNamedGraph(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedNamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph createReferencedNamedGraph(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createReferencedNamedGraph(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedNamedGraph
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph createReferencedNamedGraph(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createReferencedNamedGraph(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedNamedGraph
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph createReferencedNamedGraph(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createReferencedNamedGraph(resource, graph);
	}
	
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Leaves the dataset unchanged.
	 * @param resource The resource of the ReferencedNamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph getReferencedNamedGraph(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.persistence.ReferencedNamedGraphImpl.getReferencedNamedGraph(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedNamedGraph
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph getReferencedNamedGraph(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getReferencedNamedGraph(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedNamedGraph
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph getReferencedNamedGraph(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getReferencedNamedGraph(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedNamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph getReferencedNamedGraph(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getReferencedNamedGraph(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedNamedGraph
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph getReferencedNamedGraph(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getReferencedNamedGraph(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ReferencedNamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedNamedGraph
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedNamedGraph getReferencedNamedGraph(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getReferencedNamedGraph(resource, graph);
	}
	
	/**
	 * Return an instance of ReferencedNamedGraph for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedNamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ReferencedNamedGraph> getAllReferencedNamedGraph(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,ReferencedNamedGraph.TYPE,_namedGraphUri);
		java.util.List<ReferencedNamedGraph> list = new java.util.ArrayList<ReferencedNamedGraph>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getReferencedNamedGraph(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of ReferencedNamedGraph for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedNamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ReferencedNamedGraph> getAllReferencedNamedGraph(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllReferencedNamedGraph(null, dataset);
	}
	
	/**
	 * Return an instance of ReferencedNamedGraph for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedNamedGraph
	 * @param graph the NamedGraph containing the data
	 * @return a List of ReferencedNamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ReferencedNamedGraph> getAllReferencedNamedGraph(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllReferencedNamedGraph(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isReferencedQuadStorePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ReferencedQuadStoreImpl.namedGraphProperty) ;
	}
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedQuadStore
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore createReferencedQuadStore(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		ReferencedQuadStore result= org.openanzo.ontologies.persistence.ReferencedQuadStoreImpl.createReferencedQuadStore(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedQuadStore
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore createReferencedQuadStore(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createReferencedQuadStore(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedQuadStore
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore createReferencedQuadStore(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createReferencedQuadStore(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedQuadStore
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore createReferencedQuadStore(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createReferencedQuadStore(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedQuadStore
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore createReferencedQuadStore(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createReferencedQuadStore(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedQuadStore
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore createReferencedQuadStore(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createReferencedQuadStore(resource, graph);
	}
	
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Leaves the dataset unchanged.
	 * @param resource The resource of the ReferencedQuadStore
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore getReferencedQuadStore(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.persistence.ReferencedQuadStoreImpl.getReferencedQuadStore(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedQuadStore
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore getReferencedQuadStore(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getReferencedQuadStore(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedQuadStore
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore getReferencedQuadStore(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getReferencedQuadStore(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedQuadStore
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore getReferencedQuadStore(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getReferencedQuadStore(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReferencedQuadStore
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore getReferencedQuadStore(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getReferencedQuadStore(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ReferencedQuadStore.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReferencedQuadStore
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReferencedQuadStore getReferencedQuadStore(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getReferencedQuadStore(resource, graph);
	}
	
	/**
	 * Return an instance of ReferencedQuadStore for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedQuadStore
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ReferencedQuadStore> getAllReferencedQuadStore(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,ReferencedQuadStore.TYPE,_namedGraphUri);
		java.util.List<ReferencedQuadStore> list = new java.util.ArrayList<ReferencedQuadStore>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getReferencedQuadStore(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of ReferencedQuadStore for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedQuadStore
	 * @param dataset the IDataset containing the data
	 * @return a List of ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ReferencedQuadStore> getAllReferencedQuadStore(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllReferencedQuadStore(null, dataset);
	}
	
	/**
	 * Return an instance of ReferencedQuadStore for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedQuadStore
	 * @param graph the NamedGraph containing the data
	 * @return a List of ReferencedQuadStore
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ReferencedQuadStore> getAllReferencedQuadStore(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllReferencedQuadStore(graph.getNamedGraphUri(), dataset);
	}



	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 * @throws org.openanzo.rdf.jastor.JastorException 
	 */
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedQuadStore"), namedGraphUri)) {
			return getReferencedQuadStore(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedNamedGraph"), namedGraphUri)) {
			return getReferencedNamedGraph(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedTransaction"), namedGraphUri)) {
			return getPersistedTransaction(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedPrecondition"), namedGraphUri)) {
			return getPersistedPrecondition(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/ClientPersistence#ClientPersistenceRoot"), namedGraphUri)) {
			return getClientPersistenceRoot(resource, namedGraphUri, dataset);
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
	 * in the ClientPersistence ontology.
	 * @param type the type for which to find compatible interfaces
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> listCompatibleInterfaces (org.openanzo.rdf.Resource type) {
		java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> types = new java.util.ArrayList<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>>();
		if (type.equals(org.openanzo.ontologies.persistence.ClientPersistenceRoot.TYPE)) {
			types.add(org.openanzo.ontologies.persistence.ClientPersistenceRoot.class);
		}
		if (type.equals(org.openanzo.ontologies.persistence.PersistedPrecondition.TYPE)) {
			types.add(org.openanzo.ontologies.persistence.PersistedPrecondition.class);
		}
		if (type.equals(org.openanzo.ontologies.persistence.PersistedTransaction.TYPE)) {
			types.add(org.openanzo.ontologies.persistence.PersistedTransaction.class);
		}
		if (type.equals(org.openanzo.ontologies.persistence.ReferencedNamedGraph.TYPE)) {
			types.add(org.openanzo.ontologies.persistence.ReferencedNamedGraph.class);
		}
		if (type.equals(org.openanzo.ontologies.persistence.ReferencedQuadStore.TYPE)) {
			types.add(org.openanzo.ontologies.persistence.ReferencedQuadStore.class);
		}
		return types;
	}
}