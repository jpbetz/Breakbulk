
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
package org.openanzo.security.keystore.attributes;
import org.openanzo.osgi.AnzoAttributeDefinition;

/**
 *   Base configuration properties that are used by ldap authentication provider.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class KeyStoreAttributes{
 	
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.keyFileLocation"
	 * The path to the secret keystore.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  KeyFileLocation = new AnzoAttributeDefinition() {
            public String getName() {
                return "keyFileLocation";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.keyFileLocation";
            }

            public String getDescription() {
                return ""+"The path to the secret keystore.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.keyPassword"
	 * Password used to protect the secret key in the keystore.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  KeyPassword = new AnzoAttributeDefinition() {
            public String getName() {
                return "keyPassword";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.keyPassword";
            }

            public String getDescription() {
                return ""+"Password used to protect the secret key in the keystore.";
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
                return new String[] {"secret"};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.keystoreType"
	 * Keystore Type.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  KeystoreType = new AnzoAttributeDefinition() {
            public String getName() {
                return "keystoreType";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.keystoreType";
            }

            public String getDescription() {
                return ""+"Keystore Type.";
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
                return new String[] {"JCEKS"};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.algorithm"
	 * Algorithm to use for encrypting data. This is a transformation string of the format accepted by the javax.crypto.Cipher#getInstance method. The default is 'AES'.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  Algorithm = new AnzoAttributeDefinition() {
            public String getName() {
                return "algorithm";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.algorithm";
            }

            public String getDescription() {
                return ""+"Algorithm to use for encrypting data. This is a transformation string of the format accepted by the javax.crypto.Cipher#getInstance method. The default is 'AES'.";
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
                return new String[] {"AES"};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.trustFileLocation"
	 * The path to the secret truststore.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  TrustFileLocation = new AnzoAttributeDefinition() {
            public String getName() {
                return "trustFileLocation";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.trustFileLocation";
            }

            public String getDescription() {
                return ""+"The path to the secret truststore.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.trustPassword"
	 * Password used to protect the secret key in the truststore.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  TrustPassword = new AnzoAttributeDefinition() {
            public String getName() {
                return "trustPassword";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.trustPassword";
            }

            public String getDescription() {
                return ""+"Password used to protect the secret key in the truststore.";
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
                return new String[] {"secret"};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.truststoreType"
	 * Truststore Type.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  TruststoreType = new AnzoAttributeDefinition() {
            public String getName() {
                return "truststoreType";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.truststoreType";
            }

            public String getDescription() {
                return ""+"Truststore Type.";
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
                return new String[] {"JCEKS"};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.clientKeyFileLocation"
	 * The path to the secret keystore.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  ClientKeyFileLocation = new AnzoAttributeDefinition() {
            public String getName() {
                return "clientKeyFileLocation";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.clientKeyFileLocation";
            }

            public String getDescription() {
                return ""+"The path to the secret keystore.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.clientKeyPassword"
	 * Password used to protect the secret key in the keystore.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  ClientKeyPassword = new AnzoAttributeDefinition() {
            public String getName() {
                return "clientKeyPassword";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.clientKeyPassword";
            }

            public String getDescription() {
                return ""+"Password used to protect the secret key in the keystore.";
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
                return new String[] {"secret"};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.clientKeystoreType"
	 * Keystore Type.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  ClientKeystoreType = new AnzoAttributeDefinition() {
            public String getName() {
                return "clientKeystoreType";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.clientKeystoreType";
            }

            public String getDescription() {
                return ""+"Keystore Type.";
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
                return new String[] {"JCEKS"};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.clientTrustFileLocation"
	 * The path to the secret truststore.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  ClientTrustFileLocation = new AnzoAttributeDefinition() {
            public String getName() {
                return "clientTrustFileLocation";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.clientTrustFileLocation";
            }

            public String getDescription() {
                return ""+"The path to the secret truststore.";
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
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.clientTrustPassword"
	 * Password used to protect the secret key in the truststore.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  ClientTrustPassword = new AnzoAttributeDefinition() {
            public String getName() {
                return "clientTrustPassword";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.clientTrustPassword";
            }

            public String getDescription() {
                return ""+"Password used to protect the secret key in the truststore.";
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
                return new String[] {"secret"};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.security.keystore.clientTruststoreType"
	 * Truststore Type.
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  ClientTruststoreType = new AnzoAttributeDefinition() {
            public String getName() {
                return "clientTruststoreType";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.security.keystore.clientTruststoreType";
            }

            public String getDescription() {
                return ""+"Truststore Type.";
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
                return new String[] {"JCEKS"};
            }

            public int getCardinality() {
                return 0;
            }
        };
         
 }
 	