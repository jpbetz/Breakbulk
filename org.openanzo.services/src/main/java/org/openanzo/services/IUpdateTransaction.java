/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/services/IModelTransactionUpdates.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/20/2005
 * Revision:	$Id: IModelTransactionUpdates.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;

/**
 * IUpdateTransaction encapsulate the results of a transaction's committal on the server
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IUpdateTransaction {
    /**
     * Map between UUID and revision
     * 
     * @return Map between UUID and revision
     */
    public abstract Map<URI, Long> getUpdatedNamedGraphRevisions();

    /**
     * Map between NamedGraphUri and UUID
     * 
     * @return Map between NamedGraphUri and UUID
     */
    public abstract Map<URI, URI> getUpdatedNamedGraphs();

    /**
     * Get any errors that occurred committing transaction to server
     * 
     * @return any errors that occurred committing transaction to server
     */
    public abstract List<AnzoException> getErrors();

    /**
     * Get the list of additions that occurred during this transaction
     * 
     * @return the list of additions that occurred during this transaction
     */
    public abstract Collection<INamedGraphUpdate> getNamedGraphUpdates();

    /**
     * Get the list of additions that occurred during this transaction
     * 
     * @return the list of additions that occurred during this transaction
     */
    public abstract Set<URI> getNamedGraphs();

    /**
     * Get Map between removed NamedGraphUri and UUID
     * 
     * @return Map between removed NamedGraphUri and UUID
     */
    public abstract Map<URI, URI> getRemovedNamedGraphs();

    /**
     * Get the {@link INamedGraphUpdate} for given URI
     * 
     * @param namedGraphUri
     *            URI of graph for which to get update
     * @return {@link INamedGraphUpdate} for given URI
     */
    public abstract INamedGraphUpdate getNamedGraphUpdate(URI namedGraphUri);

    /**
     * Get the timestamp for this transaction
     * 
     * @return the timestamp for this transaction
     */
    public long getTransactionTimestamp();

    /**
     * Get the transaction URI
     * 
     * @return the transaction URI
     */
    public abstract URI getURI();

    /**
     * Get the transaction context
     * 
     * @return the transaction context
     */
    public abstract java.util.Collection<Statement> getTransactionContext();

    /**
     * Get the transaction preconditions
     * 
     * @return the transaction preconditions
     */
    public Collection<IPrecondition> getPreconditions();

    /**
     * Add addition statements to the transaction
     * 
     * @param statements
     *            statements to add
     * @throws AnzoException
     */
    public void addStatement(Collection<Statement> statements) throws AnzoException;

    /**
     * Add removal statements to the transaction
     * 
     * @param statements
     *            statements to remove
     * @throws AnzoException
     */
    public void removeStatement(Collection<Statement> statements) throws AnzoException;

    /**
     * Add an INamedGraphUpdate to the transaction
     * 
     * @param namedGraphUpdate
     */
    public void addNamedGraphUpdate(INamedGraphUpdate namedGraphUpdate);

    /**
     * Does this transaction have any commands
     * 
     * @return True if this transaction has any commands
     */
    public boolean isEmpty();
}
