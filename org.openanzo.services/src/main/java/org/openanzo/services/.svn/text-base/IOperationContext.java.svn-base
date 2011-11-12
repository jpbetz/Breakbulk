/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 4, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services;

import java.util.Hashtable;

import org.openanzo.exceptions.AnzoException;

/**
 * An IOperationContext is a context object that is passed from the initial request at the end-point, all the way threw to the back-end. Attributes can be added
 * to the context along the way. Core attributes are available, such as the operationID, and the requesting user's principal object.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IOperationContext {
    /**
     * Get the name for this operation. Example is "getNamedGraphSize", or "authenticateUser".
     * 
     * @return the name for this operation
     */
    public String getOperationName();

    /**
     * Get the unique ID for this operation. Example is the correlationId from JMS.
     * 
     * @return the unique ID for this operation
     */
    public String getOperationId();

    /**
     * Get the {@link AnzoPrincipal} for the user calling this operation
     * 
     * @return the Principal for the user calling this operation
     */
    public AnzoPrincipal getOperationPrincipal();

    /**
     * Set the {@link AnzoPrincipal} for this operation
     * 
     * @param principal
     *            the {@link AnzoPrincipal} for this operation
     */
    public void setOperationPrincipal(AnzoPrincipal principal);

    /**
     * Set attribute within context
     * 
     * @param name
     *            name of the attribute
     * @param value
     *            value of the attribute
     */
    public void setAttribute(String name, Object value);

    /**
     * Get value of attribute within context
     * 
     * @param name
     *            name of the attribute
     * @return value of attribute within context
     */
    public Object getAttribute(String name);

    /**
     * @return the attributes
     */
    public Hashtable<String, Object> getAttributes();

    /**
     * Get value of attribute within context
     * 
     * @param <T>
     *            Type of object to return
     * @param name
     *            name of the attribute
     * @param attributeType
     *            expected type of object to return
     * @return value of attribute within context
     * @throws AnzoException
     *             if the attribute was of a different type than requested
     */
    public <T extends Object> T getAttribute(String name, Class<T> attributeType) throws AnzoException;

    /**
     * Get root context
     * 
     * @return root context
     */
    public IOperationContext getRootContext();

    /**
     * Set the MDC log values for this context
     */
    public void setMDC();

    /**
     * Clear the MDC values for this context
     */
    public void clearMDC();
}
