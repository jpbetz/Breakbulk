/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 1, 2007
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization.handlers;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.rdf.AnzoGraph;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.IRDFHandler;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.UriGenerator;

/**
 * RevisionGraphHandler provides a handler that can handle events about NamedGraphs, placing the statements within an INamedGraphWithMetaData
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class RevisionGraphHandler implements IRDFHandler {
    private IAnzoGraph namedGraph;

    /**
     * Create a new RevisionGraphHandler for the given underlying INamedGraphWithMetaData
     */
    public RevisionGraphHandler() {

    }

    public void handleStatement(Statement statement) {
        if (UriGenerator.isMetadataGraphUri(statement.getNamedGraphUri())) {
            if (namedGraph == null) {
                try {
                    namedGraph = new AnzoGraph(UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, statement.getNamedGraphUri()), statement.getNamedGraphUri());
                } catch (AnzoException e) {
                    throw new AnzoRuntimeException(e);
                }
            }
            namedGraph.getMetadataGraph().add(statement);
        } else {
            if (namedGraph == null) {
                namedGraph = new AnzoGraph(statement.getNamedGraphUri(), UriGenerator.generateMetadataGraphUri(statement.getNamedGraphUri()));
            }
            namedGraph.add(statement);
        }
    }

    /**
     * @return the namedGraph
     */
    public IAnzoGraph getNamedGraph() {
        return namedGraph;
    }

    public void startRDF() throws AnzoException {
    }

    public void endRDF() throws AnzoException {
    }

    public void handleComment(String comment) throws AnzoException {
    }

    public void handleNamespace(String prefix, String uri) throws AnzoException {
    }
}
