/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jan 18, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource;

import org.openanzo.datasource.update.NamedGraphType;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.IUpdates;
import org.openanzo.services.Privilege;

/**
 * Interface that the update process uses to write data into a datasource
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IServerQuadStore extends IMultiStageUpdateHandler {
    /**
     * Close the quad store
     * 
     * @throws AnzoException
     */
    public void close() throws AnzoException;

    /**
     * Notify any of this quad stores listeners of updates
     * 
     * @param updates
     *            updates sent to listeners
     * @throws AnzoException
     */
    public void fireUpdatesToListeners(IUpdates updates) throws AnzoException;

    /**
     * Get the Datasource's URI
     * 
     * @return datasource's URI
     */
    public URI getInstanceURI();

    /**
     * Add one or more statements to container
     * 
     * @param statements
     *            statements to add to container
     * @throws AnzoException
     */
    public void add(Statement... statements) throws AnzoException;

    /**
     * Delete a set of statements from container
     * 
     * @param statements
     *            statements to delete from container
     * @throws AnzoException
     */
    public void remove(Statement... statements) throws AnzoException;

    public boolean containsNamedGraph(URI namedGraphURI) throws AnzoException;

    /**
     * Get the UUID for a given URI
     * 
     * @param namedGraphURI
     *            URI for which to determine a UUID
     * @return the UUID for the given URI
     * @throws AnzoException
     */
    public URI getNamedGraphUUID(URI namedGraphURI) throws AnzoException;

    /**
     * Add a new NamedGraph to the store
     * 
     * @param namedGraphUri
     *            URI of the namedGraph
     * @param metadataGraphUri
     *            URI of the metadata graph
     * @param uuid
     *            UUID of the namedgraph
     * @param type
     *            Type of namedGraph
     * @throws AnzoException
     */
    public void addNewNamedGraph(URI namedGraphUri, URI metadataGraphUri, URI uuid, NamedGraphType type) throws AnzoException;

    /**
     * Remove NamedGraph from store
     * 
     * @param namedGraphUri
     *            URI of the namedgraph
     * @param uuid
     *            UUID of the namedgraph
     * @param transactionStart
     *            timestamp of the removal
     * @throws AnzoException
     */
    public void removeNamedGraph(URI namedGraphUri, URI uuid, long transactionStart) throws AnzoException;

    public void addAcl(URI namedGraphUri, URI Role, Privilege privilege) throws AnzoException;

    public void removeAcl(URI namedGraphUri, URI Role, Privilege privilege) throws AnzoException;
}
