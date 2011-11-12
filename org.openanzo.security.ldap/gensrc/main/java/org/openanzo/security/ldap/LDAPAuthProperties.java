
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
import java.util.Properties;
/**
 *   Base configuration properties that are used by ldap authentication provider.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class LDAPAuthProperties{
 	
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
	static public String getUserBaseDN(Properties properties) {
		return properties.getProperty(KEY_USER_BASE_DN);
	}
	
	/**
	 * Set {@link #KEY_USER_BASE_DN} property to userBaseDN in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userBaseDN
	 *            value for userBaseDN
	 */
	static public void setUserBaseDN(Properties properties, String userBaseDN) {
		if(userBaseDN==null){
			properties.remove(KEY_USER_BASE_DN);
		}else{
			properties.setProperty(KEY_USER_BASE_DN, userBaseDN);
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
	static public String getRoleBaseDN(Properties properties) {
		return properties.getProperty(KEY_ROLE_BASE_DN);
	}
	
	/**
	 * Set {@link #KEY_ROLE_BASE_DN} property to roleBaseDN in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param roleBaseDN
	 *            value for roleBaseDN
	 */
	static public void setRoleBaseDN(Properties properties, String roleBaseDN) {
		if(roleBaseDN==null){
			properties.remove(KEY_ROLE_BASE_DN);
		}else{
			properties.setProperty(KEY_ROLE_BASE_DN, roleBaseDN);
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
	static public String getDnToUriTemplate(Properties properties) {
		return properties.getProperty(KEY_DN_TO_URI);
	}
	
	/**
	 * Set {@link #KEY_DN_TO_URI} property to dnToUriTemplate in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param dnToUriTemplate
	 *            value for dnToUriTemplate
	 */
	static public void setDnToUriTemplate(Properties properties, String dnToUriTemplate) {
		if(dnToUriTemplate==null){
			properties.remove(KEY_DN_TO_URI);
		}else{
			properties.setProperty(KEY_DN_TO_URI, dnToUriTemplate);
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
	static public String getRolesSearch(Properties properties) {
		return properties.getProperty(KEY_ROLE_SEARCH);
	}
	
	/**
	 * Set {@link #KEY_ROLE_SEARCH} property to rolesSearch in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param rolesSearch
	 *            value for rolesSearch
	 */
	static public void setRolesSearch(Properties properties, String rolesSearch) {
		if(rolesSearch==null){
			properties.remove(KEY_ROLE_SEARCH);
		}else{
			properties.setProperty(KEY_ROLE_SEARCH, rolesSearch);
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
	static public String getRoleObjectClass(Properties properties) {
		return properties.getProperty(KEY_ROLE_OBJECT_CLASS);
	}
	
	/**
	 * Set {@link #KEY_ROLE_OBJECT_CLASS} property to roleObjectClass in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param roleObjectClass
	 *            value for roleObjectClass
	 */
	static public void setRoleObjectClass(Properties properties, String roleObjectClass) {
		if(roleObjectClass==null){
			properties.remove(KEY_ROLE_OBJECT_CLASS);
		}else{
			properties.setProperty(KEY_ROLE_OBJECT_CLASS, roleObjectClass);
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
	static public String getUserObjectClass(Properties properties) {
		return properties.getProperty(KEY_USER_OBJECT_CLASS);
	}
	
	/**
	 * Set {@link #KEY_USER_OBJECT_CLASS} property to userObjectClass in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userObjectClass
	 *            value for userObjectClass
	 */
	static public void setUserObjectClass(Properties properties, String userObjectClass) {
		if(userObjectClass==null){
			properties.remove(KEY_USER_OBJECT_CLASS);
		}else{
			properties.setProperty(KEY_USER_OBJECT_CLASS, userObjectClass);
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
	static public String getRoleSearchFilter(Properties properties) {
		return properties.getProperty(KEY_ROLE_SEARCH_FILTER);
	}
	
	/**
	 * Set {@link #KEY_ROLE_SEARCH_FILTER} property to roleSearchFilter in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param roleSearchFilter
	 *            value for roleSearchFilter
	 */
	static public void setRoleSearchFilter(Properties properties, String roleSearchFilter) {
		if(roleSearchFilter==null){
			properties.remove(KEY_ROLE_SEARCH_FILTER);
		}else{
			properties.setProperty(KEY_ROLE_SEARCH_FILTER, roleSearchFilter);
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
	static public String getUserSearchFilter(Properties properties) {
		return properties.getProperty(KEY_USER_SEARCH_FILTER);
	}
	
	/**
	 * Set {@link #KEY_USER_SEARCH_FILTER} property to userSearchFilter in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userSearchFilter
	 *            value for userSearchFilter
	 */
	static public void setUserSearchFilter(Properties properties, String userSearchFilter) {
		if(userSearchFilter==null){
			properties.remove(KEY_USER_SEARCH_FILTER);
		}else{
			properties.setProperty(KEY_USER_SEARCH_FILTER, userSearchFilter);
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
	static public String getUserSearch(Properties properties) {
		return properties.getProperty(KEY_USER_SEARCH);
	}
	
	/**
	 * Set {@link #KEY_USER_SEARCH} property to userSearch in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userSearch
	 *            value for userSearch
	 */
	static public void setUserSearch(Properties properties, String userSearch) {
		if(userSearch==null){
			properties.remove(KEY_USER_SEARCH);
		}else{
			properties.setProperty(KEY_USER_SEARCH, userSearch);
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
	static public String getUserIdAttribute(Properties properties) {
		return properties.getProperty(KEY_USER_ID);
	}
	
	/**
	 * Set {@link #KEY_USER_ID} property to userIdAttribute in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param userIdAttribute
	 *            value for userIdAttribute
	 */
	static public void setUserIdAttribute(Properties properties, String userIdAttribute) {
		if(userIdAttribute==null){
			properties.remove(KEY_USER_ID);
		}else{
			properties.setProperty(KEY_USER_ID, userIdAttribute);
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
	static public String getSysadminRole(Properties properties) {
		return properties.getProperty(KEY_SYSADMIN);
	}
	
	/**
	 * Set {@link #KEY_SYSADMIN} property to sysadminRole in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param sysadminRole
	 *            value for sysadminRole
	 */
	static public void setSysadminRole(Properties properties, String sysadminRole) {
		if(sysadminRole==null){
			properties.remove(KEY_SYSADMIN);
		}else{
			properties.setProperty(KEY_SYSADMIN, sysadminRole);
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
	static public boolean getUseEmbeddedServer(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_USE_EMBEDDED,""+true)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_USE_EMBEDDED} property to useEmbeddedServer in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param useEmbeddedServer
	 *           value for useEmbeddedServer
	 */
	static public void setUseEmbeddedServer(Properties properties, boolean useEmbeddedServer) {
		properties.setProperty(KEY_USE_EMBEDDED, Boolean.toString(useEmbeddedServer));
	}
 	
 	
 	/**
	 * Get {@link #KEY_ANONYMOUS_ACCESS_ENABLED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_ANONYMOUS_ACCESS_ENABLED},or "false"  if not present
	 */
	static public boolean getAnonymousAccessEnabled(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_ANONYMOUS_ACCESS_ENABLED,""+false)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_ANONYMOUS_ACCESS_ENABLED} property to anonymousAccessEnabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param anonymousAccessEnabled
	 *           value for anonymousAccessEnabled
	 */
	static public void setAnonymousAccessEnabled(Properties properties, boolean anonymousAccessEnabled) {
		properties.setProperty(KEY_ANONYMOUS_ACCESS_ENABLED, Boolean.toString(anonymousAccessEnabled));
	}
 	
 	
 }
 	