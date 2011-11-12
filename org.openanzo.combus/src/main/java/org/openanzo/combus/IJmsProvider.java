/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/services/IJmsProvider.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/24/2006
 * Revision:	$Id: IJmsProvider.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.combus;

import java.util.Dictionary;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * IJmsProvider wraps an implementation of a JMS provider with any conversion needed in order for Anzo's notification system to work.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public interface IJmsProvider {

    /**
     * Create a new JMS ConnectionFactory given a set of properties.
     * 
     * @param properties
     *            Configuration properties for the ConnectionFactory
     * @return New JMS ConnectionFactory based on the given properties
     * @throws JMSException
     *             if there is an exception creating a ConnectionFactory
     * 
     * @see javax.jms.ConnectionFactory
     */
    public ConnectionFactory createConnectionFactory(Dictionary<? extends Object, ? extends Object> properties);

    /**
     * Do any provider specific operations that are needed in order to convert a replyToDestination to a Destination object that the provider can send messages.
     * 
     * @param session
     *            Session destination is a member of
     * @param destination
     *            Destination to convert
     * @return Converted/augmented destination
     * @throws JMSException
     */
    public Destination convertReplyToDestination(Session session, Destination destination) throws JMSException;

    /**
     * Do any provider specific operations that are needed in order to convert a String representation of a Destination to a Destination object that the
     * provider can send messages.
     * 
     * @param session
     *            Session destination is a member of
     * @param destination
     *            String representation of destination to convert
     * @return New destination object
     * @throws JMSException
     */
    public Destination convertStringToDestination(Session session, String destination) throws JMSException;

}
