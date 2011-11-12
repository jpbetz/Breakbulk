/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 1, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus.endpoint;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.openanzo.analysis.RequestRecorder;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.IOperationContext;

/**
 * An ICombusEndpointListener is registered with a JMS queue, and messages are handed to the handleMessage method
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface ICombusEndpointListener {
    /**
     * Set the {@link Session} object for this listener
     * 
     * @param session
     *            the {@link Session} object for this listener
     */
    public void setSession(Session session);

    /**
     * Handle a message, and return the response message if one is required
     * 
     * @param context
     *            The operation's context
     * @param replyTo
     *            {@link Destination} to which reply is sent
     * @param format
     *            format of content with request
     * @param operation
     *            Operation name
     * @param request
     *            The request message
     * @param messageProducer
     *            Message producer
     * @return Response message if required
     * @throws JMSException
     * @throws AnzoException
     */
    public TextMessage handleMessage(IOperationContext context, Destination replyTo, String format, String operation, TextMessage request, MessageProducer messageProducer) throws JMSException, AnzoException;

    /**
     * Get the name of the Queue on which this listener listens
     * 
     * @return the name of the Queue on which this listener listens
     */
    public String getQueueName();

    /**
     * Set the JMS {@link MessageConsumer} object for this listener
     * 
     * @param consumer
     *            the JMS {@link MessageConsumer} object for this listener
     * @param lowConsumer
     *            the low priority JMS {@link MessageConsumer} object for this listener
     * @throws JMSException
     */
    public void setConsumer(MessageConsumer consumer, MessageConsumer lowConsumer) throws JMSException;

    /**
     * Set the request recorder for this listener
     * 
     * @param recorder
     *            requestrecorder
     */
    public void setRecorder(RequestRecorder recorder);

    /**
     * Start the listener
     * 
     * @throws AnzoException
     */
    public void start() throws AnzoException;

    /**
     * Stop the listener
     * 
     * @throws AnzoException
     */
    public void stop() throws AnzoException;
}
