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
package org.openanzo.rdf.jastor.collections;

/**
 * Interface for OrderedItem ontology class<br>
 * Use the org.openanzo.rdf.jastor.collections.CollectionsFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Collections#OrderedItem)</p>
 * <br>
 * <br>
 * <br>
 */
public interface OrderedItem extends 
org.openanzo.rdf.jastor.collections.Item, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#OrderedItem");
	

	/**
	 * The Anzo Property for nextItem 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Collections#nextItem)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI nextItemProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#nextItem");


	/**
	 * The Anzo Property for previousItem 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Collections#previousItem)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI previousItemProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#previousItem");




	/**
	 * Gets the 'nextItem' property value
	 * @return		{@link org.openanzo.rdf.jastor.collections.OrderedItem}
	 * @see			#nextItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.collections.OrderedItem getNextItem() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'nextItem' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.collections.OrderedItem}
	 * @see			#nextItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.collections.OrderedItem getNextItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'nextItem' property value
	 * @param	nextItem	{@link org.openanzo.rdf.jastor.collections.OrderedItem}, value to set
	 * @see			#nextItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setNextItem(org.openanzo.rdf.jastor.collections.OrderedItem nextItem) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'nextItem' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.collections.OrderedItem}, the created value
	 * @see			#nextItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.collections.OrderedItem setNextItem() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'nextItem' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.collections.OrderedItem} with the factory.
	 * and calling setNextItem(org.openanzo.rdf.jastor.collections.OrderedItem nextItem)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/Collections#OrderedItem.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.collections.OrderedItem}, the newly created value
	 * @see			#nextItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.collections.OrderedItem setNextItem(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'nextItem'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#nextItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearNextItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'previousItem' property value
	 * @return		{@link org.openanzo.rdf.jastor.collections.OrderedItem}
	 * @see			#previousItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.collections.OrderedItem getPreviousItem() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'previousItem' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.collections.OrderedItem}
	 * @see			#previousItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.collections.OrderedItem getPreviousItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'previousItem' property value
	 * @param	previousItem	{@link org.openanzo.rdf.jastor.collections.OrderedItem}, value to set
	 * @see			#previousItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setPreviousItem(org.openanzo.rdf.jastor.collections.OrderedItem previousItem) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'previousItem' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.collections.OrderedItem}, the created value
	 * @see			#previousItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.collections.OrderedItem setPreviousItem() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'previousItem' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.collections.OrderedItem} with the factory.
	 * and calling setPreviousItem(org.openanzo.rdf.jastor.collections.OrderedItem previousItem)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/Collections#OrderedItem.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.collections.OrderedItem}, the newly created value
	 * @see			#previousItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.collections.OrderedItem setPreviousItem(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'previousItem'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#previousItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPreviousItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}