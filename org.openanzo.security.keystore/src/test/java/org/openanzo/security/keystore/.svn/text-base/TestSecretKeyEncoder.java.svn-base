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
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import junit.framework.TestCase;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

/**
 * SecretKeystore test
 */
public class TestSecretKeyEncoder extends TestCase {
    //private static final Logger log                    = LoggerFactory.getLogger(TestSecretKeyEncoder.class);

    private static final String KEY_STORE_ENCODING     = "JCEKS";

    private static final char[] TEST_KEYSTORE_PASSWORD = "passw0rd".toCharArray();

    private static final String KEY_NAME               = "test-service-container-key";

    private static final String ALGORITHM              = "AES";

    private ISecretKeystore     encoder;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Load up a keystore from the src/text/resources. We'd rather load up a saved key
        // rather than create a new one every time so that the test is deterministic. 
        KeyStore keyStore = KeyStore.getInstance(KEY_STORE_ENCODING);
        InputStream keystoreStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("testKeystore");
        if (keystoreStream == null) {
            throw new Exception("Could not find keystore.");
        }
        keyStore.load(keystoreStream, TEST_KEYSTORE_PASSWORD);
        Key key;
        if (keyStore.containsAlias(KEY_NAME)) {
            key = keyStore.getKey(KEY_NAME, TEST_KEYSTORE_PASSWORD);
        } else {
            throw new Exception("Could not find test key in test key store.");
        }
        SecretKeyStore encoder = new SecretKeyStore(null, (File) null);
        encoder.initialize((SecretKey) key, ALGORITHM);
        this.encoder = encoder;
    }

    /**
     * @throws Exception
     */
    public void testEncryptAndBase64EncodeString() throws Exception {
        String str = "My string to encrypt, including an uncommon character,\u05D2 (the Hebrew Gimel), to ensure character encoding is handled correctly.";
        String cyphertext = encoder.encryptAndBase64EncodeString(str);
        assertTrue(Base64.isArrayByteBase64(cyphertext.getBytes("UTF-8")));
        String decrypted = encoder.decryptAndBase64DecodeString(cyphertext);
        assertEquals(str, decrypted);
    }

    /**
     * @throws Exception
     */
    public void testEncryptAndBase64EncodeBytes() throws Exception {
        byte[] sample = { 0, 1, 2, 3, 4, 5 };
        String cyphertext = encoder.encryptAndBase64EncodeBytes(sample);
        assertTrue(Base64.isArrayByteBase64(cyphertext.getBytes("UTF-8")));
        byte[] decrypted = encoder.decryptAndBase64DecodeBytes(cyphertext);
        assertTrue(Arrays.equals(sample, decrypted));
    }

    /**
     * @throws Exception
     */
    public void testEncryptString() throws Exception {
        String str = "My string to encrypt, including an uncommon character,\u05D2 (the Hebrew Gimel), to ensure character encoding is handled correctly.";
        byte[] cyphertext = encoder.encryptString(str);
        String decrypted = encoder.decryptString(cyphertext);
        assertEquals(str, decrypted);
    }

    /**
     * @throws Exception
     */
    public void testEncryptBytes() throws Exception {
        byte[] sample = { 0, 1, 2, 3, 4, 5 };
        byte[] cyphertext = encoder.encryptBytes(sample);
        byte[] decrypted = encoder.decryptBytes(cyphertext);
        assertTrue(Arrays.equals(sample, decrypted));
    }

    /**
     * Main method used to generate a keystore. Useful for bootstrapping the first time.
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        File file = new File("testKeystore");
        System.out.println("Generating new keystore to:" + file.getAbsolutePath());

        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        keyStore.load(null, TEST_KEYSTORE_PASSWORD);
        KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
        Key key = kgen.generateKey();
        keyStore.setKeyEntry(KEY_NAME, key, TEST_KEYSTORE_PASSWORD, new Certificate[0]);
        keyStore.store(FileUtils.openOutputStream(file), TEST_KEYSTORE_PASSWORD);
        System.out.println("Done generating keystore.");
    }
}
