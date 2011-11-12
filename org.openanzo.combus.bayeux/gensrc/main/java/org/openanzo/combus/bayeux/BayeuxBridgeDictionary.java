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
package org.openanzo.combus.bayeux;
import java.util.Dictionary;
/**
 *   Bayeux Bridge Config Properties.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class BayeuxBridgeDictionary{
 	
	/**
	 * Key for property "org.openanzo.combus.bayeuxBridge.threadPoolSize"
	 * Max size of pool to handle bayeux to jms bridging
	 *
	 */
	public static final String	KEY_THREAD_POOL_SIZE	= "org.openanzo.combus.bayeuxBridge.threadPoolSize";
 	
 	/**
	 * Get {@link #KEY_THREAD_POOL_SIZE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_THREAD_POOL_SIZE} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Integer getThreadPoolSize(Dictionary properties) {
		Object _prop= properties.get(KEY_THREAD_POOL_SIZE);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):null;
		return value;
	}

	/**
	 * Set {@link #KEY_THREAD_POOL_SIZE} property to threadPoolSize in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param threadPoolSize
	 *           value for threadPoolSize
	 */
	 @SuppressWarnings("unchecked")
	static public void setThreadPoolSize(Dictionary properties, Integer threadPoolSize) {
		if(threadPoolSize==null){
			properties.remove(KEY_THREAD_POOL_SIZE);
		}else{
		properties.put(KEY_THREAD_POOL_SIZE, Integer.toString(threadPoolSize));
		}
	}
 	
 	
 }
 	