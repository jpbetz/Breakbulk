
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
package org.openanzo.datasource;
import java.util.Properties;
/**
 *   Base configuration properties that are used by datasources.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class DatasourceProperties{
 	
	/**
	 * Key for property "org.openanzo.datasource.isPrimary"
	 * Is this the primary datasource
	 *
	 */
	public static final String	KEY_IS_PRIMARY	= "org.openanzo.datasource.isPrimary";
 	
	/**
	 * Key for property "org.openanzo.datasource.initFiles"
	 * Init files for datasource initialization and reset
	 *
	 */
	public static final String	KEY_INIT_FILES	= "org.openanzo.datasource.initFiles";
 	
	/**
	 * Key for property "org.openanzo.datasource.datasourceURI"
	 * URI for datasource
	 *
	 */
	public static final String	KEY_DATASOURCE_URI	= "org.openanzo.datasource.datasourceURI";
 	
	/**
	 * Key for property "org.openanzo.datasource.uriPatterns"
	 * URI patterns for datasource
	 *
	 */
	public static final String	KEY_URI_PATTERNS	= "org.openanzo.datasource.uriPatterns";
 	
	/**
	 * Key for property "org.openanzo.datasource.enableCaching"
	 * Enable Caching
	 *
	 */
	public static final String	KEY_ENABLE_CACHING	= "org.openanzo.datasource.enableCaching";
 	
	/**
	 * Key for property "org.openanzo.datasource.resetEnabled"
	 * Enable Reset
	 *
	 */
	public static final String	KEY_RESET_ENABLED	= "org.openanzo.datasource.resetEnabled";
 	
	/**
	 * Key for property "org.openanzo.datasource.maxWriteConnections"
	 * Maximum number of write connections.
	 *
	 * Examples:
	 * 
	 */
	public static final String	KEY_MAX_WRITE_CONNECTIONS	= "org.openanzo.datasource.maxWriteConnections";
 	
	/**
	 * Key for property "org.openanzo.datasource.maxQueryConnections"
	 * Maximum number of query connections.
	 *
	 * Examples:
	 * 
	 */
	public static final String	KEY_MAX_QUERY_CONNECTIONS	= "org.openanzo.datasource.maxQueryConnections";
 	
 	/**
	 * Get {@link #KEY_IS_PRIMARY} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_IS_PRIMARY}, or false  if not present
	 */
	static public boolean getIsPrimary(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_IS_PRIMARY,"false")).booleanValue();		
	}

	/**
	 * Set {@link #KEY_IS_PRIMARY} property to isPrimary in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param isPrimary
	 *           value for isPrimary
	 */
	static public void setIsPrimary(Properties properties, boolean isPrimary) {
		properties.setProperty(KEY_IS_PRIMARY, Boolean.toString(isPrimary));
	}
 	
 	
 	/**
	 * Get {@link #KEY_INIT_FILES} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_INIT_FILES} if not present
	 */
	static public String getInitFiles(Properties properties) {
		return properties.getProperty(KEY_INIT_FILES);
	}
	
	/**
	 * Set {@link #KEY_INIT_FILES} property to initFiles in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param initFiles
	 *            value for initFiles
	 */
	static public void setInitFiles(Properties properties, String initFiles) {
		if(initFiles==null){
			properties.remove(KEY_INIT_FILES);
		}else{
			properties.setProperty(KEY_INIT_FILES, initFiles);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_DATASOURCE_URI} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_DATASOURCE_URI} if not present
	 */
	static public String getDatasourceURI(Properties properties) {
		return properties.getProperty(KEY_DATASOURCE_URI);
	}
	
	/**
	 * Set {@link #KEY_DATASOURCE_URI} property to datasourceURI in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param datasourceURI
	 *            value for datasourceURI
	 */
	static public void setDatasourceURI(Properties properties, String datasourceURI) {
		if(datasourceURI==null){
			properties.remove(KEY_DATASOURCE_URI);
		}else{
			properties.setProperty(KEY_DATASOURCE_URI, datasourceURI);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_URI_PATTERNS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_URI_PATTERNS} if not present
	 */
	static public String getUriPatterns(Properties properties) {
		return properties.getProperty(KEY_URI_PATTERNS);
	}
	
	/**
	 * Set {@link #KEY_URI_PATTERNS} property to uriPatterns in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param uriPatterns
	 *            value for uriPatterns
	 */
	static public void setUriPatterns(Properties properties, String uriPatterns) {
		if(uriPatterns==null){
			properties.remove(KEY_URI_PATTERNS);
		}else{
			properties.setProperty(KEY_URI_PATTERNS, uriPatterns);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_ENABLE_CACHING} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for enableCaching
	 * @return value of {@link #KEY_ENABLE_CACHING}or defaultValue if not present
	 */
	static public boolean getEnableCaching(Properties properties,boolean defaultValue) {
		return Boolean.valueOf(properties.getProperty(KEY_ENABLE_CACHING,""+defaultValue)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_ENABLE_CACHING} property to enableCaching in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param enableCaching
	 *           value for enableCaching
	 */
	static public void setEnableCaching(Properties properties, boolean enableCaching) {
		properties.setProperty(KEY_ENABLE_CACHING, Boolean.toString(enableCaching));
	}
 	
 	
 	/**
	 * Get {@link #KEY_RESET_ENABLED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_RESET_ENABLED}, or false  if not present
	 */
	static public boolean getResetEnabled(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_RESET_ENABLED,"false")).booleanValue();		
	}

	/**
	 * Set {@link #KEY_RESET_ENABLED} property to resetEnabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param resetEnabled
	 *           value for resetEnabled
	 */
	static public void setResetEnabled(Properties properties, boolean resetEnabled) {
		properties.setProperty(KEY_RESET_ENABLED, Boolean.toString(resetEnabled));
	}
 	
 	
 	/**
	 * Get {@link #KEY_MAX_WRITE_CONNECTIONS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_MAX_WRITE_CONNECTIONS} if not present
	 */
	static public int getMaxWriteConnections(Properties properties) {
		int value= Integer.parseInt(properties.getProperty(KEY_MAX_WRITE_CONNECTIONS));
		
		if(value <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxWriteConnections","0");
		if(value >= 1600)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"maxWriteConnections","1600");
		return value;
	}

	/**
	 * Set {@link #KEY_MAX_WRITE_CONNECTIONS} property to maxWriteConnections in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param maxWriteConnections
	 *           value for maxWriteConnections
	 */
	static public void setMaxWriteConnections(Properties properties, int maxWriteConnections) {
		
		if(maxWriteConnections <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxWriteConnections","0");
		if(maxWriteConnections >= 1600)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"maxWriteConnections","1600");
		properties.setProperty(KEY_MAX_WRITE_CONNECTIONS, Integer.toString(maxWriteConnections));
	}
 	
 	
 	/**
	 * Get {@link #KEY_MAX_QUERY_CONNECTIONS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_MAX_QUERY_CONNECTIONS} if not present
	 */
	static public int getMaxQueryConnections(Properties properties) {
		int value= Integer.parseInt(properties.getProperty(KEY_MAX_QUERY_CONNECTIONS));
		
		if(value <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxQueryConnections","0");
		if(value >= 1600)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"maxQueryConnections","1600");
		return value;
	}

	/**
	 * Set {@link #KEY_MAX_QUERY_CONNECTIONS} property to maxQueryConnections in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param maxQueryConnections
	 *           value for maxQueryConnections
	 */
	static public void setMaxQueryConnections(Properties properties, int maxQueryConnections) {
		
		if(maxQueryConnections <= 0)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"maxQueryConnections","0");
		if(maxQueryConnections >= 1600)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"maxQueryConnections","1600");
		properties.setProperty(KEY_MAX_QUERY_CONNECTIONS, Integer.toString(maxQueryConnections));
	}
 	
 	
 }
 	