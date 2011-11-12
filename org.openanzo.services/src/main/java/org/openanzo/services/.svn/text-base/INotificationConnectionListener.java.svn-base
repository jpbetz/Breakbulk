/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 2, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services;

import org.openanzo.exceptions.AnzoException;

/**
 * IJmsConnectionListener listens for events from the JMSConnectionManager. It provides both events about the state of the client's connection to the JMS
 * broker.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
public interface INotificationConnectionListener {
    /**
     * IJmsConnectionListener is connected to the server
     */
    public static final int CONNECTED        = 1;

    /**
     * IJmsConnectionListener is disconnected from the server
     */
    public static final int DISCONNECTED     = 0;

    /**
     * IJmsConnectionListener failed to connect to the server
     */
    public static final int CONNECTIONFAILED = -1;

    /**
     * Event about the state of the IJmsConnectionListener's connection to the NotificationServer
     * 
     * @param state
     *            current state of the connection
     * @see org.openanzo.services.INotificationConnectionListener#CONNECTED
     * @see org.openanzo.services.INotificationConnectionListener#DISCONNECTED
     * @see org.openanzo.services.INotificationConnectionListener#CONNECTIONFAILED
     */
    void connectionStateChanged(int state);

    /**
     * Exception was thrown within the IJmsConnectionListener
     * 
     * @param exception
     *            which was thrown within the service
     */
    void notificationException(AnzoException exception);
}
