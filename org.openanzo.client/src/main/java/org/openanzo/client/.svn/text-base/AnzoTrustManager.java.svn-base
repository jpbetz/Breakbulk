/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     
 *     Cambridge Semantics Incorporated - Initial Implementation
 *******************************************************************************/
package org.openanzo.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Hex;
import org.openanzo.client.cli.CommandContext;
import org.openanzo.client.cli.CommandLineInterface;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.utils.KeystoreUtils;

/**
 * This is a subclass of the default Java Trust Manager, X509TrustManager. It gives us access to the certificates so that information about them can be reported
 * should they not be trusted. In that event the user is given the option to trust the certificate anyway.
 * 
 * @author Danny Kahn ( <a href="mailto:danny@cambridgesemantics.com">danny@cambridgesemantics.com </a>)
 * 
 */
public class AnzoTrustManager implements X509TrustManager {

    /*
     * The default X509TrustManager returned by SunX509.  We'll delegate
     * decisions to it, and fall back to the logic in this class if the
     * default X509TrustManager doesn't trust it.
     */
    private X509TrustManager      x509tm;

    private boolean               trustAll;

    private boolean               showTrace;

    private static final String[] MONTHS               = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

    private static final String   ANZO_DIR             = ".anzo";

    private static final String   DEFAULT_CLIENT_TRUST = "client.ts";

    private static final String   DEFAULT_PWORD        = "p@ssw0rd";

    public AnzoTrustManager(boolean trustAll, boolean showTrace) throws AnzoException {
        this.trustAll = trustAll;
        this.showTrace = showTrace;

        String truststorePath = CommandContext.preprocessString(System.getProperty("javax.net.ssl.trustStore"));
        String userHome = System.getProperty("user.home");
        try {
            if (truststorePath == null && userHome != null) {
                File truststoreFile = new File(new File(userHome, ANZO_DIR), DEFAULT_CLIENT_TRUST);
                if (truststoreFile.exists()) // check the default location for the trust store in the user's .anzo directory
                    truststorePath = truststoreFile.getCanonicalPath();
            }
            String truststoreType = System.getProperty("javax.net.ssl.trustStoreType", "JCEKS");
            String truststorePassword = System.getProperty("javax.net.ssl.trustStorePassword", DEFAULT_PWORD);

            // create a "default" JSSE X509TrustManager.
            KeyStore ks = KeyStore.getInstance(truststoreType);
            if (truststorePath != null && truststorePassword != null) {
                File trustFile = new File(truststorePath);
                if (trustFile.exists()) {
                    ks.load(new FileInputStream(trustFile), truststorePassword.toCharArray());
                }
            }
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
            tmf.init(ks);
            TrustManager tms[] = tmf.getTrustManagers();

            /*
             * Iterate over the returned trustmanagers, look
             * for an instance of X509TrustManager.  If found,
             * use that as our "default" trust manager.
             */
            for (int i = 0; i < tms.length; i++) {
                if (tms[i] instanceof X509TrustManager) {
                    x509tm = (X509TrustManager) tms[i];
                    return;
                }
            }
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_TRUST_MANAGER, e);
        }

        // could not find the java default trust manager so throw an exception
        throw new AnzoRuntimeException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_TRUST_MANAGER, "The default Java Trust Manager was not found");
    }

    /**
     * Delegate to the default trust manager.
     */
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        try {
            x509tm.checkClientTrusted(chain, authType);
        } catch (CertificateException excep) {
            handleCertificateException(excep, chain);
        }
    }

    /**
     * Delegate to the default trust manager.
     */
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        try {
            x509tm.checkServerTrusted(chain, authType);
        } catch (CertificateException excep) {
            handleCertificateException(excep, chain);
        }
    }

    /**
     * Merely pass this through.
     */
    public X509Certificate[] getAcceptedIssuers() {
        return x509tm.getAcceptedIssuers();
    }

    private void handleCertificateException(CertificateException ce, X509Certificate[] chain) throws CertificateException {
        if (trustAll) {
            return;
        }

        System.err.println(ce.getMessage());
        System.err.println("Certificate Information: \n");
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(chain[0].getNotBefore().getTime());
        System.err.println("Creation Date: " + MONTHS[cal.get(Calendar.MONTH)] + " " + cal.get(Calendar.DAY_OF_MONTH) + ", " + cal.get(Calendar.YEAR));
        //System.err.println("Entry type: " + chain[0].getType());
        System.err.println("Certificate chain length: " + chain.length);

        // print some information about the certificate(s) that failed
        int i = 1;
        for (X509Certificate cert : chain) {
            System.err.println("Certificate[" + i++ + "]:");
            System.err.println("Owner: " + cert.getSubjectX500Principal().toString());
            System.err.println("Issuer: " + cert.getIssuerX500Principal().toString());

            String serialNum = new String(Hex.encodeHex(cert.getSerialNumber().toByteArray()));
            System.err.println("Serial Number: " + serialNum);
            System.err.println("Valid from: " + cert.getNotBefore().toString() + " until: " + cert.getNotAfter().toString());
            System.err.println("Certificate fingerprints: ");
            try {
                byte[] sig = cert.getEncoded();
                System.err.println("\tMD5: " + getHash(sig, "MD5"));
                System.err.println("\tSHA1: " + getHash(sig, "SHA1"));
            } catch (NoSuchAlgorithmException e) {
            }
            System.err.println("\tSignature Algorithm Name: " + cert.getSigAlgName());
            System.err.println("\tVersion: " + cert.getVersion());
            System.err.println("-----------------------------------------------------");
        }
        System.err.println("Would you like to accept this certificate? (o)nce, (a)lways, (n)o");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            line = in.readLine();
        } catch (IOException e) {
            CommandLineInterface.DEFAULT_CONSOLE.printException(e, showTrace);
            System.exit(1);
        }
        if (Character.toLowerCase(line.charAt(0)) == 'o') {
            return;
        } else if (Character.toLowerCase(line.charAt(0)) == 'a') {
            try {
                String truststoreType = System.getProperty("javax.net.ssl.trustStoreType", "JCEKS");
                String truststorePassword = System.getProperty("javax.net.ssl.trustStorePassword", DEFAULT_PWORD);

                String truststorePath = System.getProperty("javax.net.ssl.trustStore");
                if (truststorePath == null) { // there is no trust store location in the user's settings.trig file
                    String userHome = System.getProperty("user.home");
                    if (userHome == null)
                        throw new AnzoException(ExceptionConstants.CLIENT.FAILED_INITIALIZE_TRUST_MANAGER, "User's home directory is not specified");
                    File truststoreFile = new File(new File(userHome, ANZO_DIR), DEFAULT_CLIENT_TRUST);
                    truststorePath = truststoreFile.getCanonicalPath();
                    if (!truststoreFile.exists())
                        openTruststore(truststoreType, truststorePath, truststorePassword);
                } else {
                    truststorePath = CommandContext.preprocessString(truststorePath);
                    File truststoreFile = new File(truststorePath);

                    if (!truststoreFile.exists()) {
                        System.err.println("Could not find the specified trust store file at:");
                        System.err.println(truststoreFile.getCanonicalPath());
                        System.err.println("The trust store file is used for permanently trusting server certificates that");
                        System.err.println("are not trusted by default.");
                        System.err.println("Would you like to create a new trust store file at the specified location?");
                        System.err.println("(y)es, (n)o");
                        try {
                            line = in.readLine();
                        } catch (IOException e) {
                            CommandLineInterface.DEFAULT_CONSOLE.printException(e, showTrace);
                            System.exit(1);
                        }
                        if (Character.toLowerCase(line.charAt(0)) == 'y')
                            openTruststore(truststoreType, truststorePath, truststorePassword);
                        else
                            System.exit(1);
                    }
                }

                KeystoreUtils.addTrustedCert(truststorePath, truststoreType, truststorePassword, "imported_" + System.currentTimeMillis(), chain[0]);
            } catch (AnzoException ae) {
                System.err.println("Error importing certificate into truststore: ");
                CommandLineInterface.DEFAULT_CONSOLE.printException(ae, showTrace);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Error importing certificate into truststore: ");
                CommandLineInterface.DEFAULT_CONSOLE.printException(e, showTrace);
                System.exit(1);
            }
        } else {
            System.exit(1); // if the user does not want to trust the certificate then exit
        }
    }

    private void openTruststore(String truststoreType, String truststorePath, String truststorePassword) throws AnzoException {
        try {
            KeystoreUtils.generateTruststore(truststoreType, truststorePath, truststorePassword);
        } catch (AnzoException ae) {
            System.err.println("Could not open trust store file at:");
            System.err.println(truststorePath);
            System.err.println("The password or truststore type settings may be incorrect or the trust store file is invalid.");
            throw ae;
        }
    }

    private String getHash(byte[] key, String algName) throws NoSuchAlgorithmException {
        MessageDigest digest;
        digest = java.security.MessageDigest.getInstance(algName);
        digest.update(key);
        byte[] hash = digest.digest();

        char[] digestChars = Hex.encodeHex(hash);
        int len = (int) (digestChars.length + 0.5 * digestChars.length - 1);
        char[] withColons = new char[len];
        int j = 0;
        for (int i = 0; i < digestChars.length; i += 2) {
            withColons[j++] = Character.toUpperCase(digestChars[i]);
            withColons[j++] = Character.toUpperCase(digestChars[i + 1]);
            if (j < len)
                withColons[j++] = ':';
        }

        return new String(withColons);
    }
}
