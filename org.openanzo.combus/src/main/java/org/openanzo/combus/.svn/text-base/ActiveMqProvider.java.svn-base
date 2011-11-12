/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/jms/ActiveMqProvider.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/24/2006
 * Revision:	$Id: ActiveMqProvider.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.combus;

import java.util.Dictionary;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTempTopic;

/**
 * Implementation of IJmsProvider for the ActiveMQ jms system.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public class ActiveMqProvider implements IJmsProvider {

    private final boolean localVmConnections;

    /**
     * @param localVmConnections
     *            if true, there is a local vm listener for connections
     */
    public ActiveMqProvider(boolean localVmConnections) {
        this.localVmConnections = localVmConnections;
    }

    /**
     * Create a new ActiveMq connection factory. Defaults to tcp://localhost if jmshost property is not set. will prepend tcp:// if no protocol is set as part
     * of jmshost property.
     */
    public ConnectionFactory createConnectionFactory(Dictionary<? extends Object, ? extends Object> properties) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        String hostUrl = null;
        if (localVmConnections) {
            hostUrl = "vm://localhost?create=false&broker.persistent=false&marshal=false&waitForStart=5000&jms.useCompression=true";
        } else {
            hostUrl = CombusDictionary.getHost(properties);
            Integer hostPort = CombusDictionary.getPort(properties);
            Boolean useSsl = CombusDictionary.getUseSsl(properties);
            boolean ssl = false;
            if (useSsl != null && useSsl) {
                ssl = true;
            }
            if (!ssl) {
                if (hostUrl == null) {
                    hostUrl = "nio://localhost";
                } else if (hostUrl.indexOf("://") < 0) {
                    hostUrl = "nio://" + hostUrl;
                }
            } else {
                String sslHost = CombusDictionary.getSslHost(properties);
                if (sslHost != null) {
                    hostUrl = sslHost;
                }
                if (hostUrl == null) {
                    hostUrl = "ssl://localhost";
                } else if (hostUrl.indexOf("://") < 0) {
                    hostUrl = "ssl://" + hostUrl;
                }
                Integer sslPort = CombusDictionary.getSslPort(properties);
                if (sslPort != null) {
                    hostPort = sslPort;
                }
            }
            if (hostPort != null) {
                hostUrl = hostUrl + ":" + hostPort;
            }
            hostUrl = "failover:(" + hostUrl + ")?jms.useCompression=true&maxReconnectAttempts=5&initialReconnectDelay=500&maxReconnectDelay=1000";
        }

        connectionFactory.setBrokerURL(hostUrl);
        connectionFactory.setCopyMessageOnSend(false);
        return connectionFactory;
    }

    public Destination convertReplyToDestination(Session session, Destination destination) {
        return destination;
    }

    public Destination convertStringToDestination(Session session, String destination) {
        Destination newDestination = new ActiveMQTempTopic(destination);
        return newDestination;
    }

}
