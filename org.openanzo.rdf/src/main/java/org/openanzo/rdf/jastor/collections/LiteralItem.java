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
 * Interface for LiteralItem ontology class<br>
 * Use the org.openanzo.rdf.jastor.collections.CollectionsFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Collections#LiteralItem)</p>
 * <br>
 * <br>
 * <br>
 */
public interface LiteralItem extends 
org.openanzo.rdf.jastor.collections.Item, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#LiteralItem");
	

	/**
	 * The Anzo Property for itemData 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Collections#itemData)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI itemDataProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#itemData");




	/**
	 * Gets the 'itemData' property value from the given graph
	 * @return		{@link org.openanzo.rdf.Literal}
	 * @see			#itemDataProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.Literal getItemData() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'itemData' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.Literal}
	 * @see			#itemDataProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.Literal getItemData(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'itemData' property value
	 * @param	itemData	{@link org.openanzo.rdf.Literal}, the value to set
	 * @see			#itemDataProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setItemData(org.openanzo.rdf.Literal itemData) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'itemData'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#itemDataProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearItemData(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}