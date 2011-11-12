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
 * Core implementation of IStoredNamedGraph
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class StoredNamedGraph implements IStoredNamedGraph {
    protected URI            lastModifiedBy;

    protected Long           lastModifiedTime;

    protected Long           revision;

    protected Long           newRevision;

    protected URI            uri;

    protected URI            metaUri;

    protected URI            uuid;

    protected boolean        newGraph = false;

    protected NamedGraphType type;

    /**
 * 
 */
    public StoredNamedGraph() {
    }

    /**
     * 
     * @param newGraph
     * @param type
     * @param uri
     * @param metaUri
     * @param uuid
     * @param revision
     * @param lastModifiedBy
     * @param lastModifiedTime
     */
    public StoredNamedGraph(boolean newGraph, NamedGraphType type, URI uri, URI metaUri, URI uuid, Long revision, URI lastModifiedBy, Long lastModifiedTime) {
        super();
        this.type = type;
        this.newGraph = newGraph;
        this.uri = uri;
        this.metaUri = metaUri;
        this.uuid = uuid;
        this.revision = revision;
        this.lastModifiedTime = lastModifiedTime;
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public String toString() {
        return "StoredNamedGraph:" + uri.toString() + ":" + metaUri.toString() + ":" + revision + ":" + newRevision + ":" + uuid + ":" + lastModifiedBy + ":" + lastModifiedTime;
    }

    public NamedGraphType getNamedGraphType() {
        return type;
    }

    public boolean isNewGraph() {
        return newGraph;
    }

    public Long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void commitNewRevision() {
        if (newRevision != null) {
            revision = newRevision;
            newRevision = null;
        }
        newGraph = false;
    }

    public void abortNewRevision() {
        newRevision = null;
    }

    public Long getNewRevision() {
        if (newRevision == null) {
            newRevision = (newGraph) ? revision : Long.valueOf(revision + 1);
        }
        return newRevision;
    }

    public Long getRevision() {
        return revision;
    }

    public URI getMetaURI() {
        return metaUri;
    }

    public URI getURI() {
        return uri;
    }

    public URI getUUID() {
        return uuid;
    }

    public void setLastModifiedTime(Long timestamp) {
        this.lastModifiedTime = timestamp;
    }

    public void setRevision(Long revision) {
        this.revision = revision;
    }

    public URI getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(URI lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
