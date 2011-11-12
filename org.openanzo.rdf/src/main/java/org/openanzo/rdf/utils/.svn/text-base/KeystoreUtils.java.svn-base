/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 22, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class KeystoreUtils {

    private static final Logger log = LoggerFactory.getLogger(KeystoreUtils.class);

    /**
     * 
     * @param filename
     * @param password
     * @param store
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public static final void writeStoreToFile(String filename, String password, KeyStore store) throws IOException, GeneralSecurityException {
        OutputStream outputStream = null;
        try {
            outputStream = org.apache.commons.io.FileUtils.openOutputStream(new File(filename));
            store.store(outputStream, password.toCharArray());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    /**
     * 
     * @param keyStoreFile
     * @param keystoreType
     * @param password
     * @param alias
     * @param in
     * @throws AnzoException
     */
    public static void addTrustedCert(String keyStoreFile, String keystoreType, String password, String alias, InputStream in) throws AnzoException {
        try {

            CertificateFactory cf = CertificateFactory.getInstance("X509");

            X509Certificate cert = (X509Certificate) cf.generateCertificate(in);
            if (cert.getSubjectDN().equals(cert.getIssuerDN())) {
                cert.verify(cert.getPublicKey());
            }
            addTrustedCert(keyStoreFile, keystoreType, password, alias, cert);

        } catch (Exception cce) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, cce);
        }
    }

    /**
     * 
     * @param keyStoreFile
     * @param keystoreType
     * @param password
     * @param alias
     * @param cert
     * @throws AnzoException
     */
    public static void addTrustedCert(String keyStoreFile, String keystoreType, String password, String alias, X509Certificate cert) throws AnzoException {
        try {
            KeyStore keyStore = KeyStore.getInstance(keystoreType);
            keyStore.load(new FileInputStream(keyStoreFile), password.toCharArray());

            if (keyStore.containsAlias(alias)) {
                keyStore.deleteEntry(alias);
            }
            keyStore.setCertificateEntry(alias, cert);

            writeStoreToFile(keyStoreFile, password, keyStore);

        } catch (Exception cce) {
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, cce);
        }
    }

    public static void generateTruststore(String keystoreType, String trustPath, String password) throws AnzoException {
        try {
            KeyStore clientTrustStore = instantiateKeystore(keystoreType, password);
            writeStoreToFile(trustPath, password, clientTrustStore);
        } catch (GeneralSecurityException e) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error creating keystore", e);
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } catch (IOException e) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error creating keystore", e);
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
    }

    public static KeyStore instantiateKeystore(String keystoreType, String password) throws AnzoException {
        try {
            KeyStore keyStore = KeyStore.getInstance(keystoreType);
            keyStore.load(null, password.toCharArray());
            return keyStore;
        } catch (GeneralSecurityException e) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error creating keystore", e);
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } catch (IOException e) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error creating keystore", e);
            throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        }
    }
}
