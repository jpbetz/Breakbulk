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
import java.util.Dictionary;
/**
 *   Base configuration properties that are used by services if there aren't service specific values present.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class ServicesDictionary{
 	
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
	 @SuppressWarnings("unchecked")
	static public Boolean getEnabled(Dictionary properties) {
		Object _prop=properties.get(KEY_SERVICE_ENABLED);
		if(_prop==null){
			_prop=Boolean.valueOf(true);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_SERVICE_ENABLED} property to enabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param enabled
	 *           value for enabled
	 */
	 @SuppressWarnings("unchecked")
	static public void setEnabled(Dictionary properties, Boolean enabled) {
		if(enabled==null){
			properties.remove(KEY_SERVICE_ENABLED);
		}else{
			properties.put(KEY_SERVICE_ENABLED, enabled.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_SERVICE_USER} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for user
	 * @return value of {@link #KEY_SERVICE_USER}or defaultValue if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUser(Dictionary properties,String defaultValue) {
		Object _prop = properties.get(KEY_SERVICE_USER);
		
		
		if(_prop==null){
			return defaultValue;
		}else{
			return _prop.toString();
		}
		
	}
	
	/**
	 * Set {@link #KEY_SERVICE_USER} property to user in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param user
	 *            value for user
	 */
	 @SuppressWarnings("unchecked")
	static public void setUser(Dictionary properties, String user) {
		if(user==null){
			properties.remove(KEY_SERVICE_USER);
		}else{
			properties.put(KEY_SERVICE_USER, user);
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
	  @SuppressWarnings("unchecked")
	static public String getPassword(Dictionary properties,String defaultValue) throws org.openanzo.exceptions.AnzoException{
		try{
		Object _prop = properties.get(KEY_SERVICE_PASSWORD);
		
		
		if(_prop==null){
			return defaultValue;
		}else{
			if(_prop.toString().startsWith("encrypted:")){
				_prop=_prop.toString().substring("encrypted:".length());
				if(_prop.toString().length()>0){
					return org.openanzo.exceptions.EncryptionUtil.decryptBase64(_prop.toString());
				}else{
					return _prop.toString();
				}
			}else{
				return _prop.toString();
			}
		}
		
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
	  @SuppressWarnings("unchecked")
	static public void setPassword(Dictionary properties, String password) throws org.openanzo.exceptions.AnzoException {
		try{
			if(password==null){
				properties.remove(KEY_SERVICE_PASSWORD);
			}else{
				password="encrypted:"+org.openanzo.exceptions.EncryptionUtil.encryptBase64(password);
				properties.put(KEY_SERVICE_PASSWORD,password);
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
	 @SuppressWarnings("unchecked")
	static public Integer getTimeout(Dictionary properties,Integer defaultValue) {
		Object _prop= properties.get(KEY_SERVICE_TIMEOUT);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):defaultValue;
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
	 @SuppressWarnings("unchecked")
	static public void setTimeout(Dictionary properties, Integer timeout) {
		if(timeout==null){
			properties.remove(KEY_SERVICE_TIMEOUT);
		}else{
		properties.put(KEY_SERVICE_TIMEOUT, Integer.toString(timeout));
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_SERVICE_INITIALIZATION_FILES} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_SERVICE_INITIALIZATION_FILES} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getInitializationFiles(Dictionary properties) {
		Object _prop = properties.get(KEY_SERVICE_INITIALIZATION_FILES);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_SERVICE_INITIALIZATION_FILES} property to initializationFiles in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param initializationFiles
	 *            value for initializationFiles
	 */
	 @SuppressWarnings("unchecked")
	static public void setInitializationFiles(Dictionary properties, String initializationFiles) {
		if(initializationFiles==null){
			properties.remove(KEY_SERVICE_INITIALIZATION_FILES);
		}else{
			properties.put(KEY_SERVICE_INITIALIZATION_FILES, initializationFiles);
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
	 @SuppressWarnings("unchecked")
	static public String getInstanceURI(Dictionary properties) {
		Object _prop = properties.get(KEY_INSTANCE_URI);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_INSTANCE_URI} property to instanceURI in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param instanceURI
	 *            value for instanceURI
	 */
	 @SuppressWarnings("unchecked")
	static public void setInstanceURI(Dictionary properties, String instanceURI) {
		if(instanceURI==null){
			properties.remove(KEY_INSTANCE_URI);
		}else{
			properties.put(KEY_INSTANCE_URI, instanceURI);
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
	 @SuppressWarnings("unchecked")
	static public Boolean getRequireSSL(Dictionary properties) {
		Object _prop=properties.get(KEY_REQUIRE_SSL);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_REQUIRE_SSL} property to requireSSL in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param requireSSL
	 *           value for requireSSL
	 */
	 @SuppressWarnings("unchecked")
	static public void setRequireSSL(Dictionary properties, Boolean requireSSL) {
		if(requireSSL==null){
			properties.remove(KEY_REQUIRE_SSL);
		}else{
			properties.put(KEY_REQUIRE_SSL, requireSSL.toString());
		}
	}
 	
 	
 }
 	