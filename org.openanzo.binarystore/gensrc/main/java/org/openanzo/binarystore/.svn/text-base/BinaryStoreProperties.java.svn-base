
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
package org.openanzo.binarystore;
import java.util.Properties;
/**
 *   Base configuration properties that are used by services if there aren't service specific values present.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class BinaryStoreProperties{
 	
	/**
	 * Key for property "org.openanzo.binarystore.serverNode"
	 * 
	 *
	 */
	public static final String	KEY_SERVERNODE	= "org.openanzo.binarystore.serverNode";
 	
	/**
	 * Key for property "org.openanzo.binarystore.fileSystemRoot"
	 * 
	 *
	 */
	public static final String	KEY_FILESYSTEM_ROOT	= "org.openanzo.binarystore.fileSystemRoot";
 	
	/**
	 * Key for property "org.openanzo.binarystore.progressUpdateFrequency"
	 * 
	 *
	 */
	public static final String	KEY_PROGRESS_UPDATE_FREQUENCY	= "org.openanzo.binarystore.progressUpdateFrequency";
 	
 	/**
	 * Get {@link #KEY_SERVERNODE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_SERVERNODE} if not present
	 */
	static public String getServerNode(Properties properties) {
		return properties.getProperty(KEY_SERVERNODE);
	}
	
	/**
	 * Set {@link #KEY_SERVERNODE} property to serverNode in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param serverNode
	 *            value for serverNode
	 */
	static public void setServerNode(Properties properties, String serverNode) {
		if(serverNode==null){
			properties.remove(KEY_SERVERNODE);
		}else{
			properties.setProperty(KEY_SERVERNODE, serverNode);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_FILESYSTEM_ROOT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_FILESYSTEM_ROOT} if not present
	 */
	static public String getFileSystemRoot(Properties properties) {
		return properties.getProperty(KEY_FILESYSTEM_ROOT);
	}
	
	/**
	 * Set {@link #KEY_FILESYSTEM_ROOT} property to fileSystemRoot in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param fileSystemRoot
	 *            value for fileSystemRoot
	 */
	static public void setFileSystemRoot(Properties properties, String fileSystemRoot) {
		if(fileSystemRoot==null){
			properties.remove(KEY_FILESYSTEM_ROOT);
		}else{
			properties.setProperty(KEY_FILESYSTEM_ROOT, fileSystemRoot);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_PROGRESS_UPDATE_FREQUENCY} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for progressUpdateFrequency
	 * @return value of {@link #KEY_PROGRESS_UPDATE_FREQUENCY}or defaultValue if not present
	 */
	static public long getProgressUpdateFrequency(Properties properties,long defaultValue) {
		long value= Long.parseLong(properties.getProperty(KEY_PROGRESS_UPDATE_FREQUENCY, ""+defaultValue));
		
		return value;		
	}

	/**
	 * Set {@link #KEY_PROGRESS_UPDATE_FREQUENCY} property to progressUpdateFrequency in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param progressUpdateFrequency
	 *           value for progressUpdateFrequency
	 */
	static public void setProgressUpdateFrequency(Properties properties, long progressUpdateFrequency) {
		
		properties.setProperty(KEY_PROGRESS_UPDATE_FREQUENCY, Long.toString(progressUpdateFrequency));
	}
 	
 	
 }
 	