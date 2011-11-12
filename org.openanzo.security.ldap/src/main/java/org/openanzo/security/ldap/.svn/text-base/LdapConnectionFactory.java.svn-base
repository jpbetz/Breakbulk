/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Aug 20, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.security.ldap;

import java.security.Security;
import java.util.Dictionary;

import org.apache.commons.pool.PoolableObjectFactory;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.security.keystore.KeyStoreDictionary;
import org.openanzo.services.LDAPDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPJSSESecureSocketFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 */
public class LdapConnectionFactory implements PoolableObjectFactory {
    private static final Logger         log = LoggerFactory.getLogger(LdapConnectionFactory.class);

    /**
     * 
     */
    protected String                    ldapAdminDN;

    /**
     * 
     */
    protected String                    ldapAdminPassword;

    /**
     * 
     */
    protected String                    host;

    /**
     * 
     */
    protected Integer                   port;

    protected boolean                   useSSL;

    private LDAPJSSESecureSocketFactory ssf;

    /**
     * 
     * @param ldapAdminDN
     * @param ldapAdminPassword
     * @param host
     * @param port
     */
    public LdapConnectionFactory(String ldapAdminDN, String ldapAdminPassword, String host, Integer port, boolean useSSL, String keystoreFile, String keystorePassword, String keystoreType, String truststoreFile, String truststorePassword, String truststoreType) {
        this.ldapAdminDN = ldapAdminDN;
        this.ldapAdminPassword = ldapAdminPassword;
        this.host = host;
        this.port = port;
        this.useSSL = useSSL;
        if (this.useSSL) {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            ssf = new LDAPJSSESecureSocketFactory(Utils.getSSLSocketFactory(keystoreFile, keystorePassword, keystoreType, truststoreFile, truststorePassword, truststoreType));
        }
    }

    /**
     * 
     * @param connProperties
     */
    public LdapConnectionFactory(Dictionary<? extends Object, ? extends Object> connProperties) throws AnzoException {
        host = LDAPDictionary.getHost(connProperties, "localhost");
        port = LDAPDictionary.getPort(connProperties, 10389);
        ldapAdminDN = LDAPDictionary.getLdapServerUser(connProperties);
        ldapAdminPassword = LDAPDictionary.getLdapServerPassword(connProperties);
        Boolean useSSL = LDAPDictionary.getUseSSL(connProperties);
        if (useSSL != null) {
            this.useSSL = useSSL.booleanValue();
        }
        if (this.useSSL) {

            String keystoreFile = KeyStoreDictionary.getKeyFileLocation(connProperties);
            String keystorePassword = KeyStoreDictionary.getKeyPassword(connProperties);
            String keystoreType = KeyStoreDictionary.getKeystoreType(connProperties);
            String truststoreFile = KeyStoreDictionary.getClientTrustFileLocation(connProperties);
            String truststorePassword = KeyStoreDictionary.getClientTrustPassword(connProperties);
            String truststoreType = KeyStoreDictionary.getClientTruststoreType(connProperties);
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            ssf = new LDAPJSSESecureSocketFactory(Utils.getSSLSocketFactory(keystoreFile, keystorePassword, keystoreType, truststoreFile, truststorePassword, truststoreType));
        }
    }

    public Object makeObject() throws Exception {
        LDAPConnection ldapConnection = null;
        try {
            if (useSSL) {
                ldapConnection = new LDAPConnection(ssf);
            } else {
                ldapConnection = new LDAPConnection();
            }
            ldapConnection.connect(host, port);
            ldapConnection.bind(LDAPConnection.LDAP_V3, ldapAdminDN, ldapAdminPassword.getBytes("UTF8"));
        } catch (LDAPException ae) {
            log.error(LogUtils.SECURITY_MARKER, "Create ldap exception error:", ae);
            throw ae;
        }
        return ldapConnection;
    }

    public void destroyObject(Object connection) throws Exception {
        LDAPConnection ldapConnection = (LDAPConnection) connection;
        ldapConnection.disconnect();
    }

    public void passivateObject(Object arg0) throws Exception {
    }

    public void activateObject(Object arg0) throws Exception {
    }

    public boolean validateObject(Object connection) {
        return (((LDAPConnection) connection).isConnectionAlive());
    }
}
