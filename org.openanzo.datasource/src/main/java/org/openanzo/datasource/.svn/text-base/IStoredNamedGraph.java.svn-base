/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 21, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource;

import org.openanzo.datasource.update.NamedGraphType;
import org.openanzo.rdf.URI;

/**
 * This is an object interface used during the update process to describe a namedgraph
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IStoredNamedGraph {
    /**
     * Get the type of graph
     * 
     * @return the type of graph
     */
    public NamedGraphType getNamedGraphType();

    /**
     * True if the graph is not yet stored
     * 
     * @return True if the graph is not yet stored
     */
    public boolean isNewGraph();

    /**
     * Get the graphs URI
     * 
     * @return the graphs URI
     */
    public URI getURI();

    /**
     * Set the graphs metadata URI
     * 
     * @return the graphs metadata URI
     */
    public URI getMetaURI();

    /**
     * Set the graphs UUID
     * 
     * @return the graphs UUID
     */
    public URI getUUID();

    /**
     * Get the graphs current revision
     * 
     * @return the graphs current revision
     */
    public Long getRevision();

    /**
     * Get the graphs new revision
     * 
     * @return the graphs new revision
     */
    public Long getNewRevision();

    /**
     * Commit the new revision to the store
     */
    public void commitNewRevision();

    /**
     * Abort the new revision number
     */
    public void abortNewRevision();

    /**
     * Set the revision number for the graph
     * 
     * @param revision
     *            the revision number for the graph
     */
    public void setRevision(Long revision);

    /**
     * Get the last modified time for the graph
     * 
     * @return the last modified time for the graph
     */
    public Long getLastModifiedTime();

    /**
     * Set the last modified time for the graph
     * 
     * @param timestamp
     *            the last modified time for the graph
     */
    public void setLastModifiedTime(Long timestamp);

    /**
     * Get the last modified by value for the graph
     * 
     * @return the last modified by value for the graph
     */
    public URI getLastModifiedBy();

    /**
     * Set the last modified by value for the graph
     * 
     * @param lastModifiedBy
     *            the last modified by value for the graph
     */
    public void setLastModifiedBy(URI lastModifiedBy);

}
