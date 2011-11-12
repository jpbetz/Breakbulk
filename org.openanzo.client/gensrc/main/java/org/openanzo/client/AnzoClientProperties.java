
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
import java.util.Properties;
/**
 *   Configuration properties for the local client stack.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class AnzoClientProperties{
 	
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
	static public boolean getPersistenceEnabled(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_PERSISTENCE_ENABLED,""+false)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_PERSISTENCE_ENABLED} property to persistence.enabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param persistenceEnabled
	 *           value for persistence.enabled
	 */
	static public void setPersistenceEnabled(Properties properties, boolean persistenceEnabled) {
		properties.setProperty(KEY_PERSISTENCE_ENABLED, Boolean.toString(persistenceEnabled));
	}
 	
 	
 	/**
	 * Get {@link #KEY_QUADSTORE_SHARED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_QUADSTORE_SHARED},or "false"  if not present
	 */
	static public boolean getQuadstoreShared(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_QUADSTORE_SHARED,""+false)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_QUADSTORE_SHARED} property to quadstore.shared in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param quadstoreShared
	 *           value for quadstore.shared
	 */
	static public void setQuadstoreShared(Properties properties, boolean quadstoreShared) {
		properties.setProperty(KEY_QUADSTORE_SHARED, Boolean.toString(quadstoreShared));
	}
 	
 	
 }
 	