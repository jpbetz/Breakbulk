/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client;

import java.util.Collection;
import java.util.Set;

import org.apache.commons.lang.NotImplementedException;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.BaseQuadStore;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Implementation of QuadStore that delegates all NamedGraph read operations to the remote server provided by the AnzoClient.
 * 
 * Write operations are not supported, as they should be performed via the UpdateService, not this graph.
 * 
 * Read operations about the QuadStore as a whole, and not a specific NamedGraph are not supported since the server does not provide direct calls for these
 * operations.
 * 
 * @author Joe Betz
 * 
 */
class ServerQuadStore extends BaseQuadStore {

    private final AnzoClient client;

    ServerQuadStore(AnzoClient client) {
        this.client = client;
    }

    public void add(Statement... statements) {
        throw new NotImplementedException();
    }

    public void clear() {
        throw new NotImplementedException();
    }

    public boolean contains(Resource subj, URI prop, Value obj, URI... namedGraphUri) {
        return !find(subj, prop, obj, namedGraphUri).isEmpty();
    }

    public boolean contains(Statement statement) {
        return !find(statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getNamedGraphUri()).isEmpty();
    }

    public QueryResults executeQuery(Set<URI> defaultGraph, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        return client.clientDatasource.getQueryService().query(client.createContext("executeQuery"), defaultGraph, namedGraphs, namedDatasets, null, query, baseUri);
    }

    public Collection<Statement> find(Resource subj, URI prop, Value obj, URI... namedGraphUri) {
        try {
            return client.clientDatasource.getModelService().findStatements(client.createContext("find"), subj, prop, obj, namedGraphUri);
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }

    }

    public Collection<URI> getNamedGraphUris() {
        try {
            return client.clientDatasource.getModelService().getStoredNamedGraphs(client.createContext("getNamedGraphUris"));
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

    public Collection<Statement> getStatements() {
        return find(null, null, null);
    }

    public boolean isEmpty() {
        throw new NotImplementedException();
    }

    public void remove(Statement... statements) {
        throw new NotImplementedException();
    }

    public int size() {
        throw new NotImplementedException();
    }

    public int size(URI... namedGraphUris) {
        try {
            int i = 0;
            for (URI uri : namedGraphUris) {
                i += client.clientDatasource.getModelService().getSize(client.createContext("size"), uri);
            }
            return i;
        } catch (AnzoException e) {
            throw new AnzoRuntimeException(e);
        }
    }

}
