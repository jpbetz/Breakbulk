/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 27, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.io.Writer;
import java.util.Set;

import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.Privilege;
import org.openanzo.services.serialization.IValueSetHandler;
import org.openanzo.services.serialization.WriterURIValueSetHandler;
import org.openanzo.services.serialization.handlers.URIValueSetHandler;

/**
 * Base implementation of service which is in charge of authentication and authorization within the server.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseAuthorizationService extends BaseDatasourceComponent implements IAuthorizationService {
    protected DynamicServiceStats stats;

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    public String getName() {
        return getDatasource().getName() + ",Service=AuthorizationService";
    }

    public String getDescription() {
        return "Authorization Service for " + getDatasource().getName();
    }

    public void start() throws AnzoException {
        stats = new DynamicServiceStats("getRolesForGraph");
        stats.setEnabled(true);
    }

    public void reset() throws AnzoException {
        stats.reset();
    }

    /**
     * Get a set of users that have permission to read the statements in this graph Note:Only users in the sysAdmin role can call this method
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            {@link URI} of named graph
     * @param valueSetHandler
     *            {@link IValueSetHandler} call-back handler that handles the values found
     * @throws AnzoException
     */
    private void getRolesForGraph(IOperationContext context, URI namedGraphUri, Privilege privilege, IValueSetHandler<URI> valueSetHandler) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            if (namedGraphUri == null) {
                throw new AnzoException(ExceptionConstants.SERVER.MISSING_ARG, SerializationConstants.namedGraphUri, "getRolesForGraph");
            }
            if (privilege == null) {
                throw new AnzoException(ExceptionConstants.SERVER.MISSING_ARG, SerializationConstants.privilege, "getRolesForGraph");
            }
            this.getRolesForGraphInternal(context, namedGraphUri, privilege, valueSetHandler);
        } finally {
            if (stats.isEnabled()) {
                stats.use("getRolesForGraph", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    public Set<URI> getRolesForGraph(IOperationContext context, URI namedGraphUri, Privilege privilege) throws AnzoException {
        URIValueSetHandler handler = new URIValueSetHandler();
        getRolesForGraph(context, namedGraphUri, privilege, handler);
        return handler.getURIs();
    }

    public void getRolesForGraph(IOperationContext context, URI namedGraphUri, Privilege privilege, Writer output, String format) throws AnzoException {
        getRolesForGraph(context, namedGraphUri, privilege, new WriterURIValueSetHandler(output, format));
    }

    /**
     * Get the set of roles for the given graph
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param namedGraphUri
     *            {@link URI} of named graph for which to determine users
     * @param privilege
     *            privilege that is being checked
     * @param valueSetHandler
     *            {@link IValueSetHandler} that handles the results of this request
     * @throws AnzoException
     *             {@link ExceptionConstants.DATASOURCE.NAMEDGRAPH#NOT_FOUND} if specified named graph could not be found
     * @throws AnzoException
     *             {@link ExceptionConstants.DATASOURCE.USER#SELECT_ROLES} if there was an SQL error selecting roles for the user
     * @throws AnzoException
     *             {@link ExceptionConstants.IO#WRITE_ERROR} if there was an IO error writing to the valueSetHandler
     */
    protected abstract void getRolesForGraphInternal(IOperationContext context, URI graphUri, Privilege privilege, IValueSetHandler<URI> valueSetHandler) throws AnzoException;

}
