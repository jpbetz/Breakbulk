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

package org.openanzo.ontologies.foaf;

/**
 * Factory for instantiating objects for ontology classes in the FOAF ontology.  The
 * get methods leave the dataset unchanged and return a Java view of the object in the dataset.  The create methods
 * may add certain baseline properties to the dataset such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://xmlns.com/foaf/0.1/FOAF)</p>
 * <br>
 * <br>
 * <br>
 */
public class FOAFFactory extends org.openanzo.rdf.jastor.ThingFactory { 


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isSpatialThingPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(SpatialThingImpl.based__nearProperty) ||
			predicate.equals(SpatialThingImpl.depictionProperty) ||
			predicate.equals(SpatialThingImpl.fundedByProperty) ||
			predicate.equals(SpatialThingImpl.homepageProperty) ||
			predicate.equals(SpatialThingImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(SpatialThingImpl.logoProperty) ||
			predicate.equals(SpatialThingImpl.makerProperty) ||
			predicate.equals(SpatialThingImpl.pageProperty) ||
			predicate.equals(SpatialThingImpl.themeProperty) ||
			predicate.equals(SpatialThingImpl.dnaChecksumProperty) ||
			predicate.equals(SpatialThingImpl.nickProperty) ||
			predicate.equals(SpatialThingImpl.titleProperty) ||
			predicate.equals(SpatialThingImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SpatialThing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing createSpatialThing(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		SpatialThing result= org.openanzo.ontologies.foaf.SpatialThingImpl.createSpatialThing(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SpatialThing
	 * @param dataset the IDataset containing the data
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing createSpatialThing(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createSpatialThing(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SpatialThing
	 * @param dataset the IDataset containing the data
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing createSpatialThing(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSpatialThing(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SpatialThing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing createSpatialThing(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSpatialThing(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SpatialThing
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing createSpatialThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createSpatialThing(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SpatialThing
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing createSpatialThing(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createSpatialThing(resource, graph);
	}
	
	
	/**
	 * Create a new instance of SpatialThing.  Leaves the dataset unchanged.
	 * @param resource The resource of the SpatialThing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing getSpatialThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.SpatialThingImpl.getSpatialThing(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SpatialThing
	 * @param dataset the IDataset containing the data
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing getSpatialThing(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getSpatialThing(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SpatialThing
	 * @param dataset the IDataset containing the data
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing getSpatialThing(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSpatialThing(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SpatialThing
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing getSpatialThing(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSpatialThing(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the SpatialThing
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing getSpatialThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getSpatialThing(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of SpatialThing.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the SpatialThing
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static SpatialThing getSpatialThing(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getSpatialThing(resource, graph);
	}
	
	/**
	 * Return an instance of SpatialThing for every resource in the dataset with rdf:Type http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<SpatialThing> getAllSpatialThing(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,SpatialThing.TYPE,_namedGraphUri);
		java.util.List<SpatialThing> list = new java.util.ArrayList<SpatialThing>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getSpatialThing(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of SpatialThing for every resource in the dataset with rdf:Type http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing
	 * @param dataset the IDataset containing the data
	 * @return a List of SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<SpatialThing> getAllSpatialThing(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllSpatialThing(null, dataset);
	}
	
	/**
	 * Return an instance of SpatialThing for every resource in the dataset with rdf:Type http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing
	 * @param graph the NamedGraph containing the data
	 * @return a List of SpatialThing
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<SpatialThing> getAllSpatialThing(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllSpatialThing(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isAgentPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(AgentImpl.descriptionProperty) ||
			predicate.equals(AgentImpl.aimChatIDProperty) ||
			predicate.equals(AgentImpl.birthdayProperty) ||
			predicate.equals(AgentImpl.genderProperty) ||
			predicate.equals(AgentImpl.icqChatIDProperty) ||
			predicate.equals(AgentImpl.jabberIDProperty) ||
			predicate.equals(AgentImpl.mbox__sha1sumProperty) ||
			predicate.equals(AgentImpl.msnChatIDProperty) ||
			predicate.equals(AgentImpl.yahooChatIDProperty) ||
			predicate.equals(AgentImpl.holdsAccountProperty) ||
			predicate.equals(AgentImpl.madeProperty) ||
			predicate.equals(AgentImpl.mboxProperty) ||
			predicate.equals(AgentImpl.tipjarProperty) ||
			predicate.equals(AgentImpl.weblogProperty) ||
			predicate.equals(AgentImpl.depictionProperty) ||
			predicate.equals(AgentImpl.fundedByProperty) ||
			predicate.equals(AgentImpl.homepageProperty) ||
			predicate.equals(AgentImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(AgentImpl.logoProperty) ||
			predicate.equals(AgentImpl.makerProperty) ||
			predicate.equals(AgentImpl.pageProperty) ||
			predicate.equals(AgentImpl.themeProperty) ||
			predicate.equals(AgentImpl.dnaChecksumProperty) ||
			predicate.equals(AgentImpl.nickProperty) ||
			predicate.equals(AgentImpl.titleProperty) ||
			predicate.equals(AgentImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Agent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent createAgent(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Agent result= org.openanzo.ontologies.foaf.AgentImpl.createAgent(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Agent
	 * @param dataset the IDataset containing the data
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent createAgent(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createAgent(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Agent
	 * @param dataset the IDataset containing the data
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent createAgent(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAgent(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Agent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent createAgent(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAgent(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Agent
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent createAgent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createAgent(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Agent
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent createAgent(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createAgent(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Agent.  Leaves the dataset unchanged.
	 * @param resource The resource of the Agent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent getAgent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.AgentImpl.getAgent(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Agent
	 * @param dataset the IDataset containing the data
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent getAgent(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAgent(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Agent
	 * @param dataset the IDataset containing the data
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent getAgent(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAgent(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Agent
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent getAgent(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAgent(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Agent
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent getAgent(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAgent(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Agent.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Agent
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Agent getAgent(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getAgent(resource, graph);
	}
	
	/**
	 * Return an instance of Agent for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Agent
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Agent> getAllAgent(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Agent.TYPE,_namedGraphUri);
		java.util.List<Agent> list = new java.util.ArrayList<Agent>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getAgent(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Agent for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Agent
	 * @param dataset the IDataset containing the data
	 * @return a List of Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Agent> getAllAgent(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllAgent(null, dataset);
	}
	
	/**
	 * Return an instance of Agent for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Agent
	 * @param graph the NamedGraph containing the data
	 * @return a List of Agent
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Agent> getAllAgent(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllAgent(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isDocumentPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(DocumentImpl.sha1Property) ||
			predicate.equals(DocumentImpl.primaryTopicProperty) ||
			predicate.equals(DocumentImpl.topicProperty) ||
			predicate.equals(DocumentImpl.depictionProperty) ||
			predicate.equals(DocumentImpl.fundedByProperty) ||
			predicate.equals(DocumentImpl.homepageProperty) ||
			predicate.equals(DocumentImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(DocumentImpl.logoProperty) ||
			predicate.equals(DocumentImpl.makerProperty) ||
			predicate.equals(DocumentImpl.pageProperty) ||
			predicate.equals(DocumentImpl.themeProperty) ||
			predicate.equals(DocumentImpl.dnaChecksumProperty) ||
			predicate.equals(DocumentImpl.nickProperty) ||
			predicate.equals(DocumentImpl.titleProperty) ||
			predicate.equals(DocumentImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Document
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document createDocument(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Document result= org.openanzo.ontologies.foaf.DocumentImpl.createDocument(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Document
	 * @param dataset the IDataset containing the data
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document createDocument(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createDocument(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Document
	 * @param dataset the IDataset containing the data
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document createDocument(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDocument(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Document
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document createDocument(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDocument(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Document
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document createDocument(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createDocument(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Document
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document createDocument(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createDocument(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Document.  Leaves the dataset unchanged.
	 * @param resource The resource of the Document
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document getDocument(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.DocumentImpl.getDocument(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Document
	 * @param dataset the IDataset containing the data
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document getDocument(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getDocument(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Document
	 * @param dataset the IDataset containing the data
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document getDocument(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDocument(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Document
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document getDocument(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDocument(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Document
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document getDocument(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getDocument(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Document.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Document
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Document getDocument(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getDocument(resource, graph);
	}
	
	/**
	 * Return an instance of Document for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Document
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Document> getAllDocument(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Document.TYPE,_namedGraphUri);
		java.util.List<Document> list = new java.util.ArrayList<Document>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getDocument(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Document for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Document
	 * @param dataset the IDataset containing the data
	 * @return a List of Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Document> getAllDocument(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllDocument(null, dataset);
	}
	
	/**
	 * Return an instance of Document for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Document
	 * @param graph the NamedGraph containing the data
	 * @return a List of Document
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Document> getAllDocument(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllDocument(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isGroupPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(GroupImpl.descriptionProperty) ||
			predicate.equals(GroupImpl.aimChatIDProperty) ||
			predicate.equals(GroupImpl.birthdayProperty) ||
			predicate.equals(GroupImpl.genderProperty) ||
			predicate.equals(GroupImpl.icqChatIDProperty) ||
			predicate.equals(GroupImpl.jabberIDProperty) ||
			predicate.equals(GroupImpl.mbox__sha1sumProperty) ||
			predicate.equals(GroupImpl.msnChatIDProperty) ||
			predicate.equals(GroupImpl.yahooChatIDProperty) ||
			predicate.equals(GroupImpl.holdsAccountProperty) ||
			predicate.equals(GroupImpl.madeProperty) ||
			predicate.equals(GroupImpl.mboxProperty) ||
			predicate.equals(GroupImpl.tipjarProperty) ||
			predicate.equals(GroupImpl.weblogProperty) ||
			predicate.equals(GroupImpl.depictionProperty) ||
			predicate.equals(GroupImpl.fundedByProperty) ||
			predicate.equals(GroupImpl.homepageProperty) ||
			predicate.equals(GroupImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(GroupImpl.logoProperty) ||
			predicate.equals(GroupImpl.makerProperty) ||
			predicate.equals(GroupImpl.pageProperty) ||
			predicate.equals(GroupImpl.themeProperty) ||
			predicate.equals(GroupImpl.dnaChecksumProperty) ||
			predicate.equals(GroupImpl.nickProperty) ||
			predicate.equals(GroupImpl.titleProperty) ||
			predicate.equals(GroupImpl.phoneProperty) ||
			predicate.equals(GroupImpl.memberProperty) ;
	}
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Group
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group createGroup(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Group result= org.openanzo.ontologies.foaf.GroupImpl.createGroup(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Group
	 * @param dataset the IDataset containing the data
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group createGroup(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createGroup(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Group
	 * @param dataset the IDataset containing the data
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group createGroup(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createGroup(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Group
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group createGroup(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createGroup(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Group
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group createGroup(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createGroup(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Group
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group createGroup(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createGroup(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Group.  Leaves the dataset unchanged.
	 * @param resource The resource of the Group
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group getGroup(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.GroupImpl.getGroup(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Group
	 * @param dataset the IDataset containing the data
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group getGroup(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getGroup(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Group
	 * @param dataset the IDataset containing the data
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group getGroup(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getGroup(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Group
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group getGroup(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getGroup(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Group
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group getGroup(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getGroup(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Group.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Group
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Group getGroup(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getGroup(resource, graph);
	}
	
	/**
	 * Return an instance of Group for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Group
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Group> getAllGroup(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Group.TYPE,_namedGraphUri);
		java.util.List<Group> list = new java.util.ArrayList<Group>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getGroup(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Group for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Group
	 * @param dataset the IDataset containing the data
	 * @return a List of Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Group> getAllGroup(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllGroup(null, dataset);
	}
	
	/**
	 * Return an instance of Group for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Group
	 * @param graph the NamedGraph containing the data
	 * @return a List of Group
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Group> getAllGroup(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllGroup(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isImagePredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ImageImpl.sha1Property) ||
			predicate.equals(ImageImpl.primaryTopicProperty) ||
			predicate.equals(ImageImpl.topicProperty) ||
			predicate.equals(ImageImpl.depictionProperty) ||
			predicate.equals(ImageImpl.fundedByProperty) ||
			predicate.equals(ImageImpl.homepageProperty) ||
			predicate.equals(ImageImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(ImageImpl.logoProperty) ||
			predicate.equals(ImageImpl.makerProperty) ||
			predicate.equals(ImageImpl.pageProperty) ||
			predicate.equals(ImageImpl.themeProperty) ||
			predicate.equals(ImageImpl.dnaChecksumProperty) ||
			predicate.equals(ImageImpl.nickProperty) ||
			predicate.equals(ImageImpl.titleProperty) ||
			predicate.equals(ImageImpl.phoneProperty) ||
			predicate.equals(ImageImpl.depictsProperty) ||
			predicate.equals(ImageImpl.thumbnailProperty) ;
	}
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Image
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image createImage(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Image result= org.openanzo.ontologies.foaf.ImageImpl.createImage(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Image
	 * @param dataset the IDataset containing the data
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image createImage(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createImage(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Image
	 * @param dataset the IDataset containing the data
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image createImage(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createImage(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Image
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image createImage(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createImage(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Image
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image createImage(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createImage(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Image
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image createImage(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createImage(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Image.  Leaves the dataset unchanged.
	 * @param resource The resource of the Image
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image getImage(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.ImageImpl.getImage(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Image
	 * @param dataset the IDataset containing the data
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image getImage(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getImage(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Image
	 * @param dataset the IDataset containing the data
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image getImage(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getImage(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Image
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image getImage(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getImage(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Image
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image getImage(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getImage(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Image.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Image
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Image getImage(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getImage(resource, graph);
	}
	
	/**
	 * Return an instance of Image for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Image
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Image> getAllImage(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Image.TYPE,_namedGraphUri);
		java.util.List<Image> list = new java.util.ArrayList<Image>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getImage(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Image for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Image
	 * @param dataset the IDataset containing the data
	 * @return a List of Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Image> getAllImage(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllImage(null, dataset);
	}
	
	/**
	 * Return an instance of Image for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Image
	 * @param graph the NamedGraph containing the data
	 * @return a List of Image
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Image> getAllImage(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllImage(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isOnlineAccountPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(OnlineAccountImpl.accountNameProperty) ||
			predicate.equals(OnlineAccountImpl.accountServiceHomepageProperty) ||
			predicate.equals(OnlineAccountImpl.depictionProperty) ||
			predicate.equals(OnlineAccountImpl.fundedByProperty) ||
			predicate.equals(OnlineAccountImpl.homepageProperty) ||
			predicate.equals(OnlineAccountImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(OnlineAccountImpl.logoProperty) ||
			predicate.equals(OnlineAccountImpl.makerProperty) ||
			predicate.equals(OnlineAccountImpl.pageProperty) ||
			predicate.equals(OnlineAccountImpl.themeProperty) ||
			predicate.equals(OnlineAccountImpl.dnaChecksumProperty) ||
			predicate.equals(OnlineAccountImpl.nickProperty) ||
			predicate.equals(OnlineAccountImpl.titleProperty) ||
			predicate.equals(OnlineAccountImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount createOnlineAccount(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		OnlineAccount result= org.openanzo.ontologies.foaf.OnlineAccountImpl.createOnlineAccount(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount createOnlineAccount(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createOnlineAccount(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount createOnlineAccount(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineAccount(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount createOnlineAccount(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineAccount(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount createOnlineAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createOnlineAccount(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount createOnlineAccount(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineAccount(resource, graph);
	}
	
	
	/**
	 * Create a new instance of OnlineAccount.  Leaves the dataset unchanged.
	 * @param resource The resource of the OnlineAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount getOnlineAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.OnlineAccountImpl.getOnlineAccount(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount getOnlineAccount(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getOnlineAccount(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount getOnlineAccount(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineAccount(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount getOnlineAccount(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineAccount(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineAccount
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount getOnlineAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getOnlineAccount(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OnlineAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineAccount getOnlineAccount(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineAccount(resource, graph);
	}
	
	/**
	 * Return an instance of OnlineAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineAccount
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineAccount> getAllOnlineAccount(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,OnlineAccount.TYPE,_namedGraphUri);
		java.util.List<OnlineAccount> list = new java.util.ArrayList<OnlineAccount>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getOnlineAccount(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of OnlineAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineAccount
	 * @param dataset the IDataset containing the data
	 * @return a List of OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineAccount> getAllOnlineAccount(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllOnlineAccount(null, dataset);
	}
	
	/**
	 * Return an instance of OnlineAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineAccount
	 * @param graph the NamedGraph containing the data
	 * @return a List of OnlineAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineAccount> getAllOnlineAccount(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllOnlineAccount(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isOnlineChatAccountPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(OnlineChatAccountImpl.accountNameProperty) ||
			predicate.equals(OnlineChatAccountImpl.accountServiceHomepageProperty) ||
			predicate.equals(OnlineChatAccountImpl.depictionProperty) ||
			predicate.equals(OnlineChatAccountImpl.fundedByProperty) ||
			predicate.equals(OnlineChatAccountImpl.homepageProperty) ||
			predicate.equals(OnlineChatAccountImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(OnlineChatAccountImpl.logoProperty) ||
			predicate.equals(OnlineChatAccountImpl.makerProperty) ||
			predicate.equals(OnlineChatAccountImpl.pageProperty) ||
			predicate.equals(OnlineChatAccountImpl.themeProperty) ||
			predicate.equals(OnlineChatAccountImpl.dnaChecksumProperty) ||
			predicate.equals(OnlineChatAccountImpl.nickProperty) ||
			predicate.equals(OnlineChatAccountImpl.titleProperty) ||
			predicate.equals(OnlineChatAccountImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineChatAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount createOnlineChatAccount(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		OnlineChatAccount result= org.openanzo.ontologies.foaf.OnlineChatAccountImpl.createOnlineChatAccount(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineChatAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount createOnlineChatAccount(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createOnlineChatAccount(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineChatAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount createOnlineChatAccount(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineChatAccount(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineChatAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount createOnlineChatAccount(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineChatAccount(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineChatAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount createOnlineChatAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createOnlineChatAccount(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineChatAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount createOnlineChatAccount(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineChatAccount(resource, graph);
	}
	
	
	/**
	 * Create a new instance of OnlineChatAccount.  Leaves the dataset unchanged.
	 * @param resource The resource of the OnlineChatAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount getOnlineChatAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.OnlineChatAccountImpl.getOnlineChatAccount(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineChatAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount getOnlineChatAccount(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getOnlineChatAccount(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineChatAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount getOnlineChatAccount(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineChatAccount(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineChatAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount getOnlineChatAccount(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineChatAccount(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineChatAccount
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount getOnlineChatAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getOnlineChatAccount(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OnlineChatAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineChatAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineChatAccount getOnlineChatAccount(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineChatAccount(resource, graph);
	}
	
	/**
	 * Return an instance of OnlineChatAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineChatAccount
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineChatAccount> getAllOnlineChatAccount(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,OnlineChatAccount.TYPE,_namedGraphUri);
		java.util.List<OnlineChatAccount> list = new java.util.ArrayList<OnlineChatAccount>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getOnlineChatAccount(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of OnlineChatAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineChatAccount
	 * @param dataset the IDataset containing the data
	 * @return a List of OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineChatAccount> getAllOnlineChatAccount(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllOnlineChatAccount(null, dataset);
	}
	
	/**
	 * Return an instance of OnlineChatAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineChatAccount
	 * @param graph the NamedGraph containing the data
	 * @return a List of OnlineChatAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineChatAccount> getAllOnlineChatAccount(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllOnlineChatAccount(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isOnlineEcommerceAccountPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(OnlineEcommerceAccountImpl.accountNameProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.accountServiceHomepageProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.depictionProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.fundedByProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.homepageProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.logoProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.makerProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.pageProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.themeProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.dnaChecksumProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.nickProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.titleProperty) ||
			predicate.equals(OnlineEcommerceAccountImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineEcommerceAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount createOnlineEcommerceAccount(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		OnlineEcommerceAccount result= org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.createOnlineEcommerceAccount(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineEcommerceAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount createOnlineEcommerceAccount(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createOnlineEcommerceAccount(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineEcommerceAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount createOnlineEcommerceAccount(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineEcommerceAccount(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineEcommerceAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount createOnlineEcommerceAccount(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineEcommerceAccount(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineEcommerceAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount createOnlineEcommerceAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createOnlineEcommerceAccount(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineEcommerceAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount createOnlineEcommerceAccount(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineEcommerceAccount(resource, graph);
	}
	
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Leaves the dataset unchanged.
	 * @param resource The resource of the OnlineEcommerceAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount getOnlineEcommerceAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.getOnlineEcommerceAccount(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineEcommerceAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount getOnlineEcommerceAccount(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getOnlineEcommerceAccount(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineEcommerceAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount getOnlineEcommerceAccount(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineEcommerceAccount(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineEcommerceAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount getOnlineEcommerceAccount(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineEcommerceAccount(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineEcommerceAccount
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount getOnlineEcommerceAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getOnlineEcommerceAccount(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OnlineEcommerceAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineEcommerceAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineEcommerceAccount getOnlineEcommerceAccount(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineEcommerceAccount(resource, graph);
	}
	
	/**
	 * Return an instance of OnlineEcommerceAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineEcommerceAccount
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineEcommerceAccount> getAllOnlineEcommerceAccount(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,OnlineEcommerceAccount.TYPE,_namedGraphUri);
		java.util.List<OnlineEcommerceAccount> list = new java.util.ArrayList<OnlineEcommerceAccount>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getOnlineEcommerceAccount(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of OnlineEcommerceAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineEcommerceAccount
	 * @param dataset the IDataset containing the data
	 * @return a List of OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineEcommerceAccount> getAllOnlineEcommerceAccount(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllOnlineEcommerceAccount(null, dataset);
	}
	
	/**
	 * Return an instance of OnlineEcommerceAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineEcommerceAccount
	 * @param graph the NamedGraph containing the data
	 * @return a List of OnlineEcommerceAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineEcommerceAccount> getAllOnlineEcommerceAccount(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllOnlineEcommerceAccount(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isOnlineGamingAccountPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(OnlineGamingAccountImpl.accountNameProperty) ||
			predicate.equals(OnlineGamingAccountImpl.accountServiceHomepageProperty) ||
			predicate.equals(OnlineGamingAccountImpl.depictionProperty) ||
			predicate.equals(OnlineGamingAccountImpl.fundedByProperty) ||
			predicate.equals(OnlineGamingAccountImpl.homepageProperty) ||
			predicate.equals(OnlineGamingAccountImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(OnlineGamingAccountImpl.logoProperty) ||
			predicate.equals(OnlineGamingAccountImpl.makerProperty) ||
			predicate.equals(OnlineGamingAccountImpl.pageProperty) ||
			predicate.equals(OnlineGamingAccountImpl.themeProperty) ||
			predicate.equals(OnlineGamingAccountImpl.dnaChecksumProperty) ||
			predicate.equals(OnlineGamingAccountImpl.nickProperty) ||
			predicate.equals(OnlineGamingAccountImpl.titleProperty) ||
			predicate.equals(OnlineGamingAccountImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineGamingAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount createOnlineGamingAccount(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		OnlineGamingAccount result= org.openanzo.ontologies.foaf.OnlineGamingAccountImpl.createOnlineGamingAccount(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineGamingAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount createOnlineGamingAccount(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createOnlineGamingAccount(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineGamingAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount createOnlineGamingAccount(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineGamingAccount(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineGamingAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount createOnlineGamingAccount(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineGamingAccount(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineGamingAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount createOnlineGamingAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createOnlineGamingAccount(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineGamingAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount createOnlineGamingAccount(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOnlineGamingAccount(resource, graph);
	}
	
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Leaves the dataset unchanged.
	 * @param resource The resource of the OnlineGamingAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount getOnlineGamingAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.OnlineGamingAccountImpl.getOnlineGamingAccount(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineGamingAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount getOnlineGamingAccount(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getOnlineGamingAccount(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineGamingAccount
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount getOnlineGamingAccount(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineGamingAccount(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineGamingAccount
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount getOnlineGamingAccount(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineGamingAccount(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the OnlineGamingAccount
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount getOnlineGamingAccount(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getOnlineGamingAccount(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of OnlineGamingAccount.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the OnlineGamingAccount
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static OnlineGamingAccount getOnlineGamingAccount(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOnlineGamingAccount(resource, graph);
	}
	
	/**
	 * Return an instance of OnlineGamingAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineGamingAccount
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineGamingAccount> getAllOnlineGamingAccount(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,OnlineGamingAccount.TYPE,_namedGraphUri);
		java.util.List<OnlineGamingAccount> list = new java.util.ArrayList<OnlineGamingAccount>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getOnlineGamingAccount(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of OnlineGamingAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineGamingAccount
	 * @param dataset the IDataset containing the data
	 * @return a List of OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineGamingAccount> getAllOnlineGamingAccount(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllOnlineGamingAccount(null, dataset);
	}
	
	/**
	 * Return an instance of OnlineGamingAccount for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/OnlineGamingAccount
	 * @param graph the NamedGraph containing the data
	 * @return a List of OnlineGamingAccount
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<OnlineGamingAccount> getAllOnlineGamingAccount(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllOnlineGamingAccount(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isOrganizationPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(OrganizationImpl.descriptionProperty) ||
			predicate.equals(OrganizationImpl.aimChatIDProperty) ||
			predicate.equals(OrganizationImpl.birthdayProperty) ||
			predicate.equals(OrganizationImpl.genderProperty) ||
			predicate.equals(OrganizationImpl.icqChatIDProperty) ||
			predicate.equals(OrganizationImpl.jabberIDProperty) ||
			predicate.equals(OrganizationImpl.mbox__sha1sumProperty) ||
			predicate.equals(OrganizationImpl.msnChatIDProperty) ||
			predicate.equals(OrganizationImpl.yahooChatIDProperty) ||
			predicate.equals(OrganizationImpl.holdsAccountProperty) ||
			predicate.equals(OrganizationImpl.madeProperty) ||
			predicate.equals(OrganizationImpl.mboxProperty) ||
			predicate.equals(OrganizationImpl.tipjarProperty) ||
			predicate.equals(OrganizationImpl.weblogProperty) ||
			predicate.equals(OrganizationImpl.depictionProperty) ||
			predicate.equals(OrganizationImpl.fundedByProperty) ||
			predicate.equals(OrganizationImpl.homepageProperty) ||
			predicate.equals(OrganizationImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(OrganizationImpl.logoProperty) ||
			predicate.equals(OrganizationImpl.makerProperty) ||
			predicate.equals(OrganizationImpl.pageProperty) ||
			predicate.equals(OrganizationImpl.themeProperty) ||
			predicate.equals(OrganizationImpl.dnaChecksumProperty) ||
			predicate.equals(OrganizationImpl.nickProperty) ||
			predicate.equals(OrganizationImpl.titleProperty) ||
			predicate.equals(OrganizationImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Organization
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization createOrganization(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Organization result= org.openanzo.ontologies.foaf.OrganizationImpl.createOrganization(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Organization
	 * @param dataset the IDataset containing the data
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization createOrganization(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createOrganization(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Organization
	 * @param dataset the IDataset containing the data
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization createOrganization(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOrganization(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Organization
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization createOrganization(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOrganization(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Organization
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization createOrganization(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createOrganization(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Organization
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization createOrganization(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createOrganization(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Organization.  Leaves the dataset unchanged.
	 * @param resource The resource of the Organization
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization getOrganization(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.OrganizationImpl.getOrganization(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Organization
	 * @param dataset the IDataset containing the data
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization getOrganization(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getOrganization(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Organization
	 * @param dataset the IDataset containing the data
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization getOrganization(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOrganization(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Organization
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization getOrganization(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOrganization(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Organization
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization getOrganization(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getOrganization(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Organization.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Organization
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Organization getOrganization(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getOrganization(resource, graph);
	}
	
	/**
	 * Return an instance of Organization for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Organization
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Organization> getAllOrganization(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Organization.TYPE,_namedGraphUri);
		java.util.List<Organization> list = new java.util.ArrayList<Organization>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getOrganization(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Organization for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Organization
	 * @param dataset the IDataset containing the data
	 * @return a List of Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Organization> getAllOrganization(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllOrganization(null, dataset);
	}
	
	/**
	 * Return an instance of Organization for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Organization
	 * @param graph the NamedGraph containing the data
	 * @return a List of Organization
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Organization> getAllOrganization(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllOrganization(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isPersonPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(PersonImpl.based__nearProperty) ||
			predicate.equals(PersonImpl.depictionProperty) ||
			predicate.equals(PersonImpl.fundedByProperty) ||
			predicate.equals(PersonImpl.homepageProperty) ||
			predicate.equals(PersonImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(PersonImpl.logoProperty) ||
			predicate.equals(PersonImpl.makerProperty) ||
			predicate.equals(PersonImpl.pageProperty) ||
			predicate.equals(PersonImpl.themeProperty) ||
			predicate.equals(PersonImpl.dnaChecksumProperty) ||
			predicate.equals(PersonImpl.nickProperty) ||
			predicate.equals(PersonImpl.titleProperty) ||
			predicate.equals(PersonImpl.phoneProperty) ||
			predicate.equals(PersonImpl.descriptionProperty) ||
			predicate.equals(PersonImpl.aimChatIDProperty) ||
			predicate.equals(PersonImpl.birthdayProperty) ||
			predicate.equals(PersonImpl.genderProperty) ||
			predicate.equals(PersonImpl.icqChatIDProperty) ||
			predicate.equals(PersonImpl.jabberIDProperty) ||
			predicate.equals(PersonImpl.mbox__sha1sumProperty) ||
			predicate.equals(PersonImpl.msnChatIDProperty) ||
			predicate.equals(PersonImpl.yahooChatIDProperty) ||
			predicate.equals(PersonImpl.holdsAccountProperty) ||
			predicate.equals(PersonImpl.madeProperty) ||
			predicate.equals(PersonImpl.mboxProperty) ||
			predicate.equals(PersonImpl.tipjarProperty) ||
			predicate.equals(PersonImpl.weblogProperty) ||
			predicate.equals(PersonImpl.family__nameProperty) ||
			predicate.equals(PersonImpl.firstNameProperty) ||
			predicate.equals(PersonImpl.geekcodeProperty) ||
			predicate.equals(PersonImpl.givennameProperty) ||
			predicate.equals(PersonImpl.nameProperty) ||
			predicate.equals(PersonImpl.planProperty) ||
			predicate.equals(PersonImpl.surnameProperty) ||
			predicate.equals(PersonImpl.currentProjectProperty) ||
			predicate.equals(PersonImpl.imgProperty) ||
			predicate.equals(PersonImpl.interestProperty) ||
			predicate.equals(PersonImpl.knowsProperty) ||
			predicate.equals(PersonImpl.myersBriggsProperty) ||
			predicate.equals(PersonImpl.pastProjectProperty) ||
			predicate.equals(PersonImpl.publicationsProperty) ||
			predicate.equals(PersonImpl.schoolHomepageProperty) ||
			predicate.equals(PersonImpl.topic__interestProperty) ||
			predicate.equals(PersonImpl.workInfoHomepageProperty) ||
			predicate.equals(PersonImpl.workplaceHomepageProperty) ;
	}
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Person
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person createPerson(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Person result= org.openanzo.ontologies.foaf.PersonImpl.createPerson(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Person
	 * @param dataset the IDataset containing the data
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person createPerson(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createPerson(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Person
	 * @param dataset the IDataset containing the data
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person createPerson(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPerson(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Person
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person createPerson(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPerson(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Person
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person createPerson(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createPerson(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Person
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person createPerson(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPerson(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Person.  Leaves the dataset unchanged.
	 * @param resource The resource of the Person
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person getPerson(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.PersonImpl.getPerson(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Person
	 * @param dataset the IDataset containing the data
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person getPerson(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getPerson(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Person
	 * @param dataset the IDataset containing the data
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person getPerson(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPerson(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Person
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person getPerson(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPerson(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Person
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person getPerson(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getPerson(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Person.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Person
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Person getPerson(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPerson(resource, graph);
	}
	
	/**
	 * Return an instance of Person for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Person
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Person> getAllPerson(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Person.TYPE,_namedGraphUri);
		java.util.List<Person> list = new java.util.ArrayList<Person>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getPerson(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Person for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Person
	 * @param dataset the IDataset containing the data
	 * @return a List of Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Person> getAllPerson(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllPerson(null, dataset);
	}
	
	/**
	 * Return an instance of Person for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Person
	 * @param graph the NamedGraph containing the data
	 * @return a List of Person
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Person> getAllPerson(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllPerson(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isPersonalProfileDocumentPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(PersonalProfileDocumentImpl.sha1Property) ||
			predicate.equals(PersonalProfileDocumentImpl.primaryTopicProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.topicProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.depictionProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.fundedByProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.homepageProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.logoProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.makerProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.pageProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.themeProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.dnaChecksumProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.nickProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.titleProperty) ||
			predicate.equals(PersonalProfileDocumentImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersonalProfileDocument
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument createPersonalProfileDocument(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		PersonalProfileDocument result= org.openanzo.ontologies.foaf.PersonalProfileDocumentImpl.createPersonalProfileDocument(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersonalProfileDocument
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument createPersonalProfileDocument(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createPersonalProfileDocument(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersonalProfileDocument
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument createPersonalProfileDocument(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPersonalProfileDocument(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersonalProfileDocument
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument createPersonalProfileDocument(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPersonalProfileDocument(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersonalProfileDocument
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument createPersonalProfileDocument(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createPersonalProfileDocument(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersonalProfileDocument
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument createPersonalProfileDocument(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createPersonalProfileDocument(resource, graph);
	}
	
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Leaves the dataset unchanged.
	 * @param resource The resource of the PersonalProfileDocument
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument getPersonalProfileDocument(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.PersonalProfileDocumentImpl.getPersonalProfileDocument(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersonalProfileDocument
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument getPersonalProfileDocument(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getPersonalProfileDocument(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersonalProfileDocument
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument getPersonalProfileDocument(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPersonalProfileDocument(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersonalProfileDocument
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument getPersonalProfileDocument(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPersonalProfileDocument(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the PersonalProfileDocument
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument getPersonalProfileDocument(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getPersonalProfileDocument(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of PersonalProfileDocument.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the PersonalProfileDocument
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static PersonalProfileDocument getPersonalProfileDocument(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getPersonalProfileDocument(resource, graph);
	}
	
	/**
	 * Return an instance of PersonalProfileDocument for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/PersonalProfileDocument
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<PersonalProfileDocument> getAllPersonalProfileDocument(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,PersonalProfileDocument.TYPE,_namedGraphUri);
		java.util.List<PersonalProfileDocument> list = new java.util.ArrayList<PersonalProfileDocument>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getPersonalProfileDocument(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of PersonalProfileDocument for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/PersonalProfileDocument
	 * @param dataset the IDataset containing the data
	 * @return a List of PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<PersonalProfileDocument> getAllPersonalProfileDocument(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllPersonalProfileDocument(null, dataset);
	}
	
	/**
	 * Return an instance of PersonalProfileDocument for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/PersonalProfileDocument
	 * @param graph the NamedGraph containing the data
	 * @return a List of PersonalProfileDocument
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<PersonalProfileDocument> getAllPersonalProfileDocument(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllPersonalProfileDocument(graph.getNamedGraphUri(), dataset);
	}


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isProjectPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(ProjectImpl.depictionProperty) ||
			predicate.equals(ProjectImpl.fundedByProperty) ||
			predicate.equals(ProjectImpl.homepageProperty) ||
			predicate.equals(ProjectImpl.isPrimaryTopicOfProperty) ||
			predicate.equals(ProjectImpl.logoProperty) ||
			predicate.equals(ProjectImpl.makerProperty) ||
			predicate.equals(ProjectImpl.pageProperty) ||
			predicate.equals(ProjectImpl.themeProperty) ||
			predicate.equals(ProjectImpl.dnaChecksumProperty) ||
			predicate.equals(ProjectImpl.nickProperty) ||
			predicate.equals(ProjectImpl.titleProperty) ||
			predicate.equals(ProjectImpl.phoneProperty) ;
	}
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Project
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project createProject(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Project result= org.openanzo.ontologies.foaf.ProjectImpl.createProject(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Project
	 * @param dataset the IDataset containing the data
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project createProject(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createProject(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Project
	 * @param dataset the IDataset containing the data
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project createProject(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createProject(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Project
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project createProject(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createProject(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Project
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project createProject(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createProject(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Project
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project createProject(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createProject(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Project.  Leaves the dataset unchanged.
	 * @param resource The resource of the Project
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project getProject(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.foaf.ProjectImpl.getProject(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Project
	 * @param dataset the IDataset containing the data
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project getProject(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getProject(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Project
	 * @param dataset the IDataset containing the data
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project getProject(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getProject(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Project
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project getProject(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getProject(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Project
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project getProject(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getProject(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Project.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Project
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Project getProject(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getProject(resource, graph);
	}
	
	/**
	 * Return an instance of Project for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Project
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Project> getAllProject(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Project.TYPE,_namedGraphUri);
		java.util.List<Project> list = new java.util.ArrayList<Project>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getProject(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Project for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Project
	 * @param dataset the IDataset containing the data
	 * @return a List of Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Project> getAllProject(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllProject(null, dataset);
	}
	
	/**
	 * Return an instance of Project for every resource in the dataset with rdf:Type http://xmlns.com/foaf/0.1/Project
	 * @param graph the NamedGraph containing the data
	 * @return a List of Project
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Project> getAllProject(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllProject(graph.getNamedGraphUri(), dataset);
	}



	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 * @throws org.openanzo.rdf.jastor.JastorException 
	 */
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Project"), namedGraphUri)) {
			return getProject(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/PersonalProfileDocument"), namedGraphUri)) {
			return getPersonalProfileDocument(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Person"), namedGraphUri)) {
			return getPerson(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing"), namedGraphUri)) {
			return getSpatialThing(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Organization"), namedGraphUri)) {
			return getOrganization(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/OnlineGamingAccount"), namedGraphUri)) {
			return getOnlineGamingAccount(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/OnlineEcommerceAccount"), namedGraphUri)) {
			return getOnlineEcommerceAccount(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/OnlineChatAccount"), namedGraphUri)) {
			return getOnlineChatAccount(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/OnlineAccount"), namedGraphUri)) {
			return getOnlineAccount(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Image"), namedGraphUri)) {
			return getImage(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), namedGraphUri)) {
			return getDocument(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Group"), namedGraphUri)) {
			return getGroup(resource, namedGraphUri, dataset);
		}
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Agent"), namedGraphUri)) {
			return getAgent(resource, namedGraphUri, dataset);
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
	 * in the FOAF ontology.
	 * @param type the type for which to find compatible interfaces
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> listCompatibleInterfaces (org.openanzo.rdf.Resource type) {
		java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> types = new java.util.ArrayList<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>>();
		if (type.equals(org.openanzo.ontologies.foaf.SpatialThing.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.SpatialThing.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.Agent.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.Agent.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.Document.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.Document.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.Group.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.Group.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.Image.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.Image.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.OnlineAccount.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.OnlineAccount.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.OnlineChatAccount.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.OnlineChatAccount.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.OnlineEcommerceAccount.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.OnlineEcommerceAccount.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.OnlineGamingAccount.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.OnlineGamingAccount.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.Organization.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.Organization.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.Person.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.Person.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.PersonalProfileDocument.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.PersonalProfileDocument.class);
		}
		if (type.equals(org.openanzo.ontologies.foaf.Project.TYPE)) {
			types.add(org.openanzo.ontologies.foaf.Project.class);
		}
		return types;
	}
}