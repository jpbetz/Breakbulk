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
package org.openanzo.client.pool;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.client.IAnzoClientConnectionListener;
import org.openanzo.client.INamedGraphInitializer;
import org.openanzo.client.IStatementChannel;
import org.openanzo.client.ITransactionListener;
import org.openanzo.client.RealtimeUpdateManager;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.datasource.IDatasource;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.IUpdatesProvider;

/**
 * 
 * A version of AnzoClient that only allows certain methods to be invoked. Used by semantic services.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class RestrictedAnzoClient extends AnzoClient {

    final boolean useJms;

    /**
     * Create an AnzoClient that restricts certain operations
     * 
     * @param configuration
     * @param datasource
     * @param authenticationService
     * @param executionService
     * @param updatesProvider
     * @param jmsProvider
     * @param enableJMS
     * @throws AnzoException
     */
    public RestrictedAnzoClient(Dictionary<? extends Object, ? extends Object> configuration, IDatasource datasource, IAuthenticationService authenticationService, IExecutionService executionService, IUpdatesProvider updatesProvider, IJmsProvider jmsProvider, boolean enableJMS) throws AnzoException {
        super(configuration, datasource, authenticationService, executionService, updatesProvider, jmsProvider, enableJMS);
        this.useJms = enableJMS;
    }

    /**
     * Restricted close
     */
    public void restrictedClose() {
        super.close();
    }

    /**
     * Restricted close
     * 
     * @param closeJms
     *            if true, close the jms connection
     */
    public void restrictedClose(boolean closeJms) {
        super.close(closeJms);
    }

    @Override
    public IDataset createReplicaDataset(boolean persisted, URI datasetUri, Set<URI> defaultGraphUris, Set<URI> namedGraphUris, INamedGraphInitializer... namedGraphInitializers) {
        return super.createReplicaDataset(persisted, datasetUri, defaultGraphUris, namedGraphUris, namedGraphInitializers);
    }

    @Override
    public IDataset createServerDataset(boolean persisted, URI datasetUri, Set<URI> defaultGraphUris, Set<URI> namedGraphUris, INamedGraphInitializer... namedGraphInitializers) {
        return super.createServerDataset(persisted, datasetUri, defaultGraphUris, namedGraphUris, namedGraphInitializers);
    }

    @Override
    public Collection<Statement> executeService(URI serviceUri, Collection<Statement> statements) throws AnzoException {
        return super.executeService(serviceUri, statements);
    }

    @Override
    public IDataset getAllReplicaGraphsDataset() {
        return super.getAllReplicaGraphsDataset();
    }

    @Override
    public RealtimeUpdateManager getRealtimeUpdates() throws AnzoException {
        if (!useJms) {
            throw new AnzoRuntimeException(ExceptionConstants.EXECUTION.RESTRICTED_CLIENT_OP);
        } else {
            return super.getRealtimeUpdates();
        }
    }

    @Override
    public ClientGraph getReplicaGraph(URI uri, INamedGraphInitializer... namedGraphInitializers) throws AnzoException {
        return super.getReplicaGraph(uri, namedGraphInitializers);
    }

    @Override
    public Map<URI, ClientGraph> getReplicaGraphs(Set<URI> uris, INamedGraphInitializer... namedGraphInitializers) throws AnzoException {
        return super.getReplicaGraphs(uris, namedGraphInitializers);
    }

    //    @Override
    //    public String getServiceUser() {
    //        throw new AnzoRuntimeException(ERROR_TAGS.EXECUTION_ERROR, ExceptionConstants.EXECUTION.RESTRICTED_CLIENT_OP);
    //    }

    @Override
    public IStatementChannel getStatementChannel(URI uri, INamedGraphInitializer... initializers) throws AnzoException {
        if (!useJms) {
            throw new AnzoRuntimeException(ExceptionConstants.EXECUTION.RESTRICTED_CLIENT_OP);
        } else {
            return super.getStatementChannel(uri, initializers);
        }
    }

    @Override
    public Collection<Statement> replicaFind(Resource subj, URI prop, Value obj, URI... namedGraphUri) throws AnzoException {
        return super.replicaFind(subj, prop, obj, namedGraphUri);
    }

    @Override
    public QueryResults replicaQuery(Set<URI> defaultNamedGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        return super.replicaQuery(defaultNamedGraphs, namedGraphs, namedDatasets, query, baseUri);
    }

    @Override
    public void replicate() throws AnzoException {
        if (!useJms) {
            throw new AnzoRuntimeException(ExceptionConstants.EXECUTION.RESTRICTED_CLIENT_OP);
        } else {
            super.replicate();
        }
    }

    @Override
    public void reset(Collection<Statement> statements, Collection<Statement> checks) throws AnzoException {
        throw new AnzoRuntimeException(ExceptionConstants.EXECUTION.RESTRICTED_CLIENT_OP);
    }

    @Override
    public void setUpdateRepositoryOnCommit(boolean updateRepositoryOnCommit) {
        if (!useJms) {
            throw new AnzoRuntimeException(ExceptionConstants.EXECUTION.RESTRICTED_CLIENT_OP);
        } else {
            super.setUpdateRepositoryOnCommit(updateRepositoryOnCommit);
        }
    }

    @Override
    public void unregisterConnectionListener(IAnzoClientConnectionListener listener) {
        if (!useJms) {
            throw new AnzoRuntimeException(ExceptionConstants.EXECUTION.RESTRICTED_CLIENT_OP);
        } else {
            unregisterConnectionListener(listener);
        }
    }

    @Override
    public void unregisterTransactionListener(ITransactionListener listener) {
        if (!useJms) {
            throw new AnzoRuntimeException(ExceptionConstants.EXECUTION.RESTRICTED_CLIENT_OP);
        } else {
            super.unregisterTransactionListener(listener);
        }
    }

    @Override
    public void close() {
        throw new AnzoRuntimeException(ExceptionConstants.EXECUTION.RESTRICTED_CLIENT_OP);
    }

}
