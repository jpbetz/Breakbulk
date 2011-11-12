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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.openanzo.StatementStream to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface StatementStreamListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when created has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 */
	public void createdChanged(org.openanzo.ontologies.openanzo.StatementStream source);

	/**
	 * Called when hasMetadataGraph has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 */
	public void hasMetadataGraphChanged(org.openanzo.ontologies.openanzo.StatementStream source);

	/**
	 * Called when modified has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 */
	public void modifiedChanged(org.openanzo.ontologies.openanzo.StatementStream source);

	/**
	 * Called when persisted has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 */
	public void persistedChanged(org.openanzo.ontologies.openanzo.StatementStream source);

	/**
	 * Called when revision has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 */
	public void revisionChanged(org.openanzo.ontologies.openanzo.StatementStream source);

	/**
	 * Called when revisioned has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 */
	public void revisionedChanged(org.openanzo.ontologies.openanzo.StatementStream source);

	/**
	 * Called when uuid has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 */
	public void uuidChanged(org.openanzo.ontologies.openanzo.StatementStream source);

	/**
	 * Called when a value of canBeAddedToBy has been added
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param newValue the object representing the new value
	 */	
	public void canBeAddedToByAdded(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.Role newValue);

	/**
	 * Called when a value of canBeAddedToBy has been removed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param oldValue the object representing the removed value
	 */
	public void canBeAddedToByRemoved(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.Role oldValue);
		
	/**
	 * Called when a value of canBeReadBy has been added
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param newValue the object representing the new value
	 */	
	public void canBeReadByAdded(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.Role newValue);

	/**
	 * Called when a value of canBeReadBy has been removed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param oldValue the object representing the removed value
	 */
	public void canBeReadByRemoved(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.Role oldValue);
		
	/**
	 * Called when a value of canBeRemovedFromBy has been added
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param newValue the object representing the new value
	 */	
	public void canBeRemovedFromByAdded(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.Role newValue);

	/**
	 * Called when a value of canBeRemovedFromBy has been removed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param oldValue the object representing the removed value
	 */
	public void canBeRemovedFromByRemoved(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.Role oldValue);
		
	/**
	 * Called when a value of createdBy has been added
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param newValue the object representing the new value
	 */	
	public void createdByAdded(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.User newValue);

	/**
	 * Called when a value of createdBy has been removed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param oldValue the object representing the removed value
	 */
	public void createdByRemoved(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.User oldValue);
		
	/**
	 * Called when datasource has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 */
	public void datasourceChanged(org.openanzo.ontologies.openanzo.StatementStream source);

	/**
	 * Called when a value of inheritsFrom has been added
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param newValue the object representing the new value
	 */	
	public void inheritsFromAdded(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.NamedGraph newValue);

	/**
	 * Called when a value of inheritsFrom has been removed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param oldValue the object representing the removed value
	 */
	public void inheritsFromRemoved(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.NamedGraph oldValue);
		
	/**
	 * Called when a value of lastModifiedByUser has been added
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param newValue the object representing the new value
	 */	
	public void lastModifiedByUserAdded(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.User newValue);

	/**
	 * Called when a value of lastModifiedByUser has been removed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.StatementStream
	 * @param oldValue the object representing the removed value
	 */
	public void lastModifiedByUserRemoved(org.openanzo.ontologies.openanzo.StatementStream source, org.openanzo.ontologies.openanzo.User oldValue);
		
}