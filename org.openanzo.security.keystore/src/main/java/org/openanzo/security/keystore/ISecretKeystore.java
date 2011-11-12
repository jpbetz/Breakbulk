/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 15, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.security.keystore;

import org.openanzo.exceptions.AnzoException;

/**
 * Component for encrypting strings and for handling the encrypted data in base64 encoding. The various encryption and decryption methods should be used in
 * their corresponding pairs or the data may be corrupted. In particular:
 * <ul>
 * <li>encryptAndBase64EncodeString corresponds to decryptAndBase64DecodeString</li>
 * <li>encryptAndBase64EncodeBytes corresponds to decryptAndBase64DecodeBytes</li>
 * <li>encryptString corresponds to decryptString</li>
 * <li>encryptBytes corresponds to decryptBytes</li>
 * </ul>
 * Mixing calls that don't correspond as described above can cause data corruption. For example,
 * <code>new String(decryptBytes(encryptString("my plaintext")))</code>, will compile but the result from <code>decryptBytes</code> may be incorrect due to
 * character encoding issues. If you ensure that the corresponding methods are used together, then no corruption due to character encoding issues can happen.
 * 
 * Similarly, decrypting base64-encoded data which was base64-encoded outside of this class could cause data corruption. Different base64 encoding
 * implementations may use different alphabets, may chunk the text into various lines, and may pad the text differently. The best practice is to only use these
 * methods to decrypt data which was encrypted with the corresponding method.
 * 
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 * 
 */
public interface ISecretKeystore {

    /**
     * Encrypts the given string and base64 encodes the encrypted data. The Base64 encoding doesn't chunk the data into fixed-width lines.
     * 
     * To avoid data corruption due to character-encoding issues, you should only decrypt the results with the {@link #decryptAndBase64DecodeString(String)}
     * method.
     * 
     * @param plaintext
     *            string to encrypt
     * @return base64-encoded encrypted string.
     * @throws AnzoException
     */
    public abstract String encryptAndBase64EncodeString(String plaintext) throws AnzoException;

    /**
     * Encrypts the given byte array and base64 encodes it. The Base64 encoding doesn't chunk the data into fixed-width lines.
     * 
     * To avoid data corruption due to character-encoding issues, you should only decrypt the results with the {@link #decryptAndBase64DecodeBytes(String)}
     * method.
     * 
     * @param plaintext
     *            bytes to encrypt
     * @return base64-encoded encrypted string.
     * @throws AnzoException
     */
    public abstract String encryptAndBase64EncodeBytes(byte plaintext[]) throws AnzoException;

    /**
     * Encrypts the given string.
     * 
     * To avoid data corruption due to character-encoding issues, you should only decrypt the results with the {@link #decryptString(byte[])} method.
     * 
     * @param plaintext
     *            string to encrypt
     * @return encrypted data
     * @throws AnzoException
     */
    public abstract byte[] encryptString(String plaintext) throws AnzoException;

    /**
     * Encrypts the given bytes.
     * 
     * To avoid data corruption due to character-encoding issues, you should only decrypt the results with the {@link #decryptBytes(byte[])} method.
     * 
     * @param plaintext
     *            bytes to encrypt
     * @return encrypted data
     * @throws AnzoException
     */
    public abstract byte[] encryptBytes(byte plaintext[]) throws AnzoException;

    /**
     * Decodes the given base64-encoded string and then decrypts the decoded string.
     * 
     * To avoid data corruption due to character-encoding issues, you should only use this to decrypt strings that were encrypted by the
     * {@link #encryptAndBase64EncodeString(String)} method.
     * 
     * @param base64encodedCyphertext
     *            string to decrypt
     * @return decrypted string
     * @throws AnzoException
     */
    public abstract String decryptAndBase64DecodeString(String base64encodedCyphertext) throws AnzoException;

    /**
     * Decodes the given base64-encoded string and then decrypts the decoded data.
     * 
     * To avoid data corruption due to character-encoding issues, you should only use this to decrypt data that was encrypted by the
     * {@link #encryptAndBase64EncodeBytes(byte[])} method.
     * 
     * @param base64encodedCyphertext
     *            string to decrypt
     * @return decrypted bytes
     * @throws AnzoException
     */
    public abstract byte[] decryptAndBase64DecodeBytes(String base64encodedCyphertext) throws AnzoException;

    /**
     * Decrypts the given data into a string.
     * 
     * To avoid data corruption due to character-encoding issues, you should only use this to decrypt strings that were encrypted by the
     * {@link #encryptString(String)} method.
     * 
     * @param cyphertext
     *            data to decrypt
     * @return decrypted string
     * @throws AnzoException
     */
    public abstract String decryptString(byte cyphertext[]) throws AnzoException;

    /**
     * Decrypts the given data.
     * 
     * To avoid data corruption due to character-encoding issues, you should only use this to decrypt data that was encrypted by the
     * {@link #encryptBytes(byte[])} method.
     * 
     * @param cyphertext
     *            data to decrypt
     * @return decrypted data
     * @throws AnzoException
     */
    public abstract byte[] decryptBytes(byte cyphertext[]) throws AnzoException;

    /**
     * Start the keystore
     * 
     * @throws AnzoException
     */
    public void start() throws AnzoException;

    /**
     * Stop the keystore
     * 
     * @throws AnzoException
     */
    public void stop() throws AnzoException;
}
