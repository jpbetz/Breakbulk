/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 3, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus;

/**
 * Base class for other service implementations that use a JMS connection for their operations
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseCombusProxyService {
    /** JMSConnectionBackend */
    protected final CombusConnection  combusConnection;

    private long                      timeout       = 60000;

    /** ThreadLocal property for thed user to run operations as for this thread */
    private final ThreadLocal<String> runAsUser     = new ThreadLocal<String>();

    /** ThreadLocal property for thed password to run operations as for this thread */
    private final ThreadLocal<String> runAsPassword = new ThreadLocal<String>();

    /**
     * Create new JMSBaseService with configuration properties provided in properties object
     * 
     * @param combusConnection
     *            Connection which this proxy class uses to communicate to the server
     */
    public BaseCombusProxyService(CombusConnection combusConnection) {
        this.combusConnection = combusConnection;
    }

    /**
     * Set the userId for the current thread which this service will use to authenticate
     * 
     * @param user
     *            userId for the current thread which this service will use to authenticate
     */
    public void setServiceUser(String user) {
        runAsUser.set(user);
    }

    /**
     * Get the userId for the current thread which this service will use to authenticate
     * 
     * @return the userId for the current thread which this service will use to authenticate
     */
    public String getServiceUser() {
        return runAsUser.get();
    }

    /**
     * Get the user's password for the current thread which this service will use to authenticate
     * 
     * @return the user's password for the current thread which this service will use to authenticate
     */
    public String getServicePassword() {
        return runAsPassword.get();
    }

    /**
     * Set the user's password for the current thread which this service will use to authenticate
     * 
     * @param password
     *            user's password for the current thread which this service will use to authenticate
     */
    public void setServicePassword(String password) {
        runAsPassword.set(password);
    }

    /**
     * Get the number of milliseconds to wait for a response
     * 
     * @return the number of milliseconds to wait for a response
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * Set the number of milliseconds to wait for a response
     * 
     * @param timeout
     *            the number of milliseconds to wait for a response
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

}
