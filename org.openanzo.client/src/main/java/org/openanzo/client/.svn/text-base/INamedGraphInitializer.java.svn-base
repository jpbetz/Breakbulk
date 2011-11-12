/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/

package org.openanzo.client;

import java.util.Collection;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.services.IPrecondition;

/**
 * 
 * Simple interface providing automatic initialization of named graphs and their metadata graphs before they are pushed to the server.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface INamedGraphInitializer {

    /**
     * Initialize the given named graph and its metadata graph
     * 
     * @param namedGraph
     *            NamedGraph on which to operate
     * @param createNew
     *            Create a new graph if it does not already exist
     * @throws AnzoException
     *             Thrown if the named graph or metadata graph contain triples that prevent this initializer from running.
     */
    public void initializeNamedGraph(IAnzoGraph namedGraph, boolean createNew) throws AnzoException;

    /**
     * Preconditions that must hold before the transaction in which this graph is created can be executed
     * 
     * @return Collection of preconditions which must be met when this graph is created
     */
    public Collection<IPrecondition> getPreconditions();

}
