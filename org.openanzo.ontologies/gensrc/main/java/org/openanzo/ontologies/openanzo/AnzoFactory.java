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
 * Factory for instantiating objects for ontology classes in the Anzo ontology.  The
 * get methods leave the dataset unchanged and return a Java view of the object in the dataset.  The create methods
 * may add certain baseline properties to the dataset such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://openanzo.org/ontologies/Anzo)</p>
 * <br>
 * <br>
 * <br>
 */
public class AnzoFactory extends org.openanzo.rdf.jastor.ThingFactory { 


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isAnzoServerPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(AnzoServerImpl.serverIdProperty) ||
			predicate.equals(AnzoServerImpl.uriPrefixProperty) ;
	}
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnzoServer
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer createAnzoServer(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		AnzoServer result= org.openanzo.ontologies.openanzo.AnzoServerImpl.createAnzoServer(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnzoServer
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer createAnzoServer(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createAnzoServer(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnzoServer
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer createAnzoServer(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAnzoServer(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnzoServer
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer createAnzoServer(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAnzoServer(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnzoServer
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer createAnzoServer(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createAnzoServer(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnzoServer
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer createAnzoServer(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAnzoServer(resource, graph);
	}
	
	
	/**
	 * Create a new instance of AnzoServer.  Leaves the dataset unchanged.
	 * @param resource The resource of the AnzoServer
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer getAnzoServer(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.AnzoServerImpl.getAnzoServer(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnzoServer
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer getAnzoServer(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAnzoServer(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnzoServer
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer getAnzoServer(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAnzoServer(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnzoServer
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer getAnzoServer(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAnzoServer(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnzoServer
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer getAnzoServer(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAnzoServer(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AnzoServer.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnzoServer
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnzoServer getAnzoServer(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAnzoServer(resource, graph);
	}
	
	/**
	 * Return an instance of AnzoServer for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#AnzoServer
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AnzoServer> getAllAnzoServer(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,AnzoServer.TYPE,_namedGraphUri);
		java.util.List<AnzoServer> list = new java.util.ArrayList<AnzoServer>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getAnzoServer(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of AnzoServer for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#AnzoServer
	 * @param dataset the IDataset containing the data
	 * @return a List of AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AnzoServer> getAllAnzoServer(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllAnzoServer(null, dataset);
	}
	
	/**
	 * Return an instance of AnzoServer for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#AnzoServer
	 * @param graph the NamedGraph containing the data
	 * @return a List of AnzoServer
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AnzoServer> getAllAnzoServer(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllAnzoServer(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isAskResultPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(AskResultImpl._booleanProperty) ;
	}
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AskResult
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult createAskResult(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		AskResult result= org.openanzo.ontologies.openanzo.AskResultImpl.createAskResult(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AskResult
	 * @param dataset the IDataset containing the data
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult createAskResult(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createAskResult(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AskResult
	 * @param dataset the IDataset containing the data
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult createAskResult(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAskResult(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AskResult
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult createAskResult(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAskResult(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AskResult
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult createAskResult(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createAskResult(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AskResult
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult createAskResult(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAskResult(resource, graph);
	}
	
	
	/**
	 * Create a new instance of AskResult.  Leaves the dataset unchanged.
	 * @param resource The resource of the AskResult
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult getAskResult(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.AskResultImpl.getAskResult(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AskResult
	 * @param dataset the IDataset containing the data
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult getAskResult(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAskResult(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AskResult
	 * @param dataset the IDataset containing the data
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult getAskResult(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAskResult(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AskResult
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult getAskResult(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAskResult(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AskResult
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult getAskResult(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAskResult(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AskResult.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AskResult
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AskResult getAskResult(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAskResult(resource, graph);
	}
	
	/**
	 * Return an instance of AskResult for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#AskResult
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AskResult> getAllAskResult(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,AskResult.TYPE,_namedGraphUri);
		java.util.List<AskResult> list = new java.util.ArrayList<AskResult>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getAskResult(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of AskResult for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#AskResult
	 * @param dataset the IDataset containing the data
	 * @return a List of AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AskResult> getAllAskResult(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllAskResult(null, dataset);
	}
	
	/**
	 * Return an instance of AskResult for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#AskResult
	 * @param graph the NamedGraph containing the data
	 * @return a List of AskResult
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AskResult> getAllAskResult(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllAskResult(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isDatasetPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(DatasetImpl.includeMetadataGraphsProperty) ||
			predicate.equals(DatasetImpl.defaultGraphProperty) ||
			predicate.equals(DatasetImpl.defaultNamedGraphProperty) ||
			predicate.equals(DatasetImpl.namedGraphProperty) ;
	}
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Dataset
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset createDataset(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Dataset result= org.openanzo.ontologies.openanzo.DatasetImpl.createDataset(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Dataset
	 * @param dataset the IDataset containing the data
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset createDataset(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createDataset(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Dataset
	 * @param dataset the IDataset containing the data
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset createDataset(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDataset(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Dataset
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset createDataset(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDataset(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Dataset
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset createDataset(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createDataset(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Dataset
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset createDataset(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDataset(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Dataset.  Leaves the dataset unchanged.
	 * @param resource The resource of the Dataset
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset getDataset(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.DatasetImpl.getDataset(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Dataset
	 * @param dataset the IDataset containing the data
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset getDataset(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getDataset(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Dataset
	 * @param dataset the IDataset containing the data
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset getDataset(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDataset(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Dataset
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset getDataset(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDataset(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Dataset
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset getDataset(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getDataset(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Dataset.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Dataset
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Dataset getDataset(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDataset(resource, graph);
	}
	
	/**
	 * Return an instance of Dataset for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Dataset
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Dataset> getAllDataset(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Dataset.TYPE,_namedGraphUri);
		java.util.List<Dataset> list = new java.util.ArrayList<Dataset>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getDataset(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Dataset for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Dataset
	 * @param dataset the IDataset containing the data
	 * @return a List of Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Dataset> getAllDataset(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllDataset(null, dataset);
	}
	
	/**
	 * Return an instance of Dataset for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Dataset
	 * @param graph the NamedGraph containing the data
	 * @return a List of Dataset
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Dataset> getAllDataset(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllDataset(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isDatasetTrackerPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(DatasetTrackerImpl.includeMetadataGraphsProperty) ||
			predicate.equals(DatasetTrackerImpl.defaultGraphProperty) ||
			predicate.equals(DatasetTrackerImpl.defaultNamedGraphProperty) ||
			predicate.equals(DatasetTrackerImpl.namedGraphProperty) ||
			predicate.equals(DatasetTrackerImpl.namedDatasetProperty) ;
	}
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasetTracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker createDatasetTracker(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		DatasetTracker result= org.openanzo.ontologies.openanzo.DatasetTrackerImpl.createDatasetTracker(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasetTracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker createDatasetTracker(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createDatasetTracker(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasetTracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker createDatasetTracker(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatasetTracker(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasetTracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker createDatasetTracker(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatasetTracker(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasetTracker
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker createDatasetTracker(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createDatasetTracker(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasetTracker
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker createDatasetTracker(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatasetTracker(resource, graph);
	}
	
	
	/**
	 * Create a new instance of DatasetTracker.  Leaves the dataset unchanged.
	 * @param resource The resource of the DatasetTracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker getDatasetTracker(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.DatasetTrackerImpl.getDatasetTracker(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasetTracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker getDatasetTracker(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getDatasetTracker(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasetTracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker getDatasetTracker(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatasetTracker(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasetTracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker getDatasetTracker(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatasetTracker(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatasetTracker
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker getDatasetTracker(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getDatasetTracker(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DatasetTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatasetTracker
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatasetTracker getDatasetTracker(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatasetTracker(resource, graph);
	}
	
	/**
	 * Return an instance of DatasetTracker for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#DatasetTracker
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DatasetTracker> getAllDatasetTracker(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,DatasetTracker.TYPE,_namedGraphUri);
		java.util.List<DatasetTracker> list = new java.util.ArrayList<DatasetTracker>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getDatasetTracker(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of DatasetTracker for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#DatasetTracker
	 * @param dataset the IDataset containing the data
	 * @return a List of DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DatasetTracker> getAllDatasetTracker(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllDatasetTracker(null, dataset);
	}
	
	/**
	 * Return an instance of DatasetTracker for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#DatasetTracker
	 * @param graph the NamedGraph containing the data
	 * @return a List of DatasetTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DatasetTracker> getAllDatasetTracker(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllDatasetTracker(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isNamedGraphPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(NamedGraphImpl.createdProperty) ||
			predicate.equals(NamedGraphImpl.hasMetadataGraphProperty) ||
			predicate.equals(NamedGraphImpl.modifiedProperty) ||
			predicate.equals(NamedGraphImpl.persistedProperty) ||
			predicate.equals(NamedGraphImpl.revisionProperty) ||
			predicate.equals(NamedGraphImpl.revisionedProperty) ||
			predicate.equals(NamedGraphImpl.uuidProperty) ||
			predicate.equals(NamedGraphImpl.canBeAddedToByProperty) ||
			predicate.equals(NamedGraphImpl.canBeReadByProperty) ||
			predicate.equals(NamedGraphImpl.canBeRemovedFromByProperty) ||
			predicate.equals(NamedGraphImpl.createdByProperty) ||
			predicate.equals(NamedGraphImpl.datasourceProperty) ||
			predicate.equals(NamedGraphImpl.inheritsFromProperty) ||
			predicate.equals(NamedGraphImpl.lastModifiedByUserProperty) ;
	}
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph createNamedGraph(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		NamedGraph result= org.openanzo.ontologies.openanzo.NamedGraphImpl.createNamedGraph(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph createNamedGraph(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createNamedGraph(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph createNamedGraph(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNamedGraph(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph createNamedGraph(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNamedGraph(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NamedGraph
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph createNamedGraph(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createNamedGraph(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NamedGraph
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph createNamedGraph(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNamedGraph(resource, graph);
	}
	
	
	/**
	 * Create a new instance of NamedGraph.  Leaves the dataset unchanged.
	 * @param resource The resource of the NamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph getNamedGraph(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.NamedGraphImpl.getNamedGraph(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph getNamedGraph(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getNamedGraph(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph getNamedGraph(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNamedGraph(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph getNamedGraph(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNamedGraph(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the NamedGraph
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph getNamedGraph(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getNamedGraph(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of NamedGraph.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the NamedGraph
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static NamedGraph getNamedGraph(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNamedGraph(resource, graph);
	}
	
	/**
	 * Return an instance of NamedGraph for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<NamedGraph> getAllNamedGraph(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,NamedGraph.TYPE,_namedGraphUri);
		java.util.List<NamedGraph> list = new java.util.ArrayList<NamedGraph>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getNamedGraph(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of NamedGraph for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<NamedGraph> getAllNamedGraph(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllNamedGraph(null, dataset);
	}
	
	/**
	 * Return an instance of NamedGraph for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph
	 * @param graph the NamedGraph containing the data
	 * @return a List of NamedGraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<NamedGraph> getAllNamedGraph(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllNamedGraph(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isPreconditionPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(PreconditionImpl.datasetProperty) ||
			predicate.equals(PreconditionImpl.queryProperty) ||
			predicate.equals(PreconditionImpl.resultProperty) ;
	}
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Precondition
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition createPrecondition(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Precondition result= org.openanzo.ontologies.openanzo.PreconditionImpl.createPrecondition(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Precondition
	 * @param dataset the IDataset containing the data
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition createPrecondition(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createPrecondition(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Precondition
	 * @param dataset the IDataset containing the data
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition createPrecondition(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPrecondition(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Precondition
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition createPrecondition(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPrecondition(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Precondition
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition createPrecondition(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createPrecondition(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Precondition
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition createPrecondition(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPrecondition(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Precondition.  Leaves the dataset unchanged.
	 * @param resource The resource of the Precondition
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition getPrecondition(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.PreconditionImpl.getPrecondition(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Precondition
	 * @param dataset the IDataset containing the data
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition getPrecondition(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getPrecondition(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Precondition
	 * @param dataset the IDataset containing the data
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition getPrecondition(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPrecondition(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Precondition
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition getPrecondition(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPrecondition(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Precondition
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition getPrecondition(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getPrecondition(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Precondition.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Precondition
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Precondition getPrecondition(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPrecondition(resource, graph);
	}
	
	/**
	 * Return an instance of Precondition for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Precondition
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Precondition> getAllPrecondition(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Precondition.TYPE,_namedGraphUri);
		java.util.List<Precondition> list = new java.util.ArrayList<Precondition>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getPrecondition(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Precondition for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Precondition
	 * @param dataset the IDataset containing the data
	 * @return a List of Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Precondition> getAllPrecondition(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllPrecondition(null, dataset);
	}
	
	/**
	 * Return an instance of Precondition for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Precondition
	 * @param graph the NamedGraph containing the data
	 * @return a List of Precondition
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Precondition> getAllPrecondition(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllPrecondition(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isQueryPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(QueryImpl.queryStringProperty) ;
	}
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Query
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query createQuery(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Query result= org.openanzo.ontologies.openanzo.QueryImpl.createQuery(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Query
	 * @param dataset the IDataset containing the data
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query createQuery(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createQuery(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Query
	 * @param dataset the IDataset containing the data
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query createQuery(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createQuery(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Query
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query createQuery(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createQuery(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Query
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query createQuery(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createQuery(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Query
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query createQuery(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createQuery(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Query.  Leaves the dataset unchanged.
	 * @param resource The resource of the Query
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query getQuery(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.QueryImpl.getQuery(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Query
	 * @param dataset the IDataset containing the data
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query getQuery(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getQuery(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Query
	 * @param dataset the IDataset containing the data
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query getQuery(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getQuery(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Query
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query getQuery(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getQuery(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Query
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query getQuery(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getQuery(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Query.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Query
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Query getQuery(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getQuery(resource, graph);
	}
	
	/**
	 * Return an instance of Query for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Query
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Query> getAllQuery(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Query.TYPE,_namedGraphUri);
		java.util.List<Query> list = new java.util.ArrayList<Query>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getQuery(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Query for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Query
	 * @param dataset the IDataset containing the data
	 * @return a List of Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Query> getAllQuery(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllQuery(null, dataset);
	}
	
	/**
	 * Return an instance of Query for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Query
	 * @param graph the NamedGraph containing the data
	 * @return a List of Query
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Query> getAllQuery(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllQuery(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isRegistryPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(RegistryImpl.includeMetadataGraphsProperty) ||
			predicate.equals(RegistryImpl.defaultGraphProperty) ||
			predicate.equals(RegistryImpl.defaultNamedGraphProperty) ||
			predicate.equals(RegistryImpl.namedGraphProperty) ||
			predicate.equals(RegistryImpl.registeredTypeProperty) ;
	}
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Registry
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry createRegistry(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Registry result= org.openanzo.ontologies.openanzo.RegistryImpl.createRegistry(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Registry
	 * @param dataset the IDataset containing the data
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry createRegistry(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createRegistry(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Registry
	 * @param dataset the IDataset containing the data
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry createRegistry(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRegistry(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Registry
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry createRegistry(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRegistry(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Registry
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry createRegistry(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createRegistry(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Registry
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry createRegistry(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRegistry(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Registry.  Leaves the dataset unchanged.
	 * @param resource The resource of the Registry
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry getRegistry(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.RegistryImpl.getRegistry(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Registry
	 * @param dataset the IDataset containing the data
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry getRegistry(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getRegistry(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Registry
	 * @param dataset the IDataset containing the data
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry getRegistry(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRegistry(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Registry
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry getRegistry(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRegistry(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Registry
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry getRegistry(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getRegistry(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Registry.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Registry
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Registry getRegistry(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRegistry(resource, graph);
	}
	
	/**
	 * Return an instance of Registry for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Registry
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Registry> getAllRegistry(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Registry.TYPE,_namedGraphUri);
		java.util.List<Registry> list = new java.util.ArrayList<Registry>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getRegistry(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Registry for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Registry
	 * @param dataset the IDataset containing the data
	 * @return a List of Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Registry> getAllRegistry(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllRegistry(null, dataset);
	}
	
	/**
	 * Return an instance of Registry for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Registry
	 * @param graph the NamedGraph containing the data
	 * @return a List of Registry
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Registry> getAllRegistry(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllRegistry(graph.getNamedGraphUri(), dataset);
	}


	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Result
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result createResult(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Result result= org.openanzo.ontologies.openanzo.ResultImpl.createResult(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Result
	 * @param dataset the IDataset containing the data
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result createResult(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createResult(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Result
	 * @param dataset the IDataset containing the data
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result createResult(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createResult(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Result
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result createResult(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createResult(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Result
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result createResult(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createResult(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Result
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result createResult(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createResult(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Result.  Leaves the dataset unchanged.
	 * @param resource The resource of the Result
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result getResult(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.ResultImpl.getResult(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Result
	 * @param dataset the IDataset containing the data
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result getResult(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getResult(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Result
	 * @param dataset the IDataset containing the data
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result getResult(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getResult(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Result
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result getResult(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getResult(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Result
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result getResult(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getResult(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Result.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Result
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Result getResult(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getResult(resource, graph);
	}
	
	/**
	 * Return an instance of Result for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Result
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Result> getAllResult(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Result.TYPE,_namedGraphUri);
		java.util.List<Result> list = new java.util.ArrayList<Result>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getResult(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Result for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Result
	 * @param dataset the IDataset containing the data
	 * @return a List of Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Result> getAllResult(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllResult(null, dataset);
	}
	
	/**
	 * Return an instance of Result for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Result
	 * @param graph the NamedGraph containing the data
	 * @return a List of Result
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Result> getAllResult(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllResult(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isSelectorTrackerPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(SelectorTrackerImpl.namedGraphUriProperty) ||
			predicate.equals(SelectorTrackerImpl.objectProperty) ||
			predicate.equals(SelectorTrackerImpl.predicateProperty) ||
			predicate.equals(SelectorTrackerImpl.subjectProperty) ;
	}
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SelectorTracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker createSelectorTracker(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		SelectorTracker result= org.openanzo.ontologies.openanzo.SelectorTrackerImpl.createSelectorTracker(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SelectorTracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker createSelectorTracker(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createSelectorTracker(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SelectorTracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker createSelectorTracker(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSelectorTracker(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SelectorTracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker createSelectorTracker(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSelectorTracker(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SelectorTracker
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker createSelectorTracker(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createSelectorTracker(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SelectorTracker
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker createSelectorTracker(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSelectorTracker(resource, graph);
	}
	
	
	/**
	 * Create a new instance of SelectorTracker.  Leaves the dataset unchanged.
	 * @param resource The resource of the SelectorTracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker getSelectorTracker(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.SelectorTrackerImpl.getSelectorTracker(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SelectorTracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker getSelectorTracker(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getSelectorTracker(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SelectorTracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker getSelectorTracker(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSelectorTracker(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SelectorTracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker getSelectorTracker(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSelectorTracker(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SelectorTracker
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker getSelectorTracker(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getSelectorTracker(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of SelectorTracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SelectorTracker
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SelectorTracker getSelectorTracker(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSelectorTracker(resource, graph);
	}
	
	/**
	 * Return an instance of SelectorTracker for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#SelectorTracker
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<SelectorTracker> getAllSelectorTracker(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,SelectorTracker.TYPE,_namedGraphUri);
		java.util.List<SelectorTracker> list = new java.util.ArrayList<SelectorTracker>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getSelectorTracker(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of SelectorTracker for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#SelectorTracker
	 * @param dataset the IDataset containing the data
	 * @return a List of SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<SelectorTracker> getAllSelectorTracker(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllSelectorTracker(null, dataset);
	}
	
	/**
	 * Return an instance of SelectorTracker for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#SelectorTracker
	 * @param graph the NamedGraph containing the data
	 * @return a List of SelectorTracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<SelectorTracker> getAllSelectorTracker(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllSelectorTracker(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isStatementStreamPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(StatementStreamImpl.createdProperty) ||
			predicate.equals(StatementStreamImpl.hasMetadataGraphProperty) ||
			predicate.equals(StatementStreamImpl.modifiedProperty) ||
			predicate.equals(StatementStreamImpl.persistedProperty) ||
			predicate.equals(StatementStreamImpl.revisionProperty) ||
			predicate.equals(StatementStreamImpl.revisionedProperty) ||
			predicate.equals(StatementStreamImpl.uuidProperty) ||
			predicate.equals(StatementStreamImpl.canBeAddedToByProperty) ||
			predicate.equals(StatementStreamImpl.canBeReadByProperty) ||
			predicate.equals(StatementStreamImpl.canBeRemovedFromByProperty) ||
			predicate.equals(StatementStreamImpl.createdByProperty) ||
			predicate.equals(StatementStreamImpl.datasourceProperty) ||
			predicate.equals(StatementStreamImpl.inheritsFromProperty) ||
			predicate.equals(StatementStreamImpl.lastModifiedByUserProperty) ;
	}
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatementStream
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream createStatementStream(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		StatementStream result= org.openanzo.ontologies.openanzo.StatementStreamImpl.createStatementStream(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatementStream
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream createStatementStream(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createStatementStream(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatementStream
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream createStatementStream(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createStatementStream(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatementStream
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream createStatementStream(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createStatementStream(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatementStream
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream createStatementStream(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createStatementStream(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatementStream
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream createStatementStream(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createStatementStream(resource, graph);
	}
	
	
	/**
	 * Create a new instance of StatementStream.  Leaves the dataset unchanged.
	 * @param resource The resource of the StatementStream
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream getStatementStream(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.StatementStreamImpl.getStatementStream(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatementStream
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream getStatementStream(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getStatementStream(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatementStream
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream getStatementStream(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getStatementStream(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatementStream
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream getStatementStream(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getStatementStream(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the StatementStream
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream getStatementStream(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getStatementStream(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of StatementStream.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the StatementStream
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static StatementStream getStatementStream(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getStatementStream(resource, graph);
	}
	
	/**
	 * Return an instance of StatementStream for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#StatementStream
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<StatementStream> getAllStatementStream(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,StatementStream.TYPE,_namedGraphUri);
		java.util.List<StatementStream> list = new java.util.ArrayList<StatementStream>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getStatementStream(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of StatementStream for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#StatementStream
	 * @param dataset the IDataset containing the data
	 * @return a List of StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<StatementStream> getAllStatementStream(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllStatementStream(null, dataset);
	}
	
	/**
	 * Return an instance of StatementStream for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#StatementStream
	 * @param graph the NamedGraph containing the data
	 * @return a List of StatementStream
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<StatementStream> getAllStatementStream(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllStatementStream(graph.getNamedGraphUri(), dataset);
	}


	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Tracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker createTracker(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Tracker result= org.openanzo.ontologies.openanzo.TrackerImpl.createTracker(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Tracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker createTracker(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createTracker(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Tracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker createTracker(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createTracker(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Tracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker createTracker(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createTracker(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Tracker
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker createTracker(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createTracker(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Tracker
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker createTracker(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createTracker(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Tracker.  Leaves the dataset unchanged.
	 * @param resource The resource of the Tracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker getTracker(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.TrackerImpl.getTracker(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Tracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker getTracker(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getTracker(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Tracker
	 * @param dataset the IDataset containing the data
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker getTracker(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getTracker(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Tracker
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker getTracker(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getTracker(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Tracker
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker getTracker(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getTracker(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Tracker.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Tracker
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Tracker getTracker(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getTracker(resource, graph);
	}
	
	/**
	 * Return an instance of Tracker for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Tracker
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Tracker> getAllTracker(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Tracker.TYPE,_namedGraphUri);
		java.util.List<Tracker> list = new java.util.ArrayList<Tracker>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getTracker(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Tracker for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Tracker
	 * @param dataset the IDataset containing the data
	 * @return a List of Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Tracker> getAllTracker(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllTracker(null, dataset);
	}
	
	/**
	 * Return an instance of Tracker for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Tracker
	 * @param graph the NamedGraph containing the data
	 * @return a List of Tracker
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Tracker> getAllTracker(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllTracker(graph.getNamedGraphUri(), dataset);
	}


	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the User
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User createUser(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		User result= org.openanzo.ontologies.openanzo.UserImpl.createUser(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the User
	 * @param dataset the IDataset containing the data
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User createUser(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createUser(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the User
	 * @param dataset the IDataset containing the data
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User createUser(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createUser(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the User
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User createUser(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createUser(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the User
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User createUser(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createUser(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the User
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User createUser(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createUser(resource, graph);
	}
	
	
	/**
	 * Create a new instance of User.  Leaves the dataset unchanged.
	 * @param resource The resource of the User
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User getUser(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.UserImpl.getUser(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the User
	 * @param dataset the IDataset containing the data
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User getUser(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getUser(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the User
	 * @param dataset the IDataset containing the data
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User getUser(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getUser(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the User
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User getUser(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getUser(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the User
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User getUser(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getUser(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of User.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the User
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static User getUser(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getUser(resource, graph);
	}
	
	/**
	 * Return an instance of User for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#User
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<User> getAllUser(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,User.TYPE,_namedGraphUri);
		java.util.List<User> list = new java.util.ArrayList<User>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getUser(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of User for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#User
	 * @param dataset the IDataset containing the data
	 * @return a List of User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<User> getAllUser(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllUser(null, dataset);
	}
	
	/**
	 * Return an instance of User for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#User
	 * @param graph the NamedGraph containing the data
	 * @return a List of User
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<User> getAllUser(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllUser(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isRolePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(RoleImpl.memberProperty) ;
	}
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Role
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role createRole(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Role result= org.openanzo.ontologies.openanzo.RoleImpl.createRole(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Role
	 * @param dataset the IDataset containing the data
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role createRole(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createRole(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Role
	 * @param dataset the IDataset containing the data
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role createRole(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRole(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Role
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role createRole(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRole(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Role
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role createRole(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createRole(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Role
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role createRole(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRole(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Role.  Leaves the dataset unchanged.
	 * @param resource The resource of the Role
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role getRole(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.openanzo.RoleImpl.getRole(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Role
	 * @param dataset the IDataset containing the data
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role getRole(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getRole(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Role
	 * @param dataset the IDataset containing the data
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role getRole(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRole(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Role
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role getRole(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRole(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Role
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role getRole(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getRole(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Role.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Role
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Role getRole(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRole(resource, graph);
	}
	
	/**
	 * Return an instance of Role for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Role
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Role> getAllRole(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Role.TYPE,_namedGraphUri);
		java.util.List<Role> list = new java.util.ArrayList<Role>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getRole(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Role for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Role
	 * @param dataset the IDataset containing the data
	 * @return a List of Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Role> getAllRole(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllRole(null, dataset);
	}
	
	/**
	 * Return an instance of Role for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Anzo#Role
	 * @param graph the NamedGraph containing the data
	 * @return a List of Role
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Role> getAllRole(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllRole(graph.getNamedGraphUri(), dataset);
	}



	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 * @throws org.openanzo.rdf.jastor.JastorException 
	 */
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Role"), namedGraphUri)) {
			return getRole(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#User"), namedGraphUri)) {
			return getUser(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#StatementStream"), namedGraphUri)) {
			return getStatementStream(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"), namedGraphUri)) {
			return getNamedGraph(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#SelectorTracker"), namedGraphUri)) {
			return getSelectorTracker(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Registry"), namedGraphUri)) {
			return getRegistry(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Query"), namedGraphUri)) {
			return getQuery(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Precondition"), namedGraphUri)) {
			return getPrecondition(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#DatasetTracker"), namedGraphUri)) {
			return getDatasetTracker(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Tracker"), namedGraphUri)) {
			return getTracker(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Dataset"), namedGraphUri)) {
			return getDataset(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#AskResult"), namedGraphUri)) {
			return getAskResult(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Result"), namedGraphUri)) {
			return getResult(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#AnzoServer"), namedGraphUri)) {
			return getAnzoServer(resource, namedGraphUri, dataset);
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
	 * in the Anzo ontology.
	 * @param type the type for which to find compatible interfaces
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> listCompatibleInterfaces (org.openanzo.rdf.Resource type) {
		java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> types = new java.util.ArrayList<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>>();
		if (type.equals(org.openanzo.ontologies.openanzo.AnzoServer.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.AnzoServer.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.AskResult.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.AskResult.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.Dataset.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.Dataset.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.DatasetTracker.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.DatasetTracker.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.NamedGraph.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.NamedGraph.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.Precondition.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.Precondition.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.Query.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.Query.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.Registry.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.Registry.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.Result.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.Result.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.SelectorTracker.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.SelectorTracker.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.StatementStream.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.StatementStream.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.Tracker.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.Tracker.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.User.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.User.class);
		}
		if (type.equals(org.openanzo.ontologies.openanzo.Role.TYPE)) {
			types.add(org.openanzo.ontologies.openanzo.Role.class);
		}
		return types;
	}
}