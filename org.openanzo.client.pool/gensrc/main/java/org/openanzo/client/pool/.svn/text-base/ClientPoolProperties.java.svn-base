
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
package org.openanzo.client.pool;
import java.util.Properties;
/**
 *   Base configuration properties that are used by client pool provider.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class ClientPoolProperties{
 	
	/**
	 * Key for property "org.openanzo.client.pool.usesJms"
	 * Whether or not this pool's clients use JMS
	 *
	 */
	public static final String	KEY_USES_JMS	= "org.openanzo.client.pool.usesJms";
 	
	/**
	 * Key for property "org.openanzo.client.pool.maxClient"
	 * Maximum number of clients in the pool
	 *
	 */
	public static final String	KEY_MAX_CLIENTS	= "org.openanzo.client.pool.maxClient";
 	
	/**
	 * Key for property "org.openanzo.client.pool.minClient"
	 * Minimum number of idle clients in the pool
	 *
	 */
	public static final String	KEY_MIN_CLIENTS	= "org.openanzo.client.pool.minClient";
 	
 	/**
	 * Get {@link #KEY_USES_JMS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_USES_JMS},or "true"  if not present
	 */
	static public boolean getUsesJms(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_USES_JMS,""+true)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_USES_JMS} property to usesJms in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param usesJms
	 *           value for usesJms
	 */
	static public void setUsesJms(Properties properties, boolean usesJms) {
		properties.setProperty(KEY_USES_JMS, Boolean.toString(usesJms));
	}
 	
 	
 	/**
	 * Get {@link #KEY_MAX_CLIENTS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_MAX_CLIENTS},or "5"  if not present
	 */
	static public int getMaxClient(Properties properties) {
		int value= Integer.parseInt(properties.getProperty(KEY_MAX_CLIENTS,""+5));
		
		return value;
	}

	/**
	 * Set {@link #KEY_MAX_CLIENTS} property to maxClient in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param maxClient
	 *           value for maxClient
	 */
	static public void setMaxClient(Properties properties, int maxClient) {
		
		properties.setProperty(KEY_MAX_CLIENTS, Integer.toString(maxClient));
	}
 	
 	
 	/**
	 * Get {@link #KEY_MIN_CLIENTS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_MIN_CLIENTS},or "1"  if not present
	 */
	static public int getMinClient(Properties properties) {
		int value= Integer.parseInt(properties.getProperty(KEY_MIN_CLIENTS,""+1));
		
		return value;
	}

	/**
	 * Set {@link #KEY_MIN_CLIENTS} property to minClient in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param minClient
	 *           value for minClient
	 */
	static public void setMinClient(Properties properties, int minClient) {
		
		properties.setProperty(KEY_MIN_CLIENTS, Integer.toString(minClient));
	}
 	
 	
 }
 	