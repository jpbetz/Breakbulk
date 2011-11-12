
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
package org.openanzo.services;
import java.util.Properties;
/**
 *   Base configuration properties that are used by services if there aren't service specific values present.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class ServicesProperties{
 	
	/**
	 * Key for property "org.openanzo.services.enabled"
	 * Should service be enabled
	 *
	 */
	public static final String	KEY_SERVICE_ENABLED	= "org.openanzo.services.enabled";
 	
	/**
	 * Key for property "org.openanzo.services.user"
	 * Login id for server
	 * <li><b>Server:</b>The login id used by server services to talk to other services.</li>
	 * <li><b>Client:</b>The login id for connecting to the server</li>
	 * <li><b>Embedded:</b>The login id under which all commands are run as.</li>
	 *
	 * Examples:
	 * default
	 */
	public static final String	KEY_SERVICE_USER	= "org.openanzo.services.user";
 	
	/**
	 * Key for property "org.openanzo.services.password"
	 * Password for server
	 * <li><b>Server:</b>The password used by server services to talk to other services.</li>
	 * <li><b>Client:</b>The password for connecting to the server</li>
	 * <li><b>Embedded:</b>The password under which all commands are authenticated.</li>
	 *
	 * Examples:
	 * 123
	 */
	public static final String	KEY_SERVICE_PASSWORD	= "org.openanzo.services.password";
 	
	/**
	 * Key for property "org.openanzo.services.timeout"
	 * Timeout in milliseconds for transport calls
	 * <li><b>Server:</b>When making calls to services, the time to wait on a transport to get a response before reporting a timeout error.</li>
	 * <li><b>Client:</b>When making calls to services, the time to wait on a transport to get a response before reporting a timeout error.</li>
	 * <li><b>Embedded:</b>Not Used</li>
	 *
	 * Examples:
	 * 0=Never timeout, 60000=Timeout in 1 minute
	 */
	public static final String	KEY_SERVICE_TIMEOUT	= "org.openanzo.services.timeout";
 	
	/**
	 * Key for property "org.openanzo.services.initializationFiles"
	 * Configuration file for service.
	 *
	 */
	public static final String	KEY_SERVICE_INITIALIZATION_FILES	= "org.openanzo.services.initializationFiles";
 	
	/**
	 * Key for property "org.openanzo.services.instanceURI"
	 * URI of instance
	 *
	 */
	public static final String	KEY_INSTANCE_URI	= "org.openanzo.services.instanceURI";
 	
	/**
	 * Key for property "org.openanzo.services.requireSSL"
	 * Require SSL for all connections
	 *
	 */
	public static final String	KEY_REQUIRE_SSL	= "org.openanzo.services.requireSSL";
 	
 	/**
	 * Get {@link #KEY_SERVICE_ENABLED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_SERVICE_ENABLED},or "true"  if not present
	 */
	static public boolean getEnabled(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_SERVICE_ENABLED,""+true)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_SERVICE_ENABLED} property to enabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param enabled
	 *           value for enabled
	 */
	static public void setEnabled(Properties properties, boolean enabled) {
		properties.setProperty(KEY_SERVICE_ENABLED, Boolean.toString(enabled));
	}
 	
 	
 	/**
	 * Get {@link #KEY_SERVICE_USER} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for user
	 * @return value of {@link #KEY_SERVICE_USER}or defaultValue if not present
	 */
	static public String getUser(Properties properties,String defaultValue) {
		return properties.getProperty(KEY_SERVICE_USER,defaultValue);
	}
	
	/**
	 * Set {@link #KEY_SERVICE_USER} property to user in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param user
	 *            value for user
	 */
	static public void setUser(Properties properties, String user) {
		if(user==null){
			properties.remove(KEY_SERVICE_USER);
		}else{
			properties.setProperty(KEY_SERVICE_USER, user);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_SERVICE_PASSWORD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for password
	 * @return value of {@link #KEY_SERVICE_PASSWORD}or defaultValue if not present
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception decrypting value
	 */
	static public String getPassword(Properties properties,String defaultValue)  throws org.openanzo.exceptions.AnzoException{
		try{
		String result= properties.getProperty(KEY_SERVICE_PASSWORD
		);
		
		if(result==null){
			result=defaultValue;
		}else{
			if(result.startsWith("encrypted:")){
				result=result.substring("encrypted:".length());
				if(result.length()>0){
					result=org.openanzo.exceptions.EncryptionUtil.decryptBase64(result);
				}
			}
		}
		
		return result;
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
	
	/**
	 * Set {@link #KEY_SERVICE_PASSWORD} property to password in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param password
	 *            value for password
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception encrypting value
	 */
	static public void setPassword(Properties properties, String password)  throws org.openanzo.exceptions.AnzoException{
		try{if(password==null){
			properties.remove(KEY_SERVICE_PASSWORD);
		}else{
			password=org.openanzo.exceptions.EncryptionUtil.encryptBase64(password);
			properties.setProperty(KEY_SERVICE_PASSWORD, "encrypted:"+password);
		}
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_SERVICE_TIMEOUT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for timeout
	 * @return value of {@link #KEY_SERVICE_TIMEOUT}or defaultValue if not present
	 */
	static public int getTimeout(Properties properties,int defaultValue) {
		int value= Integer.parseInt(properties.getProperty(KEY_SERVICE_TIMEOUT,""+defaultValue));
		
		return value;
	}

	/**
	 * Set {@link #KEY_SERVICE_TIMEOUT} property to timeout in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param timeout
	 *           value for timeout
	 */
	static public void setTimeout(Properties properties, int timeout) {
		
		properties.setProperty(KEY_SERVICE_TIMEOUT, Integer.toString(timeout));
	}
 	
 	
 	/**
	 * Get {@link #KEY_SERVICE_INITIALIZATION_FILES} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_SERVICE_INITIALIZATION_FILES} if not present
	 */
	static public String getInitializationFiles(Properties properties) {
		return properties.getProperty(KEY_SERVICE_INITIALIZATION_FILES);
	}
	
	/**
	 * Set {@link #KEY_SERVICE_INITIALIZATION_FILES} property to initializationFiles in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param initializationFiles
	 *            value for initializationFiles
	 */
	static public void setInitializationFiles(Properties properties, String initializationFiles) {
		if(initializationFiles==null){
			properties.remove(KEY_SERVICE_INITIALIZATION_FILES);
		}else{
			properties.setProperty(KEY_SERVICE_INITIALIZATION_FILES, initializationFiles);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_INSTANCE_URI} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_INSTANCE_URI} if not present
	 */
	static public String getInstanceURI(Properties properties) {
		return properties.getProperty(KEY_INSTANCE_URI);
	}
	
	/**
	 * Set {@link #KEY_INSTANCE_URI} property to instanceURI in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param instanceURI
	 *            value for instanceURI
	 */
	static public void setInstanceURI(Properties properties, String instanceURI) {
		if(instanceURI==null){
			properties.remove(KEY_INSTANCE_URI);
		}else{
			properties.setProperty(KEY_INSTANCE_URI, instanceURI);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_REQUIRE_SSL} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_REQUIRE_SSL},or "false"  if not present
	 */
	static public boolean getRequireSSL(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_REQUIRE_SSL,""+false)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_REQUIRE_SSL} property to requireSSL in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param requireSSL
	 *           value for requireSSL
	 */
	static public void setRequireSSL(Properties properties, boolean requireSSL) {
		properties.setProperty(KEY_REQUIRE_SSL, Boolean.toString(requireSSL));
	}
 	
 	
 }
 	