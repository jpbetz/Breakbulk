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

import java.util.ArrayList;
import java.util.Collection;

import org.openanzo.exceptions.AnzoException;

/**
 * Collect statements into a collection
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class StatementCollector implements IRDFHandler {

    private final Collection<Statement> stmts = new ArrayList<Statement>();

    public void endRDF() throws AnzoException {
    }

    public void handleComment(String comment) throws AnzoException {
    }

    public void handleNamespace(String prefix, String uri) throws AnzoException {
    }

    public void handleStatement(Statement statement) throws AnzoException {
        stmts.add(statement);
    }

    public void startRDF() throws AnzoException {
    }

    /**
     * Get the statements in the collector
     * 
     * @return the statements
     */
    public Collection<Statement> getStatements() {
        return stmts;
    }

}
