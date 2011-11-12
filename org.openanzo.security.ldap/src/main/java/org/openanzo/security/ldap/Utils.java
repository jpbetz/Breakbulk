/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 3, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.security.ldap;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.util.StringTokenizer;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.apache.directory.shared.ldap.util.LdapURL;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class Utils {

    /**
     * Escape DN
     * 
     * @param dn
     * @return escaped dn
     */
    public static final String escapeDN(String dn) {
        return dn.replace("\\", "\\5c").replace("(", "\\28").replace(")", "\\29").replace("*", "\\2a");
    }

    /**
     * Encode dn to uri
     * 
     * @param dn
     * @return encoded dn
     */
    public static final String encodeLdapUri(String dn) {
        if (dn.indexOf(',') > 0) {
            StringBuilder sb = new StringBuilder();
            String[] sp = dn.split("(?<!\\\\),");
            for (String attribute : sp) {
                int index = attribute.indexOf('=');
                sb.append(attribute.substring(0, index).toLowerCase());
                sb.append(attribute.substring(index));
                sb.append(',');
            }
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
            dn = sb.toString();
        }
        String encoded = LdapURL.urlEncode(dn, false).replace("#", "%23").replace("[", "%5B").replace("]", "%5D");
        return encoded;
    }

    /**
     * Decode and encoded ldap uri fragment
     * 
     * @param encoded
     * @return decoded ldap uri fragment
     */
    public static final String decodeLdapURI(String encoded) throws AnzoException {
        try {
            if (encoded == null) {
                return encoded;
            }

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] bytes = encoded.getBytes(Constants.byteEncoding);
            for (int i = 0; i < bytes.length; i++) {
                int b = bytes[i];

                if (b == '%') {
                    try {
                        int u = Character.digit((char) bytes[++i], 16);
                        int l = Character.digit((char) bytes[++i], 16);

                        if (u == -1 || l == -1) {
                            throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR);
                        }

                        buffer.write((char) ((u << 4) + l));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR);
                    }
                } else {
                    buffer.write(b);
                }
            }

            return new String(buffer.toByteArray(), Constants.byteEncoding);
        } catch (UnsupportedEncodingException uee) {
            throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, uee);
        }
    }

    /**
     * 
     * @param keystoreFile
     * @param keystorePassword
     * @param keystoreType
     * @param truststoreFile
     * @param truststorePassword
     * @param truststoreType
     * @return
     */
    public static synchronized SSLSocketFactory getSSLSocketFactory(String keystoreFile, String keystorePassword, String keystoreType, String truststoreFile, String truststorePassword, String truststoreType) {
        KeyManager[] km = null;
        TrustManager[] tm = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(keystoreType);
            keyStore.load(new FileInputStream(keystoreFile), keystorePassword.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, keystorePassword.toCharArray());
            km = kmf.getKeyManagers();

            KeyStore trustStore = KeyStore.getInstance(truststoreType);
            trustStore.load(new FileInputStream(truststoreFile), truststorePassword.toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            tm = tmf.getTrustManagers();

            SSLContext context = SSLContext.getInstance("SSLv3");
            context.init(km, tm, null);
            return context.getSocketFactory();
        } catch (Exception ex) {
            throw new RuntimeException("error instantiating default socket factory: " + ex.toString(), ex);
        }
    }
}
