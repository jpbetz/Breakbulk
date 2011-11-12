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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.IOperationContext;

/**
 * The Core semantic execution service
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class SemanticServiceExecutionService extends BaseExecutionService {

    //private static final Logger                log              = LoggerFactory.getLogger(SemanticServiceExecutionService.class);
    /** The URI of the registry containing all semantic services */
    public static final URI                          registryUri = Constants.valueFactory.createURI("http://openanzo.org/registries/SemanticService");

    /** Map from serviceUri to serviceTypeUri */
    private final Map<URI, URI>                      services    = new HashMap<URI, URI>();

    /** Map from serviceTypeUri to service executor */
    private final Map<URI, ISemanticServiceExecutor> executors   = new HashMap<URI, ISemanticServiceExecutor>();

    SemanticServiceExecutionService() {
    }

    public String getName() {
        return "service=SemanticExecutionService";
    }

    public String getDescription() {
        return "Semantic Service Execution Service";
    }

    /**
     * Register a service
     * 
     * @param serviceUri
     *            uri of a service
     * @param serviceTypeUri
     *            type uri for service
     */
    public void registerService(URI serviceUri, URI serviceTypeUri) {
        services.put(serviceUri, serviceTypeUri);
    }

    /**
     * Unregister a service
     * 
     * @param serviceUri
     *            uri of service to unregister
     */
    public void unregisterService(URI serviceUri) {
        services.remove(serviceUri);
    }

    /**
     * Register a service executor
     * 
     * @param serviceTypeUri
     *            URI Service executor type
     * @param executor
     *            Executor to register
     */
    public void registerServiceExecutor(URI serviceTypeUri, ISemanticServiceExecutor executor) {
        executor.setHostExecutionService(this);
        executors.put(serviceTypeUri, executor);
    }

    /**
     * Unregister an executor
     * 
     * @param serviceTypeUri
     *            Service executor type to unregister
     */
    public void unregisterServiceExecutor(URI serviceTypeUri) {
        executors.remove(serviceTypeUri);
    }

    @Override
    protected Collection<Statement> executeServiceInternal(IOperationContext context, Collection<Statement> statements, URI operationUri) throws AnzoException {

        IDataset request = new Dataset();
        IDataset response = new Dataset();

        Set<URI> graphsToAdd = new HashSet<URI>();
        for (Statement statement : statements) {
            graphsToAdd.add(statement.getNamedGraphUri());
        }
        for (URI uri : graphsToAdd) {
            request.addNamedGraph(uri);
        }
        request.add(statements);

        // first check to see if we can derive the 
        // serviceUri from the operationUri.  If not,
        // we have to see if there are any executors
        // that can do so. 
        String ns = operationUri.getNamespace();
        String servUri = ns.substring(0, ns.length() - 1);
        URI serviceUri = Constants.valueFactory.createURI(servUri);
        URI serviceTypeUri = services.get(serviceUri);
        boolean requestDefinedService = false;
        if (serviceTypeUri == null) {
            serviceUri = null;
            for (URI uri : executors.keySet()) {
                ISemanticServiceExecutor executor = executors.get(uri);
                serviceTypeUri = executor.getServiceTypeUri();
                serviceUri = executor.getServiceUri(operationUri, request);
                if (serviceUri != null) {
                    requestDefinedService = true;
                    break;
                }
            }
            if (serviceUri == null) {
                throw new AnzoException(ExceptionConstants.EXECUTION.UNKNOWN_SERVICE_ERROR, servUri);
            }
        }

        ISemanticServiceExecutor executor = executors.get(serviceTypeUri);
        executor.executeService(context, serviceUri, operationUri, requestDefinedService, request, response);

        return response.getStatements();
    }
}
