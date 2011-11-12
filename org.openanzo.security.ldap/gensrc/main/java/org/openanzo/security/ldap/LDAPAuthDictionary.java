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
package org.openanzo.security.ldap;
import java.util.Dictionary;
/**
 *   Base configuration properties that are used by ldap authentication provider.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class LDAPAuthDictionary{
 	
	/**
	 * Key for property "org.openanzo.security.ldap.userBaseDN"
	 * BaseDN for User search.
	 *
	 */
	public static final String	KEY_USER_BASE_DN	= "org.openanzo.security.ldap.userBaseDN";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.roleBaseDN"
	 * BaseDN for Role search.
	 *
	 */
	public static final String	KEY_ROLE_BASE_DN	= "org.openanzo.security.ldap.roleBaseDN";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.dnToUriTemplate"
	 * Template for converting dn to URI.
	 *
	 */
	public static final String	KEY_DN_TO_URI	= "org.openanzo.security.ldap.dnToUriTemplate";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.rolesSearch"
	 * Roles search template.
	 *
	 */
	public static final String	KEY_ROLE_SEARCH	= "org.openanzo.security.ldap.rolesSearch";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.roleObjectClass"
	 * Role class.
	 *
	 */
	public static final String	KEY_ROLE_OBJECT_CLASS	= "org.openanzo.security.ldap.roleObjectClass";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.userObjectClass"
	 * User class.
	 *
	 */
	public static final String	KEY_USER_OBJECT_CLASS	= "org.openanzo.security.ldap.userObjectClass";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.roleSearchFilter"
	 * Ldap filter to filter user search results eg objectClass=group
	 *
	 */
	public static final String	KEY_ROLE_SEARCH_FILTER	= "org.openanzo.security.ldap.roleSearchFilter";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.userSearchFilter"
	 * Ldap filter to filter user search results eg objectClass=person
	 *
	 */
	public static final String	KEY_USER_SEARCH_FILTER	= "org.openanzo.security.ldap.userSearchFilter";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.userSearch"
	 * Users search template.
	 *
	 */
	public static final String	KEY_USER_SEARCH	= "org.openanzo.security.ldap.userSearch";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.userIdAttribute"
	 * User ID attribute.
	 *
	 */
	public static final String	KEY_USER_ID	= "org.openanzo.security.ldap.userIdAttribute";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.sysadminRole"
	 * Sysadmin Role.
	 *
	 */
	public static final String	KEY_SYSADMIN	= "org.openanzo.security.ldap.sysadminRole";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.useEmbeddedServer"
	 * Connect to embedded server.
	 *
	 */
	public static final String	KEY_USE_EMBEDDED	= "org.openanzo.security.ldap.useEmbeddedServer";
 	
	/**
	 * Key for property "org.openanzo.security.ldap.anonymousAccessEnabled"
	 * Anonymous access enabled.
	 *
	 */
	public static final String	KEY_ANONYMOUS_ACCESS_ENABLED	= "org.openanzo.security.ldap.anonymousAccessEnabled";
 	
 	/**
	 * Get {@link #KEY_USER_BASE_DN} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_USER_BASE_DN} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUserBaseDN(Dictionary properties) {
		Object _prop = properties.get(KEY_USER_BASE_DN);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_USER_BASE_DN} property to userBaseDN in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userBaseDN
	 *            value for userBaseDN
	 */
	 @SuppressWarnings("unchecked")
	static public void setUserBaseDN(Dictionary properties, String userBaseDN) {
		if(userBaseDN==null){
			properties.remove(KEY_USER_BASE_DN);
		}else{
			properties.put(KEY_USER_BASE_DN, userBaseDN);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_ROLE_BASE_DN} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_ROLE_BASE_DN} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getRoleBaseDN(Dictionary properties) {
		Object _prop = properties.get(KEY_ROLE_BASE_DN);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_ROLE_BASE_DN} property to roleBaseDN in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param roleBaseDN
	 *            value for roleBaseDN
	 */
	 @SuppressWarnings("unchecked")
	static public void setRoleBaseDN(Dictionary properties, String roleBaseDN) {
		if(roleBaseDN==null){
			properties.remove(KEY_ROLE_BASE_DN);
		}else{
			properties.put(KEY_ROLE_BASE_DN, roleBaseDN);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DN_TO_URI} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DN_TO_URI} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getDnToUriTemplate(Dictionary properties) {
		Object _prop = properties.get(KEY_DN_TO_URI);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_DN_TO_URI} property to dnToUriTemplate in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param dnToUriTemplate
	 *            value for dnToUriTemplate
	 */
	 @SuppressWarnings("unchecked")
	static public void setDnToUriTemplate(Dictionary properties, String dnToUriTemplate) {
		if(dnToUriTemplate==null){
			properties.remove(KEY_DN_TO_URI);
		}else{
			properties.put(KEY_DN_TO_URI, dnToUriTemplate);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_ROLE_SEARCH} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_ROLE_SEARCH} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getRolesSearch(Dictionary properties) {
		Object _prop = properties.get(KEY_ROLE_SEARCH);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_ROLE_SEARCH} property to rolesSearch in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param rolesSearch
	 *            value for rolesSearch
	 */
	 @SuppressWarnings("unchecked")
	static public void setRolesSearch(Dictionary properties, String rolesSearch) {
		if(rolesSearch==null){
			properties.remove(KEY_ROLE_SEARCH);
		}else{
			properties.put(KEY_ROLE_SEARCH, rolesSearch);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_ROLE_OBJECT_CLASS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_ROLE_OBJECT_CLASS} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getRoleObjectClass(Dictionary properties) {
		Object _prop = properties.get(KEY_ROLE_OBJECT_CLASS);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_ROLE_OBJECT_CLASS} property to roleObjectClass in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param roleObjectClass
	 *            value for roleObjectClass
	 */
	 @SuppressWarnings("unchecked")
	static public void setRoleObjectClass(Dictionary properties, String roleObjectClass) {
		if(roleObjectClass==null){
			properties.remove(KEY_ROLE_OBJECT_CLASS);
		}else{
			properties.put(KEY_ROLE_OBJECT_CLASS, roleObjectClass);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_USER_OBJECT_CLASS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_USER_OBJECT_CLASS} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUserObjectClass(Dictionary properties) {
		Object _prop = properties.get(KEY_USER_OBJECT_CLASS);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_USER_OBJECT_CLASS} property to userObjectClass in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userObjectClass
	 *            value for userObjectClass
	 */
	 @SuppressWarnings("unchecked")
	static public void setUserObjectClass(Dictionary properties, String userObjectClass) {
		if(userObjectClass==null){
			properties.remove(KEY_USER_OBJECT_CLASS);
		}else{
			properties.put(KEY_USER_OBJECT_CLASS, userObjectClass);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_ROLE_SEARCH_FILTER} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_ROLE_SEARCH_FILTER} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getRoleSearchFilter(Dictionary properties) {
		Object _prop = properties.get(KEY_ROLE_SEARCH_FILTER);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_ROLE_SEARCH_FILTER} property to roleSearchFilter in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param roleSearchFilter
	 *            value for roleSearchFilter
	 */
	 @SuppressWarnings("unchecked")
	static public void setRoleSearchFilter(Dictionary properties, String roleSearchFilter) {
		if(roleSearchFilter==null){
			properties.remove(KEY_ROLE_SEARCH_FILTER);
		}else{
			properties.put(KEY_ROLE_SEARCH_FILTER, roleSearchFilter);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_USER_SEARCH_FILTER} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_USER_SEARCH_FILTER} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUserSearchFilter(Dictionary properties) {
		Object _prop = properties.get(KEY_USER_SEARCH_FILTER);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_USER_SEARCH_FILTER} property to userSearchFilter in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userSearchFilter
	 *            value for userSearchFilter
	 */
	 @SuppressWarnings("unchecked")
	static public void setUserSearchFilter(Dictionary properties, String userSearchFilter) {
		if(userSearchFilter==null){
			properties.remove(KEY_USER_SEARCH_FILTER);
		}else{
			properties.put(KEY_USER_SEARCH_FILTER, userSearchFilter);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_USER_SEARCH} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_USER_SEARCH} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUserSearch(Dictionary properties) {
		Object _prop = properties.get(KEY_USER_SEARCH);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_USER_SEARCH} property to userSearch in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userSearch
	 *            value for userSearch
	 */
	 @SuppressWarnings("unchecked")
	static public void setUserSearch(Dictionary properties, String userSearch) {
		if(userSearch==null){
			properties.remove(KEY_USER_SEARCH);
		}else{
			properties.put(KEY_USER_SEARCH, userSearch);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_USER_ID} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_USER_ID} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getUserIdAttribute(Dictionary properties) {
		Object _prop = properties.get(KEY_USER_ID);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_USER_ID} property to userIdAttribute in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userIdAttribute
	 *            value for userIdAttribute
	 */
	 @SuppressWarnings("unchecked")
	static public void setUserIdAttribute(Dictionary properties, String userIdAttribute) {
		if(userIdAttribute==null){
			properties.remove(KEY_USER_ID);
		}else{
			properties.put(KEY_USER_ID, userIdAttribute);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_SYSADMIN} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_SYSADMIN} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getSysadminRole(Dictionary properties) {
		Object _prop = properties.get(KEY_SYSADMIN);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_SYSADMIN} property to sysadminRole in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param sysadminRole
	 *            value for sysadminRole
	 */
	 @SuppressWarnings("unchecked")
	static public void setSysadminRole(Dictionary properties, String sysadminRole) {
		if(sysadminRole==null){
			properties.remove(KEY_SYSADMIN);
		}else{
			properties.put(KEY_SYSADMIN, sysadminRole);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_USE_EMBEDDED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_USE_EMBEDDED},or "true"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getUseEmbeddedServer(Dictionary properties) {
		Object _prop=properties.get(KEY_USE_EMBEDDED);
		if(_prop==null){
			_prop=Boolean.valueOf(true);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_USE_EMBEDDED} property to useEmbeddedServer in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param useEmbeddedServer
	 *           value for useEmbeddedServer
	 */
	 @SuppressWarnings("unchecked")
	static public void setUseEmbeddedServer(Dictionary properties, Boolean useEmbeddedServer) {
		if(useEmbeddedServer==null){
			properties.remove(KEY_USE_EMBEDDED);
		}else{
			properties.put(KEY_USE_EMBEDDED, useEmbeddedServer.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_ANONYMOUS_ACCESS_ENABLED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_ANONYMOUS_ACCESS_ENABLED},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getAnonymousAccessEnabled(Dictionary properties) {
		Object _prop=properties.get(KEY_ANONYMOUS_ACCESS_ENABLED);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_ANONYMOUS_ACCESS_ENABLED} property to anonymousAccessEnabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param anonymousAccessEnabled
	 *           value for anonymousAccessEnabled
	 */
	 @SuppressWarnings("unchecked")
	static public void setAnonymousAccessEnabled(Dictionary properties, Boolean anonymousAccessEnabled) {
		if(anonymousAccessEnabled==null){
			properties.remove(KEY_ANONYMOUS_ACCESS_ENABLED);
		}else{
			properties.put(KEY_ANONYMOUS_ACCESS_ENABLED, anonymousAccessEnabled.toString());
		}
	}
 	
 	
 }
 	