/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 26, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization.transport;

import java.io.StringReader;
import java.util.Collection;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.serialization.INamedGraphUpdateHandler;
import org.openanzo.services.serialization.IReplicationHandler;
import org.openanzo.services.serialization.JSONUpdatesReader;
import org.openanzo.services.serialization.XMLNamedGraphUpdatesReader;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ReplicationSerializer {
    /**
     * Deserialize from a String to type T
     * 
     * @param serialized
     *            String representation of object type T
     * @param format
     *            Format of the String
     * @param handler
     *            handler for updates
     * @throws AnzoException
     *             if there was a problem deserializing the object
     */
    static public void deserialize(String serialized, String format, IReplicationHandler handler) throws AnzoException {
        if (serialized == null || serialized.length() == 0)
            return;
        NamedGraphUpdatedHandler ngHandler = new NamedGraphUpdatedHandler(handler);
        // try {
        if (serialized.length() > 0) {
            if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
                Collection<INamedGraphUpdate> updates = JSONUpdatesReader.parseUpdates(new StringReader(serialized));
                for (INamedGraphUpdate update : updates) {
                    ngHandler.handleNamedGraphUpdate(update);
                }
            } else if (SerializationConstants.MIMETYPE_ANZO_XML.equals(format)) {
                new XMLNamedGraphUpdatesReader().parseUpdates(new StringReader(serialized), ngHandler);
            } else {
                throw new IllegalStateException("unsupported format: " + format);
            }
        }
        /*} finally {
            ngHandler.end();
        }*/
        return;
    }

    static class NamedGraphUpdatedHandler implements INamedGraphUpdateHandler {
        private final IReplicationHandler handler;

        NamedGraphUpdatedHandler(IReplicationHandler handler) {
            this.handler = handler;
        }

        public void start() throws AnzoException {
            handler.start(-1);
        }

        public void end() throws AnzoException {
            handler.end();
        }

        public boolean handleNamedGraphUpdate(INamedGraphUpdate namedGraphUpdate) throws AnzoException {
            handler.handleNamedGraph(namedGraphUpdate.getNamedGraphURI(), namedGraphUpdate.getUUID(), namedGraphUpdate.getRevision());
            for (Statement stmt : namedGraphUpdate.getRemovals()) {
                handler.handleStatement(false, false, stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), stmt.getNamedGraphUri());
            }
            for (Statement stmt : namedGraphUpdate.getMetaRemovals()) {
                handler.handleStatement(true, false, stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), stmt.getNamedGraphUri());
            }
            for (Statement stmt : namedGraphUpdate.getAdditions()) {
                handler.handleStatement(false, true, stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), stmt.getNamedGraphUri());
            }
            for (Statement stmt : namedGraphUpdate.getMetaAdditions()) {
                handler.handleStatement(true, true, stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), stmt.getNamedGraphUri());
            }
            return true;
        }
    }
}
