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

import org.apache.commons.collections15.MultiMap;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.utils.AnzoMultiMap;

/**
 * Statement collector that puts statemtns into a multimap keyed off the graph uri
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class SegmentedStatementCollector implements IRDFHandler {

    private final MultiMap<URI, Statement> stmts = new AnzoMultiMap<URI, Statement>();

    public void endRDF() throws AnzoException {
    }

    public void handleComment(String comment) throws AnzoException {
    }

    public void handleNamespace(String prefix, String uri) throws AnzoException {
    }

    public void handleStatement(Statement statement) throws AnzoException {
        stmts.put(statement.getNamedGraphUri(), statement);
    }

    public void startRDF() throws AnzoException {
    }

    /**
     * Get the multimap of statements
     * 
     * @return the multimap of statements
     */
    public MultiMap<URI, Statement> getStatements() {
        return stmts;
    }

}
