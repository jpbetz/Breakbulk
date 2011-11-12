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

import org.openanzo.client.AnzoClient;
import org.openanzo.client.pool.AnzoClientPool;
import org.openanzo.client.pool.RestrictedAnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.ontologies.execution.SemanticOperation;
import org.openanzo.ontologies.execution.SemanticService;
import org.openanzo.ontologies.execution.SemanticServiceFactory;
import org.openanzo.ontologies.execution.StateStyleEnum;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.ontologies.openanzo.DatasetListener;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.osgi.registry.RegistryDataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IOperationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base Service Executor
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseServiceExecutor implements ISemanticServiceExecutor {

    private static final Logger                        log                  = LoggerFactory.getLogger(BaseServiceExecutor.class);

    private Map<URI, ServiceInfo>                      servicesInfo         = null;

    private SemanticServiceExecutionService            hostExecutionService = null;

    private AnzoClientPool                             anzoClientPool       = null;

    protected RegistryDataset                          serviceRegistry      = null;

    protected org.openanzo.ontologies.openanzo.Dataset dataset              = null;

    protected final DatasetListener                    listener             = new DsListener();

    /**
     * Initialize the service
     * 
     * @param service
     *            Service to initialize
     * @param anzoClient
     *            client used to initialize
     * @return true if initialized
     * @throws AnzoException
     */
    public abstract boolean initializeService(SemanticService service, AnzoClient anzoClient) throws AnzoException;

    /**
     * Stop the service
     * 
     * @param serviceUri
     *            uri of the service
     * @param anzoClient
     *            client used to stop the service
     * @throws AnzoException
     */
    public abstract void stopService(URI serviceUri, AnzoClient anzoClient) throws AnzoException;

    /**
     * Verify that the operation is valid
     * 
     * @param serviceUri
     *            uri of the service
     * @param operationUri
     *            uri of the operation to verify
     * @throws AnzoException
     */
    public abstract void verifyOperation(URI serviceUri, URI operationUri) throws AnzoException;

    /**
     * Execute the service
     * 
     * @param serviceUri
     *            uri of the service
     * @param operationUri
     *            uri of the operation
     * @param executionContext
     *            context of execution
     * @param request
     *            dataset containing the request
     * @param response
     *            dataset containg the response
     * @throws AnzoException
     */
    public abstract void executeService(URI serviceUri, URI operationUri, IExecutionContext executionContext, IDataset request, IDataset response) throws AnzoException;

    /**
     * The registry is reset
     * 
     * @param registry
     *            registry
     * @throws AnzoException
     */
    public abstract void registryReset(RegistryDataset registry) throws AnzoException;

    /**
     * Load service from registry
     * 
     * @param serviceRegistry
     *            registry containing service definition
     * @throws AnzoException
     */
    public void loadServices(RegistryDataset serviceRegistry) throws AnzoException {
        try {
            if (dataset != null) {
                dataset.unregisterListener(listener);
            }
            this.servicesInfo = new HashMap<URI, ServiceInfo>();
            this.serviceRegistry = serviceRegistry;
            URI serviceTypeUri = getServiceTypeUri();
            Collection<Statement> stmts = serviceRegistry.find(null, RDF.TYPE, serviceTypeUri);

            for (Statement stmt : stmts) {
                URI serviceUri = (URI) stmt.getSubject();
                SemanticService service = SemanticServiceFactory.getSemanticService(serviceUri, serviceRegistry);
                if (service.isRDFType(SemanticService.TYPE)) {
                    loadService(service);
                } else {
                    log.error(LogUtils.LIFECYCLE_MARKER, "There is a problem, service " + serviceUri.toString() + " is not of correct type");
                }
            }

            dataset = AnzoFactory.createDataset(serviceRegistry.getURI(), serviceRegistry);

            dataset.registerListener(listener);

        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, e);
        }
    }

    /**
     * Stop the services
     * 
     * @param bundleStopping
     * @throws AnzoException
     */
    public void stopServices(boolean bundleStopping) throws AnzoException {
        Set<URI> servicesToStop = new HashSet<URI>();
        for (URI uri : servicesInfo.keySet()) {
            servicesToStop.add(uri);
        }
        for (URI uri : servicesToStop) {
            stopService(uri, bundleStopping);
        }
        servicesInfo.clear();
    }

    /**
     * 
     * @param uri
     * @param bundleStopping
     * @throws AnzoException
     */
    public void stopService(URI uri, boolean bundleStopping) throws AnzoException {
        ServiceInfo serviceInfo = servicesInfo.get(uri);
        if (serviceInfo == null) {
            // this means the service isn't owned by this executor
            return;
        }
        RestrictedAnzoClient anzoClient = null;
        try {
            if (serviceInfo.anzoClient != null) {
                anzoClient = serviceInfo.anzoClient;
            } else {
                anzoClient = getServiceClient(false, serviceInfo.username, uri.toString());
            }
            stopService(uri, anzoClient);
            servicesInfo.remove(uri);
        } finally {
            // we'll be closing either the client associated with a long running service,
            // or a client we just instantiated for the stop() call.
            if (anzoClient != null) {
                anzoClientPool.returnAnzoClient(anzoClient, bundleStopping);
            }
        }
    }

    /**
     * Set the anzo client pool
     * 
     * @param anzoClientPool
     */
    public void setAnzoClientPool(AnzoClientPool anzoClientPool) {
        this.anzoClientPool = anzoClientPool;
    }

    public void setHostExecutionService(SemanticServiceExecutionService executionService) {
        hostExecutionService = executionService;
        // register any services that have been loaded thus far
        for (URI uri : servicesInfo.keySet()) {
            hostExecutionService.registerService(uri, getServiceTypeUri());
        }
    }

    protected IDataset getServiceRegistry() {
        return serviceRegistry;
    }

    protected boolean serviceLoaded(URI serviceUri) {
        return servicesInfo.containsKey(serviceUri);
    }

    protected void loadService(SemanticService service) throws AnzoException {
        if (serviceLoaded((URI) service.resource())) {
            return;
        }
        boolean closeClient = true;
        RestrictedAnzoClient anzoClient = null;
        try {
            ServiceInfo serviceInfo = new ServiceInfo();
            String username = service.getServiceUser();
            if (username != null) {
                serviceInfo.username = username;
            }
            boolean longRunning = false;
            if (service.getStateStyle().resource().equals(StateStyleEnum.LongRunningStyle)) {
                longRunning = true;
            }
            anzoClient = getServiceClient(longRunning, serviceInfo.username, service.uri());
            //What are we doing here?
            anzoClient.begin();
            anzoClient.commit();
            if (serviceInfo.username == null) {
                serviceInfo.username = anzoClient.getServiceUser();
            }

            boolean serviceReady = initializeService(service, anzoClient);
            if (serviceReady) {
                // if the service isn't ready, then it will have to call us back 
                // later to load itself.  
                URI serviceUri = (URI) service.resource();
                servicesInfo.put(serviceUri, serviceInfo);

                for (SemanticOperation operation : service.getOperation()) {
                    URI opuri = (URI) operation.resource();
                    verifyOperation(serviceUri, opuri);
                    serviceInfo.operations.add(opuri);
                }

                // If necessary, instantiate an AnzoClient that the service will use to perform its function.
                if (longRunning) {
                    serviceInfo.anzoClient = anzoClient;
                    closeClient = false;
                }
                serviceInfo.stateStyle = (URI) service.getStateStyle().resource();
                if (hostExecutionService != null) {
                    hostExecutionService.registerService(serviceUri, getServiceTypeUri());
                }
            }
        } catch (AnzoException e) {
            throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, e);
        } finally {
            if (closeClient && anzoClient != null) {
                anzoClientPool.returnAnzoClient(anzoClient, true);
            }
        }
    }

    protected RestrictedAnzoClient getServiceClient(boolean longRunning, String user, String userDescription) throws AnzoException {
        RestrictedAnzoClient anzoClient = anzoClientPool.getAnzoClient(longRunning, userDescription);
        if (user != null) {
            anzoClient.setServiceUser(user);
        }
        return anzoClient;
    }

    public void executeService(IOperationContext context, URI serviceUri, URI operationUri, boolean requestDefinedService, IDataset request, IDataset response) throws AnzoException {

        ServiceInfo serviceInfo = servicesInfo.get(serviceUri);
        if (serviceInfo == null) {
            if (!requestDefinedService) {
                throw new AnzoException(ExceptionConstants.EXECUTION.UNKNOWN_SERVICE_ERROR, serviceUri.toString());
            } else {
                serviceInfo = new ServiceInfo();
                serviceInfo.stateStyle = StateStyleEnum.ConnectionStyle;
            }
        }

        RestrictedAnzoClient anzoClient = getServiceClient(false, serviceInfo.username, serviceUri.toString() + ":" + operationUri.toString());
        try {
            if (anzoClient.namedGraphExists(serviceUri)) {
                anzoClient.setServiceUser(context.getOperationPrincipal().getName());
                boolean canExecService = anzoClient.canReadNamedGraph(serviceUri);
                if (!canExecService) {
                    //TODO: Should this throw an error saying no permission
                    throw new AnzoException(ExceptionConstants.EXECUTION.UNKNOWN_SERVICE_ERROR, serviceUri.toString());
                }

                anzoClient.setServiceUser(serviceInfo.username);
                if (anzoClient.namedGraphExists(operationUri)) {
                    anzoClient.setServiceUser(context.getOperationPrincipal().getName());
                    boolean canExecOp = anzoClient.canReadNamedGraph(operationUri);
                    if (!canExecOp) {
                        //TODO: Should this throw an error saying no permission
                        throw new AnzoException(ExceptionConstants.EXECUTION.UNKNOWN_OPERATION_ERROR, serviceUri.toString(), operationUri.toString());
                    }
                }
            }
        } finally {
            anzoClientPool.returnAnzoClient(anzoClient, true);
        }
        RestrictedAnzoClient execClient = null;
        if (serviceInfo.stateStyle.equals(StateStyleEnum.LongRunningStyle)) {
            execClient = serviceInfo.anzoClient;
        } else if (serviceInfo.stateStyle.equals(StateStyleEnum.ConnectionStyle)) {
            try {
                execClient = anzoClientPool.getAnzoClient(false, serviceUri.toString() + ":" + operationUri.toString());
                execClient.setServiceUser(serviceInfo.username);
            } catch (Exception e) {
                throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, e);
            }
        }

        ExecutionContext ec = new ExecutionContext(serviceInfo, context, serviceUri, operationUri, execClient);

        try {
            executeService(serviceUri, operationUri, ec, request, response);
        } finally {
            if (serviceInfo.stateStyle.equals(StateStyleEnum.ConnectionStyle)) {
                try {
                    anzoClientPool.returnAnzoClient(execClient, true);
                } catch (Exception e) {
                    throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, e);
                }
            }
        }
    }

    static class ServiceInfo {

        RestrictedAnzoClient anzoClient;

        Set<URI>             operations = new HashSet<URI>();

        String               username;

        URI                  stateStyle;
    }

    /**
     * 
     * @author bszekely
     * 
     */
    static class ExecutionContext implements IExecutionContext {

        ServiceInfo          serviceInfo      = null;

        IOperationContext    operationContext = null;

        RestrictedAnzoClient anzoClient       = null;

        URI                  serviceUri       = null;

        URI                  operationUri     = null;

        ExecutionContext(ServiceInfo serviceInfo, IOperationContext operationContext, URI serviceUri, URI operationUri, RestrictedAnzoClient anzoClient) {
            this.serviceInfo = serviceInfo;
            this.operationContext = operationContext;
            this.operationUri = operationUri;
            this.serviceUri = serviceUri;
            this.anzoClient = anzoClient;
        }

        public void executeAsRequestUser() {
            try {
                if (anzoClient != null) {
                    anzoClient.setServiceUser(operationContext.getOperationPrincipal().getName());
                }
            } catch (AnzoException e) {
                throw new AnzoRuntimeException(e);
            }
        }

        public void executeAsServiceUser() {
            try {
                if (anzoClient != null) {
                    anzoClient.setServiceUser(serviceInfo.username);
                }
            } catch (AnzoException e) {
                throw new AnzoRuntimeException(e);
            }
        }

        public AnzoClient getAnzoClient() {
            return anzoClient;
        }

        public URI getOperationURI() {
            return operationUri;
        }

        public AnzoPrincipal getRequestUser() {
            return operationContext.getOperationPrincipal();
        }

        public URI getServiceURI() {
            return serviceUri;
        }

        public IOperationContext getOperationContext() {
            return operationContext;
        }

    }

    class DsListener implements DatasetListener {

        public void namedGraphAdded(org.openanzo.ontologies.openanzo.Dataset source, NamedGraph newValue) {
            log.debug("!!!! Named Graph Added: " + this + " " + newValue.resource());
            //System.err.println("!!!! Named Graph Added: " + BaseServiceExecutor.this + " " + newValue.resource());
            URI newServiceUri = (URI) newValue.resource();
            SemanticService service = SemanticServiceFactory.getSemanticService(newServiceUri, BaseServiceExecutor.this.serviceRegistry);
            try {
                if (service == null || !service.isRDFType(getServiceTypeUri())) {
                    return;
                }
                loadService(service);
            } catch (Exception e) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error loading service:" + newServiceUri.toString(), e);
            }
        }

        public void namedGraphRemoved(org.openanzo.ontologies.openanzo.Dataset source, NamedGraph oldValue) {
            URI oldServiceUri = (URI) oldValue.resource();
            try {
                stopService(oldServiceUri, true);
            } catch (Exception e) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error stopping service:" + oldServiceUri.toString(), e);
            }
        }

        public void defaultNamedGraphAdded(Dataset source, NamedGraph newValue) {
            namedGraphAdded(source, newValue);
        }

        public void defaultNamedGraphRemoved(Dataset source, NamedGraph oldValue) {
            namedGraphRemoved(source, oldValue);
        }

        public void defaultGraphAdded(org.openanzo.ontologies.openanzo.Dataset source, NamedGraph newValue) {
        }

        public void defaultGraphRemoved(org.openanzo.ontologies.openanzo.Dataset source, NamedGraph oldValue) {
        }

        public void includeMetadataGraphsChanged(Dataset source) {
        }
    }
}
