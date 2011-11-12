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
 * Interface for DataRange ontology class<br>
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this interface.
 * <p>(URI: http://www.w3.org/2002/07/owl#DataRange)</p>
 * <br>
 * <br>
 * <br>
 */
public interface DataRange extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#DataRange");
	

	/**
	 * The Anzo Property for oneOf 
	 * <p>(URI: http://www.w3.org/2002/07/owl#oneOf)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI oneOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#oneOf");


	/**
	 * The Anzo Property for complementOf 
	 * <p>(URI: http://www.w3.org/2002/07/owl#complementOf)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI complementOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#complementOf");




	/**
	 * Gets the 'oneOf' property value
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getOneOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'oneOf' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getOneOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'oneOf' property value
	 * @param	oneOf	{@link org.openanzo.rdf.jastor.Thing}, value to set
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setOneOf(org.openanzo.rdf.jastor.Thing oneOf) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'oneOf' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the created value
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.Thing setOneOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'oneOf' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory.
	 * and calling setOneOf(org.openanzo.rdf.jastor.Thing oneOf)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the newly created value
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing setOneOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'oneOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearOneOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'complementOf' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.DataRange}
	 * @see			#complementOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.DataRange> getComplementOf() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'complementOf' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.DataRange}
	 * @see			#complementOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.DataRange> getComplementOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'complementOf' property
	 * @param	complementOf	The {@link org.openanzo.rdf.owl.DataRange} to add
	 * @see			#complementOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addComplementOf(org.openanzo.rdf.owl.DataRange complementOf) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'complementOf' property
	 * @return		The anoymous {@link org.openanzo.rdf.owl.DataRange} created
	 * @see			#complementOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.DataRange addComplementOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'complementOf' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.DataRange} with the factory
	 * and calling addComplementOf(org.openanzo.rdf.owl.DataRange complementOf)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#DataRange.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.owl.DataRange, value added
	 * @see			#complementOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.DataRange addComplementOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'complementOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	complementOf	The {@link org.openanzo.rdf.owl.DataRange} to remove
	 * @see			#complementOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeComplementOf(org.openanzo.rdf.owl.DataRange complementOf) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'complementOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	complementOf	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#complementOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeComplementOf(org.openanzo.rdf.Resource complementOf) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'complementOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#complementOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearComplementOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}