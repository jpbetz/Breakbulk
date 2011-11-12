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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.Operation to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface OperationListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when name has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void nameChanged(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when bypassPool has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void bypassPoolChanged(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when restEndpoint has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void restEndpointChanged(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when restType has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void restTypeChanged(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when sysadminRequired has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void sysadminRequiredChanged(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when wsOperation has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void wsOperationChanged(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when a value of requestParameter has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 * @param newValue the object representing the new value
	 */	
	public void requestParameterAdded(org.openanzo.ontologies.system.Operation source, org.openanzo.ontologies.system.Parameter newValue);

	/**
	 * Called when a value of requestParameter has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 * @param oldValue the object representing the removed value
	 */
	public void requestParameterRemoved(org.openanzo.ontologies.system.Operation source, org.openanzo.ontologies.system.Parameter oldValue);
		
	/**
	 * Called when requestParameter0 has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void requestParameter0Changed(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when requestParameter1 has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void requestParameter1Changed(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when requestParameter2 has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void requestParameter2Changed(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when requestParameter3 has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void requestParameter3Changed(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when requestParameter4 has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void requestParameter4Changed(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when requestParameter5 has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void requestParameter5Changed(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when requestParameter6 has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void requestParameter6Changed(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when requestParameter7 has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 */
	public void requestParameter7Changed(org.openanzo.ontologies.system.Operation source);

	/**
	 * Called when a value of result has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 * @param newValue the object representing the new value
	 */	
	public void resultAdded(org.openanzo.ontologies.system.Operation source, org.openanzo.ontologies.system.Parameter newValue);

	/**
	 * Called when a value of result has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.Operation
	 * @param oldValue the object representing the removed value
	 */
	public void resultRemoved(org.openanzo.ontologies.system.Operation source, org.openanzo.ontologies.system.Parameter oldValue);
		
}