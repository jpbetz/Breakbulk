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
import java.util.Dictionary;
/**
 *   Configuration properties for combus services.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class CombusDictionary{
 	
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
	 @SuppressWarnings("unchecked")
	static public String getHost(Dictionary properties) {
		Object _prop = properties.get(KEY_COMBUS_HOST);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_COMBUS_HOST} property to host in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param host
	 *            value for host
	 */
	 @SuppressWarnings("unchecked")
	static public void setHost(Dictionary properties, String host) {
		if(host==null){
			properties.remove(KEY_COMBUS_HOST);
		}else{
			properties.put(KEY_COMBUS_HOST, host);
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
	 @SuppressWarnings("unchecked")
	static public Integer getPort(Dictionary properties) {
		Object _prop= properties.get(KEY_COMBUS_PORT);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):null;
		if(value!=null&&value <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"port","1");
		if(value!=null&&value >= 65536)
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
	 @SuppressWarnings("unchecked")
	static public void setPort(Dictionary properties, Integer port) {
		if(port==null){
			properties.remove(KEY_COMBUS_PORT);
		}else{
		if(port <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"port","1");
		if(port >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"port","65536");
		properties.put(KEY_COMBUS_PORT, Integer.toString(port));
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_COMBUS_USE_SSL} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_COMBUS_USE_SSL},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getUseSsl(Dictionary properties) {
		Object _prop=properties.get(KEY_COMBUS_USE_SSL);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_COMBUS_USE_SSL} property to useSsl in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param useSsl
	 *           value for useSsl
	 */
	 @SuppressWarnings("unchecked")
	static public void setUseSsl(Dictionary properties, Boolean useSsl) {
		if(useSsl==null){
			properties.remove(KEY_COMBUS_USE_SSL);
		}else{
			properties.put(KEY_COMBUS_USE_SSL, useSsl.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_COMBUS_SSL_HOST} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_COMBUS_SSL_HOST} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getSslHost(Dictionary properties) {
		Object _prop = properties.get(KEY_COMBUS_SSL_HOST);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_COMBUS_SSL_HOST} property to sslHost in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param sslHost
	 *            value for sslHost
	 */
	 @SuppressWarnings("unchecked")
	static public void setSslHost(Dictionary properties, String sslHost) {
		if(sslHost==null){
			properties.remove(KEY_COMBUS_SSL_HOST);
		}else{
			properties.put(KEY_COMBUS_SSL_HOST, sslHost);
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
	 @SuppressWarnings("unchecked")
	static public Integer getSslPort(Dictionary properties) {
		Object _prop= properties.get(KEY_COMBUS_SSL_PORT);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):null;
		if(value!=null&&value <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"sslPort","1");
		if(value!=null&&value >= 65536)
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
	 @SuppressWarnings("unchecked")
	static public void setSslPort(Dictionary properties, Integer sslPort) {
		if(sslPort==null){
			properties.remove(KEY_COMBUS_SSL_PORT);
		}else{
		if(sslPort <= 1)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_GREATER_THAN,"sslPort","1");
		if(sslPort >= 65536)
			throw new org.openanzo.exceptions.AnzoRuntimeException(org.openanzo.exceptions.ExceptionConstants.OSGI.PARAM_LESS_THAN,"sslPort","65536");
		properties.put(KEY_COMBUS_SSL_PORT, Integer.toString(sslPort));
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_COMBUS_CONTROLQUEUE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for controlQueue
	 * @return value of {@link #KEY_COMBUS_CONTROLQUEUE}or defaultValue if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getControlQueue(Dictionary properties,String defaultValue) {
		Object _prop = properties.get(KEY_COMBUS_CONTROLQUEUE);
		
		
		if(_prop==null){
			return defaultValue;
		}else{
			return _prop.toString();
		}
		
	}
	
	/**
	 * Set {@link #KEY_COMBUS_CONTROLQUEUE} property to controlQueue in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param controlQueue
	 *            value for controlQueue
	 */
	 @SuppressWarnings("unchecked")
	static public void setControlQueue(Dictionary properties, String controlQueue) {
		if(controlQueue==null){
			properties.remove(KEY_COMBUS_CONTROLQUEUE);
		}else{
			properties.put(KEY_COMBUS_CONTROLQUEUE, controlQueue);
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
	 @SuppressWarnings("unchecked")
	static public String getUpdatesQueue(Dictionary properties,String defaultValue) {
		Object _prop = properties.get(KEY_COMBUS_UPDATESQUEUE);
		
		
		if(_prop==null){
			return defaultValue;
		}else{
			return _prop.toString();
		}
		
	}
	
	/**
	 * Set {@link #KEY_COMBUS_UPDATESQUEUE} property to updatesQueue in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param updatesQueue
	 *            value for updatesQueue
	 */
	 @SuppressWarnings("unchecked")
	static public void setUpdatesQueue(Dictionary properties, String updatesQueue) {
		if(updatesQueue==null){
			properties.remove(KEY_COMBUS_UPDATESQUEUE);
		}else{
			properties.put(KEY_COMBUS_UPDATESQUEUE, updatesQueue);
		}
	}
 	
 	
 }
 	