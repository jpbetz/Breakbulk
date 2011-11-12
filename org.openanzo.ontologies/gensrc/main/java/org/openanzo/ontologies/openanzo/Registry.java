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
 * Interface for Registry ontology class<br>
 * Use the org.openanzo.ontologies.openanzo.AnzoFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#Registry)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : A Registry is .... <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Registry extends 
org.openanzo.ontologies.openanzo.Dataset, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#Registry");
	

	/**
	 * The Anzo Property for registeredType 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#registeredType)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI registeredTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#registeredType");




/**
	 * Clears all values for 'includeMetadataGraphs'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#includeMetadataGraphsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIncludeMetadataGraphs(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'defaultGraph' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	defaultGraph	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#defaultGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDefaultGraph(org.openanzo.rdf.Resource defaultGraph) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'defaultGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#defaultGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDefaultGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'defaultNamedGraph' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	defaultNamedGraph	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#defaultNamedGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDefaultNamedGraph(org.openanzo.rdf.Resource defaultNamedGraph) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'defaultNamedGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#defaultNamedGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDefaultNamedGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'namedGraph' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	namedGraph	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#namedGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeNamedGraph(org.openanzo.rdf.Resource namedGraph) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'namedGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#namedGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearNamedGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'registeredType' property value
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#registeredTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getRegisteredType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'registeredType' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#registeredTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getRegisteredType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'registeredType' property value
	 * @param	registeredType	{@link org.openanzo.rdf.jastor.Thing}, value to set
	 * @see			#registeredTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRegisteredType(org.openanzo.rdf.jastor.Thing registeredType) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'registeredType' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the created value
	 * @see			#registeredTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.Thing setRegisteredType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'registeredType' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory.
	 * and calling setRegisteredType(org.openanzo.rdf.jastor.Thing registeredType)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the newly created value
	 * @see			#registeredTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing setRegisteredType(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'registeredType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#registeredTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRegisteredType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}