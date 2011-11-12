
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
package org.openanzo.security.ldap.attributes;
import org.openanzo.osgi.AnzoAttributeDefinition;

/**
 *   Base configuration properties that are used by ldap authentication provider.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class LDAPAuthAttributes{
 	
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.userBaseDN"
	 * BaseDN for User search.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  UserBaseDN = new AnzoAttributeDefinition() {
            public String getName() {
                return "userBaseDN";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.userBaseDN";
            }

            public String getDescription() {
                return ""+"BaseDN for User search.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.roleBaseDN"
	 * BaseDN for Role search.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  RoleBaseDN = new AnzoAttributeDefinition() {
            public String getName() {
                return "roleBaseDN";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.roleBaseDN";
            }

            public String getDescription() {
                return ""+"BaseDN for Role search.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.dnToUriTemplate"
	 * Template for converting dn to URI.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  DnToUriTemplate = new AnzoAttributeDefinition() {
            public String getName() {
                return "dnToUriTemplate";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.dnToUriTemplate";
            }

            public String getDescription() {
                return ""+"Template for converting dn to URI.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.rolesSearch"
	 * Roles search template.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  RolesSearch = new AnzoAttributeDefinition() {
            public String getName() {
                return "rolesSearch";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.rolesSearch";
            }

            public String getDescription() {
                return ""+"Roles search template.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.roleObjectClass"
	 * Role class.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  RoleObjectClass = new AnzoAttributeDefinition() {
            public String getName() {
                return "roleObjectClass";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.roleObjectClass";
            }

            public String getDescription() {
                return ""+"Role class.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.userObjectClass"
	 * User class.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  UserObjectClass = new AnzoAttributeDefinition() {
            public String getName() {
                return "userObjectClass";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.userObjectClass";
            }

            public String getDescription() {
                return ""+"User class.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.roleSearchFilter"
	 * Ldap filter to filter user search results eg objectClass=group
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  RoleSearchFilter = new AnzoAttributeDefinition() {
            public String getName() {
                return "roleSearchFilter";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.roleSearchFilter";
            }

            public String getDescription() {
                return ""+"Ldap filter to filter user search results eg objectClass=group";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.userSearchFilter"
	 * Ldap filter to filter user search results eg objectClass=person
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  UserSearchFilter = new AnzoAttributeDefinition() {
            public String getName() {
                return "userSearchFilter";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.userSearchFilter";
            }

            public String getDescription() {
                return ""+"Ldap filter to filter user search results eg objectClass=person";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.userSearch"
	 * Users search template.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  UserSearch = new AnzoAttributeDefinition() {
            public String getName() {
                return "userSearch";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.userSearch";
            }

            public String getDescription() {
                return ""+"Users search template.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.userIdAttribute"
	 * User ID attribute.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  UserIdAttribute = new AnzoAttributeDefinition() {
            public String getName() {
                return "userIdAttribute";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.userIdAttribute";
            }

            public String getDescription() {
                return ""+"User ID attribute.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.sysadminRole"
	 * Sysadmin Role.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  SysadminRole = new AnzoAttributeDefinition() {
            public String getName() {
                return "sysadminRole";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.sysadminRole";
            }

            public String getDescription() {
                return ""+"Sysadmin Role.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.useEmbeddedServer"
	 * Connect to embedded server.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  UseEmbeddedServer = new AnzoAttributeDefinition() {
            public String getName() {
                return "useEmbeddedServer";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.useEmbeddedServer";
            }

            public String getDescription() {
                return ""+"Connect to embedded server.";
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
                return new String[] {Boolean.toString(true)};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.ldap.anonymousAccessEnabled"
	 * Anonymous access enabled.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  AnonymousAccessEnabled = new AnzoAttributeDefinition() {
            public String getName() {
                return "anonymousAccessEnabled";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.ldap.anonymousAccessEnabled";
            }

            public String getDescription() {
                return ""+"Anonymous access enabled.";
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
         
 }
 	