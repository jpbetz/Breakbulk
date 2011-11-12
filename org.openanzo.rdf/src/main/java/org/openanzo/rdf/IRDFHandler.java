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
package org.openanzo.rdf;

import org.openanzo.exceptions.AnzoException;

/**
 * Contract for handling a stream of incoming rdf statements.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public interface IRDFHandler {
    /**
     * Handle statement
     * 
     * @param statement
     *            statement to handle
     * @throws AnzoException
     */
    void handleStatement(Statement statement) throws AnzoException;

    /**
     * Finish handling rdf
     * 
     * @throws AnzoException
     */
    void endRDF() throws AnzoException;

    /**
     * Start handling rdf
     * 
     * @throws AnzoException
     */
    void startRDF() throws AnzoException;

    /**
     * Handle comment
     * 
     * @param comment
     *            comment to handle
     * @throws AnzoException
     */
    void handleComment(String comment) throws AnzoException;

    /**
     * Handle namespace
     * 
     * @param prefix
     *            prefix
     * @param uri
     *            uri
     * @throws AnzoException
     */
    void handleNamespace(String prefix, String uri) throws AnzoException;
}
