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
package org.openanzo.execution.echo;

import java.util.Collection;
import java.util.Dictionary;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.execution.IExecutionContext;
import org.openanzo.execution.java.IBundledSemanticService;
import org.openanzo.ontologies.execution.JavaSemanticService;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.ServicesDictionary;

/**
 * 
 * Simple service, deployed for testing.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class EchoSemanticService implements IBundledSemanticService {

    static final URI    serviceURI = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/echoService");

    String              user       = null;

    DynamicServiceStats stats      = new DynamicServiceStats();

    EchoSemanticService(Dictionary<? extends Object, ? extends Object> configProperties) {
        user = ServicesDictionary.getUser(configProperties, null);
    }

    public URI getServiceUri() {
        return serviceURI;
    }

    public String getServiceUser() {
        return user;
    }

    public boolean isLongRunning() {
        return false;
    }

    public String getDescription() {
        return "Echo service";
    }

    public String getName() {
        return "Service=EchoService";
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    /**
     * Return the statements into the request
     * 
     * @param context
     *            the execution context
     * @param request
     *            request statements
     * @param response
     *            response statements
     * @throws AnzoException
     */
    public void echo(IExecutionContext context, IDataset request, IDataset response) throws AnzoException {

        for (Statement statement : request.getStatements()) {
            if (!response.containsNamedGraph(statement.getNamedGraphUri())) {
                // not all implementations of IDataset support adding graphs by URI only.
                response.addNamedGraph(statement.getNamedGraphUri());
            }
            response.add(statement);
        }
    }

    /**
     * Count service
     * 
     * @param context
     *            the execution context
     * @param request
     *            request statements
     * @param response
     *            response statements
     * @throws AnzoException
     */
    public void count(IExecutionContext context, IDataset request, IDataset response) throws AnzoException {
        ClientGraph graph = null;
        try {
            context.executeAsRequestUser();
            AnzoClient anzoClient = context.getAnzoClient();
            anzoClient.begin();
            graph = anzoClient.getServerGraph(context.getOperationURI());
            URI predicate = Constants.valueFactory.createURI(context.getServiceURI().toString() + "#hasCount");
            Collection<Statement> stmts = graph.find(context.getOperationURI(), predicate, null);
            if (stmts.isEmpty()) {
                graph.add(context.getOperationURI(), predicate, Constants.valueFactory.createLiteral(1));
            } else {
                Literal literal = (Literal) stmts.iterator().next().getObject();
                int count = Integer.parseInt(literal.getLabel());
                graph.remove(stmts);
                graph.add(context.getOperationURI(), predicate, Constants.valueFactory.createLiteral(count + 1));
            }
            response.addNamedGraph(graph.getNamedGraphUri());
            response.add(graph.getStatements());
            anzoClient.commit();
            anzoClient.updateRepository();
        } finally {
            if (graph != null) {
                graph.close();
            }
        }
    }

    /**
     * Secret service
     * 
     * @param context
     * @param request
     * @param response
     * @throws AnzoException
     */
    public void secret(IExecutionContext context, IDataset request, IDataset response) throws AnzoException {
        response.addNamedGraph(context.getOperationURI());
        INamedGraph graph = response.getNamedGraph(context.getOperationURI());
        URI predicate = Constants.valueFactory.createURI(context.getServiceURI().toString() + "#message");
        Literal literal = Constants.valueFactory.createLiteral("secret");
        graph.add(context.getOperationURI(), predicate, literal);

    }

    public void initialize(JavaSemanticService service, AnzoClient anzoClient) throws AnzoException {

    }

    public void stop(AnzoClient anzoClient) throws AnzoException {

    }

    public boolean getRestrictInitialPermission() {
        return true;
    }
}
