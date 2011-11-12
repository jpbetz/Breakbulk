/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
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
package org.openanzo.services;

import java.util.Collection;

import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;

/**
 * Interface for an object that contains update information about a namedgraph
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface INamedGraphUpdate {
    /**
     * Get the namedGraph's URI
     * 
     * @return namedGraph's URI
     */
    public URI getNamedGraphURI();

    /**
     * Get the graph's revision
     * 
     * @return the graph's revision
     */
    public long getRevision();

    /**
     * Set the graph's revision
     * 
     * @param revision
     *            the graph's revision
     */
    public void setRevision(long revision);

    /**
     * Get the UUID for the graph
     * 
     * @return the UUID for the graph
     */
    public URI getUUID();

    /**
     * Set the graph's UUID
     * 
     * @param uuid
     *            the graph's UUID
     */
    public void setUUID(URI uuid);

    /**
     * Get the statement additions for the update
     * 
     * @return the statement additions for the update
     */
    public Collection<Statement> getAdditions();

    /**
     * Get the statement removals for the update
     * 
     * @return the statement removals for the update
     */
    public Collection<Statement> getRemovals();

    /**
     * Get the meta statement additions for the update
     * 
     * @return the meta statement additions for the update
     */
    public Collection<Statement> getMetaAdditions();

    /**
     * Get the meta statement removals for the update
     * 
     * @return the meta statement removals for the update
     */
    public Collection<Statement> getMetaRemovals();

    /**
     * Get the parent transaction for this update
     * 
     * @return the parent transaction for this update
     */
    public IUpdateTransaction getTransaction();

    /**
     * Set the parent transaction for this update
     * 
     * @param updateTransaction
     *            the parent transaction for this update
     */
    public void setTransaction(IUpdateTransaction updateTransaction);
}
