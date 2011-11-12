/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.execution;

import org.openanzo.client.AnzoClient;
import org.openanzo.rdf.URI;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IOperationContext;

/**
 * The execution context for operation
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface IExecutionContext {

    /**
     * Get the URI of the current operation
     * 
     * @return the URI of the current operation
     */
    public URI getOperationURI();

    /**
     * Get the URI of the current service
     * 
     * @return the URI of the current service
     */
    public URI getServiceURI();

    /**
     * Get the user associated with the request.
     * 
     * @return the user associated with the request.
     */
    public AnzoPrincipal getRequestUser();

    /**
     * Use the authenticated request user for anzo client operations
     */
    public void executeAsRequestUser();

    /**
     * Use the service's authenticated user for anzo client operations
     */
    public void executeAsServiceUser();

    /**
     * get the AnzoClient to use for servicing requests (if necessary)
     * 
     * @return the AnzoClient to use for servicing requests (if necessary)
     */
    public AnzoClient getAnzoClient();

    /**
     * get the IOperationContext of the request
     * 
     * @return the IOperationContext of the request
     */
    public IOperationContext getOperationContext();

}
