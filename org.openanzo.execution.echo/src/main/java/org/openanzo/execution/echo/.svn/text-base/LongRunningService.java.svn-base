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
import java.util.Collections;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.client.IStatementChannel;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.execution.IExecutionContext;
import org.openanzo.execution.java.ISemanticService;
import org.openanzo.ontologies.execution.JavaSemanticService;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.DynamicServiceStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Simple service, deployed for testing.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class LongRunningService implements ISemanticService {

    private static final Logger log        = LoggerFactory.getLogger(LongRunningService.class);

    private boolean             activated  = false;

    HashMap<Long, UpdateData>   updateData = new HashMap<Long, UpdateData>();

    DynamicServiceStats         stats      = new DynamicServiceStats();

    LongRunningService() {

    }

    public void initialize(JavaSemanticService serviceConfig, AnzoClient anzoClient) throws AnzoException {

    }

    public void stop(AnzoClient anzoClient) throws AnzoException {
        for (Long l : updateData.keySet()) {
            UpdateData data = updateData.get(l);
            if (!data.graph.isClosed()) {
                data.graph.close();
            }
            data.timer.cancel();
        }
    }

    public String getDescription() {
        return "Long running service";
    }

    public String getName() {
        return "Service=LongRunningService";
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    /**
     * Activate the service
     * 
     * @param context
     * @param request
     * @param response
     * @throws AnzoException
     */
    public void activate(IExecutionContext context, IDataset request, IDataset response) throws AnzoException {

        if (activated) {
            response.addNamedGraph(context.getOperationURI());
            INamedGraph graph = response.getNamedGraph(context.getOperationURI());
            URI predicate = Constants.valueFactory.createURI(context.getServiceURI().toString() + "#activationStatus");
            Literal literal = Constants.valueFactory.createLiteral("alreadyActivated");
            graph.add(context.getOperationURI(), predicate, literal);
            return;
        }

        AnzoClient anzoClient = context.getAnzoClient();
        anzoClient.begin();
        ClientGraph graph = anzoClient.getReplicaGraph(context.getServiceURI());
        anzoClient.commit();
        URI channelUri = Constants.valueFactory.createURI(context.getServiceURI().toString() + "#channel");
        final IStatementChannel channel = anzoClient.getStatementChannel(channelUri, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
        anzoClient.updateRepository();

        graph.registerListener(new IStatementListener<INamedGraph>() {

            public void statementsAdded(INamedGraph source, Statement... statements) {
                try {
                    log.debug("Relaying statements: " + statements.length);
                    channel.sendMessage(null, Collections.singleton(statements[0]));
                } catch (AnzoException e) {
                    log.error("Error forwarding event to channel.", e);
                }
            }

            public void statementsRemoved(INamedGraph source, Statement... statements) {
                System.err.println("Sending - statement on channel: " + statements[0]);

            }

        });

        activated = true;
        response.addNamedGraph(context.getOperationURI());
        INamedGraph g = response.getNamedGraph(context.getOperationURI());
        URI predicate = Constants.valueFactory.createURI(context.getServiceURI().toString() + "#activationStatus");
        Literal literal = Constants.valueFactory.createLiteral("activationSuccessful");
        g.add(context.getOperationURI(), predicate, literal);
        return;

    }

    /**
     * 
     * @param context
     * @param request
     * @param response
     * @throws AnzoException
     */
    public void count(IExecutionContext context, IDataset request, IDataset response) throws AnzoException {
        ClientGraph graph = null;
        try {
            context.executeAsRequestUser();
            AnzoClient anzoClient = context.getAnzoClient();
            anzoClient.begin();
            graph = anzoClient.getServerGraph(context.getServiceURI());

            URI predicate = Constants.valueFactory.createURI(context.getServiceURI().toString() + "#hasCount");
            Collection<Statement> stmts = graph.find(context.getServiceURI(), predicate, null);
            if (stmts.isEmpty()) {
                graph.add(context.getServiceURI(), predicate, Constants.valueFactory.createLiteral(1));
            } else {
                Literal literal = (Literal) stmts.iterator().next().getObject();
                int count = Integer.parseInt(literal.getLabel());
                graph.remove(stmts);
                graph.add(context.getServiceURI(), predicate, Constants.valueFactory.createLiteral(count + 1));
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
     * 
     * @param context
     * @param request
     * @param response
     * @throws AnzoException
     */
    public void startUpdating(IExecutionContext context, IDataset request, IDataset response) throws AnzoException {
        URI updateNamedGraphPredicate = Constants.valueFactory.createURI(context.getServiceURI() + "#updateNamedGraph");
        URI updatePeriodPredicate = Constants.valueFactory.createURI(context.getServiceURI() + "#updatePeriod");
        URI updatePredicatePredicate = Constants.valueFactory.createURI(context.getServiceURI() + "#updatePredicate");
        URI updateResourcePredicate = Constants.valueFactory.createURI(context.getServiceURI() + "#updateResource");
        URI updateRangePredicate = Constants.valueFactory.createURI(context.getServiceURI() + "#updateRange");
        URI updateKeyPredicate = Constants.valueFactory.createURI(context.getServiceURI() + "#updateKey");

        Collection<Statement> stmts = request.find(context.getOperationURI(), updateNamedGraphPredicate, null, context.getOperationURI());
        if (stmts.isEmpty()) {
            throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, "Missing predicate: " + updateNamedGraphPredicate);
        }
        final URI updateNamedGraph = (URI) stmts.iterator().next().getObject();

        stmts = request.find(context.getOperationURI(), updatePeriodPredicate, null, context.getOperationURI());
        if (stmts.isEmpty()) {
            throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, "Missing predicate: " + updatePeriodPredicate);
        }
        final long updatePeriod = Long.parseLong(((Literal) stmts.iterator().next().getObject()).getLabel());

        stmts = request.find(context.getOperationURI(), updatePredicatePredicate, null, context.getOperationURI());
        if (stmts.isEmpty()) {
            throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, "Missing predicate: " + updatePredicatePredicate);
        }
        final URI updatePredicate = (URI) stmts.iterator().next().getObject();

        stmts = request.find(context.getOperationURI(), updateResourcePredicate, null, context.getOperationURI());
        if (stmts.isEmpty()) {
            throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, "Missing predicate: " + updateResourcePredicate);
        }
        final URI updateResource = (URI) stmts.iterator().next().getObject();

        stmts = request.find(context.getOperationURI(), updateRangePredicate, null, context.getOperationURI());
        if (stmts.isEmpty()) {
            throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, "Missing predicate: " + updateRangePredicate);
        }
        final long updateRange = Long.parseLong(((Literal) stmts.iterator().next().getObject()).getLabel());

        final long updateKey = Math.round(Math.random() * 100000);

        final AnzoClient client = context.getAnzoClient();

        client.begin();
        final ClientGraph graph = context.getAnzoClient().getServerGraph(updateNamedGraph);
        client.commit();
        client.updateRepository();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                client.begin();
                graph.remove(updateResource, updatePredicate, null);
                long rand = Math.round(Math.random() * updateRange);
                graph.add(updateResource, updatePredicate, Constants.valueFactory.createLiteral(rand));
                client.commit();
                try {
                    client.updateRepository();
                } catch (Exception e) {
                    log.error("Error updating repository in timer", e);
                }
            }
        };

        Timer timer = new Timer();
        UpdateData data = new UpdateData();
        data.timer = timer;
        data.graph = graph;

        updateData.put(updateKey, data);

        timer.schedule(task, updatePeriod, updatePeriod);

        response.addNamedGraph(context.getOperationURI());
        response.add(context.getOperationURI(), updateKeyPredicate, Constants.valueFactory.createLiteral(updateKey), context.getOperationURI());

    }

    /**
     * 
     * @param context
     * @param request
     * @param response
     * @throws AnzoException
     */
    public void stopUpdating(IExecutionContext context, IDataset request, IDataset response) throws AnzoException {
        URI updateKeyPredicate = Constants.valueFactory.createURI(context.getServiceURI() + "#updateKey");

        Collection<Statement> stmts = request.find(context.getOperationURI(), updateKeyPredicate, null, context.getOperationURI());
        if (stmts.isEmpty()) {
            throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, "Missing predicate: " + updateKeyPredicate);
        }
        long updateKey = Long.parseLong(((Literal) stmts.iterator().next().getObject()).getLabel());
        UpdateData data = updateData.get(updateKey);
        if (data == null) {
            throw new AnzoException(ExceptionConstants.EXECUTION.EXECUTION_ERROR, "Unknown update key: " + updateKey);
        }
        data.timer.cancel();
        data.graph.close();
    }

    static class UpdateData {

        Timer       timer = null;

        ClientGraph graph = null;

    }

}
