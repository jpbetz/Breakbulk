
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
package org.openanzo.jmx;
import java.util.Properties;
/**
 *   Base configuration properties that are used by services if there aren't service specific values present.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class JMXProperties{
 	
	/**
	 * Key for property "org.openanzo.jmx.host"
	 * Host name for server
	 *
	 * Examples:
	 * localhost or 127.0.0.1
	 */
	public static final String	KEY_HOST	= "org.openanzo.jmx.host";
 	
	/**
	 * Key for property "org.openanzo.jmx.port"
	 * Port for server
	 *
	 * Examples:
	 * 8080
	 */
	public static final String	KEY_PORT	= "org.openanzo.jmx.port";
 	
 	/**
	 * Get {@link #KEY_HOST} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for host
	 * @return value of {@link #KEY_HOST}or defaultValue if not present
	 */
	static public String getHost(Properties properties,String defaultValue) {
		return properties.getProperty(KEY_HOST,defaultValue);
	}
	
	/**
	 * Set {@link #KEY_HOST} property to host in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param host
	 *            value for host
	 */
	static public void setHost(Properties properties, String host) {
		if(host==null){
			properties.remove(KEY_HOST);
		}else{
			properties.setProperty(KEY_HOST, host);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_PORT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for port
	 * @return value of {@link #KEY_PORT}or defaultValue if not present
	 */
	static public int getPort(Properties properties,int defaultValue) {
		int value= Integer.parseInt(properties.getProperty(KEY_PORT,""+defaultValue));
		
		if(value <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"port","1");
		if(value >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"port","65536");
		return value;
	}

	/**
	 * Set {@link #KEY_PORT} property to port in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param port
	 *           value for port
	 */
	static public void setPort(Properties properties, int port) {
		
		if(port <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"port","1");
		if(port >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"port","65536");
		properties.setProperty(KEY_PORT, Integer.toString(port));
	}
 	
 	
 }
 	