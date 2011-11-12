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
 * Interface for ReferencedNamedGraph ontology class<br>
 * Use the org.openanzo.ontologies.persistence.ClientPersistenceFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedNamedGraph)</p>
 * <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface ReferencedNamedGraph extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#ReferencedNamedGraph");
	

	/**
	 * The Anzo Property for graphUri 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#graphUri)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : named graph uri for a  reference quad store <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI graphUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#graphUri");


	/**
	 * The Anzo Property for referenceUri 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#referenceUri)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : unique uri for named graph in the actual quad store <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI referenceUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#referenceUri");




	/**
	 * Gets the 'graphUri' property value
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#graphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getGraphUri() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'graphUri' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#graphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'graphUri' property value
	 * @param	graphUri	{@link org.openanzo.rdf.jastor.Thing}, value to set
	 * @see			#graphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setGraphUri(org.openanzo.rdf.jastor.Thing graphUri) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'graphUri' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the created value
	 * @see			#graphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.Thing setGraphUri() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'graphUri' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory.
	 * and calling setGraphUri(org.openanzo.rdf.jastor.Thing graphUri)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the newly created value
	 * @see			#graphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing setGraphUri(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'graphUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#graphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'referenceUri' property value
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#referenceUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getReferenceUri() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'referenceUri' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#referenceUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getReferenceUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'referenceUri' property value
	 * @param	referenceUri	{@link org.openanzo.rdf.jastor.Thing}, value to set
	 * @see			#referenceUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setReferenceUri(org.openanzo.rdf.jastor.Thing referenceUri) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'referenceUri' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the created value
	 * @see			#referenceUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.Thing setReferenceUri() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'referenceUri' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory.
	 * and calling setReferenceUri(org.openanzo.rdf.jastor.Thing referenceUri)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the newly created value
	 * @see			#referenceUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing setReferenceUri(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'referenceUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#referenceUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearReferenceUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}