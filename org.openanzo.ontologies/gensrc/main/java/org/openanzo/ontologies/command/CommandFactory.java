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

package org.openanzo.ontologies.command;

/**
 * Factory for instantiating objects for ontology classes in the Command ontology.  The
 * get methods leave the dataset unchanged and return a Java view of the object in the dataset.  The create methods
 * may add certain baseline properties to the dataset such as rdf:type and any properties with hasValue restrictions.
 * <p>(URI: http://openanzo.org/ontologies/Command)</p>
 * <br>
 * <br>
 * <br>
 */
public class CommandFactory extends org.openanzo.rdf.jastor.ThingFactory { 


	/**
	 *Determine if the given predicate is one of the properties for the given class 
	 *@param predicate predicate to check
	 *@return true if the given predicate is one of the properties for the given class
	 */
	public static boolean isCommandPredicate(org.openanzo.rdf.URI predicate){
		return 
			predicate.equals(CommandImpl.commandTypeProperty) ;
	}
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Command
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command createCommand(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI _namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		Command result= org.openanzo.ontologies.command.CommandImpl.createCommand(resource,_namedGraphUri,dataset);
		
		return result;
	}

	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Command
	 * @param dataset the IDataset containing the data
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command createCommand(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return createCommand(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Command
	 * @param dataset the IDataset containing the data
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command createCommand(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createCommand(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Command
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command createCommand(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createCommand(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Command
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command createCommand(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return createCommand(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Command
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command createCommand(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return createCommand(resource, graph);
	}
	
	
	/**
	 * Create a new instance of Command.  Leaves the dataset unchanged.
	 * @param resource The resource of the Command
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command getCommand(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return org.openanzo.ontologies.command.CommandImpl.getCommand(resource, _namedGraphUri,dataset);
	}	
	
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Command
	 * @param dataset the IDataset containing the data
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command getCommand(org.openanzo.rdf.URI resource, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getCommand(resource, resource, dataset);
	}
	
	
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Command
	 * @param dataset the IDataset containing the data
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command getCommand(String uri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getCommand(resource, resource, dataset);
	}
	
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Command
	 * @param _namedGraphUri the URI of the NamedGraph within the dataset where this object is to be created
	 * @param dataset the IDataset containing the data
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command getCommand(String uri, org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getCommand(resource, _namedGraphUri, dataset);
	}
	
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param resource The resource of the Command
	 * @param graph  the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command getCommand(org.openanzo.rdf.Resource resource, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getCommand(resource, graph.getNamedGraphUri(), dataset);
	}
	
	/**
	 * Create a new instance of Command.  Adds the rdf:type property for the given resource to the dataset.
	 * @param uri The uri of the Command
	 * @param graph the NamedGraph within the dataset where this object is to be created
	 * @return the newly created Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static Command getCommand(String uri, org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.URI resource=org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI(uri);
		return getCommand(resource, graph);
	}
	
	/**
	 * Return an instance of Command for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Command#Command
	 * @param _namedGraphUri the URI of the NamedGraph
	 * @param dataset the IDataset containing the data
	 * @return a List of Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Command> getAllCommand(org.openanzo.rdf.URI _namedGraphUri,org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = dataset.find(null,org.openanzo.rdf.vocabulary.RDF.TYPE,Command.TYPE,_namedGraphUri);
		java.util.List<Command> list = new java.util.ArrayList<Command>();
		for(org.openanzo.rdf.Statement stmt :result){
			org.openanzo.rdf.URI nguri = _namedGraphUri != null ? _namedGraphUri : (org.openanzo.rdf.URI)stmt.getSubject();
			list.add(getCommand(stmt.getSubject(),nguri,dataset));
		}
		return list;
	}
	
	/**
	 * Return an instance of Command for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Command#Command
	 * @param dataset the IDataset containing the data
	 * @return a List of Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Command> getAllCommand(org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		return getAllCommand(null, dataset);
	}
	
	/**
	 * Return an instance of Command for every resource in the dataset with rdf:Type http://openanzo.org/ontologies/2008/07/Command#Command
	 * @param graph the NamedGraph containing the data
	 * @return a List of Command
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public static java.util.List<Command> getAllCommand(org.openanzo.rdf.INamedGraph graph) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.IDataset dataset = org.openanzo.rdf.jastor.SingletonDataset.getInstance(graph);
		return getAllCommand(graph.getNamedGraphUri(), dataset);
	}



	/**
	 * Returns an instance of an interface for the given Resource.  The return instance is guaranteed to 
	 * implement the most specific interface in *some* hierarchy in which the Resource participates.  The behavior
	 * is unspecified for resources with RDF types from different hierarchies.
	 * @return an instance of Thing
	 * @throws org.openanzo.rdf.jastor.JastorException 
	 */
	public static org.openanzo.rdf.jastor.Thing getThing(org.openanzo.rdf.Resource resource, org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if (dataset.contains(resource,org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Command#Command"), namedGraphUri)) {
			return getCommand(resource, namedGraphUri, dataset);
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
	 * in the Command ontology.
	 * @param type the type for which to find compatible interfaces
	 * @return a List of type java.lang.Class
	 */
	public static java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> listCompatibleInterfaces (org.openanzo.rdf.Resource type) {
		java.util.List<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>> types = new java.util.ArrayList<java.lang.Class<? extends org.openanzo.rdf.jastor.Thing>>();
		if (type.equals(org.openanzo.ontologies.command.Command.TYPE)) {
			types.add(org.openanzo.ontologies.command.Command.class);
		}
		return types;
	}
}