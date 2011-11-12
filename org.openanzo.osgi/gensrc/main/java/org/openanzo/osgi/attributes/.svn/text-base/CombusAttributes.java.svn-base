
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
package org.openanzo.osgi.attributes;
import org.openanzo.osgi.AnzoAttributeDefinition;

/**
 *   Configuration properties for combus services.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class CombusAttributes{
 	
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.host"
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
	 
	 public static final AnzoAttributeDefinition  Host = new AnzoAttributeDefinition() {
            public String getName() {
                return "host";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.combus.host";
            }

            public String getDescription() {
                return ""+"Hostname/IP Address or connection URL for the notification/jms server. Will fallback to org.openanzo.services.host if property not present.";
            }

            public String validate(String value) {
            	return "";
            }

            public int getType() {
                return AnzoAttributeDefinition.STRING;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.port"
	 * Port for notification/jms server. Will fallback to org.openanzo.services.port if property not present.
	 * <li><b>Server:</b>The notification server's listening port that the server services will use in order to connect to the notification server.</li>
	 * <li><b>Client:</b>The notification server's listening port that the client will use in order to connect to the notification server.</li>
	 * <li><b>Embedded:</b>See client</li>
	 *
	 * Examples:
	 * 61616
	 */
	 
	 public static final AnzoAttributeDefinition  Port = new AnzoAttributeDefinition() {
            public String getName() {
                return "port";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.combus.port";
            }

            public String getDescription() {
                return ""+"Port for notification/jms server. Will fallback to org.openanzo.services.port if property not present.";
            }

            public String validate(String value) {
            	
                try {
                    int _val = Integer.valueOf(value);
                    	if(_val< 1){return "Value must be greater than 1";}
                    if(_val> 65536){return "Value must be less than 65536";}
                    return "";
                } catch (NumberFormatException nfe) {
                    return "Value is not an Integer";
                }
            }

            public int getType() {
                return AnzoAttributeDefinition.INTEGER;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.useSsl"
	 * Use ssl connection to talk to server.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  UseSsl = new AnzoAttributeDefinition() {
            public String getName() {
                return "useSsl";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.combus.useSsl";
            }

            public String getDescription() {
                return ""+"Use ssl connection to talk to server.";
            }

            public String validate(String value) {
            	return "";
            }

            public int getType() {
                return AnzoAttributeDefinition.BOOLEAN;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return new String[] {Boolean.toString(false)};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.sslHost"
	 * Hostname/IP Address or connection URL for the notification/jms server. Will fallback to org.openanzo.services.host if property not present.
	 * The hostname/IP Address or connection URL of the notification server for which the client will use in order to connect to the notification server.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  SslHost = new AnzoAttributeDefinition() {
            public String getName() {
                return "sslHost";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.combus.sslHost";
            }

            public String getDescription() {
                return ""+"Hostname/IP Address or connection URL for the notification/jms server. Will fallback to org.openanzo.services.host if property not present."+"The hostname/IP Address or connection URL of the notification server for which the client will use in order to connect to the notification server.";
            }

            public String validate(String value) {
            	return "";
            }

            public int getType() {
                return AnzoAttributeDefinition.STRING;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.sslPort"
	 * Port for notification/jms server. Will fallback to org.openanzo.services.port if property not present.
	 * The notification server's ssl listening port that the client will use in order to connect to the notification server.
	 *
	 * Examples:
	 * 61617
	 */
	 
	 public static final AnzoAttributeDefinition  SslPort = new AnzoAttributeDefinition() {
            public String getName() {
                return "sslPort";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.combus.sslPort";
            }

            public String getDescription() {
                return ""+"Port for notification/jms server. Will fallback to org.openanzo.services.port if property not present."+"The notification server's ssl listening port that the client will use in order to connect to the notification server.";
            }

            public String validate(String value) {
            	
                try {
                    int _val = Integer.valueOf(value);
                    	if(_val< 1){return "Value must be greater than 1";}
                    if(_val> 65536){return "Value must be less than 65536";}
                    return "";
                } catch (NumberFormatException nfe) {
                    return "Value is not an Integer";
                }
            }

            public int getType() {
                return AnzoAttributeDefinition.INTEGER;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.controlQueue"
	 * Queue name that control messages are passed over.
	 * <li><b>Server:</b>Queue name that is used to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 * <li><b>Client:</b>Queue name that is used to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 * <li><b>Embedded:</b>Queue name that is used to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 *
	 * Examples:
	 * ControlQueue
	 */
	 
	 public static final AnzoAttributeDefinition  ControlQueue = new AnzoAttributeDefinition() {
            public String getName() {
                return "controlQueue";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.combus.controlQueue";
            }

            public String getDescription() {
                return ""+"Queue name that control messages are passed over.";
            }

            public String validate(String value) {
            	return "";
            }

            public int getType() {
                return AnzoAttributeDefinition.STRING;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.updatesQueue"
	 * Queue name that is used to update messages within the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.
	 * <li><b>Server:</b>Queue name that the update publisher uses to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 * <li><b>Client:</b>Not Used</li>
	 * <li><b>Embedded:</b>Queue name that the update publisher uses to send control messages to the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.</li>
	 *
	 * Examples:
	 * UpdateQueue
	 */
	 
	 public static final AnzoAttributeDefinition  UpdatesQueue = new AnzoAttributeDefinition() {
            public String getName() {
                return "updatesQueue";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.combus.updatesQueue";
            }

            public String getDescription() {
                return ""+"Queue name that is used to update messages within the notification server. Note: These settings should only be changed if you are changing the default behaviour of the JMS server.";
            }

            public String validate(String value) {
            	return "";
            }

            public int getType() {
                return AnzoAttributeDefinition.STRING;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
         
 }
 	