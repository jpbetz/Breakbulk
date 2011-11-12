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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.Type to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface TypeListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when javaType has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 */
	public void javaTypeChanged(org.openanzo.ontologies.system.Type source);

	/**
	 * Called when name has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 */
	public void nameChanged(org.openanzo.ontologies.system.Type source);

	/**
	 * Called when defaultValue has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 */
	public void defaultValueChanged(org.openanzo.ontologies.system.Type source);

	/**
	 * Called when javaTransportType has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 */
	public void javaTransportTypeChanged(org.openanzo.ontologies.system.Type source);

	/**
	 * Called when serializer has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 */
	public void serializerChanged(org.openanzo.ontologies.system.Type source);

	/**
	 * Called when defaultJMSFormat has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 */
	public void defaultJMSFormatChanged(org.openanzo.ontologies.system.Type source);

	/**
	 * Called when defaultRestFormat has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 */
	public void defaultRestFormatChanged(org.openanzo.ontologies.system.Type source);

	/**
	 * Called when defaultWSFormat has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 */
	public void defaultWSFormatChanged(org.openanzo.ontologies.system.Type source);

	/**
	 * Called when a value of validFormat has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 * @param newValue the object representing the new value
	 */	
	public void validFormatAdded(org.openanzo.ontologies.system.Type source, org.openanzo.ontologies.system.Format newValue);

	/**
	 * Called when a value of validFormat has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.Type
	 * @param oldValue the object representing the removed value
	 */
	public void validFormatRemoved(org.openanzo.ontologies.system.Type source, org.openanzo.ontologies.system.Format oldValue);
		
}