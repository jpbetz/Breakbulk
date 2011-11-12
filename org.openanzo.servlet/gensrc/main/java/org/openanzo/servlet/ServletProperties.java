
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
package org.openanzo.servlet;
import java.util.Properties;
/**
 *   Base configuration properties that are used by servlets.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class ServletProperties{
 	
	/**
	 * Key for property "org.openanzo.servlet.pathSpec"
	 * PathSpec
	 *
	 */
	public static final String	KEY_PATH_SPEC	= "org.openanzo.servlet.pathSpec";
 	
	/**
	 * Key for property "org.openanzo.servlet.protectedPathSpec"
	 * Protected PathSpec
	 *
	 */
	public static final String	KEY_PROTECTED_PATH_SPEC	= "org.openanzo.servlet.protectedPathSpec";
 	
	/**
	 * Key for property "org.openanzo.servlet.contextPath"
	 * PathSpec
	 *
	 */
	public static final String	KEY_CONTEXT_PATH	= "org.openanzo.servlet.contextPath";
 	
	/**
	 * Key for property "org.openanzo.servlet.docRoot"
	 * Doc root
	 *
	 */
	public static final String	KEY_DOC_ROOT	= "org.openanzo.servlet.docRoot";
 	
	/**
	 * Key for property "org.openanzo.servlet.authorizationType"
	 * Auth type.
	 *
	 */
	public static final String	KEY_AUTH_TYPE	= "org.openanzo.servlet.authorizationType";
 	
	/**
	 * Key for property "org.openanzo.servlet.securityConstraint"
	 * Security Constraint
	 *
	 */
	public static final String	KEY_SECURITY_CONSTRAINT	= "org.openanzo.servlet.securityConstraint";
 	
	/**
	 * Key for property "org.openanzo.servlet.loginPage"
	 * login page url
	 *
	 */
	public static final String	KEY_LOGIN_PAGE	= "org.openanzo.servlet.loginPage";
 	
	/**
	 * Key for property "org.openanzo.servlet.errorPage"
	 * error page url
	 *
	 */
	public static final String	KEY_ERROR_PAGE	= "org.openanzo.servlet.errorPage";
 	
	/**
	 * Key for property "org.openanzo.servlet.customTokenRefreshEnabled"
	 * Doc root
	 *
	 */
	public static final String	KEY_CUSTOME_TOKEN_REFRESH	= "org.openanzo.servlet.customTokenRefreshEnabled";
 	
	/**
	 * Key for property "org.openanzo.servlet.gzipOutput"
	 * GZIP output
	 *
	 */
	public static final String	KEY_GZIP_OUTPUT	= "org.openanzo.servlet.gzipOutput";
 	
	/**
	 * Key for property "org.openanzo.servlet.authTokenTimeout"
	 * Auth token timeout
	 *
	 */
	public static final String	KEY_AUTH_TOKEN_TIMEOUT	= "org.openanzo.servlet.authTokenTimeout";
 	
	/**
	 * Key for property "org.openanzo.servlet.authTokenRefreshWindow"
	 * Auth token refresh window
	 *
	 */
	public static final String	KEY_AUTH_TOKEN_REFRESH_WINDOW	= "org.openanzo.servlet.authTokenRefreshWindow";
 	
	/**
	 * Key for property "org.openanzo.servlet.servletClass"
	 * Servlet ClassName
	 *
	 */
	public static final String	KEY_SERVLET_CLASS	= "org.openanzo.servlet.servletClass";
 	
 	/**
	 * Get {@link #KEY_PATH_SPEC} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_PATH_SPEC} if not present
	 */
	static public String getPathSpec(Properties properties) {
		return properties.getProperty(KEY_PATH_SPEC);
	}
	
	/**
	 * Set {@link #KEY_PATH_SPEC} property to pathSpec in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param pathSpec
	 *            value for pathSpec
	 */
	static public void setPathSpec(Properties properties, String pathSpec) {
		if(pathSpec==null){
			properties.remove(KEY_PATH_SPEC);
		}else{
			properties.setProperty(KEY_PATH_SPEC, pathSpec);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_PROTECTED_PATH_SPEC} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_PROTECTED_PATH_SPEC} if not present
	 */
	static public String getProtectedPathSpec(Properties properties) {
		return properties.getProperty(KEY_PROTECTED_PATH_SPEC);
	}
	
	/**
	 * Set {@link #KEY_PROTECTED_PATH_SPEC} property to protectedPathSpec in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param protectedPathSpec
	 *            value for protectedPathSpec
	 */
	static public void setProtectedPathSpec(Properties properties, String protectedPathSpec) {
		if(protectedPathSpec==null){
			properties.remove(KEY_PROTECTED_PATH_SPEC);
		}else{
			properties.setProperty(KEY_PROTECTED_PATH_SPEC, protectedPathSpec);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_CONTEXT_PATH} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_CONTEXT_PATH} if not present
	 */
	static public String getContextPath(Properties properties) {
		return properties.getProperty(KEY_CONTEXT_PATH);
	}
	
	/**
	 * Set {@link #KEY_CONTEXT_PATH} property to contextPath in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param contextPath
	 *            value for contextPath
	 */
	static public void setContextPath(Properties properties, String contextPath) {
		if(contextPath==null){
			properties.remove(KEY_CONTEXT_PATH);
		}else{
			properties.setProperty(KEY_CONTEXT_PATH, contextPath);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DOC_ROOT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DOC_ROOT} if not present
	 */
	static public String getDocRoot(Properties properties) {
		return properties.getProperty(KEY_DOC_ROOT);
	}
	
	/**
	 * Set {@link #KEY_DOC_ROOT} property to docRoot in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param docRoot
	 *            value for docRoot
	 */
	static public void setDocRoot(Properties properties, String docRoot) {
		if(docRoot==null){
			properties.remove(KEY_DOC_ROOT);
		}else{
			properties.setProperty(KEY_DOC_ROOT, docRoot);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_AUTH_TYPE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_AUTH_TYPE} if not present
	 */
	static public String getAuthorizationType(Properties properties) {
		return properties.getProperty(KEY_AUTH_TYPE);
	}
	
	/**
	 * Set {@link #KEY_AUTH_TYPE} property to authorizationType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param authorizationType
	 *            value for authorizationType
	 */
	static public void setAuthorizationType(Properties properties, String authorizationType) {
		if(authorizationType==null){
			properties.remove(KEY_AUTH_TYPE);
		}else{
			properties.setProperty(KEY_AUTH_TYPE, authorizationType);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_SECURITY_CONSTRAINT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_SECURITY_CONSTRAINT} if not present
	 */
	static public String getSecurityConstraint(Properties properties) {
		return properties.getProperty(KEY_SECURITY_CONSTRAINT);
	}
	
	/**
	 * Set {@link #KEY_SECURITY_CONSTRAINT} property to securityConstraint in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param securityConstraint
	 *            value for securityConstraint
	 */
	static public void setSecurityConstraint(Properties properties, String securityConstraint) {
		if(securityConstraint==null){
			properties.remove(KEY_SECURITY_CONSTRAINT);
		}else{
			properties.setProperty(KEY_SECURITY_CONSTRAINT, securityConstraint);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LOGIN_PAGE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LOGIN_PAGE} if not present
	 */
	static public String getLoginPage(Properties properties) {
		return properties.getProperty(KEY_LOGIN_PAGE);
	}
	
	/**
	 * Set {@link #KEY_LOGIN_PAGE} property to loginPage in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param loginPage
	 *            value for loginPage
	 */
	static public void setLoginPage(Properties properties, String loginPage) {
		if(loginPage==null){
			properties.remove(KEY_LOGIN_PAGE);
		}else{
			properties.setProperty(KEY_LOGIN_PAGE, loginPage);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_ERROR_PAGE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_ERROR_PAGE} if not present
	 */
	static public String getErrorPage(Properties properties) {
		return properties.getProperty(KEY_ERROR_PAGE);
	}
	
	/**
	 * Set {@link #KEY_ERROR_PAGE} property to errorPage in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param errorPage
	 *            value for errorPage
	 */
	static public void setErrorPage(Properties properties, String errorPage) {
		if(errorPage==null){
			properties.remove(KEY_ERROR_PAGE);
		}else{
			properties.setProperty(KEY_ERROR_PAGE, errorPage);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_CUSTOME_TOKEN_REFRESH} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_CUSTOME_TOKEN_REFRESH},or "false"  if not present
	 */
	static public boolean getCustomTokenRefreshEnabled(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_CUSTOME_TOKEN_REFRESH,""+false)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_CUSTOME_TOKEN_REFRESH} property to customTokenRefreshEnabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param customTokenRefreshEnabled
	 *           value for customTokenRefreshEnabled
	 */
	static public void setCustomTokenRefreshEnabled(Properties properties, boolean customTokenRefreshEnabled) {
		properties.setProperty(KEY_CUSTOME_TOKEN_REFRESH, Boolean.toString(customTokenRefreshEnabled));
	}
 	
 	
 	/**
	 * Get {@link #KEY_GZIP_OUTPUT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_GZIP_OUTPUT},or "true"  if not present
	 */
	static public boolean getGzipOutput(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_GZIP_OUTPUT,""+true)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_GZIP_OUTPUT} property to gzipOutput in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param gzipOutput
	 *           value for gzipOutput
	 */
	static public void setGzipOutput(Properties properties, boolean gzipOutput) {
		properties.setProperty(KEY_GZIP_OUTPUT, Boolean.toString(gzipOutput));
	}
 	
 	
 	/**
	 * Get {@link #KEY_AUTH_TOKEN_TIMEOUT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_AUTH_TOKEN_TIMEOUT} if not present
	 */
	static public int getAuthTokenTimeout(Properties properties) {
		int value= Integer.parseInt(properties.getProperty(KEY_AUTH_TOKEN_TIMEOUT));
		
		if(value <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"authTokenTimeout","0");
		if(value >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"authTokenTimeout","65536");
		return value;
	}

	/**
	 * Set {@link #KEY_AUTH_TOKEN_TIMEOUT} property to authTokenTimeout in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param authTokenTimeout
	 *           value for authTokenTimeout
	 */
	static public void setAuthTokenTimeout(Properties properties, int authTokenTimeout) {
		
		if(authTokenTimeout <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"authTokenTimeout","0");
		if(authTokenTimeout >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"authTokenTimeout","65536");
		properties.setProperty(KEY_AUTH_TOKEN_TIMEOUT, Integer.toString(authTokenTimeout));
	}
 	
 	
 	/**
	 * Get {@link #KEY_AUTH_TOKEN_REFRESH_WINDOW} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_AUTH_TOKEN_REFRESH_WINDOW} if not present
	 */
	static public int getAuthTokenRefreshWindow(Properties properties) {
		int value= Integer.parseInt(properties.getProperty(KEY_AUTH_TOKEN_REFRESH_WINDOW));
		
		if(value <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"authTokenRefreshWindow","0");
		if(value >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"authTokenRefreshWindow","65536");
		return value;
	}

	/**
	 * Set {@link #KEY_AUTH_TOKEN_REFRESH_WINDOW} property to authTokenRefreshWindow in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param authTokenRefreshWindow
	 *           value for authTokenRefreshWindow
	 */
	static public void setAuthTokenRefreshWindow(Properties properties, int authTokenRefreshWindow) {
		
		if(authTokenRefreshWindow <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"authTokenRefreshWindow","0");
		if(authTokenRefreshWindow >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"authTokenRefreshWindow","65536");
		properties.setProperty(KEY_AUTH_TOKEN_REFRESH_WINDOW, Integer.toString(authTokenRefreshWindow));
	}
 	
 	
 	/**
	 * Get {@link #KEY_SERVLET_CLASS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_SERVLET_CLASS} if not present
	 */
	static public String getServletClass(Properties properties) {
		return properties.getProperty(KEY_SERVLET_CLASS);
	}
	
	/**
	 * Set {@link #KEY_SERVLET_CLASS} property to servletClass in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param servletClass
	 *            value for servletClass
	 */
	static public void setServletClass(Properties properties, String servletClass) {
		if(servletClass==null){
			properties.remove(KEY_SERVLET_CLASS);
		}else{
			properties.setProperty(KEY_SERVLET_CLASS, servletClass);
		}
	}
 	
 	
 }
 	