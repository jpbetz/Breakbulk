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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.persistence.PersistedPrecondition to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface PersistedPreconditionListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when askResult has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedPrecondition
	 */
	public void askResultChanged(org.openanzo.ontologies.persistence.PersistedPrecondition source);

	/**
	 * Called when queryString has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedPrecondition
	 */
	public void queryStringChanged(org.openanzo.ontologies.persistence.PersistedPrecondition source);

	/**
	 * Called when a value of preconditionDefaultUri has been added
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedPrecondition
	 * @param newValue the object representing the new value
	 */	
	public void preconditionDefaultUriAdded(org.openanzo.ontologies.persistence.PersistedPrecondition source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of preconditionDefaultUri has been removed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedPrecondition
	 * @param oldValue the object representing the removed value
	 */
	public void preconditionDefaultUriRemoved(org.openanzo.ontologies.persistence.PersistedPrecondition source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of preconditionNamedGraphUri has been added
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedPrecondition
	 * @param newValue the object representing the new value
	 */	
	public void preconditionNamedGraphUriAdded(org.openanzo.ontologies.persistence.PersistedPrecondition source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of preconditionNamedGraphUri has been removed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedPrecondition
	 * @param oldValue the object representing the removed value
	 */
	public void preconditionNamedGraphUriRemoved(org.openanzo.ontologies.persistence.PersistedPrecondition source, org.openanzo.rdf.jastor.Thing oldValue);
		
}