/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 29, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.io.IOException;
import java.util.Collection;

import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.nodecentric.operations.Find;
import org.openanzo.datasource.services.BaseAuthorizationService;
import org.openanzo.datasource.update.NamedGraphType;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.Privilege;
import org.openanzo.services.serialization.IValueSetHandler;

/**
 * NodeCentric implementation of the AuthorizationService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class NodeCentricAuthorizationService extends BaseAuthorizationService {
    private final NodeCentricDatasource datasource;

    protected NodeCentricAuthorizationService(NodeCentricDatasource datasource) {
        this.datasource = datasource;
    }

    public IDatasource getDatasource() {
        return datasource;
    }

    /**
     * Get the set of users for the given graph
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            {@link URI} of named graph for which to determine users
     * @param valueSetHandler
     *            {@link IValueSetHandler} that handles the results of this request
     * @throws AnzoException
     *             {@link ExceptionConstants.DATASOURCE.NAMEDGRAPH#NOT_FOUND} if specified named graph could not be found
     * @throws AnzoException
     *             {@link ExceptionConstants.DATASOURCE.USER#SELECT_ROLES} if there was an SQL error selecting roles for the user
     * @throws AnzoException
     *             {@link ExceptionConstants.IO#WRITE_ERROR} if there was an IO error writing to the valueSetHandler
     */
    @Override
    protected void getRolesForGraphInternal(IOperationContext context, URI namedGraphUri, Privilege privilege, IValueSetHandler<URI> valueSetHandler) throws AnzoException {
        NodeCentricOperationContext connectionContext = null;
        boolean isMine = false;
        try {
            if (context instanceof NodeCentricOperationContext) {
                connectionContext = (NodeCentricOperationContext) context;
            } else {
                connectionContext = datasource.getQueryContext(context);
                isMine = true;
            }
            URI metadataGraphUri = null;
            boolean metadata = false;
            if (UriGenerator.isMetadataGraphUri(namedGraphUri)) {
                metadataGraphUri = namedGraphUri;
                metadata = true;
            } else {
                metadataGraphUri = UriGenerator.generateMetadataGraphUri(namedGraphUri);
            }
            Long id = connectionContext.getNodeLayout().fetchId(namedGraphUri, connectionContext.getConnection());
            if (id == null) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUri.toString());
            }
            valueSetHandler.start();
            URI predicate = null;
            switch (privilege) {
            case READ:
                predicate = NamedGraph.canBeReadByProperty;
                break;
            case ADD:
                predicate = NamedGraph.canBeAddedToByProperty;
                break;
            case REMOVE:
                predicate = NamedGraph.canBeRemovedFromByProperty;
                break;
            }
            NamedGraphType type = datasource.containsNamedGraph(connectionContext, namedGraphUri, metadata);
            if (type != null) {
                String tableName = null;
                switch (type) {
                case REVISIONED:
                    tableName = NodeCentricDatasource.STATEMENTS;
                    break;
                case NON_REVISIONED_PERSISTED:
                    tableName = NodeCentricDatasource.STATEMENTS_NR;
                    break;
                default:
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUri.toString());
                }

                Collection<Statement> rolesResult = Find.findQuads(connectionContext, tableName, (type == NamedGraphType.REVISIONED), true, new URI[] { namedGraphUri }, new URI[] { predicate }, null, new URI[] { metadataGraphUri });
                for (Statement stmt : rolesResult) {
                    valueSetHandler.handleValue((URI) stmt.getObject());
                }
            } else {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUri.toString());
            }
            valueSetHandler.end();
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.SERVER.GET_ROLES_FOR_GRAPH_ERROR, ioe, namedGraphUri.toString());
        } finally {
            if (connectionContext != null && isMine) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }
}
