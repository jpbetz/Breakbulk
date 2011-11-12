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
 *   Base configuration properties that are used by ldap authentication provider.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class LDAPDictionary{
 	
	/**
	 * Key for property "org.openanzo.ldap.host"
	 * Host name for server
	 *
	 * Examples:
	 * localhost or 127.0.0.1
	 */
	public static final String	KEY_LDAP_HOST	= "org.openanzo.ldap.host";
 	
	/**
	 * Key for property "org.openanzo.ldap.port"
	 * Port for server
	 *
	 * Examples:
	 * 10389
	 */
	public static final String	KEY_LDAP_PORT	= "org.openanzo.ldap.port";
 	
	/**
	 * Key for property "org.openanzo.ldap.useSSL"
	 * Use SSL for connection
	 *
	 */
	public static final String	KEY_LDAP_USE_SSL	= "org.openanzo.ldap.useSSL";
 	
	/**
	 * Key for property "org.openanzo.ldap.id"
	 * LDAP Server ID
	 *
	 */
	public static final String	KEY_LDAP_ID	= "org.openanzo.ldap.id";
 	
	/**
	 * Key for property "org.openanzo.ldap.suffix"
	 * LDAP Server Suffix
	 *
	 */
	public static final String	KEY_LDAP_SUFFIX	= "org.openanzo.ldap.suffix";
 	
	/**
	 * Key for property "org.openanzo.ldap.organization"
	 * LDAP Server Organization
	 *
	 */
	public static final String	KEY_LDAP_ORGANIZATION	= "org.openanzo.ldap.organization";
 	
	/**
	 * Key for property "org.openanzo.ldap.initFile"
	 * LDAP ldif file
	 *
	 */
	public static final String	KEY_LDAP_INIT_FILE	= "org.openanzo.ldap.initFile";
 	
	/**
	 * Key for property "org.openanzo.ldap.searchBaseDN"
	 * BaseDN for search.
	 *
	 */
	public static final String	KEY_USER_BASE_DN	= "org.openanzo.ldap.searchBaseDN";
 	
	/**
	 * Key for property "org.openanzo.ldap.ldapServerUser"
	 * Ldap Server User.
	 *
	 */
	public static final String	KEY_LDAP_USER	= "org.openanzo.ldap.ldapServerUser";
 	
	/**
	 * Key for property "org.openanzo.ldap.ldapServerPassword"
	 * Ldap Server Password.
	 *
	 */
	public static final String	KEY_LDAP_PASSWORD	= "org.openanzo.ldap.ldapServerPassword";
 	
 	/**
	 * Get {@link #KEY_LDAP_HOST} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for host
	 * @return value of {@link #KEY_LDAP_HOST}or defaultValue if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getHost(Dictionary properties,String defaultValue) {
		Object _prop = properties.get(KEY_LDAP_HOST);
		
		
		if(_prop==null){
			return defaultValue;
		}else{
			return _prop.toString();
		}
		
	}
	
	/**
	 * Set {@link #KEY_LDAP_HOST} property to host in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param host
	 *            value for host
	 */
	 @SuppressWarnings("unchecked")
	static public void setHost(Dictionary properties, String host) {
		if(host==null){
			properties.remove(KEY_LDAP_HOST);
		}else{
			properties.put(KEY_LDAP_HOST, host);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LDAP_PORT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for port
	 * @return value of {@link #KEY_LDAP_PORT}or defaultValue if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Integer getPort(Dictionary properties,Integer defaultValue) {
		Object _prop= properties.get(KEY_LDAP_PORT);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):defaultValue;
		if(value!=null&&value <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"port","1");
		if(value!=null&&value >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"port","65536");
		return value;
	}

	/**
	 * Set {@link #KEY_LDAP_PORT} property to port in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param port
	 *           value for port
	 */
	 @SuppressWarnings("unchecked")
	static public void setPort(Dictionary properties, Integer port) {
		if(port==null){
			properties.remove(KEY_LDAP_PORT);
		}else{
		if(port <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"port","1");
		if(port >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"port","65536");
		properties.put(KEY_LDAP_PORT, Integer.toString(port));
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LDAP_USE_SSL} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LDAP_USE_SSL}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getUseSSL(Dictionary properties) {
		Object _prop=properties.get(KEY_LDAP_USE_SSL);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_LDAP_USE_SSL} property to useSSL in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param useSSL
	 *           value for useSSL
	 */
	 @SuppressWarnings("unchecked")
	static public void setUseSSL(Dictionary properties, Boolean useSSL) {
		if(useSSL==null){
			properties.remove(KEY_LDAP_USE_SSL);
		}else{
			properties.put(KEY_LDAP_USE_SSL, useSSL.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LDAP_ID} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LDAP_ID} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getId(Dictionary properties) {
		Object _prop = properties.get(KEY_LDAP_ID);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_LDAP_ID} property to id in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param id
	 *            value for id
	 */
	 @SuppressWarnings("unchecked")
	static public void setId(Dictionary properties, String id) {
		if(id==null){
			properties.remove(KEY_LDAP_ID);
		}else{
			properties.put(KEY_LDAP_ID, id);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LDAP_SUFFIX} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LDAP_SUFFIX} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getSuffix(Dictionary properties) {
		Object _prop = properties.get(KEY_LDAP_SUFFIX);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_LDAP_SUFFIX} property to suffix in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param suffix
	 *            value for suffix
	 */
	 @SuppressWarnings("unchecked")
	static public void setSuffix(Dictionary properties, String suffix) {
		if(suffix==null){
			properties.remove(KEY_LDAP_SUFFIX);
		}else{
			properties.put(KEY_LDAP_SUFFIX, suffix);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LDAP_ORGANIZATION} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LDAP_ORGANIZATION} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getOrganization(Dictionary properties) {
		Object _prop = properties.get(KEY_LDAP_ORGANIZATION);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_LDAP_ORGANIZATION} property to organization in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param organization
	 *            value for organization
	 */
	 @SuppressWarnings("unchecked")
	static public void setOrganization(Dictionary properties, String organization) {
		if(organization==null){
			properties.remove(KEY_LDAP_ORGANIZATION);
		}else{
			properties.put(KEY_LDAP_ORGANIZATION, organization);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LDAP_INIT_FILE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LDAP_INIT_FILE} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getInitFile(Dictionary properties) {
		Object _prop = properties.get(KEY_LDAP_INIT_FILE);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_LDAP_INIT_FILE} property to initFile in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param initFile
	 *            value for initFile
	 */
	 @SuppressWarnings("unchecked")
	static public void setInitFile(Dictionary properties, String initFile) {
		if(initFile==null){
			properties.remove(KEY_LDAP_INIT_FILE);
		}else{
			properties.put(KEY_LDAP_INIT_FILE, initFile);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_USER_BASE_DN} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_USER_BASE_DN} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getSearchBaseDN(Dictionary properties) {
		Object _prop = properties.get(KEY_USER_BASE_DN);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_USER_BASE_DN} property to searchBaseDN in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param searchBaseDN
	 *            value for searchBaseDN
	 */
	 @SuppressWarnings("unchecked")
	static public void setSearchBaseDN(Dictionary properties, String searchBaseDN) {
		if(searchBaseDN==null){
			properties.remove(KEY_USER_BASE_DN);
		}else{
			properties.put(KEY_USER_BASE_DN, searchBaseDN);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LDAP_USER} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LDAP_USER} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getLdapServerUser(Dictionary properties) {
		Object _prop = properties.get(KEY_LDAP_USER);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_LDAP_USER} property to ldapServerUser in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param ldapServerUser
	 *            value for ldapServerUser
	 */
	 @SuppressWarnings("unchecked")
	static public void setLdapServerUser(Dictionary properties, String ldapServerUser) {
		if(ldapServerUser==null){
			properties.remove(KEY_LDAP_USER);
		}else{
			properties.put(KEY_LDAP_USER, ldapServerUser);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LDAP_PASSWORD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LDAP_PASSWORD} if not present
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception decrypting value
	 */
	  @SuppressWarnings("unchecked")
	static public String getLdapServerPassword(Dictionary properties) throws org.openanzo.exceptions.AnzoException{
		try{
		Object _prop = properties.get(KEY_LDAP_PASSWORD);
		
			
		if(_prop==null){
			return null;
		}else if(_prop.toString().startsWith("encrypted:")){
			_prop=_prop.toString().substring("encrypted:".length());
			if(_prop.toString().length()>0){
				return org.openanzo.exceptions.EncryptionUtil.decryptBase64(_prop.toString());
			}else{
				return _prop.toString();
			}
		}else{
			return _prop.toString();
		}
		
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
	
	/**
	 * Set {@link #KEY_LDAP_PASSWORD} property to ldapServerPassword in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param ldapServerPassword
	 *            value for ldapServerPassword
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception encrypting value
	 */
	  @SuppressWarnings("unchecked")
	static public void setLdapServerPassword(Dictionary properties, String ldapServerPassword) throws org.openanzo.exceptions.AnzoException {
		try{
			if(ldapServerPassword==null){
				properties.remove(KEY_LDAP_PASSWORD);
			}else{
				ldapServerPassword="encrypted:"+org.openanzo.exceptions.EncryptionUtil.encryptBase64(ldapServerPassword);
				properties.put(KEY_LDAP_PASSWORD,ldapServerPassword);
			}
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
 	
 	
 }
 	