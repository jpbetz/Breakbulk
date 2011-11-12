/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 26, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization.transport;

import org.openanzo.exceptions.AnzoException;

/**
 * Generic type for an object representing a message for a specific transport
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IMessage {
    /**
     * Return true if this message format uses multi-valued properties
     * @return true if this message format uses multi-valued properties
     */
    public boolean getUseMultiValueProperties();
    /**
     * Set the body of the message
     * @param bodyString Text of the body
     * @throws AnzoException
     */
    public void setBody(String bodyString)throws AnzoException;
    
    /**
     * Get the body of the message
     * @return Text of the body
     * @throws AnzoException
     */
    public String getBody()throws AnzoException;
    
    /**
     * Set a Property for message
     * 
     * @param name
     *            Name of Property
     * @param value
     *            value of Property
     * @throws AnzoException
     *             if there was an error setting a Property on the message
     */
    public void setProperty(String name,String value) throws AnzoException;
    
    /**
     * Get the value of a Property from the message
     * @param name Name of the Property
     * @return the value of a Property from the message
     * @throws AnzoException
     */
    public String getProperty(String name)throws AnzoException;
    
    /**
     * Get the multi-value of a Property from the message
     * @param name Name of the Property
     * @return the multi-value of a Property from the message
     * @throws AnzoException
     */
    public String[] getProperties(String name)throws AnzoException;
   
    /**
     * Return true if message has property
     * @param name name of property
     * @return true if message has property
     * @throws AnzoException
     */
    public boolean hasProperty(String name)throws AnzoException;
}
