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
package org.openanzo.execution.javascript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.mozillax.javascript.Context;
import org.mozillax.javascript.ContextFactory;
import org.mozillax.javascript.Function;
import org.mozillax.javascript.Scriptable;
import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.execution.BaseServiceExecutor;
import org.openanzo.execution.IExecutionContext;
import org.openanzo.ontologies.execution.JavascriptSemanticService;
import org.openanzo.ontologies.execution.SemanticService;
import org.openanzo.ontologies.execution.SemanticServiceFactory;
import org.openanzo.osgi.registry.RegistryDataset;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The JavaScript Semantic Service Executor
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
class JavascriptServiceExecutor extends BaseServiceExecutor {

    private static final Logger log      = LoggerFactory.getLogger(JavascriptServiceExecutor.class);

    Map<URI, JavascriptService> services = new HashMap<URI, JavascriptService>();

    @Override
    public boolean initializeService(SemanticService service, AnzoClient anzoClient) throws AnzoException {
        JavascriptSemanticService javascriptService = SemanticServiceFactory.getJavascriptSemanticService(service.resource(), service.graph());
        String resource = javascriptService.getScriptResource();
        InputStream in = getClass().getResourceAsStream(resource);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in, Constants.byteEncoding));
            StringBuilder script = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                script.append("\r\n").append(line);
                line = reader.readLine();
            }
            Context cx = ContextFactory.getGlobal().enterContext();
            try {
                Scriptable scope = cx.initStandardObjects();
                cx.evaluateString(scope, script.toString(), service.uri(), 1, null);
                setupJavascriptObjects(scope);
                Object serviceObj = scope.get("service", scope);
                if (serviceObj == Scriptable.NOT_FOUND) {
                    throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, "Could not find service object in Javascript service");
                }
                Scriptable serviceObject = (Scriptable) serviceObj;
                Object initObj = serviceObject.get("initialize", serviceObject);
                if (!(initObj instanceof Function)) {
                    throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, "Service object does not contain initialize method");
                }

                Object stopObj = serviceObject.get("stop", serviceObject);
                if (!(stopObj instanceof Function)) {
                    throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, "Service object does not contain stop method");
                }

                Function initializeFunction = (Function) initObj;
                initializeFunction.call(cx, scope, scope, new Object[] { service, anzoClient });

                JavascriptService serviceInfo = new JavascriptService();
                serviceInfo.serviceScript = script.toString();
                serviceInfo.serviceScope = scope;
                services.put((URI) service.resource(), serviceInfo);
            } finally {
                Context.exit();
            }
            return true;
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, e);
        } catch (Throwable e) {
            log.error(LogUtils.EXECUTION_MARKER, "Javascript Error:", e);
            return false;
        } finally {
            try {
                if (reader != null)
                    reader.close();
                in.close();
            } catch (IOException e) {
                throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, e);
            }
        }
    }

    @Override
    public void executeService(URI serviceUri, URI operationUri, IExecutionContext ec, IDataset request, IDataset response) throws AnzoException {
        JavascriptService serviceInfo = services.get(serviceUri);
        String operation = operationUri.getLocalName();
        Context cx = ContextFactory.getGlobal().enterContext();
        try {
            Scriptable scope = cx.newObject(serviceInfo.serviceScope);
            scope.setPrototype(serviceInfo.serviceScope);
            scope.setParentScope(null);
            cx.evaluateString(scope, serviceInfo.serviceScript, serviceUri.toString(), 1, null);
            Scriptable serviceObject = (Scriptable) scope.get("service", scope);
            Object funcObj = serviceObject.get(operation, serviceObject);
            if (!(funcObj instanceof Function)) {
                throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, "Unknown operation: " + operation);
            }
            Function function = (Function) funcObj;
            Object[] args = new Object[] { ec, request, response };
            function.call(cx, scope, scope, args);
        } finally {
            Context.exit();
        }

    }

    @Override
    public void registryReset(RegistryDataset registry) throws AnzoException {
        // shouldn't have to do anything here.        
    }

    @Override
    public void stopService(URI serviceUri, AnzoClient anzoClient) throws AnzoException {
        JavascriptService serviceInfo = services.get(serviceUri);
        Context cx = ContextFactory.getGlobal().enterContext();
        try {
            Scriptable scope = cx.newObject(serviceInfo.serviceScope);
            scope.setPrototype(serviceInfo.serviceScope);
            scope.setParentScope(null);
            cx.evaluateString(scope, serviceInfo.serviceScript, serviceUri.toString(), 1, null);
            Object serviceObj = scope.get("service", scope);
            Scriptable serviceObject = (Scriptable) serviceObj;
            Object stopObj = serviceObject.get("stop", serviceObject);
            Function stopFunction = (Function) stopObj;
            stopFunction.call(cx, scope, scope, null);
        } finally {
            Context.exit();
        }

    }

    @Override
    public void verifyOperation(URI serviceUri, URI operationUri) throws AnzoException {
        JavascriptService serviceInfo = services.get(serviceUri);
        Context cx = ContextFactory.getGlobal().enterContext();
        try {
            Scriptable scope = cx.newObject(serviceInfo.serviceScope);
            scope.setPrototype(serviceInfo.serviceScope);
            scope.setParentScope(null);
            cx.evaluateString(scope, serviceInfo.serviceScript, serviceUri.toString(), 1, null);
            Scriptable serviceObject = (Scriptable) scope.get("service", scope);
            String op = operationUri.getLocalName();
            Object funcObj = serviceObject.get(op, serviceObject);
            if (!(funcObj instanceof Function)) {
                throw new AnzoException(ExceptionConstants.EXECUTION.SERVICE_INITIALIZATION_ERROR, "Unknown operation: " + op);
            }
        } finally {
            Context.exit();
        }
    }

    private void setupJavascriptObjects(Scriptable scope) {
        scope.put("valueFactory", scope, Constants.valueFactory);
        scope.put("log", scope, log);
    }

    public URI getServiceTypeUri() {
        return JavascriptSemanticService.TYPE;
    }

    public URI getServiceUri(URI operationUri, IDataset request) throws AnzoException {
        return null;
    }

    private static class JavascriptService {

        Scriptable serviceScope;

        String     serviceScript;

    }

}
