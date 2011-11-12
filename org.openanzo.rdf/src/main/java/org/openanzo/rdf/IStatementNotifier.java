/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Dec 10, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.rdf;

/**
 * Source of IStatementListener events
 * 
 * @param <T>
 *            Source of events
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
public interface IStatementNotifier<T> {

    /**
     * Register an INamedGraphListener with event manager
     * 
     * @param listener
     *            INamedGraphListener to register
     */
    public void registerListener(IStatementListener<T> listener);

    /**
     * Unregister an INamedGraphListener from event manager
     * 
     * @param listener
     *            INamedGraphListener to unregister
     */
    public void unregisterListener(IStatementListener<T> listener);

    /**
     * Notify listeners that statements where added
     * 
     * @param statements
     *            Added statements to which listeners should be notified
     */
    public void notifyAddStatements(Statement... statements);

    /**
     * Notify listeners that statements where deleted
     * 
     * @param statements
     *            Deleted statements to which listeners should be notified
     */
    public void notifyRemoveStatements(Statement... statements);

}
