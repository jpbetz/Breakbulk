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
 * Interface for DataRestriction ontology class<br>
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this interface.
 * <p>(URI: http://www.w3.org/2006/12/owl11#DataRestriction)</p>
 * <br>
 * <br>
 * <br>
 */
public interface DataRestriction extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#DataRestriction");
	

	/**
	 * The Anzo Property for maxCardinality 
	 * <p>(URI: http://www.w3.org/2002/07/owl#maxCardinality)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI maxCardinalityProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#maxCardinality");


	/**
	 * The Anzo Property for minCardinality 
	 * <p>(URI: http://www.w3.org/2002/07/owl#minCardinality)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI minCardinalityProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#minCardinality");


	/**
	 * The Anzo Property for cardinality 
	 * <p>(URI: http://www.w3.org/2002/07/owl#cardinality)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI cardinalityProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#cardinality");


	/**
	 * The Anzo Property for onProperty 
	 * <p>(URI: http://www.w3.org/2002/07/owl#onProperty)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI onPropertyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#onProperty");


	/**
	 * The Anzo Property for onDataRange 
	 * <p>(URI: http://www.w3.org/2006/12/owl11#onDataRange)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI onDataRangeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#onDataRange");




	/**
	 * Iterates through the 'maxCardinality' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.Integer}
	 * @see			#maxCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Integer> getMaxCardinality() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'maxCardinality' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.Integer}
	 * @see			#maxCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Integer> getMaxCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'maxCardinality' property value
	 * @param	maxCardinality	{@link java.lang.Integer}, the value to add
	 * @see			#maxCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addMaxCardinality(java.lang.Integer maxCardinality) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'maxCardinality' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	maxCardinality	{@link java.lang.Integer}, the value to remove
	 * @see			#maxCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMaxCardinality(java.lang.Integer maxCardinality) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'maxCardinality'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#maxCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMaxCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'minCardinality' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.Integer}
	 * @see			#minCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Integer> getMinCardinality() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'minCardinality' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.Integer}
	 * @see			#minCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Integer> getMinCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'minCardinality' property value
	 * @param	minCardinality	{@link java.lang.Integer}, the value to add
	 * @see			#minCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addMinCardinality(java.lang.Integer minCardinality) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'minCardinality' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	minCardinality	{@link java.lang.Integer}, the value to remove
	 * @see			#minCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMinCardinality(java.lang.Integer minCardinality) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'minCardinality'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#minCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMinCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'cardinality' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.Integer}
	 * @see			#cardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Integer> getCardinality() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'cardinality' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.Integer}
	 * @see			#cardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Integer> getCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'cardinality' property value
	 * @param	cardinality	{@link java.lang.Integer}, the value to add
	 * @see			#cardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addCardinality(java.lang.Integer cardinality) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'cardinality' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	cardinality	{@link java.lang.Integer}, the value to remove
	 * @see			#cardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCardinality(java.lang.Integer cardinality) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'cardinality'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#cardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'onProperty' property value
	 * @return		{@link org.openanzo.rdf.rdfs._Property}
	 * @see			#onPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.rdfs._Property getOnProperty() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'onProperty' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.rdfs._Property}
	 * @see			#onPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.rdfs._Property getOnProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'onProperty' property value
	 * @param	onProperty	{@link org.openanzo.rdf.rdfs._Property}, value to set
	 * @see			#onPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setOnProperty(org.openanzo.rdf.rdfs._Property onProperty) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'onProperty' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.rdfs._Property}, the created value
	 * @see			#onPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.rdfs._Property setOnProperty() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'onProperty' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.rdfs._Property} with the factory.
	 * and calling setOnProperty(org.openanzo.rdf.rdfs._Property onProperty)
	 * The resource argument have rdf:type http://www.w3.org/1999/02/22-rdf-syntax-ns#Property.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.rdfs._Property}, the newly created value
	 * @see			#onPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.rdfs._Property setOnProperty(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'onProperty'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#onPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearOnProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'onDataRange' property value
	 * @return		{@link org.openanzo.rdf.owl.DataRange}
	 * @see			#onDataRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.DataRange getOnDataRange() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'onDataRange' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.owl.DataRange}
	 * @see			#onDataRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.DataRange getOnDataRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'onDataRange' property value
	 * @param	onDataRange	{@link org.openanzo.rdf.owl.DataRange}, value to set
	 * @see			#onDataRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setOnDataRange(org.openanzo.rdf.owl.DataRange onDataRange) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'onDataRange' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.owl.DataRange}, the created value
	 * @see			#onDataRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.owl.DataRange setOnDataRange() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'onDataRange' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.DataRange} with the factory.
	 * and calling setOnDataRange(org.openanzo.rdf.owl.DataRange onDataRange)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#DataRange.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.owl.DataRange}, the newly created value
	 * @see			#onDataRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.DataRange setOnDataRange(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'onDataRange'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#onDataRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearOnDataRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}