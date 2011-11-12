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
package org.openanzo.services.serialization;

import java.util.ArrayList;
import java.util.Collection;

import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IUpdateTransaction;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class NamedGraphUpdate implements INamedGraphUpdate {
    final private Collection<Statement> additions;

    final private Collection<Statement> removals;

    final private Collection<Statement> metaAdditions;

    final private Collection<Statement> metaRemovals;

    final private URI                   namedGraphURI;

    private URI                         uuid;

    private long                        revision;

    private IUpdateTransaction          transaction;

    /**
     * @param transaction
     *            the transaction to set
     */
    public void setTransaction(IUpdateTransaction transaction) {
        this.transaction = transaction;
    }

    /**
     * Create a new NamedGraphUpdate
     * 
     * @param namedGraphURI
     *            uri of namedGraph
     * @param uuid
     *            uuid of namedGraph
     * @param additions
     *            set of addition statements
     * @param removals
     *            set of removal statements
     * @param metaAdditions
     *            set of metadata addition statements
     * @param metaRemovals
     *            set of metdata removal statements
     */
    public NamedGraphUpdate(URI namedGraphURI, URI uuid, Collection<Statement> additions, Collection<Statement> removals, Collection<Statement> metaAdditions, Collection<Statement> metaRemovals) {
        super();
        this.namedGraphURI = namedGraphURI;
        this.uuid = uuid;
        this.additions = additions != null ? additions : new ArrayList<Statement>();
        this.removals = removals != null ? removals : new ArrayList<Statement>();
        this.metaAdditions = metaAdditions != null ? metaAdditions : new ArrayList<Statement>();
        this.metaRemovals = metaRemovals != null ? metaRemovals : new ArrayList<Statement>();
    }

    /**
     * Create empty update object
     * 
     * @param namedGraphURI
     *            uri of namedgraph
     */
    public NamedGraphUpdate(URI namedGraphURI) {
        super();
        this.namedGraphURI = namedGraphURI;
        this.additions = new ArrayList<Statement>();
        this.removals = new ArrayList<Statement>();
        this.metaAdditions = new ArrayList<Statement>();
        this.metaRemovals = new ArrayList<Statement>();
    }

    public Collection<Statement> getAdditions() {
        return additions;
    }

    public URI getNamedGraphURI() {
        return namedGraphURI;
    }

    public Collection<Statement> getRemovals() {
        return removals;
    }

    public Collection<Statement> getMetaAdditions() {
        return metaAdditions;
    }

    public Collection<Statement> getMetaRemovals() {
        return metaRemovals;
    }

    /**
     * @return the revision
     */
    public long getRevision() {
        return revision;
    }

    /**
     * @param revision
     *            the revision to set
     */
    public void setRevision(long revision) {
        this.revision = revision;
    }

    /**
     * @return the uuid
     */
    public URI getUUID() {
        return uuid;
    }

    /**
     * @param uuid
     *            the uuid to set
     */
    public void setUUID(URI uuid) {
        this.uuid = uuid;
    }

    public IUpdateTransaction getTransaction() {
        return transaction;
    }

}
