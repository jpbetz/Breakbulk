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

package org.openanzo.rdf.rdfs;

/**
 * Factory for instantiating objects for ontology classes in the RDFS ontology.  The
 * get methods leave the dataset unchanged and return a Java view of the object in the dataset.  The create methods
 * may add certain baseline properties to the dataset such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://www.w3.org/2000/01/rdf-schema#RDFS)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : RDFS Classes <br>
 * <br>
 * <br>
 *	@version 1.1
 */
public class RDFSFactory extends org.openanzo.rdf.jastor.ThingFactory { 


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isListPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(List.commentProperty) ||
			predicate.equals(List.labelProperty) ||
			predicate.equals(List.typeProperty) ||
			predicate.equals(List.valueProperty) ||
			predicate.equals(List.isDefinedByProperty) ||
			predicate.equals(List.memberProperty) ||
			predicate.equals(List.seeAlsoProperty) ||
			predicate.equals(List.firstProperty) ||
			predicate.equals(List.restProperty) ;
	}
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the List
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List createList(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		List result= org.openanzo.rdf.rdfs.ListImpl.createList(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the List
	 * @param dataset the IDataset containing the data
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List createList(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createList(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the List
	 * @param dataset the IDataset containing the data
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List createList(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createList(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the List
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List createList(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createList(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the List
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List createList(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createList(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the List
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List createList(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createList(resource, graph);
	}
	
	
	/**
	 * Create a new instance of List.  Leaves the dataset unchanged.
	 * @param resource The resource of the List
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List getList(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs.ListImpl.getList(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the List
	 * @param dataset the IDataset containing the data
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List getList(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getList(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the List
	 * @param dataset the IDataset containing the data
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List getList(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getList(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the List
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List getList(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getList(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the List
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List getList(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getList(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of List.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the List
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static List getList(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getList(resource, graph);
	}
	
	/**
	 * Return an instance of List for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#List
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<List> getAllList(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,List.TYPE,_namedGraphUri);
		java.util.List<List> list = new java.util.ArrayList<List>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getList(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of List for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#List
	 * @param dataset the IDataset containing the data
	 * @return a List of List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<List> getAllList(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllList(null, dataset);
	}
	
	/**
	 * Return an instance of List for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#List
	 * @param graph the NamedGraph containing the data
	 * @return a List of List
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<List> getAllList(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllList(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isSeqPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Seq.commentProperty) ||
			predicate.equals(Seq.labelProperty) ||
			predicate.equals(Seq.typeProperty) ||
			predicate.equals(Seq.valueProperty) ||
			predicate.equals(Seq.isDefinedByProperty) ||
			predicate.equals(Seq.memberProperty) ||
			predicate.equals(Seq.seeAlsoProperty) ;
	}
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Seq
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq createSeq(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Seq result= org.openanzo.rdf.rdfs.SeqImpl.createSeq(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Seq
	 * @param dataset the IDataset containing the data
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq createSeq(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createSeq(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Seq
	 * @param dataset the IDataset containing the data
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq createSeq(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSeq(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Seq
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq createSeq(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSeq(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Seq
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq createSeq(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createSeq(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Seq
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq createSeq(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSeq(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Seq.  Leaves the dataset unchanged.
	 * @param resource The resource of the Seq
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq getSeq(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs.SeqImpl.getSeq(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Seq
	 * @param dataset the IDataset containing the data
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq getSeq(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getSeq(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Seq
	 * @param dataset the IDataset containing the data
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq getSeq(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSeq(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Seq
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq getSeq(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSeq(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Seq
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq getSeq(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getSeq(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Seq.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Seq
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Seq getSeq(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSeq(resource, graph);
	}
	
	/**
	 * Return an instance of Seq for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Seq
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Seq> getAllSeq(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Seq.TYPE,_namedGraphUri);
		java.util.List<Seq> list = new java.util.ArrayList<Seq>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getSeq(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Seq for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Seq
	 * @param dataset the IDataset containing the data
	 * @return a List of Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Seq> getAllSeq(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllSeq(null, dataset);
	}
	
	/**
	 * Return an instance of Seq for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Seq
	 * @param graph the NamedGraph containing the data
	 * @return a List of Seq
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Seq> getAllSeq(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllSeq(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isClassPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Class.commentProperty) ||
			predicate.equals(Class.labelProperty) ||
			predicate.equals(Class.typeProperty) ||
			predicate.equals(Class.valueProperty) ||
			predicate.equals(Class.isDefinedByProperty) ||
			predicate.equals(Class.memberProperty) ||
			predicate.equals(Class.seeAlsoProperty) ||
			predicate.equals(Class.subClassOfProperty) ;
	}
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Class
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class createClass(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Class result= org.openanzo.rdf.rdfs.ClassImpl.createClass(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Class
	 * @param dataset the IDataset containing the data
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class createClass(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createClass(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Class
	 * @param dataset the IDataset containing the data
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class createClass(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createClass(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Class
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class createClass(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createClass(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Class
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class createClass(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createClass(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Class
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class createClass(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createClass(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Class.  Leaves the dataset unchanged.
	 * @param resource The resource of the Class
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class getClass(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs.ClassImpl.getClass(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Class
	 * @param dataset the IDataset containing the data
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class getClass(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getClass(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Class
	 * @param dataset the IDataset containing the data
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class getClass(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getClass(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Class
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class getClass(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getClass(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Class
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class getClass(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getClass(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Class.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Class
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Class getClass(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getClass(resource, graph);
	}
	
	/**
	 * Return an instance of Class for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Class
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Class> getAllClass(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Class.TYPE,_namedGraphUri);
		java.util.List<Class> list = new java.util.ArrayList<Class>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getClass(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Class for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Class
	 * @param dataset the IDataset containing the data
	 * @return a List of Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Class> getAllClass(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllClass(null, dataset);
	}
	
	/**
	 * Return an instance of Class for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Class
	 * @param graph the NamedGraph containing the data
	 * @return a List of Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Class> getAllClass(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllClass(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isBagPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Bag.commentProperty) ||
			predicate.equals(Bag.labelProperty) ||
			predicate.equals(Bag.typeProperty) ||
			predicate.equals(Bag.valueProperty) ||
			predicate.equals(Bag.isDefinedByProperty) ||
			predicate.equals(Bag.memberProperty) ||
			predicate.equals(Bag.seeAlsoProperty) ;
	}
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Bag
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag createBag(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Bag result= org.openanzo.rdf.rdfs.BagImpl.createBag(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Bag
	 * @param dataset the IDataset containing the data
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag createBag(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createBag(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Bag
	 * @param dataset the IDataset containing the data
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag createBag(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createBag(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Bag
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag createBag(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createBag(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Bag
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag createBag(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createBag(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Bag
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag createBag(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createBag(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Bag.  Leaves the dataset unchanged.
	 * @param resource The resource of the Bag
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag getBag(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs.BagImpl.getBag(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Bag
	 * @param dataset the IDataset containing the data
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag getBag(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getBag(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Bag
	 * @param dataset the IDataset containing the data
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag getBag(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getBag(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Bag
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag getBag(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getBag(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Bag
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag getBag(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getBag(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Bag.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Bag
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Bag getBag(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getBag(resource, graph);
	}
	
	/**
	 * Return an instance of Bag for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Bag
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Bag> getAllBag(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Bag.TYPE,_namedGraphUri);
		java.util.List<Bag> list = new java.util.ArrayList<Bag>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getBag(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Bag for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Bag
	 * @param dataset the IDataset containing the data
	 * @return a List of Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Bag> getAllBag(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllBag(null, dataset);
	}
	
	/**
	 * Return an instance of Bag for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Bag
	 * @param graph the NamedGraph containing the data
	 * @return a List of Bag
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Bag> getAllBag(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllBag(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isAltPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Alt.commentProperty) ||
			predicate.equals(Alt.labelProperty) ||
			predicate.equals(Alt.typeProperty) ||
			predicate.equals(Alt.valueProperty) ||
			predicate.equals(Alt.isDefinedByProperty) ||
			predicate.equals(Alt.memberProperty) ||
			predicate.equals(Alt.seeAlsoProperty) ;
	}
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Alt
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt createAlt(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Alt result= org.openanzo.rdf.rdfs.AltImpl.createAlt(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Alt
	 * @param dataset the IDataset containing the data
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt createAlt(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createAlt(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Alt
	 * @param dataset the IDataset containing the data
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt createAlt(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAlt(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Alt
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt createAlt(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAlt(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Alt
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt createAlt(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createAlt(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Alt
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt createAlt(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAlt(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Alt.  Leaves the dataset unchanged.
	 * @param resource The resource of the Alt
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt getAlt(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs.AltImpl.getAlt(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Alt
	 * @param dataset the IDataset containing the data
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt getAlt(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAlt(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Alt
	 * @param dataset the IDataset containing the data
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt getAlt(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAlt(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Alt
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt getAlt(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAlt(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Alt
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt getAlt(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAlt(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Alt.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Alt
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Alt getAlt(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAlt(resource, graph);
	}
	
	/**
	 * Return an instance of Alt for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Alt
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Alt> getAllAlt(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Alt.TYPE,_namedGraphUri);
		java.util.List<Alt> list = new java.util.ArrayList<Alt>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getAlt(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Alt for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Alt
	 * @param dataset the IDataset containing the data
	 * @return a List of Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Alt> getAllAlt(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllAlt(null, dataset);
	}
	
	/**
	 * Return an instance of Alt for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Alt
	 * @param graph the NamedGraph containing the data
	 * @return a List of Alt
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Alt> getAllAlt(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllAlt(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean is_ResourcePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(_Resource.commentProperty) ||
			predicate.equals(_Resource.labelProperty) ||
			predicate.equals(_Resource.typeProperty) ||
			predicate.equals(_Resource.valueProperty) ||
			predicate.equals(_Resource.isDefinedByProperty) ||
			predicate.equals(_Resource.memberProperty) ||
			predicate.equals(_Resource.seeAlsoProperty) ;
	}
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Resource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource create_Resource(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		_Resource result= org.openanzo.rdf.rdfs._ResourceImpl.create_Resource(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Resource
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource create_Resource(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return create_Resource(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Resource
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource create_Resource(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return create_Resource(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Resource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource create_Resource(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return create_Resource(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Resource
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource create_Resource(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return create_Resource(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Resource
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource create_Resource(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return create_Resource(resource, graph);
	}
	
	
	/**
	 * Create a new instance of _Resource.  Leaves the dataset unchanged.
	 * @param resource The resource of the _Resource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource get_Resource(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs._ResourceImpl.get_Resource(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Resource
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource get_Resource(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return get_Resource(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Resource
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource get_Resource(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return get_Resource(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Resource
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource get_Resource(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return get_Resource(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Resource
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource get_Resource(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return get_Resource(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of _Resource.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Resource
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Resource get_Resource(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return get_Resource(resource, graph);
	}
	
	/**
	 * Return an instance of _Resource for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Resource
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<_Resource> getAll_Resource(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,_Resource.TYPE,_namedGraphUri);
		java.util.List<_Resource> list = new java.util.ArrayList<_Resource>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(get_Resource(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of _Resource for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Resource
	 * @param dataset the IDataset containing the data
	 * @return a List of _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<_Resource> getAll_Resource(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAll_Resource(null, dataset);
	}
	
	/**
	 * Return an instance of _Resource for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Resource
	 * @param graph the NamedGraph containing the data
	 * @return a List of _Resource
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<_Resource> getAll_Resource(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAll_Resource(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean is_PropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(_Property.commentProperty) ||
			predicate.equals(_Property.labelProperty) ||
			predicate.equals(_Property.typeProperty) ||
			predicate.equals(_Property.valueProperty) ||
			predicate.equals(_Property.isDefinedByProperty) ||
			predicate.equals(_Property.memberProperty) ||
			predicate.equals(_Property.seeAlsoProperty) ||
			predicate.equals(_Property.domainProperty) ||
			predicate.equals(_Property.rangeProperty) ||
			predicate.equals(_Property.subPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Property
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property create_Property(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		_Property result= org.openanzo.rdf.rdfs._PropertyImpl.create_Property(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Property
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property create_Property(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return create_Property(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Property
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property create_Property(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return create_Property(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Property
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property create_Property(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return create_Property(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Property
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property create_Property(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return create_Property(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Property
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property create_Property(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return create_Property(resource, graph);
	}
	
	
	/**
	 * Create a new instance of _Property.  Leaves the dataset unchanged.
	 * @param resource The resource of the _Property
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property get_Property(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs._PropertyImpl.get_Property(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Property
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property get_Property(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return get_Property(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Property
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property get_Property(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return get_Property(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Property
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property get_Property(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return get_Property(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Property
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property get_Property(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return get_Property(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of _Property.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Property
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Property get_Property(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return get_Property(resource, graph);
	}
	
	/**
	 * Return an instance of _Property for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Property
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<_Property> getAll_Property(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,_Property.TYPE,_namedGraphUri);
		java.util.List<_Property> list = new java.util.ArrayList<_Property>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(get_Property(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of _Property for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Property
	 * @param dataset the IDataset containing the data
	 * @return a List of _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<_Property> getAll_Property(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAll_Property(null, dataset);
	}
	
	/**
	 * Return an instance of _Property for every resource in the dataset with rdf:Type http://www.w3.org/1999/02/22-rdf-syntax-ns#Property
	 * @param graph the NamedGraph containing the data
	 * @return a List of _Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<_Property> getAll_Property(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAll_Property(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isDatatypePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Datatype.commentProperty) ||
			predicate.equals(Datatype.labelProperty) ||
			predicate.equals(Datatype.typeProperty) ||
			predicate.equals(Datatype.valueProperty) ||
			predicate.equals(Datatype.isDefinedByProperty) ||
			predicate.equals(Datatype.memberProperty) ||
			predicate.equals(Datatype.seeAlsoProperty) ||
			predicate.equals(Datatype.subClassOfProperty) ;
	}
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datatype
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype createDatatype(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Datatype result= org.openanzo.rdf.rdfs.DatatypeImpl.createDatatype(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datatype
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype createDatatype(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createDatatype(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datatype
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype createDatatype(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatatype(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datatype
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype createDatatype(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatatype(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datatype
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype createDatatype(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createDatatype(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datatype
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype createDatatype(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatatype(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Datatype.  Leaves the dataset unchanged.
	 * @param resource The resource of the Datatype
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype getDatatype(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs.DatatypeImpl.getDatatype(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datatype
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype getDatatype(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getDatatype(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datatype
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype getDatatype(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatatype(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datatype
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype getDatatype(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatatype(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Datatype
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype getDatatype(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getDatatype(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Datatype.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Datatype
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Datatype getDatatype(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatatype(resource, graph);
	}
	
	/**
	 * Return an instance of Datatype for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Datatype
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Datatype> getAllDatatype(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Datatype.TYPE,_namedGraphUri);
		java.util.List<Datatype> list = new java.util.ArrayList<Datatype>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getDatatype(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Datatype for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Datatype
	 * @param dataset the IDataset containing the data
	 * @return a List of Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Datatype> getAllDatatype(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllDatatype(null, dataset);
	}
	
	/**
	 * Return an instance of Datatype for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Datatype
	 * @param graph the NamedGraph containing the data
	 * @return a List of Datatype
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Datatype> getAllDatatype(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllDatatype(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isContainerPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Container.commentProperty) ||
			predicate.equals(Container.labelProperty) ||
			predicate.equals(Container.typeProperty) ||
			predicate.equals(Container.valueProperty) ||
			predicate.equals(Container.isDefinedByProperty) ||
			predicate.equals(Container.memberProperty) ||
			predicate.equals(Container.seeAlsoProperty) ;
	}
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Container
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container createContainer(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Container result= org.openanzo.rdf.rdfs.ContainerImpl.createContainer(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Container
	 * @param dataset the IDataset containing the data
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container createContainer(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createContainer(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Container
	 * @param dataset the IDataset containing the data
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container createContainer(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createContainer(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Container
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container createContainer(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createContainer(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Container
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container createContainer(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createContainer(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Container
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container createContainer(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createContainer(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Container.  Leaves the dataset unchanged.
	 * @param resource The resource of the Container
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container getContainer(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs.ContainerImpl.getContainer(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Container
	 * @param dataset the IDataset containing the data
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container getContainer(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getContainer(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Container
	 * @param dataset the IDataset containing the data
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container getContainer(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getContainer(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Container
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container getContainer(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getContainer(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Container
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container getContainer(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getContainer(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Container.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Container
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Container getContainer(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getContainer(resource, graph);
	}
	
	/**
	 * Return an instance of Container for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Container
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Container> getAllContainer(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Container.TYPE,_namedGraphUri);
		java.util.List<Container> list = new java.util.ArrayList<Container>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getContainer(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Container for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Container
	 * @param dataset the IDataset containing the data
	 * @return a List of Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Container> getAllContainer(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllContainer(null, dataset);
	}
	
	/**
	 * Return an instance of Container for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Container
	 * @param graph the NamedGraph containing the data
	 * @return a List of Container
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Container> getAllContainer(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllContainer(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isContainerMembershipPropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ContainerMembershipProperty.commentProperty) ||
			predicate.equals(ContainerMembershipProperty.labelProperty) ||
			predicate.equals(ContainerMembershipProperty.typeProperty) ||
			predicate.equals(ContainerMembershipProperty.valueProperty) ||
			predicate.equals(ContainerMembershipProperty.isDefinedByProperty) ||
			predicate.equals(ContainerMembershipProperty.memberProperty) ||
			predicate.equals(ContainerMembershipProperty.seeAlsoProperty) ||
			predicate.equals(ContainerMembershipProperty.domainProperty) ||
			predicate.equals(ContainerMembershipProperty.rangeProperty) ||
			predicate.equals(ContainerMembershipProperty.subPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ContainerMembershipProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty createContainerMembershipProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		ContainerMembershipProperty result= org.openanzo.rdf.rdfs.ContainerMembershipPropertyImpl.createContainerMembershipProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ContainerMembershipProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty createContainerMembershipProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createContainerMembershipProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ContainerMembershipProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty createContainerMembershipProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createContainerMembershipProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ContainerMembershipProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty createContainerMembershipProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createContainerMembershipProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ContainerMembershipProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty createContainerMembershipProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createContainerMembershipProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ContainerMembershipProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty createContainerMembershipProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createContainerMembershipProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the ContainerMembershipProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty getContainerMembershipProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs.ContainerMembershipPropertyImpl.getContainerMembershipProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ContainerMembershipProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty getContainerMembershipProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getContainerMembershipProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ContainerMembershipProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty getContainerMembershipProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getContainerMembershipProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ContainerMembershipProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty getContainerMembershipProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getContainerMembershipProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ContainerMembershipProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty getContainerMembershipProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getContainerMembershipProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ContainerMembershipProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ContainerMembershipProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ContainerMembershipProperty getContainerMembershipProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getContainerMembershipProperty(resource, graph);
	}
	
	/**
	 * Return an instance of ContainerMembershipProperty for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#ContainerMembershipProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ContainerMembershipProperty> getAllContainerMembershipProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,ContainerMembershipProperty.TYPE,_namedGraphUri);
		java.util.List<ContainerMembershipProperty> list = new java.util.ArrayList<ContainerMembershipProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getContainerMembershipProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of ContainerMembershipProperty for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#ContainerMembershipProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ContainerMembershipProperty> getAllContainerMembershipProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllContainerMembershipProperty(null, dataset);
	}
	
	/**
	 * Return an instance of ContainerMembershipProperty for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#ContainerMembershipProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of ContainerMembershipProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ContainerMembershipProperty> getAllContainerMembershipProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllContainerMembershipProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isLiteralPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Literal.commentProperty) ||
			predicate.equals(Literal.labelProperty) ||
			predicate.equals(Literal.typeProperty) ||
			predicate.equals(Literal.valueProperty) ||
			predicate.equals(Literal.isDefinedByProperty) ||
			predicate.equals(Literal.memberProperty) ||
			predicate.equals(Literal.seeAlsoProperty) ;
	}
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Literal
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal createLiteral(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Literal result= org.openanzo.rdf.rdfs.LiteralImpl.createLiteral(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Literal
	 * @param dataset the IDataset containing the data
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal createLiteral(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createLiteral(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Literal
	 * @param dataset the IDataset containing the data
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal createLiteral(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createLiteral(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Literal
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal createLiteral(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createLiteral(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Literal
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal createLiteral(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createLiteral(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Literal
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal createLiteral(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createLiteral(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Literal.  Leaves the dataset unchanged.
	 * @param resource The resource of the Literal
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal getLiteral(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.rdfs.LiteralImpl.getLiteral(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Literal
	 * @param dataset the IDataset containing the data
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal getLiteral(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getLiteral(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Literal
	 * @param dataset the IDataset containing the data
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal getLiteral(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getLiteral(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Literal
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal getLiteral(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getLiteral(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Literal
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal getLiteral(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getLiteral(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Literal.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Literal
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Literal getLiteral(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getLiteral(resource, graph);
	}
	
	/**
	 * Return an instance of Literal for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Literal
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Literal> getAllLiteral(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Literal.TYPE,_namedGraphUri);
		java.util.List<Literal> list = new java.util.ArrayList<Literal>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getLiteral(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Literal for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Literal
	 * @param dataset the IDataset containing the data
	 * @return a List of Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Literal> getAllLiteral(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllLiteral(null, dataset);
	}
	
	/**
	 * Return an instance of Literal for every resource in the dataset with rdf:Type http://www.w3.org/2000/01/rdf-schema#Literal
	 * @param graph the NamedGraph containing the data
	 * @return a List of Literal
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Literal> getAllLiteral(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllLiteral(graph.getNamedGraphUri(), dataset);
	}



	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 * @throws org.openanzo.rdf.jastor.JastorException 
	 */
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), namedGraphUri)) {
			return getLiteral(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#ContainerMembershipProperty"), namedGraphUri)) {
			return getContainerMembershipProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"), namedGraphUri)) {
			return get_Property(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Datatype"), namedGraphUri)) {
			return getDatatype(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Class"), namedGraphUri)) {
			return getClass(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#Alt"), namedGraphUri)) {
			return getAlt(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#Bag"), namedGraphUri)) {
			return getBag(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#Seq"), namedGraphUri)) {
			return getSeq(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Container"), namedGraphUri)) {
			return getContainer(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#List"), namedGraphUri)) {
			return getList(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), namedGraphUri)) {
			return get_Resource(resource, namedGraphUri, dataset);
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
	 * in the RDFS ontology.
	 * @param type the type for which to find compatible interfaces
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> listCompatibleInterfaces (org.openanzo.rdf.Resource type) {
		java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> types = new java.util.ArrayList<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>>();
		if (type.equals(org.openanzo.rdf.rdfs.List.TYPE)) {
			types.add(org.openanzo.rdf.rdfs.List.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs.Seq.TYPE)) {
			types.add(org.openanzo.rdf.rdfs.Seq.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs.Class.TYPE)) {
			types.add(org.openanzo.rdf.rdfs.Class.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs.Bag.TYPE)) {
			types.add(org.openanzo.rdf.rdfs.Bag.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs.Alt.TYPE)) {
			types.add(org.openanzo.rdf.rdfs.Alt.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs._Resource.TYPE)) {
			types.add(org.openanzo.rdf.rdfs._Resource.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs._Property.TYPE)) {
			types.add(org.openanzo.rdf.rdfs._Property.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs.Datatype.TYPE)) {
			types.add(org.openanzo.rdf.rdfs.Datatype.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs.Container.TYPE)) {
			types.add(org.openanzo.rdf.rdfs.Container.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs.ContainerMembershipProperty.TYPE)) {
			types.add(org.openanzo.rdf.rdfs.ContainerMembershipProperty.class);
		}
		if (type.equals(org.openanzo.rdf.rdfs.Literal.TYPE)) {
			types.add(org.openanzo.rdf.rdfs.Literal.class);
		}
		return types;
	}
}