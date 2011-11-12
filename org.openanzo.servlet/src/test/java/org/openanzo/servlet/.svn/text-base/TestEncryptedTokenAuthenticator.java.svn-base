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
package org.openanzo.servlet;

import java.io.File;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.util.ArrayList;

import javax.crypto.SecretKey;

import junit.framework.TestCase;

import org.openanzo.security.keystore.ISecretKeystore;
import org.openanzo.security.keystore.SecretKeyStore;
import org.openanzo.servlet.EncryptedTokenAuthenticator.Token;

/**
 * Tests for the EncryptedTokenAuthenticator.
 * 
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */
public class TestEncryptedTokenAuthenticator extends TestCase {

    //private static final Logger         log                    = LoggerFactory.getLogger(TestEncryptedTokenAuthenticator.class);

    private static final String         KEY_STORE_ENCODING     = "JCEKS";

    private static final char[]         TEST_KEYSTORE_PASSWORD = "passw0rd".toCharArray();

    private static final String         KEY_NAME               = "test-service-container-key";

    private static final String         ALGORITHM              = "AES";

    private EncryptedTokenAuthenticator authenticator;

    private ISecretKeystore             encoder;

    @Override
    protected void setUp() throws Exception {

        // Load up a keystore from the src/text/resources. We'd rather load up a saved key
        // rather than create a new one every time so that the test is deterministic. 
        KeyStore keyStore = KeyStore.getInstance(KEY_STORE_ENCODING);
        InputStream keystoreStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("org/openanzo/servlet/testKeystore");
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

        authenticator = new EncryptedTokenAuthenticator(null, SecurityConstraint.NONE, null, encoder, "", null, new ArrayList<PathSpec>() {
            private static final long serialVersionUID = 1L;

            {
                add(new PathSpec("/*"));
            }
        });
    }

    /**
     * @throws Exception
     */
    public void testCreateEncryptedToken() throws Exception {
        String token = authenticator.createEncryptedToken("cooluser", "127.0.0.1");
        assertTrue(token.length() > 0);
        assertTrue(token.indexOf("cooluser") == -1); // rough check to make sure it was encrypted.

        String decryptedToken = encoder.decryptAndBase64DecodeString(token);
        int firstDelimiter = decryptedToken.indexOf(EncryptedTokenAuthenticator.TOKEN_DELIMITER);
        assertTrue(firstDelimiter != -1);
        String timestr = decryptedToken.substring(0, firstDelimiter);
        String addressAndUser = decryptedToken.substring(firstDelimiter + 1);
        Long.parseLong(timestr); // will throw exception is format is wrong
        assertEquals("127.0.0.1;cooluser", addressAndUser);

    }

    /**
     * @throws Exception
     */
    public void testParseAnzoToken() throws Exception {
        String cryptedtoken = authenticator.createEncryptedToken("cooluser", "127.0.0.1");
        Token token = authenticator.parseAnzoToken(cryptedtoken);
        assertEquals("cooluser", token.getUsername());
        assertEquals("127.0.0.1", token.getRemoteAddress());
    }

    /**
     * @throws Exception
     */
    public void testParseAnzoTokenHandlesIPV6Address() throws Exception {
        String cryptedtoken = authenticator.createEncryptedToken("cooluser", "2001:0db8:85a3:08d3:1319:8a2e:0370:7334");
        Token token = authenticator.parseAnzoToken(cryptedtoken);
        assertEquals("cooluser", token.getUsername());
        assertEquals("2001:0db8:85a3:08d3:1319:8a2e:0370:7334", token.getRemoteAddress());
    }

    /**
     * @throws Exception
     */
    public void testParseAnzoTokenAllowsDelimitersInUsername() throws Exception {
        String username = EncryptedTokenAuthenticator.TOKEN_DELIMITER + "my" + EncryptedTokenAuthenticator.TOKEN_DELIMITER + "cool" + EncryptedTokenAuthenticator.TOKEN_DELIMITER + "user" + EncryptedTokenAuthenticator.TOKEN_DELIMITER;
        String cryptedtoken = authenticator.createEncryptedToken(username, "2001:0db8:85a3:08d3:1319:8a2e:0370:7334");
        Token token = authenticator.parseAnzoToken(cryptedtoken);
        assertEquals(username, token.getUsername());
        assertEquals("2001:0db8:85a3:08d3:1319:8a2e:0370:7334", token.getRemoteAddress());
    }

    /**
     * @throws Exception
     */
    public void testParseAnzoTokenFailsForEmptySections() throws Exception {
        {
            // missing username
            String cryptedtoken = authenticator.createEncryptedToken("", "2001:0db8:85a3:08d3:1319:8a2e:0370:7334");
            Token token = authenticator.parseAnzoToken(cryptedtoken);
            assertNull(token);
        }
        {
            // missing IP address
            String cryptedtoken = authenticator.createEncryptedToken("cooluser", "");
            Token token = authenticator.parseAnzoToken(cryptedtoken);
            assertNull(token);
        }
        {
            // missing username and IP address
            String cryptedtoken = authenticator.createEncryptedToken("", "");
            Token token = authenticator.parseAnzoToken(cryptedtoken);
            assertNull(token);
        }
        {
            // missing timestamp
            String cryptedtoken = encoder.encryptAndBase64EncodeString(EncryptedTokenAuthenticator.TOKEN_DELIMITER + "2001:0db8:85a3:08d3:1319:8a2e:0370:7334" + EncryptedTokenAuthenticator.TOKEN_DELIMITER + "cooluser");
            Token token = authenticator.parseAnzoToken(cryptedtoken);
            assertNull(token);
        }
        {
            // only delimiters
            String cryptedtoken = encoder.encryptAndBase64EncodeString(EncryptedTokenAuthenticator.TOKEN_DELIMITER + EncryptedTokenAuthenticator.TOKEN_DELIMITER);
            Token token = authenticator.parseAnzoToken(cryptedtoken);
            assertNull(token);
        }
        {
            // empty string
            Token token = authenticator.parseAnzoToken("");
            assertNull(token);
        }
    }

}
