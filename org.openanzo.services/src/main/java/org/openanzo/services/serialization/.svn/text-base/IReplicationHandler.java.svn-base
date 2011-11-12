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

package org.openanzo.services.serialization;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Used by client components to process named graph updates. Implements of this interface must use contextual information to determine if the contents of the
 * update are meant to update or completely replace the existing statements.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface IReplicationHandler {
    /**
     * Start handling replication
     * 
     * @param totalSize
     *            Not Used
     * @throws AnzoException
     */
    public void start(int totalSize) throws AnzoException;

    /**
     * Stop handling replication
     * 
     * @throws AnzoException
     */
    public void end() throws AnzoException;

    /**
     * Handle info about namedgraph
     * 
     * @param namedGraphUri
     *            uri of namedgraph
     * @param uuid
     *            uuid of namedgraph
     * @param revision
     *            new revision for graph
     * @return true if handled ok
     * @throws AnzoException
     */
    public boolean handleNamedGraph(URI namedGraphUri, URI uuid, long revision) throws AnzoException;

    /**
     * Handle statement
     * 
     * @param metadata
     *            is this a metadata statement
     * @param addition
     *            is this an addition or a deletion
     * @param subject
     *            subject of statement
     * @param predicate
     *            predicate of statement
     * @param object
     *            object of statement
     * @param namedGraphURI
     *            namedgraphURI of statement
     * @return true if handled ok
     * @throws AnzoException
     */
    public boolean handleStatement(boolean metadata, boolean addition, Resource subject, URI predicate, Value object, URI namedGraphURI) throws AnzoException;

}
