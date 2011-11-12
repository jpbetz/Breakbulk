/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 9, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.util.HashMap;
import java.util.Map;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.INamedGraphUpdate;

/**
 * Implementation of the IReplicationHandler that stores updates in map of graphs to updates until complete, and then passes updates to handler
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ReplicationHandler implements IReplicationHandler {

    final private Map<URI, INamedGraphUpdate> updates = new HashMap<URI, INamedGraphUpdate>();

    final private INamedGraphUpdateHandler    handler;

    /**
     * Create a new handler
     * 
     * @param handler
     *            INamedGraphUpdateHandler to handle namedgraph updates
     */
    public ReplicationHandler(INamedGraphUpdateHandler handler) {
        this.handler = handler;
    }

    /**
     * @return the updates
     */
    public Map<URI, INamedGraphUpdate> getUpdates() {
        return updates;
    }

    public void start(int totalSize) throws AnzoException {
        handler.start();
    }

    public void end() throws AnzoException {
        for (INamedGraphUpdate update : updates.values()) {
            handler.handleNamedGraphUpdate(update);
        }
        handler.end();
    }

    public boolean handleNamedGraph(URI namedGraphUri, URI uuid, long revision) throws AnzoException {
        if (UriGenerator.isMetadataGraphUri(namedGraphUri)) {
            namedGraphUri = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, namedGraphUri);
        }
        INamedGraphUpdate update = updates.get(namedGraphUri);
        if (update == null) {
            update = new NamedGraphUpdate(namedGraphUri);
            update.setUUID(uuid);
            update.setRevision(revision);
            updates.put(namedGraphUri, update);
        }
        return true;
    }

    public boolean handleStatement(boolean metadata, boolean addition, Resource subject, URI predicate, Value object, URI namedGraphURI) throws AnzoException {
        boolean meta = false;
        URI ngURI = namedGraphURI;
        if (UriGenerator.isMetadataGraphUri(namedGraphURI)) {
            ngURI = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, namedGraphURI);
            meta = true;
        }
        INamedGraphUpdate update = updates.get(ngURI);
        Statement stmt = Constants.valueFactory.createStatement(subject, predicate, object, namedGraphURI);
        if (addition) {
            if (meta) {
                update.getMetaRemovals().remove(stmt);
                update.getMetaAdditions().add(stmt);
            } else {
                update.getRemovals().remove(stmt);
                update.getAdditions().add(stmt);
            }
        } else {
            if (meta) {
                update.getMetaRemovals().add(stmt);
            } else {
                update.getRemovals().add(stmt);
            }
        }
        return true;
    }
}
