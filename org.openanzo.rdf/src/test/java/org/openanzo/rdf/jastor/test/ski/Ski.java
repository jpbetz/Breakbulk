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
package org.openanzo.rdf.jastor.test.ski;

/**
 * Interface for Ski Class ontology class<br>
 * Use the org.openanzo.rdf.jastor.test.ski.SkiFactory to create instances of this interface.
 * <p>(URI: http://jastor.openanzo.org/testonts/classes#Ski)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	label : Ski Class <br>
 * 	seeAlso : http://jastor.openanzo.org/testonts/classes#TwinTiphttp://jastor.openanzo.org/testonts/classes#PowderSki <br>
 * 	comment : This class represents the base ontology class for describing skis <br>
 * <br>
 * Dublin Core Standard Properties <br>
 * 	title : Ski Title <br>
 * 	contributor : Joe Betz <br>
 * 	creator : Ben Szekely <br>
 * <br>
 *	@version 1.0
 */
 @SuppressWarnings("all")
public interface Ski extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/classes#Ski");
	

	/**
	 * The Anzo Property for designer 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#designer)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI designerProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#designer");


	/**
	 * The Anzo Property for attribute 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#attribute)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI attributeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#attribute");


	/**
	 * The Anzo Property for availableLength 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#availableLength)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI availableLengthProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#availableLength");


	/**
	 * The Anzo Property for coreConstruction 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#coreConstruction)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI coreConstructionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#coreConstruction");


	/**
	 * The Anzo Property for coreMaterial 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#coreMaterial)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI coreMaterialProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#coreMaterial");


	/**
	 * The Anzo Property for manufacturer 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#manufacturer)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	label : Manufacturer <br>
	 * 	comment : This property indicates the manufacturer of the ski <br>
	 * <br>
	 * Dublin Core Standard Properties <br>
	 * 	title : Manufacturer Title <br>
	 * 	contributor : Joe Betz <br>
	 * 	creator : Ben Szekely <br>
	 * <br>  
	 * @version 1.0
	 */
	public static org.openanzo.rdf.URI manufacturerProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#manufacturer");


	/**
	 * The Anzo Property for model 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#model)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI modelProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#model");


	/**
	 * The Anzo Property for partnum 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#partnum)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI partnumProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#partnum");


	/**
	 * The Anzo Property for relatedPartnum 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#relatedPartnum)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI relatedPartnumProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#relatedPartnum");


	/**
	 * The Anzo Property for website 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#website)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI websiteProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#website");


	/**
	 * The Anzo Property for competesWith 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#competesWith)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI competesWithProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#competesWith");


	/**
	 * The Anzo Property for identifier 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#identifier)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI identifierProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#identifier");


	/**
	 * The Anzo Property for mostSimilarTo 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#mostSimilarTo)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI mostSimilarToProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#mostSimilarTo");


	/**
	 * The Anzo Property for multiIdentifier 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#multiIdentifier)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI multiIdentifierProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#multiIdentifier");


	/**
	 * The Anzo Property for previousModel 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#previousModel)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI previousModelProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#previousModel");


	/**
	 * The Anzo Property for sidewall 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#sidewall)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI sidewallProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#sidewall");


	/**
	 * The Anzo Property for isAlpine 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#isAlpine)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI isAlpineProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#isAlpine");


	/**
	 * The Anzo Property for isFreestyle 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#isFreestyle)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI isFreestyleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#isFreestyle");


	/**
	 * The Anzo Property for preferredStance 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#preferredStance)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI preferredStanceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#preferredStance");


	/**
	 * The Anzo Property for complimentBoard 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#complimentBoard)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI complimentBoardProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#complimentBoard");




	/**
	 * Gets the 'designer' property value
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.Ski}
	 * @see			#designerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski getDesigner() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'designer' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.Ski}
	 * @see			#designerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski getDesigner(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'designer' property value
	 * @param	designer	{@link org.openanzo.rdf.jastor.test.ski.Ski}, value to set
	 * @see			#designerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setDesigner(org.openanzo.rdf.jastor.test.ski.Ski designer) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'designer' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.Ski}, the created value
	 * @see			#designerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.test.ski.Ski setDesigner() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'designer' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.test.ski.Ski} with the factory.
	 * and calling setDesigner(org.openanzo.rdf.jastor.test.ski.Ski designer)
	 * The resource argument have rdf:type http://jastor.openanzo.org/testonts/classes#Ski.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.Ski}, the newly created value
	 * @see			#designerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski setDesigner(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'designer'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#designerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDesigner(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'attribute' property value from the given graph
	 * @return		{@link org.openanzo.rdf.Literal}
	 * @see			#attributeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.Literal getAttribute() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'attribute' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.Literal}
	 * @see			#attributeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.Literal getAttribute(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'attribute' property value
	 * @param	attribute	{@link org.openanzo.rdf.Literal}, the value to set
	 * @see			#attributeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setAttribute(org.openanzo.rdf.Literal attribute) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'attribute'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#attributeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearAttribute(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'availableLength' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.Integer}
	 * @see			#availableLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Integer> getAvailableLength() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'availableLength' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.Integer}
	 * @see			#availableLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Integer> getAvailableLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'availableLength' property value
	 * @param	availableLength	{@link java.lang.Integer}, the value to add
	 * @see			#availableLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addAvailableLength(java.lang.Integer availableLength) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'availableLength' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	availableLength	{@link java.lang.Integer}, the value to remove
	 * @see			#availableLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeAvailableLength(java.lang.Integer availableLength) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'availableLength'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#availableLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearAvailableLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'coreConstruction' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#coreConstructionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getCoreConstruction() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'coreConstruction' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#coreConstructionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getCoreConstruction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'coreConstruction' property value
	 * @param	coreConstruction	{@link java.lang.String}, the value to set
	 * @see			#coreConstructionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setCoreConstruction(java.lang.String coreConstruction) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'coreConstruction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#coreConstructionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCoreConstruction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'coreMaterial' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.String}
	 * @see			#coreMaterialProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.String> getCoreMaterial() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'coreMaterial' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.String}
	 * @see			#coreMaterialProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.String> getCoreMaterial(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'coreMaterial' property value
	 * @param	coreMaterial	{@link java.lang.String}, the value to add
	 * @see			#coreMaterialProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addCoreMaterial(java.lang.String coreMaterial) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'coreMaterial' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	coreMaterial	{@link java.lang.String}, the value to remove
	 * @see			#coreMaterialProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCoreMaterial(java.lang.String coreMaterial) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'coreMaterial'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#coreMaterialProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCoreMaterial(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'manufacturer' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#manufacturerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getManufacturer() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'manufacturer' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#manufacturerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getManufacturer(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'manufacturer' property value
	 * @param	manufacturer	{@link java.lang.String}, the value to set
	 * @see			#manufacturerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setManufacturer(java.lang.String manufacturer) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'manufacturer'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#manufacturerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearManufacturer(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'model' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#modelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getModel() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'model' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#modelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getModel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'model' property value
	 * @param	model	{@link java.lang.String}, the value to set
	 * @see			#modelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setModel(java.lang.String model) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'model'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#modelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearModel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'partnum' property value from the given graph
	 * @return		{@link java.lang.Long}
	 * @see			#partnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getPartnum() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'partnum' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Long}
	 * @see			#partnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'partnum' property value
	 * @param	partnum	{@link java.lang.Long}, the value to set
	 * @see			#partnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setPartnum(java.lang.Long partnum) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'partnum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#partnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'relatedPartnum' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.Long}
	 * @see			#relatedPartnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Long> getRelatedPartnum() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'relatedPartnum' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.Long}
	 * @see			#relatedPartnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Long> getRelatedPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'relatedPartnum' property value
	 * @param	relatedPartnum	{@link java.lang.Long}, the value to add
	 * @see			#relatedPartnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addRelatedPartnum(java.lang.Long relatedPartnum) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'relatedPartnum' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	relatedPartnum	{@link java.lang.Long}, the value to remove
	 * @see			#relatedPartnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeRelatedPartnum(java.lang.Long relatedPartnum) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'relatedPartnum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#relatedPartnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRelatedPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'website' property value from the given graph
	 * @return		{@link org.openanzo.rdf.URI}
	 * @see			#websiteProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.URI getWebsite() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'website' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.URI}
	 * @see			#websiteProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.URI getWebsite(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'website' property value
	 * @param	website	{@link org.openanzo.rdf.URI}, the value to set
	 * @see			#websiteProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setWebsite(org.openanzo.rdf.URI website) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'website'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#websiteProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearWebsite(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'competesWith' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.test.ski.Ski}
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getCompetesWith() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'competesWith' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.test.ski.Ski}
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getCompetesWith(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'competesWith' property
	 * @param	competesWith	The {@link org.openanzo.rdf.jastor.test.ski.Ski} to add
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addCompetesWith(org.openanzo.rdf.jastor.test.ski.Ski competesWith) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'competesWith' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.test.ski.Ski} created
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski addCompetesWith() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'competesWith' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.test.ski.Ski} with the factory
	 * and calling addCompetesWith(org.openanzo.rdf.jastor.test.ski.Ski competesWith)
	 * The resource argument have rdf:type http://jastor.openanzo.org/testonts/classes#Ski.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.test.ski.Ski, value added
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski addCompetesWith(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'competesWith' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	competesWith	The {@link org.openanzo.rdf.jastor.test.ski.Ski} to remove
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCompetesWith(org.openanzo.rdf.jastor.test.ski.Ski competesWith) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'competesWith' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	competesWith	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCompetesWith(org.openanzo.rdf.Resource competesWith) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'competesWith'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCompetesWith(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'identifier' property value
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#identifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getIdentifier() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'identifier' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#identifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getIdentifier(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'identifier' property value
	 * @param	identifier	{@link org.openanzo.rdf.jastor.Thing}, value to set
	 * @see			#identifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setIdentifier(org.openanzo.rdf.jastor.Thing identifier) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'identifier' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the created value
	 * @see			#identifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.Thing setIdentifier() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'identifier' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory.
	 * and calling setIdentifier(org.openanzo.rdf.jastor.Thing identifier)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the newly created value
	 * @see			#identifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing setIdentifier(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'identifier'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#identifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIdentifier(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'mostSimilarTo' property value
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.Ski}
	 * @see			#mostSimilarToProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski getMostSimilarTo() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'mostSimilarTo' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.Ski}
	 * @see			#mostSimilarToProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski getMostSimilarTo(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'mostSimilarTo' property value
	 * @param	mostSimilarTo	{@link org.openanzo.rdf.jastor.test.ski.Ski}, value to set
	 * @see			#mostSimilarToProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setMostSimilarTo(org.openanzo.rdf.jastor.test.ski.Ski mostSimilarTo) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'mostSimilarTo' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.Ski}, the created value
	 * @see			#mostSimilarToProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.test.ski.Ski setMostSimilarTo() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'mostSimilarTo' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.test.ski.Ski} with the factory.
	 * and calling setMostSimilarTo(org.openanzo.rdf.jastor.test.ski.Ski mostSimilarTo)
	 * The resource argument have rdf:type http://jastor.openanzo.org/testonts/classes#Ski.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.Ski}, the newly created value
	 * @see			#mostSimilarToProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski setMostSimilarTo(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'mostSimilarTo'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#mostSimilarToProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMostSimilarTo(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'multiIdentifier' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#multiIdentifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMultiIdentifier() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'multiIdentifier' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#multiIdentifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMultiIdentifier(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'multiIdentifier' property
	 * @param	multiIdentifier	The {@link org.openanzo.rdf.jastor.Thing} to add
	 * @see			#multiIdentifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addMultiIdentifier(org.openanzo.rdf.jastor.Thing multiIdentifier) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'multiIdentifier' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.Thing} created
	 * @see			#multiIdentifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addMultiIdentifier() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'multiIdentifier' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory
	 * and calling addMultiIdentifier(org.openanzo.rdf.jastor.Thing multiIdentifier)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.Thing, value added
	 * @see			#multiIdentifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addMultiIdentifier(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'multiIdentifier' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	multiIdentifier	The {@link org.openanzo.rdf.jastor.Thing} to remove
	 * @see			#multiIdentifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMultiIdentifier(org.openanzo.rdf.jastor.Thing multiIdentifier) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'multiIdentifier' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	multiIdentifier	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#multiIdentifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMultiIdentifier(org.openanzo.rdf.Resource multiIdentifier) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'multiIdentifier'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#multiIdentifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMultiIdentifier(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'previousModel' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.test.ski.Ski}
	 * @see			#previousModelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getPreviousModel() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'previousModel' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.test.ski.Ski}
	 * @see			#previousModelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getPreviousModel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'previousModel' property
	 * @param	previousModel	The {@link org.openanzo.rdf.jastor.test.ski.Ski} to add
	 * @see			#previousModelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addPreviousModel(org.openanzo.rdf.jastor.test.ski.Ski previousModel) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'previousModel' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.test.ski.Ski} created
	 * @see			#previousModelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski addPreviousModel() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'previousModel' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.test.ski.Ski} with the factory
	 * and calling addPreviousModel(org.openanzo.rdf.jastor.test.ski.Ski previousModel)
	 * The resource argument have rdf:type http://jastor.openanzo.org/testonts/classes#Ski.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.test.ski.Ski, value added
	 * @see			#previousModelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.Ski addPreviousModel(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'previousModel' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	previousModel	The {@link org.openanzo.rdf.jastor.test.ski.Ski} to remove
	 * @see			#previousModelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreviousModel(org.openanzo.rdf.jastor.test.ski.Ski previousModel) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'previousModel' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	previousModel	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#previousModelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreviousModel(org.openanzo.rdf.Resource previousModel) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'previousModel'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#previousModelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPreviousModel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'sidewall' property value
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.SidewallEnum}
	 * @see			#sidewallProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.SidewallEnum getSidewall() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'sidewall' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.SidewallEnum}
	 * @see			#sidewallProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.SidewallEnum getSidewall(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'sidewall' property value
	 * @param	sidewall	{@link org.openanzo.rdf.jastor.test.ski.SidewallEnum}, value to set
	 * @see			#sidewallProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSidewall(org.openanzo.rdf.jastor.test.ski.SidewallEnum sidewall) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'sidewall' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.SidewallEnum}, the created value
	 * @see			#sidewallProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.test.ski.SidewallEnum setSidewall() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'sidewall' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.test.ski.SidewallEnum} with the factory.
	 * and calling setSidewall(org.openanzo.rdf.jastor.test.ski.SidewallEnum sidewall)
	 * The resource argument have rdf:type http://jastor.openanzo.org/gen#SidewallEnum.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.test.ski.SidewallEnum}, the newly created value
	 * @see			#sidewallProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.SidewallEnum setSidewall(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'sidewall'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#sidewallProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSidewall(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'isAlpine' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.Boolean}
	 * @see			#isAlpineProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Boolean> getIsAlpine() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'isAlpine' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.Boolean}
	 * @see			#isAlpineProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.Boolean> getIsAlpine(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'isAlpine' property value
	 * @param	isAlpine	{@link java.lang.Boolean}, the value to add
	 * @see			#isAlpineProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addIsAlpine(java.lang.Boolean isAlpine) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'isAlpine' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	isAlpine	{@link java.lang.Boolean}, the value to remove
	 * @see			#isAlpineProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeIsAlpine(java.lang.Boolean isAlpine) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'isAlpine'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#isAlpineProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIsAlpine(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'isFreestyle' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#isFreestyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getIsFreestyle() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'isFreestyle' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#isFreestyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getIsFreestyle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'isFreestyle' property
	 * @param	isFreestyle	The {@link org.openanzo.rdf.jastor.Thing} to add
	 * @see			#isFreestyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addIsFreestyle(org.openanzo.rdf.jastor.Thing isFreestyle) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'isFreestyle' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.Thing} created
	 * @see			#isFreestyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addIsFreestyle() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'isFreestyle' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory
	 * and calling addIsFreestyle(org.openanzo.rdf.jastor.Thing isFreestyle)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.Thing, value added
	 * @see			#isFreestyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addIsFreestyle(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'isFreestyle' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	isFreestyle	The {@link org.openanzo.rdf.jastor.Thing} to remove
	 * @see			#isFreestyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeIsFreestyle(org.openanzo.rdf.jastor.Thing isFreestyle) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'isFreestyle' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	isFreestyle	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#isFreestyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeIsFreestyle(org.openanzo.rdf.Resource isFreestyle) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'isFreestyle'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#isFreestyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIsFreestyle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'preferredStance' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.String}
	 * @see			#preferredStanceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.String> getPreferredStance() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'preferredStance' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.String}
	 * @see			#preferredStanceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.String> getPreferredStance(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'preferredStance' property value
	 * @param	preferredStance	{@link java.lang.String}, the value to add
	 * @see			#preferredStanceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addPreferredStance(java.lang.String preferredStance) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'preferredStance' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	preferredStance	{@link java.lang.String}, the value to remove
	 * @see			#preferredStanceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreferredStance(java.lang.String preferredStance) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'preferredStance'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#preferredStanceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPreferredStance(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'complimentBoard' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#complimentBoardProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getComplimentBoard() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'complimentBoard' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#complimentBoardProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getComplimentBoard(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'complimentBoard' property
	 * @param	complimentBoard	The {@link org.openanzo.rdf.jastor.Thing} to add
	 * @see			#complimentBoardProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addComplimentBoard(org.openanzo.rdf.jastor.Thing complimentBoard) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'complimentBoard' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.Thing} created
	 * @see			#complimentBoardProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addComplimentBoard() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'complimentBoard' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory
	 * and calling addComplimentBoard(org.openanzo.rdf.jastor.Thing complimentBoard)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.Thing, value added
	 * @see			#complimentBoardProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addComplimentBoard(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'complimentBoard' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	complimentBoard	The {@link org.openanzo.rdf.jastor.Thing} to remove
	 * @see			#complimentBoardProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeComplimentBoard(org.openanzo.rdf.jastor.Thing complimentBoard) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'complimentBoard' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	complimentBoard	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#complimentBoardProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeComplimentBoard(org.openanzo.rdf.Resource complimentBoard) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'complimentBoard'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#complimentBoardProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearComplimentBoard(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}