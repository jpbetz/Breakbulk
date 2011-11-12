/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 21, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.io.Serializable;
import java.util.Collection;

import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;

/**
 * Information containing a namedgraph's revision data used to serialize
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class NamedGraphRevision implements Serializable {
    private static final long    serialVersionUID = 8834618267341196414L;

    /** Revision number */
    public long                  revision         = -1;

    /** NamedGraph URI */
    public final URI             namedGraphUri;

    /** MetadataGraph URI */
    public final URI             metadataUri;

    /** UUID of graph */
    public URI                   uuid;

    /** is this a new graph */
    public final boolean         newGraph;

    /** read graph */
    public final boolean         readGraph;

    /** read metadata */
    public final boolean         readMeta;

    /** cache of statements */
    public Collection<Statement> cache            = null;

    /**
     * New NamedGraphRevision
     * 
     * @param namedGraphUri
     *            URI of namedGraph
     * @param metadataUri
     *            URI of metadataURI
     * @param uuid
     *            UUID of the namedGraph
     * @param revision
     *            revision number
     * @param newGraph
     *            is new graph
     * @param readGraph
     *            can read graph
     * @param readMeta
     *            can read metadata
     */
    public NamedGraphRevision(URI namedGraphUri, URI metadataUri, URI uuid, long revision, boolean newGraph, boolean readGraph, boolean readMeta) {
        this.revision = revision;
        this.namedGraphUri = namedGraphUri;
        this.metadataUri = metadataUri;
        this.uuid = uuid;
        this.readGraph = readGraph;
        this.readMeta = readMeta;
        this.newGraph = newGraph;
    }
}
