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

package org.openanzo.rdf.owl;

/**
 * Factory for instantiating objects for ontology classes in the OWL11 ontology.  The
 * get methods leave the dataset unchanged and return a Java view of the object in the dataset.  The create methods
 * may add certain baseline properties to the dataset such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://www.w3.org/2002/07/owl#OWL11)</p>
 * <br>
 * <br>
 * <br>
 */
public class OWL11Factory extends org.openanzo.rdf.jastor.ThingFactory { 


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isOWLEntityPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(OWLEntity.commentProperty) ||
			predicate.equals(OWLEntity.labelProperty) ||
			predicate.equals(OWLEntity.typeProperty) ||
			predicate.equals(OWLEntity.valueProperty) ||
			predicate.equals(OWLEntity.isDefinedByProperty) ||
			predicate.equals(OWLEntity.memberProperty) ||
			predicate.equals(OWLEntity.seeAlsoProperty) ||
			predicate.equals(OWLEntity.differentFromProperty) ||
			predicate.equals(OWLEntity.sameAsProperty) ;
	}
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OWLEntity
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity createOWLEntity(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		OWLEntity result= org.openanzo.rdf.owl.OWLEntityImpl.createOWLEntity(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OWLEntity
	 * @param dataset the IDataset containing the data
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity createOWLEntity(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createOWLEntity(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OWLEntity
	 * @param dataset the IDataset containing the data
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity createOWLEntity(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOWLEntity(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OWLEntity
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity createOWLEntity(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOWLEntity(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OWLEntity
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity createOWLEntity(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createOWLEntity(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OWLEntity
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity createOWLEntity(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOWLEntity(resource, graph);
	}
	
	
	/**
	 * Create a new instance of OWLEntity.  Leaves the dataset unchanged.
	 * @param resource The resource of the OWLEntity
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity getOWLEntity(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.OWLEntityImpl.getOWLEntity(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OWLEntity
	 * @param dataset the IDataset containing the data
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity getOWLEntity(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getOWLEntity(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OWLEntity
	 * @param dataset the IDataset containing the data
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity getOWLEntity(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOWLEntity(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OWLEntity
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity getOWLEntity(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOWLEntity(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OWLEntity
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity getOWLEntity(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getOWLEntity(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OWLEntity.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OWLEntity
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OWLEntity getOWLEntity(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOWLEntity(resource, graph);
	}
	
	/**
	 * Return an instance of OWLEntity for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#OWLEntity
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OWLEntity> getAllOWLEntity(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,OWLEntity.TYPE,_namedGraphUri);
		java.util.List<OWLEntity> list = new java.util.ArrayList<OWLEntity>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getOWLEntity(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of OWLEntity for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#OWLEntity
	 * @param dataset the IDataset containing the data
	 * @return a List of OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OWLEntity> getAllOWLEntity(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllOWLEntity(null, dataset);
	}
	
	/**
	 * Return an instance of OWLEntity for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#OWLEntity
	 * @param graph the NamedGraph containing the data
	 * @return a List of OWLEntity
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OWLEntity> getAllOWLEntity(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllOWLEntity(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isDatatypePropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(DatatypeProperty.commentProperty) ||
			predicate.equals(DatatypeProperty.labelProperty) ||
			predicate.equals(DatatypeProperty.typeProperty) ||
			predicate.equals(DatatypeProperty.valueProperty) ||
			predicate.equals(DatatypeProperty.isDefinedByProperty) ||
			predicate.equals(DatatypeProperty.memberProperty) ||
			predicate.equals(DatatypeProperty.seeAlsoProperty) ||
			predicate.equals(DatatypeProperty.domainProperty) ||
			predicate.equals(DatatypeProperty.rangeProperty) ||
			predicate.equals(DatatypeProperty.subPropertyOfProperty) ||
			predicate.equals(DatatypeProperty.equivalentPropertyProperty) ||
			predicate.equals(DatatypeProperty.dataPropertyDomainProperty) ||
			predicate.equals(DatatypeProperty.dataPropertyRangeProperty) ||
			predicate.equals(DatatypeProperty.disjointDataPropertiesProperty) ||
			predicate.equals(DatatypeProperty.equivalentDataPropertyProperty) ||
			predicate.equals(DatatypeProperty.subDataPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatatypeProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty createDatatypeProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		DatatypeProperty result= org.openanzo.rdf.owl.DatatypePropertyImpl.createDatatypeProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatatypeProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty createDatatypeProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createDatatypeProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatatypeProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty createDatatypeProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatatypeProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatatypeProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty createDatatypeProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatatypeProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatatypeProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty createDatatypeProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createDatatypeProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatatypeProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty createDatatypeProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDatatypeProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of DatatypeProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the DatatypeProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty getDatatypeProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.DatatypePropertyImpl.getDatatypeProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatatypeProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty getDatatypeProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getDatatypeProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatatypeProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty getDatatypeProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatatypeProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatatypeProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty getDatatypeProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatatypeProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DatatypeProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty getDatatypeProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getDatatypeProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DatatypeProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DatatypeProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DatatypeProperty getDatatypeProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDatatypeProperty(resource, graph);
	}
	
	/**
	 * Return an instance of DatatypeProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#DatatypeProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DatatypeProperty> getAllDatatypeProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,DatatypeProperty.TYPE,_namedGraphUri);
		java.util.List<DatatypeProperty> list = new java.util.ArrayList<DatatypeProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getDatatypeProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of DatatypeProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#DatatypeProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DatatypeProperty> getAllDatatypeProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllDatatypeProperty(null, dataset);
	}
	
	/**
	 * Return an instance of DatatypeProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#DatatypeProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of DatatypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DatatypeProperty> getAllDatatypeProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllDatatypeProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Constant
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant createConstant(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Constant result= org.openanzo.rdf.owl.ConstantImpl.createConstant(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Constant
	 * @param dataset the IDataset containing the data
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant createConstant(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createConstant(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Constant
	 * @param dataset the IDataset containing the data
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant createConstant(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createConstant(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Constant
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant createConstant(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createConstant(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Constant
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant createConstant(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createConstant(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Constant
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant createConstant(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createConstant(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Constant.  Leaves the dataset unchanged.
	 * @param resource The resource of the Constant
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant getConstant(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.ConstantImpl.getConstant(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Constant
	 * @param dataset the IDataset containing the data
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant getConstant(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getConstant(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Constant
	 * @param dataset the IDataset containing the data
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant getConstant(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getConstant(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Constant
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant getConstant(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getConstant(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Constant
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant getConstant(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getConstant(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Constant.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Constant
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Constant getConstant(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getConstant(resource, graph);
	}
	
	/**
	 * Return an instance of Constant for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Constant
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Constant> getAllConstant(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Constant.TYPE,_namedGraphUri);
		java.util.List<Constant> list = new java.util.ArrayList<Constant>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getConstant(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Constant for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Constant
	 * @param dataset the IDataset containing the data
	 * @return a List of Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Constant> getAllConstant(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllConstant(null, dataset);
	}
	
	/**
	 * Return an instance of Constant for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Constant
	 * @param graph the NamedGraph containing the data
	 * @return a List of Constant
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Constant> getAllConstant(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllConstant(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isIndividualPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Individual.commentProperty) ||
			predicate.equals(Individual.labelProperty) ||
			predicate.equals(Individual.typeProperty) ||
			predicate.equals(Individual.valueProperty) ||
			predicate.equals(Individual.isDefinedByProperty) ||
			predicate.equals(Individual.memberProperty) ||
			predicate.equals(Individual.seeAlsoProperty) ||
			predicate.equals(Individual.differentFromProperty) ||
			predicate.equals(Individual.sameAsProperty) ;
	}
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Individual
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual createIndividual(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Individual result= org.openanzo.rdf.owl.IndividualImpl.createIndividual(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Individual
	 * @param dataset the IDataset containing the data
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual createIndividual(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createIndividual(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Individual
	 * @param dataset the IDataset containing the data
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual createIndividual(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createIndividual(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Individual
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual createIndividual(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createIndividual(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Individual
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual createIndividual(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createIndividual(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Individual
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual createIndividual(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createIndividual(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Individual.  Leaves the dataset unchanged.
	 * @param resource The resource of the Individual
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual getIndividual(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.IndividualImpl.getIndividual(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Individual
	 * @param dataset the IDataset containing the data
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual getIndividual(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getIndividual(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Individual
	 * @param dataset the IDataset containing the data
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual getIndividual(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getIndividual(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Individual
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual getIndividual(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getIndividual(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Individual
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual getIndividual(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getIndividual(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Individual.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Individual
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Individual getIndividual(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getIndividual(resource, graph);
	}
	
	/**
	 * Return an instance of Individual for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Individual
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Individual> getAllIndividual(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Individual.TYPE,_namedGraphUri);
		java.util.List<Individual> list = new java.util.ArrayList<Individual>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getIndividual(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Individual for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Individual
	 * @param dataset the IDataset containing the data
	 * @return a List of Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Individual> getAllIndividual(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllIndividual(null, dataset);
	}
	
	/**
	 * Return an instance of Individual for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Individual
	 * @param graph the NamedGraph containing the data
	 * @return a List of Individual
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Individual> getAllIndividual(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllIndividual(graph.getNamedGraphUri(), dataset);
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
			predicate.equals(Class.subClassOfProperty) ||
			predicate.equals(Class.oneOfProperty) ||
			predicate.equals(Class.disjointWithProperty) ||
			predicate.equals(Class.equivalentClassProperty) ||
			predicate.equals(Class.intersectionOfProperty) ||
			predicate.equals(Class.unionOfProperty) ||
			predicate.equals(Class.disjointUnionOfProperty) ;
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
		Class result= org.openanzo.rdf.owl.ClassImpl.createClass(resource,_namedGraphUri,dataset);
		
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
		return org.openanzo.rdf.owl.ClassImpl.getClass(resource, _namedGraphUri,dataset);
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
	 * Return an instance of Class for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Class
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
	 * Return an instance of Class for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Class
	 * @param dataset the IDataset containing the data
	 * @return a List of Class
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Class> getAllClass(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllClass(null, dataset);
	}
	
	/**
	 * Return an instance of Class for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Class
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
	public static boolean isDataRestrictionPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(DataRestriction.maxCardinalityProperty) ||
			predicate.equals(DataRestriction.minCardinalityProperty) ||
			predicate.equals(DataRestriction.cardinalityProperty) ||
			predicate.equals(DataRestriction.onPropertyProperty) ||
			predicate.equals(DataRestriction.onDataRangeProperty) ;
	}
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRestriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction createDataRestriction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		DataRestriction result= org.openanzo.rdf.owl.DataRestrictionImpl.createDataRestriction(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRestriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction createDataRestriction(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createDataRestriction(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRestriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction createDataRestriction(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDataRestriction(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRestriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction createDataRestriction(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDataRestriction(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRestriction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction createDataRestriction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createDataRestriction(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRestriction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction createDataRestriction(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDataRestriction(resource, graph);
	}
	
	
	/**
	 * Create a new instance of DataRestriction.  Leaves the dataset unchanged.
	 * @param resource The resource of the DataRestriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction getDataRestriction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.DataRestrictionImpl.getDataRestriction(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRestriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction getDataRestriction(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getDataRestriction(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRestriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction getDataRestriction(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDataRestriction(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRestriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction getDataRestriction(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDataRestriction(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRestriction
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction getDataRestriction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getDataRestriction(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DataRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRestriction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRestriction getDataRestriction(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDataRestriction(resource, graph);
	}
	
	/**
	 * Return an instance of DataRestriction for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#DataRestriction
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DataRestriction> getAllDataRestriction(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,DataRestriction.TYPE,_namedGraphUri);
		java.util.List<DataRestriction> list = new java.util.ArrayList<DataRestriction>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getDataRestriction(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of DataRestriction for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#DataRestriction
	 * @param dataset the IDataset containing the data
	 * @return a List of DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DataRestriction> getAllDataRestriction(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllDataRestriction(null, dataset);
	}
	
	/**
	 * Return an instance of DataRestriction for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#DataRestriction
	 * @param graph the NamedGraph containing the data
	 * @return a List of DataRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DataRestriction> getAllDataRestriction(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllDataRestriction(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isIrreflexivePropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(IrreflexiveProperty.commentProperty) ||
			predicate.equals(IrreflexiveProperty.labelProperty) ||
			predicate.equals(IrreflexiveProperty.typeProperty) ||
			predicate.equals(IrreflexiveProperty.valueProperty) ||
			predicate.equals(IrreflexiveProperty.isDefinedByProperty) ||
			predicate.equals(IrreflexiveProperty.memberProperty) ||
			predicate.equals(IrreflexiveProperty.seeAlsoProperty) ||
			predicate.equals(IrreflexiveProperty.domainProperty) ||
			predicate.equals(IrreflexiveProperty.rangeProperty) ||
			predicate.equals(IrreflexiveProperty.subPropertyOfProperty) ||
			predicate.equals(IrreflexiveProperty.inverseOfProperty) ||
			predicate.equals(IrreflexiveProperty.disjointObjectPropertiesProperty) ||
			predicate.equals(IrreflexiveProperty.equivalentObjectPropertyProperty) ||
			predicate.equals(IrreflexiveProperty.objectPropertyDomainProperty) ||
			predicate.equals(IrreflexiveProperty.objectPropertyRangeProperty) ||
			predicate.equals(IrreflexiveProperty.subObjectPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the IrreflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty createIrreflexiveProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		IrreflexiveProperty result= org.openanzo.rdf.owl.IrreflexivePropertyImpl.createIrreflexiveProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the IrreflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty createIrreflexiveProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createIrreflexiveProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the IrreflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty createIrreflexiveProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createIrreflexiveProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the IrreflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty createIrreflexiveProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createIrreflexiveProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the IrreflexiveProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty createIrreflexiveProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createIrreflexiveProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the IrreflexiveProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty createIrreflexiveProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createIrreflexiveProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the IrreflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty getIrreflexiveProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.IrreflexivePropertyImpl.getIrreflexiveProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the IrreflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty getIrreflexiveProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getIrreflexiveProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the IrreflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty getIrreflexiveProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getIrreflexiveProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the IrreflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty getIrreflexiveProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getIrreflexiveProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the IrreflexiveProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty getIrreflexiveProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getIrreflexiveProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of IrreflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the IrreflexiveProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static IrreflexiveProperty getIrreflexiveProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getIrreflexiveProperty(resource, graph);
	}
	
	/**
	 * Return an instance of IrreflexiveProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#IrreflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<IrreflexiveProperty> getAllIrreflexiveProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,IrreflexiveProperty.TYPE,_namedGraphUri);
		java.util.List<IrreflexiveProperty> list = new java.util.ArrayList<IrreflexiveProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getIrreflexiveProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of IrreflexiveProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#IrreflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<IrreflexiveProperty> getAllIrreflexiveProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllIrreflexiveProperty(null, dataset);
	}
	
	/**
	 * Return an instance of IrreflexiveProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#IrreflexiveProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of IrreflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<IrreflexiveProperty> getAllIrreflexiveProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllIrreflexiveProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isOntologyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Ontology.ImportsProperty) ;
	}
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Ontology
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology createOntology(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Ontology result= org.openanzo.rdf.owl.OntologyImpl.createOntology(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Ontology
	 * @param dataset the IDataset containing the data
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology createOntology(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createOntology(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Ontology
	 * @param dataset the IDataset containing the data
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology createOntology(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOntology(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Ontology
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology createOntology(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOntology(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Ontology
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology createOntology(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createOntology(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Ontology
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology createOntology(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOntology(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Ontology.  Leaves the dataset unchanged.
	 * @param resource The resource of the Ontology
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology getOntology(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.OntologyImpl.getOntology(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Ontology
	 * @param dataset the IDataset containing the data
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology getOntology(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getOntology(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Ontology
	 * @param dataset the IDataset containing the data
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology getOntology(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOntology(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Ontology
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology getOntology(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOntology(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Ontology
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology getOntology(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getOntology(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Ontology.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Ontology
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Ontology getOntology(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOntology(resource, graph);
	}
	
	/**
	 * Return an instance of Ontology for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Ontology
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Ontology> getAllOntology(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Ontology.TYPE,_namedGraphUri);
		java.util.List<Ontology> list = new java.util.ArrayList<Ontology>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getOntology(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Ontology for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Ontology
	 * @param dataset the IDataset containing the data
	 * @return a List of Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Ontology> getAllOntology(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllOntology(null, dataset);
	}
	
	/**
	 * Return an instance of Ontology for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Ontology
	 * @param graph the NamedGraph containing the data
	 * @return a List of Ontology
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Ontology> getAllOntology(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllOntology(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isSymmetricPropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(SymmetricProperty.commentProperty) ||
			predicate.equals(SymmetricProperty.labelProperty) ||
			predicate.equals(SymmetricProperty.typeProperty) ||
			predicate.equals(SymmetricProperty.valueProperty) ||
			predicate.equals(SymmetricProperty.isDefinedByProperty) ||
			predicate.equals(SymmetricProperty.memberProperty) ||
			predicate.equals(SymmetricProperty.seeAlsoProperty) ||
			predicate.equals(SymmetricProperty.domainProperty) ||
			predicate.equals(SymmetricProperty.rangeProperty) ||
			predicate.equals(SymmetricProperty.subPropertyOfProperty) ||
			predicate.equals(SymmetricProperty.inverseOfProperty) ||
			predicate.equals(SymmetricProperty.disjointObjectPropertiesProperty) ||
			predicate.equals(SymmetricProperty.equivalentObjectPropertyProperty) ||
			predicate.equals(SymmetricProperty.objectPropertyDomainProperty) ||
			predicate.equals(SymmetricProperty.objectPropertyRangeProperty) ||
			predicate.equals(SymmetricProperty.subObjectPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty createSymmetricProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		SymmetricProperty result= org.openanzo.rdf.owl.SymmetricPropertyImpl.createSymmetricProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty createSymmetricProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createSymmetricProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty createSymmetricProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSymmetricProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty createSymmetricProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSymmetricProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SymmetricProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty createSymmetricProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createSymmetricProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SymmetricProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty createSymmetricProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSymmetricProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of SymmetricProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the SymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty getSymmetricProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.SymmetricPropertyImpl.getSymmetricProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty getSymmetricProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getSymmetricProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty getSymmetricProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSymmetricProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty getSymmetricProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSymmetricProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SymmetricProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty getSymmetricProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getSymmetricProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of SymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SymmetricProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SymmetricProperty getSymmetricProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSymmetricProperty(resource, graph);
	}
	
	/**
	 * Return an instance of SymmetricProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#SymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<SymmetricProperty> getAllSymmetricProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,SymmetricProperty.TYPE,_namedGraphUri);
		java.util.List<SymmetricProperty> list = new java.util.ArrayList<SymmetricProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getSymmetricProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of SymmetricProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#SymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<SymmetricProperty> getAllSymmetricProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllSymmetricProperty(null, dataset);
	}
	
	/**
	 * Return an instance of SymmetricProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#SymmetricProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of SymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<SymmetricProperty> getAllSymmetricProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllSymmetricProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isFunctionalPropetyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(FunctionalPropety.commentProperty) ||
			predicate.equals(FunctionalPropety.labelProperty) ||
			predicate.equals(FunctionalPropety.typeProperty) ||
			predicate.equals(FunctionalPropety.valueProperty) ||
			predicate.equals(FunctionalPropety.isDefinedByProperty) ||
			predicate.equals(FunctionalPropety.memberProperty) ||
			predicate.equals(FunctionalPropety.seeAlsoProperty) ||
			predicate.equals(FunctionalPropety.domainProperty) ||
			predicate.equals(FunctionalPropety.rangeProperty) ||
			predicate.equals(FunctionalPropety.subPropertyOfProperty) ||
			predicate.equals(FunctionalPropety.equivalentPropertyProperty) ||
			predicate.equals(FunctionalPropety.dataPropertyDomainProperty) ||
			predicate.equals(FunctionalPropety.dataPropertyRangeProperty) ||
			predicate.equals(FunctionalPropety.disjointDataPropertiesProperty) ||
			predicate.equals(FunctionalPropety.equivalentDataPropertyProperty) ||
			predicate.equals(FunctionalPropety.subDataPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalPropety
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety createFunctionalPropety(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		FunctionalPropety result= org.openanzo.rdf.owl.FunctionalPropetyImpl.createFunctionalPropety(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalPropety
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety createFunctionalPropety(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createFunctionalPropety(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalPropety
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety createFunctionalPropety(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalPropety(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalPropety
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety createFunctionalPropety(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalPropety(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalPropety
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety createFunctionalPropety(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createFunctionalPropety(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalPropety
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety createFunctionalPropety(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalPropety(resource, graph);
	}
	
	
	/**
	 * Create a new instance of FunctionalPropety.  Leaves the dataset unchanged.
	 * @param resource The resource of the FunctionalPropety
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety getFunctionalPropety(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.FunctionalPropetyImpl.getFunctionalPropety(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalPropety
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety getFunctionalPropety(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getFunctionalPropety(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalPropety
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety getFunctionalPropety(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalPropety(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalPropety
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety getFunctionalPropety(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalPropety(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalPropety
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety getFunctionalPropety(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getFunctionalPropety(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of FunctionalPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalPropety
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalPropety getFunctionalPropety(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalPropety(resource, graph);
	}
	
	/**
	 * Return an instance of FunctionalPropety for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#FunctionalPropety
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalPropety> getAllFunctionalPropety(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,FunctionalPropety.TYPE,_namedGraphUri);
		java.util.List<FunctionalPropety> list = new java.util.ArrayList<FunctionalPropety>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getFunctionalPropety(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of FunctionalPropety for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#FunctionalPropety
	 * @param dataset the IDataset containing the data
	 * @return a List of FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalPropety> getAllFunctionalPropety(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllFunctionalPropety(null, dataset);
	}
	
	/**
	 * Return an instance of FunctionalPropety for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#FunctionalPropety
	 * @param graph the NamedGraph containing the data
	 * @return a List of FunctionalPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalPropety> getAllFunctionalPropety(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllFunctionalPropety(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isDataRangePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(DataRange.oneOfProperty) ||
			predicate.equals(DataRange.complementOfProperty) ;
	}
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRange
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange createDataRange(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		DataRange result= org.openanzo.rdf.owl.DataRangeImpl.createDataRange(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRange
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange createDataRange(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createDataRange(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRange
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange createDataRange(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDataRange(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRange
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange createDataRange(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDataRange(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRange
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange createDataRange(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createDataRange(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRange
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange createDataRange(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDataRange(resource, graph);
	}
	
	
	/**
	 * Create a new instance of DataRange.  Leaves the dataset unchanged.
	 * @param resource The resource of the DataRange
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange getDataRange(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.DataRangeImpl.getDataRange(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRange
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange getDataRange(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getDataRange(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRange
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange getDataRange(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDataRange(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRange
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange getDataRange(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDataRange(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the DataRange
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange getDataRange(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getDataRange(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of DataRange.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the DataRange
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static DataRange getDataRange(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDataRange(resource, graph);
	}
	
	/**
	 * Return an instance of DataRange for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#DataRange
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DataRange> getAllDataRange(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,DataRange.TYPE,_namedGraphUri);
		java.util.List<DataRange> list = new java.util.ArrayList<DataRange>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getDataRange(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of DataRange for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#DataRange
	 * @param dataset the IDataset containing the data
	 * @return a List of DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DataRange> getAllDataRange(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllDataRange(null, dataset);
	}
	
	/**
	 * Return an instance of DataRange for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#DataRange
	 * @param graph the NamedGraph containing the data
	 * @return a List of DataRange
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<DataRange> getAllDataRange(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllDataRange(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isNothingPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Nothing.commentProperty) ||
			predicate.equals(Nothing.labelProperty) ||
			predicate.equals(Nothing.typeProperty) ||
			predicate.equals(Nothing.valueProperty) ||
			predicate.equals(Nothing.isDefinedByProperty) ||
			predicate.equals(Nothing.memberProperty) ||
			predicate.equals(Nothing.seeAlsoProperty) ||
			predicate.equals(Nothing.subClassOfProperty) ||
			predicate.equals(Nothing.oneOfProperty) ||
			predicate.equals(Nothing.disjointWithProperty) ||
			predicate.equals(Nothing.equivalentClassProperty) ||
			predicate.equals(Nothing.intersectionOfProperty) ||
			predicate.equals(Nothing.unionOfProperty) ||
			predicate.equals(Nothing.disjointUnionOfProperty) ;
	}
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Nothing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing createNothing(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Nothing result= org.openanzo.rdf.owl.NothingImpl.createNothing(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Nothing
	 * @param dataset the IDataset containing the data
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing createNothing(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createNothing(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Nothing
	 * @param dataset the IDataset containing the data
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing createNothing(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNothing(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Nothing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing createNothing(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNothing(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Nothing
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing createNothing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createNothing(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Nothing
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing createNothing(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createNothing(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Nothing.  Leaves the dataset unchanged.
	 * @param resource The resource of the Nothing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing getNothing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.NothingImpl.getNothing(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Nothing
	 * @param dataset the IDataset containing the data
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing getNothing(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getNothing(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Nothing
	 * @param dataset the IDataset containing the data
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing getNothing(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNothing(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Nothing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing getNothing(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNothing(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Nothing
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing getNothing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getNothing(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Nothing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Nothing
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Nothing getNothing(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getNothing(resource, graph);
	}
	
	/**
	 * Return an instance of Nothing for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Nothing
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Nothing> getAllNothing(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Nothing.TYPE,_namedGraphUri);
		java.util.List<Nothing> list = new java.util.ArrayList<Nothing>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getNothing(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Nothing for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Nothing
	 * @param dataset the IDataset containing the data
	 * @return a List of Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Nothing> getAllNothing(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllNothing(null, dataset);
	}
	
	/**
	 * Return an instance of Nothing for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Nothing
	 * @param graph the NamedGraph containing the data
	 * @return a List of Nothing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Nothing> getAllNothing(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllNothing(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isObjectRestrictionPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ObjectRestriction.maxCardinalityProperty) ||
			predicate.equals(ObjectRestriction.minCardinalityProperty) ||
			predicate.equals(ObjectRestriction.cardinalityProperty) ||
			predicate.equals(ObjectRestriction.onPropertyProperty) ||
			predicate.equals(ObjectRestriction.onClassProperty) ;
	}
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectRestriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction createObjectRestriction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		ObjectRestriction result= org.openanzo.rdf.owl.ObjectRestrictionImpl.createObjectRestriction(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectRestriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction createObjectRestriction(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createObjectRestriction(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectRestriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction createObjectRestriction(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createObjectRestriction(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectRestriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction createObjectRestriction(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createObjectRestriction(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectRestriction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction createObjectRestriction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createObjectRestriction(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectRestriction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction createObjectRestriction(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createObjectRestriction(resource, graph);
	}
	
	
	/**
	 * Create a new instance of ObjectRestriction.  Leaves the dataset unchanged.
	 * @param resource The resource of the ObjectRestriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction getObjectRestriction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.ObjectRestrictionImpl.getObjectRestriction(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectRestriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction getObjectRestriction(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getObjectRestriction(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectRestriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction getObjectRestriction(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getObjectRestriction(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectRestriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction getObjectRestriction(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getObjectRestriction(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectRestriction
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction getObjectRestriction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getObjectRestriction(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ObjectRestriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectRestriction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectRestriction getObjectRestriction(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getObjectRestriction(resource, graph);
	}
	
	/**
	 * Return an instance of ObjectRestriction for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#ObjectRestriction
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ObjectRestriction> getAllObjectRestriction(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,ObjectRestriction.TYPE,_namedGraphUri);
		java.util.List<ObjectRestriction> list = new java.util.ArrayList<ObjectRestriction>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getObjectRestriction(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of ObjectRestriction for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#ObjectRestriction
	 * @param dataset the IDataset containing the data
	 * @return a List of ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ObjectRestriction> getAllObjectRestriction(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllObjectRestriction(null, dataset);
	}
	
	/**
	 * Return an instance of ObjectRestriction for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#ObjectRestriction
	 * @param graph the NamedGraph containing the data
	 * @return a List of ObjectRestriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ObjectRestriction> getAllObjectRestriction(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllObjectRestriction(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isReflexivePropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ReflexiveProperty.commentProperty) ||
			predicate.equals(ReflexiveProperty.labelProperty) ||
			predicate.equals(ReflexiveProperty.typeProperty) ||
			predicate.equals(ReflexiveProperty.valueProperty) ||
			predicate.equals(ReflexiveProperty.isDefinedByProperty) ||
			predicate.equals(ReflexiveProperty.memberProperty) ||
			predicate.equals(ReflexiveProperty.seeAlsoProperty) ||
			predicate.equals(ReflexiveProperty.domainProperty) ||
			predicate.equals(ReflexiveProperty.rangeProperty) ||
			predicate.equals(ReflexiveProperty.subPropertyOfProperty) ||
			predicate.equals(ReflexiveProperty.inverseOfProperty) ||
			predicate.equals(ReflexiveProperty.disjointObjectPropertiesProperty) ||
			predicate.equals(ReflexiveProperty.equivalentObjectPropertyProperty) ||
			predicate.equals(ReflexiveProperty.objectPropertyDomainProperty) ||
			predicate.equals(ReflexiveProperty.objectPropertyRangeProperty) ||
			predicate.equals(ReflexiveProperty.subObjectPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty createReflexiveProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		ReflexiveProperty result= org.openanzo.rdf.owl.ReflexivePropertyImpl.createReflexiveProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty createReflexiveProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createReflexiveProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty createReflexiveProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createReflexiveProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty createReflexiveProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createReflexiveProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReflexiveProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty createReflexiveProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createReflexiveProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReflexiveProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty createReflexiveProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createReflexiveProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of ReflexiveProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the ReflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty getReflexiveProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.ReflexivePropertyImpl.getReflexiveProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty getReflexiveProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getReflexiveProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty getReflexiveProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getReflexiveProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty getReflexiveProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getReflexiveProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ReflexiveProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty getReflexiveProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getReflexiveProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ReflexiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ReflexiveProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ReflexiveProperty getReflexiveProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getReflexiveProperty(resource, graph);
	}
	
	/**
	 * Return an instance of ReflexiveProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#ReflexiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ReflexiveProperty> getAllReflexiveProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,ReflexiveProperty.TYPE,_namedGraphUri);
		java.util.List<ReflexiveProperty> list = new java.util.ArrayList<ReflexiveProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getReflexiveProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of ReflexiveProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#ReflexiveProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ReflexiveProperty> getAllReflexiveProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllReflexiveProperty(null, dataset);
	}
	
	/**
	 * Return an instance of ReflexiveProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#ReflexiveProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of ReflexiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ReflexiveProperty> getAllReflexiveProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllReflexiveProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isAntisymmetricPropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(AntisymmetricProperty.commentProperty) ||
			predicate.equals(AntisymmetricProperty.labelProperty) ||
			predicate.equals(AntisymmetricProperty.typeProperty) ||
			predicate.equals(AntisymmetricProperty.valueProperty) ||
			predicate.equals(AntisymmetricProperty.isDefinedByProperty) ||
			predicate.equals(AntisymmetricProperty.memberProperty) ||
			predicate.equals(AntisymmetricProperty.seeAlsoProperty) ||
			predicate.equals(AntisymmetricProperty.domainProperty) ||
			predicate.equals(AntisymmetricProperty.rangeProperty) ||
			predicate.equals(AntisymmetricProperty.subPropertyOfProperty) ||
			predicate.equals(AntisymmetricProperty.inverseOfProperty) ||
			predicate.equals(AntisymmetricProperty.disjointObjectPropertiesProperty) ||
			predicate.equals(AntisymmetricProperty.equivalentObjectPropertyProperty) ||
			predicate.equals(AntisymmetricProperty.objectPropertyDomainProperty) ||
			predicate.equals(AntisymmetricProperty.objectPropertyRangeProperty) ||
			predicate.equals(AntisymmetricProperty.subObjectPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AntisymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty createAntisymmetricProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		AntisymmetricProperty result= org.openanzo.rdf.owl.AntisymmetricPropertyImpl.createAntisymmetricProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AntisymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty createAntisymmetricProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createAntisymmetricProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AntisymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty createAntisymmetricProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAntisymmetricProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AntisymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty createAntisymmetricProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAntisymmetricProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AntisymmetricProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty createAntisymmetricProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createAntisymmetricProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AntisymmetricProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty createAntisymmetricProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAntisymmetricProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the AntisymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty getAntisymmetricProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.AntisymmetricPropertyImpl.getAntisymmetricProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AntisymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty getAntisymmetricProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAntisymmetricProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AntisymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty getAntisymmetricProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAntisymmetricProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AntisymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty getAntisymmetricProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAntisymmetricProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AntisymmetricProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty getAntisymmetricProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAntisymmetricProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AntisymmetricProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AntisymmetricProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AntisymmetricProperty getAntisymmetricProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAntisymmetricProperty(resource, graph);
	}
	
	/**
	 * Return an instance of AntisymmetricProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#AntisymmetricProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AntisymmetricProperty> getAllAntisymmetricProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,AntisymmetricProperty.TYPE,_namedGraphUri);
		java.util.List<AntisymmetricProperty> list = new java.util.ArrayList<AntisymmetricProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getAntisymmetricProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of AntisymmetricProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#AntisymmetricProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AntisymmetricProperty> getAllAntisymmetricProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllAntisymmetricProperty(null, dataset);
	}
	
	/**
	 * Return an instance of AntisymmetricProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#AntisymmetricProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of AntisymmetricProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AntisymmetricProperty> getAllAntisymmetricProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllAntisymmetricProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isFunctionalObjectPropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(FunctionalObjectProperty.commentProperty) ||
			predicate.equals(FunctionalObjectProperty.labelProperty) ||
			predicate.equals(FunctionalObjectProperty.typeProperty) ||
			predicate.equals(FunctionalObjectProperty.valueProperty) ||
			predicate.equals(FunctionalObjectProperty.isDefinedByProperty) ||
			predicate.equals(FunctionalObjectProperty.memberProperty) ||
			predicate.equals(FunctionalObjectProperty.seeAlsoProperty) ||
			predicate.equals(FunctionalObjectProperty.domainProperty) ||
			predicate.equals(FunctionalObjectProperty.rangeProperty) ||
			predicate.equals(FunctionalObjectProperty.subPropertyOfProperty) ||
			predicate.equals(FunctionalObjectProperty.inverseOfProperty) ||
			predicate.equals(FunctionalObjectProperty.disjointObjectPropertiesProperty) ||
			predicate.equals(FunctionalObjectProperty.equivalentObjectPropertyProperty) ||
			predicate.equals(FunctionalObjectProperty.objectPropertyDomainProperty) ||
			predicate.equals(FunctionalObjectProperty.objectPropertyRangeProperty) ||
			predicate.equals(FunctionalObjectProperty.subObjectPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty createFunctionalObjectProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		FunctionalObjectProperty result= org.openanzo.rdf.owl.FunctionalObjectPropertyImpl.createFunctionalObjectProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty createFunctionalObjectProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createFunctionalObjectProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty createFunctionalObjectProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalObjectProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty createFunctionalObjectProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalObjectProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalObjectProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty createFunctionalObjectProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createFunctionalObjectProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalObjectProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty createFunctionalObjectProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalObjectProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the FunctionalObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty getFunctionalObjectProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.FunctionalObjectPropertyImpl.getFunctionalObjectProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty getFunctionalObjectProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getFunctionalObjectProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty getFunctionalObjectProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalObjectProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty getFunctionalObjectProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalObjectProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalObjectProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty getFunctionalObjectProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getFunctionalObjectProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of FunctionalObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalObjectProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalObjectProperty getFunctionalObjectProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalObjectProperty(resource, graph);
	}
	
	/**
	 * Return an instance of FunctionalObjectProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#FunctionalObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalObjectProperty> getAllFunctionalObjectProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,FunctionalObjectProperty.TYPE,_namedGraphUri);
		java.util.List<FunctionalObjectProperty> list = new java.util.ArrayList<FunctionalObjectProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getFunctionalObjectProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of FunctionalObjectProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#FunctionalObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalObjectProperty> getAllFunctionalObjectProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllFunctionalObjectProperty(null, dataset);
	}
	
	/**
	 * Return an instance of FunctionalObjectProperty for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#FunctionalObjectProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of FunctionalObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalObjectProperty> getAllFunctionalObjectProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllFunctionalObjectProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isAnnotationPropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(AnnotationProperty.commentProperty) ||
			predicate.equals(AnnotationProperty.labelProperty) ||
			predicate.equals(AnnotationProperty.typeProperty) ||
			predicate.equals(AnnotationProperty.valueProperty) ||
			predicate.equals(AnnotationProperty.isDefinedByProperty) ||
			predicate.equals(AnnotationProperty.memberProperty) ||
			predicate.equals(AnnotationProperty.seeAlsoProperty) ||
			predicate.equals(AnnotationProperty.differentFromProperty) ||
			predicate.equals(AnnotationProperty.sameAsProperty) ;
	}
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnnotationProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty createAnnotationProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		AnnotationProperty result= org.openanzo.rdf.owl.AnnotationPropertyImpl.createAnnotationProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnnotationProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty createAnnotationProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createAnnotationProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnnotationProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty createAnnotationProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAnnotationProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnnotationProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty createAnnotationProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAnnotationProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnnotationProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty createAnnotationProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createAnnotationProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnnotationProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty createAnnotationProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAnnotationProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of AnnotationProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the AnnotationProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty getAnnotationProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.AnnotationPropertyImpl.getAnnotationProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnnotationProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty getAnnotationProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAnnotationProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnnotationProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty getAnnotationProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAnnotationProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnnotationProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty getAnnotationProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAnnotationProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the AnnotationProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty getAnnotationProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAnnotationProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of AnnotationProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the AnnotationProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static AnnotationProperty getAnnotationProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAnnotationProperty(resource, graph);
	}
	
	/**
	 * Return an instance of AnnotationProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#AnnotationProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AnnotationProperty> getAllAnnotationProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,AnnotationProperty.TYPE,_namedGraphUri);
		java.util.List<AnnotationProperty> list = new java.util.ArrayList<AnnotationProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getAnnotationProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of AnnotationProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#AnnotationProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AnnotationProperty> getAllAnnotationProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllAnnotationProperty(null, dataset);
	}
	
	/**
	 * Return an instance of AnnotationProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#AnnotationProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of AnnotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<AnnotationProperty> getAllAnnotationProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllAnnotationProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isTransitivePropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(TransitiveProperty.commentProperty) ||
			predicate.equals(TransitiveProperty.labelProperty) ||
			predicate.equals(TransitiveProperty.typeProperty) ||
			predicate.equals(TransitiveProperty.valueProperty) ||
			predicate.equals(TransitiveProperty.isDefinedByProperty) ||
			predicate.equals(TransitiveProperty.memberProperty) ||
			predicate.equals(TransitiveProperty.seeAlsoProperty) ||
			predicate.equals(TransitiveProperty.domainProperty) ||
			predicate.equals(TransitiveProperty.rangeProperty) ||
			predicate.equals(TransitiveProperty.subPropertyOfProperty) ||
			predicate.equals(TransitiveProperty.inverseOfProperty) ||
			predicate.equals(TransitiveProperty.disjointObjectPropertiesProperty) ||
			predicate.equals(TransitiveProperty.equivalentObjectPropertyProperty) ||
			predicate.equals(TransitiveProperty.objectPropertyDomainProperty) ||
			predicate.equals(TransitiveProperty.objectPropertyRangeProperty) ||
			predicate.equals(TransitiveProperty.subObjectPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TransitiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty createTransitiveProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		TransitiveProperty result= org.openanzo.rdf.owl.TransitivePropertyImpl.createTransitiveProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TransitiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty createTransitiveProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createTransitiveProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TransitiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty createTransitiveProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createTransitiveProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TransitiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty createTransitiveProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createTransitiveProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TransitiveProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty createTransitiveProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createTransitiveProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TransitiveProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty createTransitiveProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createTransitiveProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of TransitiveProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the TransitiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty getTransitiveProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.TransitivePropertyImpl.getTransitiveProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TransitiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty getTransitiveProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getTransitiveProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TransitiveProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty getTransitiveProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getTransitiveProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TransitiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty getTransitiveProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getTransitiveProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the TransitiveProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty getTransitiveProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getTransitiveProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of TransitiveProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the TransitiveProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static TransitiveProperty getTransitiveProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getTransitiveProperty(resource, graph);
	}
	
	/**
	 * Return an instance of TransitiveProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#TransitiveProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<TransitiveProperty> getAllTransitiveProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,TransitiveProperty.TYPE,_namedGraphUri);
		java.util.List<TransitiveProperty> list = new java.util.ArrayList<TransitiveProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getTransitiveProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of TransitiveProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#TransitiveProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<TransitiveProperty> getAllTransitiveProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllTransitiveProperty(null, dataset);
	}
	
	/**
	 * Return an instance of TransitiveProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#TransitiveProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of TransitiveProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<TransitiveProperty> getAllTransitiveProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllTransitiveProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isFunctionalPropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(FunctionalProperty.commentProperty) ||
			predicate.equals(FunctionalProperty.labelProperty) ||
			predicate.equals(FunctionalProperty.typeProperty) ||
			predicate.equals(FunctionalProperty.valueProperty) ||
			predicate.equals(FunctionalProperty.isDefinedByProperty) ||
			predicate.equals(FunctionalProperty.memberProperty) ||
			predicate.equals(FunctionalProperty.seeAlsoProperty) ||
			predicate.equals(FunctionalProperty.domainProperty) ||
			predicate.equals(FunctionalProperty.rangeProperty) ||
			predicate.equals(FunctionalProperty.subPropertyOfProperty) ||
			predicate.equals(FunctionalProperty.inverseOfProperty) ||
			predicate.equals(FunctionalProperty.disjointObjectPropertiesProperty) ||
			predicate.equals(FunctionalProperty.equivalentObjectPropertyProperty) ||
			predicate.equals(FunctionalProperty.objectPropertyDomainProperty) ||
			predicate.equals(FunctionalProperty.objectPropertyRangeProperty) ||
			predicate.equals(FunctionalProperty.subObjectPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty createFunctionalProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		FunctionalProperty result= org.openanzo.rdf.owl.FunctionalPropertyImpl.createFunctionalProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty createFunctionalProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createFunctionalProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty createFunctionalProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty createFunctionalProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty createFunctionalProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createFunctionalProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty createFunctionalProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of FunctionalProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the FunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty getFunctionalProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.FunctionalPropertyImpl.getFunctionalProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty getFunctionalProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getFunctionalProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty getFunctionalProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty getFunctionalProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty getFunctionalProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getFunctionalProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of FunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalProperty getFunctionalProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalProperty(resource, graph);
	}
	
	/**
	 * Return an instance of FunctionalProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#FunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalProperty> getAllFunctionalProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,FunctionalProperty.TYPE,_namedGraphUri);
		java.util.List<FunctionalProperty> list = new java.util.ArrayList<FunctionalProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getFunctionalProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of FunctionalProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#FunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalProperty> getAllFunctionalProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllFunctionalProperty(null, dataset);
	}
	
	/**
	 * Return an instance of FunctionalProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#FunctionalProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of FunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalProperty> getAllFunctionalProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllFunctionalProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean is_ThingPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(_Thing.commentProperty) ||
			predicate.equals(_Thing.labelProperty) ||
			predicate.equals(_Thing.typeProperty) ||
			predicate.equals(_Thing.valueProperty) ||
			predicate.equals(_Thing.isDefinedByProperty) ||
			predicate.equals(_Thing.memberProperty) ||
			predicate.equals(_Thing.seeAlsoProperty) ||
			predicate.equals(_Thing.subClassOfProperty) ||
			predicate.equals(_Thing.oneOfProperty) ||
			predicate.equals(_Thing.disjointWithProperty) ||
			predicate.equals(_Thing.equivalentClassProperty) ||
			predicate.equals(_Thing.intersectionOfProperty) ||
			predicate.equals(_Thing.unionOfProperty) ||
			predicate.equals(_Thing.disjointUnionOfProperty) ;
	}
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Thing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing create_Thing(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		_Thing result= org.openanzo.rdf.owl._ThingImpl.create_Thing(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Thing
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing create_Thing(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return create_Thing(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Thing
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing create_Thing(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return create_Thing(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Thing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing create_Thing(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return create_Thing(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Thing
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing create_Thing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return create_Thing(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Thing
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing create_Thing(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return create_Thing(resource, graph);
	}
	
	
	/**
	 * Create a new instance of _Thing.  Leaves the dataset unchanged.
	 * @param resource The resource of the _Thing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing get_Thing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl._ThingImpl.get_Thing(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Thing
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing get_Thing(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return get_Thing(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Thing
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing get_Thing(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return get_Thing(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Thing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing get_Thing(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return get_Thing(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the _Thing
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing get_Thing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return get_Thing(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of _Thing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the _Thing
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static _Thing get_Thing(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return get_Thing(resource, graph);
	}
	
	/**
	 * Return an instance of _Thing for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Thing
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<_Thing> getAll_Thing(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,_Thing.TYPE,_namedGraphUri);
		java.util.List<_Thing> list = new java.util.ArrayList<_Thing>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(get_Thing(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of _Thing for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Thing
	 * @param dataset the IDataset containing the data
	 * @return a List of _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<_Thing> getAll_Thing(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAll_Thing(null, dataset);
	}
	
	/**
	 * Return an instance of _Thing for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Thing
	 * @param graph the NamedGraph containing the data
	 * @return a List of _Thing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<_Thing> getAll_Thing(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAll_Thing(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isRestrictionPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(Restriction.maxCardinalityProperty) ||
			predicate.equals(Restriction.minCardinalityProperty) ||
			predicate.equals(Restriction.cardinalityProperty) ||
			predicate.equals(Restriction.onPropertyProperty) ||
			predicate.equals(Restriction.hasValueProperty) ||
			predicate.equals(Restriction.allValuesFromProperty) ||
			predicate.equals(Restriction.someValuesFromProperty) ;
	}
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Restriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction createRestriction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Restriction result= org.openanzo.rdf.owl.RestrictionImpl.createRestriction(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Restriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction createRestriction(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createRestriction(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Restriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction createRestriction(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRestriction(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Restriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction createRestriction(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRestriction(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Restriction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction createRestriction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createRestriction(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Restriction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction createRestriction(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createRestriction(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Restriction.  Leaves the dataset unchanged.
	 * @param resource The resource of the Restriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction getRestriction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.RestrictionImpl.getRestriction(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Restriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction getRestriction(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getRestriction(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Restriction
	 * @param dataset the IDataset containing the data
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction getRestriction(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRestriction(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Restriction
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction getRestriction(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRestriction(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Restriction
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction getRestriction(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getRestriction(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Restriction.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Restriction
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Restriction getRestriction(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getRestriction(resource, graph);
	}
	
	/**
	 * Return an instance of Restriction for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Restriction
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Restriction> getAllRestriction(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Restriction.TYPE,_namedGraphUri);
		java.util.List<Restriction> list = new java.util.ArrayList<Restriction>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getRestriction(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Restriction for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Restriction
	 * @param dataset the IDataset containing the data
	 * @return a List of Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Restriction> getAllRestriction(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllRestriction(null, dataset);
	}
	
	/**
	 * Return an instance of Restriction for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#Restriction
	 * @param graph the NamedGraph containing the data
	 * @return a List of Restriction
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Restriction> getAllRestriction(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllRestriction(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isObjectPropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ObjectProperty.commentProperty) ||
			predicate.equals(ObjectProperty.labelProperty) ||
			predicate.equals(ObjectProperty.typeProperty) ||
			predicate.equals(ObjectProperty.valueProperty) ||
			predicate.equals(ObjectProperty.isDefinedByProperty) ||
			predicate.equals(ObjectProperty.memberProperty) ||
			predicate.equals(ObjectProperty.seeAlsoProperty) ||
			predicate.equals(ObjectProperty.domainProperty) ||
			predicate.equals(ObjectProperty.rangeProperty) ||
			predicate.equals(ObjectProperty.subPropertyOfProperty) ||
			predicate.equals(ObjectProperty.inverseOfProperty) ||
			predicate.equals(ObjectProperty.disjointObjectPropertiesProperty) ||
			predicate.equals(ObjectProperty.equivalentObjectPropertyProperty) ||
			predicate.equals(ObjectProperty.objectPropertyDomainProperty) ||
			predicate.equals(ObjectProperty.objectPropertyRangeProperty) ||
			predicate.equals(ObjectProperty.subObjectPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty createObjectProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		ObjectProperty result= org.openanzo.rdf.owl.ObjectPropertyImpl.createObjectProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty createObjectProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createObjectProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty createObjectProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createObjectProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty createObjectProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createObjectProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty createObjectProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createObjectProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty createObjectProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createObjectProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of ObjectProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the ObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty getObjectProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.ObjectPropertyImpl.getObjectProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty getObjectProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getObjectProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty getObjectProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getObjectProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty getObjectProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getObjectProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the ObjectProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty getObjectProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getObjectProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of ObjectProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the ObjectProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static ObjectProperty getObjectProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getObjectProperty(resource, graph);
	}
	
	/**
	 * Return an instance of ObjectProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#ObjectProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ObjectProperty> getAllObjectProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,ObjectProperty.TYPE,_namedGraphUri);
		java.util.List<ObjectProperty> list = new java.util.ArrayList<ObjectProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getObjectProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of ObjectProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#ObjectProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ObjectProperty> getAllObjectProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllObjectProperty(null, dataset);
	}
	
	/**
	 * Return an instance of ObjectProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#ObjectProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of ObjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<ObjectProperty> getAllObjectProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllObjectProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isInverseFunctionalPropertyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(InverseFunctionalProperty.commentProperty) ||
			predicate.equals(InverseFunctionalProperty.labelProperty) ||
			predicate.equals(InverseFunctionalProperty.typeProperty) ||
			predicate.equals(InverseFunctionalProperty.valueProperty) ||
			predicate.equals(InverseFunctionalProperty.isDefinedByProperty) ||
			predicate.equals(InverseFunctionalProperty.memberProperty) ||
			predicate.equals(InverseFunctionalProperty.seeAlsoProperty) ||
			predicate.equals(InverseFunctionalProperty.domainProperty) ||
			predicate.equals(InverseFunctionalProperty.rangeProperty) ||
			predicate.equals(InverseFunctionalProperty.subPropertyOfProperty) ||
			predicate.equals(InverseFunctionalProperty.inverseOfProperty) ||
			predicate.equals(InverseFunctionalProperty.disjointObjectPropertiesProperty) ||
			predicate.equals(InverseFunctionalProperty.equivalentObjectPropertyProperty) ||
			predicate.equals(InverseFunctionalProperty.objectPropertyDomainProperty) ||
			predicate.equals(InverseFunctionalProperty.objectPropertyRangeProperty) ||
			predicate.equals(InverseFunctionalProperty.subObjectPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the InverseFunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty createInverseFunctionalProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		InverseFunctionalProperty result= org.openanzo.rdf.owl.InverseFunctionalPropertyImpl.createInverseFunctionalProperty(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the InverseFunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty createInverseFunctionalProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createInverseFunctionalProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the InverseFunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty createInverseFunctionalProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createInverseFunctionalProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the InverseFunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty createInverseFunctionalProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createInverseFunctionalProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the InverseFunctionalProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty createInverseFunctionalProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createInverseFunctionalProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the InverseFunctionalProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty createInverseFunctionalProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createInverseFunctionalProperty(resource, graph);
	}
	
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Leaves the dataset unchanged.
	 * @param resource The resource of the InverseFunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty getInverseFunctionalProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.InverseFunctionalPropertyImpl.getInverseFunctionalProperty(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the InverseFunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty getInverseFunctionalProperty(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getInverseFunctionalProperty(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the InverseFunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty getInverseFunctionalProperty(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getInverseFunctionalProperty(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the InverseFunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty getInverseFunctionalProperty(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getInverseFunctionalProperty(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the InverseFunctionalProperty
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty getInverseFunctionalProperty(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getInverseFunctionalProperty(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of InverseFunctionalProperty.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the InverseFunctionalProperty
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static InverseFunctionalProperty getInverseFunctionalProperty(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getInverseFunctionalProperty(resource, graph);
	}
	
	/**
	 * Return an instance of InverseFunctionalProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#InverseFunctionalProperty
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<InverseFunctionalProperty> getAllInverseFunctionalProperty(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,InverseFunctionalProperty.TYPE,_namedGraphUri);
		java.util.List<InverseFunctionalProperty> list = new java.util.ArrayList<InverseFunctionalProperty>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getInverseFunctionalProperty(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of InverseFunctionalProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#InverseFunctionalProperty
	 * @param dataset the IDataset containing the data
	 * @return a List of InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<InverseFunctionalProperty> getAllInverseFunctionalProperty(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllInverseFunctionalProperty(null, dataset);
	}
	
	/**
	 * Return an instance of InverseFunctionalProperty for every resource in the dataset with rdf:Type http://www.w3.org/2002/07/owl#InverseFunctionalProperty
	 * @param graph the NamedGraph containing the data
	 * @return a List of InverseFunctionalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<InverseFunctionalProperty> getAllInverseFunctionalProperty(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllInverseFunctionalProperty(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isFunctionalDataPropetyPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(FunctionalDataPropety.commentProperty) ||
			predicate.equals(FunctionalDataPropety.labelProperty) ||
			predicate.equals(FunctionalDataPropety.typeProperty) ||
			predicate.equals(FunctionalDataPropety.valueProperty) ||
			predicate.equals(FunctionalDataPropety.isDefinedByProperty) ||
			predicate.equals(FunctionalDataPropety.memberProperty) ||
			predicate.equals(FunctionalDataPropety.seeAlsoProperty) ||
			predicate.equals(FunctionalDataPropety.domainProperty) ||
			predicate.equals(FunctionalDataPropety.rangeProperty) ||
			predicate.equals(FunctionalDataPropety.subPropertyOfProperty) ||
			predicate.equals(FunctionalDataPropety.equivalentPropertyProperty) ||
			predicate.equals(FunctionalDataPropety.dataPropertyDomainProperty) ||
			predicate.equals(FunctionalDataPropety.dataPropertyRangeProperty) ||
			predicate.equals(FunctionalDataPropety.disjointDataPropertiesProperty) ||
			predicate.equals(FunctionalDataPropety.equivalentDataPropertyProperty) ||
			predicate.equals(FunctionalDataPropety.subDataPropertyOfProperty) ;
	}
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalDataPropety
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety createFunctionalDataPropety(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		FunctionalDataPropety result= org.openanzo.rdf.owl.FunctionalDataPropetyImpl.createFunctionalDataPropety(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalDataPropety
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety createFunctionalDataPropety(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createFunctionalDataPropety(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalDataPropety
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety createFunctionalDataPropety(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalDataPropety(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalDataPropety
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety createFunctionalDataPropety(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalDataPropety(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalDataPropety
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety createFunctionalDataPropety(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createFunctionalDataPropety(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalDataPropety
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety createFunctionalDataPropety(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createFunctionalDataPropety(resource, graph);
	}
	
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Leaves the dataset unchanged.
	 * @param resource The resource of the FunctionalDataPropety
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety getFunctionalDataPropety(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.rdf.owl.FunctionalDataPropetyImpl.getFunctionalDataPropety(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalDataPropety
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety getFunctionalDataPropety(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getFunctionalDataPropety(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalDataPropety
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety getFunctionalDataPropety(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalDataPropety(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalDataPropety
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety getFunctionalDataPropety(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalDataPropety(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the FunctionalDataPropety
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety getFunctionalDataPropety(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getFunctionalDataPropety(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of FunctionalDataPropety.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the FunctionalDataPropety
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static FunctionalDataPropety getFunctionalDataPropety(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getFunctionalDataPropety(resource, graph);
	}
	
	/**
	 * Return an instance of FunctionalDataPropety for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#FunctionalDataPropety
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalDataPropety> getAllFunctionalDataPropety(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,FunctionalDataPropety.TYPE,_namedGraphUri);
		java.util.List<FunctionalDataPropety> list = new java.util.ArrayList<FunctionalDataPropety>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getFunctionalDataPropety(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of FunctionalDataPropety for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#FunctionalDataPropety
	 * @param dataset the IDataset containing the data
	 * @return a List of FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalDataPropety> getAllFunctionalDataPropety(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllFunctionalDataPropety(null, dataset);
	}
	
	/**
	 * Return an instance of FunctionalDataPropety for every resource in the dataset with rdf:Type http://www.w3.org/2006/12/owl11#FunctionalDataPropety
	 * @param graph the NamedGraph containing the data
	 * @return a List of FunctionalDataPropety
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<FunctionalDataPropety> getAllFunctionalDataPropety(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllFunctionalDataPropety(graph.getNamedGraphUri(), dataset);
	}



	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 * @throws org.openanzo.rdf.jastor.JastorException 
	 */
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#FunctionalDataPropety"), namedGraphUri)) {
			return getFunctionalDataPropety(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#InverseFunctionalProperty"), namedGraphUri)) {
			return getInverseFunctionalProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Restriction"), namedGraphUri)) {
			return getRestriction(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#FunctionalProperty"), namedGraphUri)) {
			return getFunctionalProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#TransitiveProperty"), namedGraphUri)) {
			return getTransitiveProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#AnnotationProperty"), namedGraphUri)) {
			return getAnnotationProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#FunctionalObjectProperty"), namedGraphUri)) {
			return getFunctionalObjectProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#AntisymmetricProperty"), namedGraphUri)) {
			return getAntisymmetricProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#ReflexiveProperty"), namedGraphUri)) {
			return getReflexiveProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#ObjectRestriction"), namedGraphUri)) {
			return getObjectRestriction(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Nothing"), namedGraphUri)) {
			return getNothing(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Thing"), namedGraphUri)) {
			return get_Thing(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Class"), namedGraphUri)) {
			return getClass(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#DataRange"), namedGraphUri)) {
			return getDataRange(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#FunctionalPropety"), namedGraphUri)) {
			return getFunctionalPropety(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#DatatypeProperty"), namedGraphUri)) {
			return getDatatypeProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#SymmetricProperty"), namedGraphUri)) {
			return getSymmetricProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Ontology"), namedGraphUri)) {
			return getOntology(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#IrreflexiveProperty"), namedGraphUri)) {
			return getIrreflexiveProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#ObjectProperty"), namedGraphUri)) {
			return getObjectProperty(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#DataRestriction"), namedGraphUri)) {
			return getDataRestriction(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Individual"), namedGraphUri)) {
			return getIndividual(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#OWLEntity"), namedGraphUri)) {
			return getOWLEntity(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Constant"), namedGraphUri)) {
			return getConstant(resource, namedGraphUri, dataset);
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
	 * in the OWL11 ontology.
	 * @param type the type for which to find compatible interfaces
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> listCompatibleInterfaces (org.openanzo.rdf.Resource type) {
		java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> types = new java.util.ArrayList<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>>();
		if (type.equals(org.openanzo.rdf.owl.OWLEntity.TYPE)) {
			types.add(org.openanzo.rdf.owl.OWLEntity.class);
		}
		if (type.equals(org.openanzo.rdf.owl.DatatypeProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.DatatypeProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.Constant.TYPE)) {
			types.add(org.openanzo.rdf.owl.Constant.class);
		}
		if (type.equals(org.openanzo.rdf.owl.Individual.TYPE)) {
			types.add(org.openanzo.rdf.owl.Individual.class);
		}
		if (type.equals(org.openanzo.rdf.owl.Class.TYPE)) {
			types.add(org.openanzo.rdf.owl.Class.class);
		}
		if (type.equals(org.openanzo.rdf.owl.DataRestriction.TYPE)) {
			types.add(org.openanzo.rdf.owl.DataRestriction.class);
		}
		if (type.equals(org.openanzo.rdf.owl.IrreflexiveProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.IrreflexiveProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.Ontology.TYPE)) {
			types.add(org.openanzo.rdf.owl.Ontology.class);
		}
		if (type.equals(org.openanzo.rdf.owl.SymmetricProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.SymmetricProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.FunctionalPropety.TYPE)) {
			types.add(org.openanzo.rdf.owl.FunctionalPropety.class);
		}
		if (type.equals(org.openanzo.rdf.owl.DataRange.TYPE)) {
			types.add(org.openanzo.rdf.owl.DataRange.class);
		}
		if (type.equals(org.openanzo.rdf.owl.Nothing.TYPE)) {
			types.add(org.openanzo.rdf.owl.Nothing.class);
		}
		if (type.equals(org.openanzo.rdf.owl.ObjectRestriction.TYPE)) {
			types.add(org.openanzo.rdf.owl.ObjectRestriction.class);
		}
		if (type.equals(org.openanzo.rdf.owl.ReflexiveProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.ReflexiveProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.AntisymmetricProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.AntisymmetricProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.FunctionalObjectProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.FunctionalObjectProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.AnnotationProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.AnnotationProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.TransitiveProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.TransitiveProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.FunctionalProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.FunctionalProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl._Thing.TYPE)) {
			types.add(org.openanzo.rdf.owl._Thing.class);
		}
		if (type.equals(org.openanzo.rdf.owl.Restriction.TYPE)) {
			types.add(org.openanzo.rdf.owl.Restriction.class);
		}
		if (type.equals(org.openanzo.rdf.owl.ObjectProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.ObjectProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.InverseFunctionalProperty.TYPE)) {
			types.add(org.openanzo.rdf.owl.InverseFunctionalProperty.class);
		}
		if (type.equals(org.openanzo.rdf.owl.FunctionalDataPropety.TYPE)) {
			types.add(org.openanzo.rdf.owl.FunctionalDataPropety.class);
		}
		return types;
	}
}