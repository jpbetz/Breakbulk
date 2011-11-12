/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 2, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.util.Collection;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;

/**
 * Interface to allow handling of full namedgraph revision data
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IBackupHandler {
    /**
     * Start the backup handling
     * 
     * @throws AnzoException
     */
    public void start() throws AnzoException;

    /**
     * Handle full revision data about a namedgraph
     * 
     * @param revisioned
     *            true if graph has full revision history
     * @param namedGraphUri
     *            uri of namedgraph
     * @param metadataURI
     *            uri of metadata graph
     * @param uuid
     *            UUID of namedgraph
     * @param revisions
     *            set of full revision data about graph
     * @return true if handled ok
     * @throws AnzoException
     */
    public boolean handleNamedGraph(boolean revisioned, URI namedGraphUri, URI metadataURI, URI uuid, Collection<BackupRevision> revisions) throws AnzoException;

    /**
     * Handle a statement
     * 
     * @param metadata
     *            is this a metadata statement
     * @param revisioned
     *            is the parent graph revisioned
     * @param statement
     *            statement to handle
     * @param start
     *            what revision was this statement added
     * @param end
     *            what revision was this statement deleted, if any
     * @throws AnzoException
     */
    public void handleStatement(boolean metadata, boolean revisioned, Statement statement, Long start, Long end) throws AnzoException;

    /**
     * Finish handling backup
     * 
     * @throws AnzoException
     */
    public void end() throws AnzoException;
}
