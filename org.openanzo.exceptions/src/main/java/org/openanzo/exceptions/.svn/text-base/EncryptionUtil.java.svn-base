/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 21, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.exceptions;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class EncryptionUtil {

    static private Cipher encryptCipher = null;

    static private Cipher decryptCipher = null;
    static {
        try {
            String password = "anzoEncryptionKey";
            DESKeySpec key = new DESKeySpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

            encryptCipher = Cipher.getInstance("DES");
            decryptCipher = Cipher.getInstance("DES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, keyFactory.generateSecret(key));
            decryptCipher.init(Cipher.DECRYPT_MODE, keyFactory.generateSecret(key));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Encrypt a string using DES encryption, and return the encrypted string as a base64 encoded string.
     * 
     * @param unencryptedString
     *            The string to encrypt.
     * @return String The DES encrypted and base 64 encoded string.
     * @throws Exception
     *             If an error occurs.
     */
    static public String encryptBase64(String unencryptedString) throws Exception {
        // Encode the string into bytes using utf-8
        byte[] unencryptedByteArray = unencryptedString.getBytes("UTF8");

        // Encrypt
        byte[] encryptedBytes = encryptCipher.doFinal(unencryptedByteArray);

        // Encode bytes to base64 to get a string
        byte[] encodedBytes = Base64.encodeBase64(encryptedBytes);

        return new String(encodedBytes);
    }

    /**
     * Decrypt a base64 encoded, DES encrypted string and return the unencrypted string.
     * 
     * @param encryptedString
     *            The base64 encoded string to decrypt.
     * @return String The decrypted string.
     * @throws Exception
     *             If an error occurs.
     */
    static public String decryptBase64(String encryptedString) throws Exception {
        // Encode bytes to base64 to get a string
        byte[] decodedBytes = Base64.decodeBase64(encryptedString.getBytes());

        // Decrypt
        byte[] unencryptedByteArray = decryptCipher.doFinal(decodedBytes);

        // Decode using utf-8
        return new String(unencryptedByteArray, "UTF8");
    }

}
