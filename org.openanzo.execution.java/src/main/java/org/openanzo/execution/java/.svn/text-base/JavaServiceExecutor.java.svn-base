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
package org.openanzo.execution.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.execution.BaseServiceExecutor;
import org.openanzo.execution.IExecutionContext;
import org.openanzo.ontologies.execution.JavaSemanticService;
import org.openanzo.ontologies.execution.SemanticOperation;
import org.openanzo.ontologies.execution.SemanticService;
import org.openanzo.ontologies.execution.SemanticServiceFactory;
import org.openanzo.ontologies.execution.StateStyleEnum;
import org.openanzo.osgi.registry.RegistryDataset;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.AnzoMultiMap;
import org.openanzo.services.ACLUtil;
import org.openanzo.services.DynamicServiceStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Java Service Executor
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class JavaServiceExecutor extends BaseServiceExecutor {

    private static final Logger                       log              = LoggerFactory.getLogger(JavaServiceExecutor.class);

    private static final String                       ENABLE_STATS     = "enableStats";

    private static final String                       DISABLE_STATS    = "disableStats";

    // map from service URI to service implementation
    private Map<URI, ISemanticService>                services         = new HashMap<URI, ISemanticService>();

    // map from service factory PID to the factory
    private Map<String, ISemanticServiceFactory>      serviceFactories = new HashMap<String, ISemanticServiceFactory>();

    private AnzoMultiMap<String, JavaSemanticService> factoryServices  = new AnzoMultiMap<String, JavaSemanticService>();

    void registerService(IBundledSemanticService service, IDataset serviceRegistry) throws AnzoException {
        services.put(service.getServiceUri(), service);

        URI serviceUri = service.getServiceUri();
        if (serviceRegistry.containsNamedGraph(serviceUri)) {
            log.info(LogUtils.LIFECYCLE_MARKER, "Do not need to update registry for bundled service because it already exists in registry: " + serviceUri);
            if (serviceLoaded(serviceUri)) {
                log.info(LogUtils.LIFECYCLE_MARKER, "Service already loaded: " + serviceUri);
            } else {
                JavaSemanticService javaService = SemanticServiceFactory.getJavaSemanticService(serviceUri, serviceRegistry);
                loadService(javaService);
            }
            return;
        } else {
            IAnzoGraph graph = (IAnzoGraph) serviceRegistry.addNamedGraph(serviceUri);
            if (service.getRestrictInitialPermission()) {
                ACLUtil.setReadPermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setAddPermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setRemovePermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setReadMetadataPermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setAddMetadataPermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setRemoveMetadataPermission(graph, Constants.NOONE_ROLE, true);
            } else {
                ACLUtil.setReadPermission(graph, Constants.EVERYONE_ROLE, true);
            }
            JavaSemanticService javaService = SemanticServiceFactory.createJavaSemanticService(serviceUri, serviceRegistry);
            javaService.setServiceUser(service.getServiceUser());
            if (service.isLongRunning()) {
                javaService.setStateStyle(StateStyleEnum.LongRunningStyle);
            } else {
                javaService.setStateStyle(StateStyleEnum.ConnectionStyle);
            }
            Method[] methods = service.getClass().getMethods();
            ArrayList<String> operations = new ArrayList<String>();
            DynamicServiceStats serviceStats = service.getStatistics();

            for (int i = 0; i < methods.length; i++) {
                @SuppressWarnings("unchecked")
                Class[] params = methods[i].getParameterTypes();
                if (params.length != 3) {
                    continue;
                } else {
                    if (params[0].equals(IExecutionContext.class) && params[1].equals(IDataset.class) && params[2].equals(IDataset.class)) {
                        operations.add(methods[i].getName());
                        if (serviceStats != null) {
                            serviceStats.addMethod(methods[i].getName());
                        }
                    }
                }
            }
            if (serviceStats != null) {
                operations.add(ENABLE_STATS);
                operations.add(DISABLE_STATS);
            }
            for (String op : operations) {
                URI opUri = Constants.valueFactory.createURI(serviceUri.toString() + "#" + op);
                SemanticOperation operation = SemanticServiceFactory.createSemanticOperation(opUri, javaService.graph());
                javaService.addOperation(operation);
            }
        }

    }

    void unregisterService(IBundledSemanticService service) {
        try {
            stopService(service.getServiceUri(), true);
        } catch (AnzoException e) {
            log.error("Could not stop service: " + service.getServiceUri(), e);
        }
        services.remove(service.getServiceUri());
    }

    Collection<JavaSemanticService> registerServiceFactory(String serviceFactoryPid, ISemanticServiceFactory serviceFactory) throws AnzoException {
        serviceFactories.put(serviceFactoryPid, serviceFactory);
        // TODO: query the registry to see if we have a service that uses this factory that
        // couldn't start because the factory wasn't registered yet.
        Collection<Statement> stmts = serviceRegistry.find(null, JavaSemanticService.serviceFactoryPidProperty, Constants.valueFactory.createTypedLiteral(serviceFactoryPid));
        for (Statement stmt : stmts) {
            URI serviceUri = (URI) stmt.getSubject();
            if (!services.containsKey(serviceUri)) {
                JavaSemanticService service = SemanticServiceFactory.getJavaSemanticService(serviceUri, serviceRegistry);
                ISemanticService javaService = serviceFactory.createService(service);
                // the service will get initialized by the loadService call, which will call initializeService
                services.put(serviceUri, javaService);
                loadService(service);
                factoryServices.put(serviceFactoryPid, service);
            }
        }
        return factoryServices.getCollection(serviceFactoryPid);
    }

    Collection<JavaSemanticService> unregisterServiceFactory(String serviceFactoryPid) {
        // should we be maintaining a list of services created by the factory and stop them here?
        serviceFactories.remove(serviceFactoryPid);
        return factoryServices.remove(serviceFactoryPid);
    }

    @Override
    public boolean initializeService(SemanticService service, AnzoClient anzoClient) throws AnzoException {
        if (services.containsKey(service.resource())) {
            ISemanticService ss = services.get(service.resource());
            JavaSemanticService javaService = SemanticServiceFactory.getJavaSemanticService(service.resource(), service.graph());
            ss.initialize(javaService, anzoClient);
            return true;
        } else {
            // otherwise check if a factory has been registered for it. 
            JavaSemanticService javaService = SemanticServiceFactory.getJavaSemanticService(service.resource(), service.graph().getNamedGraphUri(), service.dataset());
            String factoryPid = javaService.getServiceFactoryPid();
            ISemanticServiceFactory factory = serviceFactories.get(factoryPid);
            if (factory == null) {
                return false;
            }
            ISemanticService ss = factory.createService(javaService);
            ss.initialize(javaService, anzoClient);
            services.put((URI) service.resource(), ss);
            return true;
        }
    }

    @Override
    public void stopService(URI serviceUri, AnzoClient anzoClient) throws AnzoException {
        ISemanticService ss = services.get(serviceUri);
        if (ss != null) {
            ss.stop(anzoClient);
            // remove anything created by a factory since when we load the service again,
            // we'll recreate the instance. 
            if (!(ss instanceof IBundledSemanticService)) {
                services.remove(serviceUri);
            }
        }
    }

    @Override
    public void verifyOperation(URI serviceUri, URI operationUri) throws AnzoException {
        try {
            ISemanticService service = services.get(serviceUri);
            String operationName = operationUri.getLocalName();
            if (ENABLE_STATS.equals(operationName)) {
                if (service.getStatistics() == null)
                    throw new Exception("No statistics object to enable");
            } else if (DISABLE_STATS.equals(operationName)) {
                if (service.getStatistics() == null)
                    throw new Exception("No statistics object to disable");
            } else {
                service.getClass().getMethod(operationUri.getLocalName(), IExecutionContext.class, IDataset.class, IDataset.class);
            }
        } catch (Exception e) {
            throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, e);
        }
    }

    @Override
    public void executeService(URI serviceUri, URI operationUri, IExecutionContext ec, IDataset request, IDataset response) throws AnzoException {
        try {
            ISemanticService ss = services.get(serviceUri);
            long start = 0;
            if (ss.getStatistics() != null && ss.getStatistics().isEnabled()) {
                start = System.currentTimeMillis();
            }
            String operation = operationUri.getLocalName();
            if (ENABLE_STATS.equals(operation)) {
                ss.getStatistics().setEnabled(true);
            } else if (DISABLE_STATS.equals(operation)) {
                ss.getStatistics().setEnabled(false);
            } else {
                try {
                    Method method = ss.getClass().getMethod(operation, IExecutionContext.class, IDataset.class, IDataset.class);
                    method.invoke(ss, ec, request, response);
                } finally {
                    if (ss.getStatistics() != null && ss.getStatistics().isEnabled()) {
                        ss.getStatistics().use(operation, System.currentTimeMillis() - start);
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            throw new AnzoException(ExceptionConstants.EXECUTION.UNKNOWN_OPERATION_ERROR, e, serviceUri.toString(), operationUri.toString());
        } catch (IllegalAccessException e) {
            throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, e, serviceUri.toString(), operationUri.toString());
        } catch (InvocationTargetException e) {
            throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, e.getTargetException(), serviceUri.toString(), operationUri.toString(), e.getTargetException().getMessage());
        }

    }

    public URI getServiceTypeUri() {
        return JavaSemanticService.TYPE;
    }

    public URI getServiceUri(URI operationUri, IDataset request) throws AnzoException {
        return null;
    }

    @Override
    public void registryReset(RegistryDataset registry) throws AnzoException {
        for (Map.Entry<URI, ISemanticService> entry : services.entrySet()) {
            if (entry.getValue() instanceof IBundledSemanticService) {
                registerService((IBundledSemanticService) entry.getValue(), registry);
            }
        }
        for (Map.Entry<String, ISemanticServiceFactory> entry : serviceFactories.entrySet()) {
            registerServiceFactory(entry.getKey(), entry.getValue());
        }
    }

}
