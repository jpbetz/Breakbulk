/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.rdf.utils.properties.jet
 * Created on:  Generated Source from org.openanzo.rdf.utils.properties.jet
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client;
import java.util.Dictionary;
/**
 *   Configuration properties for the local client stack.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class AnzoClientDictionary{
 	
	/**
	 * Key for property "org.openanzo.client.persistence.enabled"
	 * This determines if the data retrieved into the local cache and local transactions are persisted to disk
	 * If true, the client stack uses a relational database to store statements, as opposed to an in memory store if false.
	 *
	 */
	public static final String	KEY_PERSISTENCE_ENABLED	= "org.openanzo.client.persistence.enabled";
 	
	/**
	 * Key for property "org.openanzo.client.quadstore.shared"
	 * Is the quad store shared between multiple anzo clients created.
	 *
	 */
	public static final String	KEY_QUADSTORE_SHARED	= "org.openanzo.client.quadstore.shared";
 	
 	/**
	 * Get {@link #KEY_PERSISTENCE_ENABLED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_PERSISTENCE_ENABLED},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getPersistenceEnabled(Dictionary properties) {
		Object _prop=properties.get(KEY_PERSISTENCE_ENABLED);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_PERSISTENCE_ENABLED} property to persistence.enabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param persistenceEnabled
	 *           value for persistence.enabled
	 */
	 @SuppressWarnings("unchecked")
	static public void setPersistenceEnabled(Dictionary properties, Boolean persistenceEnabled) {
		if(persistenceEnabled==null){
			properties.remove(KEY_PERSISTENCE_ENABLED);
		}else{
			properties.put(KEY_PERSISTENCE_ENABLED, persistenceEnabled.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_QUADSTORE_SHARED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_QUADSTORE_SHARED},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getQuadstoreShared(Dictionary properties) {
		Object _prop=properties.get(KEY_QUADSTORE_SHARED);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_QUADSTORE_SHARED} property to quadstore.shared in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param quadstoreShared
	 *           value for quadstore.shared
	 */
	 @SuppressWarnings("unchecked")
	static public void setQuadstoreShared(Dictionary properties, Boolean quadstoreShared) {
		if(quadstoreShared==null){
			properties.remove(KEY_QUADSTORE_SHARED);
		}else{
			properties.put(KEY_QUADSTORE_SHARED, quadstoreShared.toString());
		}
	}
 	
 	
 }
 	