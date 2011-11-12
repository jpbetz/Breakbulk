
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
 *   Base configuration properties that are used by ldap authentication provider.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class LDAPAttributes{
 	
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.ldap.host"
	 * Host name for server
	 *
	 * Examples:
	 * localhost or 127.0.0.1
	 */
	 
	 public static final AnzoAttributeDefinition  Host = new AnzoAttributeDefinition() {
            public String getName() {
                return "host";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.host";
            }

            public String getDescription() {
                return ""+"Host name for server";
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
	 * AnzoAttributeDefinition for "org.openanzo.ldap.port"
	 * Port for server
	 *
	 * Examples:
	 * 10389
	 */
	 
	 public static final AnzoAttributeDefinition  Port = new AnzoAttributeDefinition() {
            public String getName() {
                return "port";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.port";
            }

            public String getDescription() {
                return ""+"Port for server";
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
	 * AnzoAttributeDefinition for "org.openanzo.ldap.useSSL"
	 * Use SSL for connection
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  UseSSL = new AnzoAttributeDefinition() {
            public String getName() {
                return "useSSL";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.useSSL";
            }

            public String getDescription() {
                return ""+"Use SSL for connection";
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
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.ldap.id"
	 * LDAP Server ID
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  Id = new AnzoAttributeDefinition() {
            public String getName() {
                return "id";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.id";
            }

            public String getDescription() {
                return ""+"LDAP Server ID";
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
	 * AnzoAttributeDefinition for "org.openanzo.ldap.suffix"
	 * LDAP Server Suffix
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  Suffix = new AnzoAttributeDefinition() {
            public String getName() {
                return "suffix";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.suffix";
            }

            public String getDescription() {
                return ""+"LDAP Server Suffix";
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
	 * AnzoAttributeDefinition for "org.openanzo.ldap.organization"
	 * LDAP Server Organization
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  Organization = new AnzoAttributeDefinition() {
            public String getName() {
                return "organization";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.organization";
            }

            public String getDescription() {
                return ""+"LDAP Server Organization";
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
	 * AnzoAttributeDefinition for "org.openanzo.ldap.initFile"
	 * LDAP ldif file
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  InitFile = new AnzoAttributeDefinition() {
            public String getName() {
                return "initFile";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.initFile";
            }

            public String getDescription() {
                return ""+"LDAP ldif file";
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
	 * AnzoAttributeDefinition for "org.openanzo.ldap.searchBaseDN"
	 * BaseDN for search.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  SearchBaseDN = new AnzoAttributeDefinition() {
            public String getName() {
                return "searchBaseDN";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.searchBaseDN";
            }

            public String getDescription() {
                return ""+"BaseDN for search.";
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
	 * AnzoAttributeDefinition for "org.openanzo.ldap.ldapServerUser"
	 * Ldap Server User.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  LdapServerUser = new AnzoAttributeDefinition() {
            public String getName() {
                return "ldapServerUser";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.ldapServerUser";
            }

            public String getDescription() {
                return ""+"Ldap Server User.";
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
	 * AnzoAttributeDefinition for "org.openanzo.ldap.ldapServerPassword"
	 * Ldap Server Password.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  LdapServerPassword = new AnzoAttributeDefinition() {
            public String getName() {
                return "ldapServerPassword";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.ldap.ldapServerPassword";
            }

            public String getDescription() {
                return ""+"Ldap Server Password.";
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
 	