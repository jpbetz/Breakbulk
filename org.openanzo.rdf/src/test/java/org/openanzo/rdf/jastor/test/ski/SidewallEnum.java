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
 * Interface for SidewallEnum ontology class<br>
 * Use the org.openanzo.rdf.jastor.test.ski.SkiFactory to create instances of this interface.
 * <p>(URI: http://jastor.openanzo.org/gen#SidewallEnum)</p>
 * <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface SidewallEnum extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/gen#SidewallEnum");
	

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
	 * Individual for URI: http://jastor.openanzo.org/testonts/individuals#Vertical
	 */
	public static org.openanzo.rdf.URI Vertical = org.openanzo.rdf.MemURI.create("http://jastor.openanzo.org/testonts/individuals#Vertical");


	/**
	 * Individual for URI: http://jastor.openanzo.org/testonts/individuals#Cap
	 */
	public static org.openanzo.rdf.URI Cap = org.openanzo.rdf.MemURI.create("http://jastor.openanzo.org/testonts/individuals#Cap");


	/**
	 * Individual for URI: http://jastor.openanzo.org/testonts/individuals#Angled
	 */
	public static org.openanzo.rdf.URI Angled = org.openanzo.rdf.MemURI.create("http://jastor.openanzo.org/testonts/individuals#Angled");



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