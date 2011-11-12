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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.HttpConfiguration to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface HttpConfigurationListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when credentials has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.HttpConfiguration
	 */
	public void credentialsChanged(org.openanzo.ontologies.system.HttpConfiguration source);

	/**
	 * Called when className has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.HttpConfiguration
	 */
	public void classNameChanged(org.openanzo.ontologies.system.HttpConfiguration source);

	/**
	 * Called when enabled has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.HttpConfiguration
	 */
	public void enabledChanged(org.openanzo.ontologies.system.HttpConfiguration source);

	/**
	 * Called when initOrder has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.HttpConfiguration
	 */
	public void initOrderChanged(org.openanzo.ontologies.system.HttpConfiguration source);

	/**
	 * Called when a value of dependency has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.HttpConfiguration
	 * @param newValue the object representing the new value
	 */	
	public void dependencyAdded(org.openanzo.ontologies.system.HttpConfiguration source, org.openanzo.ontologies.system.Component newValue);

	/**
	 * Called when a value of dependency has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.HttpConfiguration
	 * @param oldValue the object representing the removed value
	 */
	public void dependencyRemoved(org.openanzo.ontologies.system.HttpConfiguration source, org.openanzo.ontologies.system.Component oldValue);
		
	/**
	 * Called when networkTimeout has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.HttpConfiguration
	 */
	public void networkTimeoutChanged(org.openanzo.ontologies.system.HttpConfiguration source);

	/**
	 * Called when connection has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.HttpConfiguration
	 */
	public void connectionChanged(org.openanzo.ontologies.system.HttpConfiguration source);

}