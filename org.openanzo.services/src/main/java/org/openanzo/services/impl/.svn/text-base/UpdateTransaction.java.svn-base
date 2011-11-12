/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/services/impl/ModelTransactionUpdates.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/20/2005
 * Revision:	$Id: ModelTransactionUpdates.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.openanzo.services.serialization.NamedGraphUpdate;

/**
 * Implementation of IModelTransactionUpdates
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class UpdateTransaction implements IUpdateTransaction {

    /** List of errors from server */
    final private ArrayList<AnzoException>    errors;

    /** Timestamp for transaction */
    final private long                        transactionTimestamp;

    final private Map<URI, Long>              updatedNamedGraphRevisions;

    final private Map<URI, URI>               updatedNamedGraphs;

    final private Map<URI, INamedGraphUpdate> namedGraphUpdates;

    final private Collection<Statement>       transactionContext;

    final private Collection<IPrecondition>   preconditions;

    final private URI                         transactionURI;

    final private Map<URI, URI>               removedNamedGraphs;

    /**
     * Create new ModelTransactionUpdates with given transaction id
     * 
     * @param transactionUri
     *            URI of transaction
     * @param transactionTimestamp
     *            timestamp of when transaction was committed
     * @param transactionContext
     *            context for transaction
     * @param preconditions
     *            preconditions for transaction
     * @param updatedNamedGraphs
     *            serialized list of updated namedgraphs
     * 
     */
    public UpdateTransaction(URI transactionUri, long transactionTimestamp, Collection<Statement> transactionContext, Collection<IPrecondition> preconditions, String updatedNamedGraphs) {
        this.transactionURI = transactionUri;
        this.transactionTimestamp = transactionTimestamp;
        this.transactionContext = transactionContext;
        this.errors = new ArrayList<AnzoException>();
        this.updatedNamedGraphs = new HashMap<URI, URI>();
        this.preconditions = new ArrayList<IPrecondition>();
        if (preconditions != null) {
            this.preconditions.addAll(preconditions);
        }
        this.updatedNamedGraphRevisions = CommonSerializationUtils.readNamedGraphRevisions(updatedNamedGraphs);
        this.namedGraphUpdates = new HashMap<URI, INamedGraphUpdate>();
        this.removedNamedGraphs = new HashMap<URI, URI>();

    }

    /**
     * Create new ModelTransactionUpdates with given transaction id
     * 
     * @param transactionUri
     *            URI of transaction
     * @param transactionTimestamp
     *            timestamp of when transaction was committed
     * @param transactionContext
     *            context for transaction
     * @param updatedNamedGraphs
     *            map of NamedGraphs to their new revision number
     * 
     */
    public UpdateTransaction(URI transactionUri, long transactionTimestamp, Collection<Statement> transactionContext, Map<URI, Long> updatedNamedGraphs) {
        this.transactionURI = transactionUri;
        this.transactionTimestamp = transactionTimestamp;
        this.errors = new ArrayList<AnzoException>();
        this.updatedNamedGraphs = new HashMap<URI, URI>();
        this.namedGraphUpdates = new HashMap<URI, INamedGraphUpdate>();
        this.updatedNamedGraphRevisions = updatedNamedGraphs;
        this.preconditions = new ArrayList<IPrecondition>();
        this.transactionContext = transactionContext;
        this.removedNamedGraphs = new HashMap<URI, URI>();
    }

    public Map<URI, URI> getRemovedNamedGraphs() {
        return removedNamedGraphs;
    }

    public void addNamedGraphUpdate(INamedGraphUpdate namedGraphUpdate) {
        namedGraphUpdate.setTransaction(this);
        namedGraphUpdates.put(namedGraphUpdate.getNamedGraphURI(), namedGraphUpdate);
    }

    public Collection<IPrecondition> getPreconditions() {
        return preconditions;
    }

    public Collection<INamedGraphUpdate> getNamedGraphUpdates() {
        return namedGraphUpdates.values();
    }

    public Set<URI> getNamedGraphs() {
        return namedGraphUpdates.keySet();
    }

    public INamedGraphUpdate getNamedGraphUpdate(URI namedGraphUri) {
        return namedGraphUpdates.get(namedGraphUri);
    }

    public Map<URI, Long> getUpdatedNamedGraphRevisions() {
        return updatedNamedGraphRevisions;
    }

    public Map<URI, URI> getUpdatedNamedGraphs() {
        return updatedNamedGraphs;
    }

    /**
     * Get the list of errors from server
     * 
     * @return Returns the errors.
     */
    public List<AnzoException> getErrors() {
        return errors;
    }

    /**
     * Get the transactionTimestamp
     * 
     * @return the transactionTimestamp
     */
    public long getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void addStatement(Collection<Statement> statements) throws AnzoException {
        for (Statement statement : statements) {
            URI uri = statement.getNamedGraphUri();
            if (UriGenerator.isMetadataGraphUri(uri)) {
                uri = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, uri);
                INamedGraphUpdate update = namedGraphUpdates.get(uri);
                if (update == null) {
                    update = new NamedGraphUpdate(uri);
                    update.getMetaAdditions().add(statement);
                    addNamedGraphUpdate(update);
                } else {
                    if (!update.getMetaRemovals().contains(statement)) {
                        update.getMetaAdditions().add(statement);
                    } else {
                        update.getMetaRemovals().remove(statement);
                    }
                }
            } else {
                INamedGraphUpdate update = namedGraphUpdates.get(uri);
                if (update == null) {
                    update = new NamedGraphUpdate(uri);
                    update.getAdditions().add(statement);
                    addNamedGraphUpdate(update);
                } else {
                    if (!update.getRemovals().contains(statement)) {
                        update.getAdditions().add(statement);
                    } else {
                        update.getRemovals().remove(statement);
                    }
                }
            }
        }
    }

    public void removeStatement(Collection<Statement> statements) throws AnzoException {
        for (Statement statement : statements) {
            URI uri = statement.getNamedGraphUri();
            if (UriGenerator.isMetadataGraphUri(uri)) {
                uri = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, uri);
                INamedGraphUpdate update = namedGraphUpdates.get(uri);
                if (update == null) {
                    update = new NamedGraphUpdate(uri);
                    update.getMetaRemovals().add(statement);
                    addNamedGraphUpdate(update);
                } else {
                    if (!update.getMetaAdditions().contains(statement)) {
                        update.getMetaRemovals().add(statement);
                    } else {
                        update.getMetaAdditions().remove(statement);
                    }
                }
            } else {
                INamedGraphUpdate update = namedGraphUpdates.get(uri);
                if (update == null) {
                    update = new NamedGraphUpdate(uri);
                    update.getRemovals().add(statement);
                    addNamedGraphUpdate(update);
                } else {
                    if (!update.getAdditions().contains(statement)) {
                        update.getRemovals().add(statement);
                    } else {
                        update.getAdditions().remove(statement);
                    }
                }
            }
        }
    }

    public Collection<Statement> getTransactionContext() {
        return transactionContext;
    }

    public URI getURI() {
        return transactionURI;
    }

    public boolean isEmpty() {
        return namedGraphUpdates.isEmpty();
    }

}
