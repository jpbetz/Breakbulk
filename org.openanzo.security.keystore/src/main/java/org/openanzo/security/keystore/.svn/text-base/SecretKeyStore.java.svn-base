/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.security.keystore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Dictionary;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A component used for encrypting and decrypting data based on a secret key held by the component. Encryption is done with a symmetric cypher with a secret key
 * saved to a keystore.
 * 
 * Be careful to only encrypt and decrypt using corresponding methods. See {@link ISecretKeystore} for more information.
 * 
 * @author Jordi Albornoz Mulligan <jordi@cambridgesemantics.com>
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 */
public class SecretKeyStore implements ISecretKeystore {
    private static final Logger log                = LoggerFactory.getLogger(SecretKeyStore.class);

    /** Prefix for loading a resource URL */
    public static final String  resourcePrefix     = "resource:";

    private static final String KEY_NAME           = "service-container-key";

    private static final String KEY_STORE_ENCODING = "JCEKS";

    private static final String STRING_ENCODING    = "UTF-8";

    private File                dataDirectory      = null;

    private String              algorithm;

    private SecretKey           skey;

    private BundleContext       bundleContext      = null;

    @SuppressWarnings("unchecked")
    private Dictionary          configurationProperties;

    /**
     * Create a secret key store
     * 
     * @param configurationProperties
     *            configuration properties for secret key store
     * @param dataDirectory
     *            directory for the keystore
     */
    public SecretKeyStore(Dictionary<? extends Object, ? extends Object> configurationProperties, File dataDirectory) {
        this.configurationProperties = configurationProperties;
        this.dataDirectory = dataDirectory;
    }

    public void start() throws AnzoException {
        String filelocation = KeyStoreDictionary.getKeyFileLocation(configurationProperties);
        String keyPassword = KeyStoreDictionary.getKeyPassword(configurationProperties);
        String algorithm = KeyStoreDictionary.getAlgorithm(configurationProperties);
        String keystoreType = KeyStoreDictionary.getKeystoreType(configurationProperties);
        if (StringUtils.isEmpty(algorithm)) {
            algorithm = "AES";
        }
        if (StringUtils.isEmpty(keystoreType)) {
            keystoreType = KEY_STORE_ENCODING;
        }
        if (StringUtils.isEmpty(keyPassword)) {
            log.info("Using default key password since no '{}' specified in configuration.", KeyStoreDictionary.KEY_PASSWORD);
            keyPassword = "secret";
        }
        if (StringUtils.isEmpty(filelocation)) {
            throw new AnzoException(ExceptionConstants.OSGI.MISSING_COMPONENT_PARAMETER, KeyStoreDictionary.KEY_FILE_LOCATION);
        }
        log.info("Using keyLocation ('{}') and algorithm ('{}').", filelocation, algorithm);

        this.algorithm = algorithm; // The loadKey method may need to use this.algorithm so we set it here.

        InputStream inputStream = null;
        try {
            File keyStoreFile = null;
            if (filelocation.startsWith(resourcePrefix) && bundleContext != null) { // handle resource:/ file locations
                String resourceLocation = filelocation.substring(resourcePrefix.length());
                URL resourceUrl = bundleContext.getBundle().getResource(resourceLocation);
                if (resourceUrl == null) {
                    throw new AnzoException(ExceptionConstants.IO.READ_ERROR, resourceLocation);
                }
                inputStream = resourceUrl.openStream();
            } else {
                keyStoreFile = (filelocation.startsWith(".") && dataDirectory != null) ? new File(dataDirectory, filelocation) : new File(filelocation);
                if (keyStoreFile.exists()) {
                    inputStream = new FileInputStream(keyStoreFile);
                } else {
                    log.warn("Could not find keystore at '{}'. Creating a new keystore at that location.", keyStoreFile.getAbsolutePath());
                }
            }
            SecretKey key = loadKey(inputStream, keyPassword, keyStoreFile, keystoreType);
            initialize(key, algorithm);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("error closing keystore input stream", e);
                }
            }
        }
    }

    public void stop() throws AnzoException {
    }

    /**
     * Initialize the encoder based on the given configuration. This method is typically only used by unit tests.
     * 
     * @param key
     * @param algorithm
     * @throws AnzoException
     */
    public void initialize(SecretKey key, String algorithm) throws AnzoException {
        this.algorithm = algorithm;
        this.skey = key;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.security.SecretKeyEncoder#encryptAndBase64EncodeString(java.lang.String)
     */
    public String encryptAndBase64EncodeString(String plaintext) throws AnzoException {
        byte[] plainbytes;
        try {
            plainbytes = plaintext.getBytes(STRING_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
        return encryptAndBase64EncodeBytes(plainbytes);
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.security.SecretKeyEncoder#encryptAndBase64EncodeBytes(byte[])
     */
    public String encryptAndBase64EncodeBytes(byte plaintext[]) throws AnzoException {
        byte[] cypherbytes = encryptBytes(plaintext);
        byte[] encodedCypherbytes = Base64.encodeBase64(cypherbytes);
        String encodedEncryptedStr;
        try {
            encodedEncryptedStr = new String(encodedCypherbytes, STRING_ENCODING); // base64 is ASCII so we use an ASCII compatible encoding to create the String.
        } catch (UnsupportedEncodingException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
        return encodedEncryptedStr;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.security.SecretKeyEncoder#encryptString(java.lang.String)
     */
    public byte[] encryptString(String plaintext) throws AnzoException {
        byte[] plainbytes;
        try {
            plainbytes = plaintext.getBytes(STRING_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
        return encryptBytes(plainbytes);
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.security.SecretKeyEncoder#encryptBytes(byte[])
     */
    public byte[] encryptBytes(byte plaintext[]) throws AnzoException {
        byte[] cyphertext;
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            cyphertext = cipher.doFinal(plaintext);
        } catch (GeneralSecurityException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
        return cyphertext;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.security.SecretKeyEncoder#decryptAndBase64DecodeString(java.lang.String)
     */
    public String decryptAndBase64DecodeString(String base64encodedCyphertext) throws AnzoException {
        byte[] cypherbytes;
        try {
            byte[] base64encodedCypherbytes = base64encodedCyphertext.getBytes(STRING_ENCODING);
            cypherbytes = Base64.decodeBase64(base64encodedCypherbytes);
        } catch (UnsupportedEncodingException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
        return decryptString(cypherbytes);
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.security.SecretKeyEncoder#decryptAndBase64DecodeBytes(java.lang.String)
     */
    public byte[] decryptAndBase64DecodeBytes(String base64encodedCyphertext) throws AnzoException {
        byte[] plaintext;
        try {
            byte[] base64encodedCypherbytes = base64encodedCyphertext.getBytes(STRING_ENCODING);
            byte[] cypherbytes = Base64.decodeBase64(base64encodedCypherbytes);
            plaintext = decryptBytes(cypherbytes);
        } catch (UnsupportedEncodingException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
        return plaintext;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.security.SecretKeyEncoder#decryptString(byte[])
     */
    public String decryptString(byte cyphertext[]) throws AnzoException {
        String plaintext;
        try {
            byte[] plainbytes = decryptBytes(cyphertext);
            plaintext = new String(plainbytes, STRING_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
        return plaintext;
    }

    /* (non-Javadoc)
     * @see org.openanzo.server.security.SecretKeyEncoder#decryptBytes(byte[])
     */
    public byte[] decryptBytes(byte cyphertext[]) throws AnzoException {
        byte[] plaintext;
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, skey);
            plaintext = cipher.doFinal(cyphertext);
        } catch (GeneralSecurityException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
        return plaintext;
    }

    /**
     * Loads the secret key to use for encryption and decryption. It will read the key from the keystore if it exists. Otherwise it will create a new randomly
     * generated key and save it in a keystore at the given file. It will use the algorithm defined in the <code>algorithm</code> member.
     * 
     * @param keyStoreStream
     *            stream from which to read the keystore which holds the secret key. If null, a new keystore is created.
     * @param password
     *            password used to protect the and integrity-check the secret key.
     * @param keyStoreDestination
     *            File path to which to save the keystore in case it is newly created or a new key was added. If null, then nothing is written out.
     * @return the loaded or newly generated secret key.
     * @throws AnzoException
     */
    private SecretKey loadKey(InputStream keyStoreStream, String password, File keyStoreDestination, String keystoreType) throws AnzoException {

        try {
            KeyStore keyStore = KeyStore.getInstance(keystoreType);
            keyStore.load(keyStoreStream, password.toCharArray());

            Key key = null;
            if (keyStore.containsAlias(KEY_NAME)) {
                key = keyStore.getKey(KEY_NAME, password.toCharArray());
            } else {
                log.warn("Could not find key '{}' within keystore. Generating a new key.", KEY_NAME);
                KeyGenerator kgen = KeyGenerator.getInstance(algorithm);
                key = kgen.generateKey();
                keyStore.setKeyEntry(KEY_NAME, key, password.toCharArray(), new Certificate[0]);
                if (keyStoreDestination != null) {
                    log.warn("Storing new key in the keystore.");
                    OutputStream outputStream = null;
                    try {
                        outputStream = FileUtils.openOutputStream(keyStoreDestination);
                        keyStore.store(outputStream, password.toCharArray());
                    } finally {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    }

                }
            }

            if (!(key instanceof SecretKey))
                throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, "key must be of type SecretKey: " + key);
            return (SecretKey) key;
        } catch (GeneralSecurityException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }

    }

}
