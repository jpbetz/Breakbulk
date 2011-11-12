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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.openanzo.Registry to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface RegistryListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when includeMetadataGraphs has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.Registry
	 */
	public void includeMetadataGraphsChanged(org.openanzo.ontologies.openanzo.Registry source);

	/**
	 * Called when a value of defaultGraph has been added
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.Registry
	 * @param newValue the object representing the new value
	 */	
	public void defaultGraphAdded(org.openanzo.ontologies.openanzo.Registry source, org.openanzo.ontologies.openanzo.NamedGraph newValue);

	/**
	 * Called when a value of defaultGraph has been removed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.Registry
	 * @param oldValue the object representing the removed value
	 */
	public void defaultGraphRemoved(org.openanzo.ontologies.openanzo.Registry source, org.openanzo.ontologies.openanzo.NamedGraph oldValue);
		
	/**
	 * Called when a value of defaultNamedGraph has been added
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.Registry
	 * @param newValue the object representing the new value
	 */	
	public void defaultNamedGraphAdded(org.openanzo.ontologies.openanzo.Registry source, org.openanzo.ontologies.openanzo.NamedGraph newValue);

	/**
	 * Called when a value of defaultNamedGraph has been removed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.Registry
	 * @param oldValue the object representing the removed value
	 */
	public void defaultNamedGraphRemoved(org.openanzo.ontologies.openanzo.Registry source, org.openanzo.ontologies.openanzo.NamedGraph oldValue);
		
	/**
	 * Called when a value of namedGraph has been added
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.Registry
	 * @param newValue the object representing the new value
	 */	
	public void namedGraphAdded(org.openanzo.ontologies.openanzo.Registry source, org.openanzo.ontologies.openanzo.NamedGraph newValue);

	/**
	 * Called when a value of namedGraph has been removed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.Registry
	 * @param oldValue the object representing the removed value
	 */
	public void namedGraphRemoved(org.openanzo.ontologies.openanzo.Registry source, org.openanzo.ontologies.openanzo.NamedGraph oldValue);
		
	/**
	 * Called when registeredType has changed
	 * @param source the affected instance of org.openanzo.ontologies.openanzo.Registry
	 */
	public void registeredTypeChanged(org.openanzo.ontologies.openanzo.Registry source);

}