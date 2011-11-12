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

import org.openanzo.rdf.Statement;

/**
 * Listener for receiving events when statements are published to a statements channel
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IStatementChannelListener {
    /**
     * Statements received via channel
     * 
     * @param messageProperties
     *            Set of properties associated with this collection of statements, like who sent the message
     * @param statements
     *            Statements received via channel
     */
    public void statementsReceived(Map<String, Object> messageProperties, Collection<Statement> statements);

    /**
     * Channel was closed
     */
    public void channelClosed();
}
