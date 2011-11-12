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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.AuthorizationRule to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface AuthorizationRuleListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when a value of uriPattern has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.AuthorizationRule
	 * @param newValue the object representing the new value
	 */	
	public void uriPatternAdded(org.openanzo.ontologies.system.AuthorizationRule source, java.lang.String newValue);

	/**
	 * Called when a value of uriPattern has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.AuthorizationRule
	 * @param oldValue the object representing the removed value
	 */	
	public void uriPatternRemoved(org.openanzo.ontologies.system.AuthorizationRule source, java.lang.String oldValue);

	/**
	 * Called when privilege has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.AuthorizationRule
	 */
	public void privilegeChanged(org.openanzo.ontologies.system.AuthorizationRule source);

	/**
	 * Called when a value of role has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.AuthorizationRule
	 * @param newValue the object representing the new value
	 */	
	public void roleAdded(org.openanzo.ontologies.system.AuthorizationRule source, org.openanzo.ontologies.openanzo.Role newValue);

	/**
	 * Called when a value of role has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.AuthorizationRule
	 * @param oldValue the object representing the removed value
	 */
	public void roleRemoved(org.openanzo.ontologies.system.AuthorizationRule source, org.openanzo.ontologies.openanzo.Role oldValue);
		
}