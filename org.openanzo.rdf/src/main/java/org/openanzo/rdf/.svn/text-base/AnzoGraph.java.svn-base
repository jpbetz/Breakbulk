/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Dec 17, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.rdf;

/**
 * The AnzoGraph is a simple extension of NamedGraph. In addition to providing the usual graph projection of an IQuadStore, the AnzoGraph contains a pointer to
 * a MetadataGraph, the defining feature of a named graph in Anzo, from the perspective of the user. From an operational perspective, the AnzoGraph must also
 * take the AnzoClient to perform the close operation properly, decrementing the usage count. The user of course never calls the constructor of an AnzoGraph so
 * this complication does not over burden the user.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 */
public class AnzoGraph extends NamedGraph implements IAnzoGraph {

    private static final long   serialVersionUID = -1565925797206945921L;

    protected final INamedGraph metadataGraph;

    /**
     * Create new AnzoGraph backed by given quadstore
     * 
     * @param quadStore
     *            Parent quadStore holding statements
     * @param namedGraphUri
     *            URI of NamedGraph
     * @param metadataGraph
     *            metadata graph
     */
    public AnzoGraph(URI namedGraphUri, INamedGraph metadataGraph, IQuadStore quadStore) {
        super(namedGraphUri, quadStore);
        this.metadataGraph = metadataGraph;
    }

    /**
     * Create AnzoGraph backed by its own memory quad store
     * 
     * @param namedGraphUri
     *            uri of graph
     * @param metadataGraphUri
     *            uri of metadata graph
     */
    public AnzoGraph(URI namedGraphUri, URI metadataGraphUri) {
        super(namedGraphUri);
        this.metadataGraph = new NamedGraph(metadataGraphUri);
    }

    public INamedGraph getMetadataGraph() {
        return metadataGraph;
    }

}
