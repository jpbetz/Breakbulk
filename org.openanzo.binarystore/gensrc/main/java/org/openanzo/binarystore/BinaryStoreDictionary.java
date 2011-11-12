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
import java.util.Dictionary;
/**
 *   Base configuration properties that are used by services if there aren't service specific values present.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class BinaryStoreDictionary{
 	
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
	 @SuppressWarnings("unchecked")
	static public String getServerNode(Dictionary properties) {
		Object _prop = properties.get(KEY_SERVERNODE);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_SERVERNODE} property to serverNode in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param serverNode
	 *            value for serverNode
	 */
	 @SuppressWarnings("unchecked")
	static public void setServerNode(Dictionary properties, String serverNode) {
		if(serverNode==null){
			properties.remove(KEY_SERVERNODE);
		}else{
			properties.put(KEY_SERVERNODE, serverNode);
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
	 @SuppressWarnings("unchecked")
	static public String getFileSystemRoot(Dictionary properties) {
		Object _prop = properties.get(KEY_FILESYSTEM_ROOT);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_FILESYSTEM_ROOT} property to fileSystemRoot in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param fileSystemRoot
	 *            value for fileSystemRoot
	 */
	 @SuppressWarnings("unchecked")
	static public void setFileSystemRoot(Dictionary properties, String fileSystemRoot) {
		if(fileSystemRoot==null){
			properties.remove(KEY_FILESYSTEM_ROOT);
		}else{
			properties.put(KEY_FILESYSTEM_ROOT, fileSystemRoot);
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
	 @SuppressWarnings("unchecked")
	static public Long getProgressUpdateFrequency(Dictionary properties,Long defaultValue) {
		Object _prop= properties.get(KEY_PROGRESS_UPDATE_FREQUENCY);
		
		
		Long value= (_prop!=null)?Long.valueOf(_prop.toString()):defaultValue;
		
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
	 @SuppressWarnings("unchecked")
	static public void setProgressUpdateFrequency(Dictionary properties, Long progressUpdateFrequency) {
		if(progressUpdateFrequency==null){
			properties.remove(KEY_PROGRESS_UPDATE_FREQUENCY);
		}else{
		properties.put(KEY_PROGRESS_UPDATE_FREQUENCY, Long.toString(progressUpdateFrequency));
		}
	}
 	
 	
 }
 	