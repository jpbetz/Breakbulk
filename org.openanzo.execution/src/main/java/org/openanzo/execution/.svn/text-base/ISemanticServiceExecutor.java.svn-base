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

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.URI;
import org.openanzo.services.IOperationContext;

/**
 * Interface for the SemanticService executor
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface ISemanticServiceExecutor {
    /**
     * Execute service
     * 
     * @param context
     *            context for the operation
     * @param serviceUri
     *            uri of the service
     * @param operationUri
     *            uri of the operation
     * @param requestDefinedService
     *            is the request self defining the service
     * @param request
     *            request data
     * @param response
     *            response data
     * @throws AnzoException
     */
    public void executeService(IOperationContext context, URI serviceUri, URI operationUri, boolean requestDefinedService, IDataset request, IDataset response) throws AnzoException;

    /**
     * Set the ExecutionService service
     * 
     * @param executionService
     *            the ExecutionService service
     */
    public void setHostExecutionService(SemanticServiceExecutionService executionService);

    /**
     * Get the service URI for an operation and the request
     * 
     * @param operationUri
     *            uri of the operation
     * @param request
     *            request data
     * @return the service URI
     * @throws AnzoException
     */
    public URI getServiceUri(URI operationUri, IDataset request) throws AnzoException;

    /**
     * Get the service type URI
     * 
     * @return the service type URI
     */
    public URI getServiceTypeUri();

}
