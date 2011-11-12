
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
package org.openanzo.security.keystore;
import java.util.Properties;
/**
 *   Base configuration properties that are used by ldap authentication provider.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class KeyStoreProperties{
 	
	/**
	 * Key for property "org.openanzo.security.keystore.keyFileLocation"
	 * The path to the secret keystore.
	 *
	 */
	public static final String	KEY_FILE_LOCATION	= "org.openanzo.security.keystore.keyFileLocation";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.keyPassword"
	 * Password used to protect the secret key in the keystore.
	 *
	 */
	public static final String	KEY_PASSWORD	= "org.openanzo.security.keystore.keyPassword";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.keystoreType"
	 * Keystore Type.
	 *
	 */
	public static final String	KEYSTORE_TYPE	= "org.openanzo.security.keystore.keystoreType";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.algorithm"
	 * Algorithm to use for encrypting data. This is a transformation string of the format accepted by the javax.crypto.Cipher#getInstance method. The default is 'AES'.
	 *
	 */
	public static final String	KEY_ALGORITHM	= "org.openanzo.security.keystore.algorithm";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.trustFileLocation"
	 * The path to the secret truststore.
	 *
	 */
	public static final String	TRUST_FILE_LOCATION	= "org.openanzo.security.keystore.trustFileLocation";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.trustPassword"
	 * Password used to protect the secret key in the truststore.
	 *
	 */
	public static final String	TRUST_PASSWORD	= "org.openanzo.security.keystore.trustPassword";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.truststoreType"
	 * Truststore Type.
	 *
	 */
	public static final String	TRUSTSTORE_TYPE	= "org.openanzo.security.keystore.truststoreType";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.clientKeyFileLocation"
	 * The path to the secret keystore.
	 *
	 */
	public static final String	CLIENT_KEY_FILE_LOCATION	= "org.openanzo.security.keystore.clientKeyFileLocation";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.clientKeyPassword"
	 * Password used to protect the secret key in the keystore.
	 *
	 */
	public static final String	CLIENT_KEY_PASSWORD	= "org.openanzo.security.keystore.clientKeyPassword";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.clientKeystoreType"
	 * Keystore Type.
	 *
	 */
	public static final String	CLIENT_KEYSTORE_TYPE	= "org.openanzo.security.keystore.clientKeystoreType";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.clientTrustFileLocation"
	 * The path to the secret truststore.
	 *
	 */
	public static final String	CLIENT_TRUST_FILE_LOCATION	= "org.openanzo.security.keystore.clientTrustFileLocation";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.clientTrustPassword"
	 * Password used to protect the secret key in the truststore.
	 *
	 */
	public static final String	CLIENT_TRUST_PASSWORD	= "org.openanzo.security.keystore.clientTrustPassword";
 	
	/**
	 * Key for property "org.openanzo.security.keystore.clientTruststoreType"
	 * Truststore Type.
	 *
	 */
	public static final String	CLIENT_TRUSTSTORE_TYPE	= "org.openanzo.security.keystore.clientTruststoreType";
 	
 	/**
	 * Get {@link #KEY_FILE_LOCATION} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_FILE_LOCATION} if not present
	 */
	static public String getKeyFileLocation(Properties properties) {
		return properties.getProperty(KEY_FILE_LOCATION);
	}
	
	/**
	 * Set {@link #KEY_FILE_LOCATION} property to keyFileLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param keyFileLocation
	 *            value for keyFileLocation
	 */
	static public void setKeyFileLocation(Properties properties, String keyFileLocation) {
		if(keyFileLocation==null){
			properties.remove(KEY_FILE_LOCATION);
		}else{
			properties.setProperty(KEY_FILE_LOCATION, keyFileLocation);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_PASSWORD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_PASSWORD},or "secret"  if not present
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception decrypting value
	 */
	static public String getKeyPassword(Properties properties)  throws org.openanzo.exceptions.AnzoException{
		try{
		String result= properties.getProperty(KEY_PASSWORD
		);
		
		if(result==null){
			result="secret";
		}else{
			if(result.startsWith("encrypted:")){
				result=result.substring("encrypted:".length());
				if(result.length()>0){
					result=org.openanzo.exceptions.EncryptionUtil.decryptBase64(result);
				}
			}
		}
		
		return result;
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
	
	/**
	 * Set {@link #KEY_PASSWORD} property to keyPassword in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param keyPassword
	 *            value for keyPassword
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception encrypting value
	 */
	static public void setKeyPassword(Properties properties, String keyPassword)  throws org.openanzo.exceptions.AnzoException{
		try{if(keyPassword==null){
			properties.remove(KEY_PASSWORD);
		}else{
			keyPassword=org.openanzo.exceptions.EncryptionUtil.encryptBase64(keyPassword);
			properties.setProperty(KEY_PASSWORD, "encrypted:"+keyPassword);
		}
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEYSTORE_TYPE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEYSTORE_TYPE},or "JCEKS"  if not present
	 */
	static public String getKeystoreType(Properties properties) {
		return properties.getProperty(KEYSTORE_TYPE,"JCEKS");
	}
	
	/**
	 * Set {@link #KEYSTORE_TYPE} property to keystoreType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param keystoreType
	 *            value for keystoreType
	 */
	static public void setKeystoreType(Properties properties, String keystoreType) {
		if(keystoreType==null){
			properties.remove(KEYSTORE_TYPE);
		}else{
			properties.setProperty(KEYSTORE_TYPE, keystoreType);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_ALGORITHM} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_ALGORITHM},or "AES"  if not present
	 */
	static public String getAlgorithm(Properties properties) {
		return properties.getProperty(KEY_ALGORITHM,"AES");
	}
	
	/**
	 * Set {@link #KEY_ALGORITHM} property to algorithm in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param algorithm
	 *            value for algorithm
	 */
	static public void setAlgorithm(Properties properties, String algorithm) {
		if(algorithm==null){
			properties.remove(KEY_ALGORITHM);
		}else{
			properties.setProperty(KEY_ALGORITHM, algorithm);
		}
	}
 	
 	
 	/**
	 * Get {@link #TRUST_FILE_LOCATION} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #TRUST_FILE_LOCATION} if not present
	 */
	static public String getTrustFileLocation(Properties properties) {
		return properties.getProperty(TRUST_FILE_LOCATION);
	}
	
	/**
	 * Set {@link #TRUST_FILE_LOCATION} property to trustFileLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param trustFileLocation
	 *            value for trustFileLocation
	 */
	static public void setTrustFileLocation(Properties properties, String trustFileLocation) {
		if(trustFileLocation==null){
			properties.remove(TRUST_FILE_LOCATION);
		}else{
			properties.setProperty(TRUST_FILE_LOCATION, trustFileLocation);
		}
	}
 	
 	
 	/**
	 * Get {@link #TRUST_PASSWORD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #TRUST_PASSWORD},or "secret"  if not present
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception decrypting value
	 */
	static public String getTrustPassword(Properties properties)  throws org.openanzo.exceptions.AnzoException{
		try{
		String result= properties.getProperty(TRUST_PASSWORD
		);
		
		if(result==null){
			result="secret";
		}else{
			if(result.startsWith("encrypted:")){
				result=result.substring("encrypted:".length());
				if(result.length()>0){
					result=org.openanzo.exceptions.EncryptionUtil.decryptBase64(result);
				}
			}
		}
		
		return result;
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
	
	/**
	 * Set {@link #TRUST_PASSWORD} property to trustPassword in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param trustPassword
	 *            value for trustPassword
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception encrypting value
	 */
	static public void setTrustPassword(Properties properties, String trustPassword)  throws org.openanzo.exceptions.AnzoException{
		try{if(trustPassword==null){
			properties.remove(TRUST_PASSWORD);
		}else{
			trustPassword=org.openanzo.exceptions.EncryptionUtil.encryptBase64(trustPassword);
			properties.setProperty(TRUST_PASSWORD, "encrypted:"+trustPassword);
		}
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
 	
 	
 	/**
	 * Get {@link #TRUSTSTORE_TYPE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #TRUSTSTORE_TYPE},or "JCEKS"  if not present
	 */
	static public String getTruststoreType(Properties properties) {
		return properties.getProperty(TRUSTSTORE_TYPE,"JCEKS");
	}
	
	/**
	 * Set {@link #TRUSTSTORE_TYPE} property to truststoreType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param truststoreType
	 *            value for truststoreType
	 */
	static public void setTruststoreType(Properties properties, String truststoreType) {
		if(truststoreType==null){
			properties.remove(TRUSTSTORE_TYPE);
		}else{
			properties.setProperty(TRUSTSTORE_TYPE, truststoreType);
		}
	}
 	
 	
 	/**
	 * Get {@link #CLIENT_KEY_FILE_LOCATION} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #CLIENT_KEY_FILE_LOCATION} if not present
	 */
	static public String getClientKeyFileLocation(Properties properties) {
		return properties.getProperty(CLIENT_KEY_FILE_LOCATION);
	}
	
	/**
	 * Set {@link #CLIENT_KEY_FILE_LOCATION} property to clientKeyFileLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientKeyFileLocation
	 *            value for clientKeyFileLocation
	 */
	static public void setClientKeyFileLocation(Properties properties, String clientKeyFileLocation) {
		if(clientKeyFileLocation==null){
			properties.remove(CLIENT_KEY_FILE_LOCATION);
		}else{
			properties.setProperty(CLIENT_KEY_FILE_LOCATION, clientKeyFileLocation);
		}
	}
 	
 	
 	/**
	 * Get {@link #CLIENT_KEY_PASSWORD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #CLIENT_KEY_PASSWORD},or "secret"  if not present
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception decrypting value
	 */
	static public String getClientKeyPassword(Properties properties)  throws org.openanzo.exceptions.AnzoException{
		try{
		String result= properties.getProperty(CLIENT_KEY_PASSWORD
		);
		
		if(result==null){
			result="secret";
		}else{
			if(result.startsWith("encrypted:")){
				result=result.substring("encrypted:".length());
				if(result.length()>0){
					result=org.openanzo.exceptions.EncryptionUtil.decryptBase64(result);
				}
			}
		}
		
		return result;
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
	
	/**
	 * Set {@link #CLIENT_KEY_PASSWORD} property to clientKeyPassword in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientKeyPassword
	 *            value for clientKeyPassword
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception encrypting value
	 */
	static public void setClientKeyPassword(Properties properties, String clientKeyPassword)  throws org.openanzo.exceptions.AnzoException{
		try{if(clientKeyPassword==null){
			properties.remove(CLIENT_KEY_PASSWORD);
		}else{
			clientKeyPassword=org.openanzo.exceptions.EncryptionUtil.encryptBase64(clientKeyPassword);
			properties.setProperty(CLIENT_KEY_PASSWORD, "encrypted:"+clientKeyPassword);
		}
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
 	
 	
 	/**
	 * Get {@link #CLIENT_KEYSTORE_TYPE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #CLIENT_KEYSTORE_TYPE},or "JCEKS"  if not present
	 */
	static public String getClientKeystoreType(Properties properties) {
		return properties.getProperty(CLIENT_KEYSTORE_TYPE,"JCEKS");
	}
	
	/**
	 * Set {@link #CLIENT_KEYSTORE_TYPE} property to clientKeystoreType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientKeystoreType
	 *            value for clientKeystoreType
	 */
	static public void setClientKeystoreType(Properties properties, String clientKeystoreType) {
		if(clientKeystoreType==null){
			properties.remove(CLIENT_KEYSTORE_TYPE);
		}else{
			properties.setProperty(CLIENT_KEYSTORE_TYPE, clientKeystoreType);
		}
	}
 	
 	
 	/**
	 * Get {@link #CLIENT_TRUST_FILE_LOCATION} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #CLIENT_TRUST_FILE_LOCATION} if not present
	 */
	static public String getClientTrustFileLocation(Properties properties) {
		return properties.getProperty(CLIENT_TRUST_FILE_LOCATION);
	}
	
	/**
	 * Set {@link #CLIENT_TRUST_FILE_LOCATION} property to clientTrustFileLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientTrustFileLocation
	 *            value for clientTrustFileLocation
	 */
	static public void setClientTrustFileLocation(Properties properties, String clientTrustFileLocation) {
		if(clientTrustFileLocation==null){
			properties.remove(CLIENT_TRUST_FILE_LOCATION);
		}else{
			properties.setProperty(CLIENT_TRUST_FILE_LOCATION, clientTrustFileLocation);
		}
	}
 	
 	
 	/**
	 * Get {@link #CLIENT_TRUST_PASSWORD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #CLIENT_TRUST_PASSWORD},or "secret"  if not present
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception decrypting value
	 */
	static public String getClientTrustPassword(Properties properties)  throws org.openanzo.exceptions.AnzoException{
		try{
		String result= properties.getProperty(CLIENT_TRUST_PASSWORD
		);
		
		if(result==null){
			result="secret";
		}else{
			if(result.startsWith("encrypted:")){
				result=result.substring("encrypted:".length());
				if(result.length()>0){
					result=org.openanzo.exceptions.EncryptionUtil.decryptBase64(result);
				}
			}
		}
		
		return result;
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
	
	/**
	 * Set {@link #CLIENT_TRUST_PASSWORD} property to clientTrustPassword in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientTrustPassword
	 *            value for clientTrustPassword
	 * @throws org.openanzo.exceptions.AnzoException if there is an exception encrypting value
	 */
	static public void setClientTrustPassword(Properties properties, String clientTrustPassword)  throws org.openanzo.exceptions.AnzoException{
		try{if(clientTrustPassword==null){
			properties.remove(CLIENT_TRUST_PASSWORD);
		}else{
			clientTrustPassword=org.openanzo.exceptions.EncryptionUtil.encryptBase64(clientTrustPassword);
			properties.setProperty(CLIENT_TRUST_PASSWORD, "encrypted:"+clientTrustPassword);
		}
		}catch(Exception e){
			 throw new org.openanzo.exceptions.AnzoException( org.openanzo.exceptions.ExceptionConstants.IO.PROPERTIES_ERROR, e);
		}
	}
 	
 	
 	/**
	 * Get {@link #CLIENT_TRUSTSTORE_TYPE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #CLIENT_TRUSTSTORE_TYPE},or "JCEKS"  if not present
	 */
	static public String getClientTruststoreType(Properties properties) {
		return properties.getProperty(CLIENT_TRUSTSTORE_TYPE,"JCEKS");
	}
	
	/**
	 * Set {@link #CLIENT_TRUSTSTORE_TYPE} property to clientTruststoreType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientTruststoreType
	 *            value for clientTruststoreType
	 */
	static public void setClientTruststoreType(Properties properties, String clientTruststoreType) {
		if(clientTruststoreType==null){
			properties.remove(CLIENT_TRUSTSTORE_TYPE);
		}else{
			properties.setProperty(CLIENT_TRUSTSTORE_TYPE, clientTruststoreType);
		}
	}
 	
 	
 }
 	