/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 4, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.sql.Connection;

import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.BaseOperationContext;

/**
 * NodeCentric specific implementation of a IOpeationContext which contains connection, nodelayout, configuration, and statementProvider attributes
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class NodeCentricOperationContext extends BaseOperationContext {
    private final NodeCentricDatasource     datasource;

    private Connection                      connection;

    private final CompositeNodeLayout       nodeLayout;

    private final PreparedStatementProvider statementProvider;

    private final CoreDBConfiguration       configuration;

    /**
     * Create a new NodeCentricOperationContext
     * 
     * @param name
     *            name of operation
     * @param operationId
     *            id of operation
     * @param principal
     *            principal that is calling operation
     * @param connection
     *            connection to database
     * @param datasource
     *            NodeCentric back-end for this operation
     */
    protected NodeCentricOperationContext(String name, String operationId, AnzoPrincipal principal, Connection connection, NodeCentricDatasource datasource) {
        super(name, operationId, principal);
        this.nodeLayout = datasource.getNodeLayout();
        this.connection = connection;
        this.statementProvider = datasource.getStatementProvider();
        this.configuration = datasource.getConfiguration();
        this.datasource = datasource;
    }

    /**
     * Create a new NodeCentricOperationContext
     * 
     * @param rootContext
     *            parent context to wrap
     * @param connection
     *            connection to database
     * @param datasource
     *            NodeCentric back-end for this operation
     */
    protected NodeCentricOperationContext(IOperationContext rootContext, Connection connection, NodeCentricDatasource datasource) {
        super(rootContext);
        this.nodeLayout = datasource.getNodeLayout();
        this.connection = connection;
        this.statementProvider = datasource.getStatementProvider();
        this.configuration = datasource.getConfiguration();
        this.datasource = datasource;
    }

    /**
     * Get the jdbc {@link Connection} for this context
     * 
     * @return the jdbc {@link Connection} for this context
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Set the jdbc {@link Connection} for this context
     * 
     * @param connection
     *            the jdbc {@link Connection} for this context
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Get the {@link CompositeNodeLayout} for this context
     * 
     * @return the {@link CompositeNodeLayout} for this context
     */
    public CompositeNodeLayout getNodeLayout() {
        return nodeLayout;
    }

    /**
     * Get the {@link PreparedStatementProvider} for this context
     * 
     * @return the {@link PreparedStatementProvider} for this context
     */
    public PreparedStatementProvider getStatementProvider() {
        return statementProvider;
    }

    /**
     * Get the {@link CoreDBConfiguration} for this context
     * 
     * @return the {@link CoreDBConfiguration} for this context
     */
    public CoreDBConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Get the {@link NodeCentricDatasource} for this context
     * 
     * @return the {@link NodeCentricDatasource} for this context
     */
    public NodeCentricDatasource getDatasource() {
        return datasource;
    }

}
