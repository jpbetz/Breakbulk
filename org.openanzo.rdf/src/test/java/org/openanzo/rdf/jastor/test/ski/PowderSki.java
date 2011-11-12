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
 * Interface for PowderSki ontology class<br>
 * Use the org.openanzo.rdf.jastor.test.ski.SkiFactory to create instances of this interface.
 * <p>(URI: http://jastor.openanzo.org/testonts/classes#PowderSki)</p>
 * <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface PowderSki extends 
org.openanzo.rdf.jastor.test.ski.Ski, 
org.openanzo.rdf.jastor.test.ski.SpecialtySki, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/classes#PowderSki");
	

	/**
	 * The Anzo Property for proRider 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#proRider)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI proRiderProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#proRider");


	/**
	 * The Anzo Property for flotation 
	 * <p>(URI: http://jastor.openanzo.org/testonts/predicates#flotation)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI flotationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#flotation");


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
	 * Clears all values for 'designer'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#designerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDesigner(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'attribute'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#attributeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearAttribute(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'availableLength'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#availableLengthProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearAvailableLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'coreConstruction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#coreConstructionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCoreConstruction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'coreMaterial'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#coreMaterialProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCoreMaterial(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'manufacturer'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#manufacturerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearManufacturer(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'model'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#modelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearModel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'partnum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#partnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'relatedPartnum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#relatedPartnumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRelatedPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
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
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.test.ski.PowderSki}
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.PowderSki> getCompetesWith_asPowderSki() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'competesWith' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.test.ski.PowderSki}
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.PowderSki> getCompetesWith_asPowderSki(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'competesWith' property
	 * @param	competesWith	The {@link org.openanzo.rdf.jastor.test.ski.PowderSki} to add
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addCompetesWith(org.openanzo.rdf.jastor.test.ski.PowderSki competesWith) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'competesWith' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.test.ski.PowderSki} created
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.PowderSki addCompetesWith_asPowderSki() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'competesWith' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.test.ski.PowderSki} with the factory
	 * and calling addCompetesWith(org.openanzo.rdf.jastor.test.ski.PowderSki competesWith)
	 * The resource argument have rdf:type http://jastor.openanzo.org/testonts/classes#PowderSki.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.test.ski.PowderSki, value added
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.test.ski.PowderSki addCompetesWith_asPowderSki(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'competesWith' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	competesWith	The {@link org.openanzo.rdf.jastor.test.ski.PowderSki} to remove
	 * @see			#competesWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCompetesWith(org.openanzo.rdf.jastor.test.ski.PowderSki competesWith) throws org.openanzo.rdf.jastor.JastorException;

		
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
	 * Clears all values for 'identifier'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#identifierProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIdentifier(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'mostSimilarTo'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#mostSimilarToProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMostSimilarTo(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
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
	 * Clears all values for 'sidewall'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#sidewallProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSidewall(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'isAlpine'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#isAlpineProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIsAlpine(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
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
	 * Clears all values for 'preferredStance'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#preferredStanceProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPreferredStance(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
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
/**
	 * Clears all values for 'specialty'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#specialtyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSpecialty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'proRider' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link java.lang.String}
	 * @see			#proRiderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.String> getProRider() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'proRider' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link java.lang.String}
	 * @see			#proRiderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<java.lang.String> getProRider(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'proRider' property value
	 * @param	proRider	{@link java.lang.String}, the value to add
	 * @see			#proRiderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addProRider(java.lang.String proRider) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'proRider' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	proRider	{@link java.lang.String}, the value to remove
	 * @see			#proRiderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeProRider(java.lang.String proRider) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'proRider'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#proRiderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearProRider(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'flotation' property value from the given graph
	 * @return		{@link java.lang.Integer}
	 * @see			#flotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getFlotation() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'flotation' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Integer}
	 * @see			#flotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getFlotation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'flotation' property value
	 * @param	flotation	{@link java.lang.Integer}, the value to set
	 * @see			#flotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setFlotation(java.lang.Integer flotation) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'flotation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#flotationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearFlotation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}