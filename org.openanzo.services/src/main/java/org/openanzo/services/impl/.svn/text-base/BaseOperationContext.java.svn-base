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
package org.openanzo.services.impl;

import java.util.Hashtable;
import java.util.UUID;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IOperationContext;
import org.slf4j.MDC;

/**
 * Base implementation of the IOperationContext object
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class BaseOperationContext implements IOperationContext {
    private AnzoPrincipal             principal   = null;

    private String                    name        = null;

    private String                    operationId = null;

    private IOperationContext         rootContext = null;

    private Hashtable<String, Object> attributes;

    /**
     * Create a new BaseOperationContext for the given operation id and principal
     * 
     * @param name
     *            name for this operation
     * @param operationId
     *            ID for this operation
     * @param principal
     *            {@link AnzoPrincipal} for user that is calling this operation
     */
    public BaseOperationContext(String name, String operationId, AnzoPrincipal principal) {
        this.name = name;
        this.principal = principal;
        this.operationId = operationId;
        this.attributes = new Hashtable<String, Object>();
    }

    /**
     * Create a new BaseOperationContext, wrapping the provided rootContext
     * 
     * @param rootContext
     *            {@link IOperationContext} to set as root for this context
     * 
     */
    public BaseOperationContext(IOperationContext rootContext) {
        this.rootContext = rootContext;
    }

    public String getOperationId() {
        if (operationId != null) {
            return operationId;
        } else if (rootContext != null) {
            return rootContext.getOperationId();
        }
        return null;
    }

    public AnzoPrincipal getOperationPrincipal() {
        if (principal != null) {
            return principal;
        } else if (rootContext != null) {
            return rootContext.getOperationPrincipal();
        }
        return null;

    }

    public void setOperationPrincipal(AnzoPrincipal principal) {
        this.principal = principal;
    }

    /**
     * @see IOperationContext#getAttribute(String, Class)
     * @throws AnzoException
     *             {@link ExceptionConstants.OSGI#ATTRIBUTE_WRONG_TYPE} if requested attribute is of the wrong type
     */
    public <T> T getAttribute(String name, Class<T> attributeType) throws AnzoException {

        Object obj = (attributes != null) ? attributes.get(name) : rootContext.getAttributes().get(name);
        if (obj != null) {
            if (attributeType.isInstance(obj)) {
                return attributeType.cast(obj);
            }
            throw new AnzoException(ExceptionConstants.OSGI.ATTRIBUTE_WRONG_TYPE, name, attributeType.getCanonicalName(), obj.getClass().getCanonicalName());
        }
        return null;
    }

    public Object getAttribute(String name) {
        if (rootContext != null) {
            return rootContext.getAttribute(name);
        } else {
            return attributes.get(name);
        }
    }

    public IOperationContext getRootContext() {
        return rootContext;
    }

    public void setAttribute(String name, Object value) {
        if (rootContext != null) {
            rootContext.setAttribute(name, value);
        } else {
            attributes.put(name, value);
        }

    }

    /**
     * The the operation name
     * 
     * @return the operation name
     */
    public String getOperationName() {
        if (name != null) {
            return name;
        } else if (rootContext != null) {
            return rootContext.getOperationName();
        } else {
            return null;
        }

    }

    /**
     * Generate unique operationId
     * 
     * @return operationId
     */
    public static String generateOperationId() {
        return UUID.randomUUID().toString();
    }

    public void setMDC() {
        if (getOperationName() != null)
            MDC.put(SerializationConstants.operation, getOperationName());
        if (getOperationId() != null)
            MDC.put(SerializationConstants.operationId, getOperationId());
        if (getOperationPrincipal() != null && getOperationPrincipal().getUserURI() != null)
            MDC.put(SerializationConstants.userUri, getOperationPrincipal().getUserURI().toString());
        if (getAttribute(SerializationConstants.userDescription) != null)
            MDC.put(SerializationConstants.userDescription, getAttribute(SerializationConstants.userDescription).toString());
    }

    public void clearMDC() {
        MDC.remove(SerializationConstants.operation);
        MDC.remove(SerializationConstants.operationId);
        MDC.remove(SerializationConstants.userUri);
        MDC.remove(SerializationConstants.runAsUser);
        MDC.remove(SerializationConstants.userDescription);
    }

    /**
     * @return the attributes
     */
    public Hashtable<String, Object> getAttributes() {
        return attributes;
    }
}
