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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.Service to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface ServiceListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when credentials has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void credentialsChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when className has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void classNameChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when enabled has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void enabledChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when initOrder has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void initOrderChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when a value of dependency has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 * @param newValue the object representing the new value
	 */	
	public void dependencyAdded(org.openanzo.ontologies.system.Service source, org.openanzo.ontologies.system.Component newValue);

	/**
	 * Called when a value of dependency has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 * @param oldValue the object representing the removed value
	 */
	public void dependencyRemoved(org.openanzo.ontologies.system.Service source, org.openanzo.ontologies.system.Component oldValue);
		
	/**
	 * Called when name has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void nameChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when availableOverJms has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void availableOverJmsChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when availableOverRest has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void availableOverRestChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when availableOverWS has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void availableOverWSChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when _interface has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void _interfaceChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when isDatasourceService has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void isDatasourceServiceChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when jmsQueueName has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 */
	public void jmsQueueNameChanged(org.openanzo.ontologies.system.Service source);

	/**
	 * Called when a value of operation has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 * @param newValue the object representing the new value
	 */	
	public void operationAdded(org.openanzo.ontologies.system.Service source, org.openanzo.ontologies.system.Operation newValue);

	/**
	 * Called when a value of operation has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.Service
	 * @param oldValue the object representing the removed value
	 */
	public void operationRemoved(org.openanzo.ontologies.system.Service source, org.openanzo.ontologies.system.Operation oldValue);
		
}