
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
package org.openanzo.combus;
import java.util.Properties;
/**
 *   Configuration properties for combus services.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class CombusProperties{
 	
	/**
	 * Key for property "org.openanzo.combus.host"
	 * Hostname/IP Address or connection URL for the notification/jms server. Will fallback to org.openanzo.services.host if property not present.
	 * <li><b>Server:</b>The hostname/IP address or connection URL of the notification server for which the server services will use in order to connect to the notification server.</li>
	 * <li><b>Client:</b>The hostname/IP Address or connection URL of the notification server for which the client will use in order to connect to the notification server.</li>
	 * <li><b>Embedded:</b>See client</li>
	 *
	 * Examples:
	 * <li><b>Server:</b>localhost,tcp://localhost or if running in the same JVM as the JMS server, vm://localhost</li>
	 * <li><b>Client:</b>localhost or tcp://localhost</li>
	 * <li><b>Embedded:</b>localhost or tcp://localhost</li>
	 */
	public static final String	KEY_COMBUS_HOST	= "org.openanzo.combus.host";
 	
	/**
	 * Key for property "org.openanzo.combus.port"
	 * Port for notification/jms server. Will fallback to org.openanzo.services.port if property not present.
	 * <li><b>Server:</b>The notification server's listening port that the server services will use in order to connect to the notification server.</li>
	 * <li><b>Client:</b>The notification server's listening port that the client will use in order to connect to the notification server.</li>
	 * <li><b>Embedded:</b>See client</li>
	 *
	 * Examples:
	 * 61616
	 */
	public static final String	KEY_COMBUS_PORT	= "org.openanzo.combus.port";
 	
	/**
	 * Key for property "org.openanzo.combus.useSsl"
	 * Use ssl connection to talk to server.
	 *
	 */
	public static final String	KEY_COMBUS_USE_SSL	= "org.openanzo.combus.useSsl";
 	
	/**
	 * Key for property "org.openanzo.combus.sslHost"
	 * Hostname/IP Address or connection URL for the notification/jms server. Will fallback to org.openanzo.services.host if property not present.
	 * The hostname/IP Address or connection URL of the notification server for which the client will use in order to connect to the notification server.
	 *
	 */
	public static final String	KEY_COMBUS_SSL_HOST	= "org.openanzo.combus.sslHost";
 	
	/**
	 * Key for property "org.openanzo.combus.sslPort"
	 * Port for notification/jms server. Will fallback to org.openanzo.services.port if property not present.
	 * The notification server's ssl listening port that the client will use in order to connect to the notification server.
	 *
	 * Examples:
	 * 61617
	 */
	public static final String	KEY_COMBUS_SSL_PORT	= "org.openanzo.combus.sslPort";
 	
	/**
	 * Key for property "org.openanzo.combus.controlQueue"
	 * Queue name that control messages are passed over.
	 * <li><b>Server:</b>Queue name that is used to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 * <li><b>Client:</b>Queue name that is used to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 * <li><b>Embedded:</b>Queue name that is used to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 *
	 * Examples:
	 * ControlQueue
	 */
	public static final String	KEY_COMBUS_CONTROLQUEUE	= "org.openanzo.combus.controlQueue";
 	
	/**
	 * Key for property "org.openanzo.combus.updatesQueue"
	 * Queue name that is used to update messages within the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.
	 * <li><b>Server:</b>Queue name that the update publisher uses to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 * <li><b>Client:</b>Not Used</li>
	 * <li><b>Embedded:</b>Queue name that the update publisher uses to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 *
	 * Examples:
	 * UpdateQueue
	 */
	public static final String	KEY_COMBUS_UPDATESQUEUE	= "org.openanzo.combus.updatesQueue";
 	
 	/**
	 * Get {@link #KEY_COMBUS_HOST} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_COMBUS_HOST} if not present
	 */
	static public String getHost(Properties properties) {
		return properties.getProperty(KEY_COMBUS_HOST);
	}
	
	/**
	 * Set {@link #KEY_COMBUS_HOST} property to host in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param host
	 *            value for host
	 */
	static public void setHost(Properties properties, String host) {
		if(host==null){
			properties.remove(KEY_COMBUS_HOST);
		}else{
			properties.setProperty(KEY_COMBUS_HOST, host);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_COMBUS_PORT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_COMBUS_PORT} if not present
	 */
	static public int getPort(Properties properties) {
		int value= Integer.parseInt(properties.getProperty(KEY_COMBUS_PORT));
		
		if(value <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"port","1");
		if(value >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"port","65536");
		return value;
	}

	/**
	 * Set {@link #KEY_COMBUS_PORT} property to port in properties
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
		properties.setProperty(KEY_COMBUS_PORT, Integer.toString(port));
	}
 	
 	
 	/**
	 * Get {@link #KEY_COMBUS_USE_SSL} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_COMBUS_USE_SSL},or "false"  if not present
	 */
	static public boolean getUseSsl(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_COMBUS_USE_SSL,""+false)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_COMBUS_USE_SSL} property to useSsl in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param useSsl
	 *           value for useSsl
	 */
	static public void setUseSsl(Properties properties, boolean useSsl) {
		properties.setProperty(KEY_COMBUS_USE_SSL, Boolean.toString(useSsl));
	}
 	
 	
 	/**
	 * Get {@link #KEY_COMBUS_SSL_HOST} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_COMBUS_SSL_HOST} if not present
	 */
	static public String getSslHost(Properties properties) {
		return properties.getProperty(KEY_COMBUS_SSL_HOST);
	}
	
	/**
	 * Set {@link #KEY_COMBUS_SSL_HOST} property to sslHost in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param sslHost
	 *            value for sslHost
	 */
	static public void setSslHost(Properties properties, String sslHost) {
		if(sslHost==null){
			properties.remove(KEY_COMBUS_SSL_HOST);
		}else{
			properties.setProperty(KEY_COMBUS_SSL_HOST, sslHost);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_COMBUS_SSL_PORT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_COMBUS_SSL_PORT} if not present
	 */
	static public int getSslPort(Properties properties) {
		int value= Integer.parseInt(properties.getProperty(KEY_COMBUS_SSL_PORT));
		
		if(value <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"sslPort","1");
		if(value >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"sslPort","65536");
		return value;
	}

	/**
	 * Set {@link #KEY_COMBUS_SSL_PORT} property to sslPort in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param sslPort
	 *           value for sslPort
	 */
	static public void setSslPort(Properties properties, int sslPort) {
		
		if(sslPort <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"sslPort","1");
		if(sslPort >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"sslPort","65536");
		properties.setProperty(KEY_COMBUS_SSL_PORT, Integer.toString(sslPort));
	}
 	
 	
 	/**
	 * Get {@link #KEY_COMBUS_CONTROLQUEUE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for controlQueue
	 * @return value of {@link #KEY_COMBUS_CONTROLQUEUE}or defaultValue if not present
	 */
	static public String getControlQueue(Properties properties,String defaultValue) {
		return properties.getProperty(KEY_COMBUS_CONTROLQUEUE,defaultValue);
	}
	
	/**
	 * Set {@link #KEY_COMBUS_CONTROLQUEUE} property to controlQueue in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param controlQueue
	 *            value for controlQueue
	 */
	static public void setControlQueue(Properties properties, String controlQueue) {
		if(controlQueue==null){
			properties.remove(KEY_COMBUS_CONTROLQUEUE);
		}else{
			properties.setProperty(KEY_COMBUS_CONTROLQUEUE, controlQueue);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_COMBUS_UPDATESQUEUE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for updatesQueue
	 * @return value of {@link #KEY_COMBUS_UPDATESQUEUE}or defaultValue if not present
	 */
	static public String getUpdatesQueue(Properties properties,String defaultValue) {
		return properties.getProperty(KEY_COMBUS_UPDATESQUEUE,defaultValue);
	}
	
	/**
	 * Set {@link #KEY_COMBUS_UPDATESQUEUE} property to updatesQueue in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param updatesQueue
	 *            value for updatesQueue
	 */
	static public void setUpdatesQueue(Properties properties, String updatesQueue) {
		if(updatesQueue==null){
			properties.remove(KEY_COMBUS_UPDATESQUEUE);
		}else{
			properties.setProperty(KEY_COMBUS_UPDATESQUEUE, updatesQueue);
		}
	}
 	
 	
 }
 	