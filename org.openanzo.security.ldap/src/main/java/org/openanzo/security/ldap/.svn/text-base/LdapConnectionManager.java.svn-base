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

import java.util.Dictionary;

import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;

import com.novell.ldap.LDAPConnection;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 */
public class LdapConnectionManager {
    /**
     * 
     */
    protected GenericObjectPool     pool;

    /**
     * 
     */
    protected PoolableObjectFactory factory;

    /**
     * 
     * @param configProperties
     * @throws AnzoException
     */
    public LdapConnectionManager(Dictionary<? extends Object, ? extends Object> configProperties) throws AnzoException {
        factory = new LdapConnectionFactory(configProperties);
        pool = new GenericObjectPool(factory);
        pool.setTestOnBorrow(true);
    }

    /**
     * @param userDN
     * @param userPassword
     * @param host
     * @param port
     * 
     */
    public LdapConnectionManager(String userDN, String userPassword, String host, Integer port, boolean useSSL, String keystoreFile, String keystorePassword, String keystoreType, String truststoreFile, String truststorePassword, String truststoreType) {
        factory = new LdapConnectionFactory(userDN, userPassword, host, port, useSSL, keystoreFile, keystorePassword, keystoreType, truststoreFile, truststorePassword, truststoreType);
        pool = new GenericObjectPool(factory);
        pool.setTestOnBorrow(true);
    }

    /**
     * @return connection
     * @throws AnzoException
     */
    public LDAPConnection getConnection() throws AnzoException {
        try {
            return (LDAPConnection) pool.borrowObject();
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.SERVER.LDAP_ERROR, e);
        }
    }

    /**
     * 
     * @param context
     * @throws AnzoException
     */
    public void returnConnection(LDAPConnection context) throws AnzoException {
        try {
            pool.returnObject(context);
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.SERVER.LDAP_ERROR, e);
        }
    }

    /**
     * 
     * @throws AnzoException
     */
    public void close() throws AnzoException {
        try {
            pool.close();
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.SERVER.LDAP_ERROR, e);
        }
    }
}
