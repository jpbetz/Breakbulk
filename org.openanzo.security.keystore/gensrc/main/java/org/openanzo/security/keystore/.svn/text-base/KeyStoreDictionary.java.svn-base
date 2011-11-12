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
import java.util.Dictionary;
/**
 *   Base configuration properties that are used by ldap authentication provider.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class KeyStoreDictionary{
 	
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
	 @SuppressWarnings("unchecked")
	static public String getKeyFileLocation(Dictionary properties) {
		Object _prop = properties.get(KEY_FILE_LOCATION);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_FILE_LOCATION} property to keyFileLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param keyFileLocation
	 *            value for keyFileLocation
	 */
	 @SuppressWarnings("unchecked")
	static public void setKeyFileLocation(Dictionary properties, String keyFileLocation) {
		if(keyFileLocation==null){
			properties.remove(KEY_FILE_LOCATION);
		}else{
			properties.put(KEY_FILE_LOCATION, keyFileLocation);
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
	  @SuppressWarnings("unchecked")
	static public String getKeyPassword(Dictionary properties) throws org.openanzo.exceptions.AnzoException{
		try{
		Object _prop = properties.get(KEY_PASSWORD);
		
		
		if(_prop==null){
			return "secret";
		}else{
			if(_prop.toString().startsWith("encrypted:")){
				_prop=_prop.toString().substring("encrypted:".length());
				if(_prop.toString().length()>0){
					return org.openanzo.exceptions.EncryptionUtil.decryptBase64(_prop.toString());
				}else{
					return _prop.toString();
				}
			}else{
				return _prop.toString();
			}
		}
		
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
	  @SuppressWarnings("unchecked")
	static public void setKeyPassword(Dictionary properties, String keyPassword) throws org.openanzo.exceptions.AnzoException {
		try{
			if(keyPassword==null){
				properties.remove(KEY_PASSWORD);
			}else{
				keyPassword="encrypted:"+org.openanzo.exceptions.EncryptionUtil.encryptBase64(keyPassword);
				properties.put(KEY_PASSWORD,keyPassword);
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
	 @SuppressWarnings("unchecked")
	static public String getKeystoreType(Dictionary properties) {
		Object _prop = properties.get(KEYSTORE_TYPE);
		
		
		if(_prop==null){
			return "JCEKS";
		}else{
			return _prop.toString();
		}
		
	}
	
	/**
	 * Set {@link #KEYSTORE_TYPE} property to keystoreType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param keystoreType
	 *            value for keystoreType
	 */
	 @SuppressWarnings("unchecked")
	static public void setKeystoreType(Dictionary properties, String keystoreType) {
		if(keystoreType==null){
			properties.remove(KEYSTORE_TYPE);
		}else{
			properties.put(KEYSTORE_TYPE, keystoreType);
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
	 @SuppressWarnings("unchecked")
	static public String getAlgorithm(Dictionary properties) {
		Object _prop = properties.get(KEY_ALGORITHM);
		
		
		if(_prop==null){
			return "AES";
		}else{
			return _prop.toString();
		}
		
	}
	
	/**
	 * Set {@link #KEY_ALGORITHM} property to algorithm in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param algorithm
	 *            value for algorithm
	 */
	 @SuppressWarnings("unchecked")
	static public void setAlgorithm(Dictionary properties, String algorithm) {
		if(algorithm==null){
			properties.remove(KEY_ALGORITHM);
		}else{
			properties.put(KEY_ALGORITHM, algorithm);
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
	 @SuppressWarnings("unchecked")
	static public String getTrustFileLocation(Dictionary properties) {
		Object _prop = properties.get(TRUST_FILE_LOCATION);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #TRUST_FILE_LOCATION} property to trustFileLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param trustFileLocation
	 *            value for trustFileLocation
	 */
	 @SuppressWarnings("unchecked")
	static public void setTrustFileLocation(Dictionary properties, String trustFileLocation) {
		if(trustFileLocation==null){
			properties.remove(TRUST_FILE_LOCATION);
		}else{
			properties.put(TRUST_FILE_LOCATION, trustFileLocation);
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
	  @SuppressWarnings("unchecked")
	static public String getTrustPassword(Dictionary properties) throws org.openanzo.exceptions.AnzoException{
		try{
		Object _prop = properties.get(TRUST_PASSWORD);
		
		
		if(_prop==null){
			return "secret";
		}else{
			if(_prop.toString().startsWith("encrypted:")){
				_prop=_prop.toString().substring("encrypted:".length());
				if(_prop.toString().length()>0){
					return org.openanzo.exceptions.EncryptionUtil.decryptBase64(_prop.toString());
				}else{
					return _prop.toString();
				}
			}else{
				return _prop.toString();
			}
		}
		
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
	  @SuppressWarnings("unchecked")
	static public void setTrustPassword(Dictionary properties, String trustPassword) throws org.openanzo.exceptions.AnzoException {
		try{
			if(trustPassword==null){
				properties.remove(TRUST_PASSWORD);
			}else{
				trustPassword="encrypted:"+org.openanzo.exceptions.EncryptionUtil.encryptBase64(trustPassword);
				properties.put(TRUST_PASSWORD,trustPassword);
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
	 @SuppressWarnings("unchecked")
	static public String getTruststoreType(Dictionary properties) {
		Object _prop = properties.get(TRUSTSTORE_TYPE);
		
		
		if(_prop==null){
			return "JCEKS";
		}else{
			return _prop.toString();
		}
		
	}
	
	/**
	 * Set {@link #TRUSTSTORE_TYPE} property to truststoreType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param truststoreType
	 *            value for truststoreType
	 */
	 @SuppressWarnings("unchecked")
	static public void setTruststoreType(Dictionary properties, String truststoreType) {
		if(truststoreType==null){
			properties.remove(TRUSTSTORE_TYPE);
		}else{
			properties.put(TRUSTSTORE_TYPE, truststoreType);
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
	 @SuppressWarnings("unchecked")
	static public String getClientKeyFileLocation(Dictionary properties) {
		Object _prop = properties.get(CLIENT_KEY_FILE_LOCATION);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #CLIENT_KEY_FILE_LOCATION} property to clientKeyFileLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientKeyFileLocation
	 *            value for clientKeyFileLocation
	 */
	 @SuppressWarnings("unchecked")
	static public void setClientKeyFileLocation(Dictionary properties, String clientKeyFileLocation) {
		if(clientKeyFileLocation==null){
			properties.remove(CLIENT_KEY_FILE_LOCATION);
		}else{
			properties.put(CLIENT_KEY_FILE_LOCATION, clientKeyFileLocation);
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
	  @SuppressWarnings("unchecked")
	static public String getClientKeyPassword(Dictionary properties) throws org.openanzo.exceptions.AnzoException{
		try{
		Object _prop = properties.get(CLIENT_KEY_PASSWORD);
		
		
		if(_prop==null){
			return "secret";
		}else{
			if(_prop.toString().startsWith("encrypted:")){
				_prop=_prop.toString().substring("encrypted:".length());
				if(_prop.toString().length()>0){
					return org.openanzo.exceptions.EncryptionUtil.decryptBase64(_prop.toString());
				}else{
					return _prop.toString();
				}
			}else{
				return _prop.toString();
			}
		}
		
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
	  @SuppressWarnings("unchecked")
	static public void setClientKeyPassword(Dictionary properties, String clientKeyPassword) throws org.openanzo.exceptions.AnzoException {
		try{
			if(clientKeyPassword==null){
				properties.remove(CLIENT_KEY_PASSWORD);
			}else{
				clientKeyPassword="encrypted:"+org.openanzo.exceptions.EncryptionUtil.encryptBase64(clientKeyPassword);
				properties.put(CLIENT_KEY_PASSWORD,clientKeyPassword);
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
	 @SuppressWarnings("unchecked")
	static public String getClientKeystoreType(Dictionary properties) {
		Object _prop = properties.get(CLIENT_KEYSTORE_TYPE);
		
		
		if(_prop==null){
			return "JCEKS";
		}else{
			return _prop.toString();
		}
		
	}
	
	/**
	 * Set {@link #CLIENT_KEYSTORE_TYPE} property to clientKeystoreType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientKeystoreType
	 *            value for clientKeystoreType
	 */
	 @SuppressWarnings("unchecked")
	static public void setClientKeystoreType(Dictionary properties, String clientKeystoreType) {
		if(clientKeystoreType==null){
			properties.remove(CLIENT_KEYSTORE_TYPE);
		}else{
			properties.put(CLIENT_KEYSTORE_TYPE, clientKeystoreType);
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
	 @SuppressWarnings("unchecked")
	static public String getClientTrustFileLocation(Dictionary properties) {
		Object _prop = properties.get(CLIENT_TRUST_FILE_LOCATION);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #CLIENT_TRUST_FILE_LOCATION} property to clientTrustFileLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientTrustFileLocation
	 *            value for clientTrustFileLocation
	 */
	 @SuppressWarnings("unchecked")
	static public void setClientTrustFileLocation(Dictionary properties, String clientTrustFileLocation) {
		if(clientTrustFileLocation==null){
			properties.remove(CLIENT_TRUST_FILE_LOCATION);
		}else{
			properties.put(CLIENT_TRUST_FILE_LOCATION, clientTrustFileLocation);
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
	  @SuppressWarnings("unchecked")
	static public String getClientTrustPassword(Dictionary properties) throws org.openanzo.exceptions.AnzoException{
		try{
		Object _prop = properties.get(CLIENT_TRUST_PASSWORD);
		
		
		if(_prop==null){
			return "secret";
		}else{
			if(_prop.toString().startsWith("encrypted:")){
				_prop=_prop.toString().substring("encrypted:".length());
				if(_prop.toString().length()>0){
					return org.openanzo.exceptions.EncryptionUtil.decryptBase64(_prop.toString());
				}else{
					return _prop.toString();
				}
			}else{
				return _prop.toString();
			}
		}
		
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
	  @SuppressWarnings("unchecked")
	static public void setClientTrustPassword(Dictionary properties, String clientTrustPassword) throws org.openanzo.exceptions.AnzoException {
		try{
			if(clientTrustPassword==null){
				properties.remove(CLIENT_TRUST_PASSWORD);
			}else{
				clientTrustPassword="encrypted:"+org.openanzo.exceptions.EncryptionUtil.encryptBase64(clientTrustPassword);
				properties.put(CLIENT_TRUST_PASSWORD,clientTrustPassword);
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
	 @SuppressWarnings("unchecked")
	static public String getClientTruststoreType(Dictionary properties) {
		Object _prop = properties.get(CLIENT_TRUSTSTORE_TYPE);
		
		
		if(_prop==null){
			return "JCEKS";
		}else{
			return _prop.toString();
		}
		
	}
	
	/**
	 * Set {@link #CLIENT_TRUSTSTORE_TYPE} property to clientTruststoreType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param clientTruststoreType
	 *            value for clientTruststoreType
	 */
	 @SuppressWarnings("unchecked")
	static public void setClientTruststoreType(Dictionary properties, String clientTruststoreType) {
		if(clientTruststoreType==null){
			properties.remove(CLIENT_TRUSTSTORE_TYPE);
		}else{
			properties.put(CLIENT_TRUSTSTORE_TYPE, clientTruststoreType);
		}
	}
 	
 	
 }
 	