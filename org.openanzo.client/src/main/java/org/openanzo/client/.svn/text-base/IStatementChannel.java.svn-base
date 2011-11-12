/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 12, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client;

import java.util.Collection;
import java.util.Map;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.AnzoGraph;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;

/**
 * A statement channel is a JMS backed channel of statements which a client can publish and receive statements from, depending on their acls
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IStatementChannel {
    /**
     * Get the URI of the channel
     * 
     * @return the URI of the channel
     */
    public URI getURI();

    /**
     * Gets a standard AnzoNamedGraph containing the non streamed data and metadata about the channel.
     * 
     * @return a standard AnzoNamedGraph containing the non streamed data and metadata about the channel.
     */
    public AnzoGraph getNamedGraph();

    /**
     * Send a collection of statements to the channel.
     * 
     * @param messageProperties
     *            Zero or more properties that are added as JMS message properties
     * @param statements
     *            collection of statements to send to the channel.
     * @throws AnzoException
     */
    public void sendMessage(Map<String, Object> messageProperties, Collection<Statement> statements) throws AnzoException;

    /**
     * Register a channelListener with the channel
     * 
     * @param listener
     *            listener for which to register with channel
     * @throws AnzoException
     */
    public void registerListener(IStatementChannelListener listener) throws AnzoException;

    /**
     * Unregister a channelListener with the channel
     * 
     * @param listener
     *            listener for which to unregister from channel
     * @throws AnzoException
     */
    public void unregisterListener(IStatementChannelListener listener) throws AnzoException;

    /**
     * Close the Statement Channel
     * 
     * @throws AnzoException
     */
    public void close() throws AnzoException;

}
