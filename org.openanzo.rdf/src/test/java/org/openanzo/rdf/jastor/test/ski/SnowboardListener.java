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
 * Implementations of this listener may be registered with instances of org.openanzo.rdf.jastor.test.ski.Snowboard to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface SnowboardListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when a value of complimentBoard has been added
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param newValue the object representing the new value
	 */	
	public void complimentBoardAdded(org.openanzo.rdf.jastor.test.ski.Snowboard source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of complimentBoard has been removed
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param oldValue the object representing the removed value
	 */
	public void complimentBoardRemoved(org.openanzo.rdf.jastor.test.ski.Snowboard source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of complimentBoard has been added
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param newValue the object representing the new value
	 */	
	public void complimentBoardAdded(org.openanzo.rdf.jastor.test.ski.Snowboard source, org.openanzo.rdf.jastor.test.ski.Snowboard newValue);

	/**
	 * Called when a value of complimentBoard has been removed
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param oldValue the object representing the removed value
	 */
	public void complimentBoardRemoved(org.openanzo.rdf.jastor.test.ski.Snowboard source, org.openanzo.rdf.jastor.test.ski.Snowboard oldValue);
		
	/**
	 * Called when preferredStance has changed
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 */
	public void preferredStanceChanged(org.openanzo.rdf.jastor.test.ski.Snowboard source);

	/**
	 * Called when isAlpine has changed
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 */
	public void isAlpineChanged(org.openanzo.rdf.jastor.test.ski.Snowboard source);

	/**
	 * Called when a value of designer has been added
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param newValue the object representing the new value
	 */	
	public void designerAdded(org.openanzo.rdf.jastor.test.ski.Snowboard source, org.openanzo.rdf.jastor.test.ski.Ski newValue);

	/**
	 * Called when a value of designer has been removed
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param oldValue the object representing the removed value
	 */
	public void designerRemoved(org.openanzo.rdf.jastor.test.ski.Snowboard source, org.openanzo.rdf.jastor.test.ski.Ski oldValue);
		
	/**
	 * Called when a value of availableBoardLength has been added
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param newValue the object representing the new value
	 */	
	public void availableBoardLengthAdded(org.openanzo.rdf.jastor.test.ski.Snowboard source, java.lang.Integer newValue);

	/**
	 * Called when a value of availableBoardLength has been removed
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param oldValue the object representing the removed value
	 */	
	public void availableBoardLengthRemoved(org.openanzo.rdf.jastor.test.ski.Snowboard source, java.lang.Integer oldValue);

	/**
	 * Called when extensionXML has changed
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 */
	public void extensionXMLChanged(org.openanzo.rdf.jastor.test.ski.Snowboard source);

	/**
	 * Called when a value of isFreestyle has been added
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param newValue the object representing the new value
	 */	
	public void isFreestyleAdded(org.openanzo.rdf.jastor.test.ski.Snowboard source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of isFreestyle has been removed
	 * @param source the affected instance of org.openanzo.rdf.jastor.test.ski.Snowboard
	 * @param oldValue the object representing the removed value
	 */
	public void isFreestyleRemoved(org.openanzo.rdf.jastor.test.ski.Snowboard source, org.openanzo.rdf.jastor.Thing oldValue);
		
}