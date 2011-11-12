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
package org.openanzo.ontologies.system;

/**
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.DatasourceCapability to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface DatasourceCapabilityListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when a value of capabilityService has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.DatasourceCapability
	 * @param newValue the object representing the new value
	 */	
	public void capabilityServiceAdded(org.openanzo.ontologies.system.DatasourceCapability source, org.openanzo.ontologies.system.Service newValue);

	/**
	 * Called when a value of capabilityService has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.DatasourceCapability
	 * @param oldValue the object representing the removed value
	 */
	public void capabilityServiceRemoved(org.openanzo.ontologies.system.DatasourceCapability source, org.openanzo.ontologies.system.Service oldValue);
		
}